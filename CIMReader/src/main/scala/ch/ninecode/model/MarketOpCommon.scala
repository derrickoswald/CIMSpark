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
 * A roll up of invoice line items.
 *
 * The whole invoice has a due date and amount to be paid, with information such as customer, banks etc. being obtained through associations. The invoice roll up is based on individual line items that each contain amounts and descriptions for specific services or products.
 *
 * @param Element                Reference to the superclass object.
 * @param amount                 Total amount due on this invoice based on line items and applicable adjustments.
 * @param billMediaKind          Kind of media by which the CustomerBillingInfo was delivered.
 * @param dueDate                Calculated date upon which the Invoice amount is due.
 * @param kind                   Kind of invoice (default is 'sales').
 * @param mailedDate             Date on which the customer billing statement/invoice was printed/mailed.
 * @param proForma               True if payment is to be paid by a Customer to accept a particular ErpQuote (with associated Design) and have work initiated, at which time an associated ErpInvoice should automatically be generated.
 *                               EprPayment.subjectStatus satisfies terms specificed in the ErpQuote.
 * @param referenceNumber        Number of an invoice to be reference by this invoice.
 * @param transactionDateTime    Date and time when the invoice is issued.
 * @param transferType           Type of invoice transfer.
 * @param MajorChargeGroup       [[ch.ninecode.model.MajorChargeGroup MajorChargeGroup]] <em>undocumented</em>
 * @param MarketInvoiceLineItems [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketInvoice
(
    Element: BasicElement = null,
    amount: Double = 0.0,
    billMediaKind: String = null,
    dueDate: String = null,
    kind: String = null,
    mailedDate: String = null,
    proForma: Boolean = false,
    referenceNumber: String = null,
    transactionDateTime: String = null,
    transferType: String = null,
    MajorChargeGroup: List[String] = null,
    MarketInvoiceLineItems: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketInvoice.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MarketInvoice.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MarketInvoice.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketInvoice.fields(position), x))

        emitelem(0, amount)
        emitattr(1, billMediaKind)
        emitelem(2, dueDate)
        emitattr(3, kind)
        emitelem(4, mailedDate)
        emitelem(5, proForma)
        emitelem(6, referenceNumber)
        emitelem(7, transactionDateTime)
        emitelem(8, transferType)
        emitattrs(9, MajorChargeGroup)
        emitattrs(10, MarketInvoiceLineItems)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketInvoice rdf:%s=\"%s\">\n%s\t</cim:MarketInvoice>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketInvoice
    extends
        CIMParseable[MarketInvoice]
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
        "MajorChargeGroup",
        "MarketInvoiceLineItems"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MajorChargeGroup", "MajorChargeGroup", "1..*", "0..*"),
        CIMRelationship("MarketInvoiceLineItems", "MarketInvoiceLineItem", "0..*", "1")
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
    val MajorChargeGroup: FielderMultiple = parse_attributes(attribute(cls, fields(9)))
    val MarketInvoiceLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(10)))

    def parse (context: CIMContext): MarketInvoice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketInvoice(
            BasicElement.parse(context),
            toDouble(mask(amount(), 0)),
            mask(billMediaKind(), 1),
            mask(dueDate(), 2),
            mask(kind(), 3),
            mask(mailedDate(), 4),
            toBoolean(mask(proForma(), 5)),
            mask(referenceNumber(), 6),
            mask(transactionDateTime(), 7),
            mask(transferType(), 8),
            masks(MajorChargeGroup(), 9),
            masks(MarketInvoiceLineItems(), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketInvoice] = MarketInvoiceSerializer
}

object MarketInvoiceSerializer extends CIMSerializer[MarketInvoice]
{
    def write (kryo: Kryo, output: Output, obj: MarketInvoice): Unit =
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
            () => writeList(obj.MajorChargeGroup, output),
            () => writeList(obj.MarketInvoiceLineItems, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketInvoice]): MarketInvoice =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketInvoice(
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
            if (isSet(9)) readList(input) else null,
            if (isSet(10)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An individual line item on an invoice.
 *
 * @param Element                         Reference to the superclass object.
 * @param billPeriod                      Bill period for the line item.
 * @param glAccount                       General Ledger account code, shall be a valid combination.
 * @param glDateTime                      Date and time line item will be posted to the General Ledger.
 * @param kind                            Kind of line item.
 * @param lineAmount                      Amount due for this line item.
 * @param lineNumber                      Line item number on invoice statement.
 * @param lineVersion                     Version number of the bill run.
 * @param netAmount                       Net line item charge amount.
 * @param previousAmount                  Previous line item charge amount.
 * @param ComponentMarketInvoiceLineItems [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @param ContainerMarketInvoiceLineItem  [[ch.ninecode.model.MarketInvoiceLineItem MarketInvoiceLineItem]] <em>undocumented</em>
 * @param MarketInvoice                   [[ch.ninecode.model.MarketInvoice MarketInvoice]] <em>undocumented</em>
 * @param Settlement                      [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketInvoiceLineItem
(
    Element: BasicElement = null,
    billPeriod: String = null,
    glAccount: String = null,
    glDateTime: String = null,
    kind: String = null,
    lineAmount: Double = 0.0,
    lineNumber: String = null,
    lineVersion: String = null,
    netAmount: Double = 0.0,
    previousAmount: Double = 0.0,
    ComponentMarketInvoiceLineItems: List[String] = null,
    ContainerMarketInvoiceLineItem: String = null,
    MarketInvoice: String = null,
    Settlement: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketInvoiceLineItem.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MarketInvoiceLineItem.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MarketInvoiceLineItem.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketInvoiceLineItem.fields(position), x))

        emitattr(0, billPeriod)
        emitelem(1, glAccount)
        emitelem(2, glDateTime)
        emitattr(3, kind)
        emitelem(4, lineAmount)
        emitelem(5, lineNumber)
        emitelem(6, lineVersion)
        emitelem(7, netAmount)
        emitelem(8, previousAmount)
        emitattrs(9, ComponentMarketInvoiceLineItems)
        emitattr(10, ContainerMarketInvoiceLineItem)
        emitattr(11, MarketInvoice)
        emitattrs(12, Settlement)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketInvoiceLineItem rdf:%s=\"%s\">\n%s\t</cim:MarketInvoiceLineItem>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketInvoiceLineItem
    extends
        CIMParseable[MarketInvoiceLineItem]
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
        "ComponentMarketInvoiceLineItems",
        "ContainerMarketInvoiceLineItem",
        "MarketInvoice",
        "Settlement"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ComponentMarketInvoiceLineItems", "MarketInvoiceLineItem", "0..*", "0..1"),
        CIMRelationship("ContainerMarketInvoiceLineItem", "MarketInvoiceLineItem", "0..1", "0..*"),
        CIMRelationship("MarketInvoice", "MarketInvoice", "1", "0..*"),
        CIMRelationship("Settlement", "Settlement", "0..*", "0..*")
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
    val ComponentMarketInvoiceLineItems: FielderMultiple = parse_attributes(attribute(cls, fields(9)))
    val ContainerMarketInvoiceLineItem: Fielder = parse_attribute(attribute(cls, fields(10)))
    val MarketInvoice: Fielder = parse_attribute(attribute(cls, fields(11)))
    val Settlement: FielderMultiple = parse_attributes(attribute(cls, fields(12)))

    def parse (context: CIMContext): MarketInvoiceLineItem =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketInvoiceLineItem(
            BasicElement.parse(context),
            mask(billPeriod(), 0),
            mask(glAccount(), 1),
            mask(glDateTime(), 2),
            mask(kind(), 3),
            toDouble(mask(lineAmount(), 4)),
            mask(lineNumber(), 5),
            mask(lineVersion(), 6),
            toDouble(mask(netAmount(), 7)),
            toDouble(mask(previousAmount(), 8)),
            masks(ComponentMarketInvoiceLineItems(), 9),
            mask(ContainerMarketInvoiceLineItem(), 10),
            mask(MarketInvoice(), 11),
            masks(Settlement(), 12)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketInvoiceLineItem] = MarketInvoiceLineItemSerializer
}

object MarketInvoiceLineItemSerializer extends CIMSerializer[MarketInvoiceLineItem]
{
    def write (kryo: Kryo, output: Output, obj: MarketInvoiceLineItem): Unit =
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
            () => writeList(obj.ComponentMarketInvoiceLineItems, output),
            () => output.writeString(obj.ContainerMarketInvoiceLineItem),
            () => output.writeString(obj.MarketInvoice),
            () => writeList(obj.Settlement, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketInvoiceLineItem]): MarketInvoiceLineItem =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketInvoiceLineItem(
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
            if (isSet(11)) input.readString else null,
            if (isSet(12)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * In accounting transactions, a ledger is a book containing accounts to which debits and credits are posted from journals, where transactions are initially recorded.
 *
 * Journal entries are periodically posted to the ledger. Ledger actual represents actual amounts by account within ledger within company or within business area. Actual amounts may be generated in a source application and then loaded to a specific ledger within the enterprise general ledger or budget application.
 *
 * @param Element             Reference to the superclass object.
 * @param MarketLedgerEntries [[ch.ninecode.model.MarketLedgerEntry MarketLedgerEntry]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketLedger
(
    Element: BasicElement = null,
    MarketLedgerEntries: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketLedger.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketLedger.fields(position), x))

        emitattrs(0, MarketLedgerEntries)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketLedger rdf:%s=\"%s\">\n%s\t</cim:MarketLedger>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketLedger
    extends
        CIMParseable[MarketLedger]
{
    override val fields: Array[String] = Array[String](
        "MarketLedgerEntries"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MarketLedgerEntries", "MarketLedgerEntry", "0..*", "1")
    )
    val MarketLedgerEntries: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): MarketLedger =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketLedger(
            BasicElement.parse(context),
            masks(MarketLedgerEntries(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketLedger] = MarketLedgerSerializer
}

object MarketLedgerSerializer extends CIMSerializer[MarketLedger]
{
    def write (kryo: Kryo, output: Output, obj: MarketLedger): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.MarketLedgerEntries, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketLedger]): MarketLedger =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketLedger(
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
 * @param Element             Reference to the superclass object.
 * @param accountID           Account identifier for this entry.
 * @param accountKind         Kind of account for this entry.
 * @param amount              The amount of the debit or credit for this account.
 * @param postedDateTime      Date and time this entry was posted to the ledger.
 * @param status              Status of ledger entry.
 * @param transactionDateTime Date and time journal entry was recorded.
 * @param MarketLedger        [[ch.ninecode.model.MarketLedger MarketLedger]] <em>undocumented</em>
 * @param Settlement          [[ch.ninecode.model.Settlement Settlement]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MarketLedgerEntry
(
    Element: BasicElement = null,
    accountID: String = null,
    accountKind: String = null,
    amount: Double = 0.0,
    postedDateTime: String = null,
    status: String = null,
    transactionDateTime: String = null,
    MarketLedger: String = null,
    Settlement: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketLedgerEntry.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MarketLedgerEntry.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MarketLedgerEntry.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketLedgerEntry.fields(position), x))

        emitelem(0, accountID)
        emitattr(1, accountKind)
        emitelem(2, amount)
        emitelem(3, postedDateTime)
        emitattr(4, status)
        emitelem(5, transactionDateTime)
        emitattr(6, MarketLedger)
        emitattrs(7, Settlement)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketLedgerEntry rdf:%s=\"%s\">\n%s\t</cim:MarketLedgerEntry>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketLedgerEntry
    extends
        CIMParseable[MarketLedgerEntry]
{
    override val fields: Array[String] = Array[String](
        "accountID",
        "accountKind",
        "amount",
        "postedDateTime",
        "status",
        "transactionDateTime",
        "MarketLedger",
        "Settlement"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MarketLedger", "MarketLedger", "1", "0..*"),
        CIMRelationship("Settlement", "Settlement", "0..*", "0..*")
    )
    val accountID: Fielder = parse_element(element(cls, fields(0)))
    val accountKind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val amount: Fielder = parse_element(element(cls, fields(2)))
    val postedDateTime: Fielder = parse_element(element(cls, fields(3)))
    val status: Fielder = parse_attribute(attribute(cls, fields(4)))
    val transactionDateTime: Fielder = parse_element(element(cls, fields(5)))
    val MarketLedger: Fielder = parse_attribute(attribute(cls, fields(6)))
    val Settlement: FielderMultiple = parse_attributes(attribute(cls, fields(7)))

    def parse (context: CIMContext): MarketLedgerEntry =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketLedgerEntry(
            BasicElement.parse(context),
            mask(accountID(), 0),
            mask(accountKind(), 1),
            toDouble(mask(amount(), 2)),
            mask(postedDateTime(), 3),
            mask(status(), 4),
            mask(transactionDateTime(), 5),
            mask(MarketLedger(), 6),
            masks(Settlement(), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketLedgerEntry] = MarketLedgerEntrySerializer
}

object MarketLedgerEntrySerializer extends CIMSerializer[MarketLedgerEntry]
{
    def write (kryo: Kryo, output: Output, obj: MarketLedgerEntry): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.accountID),
            () => output.writeString(obj.accountKind),
            () => output.writeDouble(obj.amount),
            () => output.writeString(obj.postedDateTime),
            () => output.writeString(obj.status),
            () => output.writeString(obj.transactionDateTime),
            () => output.writeString(obj.MarketLedger),
            () => writeList(obj.Settlement, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketLedgerEntry]): MarketLedgerEntry =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketLedgerEntry(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61968: Common:ActivityRecord.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param MarketFactors  [[ch.ninecode.model.MarketFactors MarketFactors]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktActivityRecord
(
    ActivityRecord: ActivityRecord = null,
    MarketFactors: List[String] = null
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
    override def sup: ActivityRecord = ActivityRecord

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
        implicit val clz: String = MktActivityRecord.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktActivityRecord.fields(position), x))

        emitattrs(0, MarketFactors)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktActivityRecord rdf:%s=\"%s\">\n%s\t</cim:MktActivityRecord>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktActivityRecord
    extends
        CIMParseable[MktActivityRecord]
{
    override val fields: Array[String] = Array[String](
        "MarketFactors"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MarketFactors", "MarketFactors", "0..*", "0..*")
    )
    val MarketFactors: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): MktActivityRecord =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktActivityRecord(
            ActivityRecord.parse(context),
            masks(MarketFactors(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktActivityRecord] = MktActivityRecordSerializer
}

object MktActivityRecordSerializer extends CIMSerializer[MktActivityRecord]
{
    def write (kryo: Kryo, output: Output, obj: MktActivityRecord): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.MarketFactors, output)
        )
        ActivityRecordSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktActivityRecord]): MktActivityRecord =
    {
        val parent = ActivityRecordSerializer.read(kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktActivityRecord(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61970:Topology:ConnectivityNode.
 *
 * @param ConnectivityNode        [[ch.ninecode.model.ConnectivityNode ConnectivityNode]] Reference to the superclass object.
 * @param CnodeDistributionFactor [[ch.ninecode.model.CnodeDistributionFactor CnodeDistributionFactor]] <em>undocumented</em>
 * @param IndividualPnode         [[ch.ninecode.model.IndividualPnode IndividualPnode]] <em>undocumented</em>
 * @param LossPenaltyFactor       [[ch.ninecode.model.LossSensitivity LossSensitivity]] <em>undocumented</em>
 * @param NodeConstraintTerm      [[ch.ninecode.model.NodeConstraintTerm NodeConstraintTerm]] <em>undocumented</em>
 * @param RTO                     [[ch.ninecode.model.RTO RTO]] <em>undocumented</em>
 * @param RegisteredResource      [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param SysLoadDistribuFactor   [[ch.ninecode.model.SysLoadDistributionFactor SysLoadDistributionFactor]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktConnectivityNode
(
    ConnectivityNode: ConnectivityNode = null,
    CnodeDistributionFactor: List[String] = null,
    IndividualPnode: String = null,
    LossPenaltyFactor: List[String] = null,
    NodeConstraintTerm: List[String] = null,
    RTO: String = null,
    RegisteredResource: List[String] = null,
    SysLoadDistribuFactor: String = null
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
    override def sup: ConnectivityNode = ConnectivityNode

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
        implicit val clz: String = MktConnectivityNode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MktConnectivityNode.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktConnectivityNode.fields(position), x))

        emitattrs(0, CnodeDistributionFactor)
        emitattr(1, IndividualPnode)
        emitattrs(2, LossPenaltyFactor)
        emitattrs(3, NodeConstraintTerm)
        emitattr(4, RTO)
        emitattrs(5, RegisteredResource)
        emitattr(6, SysLoadDistribuFactor)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktConnectivityNode rdf:%s=\"%s\">\n%s\t</cim:MktConnectivityNode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktConnectivityNode
    extends
        CIMParseable[MktConnectivityNode]
{
    override val fields: Array[String] = Array[String](
        "CnodeDistributionFactor",
        "IndividualPnode",
        "LossPenaltyFactor",
        "NodeConstraintTerm",
        "RTO",
        "RegisteredResource",
        "SysLoadDistribuFactor"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CnodeDistributionFactor", "CnodeDistributionFactor", "0..*", "1"),
        CIMRelationship("IndividualPnode", "IndividualPnode", "0..1", "1"),
        CIMRelationship("LossPenaltyFactor", "LossSensitivity", "0..*", "1"),
        CIMRelationship("NodeConstraintTerm", "NodeConstraintTerm", "0..*", "1"),
        CIMRelationship("RTO", "RTO", "1", "0..*"),
        CIMRelationship("RegisteredResource", "RegisteredResource", "0..*", "0..1"),
        CIMRelationship("SysLoadDistribuFactor", "SysLoadDistributionFactor", "0..1", "1")
    )
    val CnodeDistributionFactor: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val IndividualPnode: Fielder = parse_attribute(attribute(cls, fields(1)))
    val LossPenaltyFactor: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val NodeConstraintTerm: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val RTO: Fielder = parse_attribute(attribute(cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes(attribute(cls, fields(5)))
    val SysLoadDistribuFactor: Fielder = parse_attribute(attribute(cls, fields(6)))

    def parse (context: CIMContext): MktConnectivityNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktConnectivityNode(
            ConnectivityNode.parse(context),
            masks(CnodeDistributionFactor(), 0),
            mask(IndividualPnode(), 1),
            masks(LossPenaltyFactor(), 2),
            masks(NodeConstraintTerm(), 3),
            mask(RTO(), 4),
            masks(RegisteredResource(), 5),
            mask(SysLoadDistribuFactor(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktConnectivityNode] = MktConnectivityNodeSerializer
}

object MktConnectivityNodeSerializer extends CIMSerializer[MktConnectivityNode]
{
    def write (kryo: Kryo, output: Output, obj: MktConnectivityNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.CnodeDistributionFactor, output),
            () => output.writeString(obj.IndividualPnode),
            () => writeList(obj.LossPenaltyFactor, output),
            () => writeList(obj.NodeConstraintTerm, output),
            () => output.writeString(obj.RTO),
            () => writeList(obj.RegisteredResource, output),
            () => output.writeString(obj.SysLoadDistribuFactor)
        )
        ConnectivityNodeSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktConnectivityNode]): MktConnectivityNode =
    {
        val parent = ConnectivityNodeSerializer.read(kryo, input, classOf[ConnectivityNode])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktConnectivityNode(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) readList(input) else null,
            if (isSet(6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass for IEC61970:Wires:Line.
 *
 * @param Line                   [[ch.ninecode.model.Line Line]] Reference to the superclass object.
 * @param Flowgate               [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TransmissionRightOfWay [[ch.ninecode.model.TransmissionRightOfWay TransmissionRightOfWay]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktLine
(
    Line: Line = null,
    Flowgate: List[String] = null,
    TransmissionRightOfWay: String = null
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
    override def sup: Line = Line

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
        implicit val clz: String = MktLine.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MktLine.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktLine.fields(position), x))

        emitattrs(0, Flowgate)
        emitattr(1, TransmissionRightOfWay)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktLine rdf:%s=\"%s\">\n%s\t</cim:MktLine>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktLine
    extends
        CIMParseable[MktLine]
{
    override val fields: Array[String] = Array[String](
        "Flowgate",
        "TransmissionRightOfWay"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Flowgate", "Flowgate", "0..*", "0..*"),
        CIMRelationship("TransmissionRightOfWay", "TransmissionRightOfWay", "0..1", "0..*")
    )
    val Flowgate: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val TransmissionRightOfWay: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): MktLine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktLine(
            Line.parse(context),
            masks(Flowgate(), 0),
            mask(TransmissionRightOfWay(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktLine] = MktLineSerializer
}

object MktLineSerializer extends CIMSerializer[MktLine]
{
    def write (kryo: Kryo, output: Output, obj: MktLine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.Flowgate, output),
            () => output.writeString(obj.TransmissionRightOfWay)
        )
        LineSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktLine]): MktLine =
    {
        val parent = LineSerializer.read(kryo, input, classOf[Line])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktLine(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61970:Meas:Measurement.
 *
 * @param Measurement     [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param ByTiePoint      [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the B side of a tie point
 * @param DynamicSchedule [[ch.ninecode.model.DynamicSchedule DynamicSchedule]] <em>undocumented</em>
 * @param ForTiePoint     [[ch.ninecode.model.TiePoint TiePoint]] A measurement is made on the A side of a tie point
 * @param Pnode           [[ch.ninecode.model.Pnode Pnode]] Allows Pnode an association to aggregated resources external DC ties or psuedo tie measurements.
 * @param ViolationLimit  [[ch.ninecode.model.ViolationLimit ViolationLimit]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktMeasurement
(
    Measurement: Measurement = null,
    ByTiePoint: String = null,
    DynamicSchedule: List[String] = null,
    ForTiePoint: String = null,
    Pnode: String = null,
    ViolationLimit: List[String] = null
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
    override def sup: Measurement = Measurement

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
        implicit val clz: String = MktMeasurement.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MktMeasurement.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktMeasurement.fields(position), x))

        emitattr(0, ByTiePoint)
        emitattrs(1, DynamicSchedule)
        emitattr(2, ForTiePoint)
        emitattr(3, Pnode)
        emitattrs(4, ViolationLimit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktMeasurement rdf:%s=\"%s\">\n%s\t</cim:MktMeasurement>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktMeasurement
    extends
        CIMParseable[MktMeasurement]
{
    override val fields: Array[String] = Array[String](
        "ByTiePoint",
        "DynamicSchedule",
        "ForTiePoint",
        "Pnode",
        "ViolationLimit"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ByTiePoint", "TiePoint", "1", "1..*"),
        CIMRelationship("DynamicSchedule", "DynamicSchedule", "0..*", "1"),
        CIMRelationship("ForTiePoint", "TiePoint", "1", "1..*"),
        CIMRelationship("Pnode", "Pnode", "0..1", "0..*"),
        CIMRelationship("ViolationLimit", "ViolationLimit", "0..*", "0..1")
    )
    val ByTiePoint: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DynamicSchedule: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ForTiePoint: Fielder = parse_attribute(attribute(cls, fields(2)))
    val Pnode: Fielder = parse_attribute(attribute(cls, fields(3)))
    val ViolationLimit: FielderMultiple = parse_attributes(attribute(cls, fields(4)))

    def parse (context: CIMContext): MktMeasurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktMeasurement(
            Measurement.parse(context),
            mask(ByTiePoint(), 0),
            masks(DynamicSchedule(), 1),
            mask(ForTiePoint(), 2),
            mask(Pnode(), 3),
            masks(ViolationLimit(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktMeasurement] = MktMeasurementSerializer
}

object MktMeasurementSerializer extends CIMSerializer[MktMeasurement]
{
    def write (kryo: Kryo, output: Output, obj: MktMeasurement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.ByTiePoint),
            () => writeList(obj.DynamicSchedule, output),
            () => output.writeString(obj.ForTiePoint),
            () => output.writeString(obj.Pnode),
            () => writeList(obj.ViolationLimit, output)
        )
        MeasurementSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktMeasurement]): MktMeasurement =
    {
        val parent = MeasurementSerializer.read(kryo, input, classOf[Measurement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktMeasurement(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61970:Wires:PowerTransformer.
 *
 * @param PowerTransformer [[ch.ninecode.model.PowerTransformer PowerTransformer]] Reference to the superclass object.
 * @param EndAFlow         [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param EndBFlow         [[ch.ninecode.model.BranchEndFlow BranchEndFlow]] <em>undocumented</em>
 * @param Flowgate         [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktPowerTransformer
(
    PowerTransformer: PowerTransformer = null,
    EndAFlow: String = null,
    EndBFlow: String = null,
    Flowgate: List[String] = null
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
    override def sup: PowerTransformer = PowerTransformer

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
        implicit val clz: String = MktPowerTransformer.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MktPowerTransformer.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktPowerTransformer.fields(position), x))

        emitattr(0, EndAFlow)
        emitattr(1, EndBFlow)
        emitattrs(2, Flowgate)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktPowerTransformer rdf:%s=\"%s\">\n%s\t</cim:MktPowerTransformer>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktPowerTransformer
    extends
        CIMParseable[MktPowerTransformer]
{
    override val fields: Array[String] = Array[String](
        "EndAFlow",
        "EndBFlow",
        "Flowgate"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EndAFlow", "BranchEndFlow", "0..1", "0..*"),
        CIMRelationship("EndBFlow", "BranchEndFlow", "0..1", "0..*"),
        CIMRelationship("Flowgate", "Flowgate", "0..*", "0..*")
    )
    val EndAFlow: Fielder = parse_attribute(attribute(cls, fields(0)))
    val EndBFlow: Fielder = parse_attribute(attribute(cls, fields(1)))
    val Flowgate: FielderMultiple = parse_attributes(attribute(cls, fields(2)))

    def parse (context: CIMContext): MktPowerTransformer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktPowerTransformer(
            PowerTransformer.parse(context),
            mask(EndAFlow(), 0),
            mask(EndBFlow(), 1),
            masks(Flowgate(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktPowerTransformer] = MktPowerTransformerSerializer
}

object MktPowerTransformerSerializer extends CIMSerializer[MktPowerTransformer]
{
    def write (kryo: Kryo, output: Output, obj: MktPowerTransformer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.EndAFlow),
            () => output.writeString(obj.EndBFlow),
            () => writeList(obj.Flowgate, output)
        )
        PowerTransformerSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktPowerTransformer]): MktPowerTransformer =
    {
        val parent = PowerTransformerSerializer.read(kryo, input, classOf[PowerTransformer])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktPowerTransformer(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61970:Core:Terminal.
 *
 * @param Terminal               [[ch.ninecode.model.Terminal Terminal]] Reference to the superclass object.
 * @param Flowgate               [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param TerminalConstraintTerm [[ch.ninecode.model.TerminalConstraintTerm TerminalConstraintTerm]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktTerminal
(
    Terminal: Terminal = null,
    Flowgate: String = null,
    TerminalConstraintTerm: List[String] = null
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
    override def sup: Terminal = Terminal

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
        implicit val clz: String = MktTerminal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(MktTerminal.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktTerminal.fields(position), x))

        emitattr(0, Flowgate)
        emitattrs(1, TerminalConstraintTerm)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktTerminal rdf:%s=\"%s\">\n%s\t</cim:MktTerminal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktTerminal
    extends
        CIMParseable[MktTerminal]
{
    override val fields: Array[String] = Array[String](
        "Flowgate",
        "TerminalConstraintTerm"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Flowgate", "Flowgate", "0..1", "0..*"),
        CIMRelationship("TerminalConstraintTerm", "TerminalConstraintTerm", "0..*", "1")
    )
    val Flowgate: Fielder = parse_attribute(attribute(cls, fields(0)))
    val TerminalConstraintTerm: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): MktTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktTerminal(
            Terminal.parse(context),
            mask(Flowgate(), 0),
            masks(TerminalConstraintTerm(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktTerminal] = MktTerminalSerializer
}

object MktTerminalSerializer extends CIMSerializer[MktTerminal]
{
    def write (kryo: Kryo, output: Output, obj: MktTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Flowgate),
            () => writeList(obj.TerminalConstraintTerm, output)
        )
        TerminalSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktTerminal]): MktTerminal =
    {
        val parent = TerminalSerializer.read(kryo, input, classOf[Terminal])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktTerminal(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Subclass of IEC61968:Domain2:UserAttribute.
 *
 * @param UserAttribute           [[ch.ninecode.model.UserAttribute UserAttribute]] Reference to the superclass object.
 * @param AttributeProperty       [[ch.ninecode.model.AttributeProperty AttributeProperty]] <em>undocumented</em>
 * @param BillDeterminant         [[ch.ninecode.model.BillDeterminant BillDeterminant]] <em>undocumented</em>
 * @param ChargeGroup             [[ch.ninecode.model.ChargeGroup ChargeGroup]] <em>undocumented</em>
 * @param ChargeType              [[ch.ninecode.model.ChargeType ChargeType]] <em>undocumented</em>
 * @param MarketStatementLineItem [[ch.ninecode.model.MarketStatementLineItem MarketStatementLineItem]] <em>undocumented</em>
 * @param PassThroughBill         [[ch.ninecode.model.PassThroughBill PassThroughBill]] <em>undocumented</em>
 * @group MarketOpCommon
 * @groupname MarketOpCommon Package MarketOpCommon
 * @groupdesc MarketOpCommon This package contains the common objects shared by MarketOperations packages.
 */
final case class MktUserAttribute
(
    UserAttribute: UserAttribute = null,
    AttributeProperty: List[String] = null,
    BillDeterminant: List[String] = null,
    ChargeGroup: List[String] = null,
    ChargeType: List[String] = null,
    MarketStatementLineItem: List[String] = null,
    PassThroughBill: List[String] = null
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
    override def sup: UserAttribute = UserAttribute

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
        implicit val clz: String = MktUserAttribute.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MktUserAttribute.fields(position), x))

        emitattrs(0, AttributeProperty)
        emitattrs(1, BillDeterminant)
        emitattrs(2, ChargeGroup)
        emitattrs(3, ChargeType)
        emitattrs(4, MarketStatementLineItem)
        emitattrs(5, PassThroughBill)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MktUserAttribute rdf:%s=\"%s\">\n%s\t</cim:MktUserAttribute>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MktUserAttribute
    extends
        CIMParseable[MktUserAttribute]
{
    override val fields: Array[String] = Array[String](
        "AttributeProperty",
        "BillDeterminant",
        "ChargeGroup",
        "ChargeType",
        "MarketStatementLineItem",
        "PassThroughBill"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AttributeProperty", "AttributeProperty", "0..*", "1"),
        CIMRelationship("BillDeterminant", "BillDeterminant", "0..*", "0..*"),
        CIMRelationship("ChargeGroup", "ChargeGroup", "0..*", "0..*"),
        CIMRelationship("ChargeType", "ChargeType", "0..*", "0..*"),
        CIMRelationship("MarketStatementLineItem", "MarketStatementLineItem", "0..*", "0..*"),
        CIMRelationship("PassThroughBill", "PassThroughBill", "0..*", "0..*")
    )
    val AttributeProperty: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val BillDeterminant: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ChargeGroup: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val ChargeType: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val MarketStatementLineItem: FielderMultiple = parse_attributes(attribute(cls, fields(4)))
    val PassThroughBill: FielderMultiple = parse_attributes(attribute(cls, fields(5)))

    def parse (context: CIMContext): MktUserAttribute =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktUserAttribute(
            UserAttribute.parse(context),
            masks(AttributeProperty(), 0),
            masks(BillDeterminant(), 1),
            masks(ChargeGroup(), 2),
            masks(ChargeType(), 3),
            masks(MarketStatementLineItem(), 4),
            masks(PassThroughBill(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MktUserAttribute] = MktUserAttributeSerializer
}

object MktUserAttributeSerializer extends CIMSerializer[MktUserAttribute]
{
    def write (kryo: Kryo, output: Output, obj: MktUserAttribute): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.AttributeProperty, output),
            () => writeList(obj.BillDeterminant, output),
            () => writeList(obj.ChargeGroup, output),
            () => writeList(obj.ChargeType, output),
            () => writeList(obj.MarketStatementLineItem, output),
            () => writeList(obj.PassThroughBill, output)
        )
        UserAttributeSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktUserAttribute]): MktUserAttribute =
    {
        val parent = UserAttributeSerializer.read(kryo, input, classOf[UserAttribute])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MktUserAttribute(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) readList(input) else null,
            if (isSet(5)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _MarketOpCommon
{
    def register: List[CIMClassInfo] =
    {
        List(
            MarketInvoice.register,
            MarketInvoiceLineItem.register,
            MarketLedger.register,
            MarketLedgerEntry.register,
            MktActivityRecord.register,
            MktConnectivityNode.register,
            MktLine.register,
            MktMeasurement.register,
            MktPowerTransformer.register,
            MktTerminal.register,
            MktUserAttribute.register
        )
    }
}