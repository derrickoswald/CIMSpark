package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

case class StateVariable (
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[StateVariable]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StateVariable
extends
    Parseable[StateVariable]
with
    Parser
{
    def parse (context: Context): StateVariable =
    {
        return (
            StateVariable
            (
                Element.parse (context)
            )
        )
    }
}

case class SvStatus (
    override val sup: Element,
    val inService: Boolean,
    val ConductingEquipment: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[SvStatus]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvStatus
extends
    Parseable[SvStatus]
with
    Parser
{
    def parse (context: Context): SvStatus =
    {
        val inService = parse_element (element ("""SvStatus.inService"""))_
        val ConductingEquipment = parse_attribute (attribute ("""SvStatus.ConductingEquipment"""))_
        return (
            SvStatus
            (
                StateVariable.parse (context),
                toBoolean (inService (context), context),
                ConductingEquipment (context)
            )
        )
    }
}

object StateVariables
{
    def register: Unit =
    {
        StateVariable.register
        SvStatus.register
    }
}
