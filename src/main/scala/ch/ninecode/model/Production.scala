package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class GeneratingUnit
(
    override val sup: Element
    // ToDo: many, many attributes
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
    Parser
{
    def parse (context: Context): GeneratingUnit =
    {
        return (
            GeneratingUnit
            (
                Equipment.parse (context)
            )
        )
    }
}

case class SolarGeneratingUnit
(
    override val sup: Element
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
    Parser
{
    //val x = parse_element (element ("""SolarGeneratingUnit."""))_
    //val y = parse_attribute (attribute ("""SolarGeneratingUnit."""))_
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

