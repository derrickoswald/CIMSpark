package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ModelingAuthority rdf:ID=\"%s\">\n%s\t</cim:ModelingAuthority>".format (id, export_fields)
    }
}

object ModelingAuthority
extends
    Parseable[ModelingAuthority]
{

    def parse (context: Context): ModelingAuthority =
    {
        implicit val ctx: Context = context
        val ret = ModelingAuthority (
            BasicElement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A Modeling Authority Set is a group of objects in a network model where the data is supplied and maintained by the same Modeling Authority.
 *
 * This class is typically not included in instance data exchange as this information is tracked by other mechanisms in the exchange.
 *
 * @param sup Reference to the superclass object.
 * @param ModelingAuthority [[ch.ninecode.model.ModelingAuthority ModelingAuthority]] A Modeling Authority set supplies and maintains the data for the objects in a Modeling Authority Set.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ModelingAuthoritySet.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ModelingAuthoritySet.fields (position), value)
        emitattr (0, ModelingAuthority)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ModelingAuthoritySet rdf:ID=\"%s\">\n%s\t</cim:ModelingAuthoritySet>".format (id, export_fields)
    }
}

object ModelingAuthoritySet
extends
    Parseable[ModelingAuthoritySet]
{
    val fields: Array[String] = Array[String] (
        "ModelingAuthority"
    )
    val ModelingAuthority: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ModelingAuthoritySet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ModelingAuthoritySet (
            BasicElement.parse (context),
            mask (ModelingAuthority (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ModelingAuthority", "ModelingAuthority", false)
    )
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