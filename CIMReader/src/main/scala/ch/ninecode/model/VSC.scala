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
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class BlockingFunction
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = BlockingFunction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(BlockingFunction.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BlockingFunction rdf:%s=\"%s\">\n%s\t</cim:BlockingFunction>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BlockingFunction
    extends
        CIMParseable[BlockingFunction]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): BlockingFunction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BlockingFunction(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BlockingFunction] = BlockingFunctionSerializer
}

object BlockingFunctionSerializer extends CIMSerializer[BlockingFunction]
{
    def write (kryo: Kryo, output: Output, obj: BlockingFunction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BlockingFunction]): BlockingFunction =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BlockingFunction(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * DC voltage control used for voltage regulation.
 *
 * @param Element  Reference to the superclass object.
 * @param kivdc    Integral gain of the DC voltage regulator (Kivdc).
 * @param kpvdc    Proportional gain of the DC voltage regulator (Kpvdc).
 * @param vdcmax   Maximum DC voltage (Vdcmax).
 * @param vdcmin   Minimum DC voltage (Vdcmin).
 * @param Delay    [[ch.ninecode.model.Delay Delay]] <em>undocumented</em>
 * @param VSCtype1 [[ch.ninecode.model.VSCtype1 VSCtype1]] <em>undocumented</em>
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class DCvoltageControl
(
    Element: BasicElement = null,
    kivdc: Double = 0.0,
    kpvdc: Double = 0.0,
    vdcmax: Double = 0.0,
    vdcmin: Double = 0.0,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DCvoltageControl.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCvoltageControl.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCvoltageControl.fields(position), value)

        emitelem(0, kivdc)
        emitelem(1, kpvdc)
        emitelem(2, vdcmax)
        emitelem(3, vdcmin)
        emitattr(4, Delay)
        emitattr(5, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCvoltageControl rdf:%s=\"%s\">\n%s\t</cim:DCvoltageControl>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCvoltageControl
    extends
        CIMParseable[DCvoltageControl]
{
    override val fields: Array[String] = Array[String](
        "kivdc",
        "kpvdc",
        "vdcmax",
        "vdcmin",
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val kivdc: Fielder = parse_element(element(cls, fields(0)))
    val kpvdc: Fielder = parse_element(element(cls, fields(1)))
    val vdcmax: Fielder = parse_element(element(cls, fields(2)))
    val vdcmin: Fielder = parse_element(element(cls, fields(3)))
    val Delay: Fielder = parse_attribute(attribute(cls, fields(4)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(5)))

    def parse (context: CIMContext): DCvoltageControl =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCvoltageControl(
            BasicElement.parse(context),
            toDouble(mask(kivdc(), 0)),
            toDouble(mask(kpvdc(), 1)),
            toDouble(mask(vdcmax(), 2)),
            toDouble(mask(vdcmin(), 3)),
            mask(Delay(), 4),
            mask(VSCtype1(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCvoltageControl] = DCvoltageControlSerializer
}

object DCvoltageControlSerializer extends CIMSerializer[DCvoltageControl]
{
    def write (kryo: Kryo, output: Output, obj: DCvoltageControl): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.kivdc),
            () => output.writeDouble(obj.kpvdc),
            () => output.writeDouble(obj.vdcmax),
            () => output.writeDouble(obj.vdcmin),
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCvoltageControl]): DCvoltageControl =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCvoltageControl(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class PFmode
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = PFmode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(PFmode.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PFmode rdf:%s=\"%s\">\n%s\t</cim:PFmode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object PFmode
    extends
        CIMParseable[PFmode]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): PFmode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFmode(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PFmode] = PFmodeSerializer
}

object PFmodeSerializer extends CIMSerializer[PFmode]
{
    def write (kryo: Kryo, output: Output, obj: PFmode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PFmode]): PFmode =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = PFmode(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Pcontrol
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = Pcontrol.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Pcontrol.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pcontrol rdf:%s=\"%s\">\n%s\t</cim:Pcontrol>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Pcontrol
    extends
        CIMParseable[Pcontrol]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): Pcontrol =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Pcontrol(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Pcontrol] = PcontrolSerializer
}

object PcontrolSerializer extends CIMSerializer[Pcontrol]
{
    def write (kryo: Kryo, output: Output, obj: Pcontrol): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pcontrol]): Pcontrol =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Pcontrol(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qlimiter
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = Qlimiter.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Qlimiter.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Qlimiter rdf:%s=\"%s\">\n%s\t</cim:Qlimiter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Qlimiter
    extends
        CIMParseable[Qlimiter]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): Qlimiter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Qlimiter(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Qlimiter] = QlimiterSerializer
}

object QlimiterSerializer extends CIMSerializer[Qlimiter]
{
    def write (kryo: Kryo, output: Output, obj: Qlimiter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Qlimiter]): Qlimiter =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Qlimiter(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qmode
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = Qmode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Qmode.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Qmode rdf:%s=\"%s\">\n%s\t</cim:Qmode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Qmode
    extends
        CIMParseable[Qmode]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): Qmode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Qmode(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Qmode] = QmodeSerializer
}

object QmodeSerializer extends CIMSerializer[Qmode]
{
    def write (kryo: Kryo, output: Output, obj: Qmode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Qmode]): Qmode =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Qmode(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qregulator
(
    Element: BasicElement = null,
    Delay: String = null,
    HVDClookUpTable: List[String] = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = Qregulator.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Qregulator.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(Qregulator.fields(position), x))

        emitattr(0, Delay)
        emitattrs(1, HVDClookUpTable)
        emitattr(2, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Qregulator rdf:%s=\"%s\">\n%s\t</cim:Qregulator>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Qregulator
    extends
        CIMParseable[Qregulator]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "HVDClookUpTable",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("HVDClookUpTable", "HVDCLookUpTable", "1..*", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val HVDClookUpTable: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): Qregulator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Qregulator(
            BasicElement.parse(context),
            mask(Delay(), 0),
            masks(HVDClookUpTable(), 1),
            mask(VSCtype1(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Qregulator] = QregulatorSerializer
}

object QregulatorSerializer extends CIMSerializer[Qregulator]
{
    def write (kryo: Kryo, output: Output, obj: Qregulator): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => writeList(obj.HVDClookUpTable, output),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Qregulator]): Qregulator =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Qregulator(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Umode
(
    Element: BasicElement = null,
    Delay: String = null,
    VSCtype1: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = Umode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(Umode.fields(position), value)

        emitattr(0, Delay)
        emitattr(1, VSCtype1)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Umode rdf:%s=\"%s\">\n%s\t</cim:Umode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object Umode
    extends
        CIMParseable[Umode]
{
    override val fields: Array[String] = Array[String](
        "Delay",
        "VSCtype1"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Delay", "Delay", "1", "0..1"),
        CIMRelationship("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute(attribute(cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): Umode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Umode(
            BasicElement.parse(context),
            mask(Delay(), 0),
            mask(VSCtype1(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Umode] = UmodeSerializer
}

object UmodeSerializer extends CIMSerializer[Umode]
{
    def write (kryo: Kryo, output: Output, obj: Umode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Delay),
            () => output.writeString(obj.VSCtype1)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Umode]): Umode =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = Umode(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class VSCtype1
(
    VSCDynamics: VSCDynamics = null,
    BlockingFunction: String = null,
    DCvoltageControl: String = null,
    PFmodel: String = null,
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
    override def sup: VSCDynamics = VSCDynamics

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = VSCtype1.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(VSCtype1.fields(position), value)

        emitattr(0, BlockingFunction)
        emitattr(1, DCvoltageControl)
        emitattr(2, PFmodel)
        emitattr(3, Pcontrol)
        emitattr(4, Qlimiter)
        emitattr(5, Qmode)
        emitattr(6, Qregulator)
        emitattr(7, Umode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:VSCtype1 rdf:%s=\"%s\">\n%s\t</cim:VSCtype1>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object VSCtype1
    extends
        CIMParseable[VSCtype1]
{
    override val fields: Array[String] = Array[String](
        "BlockingFunction",
        "DCvoltageControl",
        "PFmodel",
        "Pcontrol",
        "Qlimiter",
        "Qmode",
        "Qregulator",
        "Umode"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("BlockingFunction", "BlockingFunction", "1", "0..1"),
        CIMRelationship("DCvoltageControl", "DCvoltageControl", "1", "0..1"),
        CIMRelationship("PFmodel", "PFmode", "1", "0..1"),
        CIMRelationship("Pcontrol", "Pcontrol", "1", "0..1"),
        CIMRelationship("Qlimiter", "Qlimiter", "1", "0..1"),
        CIMRelationship("Qmode", "Qmode", "1", "0..1"),
        CIMRelationship("Qregulator", "Qregulator", "1", "0..1"),
        CIMRelationship("Umode", "Umode", "1", "0..1")
    )
    val BlockingFunction: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DCvoltageControl: Fielder = parse_attribute(attribute(cls, fields(1)))
    val PFmodel: Fielder = parse_attribute(attribute(cls, fields(2)))
    val Pcontrol: Fielder = parse_attribute(attribute(cls, fields(3)))
    val Qlimiter: Fielder = parse_attribute(attribute(cls, fields(4)))
    val Qmode: Fielder = parse_attribute(attribute(cls, fields(5)))
    val Qregulator: Fielder = parse_attribute(attribute(cls, fields(6)))
    val Umode: Fielder = parse_attribute(attribute(cls, fields(7)))

    def parse (context: CIMContext): VSCtype1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VSCtype1(
            VSCDynamics.parse(context),
            mask(BlockingFunction(), 0),
            mask(DCvoltageControl(), 1),
            mask(PFmodel(), 2),
            mask(Pcontrol(), 3),
            mask(Qlimiter(), 4),
            mask(Qmode(), 5),
            mask(Qregulator(), 6),
            mask(Umode(), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VSCtype1] = VSCtype1Serializer
}

object VSCtype1Serializer extends CIMSerializer[VSCtype1]
{
    def write (kryo: Kryo, output: Output, obj: VSCtype1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.BlockingFunction),
            () => output.writeString(obj.DCvoltageControl),
            () => output.writeString(obj.PFmodel),
            () => output.writeString(obj.Pcontrol),
            () => output.writeString(obj.Qlimiter),
            () => output.writeString(obj.Qmode),
            () => output.writeString(obj.Qregulator),
            () => output.writeString(obj.Umode)
        )
        VSCDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VSCtype1]): VSCtype1 =
    {
        val parent = VSCDynamicsSerializer.read(kryo, input, classOf[VSCDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = VSCtype1(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _VSC
{
    def register: List[CIMClassInfo] =
    {
        List(
            BlockingFunction.register,
            DCvoltageControl.register,
            PFmode.register,
            Pcontrol.register,
            Qlimiter.register,
            Qmode.register,
            Qregulator.register,
            Umode.register,
            VSCtype1.register
        )
    }
}