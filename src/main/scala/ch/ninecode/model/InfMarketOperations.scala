package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BilateralTransaction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BilateralTransaction.fields (position), value)
        emitelem (0, curtailTimeMax)
        emitelem (1, curtailTimeMin)
        emitelem (2, marketType)
        emitelem (3, purchaseTimeMax)
        emitelem (4, purchaseTimeMin)
        emitelem (5, scope)
        emitelem (6, totalTranChargeMax)
        emitelem (7, transactionType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BilateralTransaction rdf:ID=\"%s\">\n%s\t</cim:BilateralTransaction>".format (id, export_fields)
    }
}

object BilateralTransaction
extends
    Parseable[BilateralTransaction]
{
    override val fields: Array[String] = Array[String] (
        "curtailTimeMax",
        "curtailTimeMin",
        "marketType",
        "purchaseTimeMax",
        "purchaseTimeMin",
        "scope",
        "totalTranChargeMax",
        "transactionType"
    )
    val curtailTimeMax: Fielder = parse_element (element (cls, fields(0)))
    val curtailTimeMin: Fielder = parse_element (element (cls, fields(1)))
    val marketType: Fielder = parse_element (element (cls, fields(2)))
    val purchaseTimeMax: Fielder = parse_element (element (cls, fields(3)))
    val purchaseTimeMin: Fielder = parse_element (element (cls, fields(4)))
    val scope: Fielder = parse_element (element (cls, fields(5)))
    val totalTranChargeMax: Fielder = parse_element (element (cls, fields(6)))
    val transactionType: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): BilateralTransaction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BilateralTransaction (
            BasicElement.parse (context),
            toInteger (mask (curtailTimeMax (), 0)),
            toInteger (mask (curtailTimeMin (), 1)),
            mask (marketType (), 2),
            toInteger (mask (purchaseTimeMax (), 3)),
            toInteger (mask (purchaseTimeMin (), 4)),
            mask (scope (), 5),
            toDouble (mask (totalTranChargeMax (), 6)),
            mask (transactionType (), 7)
        )
        ret.bitfields = bitfields
        ret
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Participation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Participation.fields (position), value)
        emitelem (0, factor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Participation rdf:ID=\"%s\">\n%s\t</cim:Participation>".format (id, export_fields)
    }
}

object Participation
extends
    Parseable[Participation]
{
    override val fields: Array[String] = Array[String] (
        "factor"
    )
    val factor: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Participation =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Participation (
            IdentifiedObject.parse (context),
            toDouble (mask (factor (), 0))
        )
        ret.bitfields = bitfields
        ret
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
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
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
    certifiedSpinMw: Double,
    RegisteredResource: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0, null, 0.0, null, null, null, null, 0.0, null, null, 0.0, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceCertification.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ResourceCertification.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertification.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ResourceCertification.fields (position), x))
        emitattr (0, certifiedDAM)
        emitattr (1, certifiedNonspinDAM)
        emitelem (2, certifiedNonspinDAMMw)
        emitattr (3, certifiedNonspinRTM)
        emitelem (4, certifiedNonspinRTMMw)
        emitattr (5, certifiedPIRP)
        emitattr (6, certifiedRTM)
        emitattr (7, certifiedRUC)
        emitattr (8, certifiedRegulation)
        emitelem (9, certifiedRegulationMw)
        emitattr (10, certifiedReplaceAS)
        emitattr (11, certifiedSpin)
        emitelem (12, certifiedSpinMw)
        emitattrs (13, RegisteredResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertification rdf:ID=\"%s\">\n%s\t</cim:ResourceCertification>".format (id, export_fields)
    }
}

object ResourceCertification
extends
    Parseable[ResourceCertification]
{
    override val fields: Array[String] = Array[String] (
        "certifiedDAM",
        "certifiedNonspinDAM",
        "certifiedNonspinDAMMw",
        "certifiedNonspinRTM",
        "certifiedNonspinRTMMw",
        "certifiedPIRP",
        "certifiedRTM",
        "certifiedRUC",
        "certifiedRegulation",
        "certifiedRegulationMw",
        "certifiedReplaceAS",
        "certifiedSpin",
        "certifiedSpinMw",
        "RegisteredResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*")
    )
    val certifiedDAM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val certifiedNonspinDAM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val certifiedNonspinDAMMw: Fielder = parse_element (element (cls, fields(2)))
    val certifiedNonspinRTM: Fielder = parse_attribute (attribute (cls, fields(3)))
    val certifiedNonspinRTMMw: Fielder = parse_element (element (cls, fields(4)))
    val certifiedPIRP: Fielder = parse_attribute (attribute (cls, fields(5)))
    val certifiedRTM: Fielder = parse_attribute (attribute (cls, fields(6)))
    val certifiedRUC: Fielder = parse_attribute (attribute (cls, fields(7)))
    val certifiedRegulation: Fielder = parse_attribute (attribute (cls, fields(8)))
    val certifiedRegulationMw: Fielder = parse_element (element (cls, fields(9)))
    val certifiedReplaceAS: Fielder = parse_attribute (attribute (cls, fields(10)))
    val certifiedSpin: Fielder = parse_attribute (attribute (cls, fields(11)))
    val certifiedSpinMw: Fielder = parse_element (element (cls, fields(12)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): ResourceCertification =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ResourceCertification (
            BasicElement.parse (context),
            mask (certifiedDAM (), 0),
            mask (certifiedNonspinDAM (), 1),
            toDouble (mask (certifiedNonspinDAMMw (), 2)),
            mask (certifiedNonspinRTM (), 3),
            toDouble (mask (certifiedNonspinRTMMw (), 4)),
            mask (certifiedPIRP (), 5),
            mask (certifiedRTM (), 6),
            mask (certifiedRUC (), 7),
            mask (certifiedRegulation (), 8),
            toDouble (mask (certifiedRegulationMw (), 9)),
            mask (certifiedReplaceAS (), 10),
            mask (certifiedSpin (), 11),
            toDouble (mask (certifiedSpinMw (), 12)),
            masks (RegisteredResource (), 13)
        )
        ret.bitfields = bitfields
        ret
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