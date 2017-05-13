package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering.
 * These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */

/**
 * Credit/debit movements for an account.
 */
case class AccountMovement
(

    override val sup: BasicElement,

    /**
     * Amount that was credited to/debited from an account.
     * For example: payment received/interest charge on arrears.
     */
    val amount: Double,

    /**
     * Date and time when the credit/debit transaction was performed.
     */
    val dateTime: String,

    /**
     * Reason for credit/debit transaction on an account.
     * Example: payment received/arrears interest levied.
     */
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
    val amount = parse_element (element ("""AccountMovement.amount"""))_
    val dateTime = parse_element (element ("""AccountMovement.dateTime"""))_
    val reason = parse_element (element ("""AccountMovement.reason"""))_
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
 */
case class AccountingUnit
(

    override val sup: BasicElement,

    /**
     * Unit of service.
     */
    val energyUnit: Double,

    /**
     * Unit of currency.
     */
    val monetaryUnit: String,

    /**
     * Multiplier for the 'energyUnit' or 'monetaryUnit'.
     */
    val multiplier: String,

    /**
     * Value expressed in applicable units.
     */
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
    val energyUnit = parse_element (element ("""AccountingUnit.energyUnit"""))_
    val monetaryUnit = parse_attribute (attribute ("""AccountingUnit.monetaryUnit"""))_
    val multiplier = parse_attribute (attribute ("""AccountingUnit.multiplier"""))_
    val value = parse_element (element ("""AccountingUnit.value"""))_
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
 */
case class AuxiliaryAccount
(

    override val sup: Document,

    /**
     * The total amount currently remaining on this account that is required to be paid in order to settle the account to zero.
     * This excludes any due amounts not yet paid.
     */
    val balance: Double,

    /**
     * Current amounts now due for payment on this account.
     */
    val due: String,

    /**
     * Details of the last credit transaction performed on this account.
     */
    val lastCredit: String,

    /**
     * Details of the last debit transaction performed on this account.
     */
    val lastDebit: String,

    /**
     * The initial principle amount, with which this account was instantiated.
     */
    val principleAmount: Double,

    /**
     * Auxiliary agreement regulating this account.
     */
    val AuxiliaryAgreement: String,

    /**
     * All charges levied on this account.
     */
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
    val balance = parse_element (element ("""AuxiliaryAccount.balance"""))_
    val due = parse_attribute (attribute ("""AuxiliaryAccount.due"""))_
    val lastCredit = parse_attribute (attribute ("""AuxiliaryAccount.lastCredit"""))_
    val lastDebit = parse_attribute (attribute ("""AuxiliaryAccount.lastDebit"""))_
    val principleAmount = parse_element (element ("""AuxiliaryAccount.principleAmount"""))_
    val AuxiliaryAgreement = parse_attribute (attribute ("""AuxiliaryAccount.AuxiliaryAgreement"""))_
    val Charges = parse_attributes (attribute ("""AuxiliaryAccount.Charges"""))_
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
 */
case class AuxiliaryAgreement
(

    override val sup: Agreement,

    /**
     * The interest per annum to be charged prorata on 'AuxiliaryAccount.dueArrears' at the end of each 'payCycle'.
     */
    val arrearsInterest: Double,

    /**
     * The frequency for automatically recurring auxiliary charges, where 'AuxiliaryAccount.initialCharge' is recursively added to 'AuxiliaryAccount.dueCurrent' at the start of each 'auxCycle'.
     * For example: on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc.
     */
    val auxCycle: String,

    /**
     * The coded priority indicating the priority that this auxiliary agreement has above other auxiliary agreements (associated with the same customer agreement) when it comes to competing for settlement from a payment transaction or token purchase.
     */
    val auxPriorityCode: String,

    /**
     * The fixed amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement.
     * Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
     */
    val fixedAmount: Double,

    /**
     * The minimum amount that has to be paid at any transaction towards settling this auxiliary agreement or reducing the balance.
     */
    val minAmount: Double,

    /**
     * The contractually expected payment frequency (by the customer).
     * Examples are: ad-hoc; on specified date; hourly, daily, weekly, monthly. etc.
     */
    val payCycle: String,

    /**
     * Sub-classification of the inherited 'type' for this AuxiliaryAgreement.
     */
    val subType: String,

    /**
     * The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are not in arrears.
     * Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
     */
    val vendPortion: Double,

    /**
     * The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are in arrears.
     * Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
     */
    val vendPortionArrear: Double,

    /**
     * Customer agreement this (non-service related) auxiliary agreement refers to.
     */
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
    val arrearsInterest = parse_element (element ("""AuxiliaryAgreement.arrearsInterest"""))_
    val auxCycle = parse_element (element ("""AuxiliaryAgreement.auxCycle"""))_
    val auxPriorityCode = parse_element (element ("""AuxiliaryAgreement.auxPriorityCode"""))_
    val fixedAmount = parse_element (element ("""AuxiliaryAgreement.fixedAmount"""))_
    val minAmount = parse_element (element ("""AuxiliaryAgreement.minAmount"""))_
    val payCycle = parse_element (element ("""AuxiliaryAgreement.payCycle"""))_
    val subType = parse_element (element ("""AuxiliaryAgreement.subType"""))_
    val vendPortion = parse_element (element ("""AuxiliaryAgreement.vendPortion"""))_
    val vendPortionArrear = parse_element (element ("""AuxiliaryAgreement.vendPortionArrear"""))_
    val CustomerAgreement = parse_attribute (attribute ("""AuxiliaryAgreement.CustomerAgreement"""))_
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
 */
case class BankAccountDetail
(

    override val sup: BasicElement,

    /**
     * Operational account reference number.
     */
    val accountNumber: String,

    /**
     * Name of bank where account is held.
     */
    val bankName: String,

    /**
     * Branch of bank where account is held.
     */
    val branchCode: String,

    /**
     * National identity number (or equivalent) of account holder.
     */
    val holderID: String,

    /**
     * Name of account holder.
     */
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
    val accountNumber = parse_element (element ("""BankAccountDetail.accountNumber"""))_
    val bankName = parse_element (element ("""BankAccountDetail.bankName"""))_
    val branchCode = parse_element (element ("""BankAccountDetail.branchCode"""))_
    val holderID = parse_element (element ("""BankAccountDetail.holderID"""))_
    val holderName = parse_element (element ("""BankAccountDetail.holderName"""))_
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
 */
case class Card
(

    override val sup: BasicElement,

    /**
     * Name of account holder.
     */
    val accountHolderName: String,

    /**
     * The card verification number.
     */
    val cvNumber: String,

    /**
     * The date when this card expires.
     */
    val expiryDate: String,

    /**
     * The primary account number.
     */
    val pan: String,

    /**
     * Payment tender this card is being used for.
     */
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
    val accountHolderName = parse_element (element ("""Card.accountHolderName"""))_
    val cvNumber = parse_element (element ("""Card.cvNumber"""))_
    val expiryDate = parse_element (element ("""Card.expiryDate"""))_
    val pan = parse_element (element ("""Card.pan"""))_
    val Tender = parse_attribute (attribute ("""Card.Tender"""))_
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
 */
case class Cashier
(

    override val sup: IdentifiedObject,

    /**
     * Electronic address.
     */
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
    val electronicAddress = parse_attribute (attribute ("""Cashier.electronicAddress"""))_
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
 */
case class CashierShift
(

    override val sup: Shift,

    /**
     * The amount of cash that the cashier brings to start the shift and that will be taken away at the end of the shift; i.e. the cash float does not get banked.
     */
    val cashFloat: Double,

    /**
     * Cashier operating this shift.
     */
    val Cashier: String,

    /**
     * Point of sale that is in operation during this shift.
     */
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
    val cashFloat = parse_element (element ("""CashierShift.cashFloat"""))_
    val Cashier = parse_attribute (attribute ("""CashierShift.Cashier"""))_
    val PointOfSale = parse_attribute (attribute ("""CashierShift.PointOfSale"""))_
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
 */
case class Charge
(

    override val sup: IdentifiedObject,

    /**
     * The fixed portion of this charge element.
     */
    val fixedPortion: String,

    /**
     * The kind of charge to be applied.
     */
    val kind: String,

    /**
     * The variable portion of this charge element, calculated as a percentage of the total amount of a parent charge.
     */
    val variablePortion: Double,

    /**
     * Parent of this charge sub-component.
     */
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
    val fixedPortion = parse_attribute (attribute ("""Charge.fixedPortion"""))_
    val kind = parse_attribute (attribute ("""Charge.kind"""))_
    val variablePortion = parse_element (element ("""Charge.variablePortion"""))_
    val ParentCharge = parse_attribute (attribute ("""Charge.ParentCharge"""))_
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
 */
case class ChargeKind
(

    override val sup: BasicElement,

    /**
     * Any other charge which is not a consumptionCharge or demandCharge.
     * For example: debt recovery, arrears, standing charge or charge for another service such as street lighting.
     */
    val auxiliaryCharge: String,

    /**
     * The charge levied for the actual usage of the service, normally expressed in terms of a tariff.
     * For example: usage x price per kWh = total charge for consumption.
     */
    val consumptionCharge: String,

    /**
     * The charge related to the usage within a defined time interval, normally expressed in terms of a tariff.
     * For example: a maximum-demand tariff will levy an additional charge on top of the consumption charge if the usage exceeds a defined limit per hour.
     */
    val demandCharge: String,

    /**
     * Other kind of charge.
     */
    val other: String,

    /**
     * Any charge that is classified as a tax of a kind.
     * For example: VAT, GST, TV tax, etc.
     */
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
    val auxiliaryCharge = parse_attribute (attribute ("""ChargeKind.auxiliaryCharge"""))_
    val consumptionCharge = parse_attribute (attribute ("""ChargeKind.consumptionCharge"""))_
    val demandCharge = parse_attribute (attribute ("""ChargeKind.demandCharge"""))_
    val other = parse_attribute (attribute ("""ChargeKind.other"""))_
    val taxCharge = parse_attribute (attribute ("""ChargeKind.taxCharge"""))_
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
 */
case class Cheque
(

    override val sup: BasicElement,

    /**
     * Details of the account holder and bank.
     */
    val bankAccountDetail: String,

    /**
     * Cheque reference number as printed on the cheque.
     */
    val chequeNumber: String,

    /**
     * Date when cheque becomes valid.
     */
    val date: String,

    /**
     * Kind of cheque.
     */
    val kind: String,

    /**
     * The magnetic ink character recognition number printed on the cheque.
     */
    val micrNumber: String,

    /**
     * Payment tender the cheque is being used for.
     */
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
    val bankAccountDetail = parse_attribute (attribute ("""Cheque.bankAccountDetail"""))_
    val chequeNumber = parse_element (element ("""Cheque.chequeNumber"""))_
    val date = parse_element (element ("""Cheque.date"""))_
    val kind = parse_attribute (attribute ("""Cheque.kind"""))_
    val micrNumber = parse_element (element ("""Cheque.micrNumber"""))_
    val Tender = parse_attribute (attribute ("""Cheque.Tender"""))_
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
 */
case class ChequeKind
(

    override val sup: BasicElement,

    /**
     * Payment order used by a bank.
     */
    val bankOrder: String,

    /**
     * Other kind of cheque.
     */
    val other: String,

    /**
     * Payment order used by institutions other than banks.
     */
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
    val bankOrder = parse_attribute (attribute ("""ChequeKind.bankOrder"""))_
    val other = parse_attribute (attribute ("""ChequeKind.other"""))_
    val postalOrder = parse_attribute (attribute ("""ChequeKind.postalOrder"""))_
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
 */
case class ConsumptionTariffInterval
(

    override val sup: BasicElement,

    /**
     * A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
     */
    val sequenceNumber: Int,

    /**
     * The lowest level of consumption that defines the starting point of this interval.
     * The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
     */
    val startValue: Double,

    /**
     * All charges used to define this consumption tariff interval.
     */
    val Charges: List[String],

    /**
     * All time of use tariff intervals influenced by this consumption tariff interval.
     */
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
    val sequenceNumber = parse_element (element ("""ConsumptionTariffInterval.sequenceNumber"""))_
    val startValue = parse_element (element ("""ConsumptionTariffInterval.startValue"""))_
    val Charges = parse_attributes (attribute ("""ConsumptionTariffInterval.Charges"""))_
    val TouTariffIntervals = parse_attributes (attribute ("""ConsumptionTariffInterval.TouTariffIntervals"""))_
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
 */
case class Due
(

    override val sup: BasicElement,

    /**
     * Part of 'current' that constitutes the arrears portion.
     */
    val arrears: Double,

    /**
     * Part of 'current' that constitutes the charge portion: 'charges' = 'Charge.fixedPortion' + 'Charge.variablePortion'.
     */
    val charges: Double,

    /**
     * Current total amount now due: current = principle + arrears + interest + charges.
     * Typically the rule for settlement priority is: interest dues, then arrears dues, then current dues, then charge dues.
     */
    val current: Double,

    /**
     * Part of 'current' that constitutes the interest portion.
     */
    val interest: Double,

    /**
     * Part of 'current' that constitutes the portion of the principle amount currently due.
     */
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
    val arrears = parse_element (element ("""Due.arrears"""))_
    val charges = parse_element (element ("""Due.charges"""))_
    val current = parse_element (element ("""Due.current"""))_
    val interest = parse_element (element ("""Due.interest"""))_
    val principle = parse_element (element ("""Due.principle"""))_
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
 */
case class LineDetail
(

    override val sup: BasicElement,

    /**
     * Amount for this line item.
     */
    val amount: Double,

    /**
     * Date and time when this line was created in the application process.
     */
    val dateTime: String,

    /**
     * Free format note relevant to this line.
     */
    val note: String,

    /**
     * Totalised monetary value of all errors due to process rounding or truncating that is not reflected in 'amount'.
     */
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
    val amount = parse_element (element ("""LineDetail.amount"""))_
    val dateTime = parse_element (element ("""LineDetail.dateTime"""))_
    val note = parse_element (element ("""LineDetail.note"""))_
    val rounding = parse_element (element ("""LineDetail.rounding"""))_
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
 */
case class MerchantAccount
(

    override val sup: Document,

    /**
     * The current operating balance of this account.
     */
    val currentBalance: Double,

    /**
     * The balance of this account after taking into account any pending debits from VendorShift.merchantDebitAmount and pending credits from BankStatement.merchantCreditAmount or credits (see also BankStatement attributes and VendorShift attributes).
     */
    val provisionalBalance: Double,

    /**
     * Merchant agreement that instantiated this merchant account.
     */
    val MerchantAgreement: String,

    /**
     * All transactors this merchant account is registered with.
     */
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
    val currentBalance = parse_element (element ("""MerchantAccount.currentBalance"""))_
    val provisionalBalance = parse_element (element ("""MerchantAccount.provisionalBalance"""))_
    val MerchantAgreement = parse_attribute (attribute ("""MerchantAccount.MerchantAgreement"""))_
    val Transactors = parse_attributes (attribute ("""MerchantAccount.Transactors"""))_
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
 */
case class MerchantAgreement
(

    override val sup: Agreement
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
 */
case class PointOfSale
(

    override val sup: IdentifiedObject,

    /**
     * Local description for where this point of sale is physically located.
     */
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
    val location = parse_element (element ("""PointOfSale.location"""))_
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
 */
case class Receipt
(

    override val sup: IdentifiedObject,

    /**
     * True if this receipted payment is manually bankable, otherwise it is an electronic funds transfer.
     */
    val isBankable: Boolean,

    /**
     * Receipted amount with rounding, date and note.
     */
    val line: String,

    /**
     * Cashier shift during which this receipt was recorded.
     */
    val CashierShift: String,

    /**
     * Vendor shift during which this receipt was recorded.
     */
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
    val isBankable = parse_element (element ("""Receipt.isBankable"""))_
    val line = parse_attribute (attribute ("""Receipt.line"""))_
    val CashierShift = parse_attribute (attribute ("""Receipt.CashierShift"""))_
    val VendorShift = parse_attribute (attribute ("""Receipt.VendorShift"""))_
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
 */
case class ServiceSupplier
(

    override val sup: OrganisationRole,

    /**
     * Unique transaction reference prefix number issued to an entity by the International Organization for Standardization for the purpose of tagging onto electronic financial transactions, as defined in ISO/IEC 7812-1 and ISO/IEC 7812-2.
     */
    val issuerIdentificationNumber: String,

    /**
     * Kind of supplier.
     */
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
    val issuerIdentificationNumber = parse_element (element ("""ServiceSupplier.issuerIdentificationNumber"""))_
    val kind = parse_attribute (attribute ("""ServiceSupplier.kind"""))_
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
 */
case class Shift
(

    override val sup: IdentifiedObject,

    /**
     * Interval for activity of this shift.
     */
    val activityInterval: String,

    /**
     * Total of amounts receipted during this shift that can be manually banked (cash and cheques for example).
     * Values are obtained from Receipt attributes:
     */
    val receiptsGrandTotalBankable: Double,

    /**
     * Total of amounts receipted during this shift that cannot be manually banked (card payments for example).
     * Values are obtained from Receipt attributes:
     */
    val receiptsGrandTotalNonBankable: Double,

    /**
     * Cumulative amount in error due to process rounding not reflected in receiptsGrandTotal.
     * Values are obtained from Receipt attributes:
     */
    val receiptsGrandTotalRounding: Double,

    /**
     * Cumulative total of transacted amounts during this shift.
     * Values are obtained from transaction:
     */
    val transactionsGrandTotal: Double,

    /**
     * Cumulative amount in error due to process rounding not reflected in transactionsGandTotal.
     * Values are obtained from Transaction attributes:
     */
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
    val activityInterval = parse_attribute (attribute ("""Shift.activityInterval"""))_
    val receiptsGrandTotalBankable = parse_element (element ("""Shift.receiptsGrandTotalBankable"""))_
    val receiptsGrandTotalNonBankable = parse_element (element ("""Shift.receiptsGrandTotalNonBankable"""))_
    val receiptsGrandTotalRounding = parse_element (element ("""Shift.receiptsGrandTotalRounding"""))_
    val transactionsGrandTotal = parse_element (element ("""Shift.transactionsGrandTotal"""))_
    val transactionsGrandTotalRounding = parse_element (element ("""Shift.transactionsGrandTotalRounding"""))_
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
 */
case class SupplierKind
(

    override val sup: BasicElement,

    /**
     * Other kind of supplier.
     */
    val other: String,

    /**
     * Entity that sells the service, but does not deliver to the customer; applies to the deregulated markets.
     */
    val retailer: String,

    /**
     * Entity that delivers the service to the customer.
     */
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
    val other = parse_attribute (attribute ("""SupplierKind.other"""))_
    val retailer = parse_attribute (attribute ("""SupplierKind.retailer"""))_
    val utility = parse_attribute (attribute ("""SupplierKind.utility"""))_
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
 */
case class TariffProfile
(

    override val sup: Document,

    /**
     * The frequency at which the tariff charge schedule is repeated.
     * Examples are: once off on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc. At the end of each cycle, the business rules are reset to start from the beginning again.
     */
    val tariffCycle: String,

    /**
     * All consumption tariff intervals used to define this tariff profile.
     */
    val ConsumptionTariffIntervals: List[String],

    /**
     * All time tariff intervals used to define this tariff profile.
     */
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
    val tariffCycle = parse_element (element ("""TariffProfile.tariffCycle"""))_
    val ConsumptionTariffIntervals = parse_attributes (attribute ("""TariffProfile.ConsumptionTariffIntervals"""))_
    val TimeTariffIntervals = parse_attributes (attribute ("""TariffProfile.TimeTariffIntervals"""))_
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
 */
case class Tender
(

    override val sup: IdentifiedObject,

    /**
     * Amount tendered by customer.
     */
    val amount: Double,

    /**
     * Difference between amount tendered by customer and the amount charged by point of sale.
     */
    val change: Double,

    /**
     * Kind of tender from customer.
     */
    val kind: String,

    /**
     * Card used to tender payment.
     */
    val Card: String,

    /**
     * Cheque used to tender payment.
     */
    val Cheque: String,

    /**
     * Receipt that recorded this receiving of a payment in the form of tenders.
     */
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
    val amount = parse_element (element ("""Tender.amount"""))_
    val change = parse_element (element ("""Tender.change"""))_
    val kind = parse_attribute (attribute ("""Tender.kind"""))_
    val Card = parse_attribute (attribute ("""Tender.Card"""))_
    val Cheque = parse_attribute (attribute ("""Tender.Cheque"""))_
    val Receipt = parse_attribute (attribute ("""Tender.Receipt"""))_
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
 */
case class TenderKind
(

    override val sup: BasicElement,

    /**
     * Payment method by means of a credit or debit card.
     */
    val card: String,

    /**
     * Payment method by means of cash.
     */
    val cash: String,

    /**
     * Payment method by means of a cheque.
     */
    val cheque: String,

    /**
     * Other payment method such as electronic finds transfer.
     */
    val other: String,

    /**
     * Payment method is not known.
     */
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
    val card = parse_attribute (attribute ("""TenderKind.card"""))_
    val cash = parse_attribute (attribute ("""TenderKind.cash"""))_
    val cheque = parse_attribute (attribute ("""TenderKind.cheque"""))_
    val other = parse_attribute (attribute ("""TenderKind.other"""))_
    val unspecified = parse_attribute (attribute ("""TenderKind.unspecified"""))_
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
 */
case class TimeTariffInterval
(

    override val sup: BasicElement,

    /**
     * A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
     */
    val sequenceNumber: Int,

    /**
     * A real time marker that defines the starting time (typically it is the time of day) for this interval.
     * The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
     */
    val startTime: String,

    /**
     * All charges used to define this time tariff interval.
     */
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
    val sequenceNumber = parse_element (element ("""TimeTariffInterval.sequenceNumber"""))_
    val startTime = parse_element (element ("""TimeTariffInterval.startTime"""))_
    val Charges = parse_attributes (attribute ("""TimeTariffInterval.Charges"""))_
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
 */
case class Transaction
(

    override val sup: IdentifiedObject,

    /**
     * Formal reference for use with diverse payment (traffic fine for example).
     */
    val diverseReference: String,

    /**
     * Reference to the entity that is the source of 'amount' (for example: customer for token purchase; or supplier for free issue token).
     */
    val donorReference: String,

    /**
     * Kind of transaction.
     */
    val kind: String,

    /**
     * Transaction amount, rounding, date and note for this transaction line.
     */
    val line: String,

    /**
     * Reference to the entity that is the recipient of 'amount' (for example, supplier for service charge payment; or tax receiver for VAT).
     */
    val receiverReference: String,

    /**
     * (if 'kind' is transactionReversal) Reference to the original transaction that is being reversed by this transaction.
     */
    val reversedId: String,

    /**
     * Actual amount of service units that is being paid for.
     */
    val serviceUnitsEnergy: Double,

    /**
     * Number of service units not reflected in 'serviceUnitsEnergy' due to process rounding or truncating errors.
     */
    val serviceUnitsError: Double,

    /**
     * Auxiliary account for this payment transaction.
     */
    val AuxiliaryAccount: String,

    /**
     * Cashier shift during which this transaction was recorded.
     */
    val CashierShift: String,

    /**
     * Customer account for this payment transaction.
     */
    val CustomerAccount: String,

    /**
     * Meter for this vending transaction.
     */
    val Meter: String,

    /**
     * Pricing structure applicable for this transaction.
     */
    val PricingStructure: String,

    /**
     * The receipted payment for which this transaction has been recorded.
     */
    val Receipt: String,

    /**
     * Vendor shift during which this transaction was recorded.
     */
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
    val diverseReference = parse_element (element ("""Transaction.diverseReference"""))_
    val donorReference = parse_element (element ("""Transaction.donorReference"""))_
    val kind = parse_attribute (attribute ("""Transaction.kind"""))_
    val line = parse_attribute (attribute ("""Transaction.line"""))_
    val receiverReference = parse_element (element ("""Transaction.receiverReference"""))_
    val reversedId = parse_element (element ("""Transaction.reversedId"""))_
    val serviceUnitsEnergy = parse_element (element ("""Transaction.serviceUnitsEnergy"""))_
    val serviceUnitsError = parse_element (element ("""Transaction.serviceUnitsError"""))_
    val AuxiliaryAccount = parse_attribute (attribute ("""Transaction.AuxiliaryAccount"""))_
    val CashierShift = parse_attribute (attribute ("""Transaction.CashierShift"""))_
    val CustomerAccount = parse_attribute (attribute ("""Transaction.CustomerAccount"""))_
    val Meter = parse_attribute (attribute ("""Transaction.Meter"""))_
    val PricingStructure = parse_attribute (attribute ("""Transaction.PricingStructure"""))_
    val Receipt = parse_attribute (attribute ("""Transaction.Receipt"""))_
    val VendorShift = parse_attribute (attribute ("""Transaction.VendorShift"""))_
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
 */
case class TransactionKind
(

    override val sup: BasicElement,

    /**
     * Payment against a specified account.
     */
    val accountPayment: String,

    /**
     * Payment against a specified auxiliary account.
     */
    val auxiliaryChargePayment: String,

    /**
     * Payment against an item other than an account.
     */
    val diversePayment: String,

    /**
     * Issue of token that will alter the meter configuration.
     */
    val meterConfigurationToken: String,

    /**
     * Other kind of transaction.
     */
    val other: String,

    /**
     * Payment for a service.
     */
    val serviceChargePayment: String,

    /**
     * Payment for a tax.
     */
    val taxChargePayment: String,

    /**
     * Cancellation of a previously issued token.
     */
    val tokenCancellation: String,

    /**
     * Exchange of a previously issued token for a new token.
     */
    val tokenExchange: String,

    /**
     * Issue of a free credit token where the donor is the supplier.
     */
    val tokenFreeIssue: String,

    /**
     * Issue of a free credit token where the donor is a 3<sup>rd</sup> party.
     */
    val tokenGrant: String,

    /**
     * Payment for a credit token sale to a customer.
     */
    val tokenSalePayment: String,

    /**
     * Reversal of a previous transaction.
     */
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
    val accountPayment = parse_attribute (attribute ("""TransactionKind.accountPayment"""))_
    val auxiliaryChargePayment = parse_attribute (attribute ("""TransactionKind.auxiliaryChargePayment"""))_
    val diversePayment = parse_attribute (attribute ("""TransactionKind.diversePayment"""))_
    val meterConfigurationToken = parse_attribute (attribute ("""TransactionKind.meterConfigurationToken"""))_
    val other = parse_attribute (attribute ("""TransactionKind.other"""))_
    val serviceChargePayment = parse_attribute (attribute ("""TransactionKind.serviceChargePayment"""))_
    val taxChargePayment = parse_attribute (attribute ("""TransactionKind.taxChargePayment"""))_
    val tokenCancellation = parse_attribute (attribute ("""TransactionKind.tokenCancellation"""))_
    val tokenExchange = parse_attribute (attribute ("""TransactionKind.tokenExchange"""))_
    val tokenFreeIssue = parse_attribute (attribute ("""TransactionKind.tokenFreeIssue"""))_
    val tokenGrant = parse_attribute (attribute ("""TransactionKind.tokenGrant"""))_
    val tokenSalePayment = parse_attribute (attribute ("""TransactionKind.tokenSalePayment"""))_
    val transactionReversal = parse_attribute (attribute ("""TransactionKind.transactionReversal"""))_
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
 */
case class Transactor
(

    override val sup: IdentifiedObject
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
 */
case class Vendor
(

    override val sup: IdentifiedObject
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
 */
case class VendorShift
(

    override val sup: Shift,

    /**
     * The amount that is to be debited from the merchant account for this vendor shift.
     * This amount reflects the sum(PaymentTransaction.transactionAmount).
     */
    val merchantDebitAmount: Double,

    /**
     * If true, merchantDebitAmount has been debited from MerchantAccount; typically happens at the end of VendorShift when it closes.
     */
    val posted: Boolean,

    /**
     * Merchant account this vendor shift periodically debits (based on aggregated transactions).
     */
    val MerchantAccount: String,

    /**
     * Vendor that opens and owns this vendor shift.
     */
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
    val merchantDebitAmount = parse_element (element ("""VendorShift.merchantDebitAmount"""))_
    val posted = parse_element (element ("""VendorShift.posted"""))_
    val MerchantAccount = parse_attribute (attribute ("""VendorShift.MerchantAccount"""))_
    val Vendor = parse_attribute (attribute ("""VendorShift.Vendor"""))_
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