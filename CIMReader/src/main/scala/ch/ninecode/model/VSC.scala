package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class BlockingFunction
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BlockingFunction] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BlockingFunction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BlockingFunction.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BlockingFunction rdf:ID=\"%s\">\n%s\t</cim:BlockingFunction>".format (id, export_fields)
    }
}

object BlockingFunction
extends
    Parseable[BlockingFunction]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): BlockingFunction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BlockingFunction (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DC voltage control used for voltage regulation.
 *
 * @param sup Reference to the superclass object.
 * @param kivdc Integral gain of the DC voltage regulator (Kivdc).
 * @param kpvdc Proportional gain of the DC voltage regulator (Kpvdc).
 * @param vdcmax Maximum DC voltage (Vdcmax).
 * @param vdcmin Minimum DC voltage (Vdcmin).
 * @param Delay [[ch.ninecode.model.Delay Delay]] <em>undocumented</em>
 * @param VSCtype1 [[ch.ninecode.model.VSCtype1 VSCtype1]] <em>undocumented</em>
 * @group VSC
 * @groupname VSC Package VSC
 */
final case class DCvoltageControl
(
    override val sup: BasicElement,
    kivdc: Double,
    kpvdc: Double,
    vdcmax: Double,
    vdcmin: Double,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DCvoltageControl] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DCvoltageControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DCvoltageControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DCvoltageControl.fields (position), value)
        emitelem (0, kivdc)
        emitelem (1, kpvdc)
        emitelem (2, vdcmax)
        emitelem (3, vdcmin)
        emitattr (4, Delay)
        emitattr (5, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DCvoltageControl rdf:ID=\"%s\">\n%s\t</cim:DCvoltageControl>".format (id, export_fields)
    }
}

object DCvoltageControl
extends
    Parseable[DCvoltageControl]
{
    override val fields: Array[String] = Array[String] (
        "kivdc",
        "kpvdc",
        "vdcmax",
        "vdcmin",
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val kivdc: Fielder = parse_element (element (cls, fields(0)))
    val kpvdc: Fielder = parse_element (element (cls, fields(1)))
    val vdcmax: Fielder = parse_element (element (cls, fields(2)))
    val vdcmin: Fielder = parse_element (element (cls, fields(3)))
    val Delay: Fielder = parse_attribute (attribute (cls, fields(4)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): DCvoltageControl =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DCvoltageControl (
            BasicElement.parse (context),
            toDouble (mask (kivdc (), 0)),
            toDouble (mask (kpvdc (), 1)),
            toDouble (mask (vdcmax (), 2)),
            toDouble (mask (vdcmin (), 3)),
            mask (Delay (), 4),
            mask (VSCtype1 (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class PFmode
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PFmode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PFmode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PFmode.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFmode rdf:ID=\"%s\">\n%s\t</cim:PFmode>".format (id, export_fields)
    }
}

object PFmode
extends
    Parseable[PFmode]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): PFmode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = PFmode (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Pcontrol
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Pcontrol] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pcontrol.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pcontrol.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Pcontrol rdf:ID=\"%s\">\n%s\t</cim:Pcontrol>".format (id, export_fields)
    }
}

object Pcontrol
extends
    Parseable[Pcontrol]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Pcontrol =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Pcontrol (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qlimiter
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Qlimiter] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Qlimiter.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Qlimiter.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Qlimiter rdf:ID=\"%s\">\n%s\t</cim:Qlimiter>".format (id, export_fields)
    }
}

object Qlimiter
extends
    Parseable[Qlimiter]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Qlimiter =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Qlimiter (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qmode
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Qmode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Qmode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Qmode.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Qmode rdf:ID=\"%s\">\n%s\t</cim:Qmode>".format (id, export_fields)
    }
}

object Qmode
extends
    Parseable[Qmode]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Qmode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Qmode (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Qregulator
(
    override val sup: BasicElement,
    Delay: String,
    HVDClookUpTable: List[String],
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Qregulator] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Qregulator.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Qregulator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Qregulator.fields (position), x))
        emitattr (0, Delay)
        emitattrs (1, HVDClookUpTable)
        emitattr (2, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Qregulator rdf:ID=\"%s\">\n%s\t</cim:Qregulator>".format (id, export_fields)
    }
}

object Qregulator
extends
    Parseable[Qregulator]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "HVDClookUpTable",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("HVDClookUpTable", "HVDCLookUpTable", "1..*", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val HVDClookUpTable: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): Qregulator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Qregulator (
            BasicElement.parse (context),
            mask (Delay (), 0),
            masks (HVDClookUpTable (), 1),
            mask (VSCtype1 (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class Umode
(
    override val sup: BasicElement,
    Delay: String,
    VSCtype1: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Umode] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Umode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Umode.fields (position), value)
        emitattr (0, Delay)
        emitattr (1, VSCtype1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Umode rdf:ID=\"%s\">\n%s\t</cim:Umode>".format (id, export_fields)
    }
}

object Umode
extends
    Parseable[Umode]
{
    override val fields: Array[String] = Array[String] (
        "Delay",
        "VSCtype1"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Delay", "Delay", "1", "0..1"),
        Relationship ("VSCtype1", "VSCtype1", "0..1", "1")
    )
    val Delay: Fielder = parse_attribute (attribute (cls, fields(0)))
    val VSCtype1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): Umode =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Umode (
            BasicElement.parse (context),
            mask (Delay (), 0),
            mask (VSCtype1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group VSC
 * @groupname VSC Package VSC
 */
final case class VSCtype1
(
    override val sup: VSCDynamics,
    BlockingFunction: String,
    DCvoltageControl: String,
    PFmodel: String,
    Pcontrol: String,
    Qlimiter: String,
    Qmode: String,
    Qregulator: String,
    Umode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VSCDynamics: VSCDynamics = sup.asInstanceOf[VSCDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VSCtype1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VSCtype1.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VSCtype1.fields (position), value)
        emitattr (0, BlockingFunction)
        emitattr (1, DCvoltageControl)
        emitattr (2, PFmodel)
        emitattr (3, Pcontrol)
        emitattr (4, Qlimiter)
        emitattr (5, Qmode)
        emitattr (6, Qregulator)
        emitattr (7, Umode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VSCtype1 rdf:ID=\"%s\">\n%s\t</cim:VSCtype1>".format (id, export_fields)
    }
}

object VSCtype1
extends
    Parseable[VSCtype1]
{
    override val fields: Array[String] = Array[String] (
        "BlockingFunction",
        "DCvoltageControl",
        "PFmodel",
        "Pcontrol",
        "Qlimiter",
        "Qmode",
        "Qregulator",
        "Umode"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BlockingFunction", "BlockingFunction", "1", "0..1"),
        Relationship ("DCvoltageControl", "DCvoltageControl", "1", "0..1"),
        Relationship ("PFmodel", "PFmode", "1", "0..1"),
        Relationship ("Pcontrol", "Pcontrol", "1", "0..1"),
        Relationship ("Qlimiter", "Qlimiter", "1", "0..1"),
        Relationship ("Qmode", "Qmode", "1", "0..1"),
        Relationship ("Qregulator", "Qregulator", "1", "0..1"),
        Relationship ("Umode", "Umode", "1", "0..1")
    )
    val BlockingFunction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCvoltageControl: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PFmodel: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Pcontrol: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Qlimiter: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Qmode: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Qregulator: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Umode: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): VSCtype1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VSCtype1 (
            VSCDynamics.parse (context),
            mask (BlockingFunction (), 0),
            mask (DCvoltageControl (), 1),
            mask (PFmodel (), 2),
            mask (Pcontrol (), 3),
            mask (Qlimiter (), 4),
            mask (Qmode (), 5),
            mask (Qregulator (), 6),
            mask (Umode (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _VSC
{
    def register: List[ClassInfo] =
    {
        List (
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