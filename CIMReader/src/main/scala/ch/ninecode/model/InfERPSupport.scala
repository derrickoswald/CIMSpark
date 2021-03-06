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
 * Information that generally describes the Bill of Material Structure and its contents for a utility.
 *
 * This is used by ERP systems to transfer Bill of Material information between two business applications.
 *
 * @param ErpDocument     [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param Design          [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpBomItemDatas [[ch.ninecode.model.ErpBomItemData ErpBomItemData]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpBOM
(
    ErpDocument: ErpDocument = null,
    Design: String = null,
    ErpBomItemDatas: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpBOM.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpBOM.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpBOM.fields(position), x))

        emitattr(0, Design)
        emitattrs(1, ErpBomItemDatas)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpBOM rdf:%s=\"%s\">\n%s\t</cim:ErpBOM>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpBOM
    extends
        CIMParseable[ErpBOM]
{
    override val fields: Array[String] = Array[String](
        "Design",
        "ErpBomItemDatas"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Design", "Design", "0..1", "0..*"),
        CIMRelationship("ErpBomItemDatas", "ErpBomItemData", "0..*", "1")
    )
    val Design: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpBomItemDatas: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpBOM =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpBOM(
            ErpDocument.parse(context),
            mask(Design(), 0),
            masks(ErpBomItemDatas(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpBOM] = ErpBOMSerializer
}

object ErpBOMSerializer extends CIMSerializer[ErpBOM]
{
    def write (kryo: Kryo, output: Output, obj: ErpBOM): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Design),
            () => writeList(obj.ErpBomItemDatas, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpBOM]): ErpBOM =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpBOM(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Relationship under a particular name, usually evidenced by a deposit against which withdrawals can be made.
 *
 * Types of bank accounts include: demand, time, custodial, joint, trustee, corporate, special, and regular accounts.
 * A statement of transactions during a fiscal period and the resulting balance is maintained on each account.
 * For Payment metering, the account is associated with Bank and Supplier, reflecting details of the bank account used for depositing revenue collected by TokenVendor. The name of the account holder should be specified in 'name' attribute.
 *
 * @param BankAccount [[ch.ninecode.model.BankAccount BankAccount]] Reference to the superclass object.
 * @param bankABA     Bank ABA.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpBankAccount
(
    BankAccount: BankAccount = null,
    bankABA: String = null
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
    override def sup: BankAccount = BankAccount

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpBankAccount.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpBankAccount.fields(position), value)

        emitelem(0, bankABA)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpBankAccount rdf:%s=\"%s\">\n%s\t</cim:ErpBankAccount>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpBankAccount
    extends
        CIMParseable[ErpBankAccount]
{
    override val fields: Array[String] = Array[String](
        "bankABA"
    )
    val bankABA: Fielder = parse_element(element(cls, fields(0)))

    def parse (context: CIMContext): ErpBankAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpBankAccount(
            BankAccount.parse(context),
            mask(bankABA(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpBankAccount] = ErpBankAccountSerializer
}

object ErpBankAccountSerializer extends CIMSerializer[ErpBankAccount]
{
    def write (kryo: Kryo, output: Output, obj: ErpBankAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.bankABA)
        )
        BankAccountSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpBankAccount]): ErpBankAccount =
    {
        val parent = BankAccountSerializer.read(kryo, input, classOf[BankAccount])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpBankAccount(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An individual item on a bill of materials.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param DesignLocation      [[ch.ninecode.model.DesignLocation DesignLocation]] <em>undocumented</em>
 * @param ErpBOM              [[ch.ninecode.model.ErpBOM ErpBOM]] <em>undocumented</em>
 * @param TypeAsset           [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpBomItemData
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    DesignLocation: String = null,
    ErpBOM: String = null,
    TypeAsset: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpBomItemData.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpBomItemData.fields(position), value)

        emitattr(0, DesignLocation)
        emitattr(1, ErpBOM)
        emitattr(2, TypeAsset)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpBomItemData rdf:%s=\"%s\">\n%s\t</cim:ErpBomItemData>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpBomItemData
    extends
        CIMParseable[ErpBomItemData]
{
    override val fields: Array[String] = Array[String](
        "DesignLocation",
        "ErpBOM",
        "TypeAsset"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DesignLocation", "DesignLocation", "0..1", "0..*"),
        CIMRelationship("ErpBOM", "ErpBOM", "1", "0..*"),
        CIMRelationship("TypeAsset", "CatalogAssetType", "0..1", "0..*")
    )
    val DesignLocation: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpBOM: Fielder = parse_attribute(attribute(cls, fields(1)))
    val TypeAsset: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): ErpBomItemData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpBomItemData(
            ErpIdentifiedObject.parse(context),
            mask(DesignLocation(), 0),
            mask(ErpBOM(), 1),
            mask(TypeAsset(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpBomItemData] = ErpBomItemDataSerializer
}

object ErpBomItemDataSerializer extends CIMSerializer[ErpBomItemData]
{
    def write (kryo: Kryo, output: Output, obj: ErpBomItemData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.DesignLocation),
            () => output.writeString(obj.ErpBOM),
            () => output.writeString(obj.TypeAsset)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpBomItemData]): ErpBomItemData =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpBomItemData(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Accounting structure of a business.
 *
 * Each account represents a financial aspect of a business, such as its Accounts Payable, or the value of its inventory, or its office supply expenses.
 *
 * @param ErpDocument [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpChartOfAccounts
(
    ErpDocument: ErpDocument = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ErpChartOfAccounts rdf:%s=\"%s\">\n%s\t</cim:ErpChartOfAccounts>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpChartOfAccounts
    extends
        CIMParseable[ErpChartOfAccounts]
{

    def parse (context: CIMContext): ErpChartOfAccounts =
    {
        val ret = ErpChartOfAccounts(
            ErpDocument.parse(context)
        )
        ret
    }

    def serializer: Serializer[ErpChartOfAccounts] = ErpChartOfAccountsSerializer
}

object ErpChartOfAccountsSerializer extends CIMSerializer[ErpChartOfAccounts]
{
    def write (kryo: Kryo, output: Output, obj: ErpChartOfAccounts): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpChartOfAccounts]): ErpChartOfAccounts =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpChartOfAccounts(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information that describes aptitudes of a utility employee.
 *
 * Unlike Skills that an ErpPerson must be certified to perform before undertaking certain type of assignments (to be able to perfrom a Craft), ErpCompetency has more to do with typical Human Resource (HR) matters such as schooling, training, etc.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param ErpPersons          [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpCompetency
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    ErpPersons: List[String] = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpCompetency.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpCompetency.fields(position), x))

        emitattrs(0, ErpPersons)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpCompetency rdf:%s=\"%s\">\n%s\t</cim:ErpCompetency>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpCompetency
    extends
        CIMParseable[ErpCompetency]
{
    override val fields: Array[String] = Array[String](
        "ErpPersons"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpPersons", "OldPerson", "0..*", "0..1")
    )
    val ErpPersons: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpCompetency =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpCompetency(
            ErpIdentifiedObject.parse(context),
            masks(ErpPersons(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpCompetency] = ErpCompetencySerializer
}

object ErpCompetencySerializer extends CIMSerializer[ErpCompetency]
{
    def write (kryo: Kryo, output: Output, obj: ErpCompetency): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpPersons, output)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpCompetency]): ErpCompetency =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpCompetency(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Shadow class for Document, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from Document.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpDocument
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ErpDocument rdf:%s=\"%s\">\n%s\t</cim:ErpDocument>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpDocument
    extends
        CIMParseable[ErpDocument]
{

    def parse (context: CIMContext): ErpDocument =
    {
        val ret = ErpDocument(
            Document.parse(context)
        )
        ret
    }

    def serializer: Serializer[ErpDocument] = ErpDocumentSerializer
}

object ErpDocumentSerializer extends CIMSerializer[ErpDocument]
{
    def write (kryo: Kryo, output: Output, obj: ErpDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpDocument]): ErpDocument =
    {
        val parent = DocumentSerializer.read(kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpDocument(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General Utility Engineering Change Order information.
 *
 * @param ErpDocument [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpEngChangeOrder
(
    ErpDocument: ErpDocument = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ErpEngChangeOrder rdf:%s=\"%s\">\n%s\t</cim:ErpEngChangeOrder>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpEngChangeOrder
    extends
        CIMParseable[ErpEngChangeOrder]
{

    def parse (context: CIMContext): ErpEngChangeOrder =
    {
        val ret = ErpEngChangeOrder(
            ErpDocument.parse(context)
        )
        ret
    }

    def serializer: Serializer[ErpEngChangeOrder] = ErpEngChangeOrderSerializer
}

object ErpEngChangeOrderSerializer extends CIMSerializer[ErpEngChangeOrder]
{
    def write (kryo: Kryo, output: Output, obj: ErpEngChangeOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpEngChangeOrder]): ErpEngChangeOrder =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpEngChangeOrder(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Shadow class for IdentifiedObject, to isolate subclassing from this package.
 *
 * If any subclass gets normative and needs inheritance, it will inherit directly from IdentifiedObject.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpIdentifiedObject
(
    IdentifiedObject: IdentifiedObject = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ErpIdentifiedObject rdf:%s=\"%s\">\n%s\t</cim:ErpIdentifiedObject>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpIdentifiedObject
    extends
        CIMParseable[ErpIdentifiedObject]
{

    def parse (context: CIMContext): ErpIdentifiedObject =
    {
        val ret = ErpIdentifiedObject(
            IdentifiedObject.parse(context)
        )
        ret
    }

    def serializer: Serializer[ErpIdentifiedObject] = ErpIdentifiedObjectSerializer
}

object ErpIdentifiedObjectSerializer extends CIMSerializer[ErpIdentifiedObject]
{
    def write (kryo: Kryo, output: Output, obj: ErpIdentifiedObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpIdentifiedObject]): ErpIdentifiedObject =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpIdentifiedObject(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Utility inventory-related information about an item or part (and not for description of the item and its attributes).
 *
 * It is used by ERP applications to enable the synchronization of Inventory data that exists on separate Item Master databases. This data is not the master data that describes the attributes of the item such as dimensions, weight, or unit of measure - it describes the item as it exists at a specific location.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param Asset               [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpInventory
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    Asset: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpInventory.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpInventory.fields(position), value)

        emitattr(0, status)
        emitattr(1, Asset)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpInventory rdf:%s=\"%s\">\n%s\t</cim:ErpInventory>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpInventory
    extends
        CIMParseable[ErpInventory]
{
    override val fields: Array[String] = Array[String](
        "status",
        "Asset"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Asset", "Asset", "0..1", "0..1")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val Asset: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpInventory =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpInventory(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(Asset(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpInventory] = ErpInventorySerializer
}

object ErpInventorySerializer extends CIMSerializer[ErpInventory]
{
    def write (kryo: Kryo, output: Output, obj: ErpInventory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.Asset)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpInventory]): ErpInventory =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpInventory(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is related to Inventory physical counts organized by AssetModel.
 *
 * Note that a count of a type of asset can be accomplished by the association inherited by AssetModel (from Document) to Asset.
 * It enables ERP applications to transfer an inventory count between ERP and the actual physical inventory location. This count may be a cycle count or a physical count.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpInventoryCount
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpInventoryCount.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpInventoryCount.fields(position), value)

        emitattr(0, status)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpInventoryCount rdf:%s=\"%s\">\n%s\t</cim:ErpInventoryCount>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpInventoryCount
    extends
        CIMParseable[ErpInventoryCount]
{
    override val fields: Array[String] = Array[String](
        "status"
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpInventoryCount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpInventoryCount(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpInventoryCount] = ErpInventoryCountSerializer
}

object ErpInventoryCountSerializer extends CIMSerializer[ErpInventoryCount]
{
    def write (kryo: Kryo, output: Output, obj: ErpInventoryCount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpInventoryCount]): ErpInventoryCount =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpInventoryCount(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A roll up of invoice line items.
 *
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
 *
 * @param ErpDocument         [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param amount              Total amount due on this invoice based on line items and applicable adjustments.
 * @param billMediaKind       Kind of media by which the CustomerBillingInfo was delivered.
 * @param dueDate             Calculated date upon which the Invoice amount is due.
 * @param kind                Kind of invoice (default is 'sales').
 * @param mailedDate          Date on which the customer billing statement/invoice was printed/mailed.
 * @param proForma            True if payment is to be paid by a Customer to accept a particular ErpQuote (with associated Design) and have work initiated, at which time an associated ErpInvoice should automatically be generated.
 *                            EprPayment.subjectStatus satisfies terms specificed in the ErpQuote.
 * @param referenceNumber     Number of an invoice to be reference by this invoice.
 * @param transactionDateTime Date and time when the invoice is issued.
 * @param transferType        Type of invoice transfer.
 * @param CustomerAccount     [[ch.ninecode.model.CustomerAccount CustomerAccount]] <em>undocumented</em>
 * @param ErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpInvoice
(
    ErpDocument: ErpDocument = null,
    amount: Double = 0.0,
    billMediaKind: String = null,
    dueDate: String = null,
    kind: String = null,
    mailedDate: String = null,
    proForma: Boolean = false,
    referenceNumber: String = null,
    transactionDateTime: String = null,
    transferType: String = null,
    CustomerAccount: String = null,
    ErpInvoiceLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpInvoice.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpInvoice.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpInvoice.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpInvoice.fields(position), x))

        emitelem(0, amount)
        emitattr(1, billMediaKind)
        emitelem(2, dueDate)
        emitattr(3, kind)
        emitelem(4, mailedDate)
        emitelem(5, proForma)
        emitelem(6, referenceNumber)
        emitelem(7, transactionDateTime)
        emitelem(8, transferType)
        emitattr(9, CustomerAccount)
        emitattrs(10, ErpInvoiceLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpInvoice rdf:%s=\"%s\">\n%s\t</cim:ErpInvoice>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpInvoice
    extends
        CIMParseable[ErpInvoice]
{
    override val fields: Array[String] = Array[String](
        "amount",
        "billMediaKind",
        "dueDate",
        "kind",
        "mailedDate",
        "proForma",
        "referenceNumber",
        "transactionDateTime",
        "transferType",
        "CustomerAccount",
        "ErpInvoiceLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CustomerAccount", "CustomerAccount", "0..1", "0..*"),
        CIMRelationship("ErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "1")
    )
    val amount: Fielder = parse_element(element(cls, fields(0)))
    val billMediaKind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val dueDate: Fielder = parse_element(element(cls, fields(2)))
    val kind: Fielder = parse_attribute(attribute(cls, fields(3)))
    val mailedDate: Fielder = parse_element(element(cls, fields(4)))
    val proForma: Fielder = parse_element(element(cls, fields(5)))
    val referenceNumber: Fielder = parse_element(element(cls, fields(6)))
    val transactionDateTime: Fielder = parse_element(element(cls, fields(7)))
    val transferType: Fielder = parse_element(element(cls, fields(8)))
    val CustomerAccount: Fielder = parse_attribute(attribute(cls, fields(9)))
    val ErpInvoiceLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(10)))

    def parse (context: CIMContext): ErpInvoice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpInvoice(
            ErpDocument.parse(context),
            toDouble(mask(amount(), 0)),
            mask(billMediaKind(), 1),
            mask(dueDate(), 2),
            mask(kind(), 3),
            mask(mailedDate(), 4),
            toBoolean(mask(proForma(), 5)),
            mask(referenceNumber(), 6),
            mask(transactionDateTime(), 7),
            mask(transferType(), 8),
            mask(CustomerAccount(), 9),
            masks(ErpInvoiceLineItems(), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpInvoice] = ErpInvoiceSerializer
}

object ErpInvoiceSerializer extends CIMSerializer[ErpInvoice]
{
    def write (kryo: Kryo, output: Output, obj: ErpInvoice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.amount),
            () => output.writeString(obj.billMediaKind),
            () => output.writeString(obj.dueDate),
            () => output.writeString(obj.kind),
            () => output.writeString(obj.mailedDate),
            () => output.writeBoolean(obj.proForma),
            () => output.writeString(obj.referenceNumber),
            () => output.writeString(obj.transactionDateTime),
            () => output.writeString(obj.transferType),
            () => output.writeString(obj.CustomerAccount),
            () => writeList(obj.ErpInvoiceLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpInvoice]): ErpInvoice =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpInvoice(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readBoolean else false,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An individual line item on an invoice.
 *
 * @param ErpDocument                  [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param billPeriod                   Bill period for the line item.
 * @param glAccount                    General Ledger account code, must be a valid combination.
 * @param glDateTime                   Date and time line item will be posted to the General Ledger.
 * @param kind                         Kind of line item.
 * @param lineAmount                   Amount due for this line item.
 * @param lineNumber                   Line item number on invoice statement.
 * @param lineVersion                  Version number of the bill run.
 * @param netAmount                    Net line item charge amount.
 * @param previousAmount               Previous line item charge amount.
 * @param ComponentErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ContainerErpInvoiceLineItem  [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param CustomerBillingInfos         [[ch.ninecode.model.CustomerBillingInfo CustomerBillingInfo]] Customer billing for services rendered.
 * @param ErpInvoice                   [[ch.ninecode.model.ErpInvoice ErpInvoice]] <em>undocumented</em>
 * @param ErpJournalEntries            [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpPayableLineItem           [[ch.ninecode.model.ErpPayableLineItem ErpPayableLineItem]] <em>undocumented</em>
 * @param ErpPayments                  [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @param ErpQuoteLineItem             [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param ErpRecDelvLineItem           [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param ErpRecLineItem               [[ch.ninecode.model.ErpRecLineItem ErpRecLineItem]] <em>undocumented</em>
 * @param UserAttributes               [[ch.ninecode.model.UserAttribute UserAttribute]] <em>undocumented</em>
 * @param WorkBillingInfos             [[ch.ninecode.model.WorkBillingInfo WorkBillingInfo]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpInvoiceLineItem
(
    ErpDocument: ErpDocument = null,
    billPeriod: String = null,
    glAccount: String = null,
    glDateTime: String = null,
    kind: String = null,
    lineAmount: Double = 0.0,
    lineNumber: String = null,
    lineVersion: String = null,
    netAmount: Double = 0.0,
    previousAmount: Double = 0.0,
    ComponentErpInvoiceLineItems: List[String] = null,
    ContainerErpInvoiceLineItem: String = null,
    CustomerBillingInfos: List[String] = null,
    ErpInvoice: String = null,
    ErpJournalEntries: List[String] = null,
    ErpPayableLineItem: String = null,
    ErpPayments: List[String] = null,
    ErpQuoteLineItem: String = null,
    ErpRecDelvLineItem: String = null,
    ErpRecLineItem: String = null,
    UserAttributes: List[String] = null,
    WorkBillingInfos: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpInvoiceLineItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpInvoiceLineItem.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpInvoiceLineItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpInvoiceLineItem.fields(position), x))

        emitattr(0, billPeriod)
        emitelem(1, glAccount)
        emitelem(2, glDateTime)
        emitattr(3, kind)
        emitelem(4, lineAmount)
        emitelem(5, lineNumber)
        emitelem(6, lineVersion)
        emitelem(7, netAmount)
        emitelem(8, previousAmount)
        emitattrs(9, ComponentErpInvoiceLineItems)
        emitattr(10, ContainerErpInvoiceLineItem)
        emitattrs(11, CustomerBillingInfos)
        emitattr(12, ErpInvoice)
        emitattrs(13, ErpJournalEntries)
        emitattr(14, ErpPayableLineItem)
        emitattrs(15, ErpPayments)
        emitattr(16, ErpQuoteLineItem)
        emitattr(17, ErpRecDelvLineItem)
        emitattr(18, ErpRecLineItem)
        emitattrs(19, UserAttributes)
        emitattrs(20, WorkBillingInfos)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpInvoiceLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpInvoiceLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpInvoiceLineItem
    extends
        CIMParseable[ErpInvoiceLineItem]
{
    override val fields: Array[String] = Array[String](
        "billPeriod",
        "glAccount",
        "glDateTime",
        "kind",
        "lineAmount",
        "lineNumber",
        "lineVersion",
        "netAmount",
        "previousAmount",
        "ComponentErpInvoiceLineItems",
        "ContainerErpInvoiceLineItem",
        "CustomerBillingInfos",
        "ErpInvoice",
        "ErpJournalEntries",
        "ErpPayableLineItem",
        "ErpPayments",
        "ErpQuoteLineItem",
        "ErpRecDelvLineItem",
        "ErpRecLineItem",
        "UserAttributes",
        "WorkBillingInfos"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ComponentErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "0..1"),
        CIMRelationship("ContainerErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..*"),
        CIMRelationship("CustomerBillingInfos", "CustomerBillingInfo", "0..*", "0..*"),
        CIMRelationship("ErpInvoice", "ErpInvoice", "1", "0..*"),
        CIMRelationship("ErpJournalEntries", "ErpJournalEntry", "0..*", "0..1"),
        CIMRelationship("ErpPayableLineItem", "ErpPayableLineItem", "0..1", "0..1"),
        CIMRelationship("ErpPayments", "ErpPayment", "0..*", "0..*"),
        CIMRelationship("ErpQuoteLineItem", "ErpQuoteLineItem", "0..1", "0..1"),
        CIMRelationship("ErpRecDelvLineItem", "ErpRecDelvLineItem", "0..1", "0..1"),
        CIMRelationship("ErpRecLineItem", "ErpRecLineItem", "0..1", "0..1"),
        CIMRelationship("UserAttributes", "UserAttribute", "0..*", "0..*"),
        CIMRelationship("WorkBillingInfos", "WorkBillingInfo", "0..*", "0..*")
    )
    val billPeriod: Fielder = parse_attribute(attribute(cls, fields(0)))
    val glAccount: Fielder = parse_element(element(cls, fields(1)))
    val glDateTime: Fielder = parse_element(element(cls, fields(2)))
    val kind: Fielder = parse_attribute(attribute(cls, fields(3)))
    val lineAmount: Fielder = parse_element(element(cls, fields(4)))
    val lineNumber: Fielder = parse_element(element(cls, fields(5)))
    val lineVersion: Fielder = parse_element(element(cls, fields(6)))
    val netAmount: Fielder = parse_element(element(cls, fields(7)))
    val previousAmount: Fielder = parse_element(element(cls, fields(8)))
    val ComponentErpInvoiceLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(9)))
    val ContainerErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(10)))
    val CustomerBillingInfos: FielderMultiple = parse_attributes(attribute(cls, fields(11)))
    val ErpInvoice: Fielder = parse_attribute(attribute(cls, fields(12)))
    val ErpJournalEntries: FielderMultiple = parse_attributes(attribute(cls, fields(13)))
    val ErpPayableLineItem: Fielder = parse_attribute(attribute(cls, fields(14)))
    val ErpPayments: FielderMultiple = parse_attributes(attribute(cls, fields(15)))
    val ErpQuoteLineItem: Fielder = parse_attribute(attribute(cls, fields(16)))
    val ErpRecDelvLineItem: Fielder = parse_attribute(attribute(cls, fields(17)))
    val ErpRecLineItem: Fielder = parse_attribute(attribute(cls, fields(18)))
    val UserAttributes: FielderMultiple = parse_attributes(attribute(cls, fields(19)))
    val WorkBillingInfos: FielderMultiple = parse_attributes(attribute(cls, fields(20)))

    def parse (context: CIMContext): ErpInvoiceLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpInvoiceLineItem(
            ErpDocument.parse(context),
            mask(billPeriod(), 0),
            mask(glAccount(), 1),
            mask(glDateTime(), 2),
            mask(kind(), 3),
            toDouble(mask(lineAmount(), 4)),
            mask(lineNumber(), 5),
            mask(lineVersion(), 6),
            toDouble(mask(netAmount(), 7)),
            toDouble(mask(previousAmount(), 8)),
            masks(ComponentErpInvoiceLineItems(), 9),
            mask(ContainerErpInvoiceLineItem(), 10),
            masks(CustomerBillingInfos(), 11),
            mask(ErpInvoice(), 12),
            masks(ErpJournalEntries(), 13),
            mask(ErpPayableLineItem(), 14),
            masks(ErpPayments(), 15),
            mask(ErpQuoteLineItem(), 16),
            mask(ErpRecDelvLineItem(), 17),
            mask(ErpRecLineItem(), 18),
            masks(UserAttributes(), 19),
            masks(WorkBillingInfos(), 20)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpInvoiceLineItem] = ErpInvoiceLineItemSerializer
}

object ErpInvoiceLineItemSerializer extends CIMSerializer[ErpInvoiceLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpInvoiceLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.billPeriod),
            () => output.writeString(obj.glAccount),
            () => output.writeString(obj.glDateTime),
            () => output.writeString(obj.kind),
            () => output.writeDouble(obj.lineAmount),
            () => output.writeString(obj.lineNumber),
            () => output.writeString(obj.lineVersion),
            () => output.writeDouble(obj.netAmount),
            () => output.writeDouble(obj.previousAmount),
            () => writeList(obj.ComponentErpInvoiceLineItems, output),
            () => output.writeString(obj.ContainerErpInvoiceLineItem),
            () => writeList(obj.CustomerBillingInfos, output),
            () => output.writeString(obj.ErpInvoice),
            () => writeList(obj.ErpJournalEntries, output),
            () => output.writeString(obj.ErpPayableLineItem),
            () => writeList(obj.ErpPayments, output),
            () => output.writeString(obj.ErpQuoteLineItem),
            () => output.writeString(obj.ErpRecDelvLineItem),
            () => output.writeString(obj.ErpRecLineItem),
            () => writeList(obj.UserAttributes, output),
            () => writeList(obj.WorkBillingInfos, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpInvoiceLineItem]): ErpInvoiceLineItem =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpInvoiceLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) readList(input) else null,
            if (isSet(10)) input.readString else null,
            if (isSet(11)) readList(input) else null,
            if (isSet(12)) input.readString else null,
            if (isSet(13)) readList(input) else null,
            if (isSet(14)) input.readString else null,
            if (isSet(15)) readList(input) else null,
            if (isSet(16)) input.readString else null,
            if (isSet(17)) input.readString else null,
            if (isSet(18)) input.readString else null,
            if (isSet(19)) readList(input) else null,
            if (isSet(20)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Can be used to request an application to process an issue or request information about an issue.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param TypeAsset           [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @param TypeMaterial        [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpIssueInventory
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    TypeAsset: String = null,
    TypeMaterial: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpIssueInventory.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpIssueInventory.fields(position), value)

        emitattr(0, status)
        emitattr(1, TypeAsset)
        emitattr(2, TypeMaterial)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpIssueInventory rdf:%s=\"%s\">\n%s\t</cim:ErpIssueInventory>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpIssueInventory
    extends
        CIMParseable[ErpIssueInventory]
{
    override val fields: Array[String] = Array[String](
        "status",
        "TypeAsset",
        "TypeMaterial"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("TypeAsset", "CatalogAssetType", "0..1", "0..*"),
        CIMRelationship("TypeMaterial", "TypeMaterial", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val TypeAsset: Fielder = parse_attribute(attribute(cls, fields(1)))
    val TypeMaterial: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): ErpIssueInventory =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpIssueInventory(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(TypeAsset(), 1),
            mask(TypeMaterial(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpIssueInventory] = ErpIssueInventorySerializer
}

object ErpIssueInventorySerializer extends CIMSerializer[ErpIssueInventory]
{
    def write (kryo: Kryo, output: Output, obj: ErpIssueInventory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.TypeAsset),
            () => output.writeString(obj.TypeMaterial)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpIssueInventory]): ErpIssueInventory =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpIssueInventory(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Any unique purchased part for manufactured product tracked by ERP systems for a utility.
 *
 * Item, as used by the OAG, refers to the basic information about an item, including its attributes, cost, and locations. It does not include item quantities. Compare to the Inventory, which includes all quantities and other location-specific information.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param Asset               [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpItemMaster
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    Asset: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpItemMaster.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpItemMaster.fields(position), value)

        emitattr(0, status)
        emitattr(1, Asset)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpItemMaster rdf:%s=\"%s\">\n%s\t</cim:ErpItemMaster>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpItemMaster
    extends
        CIMParseable[ErpItemMaster]
{
    override val fields: Array[String] = Array[String](
        "status",
        "Asset"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Asset", "Asset", "0..1", "0..1")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val Asset: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpItemMaster =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpItemMaster(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(Asset(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpItemMaster] = ErpItemMasterSerializer
}

object ErpItemMasterSerializer extends CIMSerializer[ErpItemMaster]
{
    def write (kryo: Kryo, output: Output, obj: ErpItemMaster): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.Asset)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpItemMaster]): ErpItemMaster =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpItemMaster(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Book for recording accounting transactions as they occur.
 *
 * Transactions and adjustments are first recorded in a journal, which is like a diary of instructions, advising which account to be charged and by how much.
 * A journal represents a change in the balances of a business's financial accounts. Many tasks or transactions throughout an enterprise will result in the creation of a journal. Some examples are creating a customer invoice, paying a vendor, transferring inventory, or paying employees.
 *
 * @param ErpDocument       [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpJournalEntries [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpJournal
(
    ErpDocument: ErpDocument = null,
    ErpJournalEntries: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpJournal.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpJournal.fields(position), x))

        emitattrs(0, ErpJournalEntries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpJournal rdf:%s=\"%s\">\n%s\t</cim:ErpJournal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpJournal
    extends
        CIMParseable[ErpJournal]
{
    override val fields: Array[String] = Array[String](
        "ErpJournalEntries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpJournalEntries", "ErpJournalEntry", "0..*", "1")
    )
    val ErpJournalEntries: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpJournal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpJournal(
            ErpDocument.parse(context),
            masks(ErpJournalEntries(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpJournal] = ErpJournalSerializer
}

object ErpJournalSerializer extends CIMSerializer[ErpJournal]
{
    def write (kryo: Kryo, output: Output, obj: ErpJournal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpJournalEntries, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpJournal]): ErpJournal =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpJournal(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details of an individual entry in a journal, which is to be posted to a ledger on the posting date.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param accountID           Account identifier for this entry.
 * @param amount              The amount of the debit or credit for this account.
 * @param postingDateTime     Date and time this entry is to be posted to the ledger.
 * @param sourceID            The identifer of the source for this entry.
 * @param status              <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param CostTypes           [[ch.ninecode.model.CostType CostType]] <em>undocumented</em>
 * @param ErpInvoiceLineItem  [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournal          [[ch.ninecode.model.ErpJournal ErpJournal]] <em>undocumented</em>
 * @param ErpLedgerEntry      [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @param ErpPayableLineItems [[ch.ninecode.model.ErpPayableLineItem ErpPayableLineItem]] <em>undocumented</em>
 * @param ErpRecLineItems     [[ch.ninecode.model.ErpRecLineItem ErpRecLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpJournalEntry
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    accountID: String = null,
    amount: Double = 0.0,
    postingDateTime: String = null,
    sourceID: String = null,
    status: String = null,
    transactionDateTime: String = null,
    CostTypes: List[String] = null,
    ErpInvoiceLineItem: String = null,
    ErpJournal: String = null,
    ErpLedgerEntry: String = null,
    ErpPayableLineItems: List[String] = null,
    ErpRecLineItems: List[String] = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpJournalEntry.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpJournalEntry.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpJournalEntry.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpJournalEntry.fields(position), x))

        emitelem(0, accountID)
        emitelem(1, amount)
        emitelem(2, postingDateTime)
        emitelem(3, sourceID)
        emitattr(4, status)
        emitelem(5, transactionDateTime)
        emitattrs(6, CostTypes)
        emitattr(7, ErpInvoiceLineItem)
        emitattr(8, ErpJournal)
        emitattr(9, ErpLedgerEntry)
        emitattrs(10, ErpPayableLineItems)
        emitattrs(11, ErpRecLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpJournalEntry rdf:%s=\"%s\">\n%s\t</cim:ErpJournalEntry>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpJournalEntry
    extends
        CIMParseable[ErpJournalEntry]
{
    override val fields: Array[String] = Array[String](
        "accountID",
        "amount",
        "postingDateTime",
        "sourceID",
        "status",
        "transactionDateTime",
        "CostTypes",
        "ErpInvoiceLineItem",
        "ErpJournal",
        "ErpLedgerEntry",
        "ErpPayableLineItems",
        "ErpRecLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CostTypes", "CostType", "0..*", "0..*"),
        CIMRelationship("ErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..*"),
        CIMRelationship("ErpJournal", "ErpJournal", "1", "0..*"),
        CIMRelationship("ErpLedgerEntry", "ErpLedgerEntry", "0..1", "0..1"),
        CIMRelationship("ErpPayableLineItems", "ErpPayableLineItem", "0..*", "0..*"),
        CIMRelationship("ErpRecLineItems", "ErpRecLineItem", "0..*", "0..*")
    )
    val accountID: Fielder = parse_element(element(cls, fields(0)))
    val amount: Fielder = parse_element(element(cls, fields(1)))
    val postingDateTime: Fielder = parse_element(element(cls, fields(2)))
    val sourceID: Fielder = parse_element(element(cls, fields(3)))
    val status: Fielder = parse_attribute(attribute(cls, fields(4)))
    val transactionDateTime: Fielder = parse_element(element(cls, fields(5)))
    val CostTypes: FielderMultiple = parse_attributes(attribute(cls, fields(6)))
    val ErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(7)))
    val ErpJournal: Fielder = parse_attribute(attribute(cls, fields(8)))
    val ErpLedgerEntry: Fielder = parse_attribute(attribute(cls, fields(9)))
    val ErpPayableLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(10)))
    val ErpRecLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(11)))

    def parse (context: CIMContext): ErpJournalEntry =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpJournalEntry(
            ErpIdentifiedObject.parse(context),
            mask(accountID(), 0),
            toDouble(mask(amount(), 1)),
            mask(postingDateTime(), 2),
            mask(sourceID(), 3),
            mask(status(), 4),
            mask(transactionDateTime(), 5),
            masks(CostTypes(), 6),
            mask(ErpInvoiceLineItem(), 7),
            mask(ErpJournal(), 8),
            mask(ErpLedgerEntry(), 9),
            masks(ErpPayableLineItems(), 10),
            masks(ErpRecLineItems(), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpJournalEntry] = ErpJournalEntrySerializer
}

object ErpJournalEntrySerializer extends CIMSerializer[ErpJournalEntry]
{
    def write (kryo: Kryo, output: Output, obj: ErpJournalEntry): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.accountID),
            () => output.writeDouble(obj.amount),
            () => output.writeString(obj.postingDateTime),
            () => output.writeString(obj.sourceID),
            () => output.writeString(obj.status),
            () => output.writeString(obj.transactionDateTime),
            () => writeList(obj.CostTypes, output),
            () => output.writeString(obj.ErpInvoiceLineItem),
            () => output.writeString(obj.ErpJournal),
            () => output.writeString(obj.ErpLedgerEntry),
            () => writeList(obj.ErpPayableLineItems, output),
            () => writeList(obj.ErpRecLineItems, output)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpJournalEntry]): ErpJournalEntry =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpJournalEntry(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) readList(input) else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) readList(input) else null,
            if (isSet(11)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Individual entry of a given Ledger Budget, typically containing information such as amount, accounting date, accounting period, and is associated with the applicable general ledger account.
 *
 * @param ErpIdentifiedObject    [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status                 <em>undocumented</em>
 * @param ErpLedBudLineItem_attr [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @param ErpLedgerBudget        [[ch.ninecode.model.ErpLedgerBudget ErpLedgerBudget]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpLedBudLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    ErpLedBudLineItem_attr: String = null,
    ErpLedgerBudget: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpLedBudLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpLedBudLineItem.fields(position), value)

        emitattr(0, status)
        emitattr(1, ErpLedBudLineItem_attr)
        emitattr(2, ErpLedgerBudget)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpLedBudLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpLedBudLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpLedBudLineItem
    extends
        CIMParseable[ErpLedBudLineItem]
{
    override val fields: Array[String] = Array[String](
        "status",
        "ErpLedBudLineItem",
        "ErpLedgerBudget"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpLedBudLineItem_attr", "ErpLedgerEntry", "0..1", "0..1"),
        CIMRelationship("ErpLedgerBudget", "ErpLedgerBudget", "1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpLedBudLineItem_attr: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ErpLedgerBudget: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): ErpLedBudLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpLedBudLineItem(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(ErpLedBudLineItem_attr(), 1),
            mask(ErpLedgerBudget(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpLedBudLineItem] = ErpLedBudLineItemSerializer
}

object ErpLedBudLineItemSerializer extends CIMSerializer[ErpLedBudLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpLedBudLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.ErpLedBudLineItem_attr),
            () => output.writeString(obj.ErpLedgerBudget)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpLedBudLineItem]): ErpLedBudLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpLedBudLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger Actual represents actual amounts by account within ledger within company or business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param ErpDocument      [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpLedgerEntries [[ch.ninecode.model.ErpLedgerEntry ErpLedgerEntry]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpLedger
(
    ErpDocument: ErpDocument = null,
    ErpLedgerEntries: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpLedger.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpLedger.fields(position), x))

        emitattrs(0, ErpLedgerEntries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpLedger rdf:%s=\"%s\">\n%s\t</cim:ErpLedger>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpLedger
    extends
        CIMParseable[ErpLedger]
{
    override val fields: Array[String] = Array[String](
        "ErpLedgerEntries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpLedgerEntries", "ErpLedgerEntry", "0..*", "1")
    )
    val ErpLedgerEntries: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpLedger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpLedger(
            ErpDocument.parse(context),
            masks(ErpLedgerEntries(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpLedger] = ErpLedgerSerializer
}

object ErpLedgerSerializer extends CIMSerializer[ErpLedger]
{
    def write (kryo: Kryo, output: Output, obj: ErpLedger): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpLedgerEntries, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpLedger]): ErpLedger =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpLedger(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information for utility Ledger Budgets.
 *
 * They support the transfer budget amounts between all possible source applications throughout an enterprise and a general ledger or budget application.
 *
 * @param ErpDocument        [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpLedBudLineItems [[ch.ninecode.model.ErpLedBudLineItem ErpLedBudLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpLedgerBudget
(
    ErpDocument: ErpDocument = null,
    ErpLedBudLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpLedgerBudget.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpLedgerBudget.fields(position), x))

        emitattrs(0, ErpLedBudLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpLedgerBudget rdf:%s=\"%s\">\n%s\t</cim:ErpLedgerBudget>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpLedgerBudget
    extends
        CIMParseable[ErpLedgerBudget]
{
    override val fields: Array[String] = Array[String](
        "ErpLedBudLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpLedBudLineItems", "ErpLedBudLineItem", "0..*", "1")
    )
    val ErpLedBudLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpLedgerBudget =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpLedgerBudget(
            ErpDocument.parse(context),
            masks(ErpLedBudLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpLedgerBudget] = ErpLedgerBudgetSerializer
}

object ErpLedgerBudgetSerializer extends CIMSerializer[ErpLedgerBudget]
{
    def write (kryo: Kryo, output: Output, obj: ErpLedgerBudget): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpLedBudLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpLedgerBudget]): ErpLedgerBudget =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpLedgerBudget(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details of an individual entry in a ledger, which was posted from a journal on the posted date.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param accountID           Account identifier for this entry.
 * @param accountKind         Kind of account for this entry.
 * @param amount              The amount of the debit or credit for this account.
 * @param postedDateTime      Date and time this entry was posted to the ledger.
 * @param status              <em>undocumented</em>
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param ErpJounalEntry      [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpLedger           [[ch.ninecode.model.ErpLedger ErpLedger]] <em>undocumented</em>
 * @param ErpLedgerEntry_attr [[ch.ninecode.model.ErpLedBudLineItem ErpLedBudLineItem]] <em>undocumented</em>
 * @param UserAttributes      [[ch.ninecode.model.UserAttribute UserAttribute]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpLedgerEntry
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    accountID: String = null,
    accountKind: String = null,
    amount: Double = 0.0,
    postedDateTime: String = null,
    status: String = null,
    transactionDateTime: String = null,
    ErpJounalEntry: String = null,
    ErpLedger: String = null,
    ErpLedgerEntry_attr: String = null,
    UserAttributes: List[String] = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpLedgerEntry.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpLedgerEntry.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpLedgerEntry.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpLedgerEntry.fields(position), x))

        emitelem(0, accountID)
        emitattr(1, accountKind)
        emitelem(2, amount)
        emitelem(3, postedDateTime)
        emitattr(4, status)
        emitelem(5, transactionDateTime)
        emitattr(6, ErpJounalEntry)
        emitattr(7, ErpLedger)
        emitattr(8, ErpLedgerEntry_attr)
        emitattrs(9, UserAttributes)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpLedgerEntry rdf:%s=\"%s\">\n%s\t</cim:ErpLedgerEntry>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpLedgerEntry
    extends
        CIMParseable[ErpLedgerEntry]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpJounalEntry", "ErpJournalEntry", "0..1", "0..1"),
        CIMRelationship("ErpLedger", "ErpLedger", "1", "0..*"),
        CIMRelationship("ErpLedgerEntry_attr", "ErpLedBudLineItem", "0..1", "0..1"),
        CIMRelationship("UserAttributes", "UserAttribute", "0..*", "0..*")
    )
    val accountID: Fielder = parse_element(element(cls, fields(0)))
    val accountKind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val amount: Fielder = parse_element(element(cls, fields(2)))
    val postedDateTime: Fielder = parse_element(element(cls, fields(3)))
    val status: Fielder = parse_attribute(attribute(cls, fields(4)))
    val transactionDateTime: Fielder = parse_element(element(cls, fields(5)))
    val ErpJounalEntry: Fielder = parse_attribute(attribute(cls, fields(6)))
    val ErpLedger: Fielder = parse_attribute(attribute(cls, fields(7)))
    val ErpLedgerEntry_attr: Fielder = parse_attribute(attribute(cls, fields(8)))
    val UserAttributes: FielderMultiple = parse_attributes(attribute(cls, fields(9)))

    def parse (context: CIMContext): ErpLedgerEntry =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpLedgerEntry(
            ErpIdentifiedObject.parse(context),
            mask(accountID(), 0),
            mask(accountKind(), 1),
            toDouble(mask(amount(), 2)),
            mask(postedDateTime(), 3),
            mask(status(), 4),
            mask(transactionDateTime(), 5),
            mask(ErpJounalEntry(), 6),
            mask(ErpLedger(), 7),
            mask(ErpLedgerEntry_attr(), 8),
            masks(UserAttributes(), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpLedgerEntry] = ErpLedgerEntrySerializer
}

object ErpLedgerEntrySerializer extends CIMSerializer[ErpLedgerEntry]
{
    def write (kryo: Kryo, output: Output, obj: ErpLedgerEntry): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.accountID),
            () => output.writeString(obj.accountKind),
            () => output.writeDouble(obj.amount),
            () => output.writeString(obj.postedDateTime),
            () => output.writeString(obj.status),
            () => output.writeString(obj.transactionDateTime),
            () => output.writeString(obj.ErpJounalEntry),
            () => output.writeString(obj.ErpLedger),
            () => output.writeString(obj.ErpLedgerEntry_attr),
            () => writeList(obj.UserAttributes, output)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpLedgerEntry]): ErpLedgerEntry =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpLedgerEntry(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Of an ErpPurchaseOrder, this is an individually ordered item or product along with the quantity, price and other descriptive information.
 *
 * @param ErpDocument             [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param AssetModelCatalogueItem [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param ErpPurchaseOrder        [[ch.ninecode.model.ErpPurchaseOrder ErpPurchaseOrder]] <em>undocumented</em>
 * @param ErpRecDelLineItem       [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param ErpReqLineItem          [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPOLineItem
(
    ErpDocument: ErpDocument = null,
    AssetModelCatalogueItem: String = null,
    ErpPurchaseOrder: String = null,
    ErpRecDelLineItem: String = null,
    ErpReqLineItem: String = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPOLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpPOLineItem.fields(position), value)

        emitattr(0, AssetModelCatalogueItem)
        emitattr(1, ErpPurchaseOrder)
        emitattr(2, ErpRecDelLineItem)
        emitattr(3, ErpReqLineItem)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPOLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpPOLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPOLineItem
    extends
        CIMParseable[ErpPOLineItem]
{
    override val fields: Array[String] = Array[String](
        "AssetModelCatalogueItem",
        "ErpPurchaseOrder",
        "ErpRecDelLineItem",
        "ErpReqLineItem"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AssetModelCatalogueItem", "AssetModelCatalogueItem", "0..1", "0..*"),
        CIMRelationship("ErpPurchaseOrder", "ErpPurchaseOrder", "1", "0..*"),
        CIMRelationship("ErpRecDelLineItem", "ErpRecDelvLineItem", "0..1", "0..1"),
        CIMRelationship("ErpReqLineItem", "ErpReqLineItem", "0..1", "0..1")
    )
    val AssetModelCatalogueItem: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpPurchaseOrder: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ErpRecDelLineItem: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ErpReqLineItem: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): ErpPOLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPOLineItem(
            ErpDocument.parse(context),
            mask(AssetModelCatalogueItem(), 0),
            mask(ErpPurchaseOrder(), 1),
            mask(ErpRecDelLineItem(), 2),
            mask(ErpReqLineItem(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPOLineItem] = ErpPOLineItemSerializer
}

object ErpPOLineItemSerializer extends CIMSerializer[ErpPOLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpPOLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.AssetModelCatalogueItem),
            () => output.writeString(obj.ErpPurchaseOrder),
            () => output.writeString(obj.ErpRecDelLineItem),
            () => output.writeString(obj.ErpReqLineItem)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPOLineItem]): ErpPOLineItem =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPOLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A transaction that represents an invoice from a supplier.
 *
 * A payable (or voucher) is an open item, approved and ready for payment, in the Accounts Payable ledger.
 *
 * @param ErpDocument         [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ContractorItems     [[ch.ninecode.model.ContractorItem ContractorItem]] <em>undocumented</em>
 * @param ErpPayableLineItems [[ch.ninecode.model.ErpPayableLineItem ErpPayableLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPayable
(
    ErpDocument: ErpDocument = null,
    ContractorItems: List[String] = null,
    ErpPayableLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPayable.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpPayable.fields(position), x))

        emitattrs(0, ContractorItems)
        emitattrs(1, ErpPayableLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPayable rdf:%s=\"%s\">\n%s\t</cim:ErpPayable>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPayable
    extends
        CIMParseable[ErpPayable]
{
    override val fields: Array[String] = Array[String](
        "ContractorItems",
        "ErpPayableLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ContractorItems", "ContractorItem", "0..*", "0..*"),
        CIMRelationship("ErpPayableLineItems", "ErpPayableLineItem", "0..*", "1")
    )
    val ContractorItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val ErpPayableLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpPayable =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPayable(
            ErpDocument.parse(context),
            masks(ContractorItems(), 0),
            masks(ErpPayableLineItems(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPayable] = ErpPayableSerializer
}

object ErpPayableSerializer extends CIMSerializer[ErpPayable]
{
    def write (kryo: Kryo, output: Output, obj: ErpPayable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ContractorItems, output),
            () => writeList(obj.ErpPayableLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPayable]): ErpPayable =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPayable(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Of an ErpPayable, a line item references an ErpInvoiceLineitem or other source such as credit memos.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param ErpInvoiceLineItem  [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournalEntries   [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpPayable          [[ch.ninecode.model.ErpPayable ErpPayable]] <em>undocumented</em>
 * @param ErpPayments         [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPayableLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    ErpInvoiceLineItem: String = null,
    ErpJournalEntries: List[String] = null,
    ErpPayable: String = null,
    ErpPayments: List[String] = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPayableLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpPayableLineItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpPayableLineItem.fields(position), x))

        emitattr(0, status)
        emitattr(1, ErpInvoiceLineItem)
        emitattrs(2, ErpJournalEntries)
        emitattr(3, ErpPayable)
        emitattrs(4, ErpPayments)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPayableLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpPayableLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPayableLineItem
    extends
        CIMParseable[ErpPayableLineItem]
{
    override val fields: Array[String] = Array[String](
        "status",
        "ErpInvoiceLineItem",
        "ErpJournalEntries",
        "ErpPayable",
        "ErpPayments"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..1"),
        CIMRelationship("ErpJournalEntries", "ErpJournalEntry", "0..*", "0..*"),
        CIMRelationship("ErpPayable", "ErpPayable", "1", "0..*"),
        CIMRelationship("ErpPayments", "ErpPayment", "0..*", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ErpJournalEntries: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val ErpPayable: Fielder = parse_attribute(attribute(cls, fields(3)))
    val ErpPayments: FielderMultiple = parse_attributes(attribute(cls, fields(4)))

    def parse (context: CIMContext): ErpPayableLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPayableLineItem(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(ErpInvoiceLineItem(), 1),
            masks(ErpJournalEntries(), 2),
            mask(ErpPayable(), 3),
            masks(ErpPayments(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPayableLineItem] = ErpPayableLineItemSerializer
}

object ErpPayableLineItemSerializer extends CIMSerializer[ErpPayableLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpPayableLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.ErpInvoiceLineItem),
            () => writeList(obj.ErpJournalEntries, output),
            () => output.writeString(obj.ErpPayable),
            () => writeList(obj.ErpPayments, output)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPayableLineItem]): ErpPayableLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPayableLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Payment infromation and status for any individual line item of an ErpInvoice (e.g., when payment is from a customer).
 *
 * ErpPayable is also updated when payment is to a supplier and ErpReceivable is updated when payment is from a customer. Multiple payments can be made against a single line item and an individual payment can apply to more that one line item.
 *
 * @param ErpDocument         [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param termsPayment        Payment terms (e.g., net 30).
 * @param ErpInvoiceLineItems [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpPayableLineItems [[ch.ninecode.model.ErpPayableLineItem ErpPayableLineItem]] <em>undocumented</em>
 * @param ErpRecLineItems     [[ch.ninecode.model.ErpRecLineItem ErpRecLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPayment
(
    ErpDocument: ErpDocument = null,
    termsPayment: String = null,
    ErpInvoiceLineItems: List[String] = null,
    ErpPayableLineItems: List[String] = null,
    ErpRecLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPayment.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpPayment.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpPayment.fields(position), x))

        emitelem(0, termsPayment)
        emitattrs(1, ErpInvoiceLineItems)
        emitattrs(2, ErpPayableLineItems)
        emitattrs(3, ErpRecLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPayment rdf:%s=\"%s\">\n%s\t</cim:ErpPayment>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPayment
    extends
        CIMParseable[ErpPayment]
{
    override val fields: Array[String] = Array[String](
        "termsPayment",
        "ErpInvoiceLineItems",
        "ErpPayableLineItems",
        "ErpRecLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpInvoiceLineItems", "ErpInvoiceLineItem", "0..*", "0..*"),
        CIMRelationship("ErpPayableLineItems", "ErpPayableLineItem", "0..*", "0..*"),
        CIMRelationship("ErpRecLineItems", "ErpRecLineItem", "0..*", "0..*")
    )
    val termsPayment: Fielder = parse_element(element(cls, fields(0)))
    val ErpInvoiceLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ErpPayableLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val ErpRecLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): ErpPayment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPayment(
            ErpDocument.parse(context),
            mask(termsPayment(), 0),
            masks(ErpInvoiceLineItems(), 1),
            masks(ErpPayableLineItems(), 2),
            masks(ErpRecLineItems(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPayment] = ErpPaymentSerializer
}

object ErpPaymentSerializer extends CIMSerializer[ErpPayment]
{
    def write (kryo: Kryo, output: Output, obj: ErpPayment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.termsPayment),
            () => writeList(obj.ErpInvoiceLineItems, output),
            () => writeList(obj.ErpPayableLineItems, output),
            () => writeList(obj.ErpRecLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPayment]): ErpPayment =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPayment(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information that applies to the basic data about a utility person, used by ERP applications to transfer Personnel data for a worker.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param ErpPersons          [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPersonnel
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    ErpPersons: List[String] = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPersonnel.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpPersonnel.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpPersonnel.fields(position), x))

        emitattr(0, status)
        emitattrs(1, ErpPersons)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPersonnel rdf:%s=\"%s\">\n%s\t</cim:ErpPersonnel>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPersonnel
    extends
        CIMParseable[ErpPersonnel]
{
    override val fields: Array[String] = Array[String](
        "status",
        "ErpPersons"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpPersons", "OldPerson", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpPersons: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpPersonnel =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPersonnel(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            masks(ErpPersons(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPersonnel] = ErpPersonnelSerializer
}

object ErpPersonnelSerializer extends CIMSerializer[ErpPersonnel]
{
    def write (kryo: Kryo, output: Output, obj: ErpPersonnel): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => writeList(obj.ErpPersons, output)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPersonnel]): ErpPersonnel =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPersonnel(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Utility Project Accounting information, used by ERP applications to enable all relevant sub-systems that submit single sided transactions to transfer information with a Project Accounting Application.
 *
 * This would include, but not necessarily be limited to: Accounts Payable, Accounts Receivable, Budget, Order Management, Purchasing, Time and Labor, Travel and Expense.
 *
 * @param ErpDocument     [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpTimeEntries  [[ch.ninecode.model.ErpTimeEntry ErpTimeEntry]] <em>undocumented</em>
 * @param Projects        [[ch.ninecode.model.Project Project]] <em>undocumented</em>
 * @param WorkCostDetails [[ch.ninecode.model.WorkCostDetail WorkCostDetail]] <em>undocumented</em>
 * @param Works           [[ch.ninecode.model.Work Work]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpProjectAccounting
(
    ErpDocument: ErpDocument = null,
    ErpTimeEntries: List[String] = null,
    Projects: List[String] = null,
    WorkCostDetails: List[String] = null,
    Works: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpProjectAccounting.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpProjectAccounting.fields(position), x))

        emitattrs(0, ErpTimeEntries)
        emitattrs(1, Projects)
        emitattrs(2, WorkCostDetails)
        emitattrs(3, Works)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpProjectAccounting rdf:%s=\"%s\">\n%s\t</cim:ErpProjectAccounting>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpProjectAccounting
    extends
        CIMParseable[ErpProjectAccounting]
{
    override val fields: Array[String] = Array[String](
        "ErpTimeEntries",
        "Projects",
        "WorkCostDetails",
        "Works"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpTimeEntries", "ErpTimeEntry", "0..*", "0..1"),
        CIMRelationship("Projects", "Project", "0..*", "1"),
        CIMRelationship("WorkCostDetails", "WorkCostDetail", "0..*", "1"),
        CIMRelationship("Works", "Work", "0..*", "0..1")
    )
    val ErpTimeEntries: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val Projects: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val WorkCostDetails: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val Works: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): ErpProjectAccounting =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpProjectAccounting(
            ErpDocument.parse(context),
            masks(ErpTimeEntries(), 0),
            masks(Projects(), 1),
            masks(WorkCostDetails(), 2),
            masks(Works(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpProjectAccounting] = ErpProjectAccountingSerializer
}

object ErpProjectAccountingSerializer extends CIMSerializer[ErpProjectAccounting]
{
    def write (kryo: Kryo, output: Output, obj: ErpProjectAccounting): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpTimeEntries, output),
            () => writeList(obj.Projects, output),
            () => writeList(obj.WorkCostDetails, output),
            () => writeList(obj.Works, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpProjectAccounting]): ErpProjectAccounting =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpProjectAccounting(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A document that communicates an order to purchase goods from a buyer to a supplier.
 *
 * The PurchaseOrder carries information to and from the buyer and supplier. It is a legally binding document once both Parties agree to the contents and the specified terms and conditions of the order.
 *
 * @param ErpDocument    [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpPOLineItems [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpPurchaseOrder
(
    ErpDocument: ErpDocument = null,
    ErpPOLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpPurchaseOrder.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpPurchaseOrder.fields(position), x))

        emitattrs(0, ErpPOLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpPurchaseOrder rdf:%s=\"%s\">\n%s\t</cim:ErpPurchaseOrder>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpPurchaseOrder
    extends
        CIMParseable[ErpPurchaseOrder]
{
    override val fields: Array[String] = Array[String](
        "ErpPOLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpPOLineItems", "ErpPOLineItem", "0..*", "1")
    )
    val ErpPOLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpPurchaseOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpPurchaseOrder(
            ErpDocument.parse(context),
            masks(ErpPOLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpPurchaseOrder] = ErpPurchaseOrderSerializer
}

object ErpPurchaseOrderSerializer extends CIMSerializer[ErpPurchaseOrder]
{
    def write (kryo: Kryo, output: Output, obj: ErpPurchaseOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpPOLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpPurchaseOrder]): ErpPurchaseOrder =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpPurchaseOrder(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document describing the prices of goods or services provided by a supplier.
 *
 * It includes the terms of the purchase, delivery proposals, identification of goods or services ordered, as well as their quantities.
 *
 * @param ErpDocument       [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpQuoteLineItems [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpQuote
(
    ErpDocument: ErpDocument = null,
    ErpQuoteLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpQuote.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpQuote.fields(position), x))

        emitattrs(0, ErpQuoteLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpQuote rdf:%s=\"%s\">\n%s\t</cim:ErpQuote>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpQuote
    extends
        CIMParseable[ErpQuote]
{
    override val fields: Array[String] = Array[String](
        "ErpQuoteLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpQuoteLineItems", "ErpQuoteLineItem", "0..*", "1")
    )
    val ErpQuoteLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpQuote =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpQuote(
            ErpDocument.parse(context),
            masks(ErpQuoteLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpQuote] = ErpQuoteSerializer
}

object ErpQuoteSerializer extends CIMSerializer[ErpQuote]
{
    def write (kryo: Kryo, output: Output, obj: ErpQuote): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpQuoteLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpQuote]): ErpQuote =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpQuote(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Of an ErpQuote, the item or product quoted along with quantity, price and other descriptive information.
 *
 * @param ErpIdentifiedObject     [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status                  <em>undocumented</em>
 * @param AssetModelCatalogueItem [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param Design                  [[ch.ninecode.model.Design Design]] <em>undocumented</em>
 * @param ErpInvoiceLineItem      [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] Some utilities provide quotes to customer for services, where the customer accepts the quote by making a payment.
 *                                An invoice is required for this to occur.
 * @param ErpQuote                [[ch.ninecode.model.ErpQuote ErpQuote]] <em>undocumented</em>
 * @param ErpReqLineItem          [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpQuoteLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    AssetModelCatalogueItem: String = null,
    Design: String = null,
    ErpInvoiceLineItem: String = null,
    ErpQuote: String = null,
    ErpReqLineItem: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpQuoteLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpQuoteLineItem.fields(position), value)

        emitattr(0, status)
        emitattr(1, AssetModelCatalogueItem)
        emitattr(2, Design)
        emitattr(3, ErpInvoiceLineItem)
        emitattr(4, ErpQuote)
        emitattr(5, ErpReqLineItem)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpQuoteLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpQuoteLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpQuoteLineItem
    extends
        CIMParseable[ErpQuoteLineItem]
{
    override val fields: Array[String] = Array[String](
        "status",
        "AssetModelCatalogueItem",
        "Design",
        "ErpInvoiceLineItem",
        "ErpQuote",
        "ErpReqLineItem"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AssetModelCatalogueItem", "AssetModelCatalogueItem", "0..1", "0..*"),
        CIMRelationship("Design", "Design", "0..1", "0..1"),
        CIMRelationship("ErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..1"),
        CIMRelationship("ErpQuote", "ErpQuote", "1", "0..*"),
        CIMRelationship("ErpReqLineItem", "ErpReqLineItem", "0..1", "0..1")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val AssetModelCatalogueItem: Fielder = parse_attribute(attribute(cls, fields(1)))
    val Design: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(3)))
    val ErpQuote: Fielder = parse_attribute(attribute(cls, fields(4)))
    val ErpReqLineItem: Fielder = parse_attribute(attribute(cls, fields(5)))

    def parse (context: CIMContext): ErpQuoteLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpQuoteLineItem(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(AssetModelCatalogueItem(), 1),
            mask(Design(), 2),
            mask(ErpInvoiceLineItem(), 3),
            mask(ErpQuote(), 4),
            mask(ErpReqLineItem(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpQuoteLineItem] = ErpQuoteLineItemSerializer
}

object ErpQuoteLineItemSerializer extends CIMSerializer[ErpQuoteLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpQuoteLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.AssetModelCatalogueItem),
            () => output.writeString(obj.Design),
            () => output.writeString(obj.ErpInvoiceLineItem),
            () => output.writeString(obj.ErpQuote),
            () => output.writeString(obj.ErpReqLineItem)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpQuoteLineItem]): ErpQuoteLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpQuoteLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Of an ErpReceiveDelivery, this is an individually received good or service by the Organisation receiving goods or services.
 *
 * It may be used to indicate receipt of goods in conjunction with a purchase order line item.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param Assets              [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param ErpInvoiceLineItem  [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpPOLineItem       [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @param ErpReceiveDelivery  [[ch.ninecode.model.ErpReceiveDelivery ErpReceiveDelivery]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpRecDelvLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    Assets: List[String] = null,
    ErpInvoiceLineItem: String = null,
    ErpPOLineItem: String = null,
    ErpReceiveDelivery: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpRecDelvLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpRecDelvLineItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpRecDelvLineItem.fields(position), x))

        emitattr(0, status)
        emitattrs(1, Assets)
        emitattr(2, ErpInvoiceLineItem)
        emitattr(3, ErpPOLineItem)
        emitattr(4, ErpReceiveDelivery)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpRecDelvLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpRecDelvLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpRecDelvLineItem
    extends
        CIMParseable[ErpRecDelvLineItem]
{
    override val fields: Array[String] = Array[String](
        "status",
        "Assets",
        "ErpInvoiceLineItem",
        "ErpPOLineItem",
        "ErpReceiveDelivery"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship("ErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..1"),
        CIMRelationship("ErpPOLineItem", "ErpPOLineItem", "0..1", "0..1"),
        CIMRelationship("ErpReceiveDelivery", "ErpReceiveDelivery", "1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val Assets: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ErpPOLineItem: Fielder = parse_attribute(attribute(cls, fields(3)))
    val ErpReceiveDelivery: Fielder = parse_attribute(attribute(cls, fields(4)))

    def parse (context: CIMContext): ErpRecDelvLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpRecDelvLineItem(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            masks(Assets(), 1),
            mask(ErpInvoiceLineItem(), 2),
            mask(ErpPOLineItem(), 3),
            mask(ErpReceiveDelivery(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpRecDelvLineItem] = ErpRecDelvLineItemSerializer
}

object ErpRecDelvLineItemSerializer extends CIMSerializer[ErpRecDelvLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpRecDelvLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => writeList(obj.Assets, output),
            () => output.writeString(obj.ErpInvoiceLineItem),
            () => output.writeString(obj.ErpPOLineItem),
            () => output.writeString(obj.ErpReceiveDelivery)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpRecDelvLineItem]): ErpRecDelvLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpRecDelvLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Individual entry of an ErpReceivable, it is a particular transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param ErpInvoiceLineItem  [[ch.ninecode.model.ErpInvoiceLineItem ErpInvoiceLineItem]] <em>undocumented</em>
 * @param ErpJournalEntries   [[ch.ninecode.model.ErpJournalEntry ErpJournalEntry]] <em>undocumented</em>
 * @param ErpPayments         [[ch.ninecode.model.ErpPayment ErpPayment]] <em>undocumented</em>
 * @param ErpReceivable       [[ch.ninecode.model.ErpReceivable ErpReceivable]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpRecLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    ErpInvoiceLineItem: String = null,
    ErpJournalEntries: List[String] = null,
    ErpPayments: List[String] = null,
    ErpReceivable: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpRecLineItem.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpRecLineItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpRecLineItem.fields(position), x))

        emitattr(0, status)
        emitattr(1, ErpInvoiceLineItem)
        emitattrs(2, ErpJournalEntries)
        emitattrs(3, ErpPayments)
        emitattr(4, ErpReceivable)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpRecLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpRecLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpRecLineItem
    extends
        CIMParseable[ErpRecLineItem]
{
    override val fields: Array[String] = Array[String](
        "status",
        "ErpInvoiceLineItem",
        "ErpJournalEntries",
        "ErpPayments",
        "ErpReceivable"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpInvoiceLineItem", "ErpInvoiceLineItem", "0..1", "0..1"),
        CIMRelationship("ErpJournalEntries", "ErpJournalEntry", "0..*", "0..*"),
        CIMRelationship("ErpPayments", "ErpPayment", "0..*", "0..*"),
        CIMRelationship("ErpReceivable", "ErpReceivable", "1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ErpJournalEntries: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val ErpPayments: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val ErpReceivable: Fielder = parse_attribute(attribute(cls, fields(4)))

    def parse (context: CIMContext): ErpRecLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpRecLineItem(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(ErpInvoiceLineItem(), 1),
            masks(ErpJournalEntries(), 2),
            masks(ErpPayments(), 3),
            mask(ErpReceivable(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpRecLineItem] = ErpRecLineItemSerializer
}

object ErpRecLineItemSerializer extends CIMSerializer[ErpRecLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpRecLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.ErpInvoiceLineItem),
            () => writeList(obj.ErpJournalEntries, output),
            () => writeList(obj.ErpPayments, output),
            () => output.writeString(obj.ErpReceivable)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpRecLineItem]): ErpRecLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpRecLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transaction representing an invoice, credit memo or debit memo to a customer.
 *
 * It is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param ErpDocument     [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpRecLineItems [[ch.ninecode.model.ErpRecLineItem ErpRecLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpReceivable
(
    ErpDocument: ErpDocument = null,
    ErpRecLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpReceivable.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpReceivable.fields(position), x))

        emitattrs(0, ErpRecLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpReceivable rdf:%s=\"%s\">\n%s\t</cim:ErpReceivable>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpReceivable
    extends
        CIMParseable[ErpReceivable]
{
    override val fields: Array[String] = Array[String](
        "ErpRecLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpRecLineItems", "ErpRecLineItem", "0..*", "1")
    )
    val ErpRecLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpReceivable =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpReceivable(
            ErpDocument.parse(context),
            masks(ErpRecLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpReceivable] = ErpReceivableSerializer
}

object ErpReceivableSerializer extends CIMSerializer[ErpReceivable]
{
    def write (kryo: Kryo, output: Output, obj: ErpReceivable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpRecLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpReceivable]): ErpReceivable =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpReceivable(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transaction for an Organisation receiving goods or services that may be used to indicate receipt of goods in conjunction with a purchase order.
 *
 * A receivable is an open (unpaid) item in the Accounts Receivable ledger.
 *
 * @param ErpDocument         [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpRecDelvLineItems [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpReceiveDelivery
(
    ErpDocument: ErpDocument = null,
    ErpRecDelvLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpReceiveDelivery.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpReceiveDelivery.fields(position), x))

        emitattrs(0, ErpRecDelvLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpReceiveDelivery rdf:%s=\"%s\">\n%s\t</cim:ErpReceiveDelivery>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpReceiveDelivery
    extends
        CIMParseable[ErpReceiveDelivery]
{
    override val fields: Array[String] = Array[String](
        "ErpRecDelvLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpRecDelvLineItems", "ErpRecDelvLineItem", "0..*", "1")
    )
    val ErpRecDelvLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpReceiveDelivery =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpReceiveDelivery(
            ErpDocument.parse(context),
            masks(ErpRecDelvLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpReceiveDelivery] = ErpReceiveDeliverySerializer
}

object ErpReceiveDeliverySerializer extends CIMSerializer[ErpReceiveDelivery]
{
    def write (kryo: Kryo, output: Output, obj: ErpReceiveDelivery): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpRecDelvLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpReceiveDelivery]): ErpReceiveDelivery =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpReceiveDelivery(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information that describes a requested item and its attributes.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param code                <em>undocumented</em>
 * @param cost                Cost of material.
 * @param deliveryDate        <em>undocumented</em>
 * @param quantity            Quantity of item requisitioned.
 * @param status              <em>undocumented</em>
 * @param ErpPOLineItem       [[ch.ninecode.model.ErpPOLineItem ErpPOLineItem]] <em>undocumented</em>
 * @param ErpQuoteLineItem    [[ch.ninecode.model.ErpQuoteLineItem ErpQuoteLineItem]] <em>undocumented</em>
 * @param ErpRequisition      [[ch.ninecode.model.ErpRequisition ErpRequisition]] <em>undocumented</em>
 * @param TypeAsset           [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @param TypeMaterial        [[ch.ninecode.model.TypeMaterial TypeMaterial]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpReqLineItem
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    code: String = null,
    cost: Double = 0.0,
    deliveryDate: String = null,
    quantity: Int = 0,
    status: String = null,
    ErpPOLineItem: String = null,
    ErpQuoteLineItem: String = null,
    ErpRequisition: String = null,
    TypeAsset: String = null,
    TypeMaterial: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpReqLineItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ErpReqLineItem.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpReqLineItem.fields(position), value)

        emitelem(0, code)
        emitelem(1, cost)
        emitelem(2, deliveryDate)
        emitelem(3, quantity)
        emitattr(4, status)
        emitattr(5, ErpPOLineItem)
        emitattr(6, ErpQuoteLineItem)
        emitattr(7, ErpRequisition)
        emitattr(8, TypeAsset)
        emitattr(9, TypeMaterial)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpReqLineItem rdf:%s=\"%s\">\n%s\t</cim:ErpReqLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpReqLineItem
    extends
        CIMParseable[ErpReqLineItem]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpPOLineItem", "ErpPOLineItem", "0..1", "0..1"),
        CIMRelationship("ErpQuoteLineItem", "ErpQuoteLineItem", "0..1", "0..1"),
        CIMRelationship("ErpRequisition", "ErpRequisition", "1", "0..*"),
        CIMRelationship("TypeAsset", "CatalogAssetType", "0..1", "0..*"),
        CIMRelationship("TypeMaterial", "TypeMaterial", "0..1", "0..*")
    )
    val code: Fielder = parse_element(element(cls, fields(0)))
    val cost: Fielder = parse_element(element(cls, fields(1)))
    val deliveryDate: Fielder = parse_element(element(cls, fields(2)))
    val quantity: Fielder = parse_element(element(cls, fields(3)))
    val status: Fielder = parse_attribute(attribute(cls, fields(4)))
    val ErpPOLineItem: Fielder = parse_attribute(attribute(cls, fields(5)))
    val ErpQuoteLineItem: Fielder = parse_attribute(attribute(cls, fields(6)))
    val ErpRequisition: Fielder = parse_attribute(attribute(cls, fields(7)))
    val TypeAsset: Fielder = parse_attribute(attribute(cls, fields(8)))
    val TypeMaterial: Fielder = parse_attribute(attribute(cls, fields(9)))

    def parse (context: CIMContext): ErpReqLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpReqLineItem(
            ErpIdentifiedObject.parse(context),
            mask(code(), 0),
            toDouble(mask(cost(), 1)),
            mask(deliveryDate(), 2),
            toInteger(mask(quantity(), 3)),
            mask(status(), 4),
            mask(ErpPOLineItem(), 5),
            mask(ErpQuoteLineItem(), 6),
            mask(ErpRequisition(), 7),
            mask(TypeAsset(), 8),
            mask(TypeMaterial(), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpReqLineItem] = ErpReqLineItemSerializer
}

object ErpReqLineItemSerializer extends CIMSerializer[ErpReqLineItem]
{
    def write (kryo: Kryo, output: Output, obj: ErpReqLineItem): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.code),
            () => output.writeDouble(obj.cost),
            () => output.writeString(obj.deliveryDate),
            () => output.writeInt(obj.quantity),
            () => output.writeString(obj.status),
            () => output.writeString(obj.ErpPOLineItem),
            () => output.writeString(obj.ErpQuoteLineItem),
            () => output.writeString(obj.ErpRequisition),
            () => output.writeString(obj.TypeAsset),
            () => output.writeString(obj.TypeMaterial)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpReqLineItem]): ErpReqLineItem =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpReqLineItem(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readInt else 0,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General information that applies to a utility requisition that is a request for the purchase of goods or services.
 *
 * Typically, a requisition leads to the creation of a purchase order to a specific supplier.
 *
 * @param ErpDocument     [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpReqLineItems [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpRequisition
(
    ErpDocument: ErpDocument = null,
    ErpReqLineItems: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpRequisition.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpRequisition.fields(position), x))

        emitattrs(0, ErpReqLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpRequisition rdf:%s=\"%s\">\n%s\t</cim:ErpRequisition>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpRequisition
    extends
        CIMParseable[ErpRequisition]
{
    override val fields: Array[String] = Array[String](
        "ErpReqLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpReqLineItems", "ErpReqLineItem", "0..*", "1")
    )
    val ErpReqLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpRequisition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpRequisition(
            ErpDocument.parse(context),
            masks(ErpReqLineItems(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpRequisition] = ErpRequisitionSerializer
}

object ErpRequisitionSerializer extends CIMSerializer[ErpRequisition]
{
    def write (kryo: Kryo, output: Output, obj: ErpRequisition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpReqLineItems, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpRequisition]): ErpRequisition =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpRequisition(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * General purpose Sales Order is used for utility service orders, etc.
 *
 * As used by the OAG, the SalesOrder is a step beyond a PurchaseOrder in that the receiving entity of the order also communicates SalesInformoration about the Order along with the Order itself.
 *
 * @param ErpDocument [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpSalesOrder
(
    ErpDocument: ErpDocument = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:ErpSalesOrder rdf:%s=\"%s\">\n%s\t</cim:ErpSalesOrder>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpSalesOrder
    extends
        CIMParseable[ErpSalesOrder]
{

    def parse (context: CIMContext): ErpSalesOrder =
    {
        val ret = ErpSalesOrder(
            ErpDocument.parse(context)
        )
        ret
    }

    def serializer: Serializer[ErpSalesOrder] = ErpSalesOrderSerializer
}

object ErpSalesOrderSerializer extends CIMSerializer[ErpSalesOrder]
{
    def write (kryo: Kryo, output: Output, obj: ErpSalesOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpSalesOrder]): ErpSalesOrder =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpSalesOrder(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * For a utility, general information that describes physical locations of organizations or the location codes and their meanings.
 *
 * This enables ERP applications to ensure that the physical location identifiers are synchronized between the business applications.
 *
 * @param ErpIdentifiedObject [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status              <em>undocumented</em>
 * @param LandProperty        [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpSiteLevelData
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    LandProperty: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpSiteLevelData.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpSiteLevelData.fields(position), value)

        emitattr(0, status)
        emitattr(1, LandProperty)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpSiteLevelData rdf:%s=\"%s\">\n%s\t</cim:ErpSiteLevelData>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpSiteLevelData
    extends
        CIMParseable[ErpSiteLevelData]
{
    override val fields: Array[String] = Array[String](
        "status",
        "LandProperty"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("LandProperty", "LandProperty", "0..1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val LandProperty: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): ErpSiteLevelData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpSiteLevelData(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(LandProperty(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpSiteLevelData] = ErpSiteLevelDataSerializer
}

object ErpSiteLevelDataSerializer extends CIMSerializer[ErpSiteLevelData]
{
    def write (kryo: Kryo, output: Output, obj: ErpSiteLevelData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.LandProperty)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpSiteLevelData]): ErpSiteLevelData =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpSiteLevelData(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An individual entry on an ErpTimeSheet.
 *
 * @param ErpIdentifiedObject  [[ch.ninecode.model.ErpIdentifiedObject ErpIdentifiedObject]] Reference to the superclass object.
 * @param status               <em>undocumented</em>
 * @param ErpProjectAccounting [[ch.ninecode.model.ErpProjectAccounting ErpProjectAccounting]] <em>undocumented</em>
 * @param ErpTimeSheet         [[ch.ninecode.model.ErpTimeSheet ErpTimeSheet]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpTimeEntry
(
    ErpIdentifiedObject: ErpIdentifiedObject = null,
    status: String = null,
    ErpProjectAccounting: String = null,
    ErpTimeSheet: String = null
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
    override def sup: ErpIdentifiedObject = ErpIdentifiedObject

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpTimeEntry.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ErpTimeEntry.fields(position), value)

        emitattr(0, status)
        emitattr(1, ErpProjectAccounting)
        emitattr(2, ErpTimeSheet)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpTimeEntry rdf:%s=\"%s\">\n%s\t</cim:ErpTimeEntry>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpTimeEntry
    extends
        CIMParseable[ErpTimeEntry]
{
    override val fields: Array[String] = Array[String](
        "status",
        "ErpProjectAccounting",
        "ErpTimeSheet"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpProjectAccounting", "ErpProjectAccounting", "0..1", "0..*"),
        CIMRelationship("ErpTimeSheet", "ErpTimeSheet", "1", "0..*")
    )
    val status: Fielder = parse_attribute(attribute(cls, fields(0)))
    val ErpProjectAccounting: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ErpTimeSheet: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): ErpTimeEntry =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpTimeEntry(
            ErpIdentifiedObject.parse(context),
            mask(status(), 0),
            mask(ErpProjectAccounting(), 1),
            mask(ErpTimeSheet(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpTimeEntry] = ErpTimeEntrySerializer
}

object ErpTimeEntrySerializer extends CIMSerializer[ErpTimeEntry]
{
    def write (kryo: Kryo, output: Output, obj: ErpTimeEntry): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.status),
            () => output.writeString(obj.ErpProjectAccounting),
            () => output.writeString(obj.ErpTimeSheet)
        )
        ErpIdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpTimeEntry]): ErpTimeEntry =
    {
        val parent = ErpIdentifiedObjectSerializer.read(kryo, input, classOf[ErpIdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpTimeEntry(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Time sheet for employees and contractors.
 *
 * Note that ErpTimeSheet inherits the relationship to ErpPerson from Document.
 *
 * @param ErpDocument    [[ch.ninecode.model.ErpDocument ErpDocument]] Reference to the superclass object.
 * @param ErpTimeEntries [[ch.ninecode.model.ErpTimeEntry ErpTimeEntry]] <em>undocumented</em>
 * @group InfERPSupport
 * @groupname InfERPSupport Package InfERPSupport
 * @groupdesc InfERPSupport The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG). It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 *            TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 *            "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *            If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 */
final case class ErpTimeSheet
(
    ErpDocument: ErpDocument = null,
    ErpTimeEntries: List[String] = null
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
    override def sup: ErpDocument = ErpDocument

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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ErpTimeSheet.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ErpTimeSheet.fields(position), x))

        emitattrs(0, ErpTimeEntries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ErpTimeSheet rdf:%s=\"%s\">\n%s\t</cim:ErpTimeSheet>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ErpTimeSheet
    extends
        CIMParseable[ErpTimeSheet]
{
    override val fields: Array[String] = Array[String](
        "ErpTimeEntries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ErpTimeEntries", "ErpTimeEntry", "0..*", "1")
    )
    val ErpTimeEntries: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): ErpTimeSheet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ErpTimeSheet(
            ErpDocument.parse(context),
            masks(ErpTimeEntries(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ErpTimeSheet] = ErpTimeSheetSerializer
}

object ErpTimeSheetSerializer extends CIMSerializer[ErpTimeSheet]
{
    def write (kryo: Kryo, output: Output, obj: ErpTimeSheet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.ErpTimeEntries, output)
        )
        ErpDocumentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ErpTimeSheet]): ErpTimeSheet =
    {
        val parent = ErpDocumentSerializer.read(kryo, input, classOf[ErpDocument])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ErpTimeSheet(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfERPSupport
{
    def register: List[CIMClassInfo] =
    {
        List(
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