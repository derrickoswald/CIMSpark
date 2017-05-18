package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package describes meta data for partitioning  power system models into non overlapping subsets of objects managed by a model authority.
 */

/**
 * A Modeling Authority is an entity responsible for supplying and maintaining the data defining a specific set of objects in a network model.
 * @param sup Reference to the superclass object.
 */
case class ModelingAuthority
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ModelingAuthority]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ModelingAuthority
extends
    Parseable[ModelingAuthority]
{
    val sup = BasicElement.parse _
    def parse (context: Context): ModelingAuthority =
    {
        ModelingAuthority(
            sup (context)
        )
    }
}

/**
 * A Modeling Authority Set is a group of objects in a network model where the data is supplied and maintained by the same Modeling Authority.
 * This class is typically not included in instance data exchange as this information is tracked by other mechanisms in the exchange.
 * @param sup Reference to the superclass object.
 * @param ModelingAuthority A Modeling Authority set supplies and maintains the data for the objects in a Modeling Authority Set.
 */
case class ModelingAuthoritySet
(
    override val sup: Element,
    val ModelingAuthority: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ModelingAuthoritySet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ModelingAuthoritySet
extends
    Parseable[ModelingAuthoritySet]
{
    val sup = BasicElement.parse _
    val ModelingAuthority = parse_attribute (attribute ("""ModelingAuthoritySet.ModelingAuthority"""))
    def parse (context: Context): ModelingAuthoritySet =
    {
        ModelingAuthoritySet(
            sup (context),
            ModelingAuthority (context)
        )
    }
}

object _ModelAuthority
{
    def register: Unit =
    {
        ModelingAuthority.register
        ModelingAuthoritySet.register
    }
}