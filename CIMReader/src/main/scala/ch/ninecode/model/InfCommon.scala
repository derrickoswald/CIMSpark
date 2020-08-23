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
 * Organisation that is a commercial bank, agency, or other institution that offers a similar service.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param bic              Bank identifier code as defined in ISO 9362; for use in countries wher IBAN is not yet in operation.
 * @param iban             International bank account number defined in ISO 13616; for countries where IBAN is not in operation, the existing BIC or SWIFT codes may be used instead (see ISO 9362).
 * @param BankAccounts     [[ch.ninecode.model.BankAccount BankAccount]] All BankAccounts this Bank provides.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Bank
(
    OrganisationRole: OrganisationRole = null,
    bic: String = null,
    iban: String = null,
    BankAccounts: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Bank]
{
    override val fields: Array[String] = Array [String](
        "bic",
        "iban",
        "BankAccounts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BankAccounts", "BankAccount", "0..*", "0..1")
    )
    val bic: Fielder = parse_element (element (cls, fields (0)))
    val iban: Fielder = parse_element (element (cls, fields (1)))
    val BankAccounts: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): Bank =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Bank (
            OrganisationRole.parse (context),
            mask (bic (), 0),
            mask (iban (), 1),
            masks (BankAccounts (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Bank] = BankSerializer
}

object BankSerializer extends CIMSerializer[Bank]
{
    def write (kryo: Kryo, output: Output, obj: Bank): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.bic),
            () => output.writeString (obj.iban),
            () => writeList (obj.BankAccounts, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Bank]): Bank =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Bank (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Bank account.
 *
 * @param Document        [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param accountNumber   Account reference number.
 * @param Bank            [[ch.ninecode.model.Bank Bank]] Bank that provides this BankAccount.
 * @param ServiceSupplier [[ch.ninecode.model.ServiceSupplier ServiceSupplier]] ServiceSupplier that is owner of this BankAccount.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BankAccount
(
    Document: Document = null,
    accountNumber: String = null,
    Bank: String = null,
    ServiceSupplier: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[BankAccount]
{
    override val fields: Array[String] = Array [String](
        "accountNumber",
        "Bank",
        "ServiceSupplier"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bank", "Bank", "0..1", "0..*"),
        CIMRelationship ("ServiceSupplier", "ServiceSupplier", "0..1", "0..*")
    )
    val accountNumber: Fielder = parse_element (element (cls, fields (0)))
    val Bank: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ServiceSupplier: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): BankAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BankAccount (
            Document.parse (context),
            mask (accountNumber (), 0),
            mask (Bank (), 1),
            mask (ServiceSupplier (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BankAccount] = BankAccountSerializer
}

object BankAccountSerializer extends CIMSerializer[BankAccount]
{
    def write (kryo: Kryo, output: Output, obj: BankAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accountNumber),
            () => output.writeString (obj.Bank),
            () => output.writeString (obj.ServiceSupplier)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BankAccount]): BankAccount =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf [Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BankAccount (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A BusinessPlan is an organized sequence of predetermined actions required to complete a future organizational objective.
 *
 * It is a type of document that typically references a schedule, physical and/or logical resources (assets and/or PowerSystemResources), locations, etc.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BusinessPlan
(
    Document: Document = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[BusinessPlan]
{

    def parse (context: CIMContext): BusinessPlan =
    {
        val ret = BusinessPlan (
            Document.parse (context)
        )
        ret
    }

    def serializer: Serializer[BusinessPlan] = BusinessPlanSerializer
}

object BusinessPlanSerializer extends CIMSerializer[BusinessPlan]
{
    def write (kryo: Kryo, output: Output, obj: BusinessPlan): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusinessPlan]): BusinessPlan =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf [Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BusinessPlan (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A business role that this organisation plays.
 *
 * A single organisation typically performs many functions, each one described as a role.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param status           <em>undocumented</em>
 * @param type             Classification by utility's corporate standards and practices.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class BusinessRole
(
    OrganisationRole: OrganisationRole = null,
    status: String = null,
    `type`: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[BusinessRole]
{
    override val fields: Array[String] = Array [String](
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val `type`: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: CIMContext): BusinessRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = BusinessRole (
            OrganisationRole.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BusinessRole] = BusinessRoleSerializer
}

object BusinessRoleSerializer extends CIMSerializer[BusinessRole]
{
    def write (kryo: Kryo, output: Output, obj: BusinessRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusinessRole]): BusinessRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BusinessRole (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Craft of a person or a crew.
 *
 * Examples include overhead electric, underground electric, high pressure gas, etc. This ensures necessary knowledge and skills before being allowed to perform certain types of work.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status           <em>undocumented</em>
 * @param type             Classification by utility's work mangement standards and practices.
 * @param Capabilities     [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param ErpPersons       [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param Skills           [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Craft
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    `type`: String = null,
    Capabilities: List[String] = null,
    ErpPersons: List[String] = null,
    Skills: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Craft]
{
    override val fields: Array[String] = Array [String](
        "status",
        "type",
        "Capabilities",
        "ErpPersons",
        "Skills"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Capabilities", "Capability", "0..*", "0..*"),
        CIMRelationship ("ErpPersons", "OldPerson", "0..*", "0..*"),
        CIMRelationship ("Skills", "Skill", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val `type`: Fielder = parse_element (element (cls, fields (1)))
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val ErpPersons: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields (4)))

    def parse (context: CIMContext): Craft =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[Craft] = CraftSerializer
}

object CraftSerializer extends CIMSerializer[Craft]
{
    def write (kryo: Kryo, output: Output, obj: Craft): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Capabilities, output),
            () => writeList (obj.ErpPersons, output),
            () => writeList (obj.Skills, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Craft]): Craft =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Craft (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Role an organisation plays with respect to documents.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class DocumentOrganisationRole
(
    OrganisationRole: OrganisationRole = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[DocumentOrganisationRole]
{

    def parse (context: CIMContext): DocumentOrganisationRole =
    {
        val ret = DocumentOrganisationRole (
            OrganisationRole.parse (context)
        )
        ret
    }

    def serializer: Serializer[DocumentOrganisationRole] = DocumentOrganisationRoleSerializer
}

object DocumentOrganisationRoleSerializer extends CIMSerializer[DocumentOrganisationRole]
{
    def write (kryo: Kryo, output: Output, obj: DocumentOrganisationRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DocumentOrganisationRole]): DocumentOrganisationRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DocumentOrganisationRole (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A crew is a group of people with specific skills, tools, and vehicles.
 *
 * @param Crew          [[ch.ninecode.model.Crew Crew]] Reference to the superclass object.
 * @param type          Classification by utility's work management standards and practices.
 * @param Assignments   [[ch.ninecode.model.Assignment Assignment]] All Assignments for this Crew.
 * @param Capabilities  [[ch.ninecode.model.Capability Capability]] <em>undocumented</em>
 * @param Locations     [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param Route         [[ch.ninecode.model.Route Route]] <em>undocumented</em>
 * @param ShiftPatterns [[ch.ninecode.model.ShiftPattern ShiftPattern]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OldCrew
(
    Crew: Crew = null,
    `type`: String = null,
    Assignments: List[String] = null,
    Capabilities: List[String] = null,
    Locations: List[String] = null,
    Route: String = null,
    ShiftPatterns: List[String] = null
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
    override def sup: Crew = Crew

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[OldCrew]
{
    override val fields: Array[String] = Array [String](
        "type",
        "Assignments",
        "Capabilities",
        "Locations",
        "Route",
        "ShiftPatterns"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assignments", "Assignment", "0..*", "0..*"),
        CIMRelationship ("Capabilities", "Capability", "0..*", "0..1"),
        CIMRelationship ("Locations", "Location", "0..*", "0..*"),
        CIMRelationship ("Route", "Route", "0..1", "0..*"),
        CIMRelationship ("ShiftPatterns", "ShiftPattern", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields (0)))
    val Assignments: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Capabilities: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val Route: Fielder = parse_attribute (attribute (cls, fields (4)))
    val ShiftPatterns: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: CIMContext): OldCrew =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[OldCrew] = OldCrewSerializer
}

object OldCrewSerializer extends CIMSerializer[OldCrew]
{
    def write (kryo: Kryo, output: Output, obj: OldCrew): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.`type`),
            () => writeList (obj.Assignments, output),
            () => writeList (obj.Capabilities, output),
            () => writeList (obj.Locations, output),
            () => output.writeString (obj.Route),
            () => writeList (obj.ShiftPatterns, output)
        )
        CrewSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldCrew]): OldCrew =
    {
        val parent = CrewSerializer.read (kryo, input, classOf [Crew])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OldCrew (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General purpose information for name and other information to contact people.
 *
 * @param Person            [[ch.ninecode.model.Person Person]] Reference to the superclass object.
 * @param status            <em>undocumented</em>
 * @param type              Utility-specific classification for this person, according to the utility's corporate standards and practices.
 *                          Examples include employee, contractor, agent, not affiliated, etc.
 *                          Note that this field is not used to indicate whether this person is a customer of the utility. Often an employee or contractor is also a customer. Customer information is gained with relationship to Organisation and CustomerData. In similar fashion, this field does not indicate the various roles this person may fill as part of utility operations.
 * @param Crafts            [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param CustomerData      [[ch.ninecode.model.Customer Customer]] <em>undocumented</em>
 * @param ErpCompetency     [[ch.ninecode.model.ErpCompetency ErpCompetency]] <em>undocumented</em>
 * @param ErpPersonnel      [[ch.ninecode.model.ErpPersonnel ErpPersonnel]] <em>undocumented</em>
 * @param LaborItems        [[ch.ninecode.model.LaborItem LaborItem]] <em>undocumented</em>
 * @param LandPropertyRoles [[ch.ninecode.model.PersonPropertyRole PersonPropertyRole]] <em>undocumented</em>
 * @param MeasurementValues [[ch.ninecode.model.MeasurementValue MeasurementValue]] <em>undocumented</em>
 * @param OrganisationRoles [[ch.ninecode.model.PersonOrganisationRole PersonOrganisationRole]] <em>undocumented</em>
 * @param Skills            [[ch.ninecode.model.Skill Skill]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OldPerson
(
    Person: Person = null,
    status: String = null,
    `type`: String = null,
    Crafts: List[String] = null,
    CustomerData: String = null,
    ErpCompetency: String = null,
    ErpPersonnel: String = null,
    LaborItems: List[String] = null,
    LandPropertyRoles: List[String] = null,
    MeasurementValues: List[String] = null,
    OrganisationRoles: List[String] = null,
    Skills: List[String] = null
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
    override def sup: Person = Person

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[OldPerson]
{
    override val fields: Array[String] = Array [String](
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crafts", "Craft", "0..*", "0..*"),
        CIMRelationship ("CustomerData", "Customer", "0..1", "0..*"),
        CIMRelationship ("ErpCompetency", "ErpCompetency", "0..1", "0..*"),
        CIMRelationship ("ErpPersonnel", "ErpPersonnel", "0..1", "0..*"),
        CIMRelationship ("LaborItems", "LaborItem", "0..*", "0..*"),
        CIMRelationship ("LandPropertyRoles", "PersonPropertyRole", "0..*", "1"),
        CIMRelationship ("MeasurementValues", "MeasurementValue", "0..*", "0..1"),
        CIMRelationship ("OrganisationRoles", "PersonOrganisationRole", "0..*", "1"),
        CIMRelationship ("Skills", "Skill", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val `type`: Fielder = parse_element (element (cls, fields (1)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val CustomerData: Fielder = parse_attribute (attribute (cls, fields (3)))
    val ErpCompetency: Fielder = parse_attribute (attribute (cls, fields (4)))
    val ErpPersonnel: Fielder = parse_attribute (attribute (cls, fields (5)))
    val LaborItems: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val LandPropertyRoles: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val MeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val OrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val Skills: FielderMultiple = parse_attributes (attribute (cls, fields (10)))

    def parse (context: CIMContext): OldPerson =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[OldPerson] = OldPersonSerializer
}

object OldPersonSerializer extends CIMSerializer[OldPerson]
{
    def write (kryo: Kryo, output: Output, obj: OldPerson): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => writeList (obj.Crafts, output),
            () => output.writeString (obj.CustomerData),
            () => output.writeString (obj.ErpCompetency),
            () => output.writeString (obj.ErpPersonnel),
            () => writeList (obj.LaborItems, output),
            () => writeList (obj.LandPropertyRoles, output),
            () => writeList (obj.MeasurementValues, output),
            () => writeList (obj.OrganisationRoles, output),
            () => writeList (obj.Skills, output)
        )
        PersonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OldPerson]): OldPerson =
    {
        val parent = PersonSerializer.read (kryo, input, classOf [Person])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OldPerson (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Roles played between Organisations and other Organisations.
 *
 * This includes role ups for ogranisations, cost centers, profit centers, regulatory reporting, etc.
 * Note that the parent and child relationship is indicated by the name on each end of the association.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param clientID         Identifiers of the organisation held by another organisation, such as a government agency (federal, state, province, city, county), financial institution (Dun and Bradstreet), etc.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class OrgOrgRole
(
    OrganisationRole: OrganisationRole = null,
    clientID: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[OrgOrgRole]
{
    override val fields: Array[String] = Array [String](
        "clientID"
    )
    val clientID: Fielder = parse_element (element (cls, fields (0)))

    def parse (context: CIMContext): OrgOrgRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = OrgOrgRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OrgOrgRole] = OrgOrgRoleSerializer
}

object OrgOrgRoleSerializer extends CIMSerializer[OrgOrgRole]
{
    def write (kryo: Kryo, output: Output, obj: OrgOrgRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.clientID)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrgOrgRole]): OrgOrgRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrgOrgRole (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Role an organisation plays with respect to persons.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param clientID         Identifiers of the person held by an organisation, such as a government agency (federal, state, province, city, county), financial institutions, etc.
 * @param ErpPerson        [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PersonOrganisationRole
(
    OrganisationRole: OrganisationRole = null,
    clientID: String = null,
    ErpPerson: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PersonOrganisationRole]
{
    override val fields: Array[String] = Array [String](
        "clientID",
        "ErpPerson"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ErpPerson", "OldPerson", "1", "0..*")
    )
    val clientID: Fielder = parse_element (element (cls, fields (0)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): PersonOrganisationRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PersonOrganisationRole (
            OrganisationRole.parse (context),
            mask (clientID (), 0),
            mask (ErpPerson (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PersonOrganisationRole] = PersonOrganisationRoleSerializer
}

object PersonOrganisationRoleSerializer extends CIMSerializer[PersonOrganisationRole]
{
    def write (kryo: Kryo, output: Output, obj: PersonOrganisationRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.clientID),
            () => output.writeString (obj.ErpPerson)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PersonOrganisationRole]): PersonOrganisationRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PersonOrganisationRole (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The role of a person relative to a given piece of property.
 *
 * Examples of roles include: owner, renter, contractor, etc.
 *
 * @param Role         [[ch.ninecode.model.Role Role]] Reference to the superclass object.
 * @param LandProperty [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Person       [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PersonPropertyRole
(
    Role: Role = null,
    LandProperty: String = null,
    Person: String = null
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
    override def sup: Role = Role

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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PersonPropertyRole]
{
    override val fields: Array[String] = Array [String](
        "LandProperty",
        "Person"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LandProperty", "LandProperty", "1", "0..*"),
        CIMRelationship ("Person", "OldPerson", "1", "0..*")
    )
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Person: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): PersonPropertyRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PersonPropertyRole (
            Role.parse (context),
            mask (LandProperty (), 0),
            mask (Person (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PersonPropertyRole] = PersonPropertyRoleSerializer
}

object PersonPropertyRoleSerializer extends CIMSerializer[PersonPropertyRole]
{
    def write (kryo: Kryo, output: Output, obj: PersonPropertyRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.LandProperty),
            () => output.writeString (obj.Person)
        )
        RoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PersonPropertyRole]): PersonPropertyRole =
    {
        val parent = RoleSerializer.read (kryo, input, classOf [Role])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PersonPropertyRole (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Role an organisation plays with respect to property (for example, the organisation may be the owner, renter, occupier, taxiing authority, etc.).
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param LandProperty     [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class PropertyOrganisationRole
(
    OrganisationRole: OrganisationRole = null,
    LandProperty: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PropertyOrganisationRole]
{
    override val fields: Array[String] = Array [String](
        "LandProperty"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LandProperty", "LandProperty", "1..", "0..*")
    )
    val LandProperty: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): PropertyOrganisationRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PropertyOrganisationRole (
            OrganisationRole.parse (context),
            masks (LandProperty (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PropertyOrganisationRole] = PropertyOrganisationRoleSerializer
}

object PropertyOrganisationRoleSerializer extends CIMSerializer[PropertyOrganisationRole]
{
    def write (kryo: Kryo, output: Output, obj: PropertyOrganisationRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.LandProperty, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PropertyOrganisationRole]): PropertyOrganisationRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf [OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PropertyOrganisationRole (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Fraction specified explicitly with a numerator and denominator, which can be used to calculate the quotient.
 *
 * @param Element     Reference to the superclass object.
 * @param denominator The part of a fraction that is below the line and that functions as the divisor of the numerator.
 * @param numerator   The part of a fraction that is above the line and signifies the number to be divided by the denominator.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Ratio
(
    Element: BasicElement = null,
    denominator: Double = 0.0,
    numerator: Double = 0.0
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Ratio]
{
    override val fields: Array[String] = Array [String](
        "denominator",
        "numerator"
    )
    val denominator: Fielder = parse_element (element (cls, fields (0)))
    val numerator: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: CIMContext): Ratio =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Ratio (
            BasicElement.parse (context),
            toDouble (mask (denominator (), 0)),
            toDouble (mask (numerator (), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Ratio] = RatioSerializer
}

object RatioSerializer extends CIMSerializer[Ratio]
{
    def write (kryo: Kryo, output: Output, obj: Ratio): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.denominator),
            () => output.writeDouble (obj.numerator)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Ratio]): Ratio =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Ratio (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Enumeration of potential roles that might be played by one object relative to another.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status           <em>undocumented</em>
 * @param type             Type of role.
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Role
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    `type`: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Role]
{
    override val fields: Array[String] = Array [String](
        "status",
        "type"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields (0)))
    val `type`: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: CIMContext): Role =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Role (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            mask (`type` (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Role] = RoleSerializer
}

object RoleSerializer extends CIMSerializer[Role]
{
    def write (kryo: Kryo, output: Output, obj: Role): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Role]): Role =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Role (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Proficiency level of a craft, which is required to operate or maintain a particular type of asset and/or perform certain types of work.
 *
 * @param Document                  [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param certificationPeriod       Interval between the certification and its expiry.
 * @param effectiveDateTime         Date and time the skill became effective.
 * @param level                     Level of skill for a Craft.
 * @param Crafts                    [[ch.ninecode.model.Craft Craft]] <em>undocumented</em>
 * @param ErpPerson                 [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param QualificationRequirements [[ch.ninecode.model.QualificationRequirement QualificationRequirement]] <em>undocumented</em>
 * @group InfCommon
 * @groupname InfCommon Package InfCommon
 * @groupdesc InfCommon This package contains functions common for distribution management.
 */
final case class Skill
(
    Document: Document = null,
    certificationPeriod: String = null,
    effectiveDateTime: String = null,
    level: String = null,
    Crafts: List[String] = null,
    ErpPerson: String = null,
    QualificationRequirements: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Skill]
{
    override val fields: Array[String] = Array [String](
        "certificationPeriod",
        "effectiveDateTime",
        "level",
        "Crafts",
        "ErpPerson",
        "QualificationRequirements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crafts", "Craft", "0..*", "0..*"),
        CIMRelationship ("ErpPerson", "OldPerson", "0..1", "0..*"),
        CIMRelationship ("QualificationRequirements", "QualificationRequirement", "0..*", "0..*")
    )
    val certificationPeriod: Fielder = parse_attribute (attribute (cls, fields (0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields (1)))
    val level: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Crafts: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields (4)))
    val QualificationRequirements: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: CIMContext): Skill =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[Skill] = SkillSerializer
}

object SkillSerializer extends CIMSerializer[Skill]
{
    def write (kryo: Kryo, output: Output, obj: Skill): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.certificationPeriod),
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeString (obj.level),
            () => writeList (obj.Crafts, output),
            () => output.writeString (obj.ErpPerson),
            () => writeList (obj.QualificationRequirements, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Skill]): Skill =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf [Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Skill (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfCommon
{
    def register: List[CIMClassInfo] =
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