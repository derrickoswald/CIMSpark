package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering.
 * These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */

/**
 * Credit/debit movements for an account.
 * @param sup Reference to the superclass object.
 * @param amount Amount that was credited to/debited from an account.
 *        For example: payment received/interest charge on arrears.
 * @param dateTime Date and time when the credit/debit transaction was performed.
 * @param reason Reason for credit/debit transaction on an account.
 *        Example: payment received/arrears interest levied.
 */
case class AccountMovement
(
    override val sup: Element,
    val amount: Double,
    val dateTime: String,
    val reason: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AccountMovement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccountMovement
extends
    Parseable[AccountMovement]
{
    val sup = BasicElement.parse _
    val amount = parse_element (element ("""AccountMovement.amount"""))
    val dateTime = parse_element (element ("""AccountMovement.dateTime"""))
    val reason = parse_element (element ("""AccountMovement.reason"""))
    def parse (context: Context): AccountMovement =
    {
        AccountMovement(
            sup (context),
            toDouble (amount (context), context),
            dateTime (context),
            reason (context)
        )
    }
}

/**
 * Unit for accounting; use either 'energyUnit' or 'currencyUnit' to specify the unit for 'value'.
 * @param sup Reference to the superclass object.
 * @param energyUnit Unit of service.
 * @param monetaryUnit Unit of currency.
 * @param multiplier Multiplier for the 'energyUnit' or 'monetaryUnit'.
 * @param value Value expressed in applicable units.
 */
case class AccountingUnit
(
    override val sup: Element,
    val energyUnit: Double,
    val monetaryUnit: String,
    val multiplier: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AccountingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AccountingUnit
extends
    Parseable[AccountingUnit]
{
    val sup = BasicElement.parse _
    val energyUnit = parse_element (element ("""AccountingUnit.energyUnit"""))
    val monetaryUnit = parse_attribute (attribute ("""AccountingUnit.monetaryUnit"""))
    val multiplier = parse_attribute (attribute ("""AccountingUnit.multiplier"""))
    val value = parse_element (element ("""AccountingUnit.value"""))
    def parse (context: Context): AccountingUnit =
    {
        AccountingUnit(
            sup (context),
            toDouble (energyUnit (context), context),
            monetaryUnit (context),
            multiplier (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Variable and dynamic part of auxiliary agreement, generally representing the current state of the account related to the outstanding balance defined in auxiliary agreement.
 * @param sup Reference to the superclass object.
 * @param balance The total amount currently remaining on this account that is required to be paid in order to settle the account to zero.
 *        This excludes any due amounts not yet paid.
 * @param due Current amounts now due for payment on this account.
 * @param lastCredit Details of the last credit transaction performed on this account.
 * @param lastDebit Details of the last debit transaction performed on this account.
 * @param principleAmount The initial principle amount, with which this account was instantiated.
 * @param AuxiliaryAgreement Auxiliary agreement regulating this account.
 * @param Charges All charges levied on this account.
 */
case class AuxiliaryAccount
(
    override val sup: Element,
    val balance: Double,
    val due: String,
    val lastCredit: String,
    val lastDebit: String,
    val principleAmount: Double,
    val AuxiliaryAgreement: String,
    val Charges: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, 0.0, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryAccount
extends
    Parseable[AuxiliaryAccount]
{
    val sup = Document.parse _
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
            sup (context),
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
 * Typically this is used to collect revenue owed by the customer for other services or arrears accrued with the utility for other services. It is typically linked to a prepaid token purchase transaction, thus forcing the customer to make a payment towards settlement of the auxiliary account balance whenever the customer needs to purchase a prepaid token for electricity.
 * @param sup Reference to the superclass object.
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
 * @param CustomerAgreement Customer agreement this (non-service related) auxiliary agreement refers to.
 */
case class AuxiliaryAgreement
(
    override val sup: Element,
    val arrearsInterest: Double,
    val auxCycle: String,
    val auxPriorityCode: String,
    val fixedAmount: Double,
    val minAmount: Double,
    val payCycle: String,
    val subType: String,
    val vendPortion: Double,
    val vendPortionArrear: Double,
    val CustomerAgreement: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, null, null, 0.0, 0.0, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[AuxiliaryAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AuxiliaryAgreement
extends
    Parseable[AuxiliaryAgreement]
{
    val sup = Agreement.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param accountNumber Operational account reference number.
 * @param bankName Name of bank where account is held.
 * @param branchCode Branch of bank where account is held.
 * @param holderID National identity number (or equivalent) of account holder.
 * @param holderName Name of account holder.
 */
case class BankAccountDetail
(
    override val sup: Element,
    val accountNumber: String,
    val bankName: String,
    val branchCode: String,
    val holderID: String,
    val holderName: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BankAccountDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BankAccountDetail
extends
    Parseable[BankAccountDetail]
{
    val sup = BasicElement.parse _
    val accountNumber = parse_element (element ("""BankAccountDetail.accountNumber"""))
    val bankName = parse_element (element ("""BankAccountDetail.bankName"""))
    val branchCode = parse_element (element ("""BankAccountDetail.branchCode"""))
    val holderID = parse_element (element ("""BankAccountDetail.holderID"""))
    val holderName = parse_element (element ("""BankAccountDetail.holderName"""))
    def parse (context: Context): BankAccountDetail =
    {
        BankAccountDetail(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param accountHolderName Name of account holder.
 * @param cvNumber The card verification number.
 * @param expiryDate The date when this card expires.
 * @param pan The primary account number.
 * @param Tender Payment tender this card is being used for.
 */
case class Card
(
    override val sup: Element,
    val accountHolderName: String,
    val cvNumber: String,
    val expiryDate: String,
    val pan: String,
    val Tender: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Card]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Card
extends
    Parseable[Card]
{
    val sup = BasicElement.parse _
    val accountHolderName = parse_element (element ("""Card.accountHolderName"""))
    val cvNumber = parse_element (element ("""Card.cvNumber"""))
    val expiryDate = parse_element (element ("""Card.expiryDate"""))
    val pan = parse_element (element ("""Card.pan"""))
    val Tender = parse_attribute (attribute ("""Card.Tender"""))
    def parse (context: Context): Card =
    {
        Card(
            sup (context),
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
 * Cashier is under the exclusive management control of Vendor.
 * @param sup Reference to the superclass object.
 * @param electronicAddress Electronic address.
 */
case class Cashier
(
    override val sup: Element,
    val electronicAddress: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Cashier]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Cashier
extends
    Parseable[Cashier]
{
    val sup = IdentifiedObject.parse _
    val electronicAddress = parse_attribute (attribute ("""Cashier.electronicAddress"""))
    def parse (context: Context): Cashier =
    {
        Cashier(
            sup (context),
            electronicAddress (context)
        )
    }
}

/**
 * The operating shift for a cashier, during which the cashier may transact against the cashier shift, subject to vendor shift being open.
 * @param sup Reference to the superclass object.
 * @param cashFloat The amount of cash that the cashier brings to start the shift and that will be taken away at the end of the shift; i.e. the cash float does not get banked.
 * @param Cashier Cashier operating this shift.
 * @param PointOfSale Point of sale that is in operation during this shift.
 */
case class CashierShift
(
    override val sup: Element,
    val cashFloat: Double,
    val Cashier: String,
    val PointOfSale: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Shift: Shift = sup.asInstanceOf[Shift]
    override def copy (): Row = { return (clone ().asInstanceOf[CashierShift]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CashierShift
extends
    Parseable[CashierShift]
{
    val sup = Shift.parse _
    val cashFloat = parse_element (element ("""CashierShift.cashFloat"""))
    val Cashier = parse_attribute (attribute ("""CashierShift.Cashier"""))
    val PointOfSale = parse_attribute (attribute ("""CashierShift.PointOfSale"""))
    def parse (context: Context): CashierShift =
    {
        CashierShift(
            sup (context),
            toDouble (cashFloat (context), context),
            Cashier (context),
            PointOfSale (context)
        )
    }
}

/**
 * A charge element associated with other entities such as tariff structures, auxiliary agreements or other charge elements.
 * The total charge amount applicable to this instance of charge is the sum of fixed and variable portion.
 * @param sup Reference to the superclass object.
 * @param fixedPortion The fixed portion of this charge element.
 * @param kind The kind of charge to be applied.
 * @param variablePortion The variable portion of this charge element, calculated as a percentage of the total amount of a parent charge.
 * @param ParentCharge Parent of this charge sub-component.
 */
case class Charge
(
    override val sup: Element,
    val fixedPortion: String,
    val kind: String,
    val variablePortion: Double,
    val ParentCharge: String
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Charge]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Charge
extends
    Parseable[Charge]
{
    val sup = IdentifiedObject.parse _
    val fixedPortion = parse_attribute (attribute ("""Charge.fixedPortion"""))
    val kind = parse_attribute (attribute ("""Charge.kind"""))
    val variablePortion = parse_element (element ("""Charge.variablePortion"""))
    val ParentCharge = parse_attribute (attribute ("""Charge.ParentCharge"""))
    def parse (context: Context): Charge =
    {
        Charge(
            sup (context),
            fixedPortion (context),
            kind (context),
            toDouble (variablePortion (context), context),
            ParentCharge (context)
        )
    }
}

/**
 * Kind of charge.
 * @param sup Reference to the superclass object.
 * @param auxiliaryCharge Any other charge which is not a consumptionCharge or demandCharge.
 *        For example: debt recovery, arrears, standing charge or charge for another service such as street lighting.
 * @param consumptionCharge The charge levied for the actual usage of the service, normally expressed in terms of a tariff.
 *        For example: usage x price per kWh = total charge for consumption.
 * @param demandCharge The charge related to the usage within a defined time interval, normally expressed in terms of a tariff.
 *        For example: a maximum-demand tariff will levy an additional charge on top of the consumption charge if the usage exceeds a defined limit per hour.
 * @param other Other kind of charge.
 * @param taxCharge Any charge that is classified as a tax of a kind.
 *        For example: VAT, GST, TV tax, etc.
 */
case class ChargeKind
(
    override val sup: Element,
    val auxiliaryCharge: String,
    val consumptionCharge: String,
    val demandCharge: String,
    val other: String,
    val taxCharge: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ChargeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChargeKind
extends
    Parseable[ChargeKind]
{
    val sup = BasicElement.parse _
    val auxiliaryCharge = parse_attribute (attribute ("""ChargeKind.auxiliaryCharge"""))
    val consumptionCharge = parse_attribute (attribute ("""ChargeKind.consumptionCharge"""))
    val demandCharge = parse_attribute (attribute ("""ChargeKind.demandCharge"""))
    val other = parse_attribute (attribute ("""ChargeKind.other"""))
    val taxCharge = parse_attribute (attribute ("""ChargeKind.taxCharge"""))
    def parse (context: Context): ChargeKind =
    {
        ChargeKind(
            sup (context),
            auxiliaryCharge (context),
            consumptionCharge (context),
            demandCharge (context),
            other (context),
            taxCharge (context)
        )
    }
}

/**
 * The actual tender when it is a type of cheque.
 * @param sup Reference to the superclass object.
 * @param bankAccountDetail Details of the account holder and bank.
 * @param chequeNumber Cheque reference number as printed on the cheque.
 * @param date Date when cheque becomes valid.
 * @param kind Kind of cheque.
 * @param micrNumber The magnetic ink character recognition number printed on the cheque.
 * @param Tender Payment tender the cheque is being used for.
 */
case class Cheque
(
    override val sup: Element,
    val bankAccountDetail: String,
    val chequeNumber: String,
    val date: String,
    val kind: String,
    val micrNumber: String,
    val Tender: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Cheque]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Cheque
extends
    Parseable[Cheque]
{
    val sup = BasicElement.parse _
    val bankAccountDetail = parse_attribute (attribute ("""Cheque.bankAccountDetail"""))
    val chequeNumber = parse_element (element ("""Cheque.chequeNumber"""))
    val date = parse_element (element ("""Cheque.date"""))
    val kind = parse_attribute (attribute ("""Cheque.kind"""))
    val micrNumber = parse_element (element ("""Cheque.micrNumber"""))
    val Tender = parse_attribute (attribute ("""Cheque.Tender"""))
    def parse (context: Context): Cheque =
    {
        Cheque(
            sup (context),
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
 * Kind of cheque.
 * @param sup Reference to the superclass object.
 * @param bankOrder Payment order used by a bank.
 * @param other Other kind of cheque.
 * @param postalOrder Payment order used by institutions other than banks.
 */
case class ChequeKind
(
    override val sup: Element,
    val bankOrder: String,
    val other: String,
    val postalOrder: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ChequeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ChequeKind
extends
    Parseable[ChequeKind]
{
    val sup = BasicElement.parse _
    val bankOrder = parse_attribute (attribute ("""ChequeKind.bankOrder"""))
    val other = parse_attribute (attribute ("""ChequeKind.other"""))
    val postalOrder = parse_attribute (attribute ("""ChequeKind.postalOrder"""))
    def parse (context: Context): ChequeKind =
    {
        ChequeKind(
            sup (context),
            bankOrder (context),
            other (context),
            postalOrder (context)
        )
    }
}

/**
 * One of a sequence of intervals defined in terms of consumption quantity of a service such as electricity, water, gas, etc.
 * It is typically used in association with TariffProfile to define the steps or blocks in a step tariff structure, where startValue simultaneously defines the entry value of this step and the closing value of the previous step. Where consumption is &gt;= startValue it falls within this interval and where consumption is &lt; startValue it falls within the previous interval.
 * @param sup Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startValue The lowest level of consumption that defines the starting point of this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges All charges used to define this consumption tariff interval.
 * @param TouTariffIntervals All time of use tariff intervals influenced by this consumption tariff interval.
 */
case class ConsumptionTariffInterval
(
    override val sup: Element,
    val sequenceNumber: Int,
    val startValue: Double,
    val Charges: List[String],
    val TouTariffIntervals: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, List(), List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ConsumptionTariffInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConsumptionTariffInterval
extends
    Parseable[ConsumptionTariffInterval]
{
    val sup = BasicElement.parse _
    val sequenceNumber = parse_element (element ("""ConsumptionTariffInterval.sequenceNumber"""))
    val startValue = parse_element (element ("""ConsumptionTariffInterval.startValue"""))
    val Charges = parse_attributes (attribute ("""ConsumptionTariffInterval.Charges"""))
    val TouTariffIntervals = parse_attributes (attribute ("""ConsumptionTariffInterval.TouTariffIntervals"""))
    def parse (context: Context): ConsumptionTariffInterval =
    {
        ConsumptionTariffInterval(
            sup (context),
            toInteger (sequenceNumber (context), context),
            toDouble (startValue (context), context),
            Charges (context),
            TouTariffIntervals (context)
        )
    }
}

/**
 * Details on amounts due for an account.
 * @param sup Reference to the superclass object.
 * @param arrears Part of 'current' that constitutes the arrears portion.
 * @param charges Part of 'current' that constitutes the charge portion: 'charges' = 'Charge.fixedPortion' + 'Charge.variablePortion'.
 * @param current Current total amount now due: current = principle + arrears + interest + charges.
 *        Typically the rule for settlement priority is: interest dues, then arrears dues, then current dues, then charge dues.
 * @param interest Part of 'current' that constitutes the interest portion.
 * @param principle Part of 'current' that constitutes the portion of the principle amount currently due.
 */
case class Due
(
    override val sup: Element,
    val arrears: Double,
    val charges: Double,
    val current: Double,
    val interest: Double,
    val principle: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Due]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Due
extends
    Parseable[Due]
{
    val sup = BasicElement.parse _
    val arrears = parse_element (element ("""Due.arrears"""))
    val charges = parse_element (element ("""Due.charges"""))
    val current = parse_element (element ("""Due.current"""))
    val interest = parse_element (element ("""Due.interest"""))
    val principle = parse_element (element ("""Due.principle"""))
    def parse (context: Context): Due =
    {
        Due(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param amount Amount for this line item.
 * @param dateTime Date and time when this line was created in the application process.
 * @param note Free format note relevant to this line.
 * @param rounding Totalised monetary value of all errors due to process rounding or truncating that is not reflected in 'amount'.
 */
case class LineDetail
(
    override val sup: Element,
    val amount: Double,
    val dateTime: String,
    val note: String,
    val rounding: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LineDetail]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LineDetail
extends
    Parseable[LineDetail]
{
    val sup = BasicElement.parse _
    val amount = parse_element (element ("""LineDetail.amount"""))
    val dateTime = parse_element (element ("""LineDetail.dateTime"""))
    val note = parse_element (element ("""LineDetail.note"""))
    val rounding = parse_element (element ("""LineDetail.rounding"""))
    def parse (context: Context): LineDetail =
    {
        LineDetail(
            sup (context),
            toDouble (amount (context), context),
            dateTime (context),
            note (context),
            toDouble (rounding (context), context)
        )
    }
}

/**
 * The operating account controlled by merchant agreement, against which the vendor may vend tokens or receipt payments.
 * Transactions via vendor shift debit the account and bank deposits via bank statement credit the account.
 * @param sup Reference to the superclass object.
 * @param currentBalance The current operating balance of this account.
 * @param provisionalBalance The balance of this account after taking into account any pending debits from VendorShift.merchantDebitAmount and pending credits from BankStatement.merchantCreditAmount or credits (see also BankStatement attributes and VendorShift attributes).
 * @param MerchantAgreement Merchant agreement that instantiated this merchant account.
 * @param Transactors All transactors this merchant account is registered with.
 */
case class MerchantAccount
(
    override val sup: Element,
    val currentBalance: Double,
    val provisionalBalance: Double,
    val MerchantAgreement: String,
    val Transactors: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[MerchantAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MerchantAccount
extends
    Parseable[MerchantAccount]
{
    val sup = Document.parse _
    val currentBalance = parse_element (element ("""MerchantAccount.currentBalance"""))
    val provisionalBalance = parse_element (element ("""MerchantAccount.provisionalBalance"""))
    val MerchantAgreement = parse_attribute (attribute ("""MerchantAccount.MerchantAgreement"""))
    val Transactors = parse_attributes (attribute ("""MerchantAccount.Transactors"""))
    def parse (context: Context): MerchantAccount =
    {
        MerchantAccount(
            sup (context),
            toDouble (currentBalance (context), context),
            toDouble (provisionalBalance (context), context),
            MerchantAgreement (context),
            Transactors (context)
        )
    }
}

/**
 * A formal controlling contractual agreement between supplier and merchant, in terms of which the merchant is authorised to vend tokens and receipt payments on behalf of the supplier.
 * The merchant is accountable to the supplier for revenue collected at point of sale.
 * @param sup Reference to the superclass object.
 */
case class MerchantAgreement
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[MerchantAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MerchantAgreement
extends
    Parseable[MerchantAgreement]
{
    val sup = Agreement.parse _
    def parse (context: Context): MerchantAgreement =
    {
        MerchantAgreement(
            sup (context)
        )
    }
}

/**
 * Logical point where transactions take place with operational interaction between cashier and the payment system; in certain cases the point of sale interacts directly with the end customer, in which case the cashier might not be a real person: for example a self-service kiosk or over the internet.
 * @param sup Reference to the superclass object.
 * @param location Local description for where this point of sale is physically located.
 */
case class PointOfSale
(
    override val sup: Element,
    val location: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[PointOfSale]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PointOfSale
extends
    Parseable[PointOfSale]
{
    val sup = IdentifiedObject.parse _
    val location = parse_element (element ("""PointOfSale.location"""))
    def parse (context: Context): PointOfSale =
    {
        PointOfSale(
            sup (context),
            location (context)
        )
    }
}

/**
 * Record of total receipted payment from customer.
 * @param sup Reference to the superclass object.
 * @param isBankable True if this receipted payment is manually bankable, otherwise it is an electronic funds transfer.
 * @param line Receipted amount with rounding, date and note.
 * @param CashierShift Cashier shift during which this receipt was recorded.
 * @param VendorShift Vendor shift during which this receipt was recorded.
 */
case class Receipt
(
    override val sup: Element,
    val isBankable: Boolean,
    val line: String,
    val CashierShift: String,
    val VendorShift: String
)
extends
    Element
{
    def this () = { this (null, false, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Receipt]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Receipt
extends
    Parseable[Receipt]
{
    val sup = IdentifiedObject.parse _
    val isBankable = parse_element (element ("""Receipt.isBankable"""))
    val line = parse_attribute (attribute ("""Receipt.line"""))
    val CashierShift = parse_attribute (attribute ("""Receipt.CashierShift"""))
    val VendorShift = parse_attribute (attribute ("""Receipt.VendorShift"""))
    def parse (context: Context): Receipt =
    {
        Receipt(
            sup (context),
            toBoolean (isBankable (context), context),
            line (context),
            CashierShift (context),
            VendorShift (context)
        )
    }
}

/**
 * Organisation that provides services to customers.
 * @param sup Reference to the superclass object.
 * @param issuerIdentificationNumber Unique transaction reference prefix number issued to an entity by the International Organization for Standardization for the purpose of tagging onto electronic financial transactions, as defined in ISO/IEC 7812-1 and ISO/IEC 7812-2.
 * @param kind Kind of supplier.
 */
case class ServiceSupplier
(
    override val sup: Element,
    val issuerIdentificationNumber: String,
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceSupplier]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceSupplier
extends
    Parseable[ServiceSupplier]
{
    val sup = OrganisationRole.parse _
    val issuerIdentificationNumber = parse_element (element ("""ServiceSupplier.issuerIdentificationNumber"""))
    val kind = parse_attribute (attribute ("""ServiceSupplier.kind"""))
    def parse (context: Context): ServiceSupplier =
    {
        ServiceSupplier(
            sup (context),
            issuerIdentificationNumber (context),
            kind (context)
        )
    }
}

/**
 * Generally referring to a period of operation or work performed.
 * Whether the shift is open/closed can be derived from attributes 'activityInterval.start' and 'activityInterval.end'.
 * @param sup Reference to the superclass object.
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
 */
case class Shift
(
    override val sup: Element,
    val activityInterval: String,
    val receiptsGrandTotalBankable: Double,
    val receiptsGrandTotalNonBankable: Double,
    val receiptsGrandTotalRounding: Double,
    val transactionsGrandTotal: Double,
    val transactionsGrandTotalRounding: Double
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Shift]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Shift
extends
    Parseable[Shift]
{
    val sup = IdentifiedObject.parse _
    val activityInterval = parse_attribute (attribute ("""Shift.activityInterval"""))
    val receiptsGrandTotalBankable = parse_element (element ("""Shift.receiptsGrandTotalBankable"""))
    val receiptsGrandTotalNonBankable = parse_element (element ("""Shift.receiptsGrandTotalNonBankable"""))
    val receiptsGrandTotalRounding = parse_element (element ("""Shift.receiptsGrandTotalRounding"""))
    val transactionsGrandTotal = parse_element (element ("""Shift.transactionsGrandTotal"""))
    val transactionsGrandTotalRounding = parse_element (element ("""Shift.transactionsGrandTotalRounding"""))
    def parse (context: Context): Shift =
    {
        Shift(
            sup (context),
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
 * Kind of supplier.
 * @param sup Reference to the superclass object.
 * @param other Other kind of supplier.
 * @param retailer Entity that sells the service, but does not deliver to the customer; applies to the deregulated markets.
 * @param utility Entity that delivers the service to the customer.
 */
case class SupplierKind
(
    override val sup: Element,
    val other: String,
    val retailer: String,
    val utility: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SupplierKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SupplierKind
extends
    Parseable[SupplierKind]
{
    val sup = BasicElement.parse _
    val other = parse_attribute (attribute ("""SupplierKind.other"""))
    val retailer = parse_attribute (attribute ("""SupplierKind.retailer"""))
    val utility = parse_attribute (attribute ("""SupplierKind.utility"""))
    def parse (context: Context): SupplierKind =
    {
        SupplierKind(
            sup (context),
            other (context),
            retailer (context),
            utility (context)
        )
    }
}

/**
 * A schedule of charges; structure associated with Tariff that allows the definition of complex tarif structures such as step and time of use when used in conjunction with TimeTariffInterval and Charge.
 * Inherited 'status.value' is defined in the context of the utility's business rules, for example: active, inactive, etc.
 * @param sup Reference to the superclass object.
 * @param tariffCycle The frequency at which the tariff charge schedule is repeated.
 *        Examples are: once off on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc. At the end of each cycle, the business rules are reset to start from the beginning again.
 * @param ConsumptionTariffIntervals All consumption tariff intervals used to define this tariff profile.
 * @param TimeTariffIntervals All time tariff intervals used to define this tariff profile.
 */
case class TariffProfile
(
    override val sup: Element,
    val tariffCycle: String,
    val ConsumptionTariffIntervals: List[String],
    val TimeTariffIntervals: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[TariffProfile]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TariffProfile
extends
    Parseable[TariffProfile]
{
    val sup = Document.parse _
    val tariffCycle = parse_element (element ("""TariffProfile.tariffCycle"""))
    val ConsumptionTariffIntervals = parse_attributes (attribute ("""TariffProfile.ConsumptionTariffIntervals"""))
    val TimeTariffIntervals = parse_attributes (attribute ("""TariffProfile.TimeTariffIntervals"""))
    def parse (context: Context): TariffProfile =
    {
        TariffProfile(
            sup (context),
            tariffCycle (context),
            ConsumptionTariffIntervals (context),
            TimeTariffIntervals (context)
        )
    }
}

/**
 * Tender is what is "offered" by the customer towards making a payment and is often more than the required payment (hence the need for 'change').
 * The payment is thus that part of the Tender that goes towards settlement of a particular transaction.
 * @param sup Reference to the superclass object.
 * @param amount Amount tendered by customer.
 * @param change Difference between amount tendered by customer and the amount charged by point of sale.
 * @param kind Kind of tender from customer.
 * @param Card Card used to tender payment.
 * @param Cheque Cheque used to tender payment.
 * @param Receipt Receipt that recorded this receiving of a payment in the form of tenders.
 */
case class Tender
(
    override val sup: Element,
    val amount: Double,
    val change: Double,
    val kind: String,
    val Card: String,
    val Cheque: String,
    val Receipt: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Tender]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Tender
extends
    Parseable[Tender]
{
    val sup = IdentifiedObject.parse _
    val amount = parse_element (element ("""Tender.amount"""))
    val change = parse_element (element ("""Tender.change"""))
    val kind = parse_attribute (attribute ("""Tender.kind"""))
    val Card = parse_attribute (attribute ("""Tender.Card"""))
    val Cheque = parse_attribute (attribute ("""Tender.Cheque"""))
    val Receipt = parse_attribute (attribute ("""Tender.Receipt"""))
    def parse (context: Context): Tender =
    {
        Tender(
            sup (context),
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
 * Kind of tender.
 * @param sup Reference to the superclass object.
 * @param card Payment method by means of a credit or debit card.
 * @param cash Payment method by means of cash.
 * @param cheque Payment method by means of a cheque.
 * @param other Other payment method such as electronic finds transfer.
 * @param unspecified Payment method is not known.
 */
case class TenderKind
(
    override val sup: Element,
    val card: String,
    val cash: String,
    val cheque: String,
    val other: String,
    val unspecified: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TenderKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TenderKind
extends
    Parseable[TenderKind]
{
    val sup = BasicElement.parse _
    val card = parse_attribute (attribute ("""TenderKind.card"""))
    val cash = parse_attribute (attribute ("""TenderKind.cash"""))
    val cheque = parse_attribute (attribute ("""TenderKind.cheque"""))
    val other = parse_attribute (attribute ("""TenderKind.other"""))
    val unspecified = parse_attribute (attribute ("""TenderKind.unspecified"""))
    def parse (context: Context): TenderKind =
    {
        TenderKind(
            sup (context),
            card (context),
            cash (context),
            cheque (context),
            other (context),
            unspecified (context)
        )
    }
}

/**
 * One of a sequence of time intervals defined in terms of real time.
 * It is typically used in association with TariffProfile to define the intervals in a time of use tariff structure, where startDateTime simultaneously determines the starting point of this interval and the ending point of the previous interval.
 * @param sup Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startTime A real time marker that defines the starting time (typically it is the time of day) for this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges All charges used to define this time tariff interval.
 */
case class TimeTariffInterval
(
    override val sup: Element,
    val sequenceNumber: Int,
    val startTime: String,
    val Charges: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, null, List()) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeTariffInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeTariffInterval
extends
    Parseable[TimeTariffInterval]
{
    val sup = BasicElement.parse _
    val sequenceNumber = parse_element (element ("""TimeTariffInterval.sequenceNumber"""))
    val startTime = parse_element (element ("""TimeTariffInterval.startTime"""))
    val Charges = parse_attributes (attribute ("""TimeTariffInterval.Charges"""))
    def parse (context: Context): TimeTariffInterval =
    {
        TimeTariffInterval(
            sup (context),
            toInteger (sequenceNumber (context), context),
            startTime (context),
            Charges (context)
        )
    }
}

/**
 * The record of details of payment for service or token sale.
 * @param sup Reference to the superclass object.
 * @param diverseReference Formal reference for use with diverse payment (traffic fine for example).
 * @param donorReference Reference to the entity that is the source of 'amount' (for example: customer for token purchase; or supplier for free issue token).
 * @param kind Kind of transaction.
 * @param line Transaction amount, rounding, date and note for this transaction line.
 * @param receiverReference Reference to the entity that is the recipient of 'amount' (for example, supplier for service charge payment; or tax receiver for VAT).
 * @param reversedId (if 'kind' is transactionReversal) Reference to the original transaction that is being reversed by this transaction.
 * @param serviceUnitsEnergy Actual amount of service units that is being paid for.
 * @param serviceUnitsError Number of service units not reflected in 'serviceUnitsEnergy' due to process rounding or truncating errors.
 * @param AuxiliaryAccount Auxiliary account for this payment transaction.
 * @param CashierShift Cashier shift during which this transaction was recorded.
 * @param CustomerAccount Customer account for this payment transaction.
 * @param Meter Meter for this vending transaction.
 * @param PricingStructure Pricing structure applicable for this transaction.
 * @param Receipt The receipted payment for which this transaction has been recorded.
 * @param VendorShift Vendor shift during which this transaction was recorded.
 */
case class Transaction
(
    override val sup: Element,
    val diverseReference: String,
    val donorReference: String,
    val kind: String,
    val line: String,
    val receiverReference: String,
    val reversedId: String,
    val serviceUnitsEnergy: Double,
    val serviceUnitsError: Double,
    val AuxiliaryAccount: String,
    val CashierShift: String,
    val CustomerAccount: String,
    val Meter: String,
    val PricingStructure: String,
    val Receipt: String,
    val VendorShift: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, 0.0, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Transaction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Transaction
extends
    Parseable[Transaction]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
 * Kind of transaction.
 * @param sup Reference to the superclass object.
 * @param accountPayment Payment against a specified account.
 * @param auxiliaryChargePayment Payment against a specified auxiliary account.
 * @param diversePayment Payment against an item other than an account.
 * @param meterConfigurationToken Issue of token that will alter the meter configuration.
 * @param other Other kind of transaction.
 * @param serviceChargePayment Payment for a service.
 * @param taxChargePayment Payment for a tax.
 * @param tokenCancellation Cancellation of a previously issued token.
 * @param tokenExchange Exchange of a previously issued token for a new token.
 * @param tokenFreeIssue Issue of a free credit token where the donor is the supplier.
 * @param tokenGrant Issue of a free credit token where the donor is a 3<sup>rd</sup> party.
 * @param tokenSalePayment Payment for a credit token sale to a customer.
 * @param transactionReversal Reversal of a previous transaction.
 */
case class TransactionKind
(
    override val sup: Element,
    val accountPayment: String,
    val auxiliaryChargePayment: String,
    val diversePayment: String,
    val meterConfigurationToken: String,
    val other: String,
    val serviceChargePayment: String,
    val taxChargePayment: String,
    val tokenCancellation: String,
    val tokenExchange: String,
    val tokenFreeIssue: String,
    val tokenGrant: String,
    val tokenSalePayment: String,
    val transactionReversal: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TransactionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransactionKind
extends
    Parseable[TransactionKind]
{
    val sup = BasicElement.parse _
    val accountPayment = parse_attribute (attribute ("""TransactionKind.accountPayment"""))
    val auxiliaryChargePayment = parse_attribute (attribute ("""TransactionKind.auxiliaryChargePayment"""))
    val diversePayment = parse_attribute (attribute ("""TransactionKind.diversePayment"""))
    val meterConfigurationToken = parse_attribute (attribute ("""TransactionKind.meterConfigurationToken"""))
    val other = parse_attribute (attribute ("""TransactionKind.other"""))
    val serviceChargePayment = parse_attribute (attribute ("""TransactionKind.serviceChargePayment"""))
    val taxChargePayment = parse_attribute (attribute ("""TransactionKind.taxChargePayment"""))
    val tokenCancellation = parse_attribute (attribute ("""TransactionKind.tokenCancellation"""))
    val tokenExchange = parse_attribute (attribute ("""TransactionKind.tokenExchange"""))
    val tokenFreeIssue = parse_attribute (attribute ("""TransactionKind.tokenFreeIssue"""))
    val tokenGrant = parse_attribute (attribute ("""TransactionKind.tokenGrant"""))
    val tokenSalePayment = parse_attribute (attribute ("""TransactionKind.tokenSalePayment"""))
    val transactionReversal = parse_attribute (attribute ("""TransactionKind.transactionReversal"""))
    def parse (context: Context): TransactionKind =
    {
        TransactionKind(
            sup (context),
            accountPayment (context),
            auxiliaryChargePayment (context),
            diversePayment (context),
            meterConfigurationToken (context),
            other (context),
            serviceChargePayment (context),
            taxChargePayment (context),
            tokenCancellation (context),
            tokenExchange (context),
            tokenFreeIssue (context),
            tokenGrant (context),
            tokenSalePayment (context),
            transactionReversal (context)
        )
    }
}

/**
 * The entity that ultimately executes the transaction and which is in control of the process; typically this is embodied in secure software running on a server that may employ secure hardware encryption devices for secure transaction processing.
 * @param sup Reference to the superclass object.
 */
case class Transactor
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Transactor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Transactor
extends
    Parseable[Transactor]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): Transactor =
    {
        Transactor(
            sup (context)
        )
    }
}

/**
 * The entity that owns the point of sale and contracts with the cashier to receipt payments and vend tokens using the payment system.
 * The vendor has a private contract with and is managed by the merchant which is a type of organisation. The vendor is accountable to the merchant for revenue collected, and the merchant is in turn accountable to the supplier.
 * @param sup Reference to the superclass object.
 */
case class Vendor
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Vendor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Vendor
extends
    Parseable[Vendor]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): Vendor =
    {
        Vendor(
            sup (context)
        )
    }
}

/**
 * The operating shift for a vendor during which the vendor may transact against the merchant's account.
 * It aggregates transactions and receipts during the shift and periodically debits a merchant account. The totals in vendor shift should always be the sum of totals aggregated in all cashier shifts that were open under the particular vendor shift.
 * @param sup Reference to the superclass object.
 * @param merchantDebitAmount The amount that is to be debited from the merchant account for this vendor shift.
 *        This amount reflects the sum(PaymentTransaction.transactionAmount).
 * @param posted If true, merchantDebitAmount has been debited from MerchantAccount; typically happens at the end of VendorShift when it closes.
 * @param MerchantAccount Merchant account this vendor shift periodically debits (based on aggregated transactions).
 * @param Vendor Vendor that opens and owns this vendor shift.
 */
case class VendorShift
(
    override val sup: Element,
    val merchantDebitAmount: Double,
    val posted: Boolean,
    val MerchantAccount: String,
    val Vendor: String
)
extends
    Element
{
    def this () = { this (null, 0.0, false, null, null) }
    def Shift: Shift = sup.asInstanceOf[Shift]
    override def copy (): Row = { return (clone ().asInstanceOf[VendorShift]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VendorShift
extends
    Parseable[VendorShift]
{
    val sup = Shift.parse _
    val merchantDebitAmount = parse_element (element ("""VendorShift.merchantDebitAmount"""))
    val posted = parse_element (element ("""VendorShift.posted"""))
    val MerchantAccount = parse_attribute (attribute ("""VendorShift.MerchantAccount"""))
    val Vendor = parse_attribute (attribute ("""VendorShift.Vendor"""))
    def parse (context: Context): VendorShift =
    {
        VendorShift(
            sup (context),
            toDouble (merchantDebitAmount (context), context),
            toBoolean (posted (context), context),
            MerchantAccount (context),
            Vendor (context)
        )
    }
}

object _PaymentMetering
{
    def register: Unit =
    {
        AccountMovement.register
        AccountingUnit.register
        AuxiliaryAccount.register
        AuxiliaryAgreement.register
        BankAccountDetail.register
        Card.register
        Cashier.register
        CashierShift.register
        Charge.register
        ChargeKind.register
        Cheque.register
        ChequeKind.register
        ConsumptionTariffInterval.register
        Due.register
        LineDetail.register
        MerchantAccount.register
        MerchantAgreement.register
        PointOfSale.register
        Receipt.register
        ServiceSupplier.register
        Shift.register
        SupplierKind.register
        TariffProfile.register
        Tender.register
        TenderKind.register
        TimeTariffInterval.register
        Transaction.register
        TransactionKind.register
        Transactor.register
        Vendor.register
        VendorShift.register
    }
}