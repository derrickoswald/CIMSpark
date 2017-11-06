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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EquipmentFault.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EquipmentFault.fields (position), value)
        emitattr (0, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquipmentFault rdf:ID=\"%s\">\n%s\t</cim:EquipmentFault>".format (id, export_fields)
    }
}

object EquipmentFault
extends
    Parseable[EquipmentFault]
{
    override val fields: Array[String] = Array[String] (
        "Terminal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Terminal", "Terminal", "0..1", "0..*")
    )
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): EquipmentFault =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EquipmentFault (
            Fault.parse (context),
            mask (Terminal (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Abnormal condition causing current flow through conducting equipment, such as caused by equipment failure or short circuits from objects not typically modeled (for example, a tree falling on a line).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param impedance [[ch.ninecode.model.FaultImpedance FaultImpedance]] Fault impedance.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Fault.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Fault.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Fault.fields (position), x))
        emitattr (0, impedance)
        emitattr (1, kind)
        emitattr (2, phases)
        emitattrs (3, FaultCauseTypes)
        emitattr (4, FaultyEquipment)
        emitattr (5, Outage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Fault rdf:ID=\"%s\">\n%s\t</cim:Fault>".format (id, export_fields)
    }
}

object Fault
extends
    Parseable[Fault]
{
    override val fields: Array[String] = Array[String] (
        "impedance",
        "kind",
        "phases",
        "FaultCauseTypes",
        "FaultyEquipment",
        "Outage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("impedance", "FaultImpedance", "0..1", "0..*"),
        Relationship ("FaultCauseTypes", "FaultCauseType", "0..*", "0..*"),
        Relationship ("FaultyEquipment", "Equipment", "0..1", "0..*"),
        Relationship ("Outage", "Outage", "0..1", "0..*")
    )
    val impedance: Fielder = parse_attribute (attribute (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val phases: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FaultCauseTypes: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val FaultyEquipment: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Fault =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Fault (
            IdentifiedObject.parse (context),
            mask (impedance (), 0),
            mask (kind (), 1),
            mask (phases (), 2),
            masks (FaultCauseTypes (), 3),
            mask (FaultyEquipment (), 4),
            mask (Outage (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Type of cause of the fault.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Faults [[ch.ninecode.model.Fault Fault]] All faults with this cause type.
 * @group Faults
 * @groupname Faults Package Faults
 * @groupdesc Faults The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 */
case class FaultCauseType
(
    override val sup: IdentifiedObject,
    Faults: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FaultCauseType.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (FaultCauseType.fields (position), x))
        emitattrs (0, Faults)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FaultCauseType rdf:ID=\"%s\">\n%s\t</cim:FaultCauseType>".format (id, export_fields)
    }
}

object FaultCauseType
extends
    Parseable[FaultCauseType]
{
    override val fields: Array[String] = Array[String] (
        "Faults"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Faults", "Fault", "0..*", "0..*")
    )
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): FaultCauseType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FaultCauseType (
            IdentifiedObject.parse (context),
            masks (Faults (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FaultImpedance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FaultImpedance.fields (position), value)
        emitelem (0, rGround)
        emitelem (1, rLineToLine)
        emitelem (2, xGround)
        emitelem (3, xLineToLine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FaultImpedance rdf:ID=\"%s\">\n%s\t</cim:FaultImpedance>".format (id, export_fields)
    }
}

object FaultImpedance
extends
    Parseable[FaultImpedance]
{
    override val fields: Array[String] = Array[String] (
        "rGround",
        "rLineToLine",
        "xGround",
        "xLineToLine"
    )
    val rGround: Fielder = parse_element (element (cls, fields(0)))
    val rLineToLine: Fielder = parse_element (element (cls, fields(1)))
    val xGround: Fielder = parse_element (element (cls, fields(2)))
    val xLineToLine: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): FaultImpedance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FaultImpedance (
            BasicElement.parse (context),
            toDouble (mask (rGround (), 0)),
            toDouble (mask (rLineToLine (), 1)),
            toDouble (mask (xGround (), 2)),
            toDouble (mask (xLineToLine (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LineFault.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LineFault.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LineFault.fields (position), value)
        emitelem (0, lengthFromTerminal1)
        emitattr (1, ACLineSegment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LineFault rdf:ID=\"%s\">\n%s\t</cim:LineFault>".format (id, export_fields)
    }
}

object LineFault
extends
    Parseable[LineFault]
{
    override val fields: Array[String] = Array[String] (
        "lengthFromTerminal1",
        "ACLineSegment"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ACLineSegment", "ACLineSegment", "0..1", "0..*")
    )
    val lengthFromTerminal1: Fielder = parse_element (element (cls, fields(0)))
    val ACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LineFault =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LineFault (
            Fault.parse (context),
            toDouble (mask (lengthFromTerminal1 (), 0)),
            mask (ACLineSegment (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
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