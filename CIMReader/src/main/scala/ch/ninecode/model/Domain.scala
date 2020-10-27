package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable

import ch.ninecode.cim.CIMSerializer

/**
 * Interval between two dates.
 *
 * @param Element Reference to the superclass object.
 * @param end     End date of this interval.
 * @param start   Start date of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class DateInterval
(
    Element: BasicElement = null,
    end: String = null,
    start: String = null
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
        implicit val clz: String = DateInterval.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DateInterval.fields(position), value)

        emitelem(0, end)
        emitelem(1, start)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DateInterval rdf:%s=\"%s\">\n%s\t</cim:DateInterval>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DateInterval
    extends
        CIMParseable[DateInterval]
{
    override val fields: Array[String] = Array[String](
        "end",
        "start"
    )
    val end: Fielder = parse_element(element(cls, fields(0)))
    val start: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DateInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DateInterval(
            BasicElement.parse(context),
            mask(end(), 0),
            mask(start(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DateInterval] = DateIntervalSerializer
}

object DateIntervalSerializer extends CIMSerializer[DateInterval]
{
    def write (kryo: Kryo, output: Output, obj: DateInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.end),
            () => output.writeString(obj.start)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DateInterval]): DateInterval =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DateInterval(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Interval between two date and time points, where the interval includes the start time but excludes end time.
 *
 * @param Element Reference to the superclass object.
 * @param end     End date and time of this interval.
 *                The end date and time where the interval is defined up to, but excluded.
 * @param start   Start date and time of this interval.
 *                The start date and time is included in the defined interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class DateTimeInterval
(
    Element: BasicElement = null,
    end: String = null,
    start: String = null
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
        implicit val clz: String = DateTimeInterval.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DateTimeInterval.fields(position), value)

        emitelem(0, end)
        emitelem(1, start)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DateTimeInterval rdf:%s=\"%s\">\n%s\t</cim:DateTimeInterval>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DateTimeInterval
    extends
        CIMParseable[DateTimeInterval]
{
    override val fields: Array[String] = Array[String](
        "end",
        "start"
    )
    val end: Fielder = parse_element(element(cls, fields(0)))
    val start: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DateTimeInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DateTimeInterval(
            BasicElement.parse(context),
            mask(end(), 0),
            mask(start(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DateTimeInterval] = DateTimeIntervalSerializer
}

object DateTimeIntervalSerializer extends CIMSerializer[DateTimeInterval]
{
    def write (kryo: Kryo, output: Output, obj: DateTimeInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.end),
            () => output.writeString(obj.start)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DateTimeInterval]): DateTimeInterval =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DateTimeInterval(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Quantity with decimal value and associated unit or currency information.
 *
 * @param Element    Reference to the superclass object.
 * @param currency   Currency of this quantity.
 * @param multiplier Unit multiplier of this quantity.
 * @param unit       Unit of this quantity.
 * @param value      Value of this quantity.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class DecimalQuantity
(
    Element: BasicElement = null,
    currency: String = null,
    multiplier: String = null,
    unit: String = null,
    value: Double = 0.0
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
        implicit val clz: String = DecimalQuantity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DecimalQuantity.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DecimalQuantity.fields(position), value)

        emitattr(0, currency)
        emitattr(1, multiplier)
        emitattr(2, unit)
        emitelem(3, value)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DecimalQuantity rdf:%s=\"%s\">\n%s\t</cim:DecimalQuantity>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DecimalQuantity
    extends
        CIMParseable[DecimalQuantity]
{
    override val fields: Array[String] = Array[String](
        "currency",
        "multiplier",
        "unit",
        "value"
    )
    val currency: Fielder = parse_attribute(attribute(cls, fields(0)))
    val multiplier: Fielder = parse_attribute(attribute(cls, fields(1)))
    val unit: Fielder = parse_attribute(attribute(cls, fields(2)))
    val value: Fielder = parse_element(element(cls, fields(3)))

    def parse (context: CIMContext): DecimalQuantity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DecimalQuantity(
            BasicElement.parse(context),
            mask(currency(), 0),
            mask(multiplier(), 1),
            mask(unit(), 2),
            toDouble(mask(value(), 3))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DecimalQuantity] = DecimalQuantitySerializer
}

object DecimalQuantitySerializer extends CIMSerializer[DecimalQuantity]
{
    def write (kryo: Kryo, output: Output, obj: DecimalQuantity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.currency),
            () => output.writeString(obj.multiplier),
            () => output.writeString(obj.unit),
            () => output.writeDouble(obj.value)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DecimalQuantity]): DecimalQuantity =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DecimalQuantity(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Quantity with float value and associated unit information.
 *
 * @param Element    Reference to the superclass object.
 * @param multiplier Unit multiplier of this quantity.
 * @param unit       Unit of this quantity.
 * @param value      Value of this quantity.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class FloatQuantity
(
    Element: BasicElement = null,
    multiplier: String = null,
    unit: String = null,
    value: Double = 0.0
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
        implicit val clz: String = FloatQuantity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(FloatQuantity.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(FloatQuantity.fields(position), value)

        emitattr(0, multiplier)
        emitattr(1, unit)
        emitelem(2, value)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:FloatQuantity rdf:%s=\"%s\">\n%s\t</cim:FloatQuantity>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object FloatQuantity
    extends
        CIMParseable[FloatQuantity]
{
    override val fields: Array[String] = Array[String](
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute(attribute(cls, fields(0)))
    val unit: Fielder = parse_attribute(attribute(cls, fields(1)))
    val value: Fielder = parse_element(element(cls, fields(2)))

    def parse (context: CIMContext): FloatQuantity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FloatQuantity(
            BasicElement.parse(context),
            mask(multiplier(), 0),
            mask(unit(), 1),
            toDouble(mask(value(), 2))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FloatQuantity] = FloatQuantitySerializer
}

object FloatQuantitySerializer extends CIMSerializer[FloatQuantity]
{
    def write (kryo: Kryo, output: Output, obj: FloatQuantity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.multiplier),
            () => output.writeString(obj.unit),
            () => output.writeDouble(obj.value)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FloatQuantity]): FloatQuantity =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = FloatQuantity(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Quantity with integer value and associated unit information.
 *
 * @param Element    Reference to the superclass object.
 * @param multiplier Unit multiplier of this quantity.
 * @param unit       Unit of this quantity.
 * @param value      Value of this quantity.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class IntegerQuantity
(
    Element: BasicElement = null,
    multiplier: String = null,
    unit: String = null,
    value: Int = 0
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
        implicit val clz: String = IntegerQuantity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(IntegerQuantity.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(IntegerQuantity.fields(position), value)

        emitattr(0, multiplier)
        emitattr(1, unit)
        emitelem(2, value)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:IntegerQuantity rdf:%s=\"%s\">\n%s\t</cim:IntegerQuantity>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object IntegerQuantity
    extends
        CIMParseable[IntegerQuantity]
{
    override val fields: Array[String] = Array[String](
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute(attribute(cls, fields(0)))
    val unit: Fielder = parse_attribute(attribute(cls, fields(1)))
    val value: Fielder = parse_element(element(cls, fields(2)))

    def parse (context: CIMContext): IntegerQuantity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IntegerQuantity(
            BasicElement.parse(context),
            mask(multiplier(), 0),
            mask(unit(), 1),
            toInteger(mask(value(), 2))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IntegerQuantity] = IntegerQuantitySerializer
}

object IntegerQuantitySerializer extends CIMSerializer[IntegerQuantity]
{
    def write (kryo: Kryo, output: Output, obj: IntegerQuantity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.multiplier),
            () => output.writeString(obj.unit),
            () => output.writeInt(obj.value)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IntegerQuantity]): IntegerQuantity =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = IntegerQuantity(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Interval between two times specified as month and day.
 *
 * @param Element Reference to the superclass object.
 * @param end     End time of this interval.
 * @param start   Start time of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class MonthDayInterval
(
    Element: BasicElement = null,
    end: String = null,
    start: String = null
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
        implicit val clz: String = MonthDayInterval.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MonthDayInterval.fields(position), value)

        emitelem(0, end)
        emitelem(1, start)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MonthDayInterval rdf:%s=\"%s\">\n%s\t</cim:MonthDayInterval>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MonthDayInterval
    extends
        CIMParseable[MonthDayInterval]
{
    override val fields: Array[String] = Array[String](
        "end",
        "start"
    )
    val end: Fielder = parse_element(element(cls, fields(0)))
    val start: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): MonthDayInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MonthDayInterval(
            BasicElement.parse(context),
            mask(end(), 0),
            mask(start(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MonthDayInterval] = MonthDayIntervalSerializer
}

object MonthDayIntervalSerializer extends CIMSerializer[MonthDayInterval]
{
    def write (kryo: Kryo, output: Output, obj: MonthDayInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.end),
            () => output.writeString(obj.start)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MonthDayInterval]): MonthDayInterval =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MonthDayInterval(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Quantity with string value (when it is not important whether it is an integral or a floating point number) and associated unit information.
 *
 * @param Element    Reference to the superclass object.
 * @param multiplier Unit multiplier of this quantity.
 * @param unit       Unit of this quantity.
 * @param value      Value of this quantity.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class StringQuantity
(
    Element: BasicElement = null,
    multiplier: String = null,
    unit: String = null,
    value: String = null
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
        implicit val clz: String = StringQuantity.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(StringQuantity.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(StringQuantity.fields(position), value)

        emitattr(0, multiplier)
        emitattr(1, unit)
        emitelem(2, value)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:StringQuantity rdf:%s=\"%s\">\n%s\t</cim:StringQuantity>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object StringQuantity
    extends
        CIMParseable[StringQuantity]
{
    override val fields: Array[String] = Array[String](
        "multiplier",
        "unit",
        "value"
    )
    val multiplier: Fielder = parse_attribute(attribute(cls, fields(0)))
    val unit: Fielder = parse_attribute(attribute(cls, fields(1)))
    val value: Fielder = parse_element(element(cls, fields(2)))

    def parse (context: CIMContext): StringQuantity =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StringQuantity(
            BasicElement.parse(context),
            mask(multiplier(), 0),
            mask(unit(), 1),
            mask(value(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StringQuantity] = StringQuantitySerializer
}

object StringQuantitySerializer extends CIMSerializer[StringQuantity]
{
    def write (kryo: Kryo, output: Output, obj: StringQuantity): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.multiplier),
            () => output.writeString(obj.unit),
            () => output.writeString(obj.value)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StringQuantity]): StringQuantity =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = StringQuantity(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Interval between two times.
 *
 * @param Element Reference to the superclass object.
 * @param end     End time of this interval.
 * @param start   Start time of this interval.
 * @group Domain
 * @groupname Domain Package Domain
 * @groupdesc Domain The domain package defines primitive datatypes that are used by classes in other packages. Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *            &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 *            &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 *            &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 *            &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 *            For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 */
final case class TimeInterval
(
    Element: BasicElement = null,
    end: String = null,
    start: String = null
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
        implicit val clz: String = TimeInterval.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TimeInterval.fields(position), value)

        emitelem(0, end)
        emitelem(1, start)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TimeInterval rdf:%s=\"%s\">\n%s\t</cim:TimeInterval>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TimeInterval
    extends
        CIMParseable[TimeInterval]
{
    override val fields: Array[String] = Array[String](
        "end",
        "start"
    )
    val end: Fielder = parse_element(element(cls, fields(0)))
    val start: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): TimeInterval =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimeInterval(
            BasicElement.parse(context),
            mask(end(), 0),
            mask(start(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TimeInterval] = TimeIntervalSerializer
}

object TimeIntervalSerializer extends CIMSerializer[TimeInterval]
{
    def write (kryo: Kryo, output: Output, obj: TimeInterval): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.end),
            () => output.writeString(obj.start)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimeInterval]): TimeInterval =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TimeInterval(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Domain
{
    def register: List[CIMClassInfo] =
    {
        List(
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