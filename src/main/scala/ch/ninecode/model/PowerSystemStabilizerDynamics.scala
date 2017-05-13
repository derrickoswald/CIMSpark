package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.
 * A variety of input signals may be used depending on the particular design.
 */

/**
 * Input signal type.
 * In Dynamics modelling, commonly represented by j parameter.
 */
case class InputSignalKind
(

    override val sup: BasicElement,

    /**
     * Input signal is amplitude of remote branch current.
     */
    val branchCurrent: String,

    /**
     * Input signal is bus voltage fr<font color="#0f0f0f">equency.
     * This could be a terminal frequency or remote frequency.</font>
     */
    val busFrequency: String,

    /**
     * Input signal is deviation of bus voltage frequ<font color="#0f0f0f">ency.
     * This could be a terminal frequency deviation or remote frequency deviation.</font>
     */
    val busFrequencyDeviation: String,

    /**
     * Input signal <font color="#0f0f0f">is bus voltage.
     * This could be a terminal voltage or remote voltage.</font>
     */
    val busVoltage: String,

    /**
     * Input signal is derivative of bus voltag<font color="#0f0f0f">e.
     * This could be a terminal voltage derivative or remote voltage derivative.</font>
     */
    val busVoltageDerivative: String,

    /**
     * Input signal is generator field current.
     */
    val fieldCurrent: String,

    /**
     * Input signal is generating accelerating power.
     */
    val generatorAcceleratingPower: String,

    /**
     * Input signal is generator electrical power on rated S.
     */
    val generatorElectricalPower: String,

    /**
     * Input signal is rotor or shaft angular frequency deviation.
     */
    val rotorAngularFrequencyDeviation: String,

    /**
     * Input signal is rotor or shaft speed (angular frequency).
     */
    val rotorSpeed: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InputSignalKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InputSignalKind
extends
    Parseable[InputSignalKind]
{
    val sup = BasicElement.parse _
    val branchCurrent = parse_attribute (attribute ("""InputSignalKind.branchCurrent"""))_
    val busFrequency = parse_attribute (attribute ("""InputSignalKind.busFrequency"""))_
    val busFrequencyDeviation = parse_attribute (attribute ("""InputSignalKind.busFrequencyDeviation"""))_
    val busVoltage = parse_attribute (attribute ("""InputSignalKind.busVoltage"""))_
    val busVoltageDerivative = parse_attribute (attribute ("""InputSignalKind.busVoltageDerivative"""))_
    val fieldCurrent = parse_attribute (attribute ("""InputSignalKind.fieldCurrent"""))_
    val generatorAcceleratingPower = parse_attribute (attribute ("""InputSignalKind.generatorAcceleratingPower"""))_
    val generatorElectricalPower = parse_attribute (attribute ("""InputSignalKind.generatorElectricalPower"""))_
    val rotorAngularFrequencyDeviation = parse_attribute (attribute ("""InputSignalKind.rotorAngularFrequencyDeviation"""))_
    val rotorSpeed = parse_attribute (attribute ("""InputSignalKind.rotorSpeed"""))_
    def parse (context: Context): InputSignalKind =
    {
        InputSignalKind(
            sup (context),
            branchCurrent (context),
            busFrequency (context),
            busFrequencyDeviation (context),
            busVoltage (context),
            busVoltageDerivative (context),
            fieldCurrent (context),
            generatorAcceleratingPower (context),
            generatorElectricalPower (context),
            rotorAngularFrequencyDeviation (context),
            rotorSpeed (context)
        )
    }
}

/**
 * Power system stabilizer function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 */
case class PowerSystemStabilizerDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Excitation system model with which this power system stabilizer model is associated.
     */
    val ExcitationSystemDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemStabilizerDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemStabilizerDynamics
extends
    Parseable[PowerSystemStabilizerDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PowerSystemStabilizerDynamics.ExcitationSystemDynamics"""))_
    def parse (context: Context): PowerSystemStabilizerDynamics =
    {
        PowerSystemStabilizerDynamics(
            sup (context),
            ExcitationSystemDynamics (context)
        )
    }
}

/**
 * Italian PSS - three input PSS (speed, frequency, power).
 */
case class Pss1
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Frequency power input gain (K<sub>F</sub>).
     * Typical Value = 5.
     */
    val kf: Double,

    /**
     * Electric power input gain (K<sub>PE</sub>).
     * Typical Value = 0.3.
     */
    val kpe: Double,

    /**
     * PSS gain (K<sub>S</sub>).
     * Typical Value = 1.
     */
    val ks: Double,

    /**
     * Shaft speed power input gain (K<sub>W</sub>).
     * Typical Value = 0.
     */
    val kw: Double,

    /**
     * Minimum power PSS enabling (P<sub>MIN</sub>).
     * Typical Value = 0.25.
     */
    val pmin: Double,

    /**
     * Lead/lag time constant (T<sub>10</sub>).
     * Typical Value = 0.
     */
    val t10: Double,

    /**
     * Washout (T<sub>5</sub>).
     * Typical Value = 3.5.
     */
    val t5: Double,

    /**
     * Filter time constant (T<sub>6</sub>).
     * Typical Value = 0.
     */
    val t6: Double,

    /**
     * Lead/lag time constant (T<sub>7</sub>).
     * Typical Value = 0.
     */
    val t7: Double,

    /**
     * Lead/lag time constant (T<sub>8</sub>).
     * Typical Value = 0.
     */
    val t8: Double,

    /**
     * Lead/lag time constant (T<sub>9</sub>).
     * Typical Value = 0.
     */
    val t9: Double,

    /**
     * Electric power filter time constant (T<sub>PE</sub>).
     * Typical Value = 0.05.
     */
    val tpe: Double,

    /**
     * <font color="#0f0f0f">Signal selector (V<sub>adAt</sub>).</font>
    <font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
    <font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
     * <font color="#0f0f0f">Typical Value = true.</font>
     */
    val vadat: Boolean,

    /**
     * Stabilizer output max limit (V<sub>SMN</sub>).
     * Typical Value = -0.06.
     */
    val vsmn: Double,

    /**
     * Stabilizer output min limit (V<sub>SMX</sub>).
     * Typical Value = 0.06.
     */
    val vsmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[Pss1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pss1
extends
    Parseable[Pss1]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val kf = parse_element (element ("""Pss1.kf"""))_
    val kpe = parse_element (element ("""Pss1.kpe"""))_
    val ks = parse_element (element ("""Pss1.ks"""))_
    val kw = parse_element (element ("""Pss1.kw"""))_
    val pmin = parse_element (element ("""Pss1.pmin"""))_
    val t10 = parse_element (element ("""Pss1.t10"""))_
    val t5 = parse_element (element ("""Pss1.t5"""))_
    val t6 = parse_element (element ("""Pss1.t6"""))_
    val t7 = parse_element (element ("""Pss1.t7"""))_
    val t8 = parse_element (element ("""Pss1.t8"""))_
    val t9 = parse_element (element ("""Pss1.t9"""))_
    val tpe = parse_element (element ("""Pss1.tpe"""))_
    val vadat = parse_element (element ("""Pss1.vadat"""))_
    val vsmn = parse_element (element ("""Pss1.vsmn"""))_
    val vsmx = parse_element (element ("""Pss1.vsmx"""))_
    def parse (context: Context): Pss1 =
    {
        Pss1(
            sup (context),
            toDouble (kf (context), context),
            toDouble (kpe (context), context),
            toDouble (ks (context), context),
            toDouble (kw (context), context),
            toDouble (pmin (context), context),
            toDouble (t10 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (t9 (context), context),
            toDouble (tpe (context), context),
            toBoolean (vadat (context), context),
            toDouble (vsmn (context), context),
            toDouble (vsmx (context), context)
        )
    }
}

/**
 * Single input power system stabilizer.
 * It is a modified version in order to allow representation of various vendors' implementations on PSS type 1A.
 */
case class Pss1A
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Notch filter parameter (A1).
     */
    val a1: Double,

    /**
     * Notch filter parameter (A2).
     */
    val a2: Double,

    /**
     * Notch filter parameter (A3).
     */
    val a3: Double,

    /**
     * Notch filter parameter (A4).
     */
    val a4: Double,

    /**
     * Notch filter parameter (A5).
     */
    val a5: Double,

    /**
     * Notch filter parameter (A6).
     */
    val a6: Double,

    /**
     * Notch filter parameter (A7).
     */
    val a7: Double,

    /**
     * Notch filter parameter (A8).
     */
    val a8: Double,

    /**
     * Type of input signal.
     */
    val inputSignalType: String,

    /**
     * Selector (Kd). 
    true = e<sup>-sTdelay</sup> used
     * false = e<sup>-sTdelay</sup> not used.
     */
    val kd: Boolean,

    /**
     * Stabilizer gain (Ks).
     */
    val ks: Double,

    /**
     * Lead/lag time constant (T1).
     */
    val t1: Double,

    /**
     * Lead/lag time constant (T2).
     */
    val t2: Double,

    /**
     * Lead/lag time constant (T3).
     */
    val t3: Double,

    /**
     * Lead/lag time constant (T4).
     */
    val t4: Double,

    /**
     * Washout time constant (T5).
     */
    val t5: Double,

    /**
     * Transducer time constant (T6).
     */
    val t6: Double,

    /**
     * Time constant (Tdelay).
     */
    val tdelay: Double,

    /**
     * Stabilizer input cutoff threshold (Vcl).
     */
    val vcl: Double,

    /**
     * Stabilizer input cutoff threshold (Vcu).
     */
    val vcu: Double,

    /**
     * Maximum stabilizer output (Vrmax).
     */
    val vrmax: Double,

    /**
     * Minimum stabilizer output (Vrmin).
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[Pss1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pss1A
extends
    Parseable[Pss1A]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val a1 = parse_element (element ("""Pss1A.a1"""))_
    val a2 = parse_element (element ("""Pss1A.a2"""))_
    val a3 = parse_element (element ("""Pss1A.a3"""))_
    val a4 = parse_element (element ("""Pss1A.a4"""))_
    val a5 = parse_element (element ("""Pss1A.a5"""))_
    val a6 = parse_element (element ("""Pss1A.a6"""))_
    val a7 = parse_element (element ("""Pss1A.a7"""))_
    val a8 = parse_element (element ("""Pss1A.a8"""))_
    val inputSignalType = parse_attribute (attribute ("""Pss1A.inputSignalType"""))_
    val kd = parse_element (element ("""Pss1A.kd"""))_
    val ks = parse_element (element ("""Pss1A.ks"""))_
    val t1 = parse_element (element ("""Pss1A.t1"""))_
    val t2 = parse_element (element ("""Pss1A.t2"""))_
    val t3 = parse_element (element ("""Pss1A.t3"""))_
    val t4 = parse_element (element ("""Pss1A.t4"""))_
    val t5 = parse_element (element ("""Pss1A.t5"""))_
    val t6 = parse_element (element ("""Pss1A.t6"""))_
    val tdelay = parse_element (element ("""Pss1A.tdelay"""))_
    val vcl = parse_element (element ("""Pss1A.vcl"""))_
    val vcu = parse_element (element ("""Pss1A.vcu"""))_
    val vrmax = parse_element (element ("""Pss1A.vrmax"""))_
    val vrmin = parse_element (element ("""Pss1A.vrmin"""))_
    def parse (context: Context): Pss1A =
    {
        Pss1A(
            sup (context),
            toDouble (a1 (context), context),
            toDouble (a2 (context), context),
            toDouble (a3 (context), context),
            toDouble (a4 (context), context),
            toDouble (a5 (context), context),
            toDouble (a6 (context), context),
            toDouble (a7 (context), context),
            toDouble (a8 (context), context),
            inputSignalType (context),
            toBoolean (kd (context), context),
            toDouble (ks (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (tdelay (context), context),
            toDouble (vcl (context), context),
            toDouble (vcu (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE PSS2B Model.
 * Extra lead/lag (or rate) block added at end (up to 4 lead/lags total).
 */
case class Pss2B
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Numerator constant (a).
     * Typical Value = 1.
     */
    val a: Double,

    /**
     * Type of input signal #1.
     * Typical Value = rotorSpeed.
     */
    val inputSignal1Type: String,

    /**
     * Type of input signal #2.
     * Typical Value = generatorElectricalPower.
     */
    val inputSignal2Type: String,

    /**
     * Stabilizer gain (Ks1).
     * Typical Value = 12.
     */
    val ks1: Double,

    /**
     * Gain on signal #2 (Ks2).
     * Typical Value = 0.2.
     */
    val ks2: Double,

    /**
     * Gain on signal #2 input before ramp-tracking filter (Ks3).
     * Typical Value = 1.
     */
    val ks3: Double,

    /**
     * Gain on signal #2 input after ramp-tracking filter (Ks4).
     * Typical Value = 1.
     */
    val ks4: Double,

    /**
     * Denominator order of ramp tracking filter (M).
     * Typical Value = 5.
     */
    val m: Int,

    /**
     * Order of ramp tracking filter (N).
     * Typical Value = 1.
     */
    val n: Int,

    /**
     * Lead/lag time constant (T1).
     * Typical Value = 0.12.
     */
    val t1: Double,

    /**
     * Lead/lag time constant (T10).
     * Typical Value = 0.
     */
    val t10: Double,

    /**
     * Lead/lag time constant (T11).
     * Typical Value = 0.
     */
    val t11: Double,

    /**
     * Lead/lag time constant (T2).
     * Typical Value = 0.02.
     */
    val t2: Double,

    /**
     * Lead/lag time constant (T3).
     * Typical Value = 0.3.
     */
    val t3: Double,

    /**
     * Lead/lag time constant (T4).
     * Typical Value = 0.02.
     */
    val t4: Double,

    /**
     * Time constant on signal #1 (T6).
     * Typical Value = 0.
     */
    val t6: Double,

    /**
     * Time constant on signal #2 (T7).
     * Typical Value = 2.
     */
    val t7: Double,

    /**
     * Lead of ramp tracking filter (T8).
     * Typical Value = 0.2.
     */
    val t8: Double,

    /**
     * Lag of ramp tracking filter (T9).
     * Typical Value = 0.1.
     */
    val t9: Double,

    /**
     * Lead constant (Ta).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Lag time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * First washout on signal #1 (Tw1).
     * Typical Value = 2.
     */
    val tw1: Double,

    /**
     * Second washout on signal #1 (Tw2).
     * Typical Value = 2.
     */
    val tw2: Double,

    /**
     * First washout on signal #2 (Tw3).
     * Typical Value = 2.
     */
    val tw3: Double,

    /**
     * Second washout on signal #2 (Tw4).
     * Typical Value = 0.
     */
    val tw4: Double,

    /**
     * Input signal #1 max limit (Vsi1max).
     * Typical Value = 2.
     */
    val vsi1max: Double,

    /**
     * Input signal #1 min limit (Vsi1min).
     * Typical Value = -2.
     */
    val vsi1min: Double,

    /**
     * Input signal #2 max limit (Vsi2max).
     * Typical Value = 2.
     */
    val vsi2max: Double,

    /**
     * Input signal #2 min limit (Vsi2min).
     * Typical Value = -2.
     */
    val vsi2min: Double,

    /**
     * Stabilizer output max limit (Vstmax).
     * Typical Value = 0.1.
     */
    val vstmax: Double,

    /**
     * Stabilizer output min limit (Vstmin).
     * Typical Value = -0.1.
     */
    val vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[Pss2B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pss2B
extends
    Parseable[Pss2B]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val a = parse_element (element ("""Pss2B.a"""))_
    val inputSignal1Type = parse_attribute (attribute ("""Pss2B.inputSignal1Type"""))_
    val inputSignal2Type = parse_attribute (attribute ("""Pss2B.inputSignal2Type"""))_
    val ks1 = parse_element (element ("""Pss2B.ks1"""))_
    val ks2 = parse_element (element ("""Pss2B.ks2"""))_
    val ks3 = parse_element (element ("""Pss2B.ks3"""))_
    val ks4 = parse_element (element ("""Pss2B.ks4"""))_
    val m = parse_element (element ("""Pss2B.m"""))_
    val n = parse_element (element ("""Pss2B.n"""))_
    val t1 = parse_element (element ("""Pss2B.t1"""))_
    val t10 = parse_element (element ("""Pss2B.t10"""))_
    val t11 = parse_element (element ("""Pss2B.t11"""))_
    val t2 = parse_element (element ("""Pss2B.t2"""))_
    val t3 = parse_element (element ("""Pss2B.t3"""))_
    val t4 = parse_element (element ("""Pss2B.t4"""))_
    val t6 = parse_element (element ("""Pss2B.t6"""))_
    val t7 = parse_element (element ("""Pss2B.t7"""))_
    val t8 = parse_element (element ("""Pss2B.t8"""))_
    val t9 = parse_element (element ("""Pss2B.t9"""))_
    val ta = parse_element (element ("""Pss2B.ta"""))_
    val tb = parse_element (element ("""Pss2B.tb"""))_
    val tw1 = parse_element (element ("""Pss2B.tw1"""))_
    val tw2 = parse_element (element ("""Pss2B.tw2"""))_
    val tw3 = parse_element (element ("""Pss2B.tw3"""))_
    val tw4 = parse_element (element ("""Pss2B.tw4"""))_
    val vsi1max = parse_element (element ("""Pss2B.vsi1max"""))_
    val vsi1min = parse_element (element ("""Pss2B.vsi1min"""))_
    val vsi2max = parse_element (element ("""Pss2B.vsi2max"""))_
    val vsi2min = parse_element (element ("""Pss2B.vsi2min"""))_
    val vstmax = parse_element (element ("""Pss2B.vstmax"""))_
    val vstmin = parse_element (element ("""Pss2B.vstmin"""))_
    def parse (context: Context): Pss2B =
    {
        Pss2B(
            sup (context),
            toDouble (a (context), context),
            inputSignal1Type (context),
            inputSignal2Type (context),
            toDouble (ks1 (context), context),
            toDouble (ks2 (context), context),
            toDouble (ks3 (context), context),
            toDouble (ks4 (context), context),
            toInteger (m (context), context),
            toInteger (n (context), context),
            toDouble (t1 (context), context),
            toDouble (t10 (context), context),
            toDouble (t11 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (t9 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tw1 (context), context),
            toDouble (tw2 (context), context),
            toDouble (tw3 (context), context),
            toDouble (tw4 (context), context),
            toDouble (vsi1max (context), context),
            toDouble (vsi1min (context), context),
            toDouble (vsi2max (context), context),
            toDouble (vsi2min (context), context),
            toDouble (vstmax (context), context),
            toDouble (vstmin (context), context)
        )
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 1.
 */
case class Pss2ST
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Type of input signal #1.
     * Typical Value = rotorAngularFrequencyDeviation.
     */
    val inputSignal1Type: String,

    /**
     * Type of input signal #2.
     * Typical Value = generatorElectricalPower.
     */
    val inputSignal2Type: String,

    /**
     * Gain (K1).
     */
    val k1: Double,

    /**
     * Gain (K2).
     */
    val k2: Double,

    /**
     * Limiter (Lsmax).
     */
    val lsmax: Double,

    /**
     * Limiter (Lsmin).
     */
    val lsmin: Double,

    /**
     * Time constant (T1).
     */
    val t1: Double,

    /**
     * Time constant (T10).
     */
    val t10: Double,

    /**
     * Time constant (T2).
     */
    val t2: Double,

    /**
     * Time constant (T3).
     */
    val t3: Double,

    /**
     * Time constant (T4).
     */
    val t4: Double,

    /**
     * Time constant (T5).
     */
    val t5: Double,

    /**
     * Time constant (T6).
     */
    val t6: Double,

    /**
     * Time constant (T7).
     */
    val t7: Double,

    /**
     * Time constant (T8).
     */
    val t8: Double,

    /**
     * Time constant (T9).
     */
    val t9: Double,

    /**
     * Cutoff limiter (Vcl).
     */
    val vcl: Double,

    /**
     * Cutoff limiter (Vcu).
     */
    val vcu: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[Pss2ST]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pss2ST
extends
    Parseable[Pss2ST]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val inputSignal1Type = parse_attribute (attribute ("""Pss2ST.inputSignal1Type"""))_
    val inputSignal2Type = parse_attribute (attribute ("""Pss2ST.inputSignal2Type"""))_
    val k1 = parse_element (element ("""Pss2ST.k1"""))_
    val k2 = parse_element (element ("""Pss2ST.k2"""))_
    val lsmax = parse_element (element ("""Pss2ST.lsmax"""))_
    val lsmin = parse_element (element ("""Pss2ST.lsmin"""))_
    val t1 = parse_element (element ("""Pss2ST.t1"""))_
    val t10 = parse_element (element ("""Pss2ST.t10"""))_
    val t2 = parse_element (element ("""Pss2ST.t2"""))_
    val t3 = parse_element (element ("""Pss2ST.t3"""))_
    val t4 = parse_element (element ("""Pss2ST.t4"""))_
    val t5 = parse_element (element ("""Pss2ST.t5"""))_
    val t6 = parse_element (element ("""Pss2ST.t6"""))_
    val t7 = parse_element (element ("""Pss2ST.t7"""))_
    val t8 = parse_element (element ("""Pss2ST.t8"""))_
    val t9 = parse_element (element ("""Pss2ST.t9"""))_
    val vcl = parse_element (element ("""Pss2ST.vcl"""))_
    val vcu = parse_element (element ("""Pss2ST.vcu"""))_
    def parse (context: Context): Pss2ST =
    {
        Pss2ST(
            sup (context),
            inputSignal1Type (context),
            inputSignal2Type (context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (lsmax (context), context),
            toDouble (lsmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t10 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (t9 (context), context),
            toDouble (vcl (context), context),
            toDouble (vcu (context), context)
        )
    }
}

/**
 * Italian PSS - Detailed PSS.
 */
case class Pss5
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Selector for Second washout enabling (C<sub>TW2</sub>).
    true = second washout filter is bypassed
    false = second washout filter in use.
     * Typical Value = true.
     */
    val ctw2: Boolean,

    /**
     * Stabilizer output dead band (DeadBand).
     * Typical Value = 0.
     */
    val deadband: Double,

    /**
     * Selector for Frequency/shaft speed input (IsFreq).
    true = speed
    false = frequency.
     * Typical Value = true.
     */
    val isfreq: Boolean,

    /**
     * Frequency/shaft speed input gain (K<sub>F</sub>).
     * Typical Value = 5.
     */
    val kf: Double,

    /**
     * Electric power input gain (K<sub>PE</sub>).
     * Typical Value = 0.3.
     */
    val kpe: Double,

    /**
     * PSS gain (K<sub>PSS</sub>).
     * Typical Value = 1.
     */
    val kpss: Double,

    /**
     * Minimum power PSS enabling (P<sub>mn</sub>).
     * Typical Value = 0.25.
     */
    val pmm: Double,

    /**
     * Lead/lag time constant (T<sub>L1</sub>).
     * Typical Value = 0.
     */
    val tl1: Double,

    /**
     * Lead/lag time constant (T<sub>L2</sub>).
     * Typical Value = 0.
     */
    val tl2: Double,

    /**
     * Lead/lag time constant (T<sub>L3</sub>).
     * Typical Value = 0.
     */
    val tl3: Double,

    /**
     * Lead/lag time constant (T<sub>L4</sub>).
     * Typical Value = 0.
     */
    val tl4: Double,

    /**
     * Electric power filter time constant (T<sub>PE</sub>).
     * Typical Value = 0.05.
     */
    val tpe: Double,

    /**
     * First WashOut (T<sub>w1</sub>).
     * Typical Value = 3.5.
     */
    val tw1: Double,

    /**
     * Second WashOut (T<sub>w2</sub>).
     * Typical Value = 0.
     */
    val tw2: Double,

    /**
     * <font color="#0f0f0f">Signal selector (V<sub>adAtt</sub>).</font>
    <font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
    <font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
     * <font color="#0f0f0f">Typical Value = true.</font>
     */
    val vadat: Boolean,

    /**
     * Stabilizer output max limit (V<sub>SMN</sub>).
     * Typical Value = -0.1.
     */
    val vsmn: Double,

    /**
     * Stabilizer output min limit (V<sub>SMX</sub>).
     * Typical Value = 0.1.
     */
    val vsmx: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[Pss5]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Pss5
extends
    Parseable[Pss5]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val ctw2 = parse_element (element ("""Pss5.ctw2"""))_
    val deadband = parse_element (element ("""Pss5.deadband"""))_
    val isfreq = parse_element (element ("""Pss5.isfreq"""))_
    val kf = parse_element (element ("""Pss5.kf"""))_
    val kpe = parse_element (element ("""Pss5.kpe"""))_
    val kpss = parse_element (element ("""Pss5.kpss"""))_
    val pmm = parse_element (element ("""Pss5.pmm"""))_
    val tl1 = parse_element (element ("""Pss5.tl1"""))_
    val tl2 = parse_element (element ("""Pss5.tl2"""))_
    val tl3 = parse_element (element ("""Pss5.tl3"""))_
    val tl4 = parse_element (element ("""Pss5.tl4"""))_
    val tpe = parse_element (element ("""Pss5.tpe"""))_
    val tw1 = parse_element (element ("""Pss5.tw1"""))_
    val tw2 = parse_element (element ("""Pss5.tw2"""))_
    val vadat = parse_element (element ("""Pss5.vadat"""))_
    val vsmn = parse_element (element ("""Pss5.vsmn"""))_
    val vsmx = parse_element (element ("""Pss5.vsmx"""))_
    def parse (context: Context): Pss5 =
    {
        Pss5(
            sup (context),
            toBoolean (ctw2 (context), context),
            toDouble (deadband (context), context),
            toBoolean (isfreq (context), context),
            toDouble (kf (context), context),
            toDouble (kpe (context), context),
            toDouble (kpss (context), context),
            toDouble (pmm (context), context),
            toDouble (tl1 (context), context),
            toDouble (tl2 (context), context),
            toDouble (tl3 (context), context),
            toDouble (tl4 (context), context),
            toDouble (tpe (context), context),
            toDouble (tw1 (context), context),
            toDouble (tw2 (context), context),
            toBoolean (vadat (context), context),
            toDouble (vsmn (context), context),
            toDouble (vsmx (context), context)
        )
    }
}

/**
 * Power system stabilizer typically associated with ExcELIN2 (though PssIEEE2B or Pss2B can also be used).
 */
case class PssELIN2
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Coefficient (a_PSS).
     * Typical Value = 0.1.
     */
    val apss: Double,

    /**
     * Gain (Ks1).
     * Typical Value = 1.
     */
    val ks1: Double,

    /**
     * Gain (Ks2).
     * Typical Value = 0.1.
     */
    val ks2: Double,

    /**
     * Coefficient (p_PSS) (&gt;=0 and &lt;=4).
     * Typical Value = 0.1.
     */
    val ppss: Double,

    /**
     * PSS limiter (psslim).
     * Typical Value = 0.1.
     */
    val psslim: Double,

    /**
     * Time constant (Ts1).
     * Typical Value = 0.
     */
    val ts1: Double,

    /**
     * Time constant (Ts2).
     * Typical Value = 1.
     */
    val ts2: Double,

    /**
     * Time constant (Ts3).
     * Typical Value = 1.
     */
    val ts3: Double,

    /**
     * Time constant (Ts4).
     * Typical Value = 0.1.
     */
    val ts4: Double,

    /**
     * Time constant (Ts5).
     * Typical Value = 0.
     */
    val ts5: Double,

    /**
     * Time constant (Ts6).
     * Typical Value = 1.
     */
    val ts6: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssELIN2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssELIN2
extends
    Parseable[PssELIN2]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val apss = parse_element (element ("""PssELIN2.apss"""))_
    val ks1 = parse_element (element ("""PssELIN2.ks1"""))_
    val ks2 = parse_element (element ("""PssELIN2.ks2"""))_
    val ppss = parse_element (element ("""PssELIN2.ppss"""))_
    val psslim = parse_element (element ("""PssELIN2.psslim"""))_
    val ts1 = parse_element (element ("""PssELIN2.ts1"""))_
    val ts2 = parse_element (element ("""PssELIN2.ts2"""))_
    val ts3 = parse_element (element ("""PssELIN2.ts3"""))_
    val ts4 = parse_element (element ("""PssELIN2.ts4"""))_
    val ts5 = parse_element (element ("""PssELIN2.ts5"""))_
    val ts6 = parse_element (element ("""PssELIN2.ts6"""))_
    def parse (context: Context): PssELIN2 =
    {
        PssELIN2(
            sup (context),
            toDouble (apss (context), context),
            toDouble (ks1 (context), context),
            toDouble (ks2 (context), context),
            toDouble (ppss (context), context),
            toDouble (psslim (context), context),
            toDouble (ts1 (context), context),
            toDouble (ts2 (context), context),
            toDouble (ts3 (context), context),
            toDouble (ts4 (context), context),
            toDouble (ts5 (context), context),
            toDouble (ts6 (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS1A power system stabilizer model.
 * PSS1A is the generalized form of a PSS with a single input. Some common stabilizer input signals are speed, frequency, and power.
 */
case class PssIEEE1A
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * PSS signal conditioning frequency filter constant (A1).
     * Typical Value = 0.061.
     */
    val a1: Double,

    /**
     * PSS signal conditioning frequency filter constant (A2).
     * Typical Value = 0.0017.
     */
    val a2: Double,

    /**
     * Type of input signal.
     * Typical Value = rotorAngularFrequencyDeviation.
     */
    val inputSignalType: String,

    /**
     * Stabilizer gain (Ks).
     * Typical Value = 5.
     */
    val ks: Double,

    /**
     * Lead/lag time constant (T1).
     * Typical Value = 0.3.
     */
    val t1: Double,

    /**
     * Lead/lag time constant (T2).
     * Typical Value = 0.03.
     */
    val t2: Double,

    /**
     * Lead/lag time constant (T3).
     * Typical Value = 0.3.
     */
    val t3: Double,

    /**
     * Lead/lag time constant (T4).
     * Typical Value = 0.03.
     */
    val t4: Double,

    /**
     * Washout time constant (T5).
     * Typical Value = 10.
     */
    val t5: Double,

    /**
     * Transducer time constant (T6).
     * Typical Value = 0.01.
     */
    val t6: Double,

    /**
     * Maximum stabilizer output (Vrmax).
     * Typical Value = 0.05.
     */
    val vrmax: Double,

    /**
     * Minimum stabilizer output (Vrmin).
     * Typical Value = -0.05.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssIEEE1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssIEEE1A
extends
    Parseable[PssIEEE1A]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val a1 = parse_element (element ("""PssIEEE1A.a1"""))_
    val a2 = parse_element (element ("""PssIEEE1A.a2"""))_
    val inputSignalType = parse_attribute (attribute ("""PssIEEE1A.inputSignalType"""))_
    val ks = parse_element (element ("""PssIEEE1A.ks"""))_
    val t1 = parse_element (element ("""PssIEEE1A.t1"""))_
    val t2 = parse_element (element ("""PssIEEE1A.t2"""))_
    val t3 = parse_element (element ("""PssIEEE1A.t3"""))_
    val t4 = parse_element (element ("""PssIEEE1A.t4"""))_
    val t5 = parse_element (element ("""PssIEEE1A.t5"""))_
    val t6 = parse_element (element ("""PssIEEE1A.t6"""))_
    val vrmax = parse_element (element ("""PssIEEE1A.vrmax"""))_
    val vrmin = parse_element (element ("""PssIEEE1A.vrmin"""))_
    def parse (context: Context): PssIEEE1A =
    {
        PssIEEE1A(
            sup (context),
            toDouble (a1 (context), context),
            toDouble (a2 (context), context),
            inputSignalType (context),
            toDouble (ks (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS2B power system stabilizer model.
 * This stabilizer model is designed to represent a variety of dual-input stabilizers, which normally use combinations of power and speed or frequency to derive the stabilizing signal.
 */
case class PssIEEE2B
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Type of input signal #1.
     * Typical Value = rotorSpeed.
     */
    val inputSignal1Type: String,

    /**
     * Type of input signal #2.
     * Typical Value = generatorElectricalPower.
     */
    val inputSignal2Type: String,

    /**
     * Stabilizer gain (Ks1).
     * Typical Value = 12.
     */
    val ks1: Double,

    /**
     * Gain on signal #2 (Ks2).
     * Typical Value = 0.2.
     */
    val ks2: Double,

    /**
     * Gain on signal #2 input before ramp-tracking filter (Ks3).
     * Typical Value = 1.
     */
    val ks3: Double,

    /**
     * Denominator order of ramp tracking filter (M).
     * Typical Value = 5.
     */
    val m: Int,

    /**
     * Order of ramp tracking filter (N).
     * Typical Value = 1.
     */
    val n: Int,

    /**
     * Lead/lag time constant (T1).
     * Typical Value = 0.12.
     */
    val t1: Double,

    /**
     * Lead/lag time constant (T10).
     * Typical Value = 0.
     */
    val t10: Double,

    /**
     * Lead/lag time constant (T11).
     * Typical Value = 0.
     */
    val t11: Double,

    /**
     * Lead/lag time constant (T2).
     * Typical Value = 0.02.
     */
    val t2: Double,

    /**
     * Lead/lag time constant (T3).
     * Typical Value = 0.3.
     */
    val t3: Double,

    /**
     * Lead/lag time constant (T4).
     * Typical Value = 0.02.
     */
    val t4: Double,

    /**
     * Time constant on signal #1 (T6).
     * Typical Value = 0.
     */
    val t6: Double,

    /**
     * Time constant on signal #2 (T7).
     * Typical Value = 2.
     */
    val t7: Double,

    /**
     * Lead of ramp tracking filter (T8).
     * Typical Value = 0.2.
     */
    val t8: Double,

    /**
     * Lag of ramp tracking filter (T9).
     * Typical Value = 0.1.
     */
    val t9: Double,

    /**
     * First washout on signal #1 (Tw1).
     * Typical Value = 2.
     */
    val tw1: Double,

    /**
     * Second washout on signal #1 (Tw2).
     * Typical Value = 2.
     */
    val tw2: Double,

    /**
     * First washout on signal #2 (Tw3).
     * Typical Value = 2.
     */
    val tw3: Double,

    /**
     * Second washout on signal #2 (Tw4).
     * Typical Value = 0.
     */
    val tw4: Double,

    /**
     * Input signal #1 max limit (Vsi1max).
     * Typical Value = 2.
     */
    val vsi1max: Double,

    /**
     * Input signal #1 min limit (Vsi1min).
     * Typical Value = -2.
     */
    val vsi1min: Double,

    /**
     * Input signal #2 max limit (Vsi2max).
     * Typical Value = 2.
     */
    val vsi2max: Double,

    /**
     * Input signal #2 min limit (Vsi2min).
     * Typical Value = -2.
     */
    val vsi2min: Double,

    /**
     * Stabilizer output max limit (Vstmax).
     * Typical Value = 0.1.
     */
    val vstmax: Double,

    /**
     * Stabilizer output min limit (Vstmin).
     * Typical Value = -0.1.
     */
    val vstmin: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssIEEE2B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssIEEE2B
extends
    Parseable[PssIEEE2B]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val inputSignal1Type = parse_attribute (attribute ("""PssIEEE2B.inputSignal1Type"""))_
    val inputSignal2Type = parse_attribute (attribute ("""PssIEEE2B.inputSignal2Type"""))_
    val ks1 = parse_element (element ("""PssIEEE2B.ks1"""))_
    val ks2 = parse_element (element ("""PssIEEE2B.ks2"""))_
    val ks3 = parse_element (element ("""PssIEEE2B.ks3"""))_
    val m = parse_element (element ("""PssIEEE2B.m"""))_
    val n = parse_element (element ("""PssIEEE2B.n"""))_
    val t1 = parse_element (element ("""PssIEEE2B.t1"""))_
    val t10 = parse_element (element ("""PssIEEE2B.t10"""))_
    val t11 = parse_element (element ("""PssIEEE2B.t11"""))_
    val t2 = parse_element (element ("""PssIEEE2B.t2"""))_
    val t3 = parse_element (element ("""PssIEEE2B.t3"""))_
    val t4 = parse_element (element ("""PssIEEE2B.t4"""))_
    val t6 = parse_element (element ("""PssIEEE2B.t6"""))_
    val t7 = parse_element (element ("""PssIEEE2B.t7"""))_
    val t8 = parse_element (element ("""PssIEEE2B.t8"""))_
    val t9 = parse_element (element ("""PssIEEE2B.t9"""))_
    val tw1 = parse_element (element ("""PssIEEE2B.tw1"""))_
    val tw2 = parse_element (element ("""PssIEEE2B.tw2"""))_
    val tw3 = parse_element (element ("""PssIEEE2B.tw3"""))_
    val tw4 = parse_element (element ("""PssIEEE2B.tw4"""))_
    val vsi1max = parse_element (element ("""PssIEEE2B.vsi1max"""))_
    val vsi1min = parse_element (element ("""PssIEEE2B.vsi1min"""))_
    val vsi2max = parse_element (element ("""PssIEEE2B.vsi2max"""))_
    val vsi2min = parse_element (element ("""PssIEEE2B.vsi2min"""))_
    val vstmax = parse_element (element ("""PssIEEE2B.vstmax"""))_
    val vstmin = parse_element (element ("""PssIEEE2B.vstmin"""))_
    def parse (context: Context): PssIEEE2B =
    {
        PssIEEE2B(
            sup (context),
            inputSignal1Type (context),
            inputSignal2Type (context),
            toDouble (ks1 (context), context),
            toDouble (ks2 (context), context),
            toDouble (ks3 (context), context),
            toInteger (m (context), context),
            toInteger (n (context), context),
            toDouble (t1 (context), context),
            toDouble (t10 (context), context),
            toDouble (t11 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (t9 (context), context),
            toDouble (tw1 (context), context),
            toDouble (tw2 (context), context),
            toDouble (tw3 (context), context),
            toDouble (tw4 (context), context),
            toDouble (vsi1max (context), context),
            toDouble (vsi1min (context), context),
            toDouble (vsi2max (context), context),
            toDouble (vsi2min (context), context),
            toDouble (vstmax (context), context),
            toDouble (vstmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS3B power system stabilizer model.
 * The PSS model PSS3B has dual inputs of electrical power and rotor angular frequency deviation. The signals are used to derive an equivalent mechanical power signal.
 */
case class PssIEEE3B
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Notch filter parameter (A1).
     * Typical Value = 0.359.
     */
    val a1: Double,

    /**
     * Notch filter parameter (A2).
     * Typical Value = 0.586.
     */
    val a2: Double,

    /**
     * Notch filter parameter (A3).
     * Typical Value = 0.429.
     */
    val a3: Double,

    /**
     * Notch filter parameter (A4).
     * Typical Value = 0.564.
     */
    val a4: Double,

    /**
     * Notch filter parameter (A5).
     * Typical Value = 0.001.
     */
    val a5: Double,

    /**
     * Notch filter parameter (A6).
     * Typical Value = 0.
     */
    val a6: Double,

    /**
     * Notch filter parameter (A7).
     * Typical Value = 0.031.
     */
    val a7: Double,

    /**
     * Notch filter parameter (A8).
     * Typical Value = 0.
     */
    val a8: Double,

    /**
     * Type of input signal #1.
     * Typical Value = generatorElectricalPower.
     */
    val inputSignal1Type: String,

    /**
     * Type of input signal #2.
     * Typical Value = rotorSpeed.
     */
    val inputSignal2Type: String,

    /**
     * Gain on signal # 1 (Ks1).
     * Typical Value = -0.602.
     */
    val ks1: Double,

    /**
     * Gain on signal # 2 (Ks2).
     * Typical Value = 30.12.
     */
    val ks2: Double,

    /**
     * Transducer time constant (T1).
     * Typical Value = 0.012.
     */
    val t1: Double,

    /**
     * Transducer time constant (T2).
     * Typical Value = 0.012.
     */
    val t2: Double,

    /**
     * Washout time constant (Tw1).
     * Typical Value = 0.3.
     */
    val tw1: Double,

    /**
     * Washout time constant (Tw2).
     * Typical Value = 0.3.
     */
    val tw2: Double,

    /**
     * Washout time constant (Tw3).
     * Typical Value = 0.6.
     */
    val tw3: Double,

    /**
     * Stabilizer output max limit (Vstmax).
     * Typical Value = 0.1.
     */
    val vstmax: Double,

    /**
     * Stabilizer output min limit (Vstmin).
     * Typical Value = -0.1.
     */
    val vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssIEEE3B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssIEEE3B
extends
    Parseable[PssIEEE3B]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val a1 = parse_element (element ("""PssIEEE3B.a1"""))_
    val a2 = parse_element (element ("""PssIEEE3B.a2"""))_
    val a3 = parse_element (element ("""PssIEEE3B.a3"""))_
    val a4 = parse_element (element ("""PssIEEE3B.a4"""))_
    val a5 = parse_element (element ("""PssIEEE3B.a5"""))_
    val a6 = parse_element (element ("""PssIEEE3B.a6"""))_
    val a7 = parse_element (element ("""PssIEEE3B.a7"""))_
    val a8 = parse_element (element ("""PssIEEE3B.a8"""))_
    val inputSignal1Type = parse_attribute (attribute ("""PssIEEE3B.inputSignal1Type"""))_
    val inputSignal2Type = parse_attribute (attribute ("""PssIEEE3B.inputSignal2Type"""))_
    val ks1 = parse_element (element ("""PssIEEE3B.ks1"""))_
    val ks2 = parse_element (element ("""PssIEEE3B.ks2"""))_
    val t1 = parse_element (element ("""PssIEEE3B.t1"""))_
    val t2 = parse_element (element ("""PssIEEE3B.t2"""))_
    val tw1 = parse_element (element ("""PssIEEE3B.tw1"""))_
    val tw2 = parse_element (element ("""PssIEEE3B.tw2"""))_
    val tw3 = parse_element (element ("""PssIEEE3B.tw3"""))_
    val vstmax = parse_element (element ("""PssIEEE3B.vstmax"""))_
    val vstmin = parse_element (element ("""PssIEEE3B.vstmin"""))_
    def parse (context: Context): PssIEEE3B =
    {
        PssIEEE3B(
            sup (context),
            toDouble (a1 (context), context),
            toDouble (a2 (context), context),
            toDouble (a3 (context), context),
            toDouble (a4 (context), context),
            toDouble (a5 (context), context),
            toDouble (a6 (context), context),
            toDouble (a7 (context), context),
            toDouble (a8 (context), context),
            inputSignal1Type (context),
            inputSignal2Type (context),
            toDouble (ks1 (context), context),
            toDouble (ks2 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (tw1 (context), context),
            toDouble (tw2 (context), context),
            toDouble (tw3 (context), context),
            toDouble (vstmax (context), context),
            toDouble (vstmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS2B power system stabilizer model.
 * The PSS4B model represents a structure based on multiple working frequency bands. Three separate bands, respectively dedicated to the low-, intermediate- and high-frequency modes of oscillations, are used in this delta-omega (speed input) PSS.
 */
case class PssIEEE4B
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Notch filter 1 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
     */
    val bwh1: Double,

    /**
     * Notch filter 2 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
     */
    val bwh2: Double,

    /**
     * Notch filter 1 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
     */
    val bwl1: Double,

    /**
     * Notch filter 2 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
     */
    val bwl2: Double,

    /**
     * High band gain (K<sub>H</sub>).
     * Typical Value = 120.
     */
    val kh: Double,

    /**
     * High band differential filter gain (K<sub>H1</sub>).
     * Typical Value = 66.
     */
    val kh1: Double,

    /**
     * High band first lead-lag blocks coefficient (K<sub>H11</sub>).
     * Typical Value = 1.
     */
    val kh11: Double,

    /**
     * High band first lead-lag blocks coefficient (K<sub>H17</sub>).
     * Typical Value = 1.
     */
    val kh17: Double,

    /**
     * High band differential filter gain (K<sub>H2</sub>).
     * Typical Value = 66.
     */
    val kh2: Double,

    /**
     * Intermediate band gain (K<sub>I</sub>).
     * Typical Value = 30.
     */
    val ki: Double,

    /**
     * Intermediate band differential filter gain (K<sub>I1</sub>).
     * Typical Value = 66.
     */
    val ki1: Double,

    /**
     * Intermediate band first lead-lag blocks coefficient (K<sub>I11</sub>).
     * Typical Value = 1.
     */
    val ki11: Double,

    /**
     * Intermediate band first lead-lag blocks coefficient (K<sub>I17</sub>).
     * Typical Value = 1.
     */
    val ki17: Double,

    /**
     * Intermediate band differential filter gain (K<sub>I2</sub>).
     * Typical Value = 66.
     */
    val ki2: Double,

    /**
     * Low band gain (K<sub>L</sub>).
     * Typical Value = 7.5.
     */
    val kl: Double,

    /**
     * Low band differential filter gain (K<sub>L1</sub>).
     * Typical Value = 66.
     */
    val kl1: Double,

    /**
     * Low band first lead-lag blocks coefficient (K<sub>L11</sub>).
     * Typical Value = 1.
     */
    val kl11: Double,

    /**
     * Low band first lead-lag blocks coefficient (K<sub>L17</sub>).
     * Typical Value = 1.
     */
    val kl17: Double,

    /**
     * Low band differential filter gain (K<sub>L2</sub>).
     * Typical Value = 66.
     */
    val kl2: Double,

    /**
     * Notch filter 1 (high-frequency band): filter frequency (omega<sub>ni</sub>).
     */
    val omeganh1: Double,

    /**
     * Notch filter 2 (high-frequency band): filter frequency (omega<sub>ni</sub>).
     */
    val omeganh2: Double,

    /**
     * Notch filter 1 (low-frequency band): filter frequency (omega<sub>ni</sub>).
     */
    val omeganl1: Double,

    /**
     * Notch filter 2 (low-frequency band): filter frequency (omega<sub>ni</sub>).
     */
    val omeganl2: Double,

    /**
     * High band time constant (T<sub>H1</sub>).
     * Typical Value = 0.01513.
     */
    val th1: Double,

    /**
     * High band time constant (T<sub>H10</sub>).
     * Typical Value = 0.
     */
    val th10: Double,

    /**
     * High band time constant (T<sub>H11</sub>).
     * Typical Value = 0.
     */
    val th11: Double,

    /**
     * High band time constant (T<sub>H12</sub>).
     * Typical Value = 0.
     */
    val th12: Double,

    /**
     * High band time constant (T<sub>H2</sub>).
     * Typical Value = 0.01816.
     */
    val th2: Double,

    /**
     * High band time constant (T<sub>H3</sub>).
     * Typical Value = 0.
     */
    val th3: Double,

    /**
     * High band time constant (T<sub>H4</sub>).
     * Typical Value = 0.
     */
    val th4: Double,

    /**
     * High band time constant (T<sub>H5</sub>).
     * Typical Value = 0.
     */
    val th5: Double,

    /**
     * High band time constant (T<sub>H6</sub>).
     * Typical Value = 0.
     */
    val th6: Double,

    /**
     * High band time constant (T<sub>H7</sub>).
     * Typical Value = 0.01816.
     */
    val th7: Double,

    /**
     * High band time constant (T<sub>H8</sub>).
     * Typical Value = 0.02179.
     */
    val th8: Double,

    /**
     * High band time constant (T<sub>H9</sub>).
     * Typical Value = 0.
     */
    val th9: Double,

    /**
     * Intermediate band time constant (T<sub>I1</sub>).
     * Typical Value = 0.173.
     */
    val ti1: Double,

    /**
     * Intermediate band time constant (T<sub>I11</sub>).
     * Typical Value = 0.
     */
    val ti10: Double,

    /**
     * Intermediate band time constant (T<sub>I11</sub>).
     * Typical Value = 0.
     */
    val ti11: Double,

    /**
     * Intermediate band time constant (T<sub>I2</sub>).
     * Typical Value = 0.
     */
    val ti12: Double,

    /**
     * Intermediate band time constant (T<sub>I2</sub>).
     * Typical Value = 0.2075.
     */
    val ti2: Double,

    /**
     * Intermediate band time constant (T<sub>I3</sub>).
     * Typical Value = 0.
     */
    val ti3: Double,

    /**
     * Intermediate band time constant (T<sub>I4</sub>).
     * Typical Value = 0.
     */
    val ti4: Double,

    /**
     * Intermediate band time constant (T<sub>I5</sub>).
     * Typical Value = 0.
     */
    val ti5: Double,

    /**
     * Intermediate band time constant (T<sub>I6</sub>).
     * Typical Value = 0.
     */
    val ti6: Double,

    /**
     * Intermediate band time constant (T<sub>I7</sub>).
     * Typical Value = 0.2075.
     */
    val ti7: Double,

    /**
     * Intermediate band time constant (T<sub>I8</sub>).
     * Typical Value = 0.2491.
     */
    val ti8: Double,

    /**
     * Intermediate band time constant (T<sub>I9</sub>).
     * Typical Value = 0.
     */
    val ti9: Double,

    /**
     * Low band time constant (T<sub>L1</sub>).
     * Typical Value = 1.73.
     */
    val tl1: Double,

    /**
     * Low band time constant (T<sub>L10</sub>).
     * Typical Value = 0.
     */
    val tl10: Double,

    /**
     * Low band time constant (T<sub>L11</sub>).
     * Typical Value = 0.
     */
    val tl11: Double,

    /**
     * Low band time constant (T<sub>L12</sub>).
     * Typical Value = 0.
     */
    val tl12: Double,

    /**
     * Low band time constant (T<sub>L2</sub>).
     * Typical Value = 2.075.
     */
    val tl2: Double,

    /**
     * Low band time constant (T<sub>L3</sub>).
     * Typical Value = 0.
     */
    val tl3: Double,

    /**
     * Low band time constant (T<sub>L4</sub>).
     * Typical Value = 0.
     */
    val tl4: Double,

    /**
     * Low band time constant (T<sub>L5</sub>).
     * Typical Value = 0.
     */
    val tl5: Double,

    /**
     * Low band time constant (T<sub>L6</sub>).
     * Typical Value = 0.
     */
    val tl6: Double,

    /**
     * Low band time constant (T<sub>L7</sub>).
     * Typical Value = 2.075.
     */
    val tl7: Double,

    /**
     * Low band time constant (T<sub>L8</sub>).
     * Typical Value = 2.491.
     */
    val tl8: Double,

    /**
     * Low band time constant (T<sub>L9</sub>).
     * Typical Value = 0.
     */
    val tl9: Double,

    /**
     * High band output maximum limit (V<sub>Hmax</sub>).
     * Typical Value = 0.6.
     */
    val vhmax: Double,

    /**
     * High band output minimum limit (V<sub>Hmin</sub>).
     * Typical Value = -0.6.
     */
    val vhmin: Double,

    /**
     * Intermediate band output maximum limit (V<sub>Imax</sub>).
     * Typical Value = 0.6.
     */
    val vimax: Double,

    /**
     * Intermediate band output minimum limit (V<sub>Imin</sub>).
     * Typical Value = -0.6.
     */
    val vimin: Double,

    /**
     * Low band output maximum limit (V<sub>Lmax</sub>).
     * Typical Value = 0.075.
     */
    val vlmax: Double,

    /**
     * Low band output minimum limit (V<sub>Lmin</sub>).
     * Typical Value = -0.075.
     */
    val vlmin: Double,

    /**
     * PSS output maximum limit (V<sub>STmax</sub>).
     * Typical Value = 0.15.
     */
    val vstmax: Double,

    /**
     * PSS output minimum limit (V<sub>STmin</sub>).
     * Typical Value = -0.15.
     */
    val vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssIEEE4B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssIEEE4B
extends
    Parseable[PssIEEE4B]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val bwh1 = parse_element (element ("""PssIEEE4B.bwh1"""))_
    val bwh2 = parse_element (element ("""PssIEEE4B.bwh2"""))_
    val bwl1 = parse_element (element ("""PssIEEE4B.bwl1"""))_
    val bwl2 = parse_element (element ("""PssIEEE4B.bwl2"""))_
    val kh = parse_element (element ("""PssIEEE4B.kh"""))_
    val kh1 = parse_element (element ("""PssIEEE4B.kh1"""))_
    val kh11 = parse_element (element ("""PssIEEE4B.kh11"""))_
    val kh17 = parse_element (element ("""PssIEEE4B.kh17"""))_
    val kh2 = parse_element (element ("""PssIEEE4B.kh2"""))_
    val ki = parse_element (element ("""PssIEEE4B.ki"""))_
    val ki1 = parse_element (element ("""PssIEEE4B.ki1"""))_
    val ki11 = parse_element (element ("""PssIEEE4B.ki11"""))_
    val ki17 = parse_element (element ("""PssIEEE4B.ki17"""))_
    val ki2 = parse_element (element ("""PssIEEE4B.ki2"""))_
    val kl = parse_element (element ("""PssIEEE4B.kl"""))_
    val kl1 = parse_element (element ("""PssIEEE4B.kl1"""))_
    val kl11 = parse_element (element ("""PssIEEE4B.kl11"""))_
    val kl17 = parse_element (element ("""PssIEEE4B.kl17"""))_
    val kl2 = parse_element (element ("""PssIEEE4B.kl2"""))_
    val omeganh1 = parse_element (element ("""PssIEEE4B.omeganh1"""))_
    val omeganh2 = parse_element (element ("""PssIEEE4B.omeganh2"""))_
    val omeganl1 = parse_element (element ("""PssIEEE4B.omeganl1"""))_
    val omeganl2 = parse_element (element ("""PssIEEE4B.omeganl2"""))_
    val th1 = parse_element (element ("""PssIEEE4B.th1"""))_
    val th10 = parse_element (element ("""PssIEEE4B.th10"""))_
    val th11 = parse_element (element ("""PssIEEE4B.th11"""))_
    val th12 = parse_element (element ("""PssIEEE4B.th12"""))_
    val th2 = parse_element (element ("""PssIEEE4B.th2"""))_
    val th3 = parse_element (element ("""PssIEEE4B.th3"""))_
    val th4 = parse_element (element ("""PssIEEE4B.th4"""))_
    val th5 = parse_element (element ("""PssIEEE4B.th5"""))_
    val th6 = parse_element (element ("""PssIEEE4B.th6"""))_
    val th7 = parse_element (element ("""PssIEEE4B.th7"""))_
    val th8 = parse_element (element ("""PssIEEE4B.th8"""))_
    val th9 = parse_element (element ("""PssIEEE4B.th9"""))_
    val ti1 = parse_element (element ("""PssIEEE4B.ti1"""))_
    val ti10 = parse_element (element ("""PssIEEE4B.ti10"""))_
    val ti11 = parse_element (element ("""PssIEEE4B.ti11"""))_
    val ti12 = parse_element (element ("""PssIEEE4B.ti12"""))_
    val ti2 = parse_element (element ("""PssIEEE4B.ti2"""))_
    val ti3 = parse_element (element ("""PssIEEE4B.ti3"""))_
    val ti4 = parse_element (element ("""PssIEEE4B.ti4"""))_
    val ti5 = parse_element (element ("""PssIEEE4B.ti5"""))_
    val ti6 = parse_element (element ("""PssIEEE4B.ti6"""))_
    val ti7 = parse_element (element ("""PssIEEE4B.ti7"""))_
    val ti8 = parse_element (element ("""PssIEEE4B.ti8"""))_
    val ti9 = parse_element (element ("""PssIEEE4B.ti9"""))_
    val tl1 = parse_element (element ("""PssIEEE4B.tl1"""))_
    val tl10 = parse_element (element ("""PssIEEE4B.tl10"""))_
    val tl11 = parse_element (element ("""PssIEEE4B.tl11"""))_
    val tl12 = parse_element (element ("""PssIEEE4B.tl12"""))_
    val tl2 = parse_element (element ("""PssIEEE4B.tl2"""))_
    val tl3 = parse_element (element ("""PssIEEE4B.tl3"""))_
    val tl4 = parse_element (element ("""PssIEEE4B.tl4"""))_
    val tl5 = parse_element (element ("""PssIEEE4B.tl5"""))_
    val tl6 = parse_element (element ("""PssIEEE4B.tl6"""))_
    val tl7 = parse_element (element ("""PssIEEE4B.tl7"""))_
    val tl8 = parse_element (element ("""PssIEEE4B.tl8"""))_
    val tl9 = parse_element (element ("""PssIEEE4B.tl9"""))_
    val vhmax = parse_element (element ("""PssIEEE4B.vhmax"""))_
    val vhmin = parse_element (element ("""PssIEEE4B.vhmin"""))_
    val vimax = parse_element (element ("""PssIEEE4B.vimax"""))_
    val vimin = parse_element (element ("""PssIEEE4B.vimin"""))_
    val vlmax = parse_element (element ("""PssIEEE4B.vlmax"""))_
    val vlmin = parse_element (element ("""PssIEEE4B.vlmin"""))_
    val vstmax = parse_element (element ("""PssIEEE4B.vstmax"""))_
    val vstmin = parse_element (element ("""PssIEEE4B.vstmin"""))_
    def parse (context: Context): PssIEEE4B =
    {
        PssIEEE4B(
            sup (context),
            toDouble (bwh1 (context), context),
            toDouble (bwh2 (context), context),
            toDouble (bwl1 (context), context),
            toDouble (bwl2 (context), context),
            toDouble (kh (context), context),
            toDouble (kh1 (context), context),
            toDouble (kh11 (context), context),
            toDouble (kh17 (context), context),
            toDouble (kh2 (context), context),
            toDouble (ki (context), context),
            toDouble (ki1 (context), context),
            toDouble (ki11 (context), context),
            toDouble (ki17 (context), context),
            toDouble (ki2 (context), context),
            toDouble (kl (context), context),
            toDouble (kl1 (context), context),
            toDouble (kl11 (context), context),
            toDouble (kl17 (context), context),
            toDouble (kl2 (context), context),
            toDouble (omeganh1 (context), context),
            toDouble (omeganh2 (context), context),
            toDouble (omeganl1 (context), context),
            toDouble (omeganl2 (context), context),
            toDouble (th1 (context), context),
            toDouble (th10 (context), context),
            toDouble (th11 (context), context),
            toDouble (th12 (context), context),
            toDouble (th2 (context), context),
            toDouble (th3 (context), context),
            toDouble (th4 (context), context),
            toDouble (th5 (context), context),
            toDouble (th6 (context), context),
            toDouble (th7 (context), context),
            toDouble (th8 (context), context),
            toDouble (th9 (context), context),
            toDouble (ti1 (context), context),
            toDouble (ti10 (context), context),
            toDouble (ti11 (context), context),
            toDouble (ti12 (context), context),
            toDouble (ti2 (context), context),
            toDouble (ti3 (context), context),
            toDouble (ti4 (context), context),
            toDouble (ti5 (context), context),
            toDouble (ti6 (context), context),
            toDouble (ti7 (context), context),
            toDouble (ti8 (context), context),
            toDouble (ti9 (context), context),
            toDouble (tl1 (context), context),
            toDouble (tl10 (context), context),
            toDouble (tl11 (context), context),
            toDouble (tl12 (context), context),
            toDouble (tl2 (context), context),
            toDouble (tl3 (context), context),
            toDouble (tl4 (context), context),
            toDouble (tl5 (context), context),
            toDouble (tl6 (context), context),
            toDouble (tl7 (context), context),
            toDouble (tl8 (context), context),
            toDouble (tl9 (context), context),
            toDouble (vhmax (context), context),
            toDouble (vhmin (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vlmax (context), context),
            toDouble (vlmin (context), context),
            toDouble (vstmax (context), context),
            toDouble (vstmin (context), context)
        )
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 1.
 */
case class PssPTIST1
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Time step related to activation of controls (Dtc).
     * Typical Value = 0.025.
     */
    val dtc: Double,

    /**
     * Time step frequency calculation (Dtf).
     * Typical Value = 0.025.
     */
    val dtf: Double,

    /**
     * Time step active power calculation (Dtp).
     * Typical Value = 0.0125.
     */
    val dtp: Double,

    /**
     * Gain (K).
     * Typical Value = 9.
     */
    val k: Double,

    /**
     * (M).
     * M=2*H.  Typical Value = 5.
     */
    val m: Double,

    /**
     * Time constant (T1).
     * Typical Value = 0.3.
     */
    val t1: Double,

    /**
     * Time constant (T2).
     * Typical Value = 1.
     */
    val t2: Double,

    /**
     * Time constant (T3).
     * Typical Value = 0.2.
     */
    val t3: Double,

    /**
     * Time constant (T4).
     * Typical Value = 0.05.
     */
    val t4: Double,

    /**
     * Time constant (Tf).
     * Typical Value = 0.2.
     */
    val tf: Double,

    /**
     * Time constant (Tp).
     * Typical Value = 0.2.
     */
    val tp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssPTIST1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssPTIST1
extends
    Parseable[PssPTIST1]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val dtc = parse_element (element ("""PssPTIST1.dtc"""))_
    val dtf = parse_element (element ("""PssPTIST1.dtf"""))_
    val dtp = parse_element (element ("""PssPTIST1.dtp"""))_
    val k = parse_element (element ("""PssPTIST1.k"""))_
    val m = parse_element (element ("""PssPTIST1.m"""))_
    val t1 = parse_element (element ("""PssPTIST1.t1"""))_
    val t2 = parse_element (element ("""PssPTIST1.t2"""))_
    val t3 = parse_element (element ("""PssPTIST1.t3"""))_
    val t4 = parse_element (element ("""PssPTIST1.t4"""))_
    val tf = parse_element (element ("""PssPTIST1.tf"""))_
    val tp = parse_element (element ("""PssPTIST1.tp"""))_
    def parse (context: Context): PssPTIST1 =
    {
        PssPTIST1(
            sup (context),
            toDouble (dtc (context), context),
            toDouble (dtf (context), context),
            toDouble (dtp (context), context),
            toDouble (k (context), context),
            toDouble (m (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (tf (context), context),
            toDouble (tp (context), context)
        )
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 3.
 */
case class PssPTIST3
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Filter coefficient (A0).
     */
    val a0: Double,

    /**
     * Limiter (Al).
     */
    val a1: Double,

    /**
     * Filter coefficient (A2).
     */
    val a2: Double,

    /**
     * Filter coefficient (A3).
     */
    val a3: Double,

    /**
     * Filter coefficient (A4).
     */
    val a4: Double,

    /**
     * Filter coefficient (A5).
     */
    val a5: Double,

    /**
     * Limiter (Al).
     */
    val al: Double,

    /**
     * Threshold value above which output averaging will be bypassed (Athres).
     * Typical Value = 0.005.
     */
    val athres: Double,

    /**
     * Filter coefficient (B0).
     */
    val b0: Double,

    /**
     * Filter coefficient (B1).
     */
    val b1: Double,

    /**
     * Filter coefficient (B2).
     */
    val b2: Double,

    /**
     * Filter coefficient (B3).
     */
    val b3: Double,

    /**
     * Filter coefficient (B4).
     */
    val b4: Double,

    /**
     * Filter coefficient (B5).
     */
    val b5: Double,

    /**
     * Limiter (Dl).
     */
    val dl: Double,

    /**
     * Time step related to activation of controls (0.03 for 50 Hz) (Dtc).
     * Typical Value = 0.025.
     */
    val dtc: Double,

    /**
     * Time step frequency calculation (0.03 for 50 Hz) (Dtf).
     * Typical Value = 0.025.
     */
    val dtf: Double,

    /**
     * Time step active power calculation (0.015 for 50 Hz) (Dtp).
     * Typical Value = 0.0125.
     */
    val dtp: Double,

    /**
     * Digital/analog output switch (Isw).
    true = produce analog output
     * false = convert to digital output, using tap selection table.
     */
    val isw: Boolean,

    /**
     * Gain (K).
     * Typical Value = 9.
     */
    val k: Double,

    /**
     * Threshold value (Lthres).
     */
    val lthres: Double,

    /**
     * (M).
     * M=2*H.  Typical Value = 5.
     */
    val m: Double,

    /**
     * Number of control outputs to average (Nav) (1 &lt;= Nav &lt;= 16).
     * Typical Value = 4.
     */
    val nav: Double,

    /**
     * Number of counts at limit to active limit function (Ncl) (&gt;0).
     */
    val ncl: Double,

    /**
     * Number of counts until reset after limit function is triggered (Ncr).
     */
    val ncr: Double,

    /**
     * (Pmin).
     */
    val pmin: Double,

    /**
     * Time constant (T1).
     * Typical Value = 0.3.
     */
    val t1: Double,

    /**
     * Time constant (T2).
     * Typical Value = 1.
     */
    val t2: Double,

    /**
     * Time constant (T3).
     * Typical Value = 0.2.
     */
    val t3: Double,

    /**
     * Time constant (T4).
     * Typical Value = 0.05.
     */
    val t4: Double,

    /**
     * Time constant (T5).
     */
    val t5: Double,

    /**
     * Time constant (T6).
     */
    val t6: Double,

    /**
     * Time constant (Tf).
     * Typical Value = 0.2.
     */
    val tf: Double,

    /**
     * Time constant (Tp).
     * Typical Value = 0.2.
     */
    val tp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssPTIST3]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssPTIST3
extends
    Parseable[PssPTIST3]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val a0 = parse_element (element ("""PssPTIST3.a0"""))_
    val a1 = parse_element (element ("""PssPTIST3.a1"""))_
    val a2 = parse_element (element ("""PssPTIST3.a2"""))_
    val a3 = parse_element (element ("""PssPTIST3.a3"""))_
    val a4 = parse_element (element ("""PssPTIST3.a4"""))_
    val a5 = parse_element (element ("""PssPTIST3.a5"""))_
    val al = parse_element (element ("""PssPTIST3.al"""))_
    val athres = parse_element (element ("""PssPTIST3.athres"""))_
    val b0 = parse_element (element ("""PssPTIST3.b0"""))_
    val b1 = parse_element (element ("""PssPTIST3.b1"""))_
    val b2 = parse_element (element ("""PssPTIST3.b2"""))_
    val b3 = parse_element (element ("""PssPTIST3.b3"""))_
    val b4 = parse_element (element ("""PssPTIST3.b4"""))_
    val b5 = parse_element (element ("""PssPTIST3.b5"""))_
    val dl = parse_element (element ("""PssPTIST3.dl"""))_
    val dtc = parse_element (element ("""PssPTIST3.dtc"""))_
    val dtf = parse_element (element ("""PssPTIST3.dtf"""))_
    val dtp = parse_element (element ("""PssPTIST3.dtp"""))_
    val isw = parse_element (element ("""PssPTIST3.isw"""))_
    val k = parse_element (element ("""PssPTIST3.k"""))_
    val lthres = parse_element (element ("""PssPTIST3.lthres"""))_
    val m = parse_element (element ("""PssPTIST3.m"""))_
    val nav = parse_element (element ("""PssPTIST3.nav"""))_
    val ncl = parse_element (element ("""PssPTIST3.ncl"""))_
    val ncr = parse_element (element ("""PssPTIST3.ncr"""))_
    val pmin = parse_element (element ("""PssPTIST3.pmin"""))_
    val t1 = parse_element (element ("""PssPTIST3.t1"""))_
    val t2 = parse_element (element ("""PssPTIST3.t2"""))_
    val t3 = parse_element (element ("""PssPTIST3.t3"""))_
    val t4 = parse_element (element ("""PssPTIST3.t4"""))_
    val t5 = parse_element (element ("""PssPTIST3.t5"""))_
    val t6 = parse_element (element ("""PssPTIST3.t6"""))_
    val tf = parse_element (element ("""PssPTIST3.tf"""))_
    val tp = parse_element (element ("""PssPTIST3.tp"""))_
    def parse (context: Context): PssPTIST3 =
    {
        PssPTIST3(
            sup (context),
            toDouble (a0 (context), context),
            toDouble (a1 (context), context),
            toDouble (a2 (context), context),
            toDouble (a3 (context), context),
            toDouble (a4 (context), context),
            toDouble (a5 (context), context),
            toDouble (al (context), context),
            toDouble (athres (context), context),
            toDouble (b0 (context), context),
            toDouble (b1 (context), context),
            toDouble (b2 (context), context),
            toDouble (b3 (context), context),
            toDouble (b4 (context), context),
            toDouble (b5 (context), context),
            toDouble (dl (context), context),
            toDouble (dtc (context), context),
            toDouble (dtf (context), context),
            toDouble (dtp (context), context),
            toBoolean (isw (context), context),
            toDouble (k (context), context),
            toDouble (lthres (context), context),
            toDouble (m (context), context),
            toDouble (nav (context), context),
            toDouble (ncl (context), context),
            toDouble (ncr (context), context),
            toDouble (pmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (tf (context), context),
            toDouble (tp (context), context)
        )
    }
}

/**
 * Power sensitive stabilizer model.
 */
case class PssSB4
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Gain (Kx).
     */
    val kx: Double,

    /**
     * Time constant (Ta).
     */
    val ta: Double,

    /**
     * Time constant (Tb).
     */
    val tb: Double,

    /**
     * Time constant (Tc).
     */
    val tc: Double,

    /**
     * Time constant (Td).
     */
    val td: Double,

    /**
     * Time constant (Te).
     */
    val te: Double,

    /**
     * Time constant (Tt).
     */
    val tt: Double,

    /**
     * Reset time constant (Tx1).
     */
    val tx1: Double,

    /**
     * Time constant (Tx2).
     */
    val tx2: Double,

    /**
     * Limiter (Vsmax).
     */
    val vsmax: Double,

    /**
     * Limiter (Vsmin).
     */
    val vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssSB4]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssSB4
extends
    Parseable[PssSB4]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val kx = parse_element (element ("""PssSB4.kx"""))_
    val ta = parse_element (element ("""PssSB4.ta"""))_
    val tb = parse_element (element ("""PssSB4.tb"""))_
    val tc = parse_element (element ("""PssSB4.tc"""))_
    val td = parse_element (element ("""PssSB4.td"""))_
    val te = parse_element (element ("""PssSB4.te"""))_
    val tt = parse_element (element ("""PssSB4.tt"""))_
    val tx1 = parse_element (element ("""PssSB4.tx1"""))_
    val tx2 = parse_element (element ("""PssSB4.tx2"""))_
    val vsmax = parse_element (element ("""PssSB4.vsmax"""))_
    val vsmin = parse_element (element ("""PssSB4.vsmin"""))_
    def parse (context: Context): PssSB4 =
    {
        PssSB4(
            sup (context),
            toDouble (kx (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (td (context), context),
            toDouble (te (context), context),
            toDouble (tt (context), context),
            toDouble (tx1 (context), context),
            toDouble (tx2 (context), context),
            toDouble (vsmax (context), context),
            toDouble (vsmin (context), context)
        )
    }
}

/**
 * Model for Siemens �H infinity� power system stabilizer with generator electrical power input.
 */
case class PssSH
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Main gain (K).
     * Typical Value = 1.
     */
    val k: Double,

    /**
     * Gain 0 (K0).
     * Typical Value = 0.012.
     */
    val k0: Double,

    /**
     * Gain 1 (K1).
     * Typical Value = 0.488.
     */
    val k1: Double,

    /**
     * Gain 2 (K2).
     * Typical Value = 0.064.
     */
    val k2: Double,

    /**
     * Gain 3 (K3).
     * Typical Value = 0.224.
     */
    val k3: Double,

    /**
     * Gain 4 (K4).
     * Typical Value = 0.1.
     */
    val k4: Double,

    /**
     * Time constant 1 (T1).
     * Typical Value = 0.076.
     */
    val t1: Double,

    /**
     * Time constant 2 (T2).
     * Typical Value = 0.086.
     */
    val t2: Double,

    /**
     * Time constant 3 (T3).
     * Typical Value = 1.068.
     */
    val t3: Double,

    /**
     * Time constant 4 (T4).
     * Typical Value = 1.913.
     */
    val t4: Double,

    /**
     * Input time constant (Td).
     * Typical Value = 10.
     */
    val td: Double,

    /**
     * Output maximum limit (Vsmax).
     * Typical Value = 0.1.
     */
    val vsmax: Double,

    /**
     * Output minimum limit (Vsmin).
     * Typical Value = -0.1.
     */
    val vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssSH]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssSH
extends
    Parseable[PssSH]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val k = parse_element (element ("""PssSH.k"""))_
    val k0 = parse_element (element ("""PssSH.k0"""))_
    val k1 = parse_element (element ("""PssSH.k1"""))_
    val k2 = parse_element (element ("""PssSH.k2"""))_
    val k3 = parse_element (element ("""PssSH.k3"""))_
    val k4 = parse_element (element ("""PssSH.k4"""))_
    val t1 = parse_element (element ("""PssSH.t1"""))_
    val t2 = parse_element (element ("""PssSH.t2"""))_
    val t3 = parse_element (element ("""PssSH.t3"""))_
    val t4 = parse_element (element ("""PssSH.t4"""))_
    val td = parse_element (element ("""PssSH.td"""))_
    val vsmax = parse_element (element ("""PssSH.vsmax"""))_
    val vsmin = parse_element (element ("""PssSH.vsmin"""))_
    def parse (context: Context): PssSH =
    {
        PssSH(
            sup (context),
            toDouble (k (context), context),
            toDouble (k0 (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (td (context), context),
            toDouble (vsmax (context), context),
            toDouble (vsmin (context), context)
        )
    }
}

/**
 * PSS Slovakian type � three inputs.
 */
case class PssSK
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Gain P (K1).
     * Typical Value = -0.3.
     */
    val k1: Double,

    /**
     * Gain fe (K2).
     * Typical Value = -0.15.
     */
    val k2: Double,

    /**
     * Gain If (K3).
     * Typical Value = 10.
     */
    val k3: Double,

    /**
     * Denominator time constant (T1).
     * Typical Value = 0.3.
     */
    val t1: Double,

    /**
     * Filter time constant (T2).
     * Typical Value = 0.35.
     */
    val t2: Double,

    /**
     * Denominator time constant (T3).
     * Typical Value = 0.22.
     */
    val t3: Double,

    /**
     * Filter time constant (T4).
     * Typical Value = 0.02.
     */
    val t4: Double,

    /**
     * Denominator time constant (T5).
     * Typical Value = 0.02.
     */
    val t5: Double,

    /**
     * Filter time constant (T6).
     * Typical Value = 0.02.
     */
    val t6: Double,

    /**
     * Stabilizer output max limit (Vsmax).
     * Typical Value = 0.4.
     */
    val vsmax: Double,

    /**
     * Stabilizer output min limit (Vsmin).
     * Typical Value = -0.4.
     */
    val vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssSK]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssSK
extends
    Parseable[PssSK]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val k1 = parse_element (element ("""PssSK.k1"""))_
    val k2 = parse_element (element ("""PssSK.k2"""))_
    val k3 = parse_element (element ("""PssSK.k3"""))_
    val t1 = parse_element (element ("""PssSK.t1"""))_
    val t2 = parse_element (element ("""PssSK.t2"""))_
    val t3 = parse_element (element ("""PssSK.t3"""))_
    val t4 = parse_element (element ("""PssSK.t4"""))_
    val t5 = parse_element (element ("""PssSK.t5"""))_
    val t6 = parse_element (element ("""PssSK.t6"""))_
    val vsmax = parse_element (element ("""PssSK.vsmax"""))_
    val vsmin = parse_element (element ("""PssSK.vsmin"""))_
    def parse (context: Context): PssSK =
    {
        PssSK(
            sup (context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (vsmax (context), context),
            toDouble (vsmin (context), context)
        )
    }
}

/**
 * Dual input Power System Stabilizer, based on IEEE type 2, with modified output limiter defined by WECC (Western Electricity Coordinating Council, USA).
 */
case class PssWECC
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Type of input signal #1.
     */
    val inputSignal1Type: String,

    /**
     * Type of input signal #2.
     */
    val inputSignal2Type: String,

    /**
     * Input signal 1 gain  (K<sub>1</sub>).
     */
    val k1: Double,

    /**
     * Input signal 2 gain (K<sub>2</sub>).
     */
    val k2: Double,

    /**
     * Input signal 1 transducer time constant (T<sub>1</sub>).
     */
    val t1: Double,

    /**
     * Lag time constant (T<sub>10</sub>).
     */
    val t10: Double,

    /**
     * Input signal 2 transducer time constant (T<sub>2</sub>).
     */
    val t2: Double,

    /**
     * Stabilizer washout time constant (T<sub>3</sub>).
     */
    val t3: Double,

    /**
     * Stabilizer washout time lag constant (T<sub>4</sub>) (&gt;0).
     */
    val t4: Double,

    /**
     * Lead time constant (T<sub>5</sub>).
     */
    val t5: Double,

    /**
     * Lag time constant (T<sub>6</sub>).
     */
    val t6: Double,

    /**
     * Lead time constant (T<sub>7</sub>).
     */
    val t7: Double,

    /**
     * Lag time constant (T<sub>8</sub>).
     */
    val t8: Double,

    /**
     * Lead time constant (T<sub>9</sub>).
     */
    val t9: Double,

    /**
     * Minimum value for voltage compensator output (V<sub>CL</sub>).
     */
    val vcl: Double,

    /**
     * Maximum value for voltage compensator output (V<sub>CU</sub>).
     */
    val vcu: Double,

    /**
     * Maximum output signal (Vsmax).
     */
    val vsmax: Double,

    /**
     * Minimum output signal (Vsmin).
     */
    val vsmin: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PssWECC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PssWECC
extends
    Parseable[PssWECC]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val inputSignal1Type = parse_attribute (attribute ("""PssWECC.inputSignal1Type"""))_
    val inputSignal2Type = parse_attribute (attribute ("""PssWECC.inputSignal2Type"""))_
    val k1 = parse_element (element ("""PssWECC.k1"""))_
    val k2 = parse_element (element ("""PssWECC.k2"""))_
    val t1 = parse_element (element ("""PssWECC.t1"""))_
    val t10 = parse_element (element ("""PssWECC.t10"""))_
    val t2 = parse_element (element ("""PssWECC.t2"""))_
    val t3 = parse_element (element ("""PssWECC.t3"""))_
    val t4 = parse_element (element ("""PssWECC.t4"""))_
    val t5 = parse_element (element ("""PssWECC.t5"""))_
    val t6 = parse_element (element ("""PssWECC.t6"""))_
    val t7 = parse_element (element ("""PssWECC.t7"""))_
    val t8 = parse_element (element ("""PssWECC.t8"""))_
    val t9 = parse_element (element ("""PssWECC.t9"""))_
    val vcl = parse_element (element ("""PssWECC.vcl"""))_
    val vcu = parse_element (element ("""PssWECC.vcu"""))_
    val vsmax = parse_element (element ("""PssWECC.vsmax"""))_
    val vsmin = parse_element (element ("""PssWECC.vsmin"""))_
    def parse (context: Context): PssWECC =
    {
        PssWECC(
            sup (context),
            inputSignal1Type (context),
            inputSignal2Type (context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (t1 (context), context),
            toDouble (t10 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (t9 (context), context),
            toDouble (vcl (context), context),
            toDouble (vcu (context), context),
            toDouble (vsmax (context), context),
            toDouble (vsmin (context), context)
        )
    }
}

object _PowerSystemStabilizerDynamics
{
    def register: Unit =
    {
        InputSignalKind.register
        PowerSystemStabilizerDynamics.register
        Pss1.register
        Pss1A.register
        Pss2B.register
        Pss2ST.register
        Pss5.register
        PssELIN2.register
        PssIEEE1A.register
        PssIEEE2B.register
        PssIEEE3B.register
        PssIEEE4B.register
        PssPTIST1.register
        PssPTIST3.register
        PssSB4.register
        PssSH.register
        PssSK.register
        PssWECC.register
    }
}