package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Model of market clearing related to results at the inter-ties.
 * Identifies interval
 * @param sup Reference to the superclass object.
 */
case class InterTieClearing
(override val sup: MarketFactors
)
extends
    Element
{
    def this () = { this (null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[InterTieClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterTieClearing
extends
    Parseable[InterTieClearing]
{
    val sup = MarketFactors.parse _
    def parse (context: Context): InterTieClearing =
    {
        InterTieClearing(
            sup (context)
        )
    }
}

/**
 * Provides the tie point specific output from the market applications.
 * Currently, this is defined as the loop flow compensation MW value.
 * @param sup Reference to the superclass object.
 * @param baseMW Net Actual MW Flow
 * @param clearedValue Net Dispatched MW
 * @param Flowgate
 * @param InterTieClearing
 */
case class InterTieResults
(override val sup: BasicElement,
val baseMW: Double,
val clearedValue: Double,
val Flowgate: String,
val InterTieClearing: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InterTieResults]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterTieResults
extends
    Parseable[InterTieResults]
{
    val sup = BasicElement.parse _
    val baseMW = parse_element (element ("""InterTieResults.baseMW"""))_
    val clearedValue = parse_element (element ("""InterTieResults.clearedValue"""))_
    val Flowgate = parse_attribute (attribute ("""InterTieResults.Flowgate"""))_
    val InterTieClearing = parse_attribute (attribute ("""InterTieResults.InterTieClearing"""))_
    def parse (context: Context): InterTieResults =
    {
        InterTieResults(
            sup (context),
            toDouble (baseMW (context), context),
            toDouble (clearedValue (context), context),
            Flowgate (context),
            InterTieClearing (context)
        )
    }
}

/**
 * Market case clearing results are posted for a given settlement period.
 * @param sup Reference to the superclass object.
 * @param caseType Settlement period:
'DA - Bid-in'
'DA - Reliability'
'DA - Amp1'
'DA - Amp2'
'RT - Ex-Ante'
'RT - Ex-Post'
'RT - Amp1'
 *        'RT - Amp2'
 * @param modifiedDate Last time and date clearing results were manually modified.
 * @param postedDate Bid clearing results posted time and date.
 */
case class MarketCaseClearing
(override val sup: MarketFactors,
val caseType: String,
val modifiedDate: String,
val postedDate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketCaseClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketCaseClearing
extends
    Parseable[MarketCaseClearing]
{
    val sup = MarketFactors.parse _
    val caseType = parse_element (element ("""MarketCaseClearing.caseType"""))_
    val modifiedDate = parse_element (element ("""MarketCaseClearing.modifiedDate"""))_
    val postedDate = parse_element (element ("""MarketCaseClearing.postedDate"""))_
    def parse (context: Context): MarketCaseClearing =
    {
        MarketCaseClearing(
            sup (context),
            caseType (context),
            modifiedDate (context),
            postedDate (context)
        )
    }
}

/**
 * Binding security constrained clearing results posted for a given settlement period.
 * @param sup Reference to the superclass object.
 * @param mwFlow Optimal MW flow
 * @param mwLimit Binding MW limit.
 * @param shadowPrice Security constraint shadow price.
 */
case class SecurityConstraintsClearing
(override val sup: MarketFactors,
val mwFlow: Double,
val mwLimit: Double,
val shadowPrice: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { return (clone ().asInstanceOf[SecurityConstraintsClearing]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SecurityConstraintsClearing
extends
    Parseable[SecurityConstraintsClearing]
{
    val sup = MarketFactors.parse _
    val mwFlow = parse_element (element ("""SecurityConstraintsClearing.mwFlow"""))_
    val mwLimit = parse_element (element ("""SecurityConstraintsClearing.mwLimit"""))_
    val shadowPrice = parse_element (element ("""SecurityConstraintsClearing.shadowPrice"""))_
    def parse (context: Context): SecurityConstraintsClearing =
    {
        SecurityConstraintsClearing(
            sup (context),
            toDouble (mwFlow (context), context),
            toDouble (mwLimit (context), context),
            toDouble (shadowPrice (context), context)
        )
    }
}

object _InfMarketResults
{
    def register: Unit =
    {
        InterTieClearing.register
        InterTieResults.register
        MarketCaseClearing.register
        SecurityConstraintsClearing.register
    }
}