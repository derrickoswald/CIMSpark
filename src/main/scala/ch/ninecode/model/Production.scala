package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/*
 * Production
 */

case class GeneratingUnit
(
    override val sup: Equipment,
    val ratedNetMaxP: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratingUnit]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
{
    val ratedNetMaxP = parse_element (element ("""GeneratingUnit.ratedNetMaxP"""))_
    def parse (context: Context): GeneratingUnit =
    {
        return (
            GeneratingUnit
            (
                Equipment.parse (context),
                toDouble (ratedNetMaxP (context), context)
            )
        )
    }
}

case class SolarGeneratingUnit
(
    override val sup: GeneratingUnit
)
extends
    Element
{
    def this () = { this (null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[SolarGeneratingUnit]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
{
    def parse (context: Context): SolarGeneratingUnit =
    {
        return (
            SolarGeneratingUnit
            (
                GeneratingUnit.parse (context)
            )
        )
    }
}

object Production
{
    def register: Unit =
    {
        GeneratingUnit.register
        SolarGeneratingUnit.register
    }
}
