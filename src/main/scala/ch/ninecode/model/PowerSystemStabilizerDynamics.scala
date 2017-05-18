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
 * @param sup Reference to the superclass object.
 * @param branchCurrent Input signal is amplitude of remote branch current.
 * @param busFrequency Input signal is bus voltage fr<font color="#0f0f0f">equency.
 *        This could be a terminal frequency or remote frequency.</font>
 * @param busFrequencyDeviation Input signal is deviation of bus voltage frequ<font color="#0f0f0f">ency.
 *        This could be a terminal frequency deviation or remote frequency deviation.</font>
 * @param busVoltage Input signal <font color="#0f0f0f">is bus voltage.
 *        This could be a terminal voltage or remote voltage.</font>
 * @param busVoltageDerivative Input signal is derivative of bus voltag<font color="#0f0f0f">e.
 *        This could be a terminal voltage derivative or remote voltage derivative.</font>
 * @param fieldCurrent Input signal is generator field current.
 * @param generatorAcceleratingPower Input signal is generating accelerating power.
 * @param generatorElectricalPower Input signal is generator electrical power on rated S.
 * @param rotorAngularFrequencyDeviation Input signal is rotor or shaft angular frequency deviation.
 * @param rotorSpeed Input signal is rotor or shaft speed (angular frequency).
 */
case class InputSignalKind
(
    override val sup: Element,
    val branchCurrent: String,
    val busFrequency: String,
    val busFrequencyDeviation: String,
    val busVoltage: String,
    val busVoltageDerivative: String,
    val fieldCurrent: String,
    val generatorAcceleratingPower: String,
    val generatorElectricalPower: String,
    val rotorAngularFrequencyDeviation: String,
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
    val branchCurrent = parse_attribute (attribute ("""InputSignalKind.branchCurrent"""))
    val busFrequency = parse_attribute (attribute ("""InputSignalKind.busFrequency"""))
    val busFrequencyDeviation = parse_attribute (attribute ("""InputSignalKind.busFrequencyDeviation"""))
    val busVoltage = parse_attribute (attribute ("""InputSignalKind.busVoltage"""))
    val busVoltageDerivative = parse_attribute (attribute ("""InputSignalKind.busVoltageDerivative"""))
    val fieldCurrent = parse_attribute (attribute ("""InputSignalKind.fieldCurrent"""))
    val generatorAcceleratingPower = parse_attribute (attribute ("""InputSignalKind.generatorAcceleratingPower"""))
    val generatorElectricalPower = parse_attribute (attribute ("""InputSignalKind.generatorElectricalPower"""))
    val rotorAngularFrequencyDeviation = parse_attribute (attribute ("""InputSignalKind.rotorAngularFrequencyDeviation"""))
    val rotorSpeed = parse_attribute (attribute ("""InputSignalKind.rotorSpeed"""))
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
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this power system stabilizer model is associated.
 */
case class PowerSystemStabilizerDynamics
(
    override val sup: Element,
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
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PowerSystemStabilizerDynamics.ExcitationSystemDynamics"""))
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
 * @param sup Reference to the superclass object.
 * @param kf Frequency power input gain (K<sub>F</sub>).
 *        Typical Value = 5.
 * @param kpe Electric power input gain (K<sub>PE</sub>).
 *        Typical Value = 0.3.
 * @param ks PSS gain (K<sub>S</sub>).
 *        Typical Value = 1.
 * @param kw Shaft speed power input gain (K<sub>W</sub>).
 *        Typical Value = 0.
 * @param pmin Minimum power PSS enabling (P<sub>MIN</sub>).
 *        Typical Value = 0.25.
 * @param t10 Lead/lag time constant (T<sub>10</sub>).
 *        Typical Value = 0.
 * @param t5 Washout (T<sub>5</sub>).
 *        Typical Value = 3.5.
 * @param t6 Filter time constant (T<sub>6</sub>).
 *        Typical Value = 0.
 * @param t7 Lead/lag time constant (T<sub>7</sub>).
 *        Typical Value = 0.
 * @param t8 Lead/lag time constant (T<sub>8</sub>).
 *        Typical Value = 0.
 * @param t9 Lead/lag time constant (T<sub>9</sub>).
 *        Typical Value = 0.
 * @param tpe Electric power filter time constant (T<sub>PE</sub>).
 *        Typical Value = 0.05.
 * @param vadat <font color="#0f0f0f">Signal selector (V<sub>adAt</sub>).</font>
<font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
<font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
 *        <font color="#0f0f0f">Typical Value = true.</font>
 * @param vsmn Stabilizer output max limit (V<sub>SMN</sub>).
 *        Typical Value = -0.06.
 * @param vsmx Stabilizer output min limit (V<sub>SMX</sub>).
 *        Typical Value = 0.06.
 */
case class Pss1
(
    override val sup: Element,
    val kf: Double,
    val kpe: Double,
    val ks: Double,
    val kw: Double,
    val pmin: Double,
    val t10: Double,
    val t5: Double,
    val t6: Double,
    val t7: Double,
    val t8: Double,
    val t9: Double,
    val tpe: Double,
    val vadat: Boolean,
    val vsmn: Double,
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
    val kf = parse_element (element ("""Pss1.kf"""))
    val kpe = parse_element (element ("""Pss1.kpe"""))
    val ks = parse_element (element ("""Pss1.ks"""))
    val kw = parse_element (element ("""Pss1.kw"""))
    val pmin = parse_element (element ("""Pss1.pmin"""))
    val t10 = parse_element (element ("""Pss1.t10"""))
    val t5 = parse_element (element ("""Pss1.t5"""))
    val t6 = parse_element (element ("""Pss1.t6"""))
    val t7 = parse_element (element ("""Pss1.t7"""))
    val t8 = parse_element (element ("""Pss1.t8"""))
    val t9 = parse_element (element ("""Pss1.t9"""))
    val tpe = parse_element (element ("""Pss1.tpe"""))
    val vadat = parse_element (element ("""Pss1.vadat"""))
    val vsmn = parse_element (element ("""Pss1.vsmn"""))
    val vsmx = parse_element (element ("""Pss1.vsmx"""))
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
 * @param sup Reference to the superclass object.
 * @param a1 Notch filter parameter (A1).
 * @param a2 Notch filter parameter (A2).
 * @param a3 Notch filter parameter (A3).
 * @param a4 Notch filter parameter (A4).
 * @param a5 Notch filter parameter (A5).
 * @param a6 Notch filter parameter (A6).
 * @param a7 Notch filter parameter (A7).
 * @param a8 Notch filter parameter (A8).
 * @param inputSignalType Type of input signal.
 * @param kd Selector (Kd). 
true = e<sup>-sTdelay</sup> used
 *        false = e<sup>-sTdelay</sup> not used.
 * @param ks Stabilizer gain (Ks).
 * @param t1 Lead/lag time constant (T1).
 * @param t2 Lead/lag time constant (T2).
 * @param t3 Lead/lag time constant (T3).
 * @param t4 Lead/lag time constant (T4).
 * @param t5 Washout time constant (T5).
 * @param t6 Transducer time constant (T6).
 * @param tdelay Time constant (Tdelay).
 * @param vcl Stabilizer input cutoff threshold (Vcl).
 * @param vcu Stabilizer input cutoff threshold (Vcu).
 * @param vrmax Maximum stabilizer output (Vrmax).
 * @param vrmin Minimum stabilizer output (Vrmin).
 */
case class Pss1A
(
    override val sup: Element,
    val a1: Double,
    val a2: Double,
    val a3: Double,
    val a4: Double,
    val a5: Double,
    val a6: Double,
    val a7: Double,
    val a8: Double,
    val inputSignalType: String,
    val kd: Boolean,
    val ks: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val tdelay: Double,
    val vcl: Double,
    val vcu: Double,
    val vrmax: Double,
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
    val a1 = parse_element (element ("""Pss1A.a1"""))
    val a2 = parse_element (element ("""Pss1A.a2"""))
    val a3 = parse_element (element ("""Pss1A.a3"""))
    val a4 = parse_element (element ("""Pss1A.a4"""))
    val a5 = parse_element (element ("""Pss1A.a5"""))
    val a6 = parse_element (element ("""Pss1A.a6"""))
    val a7 = parse_element (element ("""Pss1A.a7"""))
    val a8 = parse_element (element ("""Pss1A.a8"""))
    val inputSignalType = parse_attribute (attribute ("""Pss1A.inputSignalType"""))
    val kd = parse_element (element ("""Pss1A.kd"""))
    val ks = parse_element (element ("""Pss1A.ks"""))
    val t1 = parse_element (element ("""Pss1A.t1"""))
    val t2 = parse_element (element ("""Pss1A.t2"""))
    val t3 = parse_element (element ("""Pss1A.t3"""))
    val t4 = parse_element (element ("""Pss1A.t4"""))
    val t5 = parse_element (element ("""Pss1A.t5"""))
    val t6 = parse_element (element ("""Pss1A.t6"""))
    val tdelay = parse_element (element ("""Pss1A.tdelay"""))
    val vcl = parse_element (element ("""Pss1A.vcl"""))
    val vcu = parse_element (element ("""Pss1A.vcu"""))
    val vrmax = parse_element (element ("""Pss1A.vrmax"""))
    val vrmin = parse_element (element ("""Pss1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param a Numerator constant (a).
 *        Typical Value = 1.
 * @param inputSignal1Type Type of input signal #1.
 *        Typical Value = rotorSpeed.
 * @param inputSignal2Type Type of input signal #2.
 *        Typical Value = generatorElectricalPower.
 * @param ks1 Stabilizer gain (Ks1).
 *        Typical Value = 12.
 * @param ks2 Gain on signal #2 (Ks2).
 *        Typical Value = 0.2.
 * @param ks3 Gain on signal #2 input before ramp-tracking filter (Ks3).
 *        Typical Value = 1.
 * @param ks4 Gain on signal #2 input after ramp-tracking filter (Ks4).
 *        Typical Value = 1.
 * @param m Denominator order of ramp tracking filter (M).
 *        Typical Value = 5.
 * @param n Order of ramp tracking filter (N).
 *        Typical Value = 1.
 * @param t1 Lead/lag time constant (T1).
 *        Typical Value = 0.12.
 * @param t10 Lead/lag time constant (T10).
 *        Typical Value = 0.
 * @param t11 Lead/lag time constant (T11).
 *        Typical Value = 0.
 * @param t2 Lead/lag time constant (T2).
 *        Typical Value = 0.02.
 * @param t3 Lead/lag time constant (T3).
 *        Typical Value = 0.3.
 * @param t4 Lead/lag time constant (T4).
 *        Typical Value = 0.02.
 * @param t6 Time constant on signal #1 (T6).
 *        Typical Value = 0.
 * @param t7 Time constant on signal #2 (T7).
 *        Typical Value = 2.
 * @param t8 Lead of ramp tracking filter (T8).
 *        Typical Value = 0.2.
 * @param t9 Lag of ramp tracking filter (T9).
 *        Typical Value = 0.1.
 * @param ta Lead constant (Ta).
 *        Typical Value = 0.
 * @param tb Lag time constant (Tb).
 *        Typical Value = 0.
 * @param tw1 First washout on signal #1 (Tw1).
 *        Typical Value = 2.
 * @param tw2 Second washout on signal #1 (Tw2).
 *        Typical Value = 2.
 * @param tw3 First washout on signal #2 (Tw3).
 *        Typical Value = 2.
 * @param tw4 Second washout on signal #2 (Tw4).
 *        Typical Value = 0.
 * @param vsi1max Input signal #1 max limit (Vsi1max).
 *        Typical Value = 2.
 * @param vsi1min Input signal #1 min limit (Vsi1min).
 *        Typical Value = -2.
 * @param vsi2max Input signal #2 max limit (Vsi2max).
 *        Typical Value = 2.
 * @param vsi2min Input signal #2 min limit (Vsi2min).
 *        Typical Value = -2.
 * @param vstmax Stabilizer output max limit (Vstmax).
 *        Typical Value = 0.1.
 * @param vstmin Stabilizer output min limit (Vstmin).
 *        Typical Value = -0.1.
 */
case class Pss2B
(
    override val sup: Element,
    val a: Double,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: Double,
    val ks2: Double,
    val ks3: Double,
    val ks4: Double,
    val m: Int,
    val n: Int,
    val t1: Double,
    val t10: Double,
    val t11: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t6: Double,
    val t7: Double,
    val t8: Double,
    val t9: Double,
    val ta: Double,
    val tb: Double,
    val tw1: Double,
    val tw2: Double,
    val tw3: Double,
    val tw4: Double,
    val vsi1max: Double,
    val vsi1min: Double,
    val vsi2max: Double,
    val vsi2min: Double,
    val vstmax: Double,
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
    val a = parse_element (element ("""Pss2B.a"""))
    val inputSignal1Type = parse_attribute (attribute ("""Pss2B.inputSignal1Type"""))
    val inputSignal2Type = parse_attribute (attribute ("""Pss2B.inputSignal2Type"""))
    val ks1 = parse_element (element ("""Pss2B.ks1"""))
    val ks2 = parse_element (element ("""Pss2B.ks2"""))
    val ks3 = parse_element (element ("""Pss2B.ks3"""))
    val ks4 = parse_element (element ("""Pss2B.ks4"""))
    val m = parse_element (element ("""Pss2B.m"""))
    val n = parse_element (element ("""Pss2B.n"""))
    val t1 = parse_element (element ("""Pss2B.t1"""))
    val t10 = parse_element (element ("""Pss2B.t10"""))
    val t11 = parse_element (element ("""Pss2B.t11"""))
    val t2 = parse_element (element ("""Pss2B.t2"""))
    val t3 = parse_element (element ("""Pss2B.t3"""))
    val t4 = parse_element (element ("""Pss2B.t4"""))
    val t6 = parse_element (element ("""Pss2B.t6"""))
    val t7 = parse_element (element ("""Pss2B.t7"""))
    val t8 = parse_element (element ("""Pss2B.t8"""))
    val t9 = parse_element (element ("""Pss2B.t9"""))
    val ta = parse_element (element ("""Pss2B.ta"""))
    val tb = parse_element (element ("""Pss2B.tb"""))
    val tw1 = parse_element (element ("""Pss2B.tw1"""))
    val tw2 = parse_element (element ("""Pss2B.tw2"""))
    val tw3 = parse_element (element ("""Pss2B.tw3"""))
    val tw4 = parse_element (element ("""Pss2B.tw4"""))
    val vsi1max = parse_element (element ("""Pss2B.vsi1max"""))
    val vsi1min = parse_element (element ("""Pss2B.vsi1min"""))
    val vsi2max = parse_element (element ("""Pss2B.vsi2max"""))
    val vsi2min = parse_element (element ("""Pss2B.vsi2min"""))
    val vstmax = parse_element (element ("""Pss2B.vstmax"""))
    val vstmin = parse_element (element ("""Pss2B.vstmin"""))
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
 * @param sup Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 *        Typical Value = rotorAngularFrequencyDeviation.
 * @param inputSignal2Type Type of input signal #2.
 *        Typical Value = generatorElectricalPower.
 * @param k1 Gain (K1).
 * @param k2 Gain (K2).
 * @param lsmax Limiter (Lsmax).
 * @param lsmin Limiter (Lsmin).
 * @param t1 Time constant (T1).
 * @param t10 Time constant (T10).
 * @param t2 Time constant (T2).
 * @param t3 Time constant (T3).
 * @param t4 Time constant (T4).
 * @param t5 Time constant (T5).
 * @param t6 Time constant (T6).
 * @param t7 Time constant (T7).
 * @param t8 Time constant (T8).
 * @param t9 Time constant (T9).
 * @param vcl Cutoff limiter (Vcl).
 * @param vcu Cutoff limiter (Vcu).
 */
case class Pss2ST
(
    override val sup: Element,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: Double,
    val k2: Double,
    val lsmax: Double,
    val lsmin: Double,
    val t1: Double,
    val t10: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val t7: Double,
    val t8: Double,
    val t9: Double,
    val vcl: Double,
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
    val inputSignal1Type = parse_attribute (attribute ("""Pss2ST.inputSignal1Type"""))
    val inputSignal2Type = parse_attribute (attribute ("""Pss2ST.inputSignal2Type"""))
    val k1 = parse_element (element ("""Pss2ST.k1"""))
    val k2 = parse_element (element ("""Pss2ST.k2"""))
    val lsmax = parse_element (element ("""Pss2ST.lsmax"""))
    val lsmin = parse_element (element ("""Pss2ST.lsmin"""))
    val t1 = parse_element (element ("""Pss2ST.t1"""))
    val t10 = parse_element (element ("""Pss2ST.t10"""))
    val t2 = parse_element (element ("""Pss2ST.t2"""))
    val t3 = parse_element (element ("""Pss2ST.t3"""))
    val t4 = parse_element (element ("""Pss2ST.t4"""))
    val t5 = parse_element (element ("""Pss2ST.t5"""))
    val t6 = parse_element (element ("""Pss2ST.t6"""))
    val t7 = parse_element (element ("""Pss2ST.t7"""))
    val t8 = parse_element (element ("""Pss2ST.t8"""))
    val t9 = parse_element (element ("""Pss2ST.t9"""))
    val vcl = parse_element (element ("""Pss2ST.vcl"""))
    val vcu = parse_element (element ("""Pss2ST.vcu"""))
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
 * @param sup Reference to the superclass object.
 * @param ctw2 Selector for Second washout enabling (C<sub>TW2</sub>).
true = second washout filter is bypassed
false = second washout filter in use.
 *        Typical Value = true.
 * @param deadband Stabilizer output dead band (DeadBand).
 *        Typical Value = 0.
 * @param isfreq Selector for Frequency/shaft speed input (IsFreq).
true = speed
false = frequency.
 *        Typical Value = true.
 * @param kf Frequency/shaft speed input gain (K<sub>F</sub>).
 *        Typical Value = 5.
 * @param kpe Electric power input gain (K<sub>PE</sub>).
 *        Typical Value = 0.3.
 * @param kpss PSS gain (K<sub>PSS</sub>).
 *        Typical Value = 1.
 * @param pmm Minimum power PSS enabling (P<sub>mn</sub>).
 *        Typical Value = 0.25.
 * @param tl1 Lead/lag time constant (T<sub>L1</sub>).
 *        Typical Value = 0.
 * @param tl2 Lead/lag time constant (T<sub>L2</sub>).
 *        Typical Value = 0.
 * @param tl3 Lead/lag time constant (T<sub>L3</sub>).
 *        Typical Value = 0.
 * @param tl4 Lead/lag time constant (T<sub>L4</sub>).
 *        Typical Value = 0.
 * @param tpe Electric power filter time constant (T<sub>PE</sub>).
 *        Typical Value = 0.05.
 * @param tw1 First WashOut (T<sub>w1</sub>).
 *        Typical Value = 3.5.
 * @param tw2 Second WashOut (T<sub>w2</sub>).
 *        Typical Value = 0.
 * @param vadat <font color="#0f0f0f">Signal selector (V<sub>adAtt</sub>).</font>
<font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
<font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
 *        <font color="#0f0f0f">Typical Value = true.</font>
 * @param vsmn Stabilizer output max limit (V<sub>SMN</sub>).
 *        Typical Value = -0.1.
 * @param vsmx Stabilizer output min limit (V<sub>SMX</sub>).
 *        Typical Value = 0.1.
 */
case class Pss5
(
    override val sup: Element,
    val ctw2: Boolean,
    val deadband: Double,
    val isfreq: Boolean,
    val kf: Double,
    val kpe: Double,
    val kpss: Double,
    val pmm: Double,
    val tl1: Double,
    val tl2: Double,
    val tl3: Double,
    val tl4: Double,
    val tpe: Double,
    val tw1: Double,
    val tw2: Double,
    val vadat: Boolean,
    val vsmn: Double,
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
    val ctw2 = parse_element (element ("""Pss5.ctw2"""))
    val deadband = parse_element (element ("""Pss5.deadband"""))
    val isfreq = parse_element (element ("""Pss5.isfreq"""))
    val kf = parse_element (element ("""Pss5.kf"""))
    val kpe = parse_element (element ("""Pss5.kpe"""))
    val kpss = parse_element (element ("""Pss5.kpss"""))
    val pmm = parse_element (element ("""Pss5.pmm"""))
    val tl1 = parse_element (element ("""Pss5.tl1"""))
    val tl2 = parse_element (element ("""Pss5.tl2"""))
    val tl3 = parse_element (element ("""Pss5.tl3"""))
    val tl4 = parse_element (element ("""Pss5.tl4"""))
    val tpe = parse_element (element ("""Pss5.tpe"""))
    val tw1 = parse_element (element ("""Pss5.tw1"""))
    val tw2 = parse_element (element ("""Pss5.tw2"""))
    val vadat = parse_element (element ("""Pss5.vadat"""))
    val vsmn = parse_element (element ("""Pss5.vsmn"""))
    val vsmx = parse_element (element ("""Pss5.vsmx"""))
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
 * @param sup Reference to the superclass object.
 * @param apss Coefficient (a_PSS).
 *        Typical Value = 0.1.
 * @param ks1 Gain (Ks1).
 *        Typical Value = 1.
 * @param ks2 Gain (Ks2).
 *        Typical Value = 0.1.
 * @param ppss Coefficient (p_PSS) (&gt;=0 and &lt;=4).
 *        Typical Value = 0.1.
 * @param psslim PSS limiter (psslim).
 *        Typical Value = 0.1.
 * @param ts1 Time constant (Ts1).
 *        Typical Value = 0.
 * @param ts2 Time constant (Ts2).
 *        Typical Value = 1.
 * @param ts3 Time constant (Ts3).
 *        Typical Value = 1.
 * @param ts4 Time constant (Ts4).
 *        Typical Value = 0.1.
 * @param ts5 Time constant (Ts5).
 *        Typical Value = 0.
 * @param ts6 Time constant (Ts6).
 *        Typical Value = 1.
 */
case class PssELIN2
(
    override val sup: Element,
    val apss: Double,
    val ks1: Double,
    val ks2: Double,
    val ppss: Double,
    val psslim: Double,
    val ts1: Double,
    val ts2: Double,
    val ts3: Double,
    val ts4: Double,
    val ts5: Double,
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
    val apss = parse_element (element ("""PssELIN2.apss"""))
    val ks1 = parse_element (element ("""PssELIN2.ks1"""))
    val ks2 = parse_element (element ("""PssELIN2.ks2"""))
    val ppss = parse_element (element ("""PssELIN2.ppss"""))
    val psslim = parse_element (element ("""PssELIN2.psslim"""))
    val ts1 = parse_element (element ("""PssELIN2.ts1"""))
    val ts2 = parse_element (element ("""PssELIN2.ts2"""))
    val ts3 = parse_element (element ("""PssELIN2.ts3"""))
    val ts4 = parse_element (element ("""PssELIN2.ts4"""))
    val ts5 = parse_element (element ("""PssELIN2.ts5"""))
    val ts6 = parse_element (element ("""PssELIN2.ts6"""))
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
 * @param sup Reference to the superclass object.
 * @param a1 PSS signal conditioning frequency filter constant (A1).
 *        Typical Value = 0.061.
 * @param a2 PSS signal conditioning frequency filter constant (A2).
 *        Typical Value = 0.0017.
 * @param inputSignalType Type of input signal.
 *        Typical Value = rotorAngularFrequencyDeviation.
 * @param ks Stabilizer gain (Ks).
 *        Typical Value = 5.
 * @param t1 Lead/lag time constant (T1).
 *        Typical Value = 0.3.
 * @param t2 Lead/lag time constant (T2).
 *        Typical Value = 0.03.
 * @param t3 Lead/lag time constant (T3).
 *        Typical Value = 0.3.
 * @param t4 Lead/lag time constant (T4).
 *        Typical Value = 0.03.
 * @param t5 Washout time constant (T5).
 *        Typical Value = 10.
 * @param t6 Transducer time constant (T6).
 *        Typical Value = 0.01.
 * @param vrmax Maximum stabilizer output (Vrmax).
 *        Typical Value = 0.05.
 * @param vrmin Minimum stabilizer output (Vrmin).
 *        Typical Value = -0.05.
 */
case class PssIEEE1A
(
    override val sup: Element,
    val a1: Double,
    val a2: Double,
    val inputSignalType: String,
    val ks: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val vrmax: Double,
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
    val a1 = parse_element (element ("""PssIEEE1A.a1"""))
    val a2 = parse_element (element ("""PssIEEE1A.a2"""))
    val inputSignalType = parse_attribute (attribute ("""PssIEEE1A.inputSignalType"""))
    val ks = parse_element (element ("""PssIEEE1A.ks"""))
    val t1 = parse_element (element ("""PssIEEE1A.t1"""))
    val t2 = parse_element (element ("""PssIEEE1A.t2"""))
    val t3 = parse_element (element ("""PssIEEE1A.t3"""))
    val t4 = parse_element (element ("""PssIEEE1A.t4"""))
    val t5 = parse_element (element ("""PssIEEE1A.t5"""))
    val t6 = parse_element (element ("""PssIEEE1A.t6"""))
    val vrmax = parse_element (element ("""PssIEEE1A.vrmax"""))
    val vrmin = parse_element (element ("""PssIEEE1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 *        Typical Value = rotorSpeed.
 * @param inputSignal2Type Type of input signal #2.
 *        Typical Value = generatorElectricalPower.
 * @param ks1 Stabilizer gain (Ks1).
 *        Typical Value = 12.
 * @param ks2 Gain on signal #2 (Ks2).
 *        Typical Value = 0.2.
 * @param ks3 Gain on signal #2 input before ramp-tracking filter (Ks3).
 *        Typical Value = 1.
 * @param m Denominator order of ramp tracking filter (M).
 *        Typical Value = 5.
 * @param n Order of ramp tracking filter (N).
 *        Typical Value = 1.
 * @param t1 Lead/lag time constant (T1).
 *        Typical Value = 0.12.
 * @param t10 Lead/lag time constant (T10).
 *        Typical Value = 0.
 * @param t11 Lead/lag time constant (T11).
 *        Typical Value = 0.
 * @param t2 Lead/lag time constant (T2).
 *        Typical Value = 0.02.
 * @param t3 Lead/lag time constant (T3).
 *        Typical Value = 0.3.
 * @param t4 Lead/lag time constant (T4).
 *        Typical Value = 0.02.
 * @param t6 Time constant on signal #1 (T6).
 *        Typical Value = 0.
 * @param t7 Time constant on signal #2 (T7).
 *        Typical Value = 2.
 * @param t8 Lead of ramp tracking filter (T8).
 *        Typical Value = 0.2.
 * @param t9 Lag of ramp tracking filter (T9).
 *        Typical Value = 0.1.
 * @param tw1 First washout on signal #1 (Tw1).
 *        Typical Value = 2.
 * @param tw2 Second washout on signal #1 (Tw2).
 *        Typical Value = 2.
 * @param tw3 First washout on signal #2 (Tw3).
 *        Typical Value = 2.
 * @param tw4 Second washout on signal #2 (Tw4).
 *        Typical Value = 0.
 * @param vsi1max Input signal #1 max limit (Vsi1max).
 *        Typical Value = 2.
 * @param vsi1min Input signal #1 min limit (Vsi1min).
 *        Typical Value = -2.
 * @param vsi2max Input signal #2 max limit (Vsi2max).
 *        Typical Value = 2.
 * @param vsi2min Input signal #2 min limit (Vsi2min).
 *        Typical Value = -2.
 * @param vstmax Stabilizer output max limit (Vstmax).
 *        Typical Value = 0.1.
 * @param vstmin Stabilizer output min limit (Vstmin).
 *        Typical Value = -0.1.
 */
case class PssIEEE2B
(
    override val sup: Element,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: Double,
    val ks2: Double,
    val ks3: Double,
    val m: Int,
    val n: Int,
    val t1: Double,
    val t10: Double,
    val t11: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t6: Double,
    val t7: Double,
    val t8: Double,
    val t9: Double,
    val tw1: Double,
    val tw2: Double,
    val tw3: Double,
    val tw4: Double,
    val vsi1max: Double,
    val vsi1min: Double,
    val vsi2max: Double,
    val vsi2min: Double,
    val vstmax: Double,
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
    val inputSignal1Type = parse_attribute (attribute ("""PssIEEE2B.inputSignal1Type"""))
    val inputSignal2Type = parse_attribute (attribute ("""PssIEEE2B.inputSignal2Type"""))
    val ks1 = parse_element (element ("""PssIEEE2B.ks1"""))
    val ks2 = parse_element (element ("""PssIEEE2B.ks2"""))
    val ks3 = parse_element (element ("""PssIEEE2B.ks3"""))
    val m = parse_element (element ("""PssIEEE2B.m"""))
    val n = parse_element (element ("""PssIEEE2B.n"""))
    val t1 = parse_element (element ("""PssIEEE2B.t1"""))
    val t10 = parse_element (element ("""PssIEEE2B.t10"""))
    val t11 = parse_element (element ("""PssIEEE2B.t11"""))
    val t2 = parse_element (element ("""PssIEEE2B.t2"""))
    val t3 = parse_element (element ("""PssIEEE2B.t3"""))
    val t4 = parse_element (element ("""PssIEEE2B.t4"""))
    val t6 = parse_element (element ("""PssIEEE2B.t6"""))
    val t7 = parse_element (element ("""PssIEEE2B.t7"""))
    val t8 = parse_element (element ("""PssIEEE2B.t8"""))
    val t9 = parse_element (element ("""PssIEEE2B.t9"""))
    val tw1 = parse_element (element ("""PssIEEE2B.tw1"""))
    val tw2 = parse_element (element ("""PssIEEE2B.tw2"""))
    val tw3 = parse_element (element ("""PssIEEE2B.tw3"""))
    val tw4 = parse_element (element ("""PssIEEE2B.tw4"""))
    val vsi1max = parse_element (element ("""PssIEEE2B.vsi1max"""))
    val vsi1min = parse_element (element ("""PssIEEE2B.vsi1min"""))
    val vsi2max = parse_element (element ("""PssIEEE2B.vsi2max"""))
    val vsi2min = parse_element (element ("""PssIEEE2B.vsi2min"""))
    val vstmax = parse_element (element ("""PssIEEE2B.vstmax"""))
    val vstmin = parse_element (element ("""PssIEEE2B.vstmin"""))
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
 * @param sup Reference to the superclass object.
 * @param a1 Notch filter parameter (A1).
 *        Typical Value = 0.359.
 * @param a2 Notch filter parameter (A2).
 *        Typical Value = 0.586.
 * @param a3 Notch filter parameter (A3).
 *        Typical Value = 0.429.
 * @param a4 Notch filter parameter (A4).
 *        Typical Value = 0.564.
 * @param a5 Notch filter parameter (A5).
 *        Typical Value = 0.001.
 * @param a6 Notch filter parameter (A6).
 *        Typical Value = 0.
 * @param a7 Notch filter parameter (A7).
 *        Typical Value = 0.031.
 * @param a8 Notch filter parameter (A8).
 *        Typical Value = 0.
 * @param inputSignal1Type Type of input signal #1.
 *        Typical Value = generatorElectricalPower.
 * @param inputSignal2Type Type of input signal #2.
 *        Typical Value = rotorSpeed.
 * @param ks1 Gain on signal # 1 (Ks1).
 *        Typical Value = -0.602.
 * @param ks2 Gain on signal # 2 (Ks2).
 *        Typical Value = 30.12.
 * @param t1 Transducer time constant (T1).
 *        Typical Value = 0.012.
 * @param t2 Transducer time constant (T2).
 *        Typical Value = 0.012.
 * @param tw1 Washout time constant (Tw1).
 *        Typical Value = 0.3.
 * @param tw2 Washout time constant (Tw2).
 *        Typical Value = 0.3.
 * @param tw3 Washout time constant (Tw3).
 *        Typical Value = 0.6.
 * @param vstmax Stabilizer output max limit (Vstmax).
 *        Typical Value = 0.1.
 * @param vstmin Stabilizer output min limit (Vstmin).
 *        Typical Value = -0.1.
 */
case class PssIEEE3B
(
    override val sup: Element,
    val a1: Double,
    val a2: Double,
    val a3: Double,
    val a4: Double,
    val a5: Double,
    val a6: Double,
    val a7: Double,
    val a8: Double,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val ks1: Double,
    val ks2: Double,
    val t1: Double,
    val t2: Double,
    val tw1: Double,
    val tw2: Double,
    val tw3: Double,
    val vstmax: Double,
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
    val a1 = parse_element (element ("""PssIEEE3B.a1"""))
    val a2 = parse_element (element ("""PssIEEE3B.a2"""))
    val a3 = parse_element (element ("""PssIEEE3B.a3"""))
    val a4 = parse_element (element ("""PssIEEE3B.a4"""))
    val a5 = parse_element (element ("""PssIEEE3B.a5"""))
    val a6 = parse_element (element ("""PssIEEE3B.a6"""))
    val a7 = parse_element (element ("""PssIEEE3B.a7"""))
    val a8 = parse_element (element ("""PssIEEE3B.a8"""))
    val inputSignal1Type = parse_attribute (attribute ("""PssIEEE3B.inputSignal1Type"""))
    val inputSignal2Type = parse_attribute (attribute ("""PssIEEE3B.inputSignal2Type"""))
    val ks1 = parse_element (element ("""PssIEEE3B.ks1"""))
    val ks2 = parse_element (element ("""PssIEEE3B.ks2"""))
    val t1 = parse_element (element ("""PssIEEE3B.t1"""))
    val t2 = parse_element (element ("""PssIEEE3B.t2"""))
    val tw1 = parse_element (element ("""PssIEEE3B.tw1"""))
    val tw2 = parse_element (element ("""PssIEEE3B.tw2"""))
    val tw3 = parse_element (element ("""PssIEEE3B.tw3"""))
    val vstmax = parse_element (element ("""PssIEEE3B.vstmax"""))
    val vstmin = parse_element (element ("""PssIEEE3B.vstmin"""))
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
 * @param sup Reference to the superclass object.
 * @param bwh1 Notch filter 1 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwh2 Notch filter 2 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwl1 Notch filter 1 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwl2 Notch filter 2 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param kh High band gain (K<sub>H</sub>).
 *        Typical Value = 120.
 * @param kh1 High band differential filter gain (K<sub>H1</sub>).
 *        Typical Value = 66.
 * @param kh11 High band first lead-lag blocks coefficient (K<sub>H11</sub>).
 *        Typical Value = 1.
 * @param kh17 High band first lead-lag blocks coefficient (K<sub>H17</sub>).
 *        Typical Value = 1.
 * @param kh2 High band differential filter gain (K<sub>H2</sub>).
 *        Typical Value = 66.
 * @param ki Intermediate band gain (K<sub>I</sub>).
 *        Typical Value = 30.
 * @param ki1 Intermediate band differential filter gain (K<sub>I1</sub>).
 *        Typical Value = 66.
 * @param ki11 Intermediate band first lead-lag blocks coefficient (K<sub>I11</sub>).
 *        Typical Value = 1.
 * @param ki17 Intermediate band first lead-lag blocks coefficient (K<sub>I17</sub>).
 *        Typical Value = 1.
 * @param ki2 Intermediate band differential filter gain (K<sub>I2</sub>).
 *        Typical Value = 66.
 * @param kl Low band gain (K<sub>L</sub>).
 *        Typical Value = 7.5.
 * @param kl1 Low band differential filter gain (K<sub>L1</sub>).
 *        Typical Value = 66.
 * @param kl11 Low band first lead-lag blocks coefficient (K<sub>L11</sub>).
 *        Typical Value = 1.
 * @param kl17 Low band first lead-lag blocks coefficient (K<sub>L17</sub>).
 *        Typical Value = 1.
 * @param kl2 Low band differential filter gain (K<sub>L2</sub>).
 *        Typical Value = 66.
 * @param omeganh1 Notch filter 1 (high-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganh2 Notch filter 2 (high-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganl1 Notch filter 1 (low-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganl2 Notch filter 2 (low-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param th1 High band time constant (T<sub>H1</sub>).
 *        Typical Value = 0.01513.
 * @param th10 High band time constant (T<sub>H10</sub>).
 *        Typical Value = 0.
 * @param th11 High band time constant (T<sub>H11</sub>).
 *        Typical Value = 0.
 * @param th12 High band time constant (T<sub>H12</sub>).
 *        Typical Value = 0.
 * @param th2 High band time constant (T<sub>H2</sub>).
 *        Typical Value = 0.01816.
 * @param th3 High band time constant (T<sub>H3</sub>).
 *        Typical Value = 0.
 * @param th4 High band time constant (T<sub>H4</sub>).
 *        Typical Value = 0.
 * @param th5 High band time constant (T<sub>H5</sub>).
 *        Typical Value = 0.
 * @param th6 High band time constant (T<sub>H6</sub>).
 *        Typical Value = 0.
 * @param th7 High band time constant (T<sub>H7</sub>).
 *        Typical Value = 0.01816.
 * @param th8 High band time constant (T<sub>H8</sub>).
 *        Typical Value = 0.02179.
 * @param th9 High band time constant (T<sub>H9</sub>).
 *        Typical Value = 0.
 * @param ti1 Intermediate band time constant (T<sub>I1</sub>).
 *        Typical Value = 0.173.
 * @param ti10 Intermediate band time constant (T<sub>I11</sub>).
 *        Typical Value = 0.
 * @param ti11 Intermediate band time constant (T<sub>I11</sub>).
 *        Typical Value = 0.
 * @param ti12 Intermediate band time constant (T<sub>I2</sub>).
 *        Typical Value = 0.
 * @param ti2 Intermediate band time constant (T<sub>I2</sub>).
 *        Typical Value = 0.2075.
 * @param ti3 Intermediate band time constant (T<sub>I3</sub>).
 *        Typical Value = 0.
 * @param ti4 Intermediate band time constant (T<sub>I4</sub>).
 *        Typical Value = 0.
 * @param ti5 Intermediate band time constant (T<sub>I5</sub>).
 *        Typical Value = 0.
 * @param ti6 Intermediate band time constant (T<sub>I6</sub>).
 *        Typical Value = 0.
 * @param ti7 Intermediate band time constant (T<sub>I7</sub>).
 *        Typical Value = 0.2075.
 * @param ti8 Intermediate band time constant (T<sub>I8</sub>).
 *        Typical Value = 0.2491.
 * @param ti9 Intermediate band time constant (T<sub>I9</sub>).
 *        Typical Value = 0.
 * @param tl1 Low band time constant (T<sub>L1</sub>).
 *        Typical Value = 1.73.
 * @param tl10 Low band time constant (T<sub>L10</sub>).
 *        Typical Value = 0.
 * @param tl11 Low band time constant (T<sub>L11</sub>).
 *        Typical Value = 0.
 * @param tl12 Low band time constant (T<sub>L12</sub>).
 *        Typical Value = 0.
 * @param tl2 Low band time constant (T<sub>L2</sub>).
 *        Typical Value = 2.075.
 * @param tl3 Low band time constant (T<sub>L3</sub>).
 *        Typical Value = 0.
 * @param tl4 Low band time constant (T<sub>L4</sub>).
 *        Typical Value = 0.
 * @param tl5 Low band time constant (T<sub>L5</sub>).
 *        Typical Value = 0.
 * @param tl6 Low band time constant (T<sub>L6</sub>).
 *        Typical Value = 0.
 * @param tl7 Low band time constant (T<sub>L7</sub>).
 *        Typical Value = 2.075.
 * @param tl8 Low band time constant (T<sub>L8</sub>).
 *        Typical Value = 2.491.
 * @param tl9 Low band time constant (T<sub>L9</sub>).
 *        Typical Value = 0.
 * @param vhmax High band output maximum limit (V<sub>Hmax</sub>).
 *        Typical Value = 0.6.
 * @param vhmin High band output minimum limit (V<sub>Hmin</sub>).
 *        Typical Value = -0.6.
 * @param vimax Intermediate band output maximum limit (V<sub>Imax</sub>).
 *        Typical Value = 0.6.
 * @param vimin Intermediate band output minimum limit (V<sub>Imin</sub>).
 *        Typical Value = -0.6.
 * @param vlmax Low band output maximum limit (V<sub>Lmax</sub>).
 *        Typical Value = 0.075.
 * @param vlmin Low band output minimum limit (V<sub>Lmin</sub>).
 *        Typical Value = -0.075.
 * @param vstmax PSS output maximum limit (V<sub>STmax</sub>).
 *        Typical Value = 0.15.
 * @param vstmin PSS output minimum limit (V<sub>STmin</sub>).
 *        Typical Value = -0.15.
 */
case class PssIEEE4B
(
    override val sup: Element,
    val bwh1: Double,
    val bwh2: Double,
    val bwl1: Double,
    val bwl2: Double,
    val kh: Double,
    val kh1: Double,
    val kh11: Double,
    val kh17: Double,
    val kh2: Double,
    val ki: Double,
    val ki1: Double,
    val ki11: Double,
    val ki17: Double,
    val ki2: Double,
    val kl: Double,
    val kl1: Double,
    val kl11: Double,
    val kl17: Double,
    val kl2: Double,
    val omeganh1: Double,
    val omeganh2: Double,
    val omeganl1: Double,
    val omeganl2: Double,
    val th1: Double,
    val th10: Double,
    val th11: Double,
    val th12: Double,
    val th2: Double,
    val th3: Double,
    val th4: Double,
    val th5: Double,
    val th6: Double,
    val th7: Double,
    val th8: Double,
    val th9: Double,
    val ti1: Double,
    val ti10: Double,
    val ti11: Double,
    val ti12: Double,
    val ti2: Double,
    val ti3: Double,
    val ti4: Double,
    val ti5: Double,
    val ti6: Double,
    val ti7: Double,
    val ti8: Double,
    val ti9: Double,
    val tl1: Double,
    val tl10: Double,
    val tl11: Double,
    val tl12: Double,
    val tl2: Double,
    val tl3: Double,
    val tl4: Double,
    val tl5: Double,
    val tl6: Double,
    val tl7: Double,
    val tl8: Double,
    val tl9: Double,
    val vhmax: Double,
    val vhmin: Double,
    val vimax: Double,
    val vimin: Double,
    val vlmax: Double,
    val vlmin: Double,
    val vstmax: Double,
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
    val bwh1 = parse_element (element ("""PssIEEE4B.bwh1"""))
    val bwh2 = parse_element (element ("""PssIEEE4B.bwh2"""))
    val bwl1 = parse_element (element ("""PssIEEE4B.bwl1"""))
    val bwl2 = parse_element (element ("""PssIEEE4B.bwl2"""))
    val kh = parse_element (element ("""PssIEEE4B.kh"""))
    val kh1 = parse_element (element ("""PssIEEE4B.kh1"""))
    val kh11 = parse_element (element ("""PssIEEE4B.kh11"""))
    val kh17 = parse_element (element ("""PssIEEE4B.kh17"""))
    val kh2 = parse_element (element ("""PssIEEE4B.kh2"""))
    val ki = parse_element (element ("""PssIEEE4B.ki"""))
    val ki1 = parse_element (element ("""PssIEEE4B.ki1"""))
    val ki11 = parse_element (element ("""PssIEEE4B.ki11"""))
    val ki17 = parse_element (element ("""PssIEEE4B.ki17"""))
    val ki2 = parse_element (element ("""PssIEEE4B.ki2"""))
    val kl = parse_element (element ("""PssIEEE4B.kl"""))
    val kl1 = parse_element (element ("""PssIEEE4B.kl1"""))
    val kl11 = parse_element (element ("""PssIEEE4B.kl11"""))
    val kl17 = parse_element (element ("""PssIEEE4B.kl17"""))
    val kl2 = parse_element (element ("""PssIEEE4B.kl2"""))
    val omeganh1 = parse_element (element ("""PssIEEE4B.omeganh1"""))
    val omeganh2 = parse_element (element ("""PssIEEE4B.omeganh2"""))
    val omeganl1 = parse_element (element ("""PssIEEE4B.omeganl1"""))
    val omeganl2 = parse_element (element ("""PssIEEE4B.omeganl2"""))
    val th1 = parse_element (element ("""PssIEEE4B.th1"""))
    val th10 = parse_element (element ("""PssIEEE4B.th10"""))
    val th11 = parse_element (element ("""PssIEEE4B.th11"""))
    val th12 = parse_element (element ("""PssIEEE4B.th12"""))
    val th2 = parse_element (element ("""PssIEEE4B.th2"""))
    val th3 = parse_element (element ("""PssIEEE4B.th3"""))
    val th4 = parse_element (element ("""PssIEEE4B.th4"""))
    val th5 = parse_element (element ("""PssIEEE4B.th5"""))
    val th6 = parse_element (element ("""PssIEEE4B.th6"""))
    val th7 = parse_element (element ("""PssIEEE4B.th7"""))
    val th8 = parse_element (element ("""PssIEEE4B.th8"""))
    val th9 = parse_element (element ("""PssIEEE4B.th9"""))
    val ti1 = parse_element (element ("""PssIEEE4B.ti1"""))
    val ti10 = parse_element (element ("""PssIEEE4B.ti10"""))
    val ti11 = parse_element (element ("""PssIEEE4B.ti11"""))
    val ti12 = parse_element (element ("""PssIEEE4B.ti12"""))
    val ti2 = parse_element (element ("""PssIEEE4B.ti2"""))
    val ti3 = parse_element (element ("""PssIEEE4B.ti3"""))
    val ti4 = parse_element (element ("""PssIEEE4B.ti4"""))
    val ti5 = parse_element (element ("""PssIEEE4B.ti5"""))
    val ti6 = parse_element (element ("""PssIEEE4B.ti6"""))
    val ti7 = parse_element (element ("""PssIEEE4B.ti7"""))
    val ti8 = parse_element (element ("""PssIEEE4B.ti8"""))
    val ti9 = parse_element (element ("""PssIEEE4B.ti9"""))
    val tl1 = parse_element (element ("""PssIEEE4B.tl1"""))
    val tl10 = parse_element (element ("""PssIEEE4B.tl10"""))
    val tl11 = parse_element (element ("""PssIEEE4B.tl11"""))
    val tl12 = parse_element (element ("""PssIEEE4B.tl12"""))
    val tl2 = parse_element (element ("""PssIEEE4B.tl2"""))
    val tl3 = parse_element (element ("""PssIEEE4B.tl3"""))
    val tl4 = parse_element (element ("""PssIEEE4B.tl4"""))
    val tl5 = parse_element (element ("""PssIEEE4B.tl5"""))
    val tl6 = parse_element (element ("""PssIEEE4B.tl6"""))
    val tl7 = parse_element (element ("""PssIEEE4B.tl7"""))
    val tl8 = parse_element (element ("""PssIEEE4B.tl8"""))
    val tl9 = parse_element (element ("""PssIEEE4B.tl9"""))
    val vhmax = parse_element (element ("""PssIEEE4B.vhmax"""))
    val vhmin = parse_element (element ("""PssIEEE4B.vhmin"""))
    val vimax = parse_element (element ("""PssIEEE4B.vimax"""))
    val vimin = parse_element (element ("""PssIEEE4B.vimin"""))
    val vlmax = parse_element (element ("""PssIEEE4B.vlmax"""))
    val vlmin = parse_element (element ("""PssIEEE4B.vlmin"""))
    val vstmax = parse_element (element ("""PssIEEE4B.vstmax"""))
    val vstmin = parse_element (element ("""PssIEEE4B.vstmin"""))
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
 * @param sup Reference to the superclass object.
 * @param dtc Time step related to activation of controls (Dtc).
 *        Typical Value = 0.025.
 * @param dtf Time step frequency calculation (Dtf).
 *        Typical Value = 0.025.
 * @param dtp Time step active power calculation (Dtp).
 *        Typical Value = 0.0125.
 * @param k Gain (K).
 *        Typical Value = 9.
 * @param m (M).
 *        M=2*H.  Typical Value = 5.
 * @param t1 Time constant (T1).
 *        Typical Value = 0.3.
 * @param t2 Time constant (T2).
 *        Typical Value = 1.
 * @param t3 Time constant (T3).
 *        Typical Value = 0.2.
 * @param t4 Time constant (T4).
 *        Typical Value = 0.05.
 * @param tf Time constant (Tf).
 *        Typical Value = 0.2.
 * @param tp Time constant (Tp).
 *        Typical Value = 0.2.
 */
case class PssPTIST1
(
    override val sup: Element,
    val dtc: Double,
    val dtf: Double,
    val dtp: Double,
    val k: Double,
    val m: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val tf: Double,
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
    val dtc = parse_element (element ("""PssPTIST1.dtc"""))
    val dtf = parse_element (element ("""PssPTIST1.dtf"""))
    val dtp = parse_element (element ("""PssPTIST1.dtp"""))
    val k = parse_element (element ("""PssPTIST1.k"""))
    val m = parse_element (element ("""PssPTIST1.m"""))
    val t1 = parse_element (element ("""PssPTIST1.t1"""))
    val t2 = parse_element (element ("""PssPTIST1.t2"""))
    val t3 = parse_element (element ("""PssPTIST1.t3"""))
    val t4 = parse_element (element ("""PssPTIST1.t4"""))
    val tf = parse_element (element ("""PssPTIST1.tf"""))
    val tp = parse_element (element ("""PssPTIST1.tp"""))
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
 * @param sup Reference to the superclass object.
 * @param a0 Filter coefficient (A0).
 * @param a1 Limiter (Al).
 * @param a2 Filter coefficient (A2).
 * @param a3 Filter coefficient (A3).
 * @param a4 Filter coefficient (A4).
 * @param a5 Filter coefficient (A5).
 * @param al Limiter (Al).
 * @param athres Threshold value above which output averaging will be bypassed (Athres).
 *        Typical Value = 0.005.
 * @param b0 Filter coefficient (B0).
 * @param b1 Filter coefficient (B1).
 * @param b2 Filter coefficient (B2).
 * @param b3 Filter coefficient (B3).
 * @param b4 Filter coefficient (B4).
 * @param b5 Filter coefficient (B5).
 * @param dl Limiter (Dl).
 * @param dtc Time step related to activation of controls (0.03 for 50 Hz) (Dtc).
 *        Typical Value = 0.025.
 * @param dtf Time step frequency calculation (0.03 for 50 Hz) (Dtf).
 *        Typical Value = 0.025.
 * @param dtp Time step active power calculation (0.015 for 50 Hz) (Dtp).
 *        Typical Value = 0.0125.
 * @param isw Digital/analog output switch (Isw).
true = produce analog output
 *        false = convert to digital output, using tap selection table.
 * @param k Gain (K).
 *        Typical Value = 9.
 * @param lthres Threshold value (Lthres).
 * @param m (M).
 *        M=2*H.  Typical Value = 5.
 * @param nav Number of control outputs to average (Nav) (1 &lt;= Nav &lt;= 16).
 *        Typical Value = 4.
 * @param ncl Number of counts at limit to active limit function (Ncl) (&gt;0).
 * @param ncr Number of counts until reset after limit function is triggered (Ncr).
 * @param pmin (Pmin).
 * @param t1 Time constant (T1).
 *        Typical Value = 0.3.
 * @param t2 Time constant (T2).
 *        Typical Value = 1.
 * @param t3 Time constant (T3).
 *        Typical Value = 0.2.
 * @param t4 Time constant (T4).
 *        Typical Value = 0.05.
 * @param t5 Time constant (T5).
 * @param t6 Time constant (T6).
 * @param tf Time constant (Tf).
 *        Typical Value = 0.2.
 * @param tp Time constant (Tp).
 *        Typical Value = 0.2.
 */
case class PssPTIST3
(
    override val sup: Element,
    val a0: Double,
    val a1: Double,
    val a2: Double,
    val a3: Double,
    val a4: Double,
    val a5: Double,
    val al: Double,
    val athres: Double,
    val b0: Double,
    val b1: Double,
    val b2: Double,
    val b3: Double,
    val b4: Double,
    val b5: Double,
    val dl: Double,
    val dtc: Double,
    val dtf: Double,
    val dtp: Double,
    val isw: Boolean,
    val k: Double,
    val lthres: Double,
    val m: Double,
    val nav: Double,
    val ncl: Double,
    val ncr: Double,
    val pmin: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val tf: Double,
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
    val a0 = parse_element (element ("""PssPTIST3.a0"""))
    val a1 = parse_element (element ("""PssPTIST3.a1"""))
    val a2 = parse_element (element ("""PssPTIST3.a2"""))
    val a3 = parse_element (element ("""PssPTIST3.a3"""))
    val a4 = parse_element (element ("""PssPTIST3.a4"""))
    val a5 = parse_element (element ("""PssPTIST3.a5"""))
    val al = parse_element (element ("""PssPTIST3.al"""))
    val athres = parse_element (element ("""PssPTIST3.athres"""))
    val b0 = parse_element (element ("""PssPTIST3.b0"""))
    val b1 = parse_element (element ("""PssPTIST3.b1"""))
    val b2 = parse_element (element ("""PssPTIST3.b2"""))
    val b3 = parse_element (element ("""PssPTIST3.b3"""))
    val b4 = parse_element (element ("""PssPTIST3.b4"""))
    val b5 = parse_element (element ("""PssPTIST3.b5"""))
    val dl = parse_element (element ("""PssPTIST3.dl"""))
    val dtc = parse_element (element ("""PssPTIST3.dtc"""))
    val dtf = parse_element (element ("""PssPTIST3.dtf"""))
    val dtp = parse_element (element ("""PssPTIST3.dtp"""))
    val isw = parse_element (element ("""PssPTIST3.isw"""))
    val k = parse_element (element ("""PssPTIST3.k"""))
    val lthres = parse_element (element ("""PssPTIST3.lthres"""))
    val m = parse_element (element ("""PssPTIST3.m"""))
    val nav = parse_element (element ("""PssPTIST3.nav"""))
    val ncl = parse_element (element ("""PssPTIST3.ncl"""))
    val ncr = parse_element (element ("""PssPTIST3.ncr"""))
    val pmin = parse_element (element ("""PssPTIST3.pmin"""))
    val t1 = parse_element (element ("""PssPTIST3.t1"""))
    val t2 = parse_element (element ("""PssPTIST3.t2"""))
    val t3 = parse_element (element ("""PssPTIST3.t3"""))
    val t4 = parse_element (element ("""PssPTIST3.t4"""))
    val t5 = parse_element (element ("""PssPTIST3.t5"""))
    val t6 = parse_element (element ("""PssPTIST3.t6"""))
    val tf = parse_element (element ("""PssPTIST3.tf"""))
    val tp = parse_element (element ("""PssPTIST3.tp"""))
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
 * @param sup Reference to the superclass object.
 * @param kx Gain (Kx).
 * @param ta Time constant (Ta).
 * @param tb Time constant (Tb).
 * @param tc Time constant (Tc).
 * @param td Time constant (Td).
 * @param te Time constant (Te).
 * @param tt Time constant (Tt).
 * @param tx1 Reset time constant (Tx1).
 * @param tx2 Time constant (Tx2).
 * @param vsmax Limiter (Vsmax).
 * @param vsmin Limiter (Vsmin).
 */
case class PssSB4
(
    override val sup: Element,
    val kx: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val td: Double,
    val te: Double,
    val tt: Double,
    val tx1: Double,
    val tx2: Double,
    val vsmax: Double,
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
    val kx = parse_element (element ("""PssSB4.kx"""))
    val ta = parse_element (element ("""PssSB4.ta"""))
    val tb = parse_element (element ("""PssSB4.tb"""))
    val tc = parse_element (element ("""PssSB4.tc"""))
    val td = parse_element (element ("""PssSB4.td"""))
    val te = parse_element (element ("""PssSB4.te"""))
    val tt = parse_element (element ("""PssSB4.tt"""))
    val tx1 = parse_element (element ("""PssSB4.tx1"""))
    val tx2 = parse_element (element ("""PssSB4.tx2"""))
    val vsmax = parse_element (element ("""PssSB4.vsmax"""))
    val vsmin = parse_element (element ("""PssSB4.vsmin"""))
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
 * @param sup Reference to the superclass object.
 * @param k Main gain (K).
 *        Typical Value = 1.
 * @param k0 Gain 0 (K0).
 *        Typical Value = 0.012.
 * @param k1 Gain 1 (K1).
 *        Typical Value = 0.488.
 * @param k2 Gain 2 (K2).
 *        Typical Value = 0.064.
 * @param k3 Gain 3 (K3).
 *        Typical Value = 0.224.
 * @param k4 Gain 4 (K4).
 *        Typical Value = 0.1.
 * @param t1 Time constant 1 (T1).
 *        Typical Value = 0.076.
 * @param t2 Time constant 2 (T2).
 *        Typical Value = 0.086.
 * @param t3 Time constant 3 (T3).
 *        Typical Value = 1.068.
 * @param t4 Time constant 4 (T4).
 *        Typical Value = 1.913.
 * @param td Input time constant (Td).
 *        Typical Value = 10.
 * @param vsmax Output maximum limit (Vsmax).
 *        Typical Value = 0.1.
 * @param vsmin Output minimum limit (Vsmin).
 *        Typical Value = -0.1.
 */
case class PssSH
(
    override val sup: Element,
    val k: Double,
    val k0: Double,
    val k1: Double,
    val k2: Double,
    val k3: Double,
    val k4: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val td: Double,
    val vsmax: Double,
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
    val k = parse_element (element ("""PssSH.k"""))
    val k0 = parse_element (element ("""PssSH.k0"""))
    val k1 = parse_element (element ("""PssSH.k1"""))
    val k2 = parse_element (element ("""PssSH.k2"""))
    val k3 = parse_element (element ("""PssSH.k3"""))
    val k4 = parse_element (element ("""PssSH.k4"""))
    val t1 = parse_element (element ("""PssSH.t1"""))
    val t2 = parse_element (element ("""PssSH.t2"""))
    val t3 = parse_element (element ("""PssSH.t3"""))
    val t4 = parse_element (element ("""PssSH.t4"""))
    val td = parse_element (element ("""PssSH.td"""))
    val vsmax = parse_element (element ("""PssSH.vsmax"""))
    val vsmin = parse_element (element ("""PssSH.vsmin"""))
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
 * @param sup Reference to the superclass object.
 * @param k1 Gain P (K1).
 *        Typical Value = -0.3.
 * @param k2 Gain fe (K2).
 *        Typical Value = -0.15.
 * @param k3 Gain If (K3).
 *        Typical Value = 10.
 * @param t1 Denominator time constant (T1).
 *        Typical Value = 0.3.
 * @param t2 Filter time constant (T2).
 *        Typical Value = 0.35.
 * @param t3 Denominator time constant (T3).
 *        Typical Value = 0.22.
 * @param t4 Filter time constant (T4).
 *        Typical Value = 0.02.
 * @param t5 Denominator time constant (T5).
 *        Typical Value = 0.02.
 * @param t6 Filter time constant (T6).
 *        Typical Value = 0.02.
 * @param vsmax Stabilizer output max limit (Vsmax).
 *        Typical Value = 0.4.
 * @param vsmin Stabilizer output min limit (Vsmin).
 *        Typical Value = -0.4.
 */
case class PssSK
(
    override val sup: Element,
    val k1: Double,
    val k2: Double,
    val k3: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val vsmax: Double,
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
    val k1 = parse_element (element ("""PssSK.k1"""))
    val k2 = parse_element (element ("""PssSK.k2"""))
    val k3 = parse_element (element ("""PssSK.k3"""))
    val t1 = parse_element (element ("""PssSK.t1"""))
    val t2 = parse_element (element ("""PssSK.t2"""))
    val t3 = parse_element (element ("""PssSK.t3"""))
    val t4 = parse_element (element ("""PssSK.t4"""))
    val t5 = parse_element (element ("""PssSK.t5"""))
    val t6 = parse_element (element ("""PssSK.t6"""))
    val vsmax = parse_element (element ("""PssSK.vsmax"""))
    val vsmin = parse_element (element ("""PssSK.vsmin"""))
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
 * @param sup Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 * @param inputSignal2Type Type of input signal #2.
 * @param k1 Input signal 1 gain  (K<sub>1</sub>).
 * @param k2 Input signal 2 gain (K<sub>2</sub>).
 * @param t1 Input signal 1 transducer time constant (T<sub>1</sub>).
 * @param t10 Lag time constant (T<sub>10</sub>).
 * @param t2 Input signal 2 transducer time constant (T<sub>2</sub>).
 * @param t3 Stabilizer washout time constant (T<sub>3</sub>).
 * @param t4 Stabilizer washout time lag constant (T<sub>4</sub>) (&gt;0).
 * @param t5 Lead time constant (T<sub>5</sub>).
 * @param t6 Lag time constant (T<sub>6</sub>).
 * @param t7 Lead time constant (T<sub>7</sub>).
 * @param t8 Lag time constant (T<sub>8</sub>).
 * @param t9 Lead time constant (T<sub>9</sub>).
 * @param vcl Minimum value for voltage compensator output (V<sub>CL</sub>).
 * @param vcu Maximum value for voltage compensator output (V<sub>CU</sub>).
 * @param vsmax Maximum output signal (Vsmax).
 * @param vsmin Minimum output signal (Vsmin).
 */
case class PssWECC
(
    override val sup: Element,
    val inputSignal1Type: String,
    val inputSignal2Type: String,
    val k1: Double,
    val k2: Double,
    val t1: Double,
    val t10: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val t7: Double,
    val t8: Double,
    val t9: Double,
    val vcl: Double,
    val vcu: Double,
    val vsmax: Double,
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
    val inputSignal1Type = parse_attribute (attribute ("""PssWECC.inputSignal1Type"""))
    val inputSignal2Type = parse_attribute (attribute ("""PssWECC.inputSignal2Type"""))
    val k1 = parse_element (element ("""PssWECC.k1"""))
    val k2 = parse_element (element ("""PssWECC.k2"""))
    val t1 = parse_element (element ("""PssWECC.t1"""))
    val t10 = parse_element (element ("""PssWECC.t10"""))
    val t2 = parse_element (element ("""PssWECC.t2"""))
    val t3 = parse_element (element ("""PssWECC.t3"""))
    val t4 = parse_element (element ("""PssWECC.t4"""))
    val t5 = parse_element (element ("""PssWECC.t5"""))
    val t6 = parse_element (element ("""PssWECC.t6"""))
    val t7 = parse_element (element ("""PssWECC.t7"""))
    val t8 = parse_element (element ("""PssWECC.t8"""))
    val t9 = parse_element (element ("""PssWECC.t9"""))
    val vcl = parse_element (element ("""PssWECC.vcl"""))
    val vcu = parse_element (element ("""PssWECC.vcu"""))
    val vsmax = parse_element (element ("""PssWECC.vsmax"""))
    val vsmin = parse_element (element ("""PssWECC.vsmin"""))
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