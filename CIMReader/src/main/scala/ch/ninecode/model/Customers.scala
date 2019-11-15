package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Notifications for move-in, move-out, delinquencies, etc.
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AccountNotification] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:AccountNotification rdf:ID=\"%s\">\n%s\t</cim:AccountNotification>".format (id, export_fields)
    }
}

object AccountNotification
extends
    Parseable[AccountNotification]
{
    override val fields: Array[String] = Array[String] (
        "customerNotificationType",
        "methodType",
        "note",
        "time",
        "CustomerAccount"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAccount", "CustomerAccount", "1", "0..*")
    )
    val customerNotificationType: Fielder = parse_element (element (cls, fields(0)))
    val methodType: Fielder = parse_element (element (cls, fields(1)))
    val note: Fielder = parse_element (element (cls, fields(2)))
    val time: Fielder = parse_element (element (cls, fields(3)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): AccountNotification =
    {
        implicit val ctx: Context = context
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
}

/**
 * Organisation receiving services from service supplier.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
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
 * @param Customer [[ch.ninecode.model.Customer Customer]] <em>undocumented</em>
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices of this customer.
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param OutagePlan [[ch.ninecode.model.OutagePlan OutagePlan]] The outage plan that identifies the customers that are affected.
 * @param TroubleTickets [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets for this customer.
 * @param Works [[ch.ninecode.model.Work Work]] All the works performed for this customer.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class Customer
(
    override val sup: OrganisationRole = null,
    kind: String = null,
    locale: String = null,
    priority: String = null,
    pucNumber: String = null,
    specialNeed: String = null,
    status: String = null,
    vip: Boolean = false,
    CustomerAccounts: List[String] = List(),
    CustomerAgreements: List[String] = List(),
    CustomerNotifications: List[String] = List(),
    Customer_attr: List[String] = List(),
    EndDevices: List[String] = List(),
    ErpPersons: List[String] = List(),
    OutagePlan: String = null,
    TroubleTickets: List[String] = List(),
    Works: List[String] = List()
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Customer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        emitattrs (14, TroubleTickets)
        emitattrs (15, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Customer rdf:ID=\"%s\">\n%s\t</cim:Customer>".format (id, export_fields)
    }
}

object Customer
extends
    Parseable[Customer]
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
        "TroubleTickets",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAccounts", "CustomerAccount", "0..*", "1"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        Relationship ("CustomerNotifications", "CustomerNotification", "0..*", "0..1"),
        Relationship ("Customer_attr", "Customer", "0..*", ""),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        Relationship ("ErpPersons", "OldPerson", "0..*", "0..1"),
        Relationship ("OutagePlan", "OutagePlan", "0..1", "0..*"),
        Relationship ("TroubleTickets", "TroubleTicket", "0..*", "0..1"),
        Relationship ("Works", "Work", "0..*", "0..*")
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
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): Customer =
    {
        implicit val ctx: Context = context
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
            masks (TroubleTickets (), 14),
            masks (Works (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Assignment of a group of products and services purchased by the customer through a customer agreement, used as a mechanism for customer billing and payment.
 *
 * It contains common information from the various types of customer agreements to create billings (invoices) for a customer and receive payment.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    override val sup: Document = null,
    billingCycle: String = null,
    budgetBill: String = null,
    lastBillAmount: Double = 0.0,
    AccountNotification: List[String] = List(),
    Customer: String = null,
    CustomerAgreements: List[String] = List(),
    CustomerBillingInfos: List[String] = List(),
    ErpInvoicees: List[String] = List(),
    PaymentTransactions: List[String] = List(),
    WorkBillingInfos: List[String] = List()
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[CustomerAccount] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:CustomerAccount rdf:ID=\"%s\">\n%s\t</cim:CustomerAccount>".format (id, export_fields)
    }
}

object CustomerAccount
extends
    Parseable[CustomerAccount]
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
    override val relations: List[Relationship] = List (
        Relationship ("AccountNotification", "AccountNotification", "0..*", "1"),
        Relationship ("Customer", "Customer", "1", "0..*"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        Relationship ("CustomerBillingInfos", "CustomerBillingInfo", "0..*", "0..1"),
        Relationship ("ErpInvoicees", "ErpInvoice", "0..*", "0..1"),
        Relationship ("PaymentTransactions", "Transaction", "0..*", "0..1"),
        Relationship ("WorkBillingInfos", "WorkBillingInfo", "0..*", "0..1")
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

    def parse (context: Context): CustomerAccount =
    {
        implicit val ctx: Context = context
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
}

/**
 * Agreement between the customer and the service supplier to pay for service at a specific service location.
 *
 * It records certain billing information about the type of service provided at the service location and is used during charge creation to determine the type of service.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
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
    override val sup: Agreement = null,
    isPrePay: Boolean = false,
    loadMgmt: String = null,
    shutOffDateTime: String = null,
    AuxiliaryAgreements: List[String] = List(),
    Customer: String = null,
    CustomerAccount: String = null,
    DemandResponsePrograms: List[String] = List(),
    MeterReadings: List[String] = List(),
    PricingStructures: List[String] = List(),
    ServiceCategory: String = null,
    ServiceLocations: List[String] = List(),
    ServiceSupplier: String = null,
    StandardIndustryCode: String = null,
    UsagePoints: List[String] = List()
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
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[CustomerAgreement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:CustomerAgreement rdf:ID=\"%s\">\n%s\t</cim:CustomerAgreement>".format (id, export_fields)
    }
}

object CustomerAgreement
extends
    Parseable[CustomerAgreement]
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
    override val relations: List[Relationship] = List (
        Relationship ("AuxiliaryAgreements", "AuxiliaryAgreement", "0..*", "0..1"),
        Relationship ("Customer", "Customer", "1", "0..*"),
        Relationship ("CustomerAccount", "CustomerAccount", "1", "0..*"),
        Relationship ("DemandResponsePrograms", "DemandResponseProgram", "0..*", "0..*"),
        Relationship ("MeterReadings", "MeterReading", "0..*", "0..1"),
        Relationship ("PricingStructures", "PricingStructure", "0..*", "0..*"),
        Relationship ("ServiceCategory", "ServiceCategory", "0..1", "0..*"),
        Relationship ("ServiceLocations", "ServiceLocation", "0..*", "0..*"),
        Relationship ("ServiceSupplier", "ServiceSupplier", "1", "0..*"),
        Relationship ("StandardIndustryCode", "StandardIndustryCode", "0..1", "0..*"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
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

    def parse (context: Context): CustomerAgreement =
    {
        implicit val ctx: Context = context
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
}

/**
 * Conditions for notifying the customer about the changes in the status of their service (e.g., outage restore, estimated restoration time, tariff or service level change, etc.)
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
    contactType: String = null,
    contactValue: String = null,
    earliestDateTimeToCall: String = null,
    latestDateTimeToCall: String = null,
    trigger: String = null,
    Customer: String = null,
    Incident: String = null,
    TroubleTickets: List[String] = List()
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CustomerNotification] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:CustomerNotification rdf:ID=\"%s\">\n%s\t</cim:CustomerNotification>".format (id, export_fields)
    }
}

object CustomerNotification
extends
    Parseable[CustomerNotification]
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
    override val relations: List[Relationship] = List (
        Relationship ("Customer", "Customer", "0..1", "0..*"),
        Relationship ("Incident", "Incident", "0..1", "0..*"),
        Relationship ("TroubleTickets", "TroubleTicket", "0..*", "0..1")
    )
    val contactType: Fielder = parse_element (element (cls, fields(0)))
    val contactValue: Fielder = parse_element (element (cls, fields(1)))
    val earliestDateTimeToCall: Fielder = parse_element (element (cls, fields(2)))
    val latestDateTimeToCall: Fielder = parse_element (element (cls, fields(3)))
    val trigger: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): CustomerNotification =
    {
        implicit val ctx: Context = context
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
}

/**
 * Hazardous situation associated with an incident.
 *
 * Examples are line down, gas leak, fire, etc.
 *
 * @param sup [[ch.ninecode.model.Hazard Hazard]] Reference to the superclass object.
 * @param Incident [[ch.ninecode.model.Incident Incident]] Incident associated with this hazard.
 * @param TroubleTicket [[ch.ninecode.model.TroubleTicket TroubleTicket]] Trouble ticket associated with this hazard.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class IncidentHazard
(
    override val sup: Hazard = null,
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
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { clone ().asInstanceOf[IncidentHazard] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:IncidentHazard rdf:ID=\"%s\">\n%s\t</cim:IncidentHazard>".format (id, export_fields)
    }
}

object IncidentHazard
extends
    Parseable[IncidentHazard]
{
    override val fields: Array[String] = Array[String] (
        "Incident",
        "TroubleTicket"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Incident", "Incident", "0..1", "0..*"),
        Relationship ("TroubleTicket", "TroubleTicket", "0..1", "0..*")
    )
    val Incident: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TroubleTicket: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): IncidentHazard =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IncidentHazard (
            Hazard.parse (context),
            mask (Incident (), 0),
            mask (TroubleTicket (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Grouping of pricing components and prices used in the creation of customer charges and the eligibility criteria under which these terms may be offered to a customer.
 *
 * The reasons for grouping include state, customer classification, site characteristics, classification (i.e. fee price structure, deposit price structure, electric service price structure, etc.) and accounting requirements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    override val sup: Document = null,
    code: String = null,
    dailyCeilingUsage: Int = 0,
    dailyEstimatedUsage: Int = 0,
    dailyFloorUsage: Int = 0,
    revenueKind: String = null,
    taxExemption: Boolean = false,
    CustomerAgreements: List[String] = List(),
    ServiceCategory: String = null,
    Tariffs: List[String] = List(),
    Transactions: List[String] = List(),
    UsagePoints: List[String] = List()
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[PricingStructure] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:PricingStructure rdf:ID=\"%s\">\n%s\t</cim:PricingStructure>".format (id, export_fields)
    }
}

object PricingStructure
extends
    Parseable[PricingStructure]
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
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        Relationship ("ServiceCategory", "ServiceCategory", "1", "0..*"),
        Relationship ("Tariffs", "Tariff", "0..*", "0..*"),
        Relationship ("Transactions", "Transaction", "0..*", "0..1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
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

    def parse (context: Context): PricingStructure =
    {
        implicit val ctx: Context = context
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
}

/**
 * Category of service provided to the customer.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    override val sup: IdentifiedObject = null,
    kind: String = null,
    ConfigurationEvents: List[String] = List(),
    CustomerAgreements: List[String] = List(),
    PricingStructures: List[String] = List(),
    UsagePoints: List[String] = List()
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ServiceCategory] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:ServiceCategory rdf:ID=\"%s\">\n%s\t</cim:ServiceCategory>".format (id, export_fields)
    }
}

object ServiceCategory
extends
    Parseable[ServiceCategory]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "ConfigurationEvents",
        "CustomerAgreements",
        "PricingStructures",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..1"),
        Relationship ("PricingStructures", "PricingStructure", "0..*", "1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ServiceCategory =
    {
        implicit val ctx: Context = context
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
}

/**
 * A real estate location, commonly referred to as premises.
 *
 * @param sup [[ch.ninecode.model.WorkLocation WorkLocation]] Reference to the superclass object.
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
    override val sup: WorkLocation = null,
    accessMethod: String = null,
    needsInspection: Boolean = false,
    siteAccessProblem: String = null,
    CustomerAgreements: List[String] = List(),
    EndDevices: List[String] = List(),
    TroubleTicket: List[String] = List(),
    UsagePoints: List[String] = List()
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
    def WorkLocation: WorkLocation = sup.asInstanceOf[WorkLocation]
    override def copy (): Row = { clone ().asInstanceOf[ServiceLocation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:ServiceLocation rdf:ID=\"%s\">\n%s\t</cim:ServiceLocation>".format (id, export_fields)
    }
}

object ServiceLocation
extends
    Parseable[ServiceLocation]
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
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        Relationship ("TroubleTicket", "TroubleTicket", "0..*", "1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val accessMethod: Fielder = parse_element (element (cls, fields(0)))
    val needsInspection: Fielder = parse_element (element (cls, fields(1)))
    val siteAccessProblem: Fielder = parse_element (element (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TroubleTicket: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): ServiceLocation =
    {
        implicit val ctx: Context = context
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
}

/**
 * Document, approved by the responsible regulatory agency, listing the terms and conditions, including a schedule of prices, under which utility services will be provided.
 *
 * It has a unique number within the state or province. For rate schedules it is frequently allocated by the affiliated Public utilities commission (PUC).
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
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
    override val sup: Document = null,
    endDate: String = null,
    startDate: String = null,
    PricingStructures: List[String] = List(),
    TariffProfiles: List[String] = List()
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Tariff] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        "\t<cim:Tariff rdf:ID=\"%s\">\n%s\t</cim:Tariff>".format (id, export_fields)
    }
}

object Tariff
extends
    Parseable[Tariff]
{
    override val fields: Array[String] = Array[String] (
        "endDate",
        "startDate",
        "PricingStructures",
        "TariffProfiles"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PricingStructures", "PricingStructure", "0..*", "0..*"),
        Relationship ("TariffProfiles", "TariffProfile", "0..*", "0..*")
    )
    val endDate: Fielder = parse_element (element (cls, fields(0)))
    val startDate: Fielder = parse_element (element (cls, fields(1)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Tariff =
    {
        implicit val ctx: Context = context
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
}

/**

 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
final case class TroubleTicket
(
    override val sup: Document = null,
    comment: String = null,
    dateTimeOfReport: String = null,
    firstResponderStatus: String = null,
    multiplePremises: Boolean = false,
    reportingKind: String = null,
    resolvedDateTime: String = null,
    troubleCode: String = null,
    Customer: String = null,
    Incident: String = null,
    IncidentHazard: List[String] = List(),
    Notification: String = null,
    ServiceLocation: String = null,
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[TroubleTicket] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
        emitattr (10, Notification)
        emitattr (11, ServiceLocation)
        emitattr (12, UnplannedOutage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TroubleTicket rdf:ID=\"%s\">\n%s\t</cim:TroubleTicket>".format (id, export_fields)
    }
}

object TroubleTicket
extends
    Parseable[TroubleTicket]
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
        "UnplannedOutage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Customer", "Customer", "0..1", "0..*"),
        Relationship ("Incident", "Incident", "0..1", "0..*"),
        Relationship ("IncidentHazard", "IncidentHazard", "0..*", "0..1"),
        Relationship ("Notification", "CustomerNotification", "0..1", "0..*"),
        Relationship ("ServiceLocation", "ServiceLocation", "1", "0..*"),
        Relationship ("UnplannedOutage", "UnplannedOutage", "0..1", "0..*")
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
    val Notification: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ServiceLocation: Fielder = parse_attribute (attribute (cls, fields(11)))
    val UnplannedOutage: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): TroubleTicket =
    {
        implicit val ctx: Context = context
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
            mask (Notification (), 10),
            mask (ServiceLocation (), 11),
            mask (UnplannedOutage (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Customers
{
    def register: List[ClassInfo] =
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