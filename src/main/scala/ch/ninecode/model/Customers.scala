package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support customer billing applications.
 */

/**
 * Organisation receiving services from service supplier.
 */
case class Customer
(

    override val sup: OrganisationRole,

    /**
     * Kind of customer.
     */
    val kind: String,

    /**
     * Locale designating language to use in communications with this customer.
     */
    val locale: String,

    /**
     * Priority of the customer.
     */
    val priority: String,

    /**
     * (if applicable) Public utilities commission (PUC) identification number.
     */
    val pucNumber: String,

    /**
     * True if customer organisation has special service needs such as life support, hospitals, etc.
     */
    val specialNeed: String,

    /**
     * Status of this customer.
     */
    val status: String,

    /**
     * (use 'priority' instead) True if this is an important customer.
     * Importance is for matters different than those in 'specialNeed' attribute.
     */
    val vip: Boolean,

    /**
     * All the works performed for this customer.
     */
    val Works: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, false, List()) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Customer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Customer
extends
    Parseable[Customer]
{
    val sup = OrganisationRole.parse _
    val kind = parse_attribute (attribute ("""Customer.kind"""))_
    val locale = parse_element (element ("""Customer.locale"""))_
    val priority = parse_attribute (attribute ("""Customer.priority"""))_
    val pucNumber = parse_element (element ("""Customer.pucNumber"""))_
    val specialNeed = parse_element (element ("""Customer.specialNeed"""))_
    val status = parse_attribute (attribute ("""Customer.status"""))_
    val vip = parse_element (element ("""Customer.vip"""))_
    val Works = parse_attributes (attribute ("""Customer.Works"""))_
    def parse (context: Context): Customer =
    {
        Customer(
            sup (context),
            kind (context),
            locale (context),
            priority (context),
            pucNumber (context),
            specialNeed (context),
            status (context),
            toBoolean (vip (context), context),
            Works (context)
        )
    }
}

/**
 * Assignment of a group of products and services purchased by the customer through a customer agreement, used as a mechanism for customer billing and payment.
 * It contains common information from the various types of customer agreements to create billings (invoices) for a customer and receive payment.
 */
case class CustomerAccount
(

    override val sup: Document,

    /**
     * Cycle day on which the associated customer account will normally be billed, used to determine when to produce the billing.
     */
    val billingCycle: String,

    /**
     * Budget bill code.
     */
    val budgetBill: String,

    /**
     * Customer owning this account.
     */
    val Customer: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerAccount
extends
    Parseable[CustomerAccount]
{
    val sup = Document.parse _
    val billingCycle = parse_element (element ("""CustomerAccount.billingCycle"""))_
    val budgetBill = parse_element (element ("""CustomerAccount.budgetBill"""))_
    val Customer = parse_attribute (attribute ("""CustomerAccount.Customer"""))_
    def parse (context: Context): CustomerAccount =
    {
        CustomerAccount(
            sup (context),
            billingCycle (context),
            budgetBill (context),
            Customer (context)
        )
    }
}

/**
 * Agreement between the customer and the service supplier to pay for service at a specific service location.
 * It records certain billing information about the type of service provided at the service location and is used during charge creation to determine the type of service.
 */
case class CustomerAgreement
(

    override val sup: Agreement,

    /**
     * Load management code.
     */
    val loadMgmt: String,

    /**
     * Customer for this agreement.
     */
    val Customer: String,

    /**
     * Customer account owning this agreement.
     */
    val CustomerAccount: String,

    /**
     * All pricing structures applicable to this customer agreement.
     */
    val PricingStructures: List[String],

    /**
     * Service category for this agreement.
     */
    val ServiceCategory: String,

    /**
     * All service locations regulated by this customer agreement.
     */
    val ServiceLocations: List[String],

    /**
     * Service supplier for this customer agreement.
     */
    val ServiceSupplier: String,

    val StandardIndustryCode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), null, List(), null, null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerAgreement
extends
    Parseable[CustomerAgreement]
{
    val sup = Agreement.parse _
    val loadMgmt = parse_element (element ("""CustomerAgreement.loadMgmt"""))_
    val Customer = parse_attribute (attribute ("""CustomerAgreement.Customer"""))_
    val CustomerAccount = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))_
    val PricingStructures = parse_attributes (attribute ("""CustomerAgreement.PricingStructures"""))_
    val ServiceCategory = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))_
    val ServiceLocations = parse_attributes (attribute ("""CustomerAgreement.ServiceLocations"""))_
    val ServiceSupplier = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))_
    val StandardIndustryCode = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))_
    def parse (context: Context): CustomerAgreement =
    {
        CustomerAgreement(
            sup (context),
            loadMgmt (context),
            Customer (context),
            CustomerAccount (context),
            PricingStructures (context),
            ServiceCategory (context),
            ServiceLocations (context),
            ServiceSupplier (context),
            StandardIndustryCode (context)
        )
    }
}

/**
 * Kind of customer.
 */
case class CustomerKind
(

    override val sup: BasicElement,

    /**
     * Commercial industrial customer.
     */
    val commercialIndustrial: String,

    /**
     * Customer as energy service scheduler.
     */
    val energyServiceScheduler: String,

    /**
     * Customer as energy service supplier.
     */
    val energyServiceSupplier: String,

    /**
     * Internal use customer.
     */
    val internalUse: String,

    /**
     * Other kind of customer.
     */
    val other: String,

    /**
     * Pumping load customer.
     */
    val pumpingLoad: String,

    /**
     * Residential customer.
     */
    val residential: String,

    /**
     * Residential and commercial customer.
     */
    val residentialAndCommercial: String,

    /**
     * Residential and streetlight customer.
     */
    val residentialAndStreetlight: String,

    /**
     * Residential farm service customer.
     */
    val residentialFarmService: String,

    /**
     * Residential streetlight or other related customer.
     */
    val residentialStreetlightOthers: String,

    /**
     * Wind machine customer.
     */
    val windMachine: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerKind
extends
    Parseable[CustomerKind]
{
    val sup = BasicElement.parse _
    val commercialIndustrial = parse_attribute (attribute ("""CustomerKind.commercialIndustrial"""))_
    val energyServiceScheduler = parse_attribute (attribute ("""CustomerKind.energyServiceScheduler"""))_
    val energyServiceSupplier = parse_attribute (attribute ("""CustomerKind.energyServiceSupplier"""))_
    val internalUse = parse_attribute (attribute ("""CustomerKind.internalUse"""))_
    val other = parse_attribute (attribute ("""CustomerKind.other"""))_
    val pumpingLoad = parse_attribute (attribute ("""CustomerKind.pumpingLoad"""))_
    val residential = parse_attribute (attribute ("""CustomerKind.residential"""))_
    val residentialAndCommercial = parse_attribute (attribute ("""CustomerKind.residentialAndCommercial"""))_
    val residentialAndStreetlight = parse_attribute (attribute ("""CustomerKind.residentialAndStreetlight"""))_
    val residentialFarmService = parse_attribute (attribute ("""CustomerKind.residentialFarmService"""))_
    val residentialStreetlightOthers = parse_attribute (attribute ("""CustomerKind.residentialStreetlightOthers"""))_
    val windMachine = parse_attribute (attribute ("""CustomerKind.windMachine"""))_
    def parse (context: Context): CustomerKind =
    {
        CustomerKind(
            sup (context),
            commercialIndustrial (context),
            energyServiceScheduler (context),
            energyServiceSupplier (context),
            internalUse (context),
            other (context),
            pumpingLoad (context),
            residential (context),
            residentialAndCommercial (context),
            residentialAndStreetlight (context),
            residentialFarmService (context),
            residentialStreetlightOthers (context),
            windMachine (context)
        )
    }
}

/**
 * Conditions for notifying the customer about the changes in the status of their service (e.g., outage restore, estimated restoration time, tariff or service level change, etc.)
 */
case class CustomerNotification
(

    override val sup: BasicElement,

    /**
     * Type of contact (e.g., phone, email, etc.).
     */
    val contactType: String,

    /**
     * Value of contact type (e.g., phone number, email address, etc.).
     */
    val contactValue: String,

    /**
     * Earliest date time to call the customer.
     */
    val earliestDateTimeToCall: String,

    /**
     * Latest date time to call the customer.
     */
    val latestDateTimeToCall: String,

    /**
     * Trigger for this notification.
     */
    val trigger: String,

    /**
     * Customer requiring this notification.
     */
    val Customer: String,

    /**
     * Incident as a subject of this customer notification.
     */
    val Incident: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerNotification]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerNotification
extends
    Parseable[CustomerNotification]
{
    val sup = BasicElement.parse _
    val contactType = parse_element (element ("""CustomerNotification.contactType"""))_
    val contactValue = parse_element (element ("""CustomerNotification.contactValue"""))_
    val earliestDateTimeToCall = parse_element (element ("""CustomerNotification.earliestDateTimeToCall"""))_
    val latestDateTimeToCall = parse_element (element ("""CustomerNotification.latestDateTimeToCall"""))_
    val trigger = parse_attribute (attribute ("""CustomerNotification.trigger"""))_
    val Customer = parse_attribute (attribute ("""CustomerNotification.Customer"""))_
    val Incident = parse_attribute (attribute ("""CustomerNotification.Incident"""))_
    def parse (context: Context): CustomerNotification =
    {
        CustomerNotification(
            sup (context),
            contactType (context),
            contactValue (context),
            earliestDateTimeToCall (context),
            latestDateTimeToCall (context),
            trigger (context),
            Customer (context),
            Incident (context)
        )
    }
}

/**
 * Hazardous situation associated with an incident.
 * Examples are line down, gas leak, fire, etc.
 */
case class IncidentHazard
(

    override val sup: Hazard,

    /**
     * Incident associated with this hazard.
     */
    val Incident: String,

    /**
     * Trouble ticket associated with this hazard.
     */
    val TroubleTicket: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Hazard: Hazard = sup.asInstanceOf[Hazard]
    override def copy (): Row = { return (clone ().asInstanceOf[IncidentHazard]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IncidentHazard
extends
    Parseable[IncidentHazard]
{
    val sup = Hazard.parse _
    val Incident = parse_attribute (attribute ("""IncidentHazard.Incident"""))_
    val TroubleTicket = parse_attribute (attribute ("""IncidentHazard.TroubleTicket"""))_
    def parse (context: Context): IncidentHazard =
    {
        IncidentHazard(
            sup (context),
            Incident (context),
            TroubleTicket (context)
        )
    }
}

/**
 * Kind of trigger to notify customer.
 */
case class NotificationTriggerKind
(

    override val sup: BasicElement,

    /**
     * Notify customer if estimated restoration time changes.
     */
    val etrChange: String,

    /**
     * Notify customer that a crew has been dispatched to investigate the problem.
     */
    val informDispatched: String,

    /**
     * Notify customer for the first time that estimated restoration time is available.
     */
    val initialEtr: String,

    /**
     * Notify customer of planned outage.
     */
    val powerOut: String,

    /**
     * Notify customer when power has been restored.
     */
    val powerRestored: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[NotificationTriggerKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NotificationTriggerKind
extends
    Parseable[NotificationTriggerKind]
{
    val sup = BasicElement.parse _
    val etrChange = parse_attribute (attribute ("""NotificationTriggerKind.etrChange"""))_
    val informDispatched = parse_attribute (attribute ("""NotificationTriggerKind.informDispatched"""))_
    val initialEtr = parse_attribute (attribute ("""NotificationTriggerKind.initialEtr"""))_
    val powerOut = parse_attribute (attribute ("""NotificationTriggerKind.powerOut"""))_
    val powerRestored = parse_attribute (attribute ("""NotificationTriggerKind.powerRestored"""))_
    def parse (context: Context): NotificationTriggerKind =
    {
        NotificationTriggerKind(
            sup (context),
            etrChange (context),
            informDispatched (context),
            initialEtr (context),
            powerOut (context),
            powerRestored (context)
        )
    }
}

/**
 * Grouping of pricing components and prices used in the creation of customer charges and the eligibility criteria under which these terms may be offered to a customer.
 * The reasons for grouping include state, customer classification, site characteristics, classification (i.e. fee price structure, deposit price structure, electric service price structure, etc.) and accounting requirements.
 */
case class PricingStructure
(

    override val sup: Document,

    /**
     * Unique user-allocated key for this pricing structure, used by company representatives to identify the correct price structure for allocating to a customer.
     * For rate schedules it is often prefixed by a state code.
     */
    val code: String,

    /**
     * Absolute maximum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
     */
    val dailyCeilingUsage: Int,

    /**
     * Used in place of actual computed estimated average when history of usage is not available, and typically manually entered by customer accounting.
     */
    val dailyEstimatedUsage: Int,

    /**
     * Absolute minimum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
     */
    val dailyFloorUsage: Int,

    /**
     * (accounting) Kind of revenue, often used to determine the grace period allowed, before collection actions are taken on a customer (grace periods vary between revenue classes).
     */
    val revenueKind: String,

    /**
     * True if this pricing structure is not taxable.
     */
    val taxExemption: Boolean,

    /**
     * Service category to which this pricing structure applies.
     */
    val ServiceCategory: String,

    /**
     * All tariffs used by this pricing structure.
     */
    val Tariffs: List[String],

    /**
     * All service delivery points (with prepayment meter running as a stand-alone device, with no CustomerAgreement or Customer) to which this pricing structure applies.
     */
    val UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, 0, 0, 0, null, false, null, List(), List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[PricingStructure]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PricingStructure
extends
    Parseable[PricingStructure]
{
    val sup = Document.parse _
    val code = parse_element (element ("""PricingStructure.code"""))_
    val dailyCeilingUsage = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))_
    val dailyEstimatedUsage = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))_
    val dailyFloorUsage = parse_element (element ("""PricingStructure.dailyFloorUsage"""))_
    val revenueKind = parse_attribute (attribute ("""PricingStructure.revenueKind"""))_
    val taxExemption = parse_element (element ("""PricingStructure.taxExemption"""))_
    val ServiceCategory = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))_
    val Tariffs = parse_attributes (attribute ("""PricingStructure.Tariffs"""))_
    val UsagePoints = parse_attributes (attribute ("""PricingStructure.UsagePoints"""))_
    def parse (context: Context): PricingStructure =
    {
        PricingStructure(
            sup (context),
            code (context),
            toInteger (dailyCeilingUsage (context), context),
            toInteger (dailyEstimatedUsage (context), context),
            toInteger (dailyFloorUsage (context), context),
            revenueKind (context),
            toBoolean (taxExemption (context), context),
            ServiceCategory (context),
            Tariffs (context),
            UsagePoints (context)
        )
    }
}

/**
 * Accounting classification of the type of revenue collected for the customer agreement, typically used to break down accounts for revenue accounting.
 */
case class RevenueKind
(

    override val sup: BasicElement,

    /**
     * Commercial revenue.
     */
    val commercial: String,

    /**
     * Industrial revenue.
     */
    val industrial: String,

    /**
     * Irrigation revenue.
     */
    val irrigation: String,

    /**
     * Non-residential revenue.
     */
    val nonResidential: String,

    /**
     * Other revenue kind.
     */
    val other: String,

    /**
     * Residential revenue.
     */
    val residential: String,

    /**
     * Streetlight revenue.
     */
    val streetLight: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RevenueKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RevenueKind
extends
    Parseable[RevenueKind]
{
    val sup = BasicElement.parse _
    val commercial = parse_attribute (attribute ("""RevenueKind.commercial"""))_
    val industrial = parse_attribute (attribute ("""RevenueKind.industrial"""))_
    val irrigation = parse_attribute (attribute ("""RevenueKind.irrigation"""))_
    val nonResidential = parse_attribute (attribute ("""RevenueKind.nonResidential"""))_
    val other = parse_attribute (attribute ("""RevenueKind.other"""))_
    val residential = parse_attribute (attribute ("""RevenueKind.residential"""))_
    val streetLight = parse_attribute (attribute ("""RevenueKind.streetLight"""))_
    def parse (context: Context): RevenueKind =
    {
        RevenueKind(
            sup (context),
            commercial (context),
            industrial (context),
            irrigation (context),
            nonResidential (context),
            other (context),
            residential (context),
            streetLight (context)
        )
    }
}

/**
 * Category of service provided to the customer.
 */
case class ServiceCategory
(

    override val sup: IdentifiedObject,

    /**
     * Kind of service.
     */
    val kind: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceCategory]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceCategory
extends
    Parseable[ServiceCategory]
{
    val sup = IdentifiedObject.parse _
    val kind = parse_attribute (attribute ("""ServiceCategory.kind"""))_
    def parse (context: Context): ServiceCategory =
    {
        ServiceCategory(
            sup (context),
            kind (context)
        )
    }
}

/**
 * Kind of service.
 */
case class ServiceKind
(

    override val sup: BasicElement,

    /**
     * Electricity service.
     */
    val electricity: String,

    /**
     * Gas service.
     */
    val gas: String,

    /**
     * Heat service.
     */
    val heat: String,

    /**
     * Internet service.
     */
    val internet: String,

    /**
     * Other kind of service.
     */
    val other: String,

    /**
     * Rates (e.g. tax, charge, toll, duty, tariff, etc.) service.
     */
    val rates: String,

    /**
     * Refuse (waster) service.
     */
    val refuse: String,

    /**
     * Sewerage service.
     */
    val sewerage: String,

    /**
     * Time service.
     */
    val time: String,

    /**
     * TV license service.
     */
    val tvLicence: String,

    /**
     * Water service.
     */
    val water: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceKind
extends
    Parseable[ServiceKind]
{
    val sup = BasicElement.parse _
    val electricity = parse_attribute (attribute ("""ServiceKind.electricity"""))_
    val gas = parse_attribute (attribute ("""ServiceKind.gas"""))_
    val heat = parse_attribute (attribute ("""ServiceKind.heat"""))_
    val internet = parse_attribute (attribute ("""ServiceKind.internet"""))_
    val other = parse_attribute (attribute ("""ServiceKind.other"""))_
    val rates = parse_attribute (attribute ("""ServiceKind.rates"""))_
    val refuse = parse_attribute (attribute ("""ServiceKind.refuse"""))_
    val sewerage = parse_attribute (attribute ("""ServiceKind.sewerage"""))_
    val time = parse_attribute (attribute ("""ServiceKind.time"""))_
    val tvLicence = parse_attribute (attribute ("""ServiceKind.tvLicence"""))_
    val water = parse_attribute (attribute ("""ServiceKind.water"""))_
    def parse (context: Context): ServiceKind =
    {
        ServiceKind(
            sup (context),
            electricity (context),
            gas (context),
            heat (context),
            internet (context),
            other (context),
            rates (context),
            refuse (context),
            sewerage (context),
            time (context),
            tvLicence (context),
            water (context)
        )
    }
}

/**
 * A real estate location, commonly referred to as premises.
 */
case class ServiceLocation
(

    override val sup: WorkLocation,

    /**
     * Method for the service person to access this service location.
     * For example, a description of where to obtain a key if the facility is unmanned and secured.
     */
    val accessMethod: String,

    /**
     * True if inspection is needed of facilities at this service location.
     * This could be requested by a customer, due to suspected tampering, environmental concerns (e.g., a fire in the vicinity), or to correct incompatible data.
     */
    val needsInspection: Boolean,

    /**
     * Problems previously encountered when visiting or performing work on this location.
     * Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
     */
    val siteAccessProblem: String
)
extends
    Element
{
    def this () = { this (null, null, false, null) }
    def WorkLocation: WorkLocation = sup.asInstanceOf[WorkLocation]
    override def copy (): Row = { return (clone ().asInstanceOf[ServiceLocation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceLocation
extends
    Parseable[ServiceLocation]
{
    val sup = WorkLocation.parse _
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))_
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))_
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))_
    def parse (context: Context): ServiceLocation =
    {
        ServiceLocation(
            sup (context),
            accessMethod (context),
            toBoolean (needsInspection (context), context),
            siteAccessProblem (context)
        )
    }
}

/**
 * Document, approved by the responsible regulatory agency, listing the terms and conditions, including a schedule of prices, under which utility services will be provided.
 * It has a unique number within the state or province. For rate schedules it is frequently allocated by the affiliated Public utilities commission (PUC).
 */
case class Tariff
(

    override val sup: Document,

    /**
     * (if tariff became inactive) Date tariff was terminated.
     */
    val endDate: String,

    /**
     * Date tariff was activated.
     */
    val startDate: String,

    /**
     * All tariff profiles using this tariff.
     */
    val TariffProfiles: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Tariff]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Tariff
extends
    Parseable[Tariff]
{
    val sup = Document.parse _
    val endDate = parse_element (element ("""Tariff.endDate"""))_
    val startDate = parse_element (element ("""Tariff.startDate"""))_
    val TariffProfiles = parse_attributes (attribute ("""Tariff.TariffProfiles"""))_
    def parse (context: Context): Tariff =
    {
        Tariff(
            sup (context),
            endDate (context),
            startDate (context),
            TariffProfiles (context)
        )
    }
}

/**
 * Kind of trouble reporting.
 */
case class TroubleReportingKind
(

    override val sup: BasicElement,

    /**
     * Trouble call received by customer service representative.
     */
    val call: String,

    /**
     * Trouble reported by email.
     */
    val email: String,

    /**
     * Trouble reported through interactive voice response system.
     */
    val ivr: String,

    /**
     * Trouble reported by letter.
     */
    val letter: String,

    /**
     * Trouble reported by other means.
     */
    val other: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TroubleReportingKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TroubleReportingKind
extends
    Parseable[TroubleReportingKind]
{
    val sup = BasicElement.parse _
    val call = parse_attribute (attribute ("""TroubleReportingKind.call"""))_
    val email = parse_attribute (attribute ("""TroubleReportingKind.email"""))_
    val ivr = parse_attribute (attribute ("""TroubleReportingKind.ivr"""))_
    val letter = parse_attribute (attribute ("""TroubleReportingKind.letter"""))_
    val other = parse_attribute (attribute ("""TroubleReportingKind.other"""))_
    def parse (context: Context): TroubleReportingKind =
    {
        TroubleReportingKind(
            sup (context),
            call (context),
            email (context),
            ivr (context),
            letter (context),
            other (context)
        )
    }
}

case class TroubleTicket
(

    override val sup: Document,

    /**
     * Date and time the trouble has been reported.
     */
    val dateTimeOfReport: String,

    /**
     * A first responder on site such as police, fire department etc.
     */
    val firstResponder: String,

    /**
     * Indicates how the customer reported trouble.
     */
    val reportingKind: String,

    /**
     * Date and time this trouble ticket has been resolved.
     */
    val resolvedDateTime: String,

    /**
     * Trouble code (e.g., power down, flickering lights, partial power, etc).
     */
    val troubleCode: String,

    /**
     * Customer for whom this trouble ticket is relevant.
     */
    val Customer: String,

    /**
     * Incident reported in this trouble ticket
     */
    val Incident: String,

    /**
     * Notification for this trouble ticket.
     */
    val Notification: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[TroubleTicket]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TroubleTicket
extends
    Parseable[TroubleTicket]
{
    val sup = Document.parse _
    val dateTimeOfReport = parse_element (element ("""TroubleTicket.dateTimeOfReport"""))_
    val firstResponder = parse_element (element ("""TroubleTicket.firstResponder"""))_
    val reportingKind = parse_attribute (attribute ("""TroubleTicket.reportingKind"""))_
    val resolvedDateTime = parse_element (element ("""TroubleTicket.resolvedDateTime"""))_
    val troubleCode = parse_element (element ("""TroubleTicket.troubleCode"""))_
    val Customer = parse_attribute (attribute ("""TroubleTicket.Customer"""))_
    val Incident = parse_attribute (attribute ("""TroubleTicket.Incident"""))_
    val Notification = parse_attribute (attribute ("""TroubleTicket.Notification"""))_
    def parse (context: Context): TroubleTicket =
    {
        TroubleTicket(
            sup (context),
            dateTimeOfReport (context),
            firstResponder (context),
            reportingKind (context),
            resolvedDateTime (context),
            troubleCode (context),
            Customer (context),
            Incident (context),
            Notification (context)
        )
    }
}

object _Customers
{
    def register: Unit =
    {
        Customer.register
        CustomerAccount.register
        CustomerAgreement.register
        CustomerKind.register
        CustomerNotification.register
        IncidentHazard.register
        NotificationTriggerKind.register
        PricingStructure.register
        RevenueKind.register
        ServiceCategory.register
        ServiceKind.register
        ServiceLocation.register
        Tariff.register
        TroubleReportingKind.register
        TroubleTicket.register
    }
}