package ch.ninecode.model

import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.apache.spark.sql.catalyst.InternalRow

import ch.ninecode.Context

/*
 * StateVariables
 */

case class StateVariable
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup
    override def copy (): Row = { return (clone ().asInstanceOf[StateVariable]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StateVariable
extends
    Parseable[StateVariable]
{
    def parse (context: Context): StateVariable =
    {
        return (
            StateVariable
            (
                BasicElement.parse (context)
            )
        )
    }
}

case class SvStatus
(
    override val sup: StateVariable,
    val inService: Boolean,
    val ConductingEquipment: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def StateVariable: StateVariable = sup.asInstanceOf[StateVariable]
    override def copy (): Row = { return (clone ().asInstanceOf[SvStatus]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvStatus
extends
    Parseable[SvStatus]
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
