package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package is used to define detailed customer models.
 */

/**
 * Compliance events are used for reporting regulatory or contract compliance issues and/or variances.
 * These might be created as a consequence of local business processes and associated rules. It is anticipated that this class will be customised extensively to meet local implementation needs.
 * @param sup Reference to the superclass object.
 * @param deadline The deadline for compliance.
 */
case class ComplianceEvent
(override val sup: ActivityRecord,
val deadline: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[ComplianceEvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ComplianceEvent
extends
    Parseable[ComplianceEvent]
{
    val sup = ActivityRecord.parse _
    val deadline = parse_element (element ("""ComplianceEvent.deadline"""))_
    def parse (context: Context): ComplianceEvent =
    {
        ComplianceEvent(
            sup (context),
            deadline (context)
        )
    }
}

/**
 * The creation of the monthly customer billing statements is the method employed to notify Customers of charges, adjustments and credits applied to their account for Services and Products.
 * The actuall billing occurs through an ErpInvoice. The CustomerBillingInfo includes information from the payment, collection, meter reading, installed meter, service, site, customer, customer account, customer agreement, services and pricing subject areas. Each component price shows up as a separate line item on the ErpInvoice.
 * @param sup Reference to the superclass object.
 * @param billingDate Business date designated for the billing run which produced this CustomerBillingInfo.
 * @param dueDate Calculated date upon which a customer billing amount is due, used in the invoicing process to determine when a Customer's Payment is delinquent.
 *        It takes into consideration the regulatory criteria and the Customer's requested due date. In the absence of a Customer requested due date, the due date is typically calculated from the regulated number of days and the 'billingDate'.
 * @param kind Kind of bill customer receives.
 * @param lastPaymentAmt Amount of the last payment received from the customer.
 *        It is retained in the Customer Billing system, although the details of each payment are tracked in the ERP system.
 * @param lastPaymentDate Date of the last payment received from the customer.
 *        It is retained in the Customer Billing system, although the details of each payment are tracked in the ERP system.
 * @param outBalance Outstanding balance on the CustomerAccount as of the statement date.
 * @param pymtPlanAmt Monthly amortized amount due during each billing cycle for the CustomerAccount balance for which the Payment Plan is set-up.
 * @param pymtPlanType Type of payment plan.
 * @param CustomerAccount
 * @param ErpInvoiceLineItems
 */
case class CustomerBillingInfo
(override val sup: Document,
val billingDate: String,
val dueDate: String,
val kind: String,
val lastPaymentAmt: Double,
val lastPaymentDate: String,
val outBalance: Double,
val pymtPlanAmt: Double,
val pymtPlanType: String,
val CustomerAccount: String,
val ErpInvoiceLineItems: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null, 0.0, 0.0, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerBillingInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerBillingInfo
extends
    Parseable[CustomerBillingInfo]
{
    val sup = Document.parse _
    val billingDate = parse_element (element ("""CustomerBillingInfo.billingDate"""))_
    val dueDate = parse_element (element ("""CustomerBillingInfo.dueDate"""))_
    val kind = parse_attribute (attribute ("""CustomerBillingInfo.kind"""))_
    val lastPaymentAmt = parse_element (element ("""CustomerBillingInfo.lastPaymentAmt"""))_
    val lastPaymentDate = parse_element (element ("""CustomerBillingInfo.lastPaymentDate"""))_
    val outBalance = parse_element (element ("""CustomerBillingInfo.outBalance"""))_
    val pymtPlanAmt = parse_element (element ("""CustomerBillingInfo.pymtPlanAmt"""))_
    val pymtPlanType = parse_element (element ("""CustomerBillingInfo.pymtPlanType"""))_
    val CustomerAccount = parse_attribute (attribute ("""CustomerBillingInfo.CustomerAccount"""))_
    val ErpInvoiceLineItems = parse_attributes (attribute ("""CustomerBillingInfo.ErpInvoiceLineItems"""))_
    def parse (context: Context): CustomerBillingInfo =
    {
        CustomerBillingInfo(
            sup (context),
            billingDate (context),
            dueDate (context),
            kind (context),
            toDouble (lastPaymentAmt (context), context),
            lastPaymentDate (context),
            toDouble (outBalance (context), context),
            toDouble (pymtPlanAmt (context), context),
            pymtPlanType (context),
            CustomerAccount (context),
            ErpInvoiceLineItems (context)
        )
    }
}

/**
 * Kind of customer billing.
 * @param sup Reference to the superclass object.
 * @param consolidatedEss Consolidated bill from energy service supplier (ESS).
 * @param consolidatedUdc Consolidated bill from utility distribution company (UDC).
 * @param other
 * @param separateEssUdc Separate bills from ESS and UDC.
 */
case class CustomerBillingKind
(override val sup: BasicElement,
val consolidatedEss: String,
val consolidatedUdc: String,
val other: String,
val separateEssUdc: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerBillingKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerBillingKind
extends
    Parseable[CustomerBillingKind]
{
    val sup = BasicElement.parse _
    val consolidatedEss = parse_attribute (attribute ("""CustomerBillingKind.consolidatedEss"""))_
    val consolidatedUdc = parse_attribute (attribute ("""CustomerBillingKind.consolidatedUdc"""))_
    val other = parse_attribute (attribute ("""CustomerBillingKind.other"""))_
    val separateEssUdc = parse_attribute (attribute ("""CustomerBillingKind.separateEssUdc"""))_
    def parse (context: Context): CustomerBillingKind =
    {
        CustomerBillingKind(
            sup (context),
            consolidatedEss (context),
            consolidatedUdc (context),
            other (context),
            separateEssUdc (context)
        )
    }
}

/**
 * A type of customer agreement involving an external agency.
 * For example, a customer may form a contracts with an Energy Service Supplier if Direct Access is permitted.
 * @param sup Reference to the superclass object.
 */
case class ExternalCustomerAgreement
(override val sup: Agreement
)
extends
    Element
{
    def this () = { this (null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[ExternalCustomerAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExternalCustomerAgreement
extends
    Parseable[ExternalCustomerAgreement]
{
    val sup = Agreement.parse _
    def parse (context: Context): ExternalCustomerAgreement =
    {
        ExternalCustomerAgreement(
            sup (context)
        )
    }
}

/**
 * Pricing can be based on power quality.
 * @param sup Reference to the superclass object.
 * @param emergencyHighVoltLimit Emergency high voltage limit.
 * @param emergencyLowVoltLimit Emergency low voltage limit.
 * @param normalHighVoltLimit Normal high voltage limit.
 * @param normalLowVoltLimit Normal low voltage limit.
 * @param powerFactorMin Threshold minimum power factor for this PricingStructure, specified in instances where a special charge is levied if the actual power factor for a Service falls below the value specified here.
 * @param valueUninterruptedServiceEnergy Value of uninterrupted service (Cost per energy).
 * @param valueUninterruptedServiceP Value of uninterrupted service (Cost per active power).
 * @param voltImbalanceViolCost Voltage imbalance violation cost (Cost per unit Voltage).
 * @param voltLimitViolCost Voltage limit violation cost (Cost per unit Voltage).
 */
case class PowerQualityPricing
(override val sup: Document,
val emergencyHighVoltLimit: Double,
val emergencyLowVoltLimit: Double,
val normalHighVoltLimit: Double,
val normalLowVoltLimit: Double,
val powerFactorMin: Double,
val valueUninterruptedServiceEnergy: Double,
val valueUninterruptedServiceP: Double,
val voltImbalanceViolCost: Double,
val voltLimitViolCost: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerQualityPricing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerQualityPricing
extends
    Parseable[PowerQualityPricing]
{
    val sup = Document.parse _
    val emergencyHighVoltLimit = parse_element (element ("""PowerQualityPricing.emergencyHighVoltLimit"""))_
    val emergencyLowVoltLimit = parse_element (element ("""PowerQualityPricing.emergencyLowVoltLimit"""))_
    val normalHighVoltLimit = parse_element (element ("""PowerQualityPricing.normalHighVoltLimit"""))_
    val normalLowVoltLimit = parse_element (element ("""PowerQualityPricing.normalLowVoltLimit"""))_
    val powerFactorMin = parse_element (element ("""PowerQualityPricing.powerFactorMin"""))_
    val valueUninterruptedServiceEnergy = parse_element (element ("""PowerQualityPricing.valueUninterruptedServiceEnergy"""))_
    val valueUninterruptedServiceP = parse_element (element ("""PowerQualityPricing.valueUninterruptedServiceP"""))_
    val voltImbalanceViolCost = parse_element (element ("""PowerQualityPricing.voltImbalanceViolCost"""))_
    val voltLimitViolCost = parse_element (element ("""PowerQualityPricing.voltLimitViolCost"""))_
    def parse (context: Context): PowerQualityPricing =
    {
        PowerQualityPricing(
            sup (context),
            toDouble (emergencyHighVoltLimit (context), context),
            toDouble (emergencyLowVoltLimit (context), context),
            toDouble (normalHighVoltLimit (context), context),
            toDouble (normalLowVoltLimit (context), context),
            toDouble (powerFactorMin (context), context),
            toDouble (valueUninterruptedServiceEnergy (context), context),
            toDouble (valueUninterruptedServiceP (context), context),
            toDouble (voltImbalanceViolCost (context), context),
            toDouble (voltLimitViolCost (context), context)
        )
    }
}

/**
 * A service guarantee, often imposed by a regulator, defines conditions that, if not satisfied, will result in the utility making a monetary payment to the customer.
 * Note that guarantee's identifier is in the 'name' attribute and the status of the guarantee is in the 'Status.status' attribute.
 * @param sup Reference to the superclass object.
 * @param applicationPeriod Period in which this service guantee applies.
 * @param automaticPay True if utility must autmatically pay the specified amount whenever the condition is not satisified, otherwise customer must make a claim to receive payment.
 * @param payAmount Amount to be paid by the service provider to the customer for each violation of the 'serviceRequirement'.
 * @param serviceRequirement Explanation of the requirement and conditions for satisfying it.
 */
case class ServiceGuarantee
(override val sup: Document,
val applicationPeriod: String,
val automaticPay: Boolean,
val payAmount: Double,
val serviceRequirement: String
)
extends
    Element
{
    def this () = { this (null, null, false, 0.0, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceGuarantee]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceGuarantee
extends
    Parseable[ServiceGuarantee]
{
    val sup = Document.parse _
    val applicationPeriod = parse_attribute (attribute ("""ServiceGuarantee.applicationPeriod"""))_
    val automaticPay = parse_element (element ("""ServiceGuarantee.automaticPay"""))_
    val payAmount = parse_element (element ("""ServiceGuarantee.payAmount"""))_
    val serviceRequirement = parse_element (element ("""ServiceGuarantee.serviceRequirement"""))_
    def parse (context: Context): ServiceGuarantee =
    {
        ServiceGuarantee(
            sup (context),
            applicationPeriod (context),
            toBoolean (automaticPay (context), context),
            toDouble (payAmount (context), context),
            serviceRequirement (context)
        )
    }
}

/**
 * The Standard Industrial Classification (SIC) are the codes that identify the type of products/service an industry is involved in, and used for statutory reporting purposes.
 * For example, in the USA these codes are located by the federal government, and then published in a book entitled "The Standard Industrial Classification Manual". The codes are arranged in a hierarchical structure.
 * @param sup Reference to the superclass object.
 * @param code Standard alphanumeric code assigned to a particular product/service within an industry.
 */
case class StandardIndustryCode
(override val sup: Document,
val code: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[StandardIndustryCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StandardIndustryCode
extends
    Parseable[StandardIndustryCode]
{
    val sup = Document.parse _
    val code = parse_element (element ("""StandardIndustryCode.code"""))_
    def parse (context: Context): StandardIndustryCode =
    {
        StandardIndustryCode(
            sup (context),
            code (context)
        )
    }
}

/**
 * Price curve for specifying the cost of energy (X) at points in time (y1) according to a prcing structure, which is based on a tariff.
 * @param sup Reference to the superclass object.
 */
case class SubscribePowerCurve
(override val sup: Curve
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[SubscribePowerCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SubscribePowerCurve
extends
    Parseable[SubscribePowerCurve]
{
    val sup = Curve.parse _
    def parse (context: Context): SubscribePowerCurve =
    {
        SubscribePowerCurve(
            sup (context)
        )
    }
}

/**
 * Billing information for work performed for the customer.
 * The history of Work Billing Info, Invoices, and Payments is to be maintained in associated ActivityRecords.
 * @param sup Reference to the superclass object.
 * @param costEstimate Estimated cost for work.
 * @param deposit Amount of price on deposit.
 * @param discount Discount from standard price.
 * @param dueDateTime Date and time by which payment for bill is expected from client.
 * @param issueDateTime Date and time bill was issued to client.
 * @param receivedDateTime Date payment was received from client.
 * @param workPrice Amount of bill.
 * @param CustomerAccount
 * @param ErpLineItems
 */
case class WorkBillingInfo
(override val sup: Document,
val costEstimate: Double,
val deposit: Double,
val discount: Double,
val dueDateTime: String,
val issueDateTime: String,
val receivedDateTime: String,
val workPrice: Double,
val CustomerAccount: String,
val ErpLineItems: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, 0.0, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkBillingInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkBillingInfo
extends
    Parseable[WorkBillingInfo]
{
    val sup = Document.parse _
    val costEstimate = parse_element (element ("""WorkBillingInfo.costEstimate"""))_
    val deposit = parse_element (element ("""WorkBillingInfo.deposit"""))_
    val discount = parse_element (element ("""WorkBillingInfo.discount"""))_
    val dueDateTime = parse_element (element ("""WorkBillingInfo.dueDateTime"""))_
    val issueDateTime = parse_element (element ("""WorkBillingInfo.issueDateTime"""))_
    val receivedDateTime = parse_element (element ("""WorkBillingInfo.receivedDateTime"""))_
    val workPrice = parse_element (element ("""WorkBillingInfo.workPrice"""))_
    val CustomerAccount = parse_attribute (attribute ("""WorkBillingInfo.CustomerAccount"""))_
    val ErpLineItems = parse_attributes (attribute ("""WorkBillingInfo.ErpLineItems"""))_
    def parse (context: Context): WorkBillingInfo =
    {
        WorkBillingInfo(
            sup (context),
            toDouble (costEstimate (context), context),
            toDouble (deposit (context), context),
            toDouble (discount (context), context),
            dueDateTime (context),
            issueDateTime (context),
            receivedDateTime (context),
            toDouble (workPrice (context), context),
            CustomerAccount (context),
            ErpLineItems (context)
        )
    }
}

object _InfCustomers
{
    def register: Unit =
    {
        ComplianceEvent.register
        CustomerBillingInfo.register
        CustomerBillingKind.register
        ExternalCustomerAgreement.register
        PowerQualityPricing.register
        ServiceGuarantee.register
        StandardIndustryCode.register
        SubscribePowerCurve.register
        WorkBillingInfo.register
    }
}