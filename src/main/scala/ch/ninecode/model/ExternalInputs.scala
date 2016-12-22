package ch.ninecode.model

import org.apache.spark.sql.Row
import org.apache.spark.sql.catalyst.InternalRow

import org.apache.spark.sql.types._
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
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
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
