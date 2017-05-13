package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The excitation system model provides the field voltage (Efd) for a synchronous machine model.
 * It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */

/**
 * Modified IEEE AC1A alternator-supplied rectifier excitation system with different rate feedback source.
 */
case class ExcAC1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Indicates if both HV gate and LV gate are active (HVLVgates).
    true = gates are used
    false = gates are not used.
     * Typical Value = true.
     */
    val hvlvgates: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.2.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (Kd).
     * Typical Value = 0.38.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Coefficient to allow different usage of the model (Kf1).
     * Typical Value = 0.
     */
    val kf1: Double,

    /**
     * Coefficient to allow different usage of the model (Kf2).
     * Typical Value = 1.
     */
    val kf2: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
     * Typical Value = 0.1.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
     * Typical Value = 0.03.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>c</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 0.8.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>amax</sub>).
     * Typical Value = 14.5.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>amin</sub>).
     * Typical Value = -14.5.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1).
     * Typical Value = 4.18.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
     * Typical Value = 3.14.
     */
    val ve2: Double,

    /**
     * Maximum voltage regulator outputs (Vrmax).
     * Typical Value = 6.03.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (Rrmin).
     * Typical Value = -5.43.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC1A
extends
    Parseable[ExcAC1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val hvlvgates = parse_element (element ("""ExcAC1A.hvlvgates"""))_
    val ka = parse_element (element ("""ExcAC1A.ka"""))_
    val kc = parse_element (element ("""ExcAC1A.kc"""))_
    val kd = parse_element (element ("""ExcAC1A.kd"""))_
    val ke = parse_element (element ("""ExcAC1A.ke"""))_
    val kf = parse_element (element ("""ExcAC1A.kf"""))_
    val kf1 = parse_element (element ("""ExcAC1A.kf1"""))_
    val kf2 = parse_element (element ("""ExcAC1A.kf2"""))_
    val ks = parse_element (element ("""ExcAC1A.ks"""))_
    val seve1 = parse_element (element ("""ExcAC1A.seve1"""))_
    val seve2 = parse_element (element ("""ExcAC1A.seve2"""))_
    val ta = parse_element (element ("""ExcAC1A.ta"""))_
    val tb = parse_element (element ("""ExcAC1A.tb"""))_
    val tc = parse_element (element ("""ExcAC1A.tc"""))_
    val te = parse_element (element ("""ExcAC1A.te"""))_
    val tf = parse_element (element ("""ExcAC1A.tf"""))_
    val vamax = parse_element (element ("""ExcAC1A.vamax"""))_
    val vamin = parse_element (element ("""ExcAC1A.vamin"""))_
    val ve1 = parse_element (element ("""ExcAC1A.ve1"""))_
    val ve2 = parse_element (element ("""ExcAC1A.ve2"""))_
    val vrmax = parse_element (element ("""ExcAC1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC1A.vrmin"""))_
    def parse (context: Context): ExcAC1A =
    {
        ExcAC1A(
            sup (context),
            toBoolean (hvlvgates (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (kf1 (context), context),
            toDouble (kf2 (context), context),
            toDouble (ks (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE AC2A alternator-supplied rectifier excitation system with different field current limit.
 */
case class ExcAC2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Indicates if HV gate is active (HVgate).
    true = gate is used
    false = gate is not used.
     * Typical Value = true.
     */
    val hvgate: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Second stage regulator gain (Kb) (&gt;0).
     * Exciter field current controller gain.  Typical Value = 25.
     */
    val kb: Double,

    /**
     * Second stage regulator gain (Kb1).
     * It is exciter field current controller gain used as alternative to Kb to represent a variant of the ExcAC2A model.  Typical Value = 25.
     */
    val kb1: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.28.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (Kd).
     * Typical Value = 0.35.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Exciter field current feedback gain (Kh).
     * Typical Value = 1.
     */
    val kh: Double,

    /**
     * Exciter field current limiter gain (Kl).
     * Typical Value = 10.
     */
    val kl: Double,

    /**
     * Coefficient to allow different usage of the model (Kl1).
     * Typical Value = 1.
     */
    val kl1: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Indicates if LV gate is active (LVgate).
    true = gate is used
    false = gate is not used.
     * Typical Value = true.
     */
    val lvgate: Boolean,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve<sub>1</sub>]).
     * Typical Value = 0.037.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve<sub>2</sub>]).
     * Typical Value = 0.012.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>c</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 0.6.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>amax</sub>).
     * Typical Value = 8.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>amin</sub>).
     * Typical Value = -8.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>).
     * Typical Value = 4.4.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
     * Typical Value = 3.3.
     */
    val ve2: Double,

    /**
     * Exciter field current limit reference (Vfemax).
     * Typical Value = 4.4.
     */
    val vfemax: Double,

    /**
     * Maximum exciter field current (Vlr).
     * Typical Value = 4.4.
     */
    val vlr: Double,

    /**
     * Maximum voltage regulator outputs (Vrmax).
     * Typical Value = 105.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (Vrmin).
     * Typical Value = -95.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC2A
extends
    Parseable[ExcAC2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val hvgate = parse_element (element ("""ExcAC2A.hvgate"""))_
    val ka = parse_element (element ("""ExcAC2A.ka"""))_
    val kb = parse_element (element ("""ExcAC2A.kb"""))_
    val kb1 = parse_element (element ("""ExcAC2A.kb1"""))_
    val kc = parse_element (element ("""ExcAC2A.kc"""))_
    val kd = parse_element (element ("""ExcAC2A.kd"""))_
    val ke = parse_element (element ("""ExcAC2A.ke"""))_
    val kf = parse_element (element ("""ExcAC2A.kf"""))_
    val kh = parse_element (element ("""ExcAC2A.kh"""))_
    val kl = parse_element (element ("""ExcAC2A.kl"""))_
    val kl1 = parse_element (element ("""ExcAC2A.kl1"""))_
    val ks = parse_element (element ("""ExcAC2A.ks"""))_
    val lvgate = parse_element (element ("""ExcAC2A.lvgate"""))_
    val seve1 = parse_element (element ("""ExcAC2A.seve1"""))_
    val seve2 = parse_element (element ("""ExcAC2A.seve2"""))_
    val ta = parse_element (element ("""ExcAC2A.ta"""))_
    val tb = parse_element (element ("""ExcAC2A.tb"""))_
    val tc = parse_element (element ("""ExcAC2A.tc"""))_
    val te = parse_element (element ("""ExcAC2A.te"""))_
    val tf = parse_element (element ("""ExcAC2A.tf"""))_
    val vamax = parse_element (element ("""ExcAC2A.vamax"""))_
    val vamin = parse_element (element ("""ExcAC2A.vamin"""))_
    val ve1 = parse_element (element ("""ExcAC2A.ve1"""))_
    val ve2 = parse_element (element ("""ExcAC2A.ve2"""))_
    val vfemax = parse_element (element ("""ExcAC2A.vfemax"""))_
    val vlr = parse_element (element ("""ExcAC2A.vlr"""))_
    val vrmax = parse_element (element ("""ExcAC2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC2A.vrmin"""))_
    def parse (context: Context): ExcAC2A =
    {
        ExcAC2A(
            sup (context),
            toBoolean (hvgate (context), context),
            toDouble (ka (context), context),
            toDouble (kb (context), context),
            toDouble (kb1 (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (kh (context), context),
            toDouble (kl (context), context),
            toDouble (kl1 (context), context),
            toDouble (ks (context), context),
            toBoolean (lvgate (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vfemax (context), context),
            toDouble (vlr (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE AC3A alternator-supplied rectifier excitation system with different field current limit.
 */
case class ExcAC3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Value of <i>EFD </i>at which feedback gain changes (Efdn).
     * Typical Value = 2.36.
     */
    val efdn: Double,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 45.62.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.104.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (Kd).
     * Typical Value = 0.499.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.143.
     */
    val kf: Double,

    /**
     * Coefficient to allow different usage of the model (Kf1).
     * Typical Value = 1.
     */
    val kf1: Double,

    /**
     * Coefficient to allow different usage of the model (Kf2).
     * Typical Value = 0.
     */
    val kf2: Double,

    /**
     * Gain used in the minimum field voltage limiter loop (Klv).
     * Typical Value = 0.194.
     */
    val klv: Double,

    /**
     * Excitation control system stabilizer gain (Kn).
     * Typical Value =0.05.
     */
    val kn: Double,

    /**
     * Constant associated with regulator and alternator field power supply (Kr).
     * Typical Value =3.77.
     */
    val kr: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve<sub>1</sub>]).
     * Typical Value = 1.143.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve<sub>2</sub>]).
     * Typical Value = 0.1.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.013.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>c</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.17.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>amax</sub>).
     * Typical Value = 1.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>amin</sub>).
     * Typical Value = -0.95.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1) equals Vemax (Ve1).
     * Typical Value = 6.24.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
     * Typical Value = 4.68.
     */
    val ve2: Double,

    /**
     * Minimum exciter voltage output (Vemin).
     * Typical Value = 0.1.
     */
    val vemin: Double,

    /**
     * Exciter field current limit reference (Vfemax).
     * Typical Value = 16.
     */
    val vfemax: Double,

    /**
     * Field voltage used in the minimum field voltage limiter loop (Vlv).
     * Typical Value = 0.79.
     */
    val vlv: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC3A
extends
    Parseable[ExcAC3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdn = parse_element (element ("""ExcAC3A.efdn"""))_
    val ka = parse_element (element ("""ExcAC3A.ka"""))_
    val kc = parse_element (element ("""ExcAC3A.kc"""))_
    val kd = parse_element (element ("""ExcAC3A.kd"""))_
    val ke = parse_element (element ("""ExcAC3A.ke"""))_
    val kf = parse_element (element ("""ExcAC3A.kf"""))_
    val kf1 = parse_element (element ("""ExcAC3A.kf1"""))_
    val kf2 = parse_element (element ("""ExcAC3A.kf2"""))_
    val klv = parse_element (element ("""ExcAC3A.klv"""))_
    val kn = parse_element (element ("""ExcAC3A.kn"""))_
    val kr = parse_element (element ("""ExcAC3A.kr"""))_
    val ks = parse_element (element ("""ExcAC3A.ks"""))_
    val seve1 = parse_element (element ("""ExcAC3A.seve1"""))_
    val seve2 = parse_element (element ("""ExcAC3A.seve2"""))_
    val ta = parse_element (element ("""ExcAC3A.ta"""))_
    val tb = parse_element (element ("""ExcAC3A.tb"""))_
    val tc = parse_element (element ("""ExcAC3A.tc"""))_
    val te = parse_element (element ("""ExcAC3A.te"""))_
    val tf = parse_element (element ("""ExcAC3A.tf"""))_
    val vamax = parse_element (element ("""ExcAC3A.vamax"""))_
    val vamin = parse_element (element ("""ExcAC3A.vamin"""))_
    val ve1 = parse_element (element ("""ExcAC3A.ve1"""))_
    val ve2 = parse_element (element ("""ExcAC3A.ve2"""))_
    val vemin = parse_element (element ("""ExcAC3A.vemin"""))_
    val vfemax = parse_element (element ("""ExcAC3A.vfemax"""))_
    val vlv = parse_element (element ("""ExcAC3A.vlv"""))_
    def parse (context: Context): ExcAC3A =
    {
        ExcAC3A(
            sup (context),
            toDouble (efdn (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (kf1 (context), context),
            toDouble (kf2 (context), context),
            toDouble (klv (context), context),
            toDouble (kn (context), context),
            toDouble (kr (context), context),
            toDouble (ks (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vemin (context), context),
            toDouble (vfemax (context), context),
            toDouble (vlv (context), context)
        )
    }
}

/**
 * Modified IEEE AC4A alternator-supplied rectifier excitation system with different minimum controller output.
 */
case class ExcAC4A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 200.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.
     */
    val kc: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.015.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Maximum voltage regulator input limit (Vimax).
     * Typical Value = 10.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (Vimin).
     * Typical Value = -10.
     */
    val vimin: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 5.64.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -4.53.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC4A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC4A
extends
    Parseable[ExcAC4A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcAC4A.ka"""))_
    val kc = parse_element (element ("""ExcAC4A.kc"""))_
    val ta = parse_element (element ("""ExcAC4A.ta"""))_
    val tb = parse_element (element ("""ExcAC4A.tb"""))_
    val tc = parse_element (element ("""ExcAC4A.tc"""))_
    val vimax = parse_element (element ("""ExcAC4A.vimax"""))_
    val vimin = parse_element (element ("""ExcAC4A.vimin"""))_
    val vrmax = parse_element (element ("""ExcAC4A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC4A.vrmin"""))_
    def parse (context: Context): ExcAC4A =
    {
        ExcAC4A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE AC5A alternator-supplied rectifier excitation system with different minimum controller output.
 */
case class ExcAC5A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Coefficient to allow different usage of the model (a).
     * Typical Value = 1.
     */
    val a: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd1).
     * Typical Value = 5.6.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd2).
     * Typical Value = 4.2.
     */
    val efd2: Double,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd1 (S<sub>E</sub>[Efd1]).
     * Typical Value = 0.86.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd2 (S<sub>E</sub>[Efd2]).
     * Typical Value = 0.5.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 0.8.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf1).
     * Typical Value  = 1.
     */
    val tf1: Double,

    /**
     * Excitation control system stabilizer time constant (Tf2).
     * Typical Value = 0.8.
     */
    val tf2: Double,

    /**
     * Excitation control system stabilizer time constant (Tf3).
     * Typical Value = 0.
     */
    val tf3: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 7.3.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value =-7.3.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC5A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC5A
extends
    Parseable[ExcAC5A]
{
    val sup = ExcitationSystemDynamics.parse _
    val a = parse_element (element ("""ExcAC5A.a"""))_
    val efd1 = parse_element (element ("""ExcAC5A.efd1"""))_
    val efd2 = parse_element (element ("""ExcAC5A.efd2"""))_
    val ka = parse_element (element ("""ExcAC5A.ka"""))_
    val ke = parse_element (element ("""ExcAC5A.ke"""))_
    val kf = parse_element (element ("""ExcAC5A.kf"""))_
    val ks = parse_element (element ("""ExcAC5A.ks"""))_
    val seefd1 = parse_element (element ("""ExcAC5A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcAC5A.seefd2"""))_
    val ta = parse_element (element ("""ExcAC5A.ta"""))_
    val tb = parse_element (element ("""ExcAC5A.tb"""))_
    val tc = parse_element (element ("""ExcAC5A.tc"""))_
    val te = parse_element (element ("""ExcAC5A.te"""))_
    val tf1 = parse_element (element ("""ExcAC5A.tf1"""))_
    val tf2 = parse_element (element ("""ExcAC5A.tf2"""))_
    val tf3 = parse_element (element ("""ExcAC5A.tf3"""))_
    val vrmax = parse_element (element ("""ExcAC5A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC5A.vrmin"""))_
    def parse (context: Context): ExcAC5A =
    {
        ExcAC5A(
            sup (context),
            toDouble (a (context), context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ks (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (tf3 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE AC6A alternator-supplied rectifier excitation system with speed input.
 */
case class ExcAC6A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 536.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.173.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (Kd).
     * Typical Value = 1.91.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.6.
     */
    val ke: Double,

    /**
     * Exciter field current limiter gain (Kh).
     * Typical Value = 92.
     */
    val kh: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
     * Typical Value = 0.214.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
     * Typical Value = 0.044.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.086.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 9.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 3.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.
     */
    val te: Double,

    /**
     * Exciter field current limiter time constant (Th).
     * Typical Value = 0.08.
     */
    val th: Double,

    /**
     * Exciter field current limiter time constant (Tj).
     * Typical Value = 0.02.
     */
    val tj: Double,

    /**
     * Voltage regulator time constant (Tk).
     * Typical Value = 0.18.
     */
    val tk: Double,

    /**
     * Maximum voltage regulator output (Vamax).
     * Typical Value = 75.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (Vamin).
     * Typical Value = -75.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>).
     * Typical Value = 7.4.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
     * Typical Value = 5.55.
     */
    val ve2: Double,

    /**
     * Exciter field current limit reference (Vfelim).
     * Typical Value = 19.
     */
    val vfelim: Double,

    /**
     * Maximum field current limiter signal reference (Vhmax).
     * Typical Value = 75.
     */
    val vhmax: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 44.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -36.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC6A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC6A
extends
    Parseable[ExcAC6A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcAC6A.ka"""))_
    val kc = parse_element (element ("""ExcAC6A.kc"""))_
    val kd = parse_element (element ("""ExcAC6A.kd"""))_
    val ke = parse_element (element ("""ExcAC6A.ke"""))_
    val kh = parse_element (element ("""ExcAC6A.kh"""))_
    val ks = parse_element (element ("""ExcAC6A.ks"""))_
    val seve1 = parse_element (element ("""ExcAC6A.seve1"""))_
    val seve2 = parse_element (element ("""ExcAC6A.seve2"""))_
    val ta = parse_element (element ("""ExcAC6A.ta"""))_
    val tb = parse_element (element ("""ExcAC6A.tb"""))_
    val tc = parse_element (element ("""ExcAC6A.tc"""))_
    val te = parse_element (element ("""ExcAC6A.te"""))_
    val th = parse_element (element ("""ExcAC6A.th"""))_
    val tj = parse_element (element ("""ExcAC6A.tj"""))_
    val tk = parse_element (element ("""ExcAC6A.tk"""))_
    val vamax = parse_element (element ("""ExcAC6A.vamax"""))_
    val vamin = parse_element (element ("""ExcAC6A.vamin"""))_
    val ve1 = parse_element (element ("""ExcAC6A.ve1"""))_
    val ve2 = parse_element (element ("""ExcAC6A.ve2"""))_
    val vfelim = parse_element (element ("""ExcAC6A.vfelim"""))_
    val vhmax = parse_element (element ("""ExcAC6A.vhmax"""))_
    val vrmax = parse_element (element ("""ExcAC6A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC6A.vrmin"""))_
    def parse (context: Context): ExcAC6A =
    {
        ExcAC6A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kh (context), context),
            toDouble (ks (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (th (context), context),
            toDouble (tj (context), context),
            toDouble (tk (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vfelim (context), context),
            toDouble (vhmax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE AC8B alternator-supplied rectifier excitation system with speed input and input limiter.
 */
case class ExcAC8B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Input limiter indicator.
    true = input limiter Vimax and Vimin is considered
    false = input limiter Vimax and Vimin is not considered.
     * Typical Value = true.
     */
    val inlim: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 1.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.55.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (Kd).
     * Typical Value = 1.1.
     */
    val kd: Double,

    /**
     * Voltage regulator derivative gain (Kdr).
     * Typical Value = 10.
     */
    val kdr: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Voltage regulator integral gain (Kir).
     * Typical Value = 5.
     */
    val kir: Double,

    /**
     * Voltage regulator proportional gain (Kpr).
     * Typical Value = 80.
     */
    val kpr: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * PID limiter indicator.
    true = input limiter Vpidmax and Vpidmin is considered
    false = input limiter Vpidmax and Vpidmin is not considered.
     * Typical Value = true.
     */
    val pidlim: Boolean,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve1]).
     * Typical Value = 0.3.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve2]).
     * Typical Value = 3.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Lag time constant (Tdr).
     * Typical Value = 0.1.
     */
    val tdr: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.2.
     */
    val te: Double,

    /**
     * Selector for the limiter on the block [1/sTe].
     * See diagram for meaning of true and false.
     */
    val telim: Boolean,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>) equals V<sub>EMAX</sub> (Ve1).
     * Typical Value = 6.5.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
     * Typical Value = 9.
     */
    val ve2: Double,

    /**
     * Minimum exciter voltage output (Vemin).
     * Typical Value = 0.
     */
    val vemin: Double,

    /**
     * Exciter field current limit reference (Vfemax).
     * Typical Value = 6.
     */
    val vfemax: Double,

    /**
     * Input signal maximum (Vimax).
     * Typical Value = 35.
     */
    val vimax: Double,

    /**
     * Input signal minimum (Vimin).
     * Typical Value = -10.
     */
    val vimin: Double,

    /**
     * PID maximum controller output (Vpidmax).
     * Typical Value = 35.
     */
    val vpidmax: Double,

    /**
     * PID minimum controller output (Vpidmin).
     * Typical Value = -10.
     */
    val vpidmin: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 35.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = 0.
     */
    val vrmin: Double,

    /**
     * Multiply by generator's terminal voltage indicator.
    true =the limits Vrmax and Vrmin are multiplied by the generator�s terminal voltage to represent a thyristor power stage fed from the generator terminals
    false = limits are not multiplied by generator's terminal voltage.
     * Typical Value = false.
     */
    val vtmult: Boolean
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAC8B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAC8B
extends
    Parseable[ExcAC8B]
{
    val sup = ExcitationSystemDynamics.parse _
    val inlim = parse_element (element ("""ExcAC8B.inlim"""))_
    val ka = parse_element (element ("""ExcAC8B.ka"""))_
    val kc = parse_element (element ("""ExcAC8B.kc"""))_
    val kd = parse_element (element ("""ExcAC8B.kd"""))_
    val kdr = parse_element (element ("""ExcAC8B.kdr"""))_
    val ke = parse_element (element ("""ExcAC8B.ke"""))_
    val kir = parse_element (element ("""ExcAC8B.kir"""))_
    val kpr = parse_element (element ("""ExcAC8B.kpr"""))_
    val ks = parse_element (element ("""ExcAC8B.ks"""))_
    val pidlim = parse_element (element ("""ExcAC8B.pidlim"""))_
    val seve1 = parse_element (element ("""ExcAC8B.seve1"""))_
    val seve2 = parse_element (element ("""ExcAC8B.seve2"""))_
    val ta = parse_element (element ("""ExcAC8B.ta"""))_
    val tdr = parse_element (element ("""ExcAC8B.tdr"""))_
    val te = parse_element (element ("""ExcAC8B.te"""))_
    val telim = parse_element (element ("""ExcAC8B.telim"""))_
    val ve1 = parse_element (element ("""ExcAC8B.ve1"""))_
    val ve2 = parse_element (element ("""ExcAC8B.ve2"""))_
    val vemin = parse_element (element ("""ExcAC8B.vemin"""))_
    val vfemax = parse_element (element ("""ExcAC8B.vfemax"""))_
    val vimax = parse_element (element ("""ExcAC8B.vimax"""))_
    val vimin = parse_element (element ("""ExcAC8B.vimin"""))_
    val vpidmax = parse_element (element ("""ExcAC8B.vpidmax"""))_
    val vpidmin = parse_element (element ("""ExcAC8B.vpidmin"""))_
    val vrmax = parse_element (element ("""ExcAC8B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcAC8B.vrmin"""))_
    val vtmult = parse_element (element ("""ExcAC8B.vtmult"""))_
    def parse (context: Context): ExcAC8B =
    {
        ExcAC8B(
            sup (context),
            toBoolean (inlim (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (kdr (context), context),
            toDouble (ke (context), context),
            toDouble (kir (context), context),
            toDouble (kpr (context), context),
            toDouble (ks (context), context),
            toBoolean (pidlim (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tdr (context), context),
            toDouble (te (context), context),
            toBoolean (telim (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vemin (context), context),
            toDouble (vfemax (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vpidmax (context), context),
            toDouble (vpidmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toBoolean (vtmult (context), context)
        )
    }
}

/**
 * Italian excitation system.
 * It represents static field voltage or excitation current feedback excitation system.
 */
case class ExcANS
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Governor Control Flag (BLINT). 
    0 = lead-lag regulator
    1 = proportional integral regulator.
     * Typical Value = 0.
     */
    val blint: Int,

    /**
     * Minimum exciter current (I<sub>FMN</sub>).
     * Typical Value = -5.2.
     */
    val ifmn: Double,

    /**
     * Maximum exciter current (I<sub>FMX</sub>).
     * Typical Value = 6.5.
     */
    val ifmx: Double,

    /**
     * Exciter gain (K<sub>2</sub>).
     * Typical Value = 20.
     */
    val k2: Double,

    /**
     * AVR gain (K<sub>3</sub>).
     * Typical Value = 1000.
     */
    val k3: Double,

    /**
     * Ceiling factor (K<sub>CE</sub>).
     * Typical Value = 1.
     */
    val kce: Double,

    /**
     * Feedback enabling (K<sub>RVECC</sub>). 
    0 = Open loop control
    1 = Closed loop control.
     * Typical Value = 1.
     */
    val krvecc: Int,

    /**
     * Rate feedback signal flag (K<sub>VFIF</sub>). 
    0 = output voltage of the exciter
    1 = exciter field current.
     * Typical Value = 0.
     */
    val kvfif: Int,

    /**
     * Time constant (T<sub>1</sub>).
     * Typical Value = 20.
     */
    val t1: Double,

    /**
     * Time constant (T<sub>2</sub>).
     * Typical Value = 0.05.
     */
    val t2: Double,

    /**
     * Time constant (T<sub>3</sub>).
     * Typical Value = 1.6.
     */
    val t3: Double,

    /**
     * Exciter time constant (T<sub>B</sub>).
     * Typical Value = 0.04.
     */
    val tb: Double,

    /**
     * Minimum AVR output (V<sub>RMN</sub>).
     * Typical Value = -5.2.
     */
    val vrmn: Double,

    /**
     * Maximum AVR output (V<sub>RMX</sub>).
     * Typical Value = 6.5.
     */
    val vrmx: Double
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcANS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcANS
extends
    Parseable[ExcANS]
{
    val sup = ExcitationSystemDynamics.parse _
    val blint = parse_element (element ("""ExcANS.blint"""))_
    val ifmn = parse_element (element ("""ExcANS.ifmn"""))_
    val ifmx = parse_element (element ("""ExcANS.ifmx"""))_
    val k2 = parse_element (element ("""ExcANS.k2"""))_
    val k3 = parse_element (element ("""ExcANS.k3"""))_
    val kce = parse_element (element ("""ExcANS.kce"""))_
    val krvecc = parse_element (element ("""ExcANS.krvecc"""))_
    val kvfif = parse_element (element ("""ExcANS.kvfif"""))_
    val t1 = parse_element (element ("""ExcANS.t1"""))_
    val t2 = parse_element (element ("""ExcANS.t2"""))_
    val t3 = parse_element (element ("""ExcANS.t3"""))_
    val tb = parse_element (element ("""ExcANS.tb"""))_
    val vrmn = parse_element (element ("""ExcANS.vrmn"""))_
    val vrmx = parse_element (element ("""ExcANS.vrmx"""))_
    def parse (context: Context): ExcANS =
    {
        ExcANS(
            sup (context),
            toInteger (blint (context), context),
            toDouble (ifmn (context), context),
            toDouble (ifmx (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (kce (context), context),
            toInteger (krvecc (context), context),
            toInteger (kvfif (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (tb (context), context),
            toDouble (vrmn (context), context),
            toDouble (vrmx (context), context)
        )
    }
}

/**
 * Italian excitation system corresponding to IEEE (1968) Type 1 Model.
 * It represents exciter dynamo and electromechanical regulator.
 */
case class ExcAVR1
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage value 1  (E1).
     * Typical Value = 4.18.
     */
    val e1: Double,

    /**
     * Field voltage value 2 (E2).
     * Typical Value = 3.14.
     */
    val e2: Double,

    /**
     * AVR gain (K<sub>A</sub>).
     * Typical Value = 500.
     */
    val ka: Double,

    /**
     * Rate feedback gain (K<sub>F</sub>).
     * Typical Value = 0.12.
     */
    val kf: Double,

    /**
     * Saturation factor at E1 (S(E1)).
     * Typical Value = 0.1.
     */
    val se1: Double,

    /**
     * Saturation factor at E2 (S(E2)).
     * Typical Value = 0.03.
     */
    val se2: Double,

    /**
     * AVR time constant (T<sub>A</sub>).
     * Typical Value = 0.2.
     */
    val ta: Double,

    /**
     * AVR time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Exciter time constant (T<sub>E</sub>).
     * Typical Value = 1.
     */
    val te: Double,

    /**
     * Rate feedback time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Minimum AVR output (V<sub>RMN</sub>).
     * Typical Value = -6.
     */
    val vrmn: Double,

    /**
     * Maximum AVR output (V<sub>RMX</sub>).
     * Typical Value = 7.
     */
    val vrmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR1
extends
    Parseable[ExcAVR1]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcAVR1.e1"""))_
    val e2 = parse_element (element ("""ExcAVR1.e2"""))_
    val ka = parse_element (element ("""ExcAVR1.ka"""))_
    val kf = parse_element (element ("""ExcAVR1.kf"""))_
    val se1 = parse_element (element ("""ExcAVR1.se1"""))_
    val se2 = parse_element (element ("""ExcAVR1.se2"""))_
    val ta = parse_element (element ("""ExcAVR1.ta"""))_
    val tb = parse_element (element ("""ExcAVR1.tb"""))_
    val te = parse_element (element ("""ExcAVR1.te"""))_
    val tf = parse_element (element ("""ExcAVR1.tf"""))_
    val vrmn = parse_element (element ("""ExcAVR1.vrmn"""))_
    val vrmx = parse_element (element ("""ExcAVR1.vrmx"""))_
    def parse (context: Context): ExcAVR1 =
    {
        ExcAVR1(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            toDouble (ka (context), context),
            toDouble (kf (context), context),
            toDouble (se1 (context), context),
            toDouble (se2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vrmn (context), context),
            toDouble (vrmx (context), context)
        )
    }
}

/**
 * Italian excitation system corresponding to IEEE (1968) Type 2 Model.
 * It represents alternator and rotating diodes and electromechanic voltage regulators.
 */
case class ExcAVR2
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage value 1 (E1).
     * Typical Value = 4.18.
     */
    val e1: Double,

    /**
     * Field voltage value 2 (E2).
     * Typical Value = 3.14.
     */
    val e2: Double,

    /**
     * AVR gain (K<sub>A</sub>).
     * Typical Value = 500.
     */
    val ka: Double,

    /**
     * Rate feedback gain (K<sub>F</sub>).
     * Typical Value = 0.12.
     */
    val kf: Double,

    /**
     * Saturation factor at E1 (S(E1)).
     * Typical Value = 0.1.
     */
    val se1: Double,

    /**
     * Saturation factor at E2 (S(E2)).
     * Typical Value = 0.03.
     */
    val se2: Double,

    /**
     * AVR time constant (T<sub>A</sub>).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * AVR time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Exciter time constant (T<sub>E</sub>).
     * Typical Value = 1.
     */
    val te: Double,

    /**
     * Rate feedback time constant (T<sub>F1</sub>).
     * Typical Value = 1.
     */
    val tf1: Double,

    /**
     * Rate feedback time constant (T<sub>F2</sub>).
     * Typical Value = 1.
     */
    val tf2: Double,

    /**
     * Minimum AVR output (V<sub>RMN</sub>).
     * Typical Value = -6.
     */
    val vrmn: Double,

    /**
     * Maximum AVR output (V<sub>RMX</sub>).
     * Typical Value = 7.
     */
    val vrmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR2
extends
    Parseable[ExcAVR2]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcAVR2.e1"""))_
    val e2 = parse_element (element ("""ExcAVR2.e2"""))_
    val ka = parse_element (element ("""ExcAVR2.ka"""))_
    val kf = parse_element (element ("""ExcAVR2.kf"""))_
    val se1 = parse_element (element ("""ExcAVR2.se1"""))_
    val se2 = parse_element (element ("""ExcAVR2.se2"""))_
    val ta = parse_element (element ("""ExcAVR2.ta"""))_
    val tb = parse_element (element ("""ExcAVR2.tb"""))_
    val te = parse_element (element ("""ExcAVR2.te"""))_
    val tf1 = parse_element (element ("""ExcAVR2.tf1"""))_
    val tf2 = parse_element (element ("""ExcAVR2.tf2"""))_
    val vrmn = parse_element (element ("""ExcAVR2.vrmn"""))_
    val vrmx = parse_element (element ("""ExcAVR2.vrmx"""))_
    def parse (context: Context): ExcAVR2 =
    {
        ExcAVR2(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            toDouble (ka (context), context),
            toDouble (kf (context), context),
            toDouble (se1 (context), context),
            toDouble (se2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (te (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (vrmn (context), context),
            toDouble (vrmx (context), context)
        )
    }
}

/**
 * Italian excitation system.
 * It represents exciter dynamo and electric regulator.
 */
case class ExcAVR3
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage value 1 (E1).
     * Typical Value = 4.18.
     */
    val e1: Double,

    /**
     * Field voltage value 2 (E2).
     * Typical Value = 3.14.
     */
    val e2: Double,

    /**
     * AVR gain (K<sub>A</sub>).
     * Typical Value = 100.
     */
    val ka: Double,

    /**
     * Saturation factor at E1 (S(E1)).
     * Typical Value = 0.1.
     */
    val se1: Double,

    /**
     * Saturation factor at E2 (S(E2)).
     * Typical Value = 0.03.
     */
    val se2: Double,

    /**
     * AVR time constant (T<sub>1</sub>).
     * Typical Value = 20.
     */
    val t1: Double,

    /**
     * AVR time constant (T<sub>2</sub>).
     * Typical Value = 1.6.
     */
    val t2: Double,

    /**
     * AVR time constant (T<sub>3</sub>).
     * Typical Value = 0.66.
     */
    val t3: Double,

    /**
     * AVR time constant (T<sub>4</sub>).
     * Typical Value = 0.07.
     */
    val t4: Double,

    /**
     * Exciter time constant (T<sub>E</sub>).
     * Typical Value = 1.
     */
    val te: Double,

    /**
     * Minimum AVR output (V<sub>RMN</sub>).
     * Typical Value = -7.5.
     */
    val vrmn: Double,

    /**
     * Maximum AVR output (V<sub>RMX</sub>).
     * Typical Value = 7.5.
     */
    val vrmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR3]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR3
extends
    Parseable[ExcAVR3]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcAVR3.e1"""))_
    val e2 = parse_element (element ("""ExcAVR3.e2"""))_
    val ka = parse_element (element ("""ExcAVR3.ka"""))_
    val se1 = parse_element (element ("""ExcAVR3.se1"""))_
    val se2 = parse_element (element ("""ExcAVR3.se2"""))_
    val t1 = parse_element (element ("""ExcAVR3.t1"""))_
    val t2 = parse_element (element ("""ExcAVR3.t2"""))_
    val t3 = parse_element (element ("""ExcAVR3.t3"""))_
    val t4 = parse_element (element ("""ExcAVR3.t4"""))_
    val te = parse_element (element ("""ExcAVR3.te"""))_
    val vrmn = parse_element (element ("""ExcAVR3.vrmn"""))_
    val vrmx = parse_element (element ("""ExcAVR3.vrmx"""))_
    def parse (context: Context): ExcAVR3 =
    {
        ExcAVR3(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            toDouble (ka (context), context),
            toDouble (se1 (context), context),
            toDouble (se2 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (te (context), context),
            toDouble (vrmn (context), context),
            toDouble (vrmx (context), context)
        )
    }
}

/**
 * Italian excitation system.
 * It represents static exciter and electric voltage regulator.
 */
case class ExcAVR4
(

    override val sup: ExcitationSystemDynamics,

    /**
     * AVR output voltage dependency selector (Imul).
    true = selector is connected
    false = selector is not connected.
     * Typical Value = true.
     */
    val imul: Boolean,

    /**
     * AVR gain (K<sub>A</sub>).
     * Typical Value = 300.
     */
    val ka: Double,

    /**
     * Exciter gain (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Exciter internal reactance (K<sub>IF</sub>).
     * Typical Value = 0.
     */
    val kif: Double,

    /**
     * AVR time constant (T<sub>1</sub>).
     * Typical Value = 4.8.
     */
    val t1: Double,

    /**
     * Exciter current feedback time constant (T<sub>1IF</sub>).
     * Typical Value = 60.
     */
    val t1if: Double,

    /**
     * AVR time constant (T<sub>2</sub>).
     * Typical Value = 1.5.
     */
    val t2: Double,

    /**
     * AVR time constant (T<sub>3</sub>).
     * Typical Value = 0.
     */
    val t3: Double,

    /**
     * AVR time constant (T<sub>4</sub>).
     * Typical Value = 0.
     */
    val t4: Double,

    /**
     * Exciter current feedback time constant (T<sub>IF</sub>).
     * Typical Value = 0.
     */
    val tif: Double,

    /**
     * Minimum exciter output (V<sub>FMN</sub>).
     * Typical Value = 0.
     */
    val vfmn: Double,

    /**
     * Maximum exciter output (V<sub>FMX</sub>).
     * Typical Value = 5.
     */
    val vfmx: Double,

    /**
     * Minimum AVR output (V<sub>RMN</sub>).
     * Typical Value = 0.
     */
    val vrmn: Double,

    /**
     * Maximum AVR output (V<sub>RMX</sub>).
     * Typical Value = 5.
     */
    val vrmx: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR4]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR4
extends
    Parseable[ExcAVR4]
{
    val sup = ExcitationSystemDynamics.parse _
    val imul = parse_element (element ("""ExcAVR4.imul"""))_
    val ka = parse_element (element ("""ExcAVR4.ka"""))_
    val ke = parse_element (element ("""ExcAVR4.ke"""))_
    val kif = parse_element (element ("""ExcAVR4.kif"""))_
    val t1 = parse_element (element ("""ExcAVR4.t1"""))_
    val t1if = parse_element (element ("""ExcAVR4.t1if"""))_
    val t2 = parse_element (element ("""ExcAVR4.t2"""))_
    val t3 = parse_element (element ("""ExcAVR4.t3"""))_
    val t4 = parse_element (element ("""ExcAVR4.t4"""))_
    val tif = parse_element (element ("""ExcAVR4.tif"""))_
    val vfmn = parse_element (element ("""ExcAVR4.vfmn"""))_
    val vfmx = parse_element (element ("""ExcAVR4.vfmx"""))_
    val vrmn = parse_element (element ("""ExcAVR4.vrmn"""))_
    val vrmx = parse_element (element ("""ExcAVR4.vrmx"""))_
    def parse (context: Context): ExcAVR4 =
    {
        ExcAVR4(
            sup (context),
            toBoolean (imul (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kif (context), context),
            toDouble (t1 (context), context),
            toDouble (t1if (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (tif (context), context),
            toDouble (vfmn (context), context),
            toDouble (vfmx (context), context),
            toDouble (vrmn (context), context),
            toDouble (vrmx (context), context)
        )
    }
}

/**
 * Manual excitation control with field circuit resistance.
 * This model can be used as a very simple representation of manual voltage control.
 */
case class ExcAVR5
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Gain (Ka).
     */
    val ka: Double,

    /**
     * Effective Output Resistance (Rex).
     * Rex represents the effective output resistance seen by the excitation system.
     */
    val rex: Double,

    /**
     * Time constant (Ta).
     */
    val ta: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR5]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR5
extends
    Parseable[ExcAVR5]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcAVR5.ka"""))_
    val rex = parse_element (element ("""ExcAVR5.rex"""))_
    val ta = parse_element (element ("""ExcAVR5.ta"""))_
    def parse (context: Context): ExcAVR5 =
    {
        ExcAVR5(
            sup (context),
            toDouble (ka (context), context),
            toDouble (rex (context), context),
            toDouble (ta (context), context)
        )
    }
}

/**
 * IVO excitation system.
 */
case class ExcAVR7
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Lead coefficient (A1).
     * Typical Value = 0.5.
     */
    val a1: Double,

    /**
     * Lag coefficient (A2).
     * Typical Value = 0.5.
     */
    val a2: Double,

    /**
     * Lead coefficient (A3).
     * Typical Value = 0.5.
     */
    val a3: Double,

    /**
     * Lag coefficient (A4).
     * Typical Value = 0.5.
     */
    val a4: Double,

    /**
     * Lead coefficient (A5).
     * Typical Value = 0.5.
     */
    val a5: Double,

    /**
     * Lag coefficient (A6).
     * Typical Value = 0.5.
     */
    val a6: Double,

    /**
     * Gain (K1).
     * Typical Value = 1.
     */
    val k1: Double,

    /**
     * Gain (K3).
     * Typical Value = 3.
     */
    val k3: Double,

    /**
     * Gain (K5).
     * Typical Value = 1.
     */
    val k5: Double,

    /**
     * Lead time constant (T1).
     * Typical Value = 0.05.
     */
    val t1: Double,

    /**
     * Lag time constant (T2).
     * Typical Value = 0.1.
     */
    val t2: Double,

    /**
     * Lead time constant (T3).
     * Typical Value = 0.1.
     */
    val t3: Double,

    /**
     * Lag time constant (T4).
     * Typical Value = 0.1.
     */
    val t4: Double,

    /**
     * Lead time constant (T5).
     * Typical Value = 0.1.
     */
    val t5: Double,

    /**
     * Lag time constant (T6).
     * Typical Value = 0.1.
     */
    val t6: Double,

    /**
     * Lead-lag max. limit (Vmax1).
     * Typical Value = 5.
     */
    val vmax1: Double,

    /**
     * Lead-lag max. limit (Vmax3).
     * Typical Value = 5.
     */
    val vmax3: Double,

    /**
     * Lead-lag max. limit (Vmax5).
     * Typical Value = 5.
     */
    val vmax5: Double,

    /**
     * Lead-lag min. limit (Vmin1).
     * Typical Value = -5.
     */
    val vmin1: Double,

    /**
     * Lead-lag min. limit (Vmin3).
     * Typical Value = -5.
     */
    val vmin3: Double,

    /**
     * Lead-lag min. limit (Vmin5).
     * Typical Value = -2.
     */
    val vmin5: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcAVR7]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcAVR7
extends
    Parseable[ExcAVR7]
{
    val sup = ExcitationSystemDynamics.parse _
    val a1 = parse_element (element ("""ExcAVR7.a1"""))_
    val a2 = parse_element (element ("""ExcAVR7.a2"""))_
    val a3 = parse_element (element ("""ExcAVR7.a3"""))_
    val a4 = parse_element (element ("""ExcAVR7.a4"""))_
    val a5 = parse_element (element ("""ExcAVR7.a5"""))_
    val a6 = parse_element (element ("""ExcAVR7.a6"""))_
    val k1 = parse_element (element ("""ExcAVR7.k1"""))_
    val k3 = parse_element (element ("""ExcAVR7.k3"""))_
    val k5 = parse_element (element ("""ExcAVR7.k5"""))_
    val t1 = parse_element (element ("""ExcAVR7.t1"""))_
    val t2 = parse_element (element ("""ExcAVR7.t2"""))_
    val t3 = parse_element (element ("""ExcAVR7.t3"""))_
    val t4 = parse_element (element ("""ExcAVR7.t4"""))_
    val t5 = parse_element (element ("""ExcAVR7.t5"""))_
    val t6 = parse_element (element ("""ExcAVR7.t6"""))_
    val vmax1 = parse_element (element ("""ExcAVR7.vmax1"""))_
    val vmax3 = parse_element (element ("""ExcAVR7.vmax3"""))_
    val vmax5 = parse_element (element ("""ExcAVR7.vmax5"""))_
    val vmin1 = parse_element (element ("""ExcAVR7.vmin1"""))_
    val vmin3 = parse_element (element ("""ExcAVR7.vmin3"""))_
    val vmin5 = parse_element (element ("""ExcAVR7.vmin5"""))_
    def parse (context: Context): ExcAVR7 =
    {
        ExcAVR7(
            sup (context),
            toDouble (a1 (context), context),
            toDouble (a2 (context), context),
            toDouble (a3 (context), context),
            toDouble (a4 (context), context),
            toDouble (a5 (context), context),
            toDouble (a6 (context), context),
            toDouble (k1 (context), context),
            toDouble (k3 (context), context),
            toDouble (k5 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (vmax1 (context), context),
            toDouble (vmax3 (context), context),
            toDouble (vmax5 (context), context),
            toDouble (vmin1 (context), context),
            toDouble (vmin3 (context), context),
            toDouble (vmin5 (context), context)
        )
    }
}

/**
 * Transformer fed static excitation system (static with ABB regulator).
 * This model represents a static excitation system in which a gated thyristor bridge fed by a transformer at the main generator terminals feeds the main generator directly.
 */
case class ExcBBC
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum open circuit exciter voltage (Efdmax).
     * Typical Value = 5.
     */
    val efdmax: Double,

    /**
     * Minimum open circuit exciter voltage (Efdmin).
     * Typical Value = -5.
     */
    val efdmin: Double,

    /**
     * Steady state gain (K).
     * Typical Value = 300.
     */
    val k: Double,

    /**
     * Supplementary signal routing selector (switch).
    true = Vs connected to 3rd summing point
    false =  Vs connected to 1st summing point (see diagram).
     * Typical Value = true.
     */
    val switch: Boolean,

    /**
     * Controller time constant (T1).
     * Typical Value = 6.
     */
    val t1: Double,

    /**
     * Controller time constant (T2).
     * Typical Value = 1.
     */
    val t2: Double,

    /**
     * Lead/lag time constant (T3).
     * Typical Value = 0.05.
     */
    val t3: Double,

    /**
     * Lead/lag time constant (T4).
     * Typical Value = 0.01.
     */
    val t4: Double,

    /**
     * Maximum control element output (Vrmax).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum control element output (Vrmin).
     * Typical Value = -5.
     */
    val vrmin: Double,

    /**
     * Effective excitation transformer reactance (Xe).
     * Typical Value = 0.05.
     */
    val xe: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcBBC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcBBC
extends
    Parseable[ExcBBC]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcBBC.efdmax"""))_
    val efdmin = parse_element (element ("""ExcBBC.efdmin"""))_
    val k = parse_element (element ("""ExcBBC.k"""))_
    val switch = parse_element (element ("""ExcBBC.switch"""))_
    val t1 = parse_element (element ("""ExcBBC.t1"""))_
    val t2 = parse_element (element ("""ExcBBC.t2"""))_
    val t3 = parse_element (element ("""ExcBBC.t3"""))_
    val t4 = parse_element (element ("""ExcBBC.t4"""))_
    val vrmax = parse_element (element ("""ExcBBC.vrmax"""))_
    val vrmin = parse_element (element ("""ExcBBC.vrmin"""))_
    val xe = parse_element (element ("""ExcBBC.xe"""))_
    def parse (context: Context): ExcBBC =
    {
        ExcBBC(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (efdmin (context), context),
            toDouble (k (context), context),
            toBoolean (switch (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xe (context), context)
        )
    }
}

/**
 * Czech Proportion/Integral Exciter.
 */
case class ExcCZ
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter output maximum limit (Efdmax).
     */
    val efdmax: Double,

    /**
     * Exciter output minimum limit (Efdmin).
     */
    val efdmin: Double,

    /**
     * Regulator gain (Ka).
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     */
    val ke: Double,

    /**
     * Regulator proportional gain (Kp).
     */
    val kp: Double,

    /**
     * Regulator time constant (Ta).
     */
    val ta: Double,

    /**
     * Regulator integral time constant (Tc).
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     */
    val te: Double,

    /**
     * Voltage regulator maximum limit (Vrmax).
     */
    val vrmax: Double,

    /**
     * Voltage regulator minimum limit (Vrmin).
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcCZ]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcCZ
extends
    Parseable[ExcCZ]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcCZ.efdmax"""))_
    val efdmin = parse_element (element ("""ExcCZ.efdmin"""))_
    val ka = parse_element (element ("""ExcCZ.ka"""))_
    val ke = parse_element (element ("""ExcCZ.ke"""))_
    val kp = parse_element (element ("""ExcCZ.kp"""))_
    val ta = parse_element (element ("""ExcCZ.ta"""))_
    val tc = parse_element (element ("""ExcCZ.tc"""))_
    val te = parse_element (element ("""ExcCZ.te"""))_
    val vrmax = parse_element (element ("""ExcCZ.vrmax"""))_
    val vrmin = parse_element (element ("""ExcCZ.vrmin"""))_
    def parse (context: Context): ExcCZ =
    {
        ExcCZ(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (efdmin (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kp (context), context),
            toDouble (ta (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE DC1A direct current commutator exciter with speed input and without underexcitation limiters (UEL) inputs.
 */
case class ExcDC1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum voltage exciter output limiter (Efdmax).
     * Typical Value = 99.
     */
    val edfmax: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd1).
     * Typical Value = 3.1.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd2).
     * Typical Value = 2.3.
     */
    val efd2: Double,

    /**
     * Minimum voltage exciter output limiter (Efdmin).
     * Typical Value = -99.
     */
    val efdmin: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output.
     */
    val exclim: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 46.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 0.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (Kf).
     * Typical Value = 0.1.
     */
    val kf: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
     * Typical Value = 0.33.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
     * Typical Value = 0.33.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.06.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 0.46.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -0.9.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcDC1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcDC1A
extends
    Parseable[ExcDC1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val edfmax = parse_element (element ("""ExcDC1A.edfmax"""))_
    val efd1 = parse_element (element ("""ExcDC1A.efd1"""))_
    val efd2 = parse_element (element ("""ExcDC1A.efd2"""))_
    val efdmin = parse_element (element ("""ExcDC1A.efdmin"""))_
    val exclim = parse_element (element ("""ExcDC1A.exclim"""))_
    val ka = parse_element (element ("""ExcDC1A.ka"""))_
    val ke = parse_element (element ("""ExcDC1A.ke"""))_
    val kf = parse_element (element ("""ExcDC1A.kf"""))_
    val ks = parse_element (element ("""ExcDC1A.ks"""))_
    val seefd1 = parse_element (element ("""ExcDC1A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcDC1A.seefd2"""))_
    val ta = parse_element (element ("""ExcDC1A.ta"""))_
    val tb = parse_element (element ("""ExcDC1A.tb"""))_
    val tc = parse_element (element ("""ExcDC1A.tc"""))_
    val te = parse_element (element ("""ExcDC1A.te"""))_
    val tf = parse_element (element ("""ExcDC1A.tf"""))_
    val vrmax = parse_element (element ("""ExcDC1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcDC1A.vrmin"""))_
    def parse (context: Context): ExcDC1A =
    {
        ExcDC1A(
            sup (context),
            toDouble (edfmax (context), context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (efdmin (context), context),
            toBoolean (exclim (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ks (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE DC2A direct current commutator exciters with speed input, one more leg block in feedback loop and without underexcitation limiters (UEL) inputs.
 * DC type 2 excitation system model with added speed multiplier, added lead-lag, and voltage-dependent limits.
 */
case class ExcDC2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd1).
     * Typical Value = 3.05.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd2).
     * Typical Value = 2.29.
     */
    val efd2: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output.
     */
    val exclim: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 300.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * If Ke is entered as zero, the model calculates an effective value of Ke such that the initial condition value of Vr is zero. The zero value of Ke is not changed.  If Ke is entered as non-zero, its value is used directly, without change.  Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (Kf).
     * Typical Value = 0.1.
     */
    val kf: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
     * Typical Value = 0.279.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd2 (Se[Efd2]).
     * Typical Value = 0.117.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.01.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.33.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 0.675.
     */
    val tf: Double,

    /**
     * Excitation control system stabilizer time constant (Tf1).
     * Typical Value = 0.
     */
    val tf1: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 4.95.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -4.9.
     */
    val vrmin: Double,

    /**
     * (Vtlim).
    true = limiter at the block [Ka/(1+sTa)] is dependent on Vt 
    false = limiter at the block is not dependent on Vt.
     * Typical Value = true.
     */
    val vtlim: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcDC2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcDC2A
extends
    Parseable[ExcDC2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcDC2A.efd1"""))_
    val efd2 = parse_element (element ("""ExcDC2A.efd2"""))_
    val exclim = parse_element (element ("""ExcDC2A.exclim"""))_
    val ka = parse_element (element ("""ExcDC2A.ka"""))_
    val ke = parse_element (element ("""ExcDC2A.ke"""))_
    val kf = parse_element (element ("""ExcDC2A.kf"""))_
    val ks = parse_element (element ("""ExcDC2A.ks"""))_
    val seefd1 = parse_element (element ("""ExcDC2A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcDC2A.seefd2"""))_
    val ta = parse_element (element ("""ExcDC2A.ta"""))_
    val tb = parse_element (element ("""ExcDC2A.tb"""))_
    val tc = parse_element (element ("""ExcDC2A.tc"""))_
    val te = parse_element (element ("""ExcDC2A.te"""))_
    val tf = parse_element (element ("""ExcDC2A.tf"""))_
    val tf1 = parse_element (element ("""ExcDC2A.tf1"""))_
    val vrmax = parse_element (element ("""ExcDC2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcDC2A.vrmin"""))_
    val vtlim = parse_element (element ("""ExcDC2A.vtlim"""))_
    def parse (context: Context): ExcDC2A =
    {
        ExcDC2A(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toBoolean (exclim (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ks (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (tf1 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toBoolean (vtlim (context), context)
        )
    }
}

/**
 * This is modified IEEE DC3A direct current commutator exciters with speed input, and death band.
 * DC old type 4.
 */
case class ExcDC3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum voltage exciter output limiter (Efdmax).
     * Typical Value = 99.
     */
    val edfmax: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd1).
     * Typical Value = 2.6.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (Efd2).
     * Typical Value = 3.45.
     */
    val efd2: Double,

    /**
     * (Efdlim).
    true = exciter output limiter is active
    false = exciter output limiter not active.
     * Typical Value = true.
     */
    val efdlim: Boolean,

    /**
     * Minimum voltage exciter output limiter (Efdmin).
     * Typical Value = -99.
     */
    val efdmin: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output.
     */
    val exclim: Boolean,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Death band (Kr).
     * If Kr is not zero, the voltage regulator input changes at a constant rate if Verr &gt; Kr or Verr &lt; -Kr as per the IEEE (1968) Type 4 model. If Kr is zero, the error signal drives the voltage regulator continuously as per the IEEE (1980) DC3 and IEEE (1992, 2005) DC3A models.  Typical Value = 0.
     */
    val kr: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Fast raise/lower contact setting (Kv).
     * Typical Value = 0.05.
     */
    val kv: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
     * Typical Value = 0.1.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Efd2 (Se[Efd2]).
     * Typical Value = 0.35.
     */
    val seefd2: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.83.
     */
    val te: Double,

    /**
     * Rheostat travel time (Trh).
     * Typical Value = 20.
     */
    val trh: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = 0.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcDC3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcDC3A
extends
    Parseable[ExcDC3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val edfmax = parse_element (element ("""ExcDC3A.edfmax"""))_
    val efd1 = parse_element (element ("""ExcDC3A.efd1"""))_
    val efd2 = parse_element (element ("""ExcDC3A.efd2"""))_
    val efdlim = parse_element (element ("""ExcDC3A.efdlim"""))_
    val efdmin = parse_element (element ("""ExcDC3A.efdmin"""))_
    val exclim = parse_element (element ("""ExcDC3A.exclim"""))_
    val ke = parse_element (element ("""ExcDC3A.ke"""))_
    val kr = parse_element (element ("""ExcDC3A.kr"""))_
    val ks = parse_element (element ("""ExcDC3A.ks"""))_
    val kv = parse_element (element ("""ExcDC3A.kv"""))_
    val seefd1 = parse_element (element ("""ExcDC3A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcDC3A.seefd2"""))_
    val te = parse_element (element ("""ExcDC3A.te"""))_
    val trh = parse_element (element ("""ExcDC3A.trh"""))_
    val vrmax = parse_element (element ("""ExcDC3A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcDC3A.vrmin"""))_
    def parse (context: Context): ExcDC3A =
    {
        ExcDC3A(
            sup (context),
            toDouble (edfmax (context), context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toBoolean (efdlim (context), context),
            toDouble (efdmin (context), context),
            toBoolean (exclim (context), context),
            toDouble (ke (context), context),
            toDouble (kr (context), context),
            toDouble (ks (context), context),
            toDouble (kv (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (te (context), context),
            toDouble (trh (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * This is modified old IEEE type 3 excitation system.
 */
case class ExcDC3A1
(

    override val sup: ExcitationSystemDynamics,

    /**
     * (exclim).
    true = lower limit of zero is applied to integrator output
    false = lower limit of zero not applied to integrator output.
     * Typical Value = true.
     */
    val exclim: Boolean,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 300.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (Kf).
     * Typical Value = 0.1.
     */
    val kf: Double,

    /**
     * Potential circuit gain coefficient (Ki).
     * Typical Value = 4.83.
     */
    val ki: Double,

    /**
     * Potential circuit gain coefficient (Kp).
     * Typical Value = 4.37.
     */
    val kp: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.01.
     */
    val ta: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 1.83.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 0.675.
     */
    val tf: Double,

    /**
     * Available exciter voltage limiter (Vb1max).
     * Typical Value = 11.63.
     */
    val vb1max: Double,

    /**
     * Vb limiter indicator.
    true = exciter Vbmax limiter is active
    false = Vb1max is active.
     * Typical Value = true.
     */
    val vblim: Boolean,

    /**
     * Available exciter voltage limiter (Vbmax).
     * Typical Value = 11.63.
     */
    val vbmax: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = 0.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcDC3A1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcDC3A1
extends
    Parseable[ExcDC3A1]
{
    val sup = ExcitationSystemDynamics.parse _
    val exclim = parse_element (element ("""ExcDC3A1.exclim"""))_
    val ka = parse_element (element ("""ExcDC3A1.ka"""))_
    val ke = parse_element (element ("""ExcDC3A1.ke"""))_
    val kf = parse_element (element ("""ExcDC3A1.kf"""))_
    val ki = parse_element (element ("""ExcDC3A1.ki"""))_
    val kp = parse_element (element ("""ExcDC3A1.kp"""))_
    val ta = parse_element (element ("""ExcDC3A1.ta"""))_
    val te = parse_element (element ("""ExcDC3A1.te"""))_
    val tf = parse_element (element ("""ExcDC3A1.tf"""))_
    val vb1max = parse_element (element ("""ExcDC3A1.vb1max"""))_
    val vblim = parse_element (element ("""ExcDC3A1.vblim"""))_
    val vbmax = parse_element (element ("""ExcDC3A1.vbmax"""))_
    val vrmax = parse_element (element ("""ExcDC3A1.vrmax"""))_
    val vrmin = parse_element (element ("""ExcDC3A1.vrmin"""))_
    def parse (context: Context): ExcDC3A1 =
    {
        ExcDC3A1(
            sup (context),
            toBoolean (exclim (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (ta (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vb1max (context), context),
            toBoolean (vblim (context), context),
            toDouble (vbmax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Static PI transformer fed excitation system: ELIN (VATECH) - simplified model.
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  A power system stabilizer with power input is included in the model.
 */
case class ExcELIN1
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Controller follow up dead band (Dpnf).
     * Typical Value = 0.
     */
    val dpnf: Double,

    /**
     * Maximum open circuit excitation voltage (Efmax).
     * Typical Value = 5.
     */
    val efmax: Double,

    /**
     * Minimum open circuit excitation voltage (Efmin).
     * Typical Value = -5.
     */
    val efmin: Double,

    /**
     * Stabilizer Gain 1 (Ks1).
     * Typical Value = 0.
     */
    val ks1: Double,

    /**
     * Stabilizer Gain 2 (Ks2).
     * Typical Value = 0.
     */
    val ks2: Double,

    /**
     * Stabilizer Limit Output (smax).
     * Typical Value = 0.1.
     */
    val smax: Double,

    /**
     * Current transducer time constant (Tfi).
     * Typical Value = 0.
     */
    val tfi: Double,

    /**
     * Controller reset time constant (Tnu).
     * Typical Value = 2.
     */
    val tnu: Double,

    /**
     * Stabilizer Phase Lag Time Constant (Ts1).
     * Typical Value = 1.
     */
    val ts1: Double,

    /**
     * Stabilizer Filter Time Constant (Ts2).
     * Typical Value = 1.
     */
    val ts2: Double,

    /**
     * Stabilizer parameters (Tsw).
     * Typical Value = 3.
     */
    val tsw: Double,

    /**
     * Current controller gain (Vpi).
     * Typical Value = 12.45.
     */
    val vpi: Double,

    /**
     * Controller follow up gain (Vpnf).
     * Typical Value = 2.
     */
    val vpnf: Double,

    /**
     * Voltage controller proportional gain (Vpu).
     * Typical Value = 34.5.
     */
    val vpu: Double,

    /**
     * Excitation transformer effective reactance (Xe) (&gt;=0).
     * Xe represents the regulation of the transformer/rectifier unit.  Typical Value = 0.06.
     */
    val xe: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcELIN1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcELIN1
extends
    Parseable[ExcELIN1]
{
    val sup = ExcitationSystemDynamics.parse _
    val dpnf = parse_element (element ("""ExcELIN1.dpnf"""))_
    val efmax = parse_element (element ("""ExcELIN1.efmax"""))_
    val efmin = parse_element (element ("""ExcELIN1.efmin"""))_
    val ks1 = parse_element (element ("""ExcELIN1.ks1"""))_
    val ks2 = parse_element (element ("""ExcELIN1.ks2"""))_
    val smax = parse_element (element ("""ExcELIN1.smax"""))_
    val tfi = parse_element (element ("""ExcELIN1.tfi"""))_
    val tnu = parse_element (element ("""ExcELIN1.tnu"""))_
    val ts1 = parse_element (element ("""ExcELIN1.ts1"""))_
    val ts2 = parse_element (element ("""ExcELIN1.ts2"""))_
    val tsw = parse_element (element ("""ExcELIN1.tsw"""))_
    val vpi = parse_element (element ("""ExcELIN1.vpi"""))_
    val vpnf = parse_element (element ("""ExcELIN1.vpnf"""))_
    val vpu = parse_element (element ("""ExcELIN1.vpu"""))_
    val xe = parse_element (element ("""ExcELIN1.xe"""))_
    def parse (context: Context): ExcELIN1 =
    {
        ExcELIN1(
            sup (context),
            toDouble (dpnf (context), context),
            toDouble (efmax (context), context),
            toDouble (efmin (context), context),
            toDouble (ks1 (context), context),
            toDouble (ks2 (context), context),
            toDouble (smax (context), context),
            toDouble (tfi (context), context),
            toDouble (tnu (context), context),
            toDouble (ts1 (context), context),
            toDouble (ts2 (context), context),
            toDouble (tsw (context), context),
            toDouble (vpi (context), context),
            toDouble (vpnf (context), context),
            toDouble (vpu (context), context),
            toDouble (xe (context), context)
        )
    }
}

/**
 * Detailed Excitation System Model - ELIN (VATECH).
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  Power system stabilizer models used in conjunction with this excitation system model: PssELIN2, PssIEEE2B, Pss2B.
 */
case class ExcELIN2
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Gain (Efdbas).
     * Typical Value = 0.1.
     */
    val efdbas: Double,

    /**
     * Limiter (Iefmax).
     * Typical Value = 1.
     */
    val iefmax: Double,

    /**
     * Minimum open circuit excitation voltage (Iefmax2).
     * Typical Value = -5.
     */
    val iefmax2: Double,

    /**
     * Limiter (Iefmin).
     * Typical Value = 1.
     */
    val iefmin: Double,

    /**
     * Voltage regulator input gain (K1).
     * Typical Value = 0.
     */
    val k1: Double,

    /**
     * Voltage regulator input limit (K1ec).
     * Typical Value = 2.
     */
    val k1ec: Double,

    /**
     * Gain (K2).
     * Typical Value = 5.
     */
    val k2: Double,

    /**
     * Gain (K3).
     * Typical Value = 0.1.
     */
    val k3: Double,

    /**
     * Gain (K4).
     * Typical Value = 0.
     */
    val k4: Double,

    /**
     * Voltage controller derivative gain (Kd1).
     * Typical Value = 34.5.
     */
    val kd1: Double,

    /**
     * Gain (Ke2).
     * Typical Value = 0.1.
     */
    val ke2: Double,

    /**
     * Gain (Ketb).
     * Typical Value = 0.06.
     */
    val ketb: Double,

    /**
     * Controller follow up gain (PID1max).
     * Typical Value = 2.
     */
    val pid1max: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
     * Typical Value = 0.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
     * Typical Value = 1.
     */
    val seve2: Double,

    /**
     * Voltage controller derivative washout time constant (Tb1).
     * Typical Value = 12.45.
     */
    val tb1: Double,

    /**
     * Time constant (Te).
     * Typical Value = 0.
     */
    val te: Double,

    /**
     * Time Constant (Te2).
     * Typical Value = 1.
     */
    val te2: Double,

    /**
     * Controller follow up dead band (Ti1).
     * Typical Value = 0.
     */
    val ti1: Double,

    /**
     * Time constant (Ti3).
     * Typical Value = 3.
     */
    val ti3: Double,

    /**
     * Time constant (Ti4).
     * Typical Value = 0.
     */
    val ti4: Double,

    /**
     * Time constant (Tr4).
     * Typical Value = 1.
     */
    val tr4: Double,

    /**
     * Limiter (Upmax).
     * Typical Value = 3.
     */
    val upmax: Double,

    /**
     * Limiter (Upmin).
     * Typical Value = 0.
     */
    val upmin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1).
     * Typical Value = 3.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
     * Typical Value = 0.
     */
    val ve2: Double,

    /**
     * Excitation transformer effective reactance (Xp).
     * Typical Value = 1.
     */
    val xp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcELIN2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcELIN2
extends
    Parseable[ExcELIN2]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdbas = parse_element (element ("""ExcELIN2.efdbas"""))_
    val iefmax = parse_element (element ("""ExcELIN2.iefmax"""))_
    val iefmax2 = parse_element (element ("""ExcELIN2.iefmax2"""))_
    val iefmin = parse_element (element ("""ExcELIN2.iefmin"""))_
    val k1 = parse_element (element ("""ExcELIN2.k1"""))_
    val k1ec = parse_element (element ("""ExcELIN2.k1ec"""))_
    val k2 = parse_element (element ("""ExcELIN2.k2"""))_
    val k3 = parse_element (element ("""ExcELIN2.k3"""))_
    val k4 = parse_element (element ("""ExcELIN2.k4"""))_
    val kd1 = parse_element (element ("""ExcELIN2.kd1"""))_
    val ke2 = parse_element (element ("""ExcELIN2.ke2"""))_
    val ketb = parse_element (element ("""ExcELIN2.ketb"""))_
    val pid1max = parse_element (element ("""ExcELIN2.pid1max"""))_
    val seve1 = parse_element (element ("""ExcELIN2.seve1"""))_
    val seve2 = parse_element (element ("""ExcELIN2.seve2"""))_
    val tb1 = parse_element (element ("""ExcELIN2.tb1"""))_
    val te = parse_element (element ("""ExcELIN2.te"""))_
    val te2 = parse_element (element ("""ExcELIN2.te2"""))_
    val ti1 = parse_element (element ("""ExcELIN2.ti1"""))_
    val ti3 = parse_element (element ("""ExcELIN2.ti3"""))_
    val ti4 = parse_element (element ("""ExcELIN2.ti4"""))_
    val tr4 = parse_element (element ("""ExcELIN2.tr4"""))_
    val upmax = parse_element (element ("""ExcELIN2.upmax"""))_
    val upmin = parse_element (element ("""ExcELIN2.upmin"""))_
    val ve1 = parse_element (element ("""ExcELIN2.ve1"""))_
    val ve2 = parse_element (element ("""ExcELIN2.ve2"""))_
    val xp = parse_element (element ("""ExcELIN2.xp"""))_
    def parse (context: Context): ExcELIN2 =
    {
        ExcELIN2(
            sup (context),
            toDouble (efdbas (context), context),
            toDouble (iefmax (context), context),
            toDouble (iefmax2 (context), context),
            toDouble (iefmin (context), context),
            toDouble (k1 (context), context),
            toDouble (k1ec (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (kd1 (context), context),
            toDouble (ke2 (context), context),
            toDouble (ketb (context), context),
            toDouble (pid1max (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (tb1 (context), context),
            toDouble (te (context), context),
            toDouble (te2 (context), context),
            toDouble (ti1 (context), context),
            toDouble (ti3 (context), context),
            toDouble (ti4 (context), context),
            toDouble (tr4 (context), context),
            toDouble (upmax (context), context),
            toDouble (upmin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (xp (context), context)
        )
    }
}

/**
 * Hungarian Excitation System Model, with built-in voltage transducer.
 */
case class ExcHU
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Major loop PI tag gain factor (Ae).
     * Typical Value = 3.
     */
    val ae: Double,

    /**
     * Minor loop PI tag gain factor (Ai).
     * Typical Value = 22.
     */
    val ai: Double,

    /**
     * AVR constant (Atr).
     * Typical Value = 2.19.
     */
    val atr: Double,

    /**
     * Field voltage control signal upper limit on AVR base (Emax).
     * Typical Value = 0.996.
     */
    val emax: Double,

    /**
     * Field voltage control signal lower limit on AVR base (Emin).
     * Typical Value = -0.866.
     */
    val emin: Double,

    /**
     * Major loop PI tag output signal upper limit (Imax).
     * Typical Value = 2.19.
     */
    val imax: Double,

    /**
     * Major loop PI tag output signal lower limit (Imin).
     * Typical Value = 0.1.
     */
    val imin: Double,

    /**
     * Voltage base conversion constant (Ke).
     * Typical Value = 4.666.
     */
    val ke: Double,

    /**
     * Current base conversion constant (Ki).
     * Typical Value = 0.21428.
     */
    val ki: Double,

    /**
     * Major loop PI tag integration time constant (Te).
     * Typical Value = 0.154.
     */
    val te: Double,

    /**
     * Minor loop PI control tag integration time constant (Ti).
     * Typical Value = 0.01333.
     */
    val ti: Double,

    /**
     * Filter time constant (Tr).
     * If a voltage compensator is used in conjunction with this excitation system model, Tr should be set to 0.  Typical Value = 0.01.
     */
    val tr: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcHU]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcHU
extends
    Parseable[ExcHU]
{
    val sup = ExcitationSystemDynamics.parse _
    val ae = parse_element (element ("""ExcHU.ae"""))_
    val ai = parse_element (element ("""ExcHU.ai"""))_
    val atr = parse_element (element ("""ExcHU.atr"""))_
    val emax = parse_element (element ("""ExcHU.emax"""))_
    val emin = parse_element (element ("""ExcHU.emin"""))_
    val imax = parse_element (element ("""ExcHU.imax"""))_
    val imin = parse_element (element ("""ExcHU.imin"""))_
    val ke = parse_element (element ("""ExcHU.ke"""))_
    val ki = parse_element (element ("""ExcHU.ki"""))_
    val te = parse_element (element ("""ExcHU.te"""))_
    val ti = parse_element (element ("""ExcHU.ti"""))_
    val tr = parse_element (element ("""ExcHU.tr"""))_
    def parse (context: Context): ExcHU =
    {
        ExcHU(
            sup (context),
            toDouble (ae (context), context),
            toDouble (ai (context), context),
            toDouble (atr (context), context),
            toDouble (emax (context), context),
            toDouble (emin (context), context),
            toDouble (imax (context), context),
            toDouble (imin (context), context),
            toDouble (ke (context), context),
            toDouble (ki (context), context),
            toDouble (te (context), context),
            toDouble (ti (context), context),
            toDouble (tr (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC1A model.
 * The model represents the field-controlled alternator-rectifier excitation systems designated Type AC1A. These excitation systems consist of an alternator main exciter with non-controlled rectifiers.
 */
case class ExcIEEEAC1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.2.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 0.38.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 0.1.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 0.03.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.8.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 14.5.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -14.5.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>).
     * Typical Value = 4.18.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 3.14.
     */
    val ve2: Double,

    /**
     * Maximum voltage regulator outputs (V<sub>RMAX</sub>).
     * Typical Value = 6.03.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (V<sub>RMIN</sub>).
     * Typical Value = -5.43.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC1A
extends
    Parseable[ExcIEEEAC1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEAC1A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEAC1A.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC1A.kd"""))_
    val ke = parse_element (element ("""ExcIEEEAC1A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEAC1A.kf"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC1A.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC1A.seve2"""))_
    val ta = parse_element (element ("""ExcIEEEAC1A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEAC1A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEAC1A.tc"""))_
    val te = parse_element (element ("""ExcIEEEAC1A.te"""))_
    val tf = parse_element (element ("""ExcIEEEAC1A.tf"""))_
    val vamax = parse_element (element ("""ExcIEEEAC1A.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEAC1A.vamin"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC1A.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC1A.ve2"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC1A.vrmin"""))_
    def parse (context: Context): ExcIEEEAC1A =
    {
        ExcIEEEAC1A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC2A model.
 * The model represents a high initial response field-controlled alternator-rectifier excitation system. The alternator main exciter is used with non-controlled rectifiers. The Type AC2A model is similar to that of Type AC1A except for the inclusion of exciter time constant compensation and exciter field current limiting elements.
 */
case class ExcIEEEAC2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Second stage regulator gain (K<sub>B</sub>).
     * Typical Value = 25.
     */
    val kb: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.28.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 0.35.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Exciter field current feedback gain (K<sub>H</sub>).
     * Typical Value = 1.
     */
    val kh: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 0.037.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 0.012.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.6.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 8.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -8.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>).
     * Typical Value = 4.4.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 3.3.
     */
    val ve2: Double,

    /**
     * Exciter field current limit reference (V<sub>FEMAX</sub>).
     * Typical Value = 4.4.
     */
    val vfemax: Double,

    /**
     * Maximum voltage regulator outputs (V<sub>RMAX</sub>).
     * Typical Value = 105.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (V<sub>RMIN</sub>).
     * Typical Value = -95.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC2A
extends
    Parseable[ExcIEEEAC2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEAC2A.ka"""))_
    val kb = parse_element (element ("""ExcIEEEAC2A.kb"""))_
    val kc = parse_element (element ("""ExcIEEEAC2A.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC2A.kd"""))_
    val ke = parse_element (element ("""ExcIEEEAC2A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEAC2A.kf"""))_
    val kh = parse_element (element ("""ExcIEEEAC2A.kh"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC2A.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC2A.seve2"""))_
    val ta = parse_element (element ("""ExcIEEEAC2A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEAC2A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEAC2A.tc"""))_
    val te = parse_element (element ("""ExcIEEEAC2A.te"""))_
    val tf = parse_element (element ("""ExcIEEEAC2A.tf"""))_
    val vamax = parse_element (element ("""ExcIEEEAC2A.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEAC2A.vamin"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC2A.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC2A.ve2"""))_
    val vfemax = parse_element (element ("""ExcIEEEAC2A.vfemax"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC2A.vrmin"""))_
    def parse (context: Context): ExcIEEEAC2A =
    {
        ExcIEEEAC2A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kb (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (kh (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vfemax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC3A model.
 * The model represents the field-controlled alternator-rectifier excitation systems designated Type AC3A. These excitation systems include an alternator main exciter with non-controlled rectifiers. The exciter employs self-excitation, and the voltage regulator power is derived from the exciter output voltage.  Therefore, this system has an additional nonlinearity, simulated by the use of a multiplier
 */
case class ExcIEEEAC3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Value of <i>EFD </i>at which feedback gain changes (E<sub>FDN</sub>).
     * Typical Value = 2.36.
     */
    val efdn: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 45.62.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.104.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 0.499.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.143.
     */
    val kf: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>N</sub>).
     * Typical Value = 0.05.
     */
    val kn: Double,

    /**
     * Constant associated with regulator and alternator field power supply (K<sub>R</sub>).
     * Typical Value = 3.77.
     */
    val kr: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 1.143.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 0.1.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.013.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 1.17.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 1.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -0.95.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX </sub>(V<sub>E1</sub>).
     * Typical Value = 6.24.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 4.68.
     */
    val ve2: Double,

    /**
     * Minimum exciter voltage output (V<sub>EMIN</sub>).
     * Typical Value = 0.1.
     */
    val vemin: Double,

    /**
     * Exciter field current limit reference (V<sub>FEMAX</sub>).
     * Typical Value = 16.
     */
    val vfemax: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC3A
extends
    Parseable[ExcIEEEAC3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdn = parse_element (element ("""ExcIEEEAC3A.efdn"""))_
    val ka = parse_element (element ("""ExcIEEEAC3A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEAC3A.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC3A.kd"""))_
    val ke = parse_element (element ("""ExcIEEEAC3A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEAC3A.kf"""))_
    val kn = parse_element (element ("""ExcIEEEAC3A.kn"""))_
    val kr = parse_element (element ("""ExcIEEEAC3A.kr"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC3A.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC3A.seve2"""))_
    val ta = parse_element (element ("""ExcIEEEAC3A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEAC3A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEAC3A.tc"""))_
    val te = parse_element (element ("""ExcIEEEAC3A.te"""))_
    val tf = parse_element (element ("""ExcIEEEAC3A.tf"""))_
    val vamax = parse_element (element ("""ExcIEEEAC3A.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEAC3A.vamin"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC3A.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC3A.ve2"""))_
    val vemin = parse_element (element ("""ExcIEEEAC3A.vemin"""))_
    val vfemax = parse_element (element ("""ExcIEEEAC3A.vfemax"""))_
    def parse (context: Context): ExcIEEEAC3A =
    {
        ExcIEEEAC3A(
            sup (context),
            toDouble (efdn (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (kn (context), context),
            toDouble (kr (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vemin (context), context),
            toDouble (vfemax (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC4A model.
 * The model represents type AC4A alternator-supplied controlled-rectifier excitation system which is quite different from the other type ac systems. This high initial response excitation system utilizes a full thyristor bridge in the exciter output circuit.  The voltage regulator controls the firing of the thyristor bridges. The exciter alternator uses an independent voltage regulator to control its output voltage to a constant value. These effects are not modeled; however, transient loading effects on the exciter alternator are included.
 */
case class ExcIEEEAC4A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 200.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.
     */
    val kc: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.015.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Maximum voltage regulator input limit (V<sub>IMAX</sub>).
     * Typical Value = 10.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (V<sub>IMIN</sub>).
     * Typical Value = -10.
     */
    val vimin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 5.64.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -4.53.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC4A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC4A
extends
    Parseable[ExcIEEEAC4A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEAC4A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEAC4A.kc"""))_
    val ta = parse_element (element ("""ExcIEEEAC4A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEAC4A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEAC4A.tc"""))_
    val vimax = parse_element (element ("""ExcIEEEAC4A.vimax"""))_
    val vimin = parse_element (element ("""ExcIEEEAC4A.vimin"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC4A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC4A.vrmin"""))_
    def parse (context: Context): ExcIEEEAC4A =
    {
        ExcIEEEAC4A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC5A model.
 * The model represents a simplified model for brushless excitation systems. The regulator is supplied from a source, such as a permanent magnet generator, which is not affected by system disturbances.  Unlike other ac models, this model uses loaded rather than open circuit exciter saturation data in the same way as it is used for the dc models.  Because the model has been widely implemented by the industry, it is sometimes used to represent other types of systems when either detailed data for them are not available or simplified models are required.
 */
case class ExcIEEEAC5A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
     * Typical Value = 5.6.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
     * Typical Value = 4.2.
     */
    val efd2: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 400.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.03.
     */
    val kf: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
     * Typical Value = 0.86.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
     * Typical Value = 0.5.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.8.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F1</sub>).
     * Typical Value = 1.
     */
    val tf1: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F2</sub>).
     * Typical Value = 1.
     */
    val tf2: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F3</sub>).
     * Typical Value = 1.
     */
    val tf3: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 7.3.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -7.3.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC5A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC5A
extends
    Parseable[ExcIEEEAC5A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcIEEEAC5A.efd1"""))_
    val efd2 = parse_element (element ("""ExcIEEEAC5A.efd2"""))_
    val ka = parse_element (element ("""ExcIEEEAC5A.ka"""))_
    val ke = parse_element (element ("""ExcIEEEAC5A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEAC5A.kf"""))_
    val seefd1 = parse_element (element ("""ExcIEEEAC5A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcIEEEAC5A.seefd2"""))_
    val ta = parse_element (element ("""ExcIEEEAC5A.ta"""))_
    val te = parse_element (element ("""ExcIEEEAC5A.te"""))_
    val tf1 = parse_element (element ("""ExcIEEEAC5A.tf1"""))_
    val tf2 = parse_element (element ("""ExcIEEEAC5A.tf2"""))_
    val tf3 = parse_element (element ("""ExcIEEEAC5A.tf3"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC5A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC5A.vrmin"""))_
    def parse (context: Context): ExcIEEEAC5A =
    {
        ExcIEEEAC5A(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (te (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (tf3 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC6A model.
 * The model represents field-controlled alternator-rectifier excitation systems with system-supplied electronic voltage regulators.  The maximum output of the regulator, <b><i>V</i></b><b><i><sub>R</sub></i></b>, is a function of terminal voltage, <b><i>V</i></b><b><i><sub>T</sub></i></b>. The field current limiter included in the original model AC6A remains in the 2005 update.
 */
case class ExcIEEEAC6A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 536.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.173.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 1.91.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.6.
     */
    val ke: Double,

    /**
     * Exciter field current limiter gain (K<sub>H</sub>).
     * Typical Value = 92.
     */
    val kh: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 0.214.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 0.044.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.086.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 9.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 3.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 1.
     */
    val te: Double,

    /**
     * Exciter field current limiter time constant (T<sub>H</sub>).
     * Typical Value = 0.08.
     */
    val th: Double,

    /**
     * Exciter field current limiter time constant (T<sub>J</sub>).
     * Typical Value = 0.02.
     */
    val tj: Double,

    /**
     * Voltage regulator time constant (T<sub>K</sub>).
     * Typical Value = 0.18.
     */
    val tk: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 75.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -75.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX </sub>(V<sub>E1</sub>).
     * Typical Value = 7.4.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 5.55.
     */
    val ve2: Double,

    /**
     * Exciter field current limit reference (V<sub>FELIM</sub>).
     * Typical Value = 19.
     */
    val vfelim: Double,

    /**
     * Maximum field current limiter signal reference (V<sub>HMAX</sub>).
     * Typical Value = 75.
     */
    val vhmax: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 44.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -36.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC6A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC6A
extends
    Parseable[ExcIEEEAC6A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEAC6A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEAC6A.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC6A.kd"""))_
    val ke = parse_element (element ("""ExcIEEEAC6A.ke"""))_
    val kh = parse_element (element ("""ExcIEEEAC6A.kh"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC6A.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC6A.seve2"""))_
    val ta = parse_element (element ("""ExcIEEEAC6A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEAC6A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEAC6A.tc"""))_
    val te = parse_element (element ("""ExcIEEEAC6A.te"""))_
    val th = parse_element (element ("""ExcIEEEAC6A.th"""))_
    val tj = parse_element (element ("""ExcIEEEAC6A.tj"""))_
    val tk = parse_element (element ("""ExcIEEEAC6A.tk"""))_
    val vamax = parse_element (element ("""ExcIEEEAC6A.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEAC6A.vamin"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC6A.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC6A.ve2"""))_
    val vfelim = parse_element (element ("""ExcIEEEAC6A.vfelim"""))_
    val vhmax = parse_element (element ("""ExcIEEEAC6A.vhmax"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC6A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC6A.vrmin"""))_
    def parse (context: Context): ExcIEEEAC6A =
    {
        ExcIEEEAC6A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kh (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (th (context), context),
            toDouble (tj (context), context),
            toDouble (tk (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vfelim (context), context),
            toDouble (vhmax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC7B model.
 * The model represents excitation systems which consist of an ac alternator with either stationary or rotating rectifiers to produce the dc field requirements. It is an upgrade to earlier ac excitation systems, which replace only the controls but retain the ac alternator and diode rectifier bridge.
 */
case class ExcIEEEAC7B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.18.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 0.02.
     */
    val kd: Double,

    /**
     * Voltage regulator derivative gain (K<sub>DR</sub>).
     * Typical Value = 0.
     */
    val kdr: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F1</sub>).
     * Typical Value = 0.212.
     */
    val kf1: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F2</sub>).
     * Typical Value = 0.
     */
    val kf2: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F3</sub>).
     * Typical Value = 0.
     */
    val kf3: Double,

    /**
     * Voltage regulator integral gain (K<sub>IA</sub>).
     * Typical Value = 59.69.
     */
    val kia: Double,

    /**
     * Voltage regulator integral gain (K<sub>IR</sub>).
     * Typical Value = 4.24.
     */
    val kir: Double,

    /**
     * Exciter field voltage lower limit parameter (K<sub>L</sub>).
     * Typical Value = 10.
     */
    val kl: Double,

    /**
     * Potential circuit gain coefficient (K<sub>P</sub>).
     * Typical Value = 4.96.
     */
    val kp: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PA</sub>).
     * Typical Value = 65.36.
     */
    val kpa: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PR</sub>).
     * Typical Value = 4.24.
     */
    val kpr: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 0.44.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 0.075.
     */
    val seve2: Double,

    /**
     * Lag time constant (T<sub>DR</sub>).
     * Typical Value = 0.
     */
    val tdr: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 1.1.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 1.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -0.95.
     */
    val vamin: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX</sub> (V<sub>E1</sub>).
     * Typical Value = 6.3.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 3.02.
     */
    val ve2: Double,

    /**
     * Minimum exciter voltage output (V<sub>EMIN</sub>).
     * Typical Value = 0.
     */
    val vemin: Double,

    /**
     * Exciter field current limit reference (V<sub>FEMAX</sub>).
     * Typical Value = 6.9.
     */
    val vfemax: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 5.79.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -5.79.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC7B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC7B
extends
    Parseable[ExcIEEEAC7B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kc = parse_element (element ("""ExcIEEEAC7B.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC7B.kd"""))_
    val kdr = parse_element (element ("""ExcIEEEAC7B.kdr"""))_
    val ke = parse_element (element ("""ExcIEEEAC7B.ke"""))_
    val kf1 = parse_element (element ("""ExcIEEEAC7B.kf1"""))_
    val kf2 = parse_element (element ("""ExcIEEEAC7B.kf2"""))_
    val kf3 = parse_element (element ("""ExcIEEEAC7B.kf3"""))_
    val kia = parse_element (element ("""ExcIEEEAC7B.kia"""))_
    val kir = parse_element (element ("""ExcIEEEAC7B.kir"""))_
    val kl = parse_element (element ("""ExcIEEEAC7B.kl"""))_
    val kp = parse_element (element ("""ExcIEEEAC7B.kp"""))_
    val kpa = parse_element (element ("""ExcIEEEAC7B.kpa"""))_
    val kpr = parse_element (element ("""ExcIEEEAC7B.kpr"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC7B.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC7B.seve2"""))_
    val tdr = parse_element (element ("""ExcIEEEAC7B.tdr"""))_
    val te = parse_element (element ("""ExcIEEEAC7B.te"""))_
    val tf = parse_element (element ("""ExcIEEEAC7B.tf"""))_
    val vamax = parse_element (element ("""ExcIEEEAC7B.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEAC7B.vamin"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC7B.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC7B.ve2"""))_
    val vemin = parse_element (element ("""ExcIEEEAC7B.vemin"""))_
    val vfemax = parse_element (element ("""ExcIEEEAC7B.vfemax"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC7B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC7B.vrmin"""))_
    def parse (context: Context): ExcIEEEAC7B =
    {
        ExcIEEEAC7B(
            sup (context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (kdr (context), context),
            toDouble (ke (context), context),
            toDouble (kf1 (context), context),
            toDouble (kf2 (context), context),
            toDouble (kf3 (context), context),
            toDouble (kia (context), context),
            toDouble (kir (context), context),
            toDouble (kl (context), context),
            toDouble (kp (context), context),
            toDouble (kpa (context), context),
            toDouble (kpr (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (tdr (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vemin (context), context),
            toDouble (vfemax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC8B model.
 * This model represents a PID voltage regulator with either a brushless exciter or dc exciter. The AVR in this model consists of PID control, with separate constants for the proportional (<b>K</b><b><sub>PR</sub></b>), integral (<b>K</b><b><sub>IR</sub></b>), and derivative (<b>K</b><b><sub>DR</sub></b>) gains. The representation of the brushless exciter (<b>T</b><b><sub>E</sub></b>, <b>K</b><b><sub>E</sub></b>, <b>S</b><b><sub>E</sub></b>, <b>K</b><b><sub>C</sub></b>, <b>K</b><b><sub>D</sub></b>) is similar to the model Type AC2A. The Type AC8B model can be used to represent static voltage regulators applied to brushless excitation systems. Digitally based voltage regulators feeding dc rotating main exciters can be represented with the AC Type AC8B model with the parameters <b>K</b><b><sub>C</sub></b> and <b>K</b><b><sub>D</sub></b> set to 0.  For thyristor power stages fed from the generator terminals, the limits <b>V</b><b><sub>RMAX</sub></b> and <b>V</b><b><sub>RMIN</sub></b> should be a function of terminal voltage: <b>V</b><b><sub>T</sub></b> * <b>V</b><b><sub>RMAX</sub></b><sub> </sub>and <b>V</b><b><sub>T</sub></b> * <b>V</b><b><sub>RMIN</sub></b>.
 */
case class ExcIEEEAC8B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 1.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.55.
     */
    val kc: Double,

    /**
     * Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
     * Typical Value = 1.1.
     */
    val kd: Double,

    /**
     * Voltage regulator derivative gain (K<sub>DR</sub>).
     * Typical Value = 10.
     */
    val kdr: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Voltage regulator integral gain (K<sub>IR</sub>).
     * Typical Value = 5.
     */
    val kir: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PR</sub>).
     * Typical Value = 80.
     */
    val kpr: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
     * Typical Value = 0.3.
     */
    val seve1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
     * Typical Value = 3.
     */
    val seve2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Lag time constant (T<sub>DR</sub>).
     * Typical Value = 0.1.
     */
    val tdr: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 1.2.
     */
    val te: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX</sub> (V<sub>E1</sub>).
     * Typical Value = 6.5.
     */
    val ve1: Double,

    /**
     * Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
     * Typical Value = 9.
     */
    val ve2: Double,

    /**
     * Minimum exciter voltage output (V<sub>EMIN</sub>).
     * Typical Value = 0.
     */
    val vemin: Double,

    /**
     * Exciter field current limit reference (V<sub>FEMAX</sub>).
     * Typical Value = 6.
     */
    val vfemax: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 35.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = 0.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEAC8B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEAC8B
extends
    Parseable[ExcIEEEAC8B]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEAC8B.ka"""))_
    val kc = parse_element (element ("""ExcIEEEAC8B.kc"""))_
    val kd = parse_element (element ("""ExcIEEEAC8B.kd"""))_
    val kdr = parse_element (element ("""ExcIEEEAC8B.kdr"""))_
    val ke = parse_element (element ("""ExcIEEEAC8B.ke"""))_
    val kir = parse_element (element ("""ExcIEEEAC8B.kir"""))_
    val kpr = parse_element (element ("""ExcIEEEAC8B.kpr"""))_
    val seve1 = parse_element (element ("""ExcIEEEAC8B.seve1"""))_
    val seve2 = parse_element (element ("""ExcIEEEAC8B.seve2"""))_
    val ta = parse_element (element ("""ExcIEEEAC8B.ta"""))_
    val tdr = parse_element (element ("""ExcIEEEAC8B.tdr"""))_
    val te = parse_element (element ("""ExcIEEEAC8B.te"""))_
    val ve1 = parse_element (element ("""ExcIEEEAC8B.ve1"""))_
    val ve2 = parse_element (element ("""ExcIEEEAC8B.ve2"""))_
    val vemin = parse_element (element ("""ExcIEEEAC8B.vemin"""))_
    val vfemax = parse_element (element ("""ExcIEEEAC8B.vfemax"""))_
    val vrmax = parse_element (element ("""ExcIEEEAC8B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEAC8B.vrmin"""))_
    def parse (context: Context): ExcIEEEAC8B =
    {
        ExcIEEEAC8B(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (kdr (context), context),
            toDouble (ke (context), context),
            toDouble (kir (context), context),
            toDouble (kpr (context), context),
            toDouble (seve1 (context), context),
            toDouble (seve2 (context), context),
            toDouble (ta (context), context),
            toDouble (tdr (context), context),
            toDouble (te (context), context),
            toDouble (ve1 (context), context),
            toDouble (ve2 (context), context),
            toDouble (vemin (context), context),
            toDouble (vfemax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC1A model.
 * This model represents field-controlled dc commutator exciters with continuously acting voltage regulators (especially the direct-acting rheostatic, rotating amplifier, and magnetic amplifier types).  Because this model has been widely implemented by the industry, it is sometimes used to represent other types of systems when detailed data for them are not available or when a simplified model is required.
 */
case class ExcIEEEDC1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
     * Typical Value = 3.1.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
     * Typical Value = 2.3.
     */
    val efd2: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output.
     */
    val exclim: Boolean,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 46.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 0.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F</sub>).
     * Typical Value = 0.1.
     */
    val kf: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
     * Typical Value = 0.33.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
     * Typical Value = 0.1.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.06.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.46.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * UEL input (uelin).
    true = input is connected to the HV gate
    false = input connects to the error signal.
     * Typical Value = true.
     */
    val uelin: Boolean,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -0.9.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEDC1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEDC1A
extends
    Parseable[ExcIEEEDC1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcIEEEDC1A.efd1"""))_
    val efd2 = parse_element (element ("""ExcIEEEDC1A.efd2"""))_
    val exclim = parse_element (element ("""ExcIEEEDC1A.exclim"""))_
    val ka = parse_element (element ("""ExcIEEEDC1A.ka"""))_
    val ke = parse_element (element ("""ExcIEEEDC1A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEDC1A.kf"""))_
    val seefd1 = parse_element (element ("""ExcIEEEDC1A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcIEEEDC1A.seefd2"""))_
    val ta = parse_element (element ("""ExcIEEEDC1A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEDC1A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEDC1A.tc"""))_
    val te = parse_element (element ("""ExcIEEEDC1A.te"""))_
    val tf = parse_element (element ("""ExcIEEEDC1A.tf"""))_
    val uelin = parse_element (element ("""ExcIEEEDC1A.uelin"""))_
    val vrmax = parse_element (element ("""ExcIEEEDC1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEDC1A.vrmin"""))_
    def parse (context: Context): ExcIEEEDC1A =
    {
        ExcIEEEDC1A(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toBoolean (exclim (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toBoolean (uelin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC2A model.
 * This model represents represent field-controlled dc commutator exciters with continuously acting voltage regulators having supplies obtained from the generator or auxiliary bus.  It differs from the Type DC1A model only in the voltage regulator output limits, which are now proportional to terminal voltage <b>V</b><b><sub>T</sub></b>.
 */
case class ExcIEEEDC2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
     * Typical Value = 3.05.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
     * Typical Value = 2.29.
     */
    val efd2: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output. Typical Value = - 999  which means that there is no limit applied.
     */
    val exclim: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 300.
     */
    val ka: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F</sub>).
     * Typical Value = 0.1.
     */
    val kf: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
     * Typical Value = 0.279.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
     * Typical Value = 0.117.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.01.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 1.33.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 0.675.
     */
    val tf: Double,

    /**
     * UEL input (uelin).
    true = input is connected to the HV gate
    false = input connects to the error signal.
     * Typical Value = true.
     */
    val uelin: Boolean,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 4.95.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -4.9.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEDC2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEDC2A
extends
    Parseable[ExcIEEEDC2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcIEEEDC2A.efd1"""))_
    val efd2 = parse_element (element ("""ExcIEEEDC2A.efd2"""))_
    val exclim = parse_element (element ("""ExcIEEEDC2A.exclim"""))_
    val ka = parse_element (element ("""ExcIEEEDC2A.ka"""))_
    val ke = parse_element (element ("""ExcIEEEDC2A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEDC2A.kf"""))_
    val seefd1 = parse_element (element ("""ExcIEEEDC2A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcIEEEDC2A.seefd2"""))_
    val ta = parse_element (element ("""ExcIEEEDC2A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEDC2A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEDC2A.tc"""))_
    val te = parse_element (element ("""ExcIEEEDC2A.te"""))_
    val tf = parse_element (element ("""ExcIEEEDC2A.tf"""))_
    val uelin = parse_element (element ("""ExcIEEEDC2A.uelin"""))_
    val vrmax = parse_element (element ("""ExcIEEEDC2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEDC2A.vrmin"""))_
    def parse (context: Context): ExcIEEEDC2A =
    {
        ExcIEEEDC2A(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (exclim (context), context),
            toDouble (ka (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toBoolean (uelin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC3A model.
 * This model represents represent older systems, in particular those dc commutator exciters with non-continuously acting regulators that were commonly used before the development of the continuously acting varieties.  These systems respond at basically two different rates, depending upon the magnitude of voltage error. For small errors, adjustment is made periodically with a signal to a motor-operated rheostat. Larger errors cause resistors to be quickly shorted or inserted and a strong forcing signal applied to the exciter. Continuous motion of the motor-operated rheostat occurs for these larger error signals, even though it is bypassed by contactor action.
 */
case class ExcIEEEDC3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
     * Typical Value = 3.375.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
     * Typical Value = 3.15.
     */
    val efd2: Double,

    /**
     * (exclim).
     * IEEE standard is ambiguous about lower limit on exciter output.
     */
    val exclim: Boolean,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 0.05.
     */
    val ke: Double,

    /**
     * Fast raise/lower contact setting (K<sub>V</sub>).
     * Typical Value = 0.05.
     */
    val kv: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
     * Typical Value = 0.267.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
     * Typical Value = 0.068.
     */
    val seefd2: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.5.
     */
    val te: Double,

    /**
     * Rheostat travel time (T<sub>RH</sub>).
     * Typical Value = 20.
     */
    val trh: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = 0.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEDC3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEDC3A
extends
    Parseable[ExcIEEEDC3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcIEEEDC3A.efd1"""))_
    val efd2 = parse_element (element ("""ExcIEEEDC3A.efd2"""))_
    val exclim = parse_element (element ("""ExcIEEEDC3A.exclim"""))_
    val ke = parse_element (element ("""ExcIEEEDC3A.ke"""))_
    val kv = parse_element (element ("""ExcIEEEDC3A.kv"""))_
    val seefd1 = parse_element (element ("""ExcIEEEDC3A.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcIEEEDC3A.seefd2"""))_
    val te = parse_element (element ("""ExcIEEEDC3A.te"""))_
    val trh = parse_element (element ("""ExcIEEEDC3A.trh"""))_
    val vrmax = parse_element (element ("""ExcIEEEDC3A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEDC3A.vrmin"""))_
    def parse (context: Context): ExcIEEEDC3A =
    {
        ExcIEEEDC3A(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toBoolean (exclim (context), context),
            toDouble (ke (context), context),
            toDouble (kv (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (te (context), context),
            toDouble (trh (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC4B model.
 * These excitation systems utilize a field-controlled dc commutator exciter with a continuously acting voltage regulator having supplies obtained from the generator or auxiliary bus.
 */
case class ExcIEEEDC4B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
     * Typical Value = 1.75.
     */
    val efd1: Double,

    /**
     * Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
     * Typical Value = 2.33.
     */
    val efd2: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 1.
     */
    val ka: Double,

    /**
     * Regulator derivative gain (K<sub>D</sub>).
     * Typical Value = 20.
     */
    val kd: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gain (K<sub>F</sub>).
     * Typical Value = 0.
     */
    val kf: Double,

    /**
     * Regulator integral gain (K<sub>I</sub>).
     * Typical Value = 20.
     */
    val ki: Double,

    /**
     * Regulator proportional gain (K<sub>P</sub>).
     * Typical Value = 20.
     */
    val kp: Double,

    /**
     * OEL input (OELin).
    true = LV gate
    false = subtract from error signal.
     * Typical Value = true.
     */
    val oelin: Boolean,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
     * Typical Value = 0.08.
     */
    val seefd1: Double,

    /**
     * Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
     * Typical Value = 0.27.
     */
    val seefd2: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.2.
     */
    val ta: Double,

    /**
     * Regulator derivative filter time constant(T<sub>D</sub>).
     * Typical Value = 0.01.
     */
    val td: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.8.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * UEL input (UELin).
    true = HV gate
    false = add to error signal.
     * Typical Value = true.
     */
    val uelin: Boolean,

    /**
     * Minimum exciter voltage output(V<sub>EMIN</sub>).
     * Typical Value = 0.
     */
    val vemin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 2.7.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -0.9.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEDC4B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEDC4B
extends
    Parseable[ExcIEEEDC4B]
{
    val sup = ExcitationSystemDynamics.parse _
    val efd1 = parse_element (element ("""ExcIEEEDC4B.efd1"""))_
    val efd2 = parse_element (element ("""ExcIEEEDC4B.efd2"""))_
    val ka = parse_element (element ("""ExcIEEEDC4B.ka"""))_
    val kd = parse_element (element ("""ExcIEEEDC4B.kd"""))_
    val ke = parse_element (element ("""ExcIEEEDC4B.ke"""))_
    val kf = parse_element (element ("""ExcIEEEDC4B.kf"""))_
    val ki = parse_element (element ("""ExcIEEEDC4B.ki"""))_
    val kp = parse_element (element ("""ExcIEEEDC4B.kp"""))_
    val oelin = parse_element (element ("""ExcIEEEDC4B.oelin"""))_
    val seefd1 = parse_element (element ("""ExcIEEEDC4B.seefd1"""))_
    val seefd2 = parse_element (element ("""ExcIEEEDC4B.seefd2"""))_
    val ta = parse_element (element ("""ExcIEEEDC4B.ta"""))_
    val td = parse_element (element ("""ExcIEEEDC4B.td"""))_
    val te = parse_element (element ("""ExcIEEEDC4B.te"""))_
    val tf = parse_element (element ("""ExcIEEEDC4B.tf"""))_
    val uelin = parse_element (element ("""ExcIEEEDC4B.uelin"""))_
    val vemin = parse_element (element ("""ExcIEEEDC4B.vemin"""))_
    val vrmax = parse_element (element ("""ExcIEEEDC4B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEDC4B.vrmin"""))_
    def parse (context: Context): ExcIEEEDC4B =
    {
        ExcIEEEDC4B(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (ka (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toBoolean (oelin (context), context),
            toDouble (seefd1 (context), context),
            toDouble (seefd2 (context), context),
            toDouble (ta (context), context),
            toDouble (td (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toBoolean (uelin (context), context),
            toDouble (vemin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST1A model.
 * This model represents systems in which excitation power is supplied through a transformer from the generator terminals (or the unit�s auxiliary bus) and is regulated by a controlled rectifier.  The maximum exciter voltage available from such systems is directly related to the generator terminal voltage.
 */
case class ExcIEEEST1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter output current limit reference (I<sub>LR</sub>).
     * Typical Value = 0.
     */
    val ilr: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 190.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.08.
     */
    val kc: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.
     */
    val kf: Double,

    /**
     * Exciter output current limiter gain (K<sub>LR</sub>).
     * Typical Value = 0.
     */
    val klr: Double,

    /**
     * Selector of the Power System Stabilizer (PSS) input (PSSin).
    true = PSS input (Vs) added to error signal
    false = PSS input (Vs) added to voltage regulator output.
     * Typical Value = true.
     */
    val pssin: Boolean,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>B1</sub>).
     * Typical Value = 0.
     */
    val tb1: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Voltage regulator time constant (T<sub>C1</sub>).
     * Typical Value = 0.
     */
    val tc1: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Selector of the connection of the UEL input (UELin).
     * Typical Value = ignoreUELsignal.
     */
    val uelin: String,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 14.5.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -14.5.
     */
    val vamin: Double,

    /**
     * Maximum voltage regulator input limit (V<sub>IMAX</sub>).
     * Typical Value = 999.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (V<sub>IMIN</sub>).
     * Typical Value = -999.
     */
    val vimin: Double,

    /**
     * Maximum voltage regulator outputs (V<sub>RMAX</sub>).
     * Typical Value = 7.8.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (V<sub>RMIN</sub>).
     * Typical Value = -6.7.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST1A
extends
    Parseable[ExcIEEEST1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ilr = parse_element (element ("""ExcIEEEST1A.ilr"""))_
    val ka = parse_element (element ("""ExcIEEEST1A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEST1A.kc"""))_
    val kf = parse_element (element ("""ExcIEEEST1A.kf"""))_
    val klr = parse_element (element ("""ExcIEEEST1A.klr"""))_
    val pssin = parse_element (element ("""ExcIEEEST1A.pssin"""))_
    val ta = parse_element (element ("""ExcIEEEST1A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEST1A.tb"""))_
    val tb1 = parse_element (element ("""ExcIEEEST1A.tb1"""))_
    val tc = parse_element (element ("""ExcIEEEST1A.tc"""))_
    val tc1 = parse_element (element ("""ExcIEEEST1A.tc1"""))_
    val tf = parse_element (element ("""ExcIEEEST1A.tf"""))_
    val uelin = parse_attribute (attribute ("""ExcIEEEST1A.uelin"""))_
    val vamax = parse_element (element ("""ExcIEEEST1A.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEST1A.vamin"""))_
    val vimax = parse_element (element ("""ExcIEEEST1A.vimax"""))_
    val vimin = parse_element (element ("""ExcIEEEST1A.vimin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST1A.vrmin"""))_
    def parse (context: Context): ExcIEEEST1A =
    {
        ExcIEEEST1A(
            sup (context),
            toDouble (ilr (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kf (context), context),
            toDouble (klr (context), context),
            toBoolean (pssin (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tb1 (context), context),
            toDouble (tc (context), context),
            toDouble (tc1 (context), context),
            toDouble (tf (context), context),
            uelin (context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Type of connection for the UEL input used in ExcIEEEST1A.
 */
case class ExcIEEEST1AUELselectorKind
(

    override val sup: BasicElement,

    /**
     * Ignore UEL signal.
     */
    val ignoreUELsignal: String,

    /**
     * UEL input added to error signal.
     */
    val inputAddedToErrorSignal: String,

    /**
     * UEL input HV gate with error signal.
     */
    val inputHVgateErrorSignal: String,

    /**
     * UEL input HV gate with voltage regulator output.
     */
    val inputHVgateVoltageOutput: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST1AUELselectorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST1AUELselectorKind
extends
    Parseable[ExcIEEEST1AUELselectorKind]
{
    val sup = BasicElement.parse _
    val ignoreUELsignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.ignoreUELsignal"""))_
    val inputAddedToErrorSignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputAddedToErrorSignal"""))_
    val inputHVgateErrorSignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputHVgateErrorSignal"""))_
    val inputHVgateVoltageOutput = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputHVgateVoltageOutput"""))_
    def parse (context: Context): ExcIEEEST1AUELselectorKind =
    {
        ExcIEEEST1AUELselectorKind(
            sup (context),
            ignoreUELsignal (context),
            inputAddedToErrorSignal (context),
            inputHVgateErrorSignal (context),
            inputHVgateVoltageOutput (context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST2A model.
 * Some static systems utilize both current and voltage sources (generator terminal quantities) to comprise the power source.  The regulator controls the exciter output through controlled saturation of the power transformer components.  These compound-source rectifier excitation systems are designated Type ST2A and are represented by ExcIEEEST2A.
 */
case class ExcIEEEST2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum field voltage (E<sub>FDMax</sub>).
     * Typical Value = 99.
     */
    val efdmax: Double,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * Typical Value = 120.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 1.82.
     */
    val kc: Double,

    /**
     * Exciter constant related to self-excited field (K<sub>E</sub>).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (K<sub>F</sub>).
     * Typical Value = 0.05.
     */
    val kf: Double,

    /**
     * Potential circuit gain coefficient (K<sub>I</sub>).
     * Typical Value = 8.
     */
    val ki: Double,

    /**
     * Potential circuit gain coefficient (K<sub>P</sub>).
     * Typical Value = 4.88.
     */
    val kp: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.15.
     */
    val ta: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
     * Typical Value = 0.5.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * UEL input (UELin).
    true = HV gate
    false = add to error signal.
     * Typical Value = true.
     */
    val uelin: Boolean,

    /**
     * Maximum voltage regulator outputs (V<sub>RMAX</sub>).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (V<sub>RMIN</sub>).
     * Typical Value = 0.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST2A
extends
    Parseable[ExcIEEEST2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcIEEEST2A.efdmax"""))_
    val ka = parse_element (element ("""ExcIEEEST2A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEST2A.kc"""))_
    val ke = parse_element (element ("""ExcIEEEST2A.ke"""))_
    val kf = parse_element (element ("""ExcIEEEST2A.kf"""))_
    val ki = parse_element (element ("""ExcIEEEST2A.ki"""))_
    val kp = parse_element (element ("""ExcIEEEST2A.kp"""))_
    val ta = parse_element (element ("""ExcIEEEST2A.ta"""))_
    val te = parse_element (element ("""ExcIEEEST2A.te"""))_
    val tf = parse_element (element ("""ExcIEEEST2A.tf"""))_
    val uelin = parse_element (element ("""ExcIEEEST2A.uelin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST2A.vrmin"""))_
    def parse (context: Context): ExcIEEEST2A =
    {
        ExcIEEEST2A(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (ta (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toBoolean (uelin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST3A model.
 * Some static systems utilize a field voltage control loop to linearize the exciter control characteristic. This also makes the output independent of supply source variations until supply limitations are reached.  These systems utilize a variety of controlled-rectifier designs: full thyristor complements or hybrid bridges
 */
case class ExcIEEEST3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Voltage regulator gain (K<sub>A</sub>).
     * This is parameter K in the IEEE Std. Typical Value = 200.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.2.
     */
    val kc: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
     * Typical Value = 1.
     */
    val kg: Double,

    /**
     * Potential circuit gain coefficient (K<sub>I</sub>).
     * Typical Value = 0.
     */
    val ki: Double,

    /**
     * Forward gain constant of the inner loop field regulator (K<sub>M</sub>).
     * Typical Value = 7.93.
     */
    val km: Double,

    /**
     * Potential circuit gain coefficient (K<sub>P</sub>).
     * Typical Value = 6.15.
     */
    val kp: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (T<sub>B</sub>).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (T<sub>C</sub>).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Potential circuit phase angle (thetap).
     * Typical Value = 0.
     */
    val thetap: Double,

    /**
     * Forward time constant of inner loop field regulator (T<sub>M</sub>).
     * Typical Value = 0.4.
     */
    val tm: Double,

    /**
     * Maximum excitation voltage (V<sub>BMax</sub>).
     * Typical Value = 6.9.
     */
    val vbmax: Double,

    /**
     * Maximum inner loop feedback voltage (V<sub>GMax</sub>).
     * Typical Value = 5.8.
     */
    val vgmax: Double,

    /**
     * Maximum voltage regulator input limit (V<sub>IMAX</sub>).
     * Typical Value = 0.2.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (V<sub>IMIN</sub>).
     * Typical Value = -0.2.
     */
    val vimin: Double,

    /**
     * Maximum inner loop output (V<sub>MMax</sub>).
     * Typical Value = 1.
     */
    val vmmax: Double,

    /**
     * Minimum inner loop output (V<sub>MMin</sub>).
     * Typical Value = 0.
     */
    val vmmin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 10.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -10.
     */
    val vrmin: Double,

    /**
     * Reactance associated with potential source (X<sub>L</sub>).
     * Typical Value = 0.081.
     */
    val xl: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST3A
extends
    Parseable[ExcIEEEST3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ka = parse_element (element ("""ExcIEEEST3A.ka"""))_
    val kc = parse_element (element ("""ExcIEEEST3A.kc"""))_
    val kg = parse_element (element ("""ExcIEEEST3A.kg"""))_
    val ki = parse_element (element ("""ExcIEEEST3A.ki"""))_
    val km = parse_element (element ("""ExcIEEEST3A.km"""))_
    val kp = parse_element (element ("""ExcIEEEST3A.kp"""))_
    val ta = parse_element (element ("""ExcIEEEST3A.ta"""))_
    val tb = parse_element (element ("""ExcIEEEST3A.tb"""))_
    val tc = parse_element (element ("""ExcIEEEST3A.tc"""))_
    val thetap = parse_element (element ("""ExcIEEEST3A.thetap"""))_
    val tm = parse_element (element ("""ExcIEEEST3A.tm"""))_
    val vbmax = parse_element (element ("""ExcIEEEST3A.vbmax"""))_
    val vgmax = parse_element (element ("""ExcIEEEST3A.vgmax"""))_
    val vimax = parse_element (element ("""ExcIEEEST3A.vimax"""))_
    val vimin = parse_element (element ("""ExcIEEEST3A.vimin"""))_
    val vmmax = parse_element (element ("""ExcIEEEST3A.vmmax"""))_
    val vmmin = parse_element (element ("""ExcIEEEST3A.vmmin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST3A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST3A.vrmin"""))_
    val xl = parse_element (element ("""ExcIEEEST3A.xl"""))_
    def parse (context: Context): ExcIEEEST3A =
    {
        ExcIEEEST3A(
            sup (context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (km (context), context),
            toDouble (kp (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (thetap (context), context),
            toDouble (tm (context), context),
            toDouble (vbmax (context), context),
            toDouble (vgmax (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vmmax (context), context),
            toDouble (vmmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xl (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST4B model.
 * This model is a variation of the Type ST3A model, with a proportional plus integral (PI) regulator block replacing the lag-lead regulator characteristic that is in the ST3A model. Both potential and compound source rectifier excitation systems are modeled.  The PI regulator blocks have non-windup limits that are represented. The voltage regulator of this model is typically implemented digitally.
 */
case class ExcIEEEST4B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
     * Typical Value = 0.113.
     */
    val kc: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
     * Typical Value = 0.
     */
    val kg: Double,

    /**
     * Potential circuit gain coefficient (K<sub>I</sub>).
     * Typical Value = 0.
     */
    val ki: Double,

    /**
     * Voltage regulator integral gain output (K<sub>IM</sub>).
     * Typical Value = 0.
     */
    val kim: Double,

    /**
     * Voltage regulator integral gain (K<sub>IR</sub>).
     * Typical Value = 10.75.
     */
    val kir: Double,

    /**
     * Potential circuit gain coefficient (K<sub>P</sub>).
     * Typical Value = 9.3.
     */
    val kp: Double,

    /**
     * Voltage regulator proportional gain output (K<sub>PM</sub>).
     * Typical Value = 1.
     */
    val kpm: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PR</sub>).
     * Typical Value = 10.75.
     */
    val kpr: Double,

    /**
     * Voltage regulator time constant (T<sub>A</sub>).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Potential circuit phase angle (thetap).
     * Typical Value = 0.
     */
    val thetap: Double,

    /**
     * Maximum excitation voltage (V<sub>BMax</sub>).
     * Typical Value = 11.63.
     */
    val vbmax: Double,

    /**
     * Maximum inner loop output (V<sub>MMax</sub>).
     * Typical Value = 99.
     */
    val vmmax: Double,

    /**
     * Minimum inner loop output (V<sub>MMin</sub>).
     * Typical Value = -99.
     */
    val vmmin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -0.87.
     */
    val vrmin: Double,

    /**
     * Reactance associated with potential source (X<sub>L</sub>).
     * Typical Value = 0.124.
     */
    val xl: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST4B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST4B
extends
    Parseable[ExcIEEEST4B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kc = parse_element (element ("""ExcIEEEST4B.kc"""))_
    val kg = parse_element (element ("""ExcIEEEST4B.kg"""))_
    val ki = parse_element (element ("""ExcIEEEST4B.ki"""))_
    val kim = parse_element (element ("""ExcIEEEST4B.kim"""))_
    val kir = parse_element (element ("""ExcIEEEST4B.kir"""))_
    val kp = parse_element (element ("""ExcIEEEST4B.kp"""))_
    val kpm = parse_element (element ("""ExcIEEEST4B.kpm"""))_
    val kpr = parse_element (element ("""ExcIEEEST4B.kpr"""))_
    val ta = parse_element (element ("""ExcIEEEST4B.ta"""))_
    val thetap = parse_element (element ("""ExcIEEEST4B.thetap"""))_
    val vbmax = parse_element (element ("""ExcIEEEST4B.vbmax"""))_
    val vmmax = parse_element (element ("""ExcIEEEST4B.vmmax"""))_
    val vmmin = parse_element (element ("""ExcIEEEST4B.vmmin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST4B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST4B.vrmin"""))_
    val xl = parse_element (element ("""ExcIEEEST4B.xl"""))_
    def parse (context: Context): ExcIEEEST4B =
    {
        ExcIEEEST4B(
            sup (context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (kim (context), context),
            toDouble (kir (context), context),
            toDouble (kp (context), context),
            toDouble (kpm (context), context),
            toDouble (kpr (context), context),
            toDouble (ta (context), context),
            toDouble (thetap (context), context),
            toDouble (vbmax (context), context),
            toDouble (vmmax (context), context),
            toDouble (vmmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xl (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST5B model.
 * The Type ST5B excitation system is a variation of the Type ST1A model, with alternative overexcitation and underexcitation inputs and additional limits.
 */
case class ExcIEEEST5B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Rectifier regulation factor (K<sub>C</sub>).
     * Typical Value = 0.004.
     */
    val kc: Double,

    /**
     * Regulator gain (K<sub>R</sub>).
     * Typical Value = 200.
     */
    val kr: Double,

    /**
     * Firing circuit time constant (T1).
     * Typical Value = 0.004.
     */
    val t1: Double,

    /**
     * Regulator lag time constant (T<sub>B1</sub>).
     * Typical Value = 6.
     */
    val tb1: Double,

    /**
     * Regulator lag time constant (T<sub>B2</sub>).
     * Typical Value = 0.01.
     */
    val tb2: Double,

    /**
     * Regulator lead time constant (T<sub>C1</sub>).
     * Typical Value = 0.8.
     */
    val tc1: Double,

    /**
     * Regulator lead time constant (T<sub>C2</sub>).
     * Typical Value = 0.08.
     */
    val tc2: Double,

    /**
     * OEL lag time constant (T<sub>OB1</sub>).
     * Typical Value = 2.
     */
    val tob1: Double,

    /**
     * OEL lag time constant (T<sub>OB2</sub>).
     * Typical Value = 0.08.
     */
    val tob2: Double,

    /**
     * OEL lead time constant (T<sub>OC1</sub>).
     * Typical Value = 0.1.
     */
    val toc1: Double,

    /**
     * OEL lead time constant (T<sub>OC2</sub>).
     * Typical Value = 0.08.
     */
    val toc2: Double,

    /**
     * UEL lag time constant (T<sub>UB1</sub>).
     * Typical Value = 10.
     */
    val tub1: Double,

    /**
     * UEL lag time constant (T<sub>UB2</sub>).
     * Typical Value = 0.05.
     */
    val tub2: Double,

    /**
     * UEL lead time constant (T<sub>UC1</sub>).
     * Typical Value = 2.
     */
    val tuc1: Double,

    /**
     * UEL lead time constant (T<sub>UC2</sub>).
     * Typical Value = 0.1.
     */
    val tuc2: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -4.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST5B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST5B
extends
    Parseable[ExcIEEEST5B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kc = parse_element (element ("""ExcIEEEST5B.kc"""))_
    val kr = parse_element (element ("""ExcIEEEST5B.kr"""))_
    val t1 = parse_element (element ("""ExcIEEEST5B.t1"""))_
    val tb1 = parse_element (element ("""ExcIEEEST5B.tb1"""))_
    val tb2 = parse_element (element ("""ExcIEEEST5B.tb2"""))_
    val tc1 = parse_element (element ("""ExcIEEEST5B.tc1"""))_
    val tc2 = parse_element (element ("""ExcIEEEST5B.tc2"""))_
    val tob1 = parse_element (element ("""ExcIEEEST5B.tob1"""))_
    val tob2 = parse_element (element ("""ExcIEEEST5B.tob2"""))_
    val toc1 = parse_element (element ("""ExcIEEEST5B.toc1"""))_
    val toc2 = parse_element (element ("""ExcIEEEST5B.toc2"""))_
    val tub1 = parse_element (element ("""ExcIEEEST5B.tub1"""))_
    val tub2 = parse_element (element ("""ExcIEEEST5B.tub2"""))_
    val tuc1 = parse_element (element ("""ExcIEEEST5B.tuc1"""))_
    val tuc2 = parse_element (element ("""ExcIEEEST5B.tuc2"""))_
    val vrmax = parse_element (element ("""ExcIEEEST5B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST5B.vrmin"""))_
    def parse (context: Context): ExcIEEEST5B =
    {
        ExcIEEEST5B(
            sup (context),
            toDouble (kc (context), context),
            toDouble (kr (context), context),
            toDouble (t1 (context), context),
            toDouble (tb1 (context), context),
            toDouble (tb2 (context), context),
            toDouble (tc1 (context), context),
            toDouble (tc2 (context), context),
            toDouble (tob1 (context), context),
            toDouble (tob2 (context), context),
            toDouble (toc1 (context), context),
            toDouble (toc2 (context), context),
            toDouble (tub1 (context), context),
            toDouble (tub2 (context), context),
            toDouble (tuc1 (context), context),
            toDouble (tuc2 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST6B model.
 * This model consists of a PI voltage regulator with an inner loop field voltage regulator and pre-control. The field voltage regulator implements a proportional control. The pre-control and the delay in the feedback circuit increase the dynamic response.
 */
case class ExcIEEEST6B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter output current limit reference (I<sub>LR</sub>).
     * Typical Value = 4.164.
     */
    val ilr: Double,

    /**
     * Exciter output current limit adjustment (K<sub>CI</sub>).
     * Typical Value = 1.0577.
     */
    val kci: Double,

    /**
     * Pre-control gain constant of the inner loop field regulator (K<sub>FF</sub>).
     * Typical Value = 1.
     */
    val kff: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
     * Typical Value = 1.
     */
    val kg: Double,

    /**
     * Voltage regulator integral gain (K<sub>IA</sub>).
     * Typical Value = 45.094.
     */
    val kia: Double,

    /**
     * Exciter output current limiter gain (K<sub>LR</sub>).
     * Typical Value = 17.33.
     */
    val klr: Double,

    /**
     * Forward gain constant of the inner loop field regulator (K<sub>M</sub>).
     * Typical Value = 1.
     */
    val km: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PA</sub>).
     * Typical Value = 18.038.
     */
    val kpa: Double,

    /**
     * OEL input selector (OELin).
     * Typical Value = noOELinput.
     */
    val oelin: String,

    /**
     * Feedback time constant of inner loop field voltage regulator (T<sub>G</sub>).
     * Typical Value = 0.02.
     */
    val tg: Double,

    /**
     * Maximum voltage regulator output (V<sub>AMAX</sub>).
     * Typical Value = 4.81.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (V<sub>AMIN</sub>).
     * Typical Value = -3.85.
     */
    val vamin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 4.81.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -3.85.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST6B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST6B
extends
    Parseable[ExcIEEEST6B]
{
    val sup = ExcitationSystemDynamics.parse _
    val ilr = parse_element (element ("""ExcIEEEST6B.ilr"""))_
    val kci = parse_element (element ("""ExcIEEEST6B.kci"""))_
    val kff = parse_element (element ("""ExcIEEEST6B.kff"""))_
    val kg = parse_element (element ("""ExcIEEEST6B.kg"""))_
    val kia = parse_element (element ("""ExcIEEEST6B.kia"""))_
    val klr = parse_element (element ("""ExcIEEEST6B.klr"""))_
    val km = parse_element (element ("""ExcIEEEST6B.km"""))_
    val kpa = parse_element (element ("""ExcIEEEST6B.kpa"""))_
    val oelin = parse_attribute (attribute ("""ExcIEEEST6B.oelin"""))_
    val tg = parse_element (element ("""ExcIEEEST6B.tg"""))_
    val vamax = parse_element (element ("""ExcIEEEST6B.vamax"""))_
    val vamin = parse_element (element ("""ExcIEEEST6B.vamin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST6B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST6B.vrmin"""))_
    def parse (context: Context): ExcIEEEST6B =
    {
        ExcIEEEST6B(
            sup (context),
            toDouble (ilr (context), context),
            toDouble (kci (context), context),
            toDouble (kff (context), context),
            toDouble (kg (context), context),
            toDouble (kia (context), context),
            toDouble (klr (context), context),
            toDouble (km (context), context),
            toDouble (kpa (context), context),
            oelin (context),
            toDouble (tg (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST7B model.
 * This model is representative of static potential-source excitation systems. In this system, the AVR consists of a PI voltage regulator. A phase lead-lag filter in series allows introduction of a derivative function, typically used with brushless excitation systems. In that case, the regulator is of the PID type. In addition, the terminal voltage channel includes a phase lead-lag filter.  The AVR includes the appropriate inputs on its reference for overexcitation limiter (OEL1), underexcitation limiter (UEL), stator current limiter (SCL), and current compensator (DROOP). All these limitations, when they work at voltage reference level, keep the PSS (VS signal from Type PSS1A, PSS2A, or PSS2B) in operation. However, the UEL limitation can also be transferred to the high value (HV) gate acting on the output signal. In addition, the output signal passes through a low value (LV) gate for a ceiling overexcitation limiter (OEL2).
 */
case class ExcIEEEST7B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * High-value gate feedback gain (K<sub>H</sub>).
     * Typical Value 1.
     */
    val kh: Double,

    /**
     * Voltage regulator integral gain (K<sub>IA</sub>).
     * Typical Value = 1.
     */
    val kia: Double,

    /**
     * Low-value gate feedback gain (K<sub>L</sub>).
     * Typical Value 1.
     */
    val kl: Double,

    /**
     * Voltage regulator proportional gain (K<sub>PA</sub>).
     * Typical Value = 40.
     */
    val kpa: Double,

    /**
     * OEL input selector (OELin).
     * Typical Value = noOELinput.
     */
    val oelin: String,

    /**
     * Regulator lag time constant (T<sub>B</sub>).
     * Typical Value 1.
     */
    val tb: Double,

    /**
     * Regulator lead time constant (T<sub>C</sub>).
     * Typical Value 1.
     */
    val tc: Double,

    /**
     * Excitation control system stabilizer time constant (T<sub>F</sub>).
     * Typical Value 1.
     */
    val tf: Double,

    /**
     * Feedback time constant of inner loop field voltage regulator (T<sub>G</sub>).
     * Typical Value 1.
     */
    val tg: Double,

    /**
     * Feedback time constant (T<sub>IA</sub>).
     * Typical Value = 3.
     */
    val tia: Double,

    /**
     * UEL input selector (UELin).
     * Typical Value = noUELinput.
     */
    val uelin: String,

    /**
     * Maximum voltage reference signal (V<sub>MAX</sub>).
     * Typical Value = 1.1.
     */
    val vmax: Double,

    /**
     * Minimum voltage reference signal (V<sub>MIN</sub>).
     * Typical Value = 0.9.
     */
    val vmin: Double,

    /**
     * Maximum voltage regulator output (V<sub>RMAX</sub>).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (V<sub>RMIN</sub>).
     * Typical Value = -4.5.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcIEEEST7B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcIEEEST7B
extends
    Parseable[ExcIEEEST7B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kh = parse_element (element ("""ExcIEEEST7B.kh"""))_
    val kia = parse_element (element ("""ExcIEEEST7B.kia"""))_
    val kl = parse_element (element ("""ExcIEEEST7B.kl"""))_
    val kpa = parse_element (element ("""ExcIEEEST7B.kpa"""))_
    val oelin = parse_attribute (attribute ("""ExcIEEEST7B.oelin"""))_
    val tb = parse_element (element ("""ExcIEEEST7B.tb"""))_
    val tc = parse_element (element ("""ExcIEEEST7B.tc"""))_
    val tf = parse_element (element ("""ExcIEEEST7B.tf"""))_
    val tg = parse_element (element ("""ExcIEEEST7B.tg"""))_
    val tia = parse_element (element ("""ExcIEEEST7B.tia"""))_
    val uelin = parse_attribute (attribute ("""ExcIEEEST7B.uelin"""))_
    val vmax = parse_element (element ("""ExcIEEEST7B.vmax"""))_
    val vmin = parse_element (element ("""ExcIEEEST7B.vmin"""))_
    val vrmax = parse_element (element ("""ExcIEEEST7B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcIEEEST7B.vrmin"""))_
    def parse (context: Context): ExcIEEEST7B =
    {
        ExcIEEEST7B(
            sup (context),
            toDouble (kh (context), context),
            toDouble (kia (context), context),
            toDouble (kl (context), context),
            toDouble (kpa (context), context),
            oelin (context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (tf (context), context),
            toDouble (tg (context), context),
            toDouble (tia (context), context),
            uelin (context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE Type ST1 Excitation System with semi-continuous and acting terminal voltage limiter.
 */
case class ExcOEX3T
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Saturation parameter (E<sub>1</sub>).
     */
    val e1: Double,

    /**
     * Saturation parameter (E<sub>2</sub>).
     */
    val e2: Double,

    /**
     * Gain (K<sub>A</sub>).
     */
    val ka: Double,

    /**
     * Gain (K<sub>C</sub>).
     */
    val kc: Double,

    /**
     * Gain (K<sub>D</sub>).
     */
    val kd: Double,

    /**
     * Gain (K<sub>E</sub>).
     */
    val ke: Double,

    /**
     * Gain (K<sub>F</sub>).
     */
    val kf: Double,

    /**
     * Saturation parameter (S<sub>E</sub>(E<sub>1</sub>)).
     */
    val see1: Double,

    /**
     * Saturation parameter (S<sub>E</sub>(E<sub>2</sub>)).
     */
    val see2: Double,

    /**
     * Time constant (T<sub>1</sub>).
     */
    val t1: Double,

    /**
     * Time constant (T<sub>2</sub>).
     */
    val t2: Double,

    /**
     * Time constant (T<sub>3</sub>).
     */
    val t3: Double,

    /**
     * Time constant (T<sub>4</sub>).
     */
    val t4: Double,

    /**
     * Time constant (T<sub>5</sub>).
     */
    val t5: Double,

    /**
     * Time constant (T<sub>6</sub>).
     */
    val t6: Double,

    /**
     * Time constant (T<sub>E</sub>).
     */
    val te: Double,

    /**
     * Time constant (T<sub>F</sub>).
     */
    val tf: Double,

    /**
     * Limiter (V<sub>RMAX</sub>).
     */
    val vrmax: Double,

    /**
     * Limiter (V<sub>RMIN</sub>).
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcOEX3T]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcOEX3T
extends
    Parseable[ExcOEX3T]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcOEX3T.e1"""))_
    val e2 = parse_element (element ("""ExcOEX3T.e2"""))_
    val ka = parse_element (element ("""ExcOEX3T.ka"""))_
    val kc = parse_element (element ("""ExcOEX3T.kc"""))_
    val kd = parse_element (element ("""ExcOEX3T.kd"""))_
    val ke = parse_element (element ("""ExcOEX3T.ke"""))_
    val kf = parse_element (element ("""ExcOEX3T.kf"""))_
    val see1 = parse_element (element ("""ExcOEX3T.see1"""))_
    val see2 = parse_element (element ("""ExcOEX3T.see2"""))_
    val t1 = parse_element (element ("""ExcOEX3T.t1"""))_
    val t2 = parse_element (element ("""ExcOEX3T.t2"""))_
    val t3 = parse_element (element ("""ExcOEX3T.t3"""))_
    val t4 = parse_element (element ("""ExcOEX3T.t4"""))_
    val t5 = parse_element (element ("""ExcOEX3T.t5"""))_
    val t6 = parse_element (element ("""ExcOEX3T.t6"""))_
    val te = parse_element (element ("""ExcOEX3T.te"""))_
    val tf = parse_element (element ("""ExcOEX3T.tf"""))_
    val vrmax = parse_element (element ("""ExcOEX3T.vrmax"""))_
    val vrmin = parse_element (element ("""ExcOEX3T.vrmin"""))_
    def parse (context: Context): ExcOEX3T =
    {
        ExcOEX3T(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (see1 (context), context),
            toDouble (see2 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Proportional/Integral Regulator Excitation System Model.
 * This model can be used to represent excitation systems with a proportional-integral (PI) voltage regulator controller.
 */
case class ExcPIC
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage value 1 (E1).
     * Typical Value = 0.
     */
    val e1: Double,

    /**
     * Field voltage value 2 (E2).
     * Typical Value = 0.
     */
    val e2: Double,

    /**
     * Exciter maximum limit (Efdmax).
     * Typical Value = 8.
     */
    val efdmax: Double,

    /**
     * Exciter minimum limit (Efdmin).
     * Typical Value = -0.87.
     */
    val efdmin: Double,

    /**
     * PI controller gain (Ka).
     * Typical Value = 3.15.
     */
    val ka: Double,

    /**
     * Exciter regulation factor (Kc).
     * Typical Value = 0.08.
     */
    val kc: Double,

    /**
     * Exciter constant (Ke).
     * Typical Value = 0.
     */
    val ke: Double,

    /**
     * Rate feedback gain (Kf).
     * Typical Value = 0.
     */
    val kf: Double,

    /**
     * Current source gain (Ki).
     * Typical Value = 0.
     */
    val ki: Double,

    /**
     * Potential source gain (Kp).
     * Typical Value = 6.5.
     */
    val kp: Double,

    /**
     * Saturation factor at E1 (Se1).
     * Typical Value = 0.
     */
    val se1: Double,

    /**
     * Saturation factor at E2 (Se2).
     * Typical Value = 0.
     */
    val se2: Double,

    /**
     * PI controller time constant (Ta1).
     * Typical Value = 1.
     */
    val ta1: Double,

    /**
     * Voltage regulator time constant (Ta2).
     * Typical Value = 0.01.
     */
    val ta2: Double,

    /**
     * Lead time constant (Ta3).
     * Typical Value = 0.
     */
    val ta3: Double,

    /**
     * Lag time constant (Ta4).
     * Typical Value = 0.
     */
    val ta4: Double,

    /**
     * Exciter time constant (Te).
     * Typical Value = 0.
     */
    val te: Double,

    /**
     * Rate feedback time constant (Tf1).
     * Typical Value = 0.
     */
    val tf1: Double,

    /**
     * Rate feedback lag time constant (Tf2).
     * Typical Value = 0.
     */
    val tf2: Double,

    /**
     * PI maximum limit (Vr1).
     * Typical Value = 1.
     */
    val vr1: Double,

    /**
     * PI minimum limit (Vr2).
     * Typical Value = -0.87.
     */
    val vr2: Double,

    /**
     * Voltage regulator maximum limit (Vrmax).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Voltage regulator minimum limit (Vrmin).
     * Typical Value = -0.87.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcPIC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcPIC
extends
    Parseable[ExcPIC]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcPIC.e1"""))_
    val e2 = parse_element (element ("""ExcPIC.e2"""))_
    val efdmax = parse_element (element ("""ExcPIC.efdmax"""))_
    val efdmin = parse_element (element ("""ExcPIC.efdmin"""))_
    val ka = parse_element (element ("""ExcPIC.ka"""))_
    val kc = parse_element (element ("""ExcPIC.kc"""))_
    val ke = parse_element (element ("""ExcPIC.ke"""))_
    val kf = parse_element (element ("""ExcPIC.kf"""))_
    val ki = parse_element (element ("""ExcPIC.ki"""))_
    val kp = parse_element (element ("""ExcPIC.kp"""))_
    val se1 = parse_element (element ("""ExcPIC.se1"""))_
    val se2 = parse_element (element ("""ExcPIC.se2"""))_
    val ta1 = parse_element (element ("""ExcPIC.ta1"""))_
    val ta2 = parse_element (element ("""ExcPIC.ta2"""))_
    val ta3 = parse_element (element ("""ExcPIC.ta3"""))_
    val ta4 = parse_element (element ("""ExcPIC.ta4"""))_
    val te = parse_element (element ("""ExcPIC.te"""))_
    val tf1 = parse_element (element ("""ExcPIC.tf1"""))_
    val tf2 = parse_element (element ("""ExcPIC.tf2"""))_
    val vr1 = parse_element (element ("""ExcPIC.vr1"""))_
    val vr2 = parse_element (element ("""ExcPIC.vr2"""))_
    val vrmax = parse_element (element ("""ExcPIC.vrmax"""))_
    val vrmin = parse_element (element ("""ExcPIC.vrmin"""))_
    def parse (context: Context): ExcPIC =
    {
        ExcPIC(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            toDouble (efdmax (context), context),
            toDouble (efdmin (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (se1 (context), context),
            toDouble (se2 (context), context),
            toDouble (ta1 (context), context),
            toDouble (ta2 (context), context),
            toDouble (ta3 (context), context),
            toDouble (ta4 (context), context),
            toDouble (te (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (vr1 (context), context),
            toDouble (vr2 (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * General Purpose Rotating Excitation System Model.
 * This model can be used to represent a wide range of excitation systems whose DC power source is an AC or DC generator. It encompasses IEEE type AC1, AC2, DC1, and DC2 excitation system models.
 */
case class ExcREXS
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage value 1 (E1).
     * Typical Value = 3.
     */
    val e1: Double,

    /**
     * Field voltage value 2 (E2).
     * Typical Value = 4.
     */
    val e2: Double,

    /**
     * Rate feedback signal flag (Fbf).
     * Typical Value = fieldCurrent.
     */
    val fbf: String,

    /**
     * Limit type flag (Flimf).
     * Typical Value = 0.
     */
    val flimf: Double,

    /**
     * Rectifier regulation factor (Kc).
     * Typical Value = 0.05.
     */
    val kc: Double,

    /**
     * Exciter regulation factor (Kd).
     * Typical Value = 2.
     */
    val kd: Double,

    /**
     * Exciter field proportional constant (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Field voltage feedback gain (Kefd).
     * Typical Value = 0.
     */
    val kefd: Double,

    /**
     * Rate feedback gain (Kf).
     * Typical Value = 0.05.
     */
    val kf: Double,

    /**
     * Field voltage controller feedback gain (Kh).
     * Typical Value = 0.
     */
    val kh: Double,

    /**
     * Field Current Regulator Integral Gain (Kii).
     * Typical Value = 0.
     */
    val kii: Double,

    /**
     * Field Current Regulator Proportional Gain (Kip).
     * Typical Value = 1.
     */
    val kip: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Voltage Regulator Integral Gain (Kvi).
     * Typical Value = 0.
     */
    val kvi: Double,

    /**
     * Voltage Regulator Proportional Gain (Kvp).
     * Typical Value = 2800.
     */
    val kvp: Double,

    /**
     * V/Hz limiter gain (Kvphz).
     * Typical Value = 0.
     */
    val kvphz: Double,

    /**
     * Pickup speed of V/Hz limiter (Nvphz).
     * Typical Value = 0.
     */
    val nvphz: Double,

    /**
     * Saturation factor at E1 (Se1).
     * Typical Value = 0.0001.
     */
    val se1: Double,

    /**
     * Saturation factor at E2 (Se2).
     * Typical Value = 0.001.
     */
    val se2: Double,

    /**
     * Voltage Regulator time constant (Ta).
     * Typical Value = 0.01.
     */
    val ta: Double,

    /**
     * Lag time constant (Tb1).
     * Typical Value = 0.
     */
    val tb1: Double,

    /**
     * Lag time constant (Tb2).
     * Typical Value = 0.
     */
    val tb2: Double,

    /**
     * Lead time constant (Tc1).
     * Typical Value = 0.
     */
    val tc1: Double,

    /**
     * Lead time constant (Tc2).
     * Typical Value = 0.
     */
    val tc2: Double,

    /**
     * Exciter field time constant (Te).
     * Typical Value = 1.2.
     */
    val te: Double,

    /**
     * Rate feedback time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Feedback lead time constant (Tf1).
     * Typical Value = 0.
     */
    val tf1: Double,

    /**
     * Feedback lag time constant (Tf2).
     * Typical Value = 0.
     */
    val tf2: Double,

    /**
     * Field current Bridge time constant (Tp).
     * Typical Value = 0.
     */
    val tp: Double,

    /**
     * Maximum compounding voltage (Vcmax).
     * Typical Value = 0.
     */
    val vcmax: Double,

    /**
     * Maximum Exciter Field Current (Vfmax).
     * Typical Value = 47.
     */
    val vfmax: Double,

    /**
     * Minimum Exciter Field Current (Vfmin).
     * Typical Value = -20.
     */
    val vfmin: Double,

    /**
     * Voltage Regulator Input Limit (Vimax).
     * Typical Value = 0.1.
     */
    val vimax: Double,

    /**
     * Maximum controller output (Vrmax).
     * Typical Value = 47.
     */
    val vrmax: Double,

    /**
     * Minimum controller output (Vrmin).
     * Typical Value = -20.
     */
    val vrmin: Double,

    /**
     * Exciter compounding reactance (Xc).
     * Typical Value = 0.
     */
    val xc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcREXS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcREXS
extends
    Parseable[ExcREXS]
{
    val sup = ExcitationSystemDynamics.parse _
    val e1 = parse_element (element ("""ExcREXS.e1"""))_
    val e2 = parse_element (element ("""ExcREXS.e2"""))_
    val fbf = parse_attribute (attribute ("""ExcREXS.fbf"""))_
    val flimf = parse_element (element ("""ExcREXS.flimf"""))_
    val kc = parse_element (element ("""ExcREXS.kc"""))_
    val kd = parse_element (element ("""ExcREXS.kd"""))_
    val ke = parse_element (element ("""ExcREXS.ke"""))_
    val kefd = parse_element (element ("""ExcREXS.kefd"""))_
    val kf = parse_element (element ("""ExcREXS.kf"""))_
    val kh = parse_element (element ("""ExcREXS.kh"""))_
    val kii = parse_element (element ("""ExcREXS.kii"""))_
    val kip = parse_element (element ("""ExcREXS.kip"""))_
    val ks = parse_element (element ("""ExcREXS.ks"""))_
    val kvi = parse_element (element ("""ExcREXS.kvi"""))_
    val kvp = parse_element (element ("""ExcREXS.kvp"""))_
    val kvphz = parse_element (element ("""ExcREXS.kvphz"""))_
    val nvphz = parse_element (element ("""ExcREXS.nvphz"""))_
    val se1 = parse_element (element ("""ExcREXS.se1"""))_
    val se2 = parse_element (element ("""ExcREXS.se2"""))_
    val ta = parse_element (element ("""ExcREXS.ta"""))_
    val tb1 = parse_element (element ("""ExcREXS.tb1"""))_
    val tb2 = parse_element (element ("""ExcREXS.tb2"""))_
    val tc1 = parse_element (element ("""ExcREXS.tc1"""))_
    val tc2 = parse_element (element ("""ExcREXS.tc2"""))_
    val te = parse_element (element ("""ExcREXS.te"""))_
    val tf = parse_element (element ("""ExcREXS.tf"""))_
    val tf1 = parse_element (element ("""ExcREXS.tf1"""))_
    val tf2 = parse_element (element ("""ExcREXS.tf2"""))_
    val tp = parse_element (element ("""ExcREXS.tp"""))_
    val vcmax = parse_element (element ("""ExcREXS.vcmax"""))_
    val vfmax = parse_element (element ("""ExcREXS.vfmax"""))_
    val vfmin = parse_element (element ("""ExcREXS.vfmin"""))_
    val vimax = parse_element (element ("""ExcREXS.vimax"""))_
    val vrmax = parse_element (element ("""ExcREXS.vrmax"""))_
    val vrmin = parse_element (element ("""ExcREXS.vrmin"""))_
    val xc = parse_element (element ("""ExcREXS.xc"""))_
    def parse (context: Context): ExcREXS =
    {
        ExcREXS(
            sup (context),
            toDouble (e1 (context), context),
            toDouble (e2 (context), context),
            fbf (context),
            toDouble (flimf (context), context),
            toDouble (kc (context), context),
            toDouble (kd (context), context),
            toDouble (ke (context), context),
            toDouble (kefd (context), context),
            toDouble (kf (context), context),
            toDouble (kh (context), context),
            toDouble (kii (context), context),
            toDouble (kip (context), context),
            toDouble (ks (context), context),
            toDouble (kvi (context), context),
            toDouble (kvp (context), context),
            toDouble (kvphz (context), context),
            toDouble (nvphz (context), context),
            toDouble (se1 (context), context),
            toDouble (se2 (context), context),
            toDouble (ta (context), context),
            toDouble (tb1 (context), context),
            toDouble (tb2 (context), context),
            toDouble (tc1 (context), context),
            toDouble (tc2 (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (tp (context), context),
            toDouble (vcmax (context), context),
            toDouble (vfmax (context), context),
            toDouble (vfmin (context), context),
            toDouble (vimax (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xc (context), context)
        )
    }
}

/**
 * Type of rate feedback signals.
 */
case class ExcREXSFeedbackSignalKind
(

    override val sup: BasicElement,

    /**
     * The exciter field current is used.
     */
    val fieldCurrent: String,

    /**
     * The voltage regulator output voltage is used.
     * It is the same as exciter field voltage.
     */
    val fieldVoltage: String,

    /**
     * The output voltage of the exciter is used.
     */
    val outputVoltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcREXSFeedbackSignalKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcREXSFeedbackSignalKind
extends
    Parseable[ExcREXSFeedbackSignalKind]
{
    val sup = BasicElement.parse _
    val fieldCurrent = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.fieldCurrent"""))_
    val fieldVoltage = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.fieldVoltage"""))_
    val outputVoltage = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.outputVoltage"""))_
    def parse (context: Context): ExcREXSFeedbackSignalKind =
    {
        ExcREXSFeedbackSignalKind(
            sup (context),
            fieldCurrent (context),
            fieldVoltage (context),
            outputVoltage (context)
        )
    }
}

/**
 * Simple excitation system model representing generic characteristics of many excitation systems; intended for use where negative field current may be a problem.
 */
case class ExcSCRX
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Power source switch (Cswitch).
    true = fixed voltage of 1.0 PU
     * false = generator terminal voltage.
     */
    val cswitch: Boolean,

    /**
     * Maximum field voltage output (Emax).
     * Typical Value = 5.
     */
    val emax: Double,

    /**
     * Minimum field voltage output (Emin).
     * Typical Value = 0.
     */
    val emin: Double,

    /**
     * Gain (K) (&gt;0).
     * Typical Value = 200.
     */
    val k: Double,

    /**
     * Rc/Rfd - ratio of field discharge resistance to field winding resistance (RcRfd).
     * Typical Value = 0.
     */
    val rcrfd: Double,

    /**
     * Ta/Tb - gain reduction ratio of lag-lead element (TaTb).
     * The parameter Ta is not defined explicitly.  Typical Value = 0.1.
     */
    val tatb: Double,

    /**
     * Denominator time constant of lag-lead block (Tb).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Time constant of gain block (Te) (&gt;0).
     * Typical Value = 0.02.
     */
    val te: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcSCRX]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcSCRX
extends
    Parseable[ExcSCRX]
{
    val sup = ExcitationSystemDynamics.parse _
    val cswitch = parse_element (element ("""ExcSCRX.cswitch"""))_
    val emax = parse_element (element ("""ExcSCRX.emax"""))_
    val emin = parse_element (element ("""ExcSCRX.emin"""))_
    val k = parse_element (element ("""ExcSCRX.k"""))_
    val rcrfd = parse_element (element ("""ExcSCRX.rcrfd"""))_
    val tatb = parse_element (element ("""ExcSCRX.tatb"""))_
    val tb = parse_element (element ("""ExcSCRX.tb"""))_
    val te = parse_element (element ("""ExcSCRX.te"""))_
    def parse (context: Context): ExcSCRX =
    {
        ExcSCRX(
            sup (context),
            toBoolean (cswitch (context), context),
            toDouble (emax (context), context),
            toDouble (emin (context), context),
            toDouble (k (context), context),
            toDouble (rcrfd (context), context),
            toDouble (tatb (context), context),
            toDouble (tb (context), context),
            toDouble (te (context), context)
        )
    }
}

/**
 * Simplified Excitation System Model.
 */
case class ExcSEXS
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage clipping maximum limit (Efdmax).
     * Typical Value = 5.
     */
    val efdmax: Double,

    /**
     * Field voltage clipping minimum limit (Efdmin).
     * Typical Value = -5.
     */
    val efdmin: Double,

    /**
     * Maximum field voltage output (Emax).
     * Typical Value = 5.
     */
    val emax: Double,

    /**
     * Minimum field voltage output (Emin).
     * Typical Value = -5.
     */
    val emin: Double,

    /**
     * Gain (K) (&gt;0).
     * Typical Value = 100.
     */
    val k: Double,

    /**
     * PI controller gain (Kc).
     * Typical Value = 0.08.
     */
    val kc: Double,

    /**
     * Ta/Tb - gain reduction ratio of lag-lead element (TaTb).
     * Typical Value = 0.1.
     */
    val tatb: Double,

    /**
     * Denominator time constant of lag-lead block (Tb).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * PI controller phase lead time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Time constant of gain block (Te).
     * Typical Value = 0.05.
     */
    val te: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcSEXS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcSEXS
extends
    Parseable[ExcSEXS]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcSEXS.efdmax"""))_
    val efdmin = parse_element (element ("""ExcSEXS.efdmin"""))_
    val emax = parse_element (element ("""ExcSEXS.emax"""))_
    val emin = parse_element (element ("""ExcSEXS.emin"""))_
    val k = parse_element (element ("""ExcSEXS.k"""))_
    val kc = parse_element (element ("""ExcSEXS.kc"""))_
    val tatb = parse_element (element ("""ExcSEXS.tatb"""))_
    val tb = parse_element (element ("""ExcSEXS.tb"""))_
    val tc = parse_element (element ("""ExcSEXS.tc"""))_
    val te = parse_element (element ("""ExcSEXS.te"""))_
    def parse (context: Context): ExcSEXS =
    {
        ExcSEXS(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (efdmin (context), context),
            toDouble (emax (context), context),
            toDouble (emin (context), context),
            toDouble (k (context), context),
            toDouble (kc (context), context),
            toDouble (tatb (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context)
        )
    }
}

/**
 * Slovakian Excitation System Model.
 * UEL and secondary voltage control are included in this model. When this model is used, there cannot be a separate underexcitation limiter or VAr controller model.
 */
case class ExcSK
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Field voltage clipping limit (Efdmax).
     */
    val efdmax: Double,

    /**
     * Field voltage clipping limit (Efdmin).
     */
    val efdmin: Double,

    /**
     * Maximum field voltage output (Emax).
     * Typical Value = 20.
     */
    val emax: Double,

    /**
     * Minimum field voltage output (Emin).
     * Typical Value = -20.
     */
    val emin: Double,

    /**
     * Gain (K).
     * Typical Value = 1.
     */
    val k: Double,

    /**
     * Parameter of underexcitation limit (K1).
     * Typical Value = 0.1364.
     */
    val k1: Double,

    /**
     * Parameter of underexcitation limit (K2).
     * Typical Value = -0.3861.
     */
    val k2: Double,

    /**
     * PI controller gain (Kc).
     * Typical Value = 70.
     */
    val kc: Double,

    /**
     * Rectifier regulation factor (Kce).
     * Typical Value = 0.
     */
    val kce: Double,

    /**
     * Exciter internal reactance (Kd).
     * Typical Value = 0.
     */
    val kd: Double,

    /**
     * P controller gain (Kgob).
     * Typical Value = 10.
     */
    val kgob: Double,

    /**
     * PI controller gain (Kp).
     * Typical Value = 1.
     */
    val kp: Double,

    /**
     * PI controller gain of integral component (Kqi).
     * Typical Value = 0.
     */
    val kqi: Double,

    /**
     * Rate of rise of the reactive power (Kqob).
     */
    val kqob: Double,

    /**
     * PI controller gain (Kqp).
     * Typical Value = 0.
     */
    val kqp: Double,

    /**
     * Dead band of reactive power (nq).
     * Determines the range of sensitivity.  Typical Value = 0.001.
     */
    val nq: Double,

    /**
     * Secondary voltage control state (Qc_on_off).
    true = secondary voltage control is ON
    false = secondary voltage control is OFF.
     * Typical Value = false.
     */
    val qconoff: Boolean,

    /**
     * Desired value (setpoint) of reactive power, manual setting (Qz).
     */
    val qz: Double,

    /**
     * Selector to apply automatic calculation in secondary controller model.
    true = automatic calculation is activated
    false = manual set is active; the use of desired value of reactive power (Qz) is required.
     * Typical Value = true.
     */
    val remote: Boolean,

    /**
     * Apparent power of the unit (Sbase).
     * Unit = MVA.  Typical Value = 259.
     */
    val sbase: Double,

    /**
     * PI controller phase lead time constant (Tc).
     * Typical Value = 8.
     */
    val tc: Double,

    /**
     * Time constant of gain block (Te).
     * Typical Value = 0.1.
     */
    val te: Double,

    /**
     * PI controller phase lead time constant (Ti).
     * Typical Value = 2.
     */
    val ti: Double,

    /**
     * Time constant (Tp).
     * Typical Value = 0.1.
     */
    val tp: Double,

    /**
     * Voltage transducer time constant (Tr).
     * Typical Value = 0.01.
     */
    val tr: Double,

    /**
     * Maximum error (Uimax).
     * Typical Value = 10.
     */
    val uimax: Double,

    /**
     * Minimum error (UImin).
     * Typical Value = -10.
     */
    val uimin: Double,

    /**
     * Maximum controller output (URmax).
     * Typical Value = 10.
     */
    val urmax: Double,

    /**
     * Minimum controller output (URmin).
     * Typical Value = -10.
     */
    val urmin: Double,

    /**
     * Maximum terminal voltage input (Vtmax).
     * Determines the range of voltage dead band.  Typical Value = 1.05.
     */
    val vtmax: Double,

    /**
     * Minimum terminal voltage input (Vtmin).
     * Determines the range of voltage dead band.  Typical Value = 0.95.
     */
    val vtmin: Double,

    /**
     * Maximum output (Yp).
     * Minimum output = 0.  Typical Value = 1.
     */
    val yp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcSK]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcSK
extends
    Parseable[ExcSK]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcSK.efdmax"""))_
    val efdmin = parse_element (element ("""ExcSK.efdmin"""))_
    val emax = parse_element (element ("""ExcSK.emax"""))_
    val emin = parse_element (element ("""ExcSK.emin"""))_
    val k = parse_element (element ("""ExcSK.k"""))_
    val k1 = parse_element (element ("""ExcSK.k1"""))_
    val k2 = parse_element (element ("""ExcSK.k2"""))_
    val kc = parse_element (element ("""ExcSK.kc"""))_
    val kce = parse_element (element ("""ExcSK.kce"""))_
    val kd = parse_element (element ("""ExcSK.kd"""))_
    val kgob = parse_element (element ("""ExcSK.kgob"""))_
    val kp = parse_element (element ("""ExcSK.kp"""))_
    val kqi = parse_element (element ("""ExcSK.kqi"""))_
    val kqob = parse_element (element ("""ExcSK.kqob"""))_
    val kqp = parse_element (element ("""ExcSK.kqp"""))_
    val nq = parse_element (element ("""ExcSK.nq"""))_
    val qconoff = parse_element (element ("""ExcSK.qconoff"""))_
    val qz = parse_element (element ("""ExcSK.qz"""))_
    val remote = parse_element (element ("""ExcSK.remote"""))_
    val sbase = parse_element (element ("""ExcSK.sbase"""))_
    val tc = parse_element (element ("""ExcSK.tc"""))_
    val te = parse_element (element ("""ExcSK.te"""))_
    val ti = parse_element (element ("""ExcSK.ti"""))_
    val tp = parse_element (element ("""ExcSK.tp"""))_
    val tr = parse_element (element ("""ExcSK.tr"""))_
    val uimax = parse_element (element ("""ExcSK.uimax"""))_
    val uimin = parse_element (element ("""ExcSK.uimin"""))_
    val urmax = parse_element (element ("""ExcSK.urmax"""))_
    val urmin = parse_element (element ("""ExcSK.urmin"""))_
    val vtmax = parse_element (element ("""ExcSK.vtmax"""))_
    val vtmin = parse_element (element ("""ExcSK.vtmin"""))_
    val yp = parse_element (element ("""ExcSK.yp"""))_
    def parse (context: Context): ExcSK =
    {
        ExcSK(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (efdmin (context), context),
            toDouble (emax (context), context),
            toDouble (emin (context), context),
            toDouble (k (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (kc (context), context),
            toDouble (kce (context), context),
            toDouble (kd (context), context),
            toDouble (kgob (context), context),
            toDouble (kp (context), context),
            toDouble (kqi (context), context),
            toDouble (kqob (context), context),
            toDouble (kqp (context), context),
            toDouble (nq (context), context),
            toBoolean (qconoff (context), context),
            toDouble (qz (context), context),
            toBoolean (remote (context), context),
            toDouble (sbase (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (ti (context), context),
            toDouble (tp (context), context),
            toDouble (tr (context), context),
            toDouble (uimax (context), context),
            toDouble (uimin (context), context),
            toDouble (urmax (context), context),
            toDouble (urmin (context), context),
            toDouble (vtmax (context), context),
            toDouble (vtmin (context), context),
            toDouble (yp (context), context)
        )
    }
}

/**
 * Modification of an old IEEE ST1A static excitation system without overexcitation limiter (OEL) and underexcitation limiter (UEL).
 */
case class ExcST1A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter output current limit reference (Ilr).
     * Typical Value = 0.
     */
    val ilr: Double,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 190.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.05.
     */
    val kc: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.
     */
    val kf: Double,

    /**
     * Exciter output current limiter gain (Klr).
     * Typical Value = 0.
     */
    val klr: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 10.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tb<sub>1</sub>).
     * Typical Value = 0.
     */
    val tb1: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Voltage regulator time constant (Tc<sub>1</sub>).
     * Typical Value = 0.
     */
    val tc1: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Maximum voltage regulator output (Vamax).
     * Typical Value = 999.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (Vamin).
     * Typical Value = -999.
     */
    val vamin: Double,

    /**
     * Maximum voltage regulator input limit (Vimax).
     * Typical Value = 999.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (Vimin).
     * Typical Value = -999.
     */
    val vimin: Double,

    /**
     * Maximum voltage regulator outputs (Vrmax).
     * Typical Value = 7.8.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (Vrmin).
     * Typical Value = -6.7.
     */
    val vrmin: Double,

    /**
     * Excitation xfmr effective reactance (Xe).
     * Typical Value = 0.04.
     */
    val xe: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST1A
extends
    Parseable[ExcST1A]
{
    val sup = ExcitationSystemDynamics.parse _
    val ilr = parse_element (element ("""ExcST1A.ilr"""))_
    val ka = parse_element (element ("""ExcST1A.ka"""))_
    val kc = parse_element (element ("""ExcST1A.kc"""))_
    val kf = parse_element (element ("""ExcST1A.kf"""))_
    val klr = parse_element (element ("""ExcST1A.klr"""))_
    val ta = parse_element (element ("""ExcST1A.ta"""))_
    val tb = parse_element (element ("""ExcST1A.tb"""))_
    val tb1 = parse_element (element ("""ExcST1A.tb1"""))_
    val tc = parse_element (element ("""ExcST1A.tc"""))_
    val tc1 = parse_element (element ("""ExcST1A.tc1"""))_
    val tf = parse_element (element ("""ExcST1A.tf"""))_
    val vamax = parse_element (element ("""ExcST1A.vamax"""))_
    val vamin = parse_element (element ("""ExcST1A.vamin"""))_
    val vimax = parse_element (element ("""ExcST1A.vimax"""))_
    val vimin = parse_element (element ("""ExcST1A.vimin"""))_
    val vrmax = parse_element (element ("""ExcST1A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST1A.vrmin"""))_
    val xe = parse_element (element ("""ExcST1A.xe"""))_
    def parse (context: Context): ExcST1A =
    {
        ExcST1A(
            sup (context),
            toDouble (ilr (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (kf (context), context),
            toDouble (klr (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tb1 (context), context),
            toDouble (tc (context), context),
            toDouble (tc1 (context), context),
            toDouble (tf (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xe (context), context)
        )
    }
}

/**
 * Modified IEEE ST2A static excitation system - another lead-lag block added to match  the model defined by WECC.
 */
case class ExcST2A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum field voltage (Efdmax).
     * Typical Value = 99.
     */
    val efdmax: Double,

    /**
     * Voltage regulator gain (Ka).
     * Typical Value = 120.
     */
    val ka: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 1.82.
     */
    val kc: Double,

    /**
     * Exciter constant related to self-excited field (Ke).
     * Typical Value = 1.
     */
    val ke: Double,

    /**
     * Excitation control system stabilizer gains (Kf).
     * Typical Value = 0.05.
     */
    val kf: Double,

    /**
     * Potential circuit gain coefficient (Ki).
     * Typical Value = 8.
     */
    val ki: Double,

    /**
     * Potential circuit gain coefficient (Kp).
     * Typical Value = 4.88.
     */
    val kp: Double,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.15.
     */
    val ta: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Exciter time constant, integration rate associated with exciter control (Te).
     * Typical Value = 0.5.
     */
    val te: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 0.7.
     */
    val tf: Double,

    /**
     * UEL input (UELin).
    true = HV gate
    false = add to error signal.
     * Typical Value = false.
     */
    val uelin: Boolean,

    /**
     * Maximum voltage regulator outputs (Vrmax).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator outputs (Vrmin).
     * Typical Value = -1.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST2A
extends
    Parseable[ExcST2A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcST2A.efdmax"""))_
    val ka = parse_element (element ("""ExcST2A.ka"""))_
    val kc = parse_element (element ("""ExcST2A.kc"""))_
    val ke = parse_element (element ("""ExcST2A.ke"""))_
    val kf = parse_element (element ("""ExcST2A.kf"""))_
    val ki = parse_element (element ("""ExcST2A.ki"""))_
    val kp = parse_element (element ("""ExcST2A.kp"""))_
    val ta = parse_element (element ("""ExcST2A.ta"""))_
    val tb = parse_element (element ("""ExcST2A.tb"""))_
    val tc = parse_element (element ("""ExcST2A.tc"""))_
    val te = parse_element (element ("""ExcST2A.te"""))_
    val tf = parse_element (element ("""ExcST2A.tf"""))_
    val uelin = parse_element (element ("""ExcST2A.uelin"""))_
    val vrmax = parse_element (element ("""ExcST2A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST2A.vrmin"""))_
    def parse (context: Context): ExcST2A =
    {
        ExcST2A(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (ka (context), context),
            toDouble (kc (context), context),
            toDouble (ke (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (te (context), context),
            toDouble (tf (context), context),
            toBoolean (uelin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Modified IEEE ST3A static excitation system with added speed multiplier.
 */
case class ExcST3A
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Maximum AVR output (Efdmax).
     * Typical Value = 6.9.
     */
    val efdmax: Double,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 1.1.
     */
    val kc: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (Kg).
     * Typical Value = 1.
     */
    val kg: Double,

    /**
     * Potential circuit gain coefficient (Ki).
     * Typical Value = 4.83.
     */
    val ki: Double,

    /**
     * AVR gain (Kj).
     * Typical Value = 200.
     */
    val kj: Double,

    /**
     * Forward gain constant of the inner loop field regulator (Km).
     * Typical Value = 7.04.
     */
    val km: Double,

    /**
     * Potential source gain (Kp) (&gt;0).
     * Typical Value = 4.37.
     */
    val kp: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks).
     * Typical Value = 0.
     */
    val ks: Double,

    /**
     * Coefficient to allow different usage of the model-speed coefficient (Ks1).
     * Typical Value = 0.
     */
    val ks1: Double,

    /**
     * Voltage regulator time constant (Tb).
     * Typical Value = 6.67.
     */
    val tb: Double,

    /**
     * Voltage regulator time constant (Tc).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Potential circuit phase angle (thetap).
     * Typical Value = 20.
     */
    val thetap: Double,

    /**
     * Forward time constant of inner loop field regulator (Tm).
     * Typical Value = 1.
     */
    val tm: Double,

    /**
     * Maximum excitation voltage (Vbmax).
     * Typical Value = 8.63.
     */
    val vbmax: Double,

    /**
     * Maximum inner loop feedback voltage (Vgmax).
     * Typical Value = 6.53.
     */
    val vgmax: Double,

    /**
     * Maximum voltage regulator input limit (Vimax).
     * Typical Value = 0.2.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (Vimin).
     * Typical Value = -0.2.
     */
    val vimin: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = 0.
     */
    val vrmin: Double,

    /**
     * Reactance associated with potential source (Xl).
     * Typical Value = 0.09.
     */
    val xl: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST3A
extends
    Parseable[ExcST3A]
{
    val sup = ExcitationSystemDynamics.parse _
    val efdmax = parse_element (element ("""ExcST3A.efdmax"""))_
    val kc = parse_element (element ("""ExcST3A.kc"""))_
    val kg = parse_element (element ("""ExcST3A.kg"""))_
    val ki = parse_element (element ("""ExcST3A.ki"""))_
    val kj = parse_element (element ("""ExcST3A.kj"""))_
    val km = parse_element (element ("""ExcST3A.km"""))_
    val kp = parse_element (element ("""ExcST3A.kp"""))_
    val ks = parse_element (element ("""ExcST3A.ks"""))_
    val ks1 = parse_element (element ("""ExcST3A.ks1"""))_
    val tb = parse_element (element ("""ExcST3A.tb"""))_
    val tc = parse_element (element ("""ExcST3A.tc"""))_
    val thetap = parse_element (element ("""ExcST3A.thetap"""))_
    val tm = parse_element (element ("""ExcST3A.tm"""))_
    val vbmax = parse_element (element ("""ExcST3A.vbmax"""))_
    val vgmax = parse_element (element ("""ExcST3A.vgmax"""))_
    val vimax = parse_element (element ("""ExcST3A.vimax"""))_
    val vimin = parse_element (element ("""ExcST3A.vimin"""))_
    val vrmax = parse_element (element ("""ExcST3A.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST3A.vrmin"""))_
    val xl = parse_element (element ("""ExcST3A.xl"""))_
    def parse (context: Context): ExcST3A =
    {
        ExcST3A(
            sup (context),
            toDouble (efdmax (context), context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (kj (context), context),
            toDouble (km (context), context),
            toDouble (kp (context), context),
            toDouble (ks (context), context),
            toDouble (ks1 (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (thetap (context), context),
            toDouble (tm (context), context),
            toDouble (vbmax (context), context),
            toDouble (vgmax (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xl (context), context)
        )
    }
}

/**
 * Modified IEEE ST4B static excitation system with maximum inner loop feedback gain <b>Vgmax</b>.
 */
case class ExcST4B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Rectifier loading factor proportional to commutating reactance (Kc).
     * Typical Value = 0.113.
     */
    val kc: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (Kg).
     * Typical Value = 0.
     */
    val kg: Double,

    /**
     * Potential circuit gain coefficient (Ki).
     * Typical Value = 0.
     */
    val ki: Double,

    /**
     * Voltage regulator integral gain output (Kim).
     * Typical Value = 0.
     */
    val kim: Double,

    /**
     * Voltage regulator integral gain (Kir).
     * Typical Value = 10.75.
     */
    val kir: Double,

    /**
     * Potential circuit gain coefficient (Kp).
     * Typical Value = 9.3.
     */
    val kp: Double,

    /**
     * Voltage regulator proportional gain output (Kpm).
     * Typical Value = 1.
     */
    val kpm: Double,

    /**
     * Voltage regulator proportional gain (Kpr).
     * Typical Value = 10.75.
     */
    val kpr: Double,

    /**
     * Selector (LVgate).
    true = LVgate is part of the block diagram
    false = LVgate is not part of the block diagram.
     * Typical Value = false.
     */
    val lvgate: Boolean,

    /**
     * Voltage regulator time constant (Ta).
     * Typical Value = 0.02.
     */
    val ta: Double,

    /**
     * Potential circuit phase angle (thetap).
     * Typical Value = 0.
     */
    val thetap: Double,

    /**
     * Selector (Uel).
    true = UEL is part of block diagram
    false = UEL is not part of block diagram.
     * Typical Value = false.
     */
    val uel: Boolean,

    /**
     * Maximum excitation voltage (Vbmax).
     * Typical Value = 11.63.
     */
    val vbmax: Double,

    /**
     * Maximum inner loop feedback voltage (Vgmax).
     * Typical Value = 5.8.
     */
    val vgmax: Double,

    /**
     * Maximum inner loop output (Vmmax).
     * Typical Value = 99.
     */
    val vmmax: Double,

    /**
     * Minimum inner loop output (Vmmin).
     * Typical Value = -99.
     */
    val vmmin: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 1.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -0.87.
     */
    val vrmin: Double,

    /**
     * Reactance associated with potential source (Xl).
     * Typical Value = 0.124.
     */
    val xl: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST4B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST4B
extends
    Parseable[ExcST4B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kc = parse_element (element ("""ExcST4B.kc"""))_
    val kg = parse_element (element ("""ExcST4B.kg"""))_
    val ki = parse_element (element ("""ExcST4B.ki"""))_
    val kim = parse_element (element ("""ExcST4B.kim"""))_
    val kir = parse_element (element ("""ExcST4B.kir"""))_
    val kp = parse_element (element ("""ExcST4B.kp"""))_
    val kpm = parse_element (element ("""ExcST4B.kpm"""))_
    val kpr = parse_element (element ("""ExcST4B.kpr"""))_
    val lvgate = parse_element (element ("""ExcST4B.lvgate"""))_
    val ta = parse_element (element ("""ExcST4B.ta"""))_
    val thetap = parse_element (element ("""ExcST4B.thetap"""))_
    val uel = parse_element (element ("""ExcST4B.uel"""))_
    val vbmax = parse_element (element ("""ExcST4B.vbmax"""))_
    val vgmax = parse_element (element ("""ExcST4B.vgmax"""))_
    val vmmax = parse_element (element ("""ExcST4B.vmmax"""))_
    val vmmin = parse_element (element ("""ExcST4B.vmmin"""))_
    val vrmax = parse_element (element ("""ExcST4B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST4B.vrmin"""))_
    val xl = parse_element (element ("""ExcST4B.xl"""))_
    def parse (context: Context): ExcST4B =
    {
        ExcST4B(
            sup (context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (kim (context), context),
            toDouble (kir (context), context),
            toDouble (kp (context), context),
            toDouble (kpm (context), context),
            toDouble (kpr (context), context),
            toBoolean (lvgate (context), context),
            toDouble (ta (context), context),
            toDouble (thetap (context), context),
            toBoolean (uel (context), context),
            toDouble (vbmax (context), context),
            toDouble (vgmax (context), context),
            toDouble (vmmax (context), context),
            toDouble (vmmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xl (context), context)
        )
    }
}

/**
 * Modified IEEE ST6B static excitation system with PID controller and optional inner feedbacks loop.
 */
case class ExcST6B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Exciter output current limit reference (Ilr).
     * Typical Value = 4.164.
     */
    val ilr: Double,

    /**
     * Selector (K1).
    true = feedback is from Ifd
    false = feedback is not from Ifd.
     * Typical Value = true.
     */
    val k1: Boolean,

    /**
     * Exciter output current limit adjustment (Kcl).
     * Typical Value = 1.0577.
     */
    val kcl: Double,

    /**
     * Pre-control gain constant of the inner loop field regulator (Kff).
     * Typical Value = 1.
     */
    val kff: Double,

    /**
     * Feedback gain constant of the inner loop field regulator (Kg).
     * Typical Value = 1.
     */
    val kg: Double,

    /**
     * Voltage regulator integral gain (Kia).
     * Typical Value = 45.094.
     */
    val kia: Double,

    /**
     * Exciter output current limit adjustment (Kcl).
     * Typical Value = 17.33.
     */
    val klr: Double,

    /**
     * Forward gain constant of the inner loop field regulator (Km).
     * Typical Value = 1.
     */
    val km: Double,

    /**
     * Voltage regulator proportional gain (Kpa).
     * Typical Value = 18.038.
     */
    val kpa: Double,

    /**
     * Voltage regulator derivative gain (Kvd).
     * Typical Value = 0.
     */
    val kvd: Double,

    /**
     * OEL input selector (OELin).
     * Typical Value = noOELinput.
     */
    val oelin: String,

    /**
     * Feedback time constant of inner loop field voltage regulator (Tg).
     * Typical Value = 0.02.
     */
    val tg: Double,

    /**
     * Rectifier firing time constant (Ts).
     * Typical Value = 0.
     */
    val ts: Double,

    /**
     * Voltage regulator derivative gain (Tvd).
     * Typical Value = 0.
     */
    val tvd: Double,

    /**
     * Maximum voltage regulator output (Vamax).
     * Typical Value = 4.81.
     */
    val vamax: Double,

    /**
     * Minimum voltage regulator output (Vamin).
     * Typical Value = -3.85.
     */
    val vamin: Double,

    /**
     * Selector (Vilim).
    true = Vimin-Vimax limiter is active
    false = Vimin-Vimax limiter is not active.
     * Typical Value = true.
     */
    val vilim: Boolean,

    /**
     * Maximum voltage regulator input limit (Vimax).
     * Typical Value = 10.
     */
    val vimax: Double,

    /**
     * Minimum voltage regulator input limit (Vimin).
     * Typical Value = -10.
     */
    val vimin: Double,

    /**
     * Selector (Vmult).
    true = multiply regulator output by terminal voltage
    false = do not multiply regulator output by terminal voltage.
     * Typical Value = true.
     */
    val vmult: Boolean,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 4.81.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -3.85.
     */
    val vrmin: Double,

    /**
     * Excitation source reactance (Xc).
     * Typical Value = 0.05.
     */
    val xc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST6B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST6B
extends
    Parseable[ExcST6B]
{
    val sup = ExcitationSystemDynamics.parse _
    val ilr = parse_element (element ("""ExcST6B.ilr"""))_
    val k1 = parse_element (element ("""ExcST6B.k1"""))_
    val kcl = parse_element (element ("""ExcST6B.kcl"""))_
    val kff = parse_element (element ("""ExcST6B.kff"""))_
    val kg = parse_element (element ("""ExcST6B.kg"""))_
    val kia = parse_element (element ("""ExcST6B.kia"""))_
    val klr = parse_element (element ("""ExcST6B.klr"""))_
    val km = parse_element (element ("""ExcST6B.km"""))_
    val kpa = parse_element (element ("""ExcST6B.kpa"""))_
    val kvd = parse_element (element ("""ExcST6B.kvd"""))_
    val oelin = parse_attribute (attribute ("""ExcST6B.oelin"""))_
    val tg = parse_element (element ("""ExcST6B.tg"""))_
    val ts = parse_element (element ("""ExcST6B.ts"""))_
    val tvd = parse_element (element ("""ExcST6B.tvd"""))_
    val vamax = parse_element (element ("""ExcST6B.vamax"""))_
    val vamin = parse_element (element ("""ExcST6B.vamin"""))_
    val vilim = parse_element (element ("""ExcST6B.vilim"""))_
    val vimax = parse_element (element ("""ExcST6B.vimax"""))_
    val vimin = parse_element (element ("""ExcST6B.vimin"""))_
    val vmult = parse_element (element ("""ExcST6B.vmult"""))_
    val vrmax = parse_element (element ("""ExcST6B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST6B.vrmin"""))_
    val xc = parse_element (element ("""ExcST6B.xc"""))_
    def parse (context: Context): ExcST6B =
    {
        ExcST6B(
            sup (context),
            toDouble (ilr (context), context),
            toBoolean (k1 (context), context),
            toDouble (kcl (context), context),
            toDouble (kff (context), context),
            toDouble (kg (context), context),
            toDouble (kia (context), context),
            toDouble (klr (context), context),
            toDouble (km (context), context),
            toDouble (kpa (context), context),
            toDouble (kvd (context), context),
            oelin (context),
            toDouble (tg (context), context),
            toDouble (ts (context), context),
            toDouble (tvd (context), context),
            toDouble (vamax (context), context),
            toDouble (vamin (context), context),
            toBoolean (vilim (context), context),
            toDouble (vimax (context), context),
            toDouble (vimin (context), context),
            toBoolean (vmult (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context),
            toDouble (xc (context), context)
        )
    }
}

/**
 * Type of connection for the OEL input used for static excitation systems type 6B.
 */
case class ExcST6BOELselectorKind
(

    override val sup: BasicElement,

    /**
     * The connection is after UEL.
     */
    val afterUEL: String,

    /**
     * The connection is before UEL.
     */
    val beforeUEL: String,

    /**
     * No OEL input is used.
     */
    val noOELinput: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST6BOELselectorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST6BOELselectorKind
extends
    Parseable[ExcST6BOELselectorKind]
{
    val sup = BasicElement.parse _
    val afterUEL = parse_attribute (attribute ("""ExcST6BOELselectorKind.afterUEL"""))_
    val beforeUEL = parse_attribute (attribute ("""ExcST6BOELselectorKind.beforeUEL"""))_
    val noOELinput = parse_attribute (attribute ("""ExcST6BOELselectorKind.noOELinput"""))_
    def parse (context: Context): ExcST6BOELselectorKind =
    {
        ExcST6BOELselectorKind(
            sup (context),
            afterUEL (context),
            beforeUEL (context),
            noOELinput (context)
        )
    }
}

/**
 * Modified IEEE ST7B static excitation system without stator current limiter (SCL) and current compensator (DROOP) inputs.
 */
case class ExcST7B
(

    override val sup: ExcitationSystemDynamics,

    /**
     * High-value gate feedback gain (Kh).
     * Typical Value = 1.
     */
    val kh: Double,

    /**
     * Voltage regulator integral gain (Kia).
     * Typical Value = 1.
     */
    val kia: Double,

    /**
     * Low-value gate feedback gain (Kl).
     * Typical Value = 1.
     */
    val kl: Double,

    /**
     * Voltage regulator proportional gain (Kpa).
     * Typical Value = 40.
     */
    val kpa: Double,

    /**
     * OEL input selector (OELin).
     * Typical Value = noOELinput.
     */
    val oelin: String,

    /**
     * Regulator lag time constant (Tb).
     * Typical Value = 1.
     */
    val tb: Double,

    /**
     * Regulator lead time constant (Tc).
     * Typical Value = 1.
     */
    val tc: Double,

    /**
     * Excitation control system stabilizer time constant (Tf).
     * Typical Value = 1.
     */
    val tf: Double,

    /**
     * Feedback time constant of inner loop field voltage regulator (Tg).
     * Typical Value = 1.
     */
    val tg: Double,

    /**
     * Feedback time constant (Tia).
     * Typical Value = 3.
     */
    val tia: Double,

    /**
     * Rectifier firing time constant (Ts).
     * Typical Value = 0.
     */
    val ts: Double,

    /**
     * UEL input selector (UELin).
     * Typical Value = noUELinput.
     */
    val uelin: String,

    /**
     * Maximum voltage reference signal (Vmax).
     * Typical Value = 1.1.
     */
    val vmax: Double,

    /**
     * Minimum voltage reference signal (Vmin).
     * Typical Value = 0.9.
     */
    val vmin: Double,

    /**
     * Maximum voltage regulator output (Vrmax).
     * Typical Value = 5.
     */
    val vrmax: Double,

    /**
     * Minimum voltage regulator output (Vrmin).
     * Typical Value = -4.5.
     */
    val vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST7B]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST7B
extends
    Parseable[ExcST7B]
{
    val sup = ExcitationSystemDynamics.parse _
    val kh = parse_element (element ("""ExcST7B.kh"""))_
    val kia = parse_element (element ("""ExcST7B.kia"""))_
    val kl = parse_element (element ("""ExcST7B.kl"""))_
    val kpa = parse_element (element ("""ExcST7B.kpa"""))_
    val oelin = parse_attribute (attribute ("""ExcST7B.oelin"""))_
    val tb = parse_element (element ("""ExcST7B.tb"""))_
    val tc = parse_element (element ("""ExcST7B.tc"""))_
    val tf = parse_element (element ("""ExcST7B.tf"""))_
    val tg = parse_element (element ("""ExcST7B.tg"""))_
    val tia = parse_element (element ("""ExcST7B.tia"""))_
    val ts = parse_element (element ("""ExcST7B.ts"""))_
    val uelin = parse_attribute (attribute ("""ExcST7B.uelin"""))_
    val vmax = parse_element (element ("""ExcST7B.vmax"""))_
    val vmin = parse_element (element ("""ExcST7B.vmin"""))_
    val vrmax = parse_element (element ("""ExcST7B.vrmax"""))_
    val vrmin = parse_element (element ("""ExcST7B.vrmin"""))_
    def parse (context: Context): ExcST7B =
    {
        ExcST7B(
            sup (context),
            toDouble (kh (context), context),
            toDouble (kia (context), context),
            toDouble (kl (context), context),
            toDouble (kpa (context), context),
            oelin (context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (tf (context), context),
            toDouble (tg (context), context),
            toDouble (tia (context), context),
            toDouble (ts (context), context),
            uelin (context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context),
            toDouble (vrmax (context), context),
            toDouble (vrmin (context), context)
        )
    }
}

/**
 * Type of connection for the OEL input used for static excitation systems type 7B.
 */
case class ExcST7BOELselectorKind
(

    override val sup: BasicElement,

    /**
     * The signal is added to Vref.
     */
    val addVref: String,

    /**
     * The signal is connected in the input of the LV gate.
     */
    val inputLVgate: String,

    /**
     * No OEL input is used.
     */
    val noOELinput: String,

    /**
     * The signal is connected in the output of the LV gate.
     */
    val outputLVgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST7BOELselectorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST7BOELselectorKind
extends
    Parseable[ExcST7BOELselectorKind]
{
    val sup = BasicElement.parse _
    val addVref = parse_attribute (attribute ("""ExcST7BOELselectorKind.addVref"""))_
    val inputLVgate = parse_attribute (attribute ("""ExcST7BOELselectorKind.inputLVgate"""))_
    val noOELinput = parse_attribute (attribute ("""ExcST7BOELselectorKind.noOELinput"""))_
    val outputLVgate = parse_attribute (attribute ("""ExcST7BOELselectorKind.outputLVgate"""))_
    def parse (context: Context): ExcST7BOELselectorKind =
    {
        ExcST7BOELselectorKind(
            sup (context),
            addVref (context),
            inputLVgate (context),
            noOELinput (context),
            outputLVgate (context)
        )
    }
}

/**
 * Type of connection for the UEL input used for static excitation systems type 7B.
 */
case class ExcST7BUELselectorKind
(

    override val sup: BasicElement,

    /**
     * The signal is added to Vref.
     */
    val addVref: String,

    /**
     * The signal is connected in the input of the HV gate.
     */
    val inputHVgate: String,

    /**
     * No UEL input is used.
     */
    val noUELinput: String,

    /**
     * The signal is connected in the output of the HV gate.
     */
    val outputHVgate: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcST7BUELselectorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcST7BUELselectorKind
extends
    Parseable[ExcST7BUELselectorKind]
{
    val sup = BasicElement.parse _
    val addVref = parse_attribute (attribute ("""ExcST7BUELselectorKind.addVref"""))_
    val inputHVgate = parse_attribute (attribute ("""ExcST7BUELselectorKind.inputHVgate"""))_
    val noUELinput = parse_attribute (attribute ("""ExcST7BUELselectorKind.noUELinput"""))_
    val outputHVgate = parse_attribute (attribute ("""ExcST7BUELselectorKind.outputHVgate"""))_
    def parse (context: Context): ExcST7BUELselectorKind =
    {
        ExcST7BUELselectorKind(
            sup (context),
            addVref (context),
            inputHVgate (context),
            noUELinput (context),
            outputHVgate (context)
        )
    }
}

/**
 * Excitation system function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 */
case class ExcitationSystemDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Discontinuous excitation control model associated with this excitation system model.
     */
    val DiscontinuousExcitationControlDynamics: String,

    /**
     * Overexcitation limiter model associated with this excitation system model.
     */
    val OverexcitationLimiterDynamics: String,

    /**
     * Power Factor or VAr controller Type I model associated with this excitation system model.
     */
    val PFVArControllerType1Dynamics: String,

    /**
     * Power Factor or VAr controller Type II model associated with this excitation system model.
     */
    val PFVArControllerType2Dynamics: String,

    /**
     * Power system stabilizer model associated with this excitation system model.
     */
    val PowerSystemStabilizerDynamics: String,

    /**
     * Synchronous machine model with which this excitation system model is associated.
     */
    val SynchronousMachineDynamics: String,

    /**
     * Undrexcitation limiter model associated with this excitation system model.
     */
    val UnderexcitationLimiterDynamics: String,

    /**
     * Voltage compensator model associated with this excitation system model.
     */
    val VoltageCompensatorDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcitationSystemDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcitationSystemDynamics
extends
    Parseable[ExcitationSystemDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val DiscontinuousExcitationControlDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.DiscontinuousExcitationControlDynamics"""))_
    val OverexcitationLimiterDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.OverexcitationLimiterDynamics"""))_
    val PFVArControllerType1Dynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PFVArControllerType1Dynamics"""))_
    val PFVArControllerType2Dynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PFVArControllerType2Dynamics"""))_
    val PowerSystemStabilizerDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PowerSystemStabilizerDynamics"""))_
    val SynchronousMachineDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.SynchronousMachineDynamics"""))_
    val UnderexcitationLimiterDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.UnderexcitationLimiterDynamics"""))_
    val VoltageCompensatorDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.VoltageCompensatorDynamics"""))_
    def parse (context: Context): ExcitationSystemDynamics =
    {
        ExcitationSystemDynamics(
            sup (context),
            DiscontinuousExcitationControlDynamics (context),
            OverexcitationLimiterDynamics (context),
            PFVArControllerType1Dynamics (context),
            PFVArControllerType2Dynamics (context),
            PowerSystemStabilizerDynamics (context),
            SynchronousMachineDynamics (context),
            UnderexcitationLimiterDynamics (context),
            VoltageCompensatorDynamics (context)
        )
    }
}

object _ExcitationSystemDynamics
{
    def register: Unit =
    {
        ExcAC1A.register
        ExcAC2A.register
        ExcAC3A.register
        ExcAC4A.register
        ExcAC5A.register
        ExcAC6A.register
        ExcAC8B.register
        ExcANS.register
        ExcAVR1.register
        ExcAVR2.register
        ExcAVR3.register
        ExcAVR4.register
        ExcAVR5.register
        ExcAVR7.register
        ExcBBC.register
        ExcCZ.register
        ExcDC1A.register
        ExcDC2A.register
        ExcDC3A.register
        ExcDC3A1.register
        ExcELIN1.register
        ExcELIN2.register
        ExcHU.register
        ExcIEEEAC1A.register
        ExcIEEEAC2A.register
        ExcIEEEAC3A.register
        ExcIEEEAC4A.register
        ExcIEEEAC5A.register
        ExcIEEEAC6A.register
        ExcIEEEAC7B.register
        ExcIEEEAC8B.register
        ExcIEEEDC1A.register
        ExcIEEEDC2A.register
        ExcIEEEDC3A.register
        ExcIEEEDC4B.register
        ExcIEEEST1A.register
        ExcIEEEST1AUELselectorKind.register
        ExcIEEEST2A.register
        ExcIEEEST3A.register
        ExcIEEEST4B.register
        ExcIEEEST5B.register
        ExcIEEEST6B.register
        ExcIEEEST7B.register
        ExcOEX3T.register
        ExcPIC.register
        ExcREXS.register
        ExcREXSFeedbackSignalKind.register
        ExcSCRX.register
        ExcSEXS.register
        ExcSK.register
        ExcST1A.register
        ExcST2A.register
        ExcST3A.register
        ExcST4B.register
        ExcST6B.register
        ExcST6BOELselectorKind.register
        ExcST7B.register
        ExcST7BOELselectorKind.register
        ExcST7BUELselectorKind.register
        ExcitationSystemDynamics.register
    }
}