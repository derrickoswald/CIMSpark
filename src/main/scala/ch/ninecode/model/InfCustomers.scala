package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Compliance events are used for reporting regulatory or contract compliance issues and/or variances.
 * These might be created as a consequence of local business processes and associated rules. It is anticipated that this class will be customised extensively to meet local implementation needs.
 *
 * @param sup Reference to the superclass object.
 * @param deadline The deadline for compliance.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class ComplianceEvent
(
    override val sup: ActivityRecord,
    deadline: String
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
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[ComplianceEvent] }
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
        (if (null != deadline) "\t\t<cim:ComplianceEvent.deadline>" + deadline + "</cim:ComplianceEvent.deadline>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ComplianceEvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ComplianceEvent>"
    }
}

object ComplianceEvent
extends
    Parseable[ComplianceEvent]
{
    val deadline = parse_element (element ("""ComplianceEvent.deadline"""))
    def parse (context: Context): ComplianceEvent =
    {
        ComplianceEvent(
            ActivityRecord.parse (context),
            deadline (context)
        )
    }
}

/**
 * The creation of the monthly customer billing statements is the method employed to notify Customers of charges, adjustments and credits applied to their account for Services and Products.
 * The actuall billing occurs through an ErpInvoice. The CustomerBillingInfo includes information from the payment, collection, meter reading, installed meter, service, site, customer, customer account, customer agreement, services and pricing subject areas. Each component price shows up as a separate line item on the ErpInvoice.
 *
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
 * @param CustomerAccount <em>undocumented</em>
 * @param ErpInvoiceLineItems <em>undocumented</em>
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class CustomerBillingInfo
(
    override val sup: Document,
    billingDate: String,
    dueDate: String,
    kind: String,
    lastPaymentAmt: Double,
    lastPaymentDate: String,
    outBalance: Double,
    pymtPlanAmt: Double,
    pymtPlanType: String,
    CustomerAccount: String,
    ErpInvoiceLineItems: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0.0, null, 0.0, 0.0, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[CustomerBillingInfo] }
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
        (if (null != billingDate) "\t\t<cim:CustomerBillingInfo.billingDate>" + billingDate + "</cim:CustomerBillingInfo.billingDate>\n" else "") +
        (if (null != dueDate) "\t\t<cim:CustomerBillingInfo.dueDate>" + dueDate + "</cim:CustomerBillingInfo.dueDate>\n" else "") +
        (if (null != kind) "\t\t<cim:CustomerBillingInfo.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:CustomerBillingInfo.lastPaymentAmt>" + lastPaymentAmt + "</cim:CustomerBillingInfo.lastPaymentAmt>\n" +
        (if (null != lastPaymentDate) "\t\t<cim:CustomerBillingInfo.lastPaymentDate>" + lastPaymentDate + "</cim:CustomerBillingInfo.lastPaymentDate>\n" else "") +
        "\t\t<cim:CustomerBillingInfo.outBalance>" + outBalance + "</cim:CustomerBillingInfo.outBalance>\n" +
        "\t\t<cim:CustomerBillingInfo.pymtPlanAmt>" + pymtPlanAmt + "</cim:CustomerBillingInfo.pymtPlanAmt>\n" +
        (if (null != pymtPlanType) "\t\t<cim:CustomerBillingInfo.pymtPlanType>" + pymtPlanType + "</cim:CustomerBillingInfo.pymtPlanType>\n" else "") +
        (if (null != CustomerAccount) "\t\t<cim:CustomerBillingInfo.CustomerAccount rdf:resource=\"#" + CustomerAccount + "\"/>\n" else "") +
        (if (null != ErpInvoiceLineItems) ErpInvoiceLineItems.map (x => "\t\t<cim:CustomerBillingInfo.ErpInvoiceLineItems rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:CustomerBillingInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CustomerBillingInfo>"
    }
}

object CustomerBillingInfo
extends
    Parseable[CustomerBillingInfo]
{
    val billingDate = parse_element (element ("""CustomerBillingInfo.billingDate"""))
    val dueDate = parse_element (element ("""CustomerBillingInfo.dueDate"""))
    val kind = parse_attribute (attribute ("""CustomerBillingInfo.kind"""))
    val lastPaymentAmt = parse_element (element ("""CustomerBillingInfo.lastPaymentAmt"""))
    val lastPaymentDate = parse_element (element ("""CustomerBillingInfo.lastPaymentDate"""))
    val outBalance = parse_element (element ("""CustomerBillingInfo.outBalance"""))
    val pymtPlanAmt = parse_element (element ("""CustomerBillingInfo.pymtPlanAmt"""))
    val pymtPlanType = parse_element (element ("""CustomerBillingInfo.pymtPlanType"""))
    val CustomerAccount = parse_attribute (attribute ("""CustomerBillingInfo.CustomerAccount"""))
    val ErpInvoiceLineItems = parse_attributes (attribute ("""CustomerBillingInfo.ErpInvoiceLineItems"""))
    def parse (context: Context): CustomerBillingInfo =
    {
        CustomerBillingInfo(
            Document.parse (context),
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
 * A type of customer agreement involving an external agency.
 * For example, a customer may form a contracts with an Energy Service Supplier if Direct Access is permitted.
 *
 * @param sup Reference to the superclass object.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class ExternalCustomerAgreement
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
    override def copy (): Row = { clone ().asInstanceOf[ExternalCustomerAgreement] }
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
        "\t<cim:ExternalCustomerAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExternalCustomerAgreement>"
    }
}

object ExternalCustomerAgreement
extends
    Parseable[ExternalCustomerAgreement]
{
    def parse (context: Context): ExternalCustomerAgreement =
    {
        ExternalCustomerAgreement(
            Agreement.parse (context)
        )
    }
}

/**
 * Pricing can be based on power quality.
 *
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
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class PowerQualityPricing
(
    override val sup: Document,
    emergencyHighVoltLimit: Double,
    emergencyLowVoltLimit: Double,
    normalHighVoltLimit: Double,
    normalLowVoltLimit: Double,
    powerFactorMin: Double,
    valueUninterruptedServiceEnergy: Double,
    valueUninterruptedServiceP: Double,
    voltImbalanceViolCost: Double,
    voltLimitViolCost: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[PowerQualityPricing] }
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
        "\t\t<cim:PowerQualityPricing.emergencyHighVoltLimit>" + emergencyHighVoltLimit + "</cim:PowerQualityPricing.emergencyHighVoltLimit>\n" +
        "\t\t<cim:PowerQualityPricing.emergencyLowVoltLimit>" + emergencyLowVoltLimit + "</cim:PowerQualityPricing.emergencyLowVoltLimit>\n" +
        "\t\t<cim:PowerQualityPricing.normalHighVoltLimit>" + normalHighVoltLimit + "</cim:PowerQualityPricing.normalHighVoltLimit>\n" +
        "\t\t<cim:PowerQualityPricing.normalLowVoltLimit>" + normalLowVoltLimit + "</cim:PowerQualityPricing.normalLowVoltLimit>\n" +
        "\t\t<cim:PowerQualityPricing.powerFactorMin>" + powerFactorMin + "</cim:PowerQualityPricing.powerFactorMin>\n" +
        "\t\t<cim:PowerQualityPricing.valueUninterruptedServiceEnergy>" + valueUninterruptedServiceEnergy + "</cim:PowerQualityPricing.valueUninterruptedServiceEnergy>\n" +
        "\t\t<cim:PowerQualityPricing.valueUninterruptedServiceP>" + valueUninterruptedServiceP + "</cim:PowerQualityPricing.valueUninterruptedServiceP>\n" +
        "\t\t<cim:PowerQualityPricing.voltImbalanceViolCost>" + voltImbalanceViolCost + "</cim:PowerQualityPricing.voltImbalanceViolCost>\n" +
        "\t\t<cim:PowerQualityPricing.voltLimitViolCost>" + voltLimitViolCost + "</cim:PowerQualityPricing.voltLimitViolCost>\n"
    }
    override def export: String =
    {
        "\t<cim:PowerQualityPricing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerQualityPricing>"
    }
}

object PowerQualityPricing
extends
    Parseable[PowerQualityPricing]
{
    val emergencyHighVoltLimit = parse_element (element ("""PowerQualityPricing.emergencyHighVoltLimit"""))
    val emergencyLowVoltLimit = parse_element (element ("""PowerQualityPricing.emergencyLowVoltLimit"""))
    val normalHighVoltLimit = parse_element (element ("""PowerQualityPricing.normalHighVoltLimit"""))
    val normalLowVoltLimit = parse_element (element ("""PowerQualityPricing.normalLowVoltLimit"""))
    val powerFactorMin = parse_element (element ("""PowerQualityPricing.powerFactorMin"""))
    val valueUninterruptedServiceEnergy = parse_element (element ("""PowerQualityPricing.valueUninterruptedServiceEnergy"""))
    val valueUninterruptedServiceP = parse_element (element ("""PowerQualityPricing.valueUninterruptedServiceP"""))
    val voltImbalanceViolCost = parse_element (element ("""PowerQualityPricing.voltImbalanceViolCost"""))
    val voltLimitViolCost = parse_element (element ("""PowerQualityPricing.voltLimitViolCost"""))
    def parse (context: Context): PowerQualityPricing =
    {
        PowerQualityPricing(
            Document.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param applicationPeriod Period in which this service guantee applies.
 * @param automaticPay True if utility must autmatically pay the specified amount whenever the condition is not satisified, otherwise customer must make a claim to receive payment.
 * @param payAmount Amount to be paid by the service provider to the customer for each violation of the 'serviceRequirement'.
 * @param serviceRequirement Explanation of the requirement and conditions for satisfying it.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class ServiceGuarantee
(
    override val sup: Document,
    applicationPeriod: String,
    automaticPay: Boolean,
    payAmount: Double,
    serviceRequirement: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[ServiceGuarantee] }
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
        (if (null != applicationPeriod) "\t\t<cim:ServiceGuarantee.applicationPeriod rdf:resource=\"#" + applicationPeriod + "\"/>\n" else "") +
        "\t\t<cim:ServiceGuarantee.automaticPay>" + automaticPay + "</cim:ServiceGuarantee.automaticPay>\n" +
        "\t\t<cim:ServiceGuarantee.payAmount>" + payAmount + "</cim:ServiceGuarantee.payAmount>\n" +
        (if (null != serviceRequirement) "\t\t<cim:ServiceGuarantee.serviceRequirement>" + serviceRequirement + "</cim:ServiceGuarantee.serviceRequirement>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ServiceGuarantee rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServiceGuarantee>"
    }
}

object ServiceGuarantee
extends
    Parseable[ServiceGuarantee]
{
    val applicationPeriod = parse_attribute (attribute ("""ServiceGuarantee.applicationPeriod"""))
    val automaticPay = parse_element (element ("""ServiceGuarantee.automaticPay"""))
    val payAmount = parse_element (element ("""ServiceGuarantee.payAmount"""))
    val serviceRequirement = parse_element (element ("""ServiceGuarantee.serviceRequirement"""))
    def parse (context: Context): ServiceGuarantee =
    {
        ServiceGuarantee(
            Document.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param code Standard alphanumeric code assigned to a particular product/service within an industry.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class StandardIndustryCode
(
    override val sup: Document,
    code: String
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[StandardIndustryCode] }
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
        (if (null != code) "\t\t<cim:StandardIndustryCode.code>" + code + "</cim:StandardIndustryCode.code>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StandardIndustryCode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StandardIndustryCode>"
    }
}

object StandardIndustryCode
extends
    Parseable[StandardIndustryCode]
{
    val code = parse_element (element ("""StandardIndustryCode.code"""))
    def parse (context: Context): StandardIndustryCode =
    {
        StandardIndustryCode(
            Document.parse (context),
            code (context)
        )
    }
}

/**
 * Price curve for specifying the cost of energy (X) at points in time (y1) according to a prcing structure, which is based on a tariff.
 *
 * @param sup Reference to the superclass object.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class SubscribePowerCurve
(
    override val sup: Curve
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[SubscribePowerCurve] }
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
        "\t<cim:SubscribePowerCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SubscribePowerCurve>"
    }
}

object SubscribePowerCurve
extends
    Parseable[SubscribePowerCurve]
{
    def parse (context: Context): SubscribePowerCurve =
    {
        SubscribePowerCurve(
            Curve.parse (context)
        )
    }
}

/**
 * Billing information for work performed for the customer.
 * The history of Work Billing Info, Invoices, and Payments is to be maintained in associated ActivityRecords.
 *
 * @param sup Reference to the superclass object.
 * @param costEstimate Estimated cost for work.
 * @param deposit Amount of price on deposit.
 * @param discount Discount from standard price.
 * @param dueDateTime Date and time by which payment for bill is expected from client.
 * @param issueDateTime Date and time bill was issued to client.
 * @param receivedDateTime Date payment was received from client.
 * @param workPrice Amount of bill.
 * @param CustomerAccount <em>undocumented</em>
 * @param ErpLineItems <em>undocumented</em>
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
case class WorkBillingInfo
(
    override val sup: Document,
    costEstimate: Double,
    deposit: Double,
    discount: Double,
    dueDateTime: String,
    issueDateTime: String,
    receivedDateTime: String,
    workPrice: Double,
    CustomerAccount: String,
    ErpLineItems: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null, null, null, 0.0, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[WorkBillingInfo] }
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
        "\t\t<cim:WorkBillingInfo.costEstimate>" + costEstimate + "</cim:WorkBillingInfo.costEstimate>\n" +
        "\t\t<cim:WorkBillingInfo.deposit>" + deposit + "</cim:WorkBillingInfo.deposit>\n" +
        "\t\t<cim:WorkBillingInfo.discount>" + discount + "</cim:WorkBillingInfo.discount>\n" +
        (if (null != dueDateTime) "\t\t<cim:WorkBillingInfo.dueDateTime>" + dueDateTime + "</cim:WorkBillingInfo.dueDateTime>\n" else "") +
        (if (null != issueDateTime) "\t\t<cim:WorkBillingInfo.issueDateTime>" + issueDateTime + "</cim:WorkBillingInfo.issueDateTime>\n" else "") +
        (if (null != receivedDateTime) "\t\t<cim:WorkBillingInfo.receivedDateTime>" + receivedDateTime + "</cim:WorkBillingInfo.receivedDateTime>\n" else "") +
        "\t\t<cim:WorkBillingInfo.workPrice>" + workPrice + "</cim:WorkBillingInfo.workPrice>\n" +
        (if (null != CustomerAccount) "\t\t<cim:WorkBillingInfo.CustomerAccount rdf:resource=\"#" + CustomerAccount + "\"/>\n" else "") +
        (if (null != ErpLineItems) ErpLineItems.map (x => "\t\t<cim:WorkBillingInfo.ErpLineItems rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:WorkBillingInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WorkBillingInfo>"
    }
}

object WorkBillingInfo
extends
    Parseable[WorkBillingInfo]
{
    val costEstimate = parse_element (element ("""WorkBillingInfo.costEstimate"""))
    val deposit = parse_element (element ("""WorkBillingInfo.deposit"""))
    val discount = parse_element (element ("""WorkBillingInfo.discount"""))
    val dueDateTime = parse_element (element ("""WorkBillingInfo.dueDateTime"""))
    val issueDateTime = parse_element (element ("""WorkBillingInfo.issueDateTime"""))
    val receivedDateTime = parse_element (element ("""WorkBillingInfo.receivedDateTime"""))
    val workPrice = parse_element (element ("""WorkBillingInfo.workPrice"""))
    val CustomerAccount = parse_attribute (attribute ("""WorkBillingInfo.CustomerAccount"""))
    val ErpLineItems = parse_attributes (attribute ("""WorkBillingInfo.ErpLineItems"""))
    def parse (context: Context): WorkBillingInfo =
    {
        WorkBillingInfo(
            Document.parse (context),
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

private[ninecode] object _InfCustomers
{
    def register: List[ClassInfo] =
    {
        List (
            ComplianceEvent.register,
            CustomerBillingInfo.register,
            ExternalCustomerAgreement.register,
            PowerQualityPricing.register,
            ServiceGuarantee.register,
            StandardIndustryCode.register,
            SubscribePowerCurve.register,
            WorkBillingInfo.register
        )
    }
}