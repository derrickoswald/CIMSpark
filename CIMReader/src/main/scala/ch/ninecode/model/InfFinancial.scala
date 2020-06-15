package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Operates the Control Area.
 *
 * Approves and implements energy transactions. Verifies both Inter-Control Area and Intra-Control Area transactions for the power system  before granting approval (and implementing) the transactions.
 *
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param CAChildOf [[ch.ninecode.model.TieLine TieLine]] A ControlAreaOperator has a collection of tie points that ring the ControlArea, called a TieLine.
 * @param ControlledBy [[ch.ninecode.model.HostControlArea HostControlArea]] A ControlAreaCompany controls a ControlArea.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class ControlAreaOperator
(
    Organisation: Organisation = null,
    CAChildOf: List[String] = null,
    ControlledBy: String = null
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
    override def sup: Organisation = Organisation

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
        implicit val clz: String = ControlAreaOperator.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAreaOperator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ControlAreaOperator.fields (position), x))
        emitattrs (0, CAChildOf)
        emitattr (1, ControlledBy)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAreaOperator rdf:ID=\"%s\">\n%s\t</cim:ControlAreaOperator>".format (id, export_fields)
    }
}

object ControlAreaOperator
extends
    CIMParseable[ControlAreaOperator]
{
    override val fields: Array[String] = Array[String] (
        "CAChildOf",
        "ControlledBy"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CAChildOf", "TieLine", "0..*", "0..*"),
        CIMRelationship ("ControlledBy", "HostControlArea", "1", "1")
    )
    val CAChildOf: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ControlledBy: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ControlAreaOperator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlAreaOperator (
            Organisation.parse (context),
            masks (CAChildOf (), 0),
            mask (ControlledBy (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ControlAreaOperatorSerializer extends CIMSerializer[ControlAreaOperator]
{
    def write (kryo: Kryo, output: Output, obj: ControlAreaOperator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CAChildOf, output),
            () => output.writeString (obj.ControlledBy)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ControlAreaOperator]): ControlAreaOperator =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ControlAreaOperator (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The energy buyer in the energy marketplace.
 *
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param CustChildOf [[ch.ninecode.model.TieLine TieLine]] A  ControlAreaOperator or CustomerConsumer may ring their perimeter with metering, which can create a unique SubControlArea at the collection of metering points, called a TieLine.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class CustomerConsumer
(
    Organisation: Organisation = null,
    CustChildOf: List[String] = null
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
    override def sup: Organisation = Organisation

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
        implicit val clz: String = CustomerConsumer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CustomerConsumer.fields (position), x))
        emitattrs (0, CustChildOf)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CustomerConsumer rdf:ID=\"%s\">\n%s\t</cim:CustomerConsumer>".format (id, export_fields)
    }
}

object CustomerConsumer
extends
    CIMParseable[CustomerConsumer]
{
    override val fields: Array[String] = Array[String] (
        "CustChildOf"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustChildOf", "TieLine", "0..*", "0..1")
    )
    val CustChildOf: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): CustomerConsumer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerConsumer (
            Organisation.parse (context),
            masks (CustChildOf (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CustomerConsumerSerializer extends CIMSerializer[CustomerConsumer]
{
    def write (kryo: Kryo, output: Output, obj: CustomerConsumer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CustChildOf, output)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CustomerConsumer]): CustomerConsumer =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CustomerConsumer (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The energy seller in the energy marketplace.
 *
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param ProvidedBy [[ch.ninecode.model.EnergyProduct EnergyProduct]] <em>undocumented</em>
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class GenerationProvider
(
    Organisation: Organisation = null,
    ProvidedBy: List[String] = null
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
    override def sup: Organisation = Organisation

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
        implicit val clz: String = GenerationProvider.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (GenerationProvider.fields (position), x))
        emitattrs (0, ProvidedBy)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenerationProvider rdf:ID=\"%s\">\n%s\t</cim:GenerationProvider>".format (id, export_fields)
    }
}

object GenerationProvider
extends
    CIMParseable[GenerationProvider]
{
    override val fields: Array[String] = Array[String] (
        "ProvidedBy"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProvidedBy", "EnergyProduct", "1..*", "1")
    )
    val ProvidedBy: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): GenerationProvider =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenerationProvider (
            Organisation.parse (context),
            masks (ProvidedBy (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object GenerationProviderSerializer extends CIMSerializer[GenerationProvider]
{
    def write (kryo: Kryo, output: Output, obj: GenerationProvider): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ProvidedBy, output)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GenerationProvider]): GenerationProvider =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GenerationProvider (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A type of agreement that provides the default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param defaultIntegrationMethod The default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *        Method #1 is to integrate the instantaneous schedule between the hourly boundaries. Method #2 compensates for any up/down ramping that occurs across the hourly boundary (this is called block accounting).
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class IntSchedAgreement
(
    Agreement: Agreement = null,
    defaultIntegrationMethod: String = null
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
        implicit val clz: String = IntSchedAgreement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IntSchedAgreement.fields (position), value)
        emitelem (0, defaultIntegrationMethod)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IntSchedAgreement rdf:ID=\"%s\">\n%s\t</cim:IntSchedAgreement>".format (id, export_fields)
    }
}

object IntSchedAgreement
extends
    CIMParseable[IntSchedAgreement]
{
    override val fields: Array[String] = Array[String] (
        "defaultIntegrationMethod"
    )
    val defaultIntegrationMethod: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): IntSchedAgreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntSchedAgreement (
            Agreement.parse (context),
            mask (defaultIntegrationMethod (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object IntSchedAgreementSerializer extends CIMSerializer[IntSchedAgreement]
{
    def write (kryo: Kryo, output: Output, obj: IntSchedAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.defaultIntegrationMethod)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IntSchedAgreement]): IntSchedAgreement =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IntSchedAgreement (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Matches buyers and sellers, and secures transmission (and other ancillary services) needed to complete the energy transaction.
 *
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param HoldsTitleTo_EnergyProducts [[ch.ninecode.model.EnergyProduct EnergyProduct]] A Marketer holds title to an EnergyProduct.
 * @param Resells_EnergyProduct [[ch.ninecode.model.EnergyProduct EnergyProduct]] A Marketer may resell an EnergyProduct.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class Marketer
(
    Organisation: Organisation = null,
    HoldsTitleTo_EnergyProducts: List[String] = null,
    Resells_EnergyProduct: List[String] = null
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
    override def sup: Organisation = Organisation

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
        implicit val clz: String = Marketer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Marketer.fields (position), x))
        emitattrs (0, HoldsTitleTo_EnergyProducts)
        emitattrs (1, Resells_EnergyProduct)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Marketer rdf:ID=\"%s\">\n%s\t</cim:Marketer>".format (id, export_fields)
    }
}

object Marketer
extends
    CIMParseable[Marketer]
{
    override val fields: Array[String] = Array[String] (
        "HoldsTitleTo_EnergyProducts",
        "Resells_EnergyProduct"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("HoldsTitleTo_EnergyProducts", "EnergyProduct", "0..*", "0..1"),
        CIMRelationship ("Resells_EnergyProduct", "EnergyProduct", "0..*", "0..*")
    )
    val HoldsTitleTo_EnergyProducts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Resells_EnergyProduct: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): Marketer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Marketer (
            Organisation.parse (context),
            masks (HoldsTitleTo_EnergyProducts (), 0),
            masks (Resells_EnergyProduct (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketerSerializer extends CIMSerializer[Marketer]
{
    def write (kryo: Kryo, output: Output, obj: Marketer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.HoldsTitleTo_EnergyProducts, output),
            () => writeList (obj.Resells_EnergyProduct, output)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Marketer]): Marketer =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Marketer (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Contracts for services offered commercially.
 *
 * @param Agreement [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class OpenAccessProduct
(
    Agreement: Agreement = null
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:OpenAccessProduct rdf:ID=\"%s\">\n%s\t</cim:OpenAccessProduct>".format (id, export_fields)
    }
}

object OpenAccessProduct
extends
    CIMParseable[OpenAccessProduct]
{

    def parse (context: CIMContext): OpenAccessProduct =
    {
        val ret = OpenAccessProduct (
            Agreement.parse (context)
        )
        ret
    }
}

object OpenAccessProductSerializer extends CIMSerializer[OpenAccessProduct]
{
    def write (kryo: Kryo, output: Output, obj: OpenAccessProduct): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OpenAccessProduct]): OpenAccessProduct =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf[Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OpenAccessProduct (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class TransmissionProduct
(
    IdentifiedObject: IdentifiedObject = null,
    transmissionProductType: String = null,
    LocationFor: List[String] = null,
    TransmissionProvider: String = null
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
        implicit val clz: String = TransmissionProduct.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransmissionProduct.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionProduct.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionProduct.fields (position), x))
        emitelem (0, transmissionProductType)
        emitattrs (1, LocationFor)
        emitattr (2, TransmissionProvider)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionProduct rdf:ID=\"%s\">\n%s\t</cim:TransmissionProduct>".format (id, export_fields)
    }
}

object TransmissionProduct
extends
    CIMParseable[TransmissionProduct]
{
    override val fields: Array[String] = Array[String] (
        "transmissionProductType",
        "LocationFor",
        "TransmissionProvider"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LocationFor", "TransmissionPath", "0..*", "0..*"),
        CIMRelationship ("TransmissionProvider", "TransmissionProvider", "1", "1..*")
    )
    val transmissionProductType: Fielder = parse_element (element (cls, fields(0)))
    val LocationFor: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TransmissionProvider: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): TransmissionProduct =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionProduct (
            IdentifiedObject.parse (context),
            mask (transmissionProductType (), 0),
            masks (LocationFor (), 1),
            mask (TransmissionProvider (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransmissionProductSerializer extends CIMSerializer[TransmissionProduct]
{
    def write (kryo: Kryo, output: Output, obj: TransmissionProduct): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.transmissionProductType),
            () => writeList (obj.LocationFor, output),
            () => output.writeString (obj.TransmissionProvider)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransmissionProduct]): TransmissionProduct =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransmissionProduct (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Provider of  the transmission capacity (interconnecting wires between Generation and Consumption) required  to fulfill and Energy Transaction's energy exchange.
 *
 * Posts information for transmission paths and AvailableTransmissionCapacities  on a reservation node.  Buys and sells its products and services on the same reservation node.
 *
 * @param Organisation [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param For [[ch.ninecode.model.LossProfile LossProfile]] Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
 *        If so, the TransmissionProvider must be one of the participating entities in the EnergyTransaction.
 * @param TransmissionProducts [[ch.ninecode.model.TransmissionProduct TransmissionProduct]] A TransmissionProvider offers a TransmissionProduct.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class TransmissionProvider
(
    Organisation: Organisation = null,
    For: List[String] = null,
    TransmissionProducts: List[String] = null
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
    override def sup: Organisation = Organisation

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
        implicit val clz: String = TransmissionProvider.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionProvider.fields (position), x))
        emitattrs (0, For)
        emitattrs (1, TransmissionProducts)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionProvider rdf:ID=\"%s\">\n%s\t</cim:TransmissionProvider>".format (id, export_fields)
    }
}

object TransmissionProvider
extends
    CIMParseable[TransmissionProvider]
{
    override val fields: Array[String] = Array[String] (
        "For",
        "TransmissionProducts"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("For", "LossProfile", "0..*", "0..1"),
        CIMRelationship ("TransmissionProducts", "TransmissionProduct", "1..*", "1")
    )
    val For: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val TransmissionProducts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): TransmissionProvider =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransmissionProvider (
            Organisation.parse (context),
            masks (For (), 0),
            masks (TransmissionProducts (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TransmissionProviderSerializer extends CIMSerializer[TransmissionProvider]
{
    def write (kryo: Kryo, output: Output, obj: TransmissionProvider): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.For, output),
            () => writeList (obj.TransmissionProducts, output)
        )
        OrganisationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransmissionProvider]): TransmissionProvider =
    {
        val parent = OrganisationSerializer.read (kryo, input, classOf[Organisation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransmissionProvider (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfFinancial
{
    def register: List[CIMClassInfo] =
    {
        List (
            ControlAreaOperator.register,
            CustomerConsumer.register,
            GenerationProvider.register,
            IntSchedAgreement.register,
            Marketer.register,
            OpenAccessProduct.register,
            TransmissionProduct.register,
            TransmissionProvider.register
        )
    }
}