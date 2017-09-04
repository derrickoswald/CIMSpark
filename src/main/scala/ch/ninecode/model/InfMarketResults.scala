package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Model of market clearing related to results at the inter-ties.
 *
 * Identifies interval
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class InterTieClearing
(
    override val sup: MarketFactors
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
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[InterTieClearing] }
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
        "\t<cim:InterTieClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterTieClearing>"
    }
}

object InterTieClearing
extends
    Parseable[InterTieClearing]
{
    def parse (context: Context): InterTieClearing =
    {
        InterTieClearing(
            MarketFactors.parse (context)
        )
    }
}

/**
 * Provides the tie point specific output from the market applications.
 *
 * Currently, this is defined as the loop flow compensation MW value.
 *
 * @param sup Reference to the superclass object.
 * @param baseMW Net Actual MW Flow
 * @param clearedValue Net Dispatched MW
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterTieClearing [[ch.ninecode.model.InterTieClearing InterTieClearing]] <em>undocumented</em>
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class InterTieResults
(
    override val sup: BasicElement,
    baseMW: Double,
    clearedValue: Double,
    Flowgate: String,
    InterTieClearing: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InterTieResults] }
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
        "\t\t<cim:InterTieResults.baseMW>" + baseMW + "</cim:InterTieResults.baseMW>\n" +
        "\t\t<cim:InterTieResults.clearedValue>" + clearedValue + "</cim:InterTieResults.clearedValue>\n" +
        (if (null != Flowgate) "\t\t<cim:InterTieResults.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != InterTieClearing) "\t\t<cim:InterTieResults.InterTieClearing rdf:resource=\"#" + InterTieClearing + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterTieResults rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterTieResults>"
    }
}

object InterTieResults
extends
    Parseable[InterTieResults]
{
    val baseMW = parse_element (element ("""InterTieResults.baseMW"""))
    val clearedValue = parse_element (element ("""InterTieResults.clearedValue"""))
    val Flowgate = parse_attribute (attribute ("""InterTieResults.Flowgate"""))
    val InterTieClearing = parse_attribute (attribute ("""InterTieResults.InterTieClearing"""))
    def parse (context: Context): InterTieResults =
    {
        InterTieResults(
            BasicElement.parse (context),
            toDouble (baseMW (context), context),
            toDouble (clearedValue (context), context),
            Flowgate (context),
            InterTieClearing (context)
        )
    }
}

/**
 * Market case clearing results are posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param caseType Settlement period:
 *        'DA - Bid-in'
 *        'DA - Reliability'
 *        'DA - Amp1'
 *        'DA - Amp2'
 *        'RT - Ex-Ante'
 *        'RT - Ex-Post'
 *        'RT - Amp1'
 *        'RT - Amp2'
 * @param modifiedDate Last time and date clearing results were manually modified.
 * @param postedDate Bid clearing results posted time and date.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class MarketCaseClearing
(
    override val sup: MarketFactors,
    caseType: String,
    modifiedDate: String,
    postedDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[MarketCaseClearing] }
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
        (if (null != caseType) "\t\t<cim:MarketCaseClearing.caseType>" + caseType + "</cim:MarketCaseClearing.caseType>\n" else "") +
        (if (null != modifiedDate) "\t\t<cim:MarketCaseClearing.modifiedDate>" + modifiedDate + "</cim:MarketCaseClearing.modifiedDate>\n" else "") +
        (if (null != postedDate) "\t\t<cim:MarketCaseClearing.postedDate>" + postedDate + "</cim:MarketCaseClearing.postedDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketCaseClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketCaseClearing>"
    }
}

object MarketCaseClearing
extends
    Parseable[MarketCaseClearing]
{
    val caseType = parse_element (element ("""MarketCaseClearing.caseType"""))
    val modifiedDate = parse_element (element ("""MarketCaseClearing.modifiedDate"""))
    val postedDate = parse_element (element ("""MarketCaseClearing.postedDate"""))
    def parse (context: Context): MarketCaseClearing =
    {
        MarketCaseClearing(
            MarketFactors.parse (context),
            caseType (context),
            modifiedDate (context),
            postedDate (context)
        )
    }
}

/**
 * Binding security constrained clearing results posted for a given settlement period.
 *
 * @param sup [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param mwFlow Optimal MW flow
 * @param mwLimit Binding MW limit.
 * @param shadowPrice Security constraint shadow price.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
case class SecurityConstraintsClearing
(
    override val sup: MarketFactors,
    mwFlow: Double,
    mwLimit: Double,
    shadowPrice: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketFactors: MarketFactors = sup.asInstanceOf[MarketFactors]
    override def copy (): Row = { clone ().asInstanceOf[SecurityConstraintsClearing] }
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
        "\t\t<cim:SecurityConstraintsClearing.mwFlow>" + mwFlow + "</cim:SecurityConstraintsClearing.mwFlow>\n" +
        "\t\t<cim:SecurityConstraintsClearing.mwLimit>" + mwLimit + "</cim:SecurityConstraintsClearing.mwLimit>\n" +
        "\t\t<cim:SecurityConstraintsClearing.shadowPrice>" + shadowPrice + "</cim:SecurityConstraintsClearing.shadowPrice>\n"
    }
    override def export: String =
    {
        "\t<cim:SecurityConstraintsClearing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SecurityConstraintsClearing>"
    }
}

object SecurityConstraintsClearing
extends
    Parseable[SecurityConstraintsClearing]
{
    val mwFlow = parse_element (element ("""SecurityConstraintsClearing.mwFlow"""))
    val mwLimit = parse_element (element ("""SecurityConstraintsClearing.mwLimit"""))
    val shadowPrice = parse_element (element ("""SecurityConstraintsClearing.shadowPrice"""))
    def parse (context: Context): SecurityConstraintsClearing =
    {
        SecurityConstraintsClearing(
            MarketFactors.parse (context),
            toDouble (mwFlow (context), context),
            toDouble (mwLimit (context), context),
            toDouble (shadowPrice (context), context)
        )
    }
}

private[ninecode] object _InfMarketResults
{
    def register: List[ClassInfo] =
    {
        List (
            InterTieClearing.register,
            InterTieResults.register,
            MarketCaseClearing.register,
            SecurityConstraintsClearing.register
        )
    }
}