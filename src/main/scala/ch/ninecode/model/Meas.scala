package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Accumulator represents an accumulated (counted) Measurement, e.g. an energy value.
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param LimitSets [[ch.ninecode.model.AccumulatorLimitSet AccumulatorLimitSet]] A measurement may have zero or more limit ranges defined for it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Accumulator
(
    override val sup: Measurement,
    maxValue: Int,
    LimitSets: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Accumulator] }
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
        implicit val clz: String = Accumulator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Accumulator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Accumulator.fields (position), x))
        emitelem (0, maxValue)
        emitattrs (1, LimitSets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Accumulator rdf:ID=\"%s\">\n%s\t</cim:Accumulator>".format (id, export_fields)
    }
}

object Accumulator
extends
    Parseable[Accumulator]
{
    val fields: Array[String] = Array[String] (
        "maxValue",
        "LimitSets"
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val LimitSets: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Accumulator =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Accumulator (
            Measurement.parse (context),
            toInteger (mask (maxValue (), 0)),
            masks (LimitSets (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSets", "AccumulatorLimitSet", true)
    )
}

/**
 * Limit values for Accumulator measurements.
 *
 * @param sup [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param value The value to supervise against.
 *        The value is positive.
 * @param LimitSet [[ch.ninecode.model.AccumulatorLimitSet AccumulatorLimitSet]] The set of limits.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AccumulatorLimit
(
    override val sup: Limit,
    value: Int,
    LimitSet: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorLimit] }
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
        implicit val clz: String = AccumulatorLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccumulatorLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccumulatorLimit.fields (position), value)
        emitelem (0, value)
        emitattr (1, LimitSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimit rdf:ID=\"%s\">\n%s\t</cim:AccumulatorLimit>".format (id, export_fields)
    }
}

object AccumulatorLimit
extends
    Parseable[AccumulatorLimit]
{
    val fields: Array[String] = Array[String] (
        "value",
        "LimitSet"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val LimitSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AccumulatorLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccumulatorLimit (
            Limit.parse (context),
            toInteger (mask (value (), 0)),
            mask (LimitSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSet", "AccumulatorLimitSet", false)
    )
}

/**
 * An AccumulatorLimitSet specifies a set of Limits that are associated with an Accumulator measurement.
 *
 * @param sup [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @param Measurements [[ch.ninecode.model.Accumulator Accumulator]] The Measurements using the LimitSet.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AccumulatorLimitSet
(
    override val sup: LimitSet,
    Measurements: List[String]
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
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorLimitSet] }
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
        implicit val clz: String = AccumulatorLimitSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AccumulatorLimitSet.fields (position), x))
        emitattrs (0, Measurements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimitSet rdf:ID=\"%s\">\n%s\t</cim:AccumulatorLimitSet>".format (id, export_fields)
    }
}

object AccumulatorLimitSet
extends
    Parseable[AccumulatorLimitSet]
{
    val fields: Array[String] = Array[String] (
        "Measurements"
    )
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AccumulatorLimitSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccumulatorLimitSet (
            LimitSet.parse (context),
            masks (Measurements (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Measurements", "Accumulator", true)
    )
}

/**
 * This command reset the counter value to zero.
 *
 * @param sup [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param AccumulatorValue [[ch.ninecode.model.AccumulatorValue AccumulatorValue]] The accumulator value that is reset by the command.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AccumulatorReset
(
    override val sup: Control,
    AccumulatorValue: String
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
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorReset] }
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
        implicit val clz: String = AccumulatorReset.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccumulatorReset.fields (position), value)
        emitattr (0, AccumulatorValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccumulatorReset rdf:ID=\"%s\">\n%s\t</cim:AccumulatorReset>".format (id, export_fields)
    }
}

object AccumulatorReset
extends
    Parseable[AccumulatorReset]
{
    val fields: Array[String] = Array[String] (
        "AccumulatorValue"
    )
    val AccumulatorValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AccumulatorReset =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccumulatorReset (
            Control.parse (context),
            mask (AccumulatorValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AccumulatorValue", "AccumulatorValue", false)
    )
}

/**
 * AccumulatorValue represents an accumulated (counted) MeasurementValue.
 *
 * @param sup [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 *        The value is positive.
 * @param Accumulator [[ch.ninecode.model.Accumulator Accumulator]] Measurement to which this value is connected.
 * @param AccumulatorReset [[ch.ninecode.model.AccumulatorReset AccumulatorReset]] The command that reset the accumulator value.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AccumulatorValue
(
    override val sup: MeasurementValue,
    value: Int,
    Accumulator: String,
    AccumulatorReset: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[AccumulatorValue] }
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
        implicit val clz: String = AccumulatorValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AccumulatorValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AccumulatorValue.fields (position), value)
        emitelem (0, value)
        emitattr (1, Accumulator)
        emitattr (2, AccumulatorReset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccumulatorValue rdf:ID=\"%s\">\n%s\t</cim:AccumulatorValue>".format (id, export_fields)
    }
}

object AccumulatorValue
extends
    Parseable[AccumulatorValue]
{
    val fields: Array[String] = Array[String] (
        "value",
        "Accumulator",
        "AccumulatorReset"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val Accumulator: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AccumulatorReset: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AccumulatorValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AccumulatorValue (
            MeasurementValue.parse (context),
            toInteger (mask (value (), 0)),
            mask (Accumulator (), 1),
            mask (AccumulatorReset (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Accumulator", "Accumulator", false),
        Relationship ("AccumulatorReset", "AccumulatorReset", false)
    )
}

/**
 * Analog represents an analog Measurement.
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param positiveFlowIn If true then this measurement is an active power, reactive power or current with the convention that a positive value measured at the Terminal means power is flowing into the related PowerSystemResource.
 * @param LimitSets [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] A measurement may have zero or more limit ranges defined for it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Analog
(
    override val sup: Measurement,
    maxValue: Double,
    minValue: Double,
    normalValue: Double,
    positiveFlowIn: Boolean,
    LimitSets: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Analog] }
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
        implicit val clz: String = Analog.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Analog.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Analog.fields (position), x))
        emitelem (0, maxValue)
        emitelem (1, minValue)
        emitelem (2, normalValue)
        emitelem (3, positiveFlowIn)
        emitattrs (4, LimitSets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Analog rdf:ID=\"%s\">\n%s\t</cim:Analog>".format (id, export_fields)
    }
}

object Analog
extends
    Parseable[Analog]
{
    val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "normalValue",
        "positiveFlowIn",
        "LimitSets"
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val normalValue: Fielder = parse_element (element (cls, fields(2)))
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(3)))
    val LimitSets: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): Analog =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Analog (
            Measurement.parse (context),
            toDouble (mask (maxValue (), 0)),
            toDouble (mask (minValue (), 1)),
            toDouble (mask (normalValue (), 2)),
            toBoolean (mask (positiveFlowIn (), 3)),
            masks (LimitSets (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSets", "AnalogLimitSet", true)
    )
}

/**
 * An analog control used for supervisory control.
 *
 * @param sup [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param minValue Normal value range minimum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The MeasurementValue that is controlled.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AnalogControl
(
    override val sup: Control,
    maxValue: Double,
    minValue: Double,
    AnalogValue: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[AnalogControl] }
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
        implicit val clz: String = AnalogControl.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogControl.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalogControl.fields (position), value)
        emitelem (0, maxValue)
        emitelem (1, minValue)
        emitattr (2, AnalogValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogControl rdf:ID=\"%s\">\n%s\t</cim:AnalogControl>".format (id, export_fields)
    }
}

object AnalogControl
extends
    Parseable[AnalogControl]
{
    val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "AnalogValue"
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AnalogControl =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AnalogControl (
            Control.parse (context),
            toDouble (mask (maxValue (), 0)),
            toDouble (mask (minValue (), 1)),
            mask (AnalogValue (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false)
    )
}

/**
 * Limit values for Analog measurements.
 *
 * @param sup [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param value The value to supervise against.
 * @param LimitSet [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] The set of limits.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AnalogLimit
(
    override val sup: Limit,
    value: Double,
    LimitSet: String
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
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[AnalogLimit] }
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
        implicit val clz: String = AnalogLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogLimit.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalogLimit.fields (position), value)
        emitelem (0, value)
        emitattr (1, LimitSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogLimit rdf:ID=\"%s\">\n%s\t</cim:AnalogLimit>".format (id, export_fields)
    }
}

object AnalogLimit
extends
    Parseable[AnalogLimit]
{
    val fields: Array[String] = Array[String] (
        "value",
        "LimitSet"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val LimitSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): AnalogLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AnalogLimit (
            Limit.parse (context),
            toDouble (mask (value (), 0)),
            mask (LimitSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSet", "AnalogLimitSet", false)
    )
}

/**
 * An AnalogLimitSet specifies a set of Limits that are associated with an Analog measurement.
 *
 * @param sup [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @param Measurements [[ch.ninecode.model.Analog Analog]] The Measurements using the LimitSet.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AnalogLimitSet
(
    override val sup: LimitSet,
    Measurements: List[String]
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
    def LimitSet: LimitSet = sup.asInstanceOf[LimitSet]
    override def copy (): Row = { clone ().asInstanceOf[AnalogLimitSet] }
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
        implicit val clz: String = AnalogLimitSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AnalogLimitSet.fields (position), x))
        emitattrs (0, Measurements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogLimitSet rdf:ID=\"%s\">\n%s\t</cim:AnalogLimitSet>".format (id, export_fields)
    }
}

object AnalogLimitSet
extends
    Parseable[AnalogLimitSet]
{
    val fields: Array[String] = Array[String] (
        "Measurements"
    )
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): AnalogLimitSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AnalogLimitSet (
            LimitSet.parse (context),
            masks (Measurements (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Measurements", "Analog", true)
    )
}

/**
 * AnalogValue represents an analog MeasurementValue.
 *
 * @param sup [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param Analog [[ch.ninecode.model.Analog Analog]] Measurement to which this value is connected.
 * @param AnalogControl [[ch.ninecode.model.AnalogControl AnalogControl]] The Control variable associated with the MeasurementValue.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AnalogValue
(
    override val sup: MeasurementValue,
    value: Double,
    Analog: String,
    AnalogControl: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[AnalogValue] }
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
        implicit val clz: String = AnalogValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalogValue.fields (position), value)
        emitelem (0, value)
        emitattr (1, Analog)
        emitattr (2, AnalogControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogValue rdf:ID=\"%s\">\n%s\t</cim:AnalogValue>".format (id, export_fields)
    }
}

object AnalogValue
extends
    Parseable[AnalogValue]
{
    val fields: Array[String] = Array[String] (
        "value",
        "Analog",
        "AnalogControl"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val Analog: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AnalogControl: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AnalogValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AnalogValue (
            MeasurementValue.parse (context),
            toDouble (mask (value (), 0)),
            mask (Analog (), 1),
            mask (AnalogControl (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Analog", "Analog", false),
        Relationship ("AnalogControl", "AnalogControl", false)
    )
}

/**
 * A Command is a discrete control used for supervisory control.
 *
 * @param sup [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 * @param DiscreteValue [[ch.ninecode.model.DiscreteValue DiscreteValue]] The MeasurementValue that is controlled.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a Control value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Command
(
    override val sup: Control,
    normalValue: Int,
    value: Int,
    DiscreteValue: String,
    ValueAliasSet: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Control: Control = sup.asInstanceOf[Control]
    override def copy (): Row = { clone ().asInstanceOf[Command] }
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
        implicit val clz: String = Command.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Command.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Command.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        emitattr (2, DiscreteValue)
        emitattr (3, ValueAliasSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Command rdf:ID=\"%s\">\n%s\t</cim:Command>".format (id, export_fields)
    }
}

object Command
extends
    Parseable[Command]
{
    val fields: Array[String] = Array[String] (
        "normalValue",
        "value",
        "DiscreteValue",
        "ValueAliasSet"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))
    val DiscreteValue: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Command =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Command (
            Control.parse (context),
            toInteger (mask (normalValue (), 0)),
            toInteger (mask (value (), 1)),
            mask (DiscreteValue (), 2),
            mask (ValueAliasSet (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DiscreteValue", "DiscreteValue", false),
        Relationship ("ValueAliasSet", "ValueAliasSet", false)
    )
}

/**
 * Control is used for supervisory/device control.
 *
 * It represents control outputs that are used to change the state in a process, e.g. close or open breaker, a set point value or a raise lower command.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param controlType Specifies the type of Control, e.g.
 *        BreakerOn/Off, GeneratorVoltageSetPoint, TieLineFlow etc. The ControlType.name shall be unique among all specified types and describe the type.
 * @param operationInProgress Indicates that a client is currently sending control commands that has not completed.
 * @param timeStamp The last time a control output was sent.
 * @param unitMultiplier The unit multiplier of the controlled quantity.
 * @param unitSymbol The unit of measure of the controlled quantity.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Regulating device governed by this control output.
 * @param RemoteControl [[ch.ninecode.model.RemoteControl RemoteControl]] The remote point controlling the physical actuator.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Control
(
    override val sup: IdentifiedObject,
    controlType: String,
    operationInProgress: Boolean,
    timeStamp: String,
    unitMultiplier: String,
    unitSymbol: String,
    PowerSystemResource: String,
    RemoteControl: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Control] }
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
        implicit val clz: String = Control.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Control.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Control.fields (position), value)
        emitelem (0, controlType)
        emitelem (1, operationInProgress)
        emitelem (2, timeStamp)
        emitattr (3, unitMultiplier)
        emitattr (4, unitSymbol)
        emitattr (5, PowerSystemResource)
        emitattr (6, RemoteControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Control rdf:ID=\"%s\">\n%s\t</cim:Control>".format (id, export_fields)
    }
}

object Control
extends
    Parseable[Control]
{
    val fields: Array[String] = Array[String] (
        "controlType",
        "operationInProgress",
        "timeStamp",
        "unitMultiplier",
        "unitSymbol",
        "PowerSystemResource",
        "RemoteControl"
    )
    val controlType: Fielder = parse_element (element (cls, fields(0)))
    val operationInProgress: Fielder = parse_element (element (cls, fields(1)))
    val timeStamp: Fielder = parse_element (element (cls, fields(2)))
    val unitMultiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RemoteControl: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): Control =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Control (
            IdentifiedObject.parse (context),
            mask (controlType (), 0),
            toBoolean (mask (operationInProgress (), 1)),
            mask (timeStamp (), 2),
            mask (unitMultiplier (), 3),
            mask (unitSymbol (), 4),
            mask (PowerSystemResource (), 5),
            mask (RemoteControl (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("PowerSystemResource", "PowerSystemResource", false),
        Relationship ("RemoteControl", "RemoteControl", false)
    )
}

/**
 * Discrete represents a discrete Measurement, i.e. a Measurement representing discrete values, e.g. a Breaker position.
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a MeasurementValue.value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Discrete
(
    override val sup: Measurement,
    maxValue: Int,
    minValue: Int,
    normalValue: Int,
    ValueAliasSet: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[Discrete] }
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
        implicit val clz: String = Discrete.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Discrete.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Discrete.fields (position), value)
        emitelem (0, maxValue)
        emitelem (1, minValue)
        emitelem (2, normalValue)
        emitattr (3, ValueAliasSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Discrete rdf:ID=\"%s\">\n%s\t</cim:Discrete>".format (id, export_fields)
    }
}

object Discrete
extends
    Parseable[Discrete]
{
    val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "normalValue",
        "ValueAliasSet"
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val normalValue: Fielder = parse_element (element (cls, fields(2)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Discrete =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Discrete (
            Measurement.parse (context),
            toInteger (mask (maxValue (), 0)),
            toInteger (mask (minValue (), 1)),
            toInteger (mask (normalValue (), 2)),
            mask (ValueAliasSet (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false)
    )
}

/**

 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class DiscreteCommand
(
    override val sup: Command
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
    def Command: Command = sup.asInstanceOf[Command]
    override def copy (): Row = { clone ().asInstanceOf[DiscreteCommand] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DiscreteCommand rdf:ID=\"%s\">\n%s\t</cim:DiscreteCommand>".format (id, export_fields)
    }
}

object DiscreteCommand
extends
    Parseable[DiscreteCommand]
{

    def parse (context: Context): DiscreteCommand =
    {
        implicit val ctx: Context = context
        val ret = DiscreteCommand (
            Command.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * DiscreteValue represents a discrete MeasurementValue.
 *
 * @param sup [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param Command [[ch.ninecode.model.Command Command]] The Control variable associated with the MeasurementValue.
 * @param Discrete [[ch.ninecode.model.Discrete Discrete]] Measurement to which this value is connected.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class DiscreteValue
(
    override val sup: MeasurementValue,
    value: Int,
    Command: String,
    Discrete: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[DiscreteValue] }
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
        implicit val clz: String = DiscreteValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscreteValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiscreteValue.fields (position), value)
        emitelem (0, value)
        emitattr (1, Command)
        emitattr (2, Discrete)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscreteValue rdf:ID=\"%s\">\n%s\t</cim:DiscreteValue>".format (id, export_fields)
    }
}

object DiscreteValue
extends
    Parseable[DiscreteValue]
{
    val fields: Array[String] = Array[String] (
        "value",
        "Command",
        "Discrete"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val Command: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Discrete: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): DiscreteValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscreteValue (
            MeasurementValue.parse (context),
            toInteger (mask (value (), 0)),
            mask (Command (), 1),
            mask (Discrete (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Command", "Command", false),
        Relationship ("Discrete", "Discrete", false)
    )
}

/**
 * Specifies one limit value for a Measurement.
 *
 * A Measurement typically has several limits that are kept together by the LimitSet class. The actual meaning and use of a Limit instance (i.e., if it is an alarm or warning limit or if it is a high or low limit) is not captured in the Limit class. However the name of a Limit instance may indicate both meaning and use.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] <em>undocumented</em>
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Limit
(
    override val sup: IdentifiedObject,
    Procedures: List[String]
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
    override def copy (): Row = { clone ().asInstanceOf[Limit] }
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
        implicit val clz: String = Limit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Limit.fields (position), x))
        emitattrs (0, Procedures)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Limit rdf:ID=\"%s\">\n%s\t</cim:Limit>".format (id, export_fields)
    }
}

object Limit
extends
    Parseable[Limit]
{
    val fields: Array[String] = Array[String] (
        "Procedures"
    )
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): Limit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Limit (
            IdentifiedObject.parse (context),
            masks (Procedures (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Procedures", "Procedure", true)
    )
}

/**
 * Specifies a set of Limits that are associated with a Measurement.
 *
 * A Measurement may have several LimitSets corresponding to seasonal or other changing conditions. The condition is captured in the name and description attributes. The same LimitSet may be used for several Measurements. In particular percentage limits are used this way.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isPercentageLimits Tells if the limit values are in percentage of normalValue or the specified Unit for Measurements and Controls.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class LimitSet
(
    override val sup: IdentifiedObject,
    isPercentageLimits: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LimitSet] }
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
        implicit val clz: String = LimitSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LimitSet.fields (position), value)
        emitelem (0, isPercentageLimits)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LimitSet rdf:ID=\"%s\">\n%s\t</cim:LimitSet>".format (id, export_fields)
    }
}

object LimitSet
extends
    Parseable[LimitSet]
{
    val fields: Array[String] = Array[String] (
        "isPercentageLimits"
    )
    val isPercentageLimits: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): LimitSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LimitSet (
            IdentifiedObject.parse (context),
            toBoolean (mask (isPercentageLimits (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A Measurement represents any measured, calculated or non-measured non-calculated quantity.
 *
 * Any piece of equipment may contain Measurements, e.g. a substation may have temperature measurements and door open indications, a transformer may have oil temperature and tank pressure measurements, a bay may contain a number of power flow measurements and a Breaker may contain a switch status measurement.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param measurementType Specifies the type of measurement.
 *        For example, this specifies if the measurement represents an indoor temperature, outdoor temperature, bus voltage, line flow, etc.
 * @param phases Indicates to which phases the measurement applies and avoids the need to use 'measurementType' to also encode phase information (which would explode the types).
 *        The phase information in Measurement, along with 'measurementType' and 'phases' uniquely defines a Measurement for a device, based on normal network phase. Their meaning will not change when the computed energizing phasing is changed due to jumpers or other reasons.
 * @param unitMultiplier The unit multiplier of the measured quantity.
 * @param unitSymbol The unit of measure of the measured quantity.
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource that contains the measurement.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] Measurements are specified in types of documents, such as procedures.
 * @param Terminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] One or more measurements may be associated with a terminal in the network.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Measurement
(
    override val sup: IdentifiedObject,
    measurementType: String,
    phases: String,
    unitMultiplier: String,
    unitSymbol: String,
    Asset: String,
    Locations: List[String],
    PowerSystemResource: String,
    Procedures: List[String],
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, List(), null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Measurement] }
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
        implicit val clz: String = Measurement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Measurement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Measurement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Measurement.fields (position), x))
        emitelem (0, measurementType)
        emitattr (1, phases)
        emitattr (2, unitMultiplier)
        emitattr (3, unitSymbol)
        emitattr (4, Asset)
        emitattrs (5, Locations)
        emitattr (6, PowerSystemResource)
        emitattrs (7, Procedures)
        emitattr (8, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Measurement rdf:ID=\"%s\">\n%s\t</cim:Measurement>".format (id, export_fields)
    }
}

object Measurement
extends
    Parseable[Measurement]
{
    val fields: Array[String] = Array[String] (
        "measurementType",
        "phases",
        "unitMultiplier",
        "unitSymbol",
        "Asset",
        "Locations",
        "PowerSystemResource",
        "Procedures",
        "Terminal"
    )
    val measurementType: Fielder = parse_element (element (cls, fields(0)))
    val phases: Fielder = parse_attribute (attribute (cls, fields(1)))
    val unitMultiplier: Fielder = parse_attribute (attribute (cls, fields(2)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): Measurement =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Measurement (
            IdentifiedObject.parse (context),
            mask (measurementType (), 0),
            mask (phases (), 1),
            mask (unitMultiplier (), 2),
            mask (unitSymbol (), 3),
            mask (Asset (), 4),
            masks (Locations (), 5),
            mask (PowerSystemResource (), 6),
            masks (Procedures (), 7),
            mask (Terminal (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false),
        Relationship ("Locations", "Location", true),
        Relationship ("PowerSystemResource", "PowerSystemResource", false),
        Relationship ("Procedures", "Procedure", true),
        Relationship ("Terminal", "ACDCTerminal", false)
    )
}

/**
 * The current state for a measurement.
 *
 * A state value is an instance of a measurement from a specific source. Measurements can be associated with many state values, each representing a different source for the measurement.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sensorAccuracy The limit, expressed as a percentage of the sensor maximum, that errors will not exceed when the sensor is used under  reference conditions.
 * @param timeStamp The time when the value was last updated
 * @param unknown [[ch.ninecode.model.ICCPIndicationPoint ICCPIndicationPoint]] <em>undocumented</em>
 * @param ErpPerson [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param MeasurementValueQuality [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] A MeasurementValue has a MeasurementValueQuality associated with it.
 * @param MeasurementValueSource [[ch.ninecode.model.MeasurementValueSource MeasurementValueSource]] A reference to the type of source that updates the MeasurementValue, e.g.
 *        SCADA, CCLink, manual, etc. User conventions for the names of sources are contained in the introduction to IEC 61970-301.
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param RemoteSource [[ch.ninecode.model.RemoteSource RemoteSource]] Link to the physical telemetered point associated with this measurement.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class MeasurementValue
(
    override val sup: IdentifiedObject,
    sensorAccuracy: Double,
    timeStamp: String,
    unknown: String,
    ErpPerson: String,
    MeasurementValueQuality: String,
    MeasurementValueSource: String,
    ProcedureDataSets: List[String],
    RemoteSource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValue] }
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
        implicit val clz: String = MeasurementValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MeasurementValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementValue.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MeasurementValue.fields (position), x))
        emitelem (0, sensorAccuracy)
        emitelem (1, timeStamp)
        emitattr (2, unknown)
        emitattr (3, ErpPerson)
        emitattr (4, MeasurementValueQuality)
        emitattr (5, MeasurementValueSource)
        emitattrs (6, ProcedureDataSets)
        emitattr (7, RemoteSource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementValue rdf:ID=\"%s\">\n%s\t</cim:MeasurementValue>".format (id, export_fields)
    }
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val fields: Array[String] = Array[String] (
        "sensorAccuracy",
        "timeStamp",
        "",
        "ErpPerson",
        "MeasurementValueQuality",
        "MeasurementValueSource",
        "ProcedureDataSets",
        "RemoteSource"
    )
    val sensorAccuracy: Fielder = parse_element (element (cls, fields(0)))
    val timeStamp: Fielder = parse_element (element (cls, fields(1)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MeasurementValueQuality: Fielder = parse_attribute (attribute (cls, fields(4)))
    val MeasurementValueSource: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val RemoteSource: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): MeasurementValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MeasurementValue (
            IdentifiedObject.parse (context),
            toDouble (mask (sensorAccuracy (), 0)),
            mask (timeStamp (), 1),
            mask (unknown (), 2),
            mask (ErpPerson (), 3),
            mask (MeasurementValueQuality (), 4),
            mask (MeasurementValueSource (), 5),
            masks (ProcedureDataSets (), 6),
            mask (RemoteSource (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "ICCPIndicationPoint", false),
        Relationship ("ErpPerson", "OldPerson", false),
        Relationship ("MeasurementValueQuality", "MeasurementValueQuality", false),
        Relationship ("MeasurementValueSource", "MeasurementValueSource", false),
        Relationship ("ProcedureDataSets", "ProcedureDataSet", true),
        Relationship ("RemoteSource", "RemoteSource", false)
    )
}

/**
 * Measurement quality flags.
 *
 * Bits 0-10 are defined for substation automation in draft IEC 61850 part 7-3. Bits 11-15 are reserved for future expansion by that document. Bits 16-31 are reserved for EMS applications.
 *
 * @param sup [[ch.ninecode.model.Quality61850 Quality61850]] Reference to the superclass object.
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] A MeasurementValue has a MeasurementValueQuality associated with it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class MeasurementValueQuality
(
    override val sup: Quality61850,
    MeasurementValue: String
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
    def Quality61850: Quality61850 = sup.asInstanceOf[Quality61850]
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValueQuality] }
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
        implicit val clz: String = MeasurementValueQuality.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementValueQuality.fields (position), value)
        emitattr (0, MeasurementValue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueQuality rdf:ID=\"%s\">\n%s\t</cim:MeasurementValueQuality>".format (id, export_fields)
    }
}

object MeasurementValueQuality
extends
    Parseable[MeasurementValueQuality]
{
    val fields: Array[String] = Array[String] (
        "MeasurementValue"
    )
    val MeasurementValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): MeasurementValueQuality =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MeasurementValueQuality (
            Quality61850.parse (context),
            mask (MeasurementValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MeasurementValue", "MeasurementValue", false)
    )
}

/**
 * MeasurementValueSource describes the alternative sources updating a MeasurementValue.
 *
 * User conventions for how to use the MeasurementValueSource attributes are described in the introduction to IEC 61970-301.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class MeasurementValueSource
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
    override def copy (): Row = { clone ().asInstanceOf[MeasurementValueSource] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueSource rdf:ID=\"%s\">\n%s\t</cim:MeasurementValueSource>".format (id, export_fields)
    }
}

object MeasurementValueSource
extends
    Parseable[MeasurementValueSource]
{

    def parse (context: Context): MeasurementValueSource =
    {
        implicit val ctx: Context = context
        val ret = MeasurementValueSource (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Quality flags in this class are as defined in IEC 61850, except for estimatorReplaced, which has been included in this class for convenience.
 *
 * @param sup Reference to the superclass object.
 * @param badReference Measurement value may be incorrect due to a reference being out of calibration.
 * @param estimatorReplaced Value has been replaced by State Estimator. estimatorReplaced is not an IEC61850 quality bit but has been put in this class for convenience.
 * @param failure This identifier indicates that a supervision function has detected an internal or external failure, e.g. communication failure.
 * @param oldData Measurement value is old and possibly invalid, as it has not been successfully updated during a specified time interval.
 * @param operatorBlocked Measurement value is blocked and hence unavailable for transmission.
 * @param oscillatory To prevent some overload of the communication it is sensible to detect and suppress oscillating (fast changing) binary inputs.
 *        If a signal changes in a defined time (tosc) twice in the same direction (from 0 to 1 or from 1 to 0) then oscillation is detected and the detail quality identifier "oscillatory" is set. If it is detected a configured numbers of transient changes could be passed by. In this time the validity status "questionable" is set. If after this defined numbers of changes the signal is still in the oscillating state the value shall be set either to the opposite state of the previous stable value or to a defined default value. In this case the validity status "questionable" is reset and "invalid" is set as long as the signal is oscillating. If it is configured such that no transient changes should be passed by then the validity status "invalid" is set immediately in addition to the detail quality identifier "oscillatory" (used for status information only).
 * @param outOfRange Measurement value is beyond a predefined range of value.
 * @param overFlow Measurement value is beyond the capability of being  represented properly.
 *        For example, a counter value overflows from maximum count back to a value of zero.
 * @param source Source gives information related to the origin of a value.
 *        The value may be acquired from the process, defaulted or substituted.
 * @param suspect A correlation function has detected that the value is not consitent with other values.
 *        Typically set by a network State Estimator.
 * @param test Measurement value is transmitted for test purposes.
 * @param validity Validity of the measurement value.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Quality61850
(
    override val sup: BasicElement,
    badReference: Boolean,
    estimatorReplaced: Boolean,
    failure: Boolean,
    oldData: Boolean,
    operatorBlocked: Boolean,
    oscillatory: Boolean,
    outOfRange: Boolean,
    overFlow: Boolean,
    source: String,
    suspect: Boolean,
    test: Boolean,
    validity: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, false, false, false, false, false, false, null, false, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Quality61850] }
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
        implicit val clz: String = Quality61850.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Quality61850.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Quality61850.fields (position), value)
        emitelem (0, badReference)
        emitelem (1, estimatorReplaced)
        emitelem (2, failure)
        emitelem (3, oldData)
        emitelem (4, operatorBlocked)
        emitelem (5, oscillatory)
        emitelem (6, outOfRange)
        emitelem (7, overFlow)
        emitattr (8, source)
        emitelem (9, suspect)
        emitelem (10, test)
        emitattr (11, validity)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Quality61850 rdf:ID=\"%s\">\n%s\t</cim:Quality61850>".format (id, export_fields)
    }
}

object Quality61850
extends
    Parseable[Quality61850]
{
    val fields: Array[String] = Array[String] (
        "badReference",
        "estimatorReplaced",
        "failure",
        "oldData",
        "operatorBlocked",
        "oscillatory",
        "outOfRange",
        "overFlow",
        "source",
        "suspect",
        "test",
        "validity"
    )
    val badReference: Fielder = parse_element (element (cls, fields(0)))
    val estimatorReplaced: Fielder = parse_element (element (cls, fields(1)))
    val failure: Fielder = parse_element (element (cls, fields(2)))
    val oldData: Fielder = parse_element (element (cls, fields(3)))
    val operatorBlocked: Fielder = parse_element (element (cls, fields(4)))
    val oscillatory: Fielder = parse_element (element (cls, fields(5)))
    val outOfRange: Fielder = parse_element (element (cls, fields(6)))
    val overFlow: Fielder = parse_element (element (cls, fields(7)))
    val source: Fielder = parse_attribute (attribute (cls, fields(8)))
    val suspect: Fielder = parse_element (element (cls, fields(9)))
    val test: Fielder = parse_element (element (cls, fields(10)))
    val validity: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): Quality61850 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Quality61850 (
            BasicElement.parse (context),
            toBoolean (mask (badReference (), 0)),
            toBoolean (mask (estimatorReplaced (), 1)),
            toBoolean (mask (failure (), 2)),
            toBoolean (mask (oldData (), 3)),
            toBoolean (mask (operatorBlocked (), 4)),
            toBoolean (mask (oscillatory (), 5)),
            toBoolean (mask (outOfRange (), 6)),
            toBoolean (mask (overFlow (), 7)),
            mask (source (), 8),
            toBoolean (mask (suspect (), 9)),
            toBoolean (mask (test (), 10)),
            mask (validity (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An analog control that increase or decrease a set point value with pulses.
 *
 * @param sup [[ch.ninecode.model.AnalogControl AnalogControl]] Reference to the superclass object.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a Control value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class RaiseLowerCommand
(
    override val sup: AnalogControl,
    ValueAliasSet: String
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
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { clone ().asInstanceOf[RaiseLowerCommand] }
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
        implicit val clz: String = RaiseLowerCommand.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RaiseLowerCommand.fields (position), value)
        emitattr (0, ValueAliasSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RaiseLowerCommand rdf:ID=\"%s\">\n%s\t</cim:RaiseLowerCommand>".format (id, export_fields)
    }
}

object RaiseLowerCommand
extends
    Parseable[RaiseLowerCommand]
{
    val fields: Array[String] = Array[String] (
        "ValueAliasSet"
    )
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): RaiseLowerCommand =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = RaiseLowerCommand (
            AnalogControl.parse (context),
            mask (ValueAliasSet (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false)
    )
}

/**
 * An analog control that issue a set point value.
 *
 * @param sup [[ch.ninecode.model.AnalogControl AnalogControl]] Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class SetPoint
(
    override val sup: AnalogControl,
    normalValue: Double,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AnalogControl: AnalogControl = sup.asInstanceOf[AnalogControl]
    override def copy (): Row = { clone ().asInstanceOf[SetPoint] }
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
        implicit val clz: String = SetPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SetPoint.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SetPoint rdf:ID=\"%s\">\n%s\t</cim:SetPoint>".format (id, export_fields)
    }
}

object SetPoint
extends
    Parseable[SetPoint]
{
    val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): SetPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SetPoint (
            AnalogControl.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * StringMeasurement represents a measurement with values of type string.
 *
 * @param sup [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class StringMeasurement
(
    override val sup: Measurement
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
    def Measurement: Measurement = sup.asInstanceOf[Measurement]
    override def copy (): Row = { clone ().asInstanceOf[StringMeasurement] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:StringMeasurement rdf:ID=\"%s\">\n%s\t</cim:StringMeasurement>".format (id, export_fields)
    }
}

object StringMeasurement
extends
    Parseable[StringMeasurement]
{

    def parse (context: Context): StringMeasurement =
    {
        implicit val ctx: Context = context
        val ret = StringMeasurement (
            Measurement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * StringMeasurementValue represents a measurement value of type string.
 *
 * @param sup [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param StringMeasurement [[ch.ninecode.model.StringMeasurement StringMeasurement]] Measurement to which this value is connected.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class StringMeasurementValue
(
    override val sup: MeasurementValue,
    value: String,
    StringMeasurement: String
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
    def MeasurementValue: MeasurementValue = sup.asInstanceOf[MeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[StringMeasurementValue] }
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
        implicit val clz: String = StringMeasurementValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StringMeasurementValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StringMeasurementValue.fields (position), value)
        emitelem (0, value)
        emitattr (1, StringMeasurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StringMeasurementValue rdf:ID=\"%s\">\n%s\t</cim:StringMeasurementValue>".format (id, export_fields)
    }
}

object StringMeasurementValue
extends
    Parseable[StringMeasurementValue]
{
    val fields: Array[String] = Array[String] (
        "value",
        "StringMeasurement"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val StringMeasurement: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): StringMeasurementValue =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = StringMeasurementValue (
            MeasurementValue.parse (context),
            mask (value (), 0),
            mask (StringMeasurement (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("StringMeasurement", "StringMeasurement", false)
    )
}

/**
 * Describes the translation of a set of values into a name and is intendend to facilitate cusom translations.
 *
 * Each ValueAliasSet has a name, description etc. A specific Measurement may represent a discrete state like Open, Closed, Intermediate etc. This requires a translation from the MeasurementValue.value number to a string, e.g. 0-&gt;"Invalid", 1-&gt;"Open", 2-&gt;"Closed", 3-&gt;"Intermediate". Each ValueToAlias member in ValueAliasSet.Value describe a mapping for one particular value to a name.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class ValueAliasSet
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
    override def copy (): Row = { clone ().asInstanceOf[ValueAliasSet] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ValueAliasSet rdf:ID=\"%s\">\n%s\t</cim:ValueAliasSet>".format (id, export_fields)
    }
}

object ValueAliasSet
extends
    Parseable[ValueAliasSet]
{

    def parse (context: Context): ValueAliasSet =
    {
        implicit val ctx: Context = context
        val ret = ValueAliasSet (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Describes the translation of one particular value into a name, e.g. 1 as "Open".
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param value The value that is mapped.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet having the ValueToAlias mappings.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class ValueToAlias
(
    override val sup: IdentifiedObject,
    value: Int,
    ValueAliasSet: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ValueToAlias] }
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
        implicit val clz: String = ValueToAlias.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ValueToAlias.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ValueToAlias.fields (position), value)
        emitelem (0, value)
        emitattr (1, ValueAliasSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ValueToAlias rdf:ID=\"%s\">\n%s\t</cim:ValueToAlias>".format (id, export_fields)
    }
}

object ValueToAlias
extends
    Parseable[ValueToAlias]
{
    val fields: Array[String] = Array[String] (
        "value",
        "ValueAliasSet"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ValueToAlias =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ValueToAlias (
            IdentifiedObject.parse (context),
            toInteger (mask (value (), 0)),
            mask (ValueAliasSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false)
    )
}

private[ninecode] object _Meas
{
    def register: List[ClassInfo] =
    {
        List (
            Accumulator.register,
            AccumulatorLimit.register,
            AccumulatorLimitSet.register,
            AccumulatorReset.register,
            AccumulatorValue.register,
            Analog.register,
            AnalogControl.register,
            AnalogLimit.register,
            AnalogLimitSet.register,
            AnalogValue.register,
            Command.register,
            Control.register,
            Discrete.register,
            DiscreteCommand.register,
            DiscreteValue.register,
            Limit.register,
            LimitSet.register,
            Measurement.register,
            MeasurementValue.register,
            MeasurementValueQuality.register,
            MeasurementValueSource.register,
            Quality61850.register,
            RaiseLowerCommand.register,
            SetPoint.register,
            StringMeasurement.register,
            StringMeasurementValue.register,
            ValueAliasSet.register,
            ValueToAlias.register
        )
    }
}