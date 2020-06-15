package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Boiling water reactor used as a steam supply to a steam turbine.
 *
 * @param SteamSupply [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
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
    SteamSupply: SteamSupply = null,
    highPowerLimit: Double = 0.0,
    inCoreThermalTC: Double = 0.0,
    integralGain: Double = 0.0,
    lowPowerLimit: Double = 0.0,
    lowerLimit: Double = 0.0,
    pressureLimit: Double = 0.0,
    pressureSetpointGA: Double = 0.0,
    pressureSetpointTC1: Double = 0.0,
    pressureSetpointTC2: Double = 0.0,
    proportionalGain: Double = 0.0,
    rfAux1: Double = 0.0,
    rfAux2: Double = 0.0,
    rfAux3: Double = 0.0,
    rfAux4: Double = 0.0,
    rfAux5: Double = 0.0,
    rfAux6: Double = 0.0,
    rfAux7: Double = 0.0,
    rfAux8: Double = 0.0,
    rodPattern: Double = 0.0,
    rodPatternConstant: Double = 0.0,
    upperLimit: Double = 0.0
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
    override def sup: SteamSupply = SteamSupply

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
    CIMParseable[BWRSteamSupply]
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

    def parse (context: CIMContext): BWRSteamSupply =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[BWRSteamSupply] = BWRSteamSupplySerializer
}

object BWRSteamSupplySerializer extends CIMSerializer[BWRSteamSupply]
{
    def write (kryo: Kryo, output: Output, obj: BWRSteamSupply): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.highPowerLimit),
            () => output.writeDouble (obj.inCoreThermalTC),
            () => output.writeDouble (obj.integralGain),
            () => output.writeDouble (obj.lowPowerLimit),
            () => output.writeDouble (obj.lowerLimit),
            () => output.writeDouble (obj.pressureLimit),
            () => output.writeDouble (obj.pressureSetpointGA),
            () => output.writeDouble (obj.pressureSetpointTC1),
            () => output.writeDouble (obj.pressureSetpointTC2),
            () => output.writeDouble (obj.proportionalGain),
            () => output.writeDouble (obj.rfAux1),
            () => output.writeDouble (obj.rfAux2),
            () => output.writeDouble (obj.rfAux3),
            () => output.writeDouble (obj.rfAux4),
            () => output.writeDouble (obj.rfAux5),
            () => output.writeDouble (obj.rfAux6),
            () => output.writeDouble (obj.rfAux7),
            () => output.writeDouble (obj.rfAux8),
            () => output.writeDouble (obj.rodPattern),
            () => output.writeDouble (obj.rodPatternConstant),
            () => output.writeDouble (obj.upperLimit)
        )
        SteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BWRSteamSupply]): BWRSteamSupply =
    {
        val parent = SteamSupplySerializer.read (kryo, input, classOf[SteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BWRSteamSupply (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Relationship between the combustion turbine's power output rating in gross active power (X-axis) and the ambient air temperature (Y-axis).
 *
 * @param Curve [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param CombustionTurbine [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A combustion turbine may have an active power versus ambient temperature relationship.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class CTTempActivePowerCurve
(
    Curve: Curve = null,
    CombustionTurbine: String = null
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
    override def sup: Curve = Curve

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
    CIMParseable[CTTempActivePowerCurve]
{
    override val fields: Array[String] = Array[String] (
        "CombustionTurbine"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombustionTurbine", "CombustionTurbine", "1", "0..1")
    )
    val CombustionTurbine: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): CTTempActivePowerCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CTTempActivePowerCurve (
            Curve.parse (context),
            mask (CombustionTurbine (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CTTempActivePowerCurve] = CTTempActivePowerCurveSerializer
}

object CTTempActivePowerCurveSerializer extends CIMSerializer[CTTempActivePowerCurve]
{
    def write (kryo: Kryo, output: Output, obj: CTTempActivePowerCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CombustionTurbine)
        )
        CurveSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CTTempActivePowerCurve]): CTTempActivePowerCurve =
    {
        val parent = CurveSerializer.read (kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CTTempActivePowerCurve (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A prime mover that is typically fuelled by gas or light oil.
 *
 * @param PrimeMover [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
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
    PrimeMover: PrimeMover = null,
    ambientTemp: Double = 0.0,
    auxPowerVersusFrequency: Double = 0.0,
    auxPowerVersusVoltage: Double = 0.0,
    capabilityVersusFrequency: Double = 0.0,
    heatRecoveryFlag: Boolean = false,
    powerVariationByTemp: Double = 0.0,
    referenceTemp: Double = 0.0,
    timeConstant: Double = 0.0,
    AirCompressor: String = null,
    CTTempActivePowerCurve: String = null,
    HeatRecoveryBoiler: String = null
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
    override def sup: PrimeMover = PrimeMover

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
    CIMParseable[CombustionTurbine]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AirCompressor", "AirCompressor", "0..1", "1"),
        CIMRelationship ("CTTempActivePowerCurve", "CTTempActivePowerCurve", "0..1", "1"),
        CIMRelationship ("HeatRecoveryBoiler", "HeatRecoveryBoiler", "0..1", "0..*")
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

    def parse (context: CIMContext): CombustionTurbine =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[CombustionTurbine] = CombustionTurbineSerializer
}

object CombustionTurbineSerializer extends CIMSerializer[CombustionTurbine]
{
    def write (kryo: Kryo, output: Output, obj: CombustionTurbine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.ambientTemp),
            () => output.writeDouble (obj.auxPowerVersusFrequency),
            () => output.writeDouble (obj.auxPowerVersusVoltage),
            () => output.writeDouble (obj.capabilityVersusFrequency),
            () => output.writeBoolean (obj.heatRecoveryFlag),
            () => output.writeDouble (obj.powerVariationByTemp),
            () => output.writeDouble (obj.referenceTemp),
            () => output.writeDouble (obj.timeConstant),
            () => output.writeString (obj.AirCompressor),
            () => output.writeString (obj.CTTempActivePowerCurve),
            () => output.writeString (obj.HeatRecoveryBoiler)
        )
        PrimeMoverSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CombustionTurbine]): CombustionTurbine =
    {
        val parent = PrimeMoverSerializer.read (kryo, input, classOf[PrimeMover])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CombustionTurbine (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Drum boiler.
 *
 * @param FossilSteamSupply [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param drumBoilerRating Rating of drum boiler in steam units.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class DrumBoiler
(
    FossilSteamSupply: FossilSteamSupply = null,
    drumBoilerRating: Double = 0.0
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
    override def sup: FossilSteamSupply = FossilSteamSupply

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
    CIMParseable[DrumBoiler]
{
    override val fields: Array[String] = Array[String] (
        "drumBoilerRating"
    )
    val drumBoilerRating: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): DrumBoiler =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DrumBoiler (
            FossilSteamSupply.parse (context),
            toDouble (mask (drumBoilerRating (), 0))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DrumBoiler] = DrumBoilerSerializer
}

object DrumBoilerSerializer extends CIMSerializer[DrumBoiler]
{
    def write (kryo: Kryo, output: Output, obj: DrumBoiler): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.drumBoilerRating)
        )
        FossilSteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DrumBoiler]): DrumBoiler =
    {
        val parent = FossilSteamSupplySerializer.read (kryo, input, classOf[FossilSteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DrumBoiler (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Fossil fuelled boiler (e.g., coal, oil, gas).
 *
 * @param SteamSupply [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
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
    SteamSupply: SteamSupply = null,
    auxPowerVersusFrequency: Double = 0.0,
    auxPowerVersusVoltage: Double = 0.0,
    boilerControlMode: String = null,
    controlErrorBiasP: Double = 0.0,
    controlIC: Double = 0.0,
    controlPC: Double = 0.0,
    controlPEB: Double = 0.0,
    controlPED: Double = 0.0,
    controlTC: Double = 0.0,
    feedWaterIG: Double = 0.0,
    feedWaterPG: Double = 0.0,
    feedWaterTC: Double = 0.0,
    fuelDemandLimit: Double = 0.0,
    fuelSupplyDelay: Double = 0.0,
    fuelSupplyTC: Double = 0.0,
    maxErrorRateP: Double = 0.0,
    mechPowerSensorLag: Double = 0.0,
    minErrorRateP: Double = 0.0,
    pressureCtrlDG: Double = 0.0,
    pressureCtrlIG: Double = 0.0,
    pressureCtrlPG: Double = 0.0,
    pressureFeedback: Int = 0,
    superHeater1Capacity: Double = 0.0,
    superHeater2Capacity: Double = 0.0,
    superHeaterPipePD: Double = 0.0,
    throttlePressureSP: Double = 0.0
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
    override def sup: SteamSupply = SteamSupply

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
    CIMParseable[FossilSteamSupply]
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

    def parse (context: CIMContext): FossilSteamSupply =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[FossilSteamSupply] = FossilSteamSupplySerializer
}

object FossilSteamSupplySerializer extends CIMSerializer[FossilSteamSupply]
{
    def write (kryo: Kryo, output: Output, obj: FossilSteamSupply): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.auxPowerVersusFrequency),
            () => output.writeDouble (obj.auxPowerVersusVoltage),
            () => output.writeString (obj.boilerControlMode),
            () => output.writeDouble (obj.controlErrorBiasP),
            () => output.writeDouble (obj.controlIC),
            () => output.writeDouble (obj.controlPC),
            () => output.writeDouble (obj.controlPEB),
            () => output.writeDouble (obj.controlPED),
            () => output.writeDouble (obj.controlTC),
            () => output.writeDouble (obj.feedWaterIG),
            () => output.writeDouble (obj.feedWaterPG),
            () => output.writeDouble (obj.feedWaterTC),
            () => output.writeDouble (obj.fuelDemandLimit),
            () => output.writeDouble (obj.fuelSupplyDelay),
            () => output.writeDouble (obj.fuelSupplyTC),
            () => output.writeDouble (obj.maxErrorRateP),
            () => output.writeDouble (obj.mechPowerSensorLag),
            () => output.writeDouble (obj.minErrorRateP),
            () => output.writeDouble (obj.pressureCtrlDG),
            () => output.writeDouble (obj.pressureCtrlIG),
            () => output.writeDouble (obj.pressureCtrlPG),
            () => output.writeInt (obj.pressureFeedback),
            () => output.writeDouble (obj.superHeater1Capacity),
            () => output.writeDouble (obj.superHeater2Capacity),
            () => output.writeDouble (obj.superHeaterPipePD),
            () => output.writeDouble (obj.throttlePressureSP)
        )
        SteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FossilSteamSupply]): FossilSteamSupply =
    {
        val parent = SteamSupplySerializer.read (kryo, input, classOf[SteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FossilSteamSupply (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readDouble else 0.0,
            if (isSet (21)) input.readInt else 0,
            if (isSet (22)) input.readDouble else 0.0,
            if (isSet (23)) input.readDouble else 0.0,
            if (isSet (24)) input.readDouble else 0.0,
            if (isSet (25)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The heat recovery system associated with combustion turbines in order to produce steam for combined cycle plants.
 *
 * @param FossilSteamSupply [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @param steamSupplyRating2 The steam supply rating in kilopounds per hour, if dual pressure boiler.
 * @param CombustionTurbines [[ch.ninecode.model.CombustionTurbine CombustionTurbine]] A combustion turbine may have a heat recovery boiler for making steam.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class HeatRecoveryBoiler
(
    FossilSteamSupply: FossilSteamSupply = null,
    steamSupplyRating2: Double = 0.0,
    CombustionTurbines: List[String] = null
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
    override def sup: FossilSteamSupply = FossilSteamSupply

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
    CIMParseable[HeatRecoveryBoiler]
{
    override val fields: Array[String] = Array[String] (
        "steamSupplyRating2",
        "CombustionTurbines"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CombustionTurbines", "CombustionTurbine", "0..*", "0..1")
    )
    val steamSupplyRating2: Fielder = parse_element (element (cls, fields(0)))
    val CombustionTurbines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): HeatRecoveryBoiler =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HeatRecoveryBoiler (
            FossilSteamSupply.parse (context),
            toDouble (mask (steamSupplyRating2 (), 0)),
            masks (CombustionTurbines (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[HeatRecoveryBoiler] = HeatRecoveryBoilerSerializer
}

object HeatRecoveryBoilerSerializer extends CIMSerializer[HeatRecoveryBoiler]
{
    def write (kryo: Kryo, output: Output, obj: HeatRecoveryBoiler): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.steamSupplyRating2),
            () => writeList (obj.CombustionTurbines, output)
        )
        FossilSteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HeatRecoveryBoiler]): HeatRecoveryBoiler =
    {
        val parent = FossilSteamSupplySerializer.read (kryo, input, classOf[FossilSteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HeatRecoveryBoiler (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A water driven prime mover.
 *
 * Typical turbine types are: Francis, Kaplan, and Pelton.
 *
 * @param PrimeMover [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
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
    PrimeMover: PrimeMover = null,
    gateRateLimit: Double = 0.0,
    gateUpperLimit: Double = 0.0,
    maxHeadMaxP: Double = 0.0,
    minHeadMaxP: Double = 0.0,
    speedRating: Double = 0.0,
    speedRegulation: Double = 0.0,
    transientDroopTime: Double = 0.0,
    transientRegulation: Double = 0.0,
    turbineRating: Double = 0.0,
    turbineType: String = null,
    waterStartingTime: Double = 0.0
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
    override def sup: PrimeMover = PrimeMover

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
    CIMParseable[HydroTurbine]
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

    def parse (context: CIMContext): HydroTurbine =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[HydroTurbine] = HydroTurbineSerializer
}

object HydroTurbineSerializer extends CIMSerializer[HydroTurbine]
{
    def write (kryo: Kryo, output: Output, obj: HydroTurbine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.gateRateLimit),
            () => output.writeDouble (obj.gateUpperLimit),
            () => output.writeDouble (obj.maxHeadMaxP),
            () => output.writeDouble (obj.minHeadMaxP),
            () => output.writeDouble (obj.speedRating),
            () => output.writeDouble (obj.speedRegulation),
            () => output.writeDouble (obj.transientDroopTime),
            () => output.writeDouble (obj.transientRegulation),
            () => output.writeDouble (obj.turbineRating),
            () => output.writeString (obj.turbineType),
            () => output.writeDouble (obj.waterStartingTime)
        )
        PrimeMoverSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HydroTurbine]): HydroTurbine =
    {
        val parent = PrimeMoverSerializer.read (kryo, input, classOf[PrimeMover])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HydroTurbine (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Pressurized water reactor used as a steam supply to a steam turbine.
 *
 * @param SteamSupply [[ch.ninecode.model.SteamSupply SteamSupply]] Reference to the superclass object.
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
    SteamSupply: SteamSupply = null,
    coldLegFBLagTC: Double = 0.0,
    coldLegFBLeadTC1: Double = 0.0,
    coldLegFBLeadTC2: Double = 0.0,
    coldLegFG1: Double = 0.0,
    coldLegFG2: Double = 0.0,
    coldLegLagTC: Double = 0.0,
    coreHTLagTC1: Double = 0.0,
    coreHTLagTC2: Double = 0.0,
    coreNeutronicsEffTC: Double = 0.0,
    coreNeutronicsHT: Double = 0.0,
    feedbackFactor: Double = 0.0,
    hotLegLagTC: Double = 0.0,
    hotLegSteamGain: Double = 0.0,
    hotLegToColdLegGain: Double = 0.0,
    pressureCG: Double = 0.0,
    steamFlowFG: Double = 0.0,
    steamPressureDropLagTC: Double = 0.0,
    steamPressureFG: Double = 0.0,
    throttlePressureFactor: Double = 0.0,
    throttlePressureSP: Double = 0.0
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
    override def sup: SteamSupply = SteamSupply

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
    CIMParseable[PWRSteamSupply]
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

    def parse (context: CIMContext): PWRSteamSupply =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[PWRSteamSupply] = PWRSteamSupplySerializer
}

object PWRSteamSupplySerializer extends CIMSerializer[PWRSteamSupply]
{
    def write (kryo: Kryo, output: Output, obj: PWRSteamSupply): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.coldLegFBLagTC),
            () => output.writeDouble (obj.coldLegFBLeadTC1),
            () => output.writeDouble (obj.coldLegFBLeadTC2),
            () => output.writeDouble (obj.coldLegFG1),
            () => output.writeDouble (obj.coldLegFG2),
            () => output.writeDouble (obj.coldLegLagTC),
            () => output.writeDouble (obj.coreHTLagTC1),
            () => output.writeDouble (obj.coreHTLagTC2),
            () => output.writeDouble (obj.coreNeutronicsEffTC),
            () => output.writeDouble (obj.coreNeutronicsHT),
            () => output.writeDouble (obj.feedbackFactor),
            () => output.writeDouble (obj.hotLegLagTC),
            () => output.writeDouble (obj.hotLegSteamGain),
            () => output.writeDouble (obj.hotLegToColdLegGain),
            () => output.writeDouble (obj.pressureCG),
            () => output.writeDouble (obj.steamFlowFG),
            () => output.writeDouble (obj.steamPressureDropLagTC),
            () => output.writeDouble (obj.steamPressureFG),
            () => output.writeDouble (obj.throttlePressureFactor),
            () => output.writeDouble (obj.throttlePressureSP)
        )
        SteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PWRSteamSupply]): PWRSteamSupply =
    {
        val parent = SteamSupplySerializer.read (kryo, input, classOf[SteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PWRSteamSupply (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The machine used to develop mechanical energy used to drive a generator.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param primeMoverRating Rating of prime mover.
 * @param SynchronousMachines [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machines this Prime mover drives.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class PrimeMover
(
    PowerSystemResource: PowerSystemResource = null,
    primeMoverRating: Double = 0.0,
    SynchronousMachines: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    CIMParseable[PrimeMover]
{
    override val fields: Array[String] = Array[String] (
        "primeMoverRating",
        "SynchronousMachines"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SynchronousMachines", "SynchronousMachine", "0..*", "0..*")
    )
    val primeMoverRating: Fielder = parse_element (element (cls, fields(0)))
    val SynchronousMachines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): PrimeMover =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PrimeMover (
            PowerSystemResource.parse (context),
            toDouble (mask (primeMoverRating (), 0)),
            masks (SynchronousMachines (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PrimeMover] = PrimeMoverSerializer
}

object PrimeMoverSerializer extends CIMSerializer[PrimeMover]
{
    def write (kryo: Kryo, output: Output, obj: PrimeMover): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.primeMoverRating),
            () => writeList (obj.SynchronousMachines, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PrimeMover]): PrimeMover =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PrimeMover (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Steam supply for steam turbine.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param steamSupplyRating Rating of steam supply.
 * @param SteamTurbines [[ch.ninecode.model.SteamTurbine SteamTurbine]] Steam turbines may have steam supplied by a steam supply.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class SteamSupply
(
    PowerSystemResource: PowerSystemResource = null,
    steamSupplyRating: Double = 0.0,
    SteamTurbines: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    CIMParseable[SteamSupply]
{
    override val fields: Array[String] = Array[String] (
        "steamSupplyRating",
        "SteamTurbines"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SteamTurbines", "SteamTurbine", "0..*", "0..*")
    )
    val steamSupplyRating: Fielder = parse_element (element (cls, fields(0)))
    val SteamTurbines: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): SteamSupply =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SteamSupply (
            PowerSystemResource.parse (context),
            toDouble (mask (steamSupplyRating (), 0)),
            masks (SteamTurbines (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SteamSupply] = SteamSupplySerializer
}

object SteamSupplySerializer extends CIMSerializer[SteamSupply]
{
    def write (kryo: Kryo, output: Output, obj: SteamSupply): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.steamSupplyRating),
            () => writeList (obj.SteamTurbines, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SteamSupply]): SteamSupply =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SteamSupply (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Steam turbine.
 *
 * @param PrimeMover [[ch.ninecode.model.PrimeMover PrimeMover]] Reference to the superclass object.
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
    PrimeMover: PrimeMover = null,
    crossoverTC: Double = 0.0,
    reheater1TC: Double = 0.0,
    reheater2TC: Double = 0.0,
    shaft1PowerHP: Double = 0.0,
    shaft1PowerIP: Double = 0.0,
    shaft1PowerLP1: Double = 0.0,
    shaft1PowerLP2: Double = 0.0,
    shaft2PowerHP: Double = 0.0,
    shaft2PowerIP: Double = 0.0,
    shaft2PowerLP1: Double = 0.0,
    shaft2PowerLP2: Double = 0.0,
    steamChestTC: Double = 0.0,
    SteamSupplys: List[String] = null
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
    override def sup: PrimeMover = PrimeMover

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
    CIMParseable[SteamTurbine]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SteamSupplys", "SteamSupply", "0..*", "0..*")
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

    def parse (context: CIMContext): SteamTurbine =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[SteamTurbine] = SteamTurbineSerializer
}

object SteamTurbineSerializer extends CIMSerializer[SteamTurbine]
{
    def write (kryo: Kryo, output: Output, obj: SteamTurbine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.crossoverTC),
            () => output.writeDouble (obj.reheater1TC),
            () => output.writeDouble (obj.reheater2TC),
            () => output.writeDouble (obj.shaft1PowerHP),
            () => output.writeDouble (obj.shaft1PowerIP),
            () => output.writeDouble (obj.shaft1PowerLP1),
            () => output.writeDouble (obj.shaft1PowerLP2),
            () => output.writeDouble (obj.shaft2PowerHP),
            () => output.writeDouble (obj.shaft2PowerIP),
            () => output.writeDouble (obj.shaft2PowerLP1),
            () => output.writeDouble (obj.shaft2PowerLP2),
            () => output.writeDouble (obj.steamChestTC),
            () => writeList (obj.SteamSupplys, output)
        )
        PrimeMoverSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SteamTurbine]): SteamTurbine =
    {
        val parent = PrimeMoverSerializer.read (kryo, input, classOf[PrimeMover])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SteamTurbine (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Once-through subcritical boiler.
 *
 * @param FossilSteamSupply [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class Subcritical
(
    FossilSteamSupply: FossilSteamSupply = null
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
    override def sup: FossilSteamSupply = FossilSteamSupply

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Subcritical rdf:ID=\"%s\">\n%s\t</cim:Subcritical>".format (id, export_fields)
    }
}

object Subcritical
extends
    CIMParseable[Subcritical]
{

    def parse (context: CIMContext): Subcritical =
    {
        val ret = Subcritical (
            FossilSteamSupply.parse (context)
        )
        ret
    }

    def serializer: Serializer[Subcritical] = SubcriticalSerializer
}

object SubcriticalSerializer extends CIMSerializer[Subcritical]
{
    def write (kryo: Kryo, output: Output, obj: Subcritical): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        FossilSteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Subcritical]): Subcritical =
    {
        val parent = FossilSteamSupplySerializer.read (kryo, input, classOf[FossilSteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Subcritical (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Once-through supercritical boiler.
 *
 * @param FossilSteamSupply [[ch.ninecode.model.FossilSteamSupply FossilSteamSupply]] Reference to the superclass object.
 * @group GenerationTrainingSimulation
 * @groupname GenerationTrainingSimulation Package GenerationTrainingSimulation
 * @groupdesc GenerationTrainingSimulation The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 */
final case class Supercritical
(
    FossilSteamSupply: FossilSteamSupply = null
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
    override def sup: FossilSteamSupply = FossilSteamSupply

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Supercritical rdf:ID=\"%s\">\n%s\t</cim:Supercritical>".format (id, export_fields)
    }
}

object Supercritical
extends
    CIMParseable[Supercritical]
{

    def parse (context: CIMContext): Supercritical =
    {
        val ret = Supercritical (
            FossilSteamSupply.parse (context)
        )
        ret
    }

    def serializer: Serializer[Supercritical] = SupercriticalSerializer
}

object SupercriticalSerializer extends CIMSerializer[Supercritical]
{
    def write (kryo: Kryo, output: Output, obj: Supercritical): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        FossilSteamSupplySerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Supercritical]): Supercritical =
    {
        val parent = FossilSteamSupplySerializer.read (kryo, input, classOf[FossilSteamSupply])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Supercritical (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _GenerationTrainingSimulation
{
    def register: List[CIMClassInfo] =
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