package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The production package is responsible for classes which describe various kinds of generators.
 * These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 */

/**
 * Combustion turbine air compressor which is an integral part of a compressed air energy storage (CAES) plant.
 */
case class AirCompressor
(

    override val sup: PowerSystemResource,

    /**
     * Rating of the CAES air compressor.
     */
    val airCompressorRating: Double,

    /**
     * An air compressor may be a member of a compressed air energy storage plant.
     */
    val CAESPlant: String,

    /**
     * A CAES air compressor is driven by combustion turbine.
     */
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
    val airCompressorRating = parse_element (element ("""AirCompressor.airCompressorRating"""))_
    val CAESPlant = parse_attribute (attribute ("""AirCompressor.CAESPlant"""))_
    val CombustionTurbine = parse_attribute (attribute ("""AirCompressor.CombustionTurbine"""))_
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
 */
case class CAESPlant
(

    override val sup: PowerSystemResource,

    /**
     * The rated energy storage capacity.
     */
    val energyStorageCapacity: Double,

    /**
     * The CAES plant's gross rated generating capacity.
     */
    val ratedCapacityP: Double,

    /**
     * An air compressor may be a member of a compressed air energy storage plant.
     */
    val AirCompressor: String,

    /**
     * A thermal generating unit may be a member of a compressed air energy storage plant.
     */
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
    val energyStorageCapacity = parse_element (element ("""CAESPlant.energyStorageCapacity"""))_
    val ratedCapacityP = parse_element (element ("""CAESPlant.ratedCapacityP"""))_
    val AirCompressor = parse_attribute (attribute ("""CAESPlant.AirCompressor"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""CAESPlant.ThermalGeneratingUnit"""))_
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
    val multiplier = parse_attribute (attribute ("""Classification.multiplier"""))_
    val unit = parse_attribute (attribute ("""Classification.unit"""))_
    val value = parse_element (element ("""Classification.value"""))_
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
 */
case class CogenerationPlant
(

    override val sup: PowerSystemResource,

    /**
     * The high pressure steam sendout.
     */
    val cogenHPSendoutRating: Double,

    /**
     * The high pressure steam rating.
     */
    val cogenHPSteamRating: Double,

    /**
     * The low pressure steam sendout.
     */
    val cogenLPSendoutRating: Double,

    /**
     * The low pressure steam rating.
     */
    val cogenLPSteamRating: Double,

    /**
     * The rated output active power of the cogeneration plant.
     */
    val ratedP: Double,

    /**
     * A cogeneration plant has a steam sendout schedule.
     */
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
    val cogenHPSendoutRating = parse_element (element ("""CogenerationPlant.cogenHPSendoutRating"""))_
    val cogenHPSteamRating = parse_element (element ("""CogenerationPlant.cogenHPSteamRating"""))_
    val cogenLPSendoutRating = parse_element (element ("""CogenerationPlant.cogenLPSendoutRating"""))_
    val cogenLPSteamRating = parse_element (element ("""CogenerationPlant.cogenLPSteamRating"""))_
    val ratedP = parse_element (element ("""CogenerationPlant.ratedP"""))_
    val SteamSendoutSchedule = parse_attribute (attribute ("""CogenerationPlant.SteamSendoutSchedule"""))_
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
 */
case class CombinedCyclePlant
(

    override val sup: PowerSystemResource,

    /**
     * The combined cycle plant's active power output rating.
     */
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
    val combCyclePlantRating = parse_element (element ("""CombinedCyclePlant.combCyclePlantRating"""))_
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
    val denominatorMultiplier = parse_attribute (attribute ("""CostPerHeatUnit.denominatorMultiplier"""))_
    val denominatorUnit = parse_attribute (attribute ("""CostPerHeatUnit.denominatorUnit"""))_
    val multiplier = parse_attribute (attribute ("""CostPerHeatUnit.multiplier"""))_
    val unit = parse_attribute (attribute ("""CostPerHeatUnit.unit"""))_
    val value = parse_element (element ("""CostPerHeatUnit.value"""))_
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
    val denominatorMultiplier = parse_attribute (attribute ("""Emission.denominatorMultiplier"""))_
    val denominatorUnit = parse_attribute (attribute ("""Emission.denominatorUnit"""))_
    val multiplier = parse_attribute (attribute ("""Emission.multiplier"""))_
    val unit = parse_attribute (attribute ("""Emission.unit"""))_
    val value = parse_element (element ("""Emission.value"""))_
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
 */
case class EmissionAccount
(

    override val sup: Curve,

    /**
     * The type of emission, for example sulfur dioxide (SO2).
     * The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
     */
    val emissionType: String,

    /**
     * The source of the emission value.
     */
    val emissionValueSource: String,

    /**
     * A thermal generating unit may have one or more emission allowance accounts.
     */
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
    val emissionType = parse_attribute (attribute ("""EmissionAccount.emissionType"""))_
    val emissionValueSource = parse_attribute (attribute ("""EmissionAccount.emissionValueSource"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionAccount.ThermalGeneratingUnit"""))_
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
 */
case class EmissionCurve
(

    override val sup: Curve,

    /**
     * The emission content per quantity of fuel burned.
     */
    val emissionContent: String,

    /**
     * The type of emission, which also gives the production rate measurement unit.
     * The y1AxisUnits of the curve contains the unit of measure (e.g. kg) and the emissionType is the type of emission (e.g. sulfer dioxide).
     */
    val emissionType: String,

    /**
     * Flag is set to true when output is expressed in net active power.
     */
    val isNetGrossP: Boolean,

    /**
     * A thermal generating unit may have  one or more emission curves.
     */
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
    val emissionContent = parse_attribute (attribute ("""EmissionCurve.emissionContent"""))_
    val emissionType = parse_attribute (attribute ("""EmissionCurve.emissionType"""))_
    val isNetGrossP = parse_element (element ("""EmissionCurve.isNetGrossP"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""EmissionCurve.ThermalGeneratingUnit"""))_
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
 */
case class EmissionType
(

    override val sup: BasicElement,

    /**
     * Carbon diaoxide.
     */
    val carbonDioxide: String,

    /**
     * Carbon disulfide.
     */
    val carbonDisulfide: String,

    /**
     * Clorine.
     */
    val chlorine: String,

    /**
     * Hydrogen sulfide.
     */
    val hydrogenSulfide: String,

    /**
     * Nitrogen oxide.
     */
    val nitrogenOxide: String,

    /**
     * Sulfer dioxide.
     */
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
    val carbonDioxide = parse_attribute (attribute ("""EmissionType.carbonDioxide"""))_
    val carbonDisulfide = parse_attribute (attribute ("""EmissionType.carbonDisulfide"""))_
    val chlorine = parse_attribute (attribute ("""EmissionType.chlorine"""))_
    val hydrogenSulfide = parse_attribute (attribute ("""EmissionType.hydrogenSulfide"""))_
    val nitrogenOxide = parse_attribute (attribute ("""EmissionType.nitrogenOxide"""))_
    val sulfurDioxide = parse_attribute (attribute ("""EmissionType.sulfurDioxide"""))_
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
 */
case class EmissionValueSource
(

    override val sup: BasicElement,

    /**
     * Calculated.
     */
    val calculated: String,

    /**
     * Measured.
     */
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
    val calculated = parse_attribute (attribute ("""EmissionValueSource.calculated"""))_
    val measured = parse_attribute (attribute ("""EmissionValueSource.measured"""))_
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
 */
case class FossilFuel
(

    override val sup: IdentifiedObject,

    /**
     * The type of fossil fuel, such as coal, oil, or gas.
     */
    val fossilFuelType: String,

    /**
     * The cost in terms of heat value for the given type of fuel.
     */
    val fuelCost: String,

    /**
     * The cost of fuel used for economic dispatching which includes: fuel cost, transportation cost,  and incremental maintenance cost.
     */
    val fuelDispatchCost: String,

    /**
     * The efficiency factor for the fuel (per unit) in terms of the effective energy absorbed.
     */
    val fuelEffFactor: Double,

    /**
     * Handling and processing cost associated with this fuel.
     */
    val fuelHandlingCost: String,

    /**
     * The amount of heat per weight (or volume) of the given type of fuel.
     */
    val fuelHeatContent: Double,

    /**
     * Relative amount of the given type of fuel, when multiple fuels are being consumed.
     */
    val fuelMixture: Double,

    /**
     * The fuel's fraction of pollution credit per unit of heat content.
     */
    val fuelSulfur: Double,

    /**
     * The active power output level of the unit at which the given type of fuel is switched on.
     * This fuel (e.g., oil) is sometimes used to supplement the base fuel (e.g., coal) at high active power output levels.
     */
    val highBreakpointP: Double,

    /**
     * The active power output level of the unit at which the given type of fuel is switched off.
     * This fuel (e.g., oil) is sometimes used to stabilize the base fuel (e.g., coal) at low active power output levels.
     */
    val lowBreakpointP: Double,

    /**
     * A thermal generating unit may have one or more fossil fuels.
     */
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
    val fossilFuelType = parse_attribute (attribute ("""FossilFuel.fossilFuelType"""))_
    val fuelCost = parse_attribute (attribute ("""FossilFuel.fuelCost"""))_
    val fuelDispatchCost = parse_attribute (attribute ("""FossilFuel.fuelDispatchCost"""))_
    val fuelEffFactor = parse_element (element ("""FossilFuel.fuelEffFactor"""))_
    val fuelHandlingCost = parse_attribute (attribute ("""FossilFuel.fuelHandlingCost"""))_
    val fuelHeatContent = parse_element (element ("""FossilFuel.fuelHeatContent"""))_
    val fuelMixture = parse_element (element ("""FossilFuel.fuelMixture"""))_
    val fuelSulfur = parse_element (element ("""FossilFuel.fuelSulfur"""))_
    val highBreakpointP = parse_element (element ("""FossilFuel.highBreakpointP"""))_
    val lowBreakpointP = parse_element (element ("""FossilFuel.lowBreakpointP"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""FossilFuel.ThermalGeneratingUnit"""))_
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
 */
case class FuelAllocationSchedule
(

    override val sup: Curve,

    /**
     * The end time and date of the fuel allocation schedule.
     */
    val fuelAllocationEndDate: String,

    /**
     * The start time and date of the fuel allocation schedule.
     */
    val fuelAllocationStartDate: String,

    /**
     * The type of fuel, which also indicates the corresponding measurement unit.
     */
    val fuelType: String,

    /**
     * The maximum amount fuel that is allocated for consumption for the scheduled time period.
     */
    val maxFuelAllocation: Double,

    /**
     * The minimum amount fuel that is allocated for consumption for the scheduled time period, e.g., based on a "take-or-pay" contract.
     */
    val minFuelAllocation: Double,

    /**
     * A fuel allocation schedule must have a fossil fuel.
     */
    val FossilFuel: String,

    /**
     * A thermal generating unit may have one or more fuel allocation schedules.
     */
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
    val fuelAllocationEndDate = parse_element (element ("""FuelAllocationSchedule.fuelAllocationEndDate"""))_
    val fuelAllocationStartDate = parse_element (element ("""FuelAllocationSchedule.fuelAllocationStartDate"""))_
    val fuelType = parse_attribute (attribute ("""FuelAllocationSchedule.fuelType"""))_
    val maxFuelAllocation = parse_element (element ("""FuelAllocationSchedule.maxFuelAllocation"""))_
    val minFuelAllocation = parse_element (element ("""FuelAllocationSchedule.minFuelAllocation"""))_
    val FossilFuel = parse_attribute (attribute ("""FuelAllocationSchedule.FossilFuel"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""FuelAllocationSchedule.ThermalGeneratingUnit"""))_
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
 */
case class FuelType
(

    override val sup: BasicElement,

    /**
     * Generic coal, not including lignite type.
     */
    val coal: String,

    /**
     * Natural gas.
     */
    val gas: String,

    /**
     * Hard coal
     */
    val hardCoal: String,

    /**
     * The fuel is lignite coal.
     * Note that this is a special type of coal, so the other enum of coal is reserved for hard coal types or if the exact type of coal is not known.
     */
    val lignite: String,

    /**
     * Oil.
     */
    val oil: String,

    /**
     * Oil Shale
     */
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
    val coal = parse_attribute (attribute ("""FuelType.coal"""))_
    val gas = parse_attribute (attribute ("""FuelType.gas"""))_
    val hardCoal = parse_attribute (attribute ("""FuelType.hardCoal"""))_
    val lignite = parse_attribute (attribute ("""FuelType.lignite"""))_
    val oil = parse_attribute (attribute ("""FuelType.oil"""))_
    val oilShale = parse_attribute (attribute ("""FuelType.oilShale"""))_
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
 */
case class GenUnitOpCostCurve
(

    override val sup: Curve,

    /**
     * Flag is set to true when output is expressed in net active power.
     */
    val isNetGrossP: Boolean,

    /**
     * A generating unit may have one or more cost curves, depending upon fuel mixture and fuel cost.
     */
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
    val isNetGrossP = parse_element (element ("""GenUnitOpCostCurve.isNetGrossP"""))_
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpCostCurve.GeneratingUnit"""))_
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
 */
case class GenUnitOpSchedule
(

    override val sup: RegularIntervalSchedule,

    /**
     * A generating unit may have an operating schedule, indicating the planned operation of the unit.
     */
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
    val GeneratingUnit = parse_attribute (attribute ("""GenUnitOpSchedule.GeneratingUnit"""))_
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
 */
case class GeneratingUnit
(

    override val sup: Equipment,

    /**
     * The planned unused capacity (spinning reserve) which can be used to support emergency load.
     */
    val allocSpinResP: Double,

    /**
     * The planned unused capacity which can be used to support automatic control overruns.
     */
    val autoCntrlMarginP: Double,

    /**
     * For dispatchable units, this value represents the economic active power basepoint, for units that are not dispatchable, this value represents the fixed generation value.
     * The value must be between the operating low and high limits.
     */
    val baseP: Double,

    /**
     * Unit control error deadband.
     * When a unit's desired active power change is less than this deadband, then no control pulses will be sent to the unit.
     */
    val controlDeadband: Double,

    /**
     * Pulse high limit which is the largest control pulse that the unit can respond to.
     */
    val controlPulseHigh: Double,

    /**
     * Pulse low limit which is the smallest control pulse that the unit can respond to.
     */
    val controlPulseLow: Double,

    /**
     * Unit response rate which specifies the active power change for a control pulse of one second in the most responsive loading level of the unit.
     */
    val controlResponseRate: Double,

    /**
     * The efficiency of the unit in converting mechanical energy, from the prime mover, into electrical energy.
     */
    val efficiency: Double,

    /**
     * The unit control mode.
     */
    val genControlMode: String,

    /**
     * The source of controls for a generating unit.
     */
    val genControlSource: String,

    /**
     * Governor motor position limit.
     */
    val governorMPL: Double,

    /**
     * Governor Speed Changer Droop.
     * This is the change in generator power output divided by the change in frequency normalized by the nominal power of the generator and the nominal frequency and expressed in percent and negated. A positive value of speed change droop provides additional generator output upon a drop in frequency.
     */
    val governorSCD: Double,

    /**
     * High limit for secondary (AGC) control.
     */
    val highControlLimit: Double,

    /**
     * Default initial active power  which is used to store a powerflow result for the initial active power for this unit in this network configuration.
     */
    val initialP: Double,

    /**
     * Generating unit long term economic participation factor.
     */
    val longPF: Double,

    /**
     * Low limit for secondary (AGC) control.
     */
    val lowControlLimit: Double,

    /**
     * The normal maximum rate the generating unit active power output can be lowered by control actions.
     */
    val lowerRampRate: Double,

    /**
     * Maximum high economic active power limit, that should not exceed the maximum operating active power limit.
     */
    val maxEconomicP: Double,

    /**
     * This is the maximum operating active power limit the dispatcher can enter for this unit.
     */
    val maxOperatingP: Double,

    /**
     * Maximum allowable spinning reserve.
     * Spinning reserve will never be considered greater than this value regardless of the current operating point.
     */
    val maximumAllowableSpinningReserve: Double,

    /**
     * Low economic active power limit that must be greater than or equal to the minimum operating active power limit.
     */
    val minEconomicP: Double,

    /**
     * This is the minimum operating active power limit the dispatcher can enter for this unit.
     */
    val minOperatingP: Double,

    /**
     * Minimum time interval between unit shutdown and startup.
     */
    val minimumOffTime: Double,

    /**
     * Detail level of the generator model data.
     */
    val modelDetail: String,

    /**
     * The nominal power of the generating unit.
     * Used to give precise meaning to percentage based attributes such as the governor speed change droop (governorSCD attribute).
     */
    val nominalP: Double,

    /**
     * Generating unit economic participation factor.
     */
    val normalPF: Double,

    /**
     * Defined as: 1 / ( 1 - Incremental Transmission Loss); with the Incremental Transmission Loss expressed as a plus or minus value.
     * The typical range of penalty factors is (0.9 to 1.1).
     */
    val penaltyFactor: Double,

    /**
     * The normal maximum rate the generating unit active power output can be raised by control actions.
     */
    val raiseRampRate: Double,

    /**
     * The unit's gross rated maximum capacity (book value).
     */
    val ratedGrossMaxP: Double,

    /**
     * The gross rated minimum generation level which the unit can safely operate at while delivering power to the transmission grid.
     */
    val ratedGrossMinP: Double,

    /**
     * The net rated maximum capacity determined by subtracting the auxiliary power used to operate the internal plant machinery from the rated gross maximum capacity.
     */
    val ratedNetMaxP: Double,

    /**
     * Generating unit short term economic participation factor.
     */
    val shortPF: Double,

    /**
     * The initial startup cost incurred for each start of the GeneratingUnit.
     */
    val startupCost: Double,

    /**
     * Time it takes to get the unit on-line, from the time that the prime mover mechanical power is applied.
     */
    val startupTime: Double,

    /**
     * Generating unit economic participation factor.
     */
    val tieLinePF: Double,

    /**
     * The efficiency of the unit in converting the fuel into electrical energy.
     */
    val totalEfficiency: Double,

    /**
     * The variable cost component of production per unit of ActivePower.
     */
    val variableCost: Double,

    /**
     * A generating unit may have an operating schedule, indicating the planned operation of the unit.
     */
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
    val allocSpinResP = parse_element (element ("""GeneratingUnit.allocSpinResP"""))_
    val autoCntrlMarginP = parse_element (element ("""GeneratingUnit.autoCntrlMarginP"""))_
    val baseP = parse_element (element ("""GeneratingUnit.baseP"""))_
    val controlDeadband = parse_element (element ("""GeneratingUnit.controlDeadband"""))_
    val controlPulseHigh = parse_element (element ("""GeneratingUnit.controlPulseHigh"""))_
    val controlPulseLow = parse_element (element ("""GeneratingUnit.controlPulseLow"""))_
    val controlResponseRate = parse_element (element ("""GeneratingUnit.controlResponseRate"""))_
    val efficiency = parse_element (element ("""GeneratingUnit.efficiency"""))_
    val genControlMode = parse_attribute (attribute ("""GeneratingUnit.genControlMode"""))_
    val genControlSource = parse_attribute (attribute ("""GeneratingUnit.genControlSource"""))_
    val governorMPL = parse_element (element ("""GeneratingUnit.governorMPL"""))_
    val governorSCD = parse_element (element ("""GeneratingUnit.governorSCD"""))_
    val highControlLimit = parse_element (element ("""GeneratingUnit.highControlLimit"""))_
    val initialP = parse_element (element ("""GeneratingUnit.initialP"""))_
    val longPF = parse_element (element ("""GeneratingUnit.longPF"""))_
    val lowControlLimit = parse_element (element ("""GeneratingUnit.lowControlLimit"""))_
    val lowerRampRate = parse_element (element ("""GeneratingUnit.lowerRampRate"""))_
    val maxEconomicP = parse_element (element ("""GeneratingUnit.maxEconomicP"""))_
    val maxOperatingP = parse_element (element ("""GeneratingUnit.maxOperatingP"""))_
    val maximumAllowableSpinningReserve = parse_element (element ("""GeneratingUnit.maximumAllowableSpinningReserve"""))_
    val minEconomicP = parse_element (element ("""GeneratingUnit.minEconomicP"""))_
    val minOperatingP = parse_element (element ("""GeneratingUnit.minOperatingP"""))_
    val minimumOffTime = parse_element (element ("""GeneratingUnit.minimumOffTime"""))_
    val modelDetail = parse_attribute (attribute ("""GeneratingUnit.modelDetail"""))_
    val nominalP = parse_element (element ("""GeneratingUnit.nominalP"""))_
    val normalPF = parse_element (element ("""GeneratingUnit.normalPF"""))_
    val penaltyFactor = parse_element (element ("""GeneratingUnit.penaltyFactor"""))_
    val raiseRampRate = parse_element (element ("""GeneratingUnit.raiseRampRate"""))_
    val ratedGrossMaxP = parse_element (element ("""GeneratingUnit.ratedGrossMaxP"""))_
    val ratedGrossMinP = parse_element (element ("""GeneratingUnit.ratedGrossMinP"""))_
    val ratedNetMaxP = parse_element (element ("""GeneratingUnit.ratedNetMaxP"""))_
    val shortPF = parse_element (element ("""GeneratingUnit.shortPF"""))_
    val startupCost = parse_element (element ("""GeneratingUnit.startupCost"""))_
    val startupTime = parse_element (element ("""GeneratingUnit.startupTime"""))_
    val tieLinePF = parse_element (element ("""GeneratingUnit.tieLinePF"""))_
    val totalEfficiency = parse_element (element ("""GeneratingUnit.totalEfficiency"""))_
    val variableCost = parse_element (element ("""GeneratingUnit.variableCost"""))_
    val GenUnitOpSchedule = parse_attribute (attribute ("""GeneratingUnit.GenUnitOpSchedule"""))_
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
 */
case class GeneratorControlMode
(

    override val sup: BasicElement,

    /**
     * Pulse control mode.
     */
    val pulse: String,

    /**
     * Setpoint control mode.
     */
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
    val pulse = parse_attribute (attribute ("""GeneratorControlMode.pulse"""))_
    val setpoint = parse_attribute (attribute ("""GeneratorControlMode.setpoint"""))_
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
 */
case class GeneratorControlSource
(

    override val sup: BasicElement,

    /**
     * Off of automatic generation control (AGC).
     */
    val offAGC: String,

    /**
     * On automatic generation control (AGC).
     */
    val onAGC: String,

    /**
     * Plant is controlling.
     */
    val plantControl: String,

    /**
     * Not available.
     */
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
    val offAGC = parse_attribute (attribute ("""GeneratorControlSource.offAGC"""))_
    val onAGC = parse_attribute (attribute ("""GeneratorControlSource.onAGC"""))_
    val plantControl = parse_attribute (attribute ("""GeneratorControlSource.plantControl"""))_
    val unavailable = parse_attribute (attribute ("""GeneratorControlSource.unavailable"""))_
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
 */
case class GrossToNetActivePowerCurve
(

    override val sup: Curve,

    /**
     * A generating unit may have a gross active power to net active power curve, describing the losses and auxiliary power requirements of the unit.
     */
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
    val GeneratingUnit = parse_attribute (attribute ("""GrossToNetActivePowerCurve.GeneratingUnit"""))_
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
 */
case class HeatInputCurve
(

    override val sup: Curve,

    /**
     * Power output - auxiliary power multiplier adjustment factor.
     */
    val auxPowerMult: Double,

    /**
     * Power output - auxiliary power offset adjustment factor.
     */
    val auxPowerOffset: Double,

    /**
     * Heat input - efficiency multiplier adjustment factor.
     */
    val heatInputEff: Double,

    /**
     * Heat input - offset adjustment factor.
     */
    val heatInputOffset: String,

    /**
     * Flag is set to true when output is expressed in net active power.
     */
    val isNetGrossP: Boolean,

    /**
     * A thermal generating unit may have a heat input curve.
     */
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
    val auxPowerMult = parse_element (element ("""HeatInputCurve.auxPowerMult"""))_
    val auxPowerOffset = parse_element (element ("""HeatInputCurve.auxPowerOffset"""))_
    val heatInputEff = parse_element (element ("""HeatInputCurve.heatInputEff"""))_
    val heatInputOffset = parse_attribute (attribute ("""HeatInputCurve.heatInputOffset"""))_
    val isNetGrossP = parse_element (element ("""HeatInputCurve.isNetGrossP"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatInputCurve.ThermalGeneratingUnit"""))_
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
    val denominatorMultiplier = parse_attribute (attribute ("""HeatRate.denominatorMultiplier"""))_
    val denominatorUnit = parse_attribute (attribute ("""HeatRate.denominatorUnit"""))_
    val multiplier = parse_attribute (attribute ("""HeatRate.multiplier"""))_
    val unit = parse_attribute (attribute ("""HeatRate.unit"""))_
    val value = parse_element (element ("""HeatRate.value"""))_
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
 */
case class HeatRateCurve
(

    override val sup: Curve,

    /**
     * Flag is set to true when output is expressed in net active power.
     */
    val isNetGrossP: Boolean,

    /**
     * A thermal generating unit may have a heat rate curve.
     */
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
    val isNetGrossP = parse_element (element ("""HeatRateCurve.isNetGrossP"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""HeatRateCurve.ThermalGeneratingUnit"""))_
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
 */
case class HydroEnergyConversionKind
(

    override val sup: BasicElement,

    /**
     * Able to generate power, but not able to pump water for energy storage.
     */
    val generator: String,

    /**
     * Able to both generate power and pump water for energy storage.
     */
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
    val generator = parse_attribute (attribute ("""HydroEnergyConversionKind.generator"""))_
    val pumpAndGenerator = parse_attribute (attribute ("""HydroEnergyConversionKind.pumpAndGenerator"""))_
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
 */
case class HydroGeneratingEfficiencyCurve
(

    override val sup: Curve,

    /**
     * A hydro generating unit has an efficiency curve.
     */
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
    val HydroGeneratingUnit = parse_attribute (attribute ("""HydroGeneratingEfficiencyCurve.HydroGeneratingUnit"""))_
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
 */
case class HydroGeneratingUnit
(

    override val sup: GeneratingUnit,

    /**
     * Energy conversion capability for generating.
     */
    val energyConversionCapability: String,

    /**
     * The equivalent cost of water that drives the hydro turbine.
     */
    val hydroUnitWaterCost: Double,

    /**
     * The hydro generating unit belongs to a hydro power plant.
     */
    val HydroPowerPlant: String,

    /**
     * A hydro generating unit has a penstock loss curve.
     */
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
    val energyConversionCapability = parse_attribute (attribute ("""HydroGeneratingUnit.energyConversionCapability"""))_
    val hydroUnitWaterCost = parse_element (element ("""HydroGeneratingUnit.hydroUnitWaterCost"""))_
    val HydroPowerPlant = parse_attribute (attribute ("""HydroGeneratingUnit.HydroPowerPlant"""))_
    val PenstockLossCurve = parse_attribute (attribute ("""HydroGeneratingUnit.PenstockLossCurve"""))_
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
 */
case class HydroPlantStorageKind
(

    override val sup: BasicElement,

    /**
     * Pumped storage.
     */
    val pumpedStorage: String,

    /**
     * Run of river.
     */
    val runOfRiver: String,

    /**
     * Storage.
     */
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
    val pumpedStorage = parse_attribute (attribute ("""HydroPlantStorageKind.pumpedStorage"""))_
    val runOfRiver = parse_attribute (attribute ("""HydroPlantStorageKind.runOfRiver"""))_
    val storage = parse_attribute (attribute ("""HydroPlantStorageKind.storage"""))_
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
 */
case class HydroPowerPlant
(

    override val sup: PowerSystemResource,

    /**
     * Water travel delay from tailbay to next downstream hydro power station.
     */
    val dischargeTravelDelay: Double,

    /**
     * The hydro plant's generating rating active power for rated head conditions.
     */
    val genRatedP: Double,

    /**
     * The type of hydro power plant water storage.
     */
    val hydroPlantStorageType: String,

    /**
     * Type and configuration of hydro plant penstock(s).
     */
    val penstockType: String,

    /**
     * Total plant discharge capacity.
     */
    val plantDischargeCapacity: Double,

    /**
     * The plant's rated gross head.
     */
    val plantRatedHead: Double,

    /**
     * The hydro plant's pumping rating active power for rated head conditions.
     */
    val pumpRatedP: Double,

    /**
     * A code describing the type (or absence) of surge tank that is associated with the hydro power plant.
     */
    val surgeTankCode: String,

    /**
     * The level at which the surge tank spills.
     */
    val surgeTankCrestLevel: Double,

    /**
     * Generators are supplied water from or pumps discharge water to an upstream reservoir.
     */
    val GenSourcePumpDischargeReservoir: String,

    /**
     * Generators discharge water to or pumps are supplied water from a downstream reservoir.
     */
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
    val dischargeTravelDelay = parse_element (element ("""HydroPowerPlant.dischargeTravelDelay"""))_
    val genRatedP = parse_element (element ("""HydroPowerPlant.genRatedP"""))_
    val hydroPlantStorageType = parse_attribute (attribute ("""HydroPowerPlant.hydroPlantStorageType"""))_
    val penstockType = parse_element (element ("""HydroPowerPlant.penstockType"""))_
    val plantDischargeCapacity = parse_element (element ("""HydroPowerPlant.plantDischargeCapacity"""))_
    val plantRatedHead = parse_element (element ("""HydroPowerPlant.plantRatedHead"""))_
    val pumpRatedP = parse_element (element ("""HydroPowerPlant.pumpRatedP"""))_
    val surgeTankCode = parse_element (element ("""HydroPowerPlant.surgeTankCode"""))_
    val surgeTankCrestLevel = parse_element (element ("""HydroPowerPlant.surgeTankCrestLevel"""))_
    val GenSourcePumpDischargeReservoir = parse_attribute (attribute ("""HydroPowerPlant.GenSourcePumpDischargeReservoir"""))_
    val Reservoir = parse_attribute (attribute ("""HydroPowerPlant.Reservoir"""))_
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
 */
case class HydroPump
(

    override val sup: Equipment,

    /**
     * The pumping discharge under maximum head conditions, usually at full gate.
     */
    val pumpDischAtMaxHead: Double,

    /**
     * The pumping discharge under minimum head conditions, usually at full gate.
     */
    val pumpDischAtMinHead: Double,

    /**
     * The pumping power under maximum head conditions, usually at full gate.
     */
    val pumpPowerAtMaxHead: Double,

    /**
     * The pumping power under minimum head conditions, usually at full gate.
     */
    val pumpPowerAtMinHead: Double,

    /**
     * The hydro pump may be a member of a pumped storage plant or a pump for distributing water.
     */
    val HydroPowerPlant: String,

    /**
     * The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
     */
    val HydroPumpOpSchedule: String,

    /**
     * The synchronous machine drives the turbine which moves the water from a low elevation to a higher elevation.
     * The direction of machine rotation for pumping may or may not be the same as for generating.
     */
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
    val pumpDischAtMaxHead = parse_element (element ("""HydroPump.pumpDischAtMaxHead"""))_
    val pumpDischAtMinHead = parse_element (element ("""HydroPump.pumpDischAtMinHead"""))_
    val pumpPowerAtMaxHead = parse_element (element ("""HydroPump.pumpPowerAtMaxHead"""))_
    val pumpPowerAtMinHead = parse_element (element ("""HydroPump.pumpPowerAtMinHead"""))_
    val HydroPowerPlant = parse_attribute (attribute ("""HydroPump.HydroPowerPlant"""))_
    val HydroPumpOpSchedule = parse_attribute (attribute ("""HydroPump.HydroPumpOpSchedule"""))_
    val RotatingMachine = parse_attribute (attribute ("""HydroPump.RotatingMachine"""))_
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
 */
case class HydroPumpOpSchedule
(

    override val sup: RegularIntervalSchedule,

    /**
     * The hydro pump has a pumping schedule over time, indicating when pumping is to occur.
     */
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
    val HydroPump = parse_attribute (attribute ("""HydroPumpOpSchedule.HydroPump"""))_
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
 */
case class IncrementalHeatRateCurve
(

    override val sup: Curve,

    /**
     * Flag is set to true when output is expressed in net active power.
     */
    val isNetGrossP: Boolean,

    /**
     * A thermal generating unit may have an incremental heat rate curve.
     */
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
    val isNetGrossP = parse_element (element ("""IncrementalHeatRateCurve.isNetGrossP"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""IncrementalHeatRateCurve.ThermalGeneratingUnit"""))_
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
 */
case class InflowForecast
(

    override val sup: RegularIntervalSchedule,

    /**
     * A reservoir may have a "natural" inflow forecast.
     */
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
    val Reservoir = parse_attribute (attribute ("""InflowForecast.Reservoir"""))_
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
 */
case class LevelVsVolumeCurve
(

    override val sup: Curve,

    /**
     * A reservoir may have a level versus volume relationship.
     */
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
    val Reservoir = parse_attribute (attribute ("""LevelVsVolumeCurve.Reservoir"""))_
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
 */
case class PenstockLossCurve
(

    override val sup: Curve,

    /**
     * A hydro generating unit has a penstock loss curve.
     */
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
    val HydroGeneratingUnit = parse_attribute (attribute ("""PenstockLossCurve.HydroGeneratingUnit"""))_
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
 */
case class Reservoir
(

    override val sup: PowerSystemResource,

    /**
     * Storage volume between the full supply level and the normal minimum operating level.
     */
    val activeStorageCapacity: Double,

    /**
     * The reservoir's energy storage rating in energy for given head conditions.
     */
    val energyStorageRating: Double,

    /**
     * Full supply level, above which water will spill.
     * This can be the spillway crest level or the top of closed gates.
     */
    val fullSupplyLevel: Double,

    /**
     * Total capacity of reservoir.
     */
    val grossCapacity: Double,

    /**
     * Normal minimum operating level below which the penstocks will draw air.
     */
    val normalMinOperateLevel: Double,

    /**
     * River outlet works for riparian right releases or other purposes.
     */
    val riverOutletWorks: String,

    /**
     * The spillway water travel delay to the next downstream reservoir.
     */
    val spillTravelDelay: Double,

    /**
     * Type of spillway gate, including parameters.
     */
    val spillWayGateType: String,

    /**
     * The flow capacity of the spillway in cubic meters per second.
     */
    val spillwayCapacity: Double,

    /**
     * The length of the spillway crest.
     */
    val spillwayCrestLength: Double,

    /**
     * Spillway crest level above which water will spill.
     */
    val spillwayCrestLevel: Double,

    /**
     * A reservoir may spill into a downstream reservoir.
     */
    val SpillsFromReservoir: String,

    /**
     * A reservoir may have a water level target schedule.
     */
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
    val activeStorageCapacity = parse_element (element ("""Reservoir.activeStorageCapacity"""))_
    val energyStorageRating = parse_element (element ("""Reservoir.energyStorageRating"""))_
    val fullSupplyLevel = parse_element (element ("""Reservoir.fullSupplyLevel"""))_
    val grossCapacity = parse_element (element ("""Reservoir.grossCapacity"""))_
    val normalMinOperateLevel = parse_element (element ("""Reservoir.normalMinOperateLevel"""))_
    val riverOutletWorks = parse_element (element ("""Reservoir.riverOutletWorks"""))_
    val spillTravelDelay = parse_element (element ("""Reservoir.spillTravelDelay"""))_
    val spillWayGateType = parse_element (element ("""Reservoir.spillWayGateType"""))_
    val spillwayCapacity = parse_element (element ("""Reservoir.spillwayCapacity"""))_
    val spillwayCrestLength = parse_element (element ("""Reservoir.spillwayCrestLength"""))_
    val spillwayCrestLevel = parse_element (element ("""Reservoir.spillwayCrestLevel"""))_
    val SpillsFromReservoir = parse_attribute (attribute ("""Reservoir.SpillsFromReservoir"""))_
    val TargetLevelSchedule = parse_attribute (attribute ("""Reservoir.TargetLevelSchedule"""))_
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
 */
case class ShutdownCurve
(

    override val sup: Curve,

    /**
     * Fixed shutdown cost.
     */
    val shutdownCost: Double,

    /**
     * The date and time of the most recent generating unit shutdown.
     */
    val shutdownDate: String,

    /**
     * A thermal generating unit may have a shutdown curve.
     */
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
    val shutdownCost = parse_element (element ("""ShutdownCurve.shutdownCost"""))_
    val shutdownDate = parse_element (element ("""ShutdownCurve.shutdownDate"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""ShutdownCurve.ThermalGeneratingUnit"""))_
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
 */
case class StartIgnFuelCurve
(

    override val sup: Curve,

    /**
     * Type of ignition fuel.
     */
    val ignitionFuelType: String,

    /**
     * The unit's startup model may have a startup ignition fuel curve.
     */
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
    val ignitionFuelType = parse_attribute (attribute ("""StartIgnFuelCurve.ignitionFuelType"""))_
    val StartupModel = parse_attribute (attribute ("""StartIgnFuelCurve.StartupModel"""))_
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
 */
case class StartMainFuelCurve
(

    override val sup: Curve,

    /**
     * Type of main fuel.
     */
    val mainFuelType: String,

    /**
     * The unit's startup model may have a startup main fuel curve.
     */
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
    val mainFuelType = parse_attribute (attribute ("""StartMainFuelCurve.mainFuelType"""))_
    val StartupModel = parse_attribute (attribute ("""StartMainFuelCurve.StartupModel"""))_
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
 */
case class StartRampCurve
(

    override val sup: Curve,

    /**
     * The startup ramp rate in gross for a unit that is on hot standby.
     */
    val hotStandbyRamp: Double,

    /**
     * The unit's startup model may have a startup ramp curve.
     */
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
    val hotStandbyRamp = parse_element (element ("""StartRampCurve.hotStandbyRamp"""))_
    val StartupModel = parse_attribute (attribute ("""StartRampCurve.StartupModel"""))_
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
 */
case class StartupModel
(

    override val sup: IdentifiedObject,

    /**
     * Fixed maintenance cost.
     */
    val fixedMaintCost: Double,

    /**
     * The amount of heat input per time uint required for hot standby operation.
     */
    val hotStandbyHeat: String,

    /**
     * Incremental maintenance cost.
     */
    val incrementalMaintCost: Double,

    /**
     * The minimum number of hours the unit must be down before restart.
     */
    val minimumDownTime: Double,

    /**
     * The minimum number of hours the unit must be operating before being allowed to shut down.
     */
    val minimumRunTime: Double,

    /**
     * The opportunity cost associated with the return in monetary unit.
     * This represents the restart's "share" of the unit depreciation and risk of an event which would damage the unit.
     */
    val riskFactorCost: Double,

    /**
     * Total miscellaneous start up costs.
     */
    val startupCost: Double,

    /**
     * The date and time of the most recent generating unit startup.
     */
    val startupDate: String,

    /**
     * Startup priority within control area where lower numbers indicate higher priorities.
     * More than one unit in an area may be assigned the same priority.
     */
    val startupPriority: Int,

    /**
     * The unit's auxiliary active power consumption to maintain standby mode.
     */
    val stbyAuxP: Double,

    /**
     * The unit's startup model may have a startup ignition fuel curve.
     */
    val StartIgnFuelCurve: String,

    /**
     * The unit's startup model may have a startup main fuel curve.
     */
    val StartMainFuelCurve: String,

    /**
     * The unit's startup model may have a startup ramp curve.
     */
    val StartRampCurve: String,

    /**
     * A thermal generating unit may have a startup model.
     */
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
    val fixedMaintCost = parse_element (element ("""StartupModel.fixedMaintCost"""))_
    val hotStandbyHeat = parse_attribute (attribute ("""StartupModel.hotStandbyHeat"""))_
    val incrementalMaintCost = parse_element (element ("""StartupModel.incrementalMaintCost"""))_
    val minimumDownTime = parse_element (element ("""StartupModel.minimumDownTime"""))_
    val minimumRunTime = parse_element (element ("""StartupModel.minimumRunTime"""))_
    val riskFactorCost = parse_element (element ("""StartupModel.riskFactorCost"""))_
    val startupCost = parse_element (element ("""StartupModel.startupCost"""))_
    val startupDate = parse_element (element ("""StartupModel.startupDate"""))_
    val startupPriority = parse_element (element ("""StartupModel.startupPriority"""))_
    val stbyAuxP = parse_element (element ("""StartupModel.stbyAuxP"""))_
    val StartIgnFuelCurve = parse_attribute (attribute ("""StartupModel.StartIgnFuelCurve"""))_
    val StartMainFuelCurve = parse_attribute (attribute ("""StartupModel.StartMainFuelCurve"""))_
    val StartRampCurve = parse_attribute (attribute ("""StartupModel.StartRampCurve"""))_
    val ThermalGeneratingUnit = parse_attribute (attribute ("""StartupModel.ThermalGeneratingUnit"""))_
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
 */
case class SteamSendoutSchedule
(

    override val sup: RegularIntervalSchedule,

    /**
     * A cogeneration plant has a steam sendout schedule.
     */
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
    val CogenerationPlant = parse_attribute (attribute ("""SteamSendoutSchedule.CogenerationPlant"""))_
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
 */
case class TailbayLossCurve
(

    override val sup: Curve,

    /**
     * A hydro generating unit has a tailbay loss curve.
     */
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
    val HydroGeneratingUnit = parse_attribute (attribute ("""TailbayLossCurve.HydroGeneratingUnit"""))_
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
 */
case class TargetLevelSchedule
(

    override val sup: Curve,

    /**
     * High target level limit, above which the reservoir operation will be penalized.
     */
    val highLevelLimit: Double,

    /**
     * Low target level limit, below which the reservoir operation will be penalized.
     */
    val lowLevelLimit: Double,

    /**
     * A reservoir may have a water level target schedule.
     */
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
    val highLevelLimit = parse_element (element ("""TargetLevelSchedule.highLevelLimit"""))_
    val lowLevelLimit = parse_element (element ("""TargetLevelSchedule.lowLevelLimit"""))_
    val Reservoir = parse_attribute (attribute ("""TargetLevelSchedule.Reservoir"""))_
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
 */
case class ThermalGeneratingUnit
(

    override val sup: GeneratingUnit,

    /**
     * Operating and maintenance cost for the thermal unit.
     */
    val oMCost: String,

    /**
     * A thermal generating unit may be a member of a compressed air energy storage plant.
     */
    val CAESPlant: String,

    /**
     * A thermal generating unit may be a member of a cogeneration plant.
     */
    val CogenerationPlant: String,

    /**
     * A thermal generating unit may be a member of a combined cycle plant.
     */
    val CombinedCyclePlant: String,

    /**
     * A thermal generating unit may have a heat input curve.
     */
    val HeatInputCurve: String,

    /**
     * A thermal generating unit may have a heat rate curve.
     */
    val HeatRateCurve: String,

    /**
     * A thermal generating unit may have an incremental heat rate curve.
     */
    val IncrementalHeatRateCurve: String,

    /**
     * A thermal generating unit may have a shutdown curve.
     */
    val ShutdownCurve: String,

    /**
     * A thermal generating unit may have a startup model.
     */
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
    val oMCost = parse_attribute (attribute ("""ThermalGeneratingUnit.oMCost"""))_
    val CAESPlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CAESPlant"""))_
    val CogenerationPlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CogenerationPlant"""))_
    val CombinedCyclePlant = parse_attribute (attribute ("""ThermalGeneratingUnit.CombinedCyclePlant"""))_
    val HeatInputCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.HeatInputCurve"""))_
    val HeatRateCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.HeatRateCurve"""))_
    val IncrementalHeatRateCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.IncrementalHeatRateCurve"""))_
    val ShutdownCurve = parse_attribute (attribute ("""ThermalGeneratingUnit.ShutdownCurve"""))_
    val StartupModel = parse_attribute (attribute ("""ThermalGeneratingUnit.StartupModel"""))_
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
 */
case class WindGenUnitKind
(

    override val sup: BasicElement,

    /**
     * The wind generating unit is located offshore.
     */
    val offshore: String,

    /**
     * The wind generating unit is located onshore.
     */
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
    val offshore = parse_attribute (attribute ("""WindGenUnitKind.offshore"""))_
    val onshore = parse_attribute (attribute ("""WindGenUnitKind.onshore"""))_
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
 */
case class WindGeneratingUnit
(

    override val sup: GeneratingUnit,

    /**
     * The kind of wind generating unit
     */
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
    val windGenUnitType = parse_attribute (attribute ("""WindGeneratingUnit.windGenUnitType"""))_
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