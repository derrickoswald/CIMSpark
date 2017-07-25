package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Customers
 */

case class Customer
(
    override val sup: OrganisationRole,
    val kind: String,
    val locale: String,
    val pucNumber: String,
    val specialNeed: String,
    val vip: Boolean,
    val priority: String,
    val status: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, false, null, null) }
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
    val kind = parse_attribute (attribute ("""Customer.kind"""))
    val locale = parse_element (element ("""Customer.locale"""))
    val pucNumber = parse_element (element ("""Customer.pucNumber"""))
    val specialNeed = parse_element (element ("""Customer.specialNeed"""))
    val vip = parse_element (element ("""Customer.vip"""))
    val priority = parse_attribute (attribute ("""Customer.priority"""))
    val status = parse_attribute (attribute ("""Customer.status"""))
    def parse (context: Context): Customer =
    {
        return (
            Customer
            (
                OrganisationRole.parse (context),
                kind (context),
                locale (context),
                pucNumber (context),
                specialNeed (context),
                toBoolean (vip (context), context),
                priority (context),
                status (context)
            )
        )
    }
}

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
    val billingCycle = parse_element (element ("""CustomerAccount.billingCycle"""))
    val budgetBill = parse_element (element ("""CustomerAccount.budgetBill"""))
    val Customer = parse_attribute (attribute ("""CustomerAccount.Customer"""))
    def parse (context: Context): CustomerAccount =
    {
        return (
            CustomerAccount
            (
                Document.parse (context),
                billingCycle (context),
                budgetBill (context),
                Customer (context)
            )
        )
    }
}

case class CustomerAgreement
(
    override val sup: Agreement,
    val loadMgmt: String,
    val Customer: String,
    val CustomerAccount: String,
    val ServiceCategory: String,
    val ServiceSupplier: String,
    val StandardIndustryCode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
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
    val loadMgmt = parse_element (element ("""CustomerAgreement.loadMgmt"""))
    val Customer = parse_attribute (attribute ("""CustomerAgreement.Customer"""))
    val CustomerAccount = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))
    val ServiceCategory = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))
    val ServiceSupplier = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))
    val StandardIndustryCode = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))
    def parse (context: Context): CustomerAgreement =
    {
        return (
            CustomerAgreement
            (
                Agreement.parse (context),
                loadMgmt (context),
                Customer (context),
                CustomerAccount (context),
                ServiceCategory (context),
                ServiceSupplier (context),
                StandardIndustryCode (context)
            )
        )
    }
}

case class PricingStructure
(
    override val sup: Document,
    val code: String,
    val dailyCeilingUsage: String,
    val dailyEstimatedUsage: String,
    val dailyFloorUsage: String,
    val revenueKind: String,
    val taxExemption: Boolean,
    val ServiceCategory: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, false, null) }
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
    val code = parse_element (element ("""PricingStructure.code"""))
    val dailyCeilingUsage = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))
    val dailyEstimatedUsage = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))
    val dailyFloorUsage = parse_element (element ("""PricingStructure.dailyFloorUsage"""))
    val revenueKind = parse_attribute (attribute ("""PricingStructure.revenueKind"""))
    val taxExemption = parse_element (element ("""PricingStructure.taxExemption"""))
    val ServiceCategory = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))
    def parse (context: Context): PricingStructure =
    {
        return (
            PricingStructure
            (
                Document.parse (context),
                code (context),
                dailyCeilingUsage (context),
                dailyEstimatedUsage (context),
                dailyFloorUsage (context),
                revenueKind (context),
                toBoolean (taxExemption (context), context),
                ServiceCategory (context)
            )
        )
    }
}

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
    val kind = parse_attribute (attribute ("""ServiceCategory.kind"""))
    def parse (context: Context): ServiceCategory =
    {
        return (
            ServiceCategory
            (
                IdentifiedObject.parse (context),
                kind (context)
            )
        )
    }
}

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
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))
    def parse (context: Context): ServiceLocation =
    {
        return (
            ServiceLocation
            (
                WorkLocation.parse (context),
                accessMethod (context),
                toBoolean (needsInspection (context), context),
                siteAccessProblem (context)
            )
        )
    }
}

case class Tariff
(
    override val sup: Document,
    val endDate: String,
    val startDate: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
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
    val endDate = parse_element (element ("""Tariff.endDate"""))
    val startDate = parse_element (element ("""Tariff.startDate"""))
    def parse (context: Context): Tariff =
    {
        return (
            Tariff
            (
                Document.parse (context),
                endDate (context),
                startDate (context)
            )
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
        PricingStructure.register
        ServiceCategory.register
        ServiceLocation.register
        Tariff.register
    }
}
