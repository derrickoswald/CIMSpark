package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


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
(override val sup: GenericAssetModelOrMaterial,
val maxP: Double,
val maxQ: Double,
val minP: Double,
val minQ: Double,
val rDirectSubtrans: Double,
val rDirectSync: Double,
val rDirectTrans: Double,
val rQuadSubtrans: Double,
val rQuadSync: Double,
val rQuadTrans: Double,
val xDirectSubtrans: Double,
val xDirectSync: Double,
val xDirectTrans: Double,
val xQuadSubtrans: Double,
val xQuadSync: Double,
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
 * @param sup Reference to the superclass object.
 * @param status
 */
case class TypeAssetCatalogue
(override val sup: IdentifiedObject,
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