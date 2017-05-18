package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Used to define the type of generation for scheduling purposes.
 * @param sup Reference to the superclass object.
 */
case class EnergySchedulingType
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergySchedulingType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergySchedulingType
extends
    Parseable[EnergySchedulingType]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): EnergySchedulingType =
    {
        EnergySchedulingType(
            sup (context)
        )
    }
}

object _InfEnergySource
{
    def register: Unit =
    {
        EnergySchedulingType.register
    }
}