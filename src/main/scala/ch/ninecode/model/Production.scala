package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

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
    override val sup: Element,
    val airCompressorRating: Double,
    val CAESPlant: String,
    val CombustionTurbine: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[AirCompressor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AirCompressor
extends
    Parseable[AirCompressor]
{
    val sup = PowerSystemResource.parse _
    val airCompressorRating = parse_element (element ("""AirCompressor.airCompressorRating"""))
    val CAESPlant = parse_attribute (attribute ("""AirCompressor.CAESPlant"""))
    val CombustionTurbine = parse_attribute (attribute ("""AirCompressor.CombustionTurbine"""))
    def parse (context: Context): AirCompressor =
    {
        AirCompressor(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[CAESPlant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CAESPlant
extends
    Parseable[CAESPlant]
{
    val sup = PowerSystemResource.parse _
    val energyStorageCapacity = parse_element (element ("""CAESPlant.energyStorageCapacity"""))
    val ratedCapacityP = parse_element (element ("""CAESPlant.ratedCapacityP"""))
    val AirCompressor = parse_attribute (attribute ("""CAESPlant.AirCompressor"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""CAESPlant.ThermalGeneratingUnit"""))
    def parse (context: Context): CAESPlant =
    {
        CAESPlant(
            sup (context),
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
    override val sup: Element,
    val multiplier: String,
    val unit: String,
    val value: Int
)
extends
    Element
{
    def this () = { this (null, null, null, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[Classification]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Classification
extends
    Parseable[Classification]
{
    val sup = BasicElement.parse _
    val multiplier = parse_attribute (attribute ("""Classification.multiplier"""))
    val unit = parse_attribute (attribute ("""Classification.unit"""))
    val value = parse_element (element ("""Classification.value"""))
    def parse (context: Context): Classification =
    {
        Classification(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[CogenerationPlant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CogenerationPlant
extends
    Parseable[CogenerationPlant]
{
    val sup = PowerSystemResource.parse _
    val cogenHPSendoutRating = parse_element (element ("""CogenerationPlant.cogenHPSendoutRating"""))
    val cogenHPSteamRating = parse_element (element ("""CogenerationPlant.cogenHPSteamRating"""))
    val cogenLPSendoutRating = parse_element (element ("""CogenerationPlant.cogenLPSendoutRating"""))
    val cogenLPSteamRating = parse_element (element ("""CogenerationPlant.cogenLPSteamRating"""))
    val ratedP = parse_element (element ("""CogenerationPlant.ratedP"""))
    val SteamSendoutSchedule = parse_attribute (attribute ("""CogenerationPlant.SteamSendoutSchedule"""))
    def parse (context: Context): CogenerationPlant =
    {
        CogenerationPlant(
            sup (context),
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
    override val sup: Element,
    val combCyclePlantRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[CombinedCyclePlant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombinedCyclePlant
extends
    Parseable[CombinedCyclePlant]
{
    val sup = PowerSystemResource.parse _
    val combCyclePlantRating = parse_element (element ("""CombinedCyclePlant.combCyclePlantRating"""))
    def parse (context: Context): CombinedCyclePlant =
    {
        CombinedCyclePlant(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[CostPerHeatUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CostPerHeatUnit
extends
    Parseable[CostPerHeatUnit]
{
    val sup = BasicElement.parse _
    val denominatorMultiplier = parse_attribute (attribute ("""CostPerHeatUnit.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""CostPerHeatUnit.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""CostPerHeatUnit.multiplier"""))
    val unit = parse_attribute (attribute ("""CostPerHeatUnit.unit"""))
    val value = parse_element (element ("""CostPerHeatUnit.value"""))
    def parse (context: Context): CostPerHeatUnit =
    {
        CostPerHeatUnit(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Emission]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Emission
extends
    Parseable[Emission]
{
    val sup = BasicElement.parse _
    val denominatorMultiplier = parse_attribute (attribute ("""Emission.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""Emission.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""Emission.multiplier"""))
    val unit = parse_attribute (attribute ("""Emission.unit"""))
    val value = parse_element (element ("""Emission.value"""))
    def parse (context: Context): Emission =
    {
        Emission(
            sup (context),
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
    override val sup: Element,
    val emissionType: String,
    val emissionValueSource: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[EmissionAccount]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EmissionAccount
extends
    Parseable[EmissionAccount]
{
    val sup = Curve.parse _
    val emissionType = parse_attribute (attribute ("""EmissionAccount.emissionType"""))
    val emissionValueSource = parse_attribute (attribute ("""EmissionAccount.emissionValueSource"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionAccount.ThermalGeneratingUnit"""))
    def parse (context: Context): EmissionAccount =
    {
        EmissionAccount(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[EmissionCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EmissionCurve
extends
    Parseable[EmissionCurve]
{
    val sup = Curve.parse _
    val emissionContent = parse_attribute (attribute ("""EmissionCurve.emissionContent"""))
    val emissionType = parse_attribute (attribute ("""EmissionCurve.emissionType"""))
    val isNetGrossP = parse_element (element ("""EmissionCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): EmissionCurve =
    {
        EmissionCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[EmissionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EmissionType
extends
    Parseable[EmissionType]
{
    val sup = BasicElement.parse _
    val carbonDioxide = parse_attribute (attribute ("""EmissionType.carbonDioxide"""))
    val carbonDisulfide = parse_attribute (attribute ("""EmissionType.carbonDisulfide"""))
    val chlorine = parse_attribute (attribute ("""EmissionType.chlorine"""))
    val hydrogenSulfide = parse_attribute (attribute ("""EmissionType.hydrogenSulfide"""))
    val nitrogenOxide = parse_attribute (attribute ("""EmissionType.nitrogenOxide"""))
    val sulfurDioxide = parse_attribute (attribute ("""EmissionType.sulfurDioxide"""))
    def parse (context: Context): EmissionType =
    {
        EmissionType(
            sup (context),
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
    override val sup: Element,
    val calculated: String,
    val measured: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EmissionValueSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EmissionValueSource
extends
    Parseable[EmissionValueSource]
{
    val sup = BasicElement.parse _
    val calculated = parse_attribute (attribute ("""EmissionValueSource.calculated"""))
    val measured = parse_attribute (attribute ("""EmissionValueSource.measured"""))
    def parse (context: Context): EmissionValueSource =
    {
        EmissionValueSource(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[FossilFuel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FossilFuel
extends
    Parseable[FossilFuel]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[FuelAllocationSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FuelAllocationSchedule
extends
    Parseable[FuelAllocationSchedule]
{
    val sup = Curve.parse _
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
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[FuelType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FuelType
extends
    Parseable[FuelType]
{
    val sup = BasicElement.parse _
    val coal = parse_attribute (attribute ("""FuelType.coal"""))
    val gas = parse_attribute (attribute ("""FuelType.gas"""))
    val hardCoal = parse_attribute (attribute ("""FuelType.hardCoal"""))
    val lignite = parse_attribute (attribute ("""FuelType.lignite"""))
    val oil = parse_attribute (attribute ("""FuelType.oil"""))
    val oilShale = parse_attribute (attribute ("""FuelType.oilShale"""))
    def parse (context: Context): FuelType =
    {
        FuelType(
            sup (context),
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
    override val sup: Element,
    val isNetGrossP: Boolean,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[GenUnitOpCostCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenUnitOpCostCurve
extends
    Parseable[GenUnitOpCostCurve]
{
    val sup = Curve.parse _
    val isNetGrossP = parse_element (element ("""GenUnitOpCostCurve.isNetGrossP"""))
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpCostCurve.GeneratingUnit"""))
    def parse (context: Context): GenUnitOpCostCurve =
    {
        GenUnitOpCostCurve(
            sup (context),
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
    override val sup: Element,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[GenUnitOpSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenUnitOpSchedule
extends
    Parseable[GenUnitOpSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpSchedule.GeneratingUnit"""))
    def parse (context: Context): GenUnitOpSchedule =
    {
        GenUnitOpSchedule(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnit
extends
    Parseable[GeneratingUnit]
{
    val sup = Equipment.parse _
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
            sup (context),
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
    override val sup: Element,
    val pulse: String,
    val setpoint: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratorControlMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratorControlMode
extends
    Parseable[GeneratorControlMode]
{
    val sup = BasicElement.parse _
    val pulse = parse_attribute (attribute ("""GeneratorControlMode.pulse"""))
    val setpoint = parse_attribute (attribute ("""GeneratorControlMode.setpoint"""))
    def parse (context: Context): GeneratorControlMode =
    {
        GeneratorControlMode(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[GeneratorControlSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratorControlSource
extends
    Parseable[GeneratorControlSource]
{
    val sup = BasicElement.parse _
    val offAGC = parse_attribute (attribute ("""GeneratorControlSource.offAGC"""))
    val onAGC = parse_attribute (attribute ("""GeneratorControlSource.onAGC"""))
    val plantControl = parse_attribute (attribute ("""GeneratorControlSource.plantControl"""))
    val unavailable = parse_attribute (attribute ("""GeneratorControlSource.unavailable"""))
    def parse (context: Context): GeneratorControlSource =
    {
        GeneratorControlSource(
            sup (context),
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
    override val sup: Element,
    val GeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[GrossToNetActivePowerCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GrossToNetActivePowerCurve
extends
    Parseable[GrossToNetActivePowerCurve]
{
    val sup = Curve.parse _
    val GeneratingUnit = parse_attribute (attribute ("""GrossToNetActivePowerCurve.GeneratingUnit"""))
    def parse (context: Context): GrossToNetActivePowerCurve =
    {
        GrossToNetActivePowerCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[HeatInputCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HeatInputCurve
extends
    Parseable[HeatInputCurve]
{
    val sup = Curve.parse _
    val auxPowerMult = parse_element (element ("""HeatInputCurve.auxPowerMult"""))
    val auxPowerOffset = parse_element (element ("""HeatInputCurve.auxPowerOffset"""))
    val heatInputEff = parse_element (element ("""HeatInputCurve.heatInputEff"""))
    val heatInputOffset = parse_attribute (attribute ("""HeatInputCurve.heatInputOffset"""))
    val isNetGrossP = parse_element (element ("""HeatInputCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatInputCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): HeatInputCurve =
    {
        HeatInputCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[HeatRate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HeatRate
extends
    Parseable[HeatRate]
{
    val sup = BasicElement.parse _
    val denominatorMultiplier = parse_attribute (attribute ("""HeatRate.denominatorMultiplier"""))
    val denominatorUnit = parse_attribute (attribute ("""HeatRate.denominatorUnit"""))
    val multiplier = parse_attribute (attribute ("""HeatRate.multiplier"""))
    val unit = parse_attribute (attribute ("""HeatRate.unit"""))
    val value = parse_element (element ("""HeatRate.value"""))
    def parse (context: Context): HeatRate =
    {
        HeatRate(
            sup (context),
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
    override val sup: Element,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[HeatRateCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HeatRateCurve
extends
    Parseable[HeatRateCurve]
{
    val sup = Curve.parse _
    val isNetGrossP = parse_element (element ("""HeatRateCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatRateCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): HeatRateCurve =
    {
        HeatRateCurve(
            sup (context),
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
    override val sup: Element,
    val generator: String,
    val pumpAndGenerator: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[HydroEnergyConversionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroEnergyConversionKind
extends
    Parseable[HydroEnergyConversionKind]
{
    val sup = BasicElement.parse _
    val generator = parse_attribute (attribute ("""HydroEnergyConversionKind.generator"""))
    val pumpAndGenerator = parse_attribute (attribute ("""HydroEnergyConversionKind.pumpAndGenerator"""))
    def parse (context: Context): HydroEnergyConversionKind =
    {
        HydroEnergyConversionKind(
            sup (context),
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
    override val sup: Element,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[HydroGeneratingEfficiencyCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroGeneratingEfficiencyCurve
extends
    Parseable[HydroGeneratingEfficiencyCurve]
{
    val sup = Curve.parse _
    val HydroGeneratingUnit = parse_attribute (attribute ("""HydroGeneratingEfficiencyCurve.HydroGeneratingUnit"""))
    def parse (context: Context): HydroGeneratingEfficiencyCurve =
    {
        HydroGeneratingEfficiencyCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[HydroGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroGeneratingUnit
extends
    Parseable[HydroGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
    val energyConversionCapability = parse_attribute (attribute ("""HydroGeneratingUnit.energyConversionCapability"""))
    val hydroUnitWaterCost = parse_element (element ("""HydroGeneratingUnit.hydroUnitWaterCost"""))
    val HydroPowerPlant = parse_attribute (attribute ("""HydroGeneratingUnit.HydroPowerPlant"""))
    val PenstockLossCurve = parse_attribute (attribute ("""HydroGeneratingUnit.PenstockLossCurve"""))
    def parse (context: Context): HydroGeneratingUnit =
    {
        HydroGeneratingUnit(
            sup (context),
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
    override val sup: Element,
    val pumpedStorage: String,
    val runOfRiver: String,
    val storage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[HydroPlantStorageKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroPlantStorageKind
extends
    Parseable[HydroPlantStorageKind]
{
    val sup = BasicElement.parse _
    val pumpedStorage = parse_attribute (attribute ("""HydroPlantStorageKind.pumpedStorage"""))
    val runOfRiver = parse_attribute (attribute ("""HydroPlantStorageKind.runOfRiver"""))
    val storage = parse_attribute (attribute ("""HydroPlantStorageKind.storage"""))
    def parse (context: Context): HydroPlantStorageKind =
    {
        HydroPlantStorageKind(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[HydroPowerPlant]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroPowerPlant
extends
    Parseable[HydroPowerPlant]
{
    val sup = PowerSystemResource.parse _
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
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[HydroPump]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroPump
extends
    Parseable[HydroPump]
{
    val sup = Equipment.parse _
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
            sup (context),
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
    override val sup: Element,
    val HydroPump: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[HydroPumpOpSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroPumpOpSchedule
extends
    Parseable[HydroPumpOpSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val HydroPump = parse_attribute (attribute ("""HydroPumpOpSchedule.HydroPump"""))
    def parse (context: Context): HydroPumpOpSchedule =
    {
        HydroPumpOpSchedule(
            sup (context),
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
    override val sup: Element,
    val isNetGrossP: Boolean,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[IncrementalHeatRateCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IncrementalHeatRateCurve
extends
    Parseable[IncrementalHeatRateCurve]
{
    val sup = Curve.parse _
    val isNetGrossP = parse_element (element ("""IncrementalHeatRateCurve.isNetGrossP"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""IncrementalHeatRateCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): IncrementalHeatRateCurve =
    {
        IncrementalHeatRateCurve(
            sup (context),
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
    override val sup: Element,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[InflowForecast]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InflowForecast
extends
    Parseable[InflowForecast]
{
    val sup = RegularIntervalSchedule.parse _
    val Reservoir = parse_attribute (attribute ("""InflowForecast.Reservoir"""))
    def parse (context: Context): InflowForecast =
    {
        InflowForecast(
            sup (context),
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
    override val sup: Element,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[LevelVsVolumeCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LevelVsVolumeCurve
extends
    Parseable[LevelVsVolumeCurve]
{
    val sup = Curve.parse _
    val Reservoir = parse_attribute (attribute ("""LevelVsVolumeCurve.Reservoir"""))
    def parse (context: Context): LevelVsVolumeCurve =
    {
        LevelVsVolumeCurve(
            sup (context),
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
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[NuclearGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NuclearGeneratingUnit
extends
    Parseable[NuclearGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
    def parse (context: Context): NuclearGeneratingUnit =
    {
        NuclearGeneratingUnit(
            sup (context)
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
    override val sup: Element,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[PenstockLossCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PenstockLossCurve
extends
    Parseable[PenstockLossCurve]
{
    val sup = Curve.parse _
    val HydroGeneratingUnit = parse_attribute (attribute ("""PenstockLossCurve.HydroGeneratingUnit"""))
    def parse (context: Context): PenstockLossCurve =
    {
        PenstockLossCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Reservoir]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Reservoir
extends
    Parseable[Reservoir]
{
    val sup = PowerSystemResource.parse _
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
            sup (context),
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
    override val sup: Element,
    val shutdownCost: Double,
    val shutdownDate: String,
    val ThermalGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ShutdownCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ShutdownCurve
extends
    Parseable[ShutdownCurve]
{
    val sup = Curve.parse _
    val shutdownCost = parse_element (element ("""ShutdownCurve.shutdownCost"""))
    val shutdownDate = parse_element (element ("""ShutdownCurve.shutdownDate"""))
    val ThermalGeneratingUnit = parse_attribute (attribute ("""ShutdownCurve.ThermalGeneratingUnit"""))
    def parse (context: Context): ShutdownCurve =
    {
        ShutdownCurve(
            sup (context),
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
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[SolarGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SolarGeneratingUnit
extends
    Parseable[SolarGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
    def parse (context: Context): SolarGeneratingUnit =
    {
        SolarGeneratingUnit(
            sup (context)
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
    override val sup: Element,
    val ignitionFuelType: String,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartIgnFuelCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartIgnFuelCurve
extends
    Parseable[StartIgnFuelCurve]
{
    val sup = Curve.parse _
    val ignitionFuelType = parse_attribute (attribute ("""StartIgnFuelCurve.ignitionFuelType"""))
    val StartupModel = parse_attribute (attribute ("""StartIgnFuelCurve.StartupModel"""))
    def parse (context: Context): StartIgnFuelCurve =
    {
        StartIgnFuelCurve(
            sup (context),
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
    override val sup: Element,
    val mainFuelType: String,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartMainFuelCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartMainFuelCurve
extends
    Parseable[StartMainFuelCurve]
{
    val sup = Curve.parse _
    val mainFuelType = parse_attribute (attribute ("""StartMainFuelCurve.mainFuelType"""))
    val StartupModel = parse_attribute (attribute ("""StartMainFuelCurve.StartupModel"""))
    def parse (context: Context): StartMainFuelCurve =
    {
        StartMainFuelCurve(
            sup (context),
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
    override val sup: Element,
    val hotStandbyRamp: Double,
    val StartupModel: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[StartRampCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartRampCurve
extends
    Parseable[StartRampCurve]
{
    val sup = Curve.parse _
    val hotStandbyRamp = parse_element (element ("""StartRampCurve.hotStandbyRamp"""))
    val StartupModel = parse_attribute (attribute ("""StartRampCurve.StartupModel"""))
    def parse (context: Context): StartRampCurve =
    {
        StartRampCurve(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[StartupModel]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StartupModel
extends
    Parseable[StartupModel]
{
    val sup = IdentifiedObject.parse _
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
            sup (context),
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
    override val sup: Element,
    val CogenerationPlant: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { return (clone ().asInstanceOf[SteamSendoutSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SteamSendoutSchedule
extends
    Parseable[SteamSendoutSchedule]
{
    val sup = RegularIntervalSchedule.parse _
    val CogenerationPlant = parse_attribute (attribute ("""SteamSendoutSchedule.CogenerationPlant"""))
    def parse (context: Context): SteamSendoutSchedule =
    {
        SteamSendoutSchedule(
            sup (context),
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
    override val sup: Element,
    val HydroGeneratingUnit: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[TailbayLossCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TailbayLossCurve
extends
    Parseable[TailbayLossCurve]
{
    val sup = Curve.parse _
    val HydroGeneratingUnit = parse_attribute (attribute ("""TailbayLossCurve.HydroGeneratingUnit"""))
    def parse (context: Context): TailbayLossCurve =
    {
        TailbayLossCurve(
            sup (context),
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
    override val sup: Element,
    val highLevelLimit: Double,
    val lowLevelLimit: Double,
    val Reservoir: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[TargetLevelSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TargetLevelSchedule
extends
    Parseable[TargetLevelSchedule]
{
    val sup = Curve.parse _
    val highLevelLimit = parse_element (element ("""TargetLevelSchedule.highLevelLimit"""))
    val lowLevelLimit = parse_element (element ("""TargetLevelSchedule.lowLevelLimit"""))
    val Reservoir = parse_attribute (attribute ("""TargetLevelSchedule.Reservoir"""))
    def parse (context: Context): TargetLevelSchedule =
    {
        TargetLevelSchedule(
            sup (context),
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
    override val sup: Element,
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
    override def copy (): Row = { return (clone ().asInstanceOf[ThermalGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ThermalGeneratingUnit
extends
    Parseable[ThermalGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
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
            sup (context),
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
    override val sup: Element,
    val offshore: String,
    val onshore: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenUnitKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenUnitKind
extends
    Parseable[WindGenUnitKind]
{
    val sup = BasicElement.parse _
    val offshore = parse_attribute (attribute ("""WindGenUnitKind.offshore"""))
    val onshore = parse_attribute (attribute ("""WindGenUnitKind.onshore"""))
    def parse (context: Context): WindGenUnitKind =
    {
        WindGenUnitKind(
            sup (context),
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
    override val sup: Element,
    val windGenUnitType: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def GeneratingUnit: GeneratingUnit = sup.asInstanceOf[GeneratingUnit]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGeneratingUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGeneratingUnit
extends
    Parseable[WindGeneratingUnit]
{
    val sup = GeneratingUnit.parse _
    val windGenUnitType = parse_attribute (attribute ("""WindGeneratingUnit.windGenUnitType"""))
    def parse (context: Context): WindGeneratingUnit =
    {
        WindGeneratingUnit(
            sup (context),
            windGenUnitType (context)
        )
    }
}

object _Production
{
    def register: Unit =
    {
        AirCompressor.register
        CAESPlant.register
        Classification.register
        CogenerationPlant.register
        CombinedCyclePlant.register
        CostPerHeatUnit.register
        Emission.register
        EmissionAccount.register
        EmissionCurve.register
        EmissionType.register
        EmissionValueSource.register
        FossilFuel.register
        FuelAllocationSchedule.register
        FuelType.register
        GenUnitOpCostCurve.register
        GenUnitOpSchedule.register
        GeneratingUnit.register
        GeneratorControlMode.register
        GeneratorControlSource.register
        GrossToNetActivePowerCurve.register
        HeatInputCurve.register
        HeatRate.register
        HeatRateCurve.register
        HydroEnergyConversionKind.register
        HydroGeneratingEfficiencyCurve.register
        HydroGeneratingUnit.register
        HydroPlantStorageKind.register
        HydroPowerPlant.register
        HydroPump.register
        HydroPumpOpSchedule.register
        IncrementalHeatRateCurve.register
        InflowForecast.register
        LevelVsVolumeCurve.register
        NuclearGeneratingUnit.register
        PenstockLossCurve.register
        Reservoir.register
        ShutdownCurve.register
        SolarGeneratingUnit.register
        StartIgnFuelCurve.register
        StartMainFuelCurve.register
        StartRampCurve.register
        StartupModel.register
        SteamSendoutSchedule.register
        TailbayLossCurve.register
        TargetLevelSchedule.register
        ThermalGeneratingUnit.register
        WindGenUnitKind.register
        WindGeneratingUnit.register
    }
}