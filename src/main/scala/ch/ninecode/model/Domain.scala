package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The domain package define primitive datatypes that are used by classes in other packages.
 * Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 */

/**
 * Interval between two dates.
 * @param sup Reference to the superclass object.
 * @param end End date of this interval.
 * @param start Start date of this interval.
 */
case class DateInterval
(
    override val sup: BasicElement,
    val end: String,
    val start: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DateInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DateInterval
extends
    Parseable[DateInterval]
{
    val sup = BasicElement.parse _
    val end = parse_element (element ("""DateInterval.end"""))
    val start = parse_element (element ("""DateInterval.start"""))
    def parse (context: Context): DateInterval =
    {
        DateInterval(
            sup (context),
            end (context),
            start (context)
        )
    }
}

/**
 * Interval between two date and time points.
 * @param sup Reference to the superclass object.
 * @param end End date and time of this interval.
 * @param start Start date and time of this interval.
 */
case class DateTimeInterval
(
    override val sup: BasicElement,
    val end: String,
    val start: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DateTimeInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DateTimeInterval
extends
    Parseable[DateTimeInterval]
{
    val sup = BasicElement.parse _
    val end = parse_element (element ("""DateTimeInterval.end"""))
    val start = parse_element (element ("""DateTimeInterval.start"""))
    def parse (context: Context): DateTimeInterval =
    {
        DateTimeInterval(
            sup (context),
            end (context),
            start (context)
        )
    }
}

case class DecimalQuantity
(
    override val sup: BasicElement,
    val currency: String,
    val multiplier: String,
    val unit: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DecimalQuantity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DecimalQuantity
extends
    Parseable[DecimalQuantity]
{
    val sup = BasicElement.parse _
    val currency = parse_attribute (attribute ("""DecimalQuantity.currency"""))
    val multiplier = parse_attribute (attribute ("""DecimalQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""DecimalQuantity.unit"""))
    val value = parse_element (element ("""DecimalQuantity.value"""))
    def parse (context: Context): DecimalQuantity =
    {
        DecimalQuantity(
            sup (context),
            currency (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Quantity with float value and associated unit information.
 * @param sup Reference to the superclass object.
 * @param multiplier
 * @param unit
 * @param value
 */
case class FloatQuantity
(
    override val sup: BasicElement,
    val multiplier: String,
    val unit: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FloatQuantity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FloatQuantity
extends
    Parseable[FloatQuantity]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""FloatQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""FloatQuantity.unit"""))
    val value = parse_element (element ("""FloatQuantity.value"""))
    def parse (context: Context): FloatQuantity =
    {
        FloatQuantity(
            sup (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Quantity with integer value and associated unit information.
 * @param sup Reference to the superclass object.
 * @param multiplier
 * @param unit
 * @param value
 */
case class IntegerQuantity
(
    override val sup: BasicElement,
    val multiplier: String,
    val unit: String,
    val value: Int
)
extends
    Element
{
    def this () = { this (null, null, null, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IntegerQuantity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IntegerQuantity
extends
    Parseable[IntegerQuantity]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""IntegerQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""IntegerQuantity.unit"""))
    val value = parse_element (element ("""IntegerQuantity.value"""))
    def parse (context: Context): IntegerQuantity =
    {
        IntegerQuantity(
            sup (context),
            multiplier (context),
            unit (context),
            toInteger (value (context), context)
        )
    }
}

/**
 * Interval between two times specified as mont and date.
 * @param sup Reference to the superclass object.
 * @param end End time of this interval.
 * @param start Start time of this interval.
 */
case class MonthDayInterval
(
    override val sup: BasicElement,
    val end: String,
    val start: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MonthDayInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MonthDayInterval
extends
    Parseable[MonthDayInterval]
{
    val sup = BasicElement.parse _
    val end = parse_element (element ("""MonthDayInterval.end"""))
    val start = parse_element (element ("""MonthDayInterval.start"""))
    def parse (context: Context): MonthDayInterval =
    {
        MonthDayInterval(
            sup (context),
            end (context),
            start (context)
        )
    }
}

/**
 * Quantity with string value (when it is not important whether it is an integral or a floating point number) and associated unit information.
 * @param sup Reference to the superclass object.
 * @param multiplier
 * @param unit
 * @param value
 */
case class StringQuantity
(
    override val sup: BasicElement,
    val multiplier: String,
    val unit: String,
    val value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StringQuantity]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StringQuantity
extends
    Parseable[StringQuantity]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""StringQuantity.multiplier"""))
    val unit = parse_attribute (attribute ("""StringQuantity.unit"""))
    val value = parse_element (element ("""StringQuantity.value"""))
    def parse (context: Context): StringQuantity =
    {
        StringQuantity(
            sup (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
}

/**
 * Interval between two times.
 * @param sup Reference to the superclass object.
 * @param end End time of this interval.
 * @param start Start time of this interval.
 */
case class TimeInterval
(
    override val sup: BasicElement,
    val end: String,
    val start: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeInterval]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeInterval
extends
    Parseable[TimeInterval]
{
    val sup = BasicElement.parse _
    val end = parse_element (element ("""TimeInterval.end"""))
    val start = parse_element (element ("""TimeInterval.start"""))
    def parse (context: Context): TimeInterval =
    {
        TimeInterval(
            sup (context),
            end (context),
            start (context)
        )
    }
}

object _Domain
{
    def register: Unit =
    {
        DateInterval.register
        DateTimeInterval.register
        DecimalQuantity.register
        FloatQuantity.register
        IntegerQuantity.register
        MonthDayInterval.register
        StringQuantity.register
        TimeInterval.register
    }
}