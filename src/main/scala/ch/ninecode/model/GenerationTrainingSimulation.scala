package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */

/**
 * Boiling water reactor used as a steam supply to a steam turbine.
 */
case class BWRSteamSupply
(

    override val sup: SteamSupply,

    /**
     * High power limit.
     */
    val highPowerLimit: Double,

    /**
     * In-core thermal time constant.
     */
    val inCoreThermalTC: Double,

    /**
     * Integral gain.
     */
    val integralGain: Double,

    /**
     * Low power limit.
     */
    val lowPowerLimit: Double,

    /**
     * Initial lower limit.
     */
    val lowerLimit: Double,

    /**
     * Pressure limit.
     */
    val pressureLimit: Double,

    /**
     * Pressure setpoint gain adjuster.
     */
    val pressureSetpointGA: Double,

    /**
     * Pressure setpoint time constant.
     */
    val pressureSetpointTC1: Double,

    /**
     * Pressure setpoint time constant.
     */
    val pressureSetpointTC2: Double,

    /**
     * Proportional gain.
     */
    val proportionalGain: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux1: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux2: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux3: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux4: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux5: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux6: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux7: Double,

    /**
     * Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
     */
    val rfAux8: Double,

    /**
     * Rod pattern.
     */
    val rodPattern: Double,

    /**
     * Constant associated with rod pattern.
     */
    val rodPatternConstant: Double,

    /**
     * Initial upper limit.
     */
    val upperLimit: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[BWRSteamSupply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BWRSteamSupply
extends
    Parseable[BWRSteamSupply]
{
    val sup = SteamSupply.parse _
    val highPowerLimit = parse_element (element ("""BWRSteamSupply.highPowerLimit"""))_
    val inCoreThermalTC = parse_element (element ("""BWRSteamSupply.inCoreThermalTC"""))_
    val integralGain = parse_element (element ("""BWRSteamSupply.integralGain"""))_
    val lowPowerLimit = parse_element (element ("""BWRSteamSupply.lowPowerLimit"""))_
    val lowerLimit = parse_element (element ("""BWRSteamSupply.lowerLimit"""))_
    val pressureLimit = parse_element (element ("""BWRSteamSupply.pressureLimit"""))_
    val pressureSetpointGA = parse_element (element ("""BWRSteamSupply.pressureSetpointGA"""))_
    val pressureSetpointTC1 = parse_element (element ("""BWRSteamSupply.pressureSetpointTC1"""))_
    val pressureSetpointTC2 = parse_element (element ("""BWRSteamSupply.pressureSetpointTC2"""))_
    val proportionalGain = parse_element (element ("""BWRSteamSupply.proportionalGain"""))_
    val rfAux1 = parse_element (element ("""BWRSteamSupply.rfAux1"""))_
    val rfAux2 = parse_element (element ("""BWRSteamSupply.rfAux2"""))_
    val rfAux3 = parse_element (element ("""BWRSteamSupply.rfAux3"""))_
    val rfAux4 = parse_element (element ("""BWRSteamSupply.rfAux4"""))_
    val rfAux5 = parse_element (element ("""BWRSteamSupply.rfAux5"""))_
    val rfAux6 = parse_element (element ("""BWRSteamSupply.rfAux6"""))_
    val rfAux7 = parse_element (element ("""BWRSteamSupply.rfAux7"""))_
    val rfAux8 = parse_element (element ("""BWRSteamSupply.rfAux8"""))_
    val rodPattern = parse_element (element ("""BWRSteamSupply.rodPattern"""))_
    val rodPatternConstant = parse_element (element ("""BWRSteamSupply.rodPatternConstant"""))_
    val upperLimit = parse_element (element ("""BWRSteamSupply.upperLimit"""))_
    def parse (context: Context): BWRSteamSupply =
    {
        BWRSteamSupply(
            sup (context),
            toDouble (highPowerLimit (context), context),
            toDouble (inCoreThermalTC (context), context),
            toDouble (integralGain (context), context),
            toDouble (lowPowerLimit (context), context),
            toDouble (lowerLimit (context), context),
            toDouble (pressureLimit (context), context),
            toDouble (pressureSetpointGA (context), context),
            toDouble (pressureSetpointTC1 (context), context),
            toDouble (pressureSetpointTC2 (context), context),
            toDouble (proportionalGain (context), context),
            toDouble (rfAux1 (context), context),
            toDouble (rfAux2 (context), context),
            toDouble (rfAux3 (context), context),
            toDouble (rfAux4 (context), context),
            toDouble (rfAux5 (context), context),
            toDouble (rfAux6 (context), context),
            toDouble (rfAux7 (context), context),
            toDouble (rfAux8 (context), context),
            toDouble (rodPattern (context), context),
            toDouble (rodPatternConstant (context), context),
            toDouble (upperLimit (context), context)
        )
    }
}

/**
 * Boiler control mode.
 */
case class BoilerControlMode
(

    override val sup: BasicElement,

    /**
     * Coordinated.
     */
    val coordinated: String,

    /**
     * Following.
     */
    val following: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BoilerControlMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BoilerControlMode
extends
    Parseable[BoilerControlMode]
{
    val sup = BasicElement.parse _
    val coordinated = parse_attribute (attribute ("""BoilerControlMode.coordinated"""))_
    val following = parse_attribute (attribute ("""BoilerControlMode.following"""))_
    def parse (context: Context): BoilerControlMode =
    {
        BoilerControlMode(
            sup (context),
            coordinated (context),
            following (context)
        )
    }
}

/**
 * Relationship between the combustion turbine's power output rating in gross active power (X-axis) and the ambient air temperature (Y-axis).
 */
case class CTTempActivePowerCurve
(

    override val sup: Curve,

    /**
     * A combustion turbine may have an active power versus ambient temperature relationship.
     */
    val CombustionTurbine: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[CTTempActivePowerCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CTTempActivePowerCurve
extends
    Parseable[CTTempActivePowerCurve]
{
    val sup = Curve.parse _
    val CombustionTurbine = parse_attribute (attribute ("""CTTempActivePowerCurve.CombustionTurbine"""))_
    def parse (context: Context): CTTempActivePowerCurve =
    {
        CTTempActivePowerCurve(
            sup (context),
            CombustionTurbine (context)
        )
    }
}

/**
 * A prime mover that is typically fueled by gas or light oil.
 */
case class CombustionTurbine
(

    override val sup: PrimeMover,

    /**
     * Default ambient temperature to be used in modeling applications.
     */
    val ambientTemp: Double,

    /**
     * Off-nominal frequency effect on turbine auxiliaries.
     * Per unit reduction in auxiliary active power consumption versus per unit reduction in frequency (from rated frequency).
     */
    val auxPowerVersusFrequency: Double,

    /**
     * Off-nominal voltage effect on turbine auxiliaries.
     * Per unit reduction in auxiliary active power consumption versus per unit reduction in auxiliary bus voltage (from a specified voltage level).
     */
    val auxPowerVersusVoltage: Double,

    /**
     * Off-nominal frequency effect on turbine capability.
     * Per unit reduction in unit active power capability versus per unit reduction in frequency (from rated frequency).
     */
    val capabilityVersusFrequency: Double,

    /**
     * Flag that is set to true if the combustion turbine is associated with a heat recovery boiler.
     */
    val heatRecoveryFlag: Boolean,

    /**
     * Per unit change in power per (versus) unit change in ambient temperature.
     */
    val powerVariationByTemp: Double,

    /**
     * Reference temperature at which the output of the turbine was defined.
     */
    val referenceTemp: Double,

    /**
     * The time constant for the turbine.
     */
    val timeConstant: Double,

    /**
     * A CAES air compressor is driven by combustion turbine.
     */
    val AirCompressor: String,

    /**
     * A combustion turbine may have an active power versus ambient temperature relationship.
     */
    val CTTempActivePowerCurve: String,

    /**
     * A combustion turbine may have a heat recovery boiler for making steam.
     */
    val HeatRecoveryBoiler: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, null, null, null) }
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { return (clone ().asInstanceOf[CombustionTurbine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CombustionTurbine
extends
    Parseable[CombustionTurbine]
{
    val sup = PrimeMover.parse _
    val ambientTemp = parse_element (element ("""CombustionTurbine.ambientTemp"""))_
    val auxPowerVersusFrequency = parse_element (element ("""CombustionTurbine.auxPowerVersusFrequency"""))_
    val auxPowerVersusVoltage = parse_element (element ("""CombustionTurbine.auxPowerVersusVoltage"""))_
    val capabilityVersusFrequency = parse_element (element ("""CombustionTurbine.capabilityVersusFrequency"""))_
    val heatRecoveryFlag = parse_element (element ("""CombustionTurbine.heatRecoveryFlag"""))_
    val powerVariationByTemp = parse_element (element ("""CombustionTurbine.powerVariationByTemp"""))_
    val referenceTemp = parse_element (element ("""CombustionTurbine.referenceTemp"""))_
    val timeConstant = parse_element (element ("""CombustionTurbine.timeConstant"""))_
    val AirCompressor = parse_attribute (attribute ("""CombustionTurbine.AirCompressor"""))_
    val CTTempActivePowerCurve = parse_attribute (attribute ("""CombustionTurbine.CTTempActivePowerCurve"""))_
    val HeatRecoveryBoiler = parse_attribute (attribute ("""CombustionTurbine.HeatRecoveryBoiler"""))_
    def parse (context: Context): CombustionTurbine =
    {
        CombustionTurbine(
            sup (context),
            toDouble (ambientTemp (context), context),
            toDouble (auxPowerVersusFrequency (context), context),
            toDouble (auxPowerVersusVoltage (context), context),
            toDouble (capabilityVersusFrequency (context), context),
            toBoolean (heatRecoveryFlag (context), context),
            toDouble (powerVariationByTemp (context), context),
            toDouble (referenceTemp (context), context),
            toDouble (timeConstant (context), context),
            AirCompressor (context),
            CTTempActivePowerCurve (context),
            HeatRecoveryBoiler (context)
        )
    }
}

/**
 * Drum boiler.
 */
case class DrumBoiler
(

    override val sup: FossilSteamSupply,

    /**
     * Rating of drum boiler in steam units.
     */
    val drumBoilerRating: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[DrumBoiler]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DrumBoiler
extends
    Parseable[DrumBoiler]
{
    val sup = FossilSteamSupply.parse _
    val drumBoilerRating = parse_element (element ("""DrumBoiler.drumBoilerRating"""))_
    def parse (context: Context): DrumBoiler =
    {
        DrumBoiler(
            sup (context),
            toDouble (drumBoilerRating (context), context)
        )
    }
}

/**
 * Fossil fueled boiler (e.g., coal, oil, gas).
 */
case class FossilSteamSupply
(

    override val sup: SteamSupply,

    /**
     * Off nominal frequency effect on auxiliary real power.
     * Per unit active power variation versus per unit frequency variation.
     */
    val auxPowerVersusFrequency: Double,

    /**
     * Off nominal voltage effect on auxiliary real power.
     * Per unit active power variation versus per unit voltage variation.
     */
    val auxPowerVersusVoltage: Double,

    /**
     * The control mode of the boiler.
     */
    val boilerControlMode: String,

    /**
     * Active power error bias ratio.
     */
    val controlErrorBiasP: Double,

    /**
     * Integral constant.
     */
    val controlIC: Double,

    /**
     * Proportional constant.
     */
    val controlPC: Double,

    /**
     * Pressure error bias ratio.
     */
    val controlPEB: Double,

    /**
     * Pressure error deadband.
     */
    val controlPED: Double,

    /**
     * Time constant.
     */
    val controlTC: Double,

    /**
     * Feedwater integral gain ratio.
     */
    val feedWaterIG: Double,

    /**
     * Feedwater proportional gain ratio.
     */
    val feedWaterPG: Double,

    /**
     * Feedwater time constant rato.
     */
    val feedWaterTC: Double,

    /**
     * Fuel demand limit.
     */
    val fuelDemandLimit: Double,

    /**
     * Fuel delay.
     */
    val fuelSupplyDelay: Double,

    /**
     * Fuel supply time constant.
     */
    val fuelSupplyTC: Double,

    /**
     * Active power maximum error rate limit.
     */
    val maxErrorRateP: Double,

    /**
     * Mechanical power sensor lag.
     */
    val mechPowerSensorLag: Double,

    /**
     * Active power minimum error rate limit.
     */
    val minErrorRateP: Double,

    /**
     * Pressure control derivative gain ratio.
     */
    val pressureCtrlDG: Double,

    /**
     * Pressure control integral gain ratio.
     */
    val pressureCtrlIG: Double,

    /**
     * Pressure control proportional gain ratio.
     */
    val pressureCtrlPG: Double,

    /**
     * Pressure feedback indicator.
     */
    val pressureFeedback: Int,

    /**
     * Drum/primary superheater capacity.
     */
    val superHeater1Capacity: Double,

    /**
     * Secondary superheater capacity.
     */
    val superHeater2Capacity: Double,

    /**
     * Superheater pipe pressure drop constant.
     */
    val superHeaterPipePD: Double,

    /**
     * Throttle pressure setpoint.
     */
    val throttlePressureSP: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0) }
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[FossilSteamSupply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FossilSteamSupply
extends
    Parseable[FossilSteamSupply]
{
    val sup = SteamSupply.parse _
    val auxPowerVersusFrequency = parse_element (element ("""FossilSteamSupply.auxPowerVersusFrequency"""))_
    val auxPowerVersusVoltage = parse_element (element ("""FossilSteamSupply.auxPowerVersusVoltage"""))_
    val boilerControlMode = parse_attribute (attribute ("""FossilSteamSupply.boilerControlMode"""))_
    val controlErrorBiasP = parse_element (element ("""FossilSteamSupply.controlErrorBiasP"""))_
    val controlIC = parse_element (element ("""FossilSteamSupply.controlIC"""))_
    val controlPC = parse_element (element ("""FossilSteamSupply.controlPC"""))_
    val controlPEB = parse_element (element ("""FossilSteamSupply.controlPEB"""))_
    val controlPED = parse_element (element ("""FossilSteamSupply.controlPED"""))_
    val controlTC = parse_element (element ("""FossilSteamSupply.controlTC"""))_
    val feedWaterIG = parse_element (element ("""FossilSteamSupply.feedWaterIG"""))_
    val feedWaterPG = parse_element (element ("""FossilSteamSupply.feedWaterPG"""))_
    val feedWaterTC = parse_element (element ("""FossilSteamSupply.feedWaterTC"""))_
    val fuelDemandLimit = parse_element (element ("""FossilSteamSupply.fuelDemandLimit"""))_
    val fuelSupplyDelay = parse_element (element ("""FossilSteamSupply.fuelSupplyDelay"""))_
    val fuelSupplyTC = parse_element (element ("""FossilSteamSupply.fuelSupplyTC"""))_
    val maxErrorRateP = parse_element (element ("""FossilSteamSupply.maxErrorRateP"""))_
    val mechPowerSensorLag = parse_element (element ("""FossilSteamSupply.mechPowerSensorLag"""))_
    val minErrorRateP = parse_element (element ("""FossilSteamSupply.minErrorRateP"""))_
    val pressureCtrlDG = parse_element (element ("""FossilSteamSupply.pressureCtrlDG"""))_
    val pressureCtrlIG = parse_element (element ("""FossilSteamSupply.pressureCtrlIG"""))_
    val pressureCtrlPG = parse_element (element ("""FossilSteamSupply.pressureCtrlPG"""))_
    val pressureFeedback = parse_element (element ("""FossilSteamSupply.pressureFeedback"""))_
    val superHeater1Capacity = parse_element (element ("""FossilSteamSupply.superHeater1Capacity"""))_
    val superHeater2Capacity = parse_element (element ("""FossilSteamSupply.superHeater2Capacity"""))_
    val superHeaterPipePD = parse_element (element ("""FossilSteamSupply.superHeaterPipePD"""))_
    val throttlePressureSP = parse_element (element ("""FossilSteamSupply.throttlePressureSP"""))_
    def parse (context: Context): FossilSteamSupply =
    {
        FossilSteamSupply(
            sup (context),
            toDouble (auxPowerVersusFrequency (context), context),
            toDouble (auxPowerVersusVoltage (context), context),
            boilerControlMode (context),
            toDouble (controlErrorBiasP (context), context),
            toDouble (controlIC (context), context),
            toDouble (controlPC (context), context),
            toDouble (controlPEB (context), context),
            toDouble (controlPED (context), context),
            toDouble (controlTC (context), context),
            toDouble (feedWaterIG (context), context),
            toDouble (feedWaterPG (context), context),
            toDouble (feedWaterTC (context), context),
            toDouble (fuelDemandLimit (context), context),
            toDouble (fuelSupplyDelay (context), context),
            toDouble (fuelSupplyTC (context), context),
            toDouble (maxErrorRateP (context), context),
            toDouble (mechPowerSensorLag (context), context),
            toDouble (minErrorRateP (context), context),
            toDouble (pressureCtrlDG (context), context),
            toDouble (pressureCtrlIG (context), context),
            toDouble (pressureCtrlPG (context), context),
            toInteger (pressureFeedback (context), context),
            toDouble (superHeater1Capacity (context), context),
            toDouble (superHeater2Capacity (context), context),
            toDouble (superHeaterPipePD (context), context),
            toDouble (throttlePressureSP (context), context)
        )
    }
}

/**
 * The heat recovery system associated with combustion turbines in order to produce steam for combined cycle plants.
 */
case class HeatRecoveryBoiler
(

    override val sup: FossilSteamSupply,

    /**
     * The steam supply rating in kilopounds per hour, if dual pressure boiler.
     */
    val steamSupplyRating2: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[HeatRecoveryBoiler]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HeatRecoveryBoiler
extends
    Parseable[HeatRecoveryBoiler]
{
    val sup = FossilSteamSupply.parse _
    val steamSupplyRating2 = parse_element (element ("""HeatRecoveryBoiler.steamSupplyRating2"""))_
    def parse (context: Context): HeatRecoveryBoiler =
    {
        HeatRecoveryBoiler(
            sup (context),
            toDouble (steamSupplyRating2 (context), context)
        )
    }
}

/**
 * A water driven prime mover.
 * Typical turbine types are: Francis, Kaplan, and Pelton.
 */
case class HydroTurbine
(

    override val sup: PrimeMover,

    /**
     * Gate rate limit.
     */
    val gateRateLimit: Double,

    /**
     * Gate upper limit.
     */
    val gateUpperLimit: Double,

    /**
     * Maximum efficiency active power at maximum head conditions.
     */
    val maxHeadMaxP: Double,

    /**
     * Maximum efficiency active power at minimum head conditions.
     */
    val minHeadMaxP: Double,

    /**
     * Rated speed in number of revolutions.
     */
    val speedRating: Double,

    /**
     * Speed regulation.
     */
    val speedRegulation: Double,

    /**
     * Transient droop time constant.
     */
    val transientDroopTime: Double,

    /**
     * Transient regulation.
     */
    val transientRegulation: Double,

    /**
     * Rated turbine active power.
     */
    val turbineRating: Double,

    /**
     * Type of turbine.
     */
    val turbineType: String,

    /**
     * Water starting time.
     */
    val waterStartingTime: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0) }
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { return (clone ().asInstanceOf[HydroTurbine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object HydroTurbine
extends
    Parseable[HydroTurbine]
{
    val sup = PrimeMover.parse _
    val gateRateLimit = parse_element (element ("""HydroTurbine.gateRateLimit"""))_
    val gateUpperLimit = parse_element (element ("""HydroTurbine.gateUpperLimit"""))_
    val maxHeadMaxP = parse_element (element ("""HydroTurbine.maxHeadMaxP"""))_
    val minHeadMaxP = parse_element (element ("""HydroTurbine.minHeadMaxP"""))_
    val speedRating = parse_element (element ("""HydroTurbine.speedRating"""))_
    val speedRegulation = parse_element (element ("""HydroTurbine.speedRegulation"""))_
    val transientDroopTime = parse_element (element ("""HydroTurbine.transientDroopTime"""))_
    val transientRegulation = parse_element (element ("""HydroTurbine.transientRegulation"""))_
    val turbineRating = parse_element (element ("""HydroTurbine.turbineRating"""))_
    val turbineType = parse_attribute (attribute ("""HydroTurbine.turbineType"""))_
    val waterStartingTime = parse_element (element ("""HydroTurbine.waterStartingTime"""))_
    def parse (context: Context): HydroTurbine =
    {
        HydroTurbine(
            sup (context),
            toDouble (gateRateLimit (context), context),
            toDouble (gateUpperLimit (context), context),
            toDouble (maxHeadMaxP (context), context),
            toDouble (minHeadMaxP (context), context),
            toDouble (speedRating (context), context),
            toDouble (speedRegulation (context), context),
            toDouble (transientDroopTime (context), context),
            toDouble (transientRegulation (context), context),
            toDouble (turbineRating (context), context),
            turbineType (context),
            toDouble (waterStartingTime (context), context)
        )
    }
}

/**
 * Pressurized water reactor used as a steam supply to a steam turbine.
 */
case class PWRSteamSupply
(

    override val sup: SteamSupply,

    /**
     * Cold leg feedback lag time constant.
     */
    val coldLegFBLagTC: Double,

    /**
     * Cold leg feedback lead time constant.
     */
    val coldLegFBLeadTC1: Double,

    /**
     * Cold leg feedback lead time constant.
     */
    val coldLegFBLeadTC2: Double,

    /**
     * Cold leg feedback gain 1.
     */
    val coldLegFG1: Double,

    /**
     * Cold leg feedback gain 2.
     */
    val coldLegFG2: Double,

    /**
     * Cold leg lag time constant.
     */
    val coldLegLagTC: Double,

    /**
     * Core heat transfer lag time constant.
     */
    val coreHTLagTC1: Double,

    /**
     * Core heat transfer lag time constant.
     */
    val coreHTLagTC2: Double,

    /**
     * Core neutronics effective time constant.
     */
    val coreNeutronicsEffTC: Double,

    /**
     * Core neutronics and heat transfer.
     */
    val coreNeutronicsHT: Double,

    /**
     * Feedback factor.
     */
    val feedbackFactor: Double,

    /**
     * Hot leg lag time constant.
     */
    val hotLegLagTC: Double,

    /**
     * Hot leg steam gain.
     */
    val hotLegSteamGain: Double,

    /**
     * Hot leg to cold leg gain.
     */
    val hotLegToColdLegGain: Double,

    /**
     * Pressure control gain.
     */
    val pressureCG: Double,

    /**
     * Steam flow feedback gain.
     */
    val steamFlowFG: Double,

    /**
     * Steam pressure drop lag time constant.
     */
    val steamPressureDropLagTC: Double,

    /**
     * Steam pressure feedback gain.
     */
    val steamPressureFG: Double,

    /**
     * Throttle pressure factor.
     */
    val throttlePressureFactor: Double,

    /**
     * Throttle pressure setpoint.
     */
    val throttlePressureSP: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[PWRSteamSupply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PWRSteamSupply
extends
    Parseable[PWRSteamSupply]
{
    val sup = SteamSupply.parse _
    val coldLegFBLagTC = parse_element (element ("""PWRSteamSupply.coldLegFBLagTC"""))_
    val coldLegFBLeadTC1 = parse_element (element ("""PWRSteamSupply.coldLegFBLeadTC1"""))_
    val coldLegFBLeadTC2 = parse_element (element ("""PWRSteamSupply.coldLegFBLeadTC2"""))_
    val coldLegFG1 = parse_element (element ("""PWRSteamSupply.coldLegFG1"""))_
    val coldLegFG2 = parse_element (element ("""PWRSteamSupply.coldLegFG2"""))_
    val coldLegLagTC = parse_element (element ("""PWRSteamSupply.coldLegLagTC"""))_
    val coreHTLagTC1 = parse_element (element ("""PWRSteamSupply.coreHTLagTC1"""))_
    val coreHTLagTC2 = parse_element (element ("""PWRSteamSupply.coreHTLagTC2"""))_
    val coreNeutronicsEffTC = parse_element (element ("""PWRSteamSupply.coreNeutronicsEffTC"""))_
    val coreNeutronicsHT = parse_element (element ("""PWRSteamSupply.coreNeutronicsHT"""))_
    val feedbackFactor = parse_element (element ("""PWRSteamSupply.feedbackFactor"""))_
    val hotLegLagTC = parse_element (element ("""PWRSteamSupply.hotLegLagTC"""))_
    val hotLegSteamGain = parse_element (element ("""PWRSteamSupply.hotLegSteamGain"""))_
    val hotLegToColdLegGain = parse_element (element ("""PWRSteamSupply.hotLegToColdLegGain"""))_
    val pressureCG = parse_element (element ("""PWRSteamSupply.pressureCG"""))_
    val steamFlowFG = parse_element (element ("""PWRSteamSupply.steamFlowFG"""))_
    val steamPressureDropLagTC = parse_element (element ("""PWRSteamSupply.steamPressureDropLagTC"""))_
    val steamPressureFG = parse_element (element ("""PWRSteamSupply.steamPressureFG"""))_
    val throttlePressureFactor = parse_element (element ("""PWRSteamSupply.throttlePressureFactor"""))_
    val throttlePressureSP = parse_element (element ("""PWRSteamSupply.throttlePressureSP"""))_
    def parse (context: Context): PWRSteamSupply =
    {
        PWRSteamSupply(
            sup (context),
            toDouble (coldLegFBLagTC (context), context),
            toDouble (coldLegFBLeadTC1 (context), context),
            toDouble (coldLegFBLeadTC2 (context), context),
            toDouble (coldLegFG1 (context), context),
            toDouble (coldLegFG2 (context), context),
            toDouble (coldLegLagTC (context), context),
            toDouble (coreHTLagTC1 (context), context),
            toDouble (coreHTLagTC2 (context), context),
            toDouble (coreNeutronicsEffTC (context), context),
            toDouble (coreNeutronicsHT (context), context),
            toDouble (feedbackFactor (context), context),
            toDouble (hotLegLagTC (context), context),
            toDouble (hotLegSteamGain (context), context),
            toDouble (hotLegToColdLegGain (context), context),
            toDouble (pressureCG (context), context),
            toDouble (steamFlowFG (context), context),
            toDouble (steamPressureDropLagTC (context), context),
            toDouble (steamPressureFG (context), context),
            toDouble (throttlePressureFactor (context), context),
            toDouble (throttlePressureSP (context), context)
        )
    }
}

/**
 * The machine used to develop mechanical energy used to drive a generator.
 */
case class PrimeMover
(

    override val sup: PowerSystemResource,

    /**
     * Rating of prime mover.
     */
    val primeMoverRating: Double,

    /**
     * Synchronous machines this Prime mover drives.
     */
    val SynchronousMachines: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[PrimeMover]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PrimeMover
extends
    Parseable[PrimeMover]
{
    val sup = PowerSystemResource.parse _
    val primeMoverRating = parse_element (element ("""PrimeMover.primeMoverRating"""))_
    val SynchronousMachines = parse_attributes (attribute ("""PrimeMover.SynchronousMachines"""))_
    def parse (context: Context): PrimeMover =
    {
        PrimeMover(
            sup (context),
            toDouble (primeMoverRating (context), context),
            SynchronousMachines (context)
        )
    }
}

/**
 * Steam supply for steam turbine.
 */
case class SteamSupply
(

    override val sup: PowerSystemResource,

    /**
     * Rating of steam supply.
     */
    val steamSupplyRating: Double,

    /**
     * Steam turbines may have steam supplied by a steam supply.
     */
    val SteamTurbines: List[String]
)
extends
    Element
{
    def this () = { this (null, 0.0, List()) }
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { return (clone ().asInstanceOf[SteamSupply]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SteamSupply
extends
    Parseable[SteamSupply]
{
    val sup = PowerSystemResource.parse _
    val steamSupplyRating = parse_element (element ("""SteamSupply.steamSupplyRating"""))_
    val SteamTurbines = parse_attributes (attribute ("""SteamSupply.SteamTurbines"""))_
    def parse (context: Context): SteamSupply =
    {
        SteamSupply(
            sup (context),
            toDouble (steamSupplyRating (context), context),
            SteamTurbines (context)
        )
    }
}

/**
 * Steam turbine.
 */
case class SteamTurbine
(

    override val sup: PrimeMover,

    /**
     * Crossover time constant.
     */
    val crossoverTC: Double,

    /**
     * First reheater time constant.
     */
    val reheater1TC: Double,

    /**
     * Second reheater time constant.
     */
    val reheater2TC: Double,

    /**
     * Fraction of power from shaft 1 high pressure turbine output.
     */
    val shaft1PowerHP: Double,

    /**
     * Fraction of power from shaft 1 intermediate pressure turbine output.
     */
    val shaft1PowerIP: Double,

    /**
     * Fraction of power from shaft 1 first low pressure turbine output.
     */
    val shaft1PowerLP1: Double,

    /**
     * Fraction of power from shaft 1 second low pressure turbine output.
     */
    val shaft1PowerLP2: Double,

    /**
     * Fraction of power from shaft 2 high pressure turbine output.
     */
    val shaft2PowerHP: Double,

    /**
     * Fraction of power from shaft 2 intermediate pressure turbine output.
     */
    val shaft2PowerIP: Double,

    /**
     * Fraction of power from shaft 2 first low pressure turbine output.
     */
    val shaft2PowerLP1: Double,

    /**
     * Fraction of power from shaft 2 second low pressure turbine output.
     */
    val shaft2PowerLP2: Double,

    /**
     * Steam chest time constant.
     */
    val steamChestTC: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { return (clone ().asInstanceOf[SteamTurbine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SteamTurbine
extends
    Parseable[SteamTurbine]
{
    val sup = PrimeMover.parse _
    val crossoverTC = parse_element (element ("""SteamTurbine.crossoverTC"""))_
    val reheater1TC = parse_element (element ("""SteamTurbine.reheater1TC"""))_
    val reheater2TC = parse_element (element ("""SteamTurbine.reheater2TC"""))_
    val shaft1PowerHP = parse_element (element ("""SteamTurbine.shaft1PowerHP"""))_
    val shaft1PowerIP = parse_element (element ("""SteamTurbine.shaft1PowerIP"""))_
    val shaft1PowerLP1 = parse_element (element ("""SteamTurbine.shaft1PowerLP1"""))_
    val shaft1PowerLP2 = parse_element (element ("""SteamTurbine.shaft1PowerLP2"""))_
    val shaft2PowerHP = parse_element (element ("""SteamTurbine.shaft2PowerHP"""))_
    val shaft2PowerIP = parse_element (element ("""SteamTurbine.shaft2PowerIP"""))_
    val shaft2PowerLP1 = parse_element (element ("""SteamTurbine.shaft2PowerLP1"""))_
    val shaft2PowerLP2 = parse_element (element ("""SteamTurbine.shaft2PowerLP2"""))_
    val steamChestTC = parse_element (element ("""SteamTurbine.steamChestTC"""))_
    def parse (context: Context): SteamTurbine =
    {
        SteamTurbine(
            sup (context),
            toDouble (crossoverTC (context), context),
            toDouble (reheater1TC (context), context),
            toDouble (reheater2TC (context), context),
            toDouble (shaft1PowerHP (context), context),
            toDouble (shaft1PowerIP (context), context),
            toDouble (shaft1PowerLP1 (context), context),
            toDouble (shaft1PowerLP2 (context), context),
            toDouble (shaft2PowerHP (context), context),
            toDouble (shaft2PowerIP (context), context),
            toDouble (shaft2PowerLP1 (context), context),
            toDouble (shaft2PowerLP2 (context), context),
            toDouble (steamChestTC (context), context)
        )
    }
}

/**
 * Once-through subcritical boiler.
 */
case class Subcritical
(

    override val sup: FossilSteamSupply
)
extends
    Element
{
    def this () = { this (null) }
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[Subcritical]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Subcritical
extends
    Parseable[Subcritical]
{
    val sup = FossilSteamSupply.parse _
    def parse (context: Context): Subcritical =
    {
        Subcritical(
            sup (context)
        )
    }
}

/**
 * Once-through supercritical boiler.
 */
case class Supercritical
(

    override val sup: FossilSteamSupply
)
extends
    Element
{
    def this () = { this (null) }
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { return (clone ().asInstanceOf[Supercritical]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Supercritical
extends
    Parseable[Supercritical]
{
    val sup = FossilSteamSupply.parse _
    def parse (context: Context): Supercritical =
    {
        Supercritical(
            sup (context)
        )
    }
}

/**
 * Type of turbine.
 */
case class TurbineType
(

    override val sup: BasicElement,

    /**
     * Francis.
     */
    val francis: String,

    /**
     * Kaplan.
     */
    val kaplan: String,

    /**
     * Pelton.
     */
    val pelton: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbineType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbineType
extends
    Parseable[TurbineType]
{
    val sup = BasicElement.parse _
    val francis = parse_attribute (attribute ("""TurbineType.francis"""))_
    val kaplan = parse_attribute (attribute ("""TurbineType.kaplan"""))_
    val pelton = parse_attribute (attribute ("""TurbineType.pelton"""))_
    def parse (context: Context): TurbineType =
    {
        TurbineType(
            sup (context),
            francis (context),
            kaplan (context),
            pelton (context)
        )
    }
}

object _GenerationTrainingSimulation
{
    def register: Unit =
    {
        BWRSteamSupply.register
        BoilerControlMode.register
        CTTempActivePowerCurve.register
        CombustionTurbine.register
        DrumBoiler.register
        FossilSteamSupply.register
        HeatRecoveryBoiler.register
        HydroTurbine.register
        PWRSteamSupply.register
        PrimeMover.register
        SteamSupply.register
        SteamTurbine.register
        Subcritical.register
        Supercritical.register
        TurbineType.register
    }
}