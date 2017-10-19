package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Used to define the type of generation for scheduling purposes.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group InfEnergySource
 * @groupname InfEnergySource Package InfEnergySource
 */
case class EnergySchedulingType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnergySchedulingType] }
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
        "\t<cim:EnergySchedulingType rdf:ID=\"%s\">\n%s\t</cim:EnergySchedulingType>".format (id, export_fields)
    }
}

object EnergySchedulingType
extends
    Parseable[EnergySchedulingType]
{

    def parse (context: Context): EnergySchedulingType =
    {
        implicit val ctx: Context = context
        val ret = EnergySchedulingType (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfEnergySource
{
    def register: List[ClassInfo] =
    {
        List (
            EnergySchedulingType.register
        )
    }
}