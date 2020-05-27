package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Generic generation equipment that may be used for various purposes such as work planning.
 *
 * It defines both the Real and Reactive power properties (modelled at the PSR level as a GeneratingUnit + SynchronousMachine).
 *
 * @param CatalogAssetType [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] Reference to the superclass object.
 * @param maxP Maximum real power limit.
 * @param maxQ Maximum reactive power limit.
 * @param minP Minimum real power generated.
 * @param minQ Minimum reactive power generated.
 * @param rDirectSubtrans Direct-axis subtransient resistance.
 * @param rDirectSync Direct-axis synchronous resistance.
 * @param rDirectTrans Direct-axis transient resistance.
 * @param rQuadSubtrans Quadrature-axis subtransient resistance.
 * @param rQuadSync Quadrature-axis synchronous resistance.
 * @param rQuadTrans Quadrature-axis transient resistance.
 * @param xDirectSubtrans Direct-axis subtransient reactance.
 * @param xDirectSync Direct-axis synchronous reactance.
 * @param xDirectTrans Direct-axis transient reactance.
 * @param xQuadSubtrans Quadrature-axis subtransient reactance.
 * @param xQuadSync Quadrature-axis synchronous reactance.
 * @param xQuadTrans Quadrature-axis transient reactance.
 * @group InfTypeAsset
 * @groupname InfTypeAsset Package InfTypeAsset
 */
final case class GeneratorTypeAsset
(
    CatalogAssetType: CatalogAssetType = null,
    maxP: Double = 0.0,
    maxQ: Double = 0.0,
    minP: Double = 0.0,
    minQ: Double = 0.0,
    rDirectSubtrans: Double = 0.0,
    rDirectSync: Double = 0.0,
    rDirectTrans: Double = 0.0,
    rQuadSubtrans: Double = 0.0,
    rQuadSync: Double = 0.0,
    rQuadTrans: Double = 0.0,
    xDirectSubtrans: Double = 0.0,
    xDirectSync: Double = 0.0,
    xDirectTrans: Double = 0.0,
    xQuadSubtrans: Double = 0.0,
    xQuadSync: Double = 0.0,
    xQuadTrans: Double = 0.0
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
    override def sup: CatalogAssetType = CatalogAssetType

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
        implicit val clz: String = GeneratorTypeAsset.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GeneratorTypeAsset.fields (position), value)
        emitelem (0, maxP)
        emitelem (1, maxQ)
        emitelem (2, minP)
        emitelem (3, minQ)
        emitelem (4, rDirectSubtrans)
        emitelem (5, rDirectSync)
        emitelem (6, rDirectTrans)
        emitelem (7, rQuadSubtrans)
        emitelem (8, rQuadSync)
        emitelem (9, rQuadTrans)
        emitelem (10, xDirectSubtrans)
        emitelem (11, xDirectSync)
        emitelem (12, xDirectTrans)
        emitelem (13, xQuadSubtrans)
        emitelem (14, xQuadSync)
        emitelem (15, xQuadTrans)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeneratorTypeAsset rdf:ID=\"%s\">\n%s\t</cim:GeneratorTypeAsset>".format (id, export_fields)
    }
}

object GeneratorTypeAsset
extends
    Parseable[GeneratorTypeAsset]
{
    override val fields: Array[String] = Array[String] (
        "maxP",
        "maxQ",
        "minP",
        "minQ",
        "rDirectSubtrans",
        "rDirectSync",
        "rDirectTrans",
        "rQuadSubtrans",
        "rQuadSync",
        "rQuadTrans",
        "xDirectSubtrans",
        "xDirectSync",
        "xDirectTrans",
        "xQuadSubtrans",
        "xQuadSync",
        "xQuadTrans"
    )
    val maxP: Fielder = parse_element (element (cls, fields(0)))
    val maxQ: Fielder = parse_element (element (cls, fields(1)))
    val minP: Fielder = parse_element (element (cls, fields(2)))
    val minQ: Fielder = parse_element (element (cls, fields(3)))
    val rDirectSubtrans: Fielder = parse_element (element (cls, fields(4)))
    val rDirectSync: Fielder = parse_element (element (cls, fields(5)))
    val rDirectTrans: Fielder = parse_element (element (cls, fields(6)))
    val rQuadSubtrans: Fielder = parse_element (element (cls, fields(7)))
    val rQuadSync: Fielder = parse_element (element (cls, fields(8)))
    val rQuadTrans: Fielder = parse_element (element (cls, fields(9)))
    val xDirectSubtrans: Fielder = parse_element (element (cls, fields(10)))
    val xDirectSync: Fielder = parse_element (element (cls, fields(11)))
    val xDirectTrans: Fielder = parse_element (element (cls, fields(12)))
    val xQuadSubtrans: Fielder = parse_element (element (cls, fields(13)))
    val xQuadSync: Fielder = parse_element (element (cls, fields(14)))
    val xQuadTrans: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): GeneratorTypeAsset =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GeneratorTypeAsset (
            CatalogAssetType.parse (context),
            toDouble (mask (maxP (), 0)),
            toDouble (mask (maxQ (), 1)),
            toDouble (mask (minP (), 2)),
            toDouble (mask (minQ (), 3)),
            toDouble (mask (rDirectSubtrans (), 4)),
            toDouble (mask (rDirectSync (), 5)),
            toDouble (mask (rDirectTrans (), 6)),
            toDouble (mask (rQuadSubtrans (), 7)),
            toDouble (mask (rQuadSync (), 8)),
            toDouble (mask (rQuadTrans (), 9)),
            toDouble (mask (xDirectSubtrans (), 10)),
            toDouble (mask (xDirectSync (), 11)),
            toDouble (mask (xDirectTrans (), 12)),
            toDouble (mask (xQuadSubtrans (), 13)),
            toDouble (mask (xQuadSync (), 14)),
            toDouble (mask (xQuadTrans (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Catalogue of generic types of assets (TypeAsset) that may be used for design purposes.
 *
 * It is not associated with a particular manufacturer.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param status <em>undocumented</em>
 * @param TypeAssets [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] <em>undocumented</em>
 * @group InfTypeAsset
 * @groupname InfTypeAsset Package InfTypeAsset
 */
final case class TypeAssetCatalogue
(
    IdentifiedObject: IdentifiedObject = null,
    status: String = null,
    TypeAssets: List[String] = null
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
        implicit val clz: String = TypeAssetCatalogue.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TypeAssetCatalogue.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TypeAssetCatalogue.fields (position), x))
        emitattr (0, status)
        emitattrs (1, TypeAssets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TypeAssetCatalogue rdf:ID=\"%s\">\n%s\t</cim:TypeAssetCatalogue>".format (id, export_fields)
    }
}

object TypeAssetCatalogue
extends
    Parseable[TypeAssetCatalogue]
{
    override val fields: Array[String] = Array[String] (
        "status",
        "TypeAssets"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TypeAssets", "CatalogAssetType", "0..*", "0..1")
    )
    val status: Fielder = parse_attribute (attribute (cls, fields(0)))
    val TypeAssets: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): TypeAssetCatalogue =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TypeAssetCatalogue (
            IdentifiedObject.parse (context),
            mask (status (), 0),
            masks (TypeAssets (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfTypeAsset
{
    def register: List[ClassInfo] =
    {
        List (
            GeneratorTypeAsset.register,
            TypeAssetCatalogue.register
        )
    }
}