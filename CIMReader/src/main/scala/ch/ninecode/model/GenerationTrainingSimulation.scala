package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

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
 * @param rfAux1 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux2 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux3 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux4 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux5 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux6 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux7 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rfAux8 Coefficient for modelling the effect of off-nominal frequency and voltage on recirculation and core flow, which affects the BWR power output.
 * @param rodPattern Rod pattern.
 * @param rodPatternConstant Constant associated with rod pattern.
 * @param upperLimit Initial upper limit.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class BWRSteamSupply
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BWRSteamSupply.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BWRSteamSupply.fields (position), value)
        emitelem (0, highPowerLimit)
        emitelem (1, inCoreThermalTC)
        emitelem (2, integralGain)
        emitelem (3, lowPowerLimit)
        emitelem (4, lowerLimit)
        emitelem (5, pressureLimit)
        emitelem (6, pressureSetpointGA)
        emitelem (7, pressureSetpointTC1)
        emitelem (8, pressureSetpointTC2)
        emitelem (9, proportionalGain)
        emitelem (10, rfAux1)
        emitelem (11, rfAux2)
        emitelem (12, rfAux3)
        emitelem (13, rfAux4)
        emitelem (14, rfAux5)
        emitelem (15, rfAux6)
        emitelem (16, rfAux7)
        emitelem (17, rfAux8)
        emitelem (18, rodPattern)
        emitelem (19, rodPatternConstant)
        emitelem (20, upperLimit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BWRSteamSupply rdf:ID=\"%s\">\n%s\t</cim:BWRSteamSupply>".format (id, export_fields)
    }
}

object BWRSteamSupply
extends
    Parseable[BWRSteamSupply]
{
    override val fields: Array[String] = Array[String] (
        "highPowerLimit",
        "inCoreThermalTC",
        "integralGain",
        "lowPowerLimit",
        "lowerLimit",
        "pressureLimit",
        "pressureSetpointGA",
        "pressureSetpointTC1",
        "pressureSetpointTC2",
        "proportionalGain",
        "rfAux1",
        "rfAux2",
        "rfAux3",
        "rfAux4",
        "rfAux5",
        "rfAux6",
        "rfAux7",
        "rfAux8",
        "rodPattern",
        "rodPatternConstant",
        "upperLimit"
    )
    val highPowerLimit: Fielder = parse_element (element (cls, fields(0)))
    val inCoreThermalTC: Fielder = parse_element (element (cls, fields(1)))
    val integralGain: Fielder = parse_element (element (cls, fields(2)))
    val lowPowerLimit: Fielder = parse_element (element (cls, fields(3)))
    val lowerLimit: Fielder = parse_element (element (cls, fields(4)))
    val pressureLimit: Fielder = parse_element (element (cls, fields(5)))
    val pressureSetpointGA: Fielder = parse_element (element (cls, fields(6)))
    val pressureSetpointTC1: Fielder = parse_element (element (cls, fields(7)))
    val pressureSetpointTC2: Fielder = parse_element (element (cls, fields(8)))
    val proportionalGain: Fielder = parse_element (element (cls, fields(9)))
    val rfAux1: Fielder = parse_element (element (cls, fields(10)))
    val rfAux2: Fielder = parse_element (element (cls, fields(11)))
    val rfAux3: Fielder = parse_element (element (cls, fields(12)))
    val rfAux4: Fielder = parse_element (element (cls, fields(13)))
    val rfAux5: Fielder = parse_element (element (cls, fields(14)))
    val rfAux6: Fielder = parse_element (element (cls, fields(15)))
    val rfAux7: Fielder = parse_element (element (cls, fields(16)))
    val rfAux8: Fielder = parse_element (element (cls, fields(17)))
    val rodPattern: Fielder = parse_element (element (cls, fields(18)))
    val rodPatternConstant: Fielder = parse_element (element (cls, fields(19)))
    val upperLimit: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): BWRSteamSupply =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BWRSteamSupply (
            SteamSupply.parse (context),
            toDouble (mask (highPowerLimit (), 0)),
            toDouble (mask (inCoreThermalTC (), 1)),
            toDouble (mask (integralGain (), 2)),
            toDouble (mask (lowPowerLimit (), 3)),
            toDouble (mask (lowerLimit (), 4)),
            toDouble (mask (pressureLimit (), 5)),
            toDouble (mask (pressureSetpointGA (), 6)),
            toDouble (mask (pressureSetpointTC1 (), 7)),
            toDouble (mask (pressureSetpointTC2 (), 8)),
            toDouble (mask (proportionalGain (), 9)),
            toDouble (mask (rfAux1 (), 10)),
            toDouble (mask (rfAux2 (), 11)),
            toDouble (mask (rfAux3 (), 12)),
            toDouble (mask (rfAux4 (), 13)),
            toDouble (mask (rfAux5 (), 14)),
            toDouble (mask (rfAux6 (), 15)),
            toDouble (mask (rfAux7 (), 16)),
            toDouble (mask (rfAux8 (), 17)),
            toDouble (mask (rodPattern (), 18)),
            toDouble (mask (rodPatternConstant (), 19)),
            toDouble (mask (upperLimit (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Relationship between the combustion turbine's power output rating in gross active power (X-axis) and the ambient air temperature (Y-axis).
 *
 * @param sup [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param CombustionTurbine [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A combustion turbine may have an active power versus ambient temperature relationship.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class CTTempActivePowerCurve
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CTTempActivePowerCurve.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CTTempActivePowerCurve.fields (position), value)
        emitattr (0, CombustionTurbine)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CTTempActivePowerCurve rdf:ID=\"%s\">\n%s\t</cim:CTTempActivePowerCurve>".format (id, export_fields)
    }
}

object CTTempActivePowerCurve
extends
    Parseable[CTTempActivePowerCurve]
{
    override val fields: Array[String] = Array[String] (
        "CombustionTurbine"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombustionTurbine", "CombustionTurbine", "1", "0..1")
    )
    val CombustionTurbine: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CTTempActivePowerCurve =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CTTempActivePowerCurve (
            Curve.parse (context),
            mask (CombustionTurbine (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A prime mover that is typically fuelled by gas or light oil.
 *
 * @param sup [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
 * @param ambientTemp Default ambient temperature to be used in modelling applications.
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
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class CombustionTurbine
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CombustionTurbine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CombustionTurbine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CombustionTurbine.fields (position), value)
        emitelem (0, ambientTemp)
        emitelem (1, auxPowerVersusFrequency)
        emitelem (2, auxPowerVersusVoltage)
        emitelem (3, capabilityVersusFrequency)
        emitelem (4, heatRecoveryFlag)
        emitelem (5, powerVariationByTemp)
        emitelem (6, referenceTemp)
        emitelem (7, timeConstant)
        emitattr (8, AirCompressor)
        emitattr (9, CTTempActivePowerCurve)
        emitattr (10, HeatRecoveryBoiler)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CombustionTurbine rdf:ID=\"%s\">\n%s\t</cim:CombustionTurbine>".format (id, export_fields)
    }
}

object CombustionTurbine
extends
    Parseable[CombustionTurbine]
{
    override val fields: Array[String] = Array[String] (
        "ambientTemp",
        "auxPowerVersusFrequency",
        "auxPowerVersusVoltage",
        "capabilityVersusFrequency",
        "heatRecoveryFlag",
        "powerVariationByTemp",
        "referenceTemp",
        "timeConstant",
        "AirCompressor",
        "CTTempActivePowerCurve",
        "HeatRecoveryBoiler"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AirCompressor", "AirCompressor", "0..1", "1"),
        Relationship ("CTTempActivePowerCurve", "CTTempActivePowerCurve", "0..1", "1"),
        Relationship ("HeatRecoveryBoiler", "HeatRecoveryBoiler", "0..1", "0..*")
    )
    val ambientTemp: Fielder = parse_element (element (cls, fields(0)))
    val auxPowerVersusFrequency: Fielder = parse_element (element (cls, fields(1)))
    val auxPowerVersusVoltage: Fielder = parse_element (element (cls, fields(2)))
    val capabilityVersusFrequency: Fielder = parse_element (element (cls, fields(3)))
    val heatRecoveryFlag: Fielder = parse_element (element (cls, fields(4)))
    val powerVariationByTemp: Fielder = parse_element (element (cls, fields(5)))
    val referenceTemp: Fielder = parse_element (element (cls, fields(6)))
    val timeConstant: Fielder = parse_element (element (cls, fields(7)))
    val AirCompressor: Fielder = parse_attribute (attribute (cls, fields(8)))
    val CTTempActivePowerCurve: Fielder = parse_attribute (attribute (cls, fields(9)))
    val HeatRecoveryBoiler: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): CombustionTurbine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CombustionTurbine (
            PrimeMover.parse (context),
            toDouble (mask (ambientTemp (), 0)),
            toDouble (mask (auxPowerVersusFrequency (), 1)),
            toDouble (mask (auxPowerVersusVoltage (), 2)),
            toDouble (mask (capabilityVersusFrequency (), 3)),
            toBoolean (mask (heatRecoveryFlag (), 4)),
            toDouble (mask (powerVariationByTemp (), 5)),
            toDouble (mask (referenceTemp (), 6)),
            toDouble (mask (timeConstant (), 7)),
            mask (AirCompressor (), 8),
            mask (CTTempActivePowerCurve (), 9),
            mask (HeatRecoveryBoiler (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Drum boiler.
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param drumBoilerRating Rating of drum boiler in steam units.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class DrumBoiler
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DrumBoiler.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DrumBoiler.fields (position), value)
        emitelem (0, drumBoilerRating)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DrumBoiler rdf:ID=\"%s\">\n%s\t</cim:DrumBoiler>".format (id, export_fields)
    }
}

object DrumBoiler
extends
    Parseable[DrumBoiler]
{
    override val fields: Array[String] = Array[String] (
        "drumBoilerRating"
    )
    val drumBoilerRating: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): DrumBoiler =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DrumBoiler (
            FossilSteamSupply.parse (context),
            toDouble (mask (drumBoilerRating (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Fossil fuelled boiler (e.g., coal, oil, gas).
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
 * @param feedWaterTC Feedwater time constant ratio.
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
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class FossilSteamSupply
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = FossilSteamSupply.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FossilSteamSupply.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FossilSteamSupply.fields (position), value)
        emitelem (0, auxPowerVersusFrequency)
        emitelem (1, auxPowerVersusVoltage)
        emitattr (2, boilerControlMode)
        emitelem (3, controlErrorBiasP)
        emitelem (4, controlIC)
        emitelem (5, controlPC)
        emitelem (6, controlPEB)
        emitelem (7, controlPED)
        emitelem (8, controlTC)
        emitelem (9, feedWaterIG)
        emitelem (10, feedWaterPG)
        emitelem (11, feedWaterTC)
        emitelem (12, fuelDemandLimit)
        emitelem (13, fuelSupplyDelay)
        emitelem (14, fuelSupplyTC)
        emitelem (15, maxErrorRateP)
        emitelem (16, mechPowerSensorLag)
        emitelem (17, minErrorRateP)
        emitelem (18, pressureCtrlDG)
        emitelem (19, pressureCtrlIG)
        emitelem (20, pressureCtrlPG)
        emitelem (21, pressureFeedback)
        emitelem (22, superHeater1Capacity)
        emitelem (23, superHeater2Capacity)
        emitelem (24, superHeaterPipePD)
        emitelem (25, throttlePressureSP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FossilSteamSupply rdf:ID=\"%s\">\n%s\t</cim:FossilSteamSupply>".format (id, export_fields)
    }
}

object FossilSteamSupply
extends
    Parseable[FossilSteamSupply]
{
    override val fields: Array[String] = Array[String] (
        "auxPowerVersusFrequency",
        "auxPowerVersusVoltage",
        "boilerControlMode",
        "controlErrorBiasP",
        "controlIC",
        "controlPC",
        "controlPEB",
        "controlPED",
        "controlTC",
        "feedWaterIG",
        "feedWaterPG",
        "feedWaterTC",
        "fuelDemandLimit",
        "fuelSupplyDelay",
        "fuelSupplyTC",
        "maxErrorRateP",
        "mechPowerSensorLag",
        "minErrorRateP",
        "pressureCtrlDG",
        "pressureCtrlIG",
        "pressureCtrlPG",
        "pressureFeedback",
        "superHeater1Capacity",
        "superHeater2Capacity",
        "superHeaterPipePD",
        "throttlePressureSP"
    )
    val auxPowerVersusFrequency: Fielder = parse_element (element (cls, fields(0)))
    val auxPowerVersusVoltage: Fielder = parse_element (element (cls, fields(1)))
    val boilerControlMode: Fielder = parse_attribute (attribute (cls, fields(2)))
    val controlErrorBiasP: Fielder = parse_element (element (cls, fields(3)))
    val controlIC: Fielder = parse_element (element (cls, fields(4)))
    val controlPC: Fielder = parse_element (element (cls, fields(5)))
    val controlPEB: Fielder = parse_element (element (cls, fields(6)))
    val controlPED: Fielder = parse_element (element (cls, fields(7)))
    val controlTC: Fielder = parse_element (element (cls, fields(8)))
    val feedWaterIG: Fielder = parse_element (element (cls, fields(9)))
    val feedWaterPG: Fielder = parse_element (element (cls, fields(10)))
    val feedWaterTC: Fielder = parse_element (element (cls, fields(11)))
    val fuelDemandLimit: Fielder = parse_element (element (cls, fields(12)))
    val fuelSupplyDelay: Fielder = parse_element (element (cls, fields(13)))
    val fuelSupplyTC: Fielder = parse_element (element (cls, fields(14)))
    val maxErrorRateP: Fielder = parse_element (element (cls, fields(15)))
    val mechPowerSensorLag: Fielder = parse_element (element (cls, fields(16)))
    val minErrorRateP: Fielder = parse_element (element (cls, fields(17)))
    val pressureCtrlDG: Fielder = parse_element (element (cls, fields(18)))
    val pressureCtrlIG: Fielder = parse_element (element (cls, fields(19)))
    val pressureCtrlPG: Fielder = parse_element (element (cls, fields(20)))
    val pressureFeedback: Fielder = parse_element (element (cls, fields(21)))
    val superHeater1Capacity: Fielder = parse_element (element (cls, fields(22)))
    val superHeater2Capacity: Fielder = parse_element (element (cls, fields(23)))
    val superHeaterPipePD: Fielder = parse_element (element (cls, fields(24)))
    val throttlePressureSP: Fielder = parse_element (element (cls, fields(25)))

    def parse (context: Context): FossilSteamSupply =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FossilSteamSupply (
            SteamSupply.parse (context),
            toDouble (mask (auxPowerVersusFrequency (), 0)),
            toDouble (mask (auxPowerVersusVoltage (), 1)),
            mask (boilerControlMode (), 2),
            toDouble (mask (controlErrorBiasP (), 3)),
            toDouble (mask (controlIC (), 4)),
            toDouble (mask (controlPC (), 5)),
            toDouble (mask (controlPEB (), 6)),
            toDouble (mask (controlPED (), 7)),
            toDouble (mask (controlTC (), 8)),
            toDouble (mask (feedWaterIG (), 9)),
            toDouble (mask (feedWaterPG (), 10)),
            toDouble (mask (feedWaterTC (), 11)),
            toDouble (mask (fuelDemandLimit (), 12)),
            toDouble (mask (fuelSupplyDelay (), 13)),
            toDouble (mask (fuelSupplyTC (), 14)),
            toDouble (mask (maxErrorRateP (), 15)),
            toDouble (mask (mechPowerSensorLag (), 16)),
            toDouble (mask (minErrorRateP (), 17)),
            toDouble (mask (pressureCtrlDG (), 18)),
            toDouble (mask (pressureCtrlIG (), 19)),
            toDouble (mask (pressureCtrlPG (), 20)),
            toInteger (mask (pressureFeedback (), 21)),
            toDouble (mask (superHeater1Capacity (), 22)),
            toDouble (mask (superHeater2Capacity (), 23)),
            toDouble (mask (superHeaterPipePD (), 24)),
            toDouble (mask (throttlePressureSP (), 25))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The heat recovery system associated with combustion turbines in order to produce steam for combined cycle plants.
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param steamSupplyRating2 The steam supply rating in kilopounds per hour, if dual pressure boiler.
 * @param CombustionTurbines [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A combustion turbine may have a heat recovery boiler for making steam.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class HeatRecoveryBoiler
(
    override val sup: FossilSteamSupply,
    steamSupplyRating2: Double,
    CombustionTurbines: List[String]
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
    def FossilSteamSupply: FossilSteamSupply = sup.asInstanceOf[FossilSteamSupply]
    override def copy (): Row = { clone ().asInstanceOf[HeatRecoveryBoiler] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HeatRecoveryBoiler.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HeatRecoveryBoiler.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (HeatRecoveryBoiler.fields (position), x))
        emitelem (0, steamSupplyRating2)
        emitattrs (1, CombustionTurbines)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HeatRecoveryBoiler rdf:ID=\"%s\">\n%s\t</cim:HeatRecoveryBoiler>".format (id, export_fields)
    }
}

object HeatRecoveryBoiler
extends
    Parseable[HeatRecoveryBoiler]
{
    override val fields: Array[String] = Array[String] (
        "steamSupplyRating2",
        "CombustionTurbines"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CombustionTurbines", "CombustionTurbine", "0..*", "0..1")
    )
    val steamSupplyRating2: Fielder = parse_element (element (cls, fields(0)))
    val CombustionTurbines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): HeatRecoveryBoiler =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HeatRecoveryBoiler (
            FossilSteamSupply.parse (context),
            toDouble (mask (steamSupplyRating2 (), 0)),
            masks (CombustionTurbines (), 1)
        )
        ret.bitfields = bitfields
        ret
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
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class HydroTurbine
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydroTurbine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (HydroTurbine.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydroTurbine.fields (position), value)
        emitelem (0, gateRateLimit)
        emitelem (1, gateUpperLimit)
        emitelem (2, maxHeadMaxP)
        emitelem (3, minHeadMaxP)
        emitelem (4, speedRating)
        emitelem (5, speedRegulation)
        emitelem (6, transientDroopTime)
        emitelem (7, transientRegulation)
        emitelem (8, turbineRating)
        emitattr (9, turbineType)
        emitelem (10, waterStartingTime)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydroTurbine rdf:ID=\"%s\">\n%s\t</cim:HydroTurbine>".format (id, export_fields)
    }
}

object HydroTurbine
extends
    Parseable[HydroTurbine]
{
    override val fields: Array[String] = Array[String] (
        "gateRateLimit",
        "gateUpperLimit",
        "maxHeadMaxP",
        "minHeadMaxP",
        "speedRating",
        "speedRegulation",
        "transientDroopTime",
        "transientRegulation",
        "turbineRating",
        "turbineType",
        "waterStartingTime"
    )
    val gateRateLimit: Fielder = parse_element (element (cls, fields(0)))
    val gateUpperLimit: Fielder = parse_element (element (cls, fields(1)))
    val maxHeadMaxP: Fielder = parse_element (element (cls, fields(2)))
    val minHeadMaxP: Fielder = parse_element (element (cls, fields(3)))
    val speedRating: Fielder = parse_element (element (cls, fields(4)))
    val speedRegulation: Fielder = parse_element (element (cls, fields(5)))
    val transientDroopTime: Fielder = parse_element (element (cls, fields(6)))
    val transientRegulation: Fielder = parse_element (element (cls, fields(7)))
    val turbineRating: Fielder = parse_element (element (cls, fields(8)))
    val turbineType: Fielder = parse_attribute (attribute (cls, fields(9)))
    val waterStartingTime: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): HydroTurbine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydroTurbine (
            PrimeMover.parse (context),
            toDouble (mask (gateRateLimit (), 0)),
            toDouble (mask (gateUpperLimit (), 1)),
            toDouble (mask (maxHeadMaxP (), 2)),
            toDouble (mask (minHeadMaxP (), 3)),
            toDouble (mask (speedRating (), 4)),
            toDouble (mask (speedRegulation (), 5)),
            toDouble (mask (transientDroopTime (), 6)),
            toDouble (mask (transientRegulation (), 7)),
            toDouble (mask (turbineRating (), 8)),
            mask (turbineType (), 9),
            toDouble (mask (waterStartingTime (), 10))
        )
        ret.bitfields = bitfields
        ret
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
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class PWRSteamSupply
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PWRSteamSupply.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PWRSteamSupply.fields (position), value)
        emitelem (0, coldLegFBLagTC)
        emitelem (1, coldLegFBLeadTC1)
        emitelem (2, coldLegFBLeadTC2)
        emitelem (3, coldLegFG1)
        emitelem (4, coldLegFG2)
        emitelem (5, coldLegLagTC)
        emitelem (6, coreHTLagTC1)
        emitelem (7, coreHTLagTC2)
        emitelem (8, coreNeutronicsEffTC)
        emitelem (9, coreNeutronicsHT)
        emitelem (10, feedbackFactor)
        emitelem (11, hotLegLagTC)
        emitelem (12, hotLegSteamGain)
        emitelem (13, hotLegToColdLegGain)
        emitelem (14, pressureCG)
        emitelem (15, steamFlowFG)
        emitelem (16, steamPressureDropLagTC)
        emitelem (17, steamPressureFG)
        emitelem (18, throttlePressureFactor)
        emitelem (19, throttlePressureSP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PWRSteamSupply rdf:ID=\"%s\">\n%s\t</cim:PWRSteamSupply>".format (id, export_fields)
    }
}

object PWRSteamSupply
extends
    Parseable[PWRSteamSupply]
{
    override val fields: Array[String] = Array[String] (
        "coldLegFBLagTC",
        "coldLegFBLeadTC1",
        "coldLegFBLeadTC2",
        "coldLegFG1",
        "coldLegFG2",
        "coldLegLagTC",
        "coreHTLagTC1",
        "coreHTLagTC2",
        "coreNeutronicsEffTC",
        "coreNeutronicsHT",
        "feedbackFactor",
        "hotLegLagTC",
        "hotLegSteamGain",
        "hotLegToColdLegGain",
        "pressureCG",
        "steamFlowFG",
        "steamPressureDropLagTC",
        "steamPressureFG",
        "throttlePressureFactor",
        "throttlePressureSP"
    )
    val coldLegFBLagTC: Fielder = parse_element (element (cls, fields(0)))
    val coldLegFBLeadTC1: Fielder = parse_element (element (cls, fields(1)))
    val coldLegFBLeadTC2: Fielder = parse_element (element (cls, fields(2)))
    val coldLegFG1: Fielder = parse_element (element (cls, fields(3)))
    val coldLegFG2: Fielder = parse_element (element (cls, fields(4)))
    val coldLegLagTC: Fielder = parse_element (element (cls, fields(5)))
    val coreHTLagTC1: Fielder = parse_element (element (cls, fields(6)))
    val coreHTLagTC2: Fielder = parse_element (element (cls, fields(7)))
    val coreNeutronicsEffTC: Fielder = parse_element (element (cls, fields(8)))
    val coreNeutronicsHT: Fielder = parse_element (element (cls, fields(9)))
    val feedbackFactor: Fielder = parse_element (element (cls, fields(10)))
    val hotLegLagTC: Fielder = parse_element (element (cls, fields(11)))
    val hotLegSteamGain: Fielder = parse_element (element (cls, fields(12)))
    val hotLegToColdLegGain: Fielder = parse_element (element (cls, fields(13)))
    val pressureCG: Fielder = parse_element (element (cls, fields(14)))
    val steamFlowFG: Fielder = parse_element (element (cls, fields(15)))
    val steamPressureDropLagTC: Fielder = parse_element (element (cls, fields(16)))
    val steamPressureFG: Fielder = parse_element (element (cls, fields(17)))
    val throttlePressureFactor: Fielder = parse_element (element (cls, fields(18)))
    val throttlePressureSP: Fielder = parse_element (element (cls, fields(19)))

    def parse (context: Context): PWRSteamSupply =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PWRSteamSupply (
            SteamSupply.parse (context),
            toDouble (mask (coldLegFBLagTC (), 0)),
            toDouble (mask (coldLegFBLeadTC1 (), 1)),
            toDouble (mask (coldLegFBLeadTC2 (), 2)),
            toDouble (mask (coldLegFG1 (), 3)),
            toDouble (mask (coldLegFG2 (), 4)),
            toDouble (mask (coldLegLagTC (), 5)),
            toDouble (mask (coreHTLagTC1 (), 6)),
            toDouble (mask (coreHTLagTC2 (), 7)),
            toDouble (mask (coreNeutronicsEffTC (), 8)),
            toDouble (mask (coreNeutronicsHT (), 9)),
            toDouble (mask (feedbackFactor (), 10)),
            toDouble (mask (hotLegLagTC (), 11)),
            toDouble (mask (hotLegSteamGain (), 12)),
            toDouble (mask (hotLegToColdLegGain (), 13)),
            toDouble (mask (pressureCG (), 14)),
            toDouble (mask (steamFlowFG (), 15)),
            toDouble (mask (steamPressureDropLagTC (), 16)),
            toDouble (mask (steamPressureFG (), 17)),
            toDouble (mask (throttlePressureFactor (), 18)),
            toDouble (mask (throttlePressureSP (), 19))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The machine used to develop mechanical energy used to drive a generator.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param primeMoverRating Rating of prime mover.
 * @param SynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines this Prime mover drives.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class PrimeMover
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PrimeMover.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PrimeMover.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PrimeMover.fields (position), x))
        emitelem (0, primeMoverRating)
        emitattrs (1, SynchronousMachines)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PrimeMover rdf:ID=\"%s\">\n%s\t</cim:PrimeMover>".format (id, export_fields)
    }
}

object PrimeMover
extends
    Parseable[PrimeMover]
{
    override val fields: Array[String] = Array[String] (
        "primeMoverRating",
        "SynchronousMachines"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SynchronousMachines", "SynchronousMachine", "0..*", "0..*")
    )
    val primeMoverRating: Fielder = parse_element (element (cls, fields(0)))
    val SynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): PrimeMover =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PrimeMover (
            PowerSystemResource.parse (context),
            toDouble (mask (primeMoverRating (), 0)),
            masks (SynchronousMachines (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Steam supply for steam turbine.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param steamSupplyRating Rating of steam supply.
 * @param SteamTurbines [[ch.ninecode.model.SteamTurbine SteamTurbine]] Steam turbines may have steam supplied by a steam supply.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class SteamSupply
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SteamSupply.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SteamSupply.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SteamSupply.fields (position), x))
        emitelem (0, steamSupplyRating)
        emitattrs (1, SteamTurbines)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SteamSupply rdf:ID=\"%s\">\n%s\t</cim:SteamSupply>".format (id, export_fields)
    }
}

object SteamSupply
extends
    Parseable[SteamSupply]
{
    override val fields: Array[String] = Array[String] (
        "steamSupplyRating",
        "SteamTurbines"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SteamTurbines", "SteamTurbine", "0..*", "0..*")
    )
    val steamSupplyRating: Fielder = parse_element (element (cls, fields(0)))
    val SteamTurbines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): SteamSupply =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SteamSupply (
            PowerSystemResource.parse (context),
            toDouble (mask (steamSupplyRating (), 0)),
            masks (SteamTurbines (), 1)
        )
        ret.bitfields = bitfields
        ret
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
 * @param SteamSupplys [[ch.ninecode.model.SteamSupply SteamSupply]] Steam turbines may have steam supplied by a steam supply.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class SteamTurbine
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
    steamChestTC: Double,
    SteamSupplys: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, List()) }
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SteamTurbine.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SteamTurbine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SteamTurbine.fields (position), x))
        emitelem (0, crossoverTC)
        emitelem (1, reheater1TC)
        emitelem (2, reheater2TC)
        emitelem (3, shaft1PowerHP)
        emitelem (4, shaft1PowerIP)
        emitelem (5, shaft1PowerLP1)
        emitelem (6, shaft1PowerLP2)
        emitelem (7, shaft2PowerHP)
        emitelem (8, shaft2PowerIP)
        emitelem (9, shaft2PowerLP1)
        emitelem (10, shaft2PowerLP2)
        emitelem (11, steamChestTC)
        emitattrs (12, SteamSupplys)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SteamTurbine rdf:ID=\"%s\">\n%s\t</cim:SteamTurbine>".format (id, export_fields)
    }
}

object SteamTurbine
extends
    Parseable[SteamTurbine]
{
    override val fields: Array[String] = Array[String] (
        "crossoverTC",
        "reheater1TC",
        "reheater2TC",
        "shaft1PowerHP",
        "shaft1PowerIP",
        "shaft1PowerLP1",
        "shaft1PowerLP2",
        "shaft2PowerHP",
        "shaft2PowerIP",
        "shaft2PowerLP1",
        "shaft2PowerLP2",
        "steamChestTC",
        "SteamSupplys"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SteamSupplys", "SteamSupply", "0..*", "0..*")
    )
    val crossoverTC: Fielder = parse_element (element (cls, fields(0)))
    val reheater1TC: Fielder = parse_element (element (cls, fields(1)))
    val reheater2TC: Fielder = parse_element (element (cls, fields(2)))
    val shaft1PowerHP: Fielder = parse_element (element (cls, fields(3)))
    val shaft1PowerIP: Fielder = parse_element (element (cls, fields(4)))
    val shaft1PowerLP1: Fielder = parse_element (element (cls, fields(5)))
    val shaft1PowerLP2: Fielder = parse_element (element (cls, fields(6)))
    val shaft2PowerHP: Fielder = parse_element (element (cls, fields(7)))
    val shaft2PowerIP: Fielder = parse_element (element (cls, fields(8)))
    val shaft2PowerLP1: Fielder = parse_element (element (cls, fields(9)))
    val shaft2PowerLP2: Fielder = parse_element (element (cls, fields(10)))
    val steamChestTC: Fielder = parse_element (element (cls, fields(11)))
    val SteamSupplys: FielderMultiple = parse_attributes (attribute (cls, fields(12)))

    def parse (context: Context): SteamTurbine =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SteamTurbine (
            PrimeMover.parse (context),
            toDouble (mask (crossoverTC (), 0)),
            toDouble (mask (reheater1TC (), 1)),
            toDouble (mask (reheater2TC (), 2)),
            toDouble (mask (shaft1PowerHP (), 3)),
            toDouble (mask (shaft1PowerIP (), 4)),
            toDouble (mask (shaft1PowerLP1 (), 5)),
            toDouble (mask (shaft1PowerLP2 (), 6)),
            toDouble (mask (shaft2PowerHP (), 7)),
            toDouble (mask (shaft2PowerIP (), 8)),
            toDouble (mask (shaft2PowerLP1 (), 9)),
            toDouble (mask (shaft2PowerLP2 (), 10)),
            toDouble (mask (steamChestTC (), 11)),
            masks (SteamSupplys (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Once-through subcritical boiler.
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class Subcritical
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Subcritical rdf:ID=\"%s\">\n%s\t</cim:Subcritical>".format (id, export_fields)
    }
}

object Subcritical
extends
    Parseable[Subcritical]
{

    def parse (context: Context): Subcritical =
    {
        implicit val ctx: Context = context
        val ret = Subcritical (
            FossilSteamSupply.parse (context)
        )
        ret
    }
}

/**
 * Once-through supercritical boiler.
 *
 * @param sup [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class Supercritical
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
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Supercritical rdf:ID=\"%s\">\n%s\t</cim:Supercritical>".format (id, export_fields)
    }
}

object Supercritical
extends
    Parseable[Supercritical]
{

    def parse (context: Context): Supercritical =
    {
        implicit val ctx: Context = context
        val ret = Supercritical (
            FossilSteamSupply.parse (context)
        )
        ret
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