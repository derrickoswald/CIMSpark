package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Organisation that is a commercial bank, agency, or other institution that offers a similar service.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param bic Bank identifier code as defined in ISO 9362; for use in countries wher IBAN is not yet in operation.
 * @param iban International bank account number defined in ISO 13616; for countries where IBAN is not in operation, the existing BIC or SWIFT codes may be used instead (see ISO 9362).
 * @param BankAccounts [[ch.ninecode.model.BankAccount BankAccount]] All BankAccounts this Bank provides.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Bank
(
    override val sup: OrganisationRole,
    bic: String,
    iban: String,
    BankAccounts: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[Bank] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Bank.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bank.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Bank.fields (position), x))
        emitelem (0, bic)
        emitelem (1, iban)
        emitattrs (2, BankAccounts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bank rdf:ID=\"%s\">\n%s\t</cim:Bank>".format (id, export_fields)
    }
}

object Bank
extends
    Parseable[Bank]
{
    override val fields: Array[String] = Array[String] (
        "bic",
        "iban",
        "BankAccounts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BankAccounts", "BankAccount", "0..*", "0..1")
    )
    val bic: Fielder = parse_element (element (cls, fields(0)))
    val iban: Fielder = parse_element (element (cls, fields(1)))
    val BankAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Bank =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Bank (
            OrganisationRole.parse (context),
            mask (bic (), 0),
            mask (iban (), 1),
            masks (BankAccounts (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Bank account.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param accountNumber Account reference number.
 * @param Bank [[ch.ninecode.model.Bank Bank]] Bank that provides this BankAccount.
 * @param ServiceSupplier [[ch.ninecode.model.ServiceSupplier ServiceSupplier]] ServiceSupplier that is owner of this BankAccount.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BankAccount
(
    override val sup: Document,
    accountNumber: String,
    Bank: String,
    ServiceSupplier: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BankAccount] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BankAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BankAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BankAccount.fields (position), value)
        emitelem (0, accountNumber)
        emitattr (1, Bank)
        emitattr (2, ServiceSupplier)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BankAccount rdf:ID=\"%s\">\n%s\t</cim:BankAccount>".format (id, export_fields)
    }
}

object BankAccount
extends
    Parseable[BankAccount]
{
    override val fields: Array[String] = Array[String] (
        "accountNumber",
        "Bank",
        "ServiceSupplier"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Bank", "Bank", "0..1", "0..*"),
        Relationship ("ServiceSupplier", "ServiceSupplier", "0..1", "0..*")
    )
    val accountNumber: Fielder = parse_element (element (cls, fields(0)))
    val Bank: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): BankAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BankAccount (
            Document.parse (context),
            mask (accountNumber (), 0),
            mask (Bank (), 1),
            mask (ServiceSupplier (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A BusinessPlan is an organized sequence of predetermined actions required to complete a future organizational objective.
 *
 * It is a type of document that typically references a schedule, physical and/or logical resources (assets and/or PowerSystemResources), locations, etc.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BusinessPlan
(
    override val sup: Document
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
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[BusinessPlan] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:BusinessPlan rdf:ID=\"%s\">\n%s\t</cim:BusinessPlan>".format (id, export_fields)
    }
}

object BusinessPlan
extends
    Parseable[BusinessPlan]
{

    def parse (context: Context): BusinessPlan =
    {
        implicit val ctx: Context = context
        val ret = BusinessPlan (
            Document.parse (context)
        )
        ret
    }
}

/**
 * A business role that this organisation plays.
 *
 * A single organisation typically performs many functions, each one described as a role.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Classification by utility's corporate standards and practices.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BusinessRole
(
    override val sup: OrganisationRole,
    status: String,
    `type`: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[BusinessRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusinessRole.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusinessRole.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BusinessRole.fields (position), value)
        emitattr (0, status)
        emitelem (1, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BusinessRole rdf:ID=\"%s\">\n%s\t</cim:BusinessRole>".format (id, export_fields)
    }
}

object BusinessRole
extends
    Parseable[BusinessRole]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): BusinessRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BusinessRole (
            OrganisationRole.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Craft of a person or a crew.
 *
 * Examples include overhead electric, underground electric, high pressure gas, etc. This ensures necessary knowledge and skills before being allowed to perform certain types of work.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Classification by utility's work mangement standards and practices.
 * @param Capabilities [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param Skills [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Craft
(
    override val sup: IdentifiedObject,
    status: String,
    `type`: String,
    Capabilities: List[String],
    ErpPersons: List[String],
    Skills: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Craft] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Craft.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Craft.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Craft.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Craft.fields (position), x))
        emitattr (0, status)
        emitelem (1, `type`)
        emitattrs (2, Capabilities)
        emitattrs (3, ErpPersons)
        emitattrs (4, Skills)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Craft rdf:ID=\"%s\">\n%s\t</cim:Craft>".format (id, export_fields)
    }
}

object Craft
extends
    Parseable[Craft]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type",
        "Capabilities",
        "ErpPersons",
        "Skills"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Capabilities", "Capability", "0..*", "0..*"),
        Relationship ("ErpPersons", "OldPerson", "0..*", "0..*"),
        Relationship ("Skills", "Skill", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): Craft =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Craft (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1),
            masks (Capabilities (), 2),
            masks (ErpPersons (), 3),
            masks (Skills (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Role an organisation plays with respect to documents.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class DocumentOrganisationRole
(
    override val sup: OrganisationRole
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[DocumentOrganisationRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DocumentOrganisationRole rdf:ID=\"%s\">\n%s\t</cim:DocumentOrganisationRole>".format (id, export_fields)
    }
}

object DocumentOrganisationRole
extends
    Parseable[DocumentOrganisationRole]
{

    def parse (context: Context): DocumentOrganisationRole =
    {
        implicit val ctx: Context = context
        val ret = DocumentOrganisationRole (
            OrganisationRole.parse (context)
        )
        ret
    }
}

/**
 * A crew is a group of people with specific skills, tools, and vehicles.
 *
 * @param sup [[ch.ninecode.model.Crew Crew]] Reference to the superclass object.
 * @param type Classification by utility's work management standards and practices.
 * @param Assignments [[ch.ninecode.model.Assignment Assignment]] All Assignments for this Crew.
 * @param Capabilities [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param Route [[ch.ninecode.model.Route Route]] <em>undocumented</em>
 * @param ShiftPatterns [[ch.ninecode.model.ShiftPattern ShiftPattern]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OldCrew
(
    override val sup: Crew,
    `type`: String,
    Assignments: List[String],
    Capabilities: List[String],
    Locations: List[String],
    Route: String,
    ShiftPatterns: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Crew: Crew = sup.asInstanceOf[Crew]
    override def copy (): Row = { clone ().asInstanceOf[OldCrew] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldCrew.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldCrew.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldCrew.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OldCrew.fields (position), x))
        emitelem (0, `type`)
        emitattrs (1, Assignments)
        emitattrs (2, Capabilities)
        emitattrs (3, Locations)
        emitattr (4, Route)
        emitattrs (5, ShiftPatterns)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OldCrew rdf:ID=\"%s\">\n%s\t</cim:OldCrew>".format (id, export_fields)
    }
}

object OldCrew
extends
    Parseable[OldCrew]
{
    override val fields: Array[String] = Array[String] (
        "type",
        "Assignments",
        "Capabilities",
        "Locations",
        "Route",
        "ShiftPatterns"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Assignments", "Assignment", "0..*", "0..*"),
        Relationship ("Capabilities", "Capability", "0..*", "0..1"),
        Relationship ("Locations", "Location", "0..*", "0..*"),
        Relationship ("Route", "Route", "0..1", "0..*"),
        Relationship ("ShiftPatterns", "ShiftPattern", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val Assignments: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Route: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ShiftPatterns: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): OldCrew =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldCrew (
            Crew.parse (context),
            mask (`type` (), 0),
            masks (Assignments (), 1),
            masks (Capabilities (), 2),
            masks (Locations (), 3),
            mask (Route (), 4),
            masks (ShiftPatterns (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup [[ch.ninecode.model.Person Person]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Utility-specific classification for this person, according to the utility's corporate standards and practices.
 *        Examples include employee, contractor, agent, not affiliated, etc.
 *        Note that this field is not used to indicate whether this person is a customer of the utility. Often an employee or contractor is also a customer. Customer information is gained with relationship to Organisation and CustomerData. In similar fashion, this field does not indicate the various roles this person may fill as part of utility operations.
 * @param Crafts [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param CustomerData [[ch.ninecode.model.Customer Customer]] <em>undocumented</em>
 * @param ErpCompetency [[ch.ninecode.model.ErpCompetency ErpCompetency]] <em>undocumented</em>
 * @param ErpPersonnel [[ch.ninecode.model.ErpPersonnel ErpPersonnel]] <em>undocumented</em>
 * @param LaborItems [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param LandPropertyRoles [[ch.ninecode.model.PersonPropertyRole PersonPropertyRole]] <em>undocumented</em>
 * @param MeasurementValues [[ch.ninecode.model.MeasurementValue MeasurementValue]] <em>undocumented</em>
 * @param OrganisationRoles [[ch.ninecode.model.PersonOrganisationRole PersonOrganisationRole]] <em>undocumented</em>
 * @param Skills [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OldPerson
(
    override val sup: Person,
    status: String,
    `type`: String,
    Crafts: List[String],
    CustomerData: String,
    ErpCompetency: String,
    ErpPersonnel: String,
    LaborItems: List[String],
    LandPropertyRoles: List[String],
    MeasurementValues: List[String],
    OrganisationRoles: List[String],
    Skills: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), null, null, null, List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Person: Person = sup.asInstanceOf[Person]
    override def copy (): Row = { clone ().asInstanceOf[OldPerson] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldPerson.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldPerson.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldPerson.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OldPerson.fields (position), x))
        emitattr (0, status)
        emitelem (1, `type`)
        emitattrs (2, Crafts)
        emitattr (3, CustomerData)
        emitattr (4, ErpCompetency)
        emitattr (5, ErpPersonnel)
        emitattrs (6, LaborItems)
        emitattrs (7, LandPropertyRoles)
        emitattrs (8, MeasurementValues)
        emitattrs (9, OrganisationRoles)
        emitattrs (10, Skills)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OldPerson rdf:ID=\"%s\">\n%s\t</cim:OldPerson>".format (id, export_fields)
    }
}

object OldPerson
extends
    Parseable[OldPerson]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type",
        "Crafts",
        "CustomerData",
        "ErpCompetency",
        "ErpPersonnel",
        "LaborItems",
        "LandPropertyRoles",
        "MeasurementValues",
        "OrganisationRoles",
        "Skills"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crafts", "Craft", "0..*", "0..*"),
        Relationship ("CustomerData", "Customer", "0..1", "0..*"),
        Relationship ("ErpCompetency", "ErpCompetency", "0..1", "0..*"),
        Relationship ("ErpPersonnel", "ErpPersonnel", "0..1", "0..*"),
        Relationship ("LaborItems", "LaborItem", "0..*", "0..*"),
        Relationship ("LandPropertyRoles", "PersonPropertyRole", "0..*", "1"),
        Relationship ("MeasurementValues", "MeasurementValue", "0..*", "0..1"),
        Relationship ("OrganisationRoles", "PersonOrganisationRole", "0..*", "1"),
        Relationship ("Skills", "Skill", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val CustomerData: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ErpCompetency: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpPersonnel: Fielder = parse_attribute (attribute (cls, fields(5)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val LandPropertyRoles: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val MeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val OrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): OldPerson =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OldPerson (
            Person.parse (context),
            mask (status (), 0),
            mask (`type` (), 1),
            masks (Crafts (), 2),
            mask (CustomerData (), 3),
            mask (ErpCompetency (), 4),
            mask (ErpPersonnel (), 5),
            masks (LaborItems (), 6),
            masks (LandPropertyRoles (), 7),
            masks (MeasurementValues (), 8),
            masks (OrganisationRoles (), 9),
            masks (Skills (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Roles played between Organisations and other Organisations.
 *
 * This includes role ups for ogranisations, cost centers, profit centers, regulatory reporting, etc.
 * Note that the parent and child relationship is indicated by the name on each end of the association.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param clientID Identifiers of the organisation held by another organisation, such as a government agency (federal, state, province, city, county), financial institution (Dun and Bradstreet), etc.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OrgOrgRole
(
    override val sup: OrganisationRole,
    clientID: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[OrgOrgRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrgOrgRole.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OrgOrgRole.fields (position), value)
        emitelem (0, clientID)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrgOrgRole rdf:ID=\"%s\">\n%s\t</cim:OrgOrgRole>".format (id, export_fields)
    }
}

object OrgOrgRole
extends
    Parseable[OrgOrgRole]
{
    override val fields: Array[String] = Array[String] (
        "clientID"
    )
    val clientID: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): OrgOrgRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OrgOrgRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Role an organisation plays with respect to persons.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param clientID Identifiers of the person held by an organisation, such as a government agency (federal, state, province, city, county), financial institutions, etc.
 * @param ErpPerson [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PersonOrganisationRole
(
    override val sup: OrganisationRole,
    clientID: String,
    ErpPerson: String
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[PersonOrganisationRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PersonOrganisationRole.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PersonOrganisationRole.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PersonOrganisationRole.fields (position), value)
        emitelem (0, clientID)
        emitattr (1, ErpPerson)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PersonOrganisationRole rdf:ID=\"%s\">\n%s\t</cim:PersonOrganisationRole>".format (id, export_fields)
    }
}

object PersonOrganisationRole
extends
    Parseable[PersonOrganisationRole]
{
    override val fields: Array[String] = Array[String] (
        "clientID",
        "ErpPerson"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ErpPerson", "OldPerson", "1", "0..*")
    )
    val clientID: Fielder = parse_element (element (cls, fields(0)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PersonOrganisationRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PersonOrganisationRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0),
            mask (ErpPerson (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The role of a person relative to a given piece of property.
 *
 * Examples of roles include: owner, renter, contractor, etc.
 *
 * @param sup [[ch.ninecode.model.Role Role]] Reference to the superclass object.
 * @param LandProperty [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Person [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PersonPropertyRole
(
    override val sup: Role,
    LandProperty: String,
    Person: String
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
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { clone ().asInstanceOf[PersonPropertyRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PersonPropertyRole.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PersonPropertyRole.fields (position), value)
        emitattr (0, LandProperty)
        emitattr (1, Person)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PersonPropertyRole rdf:ID=\"%s\">\n%s\t</cim:PersonPropertyRole>".format (id, export_fields)
    }
}

object PersonPropertyRole
extends
    Parseable[PersonPropertyRole]
{
    override val fields: Array[String] = Array[String] (
        "LandProperty",
        "Person"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", "1", "0..*"),
        Relationship ("Person", "OldPerson", "1", "0..*")
    )
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Person: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PersonPropertyRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PersonPropertyRole (
            Role.parse (context),
            mask (LandProperty (), 0),
            mask (Person (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Role an organisation plays with respect to property (for example, the organisation may be the owner, renter, occupier, taxiing authority, etc.).
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param LandProperty [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PropertyOrganisationRole
(
    override val sup: OrganisationRole,
    LandProperty: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[PropertyOrganisationRole] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PropertyOrganisationRole.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PropertyOrganisationRole.fields (position), x))
        emitattrs (0, LandProperty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PropertyOrganisationRole rdf:ID=\"%s\">\n%s\t</cim:PropertyOrganisationRole>".format (id, export_fields)
    }
}

object PropertyOrganisationRole
extends
    Parseable[PropertyOrganisationRole]
{
    override val fields: Array[String] = Array[String] (
        "LandProperty"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", "1..", "0..*")
    )
    val LandProperty: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): PropertyOrganisationRole =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PropertyOrganisationRole (
            OrganisationRole.parse (context),
            masks (LandProperty (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Fraction specified explicitly with a numerator and denominator, which can be used to calculate the quotient.
 *
 * @param sup Reference to the superclass object.
 * @param denominator The part of a fraction that is below the line and that functions as the divisor of the numerator.
 * @param numerator The part of a fraction that is above the line and signifies the number to be divided by the denominator.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Ratio
(
    override val sup: BasicElement,
    denominator: Double,
    numerator: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Ratio] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Ratio.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Ratio.fields (position), value)
        emitelem (0, denominator)
        emitelem (1, numerator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Ratio rdf:ID=\"%s\">\n%s\t</cim:Ratio>".format (id, export_fields)
    }
}

object Ratio
extends
    Parseable[Ratio]
{
    override val fields: Array[String] = Array[String] (
        "denominator",
        "numerator"
    )
    val denominator: Fielder = parse_element (element (cls, fields(0)))
    val numerator: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Ratio =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Ratio (
            BasicElement.parse (context),
            toDouble (mask (denominator (), 0)),
            toDouble (mask (numerator (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Enumeration of potential roles that might be played by one object relative to another.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param type Type of role.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Role
(
    override val sup: IdentifiedObject,
    status: String,
    `type`: String
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Role] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Role.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Role.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Role.fields (position), value)
        emitattr (0, status)
        emitelem (1, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Role rdf:ID=\"%s\">\n%s\t</cim:Role>".format (id, export_fields)
    }
}

object Role
extends
    Parseable[Role]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Role =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Role (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param certificationPeriod Interval between the certification and its expiry.
 * @param effectiveDateTime Date and time the skill became effective.
 * @param level Level of skill for a Craft.
 * @param Crafts [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param ErpPerson [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Skill
(
    override val sup: Document,
    certificationPeriod: String,
    effectiveDateTime: String,
    level: String,
    Crafts: List[String],
    ErpPerson: String,
    QualificationRequirements: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Skill] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Skill.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Skill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Skill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Skill.fields (position), x))
        emitattr (0, certificationPeriod)
        emitelem (1, effectiveDateTime)
        emitattr (2, level)
        emitattrs (3, Crafts)
        emitattr (4, ErpPerson)
        emitattrs (5, QualificationRequirements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Skill rdf:ID=\"%s\">\n%s\t</cim:Skill>".format (id, export_fields)
    }
}

object Skill
extends
    Parseable[Skill]
{
    override val fields: Array[String] = Array[String] (
        "certificationPeriod",
        "effectiveDateTime",
        "level",
        "Crafts",
        "ErpPerson",
        "QualificationRequirements"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Crafts", "Craft", "0..*", "0..*"),
        Relationship ("ErpPerson", "OldPerson", "0..1", "0..*"),
        Relationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*")
    )
    val certificationPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(1)))
    val level: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields(4)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): Skill =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Skill (
            Document.parse (context),
            mask (certificationPeriod (), 0),
            mask (effectiveDateTime (), 1),
            mask (level (), 2),
            masks (Crafts (), 3),
            mask (ErpPerson (), 4),
            masks (QualificationRequirements (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfCommon
{
    def register: List[ClassInfo] =
    {
        List (
            Bank.register,
            BankAccount.register,
            BusinessPlan.register,
            BusinessRole.register,
            Craft.register,
            DocumentOrganisationRole.register,
            OldCrew.register,
            OldPerson.register,
            OrgOrgRole.register,
            PersonOrganisationRole.register,
            PersonPropertyRole.register,
            PropertyOrganisationRole.register,
            Ratio.register,
            Role.register,
            Skill.register
        )
    }
}