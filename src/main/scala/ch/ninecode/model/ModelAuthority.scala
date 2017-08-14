package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * A Modeling Authority is an entity responsible for supplying and maintaining the data defining a specific set of objects in a network model.
 *
 * @param sup Reference to the superclass object.
 * @group ModelAuthority
 * @groupname ModelAuthority Package ModelAuthority
 * @groupdesc ModelAuthority The package describes meta data for partitioning  power system models into non overlapping subsets of objects managed by a model authority.
 */
case class ModelingAuthority
(
    override val sup: BasicElement
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ModelingAuthority] }
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
        "\t<cim:ModelingAuthority rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ModelingAuthority>"
    }
}

object ModelingAuthority
extends
    Parseable[ModelingAuthority]
{
    def parse (context: Context): ModelingAuthority =
    {
        ModelingAuthority(
            BasicElement.parse (context)
        )
    }
}

/**
 * A Modeling Authority Set is a group of objects in a network model where the data is supplied and maintained by the same Modeling Authority.
 * This class is typically not included in instance data exchange as this information is tracked by other mechanisms in the exchange.
 *
 * @param sup Reference to the superclass object.
 * @param ModelingAuthority A Modeling Authority set supplies and maintains the data for the objects in a Modeling Authority Set.
 * @group ModelAuthority
 * @groupname ModelAuthority Package ModelAuthority
 * @groupdesc ModelAuthority The package describes meta data for partitioning  power system models into non overlapping subsets of objects managed by a model authority.
 */
case class ModelingAuthoritySet
(
    override val sup: BasicElement,
    ModelingAuthority: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ModelingAuthoritySet] }
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
        (if (null != ModelingAuthority) "\t\t<cim:ModelingAuthoritySet.ModelingAuthority rdf:resource=\"#" + ModelingAuthority + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ModelingAuthoritySet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ModelingAuthoritySet>"
    }
}

object ModelingAuthoritySet
extends
    Parseable[ModelingAuthoritySet]
{
    val ModelingAuthority = parse_attribute (attribute ("""ModelingAuthoritySet.ModelingAuthority"""))
    def parse (context: Context): ModelingAuthoritySet =
    {
        ModelingAuthoritySet(
            BasicElement.parse (context),
            ModelingAuthority (context)
        )
    }
}

private[ninecode] object _ModelAuthority
{
    def register: List[ClassInfo] =
    {
        List (
            ModelingAuthority.register,
            ModelingAuthoritySet.register
        )
    }
}