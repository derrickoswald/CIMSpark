package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Domain
 */

case class StringQuantity
(
    override val sup: BasicElement,
    val multiplier: String,
    val unit: String,
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StringQuantity]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringQuantity
extends
    Parseable[StringQuantity]
{
    val multiplier = parse_attribute (attribute ("""StringQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""StringQuantity.unit"""))
    val value = parse_element (element ("""StringQuantity.value"""))
    def parse (context: Context): StringQuantity =
    {
        return (
            StringQuantity
            (
                BasicElement.parse (context),
                multiplier (context),
                unit (context),
                value (context)
            )
        )
    }
}

object Domain
{
    def register: Unit =
    {
        StringQuantity.register
    }
}
