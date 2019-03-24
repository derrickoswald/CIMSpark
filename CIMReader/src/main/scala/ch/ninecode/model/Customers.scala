package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
 * @param vip (use 'priority' instead) True if this is an important customer.
 *        Importance is for matters different than those in 'specialNeed' attribute.
 * @param CustomerAccounts [[ch.ninecode.model.CustomerAccount CustomerAccount]] All accounts of this customer.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All agreements of this customer.
 * @param EndDevices [[ch.ninecode.model.EndDevice EndDevice]] All end devices of this customer.
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param Notifications [[ch.ninecode.model.CustomerNotification CustomerNotification]] All notifications required by this customer.
 * @param TroubleTickets [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets for this customer.
 * @param Works [[ch.ninecode.model.Work Work]] All the works performed for this customer.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
case class Customer
(
    override val sup: OrganisationRole,
    kind: String,
    locale: String,
    priority: String,
    pucNumber: String,
    specialNeed: String,
    status: String,
    vip: Boolean,
    CustomerAccounts: List[String],
    CustomerAgreements: List[String],
    EndDevices: List[String],
    ErpPersons: List[String],
    Notifications: List[String],
    TroubleTickets: List[String],
    Works: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, false, List(), List(), List(), List(), List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Customer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Customer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Customer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Customer.fields (position), x))
        emitattr (0, kind)
        emitelem (1, locale)
        emitattr (2, priority)
        emitelem (3, pucNumber)
        emitelem (4, specialNeed)
        emitattr (5, status)
        emitelem (6, vip)
        emitattrs (7, CustomerAccounts)
        emitattrs (8, CustomerAgreements)
        emitattrs (9, EndDevices)
        emitattrs (10, ErpPersons)
        emitattrs (11, Notifications)
        emitattrs (12, TroubleTickets)
        emitattrs (13, Works)
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
        "EndDevices",
        "ErpPersons",
        "Notifications",
        "TroubleTickets",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAccounts", "CustomerAccount", "0..*", "1"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        Relationship ("ErpPersons", "OldPerson", "0..*", "0..1"),
        Relationship ("Notifications", "CustomerNotification", "0..*", "0..1"),
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
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val Notifications: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): Customer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
            masks (EndDevices (), 9),
            masks (ErpPersons (), 10),
            masks (Notifications (), 11),
            masks (TroubleTickets (), 12),
            masks (Works (), 13)
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
case class CustomerAccount
(
    override val sup: Document,
    billingCycle: String,
    budgetBill: String,
    Customer: String,
    CustomerAgreements: List[String],
    CustomerBillingInfos: List[String],
    ErpInvoicees: List[String],
    PaymentTransactions: List[String],
    WorkBillingInfos: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List(), List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CustomerAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CustomerAccount.fields (position), x))
        emitelem (0, billingCycle)
        emitelem (1, budgetBill)
        emitattr (2, Customer)
        emitattrs (3, CustomerAgreements)
        emitattrs (4, CustomerBillingInfos)
        emitattrs (5, ErpInvoicees)
        emitattrs (6, PaymentTransactions)
        emitattrs (7, WorkBillingInfos)
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
        "Customer",
        "CustomerAgreements",
        "CustomerBillingInfos",
        "ErpInvoicees",
        "PaymentTransactions",
        "WorkBillingInfos"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Customer", "Customer", "1", "0..*"),
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        Relationship ("CustomerBillingInfos", "CustomerBillingInfo", "0..*", "0..1"),
        Relationship ("ErpInvoicees", "ErpInvoice", "0..*", "0..1"),
        Relationship ("PaymentTransactions", "Transaction", "0..*", "0..1"),
        Relationship ("WorkBillingInfos", "WorkBillingInfo", "0..*", "0..1")
    )
    val billingCycle: Fielder = parse_element (element (cls, fields(0)))
    val budgetBill: Fielder = parse_element (element (cls, fields(1)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CustomerBillingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ErpInvoicees: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PaymentTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val WorkBillingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): CustomerAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CustomerAccount (
            Document.parse (context),
            mask (billingCycle (), 0),
            mask (budgetBill (), 1),
            mask (Customer (), 2),
            masks (CustomerAgreements (), 3),
            masks (CustomerBillingInfos (), 4),
            masks (ErpInvoicees (), 5),
            masks (PaymentTransactions (), 6),
            masks (WorkBillingInfos (), 7)
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
 * @param loadMgmt Load management code.
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
case class CustomerAgreement
(
    override val sup: Agreement,
    loadMgmt: String,
    AuxiliaryAgreements: List[String],
    Customer: String,
    CustomerAccount: String,
    DemandResponsePrograms: List[String],
    MeterReadings: List[String],
    PricingStructures: List[String],
    ServiceCategory: String,
    ServiceLocations: List[String],
    ServiceSupplier: String,
    StandardIndustryCode: String,
    UsagePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null, null, List(), List(), List(), null, List(), null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CustomerAgreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerAgreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerAgreement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CustomerAgreement.fields (position), x))
        emitelem (0, loadMgmt)
        emitattrs (1, AuxiliaryAgreements)
        emitattr (2, Customer)
        emitattr (3, CustomerAccount)
        emitattrs (4, DemandResponsePrograms)
        emitattrs (5, MeterReadings)
        emitattrs (6, PricingStructures)
        emitattr (7, ServiceCategory)
        emitattrs (8, ServiceLocations)
        emitattr (9, ServiceSupplier)
        emitattr (10, StandardIndustryCode)
        emitattrs (11, UsagePoints)
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
        "loadMgmt",
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
    val loadMgmt: Fielder = parse_element (element (cls, fields(0)))
    val AuxiliaryAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(3)))
    val DemandResponsePrograms: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MeterReadings: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PricingStructures: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ServiceCategory: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ServiceLocations: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields(9)))
    val StandardIndustryCode: Fielder = parse_attribute (attribute (cls, fields(10)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: Context): CustomerAgreement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CustomerAgreement (
            Agreement.parse (context),
            mask (loadMgmt (), 0),
            masks (AuxiliaryAgreements (), 1),
            mask (Customer (), 2),
            mask (CustomerAccount (), 3),
            masks (DemandResponsePrograms (), 4),
            masks (MeterReadings (), 5),
            masks (PricingStructures (), 6),
            mask (ServiceCategory (), 7),
            masks (ServiceLocations (), 8),
            mask (ServiceSupplier (), 9),
            mask (StandardIndustryCode (), 10),
            masks (UsagePoints (), 11)
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
case class CustomerNotification
(
    override val sup: BasicElement,
    contactType: String,
    contactValue: String,
    earliestDateTimeToCall: String,
    latestDateTimeToCall: String,
    trigger: String,
    Customer: String,
    Incident: String,
    TroubleTickets: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CustomerNotification.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CustomerNotification.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CustomerNotification.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (CustomerNotification.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class IncidentHazard
(
    override val sup: Hazard,
    Incident: String,
    TroubleTicket: String
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
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { clone ().asInstanceOf[IncidentHazard] }
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class PricingStructure
(
    override val sup: Document,
    code: String,
    dailyCeilingUsage: Int,
    dailyEstimatedUsage: Int,
    dailyFloorUsage: Int,
    revenueKind: String,
    taxExemption: Boolean,
    CustomerAgreements: List[String],
    ServiceCategory: String,
    Tariffs: List[String],
    Transactions: List[String],
    UsagePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0, 0, 0, null, false, List(), null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PricingStructure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PricingStructure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PricingStructure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PricingStructure.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class ServiceCategory
(
    override val sup: IdentifiedObject,
    kind: String,
    ConfigurationEvents: List[String],
    CustomerAgreements: List[String],
    PricingStructures: List[String],
    UsagePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceCategory.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ServiceCategory.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points delivering service (of the same type) to this service location.
 * @group Customers
 * @groupname Customers Package Customers
 * @groupdesc Customers This package contains the core information classes that support customer billing applications.
 */
case class ServiceLocation
(
    override val sup: WorkLocation,
    accessMethod: String,
    needsInspection: Boolean,
    siteAccessProblem: String,
    CustomerAgreements: List[String],
    EndDevices: List[String],
    UsagePoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, List(), List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceLocation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceLocation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ServiceLocation.fields (position), x))
        emitelem (0, accessMethod)
        emitelem (1, needsInspection)
        emitelem (2, siteAccessProblem)
        emitattrs (3, CustomerAgreements)
        emitattrs (4, EndDevices)
        emitattrs (5, UsagePoints)
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
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerAgreements", "CustomerAgreement", "0..*", "0..*"),
        Relationship ("EndDevices", "EndDevice", "0..*", "0..1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val accessMethod: Fielder = parse_element (element (cls, fields(0)))
    val needsInspection: Fielder = parse_element (element (cls, fields(1)))
    val siteAccessProblem: Fielder = parse_element (element (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EndDevices: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): ServiceLocation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ServiceLocation (
            WorkLocation.parse (context),
            mask (accessMethod (), 0),
            toBoolean (mask (needsInspection (), 1)),
            mask (siteAccessProblem (), 2),
            masks (CustomerAgreements (), 3),
            masks (EndDevices (), 4),
            masks (UsagePoints (), 5)
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
case class Tariff
(
    override val sup: Document,
    endDate: String,
    startDate: String,
    PricingStructures: List[String],
    TariffProfiles: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tariff.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tariff.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Tariff.fields (position), x))
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
        implicit var bitfields: Array[Int] = Array(0)
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
case class TroubleTicket
(
    override val sup: Document,
    dateTimeOfReport: String,
    firstResponder: String,
    reportingKind: String,
    resolvedDateTime: String,
    troubleCode: String,
    Customer: String,
    Hazards: List[String],
    Incident: String,
    Notification: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), null, null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TroubleTicket.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TroubleTicket.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TroubleTicket.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TroubleTicket.fields (position), x))
        emitelem (0, dateTimeOfReport)
        emitelem (1, firstResponder)
        emitattr (2, reportingKind)
        emitelem (3, resolvedDateTime)
        emitelem (4, troubleCode)
        emitattr (5, Customer)
        emitattrs (6, Hazards)
        emitattr (7, Incident)
        emitattr (8, Notification)
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
        "dateTimeOfReport",
        "firstResponder",
        "reportingKind",
        "resolvedDateTime",
        "troubleCode",
        "Customer",
        "Hazards",
        "Incident",
        "Notification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Customer", "Customer", "0..1", "0..*"),
        Relationship ("Hazards", "IncidentHazard", "0..*", "0..1"),
        Relationship ("Incident", "Incident", "0..1", "0..*"),
        Relationship ("Notification", "CustomerNotification", "0..1", "0..*")
    )
    val dateTimeOfReport: Fielder = parse_element (element (cls, fields(0)))
    val firstResponder: Fielder = parse_element (element (cls, fields(1)))
    val reportingKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val resolvedDateTime: Fielder = parse_element (element (cls, fields(3)))
    val troubleCode: Fielder = parse_element (element (cls, fields(4)))
    val Customer: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Hazards: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Notification: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): TroubleTicket =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TroubleTicket (
            Document.parse (context),
            mask (dateTimeOfReport (), 0),
            mask (firstResponder (), 1),
            mask (reportingKind (), 2),
            mask (resolvedDateTime (), 3),
            mask (troubleCode (), 4),
            mask (Customer (), 5),
            masks (Hazards (), 6),
            mask (Incident (), 7),
            mask (Notification (), 8)
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