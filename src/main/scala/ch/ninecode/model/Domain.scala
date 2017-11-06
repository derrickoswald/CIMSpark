package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Interval between two dates.
 *
 * @param sup Reference to the superclass object.
 * @param end End date of this interval.
 * @param start Start date of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class DateInterval
(
    override val sup: BasicElement,
    end: String,
    start: String
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
    override def copy (): Row = { clone ().asInstanceOf[DateInterval] }
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
        implicit val clz: String = DateInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DateInterval.fields (position), value)
        emitelem (0, end)
        emitelem (1, start)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DateInterval rdf:ID=\"%s\">\n%s\t</cim:DateInterval>".format (id, export_fields)
    }
}

object DateInterval
extends
    Parseable[DateInterval]
{
    override val fields: Array[String] = Array[String] (
        "end",
        "start"
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val start: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DateInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DateInterval (
            BasicElement.parse (context),
            mask (end (), 0),
            mask (start (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Interval between two date and time points.
 *
 * @param sup Reference to the superclass object.
 * @param end End date and time of this interval.
 * @param start Start date and time of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class DateTimeInterval
(
    override val sup: BasicElement,
    end: String,
    start: String
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
    override def copy (): Row = { clone ().asInstanceOf[DateTimeInterval] }
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
        implicit val clz: String = DateTimeInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DateTimeInterval.fields (position), value)
        emitelem (0, end)
        emitelem (1, start)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DateTimeInterval rdf:ID=\"%s\">\n%s\t</cim:DateTimeInterval>".format (id, export_fields)
    }
}

object DateTimeInterval
extends
    Parseable[DateTimeInterval]
{
    override val fields: Array[String] = Array[String] (
        "end",
        "start"
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val start: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DateTimeInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DateTimeInterval (
            BasicElement.parse (context),
            mask (end (), 0),
            mask (start (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class DecimalQuantity
(
    override val sup: BasicElement,
    currency: String,
    multiplier: String,
    unit: String,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DecimalQuantity] }
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
        implicit val clz: String = DecimalQuantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DecimalQuantity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DecimalQuantity.fields (position), value)
        emitattr (0, currency)
        emitattr (1, multiplier)
        emitattr (2, unit)
        emitelem (3, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DecimalQuantity rdf:ID=\"%s\">\n%s\t</cim:DecimalQuantity>".format (id, export_fields)
    }
}

object DecimalQuantity
extends
    Parseable[DecimalQuantity]
{
    override val fields: Array[String] = Array[String] (
        "currency",
        "multiplier",
        "unit",
        "value"
    )
    val currency: Fielder = parse_attribute (attribute (cls, fields(0)))
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val unit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val value: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): DecimalQuantity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DecimalQuantity (
            BasicElement.parse (context),
            mask (currency (), 0),
            mask (multiplier (), 1),
            mask (unit (), 2),
            toDouble (mask (value (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Quantity with float value and associated unit information.
 *
 * @param sup Reference to the superclass object.
 * @param multiplier <em>undocumented</em>
 * @param unit <em>undocumented</em>
 * @param value <em>undocumented</em>
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class FloatQuantity
(
    override val sup: BasicElement,
    multiplier: String,
    unit: String,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FloatQuantity] }
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
        implicit val clz: String = FloatQuantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FloatQuantity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FloatQuantity.fields (position), value)
        emitattr (0, multiplier)
        emitattr (1, unit)
        emitelem (2, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FloatQuantity rdf:ID=\"%s\">\n%s\t</cim:FloatQuantity>".format (id, export_fields)
    }
}

object FloatQuantity
extends
    Parseable[FloatQuantity]
{
    override val fields: Array[String] = Array[String] (
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): FloatQuantity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FloatQuantity (
            BasicElement.parse (context),
            mask (multiplier (), 0),
            mask (unit (), 1),
            toDouble (mask (value (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Quantity with integer value and associated unit information.
 *
 * @param sup Reference to the superclass object.
 * @param multiplier <em>undocumented</em>
 * @param unit <em>undocumented</em>
 * @param value <em>undocumented</em>
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class IntegerQuantity
(
    override val sup: BasicElement,
    multiplier: String,
    unit: String,
    value: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IntegerQuantity] }
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
        implicit val clz: String = IntegerQuantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IntegerQuantity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IntegerQuantity.fields (position), value)
        emitattr (0, multiplier)
        emitattr (1, unit)
        emitelem (2, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IntegerQuantity rdf:ID=\"%s\">\n%s\t</cim:IntegerQuantity>".format (id, export_fields)
    }
}

object IntegerQuantity
extends
    Parseable[IntegerQuantity]
{
    override val fields: Array[String] = Array[String] (
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): IntegerQuantity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = IntegerQuantity (
            BasicElement.parse (context),
            mask (multiplier (), 0),
            mask (unit (), 1),
            toInteger (mask (value (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Interval between two times specified as mont and date.
 *
 * @param sup Reference to the superclass object.
 * @param end End time of this interval.
 * @param start Start time of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class MonthDayInterval
(
    override val sup: BasicElement,
    end: String,
    start: String
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
    override def copy (): Row = { clone ().asInstanceOf[MonthDayInterval] }
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
        implicit val clz: String = MonthDayInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MonthDayInterval.fields (position), value)
        emitelem (0, end)
        emitelem (1, start)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MonthDayInterval rdf:ID=\"%s\">\n%s\t</cim:MonthDayInterval>".format (id, export_fields)
    }
}

object MonthDayInterval
extends
    Parseable[MonthDayInterval]
{
    override val fields: Array[String] = Array[String] (
        "end",
        "start"
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val start: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): MonthDayInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MonthDayInterval (
            BasicElement.parse (context),
            mask (end (), 0),
            mask (start (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Quantity with string value (when it is not important whether it is an integral or a floating point number) and associated unit information.
 *
 * @param sup Reference to the superclass object.
 * @param multiplier <em>undocumented</em>
 * @param unit <em>undocumented</em>
 * @param value <em>undocumented</em>
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class StringQuantity
(
    override val sup: BasicElement,
    multiplier: String,
    unit: String,
    value: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[StringQuantity] }
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
        implicit val clz: String = StringQuantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StringQuantity.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StringQuantity.fields (position), value)
        emitattr (0, multiplier)
        emitattr (1, unit)
        emitelem (2, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StringQuantity rdf:ID=\"%s\">\n%s\t</cim:StringQuantity>".format (id, export_fields)
    }
}

object StringQuantity
extends
    Parseable[StringQuantity]
{
    override val fields: Array[String] = Array[String] (
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unit: Fielder = parse_attribute (attribute (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): StringQuantity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StringQuantity (
            BasicElement.parse (context),
            mask (multiplier (), 0),
            mask (unit (), 1),
            mask (value (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Interval between two times.
 *
 * @param sup Reference to the superclass object.
 * @param end End time of this interval.
 * @param start Start time of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package define primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
&lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
&lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
&lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
&lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or othe Compound classes, as long as the Compound classes do not recurse.
 */
case class TimeInterval
(
    override val sup: BasicElement,
    end: String,
    start: String
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
    override def copy (): Row = { clone ().asInstanceOf[TimeInterval] }
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
        implicit val clz: String = TimeInterval.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeInterval.fields (position), value)
        emitelem (0, end)
        emitelem (1, start)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeInterval rdf:ID=\"%s\">\n%s\t</cim:TimeInterval>".format (id, export_fields)
    }
}

object TimeInterval
extends
    Parseable[TimeInterval]
{
    override val fields: Array[String] = Array[String] (
        "end",
        "start"
    )
    val end: Fielder = parse_element (element (cls, fields(0)))
    val start: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): TimeInterval =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TimeInterval (
            BasicElement.parse (context),
            mask (end (), 0),
            mask (start (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Domain
{
    def register: List[ClassInfo] =
    {
        List (
            DateInterval.register,
            DateTimeInterval.register,
            DecimalQuantity.register,
            FloatQuantity.register,
            IntegerQuantity.register,
            MonthDayInterval.register,
            StringQuantity.register,
            TimeInterval.register
        )
    }
}