package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * This package is responsible for modeling the energy consumers and the system load as curves and associated curve data.
 * Special circumstances that may affect the load, such as seasons and daytypes, are also included here.
 */

/**
 * ConformLoad represent loads that follow a daily load change pattern where the pattern can be used to scale the load with a system load.
 * @param sup Reference to the superclass object.
 * @param LoadGroup Group of this ConformLoad.
 */
case class ConformLoad
(
    override val sup: EnergyConsumer,
    LoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoad] }
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
        (if (null != LoadGroup) "\t\t<cim:ConformLoad.LoadGroup rdf:resource=\"#" + LoadGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConformLoad rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConformLoad>"
    }
}

object ConformLoad
extends
    Parseable[ConformLoad]
{
    val LoadGroup = parse_attribute (attribute ("""ConformLoad.LoadGroup"""))
    def parse (context: Context): ConformLoad =
    {
        ConformLoad(
            EnergyConsumer.parse (context),
            LoadGroup (context)
        )
    }
}

/**
 * A group of loads conforming to an allocation pattern.
 * @param sup Reference to the superclass object.
 */
case class ConformLoadGroup
(
    override val sup: LoadGroup
)
extends
    Element
{
    def this () = { this (null) }
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoadGroup] }
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
        "\t<cim:ConformLoadGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConformLoadGroup>"
    }
}

object ConformLoadGroup
extends
    Parseable[ConformLoadGroup]
{
    def parse (context: Context): ConformLoadGroup =
    {
        ConformLoadGroup(
            LoadGroup.parse (context)
        )
    }
}

/**
 * A curve of load  versus time (X-axis) showing the active power values (Y1-axis) and reactive power (Y2-axis) for each unit of the period covered.
 * This curve represents a typical pattern of load over the time period for a given day type and season.
 * @param sup Reference to the superclass object.
 * @param ConformLoadGroup The ConformLoadGroup where the ConformLoadSchedule belongs.
 */
case class ConformLoadSchedule
(
    override val sup: SeasonDayTypeSchedule,
    ConformLoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoadSchedule] }
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
        (if (null != ConformLoadGroup) "\t\t<cim:ConformLoadSchedule.ConformLoadGroup rdf:resource=\"#" + ConformLoadGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConformLoadSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConformLoadSchedule>"
    }
}

object ConformLoadSchedule
extends
    Parseable[ConformLoadSchedule]
{
    val ConformLoadGroup = parse_attribute (attribute ("""ConformLoadSchedule.ConformLoadGroup"""))
    def parse (context: Context): ConformLoadSchedule =
    {
        ConformLoadSchedule(
            SeasonDayTypeSchedule.parse (context),
            ConformLoadGroup (context)
        )
    }
}

/**
 * Group of similar days.
 * For example it could be used to represent weekdays, weekend, or holidays.
 * @param sup Reference to the superclass object.
 */
case class DayType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DayType] }
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
        "\t<cim:DayType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DayType>"
    }
}

object DayType
extends
    Parseable[DayType]
{
    def parse (context: Context): DayType =
    {
        DayType(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * Describes an area having energy production or consumption.
 * Specializations are intended to support the load allocation function as typically required in energy management systems or planning studies to allocate hypothesized load levels to individual load points for power flow analysis.  Often the energy area can be linked to both measured and forecast load levels.
 * @param sup Reference to the superclass object.
 * @param ControlArea The control area specification that is used for the load forecast.
 */
case class EnergyArea
(
    override val sup: IdentifiedObject,
    ControlArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnergyArea] }
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
        (if (null != ControlArea) "\t\t<cim:EnergyArea.ControlArea rdf:resource=\"#" + ControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyArea>"
    }
}

object EnergyArea
extends
    Parseable[EnergyArea]
{
    val ControlArea = parse_attribute (attribute ("""EnergyArea.ControlArea"""))
    def parse (context: Context): EnergyArea =
    {
        EnergyArea(
            IdentifiedObject.parse (context),
            ControlArea (context)
        )
    }
}

/**
 * The class is the root or first level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 * @param sup Reference to the superclass object.
 */
case class LoadArea
(
    override val sup: EnergyArea
)
extends
    Element
{
    def this () = { this (null) }
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { clone ().asInstanceOf[LoadArea] }
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
        "\t<cim:LoadArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadArea>"
    }
}

object LoadArea
extends
    Parseable[LoadArea]
{
    def parse (context: Context): LoadArea =
    {
        LoadArea(
            EnergyArea.parse (context)
        )
    }
}

/**
 * The class is the third level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 * @param sup Reference to the superclass object.
 * @param SubLoadArea The SubLoadArea where the Loadgroup belongs.
 */
case class LoadGroup
(
    override val sup: IdentifiedObject,
    SubLoadArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadGroup] }
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
        (if (null != SubLoadArea) "\t\t<cim:LoadGroup.SubLoadArea rdf:resource=\"#" + SubLoadArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadGroup>"
    }
}

object LoadGroup
extends
    Parseable[LoadGroup]
{
    val SubLoadArea = parse_attribute (attribute ("""LoadGroup.SubLoadArea"""))
    def parse (context: Context): LoadGroup =
    {
        LoadGroup(
            IdentifiedObject.parse (context),
            SubLoadArea (context)
        )
    }
}

/**
 * Models the characteristic response of the load demand due to changes in system conditions such as voltage and frequency.
 * This is not related to demand response.
 * @param sup Reference to the superclass object.
 * @param exponentModel Indicates the exponential voltage dependency model is to be used.
 *        If false, the coefficient model is to be used.
 * @param pConstantCurrent Portion of active power load modeled as constant current.
 * @param pConstantImpedance Portion of active power load modeled as constant impedance.
 * @param pConstantPower Portion of active power load modeled as constant power.
 * @param pFrequencyExponent Exponent of per unit frequency effecting active power.
 * @param pVoltageExponent Exponent of per unit voltage effecting real power.
 * @param qConstantCurrent Portion of reactive power load modeled as constant current.
 * @param qConstantImpedance Portion of reactive power load modeled as constant impedance.
 * @param qConstantPower Portion of reactive power load modeled as constant power.
 * @param qFrequencyExponent Exponent of per unit frequency effecting reactive power.
 * @param qVoltageExponent Exponent of per unit voltage effecting reactive power.
 */
case class LoadResponseCharacteristic
(
    override val sup: IdentifiedObject,
    exponentModel: Boolean,
    pConstantCurrent: Double,
    pConstantImpedance: Double,
    pConstantPower: Double,
    pFrequencyExponent: Double,
    pVoltageExponent: Double,
    qConstantCurrent: Double,
    qConstantImpedance: Double,
    qConstantPower: Double,
    qFrequencyExponent: Double,
    qVoltageExponent: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadResponseCharacteristic] }
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
        "\t\t<cim:LoadResponseCharacteristic.exponentModel>" + exponentModel + "</cim:LoadResponseCharacteristic.exponentModel>\n" +
        "\t\t<cim:LoadResponseCharacteristic.pConstantCurrent>" + pConstantCurrent + "</cim:LoadResponseCharacteristic.pConstantCurrent>\n" +
        "\t\t<cim:LoadResponseCharacteristic.pConstantImpedance>" + pConstantImpedance + "</cim:LoadResponseCharacteristic.pConstantImpedance>\n" +
        "\t\t<cim:LoadResponseCharacteristic.pConstantPower>" + pConstantPower + "</cim:LoadResponseCharacteristic.pConstantPower>\n" +
        "\t\t<cim:LoadResponseCharacteristic.pFrequencyExponent>" + pFrequencyExponent + "</cim:LoadResponseCharacteristic.pFrequencyExponent>\n" +
        "\t\t<cim:LoadResponseCharacteristic.pVoltageExponent>" + pVoltageExponent + "</cim:LoadResponseCharacteristic.pVoltageExponent>\n" +
        "\t\t<cim:LoadResponseCharacteristic.qConstantCurrent>" + qConstantCurrent + "</cim:LoadResponseCharacteristic.qConstantCurrent>\n" +
        "\t\t<cim:LoadResponseCharacteristic.qConstantImpedance>" + qConstantImpedance + "</cim:LoadResponseCharacteristic.qConstantImpedance>\n" +
        "\t\t<cim:LoadResponseCharacteristic.qConstantPower>" + qConstantPower + "</cim:LoadResponseCharacteristic.qConstantPower>\n" +
        "\t\t<cim:LoadResponseCharacteristic.qFrequencyExponent>" + qFrequencyExponent + "</cim:LoadResponseCharacteristic.qFrequencyExponent>\n" +
        "\t\t<cim:LoadResponseCharacteristic.qVoltageExponent>" + qVoltageExponent + "</cim:LoadResponseCharacteristic.qVoltageExponent>\n"
    }
    override def export: String =
    {
        "\t<cim:LoadResponseCharacteristic rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadResponseCharacteristic>"
    }
}

object LoadResponseCharacteristic
extends
    Parseable[LoadResponseCharacteristic]
{
    val exponentModel = parse_element (element ("""LoadResponseCharacteristic.exponentModel"""))
    val pConstantCurrent = parse_element (element ("""LoadResponseCharacteristic.pConstantCurrent"""))
    val pConstantImpedance = parse_element (element ("""LoadResponseCharacteristic.pConstantImpedance"""))
    val pConstantPower = parse_element (element ("""LoadResponseCharacteristic.pConstantPower"""))
    val pFrequencyExponent = parse_element (element ("""LoadResponseCharacteristic.pFrequencyExponent"""))
    val pVoltageExponent = parse_element (element ("""LoadResponseCharacteristic.pVoltageExponent"""))
    val qConstantCurrent = parse_element (element ("""LoadResponseCharacteristic.qConstantCurrent"""))
    val qConstantImpedance = parse_element (element ("""LoadResponseCharacteristic.qConstantImpedance"""))
    val qConstantPower = parse_element (element ("""LoadResponseCharacteristic.qConstantPower"""))
    val qFrequencyExponent = parse_element (element ("""LoadResponseCharacteristic.qFrequencyExponent"""))
    val qVoltageExponent = parse_element (element ("""LoadResponseCharacteristic.qVoltageExponent"""))
    def parse (context: Context): LoadResponseCharacteristic =
    {
        LoadResponseCharacteristic(
            IdentifiedObject.parse (context),
            toBoolean (exponentModel (context), context),
            toDouble (pConstantCurrent (context), context),
            toDouble (pConstantImpedance (context), context),
            toDouble (pConstantPower (context), context),
            toDouble (pFrequencyExponent (context), context),
            toDouble (pVoltageExponent (context), context),
            toDouble (qConstantCurrent (context), context),
            toDouble (qConstantImpedance (context), context),
            toDouble (qConstantPower (context), context),
            toDouble (qFrequencyExponent (context), context),
            toDouble (qVoltageExponent (context), context)
        )
    }
}

/**
 * NonConformLoad represent loads that do not follow a daily load change pattern and changes are not correlated with the daily load change pattern.
 * @param sup Reference to the superclass object.
 * @param LoadGroup Group of this ConformLoad.
 */
case class NonConformLoad
(
    override val sup: EnergyConsumer,
    LoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoad] }
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
        (if (null != LoadGroup) "\t\t<cim:NonConformLoad.LoadGroup rdf:resource=\"#" + LoadGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NonConformLoad rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonConformLoad>"
    }
}

object NonConformLoad
extends
    Parseable[NonConformLoad]
{
    val LoadGroup = parse_attribute (attribute ("""NonConformLoad.LoadGroup"""))
    def parse (context: Context): NonConformLoad =
    {
        NonConformLoad(
            EnergyConsumer.parse (context),
            LoadGroup (context)
        )
    }
}

/**
 * Loads that do not follow a daily and seasonal load variation pattern.
 * @param sup Reference to the superclass object.
 */
case class NonConformLoadGroup
(
    override val sup: LoadGroup
)
extends
    Element
{
    def this () = { this (null) }
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoadGroup] }
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
        "\t<cim:NonConformLoadGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonConformLoadGroup>"
    }
}

object NonConformLoadGroup
extends
    Parseable[NonConformLoadGroup]
{
    def parse (context: Context): NonConformLoadGroup =
    {
        NonConformLoadGroup(
            LoadGroup.parse (context)
        )
    }
}

/**
 * An active power (Y1-axis) and reactive power (Y2-axis) schedule (curves) versus time (X-axis) for non-conforming loads, e.g., large industrial load or power station service (where modeled).
 * @param sup Reference to the superclass object.
 * @param NonConformLoadGroup The NonConformLoadGroup where the NonConformLoadSchedule belongs.
 */
case class NonConformLoadSchedule
(
    override val sup: SeasonDayTypeSchedule,
    NonConformLoadGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoadSchedule] }
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
        (if (null != NonConformLoadGroup) "\t\t<cim:NonConformLoadSchedule.NonConformLoadGroup rdf:resource=\"#" + NonConformLoadGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NonConformLoadSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NonConformLoadSchedule>"
    }
}

object NonConformLoadSchedule
extends
    Parseable[NonConformLoadSchedule]
{
    val NonConformLoadGroup = parse_attribute (attribute ("""NonConformLoadSchedule.NonConformLoadGroup"""))
    def parse (context: Context): NonConformLoadSchedule =
    {
        NonConformLoadSchedule(
            SeasonDayTypeSchedule.parse (context),
            NonConformLoadGroup (context)
        )
    }
}

/**
 * An area or zone of the power system which is used for load shedding purposes.
 * @param sup Reference to the superclass object.
 * @param cutLevel1 First level (amount) of load to cut as a percentage of total zone load.
 * @param cutLevel2 Second level (amount) of load to cut as a percentage of total zone load.
 */
case class PowerCutZone
(
    override val sup: PowerSystemResource,
    cutLevel1: Double,
    cutLevel2: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[PowerCutZone] }
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
        "\t\t<cim:PowerCutZone.cutLevel1>" + cutLevel1 + "</cim:PowerCutZone.cutLevel1>\n" +
        "\t\t<cim:PowerCutZone.cutLevel2>" + cutLevel2 + "</cim:PowerCutZone.cutLevel2>\n"
    }
    override def export: String =
    {
        "\t<cim:PowerCutZone rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerCutZone>"
    }
}

object PowerCutZone
extends
    Parseable[PowerCutZone]
{
    val cutLevel1 = parse_element (element ("""PowerCutZone.cutLevel1"""))
    val cutLevel2 = parse_element (element ("""PowerCutZone.cutLevel2"""))
    def parse (context: Context): PowerCutZone =
    {
        PowerCutZone(
            PowerSystemResource.parse (context),
            toDouble (cutLevel1 (context), context),
            toDouble (cutLevel2 (context), context)
        )
    }
}

/**
 * A specified time period of the year.
 * @param sup Reference to the superclass object.
 * @param endDate Date season ends.
 * @param startDate Date season starts.
 */
case class Season
(
    override val sup: IdentifiedObject,
    endDate: String,
    startDate: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Season] }
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
        (if (null != endDate) "\t\t<cim:Season.endDate>" + endDate + "</cim:Season.endDate>\n" else "") +
        (if (null != startDate) "\t\t<cim:Season.startDate>" + startDate + "</cim:Season.startDate>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Season rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Season>"
    }
}

object Season
extends
    Parseable[Season]
{
    val endDate = parse_element (element ("""Season.endDate"""))
    val startDate = parse_element (element ("""Season.startDate"""))
    def parse (context: Context): Season =
    {
        Season(
            IdentifiedObject.parse (context),
            endDate (context),
            startDate (context)
        )
    }
}

/**
 * A time schedule covering a 24 hour period, with curve data for a specific type of season and day.
 * @param sup Reference to the superclass object.
 * @param DayType DayType for the Schedule.
 * @param Season Season for the Schedule.
 */
case class SeasonDayTypeSchedule
(
    override val sup: RegularIntervalSchedule,
    DayType: String,
    Season: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[SeasonDayTypeSchedule] }
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
        (if (null != DayType) "\t\t<cim:SeasonDayTypeSchedule.DayType rdf:resource=\"#" + DayType + "\"/>\n" else "") +
        (if (null != Season) "\t\t<cim:SeasonDayTypeSchedule.Season rdf:resource=\"#" + Season + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SeasonDayTypeSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SeasonDayTypeSchedule>"
    }
}

object SeasonDayTypeSchedule
extends
    Parseable[SeasonDayTypeSchedule]
{
    val DayType = parse_attribute (attribute ("""SeasonDayTypeSchedule.DayType"""))
    val Season = parse_attribute (attribute ("""SeasonDayTypeSchedule.Season"""))
    def parse (context: Context): SeasonDayTypeSchedule =
    {
        SeasonDayTypeSchedule(
            RegularIntervalSchedule.parse (context),
            DayType (context),
            Season (context)
        )
    }
}

/**
 * Station supply with load derived from the station output.
 * @param sup Reference to the superclass object.
 */
case class StationSupply
(
    override val sup: EnergyConsumer
)
extends
    Element
{
    def this () = { this (null) }
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[StationSupply] }
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
        "\t<cim:StationSupply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StationSupply>"
    }
}

object StationSupply
extends
    Parseable[StationSupply]
{
    def parse (context: Context): StationSupply =
    {
        StationSupply(
            EnergyConsumer.parse (context)
        )
    }
}

/**
 * The class is the second level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 * @param sup Reference to the superclass object.
 * @param LoadArea The LoadArea where the SubLoadArea belongs.
 */
case class SubLoadArea
(
    override val sup: EnergyArea,
    LoadArea: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { clone ().asInstanceOf[SubLoadArea] }
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
        (if (null != LoadArea) "\t\t<cim:SubLoadArea.LoadArea rdf:resource=\"#" + LoadArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SubLoadArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SubLoadArea>"
    }
}

object SubLoadArea
extends
    Parseable[SubLoadArea]
{
    val LoadArea = parse_attribute (attribute ("""SubLoadArea.LoadArea"""))
    def parse (context: Context): SubLoadArea =
    {
        SubLoadArea(
            EnergyArea.parse (context),
            LoadArea (context)
        )
    }
}

private[ninecode] object _LoadModel
{
    def register: List[ClassInfo] =
    {
        List (
            ConformLoad.register,
            ConformLoadGroup.register,
            ConformLoadSchedule.register,
            DayType.register,
            EnergyArea.register,
            LoadArea.register,
            LoadGroup.register,
            LoadResponseCharacteristic.register,
            NonConformLoad.register,
            NonConformLoadGroup.register,
            NonConformLoadSchedule.register,
            PowerCutZone.register,
            Season.register,
            SeasonDayTypeSchedule.register,
            StationSupply.register,
            SubLoadArea.register
        )
    }
}