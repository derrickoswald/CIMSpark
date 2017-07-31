package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.CIMSubsetter
import ch.ninecode.cim.Parseable

/**
 * The production package is responsible for classes which describe various kinds of generators.
 * These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */

/**
 * Combustion turbine air compressor which is an integral part of a compressed air energy storage (CAES) plant.
 * @param sup Reference to the superclass object.
 * @param airCompressorRating Rating of the CAES air compressor.
 * @param CAESPlant An air compressor may be a member of a compressed air energy storage plant.
 * @param CombustionTurbine A CAES air compressor is driven by combustion turbine.
 */
case class AirCompressor
(
    override val sup: PowerSystemResource,
    val airCompressorRating: Double,
    val CAESPlant: String,
    val CombustionTurbine: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[AirCompressor] }
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
        "\t\t<cim:AirCompressor.airCompressorRating>" + airCompressorRating + "</cim:AirCompressor.airCompressorRating>\n" +
        (if (null != CAESPlant) "\t\t<cim:AirCompressor.CAESPlant rdf:resource=\"#" + CAESPlant + "\"/>\n" else "") +
        (if (null != CombustionTurbine) "\t\t<cim:AirCompressor.CombustionTurbine rdf:resource=\"#" + CombustionTurbine + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AirCompressor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AirCompressor>\n"
    }
}

object AirCompressor
extends
    Parseable[AirCompressor]
{
    val airCompressorRating = parse_element (element ("""AirCompressor.airCompressorRating"""))
    val CAESPlant = parse_attribute (attribute ("""AirCompressor.CAESPlant"""))
    val CombustionTurbine = parse_attribute (attribute ("""AirCompressor.CombustionTurbine"""))
    def parse (context: Context): AirCompressor =
    {
        AirCompressor(
            PowerSystemResource.parse (context),
            toDouble (airCompressorRating (context), context),
            CAESPlant (context),
            CombustionTurbine (context)
        )
    }
}

/**
 * Compressed air energy storage plant.
 * @param sup Reference to the superclass object.
 * @param energyStorageCapacity The rated energy storage capacity.
 * @param ratedCapacityP The CAES plant's gross rated generating capacity.
 * @param AirCompressor An air compressor may be a member of a compressed air energy storage plant.
 * @param ThermalGeneratingUnit A thermal generating unit may be a member of a compressed air energy storage plant.
 */
case class CAESPlant
(
    override val sup: PowerSystemResource,
    val energyStorageCapacity: Double,
    val ratedCapacityP: Double,
    val AirCompressor: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CAESPlant] }
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
        "\t\t<cim:CAESPlant.energyStorageCapacity>" + energyStorageCapacity + "</cim:CAESPlant.energyStorageCapacity>\n" +
        "\t\t<cim:CAESPlant.ratedCapacityP>" + ratedCapacityP + "</cim:CAESPlant.ratedCapacityP>\n" +
        (if (null != AirCompressor) "\t\t<cim:CAESPlant.AirCompressor rdf:resource=\"#" + AirCompressor + "\"/>\n" else "") +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:CAESPlant.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CAESPlant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CAESPlant>\n"
    }
}

object CAESPlant
extends
    Parseable[CAESPlant]
{
    val energyStorageCapacity = parse_element (element ("""CAESPlant.energyStorageCapacity"""))
    val ratedCapacityP = parse_element (element ("""CAESPlant.ratedCapacityP"""))
    val AirCompressor = parse_attribute (attribute ("""CAESPlant.AirCompressor"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""CAESPlant.ThermalGeneratingUnit"""))
    def parse (context: Context): CAESPlant =
    {
        CAESPlant(
            PowerSystemResource.parse (context),
            toDouble (energyStorageCapacity (context), context),
            toDouble (ratedCapacityP (context), context),
            AirCompressor (context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Classification of level.
 * Specify as 1..n, with 1 being the most detailed, highest priority, etc as described on the attribue using this data type.
 * @param sup Reference to the superclass object.
 * @param multiplier
 * @param unit
 * @param value
 */
case class Classification
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
    override def copy (): Row = { clone ().asInstanceOf[Classification] }
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
        (if (null != multiplier) "\t\t<cim:Classification.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:Classification.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:Classification.value>" + value + "</cim:Classification.value>\n"
    }
    override def export: String =
    {
        "\t<cim:Classification rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Classification>\n"
    }
}

object Classification
extends
    Parseable[Classification]
{
    val multiplier = parse_attribute (attribute ("""Classification.multiplier"""))
    val unit = parse_attribute (attribute ("""Classification.unit"""))
    val value = parse_element (element ("""Classification.value"""))
    def parse (context: Context): Classification =
    {
        Classification(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            toInteger (value (context), context)
        )
    }
}

/**
 * A set of thermal generating units for the production of electrical energy and process steam (usually from the output of the steam turbines).
 * The steam sendout is typically used for industrial purposes or for municipal heating and cooling.
 * @param sup Reference to the superclass object.
 * @param cogenHPSendoutRating The high pressure steam sendout.
 * @param cogenHPSteamRating The high pressure steam rating.
 * @param cogenLPSendoutRating The low pressure steam sendout.
 * @param cogenLPSteamRating The low pressure steam rating.
 * @param ratedP The rated output active power of the cogeneration plant.
 * @param SteamSendoutSchedule A cogeneration plant has a steam sendout schedule.
 */
case class CogenerationPlant
(
    override val sup: PowerSystemResource,
    val cogenHPSendoutRating: Double,
    val cogenHPSteamRating: Double,
    val cogenLPSendoutRating: Double,
    val cogenLPSteamRating: Double,
    val ratedP: Double,
    val SteamSendoutSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CogenerationPlant] }
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
        "\t\t<cim:CogenerationPlant.cogenHPSendoutRating>" + cogenHPSendoutRating + "</cim:CogenerationPlant.cogenHPSendoutRating>\n" +
        "\t\t<cim:CogenerationPlant.cogenHPSteamRating>" + cogenHPSteamRating + "</cim:CogenerationPlant.cogenHPSteamRating>\n" +
        "\t\t<cim:CogenerationPlant.cogenLPSendoutRating>" + cogenLPSendoutRating + "</cim:CogenerationPlant.cogenLPSendoutRating>\n" +
        "\t\t<cim:CogenerationPlant.cogenLPSteamRating>" + cogenLPSteamRating + "</cim:CogenerationPlant.cogenLPSteamRating>\n" +
        "\t\t<cim:CogenerationPlant.ratedP>" + ratedP + "</cim:CogenerationPlant.ratedP>\n" +
        (if (null != SteamSendoutSchedule) "\t\t<cim:CogenerationPlant.SteamSendoutSchedule rdf:resource=\"#" + SteamSendoutSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CogenerationPlant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CogenerationPlant>\n"
    }
}

object CogenerationPlant
extends
    Parseable[CogenerationPlant]
{
    val cogenHPSendoutRating = parse_element (element ("""CogenerationPlant.cogenHPSendoutRating"""))
    val cogenHPSteamRating = parse_element (element ("""CogenerationPlant.cogenHPSteamRating"""))
    val cogenLPSendoutRating = parse_element (element ("""CogenerationPlant.cogenLPSendoutRating"""))
    val cogenLPSteamRating = parse_element (element ("""CogenerationPlant.cogenLPSteamRating"""))
    val ratedP = parse_element (element ("""CogenerationPlant.ratedP"""))
    val SteamSendoutSchedule = parse_attribute (attribute ("""CogenerationPlant.SteamSendoutSchedule"""))
    def parse (context: Context): CogenerationPlant =
    {
        CogenerationPlant(
            PowerSystemResource.parse (context),
            toDouble (cogenHPSendoutRating (context), context),
            toDouble (cogenHPSteamRating (context), context),
            toDouble (cogenLPSendoutRating (context), context),
            toDouble (cogenLPSteamRating (context), context),
            toDouble (ratedP (context), context),
            SteamSendoutSchedule (context)
        )
    }
}

/**
 * A set of combustion turbines and steam turbines where the exhaust heat from the combustion turbines is recovered to make steam for the steam turbines, resulting in greater overall plant efficiency.
 * @param sup Reference to the superclass object.
 * @param combCyclePlantRating The combined cycle plant's active power output rating.
 */
case class CombinedCyclePlant
(
    override val sup: PowerSystemResource,
    val combCyclePlantRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[CombinedCyclePlant] }
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
        "\t\t<cim:CombinedCyclePlant.combCyclePlantRating>" + combCyclePlantRating + "</cim:CombinedCyclePlant.combCyclePlantRating>\n"
    }
    override def export: String =
    {
        "\t<cim:CombinedCyclePlant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombinedCyclePlant>\n"
    }
}

object CombinedCyclePlant
extends
    Parseable[CombinedCyclePlant]
{
    val combCyclePlantRating = parse_element (element ("""CombinedCyclePlant.combCyclePlantRating"""))
    def parse (context: Context): CombinedCyclePlant =
    {
        CombinedCyclePlant(
            PowerSystemResource.parse (context),
            toDouble (combCyclePlantRating (context), context)
        )
    }
}

/**
 * Cost, in units of currency, per quantity of heat generated.
 * @param sup Reference to the superclass object.
 * @param denominatorMultiplier
 * @param denominatorUnit
 * @param multiplier
 * @param unit
 * @param value
 */
case class CostPerHeatUnit
(
    override val sup: BasicElement,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CostPerHeatUnit] }
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
        (if (null != denominatorMultiplier) "\t\t<cim:CostPerHeatUnit.denominatorMultiplier rdf:resource=\"#" + denominatorMultiplier + "\"/>\n" else "") +
        (if (null != denominatorUnit) "\t\t<cim:CostPerHeatUnit.denominatorUnit rdf:resource=\"#" + denominatorUnit + "\"/>\n" else "") +
        (if (null != multiplier) "\t\t<cim:CostPerHeatUnit.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:CostPerHeatUnit.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:CostPerHeatUnit.value>" + value + "</cim:CostPerHeatUnit.value>\n"
    }
    override def export: String =
    {
        "\t<cim:CostPerHeatUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CostPerHeatUnit>\n"
    }
}

object CostPerHeatUnit
extends
    Parseable[CostPerHeatUnit]
{
    val denominatorMultiplier = parse_attribute (attribute ("""CostPerHeatUnit.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""CostPerHeatUnit.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""CostPerHeatUnit.multiplier"""))
    val unit = parse_attribute (attribute ("""CostPerHeatUnit.unit"""))
    val value = parse_element (element ("""CostPerHeatUnit.value"""))
    def parse (context: Context): CostPerHeatUnit =
    {
        CostPerHeatUnit(
            BasicElement.parse (context),
            denominatorMultiplier (context),
            denominatorUnit (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Quantity of emission per fuel heat content.
 * @param sup Reference to the superclass object.
 * @param denominatorMultiplier
 * @param denominatorUnit
 * @param multiplier
 * @param unit
 * @param value
 */
case class Emission
(
    override val sup: BasicElement,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Emission] }
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
        (if (null != denominatorMultiplier) "\t\t<cim:Emission.denominatorMultiplier rdf:resource=\"#" + denominatorMultiplier + "\"/>\n" else "") +
        (if (null != denominatorUnit) "\t\t<cim:Emission.denominatorUnit rdf:resource=\"#" + denominatorUnit + "\"/>\n" else "") +
        (if (null != multiplier) "\t\t<cim:Emission.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:Emission.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:Emission.value>" + value + "</cim:Emission.value>\n"
    }
    override def export: String =
    {
        "\t<cim:Emission rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Emission>\n"
    }
}

object Emission
extends
    Parseable[Emission]
{
    val denominatorMultiplier = parse_attribute (attribute ("""Emission.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""Emission.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""Emission.multiplier"""))
    val unit = parse_attribute (attribute ("""Emission.unit"""))
    val value = parse_element (element ("""Emission.value"""))
    def parse (context: Context): Emission =
    {
        Emission(
            BasicElement.parse (context),
            denominatorMultiplier (context),
            denominatorUnit (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Accounts for tracking emissions usage and credits for thermal generating units.
 * A unit may have zero or more emission accounts, and will typically have one for tracking usage and one for tracking credits.
 * @param sup Reference to the superclass object.
 * @param emissionType The type of emission, for example sulfur dioxide (SO2).
 *        The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
 * @param emissionValueSource The source of the emission value.
 * @param ThermalGeneratingUnit A thermal generating unit may have one or more emission allowance accounts.
 */
case class EmissionAccount
(
    override val sup: Curve,
    val emissionType: String,
    val emissionValueSource: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[EmissionAccount] }
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
        (if (null != emissionType) "\t\t<cim:EmissionAccount.emissionType rdf:resource=\"#" + emissionType + "\"/>\n" else "") +
        (if (null != emissionValueSource) "\t\t<cim:EmissionAccount.emissionValueSource rdf:resource=\"#" + emissionValueSource + "\"/>\n" else "") +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:EmissionAccount.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EmissionAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EmissionAccount>\n"
    }
}

object EmissionAccount
extends
    Parseable[EmissionAccount]
{
    val emissionType = parse_attribute (attribute ("""EmissionAccount.emissionType"""))
    val emissionValueSource = parse_attribute (attribute ("""EmissionAccount.emissionValueSource"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionAccount.ThermalGeneratingUnit"""))
    def parse (context: Context): EmissionAccount =
    {
        EmissionAccount(
            Curve.parse (context),
            emissionType (context),
            emissionValueSource (context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Relationship between the unit's emission rate in units of mass per hour (Y-axis) and output active power (X-axis) for a given type of emission.
 * This curve applies when only one type of fuel is being burned.
 * @param sup Reference to the superclass object.
 * @param emissionContent The emission content per quantity of fuel burned.
 * @param emissionType The type of emission, which also gives the production rate measurement unit.
 *        The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit A thermal generating unit may have  one or more emission curves.
 */
case class EmissionCurve
(
    override val sup: Curve,
    val emissionContent: String,
    val emissionType: String,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[EmissionCurve] }
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
        (if (null != emissionContent) "\t\t<cim:EmissionCurve.emissionContent rdf:resource=\"#" + emissionContent + "\"/>\n" else "") +
        (if (null != emissionType) "\t\t<cim:EmissionCurve.emissionType rdf:resource=\"#" + emissionType + "\"/>\n" else "") +
        "\t\t<cim:EmissionCurve.isNetGrossP>" + isNetGrossP + "</cim:EmissionCurve.isNetGrossP>\n" +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:EmissionCurve.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EmissionCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EmissionCurve>\n"
    }
}

object EmissionCurve
extends
    Parseable[EmissionCurve]
{
    val emissionContent = parse_attribute (attribute ("""EmissionCurve.emissionContent"""))
    val emissionType = parse_attribute (attribute ("""EmissionCurve.emissionType"""))
    val isNetGrossP = parse_element (element ("""EmissionCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): EmissionCurve =
    {
        EmissionCurve(
            Curve.parse (context),
            emissionContent (context),
            emissionType (context),
            toBoolean (isNetGrossP (context), context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * The type of emission.
 * @param sup Reference to the superclass object.
 * @param carbonDioxide Carbon diaoxide.
 * @param carbonDisulfide Carbon disulfide.
 * @param chlorine Clorine.
 * @param hydrogenSulfide Hydrogen sulfide.
 * @param nitrogenOxide Nitrogen oxide.
 * @param sulfurDioxide Sulfer dioxide.
 */
case class EmissionType
(
    override val sup: BasicElement,
    val carbonDioxide: String,
    val carbonDisulfide: String,
    val chlorine: String,
    val hydrogenSulfide: String,
    val nitrogenOxide: String,
    val sulfurDioxide: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EmissionType] }
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
        (if (null != carbonDioxide) "\t\t<cim:EmissionType.carbonDioxide rdf:resource=\"#" + carbonDioxide + "\"/>\n" else "") +
        (if (null != carbonDisulfide) "\t\t<cim:EmissionType.carbonDisulfide rdf:resource=\"#" + carbonDisulfide + "\"/>\n" else "") +
        (if (null != chlorine) "\t\t<cim:EmissionType.chlorine rdf:resource=\"#" + chlorine + "\"/>\n" else "") +
        (if (null != hydrogenSulfide) "\t\t<cim:EmissionType.hydrogenSulfide rdf:resource=\"#" + hydrogenSulfide + "\"/>\n" else "") +
        (if (null != nitrogenOxide) "\t\t<cim:EmissionType.nitrogenOxide rdf:resource=\"#" + nitrogenOxide + "\"/>\n" else "") +
        (if (null != sulfurDioxide) "\t\t<cim:EmissionType.sulfurDioxide rdf:resource=\"#" + sulfurDioxide + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EmissionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EmissionType>\n"
    }
}

object EmissionType
extends
    Parseable[EmissionType]
{
    val carbonDioxide = parse_attribute (attribute ("""EmissionType.carbonDioxide"""))
    val carbonDisulfide = parse_attribute (attribute ("""EmissionType.carbonDisulfide"""))
    val chlorine = parse_attribute (attribute ("""EmissionType.chlorine"""))
    val hydrogenSulfide = parse_attribute (attribute ("""EmissionType.hydrogenSulfide"""))
    val nitrogenOxide = parse_attribute (attribute ("""EmissionType.nitrogenOxide"""))
    val sulfurDioxide = parse_attribute (attribute ("""EmissionType.sulfurDioxide"""))
    def parse (context: Context): EmissionType =
    {
        EmissionType(
            BasicElement.parse (context),
            carbonDioxide (context),
            carbonDisulfide (context),
            chlorine (context),
            hydrogenSulfide (context),
            nitrogenOxide (context),
            sulfurDioxide (context)
        )
    }
}

/**
 * The source of the emission value.
 * @param sup Reference to the superclass object.
 * @param calculated Calculated.
 * @param measured Measured.
 */
case class EmissionValueSource
(
    override val sup: BasicElement,
    val calculated: String,
    val measured: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EmissionValueSource] }
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
        (if (null != calculated) "\t\t<cim:EmissionValueSource.calculated rdf:resource=\"#" + calculated + "\"/>\n" else "") +
        (if (null != measured) "\t\t<cim:EmissionValueSource.measured rdf:resource=\"#" + measured + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EmissionValueSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EmissionValueSource>\n"
    }
}

object EmissionValueSource
extends
    Parseable[EmissionValueSource]
{
    val calculated = parse_attribute (attribute ("""EmissionValueSource.calculated"""))
    val measured = parse_attribute (attribute ("""EmissionValueSource.measured"""))
    def parse (context: Context): EmissionValueSource =
    {
        EmissionValueSource(
            BasicElement.parse (context),
            calculated (context),
            measured (context)
        )
    }
}

/**
 * The fossil fuel consumed by the non-nuclear thermal generating unit.
 * For example, coal, oil, gas, etc.   This a the specific fuels that the generating unit can consume.
 * @param sup Reference to the superclass object.
 * @param fossilFuelType The type of fossil fuel, such as coal, oil, or gas.
 * @param fuelCost The cost in terms of heat value for the given type of fuel.
 * @param fuelDispatchCost The cost of fuel used for economic dispatching which includes: fuel cost, transportation cost,  and incremental maintenance cost.
 * @param fuelEffFactor The efficiency factor for the fuel (per unit) in terms of the effective energy absorbed.
 * @param fuelHandlingCost Handling and processing cost associated with this fuel.
 * @param fuelHeatContent The amount of heat per weight (or volume) of the given type of fuel.
 * @param fuelMixture Relative amount of the given type of fuel, when multiple fuels are being consumed.
 * @param fuelSulfur The fuel's fraction of pollution credit per unit of heat content.
 * @param highBreakpointP The active power output level of the unit at which the given type of fuel is switched on.
 *        This fuel (e.g., oil) is sometimes used to supplement the base fuel (e.g., coal) at high active power output levels.
 * @param lowBreakpointP The active power output level of the unit at which the given type of fuel is switched off.
 *        This fuel (e.g., oil) is sometimes used to stabilize the base fuel (e.g., coal) at low active power output levels.
 * @param ThermalGeneratingUnit A thermal generating unit may have one or more fossil fuels.
 */
case class FossilFuel
(
    override val sup: IdentifiedObject,
    val fossilFuelType: String,
    val fuelCost: String,
    val fuelDispatchCost: String,
    val fuelEffFactor: Double,
    val fuelHandlingCost: String,
    val fuelHeatContent: Double,
    val fuelMixture: Double,
    val fuelSulfur: Double,
    val highBreakpointP: Double,
    val lowBreakpointP: Double,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[FossilFuel] }
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
        (if (null != fossilFuelType) "\t\t<cim:FossilFuel.fossilFuelType rdf:resource=\"#" + fossilFuelType + "\"/>\n" else "") +
        (if (null != fuelCost) "\t\t<cim:FossilFuel.fuelCost rdf:resource=\"#" + fuelCost + "\"/>\n" else "") +
        (if (null != fuelDispatchCost) "\t\t<cim:FossilFuel.fuelDispatchCost rdf:resource=\"#" + fuelDispatchCost + "\"/>\n" else "") +
        "\t\t<cim:FossilFuel.fuelEffFactor>" + fuelEffFactor + "</cim:FossilFuel.fuelEffFactor>\n" +
        (if (null != fuelHandlingCost) "\t\t<cim:FossilFuel.fuelHandlingCost rdf:resource=\"#" + fuelHandlingCost + "\"/>\n" else "") +
        "\t\t<cim:FossilFuel.fuelHeatContent>" + fuelHeatContent + "</cim:FossilFuel.fuelHeatContent>\n" +
        "\t\t<cim:FossilFuel.fuelMixture>" + fuelMixture + "</cim:FossilFuel.fuelMixture>\n" +
        "\t\t<cim:FossilFuel.fuelSulfur>" + fuelSulfur + "</cim:FossilFuel.fuelSulfur>\n" +
        "\t\t<cim:FossilFuel.highBreakpointP>" + highBreakpointP + "</cim:FossilFuel.highBreakpointP>\n" +
        "\t\t<cim:FossilFuel.lowBreakpointP>" + lowBreakpointP + "</cim:FossilFuel.lowBreakpointP>\n" +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:FossilFuel.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FossilFuel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FossilFuel>\n"
    }
}

object FossilFuel
extends
    Parseable[FossilFuel]
{
    val fossilFuelType = parse_attribute (attribute ("""FossilFuel.fossilFuelType"""))
    val fuelCost = parse_attribute (attribute ("""FossilFuel.fuelCost"""))
    val fuelDispatchCost = parse_attribute (attribute ("""FossilFuel.fuelDispatchCost"""))
    val fuelEffFactor = parse_element (element ("""FossilFuel.fuelEffFactor"""))
    val fuelHandlingCost = parse_attribute (attribute ("""FossilFuel.fuelHandlingCost"""))
    val fuelHeatContent = parse_element (element ("""FossilFuel.fuelHeatContent"""))
    val fuelMixture = parse_element (element ("""FossilFuel.fuelMixture"""))
    val fuelSulfur = parse_element (element ("""FossilFuel.fuelSulfur"""))
    val highBreakpointP = parse_element (element ("""FossilFuel.highBreakpointP"""))
    val lowBreakpointP = parse_element (element ("""FossilFuel.lowBreakpointP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""FossilFuel.ThermalGeneratingUnit"""))
    def parse (context: Context): FossilFuel =
    {
        FossilFuel(
            IdentifiedObject.parse (context),
            fossilFuelType (context),
            fuelCost (context),
            fuelDispatchCost (context),
            toDouble (fuelEffFactor (context), context),
            fuelHandlingCost (context),
            toDouble (fuelHeatContent (context), context),
            toDouble (fuelMixture (context), context),
            toDouble (fuelSulfur (context), context),
            toDouble (highBreakpointP (context), context),
            toDouble (lowBreakpointP (context), context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * The amount of fuel of a given type which is allocated for consumption over a specified period of time.
 * @param sup Reference to the superclass object.
 * @param fuelAllocationEndDate The end time and date of the fuel allocation schedule.
 * @param fuelAllocationStartDate The start time and date of the fuel allocation schedule.
 * @param fuelType The type of fuel, which also indicates the corresponding measurement unit.
 * @param maxFuelAllocation The maximum amount fuel that is allocated for consumption for the scheduled time period.
 * @param minFuelAllocation The minimum amount fuel that is allocated for consumption for the scheduled time period, e.g., based on a "take-or-pay" contract.
 * @param FossilFuel A fuel allocation schedule must have a fossil fuel.
 * @param ThermalGeneratingUnit A thermal generating unit may have one or more fuel allocation schedules.
 */
case class FuelAllocationSchedule
(
    override val sup: Curve,
    val fuelAllocationEndDate: String,
    val fuelAllocationStartDate: String,
    val fuelType: String,
    val maxFuelAllocation: Double,
    val minFuelAllocation: Double,
    val FossilFuel: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, 0.0, 0.0, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[FuelAllocationSchedule] }
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
        (if (null != fuelAllocationEndDate) "\t\t<cim:FuelAllocationSchedule.fuelAllocationEndDate>" + fuelAllocationEndDate + "</cim:FuelAllocationSchedule.fuelAllocationEndDate>\n" else "") +
        (if (null != fuelAllocationStartDate) "\t\t<cim:FuelAllocationSchedule.fuelAllocationStartDate>" + fuelAllocationStartDate + "</cim:FuelAllocationSchedule.fuelAllocationStartDate>\n" else "") +
        (if (null != fuelType) "\t\t<cim:FuelAllocationSchedule.fuelType rdf:resource=\"#" + fuelType + "\"/>\n" else "") +
        "\t\t<cim:FuelAllocationSchedule.maxFuelAllocation>" + maxFuelAllocation + "</cim:FuelAllocationSchedule.maxFuelAllocation>\n" +
        "\t\t<cim:FuelAllocationSchedule.minFuelAllocation>" + minFuelAllocation + "</cim:FuelAllocationSchedule.minFuelAllocation>\n" +
        (if (null != FossilFuel) "\t\t<cim:FuelAllocationSchedule.FossilFuel rdf:resource=\"#" + FossilFuel + "\"/>\n" else "") +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:FuelAllocationSchedule.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FuelAllocationSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FuelAllocationSchedule>\n"
    }
}

object FuelAllocationSchedule
extends
    Parseable[FuelAllocationSchedule]
{
    val fuelAllocationEndDate = parse_element (element ("""FuelAllocationSchedule.fuelAllocationEndDate"""))
    val fuelAllocationStartDate = parse_element (element ("""FuelAllocationSchedule.fuelAllocationStartDate"""))
    val fuelType = parse_attribute (attribute ("""FuelAllocationSchedule.fuelType"""))
    val maxFuelAllocation = parse_element (element ("""FuelAllocationSchedule.maxFuelAllocation"""))
    val minFuelAllocation = parse_element (element ("""FuelAllocationSchedule.minFuelAllocation"""))
    val FossilFuel = parse_attribute (attribute ("""FuelAllocationSchedule.FossilFuel"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""FuelAllocationSchedule.ThermalGeneratingUnit"""))
    def parse (context: Context): FuelAllocationSchedule =
    {
        FuelAllocationSchedule(
            Curve.parse (context),
            fuelAllocationEndDate (context),
            fuelAllocationStartDate (context),
            fuelType (context),
            toDouble (maxFuelAllocation (context), context),
            toDouble (minFuelAllocation (context), context),
            FossilFuel (context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Type of fuel.
 * @param sup Reference to the superclass object.
 * @param coal Generic coal, not including lignite type.
 * @param gas Natural gas.
 * @param hardCoal Hard coal
 * @param lignite The fuel is lignite coal.
 *        Note that this is a special type of coal, so the other enum of coal is reserved for hard coal types or if the exact type of coal is not known.
 * @param oil Oil.
 * @param oilShale Oil Shale
 */
case class FuelType
(
    override val sup: BasicElement,
    val coal: String,
    val gas: String,
    val hardCoal: String,
    val lignite: String,
    val oil: String,
    val oilShale: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FuelType] }
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
        (if (null != coal) "\t\t<cim:FuelType.coal rdf:resource=\"#" + coal + "\"/>\n" else "") +
        (if (null != gas) "\t\t<cim:FuelType.gas rdf:resource=\"#" + gas + "\"/>\n" else "") +
        (if (null != hardCoal) "\t\t<cim:FuelType.hardCoal rdf:resource=\"#" + hardCoal + "\"/>\n" else "") +
        (if (null != lignite) "\t\t<cim:FuelType.lignite rdf:resource=\"#" + lignite + "\"/>\n" else "") +
        (if (null != oil) "\t\t<cim:FuelType.oil rdf:resource=\"#" + oil + "\"/>\n" else "") +
        (if (null != oilShale) "\t\t<cim:FuelType.oilShale rdf:resource=\"#" + oilShale + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FuelType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FuelType>\n"
    }
}

object FuelType
extends
    Parseable[FuelType]
{
    val coal = parse_attribute (attribute ("""FuelType.coal"""))
    val gas = parse_attribute (attribute ("""FuelType.gas"""))
    val hardCoal = parse_attribute (attribute ("""FuelType.hardCoal"""))
    val lignite = parse_attribute (attribute ("""FuelType.lignite"""))
    val oil = parse_attribute (attribute ("""FuelType.oil"""))
    val oilShale = parse_attribute (attribute ("""FuelType.oilShale"""))
    def parse (context: Context): FuelType =
    {
        FuelType(
            BasicElement.parse (context),
            coal (context),
            gas (context),
            hardCoal (context),
            lignite (context),
            oil (context),
            oilShale (context)
        )
    }
}

/**
 * Relationship between unit operating cost (Y-axis) and unit output active power (X-axis).
 * The operating cost curve for thermal units is derived from heat input and fuel costs. The operating cost curve for hydro units is derived from water flow rates and equivalent water costs.
 * @param sup Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param GeneratingUnit A generating unit may have one or more cost curves, depending upon fuel mixture and fuel cost.
 */
case class GenUnitOpCostCurve
(
    override val sup: Curve,
    val isNetGrossP: Boolean,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[GenUnitOpCostCurve] }
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
        "\t\t<cim:GenUnitOpCostCurve.isNetGrossP>" + isNetGrossP + "</cim:GenUnitOpCostCurve.isNetGrossP>\n" +
        (if (null != GeneratingUnit) "\t\t<cim:GenUnitOpCostCurve.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenUnitOpCostCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenUnitOpCostCurve>\n"
    }
}

object GenUnitOpCostCurve
extends
    Parseable[GenUnitOpCostCurve]
{
    val isNetGrossP = parse_element (element ("""GenUnitOpCostCurve.isNetGrossP"""))
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpCostCurve.GeneratingUnit"""))
    def parse (context: Context): GenUnitOpCostCurve =
    {
        GenUnitOpCostCurve(
            Curve.parse (context),
            toBoolean (isNetGrossP (context), context),
            GeneratingUnit (context)
        )
    }
}

/**
 * The generating unit's Operator-approved current operating schedule (or plan), typically produced with the aid of unit commitment type analyses.
 * The X-axis represents absolute time. The Y1-axis represents the status (0=off-line and unavailable: 1=available: 2=must run: 3=must run at fixed power value: etc.). The Y2-axis represents the must run fixed power value where required.
 * @param sup Reference to the superclass object.
 * @param GeneratingUnit A generating unit may have an operating schedule, indicating the planned operation of the unit.
 */
case class GenUnitOpSchedule
(
    override val sup: RegularIntervalSchedule,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[GenUnitOpSchedule] }
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
        (if (null != GeneratingUnit) "\t\t<cim:GenUnitOpSchedule.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenUnitOpSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenUnitOpSchedule>\n"
    }
}

object GenUnitOpSchedule
extends
    Parseable[GenUnitOpSchedule]
{
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpSchedule.GeneratingUnit"""))
    def parse (context: Context): GenUnitOpSchedule =
    {
        GenUnitOpSchedule(
            RegularIntervalSchedule.parse (context),
            GeneratingUnit (context)
        )
    }
}

/**
 * A single or set of synchronous machines for converting mechanical power into alternating-current power.
 * For example, individual machines within a set may be defined for scheduling purposes while a single control signal is derived for the set. In this case there would be a GeneratingUnit for each member of the set and an additional GeneratingUnit corresponding to the set.
 * @param sup Reference to the superclass object.
 * @param allocSpinResP The planned unused capacity (spinning reserve) which can be used to support emergency load.
 * @param autoCntrlMarginP The planned unused capacity which can be used to support automatic control overruns.
 * @param baseP For dispatchable units, this value represents the economic active power basepoint, for units that are not dispatchable, this value represents the fixed generation value.
 *        The value must be between the operating low and high limits.
 * @param controlDeadband Unit control error deadband.
 *        When a unit's desired active power change is less than this deadband, then no control pulses will be sent to the unit.
 * @param controlPulseHigh Pulse high limit which is the largest control pulse that the unit can respond to.
 * @param controlPulseLow Pulse low limit which is the smallest control pulse that the unit can respond to.
 * @param controlResponseRate Unit response rate which specifies the active power change for a control pulse of one second in the most responsive loading level of the unit.
 * @param efficiency The efficiency of the unit in converting mechanical energy, from the prime mover, into electrical energy.
 * @param genControlMode The unit control mode.
 * @param genControlSource The source of controls for a generating unit.
 * @param governorMPL Governor motor position limit.
 * @param governorSCD Governor Speed Changer Droop.
 *        This is the change in generator power output divided by the change in frequency normalized by the nominal power of the generator and the nominal frequency and expressed in percent and negated. A positive value of speed change droop provides additional generator output upon a drop in frequency.
 * @param highControlLimit High limit for secondary (AGC) control.
 * @param initialP Default initial active power  which is used to store a powerflow result for the initial active power for this unit in this network configuration.
 * @param longPF Generating unit long term economic participation factor.
 * @param lowControlLimit Low limit for secondary (AGC) control.
 * @param lowerRampRate The normal maximum rate the generating unit active power output can be lowered by control actions.
 * @param maxEconomicP Maximum high economic active power limit, that should not exceed the maximum operating active power limit.
 * @param maxOperatingP This is the maximum operating active power limit the dispatcher can enter for this unit.
 * @param maximumAllowableSpinningReserve Maximum allowable spinning reserve.
 *        Spinning reserve will never be considered greater than this value regardless of the current operating point.
 * @param minEconomicP Low economic active power limit that must be greater than or equal to the minimum operating active power limit.
 * @param minOperatingP This is the minimum operating active power limit the dispatcher can enter for this unit.
 * @param minimumOffTime Minimum time interval between unit shutdown and startup.
 * @param modelDetail Detail level of the generator model data.
 * @param nominalP The nominal power of the generating unit.
 *        Used to give precise meaning to percentage based attributes such as the governor speed change droop (governorSCD attribute).
 * @param normalPF Generating unit economic participation factor.
 * @param penaltyFactor Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value.
 *        The typical range of penalty factors is (0.9 to 1.1).
 * @param raiseRampRate The normal maximum rate the generating unit active power output can be raised by control actions.
 * @param ratedGrossMaxP The unit's gross rated maximum capacity (book value).
 * @param ratedGrossMinP The gross rated minimum generation level which the unit can safely operate at while delivering power to the transmission grid.
 * @param ratedNetMaxP The net rated maximum capacity determined by subtracting the auxiliary power used to operate the internal plant machinery from the rated gross maximum capacity.
 * @param shortPF Generating unit short term economic participation factor.
 * @param startupCost The initial startup cost incurred for each start of the GeneratingUnit.
 * @param startupTime Time it takes to get the unit on-line, from the time that the prime mover mechanical power is applied.
 * @param tieLinePF Generating unit economic participation factor.
 * @param totalEfficiency The efficiency of the unit in converting the fuel into electrical energy.
 * @param variableCost The variable cost component of production per unit of ActivePower.
 * @param GenUnitOpSchedule A generating unit may have an operating schedule, indicating the planned operation of the unit.
 */
case class GeneratingUnit
(
    override val sup: Equipment,
    val allocSpinResP: Double,
    val autoCntrlMarginP: Double,
    val baseP: Double,
    val controlDeadband: Double,
    val controlPulseHigh: Double,
    val controlPulseLow: Double,
    val controlResponseRate: Double,
    val efficiency: Double,
    val genControlMode: String,
    val genControlSource: String,
    val governorMPL: Double,
    val governorSCD: Double,
    val highControlLimit: Double,
    val initialP: Double,
    val longPF: Double,
    val lowControlLimit: Double,
    val lowerRampRate: Double,
    val maxEconomicP: Double,
    val maxOperatingP: Double,
    val maximumAllowableSpinningReserve: Double,
    val minEconomicP: Double,
    val minOperatingP: Double,
    val minimumOffTime: Double,
    val modelDetail: String,
    val nominalP: Double,
    val normalPF: Double,
    val penaltyFactor: Double,
    val raiseRampRate: Double,
    val ratedGrossMaxP: Double,
    val ratedGrossMinP: Double,
    val ratedNetMaxP: Double,
    val shortPF: Double,
    val startupCost: Double,
    val startupTime: Double,
    val tieLinePF: Double,
    val totalEfficiency: Double,
    val variableCost: Double,
    val GenUnitOpSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[GeneratingUnit] }
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
        "\t\t<cim:GeneratingUnit.allocSpinResP>" + allocSpinResP + "</cim:GeneratingUnit.allocSpinResP>\n" +
        "\t\t<cim:GeneratingUnit.autoCntrlMarginP>" + autoCntrlMarginP + "</cim:GeneratingUnit.autoCntrlMarginP>\n" +
        "\t\t<cim:GeneratingUnit.baseP>" + baseP + "</cim:GeneratingUnit.baseP>\n" +
        "\t\t<cim:GeneratingUnit.controlDeadband>" + controlDeadband + "</cim:GeneratingUnit.controlDeadband>\n" +
        "\t\t<cim:GeneratingUnit.controlPulseHigh>" + controlPulseHigh + "</cim:GeneratingUnit.controlPulseHigh>\n" +
        "\t\t<cim:GeneratingUnit.controlPulseLow>" + controlPulseLow + "</cim:GeneratingUnit.controlPulseLow>\n" +
        "\t\t<cim:GeneratingUnit.controlResponseRate>" + controlResponseRate + "</cim:GeneratingUnit.controlResponseRate>\n" +
        "\t\t<cim:GeneratingUnit.efficiency>" + efficiency + "</cim:GeneratingUnit.efficiency>\n" +
        (if (null != genControlMode) "\t\t<cim:GeneratingUnit.genControlMode rdf:resource=\"#" + genControlMode + "\"/>\n" else "") +
        (if (null != genControlSource) "\t\t<cim:GeneratingUnit.genControlSource rdf:resource=\"#" + genControlSource + "\"/>\n" else "") +
        "\t\t<cim:GeneratingUnit.governorMPL>" + governorMPL + "</cim:GeneratingUnit.governorMPL>\n" +
        "\t\t<cim:GeneratingUnit.governorSCD>" + governorSCD + "</cim:GeneratingUnit.governorSCD>\n" +
        "\t\t<cim:GeneratingUnit.highControlLimit>" + highControlLimit + "</cim:GeneratingUnit.highControlLimit>\n" +
        "\t\t<cim:GeneratingUnit.initialP>" + initialP + "</cim:GeneratingUnit.initialP>\n" +
        "\t\t<cim:GeneratingUnit.longPF>" + longPF + "</cim:GeneratingUnit.longPF>\n" +
        "\t\t<cim:GeneratingUnit.lowControlLimit>" + lowControlLimit + "</cim:GeneratingUnit.lowControlLimit>\n" +
        "\t\t<cim:GeneratingUnit.lowerRampRate>" + lowerRampRate + "</cim:GeneratingUnit.lowerRampRate>\n" +
        "\t\t<cim:GeneratingUnit.maxEconomicP>" + maxEconomicP + "</cim:GeneratingUnit.maxEconomicP>\n" +
        "\t\t<cim:GeneratingUnit.maxOperatingP>" + maxOperatingP + "</cim:GeneratingUnit.maxOperatingP>\n" +
        "\t\t<cim:GeneratingUnit.maximumAllowableSpinningReserve>" + maximumAllowableSpinningReserve + "</cim:GeneratingUnit.maximumAllowableSpinningReserve>\n" +
        "\t\t<cim:GeneratingUnit.minEconomicP>" + minEconomicP + "</cim:GeneratingUnit.minEconomicP>\n" +
        "\t\t<cim:GeneratingUnit.minOperatingP>" + minOperatingP + "</cim:GeneratingUnit.minOperatingP>\n" +
        "\t\t<cim:GeneratingUnit.minimumOffTime>" + minimumOffTime + "</cim:GeneratingUnit.minimumOffTime>\n" +
        (if (null != modelDetail) "\t\t<cim:GeneratingUnit.modelDetail rdf:resource=\"#" + modelDetail + "\"/>\n" else "") +
        "\t\t<cim:GeneratingUnit.nominalP>" + nominalP + "</cim:GeneratingUnit.nominalP>\n" +
        "\t\t<cim:GeneratingUnit.normalPF>" + normalPF + "</cim:GeneratingUnit.normalPF>\n" +
        "\t\t<cim:GeneratingUnit.penaltyFactor>" + penaltyFactor + "</cim:GeneratingUnit.penaltyFactor>\n" +
        "\t\t<cim:GeneratingUnit.raiseRampRate>" + raiseRampRate + "</cim:GeneratingUnit.raiseRampRate>\n" +
        "\t\t<cim:GeneratingUnit.ratedGrossMaxP>" + ratedGrossMaxP + "</cim:GeneratingUnit.ratedGrossMaxP>\n" +
        "\t\t<cim:GeneratingUnit.ratedGrossMinP>" + ratedGrossMinP + "</cim:GeneratingUnit.ratedGrossMinP>\n" +
        "\t\t<cim:GeneratingUnit.ratedNetMaxP>" + ratedNetMaxP + "</cim:GeneratingUnit.ratedNetMaxP>\n" +
        "\t\t<cim:GeneratingUnit.shortPF>" + shortPF + "</cim:GeneratingUnit.shortPF>\n" +
        "\t\t<cim:GeneratingUnit.startupCost>" + startupCost + "</cim:GeneratingUnit.startupCost>\n" +
        "\t\t<cim:GeneratingUnit.startupTime>" + startupTime + "</cim:GeneratingUnit.startupTime>\n" +
        "\t\t<cim:GeneratingUnit.tieLinePF>" + tieLinePF + "</cim:GeneratingUnit.tieLinePF>\n" +
        "\t\t<cim:GeneratingUnit.totalEfficiency>" + totalEfficiency + "</cim:GeneratingUnit.totalEfficiency>\n" +
        "\t\t<cim:GeneratingUnit.variableCost>" + variableCost + "</cim:GeneratingUnit.variableCost>\n" +
        (if (null != GenUnitOpSchedule) "\t\t<cim:GeneratingUnit.GenUnitOpSchedule rdf:resource=\"#" + GenUnitOpSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratingUnit>\n"
    }
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
{
    val allocSpinResP = parse_element (element ("""GeneratingUnit.allocSpinResP"""))
    val autoCntrlMarginP = parse_element (element ("""GeneratingUnit.autoCntrlMarginP"""))
    val baseP = parse_element (element ("""GeneratingUnit.baseP"""))
    val controlDeadband = parse_element (element ("""GeneratingUnit.controlDeadband"""))
    val controlPulseHigh = parse_element (element ("""GeneratingUnit.controlPulseHigh"""))
    val controlPulseLow = parse_element (element ("""GeneratingUnit.controlPulseLow"""))
    val controlResponseRate = parse_element (element ("""GeneratingUnit.controlResponseRate"""))
    val efficiency = parse_element (element ("""GeneratingUnit.efficiency"""))
    val genControlMode = parse_attribute (attribute ("""GeneratingUnit.genControlMode"""))
    val genControlSource = parse_attribute (attribute ("""GeneratingUnit.genControlSource"""))
    val governorMPL = parse_element (element ("""GeneratingUnit.governorMPL"""))
    val governorSCD = parse_element (element ("""GeneratingUnit.governorSCD"""))
    val highControlLimit = parse_element (element ("""GeneratingUnit.highControlLimit"""))
    val initialP = parse_element (element ("""GeneratingUnit.initialP"""))
    val longPF = parse_element (element ("""GeneratingUnit.longPF"""))
    val lowControlLimit = parse_element (element ("""GeneratingUnit.lowControlLimit"""))
    val lowerRampRate = parse_element (element ("""GeneratingUnit.lowerRampRate"""))
    val maxEconomicP = parse_element (element ("""GeneratingUnit.maxEconomicP"""))
    val maxOperatingP = parse_element (element ("""GeneratingUnit.maxOperatingP"""))
    val maximumAllowableSpinningReserve = parse_element (element ("""GeneratingUnit.maximumAllowableSpinningReserve"""))
    val minEconomicP = parse_element (element ("""GeneratingUnit.minEconomicP"""))
    val minOperatingP = parse_element (element ("""GeneratingUnit.minOperatingP"""))
    val minimumOffTime = parse_element (element ("""GeneratingUnit.minimumOffTime"""))
    val modelDetail = parse_attribute (attribute ("""GeneratingUnit.modelDetail"""))
    val nominalP = parse_element (element ("""GeneratingUnit.nominalP"""))
    val normalPF = parse_element (element ("""GeneratingUnit.normalPF"""))
    val penaltyFactor = parse_element (element ("""GeneratingUnit.penaltyFactor"""))
    val raiseRampRate = parse_element (element ("""GeneratingUnit.raiseRampRate"""))
    val ratedGrossMaxP = parse_element (element ("""GeneratingUnit.ratedGrossMaxP"""))
    val ratedGrossMinP = parse_element (element ("""GeneratingUnit.ratedGrossMinP"""))
    val ratedNetMaxP = parse_element (element ("""GeneratingUnit.ratedNetMaxP"""))
    val shortPF = parse_element (element ("""GeneratingUnit.shortPF"""))
    val startupCost = parse_element (element ("""GeneratingUnit.startupCost"""))
    val startupTime = parse_element (element ("""GeneratingUnit.startupTime"""))
    val tieLinePF = parse_element (element ("""GeneratingUnit.tieLinePF"""))
    val totalEfficiency = parse_element (element ("""GeneratingUnit.totalEfficiency"""))
    val variableCost = parse_element (element ("""GeneratingUnit.variableCost"""))
    val GenUnitOpSchedule = parse_attribute (attribute ("""GeneratingUnit.GenUnitOpSchedule"""))
    def parse (context: Context): GeneratingUnit =
    {
        GeneratingUnit(
            Equipment.parse (context),
            toDouble (allocSpinResP (context), context),
            toDouble (autoCntrlMarginP (context), context),
            toDouble (baseP (context), context),
            toDouble (controlDeadband (context), context),
            toDouble (controlPulseHigh (context), context),
            toDouble (controlPulseLow (context), context),
            toDouble (controlResponseRate (context), context),
            toDouble (efficiency (context), context),
            genControlMode (context),
            genControlSource (context),
            toDouble (governorMPL (context), context),
            toDouble (governorSCD (context), context),
            toDouble (highControlLimit (context), context),
            toDouble (initialP (context), context),
            toDouble (longPF (context), context),
            toDouble (lowControlLimit (context), context),
            toDouble (lowerRampRate (context), context),
            toDouble (maxEconomicP (context), context),
            toDouble (maxOperatingP (context), context),
            toDouble (maximumAllowableSpinningReserve (context), context),
            toDouble (minEconomicP (context), context),
            toDouble (minOperatingP (context), context),
            toDouble (minimumOffTime (context), context),
            modelDetail (context),
            toDouble (nominalP (context), context),
            toDouble (normalPF (context), context),
            toDouble (penaltyFactor (context), context),
            toDouble (raiseRampRate (context), context),
            toDouble (ratedGrossMaxP (context), context),
            toDouble (ratedGrossMinP (context), context),
            toDouble (ratedNetMaxP (context), context),
            toDouble (shortPF (context), context),
            toDouble (startupCost (context), context),
            toDouble (startupTime (context), context),
            toDouble (tieLinePF (context), context),
            toDouble (totalEfficiency (context), context),
            toDouble (variableCost (context), context),
            GenUnitOpSchedule (context)
        )
    }
}

/**
 * Unit control modes.
 * @param sup Reference to the superclass object.
 * @param pulse Pulse control mode.
 * @param setpoint Setpoint control mode.
 */
case class GeneratorControlMode
(
    override val sup: BasicElement,
    val pulse: String,
    val setpoint: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GeneratorControlMode] }
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
        (if (null != pulse) "\t\t<cim:GeneratorControlMode.pulse rdf:resource=\"#" + pulse + "\"/>\n" else "") +
        (if (null != setpoint) "\t\t<cim:GeneratorControlMode.setpoint rdf:resource=\"#" + setpoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneratorControlMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratorControlMode>\n"
    }
}

object GeneratorControlMode
extends
    Parseable[GeneratorControlMode]
{
    val pulse = parse_attribute (attribute ("""GeneratorControlMode.pulse"""))
    val setpoint = parse_attribute (attribute ("""GeneratorControlMode.setpoint"""))
    def parse (context: Context): GeneratorControlMode =
    {
        GeneratorControlMode(
            BasicElement.parse (context),
            pulse (context),
            setpoint (context)
        )
    }
}

/**
 * The source of controls for a generating unit.
 * @param sup Reference to the superclass object.
 * @param offAGC Off of automatic generation control (AGC).
 * @param onAGC On automatic generation control (AGC).
 * @param plantControl Plant is controlling.
 * @param unavailable Not available.
 */
case class GeneratorControlSource
(
    override val sup: BasicElement,
    val offAGC: String,
    val onAGC: String,
    val plantControl: String,
    val unavailable: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[GeneratorControlSource] }
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
        (if (null != offAGC) "\t\t<cim:GeneratorControlSource.offAGC rdf:resource=\"#" + offAGC + "\"/>\n" else "") +
        (if (null != onAGC) "\t\t<cim:GeneratorControlSource.onAGC rdf:resource=\"#" + onAGC + "\"/>\n" else "") +
        (if (null != plantControl) "\t\t<cim:GeneratorControlSource.plantControl rdf:resource=\"#" + plantControl + "\"/>\n" else "") +
        (if (null != unavailable) "\t\t<cim:GeneratorControlSource.unavailable rdf:resource=\"#" + unavailable + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GeneratorControlSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GeneratorControlSource>\n"
    }
}

object GeneratorControlSource
extends
    Parseable[GeneratorControlSource]
{
    val offAGC = parse_attribute (attribute ("""GeneratorControlSource.offAGC"""))
    val onAGC = parse_attribute (attribute ("""GeneratorControlSource.onAGC"""))
    val plantControl = parse_attribute (attribute ("""GeneratorControlSource.plantControl"""))
    val unavailable = parse_attribute (attribute ("""GeneratorControlSource.unavailable"""))
    def parse (context: Context): GeneratorControlSource =
    {
        GeneratorControlSource(
            BasicElement.parse (context),
            offAGC (context),
            onAGC (context),
            plantControl (context),
            unavailable (context)
        )
    }
}

/**
 * Relationship between the generating unit's gross active power output on the X-axis (measured at the terminals of the machine(s)) and the generating unit's net active power output on the Y-axis (based on utility-defined measurements at the power station).
 * Station service loads, when modeled, should be treated as non-conforming bus loads. There may be more than one curve, depending on the auxiliary equipment that is in service.
 * @param sup Reference to the superclass object.
 * @param GeneratingUnit A generating unit may have a gross active power to net active power curve, describing the losses and auxiliary power requirements of the unit.
 */
case class GrossToNetActivePowerCurve
(
    override val sup: Curve,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[GrossToNetActivePowerCurve] }
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
        (if (null != GeneratingUnit) "\t\t<cim:GrossToNetActivePowerCurve.GeneratingUnit rdf:resource=\"#" + GeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GrossToNetActivePowerCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GrossToNetActivePowerCurve>\n"
    }
}

object GrossToNetActivePowerCurve
extends
    Parseable[GrossToNetActivePowerCurve]
{
    val GeneratingUnit = parse_attribute (attribute ("""GrossToNetActivePowerCurve.GeneratingUnit"""))
    def parse (context: Context): GrossToNetActivePowerCurve =
    {
        GrossToNetActivePowerCurve(
            Curve.parse (context),
            GeneratingUnit (context)
        )
    }
}

/**
 * Relationship between unit heat input in energy per time for main fuel (Y1-axis) and supplemental fuel (Y2-axis) versus unit output in active power (X-axis).
 * The quantity of main fuel used to sustain generation at this output level is prorated for throttling between definition points. The quantity of supplemental fuel used at this output level is fixed and not prorated.
 * @param sup Reference to the superclass object.
 * @param auxPowerMult Power output - auxiliary power multiplier adjustment factor.
 * @param auxPowerOffset Power output - auxiliary power offset adjustment factor.
 * @param heatInputEff Heat input - efficiency multiplier adjustment factor.
 * @param heatInputOffset Heat input - offset adjustment factor.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit A thermal generating unit may have a heat input curve.
 */
case class HeatInputCurve
(
    override val sup: Curve,
    val auxPowerMult: Double,
    val auxPowerOffset: Double,
    val heatInputEff: Double,
    val heatInputOffset: String,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HeatInputCurve] }
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
        "\t\t<cim:HeatInputCurve.auxPowerMult>" + auxPowerMult + "</cim:HeatInputCurve.auxPowerMult>\n" +
        "\t\t<cim:HeatInputCurve.auxPowerOffset>" + auxPowerOffset + "</cim:HeatInputCurve.auxPowerOffset>\n" +
        "\t\t<cim:HeatInputCurve.heatInputEff>" + heatInputEff + "</cim:HeatInputCurve.heatInputEff>\n" +
        (if (null != heatInputOffset) "\t\t<cim:HeatInputCurve.heatInputOffset rdf:resource=\"#" + heatInputOffset + "\"/>\n" else "") +
        "\t\t<cim:HeatInputCurve.isNetGrossP>" + isNetGrossP + "</cim:HeatInputCurve.isNetGrossP>\n" +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:HeatInputCurve.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HeatInputCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HeatInputCurve>\n"
    }
}

object HeatInputCurve
extends
    Parseable[HeatInputCurve]
{
    val auxPowerMult = parse_element (element ("""HeatInputCurve.auxPowerMult"""))
    val auxPowerOffset = parse_element (element ("""HeatInputCurve.auxPowerOffset"""))
    val heatInputEff = parse_element (element ("""HeatInputCurve.heatInputEff"""))
    val heatInputOffset = parse_attribute (attribute ("""HeatInputCurve.heatInputOffset"""))
    val isNetGrossP = parse_element (element ("""HeatInputCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatInputCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): HeatInputCurve =
    {
        HeatInputCurve(
            Curve.parse (context),
            toDouble (auxPowerMult (context), context),
            toDouble (auxPowerOffset (context), context),
            toDouble (heatInputEff (context), context),
            heatInputOffset (context),
            toBoolean (isNetGrossP (context), context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Heat generated, in energy pertime unit of elapsed time.
 * @param sup Reference to the superclass object.
 * @param denominatorMultiplier
 * @param denominatorUnit
 * @param multiplier
 * @param unit
 * @param value
 */
case class HeatRate
(
    override val sup: BasicElement,
    val denominatorMultiplier: String,
    val denominatorUnit: String,
    val multiplier: String,
    val unit: String,
    val value: Double
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, 0.0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[HeatRate] }
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
        (if (null != denominatorMultiplier) "\t\t<cim:HeatRate.denominatorMultiplier rdf:resource=\"#" + denominatorMultiplier + "\"/>\n" else "") +
        (if (null != denominatorUnit) "\t\t<cim:HeatRate.denominatorUnit rdf:resource=\"#" + denominatorUnit + "\"/>\n" else "") +
        (if (null != multiplier) "\t\t<cim:HeatRate.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:HeatRate.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        "\t\t<cim:HeatRate.value>" + value + "</cim:HeatRate.value>\n"
    }
    override def export: String =
    {
        "\t<cim:HeatRate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HeatRate>\n"
    }
}

object HeatRate
extends
    Parseable[HeatRate]
{
    val denominatorMultiplier = parse_attribute (attribute ("""HeatRate.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""HeatRate.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""HeatRate.multiplier"""))
    val unit = parse_attribute (attribute ("""HeatRate.unit"""))
    val value = parse_element (element ("""HeatRate.value"""))
    def parse (context: Context): HeatRate =
    {
        HeatRate(
            BasicElement.parse (context),
            denominatorMultiplier (context),
            denominatorUnit (context),
            multiplier (context),
            unit (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Relationship between unit heat rate per active power (Y-axis) and  unit output (X-axis).
 * The heat input is from all fuels.
 * @param sup Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit A thermal generating unit may have a heat rate curve.
 */
case class HeatRateCurve
(
    override val sup: Curve,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HeatRateCurve] }
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
        "\t\t<cim:HeatRateCurve.isNetGrossP>" + isNetGrossP + "</cim:HeatRateCurve.isNetGrossP>\n" +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:HeatRateCurve.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HeatRateCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HeatRateCurve>\n"
    }
}

object HeatRateCurve
extends
    Parseable[HeatRateCurve]
{
    val isNetGrossP = parse_element (element ("""HeatRateCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatRateCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): HeatRateCurve =
    {
        HeatRateCurve(
            Curve.parse (context),
            toBoolean (isNetGrossP (context), context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Specifies the capability of the hydro generating unit to convert energy as a generator or pump.
 * @param sup Reference to the superclass object.
 * @param generator Able to generate power, but not able to pump water for energy storage.
 * @param pumpAndGenerator Able to both generate power and pump water for energy storage.
 */
case class HydroEnergyConversionKind
(
    override val sup: BasicElement,
    val generator: String,
    val pumpAndGenerator: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[HydroEnergyConversionKind] }
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
        (if (null != generator) "\t\t<cim:HydroEnergyConversionKind.generator rdf:resource=\"#" + generator + "\"/>\n" else "") +
        (if (null != pumpAndGenerator) "\t\t<cim:HydroEnergyConversionKind.pumpAndGenerator rdf:resource=\"#" + pumpAndGenerator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroEnergyConversionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroEnergyConversionKind>\n"
    }
}

object HydroEnergyConversionKind
extends
    Parseable[HydroEnergyConversionKind]
{
    val generator = parse_attribute (attribute ("""HydroEnergyConversionKind.generator"""))
    val pumpAndGenerator = parse_attribute (attribute ("""HydroEnergyConversionKind.pumpAndGenerator"""))
    def parse (context: Context): HydroEnergyConversionKind =
    {
        HydroEnergyConversionKind(
            BasicElement.parse (context),
            generator (context),
            pumpAndGenerator (context)
        )
    }
}

/**
 * Relationship between unit efficiency in percent and unit output active power for a given net head in meters.
 * The relationship between efficiency, discharge, head, and power output is expressed as follows:   E =KP/HQ
 * @param sup Reference to the superclass object.
 * @param HydroGeneratingUnit A hydro generating unit has an efficiency curve.
 */
case class HydroGeneratingEfficiencyCurve
(
    override val sup: Curve,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[HydroGeneratingEfficiencyCurve] }
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
        (if (null != HydroGeneratingUnit) "\t\t<cim:HydroGeneratingEfficiencyCurve.HydroGeneratingUnit rdf:resource=\"#" + HydroGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroGeneratingEfficiencyCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroGeneratingEfficiencyCurve>\n"
    }
}

object HydroGeneratingEfficiencyCurve
extends
    Parseable[HydroGeneratingEfficiencyCurve]
{
    val HydroGeneratingUnit = parse_attribute (attribute ("""HydroGeneratingEfficiencyCurve.HydroGeneratingUnit"""))
    def parse (context: Context): HydroGeneratingEfficiencyCurve =
    {
        HydroGeneratingEfficiencyCurve(
            Curve.parse (context),
            HydroGeneratingUnit (context)
        )
    }
}

/**
 * A generating unit whose prime mover is a hydraulic turbine (e.g., Francis, Pelton, Kaplan).
 * @param sup Reference to the superclass object.
 * @param energyConversionCapability Energy conversion capability for generating.
 * @param hydroUnitWaterCost The equivalent cost of water that drives the hydro turbine.
 * @param HydroPowerPlant The hydro generating unit belongs to a hydro power plant.
 * @param PenstockLossCurve A hydro generating unit has a penstock loss curve.
 */
case class HydroGeneratingUnit
(
    override val sup: GeneratingUnit,
    val energyConversionCapability: String,
    val hydroUnitWaterCost: Double,
    val HydroPowerPlant: String,
    val PenstockLossCurve: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[HydroGeneratingUnit] }
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
        (if (null != energyConversionCapability) "\t\t<cim:HydroGeneratingUnit.energyConversionCapability rdf:resource=\"#" + energyConversionCapability + "\"/>\n" else "") +
        "\t\t<cim:HydroGeneratingUnit.hydroUnitWaterCost>" + hydroUnitWaterCost + "</cim:HydroGeneratingUnit.hydroUnitWaterCost>\n" +
        (if (null != HydroPowerPlant) "\t\t<cim:HydroGeneratingUnit.HydroPowerPlant rdf:resource=\"#" + HydroPowerPlant + "\"/>\n" else "") +
        (if (null != PenstockLossCurve) "\t\t<cim:HydroGeneratingUnit.PenstockLossCurve rdf:resource=\"#" + PenstockLossCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroGeneratingUnit>\n"
    }
}

object HydroGeneratingUnit
extends
    Parseable[HydroGeneratingUnit]
{
    val energyConversionCapability = parse_attribute (attribute ("""HydroGeneratingUnit.energyConversionCapability"""))
    val hydroUnitWaterCost = parse_element (element ("""HydroGeneratingUnit.hydroUnitWaterCost"""))
    val HydroPowerPlant = parse_attribute (attribute ("""HydroGeneratingUnit.HydroPowerPlant"""))
    val PenstockLossCurve = parse_attribute (attribute ("""HydroGeneratingUnit.PenstockLossCurve"""))
    def parse (context: Context): HydroGeneratingUnit =
    {
        HydroGeneratingUnit(
            GeneratingUnit.parse (context),
            energyConversionCapability (context),
            toDouble (hydroUnitWaterCost (context), context),
            HydroPowerPlant (context),
            PenstockLossCurve (context)
        )
    }
}

/**
 * The type of hydro power plant.
 * @param sup Reference to the superclass object.
 * @param pumpedStorage Pumped storage.
 * @param runOfRiver Run of river.
 * @param storage Storage.
 */
case class HydroPlantStorageKind
(
    override val sup: BasicElement,
    val pumpedStorage: String,
    val runOfRiver: String,
    val storage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[HydroPlantStorageKind] }
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
        (if (null != pumpedStorage) "\t\t<cim:HydroPlantStorageKind.pumpedStorage rdf:resource=\"#" + pumpedStorage + "\"/>\n" else "") +
        (if (null != runOfRiver) "\t\t<cim:HydroPlantStorageKind.runOfRiver rdf:resource=\"#" + runOfRiver + "\"/>\n" else "") +
        (if (null != storage) "\t\t<cim:HydroPlantStorageKind.storage rdf:resource=\"#" + storage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroPlantStorageKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroPlantStorageKind>\n"
    }
}

object HydroPlantStorageKind
extends
    Parseable[HydroPlantStorageKind]
{
    val pumpedStorage = parse_attribute (attribute ("""HydroPlantStorageKind.pumpedStorage"""))
    val runOfRiver = parse_attribute (attribute ("""HydroPlantStorageKind.runOfRiver"""))
    val storage = parse_attribute (attribute ("""HydroPlantStorageKind.storage"""))
    def parse (context: Context): HydroPlantStorageKind =
    {
        HydroPlantStorageKind(
            BasicElement.parse (context),
            pumpedStorage (context),
            runOfRiver (context),
            storage (context)
        )
    }
}

/**
 * A hydro power station which can generate or pump.
 * When generating, the generator turbines receive water from an upper reservoir. When pumping, the pumps receive their water from a lower reservoir.
 * @param sup Reference to the superclass object.
 * @param dischargeTravelDelay Water travel delay from tailbay to next downstream hydro power station.
 * @param genRatedP The hydro plant's generating rating active power for rated head conditions.
 * @param hydroPlantStorageType The type of hydro power plant water storage.
 * @param penstockType Type and configuration of hydro plant penstock(s).
 * @param plantDischargeCapacity Total plant discharge capacity.
 * @param plantRatedHead The plant's rated gross head.
 * @param pumpRatedP The hydro plant's pumping rating active power for rated head conditions.
 * @param surgeTankCode A code describing the type (or absence) of surge tank that is associated with the hydro power plant.
 * @param surgeTankCrestLevel The level at which the surge tank spills.
 * @param GenSourcePumpDischargeReservoir Generators are supplied water from or pumps discharge water to an upstream reservoir.
 * @param Reservoir Generators discharge water to or pumps are supplied water from a downstream reservoir.
 */
case class HydroPowerPlant
(
    override val sup: PowerSystemResource,
    val dischargeTravelDelay: Double,
    val genRatedP: Double,
    val hydroPlantStorageType: String,
    val penstockType: String,
    val plantDischargeCapacity: Double,
    val plantRatedHead: Double,
    val pumpRatedP: Double,
    val surgeTankCode: String,
    val surgeTankCrestLevel: Double,
    val GenSourcePumpDischargeReservoir: String,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, null, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[HydroPowerPlant] }
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
        "\t\t<cim:HydroPowerPlant.dischargeTravelDelay>" + dischargeTravelDelay + "</cim:HydroPowerPlant.dischargeTravelDelay>\n" +
        "\t\t<cim:HydroPowerPlant.genRatedP>" + genRatedP + "</cim:HydroPowerPlant.genRatedP>\n" +
        (if (null != hydroPlantStorageType) "\t\t<cim:HydroPowerPlant.hydroPlantStorageType rdf:resource=\"#" + hydroPlantStorageType + "\"/>\n" else "") +
        (if (null != penstockType) "\t\t<cim:HydroPowerPlant.penstockType>" + penstockType + "</cim:HydroPowerPlant.penstockType>\n" else "") +
        "\t\t<cim:HydroPowerPlant.plantDischargeCapacity>" + plantDischargeCapacity + "</cim:HydroPowerPlant.plantDischargeCapacity>\n" +
        "\t\t<cim:HydroPowerPlant.plantRatedHead>" + plantRatedHead + "</cim:HydroPowerPlant.plantRatedHead>\n" +
        "\t\t<cim:HydroPowerPlant.pumpRatedP>" + pumpRatedP + "</cim:HydroPowerPlant.pumpRatedP>\n" +
        (if (null != surgeTankCode) "\t\t<cim:HydroPowerPlant.surgeTankCode>" + surgeTankCode + "</cim:HydroPowerPlant.surgeTankCode>\n" else "") +
        "\t\t<cim:HydroPowerPlant.surgeTankCrestLevel>" + surgeTankCrestLevel + "</cim:HydroPowerPlant.surgeTankCrestLevel>\n" +
        (if (null != GenSourcePumpDischargeReservoir) "\t\t<cim:HydroPowerPlant.GenSourcePumpDischargeReservoir rdf:resource=\"#" + GenSourcePumpDischargeReservoir + "\"/>\n" else "") +
        (if (null != Reservoir) "\t\t<cim:HydroPowerPlant.Reservoir rdf:resource=\"#" + Reservoir + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroPowerPlant rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroPowerPlant>\n"
    }
}

object HydroPowerPlant
extends
    Parseable[HydroPowerPlant]
{
    val dischargeTravelDelay = parse_element (element ("""HydroPowerPlant.dischargeTravelDelay"""))
    val genRatedP = parse_element (element ("""HydroPowerPlant.genRatedP"""))
    val hydroPlantStorageType = parse_attribute (attribute ("""HydroPowerPlant.hydroPlantStorageType"""))
    val penstockType = parse_element (element ("""HydroPowerPlant.penstockType"""))
    val plantDischargeCapacity = parse_element (element ("""HydroPowerPlant.plantDischargeCapacity"""))
    val plantRatedHead = parse_element (element ("""HydroPowerPlant.plantRatedHead"""))
    val pumpRatedP = parse_element (element ("""HydroPowerPlant.pumpRatedP"""))
    val surgeTankCode = parse_element (element ("""HydroPowerPlant.surgeTankCode"""))
    val surgeTankCrestLevel = parse_element (element ("""HydroPowerPlant.surgeTankCrestLevel"""))
    val GenSourcePumpDischargeReservoir = parse_attribute (attribute ("""HydroPowerPlant.GenSourcePumpDischargeReservoir"""))
    val Reservoir = parse_attribute (attribute ("""HydroPowerPlant.Reservoir"""))
    def parse (context: Context): HydroPowerPlant =
    {
        HydroPowerPlant(
            PowerSystemResource.parse (context),
            toDouble (dischargeTravelDelay (context), context),
            toDouble (genRatedP (context), context),
            hydroPlantStorageType (context),
            penstockType (context),
            toDouble (plantDischargeCapacity (context), context),
            toDouble (plantRatedHead (context), context),
            toDouble (pumpRatedP (context), context),
            surgeTankCode (context),
            toDouble (surgeTankCrestLevel (context), context),
            GenSourcePumpDischargeReservoir (context),
            Reservoir (context)
        )
    }
}

/**
 * A synchronous motor-driven pump, typically associated with a pumped storage plant.
 * @param sup Reference to the superclass object.
 * @param pumpDischAtMaxHead The pumping discharge under maximum head conditions, usually at full gate.
 * @param pumpDischAtMinHead The pumping discharge under minimum head conditions, usually at full gate.
 * @param pumpPowerAtMaxHead The pumping power under maximum head conditions, usually at full gate.
 * @param pumpPowerAtMinHead The pumping power under minimum head conditions, usually at full gate.
 * @param HydroPowerPlant The hydro pump may be a member of a pumped storage plant or a pump for distributing water.
 * @param HydroPumpOpSchedule The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
 * @param RotatingMachine The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation.
 *        The direction of machine rotation for pumping may or may not be the same as for generating.
 */
case class HydroPump
(
    override val sup: Equipment,
    val pumpDischAtMaxHead: Double,
    val pumpDischAtMinHead: Double,
    val pumpPowerAtMaxHead: Double,
    val pumpPowerAtMinHead: Double,
    val HydroPowerPlant: String,
    val HydroPumpOpSchedule: String,
    val RotatingMachine: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[HydroPump] }
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
        "\t\t<cim:HydroPump.pumpDischAtMaxHead>" + pumpDischAtMaxHead + "</cim:HydroPump.pumpDischAtMaxHead>\n" +
        "\t\t<cim:HydroPump.pumpDischAtMinHead>" + pumpDischAtMinHead + "</cim:HydroPump.pumpDischAtMinHead>\n" +
        "\t\t<cim:HydroPump.pumpPowerAtMaxHead>" + pumpPowerAtMaxHead + "</cim:HydroPump.pumpPowerAtMaxHead>\n" +
        "\t\t<cim:HydroPump.pumpPowerAtMinHead>" + pumpPowerAtMinHead + "</cim:HydroPump.pumpPowerAtMinHead>\n" +
        (if (null != HydroPowerPlant) "\t\t<cim:HydroPump.HydroPowerPlant rdf:resource=\"#" + HydroPowerPlant + "\"/>\n" else "") +
        (if (null != HydroPumpOpSchedule) "\t\t<cim:HydroPump.HydroPumpOpSchedule rdf:resource=\"#" + HydroPumpOpSchedule + "\"/>\n" else "") +
        (if (null != RotatingMachine) "\t\t<cim:HydroPump.RotatingMachine rdf:resource=\"#" + RotatingMachine + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroPump rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroPump>\n"
    }
}

object HydroPump
extends
    Parseable[HydroPump]
{
    val pumpDischAtMaxHead = parse_element (element ("""HydroPump.pumpDischAtMaxHead"""))
    val pumpDischAtMinHead = parse_element (element ("""HydroPump.pumpDischAtMinHead"""))
    val pumpPowerAtMaxHead = parse_element (element ("""HydroPump.pumpPowerAtMaxHead"""))
    val pumpPowerAtMinHead = parse_element (element ("""HydroPump.pumpPowerAtMinHead"""))
    val HydroPowerPlant = parse_attribute (attribute ("""HydroPump.HydroPowerPlant"""))
    val HydroPumpOpSchedule = parse_attribute (attribute ("""HydroPump.HydroPumpOpSchedule"""))
    val RotatingMachine = parse_attribute (attribute ("""HydroPump.RotatingMachine"""))
    def parse (context: Context): HydroPump =
    {
        HydroPump(
            Equipment.parse (context),
            toDouble (pumpDischAtMaxHead (context), context),
            toDouble (pumpDischAtMinHead (context), context),
            toDouble (pumpPowerAtMaxHead (context), context),
            toDouble (pumpPowerAtMinHead (context), context),
            HydroPowerPlant (context),
            HydroPumpOpSchedule (context),
            RotatingMachine (context)
        )
    }
}

/**
 * The hydro pump's Operator-approved current operating schedule (or plan), typically produced with the aid of unit commitment type analyses.
 * The unit's operating schedule status is typically given as: (0=unavailable) (1=avilable to startup or shutdown)  (2=must pump).
 * @param sup Reference to the superclass object.
 * @param HydroPump The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
 */
case class HydroPumpOpSchedule
(
    override val sup: RegularIntervalSchedule,
    val HydroPump: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[HydroPumpOpSchedule] }
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
        (if (null != HydroPump) "\t\t<cim:HydroPumpOpSchedule.HydroPump rdf:resource=\"#" + HydroPump + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:HydroPumpOpSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroPumpOpSchedule>\n"
    }
}

object HydroPumpOpSchedule
extends
    Parseable[HydroPumpOpSchedule]
{
    val HydroPump = parse_attribute (attribute ("""HydroPumpOpSchedule.HydroPump"""))
    def parse (context: Context): HydroPumpOpSchedule =
    {
        HydroPumpOpSchedule(
            RegularIntervalSchedule.parse (context),
            HydroPump (context)
        )
    }
}

/**
 * Relationship between unit incremental heat rate in (delta energy/time) per (delta active power) and unit output in active power.
 * The IHR curve represents the slope of the HeatInputCurve. Note that the "incremental heat rate" and the "heat rate" have the same engineering units.
 * @param sup Reference to the superclass object.
 * @param isNetGrossP Flag is set to true when output is expressed in net active power.
 * @param ThermalGeneratingUnit A thermal generating unit may have an incremental heat rate curve.
 */
case class IncrementalHeatRateCurve
(
    override val sup: Curve,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[IncrementalHeatRateCurve] }
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
        "\t\t<cim:IncrementalHeatRateCurve.isNetGrossP>" + isNetGrossP + "</cim:IncrementalHeatRateCurve.isNetGrossP>\n" +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:IncrementalHeatRateCurve.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IncrementalHeatRateCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IncrementalHeatRateCurve>\n"
    }
}

object IncrementalHeatRateCurve
extends
    Parseable[IncrementalHeatRateCurve]
{
    val isNetGrossP = parse_element (element ("""IncrementalHeatRateCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""IncrementalHeatRateCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): IncrementalHeatRateCurve =
    {
        IncrementalHeatRateCurve(
            Curve.parse (context),
            toBoolean (isNetGrossP (context), context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * Natural water inflow to a reservoir, usually forecasted from predicted rain and snowmelt.
 * Typically in one hour increments for up to 10 days. The forecast is given in average cubic meters per second over the time increment.
 * @param sup Reference to the superclass object.
 * @param Reservoir A reservoir may have a "natural" inflow forecast.
 */
case class InflowForecast
(
    override val sup: RegularIntervalSchedule,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[InflowForecast] }
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
        (if (null != Reservoir) "\t\t<cim:InflowForecast.Reservoir rdf:resource=\"#" + Reservoir + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InflowForecast rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InflowForecast>\n"
    }
}

object InflowForecast
extends
    Parseable[InflowForecast]
{
    val Reservoir = parse_attribute (attribute ("""InflowForecast.Reservoir"""))
    def parse (context: Context): InflowForecast =
    {
        InflowForecast(
            RegularIntervalSchedule.parse (context),
            Reservoir (context)
        )
    }
}

/**
 * Relationship between reservoir volume and reservoir level.
 * The  volume is at the y-axis and the reservoir level at the x-axis.
 * @param sup Reference to the superclass object.
 * @param Reservoir A reservoir may have a level versus volume relationship.
 */
case class LevelVsVolumeCurve
(
    override val sup: Curve,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[LevelVsVolumeCurve] }
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
        (if (null != Reservoir) "\t\t<cim:LevelVsVolumeCurve.Reservoir rdf:resource=\"#" + Reservoir + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LevelVsVolumeCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LevelVsVolumeCurve>\n"
    }
}

object LevelVsVolumeCurve
extends
    Parseable[LevelVsVolumeCurve]
{
    val Reservoir = parse_attribute (attribute ("""LevelVsVolumeCurve.Reservoir"""))
    def parse (context: Context): LevelVsVolumeCurve =
    {
        LevelVsVolumeCurve(
            Curve.parse (context),
            Reservoir (context)
        )
    }
}

/**
 * A nuclear generating unit.
 * @param sup Reference to the superclass object.
 */
case class NuclearGeneratingUnit
(
    override val sup: GeneratingUnit
)
extends
    Element
{
    def this () = { this (null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[NuclearGeneratingUnit] }
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
        "\t<cim:NuclearGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NuclearGeneratingUnit>\n"
    }
}

object NuclearGeneratingUnit
extends
    Parseable[NuclearGeneratingUnit]
{
    def parse (context: Context): NuclearGeneratingUnit =
    {
        NuclearGeneratingUnit(
            GeneratingUnit.parse (context)
        )
    }
}

/**
 * Relationship between penstock head loss (in meters) and  total discharge through the penstock (in cubic meters per second).
 * One or more turbines may be connected to the same penstock.
 * @param sup Reference to the superclass object.
 * @param HydroGeneratingUnit A hydro generating unit has a penstock loss curve.
 */
case class PenstockLossCurve
(
    override val sup: Curve,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[PenstockLossCurve] }
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
        (if (null != HydroGeneratingUnit) "\t\t<cim:PenstockLossCurve.HydroGeneratingUnit rdf:resource=\"#" + HydroGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PenstockLossCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PenstockLossCurve>\n"
    }
}

object PenstockLossCurve
extends
    Parseable[PenstockLossCurve]
{
    val HydroGeneratingUnit = parse_attribute (attribute ("""PenstockLossCurve.HydroGeneratingUnit"""))
    def parse (context: Context): PenstockLossCurve =
    {
        PenstockLossCurve(
            Curve.parse (context),
            HydroGeneratingUnit (context)
        )
    }
}

/**
 * A water storage facility within a hydro system, including: ponds, lakes, lagoons, and rivers.
 * The storage is usually behind some type of dam.
 * @param sup Reference to the superclass object.
 * @param activeStorageCapacity Storage volume between the full supply level and the normal minimum operating level.
 * @param energyStorageRating The reservoir's energy storage rating in energy for given head conditions.
 * @param fullSupplyLevel Full supply level, above which water will spill.
 *        This can be the spillway crest level or the top of closed gates.
 * @param grossCapacity Total capacity of reservoir.
 * @param normalMinOperateLevel Normal minimum operating level below which the penstocks will draw air.
 * @param riverOutletWorks River outlet works for riparian right releases or other purposes.
 * @param spillTravelDelay The spillway water travel delay to the next downstream reservoir.
 * @param spillWayGateType Type of spillway gate, including parameters.
 * @param spillwayCapacity The flow capacity of the spillway in cubic meters per second.
 * @param spillwayCrestLength The length of the spillway crest.
 * @param spillwayCrestLevel Spillway crest level above which water will spill.
 * @param SpillsFromReservoir A reservoir may spill into a downstream reservoir.
 * @param TargetLevelSchedule A reservoir may have a water level target schedule.
 */
case class Reservoir
(
    override val sup: PowerSystemResource,
    val activeStorageCapacity: Double,
    val energyStorageRating: Double,
    val fullSupplyLevel: Double,
    val grossCapacity: Double,
    val normalMinOperateLevel: Double,
    val riverOutletWorks: String,
    val spillTravelDelay: Double,
    val spillWayGateType: String,
    val spillwayCapacity: Double,
    val spillwayCrestLength: Double,
    val spillwayCrestLevel: Double,
    val SpillsFromReservoir: String,
    val TargetLevelSchedule: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, null, 0.0, 0.0, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[Reservoir] }
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
        "\t\t<cim:Reservoir.activeStorageCapacity>" + activeStorageCapacity + "</cim:Reservoir.activeStorageCapacity>\n" +
        "\t\t<cim:Reservoir.energyStorageRating>" + energyStorageRating + "</cim:Reservoir.energyStorageRating>\n" +
        "\t\t<cim:Reservoir.fullSupplyLevel>" + fullSupplyLevel + "</cim:Reservoir.fullSupplyLevel>\n" +
        "\t\t<cim:Reservoir.grossCapacity>" + grossCapacity + "</cim:Reservoir.grossCapacity>\n" +
        "\t\t<cim:Reservoir.normalMinOperateLevel>" + normalMinOperateLevel + "</cim:Reservoir.normalMinOperateLevel>\n" +
        (if (null != riverOutletWorks) "\t\t<cim:Reservoir.riverOutletWorks>" + riverOutletWorks + "</cim:Reservoir.riverOutletWorks>\n" else "") +
        "\t\t<cim:Reservoir.spillTravelDelay>" + spillTravelDelay + "</cim:Reservoir.spillTravelDelay>\n" +
        (if (null != spillWayGateType) "\t\t<cim:Reservoir.spillWayGateType>" + spillWayGateType + "</cim:Reservoir.spillWayGateType>\n" else "") +
        "\t\t<cim:Reservoir.spillwayCapacity>" + spillwayCapacity + "</cim:Reservoir.spillwayCapacity>\n" +
        "\t\t<cim:Reservoir.spillwayCrestLength>" + spillwayCrestLength + "</cim:Reservoir.spillwayCrestLength>\n" +
        "\t\t<cim:Reservoir.spillwayCrestLevel>" + spillwayCrestLevel + "</cim:Reservoir.spillwayCrestLevel>\n" +
        (if (null != SpillsFromReservoir) "\t\t<cim:Reservoir.SpillsFromReservoir rdf:resource=\"#" + SpillsFromReservoir + "\"/>\n" else "") +
        (if (null != TargetLevelSchedule) "\t\t<cim:Reservoir.TargetLevelSchedule rdf:resource=\"#" + TargetLevelSchedule + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Reservoir rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Reservoir>\n"
    }
}

object Reservoir
extends
    Parseable[Reservoir]
{
    val activeStorageCapacity = parse_element (element ("""Reservoir.activeStorageCapacity"""))
    val energyStorageRating = parse_element (element ("""Reservoir.energyStorageRating"""))
    val fullSupplyLevel = parse_element (element ("""Reservoir.fullSupplyLevel"""))
    val grossCapacity = parse_element (element ("""Reservoir.grossCapacity"""))
    val normalMinOperateLevel = parse_element (element ("""Reservoir.normalMinOperateLevel"""))
    val riverOutletWorks = parse_element (element ("""Reservoir.riverOutletWorks"""))
    val spillTravelDelay = parse_element (element ("""Reservoir.spillTravelDelay"""))
    val spillWayGateType = parse_element (element ("""Reservoir.spillWayGateType"""))
    val spillwayCapacity = parse_element (element ("""Reservoir.spillwayCapacity"""))
    val spillwayCrestLength = parse_element (element ("""Reservoir.spillwayCrestLength"""))
    val spillwayCrestLevel = parse_element (element ("""Reservoir.spillwayCrestLevel"""))
    val SpillsFromReservoir = parse_attribute (attribute ("""Reservoir.SpillsFromReservoir"""))
    val TargetLevelSchedule = parse_attribute (attribute ("""Reservoir.TargetLevelSchedule"""))
    def parse (context: Context): Reservoir =
    {
        Reservoir(
            PowerSystemResource.parse (context),
            toDouble (activeStorageCapacity (context), context),
            toDouble (energyStorageRating (context), context),
            toDouble (fullSupplyLevel (context), context),
            toDouble (grossCapacity (context), context),
            toDouble (normalMinOperateLevel (context), context),
            riverOutletWorks (context),
            toDouble (spillTravelDelay (context), context),
            spillWayGateType (context),
            toDouble (spillwayCapacity (context), context),
            toDouble (spillwayCrestLength (context), context),
            toDouble (spillwayCrestLevel (context), context),
            SpillsFromReservoir (context),
            TargetLevelSchedule (context)
        )
    }
}

/**
 * Relationship between the rate in gross active power/minute (Y-axis) at which a unit should be shutdown and its present gross MW output (X-axis).
 * @param sup Reference to the superclass object.
 * @param shutdownCost Fixed shutdown cost.
 * @param shutdownDate The date and time of the most recent generating unit shutdown.
 * @param ThermalGeneratingUnit A thermal generating unit may have a shutdown curve.
 */
case class ShutdownCurve
(
    override val sup: Curve,
    val shutdownCost: Double,
    val shutdownDate: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[ShutdownCurve] }
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
        "\t\t<cim:ShutdownCurve.shutdownCost>" + shutdownCost + "</cim:ShutdownCurve.shutdownCost>\n" +
        (if (null != shutdownDate) "\t\t<cim:ShutdownCurve.shutdownDate>" + shutdownDate + "</cim:ShutdownCurve.shutdownDate>\n" else "") +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:ShutdownCurve.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShutdownCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShutdownCurve>\n"
    }
}

object ShutdownCurve
extends
    Parseable[ShutdownCurve]
{
    val shutdownCost = parse_element (element ("""ShutdownCurve.shutdownCost"""))
    val shutdownDate = parse_element (element ("""ShutdownCurve.shutdownDate"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""ShutdownCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): ShutdownCurve =
    {
        ShutdownCurve(
            Curve.parse (context),
            toDouble (shutdownCost (context), context),
            shutdownDate (context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * A solar thermal generating unit.
 * @param sup Reference to the superclass object.
 */
case class SolarGeneratingUnit
(
    override val sup: GeneratingUnit
)
extends
    Element
{
    def this () = { this (null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[SolarGeneratingUnit] }
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
        "\t<cim:SolarGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SolarGeneratingUnit>\n"
    }
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
{
    def parse (context: Context): SolarGeneratingUnit =
    {
        SolarGeneratingUnit(
            GeneratingUnit.parse (context)
        )
    }
}

/**
 * The quantity of ignition fuel (Y-axis) used to restart and repay the auxiliary power consumed versus the number of hours (X-axis) the unit was off line.
 * @param sup Reference to the superclass object.
 * @param ignitionFuelType Type of ignition fuel.
 * @param StartupModel The unit's startup model may have a startup ignition fuel curve.
 */
case class StartIgnFuelCurve
(
    override val sup: Curve,
    val ignitionFuelType: String,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartIgnFuelCurve] }
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
        (if (null != ignitionFuelType) "\t\t<cim:StartIgnFuelCurve.ignitionFuelType rdf:resource=\"#" + ignitionFuelType + "\"/>\n" else "") +
        (if (null != StartupModel) "\t\t<cim:StartIgnFuelCurve.StartupModel rdf:resource=\"#" + StartupModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartIgnFuelCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartIgnFuelCurve>\n"
    }
}

object StartIgnFuelCurve
extends
    Parseable[StartIgnFuelCurve]
{
    val ignitionFuelType = parse_attribute (attribute ("""StartIgnFuelCurve.ignitionFuelType"""))
    val StartupModel = parse_attribute (attribute ("""StartIgnFuelCurve.StartupModel"""))
    def parse (context: Context): StartIgnFuelCurve =
    {
        StartIgnFuelCurve(
            Curve.parse (context),
            ignitionFuelType (context),
            StartupModel (context)
        )
    }
}

/**
 * The quantity of main fuel (Y-axis) used to restart and repay the auxiliary power consumed versus the number of hours (X-axis) the unit was off line.
 * @param sup Reference to the superclass object.
 * @param mainFuelType Type of main fuel.
 * @param StartupModel The unit's startup model may have a startup main fuel curve.
 */
case class StartMainFuelCurve
(
    override val sup: Curve,
    val mainFuelType: String,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartMainFuelCurve] }
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
        (if (null != mainFuelType) "\t\t<cim:StartMainFuelCurve.mainFuelType rdf:resource=\"#" + mainFuelType + "\"/>\n" else "") +
        (if (null != StartupModel) "\t\t<cim:StartMainFuelCurve.StartupModel rdf:resource=\"#" + StartupModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartMainFuelCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartMainFuelCurve>\n"
    }
}

object StartMainFuelCurve
extends
    Parseable[StartMainFuelCurve]
{
    val mainFuelType = parse_attribute (attribute ("""StartMainFuelCurve.mainFuelType"""))
    val StartupModel = parse_attribute (attribute ("""StartMainFuelCurve.StartupModel"""))
    def parse (context: Context): StartMainFuelCurve =
    {
        StartMainFuelCurve(
            Curve.parse (context),
            mainFuelType (context),
            StartupModel (context)
        )
    }
}

/**
 * Rate in gross active power/minute (Y-axis) at which a unit can be loaded versus the number of hours (X-axis) the unit was off line.
 * @param sup Reference to the superclass object.
 * @param hotStandbyRamp The startup ramp rate in gross for a unit that is on hot standby.
 * @param StartupModel The unit's startup model may have a startup ramp curve.
 */
case class StartRampCurve
(
    override val sup: Curve,
    val hotStandbyRamp: Double,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[StartRampCurve] }
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
        "\t\t<cim:StartRampCurve.hotStandbyRamp>" + hotStandbyRamp + "</cim:StartRampCurve.hotStandbyRamp>\n" +
        (if (null != StartupModel) "\t\t<cim:StartRampCurve.StartupModel rdf:resource=\"#" + StartupModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartRampCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartRampCurve>\n"
    }
}

object StartRampCurve
extends
    Parseable[StartRampCurve]
{
    val hotStandbyRamp = parse_element (element ("""StartRampCurve.hotStandbyRamp"""))
    val StartupModel = parse_attribute (attribute ("""StartRampCurve.StartupModel"""))
    def parse (context: Context): StartRampCurve =
    {
        StartRampCurve(
            Curve.parse (context),
            toDouble (hotStandbyRamp (context), context),
            StartupModel (context)
        )
    }
}

/**
 * Unit start up characteristics depending on how long the unit has been off line.
 * @param sup Reference to the superclass object.
 * @param fixedMaintCost Fixed maintenance cost.
 * @param hotStandbyHeat The amount of heat input per time uint required for hot standby operation.
 * @param incrementalMaintCost Incremental maintenance cost.
 * @param minimumDownTime The minimum number of hours the unit must be down before restart.
 * @param minimumRunTime The minimum number of hours the unit must be operating before being allowed to shut down.
 * @param riskFactorCost The opportunity cost associated with the return in monetary unit.
 *        This represents the restart's "share" of the unit depreciation and risk of an event which would damage the unit.
 * @param startupCost Total miscellaneous start up costs.
 * @param startupDate The date and time of the most recent generating unit startup.
 * @param startupPriority Startup priority within control area where lower numbers indicate higher priorities.
 *        More than one unit in an area may be assigned the same priority.
 * @param stbyAuxP The unit's auxiliary active power consumption to maintain standby mode.
 * @param StartIgnFuelCurve The unit's startup model may have a startup ignition fuel curve.
 * @param StartMainFuelCurve The unit's startup model may have a startup main fuel curve.
 * @param StartRampCurve The unit's startup model may have a startup ramp curve.
 * @param ThermalGeneratingUnit A thermal generating unit may have a startup model.
 */
case class StartupModel
(
    override val sup: IdentifiedObject,
    val fixedMaintCost: Double,
    val hotStandbyHeat: String,
    val incrementalMaintCost: Double,
    val minimumDownTime: Double,
    val minimumRunTime: Double,
    val riskFactorCost: Double,
    val startupCost: Double,
    val startupDate: String,
    val startupPriority: Int,
    val stbyAuxP: Double,
    val StartIgnFuelCurve: String,
    val StartMainFuelCurve: String,
    val StartRampCurve: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[StartupModel] }
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
        "\t\t<cim:StartupModel.fixedMaintCost>" + fixedMaintCost + "</cim:StartupModel.fixedMaintCost>\n" +
        (if (null != hotStandbyHeat) "\t\t<cim:StartupModel.hotStandbyHeat rdf:resource=\"#" + hotStandbyHeat + "\"/>\n" else "") +
        "\t\t<cim:StartupModel.incrementalMaintCost>" + incrementalMaintCost + "</cim:StartupModel.incrementalMaintCost>\n" +
        "\t\t<cim:StartupModel.minimumDownTime>" + minimumDownTime + "</cim:StartupModel.minimumDownTime>\n" +
        "\t\t<cim:StartupModel.minimumRunTime>" + minimumRunTime + "</cim:StartupModel.minimumRunTime>\n" +
        "\t\t<cim:StartupModel.riskFactorCost>" + riskFactorCost + "</cim:StartupModel.riskFactorCost>\n" +
        "\t\t<cim:StartupModel.startupCost>" + startupCost + "</cim:StartupModel.startupCost>\n" +
        (if (null != startupDate) "\t\t<cim:StartupModel.startupDate>" + startupDate + "</cim:StartupModel.startupDate>\n" else "") +
        "\t\t<cim:StartupModel.startupPriority>" + startupPriority + "</cim:StartupModel.startupPriority>\n" +
        "\t\t<cim:StartupModel.stbyAuxP>" + stbyAuxP + "</cim:StartupModel.stbyAuxP>\n" +
        (if (null != StartIgnFuelCurve) "\t\t<cim:StartupModel.StartIgnFuelCurve rdf:resource=\"#" + StartIgnFuelCurve + "\"/>\n" else "") +
        (if (null != StartMainFuelCurve) "\t\t<cim:StartupModel.StartMainFuelCurve rdf:resource=\"#" + StartMainFuelCurve + "\"/>\n" else "") +
        (if (null != StartRampCurve) "\t\t<cim:StartupModel.StartRampCurve rdf:resource=\"#" + StartRampCurve + "\"/>\n" else "") +
        (if (null != ThermalGeneratingUnit) "\t\t<cim:StartupModel.ThermalGeneratingUnit rdf:resource=\"#" + ThermalGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:StartupModel rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:StartupModel>\n"
    }
}

object StartupModel
extends
    Parseable[StartupModel]
{
    val fixedMaintCost = parse_element (element ("""StartupModel.fixedMaintCost"""))
    val hotStandbyHeat = parse_attribute (attribute ("""StartupModel.hotStandbyHeat"""))
    val incrementalMaintCost = parse_element (element ("""StartupModel.incrementalMaintCost"""))
    val minimumDownTime = parse_element (element ("""StartupModel.minimumDownTime"""))
    val minimumRunTime = parse_element (element ("""StartupModel.minimumRunTime"""))
    val riskFactorCost = parse_element (element ("""StartupModel.riskFactorCost"""))
    val startupCost = parse_element (element ("""StartupModel.startupCost"""))
    val startupDate = parse_element (element ("""StartupModel.startupDate"""))
    val startupPriority = parse_element (element ("""StartupModel.startupPriority"""))
    val stbyAuxP = parse_element (element ("""StartupModel.stbyAuxP"""))
    val StartIgnFuelCurve = parse_attribute (attribute ("""StartupModel.StartIgnFuelCurve"""))
    val StartMainFuelCurve = parse_attribute (attribute ("""StartupModel.StartMainFuelCurve"""))
    val StartRampCurve = parse_attribute (attribute ("""StartupModel.StartRampCurve"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""StartupModel.ThermalGeneratingUnit"""))
    def parse (context: Context): StartupModel =
    {
        StartupModel(
            IdentifiedObject.parse (context),
            toDouble (fixedMaintCost (context), context),
            hotStandbyHeat (context),
            toDouble (incrementalMaintCost (context), context),
            toDouble (minimumDownTime (context), context),
            toDouble (minimumRunTime (context), context),
            toDouble (riskFactorCost (context), context),
            toDouble (startupCost (context), context),
            startupDate (context),
            toInteger (startupPriority (context), context),
            toDouble (stbyAuxP (context), context),
            StartIgnFuelCurve (context),
            StartMainFuelCurve (context),
            StartRampCurve (context),
            ThermalGeneratingUnit (context)
        )
    }
}

/**
 * The cogeneration plant's steam sendout schedule in volume per time unit.
 * @param sup Reference to the superclass object.
 * @param CogenerationPlant A cogeneration plant has a steam sendout schedule.
 */
case class SteamSendoutSchedule
(
    override val sup: RegularIntervalSchedule,
    val CogenerationPlant: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[SteamSendoutSchedule] }
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
        (if (null != CogenerationPlant) "\t\t<cim:SteamSendoutSchedule.CogenerationPlant rdf:resource=\"#" + CogenerationPlant + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SteamSendoutSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SteamSendoutSchedule>\n"
    }
}

object SteamSendoutSchedule
extends
    Parseable[SteamSendoutSchedule]
{
    val CogenerationPlant = parse_attribute (attribute ("""SteamSendoutSchedule.CogenerationPlant"""))
    def parse (context: Context): SteamSendoutSchedule =
    {
        SteamSendoutSchedule(
            RegularIntervalSchedule.parse (context),
            CogenerationPlant (context)
        )
    }
}

/**
 * Relationship between tailbay head loss hight (y-axis) and the total discharge into the power station's tailbay volume per time unit (x-axis) .
 * There could be more than one curve depending on the level of the tailbay reservoir or river level.
 * @param sup Reference to the superclass object.
 * @param HydroGeneratingUnit A hydro generating unit has a tailbay loss curve.
 */
case class TailbayLossCurve
(
    override val sup: Curve,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[TailbayLossCurve] }
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
        (if (null != HydroGeneratingUnit) "\t\t<cim:TailbayLossCurve.HydroGeneratingUnit rdf:resource=\"#" + HydroGeneratingUnit + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TailbayLossCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TailbayLossCurve>\n"
    }
}

object TailbayLossCurve
extends
    Parseable[TailbayLossCurve]
{
    val HydroGeneratingUnit = parse_attribute (attribute ("""TailbayLossCurve.HydroGeneratingUnit"""))
    def parse (context: Context): TailbayLossCurve =
    {
        TailbayLossCurve(
            Curve.parse (context),
            HydroGeneratingUnit (context)
        )
    }
}

/**
 * Reservoir water level targets from advanced studies or "rule curves".
 * Typically in one hour increments for up to 10 days.
 * @param sup Reference to the superclass object.
 * @param highLevelLimit High target level limit, above which the reservoir operation will be penalized.
 * @param lowLevelLimit Low target level limit, below which the reservoir operation will be penalized.
 * @param Reservoir A reservoir may have a water level target schedule.
 */
case class TargetLevelSchedule
(
    override val sup: Curve,
    val highLevelLimit: Double,
    val lowLevelLimit: Double,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[TargetLevelSchedule] }
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
        "\t\t<cim:TargetLevelSchedule.highLevelLimit>" + highLevelLimit + "</cim:TargetLevelSchedule.highLevelLimit>\n" +
        "\t\t<cim:TargetLevelSchedule.lowLevelLimit>" + lowLevelLimit + "</cim:TargetLevelSchedule.lowLevelLimit>\n" +
        (if (null != Reservoir) "\t\t<cim:TargetLevelSchedule.Reservoir rdf:resource=\"#" + Reservoir + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TargetLevelSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TargetLevelSchedule>\n"
    }
}

object TargetLevelSchedule
extends
    Parseable[TargetLevelSchedule]
{
    val highLevelLimit = parse_element (element ("""TargetLevelSchedule.highLevelLimit"""))
    val lowLevelLimit = parse_element (element ("""TargetLevelSchedule.lowLevelLimit"""))
    val Reservoir = parse_attribute (attribute ("""TargetLevelSchedule.Reservoir"""))
    def parse (context: Context): TargetLevelSchedule =
    {
        TargetLevelSchedule(
            Curve.parse (context),
            toDouble (highLevelLimit (context), context),
            toDouble (lowLevelLimit (context), context),
            Reservoir (context)
        )
    }
}

/**
 * A generating unit whose prime mover could be a steam turbine, combustion turbine, or diesel engine.
 * @param sup Reference to the superclass object.
 * @param oMCost Operating and maintenance cost for the thermal unit.
 * @param CAESPlant A thermal generating unit may be a member of a compressed air energy storage plant.
 * @param CogenerationPlant A thermal generating unit may be a member of a cogeneration plant.
 * @param CombinedCyclePlant A thermal generating unit may be a member of a combined cycle plant.
 * @param HeatInputCurve A thermal generating unit may have a heat input curve.
 * @param HeatRateCurve A thermal generating unit may have a heat rate curve.
 * @param IncrementalHeatRateCurve A thermal generating unit may have an incremental heat rate curve.
 * @param ShutdownCurve A thermal generating unit may have a shutdown curve.
 * @param StartupModel A thermal generating unit may have a startup model.
 */
case class ThermalGeneratingUnit
(
    override val sup: GeneratingUnit,
    val oMCost: String,
    val CAESPlant: String,
    val CogenerationPlant: String,
    val CombinedCyclePlant: String,
    val HeatInputCurve: String,
    val HeatRateCurve: String,
    val IncrementalHeatRateCurve: String,
    val ShutdownCurve: String,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[ThermalGeneratingUnit] }
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
        (if (null != oMCost) "\t\t<cim:ThermalGeneratingUnit.oMCost rdf:resource=\"#" + oMCost + "\"/>\n" else "") +
        (if (null != CAESPlant) "\t\t<cim:ThermalGeneratingUnit.CAESPlant rdf:resource=\"#" + CAESPlant + "\"/>\n" else "") +
        (if (null != CogenerationPlant) "\t\t<cim:ThermalGeneratingUnit.CogenerationPlant rdf:resource=\"#" + CogenerationPlant + "\"/>\n" else "") +
        (if (null != CombinedCyclePlant) "\t\t<cim:ThermalGeneratingUnit.CombinedCyclePlant rdf:resource=\"#" + CombinedCyclePlant + "\"/>\n" else "") +
        (if (null != HeatInputCurve) "\t\t<cim:ThermalGeneratingUnit.HeatInputCurve rdf:resource=\"#" + HeatInputCurve + "\"/>\n" else "") +
        (if (null != HeatRateCurve) "\t\t<cim:ThermalGeneratingUnit.HeatRateCurve rdf:resource=\"#" + HeatRateCurve + "\"/>\n" else "") +
        (if (null != IncrementalHeatRateCurve) "\t\t<cim:ThermalGeneratingUnit.IncrementalHeatRateCurve rdf:resource=\"#" + IncrementalHeatRateCurve + "\"/>\n" else "") +
        (if (null != ShutdownCurve) "\t\t<cim:ThermalGeneratingUnit.ShutdownCurve rdf:resource=\"#" + ShutdownCurve + "\"/>\n" else "") +
        (if (null != StartupModel) "\t\t<cim:ThermalGeneratingUnit.StartupModel rdf:resource=\"#" + StartupModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ThermalGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ThermalGeneratingUnit>\n"
    }
}

object ThermalGeneratingUnit
extends
    Parseable[ThermalGeneratingUnit]
{
    val oMCost = parse_attribute (attribute ("""ThermalGeneratingUnit.oMCost"""))
    val CAESPlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CAESPlant"""))
    val CogenerationPlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CogenerationPlant"""))
    val CombinedCyclePlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CombinedCyclePlant"""))
    val HeatInputCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.HeatInputCurve"""))
    val HeatRateCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.HeatRateCurve"""))
    val IncrementalHeatRateCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.IncrementalHeatRateCurve"""))
    val ShutdownCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.ShutdownCurve"""))
    val StartupModel = parse_attribute (attribute ("""ThermalGeneratingUnit.StartupModel"""))
    def parse (context: Context): ThermalGeneratingUnit =
    {
        ThermalGeneratingUnit(
            GeneratingUnit.parse (context),
            oMCost (context),
            CAESPlant (context),
            CogenerationPlant (context),
            CombinedCyclePlant (context),
            HeatInputCurve (context),
            HeatRateCurve (context),
            IncrementalHeatRateCurve (context),
            ShutdownCurve (context),
            StartupModel (context)
        )
    }
}

/**
 * Kind of wind generating unit.
 * @param sup Reference to the superclass object.
 * @param offshore The wind generating unit is located offshore.
 * @param onshore The wind generating unit is located onshore.
 */
case class WindGenUnitKind
(
    override val sup: BasicElement,
    val offshore: String,
    val onshore: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[WindGenUnitKind] }
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
        (if (null != offshore) "\t\t<cim:WindGenUnitKind.offshore rdf:resource=\"#" + offshore + "\"/>\n" else "") +
        (if (null != onshore) "\t\t<cim:WindGenUnitKind.onshore rdf:resource=\"#" + onshore + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenUnitKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenUnitKind>\n"
    }
}

object WindGenUnitKind
extends
    Parseable[WindGenUnitKind]
{
    val offshore = parse_attribute (attribute ("""WindGenUnitKind.offshore"""))
    val onshore = parse_attribute (attribute ("""WindGenUnitKind.onshore"""))
    def parse (context: Context): WindGenUnitKind =
    {
        WindGenUnitKind(
            BasicElement.parse (context),
            offshore (context),
            onshore (context)
        )
    }
}

/**
 * A wind driven generating unit.
 * May be used to represent a single turbine or an aggregation.
 * @param sup Reference to the superclass object.
 * @param windGenUnitType The kind of wind generating unit
 */
case class WindGeneratingUnit
(
    override val sup: GeneratingUnit,
    val windGenUnitType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { clone ().asInstanceOf[WindGeneratingUnit] }
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
        (if (null != windGenUnitType) "\t\t<cim:WindGeneratingUnit.windGenUnitType rdf:resource=\"#" + windGenUnitType + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGeneratingUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGeneratingUnit>\n"
    }
}

object WindGeneratingUnit
extends
    Parseable[WindGeneratingUnit]
{
    val windGenUnitType = parse_attribute (attribute ("""WindGeneratingUnit.windGenUnitType"""))
    def parse (context: Context): WindGeneratingUnit =
    {
        WindGeneratingUnit(
            GeneratingUnit.parse (context),
            windGenUnitType (context)
        )
    }
}

object _Production
{
    def register: List[ClassInfo] =
    {
        List (
            AirCompressor.register,
            CAESPlant.register,
            Classification.register,
            CogenerationPlant.register,
            CombinedCyclePlant.register,
            CostPerHeatUnit.register,
            Emission.register,
            EmissionAccount.register,
            EmissionCurve.register,
            EmissionType.register,
            EmissionValueSource.register,
            FossilFuel.register,
            FuelAllocationSchedule.register,
            FuelType.register,
            GenUnitOpCostCurve.register,
            GenUnitOpSchedule.register,
            GeneratingUnit.register,
            GeneratorControlMode.register,
            GeneratorControlSource.register,
            GrossToNetActivePowerCurve.register,
            HeatInputCurve.register,
            HeatRate.register,
            HeatRateCurve.register,
            HydroEnergyConversionKind.register,
            HydroGeneratingEfficiencyCurve.register,
            HydroGeneratingUnit.register,
            HydroPlantStorageKind.register,
            HydroPowerPlant.register,
            HydroPump.register,
            HydroPumpOpSchedule.register,
            IncrementalHeatRateCurve.register,
            InflowForecast.register,
            LevelVsVolumeCurve.register,
            NuclearGeneratingUnit.register,
            PenstockLossCurve.register,
            Reservoir.register,
            ShutdownCurve.register,
            SolarGeneratingUnit.register,
            StartIgnFuelCurve.register,
            StartMainFuelCurve.register,
            StartRampCurve.register,
            StartupModel.register,
            SteamSendoutSchedule.register,
            TailbayLossCurve.register,
            TargetLevelSchedule.register,
            ThermalGeneratingUnit.register,
            WindGenUnitKind.register,
            WindGeneratingUnit.register
        )
    }
}