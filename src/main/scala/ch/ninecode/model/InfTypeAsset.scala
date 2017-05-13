package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Generic generation equipment that may be used for various purposes such as work planning.
 * It defines both the Real and Reactive power properties (modelled at the PSR level as a GeneratingUnit + SynchronousMachine).
 */
case class GeneratorTypeAsset
(

    override val sup: GenericAssetModelOrMaterial,

    /**
     * Maximum real power limit.
     */
    val maxP: Double,

    /**
     * Maximum reactive power limit.
     */
    val maxQ: Double,

    /**
     * Minimum real power generated.
     */
    val minP: Double,

    /**
     * Minimum reactive power generated.
     */
    val minQ: Double,

    /**
     * Direct-axis subtransient resistance.
     */
    val rDirectSubtrans: Double,

    /**
     * Direct-axis synchronous resistance.
     */
    val rDirectSync: Double,

    /**
     * Direct-axis transient resistance.
     */
    val rDirectTrans: Double,

    /**
     * Quadrature-axis subtransient resistance.
     */
    val rQuadSubtrans: Double,

    /**
     * Quadrature-axis synchronous resistance.
     */
    val rQuadSync: Double,

    /**
     * Quadrature-axis transient resistance.
     */
    val rQuadTrans: Double,

    /**
     * Direct-axis subtransient reactance.
     */
    val xDirectSubtrans: Double,

    /**
     * Direct-axis synchronous reactance.
     */
    val xDirectSync: Double,

    /**
     * Direct-axis transient reactance.
     */
    val xDirectTrans: Double,

    /**
     * Quadrature-axis subtransient reactance.
     */
    val xQuadSubtrans: Double,

    /**
     * Quadrature-axis synchronous reactance.
     */
    val xQuadSync: Double,

    /**
     * Quadrature-axis transient reactance.
     */
    val xQuadTrans: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def GenericAssetModelOrMaterial: GenericAssetModelOrMaterial = sup.asInstanceOf[GenericAssetModelOrMaterial]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratorTypeAsset]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratorTypeAsset
extends
    Parseable[GeneratorTypeAsset]
{
    val sup = GenericAssetModelOrMaterial.parse _
    val maxP = parse_element (element ("""GeneratorTypeAsset.maxP"""))_
    val maxQ = parse_element (element ("""GeneratorTypeAsset.maxQ"""))_
    val minP = parse_element (element ("""GeneratorTypeAsset.minP"""))_
    val minQ = parse_element (element ("""GeneratorTypeAsset.minQ"""))_
    val rDirectSubtrans = parse_element (element ("""GeneratorTypeAsset.rDirectSubtrans"""))_
    val rDirectSync = parse_element (element ("""GeneratorTypeAsset.rDirectSync"""))_
    val rDirectTrans = parse_element (element ("""GeneratorTypeAsset.rDirectTrans"""))_
    val rQuadSubtrans = parse_element (element ("""GeneratorTypeAsset.rQuadSubtrans"""))_
    val rQuadSync = parse_element (element ("""GeneratorTypeAsset.rQuadSync"""))_
    val rQuadTrans = parse_element (element ("""GeneratorTypeAsset.rQuadTrans"""))_
    val xDirectSubtrans = parse_element (element ("""GeneratorTypeAsset.xDirectSubtrans"""))_
    val xDirectSync = parse_element (element ("""GeneratorTypeAsset.xDirectSync"""))_
    val xDirectTrans = parse_element (element ("""GeneratorTypeAsset.xDirectTrans"""))_
    val xQuadSubtrans = parse_element (element ("""GeneratorTypeAsset.xQuadSubtrans"""))_
    val xQuadSync = parse_element (element ("""GeneratorTypeAsset.xQuadSync"""))_
    val xQuadTrans = parse_element (element ("""GeneratorTypeAsset.xQuadTrans"""))_
    def parse (context: Context): GeneratorTypeAsset =
    {
        GeneratorTypeAsset(
            sup (context),
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
 */
case class TypeAssetCatalogue
(

    override val sup: IdentifiedObject,

    val status: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TypeAssetCatalogue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TypeAssetCatalogue
extends
    Parseable[TypeAssetCatalogue]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""TypeAssetCatalogue.status"""))_
    def parse (context: Context): TypeAssetCatalogue =
    {
        TypeAssetCatalogue(
            sup (context),
            status (context)
        )
    }
}

object _InfTypeAsset
{
    def register: Unit =
    {
        GeneratorTypeAsset.register
        TypeAssetCatalogue.register
    }
}