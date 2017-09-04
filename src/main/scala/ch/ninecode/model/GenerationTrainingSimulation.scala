package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Boiling water reactor used as a steam supply to a steam turbine.
 *
 * @param sup [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
 * @param highPowerLimit High power limit.
 * @param inCoreThermalTC In-core thermal time constant.
 * @param integralGain Integral gain.
 * @param lowPowerLimit Low power limit.
 * @param lowerLimit Initial lower limit.
 * @param pressureLimit Pressure limit.
 * @param pressureSetpointGA Pressure setpoint gain adjuster.
 * @param pressureSetpointTC1 Pressure setpoint time constant.
 * @param pressureSetpointTC2 Pressure setpoint time constant.
 * @param proportionalGain Proportional gain.
 * @param rfAux1 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux2 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux3 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux4 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux5 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux6 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux7 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux8 Coefficient for modeling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rodPattern Rod pattern.
 * @param rodPatternConstant Constant associated with rod pattern.
 * @param upperLimit Initial upper limit.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class BWRSteamSupply
(
    override val sup: SteamSupply,
    highPowerLimit: Double,
    inCoreThermalTC: Double,
    integralGain: Double,
    lowPowerLimit: Double,
    lowerLimit: Double,
    pressureLimit: Double,
    pressureSetpointGA: Double,
    pressureSetpointTC1: Double,
    pressureSetpointTC2: Double,
    proportionalGain: Double,
    rfAux1: Double,
    rfAux2: Double,
    rfAux3: Double,
    rfAux4: Double,
    rfAux5: Double,
    rfAux6: Double,
    rfAux7: Double,
    rfAux8: Double,
    rodPattern: Double,
    rodPatternConstant: Double,
    upperLimit: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[BWRSteamSupply] }
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
        "\t\t<cim:BWRSteamSupply.highPowerLimit>" + highPowerLimit + "</cim:BWRSteamSupply.highPowerLimit>\n" +
        "\t\t<cim:BWRSteamSupply.inCoreThermalTC>" + inCoreThermalTC + "</cim:BWRSteamSupply.inCoreThermalTC>\n" +
        "\t\t<cim:BWRSteamSupply.integralGain>" + integralGain + "</cim:BWRSteamSupply.integralGain>\n" +
        "\t\t<cim:BWRSteamSupply.lowPowerLimit>" + lowPowerLimit + "</cim:BWRSteamSupply.lowPowerLimit>\n" +
        "\t\t<cim:BWRSteamSupply.lowerLimit>" + lowerLimit + "</cim:BWRSteamSupply.lowerLimit>\n" +
        "\t\t<cim:BWRSteamSupply.pressureLimit>" + pressureLimit + "</cim:BWRSteamSupply.pressureLimit>\n" +
        "\t\t<cim:BWRSteamSupply.pressureSetpointGA>" + pressureSetpointGA + "</cim:BWRSteamSupply.pressureSetpointGA>\n" +
        "\t\t<cim:BWRSteamSupply.pressureSetpointTC1>" + pressureSetpointTC1 + "</cim:BWRSteamSupply.pressureSetpointTC1>\n" +
        "\t\t<cim:BWRSteamSupply.pressureSetpointTC2>" + pressureSetpointTC2 + "</cim:BWRSteamSupply.pressureSetpointTC2>\n" +
        "\t\t<cim:BWRSteamSupply.proportionalGain>" + proportionalGain + "</cim:BWRSteamSupply.proportionalGain>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux1>" + rfAux1 + "</cim:BWRSteamSupply.rfAux1>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux2>" + rfAux2 + "</cim:BWRSteamSupply.rfAux2>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux3>" + rfAux3 + "</cim:BWRSteamSupply.rfAux3>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux4>" + rfAux4 + "</cim:BWRSteamSupply.rfAux4>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux5>" + rfAux5 + "</cim:BWRSteamSupply.rfAux5>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux6>" + rfAux6 + "</cim:BWRSteamSupply.rfAux6>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux7>" + rfAux7 + "</cim:BWRSteamSupply.rfAux7>\n" +
        "\t\t<cim:BWRSteamSupply.rfAux8>" + rfAux8 + "</cim:BWRSteamSupply.rfAux8>\n" +
        "\t\t<cim:BWRSteamSupply.rodPattern>" + rodPattern + "</cim:BWRSteamSupply.rodPattern>\n" +
        "\t\t<cim:BWRSteamSupply.rodPatternConstant>" + rodPatternConstant + "</cim:BWRSteamSupply.rodPatternConstant>\n" +
        "\t\t<cim:BWRSteamSupply.upperLimit>" + upperLimit + "</cim:BWRSteamSupply.upperLimit>\n"
    }
    override def export: String =
    {
        "\t<cim:BWRSteamSupply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BWRSteamSupply>"
    }
}

object BWRSteamSupply
extends
    Parseable[BWRSteamSupply]
{
    val highPowerLimit = parse_element (element ("""BWRSteamSupply.highPowerLimit"""))
    val inCoreThermalTC = parse_element (element ("""BWRSteamSupply.inCoreThermalTC"""))
    val integralGain = parse_element (element ("""BWRSteamSupply.integralGain"""))
    val lowPowerLimit = parse_element (element ("""BWRSteamSupply.lowPowerLimit"""))
    val lowerLimit = parse_element (element ("""BWRSteamSupply.lowerLimit"""))
    val pressureLimit = parse_element (element ("""BWRSteamSupply.pressureLimit"""))
    val pressureSetpointGA = parse_element (element ("""BWRSteamSupply.pressureSetpointGA"""))
    val pressureSetpointTC1 = parse_element (element ("""BWRSteamSupply.pressureSetpointTC1"""))
    val pressureSetpointTC2 = parse_element (element ("""BWRSteamSupply.pressureSetpointTC2"""))
    val proportionalGain = parse_element (element ("""BWRSteamSupply.proportionalGain"""))
    val rfAux1 = parse_element (element ("""BWRSteamSupply.rfAux1"""))
    val rfAux2 = parse_element (element ("""BWRSteamSupply.rfAux2"""))
    val rfAux3 = parse_element (element ("""BWRSteamSupply.rfAux3"""))
    val rfAux4 = parse_element (element ("""BWRSteamSupply.rfAux4"""))
    val rfAux5 = parse_element (element ("""BWRSteamSupply.rfAux5"""))
    val rfAux6 = parse_element (element ("""BWRSteamSupply.rfAux6"""))
    val rfAux7 = parse_element (element ("""BWRSteamSupply.rfAux7"""))
    val rfAux8 = parse_element (element ("""BWRSteamSupply.rfAux8"""))
    val rodPattern = parse_element (element ("""BWRSteamSupply.rodPattern"""))
    val rodPatternConstant = parse_element (element ("""BWRSteamSupply.rodPatternConstant"""))
    val upperLimit = parse_element (element ("""BWRSteamSupply.upperLimit"""))
    def parse (context: Context): BWRSteamSupply =
    {
        BWRSteamSupply(
            SteamSupply.parse (context),
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
 * Relationship between the combustion turbine's power output rating in gross active power (X-axis) and the ambient air temperature (Y-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param CombustionTurbine [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A combustion turbine may have an active power versus ambient temperature relationship.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class CTTempActivePowerCurve
(
    override val sup: Curve,
    CombustionTurbine: String
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[CTTempActivePowerCurve] }
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
        (if (null != CombustionTurbine) "\t\t<cim:CTTempActivePowerCurve.CombustionTurbine rdf:resource=\"#" + CombustionTurbine + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CTTempActivePowerCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CTTempActivePowerCurve>"
    }
}

object CTTempActivePowerCurve
extends
    Parseable[CTTempActivePowerCurve]
{
    val CombustionTurbine = parse_attribute (attribute ("""CTTempActivePowerCurve.CombustionTurbine"""))
    def parse (context: Context): CTTempActivePowerCurve =
    {
        CTTempActivePowerCurve(
            Curve.parse (context),
            CombustionTurbine (context)
        )
    }
}

/**
 * A prime mover that is typically fueled by gas or light oil.
 *
 * @param sup [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
 * @param ambientTemp Default ambient temperature to be used in modeling applications.
 * @param auxPowerVersusFrequency Off-nominal frequency effect on turbine auxiliaries.
 *        Per unit reduction in auxiliary active power consumption versus per unit reduction in frequency (from rated frequency).
 * @param auxPowerVersusVoltage Off-nominal voltage effect on turbine auxiliaries.
 *        Per unit reduction in auxiliary active power consumption versus per unit reduction in auxiliary bus voltage (from a specified voltage level).
 * @param capabilityVersusFrequency Off-nominal frequency effect on turbine capability.
 *        Per unit reduction in unit active power capability versus per unit reduction in frequency (from rated frequency).
 * @param heatRecoveryFlag Flag that is set to true if the combustion turbine is associated with a heat recovery boiler.
 * @param powerVariationByTemp Per unit change in power per (versus) unit change in ambient temperature.
 * @param referenceTemp Reference temperature at which the output of the turbine was defined.
 * @param timeConstant The time constant for the turbine.
 * @param AirCompressor [[ch.ninecode.model.AirCompressor AirCompressor]] A CAES air compressor is driven by combustion turbine.
 * @param CTTempActivePowerCurve [[ch.ninecode.model.CTTempActivePowerCurve CTTempActivePowerCurve]] A combustion turbine may have an active power versus ambient temperature relationship.
 * @param HeatRecoveryBoiler [[ch.ninecode.model.HeatRecoveryBoiler HeatRecoveryBoiler]] A combustion turbine may have a heat recovery boiler for making steam.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class CombustionTurbine
(
    override val sup: PrimeMover,
    ambientTemp: Double,
    auxPowerVersusFrequency: Double,
    auxPowerVersusVoltage: Double,
    capabilityVersusFrequency: Double,
    heatRecoveryFlag: Boolean,
    powerVariationByTemp: Double,
    referenceTemp: Double,
    timeConstant: Double,
    AirCompressor: String,
    CTTempActivePowerCurve: String,
    HeatRecoveryBoiler: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { clone ().asInstanceOf[CombustionTurbine] }
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
        "\t\t<cim:CombustionTurbine.ambientTemp>" + ambientTemp + "</cim:CombustionTurbine.ambientTemp>\n" +
        "\t\t<cim:CombustionTurbine.auxPowerVersusFrequency>" + auxPowerVersusFrequency + "</cim:CombustionTurbine.auxPowerVersusFrequency>\n" +
        "\t\t<cim:CombustionTurbine.auxPowerVersusVoltage>" + auxPowerVersusVoltage + "</cim:CombustionTurbine.auxPowerVersusVoltage>\n" +
        "\t\t<cim:CombustionTurbine.capabilityVersusFrequency>" + capabilityVersusFrequency + "</cim:CombustionTurbine.capabilityVersusFrequency>\n" +
        "\t\t<cim:CombustionTurbine.heatRecoveryFlag>" + heatRecoveryFlag + "</cim:CombustionTurbine.heatRecoveryFlag>\n" +
        "\t\t<cim:CombustionTurbine.powerVariationByTemp>" + powerVariationByTemp + "</cim:CombustionTurbine.powerVariationByTemp>\n" +
        "\t\t<cim:CombustionTurbine.referenceTemp>" + referenceTemp + "</cim:CombustionTurbine.referenceTemp>\n" +
        "\t\t<cim:CombustionTurbine.timeConstant>" + timeConstant + "</cim:CombustionTurbine.timeConstant>\n" +
        (if (null != AirCompressor) "\t\t<cim:CombustionTurbine.AirCompressor rdf:resource=\"#" + AirCompressor + "\"/>\n" else "") +
        (if (null != CTTempActivePowerCurve) "\t\t<cim:CombustionTurbine.CTTempActivePowerCurve rdf:resource=\"#" + CTTempActivePowerCurve + "\"/>\n" else "") +
        (if (null != HeatRecoveryBoiler) "\t\t<cim:CombustionTurbine.HeatRecoveryBoiler rdf:resource=\"#" + HeatRecoveryBoiler + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CombustionTurbine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CombustionTurbine>"
    }
}

object CombustionTurbine
extends
    Parseable[CombustionTurbine]
{
    val ambientTemp = parse_element (element ("""CombustionTurbine.ambientTemp"""))
    val auxPowerVersusFrequency = parse_element (element ("""CombustionTurbine.auxPowerVersusFrequency"""))
    val auxPowerVersusVoltage = parse_element (element ("""CombustionTurbine.auxPowerVersusVoltage"""))
    val capabilityVersusFrequency = parse_element (element ("""CombustionTurbine.capabilityVersusFrequency"""))
    val heatRecoveryFlag = parse_element (element ("""CombustionTurbine.heatRecoveryFlag"""))
    val powerVariationByTemp = parse_element (element ("""CombustionTurbine.powerVariationByTemp"""))
    val referenceTemp = parse_element (element ("""CombustionTurbine.referenceTemp"""))
    val timeConstant = parse_element (element ("""CombustionTurbine.timeConstant"""))
    val AirCompressor = parse_attribute (attribute ("""CombustionTurbine.AirCompressor"""))
    val CTTempActivePowerCurve = parse_attribute (attribute ("""CombustionTurbine.CTTempActivePowerCurve"""))
    val HeatRecoveryBoiler = parse_attribute (attribute ("""CombustionTurbine.HeatRecoveryBoiler"""))
    def parse (context: Context): CombustionTurbine =
    {
        CombustionTurbine(
            PrimeMover.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param drumBoilerRating Rating of drum boiler in steam units.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class DrumBoiler
(
    override val sup: FossilSteamSupply,
    drumBoilerRating: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[DrumBoiler] }
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
        "\t\t<cim:DrumBoiler.drumBoilerRating>" + drumBoilerRating + "</cim:DrumBoiler.drumBoilerRating>\n"
    }
    override def export: String =
    {
        "\t<cim:DrumBoiler rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DrumBoiler>"
    }
}

object DrumBoiler
extends
    Parseable[DrumBoiler]
{
    val drumBoilerRating = parse_element (element ("""DrumBoiler.drumBoilerRating"""))
    def parse (context: Context): DrumBoiler =
    {
        DrumBoiler(
            FossilSteamSupply.parse (context),
            toDouble (drumBoilerRating (context), context)
        )
    }
}

/**
 * Fossil fueled boiler (e.g., coal, oil, gas).
 *
 * @param sup [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
 * @param auxPowerVersusFrequency Off nominal frequency effect on auxiliary real power.
 *        Per unit active power variation versus per unit frequency variation.
 * @param auxPowerVersusVoltage Off nominal voltage effect on auxiliary real power.
 *        Per unit active power variation versus per unit voltage variation.
 * @param boilerControlMode The control mode of the boiler.
 * @param controlErrorBiasP Active power error bias ratio.
 * @param controlIC Integral constant.
 * @param controlPC Proportional constant.
 * @param controlPEB Pressure error bias ratio.
 * @param controlPED Pressure error deadband.
 * @param controlTC Time constant.
 * @param feedWaterIG Feedwater integral gain ratio.
 * @param feedWaterPG Feedwater proportional gain ratio.
 * @param feedWaterTC Feedwater time constant rato.
 * @param fuelDemandLimit Fuel demand limit.
 * @param fuelSupplyDelay Fuel delay.
 * @param fuelSupplyTC Fuel supply time constant.
 * @param maxErrorRateP Active power maximum error rate limit.
 * @param mechPowerSensorLag Mechanical power sensor lag.
 * @param minErrorRateP Active power minimum error rate limit.
 * @param pressureCtrlDG Pressure control derivative gain ratio.
 * @param pressureCtrlIG Pressure control integral gain ratio.
 * @param pressureCtrlPG Pressure control proportional gain ratio.
 * @param pressureFeedback Pressure feedback indicator.
 * @param superHeater1Capacity Drum/primary superheater capacity.
 * @param superHeater2Capacity Secondary superheater capacity.
 * @param superHeaterPipePD Superheater pipe pressure drop constant.
 * @param throttlePressureSP Throttle pressure setpoint.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class FossilSteamSupply
(
    override val sup: SteamSupply,
    auxPowerVersusFrequency: Double,
    auxPowerVersusVoltage: Double,
    boilerControlMode: String,
    controlErrorBiasP: Double,
    controlIC: Double,
    controlPC: Double,
    controlPEB: Double,
    controlPED: Double,
    controlTC: Double,
    feedWaterIG: Double,
    feedWaterPG: Double,
    feedWaterTC: Double,
    fuelDemandLimit: Double,
    fuelSupplyDelay: Double,
    fuelSupplyTC: Double,
    maxErrorRateP: Double,
    mechPowerSensorLag: Double,
    minErrorRateP: Double,
    pressureCtrlDG: Double,
    pressureCtrlIG: Double,
    pressureCtrlPG: Double,
    pressureFeedback: Int,
    superHeater1Capacity: Double,
    superHeater2Capacity: Double,
    superHeaterPipePD: Double,
    throttlePressureSP: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[FossilSteamSupply] }
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
        "\t\t<cim:FossilSteamSupply.auxPowerVersusFrequency>" + auxPowerVersusFrequency + "</cim:FossilSteamSupply.auxPowerVersusFrequency>\n" +
        "\t\t<cim:FossilSteamSupply.auxPowerVersusVoltage>" + auxPowerVersusVoltage + "</cim:FossilSteamSupply.auxPowerVersusVoltage>\n" +
        (if (null != boilerControlMode) "\t\t<cim:FossilSteamSupply.boilerControlMode rdf:resource=\"#" + boilerControlMode + "\"/>\n" else "") +
        "\t\t<cim:FossilSteamSupply.controlErrorBiasP>" + controlErrorBiasP + "</cim:FossilSteamSupply.controlErrorBiasP>\n" +
        "\t\t<cim:FossilSteamSupply.controlIC>" + controlIC + "</cim:FossilSteamSupply.controlIC>\n" +
        "\t\t<cim:FossilSteamSupply.controlPC>" + controlPC + "</cim:FossilSteamSupply.controlPC>\n" +
        "\t\t<cim:FossilSteamSupply.controlPEB>" + controlPEB + "</cim:FossilSteamSupply.controlPEB>\n" +
        "\t\t<cim:FossilSteamSupply.controlPED>" + controlPED + "</cim:FossilSteamSupply.controlPED>\n" +
        "\t\t<cim:FossilSteamSupply.controlTC>" + controlTC + "</cim:FossilSteamSupply.controlTC>\n" +
        "\t\t<cim:FossilSteamSupply.feedWaterIG>" + feedWaterIG + "</cim:FossilSteamSupply.feedWaterIG>\n" +
        "\t\t<cim:FossilSteamSupply.feedWaterPG>" + feedWaterPG + "</cim:FossilSteamSupply.feedWaterPG>\n" +
        "\t\t<cim:FossilSteamSupply.feedWaterTC>" + feedWaterTC + "</cim:FossilSteamSupply.feedWaterTC>\n" +
        "\t\t<cim:FossilSteamSupply.fuelDemandLimit>" + fuelDemandLimit + "</cim:FossilSteamSupply.fuelDemandLimit>\n" +
        "\t\t<cim:FossilSteamSupply.fuelSupplyDelay>" + fuelSupplyDelay + "</cim:FossilSteamSupply.fuelSupplyDelay>\n" +
        "\t\t<cim:FossilSteamSupply.fuelSupplyTC>" + fuelSupplyTC + "</cim:FossilSteamSupply.fuelSupplyTC>\n" +
        "\t\t<cim:FossilSteamSupply.maxErrorRateP>" + maxErrorRateP + "</cim:FossilSteamSupply.maxErrorRateP>\n" +
        "\t\t<cim:FossilSteamSupply.mechPowerSensorLag>" + mechPowerSensorLag + "</cim:FossilSteamSupply.mechPowerSensorLag>\n" +
        "\t\t<cim:FossilSteamSupply.minErrorRateP>" + minErrorRateP + "</cim:FossilSteamSupply.minErrorRateP>\n" +
        "\t\t<cim:FossilSteamSupply.pressureCtrlDG>" + pressureCtrlDG + "</cim:FossilSteamSupply.pressureCtrlDG>\n" +
        "\t\t<cim:FossilSteamSupply.pressureCtrlIG>" + pressureCtrlIG + "</cim:FossilSteamSupply.pressureCtrlIG>\n" +
        "\t\t<cim:FossilSteamSupply.pressureCtrlPG>" + pressureCtrlPG + "</cim:FossilSteamSupply.pressureCtrlPG>\n" +
        "\t\t<cim:FossilSteamSupply.pressureFeedback>" + pressureFeedback + "</cim:FossilSteamSupply.pressureFeedback>\n" +
        "\t\t<cim:FossilSteamSupply.superHeater1Capacity>" + superHeater1Capacity + "</cim:FossilSteamSupply.superHeater1Capacity>\n" +
        "\t\t<cim:FossilSteamSupply.superHeater2Capacity>" + superHeater2Capacity + "</cim:FossilSteamSupply.superHeater2Capacity>\n" +
        "\t\t<cim:FossilSteamSupply.superHeaterPipePD>" + superHeaterPipePD + "</cim:FossilSteamSupply.superHeaterPipePD>\n" +
        "\t\t<cim:FossilSteamSupply.throttlePressureSP>" + throttlePressureSP + "</cim:FossilSteamSupply.throttlePressureSP>\n"
    }
    override def export: String =
    {
        "\t<cim:FossilSteamSupply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FossilSteamSupply>"
    }
}

object FossilSteamSupply
extends
    Parseable[FossilSteamSupply]
{
    val auxPowerVersusFrequency = parse_element (element ("""FossilSteamSupply.auxPowerVersusFrequency"""))
    val auxPowerVersusVoltage = parse_element (element ("""FossilSteamSupply.auxPowerVersusVoltage"""))
    val boilerControlMode = parse_attribute (attribute ("""FossilSteamSupply.boilerControlMode"""))
    val controlErrorBiasP = parse_element (element ("""FossilSteamSupply.controlErrorBiasP"""))
    val controlIC = parse_element (element ("""FossilSteamSupply.controlIC"""))
    val controlPC = parse_element (element ("""FossilSteamSupply.controlPC"""))
    val controlPEB = parse_element (element ("""FossilSteamSupply.controlPEB"""))
    val controlPED = parse_element (element ("""FossilSteamSupply.controlPED"""))
    val controlTC = parse_element (element ("""FossilSteamSupply.controlTC"""))
    val feedWaterIG = parse_element (element ("""FossilSteamSupply.feedWaterIG"""))
    val feedWaterPG = parse_element (element ("""FossilSteamSupply.feedWaterPG"""))
    val feedWaterTC = parse_element (element ("""FossilSteamSupply.feedWaterTC"""))
    val fuelDemandLimit = parse_element (element ("""FossilSteamSupply.fuelDemandLimit"""))
    val fuelSupplyDelay = parse_element (element ("""FossilSteamSupply.fuelSupplyDelay"""))
    val fuelSupplyTC = parse_element (element ("""FossilSteamSupply.fuelSupplyTC"""))
    val maxErrorRateP = parse_element (element ("""FossilSteamSupply.maxErrorRateP"""))
    val mechPowerSensorLag = parse_element (element ("""FossilSteamSupply.mechPowerSensorLag"""))
    val minErrorRateP = parse_element (element ("""FossilSteamSupply.minErrorRateP"""))
    val pressureCtrlDG = parse_element (element ("""FossilSteamSupply.pressureCtrlDG"""))
    val pressureCtrlIG = parse_element (element ("""FossilSteamSupply.pressureCtrlIG"""))
    val pressureCtrlPG = parse_element (element ("""FossilSteamSupply.pressureCtrlPG"""))
    val pressureFeedback = parse_element (element ("""FossilSteamSupply.pressureFeedback"""))
    val superHeater1Capacity = parse_element (element ("""FossilSteamSupply.superHeater1Capacity"""))
    val superHeater2Capacity = parse_element (element ("""FossilSteamSupply.superHeater2Capacity"""))
    val superHeaterPipePD = parse_element (element ("""FossilSteamSupply.superHeaterPipePD"""))
    val throttlePressureSP = parse_element (element ("""FossilSteamSupply.throttlePressureSP"""))
    def parse (context: Context): FossilSteamSupply =
    {
        FossilSteamSupply(
            SteamSupply.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param steamSupplyRating2 The steam supply rating in kilopounds per hour, if dual pressure boiler.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class HeatRecoveryBoiler
(
    override val sup: FossilSteamSupply,
    steamSupplyRating2: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[HeatRecoveryBoiler] }
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
        "\t\t<cim:HeatRecoveryBoiler.steamSupplyRating2>" + steamSupplyRating2 + "</cim:HeatRecoveryBoiler.steamSupplyRating2>\n"
    }
    override def export: String =
    {
        "\t<cim:HeatRecoveryBoiler rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HeatRecoveryBoiler>"
    }
}

object HeatRecoveryBoiler
extends
    Parseable[HeatRecoveryBoiler]
{
    val steamSupplyRating2 = parse_element (element ("""HeatRecoveryBoiler.steamSupplyRating2"""))
    def parse (context: Context): HeatRecoveryBoiler =
    {
        HeatRecoveryBoiler(
            FossilSteamSupply.parse (context),
            toDouble (steamSupplyRating2 (context), context)
        )
    }
}

/**
 * A water driven prime mover.
 *
 * Typical turbine types are: Francis, Kaplan, and Pelton.
 *
 * @param sup [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
 * @param gateRateLimit Gate rate limit.
 * @param gateUpperLimit Gate upper limit.
 * @param maxHeadMaxP Maximum efficiency active power at maximum head conditions.
 * @param minHeadMaxP Maximum efficiency active power at minimum head conditions.
 * @param speedRating Rated speed in number of revolutions.
 * @param speedRegulation Speed regulation.
 * @param transientDroopTime Transient droop time constant.
 * @param transientRegulation Transient regulation.
 * @param turbineRating Rated turbine active power.
 * @param turbineType Type of turbine.
 * @param waterStartingTime Water starting time.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class HydroTurbine
(
    override val sup: PrimeMover,
    gateRateLimit: Double,
    gateUpperLimit: Double,
    maxHeadMaxP: Double,
    minHeadMaxP: Double,
    speedRating: Double,
    speedRegulation: Double,
    transientDroopTime: Double,
    transientRegulation: Double,
    turbineRating: Double,
    turbineType: String,
    waterStartingTime: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { clone ().asInstanceOf[HydroTurbine] }
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
        "\t\t<cim:HydroTurbine.gateRateLimit>" + gateRateLimit + "</cim:HydroTurbine.gateRateLimit>\n" +
        "\t\t<cim:HydroTurbine.gateUpperLimit>" + gateUpperLimit + "</cim:HydroTurbine.gateUpperLimit>\n" +
        "\t\t<cim:HydroTurbine.maxHeadMaxP>" + maxHeadMaxP + "</cim:HydroTurbine.maxHeadMaxP>\n" +
        "\t\t<cim:HydroTurbine.minHeadMaxP>" + minHeadMaxP + "</cim:HydroTurbine.minHeadMaxP>\n" +
        "\t\t<cim:HydroTurbine.speedRating>" + speedRating + "</cim:HydroTurbine.speedRating>\n" +
        "\t\t<cim:HydroTurbine.speedRegulation>" + speedRegulation + "</cim:HydroTurbine.speedRegulation>\n" +
        "\t\t<cim:HydroTurbine.transientDroopTime>" + transientDroopTime + "</cim:HydroTurbine.transientDroopTime>\n" +
        "\t\t<cim:HydroTurbine.transientRegulation>" + transientRegulation + "</cim:HydroTurbine.transientRegulation>\n" +
        "\t\t<cim:HydroTurbine.turbineRating>" + turbineRating + "</cim:HydroTurbine.turbineRating>\n" +
        (if (null != turbineType) "\t\t<cim:HydroTurbine.turbineType rdf:resource=\"#" + turbineType + "\"/>\n" else "") +
        "\t\t<cim:HydroTurbine.waterStartingTime>" + waterStartingTime + "</cim:HydroTurbine.waterStartingTime>\n"
    }
    override def export: String =
    {
        "\t<cim:HydroTurbine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:HydroTurbine>"
    }
}

object HydroTurbine
extends
    Parseable[HydroTurbine]
{
    val gateRateLimit = parse_element (element ("""HydroTurbine.gateRateLimit"""))
    val gateUpperLimit = parse_element (element ("""HydroTurbine.gateUpperLimit"""))
    val maxHeadMaxP = parse_element (element ("""HydroTurbine.maxHeadMaxP"""))
    val minHeadMaxP = parse_element (element ("""HydroTurbine.minHeadMaxP"""))
    val speedRating = parse_element (element ("""HydroTurbine.speedRating"""))
    val speedRegulation = parse_element (element ("""HydroTurbine.speedRegulation"""))
    val transientDroopTime = parse_element (element ("""HydroTurbine.transientDroopTime"""))
    val transientRegulation = parse_element (element ("""HydroTurbine.transientRegulation"""))
    val turbineRating = parse_element (element ("""HydroTurbine.turbineRating"""))
    val turbineType = parse_attribute (attribute ("""HydroTurbine.turbineType"""))
    val waterStartingTime = parse_element (element ("""HydroTurbine.waterStartingTime"""))
    def parse (context: Context): HydroTurbine =
    {
        HydroTurbine(
            PrimeMover.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
 * @param coldLegFBLagTC Cold leg feedback lag time constant.
 * @param coldLegFBLeadTC1 Cold leg feedback lead time constant.
 * @param coldLegFBLeadTC2 Cold leg feedback lead time constant.
 * @param coldLegFG1 Cold leg feedback gain 1.
 * @param coldLegFG2 Cold leg feedback gain 2.
 * @param coldLegLagTC Cold leg lag time constant.
 * @param coreHTLagTC1 Core heat transfer lag time constant.
 * @param coreHTLagTC2 Core heat transfer lag time constant.
 * @param coreNeutronicsEffTC Core neutronics effective time constant.
 * @param coreNeutronicsHT Core neutronics and heat transfer.
 * @param feedbackFactor Feedback factor.
 * @param hotLegLagTC Hot leg lag time constant.
 * @param hotLegSteamGain Hot leg steam gain.
 * @param hotLegToColdLegGain Hot leg to cold leg gain.
 * @param pressureCG Pressure control gain.
 * @param steamFlowFG Steam flow feedback gain.
 * @param steamPressureDropLagTC Steam pressure drop lag time constant.
 * @param steamPressureFG Steam pressure feedback gain.
 * @param throttlePressureFactor Throttle pressure factor.
 * @param throttlePressureSP Throttle pressure setpoint.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class PWRSteamSupply
(
    override val sup: SteamSupply,
    coldLegFBLagTC: Double,
    coldLegFBLeadTC1: Double,
    coldLegFBLeadTC2: Double,
    coldLegFG1: Double,
    coldLegFG2: Double,
    coldLegLagTC: Double,
    coreHTLagTC1: Double,
    coreHTLagTC2: Double,
    coreNeutronicsEffTC: Double,
    coreNeutronicsHT: Double,
    feedbackFactor: Double,
    hotLegLagTC: Double,
    hotLegSteamGain: Double,
    hotLegToColdLegGain: Double,
    pressureCG: Double,
    steamFlowFG: Double,
    steamPressureDropLagTC: Double,
    steamPressureFG: Double,
    throttlePressureFactor: Double,
    throttlePressureSP: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SteamSupply: SteamSupply = sup.asInstanceOf[SteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[PWRSteamSupply] }
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
        "\t\t<cim:PWRSteamSupply.coldLegFBLagTC>" + coldLegFBLagTC + "</cim:PWRSteamSupply.coldLegFBLagTC>\n" +
        "\t\t<cim:PWRSteamSupply.coldLegFBLeadTC1>" + coldLegFBLeadTC1 + "</cim:PWRSteamSupply.coldLegFBLeadTC1>\n" +
        "\t\t<cim:PWRSteamSupply.coldLegFBLeadTC2>" + coldLegFBLeadTC2 + "</cim:PWRSteamSupply.coldLegFBLeadTC2>\n" +
        "\t\t<cim:PWRSteamSupply.coldLegFG1>" + coldLegFG1 + "</cim:PWRSteamSupply.coldLegFG1>\n" +
        "\t\t<cim:PWRSteamSupply.coldLegFG2>" + coldLegFG2 + "</cim:PWRSteamSupply.coldLegFG2>\n" +
        "\t\t<cim:PWRSteamSupply.coldLegLagTC>" + coldLegLagTC + "</cim:PWRSteamSupply.coldLegLagTC>\n" +
        "\t\t<cim:PWRSteamSupply.coreHTLagTC1>" + coreHTLagTC1 + "</cim:PWRSteamSupply.coreHTLagTC1>\n" +
        "\t\t<cim:PWRSteamSupply.coreHTLagTC2>" + coreHTLagTC2 + "</cim:PWRSteamSupply.coreHTLagTC2>\n" +
        "\t\t<cim:PWRSteamSupply.coreNeutronicsEffTC>" + coreNeutronicsEffTC + "</cim:PWRSteamSupply.coreNeutronicsEffTC>\n" +
        "\t\t<cim:PWRSteamSupply.coreNeutronicsHT>" + coreNeutronicsHT + "</cim:PWRSteamSupply.coreNeutronicsHT>\n" +
        "\t\t<cim:PWRSteamSupply.feedbackFactor>" + feedbackFactor + "</cim:PWRSteamSupply.feedbackFactor>\n" +
        "\t\t<cim:PWRSteamSupply.hotLegLagTC>" + hotLegLagTC + "</cim:PWRSteamSupply.hotLegLagTC>\n" +
        "\t\t<cim:PWRSteamSupply.hotLegSteamGain>" + hotLegSteamGain + "</cim:PWRSteamSupply.hotLegSteamGain>\n" +
        "\t\t<cim:PWRSteamSupply.hotLegToColdLegGain>" + hotLegToColdLegGain + "</cim:PWRSteamSupply.hotLegToColdLegGain>\n" +
        "\t\t<cim:PWRSteamSupply.pressureCG>" + pressureCG + "</cim:PWRSteamSupply.pressureCG>\n" +
        "\t\t<cim:PWRSteamSupply.steamFlowFG>" + steamFlowFG + "</cim:PWRSteamSupply.steamFlowFG>\n" +
        "\t\t<cim:PWRSteamSupply.steamPressureDropLagTC>" + steamPressureDropLagTC + "</cim:PWRSteamSupply.steamPressureDropLagTC>\n" +
        "\t\t<cim:PWRSteamSupply.steamPressureFG>" + steamPressureFG + "</cim:PWRSteamSupply.steamPressureFG>\n" +
        "\t\t<cim:PWRSteamSupply.throttlePressureFactor>" + throttlePressureFactor + "</cim:PWRSteamSupply.throttlePressureFactor>\n" +
        "\t\t<cim:PWRSteamSupply.throttlePressureSP>" + throttlePressureSP + "</cim:PWRSteamSupply.throttlePressureSP>\n"
    }
    override def export: String =
    {
        "\t<cim:PWRSteamSupply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PWRSteamSupply>"
    }
}

object PWRSteamSupply
extends
    Parseable[PWRSteamSupply]
{
    val coldLegFBLagTC = parse_element (element ("""PWRSteamSupply.coldLegFBLagTC"""))
    val coldLegFBLeadTC1 = parse_element (element ("""PWRSteamSupply.coldLegFBLeadTC1"""))
    val coldLegFBLeadTC2 = parse_element (element ("""PWRSteamSupply.coldLegFBLeadTC2"""))
    val coldLegFG1 = parse_element (element ("""PWRSteamSupply.coldLegFG1"""))
    val coldLegFG2 = parse_element (element ("""PWRSteamSupply.coldLegFG2"""))
    val coldLegLagTC = parse_element (element ("""PWRSteamSupply.coldLegLagTC"""))
    val coreHTLagTC1 = parse_element (element ("""PWRSteamSupply.coreHTLagTC1"""))
    val coreHTLagTC2 = parse_element (element ("""PWRSteamSupply.coreHTLagTC2"""))
    val coreNeutronicsEffTC = parse_element (element ("""PWRSteamSupply.coreNeutronicsEffTC"""))
    val coreNeutronicsHT = parse_element (element ("""PWRSteamSupply.coreNeutronicsHT"""))
    val feedbackFactor = parse_element (element ("""PWRSteamSupply.feedbackFactor"""))
    val hotLegLagTC = parse_element (element ("""PWRSteamSupply.hotLegLagTC"""))
    val hotLegSteamGain = parse_element (element ("""PWRSteamSupply.hotLegSteamGain"""))
    val hotLegToColdLegGain = parse_element (element ("""PWRSteamSupply.hotLegToColdLegGain"""))
    val pressureCG = parse_element (element ("""PWRSteamSupply.pressureCG"""))
    val steamFlowFG = parse_element (element ("""PWRSteamSupply.steamFlowFG"""))
    val steamPressureDropLagTC = parse_element (element ("""PWRSteamSupply.steamPressureDropLagTC"""))
    val steamPressureFG = parse_element (element ("""PWRSteamSupply.steamPressureFG"""))
    val throttlePressureFactor = parse_element (element ("""PWRSteamSupply.throttlePressureFactor"""))
    val throttlePressureSP = parse_element (element ("""PWRSteamSupply.throttlePressureSP"""))
    def parse (context: Context): PWRSteamSupply =
    {
        PWRSteamSupply(
            SteamSupply.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param primeMoverRating Rating of prime mover.
 * @param SynchronousMachines Synchronous machines this Prime mover drives.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class PrimeMover
(
    override val sup: PowerSystemResource,
    primeMoverRating: Double,
    SynchronousMachines: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[PrimeMover] }
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
        "\t\t<cim:PrimeMover.primeMoverRating>" + primeMoverRating + "</cim:PrimeMover.primeMoverRating>\n" +
        (if (null != SynchronousMachines) SynchronousMachines.map (x => "\t\t<cim:PrimeMover.SynchronousMachines rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:PrimeMover rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PrimeMover>"
    }
}

object PrimeMover
extends
    Parseable[PrimeMover]
{
    val primeMoverRating = parse_element (element ("""PrimeMover.primeMoverRating"""))
    val SynchronousMachines = parse_attributes (attribute ("""PrimeMover.SynchronousMachines"""))
    def parse (context: Context): PrimeMover =
    {
        PrimeMover(
            PowerSystemResource.parse (context),
            toDouble (primeMoverRating (context), context),
            SynchronousMachines (context)
        )
    }
}

/**
 * Steam supply for steam turbine.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param steamSupplyRating Rating of steam supply.
 * @param SteamTurbines Steam turbines may have steam supplied by a steam supply.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class SteamSupply
(
    override val sup: PowerSystemResource,
    steamSupplyRating: Double,
    SteamTurbines: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[SteamSupply] }
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
        "\t\t<cim:SteamSupply.steamSupplyRating>" + steamSupplyRating + "</cim:SteamSupply.steamSupplyRating>\n" +
        (if (null != SteamTurbines) SteamTurbines.map (x => "\t\t<cim:SteamSupply.SteamTurbines rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:SteamSupply rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SteamSupply>"
    }
}

object SteamSupply
extends
    Parseable[SteamSupply]
{
    val steamSupplyRating = parse_element (element ("""SteamSupply.steamSupplyRating"""))
    val SteamTurbines = parse_attributes (attribute ("""SteamSupply.SteamTurbines"""))
    def parse (context: Context): SteamSupply =
    {
        SteamSupply(
            PowerSystemResource.parse (context),
            toDouble (steamSupplyRating (context), context),
            SteamTurbines (context)
        )
    }
}

/**
 * Steam turbine.
 *
 * @param sup [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
 * @param crossoverTC Crossover time constant.
 * @param reheater1TC First reheater time constant.
 * @param reheater2TC Second reheater time constant.
 * @param shaft1PowerHP Fraction of power from shaft 1 high pressure turbine output.
 * @param shaft1PowerIP Fraction of power from shaft 1 intermediate pressure turbine output.
 * @param shaft1PowerLP1 Fraction of power from shaft 1 first low pressure turbine output.
 * @param shaft1PowerLP2 Fraction of power from shaft 1 second low pressure turbine output.
 * @param shaft2PowerHP Fraction of power from shaft 2 high pressure turbine output.
 * @param shaft2PowerIP Fraction of power from shaft 2 intermediate pressure turbine output.
 * @param shaft2PowerLP1 Fraction of power from shaft 2 first low pressure turbine output.
 * @param shaft2PowerLP2 Fraction of power from shaft 2 second low pressure turbine output.
 * @param steamChestTC Steam chest time constant.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class SteamTurbine
(
    override val sup: PrimeMover,
    crossoverTC: Double,
    reheater1TC: Double,
    reheater2TC: Double,
    shaft1PowerHP: Double,
    shaft1PowerIP: Double,
    shaft1PowerLP1: Double,
    shaft1PowerLP2: Double,
    shaft2PowerHP: Double,
    shaft2PowerIP: Double,
    shaft2PowerLP1: Double,
    shaft2PowerLP2: Double,
    steamChestTC: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PrimeMover: PrimeMover = sup.asInstanceOf[PrimeMover]
    override def copy (): Row = { clone ().asInstanceOf[SteamTurbine] }
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
        "\t\t<cim:SteamTurbine.crossoverTC>" + crossoverTC + "</cim:SteamTurbine.crossoverTC>\n" +
        "\t\t<cim:SteamTurbine.reheater1TC>" + reheater1TC + "</cim:SteamTurbine.reheater1TC>\n" +
        "\t\t<cim:SteamTurbine.reheater2TC>" + reheater2TC + "</cim:SteamTurbine.reheater2TC>\n" +
        "\t\t<cim:SteamTurbine.shaft1PowerHP>" + shaft1PowerHP + "</cim:SteamTurbine.shaft1PowerHP>\n" +
        "\t\t<cim:SteamTurbine.shaft1PowerIP>" + shaft1PowerIP + "</cim:SteamTurbine.shaft1PowerIP>\n" +
        "\t\t<cim:SteamTurbine.shaft1PowerLP1>" + shaft1PowerLP1 + "</cim:SteamTurbine.shaft1PowerLP1>\n" +
        "\t\t<cim:SteamTurbine.shaft1PowerLP2>" + shaft1PowerLP2 + "</cim:SteamTurbine.shaft1PowerLP2>\n" +
        "\t\t<cim:SteamTurbine.shaft2PowerHP>" + shaft2PowerHP + "</cim:SteamTurbine.shaft2PowerHP>\n" +
        "\t\t<cim:SteamTurbine.shaft2PowerIP>" + shaft2PowerIP + "</cim:SteamTurbine.shaft2PowerIP>\n" +
        "\t\t<cim:SteamTurbine.shaft2PowerLP1>" + shaft2PowerLP1 + "</cim:SteamTurbine.shaft2PowerLP1>\n" +
        "\t\t<cim:SteamTurbine.shaft2PowerLP2>" + shaft2PowerLP2 + "</cim:SteamTurbine.shaft2PowerLP2>\n" +
        "\t\t<cim:SteamTurbine.steamChestTC>" + steamChestTC + "</cim:SteamTurbine.steamChestTC>\n"
    }
    override def export: String =
    {
        "\t<cim:SteamTurbine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SteamTurbine>"
    }
}

object SteamTurbine
extends
    Parseable[SteamTurbine]
{
    val crossoverTC = parse_element (element ("""SteamTurbine.crossoverTC"""))
    val reheater1TC = parse_element (element ("""SteamTurbine.reheater1TC"""))
    val reheater2TC = parse_element (element ("""SteamTurbine.reheater2TC"""))
    val shaft1PowerHP = parse_element (element ("""SteamTurbine.shaft1PowerHP"""))
    val shaft1PowerIP = parse_element (element ("""SteamTurbine.shaft1PowerIP"""))
    val shaft1PowerLP1 = parse_element (element ("""SteamTurbine.shaft1PowerLP1"""))
    val shaft1PowerLP2 = parse_element (element ("""SteamTurbine.shaft1PowerLP2"""))
    val shaft2PowerHP = parse_element (element ("""SteamTurbine.shaft2PowerHP"""))
    val shaft2PowerIP = parse_element (element ("""SteamTurbine.shaft2PowerIP"""))
    val shaft2PowerLP1 = parse_element (element ("""SteamTurbine.shaft2PowerLP1"""))
    val shaft2PowerLP2 = parse_element (element ("""SteamTurbine.shaft2PowerLP2"""))
    val steamChestTC = parse_element (element ("""SteamTurbine.steamChestTC"""))
    def parse (context: Context): SteamTurbine =
    {
        SteamTurbine(
            PrimeMover.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class Subcritical
(
    override val sup: FossilSteamSupply
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
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[Subcritical] }
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
        "\t<cim:Subcritical rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Subcritical>"
    }
}

object Subcritical
extends
    Parseable[Subcritical]
{
    def parse (context: Context): Subcritical =
    {
        Subcritical(
            FossilSteamSupply.parse (context)
        )
    }
}

/**
 * Once-through supercritical boiler.
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
case class Supercritical
(
    override val sup: FossilSteamSupply
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
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[Supercritical] }
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
        "\t<cim:Supercritical rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Supercritical>"
    }
}

object Supercritical
extends
    Parseable[Supercritical]
{
    def parse (context: Context): Supercritical =
    {
        Supercritical(
            FossilSteamSupply.parse (context)
        )
    }
}

private[ninecode] object _GenerationTrainingSimulation
{
    def register: List[ClassInfo] =
    {
        List (
            BWRSteamSupply.register,
            CTTempActivePowerCurve.register,
            CombustionTurbine.register,
            DrumBoiler.register,
            FossilSteamSupply.register,
            HeatRecoveryBoiler.register,
            HydroTurbine.register,
            PWRSteamSupply.register,
            PrimeMover.register,
            SteamSupply.register,
            SteamTurbine.register,
            Subcritical.register,
            Supercritical.register
        )
    }
}