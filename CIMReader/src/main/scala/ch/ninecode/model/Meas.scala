package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Accumulator represents an accumulated (counted) Measurement, e.g. an energy value.
 *
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param AccumulatorValues [[ch.ninecode.model.AccumulatorValue AccumulatorValue]] The values connected to this measurement.
 * @param LimitSets [[ch.ninecode.model.AccumulatorLimitSet AccumulatorLimitSet]] A measurement may have zero or more limit ranges defined for it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Accumulator
(
    Measurement: Measurement = null,
    maxValue: Int = 0,
    AccumulatorValues: List[String] = null,
    LimitSets: List[String] = null
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
    override def sup: Measurement = Measurement

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
        implicit val clz: String = Accumulator.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Accumulator.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Accumulator.fields (position), x))
        emitelem (0, maxValue)
        emitattrs (1, AccumulatorValues)
        emitattrs (2, LimitSets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Accumulator rdf:ID=\"%s\">\n%s\t</cim:Accumulator>".format (id, export_fields)
    }
}

object Accumulator
extends
    CIMParseable[Accumulator]
{
    override val fields: Array[String] = Array[String] (
        "maxValue",
        "AccumulatorValues",
        "LimitSets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AccumulatorValues", "AccumulatorValue", "0..*", "1"),
        CIMRelationship ("LimitSets", "AccumulatorLimitSet", "0..*", "0..*")
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val AccumulatorValues: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val LimitSets: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): Accumulator =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Accumulator (
            Measurement.parse (context),
            toInteger (mask (maxValue (), 0)),
            masks (AccumulatorValues (), 1),
            masks (LimitSets (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Limit values for Accumulator measurements.
 *
 * @param Limit [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param value The value to supervise against.
 *        The value is positive.
 * @param LimitSet [[ch.ninecode.model.AccumulatorLimitSet AccumulatorLimitSet]] The set of limits.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AccumulatorLimit
(
    Limit: Limit = null,
    value: Int = 0,
    LimitSet: String = null
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
    override def sup: Limit = Limit

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
    CIMParseable[AccumulatorLimit]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "LimitSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LimitSet", "AccumulatorLimitSet", "1", "1..*")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val LimitSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): AccumulatorLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccumulatorLimit (
            Limit.parse (context),
            toInteger (mask (value (), 0)),
            mask (LimitSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An AccumulatorLimitSet specifies a set of Limits that are associated with an Accumulator measurement.
 *
 * @param LimitSet [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @param Limits [[ch.ninecode.model.AccumulatorLimit AccumulatorLimit]] The limit values used for supervision of Measurements.
 * @param Measurements [[ch.ninecode.model.Accumulator Accumulator]] The Measurements using the LimitSet.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AccumulatorLimitSet
(
    LimitSet: LimitSet = null,
    Limits: List[String] = null,
    Measurements: List[String] = null
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
    override def sup: LimitSet = LimitSet

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
        implicit val clz: String = AccumulatorLimitSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AccumulatorLimitSet.fields (position), x))
        emitattrs (0, Limits)
        emitattrs (1, Measurements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AccumulatorLimitSet rdf:ID=\"%s\">\n%s\t</cim:AccumulatorLimitSet>".format (id, export_fields)
    }
}

object AccumulatorLimitSet
extends
    CIMParseable[AccumulatorLimitSet]
{
    override val fields: Array[String] = Array[String] (
        "Limits",
        "Measurements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Limits", "AccumulatorLimit", "1..*", "1"),
        CIMRelationship ("Measurements", "Accumulator", "0..*", "0..*")
    )
    val Limits: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): AccumulatorLimitSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccumulatorLimitSet (
            LimitSet.parse (context),
            masks (Limits (), 0),
            masks (Measurements (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This command resets the counter value to zero.
 *
 * @param Control [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param AccumulatorValue [[ch.ninecode.model.AccumulatorValue AccumulatorValue]] The accumulator value that is reset by the command.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AccumulatorReset
(
    Control: Control = null,
    AccumulatorValue: String = null
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
    override def sup: Control = Control

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
    CIMParseable[AccumulatorReset]
{
    override val fields: Array[String] = Array[String] (
        "AccumulatorValue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AccumulatorValue", "AccumulatorValue", "1", "0..1")
    )
    val AccumulatorValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): AccumulatorReset =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccumulatorReset (
            Control.parse (context),
            mask (AccumulatorValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * AccumulatorValue represents an accumulated (counted) MeasurementValue.
 *
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 *        The value is positive.
 * @param Accumulator [[ch.ninecode.model.Accumulator Accumulator]] Measurement to which this value is connected.
 * @param AccumulatorReset [[ch.ninecode.model.AccumulatorReset AccumulatorReset]] The command that resets the accumulator value.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AccumulatorValue
(
    MeasurementValue: MeasurementValue = null,
    value: Int = 0,
    Accumulator: String = null,
    AccumulatorReset: String = null
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
    override def sup: MeasurementValue = MeasurementValue

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
    CIMParseable[AccumulatorValue]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "Accumulator",
        "AccumulatorReset"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Accumulator", "Accumulator", "1", "0..*"),
        CIMRelationship ("AccumulatorReset", "AccumulatorReset", "0..1", "1")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val Accumulator: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AccumulatorReset: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): AccumulatorValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AccumulatorValue (
            MeasurementValue.parse (context),
            toInteger (mask (value (), 0)),
            mask (Accumulator (), 1),
            mask (AccumulatorReset (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Analog represents an analog Measurement.
 *
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param positiveFlowIn If true then this measurement is an active power, reactive power or current with the convention that a positive value measured at the Terminal means power is flowing into the related PowerSystemResource.
 * @param AnalogValues [[ch.ninecode.model.AnalogValue AnalogValue]] The values connected to this measurement.
 * @param LimitSets [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] A measurement may have zero or more limit ranges defined for it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Analog
(
    Measurement: Measurement = null,
    maxValue: Double = 0.0,
    minValue: Double = 0.0,
    normalValue: Double = 0.0,
    positiveFlowIn: Boolean = false,
    AnalogValues: List[String] = null,
    LimitSets: List[String] = null
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
    override def sup: Measurement = Measurement

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
        implicit val clz: String = Analog.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Analog.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Analog.fields (position), x))
        emitelem (0, maxValue)
        emitelem (1, minValue)
        emitelem (2, normalValue)
        emitelem (3, positiveFlowIn)
        emitattrs (4, AnalogValues)
        emitattrs (5, LimitSets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Analog rdf:ID=\"%s\">\n%s\t</cim:Analog>".format (id, export_fields)
    }
}

object Analog
extends
    CIMParseable[Analog]
{
    override val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "normalValue",
        "positiveFlowIn",
        "AnalogValues",
        "LimitSets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AnalogValues", "AnalogValue", "0..*", "1"),
        CIMRelationship ("LimitSets", "AnalogLimitSet", "0..*", "0..*")
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val normalValue: Fielder = parse_element (element (cls, fields(2)))
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(3)))
    val AnalogValues: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val LimitSets: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): Analog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Analog (
            Measurement.parse (context),
            toDouble (mask (maxValue (), 0)),
            toDouble (mask (minValue (), 1)),
            toDouble (mask (normalValue (), 2)),
            toBoolean (mask (positiveFlowIn (), 3)),
            masks (AnalogValues (), 4),
            masks (LimitSets (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An analog control used for supervisory control.
 *
 * @param Control [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param minValue Normal value range minimum for any of the Control.value.
 *        Used for scaling, e.g. in bar graphs.
 * @param AnalogValue [[ch.ninecode.model.AnalogValue AnalogValue]] The MeasurementValue that is controlled.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AnalogControl
(
    Control: Control = null,
    maxValue: Double = 0.0,
    minValue: Double = 0.0,
    AnalogValue: String = null
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
    override def sup: Control = Control

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
    CIMParseable[AnalogControl]
{
    override val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "AnalogValue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AnalogValue", "AnalogValue", "1", "0..1")
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val AnalogValue: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): AnalogControl =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalogControl (
            Control.parse (context),
            toDouble (mask (maxValue (), 0)),
            toDouble (mask (minValue (), 1)),
            mask (AnalogValue (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Limit values for Analog measurements.
 *
 * @param Limit [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param value The value to supervise against.
 * @param LimitSet [[ch.ninecode.model.AnalogLimitSet AnalogLimitSet]] The set of limits.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AnalogLimit
(
    Limit: Limit = null,
    value: Double = 0.0,
    LimitSet: String = null
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
    override def sup: Limit = Limit

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
    CIMParseable[AnalogLimit]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "LimitSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LimitSet", "AnalogLimitSet", "1", "0..*")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val LimitSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): AnalogLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalogLimit (
            Limit.parse (context),
            toDouble (mask (value (), 0)),
            mask (LimitSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An AnalogLimitSet specifies a set of Limits that are associated with an Analog measurement.
 *
 * @param LimitSet [[ch.ninecode.model.LimitSet LimitSet]] Reference to the superclass object.
 * @param Limits [[ch.ninecode.model.AnalogLimit AnalogLimit]] The limit values used for supervision of Measurements.
 * @param Measurements [[ch.ninecode.model.Analog Analog]] The Measurements using the LimitSet.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AnalogLimitSet
(
    LimitSet: LimitSet = null,
    Limits: List[String] = null,
    Measurements: List[String] = null
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
    override def sup: LimitSet = LimitSet

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
        implicit val clz: String = AnalogLimitSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AnalogLimitSet.fields (position), x))
        emitattrs (0, Limits)
        emitattrs (1, Measurements)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogLimitSet rdf:ID=\"%s\">\n%s\t</cim:AnalogLimitSet>".format (id, export_fields)
    }
}

object AnalogLimitSet
extends
    CIMParseable[AnalogLimitSet]
{
    override val fields: Array[String] = Array[String] (
        "Limits",
        "Measurements"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Limits", "AnalogLimit", "0..*", "1"),
        CIMRelationship ("Measurements", "Analog", "0..*", "0..*")
    )
    val Limits: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): AnalogLimitSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalogLimitSet (
            LimitSet.parse (context),
            masks (Limits (), 0),
            masks (Measurements (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * AnalogValue represents an analog MeasurementValue.
 *
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param AltGeneratingUnit [[ch.ninecode.model.AltGeneratingUnitMeas AltGeneratingUnitMeas]] The alternate generating unit for which this measurement value applies.
 * @param AltTieMeas [[ch.ninecode.model.AltTieMeas AltTieMeas]] The usage of the measurement within the control area specification.
 * @param Analog [[ch.ninecode.model.Analog Analog]] Measurement to which this value is connected.
 * @param AnalogControl [[ch.ninecode.model.AnalogControl AnalogControl]] The Control variable associated with the MeasurementValue.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class AnalogValue
(
    MeasurementValue: MeasurementValue = null,
    value: Double = 0.0,
    AltGeneratingUnit: List[String] = null,
    AltTieMeas: List[String] = null,
    Analog: String = null,
    AnalogControl: String = null
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
    override def sup: MeasurementValue = MeasurementValue

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
        implicit val clz: String = AnalogValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalogValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalogValue.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AnalogValue.fields (position), x))
        emitelem (0, value)
        emitattrs (1, AltGeneratingUnit)
        emitattrs (2, AltTieMeas)
        emitattr (3, Analog)
        emitattr (4, AnalogControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalogValue rdf:ID=\"%s\">\n%s\t</cim:AnalogValue>".format (id, export_fields)
    }
}

object AnalogValue
extends
    CIMParseable[AnalogValue]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "AltGeneratingUnit",
        "AltTieMeas",
        "Analog",
        "AnalogControl"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AltGeneratingUnit", "AltGeneratingUnitMeas", "0..*", "1"),
        CIMRelationship ("AltTieMeas", "AltTieMeas", "0..*", "1"),
        CIMRelationship ("Analog", "Analog", "1", "0..*"),
        CIMRelationship ("AnalogControl", "AnalogControl", "0..1", "1")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val AltGeneratingUnit: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val AltTieMeas: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Analog: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AnalogControl: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): AnalogValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalogValue (
            MeasurementValue.parse (context),
            toDouble (mask (value (), 0)),
            masks (AltGeneratingUnit (), 1),
            masks (AltTieMeas (), 2),
            mask (Analog (), 3),
            mask (AnalogControl (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Command is a discrete control used for supervisory control.
 *
 * @param Control [[ch.ninecode.model.Control Control]] Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 * @param DiscreteValue [[ch.ninecode.model.DiscreteValue DiscreteValue]] The MeasurementValue that is controlled.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a Control value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Command
(
    Control: Control = null,
    normalValue: Int = 0,
    value: Int = 0,
    DiscreteValue: String = null,
    ValueAliasSet: String = null
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
    override def sup: Control = Control

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
    CIMParseable[Command]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value",
        "DiscreteValue",
        "ValueAliasSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiscreteValue", "DiscreteValue", "1", "0..1"),
        CIMRelationship ("ValueAliasSet", "ValueAliasSet", "0..1", "0..*")
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))
    val DiscreteValue: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): Command =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * Control is used for supervisory/device control.
 *
 * It represents control outputs that are used to change the state in a process, e.g. close or open breaker, a set point value or a raise lower command.
 *
 * @param IOPoint [[ch.ninecode.model.IOPoint IOPoint]] Reference to the superclass object.
 * @param controlType Specifies the type of Control, e.g.
 *        BreakerOn/Off, GeneratorVoltageSetPoint, TieLineFlow etc. The ControlType.name shall be unique among all specified types and describe the type.
 * @param operationInProgress Indicates that a client is currently sending control commands that has not completed.
 * @param timeStamp The last time a control output was sent.
 * @param unitMultiplier The unit multiplier of the controlled quantity.
 * @param unitSymbol The unit of measure of the controlled quantity.
 * @param ControlAction [[ch.ninecode.model.ControlAction ControlAction]] <em>undocumented</em>
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Regulating device governed by this control output.
 * @param RemoteControl [[ch.ninecode.model.RemoteControl RemoteControl]] The remote point controlling the physical actuator.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Control
(
    IOPoint: IOPoint = null,
    controlType: String = null,
    operationInProgress: Boolean = false,
    timeStamp: String = null,
    unitMultiplier: String = null,
    unitSymbol: String = null,
    ControlAction: String = null,
    PowerSystemResource: String = null,
    RemoteControl: String = null
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
    override def sup: IOPoint = IOPoint

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
        implicit val clz: String = Control.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Control.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Control.fields (position), value)
        emitelem (0, controlType)
        emitelem (1, operationInProgress)
        emitelem (2, timeStamp)
        emitattr (3, unitMultiplier)
        emitattr (4, unitSymbol)
        emitattr (5, ControlAction)
        emitattr (6, PowerSystemResource)
        emitattr (7, RemoteControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Control rdf:ID=\"%s\">\n%s\t</cim:Control>".format (id, export_fields)
    }
}

object Control
extends
    CIMParseable[Control]
{
    override val fields: Array[String] = Array[String] (
        "controlType",
        "operationInProgress",
        "timeStamp",
        "unitMultiplier",
        "unitSymbol",
        "ControlAction",
        "PowerSystemResource",
        "RemoteControl"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ControlAction", "ControlAction", "0..1", "0..1"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*"),
        CIMRelationship ("RemoteControl", "RemoteControl", "0..1", "1")
    )
    val controlType: Fielder = parse_element (element (cls, fields(0)))
    val operationInProgress: Fielder = parse_element (element (cls, fields(1)))
    val timeStamp: Fielder = parse_element (element (cls, fields(2)))
    val unitMultiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ControlAction: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RemoteControl: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): Control =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Control (
            IOPoint.parse (context),
            mask (controlType (), 0),
            toBoolean (mask (operationInProgress (), 1)),
            mask (timeStamp (), 2),
            mask (unitMultiplier (), 3),
            mask (unitSymbol (), 4),
            mask (ControlAction (), 5),
            mask (PowerSystemResource (), 6),
            mask (RemoteControl (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Discrete represents a discrete Measurement, i.e. a Measurement representing discrete values, e.g. a Breaker position.
 *
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param maxValue Normal value range maximum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param minValue Normal value range minimum for any of the MeasurementValue.values.
 *        Used for scaling, e.g. in bar graphs or of telemetered raw values.
 * @param normalValue Normal measurement value, e.g., used for percentage calculations.
 * @param DiscreteValues [[ch.ninecode.model.DiscreteValue DiscreteValue]] The values connected to this measurement.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a MeasurementValue.value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Discrete
(
    Measurement: Measurement = null,
    maxValue: Int = 0,
    minValue: Int = 0,
    normalValue: Int = 0,
    DiscreteValues: List[String] = null,
    ValueAliasSet: String = null
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
    override def sup: Measurement = Measurement

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
        implicit val clz: String = Discrete.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Discrete.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Discrete.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Discrete.fields (position), x))
        emitelem (0, maxValue)
        emitelem (1, minValue)
        emitelem (2, normalValue)
        emitattrs (3, DiscreteValues)
        emitattr (4, ValueAliasSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Discrete rdf:ID=\"%s\">\n%s\t</cim:Discrete>".format (id, export_fields)
    }
}

object Discrete
extends
    CIMParseable[Discrete]
{
    override val fields: Array[String] = Array[String] (
        "maxValue",
        "minValue",
        "normalValue",
        "DiscreteValues",
        "ValueAliasSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiscreteValues", "DiscreteValue", "0..*", "1"),
        CIMRelationship ("ValueAliasSet", "ValueAliasSet", "0..1", "0..*")
    )
    val maxValue: Fielder = parse_element (element (cls, fields(0)))
    val minValue: Fielder = parse_element (element (cls, fields(1)))
    val normalValue: Fielder = parse_element (element (cls, fields(2)))
    val DiscreteValues: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): Discrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Discrete (
            Measurement.parse (context),
            toInteger (mask (maxValue (), 0)),
            toInteger (mask (minValue (), 1)),
            toInteger (mask (normalValue (), 2)),
            masks (DiscreteValues (), 3),
            mask (ValueAliasSet (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * DiscreteValue represents a discrete MeasurementValue.
 *
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param Command [[ch.ninecode.model.Command Command]] The Control variable associated with the MeasurementValue.
 * @param Discrete [[ch.ninecode.model.Discrete Discrete]] Measurement to which this value is connected.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class DiscreteValue
(
    MeasurementValue: MeasurementValue = null,
    value: Int = 0,
    Command: String = null,
    Discrete: String = null
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
    override def sup: MeasurementValue = MeasurementValue

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
    CIMParseable[DiscreteValue]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "Command",
        "Discrete"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Command", "Command", "0..1", "1"),
        CIMRelationship ("Discrete", "Discrete", "1", "0..*")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val Command: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Discrete: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): DiscreteValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscreteValue (
            MeasurementValue.parse (context),
            toInteger (mask (value (), 0)),
            mask (Command (), 1),
            mask (Discrete (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class describe a measurement or control value.
 *
 * The purpose is to enable having attributes and associations common for measurement and control.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param BilateralToIOPoint [[ch.ninecode.model.ProvidedBilateralPoint ProvidedBilateralPoint]] Bilateral ICCP point for the measurement or control.
 * @param IOPointSource [[ch.ninecode.model.IOPointSource IOPointSource]] Local merasurement value source for an ICCP point.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class IOPoint
(
    IdentifiedObject: IdentifiedObject = null,
    BilateralToIOPoint: List[String] = null,
    IOPointSource: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = IOPoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IOPoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IOPoint.fields (position), x))
        emitattrs (0, BilateralToIOPoint)
        emitattr (1, IOPointSource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IOPoint rdf:ID=\"%s\">\n%s\t</cim:IOPoint>".format (id, export_fields)
    }
}

object IOPoint
extends
    CIMParseable[IOPoint]
{
    override val fields: Array[String] = Array[String] (
        "BilateralToIOPoint",
        "IOPointSource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BilateralToIOPoint", "ProvidedBilateralPoint", "0..*", "0..1"),
        CIMRelationship ("IOPointSource", "IOPointSource", "0..1", "0..*")
    )
    val BilateralToIOPoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val IOPointSource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): IOPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IOPoint (
            IdentifiedObject.parse (context),
            masks (BilateralToIOPoint (), 0),
            mask (IOPointSource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies one limit value for a Measurement.
 *
 * A Measurement typically has several limits that are kept together by the LimitSet class. The actual meaning and use of a Limit instance (i.e., if it is an alarm or warning limit or if it is a high or low limit) is not captured in the Limit class. However the name of a Limit instance may indicate both meaning and use.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] <em>undocumented</em>
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Limit
(
    IdentifiedObject: IdentifiedObject = null,
    Procedures: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = Limit.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Limit.fields (position), x))
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
    CIMParseable[Limit]
{
    override val fields: Array[String] = Array[String] (
        "Procedures"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Procedures", "Procedure", "0..*", "0..*")
    )
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Limit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Limit (
            IdentifiedObject.parse (context),
            masks (Procedures (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Specifies a set of Limits that are associated with a Measurement.
 *
 * A Measurement may have several LimitSets corresponding to seasonal or other changing conditions. The condition is captured in the name and description attributes. The same LimitSet may be used for several Measurements. In particular percentage limits are used this way.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param isPercentageLimits Tells if the limit values are in percentage of normalValue or the specified Unit for Measurements and Controls.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class LimitSet
(
    IdentifiedObject: IdentifiedObject = null,
    isPercentageLimits: Boolean = false
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
    override def sup: IdentifiedObject = IdentifiedObject

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
    CIMParseable[LimitSet]
{
    override val fields: Array[String] = Array[String] (
        "isPercentageLimits"
    )
    val isPercentageLimits: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): LimitSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LimitSet (
            IdentifiedObject.parse (context),
            toBoolean (mask (isPercentageLimits (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A Measurement represents any measured, calculated or non-measured non-calculated quantity.
 *
 * Any piece of equipment may contain Measurements, e.g. a substation may have temperature measurements and door open indications, a transformer may have oil temperature and tank pressure measurements, a bay may contain a number of power flow measurements and a Breaker may contain a switch status measurement.
 * The PSR - Measurement association is intended to capture this use of Measurement and is included in the naming hierarchy based on EquipmentContainer. The naming hierarchy typically has Measurements as leaves, e.g. Substation-VoltageLevel-Bay-Switch-Measurement.
 * Some Measurements represent quantities related to a particular sensor location in the network, e.g. a voltage transformer (VT) or potential transformer (PT) at a busbar or a current transformer (CT) at the bar between a breaker and an isolator. The sensing position is not captured in the PSR - Measurement association. Instead it is captured by the Measurement - Terminal association that is used to define the sensing location in the network topology. The location is defined by the connection of the Terminal to ConductingEquipment.
 * If both a Terminal and PSR are associated, and the PSR is of type ConductingEquipment, the associated Terminal should belong to that ConductingEquipment instance.
 * When the sensor location is needed both Measurement-PSR and Measurement-Terminal are used. The Measurement-Terminal association is never used alone.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param measurementType Specifies the type of measurement.
 *        For example, this specifies if the measurement represents an indoor temperature, outdoor temperature, bus voltage, line flow, etc.
 *        When the measurementType is set to "Specialization", the type of Measurement is defined in more detail by the specialized class which inherits from Measurement.
 * @param phases Indicates to which phases the measurement applies and avoids the need to use 'measurementType' to also encode phase information (which would explode the types).
 *        The phase information in Measurement, along with 'measurementType' and 'phases' uniquely defines a Measurement for a device, based on normal network phase. Their meaning will not change when the computed energizing phasing is changed due to jumpers or other reasons.
 *        If the attribute is missing three phases (ABC) shall be assumed.
 * @param uncefactUnitCode Contains a string value for units and multipliers from a list maintained by UN/CEFACT and described in recommendation No. 20, "Codes for Units of Measure Used in International Trade".
 *        Refer to the UN/CEFACT recommendation for details.
 * @param unitMultiplier The unit multiplier of the measured quantity.
 * @param unitSymbol The unit of measure of the measured quantity.
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @param CalculationMethodHierarchy [[ch.ninecode.model.CalculationMethodHierarchy CalculationMethodHierarchy]] Calculation method hierarchy which applies to this analog.
 * @param Locations [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param MeasurementAction [[ch.ninecode.model.MeasurementAction MeasurementAction]] <em>undocumented</em>
 * @param MeasurementCalculatorInput [[ch.ninecode.model.MeasurementCalculatorInput MeasurementCalculatorInput]] <em>undocumented</em>
 * @param PinMeasurement [[ch.ninecode.model.PinMeasurement PinMeasurement]] <em>undocumented</em>
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] The power system resource that contains the measurement.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] Measurements are specified in types of documents, such as procedures.
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] <em>undocumented</em>
 * @param Terminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] One or more measurements may be associated with a terminal in the network.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Measurement
(
    IdentifiedObject: IdentifiedObject = null,
    measurementType: String = null,
    phases: String = null,
    uncefactUnitCode: String = null,
    unitMultiplier: String = null,
    unitSymbol: String = null,
    Asset: String = null,
    CalculationMethodHierarchy: String = null,
    Locations: List[String] = null,
    MeasurementAction: String = null,
    MeasurementCalculatorInput: List[String] = null,
    PinMeasurement: List[String] = null,
    PowerSystemResource: String = null,
    Procedures: List[String] = null,
    ProtectiveActionAdjustment: List[String] = null,
    Terminal: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = Measurement.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Measurement.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Measurement.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Measurement.fields (position), x))
        emitelem (0, measurementType)
        emitattr (1, phases)
        emitelem (2, uncefactUnitCode)
        emitattr (3, unitMultiplier)
        emitattr (4, unitSymbol)
        emitattr (5, Asset)
        emitattr (6, CalculationMethodHierarchy)
        emitattrs (7, Locations)
        emitattr (8, MeasurementAction)
        emitattrs (9, MeasurementCalculatorInput)
        emitattrs (10, PinMeasurement)
        emitattr (11, PowerSystemResource)
        emitattrs (12, Procedures)
        emitattrs (13, ProtectiveActionAdjustment)
        emitattr (14, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Measurement rdf:ID=\"%s\">\n%s\t</cim:Measurement>".format (id, export_fields)
    }
}

object Measurement
extends
    CIMParseable[Measurement]
{
    override val fields: Array[String] = Array[String] (
        "measurementType",
        "phases",
        "uncefactUnitCode",
        "unitMultiplier",
        "unitSymbol",
        "Asset",
        "CalculationMethodHierarchy",
        "Locations",
        "MeasurementAction",
        "MeasurementCalculatorInput",
        "PinMeasurement",
        "PowerSystemResource",
        "Procedures",
        "ProtectiveActionAdjustment",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship ("CalculationMethodHierarchy", "CalculationMethodHierarchy", "0..1", "0..*"),
        CIMRelationship ("Locations", "Location", "0..*", "0..*"),
        CIMRelationship ("MeasurementAction", "MeasurementAction", "0..1", "0..1"),
        CIMRelationship ("MeasurementCalculatorInput", "MeasurementCalculatorInput", "0..*", "1"),
        CIMRelationship ("PinMeasurement", "PinMeasurement", "0..*", "0..1"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*"),
        CIMRelationship ("Procedures", "Procedure", "0..*", "0..*"),
        CIMRelationship ("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "0..1"),
        CIMRelationship ("Terminal", "ACDCTerminal", "0..1", "0..*")
    )
    val measurementType: Fielder = parse_element (element (cls, fields(0)))
    val phases: Fielder = parse_attribute (attribute (cls, fields(1)))
    val uncefactUnitCode: Fielder = parse_element (element (cls, fields(2)))
    val unitMultiplier: Fielder = parse_attribute (attribute (cls, fields(3)))
    val unitSymbol: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CalculationMethodHierarchy: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val MeasurementAction: Fielder = parse_attribute (attribute (cls, fields(8)))
    val MeasurementCalculatorInput: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val PinMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(11)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(14)))

    def parse (context: CIMContext): Measurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Measurement (
            IdentifiedObject.parse (context),
            mask (measurementType (), 0),
            mask (phases (), 1),
            mask (uncefactUnitCode (), 2),
            mask (unitMultiplier (), 3),
            mask (unitSymbol (), 4),
            mask (Asset (), 5),
            mask (CalculationMethodHierarchy (), 6),
            masks (Locations (), 7),
            mask (MeasurementAction (), 8),
            masks (MeasurementCalculatorInput (), 9),
            masks (PinMeasurement (), 10),
            mask (PowerSystemResource (), 11),
            masks (Procedures (), 12),
            masks (ProtectiveActionAdjustment (), 13),
            mask (Terminal (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The current state for a measurement.
 *
 * A state value is an instance of a measurement from a specific source. Measurements can be associated with many state values, each representing a different source for the measurement.
 *
 * @param IOPoint [[ch.ninecode.model.IOPoint IOPoint]] Reference to the superclass object.
 * @param sensorAccuracy The limit, expressed as a percentage of the sensor maximum, that errors will not exceed when the sensor is used under  reference conditions.
 * @param timeStamp The time when the value was last updated.
 * @param CalculationMethodHierarchy [[ch.ninecode.model.CalculationMethodHierarchy CalculationMethodHierarchy]] <em>undocumented</em>
 * @param ErpPerson [[ch.ninecode.model.OldPerson OldPerson]] <em>undocumented</em>
 * @param MeasurementValueQuality [[ch.ninecode.model.MeasurementValueQuality MeasurementValueQuality]] A MeasurementValue has a MeasurementValueQuality associated with it.
 * @param MeasurementValueSource [[ch.ninecode.model.MeasurementValueSource MeasurementValueSource]] A reference to the type of source that updates the MeasurementValue, e.g.
 *        SCADA, CCLink, manual, etc. User conventions for the names of sources are contained in the introduction to IEC 61970-301.
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] <em>undocumented</em>
 * @param RemoteSource [[ch.ninecode.model.RemoteSource RemoteSource]] Link to the physical telemetered point associated with this measurement.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class MeasurementValue
(
    IOPoint: IOPoint = null,
    sensorAccuracy: Double = 0.0,
    timeStamp: String = null,
    CalculationMethodHierarchy: String = null,
    ErpPerson: String = null,
    MeasurementValueQuality: String = null,
    MeasurementValueSource: String = null,
    ProcedureDataSet: List[String] = null,
    RemoteSource: String = null
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
    override def sup: IOPoint = IOPoint

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
        implicit val clz: String = MeasurementValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MeasurementValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementValue.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MeasurementValue.fields (position), x))
        emitelem (0, sensorAccuracy)
        emitelem (1, timeStamp)
        emitattr (2, CalculationMethodHierarchy)
        emitattr (3, ErpPerson)
        emitattr (4, MeasurementValueQuality)
        emitattr (5, MeasurementValueSource)
        emitattrs (6, ProcedureDataSet)
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
    CIMParseable[MeasurementValue]
{
    override val fields: Array[String] = Array[String] (
        "sensorAccuracy",
        "timeStamp",
        "CalculationMethodHierarchy",
        "ErpPerson",
        "MeasurementValueQuality",
        "MeasurementValueSource",
        "ProcedureDataSet",
        "RemoteSource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CalculationMethodHierarchy", "CalculationMethodHierarchy", "0..1", "0..1"),
        CIMRelationship ("ErpPerson", "OldPerson", "0..1", "0..*"),
        CIMRelationship ("MeasurementValueQuality", "MeasurementValueQuality", "0..1", "1"),
        CIMRelationship ("MeasurementValueSource", "MeasurementValueSource", "1", "0..*"),
        CIMRelationship ("ProcedureDataSet", "ProcedureDataSet", "0..*", "0..*"),
        CIMRelationship ("RemoteSource", "RemoteSource", "0..1", "1")
    )
    val sensorAccuracy: Fielder = parse_element (element (cls, fields(0)))
    val timeStamp: Fielder = parse_element (element (cls, fields(1)))
    val CalculationMethodHierarchy: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ErpPerson: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MeasurementValueQuality: Fielder = parse_attribute (attribute (cls, fields(4)))
    val MeasurementValueSource: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ProcedureDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val RemoteSource: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): MeasurementValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementValue (
            IOPoint.parse (context),
            toDouble (mask (sensorAccuracy (), 0)),
            mask (timeStamp (), 1),
            mask (CalculationMethodHierarchy (), 2),
            mask (ErpPerson (), 3),
            mask (MeasurementValueQuality (), 4),
            mask (MeasurementValueSource (), 5),
            masks (ProcedureDataSet (), 6),
            mask (RemoteSource (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Measurement quality flags.
 *
 * Bits 0-10 are defined for substation automation in IEC 61850-7-3. Bits 11-15 are reserved for future expansion by that document. Bits 16-31 are reserved for EMS applications.
 *
 * @param Quality61850 [[ch.ninecode.model.Quality61850 Quality61850]] Reference to the superclass object.
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] A MeasurementValue has a MeasurementValueQuality associated with it.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class MeasurementValueQuality
(
    Quality61850: Quality61850 = null,
    MeasurementValue: String = null
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
    override def sup: Quality61850 = Quality61850

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
    CIMParseable[MeasurementValueQuality]
{
    override val fields: Array[String] = Array[String] (
        "MeasurementValue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeasurementValue", "MeasurementValue", "1", "0..1")
    )
    val MeasurementValue: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): MeasurementValueQuality =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementValueQuality (
            Quality61850.parse (context),
            mask (MeasurementValue (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * MeasurementValueSource describes the alternative sources updating a MeasurementValue.
 *
 * User conventions for how to use the MeasurementValueSource attributes are defined in IEC 61970-301.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MeasurementValues [[ch.ninecode.model.MeasurementValue MeasurementValue]] The MeasurementValues updated by the source.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class MeasurementValueSource
(
    IdentifiedObject: IdentifiedObject = null,
    MeasurementValues: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = MeasurementValueSource.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (MeasurementValueSource.fields (position), x))
        emitattrs (0, MeasurementValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementValueSource rdf:ID=\"%s\">\n%s\t</cim:MeasurementValueSource>".format (id, export_fields)
    }
}

object MeasurementValueSource
extends
    CIMParseable[MeasurementValueSource]
{
    override val fields: Array[String] = Array[String] (
        "MeasurementValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MeasurementValues", "MeasurementValue", "0..*", "1")
    )
    val MeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): MeasurementValueSource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementValueSource (
            IdentifiedObject.parse (context),
            masks (MeasurementValues (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Quality flags in this class are as defined in IEC 61850, except for estimatorReplaced, which has been included in this class for convenience.
 *
 * @param Element Reference to the superclass object.
 * @param badReference Measurement value may be incorrect due to a reference being out of calibration.
 * @param estimatorReplaced Value has been replaced by State Estimator. estimatorReplaced is not an IEC61850 quality bit but has been put in this class for convenience.
 * @param failure This identifier indicates that a supervision function has detected an internal or external failure, e.g. communication failure.
 * @param oldData Measurement value is old and possibly invalid, as it has not been successfully updated during a specified time interval.
 * @param operatorBlocked Measurement value is blocked and hence unavailable for transmission.
 * @param oscillatory To prevent some overload of the communication it is sensible to detect and suppress oscillating (fast changing) binary inputs.
 *        If a signal changes in a defined time twice in the same direction (from 0 to 1 or from 1 to 0) then oscillation is detected and the detail quality identifier "oscillatory" is set. If it is detected a configured numbers of transient changes could be passed by. In this time the validity status "questionable" is set. If after this defined numbers of changes the signal is still in the oscillating state the value shall be set either to the opposite state of the previous stable value or to a defined default value. In this case the validity status "questionable" is reset and "invalid" is set as long as the signal is oscillating. If it is configured such that no transient changes should be passed by then the validity status "invalid" is set immediately in addition to the detail quality identifier "oscillatory" (used for status information only).
 * @param outOfRange Measurement value is beyond a predefined range of value.
 * @param overFlow Measurement value is beyond the capability of being  represented properly.
 *        For example, a counter value overflows from maximum count back to a value of zero.
 * @param source Source gives information related to the origin of a value.
 *        The value may be acquired from the process, defaulted or substituted.
 * @param suspect A correlation function has detected that the value is not consistent with other values.
 *        Typically set by a network State Estimator.
 * @param test Measurement value is transmitted for test purposes.
 * @param validity Validity of the measurement value.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class Quality61850
(
    Element: BasicElement = null,
    badReference: Boolean = false,
    estimatorReplaced: Boolean = false,
    failure: Boolean = false,
    oldData: Boolean = false,
    operatorBlocked: Boolean = false,
    oscillatory: Boolean = false,
    outOfRange: Boolean = false,
    overFlow: Boolean = false,
    source: String = null,
    suspect: Boolean = false,
    test: Boolean = false,
    validity: String = null
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
    CIMParseable[Quality61850]
{
    override val fields: Array[String] = Array[String] (
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

    def parse (context: CIMContext): Quality61850 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * An analog control that increases or decreases a set point value with pulses.
 *
 * Unless otherwise specified, one pulse moves the set point by one.
 *
 * @param AnalogControl [[ch.ninecode.model.AnalogControl AnalogControl]] Reference to the superclass object.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet used for translation of a Control value to a name.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class RaiseLowerCommand
(
    AnalogControl: AnalogControl = null,
    ValueAliasSet: String = null
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
    override def sup: AnalogControl = AnalogControl

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
    CIMParseable[RaiseLowerCommand]
{
    override val fields: Array[String] = Array[String] (
        "ValueAliasSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ValueAliasSet", "ValueAliasSet", "0..1", "0..*")
    )
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): RaiseLowerCommand =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RaiseLowerCommand (
            AnalogControl.parse (context),
            mask (ValueAliasSet (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An analog control that issues a set point value.
 *
 * @param AnalogControl [[ch.ninecode.model.AnalogControl AnalogControl]] Reference to the superclass object.
 * @param normalValue Normal value for Control.value e.g. used for percentage scaling.
 * @param value The value representing the actuator output.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class SetPoint
(
    AnalogControl: AnalogControl = null,
    normalValue: Double = 0.0,
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
    override def sup: AnalogControl = AnalogControl

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
    CIMParseable[SetPoint]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): SetPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SetPoint (
            AnalogControl.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * StringMeasurement represents a measurement with values of type string.
 *
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] Reference to the superclass object.
 * @param StringMeasurementValues [[ch.ninecode.model.StringMeasurementValue StringMeasurementValue]] The values connected to this measurement.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class StringMeasurement
(
    Measurement: Measurement = null,
    StringMeasurementValues: List[String] = null
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
    override def sup: Measurement = Measurement

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
        implicit val clz: String = StringMeasurement.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (StringMeasurement.fields (position), x))
        emitattrs (0, StringMeasurementValues)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StringMeasurement rdf:ID=\"%s\">\n%s\t</cim:StringMeasurement>".format (id, export_fields)
    }
}

object StringMeasurement
extends
    CIMParseable[StringMeasurement]
{
    override val fields: Array[String] = Array[String] (
        "StringMeasurementValues"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StringMeasurementValues", "StringMeasurementValue", "0..*", "1")
    )
    val StringMeasurementValues: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): StringMeasurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StringMeasurement (
            Measurement.parse (context),
            masks (StringMeasurementValues (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * StringMeasurementValue represents a measurement value of type string.
 *
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] Reference to the superclass object.
 * @param value The value to supervise.
 * @param StringMeasurement [[ch.ninecode.model.StringMeasurement StringMeasurement]] Measurement to which this value is connected.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class StringMeasurementValue
(
    MeasurementValue: MeasurementValue = null,
    value: String = null,
    StringMeasurement: String = null
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
    override def sup: MeasurementValue = MeasurementValue

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
    CIMParseable[StringMeasurementValue]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "StringMeasurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StringMeasurement", "StringMeasurement", "1", "0..*")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val StringMeasurement: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): StringMeasurementValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StringMeasurementValue (
            MeasurementValue.parse (context),
            mask (value (), 0),
            mask (StringMeasurement (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the translation of a set of values into a name and is intendend to facilitate custom translations.
 *
 * Each ValueAliasSet has a name, description etc. A specific Measurement may represent a discrete state like Open, Closed, Intermediate etc. This requires a translation from the MeasurementValue.value number to a string, e.g. 0-&gt;"Invalid", 1-&gt;"Open", 2-&gt;"Closed", 3-&gt;"Intermediate". Each ValueToAlias member in ValueAliasSet.Value describe a mapping for one particular value to a name.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Commands [[ch.ninecode.model.Command Command]] The Commands using the set for translation.
 * @param Discretes [[ch.ninecode.model.Discrete Discrete]] The Measurements using the set for translation.
 * @param RaiseLowerCommands [[ch.ninecode.model.RaiseLowerCommand RaiseLowerCommand]] The Commands using the set for translation.
 * @param Values [[ch.ninecode.model.ValueToAlias ValueToAlias]] The ValueToAlias mappings included in the set.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class ValueAliasSet
(
    IdentifiedObject: IdentifiedObject = null,
    Commands: List[String] = null,
    Discretes: List[String] = null,
    RaiseLowerCommands: List[String] = null,
    Values: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = ValueAliasSet.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ValueAliasSet.fields (position), x))
        emitattrs (0, Commands)
        emitattrs (1, Discretes)
        emitattrs (2, RaiseLowerCommands)
        emitattrs (3, Values)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ValueAliasSet rdf:ID=\"%s\">\n%s\t</cim:ValueAliasSet>".format (id, export_fields)
    }
}

object ValueAliasSet
extends
    CIMParseable[ValueAliasSet]
{
    override val fields: Array[String] = Array[String] (
        "Commands",
        "Discretes",
        "RaiseLowerCommands",
        "Values"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Commands", "Command", "0..*", "0..1"),
        CIMRelationship ("Discretes", "Discrete", "0..*", "0..1"),
        CIMRelationship ("RaiseLowerCommands", "RaiseLowerCommand", "0..*", "0..1"),
        CIMRelationship ("Values", "ValueToAlias", "1..*", "1")
    )
    val Commands: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Discretes: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val RaiseLowerCommands: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Values: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ValueAliasSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ValueAliasSet (
            IdentifiedObject.parse (context),
            masks (Commands (), 0),
            masks (Discretes (), 1),
            masks (RaiseLowerCommands (), 2),
            masks (Values (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Describes the translation of one particular value into a name, e.g. 1 as "Open".
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param value The value that is mapped.
 * @param ValueAliasSet [[ch.ninecode.model.ValueAliasSet ValueAliasSet]] The ValueAliasSet having the ValueToAlias mappings.
 * @group Meas
 * @groupname Meas Package Meas
 * @groupdesc Meas Contains entities that describe dynamic measurement data exchanged between applications.
 */
final case class ValueToAlias
(
    IdentifiedObject: IdentifiedObject = null,
    value: Int = 0,
    ValueAliasSet: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
    CIMParseable[ValueToAlias]
{
    override val fields: Array[String] = Array[String] (
        "value",
        "ValueAliasSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ValueAliasSet", "ValueAliasSet", "1", "1..*")
    )
    val value: Fielder = parse_element (element (cls, fields(0)))
    val ValueAliasSet: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ValueToAlias =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ValueToAlias (
            IdentifiedObject.parse (context),
            toInteger (mask (value (), 0)),
            mask (ValueAliasSet (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Meas
{
    def register: List[CIMClassInfo] =
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
            DiscreteValue.register,
            IOPoint.register,
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