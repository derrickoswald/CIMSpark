package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Operates the Control Area.
 *
 * Approves and implements energy transactions. Verifies both Inter-Control Area and Intra-Control Area transactions for the power system  before granting approval (and implementing) the transactions.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param CAChildOf [[ch.ninecode.model.TieLine TieLine]] A ControlAreaOperator has a collection of tie points that ring the ControlArea, called a TieLine.
 * @param ControlledBy [[ch.ninecode.model.HostControlArea HostControlArea]] A ControlAreaCompany controls a ControlArea.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class ControlAreaOperator
(
    override val sup: Organisation = null,
    CAChildOf: List[String] = List(),
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[ControlAreaOperator] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ControlAreaOperator]
{
    override val fields: Array[String] = Array[String] (
        "CAChildOf",
        "ControlledBy"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CAChildOf", "TieLine", "0..*", "0..*"),
        Relationship ("ControlledBy", "HostControlArea", "1", "1")
    )
    val CAChildOf: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ControlledBy: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ControlAreaOperator =
    {
        implicit val ctx: Context = context
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

/**
 * The energy buyer in the energy marketplace.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param CustChildOf [[ch.ninecode.model.TieLine TieLine]] A  ControlAreaOperator or CustomerConsumer may ring their perimeter with metering, which can create a unique SubControlArea at the collection of metering points, called a TieLine.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class CustomerConsumer
(
    override val sup: Organisation = null,
    CustChildOf: List[String] = List()
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[CustomerConsumer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[CustomerConsumer]
{
    override val fields: Array[String] = Array[String] (
        "CustChildOf"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustChildOf", "TieLine", "0..*", "0..1")
    )
    val CustChildOf: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): CustomerConsumer =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CustomerConsumer (
            Organisation.parse (context),
            masks (CustChildOf (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The energy seller in the energy marketplace.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param ProvidedBy [[ch.ninecode.model.EnergyProduct EnergyProduct]] <em>undocumented</em>
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class GenerationProvider
(
    override val sup: Organisation = null,
    ProvidedBy: List[String] = List()
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[GenerationProvider] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[GenerationProvider]
{
    override val fields: Array[String] = Array[String] (
        "ProvidedBy"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ProvidedBy", "EnergyProduct", "1..*", "1")
    )
    val ProvidedBy: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): GenerationProvider =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenerationProvider (
            Organisation.parse (context),
            masks (ProvidedBy (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A type of agreement that provides the default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param defaultIntegrationMethod The default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *        Method #1 is to integrate the instantaneous schedule between the hourly boundaries. Method #2 compensates for any up/down ramping that occurs across the hourly boundary (this is called block accounting).
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class IntSchedAgreement
(
    override val sup: Agreement = null,
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
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[IntSchedAgreement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[IntSchedAgreement]
{
    override val fields: Array[String] = Array[String] (
        "defaultIntegrationMethod"
    )
    val defaultIntegrationMethod: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): IntSchedAgreement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntSchedAgreement (
            Agreement.parse (context),
            mask (defaultIntegrationMethod (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Matches buyers and sellers, and secures transmission (and other ancillary services) needed to complete the energy transaction.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param HoldsTitleTo_EnergyProducts [[ch.ninecode.model.EnergyProduct EnergyProduct]] A Marketer holds title to an EnergyProduct.
 * @param Resells_EnergyProduct [[ch.ninecode.model.EnergyProduct EnergyProduct]] A Marketer may resell an EnergyProduct.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class Marketer
(
    override val sup: Organisation = null,
    HoldsTitleTo_EnergyProducts: List[String] = List(),
    Resells_EnergyProduct: List[String] = List()
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[Marketer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Marketer]
{
    override val fields: Array[String] = Array[String] (
        "HoldsTitleTo_EnergyProducts",
        "Resells_EnergyProduct"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HoldsTitleTo_EnergyProducts", "EnergyProduct", "0..*", "0..1"),
        Relationship ("Resells_EnergyProduct", "EnergyProduct", "0..*", "0..*")
    )
    val HoldsTitleTo_EnergyProducts: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Resells_EnergyProduct: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Marketer =
    {
        implicit val ctx: Context = context
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

/**
 * Contracts for services offered commercially.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class OpenAccessProduct
(
    override val sup: Agreement = null
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
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[OpenAccessProduct] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[OpenAccessProduct]
{

    def parse (context: Context): OpenAccessProduct =
    {
        implicit val ctx: Context = context
        val ret = OpenAccessProduct (
            Agreement.parse (context)
        )
        ret
    }
}

/**

 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class TransmissionProduct
(
    override val sup: IdentifiedObject = null,
    transmissionProductType: String = null,
    LocationFor: List[String] = List(),
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionProduct] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TransmissionProduct]
{
    override val fields: Array[String] = Array[String] (
        "transmissionProductType",
        "LocationFor",
        "TransmissionProvider"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LocationFor", "TransmissionPath", "0..*", "0..*"),
        Relationship ("TransmissionProvider", "TransmissionProvider", "1", "1..*")
    )
    val transmissionProductType: Fielder = parse_element (element (cls, fields(0)))
    val LocationFor: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TransmissionProvider: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TransmissionProduct =
    {
        implicit val ctx: Context = context
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

/**
 * Provider of  the transmission capacity (interconnecting wires between Generation and Consumption) required  to fulfill and Energy Transaction's energy exchange.
 *
 * Posts information for transmission paths and AvailableTransmissionCapacities  on a reservation node.  Buys and sells its products and services on the same reservation node.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @param For [[ch.ninecode.model.LossProfile LossProfile]] Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
 *        If so, the TransmissionProvider must be one of the participating entities in the EnergyTransaction.
 * @param TransmissionProducts [[ch.ninecode.model.TransmissionProduct TransmissionProduct]] A TransmissionProvider offers a TransmissionProduct.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
final case class TransmissionProvider
(
    override val sup: Organisation = null,
    For: List[String] = List(),
    TransmissionProducts: List[String] = List()
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionProvider] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TransmissionProvider]
{
    override val fields: Array[String] = Array[String] (
        "For",
        "TransmissionProducts"
    )
    override val relations: List[Relationship] = List (
        Relationship ("For", "LossProfile", "0..*", "0..1"),
        Relationship ("TransmissionProducts", "TransmissionProduct", "1..*", "1")
    )
    val For: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val TransmissionProducts: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): TransmissionProvider =
    {
        implicit val ctx: Context = context
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

private[ninecode] object _InfFinancial
{
    def register: List[ClassInfo] =
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