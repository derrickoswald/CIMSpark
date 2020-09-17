package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Compliance events are used for reporting regulatory or contract compliance issues and/or variances.
 *
 * These might be created as a consequence of local business processes and associated rules. It is anticipated that this class will be customised extensively to meet local implementation needs.
 * Use inherited 'type' to indicate that, for example, expected performance will not be met or reported as mandated.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param deadline The deadline for compliance.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class ComplianceEvent
(
    ActivityRecord: ActivityRecord = null,
    deadline: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: ActivityRecord = ActivityRecord

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ComplianceEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ComplianceEvent.fields (position), value)
        emitelem (0, deadline)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ComplianceEvent rdf:%s=\"%s\">\n%s\t</cim:ComplianceEvent>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ComplianceEvent
extends
    CIMParseable[ComplianceEvent]
{
    override val fields: Array[String] = Array[String] (
        "deadline"
    )
    val deadline: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): ComplianceEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ComplianceEvent (
            ActivityRecord.parse (context),
            mask (deadline (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ComplianceEvent] = ComplianceEventSerializer
}

object ComplianceEventSerializer extends CIMSerializer[ComplianceEvent]
{
    def write (kryo: Kryo, output: Output, obj: ComplianceEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.deadline)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ComplianceEvent]): ComplianceEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ComplianceEvent (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The creation of the monthly customer billing statements is the method employed to notify Customers of charges, adjustments and credits applied to their account for Services and Products.
 *
 * The actuall billing occurs through an ErpInvoice. The CustomerBillingInfo includes information from the payment, collection, meter reading, installed meter, service, site, customer, customer account, customer agreement, services and pricing subject areas. Each component price shows up as a separate line item on the ErpInvoice.
 * The Customer Billing Statement may include collection and account messages, marketing/civic event messages and bill inserts.
 * One Customer Billing Statement is produced for all Agreements under a CustomerAccount per billing cycle date defined in 'CustomerAccount.billingCycle'.
 * The history of CustomerBillingInfo, Invoices and Payments is to be maintained in associated ActivityRecords.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] <em>undocumented</em>
 * @param ErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class CustomerBillingInfo
(
    Document: Document = null,
    billingDate: String = null,
    dueDate: String = null,
    kind: String = null,
    lastPaymentAmt: Double = 0.0,
    lastPaymentDate: String = null,
    outBalance: Double = 0.0,
    pymtPlanAmt: Double = 0.0,
    pymtPlanType: String = null,
    CustomerAccount: String = null,
    ErpInvoiceLineItems: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CustomerBillingInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerBillingInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerBillingInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CustomerBillingInfo.fields (position), x))
        emitelem (0, billingDate)
        emitelem (1, dueDate)
        emitattr (2, kind)
        emitelem (3, lastPaymentAmt)
        emitelem (4, lastPaymentDate)
        emitelem (5, outBalance)
        emitelem (6, pymtPlanAmt)
        emitelem (7, pymtPlanType)
        emitattr (8, CustomerAccount)
        emitattrs (9, ErpInvoiceLineItems)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CustomerBillingInfo rdf:%s=\"%s\">\n%s\t</cim:CustomerBillingInfo>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CustomerBillingInfo
extends
    CIMParseable[CustomerBillingInfo]
{
    override val fields: Array[String] = Array[String] (
        "billingDate",
        "dueDate",
        "kind",
        "lastPaymentAmt",
        "lastPaymentDate",
        "outBalance",
        "pymtPlanAmt",
        "pymtPlanType",
        "CustomerAccount",
        "ErpInvoiceLineItems"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAccount", "CustomerAccount", "0..1", "0..*"),
        CIMRelationship ("ErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "0..*")
    )
    val billingDate: Fielder = parse_element (element (cls, fields(0)))
    val dueDate: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastPaymentAmt: Fielder = parse_element (element (cls, fields(3)))
    val lastPaymentDate: Fielder = parse_element (element (cls, fields(4)))
    val outBalance: Fielder = parse_element (element (cls, fields(5)))
    val pymtPlanAmt: Fielder = parse_element (element (cls, fields(6)))
    val pymtPlanType: Fielder = parse_element (element (cls, fields(7)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ErpInvoiceLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: CIMContext): CustomerBillingInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerBillingInfo (
            Document.parse (context),
            mask (billingDate (), 0),
            mask (dueDate (), 1),
            mask (kind (), 2),
            toDouble (mask (lastPaymentAmt (), 3)),
            mask (lastPaymentDate (), 4),
            toDouble (mask (outBalance (), 5)),
            toDouble (mask (pymtPlanAmt (), 6)),
            mask (pymtPlanType (), 7),
            mask (CustomerAccount (), 8),
            masks (ErpInvoiceLineItems (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CustomerBillingInfo] = CustomerBillingInfoSerializer
}

object CustomerBillingInfoSerializer extends CIMSerializer[CustomerBillingInfo]
{
    def write (kryo: Kryo, output: Output, obj: CustomerBillingInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.billingDate),
            () => output.writeString (obj.dueDate),
            () => output.writeString (obj.kind),
            () => output.writeDouble (obj.lastPaymentAmt),
            () => output.writeString (obj.lastPaymentDate),
            () => output.writeDouble (obj.outBalance),
            () => output.writeDouble (obj.pymtPlanAmt),
            () => output.writeString (obj.pymtPlanType),
            () => output.writeString (obj.CustomerAccount),
            () => writeList (obj.ErpInvoiceLineItems, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CustomerBillingInfo]): CustomerBillingInfo =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CustomerBillingInfo (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A type of customer agreement involving an external agency.
 *
 * For example, a customer may form a contracts with an Energy Service Supplier if Direct Access is permitted.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class ExternalCustomerAgreement
(
    Agreement: Agreement = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Agreement = Agreement

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ExternalCustomerAgreement rdf:%s=\"%s\">\n%s\t</cim:ExternalCustomerAgreement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ExternalCustomerAgreement
extends
    CIMParseable[ExternalCustomerAgreement]
{

    def parse (context: CIMContext): ExternalCustomerAgreement =
    {
        val ret = ExternalCustomerAgreement (
            Agreement.parse (context)
        )
        ret
    }

    def serializer: Serializer[ExternalCustomerAgreement] = ExternalCustomerAgreementSerializer
}

object ExternalCustomerAgreementSerializer extends CIMSerializer[ExternalCustomerAgreement]
{
    def write (kryo: Kryo, output: Output, obj: ExternalCustomerAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ExternalCustomerAgreement]): ExternalCustomerAgreement =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ExternalCustomerAgreement (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Pricing can be based on power quality.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
final case class PowerQualityPricing
(
    Document: Document = null,
    emergencyHighVoltLimit: Double = 0.0,
    emergencyLowVoltLimit: Double = 0.0,
    normalHighVoltLimit: Double = 0.0,
    normalLowVoltLimit: Double = 0.0,
    powerFactorMin: Double = 0.0,
    valueUninterruptedServiceEnergy: Double = 0.0,
    valueUninterruptedServiceP: Double = 0.0,
    voltImbalanceViolCost: Double = 0.0,
    voltLimitViolCost: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerQualityPricing.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerQualityPricing.fields (position), value)
        emitelem (0, emergencyHighVoltLimit)
        emitelem (1, emergencyLowVoltLimit)
        emitelem (2, normalHighVoltLimit)
        emitelem (3, normalLowVoltLimit)
        emitelem (4, powerFactorMin)
        emitelem (5, valueUninterruptedServiceEnergy)
        emitelem (6, valueUninterruptedServiceP)
        emitelem (7, voltImbalanceViolCost)
        emitelem (8, voltLimitViolCost)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerQualityPricing rdf:%s=\"%s\">\n%s\t</cim:PowerQualityPricing>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PowerQualityPricing
extends
    CIMParseable[PowerQualityPricing]
{
    override val fields: Array[String] = Array[String] (
        "emergencyHighVoltLimit",
        "emergencyLowVoltLimit",
        "normalHighVoltLimit",
        "normalLowVoltLimit",
        "powerFactorMin",
        "valueUninterruptedServiceEnergy",
        "valueUninterruptedServiceP",
        "voltImbalanceViolCost",
        "voltLimitViolCost"
    )
    val emergencyHighVoltLimit: Fielder = parse_element (element (cls, fields(0)))
    val emergencyLowVoltLimit: Fielder = parse_element (element (cls, fields(1)))
    val normalHighVoltLimit: Fielder = parse_element (element (cls, fields(2)))
    val normalLowVoltLimit: Fielder = parse_element (element (cls, fields(3)))
    val powerFactorMin: Fielder = parse_element (element (cls, fields(4)))
    val valueUninterruptedServiceEnergy: Fielder = parse_element (element (cls, fields(5)))
    val valueUninterruptedServiceP: Fielder = parse_element (element (cls, fields(6)))
    val voltImbalanceViolCost: Fielder = parse_element (element (cls, fields(7)))
    val voltLimitViolCost: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: CIMContext): PowerQualityPricing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerQualityPricing (
            Document.parse (context),
            toDouble (mask (emergencyHighVoltLimit (), 0)),
            toDouble (mask (emergencyLowVoltLimit (), 1)),
            toDouble (mask (normalHighVoltLimit (), 2)),
            toDouble (mask (normalLowVoltLimit (), 3)),
            toDouble (mask (powerFactorMin (), 4)),
            toDouble (mask (valueUninterruptedServiceEnergy (), 5)),
            toDouble (mask (valueUninterruptedServiceP (), 6)),
            toDouble (mask (voltImbalanceViolCost (), 7)),
            toDouble (mask (voltLimitViolCost (), 8))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PowerQualityPricing] = PowerQualityPricingSerializer
}

object PowerQualityPricingSerializer extends CIMSerializer[PowerQualityPricing]
{
    def write (kryo: Kryo, output: Output, obj: PowerQualityPricing): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.emergencyHighVoltLimit),
            () => output.writeDouble (obj.emergencyLowVoltLimit),
            () => output.writeDouble (obj.normalHighVoltLimit),
            () => output.writeDouble (obj.normalLowVoltLimit),
            () => output.writeDouble (obj.powerFactorMin),
            () => output.writeDouble (obj.valueUninterruptedServiceEnergy),
            () => output.writeDouble (obj.valueUninterruptedServiceP),
            () => output.writeDouble (obj.voltImbalanceViolCost),
            () => output.writeDouble (obj.voltLimitViolCost)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerQualityPricing]): PowerQualityPricing =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerQualityPricing (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A service guarantee, often imposed by a regulator, defines conditions that, if not satisfied, will result in the utility making a monetary payment to the customer.
 *
 * Note that guarantee's identifier is in the 'name' attribute and the status of the guarantee is in the 'Status.status' attribute.
 * Example service requirements include:
 * 1) If power is not restored within 24 hours, customers can claim \$50 for residential customers or \$100 for commercial and industrial customers. In addition for each extra period of 12 hours the customer's supply has not been activated, the customer can claim \$25.
 * 2) If a customer has a question about their electricity bill, the utility will investigate and respond to the inquiry within 15 working days. If utility fails to meet its guarantee, utility will automatically pay the customer \$50.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param applicationPeriod Period in which this service guantee applies.
 * @param automaticPay True if utility must autmatically pay the specified amount whenever the condition is not satisified, otherwise customer must make a claim to receive payment.
 * @param payAmount Amount to be paid by the service provider to the customer for each violation of the 'serviceRequirement'.
 * @param serviceRequirement Explanation of the requirement and conditions for satisfying it.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class ServiceGuarantee
(
    Document: Document = null,
    applicationPeriod: String = null,
    automaticPay: Boolean = false,
    payAmount: Double = 0.0,
    serviceRequirement: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceGuarantee.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceGuarantee.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceGuarantee.fields (position), value)
        emitattr (0, applicationPeriod)
        emitelem (1, automaticPay)
        emitelem (2, payAmount)
        emitelem (3, serviceRequirement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceGuarantee rdf:%s=\"%s\">\n%s\t</cim:ServiceGuarantee>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ServiceGuarantee
extends
    CIMParseable[ServiceGuarantee]
{
    override val fields: Array[String] = Array[String] (
        "applicationPeriod",
        "automaticPay",
        "payAmount",
        "serviceRequirement"
    )
    val applicationPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val automaticPay: Fielder = parse_element (element (cls, fields(1)))
    val payAmount: Fielder = parse_element (element (cls, fields(2)))
    val serviceRequirement: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): ServiceGuarantee =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServiceGuarantee (
            Document.parse (context),
            mask (applicationPeriod (), 0),
            toBoolean (mask (automaticPay (), 1)),
            toDouble (mask (payAmount (), 2)),
            mask (serviceRequirement (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ServiceGuarantee] = ServiceGuaranteeSerializer
}

object ServiceGuaranteeSerializer extends CIMSerializer[ServiceGuarantee]
{
    def write (kryo: Kryo, output: Output, obj: ServiceGuarantee): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.applicationPeriod),
            () => output.writeBoolean (obj.automaticPay),
            () => output.writeDouble (obj.payAmount),
            () => output.writeString (obj.serviceRequirement)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ServiceGuarantee]): ServiceGuarantee =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ServiceGuarantee (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The Standard Industrial Classification (SIC) are the codes that identify the type of products/service an industry is involved in, and used for statutory reporting purposes.
 *
 * For example, in the USA these codes are located by the federal government, and then published in a book entitled "The Standard Industrial Classification Manual". The codes are arranged in a hierarchical structure.
 * Note that Residential Service Agreements are not classified according to the SIC codes.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param code Standard alphanumeric code assigned to a particular product/service within an industry.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] <em>undocumented</em>
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class StandardIndustryCode
(
    Document: Document = null,
    code: String = null,
    CustomerAgreements: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = StandardIndustryCode.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StandardIndustryCode.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (StandardIndustryCode.fields (position), x))
        emitelem (0, code)
        emitattrs (1, CustomerAgreements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StandardIndustryCode rdf:%s=\"%s\">\n%s\t</cim:StandardIndustryCode>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object StandardIndustryCode
extends
    CIMParseable[StandardIndustryCode]
{
    override val fields: Array[String] = Array[String] (
        "code",
        "CustomerAgreements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..1")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): StandardIndustryCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StandardIndustryCode (
            Document.parse (context),
            mask (code (), 0),
            masks (CustomerAgreements (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StandardIndustryCode] = StandardIndustryCodeSerializer
}

object StandardIndustryCodeSerializer extends CIMSerializer[StandardIndustryCode]
{
    def write (kryo: Kryo, output: Output, obj: StandardIndustryCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => writeList (obj.CustomerAgreements, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StandardIndustryCode]): StandardIndustryCode =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StandardIndustryCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Price curve for specifying the cost of energy (X) at points in time (y1) according to a prcing structure, which is based on a tariff.
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class SubscribePowerCurve
(
    Curve: Curve = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Curve = Curve

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SubscribePowerCurve rdf:%s=\"%s\">\n%s\t</cim:SubscribePowerCurve>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object SubscribePowerCurve
extends
    CIMParseable[SubscribePowerCurve]
{

    def parse (context: CIMContext): SubscribePowerCurve =
    {
        val ret = SubscribePowerCurve (
            Curve.parse (context)
        )
        ret
    }

    def serializer: Serializer[SubscribePowerCurve] = SubscribePowerCurveSerializer
}

object SubscribePowerCurveSerializer extends CIMSerializer[SubscribePowerCurve]
{
    def write (kryo: Kryo, output: Output, obj: SubscribePowerCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SubscribePowerCurve]): SubscribePowerCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SubscribePowerCurve (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Billing information for work performed for the customer.
 *
 * The history of Work Billing Info, Invoices, and Payments is to be maintained in associated ActivityRecords.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param costEstimate Estimated cost for work.
 * @param deposit Amount of price on deposit.
 * @param discount Discount from standard price.
 * @param dueDateTime Date and time by which payment for bill is expected from client.
 * @param issueDateTime Date and time bill was issued to client.
 * @param receivedDateTime Date payment was received from client.
 * @param workPrice Amount of bill.
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] <em>undocumented</em>
 * @param ErpLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param Works [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfCustomers
 * @groupname InfCustomers Package InfCustomers
 * @groupdesc InfCustomers The package is used to define detailed customer models.
 */
final case class WorkBillingInfo
(
    Document: Document = null,
    costEstimate: Double = 0.0,
    deposit: Double = 0.0,
    discount: Double = 0.0,
    dueDateTime: String = null,
    issueDateTime: String = null,
    receivedDateTime: String = null,
    workPrice: Double = 0.0,
    CustomerAccount: String = null,
    ErpLineItems: List[String] = null,
    Works: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Document = Document

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WorkBillingInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WorkBillingInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WorkBillingInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WorkBillingInfo.fields (position), x))
        emitelem (0, costEstimate)
        emitelem (1, deposit)
        emitelem (2, discount)
        emitelem (3, dueDateTime)
        emitelem (4, issueDateTime)
        emitelem (5, receivedDateTime)
        emitelem (6, workPrice)
        emitattr (7, CustomerAccount)
        emitattrs (8, ErpLineItems)
        emitattrs (9, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WorkBillingInfo rdf:%s=\"%s\">\n%s\t</cim:WorkBillingInfo>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object WorkBillingInfo
extends
    CIMParseable[WorkBillingInfo]
{
    override val fields: Array[String] = Array[String] (
        "costEstimate",
        "deposit",
        "discount",
        "dueDateTime",
        "issueDateTime",
        "receivedDateTime",
        "workPrice",
        "CustomerAccount",
        "ErpLineItems",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAccount", "CustomerAccount", "0..1", "0..*"),
        CIMRelationship ("ErpLineItems", "ErpInvoiceLineItem", "0..*", "0..*"),
        CIMRelationship ("Works", "Work", "0..*", "0..1")
    )
    val costEstimate: Fielder = parse_element (element (cls, fields(0)))
    val deposit: Fielder = parse_element (element (cls, fields(1)))
    val discount: Fielder = parse_element (element (cls, fields(2)))
    val dueDateTime: Fielder = parse_element (element (cls, fields(3)))
    val issueDateTime: Fielder = parse_element (element (cls, fields(4)))
    val receivedDateTime: Fielder = parse_element (element (cls, fields(5)))
    val workPrice: Fielder = parse_element (element (cls, fields(6)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ErpLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: CIMContext): WorkBillingInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WorkBillingInfo (
            Document.parse (context),
            toDouble (mask (costEstimate (), 0)),
            toDouble (mask (deposit (), 1)),
            toDouble (mask (discount (), 2)),
            mask (dueDateTime (), 3),
            mask (issueDateTime (), 4),
            mask (receivedDateTime (), 5),
            toDouble (mask (workPrice (), 6)),
            mask (CustomerAccount (), 7),
            masks (ErpLineItems (), 8),
            masks (Works (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WorkBillingInfo] = WorkBillingInfoSerializer
}

object WorkBillingInfoSerializer extends CIMSerializer[WorkBillingInfo]
{
    def write (kryo: Kryo, output: Output, obj: WorkBillingInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.costEstimate),
            () => output.writeDouble (obj.deposit),
            () => output.writeDouble (obj.discount),
            () => output.writeString (obj.dueDateTime),
            () => output.writeString (obj.issueDateTime),
            () => output.writeString (obj.receivedDateTime),
            () => output.writeDouble (obj.workPrice),
            () => output.writeString (obj.CustomerAccount),
            () => writeList (obj.ErpLineItems, output),
            () => writeList (obj.Works, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WorkBillingInfo]): WorkBillingInfo =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WorkBillingInfo (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfCustomers
{
    def register: List[CIMClassInfo] =
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