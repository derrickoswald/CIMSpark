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
 * Notifications for move-in, move-out, delinquencies, etc.
 *
 * @param Element Reference to the superclass object.
 * @param customerNotificationType <em>undocumented</em>
 * @param methodType <em>undocumented</em>
 * @param note <em>undocumented</em>
 * @param time <em>undocumented</em>
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] <em>undocumented</em>
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class AccountNotification
(
    Element: BasicElement = null,
    customerNotificationType: String = null,
    methodType: String = null,
    note: String = null,
    time: String = null,
    CustomerAccount: String = null
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
    override def sup: Element = Element

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
        implicit val clz: String = AccountNotification.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccountNotification.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccountNotification.fields (position), value)
        emitelem (0, customerNotificationType)
        emitelem (1, methodType)
        emitelem (2, note)
        emitelem (3, time)
        emitattr (4, CustomerAccount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccountNotification rdf:%s=\"%s\">\n%s\t</cim:AccountNotification>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AccountNotification
extends
    CIMParseable[AccountNotification]
{
    override val fields: Array[String] = Array[String] (
        "customerNotificationType",
        "methodType",
        "note",
        "time",
        "CustomerAccount"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAccount", "CustomerAccount", "1", "0..*")
    )
    val customerNotificationType: Fielder = parse_element (element (cls, fields(0)))
    val methodType: Fielder = parse_element (element (cls, fields(1)))
    val note: Fielder = parse_element (element (cls, fields(2)))
    val time: Fielder = parse_element (element (cls, fields(3)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): AccountNotification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccountNotification (
            BasicElement.parse (context),
            mask (customerNotificationType (), 0),
            mask (methodType (), 1),
            mask (note (), 2),
            mask (time (), 3),
            mask (CustomerAccount (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AccountNotification] = AccountNotificationSerializer
}

object AccountNotificationSerializer extends CIMSerializer[AccountNotification]
{
    def write (kryo: Kryo, output: Output, obj: AccountNotification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.customerNotificationType),
            () => output.writeString (obj.methodType),
            () => output.writeString (obj.note),
            () => output.writeString (obj.time),
            () => output.writeString (obj.CustomerAccount)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AccountNotification]): AccountNotification =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AccountNotification (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation receiving services from service supplier.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param kind Kind of customer.
 * @param locale Locale designating language to use in communications with this customer.
 * @param priority Priority of the customer.
 * @param pucNumber (if applicable) Public utilities commission (PUC) identification number.
 * @param specialNeed True if customer organisation has special service needs such as life support, hospitals, etc.
 * @param status Status of this customer.
 * @param vip (deprecated) (use 'priority' instead) True if this is an important customer.
 *        Importance is for matters different than those in 'specialNeed' attribute.
 * @param CustomerAccounts [[ch.ninecode.model.CustomerAccount CustomerAccount]] All accounts of this customer.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All agreements of this customer.
 * @param CustomerNotifications [[ch.ninecode.model.CustomerNotification CustomerNotification]] All notifications required by this customer.
 * @param Customer_attr [[ch.ninecode.model.Customer Customer]] <em>undocumented</em>
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices of this customer.
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param OutagePlan [[ch.ninecode.model.OutagePlan OutagePlan]] The outage plan that identifies the customers that are affected.
 * @param PlannedOutageNotification [[ch.ninecode.model.PlannedOutageNotification PlannedOutageNotification]] <em>undocumented</em>
 * @param TroubleTickets [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets for this customer.
 * @param Works [[ch.ninecode.model.Work Work]] All the works performed for this customer.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class Customer
(
    OrganisationRole: OrganisationRole = null,
    kind: String = null,
    locale: String = null,
    priority: String = null,
    pucNumber: String = null,
    specialNeed: String = null,
    status: String = null,
    vip: Boolean = false,
    CustomerAccounts: List[String] = null,
    CustomerAgreements: List[String] = null,
    CustomerNotifications: List[String] = null,
    Customer_attr: List[String] = null,
    EndDevices: List[String] = null,
    ErpPersons: List[String] = null,
    OutagePlan: String = null,
    PlannedOutageNotification: List[String] = null,
    TroubleTickets: List[String] = null,
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
    override def sup: OrganisationRole = OrganisationRole

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
        implicit val clz: String = Customer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Customer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Customer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Customer.fields (position), x))
        emitattr (0, kind)
        emitelem (1, locale)
        emitattr (2, priority)
        emitelem (3, pucNumber)
        emitelem (4, specialNeed)
        emitattr (5, status)
        emitelem (6, vip)
        emitattrs (7, CustomerAccounts)
        emitattrs (8, CustomerAgreements)
        emitattrs (9, CustomerNotifications)
        emitattrs (10, Customer_attr)
        emitattrs (11, EndDevices)
        emitattrs (12, ErpPersons)
        emitattr (13, OutagePlan)
        emitattrs (14, PlannedOutageNotification)
        emitattrs (15, TroubleTickets)
        emitattrs (16, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Customer rdf:%s=\"%s\">\n%s\t</cim:Customer>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Customer
extends
    CIMParseable[Customer]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "locale",
        "priority",
        "pucNumber",
        "specialNeed",
        "status",
        "vip",
        "CustomerAccounts",
        "CustomerAgreements",
        "CustomerNotifications",
        "Customer",
        "EndDevices",
        "ErpPersons",
        "OutagePlan",
        "PlannedOutageNotification",
        "TroubleTickets",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAccounts", "CustomerAccount", "0..*", "1"),
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        CIMRelationship ("CustomerNotifications", "CustomerNotification", "0..*", "0..1"),
        CIMRelationship ("Customer_attr", "Customer", "", "0..*"),
        CIMRelationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        CIMRelationship ("ErpPersons", "OldPerson", "0..*", "0..1"),
        CIMRelationship ("OutagePlan", "OutagePlan", "0..1", "0..*"),
        CIMRelationship ("PlannedOutageNotification", "PlannedOutageNotification", "0..*", "0..*"),
        CIMRelationship ("TroubleTickets", "TroubleTicket", "0..*", "0..1"),
        CIMRelationship ("Works", "Work", "0..*", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val locale: Fielder = parse_element (element (cls, fields(1)))
    val priority: Fielder = parse_attribute (attribute (cls, fields(2)))
    val pucNumber: Fielder = parse_element (element (cls, fields(3)))
    val specialNeed: Fielder = parse_element (element (cls, fields(4)))
    val status: Fielder = parse_attribute (attribute (cls, fields(5)))
    val vip: Fielder = parse_element (element (cls, fields(6)))
    val CustomerAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val CustomerNotifications: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Customer_attr: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val OutagePlan: Fielder = parse_attribute (attribute (cls, fields(13)))
    val PlannedOutageNotification: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(16)))

    def parse (context: CIMContext): Customer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Customer (
            OrganisationRole.parse (context),
            mask (kind (), 0),
            mask (locale (), 1),
            mask (priority (), 2),
            mask (pucNumber (), 3),
            mask (specialNeed (), 4),
            mask (status (), 5),
            toBoolean (mask (vip (), 6)),
            masks (CustomerAccounts (), 7),
            masks (CustomerAgreements (), 8),
            masks (CustomerNotifications (), 9),
            masks (Customer_attr (), 10),
            masks (EndDevices (), 11),
            masks (ErpPersons (), 12),
            mask (OutagePlan (), 13),
            masks (PlannedOutageNotification (), 14),
            masks (TroubleTickets (), 15),
            masks (Works (), 16)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Customer] = CustomerSerializer
}

object CustomerSerializer extends CIMSerializer[Customer]
{
    def write (kryo: Kryo, output: Output, obj: Customer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.locale),
            () => output.writeString (obj.priority),
            () => output.writeString (obj.pucNumber),
            () => output.writeString (obj.specialNeed),
            () => output.writeString (obj.status),
            () => output.writeBoolean (obj.vip),
            () => writeList (obj.CustomerAccounts, output),
            () => writeList (obj.CustomerAgreements, output),
            () => writeList (obj.CustomerNotifications, output),
            () => writeList (obj.Customer_attr, output),
            () => writeList (obj.EndDevices, output),
            () => writeList (obj.ErpPersons, output),
            () => output.writeString (obj.OutagePlan),
            () => writeList (obj.PlannedOutageNotification, output),
            () => writeList (obj.TroubleTickets, output),
            () => writeList (obj.Works, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Customer]): Customer =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Customer (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readBoolean else false,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Assignment of a group of products and services purchased by the customer through a customer agreement, used as a mechanism for customer billing and payment.
 *
 * It contains common information from the various types of customer agreements to create billings (invoices) for a customer and receive payment.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param billingCycle Cycle day on which the associated customer account will normally be billed, used to determine when to produce the billing.
 * @param budgetBill Budget bill code.
 * @param lastBillAmount The last amount that will be billed to the customer prior to shut off of the account.
 * @param AccountNotification [[ch.ninecode.model.AccountNotification AccountNotification]] <em>undocumented</em>
 * @param Customer [[ch.ninecode.model.Customer Customer]] Customer owning this account.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All agreements for this customer account.
 * @param CustomerBillingInfos [[ch.ninecode.model.CustomerBillingInfo CustomerBillingInfo]] <em>undocumented</em>
 * @param ErpInvoicees [[ch.ninecode.model.ErpInvoice ErpInvoice]] <em>undocumented</em>
 * @param PaymentTransactions [[ch.ninecode.model.Transaction Transaction]] All payment transactions for this customer account.
 * @param WorkBillingInfos [[ch.ninecode.model.WorkBillingInfo WorkBillingInfo]] <em>undocumented</em>
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class CustomerAccount
(
    Document: Document = null,
    billingCycle: String = null,
    budgetBill: String = null,
    lastBillAmount: Double = 0.0,
    AccountNotification: List[String] = null,
    Customer: String = null,
    CustomerAgreements: List[String] = null,
    CustomerBillingInfos: List[String] = null,
    ErpInvoicees: List[String] = null,
    PaymentTransactions: List[String] = null,
    WorkBillingInfos: List[String] = null
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
        implicit val clz: String = CustomerAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CustomerAccount.fields (position), x))
        emitelem (0, billingCycle)
        emitelem (1, budgetBill)
        emitelem (2, lastBillAmount)
        emitattrs (3, AccountNotification)
        emitattr (4, Customer)
        emitattrs (5, CustomerAgreements)
        emitattrs (6, CustomerBillingInfos)
        emitattrs (7, ErpInvoicees)
        emitattrs (8, PaymentTransactions)
        emitattrs (9, WorkBillingInfos)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CustomerAccount rdf:%s=\"%s\">\n%s\t</cim:CustomerAccount>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CustomerAccount
extends
    CIMParseable[CustomerAccount]
{
    override val fields: Array[String] = Array[String] (
        "billingCycle",
        "budgetBill",
        "lastBillAmount",
        "AccountNotification",
        "Customer",
        "CustomerAgreements",
        "CustomerBillingInfos",
        "ErpInvoicees",
        "PaymentTransactions",
        "WorkBillingInfos"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AccountNotification", "AccountNotification", "0..*", "1"),
        CIMRelationship ("Customer", "Customer", "1", "0..*"),
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        CIMRelationship ("CustomerBillingInfos", "CustomerBillingInfo", "0..*", "0..1"),
        CIMRelationship ("ErpInvoicees", "ErpInvoice", "0..*", "0..1"),
        CIMRelationship ("PaymentTransactions", "Transaction", "0..*", "0..1"),
        CIMRelationship ("WorkBillingInfos", "WorkBillingInfo", "0..*", "0..1")
    )
    val billingCycle: Fielder = parse_element (element (cls, fields(0)))
    val budgetBill: Fielder = parse_element (element (cls, fields(1)))
    val lastBillAmount: Fielder = parse_element (element (cls, fields(2)))
    val AccountNotification: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val CustomerBillingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ErpInvoicees: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val PaymentTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val WorkBillingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: CIMContext): CustomerAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerAccount (
            Document.parse (context),
            mask (billingCycle (), 0),
            mask (budgetBill (), 1),
            toDouble (mask (lastBillAmount (), 2)),
            masks (AccountNotification (), 3),
            mask (Customer (), 4),
            masks (CustomerAgreements (), 5),
            masks (CustomerBillingInfos (), 6),
            masks (ErpInvoicees (), 7),
            masks (PaymentTransactions (), 8),
            masks (WorkBillingInfos (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CustomerAccount] = CustomerAccountSerializer
}

object CustomerAccountSerializer extends CIMSerializer[CustomerAccount]
{
    def write (kryo: Kryo, output: Output, obj: CustomerAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.billingCycle),
            () => output.writeString (obj.budgetBill),
            () => output.writeDouble (obj.lastBillAmount),
            () => writeList (obj.AccountNotification, output),
            () => output.writeString (obj.Customer),
            () => writeList (obj.CustomerAgreements, output),
            () => writeList (obj.CustomerBillingInfos, output),
            () => writeList (obj.ErpInvoicees, output),
            () => writeList (obj.PaymentTransactions, output),
            () => writeList (obj.WorkBillingInfos, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CustomerAccount]): CustomerAccount =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CustomerAccount (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Agreement between the customer and the service supplier to pay for service at a specific service location.
 *
 * It records certain billing information about the type of service provided at the service location and is used during charge creation to determine the type of service.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param isPrePay If true, the customer is a pre-pay customer for the specified service.
 * @param loadMgmt Load management code.
 * @param shutOffDateTime Final date and time the service will be billed to the previous customer.
 * @param AuxiliaryAgreements [[ch.ninecode.model.AuxiliaryAgreement AuxiliaryAgreement]] All (non-service related) auxiliary agreements that refer to this customer agreement.
 * @param Customer [[ch.ninecode.model.Customer Customer]] Customer for this agreement.
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] Customer account owning this agreement.
 * @param DemandResponsePrograms [[ch.ninecode.model.DemandResponseProgram DemandResponseProgram]] All demand response programs the customer is enrolled in through this customer agreement.
 * @param MeterReadings [[ch.ninecode.model.MeterReading MeterReading]] (could be deprecated in the future) All meter readings for this customer agreement.
 * @param PricingStructures [[ch.ninecode.model.PricingStructure PricingStructure]] All pricing structures applicable to this customer agreement.
 * @param ServiceCategory [[ch.ninecode.model.ServiceCategory ServiceCategory]] Service category for this agreement.
 * @param ServiceLocations [[ch.ninecode.model.ServiceLocation ServiceLocation]] All service locations regulated by this customer agreement.
 * @param ServiceSupplier [[ch.ninecode.model.ServiceSupplier ServiceSupplier]] Service supplier for this customer agreement.
 * @param StandardIndustryCode [[ch.ninecode.model.StandardIndustryCode StandardIndustryCode]] <em>undocumented</em>
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All service delivery points regulated by this customer agreement.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class CustomerAgreement
(
    Agreement: Agreement = null,
    isPrePay: Boolean = false,
    loadMgmt: String = null,
    shutOffDateTime: String = null,
    AuxiliaryAgreements: List[String] = null,
    Customer: String = null,
    CustomerAccount: String = null,
    DemandResponsePrograms: List[String] = null,
    MeterReadings: List[String] = null,
    PricingStructures: List[String] = null,
    ServiceCategory: String = null,
    ServiceLocations: List[String] = null,
    ServiceSupplier: String = null,
    StandardIndustryCode: String = null,
    UsagePoints: List[String] = null
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CustomerAgreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerAgreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerAgreement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CustomerAgreement.fields (position), x))
        emitelem (0, isPrePay)
        emitelem (1, loadMgmt)
        emitelem (2, shutOffDateTime)
        emitattrs (3, AuxiliaryAgreements)
        emitattr (4, Customer)
        emitattr (5, CustomerAccount)
        emitattrs (6, DemandResponsePrograms)
        emitattrs (7, MeterReadings)
        emitattrs (8, PricingStructures)
        emitattr (9, ServiceCategory)
        emitattrs (10, ServiceLocations)
        emitattr (11, ServiceSupplier)
        emitattr (12, StandardIndustryCode)
        emitattrs (13, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CustomerAgreement rdf:%s=\"%s\">\n%s\t</cim:CustomerAgreement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CustomerAgreement
extends
    CIMParseable[CustomerAgreement]
{
    override val fields: Array[String] = Array[String] (
        "isPrePay",
        "loadMgmt",
        "shutOffDateTime",
        "AuxiliaryAgreements",
        "Customer",
        "CustomerAccount",
        "DemandResponsePrograms",
        "MeterReadings",
        "PricingStructures",
        "ServiceCategory",
        "ServiceLocations",
        "ServiceSupplier",
        "StandardIndustryCode",
        "UsagePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxiliaryAgreements", "AuxiliaryAgreement", "0..*", "0..1"),
        CIMRelationship ("Customer", "Customer", "1", "0..*"),
        CIMRelationship ("CustomerAccount", "CustomerAccount", "1", "0..*"),
        CIMRelationship ("DemandResponsePrograms", "DemandResponseProgram", "0..*", "0..*"),
        CIMRelationship ("MeterReadings", "MeterReading", "0..*", "0..1"),
        CIMRelationship ("PricingStructures", "PricingStructure", "0..*", "0..*"),
        CIMRelationship ("ServiceCategory", "ServiceCategory", "0..1", "0..*"),
        CIMRelationship ("ServiceLocations", "ServiceLocation", "0..*", "0..*"),
        CIMRelationship ("ServiceSupplier", "ServiceSupplier", "1", "0..*"),
        CIMRelationship ("StandardIndustryCode", "StandardIndustryCode", "0..1", "0..*"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val isPrePay: Fielder = parse_element (element (cls, fields(0)))
    val loadMgmt: Fielder = parse_element (element (cls, fields(1)))
    val shutOffDateTime: Fielder = parse_element (element (cls, fields(2)))
    val AuxiliaryAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DemandResponsePrograms: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val MeterReadings: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val ServiceCategory: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ServiceLocations: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields(11)))
    val StandardIndustryCode: Fielder = parse_attribute (attribute (cls, fields(12)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: CIMContext): CustomerAgreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerAgreement (
            Agreement.parse (context),
            toBoolean (mask (isPrePay (), 0)),
            mask (loadMgmt (), 1),
            mask (shutOffDateTime (), 2),
            masks (AuxiliaryAgreements (), 3),
            mask (Customer (), 4),
            mask (CustomerAccount (), 5),
            masks (DemandResponsePrograms (), 6),
            masks (MeterReadings (), 7),
            masks (PricingStructures (), 8),
            mask (ServiceCategory (), 9),
            masks (ServiceLocations (), 10),
            mask (ServiceSupplier (), 11),
            mask (StandardIndustryCode (), 12),
            masks (UsagePoints (), 13)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CustomerAgreement] = CustomerAgreementSerializer
}

object CustomerAgreementSerializer extends CIMSerializer[CustomerAgreement]
{
    def write (kryo: Kryo, output: Output, obj: CustomerAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.isPrePay),
            () => output.writeString (obj.loadMgmt),
            () => output.writeString (obj.shutOffDateTime),
            () => writeList (obj.AuxiliaryAgreements, output),
            () => output.writeString (obj.Customer),
            () => output.writeString (obj.CustomerAccount),
            () => writeList (obj.DemandResponsePrograms, output),
            () => writeList (obj.MeterReadings, output),
            () => writeList (obj.PricingStructures, output),
            () => output.writeString (obj.ServiceCategory),
            () => writeList (obj.ServiceLocations, output),
            () => output.writeString (obj.ServiceSupplier),
            () => output.writeString (obj.StandardIndustryCode),
            () => writeList (obj.UsagePoints, output)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CustomerAgreement]): CustomerAgreement =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CustomerAgreement (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Conditions for notifying the customer about the changes in the status of their service (e.g., outage restore, estimated restoration time, tariff or service level change, etc.)
 *
 * @param Element Reference to the superclass object.
 * @param contactType Type of contact (e.g., phone, email, etc.).
 * @param contactValue Value of contact type (e.g., phone number, email address, etc.).
 * @param earliestDateTimeToCall Earliest date time to call the customer.
 * @param latestDateTimeToCall Latest date time to call the customer.
 * @param trigger Trigger for this notification.
 * @param Customer [[ch.ninecode.model.Customer Customer]] Customer requiring this notification.
 * @param Incident [[ch.ninecode.model.Incident Incident]] Incident as a subject of this customer notification.
 * @param TroubleTickets [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets with this notification.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class CustomerNotification
(
    Element: BasicElement = null,
    contactType: String = null,
    contactValue: String = null,
    earliestDateTimeToCall: String = null,
    latestDateTimeToCall: String = null,
    trigger: String = null,
    Customer: String = null,
    Incident: String = null,
    TroubleTickets: List[String] = null
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
    override def sup: Element = Element

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
        implicit val clz: String = CustomerNotification.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerNotification.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerNotification.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CustomerNotification.fields (position), x))
        emitelem (0, contactType)
        emitelem (1, contactValue)
        emitelem (2, earliestDateTimeToCall)
        emitelem (3, latestDateTimeToCall)
        emitattr (4, trigger)
        emitattr (5, Customer)
        emitattr (6, Incident)
        emitattrs (7, TroubleTickets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CustomerNotification rdf:%s=\"%s\">\n%s\t</cim:CustomerNotification>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CustomerNotification
extends
    CIMParseable[CustomerNotification]
{
    override val fields: Array[String] = Array[String] (
        "contactType",
        "contactValue",
        "earliestDateTimeToCall",
        "latestDateTimeToCall",
        "trigger",
        "Customer",
        "Incident",
        "TroubleTickets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Customer", "Customer", "0..1", "0..*"),
        CIMRelationship ("Incident", "Incident", "0..1", "0..*"),
        CIMRelationship ("TroubleTickets", "TroubleTicket", "0..*", "0..*")
    )
    val contactType: Fielder = parse_element (element (cls, fields(0)))
    val contactValue: Fielder = parse_element (element (cls, fields(1)))
    val earliestDateTimeToCall: Fielder = parse_element (element (cls, fields(2)))
    val latestDateTimeToCall: Fielder = parse_element (element (cls, fields(3)))
    val trigger: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): CustomerNotification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerNotification (
            BasicElement.parse (context),
            mask (contactType (), 0),
            mask (contactValue (), 1),
            mask (earliestDateTimeToCall (), 2),
            mask (latestDateTimeToCall (), 3),
            mask (trigger (), 4),
            mask (Customer (), 5),
            mask (Incident (), 6),
            masks (TroubleTickets (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CustomerNotification] = CustomerNotificationSerializer
}

object CustomerNotificationSerializer extends CIMSerializer[CustomerNotification]
{
    def write (kryo: Kryo, output: Output, obj: CustomerNotification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.contactType),
            () => output.writeString (obj.contactValue),
            () => output.writeString (obj.earliestDateTimeToCall),
            () => output.writeString (obj.latestDateTimeToCall),
            () => output.writeString (obj.trigger),
            () => output.writeString (obj.Customer),
            () => output.writeString (obj.Incident),
            () => writeList (obj.TroubleTickets, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CustomerNotification]): CustomerNotification =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CustomerNotification (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Hazardous situation associated with an incident.
 *
 * Examples are line down, gas leak, fire, etc.
 *
 * @param Hazard [[ch.ninecode.model.Hazard Hazard]] Reference to the superclass object.
 * @param Incident [[ch.ninecode.model.Incident Incident]] Incident associated with this hazard.
 * @param TroubleTicket [[ch.ninecode.model.TroubleTicket TroubleTicket]] Trouble ticket associated with this hazard.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class IncidentHazard
(
    Hazard: Hazard = null,
    Incident: String = null,
    TroubleTicket: String = null
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
    override def sup: Hazard = Hazard

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
        implicit val clz: String = IncidentHazard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IncidentHazard.fields (position), value)
        emitattr (0, Incident)
        emitattr (1, TroubleTicket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IncidentHazard rdf:%s=\"%s\">\n%s\t</cim:IncidentHazard>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object IncidentHazard
extends
    CIMParseable[IncidentHazard]
{
    override val fields: Array[String] = Array[String] (
        "Incident",
        "TroubleTicket"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Incident", "Incident", "0..1", "0..*"),
        CIMRelationship ("TroubleTicket", "TroubleTicket", "0..1", "0..*")
    )
    val Incident: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TroubleTicket: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): IncidentHazard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IncidentHazard (
            Hazard.parse (context),
            mask (Incident (), 0),
            mask (TroubleTicket (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IncidentHazard] = IncidentHazardSerializer
}

object IncidentHazardSerializer extends CIMSerializer[IncidentHazard]
{
    def write (kryo: Kryo, output: Output, obj: IncidentHazard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Incident),
            () => output.writeString (obj.TroubleTicket)
        )
        HazardSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IncidentHazard]): IncidentHazard =
    {
        val parent = HazardSerializer.read (kryo, input, classOf[Hazard])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IncidentHazard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Grouping of pricing components and prices used in the creation of customer charges and the eligibility criteria under which these terms may be offered to a customer.
 *
 * The reasons for grouping include state, customer classification, site characteristics, classification (i.e. fee price structure, deposit price structure, electric service price structure, etc.) and accounting requirements.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param code Unique user-allocated key for this pricing structure, used by company representatives to identify the correct price structure for allocating to a customer.
 *        For rate schedules it is often prefixed by a state code.
 * @param dailyCeilingUsage Absolute maximum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param dailyEstimatedUsage Used in place of actual computed estimated average when history of usage is not available, and typically manually entered by customer accounting.
 * @param dailyFloorUsage Absolute minimum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param revenueKind (accounting) Kind of revenue, often used to determine the grace period allowed, before collection actions are taken on a customer (grace periods vary between revenue classes).
 * @param taxExemption True if this pricing structure is not taxable.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements with this pricing structure.
 * @param ServiceCategory [[ch.ninecode.model.ServiceCategory ServiceCategory]] Service category to which this pricing structure applies.
 * @param Tariffs [[ch.ninecode.model.Tariff Tariff]] All tariffs used by this pricing structure.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions applying this pricing structure.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All service delivery points (with prepayment meter running as a stand-alone device, with no CustomerAgreement or Customer) to which this pricing structure applies.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class PricingStructure
(
    Document: Document = null,
    code: String = null,
    dailyCeilingUsage: Int = 0,
    dailyEstimatedUsage: Int = 0,
    dailyFloorUsage: Int = 0,
    revenueKind: String = null,
    taxExemption: Boolean = false,
    CustomerAgreements: List[String] = null,
    ServiceCategory: String = null,
    Tariffs: List[String] = null,
    Transactions: List[String] = null,
    UsagePoints: List[String] = null
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
        implicit val clz: String = PricingStructure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PricingStructure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PricingStructure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PricingStructure.fields (position), x))
        emitelem (0, code)
        emitelem (1, dailyCeilingUsage)
        emitelem (2, dailyEstimatedUsage)
        emitelem (3, dailyFloorUsage)
        emitattr (4, revenueKind)
        emitelem (5, taxExemption)
        emitattrs (6, CustomerAgreements)
        emitattr (7, ServiceCategory)
        emitattrs (8, Tariffs)
        emitattrs (9, Transactions)
        emitattrs (10, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PricingStructure rdf:%s=\"%s\">\n%s\t</cim:PricingStructure>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PricingStructure
extends
    CIMParseable[PricingStructure]
{
    override val fields: Array[String] = Array[String] (
        "code",
        "dailyCeilingUsage",
        "dailyEstimatedUsage",
        "dailyFloorUsage",
        "revenueKind",
        "taxExemption",
        "CustomerAgreements",
        "ServiceCategory",
        "Tariffs",
        "Transactions",
        "UsagePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        CIMRelationship ("ServiceCategory", "ServiceCategory", "1", "0..*"),
        CIMRelationship ("Tariffs", "Tariff", "0..*", "0..*"),
        CIMRelationship ("Transactions", "Transaction", "0..*", "0..1"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val dailyCeilingUsage: Fielder = parse_element (element (cls, fields(1)))
    val dailyEstimatedUsage: Fielder = parse_element (element (cls, fields(2)))
    val dailyFloorUsage: Fielder = parse_element (element (cls, fields(3)))
    val revenueKind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val taxExemption: Fielder = parse_element (element (cls, fields(5)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ServiceCategory: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Tariffs: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: CIMContext): PricingStructure =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PricingStructure (
            Document.parse (context),
            mask (code (), 0),
            toInteger (mask (dailyCeilingUsage (), 1)),
            toInteger (mask (dailyEstimatedUsage (), 2)),
            toInteger (mask (dailyFloorUsage (), 3)),
            mask (revenueKind (), 4),
            toBoolean (mask (taxExemption (), 5)),
            masks (CustomerAgreements (), 6),
            mask (ServiceCategory (), 7),
            masks (Tariffs (), 8),
            masks (Transactions (), 9),
            masks (UsagePoints (), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PricingStructure] = PricingStructureSerializer
}

object PricingStructureSerializer extends CIMSerializer[PricingStructure]
{
    def write (kryo: Kryo, output: Output, obj: PricingStructure): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.code),
            () => output.writeInt (obj.dailyCeilingUsage),
            () => output.writeInt (obj.dailyEstimatedUsage),
            () => output.writeInt (obj.dailyFloorUsage),
            () => output.writeString (obj.revenueKind),
            () => output.writeBoolean (obj.taxExemption),
            () => writeList (obj.CustomerAgreements, output),
            () => output.writeString (obj.ServiceCategory),
            () => writeList (obj.Tariffs, output),
            () => writeList (obj.Transactions, output),
            () => writeList (obj.UsagePoints, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PricingStructure]): PricingStructure =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PricingStructure (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Category of service provided to the customer.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Kind of service.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this service category.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements with this service category.
 * @param PricingStructures [[ch.ninecode.model.PricingStructure PricingStructure]] All pricing structures applicable to this service category.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points that deliver this category of service.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class ServiceCategory
(
    IdentifiedObject: IdentifiedObject = null,
    kind: String = null,
    ConfigurationEvents: List[String] = null,
    CustomerAgreements: List[String] = null,
    PricingStructures: List[String] = null,
    UsagePoints: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = ServiceCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceCategory.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ServiceCategory.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, ConfigurationEvents)
        emitattrs (2, CustomerAgreements)
        emitattrs (3, PricingStructures)
        emitattrs (4, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceCategory rdf:%s=\"%s\">\n%s\t</cim:ServiceCategory>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ServiceCategory
extends
    CIMParseable[ServiceCategory]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "ConfigurationEvents",
        "CustomerAgreements",
        "PricingStructures",
        "UsagePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..1"),
        CIMRelationship ("PricingStructures", "PricingStructure", "0..*", "1"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): ServiceCategory =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServiceCategory (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            masks (ConfigurationEvents (), 1),
            masks (CustomerAgreements (), 2),
            masks (PricingStructures (), 3),
            masks (UsagePoints (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ServiceCategory] = ServiceCategorySerializer
}

object ServiceCategorySerializer extends CIMSerializer[ServiceCategory]
{
    def write (kryo: Kryo, output: Output, obj: ServiceCategory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.ConfigurationEvents, output),
            () => writeList (obj.CustomerAgreements, output),
            () => writeList (obj.PricingStructures, output),
            () => writeList (obj.UsagePoints, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ServiceCategory]): ServiceCategory =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ServiceCategory (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A real estate location, commonly referred to as premises.
 *
 * @param WorkLocation [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
 * @param accessMethod Method for the service person to access this service location.
 *        For example, a description of where to obtain a key if the facility is unmanned and secured.
 * @param needsInspection True if inspection is needed of facilities at this service location.
 *        This could be requested by a customer, due to suspected tampering, environmental concerns (e.g., a fire in the vicinity), or to correct incompatible data.
 * @param siteAccessProblem Problems previously encountered when visiting or performing work on this location.
 *        Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements regulating this service location.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices that measure the service delivered to this service location.
 * @param TroubleTicket [[ch.ninecode.model.TroubleTicket TroubleTicket]] <em>undocumented</em>
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points delivering service (of the same type) to this service location.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class ServiceLocation
(
    WorkLocation: WorkLocation = null,
    accessMethod: String = null,
    needsInspection: Boolean = false,
    siteAccessProblem: String = null,
    CustomerAgreements: List[String] = null,
    EndDevices: List[String] = null,
    TroubleTicket: List[String] = null,
    UsagePoints: List[String] = null
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
    override def sup: WorkLocation = WorkLocation

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
        implicit val clz: String = ServiceLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceLocation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ServiceLocation.fields (position), x))
        emitelem (0, accessMethod)
        emitelem (1, needsInspection)
        emitelem (2, siteAccessProblem)
        emitattrs (3, CustomerAgreements)
        emitattrs (4, EndDevices)
        emitattrs (5, TroubleTicket)
        emitattrs (6, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceLocation rdf:%s=\"%s\">\n%s\t</cim:ServiceLocation>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ServiceLocation
extends
    CIMParseable[ServiceLocation]
{
    override val fields: Array[String] = Array[String] (
        "accessMethod",
        "needsInspection",
        "siteAccessProblem",
        "CustomerAgreements",
        "EndDevices",
        "TroubleTicket",
        "UsagePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        CIMRelationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        CIMRelationship ("TroubleTicket", "TroubleTicket", "0..*", "1"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val accessMethod: Fielder = parse_element (element (cls, fields(0)))
    val needsInspection: Fielder = parse_element (element (cls, fields(1)))
    val siteAccessProblem: Fielder = parse_element (element (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TroubleTicket: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): ServiceLocation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServiceLocation (
            WorkLocation.parse (context),
            mask (accessMethod (), 0),
            toBoolean (mask (needsInspection (), 1)),
            mask (siteAccessProblem (), 2),
            masks (CustomerAgreements (), 3),
            masks (EndDevices (), 4),
            masks (TroubleTicket (), 5),
            masks (UsagePoints (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ServiceLocation] = ServiceLocationSerializer
}

object ServiceLocationSerializer extends CIMSerializer[ServiceLocation]
{
    def write (kryo: Kryo, output: Output, obj: ServiceLocation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accessMethod),
            () => output.writeBoolean (obj.needsInspection),
            () => output.writeString (obj.siteAccessProblem),
            () => writeList (obj.CustomerAgreements, output),
            () => writeList (obj.EndDevices, output),
            () => writeList (obj.TroubleTicket, output),
            () => writeList (obj.UsagePoints, output)
        )
        WorkLocationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ServiceLocation]): ServiceLocation =
    {
        val parent = WorkLocationSerializer.read (kryo, input, classOf[WorkLocation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ServiceLocation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document, approved by the responsible regulatory agency, listing the terms and conditions, including a schedule of prices, under which utility services will be provided.
 *
 * It has a unique number within the state or province. For rate schedules it is frequently allocated by the affiliated Public utilities commission (PUC).
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param endDate (if tariff became inactive) Date tariff was terminated.
 * @param startDate Date tariff was activated.
 * @param PricingStructures [[ch.ninecode.model.PricingStructure PricingStructure]] All pricing structures using this tariff.
 * @param TariffProfiles [[ch.ninecode.model.TariffProfile TariffProfile]] All tariff profiles using this tariff.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class Tariff
(
    Document: Document = null,
    endDate: String = null,
    startDate: String = null,
    PricingStructures: List[String] = null,
    TariffProfiles: List[String] = null
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
        implicit val clz: String = Tariff.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tariff.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Tariff.fields (position), x))
        emitelem (0, endDate)
        emitelem (1, startDate)
        emitattrs (2, PricingStructures)
        emitattrs (3, TariffProfiles)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tariff rdf:%s=\"%s\">\n%s\t</cim:Tariff>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Tariff
extends
    CIMParseable[Tariff]
{
    override val fields: Array[String] = Array[String] (
        "endDate",
        "startDate",
        "PricingStructures",
        "TariffProfiles"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PricingStructures", "PricingStructure", "0..*", "0..*"),
        CIMRelationship ("TariffProfiles", "TariffProfile", "0..*", "0..*")
    )
    val endDate: Fielder = parse_element (element (cls, fields(0)))
    val startDate: Fielder = parse_element (element (cls, fields(1)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): Tariff =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tariff (
            Document.parse (context),
            mask (endDate (), 0),
            mask (startDate (), 1),
            masks (PricingStructures (), 2),
            masks (TariffProfiles (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Tariff] = TariffSerializer
}

object TariffSerializer extends CIMSerializer[Tariff]
{
    def write (kryo: Kryo, output: Output, obj: Tariff): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.endDate),
            () => output.writeString (obj.startDate),
            () => writeList (obj.PricingStructures, output),
            () => writeList (obj.TariffProfiles, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tariff]): Tariff =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Tariff (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class TroubleTicket
(
    Document: Document = null,
    comment: String = null,
    dateTimeOfReport: String = null,
    firstResponderStatus: String = null,
    multiplePremises: Boolean = false,
    reportingKind: String = null,
    resolvedDateTime: String = null,
    troubleCode: String = null,
    Customer: String = null,
    Incident: String = null,
    IncidentHazard: List[String] = null,
    Notification: List[String] = null,
    ServiceLocation: String = null,
    TroubleOrder: String = null,
    UnplannedOutage: String = null
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
        implicit val clz: String = TroubleTicket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TroubleTicket.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TroubleTicket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TroubleTicket.fields (position), x))
        emitelem (0, comment)
        emitelem (1, dateTimeOfReport)
        emitelem (2, firstResponderStatus)
        emitelem (3, multiplePremises)
        emitattr (4, reportingKind)
        emitelem (5, resolvedDateTime)
        emitelem (6, troubleCode)
        emitattr (7, Customer)
        emitattr (8, Incident)
        emitattrs (9, IncidentHazard)
        emitattrs (10, Notification)
        emitattr (11, ServiceLocation)
        emitattr (12, TroubleOrder)
        emitattr (13, UnplannedOutage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TroubleTicket rdf:%s=\"%s\">\n%s\t</cim:TroubleTicket>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TroubleTicket
extends
    CIMParseable[TroubleTicket]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "dateTimeOfReport",
        "firstResponderStatus",
        "multiplePremises",
        "reportingKind",
        "resolvedDateTime",
        "troubleCode",
        "Customer",
        "Incident",
        "IncidentHazard",
        "Notification",
        "ServiceLocation",
        "TroubleOrder",
        "UnplannedOutage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Customer", "Customer", "0..1", "0..*"),
        CIMRelationship ("Incident", "Incident", "0..1", "0..*"),
        CIMRelationship ("IncidentHazard", "IncidentHazard", "0..*", "0..1"),
        CIMRelationship ("Notification", "CustomerNotification", "0..*", "0..*"),
        CIMRelationship ("ServiceLocation", "ServiceLocation", "1", "0..*"),
        CIMRelationship ("TroubleOrder", "TroubleOrder", "0..1", "0..*"),
        CIMRelationship ("UnplannedOutage", "UnplannedOutage", "0..1", "0..*")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val dateTimeOfReport: Fielder = parse_element (element (cls, fields(1)))
    val firstResponderStatus: Fielder = parse_element (element (cls, fields(2)))
    val multiplePremises: Fielder = parse_element (element (cls, fields(3)))
    val reportingKind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val resolvedDateTime: Fielder = parse_element (element (cls, fields(5)))
    val troubleCode: Fielder = parse_element (element (cls, fields(6)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(8)))
    val IncidentHazard: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Notification: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val ServiceLocation: Fielder = parse_attribute (attribute (cls, fields(11)))
    val TroubleOrder: Fielder = parse_attribute (attribute (cls, fields(12)))
    val UnplannedOutage: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: CIMContext): TroubleTicket =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TroubleTicket (
            Document.parse (context),
            mask (comment (), 0),
            mask (dateTimeOfReport (), 1),
            mask (firstResponderStatus (), 2),
            toBoolean (mask (multiplePremises (), 3)),
            mask (reportingKind (), 4),
            mask (resolvedDateTime (), 5),
            mask (troubleCode (), 6),
            mask (Customer (), 7),
            mask (Incident (), 8),
            masks (IncidentHazard (), 9),
            masks (Notification (), 10),
            mask (ServiceLocation (), 11),
            mask (TroubleOrder (), 12),
            mask (UnplannedOutage (), 13)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TroubleTicket] = TroubleTicketSerializer
}

object TroubleTicketSerializer extends CIMSerializer[TroubleTicket]
{
    def write (kryo: Kryo, output: Output, obj: TroubleTicket): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => output.writeString (obj.dateTimeOfReport),
            () => output.writeString (obj.firstResponderStatus),
            () => output.writeBoolean (obj.multiplePremises),
            () => output.writeString (obj.reportingKind),
            () => output.writeString (obj.resolvedDateTime),
            () => output.writeString (obj.troubleCode),
            () => output.writeString (obj.Customer),
            () => output.writeString (obj.Incident),
            () => writeList (obj.IncidentHazard, output),
            () => writeList (obj.Notification, output),
            () => output.writeString (obj.ServiceLocation),
            () => output.writeString (obj.TroubleOrder),
            () => output.writeString (obj.UnplannedOutage)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TroubleTicket]): TroubleTicket =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TroubleTicket (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Customers
{
    def register: List[CIMClassInfo] =
    {
        List (
            AccountNotification.register,
            Customer.register,
            CustomerAccount.register,
            CustomerAgreement.register,
            CustomerNotification.register,
            IncidentHazard.register,
            PricingStructure.register,
            ServiceCategory.register,
            ServiceLocation.register,
            Tariff.register,
            TroubleTicket.register
        )
    }
}