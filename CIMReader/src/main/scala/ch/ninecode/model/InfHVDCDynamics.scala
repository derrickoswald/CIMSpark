package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

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
        "\t<cim:Delay rdf:%s=\"%s\">\n%s\t</cim:Delay>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object Delay
extends
    CIMParseable[Delay]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BlockingFunction", "BlockingFunction", "0..1", "1"),
        CIMRelationship ("DCvoltageControl", "DCvoltageControl", "0..1", "1"),
        CIMRelationship ("PFmode", "PFmode", "0..1", "1"),
        CIMRelationship ("Pcontrol", "Pcontrol", "0..1", "1"),
        CIMRelationship ("Qlimiter", "Qlimiter", "0..1", "1"),
        CIMRelationship ("Qmode", "Qmode", "0..1", "1"),
        CIMRelationship ("Qregulator", "Qregulator", "0..1", "1"),
        CIMRelationship ("Umode", "Umode", "0..1", "1")
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

    def parse (context: CIMContext): Delay =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[Delay] = DelaySerializer
}

object DelaySerializer extends CIMSerializer[Delay]
{
    def write (kryo: Kryo, output: Output, obj: Delay): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.tm),
            () => output.writeString (obj.BlockingFunction),
            () => output.writeString (obj.DCvoltageControl),
            () => output.writeString (obj.PFmode),
            () => output.writeString (obj.Pcontrol),
            () => output.writeString (obj.Qlimiter),
            () => output.writeString (obj.Qmode),
            () => output.writeString (obj.Qregulator),
            () => output.writeString (obj.Umode)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Delay]): Delay =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Delay (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:HVDCLookUpTable rdf:%s=\"%s\">\n%s\t</cim:HVDCLookUpTable>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object HVDCLookUpTable
extends
    CIMParseable[HVDCLookUpTable]
{
    override val fields: Array[String] = Array[String] (
        "functionKind",
        "input",
        "output",
        "sequence",
        "Qregulator"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Qregulator", "Qregulator", "0..1", "1..*")
    )
    val functionKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val input: Fielder = parse_element (element (cls, fields(1)))
    val output: Fielder = parse_element (element (cls, fields(2)))
    val sequence: Fielder = parse_element (element (cls, fields(3)))
    val Qregulator: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): HVDCLookUpTable =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[HVDCLookUpTable] = HVDCLookUpTableSerializer
}

object HVDCLookUpTableSerializer extends CIMSerializer[HVDCLookUpTable]
{
    def write (kryo: Kryo, output: Output, obj: HVDCLookUpTable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.functionKind),
            () => output.writeDouble (obj.input),
            () => output.writeDouble (obj.output),
            () => output.writeInt (obj.sequence),
            () => output.writeString (obj.Qregulator)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HVDCLookUpTable]): HVDCLookUpTable =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HVDCLookUpTable (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfHVDCDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            Delay.register,
            HVDCLookUpTable.register
        )
    }
}