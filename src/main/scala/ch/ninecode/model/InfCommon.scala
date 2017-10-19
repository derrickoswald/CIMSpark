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
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Bank
(
    override val sup: OrganisationRole,
    bic: String,
    iban: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Bank.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Bank.fields (position), value)
        emitelem (0, bic)
        emitelem (1, iban)
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
    val fields: Array[String] = Array[String] (
        "bic",
        "iban"
    )
    val bic: Fielder = parse_element (element (cls, fields(0)))
    val iban: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Bank =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Bank (
            OrganisationRole.parse (context),
            mask (bic (), 0),
            mask (iban (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class BankAccount
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BankAccount.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "accountNumber",
        "Bank",
        "ServiceSupplier"
    )
    val accountNumber: Fielder = parse_element (element (cls, fields(0)))
    val Bank: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): BankAccount =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = BankAccount (
            Document.parse (context),
            mask (accountNumber (), 0),
            mask (Bank (), 1),
            mask (ServiceSupplier (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Bank", "Bank", false),
        Relationship ("ServiceSupplier", "ServiceSupplier", false)
    )
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
case class BusinessPlan
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val relations: List[Relationship] = List (

    )
}

/**
 * A business role that this organisation plays.
 *
 * A single organisation typically performs many functions, each one described as a role.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's corporate standards and practices.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class BusinessRole
(
    override val sup: OrganisationRole,
    status: String,
    typ: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusinessRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusinessRole.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BusinessRole.fields (position), value)
        emitattr (0, status)
        emitelem (1, typ)
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
    val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): BusinessRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = BusinessRole (
            OrganisationRole.parse (context),
            mask (status (), 0),
            mask (typ (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Craft of a person or a crew.
 *
 * Examples include overhead electric, underground electric, high pressure gas, etc. This ensures necessary knowledge and skills before being allowed to perform certain types of work.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Classification by utility's work mangement standards and practices.
 * @param ErpPersons [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Craft
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String,
    ErpPersons: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Craft.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Craft.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Craft.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Craft.fields (position), x))
        emitattr (0, status)
        emitelem (1, typ)
        emitattrs (2, ErpPersons)
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
    val fields: Array[String] = Array[String] (
        "status",
        "type",
        "ErpPersons"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Craft =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Craft (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (typ (), 1),
            masks (ErpPersons (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpPersons", "OldPerson", true)
    )
}

/**
 * Role an organisation plays with respect to documents.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class DocumentOrganisationRole
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
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
    val relations: List[Relationship] = List (

    )
}

/**
 * A crew is a group of people with specific skills, tools, and vehicles.
 *
 * @param sup [[ch.ninecode.model.Crew Crew]] Reference to the superclass object.
 * @param typ Classification by utility's work management standards and practices.
 * @param Assignments [[ch.ninecode.model.Assignment Assignment]] All Assignments for this Crew.
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param Route [[ch.ninecode.model.Route Route]] <em>undocumented</em>
 * @param ShiftPatterns [[ch.ninecode.model.ShiftPattern ShiftPattern]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OldCrew
(
    override val sup: Crew,
    typ: String,
    Assignments: List[String],
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
    def this () = { this (null, null, List(), List(), null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldCrew.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldCrew.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldCrew.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (OldCrew.fields (position), x))
        emitelem (0, typ)
        emitattrs (1, Assignments)
        emitattrs (2, Locations)
        emitattr (3, Route)
        emitattrs (4, ShiftPatterns)
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
    val fields: Array[String] = Array[String] (
        "type",
        "Assignments",
        "Locations",
        "Route",
        "ShiftPatterns"
    )
    val typ: Fielder = parse_element (element (cls, fields(0)))
    val Assignments: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Route: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ShiftPatterns: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): OldCrew =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = OldCrew (
            Crew.parse (context),
            mask (typ (), 0),
            masks (Assignments (), 1),
            masks (Locations (), 2),
            mask (Route (), 3),
            masks (ShiftPatterns (), 4)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Assignments", "Assignment", true),
        Relationship ("Locations", "Location", true),
        Relationship ("Route", "Route", false),
        Relationship ("ShiftPatterns", "ShiftPattern", true)
    )
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param sup [[ch.ninecode.model.Person Person]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Utility-specific classification for this person, according to the utility's corporate standards and practices.
 *        Examples include employee, contractor, agent, not affiliated, etc.
 * @param CustomerData [[ch.ninecode.model.Customer Customer]] <em>undocumented</em>
 * @param ErpCompetency [[ch.ninecode.model.ErpCompetency ErpCompetency]] <em>undocumented</em>
 * @param ErpPersonnel [[ch.ninecode.model.ErpPersonnel ErpPersonnel]] <em>undocumented</em>
 * @param LaborItems [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OldPerson
(
    override val sup: Person,
    status: String,
    typ: String,
    CustomerData: String,
    ErpCompetency: String,
    ErpPersonnel: String,
    LaborItems: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OldPerson.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OldPerson.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OldPerson.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (OldPerson.fields (position), x))
        emitattr (0, status)
        emitelem (1, typ)
        emitattr (2, CustomerData)
        emitattr (3, ErpCompetency)
        emitattr (4, ErpPersonnel)
        emitattrs (5, LaborItems)
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
    val fields: Array[String] = Array[String] (
        "status",
        "type",
        "CustomerData",
        "ErpCompetency",
        "ErpPersonnel",
        "LaborItems"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))
    val CustomerData: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpCompetency: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ErpPersonnel: Fielder = parse_attribute (attribute (cls, fields(4)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): OldPerson =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = OldPerson (
            Person.parse (context),
            mask (status (), 0),
            mask (typ (), 1),
            mask (CustomerData (), 2),
            mask (ErpCompetency (), 3),
            mask (ErpPersonnel (), 4),
            masks (LaborItems (), 5)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CustomerData", "Customer", false),
        Relationship ("ErpCompetency", "ErpCompetency", false),
        Relationship ("ErpPersonnel", "ErpPersonnel", false),
        Relationship ("LaborItems", "LaborItem", true)
    )
}

/**
 * Roles played between Organisations and other Organisations.
 *
 * This includes role ups for ogranisations, cost centers, profit centers, regulatory reporting, etc.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param clientID Identifiers of the organisation held by another organisation, such as a government agency (federal, state, province, city, county), financial institution (Dun and Bradstreet), etc.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class OrgOrgRole
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrgOrgRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "clientID"
    )
    val clientID: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): OrgOrgRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = OrgOrgRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Roles played between Persons and Documents.
 *
 * @param sup [[ch.ninecode.model.Role Role]] Reference to the superclass object.
 * @param Person [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PersonDocumentRole
(
    override val sup: Role,
    Person: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Role: Role = sup.asInstanceOf[Role]
    override def copy (): Row = { clone ().asInstanceOf[PersonDocumentRole] }
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
        implicit val clz: String = PersonDocumentRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PersonDocumentRole.fields (position), value)
        emitattr (0, Person)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PersonDocumentRole rdf:ID=\"%s\">\n%s\t</cim:PersonDocumentRole>".format (id, export_fields)
    }
}

object PersonDocumentRole
extends
    Parseable[PersonDocumentRole]
{
    val fields: Array[String] = Array[String] (
        "Person"
    )
    val Person: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): PersonDocumentRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PersonDocumentRole (
            Role.parse (context),
            mask (Person (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Person", "OldPerson", false)
    )
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
case class PersonOrganisationRole
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PersonOrganisationRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "clientID",
        "ErpPerson"
    )
    val clientID: Fielder = parse_element (element (cls, fields(0)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PersonOrganisationRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PersonOrganisationRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0),
            mask (ErpPerson (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpPerson", "OldPerson", false)
    )
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
case class PersonPropertyRole
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PersonPropertyRole.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "LandProperty",
        "Person"
    )
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Person: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PersonPropertyRole =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PersonPropertyRole (
            Role.parse (context),
            mask (LandProperty (), 0),
            mask (Person (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", false),
        Relationship ("Person", "OldPerson", false)
    )
}

/**
 * Role an organisation plays with respect to property (for example, the organisation may be the owner, renter, occupier, taxiing authority, etc.).
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class PropertyOrganisationRole
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
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

    def parse (context: Context): PropertyOrganisationRole =
    {
        implicit val ctx: Context = context
        val ret = PropertyOrganisationRole (
            OrganisationRole.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class Ratio
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Ratio.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    val fields: Array[String] = Array[String] (
        "denominator",
        "numerator"
    )
    val denominator: Fielder = parse_element (element (cls, fields(0)))
    val numerator: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Ratio =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Ratio (
            BasicElement.parse (context),
            toDouble (mask (denominator (), 0)),
            toDouble (mask (numerator (), 1))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Enumeration of potential roles that might be played by one object relative to another.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param typ Type of role.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
case class Role
(
    override val sup: IdentifiedObject,
    status: String,
    typ: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Role.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Role.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Role.fields (position), value)
        emitattr (0, status)
        emitelem (1, typ)
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
    val fields: Array[String] = Array[String] (
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val typ: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Role =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Role (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (typ (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
case class Skill
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Skill.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Skill.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Skill.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Skill.fields (position), x))
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
    val fields: Array[String] = Array[String] (
        "certificationPeriod",
        "effectiveDateTime",
        "level",
        "Crafts",
        "ErpPerson",
        "QualificationRequirements"
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
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Skill (
            Document.parse (context),
            mask (certificationPeriod (), 0),
            mask (effectiveDateTime (), 1),
            mask (level (), 2),
            masks (Crafts (), 3),
            mask (ErpPerson (), 4),
            masks (QualificationRequirements (), 5)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Crafts", "Craft", true),
        Relationship ("ErpPerson", "OldPerson", false),
        Relationship ("QualificationRequirements", "QualificationRequirement", true)
    )
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
            PersonDocumentRole.register,
            PersonOrganisationRole.register,
            PersonPropertyRole.register,
            PropertyOrganisationRole.register,
            Ratio.register,
            Role.register,
            Skill.register
        )
    }
}