package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains functions common for distribution management.
 */

/**
 * Organisation that is a commercial bank, agency, or other institution that offers a similar service.
 */
case class Bank
(

    override val sup: OrganisationRole,

    /**
     * Bank identifier code as defined in ISO 9362; for use in countries wher IBAN is not yet in operation.
     */
    val bic: String,

    /**
     * International bank account number defined in ISO 13616; for countries where IBAN is not in operation, the existing BIC or SWIFT codes may be used instead (see ISO 9362).
     */
    val iban: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[Bank]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bank
extends
    Parseable[Bank]
{
    val sup = OrganisationRole.parse _
    val bic = parse_element (element ("""Bank.bic"""))_
    val iban = parse_element (element ("""Bank.iban"""))_
    def parse (context: Context): Bank =
    {
        Bank(
            sup (context),
            bic (context),
            iban (context)
        )
    }
}

/**
 * Bank account.
 */
case class BankAccount
(

    override val sup: Document,

    /**
     * Account reference number.
     */
    val accountNumber: String,

    /**
     * Bank that provides this BankAccount.
     */
    val Bank: String,

    /**
     * ServiceSupplier that is owner of this BankAccount.
     */
    val ServiceSupplier: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[BankAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BankAccount
extends
    Parseable[BankAccount]
{
    val sup = Document.parse _
    val accountNumber = parse_element (element ("""BankAccount.accountNumber"""))_
    val Bank = parse_attribute (attribute ("""BankAccount.Bank"""))_
    val ServiceSupplier = parse_attribute (attribute ("""BankAccount.ServiceSupplier"""))_
    def parse (context: Context): BankAccount =
    {
        BankAccount(
            sup (context),
            accountNumber (context),
            Bank (context),
            ServiceSupplier (context)
        )
    }
}

/**
 * A BusinessPlan is an organized sequence of predetermined actions required to complete a future organizational objective.
 * It is a type of document that typically references a schedule, physical and/or logical resources (assets and/or PowerSystemResources), locations, etc.
 */
case class BusinessPlan
(

    override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[BusinessPlan]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusinessPlan
extends
    Parseable[BusinessPlan]
{
    val sup = Document.parse _
    def parse (context: Context): BusinessPlan =
    {
        BusinessPlan(
            sup (context)
        )
    }
}

/**
 * A business role that this organisation plays.
 * A single organisation typically performs many functions, each one described as a role.
 */
case class BusinessRole
(

    override val sup: OrganisationRole,

    val status: String,

    /**
     * Classification by utility's corporate standards and practices.
     */
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[BusinessRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusinessRole
extends
    Parseable[BusinessRole]
{
    val sup = OrganisationRole.parse _
    val status = parse_attribute (attribute ("""BusinessRole.status"""))_
    val typ = parse_element (element ("""BusinessRole.type"""))_
    def parse (context: Context): BusinessRole =
    {
        BusinessRole(
            sup (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Craft of a person or a crew.
 * Examples include overhead electric, underground electric, high pressure gas, etc. This ensures necessary knowledge and skills before being allowed to perform certain types of work.
 */
case class Craft
(

    override val sup: IdentifiedObject,

    val status: String,

    /**
     * Classification by utility's work mangement standards and practices.
     */
    val typ: String,

    val ErpPersons: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Craft]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Craft
extends
    Parseable[Craft]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Craft.status"""))_
    val typ = parse_element (element ("""Craft.type"""))_
    val ErpPersons = parse_attributes (attribute ("""Craft.ErpPersons"""))_
    def parse (context: Context): Craft =
    {
        Craft(
            sup (context),
            status (context),
            typ (context),
            ErpPersons (context)
        )
    }
}

/**
 * Role an organisation plays with respect to documents.
 */
case class DocumentOrganisationRole
(

    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[DocumentOrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DocumentOrganisationRole
extends
    Parseable[DocumentOrganisationRole]
{
    val sup = OrganisationRole.parse _
    def parse (context: Context): DocumentOrganisationRole =
    {
        DocumentOrganisationRole(
            sup (context)
        )
    }
}

/**
 * A crew is a group of people with specific skills, tools, and vehicles.
 */
case class OldCrew
(

    override val sup: Crew,

    /**
     * Classification by utility's work management standards and practices.
     */
    val typ: String,

    /**
     * All Assignments for this Crew.
     */
    val Assignments: List[String],

    val Locations: List[String],

    val Route: String,

    val ShiftPatterns: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List(), List(), null, List()) }
    def Crew: Crew = sup.asInstanceOf[Crew]
    override def copy (): Row = { return (clone ().asInstanceOf[OldCrew]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldCrew
extends
    Parseable[OldCrew]
{
    val sup = Crew.parse _
    val typ = parse_element (element ("""OldCrew.type"""))_
    val Assignments = parse_attributes (attribute ("""OldCrew.Assignments"""))_
    val Locations = parse_attributes (attribute ("""OldCrew.Locations"""))_
    val Route = parse_attribute (attribute ("""OldCrew.Route"""))_
    val ShiftPatterns = parse_attributes (attribute ("""OldCrew.ShiftPatterns"""))_
    def parse (context: Context): OldCrew =
    {
        OldCrew(
            sup (context),
            typ (context),
            Assignments (context),
            Locations (context),
            Route (context),
            ShiftPatterns (context)
        )
    }
}

/**
 * General purpose information for name and other information to contact people.
 */
case class OldPerson
(

    override val sup: Person,

    val status: String,

    /**
     * Utility-specific classification for this person, according to the utility's corporate standards and practices.
     * Examples include employee, contractor, agent, not affiliated, etc.
     */
    val typ: String,

    val CustomerData: String,

    val ErpCompetency: String,

    val ErpPersonnel: String,

    val LaborItems: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, List()) }
    def Person: Person = sup.asInstanceOf[Person]
    override def copy (): Row = { return (clone ().asInstanceOf[OldPerson]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OldPerson
extends
    Parseable[OldPerson]
{
    val sup = Person.parse _
    val status = parse_attribute (attribute ("""OldPerson.status"""))_
    val typ = parse_element (element ("""OldPerson.type"""))_
    val CustomerData = parse_attribute (attribute ("""OldPerson.CustomerData"""))_
    val ErpCompetency = parse_attribute (attribute ("""OldPerson.ErpCompetency"""))_
    val ErpPersonnel = parse_attribute (attribute ("""OldPerson.ErpPersonnel"""))_
    val LaborItems = parse_attributes (attribute ("""OldPerson.LaborItems"""))_
    def parse (context: Context): OldPerson =
    {
        OldPerson(
            sup (context),
            status (context),
            typ (context),
            CustomerData (context),
            ErpCompetency (context),
            ErpPersonnel (context),
            LaborItems (context)
        )
    }
}

/**
 * Roles played between Organisations and other Organisations.
 * This includes role ups for ogranisations, cost centers, profit centers, regulatory reporting, etc.
 */
case class OrgOrgRole
(

    override val sup: OrganisationRole,

    /**
     * Identifiers of the organisation held by another organisation, such as a government agency (federal, state, province, city, county), financial institution (Dun and Bradstreet), etc.
     */
    val clientID: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[OrgOrgRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrgOrgRole
extends
    Parseable[OrgOrgRole]
{
    val sup = OrganisationRole.parse _
    val clientID = parse_element (element ("""OrgOrgRole.clientID"""))_
    def parse (context: Context): OrgOrgRole =
    {
        OrgOrgRole(
            sup (context),
            clientID (context)
        )
    }
}

/**
 * Roles played between Persons and Documents.
 */
case class PersonDocumentRole
(

    override val sup: Role,

    val Person: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { return (clone ().asInstanceOf[PersonDocumentRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PersonDocumentRole
extends
    Parseable[PersonDocumentRole]
{
    val sup = Role.parse _
    val Person = parse_attribute (attribute ("""PersonDocumentRole.Person"""))_
    def parse (context: Context): PersonDocumentRole =
    {
        PersonDocumentRole(
            sup (context),
            Person (context)
        )
    }
}

/**
 * Role an organisation plays with respect to persons.
 */
case class PersonOrganisationRole
(

    override val sup: OrganisationRole,

    /**
     * Identifiers of the person held by an organisation, such as a government agency (federal, state, province, city, county), financial institutions, etc.
     */
    val clientID: String,

    val ErpPerson: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[PersonOrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PersonOrganisationRole
extends
    Parseable[PersonOrganisationRole]
{
    val sup = OrganisationRole.parse _
    val clientID = parse_element (element ("""PersonOrganisationRole.clientID"""))_
    val ErpPerson = parse_attribute (attribute ("""PersonOrganisationRole.ErpPerson"""))_
    def parse (context: Context): PersonOrganisationRole =
    {
        PersonOrganisationRole(
            sup (context),
            clientID (context),
            ErpPerson (context)
        )
    }
}

/**
 * The role of a person relative to a given piece of property.
 * Examples of roles include: owner, renter, contractor, etc.
 */
case class PersonPropertyRole
(

    override val sup: Role,

    val LandProperty: String,

    val Person: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { return (clone ().asInstanceOf[PersonPropertyRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PersonPropertyRole
extends
    Parseable[PersonPropertyRole]
{
    val sup = Role.parse _
    val LandProperty = parse_attribute (attribute ("""PersonPropertyRole.LandProperty"""))_
    val Person = parse_attribute (attribute ("""PersonPropertyRole.Person"""))_
    def parse (context: Context): PersonPropertyRole =
    {
        PersonPropertyRole(
            sup (context),
            LandProperty (context),
            Person (context)
        )
    }
}

/**
 * Role an organisation plays with respect to property (for example, the organisation may be the owner, renter, occupier, taxiing authority, etc.).
 */
case class PropertyOrganisationRole
(

    override val sup: OrganisationRole
)
extends
    Element
{
    def this () = { this (null) }
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { return (clone ().asInstanceOf[PropertyOrganisationRole]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PropertyOrganisationRole
extends
    Parseable[PropertyOrganisationRole]
{
    val sup = OrganisationRole.parse _
    def parse (context: Context): PropertyOrganisationRole =
    {
        PropertyOrganisationRole(
            sup (context)
        )
    }
}

/**
 * Fraction specified explicitly with a numerator and denominator, which can be used to calculate the quotient.
 */
case class Ratio
(

    override val sup: BasicElement,

    /**
     * The part of a fraction that is below the line and that functions as the divisor of the numerator.
     */
    val denominator: Double,

    /**
     * The part of a fraction that is above the line and signifies the number to be divided by the denominator.
     */
    val numerator: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Ratio]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Ratio
extends
    Parseable[Ratio]
{
    val sup = BasicElement.parse _
    val denominator = parse_element (element ("""Ratio.denominator"""))_
    val numerator = parse_element (element ("""Ratio.numerator"""))_
    def parse (context: Context): Ratio =
    {
        Ratio(
            sup (context),
            toDouble (denominator (context), context),
            toDouble (numerator (context), context)
        )
    }
}

/**
 * Enumeration of potential roles that might be played by one object relative to another.
 */
case class Role
(

    override val sup: IdentifiedObject,

    val status: String,

    /**
     * Type of role.
     */
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Role]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Role
extends
    Parseable[Role]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""Role.status"""))_
    val typ = parse_element (element ("""Role.type"""))_
    def parse (context: Context): Role =
    {
        Role(
            sup (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 */
case class Skill
(

    override val sup: Document,

    /**
     * Interval between the certification and its expiry.
     */
    val certificationPeriod: String,

    /**
     * Date and time the skill became effective.
     */
    val effectiveDateTime: String,

    /**
     * Level of skill for a Craft.
     */
    val level: String,

    val Crafts: List[String],

    val ErpPerson: String,

    val QualificationRequirements: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Skill]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Skill
extends
    Parseable[Skill]
{
    val sup = Document.parse _
    val certificationPeriod = parse_attribute (attribute ("""Skill.certificationPeriod"""))_
    val effectiveDateTime = parse_element (element ("""Skill.effectiveDateTime"""))_
    val level = parse_attribute (attribute ("""Skill.level"""))_
    val Crafts = parse_attributes (attribute ("""Skill.Crafts"""))_
    val ErpPerson = parse_attribute (attribute ("""Skill.ErpPerson"""))_
    val QualificationRequirements = parse_attributes (attribute ("""Skill.QualificationRequirements"""))_
    def parse (context: Context): Skill =
    {
        Skill(
            sup (context),
            certificationPeriod (context),
            effectiveDateTime (context),
            level (context),
            Crafts (context),
            ErpPerson (context),
            QualificationRequirements (context)
        )
    }
}

/**
 * Kind of skill level.
 */
case class SkillLevelKind
(

    override val sup: BasicElement,

    val apprentice: String,

    val master: String,

    val other: String,

    val standard: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SkillLevelKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SkillLevelKind
extends
    Parseable[SkillLevelKind]
{
    val sup = BasicElement.parse _
    val apprentice = parse_attribute (attribute ("""SkillLevelKind.apprentice"""))_
    val master = parse_attribute (attribute ("""SkillLevelKind.master"""))_
    val other = parse_attribute (attribute ("""SkillLevelKind.other"""))_
    val standard = parse_attribute (attribute ("""SkillLevelKind.standard"""))_
    def parse (context: Context): SkillLevelKind =
    {
        SkillLevelKind(
            sup (context),
            apprentice (context),
            master (context),
            other (context),
            standard (context)
        )
    }
}

object _InfCommon
{
    def register: Unit =
    {
        Bank.register
        BankAccount.register
        BusinessPlan.register
        BusinessRole.register
        Craft.register
        DocumentOrganisationRole.register
        OldCrew.register
        OldPerson.register
        OrgOrgRole.register
        PersonDocumentRole.register
        PersonOrganisationRole.register
        PersonPropertyRole.register
        PropertyOrganisationRole.register
        Ratio.register
        Role.register
        Skill.register
        SkillLevelKind.register
    }
}