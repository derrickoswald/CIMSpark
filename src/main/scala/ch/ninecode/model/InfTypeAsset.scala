package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


/**
 * Generic generation equipment that may be used for various purposes such as work planning.
 * It defines both the Real and Reactive power properties (modelled at the PSR level as a GeneratingUnit + SynchronousMachine).
 * @param sup Reference to the superclass object.
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
 */
case class GeneratorTypeAsset
(
    override val sup: GenericAssetModelOrMaterial,
    maxP: Double,
    maxQ: Double,
    minP: Double,
    minQ: Double,
    rDirectSubtrans: Double,
    rDirectSync: Double,
    rDirectTrans: Double,
    rQuadSubtrans: Double,
    rQuadSync: Double,
    rQuadTrans: Double,
    xDirectSubtrans: Double,
    xDirectSync: Double,
    xDirectTrans: Double,
    xQuadSubtrans: Double,
    xQuadSync: Double,
    xQuadTrans: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def GenericAssetModelOrMaterial: GenericAssetModelOrMaterial = sup.asInstanceOf[GenericAssetModelOrMaterial]
    override def copy (): Row = { clone ().asInstanceOf[GeneratorTypeAsset] }
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
        "\t\t<cim:GeneratorTypeAsset.maxP>" + maxP + "</cim:GeneratorTypeAsset.maxP>\n" +
        "\t\t<cim:GeneratorTypeAsset.maxQ>" + maxQ + "</cim:GeneratorTypeAsset.maxQ>\n" +
        "\t\t<cim:GeneratorTypeAsset.minP>" + minP + "</cim:GeneratorTypeAsset.minP>\n" +
        "\t\t<cim:GeneratorTypeAsset.minQ>" + minQ + "</cim:GeneratorTypeAsset.minQ>\n" +
        "\t\t<cim:GeneratorTypeAsset.rDirectSubtrans>" + rDirectSubtrans + "</cim:GeneratorTypeAsset.rDirectSubtrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.rDirectSync>" + rDirectSync + "</cim:GeneratorTypeAsset.rDirectSync>\n" +
        "\t\t<cim:GeneratorTypeAsset.rDirectTrans>" + rDirectTrans + "</cim:GeneratorTypeAsset.rDirectTrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.rQuadSubtrans>" + rQuadSubtrans + "</cim:GeneratorTypeAsset.rQuadSubtrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.rQuadSync>" + rQuadSync + "</cim:GeneratorTypeAsset.rQuadSync>\n" +
        "\t\t<cim:GeneratorTypeAsset.rQuadTrans>" + rQuadTrans + "</cim:GeneratorTypeAsset.rQuadTrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.xDirectSubtrans>" + xDirectSubtrans + "</cim:GeneratorTypeAsset.xDirectSubtrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.xDirectSync>" + xDirectSync + "</cim:GeneratorTypeAsset.xDirectSync>\n" +
        "\t\t<cim:GeneratorTypeAsset.xDirectTrans>" + xDirectTrans + "</cim:GeneratorTypeAsset.xDirectTrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.xQuadSubtrans>" + xQuadSubtrans + "</cim:GeneratorTypeAsset.xQuadSubtrans>\n" +
        "\t\t<cim:GeneratorTypeAsset.xQuadSync>" + xQuadSync + "</cim:GeneratorTypeAsset.xQuadSync>\n" +
        "\t\t<cim:GeneratorTypeAsset.xQuadTrans>" + xQuadTrans + "</cim:GeneratorTypeAsset.xQuadTrans>\n"
    }
    override def export: String =
    {
        "\t<cim:GeneratorTypeAsset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratorTypeAsset>"
    }
}

object GeneratorTypeAsset
extends
    Parseable[GeneratorTypeAsset]
{
    val maxP = parse_element (element ("""GeneratorTypeAsset.maxP"""))
    val maxQ = parse_element (element ("""GeneratorTypeAsset.maxQ"""))
    val minP = parse_element (element ("""GeneratorTypeAsset.minP"""))
    val minQ = parse_element (element ("""GeneratorTypeAsset.minQ"""))
    val rDirectSubtrans = parse_element (element ("""GeneratorTypeAsset.rDirectSubtrans"""))
    val rDirectSync = parse_element (element ("""GeneratorTypeAsset.rDirectSync"""))
    val rDirectTrans = parse_element (element ("""GeneratorTypeAsset.rDirectTrans"""))
    val rQuadSubtrans = parse_element (element ("""GeneratorTypeAsset.rQuadSubtrans"""))
    val rQuadSync = parse_element (element ("""GeneratorTypeAsset.rQuadSync"""))
    val rQuadTrans = parse_element (element ("""GeneratorTypeAsset.rQuadTrans"""))
    val xDirectSubtrans = parse_element (element ("""GeneratorTypeAsset.xDirectSubtrans"""))
    val xDirectSync = parse_element (element ("""GeneratorTypeAsset.xDirectSync"""))
    val xDirectTrans = parse_element (element ("""GeneratorTypeAsset.xDirectTrans"""))
    val xQuadSubtrans = parse_element (element ("""GeneratorTypeAsset.xQuadSubtrans"""))
    val xQuadSync = parse_element (element ("""GeneratorTypeAsset.xQuadSync"""))
    val xQuadTrans = parse_element (element ("""GeneratorTypeAsset.xQuadTrans"""))
    def parse (context: Context): GeneratorTypeAsset =
    {
        GeneratorTypeAsset(
            GenericAssetModelOrMaterial.parse (context),
            toDouble (maxP (context), context),
            toDouble (maxQ (context), context),
            toDouble (minP (context), context),
            toDouble (minQ (context), context),
            toDouble (rDirectSubtrans (context), context),
            toDouble (rDirectSync (context), context),
            toDouble (rDirectTrans (context), context),
            toDouble (rQuadSubtrans (context), context),
            toDouble (rQuadSync (context), context),
            toDouble (rQuadTrans (context), context),
            toDouble (xDirectSubtrans (context), context),
            toDouble (xDirectSync (context), context),
            toDouble (xDirectTrans (context), context),
            toDouble (xQuadSubtrans (context), context),
            toDouble (xQuadSync (context), context),
            toDouble (xQuadTrans (context), context)
        )
    }
}

/**
 * Catalogue of generic types of assets (TypeAsset) that may be used for design purposes.
 * It is not associated with a particular manufacturer.
 * @param sup Reference to the superclass object.
 * @param status <em>undocumented</em>
 */
case class TypeAssetCatalogue
(
    override val sup: IdentifiedObject,
    status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TypeAssetCatalogue] }
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
        (if (null != status) "\t\t<cim:TypeAssetCatalogue.status rdf:resource=\"#" + status + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TypeAssetCatalogue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TypeAssetCatalogue>"
    }
}

object TypeAssetCatalogue
extends
    Parseable[TypeAssetCatalogue]
{
    val status = parse_attribute (attribute ("""TypeAssetCatalogue.status"""))
    def parse (context: Context): TypeAssetCatalogue =
    {
        TypeAssetCatalogue(
            IdentifiedObject.parse (context),
            status (context)
        )
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