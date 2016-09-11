package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: ExternalInputs
 */

case class MktSwitch
(
    override val sup: Switch
)
extends
    Element
{
    def this () = { this (null) }
    def Switch: Switch = sup.asInstanceOf[Switch]
    override def copy (): Row = { return (clone ().asInstanceOf[MktSwitch]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktSwitch
extends
    Parseable[MktSwitch]
{
    def parse (context: Context): MktSwitch =
    {
        return (
            MktSwitch
            (
                Switch.parse (context)
            )
        )
    }
}

object ExternalInputs
{
    def register: Unit =
    {
        MktSwitch.register
    }
}
