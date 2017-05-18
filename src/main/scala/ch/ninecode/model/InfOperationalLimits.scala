package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

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
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { return (clone ().asInstanceOf[EnvironmentalDependentLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnvironmentalDependentLimit
extends
    Parseable[EnvironmentalDependentLimit]
{
    val sup = LimitDependency.parse _
    def parse (context: Context): EnvironmentalDependentLimit =
    {
        EnvironmentalDependentLimit(
            sup (context)
        )
    }
}

/**
 * This represents one instance of an equipment that contributes to the calculation of an operational limit.
 * @param sup Reference to the superclass object.
 * @param Equipment Equipment contributing toward the series limit.
 *        The reference here is to Equipment rather than a specific limit on the equipment so the grouiping can be reused for multiple limits of different types on the same instance of equipment.
 */
case class EquipmentLimitSeriesComponent
(
    override val sup: Element,
    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentLimitSeriesComponent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentLimitSeriesComponent
extends
    Parseable[EquipmentLimitSeriesComponent]
{
    val sup = IdentifiedObject.parse _
    val Equipment = parse_attribute (attribute ("""EquipmentLimitSeriesComponent.Equipment"""))_
    def parse (context: Context): EquipmentLimitSeriesComponent =
    {
        EquipmentLimitSeriesComponent(
            sup (context),
            Equipment (context)
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
    override val sup: Element,
    val Equipment: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LimitDependency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LimitDependency
extends
    Parseable[LimitDependency]
{
    val sup = IdentifiedObject.parse _
    val Equipment = parse_attribute (attribute ("""LimitDependency.Equipment"""))_
    def parse (context: Context): LimitDependency =
    {
        LimitDependency(
            sup (context),
            Equipment (context)
        )
    }
}

/**
 * Specifies an operational  limit is calculated by scaling another operational limit.
 * @param sup Reference to the superclass object.
 * @param limitScalingPercent The associated source limit is scaled by this value to compute the limit of the dependency model.
 * @param SourceOperationalLimit
 */
case class LimitScalingLimit
(
    override val sup: Element,
    val limitScalingPercent: Double,
    val SourceOperationalLimit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { return (clone ().asInstanceOf[LimitScalingLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LimitScalingLimit
extends
    Parseable[LimitScalingLimit]
{
    val sup = LimitDependency.parse _
    val limitScalingPercent = parse_element (element ("""LimitScalingLimit.limitScalingPercent"""))_
    val SourceOperationalLimit = parse_attribute (attribute ("""LimitScalingLimit.SourceOperationalLimit"""))_
    def parse (context: Context): LimitScalingLimit =
    {
        LimitScalingLimit(
            sup (context),
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
 * @param SourceOperationalLimitType
 * @param TargetOperationalLimit
 */
case class OperatonalLimitTypeScaling
(
    override val sup: Element,
    val scalingPercent: Double,
    val SourceOperationalLimitType: String,
    val TargetOperationalLimit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OperatonalLimitTypeScaling]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperatonalLimitTypeScaling
extends
    Parseable[OperatonalLimitTypeScaling]
{
    val sup = BasicElement.parse _
    val scalingPercent = parse_element (element ("""OperatonalLimitTypeScaling.scalingPercent"""))_
    val SourceOperationalLimitType = parse_attribute (attribute ("""OperatonalLimitTypeScaling.SourceOperationalLimitType"""))_
    val TargetOperationalLimit = parse_attribute (attribute ("""OperatonalLimitTypeScaling.TargetOperationalLimit"""))_
    def parse (context: Context): OperatonalLimitTypeScaling =
    {
        OperatonalLimitTypeScaling(
            sup (context),
            toDouble (scalingPercent (context), context),
            SourceOperationalLimitType (context),
            TargetOperationalLimit (context)
        )
    }
}

case class ScheduledActivePowerLimitValue
(
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledActivePowerLimitValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledActivePowerLimitValue
extends
    Parseable[ScheduledActivePowerLimitValue]
{
    val sup = ScheduledLimitValue.parse _
    val value = parse_element (element ("""ScheduledActivePowerLimitValue.value"""))_
    def parse (context: Context): ScheduledActivePowerLimitValue =
    {
        ScheduledActivePowerLimitValue(
            sup (context),
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
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledApparentPowerLimitValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledApparentPowerLimitValue
extends
    Parseable[ScheduledApparentPowerLimitValue]
{
    val sup = ScheduledLimitValue.parse _
    val value = parse_element (element ("""ScheduledApparentPowerLimitValue.value"""))_
    def parse (context: Context): ScheduledApparentPowerLimitValue =
    {
        ScheduledApparentPowerLimitValue(
            sup (context),
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
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledCurrentLimitValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledCurrentLimitValue
extends
    Parseable[ScheduledCurrentLimitValue]
{
    val sup = ScheduledLimitValue.parse _
    val value = parse_element (element ("""ScheduledCurrentLimitValue.value"""))_
    def parse (context: Context): ScheduledCurrentLimitValue =
    {
        ScheduledCurrentLimitValue(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

case class ScheduledLimitDependency
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledLimitDependency]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledLimitDependency
extends
    Parseable[ScheduledLimitDependency]
{
    val sup = LimitDependency.parse _
    def parse (context: Context): ScheduledLimitDependency =
    {
        ScheduledLimitDependency(
            sup (context)
        )
    }
}

/**
 * A limit that is applicable during a scheduled time period.
 * @param sup Reference to the superclass object.
 * @param Season The season for which the scheduled limits applies.
 *        If not specified, then applicable ot any season.
 */
case class ScheduledLimitValue
(
    override val sup: Element,
    val Season: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledLimitValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledLimitValue
extends
    Parseable[ScheduledLimitValue]
{
    val sup = IdentifiedObject.parse _
    val Season = parse_attribute (attribute ("""ScheduledLimitValue.Season"""))_
    def parse (context: Context): ScheduledLimitValue =
    {
        ScheduledLimitValue(
            sup (context),
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
    override val sup: Element,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def ScheduledLimitValue: ScheduledLimitValue = sup.asInstanceOf[ScheduledLimitValue]
    override def copy (): Row = { return (clone ().asInstanceOf[ScheduledVoltageLimitValue]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ScheduledVoltageLimitValue
extends
    Parseable[ScheduledVoltageLimitValue]
{
    val sup = ScheduledLimitValue.parse _
    val value = parse_element (element ("""ScheduledVoltageLimitValue.value"""))_
    def parse (context: Context): ScheduledVoltageLimitValue =
    {
        ScheduledVoltageLimitValue(
            sup (context),
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
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def LimitDependency: LimitDependency = sup.asInstanceOf[LimitDependency]
    override def copy (): Row = { return (clone ().asInstanceOf[SeriesEquipmentDependentLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SeriesEquipmentDependentLimit
extends
    Parseable[SeriesEquipmentDependentLimit]
{
    val sup = LimitDependency.parse _
    def parse (context: Context): SeriesEquipmentDependentLimit =
    {
        SeriesEquipmentDependentLimit(
            sup (context)
        )
    }
}

/**
 * A point on a table of limit verses temperature.
 * @param sup Reference to the superclass object.
 * @param limitPercent The scaling of the operational limit in percent.
 * @param temperature The temperature of the table point.
 */
case class TemperatureDependentLimitPoint
(
    override val sup: Element,
    val limitPercent: Double,
    val temperature: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TemperatureDependentLimitPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TemperatureDependentLimitPoint
extends
    Parseable[TemperatureDependentLimitPoint]
{
    val sup = BasicElement.parse _
    val limitPercent = parse_element (element ("""TemperatureDependentLimitPoint.limitPercent"""))_
    val temperature = parse_element (element ("""TemperatureDependentLimitPoint.temperature"""))_
    def parse (context: Context): TemperatureDependentLimitPoint =
    {
        TemperatureDependentLimitPoint(
            sup (context),
            toDouble (limitPercent (context), context),
            toDouble (temperature (context), context)
        )
    }
}

/**
 * This is a table lookup that provides limit values corresponding to a temperature input.
 * @param sup Reference to the superclass object.
 */
case class TemperatureDependentLimitTable
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[TemperatureDependentLimitTable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TemperatureDependentLimitTable
extends
    Parseable[TemperatureDependentLimitTable]
{
    val sup = EnvironmentalDependentLimit.parse _
    def parse (context: Context): TemperatureDependentLimitTable =
    {
        TemperatureDependentLimitTable(
            sup (context)
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
    override val sup: Element,
    val coefficient0: Double,
    val coefficient1: Double,
    val coefficient2: Double,
    val coefficient3: Double,
    val coefficient4: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def EnvironmentalDependentLimit: EnvironmentalDependentLimit = sup.asInstanceOf[EnvironmentalDependentLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[TemperaturePolynomialLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TemperaturePolynomialLimit
extends
    Parseable[TemperaturePolynomialLimit]
{
    val sup = EnvironmentalDependentLimit.parse _
    val coefficient0 = parse_element (element ("""TemperaturePolynomialLimit.coefficient0"""))_
    val coefficient1 = parse_element (element ("""TemperaturePolynomialLimit.coefficient1"""))_
    val coefficient2 = parse_element (element ("""TemperaturePolynomialLimit.coefficient2"""))_
    val coefficient3 = parse_element (element ("""TemperaturePolynomialLimit.coefficient3"""))_
    val coefficient4 = parse_element (element ("""TemperaturePolynomialLimit.coefficient4"""))_
    def parse (context: Context): TemperaturePolynomialLimit =
    {
        TemperaturePolynomialLimit(
            sup (context),
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
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[WeatherStation]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WeatherStation
extends
    Parseable[WeatherStation]
{
    val sup = PowerSystemResource.parse _
    def parse (context: Context): WeatherStation =
    {
        WeatherStation(
            sup (context)
        )
    }
}

object _InfOperationalLimits
{
    def register: Unit =
    {
        EnvironmentalDependentLimit.register
        EquipmentLimitSeriesComponent.register
        LimitDependency.register
        LimitScalingLimit.register
        OperatonalLimitTypeScaling.register
        ScheduledActivePowerLimitValue.register
        ScheduledApparentPowerLimitValue.register
        ScheduledCurrentLimitValue.register
        ScheduledLimitDependency.register
        ScheduledLimitValue.register
        ScheduledVoltageLimitValue.register
        SeriesEquipmentDependentLimit.register
        TemperatureDependentLimitPoint.register
        TemperatureDependentLimitTable.register
        TemperaturePolynomialLimit.register
        WeatherStation.register
    }
}