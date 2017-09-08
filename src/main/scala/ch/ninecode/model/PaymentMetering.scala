package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Credit/debit movements for an account.
 *
 * @param sup Reference to the superclass object.
 * @param amount Amount that was credited to/debited from an account.
 *        For example: payment received/interest charge on arrears.
 * @param dateTime Date and time when the credit/debit transaction was performed.
 * @param reason Reason for credit/debit transaction on an account.
 *        Example: payment received/arrears interest levied.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class AccountMovement
(
    override val sup: BasicElement,
    amount: Double,
    dateTime: String,
    reason: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AccountMovement] }
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
        "\t\t<cim:AccountMovement.amount>" + amount + "</cim:AccountMovement.amount>\n" +
        (if (null != dateTime) "\t\t<cim:AccountMovement.dateTime>" + dateTime + "</cim:AccountMovement.dateTime>\n" else "") +
        (if (null != reason) "\t\t<cim:AccountMovement.reason>" + reason + "</cim:AccountMovement.reason>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccountMovement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccountMovement>"
    }
}

object AccountMovement
extends
    Parseable[AccountMovement]
{
    val amount = parse_element (element ("""AccountMovement.amount"""))
    val dateTime = parse_element (element ("""AccountMovement.dateTime"""))
    val reason = parse_element (element ("""AccountMovement.reason"""))
    def parse (context: Context): AccountMovement =
    {
        AccountMovement(
            BasicElement.parse (context),
            toDouble (amount (context), context),
            dateTime (context),
            reason (context)
        )
    }
}

/**
 * Unit for accounting; use either 'energyUnit' or 'currencyUnit' to specify the unit for 'value'.
 *
 * @param sup Reference to the superclass object.
 * @param energyUnit Unit of service.
 * @param monetaryUnit Unit of currency.
 * @param multiplier Multiplier for the 'energyUnit' or 'monetaryUnit'.
 * @param value Value expressed in applicable units.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class AccountingUnit
(
    override val sup: BasicElement,
    energyUnit: Double,
    monetaryUnit: String,
    multiplier: String,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AccountingUnit] }
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
        "\t\t<cim:AccountingUnit.energyUnit>" + energyUnit + "</cim:AccountingUnit.energyUnit>\n" +
        (if (null != monetaryUnit) "\t\t<cim:AccountingUnit.monetaryUnit rdf:resource=\"#" + monetaryUnit + "\"/>\n" else "") +
        (if (null != multiplier) "\t\t<cim:AccountingUnit.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        "\t\t<cim:AccountingUnit.value>" + value + "</cim:AccountingUnit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:AccountingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccountingUnit>"
    }
}

object AccountingUnit
extends
    Parseable[AccountingUnit]
{
    val energyUnit = parse_element (element ("""AccountingUnit.energyUnit"""))
    val monetaryUnit = parse_attribute (attribute ("""AccountingUnit.monetaryUnit"""))
    val multiplier = parse_attribute (attribute ("""AccountingUnit.multiplier"""))
    val value = parse_element (element ("""AccountingUnit.value"""))
    def parse (context: Context): AccountingUnit =
    {
        AccountingUnit(
            BasicElement.parse (context),
            toDouble (energyUnit (context), context),
            monetaryUnit (context),
            multiplier (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Variable and dynamic part of auxiliary agreement, generally representing the current state of the account related to the outstanding balance defined in auxiliary agreement.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param balance The total amount currently remaining on this account that is required to be paid in order to settle the account to zero.
 *        This excludes any due amounts not yet paid.
 * @param due Current amounts now due for payment on this account.
 * @param lastCredit Details of the last credit transaction performed on this account.
 * @param lastDebit Details of the last debit transaction performed on this account.
 * @param principleAmount The initial principle amount, with which this account was instantiated.
 * @param AuxiliaryAgreement [[ch.ninecode.model.AuxiliaryAgreement AuxiliaryAgreement]] Auxiliary agreement regulating this account.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges levied on this account.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class AuxiliaryAccount
(
    override val sup: Document,
    balance: Double,
    due: String,
    lastCredit: String,
    lastDebit: String,
    principleAmount: Double,
    AuxiliaryAgreement: String,
    Charges: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, 0.0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryAccount] }
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
        "\t\t<cim:AuxiliaryAccount.balance>" + balance + "</cim:AuxiliaryAccount.balance>\n" +
        (if (null != due) "\t\t<cim:AuxiliaryAccount.due rdf:resource=\"#" + due + "\"/>\n" else "") +
        (if (null != lastCredit) "\t\t<cim:AuxiliaryAccount.lastCredit rdf:resource=\"#" + lastCredit + "\"/>\n" else "") +
        (if (null != lastDebit) "\t\t<cim:AuxiliaryAccount.lastDebit rdf:resource=\"#" + lastDebit + "\"/>\n" else "") +
        "\t\t<cim:AuxiliaryAccount.principleAmount>" + principleAmount + "</cim:AuxiliaryAccount.principleAmount>\n" +
        (if (null != AuxiliaryAgreement) "\t\t<cim:AuxiliaryAccount.AuxiliaryAgreement rdf:resource=\"#" + AuxiliaryAgreement + "\"/>\n" else "") +
        (if (null != Charges) Charges.map (x => "\t\t<cim:AuxiliaryAccount.Charges rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryAccount>"
    }
}

object AuxiliaryAccount
extends
    Parseable[AuxiliaryAccount]
{
    val balance = parse_element (element ("""AuxiliaryAccount.balance"""))
    val due = parse_attribute (attribute ("""AuxiliaryAccount.due"""))
    val lastCredit = parse_attribute (attribute ("""AuxiliaryAccount.lastCredit"""))
    val lastDebit = parse_attribute (attribute ("""AuxiliaryAccount.lastDebit"""))
    val principleAmount = parse_element (element ("""AuxiliaryAccount.principleAmount"""))
    val AuxiliaryAgreement = parse_attribute (attribute ("""AuxiliaryAccount.AuxiliaryAgreement"""))
    val Charges = parse_attributes (attribute ("""AuxiliaryAccount.Charges"""))
    def parse (context: Context): AuxiliaryAccount =
    {
        AuxiliaryAccount(
            Document.parse (context),
            toDouble (balance (context), context),
            due (context),
            lastCredit (context),
            lastDebit (context),
            toDouble (principleAmount (context), context),
            AuxiliaryAgreement (context),
            Charges (context)
        )
    }
}

/**
 * An ad-hoc auxiliary account agreement associated with a customer agreement, not part of the customer's account, but typically subject to formal agreement between customer and supplier (utility).
 *
 * Typically this is used to collect revenue owed by the customer for other services or arrears accrued with the utility for other services. It is typically linked to a prepaid token purchase transaction, thus forcing the customer to make a payment towards settlement of the auxiliary account balance whenever the customer needs to purchase a prepaid token for electricity.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param arrearsInterest The interest per annum to be charged prorata on 'AuxiliaryAccount.dueArrears' at the end of each 'payCycle'.
 * @param auxCycle The frequency for automatically recurring auxiliary charges, where 'AuxiliaryAccount.initialCharge' is recursively added to 'AuxiliaryAccount.dueCurrent' at the start of each 'auxCycle'.
 *        For example: on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc.
 * @param auxPriorityCode The coded priority indicating the priority that this auxiliary agreement has above other auxiliary agreements (associated with the same customer agreement) when it comes to competing for settlement from a payment transaction or token purchase.
 * @param fixedAmount The fixed amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param minAmount The minimum amount that has to be paid at any transaction towards settling this auxiliary agreement or reducing the balance.
 * @param payCycle The contractually expected payment frequency (by the customer).
 *        Examples are: ad-hoc; on specified date; hourly, daily, weekly, monthly. etc.
 * @param subType Sub-classification of the inherited 'type' for this AuxiliaryAgreement.
 * @param vendPortion The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are not in arrears.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param vendPortionArrear The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are in arrears.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param CustomerAgreement [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] Customer agreement this (non-service related) auxiliary agreement refers to.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class AuxiliaryAgreement
(
    override val sup: Agreement,
    arrearsInterest: Double,
    auxCycle: String,
    auxPriorityCode: String,
    fixedAmount: Double,
    minAmount: Double,
    payCycle: String,
    subType: String,
    vendPortion: Double,
    vendPortionArrear: Double,
    CustomerAgreement: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, null, null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[AuxiliaryAgreement] }
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
        "\t\t<cim:AuxiliaryAgreement.arrearsInterest>" + arrearsInterest + "</cim:AuxiliaryAgreement.arrearsInterest>\n" +
        (if (null != auxCycle) "\t\t<cim:AuxiliaryAgreement.auxCycle>" + auxCycle + "</cim:AuxiliaryAgreement.auxCycle>\n" else "") +
        (if (null != auxPriorityCode) "\t\t<cim:AuxiliaryAgreement.auxPriorityCode>" + auxPriorityCode + "</cim:AuxiliaryAgreement.auxPriorityCode>\n" else "") +
        "\t\t<cim:AuxiliaryAgreement.fixedAmount>" + fixedAmount + "</cim:AuxiliaryAgreement.fixedAmount>\n" +
        "\t\t<cim:AuxiliaryAgreement.minAmount>" + minAmount + "</cim:AuxiliaryAgreement.minAmount>\n" +
        (if (null != payCycle) "\t\t<cim:AuxiliaryAgreement.payCycle>" + payCycle + "</cim:AuxiliaryAgreement.payCycle>\n" else "") +
        (if (null != subType) "\t\t<cim:AuxiliaryAgreement.subType>" + subType + "</cim:AuxiliaryAgreement.subType>\n" else "") +
        "\t\t<cim:AuxiliaryAgreement.vendPortion>" + vendPortion + "</cim:AuxiliaryAgreement.vendPortion>\n" +
        "\t\t<cim:AuxiliaryAgreement.vendPortionArrear>" + vendPortionArrear + "</cim:AuxiliaryAgreement.vendPortionArrear>\n" +
        (if (null != CustomerAgreement) "\t\t<cim:AuxiliaryAgreement.CustomerAgreement rdf:resource=\"#" + CustomerAgreement + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AuxiliaryAgreement>"
    }
}

object AuxiliaryAgreement
extends
    Parseable[AuxiliaryAgreement]
{
    val arrearsInterest = parse_element (element ("""AuxiliaryAgreement.arrearsInterest"""))
    val auxCycle = parse_element (element ("""AuxiliaryAgreement.auxCycle"""))
    val auxPriorityCode = parse_element (element ("""AuxiliaryAgreement.auxPriorityCode"""))
    val fixedAmount = parse_element (element ("""AuxiliaryAgreement.fixedAmount"""))
    val minAmount = parse_element (element ("""AuxiliaryAgreement.minAmount"""))
    val payCycle = parse_element (element ("""AuxiliaryAgreement.payCycle"""))
    val subType = parse_element (element ("""AuxiliaryAgreement.subType"""))
    val vendPortion = parse_element (element ("""AuxiliaryAgreement.vendPortion"""))
    val vendPortionArrear = parse_element (element ("""AuxiliaryAgreement.vendPortionArrear"""))
    val CustomerAgreement = parse_attribute (attribute ("""AuxiliaryAgreement.CustomerAgreement"""))
    def parse (context: Context): AuxiliaryAgreement =
    {
        AuxiliaryAgreement(
            Agreement.parse (context),
            toDouble (arrearsInterest (context), context),
            auxCycle (context),
            auxPriorityCode (context),
            toDouble (fixedAmount (context), context),
            toDouble (minAmount (context), context),
            payCycle (context),
            subType (context),
            toDouble (vendPortion (context), context),
            toDouble (vendPortionArrear (context), context),
            CustomerAgreement (context)
        )
    }
}

/**
 * Details of a bank account.
 *
 * @param sup Reference to the superclass object.
 * @param accountNumber Operational account reference number.
 * @param bankName Name of bank where account is held.
 * @param branchCode Branch of bank where account is held.
 * @param holderID National identity number (or equivalent) of account holder.
 * @param holderName Name of account holder.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class BankAccountDetail
(
    override val sup: BasicElement,
    accountNumber: String,
    bankName: String,
    branchCode: String,
    holderID: String,
    holderName: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BankAccountDetail] }
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
        (if (null != accountNumber) "\t\t<cim:BankAccountDetail.accountNumber>" + accountNumber + "</cim:BankAccountDetail.accountNumber>\n" else "") +
        (if (null != bankName) "\t\t<cim:BankAccountDetail.bankName>" + bankName + "</cim:BankAccountDetail.bankName>\n" else "") +
        (if (null != branchCode) "\t\t<cim:BankAccountDetail.branchCode>" + branchCode + "</cim:BankAccountDetail.branchCode>\n" else "") +
        (if (null != holderID) "\t\t<cim:BankAccountDetail.holderID>" + holderID + "</cim:BankAccountDetail.holderID>\n" else "") +
        (if (null != holderName) "\t\t<cim:BankAccountDetail.holderName>" + holderName + "</cim:BankAccountDetail.holderName>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BankAccountDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BankAccountDetail>"
    }
}

object BankAccountDetail
extends
    Parseable[BankAccountDetail]
{
    val accountNumber = parse_element (element ("""BankAccountDetail.accountNumber"""))
    val bankName = parse_element (element ("""BankAccountDetail.bankName"""))
    val branchCode = parse_element (element ("""BankAccountDetail.branchCode"""))
    val holderID = parse_element (element ("""BankAccountDetail.holderID"""))
    val holderName = parse_element (element ("""BankAccountDetail.holderName"""))
    def parse (context: Context): BankAccountDetail =
    {
        BankAccountDetail(
            BasicElement.parse (context),
            accountNumber (context),
            bankName (context),
            branchCode (context),
            holderID (context),
            holderName (context)
        )
    }
}

/**
 * Documentation of the tender when it is a type of card (credit, debit, etc).
 *
 * @param sup Reference to the superclass object.
 * @param accountHolderName Name of account holder.
 * @param cvNumber The card verification number.
 * @param expiryDate The date when this card expires.
 * @param pan The primary account number.
 * @param Tender [[ch.ninecode.model.Tender Tender]] Payment tender this card is being used for.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Card
(
    override val sup: BasicElement,
    accountHolderName: String,
    cvNumber: String,
    expiryDate: String,
    pan: String,
    Tender: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Card] }
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
        (if (null != accountHolderName) "\t\t<cim:Card.accountHolderName>" + accountHolderName + "</cim:Card.accountHolderName>\n" else "") +
        (if (null != cvNumber) "\t\t<cim:Card.cvNumber>" + cvNumber + "</cim:Card.cvNumber>\n" else "") +
        (if (null != expiryDate) "\t\t<cim:Card.expiryDate>" + expiryDate + "</cim:Card.expiryDate>\n" else "") +
        (if (null != pan) "\t\t<cim:Card.pan>" + pan + "</cim:Card.pan>\n" else "") +
        (if (null != Tender) "\t\t<cim:Card.Tender rdf:resource=\"#" + Tender + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Card rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Card>"
    }
}

object Card
extends
    Parseable[Card]
{
    val accountHolderName = parse_element (element ("""Card.accountHolderName"""))
    val cvNumber = parse_element (element ("""Card.cvNumber"""))
    val expiryDate = parse_element (element ("""Card.expiryDate"""))
    val pan = parse_element (element ("""Card.pan"""))
    val Tender = parse_attribute (attribute ("""Card.Tender"""))
    def parse (context: Context): Card =
    {
        Card(
            BasicElement.parse (context),
            accountHolderName (context),
            cvNumber (context),
            expiryDate (context),
            pan (context),
            Tender (context)
        )
    }
}

/**
 * The operator of the point of sale for the duration of CashierShift.
 *
 * Cashier is under the exclusive management control of Vendor.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress Electronic address.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Cashier
(
    override val sup: IdentifiedObject,
    electronicAddress: String
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
    override def copy (): Row = { clone ().asInstanceOf[Cashier] }
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
        (if (null != electronicAddress) "\t\t<cim:Cashier.electronicAddress rdf:resource=\"#" + electronicAddress + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Cashier rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Cashier>"
    }
}

object Cashier
extends
    Parseable[Cashier]
{
    val electronicAddress = parse_attribute (attribute ("""Cashier.electronicAddress"""))
    def parse (context: Context): Cashier =
    {
        Cashier(
            IdentifiedObject.parse (context),
            electronicAddress (context)
        )
    }
}

/**
 * The operating shift for a cashier, during which the cashier may transact against the cashier shift, subject to vendor shift being open.
 *
 * @param sup [[ch.ninecode.model.Shift Shift]] Reference to the superclass object.
 * @param cashFloat The amount of cash that the cashier brings to start the shift and that will be taken away at the end of the shift; i.e. the cash float does not get banked.
 * @param Cashier [[ch.ninecode.model.Cashier Cashier]] Cashier operating this shift.
 * @param PointOfSale [[ch.ninecode.model.PointOfSale PointOfSale]] Point of sale that is in operation during this shift.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class CashierShift
(
    override val sup: Shift,
    cashFloat: Double,
    Cashier: String,
    PointOfSale: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Shift: Shift = sup.asInstanceOf[Shift]
    override def copy (): Row = { clone ().asInstanceOf[CashierShift] }
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
        "\t\t<cim:CashierShift.cashFloat>" + cashFloat + "</cim:CashierShift.cashFloat>\n" +
        (if (null != Cashier) "\t\t<cim:CashierShift.Cashier rdf:resource=\"#" + Cashier + "\"/>\n" else "") +
        (if (null != PointOfSale) "\t\t<cim:CashierShift.PointOfSale rdf:resource=\"#" + PointOfSale + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CashierShift rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CashierShift>"
    }
}

object CashierShift
extends
    Parseable[CashierShift]
{
    val cashFloat = parse_element (element ("""CashierShift.cashFloat"""))
    val Cashier = parse_attribute (attribute ("""CashierShift.Cashier"""))
    val PointOfSale = parse_attribute (attribute ("""CashierShift.PointOfSale"""))
    def parse (context: Context): CashierShift =
    {
        CashierShift(
            Shift.parse (context),
            toDouble (cashFloat (context), context),
            Cashier (context),
            PointOfSale (context)
        )
    }
}

/**
 * A charge element associated with other entities such as tariff structures, auxiliary agreements or other charge elements.
 *
 * The total charge amount applicable to this instance of charge is the sum of fixed and variable portion.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fixedPortion The fixed portion of this charge element.
 * @param kind The kind of charge to be applied.
 * @param variablePortion The variable portion of this charge element, calculated as a percentage of the total amount of a parent charge.
 * @param ParentCharge [[ch.ninecode.model.Charge Charge]] Parent of this charge sub-component.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Charge
(
    override val sup: IdentifiedObject,
    fixedPortion: String,
    kind: String,
    variablePortion: Double,
    ParentCharge: String
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
    override def copy (): Row = { clone ().asInstanceOf[Charge] }
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
        (if (null != fixedPortion) "\t\t<cim:Charge.fixedPortion rdf:resource=\"#" + fixedPortion + "\"/>\n" else "") +
        (if (null != kind) "\t\t<cim:Charge.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:Charge.variablePortion>" + variablePortion + "</cim:Charge.variablePortion>\n" +
        (if (null != ParentCharge) "\t\t<cim:Charge.ParentCharge rdf:resource=\"#" + ParentCharge + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Charge rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Charge>"
    }
}

object Charge
extends
    Parseable[Charge]
{
    val fixedPortion = parse_attribute (attribute ("""Charge.fixedPortion"""))
    val kind = parse_attribute (attribute ("""Charge.kind"""))
    val variablePortion = parse_element (element ("""Charge.variablePortion"""))
    val ParentCharge = parse_attribute (attribute ("""Charge.ParentCharge"""))
    def parse (context: Context): Charge =
    {
        Charge(
            IdentifiedObject.parse (context),
            fixedPortion (context),
            kind (context),
            toDouble (variablePortion (context), context),
            ParentCharge (context)
        )
    }
}

/**
 * The actual tender when it is a type of cheque.
 *
 * @param sup Reference to the superclass object.
 * @param bankAccountDetail Details of the account holder and bank.
 * @param chequeNumber Cheque reference number as printed on the cheque.
 * @param date Date when cheque becomes valid.
 * @param kind Kind of cheque.
 * @param micrNumber The magnetic ink character recognition number printed on the cheque.
 * @param Tender [[ch.ninecode.model.Tender Tender]] Payment tender the cheque is being used for.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Cheque
(
    override val sup: BasicElement,
    bankAccountDetail: String,
    chequeNumber: String,
    date: String,
    kind: String,
    micrNumber: String,
    Tender: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Cheque] }
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
        (if (null != bankAccountDetail) "\t\t<cim:Cheque.bankAccountDetail rdf:resource=\"#" + bankAccountDetail + "\"/>\n" else "") +
        (if (null != chequeNumber) "\t\t<cim:Cheque.chequeNumber>" + chequeNumber + "</cim:Cheque.chequeNumber>\n" else "") +
        (if (null != date) "\t\t<cim:Cheque.date>" + date + "</cim:Cheque.date>\n" else "") +
        (if (null != kind) "\t\t<cim:Cheque.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != micrNumber) "\t\t<cim:Cheque.micrNumber>" + micrNumber + "</cim:Cheque.micrNumber>\n" else "") +
        (if (null != Tender) "\t\t<cim:Cheque.Tender rdf:resource=\"#" + Tender + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Cheque rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Cheque>"
    }
}

object Cheque
extends
    Parseable[Cheque]
{
    val bankAccountDetail = parse_attribute (attribute ("""Cheque.bankAccountDetail"""))
    val chequeNumber = parse_element (element ("""Cheque.chequeNumber"""))
    val date = parse_element (element ("""Cheque.date"""))
    val kind = parse_attribute (attribute ("""Cheque.kind"""))
    val micrNumber = parse_element (element ("""Cheque.micrNumber"""))
    val Tender = parse_attribute (attribute ("""Cheque.Tender"""))
    def parse (context: Context): Cheque =
    {
        Cheque(
            BasicElement.parse (context),
            bankAccountDetail (context),
            chequeNumber (context),
            date (context),
            kind (context),
            micrNumber (context),
            Tender (context)
        )
    }
}

/**
 * One of a sequence of intervals defined in terms of consumption quantity of a service such as electricity, water, gas, etc.
 *
 * It is typically used in association with TariffProfile to define the steps or blocks in a step tariff structure, where startValue simultaneously defines the entry value of this step and the closing value of the previous step. Where consumption is &gt;= startValue it falls within this interval and where consumption is &lt; startValue it falls within the previous interval.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startValue The lowest level of consumption that defines the starting point of this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges used to define this consumption tariff interval.
 * @param TouTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] All time of use tariff intervals influenced by this consumption tariff interval.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class ConsumptionTariffInterval
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    startValue: Double,
    Charges: List[String],
    TouTariffIntervals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ConsumptionTariffInterval] }
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
        "\t\t<cim:ConsumptionTariffInterval.sequenceNumber>" + sequenceNumber + "</cim:ConsumptionTariffInterval.sequenceNumber>\n" +
        "\t\t<cim:ConsumptionTariffInterval.startValue>" + startValue + "</cim:ConsumptionTariffInterval.startValue>\n" +
        (if (null != Charges) Charges.map (x => "\t\t<cim:ConsumptionTariffInterval.Charges rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TouTariffIntervals) TouTariffIntervals.map (x => "\t\t<cim:ConsumptionTariffInterval.TouTariffIntervals rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ConsumptionTariffInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConsumptionTariffInterval>"
    }
}

object ConsumptionTariffInterval
extends
    Parseable[ConsumptionTariffInterval]
{
    val sequenceNumber = parse_element (element ("""ConsumptionTariffInterval.sequenceNumber"""))
    val startValue = parse_element (element ("""ConsumptionTariffInterval.startValue"""))
    val Charges = parse_attributes (attribute ("""ConsumptionTariffInterval.Charges"""))
    val TouTariffIntervals = parse_attributes (attribute ("""ConsumptionTariffInterval.TouTariffIntervals"""))
    def parse (context: Context): ConsumptionTariffInterval =
    {
        ConsumptionTariffInterval(
            BasicElement.parse (context),
            toInteger (sequenceNumber (context), context),
            toDouble (startValue (context), context),
            Charges (context),
            TouTariffIntervals (context)
        )
    }
}

/**
 * Details on amounts due for an account.
 *
 * @param sup Reference to the superclass object.
 * @param arrears Part of 'current' that constitutes the arrears portion.
 * @param charges Part of 'current' that constitutes the charge portion: 'charges' = 'Charge.fixedPortion' + 'Charge.variablePortion'.
 * @param current Current total amount now due: current = principle + arrears + interest + charges.
 *        Typically the rule for settlement priority is: interest dues, then arrears dues, then current dues, then charge dues.
 * @param interest Part of 'current' that constitutes the interest portion.
 * @param principle Part of 'current' that constitutes the portion of the principle amount currently due.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Due
(
    override val sup: BasicElement,
    arrears: Double,
    charges: Double,
    current: Double,
    interest: Double,
    principle: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Due] }
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
        "\t\t<cim:Due.arrears>" + arrears + "</cim:Due.arrears>\n" +
        "\t\t<cim:Due.charges>" + charges + "</cim:Due.charges>\n" +
        "\t\t<cim:Due.current>" + current + "</cim:Due.current>\n" +
        "\t\t<cim:Due.interest>" + interest + "</cim:Due.interest>\n" +
        "\t\t<cim:Due.principle>" + principle + "</cim:Due.principle>\n"
    }
    override def export: String =
    {
        "\t<cim:Due rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Due>"
    }
}

object Due
extends
    Parseable[Due]
{
    val arrears = parse_element (element ("""Due.arrears"""))
    val charges = parse_element (element ("""Due.charges"""))
    val current = parse_element (element ("""Due.current"""))
    val interest = parse_element (element ("""Due.interest"""))
    val principle = parse_element (element ("""Due.principle"""))
    def parse (context: Context): Due =
    {
        Due(
            BasicElement.parse (context),
            toDouble (arrears (context), context),
            toDouble (charges (context), context),
            toDouble (current (context), context),
            toDouble (interest (context), context),
            toDouble (principle (context), context)
        )
    }
}

/**
 * Details on an amount line, with rounding, date and note.
 *
 * @param sup Reference to the superclass object.
 * @param amount Amount for this line item.
 * @param dateTime Date and time when this line was created in the application process.
 * @param note Free format note relevant to this line.
 * @param rounding Totalised monetary value of all errors due to process rounding or truncating that is not reflected in 'amount'.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class LineDetail
(
    override val sup: BasicElement,
    amount: Double,
    dateTime: String,
    note: String,
    rounding: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LineDetail] }
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
        "\t\t<cim:LineDetail.amount>" + amount + "</cim:LineDetail.amount>\n" +
        (if (null != dateTime) "\t\t<cim:LineDetail.dateTime>" + dateTime + "</cim:LineDetail.dateTime>\n" else "") +
        (if (null != note) "\t\t<cim:LineDetail.note>" + note + "</cim:LineDetail.note>\n" else "") +
        "\t\t<cim:LineDetail.rounding>" + rounding + "</cim:LineDetail.rounding>\n"
    }
    override def export: String =
    {
        "\t<cim:LineDetail rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LineDetail>"
    }
}

object LineDetail
extends
    Parseable[LineDetail]
{
    val amount = parse_element (element ("""LineDetail.amount"""))
    val dateTime = parse_element (element ("""LineDetail.dateTime"""))
    val note = parse_element (element ("""LineDetail.note"""))
    val rounding = parse_element (element ("""LineDetail.rounding"""))
    def parse (context: Context): LineDetail =
    {
        LineDetail(
            BasicElement.parse (context),
            toDouble (amount (context), context),
            dateTime (context),
            note (context),
            toDouble (rounding (context), context)
        )
    }
}

/**
 * The operating account controlled by merchant agreement, against which the vendor may vend tokens or receipt payments.
 *
 * Transactions via vendor shift debit the account and bank deposits via bank statement credit the account.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param currentBalance The current operating balance of this account.
 * @param provisionalBalance The balance of this account after taking into account any pending debits from VendorShift.merchantDebitAmount and pending credits from BankStatement.merchantCreditAmount or credits (see also BankStatement attributes and VendorShift attributes).
 * @param MerchantAgreement [[ch.ninecode.model.MerchantAgreement MerchantAgreement]] Merchant agreement that instantiated this merchant account.
 * @param Transactors [[ch.ninecode.model.Transactor Transactor]] All transactors this merchant account is registered with.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class MerchantAccount
(
    override val sup: Document,
    currentBalance: Double,
    provisionalBalance: Double,
    MerchantAgreement: String,
    Transactors: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MerchantAccount] }
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
        "\t\t<cim:MerchantAccount.currentBalance>" + currentBalance + "</cim:MerchantAccount.currentBalance>\n" +
        "\t\t<cim:MerchantAccount.provisionalBalance>" + provisionalBalance + "</cim:MerchantAccount.provisionalBalance>\n" +
        (if (null != MerchantAgreement) "\t\t<cim:MerchantAccount.MerchantAgreement rdf:resource=\"#" + MerchantAgreement + "\"/>\n" else "") +
        (if (null != Transactors) Transactors.map (x => "\t\t<cim:MerchantAccount.Transactors rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:MerchantAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MerchantAccount>"
    }
}

object MerchantAccount
extends
    Parseable[MerchantAccount]
{
    val currentBalance = parse_element (element ("""MerchantAccount.currentBalance"""))
    val provisionalBalance = parse_element (element ("""MerchantAccount.provisionalBalance"""))
    val MerchantAgreement = parse_attribute (attribute ("""MerchantAccount.MerchantAgreement"""))
    val Transactors = parse_attributes (attribute ("""MerchantAccount.Transactors"""))
    def parse (context: Context): MerchantAccount =
    {
        MerchantAccount(
            Document.parse (context),
            toDouble (currentBalance (context), context),
            toDouble (provisionalBalance (context), context),
            MerchantAgreement (context),
            Transactors (context)
        )
    }
}

/**
 * A formal controlling contractual agreement between supplier and merchant, in terms of which the merchant is authorised to vend tokens and receipt payments on behalf of the supplier.
 *
 * The merchant is accountable to the supplier for revenue collected at point of sale.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class MerchantAgreement
(
    override val sup: Agreement
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
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[MerchantAgreement] }
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
        "\t<cim:MerchantAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MerchantAgreement>"
    }
}

object MerchantAgreement
extends
    Parseable[MerchantAgreement]
{
    def parse (context: Context): MerchantAgreement =
    {
        MerchantAgreement(
            Agreement.parse (context)
        )
    }
}

/**
 * Logical point where transactions take place with operational interaction between cashier and the payment system; in certain cases the point of sale interacts directly with the end customer, in which case the cashier might not be a real person: for example a self-service kiosk or over the internet.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param location Local description for where this point of sale is physically located.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class PointOfSale
(
    override val sup: IdentifiedObject,
    location: String
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
    override def copy (): Row = { clone ().asInstanceOf[PointOfSale] }
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
        (if (null != location) "\t\t<cim:PointOfSale.location>" + location + "</cim:PointOfSale.location>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PointOfSale rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PointOfSale>"
    }
}

object PointOfSale
extends
    Parseable[PointOfSale]
{
    val location = parse_element (element ("""PointOfSale.location"""))
    def parse (context: Context): PointOfSale =
    {
        PointOfSale(
            IdentifiedObject.parse (context),
            location (context)
        )
    }
}

/**
 * Record of total receipted payment from customer.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isBankable True if this receipted payment is manually bankable, otherwise it is an electronic funds transfer.
 * @param line Receipted amount with rounding, date and note.
 * @param CashierShift [[ch.ninecode.model.CashierShift CashierShift]] Cashier shift during which this receipt was recorded.
 * @param VendorShift [[ch.ninecode.model.VendorShift VendorShift]] Vendor shift during which this receipt was recorded.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Receipt
(
    override val sup: IdentifiedObject,
    isBankable: Boolean,
    line: String,
    CashierShift: String,
    VendorShift: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Receipt] }
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
        "\t\t<cim:Receipt.isBankable>" + isBankable + "</cim:Receipt.isBankable>\n" +
        (if (null != line) "\t\t<cim:Receipt.line rdf:resource=\"#" + line + "\"/>\n" else "") +
        (if (null != CashierShift) "\t\t<cim:Receipt.CashierShift rdf:resource=\"#" + CashierShift + "\"/>\n" else "") +
        (if (null != VendorShift) "\t\t<cim:Receipt.VendorShift rdf:resource=\"#" + VendorShift + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Receipt rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Receipt>"
    }
}

object Receipt
extends
    Parseable[Receipt]
{
    val isBankable = parse_element (element ("""Receipt.isBankable"""))
    val line = parse_attribute (attribute ("""Receipt.line"""))
    val CashierShift = parse_attribute (attribute ("""Receipt.CashierShift"""))
    val VendorShift = parse_attribute (attribute ("""Receipt.VendorShift"""))
    def parse (context: Context): Receipt =
    {
        Receipt(
            IdentifiedObject.parse (context),
            toBoolean (isBankable (context), context),
            line (context),
            CashierShift (context),
            VendorShift (context)
        )
    }
}

/**
 * Organisation that provides services to customers.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param issuerIdentificationNumber Unique transaction reference prefix number issued to an entity by the International Organization for Standardization for the purpose of tagging onto electronic financial transactions, as defined in ISO/IEC 7812-1 and ISO/IEC 7812-2.
 * @param kind Kind of supplier.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class ServiceSupplier
(
    override val sup: OrganisationRole,
    issuerIdentificationNumber: String,
    kind: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[ServiceSupplier] }
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
        (if (null != issuerIdentificationNumber) "\t\t<cim:ServiceSupplier.issuerIdentificationNumber>" + issuerIdentificationNumber + "</cim:ServiceSupplier.issuerIdentificationNumber>\n" else "") +
        (if (null != kind) "\t\t<cim:ServiceSupplier.kind rdf:resource=\"#" + kind + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceSupplier rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceSupplier>"
    }
}

object ServiceSupplier
extends
    Parseable[ServiceSupplier]
{
    val issuerIdentificationNumber = parse_element (element ("""ServiceSupplier.issuerIdentificationNumber"""))
    val kind = parse_attribute (attribute ("""ServiceSupplier.kind"""))
    def parse (context: Context): ServiceSupplier =
    {
        ServiceSupplier(
            OrganisationRole.parse (context),
            issuerIdentificationNumber (context),
            kind (context)
        )
    }
}

/**
 * Generally referring to a period of operation or work performed.
 *
 * Whether the shift is open/closed can be derived from attributes 'activityInterval.start' and 'activityInterval.end'.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param activityInterval Interval for activity of this shift.
 * @param receiptsGrandTotalBankable Total of amounts receipted during this shift that can be manually banked (cash and cheques for example).
 *        Values are obtained from Receipt attributes:
 * @param receiptsGrandTotalNonBankable Total of amounts receipted during this shift that cannot be manually banked (card payments for example).
 *        Values are obtained from Receipt attributes:
 * @param receiptsGrandTotalRounding Cumulative amount in error due to process rounding not reflected in receiptsGrandTotal.
 *        Values are obtained from Receipt attributes:
 * @param transactionsGrandTotal Cumulative total of transacted amounts during this shift.
 *        Values are obtained from transaction:
 * @param transactionsGrandTotalRounding Cumulative amount in error due to process rounding not reflected in transactionsGandTotal.
 *        Values are obtained from Transaction attributes:
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Shift
(
    override val sup: IdentifiedObject,
    activityInterval: String,
    receiptsGrandTotalBankable: Double,
    receiptsGrandTotalNonBankable: Double,
    receiptsGrandTotalRounding: Double,
    transactionsGrandTotal: Double,
    transactionsGrandTotalRounding: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Shift] }
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
        (if (null != activityInterval) "\t\t<cim:Shift.activityInterval rdf:resource=\"#" + activityInterval + "\"/>\n" else "") +
        "\t\t<cim:Shift.receiptsGrandTotalBankable>" + receiptsGrandTotalBankable + "</cim:Shift.receiptsGrandTotalBankable>\n" +
        "\t\t<cim:Shift.receiptsGrandTotalNonBankable>" + receiptsGrandTotalNonBankable + "</cim:Shift.receiptsGrandTotalNonBankable>\n" +
        "\t\t<cim:Shift.receiptsGrandTotalRounding>" + receiptsGrandTotalRounding + "</cim:Shift.receiptsGrandTotalRounding>\n" +
        "\t\t<cim:Shift.transactionsGrandTotal>" + transactionsGrandTotal + "</cim:Shift.transactionsGrandTotal>\n" +
        "\t\t<cim:Shift.transactionsGrandTotalRounding>" + transactionsGrandTotalRounding + "</cim:Shift.transactionsGrandTotalRounding>\n"
    }
    override def export: String =
    {
        "\t<cim:Shift rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Shift>"
    }
}

object Shift
extends
    Parseable[Shift]
{
    val activityInterval = parse_attribute (attribute ("""Shift.activityInterval"""))
    val receiptsGrandTotalBankable = parse_element (element ("""Shift.receiptsGrandTotalBankable"""))
    val receiptsGrandTotalNonBankable = parse_element (element ("""Shift.receiptsGrandTotalNonBankable"""))
    val receiptsGrandTotalRounding = parse_element (element ("""Shift.receiptsGrandTotalRounding"""))
    val transactionsGrandTotal = parse_element (element ("""Shift.transactionsGrandTotal"""))
    val transactionsGrandTotalRounding = parse_element (element ("""Shift.transactionsGrandTotalRounding"""))
    def parse (context: Context): Shift =
    {
        Shift(
            IdentifiedObject.parse (context),
            activityInterval (context),
            toDouble (receiptsGrandTotalBankable (context), context),
            toDouble (receiptsGrandTotalNonBankable (context), context),
            toDouble (receiptsGrandTotalRounding (context), context),
            toDouble (transactionsGrandTotal (context), context),
            toDouble (transactionsGrandTotalRounding (context), context)
        )
    }
}

/**
 * A schedule of charges; structure associated with Tariff that allows the definition of complex tarif structures such as step and time of use when used in conjunction with TimeTariffInterval and Charge.
 *
 * Inherited 'status.value' is defined in the context of the utility's business rules, for example: active, inactive, etc.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param tariffCycle The frequency at which the tariff charge schedule is repeated.
 *        Examples are: once off on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc. At the end of each cycle, the business rules are reset to start from the beginning again.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] All consumption tariff intervals used to define this tariff profile.
 * @param TimeTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] All time tariff intervals used to define this tariff profile.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class TariffProfile
(
    override val sup: Document,
    tariffCycle: String,
    ConsumptionTariffIntervals: List[String],
    TimeTariffIntervals: List[String]
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[TariffProfile] }
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
        (if (null != tariffCycle) "\t\t<cim:TariffProfile.tariffCycle>" + tariffCycle + "</cim:TariffProfile.tariffCycle>\n" else "") +
        (if (null != ConsumptionTariffIntervals) ConsumptionTariffIntervals.map (x => "\t\t<cim:TariffProfile.ConsumptionTariffIntervals rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TimeTariffIntervals) TimeTariffIntervals.map (x => "\t\t<cim:TariffProfile.TimeTariffIntervals rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:TariffProfile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TariffProfile>"
    }
}

object TariffProfile
extends
    Parseable[TariffProfile]
{
    val tariffCycle = parse_element (element ("""TariffProfile.tariffCycle"""))
    val ConsumptionTariffIntervals = parse_attributes (attribute ("""TariffProfile.ConsumptionTariffIntervals"""))
    val TimeTariffIntervals = parse_attributes (attribute ("""TariffProfile.TimeTariffIntervals"""))
    def parse (context: Context): TariffProfile =
    {
        TariffProfile(
            Document.parse (context),
            tariffCycle (context),
            ConsumptionTariffIntervals (context),
            TimeTariffIntervals (context)
        )
    }
}

/**
 * Tender is what is "offered" by the customer towards making a payment and is often more than the required payment (hence the need for 'change').
 *
 * The payment is thus that part of the Tender that goes towards settlement of a particular transaction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param amount Amount tendered by customer.
 * @param change Difference between amount tendered by customer and the amount charged by point of sale.
 * @param kind Kind of tender from customer.
 * @param Card [[ch.ninecode.model.Card Card]] Card used to tender payment.
 * @param Cheque [[ch.ninecode.model.Cheque Cheque]] Cheque used to tender payment.
 * @param Receipt [[ch.ninecode.model.Receipt Receipt]] Receipt that recorded this receiving of a payment in the form of tenders.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Tender
(
    override val sup: IdentifiedObject,
    amount: Double,
    change: Double,
    kind: String,
    Card: String,
    Cheque: String,
    Receipt: String
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
    override def copy (): Row = { clone ().asInstanceOf[Tender] }
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
        "\t\t<cim:Tender.amount>" + amount + "</cim:Tender.amount>\n" +
        "\t\t<cim:Tender.change>" + change + "</cim:Tender.change>\n" +
        (if (null != kind) "\t\t<cim:Tender.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Card) "\t\t<cim:Tender.Card rdf:resource=\"#" + Card + "\"/>\n" else "") +
        (if (null != Cheque) "\t\t<cim:Tender.Cheque rdf:resource=\"#" + Cheque + "\"/>\n" else "") +
        (if (null != Receipt) "\t\t<cim:Tender.Receipt rdf:resource=\"#" + Receipt + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Tender rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Tender>"
    }
}

object Tender
extends
    Parseable[Tender]
{
    val amount = parse_element (element ("""Tender.amount"""))
    val change = parse_element (element ("""Tender.change"""))
    val kind = parse_attribute (attribute ("""Tender.kind"""))
    val Card = parse_attribute (attribute ("""Tender.Card"""))
    val Cheque = parse_attribute (attribute ("""Tender.Cheque"""))
    val Receipt = parse_attribute (attribute ("""Tender.Receipt"""))
    def parse (context: Context): Tender =
    {
        Tender(
            IdentifiedObject.parse (context),
            toDouble (amount (context), context),
            toDouble (change (context), context),
            kind (context),
            Card (context),
            Cheque (context),
            Receipt (context)
        )
    }
}

/**
 * One of a sequence of time intervals defined in terms of real time.
 *
 * It is typically used in association with TariffProfile to define the intervals in a time of use tariff structure, where startDateTime simultaneously determines the starting point of this interval and the ending point of the previous interval.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startTime A real time marker that defines the starting time (typically it is the time of day) for this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges used to define this time tariff interval.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class TimeTariffInterval
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    startTime: String,
    Charges: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TimeTariffInterval] }
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
        "\t\t<cim:TimeTariffInterval.sequenceNumber>" + sequenceNumber + "</cim:TimeTariffInterval.sequenceNumber>\n" +
        (if (null != startTime) "\t\t<cim:TimeTariffInterval.startTime>" + startTime + "</cim:TimeTariffInterval.startTime>\n" else "") +
        (if (null != Charges) Charges.map (x => "\t\t<cim:TimeTariffInterval.Charges rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:TimeTariffInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeTariffInterval>"
    }
}

object TimeTariffInterval
extends
    Parseable[TimeTariffInterval]
{
    val sequenceNumber = parse_element (element ("""TimeTariffInterval.sequenceNumber"""))
    val startTime = parse_element (element ("""TimeTariffInterval.startTime"""))
    val Charges = parse_attributes (attribute ("""TimeTariffInterval.Charges"""))
    def parse (context: Context): TimeTariffInterval =
    {
        TimeTariffInterval(
            BasicElement.parse (context),
            toInteger (sequenceNumber (context), context),
            startTime (context),
            Charges (context)
        )
    }
}

/**
 * The record of details of payment for service or token sale.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param diverseReference Formal reference for use with diverse payment (traffic fine for example).
 * @param donorReference Reference to the entity that is the source of 'amount' (for example: customer for token purchase; or supplier for free issue token).
 * @param kind Kind of transaction.
 * @param line Transaction amount, rounding, date and note for this transaction line.
 * @param receiverReference Reference to the entity that is the recipient of 'amount' (for example, supplier for service charge payment; or tax receiver for VAT).
 * @param reversedId (if 'kind' is transactionReversal) Reference to the original transaction that is being reversed by this transaction.
 * @param serviceUnitsEnergy Actual amount of service units that is being paid for.
 * @param serviceUnitsError Number of service units not reflected in 'serviceUnitsEnergy' due to process rounding or truncating errors.
 * @param AuxiliaryAccount [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] Auxiliary account for this payment transaction.
 * @param CashierShift [[ch.ninecode.model.CashierShift CashierShift]] Cashier shift during which this transaction was recorded.
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] Customer account for this payment transaction.
 * @param Meter [[ch.ninecode.model.Meter Meter]] Meter for this vending transaction.
 * @param PricingStructure [[ch.ninecode.model.PricingStructure PricingStructure]] Pricing structure applicable for this transaction.
 * @param Receipt [[ch.ninecode.model.Receipt Receipt]] The receipted payment for which this transaction has been recorded.
 * @param VendorShift [[ch.ninecode.model.VendorShift VendorShift]] Vendor shift during which this transaction was recorded.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Transaction
(
    override val sup: IdentifiedObject,
    diverseReference: String,
    donorReference: String,
    kind: String,
    line: String,
    receiverReference: String,
    reversedId: String,
    serviceUnitsEnergy: Double,
    serviceUnitsError: Double,
    AuxiliaryAccount: String,
    CashierShift: String,
    CustomerAccount: String,
    Meter: String,
    PricingStructure: String,
    Receipt: String,
    VendorShift: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, 0.0, 0.0, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Transaction] }
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
        (if (null != diverseReference) "\t\t<cim:Transaction.diverseReference>" + diverseReference + "</cim:Transaction.diverseReference>\n" else "") +
        (if (null != donorReference) "\t\t<cim:Transaction.donorReference>" + donorReference + "</cim:Transaction.donorReference>\n" else "") +
        (if (null != kind) "\t\t<cim:Transaction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != line) "\t\t<cim:Transaction.line rdf:resource=\"#" + line + "\"/>\n" else "") +
        (if (null != receiverReference) "\t\t<cim:Transaction.receiverReference>" + receiverReference + "</cim:Transaction.receiverReference>\n" else "") +
        (if (null != reversedId) "\t\t<cim:Transaction.reversedId>" + reversedId + "</cim:Transaction.reversedId>\n" else "") +
        "\t\t<cim:Transaction.serviceUnitsEnergy>" + serviceUnitsEnergy + "</cim:Transaction.serviceUnitsEnergy>\n" +
        "\t\t<cim:Transaction.serviceUnitsError>" + serviceUnitsError + "</cim:Transaction.serviceUnitsError>\n" +
        (if (null != AuxiliaryAccount) "\t\t<cim:Transaction.AuxiliaryAccount rdf:resource=\"#" + AuxiliaryAccount + "\"/>\n" else "") +
        (if (null != CashierShift) "\t\t<cim:Transaction.CashierShift rdf:resource=\"#" + CashierShift + "\"/>\n" else "") +
        (if (null != CustomerAccount) "\t\t<cim:Transaction.CustomerAccount rdf:resource=\"#" + CustomerAccount + "\"/>\n" else "") +
        (if (null != Meter) "\t\t<cim:Transaction.Meter rdf:resource=\"#" + Meter + "\"/>\n" else "") +
        (if (null != PricingStructure) "\t\t<cim:Transaction.PricingStructure rdf:resource=\"#" + PricingStructure + "\"/>\n" else "") +
        (if (null != Receipt) "\t\t<cim:Transaction.Receipt rdf:resource=\"#" + Receipt + "\"/>\n" else "") +
        (if (null != VendorShift) "\t\t<cim:Transaction.VendorShift rdf:resource=\"#" + VendorShift + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Transaction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Transaction>"
    }
}

object Transaction
extends
    Parseable[Transaction]
{
    val diverseReference = parse_element (element ("""Transaction.diverseReference"""))
    val donorReference = parse_element (element ("""Transaction.donorReference"""))
    val kind = parse_attribute (attribute ("""Transaction.kind"""))
    val line = parse_attribute (attribute ("""Transaction.line"""))
    val receiverReference = parse_element (element ("""Transaction.receiverReference"""))
    val reversedId = parse_element (element ("""Transaction.reversedId"""))
    val serviceUnitsEnergy = parse_element (element ("""Transaction.serviceUnitsEnergy"""))
    val serviceUnitsError = parse_element (element ("""Transaction.serviceUnitsError"""))
    val AuxiliaryAccount = parse_attribute (attribute ("""Transaction.AuxiliaryAccount"""))
    val CashierShift = parse_attribute (attribute ("""Transaction.CashierShift"""))
    val CustomerAccount = parse_attribute (attribute ("""Transaction.CustomerAccount"""))
    val Meter = parse_attribute (attribute ("""Transaction.Meter"""))
    val PricingStructure = parse_attribute (attribute ("""Transaction.PricingStructure"""))
    val Receipt = parse_attribute (attribute ("""Transaction.Receipt"""))
    val VendorShift = parse_attribute (attribute ("""Transaction.VendorShift"""))
    def parse (context: Context): Transaction =
    {
        Transaction(
            IdentifiedObject.parse (context),
            diverseReference (context),
            donorReference (context),
            kind (context),
            line (context),
            receiverReference (context),
            reversedId (context),
            toDouble (serviceUnitsEnergy (context), context),
            toDouble (serviceUnitsError (context), context),
            AuxiliaryAccount (context),
            CashierShift (context),
            CustomerAccount (context),
            Meter (context),
            PricingStructure (context),
            Receipt (context),
            VendorShift (context)
        )
    }
}

/**
 * The entity that ultimately executes the transaction and which is in control of the process; typically this is embodied in secure software running on a server that may employ secure hardware encryption devices for secure transaction processing.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Transactor
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Transactor] }
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
        "\t<cim:Transactor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Transactor>"
    }
}

object Transactor
extends
    Parseable[Transactor]
{
    def parse (context: Context): Transactor =
    {
        Transactor(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * The entity that owns the point of sale and contracts with the cashier to receipt payments and vend tokens using the payment system.
 *
 * The vendor has a private contract with and is managed by the merchant which is a type of organisation. The vendor is accountable to the merchant for revenue collected, and the merchant is in turn accountable to the supplier.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Vendor
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Vendor] }
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
        "\t<cim:Vendor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Vendor>"
    }
}

object Vendor
extends
    Parseable[Vendor]
{
    def parse (context: Context): Vendor =
    {
        Vendor(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * The operating shift for a vendor during which the vendor may transact against the merchant's account.
 *
 * It aggregates transactions and receipts during the shift and periodically debits a merchant account. The totals in vendor shift should always be the sum of totals aggregated in all cashier shifts that were open under the particular vendor shift.
 *
 * @param sup [[ch.ninecode.model.Shift Shift]] Reference to the superclass object.
 * @param merchantDebitAmount The amount that is to be debited from the merchant account for this vendor shift.
 *        This amount reflects the sum(PaymentTransaction.transactionAmount).
 * @param posted If true, merchantDebitAmount has been debited from MerchantAccount; typically happens at the end of VendorShift when it closes.
 * @param MerchantAccount [[ch.ninecode.model.MerchantAccount MerchantAccount]] Merchant account this vendor shift periodically debits (based on aggregated transactions).
 * @param Vendor [[ch.ninecode.model.Vendor Vendor]] Vendor that opens and owns this vendor shift.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class VendorShift
(
    override val sup: Shift,
    merchantDebitAmount: Double,
    posted: Boolean,
    MerchantAccount: String,
    Vendor: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Shift: Shift = sup.asInstanceOf[Shift]
    override def copy (): Row = { clone ().asInstanceOf[VendorShift] }
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
        "\t\t<cim:VendorShift.merchantDebitAmount>" + merchantDebitAmount + "</cim:VendorShift.merchantDebitAmount>\n" +
        "\t\t<cim:VendorShift.posted>" + posted + "</cim:VendorShift.posted>\n" +
        (if (null != MerchantAccount) "\t\t<cim:VendorShift.MerchantAccount rdf:resource=\"#" + MerchantAccount + "\"/>\n" else "") +
        (if (null != Vendor) "\t\t<cim:VendorShift.Vendor rdf:resource=\"#" + Vendor + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VendorShift rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VendorShift>"
    }
}

object VendorShift
extends
    Parseable[VendorShift]
{
    val merchantDebitAmount = parse_element (element ("""VendorShift.merchantDebitAmount"""))
    val posted = parse_element (element ("""VendorShift.posted"""))
    val MerchantAccount = parse_attribute (attribute ("""VendorShift.MerchantAccount"""))
    val Vendor = parse_attribute (attribute ("""VendorShift.Vendor"""))
    def parse (context: Context): VendorShift =
    {
        VendorShift(
            Shift.parse (context),
            toDouble (merchantDebitAmount (context), context),
            toBoolean (posted (context), context),
            MerchantAccount (context),
            Vendor (context)
        )
    }
}

private[ninecode] object _PaymentMetering
{
    def register: List[ClassInfo] =
    {
        List (
            AccountMovement.register,
            AccountingUnit.register,
            AuxiliaryAccount.register,
            AuxiliaryAgreement.register,
            BankAccountDetail.register,
            Card.register,
            Cashier.register,
            CashierShift.register,
            Charge.register,
            Cheque.register,
            ConsumptionTariffInterval.register,
            Due.register,
            LineDetail.register,
            MerchantAccount.register,
            MerchantAgreement.register,
            PointOfSale.register,
            Receipt.register,
            ServiceSupplier.register,
            Shift.register,
            TariffProfile.register,
            Tender.register,
            TimeTariffInterval.register,
            Transaction.register,
            Transactor.register,
            Vendor.register,
            VendorShift.register
        )
    }
}