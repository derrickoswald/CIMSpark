package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Bilateral transaction
 *
 * @param sup Reference to the superclass object.
 * @param curtailTimeMax Maximum curtailment time in number of trading intervals
 * @param curtailTimeMin Minimum curtailment time in number of trading intervals
 * @param marketType Market type (default=DA)
 *        DA - Day Ahead
 *        RT - Real Time
 *        HA - Hour Ahead
 * @param purchaseTimeMax Maximum purchase time in number of trading intervals
 * @param purchaseTimeMin Minimum purchase time in number of trading intervals
 * @param scope Transaction scope:
 *        'Internal' (default)
 *        'External'
 * @param totalTranChargeMax Maximum total transmission (congestion) charges in monetary units
 * @param transactionType Transaction type (default 1)
 *        1 - Fixed
 *        2 - Dispatchable continuous
 *        3 - Dispatchable block-loading
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
case class BilateralTransaction
(
    override val sup: BasicElement,
    curtailTimeMax: Int,
    curtailTimeMin: Int,
    marketType: String,
    purchaseTimeMax: Int,
    purchaseTimeMin: Int,
    scope: String,
    totalTranChargeMax: Double,
    transactionType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, null, 0, 0, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BilateralTransaction] }
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
        "\t\t<cim:BilateralTransaction.curtailTimeMax>" + curtailTimeMax + "</cim:BilateralTransaction.curtailTimeMax>\n" +
        "\t\t<cim:BilateralTransaction.curtailTimeMin>" + curtailTimeMin + "</cim:BilateralTransaction.curtailTimeMin>\n" +
        (if (null != marketType) "\t\t<cim:BilateralTransaction.marketType>" + marketType + "</cim:BilateralTransaction.marketType>\n" else "") +
        "\t\t<cim:BilateralTransaction.purchaseTimeMax>" + purchaseTimeMax + "</cim:BilateralTransaction.purchaseTimeMax>\n" +
        "\t\t<cim:BilateralTransaction.purchaseTimeMin>" + purchaseTimeMin + "</cim:BilateralTransaction.purchaseTimeMin>\n" +
        (if (null != scope) "\t\t<cim:BilateralTransaction.scope>" + scope + "</cim:BilateralTransaction.scope>\n" else "") +
        "\t\t<cim:BilateralTransaction.totalTranChargeMax>" + totalTranChargeMax + "</cim:BilateralTransaction.totalTranChargeMax>\n" +
        (if (null != transactionType) "\t\t<cim:BilateralTransaction.transactionType>" + transactionType + "</cim:BilateralTransaction.transactionType>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BilateralTransaction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BilateralTransaction>"
    }
}

object BilateralTransaction
extends
    Parseable[BilateralTransaction]
{
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
            BasicElement.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param factor Used to calculate "participation" of Pnode in an AggregatePnode.
 *        For example, for regulation region this factor is 1 and total sum of all factors for a specific regulation region does not have to be 1. For pricing zone the total sum of all factors has to be 1.
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
case class Participation
(
    override val sup: IdentifiedObject,
    factor: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Participation] }
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
        "\t\t<cim:Participation.factor>" + factor + "</cim:Participation.factor>\n"
    }
    override def export: String =
    {
        "\t<cim:Participation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Participation>"
    }
}

object Participation
extends
    Parseable[Participation]
{
    val factor = parse_element (element ("""Participation.factor"""))
    def parse (context: Context): Participation =
    {
        Participation(
            IdentifiedObject.parse (context),
            toDouble (factor (context), context)
        )
    }
}

/**
 * This class represent the resource certification for a specific product type.
 *
 * For example, a resource is certified for Non-Spinning reserve for RTM.
 *
 * @param sup Reference to the superclass object.
 * @param certifiedDAM <em>undocumented</em>
 * @param certifiedNonspinDAM <em>undocumented</em>
 * @param certifiedNonspinDAMMw <em>undocumented</em>
 * @param certifiedNonspinRTM <em>undocumented</em>
 * @param certifiedNonspinRTMMw <em>undocumented</em>
 * @param certifiedPIRP <em>undocumented</em>
 * @param certifiedRTM <em>undocumented</em>
 * @param certifiedRUC <em>undocumented</em>
 * @param certifiedRegulation <em>undocumented</em>
 * @param certifiedRegulationMw <em>undocumented</em>
 * @param certifiedReplaceAS <em>undocumented</em>
 * @param certifiedSpin <em>undocumented</em>
 * @param certifiedSpinMw <em>undocumented</em>
 * @group InfMarketOperations
 * @groupname InfMarketOperations Package InfMarketOperations
 */
case class ResourceCertification
(
    override val sup: BasicElement,
    certifiedDAM: String,
    certifiedNonspinDAM: String,
    certifiedNonspinDAMMw: Double,
    certifiedNonspinRTM: String,
    certifiedNonspinRTMMw: Double,
    certifiedPIRP: String,
    certifiedRTM: String,
    certifiedRUC: String,
    certifiedRegulation: String,
    certifiedRegulationMw: Double,
    certifiedReplaceAS: String,
    certifiedSpin: String,
    certifiedSpinMw: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, 0.0, null, null, null, null, 0.0, null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCertification] }
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
        (if (null != certifiedDAM) "\t\t<cim:ResourceCertification.certifiedDAM rdf:resource=\"#" + certifiedDAM + "\"/>\n" else "") +
        (if (null != certifiedNonspinDAM) "\t\t<cim:ResourceCertification.certifiedNonspinDAM rdf:resource=\"#" + certifiedNonspinDAM + "\"/>\n" else "") +
        "\t\t<cim:ResourceCertification.certifiedNonspinDAMMw>" + certifiedNonspinDAMMw + "</cim:ResourceCertification.certifiedNonspinDAMMw>\n" +
        (if (null != certifiedNonspinRTM) "\t\t<cim:ResourceCertification.certifiedNonspinRTM rdf:resource=\"#" + certifiedNonspinRTM + "\"/>\n" else "") +
        "\t\t<cim:ResourceCertification.certifiedNonspinRTMMw>" + certifiedNonspinRTMMw + "</cim:ResourceCertification.certifiedNonspinRTMMw>\n" +
        (if (null != certifiedPIRP) "\t\t<cim:ResourceCertification.certifiedPIRP rdf:resource=\"#" + certifiedPIRP + "\"/>\n" else "") +
        (if (null != certifiedRTM) "\t\t<cim:ResourceCertification.certifiedRTM rdf:resource=\"#" + certifiedRTM + "\"/>\n" else "") +
        (if (null != certifiedRUC) "\t\t<cim:ResourceCertification.certifiedRUC rdf:resource=\"#" + certifiedRUC + "\"/>\n" else "") +
        (if (null != certifiedRegulation) "\t\t<cim:ResourceCertification.certifiedRegulation rdf:resource=\"#" + certifiedRegulation + "\"/>\n" else "") +
        "\t\t<cim:ResourceCertification.certifiedRegulationMw>" + certifiedRegulationMw + "</cim:ResourceCertification.certifiedRegulationMw>\n" +
        (if (null != certifiedReplaceAS) "\t\t<cim:ResourceCertification.certifiedReplaceAS rdf:resource=\"#" + certifiedReplaceAS + "\"/>\n" else "") +
        (if (null != certifiedSpin) "\t\t<cim:ResourceCertification.certifiedSpin rdf:resource=\"#" + certifiedSpin + "\"/>\n" else "") +
        "\t\t<cim:ResourceCertification.certifiedSpinMw>" + certifiedSpinMw + "</cim:ResourceCertification.certifiedSpinMw>\n"
    }
    override def export: String =
    {
        "\t<cim:ResourceCertification rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceCertification>"
    }
}

object ResourceCertification
extends
    Parseable[ResourceCertification]
{
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
            BasicElement.parse (context),
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

private[ninecode] object _InfMarketOperations
{
    def register: List[ClassInfo] =
    {
        List (
            BilateralTransaction.register,
            Participation.register,
            ResourceCertification.register
        )
    }
}