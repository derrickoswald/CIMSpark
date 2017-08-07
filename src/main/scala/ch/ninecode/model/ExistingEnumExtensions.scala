package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


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
(
    override val sup: BasicElement,
    none: String,
    A: String,
    AB: String,
    ABC: String,
    ABCN: String,
    ABN: String,
    AC: String,
    ACN: String,
    AN: String,
    AtoAv: String,
    B: String,
    BAv: String,
    BC: String,
    BCN: String,
    BN: String,
    C: String,
    CAN: String,
    CAv: String,
    CN: String,
    N: String,
    NG: String,
    S1: String,
    S12: String,
    S12N: String,
    S1N: String,
    S2: String,
    S2N: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExtPhaseCodeKind] }
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
        (if (null != none) "\t\t<cim:ExtPhaseCodeKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != A) "\t\t<cim:ExtPhaseCodeKind.A rdf:resource=\"#" + A + "\"/>\n" else "") +
        (if (null != AB) "\t\t<cim:ExtPhaseCodeKind.AB rdf:resource=\"#" + AB + "\"/>\n" else "") +
        (if (null != ABC) "\t\t<cim:ExtPhaseCodeKind.ABC rdf:resource=\"#" + ABC + "\"/>\n" else "") +
        (if (null != ABCN) "\t\t<cim:ExtPhaseCodeKind.ABCN rdf:resource=\"#" + ABCN + "\"/>\n" else "") +
        (if (null != ABN) "\t\t<cim:ExtPhaseCodeKind.ABN rdf:resource=\"#" + ABN + "\"/>\n" else "") +
        (if (null != AC) "\t\t<cim:ExtPhaseCodeKind.AC rdf:resource=\"#" + AC + "\"/>\n" else "") +
        (if (null != ACN) "\t\t<cim:ExtPhaseCodeKind.ACN rdf:resource=\"#" + ACN + "\"/>\n" else "") +
        (if (null != AN) "\t\t<cim:ExtPhaseCodeKind.AN rdf:resource=\"#" + AN + "\"/>\n" else "") +
        (if (null != AtoAv) "\t\t<cim:ExtPhaseCodeKind.AtoAv rdf:resource=\"#" + AtoAv + "\"/>\n" else "") +
        (if (null != B) "\t\t<cim:ExtPhaseCodeKind.B rdf:resource=\"#" + B + "\"/>\n" else "") +
        (if (null != BAv) "\t\t<cim:ExtPhaseCodeKind.BAv rdf:resource=\"#" + BAv + "\"/>\n" else "") +
        (if (null != BC) "\t\t<cim:ExtPhaseCodeKind.BC rdf:resource=\"#" + BC + "\"/>\n" else "") +
        (if (null != BCN) "\t\t<cim:ExtPhaseCodeKind.BCN rdf:resource=\"#" + BCN + "\"/>\n" else "") +
        (if (null != BN) "\t\t<cim:ExtPhaseCodeKind.BN rdf:resource=\"#" + BN + "\"/>\n" else "") +
        (if (null != C) "\t\t<cim:ExtPhaseCodeKind.C rdf:resource=\"#" + C + "\"/>\n" else "") +
        (if (null != CAN) "\t\t<cim:ExtPhaseCodeKind.CAN rdf:resource=\"#" + CAN + "\"/>\n" else "") +
        (if (null != CAv) "\t\t<cim:ExtPhaseCodeKind.CAv rdf:resource=\"#" + CAv + "\"/>\n" else "") +
        (if (null != CN) "\t\t<cim:ExtPhaseCodeKind.CN rdf:resource=\"#" + CN + "\"/>\n" else "") +
        (if (null != N) "\t\t<cim:ExtPhaseCodeKind.N rdf:resource=\"#" + N + "\"/>\n" else "") +
        (if (null != NG) "\t\t<cim:ExtPhaseCodeKind.NG rdf:resource=\"#" + NG + "\"/>\n" else "") +
        (if (null != S1) "\t\t<cim:ExtPhaseCodeKind.S1 rdf:resource=\"#" + S1 + "\"/>\n" else "") +
        (if (null != S12) "\t\t<cim:ExtPhaseCodeKind.S12 rdf:resource=\"#" + S12 + "\"/>\n" else "") +
        (if (null != S12N) "\t\t<cim:ExtPhaseCodeKind.S12N rdf:resource=\"#" + S12N + "\"/>\n" else "") +
        (if (null != S1N) "\t\t<cim:ExtPhaseCodeKind.S1N rdf:resource=\"#" + S1N + "\"/>\n" else "") +
        (if (null != S2) "\t\t<cim:ExtPhaseCodeKind.S2 rdf:resource=\"#" + S2 + "\"/>\n" else "") +
        (if (null != S2N) "\t\t<cim:ExtPhaseCodeKind.S2N rdf:resource=\"#" + S2N + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExtPhaseCodeKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExtPhaseCodeKind>\n"
    }
}

object ExtPhaseCodeKind
extends
    Parseable[ExtPhaseCodeKind]
{
    val none: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.none"""))
    val A: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.A"""))
    val AB: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.AB"""))
    val ABC: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.ABC"""))
    val ABCN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.ABCN"""))
    val ABN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.ABN"""))
    val AC: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.AC"""))
    val ACN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.ACN"""))
    val AN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.AN"""))
    val AtoAv: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.AtoAv"""))
    val B: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.B"""))
    val BAv: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.BAv"""))
    val BC: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.BC"""))
    val BCN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.BCN"""))
    val BN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.BN"""))
    val C: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.C"""))
    val CAN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.CAN"""))
    val CAv: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.CAv"""))
    val CN: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.CN"""))
    val N: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.N"""))
    val NG: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.NG"""))
    val S1: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S1"""))
    val S12: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S12"""))
    val S12N: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S12N"""))
    val S1N: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S1N"""))
    val S2: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S2"""))
    val S2N: (Context) => String = parse_attribute (attribute ("""ExtPhaseCodeKind.S2N"""))
    def parse (context: Context): ExtPhaseCodeKind =
    {
        ExtPhaseCodeKind(
            BasicElement.parse (context),
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
(
    override val sup: BasicElement,
    c: String,
    d: String,
    da: String,
    h: String,
    k: String,
    m: String,
    micro: String,
    n: String,
    none: String,
    p: String,
    G: String,
    M: String,
    T: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExtUnitMultiplierKind] }
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
        (if (null != c) "\t\t<cim:ExtUnitMultiplierKind.c rdf:resource=\"#" + c + "\"/>\n" else "") +
        (if (null != d) "\t\t<cim:ExtUnitMultiplierKind.d rdf:resource=\"#" + d + "\"/>\n" else "") +
        (if (null != da) "\t\t<cim:ExtUnitMultiplierKind.da rdf:resource=\"#" + da + "\"/>\n" else "") +
        (if (null != h) "\t\t<cim:ExtUnitMultiplierKind.h rdf:resource=\"#" + h + "\"/>\n" else "") +
        (if (null != k) "\t\t<cim:ExtUnitMultiplierKind.k rdf:resource=\"#" + k + "\"/>\n" else "") +
        (if (null != m) "\t\t<cim:ExtUnitMultiplierKind.m rdf:resource=\"#" + m + "\"/>\n" else "") +
        (if (null != micro) "\t\t<cim:ExtUnitMultiplierKind.micro rdf:resource=\"#" + micro + "\"/>\n" else "") +
        (if (null != n) "\t\t<cim:ExtUnitMultiplierKind.n rdf:resource=\"#" + n + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:ExtUnitMultiplierKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != p) "\t\t<cim:ExtUnitMultiplierKind.p rdf:resource=\"#" + p + "\"/>\n" else "") +
        (if (null != G) "\t\t<cim:ExtUnitMultiplierKind.G rdf:resource=\"#" + G + "\"/>\n" else "") +
        (if (null != M) "\t\t<cim:ExtUnitMultiplierKind.M rdf:resource=\"#" + M + "\"/>\n" else "") +
        (if (null != T) "\t\t<cim:ExtUnitMultiplierKind.T rdf:resource=\"#" + T + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExtUnitMultiplierKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExtUnitMultiplierKind>\n"
    }
}

object ExtUnitMultiplierKind
extends
    Parseable[ExtUnitMultiplierKind]
{
    val c: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.c"""))
    val d: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.d"""))
    val da: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.da"""))
    val h: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.h"""))
    val k: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.k"""))
    val m: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.m"""))
    val micro: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.micro"""))
    val n: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.n"""))
    val none: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.none"""))
    val p: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.p"""))
    val G: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.G"""))
    val M: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.M"""))
    val T: (Context) => String = parse_attribute (attribute ("""ExtUnitMultiplierKind.T"""))
    def parse (context: Context): ExtUnitMultiplierKind =
    {
        ExtUnitMultiplierKind(
            BasicElement.parse (context),
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
 * @param char1 Number of characters, characters, char
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
(
    override val sup: BasicElement,
    aPerM: String,
    b: String,
    bm: String,
    bq: String,
    btu: String,
    btuPerH: String,
    cd: String,
    char1: String,
    charPerSec: String,
    code: String,
    cosTheta: String,
    count: String,
    deg: String,
    degC: String,
    ft3: String,
    ft3compensated: String,
    ft3compensatedPerH: String,
    g: String,
    gM2: String,
    gPerG: String,
    gy: String,
    h: String,
    imperialGal: String,
    imperialGalPerH: String,
    jPerK: String,
    jPerKg: String,
    kat: String,
    kgM: String,
    kgPerM3: String,
    litre: String,
    litreCompensated: String,
    litreCompensatedPerH: String,
    litrePerH: String,
    litrePerLitre: String,
    litrePerSec: String,
    litreUncompensated: String,
    litreUncompensatedPerH: String,
    lm: String,
    lx: String,
    m: String,
    m2: String,
    m2PerSec: String,
    m3: String,
    m3PerH: String,
    m3PerSec: String,
    m3compensated: String,
    m3compensatedPerH: String,
    m3uncompensated: String,
    m3uncompensatedPerH: String,
    mPerM: String,
    mPerM3: String,
    mPerSec: String,
    mPerSec2: String,
    meCode: String,
    min: String,
    mol: String,
    molPerKg: String,
    molPerM3: String,
    molPerMol: String,
    money: String,
    n: String,
    none: String,
    ohm: String,
    ohmM: String,
    pa: String,
    paA: String,
    paG: String,
    psiA: String,
    psiG: String,
    q: String,
    q45: String,
    q45h: String,
    q60: String,
    q60h: String,
    qh: String,
    rad: String,
    radPerSec: String,
    rev: String,
    revPerSec: String,
    sec: String,
    secPerSec: String,
    siemens: String,
    sr: String,
    status: String,
    sv: String,
    t: String,
    therm: String,
    timeStamp: String,
    usGal: String,
    usGalPerH: String,
    wPerMK: String,
    wb: String,
    A: String,
    A2: String,
    A2h: String,
    A2s: String,
    APerA: String,
    Ah: String,
    As: String,
    F: String,
    H: String,
    Hz: String,
    HzPerHz: String,
    HzPerSec: String,
    J: String,
    K: String,
    V: String,
    V2: String,
    V2h: String,
    VA: String,
    VAh: String,
    VAhPerRev: String,
    VAr: String,
    VArh: String,
    VArhPerRev: String,
    VPerHz: String,
    VPerV: String,
    Vs: String,
    W: String,
    WPerSec: String,
    WPerVA: String,
    WPerW: String,
    Wh: String,
    WhPerM3: String,
    WhPerRev: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExtUnitSymbolKind] }
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
        (if (null != aPerM) "\t\t<cim:ExtUnitSymbolKind.aPerM rdf:resource=\"#" + aPerM + "\"/>\n" else "") +
        (if (null != b) "\t\t<cim:ExtUnitSymbolKind.b rdf:resource=\"#" + b + "\"/>\n" else "") +
        (if (null != bm) "\t\t<cim:ExtUnitSymbolKind.bm rdf:resource=\"#" + bm + "\"/>\n" else "") +
        (if (null != bq) "\t\t<cim:ExtUnitSymbolKind.bq rdf:resource=\"#" + bq + "\"/>\n" else "") +
        (if (null != btu) "\t\t<cim:ExtUnitSymbolKind.btu rdf:resource=\"#" + btu + "\"/>\n" else "") +
        (if (null != btuPerH) "\t\t<cim:ExtUnitSymbolKind.btuPerH rdf:resource=\"#" + btuPerH + "\"/>\n" else "") +
        (if (null != cd) "\t\t<cim:ExtUnitSymbolKind.cd rdf:resource=\"#" + cd + "\"/>\n" else "") +
        (if (null != char1) "\t\t<cim:ExtUnitSymbolKind.char rdf:resource=\"#" + char1 + "\"/>\n" else "") +
        (if (null != charPerSec) "\t\t<cim:ExtUnitSymbolKind.charPerSec rdf:resource=\"#" + charPerSec + "\"/>\n" else "") +
        (if (null != code) "\t\t<cim:ExtUnitSymbolKind.code rdf:resource=\"#" + code + "\"/>\n" else "") +
        (if (null != cosTheta) "\t\t<cim:ExtUnitSymbolKind.cosTheta rdf:resource=\"#" + cosTheta + "\"/>\n" else "") +
        (if (null != count) "\t\t<cim:ExtUnitSymbolKind.count rdf:resource=\"#" + count + "\"/>\n" else "") +
        (if (null != deg) "\t\t<cim:ExtUnitSymbolKind.deg rdf:resource=\"#" + deg + "\"/>\n" else "") +
        (if (null != degC) "\t\t<cim:ExtUnitSymbolKind.degC rdf:resource=\"#" + degC + "\"/>\n" else "") +
        (if (null != ft3) "\t\t<cim:ExtUnitSymbolKind.ft3 rdf:resource=\"#" + ft3 + "\"/>\n" else "") +
        (if (null != ft3compensated) "\t\t<cim:ExtUnitSymbolKind.ft3compensated rdf:resource=\"#" + ft3compensated + "\"/>\n" else "") +
        (if (null != ft3compensatedPerH) "\t\t<cim:ExtUnitSymbolKind.ft3compensatedPerH rdf:resource=\"#" + ft3compensatedPerH + "\"/>\n" else "") +
        (if (null != g) "\t\t<cim:ExtUnitSymbolKind.g rdf:resource=\"#" + g + "\"/>\n" else "") +
        (if (null != gM2) "\t\t<cim:ExtUnitSymbolKind.gM2 rdf:resource=\"#" + gM2 + "\"/>\n" else "") +
        (if (null != gPerG) "\t\t<cim:ExtUnitSymbolKind.gPerG rdf:resource=\"#" + gPerG + "\"/>\n" else "") +
        (if (null != gy) "\t\t<cim:ExtUnitSymbolKind.gy rdf:resource=\"#" + gy + "\"/>\n" else "") +
        (if (null != h) "\t\t<cim:ExtUnitSymbolKind.h rdf:resource=\"#" + h + "\"/>\n" else "") +
        (if (null != imperialGal) "\t\t<cim:ExtUnitSymbolKind.imperialGal rdf:resource=\"#" + imperialGal + "\"/>\n" else "") +
        (if (null != imperialGalPerH) "\t\t<cim:ExtUnitSymbolKind.imperialGalPerH rdf:resource=\"#" + imperialGalPerH + "\"/>\n" else "") +
        (if (null != jPerK) "\t\t<cim:ExtUnitSymbolKind.jPerK rdf:resource=\"#" + jPerK + "\"/>\n" else "") +
        (if (null != jPerKg) "\t\t<cim:ExtUnitSymbolKind.jPerKg rdf:resource=\"#" + jPerKg + "\"/>\n" else "") +
        (if (null != kat) "\t\t<cim:ExtUnitSymbolKind.kat rdf:resource=\"#" + kat + "\"/>\n" else "") +
        (if (null != kgM) "\t\t<cim:ExtUnitSymbolKind.kgM rdf:resource=\"#" + kgM + "\"/>\n" else "") +
        (if (null != kgPerM3) "\t\t<cim:ExtUnitSymbolKind.kgPerM3 rdf:resource=\"#" + kgPerM3 + "\"/>\n" else "") +
        (if (null != litre) "\t\t<cim:ExtUnitSymbolKind.litre rdf:resource=\"#" + litre + "\"/>\n" else "") +
        (if (null != litreCompensated) "\t\t<cim:ExtUnitSymbolKind.litreCompensated rdf:resource=\"#" + litreCompensated + "\"/>\n" else "") +
        (if (null != litreCompensatedPerH) "\t\t<cim:ExtUnitSymbolKind.litreCompensatedPerH rdf:resource=\"#" + litreCompensatedPerH + "\"/>\n" else "") +
        (if (null != litrePerH) "\t\t<cim:ExtUnitSymbolKind.litrePerH rdf:resource=\"#" + litrePerH + "\"/>\n" else "") +
        (if (null != litrePerLitre) "\t\t<cim:ExtUnitSymbolKind.litrePerLitre rdf:resource=\"#" + litrePerLitre + "\"/>\n" else "") +
        (if (null != litrePerSec) "\t\t<cim:ExtUnitSymbolKind.litrePerSec rdf:resource=\"#" + litrePerSec + "\"/>\n" else "") +
        (if (null != litreUncompensated) "\t\t<cim:ExtUnitSymbolKind.litreUncompensated rdf:resource=\"#" + litreUncompensated + "\"/>\n" else "") +
        (if (null != litreUncompensatedPerH) "\t\t<cim:ExtUnitSymbolKind.litreUncompensatedPerH rdf:resource=\"#" + litreUncompensatedPerH + "\"/>\n" else "") +
        (if (null != lm) "\t\t<cim:ExtUnitSymbolKind.lm rdf:resource=\"#" + lm + "\"/>\n" else "") +
        (if (null != lx) "\t\t<cim:ExtUnitSymbolKind.lx rdf:resource=\"#" + lx + "\"/>\n" else "") +
        (if (null != m) "\t\t<cim:ExtUnitSymbolKind.m rdf:resource=\"#" + m + "\"/>\n" else "") +
        (if (null != m2) "\t\t<cim:ExtUnitSymbolKind.m2 rdf:resource=\"#" + m2 + "\"/>\n" else "") +
        (if (null != m2PerSec) "\t\t<cim:ExtUnitSymbolKind.m2PerSec rdf:resource=\"#" + m2PerSec + "\"/>\n" else "") +
        (if (null != m3) "\t\t<cim:ExtUnitSymbolKind.m3 rdf:resource=\"#" + m3 + "\"/>\n" else "") +
        (if (null != m3PerH) "\t\t<cim:ExtUnitSymbolKind.m3PerH rdf:resource=\"#" + m3PerH + "\"/>\n" else "") +
        (if (null != m3PerSec) "\t\t<cim:ExtUnitSymbolKind.m3PerSec rdf:resource=\"#" + m3PerSec + "\"/>\n" else "") +
        (if (null != m3compensated) "\t\t<cim:ExtUnitSymbolKind.m3compensated rdf:resource=\"#" + m3compensated + "\"/>\n" else "") +
        (if (null != m3compensatedPerH) "\t\t<cim:ExtUnitSymbolKind.m3compensatedPerH rdf:resource=\"#" + m3compensatedPerH + "\"/>\n" else "") +
        (if (null != m3uncompensated) "\t\t<cim:ExtUnitSymbolKind.m3uncompensated rdf:resource=\"#" + m3uncompensated + "\"/>\n" else "") +
        (if (null != m3uncompensatedPerH) "\t\t<cim:ExtUnitSymbolKind.m3uncompensatedPerH rdf:resource=\"#" + m3uncompensatedPerH + "\"/>\n" else "") +
        (if (null != mPerM) "\t\t<cim:ExtUnitSymbolKind.mPerM rdf:resource=\"#" + mPerM + "\"/>\n" else "") +
        (if (null != mPerM3) "\t\t<cim:ExtUnitSymbolKind.mPerM3 rdf:resource=\"#" + mPerM3 + "\"/>\n" else "") +
        (if (null != mPerSec) "\t\t<cim:ExtUnitSymbolKind.mPerSec rdf:resource=\"#" + mPerSec + "\"/>\n" else "") +
        (if (null != mPerSec2) "\t\t<cim:ExtUnitSymbolKind.mPerSec2 rdf:resource=\"#" + mPerSec2 + "\"/>\n" else "") +
        (if (null != meCode) "\t\t<cim:ExtUnitSymbolKind.meCode rdf:resource=\"#" + meCode + "\"/>\n" else "") +
        (if (null != min) "\t\t<cim:ExtUnitSymbolKind.min rdf:resource=\"#" + min + "\"/>\n" else "") +
        (if (null != mol) "\t\t<cim:ExtUnitSymbolKind.mol rdf:resource=\"#" + mol + "\"/>\n" else "") +
        (if (null != molPerKg) "\t\t<cim:ExtUnitSymbolKind.molPerKg rdf:resource=\"#" + molPerKg + "\"/>\n" else "") +
        (if (null != molPerM3) "\t\t<cim:ExtUnitSymbolKind.molPerM3 rdf:resource=\"#" + molPerM3 + "\"/>\n" else "") +
        (if (null != molPerMol) "\t\t<cim:ExtUnitSymbolKind.molPerMol rdf:resource=\"#" + molPerMol + "\"/>\n" else "") +
        (if (null != money) "\t\t<cim:ExtUnitSymbolKind.money rdf:resource=\"#" + money + "\"/>\n" else "") +
        (if (null != n) "\t\t<cim:ExtUnitSymbolKind.n rdf:resource=\"#" + n + "\"/>\n" else "") +
        (if (null != none) "\t\t<cim:ExtUnitSymbolKind.none rdf:resource=\"#" + none + "\"/>\n" else "") +
        (if (null != ohm) "\t\t<cim:ExtUnitSymbolKind.ohm rdf:resource=\"#" + ohm + "\"/>\n" else "") +
        (if (null != ohmM) "\t\t<cim:ExtUnitSymbolKind.ohmM rdf:resource=\"#" + ohmM + "\"/>\n" else "") +
        (if (null != pa) "\t\t<cim:ExtUnitSymbolKind.pa rdf:resource=\"#" + pa + "\"/>\n" else "") +
        (if (null != paA) "\t\t<cim:ExtUnitSymbolKind.paA rdf:resource=\"#" + paA + "\"/>\n" else "") +
        (if (null != paG) "\t\t<cim:ExtUnitSymbolKind.paG rdf:resource=\"#" + paG + "\"/>\n" else "") +
        (if (null != psiA) "\t\t<cim:ExtUnitSymbolKind.psiA rdf:resource=\"#" + psiA + "\"/>\n" else "") +
        (if (null != psiG) "\t\t<cim:ExtUnitSymbolKind.psiG rdf:resource=\"#" + psiG + "\"/>\n" else "") +
        (if (null != q) "\t\t<cim:ExtUnitSymbolKind.q rdf:resource=\"#" + q + "\"/>\n" else "") +
        (if (null != q45) "\t\t<cim:ExtUnitSymbolKind.q45 rdf:resource=\"#" + q45 + "\"/>\n" else "") +
        (if (null != q45h) "\t\t<cim:ExtUnitSymbolKind.q45h rdf:resource=\"#" + q45h + "\"/>\n" else "") +
        (if (null != q60) "\t\t<cim:ExtUnitSymbolKind.q60 rdf:resource=\"#" + q60 + "\"/>\n" else "") +
        (if (null != q60h) "\t\t<cim:ExtUnitSymbolKind.q60h rdf:resource=\"#" + q60h + "\"/>\n" else "") +
        (if (null != qh) "\t\t<cim:ExtUnitSymbolKind.qh rdf:resource=\"#" + qh + "\"/>\n" else "") +
        (if (null != rad) "\t\t<cim:ExtUnitSymbolKind.rad rdf:resource=\"#" + rad + "\"/>\n" else "") +
        (if (null != radPerSec) "\t\t<cim:ExtUnitSymbolKind.radPerSec rdf:resource=\"#" + radPerSec + "\"/>\n" else "") +
        (if (null != rev) "\t\t<cim:ExtUnitSymbolKind.rev rdf:resource=\"#" + rev + "\"/>\n" else "") +
        (if (null != revPerSec) "\t\t<cim:ExtUnitSymbolKind.revPerSec rdf:resource=\"#" + revPerSec + "\"/>\n" else "") +
        (if (null != sec) "\t\t<cim:ExtUnitSymbolKind.sec rdf:resource=\"#" + sec + "\"/>\n" else "") +
        (if (null != secPerSec) "\t\t<cim:ExtUnitSymbolKind.secPerSec rdf:resource=\"#" + secPerSec + "\"/>\n" else "") +
        (if (null != siemens) "\t\t<cim:ExtUnitSymbolKind.siemens rdf:resource=\"#" + siemens + "\"/>\n" else "") +
        (if (null != sr) "\t\t<cim:ExtUnitSymbolKind.sr rdf:resource=\"#" + sr + "\"/>\n" else "") +
        (if (null != status) "\t\t<cim:ExtUnitSymbolKind.status rdf:resource=\"#" + status + "\"/>\n" else "") +
        (if (null != sv) "\t\t<cim:ExtUnitSymbolKind.sv rdf:resource=\"#" + sv + "\"/>\n" else "") +
        (if (null != t) "\t\t<cim:ExtUnitSymbolKind.t rdf:resource=\"#" + t + "\"/>\n" else "") +
        (if (null != therm) "\t\t<cim:ExtUnitSymbolKind.therm rdf:resource=\"#" + therm + "\"/>\n" else "") +
        (if (null != timeStamp) "\t\t<cim:ExtUnitSymbolKind.timeStamp rdf:resource=\"#" + timeStamp + "\"/>\n" else "") +
        (if (null != usGal) "\t\t<cim:ExtUnitSymbolKind.usGal rdf:resource=\"#" + usGal + "\"/>\n" else "") +
        (if (null != usGalPerH) "\t\t<cim:ExtUnitSymbolKind.usGalPerH rdf:resource=\"#" + usGalPerH + "\"/>\n" else "") +
        (if (null != wPerMK) "\t\t<cim:ExtUnitSymbolKind.wPerMK rdf:resource=\"#" + wPerMK + "\"/>\n" else "") +
        (if (null != wb) "\t\t<cim:ExtUnitSymbolKind.wb rdf:resource=\"#" + wb + "\"/>\n" else "") +
        (if (null != A) "\t\t<cim:ExtUnitSymbolKind.A rdf:resource=\"#" + A + "\"/>\n" else "") +
        (if (null != A2) "\t\t<cim:ExtUnitSymbolKind.A2 rdf:resource=\"#" + A2 + "\"/>\n" else "") +
        (if (null != A2h) "\t\t<cim:ExtUnitSymbolKind.A2h rdf:resource=\"#" + A2h + "\"/>\n" else "") +
        (if (null != A2s) "\t\t<cim:ExtUnitSymbolKind.A2s rdf:resource=\"#" + A2s + "\"/>\n" else "") +
        (if (null != APerA) "\t\t<cim:ExtUnitSymbolKind.APerA rdf:resource=\"#" + APerA + "\"/>\n" else "") +
        (if (null != Ah) "\t\t<cim:ExtUnitSymbolKind.Ah rdf:resource=\"#" + Ah + "\"/>\n" else "") +
        (if (null != As) "\t\t<cim:ExtUnitSymbolKind.As rdf:resource=\"#" + As + "\"/>\n" else "") +
        (if (null != F) "\t\t<cim:ExtUnitSymbolKind.F rdf:resource=\"#" + F + "\"/>\n" else "") +
        (if (null != H) "\t\t<cim:ExtUnitSymbolKind.H rdf:resource=\"#" + H + "\"/>\n" else "") +
        (if (null != Hz) "\t\t<cim:ExtUnitSymbolKind.Hz rdf:resource=\"#" + Hz + "\"/>\n" else "") +
        (if (null != HzPerHz) "\t\t<cim:ExtUnitSymbolKind.HzPerHz rdf:resource=\"#" + HzPerHz + "\"/>\n" else "") +
        (if (null != HzPerSec) "\t\t<cim:ExtUnitSymbolKind.HzPerSec rdf:resource=\"#" + HzPerSec + "\"/>\n" else "") +
        (if (null != J) "\t\t<cim:ExtUnitSymbolKind.J rdf:resource=\"#" + J + "\"/>\n" else "") +
        (if (null != K) "\t\t<cim:ExtUnitSymbolKind.K rdf:resource=\"#" + K + "\"/>\n" else "") +
        (if (null != V) "\t\t<cim:ExtUnitSymbolKind.V rdf:resource=\"#" + V + "\"/>\n" else "") +
        (if (null != V2) "\t\t<cim:ExtUnitSymbolKind.V2 rdf:resource=\"#" + V2 + "\"/>\n" else "") +
        (if (null != V2h) "\t\t<cim:ExtUnitSymbolKind.V2h rdf:resource=\"#" + V2h + "\"/>\n" else "") +
        (if (null != VA) "\t\t<cim:ExtUnitSymbolKind.VA rdf:resource=\"#" + VA + "\"/>\n" else "") +
        (if (null != VAh) "\t\t<cim:ExtUnitSymbolKind.VAh rdf:resource=\"#" + VAh + "\"/>\n" else "") +
        (if (null != VAhPerRev) "\t\t<cim:ExtUnitSymbolKind.VAhPerRev rdf:resource=\"#" + VAhPerRev + "\"/>\n" else "") +
        (if (null != VAr) "\t\t<cim:ExtUnitSymbolKind.VAr rdf:resource=\"#" + VAr + "\"/>\n" else "") +
        (if (null != VArh) "\t\t<cim:ExtUnitSymbolKind.VArh rdf:resource=\"#" + VArh + "\"/>\n" else "") +
        (if (null != VArhPerRev) "\t\t<cim:ExtUnitSymbolKind.VArhPerRev rdf:resource=\"#" + VArhPerRev + "\"/>\n" else "") +
        (if (null != VPerHz) "\t\t<cim:ExtUnitSymbolKind.VPerHz rdf:resource=\"#" + VPerHz + "\"/>\n" else "") +
        (if (null != VPerV) "\t\t<cim:ExtUnitSymbolKind.VPerV rdf:resource=\"#" + VPerV + "\"/>\n" else "") +
        (if (null != Vs) "\t\t<cim:ExtUnitSymbolKind.Vs rdf:resource=\"#" + Vs + "\"/>\n" else "") +
        (if (null != W) "\t\t<cim:ExtUnitSymbolKind.W rdf:resource=\"#" + W + "\"/>\n" else "") +
        (if (null != WPerSec) "\t\t<cim:ExtUnitSymbolKind.WPerSec rdf:resource=\"#" + WPerSec + "\"/>\n" else "") +
        (if (null != WPerVA) "\t\t<cim:ExtUnitSymbolKind.WPerVA rdf:resource=\"#" + WPerVA + "\"/>\n" else "") +
        (if (null != WPerW) "\t\t<cim:ExtUnitSymbolKind.WPerW rdf:resource=\"#" + WPerW + "\"/>\n" else "") +
        (if (null != Wh) "\t\t<cim:ExtUnitSymbolKind.Wh rdf:resource=\"#" + Wh + "\"/>\n" else "") +
        (if (null != WhPerM3) "\t\t<cim:ExtUnitSymbolKind.WhPerM3 rdf:resource=\"#" + WhPerM3 + "\"/>\n" else "") +
        (if (null != WhPerRev) "\t\t<cim:ExtUnitSymbolKind.WhPerRev rdf:resource=\"#" + WhPerRev + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExtUnitSymbolKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExtUnitSymbolKind>\n"
    }
}

object ExtUnitSymbolKind
extends
    Parseable[ExtUnitSymbolKind]
{
    val aPerM: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.aPerM"""))
    val b: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.b"""))
    val bm: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.bm"""))
    val bq: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.bq"""))
    val btu: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.btu"""))
    val btuPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.btuPerH"""))
    val cd: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.cd"""))
    val char1: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.char"""))
    val charPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.charPerSec"""))
    val code: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.code"""))
    val cosTheta: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.cosTheta"""))
    val count: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.count"""))
    val deg: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.deg"""))
    val degC: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.degC"""))
    val ft3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3"""))
    val ft3compensated: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3compensated"""))
    val ft3compensatedPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.ft3compensatedPerH"""))
    val g: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.g"""))
    val gM2: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.gM2"""))
    val gPerG: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.gPerG"""))
    val gy: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.gy"""))
    val h: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.h"""))
    val imperialGal: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.imperialGal"""))
    val imperialGalPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.imperialGalPerH"""))
    val jPerK: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.jPerK"""))
    val jPerKg: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.jPerKg"""))
    val kat: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.kat"""))
    val kgM: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.kgM"""))
    val kgPerM3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.kgPerM3"""))
    val litre: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litre"""))
    val litreCompensated: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litreCompensated"""))
    val litreCompensatedPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litreCompensatedPerH"""))
    val litrePerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerH"""))
    val litrePerLitre: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerLitre"""))
    val litrePerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litrePerSec"""))
    val litreUncompensated: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litreUncompensated"""))
    val litreUncompensatedPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.litreUncompensatedPerH"""))
    val lm: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.lm"""))
    val lx: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.lx"""))
    val m: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m"""))
    val m2: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m2"""))
    val m2PerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m2PerSec"""))
    val m3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3"""))
    val m3PerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3PerH"""))
    val m3PerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3PerSec"""))
    val m3compensated: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3compensated"""))
    val m3compensatedPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3compensatedPerH"""))
    val m3uncompensated: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3uncompensated"""))
    val m3uncompensatedPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.m3uncompensatedPerH"""))
    val mPerM: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerM"""))
    val mPerM3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerM3"""))
    val mPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerSec"""))
    val mPerSec2: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.mPerSec2"""))
    val meCode: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.meCode"""))
    val min: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.min"""))
    val mol: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.mol"""))
    val molPerKg: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerKg"""))
    val molPerM3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerM3"""))
    val molPerMol: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.molPerMol"""))
    val money: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.money"""))
    val n: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.n"""))
    val none: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.none"""))
    val ohm: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.ohm"""))
    val ohmM: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.ohmM"""))
    val pa: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.pa"""))
    val paA: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.paA"""))
    val paG: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.paG"""))
    val psiA: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.psiA"""))
    val psiG: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.psiG"""))
    val q: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.q"""))
    val q45: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.q45"""))
    val q45h: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.q45h"""))
    val q60: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.q60"""))
    val q60h: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.q60h"""))
    val qh: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.qh"""))
    val rad: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.rad"""))
    val radPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.radPerSec"""))
    val rev: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.rev"""))
    val revPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.revPerSec"""))
    val sec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.sec"""))
    val secPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.secPerSec"""))
    val siemens: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.siemens"""))
    val sr: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.sr"""))
    val status: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.status"""))
    val sv: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.sv"""))
    val t: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.t"""))
    val therm: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.therm"""))
    val timeStamp: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.timeStamp"""))
    val usGal: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.usGal"""))
    val usGalPerH: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.usGalPerH"""))
    val wPerMK: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.wPerMK"""))
    val wb: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.wb"""))
    val A: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.A"""))
    val A2: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.A2"""))
    val A2h: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.A2h"""))
    val A2s: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.A2s"""))
    val APerA: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.APerA"""))
    val Ah: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.Ah"""))
    val As: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.As"""))
    val F: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.F"""))
    val H: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.H"""))
    val Hz: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.Hz"""))
    val HzPerHz: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.HzPerHz"""))
    val HzPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.HzPerSec"""))
    val J: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.J"""))
    val K: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.K"""))
    val V: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.V"""))
    val V2: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.V2"""))
    val V2h: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.V2h"""))
    val VA: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VA"""))
    val VAh: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VAh"""))
    val VAhPerRev: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VAhPerRev"""))
    val VAr: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VAr"""))
    val VArh: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VArh"""))
    val VArhPerRev: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VArhPerRev"""))
    val VPerHz: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VPerHz"""))
    val VPerV: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.VPerV"""))
    val Vs: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.Vs"""))
    val W: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.W"""))
    val WPerSec: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerSec"""))
    val WPerVA: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerVA"""))
    val WPerW: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.WPerW"""))
    val Wh: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.Wh"""))
    val WhPerM3: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.WhPerM3"""))
    val WhPerRev: (Context) => String = parse_attribute (attribute ("""ExtUnitSymbolKind.WhPerRev"""))
    def parse (context: Context): ExtUnitSymbolKind =
    {
        ExtUnitSymbolKind(
            BasicElement.parse (context),
            aPerM (context),
            b (context),
            bm (context),
            bq (context),
            btu (context),
            btuPerH (context),
            cd (context),
            char1 (context),
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

private[ninecode] object _ExistingEnumExtensions
{
    def register: List[ClassInfo] =
    {
        List (
            ExtPhaseCodeKind.register,
            ExtUnitMultiplierKind.register,
            ExtUnitSymbolKind.register
        )
    }
}