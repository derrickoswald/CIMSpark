package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is responsible for Settlement and Billing.
 * These classes represent the legal entities who participate in formal or informal agreements.
 */

/**
 * Operates the Control Area.
 * Approves and implements energy transactions. Verifies both Inter-Control Area and Intra-Control Area transactions for the power system  before granting approval (and implementing) the transactions.
 */
case class ControlAreaOperator
(

    override val sup: Organisation,

    /**
     * A ControlAreaOperator has a collection of tie points that ring the ControlArea, called a TieLine.
     */
    val CAChildOf: List[String],

    /**
     * A ControlAreaCompany controls a ControlArea.
     */
    val ControlledBy: String
)
extends
    Element
{
    def this () = { this (null, List(), null) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[ControlAreaOperator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ControlAreaOperator
extends
    Parseable[ControlAreaOperator]
{
    val sup = Organisation.parse _
    val CAChildOf = parse_attributes (attribute ("""ControlAreaOperator.CAChildOf"""))_
    val ControlledBy = parse_attribute (attribute ("""ControlAreaOperator.ControlledBy"""))_
    def parse (context: Context): ControlAreaOperator =
    {
        ControlAreaOperator(
            sup (context),
            CAChildOf (context),
            ControlledBy (context)
        )
    }
}

/**
 * The energy buyer in the energy marketplace.
 */
case class CustomerConsumer
(

    override val sup: Organisation
)
extends
    Element
{
    def this () = { this (null) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[CustomerConsumer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CustomerConsumer
extends
    Parseable[CustomerConsumer]
{
    val sup = Organisation.parse _
    def parse (context: Context): CustomerConsumer =
    {
        CustomerConsumer(
            sup (context)
        )
    }
}

/**
 * The energy seller in the energy marketplace.
 */
case class GenerationProvider
(

    override val sup: Organisation
)
extends
    Element
{
    def this () = { this (null) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[GenerationProvider]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenerationProvider
extends
    Parseable[GenerationProvider]
{
    val sup = Organisation.parse _
    def parse (context: Context): GenerationProvider =
    {
        GenerationProvider(
            sup (context)
        )
    }
}

/**
 * A type of agreement that provides the default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
 */
case class IntSchedAgreement
(

    override val sup: Agreement,

    /**
     * The default method by which interchange schedules are to be integrated to obtain hourly MWh schedules for accounting.
     * Method #1 is to integrate the instantaneous schedule between the hourly boundaries. Method #2 compensates for any up/down ramping that occurs across the hourly boundary (this is called block accounting).
     */
    val defaultIntegrationMethod: String,

    val MktOrganisation: List[String]
)
extends
    Element
{
    def this () = { this (null, null, List()) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[IntSchedAgreement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntSchedAgreement
extends
    Parseable[IntSchedAgreement]
{
    val sup = Agreement.parse _
    val defaultIntegrationMethod = parse_element (element ("""IntSchedAgreement.defaultIntegrationMethod"""))_
    val MktOrganisation = parse_attributes (attribute ("""IntSchedAgreement.MktOrganisation"""))_
    def parse (context: Context): IntSchedAgreement =
    {
        IntSchedAgreement(
            sup (context),
            defaultIntegrationMethod (context),
            MktOrganisation (context)
        )
    }
}

/**
 * Matches buyers and sellers, and secures transmission (and other ancillary services) needed to complete the energy transaction.
 */
case class Marketer
(

    override val sup: Organisation
)
extends
    Element
{
    def this () = { this (null) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[Marketer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Marketer
extends
    Parseable[Marketer]
{
    val sup = Organisation.parse _
    def parse (context: Context): Marketer =
    {
        Marketer(
            sup (context)
        )
    }
}

/**
 * Contracts for services offered commercially.
 */
case class OpenAccessProduct
(

    override val sup: Agreement
)
extends
    Element
{
    def this () = { this (null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[OpenAccessProduct]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OpenAccessProduct
extends
    Parseable[OpenAccessProduct]
{
    val sup = Agreement.parse _
    def parse (context: Context): OpenAccessProduct =
    {
        OpenAccessProduct(
            sup (context)
        )
    }
}

case class TransmissionProduct
(

    override val sup: IdentifiedObject,

    /**
     * Type of the transmission product.
     * This could be a transmission service class (firm, total transmission capability, or non-firm), transmission service period (on-peak, full-period, off-peak), transmission service increments (yearly extended, hourly fixed, monthly sliding, etc.), transmission service type (network, available transmission capability, or point-to-point, or a transmission service window (fixed hourly, sliding weekly, extended monthly, etc.).
     */
    val transmissionProductType: String,

    /**
     * A transmission product is located on a transmission path.
     */
    val LocationFor: List[String],

    /**
     * A TransmissionProvider offers a TransmissionProduct.
     */
    val TransmissionProvider: String
)
extends
    Element
{
    def this () = { this (null, null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionProduct]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionProduct
extends
    Parseable[TransmissionProduct]
{
    val sup = IdentifiedObject.parse _
    val transmissionProductType = parse_element (element ("""TransmissionProduct.transmissionProductType"""))_
    val LocationFor = parse_attributes (attribute ("""TransmissionProduct.LocationFor"""))_
    val TransmissionProvider = parse_attribute (attribute ("""TransmissionProduct.TransmissionProvider"""))_
    def parse (context: Context): TransmissionProduct =
    {
        TransmissionProduct(
            sup (context),
            transmissionProductType (context),
            LocationFor (context),
            TransmissionProvider (context)
        )
    }
}

/**
 * Provider of  the transmission capacity (interconnecting wires between Generation and Consumption) required  to fulfill and Energy Transaction's energy exchange.
 * Posts information for transmission paths and AvailableTransmissionCapacities  on a reservation node.  Buys and sells its products and services on the same reservation node.
 */
case class TransmissionProvider
(

    override val sup: Organisation
)
extends
    Element
{
    def this () = { this (null) }
    def Organisation: Organisation = sup.asInstanceOf[Organisation]
    override def copy (): Row = { return (clone ().asInstanceOf[TransmissionProvider]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransmissionProvider
extends
    Parseable[TransmissionProvider]
{
    val sup = Organisation.parse _
    def parse (context: Context): TransmissionProvider =
    {
        TransmissionProvider(
            sup (context)
        )
    }
}

object _InfFinancial
{
    def register: Unit =
    {
        ControlAreaOperator.register
        CustomerConsumer.register
        GenerationProvider.register
        IntSchedAgreement.register
        Marketer.register
        OpenAccessProduct.register
        TransmissionProduct.register
        TransmissionProvider.register
    }
}