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
        sup.export_fields +
        (if (null != end) "\t\t<cim:DateInterval.end>" + end + "</cim:DateInterval.end>\n" else "") +
        (if (null != start) "\t\t<cim:DateInterval.start>" + start + "</cim:DateInterval.start>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DateInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DateInterval>"
    }
}

object DateInterval
extends
    Parseable[DateInterval]
{
    val end = parse_element (element ("""DateInterval.end"""))
    val start = parse_element (element ("""DateInterval.start"""))
    def parse (context: Context): DateInterval =
    {
        DateInterval(
            BasicElement.parse (context),
            end (context),
            start (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != end) "\t\t<cim:DateTimeInterval.end>" + end + "</cim:DateTimeInterval.end>\n" else "") +
        (if (null != start) "\t\t<cim:DateTimeInterval.start>" + start + "</cim:DateTimeInterval.start>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DateTimeInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DateTimeInterval>"
    }
}

object DateTimeInterval
extends
    Parseable[DateTimeInterval]
{
    val end = parse_element (element ("""DateTimeInterval.end"""))
    val start = parse_element (element ("""DateTimeInterval.start"""))
    def parse (context: Context): DateTimeInterval =
    {
        DateTimeInterval(
            BasicElement.parse (context),
            end (context),
            start (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != currency) "\t\t<cim:DecimalQuantity.currency rdf:resource=\"#" + currency + "\"/>\n" else "") +
        (if (null != multiplier) "\t\t<cim:DecimalQuantity.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:DecimalQuantity.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:DecimalQuantity.value>" + value + "</cim:DecimalQuantity.value>\n"
    }
    override def export: String =
    {
        "\t<cim:DecimalQuantity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DecimalQuantity>"
    }
}

object DecimalQuantity
extends
    Parseable[DecimalQuantity]
{
    val currency = parse_attribute (attribute ("""DecimalQuantity.currency"""))
    val multiplier = parse_attribute (attribute ("""DecimalQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""DecimalQuantity.unit"""))
    val value = parse_element (element ("""DecimalQuantity.value"""))
    def parse (context: Context): DecimalQuantity =
    {
        DecimalQuantity(
            BasicElement.parse (context),
            currency (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != multiplier) "\t\t<cim:FloatQuantity.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:FloatQuantity.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:FloatQuantity.value>" + value + "</cim:FloatQuantity.value>\n"
    }
    override def export: String =
    {
        "\t<cim:FloatQuantity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FloatQuantity>"
    }
}

object FloatQuantity
extends
    Parseable[FloatQuantity]
{
    val multiplier = parse_attribute (attribute ("""FloatQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""FloatQuantity.unit"""))
    val value = parse_element (element ("""FloatQuantity.value"""))
    def parse (context: Context): FloatQuantity =
    {
        FloatQuantity(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != multiplier) "\t\t<cim:IntegerQuantity.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:IntegerQuantity.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:IntegerQuantity.value>" + value + "</cim:IntegerQuantity.value>\n"
    }
    override def export: String =
    {
        "\t<cim:IntegerQuantity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IntegerQuantity>"
    }
}

object IntegerQuantity
extends
    Parseable[IntegerQuantity]
{
    val multiplier = parse_attribute (attribute ("""IntegerQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""IntegerQuantity.unit"""))
    val value = parse_element (element ("""IntegerQuantity.value"""))
    def parse (context: Context): IntegerQuantity =
    {
        IntegerQuantity(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            toInteger (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != end) "\t\t<cim:MonthDayInterval.end>" + end + "</cim:MonthDayInterval.end>\n" else "") +
        (if (null != start) "\t\t<cim:MonthDayInterval.start>" + start + "</cim:MonthDayInterval.start>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MonthDayInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MonthDayInterval>"
    }
}

object MonthDayInterval
extends
    Parseable[MonthDayInterval]
{
    val end = parse_element (element ("""MonthDayInterval.end"""))
    val start = parse_element (element ("""MonthDayInterval.start"""))
    def parse (context: Context): MonthDayInterval =
    {
        MonthDayInterval(
            BasicElement.parse (context),
            end (context),
            start (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != multiplier) "\t\t<cim:StringQuantity.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:StringQuantity.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        (if (null != value) "\t\t<cim:StringQuantity.value>" + value + "</cim:StringQuantity.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StringQuantity rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StringQuantity>"
    }
}

object StringQuantity
extends
    Parseable[StringQuantity]
{
    val multiplier = parse_attribute (attribute ("""StringQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""StringQuantity.unit"""))
    val value = parse_element (element ("""StringQuantity.value"""))
    def parse (context: Context): StringQuantity =
    {
        StringQuantity(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != end) "\t\t<cim:TimeInterval.end>" + end + "</cim:TimeInterval.end>\n" else "") +
        (if (null != start) "\t\t<cim:TimeInterval.start>" + start + "</cim:TimeInterval.start>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TimeInterval rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeInterval>"
    }
}

object TimeInterval
extends
    Parseable[TimeInterval]
{
    val end = parse_element (element ("""TimeInterval.end"""))
    val start = parse_element (element ("""TimeInterval.start"""))
    def parse (context: Context): TimeInterval =
    {
        TimeInterval(
            BasicElement.parse (context),
            end (context),
            start (context)
        )
    }
    val relations: List[Relationship] = List ()
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