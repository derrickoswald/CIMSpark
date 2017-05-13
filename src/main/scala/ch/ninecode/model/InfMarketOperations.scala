package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Bilateral transaction
 */
case class BilateralTransaction
(

    override val sup: BasicElement,

    /**
     * Maximum curtailment time in number of trading intervals
     */
    val curtailTimeMax: Int,

    /**
     * Minimum curtailment time in number of trading intervals
     */
    val curtailTimeMin: Int,

    /**
     * Market type (default=DA)
    DA - Day Ahead
    RT - Real Time
     * HA - Hour Ahead
     */
    val marketType: String,

    /**
     * Maximum purchase time in number of trading intervals
     */
    val purchaseTimeMax: Int,

    /**
     * Minimum purchase time in number of trading intervals
     */
    val purchaseTimeMin: Int,

    /**
     * Transaction scope:
    'Internal' (default)
     * 'External'
     */
    val scope: String,

    /**
     * Maximum total transmission (congestion) charges in monetary units
     */
    val totalTranChargeMax: Double,

    /**
     * Transaction type (default 1)
    1 - Fixed
    2 - Dispatchable continuous
     * 3 - Dispatchable block-loading
     */
    val transactionType: String
)
extends
    Element
{
    def this () = { this (null, 0, 0, null, 0, 0, null, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BilateralTransaction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BilateralTransaction
extends
    Parseable[BilateralTransaction]
{
    val sup = BasicElement.parse _
    val curtailTimeMax = parse_element (element ("""BilateralTransaction.curtailTimeMax"""))_
    val curtailTimeMin = parse_element (element ("""BilateralTransaction.curtailTimeMin"""))_
    val marketType = parse_element (element ("""BilateralTransaction.marketType"""))_
    val purchaseTimeMax = parse_element (element ("""BilateralTransaction.purchaseTimeMax"""))_
    val purchaseTimeMin = parse_element (element ("""BilateralTransaction.purchaseTimeMin"""))_
    val scope = parse_element (element ("""BilateralTransaction.scope"""))_
    val totalTranChargeMax = parse_element (element ("""BilateralTransaction.totalTranChargeMax"""))_
    val transactionType = parse_element (element ("""BilateralTransaction.transactionType"""))_
    def parse (context: Context): BilateralTransaction =
    {
        BilateralTransaction(
            sup (context),
            toInteger (curtailTimeMax (context), context),
            toInteger (curtailTimeMin (context), context),
            marketType (context),
            toInteger (purchaseTimeMax (context), context),
            toInteger (purchaseTimeMin (context), context),
            scope (context),
            toDouble (totalTranChargeMax (context), context),
            transactionType (context)
        )
    }
}

/**
 * Participation level of a given Pnode in a given AggregatePnode.
 */
case class Participation
(

    override val sup: IdentifiedObject,

    /**
     * Used to calculate "participation" of Pnode in an AggregatePnode.
     * For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
     */
    val factor: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Participation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Participation
extends
    Parseable[Participation]
{
    val sup = IdentifiedObject.parse _
    val factor = parse_element (element ("""Participation.factor"""))_
    def parse (context: Context): Participation =
    {
        Participation(
            sup (context),
            toDouble (factor (context), context)
        )
    }
}

/**
 * This class represent the resource certification for a specific product type.
 * For example, a resource is certified for Non-Spinning reserve for RTM.
 */
case class ResourceCertification
(

    override val sup: BasicElement,

    val certifiedDAM: String,

    val certifiedNonspinDAM: String,

    val certifiedNonspinDAMMw: Double,

    val certifiedNonspinRTM: String,

    val certifiedNonspinRTMMw: Double,

    val certifiedPIRP: String,

    val certifiedRTM: String,

    val certifiedRUC: String,

    val certifiedRegulation: String,

    val certifiedRegulationMw: Double,

    val certifiedReplaceAS: String,

    val certifiedSpin: String,

    val certifiedSpinMw: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, null, 0.0, null, null, null, null, 0.0, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceCertification]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceCertification
extends
    Parseable[ResourceCertification]
{
    val sup = BasicElement.parse _
    val certifiedDAM = parse_attribute (attribute ("""ResourceCertification.certifiedDAM"""))_
    val certifiedNonspinDAM = parse_attribute (attribute ("""ResourceCertification.certifiedNonspinDAM"""))_
    val certifiedNonspinDAMMw = parse_element (element ("""ResourceCertification.certifiedNonspinDAMMw"""))_
    val certifiedNonspinRTM = parse_attribute (attribute ("""ResourceCertification.certifiedNonspinRTM"""))_
    val certifiedNonspinRTMMw = parse_element (element ("""ResourceCertification.certifiedNonspinRTMMw"""))_
    val certifiedPIRP = parse_attribute (attribute ("""ResourceCertification.certifiedPIRP"""))_
    val certifiedRTM = parse_attribute (attribute ("""ResourceCertification.certifiedRTM"""))_
    val certifiedRUC = parse_attribute (attribute ("""ResourceCertification.certifiedRUC"""))_
    val certifiedRegulation = parse_attribute (attribute ("""ResourceCertification.certifiedRegulation"""))_
    val certifiedRegulationMw = parse_element (element ("""ResourceCertification.certifiedRegulationMw"""))_
    val certifiedReplaceAS = parse_attribute (attribute ("""ResourceCertification.certifiedReplaceAS"""))_
    val certifiedSpin = parse_attribute (attribute ("""ResourceCertification.certifiedSpin"""))_
    val certifiedSpinMw = parse_element (element ("""ResourceCertification.certifiedSpinMw"""))_
    def parse (context: Context): ResourceCertification =
    {
        ResourceCertification(
            sup (context),
            certifiedDAM (context),
            certifiedNonspinDAM (context),
            toDouble (certifiedNonspinDAMMw (context), context),
            certifiedNonspinRTM (context),
            toDouble (certifiedNonspinRTMMw (context), context),
            certifiedPIRP (context),
            certifiedRTM (context),
            certifiedRUC (context),
            certifiedRegulation (context),
            toDouble (certifiedRegulationMw (context), context),
            certifiedReplaceAS (context),
            certifiedSpin (context),
            toDouble (certifiedSpinMw (context), context)
        )
    }
}

object _InfMarketOperations
{
    def register: Unit =
    {
        BilateralTransaction.register
        Participation.register
        ResourceCertification.register
    }
}