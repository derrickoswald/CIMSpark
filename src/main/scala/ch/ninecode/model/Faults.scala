package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */

/**
 * A fault applied at the terminal, external to the equipment.
 * This class is not used to specify faults internal to the equipment.
 */
case class EquipmentFault
(

    override val sup: Fault,

    /**
     * The terminal connecting to the bus to which the fault is applied.
     */
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Fault: Fault = sup.asInstanceOf[Fault]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentFault]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentFault
extends
    Parseable[EquipmentFault]
{
    val sup = Fault.parse _
    val Terminal = parse_attribute (attribute ("""EquipmentFault.Terminal"""))_
    def parse (context: Context): EquipmentFault =
    {
        EquipmentFault(
            sup (context),
            Terminal (context)
        )
    }
}

/**
 * Abnormal condition causing current flow through conducting equipment, such as caused by equipment failure or short circuits from objects not typically modeled (for example, a tree falling on a line).
 */
case class Fault
(

    override val sup: IdentifiedObject,

    /**
     * Fault impedance.
     * Its usage is described by 'kind'.
     */
    val impedance: String,

    /**
     * The kind of phase fault.
     */
    val kind: String,

    /**
     * The phases participating in the fault.
     * The fault connections into these phases are further specified by the type of fault.
     */
    val phases: String,

    /**
     * All types of fault cause.
     */
    val FaultCauseTypes: List[String],

    /**
     * Equipment carrying this fault.
     */
    val FaultyEquipment: String,

    /**
     * Outage associated with this fault.
     */
    val Outage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, List(), null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Fault]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Fault
extends
    Parseable[Fault]
{
    val sup = IdentifiedObject.parse _
    val impedance = parse_attribute (attribute ("""Fault.impedance"""))_
    val kind = parse_attribute (attribute ("""Fault.kind"""))_
    val phases = parse_attribute (attribute ("""Fault.phases"""))_
    val FaultCauseTypes = parse_attributes (attribute ("""Fault.FaultCauseTypes"""))_
    val FaultyEquipment = parse_attribute (attribute ("""Fault.FaultyEquipment"""))_
    val Outage = parse_attribute (attribute ("""Fault.Outage"""))_
    def parse (context: Context): Fault =
    {
        Fault(
            sup (context),
            impedance (context),
            kind (context),
            phases (context),
            FaultCauseTypes (context),
            FaultyEquipment (context),
            Outage (context)
        )
    }
}

/**
 * Type of cause of the fault.
 */
case class FaultCauseType
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[FaultCauseType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FaultCauseType
extends
    Parseable[FaultCauseType]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): FaultCauseType =
    {
        FaultCauseType(
            sup (context)
        )
    }
}

/**
 * Impedance description for the fault.
 */
case class FaultImpedance
(

    override val sup: BasicElement,

    /**
     * The resistance of the fault between phases and ground.
     */
    val rGround: Double,

    /**
     * The resistance of the fault between phases.
     */
    val rLineToLine: Double,

    /**
     * The reactance of the fault between phases and ground.
     */
    val xGround: Double,

    /**
     * The reactance of the fault between phases.
     */
    val xLineToLine: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FaultImpedance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FaultImpedance
extends
    Parseable[FaultImpedance]
{
    val sup = BasicElement.parse _
    val rGround = parse_element (element ("""FaultImpedance.rGround"""))_
    val rLineToLine = parse_element (element ("""FaultImpedance.rLineToLine"""))_
    val xGround = parse_element (element ("""FaultImpedance.xGround"""))_
    val xLineToLine = parse_element (element ("""FaultImpedance.xLineToLine"""))_
    def parse (context: Context): FaultImpedance =
    {
        FaultImpedance(
            sup (context),
            toDouble (rGround (context), context),
            toDouble (rLineToLine (context), context),
            toDouble (xGround (context), context),
            toDouble (xLineToLine (context), context)
        )
    }
}

/**
 * A fault that occurs on an AC line segment at some point along the length.
 */
case class LineFault
(

    override val sup: Fault,

    /**
     * The length to the place where the fault is located starting from terminal with sequence number 1 of the faulted line segment.
     */
    val lengthFromTerminal1: Double,

    /**
     * The line segment of this line fault.
     */
    val ACLineSegment: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Fault: Fault = sup.asInstanceOf[Fault]
    override def copy (): Row = { return (clone ().asInstanceOf[LineFault]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LineFault
extends
    Parseable[LineFault]
{
    val sup = Fault.parse _
    val lengthFromTerminal1 = parse_element (element ("""LineFault.lengthFromTerminal1"""))_
    val ACLineSegment = parse_attribute (attribute ("""LineFault.ACLineSegment"""))_
    def parse (context: Context): LineFault =
    {
        LineFault(
            sup (context),
            toDouble (lengthFromTerminal1 (context), context),
            ACLineSegment (context)
        )
    }
}

/**
 * The type of fault connection among phases.
 */
case class PhaseConnectedFaultKind
(

    override val sup: BasicElement,

    /**
     * The fault connects the indicated phases to ground.
     * The line to line fault impedance is not used and assumed infinite. The full ground impedance is connected between each phase specified in the fault and ground, but not between the phases.
     */
    val lineToGround: String,

    /**
     * The fault connects the specified phases together without a connection to ground.
     * The ground impedance of this fault is ignored. The line to line impedance is connected between each of the phases specified in the fault. For example three times for a three phase fault, one time for a two phase fault.  A single phase fault should not be specified.
     */
    val lineToLine: String,

    /**
     * The fault connects the indicated phases to ground and to each other.
     * The line to line impedance is connected between each of the phases specified in the fault in a full mesh. For example three times for a three phase fault, one time for a two phase fault. A single phase fault should not be specified. The full ground impedance is connected between each phase specified in the fault and ground.
     */
    val lineToLineToGround: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PhaseConnectedFaultKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PhaseConnectedFaultKind
extends
    Parseable[PhaseConnectedFaultKind]
{
    val sup = BasicElement.parse _
    val lineToGround = parse_attribute (attribute ("""PhaseConnectedFaultKind.lineToGround"""))_
    val lineToLine = parse_attribute (attribute ("""PhaseConnectedFaultKind.lineToLine"""))_
    val lineToLineToGround = parse_attribute (attribute ("""PhaseConnectedFaultKind.lineToLineToGround"""))_
    def parse (context: Context): PhaseConnectedFaultKind =
    {
        PhaseConnectedFaultKind(
            sup (context),
            lineToGround (context),
            lineToLine (context),
            lineToLineToGround (context)
        )
    }
}

object _Faults
{
    def register: Unit =
    {
        EquipmentFault.register
        Fault.register
        FaultCauseType.register
        FaultImpedance.register
        LineFault.register
        PhaseConnectedFaultKind.register
    }
}