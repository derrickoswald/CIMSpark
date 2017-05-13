package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Enumeration of phase identifiers.
 * Allows designation of phases for both transmission and distribution equipment, circuits and loads.
 * @param sup Reference to the superclass object.
 * @param none Not applicable to any phase
 * @param A Phase A.
 * @param AB Phases A to B
 * @param ABC Involving all phases
 * @param ABCN ABC to Neutral
 * @param ABN AB to Neutral
 * @param AC Phases A and C
 * @param ACN Phases A, C and neutral.
 * @param AN Phases A to neutral.
 * @param AtoAv Phase A current relative to Phase A voltage
 * @param B Phase B.
 * @param BAv Phase B current or voltage relative to Phase A voltage
 * @param BC Phases B to C
 * @param BCN BC to neutral.
 * @param BN Phases B to neutral.
 * @param C Phase C.
 * @param CAN CA to Neutral
 * @param CAv hase C current or voltage relative to Phase A voltage
 * @param CN Phases C to neutral.
 * @param N Neutral
 * @param NG Neutral to ground
 * @param S1 Phase S1
 * @param S12 Phase S1 to S2
 * @param S12N Phase S1, S2 to neutral.
 * @param S1N Phase S1 to Neutral
 * @param S2 Phase S2.
 * @param S2N Phase S2 to neutral.
 */
case class ExtPhaseCodeKind
(override val sup: BasicElement,
val none: String,
val A: String,
val AB: String,
val ABC: String,
val ABCN: String,
val ABN: String,
val AC: String,
val ACN: String,
val AN: String,
val AtoAv: String,
val B: String,
val BAv: String,
val BC: String,
val BCN: String,
val BN: String,
val C: String,
val CAN: String,
val CAv: String,
val CN: String,
val N: String,
val NG: String,
val S1: String,
val S12: String,
val S12N: String,
val S1N: String,
val S2: String,
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
 * @param sup Reference to the superclass object.
 * @param c Centi 10**-2
 * @param d Deci 10**-1
 * @param da deca 10**1
 * @param h hecto 10**2
 * @param k Kilo 10**3
 * @param m Milli 10**-3
 * @param micro Micro 10**-6
 * @param n Nano 10**-9
 * @param none Not Applicable or "x1"
 * @param p Pico 10**-12
 * @param G Giga 10**9
 * @param M Mega 10**6
 * @param T Tera 10**12
 */
case class ExtUnitMultiplierKind
(override val sup: BasicElement,
val c: String,
val d: String,
val da: String,
val h: String,
val k: String,
val m: String,
val micro: String,
val n: String,
val none: String,
val p: String,
val G: String,
val M: String,
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
 * @param sup Reference to the superclass object.
 * @param aPerM A/m, magnetic field strength, Ampere per metre, A/m
 * @param b Sound pressure level, Bel, acoustic, Combine with multiplier prefix �d� to form decibels of Sound Pressure Level
 *        �dB (SPL).�, B (SPL)
 * @param bm Signal Strength, Bel-mW, normalized to 1mW.
 *        Note: to form �dBm� combine �Bm� with multiplier �d�. Bm
 * @param bq Radioactivity, Becquerel (1/s), Bq
 * @param btu Energy, British Thermal Units, BTU
 * @param btuPerH Power, BTU per hour, BTU/h
 * @param cd Luminous intensity, candela, cd
 * @param char Number of characters, characters, char
 * @param charPerSec Data rate, characters per second, char/s
 * @param code Application Value, encoded value, code
 * @param cosTheta Power factor, Dimensionless &lt;img src="HTS_1.
 *        PNG" width="64" height="29" border="0" alt="graphic"/&gt;, cos?
 * @param count Amount of substance, counter value, count
 * @param deg Plane angle, degrees, deg
 * @param degC Relative temperature in degrees Celsius.
 *        In the SI unit system the symbol is �C. Electric charge is measured in coulomb that has the unit symbol C. To destinguish degree Celsius form coulomb the symbol used in the UML is degC. Reason for not using �C is the special character � is difficult to manage in software.
 * @param ft3 Volume, cubic feet, ft�
 * @param ft3compensated Volume, cubic feet, ft�(compensated)
 * @param ft3compensatedPerH Volumetric flow rate, compensated cubic feet per hour, ft�(compensated)/h
 * @param g Mass in gram, g
 * @param gM2 Turbine inertia, gram�meter2 (Combine with multiplier prefix �k� to form kg�m2.), gm�
 * @param gPerG Concentration, The ratio of the mass of a solute divided by the mass of the solution., g/g
 * @param gy Absorbed dose, Gray (J/kg), GY
 * @param h Time, hour = minute * 60, h
 * @param imperialGal Volume, imperial gallons, ImperialGal
 * @param imperialGalPerH Volumetric flow rate, Imperial gallons per hour, ImperialGal/h
 * @param jPerK Heat capacity, Joule/Kelvin, J/K
 * @param jPerKg Specific energy, Joules / kg, J/kg
 * @param kat Catalytic activity, katal = mol / s, kat
 * @param kgM Moment of mass ,kilogram meter (kg�m), M
 * @param kgPerM3 Density, gram/cubic meter (combine with prefix multiplier �k� to form kg/ m�), g/m�
 * @param litre Volume, litre = dm3 = m3/1000., L
 * @param litreCompensated Volume, litre, with the value compensated for weather effects, L(compensated)
 * @param litreCompensatedPerH Volumetric flow rate, litres (compensated) per hour, L(compensated)/h
 * @param litrePerH Volumetric flow rate, litres per hour, L/h
 * @param litrePerLitre Concentration, The ratio of the volume of a solute divided by the volume of  the solution., L/L
 * @param litrePerSec Volumetric flow rate, Volumetric flow rate, L/s
 * @param litreUncompensated Volume, litre, with the value uncompensated for weather effects., L(uncompensated)
 * @param litreUncompensatedPerH Volumetric flow rate, litres (uncompensated) per hour, L(uncompensated)/h
 * @param lm Luminous flux, lumen (cd sr), Lm
 * @param lx Illuminance lux, (lm/m�), L(uncompensated)/h
 * @param m Length, meter, m
 * @param m2 Area, square meter, m�
 * @param m2PerSec Viscosity, meter squared / second, m�/s
 *        m�/h
 * @param m3 Volume, cubic meter, m�
 * @param m3PerH Volumetric flow rate, cubic meters per hour, m�/h
 * @param m3PerSec m3PerSec, cubic meters per second, m�/s
 * @param m3compensated Volume, cubic meter, with the value compensated for weather effects., m3(compensated)
 * @param m3compensatedPerH Volumetric flow rate, compensated cubic meters per hour, �(compensated)/h
 * @param m3uncompensated m3uncompensated, cubic meter, with the value uncompensated for weather effects., m3(uncompensated)
 * @param m3uncompensatedPerH Volumetric flow rate, uncompensated cubic meters per hour, m�(uncompensated)/h
 * @param mPerM Length, Ratio of length, m/m
 * @param mPerM3 Fuel efficiency, meters / cubic meter, m/m�
 * @param mPerSec Velocity, meters per second (m/s), m/s
 * @param mPerSec2 Acceleration, meters per second squared, m/s�
 * @param meCode EndDeviceEvent, value to be interpreted as a EndDeviceEventCode, meCode
 * @param min Time, minute  = s * 60, min
 * @param mol Amount of substance, mole, mol
 * @param molPerKg Concentration, Molality, the amount of solute in moles and the amount of solvent in kilograms., mol/kg
 * @param molPerM3 Concentration, The amount of substance concentration, (c), the amount of solvent in moles divided by the volume of solution in m�., mol/ m�
 * @param molPerMol Concentration, Molar fraction (?), the ratio of the molar amount of a solute divided by the molar amount of the solution.,mol/mol
 * @param money Monetary unit, Generic money (Note: Specific monetary units are identified the currency class)., �
 * @param n Force newton, (kg m/s�), N
 * @param none N/A, None
 * @param ohm Electric resistance, Ohm (V/A), O
 * @param ohmM resistivity, ? (rho), ?m
 * @param pa Pressure, Pascal (N/m�)
(Note: the absolute or relative measurement of pressure is implied with this entry.
 *        See below for more explicit forms.), Pa
 * @param paA Pressure, Pascal, absolute pressure, PaA
 * @param paG Pressure, Pascal, gauge pressure, PaG
 * @param psiA Pressure, Pounds per square inch, absolute, psiA
 * @param psiG Pressure, Pounds per square inch, gauge, psiG
 * @param q Quantity power, Q, Q
 * @param q45 Quantity power, Q measured at 45�, Q45
 * @param q45h Quantity energy, Q measured at 45�, Q45h
 * @param q60 Quantity power, Q measured at 60�, Q60
 * @param q60h Quantity energy, Qh measured at 60�, Q60h
 * @param qh Quantity energy, Qh, Qh
 * @param rad Plane angle, Radian (m/m), rad
 * @param radPerSec Angular velocity, radians per second, rad/s
 * @param rev Amount of rotation, Revolutions, rev
 * @param revPerSec Rotational speed, Rotations per second, rev/s
 * @param sec Time,  seconds, s
 * @param secPerSec Time, Ratio of time (can be combined with an multiplier prefix to show rates such as a clock drift rate, e.g. ��s/s�), s/s
 * @param siemens Electric conductance, Siemens (A / V = 1 / O), S
 * @param sr Solid angle, Steradian (m2/m2), sr
 * @param status State, "1" = "true", "live", "on", "high", "set"; 
"0" = "false", "dead", "off", "low", "cleared"
 *        Note: A Boolean value is preferred but other values may be supported, status
 * @param sv Doe equivalent, Sievert (J/kg), Sv
 * @param t Magnetic flux density, Tesla (Wb/m2), T
 * @param therm Energy, Therm, therm
 * @param timeStamp Timestamp, time and date per ISO 8601 format, timeStamp
 * @param usGal Volume, US gallons, <u>Gal</u>
 * @param usGalPerH Volumetric flow rate, US gallons per hour, USGal/h
 * @param wPerMK Thermal conductivity, Watt/meter Kelvin, W/m K
 * @param wb Magnetic flux, Weber (V s)<b>, Wb</b>
 * @param A Current, ampere, A
 * @param A2 Amps squared,  amp squared, A2
 * @param A2h ampere-squared, Ampere-squared hour, A�h
 * @param A2s Amps squared time, square amp second, A�s
 * @param APerA Current, Ratio of Amperages, A/A
 * @param Ah Ampere-hours, Ampere-hours, Ah
 * @param As Amp seconds, amp seconds, As
 * @param F Electric capacitance, Farad (C/V), �C
 * @param H Electric inductance, Henry (Wb/A), H
 * @param Hz Frequency hertz, (1/s), Hz
 * @param HzPerHz Frequency, Rate of frequency change, Hz/Hz
 * @param HzPerSec Rate of change of frequency, hertz per second, Hz/s
 * @param J Energy joule, (N�m = C�V = W�s), J
 * @param K Temperature, Kelvin, K
 * @param V Electric potential, Volt (W/A), V
 * @param V2 Volts squared, Volt squared (W2/A2), V�
 * @param V2h volt-squared hour, Volt-squared-hours, V�h
 * @param VA Apparent power, Volt Ampere (See also real power and reactive power.), VA
 * @param VAh Apparent energy, Volt Ampere hours, VAh
 * @param VAhPerRev Kh-Vah, apparent energy metering constant, VAh/rev
 * @param VAr Reactive power, Volt Ampere reactive.
 *        The �reactive� or �imaginary� component of electrical power (VISin?). (See also real power and apparent power)., VAr
 * @param VArh Reactive energy, Volt Ampere reactive hours, VArh
 * @param VArhPerRev Kh-VArh, reactive energy metering constant, VArh/rev
 * @param VPerHz Magnetic flux, Volts per Hertz, V/Hz
 * @param VPerV Voltage, Ratio of voltages (e.g. mV/V), V/V
 * @param Vs Volt seconds, Volt seconds (Ws/A), Vs
 * @param W Real power, Watt.
 *        By definition, one Watt equals oneJoule per second. Electrical power may have real and reactive components. The real portion of electrical power (I�R) or VIcos?, is expressed in Watts. (See also apparent power and reactive power.), W
 * @param WPerSec Ramp rate, Watts per second, W/s
 * @param WPerVA Power Factor, PF, W/VA
 * @param WPerW Signal Strength, Ratio of power, W/W
 * @param Wh Real energy, Watt hours, Wh
 * @param WhPerM3 Wh/m3, energy per volume, Wh/m�
 * @param WhPerRev Kh-Wh, active energy metering constant, Wh/rev
 */
case class ExtUnitSymbolKind
(override val sup: BasicElement,
val aPerM: String,
val b: String,
val bm: String,
val bq: String,
val btu: String,
val btuPerH: String,
val cd: String,
val char: String,
val charPerSec: String,
val code: String,
val cosTheta: String,
val count: String,
val deg: String,
val degC: String,
val ft3: String,
val ft3compensated: String,
val ft3compensatedPerH: String,
val g: String,
val gM2: String,
val gPerG: String,
val gy: String,
val h: String,
val imperialGal: String,
val imperialGalPerH: String,
val jPerK: String,
val jPerKg: String,
val kat: String,
val kgM: String,
val kgPerM3: String,
val litre: String,
val litreCompensated: String,
val litreCompensatedPerH: String,
val litrePerH: String,
val litrePerLitre: String,
val litrePerSec: String,
val litreUncompensated: String,
val litreUncompensatedPerH: String,
val lm: String,
val lx: String,
val m: String,
val m2: String,
val m2PerSec: String,
val m3: String,
val m3PerH: String,
val m3PerSec: String,
val m3compensated: String,
val m3compensatedPerH: String,
val m3uncompensated: String,
val m3uncompensatedPerH: String,
val mPerM: String,
val mPerM3: String,
val mPerSec: String,
val mPerSec2: String,
val meCode: String,
val min: String,
val mol: String,
val molPerKg: String,
val molPerM3: String,
val molPerMol: String,
val money: String,
val n: String,
val none: String,
val ohm: String,
val ohmM: String,
val pa: String,
val paA: String,
val paG: String,
val psiA: String,
val psiG: String,
val q: String,
val q45: String,
val q45h: String,
val q60: String,
val q60h: String,
val qh: String,
val rad: String,
val radPerSec: String,
val rev: String,
val revPerSec: String,
val sec: String,
val secPerSec: String,
val siemens: String,
val sr: String,
val status: String,
val sv: String,
val t: String,
val therm: String,
val timeStamp: String,
val usGal: String,
val usGalPerH: String,
val wPerMK: String,
val wb: String,
val A: String,
val A2: String,
val A2h: String,
val A2s: String,
val APerA: String,
val Ah: String,
val As: String,
val F: String,
val H: String,
val Hz: String,
val HzPerHz: String,
val HzPerSec: String,
val J: String,
val K: String,
val V: String,
val V2: String,
val V2h: String,
val VA: String,
val VAh: String,
val VAhPerRev: String,
val VAr: String,
val VArh: String,
val VArhPerRev: String,
val VPerHz: String,
val VPerV: String,
val Vs: String,
val W: String,
val WPerSec: String,
val WPerVA: String,
val WPerW: String,
val Wh: String,
val WhPerM3: String,
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