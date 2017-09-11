package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A fault applied at the terminal, external to the equipment.
 *
 * This class is not used to specify faults internal to the equipment.
 *
 * @param sup [[ch.ninecode.model.Fault Fault]] Reference to the superclass object.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal connecting to the bus to which the fault is applied.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class EquipmentFault
(
    override val sup: Fault,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Fault: Fault = sup.asInstanceOf[Fault]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentFault] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != Terminal) "\t\t<cim:EquipmentFault.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EquipmentFault rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquipmentFault>"
    }
}

object EquipmentFault
extends
    Parseable[EquipmentFault]
{
    val Terminal = parse_attribute (attribute ("""EquipmentFault.Terminal"""))
    def parse (context: Context): EquipmentFault =
    {
        EquipmentFault(
            Fault.parse (context),
            Terminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", false))
}

/**
 * Abnormal condition causing current flow through conducting equipment, such as caused by equipment failure or short circuits from objects not typically modeled (for example, a tree falling on a line).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param impedance Fault impedance.
 *        Its usage is described by 'kind'.
 * @param kind The kind of phase fault.
 * @param phases The phases participating in the fault.
 *        The fault connections into these phases are further specified by the type of fault.
 * @param FaultCauseTypes [[ch.ninecode.model.FaultCauseType FaultCauseType]] All types of fault cause.
 * @param FaultyEquipment [[ch.ninecode.model.Equipment Equipment]] Equipment carrying this fault.
 * @param Outage [[ch.ninecode.model.Outage Outage]] Outage associated with this fault.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class Fault
(
    override val sup: IdentifiedObject,
    impedance: String,
    kind: String,
    phases: String,
    FaultCauseTypes: List[String],
    FaultyEquipment: String,
    Outage: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Fault] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != impedance) "\t\t<cim:Fault.impedance rdf:resource=\"#" + impedance + "\"/>\n" else "") +
        (if (null != kind) "\t\t<cim:Fault.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != phases) "\t\t<cim:Fault.phases rdf:resource=\"#" + phases + "\"/>\n" else "") +
        (if (null != FaultCauseTypes) FaultCauseTypes.map (x => "\t\t<cim:Fault.FaultCauseTypes rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != FaultyEquipment) "\t\t<cim:Fault.FaultyEquipment rdf:resource=\"#" + FaultyEquipment + "\"/>\n" else "") +
        (if (null != Outage) "\t\t<cim:Fault.Outage rdf:resource=\"#" + Outage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Fault rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Fault>"
    }
}

object Fault
extends
    Parseable[Fault]
{
    val impedance = parse_attribute (attribute ("""Fault.impedance"""))
    val kind = parse_attribute (attribute ("""Fault.kind"""))
    val phases = parse_attribute (attribute ("""Fault.phases"""))
    val FaultCauseTypes = parse_attributes (attribute ("""Fault.FaultCauseTypes"""))
    val FaultyEquipment = parse_attribute (attribute ("""Fault.FaultyEquipment"""))
    val Outage = parse_attribute (attribute ("""Fault.Outage"""))
    def parse (context: Context): Fault =
    {
        Fault(
            IdentifiedObject.parse (context),
            impedance (context),
            kind (context),
            phases (context),
            FaultCauseTypes (context),
            FaultyEquipment (context),
            Outage (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("FaultCauseTypes", "FaultCauseType", true),
        Relationship ("FaultyEquipment", "Equipment", false),
        Relationship ("Outage", "Outage", false))
}

/**
 * Type of cause of the fault.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class FaultCauseType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FaultCauseType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:FaultCauseType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultCauseType>"
    }
}

object FaultCauseType
extends
    Parseable[FaultCauseType]
{
    def parse (context: Context): FaultCauseType =
    {
        FaultCauseType(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * Impedance description for the fault.
 *
 * @param sup Reference to the superclass object.
 * @param rGround The resistance of the fault between phases and ground.
 * @param rLineToLine The resistance of the fault between phases.
 * @param xGround The reactance of the fault between phases and ground.
 * @param xLineToLine The reactance of the fault between phases.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class FaultImpedance
(
    override val sup: BasicElement,
    rGround: Double,
    rLineToLine: Double,
    xGround: Double,
    xLineToLine: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FaultImpedance] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:FaultImpedance.rGround>" + rGround + "</cim:FaultImpedance.rGround>\n" +
        "\t\t<cim:FaultImpedance.rLineToLine>" + rLineToLine + "</cim:FaultImpedance.rLineToLine>\n" +
        "\t\t<cim:FaultImpedance.xGround>" + xGround + "</cim:FaultImpedance.xGround>\n" +
        "\t\t<cim:FaultImpedance.xLineToLine>" + xLineToLine + "</cim:FaultImpedance.xLineToLine>\n"
    }
    override def export: String =
    {
        "\t<cim:FaultImpedance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FaultImpedance>"
    }
}

object FaultImpedance
extends
    Parseable[FaultImpedance]
{
    val rGround = parse_element (element ("""FaultImpedance.rGround"""))
    val rLineToLine = parse_element (element ("""FaultImpedance.rLineToLine"""))
    val xGround = parse_element (element ("""FaultImpedance.xGround"""))
    val xLineToLine = parse_element (element ("""FaultImpedance.xLineToLine"""))
    def parse (context: Context): FaultImpedance =
    {
        FaultImpedance(
            BasicElement.parse (context),
            toDouble (rGround (context), context),
            toDouble (rLineToLine (context), context),
            toDouble (xGround (context), context),
            toDouble (xLineToLine (context), context)
        )
    }
    val relations: List[Relationship] = List ()
}

/**
 * A fault that occurs on an AC line segment at some point along the length.
 *
 * @param sup [[ch.ninecode.model.Fault Fault]] Reference to the superclass object.
 * @param lengthFromTerminal1 The length to the place where the fault is located starting from terminal with sequence number 1 of the faulted line segment.
 * @param ACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment of this line fault.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class LineFault
(
    override val sup: Fault,
    lengthFromTerminal1: Double,
    ACLineSegment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Fault: Fault = sup.asInstanceOf[Fault]
    override def copy (): Row = { clone ().asInstanceOf[LineFault] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:LineFault.lengthFromTerminal1>" + lengthFromTerminal1 + "</cim:LineFault.lengthFromTerminal1>\n" +
        (if (null != ACLineSegment) "\t\t<cim:LineFault.ACLineSegment rdf:resource=\"#" + ACLineSegment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LineFault rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LineFault>"
    }
}

object LineFault
extends
    Parseable[LineFault]
{
    val lengthFromTerminal1 = parse_element (element ("""LineFault.lengthFromTerminal1"""))
    val ACLineSegment = parse_attribute (attribute ("""LineFault.ACLineSegment"""))
    def parse (context: Context): LineFault =
    {
        LineFault(
            Fault.parse (context),
            toDouble (lengthFromTerminal1 (context), context),
            ACLineSegment (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ACLineSegment", "ACLineSegment", false))
}

private[ninecode] object _Faults
{
    def register: List[ClassInfo] =
    {
        List (
            EquipmentFault.register,
            Fault.register,
            FaultCauseType.register,
            FaultImpedance.register,
            LineFault.register
        )
    }
}