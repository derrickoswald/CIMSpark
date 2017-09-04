package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:EnergySchedulingType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergySchedulingType>"
    }
}

object EnergySchedulingType
extends
    Parseable[EnergySchedulingType]
{
    def parse (context: Context): EnergySchedulingType =
    {
        EnergySchedulingType(
            IdentifiedObject.parse (context)
        )
    }
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