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
        sup.export_fields +
        "\t\t<cim:Accumulator.maxValue>" + maxValue + "</cim:Accumulator.maxValue>\n" +
        (if (null != LimitSets) LimitSets.map (x => "\t\t<cim:Accumulator.LimitSets rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Accumulator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Accumulator>"
    }
}

object Accumulator
extends
    Parseable[Accumulator]
{
    val maxValue = parse_element (element ("""Accumulator.maxValue"""))
    val LimitSets = parse_attributes (attribute ("""Accumulator.LimitSets"""))
    def parse (context: Context): Accumulator =
    {
        Accumulator(
            Measurement.parse (context),
            toInteger (maxValue (context), context),
            LimitSets (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSets", "AccumulatorLimitSet", true))
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
        sup.export_fields +
        "\t\t<cim:AccumulatorLimit.value>" + value + "</cim:AccumulatorLimit.value>\n" +
        (if (null != LimitSet) "\t\t<cim:AccumulatorLimit.LimitSet rdf:resource=\"#" + LimitSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorLimit>"
    }
}

object AccumulatorLimit
extends
    Parseable[AccumulatorLimit]
{
    val value = parse_element (element ("""AccumulatorLimit.value"""))
    val LimitSet = parse_attribute (attribute ("""AccumulatorLimit.LimitSet"""))
    def parse (context: Context): AccumulatorLimit =
    {
        AccumulatorLimit(
            Limit.parse (context),
            toInteger (value (context), context),
            LimitSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSet", "AccumulatorLimitSet", false))
}

/**
 * An AccumulatorLimitSet specifies a set of Limits that are associated with an Accumulator measurement.
 *
 * @param sup [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AccumulatorLimitSet
(
    override val sup: LimitSet
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorLimitSet>"
    }
}

object AccumulatorLimitSet
extends
    Parseable[AccumulatorLimitSet]
{
    def parse (context: Context): AccumulatorLimitSet =
    {
        AccumulatorLimitSet(
            LimitSet.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != AccumulatorValue) "\t\t<cim:AccumulatorReset.AccumulatorValue rdf:resource=\"#" + AccumulatorValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorReset rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorReset>"
    }
}

object AccumulatorReset
extends
    Parseable[AccumulatorReset]
{
    val AccumulatorValue = parse_attribute (attribute ("""AccumulatorReset.AccumulatorValue"""))
    def parse (context: Context): AccumulatorReset =
    {
        AccumulatorReset(
            Control.parse (context),
            AccumulatorValue (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AccumulatorValue", "AccumulatorValue", false))
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
        sup.export_fields +
        "\t\t<cim:AccumulatorValue.value>" + value + "</cim:AccumulatorValue.value>\n" +
        (if (null != Accumulator) "\t\t<cim:AccumulatorValue.Accumulator rdf:resource=\"#" + Accumulator + "\"/>\n" else "") +
        (if (null != AccumulatorReset) "\t\t<cim:AccumulatorValue.AccumulatorReset rdf:resource=\"#" + AccumulatorReset + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AccumulatorValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AccumulatorValue>"
    }
}

object AccumulatorValue
extends
    Parseable[AccumulatorValue]
{
    val value = parse_element (element ("""AccumulatorValue.value"""))
    val Accumulator = parse_attribute (attribute ("""AccumulatorValue.Accumulator"""))
    val AccumulatorReset = parse_attribute (attribute ("""AccumulatorValue.AccumulatorReset"""))
    def parse (context: Context): AccumulatorValue =
    {
        AccumulatorValue(
            MeasurementValue.parse (context),
            toInteger (value (context), context),
            Accumulator (context),
            AccumulatorReset (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Accumulator", "Accumulator", false),
        Relationship ("AccumulatorReset", "AccumulatorReset", false))
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
        sup.export_fields +
        "\t\t<cim:Analog.maxValue>" + maxValue + "</cim:Analog.maxValue>\n" +
        "\t\t<cim:Analog.minValue>" + minValue + "</cim:Analog.minValue>\n" +
        "\t\t<cim:Analog.normalValue>" + normalValue + "</cim:Analog.normalValue>\n" +
        "\t\t<cim:Analog.positiveFlowIn>" + positiveFlowIn + "</cim:Analog.positiveFlowIn>\n" +
        (if (null != LimitSets) LimitSets.map (x => "\t\t<cim:Analog.LimitSets rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Analog rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Analog>"
    }
}

object Analog
extends
    Parseable[Analog]
{
    val maxValue = parse_element (element ("""Analog.maxValue"""))
    val minValue = parse_element (element ("""Analog.minValue"""))
    val normalValue = parse_element (element ("""Analog.normalValue"""))
    val positiveFlowIn = parse_element (element ("""Analog.positiveFlowIn"""))
    val LimitSets = parse_attributes (attribute ("""Analog.LimitSets"""))
    def parse (context: Context): Analog =
    {
        Analog(
            Measurement.parse (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            toDouble (normalValue (context), context),
            toBoolean (positiveFlowIn (context), context),
            LimitSets (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSets", "AnalogLimitSet", true))
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
        sup.export_fields +
        "\t\t<cim:AnalogControl.maxValue>" + maxValue + "</cim:AnalogControl.maxValue>\n" +
        "\t\t<cim:AnalogControl.minValue>" + minValue + "</cim:AnalogControl.minValue>\n" +
        (if (null != AnalogValue) "\t\t<cim:AnalogControl.AnalogValue rdf:resource=\"#" + AnalogValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogControl rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogControl>"
    }
}

object AnalogControl
extends
    Parseable[AnalogControl]
{
    val maxValue = parse_element (element ("""AnalogControl.maxValue"""))
    val minValue = parse_element (element ("""AnalogControl.minValue"""))
    val AnalogValue = parse_attribute (attribute ("""AnalogControl.AnalogValue"""))
    def parse (context: Context): AnalogControl =
    {
        AnalogControl(
            Control.parse (context),
            toDouble (maxValue (context), context),
            toDouble (minValue (context), context),
            AnalogValue (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("AnalogValue", "AnalogValue", false))
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
        sup.export_fields +
        "\t\t<cim:AnalogLimit.value>" + value + "</cim:AnalogLimit.value>\n" +
        (if (null != LimitSet) "\t\t<cim:AnalogLimit.LimitSet rdf:resource=\"#" + LimitSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogLimit>"
    }
}

object AnalogLimit
extends
    Parseable[AnalogLimit]
{
    val value = parse_element (element ("""AnalogLimit.value"""))
    val LimitSet = parse_attribute (attribute ("""AnalogLimit.LimitSet"""))
    def parse (context: Context): AnalogLimit =
    {
        AnalogLimit(
            Limit.parse (context),
            toDouble (value (context), context),
            LimitSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitSet", "AnalogLimitSet", false))
}

/**
 * An AnalogLimitSet specifies a set of Limits that are associated with an Analog measurement.
 *
 * @param sup [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class AnalogLimitSet
(
    override val sup: LimitSet
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:AnalogLimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogLimitSet>"
    }
}

object AnalogLimitSet
extends
    Parseable[AnalogLimitSet]
{
    def parse (context: Context): AnalogLimitSet =
    {
        AnalogLimitSet(
            LimitSet.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        "\t\t<cim:AnalogValue.value>" + value + "</cim:AnalogValue.value>\n" +
        (if (null != Analog) "\t\t<cim:AnalogValue.Analog rdf:resource=\"#" + Analog + "\"/>\n" else "") +
        (if (null != AnalogControl) "\t\t<cim:AnalogValue.AnalogControl rdf:resource=\"#" + AnalogControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogValue>"
    }
}

object AnalogValue
extends
    Parseable[AnalogValue]
{
    val value = parse_element (element ("""AnalogValue.value"""))
    val Analog = parse_attribute (attribute ("""AnalogValue.Analog"""))
    val AnalogControl = parse_attribute (attribute ("""AnalogValue.AnalogControl"""))
    def parse (context: Context): AnalogValue =
    {
        AnalogValue(
            MeasurementValue.parse (context),
            toDouble (value (context), context),
            Analog (context),
            AnalogControl (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Analog", "Analog", false),
        Relationship ("AnalogControl", "AnalogControl", false))
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
        sup.export_fields +
        "\t\t<cim:Command.normalValue>" + normalValue + "</cim:Command.normalValue>\n" +
        "\t\t<cim:Command.value>" + value + "</cim:Command.value>\n" +
        (if (null != DiscreteValue) "\t\t<cim:Command.DiscreteValue rdf:resource=\"#" + DiscreteValue + "\"/>\n" else "") +
        (if (null != ValueAliasSet) "\t\t<cim:Command.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Command rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Command>"
    }
}

object Command
extends
    Parseable[Command]
{
    val normalValue = parse_element (element ("""Command.normalValue"""))
    val value = parse_element (element ("""Command.value"""))
    val DiscreteValue = parse_attribute (attribute ("""Command.DiscreteValue"""))
    val ValueAliasSet = parse_attribute (attribute ("""Command.ValueAliasSet"""))
    def parse (context: Context): Command =
    {
        Command(
            Control.parse (context),
            toInteger (normalValue (context), context),
            toInteger (value (context), context),
            DiscreteValue (context),
            ValueAliasSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("DiscreteValue", "DiscreteValue", false),
        Relationship ("ValueAliasSet", "ValueAliasSet", false))
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
        sup.export_fields +
        (if (null != controlType) "\t\t<cim:Control.controlType>" + controlType + "</cim:Control.controlType>\n" else "") +
        "\t\t<cim:Control.operationInProgress>" + operationInProgress + "</cim:Control.operationInProgress>\n" +
        (if (null != timeStamp) "\t\t<cim:Control.timeStamp>" + timeStamp + "</cim:Control.timeStamp>\n" else "") +
        (if (null != unitMultiplier) "\t\t<cim:Control.unitMultiplier rdf:resource=\"#" + unitMultiplier + "\"/>\n" else "") +
        (if (null != unitSymbol) "\t\t<cim:Control.unitSymbol rdf:resource=\"#" + unitSymbol + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:Control.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "") +
        (if (null != RemoteControl) "\t\t<cim:Control.RemoteControl rdf:resource=\"#" + RemoteControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Control rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Control>"
    }
}

object Control
extends
    Parseable[Control]
{
    val controlType = parse_element (element ("""Control.controlType"""))
    val operationInProgress = parse_element (element ("""Control.operationInProgress"""))
    val timeStamp = parse_element (element ("""Control.timeStamp"""))
    val unitMultiplier = parse_attribute (attribute ("""Control.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""Control.unitSymbol"""))
    val PowerSystemResource = parse_attribute (attribute ("""Control.PowerSystemResource"""))
    val RemoteControl = parse_attribute (attribute ("""Control.RemoteControl"""))
    def parse (context: Context): Control =
    {
        Control(
            IdentifiedObject.parse (context),
            controlType (context),
            toBoolean (operationInProgress (context), context),
            timeStamp (context),
            unitMultiplier (context),
            unitSymbol (context),
            PowerSystemResource (context),
            RemoteControl (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("PowerSystemResource", "PowerSystemResource", false),
        Relationship ("RemoteControl", "RemoteControl", false))
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
        sup.export_fields +
        "\t\t<cim:Discrete.maxValue>" + maxValue + "</cim:Discrete.maxValue>\n" +
        "\t\t<cim:Discrete.minValue>" + minValue + "</cim:Discrete.minValue>\n" +
        "\t\t<cim:Discrete.normalValue>" + normalValue + "</cim:Discrete.normalValue>\n" +
        (if (null != ValueAliasSet) "\t\t<cim:Discrete.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Discrete rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Discrete>"
    }
}

object Discrete
extends
    Parseable[Discrete]
{
    val maxValue = parse_element (element ("""Discrete.maxValue"""))
    val minValue = parse_element (element ("""Discrete.minValue"""))
    val normalValue = parse_element (element ("""Discrete.normalValue"""))
    val ValueAliasSet = parse_attribute (attribute ("""Discrete.ValueAliasSet"""))
    def parse (context: Context): Discrete =
    {
        Discrete(
            Measurement.parse (context),
            toInteger (maxValue (context), context),
            toInteger (minValue (context), context),
            toInteger (normalValue (context), context),
            ValueAliasSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:DiscreteCommand rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscreteCommand>"
    }
}

object DiscreteCommand
extends
    Parseable[DiscreteCommand]
{
    def parse (context: Context): DiscreteCommand =
    {
        DiscreteCommand(
            Command.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        "\t\t<cim:DiscreteValue.value>" + value + "</cim:DiscreteValue.value>\n" +
        (if (null != Command) "\t\t<cim:DiscreteValue.Command rdf:resource=\"#" + Command + "\"/>\n" else "") +
        (if (null != Discrete) "\t\t<cim:DiscreteValue.Discrete rdf:resource=\"#" + Discrete + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiscreteValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscreteValue>"
    }
}

object DiscreteValue
extends
    Parseable[DiscreteValue]
{
    val value = parse_element (element ("""DiscreteValue.value"""))
    val Command = parse_attribute (attribute ("""DiscreteValue.Command"""))
    val Discrete = parse_attribute (attribute ("""DiscreteValue.Discrete"""))
    def parse (context: Context): DiscreteValue =
    {
        DiscreteValue(
            MeasurementValue.parse (context),
            toInteger (value (context), context),
            Command (context),
            Discrete (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Command", "Command", false),
        Relationship ("Discrete", "Discrete", false))
}

/**
 * Specifies one limit value for a Measurement.
 *
 * A Measurement typically has several limits that are kept together by the LimitSet class. The actual meaning and use of a Limit instance (i.e., if it is an alarm or warning limit or if it is a high or low limit) is not captured in the Limit class. However the name of a Limit instance may indicate both meaning and use.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class Limit
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:Limit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Limit>"
    }
}

object Limit
extends
    Parseable[Limit]
{
    def parse (context: Context): Limit =
    {
        Limit(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        "\t\t<cim:LimitSet.isPercentageLimits>" + isPercentageLimits + "</cim:LimitSet.isPercentageLimits>\n"
    }
    override def export: String =
    {
        "\t<cim:LimitSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LimitSet>"
    }
}

object LimitSet
extends
    Parseable[LimitSet]
{
    val isPercentageLimits = parse_element (element ("""LimitSet.isPercentageLimits"""))
    def parse (context: Context): LimitSet =
    {
        LimitSet(
            IdentifiedObject.parse (context),
            toBoolean (isPercentageLimits (context), context)
        )
    }
    val relations: List[Relationship] = List ()
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
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource that contains the measurement.
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
    PowerSystemResource: String,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null) }
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
        sup.export_fields +
        (if (null != measurementType) "\t\t<cim:Measurement.measurementType>" + measurementType + "</cim:Measurement.measurementType>\n" else "") +
        (if (null != phases) "\t\t<cim:Measurement.phases rdf:resource=\"#" + phases + "\"/>\n" else "") +
        (if (null != unitMultiplier) "\t\t<cim:Measurement.unitMultiplier rdf:resource=\"#" + unitMultiplier + "\"/>\n" else "") +
        (if (null != unitSymbol) "\t\t<cim:Measurement.unitSymbol rdf:resource=\"#" + unitSymbol + "\"/>\n" else "") +
        (if (null != Asset) "\t\t<cim:Measurement.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:Measurement.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "") +
        (if (null != Terminal) "\t\t<cim:Measurement.Terminal rdf:resource=\"#" + Terminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Measurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Measurement>"
    }
}

object Measurement
extends
    Parseable[Measurement]
{
    val measurementType = parse_element (element ("""Measurement.measurementType"""))
    val phases = parse_attribute (attribute ("""Measurement.phases"""))
    val unitMultiplier = parse_attribute (attribute ("""Measurement.unitMultiplier"""))
    val unitSymbol = parse_attribute (attribute ("""Measurement.unitSymbol"""))
    val Asset = parse_attribute (attribute ("""Measurement.Asset"""))
    val PowerSystemResource = parse_attribute (attribute ("""Measurement.PowerSystemResource"""))
    val Terminal = parse_attribute (attribute ("""Measurement.Terminal"""))
    def parse (context: Context): Measurement =
    {
        Measurement(
            IdentifiedObject.parse (context),
            measurementType (context),
            phases (context),
            unitMultiplier (context),
            unitSymbol (context),
            Asset (context),
            PowerSystemResource (context),
            Terminal (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", false),
        Relationship ("PowerSystemResource", "PowerSystemResource", false),
        Relationship ("Terminal", "ACDCTerminal", false))
}

/**
 * The current state for a measurement.
 *
 * A state value is an instance of a measurement from a specific source. Measurements can be associated with many state values, each representing a different source for the measurement.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param attr [[ch.ninecode.model.ICCPIndicationPoint ICCPIndicationPoint]] <em>undocumented</em>
 * @param sensorAccuracy The limit, expressed as a percentage of the sensor maximum, that errors will not exceed when the sensor is used under  reference conditions.
 * @param timeStamp The time when the value was last updated
 * @param ErpPerson [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param MeasurementValueQuality [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] A MeasurementValue has a MeasurementValueQuality associated with it.
 * @param MeasurementValueSource [[ch.ninecode.model.MeasurementValueSource MeasurementValueSource]] A reference to the type of source that updates the MeasurementValue, e.g.
 *        SCADA, CCLink, manual, etc. User conventions for the names of sources are contained in the introduction to IEC 61970-301.
 * @param RemoteSource [[ch.ninecode.model.RemoteSource RemoteSource]] Link to the physical telemetered point associated with this measurement.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
case class MeasurementValue
(
    override val sup: IdentifiedObject,
    attr: String,
    sensorAccuracy: Double,
    timeStamp: String,
    ErpPerson: String,
    MeasurementValueQuality: String,
    MeasurementValueSource: String,
    RemoteSource: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null, null) }
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
        sup.export_fields +
        (if (null != attr) "\t\t<cim:MeasurementValue. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        "\t\t<cim:MeasurementValue.sensorAccuracy>" + sensorAccuracy + "</cim:MeasurementValue.sensorAccuracy>\n" +
        (if (null != timeStamp) "\t\t<cim:MeasurementValue.timeStamp>" + timeStamp + "</cim:MeasurementValue.timeStamp>\n" else "") +
        (if (null != ErpPerson) "\t\t<cim:MeasurementValue.ErpPerson rdf:resource=\"#" + ErpPerson + "\"/>\n" else "") +
        (if (null != MeasurementValueQuality) "\t\t<cim:MeasurementValue.MeasurementValueQuality rdf:resource=\"#" + MeasurementValueQuality + "\"/>\n" else "") +
        (if (null != MeasurementValueSource) "\t\t<cim:MeasurementValue.MeasurementValueSource rdf:resource=\"#" + MeasurementValueSource + "\"/>\n" else "") +
        (if (null != RemoteSource) "\t\t<cim:MeasurementValue.RemoteSource rdf:resource=\"#" + RemoteSource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValue>"
    }
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val attr = parse_attribute (attribute ("""MeasurementValue."""))
    val sensorAccuracy = parse_element (element ("""MeasurementValue.sensorAccuracy"""))
    val timeStamp = parse_element (element ("""MeasurementValue.timeStamp"""))
    val ErpPerson = parse_attribute (attribute ("""MeasurementValue.ErpPerson"""))
    val MeasurementValueQuality = parse_attribute (attribute ("""MeasurementValue.MeasurementValueQuality"""))
    val MeasurementValueSource = parse_attribute (attribute ("""MeasurementValue.MeasurementValueSource"""))
    val RemoteSource = parse_attribute (attribute ("""MeasurementValue.RemoteSource"""))
    def parse (context: Context): MeasurementValue =
    {
        MeasurementValue(
            IdentifiedObject.parse (context),
            attr (context),
            toDouble (sensorAccuracy (context), context),
            timeStamp (context),
            ErpPerson (context),
            MeasurementValueQuality (context),
            MeasurementValueSource (context),
            RemoteSource (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ErpPerson", "OldPerson", false),
        Relationship ("MeasurementValueQuality", "MeasurementValueQuality", false),
        Relationship ("MeasurementValueSource", "MeasurementValueSource", false),
        Relationship ("RemoteSource", "RemoteSource", false),
        Relationship ("attr", "ICCPIndicationPoint", false))
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
        sup.export_fields +
        (if (null != MeasurementValue) "\t\t<cim:MeasurementValueQuality.MeasurementValue rdf:resource=\"#" + MeasurementValue + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueQuality rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValueQuality>"
    }
}

object MeasurementValueQuality
extends
    Parseable[MeasurementValueQuality]
{
    val MeasurementValue = parse_attribute (attribute ("""MeasurementValueQuality.MeasurementValue"""))
    def parse (context: Context): MeasurementValueQuality =
    {
        MeasurementValueQuality(
            Quality61850.parse (context),
            MeasurementValue (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("MeasurementValue", "MeasurementValue", false))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MeasurementValueSource>"
    }
}

object MeasurementValueSource
extends
    Parseable[MeasurementValueSource]
{
    def parse (context: Context): MeasurementValueSource =
    {
        MeasurementValueSource(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        "\t\t<cim:Quality61850.badReference>" + badReference + "</cim:Quality61850.badReference>\n" +
        "\t\t<cim:Quality61850.estimatorReplaced>" + estimatorReplaced + "</cim:Quality61850.estimatorReplaced>\n" +
        "\t\t<cim:Quality61850.failure>" + failure + "</cim:Quality61850.failure>\n" +
        "\t\t<cim:Quality61850.oldData>" + oldData + "</cim:Quality61850.oldData>\n" +
        "\t\t<cim:Quality61850.operatorBlocked>" + operatorBlocked + "</cim:Quality61850.operatorBlocked>\n" +
        "\t\t<cim:Quality61850.oscillatory>" + oscillatory + "</cim:Quality61850.oscillatory>\n" +
        "\t\t<cim:Quality61850.outOfRange>" + outOfRange + "</cim:Quality61850.outOfRange>\n" +
        "\t\t<cim:Quality61850.overFlow>" + overFlow + "</cim:Quality61850.overFlow>\n" +
        (if (null != source) "\t\t<cim:Quality61850.source rdf:resource=\"#" + source + "\"/>\n" else "") +
        "\t\t<cim:Quality61850.suspect>" + suspect + "</cim:Quality61850.suspect>\n" +
        "\t\t<cim:Quality61850.test>" + test + "</cim:Quality61850.test>\n" +
        (if (null != validity) "\t\t<cim:Quality61850.validity rdf:resource=\"#" + validity + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Quality61850 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Quality61850>"
    }
}

object Quality61850
extends
    Parseable[Quality61850]
{
    val badReference = parse_element (element ("""Quality61850.badReference"""))
    val estimatorReplaced = parse_element (element ("""Quality61850.estimatorReplaced"""))
    val failure = parse_element (element ("""Quality61850.failure"""))
    val oldData = parse_element (element ("""Quality61850.oldData"""))
    val operatorBlocked = parse_element (element ("""Quality61850.operatorBlocked"""))
    val oscillatory = parse_element (element ("""Quality61850.oscillatory"""))
    val outOfRange = parse_element (element ("""Quality61850.outOfRange"""))
    val overFlow = parse_element (element ("""Quality61850.overFlow"""))
    val source = parse_attribute (attribute ("""Quality61850.source"""))
    val suspect = parse_element (element ("""Quality61850.suspect"""))
    val test = parse_element (element ("""Quality61850.test"""))
    val validity = parse_attribute (attribute ("""Quality61850.validity"""))
    def parse (context: Context): Quality61850 =
    {
        Quality61850(
            BasicElement.parse (context),
            toBoolean (badReference (context), context),
            toBoolean (estimatorReplaced (context), context),
            toBoolean (failure (context), context),
            toBoolean (oldData (context), context),
            toBoolean (operatorBlocked (context), context),
            toBoolean (oscillatory (context), context),
            toBoolean (outOfRange (context), context),
            toBoolean (overFlow (context), context),
            source (context),
            toBoolean (suspect (context), context),
            toBoolean (test (context), context),
            validity (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != ValueAliasSet) "\t\t<cim:RaiseLowerCommand.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RaiseLowerCommand rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RaiseLowerCommand>"
    }
}

object RaiseLowerCommand
extends
    Parseable[RaiseLowerCommand]
{
    val ValueAliasSet = parse_attribute (attribute ("""RaiseLowerCommand.ValueAliasSet"""))
    def parse (context: Context): RaiseLowerCommand =
    {
        RaiseLowerCommand(
            AnalogControl.parse (context),
            ValueAliasSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false))
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
        sup.export_fields +
        "\t\t<cim:SetPoint.normalValue>" + normalValue + "</cim:SetPoint.normalValue>\n" +
        "\t\t<cim:SetPoint.value>" + value + "</cim:SetPoint.value>\n"
    }
    override def export: String =
    {
        "\t<cim:SetPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SetPoint>"
    }
}

object SetPoint
extends
    Parseable[SetPoint]
{
    val normalValue = parse_element (element ("""SetPoint.normalValue"""))
    val value = parse_element (element ("""SetPoint.value"""))
    def parse (context: Context): SetPoint =
    {
        SetPoint(
            AnalogControl.parse (context),
            toDouble (normalValue (context), context),
            toDouble (value (context), context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:StringMeasurement rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StringMeasurement>"
    }
}

object StringMeasurement
extends
    Parseable[StringMeasurement]
{
    def parse (context: Context): StringMeasurement =
    {
        StringMeasurement(
            Measurement.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        (if (null != value) "\t\t<cim:StringMeasurementValue.value>" + value + "</cim:StringMeasurementValue.value>\n" else "") +
        (if (null != StringMeasurement) "\t\t<cim:StringMeasurementValue.StringMeasurement rdf:resource=\"#" + StringMeasurement + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StringMeasurementValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StringMeasurementValue>"
    }
}

object StringMeasurementValue
extends
    Parseable[StringMeasurementValue]
{
    val value = parse_element (element ("""StringMeasurementValue.value"""))
    val StringMeasurement = parse_attribute (attribute ("""StringMeasurementValue.StringMeasurement"""))
    def parse (context: Context): StringMeasurementValue =
    {
        StringMeasurementValue(
            MeasurementValue.parse (context),
            value (context),
            StringMeasurement (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("StringMeasurement", "StringMeasurement", false))
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:ValueAliasSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ValueAliasSet>"
    }
}

object ValueAliasSet
extends
    Parseable[ValueAliasSet]
{
    def parse (context: Context): ValueAliasSet =
    {
        ValueAliasSet(
            IdentifiedObject.parse (context)
        )
    }
    val relations: List[Relationship] = List ()
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
        sup.export_fields +
        "\t\t<cim:ValueToAlias.value>" + value + "</cim:ValueToAlias.value>\n" +
        (if (null != ValueAliasSet) "\t\t<cim:ValueToAlias.ValueAliasSet rdf:resource=\"#" + ValueAliasSet + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ValueToAlias rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ValueToAlias>"
    }
}

object ValueToAlias
extends
    Parseable[ValueToAlias]
{
    val value = parse_element (element ("""ValueToAlias.value"""))
    val ValueAliasSet = parse_attribute (attribute ("""ValueToAlias.ValueAliasSet"""))
    def parse (context: Context): ValueToAlias =
    {
        ValueToAlias(
            IdentifiedObject.parse (context),
            toInteger (value (context), context),
            ValueAliasSet (context)
        )
    }
    val relations: List[Relationship] = List (
        Relationship ("ValueAliasSet", "ValueAliasSet", false))
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