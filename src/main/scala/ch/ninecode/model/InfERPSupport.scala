package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Information that generally describes the Bill of Material Structure and its contents for a utility.
 *
 * This is used by ERP systems to transfer Bill of Material information between two business applications.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpBOM
(
    override val sup: ErpDocument,
    Design: String
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpBOM] }
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
        implicit val clz: String = ErpBOM.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpBOM.fields (position), value)
        emitattr (0, Design)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpBOM rdf:ID=\"%s\">\n%s\t</cim:ErpBOM>".format (id, export_fields)
    }
}

object ErpBOM
extends
    Parseable[ErpBOM]
{
    val fields: Array[String] = Array[String] (
        "Design"
    )
    val Design: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ErpBOM =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpBOM (
            ErpDocument.parse (context),
            mask (Design (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Design", "Design", false)
    )
}

/**
 * Relationship under a particular name, usually evidenced by a deposit against which withdrawals can be made.
 *
 * Types of bank accounts include: demand, time, custodial, joint, trustee, corporate, special, and regular accounts.
 *
 * @param sup [[ch.ninecode.model.BankAccount BankAccount]] Reference to the superclass object.
 * @param bankABA Bank ABA.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpBankAccount
(
    override val sup: BankAccount,
    bankABA: String
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
    def BankAccount: BankAccount = sup.asInstanceOf[BankAccount]
    override def copy (): Row = { clone ().asInstanceOf[ErpBankAccount] }
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
        implicit val clz: String = ErpBankAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpBankAccount.fields (position), value)
        emitelem (0, bankABA)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpBankAccount rdf:ID=\"%s\">\n%s\t</cim:ErpBankAccount>".format (id, export_fields)
    }
}

object ErpBankAccount
extends
    Parseable[ErpBankAccount]
{
    val fields: Array[String] = Array[String] (
        "bankABA"
    )
    val bankABA: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ErpBankAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpBankAccount (
            BankAccount.parse (context),
            mask (bankABA (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An individual item on a bill of materials.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param DesignLocation [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param ErpBOM [[ch.ninecode.model.ErpBOM ErpBOM]] <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpBomItemData
(
    override val sup: ErpIdentifiedObject,
    DesignLocation: String,
    ErpBOM: String,
    TypeAsset: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpBomItemData] }
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
        implicit val clz: String = ErpBomItemData.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpBomItemData.fields (position), value)
        emitattr (0, DesignLocation)
        emitattr (1, ErpBOM)
        emitattr (2, TypeAsset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpBomItemData rdf:ID=\"%s\">\n%s\t</cim:ErpBomItemData>".format (id, export_fields)
    }
}

object ErpBomItemData
extends
    Parseable[ErpBomItemData]
{
    val fields: Array[String] = Array[String] (
        "DesignLocation",
        "ErpBOM",
        "TypeAsset"
    )
    val DesignLocation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpBOM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ErpBomItemData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpBomItemData (
            ErpIdentifiedObject.parse (context),
            mask (DesignLocation (), 0),
            mask (ErpBOM (), 1),
            mask (TypeAsset (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DesignLocation", "DesignLocation", false),
        Relationship ("ErpBOM", "ErpBOM", false),
        Relationship ("TypeAsset", "GenericAssetModelOrMaterial", false)
    )
}

/**
 * Accounting structure of a business.
 *
 * Each account represents a financial aspect of a business, such as its Accounts Payable, or the value of its inventory, or its office supply expenses.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpChartOfAccounts
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpChartOfAccounts] }
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
        "\t<cim:ErpChartOfAccounts rdf:ID=\"%s\">\n%s\t</cim:ErpChartOfAccounts>".format (id, export_fields)
    }
}

object ErpChartOfAccounts
extends
    Parseable[ErpChartOfAccounts]
{

    def parse (context: Context): ErpChartOfAccounts =
    {
        implicit val ctx: Context = context
        val ret = ErpChartOfAccounts (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Information that describes aptitudes of a utility employee.
 *
 * Unlike Skills that an ErpPerson must be certified to perform before undertaking certain type of assignments (to be able to perfrom a Craft), ErpCompetency has more to do with typical Human Resource (HR) matters such as schooling, training, etc.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpCompetency
(
    override val sup: ErpIdentifiedObject
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpCompetency] }
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
        "\t<cim:ErpCompetency rdf:ID=\"%s\">\n%s\t</cim:ErpCompetency>".format (id, export_fields)
    }
}

object ErpCompetency
extends
    Parseable[ErpCompetency]
{

    def parse (context: Context): ErpCompetency =
    {
        implicit val ctx: Context = context
        val ret = ErpCompetency (
            ErpIdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpDocument
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
    override def copy (): Row = { clone ().asInstanceOf[ErpDocument] }
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
        "\t<cim:ErpDocument rdf:ID=\"%s\">\n%s\t</cim:ErpDocument>".format (id, export_fields)
    }
}

object ErpDocument
extends
    Parseable[ErpDocument]
{

    def parse (context: Context): ErpDocument =
    {
        implicit val ctx: Context = context
        val ret = ErpDocument (
            Document.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * General Utility Engineering Change Order information.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpEngChangeOrder
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpEngChangeOrder] }
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
        "\t<cim:ErpEngChangeOrder rdf:ID=\"%s\">\n%s\t</cim:ErpEngChangeOrder>".format (id, export_fields)
    }
}

object ErpEngChangeOrder
extends
    Parseable[ErpEngChangeOrder]
{

    def parse (context: Context): ErpEngChangeOrder =
    {
        implicit val ctx: Context = context
        val ret = ErpEngChangeOrder (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpIdentifiedObject
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpIdentifiedObject] }
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
        "\t<cim:ErpIdentifiedObject rdf:ID=\"%s\">\n%s\t</cim:ErpIdentifiedObject>".format (id, export_fields)
    }
}

object ErpIdentifiedObject
extends
    Parseable[ErpIdentifiedObject]
{

    def parse (context: Context): ErpIdentifiedObject =
    {
        implicit val ctx: Context = context
        val ret = ErpIdentifiedObject (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Utility inventory-related information about an item or part (and not for description of the item and its attributes).
 *
 * It is used by ERP applications to enable the synchronization of Inventory data that exists on separate Item Master databases. This data is not the master data that describes the attributes of the item such as dimensions, weight, or unit of measure - it describes the item as it exists at a specific location.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpInventory
(
    override val sup: ErpIdentifiedObject,
    status: String,
    Asset: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpInventory] }
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
        implicit val clz: String = ErpInventory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpInventory.fields (position), value)
        emitattr (0, status)
        emitattr (1, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpInventory rdf:ID=\"%s\">\n%s\t</cim:ErpInventory>".format (id, export_fields)
    }
}

object ErpInventory
extends
    Parseable[ErpInventory]
{
    val fields: Array[String] = Array[String] (
        "status",
        "Asset"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ErpInventory =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpInventory (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (Asset (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false)
    )
}

/**
 * This is related to Inventory physical counts organized by AssetModel.
 *
 * Note that a count of a type of asset can be accomplished by the association inherited by AssetModel (from Document) to Asset.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param AssetModel [[ch.ninecode.model.AssetModel AssetModel]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpInventoryCount
(
    override val sup: ErpIdentifiedObject,
    status: String,
    AssetModel: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpInventoryCount] }
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
        implicit val clz: String = ErpInventoryCount.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpInventoryCount.fields (position), value)
        emitattr (0, status)
        emitattr (1, AssetModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpInventoryCount rdf:ID=\"%s\">\n%s\t</cim:ErpInventoryCount>".format (id, export_fields)
    }
}

object ErpInventoryCount
extends
    Parseable[ErpInventoryCount]
{
    val fields: Array[String] = Array[String] (
        "status",
        "AssetModel"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AssetModel: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ErpInventoryCount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpInventoryCount (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (AssetModel (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetModel", "AssetModel", false)
    )
}

/**
 * A roll up of invoice line items.
 *
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param amount Total amount due on this invoice based on line items and applicable adjustments.
 * @param billMediaKind Kind of media by which the CustomerBillingInfo was delivered.
 * @param dueDate Calculated date upon which the Invoice amount is due.
 * @param kind Kind of invoice (default is 'sales').
 * @param mailedDate Date on which the customer billing statement/invoice was printed/mailed.
 * @param proForma True if payment is to be paid by a Customer to accept a particular ErpQuote (with associated Design) and have work initiated, at which time an associated ErpInvoice should automatically be generated.
 *        EprPayment.subjectStatus satisfies terms specificed in the ErpQuote.
 * @param referenceNumber Number of an invoice to be reference by this invoice.
 * @param transactionDateTime Date and time when the invoice is issued.
 * @param transferType Type of invoice transfer.
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpInvoice
(
    override val sup: ErpDocument,
    amount: Double,
    billMediaKind: String,
    dueDate: String,
    kind: String,
    mailedDate: String,
    proForma: Boolean,
    referenceNumber: String,
    transactionDateTime: String,
    transferType: String,
    CustomerAccount: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpInvoice] }
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
        implicit val clz: String = ErpInvoice.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpInvoice.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpInvoice.fields (position), value)
        emitelem (0, amount)
        emitattr (1, billMediaKind)
        emitelem (2, dueDate)
        emitattr (3, kind)
        emitelem (4, mailedDate)
        emitelem (5, proForma)
        emitelem (6, referenceNumber)
        emitelem (7, transactionDateTime)
        emitelem (8, transferType)
        emitattr (9, CustomerAccount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpInvoice rdf:ID=\"%s\">\n%s\t</cim:ErpInvoice>".format (id, export_fields)
    }
}

object ErpInvoice
extends
    Parseable[ErpInvoice]
{
    val fields: Array[String] = Array[String] (
        "amount",
        "billMediaKind",
        "dueDate",
        "kind",
        "mailedDate",
        "proForma",
        "referenceNumber",
        "transactionDateTime",
        "transferType",
        "CustomerAccount"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val billMediaKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val dueDate: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val mailedDate: Fielder = parse_element (element (cls, fields(4)))
    val proForma: Fielder = parse_element (element (cls, fields(5)))
    val referenceNumber: Fielder = parse_element (element (cls, fields(6)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(7)))
    val transferType: Fielder = parse_element (element (cls, fields(8)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): ErpInvoice =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpInvoice (
            ErpDocument.parse (context),
            toDouble (mask (amount (), 0)),
            mask (billMediaKind (), 1),
            mask (dueDate (), 2),
            mask (kind (), 3),
            mask (mailedDate (), 4),
            toBoolean (mask (proForma (), 5)),
            mask (referenceNumber (), 6),
            mask (transactionDateTime (), 7),
            mask (transferType (), 8),
            mask (CustomerAccount (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CustomerAccount", "CustomerAccount", false)
    )
}

/**
 * An individual line item on an invoice.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param billPeriod Bill period for the line item.
 * @param glAccount General Ledger account code, must be a valid combination.
 * @param glDateTime Date and time line item will be posted to the General Ledger.
 * @param kind Kind of line item.
 * @param lineAmount Amount due for this line item.
 * @param lineNumber Line item number on invoice statement.
 * @param lineVersion Version number of the bill run.
 * @param netAmount Net line item charge amount.
 * @param previousAmount Previous line item charge amount.
 * @param ContainerErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpInvoice [[ch.ninecode.model.ErpInvoice ErpInvoice]] <em>undocumented</em>
 * @param ErpPayableLineItem [[ch.ninecode.model.ErpPayableLineItem ErpPayableLineItem]] <em>undocumented</em>
 * @param ErpPayments [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @param ErpQuoteLineItem [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param ErpRecDelvLineItem [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param ErpRecLineItem [[ch.ninecode.model.ErpRecLineItem ErpRecLineItem]] <em>undocumented</em>
 * @param UserAttributes [[ch.ninecode.model.UserAttribute UserAttribute]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpInvoiceLineItem
(
    override val sup: ErpDocument,
    billPeriod: String,
    glAccount: String,
    glDateTime: String,
    kind: String,
    lineAmount: Double,
    lineNumber: String,
    lineVersion: String,
    netAmount: Double,
    previousAmount: Double,
    ContainerErpInvoiceLineItem: String,
    ErpInvoice: String,
    ErpPayableLineItem: String,
    ErpPayments: List[String],
    ErpQuoteLineItem: String,
    ErpRecDelvLineItem: String,
    ErpRecLineItem: String,
    UserAttributes: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, null, null, 0.0, 0.0, null, null, null, List(), null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpInvoiceLineItem] }
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
        implicit val clz: String = ErpInvoiceLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpInvoiceLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpInvoiceLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ErpInvoiceLineItem.fields (position), x))
        emitattr (0, billPeriod)
        emitelem (1, glAccount)
        emitelem (2, glDateTime)
        emitattr (3, kind)
        emitelem (4, lineAmount)
        emitelem (5, lineNumber)
        emitelem (6, lineVersion)
        emitelem (7, netAmount)
        emitelem (8, previousAmount)
        emitattr (9, ContainerErpInvoiceLineItem)
        emitattr (10, ErpInvoice)
        emitattr (11, ErpPayableLineItem)
        emitattrs (12, ErpPayments)
        emitattr (13, ErpQuoteLineItem)
        emitattr (14, ErpRecDelvLineItem)
        emitattr (15, ErpRecLineItem)
        emitattrs (16, UserAttributes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpInvoiceLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpInvoiceLineItem>".format (id, export_fields)
    }
}

object ErpInvoiceLineItem
extends
    Parseable[ErpInvoiceLineItem]
{
    val fields: Array[String] = Array[String] (
        "billPeriod",
        "glAccount",
        "glDateTime",
        "kind",
        "lineAmount",
        "lineNumber",
        "lineVersion",
        "netAmount",
        "previousAmount",
        "ContainerErpInvoiceLineItem",
        "ErpInvoice",
        "ErpPayableLineItem",
        "ErpPayments",
        "ErpQuoteLineItem",
        "ErpRecDelvLineItem",
        "ErpRecLineItem",
        "UserAttributes"
    )
    val billPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val glAccount: Fielder = parse_element (element (cls, fields(1)))
    val glDateTime: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val lineAmount: Fielder = parse_element (element (cls, fields(4)))
    val lineNumber: Fielder = parse_element (element (cls, fields(5)))
    val lineVersion: Fielder = parse_element (element (cls, fields(6)))
    val netAmount: Fielder = parse_element (element (cls, fields(7)))
    val previousAmount: Fielder = parse_element (element (cls, fields(8)))
    val ContainerErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ErpInvoice: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ErpPayableLineItem: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ErpPayments: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val ErpQuoteLineItem: Fielder = parse_attribute (attribute (cls, fields(13)))
    val ErpRecDelvLineItem: Fielder = parse_attribute (attribute (cls, fields(14)))
    val ErpRecLineItem: Fielder = parse_attribute (attribute (cls, fields(15)))
    val UserAttributes: FielderMultiple = parse_attributes (attribute (cls, fields(16)))

    def parse (context: Context): ErpInvoiceLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpInvoiceLineItem (
            ErpDocument.parse (context),
            mask (billPeriod (), 0),
            mask (glAccount (), 1),
            mask (glDateTime (), 2),
            mask (kind (), 3),
            toDouble (mask (lineAmount (), 4)),
            mask (lineNumber (), 5),
            mask (lineVersion (), 6),
            toDouble (mask (netAmount (), 7)),
            toDouble (mask (previousAmount (), 8)),
            mask (ContainerErpInvoiceLineItem (), 9),
            mask (ErpInvoice (), 10),
            mask (ErpPayableLineItem (), 11),
            masks (ErpPayments (), 12),
            mask (ErpQuoteLineItem (), 13),
            mask (ErpRecDelvLineItem (), 14),
            mask (ErpRecLineItem (), 15),
            masks (UserAttributes (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ContainerErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpInvoice", "ErpInvoice", false),
        Relationship ("ErpPayableLineItem", "ErpPayableLineItem", false),
        Relationship ("ErpPayments", "ErpPayment", true),
        Relationship ("ErpQuoteLineItem", "ErpQuoteLineItem", false),
        Relationship ("ErpRecDelvLineItem", "ErpRecDelvLineItem", false),
        Relationship ("ErpRecLineItem", "ErpRecLineItem", false),
        Relationship ("UserAttributes", "UserAttribute", true)
    )
}

/**
 * Can be used to request an application to process an issue or request information about an issue.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] <em>undocumented</em>
 * @param TypeMaterial [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpIssueInventory
(
    override val sup: ErpIdentifiedObject,
    status: String,
    TypeAsset: String,
    TypeMaterial: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpIssueInventory] }
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
        implicit val clz: String = ErpIssueInventory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpIssueInventory.fields (position), value)
        emitattr (0, status)
        emitattr (1, TypeAsset)
        emitattr (2, TypeMaterial)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpIssueInventory rdf:ID=\"%s\">\n%s\t</cim:ErpIssueInventory>".format (id, export_fields)
    }
}

object ErpIssueInventory
extends
    Parseable[ErpIssueInventory]
{
    val fields: Array[String] = Array[String] (
        "status",
        "TypeAsset",
        "TypeMaterial"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ErpIssueInventory =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpIssueInventory (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (TypeAsset (), 1),
            mask (TypeMaterial (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TypeAsset", "GenericAssetModelOrMaterial", false),
        Relationship ("TypeMaterial", "TypeMaterial", false)
    )
}

/**
 * Any unique purchased part for manufactured product tracked by ERP systems for a utility.
 *
 * Item, as used by the OAG, refers to the basic information about an item, including its attributes, cost, and locations. It does not include item quantities. Compare to the Inventory, which includes all quantities and other location-specific information.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpItemMaster
(
    override val sup: ErpIdentifiedObject,
    status: String,
    Asset: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpItemMaster] }
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
        implicit val clz: String = ErpItemMaster.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpItemMaster.fields (position), value)
        emitattr (0, status)
        emitattr (1, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpItemMaster rdf:ID=\"%s\">\n%s\t</cim:ErpItemMaster>".format (id, export_fields)
    }
}

object ErpItemMaster
extends
    Parseable[ErpItemMaster]
{
    val fields: Array[String] = Array[String] (
        "status",
        "Asset"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ErpItemMaster =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpItemMaster (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (Asset (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false)
    )
}

/**
 * Book for recording accounting transactions as they occur.
 *
 * Transactions and adjustments are first recorded in a journal, which is like a diary of instructions, advising which account to be charged and by how much.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpJournal
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpJournal] }
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
        "\t<cim:ErpJournal rdf:ID=\"%s\">\n%s\t</cim:ErpJournal>".format (id, export_fields)
    }
}

object ErpJournal
extends
    Parseable[ErpJournal]
{

    def parse (context: Context): ErpJournal =
    {
        implicit val ctx: Context = context
        val ret = ErpJournal (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Details of an individual entry in a journal, which is to be posted to a ledger on the posting date.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postingDateTime Date and time this entry is to be posted to the ledger.
 * @param sourceID The identifer of the source for this entry.
 * @param status <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournal [[ch.ninecode.model.ErpJournal ErpJournal]] <em>undocumented</em>
 * @param ErpLedgerEntry [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpJournalEntry
(
    override val sup: ErpIdentifiedObject,
    accountID: String,
    amount: Double,
    postingDateTime: String,
    sourceID: String,
    status: String,
    transactionDateTime: String,
    ErpInvoiceLineItem: String,
    ErpJournal: String,
    ErpLedgerEntry: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpJournalEntry] }
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
        implicit val clz: String = ErpJournalEntry.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpJournalEntry.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpJournalEntry.fields (position), value)
        emitelem (0, accountID)
        emitelem (1, amount)
        emitelem (2, postingDateTime)
        emitelem (3, sourceID)
        emitattr (4, status)
        emitelem (5, transactionDateTime)
        emitattr (6, ErpInvoiceLineItem)
        emitattr (7, ErpJournal)
        emitattr (8, ErpLedgerEntry)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpJournalEntry rdf:ID=\"%s\">\n%s\t</cim:ErpJournalEntry>".format (id, export_fields)
    }
}

object ErpJournalEntry
extends
    Parseable[ErpJournalEntry]
{
    val fields: Array[String] = Array[String] (
        "accountID",
        "amount",
        "postingDateTime",
        "sourceID",
        "status",
        "transactionDateTime",
        "ErpInvoiceLineItem",
        "ErpJournal",
        "ErpLedgerEntry"
    )
    val accountID: Fielder = parse_element (element (cls, fields(0)))
    val amount: Fielder = parse_element (element (cls, fields(1)))
    val postingDateTime: Fielder = parse_element (element (cls, fields(2)))
    val sourceID: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(5)))
    val ErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ErpJournal: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ErpLedgerEntry: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): ErpJournalEntry =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpJournalEntry (
            ErpIdentifiedObject.parse (context),
            mask (accountID (), 0),
            toDouble (mask (amount (), 1)),
            mask (postingDateTime (), 2),
            mask (sourceID (), 3),
            mask (status (), 4),
            mask (transactionDateTime (), 5),
            mask (ErpInvoiceLineItem (), 6),
            mask (ErpJournal (), 7),
            mask (ErpLedgerEntry (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpJournal", "ErpJournal", false),
        Relationship ("ErpLedgerEntry", "ErpLedgerEntry", false)
    )
}

/**
 * Individual entry of a given Ledger Budget, typically containing information such as amount, accounting date, accounting period, and is associated with the applicable general ledger account.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpLedBudLineItem_attr [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @param ErpLedgerBudget [[ch.ninecode.model.ErpLedgerBudget ErpLedgerBudget]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpLedBudLineItem
(
    override val sup: ErpIdentifiedObject,
    status: String,
    ErpLedBudLineItem_attr: String,
    ErpLedgerBudget: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpLedBudLineItem] }
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
        implicit val clz: String = ErpLedBudLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpLedBudLineItem.fields (position), value)
        emitattr (0, status)
        emitattr (1, ErpLedBudLineItem_attr)
        emitattr (2, ErpLedgerBudget)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpLedBudLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpLedBudLineItem>".format (id, export_fields)
    }
}

object ErpLedBudLineItem
extends
    Parseable[ErpLedBudLineItem]
{
    val fields: Array[String] = Array[String] (
        "status",
        "ErpLedBudLineItem",
        "ErpLedgerBudget"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpLedBudLineItem_attr: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpLedgerBudget: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ErpLedBudLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpLedBudLineItem (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (ErpLedBudLineItem_attr (), 1),
            mask (ErpLedgerBudget (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpLedBudLineItem_attr", "ErpLedgerEntry", false),
        Relationship ("ErpLedgerBudget", "ErpLedgerBudget", false)
    )
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpLedger
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpLedger] }
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
        "\t<cim:ErpLedger rdf:ID=\"%s\">\n%s\t</cim:ErpLedger>".format (id, export_fields)
    }
}

object ErpLedger
extends
    Parseable[ErpLedger]
{

    def parse (context: Context): ErpLedger =
    {
        implicit val ctx: Context = context
        val ret = ErpLedger (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Information for utility Ledger Budgets.
 *
 * They support the transfer budget amounts between all possible source applications throughout an enterprise and a general ledger or budget application.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpLedgerBudget
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpLedgerBudget] }
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
        "\t<cim:ErpLedgerBudget rdf:ID=\"%s\">\n%s\t</cim:ErpLedgerBudget>".format (id, export_fields)
    }
}

object ErpLedgerBudget
extends
    Parseable[ErpLedgerBudget]
{

    def parse (context: Context): ErpLedgerBudget =
    {
        implicit val ctx: Context = context
        val ret = ErpLedgerBudget (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Details of an individual entry in a ledger, which was posted from a journal on the posted date.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param accountKind Kind of account for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postedDateTime Date and time this entry was posted to the ledger.
 * @param status <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpJounalEntry [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpLedger [[ch.ninecode.model.ErpLedger ErpLedger]] <em>undocumented</em>
 * @param ErpLedgerEntry_attr [[ch.ninecode.model.ErpLedBudLineItem ErpLedBudLineItem]] <em>undocumented</em>
 * @param UserAttributes [[ch.ninecode.model.UserAttribute UserAttribute]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpLedgerEntry
(
    override val sup: ErpIdentifiedObject,
    accountID: String,
    accountKind: String,
    amount: Double,
    postedDateTime: String,
    status: String,
    transactionDateTime: String,
    ErpJounalEntry: String,
    ErpLedger: String,
    ErpLedgerEntry_attr: String,
    UserAttributes: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpLedgerEntry] }
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
        implicit val clz: String = ErpLedgerEntry.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpLedgerEntry.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpLedgerEntry.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ErpLedgerEntry.fields (position), x))
        emitelem (0, accountID)
        emitattr (1, accountKind)
        emitelem (2, amount)
        emitelem (3, postedDateTime)
        emitattr (4, status)
        emitelem (5, transactionDateTime)
        emitattr (6, ErpJounalEntry)
        emitattr (7, ErpLedger)
        emitattr (8, ErpLedgerEntry_attr)
        emitattrs (9, UserAttributes)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpLedgerEntry rdf:ID=\"%s\">\n%s\t</cim:ErpLedgerEntry>".format (id, export_fields)
    }
}

object ErpLedgerEntry
extends
    Parseable[ErpLedgerEntry]
{
    val fields: Array[String] = Array[String] (
        "accountID",
        "accountKind",
        "amount",
        "postedDateTime",
        "status",
        "transactionDateTime",
        "ErpJounalEntry",
        "ErpLedger",
        "ErpLedgerEntry",
        "UserAttributes"
    )
    val accountID: Fielder = parse_element (element (cls, fields(0)))
    val accountKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val amount: Fielder = parse_element (element (cls, fields(2)))
    val postedDateTime: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val transactionDateTime: Fielder = parse_element (element (cls, fields(5)))
    val ErpJounalEntry: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ErpLedger: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ErpLedgerEntry_attr: Fielder = parse_attribute (attribute (cls, fields(8)))
    val UserAttributes: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): ErpLedgerEntry =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpLedgerEntry (
            ErpIdentifiedObject.parse (context),
            mask (accountID (), 0),
            mask (accountKind (), 1),
            toDouble (mask (amount (), 2)),
            mask (postedDateTime (), 3),
            mask (status (), 4),
            mask (transactionDateTime (), 5),
            mask (ErpJounalEntry (), 6),
            mask (ErpLedger (), 7),
            mask (ErpLedgerEntry_attr (), 8),
            masks (UserAttributes (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpJounalEntry", "ErpJournalEntry", false),
        Relationship ("ErpLedger", "ErpLedger", false),
        Relationship ("ErpLedgerEntry_attr", "ErpLedBudLineItem", false),
        Relationship ("UserAttributes", "UserAttribute", true)
    )
}

/**
 * Of an ErpPurchaseOrder, this is an individually ordered item or product along with the quantity, price and other descriptive information.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param AssetModelCatalogueItem [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param ErpPurchaseOrder [[ch.ninecode.model.ErpPurchaseOrder ErpPurchaseOrder]] <em>undocumented</em>
 * @param ErpRecDelLineItem [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param ErpReqLineItem [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPOLineItem
(
    override val sup: ErpDocument,
    AssetModelCatalogueItem: String,
    ErpPurchaseOrder: String,
    ErpRecDelLineItem: String,
    ErpReqLineItem: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpPOLineItem] }
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
        implicit val clz: String = ErpPOLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpPOLineItem.fields (position), value)
        emitattr (0, AssetModelCatalogueItem)
        emitattr (1, ErpPurchaseOrder)
        emitattr (2, ErpRecDelLineItem)
        emitattr (3, ErpReqLineItem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpPOLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpPOLineItem>".format (id, export_fields)
    }
}

object ErpPOLineItem
extends
    Parseable[ErpPOLineItem]
{
    val fields: Array[String] = Array[String] (
        "AssetModelCatalogueItem",
        "ErpPurchaseOrder",
        "ErpRecDelLineItem",
        "ErpReqLineItem"
    )
    val AssetModelCatalogueItem: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpPurchaseOrder: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpRecDelLineItem: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpReqLineItem: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ErpPOLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpPOLineItem (
            ErpDocument.parse (context),
            mask (AssetModelCatalogueItem (), 0),
            mask (ErpPurchaseOrder (), 1),
            mask (ErpRecDelLineItem (), 2),
            mask (ErpReqLineItem (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetModelCatalogueItem", "AssetModelCatalogueItem", false),
        Relationship ("ErpPurchaseOrder", "ErpPurchaseOrder", false),
        Relationship ("ErpRecDelLineItem", "ErpRecDelvLineItem", false),
        Relationship ("ErpReqLineItem", "ErpReqLineItem", false)
    )
}

/**
 * A transaction that represents an invoice from a supplier.
 *
 * A payable (or voucher) is an open item, approved and ready for payment, in the Accounts Payable ledger.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPayable
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpPayable] }
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
        "\t<cim:ErpPayable rdf:ID=\"%s\">\n%s\t</cim:ErpPayable>".format (id, export_fields)
    }
}

object ErpPayable
extends
    Parseable[ErpPayable]
{

    def parse (context: Context): ErpPayable =
    {
        implicit val ctx: Context = context
        val ret = ErpPayable (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Of an ErpPayable, a line item references an ErpInvoiceLineitem or other source such as credit memos.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournalEntries [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpPayable [[ch.ninecode.model.ErpPayable ErpPayable]] <em>undocumented</em>
 * @param ErpPayments [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPayableLineItem
(
    override val sup: ErpIdentifiedObject,
    status: String,
    ErpInvoiceLineItem: String,
    ErpJournalEntries: List[String],
    ErpPayable: String,
    ErpPayments: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpPayableLineItem] }
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
        implicit val clz: String = ErpPayableLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpPayableLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ErpPayableLineItem.fields (position), x))
        emitattr (0, status)
        emitattr (1, ErpInvoiceLineItem)
        emitattrs (2, ErpJournalEntries)
        emitattr (3, ErpPayable)
        emitattrs (4, ErpPayments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpPayableLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpPayableLineItem>".format (id, export_fields)
    }
}

object ErpPayableLineItem
extends
    Parseable[ErpPayableLineItem]
{
    val fields: Array[String] = Array[String] (
        "status",
        "ErpInvoiceLineItem",
        "ErpJournalEntries",
        "ErpPayable",
        "ErpPayments"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpJournalEntries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ErpPayable: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ErpPayments: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): ErpPayableLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpPayableLineItem (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (ErpInvoiceLineItem (), 1),
            masks (ErpJournalEntries (), 2),
            mask (ErpPayable (), 3),
            masks (ErpPayments (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpJournalEntries", "ErpJournalEntry", true),
        Relationship ("ErpPayable", "ErpPayable", false),
        Relationship ("ErpPayments", "ErpPayment", true)
    )
}

/**
 * Payment infromation and status for any individual line item of an ErpInvoice (e.g., when payment is from a customer).
 *
 * ErpPayable is also updated when payment is to a supplier and ErpReceivable is updated when payment is from a customer. Multiple payments can be made against a single line item and an individual payment can apply to more that one line item.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param termsPayment Payment terms (e.g., net 30).
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPayment
(
    override val sup: ErpDocument,
    termsPayment: String
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpPayment] }
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
        implicit val clz: String = ErpPayment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpPayment.fields (position), value)
        emitelem (0, termsPayment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpPayment rdf:ID=\"%s\">\n%s\t</cim:ErpPayment>".format (id, export_fields)
    }
}

object ErpPayment
extends
    Parseable[ErpPayment]
{
    val fields: Array[String] = Array[String] (
        "termsPayment"
    )
    val termsPayment: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ErpPayment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpPayment (
            ErpDocument.parse (context),
            mask (termsPayment (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Information that applies to the basic data about a utility person, used by ERP applications to transfer Personnel data for a worker.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPersonnel
(
    override val sup: ErpIdentifiedObject,
    status: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpPersonnel] }
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
        implicit val clz: String = ErpPersonnel.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpPersonnel.fields (position), value)
        emitattr (0, status)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpPersonnel rdf:ID=\"%s\">\n%s\t</cim:ErpPersonnel>".format (id, export_fields)
    }
}

object ErpPersonnel
extends
    Parseable[ErpPersonnel]
{
    val fields: Array[String] = Array[String] (
        "status"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ErpPersonnel =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpPersonnel (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Utility Project Accounting information, used by ERP applications to enable all relevant sub-systems that submit single sided transactions to transfer information with a Project Accounting Application.
 *
 * This would include, but not necessarily be limited to: Accounts Payable, Accounts Receivable, Budget, Order Management, Purchasing, Time and Labor, Travel and Expense.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpProjectAccounting
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpProjectAccounting] }
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
        "\t<cim:ErpProjectAccounting rdf:ID=\"%s\">\n%s\t</cim:ErpProjectAccounting>".format (id, export_fields)
    }
}

object ErpProjectAccounting
extends
    Parseable[ErpProjectAccounting]
{

    def parse (context: Context): ErpProjectAccounting =
    {
        implicit val ctx: Context = context
        val ret = ErpProjectAccounting (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A document that communicates an order to purchase goods from a buyer to a supplier.
 *
 * The PurchaseOrder carries information to and from the buyer and supplier. It is a legally binding document once both Parties agree to the contents and the specified terms and conditions of the order.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpPurchaseOrder
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpPurchaseOrder] }
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
        "\t<cim:ErpPurchaseOrder rdf:ID=\"%s\">\n%s\t</cim:ErpPurchaseOrder>".format (id, export_fields)
    }
}

object ErpPurchaseOrder
extends
    Parseable[ErpPurchaseOrder]
{

    def parse (context: Context): ErpPurchaseOrder =
    {
        implicit val ctx: Context = context
        val ret = ErpPurchaseOrder (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Document describing the prices of goods or services provided by a supplier.
 *
 * It includes the terms of the purchase, delivery proposals, identification of goods or services ordered, as well as their quantities.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpQuote
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpQuote] }
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
        "\t<cim:ErpQuote rdf:ID=\"%s\">\n%s\t</cim:ErpQuote>".format (id, export_fields)
    }
}

object ErpQuote
extends
    Parseable[ErpQuote]
{

    def parse (context: Context): ErpQuote =
    {
        implicit val ctx: Context = context
        val ret = ErpQuote (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Of an ErpQuote, the item or product quoted along with quantity, price and other descriptive information.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param AssetModelCatalogueItem [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param Design [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] Some utilities provide quotes to customer for services, where the customer accepts the quote by making a payment.
 *        An invoice is required for this to occur.
 * @param ErpQuote [[ch.ninecode.model.ErpQuote ErpQuote]] <em>undocumented</em>
 * @param ErpReqLineItem [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpQuoteLineItem
(
    override val sup: ErpIdentifiedObject,
    status: String,
    AssetModelCatalogueItem: String,
    Design: String,
    ErpInvoiceLineItem: String,
    ErpQuote: String,
    ErpReqLineItem: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpQuoteLineItem] }
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
        implicit val clz: String = ErpQuoteLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpQuoteLineItem.fields (position), value)
        emitattr (0, status)
        emitattr (1, AssetModelCatalogueItem)
        emitattr (2, Design)
        emitattr (3, ErpInvoiceLineItem)
        emitattr (4, ErpQuote)
        emitattr (5, ErpReqLineItem)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpQuoteLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpQuoteLineItem>".format (id, export_fields)
    }
}

object ErpQuoteLineItem
extends
    Parseable[ErpQuoteLineItem]
{
    val fields: Array[String] = Array[String] (
        "status",
        "AssetModelCatalogueItem",
        "Design",
        "ErpInvoiceLineItem",
        "ErpQuote",
        "ErpReqLineItem"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AssetModelCatalogueItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Design: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ErpQuote: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpReqLineItem: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): ErpQuoteLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpQuoteLineItem (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (AssetModelCatalogueItem (), 1),
            mask (Design (), 2),
            mask (ErpInvoiceLineItem (), 3),
            mask (ErpQuote (), 4),
            mask (ErpReqLineItem (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AssetModelCatalogueItem", "AssetModelCatalogueItem", false),
        Relationship ("Design", "Design", false),
        Relationship ("ErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpQuote", "ErpQuote", false),
        Relationship ("ErpReqLineItem", "ErpReqLineItem", false)
    )
}

/**
 * Of an ErpReceiveDelivery, this is an individually received good or service by the Organisation receiving goods or services.
 *
 * It may be used to indicate receipt of goods in conjunction with a purchase order line item.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpPOLineItem [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @param ErpReceiveDelivery [[ch.ninecode.model.ErpReceiveDelivery ErpReceiveDelivery]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpRecDelvLineItem
(
    override val sup: ErpIdentifiedObject,
    status: String,
    ErpInvoiceLineItem: String,
    ErpPOLineItem: String,
    ErpReceiveDelivery: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpRecDelvLineItem] }
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
        implicit val clz: String = ErpRecDelvLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpRecDelvLineItem.fields (position), value)
        emitattr (0, status)
        emitattr (1, ErpInvoiceLineItem)
        emitattr (2, ErpPOLineItem)
        emitattr (3, ErpReceiveDelivery)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpRecDelvLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpRecDelvLineItem>".format (id, export_fields)
    }
}

object ErpRecDelvLineItem
extends
    Parseable[ErpRecDelvLineItem]
{
    val fields: Array[String] = Array[String] (
        "status",
        "ErpInvoiceLineItem",
        "ErpPOLineItem",
        "ErpReceiveDelivery"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpPOLineItem: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpReceiveDelivery: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ErpRecDelvLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpRecDelvLineItem (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (ErpInvoiceLineItem (), 1),
            mask (ErpPOLineItem (), 2),
            mask (ErpReceiveDelivery (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpPOLineItem", "ErpPOLineItem", false),
        Relationship ("ErpReceiveDelivery", "ErpReceiveDelivery", false)
    )
}

/**
 * Individual entry of an ErpReceivable, it is a particular transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournalEntries [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpPayments [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @param ErpReceivable [[ch.ninecode.model.ErpReceivable ErpReceivable]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpRecLineItem
(
    override val sup: ErpIdentifiedObject,
    status: String,
    ErpInvoiceLineItem: String,
    ErpJournalEntries: List[String],
    ErpPayments: List[String],
    ErpReceivable: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpRecLineItem] }
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
        implicit val clz: String = ErpRecLineItem.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpRecLineItem.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ErpRecLineItem.fields (position), x))
        emitattr (0, status)
        emitattr (1, ErpInvoiceLineItem)
        emitattrs (2, ErpJournalEntries)
        emitattrs (3, ErpPayments)
        emitattr (4, ErpReceivable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpRecLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpRecLineItem>".format (id, export_fields)
    }
}

object ErpRecLineItem
extends
    Parseable[ErpRecLineItem]
{
    val fields: Array[String] = Array[String] (
        "status",
        "ErpInvoiceLineItem",
        "ErpJournalEntries",
        "ErpPayments",
        "ErpReceivable"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpInvoiceLineItem: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpJournalEntries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ErpPayments: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ErpReceivable: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ErpRecLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpRecLineItem (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (ErpInvoiceLineItem (), 1),
            masks (ErpJournalEntries (), 2),
            masks (ErpPayments (), 3),
            mask (ErpReceivable (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpInvoiceLineItem", "ErpInvoiceLineItem", false),
        Relationship ("ErpJournalEntries", "ErpJournalEntry", true),
        Relationship ("ErpPayments", "ErpPayment", true),
        Relationship ("ErpReceivable", "ErpReceivable", false)
    )
}

/**
 * Transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * It is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpReceivable
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpReceivable] }
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
        "\t<cim:ErpReceivable rdf:ID=\"%s\">\n%s\t</cim:ErpReceivable>".format (id, export_fields)
    }
}

object ErpReceivable
extends
    Parseable[ErpReceivable]
{

    def parse (context: Context): ErpReceivable =
    {
        implicit val ctx: Context = context
        val ret = ErpReceivable (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Transaction for an Organisation receiving goods or services that may be used to indicate receipt of goods in conjunction with a purchase order.
 *
 * A receivable is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpReceiveDelivery
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpReceiveDelivery] }
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
        "\t<cim:ErpReceiveDelivery rdf:ID=\"%s\">\n%s\t</cim:ErpReceiveDelivery>".format (id, export_fields)
    }
}

object ErpReceiveDelivery
extends
    Parseable[ErpReceiveDelivery]
{

    def parse (context: Context): ErpReceiveDelivery =
    {
        implicit val ctx: Context = context
        val ret = ErpReceiveDelivery (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Information that describes a requested item and its attributes.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param code <em>undocumented</em>
 * @param cost Cost of material.
 * @param deliveryDate <em>undocumented</em>
 * @param quantity Quantity of item requisitioned.
 * @param status <em>undocumented</em>
 * @param ErpPOLineItem [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @param ErpQuoteLineItem [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param ErpRequisition [[ch.ninecode.model.ErpRequisition ErpRequisition]] <em>undocumented</em>
 * @param TypeAsset [[ch.ninecode.model.GenericAssetModelOrMaterial GenericAssetModelOrMaterial]] <em>undocumented</em>
 * @param TypeMaterial [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpReqLineItem
(
    override val sup: ErpIdentifiedObject,
    code: String,
    cost: Double,
    deliveryDate: String,
    quantity: Int,
    status: String,
    ErpPOLineItem: String,
    ErpQuoteLineItem: String,
    ErpRequisition: String,
    TypeAsset: String,
    TypeMaterial: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, 0, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpReqLineItem] }
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
        implicit val clz: String = ErpReqLineItem.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ErpReqLineItem.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpReqLineItem.fields (position), value)
        emitelem (0, code)
        emitelem (1, cost)
        emitelem (2, deliveryDate)
        emitelem (3, quantity)
        emitattr (4, status)
        emitattr (5, ErpPOLineItem)
        emitattr (6, ErpQuoteLineItem)
        emitattr (7, ErpRequisition)
        emitattr (8, TypeAsset)
        emitattr (9, TypeMaterial)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpReqLineItem rdf:ID=\"%s\">\n%s\t</cim:ErpReqLineItem>".format (id, export_fields)
    }
}

object ErpReqLineItem
extends
    Parseable[ErpReqLineItem]
{
    val fields: Array[String] = Array[String] (
        "code",
        "cost",
        "deliveryDate",
        "quantity",
        "status",
        "ErpPOLineItem",
        "ErpQuoteLineItem",
        "ErpRequisition",
        "TypeAsset",
        "TypeMaterial"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val cost: Fielder = parse_element (element (cls, fields(1)))
    val deliveryDate: Fielder = parse_element (element (cls, fields(2)))
    val quantity: Fielder = parse_element (element (cls, fields(3)))
    val status: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ErpPOLineItem: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ErpQuoteLineItem: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ErpRequisition: Fielder = parse_attribute (attribute (cls, fields(7)))
    val TypeAsset: Fielder = parse_attribute (attribute (cls, fields(8)))
    val TypeMaterial: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): ErpReqLineItem =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpReqLineItem (
            ErpIdentifiedObject.parse (context),
            mask (code (), 0),
            toDouble (mask (cost (), 1)),
            mask (deliveryDate (), 2),
            toInteger (mask (quantity (), 3)),
            mask (status (), 4),
            mask (ErpPOLineItem (), 5),
            mask (ErpQuoteLineItem (), 6),
            mask (ErpRequisition (), 7),
            mask (TypeAsset (), 8),
            mask (TypeMaterial (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpPOLineItem", "ErpPOLineItem", false),
        Relationship ("ErpQuoteLineItem", "ErpQuoteLineItem", false),
        Relationship ("ErpRequisition", "ErpRequisition", false),
        Relationship ("TypeAsset", "GenericAssetModelOrMaterial", false),
        Relationship ("TypeMaterial", "TypeMaterial", false)
    )
}

/**
 * General information that applies to a utility requisition that is a request for the purchase of goods or services.
 *
 * Typically, a requisition leads to the creation of a purchase order to a specific supplier.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpRequisition
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpRequisition] }
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
        "\t<cim:ErpRequisition rdf:ID=\"%s\">\n%s\t</cim:ErpRequisition>".format (id, export_fields)
    }
}

object ErpRequisition
extends
    Parseable[ErpRequisition]
{

    def parse (context: Context): ErpRequisition =
    {
        implicit val ctx: Context = context
        val ret = ErpRequisition (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * General purpose Sales Order is used for utility service orders, etc.
 *
 * As used by the OAG, the SalesOrder is a step beyond a PurchaseOrder in that the receiving entity of the order also communicates SalesInformoration about the Order along with the Order itself.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpSalesOrder
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpSalesOrder] }
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
        "\t<cim:ErpSalesOrder rdf:ID=\"%s\">\n%s\t</cim:ErpSalesOrder>".format (id, export_fields)
    }
}

object ErpSalesOrder
extends
    Parseable[ErpSalesOrder]
{

    def parse (context: Context): ErpSalesOrder =
    {
        implicit val ctx: Context = context
        val ret = ErpSalesOrder (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * For a utility, general information that describes physical locations of organizations or the location codes and their meanings.
 *
 * This enables ERP applications to ensure that the physical location identifiers are synchronized between the business applications.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param LandProperty [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpSiteLevelData
(
    override val sup: ErpIdentifiedObject,
    status: String,
    LandProperty: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpSiteLevelData] }
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
        implicit val clz: String = ErpSiteLevelData.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpSiteLevelData.fields (position), value)
        emitattr (0, status)
        emitattr (1, LandProperty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpSiteLevelData rdf:ID=\"%s\">\n%s\t</cim:ErpSiteLevelData>".format (id, export_fields)
    }
}

object ErpSiteLevelData
extends
    Parseable[ErpSiteLevelData]
{
    val fields: Array[String] = Array[String] (
        "status",
        "LandProperty"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LandProperty: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ErpSiteLevelData =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpSiteLevelData (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (LandProperty (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LandProperty", "LandProperty", false)
    )
}

/**
 * An individual entry on an ErpTimeSheet.
 *
 * @param sup [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param ErpTimeSheet [[ch.ninecode.model.ErpTimeSheet ErpTimeSheet]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpTimeEntry
(
    override val sup: ErpIdentifiedObject,
    status: String,
    ErpProjectAccounting: String,
    ErpTimeSheet: String
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
    def ErpIdentifiedObject: ErpIdentifiedObject = sup.asInstanceOf[ErpIdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ErpTimeEntry] }
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
        implicit val clz: String = ErpTimeEntry.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ErpTimeEntry.fields (position), value)
        emitattr (0, status)
        emitattr (1, ErpProjectAccounting)
        emitattr (2, ErpTimeSheet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ErpTimeEntry rdf:ID=\"%s\">\n%s\t</cim:ErpTimeEntry>".format (id, export_fields)
    }
}

object ErpTimeEntry
extends
    Parseable[ErpTimeEntry]
{
    val fields: Array[String] = Array[String] (
        "status",
        "ErpProjectAccounting",
        "ErpTimeSheet"
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ErpProjectAccounting: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ErpTimeSheet: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): ErpTimeEntry =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ErpTimeEntry (
            ErpIdentifiedObject.parse (context),
            mask (status (), 0),
            mask (ErpProjectAccounting (), 1),
            mask (ErpTimeSheet (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpProjectAccounting", "ErpProjectAccounting", false),
        Relationship ("ErpTimeSheet", "ErpTimeSheet", false)
    )
}

/**
 * Time sheet for employees and contractors.
 *
 * Note that ErpTimeSheet inherits the relationship to ErpPerson from Document.
 *
 * @param sup [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.

TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
"The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
case class ErpTimeSheet
(
    override val sup: ErpDocument
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
    def ErpDocument: ErpDocument = sup.asInstanceOf[ErpDocument]
    override def copy (): Row = { clone ().asInstanceOf[ErpTimeSheet] }
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
        "\t<cim:ErpTimeSheet rdf:ID=\"%s\">\n%s\t</cim:ErpTimeSheet>".format (id, export_fields)
    }
}

object ErpTimeSheet
extends
    Parseable[ErpTimeSheet]
{

    def parse (context: Context): ErpTimeSheet =
    {
        implicit val ctx: Context = context
        val ret = ErpTimeSheet (
            ErpDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfERPSupport
{
    def register: List[ClassInfo] =
    {
        List (
            ErpBOM.register,
            ErpBankAccount.register,
            ErpBomItemData.register,
            ErpChartOfAccounts.register,
            ErpCompetency.register,
            ErpDocument.register,
            ErpEngChangeOrder.register,
            ErpIdentifiedObject.register,
            ErpInventory.register,
            ErpInventoryCount.register,
            ErpInvoice.register,
            ErpInvoiceLineItem.register,
            ErpIssueInventory.register,
            ErpItemMaster.register,
            ErpJournal.register,
            ErpJournalEntry.register,
            ErpLedBudLineItem.register,
            ErpLedger.register,
            ErpLedgerBudget.register,
            ErpLedgerEntry.register,
            ErpPOLineItem.register,
            ErpPayable.register,
            ErpPayableLineItem.register,
            ErpPayment.register,
            ErpPersonnel.register,
            ErpProjectAccounting.register,
            ErpPurchaseOrder.register,
            ErpQuote.register,
            ErpQuoteLineItem.register,
            ErpRecDelvLineItem.register,
            ErpRecLineItem.register,
            ErpReceivable.register,
            ErpReceiveDelivery.register,
            ErpReqLineItem.register,
            ErpRequisition.register,
            ErpSalesOrder.register,
            ErpSiteLevelData.register,
            ErpTimeEntry.register,
            ErpTimeSheet.register
        )
    }
}