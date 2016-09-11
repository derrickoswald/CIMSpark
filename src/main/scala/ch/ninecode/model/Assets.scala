package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: Assets
 */

case class AssetInfo
(
    override val sup: IdentifiedObject,
    val AssetModel: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[AssetInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AssetInfo
extends
    Parseable[AssetInfo]
{
    val AssetModel = parse_attribute (attribute ("""AssetInfo.AssetModel"""))_
    def parse (context: Context): AssetInfo =
    {
        return (
            AssetInfo
            (
                IdentifiedObject.parse (context),
                AssetModel (context)
            )
        )
    }
}

object Assets
{
    def register: Unit =
    {
        AssetInfo.register
    }
}
