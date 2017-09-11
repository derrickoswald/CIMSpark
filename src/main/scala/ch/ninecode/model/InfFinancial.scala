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
case class ControlAreaOperator
(
    override val sup: Organisation,
    CAChildOf: List[String],
    ControlledBy: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != CAChildOf) CAChildOf.map (x => "\t\t<cim:ControlAreaOperator.CAChildOf rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ControlledBy) "\t\t<cim:ControlAreaOperator.ControlledBy rdf:resource=\"#" + ControlledBy + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ControlAreaOperator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ControlAreaOperator>"
    }
}

object ControlAreaOperator
extends
    Parseable[ControlAreaOperator]
{
    val CAChildOf = parse_attributes (attribute ("""ControlAreaOperator.CAChildOf"""))
    val ControlledBy = parse_attribute (attribute ("""ControlAreaOperator.ControlledBy"""))
    def parse (context: Context): ControlAreaOperator =
    {
        ControlAreaOperator(
            Organisation.parse (context),
            CAChildOf (context),
            ControlledBy (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("CAChildOf", "TieLine", true),
        Relationship ("ControlledBy", "HostControlArea", false))
}

/**
 * The energy buyer in the energy marketplace.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class CustomerConsumer
(
    override val sup: Organisation
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[CustomerConsumer] }
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
        "\t<cim:CustomerConsumer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CustomerConsumer>"
    }
}

object CustomerConsumer
extends
    Parseable[CustomerConsumer]
{
    def parse (context: Context): CustomerConsumer =
    {
        CustomerConsumer(
            Organisation.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * The energy seller in the energy marketplace.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class GenerationProvider
(
    override val sup: Organisation
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[GenerationProvider] }
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
        "\t<cim:GenerationProvider rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenerationProvider>"
    }
}

object GenerationProvider
extends
    Parseable[GenerationProvider]
{
    def parse (context: Context): GenerationProvider =
    {
        GenerationProvider(
            Organisation.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A type of agreement that provides the default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param defaultIntegrationMethod The default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 *        Method #1 is to integrate the instantaneous schedule between the hourly boundaries. Method #2 compensates for any up/down ramping that occurs across the hourly boundary (this is called block accounting).
 * @param MktOrganisation [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class IntSchedAgreement
(
    override val sup: Agreement,
    defaultIntegrationMethod: String,
    MktOrganisation: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != defaultIntegrationMethod) "\t\t<cim:IntSchedAgreement.defaultIntegrationMethod>" + defaultIntegrationMethod + "</cim:IntSchedAgreement.defaultIntegrationMethod>\n" else "") +
        (if (null != MktOrganisation) MktOrganisation.map (x => "\t\t<cim:IntSchedAgreement.MktOrganisation rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:IntSchedAgreement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IntSchedAgreement>"
    }
}

object IntSchedAgreement
extends
    Parseable[IntSchedAgreement]
{
    val defaultIntegrationMethod = parse_element (element ("""IntSchedAgreement.defaultIntegrationMethod"""))
    val MktOrganisation = parse_attributes (attribute ("""IntSchedAgreement.MktOrganisation"""))
    def parse (context: Context): IntSchedAgreement =
    {
        IntSchedAgreement(
            Agreement.parse (context),
            defaultIntegrationMethod (context),
            MktOrganisation (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MktOrganisation", "MktOrganisation", true))
}

/**
 * Matches buyers and sellers, and secures transmission (and other ancillary services) needed to complete the energy transaction.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class Marketer
(
    override val sup: Organisation
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[Marketer] }
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
        "\t<cim:Marketer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Marketer>"
    }
}

object Marketer
extends
    Parseable[Marketer]
{
    def parse (context: Context): Marketer =
    {
        Marketer(
            Organisation.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Contracts for services offered commercially.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class OpenAccessProduct
(
    override val sup: Agreement
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
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[OpenAccessProduct] }
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
        "\t<cim:OpenAccessProduct rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OpenAccessProduct>"
    }
}

object OpenAccessProduct
extends
    Parseable[OpenAccessProduct]
{
    def parse (context: Context): OpenAccessProduct =
    {
        OpenAccessProduct(
            Agreement.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**

 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class TransmissionProduct
(
    override val sup: IdentifiedObject,
    transmissionProductType: String,
    LocationFor: List[String],
    TransmissionProvider: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != transmissionProductType) "\t\t<cim:TransmissionProduct.transmissionProductType>" + transmissionProductType + "</cim:TransmissionProduct.transmissionProductType>\n" else "") +
        (if (null != LocationFor) LocationFor.map (x => "\t\t<cim:TransmissionProduct.LocationFor rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TransmissionProvider) "\t\t<cim:TransmissionProduct.TransmissionProvider rdf:resource=\"#" + TransmissionProvider + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionProduct rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionProduct>"
    }
}

object TransmissionProduct
extends
    Parseable[TransmissionProduct]
{
    val transmissionProductType = parse_element (element ("""TransmissionProduct.transmissionProductType"""))
    val LocationFor = parse_attributes (attribute ("""TransmissionProduct.LocationFor"""))
    val TransmissionProvider = parse_attribute (attribute ("""TransmissionProduct.TransmissionProvider"""))
    def parse (context: Context): TransmissionProduct =
    {
        TransmissionProduct(
            IdentifiedObject.parse (context),
            transmissionProductType (context),
            LocationFor (context),
            TransmissionProvider (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LocationFor", "TransmissionPath", true),
        Relationship ("TransmissionProvider", "TransmissionProvider", false))
}

/**
 * Provider of  the transmission capacity (interconnecting wires between Generation and Consumption) required  to fulfill and Energy Transaction's energy exchange.
 *
 * Posts information for transmission paths and AvailableTransmissionCapacities  on a reservation node.  Buys and sells its products and services on the same reservation node.
 *
 * @param sup [[ch.ninecode.model.Organisation Organisation]] Reference to the superclass object.
 * @group InfFinancial
 * @groupname InfFinancial Package InfFinancial
 * @groupdesc InfFinancial This package is responsible for Settlement and Billing. These classes represent the legal entities who participate in formal or informal agreements.
 */
case class TransmissionProvider
(
    override val sup: Organisation
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
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionProvider] }
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
        "\t<cim:TransmissionProvider rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionProvider>"
    }
}

object TransmissionProvider
extends
    Parseable[TransmissionProvider]
{
    def parse (context: Context): TransmissionProvider =
    {
        TransmissionProvider(
            Organisation.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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