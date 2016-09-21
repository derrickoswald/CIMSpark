package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Work
 */

case class WorkLocation
(
    override val sup: Location,
    val OneCallRequest: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkLocation
extends
    Parseable[WorkLocation]
{
    val OneCallRequest = parse_element (element ("""WorkLocation.OneCallRequest"""))_
    def parse (context: Context): WorkLocation =
    {
        return (
            WorkLocation
            (
                Location.parse (context),
                OneCallRequest (context)
            )
        )
    }
}

object Work
{
    def register: Unit =
    {
        WorkLocation.register
    }
}
