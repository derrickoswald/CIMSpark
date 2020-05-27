package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * All the measurements are filtered by a first lag element with a time constant TM.
 *
 * @param Element Reference to the superclass object.
 * @param tm Time constant.
 * @param BlockingFunction [[ch.ninecode.model.BlockingFunction BlockingFunction]] <em>undocumented</em>
 * @param DCvoltageControl [[ch.ninecode.model.DCvoltageControl DCvoltageControl]] <em>undocumented</em>
 * @param PFmode [[ch.ninecode.model.PFmode PFmode]] <em>undocumented</em>
 * @param Pcontrol [[ch.ninecode.model.Pcontrol Pcontrol]] <em>undocumented</em>
 * @param Qlimiter [[ch.ninecode.model.Qlimiter Qlimiter]] <em>undocumented</em>
 * @param Qmode [[ch.ninecode.model.Qmode Qmode]] <em>undocumented</em>
 * @param Qregulator [[ch.ninecode.model.Qregulator Qregulator]] <em>undocumented</em>
 * @param Umode [[ch.ninecode.model.Umode Umode]] <em>undocumented</em>
 * @group InfHVDCDynamics
 * @groupname InfHVDCDynamics Package InfHVDCDynamics
 */
final case class Delay
(
    Element: BasicElement = null,
    tm: Double = 0.0,
    BlockingFunction: String = null,
    DCvoltageControl: String = null,
    PFmode: String = null,
    Pcontrol: String = null,
    Qlimiter: String = null,
    Qmode: String = null,
    Qregulator: String = null,
    Umode: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Delay.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Delay.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Delay.fields (position), value)
        emitelem (0, tm)
        emitattr (1, BlockingFunction)
        emitattr (2, DCvoltageControl)
        emitattr (3, PFmode)
        emitattr (4, Pcontrol)
        emitattr (5, Qlimiter)
        emitattr (6, Qmode)
        emitattr (7, Qregulator)
        emitattr (8, Umode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Delay rdf:ID=\"%s\">\n%s\t</cim:Delay>".format (id, export_fields)
    }
}

object Delay
extends
    Parseable[Delay]
{
    override val fields: Array[String] = Array[String] (
        "tm",
        "BlockingFunction",
        "DCvoltageControl",
        "PFmode",
        "Pcontrol",
        "Qlimiter",
        "Qmode",
        "Qregulator",
        "Umode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BlockingFunction", "BlockingFunction", "0..1", "1"),
        Relationship ("DCvoltageControl", "DCvoltageControl", "0..1", "1"),
        Relationship ("PFmode", "PFmode", "0..1", "1"),
        Relationship ("Pcontrol", "Pcontrol", "0..1", "1"),
        Relationship ("Qlimiter", "Qlimiter", "0..1", "1"),
        Relationship ("Qmode", "Qmode", "0..1", "1"),
        Relationship ("Qregulator", "Qregulator", "0..1", "1"),
        Relationship ("Umode", "Umode", "0..1", "1")
    )
    val tm: Fielder = parse_element (element (cls, fields(0)))
    val BlockingFunction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DCvoltageControl: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PFmode: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Pcontrol: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Qlimiter: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Qmode: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Qregulator: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Umode: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): Delay =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Delay (
            BasicElement.parse (context),
            toDouble (mask (tm (), 0)),
            mask (BlockingFunction (), 1),
            mask (DCvoltageControl (), 2),
            mask (PFmode (), 3),
            mask (Pcontrol (), 4),
            mask (Qlimiter (), 5),
            mask (Qmode (), 6),
            mask (Qregulator (), 7),
            mask (Umode (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * @group InfHVDCDynamics
 * @groupname InfHVDCDynamics Package InfHVDCDynamics
 */
final case class HVDCLookUpTable
(
    Element: BasicElement = null,
    functionKind: String = null,
    input: Double = 0.0,
    output: Double = 0.0,
    sequence: Int = 0,
    Qregulator: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HVDCLookUpTable.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HVDCLookUpTable.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HVDCLookUpTable.fields (position), value)
        emitattr (0, functionKind)
        emitelem (1, input)
        emitelem (2, output)
        emitelem (3, sequence)
        emitattr (4, Qregulator)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HVDCLookUpTable rdf:ID=\"%s\">\n%s\t</cim:HVDCLookUpTable>".format (id, export_fields)
    }
}

object HVDCLookUpTable
extends
    Parseable[HVDCLookUpTable]
{
    override val fields: Array[String] = Array[String] (
        "functionKind",
        "input",
        "output",
        "sequence",
        "Qregulator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Qregulator", "Qregulator", "0..1", "1..*")
    )
    val functionKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val input: Fielder = parse_element (element (cls, fields(1)))
    val output: Fielder = parse_element (element (cls, fields(2)))
    val sequence: Fielder = parse_element (element (cls, fields(3)))
    val Qregulator: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): HVDCLookUpTable =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HVDCLookUpTable (
            BasicElement.parse (context),
            mask (functionKind (), 0),
            toDouble (mask (input (), 1)),
            toDouble (mask (output (), 2)),
            toInteger (mask (sequence (), 3)),
            mask (Qregulator (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _InfHVDCDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            Delay.register,
            HVDCLookUpTable.register
        )
    }
}