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
 * Credit/debit movements for an account.
 *
 * @param Element Reference to the superclass object.
 * @param amount Amount that was credited to/debited from an account.
 *        For example: payment received/interest charge on arrears.
 * @param dateTime Date and time when the credit/debit transaction was performed.
 * @param reason Reason for credit/debit transaction on an account.
 *        Example: payment received/arrears interest levied.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class AccountMovement
(
    Element: BasicElement = null,
    amount: Double = 0.0,
    dateTime: String = null,
    reason: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AccountMovement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccountMovement.fields (position), value)
        emitelem (0, amount)
        emitelem (1, dateTime)
        emitelem (2, reason)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccountMovement rdf:%s=\"%s\">\n%s\t</cim:AccountMovement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AccountMovement
extends
    CIMParseable[AccountMovement]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "dateTime",
        "reason"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val dateTime: Fielder = parse_element (element (cls, fields(1)))
    val reason: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): AccountMovement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccountMovement (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (dateTime (), 1),
            mask (reason (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AccountMovement] = AccountMovementSerializer
}

object AccountMovementSerializer extends CIMSerializer[AccountMovement]
{
    def write (kryo: Kryo, output: Output, obj: AccountMovement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount),
            () => output.writeString (obj.dateTime),
            () => output.writeString (obj.reason)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AccountMovement]): AccountMovement =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AccountMovement (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Unit for accounting; use either 'energyUnit' or 'currencyUnit' to specify the unit for 'value'.
 *
 * @param Element Reference to the superclass object.
 * @param energyUnit Unit of service.
 * @param monetaryUnit Unit of currency.
 * @param multiplier Multiplier for the 'energyUnit' or 'monetaryUnit'.
 * @param value Value expressed in applicable units.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class AccountingUnit
(
    Element: BasicElement = null,
    energyUnit: Double = 0.0,
    monetaryUnit: String = null,
    multiplier: String = null,
    value: Double = 0.0
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AccountingUnit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccountingUnit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccountingUnit.fields (position), value)
        emitelem (0, energyUnit)
        emitattr (1, monetaryUnit)
        emitattr (2, multiplier)
        emitelem (3, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccountingUnit rdf:%s=\"%s\">\n%s\t</cim:AccountingUnit>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AccountingUnit
extends
    CIMParseable[AccountingUnit]
{
    override val fields: Array[String] = Array[String] (
        "energyUnit",
        "monetaryUnit",
        "multiplier",
        "value"
    )
    val energyUnit: Fielder = parse_element (element (cls, fields(0)))
    val monetaryUnit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): AccountingUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccountingUnit (
            BasicElement.parse (context),
            toDouble (mask (energyUnit (), 0)),
            mask (monetaryUnit (), 1),
            mask (multiplier (), 2),
            toDouble (mask (value (), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AccountingUnit] = AccountingUnitSerializer
}

object AccountingUnitSerializer extends CIMSerializer[AccountingUnit]
{
    def write (kryo: Kryo, output: Output, obj: AccountingUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.energyUnit),
            () => output.writeString (obj.monetaryUnit),
            () => output.writeString (obj.multiplier),
            () => output.writeDouble (obj.value)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AccountingUnit]): AccountingUnit =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AccountingUnit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Variable and dynamic part of auxiliary agreement, generally representing the current state of the account related to the outstanding balance defined in auxiliary agreement.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param balance The total amount currently remaining on this account that is required to be paid in order to settle the account to zero.
 *        This excludes any due amounts not yet paid.
 * @param due [[ch.ninecode.model.Due Due]] Current amounts now due for payment on this account.
 * @param lastCredit [[ch.ninecode.model.AccountMovement AccountMovement]] Details of the last credit transaction performed on this account.
 * @param lastDebit [[ch.ninecode.model.AccountMovement AccountMovement]] Details of the last debit transaction performed on this account.
 * @param principleAmount The initial principle amount, with which this account was instantiated.
 * @param AuxiliaryAgreement [[ch.ninecode.model.AuxiliaryAgreement AuxiliaryAgreement]] Auxiliary agreement regulating this account.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges levied on this account.
 * @param PaymentTransactions [[ch.ninecode.model.Transaction Transaction]] All payments against this account.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class AuxiliaryAccount
(
    Document: Document = null,
    balance: Double = 0.0,
    due: String = null,
    lastCredit: String = null,
    lastDebit: String = null,
    principleAmount: Double = 0.0,
    AuxiliaryAgreement: String = null,
    Charges: List[String] = null,
    PaymentTransactions: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AuxiliaryAccount.fields (position), x))
        emitelem (0, balance)
        emitattr (1, due)
        emitattr (2, lastCredit)
        emitattr (3, lastDebit)
        emitelem (4, principleAmount)
        emitattr (5, AuxiliaryAgreement)
        emitattrs (6, Charges)
        emitattrs (7, PaymentTransactions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAccount rdf:%s=\"%s\">\n%s\t</cim:AuxiliaryAccount>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AuxiliaryAccount
extends
    CIMParseable[AuxiliaryAccount]
{
    override val fields: Array[String] = Array[String] (
        "balance",
        "due",
        "lastCredit",
        "lastDebit",
        "principleAmount",
        "AuxiliaryAgreement",
        "Charges",
        "PaymentTransactions"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("due", "Due", "0..1", "0..*"),
        CIMRelationship ("lastCredit", "AccountMovement", "0..1", "0..*"),
        CIMRelationship ("lastDebit", "AccountMovement", "0..1", "0..*"),
        CIMRelationship ("AuxiliaryAgreement", "AuxiliaryAgreement", "0..1", "1..*"),
        CIMRelationship ("Charges", "Charge", "0..*", "0..*"),
        CIMRelationship ("PaymentTransactions", "Transaction", "0..*", "0..1")
    )
    val balance: Fielder = parse_element (element (cls, fields(0)))
    val due: Fielder = parse_attribute (attribute (cls, fields(1)))
    val lastCredit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val lastDebit: Fielder = parse_attribute (attribute (cls, fields(3)))
    val principleAmount: Fielder = parse_element (element (cls, fields(4)))
    val AuxiliaryAgreement: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val PaymentTransactions: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): AuxiliaryAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryAccount (
            Document.parse (context),
            toDouble (mask (balance (), 0)),
            mask (due (), 1),
            mask (lastCredit (), 2),
            mask (lastDebit (), 3),
            toDouble (mask (principleAmount (), 4)),
            mask (AuxiliaryAgreement (), 5),
            masks (Charges (), 6),
            masks (PaymentTransactions (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AuxiliaryAccount] = AuxiliaryAccountSerializer
}

object AuxiliaryAccountSerializer extends CIMSerializer[AuxiliaryAccount]
{
    def write (kryo: Kryo, output: Output, obj: AuxiliaryAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.balance),
            () => output.writeString (obj.due),
            () => output.writeString (obj.lastCredit),
            () => output.writeString (obj.lastDebit),
            () => output.writeDouble (obj.principleAmount),
            () => output.writeString (obj.AuxiliaryAgreement),
            () => writeList (obj.Charges, output),
            () => writeList (obj.PaymentTransactions, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AuxiliaryAccount]): AuxiliaryAccount =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AuxiliaryAccount (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An ad-hoc auxiliary account agreement associated with a customer agreement, not part of the customer's account, but typically subject to formal agreement between customer and supplier (utility).
 *
 * Typically this is used to collect revenue owed by the customer for other services or arrears accrued with the utility for other services. It is typically linked to a prepaid token purchase transaction, thus forcing the customer to make a payment towards settlement of the auxiliary account balance whenever the customer needs to purchase a prepaid token for electricity.
 * The present status of the auxiliary agreement can be defined in the context of the utility's business rules, for example: enabled, disabled, pending, over recovered, under recovered, written off, etc.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param arrearsInterest The interest per annum to be charged prorata on 'AuxiliaryAccount.dueArrears' at the end of each 'payCycle'.
 * @param auxCycle The frequency for automatically recurring auxiliary charges, where 'AuxiliaryAccount.initialCharge' is recursively added to 'AuxiliaryAccount.dueCurrent' at the start of each 'auxCycle'.
 *        For example: on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc.
 * @param auxPriorityCode The coded priority indicating the priority that this auxiliary agreement has above other auxiliary agreements (associated with the same customer agreement) when it comes to competing for settlement from a payment transaction or token purchase.
 * @param fixedAmount The fixed amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param minAmount The minimum amount that has to be paid at any transaction towards settling this auxiliary agreement or reducing the balance.
 * @param payCycle The contractually expected payment frequency (by the customer).
 *        Examples are: ad-hoc; on specified date; hourly, daily, weekly, monthly. etc.
 * @param subType Sub-classification of the inherited 'type' for this AuxiliaryAgreement.
 * @param vendPortion The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are not in arrears.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param vendPortionArrear The percentage of the transaction amount that has to be collected from each vending transaction towards settlement of this auxiliary agreement when payments are in arrears.
 *        Note that there may be multiple tokens vended per vending transaction, but this is not relevant.
 * @param AuxiliaryAccounts [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] All auxiliary accounts regulated by this agreement.
 * @param CustomerAgreement [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] Customer agreement this (non-service related) auxiliary agreement refers to.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class AuxiliaryAgreement
(
    Agreement: Agreement = null,
    arrearsInterest: Double = 0.0,
    auxCycle: String = null,
    auxPriorityCode: String = null,
    fixedAmount: Double = 0.0,
    minAmount: Double = 0.0,
    payCycle: String = null,
    subType: String = null,
    vendPortion: Double = 0.0,
    vendPortionArrear: Double = 0.0,
    AuxiliaryAccounts: List[String] = null,
    CustomerAgreement: String = null
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
    override def sup: Agreement = Agreement

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AuxiliaryAgreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AuxiliaryAgreement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AuxiliaryAgreement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AuxiliaryAgreement.fields (position), x))
        emitelem (0, arrearsInterest)
        emitelem (1, auxCycle)
        emitelem (2, auxPriorityCode)
        emitelem (3, fixedAmount)
        emitelem (4, minAmount)
        emitelem (5, payCycle)
        emitelem (6, subType)
        emitelem (7, vendPortion)
        emitelem (8, vendPortionArrear)
        emitattrs (9, AuxiliaryAccounts)
        emitattr (10, CustomerAgreement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AuxiliaryAgreement rdf:%s=\"%s\">\n%s\t</cim:AuxiliaryAgreement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object AuxiliaryAgreement
extends
    CIMParseable[AuxiliaryAgreement]
{
    override val fields: Array[String] = Array[String] (
        "arrearsInterest",
        "auxCycle",
        "auxPriorityCode",
        "fixedAmount",
        "minAmount",
        "payCycle",
        "subType",
        "vendPortion",
        "vendPortionArrear",
        "AuxiliaryAccounts",
        "CustomerAgreement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AuxiliaryAccounts", "AuxiliaryAccount", "1..*", "0..1"),
        CIMRelationship ("CustomerAgreement", "CustomerAgreement", "0..1", "0..*")
    )
    val arrearsInterest: Fielder = parse_element (element (cls, fields(0)))
    val auxCycle: Fielder = parse_element (element (cls, fields(1)))
    val auxPriorityCode: Fielder = parse_element (element (cls, fields(2)))
    val fixedAmount: Fielder = parse_element (element (cls, fields(3)))
    val minAmount: Fielder = parse_element (element (cls, fields(4)))
    val payCycle: Fielder = parse_element (element (cls, fields(5)))
    val subType: Fielder = parse_element (element (cls, fields(6)))
    val vendPortion: Fielder = parse_element (element (cls, fields(7)))
    val vendPortionArrear: Fielder = parse_element (element (cls, fields(8)))
    val AuxiliaryAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val CustomerAgreement: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): AuxiliaryAgreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AuxiliaryAgreement (
            Agreement.parse (context),
            toDouble (mask (arrearsInterest (), 0)),
            mask (auxCycle (), 1),
            mask (auxPriorityCode (), 2),
            toDouble (mask (fixedAmount (), 3)),
            toDouble (mask (minAmount (), 4)),
            mask (payCycle (), 5),
            mask (subType (), 6),
            toDouble (mask (vendPortion (), 7)),
            toDouble (mask (vendPortionArrear (), 8)),
            masks (AuxiliaryAccounts (), 9),
            mask (CustomerAgreement (), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AuxiliaryAgreement] = AuxiliaryAgreementSerializer
}

object AuxiliaryAgreementSerializer extends CIMSerializer[AuxiliaryAgreement]
{
    def write (kryo: Kryo, output: Output, obj: AuxiliaryAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.arrearsInterest),
            () => output.writeString (obj.auxCycle),
            () => output.writeString (obj.auxPriorityCode),
            () => output.writeDouble (obj.fixedAmount),
            () => output.writeDouble (obj.minAmount),
            () => output.writeString (obj.payCycle),
            () => output.writeString (obj.subType),
            () => output.writeDouble (obj.vendPortion),
            () => output.writeDouble (obj.vendPortionArrear),
            () => writeList (obj.AuxiliaryAccounts, output),
            () => output.writeString (obj.CustomerAgreement)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AuxiliaryAgreement]): AuxiliaryAgreement =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AuxiliaryAgreement (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details of a bank account.
 *
 * @param Element Reference to the superclass object.
 * @param accountNumber Operational account reference number.
 * @param bankName Name of bank where account is held.
 * @param branchCode Branch of bank where account is held.
 * @param holderID National identity number (or equivalent) of account holder.
 * @param holderName Name of account holder.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class BankAccountDetail
(
    Element: BasicElement = null,
    accountNumber: String = null,
    bankName: String = null,
    branchCode: String = null,
    holderID: String = null,
    holderName: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BankAccountDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BankAccountDetail.fields (position), value)
        emitelem (0, accountNumber)
        emitelem (1, bankName)
        emitelem (2, branchCode)
        emitelem (3, holderID)
        emitelem (4, holderName)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BankAccountDetail rdf:%s=\"%s\">\n%s\t</cim:BankAccountDetail>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BankAccountDetail
extends
    CIMParseable[BankAccountDetail]
{
    override val fields: Array[String] = Array[String] (
        "accountNumber",
        "bankName",
        "branchCode",
        "holderID",
        "holderName"
    )
    val accountNumber: Fielder = parse_element (element (cls, fields(0)))
    val bankName: Fielder = parse_element (element (cls, fields(1)))
    val branchCode: Fielder = parse_element (element (cls, fields(2)))
    val holderID: Fielder = parse_element (element (cls, fields(3)))
    val holderName: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): BankAccountDetail =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BankAccountDetail (
            BasicElement.parse (context),
            mask (accountNumber (), 0),
            mask (bankName (), 1),
            mask (branchCode (), 2),
            mask (holderID (), 3),
            mask (holderName (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BankAccountDetail] = BankAccountDetailSerializer
}

object BankAccountDetailSerializer extends CIMSerializer[BankAccountDetail]
{
    def write (kryo: Kryo, output: Output, obj: BankAccountDetail): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accountNumber),
            () => output.writeString (obj.bankName),
            () => output.writeString (obj.branchCode),
            () => output.writeString (obj.holderID),
            () => output.writeString (obj.holderName)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BankAccountDetail]): BankAccountDetail =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BankAccountDetail (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Documentation of the tender when it is a type of card (credit, debit, etc).
 *
 * @param Element Reference to the superclass object.
 * @param accountHolderName Name of account holder.
 * @param cvNumber The card verification number.
 * @param expiryDate The date when this card expires.
 * @param pan The primary account number.
 * @param Tender [[ch.ninecode.model.Tender Tender]] Payment tender this card is being used for.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Card
(
    Element: BasicElement = null,
    accountHolderName: String = null,
    cvNumber: String = null,
    expiryDate: String = null,
    pan: String = null,
    Tender: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Card.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Card.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Card.fields (position), value)
        emitelem (0, accountHolderName)
        emitelem (1, cvNumber)
        emitelem (2, expiryDate)
        emitelem (3, pan)
        emitattr (4, Tender)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Card rdf:%s=\"%s\">\n%s\t</cim:Card>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Card
extends
    CIMParseable[Card]
{
    override val fields: Array[String] = Array[String] (
        "accountHolderName",
        "cvNumber",
        "expiryDate",
        "pan",
        "Tender"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Tender", "Tender", "1", "0..1")
    )
    val accountHolderName: Fielder = parse_element (element (cls, fields(0)))
    val cvNumber: Fielder = parse_element (element (cls, fields(1)))
    val expiryDate: Fielder = parse_element (element (cls, fields(2)))
    val pan: Fielder = parse_element (element (cls, fields(3)))
    val Tender: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): Card =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Card (
            BasicElement.parse (context),
            mask (accountHolderName (), 0),
            mask (cvNumber (), 1),
            mask (expiryDate (), 2),
            mask (pan (), 3),
            mask (Tender (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Card] = CardSerializer
}

object CardSerializer extends CIMSerializer[Card]
{
    def write (kryo: Kryo, output: Output, obj: Card): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accountHolderName),
            () => output.writeString (obj.cvNumber),
            () => output.writeString (obj.expiryDate),
            () => output.writeString (obj.pan),
            () => output.writeString (obj.Tender)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Card]): Card =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Card (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The operator of the point of sale for the duration of CashierShift.
 *
 * Cashier is under the exclusive management control of Vendor.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param electronicAddress Electronic address.
 * @param CashierShifts [[ch.ninecode.model.CashierShift CashierShift]] All shifts operated by this cashier.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Cashier
(
    IdentifiedObject: IdentifiedObject = null,
    electronicAddress: String = null,
    CashierShifts: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Cashier.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Cashier.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Cashier.fields (position), x))
        emitattr (0, electronicAddress)
        emitattrs (1, CashierShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cashier rdf:%s=\"%s\">\n%s\t</cim:Cashier>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Cashier
extends
    CIMParseable[Cashier]
{
    override val fields: Array[String] = Array[String] (
        "electronicAddress",
        "CashierShifts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CashierShifts", "CashierShift", "0..*", "0..1")
    )
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CashierShifts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Cashier =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Cashier (
            IdentifiedObject.parse (context),
            mask (electronicAddress (), 0),
            masks (CashierShifts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Cashier] = CashierSerializer
}

object CashierSerializer extends CIMSerializer[Cashier]
{
    def write (kryo: Kryo, output: Output, obj: Cashier): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.electronicAddress),
            () => writeList (obj.CashierShifts, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Cashier]): Cashier =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Cashier (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The operating shift for a cashier, during which the cashier may transact against the cashier shift, subject to vendor shift being open.
 *
 * @param Shift [[ch.ninecode.model.Shift Shift]] Reference to the superclass object.
 * @param cashFloat The amount of cash that the cashier brings to start the shift and that will be taken away at the end of the shift; i.e. the cash float does not get banked.
 * @param Cashier [[ch.ninecode.model.Cashier Cashier]] Cashier operating this shift.
 * @param PointOfSale [[ch.ninecode.model.PointOfSale PointOfSale]] Point of sale that is in operation during this shift.
 * @param Receipts [[ch.ninecode.model.Receipt Receipt]] All Receipts recorded for this Shift.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded during this cashier shift.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class CashierShift
(
    Shift: Shift = null,
    cashFloat: Double = 0.0,
    Cashier: String = null,
    PointOfSale: String = null,
    Receipts: List[String] = null,
    Transactions: List[String] = null
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
    override def sup: Shift = Shift

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CashierShift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CashierShift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CashierShift.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CashierShift.fields (position), x))
        emitelem (0, cashFloat)
        emitattr (1, Cashier)
        emitattr (2, PointOfSale)
        emitattrs (3, Receipts)
        emitattrs (4, Transactions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CashierShift rdf:%s=\"%s\">\n%s\t</cim:CashierShift>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object CashierShift
extends
    CIMParseable[CashierShift]
{
    override val fields: Array[String] = Array[String] (
        "cashFloat",
        "Cashier",
        "PointOfSale",
        "Receipts",
        "Transactions"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Cashier", "Cashier", "0..1", "0..*"),
        CIMRelationship ("PointOfSale", "PointOfSale", "0..1", "0..*"),
        CIMRelationship ("Receipts", "Receipt", "0..*", "0..1"),
        CIMRelationship ("Transactions", "Transaction", "0..*", "0..1")
    )
    val cashFloat: Fielder = parse_element (element (cls, fields(0)))
    val Cashier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PointOfSale: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Receipts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): CashierShift =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CashierShift (
            Shift.parse (context),
            toDouble (mask (cashFloat (), 0)),
            mask (Cashier (), 1),
            mask (PointOfSale (), 2),
            masks (Receipts (), 3),
            masks (Transactions (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CashierShift] = CashierShiftSerializer
}

object CashierShiftSerializer extends CIMSerializer[CashierShift]
{
    def write (kryo: Kryo, output: Output, obj: CashierShift): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.cashFloat),
            () => output.writeString (obj.Cashier),
            () => output.writeString (obj.PointOfSale),
            () => writeList (obj.Receipts, output),
            () => writeList (obj.Transactions, output)
        )
        ShiftSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CashierShift]): CashierShift =
    {
        val parent = ShiftSerializer.read (kryo, input, classOf[Shift])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CashierShift (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A charge element associated with other entities such as tariff structures, auxiliary agreements or other charge elements.
 *
 * The total charge amount applicable to this instance of charge is the sum of fixed and variable portion.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param fixedPortion [[ch.ninecode.model.AccountingUnit AccountingUnit]] The fixed portion of this charge element.
 * @param kind The kind of charge to be applied.
 * @param variablePortion The variable portion of this charge element, calculated as a percentage of the total amount of a parent charge.
 * @param AuxiliaryAccounts [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] All auxiliary accounts to which this charge has to be levied.
 * @param ChildCharges [[ch.ninecode.model.Charge Charge]] All sub-components of this complex charge.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] Tariff intervals to which this consumption-based charge has to be levied.
 * @param ParentCharge [[ch.ninecode.model.Charge Charge]] Parent of this charge sub-component.
 * @param TimeTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] Tariff intervals to which this time-based charge has to be levied.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Charge
(
    IdentifiedObject: IdentifiedObject = null,
    fixedPortion: String = null,
    kind: String = null,
    variablePortion: Double = 0.0,
    AuxiliaryAccounts: List[String] = null,
    ChildCharges: List[String] = null,
    ConsumptionTariffIntervals: List[String] = null,
    ParentCharge: String = null,
    TimeTariffIntervals: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Charge.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Charge.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Charge.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Charge.fields (position), x))
        emitattr (0, fixedPortion)
        emitattr (1, kind)
        emitelem (2, variablePortion)
        emitattrs (3, AuxiliaryAccounts)
        emitattrs (4, ChildCharges)
        emitattrs (5, ConsumptionTariffIntervals)
        emitattr (6, ParentCharge)
        emitattrs (7, TimeTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Charge rdf:%s=\"%s\">\n%s\t</cim:Charge>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Charge
extends
    CIMParseable[Charge]
{
    override val fields: Array[String] = Array[String] (
        "fixedPortion",
        "kind",
        "variablePortion",
        "AuxiliaryAccounts",
        "ChildCharges",
        "ConsumptionTariffIntervals",
        "ParentCharge",
        "TimeTariffIntervals"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("fixedPortion", "AccountingUnit", "0..1", "0..*"),
        CIMRelationship ("AuxiliaryAccounts", "AuxiliaryAccount", "0..*", "0..*"),
        CIMRelationship ("ChildCharges", "Charge", "0..*", "0..1"),
        CIMRelationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        CIMRelationship ("ParentCharge", "Charge", "0..1", "0..*"),
        CIMRelationship ("TimeTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val fixedPortion: Fielder = parse_attribute (attribute (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val variablePortion: Fielder = parse_element (element (cls, fields(2)))
    val AuxiliaryAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ChildCharges: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val ParentCharge: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TimeTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): Charge =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Charge (
            IdentifiedObject.parse (context),
            mask (fixedPortion (), 0),
            mask (kind (), 1),
            toDouble (mask (variablePortion (), 2)),
            masks (AuxiliaryAccounts (), 3),
            masks (ChildCharges (), 4),
            masks (ConsumptionTariffIntervals (), 5),
            mask (ParentCharge (), 6),
            masks (TimeTariffIntervals (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Charge] = ChargeSerializer
}

object ChargeSerializer extends CIMSerializer[Charge]
{
    def write (kryo: Kryo, output: Output, obj: Charge): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.fixedPortion),
            () => output.writeString (obj.kind),
            () => output.writeDouble (obj.variablePortion),
            () => writeList (obj.AuxiliaryAccounts, output),
            () => writeList (obj.ChildCharges, output),
            () => writeList (obj.ConsumptionTariffIntervals, output),
            () => output.writeString (obj.ParentCharge),
            () => writeList (obj.TimeTariffIntervals, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Charge]): Charge =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Charge (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The actual tender when it is a type of cheque.
 *
 * @param Element Reference to the superclass object.
 * @param bankAccountDetail [[ch.ninecode.model.BankAccountDetail BankAccountDetail]] Details of the account holder and bank.
 * @param chequeNumber Cheque reference number as printed on the cheque.
 * @param date Date when cheque becomes valid.
 * @param kind Kind of cheque.
 * @param micrNumber The magnetic ink character recognition number printed on the cheque.
 * @param Tender [[ch.ninecode.model.Tender Tender]] Payment tender the cheque is being used for.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Cheque
(
    Element: BasicElement = null,
    bankAccountDetail: String = null,
    chequeNumber: String = null,
    date: String = null,
    kind: String = null,
    micrNumber: String = null,
    Tender: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Cheque.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Cheque.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Cheque.fields (position), value)
        emitattr (0, bankAccountDetail)
        emitelem (1, chequeNumber)
        emitelem (2, date)
        emitattr (3, kind)
        emitelem (4, micrNumber)
        emitattr (5, Tender)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cheque rdf:%s=\"%s\">\n%s\t</cim:Cheque>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Cheque
extends
    CIMParseable[Cheque]
{
    override val fields: Array[String] = Array[String] (
        "bankAccountDetail",
        "chequeNumber",
        "date",
        "kind",
        "micrNumber",
        "Tender"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("bankAccountDetail", "BankAccountDetail", "0..1", "0..*"),
        CIMRelationship ("Tender", "Tender", "1", "0..1")
    )
    val bankAccountDetail: Fielder = parse_attribute (attribute (cls, fields(0)))
    val chequeNumber: Fielder = parse_element (element (cls, fields(1)))
    val date: Fielder = parse_element (element (cls, fields(2)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val micrNumber: Fielder = parse_element (element (cls, fields(4)))
    val Tender: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): Cheque =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Cheque (
            BasicElement.parse (context),
            mask (bankAccountDetail (), 0),
            mask (chequeNumber (), 1),
            mask (date (), 2),
            mask (kind (), 3),
            mask (micrNumber (), 4),
            mask (Tender (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Cheque] = ChequeSerializer
}

object ChequeSerializer extends CIMSerializer[Cheque]
{
    def write (kryo: Kryo, output: Output, obj: Cheque): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.bankAccountDetail),
            () => output.writeString (obj.chequeNumber),
            () => output.writeString (obj.date),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.micrNumber),
            () => output.writeString (obj.Tender)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Cheque]): Cheque =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Cheque (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * One of a sequence of intervals defined in terms of consumption quantity of a service such as electricity, water, gas, etc.
 *
 * It is typically used in association with TariffProfile to define the steps or blocks in a step tariff structure, where startValue simultaneously defines the entry value of this step and the closing value of the previous step. Where consumption is >= startValue it falls within this interval and where consumption is < startValue it falls within the previous interval.
 *
 * @param Element Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startValue The lowest level of consumption that defines the starting point of this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges used to define this consumption tariff interval.
 * @param ReadingType [[ch.ninecode.model.ReadingType ReadingType]] Reading type for 'startValue'.
 * @param TariffProfiles [[ch.ninecode.model.TariffProfile TariffProfile]] All tariff profiles defined by this consumption tariff interval.
 * @param TouTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] All time of use tariff intervals influenced by this consumption tariff interval.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class ConsumptionTariffInterval
(
    Element: BasicElement = null,
    sequenceNumber: Int = 0,
    startValue: Double = 0.0,
    Charges: List[String] = null,
    ReadingType: String = null,
    TariffProfiles: List[String] = null,
    TouTariffIntervals: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConsumptionTariffInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConsumptionTariffInterval.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConsumptionTariffInterval.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConsumptionTariffInterval.fields (position), x))
        emitelem (0, sequenceNumber)
        emitelem (1, startValue)
        emitattrs (2, Charges)
        emitattr (3, ReadingType)
        emitattrs (4, TariffProfiles)
        emitattrs (5, TouTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConsumptionTariffInterval rdf:%s=\"%s\">\n%s\t</cim:ConsumptionTariffInterval>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ConsumptionTariffInterval
extends
    CIMParseable[ConsumptionTariffInterval]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "startValue",
        "Charges",
        "ReadingType",
        "TariffProfiles",
        "TouTariffIntervals"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Charges", "Charge", "0..*", "0..*"),
        CIMRelationship ("ReadingType", "ReadingType", "0..1", "0..*"),
        CIMRelationship ("TariffProfiles", "TariffProfile", "0..*", "0..*"),
        CIMRelationship ("TouTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val startValue: Fielder = parse_element (element (cls, fields(1)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ReadingType: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TouTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): ConsumptionTariffInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConsumptionTariffInterval (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (startValue (), 1)),
            masks (Charges (), 2),
            mask (ReadingType (), 3),
            masks (TariffProfiles (), 4),
            masks (TouTariffIntervals (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConsumptionTariffInterval] = ConsumptionTariffIntervalSerializer
}

object ConsumptionTariffIntervalSerializer extends CIMSerializer[ConsumptionTariffInterval]
{
    def write (kryo: Kryo, output: Output, obj: ConsumptionTariffInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeDouble (obj.startValue),
            () => writeList (obj.Charges, output),
            () => output.writeString (obj.ReadingType),
            () => writeList (obj.TariffProfiles, output),
            () => writeList (obj.TouTariffIntervals, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConsumptionTariffInterval]): ConsumptionTariffInterval =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConsumptionTariffInterval (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details on amounts due for an account.
 *
 * @param Element Reference to the superclass object.
 * @param arrears Part of 'current' that constitutes the arrears portion.
 * @param charges Part of 'current' that constitutes the charge portion: 'charges' = 'Charge.fixedPortion' + 'Charge.variablePortion'.
 * @param current Current total amount now due: current = principle + arrears + interest + charges.
 *        Typically the rule for settlement priority is: interest dues, then arrears dues, then current dues, then charge dues.
 * @param interest Part of 'current' that constitutes the interest portion.
 * @param principle Part of 'current' that constitutes the portion of the principle amount currently due.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Due
(
    Element: BasicElement = null,
    arrears: Double = 0.0,
    charges: Double = 0.0,
    current: Double = 0.0,
    interest: Double = 0.0,
    principle: Double = 0.0
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Due.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Due.fields (position), value)
        emitelem (0, arrears)
        emitelem (1, charges)
        emitelem (2, current)
        emitelem (3, interest)
        emitelem (4, principle)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Due rdf:%s=\"%s\">\n%s\t</cim:Due>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Due
extends
    CIMParseable[Due]
{
    override val fields: Array[String] = Array[String] (
        "arrears",
        "charges",
        "current",
        "interest",
        "principle"
    )
    val arrears: Fielder = parse_element (element (cls, fields(0)))
    val charges: Fielder = parse_element (element (cls, fields(1)))
    val current: Fielder = parse_element (element (cls, fields(2)))
    val interest: Fielder = parse_element (element (cls, fields(3)))
    val principle: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): Due =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Due (
            BasicElement.parse (context),
            toDouble (mask (arrears (), 0)),
            toDouble (mask (charges (), 1)),
            toDouble (mask (current (), 2)),
            toDouble (mask (interest (), 3)),
            toDouble (mask (principle (), 4))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Due] = DueSerializer
}

object DueSerializer extends CIMSerializer[Due]
{
    def write (kryo: Kryo, output: Output, obj: Due): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.arrears),
            () => output.writeDouble (obj.charges),
            () => output.writeDouble (obj.current),
            () => output.writeDouble (obj.interest),
            () => output.writeDouble (obj.principle)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Due]): Due =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Due (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Details on an amount line, with rounding, date and note.
 *
 * @param Element Reference to the superclass object.
 * @param amount Amount for this line item.
 * @param dateTime Date and time when this line was created in the application process.
 * @param note Free format note relevant to this line.
 * @param rounding Totalised monetary value of all errors due to process rounding or truncating that is not reflected in 'amount'.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class LineDetail
(
    Element: BasicElement = null,
    amount: Double = 0.0,
    dateTime: String = null,
    note: String = null,
    rounding: Double = 0.0
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LineDetail.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LineDetail.fields (position), value)
        emitelem (0, amount)
        emitelem (1, dateTime)
        emitelem (2, note)
        emitelem (3, rounding)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LineDetail rdf:%s=\"%s\">\n%s\t</cim:LineDetail>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object LineDetail
extends
    CIMParseable[LineDetail]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "dateTime",
        "note",
        "rounding"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val dateTime: Fielder = parse_element (element (cls, fields(1)))
    val note: Fielder = parse_element (element (cls, fields(2)))
    val rounding: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): LineDetail =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LineDetail (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (dateTime (), 1),
            mask (note (), 2),
            toDouble (mask (rounding (), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LineDetail] = LineDetailSerializer
}

object LineDetailSerializer extends CIMSerializer[LineDetail]
{
    def write (kryo: Kryo, output: Output, obj: LineDetail): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount),
            () => output.writeString (obj.dateTime),
            () => output.writeString (obj.note),
            () => output.writeDouble (obj.rounding)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LineDetail]): LineDetail =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LineDetail (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The operating account controlled by merchant agreement, against which the vendor may vend tokens or receipt payments.
 *
 * Transactions via vendor shift debit the account and bank deposits via bank statement credit the account.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param currentBalance The current operating balance of this account.
 * @param provisionalBalance The balance of this account after taking into account any pending debits from VendorShift.merchantDebitAmount and pending credits from BankStatement.merchantCreditAmount or credits (see also BankStatement attributes and VendorShift attributes).
 * @param MerchantAgreement [[ch.ninecode.model.MerchantAgreement MerchantAgreement]] Merchant agreement that instantiated this merchant account.
 * @param Transactors [[ch.ninecode.model.Transactor Transactor]] All transactors this merchant account is registered with.
 * @param VendorShifts [[ch.ninecode.model.VendorShift VendorShift]] All vendor shifts that operate on this merchant account.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class MerchantAccount
(
    Document: Document = null,
    currentBalance: Double = 0.0,
    provisionalBalance: Double = 0.0,
    MerchantAgreement: String = null,
    Transactors: List[String] = null,
    VendorShifts: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MerchantAccount.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MerchantAccount.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MerchantAccount.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MerchantAccount.fields (position), x))
        emitelem (0, currentBalance)
        emitelem (1, provisionalBalance)
        emitattr (2, MerchantAgreement)
        emitattrs (3, Transactors)
        emitattrs (4, VendorShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MerchantAccount rdf:%s=\"%s\">\n%s\t</cim:MerchantAccount>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MerchantAccount
extends
    CIMParseable[MerchantAccount]
{
    override val fields: Array[String] = Array[String] (
        "currentBalance",
        "provisionalBalance",
        "MerchantAgreement",
        "Transactors",
        "VendorShifts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MerchantAgreement", "MerchantAgreement", "0..1", "0..*"),
        CIMRelationship ("Transactors", "Transactor", "0..*", "0..*"),
        CIMRelationship ("VendorShifts", "VendorShift", "0..*", "0..1")
    )
    val currentBalance: Fielder = parse_element (element (cls, fields(0)))
    val provisionalBalance: Fielder = parse_element (element (cls, fields(1)))
    val MerchantAgreement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Transactors: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val VendorShifts: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): MerchantAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MerchantAccount (
            Document.parse (context),
            toDouble (mask (currentBalance (), 0)),
            toDouble (mask (provisionalBalance (), 1)),
            mask (MerchantAgreement (), 2),
            masks (Transactors (), 3),
            masks (VendorShifts (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MerchantAccount] = MerchantAccountSerializer
}

object MerchantAccountSerializer extends CIMSerializer[MerchantAccount]
{
    def write (kryo: Kryo, output: Output, obj: MerchantAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.currentBalance),
            () => output.writeDouble (obj.provisionalBalance),
            () => output.writeString (obj.MerchantAgreement),
            () => writeList (obj.Transactors, output),
            () => writeList (obj.VendorShifts, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MerchantAccount]): MerchantAccount =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MerchantAccount (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A formal controlling contractual agreement between supplier and merchant, in terms of which the merchant is authorised to vend tokens and receipt payments on behalf of the supplier.
 *
 * The merchant is accountable to the supplier for revenue collected at point of sale.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param MerchantAccounts [[ch.ninecode.model.MerchantAccount MerchantAccount]] All merchant accounts instantiated as a result of this merchant agreement.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class MerchantAgreement
(
    Agreement: Agreement = null,
    MerchantAccounts: List[String] = null
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
    override def sup: Agreement = Agreement

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MerchantAgreement.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MerchantAgreement.fields (position), x))
        emitattrs (0, MerchantAccounts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MerchantAgreement rdf:%s=\"%s\">\n%s\t</cim:MerchantAgreement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object MerchantAgreement
extends
    CIMParseable[MerchantAgreement]
{
    override val fields: Array[String] = Array[String] (
        "MerchantAccounts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MerchantAccounts", "MerchantAccount", "0..*", "0..1")
    )
    val MerchantAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): MerchantAgreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MerchantAgreement (
            Agreement.parse (context),
            masks (MerchantAccounts (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MerchantAgreement] = MerchantAgreementSerializer
}

object MerchantAgreementSerializer extends CIMSerializer[MerchantAgreement]
{
    def write (kryo: Kryo, output: Output, obj: MerchantAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.MerchantAccounts, output)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MerchantAgreement]): MerchantAgreement =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MerchantAgreement (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Logical point where transactions take place with operational interaction between cashier and the payment system; in certain cases the point of sale interacts directly with the end customer, in which case the cashier might not be a real person: for example a self-service kiosk or over the internet.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param location Local description for where this point of sale is physically located.
 * @param CashierShifts [[ch.ninecode.model.CashierShift CashierShift]] All shifts this point of sale operated in.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class PointOfSale
(
    IdentifiedObject: IdentifiedObject = null,
    location: String = null,
    CashierShifts: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PointOfSale.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PointOfSale.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PointOfSale.fields (position), x))
        emitelem (0, location)
        emitattrs (1, CashierShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PointOfSale rdf:%s=\"%s\">\n%s\t</cim:PointOfSale>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PointOfSale
extends
    CIMParseable[PointOfSale]
{
    override val fields: Array[String] = Array[String] (
        "location",
        "CashierShifts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CashierShifts", "CashierShift", "0..*", "0..1")
    )
    val location: Fielder = parse_element (element (cls, fields(0)))
    val CashierShifts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PointOfSale =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PointOfSale (
            IdentifiedObject.parse (context),
            mask (location (), 0),
            masks (CashierShifts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PointOfSale] = PointOfSaleSerializer
}

object PointOfSaleSerializer extends CIMSerializer[PointOfSale]
{
    def write (kryo: Kryo, output: Output, obj: PointOfSale): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.location),
            () => writeList (obj.CashierShifts, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PointOfSale]): PointOfSale =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PointOfSale (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Record of total receipted payment from customer.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isBankable True if this receipted payment is manually bankable, otherwise it is an electronic funds transfer.
 * @param line [[ch.ninecode.model.LineDetail LineDetail]] Receipted amount with rounding, date and note.
 * @param CashierShift [[ch.ninecode.model.CashierShift CashierShift]] Cashier shift during which this receipt was recorded.
 * @param Tenders [[ch.ninecode.model.Tender Tender]] All payments received in the form of tenders recorded by this receipt.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded for this receipted payment.
 * @param VendorShift [[ch.ninecode.model.VendorShift VendorShift]] Vendor shift during which this receipt was recorded.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Receipt
(
    IdentifiedObject: IdentifiedObject = null,
    isBankable: Boolean = false,
    line: String = null,
    CashierShift: String = null,
    Tenders: List[String] = null,
    Transactions: List[String] = null,
    VendorShift: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Receipt.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Receipt.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Receipt.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Receipt.fields (position), x))
        emitelem (0, isBankable)
        emitattr (1, line)
        emitattr (2, CashierShift)
        emitattrs (3, Tenders)
        emitattrs (4, Transactions)
        emitattr (5, VendorShift)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Receipt rdf:%s=\"%s\">\n%s\t</cim:Receipt>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Receipt
extends
    CIMParseable[Receipt]
{
    override val fields: Array[String] = Array[String] (
        "isBankable",
        "line",
        "CashierShift",
        "Tenders",
        "Transactions",
        "VendorShift"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("line", "LineDetail", "0..1", "0..*"),
        CIMRelationship ("CashierShift", "CashierShift", "0..1", "0..*"),
        CIMRelationship ("Tenders", "Tender", "1..*", "1"),
        CIMRelationship ("Transactions", "Transaction", "1..*", "0..1"),
        CIMRelationship ("VendorShift", "VendorShift", "0..1", "0..*")
    )
    val isBankable: Fielder = parse_element (element (cls, fields(0)))
    val line: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CashierShift: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Tenders: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val VendorShift: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): Receipt =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Receipt (
            IdentifiedObject.parse (context),
            toBoolean (mask (isBankable (), 0)),
            mask (line (), 1),
            mask (CashierShift (), 2),
            masks (Tenders (), 3),
            masks (Transactions (), 4),
            mask (VendorShift (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Receipt] = ReceiptSerializer
}

object ReceiptSerializer extends CIMSerializer[Receipt]
{
    def write (kryo: Kryo, output: Output, obj: Receipt): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.isBankable),
            () => output.writeString (obj.line),
            () => output.writeString (obj.CashierShift),
            () => writeList (obj.Tenders, output),
            () => writeList (obj.Transactions, output),
            () => output.writeString (obj.VendorShift)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Receipt]): Receipt =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Receipt (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation that provides services to customers.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param issuerIdentificationNumber Unique transaction reference prefix number issued to an entity by the International Organization for Standardization for the purpose of tagging onto electronic financial transactions, as defined in ISO/IEC 7812-1 and ISO/IEC 7812-2.
 * @param kind Kind of supplier.
 * @param BankAccounts [[ch.ninecode.model.BankAccount BankAccount]] All BackAccounts this ServiceSupplier owns.
 * @param CustomerAgreements [[ch.ninecode.model.CustomerAgreement CustomerAgreement]] All customer agreements of this service supplier.
 * @param UsagePoints [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points this service supplier utilises to deliver a service.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class ServiceSupplier
(
    OrganisationRole: OrganisationRole = null,
    issuerIdentificationNumber: String = null,
    kind: String = null,
    BankAccounts: List[String] = null,
    CustomerAgreements: List[String] = null,
    UsagePoints: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ServiceSupplier.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServiceSupplier.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ServiceSupplier.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ServiceSupplier.fields (position), x))
        emitelem (0, issuerIdentificationNumber)
        emitattr (1, kind)
        emitattrs (2, BankAccounts)
        emitattrs (3, CustomerAgreements)
        emitattrs (4, UsagePoints)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServiceSupplier rdf:%s=\"%s\">\n%s\t</cim:ServiceSupplier>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ServiceSupplier
extends
    CIMParseable[ServiceSupplier]
{
    override val fields: Array[String] = Array[String] (
        "issuerIdentificationNumber",
        "kind",
        "BankAccounts",
        "CustomerAgreements",
        "UsagePoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BankAccounts", "BankAccount", "0..*", "0..1"),
        CIMRelationship ("CustomerAgreements", "CustomerAgreement", "0..*", "1"),
        CIMRelationship ("UsagePoints", "UsagePoint", "0..*", "0..1")
    )
    val issuerIdentificationNumber: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val BankAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val CustomerAgreements: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): ServiceSupplier =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServiceSupplier (
            OrganisationRole.parse (context),
            mask (issuerIdentificationNumber (), 0),
            mask (kind (), 1),
            masks (BankAccounts (), 2),
            masks (CustomerAgreements (), 3),
            masks (UsagePoints (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ServiceSupplier] = ServiceSupplierSerializer
}

object ServiceSupplierSerializer extends CIMSerializer[ServiceSupplier]
{
    def write (kryo: Kryo, output: Output, obj: ServiceSupplier): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.issuerIdentificationNumber),
            () => output.writeString (obj.kind),
            () => writeList (obj.BankAccounts, output),
            () => writeList (obj.CustomerAgreements, output),
            () => writeList (obj.UsagePoints, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ServiceSupplier]): ServiceSupplier =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ServiceSupplier (
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
 * Generally referring to a period of operation or work performed.
 *
 * Whether the shift is open/closed can be derived from attributes 'activityInterval.start' and 'activityInterval.end'.
 * The grand total for receipts (i.e., cumulative total of all actual receipted amounts during this shift; bankable + non-bankable; excludes rounding error totals) can be derived from receipt:
 * &equals;sum('Receipt.receiptAmount'); includes bankable and non-bankable receipts.
 * It also has to be reconciled against:
 * &equals;sum('receiptsGrandTotalBankable' + 'receiptsGrandTotalNonBankable')
 * and against receipt summary:
 * &equals;sum('ReceiptSummary.receiptsTotal').
 * The attributes with "GrandTotal" defined in this class may need to be used when the source data is periodically flushed from the system and then these cannot be derived.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param activityInterval Interval for activity of this shift.
 * @param receiptsGrandTotalBankable Total of amounts receipted during this shift that can be manually banked (cash and cheques for example).
 *        Values are obtained from Receipt attributes:
 *        &equals;sum(Receipt.receiptAmount) for all Receipt.bankable = true.
 * @param receiptsGrandTotalNonBankable Total of amounts receipted during this shift that cannot be manually banked (card payments for example).
 *        Values are obtained from Receipt attributes:
 *        &equals;sum(Receipt.receiptAmount) for all Receipt.bankable = false.
 * @param receiptsGrandTotalRounding Cumulative amount in error due to process rounding not reflected in receiptsGrandTotal.
 *        Values are obtained from Receipt attributes:
 *        &equals;sum(Receipt.receiptRounding).
 * @param transactionsGrandTotal Cumulative total of transacted amounts during this shift.
 *        Values are obtained from transaction:
 *        &equals;sum('Transaction.transactionAmount'). It also has to be reconciled against transaction summary:
 *        &equals;sum('TransactionSummary.transactionsTotal').
 * @param transactionsGrandTotalRounding Cumulative amount in error due to process rounding not reflected in transactionsGandTotal.
 *        Values are obtained from Transaction attributes:
 *        &equals;sum(Transaction.transactionRounding).
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Shift
(
    IdentifiedObject: IdentifiedObject = null,
    activityInterval: String = null,
    receiptsGrandTotalBankable: Double = 0.0,
    receiptsGrandTotalNonBankable: Double = 0.0,
    receiptsGrandTotalRounding: Double = 0.0,
    transactionsGrandTotal: Double = 0.0,
    transactionsGrandTotalRounding: Double = 0.0
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Shift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Shift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Shift.fields (position), value)
        emitattr (0, activityInterval)
        emitelem (1, receiptsGrandTotalBankable)
        emitelem (2, receiptsGrandTotalNonBankable)
        emitelem (3, receiptsGrandTotalRounding)
        emitelem (4, transactionsGrandTotal)
        emitelem (5, transactionsGrandTotalRounding)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Shift rdf:%s=\"%s\">\n%s\t</cim:Shift>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Shift
extends
    CIMParseable[Shift]
{
    override val fields: Array[String] = Array[String] (
        "activityInterval",
        "receiptsGrandTotalBankable",
        "receiptsGrandTotalNonBankable",
        "receiptsGrandTotalRounding",
        "transactionsGrandTotal",
        "transactionsGrandTotalRounding"
    )
    val activityInterval: Fielder = parse_attribute (attribute (cls, fields(0)))
    val receiptsGrandTotalBankable: Fielder = parse_element (element (cls, fields(1)))
    val receiptsGrandTotalNonBankable: Fielder = parse_element (element (cls, fields(2)))
    val receiptsGrandTotalRounding: Fielder = parse_element (element (cls, fields(3)))
    val transactionsGrandTotal: Fielder = parse_element (element (cls, fields(4)))
    val transactionsGrandTotalRounding: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): Shift =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Shift (
            IdentifiedObject.parse (context),
            mask (activityInterval (), 0),
            toDouble (mask (receiptsGrandTotalBankable (), 1)),
            toDouble (mask (receiptsGrandTotalNonBankable (), 2)),
            toDouble (mask (receiptsGrandTotalRounding (), 3)),
            toDouble (mask (transactionsGrandTotal (), 4)),
            toDouble (mask (transactionsGrandTotalRounding (), 5))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Shift] = ShiftSerializer
}

object ShiftSerializer extends CIMSerializer[Shift]
{
    def write (kryo: Kryo, output: Output, obj: Shift): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activityInterval),
            () => output.writeDouble (obj.receiptsGrandTotalBankable),
            () => output.writeDouble (obj.receiptsGrandTotalNonBankable),
            () => output.writeDouble (obj.receiptsGrandTotalRounding),
            () => output.writeDouble (obj.transactionsGrandTotal),
            () => output.writeDouble (obj.transactionsGrandTotalRounding)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Shift]): Shift =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Shift (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A schedule of charges; structure associated with Tariff that allows the definition of complex tarif structures such as step and time of use when used in conjunction with TimeTariffInterval and Charge.
 *
 * Inherited 'status.value' is defined in the context of the utility's business rules, for example: active, inactive, etc.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param tariffCycle The frequency at which the tariff charge schedule is repeated.
 *        Examples are: once off on a specified date and time; hourly; daily; weekly; monthly; 3-monthly; 6-monthly; 12-monthly; etc. At the end of each cycle, the business rules are reset to start from the beginning again.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] All consumption tariff intervals used to define this tariff profile.
 * @param Tariffs [[ch.ninecode.model.Tariff Tariff]] All tariffs defined by this tariff profile.
 * @param TimeTariffIntervals [[ch.ninecode.model.TimeTariffInterval TimeTariffInterval]] All time tariff intervals used to define this tariff profile.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class TariffProfile
(
    Document: Document = null,
    tariffCycle: String = null,
    ConsumptionTariffIntervals: List[String] = null,
    Tariffs: List[String] = null,
    TimeTariffIntervals: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TariffProfile.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TariffProfile.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TariffProfile.fields (position), x))
        emitelem (0, tariffCycle)
        emitattrs (1, ConsumptionTariffIntervals)
        emitattrs (2, Tariffs)
        emitattrs (3, TimeTariffIntervals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TariffProfile rdf:%s=\"%s\">\n%s\t</cim:TariffProfile>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TariffProfile
extends
    CIMParseable[TariffProfile]
{
    override val fields: Array[String] = Array[String] (
        "tariffCycle",
        "ConsumptionTariffIntervals",
        "Tariffs",
        "TimeTariffIntervals"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        CIMRelationship ("Tariffs", "Tariff", "0..*", "0..*"),
        CIMRelationship ("TimeTariffIntervals", "TimeTariffInterval", "0..*", "0..*")
    )
    val tariffCycle: Fielder = parse_element (element (cls, fields(0)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Tariffs: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TimeTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): TariffProfile =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TariffProfile (
            Document.parse (context),
            mask (tariffCycle (), 0),
            masks (ConsumptionTariffIntervals (), 1),
            masks (Tariffs (), 2),
            masks (TimeTariffIntervals (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TariffProfile] = TariffProfileSerializer
}

object TariffProfileSerializer extends CIMSerializer[TariffProfile]
{
    def write (kryo: Kryo, output: Output, obj: TariffProfile): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.tariffCycle),
            () => writeList (obj.ConsumptionTariffIntervals, output),
            () => writeList (obj.Tariffs, output),
            () => writeList (obj.TimeTariffIntervals, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TariffProfile]): TariffProfile =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TariffProfile (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Tender is what is "offered" by the customer towards making a payment and is often more than the required payment (hence the need for 'change').
 *
 * The payment is thus that part of the Tender that goes towards settlement of a particular transaction.
 * Tender is modelled as an aggregation of Cheque and Card. Both these tender types can exist in a single tender bid thus 'accountHolderName' has to exist separately in each of Cheque and Card as each could have a different account holder name.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param amount Amount tendered by customer.
 * @param change Difference between amount tendered by customer and the amount charged by point of sale.
 * @param kind Kind of tender from customer.
 * @param Card [[ch.ninecode.model.Card Card]] Card used to tender payment.
 * @param Cheque [[ch.ninecode.model.Cheque Cheque]] Cheque used to tender payment.
 * @param Receipt [[ch.ninecode.model.Receipt Receipt]] Receipt that recorded this receiving of a payment in the form of tenders.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Tender
(
    IdentifiedObject: IdentifiedObject = null,
    amount: Double = 0.0,
    change: Double = 0.0,
    kind: String = null,
    Card: String = null,
    Cheque: String = null,
    Receipt: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tender.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tender.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Tender.fields (position), value)
        emitelem (0, amount)
        emitelem (1, change)
        emitattr (2, kind)
        emitattr (3, Card)
        emitattr (4, Cheque)
        emitattr (5, Receipt)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tender rdf:%s=\"%s\">\n%s\t</cim:Tender>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Tender
extends
    CIMParseable[Tender]
{
    override val fields: Array[String] = Array[String] (
        "amount",
        "change",
        "kind",
        "Card",
        "Cheque",
        "Receipt"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Card", "Card", "0..1", "1"),
        CIMRelationship ("Cheque", "Cheque", "0..1", "1"),
        CIMRelationship ("Receipt", "Receipt", "1", "1..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val change: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Card: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Cheque: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Receipt: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): Tender =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tender (
            IdentifiedObject.parse (context),
            toDouble (mask (amount (), 0)),
            toDouble (mask (change (), 1)),
            mask (kind (), 2),
            mask (Card (), 3),
            mask (Cheque (), 4),
            mask (Receipt (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Tender] = TenderSerializer
}

object TenderSerializer extends CIMSerializer[Tender]
{
    def write (kryo: Kryo, output: Output, obj: Tender): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.amount),
            () => output.writeDouble (obj.change),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.Card),
            () => output.writeString (obj.Cheque),
            () => output.writeString (obj.Receipt)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tender]): Tender =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Tender (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * One of a sequence of time intervals defined in terms of real time.
 *
 * It is typically used in association with TariffProfile to define the intervals in a time of use tariff structure, where startDateTime simultaneously determines the starting point of this interval and the ending point of the previous interval.
 *
 * @param Element Reference to the superclass object.
 * @param sequenceNumber A sequential reference that defines the identity of this interval and its relative position with respect to other intervals in a sequence of intervals.
 * @param startTime A real time marker that defines the starting time (typically it is the time of day) for this interval.
 *        The interval extends to the start of the next interval or until it is reset to the start of the first interval by TariffProfile.tariffCycle.
 * @param Charges [[ch.ninecode.model.Charge Charge]] All charges used to define this time tariff interval.
 * @param ConsumptionTariffIntervals [[ch.ninecode.model.ConsumptionTariffInterval ConsumptionTariffInterval]] All consumption tariff intervals that introduce variation in this time of use tariff interval; allows to express e.g., peak hour prices that are different with different consumption blocks.
 * @param TariffProfiles [[ch.ninecode.model.TariffProfile TariffProfile]] All tariff profiles defined by this time tariff interval.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class TimeTariffInterval
(
    Element: BasicElement = null,
    sequenceNumber: Int = 0,
    startTime: String = null,
    Charges: List[String] = null,
    ConsumptionTariffIntervals: List[String] = null,
    TariffProfiles: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimeTariffInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeTariffInterval.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TimeTariffInterval.fields (position), x))
        emitelem (0, sequenceNumber)
        emitelem (1, startTime)
        emitattrs (2, Charges)
        emitattrs (3, ConsumptionTariffIntervals)
        emitattrs (4, TariffProfiles)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeTariffInterval rdf:%s=\"%s\">\n%s\t</cim:TimeTariffInterval>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TimeTariffInterval
extends
    CIMParseable[TimeTariffInterval]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "startTime",
        "Charges",
        "ConsumptionTariffIntervals",
        "TariffProfiles"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Charges", "Charge", "0..*", "0..*"),
        CIMRelationship ("ConsumptionTariffIntervals", "ConsumptionTariffInterval", "0..*", "0..*"),
        CIMRelationship ("TariffProfiles", "TariffProfile", "0..*", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val startTime: Fielder = parse_element (element (cls, fields(1)))
    val Charges: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ConsumptionTariffIntervals: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TariffProfiles: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): TimeTariffInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimeTariffInterval (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (startTime (), 1),
            masks (Charges (), 2),
            masks (ConsumptionTariffIntervals (), 3),
            masks (TariffProfiles (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TimeTariffInterval] = TimeTariffIntervalSerializer
}

object TimeTariffIntervalSerializer extends CIMSerializer[TimeTariffInterval]
{
    def write (kryo: Kryo, output: Output, obj: TimeTariffInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.startTime),
            () => writeList (obj.Charges, output),
            () => writeList (obj.ConsumptionTariffIntervals, output),
            () => writeList (obj.TariffProfiles, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimeTariffInterval]): TimeTariffInterval =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TimeTariffInterval (
            parent,
            if (isSet (0)) input.readInt else 0,
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
 * The record of details of payment for service or token sale.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param diverseReference Formal reference for use with diverse payment (traffic fine for example).
 * @param donorReference Reference to the entity that is the source of 'amount' (for example: customer for token purchase; or supplier for free issue token).
 * @param kind Kind of transaction.
 * @param line [[ch.ninecode.model.LineDetail LineDetail]] Transaction amount, rounding, date and note for this transaction line.
 * @param receiverReference Reference to the entity that is the recipient of 'amount' (for example, supplier for service charge payment; or tax receiver for VAT).
 * @param reversedId (if 'kind' is transactionReversal) Reference to the original transaction that is being reversed by this transaction.
 * @param serviceUnitsEnergy Actual amount of service units that is being paid for.
 * @param serviceUnitsError Number of service units not reflected in 'serviceUnitsEnergy' due to process rounding or truncating errors.
 * @param AuxiliaryAccount [[ch.ninecode.model.AuxiliaryAccount AuxiliaryAccount]] Auxiliary account for this payment transaction.
 * @param CashierShift [[ch.ninecode.model.CashierShift CashierShift]] Cashier shift during which this transaction was recorded.
 * @param CustomerAccount [[ch.ninecode.model.CustomerAccount CustomerAccount]] Customer account for this payment transaction.
 * @param Meter [[ch.ninecode.model.Meter Meter]] Meter for this vending transaction.
 * @param PricingStructure [[ch.ninecode.model.PricingStructure PricingStructure]] Pricing structure applicable for this transaction.
 * @param Receipt [[ch.ninecode.model.Receipt Receipt]] The receipted payment for which this transaction has been recorded.
 * @param UserAttributes [[ch.ninecode.model.UserAttribute UserAttribute]] All snapshots of meter parameters recorded at the time of this transaction.
 *        Use 'name' and 'value.value' attributes to specify name and value of a parameter from meter.
 * @param VendorShift [[ch.ninecode.model.VendorShift VendorShift]] Vendor shift during which this transaction was recorded.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Transaction
(
    IdentifiedObject: IdentifiedObject = null,
    diverseReference: String = null,
    donorReference: String = null,
    kind: String = null,
    line: String = null,
    receiverReference: String = null,
    reversedId: String = null,
    serviceUnitsEnergy: Double = 0.0,
    serviceUnitsError: Double = 0.0,
    AuxiliaryAccount: String = null,
    CashierShift: String = null,
    CustomerAccount: String = null,
    Meter: String = null,
    PricingStructure: String = null,
    Receipt: String = null,
    UserAttributes: List[String] = null,
    VendorShift: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Transaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Transaction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Transaction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Transaction.fields (position), x))
        emitelem (0, diverseReference)
        emitelem (1, donorReference)
        emitattr (2, kind)
        emitattr (3, line)
        emitelem (4, receiverReference)
        emitelem (5, reversedId)
        emitelem (6, serviceUnitsEnergy)
        emitelem (7, serviceUnitsError)
        emitattr (8, AuxiliaryAccount)
        emitattr (9, CashierShift)
        emitattr (10, CustomerAccount)
        emitattr (11, Meter)
        emitattr (12, PricingStructure)
        emitattr (13, Receipt)
        emitattrs (14, UserAttributes)
        emitattr (15, VendorShift)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Transaction rdf:%s=\"%s\">\n%s\t</cim:Transaction>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Transaction
extends
    CIMParseable[Transaction]
{
    override val fields: Array[String] = Array[String] (
        "diverseReference",
        "donorReference",
        "kind",
        "line",
        "receiverReference",
        "reversedId",
        "serviceUnitsEnergy",
        "serviceUnitsError",
        "AuxiliaryAccount",
        "CashierShift",
        "CustomerAccount",
        "Meter",
        "PricingStructure",
        "Receipt",
        "UserAttributes",
        "VendorShift"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("line", "LineDetail", "0..1", "0..*"),
        CIMRelationship ("AuxiliaryAccount", "AuxiliaryAccount", "0..1", "0..*"),
        CIMRelationship ("CashierShift", "CashierShift", "0..1", "0..*"),
        CIMRelationship ("CustomerAccount", "CustomerAccount", "0..1", "0..*"),
        CIMRelationship ("Meter", "Meter", "0..1", "0..*"),
        CIMRelationship ("PricingStructure", "PricingStructure", "0..1", "0..*"),
        CIMRelationship ("Receipt", "Receipt", "0..1", "1..*"),
        CIMRelationship ("UserAttributes", "UserAttribute", "0..*", "0..1"),
        CIMRelationship ("VendorShift", "VendorShift", "0..1", "0..*")
    )
    val diverseReference: Fielder = parse_element (element (cls, fields(0)))
    val donorReference: Fielder = parse_element (element (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val line: Fielder = parse_attribute (attribute (cls, fields(3)))
    val receiverReference: Fielder = parse_element (element (cls, fields(4)))
    val reversedId: Fielder = parse_element (element (cls, fields(5)))
    val serviceUnitsEnergy: Fielder = parse_element (element (cls, fields(6)))
    val serviceUnitsError: Fielder = parse_element (element (cls, fields(7)))
    val AuxiliaryAccount: Fielder = parse_attribute (attribute (cls, fields(8)))
    val CashierShift: Fielder = parse_attribute (attribute (cls, fields(9)))
    val CustomerAccount: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Meter: Fielder = parse_attribute (attribute (cls, fields(11)))
    val PricingStructure: Fielder = parse_attribute (attribute (cls, fields(12)))
    val Receipt: Fielder = parse_attribute (attribute (cls, fields(13)))
    val UserAttributes: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val VendorShift: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: CIMContext): Transaction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Transaction (
            IdentifiedObject.parse (context),
            mask (diverseReference (), 0),
            mask (donorReference (), 1),
            mask (kind (), 2),
            mask (line (), 3),
            mask (receiverReference (), 4),
            mask (reversedId (), 5),
            toDouble (mask (serviceUnitsEnergy (), 6)),
            toDouble (mask (serviceUnitsError (), 7)),
            mask (AuxiliaryAccount (), 8),
            mask (CashierShift (), 9),
            mask (CustomerAccount (), 10),
            mask (Meter (), 11),
            mask (PricingStructure (), 12),
            mask (Receipt (), 13),
            masks (UserAttributes (), 14),
            mask (VendorShift (), 15)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Transaction] = TransactionSerializer
}

object TransactionSerializer extends CIMSerializer[Transaction]
{
    def write (kryo: Kryo, output: Output, obj: Transaction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.diverseReference),
            () => output.writeString (obj.donorReference),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.line),
            () => output.writeString (obj.receiverReference),
            () => output.writeString (obj.reversedId),
            () => output.writeDouble (obj.serviceUnitsEnergy),
            () => output.writeDouble (obj.serviceUnitsError),
            () => output.writeString (obj.AuxiliaryAccount),
            () => output.writeString (obj.CashierShift),
            () => output.writeString (obj.CustomerAccount),
            () => output.writeString (obj.Meter),
            () => output.writeString (obj.PricingStructure),
            () => output.writeString (obj.Receipt),
            () => writeList (obj.UserAttributes, output),
            () => output.writeString (obj.VendorShift)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Transaction]): Transaction =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Transaction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The entity that ultimately executes the transaction and which is in control of the process; typically this is embodied in secure software running on a server that may employ secure hardware encryption devices for secure transaction processing.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MerchantAccounts [[ch.ninecode.model.MerchantAccount MerchantAccount]] All merchant accounts registered with this transactor.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Transactor
(
    IdentifiedObject: IdentifiedObject = null,
    MerchantAccounts: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Transactor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Transactor.fields (position), x))
        emitattrs (0, MerchantAccounts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Transactor rdf:%s=\"%s\">\n%s\t</cim:Transactor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Transactor
extends
    CIMParseable[Transactor]
{
    override val fields: Array[String] = Array[String] (
        "MerchantAccounts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MerchantAccounts", "MerchantAccount", "0..*", "0..*")
    )
    val MerchantAccounts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Transactor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Transactor (
            IdentifiedObject.parse (context),
            masks (MerchantAccounts (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Transactor] = TransactorSerializer
}

object TransactorSerializer extends CIMSerializer[Transactor]
{
    def write (kryo: Kryo, output: Output, obj: Transactor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.MerchantAccounts, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Transactor]): Transactor =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Transactor (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The entity that owns the point of sale and contracts with the cashier to receipt payments and vend tokens using the payment system.
 *
 * The vendor has a private contract with and is managed by the merchant which is a type of organisation. The vendor is accountable to the merchant for revenue collected, and the merchant is in turn accountable to the supplier.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param VendorShifts [[ch.ninecode.model.VendorShift VendorShift]] All vendor shifts opened and owned by this vendor.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class Vendor
(
    IdentifiedObject: IdentifiedObject = null,
    VendorShifts: List[String] = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Vendor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Vendor.fields (position), x))
        emitattrs (0, VendorShifts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Vendor rdf:%s=\"%s\">\n%s\t</cim:Vendor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Vendor
extends
    CIMParseable[Vendor]
{
    override val fields: Array[String] = Array[String] (
        "VendorShifts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("VendorShifts", "VendorShift", "0..*", "0..1")
    )
    val VendorShifts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Vendor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Vendor (
            IdentifiedObject.parse (context),
            masks (VendorShifts (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Vendor] = VendorSerializer
}

object VendorSerializer extends CIMSerializer[Vendor]
{
    def write (kryo: Kryo, output: Output, obj: Vendor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.VendorShifts, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Vendor]): Vendor =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Vendor (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The operating shift for a vendor during which the vendor may transact against the merchant's account.
 *
 * It aggregates transactions and receipts during the shift and periodically debits a merchant account. The totals in vendor shift should always be the sum of totals aggregated in all cashier shifts that were open under the particular vendor shift.
 *
 * @param Shift [[ch.ninecode.model.Shift Shift]] Reference to the superclass object.
 * @param merchantDebitAmount The amount that is to be debited from the merchant account for this vendor shift.
 *        This amount reflects the sum(PaymentTransaction.transactionAmount).
 * @param posted If true, merchantDebitAmount has been debited from MerchantAccount; typically happens at the end of VendorShift when it closes.
 * @param MerchantAccount [[ch.ninecode.model.MerchantAccount MerchantAccount]] Merchant account this vendor shift periodically debits (based on aggregated transactions).
 * @param Receipts [[ch.ninecode.model.Receipt Receipt]] All receipts recorded during this vendor shift.
 * @param Transactions [[ch.ninecode.model.Transaction Transaction]] All transactions recorded during this vendor shift.
 * @param Vendor [[ch.ninecode.model.Vendor Vendor]] Vendor that opens and owns this vendor shift.
 * @group PaymentMetering
 * @groupname PaymentMetering Package PaymentMetering
 * @groupdesc PaymentMetering This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering. These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 */
final case class VendorShift
(
    Shift: Shift = null,
    merchantDebitAmount: Double = 0.0,
    posted: Boolean = false,
    MerchantAccount: String = null,
    Receipts: List[String] = null,
    Transactions: List[String] = null,
    Vendor: String = null
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
    override def sup: Shift = Shift

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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VendorShift.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VendorShift.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VendorShift.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VendorShift.fields (position), x))
        emitelem (0, merchantDebitAmount)
        emitelem (1, posted)
        emitattr (2, MerchantAccount)
        emitattrs (3, Receipts)
        emitattrs (4, Transactions)
        emitattr (5, Vendor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VendorShift rdf:%s=\"%s\">\n%s\t</cim:VendorShift>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object VendorShift
extends
    CIMParseable[VendorShift]
{
    override val fields: Array[String] = Array[String] (
        "merchantDebitAmount",
        "posted",
        "MerchantAccount",
        "Receipts",
        "Transactions",
        "Vendor"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MerchantAccount", "MerchantAccount", "0..1", "0..*"),
        CIMRelationship ("Receipts", "Receipt", "0..*", "0..1"),
        CIMRelationship ("Transactions", "Transaction", "0..*", "0..1"),
        CIMRelationship ("Vendor", "Vendor", "0..1", "0..*")
    )
    val merchantDebitAmount: Fielder = parse_element (element (cls, fields(0)))
    val posted: Fielder = parse_element (element (cls, fields(1)))
    val MerchantAccount: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Receipts: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Transactions: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Vendor: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): VendorShift =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VendorShift (
            Shift.parse (context),
            toDouble (mask (merchantDebitAmount (), 0)),
            toBoolean (mask (posted (), 1)),
            mask (MerchantAccount (), 2),
            masks (Receipts (), 3),
            masks (Transactions (), 4),
            mask (Vendor (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VendorShift] = VendorShiftSerializer
}

object VendorShiftSerializer extends CIMSerializer[VendorShift]
{
    def write (kryo: Kryo, output: Output, obj: VendorShift): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.merchantDebitAmount),
            () => output.writeBoolean (obj.posted),
            () => output.writeString (obj.MerchantAccount),
            () => writeList (obj.Receipts, output),
            () => writeList (obj.Transactions, output),
            () => output.writeString (obj.Vendor)
        )
        ShiftSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VendorShift]): VendorShift =
    {
        val parent = ShiftSerializer.read (kryo, input, classOf[Shift])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VendorShift (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _PaymentMetering
{
    def register: List[CIMClassInfo] =
    {
        List (
            AccountMovement.register,
            AccountingUnit.register,
            AuxiliaryAccount.register,
            AuxiliaryAgreement.register,
            BankAccountDetail.register,
            Card.register,
            Cashier.register,
            CashierShift.register,
            Charge.register,
            Cheque.register,
            ConsumptionTariffInterval.register,
            Due.register,
            LineDetail.register,
            MerchantAccount.register,
            MerchantAgreement.register,
            PointOfSale.register,
            Receipt.register,
            ServiceSupplier.register,
            Shift.register,
            TariffProfile.register,
            Tender.register,
            TimeTariffInterval.register,
            Transaction.register,
            Transactor.register,
            Vendor.register,
            VendorShift.register
        )
    }
}