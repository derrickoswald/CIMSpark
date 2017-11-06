package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AccountMovement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccountMovement.fields (position), value)
        emitelem (0, amount)
        emitelem (1, dateTime)
        emitelem (2, reason)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccountMovement rdf:ID=\"%s\">\n%s\t</cim:AccountMovement>".format (id, export_fields)
    }
}

object AccountMovement
extends
    Parseable[AccountMovement]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "dateTime",
        "reason"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val dateTime: Fielder = parse_element (element (cls, fields(1)))
    val reason: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): AccountMovement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccountMovement (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (dateTime (), 1),
            mask (reason (), 2)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AccountingUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccountingUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccountingUnit.fields (position), value)
        emitelem (0, energyUnit)
        emitattr (1, monetaryUnit)
        emitattr (2, multiplier)
        emitelem (3, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccountingUnit rdf:ID=\"%s\">\n%s\t</cim:AccountingUnit>".format (id, export_fields)
    }
}

object AccountingUnit
extends
    Parseable[AccountingUnit]
{
    override val fields: Array[String] = Array[String] (
        "energyUnit",
        "monetaryUnit",
        "multiplier",
        "value"
    )
    val energyUnit: Fielder = parse_element (element (cls, fields(0)))
    val monetaryUnit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): AccountingUnit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccountingUnit (
            BasicElement.parse (context),
            toDouble (mask (energyUnit (), 0)),
            mask (monetaryUnit (), 1),
            mask (multiplier (), 2),
            toDouble (mask (value (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Variable and dynamic part of auxiliary agreement, generally representing the current state of the account related to the outstanding balance defined in auxiliary agreement.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param balance The total amount currently remaining on this account that is required to be paid in order to settle the account to zero.
 *        This excludes any due amounts not yet paid.
 * @param due [[ch.ninecode.model.Due Due]] Current amounts now due for payment on this account.
 * @param lastCredit [[ch.ninecode.model.AccountMovement AccountMovement]] Details of the last credit transaction performed on this account.
 * @param lastDebit [[ch.ninecode.model.AccountMovement AccountMovement]] Details of the last debit transaction performed on this account.
 * @param principleAmount The initial principle amount, with which this account was instantiated.
 * @param AuxiliaryAgreement [[ch.ninecode.model.AuxiliaryAgreement AuxiliaryAgreement]] Auxiliary agreement regulating this account.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges levied on this account.
 * @param PaymentTransactions [[ch.ninecode.model.Transaction Transaction]] All payments against this account.
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
    Charges: List[String],
    PaymentTransactions: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, 0.0, null, List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AuxiliaryAccount.fields (position), x))
        emitelem (0, balance)
        emitattr (1, due)
        emitattr (2, lastCredit)
        emitattr (3, lastDebit)
        emitelem (4, principleAmount)
        emitattr (5, AuxiliaryAgreement)
        emitattrs (6, Charges)
        emitattrs (7, PaymentTransactions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAccount rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryAccount>".format (id, export_fields)
    }
}

object AuxiliaryAccount
extends
    Parseable[AuxiliaryAccount]
{
    override val fields: Array[String] = Array[String] (
        "balance",
        "due",
        "lastCredit",
        "lastDebit",
        "principleAmount",
        "AuxiliaryAgreement",
        "Charges",
        "PaymentTransactions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("due", "Due", "0..1", "0..*"),
        Relationship ("lastCredit", "AccountMovement", "0..1", "0..*"),
        Relationship ("lastDebit", "AccountMovement", "0..1", "0..*"),
        Relationship ("AuxiliaryAgreement", "AuxiliaryAgreement", "0..1", "1..*"),
        Relationship ("Charges", "Charge", "0..*", "0..*"),
        Relationship ("PaymentTransactions", "Transaction", "0..*", "0..1")
    )
    val balance: Fielder = parse_element (element (cls, fields(0)))
    val due: Fielder = parse_attribute (attribute (cls, fields(1)))
    val lastCredit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastDebit: Fielder = parse_attribute (attribute (cls, fields(3)))
    val principleAmount: Fielder = parse_element (element (cls, fields(4)))
    val AuxiliaryAgreement: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val PaymentTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): AuxiliaryAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryAccount (
            Document.parse (context),
            toDouble (mask (balance (), 0)),
            mask (due (), 1),
            mask (lastCredit (), 2),
            mask (lastDebit (), 3),
            toDouble (mask (principleAmount (), 4)),
            mask (AuxiliaryAgreement (), 5),
            masks (Charges (), 6),
            masks (PaymentTransactions (), 7)
        )
        ret.bitfields = bitfields
        ret
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
 * @param AuxiliaryAccounts [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] All auxiliary accounts regulated by this agreement.
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
    AuxiliaryAccounts: List[String],
    CustomerAgreement: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, null, null, 0.0, 0.0, List(), null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryAgreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryAgreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryAgreement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AuxiliaryAgreement.fields (position), x))
        emitelem (0, arrearsInterest)
        emitelem (1, auxCycle)
        emitelem (2, auxPriorityCode)
        emitelem (3, fixedAmount)
        emitelem (4, minAmount)
        emitelem (5, payCycle)
        emitelem (6, subType)
        emitelem (7, vendPortion)
        emitelem (8, vendPortionArrear)
        emitattrs (9, AuxiliaryAccounts)
        emitattr (10, CustomerAgreement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAgreement rdf:ID=\"%s\">\n%s\t</cim:AuxiliaryAgreement>".format (id, export_fields)
    }
}

object AuxiliaryAgreement
extends
    Parseable[AuxiliaryAgreement]
{
    override val fields: Array[String] = Array[String] (
        "arrearsInterest",
        "auxCycle",
        "auxPriorityCode",
        "fixedAmount",
        "minAmount",
        "payCycle",
        "subType",
        "vendPortion",
        "vendPortionArrear",
        "AuxiliaryAccounts",
        "CustomerAgreement"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AuxiliaryAccounts", "AuxiliaryAccount", "1..*", "0..1"),
        Relationship ("CustomerAgreement", "CustomerAgreement", "0..1", "0..*")
    )
    val arrearsInterest: Fielder = parse_element (element (cls, fields(0)))
    val auxCycle: Fielder = parse_element (element (cls, fields(1)))
    val auxPriorityCode: Fielder = parse_element (element (cls, fields(2)))
    val fixedAmount: Fielder = parse_element (element (cls, fields(3)))
    val minAmount: Fielder = parse_element (element (cls, fields(4)))
    val payCycle: Fielder = parse_element (element (cls, fields(5)))
    val subType: Fielder = parse_element (element (cls, fields(6)))
    val vendPortion: Fielder = parse_element (element (cls, fields(7)))
    val vendPortionArrear: Fielder = parse_element (element (cls, fields(8)))
    val AuxiliaryAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val CustomerAgreement: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): AuxiliaryAgreement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryAgreement (
            Agreement.parse (context),
            toDouble (mask (arrearsInterest (), 0)),
            mask (auxCycle (), 1),
            mask (auxPriorityCode (), 2),
            toDouble (mask (fixedAmount (), 3)),
            toDouble (mask (minAmount (), 4)),
            mask (payCycle (), 5),
            mask (subType (), 6),
            toDouble (mask (vendPortion (), 7)),
            toDouble (mask (vendPortionArrear (), 8)),
            masks (AuxiliaryAccounts (), 9),
            mask (CustomerAgreement (), 10)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BankAccountDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BankAccountDetail.fields (position), value)
        emitelem (0, accountNumber)
        emitelem (1, bankName)
        emitelem (2, branchCode)
        emitelem (3, holderID)
        emitelem (4, holderName)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BankAccountDetail rdf:ID=\"%s\">\n%s\t</cim:BankAccountDetail>".format (id, export_fields)
    }
}

object BankAccountDetail
extends
    Parseable[BankAccountDetail]
{
    override val fields: Array[String] = Array[String] (
        "accountNumber",
        "bankName",
        "branchCode",
        "holderID",
        "holderName"
    )
    val accountNumber: Fielder = parse_element (element (cls, fields(0)))
    val bankName: Fielder = parse_element (element (cls, fields(1)))
    val branchCode: Fielder = parse_element (element (cls, fields(2)))
    val holderID: Fielder = parse_element (element (cls, fields(3)))
    val holderName: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): BankAccountDetail =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BankAccountDetail (
            BasicElement.parse (context),
            mask (accountNumber (), 0),
            mask (bankName (), 1),
            mask (branchCode (), 2),
            mask (holderID (), 3),
            mask (holderName (), 4)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Card.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Card.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Card.fields (position), value)
        emitelem (0, accountHolderName)
        emitelem (1, cvNumber)
        emitelem (2, expiryDate)
        emitelem (3, pan)
        emitattr (4, Tender)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Card rdf:ID=\"%s\">\n%s\t</cim:Card>".format (id, export_fields)
    }
}

object Card
extends
    Parseable[Card]
{
    override val fields: Array[String] = Array[String] (
        "accountHolderName",
        "cvNumber",
        "expiryDate",
        "pan",
        "Tender"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Tender", "Tender", "1", "0..1")
    )
    val accountHolderName: Fielder = parse_element (element (cls, fields(0)))
    val cvNumber: Fielder = parse_element (element (cls, fields(1)))
    val expiryDate: Fielder = parse_element (element (cls, fields(2)))
    val pan: Fielder = parse_element (element (cls, fields(3)))
    val Tender: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): Card =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Card (
            BasicElement.parse (context),
            mask (accountHolderName (), 0),
            mask (cvNumber (), 1),
            mask (expiryDate (), 2),
            mask (pan (), 3),
            mask (Tender (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The operator of the point of sale for the duration of CashierShift.
 *
 * Cashier is under the exclusive management control of Vendor.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress Electronic address.
 * @param CashierShifts [[ch.ninecode.model.CashierShift CashierShift]] All shifts operated by this cashier.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Cashier
(
    override val sup: IdentifiedObject,
    electronicAddress: String,
    CashierShifts: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Cashier.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Cashier.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Cashier.fields (position), x))
        emitattr (0, electronicAddress)
        emitattrs (1, CashierShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cashier rdf:ID=\"%s\">\n%s\t</cim:Cashier>".format (id, export_fields)
    }
}

object Cashier
extends
    Parseable[Cashier]
{
    override val fields: Array[String] = Array[String] (
        "electronicAddress",
        "CashierShifts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CashierShifts", "CashierShift", "0..*", "0..1")
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CashierShifts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Cashier =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Cashier (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            masks (CashierShifts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The operating shift for a cashier, during which the cashier may transact against the cashier shift, subject to vendor shift being open.
 *
 * @param sup [[ch.ninecode.model.Shift Shift]] Reference to the superclass object.
 * @param cashFloat The amount of cash that the cashier brings to start the shift and that will be taken away at the end of the shift; i.e. the cash float does not get banked.
 * @param Cashier [[ch.ninecode.model.Cashier Cashier]] Cashier operating this shift.
 * @param PointOfSale [[ch.ninecode.model.PointOfSale PointOfSale]] Point of sale that is in operation during this shift.
 * @param Receipts [[ch.ninecode.model.Receipt Receipt]] All Receipts recorded for this Shift.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded during this cashier shift.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class CashierShift
(
    override val sup: Shift,
    cashFloat: Double,
    Cashier: String,
    PointOfSale: String,
    Receipts: List[String],
    Transactions: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CashierShift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CashierShift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CashierShift.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (CashierShift.fields (position), x))
        emitelem (0, cashFloat)
        emitattr (1, Cashier)
        emitattr (2, PointOfSale)
        emitattrs (3, Receipts)
        emitattrs (4, Transactions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CashierShift rdf:ID=\"%s\">\n%s\t</cim:CashierShift>".format (id, export_fields)
    }
}

object CashierShift
extends
    Parseable[CashierShift]
{
    override val fields: Array[String] = Array[String] (
        "cashFloat",
        "Cashier",
        "PointOfSale",
        "Receipts",
        "Transactions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Cashier", "Cashier", "0..1", "0..*"),
        Relationship ("PointOfSale", "PointOfSale", "0..1", "0..*"),
        Relationship ("Receipts", "Receipt", "0..*", "0..1"),
        Relationship ("Transactions", "Transaction", "0..*", "0..1")
    )
    val cashFloat: Fielder = parse_element (element (cls, fields(0)))
    val Cashier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PointOfSale: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Receipts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): CashierShift =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CashierShift (
            Shift.parse (context),
            toDouble (mask (cashFloat (), 0)),
            mask (Cashier (), 1),
            mask (PointOfSale (), 2),
            masks (Receipts (), 3),
            masks (Transactions (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A charge element associated with other entities such as tariff structures, auxiliary agreements or other charge elements.
 *
 * The total charge amount applicable to this instance of charge is the sum of fixed and variable portion.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fixedPortion [[ch.ninecode.model.AccountingUnit AccountingUnit]] The fixed portion of this charge element.
 * @param kind The kind of charge to be applied.
 * @param variablePortion The variable portion of this charge element, calculated as a percentage of the total amount of a parent charge.
 * @param AuxiliaryAccounts [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] All auxiliary accounts to which this charge has to be levied.
 * @param ChildCharges [[ch.ninecode.model.Charge Charge]] All sub-components of this complex charge.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] Tariff intervals to which this consumption-based charge has to be levied.
 * @param ParentCharge [[ch.ninecode.model.Charge Charge]] Parent of this charge sub-component.
 * @param TimeTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] Tariff intervals to which this time-based charge has to be levied.
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
    AuxiliaryAccounts: List[String],
    ChildCharges: List[String],
    ConsumptionTariffIntervals: List[String],
    ParentCharge: String,
    TimeTariffIntervals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, List(), List(), List(), null, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Charge.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Charge.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Charge.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Charge.fields (position), x))
        emitattr (0, fixedPortion)
        emitattr (1, kind)
        emitelem (2, variablePortion)
        emitattrs (3, AuxiliaryAccounts)
        emitattrs (4, ChildCharges)
        emitattrs (5, ConsumptionTariffIntervals)
        emitattr (6, ParentCharge)
        emitattrs (7, TimeTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Charge rdf:ID=\"%s\">\n%s\t</cim:Charge>".format (id, export_fields)
    }
}

object Charge
extends
    Parseable[Charge]
{
    override val fields: Array[String] = Array[String] (
        "fixedPortion",
        "kind",
        "variablePortion",
        "AuxiliaryAccounts",
        "ChildCharges",
        "ConsumptionTariffIntervals",
        "ParentCharge",
        "TimeTariffIntervals"
    )
    override val relations: List[Relationship] = List (
        Relationship ("fixedPortion", "AccountingUnit", "0..1", "0..*"),
        Relationship ("AuxiliaryAccounts", "AuxiliaryAccount", "0..*", "0..*"),
        Relationship ("ChildCharges", "Charge", "0..*", "0..1"),
        Relationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        Relationship ("ParentCharge", "Charge", "0..1", "0..*"),
        Relationship ("TimeTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val fixedPortion: Fielder = parse_attribute (attribute (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val variablePortion: Fielder = parse_element (element (cls, fields(2)))
    val AuxiliaryAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ChildCharges: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ParentCharge: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TimeTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): Charge =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Charge (
            IdentifiedObject.parse (context),
            mask (fixedPortion (), 0),
            mask (kind (), 1),
            toDouble (mask (variablePortion (), 2)),
            masks (AuxiliaryAccounts (), 3),
            masks (ChildCharges (), 4),
            masks (ConsumptionTariffIntervals (), 5),
            mask (ParentCharge (), 6),
            masks (TimeTariffIntervals (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The actual tender when it is a type of cheque.
 *
 * @param sup Reference to the superclass object.
 * @param bankAccountDetail [[ch.ninecode.model.BankAccountDetail BankAccountDetail]] Details of the account holder and bank.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Cheque.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Cheque.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Cheque.fields (position), value)
        emitattr (0, bankAccountDetail)
        emitelem (1, chequeNumber)
        emitelem (2, date)
        emitattr (3, kind)
        emitelem (4, micrNumber)
        emitattr (5, Tender)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cheque rdf:ID=\"%s\">\n%s\t</cim:Cheque>".format (id, export_fields)
    }
}

object Cheque
extends
    Parseable[Cheque]
{
    override val fields: Array[String] = Array[String] (
        "bankAccountDetail",
        "chequeNumber",
        "date",
        "kind",
        "micrNumber",
        "Tender"
    )
    override val relations: List[Relationship] = List (
        Relationship ("bankAccountDetail", "BankAccountDetail", "0..1", "0..*"),
        Relationship ("Tender", "Tender", "1", "0..1")
    )
    val bankAccountDetail: Fielder = parse_attribute (attribute (cls, fields(0)))
    val chequeNumber: Fielder = parse_element (element (cls, fields(1)))
    val date: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val micrNumber: Fielder = parse_element (element (cls, fields(4)))
    val Tender: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Cheque =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Cheque (
            BasicElement.parse (context),
            mask (bankAccountDetail (), 0),
            mask (chequeNumber (), 1),
            mask (date (), 2),
            mask (kind (), 3),
            mask (micrNumber (), 4),
            mask (Tender (), 5)
        )
        ret.bitfields = bitfields
        ret
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
 * @param TariffProfiles [[ch.ninecode.model.TariffProfile TariffProfile]] All tariff profiles defined by this consumption tariff interval.
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
    TariffProfiles: List[String],
    TouTariffIntervals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConsumptionTariffInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConsumptionTariffInterval.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ConsumptionTariffInterval.fields (position), x))
        emitelem (0, sequenceNumber)
        emitelem (1, startValue)
        emitattrs (2, Charges)
        emitattrs (3, TariffProfiles)
        emitattrs (4, TouTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConsumptionTariffInterval rdf:ID=\"%s\">\n%s\t</cim:ConsumptionTariffInterval>".format (id, export_fields)
    }
}

object ConsumptionTariffInterval
extends
    Parseable[ConsumptionTariffInterval]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "startValue",
        "Charges",
        "TariffProfiles",
        "TouTariffIntervals"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Charges", "Charge", "0..*", "0..*"),
        Relationship ("TariffProfiles", "TariffProfile", "0..*", "0..*"),
        Relationship ("TouTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val startValue: Fielder = parse_element (element (cls, fields(1)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TouTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ConsumptionTariffInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConsumptionTariffInterval (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (startValue (), 1)),
            masks (Charges (), 2),
            masks (TariffProfiles (), 3),
            masks (TouTariffIntervals (), 4)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Due.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Due.fields (position), value)
        emitelem (0, arrears)
        emitelem (1, charges)
        emitelem (2, current)
        emitelem (3, interest)
        emitelem (4, principle)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Due rdf:ID=\"%s\">\n%s\t</cim:Due>".format (id, export_fields)
    }
}

object Due
extends
    Parseable[Due]
{
    override val fields: Array[String] = Array[String] (
        "arrears",
        "charges",
        "current",
        "interest",
        "principle"
    )
    val arrears: Fielder = parse_element (element (cls, fields(0)))
    val charges: Fielder = parse_element (element (cls, fields(1)))
    val current: Fielder = parse_element (element (cls, fields(2)))
    val interest: Fielder = parse_element (element (cls, fields(3)))
    val principle: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): Due =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Due (
            BasicElement.parse (context),
            toDouble (mask (arrears (), 0)),
            toDouble (mask (charges (), 1)),
            toDouble (mask (current (), 2)),
            toDouble (mask (interest (), 3)),
            toDouble (mask (principle (), 4))
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LineDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LineDetail.fields (position), value)
        emitelem (0, amount)
        emitelem (1, dateTime)
        emitelem (2, note)
        emitelem (3, rounding)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LineDetail rdf:ID=\"%s\">\n%s\t</cim:LineDetail>".format (id, export_fields)
    }
}

object LineDetail
extends
    Parseable[LineDetail]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "dateTime",
        "note",
        "rounding"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val dateTime: Fielder = parse_element (element (cls, fields(1)))
    val note: Fielder = parse_element (element (cls, fields(2)))
    val rounding: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): LineDetail =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LineDetail (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (dateTime (), 1),
            mask (note (), 2),
            toDouble (mask (rounding (), 3))
        )
        ret.bitfields = bitfields
        ret
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
 * @param VendorShifts [[ch.ninecode.model.VendorShift VendorShift]] All vendor shifts that operate on this merchant account.
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
    Transactors: List[String],
    VendorShifts: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MerchantAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MerchantAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MerchantAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MerchantAccount.fields (position), x))
        emitelem (0, currentBalance)
        emitelem (1, provisionalBalance)
        emitattr (2, MerchantAgreement)
        emitattrs (3, Transactors)
        emitattrs (4, VendorShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MerchantAccount rdf:ID=\"%s\">\n%s\t</cim:MerchantAccount>".format (id, export_fields)
    }
}

object MerchantAccount
extends
    Parseable[MerchantAccount]
{
    override val fields: Array[String] = Array[String] (
        "currentBalance",
        "provisionalBalance",
        "MerchantAgreement",
        "Transactors",
        "VendorShifts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MerchantAgreement", "MerchantAgreement", "0..1", "0..*"),
        Relationship ("Transactors", "Transactor", "0..*", "0..*"),
        Relationship ("VendorShifts", "VendorShift", "0..*", "0..1")
    )
    val currentBalance: Fielder = parse_element (element (cls, fields(0)))
    val provisionalBalance: Fielder = parse_element (element (cls, fields(1)))
    val MerchantAgreement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Transactors: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val VendorShifts: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): MerchantAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MerchantAccount (
            Document.parse (context),
            toDouble (mask (currentBalance (), 0)),
            toDouble (mask (provisionalBalance (), 1)),
            mask (MerchantAgreement (), 2),
            masks (Transactors (), 3),
            masks (VendorShifts (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A formal controlling contractual agreement between supplier and merchant, in terms of which the merchant is authorised to vend tokens and receipt payments on behalf of the supplier.
 *
 * The merchant is accountable to the supplier for revenue collected at point of sale.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param MerchantAccounts [[ch.ninecode.model.MerchantAccount MerchantAccount]] All merchant accounts instantiated as a result of this merchant agreement.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class MerchantAgreement
(
    override val sup: Agreement,
    MerchantAccounts: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MerchantAgreement.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MerchantAgreement.fields (position), x))
        emitattrs (0, MerchantAccounts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MerchantAgreement rdf:ID=\"%s\">\n%s\t</cim:MerchantAgreement>".format (id, export_fields)
    }
}

object MerchantAgreement
extends
    Parseable[MerchantAgreement]
{
    override val fields: Array[String] = Array[String] (
        "MerchantAccounts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MerchantAccounts", "MerchantAccount", "0..*", "0..1")
    )
    val MerchantAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MerchantAgreement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MerchantAgreement (
            Agreement.parse (context),
            masks (MerchantAccounts (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Logical point where transactions take place with operational interaction between cashier and the payment system; in certain cases the point of sale interacts directly with the end customer, in which case the cashier might not be a real person: for example a self-service kiosk or over the internet.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param location Local description for where this point of sale is physically located.
 * @param CashierShifts [[ch.ninecode.model.CashierShift CashierShift]] All shifts this point of sale operated in.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class PointOfSale
(
    override val sup: IdentifiedObject,
    location: String,
    CashierShifts: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PointOfSale.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PointOfSale.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (PointOfSale.fields (position), x))
        emitelem (0, location)
        emitattrs (1, CashierShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PointOfSale rdf:ID=\"%s\">\n%s\t</cim:PointOfSale>".format (id, export_fields)
    }
}

object PointOfSale
extends
    Parseable[PointOfSale]
{
    override val fields: Array[String] = Array[String] (
        "location",
        "CashierShifts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CashierShifts", "CashierShift", "0..*", "0..1")
    )
    val location: Fielder = parse_element (element (cls, fields(0)))
    val CashierShifts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PointOfSale =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PointOfSale (
            IdentifiedObject.parse (context),
            mask (location (), 0),
            masks (CashierShifts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Record of total receipted payment from customer.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isBankable True if this receipted payment is manually bankable, otherwise it is an electronic funds transfer.
 * @param line [[ch.ninecode.model.LineDetail LineDetail]] Receipted amount with rounding, date and note.
 * @param CashierShift [[ch.ninecode.model.CashierShift CashierShift]] Cashier shift during which this receipt was recorded.
 * @param Tenders [[ch.ninecode.model.Tender Tender]] All payments received in the form of tenders recorded by this receipt.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded for this receipted payment.
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
    Tenders: List[String],
    Transactions: List[String],
    VendorShift: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, List(), List(), null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Receipt.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Receipt.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Receipt.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Receipt.fields (position), x))
        emitelem (0, isBankable)
        emitattr (1, line)
        emitattr (2, CashierShift)
        emitattrs (3, Tenders)
        emitattrs (4, Transactions)
        emitattr (5, VendorShift)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Receipt rdf:ID=\"%s\">\n%s\t</cim:Receipt>".format (id, export_fields)
    }
}

object Receipt
extends
    Parseable[Receipt]
{
    override val fields: Array[String] = Array[String] (
        "isBankable",
        "line",
        "CashierShift",
        "Tenders",
        "Transactions",
        "VendorShift"
    )
    override val relations: List[Relationship] = List (
        Relationship ("line", "LineDetail", "0..1", "0..*"),
        Relationship ("CashierShift", "CashierShift", "0..1", "0..*"),
        Relationship ("Tenders", "Tender", "1..*", "1"),
        Relationship ("Transactions", "Transaction", "1..*", "0..1"),
        Relationship ("VendorShift", "VendorShift", "0..1", "0..*")
    )
    val isBankable: Fielder = parse_element (element (cls, fields(0)))
    val line: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CashierShift: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Tenders: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val VendorShift: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Receipt =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Receipt (
            IdentifiedObject.parse (context),
            toBoolean (mask (isBankable (), 0)),
            mask (line (), 1),
            mask (CashierShift (), 2),
            masks (Tenders (), 3),
            masks (Transactions (), 4),
            mask (VendorShift (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Organisation that provides services to customers.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param issuerIdentificationNumber Unique transaction reference prefix number issued to an entity by the International Organization for Standardization for the purpose of tagging onto electronic financial transactions, as defined in ISO/IEC 7812-1 and ISO/IEC 7812-2.
 * @param kind Kind of supplier.
 * @param BankAccounts [[ch.ninecode.model.BankAccount BankAccount]] All BackAccounts this ServiceSupplier owns.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements of this service supplier.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points this service supplier utilises to deliver a service.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class ServiceSupplier
(
    override val sup: OrganisationRole,
    issuerIdentificationNumber: String,
    kind: String,
    BankAccounts: List[String],
    CustomerAgreements: List[String],
    UsagePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceSupplier.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceSupplier.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceSupplier.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ServiceSupplier.fields (position), x))
        emitelem (0, issuerIdentificationNumber)
        emitattr (1, kind)
        emitattrs (2, BankAccounts)
        emitattrs (3, CustomerAgreements)
        emitattrs (4, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceSupplier rdf:ID=\"%s\">\n%s\t</cim:ServiceSupplier>".format (id, export_fields)
    }
}

object ServiceSupplier
extends
    Parseable[ServiceSupplier]
{
    override val fields: Array[String] = Array[String] (
        "issuerIdentificationNumber",
        "kind",
        "BankAccounts",
        "CustomerAgreements",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BankAccounts", "BankAccount", "0..*", "0..1"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val issuerIdentificationNumber: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val BankAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ServiceSupplier =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ServiceSupplier (
            OrganisationRole.parse (context),
            mask (issuerIdentificationNumber (), 0),
            mask (kind (), 1),
            masks (BankAccounts (), 2),
            masks (CustomerAgreements (), 3),
            masks (UsagePoints (), 4)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Shift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Shift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Shift.fields (position), value)
        emitattr (0, activityInterval)
        emitelem (1, receiptsGrandTotalBankable)
        emitelem (2, receiptsGrandTotalNonBankable)
        emitelem (3, receiptsGrandTotalRounding)
        emitelem (4, transactionsGrandTotal)
        emitelem (5, transactionsGrandTotalRounding)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Shift rdf:ID=\"%s\">\n%s\t</cim:Shift>".format (id, export_fields)
    }
}

object Shift
extends
    Parseable[Shift]
{
    override val fields: Array[String] = Array[String] (
        "activityInterval",
        "receiptsGrandTotalBankable",
        "receiptsGrandTotalNonBankable",
        "receiptsGrandTotalRounding",
        "transactionsGrandTotal",
        "transactionsGrandTotalRounding"
    )
    val activityInterval: Fielder = parse_attribute (attribute (cls, fields(0)))
    val receiptsGrandTotalBankable: Fielder = parse_element (element (cls, fields(1)))
    val receiptsGrandTotalNonBankable: Fielder = parse_element (element (cls, fields(2)))
    val receiptsGrandTotalRounding: Fielder = parse_element (element (cls, fields(3)))
    val transactionsGrandTotal: Fielder = parse_element (element (cls, fields(4)))
    val transactionsGrandTotalRounding: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): Shift =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Shift (
            IdentifiedObject.parse (context),
            mask (activityInterval (), 0),
            toDouble (mask (receiptsGrandTotalBankable (), 1)),
            toDouble (mask (receiptsGrandTotalNonBankable (), 2)),
            toDouble (mask (receiptsGrandTotalRounding (), 3)),
            toDouble (mask (transactionsGrandTotal (), 4)),
            toDouble (mask (transactionsGrandTotalRounding (), 5))
        )
        ret.bitfields = bitfields
        ret
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
 * @param Tariffs [[ch.ninecode.model.Tariff Tariff]] All tariffs defined by this tariff profile.
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
    Tariffs: List[String],
    TimeTariffIntervals: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TariffProfile.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TariffProfile.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TariffProfile.fields (position), x))
        emitelem (0, tariffCycle)
        emitattrs (1, ConsumptionTariffIntervals)
        emitattrs (2, Tariffs)
        emitattrs (3, TimeTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TariffProfile rdf:ID=\"%s\">\n%s\t</cim:TariffProfile>".format (id, export_fields)
    }
}

object TariffProfile
extends
    Parseable[TariffProfile]
{
    override val fields: Array[String] = Array[String] (
        "tariffCycle",
        "ConsumptionTariffIntervals",
        "Tariffs",
        "TimeTariffIntervals"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        Relationship ("Tariffs", "Tariff", "0..*", "0..*"),
        Relationship ("TimeTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val tariffCycle: Fielder = parse_element (element (cls, fields(0)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Tariffs: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TimeTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): TariffProfile =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TariffProfile (
            Document.parse (context),
            mask (tariffCycle (), 0),
            masks (ConsumptionTariffIntervals (), 1),
            masks (Tariffs (), 2),
            masks (TimeTariffIntervals (), 3)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tender.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tender.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Tender.fields (position), value)
        emitelem (0, amount)
        emitelem (1, change)
        emitattr (2, kind)
        emitattr (3, Card)
        emitattr (4, Cheque)
        emitattr (5, Receipt)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tender rdf:ID=\"%s\">\n%s\t</cim:Tender>".format (id, export_fields)
    }
}

object Tender
extends
    Parseable[Tender]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "change",
        "kind",
        "Card",
        "Cheque",
        "Receipt"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Card", "Card", "0..1", "1"),
        Relationship ("Cheque", "Cheque", "0..1", "1"),
        Relationship ("Receipt", "Receipt", "1", "1..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val change: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Card: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Cheque: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Receipt: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Tender =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Tender (
            IdentifiedObject.parse (context),
            toDouble (mask (amount (), 0)),
            toDouble (mask (change (), 1)),
            mask (kind (), 2),
            mask (Card (), 3),
            mask (Cheque (), 4),
            mask (Receipt (), 5)
        )
        ret.bitfields = bitfields
        ret
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
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] All consumption tariff intervals that introduce variation in this time of use tariff interval; allows to express e.g., peak hour prices that are different with different consumption blocks.
 * @param TariffProfiles [[ch.ninecode.model.TariffProfile TariffProfile]] All tariff profiles defined by this time tariff interval.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class TimeTariffInterval
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    startTime: String,
    Charges: List[String],
    ConsumptionTariffIntervals: List[String],
    TariffProfiles: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimeTariffInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeTariffInterval.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TimeTariffInterval.fields (position), x))
        emitelem (0, sequenceNumber)
        emitelem (1, startTime)
        emitattrs (2, Charges)
        emitattrs (3, ConsumptionTariffIntervals)
        emitattrs (4, TariffProfiles)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeTariffInterval rdf:ID=\"%s\">\n%s\t</cim:TimeTariffInterval>".format (id, export_fields)
    }
}

object TimeTariffInterval
extends
    Parseable[TimeTariffInterval]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "startTime",
        "Charges",
        "ConsumptionTariffIntervals",
        "TariffProfiles"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Charges", "Charge", "0..*", "0..*"),
        Relationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        Relationship ("TariffProfiles", "TariffProfile", "0..*", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val startTime: Fielder = parse_element (element (cls, fields(1)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): TimeTariffInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TimeTariffInterval (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (startTime (), 1),
            masks (Charges (), 2),
            masks (ConsumptionTariffIntervals (), 3),
            masks (TariffProfiles (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The record of details of payment for service or token sale.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param diverseReference Formal reference for use with diverse payment (traffic fine for example).
 * @param donorReference Reference to the entity that is the source of 'amount' (for example: customer for token purchase; or supplier for free issue token).
 * @param kind Kind of transaction.
 * @param line [[ch.ninecode.model.LineDetail LineDetail]] Transaction amount, rounding, date and note for this transaction line.
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
 * @param UserAttributes [[ch.ninecode.model.UserAttribute UserAttribute]] All snapshots of meter parameters recorded at the time of this transaction.
 *        Use 'name' and 'value.value' attributes to specify name and value of a parameter from meter.
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
    UserAttributes: List[String],
    VendorShift: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, 0.0, 0.0, null, null, null, null, null, null, List(), null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Transaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Transaction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Transaction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Transaction.fields (position), x))
        emitelem (0, diverseReference)
        emitelem (1, donorReference)
        emitattr (2, kind)
        emitattr (3, line)
        emitelem (4, receiverReference)
        emitelem (5, reversedId)
        emitelem (6, serviceUnitsEnergy)
        emitelem (7, serviceUnitsError)
        emitattr (8, AuxiliaryAccount)
        emitattr (9, CashierShift)
        emitattr (10, CustomerAccount)
        emitattr (11, Meter)
        emitattr (12, PricingStructure)
        emitattr (13, Receipt)
        emitattrs (14, UserAttributes)
        emitattr (15, VendorShift)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Transaction rdf:ID=\"%s\">\n%s\t</cim:Transaction>".format (id, export_fields)
    }
}

object Transaction
extends
    Parseable[Transaction]
{
    override val fields: Array[String] = Array[String] (
        "diverseReference",
        "donorReference",
        "kind",
        "line",
        "receiverReference",
        "reversedId",
        "serviceUnitsEnergy",
        "serviceUnitsError",
        "AuxiliaryAccount",
        "CashierShift",
        "CustomerAccount",
        "Meter",
        "PricingStructure",
        "Receipt",
        "UserAttributes",
        "VendorShift"
    )
    override val relations: List[Relationship] = List (
        Relationship ("line", "LineDetail", "0..1", "0..*"),
        Relationship ("AuxiliaryAccount", "AuxiliaryAccount", "0..1", "0..*"),
        Relationship ("CashierShift", "CashierShift", "0..1", "0..*"),
        Relationship ("CustomerAccount", "CustomerAccount", "0..1", "0..*"),
        Relationship ("Meter", "Meter", "0..1", "0..*"),
        Relationship ("PricingStructure", "PricingStructure", "0..1", "0..*"),
        Relationship ("Receipt", "Receipt", "0..1", "1..*"),
        Relationship ("UserAttributes", "UserAttribute", "0..*", "0..1"),
        Relationship ("VendorShift", "VendorShift", "0..1", "0..*")
    )
    val diverseReference: Fielder = parse_element (element (cls, fields(0)))
    val donorReference: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val line: Fielder = parse_attribute (attribute (cls, fields(3)))
    val receiverReference: Fielder = parse_element (element (cls, fields(4)))
    val reversedId: Fielder = parse_element (element (cls, fields(5)))
    val serviceUnitsEnergy: Fielder = parse_element (element (cls, fields(6)))
    val serviceUnitsError: Fielder = parse_element (element (cls, fields(7)))
    val AuxiliaryAccount: Fielder = parse_attribute (attribute (cls, fields(8)))
    val CashierShift: Fielder = parse_attribute (attribute (cls, fields(9)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Meter: Fielder = parse_attribute (attribute (cls, fields(11)))
    val PricingStructure: Fielder = parse_attribute (attribute (cls, fields(12)))
    val Receipt: Fielder = parse_attribute (attribute (cls, fields(13)))
    val UserAttributes: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val VendorShift: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): Transaction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Transaction (
            IdentifiedObject.parse (context),
            mask (diverseReference (), 0),
            mask (donorReference (), 1),
            mask (kind (), 2),
            mask (line (), 3),
            mask (receiverReference (), 4),
            mask (reversedId (), 5),
            toDouble (mask (serviceUnitsEnergy (), 6)),
            toDouble (mask (serviceUnitsError (), 7)),
            mask (AuxiliaryAccount (), 8),
            mask (CashierShift (), 9),
            mask (CustomerAccount (), 10),
            mask (Meter (), 11),
            mask (PricingStructure (), 12),
            mask (Receipt (), 13),
            masks (UserAttributes (), 14),
            mask (VendorShift (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The entity that ultimately executes the transaction and which is in control of the process; typically this is embodied in secure software running on a server that may employ secure hardware encryption devices for secure transaction processing.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MerchantAccounts [[ch.ninecode.model.MerchantAccount MerchantAccount]] All merchant accounts registered with this transactor.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Transactor
(
    override val sup: IdentifiedObject,
    MerchantAccounts: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Transactor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Transactor.fields (position), x))
        emitattrs (0, MerchantAccounts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Transactor rdf:ID=\"%s\">\n%s\t</cim:Transactor>".format (id, export_fields)
    }
}

object Transactor
extends
    Parseable[Transactor]
{
    override val fields: Array[String] = Array[String] (
        "MerchantAccounts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MerchantAccounts", "MerchantAccount", "0..*", "0..*")
    )
    val MerchantAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Transactor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Transactor (
            IdentifiedObject.parse (context),
            masks (MerchantAccounts (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The entity that owns the point of sale and contracts with the cashier to receipt payments and vend tokens using the payment system.
 *
 * The vendor has a private contract with and is managed by the merchant which is a type of organisation. The vendor is accountable to the merchant for revenue collected, and the merchant is in turn accountable to the supplier.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param VendorShifts [[ch.ninecode.model.VendorShift VendorShift]] All vendor shifts opened and owned by this vendor.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
case class Vendor
(
    override val sup: IdentifiedObject,
    VendorShifts: List[String]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Vendor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Vendor.fields (position), x))
        emitattrs (0, VendorShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Vendor rdf:ID=\"%s\">\n%s\t</cim:Vendor>".format (id, export_fields)
    }
}

object Vendor
extends
    Parseable[Vendor]
{
    override val fields: Array[String] = Array[String] (
        "VendorShifts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("VendorShifts", "VendorShift", "0..*", "0..1")
    )
    val VendorShifts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Vendor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Vendor (
            IdentifiedObject.parse (context),
            masks (VendorShifts (), 0)
        )
        ret.bitfields = bitfields
        ret
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
 * @param Receipts [[ch.ninecode.model.Receipt Receipt]] All receipts recorded during this vendor shift.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded during this vendor shift.
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
    Receipts: List[String],
    Transactions: List[String],
    Vendor: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, null, List(), List(), null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VendorShift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VendorShift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VendorShift.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (VendorShift.fields (position), x))
        emitelem (0, merchantDebitAmount)
        emitelem (1, posted)
        emitattr (2, MerchantAccount)
        emitattrs (3, Receipts)
        emitattrs (4, Transactions)
        emitattr (5, Vendor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VendorShift rdf:ID=\"%s\">\n%s\t</cim:VendorShift>".format (id, export_fields)
    }
}

object VendorShift
extends
    Parseable[VendorShift]
{
    override val fields: Array[String] = Array[String] (
        "merchantDebitAmount",
        "posted",
        "MerchantAccount",
        "Receipts",
        "Transactions",
        "Vendor"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MerchantAccount", "MerchantAccount", "0..1", "0..*"),
        Relationship ("Receipts", "Receipt", "0..*", "0..1"),
        Relationship ("Transactions", "Transaction", "0..*", "0..1"),
        Relationship ("Vendor", "Vendor", "0..1", "0..*")
    )
    val merchantDebitAmount: Fielder = parse_element (element (cls, fields(0)))
    val posted: Fielder = parse_element (element (cls, fields(1)))
    val MerchantAccount: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Receipts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Vendor: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): VendorShift =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VendorShift (
            Shift.parse (context),
            toDouble (mask (merchantDebitAmount (), 0)),
            toBoolean (mask (posted (), 1)),
            mask (MerchantAccount (), 2),
            masks (Receipts (), 3),
            masks (Transactions (), 4),
            mask (Vendor (), 5)
        )
        ret.bitfields = bitfields
        ret
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