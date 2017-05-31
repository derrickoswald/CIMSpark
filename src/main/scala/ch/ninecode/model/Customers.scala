package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support customer billing applications.
 */

/**
 * Organisation receiving services from service supplier.
 * @param sup Reference to the superclass object.
 * @param kind Kind of customer.
 * @param locale Locale designating language to use in communications with this customer.
 * @param priority Priority of the customer.
 * @param pucNumber (if applicable) Public utilities commission (PUC) identification number.
 * @param specialNeed True if customer organisation has special service needs such as life support, hospitals, etc.
 * @param status Status of this customer.
 * @param vip (use 'priority' instead) True if this is an important customer.
 *        Importance is for matters different than those in 'specialNeed' attribute.
 * @param Works All the works performed for this customer.
 */
case class Customer
(
    override val sup: OrganisationRole,
    val kind: String,
    val locale: String,
    val priority: String,
    val pucNumber: String,
    val specialNeed: String,
    val status: String,
    val vip: Boolean,
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
    val kind = parse_attribute (attribute ("""Customer.kind"""))
    val locale = parse_element (element ("""Customer.locale"""))
    val priority = parse_attribute (attribute ("""Customer.priority"""))
    val pucNumber = parse_element (element ("""Customer.pucNumber"""))
    val specialNeed = parse_element (element ("""Customer.specialNeed"""))
    val status = parse_attribute (attribute ("""Customer.status"""))
    val vip = parse_element (element ("""Customer.vip"""))
    val Works = parse_attributes (attribute ("""Customer.Works"""))
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
 * @param sup Reference to the superclass object.
 * @param billingCycle Cycle day on which the associated customer account will normally be billed, used to determine when to produce the billing.
 * @param budgetBill Budget bill code.
 * @param Customer Customer owning this account.
 */
case class CustomerAccount
(
    override val sup: Document,
    val billingCycle: String,
    val budgetBill: String,
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
    val billingCycle = parse_element (element ("""CustomerAccount.billingCycle"""))
    val budgetBill = parse_element (element ("""CustomerAccount.budgetBill"""))
    val Customer = parse_attribute (attribute ("""CustomerAccount.Customer"""))
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
 * @param sup Reference to the superclass object.
 * @param loadMgmt Load management code.
 * @param Customer Customer for this agreement.
 * @param CustomerAccount Customer account owning this agreement.
 * @param PricingStructures All pricing structures applicable to this customer agreement.
 * @param ServiceCategory Service category for this agreement.
 * @param ServiceLocations All service locations regulated by this customer agreement.
 * @param ServiceSupplier Service supplier for this customer agreement.
 * @param StandardIndustryCode
 */
case class CustomerAgreement
(
    override val sup: Agreement,
    val loadMgmt: String,
    val Customer: String,
    val CustomerAccount: String,
    val PricingStructures: List[String],
    val ServiceCategory: String,
    val ServiceLocations: List[String],
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
    val loadMgmt = parse_element (element ("""CustomerAgreement.loadMgmt"""))
    val Customer = parse_attribute (attribute ("""CustomerAgreement.Customer"""))
    val CustomerAccount = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))
    val PricingStructures = parse_attributes (attribute ("""CustomerAgreement.PricingStructures"""))
    val ServiceCategory = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))
    val ServiceLocations = parse_attributes (attribute ("""CustomerAgreement.ServiceLocations"""))
    val ServiceSupplier = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))
    val StandardIndustryCode = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))
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
 * @param sup Reference to the superclass object.
 * @param commercialIndustrial Commercial industrial customer.
 * @param energyServiceScheduler Customer as energy service scheduler.
 * @param energyServiceSupplier Customer as energy service supplier.
 * @param internalUse Internal use customer.
 * @param other Other kind of customer.
 * @param pumpingLoad Pumping load customer.
 * @param residential Residential customer.
 * @param residentialAndCommercial Residential and commercial customer.
 * @param residentialAndStreetlight Residential and streetlight customer.
 * @param residentialFarmService Residential farm service customer.
 * @param residentialStreetlightOthers Residential streetlight or other related customer.
 * @param windMachine Wind machine customer.
 */
case class CustomerKind
(
    override val sup: BasicElement,
    val commercialIndustrial: String,
    val energyServiceScheduler: String,
    val energyServiceSupplier: String,
    val internalUse: String,
    val other: String,
    val pumpingLoad: String,
    val residential: String,
    val residentialAndCommercial: String,
    val residentialAndStreetlight: String,
    val residentialFarmService: String,
    val residentialStreetlightOthers: String,
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
    val commercialIndustrial = parse_attribute (attribute ("""CustomerKind.commercialIndustrial"""))
    val energyServiceScheduler = parse_attribute (attribute ("""CustomerKind.energyServiceScheduler"""))
    val energyServiceSupplier = parse_attribute (attribute ("""CustomerKind.energyServiceSupplier"""))
    val internalUse = parse_attribute (attribute ("""CustomerKind.internalUse"""))
    val other = parse_attribute (attribute ("""CustomerKind.other"""))
    val pumpingLoad = parse_attribute (attribute ("""CustomerKind.pumpingLoad"""))
    val residential = parse_attribute (attribute ("""CustomerKind.residential"""))
    val residentialAndCommercial = parse_attribute (attribute ("""CustomerKind.residentialAndCommercial"""))
    val residentialAndStreetlight = parse_attribute (attribute ("""CustomerKind.residentialAndStreetlight"""))
    val residentialFarmService = parse_attribute (attribute ("""CustomerKind.residentialFarmService"""))
    val residentialStreetlightOthers = parse_attribute (attribute ("""CustomerKind.residentialStreetlightOthers"""))
    val windMachine = parse_attribute (attribute ("""CustomerKind.windMachine"""))
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
 * @param sup Reference to the superclass object.
 * @param contactType Type of contact (e.g., phone, email, etc.).
 * @param contactValue Value of contact type (e.g., phone number, email address, etc.).
 * @param earliestDateTimeToCall Earliest date time to call the customer.
 * @param latestDateTimeToCall Latest date time to call the customer.
 * @param trigger Trigger for this notification.
 * @param Customer Customer requiring this notification.
 * @param Incident Incident as a subject of this customer notification.
 */
case class CustomerNotification
(
    override val sup: BasicElement,
    val contactType: String,
    val contactValue: String,
    val earliestDateTimeToCall: String,
    val latestDateTimeToCall: String,
    val trigger: String,
    val Customer: String,
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
    val contactType = parse_element (element ("""CustomerNotification.contactType"""))
    val contactValue = parse_element (element ("""CustomerNotification.contactValue"""))
    val earliestDateTimeToCall = parse_element (element ("""CustomerNotification.earliestDateTimeToCall"""))
    val latestDateTimeToCall = parse_element (element ("""CustomerNotification.latestDateTimeToCall"""))
    val trigger = parse_attribute (attribute ("""CustomerNotification.trigger"""))
    val Customer = parse_attribute (attribute ("""CustomerNotification.Customer"""))
    val Incident = parse_attribute (attribute ("""CustomerNotification.Incident"""))
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
 * @param sup Reference to the superclass object.
 * @param Incident Incident associated with this hazard.
 * @param TroubleTicket Trouble ticket associated with this hazard.
 */
case class IncidentHazard
(
    override val sup: Hazard,
    val Incident: String,
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
    val Incident = parse_attribute (attribute ("""IncidentHazard.Incident"""))
    val TroubleTicket = parse_attribute (attribute ("""IncidentHazard.TroubleTicket"""))
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
 * @param sup Reference to the superclass object.
 * @param etrChange Notify customer if estimated restoration time changes.
 * @param informDispatched Notify customer that a crew has been dispatched to investigate the problem.
 * @param initialEtr Notify customer for the first time that estimated restoration time is available.
 * @param powerOut Notify customer of planned outage.
 * @param powerRestored Notify customer when power has been restored.
 */
case class NotificationTriggerKind
(
    override val sup: BasicElement,
    val etrChange: String,
    val informDispatched: String,
    val initialEtr: String,
    val powerOut: String,
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
    val etrChange = parse_attribute (attribute ("""NotificationTriggerKind.etrChange"""))
    val informDispatched = parse_attribute (attribute ("""NotificationTriggerKind.informDispatched"""))
    val initialEtr = parse_attribute (attribute ("""NotificationTriggerKind.initialEtr"""))
    val powerOut = parse_attribute (attribute ("""NotificationTriggerKind.powerOut"""))
    val powerRestored = parse_attribute (attribute ("""NotificationTriggerKind.powerRestored"""))
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
 * @param sup Reference to the superclass object.
 * @param code Unique user-allocated key for this pricing structure, used by company representatives to identify the correct price structure for allocating to a customer.
 *        For rate schedules it is often prefixed by a state code.
 * @param dailyCeilingUsage Absolute maximum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param dailyEstimatedUsage Used in place of actual computed estimated average when history of usage is not available, and typically manually entered by customer accounting.
 * @param dailyFloorUsage Absolute minimum valid non-demand usage quantity used in validating a customer's billed non-demand usage.
 * @param revenueKind (accounting) Kind of revenue, often used to determine the grace period allowed, before collection actions are taken on a customer (grace periods vary between revenue classes).
 * @param taxExemption True if this pricing structure is not taxable.
 * @param ServiceCategory Service category to which this pricing structure applies.
 * @param Tariffs All tariffs used by this pricing structure.
 * @param UsagePoints All service delivery points (with prepayment meter running as a stand-alone device, with no CustomerAgreement or Customer) to which this pricing structure applies.
 */
case class PricingStructure
(
    override val sup: Document,
    val code: String,
    val dailyCeilingUsage: Int,
    val dailyEstimatedUsage: Int,
    val dailyFloorUsage: Int,
    val revenueKind: String,
    val taxExemption: Boolean,
    val ServiceCategory: String,
    val Tariffs: List[String],
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
    val code = parse_element (element ("""PricingStructure.code"""))
    val dailyCeilingUsage = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))
    val dailyEstimatedUsage = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))
    val dailyFloorUsage = parse_element (element ("""PricingStructure.dailyFloorUsage"""))
    val revenueKind = parse_attribute (attribute ("""PricingStructure.revenueKind"""))
    val taxExemption = parse_element (element ("""PricingStructure.taxExemption"""))
    val ServiceCategory = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))
    val Tariffs = parse_attributes (attribute ("""PricingStructure.Tariffs"""))
    val UsagePoints = parse_attributes (attribute ("""PricingStructure.UsagePoints"""))
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
 * @param sup Reference to the superclass object.
 * @param commercial Commercial revenue.
 * @param industrial Industrial revenue.
 * @param irrigation Irrigation revenue.
 * @param nonResidential Non-residential revenue.
 * @param other Other revenue kind.
 * @param residential Residential revenue.
 * @param streetLight Streetlight revenue.
 */
case class RevenueKind
(
    override val sup: BasicElement,
    val commercial: String,
    val industrial: String,
    val irrigation: String,
    val nonResidential: String,
    val other: String,
    val residential: String,
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
    val commercial = parse_attribute (attribute ("""RevenueKind.commercial"""))
    val industrial = parse_attribute (attribute ("""RevenueKind.industrial"""))
    val irrigation = parse_attribute (attribute ("""RevenueKind.irrigation"""))
    val nonResidential = parse_attribute (attribute ("""RevenueKind.nonResidential"""))
    val other = parse_attribute (attribute ("""RevenueKind.other"""))
    val residential = parse_attribute (attribute ("""RevenueKind.residential"""))
    val streetLight = parse_attribute (attribute ("""RevenueKind.streetLight"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Kind of service.
 */
case class ServiceCategory
(
    override val sup: IdentifiedObject,
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
    val kind = parse_attribute (attribute ("""ServiceCategory.kind"""))
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
 * @param sup Reference to the superclass object.
 * @param electricity Electricity service.
 * @param gas Gas service.
 * @param heat Heat service.
 * @param internet Internet service.
 * @param other Other kind of service.
 * @param rates Rates (e.g. tax, charge, toll, duty, tariff, etc.) service.
 * @param refuse Refuse (waster) service.
 * @param sewerage Sewerage service.
 * @param time Time service.
 * @param tvLicence TV license service.
 * @param water Water service.
 */
case class ServiceKind
(
    override val sup: BasicElement,
    val electricity: String,
    val gas: String,
    val heat: String,
    val internet: String,
    val other: String,
    val rates: String,
    val refuse: String,
    val sewerage: String,
    val time: String,
    val tvLicence: String,
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
    val electricity = parse_attribute (attribute ("""ServiceKind.electricity"""))
    val gas = parse_attribute (attribute ("""ServiceKind.gas"""))
    val heat = parse_attribute (attribute ("""ServiceKind.heat"""))
    val internet = parse_attribute (attribute ("""ServiceKind.internet"""))
    val other = parse_attribute (attribute ("""ServiceKind.other"""))
    val rates = parse_attribute (attribute ("""ServiceKind.rates"""))
    val refuse = parse_attribute (attribute ("""ServiceKind.refuse"""))
    val sewerage = parse_attribute (attribute ("""ServiceKind.sewerage"""))
    val time = parse_attribute (attribute ("""ServiceKind.time"""))
    val tvLicence = parse_attribute (attribute ("""ServiceKind.tvLicence"""))
    val water = parse_attribute (attribute ("""ServiceKind.water"""))
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
 * @param sup Reference to the superclass object.
 * @param accessMethod Method for the service person to access this service location.
 *        For example, a description of where to obtain a key if the facility is unmanned and secured.
 * @param needsInspection True if inspection is needed of facilities at this service location.
 *        This could be requested by a customer, due to suspected tampering, environmental concerns (e.g., a fire in the vicinity), or to correct incompatible data.
 * @param siteAccessProblem Problems previously encountered when visiting or performing work on this location.
 *        Examples include: bad dog, violent customer, verbally abusive occupant, obstructions, safety hazards, etc.
 */
case class ServiceLocation
(
    override val sup: WorkLocation,
    val accessMethod: String,
    val needsInspection: Boolean,
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
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))
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
 * @param sup Reference to the superclass object.
 * @param endDate (if tariff became inactive) Date tariff was terminated.
 * @param startDate Date tariff was activated.
 * @param TariffProfiles All tariff profiles using this tariff.
 */
case class Tariff
(
    override val sup: Document,
    val endDate: String,
    val startDate: String,
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
    val endDate = parse_element (element ("""Tariff.endDate"""))
    val startDate = parse_element (element ("""Tariff.startDate"""))
    val TariffProfiles = parse_attributes (attribute ("""Tariff.TariffProfiles"""))
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
 * @param sup Reference to the superclass object.
 * @param call Trouble call received by customer service representative.
 * @param email Trouble reported by email.
 * @param ivr Trouble reported through interactive voice response system.
 * @param letter Trouble reported by letter.
 * @param other Trouble reported by other means.
 */
case class TroubleReportingKind
(
    override val sup: BasicElement,
    val call: String,
    val email: String,
    val ivr: String,
    val letter: String,
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
    val call = parse_attribute (attribute ("""TroubleReportingKind.call"""))
    val email = parse_attribute (attribute ("""TroubleReportingKind.email"""))
    val ivr = parse_attribute (attribute ("""TroubleReportingKind.ivr"""))
    val letter = parse_attribute (attribute ("""TroubleReportingKind.letter"""))
    val other = parse_attribute (attribute ("""TroubleReportingKind.other"""))
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
    val dateTimeOfReport: String,
    val firstResponder: String,
    val reportingKind: String,
    val resolvedDateTime: String,
    val troubleCode: String,
    val Customer: String,
    val Incident: String,
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
    val dateTimeOfReport = parse_element (element ("""TroubleTicket.dateTimeOfReport"""))
    val firstResponder = parse_element (element ("""TroubleTicket.firstResponder"""))
    val reportingKind = parse_attribute (attribute ("""TroubleTicket.reportingKind"""))
    val resolvedDateTime = parse_element (element ("""TroubleTicket.resolvedDateTime"""))
    val troubleCode = parse_element (element ("""TroubleTicket.troubleCode"""))
    val Customer = parse_attribute (attribute ("""TroubleTicket.Customer"""))
    val Incident = parse_attribute (attribute ("""TroubleTicket.Incident"""))
    val Notification = parse_attribute (attribute ("""TroubleTicket.Notification"""))
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