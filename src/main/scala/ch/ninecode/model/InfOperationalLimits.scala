package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The description of computed or dynamic limits.
 * These classes would likely go into the OperationalLimits package.
 */

/**
 * This is a environmental based limit dependency model for calculating operational limits.
 * @param sup Reference to the superclass object.
 */
case class EnvironmentalDependentLimit
(
    override val sup: LimitDependency
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalDependentLimit] }
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
        "\t<cim:EnvironmentalDependentLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnvironmentalDependentLimit>"
    }
}

object EnvironmentalDependentLimit
extends
    Parseable[EnvironmentalDependentLimit]
{
    def parse (context: Context): EnvironmentalDependentLimit =
    {
        EnvironmentalDependentLimit(
            LimitDependency.parse (context)
        )
    }
}

/**
 * This represents one instance of an equipment that contributes to the calculation of an operational limit.
 * @param sup Reference to the superclass object.
 * @param Equipment Equipment contributing toward the series limit.
 *        The reference here is to Equipment rather than a specific limit on the equipment so the grouiping can be reused for multiple limits of different types on the same instance of equipment.
 * @param SeriesEquipmentDependentLimit Calculation in which the refernce to equipment applies.
 */
case class EquipmentLimitSeriesComponent
(
    override val sup: IdentifiedObject,
    Equipment: String,
    SeriesEquipmentDependentLimit: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentLimitSeriesComponent] }
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
        (if (null != Equipment) "\t\t<cim:EquipmentLimitSeriesComponent.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "") +
        (if (null != SeriesEquipmentDependentLimit) "\t\t<cim:EquipmentLimitSeriesComponent.SeriesEquipmentDependentLimit rdf:resource=\"#" + SeriesEquipmentDependentLimit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EquipmentLimitSeriesComponent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquipmentLimitSeriesComponent>"
    }
}

object EquipmentLimitSeriesComponent
extends
    Parseable[EquipmentLimitSeriesComponent]
{
    val Equipment: (Context) => String = parse_attribute (attribute ("""EquipmentLimitSeriesComponent.Equipment"""))
    val SeriesEquipmentDependentLimit: (Context) => String = parse_attribute (attribute ("""EquipmentLimitSeriesComponent.SeriesEquipmentDependentLimit"""))
    def parse (context: Context): EquipmentLimitSeriesComponent =
    {
        EquipmentLimitSeriesComponent(
            IdentifiedObject.parse (context),
            Equipment (context),
            SeriesEquipmentDependentLimit (context)
        )
    }
}

/**
 * A limit calculation model used to compute an operational limit based on external input such as temperature.
 * These are intended to be shared among operational limits with the same calculation form that apply to a piece of equipment..
 * @param sup Reference to the superclass object.
 * @param Equipment The equipment for which this limit dependency model is organized under.
 */
case class LimitDependency
(
    override val sup: IdentifiedObject,
    Equipment: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LimitDependency] }
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
        (if (null != Equipment) "\t\t<cim:LimitDependency.Equipment rdf:resource=\"#" + Equipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LimitDependency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LimitDependency>"
    }
}

object LimitDependency
extends
    Parseable[LimitDependency]
{
    val Equipment: (Context) => String = parse_attribute (attribute ("""LimitDependency.Equipment"""))
    def parse (context: Context): LimitDependency =
    {
        LimitDependency(
            IdentifiedObject.parse (context),
            Equipment (context)
        )
    }
}

/**
 * Specifies an operational  limit is calculated by scaling another operational limit.
 * @param sup Reference to the superclass object.
 * @param limitScalingPercent The associated source limit is scaled by this value to compute the limit of the dependency model.
 * @param SourceOperationalLimit <em>undocumented</em>
 */
case class LimitScalingLimit
(
    override val sup: LimitDependency,
    limitScalingPercent: Double,
    SourceOperationalLimit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[LimitScalingLimit] }
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
        "\t\t<cim:LimitScalingLimit.limitScalingPercent>" + limitScalingPercent + "</cim:LimitScalingLimit.limitScalingPercent>\n" +
        (if (null != SourceOperationalLimit) "\t\t<cim:LimitScalingLimit.SourceOperationalLimit rdf:resource=\"#" + SourceOperationalLimit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LimitScalingLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LimitScalingLimit>"
    }
}

object LimitScalingLimit
extends
    Parseable[LimitScalingLimit]
{
    val limitScalingPercent: (Context) => String = parse_element (element ("""LimitScalingLimit.limitScalingPercent"""))
    val SourceOperationalLimit: (Context) => String = parse_attribute (attribute ("""LimitScalingLimit.SourceOperationalLimit"""))
    def parse (context: Context): LimitScalingLimit =
    {
        LimitScalingLimit(
            LimitDependency.parse (context),
            toDouble (limitScalingPercent (context), context),
            SourceOperationalLimit (context)
        )
    }
}

/**
 * One operational limit type scales values of another operational limit type when under the same operational limit set.
 * This applies to any operational limit assigned to the target operational limit type and without other limit dependency models.
 * @param sup Reference to the superclass object.
 * @param scalingPercent The percentage scaling of the source limit to compute the target limit.
 *        Applys to operational limits within an operaitonal limit set when both source and target operational limit types exist.
 * @param SourceOperationalLimitType <em>undocumented</em>
 * @param TargetOperationalLimit <em>undocumented</em>
 */
case class OperatonalLimitTypeScaling
(
    override val sup: BasicElement,
    scalingPercent: Double,
    SourceOperationalLimitType: String,
    TargetOperationalLimit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OperatonalLimitTypeScaling] }
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
        "\t\t<cim:OperatonalLimitTypeScaling.scalingPercent>" + scalingPercent + "</cim:OperatonalLimitTypeScaling.scalingPercent>\n" +
        (if (null != SourceOperationalLimitType) "\t\t<cim:OperatonalLimitTypeScaling.SourceOperationalLimitType rdf:resource=\"#" + SourceOperationalLimitType + "\"/>\n" else "") +
        (if (null != TargetOperationalLimit) "\t\t<cim:OperatonalLimitTypeScaling.TargetOperationalLimit rdf:resource=\"#" + TargetOperationalLimit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperatonalLimitTypeScaling rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperatonalLimitTypeScaling>"
    }
}

object OperatonalLimitTypeScaling
extends
    Parseable[OperatonalLimitTypeScaling]
{
    val scalingPercent: (Context) => String = parse_element (element ("""OperatonalLimitTypeScaling.scalingPercent"""))
    val SourceOperationalLimitType: (Context) => String = parse_attribute (attribute ("""OperatonalLimitTypeScaling.SourceOperationalLimitType"""))
    val TargetOperationalLimit: (Context) => String = parse_attribute (attribute ("""OperatonalLimitTypeScaling.TargetOperationalLimit"""))
    def parse (context: Context): OperatonalLimitTypeScaling =
    {
        OperatonalLimitTypeScaling(
            BasicElement.parse (context),
            toDouble (scalingPercent (context), context),
            SourceOperationalLimitType (context),
            TargetOperationalLimit (context)
        )
    }
}

case class ScheduledActivePowerLimitValue
(
    override val sup: ScheduledLimitValue,
    value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledActivePowerLimitValue] }
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
        "\t\t<cim:ScheduledActivePowerLimitValue.value>" + value + "</cim:ScheduledActivePowerLimitValue.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ScheduledActivePowerLimitValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledActivePowerLimitValue>"
    }
}

object ScheduledActivePowerLimitValue
extends
    Parseable[ScheduledActivePowerLimitValue]
{
    val value: (Context) => String = parse_element (element ("""ScheduledActivePowerLimitValue.value"""))
    def parse (context: Context): ScheduledActivePowerLimitValue =
    {
        ScheduledActivePowerLimitValue(
            ScheduledLimitValue.parse (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * A time scheduled value for apparent power limit.
 * @param sup Reference to the superclass object.
 * @param value The apparent power limit value for the scheduled time.
 */
case class ScheduledApparentPowerLimitValue
(
    override val sup: ScheduledLimitValue,
    value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledApparentPowerLimitValue] }
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
        "\t\t<cim:ScheduledApparentPowerLimitValue.value>" + value + "</cim:ScheduledApparentPowerLimitValue.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ScheduledApparentPowerLimitValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledApparentPowerLimitValue>"
    }
}

object ScheduledApparentPowerLimitValue
extends
    Parseable[ScheduledApparentPowerLimitValue]
{
    val value: (Context) => String = parse_element (element ("""ScheduledApparentPowerLimitValue.value"""))
    def parse (context: Context): ScheduledApparentPowerLimitValue =
    {
        ScheduledApparentPowerLimitValue(
            ScheduledLimitValue.parse (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * A current limit that is scheduled.
 * @param sup Reference to the superclass object.
 * @param value The current flow limit value applicable at the scheduled time.
 */
case class ScheduledCurrentLimitValue
(
    override val sup: ScheduledLimitValue,
    value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledCurrentLimitValue] }
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
        "\t\t<cim:ScheduledCurrentLimitValue.value>" + value + "</cim:ScheduledCurrentLimitValue.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ScheduledCurrentLimitValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledCurrentLimitValue>"
    }
}

object ScheduledCurrentLimitValue
extends
    Parseable[ScheduledCurrentLimitValue]
{
    val value: (Context) => String = parse_element (element ("""ScheduledCurrentLimitValue.value"""))
    def parse (context: Context): ScheduledCurrentLimitValue =
    {
        ScheduledCurrentLimitValue(
            ScheduledLimitValue.parse (context),
            toDouble (value (context), context)
        )
    }
}

case class ScheduledLimitDependency
(
    override val sup: LimitDependency
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledLimitDependency] }
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
        "\t<cim:ScheduledLimitDependency rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledLimitDependency>"
    }
}

object ScheduledLimitDependency
extends
    Parseable[ScheduledLimitDependency]
{
    def parse (context: Context): ScheduledLimitDependency =
    {
        ScheduledLimitDependency(
            LimitDependency.parse (context)
        )
    }
}

/**
 * A limit that is applicable during a scheduled time period.
 * @param sup Reference to the superclass object.
 * @param ScheduledLimitDependency <em>undocumented</em>
 * @param Season The season for which the scheduled limits applies.
 *        If not specified, then applicable ot any season.
 */
case class ScheduledLimitValue
(
    override val sup: IdentifiedObject,
    ScheduledLimitDependency: String,
    Season: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledLimitValue] }
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
        (if (null != ScheduledLimitDependency) "\t\t<cim:ScheduledLimitValue.ScheduledLimitDependency rdf:resource=\"#" + ScheduledLimitDependency + "\"/>\n" else "") +
        (if (null != Season) "\t\t<cim:ScheduledLimitValue.Season rdf:resource=\"#" + Season + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ScheduledLimitValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledLimitValue>"
    }
}

object ScheduledLimitValue
extends
    Parseable[ScheduledLimitValue]
{
    val ScheduledLimitDependency: (Context) => String = parse_attribute (attribute ("""ScheduledLimitValue.ScheduledLimitDependency"""))
    val Season: (Context) => String = parse_attribute (attribute ("""ScheduledLimitValue.Season"""))
    def parse (context: Context): ScheduledLimitValue =
    {
        ScheduledLimitValue(
            IdentifiedObject.parse (context),
            ScheduledLimitDependency (context),
            Season (context)
        )
    }
}

/**
 * A voltage limit value for a scheduled time.
 * @param sup Reference to the superclass object.
 * @param value The voltage limit value for the scheduled time.
 */
case class ScheduledVoltageLimitValue
(
    override val sup: ScheduledLimitValue,
    value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { clone ().asInstanceOf[ScheduledVoltageLimitValue] }
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
        "\t\t<cim:ScheduledVoltageLimitValue.value>" + value + "</cim:ScheduledVoltageLimitValue.value>\n"
    }
    override def export: String =
    {
        "\t<cim:ScheduledVoltageLimitValue rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ScheduledVoltageLimitValue>"
    }
}

object ScheduledVoltageLimitValue
extends
    Parseable[ScheduledVoltageLimitValue]
{
    val value: (Context) => String = parse_element (element ("""ScheduledVoltageLimitValue.value"""))
    def parse (context: Context): ScheduledVoltageLimitValue =
    {
        ScheduledVoltageLimitValue(
            ScheduledLimitValue.parse (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Limit based on most restrictive series equipment limit.
 * A specification of  of equipment that determines the calculated operational limit values based upon other equipment and their ratings.  The most restrictive limit connected in series within the group is used.   The physical connection based on switch status for example may also impact which elements in the group are considered. Any equipment in the group that are presently connected in series with the equipment of the directly associated operational limit are used.   This provides a means to indicate which potentially series equipment limits are considered for a computed operational limit. The operational limit of the same operational limit type is assumed to be used from the grouped equipment.   It is also possible to make assumptions or calculations regarding how flow might split if the equipment is not simply in series.
 * @param sup Reference to the superclass object.
 */
case class SeriesEquipmentDependentLimit
(
    override val sup: LimitDependency
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { clone ().asInstanceOf[SeriesEquipmentDependentLimit] }
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
        "\t<cim:SeriesEquipmentDependentLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SeriesEquipmentDependentLimit>"
    }
}

object SeriesEquipmentDependentLimit
extends
    Parseable[SeriesEquipmentDependentLimit]
{
    def parse (context: Context): SeriesEquipmentDependentLimit =
    {
        SeriesEquipmentDependentLimit(
            LimitDependency.parse (context)
        )
    }
}

/**
 * A point on a table of limit verses temperature.
 * @param sup Reference to the superclass object.
 * @param limitPercent The scaling of the operational limit in percent.
 * @param temperature The temperature of the table point.
 * @param TemperatureDependentLimitTable <em>undocumented</em>
 */
case class TemperatureDependentLimitPoint
(
    override val sup: BasicElement,
    limitPercent: Double,
    temperature: Double,
    TemperatureDependentLimitTable: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TemperatureDependentLimitPoint] }
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
        "\t\t<cim:TemperatureDependentLimitPoint.limitPercent>" + limitPercent + "</cim:TemperatureDependentLimitPoint.limitPercent>\n" +
        "\t\t<cim:TemperatureDependentLimitPoint.temperature>" + temperature + "</cim:TemperatureDependentLimitPoint.temperature>\n" +
        (if (null != TemperatureDependentLimitTable) "\t\t<cim:TemperatureDependentLimitPoint.TemperatureDependentLimitTable rdf:resource=\"#" + TemperatureDependentLimitTable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TemperatureDependentLimitPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TemperatureDependentLimitPoint>"
    }
}

object TemperatureDependentLimitPoint
extends
    Parseable[TemperatureDependentLimitPoint]
{
    val limitPercent: (Context) => String = parse_element (element ("""TemperatureDependentLimitPoint.limitPercent"""))
    val temperature: (Context) => String = parse_element (element ("""TemperatureDependentLimitPoint.temperature"""))
    val TemperatureDependentLimitTable: (Context) => String = parse_attribute (attribute ("""TemperatureDependentLimitPoint.TemperatureDependentLimitTable"""))
    def parse (context: Context): TemperatureDependentLimitPoint =
    {
        TemperatureDependentLimitPoint(
            BasicElement.parse (context),
            toDouble (limitPercent (context), context),
            toDouble (temperature (context), context),
            TemperatureDependentLimitTable (context)
        )
    }
}

/**
 * This is a table lookup that provides limit values corresponding to a temperature input.
 * @param sup Reference to the superclass object.
 */
case class TemperatureDependentLimitTable
(
    override val sup: EnvironmentalDependentLimit
)
extends
    Element
{
    def this () = { this (null) }
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { clone ().asInstanceOf[TemperatureDependentLimitTable] }
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
        "\t<cim:TemperatureDependentLimitTable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TemperatureDependentLimitTable>"
    }
}

object TemperatureDependentLimitTable
extends
    Parseable[TemperatureDependentLimitTable]
{
    def parse (context: Context): TemperatureDependentLimitTable =
    {
        TemperatureDependentLimitTable(
            EnvironmentalDependentLimit.parse (context)
        )
    }
}

/**
 * This describes the coefficients of a polynomial function that has temperature as input and calculates limit values as output.
 * @param sup Reference to the superclass object.
 * @param coefficient0 The polinomial coefficent of power 0.
 * @param coefficient1 The polinomial coefficent of power 1.
 * @param coefficient2 The polinomial coefficent of power 2.
 * @param coefficient3 The polinomial coefficent of power 3.
 * @param coefficient4 The polinomial coefficent of power 4.
 */
case class TemperaturePolynomialLimit
(
    override val sup: EnvironmentalDependentLimit,
    coefficient0: Double,
    coefficient1: Double,
    coefficient2: Double,
    coefficient3: Double,
    coefficient4: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { clone ().asInstanceOf[TemperaturePolynomialLimit] }
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
        "\t\t<cim:TemperaturePolynomialLimit.coefficient0>" + coefficient0 + "</cim:TemperaturePolynomialLimit.coefficient0>\n" +
        "\t\t<cim:TemperaturePolynomialLimit.coefficient1>" + coefficient1 + "</cim:TemperaturePolynomialLimit.coefficient1>\n" +
        "\t\t<cim:TemperaturePolynomialLimit.coefficient2>" + coefficient2 + "</cim:TemperaturePolynomialLimit.coefficient2>\n" +
        "\t\t<cim:TemperaturePolynomialLimit.coefficient3>" + coefficient3 + "</cim:TemperaturePolynomialLimit.coefficient3>\n" +
        "\t\t<cim:TemperaturePolynomialLimit.coefficient4>" + coefficient4 + "</cim:TemperaturePolynomialLimit.coefficient4>\n"
    }
    override def export: String =
    {
        "\t<cim:TemperaturePolynomialLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TemperaturePolynomialLimit>"
    }
}

object TemperaturePolynomialLimit
extends
    Parseable[TemperaturePolynomialLimit]
{
    val coefficient0: (Context) => String = parse_element (element ("""TemperaturePolynomialLimit.coefficient0"""))
    val coefficient1: (Context) => String = parse_element (element ("""TemperaturePolynomialLimit.coefficient1"""))
    val coefficient2: (Context) => String = parse_element (element ("""TemperaturePolynomialLimit.coefficient2"""))
    val coefficient3: (Context) => String = parse_element (element ("""TemperaturePolynomialLimit.coefficient3"""))
    val coefficient4: (Context) => String = parse_element (element ("""TemperaturePolynomialLimit.coefficient4"""))
    def parse (context: Context): TemperaturePolynomialLimit =
    {
        TemperaturePolynomialLimit(
            EnvironmentalDependentLimit.parse (context),
            toDouble (coefficient0 (context), context),
            toDouble (coefficient1 (context), context),
            toDouble (coefficient2 (context), context),
            toDouble (coefficient3 (context), context),
            toDouble (coefficient4 (context), context)
        )
    }
}

/**
 * This represents a source of ambient temperature.
 * @param sup Reference to the superclass object.
 */
case class WeatherStation
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[WeatherStation] }
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
        "\t<cim:WeatherStation rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WeatherStation>"
    }
}

object WeatherStation
extends
    Parseable[WeatherStation]
{
    def parse (context: Context): WeatherStation =
    {
        WeatherStation(
            PowerSystemResource.parse (context)
        )
    }
}

private[ninecode] object _InfOperationalLimits
{
    def register: List[ClassInfo] =
    {
        List (
            EnvironmentalDependentLimit.register,
            EquipmentLimitSeriesComponent.register,
            LimitDependency.register,
            LimitScalingLimit.register,
            OperatonalLimitTypeScaling.register,
            ScheduledActivePowerLimitValue.register,
            ScheduledApparentPowerLimitValue.register,
            ScheduledCurrentLimitValue.register,
            ScheduledLimitDependency.register,
            ScheduledLimitValue.register,
            ScheduledVoltageLimitValue.register,
            SeriesEquipmentDependentLimit.register,
            TemperatureDependentLimitPoint.register,
            TemperatureDependentLimitTable.register,
            TemperaturePolynomialLimit.register,
            WeatherStation.register
        )
    }
}