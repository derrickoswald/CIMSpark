package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Contingencies to be studied.
 */

/**
 * An event threatening system reliability, consisting of one or more contingency elements.
 * @param sup Reference to the superclass object.
 * @param mustStudy Set true if must study this contingency.
 */
case class Contingency
(
    override val sup: Element,
    val mustStudy: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Contingency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Contingency
extends
    Parseable[Contingency]
{
    val sup = IdentifiedObject.parse _
    val mustStudy = parse_element (element ("""Contingency.mustStudy"""))
    def parse (context: Context): Contingency =
    {
        Contingency(
            sup (context),
            toBoolean (mustStudy (context), context)
        )
    }
}

/**
 * An element of a system event to be studied by contingency analysis, representing a change in status of a single piece of equipment.
 * @param sup Reference to the superclass object.
 */
case class ContingencyElement
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyElement]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyElement
extends
    Parseable[ContingencyElement]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): ContingencyElement =
    {
        ContingencyElement(
            sup (context)
        )
    }
}

/**
 * A equipment to which the in service status is to change such as a power transformer or AC line segment.
 * @param sup Reference to the superclass object.
 * @param contingentStatus The status for the associated equipment when in the contingency state.
 *        This status is independent of the case to which the contingency is originally applied, but defines the equipment status when the contingency is applied.
 * @param Equipment The single piece of equipment to which to apply the contingency.
 */
case class ContingencyEquipment
(
    override val sup: Element,
    val contingentStatus: String,
    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ContingencyElement: ContingencyElement = sup.asInstanceOf[ContingencyElement]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyEquipment
extends
    Parseable[ContingencyEquipment]
{
    val sup = ContingencyElement.parse _
    val contingentStatus = parse_attribute (attribute ("""ContingencyEquipment.contingentStatus"""))
    val Equipment = parse_attribute (attribute ("""ContingencyEquipment.Equipment"""))
    def parse (context: Context): ContingencyEquipment =
    {
        ContingencyEquipment(
            sup (context),
            contingentStatus (context),
            Equipment (context)
        )
    }
}

/**
 * Indicates the state which the contingency equipment is to be in when the contingency is applied.
 * @param sup Reference to the superclass object.
 * @param inService The equipment is in service.
 * @param outOfService The equipment is to be taken out of service.
 */
case class ContingencyEquipmentStatusKind
(
    override val sup: Element,
    val inService: String,
    val outOfService: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ContingencyEquipmentStatusKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContingencyEquipmentStatusKind
extends
    Parseable[ContingencyEquipmentStatusKind]
{
    val sup = BasicElement.parse _
    val inService = parse_attribute (attribute ("""ContingencyEquipmentStatusKind.inService"""))
    val outOfService = parse_attribute (attribute ("""ContingencyEquipmentStatusKind.outOfService"""))
    def parse (context: Context): ContingencyEquipmentStatusKind =
    {
        ContingencyEquipmentStatusKind(
            sup (context),
            inService (context),
            outOfService (context)
        )
    }
}

object _Contingency
{
    def register: Unit =
    {
        Contingency.register
        ContingencyElement.register
        ContingencyEquipment.register
        ContingencyEquipmentStatusKind.register
    }
}