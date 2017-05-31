package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Bilateral transaction
 * @param sup Reference to the superclass object.
 * @param curtailTimeMax Maximum curtailment time in number of trading intervals
 * @param curtailTimeMin Minimum curtailment time in number of trading intervals
 * @param marketType Market type (default=DA)
DA - Day Ahead
RT - Real Time
 *        HA - Hour Ahead
 * @param purchaseTimeMax Maximum purchase time in number of trading intervals
 * @param purchaseTimeMin Minimum purchase time in number of trading intervals
 * @param scope Transaction scope:
'Internal' (default)
 *        'External'
 * @param totalTranChargeMax Maximum total transmission (congestion) charges in monetary units
 * @param transactionType Transaction type (default 1)
1 - Fixed
2 - Dispatchable continuous
 *        3 - Dispatchable block-loading
 */
case class BilateralTransaction
(
    override val sup: BasicElement,
    val curtailTimeMax: Int,
    val curtailTimeMin: Int,
    val marketType: String,
    val purchaseTimeMax: Int,
    val purchaseTimeMin: Int,
    val scope: String,
    val totalTranChargeMax: Double,
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
    val curtailTimeMax = parse_element (element ("""BilateralTransaction.curtailTimeMax"""))
    val curtailTimeMin = parse_element (element ("""BilateralTransaction.curtailTimeMin"""))
    val marketType = parse_element (element ("""BilateralTransaction.marketType"""))
    val purchaseTimeMax = parse_element (element ("""BilateralTransaction.purchaseTimeMax"""))
    val purchaseTimeMin = parse_element (element ("""BilateralTransaction.purchaseTimeMin"""))
    val scope = parse_element (element ("""BilateralTransaction.scope"""))
    val totalTranChargeMax = parse_element (element ("""BilateralTransaction.totalTranChargeMax"""))
    val transactionType = parse_element (element ("""BilateralTransaction.transactionType"""))
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
 * @param sup Reference to the superclass object.
 * @param factor Used to calculate "participation" of Pnode in an AggregatePnode.
 *        For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 */
case class Participation
(
    override val sup: IdentifiedObject,
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
    val factor = parse_element (element ("""Participation.factor"""))
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
 * @param sup Reference to the superclass object.
 * @param certifiedDAM
 * @param certifiedNonspinDAM
 * @param certifiedNonspinDAMMw
 * @param certifiedNonspinRTM
 * @param certifiedNonspinRTMMw
 * @param certifiedPIRP
 * @param certifiedRTM
 * @param certifiedRUC
 * @param certifiedRegulation
 * @param certifiedRegulationMw
 * @param certifiedReplaceAS
 * @param certifiedSpin
 * @param certifiedSpinMw
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
    val certifiedDAM = parse_attribute (attribute ("""ResourceCertification.certifiedDAM"""))
    val certifiedNonspinDAM = parse_attribute (attribute ("""ResourceCertification.certifiedNonspinDAM"""))
    val certifiedNonspinDAMMw = parse_element (element ("""ResourceCertification.certifiedNonspinDAMMw"""))
    val certifiedNonspinRTM = parse_attribute (attribute ("""ResourceCertification.certifiedNonspinRTM"""))
    val certifiedNonspinRTMMw = parse_element (element ("""ResourceCertification.certifiedNonspinRTMMw"""))
    val certifiedPIRP = parse_attribute (attribute ("""ResourceCertification.certifiedPIRP"""))
    val certifiedRTM = parse_attribute (attribute ("""ResourceCertification.certifiedRTM"""))
    val certifiedRUC = parse_attribute (attribute ("""ResourceCertification.certifiedRUC"""))
    val certifiedRegulation = parse_attribute (attribute ("""ResourceCertification.certifiedRegulation"""))
    val certifiedRegulationMw = parse_element (element ("""ResourceCertification.certifiedRegulationMw"""))
    val certifiedReplaceAS = parse_attribute (attribute ("""ResourceCertification.certifiedReplaceAS"""))
    val certifiedSpin = parse_attribute (attribute ("""ResourceCertification.certifiedSpin"""))
    val certifiedSpinMw = parse_element (element ("""ResourceCertification.certifiedSpinMw"""))
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