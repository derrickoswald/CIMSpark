package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Information that generally describes the Bill of Material Structure and its contents for a utility.
 *
 * This is used by ERP systems to transfer Bill of Material information between two business applications.
 *
 * @param sup Reference to the superclass object.
 * @param Design <em>undocumented</em>
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
        sup.export_fields +
        (if (null != Design) "\t\t<cim:ErpBOM.Design rdf:resource=\"#" + Design + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpBOM rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpBOM>"
    }
}

object ErpBOM
extends
    Parseable[ErpBOM]
{
    val Design = parse_attribute (attribute ("""ErpBOM.Design"""))
    def parse (context: Context): ErpBOM =
    {
        ErpBOM(
            ErpDocument.parse (context),
            Design (context)
        )
    }
}

/**
 * Relationship under a particular name, usually evidenced by a deposit against which withdrawals can be made.
 *
 * Types of bank accounts include: demand, time, custodial, joint, trustee, corporate, special, and regular accounts.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != bankABA) "\t\t<cim:ErpBankAccount.bankABA>" + bankABA + "</cim:ErpBankAccount.bankABA>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpBankAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpBankAccount>"
    }
}

object ErpBankAccount
extends
    Parseable[ErpBankAccount]
{
    val bankABA = parse_element (element ("""ErpBankAccount.bankABA"""))
    def parse (context: Context): ErpBankAccount =
    {
        ErpBankAccount(
            BankAccount.parse (context),
            bankABA (context)
        )
    }
}

/**
 * An individual item on a bill of materials.
 *
 * @param sup Reference to the superclass object.
 * @param DesignLocation <em>undocumented</em>
 * @param ErpBOM <em>undocumented</em>
 * @param TypeAsset <em>undocumented</em>
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
        sup.export_fields +
        (if (null != DesignLocation) "\t\t<cim:ErpBomItemData.DesignLocation rdf:resource=\"#" + DesignLocation + "\"/>\n" else "") +
        (if (null != ErpBOM) "\t\t<cim:ErpBomItemData.ErpBOM rdf:resource=\"#" + ErpBOM + "\"/>\n" else "") +
        (if (null != TypeAsset) "\t\t<cim:ErpBomItemData.TypeAsset rdf:resource=\"#" + TypeAsset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpBomItemData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpBomItemData>"
    }
}

object ErpBomItemData
extends
    Parseable[ErpBomItemData]
{
    val DesignLocation = parse_attribute (attribute ("""ErpBomItemData.DesignLocation"""))
    val ErpBOM = parse_attribute (attribute ("""ErpBomItemData.ErpBOM"""))
    val TypeAsset = parse_attribute (attribute ("""ErpBomItemData.TypeAsset"""))
    def parse (context: Context): ErpBomItemData =
    {
        ErpBomItemData(
            ErpIdentifiedObject.parse (context),
            DesignLocation (context),
            ErpBOM (context),
            TypeAsset (context)
        )
    }
}

/**
 * Accounting structure of a business.
 *
 * Each account represents a financial aspect of a business, such as its Accounts Payable, or the value of its inventory, or its office supply expenses.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpChartOfAccounts rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpChartOfAccounts>"
    }
}

object ErpChartOfAccounts
extends
    Parseable[ErpChartOfAccounts]
{
    def parse (context: Context): ErpChartOfAccounts =
    {
        ErpChartOfAccounts(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Information that describes aptitudes of a utility employee.
 *
 * Unlike Skills that an ErpPerson must be certified to perform before undertaking certain type of assignments (to be able to perfrom a Craft), ErpCompetency has more to do with typical Human Resource (HR) matters such as schooling, training, etc.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpCompetency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpCompetency>"
    }
}

object ErpCompetency
extends
    Parseable[ErpCompetency]
{
    def parse (context: Context): ErpCompetency =
    {
        ErpCompetency(
            ErpIdentifiedObject.parse (context)
        )
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpDocument rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpDocument>"
    }
}

object ErpDocument
extends
    Parseable[ErpDocument]
{
    def parse (context: Context): ErpDocument =
    {
        ErpDocument(
            Document.parse (context)
        )
    }
}

/**
 * General Utility Engineering Change Order information.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpEngChangeOrder rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpEngChangeOrder>"
    }
}

object ErpEngChangeOrder
extends
    Parseable[ErpEngChangeOrder]
{
    def parse (context: Context): ErpEngChangeOrder =
    {
        ErpEngChangeOrder(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpIdentifiedObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpIdentifiedObject>"
    }
}

object ErpIdentifiedObject
extends
    Parseable[ErpIdentifiedObject]
{
    def parse (context: Context): ErpIdentifiedObject =
    {
        ErpIdentifiedObject(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Utility inventory-related information about an item or part (and not for description of the item and its attributes).
 *
 * It is used by ERP applications to enable the synchronization of Inventory data that exists on separate Item Master databases. This data is not the master data that describes the attributes of the item such as dimensions, weight, or unit of measure - it describes the item as it exists at a specific location.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param Asset <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpInventory.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != Asset) "\t\t<cim:ErpInventory.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpInventory rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpInventory>"
    }
}

object ErpInventory
extends
    Parseable[ErpInventory]
{
    val status = parse_attribute (attribute ("""ErpInventory.status"""))
    val Asset = parse_attribute (attribute ("""ErpInventory.Asset"""))
    def parse (context: Context): ErpInventory =
    {
        ErpInventory(
            ErpIdentifiedObject.parse (context),
            status (context),
            Asset (context)
        )
    }
}

/**
 * This is related to Inventory physical counts organized by AssetModel.
 *
 * Note that a count of a type of asset can be accomplished by the association inherited by AssetModel (from Document) to Asset.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param AssetModel <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpInventoryCount.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != AssetModel) "\t\t<cim:ErpInventoryCount.AssetModel rdf:resource=\"#" + AssetModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpInventoryCount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpInventoryCount>"
    }
}

object ErpInventoryCount
extends
    Parseable[ErpInventoryCount]
{
    val status = parse_attribute (attribute ("""ErpInventoryCount.status"""))
    val AssetModel = parse_attribute (attribute ("""ErpInventoryCount.AssetModel"""))
    def parse (context: Context): ErpInventoryCount =
    {
        ErpInventoryCount(
            ErpIdentifiedObject.parse (context),
            status (context),
            AssetModel (context)
        )
    }
}

/**
 * A roll up of invoice line items.
 *
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
 *
 * @param sup Reference to the superclass object.
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
 * @param CustomerAccount <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:ErpInvoice.amount>" + amount + "</cim:ErpInvoice.amount>\n" +
        (if (null != billMediaKind) "\t\t<cim:ErpInvoice.billMediaKind rdf:resource=\"#" + billMediaKind + "\"/>\n" else "") +
        (if (null != dueDate) "\t\t<cim:ErpInvoice.dueDate>" + dueDate + "</cim:ErpInvoice.dueDate>\n" else "") +
        (if (null != kind) "\t\t<cim:ErpInvoice.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != mailedDate) "\t\t<cim:ErpInvoice.mailedDate>" + mailedDate + "</cim:ErpInvoice.mailedDate>\n" else "") +
        "\t\t<cim:ErpInvoice.proForma>" + proForma + "</cim:ErpInvoice.proForma>\n" +
        (if (null != referenceNumber) "\t\t<cim:ErpInvoice.referenceNumber>" + referenceNumber + "</cim:ErpInvoice.referenceNumber>\n" else "") +
        (if (null != transactionDateTime) "\t\t<cim:ErpInvoice.transactionDateTime>" + transactionDateTime + "</cim:ErpInvoice.transactionDateTime>\n" else "") +
        (if (null != transferType) "\t\t<cim:ErpInvoice.transferType>" + transferType + "</cim:ErpInvoice.transferType>\n" else "") +
        (if (null != CustomerAccount) "\t\t<cim:ErpInvoice.CustomerAccount rdf:resource=\"#" + CustomerAccount + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpInvoice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpInvoice>"
    }
}

object ErpInvoice
extends
    Parseable[ErpInvoice]
{
    val amount = parse_element (element ("""ErpInvoice.amount"""))
    val billMediaKind = parse_attribute (attribute ("""ErpInvoice.billMediaKind"""))
    val dueDate = parse_element (element ("""ErpInvoice.dueDate"""))
    val kind = parse_attribute (attribute ("""ErpInvoice.kind"""))
    val mailedDate = parse_element (element ("""ErpInvoice.mailedDate"""))
    val proForma = parse_element (element ("""ErpInvoice.proForma"""))
    val referenceNumber = parse_element (element ("""ErpInvoice.referenceNumber"""))
    val transactionDateTime = parse_element (element ("""ErpInvoice.transactionDateTime"""))
    val transferType = parse_element (element ("""ErpInvoice.transferType"""))
    val CustomerAccount = parse_attribute (attribute ("""ErpInvoice.CustomerAccount"""))
    def parse (context: Context): ErpInvoice =
    {
        ErpInvoice(
            ErpDocument.parse (context),
            toDouble (amount (context), context),
            billMediaKind (context),
            dueDate (context),
            kind (context),
            mailedDate (context),
            toBoolean (proForma (context), context),
            referenceNumber (context),
            transactionDateTime (context),
            transferType (context),
            CustomerAccount (context)
        )
    }
}

/**
 * An individual line item on an invoice.
 *
 * @param sup Reference to the superclass object.
 * @param billPeriod Bill period for the line item.
 * @param glAccount General Ledger account code, must be a valid combination.
 * @param glDateTime Date and time line item will be posted to the General Ledger.
 * @param kind Kind of line item.
 * @param lineAmount Amount due for this line item.
 * @param lineNumber Line item number on invoice statement.
 * @param lineVersion Version number of the bill run.
 * @param netAmount Net line item charge amount.
 * @param previousAmount Previous line item charge amount.
 * @param ContainerErpInvoiceLineItem <em>undocumented</em>
 * @param ErpInvoice <em>undocumented</em>
 * @param ErpPayableLineItem <em>undocumented</em>
 * @param ErpPayments <em>undocumented</em>
 * @param ErpQuoteLineItem <em>undocumented</em>
 * @param ErpRecDelvLineItem <em>undocumented</em>
 * @param ErpRecLineItem <em>undocumented</em>
 * @param UserAttributes <em>undocumented</em>
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
        sup.export_fields +
        (if (null != billPeriod) "\t\t<cim:ErpInvoiceLineItem.billPeriod rdf:resource=\"#" + billPeriod + "\"/>\n" else "") +
        (if (null != glAccount) "\t\t<cim:ErpInvoiceLineItem.glAccount>" + glAccount + "</cim:ErpInvoiceLineItem.glAccount>\n" else "") +
        (if (null != glDateTime) "\t\t<cim:ErpInvoiceLineItem.glDateTime>" + glDateTime + "</cim:ErpInvoiceLineItem.glDateTime>\n" else "") +
        (if (null != kind) "\t\t<cim:ErpInvoiceLineItem.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        "\t\t<cim:ErpInvoiceLineItem.lineAmount>" + lineAmount + "</cim:ErpInvoiceLineItem.lineAmount>\n" +
        (if (null != lineNumber) "\t\t<cim:ErpInvoiceLineItem.lineNumber>" + lineNumber + "</cim:ErpInvoiceLineItem.lineNumber>\n" else "") +
        (if (null != lineVersion) "\t\t<cim:ErpInvoiceLineItem.lineVersion>" + lineVersion + "</cim:ErpInvoiceLineItem.lineVersion>\n" else "") +
        "\t\t<cim:ErpInvoiceLineItem.netAmount>" + netAmount + "</cim:ErpInvoiceLineItem.netAmount>\n" +
        "\t\t<cim:ErpInvoiceLineItem.previousAmount>" + previousAmount + "</cim:ErpInvoiceLineItem.previousAmount>\n" +
        (if (null != ContainerErpInvoiceLineItem) "\t\t<cim:ErpInvoiceLineItem.ContainerErpInvoiceLineItem rdf:resource=\"#" + ContainerErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpInvoice) "\t\t<cim:ErpInvoiceLineItem.ErpInvoice rdf:resource=\"#" + ErpInvoice + "\"/>\n" else "") +
        (if (null != ErpPayableLineItem) "\t\t<cim:ErpInvoiceLineItem.ErpPayableLineItem rdf:resource=\"#" + ErpPayableLineItem + "\"/>\n" else "") +
        (if (null != ErpPayments) ErpPayments.map (x => "\t\t<cim:ErpInvoiceLineItem.ErpPayments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpQuoteLineItem) "\t\t<cim:ErpInvoiceLineItem.ErpQuoteLineItem rdf:resource=\"#" + ErpQuoteLineItem + "\"/>\n" else "") +
        (if (null != ErpRecDelvLineItem) "\t\t<cim:ErpInvoiceLineItem.ErpRecDelvLineItem rdf:resource=\"#" + ErpRecDelvLineItem + "\"/>\n" else "") +
        (if (null != ErpRecLineItem) "\t\t<cim:ErpInvoiceLineItem.ErpRecLineItem rdf:resource=\"#" + ErpRecLineItem + "\"/>\n" else "") +
        (if (null != UserAttributes) UserAttributes.map (x => "\t\t<cim:ErpInvoiceLineItem.UserAttributes rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ErpInvoiceLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpInvoiceLineItem>"
    }
}

object ErpInvoiceLineItem
extends
    Parseable[ErpInvoiceLineItem]
{
    val billPeriod = parse_attribute (attribute ("""ErpInvoiceLineItem.billPeriod"""))
    val glAccount = parse_element (element ("""ErpInvoiceLineItem.glAccount"""))
    val glDateTime = parse_element (element ("""ErpInvoiceLineItem.glDateTime"""))
    val kind = parse_attribute (attribute ("""ErpInvoiceLineItem.kind"""))
    val lineAmount = parse_element (element ("""ErpInvoiceLineItem.lineAmount"""))
    val lineNumber = parse_element (element ("""ErpInvoiceLineItem.lineNumber"""))
    val lineVersion = parse_element (element ("""ErpInvoiceLineItem.lineVersion"""))
    val netAmount = parse_element (element ("""ErpInvoiceLineItem.netAmount"""))
    val previousAmount = parse_element (element ("""ErpInvoiceLineItem.previousAmount"""))
    val ContainerErpInvoiceLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ContainerErpInvoiceLineItem"""))
    val ErpInvoice = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpInvoice"""))
    val ErpPayableLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpPayableLineItem"""))
    val ErpPayments = parse_attributes (attribute ("""ErpInvoiceLineItem.ErpPayments"""))
    val ErpQuoteLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpQuoteLineItem"""))
    val ErpRecDelvLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpRecDelvLineItem"""))
    val ErpRecLineItem = parse_attribute (attribute ("""ErpInvoiceLineItem.ErpRecLineItem"""))
    val UserAttributes = parse_attributes (attribute ("""ErpInvoiceLineItem.UserAttributes"""))
    def parse (context: Context): ErpInvoiceLineItem =
    {
        ErpInvoiceLineItem(
            ErpDocument.parse (context),
            billPeriod (context),
            glAccount (context),
            glDateTime (context),
            kind (context),
            toDouble (lineAmount (context), context),
            lineNumber (context),
            lineVersion (context),
            toDouble (netAmount (context), context),
            toDouble (previousAmount (context), context),
            ContainerErpInvoiceLineItem (context),
            ErpInvoice (context),
            ErpPayableLineItem (context),
            ErpPayments (context),
            ErpQuoteLineItem (context),
            ErpRecDelvLineItem (context),
            ErpRecLineItem (context),
            UserAttributes (context)
        )
    }
}

/**
 * Can be used to request an application to process an issue or request information about an issue.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param TypeAsset <em>undocumented</em>
 * @param TypeMaterial <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpIssueInventory.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != TypeAsset) "\t\t<cim:ErpIssueInventory.TypeAsset rdf:resource=\"#" + TypeAsset + "\"/>\n" else "") +
        (if (null != TypeMaterial) "\t\t<cim:ErpIssueInventory.TypeMaterial rdf:resource=\"#" + TypeMaterial + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpIssueInventory rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpIssueInventory>"
    }
}

object ErpIssueInventory
extends
    Parseable[ErpIssueInventory]
{
    val status = parse_attribute (attribute ("""ErpIssueInventory.status"""))
    val TypeAsset = parse_attribute (attribute ("""ErpIssueInventory.TypeAsset"""))
    val TypeMaterial = parse_attribute (attribute ("""ErpIssueInventory.TypeMaterial"""))
    def parse (context: Context): ErpIssueInventory =
    {
        ErpIssueInventory(
            ErpIdentifiedObject.parse (context),
            status (context),
            TypeAsset (context),
            TypeMaterial (context)
        )
    }
}

/**
 * Any unique purchased part for manufactured product tracked by ERP systems for a utility.
 *
 * Item, as used by the OAG, refers to the basic information about an item, including its attributes, cost, and locations. It does not include item quantities. Compare to the Inventory, which includes all quantities and other location-specific information.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param Asset <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpItemMaster.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != Asset) "\t\t<cim:ErpItemMaster.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpItemMaster rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpItemMaster>"
    }
}

object ErpItemMaster
extends
    Parseable[ErpItemMaster]
{
    val status = parse_attribute (attribute ("""ErpItemMaster.status"""))
    val Asset = parse_attribute (attribute ("""ErpItemMaster.Asset"""))
    def parse (context: Context): ErpItemMaster =
    {
        ErpItemMaster(
            ErpIdentifiedObject.parse (context),
            status (context),
            Asset (context)
        )
    }
}

/**
 * Book for recording accounting transactions as they occur.
 *
 * Transactions and adjustments are first recorded in a journal, which is like a diary of instructions, advising which account to be charged and by how much.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpJournal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpJournal>"
    }
}

object ErpJournal
extends
    Parseable[ErpJournal]
{
    def parse (context: Context): ErpJournal =
    {
        ErpJournal(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Details of an individual entry in a journal, which is to be posted to a ledger on the posting date.
 *
 * @param sup Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postingDateTime Date and time this entry is to be posted to the ledger.
 * @param sourceID The identifer of the source for this entry.
 * @param status <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpInvoiceLineItem <em>undocumented</em>
 * @param ErpJournal <em>undocumented</em>
 * @param ErpLedgerEntry <em>undocumented</em>
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
        sup.export_fields +
        (if (null != accountID) "\t\t<cim:ErpJournalEntry.accountID>" + accountID + "</cim:ErpJournalEntry.accountID>\n" else "") +
        "\t\t<cim:ErpJournalEntry.amount>" + amount + "</cim:ErpJournalEntry.amount>\n" +
        (if (null != postingDateTime) "\t\t<cim:ErpJournalEntry.postingDateTime>" + postingDateTime + "</cim:ErpJournalEntry.postingDateTime>\n" else "") +
        (if (null != sourceID) "\t\t<cim:ErpJournalEntry.sourceID>" + sourceID + "</cim:ErpJournalEntry.sourceID>\n" else "") +
        (if (null != status) "\t\t<cim:ErpJournalEntry.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != transactionDateTime) "\t\t<cim:ErpJournalEntry.transactionDateTime>" + transactionDateTime + "</cim:ErpJournalEntry.transactionDateTime>\n" else "") +
        (if (null != ErpInvoiceLineItem) "\t\t<cim:ErpJournalEntry.ErpInvoiceLineItem rdf:resource=\"#" + ErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpJournal) "\t\t<cim:ErpJournalEntry.ErpJournal rdf:resource=\"#" + ErpJournal + "\"/>\n" else "") +
        (if (null != ErpLedgerEntry) "\t\t<cim:ErpJournalEntry.ErpLedgerEntry rdf:resource=\"#" + ErpLedgerEntry + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpJournalEntry rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpJournalEntry>"
    }
}

object ErpJournalEntry
extends
    Parseable[ErpJournalEntry]
{
    val accountID = parse_element (element ("""ErpJournalEntry.accountID"""))
    val amount = parse_element (element ("""ErpJournalEntry.amount"""))
    val postingDateTime = parse_element (element ("""ErpJournalEntry.postingDateTime"""))
    val sourceID = parse_element (element ("""ErpJournalEntry.sourceID"""))
    val status = parse_attribute (attribute ("""ErpJournalEntry.status"""))
    val transactionDateTime = parse_element (element ("""ErpJournalEntry.transactionDateTime"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpJournalEntry.ErpInvoiceLineItem"""))
    val ErpJournal = parse_attribute (attribute ("""ErpJournalEntry.ErpJournal"""))
    val ErpLedgerEntry = parse_attribute (attribute ("""ErpJournalEntry.ErpLedgerEntry"""))
    def parse (context: Context): ErpJournalEntry =
    {
        ErpJournalEntry(
            ErpIdentifiedObject.parse (context),
            accountID (context),
            toDouble (amount (context), context),
            postingDateTime (context),
            sourceID (context),
            status (context),
            transactionDateTime (context),
            ErpInvoiceLineItem (context),
            ErpJournal (context),
            ErpLedgerEntry (context)
        )
    }
}

/**
 * Individual entry of a given Ledger Budget, typically containing information such as amount, accounting date, accounting period, and is associated with the applicable general ledger account.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpLedBudLineItem_attr <em>undocumented</em>
 * @param ErpLedgerBudget <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpLedBudLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpLedBudLineItem_attr) "\t\t<cim:ErpLedBudLineItem.ErpLedBudLineItem rdf:resource=\"#" + ErpLedBudLineItem_attr + "\"/>\n" else "") +
        (if (null != ErpLedgerBudget) "\t\t<cim:ErpLedBudLineItem.ErpLedgerBudget rdf:resource=\"#" + ErpLedgerBudget + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpLedBudLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpLedBudLineItem>"
    }
}

object ErpLedBudLineItem
extends
    Parseable[ErpLedBudLineItem]
{
    val status = parse_attribute (attribute ("""ErpLedBudLineItem.status"""))
    val ErpLedBudLineItem_attr = parse_attribute (attribute ("""ErpLedBudLineItem.ErpLedBudLineItem"""))
    val ErpLedgerBudget = parse_attribute (attribute ("""ErpLedBudLineItem.ErpLedgerBudget"""))
    def parse (context: Context): ErpLedBudLineItem =
    {
        ErpLedBudLineItem(
            ErpIdentifiedObject.parse (context),
            status (context),
            ErpLedBudLineItem_attr (context),
            ErpLedgerBudget (context)
        )
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpLedger rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpLedger>"
    }
}

object ErpLedger
extends
    Parseable[ErpLedger]
{
    def parse (context: Context): ErpLedger =
    {
        ErpLedger(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Information for utility Ledger Budgets.
 *
 * They support the transfer budget amounts between all possible source applications throughout an enterprise and a general ledger or budget application.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpLedgerBudget rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpLedgerBudget>"
    }
}

object ErpLedgerBudget
extends
    Parseable[ErpLedgerBudget]
{
    def parse (context: Context): ErpLedgerBudget =
    {
        ErpLedgerBudget(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Details of an individual entry in a ledger, which was posted from a journal on the posted date.
 *
 * @param sup Reference to the superclass object.
 * @param accountID Account identifier for this entry.
 * @param accountKind Kind of account for this entry.
 * @param amount The amount of the debit or credit for this account.
 * @param postedDateTime Date and time this entry was posted to the ledger.
 * @param status <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpJounalEntry <em>undocumented</em>
 * @param ErpLedger <em>undocumented</em>
 * @param ErpLedgerEntry_attr <em>undocumented</em>
 * @param UserAttributes <em>undocumented</em>
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
        sup.export_fields +
        (if (null != accountID) "\t\t<cim:ErpLedgerEntry.accountID>" + accountID + "</cim:ErpLedgerEntry.accountID>\n" else "") +
        (if (null != accountKind) "\t\t<cim:ErpLedgerEntry.accountKind rdf:resource=\"#" + accountKind + "\"/>\n" else "") +
        "\t\t<cim:ErpLedgerEntry.amount>" + amount + "</cim:ErpLedgerEntry.amount>\n" +
        (if (null != postedDateTime) "\t\t<cim:ErpLedgerEntry.postedDateTime>" + postedDateTime + "</cim:ErpLedgerEntry.postedDateTime>\n" else "") +
        (if (null != status) "\t\t<cim:ErpLedgerEntry.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != transactionDateTime) "\t\t<cim:ErpLedgerEntry.transactionDateTime>" + transactionDateTime + "</cim:ErpLedgerEntry.transactionDateTime>\n" else "") +
        (if (null != ErpJounalEntry) "\t\t<cim:ErpLedgerEntry.ErpJounalEntry rdf:resource=\"#" + ErpJounalEntry + "\"/>\n" else "") +
        (if (null != ErpLedger) "\t\t<cim:ErpLedgerEntry.ErpLedger rdf:resource=\"#" + ErpLedger + "\"/>\n" else "") +
        (if (null != ErpLedgerEntry_attr) "\t\t<cim:ErpLedgerEntry.ErpLedgerEntry rdf:resource=\"#" + ErpLedgerEntry_attr + "\"/>\n" else "") +
        (if (null != UserAttributes) UserAttributes.map (x => "\t\t<cim:ErpLedgerEntry.UserAttributes rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ErpLedgerEntry rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpLedgerEntry>"
    }
}

object ErpLedgerEntry
extends
    Parseable[ErpLedgerEntry]
{
    val accountID = parse_element (element ("""ErpLedgerEntry.accountID"""))
    val accountKind = parse_attribute (attribute ("""ErpLedgerEntry.accountKind"""))
    val amount = parse_element (element ("""ErpLedgerEntry.amount"""))
    val postedDateTime = parse_element (element ("""ErpLedgerEntry.postedDateTime"""))
    val status = parse_attribute (attribute ("""ErpLedgerEntry.status"""))
    val transactionDateTime = parse_element (element ("""ErpLedgerEntry.transactionDateTime"""))
    val ErpJounalEntry = parse_attribute (attribute ("""ErpLedgerEntry.ErpJounalEntry"""))
    val ErpLedger = parse_attribute (attribute ("""ErpLedgerEntry.ErpLedger"""))
    val ErpLedgerEntry_attr = parse_attribute (attribute ("""ErpLedgerEntry.ErpLedgerEntry"""))
    val UserAttributes = parse_attributes (attribute ("""ErpLedgerEntry.UserAttributes"""))
    def parse (context: Context): ErpLedgerEntry =
    {
        ErpLedgerEntry(
            ErpIdentifiedObject.parse (context),
            accountID (context),
            accountKind (context),
            toDouble (amount (context), context),
            postedDateTime (context),
            status (context),
            transactionDateTime (context),
            ErpJounalEntry (context),
            ErpLedger (context),
            ErpLedgerEntry_attr (context),
            UserAttributes (context)
        )
    }
}

/**
 * Of an ErpPurchaseOrder, this is an individually ordered item or product along with the quantity, price and other descriptive information.
 *
 * @param sup Reference to the superclass object.
 * @param AssetModelCatalogueItem <em>undocumented</em>
 * @param ErpPurchaseOrder <em>undocumented</em>
 * @param ErpRecDelLineItem <em>undocumented</em>
 * @param ErpReqLineItem <em>undocumented</em>
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
        sup.export_fields +
        (if (null != AssetModelCatalogueItem) "\t\t<cim:ErpPOLineItem.AssetModelCatalogueItem rdf:resource=\"#" + AssetModelCatalogueItem + "\"/>\n" else "") +
        (if (null != ErpPurchaseOrder) "\t\t<cim:ErpPOLineItem.ErpPurchaseOrder rdf:resource=\"#" + ErpPurchaseOrder + "\"/>\n" else "") +
        (if (null != ErpRecDelLineItem) "\t\t<cim:ErpPOLineItem.ErpRecDelLineItem rdf:resource=\"#" + ErpRecDelLineItem + "\"/>\n" else "") +
        (if (null != ErpReqLineItem) "\t\t<cim:ErpPOLineItem.ErpReqLineItem rdf:resource=\"#" + ErpReqLineItem + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpPOLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPOLineItem>"
    }
}

object ErpPOLineItem
extends
    Parseable[ErpPOLineItem]
{
    val AssetModelCatalogueItem = parse_attribute (attribute ("""ErpPOLineItem.AssetModelCatalogueItem"""))
    val ErpPurchaseOrder = parse_attribute (attribute ("""ErpPOLineItem.ErpPurchaseOrder"""))
    val ErpRecDelLineItem = parse_attribute (attribute ("""ErpPOLineItem.ErpRecDelLineItem"""))
    val ErpReqLineItem = parse_attribute (attribute ("""ErpPOLineItem.ErpReqLineItem"""))
    def parse (context: Context): ErpPOLineItem =
    {
        ErpPOLineItem(
            ErpDocument.parse (context),
            AssetModelCatalogueItem (context),
            ErpPurchaseOrder (context),
            ErpRecDelLineItem (context),
            ErpReqLineItem (context)
        )
    }
}

/**
 * A transaction that represents an invoice from a supplier.
 *
 * A payable (or voucher) is an open item, approved and ready for payment, in the Accounts Payable ledger.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpPayable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPayable>"
    }
}

object ErpPayable
extends
    Parseable[ErpPayable]
{
    def parse (context: Context): ErpPayable =
    {
        ErpPayable(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Of an ErpPayable, a line item references an ErpInvoiceLineitem or other source such as credit memos.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem <em>undocumented</em>
 * @param ErpJournalEntries <em>undocumented</em>
 * @param ErpPayable <em>undocumented</em>
 * @param ErpPayments <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpPayableLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpInvoiceLineItem) "\t\t<cim:ErpPayableLineItem.ErpInvoiceLineItem rdf:resource=\"#" + ErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpJournalEntries) ErpJournalEntries.map (x => "\t\t<cim:ErpPayableLineItem.ErpJournalEntries rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpPayable) "\t\t<cim:ErpPayableLineItem.ErpPayable rdf:resource=\"#" + ErpPayable + "\"/>\n" else "") +
        (if (null != ErpPayments) ErpPayments.map (x => "\t\t<cim:ErpPayableLineItem.ErpPayments rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ErpPayableLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPayableLineItem>"
    }
}

object ErpPayableLineItem
extends
    Parseable[ErpPayableLineItem]
{
    val status = parse_attribute (attribute ("""ErpPayableLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpPayableLineItem.ErpInvoiceLineItem"""))
    val ErpJournalEntries = parse_attributes (attribute ("""ErpPayableLineItem.ErpJournalEntries"""))
    val ErpPayable = parse_attribute (attribute ("""ErpPayableLineItem.ErpPayable"""))
    val ErpPayments = parse_attributes (attribute ("""ErpPayableLineItem.ErpPayments"""))
    def parse (context: Context): ErpPayableLineItem =
    {
        ErpPayableLineItem(
            ErpIdentifiedObject.parse (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpJournalEntries (context),
            ErpPayable (context),
            ErpPayments (context)
        )
    }
}

/**
 * Payment infromation and status for any individual line item of an ErpInvoice (e.g., when payment is from a customer).
 *
 * ErpPayable is also updated when payment is to a supplier and ErpReceivable is updated when payment is from a customer. Multiple payments can be made against a single line item and an individual payment can apply to more that one line item.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != termsPayment) "\t\t<cim:ErpPayment.termsPayment>" + termsPayment + "</cim:ErpPayment.termsPayment>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpPayment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPayment>"
    }
}

object ErpPayment
extends
    Parseable[ErpPayment]
{
    val termsPayment = parse_element (element ("""ErpPayment.termsPayment"""))
    def parse (context: Context): ErpPayment =
    {
        ErpPayment(
            ErpDocument.parse (context),
            termsPayment (context)
        )
    }
}

/**
 * Information that applies to the basic data about a utility person, used by ERP applications to transfer Personnel data for a worker.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpPersonnel.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpPersonnel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPersonnel>"
    }
}

object ErpPersonnel
extends
    Parseable[ErpPersonnel]
{
    val status = parse_attribute (attribute ("""ErpPersonnel.status"""))
    def parse (context: Context): ErpPersonnel =
    {
        ErpPersonnel(
            ErpIdentifiedObject.parse (context),
            status (context)
        )
    }
}

/**
 * Utility Project Accounting information, used by ERP applications to enable all relevant sub-systems that submit single sided transactions to transfer information with a Project Accounting Application.
 *
 * This would include, but not necessarily be limited to: Accounts Payable, Accounts Receivable, Budget, Order Management, Purchasing, Time and Labor, Travel and Expense.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpProjectAccounting rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpProjectAccounting>"
    }
}

object ErpProjectAccounting
extends
    Parseable[ErpProjectAccounting]
{
    def parse (context: Context): ErpProjectAccounting =
    {
        ErpProjectAccounting(
            ErpDocument.parse (context)
        )
    }
}

/**
 * A document that communicates an order to purchase goods from a buyer to a supplier.
 *
 * The PurchaseOrder carries information to and from the buyer and supplier. It is a legally binding document once both Parties agree to the contents and the specified terms and conditions of the order.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpPurchaseOrder rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpPurchaseOrder>"
    }
}

object ErpPurchaseOrder
extends
    Parseable[ErpPurchaseOrder]
{
    def parse (context: Context): ErpPurchaseOrder =
    {
        ErpPurchaseOrder(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Document describing the prices of goods or services provided by a supplier.
 *
 * It includes the terms of the purchase, delivery proposals, identification of goods or services ordered, as well as their quantities.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpQuote rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpQuote>"
    }
}

object ErpQuote
extends
    Parseable[ErpQuote]
{
    def parse (context: Context): ErpQuote =
    {
        ErpQuote(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Of an ErpQuote, the item or product quoted along with quantity, price and other descriptive information.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param AssetModelCatalogueItem <em>undocumented</em>
 * @param Design <em>undocumented</em>
 * @param ErpInvoiceLineItem Some utilities provide quotes to customer for services, where the customer accepts the quote by making a payment.
 *        An invoice is required for this to occur.
 * @param ErpQuote <em>undocumented</em>
 * @param ErpReqLineItem <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpQuoteLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != AssetModelCatalogueItem) "\t\t<cim:ErpQuoteLineItem.AssetModelCatalogueItem rdf:resource=\"#" + AssetModelCatalogueItem + "\"/>\n" else "") +
        (if (null != Design) "\t\t<cim:ErpQuoteLineItem.Design rdf:resource=\"#" + Design + "\"/>\n" else "") +
        (if (null != ErpInvoiceLineItem) "\t\t<cim:ErpQuoteLineItem.ErpInvoiceLineItem rdf:resource=\"#" + ErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpQuote) "\t\t<cim:ErpQuoteLineItem.ErpQuote rdf:resource=\"#" + ErpQuote + "\"/>\n" else "") +
        (if (null != ErpReqLineItem) "\t\t<cim:ErpQuoteLineItem.ErpReqLineItem rdf:resource=\"#" + ErpReqLineItem + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpQuoteLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpQuoteLineItem>"
    }
}

object ErpQuoteLineItem
extends
    Parseable[ErpQuoteLineItem]
{
    val status = parse_attribute (attribute ("""ErpQuoteLineItem.status"""))
    val AssetModelCatalogueItem = parse_attribute (attribute ("""ErpQuoteLineItem.AssetModelCatalogueItem"""))
    val Design = parse_attribute (attribute ("""ErpQuoteLineItem.Design"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpQuoteLineItem.ErpInvoiceLineItem"""))
    val ErpQuote = parse_attribute (attribute ("""ErpQuoteLineItem.ErpQuote"""))
    val ErpReqLineItem = parse_attribute (attribute ("""ErpQuoteLineItem.ErpReqLineItem"""))
    def parse (context: Context): ErpQuoteLineItem =
    {
        ErpQuoteLineItem(
            ErpIdentifiedObject.parse (context),
            status (context),
            AssetModelCatalogueItem (context),
            Design (context),
            ErpInvoiceLineItem (context),
            ErpQuote (context),
            ErpReqLineItem (context)
        )
    }
}

/**
 * Of an ErpReceiveDelivery, this is an individually received good or service by the Organisation receiving goods or services.
 *
 * It may be used to indicate receipt of goods in conjunction with a purchase order line item.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem <em>undocumented</em>
 * @param ErpPOLineItem <em>undocumented</em>
 * @param ErpReceiveDelivery <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpRecDelvLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpInvoiceLineItem) "\t\t<cim:ErpRecDelvLineItem.ErpInvoiceLineItem rdf:resource=\"#" + ErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpPOLineItem) "\t\t<cim:ErpRecDelvLineItem.ErpPOLineItem rdf:resource=\"#" + ErpPOLineItem + "\"/>\n" else "") +
        (if (null != ErpReceiveDelivery) "\t\t<cim:ErpRecDelvLineItem.ErpReceiveDelivery rdf:resource=\"#" + ErpReceiveDelivery + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpRecDelvLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpRecDelvLineItem>"
    }
}

object ErpRecDelvLineItem
extends
    Parseable[ErpRecDelvLineItem]
{
    val status = parse_attribute (attribute ("""ErpRecDelvLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpInvoiceLineItem"""))
    val ErpPOLineItem = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpPOLineItem"""))
    val ErpReceiveDelivery = parse_attribute (attribute ("""ErpRecDelvLineItem.ErpReceiveDelivery"""))
    def parse (context: Context): ErpRecDelvLineItem =
    {
        ErpRecDelvLineItem(
            ErpIdentifiedObject.parse (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpPOLineItem (context),
            ErpReceiveDelivery (context)
        )
    }
}

/**
 * Individual entry of an ErpReceivable, it is a particular transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpInvoiceLineItem <em>undocumented</em>
 * @param ErpJournalEntries <em>undocumented</em>
 * @param ErpPayments <em>undocumented</em>
 * @param ErpReceivable <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpRecLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpInvoiceLineItem) "\t\t<cim:ErpRecLineItem.ErpInvoiceLineItem rdf:resource=\"#" + ErpInvoiceLineItem + "\"/>\n" else "") +
        (if (null != ErpJournalEntries) ErpJournalEntries.map (x => "\t\t<cim:ErpRecLineItem.ErpJournalEntries rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpPayments) ErpPayments.map (x => "\t\t<cim:ErpRecLineItem.ErpPayments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ErpReceivable) "\t\t<cim:ErpRecLineItem.ErpReceivable rdf:resource=\"#" + ErpReceivable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpRecLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpRecLineItem>"
    }
}

object ErpRecLineItem
extends
    Parseable[ErpRecLineItem]
{
    val status = parse_attribute (attribute ("""ErpRecLineItem.status"""))
    val ErpInvoiceLineItem = parse_attribute (attribute ("""ErpRecLineItem.ErpInvoiceLineItem"""))
    val ErpJournalEntries = parse_attributes (attribute ("""ErpRecLineItem.ErpJournalEntries"""))
    val ErpPayments = parse_attributes (attribute ("""ErpRecLineItem.ErpPayments"""))
    val ErpReceivable = parse_attribute (attribute ("""ErpRecLineItem.ErpReceivable"""))
    def parse (context: Context): ErpRecLineItem =
    {
        ErpRecLineItem(
            ErpIdentifiedObject.parse (context),
            status (context),
            ErpInvoiceLineItem (context),
            ErpJournalEntries (context),
            ErpPayments (context),
            ErpReceivable (context)
        )
    }
}

/**
 * Transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * It is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpReceivable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpReceivable>"
    }
}

object ErpReceivable
extends
    Parseable[ErpReceivable]
{
    def parse (context: Context): ErpReceivable =
    {
        ErpReceivable(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Transaction for an Organisation receiving goods or services that may be used to indicate receipt of goods in conjunction with a purchase order.
 *
 * A receivable is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpReceiveDelivery rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpReceiveDelivery>"
    }
}

object ErpReceiveDelivery
extends
    Parseable[ErpReceiveDelivery]
{
    def parse (context: Context): ErpReceiveDelivery =
    {
        ErpReceiveDelivery(
            ErpDocument.parse (context)
        )
    }
}

/**
 * Information that describes a requested item and its attributes.
 *
 * @param sup Reference to the superclass object.
 * @param code <em>undocumented</em>
 * @param cost Cost of material.
 * @param deliveryDate <em>undocumented</em>
 * @param quantity Quantity of item requisitioned.
 * @param status <em>undocumented</em>
 * @param ErpPOLineItem <em>undocumented</em>
 * @param ErpQuoteLineItem <em>undocumented</em>
 * @param ErpRequisition <em>undocumented</em>
 * @param TypeAsset <em>undocumented</em>
 * @param TypeMaterial <em>undocumented</em>
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
        sup.export_fields +
        (if (null != code) "\t\t<cim:ErpReqLineItem.code>" + code + "</cim:ErpReqLineItem.code>\n" else "") +
        "\t\t<cim:ErpReqLineItem.cost>" + cost + "</cim:ErpReqLineItem.cost>\n" +
        (if (null != deliveryDate) "\t\t<cim:ErpReqLineItem.deliveryDate>" + deliveryDate + "</cim:ErpReqLineItem.deliveryDate>\n" else "") +
        "\t\t<cim:ErpReqLineItem.quantity>" + quantity + "</cim:ErpReqLineItem.quantity>\n" +
        (if (null != status) "\t\t<cim:ErpReqLineItem.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpPOLineItem) "\t\t<cim:ErpReqLineItem.ErpPOLineItem rdf:resource=\"#" + ErpPOLineItem + "\"/>\n" else "") +
        (if (null != ErpQuoteLineItem) "\t\t<cim:ErpReqLineItem.ErpQuoteLineItem rdf:resource=\"#" + ErpQuoteLineItem + "\"/>\n" else "") +
        (if (null != ErpRequisition) "\t\t<cim:ErpReqLineItem.ErpRequisition rdf:resource=\"#" + ErpRequisition + "\"/>\n" else "") +
        (if (null != TypeAsset) "\t\t<cim:ErpReqLineItem.TypeAsset rdf:resource=\"#" + TypeAsset + "\"/>\n" else "") +
        (if (null != TypeMaterial) "\t\t<cim:ErpReqLineItem.TypeMaterial rdf:resource=\"#" + TypeMaterial + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpReqLineItem rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpReqLineItem>"
    }
}

object ErpReqLineItem
extends
    Parseable[ErpReqLineItem]
{
    val code = parse_element (element ("""ErpReqLineItem.code"""))
    val cost = parse_element (element ("""ErpReqLineItem.cost"""))
    val deliveryDate = parse_element (element ("""ErpReqLineItem.deliveryDate"""))
    val quantity = parse_element (element ("""ErpReqLineItem.quantity"""))
    val status = parse_attribute (attribute ("""ErpReqLineItem.status"""))
    val ErpPOLineItem = parse_attribute (attribute ("""ErpReqLineItem.ErpPOLineItem"""))
    val ErpQuoteLineItem = parse_attribute (attribute ("""ErpReqLineItem.ErpQuoteLineItem"""))
    val ErpRequisition = parse_attribute (attribute ("""ErpReqLineItem.ErpRequisition"""))
    val TypeAsset = parse_attribute (attribute ("""ErpReqLineItem.TypeAsset"""))
    val TypeMaterial = parse_attribute (attribute ("""ErpReqLineItem.TypeMaterial"""))
    def parse (context: Context): ErpReqLineItem =
    {
        ErpReqLineItem(
            ErpIdentifiedObject.parse (context),
            code (context),
            toDouble (cost (context), context),
            deliveryDate (context),
            toInteger (quantity (context), context),
            status (context),
            ErpPOLineItem (context),
            ErpQuoteLineItem (context),
            ErpRequisition (context),
            TypeAsset (context),
            TypeMaterial (context)
        )
    }
}

/**
 * General information that applies to a utility requisition that is a request for the purchase of goods or services.
 *
 * Typically, a requisition leads to the creation of a purchase order to a specific supplier.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpRequisition rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpRequisition>"
    }
}

object ErpRequisition
extends
    Parseable[ErpRequisition]
{
    def parse (context: Context): ErpRequisition =
    {
        ErpRequisition(
            ErpDocument.parse (context)
        )
    }
}

/**
 * General purpose Sales Order is used for utility service orders, etc.
 *
 * As used by the OAG, the SalesOrder is a step beyond a PurchaseOrder in that the receiving entity of the order also communicates SalesInformoration about the Order along with the Order itself.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpSalesOrder rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpSalesOrder>"
    }
}

object ErpSalesOrder
extends
    Parseable[ErpSalesOrder]
{
    def parse (context: Context): ErpSalesOrder =
    {
        ErpSalesOrder(
            ErpDocument.parse (context)
        )
    }
}

/**
 * For a utility, general information that describes physical locations of organizations or the location codes and their meanings.
 *
 * This enables ERP applications to ensure that the physical location identifiers are synchronized between the business applications.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param LandProperty <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpSiteLevelData.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != LandProperty) "\t\t<cim:ErpSiteLevelData.LandProperty rdf:resource=\"#" + LandProperty + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpSiteLevelData rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpSiteLevelData>"
    }
}

object ErpSiteLevelData
extends
    Parseable[ErpSiteLevelData]
{
    val status = parse_attribute (attribute ("""ErpSiteLevelData.status"""))
    val LandProperty = parse_attribute (attribute ("""ErpSiteLevelData.LandProperty"""))
    def parse (context: Context): ErpSiteLevelData =
    {
        ErpSiteLevelData(
            ErpIdentifiedObject.parse (context),
            status (context),
            LandProperty (context)
        )
    }
}

/**
 * An individual entry on an ErpTimeSheet.
 *
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param ErpProjectAccounting <em>undocumented</em>
 * @param ErpTimeSheet <em>undocumented</em>
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
        sup.export_fields +
        (if (null != status) "\t\t<cim:ErpTimeEntry.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != ErpProjectAccounting) "\t\t<cim:ErpTimeEntry.ErpProjectAccounting rdf:resource=\"#" + ErpProjectAccounting + "\"/>\n" else "") +
        (if (null != ErpTimeSheet) "\t\t<cim:ErpTimeEntry.ErpTimeSheet rdf:resource=\"#" + ErpTimeSheet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ErpTimeEntry rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpTimeEntry>"
    }
}

object ErpTimeEntry
extends
    Parseable[ErpTimeEntry]
{
    val status = parse_attribute (attribute ("""ErpTimeEntry.status"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""ErpTimeEntry.ErpProjectAccounting"""))
    val ErpTimeSheet = parse_attribute (attribute ("""ErpTimeEntry.ErpTimeSheet"""))
    def parse (context: Context): ErpTimeEntry =
    {
        ErpTimeEntry(
            ErpIdentifiedObject.parse (context),
            status (context),
            ErpProjectAccounting (context),
            ErpTimeSheet (context)
        )
    }
}

/**
 * Time sheet for employees and contractors.
 *
 * Note that ErpTimeSheet inherits the relationship to ErpPerson from Document.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ErpTimeSheet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ErpTimeSheet>"
    }
}

object ErpTimeSheet
extends
    Parseable[ErpTimeSheet]
{
    def parse (context: Context): ErpTimeSheet =
    {
        ErpTimeSheet(
            ErpDocument.parse (context)
        )
    }
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