package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class GeneratingUnit
(
    override val sup: Element,
    val ratedNetMaxP: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[GeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
with
    Parser
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
    override val sup: Element,
    // ToDo: non-standard... should be in Asset
    val commissioningDate: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[SolarGeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
with
    Parser
{
    val commissioningDate = parse_element (element ("""SolarGeneratingUnit.commissioningDate"""))_
    def parse (context: Context): SolarGeneratingUnit =
    {
        return (
            SolarGeneratingUnit
            (
                GeneratingUnit.parse (context),
                commissioningDate (context)
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
