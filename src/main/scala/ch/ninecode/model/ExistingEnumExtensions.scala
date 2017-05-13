package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Enumeration of phase identifiers.
 * Allows designation of phases for both transmission and distribution equipment, circuits and loads.
 */
case class ExtPhaseCodeKind
(

    override val sup: BasicElement,

    /**
     * Not applicable to any phase
     */
    val none: String,

    /**
     * Phase A.
     */
    val A: String,

    /**
     * Phases A to B
     */
    val AB: String,

    /**
     * Involving all phases
     */
    val ABC: String,

    /**
     * ABC to Neutral
     */
    val ABCN: String,

    /**
     * AB to Neutral
     */
    val ABN: String,

    /**
     * Phases A and C
     */
    val AC: String,

    /**
     * Phases A, C and neutral.
     */
    val ACN: String,

    /**
     * Phases A to neutral.
     */
    val AN: String,

    /**
     * Phase A current relative to Phase A voltage
     */
    val AtoAv: String,

    /**
     * Phase B.
     */
    val B: String,

    /**
     * Phase B current or voltage relative to Phase A voltage
     */
    val BAv: String,

    /**
     * Phases B to C
     */
    val BC: String,

    /**
     * BC to neutral.
     */
    val BCN: String,

    /**
     * Phases B to neutral.
     */
    val BN: String,

    /**
     * Phase C.
     */
    val C: String,

    /**
     * CA to Neutral
     */
    val CAN: String,

    /**
     * hase C current or voltage relative to Phase A voltage
     */
    val CAv: String,

    /**
     * Phases C to neutral.
     */
    val CN: String,

    /**
     * Neutral
     */
    val N: String,

    /**
     * Neutral to ground
     */
    val NG: String,

    /**
     * Phase S1
     */
    val S1: String,

    /**
     * Phase S1 to S2
     */
    val S12: String,

    /**
     * Phase S1, S2 to neutral.
     */
    val S12N: String,

    /**
     * Phase S1 to Neutral
     */
    val S1N: String,

    /**
     * Phase S2.
     */
    val S2: String,

    /**
     * Phase S2 to neutral.
     */
    val S2N: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExtPhaseCodeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExtPhaseCodeKind
extends
    Parseable[ExtPhaseCodeKind]
{
    val sup = BasicElement.parse _
    val none = parse_attribute (attribute ("""ExtPhaseCodeKind.none"""))_
    val A = parse_attribute (attribute ("""ExtPhaseCodeKind.A"""))_
    val AB = parse_attribute (attribute ("""ExtPhaseCodeKind.AB"""))_
    val ABC = parse_attribute (attribute ("""ExtPhaseCodeKind.ABC"""))_
    val ABCN = parse_attribute (attribute ("""ExtPhaseCodeKind.ABCN"""))_
    val ABN = parse_attribute (attribute ("""ExtPhaseCodeKind.ABN"""))_
    val AC = parse_attribute (attribute ("""ExtPhaseCodeKind.AC"""))_
    val ACN = parse_attribute (attribute ("""ExtPhaseCodeKind.ACN"""))_
    val AN = parse_attribute (attribute ("""ExtPhaseCodeKind.AN"""))_
    val AtoAv = parse_attribute (attribute ("""ExtPhaseCodeKind.AtoAv"""))_
    val B = parse_attribute (attribute ("""ExtPhaseCodeKind.B"""))_
    val BAv = parse_attribute (attribute ("""ExtPhaseCodeKind.BAv"""))_
    val BC = parse_attribute (attribute ("""ExtPhaseCodeKind.BC"""))_
    val BCN = parse_attribute (attribute ("""ExtPhaseCodeKind.BCN"""))_
    val BN = parse_attribute (attribute ("""ExtPhaseCodeKind.BN"""))_
    val C = parse_attribute (attribute ("""ExtPhaseCodeKind.C"""))_
    val CAN = parse_attribute (attribute ("""ExtPhaseCodeKind.CAN"""))_
    val CAv = parse_attribute (attribute ("""ExtPhaseCodeKind.CAv"""))_
    val CN = parse_attribute (attribute ("""ExtPhaseCodeKind.CN"""))_
    val N = parse_attribute (attribute ("""ExtPhaseCodeKind.N"""))_
    val NG = parse_attribute (attribute ("""ExtPhaseCodeKind.NG"""))_
    val S1 = parse_attribute (attribute ("""ExtPhaseCodeKind.S1"""))_
    val S12 = parse_attribute (attribute ("""ExtPhaseCodeKind.S12"""))_
    val S12N = parse_attribute (attribute ("""ExtPhaseCodeKind.S12N"""))_
    val S1N = parse_attribute (attribute ("""ExtPhaseCodeKind.S1N"""))_
    val S2 = parse_attribute (attribute ("""ExtPhaseCodeKind.S2"""))_
    val S2N = parse_attribute (attribute ("""ExtPhaseCodeKind.S2N"""))_
    def parse (context: Context): ExtPhaseCodeKind =
    {
        ExtPhaseCodeKind(
            sup (context),
            none (context),
            A (context),
            AB (context),
            ABC (context),
            ABCN (context),
            ABN (context),
            AC (context),
            ACN (context),
            AN (context),
            AtoAv (context),
            B (context),
            BAv (context),
            BC (context),
            BCN (context),
            BN (context),
            C (context),
            CAN (context),
            CAv (context),
            CN (context),
            N (context),
            NG (context),
            S1 (context),
            S12 (context),
            S12N (context),
            S1N (context),
            S2 (context),
            S2N (context)
        )
    }
}

/**
 * The unit multipliers defined for the CIM.
 */
case class ExtUnitMultiplierKind
(

    override val sup: BasicElement,

    /**
     * Centi 10**-2
     */
    val c: String,

    /**
     * Deci 10**-1
     */
    val d: String,

    /**
     * deca 10**1
     */
    val da: String,

    /**
     * hecto 10**2
     */
    val h: String,

    /**
     * Kilo 10**3
     */
    val k: String,

    /**
     * Milli 10**-3
     */
    val m: String,

    /**
     * Micro 10**-6
     */
    val micro: String,

    /**
     * Nano 10**-9
     */
    val n: String,

    /**
     * Not Applicable or "x1"
     */
    val none: String,

    /**
     * Pico 10**-12
     */
    val p: String,

    /**
     * Giga 10**9
     */
    val G: String,

    /**
     * Mega 10**6
     */
    val M: String,

    /**
     * Tera 10**12
     */
    val T: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExtUnitMultiplierKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExtUnitMultiplierKind
extends
    Parseable[ExtUnitMultiplierKind]
{
    val sup = BasicElement.parse _
    val c = parse_attribute (attribute ("""ExtUnitMultiplierKind.c"""))_
    val d = parse_attribute (attribute ("""ExtUnitMultiplierKind.d"""))_
    val da = parse_attribute (attribute ("""ExtUnitMultiplierKind.da"""))_
    val h = parse_attribute (attribute ("""ExtUnitMultiplierKind.h"""))_
    val k = parse_attribute (attribute ("""ExtUnitMultiplierKind.k"""))_
    val m = parse_attribute (attribute ("""ExtUnitMultiplierKind.m"""))_
    val micro = parse_attribute (attribute ("""ExtUnitMultiplierKind.micro"""))_
    val n = parse_attribute (attribute ("""ExtUnitMultiplierKind.n"""))_
    val none = parse_attribute (attribute ("""ExtUnitMultiplierKind.none"""))_
    val p = parse_attribute (attribute ("""ExtUnitMultiplierKind.p"""))_
    val G = parse_attribute (attribute ("""ExtUnitMultiplierKind.G"""))_
    val M = parse_attribute (attribute ("""ExtUnitMultiplierKind.M"""))_
    val T = parse_attribute (attribute ("""ExtUnitMultiplierKind.T"""))_
    def parse (context: Context): ExtUnitMultiplierKind =
    {
        ExtUnitMultiplierKind(
            sup (context),
            c (context),
            d (context),
            da (context),
            h (context),
            k (context),
            m (context),
            micro (context),
            n (context),
            none (context),
            p (context),
            G (context),
            M (context),
            T (context)
        )
    }
}

/**
 * The units defiend for usage in the CIM.
 */
case class ExtUnitSymbolKind
(

    override val sup: BasicElement,

    /**
     * A/m, magnetic field strength, Ampere per metre, A/m
     */
    val aPerM: String,

    /**
     * Sound pressure level, Bel, acoustic, Combine with multiplier prefix �d� to form decibels of Sound Pressure Level
     * �dB (SPL).�, B (SPL)
     */
    val b: String,

    /**
     * Signal Strength, Bel-mW, normalized to 1mW.
     * Note: to form �dBm� combine �Bm� with multiplier �d�. Bm
     */
    val bm: String,

    /**
     * Radioactivity, Becquerel (1/s), Bq
     */
    val bq: String,

    /**
     * Energy, British Thermal Units, BTU
     */
    val btu: String,

    /**
     * Power, BTU per hour, BTU/h
     */
    val btuPerH: String,

    /**
     * Luminous intensity, candela, cd
     */
    val cd: String,

    /**
     * Number of characters, characters, char
     */
    val char: String,

    /**
     * Data rate, characters per second, char/s
     */
    val charPerSec: String,

    /**
     * Application Value, encoded value, code
     */
    val code: String,

    /**
     * Power factor, Dimensionless &lt;img src="HTS_1.
     * PNG" width="64" height="29" border="0" alt="graphic"/&gt;, cos?
     */
    val cosTheta: String,

    /**
     * Amount of substance, counter value, count
     */
    val count: String,

    /**
     * Plane angle, degrees, deg
     */
    val deg: String,

    /**
     * Relative temperature in degrees Celsius.
     * In the SI unit system the symbol is �C. Electric charge is measured in coulomb that has the unit symbol C. To destinguish degree Celsius form coulomb the symbol used in the UML is degC. Reason for not using �C is the special character � is difficult to manage in software.
     */
    val degC: String,

    /**
     * Volume, cubic feet, ft�
     */
    val ft3: String,

    /**
     * Volume, cubic feet, ft�(compensated)
     */
    val ft3compensated: String,

    /**
     * Volumetric flow rate, compensated cubic feet per hour, ft�(compensated)/h
     */
    val ft3compensatedPerH: String,

    /**
     * Mass in gram, g
     */
    val g: String,

    /**
     * Turbine inertia, gram�meter2 (Combine with multiplier prefix �k� to form kg�m2.), gm�
     */
    val gM2: String,

    /**
     * Concentration, The ratio of the mass of a solute divided by the mass of the solution., g/g
     */
    val gPerG: String,

    /**
     * Absorbed dose, Gray (J/kg), GY
     */
    val gy: String,

    /**
     * Time, hour = minute * 60, h
     */
    val h: String,

    /**
     * Volume, imperial gallons, ImperialGal
     */
    val imperialGal: String,

    /**
     * Volumetric flow rate, Imperial gallons per hour, ImperialGal/h
     */
    val imperialGalPerH: String,

    /**
     * Heat capacity, Joule/Kelvin, J/K
     */
    val jPerK: String,

    /**
     * Specific energy, Joules / kg, J/kg
     */
    val jPerKg: String,

    /**
     * Catalytic activity, katal = mol / s, kat
     */
    val kat: String,

    /**
     * Moment of mass ,kilogram meter (kg�m), M
     */
    val kgM: String,

    /**
     * Density, gram/cubic meter (combine with prefix multiplier �k� to form kg/ m�), g/m�
     */
    val kgPerM3: String,

    /**
     * Volume, litre = dm3 = m3/1000., L
     */
    val litre: String,

    /**
     * Volume, litre, with the value compensated for weather effects, L(compensated)
     */
    val litreCompensated: String,

    /**
     * Volumetric flow rate, litres (compensated) per hour, L(compensated)/h
     */
    val litreCompensatedPerH: String,

    /**
     * Volumetric flow rate, litres per hour, L/h
     */
    val litrePerH: String,

    /**
     * Concentration, The ratio of the volume of a solute divided by the volume of  the solution., L/L
     */
    val litrePerLitre: String,

    /**
     * Volumetric flow rate, Volumetric flow rate, L/s
     */
    val litrePerSec: String,

    /**
     * Volume, litre, with the value uncompensated for weather effects., L(uncompensated)
     */
    val litreUncompensated: String,

    /**
     * Volumetric flow rate, litres (uncompensated) per hour, L(uncompensated)/h
     */
    val litreUncompensatedPerH: String,

    /**
     * Luminous flux, lumen (cd sr), Lm
     */
    val lm: String,

    /**
     * Illuminance lux, (lm/m�), L(uncompensated)/h
     */
    val lx: String,

    /**
     * Length, meter, m
     */
    val m: String,

    /**
     * Area, square meter, m�
     */
    val m2: String,

    /**
     * Viscosity, meter squared / second, m�/s
     * m�/h
     */
    val m2PerSec: String,

    /**
     * Volume, cubic meter, m�
     */
    val m3: String,

    /**
     * Volumetric flow rate, cubic meters per hour, m�/h
     */
    val m3PerH: String,

    /**
     * m3PerSec, cubic meters per second, m�/s
     */
    val m3PerSec: String,

    /**
     * Volume, cubic meter, with the value compensated for weather effects., m3(compensated)
     */
    val m3compensated: String,

    /**
     * Volumetric flow rate, compensated cubic meters per hour, �(compensated)/h
     */
    val m3compensatedPerH: String,

    /**
     * m3uncompensated, cubic meter, with the value uncompensated for weather effects., m3(uncompensated)
     */
    val m3uncompensated: String,

    /**
     * Volumetric flow rate, uncompensated cubic meters per hour, m�(uncompensated)/h
     */
    val m3uncompensatedPerH: String,

    /**
     * Length, Ratio of length, m/m
     */
    val mPerM: String,

    /**
     * Fuel efficiency, meters / cubic meter, m/m�
     */
    val mPerM3: String,

    /**
     * Velocity, meters per second (m/s), m/s
     */
    val mPerSec: String,

    /**
     * Acceleration, meters per second squared, m/s�
     */
    val mPerSec2: String,

    /**
     * EndDeviceEvent, value to be interpreted as a EndDeviceEventCode, meCode
     */
    val meCode: String,

    /**
     * Time, minute  = s * 60, min
     */
    val min: String,

    /**
     * Amount of substance, mole, mol
     */
    val mol: String,

    /**
     * Concentration, Molality, the amount of solute in moles and the amount of solvent in kilograms., mol/kg
     */
    val molPerKg: String,

    /**
     * Concentration, The amount of substance concentration, (c), the amount of solvent in moles divided by the volume of solution in m�., mol/ m�
     */
    val molPerM3: String,

    /**
     * Concentration, Molar fraction (?), the ratio of the molar amount of a solute divided by the molar amount of the solution.,mol/mol
     */
    val molPerMol: String,

    /**
     * Monetary unit, Generic money (Note: Specific monetary units are identified the currency class)., �
     */
    val money: String,

    /**
     * Force newton, (kg m/s�), N
     */
    val n: String,

    /**
     * N/A, None
     */
    val none: String,

    /**
     * Electric resistance, Ohm (V/A), O
     */
    val ohm: String,

    /**
     * resistivity, ? (rho), ?m
     */
    val ohmM: String,

    /**
     * Pressure, Pascal (N/m�)
    (Note: the absolute or relative measurement of pressure is implied with this entry.
     * See below for more explicit forms.), Pa
     */
    val pa: String,

    /**
     * Pressure, Pascal, absolute pressure, PaA
     */
    val paA: String,

    /**
     * Pressure, Pascal, gauge pressure, PaG
     */
    val paG: String,

    /**
     * Pressure, Pounds per square inch, absolute, psiA
     */
    val psiA: String,

    /**
     * Pressure, Pounds per square inch, gauge, psiG
     */
    val psiG: String,

    /**
     * Quantity power, Q, Q
     */
    val q: String,

    /**
     * Quantity power, Q measured at 45�, Q45
     */
    val q45: String,

    /**
     * Quantity energy, Q measured at 45�, Q45h
     */
    val q45h: String,

    /**
     * Quantity power, Q measured at 60�, Q60
     */
    val q60: String,

    /**
     * Quantity energy, Qh measured at 60�, Q60h
     */
    val q60h: String,

    /**
     * Quantity energy, Qh, Qh
     */
    val qh: String,

    /**
     * Plane angle, Radian (m/m), rad
     */
    val rad: String,

    /**
     * Angular velocity, radians per second, rad/s
     */
    val radPerSec: String,

    /**
     * Amount of rotation, Revolutions, rev
     */
    val rev: String,

    /**
     * Rotational speed, Rotations per second, rev/s
     */
    val revPerSec: String,

    /**
     * Time,  seconds, s
     */
    val sec: String,

    /**
     * Time, Ratio of time (can be combined with an multiplier prefix to show rates such as a clock drift rate, e.g. ��s/s�), s/s
     */
    val secPerSec: String,

    /**
     * Electric conductance, Siemens (A / V = 1 / O), S
     */
    val siemens: String,

    /**
     * Solid angle, Steradian (m2/m2), sr
     */
    val sr: String,

    /**
     * State, "1" = "true", "live", "on", "high", "set"; 
    "0" = "false", "dead", "off", "low", "cleared"
     * Note: A Boolean value is preferred but other values may be supported, status
     */
    val status: String,

    /**
     * Doe equivalent, Sievert (J/kg), Sv
     */
    val sv: String,

    /**
     * Magnetic flux density, Tesla (Wb/m2), T
     */
    val t: String,

    /**
     * Energy, Therm, therm
     */
    val therm: String,

    /**
     * Timestamp, time and date per ISO 8601 format, timeStamp
     */
    val timeStamp: String,

    /**
     * Volume, US gallons, <u>Gal</u>
     */
    val usGal: String,

    /**
     * Volumetric flow rate, US gallons per hour, USGal/h
     */
    val usGalPerH: String,

    /**
     * Thermal conductivity, Watt/meter Kelvin, W/m K
     */
    val wPerMK: String,

    /**
     * Magnetic flux, Weber (V s)<b>, Wb</b>
     */
    val wb: String,

    /**
     * Current, ampere, A
     */
    val A: String,

    /**
     * Amps squared,  amp squared, A2
     */
    val A2: String,

    /**
     * ampere-squared, Ampere-squared hour, A�h
     */
    val A2h: String,

    /**
     * Amps squared time, square amp second, A�s
     */
    val A2s: String,

    /**
     * Current, Ratio of Amperages, A/A
     */
    val APerA: String,

    /**
     * Ampere-hours, Ampere-hours, Ah
     */
    val Ah: String,

    /**
     * Amp seconds, amp seconds, As
     */
    val As: String,

    /**
     * Electric capacitance, Farad (C/V), �C
     */
    val F: String,

    /**
     * Electric inductance, Henry (Wb/A), H
     */
    val H: String,

    /**
     * Frequency hertz, (1/s), Hz
     */
    val Hz: String,

    /**
     * Frequency, Rate of frequency change, Hz/Hz
     */
    val HzPerHz: String,

    /**
     * Rate of change of frequency, hertz per second, Hz/s
     */
    val HzPerSec: String,

    /**
     * Energy joule, (N�m = C�V = W�s), J
     */
    val J: String,

    /**
     * Temperature, Kelvin, K
     */
    val K: String,

    /**
     * Electric potential, Volt (W/A), V
     */
    val V: String,

    /**
     * Volts squared, Volt squared (W2/A2), V�
     */
    val V2: String,

    /**
     * volt-squared hour, Volt-squared-hours, V�h
     */
    val V2h: String,

    /**
     * Apparent power, Volt Ampere (See also real power and reactive power.), VA
     */
    val VA: String,

    /**
     * Apparent energy, Volt Ampere hours, VAh
     */
    val VAh: String,

    /**
     * Kh-Vah, apparent energy metering constant, VAh/rev
     */
    val VAhPerRev: String,

    /**
     * Reactive power, Volt Ampere reactive.
     * The �reactive� or �imaginary� component of electrical power (VISin?). (See also real power and apparent power)., VAr
     */
    val VAr: String,

    /**
     * Reactive energy, Volt Ampere reactive hours, VArh
     */
    val VArh: String,

    /**
     * Kh-VArh, reactive energy metering constant, VArh/rev
     */
    val VArhPerRev: String,

    /**
     * Magnetic flux, Volts per Hertz, V/Hz
     */
    val VPerHz: String,

    /**
     * Voltage, Ratio of voltages (e.g. mV/V), V/V
     */
    val VPerV: String,

    /**
     * Volt seconds, Volt seconds (Ws/A), Vs
     */
    val Vs: String,

    /**
     * Real power, Watt.
     * By definition, one Watt equals oneJoule per second. Electrical power may have real and reactive components. The real portion of electrical power (I�R) or VIcos?, is expressed in Watts. (See also apparent power and reactive power.), W
     */
    val W: String,

    /**
     * Ramp rate, Watts per second, W/s
     */
    val WPerSec: String,

    /**
     * Power Factor, PF, W/VA
     */
    val WPerVA: String,

    /**
     * Signal Strength, Ratio of power, W/W
     */
    val WPerW: String,

    /**
     * Real energy, Watt hours, Wh
     */
    val Wh: String,

    /**
     * Wh/m3, energy per volume, Wh/m�
     */
    val WhPerM3: String,

    /**
     * Kh-Wh, active energy metering constant, Wh/rev
     */
    val WhPerRev: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExtUnitSymbolKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExtUnitSymbolKind
extends
    Parseable[ExtUnitSymbolKind]
{
    val sup = BasicElement.parse _
    val aPerM = parse_attribute (attribute ("""ExtUnitSymbolKind.aPerM"""))_
    val b = parse_attribute (attribute ("""ExtUnitSymbolKind.b"""))_
    val bm = parse_attribute (attribute ("""ExtUnitSymbolKind.bm"""))_
    val bq = parse_attribute (attribute ("""ExtUnitSymbolKind.bq"""))_
    val btu = parse_attribute (attribute ("""ExtUnitSymbolKind.btu"""))_
    val btuPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.btuPerH"""))_
    val cd = parse_attribute (attribute ("""ExtUnitSymbolKind.cd"""))_
    val char = parse_attribute (attribute ("""ExtUnitSymbolKind.char"""))_
    val charPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.charPerSec"""))_
    val code = parse_attribute (attribute ("""ExtUnitSymbolKind.code"""))_
    val cosTheta = parse_attribute (attribute ("""ExtUnitSymbolKind.cosTheta"""))_
    val count = parse_attribute (attribute ("""ExtUnitSymbolKind.count"""))_
    val deg = parse_attribute (attribute ("""ExtUnitSymbolKind.deg"""))_
    val degC = parse_attribute (attribute ("""ExtUnitSymbolKind.degC"""))_
    val ft3 = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3"""))_
    val ft3compensated = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3compensated"""))_
    val ft3compensatedPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3compensatedPerH"""))_
    val g = parse_attribute (attribute ("""ExtUnitSymbolKind.g"""))_
    val gM2 = parse_attribute (attribute ("""ExtUnitSymbolKind.gM2"""))_
    val gPerG = parse_attribute (attribute ("""ExtUnitSymbolKind.gPerG"""))_
    val gy = parse_attribute (attribute ("""ExtUnitSymbolKind.gy"""))_
    val h = parse_attribute (attribute ("""ExtUnitSymbolKind.h"""))_
    val imperialGal = parse_attribute (attribute ("""ExtUnitSymbolKind.imperialGal"""))_
    val imperialGalPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.imperialGalPerH"""))_
    val jPerK = parse_attribute (attribute ("""ExtUnitSymbolKind.jPerK"""))_
    val jPerKg = parse_attribute (attribute ("""ExtUnitSymbolKind.jPerKg"""))_
    val kat = parse_attribute (attribute ("""ExtUnitSymbolKind.kat"""))_
    val kgM = parse_attribute (attribute ("""ExtUnitSymbolKind.kgM"""))_
    val kgPerM3 = parse_attribute (attribute ("""ExtUnitSymbolKind.kgPerM3"""))_
    val litre = parse_attribute (attribute ("""ExtUnitSymbolKind.litre"""))_
    val litreCompensated = parse_attribute (attribute ("""ExtUnitSymbolKind.litreCompensated"""))_
    val litreCompensatedPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.litreCompensatedPerH"""))_
    val litrePerH = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerH"""))_
    val litrePerLitre = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerLitre"""))_
    val litrePerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerSec"""))_
    val litreUncompensated = parse_attribute (attribute ("""ExtUnitSymbolKind.litreUncompensated"""))_
    val litreUncompensatedPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.litreUncompensatedPerH"""))_
    val lm = parse_attribute (attribute ("""ExtUnitSymbolKind.lm"""))_
    val lx = parse_attribute (attribute ("""ExtUnitSymbolKind.lx"""))_
    val m = parse_attribute (attribute ("""ExtUnitSymbolKind.m"""))_
    val m2 = parse_attribute (attribute ("""ExtUnitSymbolKind.m2"""))_
    val m2PerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.m2PerSec"""))_
    val m3 = parse_attribute (attribute ("""ExtUnitSymbolKind.m3"""))_
    val m3PerH = parse_attribute (attribute ("""ExtUnitSymbolKind.m3PerH"""))_
    val m3PerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.m3PerSec"""))_
    val m3compensated = parse_attribute (attribute ("""ExtUnitSymbolKind.m3compensated"""))_
    val m3compensatedPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.m3compensatedPerH"""))_
    val m3uncompensated = parse_attribute (attribute ("""ExtUnitSymbolKind.m3uncompensated"""))_
    val m3uncompensatedPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.m3uncompensatedPerH"""))_
    val mPerM = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerM"""))_
    val mPerM3 = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerM3"""))_
    val mPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerSec"""))_
    val mPerSec2 = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerSec2"""))_
    val meCode = parse_attribute (attribute ("""ExtUnitSymbolKind.meCode"""))_
    val min = parse_attribute (attribute ("""ExtUnitSymbolKind.min"""))_
    val mol = parse_attribute (attribute ("""ExtUnitSymbolKind.mol"""))_
    val molPerKg = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerKg"""))_
    val molPerM3 = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerM3"""))_
    val molPerMol = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerMol"""))_
    val money = parse_attribute (attribute ("""ExtUnitSymbolKind.money"""))_
    val n = parse_attribute (attribute ("""ExtUnitSymbolKind.n"""))_
    val none = parse_attribute (attribute ("""ExtUnitSymbolKind.none"""))_
    val ohm = parse_attribute (attribute ("""ExtUnitSymbolKind.ohm"""))_
    val ohmM = parse_attribute (attribute ("""ExtUnitSymbolKind.ohmM"""))_
    val pa = parse_attribute (attribute ("""ExtUnitSymbolKind.pa"""))_
    val paA = parse_attribute (attribute ("""ExtUnitSymbolKind.paA"""))_
    val paG = parse_attribute (attribute ("""ExtUnitSymbolKind.paG"""))_
    val psiA = parse_attribute (attribute ("""ExtUnitSymbolKind.psiA"""))_
    val psiG = parse_attribute (attribute ("""ExtUnitSymbolKind.psiG"""))_
    val q = parse_attribute (attribute ("""ExtUnitSymbolKind.q"""))_
    val q45 = parse_attribute (attribute ("""ExtUnitSymbolKind.q45"""))_
    val q45h = parse_attribute (attribute ("""ExtUnitSymbolKind.q45h"""))_
    val q60 = parse_attribute (attribute ("""ExtUnitSymbolKind.q60"""))_
    val q60h = parse_attribute (attribute ("""ExtUnitSymbolKind.q60h"""))_
    val qh = parse_attribute (attribute ("""ExtUnitSymbolKind.qh"""))_
    val rad = parse_attribute (attribute ("""ExtUnitSymbolKind.rad"""))_
    val radPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.radPerSec"""))_
    val rev = parse_attribute (attribute ("""ExtUnitSymbolKind.rev"""))_
    val revPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.revPerSec"""))_
    val sec = parse_attribute (attribute ("""ExtUnitSymbolKind.sec"""))_
    val secPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.secPerSec"""))_
    val siemens = parse_attribute (attribute ("""ExtUnitSymbolKind.siemens"""))_
    val sr = parse_attribute (attribute ("""ExtUnitSymbolKind.sr"""))_
    val status = parse_attribute (attribute ("""ExtUnitSymbolKind.status"""))_
    val sv = parse_attribute (attribute ("""ExtUnitSymbolKind.sv"""))_
    val t = parse_attribute (attribute ("""ExtUnitSymbolKind.t"""))_
    val therm = parse_attribute (attribute ("""ExtUnitSymbolKind.therm"""))_
    val timeStamp = parse_attribute (attribute ("""ExtUnitSymbolKind.timeStamp"""))_
    val usGal = parse_attribute (attribute ("""ExtUnitSymbolKind.usGal"""))_
    val usGalPerH = parse_attribute (attribute ("""ExtUnitSymbolKind.usGalPerH"""))_
    val wPerMK = parse_attribute (attribute ("""ExtUnitSymbolKind.wPerMK"""))_
    val wb = parse_attribute (attribute ("""ExtUnitSymbolKind.wb"""))_
    val A = parse_attribute (attribute ("""ExtUnitSymbolKind.A"""))_
    val A2 = parse_attribute (attribute ("""ExtUnitSymbolKind.A2"""))_
    val A2h = parse_attribute (attribute ("""ExtUnitSymbolKind.A2h"""))_
    val A2s = parse_attribute (attribute ("""ExtUnitSymbolKind.A2s"""))_
    val APerA = parse_attribute (attribute ("""ExtUnitSymbolKind.APerA"""))_
    val Ah = parse_attribute (attribute ("""ExtUnitSymbolKind.Ah"""))_
    val As = parse_attribute (attribute ("""ExtUnitSymbolKind.As"""))_
    val F = parse_attribute (attribute ("""ExtUnitSymbolKind.F"""))_
    val H = parse_attribute (attribute ("""ExtUnitSymbolKind.H"""))_
    val Hz = parse_attribute (attribute ("""ExtUnitSymbolKind.Hz"""))_
    val HzPerHz = parse_attribute (attribute ("""ExtUnitSymbolKind.HzPerHz"""))_
    val HzPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.HzPerSec"""))_
    val J = parse_attribute (attribute ("""ExtUnitSymbolKind.J"""))_
    val K = parse_attribute (attribute ("""ExtUnitSymbolKind.K"""))_
    val V = parse_attribute (attribute ("""ExtUnitSymbolKind.V"""))_
    val V2 = parse_attribute (attribute ("""ExtUnitSymbolKind.V2"""))_
    val V2h = parse_attribute (attribute ("""ExtUnitSymbolKind.V2h"""))_
    val VA = parse_attribute (attribute ("""ExtUnitSymbolKind.VA"""))_
    val VAh = parse_attribute (attribute ("""ExtUnitSymbolKind.VAh"""))_
    val VAhPerRev = parse_attribute (attribute ("""ExtUnitSymbolKind.VAhPerRev"""))_
    val VAr = parse_attribute (attribute ("""ExtUnitSymbolKind.VAr"""))_
    val VArh = parse_attribute (attribute ("""ExtUnitSymbolKind.VArh"""))_
    val VArhPerRev = parse_attribute (attribute ("""ExtUnitSymbolKind.VArhPerRev"""))_
    val VPerHz = parse_attribute (attribute ("""ExtUnitSymbolKind.VPerHz"""))_
    val VPerV = parse_attribute (attribute ("""ExtUnitSymbolKind.VPerV"""))_
    val Vs = parse_attribute (attribute ("""ExtUnitSymbolKind.Vs"""))_
    val W = parse_attribute (attribute ("""ExtUnitSymbolKind.W"""))_
    val WPerSec = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerSec"""))_
    val WPerVA = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerVA"""))_
    val WPerW = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerW"""))_
    val Wh = parse_attribute (attribute ("""ExtUnitSymbolKind.Wh"""))_
    val WhPerM3 = parse_attribute (attribute ("""ExtUnitSymbolKind.WhPerM3"""))_
    val WhPerRev = parse_attribute (attribute ("""ExtUnitSymbolKind.WhPerRev"""))_
    def parse (context: Context): ExtUnitSymbolKind =
    {
        ExtUnitSymbolKind(
            sup (context),
            aPerM (context),
            b (context),
            bm (context),
            bq (context),
            btu (context),
            btuPerH (context),
            cd (context),
            char (context),
            charPerSec (context),
            code (context),
            cosTheta (context),
            count (context),
            deg (context),
            degC (context),
            ft3 (context),
            ft3compensated (context),
            ft3compensatedPerH (context),
            g (context),
            gM2 (context),
            gPerG (context),
            gy (context),
            h (context),
            imperialGal (context),
            imperialGalPerH (context),
            jPerK (context),
            jPerKg (context),
            kat (context),
            kgM (context),
            kgPerM3 (context),
            litre (context),
            litreCompensated (context),
            litreCompensatedPerH (context),
            litrePerH (context),
            litrePerLitre (context),
            litrePerSec (context),
            litreUncompensated (context),
            litreUncompensatedPerH (context),
            lm (context),
            lx (context),
            m (context),
            m2 (context),
            m2PerSec (context),
            m3 (context),
            m3PerH (context),
            m3PerSec (context),
            m3compensated (context),
            m3compensatedPerH (context),
            m3uncompensated (context),
            m3uncompensatedPerH (context),
            mPerM (context),
            mPerM3 (context),
            mPerSec (context),
            mPerSec2 (context),
            meCode (context),
            min (context),
            mol (context),
            molPerKg (context),
            molPerM3 (context),
            molPerMol (context),
            money (context),
            n (context),
            none (context),
            ohm (context),
            ohmM (context),
            pa (context),
            paA (context),
            paG (context),
            psiA (context),
            psiG (context),
            q (context),
            q45 (context),
            q45h (context),
            q60 (context),
            q60h (context),
            qh (context),
            rad (context),
            radPerSec (context),
            rev (context),
            revPerSec (context),
            sec (context),
            secPerSec (context),
            siemens (context),
            sr (context),
            status (context),
            sv (context),
            t (context),
            therm (context),
            timeStamp (context),
            usGal (context),
            usGalPerH (context),
            wPerMK (context),
            wb (context),
            A (context),
            A2 (context),
            A2h (context),
            A2s (context),
            APerA (context),
            Ah (context),
            As (context),
            F (context),
            H (context),
            Hz (context),
            HzPerHz (context),
            HzPerSec (context),
            J (context),
            K (context),
            V (context),
            V2 (context),
            V2h (context),
            VA (context),
            VAh (context),
            VAhPerRev (context),
            VAr (context),
            VArh (context),
            VArhPerRev (context),
            VPerHz (context),
            VPerV (context),
            Vs (context),
            W (context),
            WPerSec (context),
            WPerVA (context),
            WPerW (context),
            Wh (context),
            WhPerM3 (context),
            WhPerRev (context)
        )
    }
}

object _ExistingEnumExtensions
{
    def register: Unit =
    {
        ExtPhaseCodeKind.register
        ExtUnitMultiplierKind.register
        ExtUnitSymbolKind.register
    }
}