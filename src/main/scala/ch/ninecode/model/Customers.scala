package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class Agreement
(
    override val sup: Element,
    val signDate: String, // ToDo: Date handling
    val validityInterval: String // ToDo: DateTime handling
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Agreement]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Agreement
extends
    Parseable[Agreement]
with
    Parser
{
    val signDate = parse_element (element ("""Agreement.signDate"""))_
    val validityInterval = parse_attribute (attribute ("""Agreement.validityInterval"""))_
    def parse (context: Context): Agreement =
    {
        return (
            Agreement
            (
                OrganisationRole.parse (context),
                signDate (context),
                validityInterval (context)
            )
        )
    }
}

case class Customer
(
    override val sup: Element,
    val kind: String,
    val locale: String,
    val pucNumber: String,
    val specialNeed: String,
    val vip: Boolean,
    val priority: String,
    val status: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Customer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Customer
extends
    Parseable[Customer]
with
    Parser
{
    val kind = parse_attribute (attribute ("""Customer.kind"""))_
    val locale = parse_element (element ("""Customer.locale"""))_
    val pucNumber = parse_element (element ("""Customer.pucNumber"""))_
    val specialNeed = parse_element (element ("""Customer.specialNeed"""))_
    val vip = parse_element (element ("""Customer.vip"""))_
    val priority = parse_attribute (attribute ("""Customer.priority"""))_
    val status = parse_attribute (attribute ("""Customer.status"""))_
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

case class CustomerAgreement
(
    override val sup: Element,
    val loadMgmt: String,
    val Customer: String,
    val CustomerAccount: String,
    val ServiceCategory: String,
    val ServiceSupplier: String,
    val StandardIndustryCode: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[CustomerAgreement]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerAgreement
extends
    Parseable[CustomerAgreement]
with
    Parser
{
    val loadMgmt = parse_element (element ("""CustomerAgreement.loadMgmt"""))_
    val Customer = parse_attribute (attribute ("""CustomerAgreement.Customer"""))_
    val CustomerAccount = parse_attribute (attribute ("""CustomerAgreement.CustomerAccount"""))_
    val ServiceCategory = parse_attribute (attribute ("""CustomerAgreement.ServiceCategory"""))_
    val ServiceSupplier = parse_attribute (attribute ("""CustomerAgreement.ServiceSupplier"""))_
    val StandardIndustryCode = parse_attribute (attribute ("""CustomerAgreement.StandardIndustryCode"""))_
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

case class Document
(
    override val sup: Element,
    val authorName: String,
    val comment: String,
    val createdDateTime: String, // ToDo: DateTime handling
    val lastModifiedDateTime: String, // ToDo: DateTime handling
    val revisionNumber: String,
    val subject: String,
    val title: String,
    val typ: String,
    val docStatus: String,
    val electronicAddress: String,
    val status: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Document]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Document
extends
    Parseable[Document]
with
    Parser
{
    val authorName = parse_element (element ("""Document.authorName"""))_
    val comment = parse_element (element ("""Document.comment"""))_
    val createdDateTime = parse_element (element ("""Document.createdDateTime"""))_
    val lastModifiedDateTime = parse_element (element ("""Document.lastModifiedDateTime"""))_
    val revisionNumber = parse_element (element ("""Document.revisionNumber"""))_
    val subject = parse_element (element ("""Document.subject"""))_
    val title = parse_element (element ("""Document.title"""))_
    val typ = parse_element (element ("""Document.type"""))_
    val docStatus = parse_attribute (attribute ("""Document.docStatus"""))_
    val electronicAddress = parse_attribute (attribute ("""Document.electronicAddress"""))_
    val status = parse_attribute (attribute ("""Document.status"""))_
    def parse (context: Context): Document =
    {
        return (
            Document
            (
                IdentifiedObject.parse (context),
                authorName (context),
                comment (context),
                createdDateTime (context),
                lastModifiedDateTime (context),
                revisionNumber (context),
                subject (context),
                title (context),
                typ (context),
                docStatus (context),
                electronicAddress (context),
                status (context)
            )
        )
    }
}

case class OrganisationRole
(
    override val sup: Element,
    val Organisation: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[OrganisationRole]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrganisationRole
extends
    Parseable[OrganisationRole]
with
    Parser
{
    val Organisation = parse_attribute (attribute ("""OrganisationRole.Organisation"""))_
    def parse (context: Context): OrganisationRole =
    {
        return (
            OrganisationRole
            (
                IdentifiedObject.parse (context),
                Organisation (context)
            )
        )
    }
}

case class PricingStructure
(
    override val sup: Element,
    val code: String,
    val dailyCeilingUsage: String,
    val dailyEstimatedUsage: String,
    val dailyFloorUsage: String,
    val revenueKind: String,
    val taxExemption: Boolean,
    val ServiceCategory: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PricingStructure]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PricingStructure
extends
    Parseable[PricingStructure]
with
    Parser
{
    val code = parse_element (element ("""PricingStructure.code"""))_
    val dailyCeilingUsage = parse_element (element ("""PricingStructure.dailyCeilingUsage"""))_
    val dailyEstimatedUsage = parse_element (element ("""PricingStructure.dailyEstimatedUsage"""))_
    val dailyFloorUsage = parse_element (element ("""PricingStructure.dailyFloorUsage"""))_
    val revenueKind = parse_attribute (attribute ("""PricingStructure.revenueKind"""))_
    val taxExemption = parse_element (element ("""PricingStructure.taxExemption"""))_
    val ServiceCategory = parse_attribute (attribute ("""PricingStructure.ServiceCategory"""))_
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
    override val sup: Element,
    val kind: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ServiceCategory]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceCategory
extends
    Parseable[ServiceCategory]
with
    Parser
{
    val kind = parse_attribute (attribute ("""ServiceCategory.kind"""))_
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
    override val sup: Element,
    val accessMethod: String,
    val needsInspection: Boolean,
    val siteAccessProblem: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ServiceLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceLocation
extends
    Parseable[ServiceLocation]
with
    Parser
{
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))_
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))_
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))_
    def parse (context: Context): ServiceLocation =
    {
        return (
            ServiceLocation
            (
                Location.parse (context),
                accessMethod (context),
                toBoolean (needsInspection (context), context),
                siteAccessProblem (context)
            )
        )
    }
}

object Customers
{
    def register: Unit =
    {
        Agreement.register
        Customer.register
        CustomerAgreement.register
        Document.register
        OrganisationRole.register
        PricingStructure.register
        ServiceCategory.register
        ServiceLocation.register
    }
}
