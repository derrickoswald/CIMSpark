package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The excitation system model provides the field voltage (Efd) for a synchronous machine model.
 * It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */

/**
 * Modified IEEE AC1A alternator-supplied rectifier excitation system with different rate feedback source.
 * @param sup Reference to the superclass object.
 * @param hvlvgates Indicates if both HV gate and LV gate are active (HVLVgates).
true = gates are used
false = gates are not used.
 *        Typical Value = true.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 400.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.2.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (Kd).
 *        Typical Value = 0.38.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.03.
 * @param kf1 Coefficient to allow different usage of the model (Kf1).
 *        Typical Value = 0.
 * @param kf2 Coefficient to allow different usage of the model (Kf2).
 *        Typical Value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
 *        Typical Value = 0.1.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
 *        Typical Value = 0.03.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>c</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 0.8.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>amax</sub>).
 *        Typical Value = 14.5.
 * @param vamin Minimum voltage regulator output (V<sub>amin</sub>).
 *        Typical Value = -14.5.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1).
 *        Typical Value = 4.18.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
 *        Typical Value = 3.14.
 * @param vrmax Maximum voltage regulator outputs (Vrmax).
 *        Typical Value = 6.03.
 * @param vrmin Minimum voltage regulator outputs (Rrmin).
 *        Typical Value = -5.43.
 */
case class ExcAC1A
(
    override val sup: ExcitationSystemDynamics,
    val hvlvgates: Boolean,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val kf1: Double,
    val kf2: Double,
    val ks: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vrmax: Double,
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
    val hvlvgates = parse_element (element ("""ExcAC1A.hvlvgates"""))
    val ka = parse_element (element ("""ExcAC1A.ka"""))
    val kc = parse_element (element ("""ExcAC1A.kc"""))
    val kd = parse_element (element ("""ExcAC1A.kd"""))
    val ke = parse_element (element ("""ExcAC1A.ke"""))
    val kf = parse_element (element ("""ExcAC1A.kf"""))
    val kf1 = parse_element (element ("""ExcAC1A.kf1"""))
    val kf2 = parse_element (element ("""ExcAC1A.kf2"""))
    val ks = parse_element (element ("""ExcAC1A.ks"""))
    val seve1 = parse_element (element ("""ExcAC1A.seve1"""))
    val seve2 = parse_element (element ("""ExcAC1A.seve2"""))
    val ta = parse_element (element ("""ExcAC1A.ta"""))
    val tb = parse_element (element ("""ExcAC1A.tb"""))
    val tc = parse_element (element ("""ExcAC1A.tc"""))
    val te = parse_element (element ("""ExcAC1A.te"""))
    val tf = parse_element (element ("""ExcAC1A.tf"""))
    val vamax = parse_element (element ("""ExcAC1A.vamax"""))
    val vamin = parse_element (element ("""ExcAC1A.vamin"""))
    val ve1 = parse_element (element ("""ExcAC1A.ve1"""))
    val ve2 = parse_element (element ("""ExcAC1A.ve2"""))
    val vrmax = parse_element (element ("""ExcAC1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param hvgate Indicates if HV gate is active (HVgate).
true = gate is used
false = gate is not used.
 *        Typical Value = true.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 400.
 * @param kb Second stage regulator gain (Kb) (&gt;0).
 *        Exciter field current controller gain.  Typical Value = 25.
 * @param kb1 Second stage regulator gain (Kb1).
 *        It is exciter field current controller gain used as alternative to Kb to represent a variant of the ExcAC2A model.  Typical Value = 25.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.28.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (Kd).
 *        Typical Value = 0.35.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.03.
 * @param kh Exciter field current feedback gain (Kh).
 *        Typical Value = 1.
 * @param kl Exciter field current limiter gain (Kl).
 *        Typical Value = 10.
 * @param kl1 Coefficient to allow different usage of the model (Kl1).
 *        Typical Value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param lvgate Indicates if LV gate is active (LVgate).
true = gate is used
false = gate is not used.
 *        Typical Value = true.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve<sub>1</sub>]).
 *        Typical Value = 0.037.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve<sub>2</sub>]).
 *        Typical Value = 0.012.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>c</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 0.6.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>amax</sub>).
 *        Typical Value = 8.
 * @param vamin Minimum voltage regulator output (V<sub>amin</sub>).
 *        Typical Value = -8.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>).
 *        Typical Value = 4.4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
 *        Typical Value = 3.3.
 * @param vfemax Exciter field current limit reference (Vfemax).
 *        Typical Value = 4.4.
 * @param vlr Maximum exciter field current (Vlr).
 *        Typical Value = 4.4.
 * @param vrmax Maximum voltage regulator outputs (Vrmax).
 *        Typical Value = 105.
 * @param vrmin Minimum voltage regulator outputs (Vrmin).
 *        Typical Value = -95.
 */
case class ExcAC2A
(
    override val sup: ExcitationSystemDynamics,
    val hvgate: Boolean,
    val ka: Double,
    val kb: Double,
    val kb1: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val kh: Double,
    val kl: Double,
    val kl1: Double,
    val ks: Double,
    val lvgate: Boolean,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vfemax: Double,
    val vlr: Double,
    val vrmax: Double,
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
    val hvgate = parse_element (element ("""ExcAC2A.hvgate"""))
    val ka = parse_element (element ("""ExcAC2A.ka"""))
    val kb = parse_element (element ("""ExcAC2A.kb"""))
    val kb1 = parse_element (element ("""ExcAC2A.kb1"""))
    val kc = parse_element (element ("""ExcAC2A.kc"""))
    val kd = parse_element (element ("""ExcAC2A.kd"""))
    val ke = parse_element (element ("""ExcAC2A.ke"""))
    val kf = parse_element (element ("""ExcAC2A.kf"""))
    val kh = parse_element (element ("""ExcAC2A.kh"""))
    val kl = parse_element (element ("""ExcAC2A.kl"""))
    val kl1 = parse_element (element ("""ExcAC2A.kl1"""))
    val ks = parse_element (element ("""ExcAC2A.ks"""))
    val lvgate = parse_element (element ("""ExcAC2A.lvgate"""))
    val seve1 = parse_element (element ("""ExcAC2A.seve1"""))
    val seve2 = parse_element (element ("""ExcAC2A.seve2"""))
    val ta = parse_element (element ("""ExcAC2A.ta"""))
    val tb = parse_element (element ("""ExcAC2A.tb"""))
    val tc = parse_element (element ("""ExcAC2A.tc"""))
    val te = parse_element (element ("""ExcAC2A.te"""))
    val tf = parse_element (element ("""ExcAC2A.tf"""))
    val vamax = parse_element (element ("""ExcAC2A.vamax"""))
    val vamin = parse_element (element ("""ExcAC2A.vamin"""))
    val ve1 = parse_element (element ("""ExcAC2A.ve1"""))
    val ve2 = parse_element (element ("""ExcAC2A.ve2"""))
    val vfemax = parse_element (element ("""ExcAC2A.vfemax"""))
    val vlr = parse_element (element ("""ExcAC2A.vlr"""))
    val vrmax = parse_element (element ("""ExcAC2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC2A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efdn Value of <i>EFD </i>at which feedback gain changes (Efdn).
 *        Typical Value = 2.36.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 45.62.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.104.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (Kd).
 *        Typical Value = 0.499.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.143.
 * @param kf1 Coefficient to allow different usage of the model (Kf1).
 *        Typical Value = 1.
 * @param kf2 Coefficient to allow different usage of the model (Kf2).
 *        Typical Value = 0.
 * @param klv Gain used in the minimum field voltage limiter loop (Klv).
 *        Typical Value = 0.194.
 * @param kn Excitation control system stabilizer gain (Kn).
 *        Typical Value =0.05.
 * @param kr Constant associated with regulator and alternator field power supply (Kr).
 *        Typical Value =3.77.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve<sub>1</sub>]).
 *        Typical Value = 1.143.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve<sub>2</sub>]).
 *        Typical Value = 0.1.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.013.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>c</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.17.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>amax</sub>).
 *        Typical Value = 1.
 * @param vamin Minimum voltage regulator output (V<sub>amin</sub>).
 *        Typical Value = -0.95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1) equals Vemax (Ve1).
 *        Typical Value = 6.24.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
 *        Typical Value = 4.68.
 * @param vemin Minimum exciter voltage output (Vemin).
 *        Typical Value = 0.1.
 * @param vfemax Exciter field current limit reference (Vfemax).
 *        Typical Value = 16.
 * @param vlv Field voltage used in the minimum field voltage limiter loop (Vlv).
 *        Typical Value = 0.79.
 */
case class ExcAC3A
(
    override val sup: ExcitationSystemDynamics,
    val efdn: Double,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val kf1: Double,
    val kf2: Double,
    val klv: Double,
    val kn: Double,
    val kr: Double,
    val ks: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vemin: Double,
    val vfemax: Double,
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
    val efdn = parse_element (element ("""ExcAC3A.efdn"""))
    val ka = parse_element (element ("""ExcAC3A.ka"""))
    val kc = parse_element (element ("""ExcAC3A.kc"""))
    val kd = parse_element (element ("""ExcAC3A.kd"""))
    val ke = parse_element (element ("""ExcAC3A.ke"""))
    val kf = parse_element (element ("""ExcAC3A.kf"""))
    val kf1 = parse_element (element ("""ExcAC3A.kf1"""))
    val kf2 = parse_element (element ("""ExcAC3A.kf2"""))
    val klv = parse_element (element ("""ExcAC3A.klv"""))
    val kn = parse_element (element ("""ExcAC3A.kn"""))
    val kr = parse_element (element ("""ExcAC3A.kr"""))
    val ks = parse_element (element ("""ExcAC3A.ks"""))
    val seve1 = parse_element (element ("""ExcAC3A.seve1"""))
    val seve2 = parse_element (element ("""ExcAC3A.seve2"""))
    val ta = parse_element (element ("""ExcAC3A.ta"""))
    val tb = parse_element (element ("""ExcAC3A.tb"""))
    val tc = parse_element (element ("""ExcAC3A.tc"""))
    val te = parse_element (element ("""ExcAC3A.te"""))
    val tf = parse_element (element ("""ExcAC3A.tf"""))
    val vamax = parse_element (element ("""ExcAC3A.vamax"""))
    val vamin = parse_element (element ("""ExcAC3A.vamin"""))
    val ve1 = parse_element (element ("""ExcAC3A.ve1"""))
    val ve2 = parse_element (element ("""ExcAC3A.ve2"""))
    val vemin = parse_element (element ("""ExcAC3A.vemin"""))
    val vfemax = parse_element (element ("""ExcAC3A.vfemax"""))
    val vlv = parse_element (element ("""ExcAC3A.vlv"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.015.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 10.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 1.
 * @param vimax Maximum voltage regulator input limit (Vimax).
 *        Typical Value = 10.
 * @param vimin Minimum voltage regulator input limit (Vimin).
 *        Typical Value = -10.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 5.64.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -4.53.
 */
case class ExcAC4A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val vimax: Double,
    val vimin: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcAC4A.ka"""))
    val kc = parse_element (element ("""ExcAC4A.kc"""))
    val ta = parse_element (element ("""ExcAC4A.ta"""))
    val tb = parse_element (element ("""ExcAC4A.tb"""))
    val tc = parse_element (element ("""ExcAC4A.tc"""))
    val vimax = parse_element (element ("""ExcAC4A.vimax"""))
    val vimin = parse_element (element ("""ExcAC4A.vimin"""))
    val vrmax = parse_element (element ("""ExcAC4A.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC4A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param a Coefficient to allow different usage of the model (a).
 *        Typical Value = 1.
 * @param efd1 Exciter voltage at which exciter saturation is defined (Efd1).
 *        Typical Value = 5.6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (Efd2).
 *        Typical Value = 4.2.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 400.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.03.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, Efd1 (S<sub>E</sub>[Efd1]).
 *        Typical Value = 0.86.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, Efd2 (S<sub>E</sub>[Efd2]).
 *        Typical Value = 0.5.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 0.8.
 * @param tf1 Excitation control system stabilizer time constant (Tf1).
 *        Typical Value  = 1.
 * @param tf2 Excitation control system stabilizer time constant (Tf2).
 *        Typical Value = 0.8.
 * @param tf3 Excitation control system stabilizer time constant (Tf3).
 *        Typical Value = 0.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 7.3.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value =-7.3.
 */
case class ExcAC5A
(
    override val sup: ExcitationSystemDynamics,
    val a: Double,
    val efd1: Double,
    val efd2: Double,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val ks: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf1: Double,
    val tf2: Double,
    val tf3: Double,
    val vrmax: Double,
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
    val a = parse_element (element ("""ExcAC5A.a"""))
    val efd1 = parse_element (element ("""ExcAC5A.efd1"""))
    val efd2 = parse_element (element ("""ExcAC5A.efd2"""))
    val ka = parse_element (element ("""ExcAC5A.ka"""))
    val ke = parse_element (element ("""ExcAC5A.ke"""))
    val kf = parse_element (element ("""ExcAC5A.kf"""))
    val ks = parse_element (element ("""ExcAC5A.ks"""))
    val seefd1 = parse_element (element ("""ExcAC5A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcAC5A.seefd2"""))
    val ta = parse_element (element ("""ExcAC5A.ta"""))
    val tb = parse_element (element ("""ExcAC5A.tb"""))
    val tc = parse_element (element ("""ExcAC5A.tc"""))
    val te = parse_element (element ("""ExcAC5A.te"""))
    val tf1 = parse_element (element ("""ExcAC5A.tf1"""))
    val tf2 = parse_element (element ("""ExcAC5A.tf2"""))
    val tf3 = parse_element (element ("""ExcAC5A.tf3"""))
    val vrmax = parse_element (element ("""ExcAC5A.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC5A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 536.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.173.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (Kd).
 *        Typical Value = 1.91.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.6.
 * @param kh Exciter field current limiter gain (Kh).
 *        Typical Value = 92.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
 *        Typical Value = 0.214.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
 *        Typical Value = 0.044.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.086.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 9.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 3.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.
 * @param th Exciter field current limiter time constant (Th).
 *        Typical Value = 0.08.
 * @param tj Exciter field current limiter time constant (Tj).
 *        Typical Value = 0.02.
 * @param tk Voltage regulator time constant (Tk).
 *        Typical Value = 0.18.
 * @param vamax Maximum voltage regulator output (Vamax).
 *        Typical Value = 75.
 * @param vamin Minimum voltage regulator output (Vamin).
 *        Typical Value = -75.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>).
 *        Typical Value = 7.4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
 *        Typical Value = 5.55.
 * @param vfelim Exciter field current limit reference (Vfelim).
 *        Typical Value = 19.
 * @param vhmax Maximum field current limiter signal reference (Vhmax).
 *        Typical Value = 75.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 44.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -36.
 */
case class ExcAC6A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kh: Double,
    val ks: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val th: Double,
    val tj: Double,
    val tk: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vfelim: Double,
    val vhmax: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcAC6A.ka"""))
    val kc = parse_element (element ("""ExcAC6A.kc"""))
    val kd = parse_element (element ("""ExcAC6A.kd"""))
    val ke = parse_element (element ("""ExcAC6A.ke"""))
    val kh = parse_element (element ("""ExcAC6A.kh"""))
    val ks = parse_element (element ("""ExcAC6A.ks"""))
    val seve1 = parse_element (element ("""ExcAC6A.seve1"""))
    val seve2 = parse_element (element ("""ExcAC6A.seve2"""))
    val ta = parse_element (element ("""ExcAC6A.ta"""))
    val tb = parse_element (element ("""ExcAC6A.tb"""))
    val tc = parse_element (element ("""ExcAC6A.tc"""))
    val te = parse_element (element ("""ExcAC6A.te"""))
    val th = parse_element (element ("""ExcAC6A.th"""))
    val tj = parse_element (element ("""ExcAC6A.tj"""))
    val tk = parse_element (element ("""ExcAC6A.tk"""))
    val vamax = parse_element (element ("""ExcAC6A.vamax"""))
    val vamin = parse_element (element ("""ExcAC6A.vamin"""))
    val ve1 = parse_element (element ("""ExcAC6A.ve1"""))
    val ve2 = parse_element (element ("""ExcAC6A.ve2"""))
    val vfelim = parse_element (element ("""ExcAC6A.vfelim"""))
    val vhmax = parse_element (element ("""ExcAC6A.vhmax"""))
    val vrmax = parse_element (element ("""ExcAC6A.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC6A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param inlim Input limiter indicator.
true = input limiter Vimax and Vimin is considered
false = input limiter Vimax and Vimin is not considered.
 *        Typical Value = true.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 1.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.55.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (Kd).
 *        Typical Value = 1.1.
 * @param kdr Voltage regulator derivative gain (Kdr).
 *        Typical Value = 10.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kir Voltage regulator integral gain (Kir).
 *        Typical Value = 5.
 * @param kpr Voltage regulator proportional gain (Kpr).
 *        Typical Value = 80.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param pidlim PID limiter indicator.
true = input limiter Vpidmax and Vpidmin is considered
false = input limiter Vpidmax and Vpidmin is not considered.
 *        Typical Value = true.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>1</sub>, back of commutating reactance (Se[Ve1]).
 *        Typical Value = 0.3.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve<sub>2</sub>, back of commutating reactance (Se[Ve2]).
 *        Typical Value = 3.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.
 * @param tdr Lag time constant (Tdr).
 *        Typical Value = 0.1.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.2.
 * @param telim Selector for the limiter on the block [1/sTe].
 *        See diagram for meaning of true and false.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>1</sub>) equals V<sub>EMAX</sub> (Ve1).
 *        Typical Value = 6.5.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve<sub>2</sub>).
 *        Typical Value = 9.
 * @param vemin Minimum exciter voltage output (Vemin).
 *        Typical Value = 0.
 * @param vfemax Exciter field current limit reference (Vfemax).
 *        Typical Value = 6.
 * @param vimax Input signal maximum (Vimax).
 *        Typical Value = 35.
 * @param vimin Input signal minimum (Vimin).
 *        Typical Value = -10.
 * @param vpidmax PID maximum controller output (Vpidmax).
 *        Typical Value = 35.
 * @param vpidmin PID minimum controller output (Vpidmin).
 *        Typical Value = -10.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 35.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = 0.
 * @param vtmult Multiply by generator's terminal voltage indicator.
true =the limits Vrmax and Vrmin are multiplied by the generator�s terminal voltage to represent a thyristor power stage fed from the generator terminals
false = limits are not multiplied by generator's terminal voltage.
 *        Typical Value = false.
 */
case class ExcAC8B
(
    override val sup: ExcitationSystemDynamics,
    val inlim: Boolean,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val kdr: Double,
    val ke: Double,
    val kir: Double,
    val kpr: Double,
    val ks: Double,
    val pidlim: Boolean,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tdr: Double,
    val te: Double,
    val telim: Boolean,
    val ve1: Double,
    val ve2: Double,
    val vemin: Double,
    val vfemax: Double,
    val vimax: Double,
    val vimin: Double,
    val vpidmax: Double,
    val vpidmin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val inlim = parse_element (element ("""ExcAC8B.inlim"""))
    val ka = parse_element (element ("""ExcAC8B.ka"""))
    val kc = parse_element (element ("""ExcAC8B.kc"""))
    val kd = parse_element (element ("""ExcAC8B.kd"""))
    val kdr = parse_element (element ("""ExcAC8B.kdr"""))
    val ke = parse_element (element ("""ExcAC8B.ke"""))
    val kir = parse_element (element ("""ExcAC8B.kir"""))
    val kpr = parse_element (element ("""ExcAC8B.kpr"""))
    val ks = parse_element (element ("""ExcAC8B.ks"""))
    val pidlim = parse_element (element ("""ExcAC8B.pidlim"""))
    val seve1 = parse_element (element ("""ExcAC8B.seve1"""))
    val seve2 = parse_element (element ("""ExcAC8B.seve2"""))
    val ta = parse_element (element ("""ExcAC8B.ta"""))
    val tdr = parse_element (element ("""ExcAC8B.tdr"""))
    val te = parse_element (element ("""ExcAC8B.te"""))
    val telim = parse_element (element ("""ExcAC8B.telim"""))
    val ve1 = parse_element (element ("""ExcAC8B.ve1"""))
    val ve2 = parse_element (element ("""ExcAC8B.ve2"""))
    val vemin = parse_element (element ("""ExcAC8B.vemin"""))
    val vfemax = parse_element (element ("""ExcAC8B.vfemax"""))
    val vimax = parse_element (element ("""ExcAC8B.vimax"""))
    val vimin = parse_element (element ("""ExcAC8B.vimin"""))
    val vpidmax = parse_element (element ("""ExcAC8B.vpidmax"""))
    val vpidmin = parse_element (element ("""ExcAC8B.vpidmin"""))
    val vrmax = parse_element (element ("""ExcAC8B.vrmax"""))
    val vrmin = parse_element (element ("""ExcAC8B.vrmin"""))
    val vtmult = parse_element (element ("""ExcAC8B.vtmult"""))
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
 * @param sup Reference to the superclass object.
 * @param blint Governor Control Flag (BLINT). 
0 = lead-lag regulator
1 = proportional integral regulator.
 *        Typical Value = 0.
 * @param ifmn Minimum exciter current (I<sub>FMN</sub>).
 *        Typical Value = -5.2.
 * @param ifmx Maximum exciter current (I<sub>FMX</sub>).
 *        Typical Value = 6.5.
 * @param k2 Exciter gain (K<sub>2</sub>).
 *        Typical Value = 20.
 * @param k3 AVR gain (K<sub>3</sub>).
 *        Typical Value = 1000.
 * @param kce Ceiling factor (K<sub>CE</sub>).
 *        Typical Value = 1.
 * @param krvecc Feedback enabling (K<sub>RVECC</sub>). 
0 = Open loop control
1 = Closed loop control.
 *        Typical Value = 1.
 * @param kvfif Rate feedback signal flag (K<sub>VFIF</sub>). 
0 = output voltage of the exciter
1 = exciter field current.
 *        Typical Value = 0.
 * @param t1 Time constant (T<sub>1</sub>).
 *        Typical Value = 20.
 * @param t2 Time constant (T<sub>2</sub>).
 *        Typical Value = 0.05.
 * @param t3 Time constant (T<sub>3</sub>).
 *        Typical Value = 1.6.
 * @param tb Exciter time constant (T<sub>B</sub>).
 *        Typical Value = 0.04.
 * @param vrmn Minimum AVR output (V<sub>RMN</sub>).
 *        Typical Value = -5.2.
 * @param vrmx Maximum AVR output (V<sub>RMX</sub>).
 *        Typical Value = 6.5.
 */
case class ExcANS
(
    override val sup: ExcitationSystemDynamics,
    val blint: Int,
    val ifmn: Double,
    val ifmx: Double,
    val k2: Double,
    val k3: Double,
    val kce: Double,
    val krvecc: Int,
    val kvfif: Int,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val tb: Double,
    val vrmn: Double,
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
    val blint = parse_element (element ("""ExcANS.blint"""))
    val ifmn = parse_element (element ("""ExcANS.ifmn"""))
    val ifmx = parse_element (element ("""ExcANS.ifmx"""))
    val k2 = parse_element (element ("""ExcANS.k2"""))
    val k3 = parse_element (element ("""ExcANS.k3"""))
    val kce = parse_element (element ("""ExcANS.kce"""))
    val krvecc = parse_element (element ("""ExcANS.krvecc"""))
    val kvfif = parse_element (element ("""ExcANS.kvfif"""))
    val t1 = parse_element (element ("""ExcANS.t1"""))
    val t2 = parse_element (element ("""ExcANS.t2"""))
    val t3 = parse_element (element ("""ExcANS.t3"""))
    val tb = parse_element (element ("""ExcANS.tb"""))
    val vrmn = parse_element (element ("""ExcANS.vrmn"""))
    val vrmx = parse_element (element ("""ExcANS.vrmx"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Field voltage value 1  (E1).
 *        Typical Value = 4.18.
 * @param e2 Field voltage value 2 (E2).
 *        Typical Value = 3.14.
 * @param ka AVR gain (K<sub>A</sub>).
 *        Typical Value = 500.
 * @param kf Rate feedback gain (K<sub>F</sub>).
 *        Typical Value = 0.12.
 * @param se1 Saturation factor at E1 (S(E1)).
 *        Typical Value = 0.1.
 * @param se2 Saturation factor at E2 (S(E2)).
 *        Typical Value = 0.03.
 * @param ta AVR time constant (T<sub>A</sub>).
 *        Typical Value = 0.2.
 * @param tb AVR time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant (T<sub>E</sub>).
 *        Typical Value = 1.
 * @param tf Rate feedback time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param vrmn Minimum AVR output (V<sub>RMN</sub>).
 *        Typical Value = -6.
 * @param vrmx Maximum AVR output (V<sub>RMX</sub>).
 *        Typical Value = 7.
 */
case class ExcAVR1
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val ka: Double,
    val kf: Double,
    val se1: Double,
    val se2: Double,
    val ta: Double,
    val tb: Double,
    val te: Double,
    val tf: Double,
    val vrmn: Double,
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
    val e1 = parse_element (element ("""ExcAVR1.e1"""))
    val e2 = parse_element (element ("""ExcAVR1.e2"""))
    val ka = parse_element (element ("""ExcAVR1.ka"""))
    val kf = parse_element (element ("""ExcAVR1.kf"""))
    val se1 = parse_element (element ("""ExcAVR1.se1"""))
    val se2 = parse_element (element ("""ExcAVR1.se2"""))
    val ta = parse_element (element ("""ExcAVR1.ta"""))
    val tb = parse_element (element ("""ExcAVR1.tb"""))
    val te = parse_element (element ("""ExcAVR1.te"""))
    val tf = parse_element (element ("""ExcAVR1.tf"""))
    val vrmn = parse_element (element ("""ExcAVR1.vrmn"""))
    val vrmx = parse_element (element ("""ExcAVR1.vrmx"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Field voltage value 1 (E1).
 *        Typical Value = 4.18.
 * @param e2 Field voltage value 2 (E2).
 *        Typical Value = 3.14.
 * @param ka AVR gain (K<sub>A</sub>).
 *        Typical Value = 500.
 * @param kf Rate feedback gain (K<sub>F</sub>).
 *        Typical Value = 0.12.
 * @param se1 Saturation factor at E1 (S(E1)).
 *        Typical Value = 0.1.
 * @param se2 Saturation factor at E2 (S(E2)).
 *        Typical Value = 0.03.
 * @param ta AVR time constant (T<sub>A</sub>).
 *        Typical Value = 0.02.
 * @param tb AVR time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant (T<sub>E</sub>).
 *        Typical Value = 1.
 * @param tf1 Rate feedback time constant (T<sub>F1</sub>).
 *        Typical Value = 1.
 * @param tf2 Rate feedback time constant (T<sub>F2</sub>).
 *        Typical Value = 1.
 * @param vrmn Minimum AVR output (V<sub>RMN</sub>).
 *        Typical Value = -6.
 * @param vrmx Maximum AVR output (V<sub>RMX</sub>).
 *        Typical Value = 7.
 */
case class ExcAVR2
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val ka: Double,
    val kf: Double,
    val se1: Double,
    val se2: Double,
    val ta: Double,
    val tb: Double,
    val te: Double,
    val tf1: Double,
    val tf2: Double,
    val vrmn: Double,
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
    val e1 = parse_element (element ("""ExcAVR2.e1"""))
    val e2 = parse_element (element ("""ExcAVR2.e2"""))
    val ka = parse_element (element ("""ExcAVR2.ka"""))
    val kf = parse_element (element ("""ExcAVR2.kf"""))
    val se1 = parse_element (element ("""ExcAVR2.se1"""))
    val se2 = parse_element (element ("""ExcAVR2.se2"""))
    val ta = parse_element (element ("""ExcAVR2.ta"""))
    val tb = parse_element (element ("""ExcAVR2.tb"""))
    val te = parse_element (element ("""ExcAVR2.te"""))
    val tf1 = parse_element (element ("""ExcAVR2.tf1"""))
    val tf2 = parse_element (element ("""ExcAVR2.tf2"""))
    val vrmn = parse_element (element ("""ExcAVR2.vrmn"""))
    val vrmx = parse_element (element ("""ExcAVR2.vrmx"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Field voltage value 1 (E1).
 *        Typical Value = 4.18.
 * @param e2 Field voltage value 2 (E2).
 *        Typical Value = 3.14.
 * @param ka AVR gain (K<sub>A</sub>).
 *        Typical Value = 100.
 * @param se1 Saturation factor at E1 (S(E1)).
 *        Typical Value = 0.1.
 * @param se2 Saturation factor at E2 (S(E2)).
 *        Typical Value = 0.03.
 * @param t1 AVR time constant (T<sub>1</sub>).
 *        Typical Value = 20.
 * @param t2 AVR time constant (T<sub>2</sub>).
 *        Typical Value = 1.6.
 * @param t3 AVR time constant (T<sub>3</sub>).
 *        Typical Value = 0.66.
 * @param t4 AVR time constant (T<sub>4</sub>).
 *        Typical Value = 0.07.
 * @param te Exciter time constant (T<sub>E</sub>).
 *        Typical Value = 1.
 * @param vrmn Minimum AVR output (V<sub>RMN</sub>).
 *        Typical Value = -7.5.
 * @param vrmx Maximum AVR output (V<sub>RMX</sub>).
 *        Typical Value = 7.5.
 */
case class ExcAVR3
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val ka: Double,
    val se1: Double,
    val se2: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val te: Double,
    val vrmn: Double,
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
    val e1 = parse_element (element ("""ExcAVR3.e1"""))
    val e2 = parse_element (element ("""ExcAVR3.e2"""))
    val ka = parse_element (element ("""ExcAVR3.ka"""))
    val se1 = parse_element (element ("""ExcAVR3.se1"""))
    val se2 = parse_element (element ("""ExcAVR3.se2"""))
    val t1 = parse_element (element ("""ExcAVR3.t1"""))
    val t2 = parse_element (element ("""ExcAVR3.t2"""))
    val t3 = parse_element (element ("""ExcAVR3.t3"""))
    val t4 = parse_element (element ("""ExcAVR3.t4"""))
    val te = parse_element (element ("""ExcAVR3.te"""))
    val vrmn = parse_element (element ("""ExcAVR3.vrmn"""))
    val vrmx = parse_element (element ("""ExcAVR3.vrmx"""))
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
 * @param sup Reference to the superclass object.
 * @param imul AVR output voltage dependency selector (Imul).
true = selector is connected
false = selector is not connected.
 *        Typical Value = true.
 * @param ka AVR gain (K<sub>A</sub>).
 *        Typical Value = 300.
 * @param ke Exciter gain (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kif Exciter internal reactance (K<sub>IF</sub>).
 *        Typical Value = 0.
 * @param t1 AVR time constant (T<sub>1</sub>).
 *        Typical Value = 4.8.
 * @param t1if Exciter current feedback time constant (T<sub>1IF</sub>).
 *        Typical Value = 60.
 * @param t2 AVR time constant (T<sub>2</sub>).
 *        Typical Value = 1.5.
 * @param t3 AVR time constant (T<sub>3</sub>).
 *        Typical Value = 0.
 * @param t4 AVR time constant (T<sub>4</sub>).
 *        Typical Value = 0.
 * @param tif Exciter current feedback time constant (T<sub>IF</sub>).
 *        Typical Value = 0.
 * @param vfmn Minimum exciter output (V<sub>FMN</sub>).
 *        Typical Value = 0.
 * @param vfmx Maximum exciter output (V<sub>FMX</sub>).
 *        Typical Value = 5.
 * @param vrmn Minimum AVR output (V<sub>RMN</sub>).
 *        Typical Value = 0.
 * @param vrmx Maximum AVR output (V<sub>RMX</sub>).
 *        Typical Value = 5.
 */
case class ExcAVR4
(
    override val sup: ExcitationSystemDynamics,
    val imul: Boolean,
    val ka: Double,
    val ke: Double,
    val kif: Double,
    val t1: Double,
    val t1if: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val tif: Double,
    val vfmn: Double,
    val vfmx: Double,
    val vrmn: Double,
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
    val imul = parse_element (element ("""ExcAVR4.imul"""))
    val ka = parse_element (element ("""ExcAVR4.ka"""))
    val ke = parse_element (element ("""ExcAVR4.ke"""))
    val kif = parse_element (element ("""ExcAVR4.kif"""))
    val t1 = parse_element (element ("""ExcAVR4.t1"""))
    val t1if = parse_element (element ("""ExcAVR4.t1if"""))
    val t2 = parse_element (element ("""ExcAVR4.t2"""))
    val t3 = parse_element (element ("""ExcAVR4.t3"""))
    val t4 = parse_element (element ("""ExcAVR4.t4"""))
    val tif = parse_element (element ("""ExcAVR4.tif"""))
    val vfmn = parse_element (element ("""ExcAVR4.vfmn"""))
    val vfmx = parse_element (element ("""ExcAVR4.vfmx"""))
    val vrmn = parse_element (element ("""ExcAVR4.vrmn"""))
    val vrmx = parse_element (element ("""ExcAVR4.vrmx"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Gain (Ka).
 * @param rex Effective Output Resistance (Rex).
 *        Rex represents the effective output resistance seen by the excitation system.
 * @param ta Time constant (Ta).
 */
case class ExcAVR5
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val rex: Double,
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
    val ka = parse_element (element ("""ExcAVR5.ka"""))
    val rex = parse_element (element ("""ExcAVR5.rex"""))
    val ta = parse_element (element ("""ExcAVR5.ta"""))
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
 * @param sup Reference to the superclass object.
 * @param a1 Lead coefficient (A1).
 *        Typical Value = 0.5.
 * @param a2 Lag coefficient (A2).
 *        Typical Value = 0.5.
 * @param a3 Lead coefficient (A3).
 *        Typical Value = 0.5.
 * @param a4 Lag coefficient (A4).
 *        Typical Value = 0.5.
 * @param a5 Lead coefficient (A5).
 *        Typical Value = 0.5.
 * @param a6 Lag coefficient (A6).
 *        Typical Value = 0.5.
 * @param k1 Gain (K1).
 *        Typical Value = 1.
 * @param k3 Gain (K3).
 *        Typical Value = 3.
 * @param k5 Gain (K5).
 *        Typical Value = 1.
 * @param t1 Lead time constant (T1).
 *        Typical Value = 0.05.
 * @param t2 Lag time constant (T2).
 *        Typical Value = 0.1.
 * @param t3 Lead time constant (T3).
 *        Typical Value = 0.1.
 * @param t4 Lag time constant (T4).
 *        Typical Value = 0.1.
 * @param t5 Lead time constant (T5).
 *        Typical Value = 0.1.
 * @param t6 Lag time constant (T6).
 *        Typical Value = 0.1.
 * @param vmax1 Lead-lag max. limit (Vmax1).
 *        Typical Value = 5.
 * @param vmax3 Lead-lag max. limit (Vmax3).
 *        Typical Value = 5.
 * @param vmax5 Lead-lag max. limit (Vmax5).
 *        Typical Value = 5.
 * @param vmin1 Lead-lag min. limit (Vmin1).
 *        Typical Value = -5.
 * @param vmin3 Lead-lag min. limit (Vmin3).
 *        Typical Value = -5.
 * @param vmin5 Lead-lag min. limit (Vmin5).
 *        Typical Value = -2.
 */
case class ExcAVR7
(
    override val sup: ExcitationSystemDynamics,
    val a1: Double,
    val a2: Double,
    val a3: Double,
    val a4: Double,
    val a5: Double,
    val a6: Double,
    val k1: Double,
    val k3: Double,
    val k5: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val vmax1: Double,
    val vmax3: Double,
    val vmax5: Double,
    val vmin1: Double,
    val vmin3: Double,
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
    val a1 = parse_element (element ("""ExcAVR7.a1"""))
    val a2 = parse_element (element ("""ExcAVR7.a2"""))
    val a3 = parse_element (element ("""ExcAVR7.a3"""))
    val a4 = parse_element (element ("""ExcAVR7.a4"""))
    val a5 = parse_element (element ("""ExcAVR7.a5"""))
    val a6 = parse_element (element ("""ExcAVR7.a6"""))
    val k1 = parse_element (element ("""ExcAVR7.k1"""))
    val k3 = parse_element (element ("""ExcAVR7.k3"""))
    val k5 = parse_element (element ("""ExcAVR7.k5"""))
    val t1 = parse_element (element ("""ExcAVR7.t1"""))
    val t2 = parse_element (element ("""ExcAVR7.t2"""))
    val t3 = parse_element (element ("""ExcAVR7.t3"""))
    val t4 = parse_element (element ("""ExcAVR7.t4"""))
    val t5 = parse_element (element ("""ExcAVR7.t5"""))
    val t6 = parse_element (element ("""ExcAVR7.t6"""))
    val vmax1 = parse_element (element ("""ExcAVR7.vmax1"""))
    val vmax3 = parse_element (element ("""ExcAVR7.vmax3"""))
    val vmax5 = parse_element (element ("""ExcAVR7.vmax5"""))
    val vmin1 = parse_element (element ("""ExcAVR7.vmin1"""))
    val vmin3 = parse_element (element ("""ExcAVR7.vmin3"""))
    val vmin5 = parse_element (element ("""ExcAVR7.vmin5"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Maximum open circuit exciter voltage (Efdmax).
 *        Typical Value = 5.
 * @param efdmin Minimum open circuit exciter voltage (Efdmin).
 *        Typical Value = -5.
 * @param k Steady state gain (K).
 *        Typical Value = 300.
 * @param switch Supplementary signal routing selector (switch).
true = Vs connected to 3rd summing point
false =  Vs connected to 1st summing point (see diagram).
 *        Typical Value = true.
 * @param t1 Controller time constant (T1).
 *        Typical Value = 6.
 * @param t2 Controller time constant (T2).
 *        Typical Value = 1.
 * @param t3 Lead/lag time constant (T3).
 *        Typical Value = 0.05.
 * @param t4 Lead/lag time constant (T4).
 *        Typical Value = 0.01.
 * @param vrmax Maximum control element output (Vrmax).
 *        Typical Value = 5.
 * @param vrmin Minimum control element output (Vrmin).
 *        Typical Value = -5.
 * @param xe Effective excitation transformer reactance (Xe).
 *        Typical Value = 0.05.
 */
case class ExcBBC
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val efdmin: Double,
    val k: Double,
    val switch: Boolean,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val efdmax = parse_element (element ("""ExcBBC.efdmax"""))
    val efdmin = parse_element (element ("""ExcBBC.efdmin"""))
    val k = parse_element (element ("""ExcBBC.k"""))
    val switch = parse_element (element ("""ExcBBC.switch"""))
    val t1 = parse_element (element ("""ExcBBC.t1"""))
    val t2 = parse_element (element ("""ExcBBC.t2"""))
    val t3 = parse_element (element ("""ExcBBC.t3"""))
    val t4 = parse_element (element ("""ExcBBC.t4"""))
    val vrmax = parse_element (element ("""ExcBBC.vrmax"""))
    val vrmin = parse_element (element ("""ExcBBC.vrmin"""))
    val xe = parse_element (element ("""ExcBBC.xe"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Exciter output maximum limit (Efdmax).
 * @param efdmin Exciter output minimum limit (Efdmin).
 * @param ka Regulator gain (Ka).
 * @param ke Exciter constant related to self-excited field (Ke).
 * @param kp Regulator proportional gain (Kp).
 * @param ta Regulator time constant (Ta).
 * @param tc Regulator integral time constant (Tc).
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 * @param vrmax Voltage regulator maximum limit (Vrmax).
 * @param vrmin Voltage regulator minimum limit (Vrmin).
 */
case class ExcCZ
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val efdmin: Double,
    val ka: Double,
    val ke: Double,
    val kp: Double,
    val ta: Double,
    val tc: Double,
    val te: Double,
    val vrmax: Double,
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
    val efdmax = parse_element (element ("""ExcCZ.efdmax"""))
    val efdmin = parse_element (element ("""ExcCZ.efdmin"""))
    val ka = parse_element (element ("""ExcCZ.ka"""))
    val ke = parse_element (element ("""ExcCZ.ke"""))
    val kp = parse_element (element ("""ExcCZ.kp"""))
    val ta = parse_element (element ("""ExcCZ.ta"""))
    val tc = parse_element (element ("""ExcCZ.tc"""))
    val te = parse_element (element ("""ExcCZ.te"""))
    val vrmax = parse_element (element ("""ExcCZ.vrmax"""))
    val vrmin = parse_element (element ("""ExcCZ.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param edfmax Maximum voltage exciter output limiter (Efdmax).
 *        Typical Value = 99.
 * @param efd1 Exciter voltage at which exciter saturation is defined (Efd1).
 *        Typical Value = 3.1.
 * @param efd2 Exciter voltage at which exciter saturation is defined (Efd2).
 *        Typical Value = 2.3.
 * @param efdmin Minimum voltage exciter output limiter (Efdmin).
 *        Typical Value = -99.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 46.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 0.
 * @param kf Excitation control system stabilizer gain (Kf).
 *        Typical Value = 0.1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
 *        Typical Value = 0.33.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
 *        Typical Value = 0.33.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.06.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 0.46.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -0.9.
 */
case class ExcDC1A
(
    override val sup: ExcitationSystemDynamics,
    val edfmax: Double,
    val efd1: Double,
    val efd2: Double,
    val efdmin: Double,
    val exclim: Boolean,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val ks: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vrmax: Double,
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
    val edfmax = parse_element (element ("""ExcDC1A.edfmax"""))
    val efd1 = parse_element (element ("""ExcDC1A.efd1"""))
    val efd2 = parse_element (element ("""ExcDC1A.efd2"""))
    val efdmin = parse_element (element ("""ExcDC1A.efdmin"""))
    val exclim = parse_element (element ("""ExcDC1A.exclim"""))
    val ka = parse_element (element ("""ExcDC1A.ka"""))
    val ke = parse_element (element ("""ExcDC1A.ke"""))
    val kf = parse_element (element ("""ExcDC1A.kf"""))
    val ks = parse_element (element ("""ExcDC1A.ks"""))
    val seefd1 = parse_element (element ("""ExcDC1A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcDC1A.seefd2"""))
    val ta = parse_element (element ("""ExcDC1A.ta"""))
    val tb = parse_element (element ("""ExcDC1A.tb"""))
    val tc = parse_element (element ("""ExcDC1A.tc"""))
    val te = parse_element (element ("""ExcDC1A.te"""))
    val tf = parse_element (element ("""ExcDC1A.tf"""))
    val vrmax = parse_element (element ("""ExcDC1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcDC1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (Efd1).
 *        Typical Value = 3.05.
 * @param efd2 Exciter voltage at which exciter saturation is defined (Efd2).
 *        Typical Value = 2.29.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 300.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        If Ke is entered as zero, the model calculates an effective value of Ke such that the initial condition value of Vr is zero. The zero value of Ke is not changed.  If Ke is entered as non-zero, its value is used directly, without change.  Typical Value = 1.
 * @param kf Excitation control system stabilizer gain (Kf).
 *        Typical Value = 0.1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
 *        Typical Value = 0.279.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, Efd2 (Se[Efd2]).
 *        Typical Value = 0.117.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.01.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.33.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 0.675.
 * @param tf1 Excitation control system stabilizer time constant (Tf1).
 *        Typical Value = 0.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 4.95.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -4.9.
 * @param vtlim (Vtlim).
true = limiter at the block [Ka/(1+sTa)] is dependent on Vt 
false = limiter at the block is not dependent on Vt.
 *        Typical Value = true.
 */
case class ExcDC2A
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val exclim: Boolean,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val ks: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val tf1: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val efd1 = parse_element (element ("""ExcDC2A.efd1"""))
    val efd2 = parse_element (element ("""ExcDC2A.efd2"""))
    val exclim = parse_element (element ("""ExcDC2A.exclim"""))
    val ka = parse_element (element ("""ExcDC2A.ka"""))
    val ke = parse_element (element ("""ExcDC2A.ke"""))
    val kf = parse_element (element ("""ExcDC2A.kf"""))
    val ks = parse_element (element ("""ExcDC2A.ks"""))
    val seefd1 = parse_element (element ("""ExcDC2A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcDC2A.seefd2"""))
    val ta = parse_element (element ("""ExcDC2A.ta"""))
    val tb = parse_element (element ("""ExcDC2A.tb"""))
    val tc = parse_element (element ("""ExcDC2A.tc"""))
    val te = parse_element (element ("""ExcDC2A.te"""))
    val tf = parse_element (element ("""ExcDC2A.tf"""))
    val tf1 = parse_element (element ("""ExcDC2A.tf1"""))
    val vrmax = parse_element (element ("""ExcDC2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcDC2A.vrmin"""))
    val vtlim = parse_element (element ("""ExcDC2A.vtlim"""))
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
 * @param sup Reference to the superclass object.
 * @param edfmax Maximum voltage exciter output limiter (Efdmax).
 *        Typical Value = 99.
 * @param efd1 Exciter voltage at which exciter saturation is defined (Efd1).
 *        Typical Value = 2.6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (Efd2).
 *        Typical Value = 3.45.
 * @param efdlim (Efdlim).
true = exciter output limiter is active
false = exciter output limiter not active.
 *        Typical Value = true.
 * @param efdmin Minimum voltage exciter output limiter (Efdmin).
 *        Typical Value = -99.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kr Death band (Kr).
 *        If Kr is not zero, the voltage regulator input changes at a constant rate if Verr &gt; Kr or Verr &lt; -Kr as per the IEEE (1968) Type 4 model. If Kr is zero, the error signal drives the voltage regulator continuously as per the IEEE (1980) DC3 and IEEE (1992, 2005) DC3A models.  Typical Value = 0.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param kv Fast raise/lower contact setting (Kv).
 *        Typical Value = 0.05.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, Efd1 (Se[Eefd1]).
 *        Typical Value = 0.1.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, Efd2 (Se[Efd2]).
 *        Typical Value = 0.35.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.83.
 * @param trh Rheostat travel time (Trh).
 *        Typical Value = 20.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = 0.
 */
case class ExcDC3A
(
    override val sup: ExcitationSystemDynamics,
    val edfmax: Double,
    val efd1: Double,
    val efd2: Double,
    val efdlim: Boolean,
    val efdmin: Double,
    val exclim: Boolean,
    val ke: Double,
    val kr: Double,
    val ks: Double,
    val kv: Double,
    val seefd1: Double,
    val seefd2: Double,
    val te: Double,
    val trh: Double,
    val vrmax: Double,
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
    val edfmax = parse_element (element ("""ExcDC3A.edfmax"""))
    val efd1 = parse_element (element ("""ExcDC3A.efd1"""))
    val efd2 = parse_element (element ("""ExcDC3A.efd2"""))
    val efdlim = parse_element (element ("""ExcDC3A.efdlim"""))
    val efdmin = parse_element (element ("""ExcDC3A.efdmin"""))
    val exclim = parse_element (element ("""ExcDC3A.exclim"""))
    val ke = parse_element (element ("""ExcDC3A.ke"""))
    val kr = parse_element (element ("""ExcDC3A.kr"""))
    val ks = parse_element (element ("""ExcDC3A.ks"""))
    val kv = parse_element (element ("""ExcDC3A.kv"""))
    val seefd1 = parse_element (element ("""ExcDC3A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcDC3A.seefd2"""))
    val te = parse_element (element ("""ExcDC3A.te"""))
    val trh = parse_element (element ("""ExcDC3A.trh"""))
    val vrmax = parse_element (element ("""ExcDC3A.vrmax"""))
    val vrmin = parse_element (element ("""ExcDC3A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param exclim (exclim).
true = lower limit of zero is applied to integrator output
false = lower limit of zero not applied to integrator output.
 *        Typical Value = true.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 300.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gain (Kf).
 *        Typical Value = 0.1.
 * @param ki Potential circuit gain coefficient (Ki).
 *        Typical Value = 4.83.
 * @param kp Potential circuit gain coefficient (Kp).
 *        Typical Value = 4.37.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.01.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 1.83.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 0.675.
 * @param vb1max Available exciter voltage limiter (Vb1max).
 *        Typical Value = 11.63.
 * @param vblim Vb limiter indicator.
true = exciter Vbmax limiter is active
false = Vb1max is active.
 *        Typical Value = true.
 * @param vbmax Available exciter voltage limiter (Vbmax).
 *        Typical Value = 11.63.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = 0.
 */
case class ExcDC3A1
(
    override val sup: ExcitationSystemDynamics,
    val exclim: Boolean,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val ki: Double,
    val kp: Double,
    val ta: Double,
    val te: Double,
    val tf: Double,
    val vb1max: Double,
    val vblim: Boolean,
    val vbmax: Double,
    val vrmax: Double,
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
    val exclim = parse_element (element ("""ExcDC3A1.exclim"""))
    val ka = parse_element (element ("""ExcDC3A1.ka"""))
    val ke = parse_element (element ("""ExcDC3A1.ke"""))
    val kf = parse_element (element ("""ExcDC3A1.kf"""))
    val ki = parse_element (element ("""ExcDC3A1.ki"""))
    val kp = parse_element (element ("""ExcDC3A1.kp"""))
    val ta = parse_element (element ("""ExcDC3A1.ta"""))
    val te = parse_element (element ("""ExcDC3A1.te"""))
    val tf = parse_element (element ("""ExcDC3A1.tf"""))
    val vb1max = parse_element (element ("""ExcDC3A1.vb1max"""))
    val vblim = parse_element (element ("""ExcDC3A1.vblim"""))
    val vbmax = parse_element (element ("""ExcDC3A1.vbmax"""))
    val vrmax = parse_element (element ("""ExcDC3A1.vrmax"""))
    val vrmin = parse_element (element ("""ExcDC3A1.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param dpnf Controller follow up dead band (Dpnf).
 *        Typical Value = 0.
 * @param efmax Maximum open circuit excitation voltage (Efmax).
 *        Typical Value = 5.
 * @param efmin Minimum open circuit excitation voltage (Efmin).
 *        Typical Value = -5.
 * @param ks1 Stabilizer Gain 1 (Ks1).
 *        Typical Value = 0.
 * @param ks2 Stabilizer Gain 2 (Ks2).
 *        Typical Value = 0.
 * @param smax Stabilizer Limit Output (smax).
 *        Typical Value = 0.1.
 * @param tfi Current transducer time constant (Tfi).
 *        Typical Value = 0.
 * @param tnu Controller reset time constant (Tnu).
 *        Typical Value = 2.
 * @param ts1 Stabilizer Phase Lag Time Constant (Ts1).
 *        Typical Value = 1.
 * @param ts2 Stabilizer Filter Time Constant (Ts2).
 *        Typical Value = 1.
 * @param tsw Stabilizer parameters (Tsw).
 *        Typical Value = 3.
 * @param vpi Current controller gain (Vpi).
 *        Typical Value = 12.45.
 * @param vpnf Controller follow up gain (Vpnf).
 *        Typical Value = 2.
 * @param vpu Voltage controller proportional gain (Vpu).
 *        Typical Value = 34.5.
 * @param xe Excitation transformer effective reactance (Xe) (&gt;=0).
 *        Xe represents the regulation of the transformer/rectifier unit.  Typical Value = 0.06.
 */
case class ExcELIN1
(
    override val sup: ExcitationSystemDynamics,
    val dpnf: Double,
    val efmax: Double,
    val efmin: Double,
    val ks1: Double,
    val ks2: Double,
    val smax: Double,
    val tfi: Double,
    val tnu: Double,
    val ts1: Double,
    val ts2: Double,
    val tsw: Double,
    val vpi: Double,
    val vpnf: Double,
    val vpu: Double,
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
    val dpnf = parse_element (element ("""ExcELIN1.dpnf"""))
    val efmax = parse_element (element ("""ExcELIN1.efmax"""))
    val efmin = parse_element (element ("""ExcELIN1.efmin"""))
    val ks1 = parse_element (element ("""ExcELIN1.ks1"""))
    val ks2 = parse_element (element ("""ExcELIN1.ks2"""))
    val smax = parse_element (element ("""ExcELIN1.smax"""))
    val tfi = parse_element (element ("""ExcELIN1.tfi"""))
    val tnu = parse_element (element ("""ExcELIN1.tnu"""))
    val ts1 = parse_element (element ("""ExcELIN1.ts1"""))
    val ts2 = parse_element (element ("""ExcELIN1.ts2"""))
    val tsw = parse_element (element ("""ExcELIN1.tsw"""))
    val vpi = parse_element (element ("""ExcELIN1.vpi"""))
    val vpnf = parse_element (element ("""ExcELIN1.vpnf"""))
    val vpu = parse_element (element ("""ExcELIN1.vpu"""))
    val xe = parse_element (element ("""ExcELIN1.xe"""))
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
 * @param sup Reference to the superclass object.
 * @param efdbas Gain (Efdbas).
 *        Typical Value = 0.1.
 * @param iefmax Limiter (Iefmax).
 *        Typical Value = 1.
 * @param iefmax2 Minimum open circuit excitation voltage (Iefmax2).
 *        Typical Value = -5.
 * @param iefmin Limiter (Iefmin).
 *        Typical Value = 1.
 * @param k1 Voltage regulator input gain (K1).
 *        Typical Value = 0.
 * @param k1ec Voltage regulator input limit (K1ec).
 *        Typical Value = 2.
 * @param k2 Gain (K2).
 *        Typical Value = 5.
 * @param k3 Gain (K3).
 *        Typical Value = 0.1.
 * @param k4 Gain (K4).
 *        Typical Value = 0.
 * @param kd1 Voltage controller derivative gain (Kd1).
 *        Typical Value = 34.5.
 * @param ke2 Gain (Ke2).
 *        Typical Value = 0.1.
 * @param ketb Gain (Ketb).
 *        Typical Value = 0.06.
 * @param pid1max Controller follow up gain (PID1max).
 *        Typical Value = 2.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, Ve1, back of commutating reactance (Se[Ve1]).
 *        Typical Value = 0.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, Ve2, back of commutating reactance (Se[Ve2]).
 *        Typical Value = 1.
 * @param tb1 Voltage controller derivative washout time constant (Tb1).
 *        Typical Value = 12.45.
 * @param te Time constant (Te).
 *        Typical Value = 0.
 * @param te2 Time Constant (Te2).
 *        Typical Value = 1.
 * @param ti1 Controller follow up dead band (Ti1).
 *        Typical Value = 0.
 * @param ti3 Time constant (Ti3).
 *        Typical Value = 3.
 * @param ti4 Time constant (Ti4).
 *        Typical Value = 0.
 * @param tr4 Time constant (Tr4).
 *        Typical Value = 1.
 * @param upmax Limiter (Upmax).
 *        Typical Value = 3.
 * @param upmin Limiter (Upmin).
 *        Typical Value = 0.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve1).
 *        Typical Value = 3.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (Ve2).
 *        Typical Value = 0.
 * @param xp Excitation transformer effective reactance (Xp).
 *        Typical Value = 1.
 */
case class ExcELIN2
(
    override val sup: ExcitationSystemDynamics,
    val efdbas: Double,
    val iefmax: Double,
    val iefmax2: Double,
    val iefmin: Double,
    val k1: Double,
    val k1ec: Double,
    val k2: Double,
    val k3: Double,
    val k4: Double,
    val kd1: Double,
    val ke2: Double,
    val ketb: Double,
    val pid1max: Double,
    val seve1: Double,
    val seve2: Double,
    val tb1: Double,
    val te: Double,
    val te2: Double,
    val ti1: Double,
    val ti3: Double,
    val ti4: Double,
    val tr4: Double,
    val upmax: Double,
    val upmin: Double,
    val ve1: Double,
    val ve2: Double,
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
    val efdbas = parse_element (element ("""ExcELIN2.efdbas"""))
    val iefmax = parse_element (element ("""ExcELIN2.iefmax"""))
    val iefmax2 = parse_element (element ("""ExcELIN2.iefmax2"""))
    val iefmin = parse_element (element ("""ExcELIN2.iefmin"""))
    val k1 = parse_element (element ("""ExcELIN2.k1"""))
    val k1ec = parse_element (element ("""ExcELIN2.k1ec"""))
    val k2 = parse_element (element ("""ExcELIN2.k2"""))
    val k3 = parse_element (element ("""ExcELIN2.k3"""))
    val k4 = parse_element (element ("""ExcELIN2.k4"""))
    val kd1 = parse_element (element ("""ExcELIN2.kd1"""))
    val ke2 = parse_element (element ("""ExcELIN2.ke2"""))
    val ketb = parse_element (element ("""ExcELIN2.ketb"""))
    val pid1max = parse_element (element ("""ExcELIN2.pid1max"""))
    val seve1 = parse_element (element ("""ExcELIN2.seve1"""))
    val seve2 = parse_element (element ("""ExcELIN2.seve2"""))
    val tb1 = parse_element (element ("""ExcELIN2.tb1"""))
    val te = parse_element (element ("""ExcELIN2.te"""))
    val te2 = parse_element (element ("""ExcELIN2.te2"""))
    val ti1 = parse_element (element ("""ExcELIN2.ti1"""))
    val ti3 = parse_element (element ("""ExcELIN2.ti3"""))
    val ti4 = parse_element (element ("""ExcELIN2.ti4"""))
    val tr4 = parse_element (element ("""ExcELIN2.tr4"""))
    val upmax = parse_element (element ("""ExcELIN2.upmax"""))
    val upmin = parse_element (element ("""ExcELIN2.upmin"""))
    val ve1 = parse_element (element ("""ExcELIN2.ve1"""))
    val ve2 = parse_element (element ("""ExcELIN2.ve2"""))
    val xp = parse_element (element ("""ExcELIN2.xp"""))
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
 * @param sup Reference to the superclass object.
 * @param ae Major loop PI tag gain factor (Ae).
 *        Typical Value = 3.
 * @param ai Minor loop PI tag gain factor (Ai).
 *        Typical Value = 22.
 * @param atr AVR constant (Atr).
 *        Typical Value = 2.19.
 * @param emax Field voltage control signal upper limit on AVR base (Emax).
 *        Typical Value = 0.996.
 * @param emin Field voltage control signal lower limit on AVR base (Emin).
 *        Typical Value = -0.866.
 * @param imax Major loop PI tag output signal upper limit (Imax).
 *        Typical Value = 2.19.
 * @param imin Major loop PI tag output signal lower limit (Imin).
 *        Typical Value = 0.1.
 * @param ke Voltage base conversion constant (Ke).
 *        Typical Value = 4.666.
 * @param ki Current base conversion constant (Ki).
 *        Typical Value = 0.21428.
 * @param te Major loop PI tag integration time constant (Te).
 *        Typical Value = 0.154.
 * @param ti Minor loop PI control tag integration time constant (Ti).
 *        Typical Value = 0.01333.
 * @param tr Filter time constant (Tr).
 *        If a voltage compensator is used in conjunction with this excitation system model, Tr should be set to 0.  Typical Value = 0.01.
 */
case class ExcHU
(
    override val sup: ExcitationSystemDynamics,
    val ae: Double,
    val ai: Double,
    val atr: Double,
    val emax: Double,
    val emin: Double,
    val imax: Double,
    val imin: Double,
    val ke: Double,
    val ki: Double,
    val te: Double,
    val ti: Double,
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
    val ae = parse_element (element ("""ExcHU.ae"""))
    val ai = parse_element (element ("""ExcHU.ai"""))
    val atr = parse_element (element ("""ExcHU.atr"""))
    val emax = parse_element (element ("""ExcHU.emax"""))
    val emin = parse_element (element ("""ExcHU.emin"""))
    val imax = parse_element (element ("""ExcHU.imax"""))
    val imin = parse_element (element ("""ExcHU.imin"""))
    val ke = parse_element (element ("""ExcHU.ke"""))
    val ki = parse_element (element ("""ExcHU.ki"""))
    val te = parse_element (element ("""ExcHU.te"""))
    val ti = parse_element (element ("""ExcHU.ti"""))
    val tr = parse_element (element ("""ExcHU.tr"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 400.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.2.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 0.38.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.03.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 0.1.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 0.03.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.8.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 14.5.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -14.5.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>).
 *        Typical Value = 4.18.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 3.14.
 * @param vrmax Maximum voltage regulator outputs (V<sub>RMAX</sub>).
 *        Typical Value = 6.03.
 * @param vrmin Minimum voltage regulator outputs (V<sub>RMIN</sub>).
 *        Typical Value = -5.43.
 */
case class ExcIEEEAC1A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcIEEEAC1A.ka"""))
    val kc = parse_element (element ("""ExcIEEEAC1A.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC1A.kd"""))
    val ke = parse_element (element ("""ExcIEEEAC1A.ke"""))
    val kf = parse_element (element ("""ExcIEEEAC1A.kf"""))
    val seve1 = parse_element (element ("""ExcIEEEAC1A.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC1A.seve2"""))
    val ta = parse_element (element ("""ExcIEEEAC1A.ta"""))
    val tb = parse_element (element ("""ExcIEEEAC1A.tb"""))
    val tc = parse_element (element ("""ExcIEEEAC1A.tc"""))
    val te = parse_element (element ("""ExcIEEEAC1A.te"""))
    val tf = parse_element (element ("""ExcIEEEAC1A.tf"""))
    val vamax = parse_element (element ("""ExcIEEEAC1A.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEAC1A.vamin"""))
    val ve1 = parse_element (element ("""ExcIEEEAC1A.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC1A.ve2"""))
    val vrmax = parse_element (element ("""ExcIEEEAC1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 400.
 * @param kb Second stage regulator gain (K<sub>B</sub>).
 *        Typical Value = 25.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.28.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 0.35.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.03.
 * @param kh Exciter field current feedback gain (K<sub>H</sub>).
 *        Typical Value = 1.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 0.037.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 0.012.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.6.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 8.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -8.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>).
 *        Typical Value = 4.4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 3.3.
 * @param vfemax Exciter field current limit reference (V<sub>FEMAX</sub>).
 *        Typical Value = 4.4.
 * @param vrmax Maximum voltage regulator outputs (V<sub>RMAX</sub>).
 *        Typical Value = 105.
 * @param vrmin Minimum voltage regulator outputs (V<sub>RMIN</sub>).
 *        Typical Value = -95.
 */
case class ExcIEEEAC2A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kb: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val kh: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vfemax: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcIEEEAC2A.ka"""))
    val kb = parse_element (element ("""ExcIEEEAC2A.kb"""))
    val kc = parse_element (element ("""ExcIEEEAC2A.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC2A.kd"""))
    val ke = parse_element (element ("""ExcIEEEAC2A.ke"""))
    val kf = parse_element (element ("""ExcIEEEAC2A.kf"""))
    val kh = parse_element (element ("""ExcIEEEAC2A.kh"""))
    val seve1 = parse_element (element ("""ExcIEEEAC2A.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC2A.seve2"""))
    val ta = parse_element (element ("""ExcIEEEAC2A.ta"""))
    val tb = parse_element (element ("""ExcIEEEAC2A.tb"""))
    val tc = parse_element (element ("""ExcIEEEAC2A.tc"""))
    val te = parse_element (element ("""ExcIEEEAC2A.te"""))
    val tf = parse_element (element ("""ExcIEEEAC2A.tf"""))
    val vamax = parse_element (element ("""ExcIEEEAC2A.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEAC2A.vamin"""))
    val ve1 = parse_element (element ("""ExcIEEEAC2A.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC2A.ve2"""))
    val vfemax = parse_element (element ("""ExcIEEEAC2A.vfemax"""))
    val vrmax = parse_element (element ("""ExcIEEEAC2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC2A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efdn Value of <i>EFD </i>at which feedback gain changes (E<sub>FDN</sub>).
 *        Typical Value = 2.36.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 45.62.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.104.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 0.499.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.143.
 * @param kn Excitation control system stabilizer gain (K<sub>N</sub>).
 *        Typical Value = 0.05.
 * @param kr Constant associated with regulator and alternator field power supply (K<sub>R</sub>).
 *        Typical Value = 3.77.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 1.143.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 0.1.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.013.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 1.17.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 1.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -0.95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX </sub>(V<sub>E1</sub>).
 *        Typical Value = 6.24.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 4.68.
 * @param vemin Minimum exciter voltage output (V<sub>EMIN</sub>).
 *        Typical Value = 0.1.
 * @param vfemax Exciter field current limit reference (V<sub>FEMAX</sub>).
 *        Typical Value = 16.
 */
case class ExcIEEEAC3A
(
    override val sup: ExcitationSystemDynamics,
    val efdn: Double,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val kn: Double,
    val kr: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vemin: Double,
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
    val efdn = parse_element (element ("""ExcIEEEAC3A.efdn"""))
    val ka = parse_element (element ("""ExcIEEEAC3A.ka"""))
    val kc = parse_element (element ("""ExcIEEEAC3A.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC3A.kd"""))
    val ke = parse_element (element ("""ExcIEEEAC3A.ke"""))
    val kf = parse_element (element ("""ExcIEEEAC3A.kf"""))
    val kn = parse_element (element ("""ExcIEEEAC3A.kn"""))
    val kr = parse_element (element ("""ExcIEEEAC3A.kr"""))
    val seve1 = parse_element (element ("""ExcIEEEAC3A.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC3A.seve2"""))
    val ta = parse_element (element ("""ExcIEEEAC3A.ta"""))
    val tb = parse_element (element ("""ExcIEEEAC3A.tb"""))
    val tc = parse_element (element ("""ExcIEEEAC3A.tc"""))
    val te = parse_element (element ("""ExcIEEEAC3A.te"""))
    val tf = parse_element (element ("""ExcIEEEAC3A.tf"""))
    val vamax = parse_element (element ("""ExcIEEEAC3A.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEAC3A.vamin"""))
    val ve1 = parse_element (element ("""ExcIEEEAC3A.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC3A.ve2"""))
    val vemin = parse_element (element ("""ExcIEEEAC3A.vemin"""))
    val vfemax = parse_element (element ("""ExcIEEEAC3A.vfemax"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.015.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 10.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 1.
 * @param vimax Maximum voltage regulator input limit (V<sub>IMAX</sub>).
 *        Typical Value = 10.
 * @param vimin Minimum voltage regulator input limit (V<sub>IMIN</sub>).
 *        Typical Value = -10.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 5.64.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -4.53.
 */
case class ExcIEEEAC4A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val vimax: Double,
    val vimin: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcIEEEAC4A.ka"""))
    val kc = parse_element (element ("""ExcIEEEAC4A.kc"""))
    val ta = parse_element (element ("""ExcIEEEAC4A.ta"""))
    val tb = parse_element (element ("""ExcIEEEAC4A.tb"""))
    val tc = parse_element (element ("""ExcIEEEAC4A.tc"""))
    val vimax = parse_element (element ("""ExcIEEEAC4A.vimax"""))
    val vimin = parse_element (element ("""ExcIEEEAC4A.vimin"""))
    val vrmax = parse_element (element ("""ExcIEEEAC4A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC4A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
 *        Typical Value = 5.6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
 *        Typical Value = 4.2.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 400.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.03.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
 *        Typical Value = 0.86.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
 *        Typical Value = 0.5.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.02.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.8.
 * @param tf1 Excitation control system stabilizer time constant (T<sub>F1</sub>).
 *        Typical Value = 1.
 * @param tf2 Excitation control system stabilizer time constant (T<sub>F2</sub>).
 *        Typical Value = 1.
 * @param tf3 Excitation control system stabilizer time constant (T<sub>F3</sub>).
 *        Typical Value = 1.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 7.3.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -7.3.
 */
case class ExcIEEEAC5A
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val te: Double,
    val tf1: Double,
    val tf2: Double,
    val tf3: Double,
    val vrmax: Double,
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
    val efd1 = parse_element (element ("""ExcIEEEAC5A.efd1"""))
    val efd2 = parse_element (element ("""ExcIEEEAC5A.efd2"""))
    val ka = parse_element (element ("""ExcIEEEAC5A.ka"""))
    val ke = parse_element (element ("""ExcIEEEAC5A.ke"""))
    val kf = parse_element (element ("""ExcIEEEAC5A.kf"""))
    val seefd1 = parse_element (element ("""ExcIEEEAC5A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcIEEEAC5A.seefd2"""))
    val ta = parse_element (element ("""ExcIEEEAC5A.ta"""))
    val te = parse_element (element ("""ExcIEEEAC5A.te"""))
    val tf1 = parse_element (element ("""ExcIEEEAC5A.tf1"""))
    val tf2 = parse_element (element ("""ExcIEEEAC5A.tf2"""))
    val tf3 = parse_element (element ("""ExcIEEEAC5A.tf3"""))
    val vrmax = parse_element (element ("""ExcIEEEAC5A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC5A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 536.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.173.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 1.91.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.6.
 * @param kh Exciter field current limiter gain (K<sub>H</sub>).
 *        Typical Value = 92.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 0.214.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 0.044.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.086.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 9.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 3.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 1.
 * @param th Exciter field current limiter time constant (T<sub>H</sub>).
 *        Typical Value = 0.08.
 * @param tj Exciter field current limiter time constant (T<sub>J</sub>).
 *        Typical Value = 0.02.
 * @param tk Voltage regulator time constant (T<sub>K</sub>).
 *        Typical Value = 0.18.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 75.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -75.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX </sub>(V<sub>E1</sub>).
 *        Typical Value = 7.4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 5.55.
 * @param vfelim Exciter field current limit reference (V<sub>FELIM</sub>).
 *        Typical Value = 19.
 * @param vhmax Maximum field current limiter signal reference (V<sub>HMAX</sub>).
 *        Typical Value = 75.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 44.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -36.
 */
case class ExcIEEEAC6A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kh: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val th: Double,
    val tj: Double,
    val tk: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vfelim: Double,
    val vhmax: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcIEEEAC6A.ka"""))
    val kc = parse_element (element ("""ExcIEEEAC6A.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC6A.kd"""))
    val ke = parse_element (element ("""ExcIEEEAC6A.ke"""))
    val kh = parse_element (element ("""ExcIEEEAC6A.kh"""))
    val seve1 = parse_element (element ("""ExcIEEEAC6A.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC6A.seve2"""))
    val ta = parse_element (element ("""ExcIEEEAC6A.ta"""))
    val tb = parse_element (element ("""ExcIEEEAC6A.tb"""))
    val tc = parse_element (element ("""ExcIEEEAC6A.tc"""))
    val te = parse_element (element ("""ExcIEEEAC6A.te"""))
    val th = parse_element (element ("""ExcIEEEAC6A.th"""))
    val tj = parse_element (element ("""ExcIEEEAC6A.tj"""))
    val tk = parse_element (element ("""ExcIEEEAC6A.tk"""))
    val vamax = parse_element (element ("""ExcIEEEAC6A.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEAC6A.vamin"""))
    val ve1 = parse_element (element ("""ExcIEEEAC6A.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC6A.ve2"""))
    val vfelim = parse_element (element ("""ExcIEEEAC6A.vfelim"""))
    val vhmax = parse_element (element ("""ExcIEEEAC6A.vhmax"""))
    val vrmax = parse_element (element ("""ExcIEEEAC6A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC6A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.18.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 0.02.
 * @param kdr Voltage regulator derivative gain (K<sub>DR</sub>).
 *        Typical Value = 0.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf1 Excitation control system stabilizer gain (K<sub>F1</sub>).
 *        Typical Value = 0.212.
 * @param kf2 Excitation control system stabilizer gain (K<sub>F2</sub>).
 *        Typical Value = 0.
 * @param kf3 Excitation control system stabilizer gain (K<sub>F3</sub>).
 *        Typical Value = 0.
 * @param kia Voltage regulator integral gain (K<sub>IA</sub>).
 *        Typical Value = 59.69.
 * @param kir Voltage regulator integral gain (K<sub>IR</sub>).
 *        Typical Value = 4.24.
 * @param kl Exciter field voltage lower limit parameter (K<sub>L</sub>).
 *        Typical Value = 10.
 * @param kp Potential circuit gain coefficient (K<sub>P</sub>).
 *        Typical Value = 4.96.
 * @param kpa Voltage regulator proportional gain (K<sub>PA</sub>).
 *        Typical Value = 65.36.
 * @param kpr Voltage regulator proportional gain (K<sub>PR</sub>).
 *        Typical Value = 4.24.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 0.44.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 0.075.
 * @param tdr Lag time constant (T<sub>DR</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 1.1.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 1.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -0.95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX</sub> (V<sub>E1</sub>).
 *        Typical Value = 6.3.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 3.02.
 * @param vemin Minimum exciter voltage output (V<sub>EMIN</sub>).
 *        Typical Value = 0.
 * @param vfemax Exciter field current limit reference (V<sub>FEMAX</sub>).
 *        Typical Value = 6.9.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 5.79.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -5.79.
 */
case class ExcIEEEAC7B
(
    override val sup: ExcitationSystemDynamics,
    val kc: Double,
    val kd: Double,
    val kdr: Double,
    val ke: Double,
    val kf1: Double,
    val kf2: Double,
    val kf3: Double,
    val kia: Double,
    val kir: Double,
    val kl: Double,
    val kp: Double,
    val kpa: Double,
    val kpr: Double,
    val seve1: Double,
    val seve2: Double,
    val tdr: Double,
    val te: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val ve1: Double,
    val ve2: Double,
    val vemin: Double,
    val vfemax: Double,
    val vrmax: Double,
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
    val kc = parse_element (element ("""ExcIEEEAC7B.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC7B.kd"""))
    val kdr = parse_element (element ("""ExcIEEEAC7B.kdr"""))
    val ke = parse_element (element ("""ExcIEEEAC7B.ke"""))
    val kf1 = parse_element (element ("""ExcIEEEAC7B.kf1"""))
    val kf2 = parse_element (element ("""ExcIEEEAC7B.kf2"""))
    val kf3 = parse_element (element ("""ExcIEEEAC7B.kf3"""))
    val kia = parse_element (element ("""ExcIEEEAC7B.kia"""))
    val kir = parse_element (element ("""ExcIEEEAC7B.kir"""))
    val kl = parse_element (element ("""ExcIEEEAC7B.kl"""))
    val kp = parse_element (element ("""ExcIEEEAC7B.kp"""))
    val kpa = parse_element (element ("""ExcIEEEAC7B.kpa"""))
    val kpr = parse_element (element ("""ExcIEEEAC7B.kpr"""))
    val seve1 = parse_element (element ("""ExcIEEEAC7B.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC7B.seve2"""))
    val tdr = parse_element (element ("""ExcIEEEAC7B.tdr"""))
    val te = parse_element (element ("""ExcIEEEAC7B.te"""))
    val tf = parse_element (element ("""ExcIEEEAC7B.tf"""))
    val vamax = parse_element (element ("""ExcIEEEAC7B.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEAC7B.vamin"""))
    val ve1 = parse_element (element ("""ExcIEEEAC7B.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC7B.ve2"""))
    val vemin = parse_element (element ("""ExcIEEEAC7B.vemin"""))
    val vfemax = parse_element (element ("""ExcIEEEAC7B.vfemax"""))
    val vrmax = parse_element (element ("""ExcIEEEAC7B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC7B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 1.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.55.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (K<sub>D</sub>).
 *        Typical Value = 1.1.
 * @param kdr Voltage regulator derivative gain (K<sub>DR</sub>).
 *        Typical Value = 10.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kir Voltage regulator integral gain (K<sub>IR</sub>).
 *        Typical Value = 5.
 * @param kpr Voltage regulator proportional gain (K<sub>PR</sub>).
 *        Typical Value = 80.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, V<sub>E1</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E1</sub>]).
 *        Typical Value = 0.3.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, V<sub>E2</sub>, back of commutating reactance (S<sub>E</sub>[V<sub>E2</sub>]).
 *        Typical Value = 3.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.
 * @param tdr Lag time constant (T<sub>DR</sub>).
 *        Typical Value = 0.1.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 1.2.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E1</sub>) equals V<sub>EMAX</sub> (V<sub>E1</sub>).
 *        Typical Value = 6.5.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (V<sub>E2</sub>).
 *        Typical Value = 9.
 * @param vemin Minimum exciter voltage output (V<sub>EMIN</sub>).
 *        Typical Value = 0.
 * @param vfemax Exciter field current limit reference (V<sub>FEMAX</sub>).
 *        Typical Value = 6.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 35.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = 0.
 */
case class ExcIEEEAC8B
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val kdr: Double,
    val ke: Double,
    val kir: Double,
    val kpr: Double,
    val seve1: Double,
    val seve2: Double,
    val ta: Double,
    val tdr: Double,
    val te: Double,
    val ve1: Double,
    val ve2: Double,
    val vemin: Double,
    val vfemax: Double,
    val vrmax: Double,
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
    val ka = parse_element (element ("""ExcIEEEAC8B.ka"""))
    val kc = parse_element (element ("""ExcIEEEAC8B.kc"""))
    val kd = parse_element (element ("""ExcIEEEAC8B.kd"""))
    val kdr = parse_element (element ("""ExcIEEEAC8B.kdr"""))
    val ke = parse_element (element ("""ExcIEEEAC8B.ke"""))
    val kir = parse_element (element ("""ExcIEEEAC8B.kir"""))
    val kpr = parse_element (element ("""ExcIEEEAC8B.kpr"""))
    val seve1 = parse_element (element ("""ExcIEEEAC8B.seve1"""))
    val seve2 = parse_element (element ("""ExcIEEEAC8B.seve2"""))
    val ta = parse_element (element ("""ExcIEEEAC8B.ta"""))
    val tdr = parse_element (element ("""ExcIEEEAC8B.tdr"""))
    val te = parse_element (element ("""ExcIEEEAC8B.te"""))
    val ve1 = parse_element (element ("""ExcIEEEAC8B.ve1"""))
    val ve2 = parse_element (element ("""ExcIEEEAC8B.ve2"""))
    val vemin = parse_element (element ("""ExcIEEEAC8B.vemin"""))
    val vfemax = parse_element (element ("""ExcIEEEAC8B.vfemax"""))
    val vrmax = parse_element (element ("""ExcIEEEAC8B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEAC8B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
 *        Typical Value = 3.1.
 * @param efd2 Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
 *        Typical Value = 2.3.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 46.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 0.
 * @param kf Excitation control system stabilizer gain (K<sub>F</sub>).
 *        Typical Value = 0.1.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
 *        Typical Value = 0.33.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
 *        Typical Value = 0.1.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.06.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.46.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param uelin UEL input (uelin).
true = input is connected to the HV gate
false = input connects to the error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -0.9.
 */
case class ExcIEEEDC1A
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val exclim: Boolean,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val uelin: Boolean,
    val vrmax: Double,
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
    val efd1 = parse_element (element ("""ExcIEEEDC1A.efd1"""))
    val efd2 = parse_element (element ("""ExcIEEEDC1A.efd2"""))
    val exclim = parse_element (element ("""ExcIEEEDC1A.exclim"""))
    val ka = parse_element (element ("""ExcIEEEDC1A.ka"""))
    val ke = parse_element (element ("""ExcIEEEDC1A.ke"""))
    val kf = parse_element (element ("""ExcIEEEDC1A.kf"""))
    val seefd1 = parse_element (element ("""ExcIEEEDC1A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcIEEEDC1A.seefd2"""))
    val ta = parse_element (element ("""ExcIEEEDC1A.ta"""))
    val tb = parse_element (element ("""ExcIEEEDC1A.tb"""))
    val tc = parse_element (element ("""ExcIEEEDC1A.tc"""))
    val te = parse_element (element ("""ExcIEEEDC1A.te"""))
    val tf = parse_element (element ("""ExcIEEEDC1A.tf"""))
    val uelin = parse_element (element ("""ExcIEEEDC1A.uelin"""))
    val vrmax = parse_element (element ("""ExcIEEEDC1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEDC1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
 *        Typical Value = 3.05.
 * @param efd2 Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
 *        Typical Value = 2.29.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output. Typical Value = - 999  which means that there is no limit applied.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 300.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gain (K<sub>F</sub>).
 *        Typical Value = 0.1.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
 *        Typical Value = 0.279.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
 *        Typical Value = 0.117.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.01.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 1.33.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 0.675.
 * @param uelin UEL input (uelin).
true = input is connected to the HV gate
false = input connects to the error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 4.95.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -4.9.
 */
case class ExcIEEEDC2A
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val exclim: Double,
    val ka: Double,
    val ke: Double,
    val kf: Double,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val uelin: Boolean,
    val vrmax: Double,
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
    val efd1 = parse_element (element ("""ExcIEEEDC2A.efd1"""))
    val efd2 = parse_element (element ("""ExcIEEEDC2A.efd2"""))
    val exclim = parse_element (element ("""ExcIEEEDC2A.exclim"""))
    val ka = parse_element (element ("""ExcIEEEDC2A.ka"""))
    val ke = parse_element (element ("""ExcIEEEDC2A.ke"""))
    val kf = parse_element (element ("""ExcIEEEDC2A.kf"""))
    val seefd1 = parse_element (element ("""ExcIEEEDC2A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcIEEEDC2A.seefd2"""))
    val ta = parse_element (element ("""ExcIEEEDC2A.ta"""))
    val tb = parse_element (element ("""ExcIEEEDC2A.tb"""))
    val tc = parse_element (element ("""ExcIEEEDC2A.tc"""))
    val te = parse_element (element ("""ExcIEEEDC2A.te"""))
    val tf = parse_element (element ("""ExcIEEEDC2A.tf"""))
    val uelin = parse_element (element ("""ExcIEEEDC2A.uelin"""))
    val vrmax = parse_element (element ("""ExcIEEEDC2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEDC2A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
 *        Typical Value = 3.375.
 * @param efd2 Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
 *        Typical Value = 3.15.
 * @param exclim (exclim).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 0.05.
 * @param kv Fast raise/lower contact setting (K<sub>V</sub>).
 *        Typical Value = 0.05.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
 *        Typical Value = 0.267.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
 *        Typical Value = 0.068.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.5.
 * @param trh Rheostat travel time (T<sub>RH</sub>).
 *        Typical Value = 20.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = 0.
 */
case class ExcIEEEDC3A
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val exclim: Boolean,
    val ke: Double,
    val kv: Double,
    val seefd1: Double,
    val seefd2: Double,
    val te: Double,
    val trh: Double,
    val vrmax: Double,
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
    val efd1 = parse_element (element ("""ExcIEEEDC3A.efd1"""))
    val efd2 = parse_element (element ("""ExcIEEEDC3A.efd2"""))
    val exclim = parse_element (element ("""ExcIEEEDC3A.exclim"""))
    val ke = parse_element (element ("""ExcIEEEDC3A.ke"""))
    val kv = parse_element (element ("""ExcIEEEDC3A.kv"""))
    val seefd1 = parse_element (element ("""ExcIEEEDC3A.seefd1"""))
    val seefd2 = parse_element (element ("""ExcIEEEDC3A.seefd2"""))
    val te = parse_element (element ("""ExcIEEEDC3A.te"""))
    val trh = parse_element (element ("""ExcIEEEDC3A.trh"""))
    val vrmax = parse_element (element ("""ExcIEEEDC3A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEDC3A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (E<sub>FD1</sub>).
 *        Typical Value = 1.75.
 * @param efd2 Exciter voltage at which exciter saturation is defined (E<sub>FD2</sub>).
 *        Typical Value = 2.33.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 1.
 * @param kd Regulator derivative gain (K<sub>D</sub>).
 *        Typical Value = 20.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gain (K<sub>F</sub>).
 *        Typical Value = 0.
 * @param ki Regulator integral gain (K<sub>I</sub>).
 *        Typical Value = 20.
 * @param kp Regulator proportional gain (K<sub>P</sub>).
 *        Typical Value = 20.
 * @param oelin OEL input (OELin).
true = LV gate
false = subtract from error signal.
 *        Typical Value = true.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD1</sub> (S<sub>E</sub>[E<sub>FD1</sub>]).
 *        Typical Value = 0.08.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, E<sub>FD2</sub> (S<sub>E</sub>[E<sub>FD2</sub>]).
 *        Typical Value = 0.27.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.2.
 * @param td Regulator derivative filter time constant(T<sub>D</sub>).
 *        Typical Value = 0.01.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.8.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param uelin UEL input (UELin).
true = HV gate
false = add to error signal.
 *        Typical Value = true.
 * @param vemin Minimum exciter voltage output(V<sub>EMIN</sub>).
 *        Typical Value = 0.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 2.7.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -0.9.
 */
case class ExcIEEEDC4B
(
    override val sup: ExcitationSystemDynamics,
    val efd1: Double,
    val efd2: Double,
    val ka: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val ki: Double,
    val kp: Double,
    val oelin: Boolean,
    val seefd1: Double,
    val seefd2: Double,
    val ta: Double,
    val td: Double,
    val te: Double,
    val tf: Double,
    val uelin: Boolean,
    val vemin: Double,
    val vrmax: Double,
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
    val efd1 = parse_element (element ("""ExcIEEEDC4B.efd1"""))
    val efd2 = parse_element (element ("""ExcIEEEDC4B.efd2"""))
    val ka = parse_element (element ("""ExcIEEEDC4B.ka"""))
    val kd = parse_element (element ("""ExcIEEEDC4B.kd"""))
    val ke = parse_element (element ("""ExcIEEEDC4B.ke"""))
    val kf = parse_element (element ("""ExcIEEEDC4B.kf"""))
    val ki = parse_element (element ("""ExcIEEEDC4B.ki"""))
    val kp = parse_element (element ("""ExcIEEEDC4B.kp"""))
    val oelin = parse_element (element ("""ExcIEEEDC4B.oelin"""))
    val seefd1 = parse_element (element ("""ExcIEEEDC4B.seefd1"""))
    val seefd2 = parse_element (element ("""ExcIEEEDC4B.seefd2"""))
    val ta = parse_element (element ("""ExcIEEEDC4B.ta"""))
    val td = parse_element (element ("""ExcIEEEDC4B.td"""))
    val te = parse_element (element ("""ExcIEEEDC4B.te"""))
    val tf = parse_element (element ("""ExcIEEEDC4B.tf"""))
    val uelin = parse_element (element ("""ExcIEEEDC4B.uelin"""))
    val vemin = parse_element (element ("""ExcIEEEDC4B.vemin"""))
    val vrmax = parse_element (element ("""ExcIEEEDC4B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEDC4B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ilr Exciter output current limit reference (I<sub>LR</sub>).
 *        Typical Value = 0.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 190.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.08.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.
 * @param klr Exciter output current limiter gain (K<sub>LR</sub>).
 *        Typical Value = 0.
 * @param pssin Selector of the Power System Stabilizer (PSS) input (PSSin).
true = PSS input (Vs) added to error signal
false = PSS input (Vs) added to voltage regulator output.
 *        Typical Value = true.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 10.
 * @param tb1 Voltage regulator time constant (T<sub>B1</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 1.
 * @param tc1 Voltage regulator time constant (T<sub>C1</sub>).
 *        Typical Value = 0.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param uelin Selector of the connection of the UEL input (UELin).
 *        Typical Value = ignoreUELsignal.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 14.5.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -14.5.
 * @param vimax Maximum voltage regulator input limit (V<sub>IMAX</sub>).
 *        Typical Value = 999.
 * @param vimin Minimum voltage regulator input limit (V<sub>IMIN</sub>).
 *        Typical Value = -999.
 * @param vrmax Maximum voltage regulator outputs (V<sub>RMAX</sub>).
 *        Typical Value = 7.8.
 * @param vrmin Minimum voltage regulator outputs (V<sub>RMIN</sub>).
 *        Typical Value = -6.7.
 */
case class ExcIEEEST1A
(
    override val sup: ExcitationSystemDynamics,
    val ilr: Double,
    val ka: Double,
    val kc: Double,
    val kf: Double,
    val klr: Double,
    val pssin: Boolean,
    val ta: Double,
    val tb: Double,
    val tb1: Double,
    val tc: Double,
    val tc1: Double,
    val tf: Double,
    val uelin: String,
    val vamax: Double,
    val vamin: Double,
    val vimax: Double,
    val vimin: Double,
    val vrmax: Double,
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
    val ilr = parse_element (element ("""ExcIEEEST1A.ilr"""))
    val ka = parse_element (element ("""ExcIEEEST1A.ka"""))
    val kc = parse_element (element ("""ExcIEEEST1A.kc"""))
    val kf = parse_element (element ("""ExcIEEEST1A.kf"""))
    val klr = parse_element (element ("""ExcIEEEST1A.klr"""))
    val pssin = parse_element (element ("""ExcIEEEST1A.pssin"""))
    val ta = parse_element (element ("""ExcIEEEST1A.ta"""))
    val tb = parse_element (element ("""ExcIEEEST1A.tb"""))
    val tb1 = parse_element (element ("""ExcIEEEST1A.tb1"""))
    val tc = parse_element (element ("""ExcIEEEST1A.tc"""))
    val tc1 = parse_element (element ("""ExcIEEEST1A.tc1"""))
    val tf = parse_element (element ("""ExcIEEEST1A.tf"""))
    val uelin = parse_attribute (attribute ("""ExcIEEEST1A.uelin"""))
    val vamax = parse_element (element ("""ExcIEEEST1A.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEST1A.vamin"""))
    val vimax = parse_element (element ("""ExcIEEEST1A.vimax"""))
    val vimin = parse_element (element ("""ExcIEEEST1A.vimin"""))
    val vrmax = parse_element (element ("""ExcIEEEST1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST1A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ignoreUELsignal Ignore UEL signal.
 * @param inputAddedToErrorSignal UEL input added to error signal.
 * @param inputHVgateErrorSignal UEL input HV gate with error signal.
 * @param inputHVgateVoltageOutput UEL input HV gate with voltage regulator output.
 */
case class ExcIEEEST1AUELselectorKind
(
    override val sup: BasicElement,
    val ignoreUELsignal: String,
    val inputAddedToErrorSignal: String,
    val inputHVgateErrorSignal: String,
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
    val ignoreUELsignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.ignoreUELsignal"""))
    val inputAddedToErrorSignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputAddedToErrorSignal"""))
    val inputHVgateErrorSignal = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputHVgateErrorSignal"""))
    val inputHVgateVoltageOutput = parse_attribute (attribute ("""ExcIEEEST1AUELselectorKind.inputHVgateVoltageOutput"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Maximum field voltage (E<sub>FDMax</sub>).
 *        Typical Value = 99.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        Typical Value = 120.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 1.82.
 * @param ke Exciter constant related to self-excited field (K<sub>E</sub>).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (K<sub>F</sub>).
 *        Typical Value = 0.05.
 * @param ki Potential circuit gain coefficient (K<sub>I</sub>).
 *        Typical Value = 8.
 * @param kp Potential circuit gain coefficient (K<sub>P</sub>).
 *        Typical Value = 4.88.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.15.
 * @param te Exciter time constant, integration rate associated with exciter control (T<sub>E</sub>).
 *        Typical Value = 0.5.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value = 1.
 * @param uelin UEL input (UELin).
true = HV gate
false = add to error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator outputs (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator outputs (V<sub>RMIN</sub>).
 *        Typical Value = 0.
 */
case class ExcIEEEST2A
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val ka: Double,
    val kc: Double,
    val ke: Double,
    val kf: Double,
    val ki: Double,
    val kp: Double,
    val ta: Double,
    val te: Double,
    val tf: Double,
    val uelin: Boolean,
    val vrmax: Double,
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
    val efdmax = parse_element (element ("""ExcIEEEST2A.efdmax"""))
    val ka = parse_element (element ("""ExcIEEEST2A.ka"""))
    val kc = parse_element (element ("""ExcIEEEST2A.kc"""))
    val ke = parse_element (element ("""ExcIEEEST2A.ke"""))
    val kf = parse_element (element ("""ExcIEEEST2A.kf"""))
    val ki = parse_element (element ("""ExcIEEEST2A.ki"""))
    val kp = parse_element (element ("""ExcIEEEST2A.kp"""))
    val ta = parse_element (element ("""ExcIEEEST2A.ta"""))
    val te = parse_element (element ("""ExcIEEEST2A.te"""))
    val tf = parse_element (element ("""ExcIEEEST2A.tf"""))
    val uelin = parse_element (element ("""ExcIEEEST2A.uelin"""))
    val vrmax = parse_element (element ("""ExcIEEEST2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST2A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ka Voltage regulator gain (K<sub>A</sub>).
 *        This is parameter K in the IEEE Std. Typical Value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.2.
 * @param kg Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
 *        Typical Value = 1.
 * @param ki Potential circuit gain coefficient (K<sub>I</sub>).
 *        Typical Value = 0.
 * @param km Forward gain constant of the inner loop field regulator (K<sub>M</sub>).
 *        Typical Value = 7.93.
 * @param kp Potential circuit gain coefficient (K<sub>P</sub>).
 *        Typical Value = 6.15.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.
 * @param tb Voltage regulator time constant (T<sub>B</sub>).
 *        Typical Value = 10.
 * @param tc Voltage regulator time constant (T<sub>C</sub>).
 *        Typical Value = 1.
 * @param thetap Potential circuit phase angle (thetap).
 *        Typical Value = 0.
 * @param tm Forward time constant of inner loop field regulator (T<sub>M</sub>).
 *        Typical Value = 0.4.
 * @param vbmax Maximum excitation voltage (V<sub>BMax</sub>).
 *        Typical Value = 6.9.
 * @param vgmax Maximum inner loop feedback voltage (V<sub>GMax</sub>).
 *        Typical Value = 5.8.
 * @param vimax Maximum voltage regulator input limit (V<sub>IMAX</sub>).
 *        Typical Value = 0.2.
 * @param vimin Minimum voltage regulator input limit (V<sub>IMIN</sub>).
 *        Typical Value = -0.2.
 * @param vmmax Maximum inner loop output (V<sub>MMax</sub>).
 *        Typical Value = 1.
 * @param vmmin Minimum inner loop output (V<sub>MMin</sub>).
 *        Typical Value = 0.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 10.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -10.
 * @param xl Reactance associated with potential source (X<sub>L</sub>).
 *        Typical Value = 0.081.
 */
case class ExcIEEEST3A
(
    override val sup: ExcitationSystemDynamics,
    val ka: Double,
    val kc: Double,
    val kg: Double,
    val ki: Double,
    val km: Double,
    val kp: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val thetap: Double,
    val tm: Double,
    val vbmax: Double,
    val vgmax: Double,
    val vimax: Double,
    val vimin: Double,
    val vmmax: Double,
    val vmmin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val ka = parse_element (element ("""ExcIEEEST3A.ka"""))
    val kc = parse_element (element ("""ExcIEEEST3A.kc"""))
    val kg = parse_element (element ("""ExcIEEEST3A.kg"""))
    val ki = parse_element (element ("""ExcIEEEST3A.ki"""))
    val km = parse_element (element ("""ExcIEEEST3A.km"""))
    val kp = parse_element (element ("""ExcIEEEST3A.kp"""))
    val ta = parse_element (element ("""ExcIEEEST3A.ta"""))
    val tb = parse_element (element ("""ExcIEEEST3A.tb"""))
    val tc = parse_element (element ("""ExcIEEEST3A.tc"""))
    val thetap = parse_element (element ("""ExcIEEEST3A.thetap"""))
    val tm = parse_element (element ("""ExcIEEEST3A.tm"""))
    val vbmax = parse_element (element ("""ExcIEEEST3A.vbmax"""))
    val vgmax = parse_element (element ("""ExcIEEEST3A.vgmax"""))
    val vimax = parse_element (element ("""ExcIEEEST3A.vimax"""))
    val vimin = parse_element (element ("""ExcIEEEST3A.vimin"""))
    val vmmax = parse_element (element ("""ExcIEEEST3A.vmmax"""))
    val vmmin = parse_element (element ("""ExcIEEEST3A.vmmin"""))
    val vrmax = parse_element (element ("""ExcIEEEST3A.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST3A.vrmin"""))
    val xl = parse_element (element ("""ExcIEEEST3A.xl"""))
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
 * @param sup Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (K<sub>C</sub>).
 *        Typical Value = 0.113.
 * @param kg Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
 *        Typical Value = 0.
 * @param ki Potential circuit gain coefficient (K<sub>I</sub>).
 *        Typical Value = 0.
 * @param kim Voltage regulator integral gain output (K<sub>IM</sub>).
 *        Typical Value = 0.
 * @param kir Voltage regulator integral gain (K<sub>IR</sub>).
 *        Typical Value = 10.75.
 * @param kp Potential circuit gain coefficient (K<sub>P</sub>).
 *        Typical Value = 9.3.
 * @param kpm Voltage regulator proportional gain output (K<sub>PM</sub>).
 *        Typical Value = 1.
 * @param kpr Voltage regulator proportional gain (K<sub>PR</sub>).
 *        Typical Value = 10.75.
 * @param ta Voltage regulator time constant (T<sub>A</sub>).
 *        Typical Value = 0.02.
 * @param thetap Potential circuit phase angle (thetap).
 *        Typical Value = 0.
 * @param vbmax Maximum excitation voltage (V<sub>BMax</sub>).
 *        Typical Value = 11.63.
 * @param vmmax Maximum inner loop output (V<sub>MMax</sub>).
 *        Typical Value = 99.
 * @param vmmin Minimum inner loop output (V<sub>MMin</sub>).
 *        Typical Value = -99.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -0.87.
 * @param xl Reactance associated with potential source (X<sub>L</sub>).
 *        Typical Value = 0.124.
 */
case class ExcIEEEST4B
(
    override val sup: ExcitationSystemDynamics,
    val kc: Double,
    val kg: Double,
    val ki: Double,
    val kim: Double,
    val kir: Double,
    val kp: Double,
    val kpm: Double,
    val kpr: Double,
    val ta: Double,
    val thetap: Double,
    val vbmax: Double,
    val vmmax: Double,
    val vmmin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val kc = parse_element (element ("""ExcIEEEST4B.kc"""))
    val kg = parse_element (element ("""ExcIEEEST4B.kg"""))
    val ki = parse_element (element ("""ExcIEEEST4B.ki"""))
    val kim = parse_element (element ("""ExcIEEEST4B.kim"""))
    val kir = parse_element (element ("""ExcIEEEST4B.kir"""))
    val kp = parse_element (element ("""ExcIEEEST4B.kp"""))
    val kpm = parse_element (element ("""ExcIEEEST4B.kpm"""))
    val kpr = parse_element (element ("""ExcIEEEST4B.kpr"""))
    val ta = parse_element (element ("""ExcIEEEST4B.ta"""))
    val thetap = parse_element (element ("""ExcIEEEST4B.thetap"""))
    val vbmax = parse_element (element ("""ExcIEEEST4B.vbmax"""))
    val vmmax = parse_element (element ("""ExcIEEEST4B.vmmax"""))
    val vmmin = parse_element (element ("""ExcIEEEST4B.vmmin"""))
    val vrmax = parse_element (element ("""ExcIEEEST4B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST4B.vrmin"""))
    val xl = parse_element (element ("""ExcIEEEST4B.xl"""))
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
 * @param sup Reference to the superclass object.
 * @param kc Rectifier regulation factor (K<sub>C</sub>).
 *        Typical Value = 0.004.
 * @param kr Regulator gain (K<sub>R</sub>).
 *        Typical Value = 200.
 * @param t1 Firing circuit time constant (T1).
 *        Typical Value = 0.004.
 * @param tb1 Regulator lag time constant (T<sub>B1</sub>).
 *        Typical Value = 6.
 * @param tb2 Regulator lag time constant (T<sub>B2</sub>).
 *        Typical Value = 0.01.
 * @param tc1 Regulator lead time constant (T<sub>C1</sub>).
 *        Typical Value = 0.8.
 * @param tc2 Regulator lead time constant (T<sub>C2</sub>).
 *        Typical Value = 0.08.
 * @param tob1 OEL lag time constant (T<sub>OB1</sub>).
 *        Typical Value = 2.
 * @param tob2 OEL lag time constant (T<sub>OB2</sub>).
 *        Typical Value = 0.08.
 * @param toc1 OEL lead time constant (T<sub>OC1</sub>).
 *        Typical Value = 0.1.
 * @param toc2 OEL lead time constant (T<sub>OC2</sub>).
 *        Typical Value = 0.08.
 * @param tub1 UEL lag time constant (T<sub>UB1</sub>).
 *        Typical Value = 10.
 * @param tub2 UEL lag time constant (T<sub>UB2</sub>).
 *        Typical Value = 0.05.
 * @param tuc1 UEL lead time constant (T<sub>UC1</sub>).
 *        Typical Value = 2.
 * @param tuc2 UEL lead time constant (T<sub>UC2</sub>).
 *        Typical Value = 0.1.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -4.
 */
case class ExcIEEEST5B
(
    override val sup: ExcitationSystemDynamics,
    val kc: Double,
    val kr: Double,
    val t1: Double,
    val tb1: Double,
    val tb2: Double,
    val tc1: Double,
    val tc2: Double,
    val tob1: Double,
    val tob2: Double,
    val toc1: Double,
    val toc2: Double,
    val tub1: Double,
    val tub2: Double,
    val tuc1: Double,
    val tuc2: Double,
    val vrmax: Double,
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
    val kc = parse_element (element ("""ExcIEEEST5B.kc"""))
    val kr = parse_element (element ("""ExcIEEEST5B.kr"""))
    val t1 = parse_element (element ("""ExcIEEEST5B.t1"""))
    val tb1 = parse_element (element ("""ExcIEEEST5B.tb1"""))
    val tb2 = parse_element (element ("""ExcIEEEST5B.tb2"""))
    val tc1 = parse_element (element ("""ExcIEEEST5B.tc1"""))
    val tc2 = parse_element (element ("""ExcIEEEST5B.tc2"""))
    val tob1 = parse_element (element ("""ExcIEEEST5B.tob1"""))
    val tob2 = parse_element (element ("""ExcIEEEST5B.tob2"""))
    val toc1 = parse_element (element ("""ExcIEEEST5B.toc1"""))
    val toc2 = parse_element (element ("""ExcIEEEST5B.toc2"""))
    val tub1 = parse_element (element ("""ExcIEEEST5B.tub1"""))
    val tub2 = parse_element (element ("""ExcIEEEST5B.tub2"""))
    val tuc1 = parse_element (element ("""ExcIEEEST5B.tuc1"""))
    val tuc2 = parse_element (element ("""ExcIEEEST5B.tuc2"""))
    val vrmax = parse_element (element ("""ExcIEEEST5B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST5B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param ilr Exciter output current limit reference (I<sub>LR</sub>).
 *        Typical Value = 4.164.
 * @param kci Exciter output current limit adjustment (K<sub>CI</sub>).
 *        Typical Value = 1.0577.
 * @param kff Pre-control gain constant of the inner loop field regulator (K<sub>FF</sub>).
 *        Typical Value = 1.
 * @param kg Feedback gain constant of the inner loop field regulator (K<sub>G</sub>).
 *        Typical Value = 1.
 * @param kia Voltage regulator integral gain (K<sub>IA</sub>).
 *        Typical Value = 45.094.
 * @param klr Exciter output current limiter gain (K<sub>LR</sub>).
 *        Typical Value = 17.33.
 * @param km Forward gain constant of the inner loop field regulator (K<sub>M</sub>).
 *        Typical Value = 1.
 * @param kpa Voltage regulator proportional gain (K<sub>PA</sub>).
 *        Typical Value = 18.038.
 * @param oelin OEL input selector (OELin).
 *        Typical Value = noOELinput.
 * @param tg Feedback time constant of inner loop field voltage regulator (T<sub>G</sub>).
 *        Typical Value = 0.02.
 * @param vamax Maximum voltage regulator output (V<sub>AMAX</sub>).
 *        Typical Value = 4.81.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>).
 *        Typical Value = -3.85.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 4.81.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -3.85.
 */
case class ExcIEEEST6B
(
    override val sup: ExcitationSystemDynamics,
    val ilr: Double,
    val kci: Double,
    val kff: Double,
    val kg: Double,
    val kia: Double,
    val klr: Double,
    val km: Double,
    val kpa: Double,
    val oelin: String,
    val tg: Double,
    val vamax: Double,
    val vamin: Double,
    val vrmax: Double,
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
    val ilr = parse_element (element ("""ExcIEEEST6B.ilr"""))
    val kci = parse_element (element ("""ExcIEEEST6B.kci"""))
    val kff = parse_element (element ("""ExcIEEEST6B.kff"""))
    val kg = parse_element (element ("""ExcIEEEST6B.kg"""))
    val kia = parse_element (element ("""ExcIEEEST6B.kia"""))
    val klr = parse_element (element ("""ExcIEEEST6B.klr"""))
    val km = parse_element (element ("""ExcIEEEST6B.km"""))
    val kpa = parse_element (element ("""ExcIEEEST6B.kpa"""))
    val oelin = parse_attribute (attribute ("""ExcIEEEST6B.oelin"""))
    val tg = parse_element (element ("""ExcIEEEST6B.tg"""))
    val vamax = parse_element (element ("""ExcIEEEST6B.vamax"""))
    val vamin = parse_element (element ("""ExcIEEEST6B.vamin"""))
    val vrmax = parse_element (element ("""ExcIEEEST6B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST6B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param kh High-value gate feedback gain (K<sub>H</sub>).
 *        Typical Value 1.
 * @param kia Voltage regulator integral gain (K<sub>IA</sub>).
 *        Typical Value = 1.
 * @param kl Low-value gate feedback gain (K<sub>L</sub>).
 *        Typical Value 1.
 * @param kpa Voltage regulator proportional gain (K<sub>PA</sub>).
 *        Typical Value = 40.
 * @param oelin OEL input selector (OELin).
 *        Typical Value = noOELinput.
 * @param tb Regulator lag time constant (T<sub>B</sub>).
 *        Typical Value 1.
 * @param tc Regulator lead time constant (T<sub>C</sub>).
 *        Typical Value 1.
 * @param tf Excitation control system stabilizer time constant (T<sub>F</sub>).
 *        Typical Value 1.
 * @param tg Feedback time constant of inner loop field voltage regulator (T<sub>G</sub>).
 *        Typical Value 1.
 * @param tia Feedback time constant (T<sub>IA</sub>).
 *        Typical Value = 3.
 * @param uelin UEL input selector (UELin).
 *        Typical Value = noUELinput.
 * @param vmax Maximum voltage reference signal (V<sub>MAX</sub>).
 *        Typical Value = 1.1.
 * @param vmin Minimum voltage reference signal (V<sub>MIN</sub>).
 *        Typical Value = 0.9.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -4.5.
 */
case class ExcIEEEST7B
(
    override val sup: ExcitationSystemDynamics,
    val kh: Double,
    val kia: Double,
    val kl: Double,
    val kpa: Double,
    val oelin: String,
    val tb: Double,
    val tc: Double,
    val tf: Double,
    val tg: Double,
    val tia: Double,
    val uelin: String,
    val vmax: Double,
    val vmin: Double,
    val vrmax: Double,
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
    val kh = parse_element (element ("""ExcIEEEST7B.kh"""))
    val kia = parse_element (element ("""ExcIEEEST7B.kia"""))
    val kl = parse_element (element ("""ExcIEEEST7B.kl"""))
    val kpa = parse_element (element ("""ExcIEEEST7B.kpa"""))
    val oelin = parse_attribute (attribute ("""ExcIEEEST7B.oelin"""))
    val tb = parse_element (element ("""ExcIEEEST7B.tb"""))
    val tc = parse_element (element ("""ExcIEEEST7B.tc"""))
    val tf = parse_element (element ("""ExcIEEEST7B.tf"""))
    val tg = parse_element (element ("""ExcIEEEST7B.tg"""))
    val tia = parse_element (element ("""ExcIEEEST7B.tia"""))
    val uelin = parse_attribute (attribute ("""ExcIEEEST7B.uelin"""))
    val vmax = parse_element (element ("""ExcIEEEST7B.vmax"""))
    val vmin = parse_element (element ("""ExcIEEEST7B.vmin"""))
    val vrmax = parse_element (element ("""ExcIEEEST7B.vrmax"""))
    val vrmin = parse_element (element ("""ExcIEEEST7B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Saturation parameter (E<sub>1</sub>).
 * @param e2 Saturation parameter (E<sub>2</sub>).
 * @param ka Gain (K<sub>A</sub>).
 * @param kc Gain (K<sub>C</sub>).
 * @param kd Gain (K<sub>D</sub>).
 * @param ke Gain (K<sub>E</sub>).
 * @param kf Gain (K<sub>F</sub>).
 * @param see1 Saturation parameter (S<sub>E</sub>(E<sub>1</sub>)).
 * @param see2 Saturation parameter (S<sub>E</sub>(E<sub>2</sub>)).
 * @param t1 Time constant (T<sub>1</sub>).
 * @param t2 Time constant (T<sub>2</sub>).
 * @param t3 Time constant (T<sub>3</sub>).
 * @param t4 Time constant (T<sub>4</sub>).
 * @param t5 Time constant (T<sub>5</sub>).
 * @param t6 Time constant (T<sub>6</sub>).
 * @param te Time constant (T<sub>E</sub>).
 * @param tf Time constant (T<sub>F</sub>).
 * @param vrmax Limiter (V<sub>RMAX</sub>).
 * @param vrmin Limiter (V<sub>RMIN</sub>).
 */
case class ExcOEX3T
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val ka: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kf: Double,
    val see1: Double,
    val see2: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val t4: Double,
    val t5: Double,
    val t6: Double,
    val te: Double,
    val tf: Double,
    val vrmax: Double,
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
    val e1 = parse_element (element ("""ExcOEX3T.e1"""))
    val e2 = parse_element (element ("""ExcOEX3T.e2"""))
    val ka = parse_element (element ("""ExcOEX3T.ka"""))
    val kc = parse_element (element ("""ExcOEX3T.kc"""))
    val kd = parse_element (element ("""ExcOEX3T.kd"""))
    val ke = parse_element (element ("""ExcOEX3T.ke"""))
    val kf = parse_element (element ("""ExcOEX3T.kf"""))
    val see1 = parse_element (element ("""ExcOEX3T.see1"""))
    val see2 = parse_element (element ("""ExcOEX3T.see2"""))
    val t1 = parse_element (element ("""ExcOEX3T.t1"""))
    val t2 = parse_element (element ("""ExcOEX3T.t2"""))
    val t3 = parse_element (element ("""ExcOEX3T.t3"""))
    val t4 = parse_element (element ("""ExcOEX3T.t4"""))
    val t5 = parse_element (element ("""ExcOEX3T.t5"""))
    val t6 = parse_element (element ("""ExcOEX3T.t6"""))
    val te = parse_element (element ("""ExcOEX3T.te"""))
    val tf = parse_element (element ("""ExcOEX3T.tf"""))
    val vrmax = parse_element (element ("""ExcOEX3T.vrmax"""))
    val vrmin = parse_element (element ("""ExcOEX3T.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Field voltage value 1 (E1).
 *        Typical Value = 0.
 * @param e2 Field voltage value 2 (E2).
 *        Typical Value = 0.
 * @param efdmax Exciter maximum limit (Efdmax).
 *        Typical Value = 8.
 * @param efdmin Exciter minimum limit (Efdmin).
 *        Typical Value = -0.87.
 * @param ka PI controller gain (Ka).
 *        Typical Value = 3.15.
 * @param kc Exciter regulation factor (Kc).
 *        Typical Value = 0.08.
 * @param ke Exciter constant (Ke).
 *        Typical Value = 0.
 * @param kf Rate feedback gain (Kf).
 *        Typical Value = 0.
 * @param ki Current source gain (Ki).
 *        Typical Value = 0.
 * @param kp Potential source gain (Kp).
 *        Typical Value = 6.5.
 * @param se1 Saturation factor at E1 (Se1).
 *        Typical Value = 0.
 * @param se2 Saturation factor at E2 (Se2).
 *        Typical Value = 0.
 * @param ta1 PI controller time constant (Ta1).
 *        Typical Value = 1.
 * @param ta2 Voltage regulator time constant (Ta2).
 *        Typical Value = 0.01.
 * @param ta3 Lead time constant (Ta3).
 *        Typical Value = 0.
 * @param ta4 Lag time constant (Ta4).
 *        Typical Value = 0.
 * @param te Exciter time constant (Te).
 *        Typical Value = 0.
 * @param tf1 Rate feedback time constant (Tf1).
 *        Typical Value = 0.
 * @param tf2 Rate feedback lag time constant (Tf2).
 *        Typical Value = 0.
 * @param vr1 PI maximum limit (Vr1).
 *        Typical Value = 1.
 * @param vr2 PI minimum limit (Vr2).
 *        Typical Value = -0.87.
 * @param vrmax Voltage regulator maximum limit (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Voltage regulator minimum limit (Vrmin).
 *        Typical Value = -0.87.
 */
case class ExcPIC
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val efdmax: Double,
    val efdmin: Double,
    val ka: Double,
    val kc: Double,
    val ke: Double,
    val kf: Double,
    val ki: Double,
    val kp: Double,
    val se1: Double,
    val se2: Double,
    val ta1: Double,
    val ta2: Double,
    val ta3: Double,
    val ta4: Double,
    val te: Double,
    val tf1: Double,
    val tf2: Double,
    val vr1: Double,
    val vr2: Double,
    val vrmax: Double,
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
    val e1 = parse_element (element ("""ExcPIC.e1"""))
    val e2 = parse_element (element ("""ExcPIC.e2"""))
    val efdmax = parse_element (element ("""ExcPIC.efdmax"""))
    val efdmin = parse_element (element ("""ExcPIC.efdmin"""))
    val ka = parse_element (element ("""ExcPIC.ka"""))
    val kc = parse_element (element ("""ExcPIC.kc"""))
    val ke = parse_element (element ("""ExcPIC.ke"""))
    val kf = parse_element (element ("""ExcPIC.kf"""))
    val ki = parse_element (element ("""ExcPIC.ki"""))
    val kp = parse_element (element ("""ExcPIC.kp"""))
    val se1 = parse_element (element ("""ExcPIC.se1"""))
    val se2 = parse_element (element ("""ExcPIC.se2"""))
    val ta1 = parse_element (element ("""ExcPIC.ta1"""))
    val ta2 = parse_element (element ("""ExcPIC.ta2"""))
    val ta3 = parse_element (element ("""ExcPIC.ta3"""))
    val ta4 = parse_element (element ("""ExcPIC.ta4"""))
    val te = parse_element (element ("""ExcPIC.te"""))
    val tf1 = parse_element (element ("""ExcPIC.tf1"""))
    val tf2 = parse_element (element ("""ExcPIC.tf2"""))
    val vr1 = parse_element (element ("""ExcPIC.vr1"""))
    val vr2 = parse_element (element ("""ExcPIC.vr2"""))
    val vrmax = parse_element (element ("""ExcPIC.vrmax"""))
    val vrmin = parse_element (element ("""ExcPIC.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param e1 Field voltage value 1 (E1).
 *        Typical Value = 3.
 * @param e2 Field voltage value 2 (E2).
 *        Typical Value = 4.
 * @param fbf Rate feedback signal flag (Fbf).
 *        Typical Value = fieldCurrent.
 * @param flimf Limit type flag (Flimf).
 *        Typical Value = 0.
 * @param kc Rectifier regulation factor (Kc).
 *        Typical Value = 0.05.
 * @param kd Exciter regulation factor (Kd).
 *        Typical Value = 2.
 * @param ke Exciter field proportional constant (Ke).
 *        Typical Value = 1.
 * @param kefd Field voltage feedback gain (Kefd).
 *        Typical Value = 0.
 * @param kf Rate feedback gain (Kf).
 *        Typical Value = 0.05.
 * @param kh Field voltage controller feedback gain (Kh).
 *        Typical Value = 0.
 * @param kii Field Current Regulator Integral Gain (Kii).
 *        Typical Value = 0.
 * @param kip Field Current Regulator Proportional Gain (Kip).
 *        Typical Value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param kvi Voltage Regulator Integral Gain (Kvi).
 *        Typical Value = 0.
 * @param kvp Voltage Regulator Proportional Gain (Kvp).
 *        Typical Value = 2800.
 * @param kvphz V/Hz limiter gain (Kvphz).
 *        Typical Value = 0.
 * @param nvphz Pickup speed of V/Hz limiter (Nvphz).
 *        Typical Value = 0.
 * @param se1 Saturation factor at E1 (Se1).
 *        Typical Value = 0.0001.
 * @param se2 Saturation factor at E2 (Se2).
 *        Typical Value = 0.001.
 * @param ta Voltage Regulator time constant (Ta).
 *        Typical Value = 0.01.
 * @param tb1 Lag time constant (Tb1).
 *        Typical Value = 0.
 * @param tb2 Lag time constant (Tb2).
 *        Typical Value = 0.
 * @param tc1 Lead time constant (Tc1).
 *        Typical Value = 0.
 * @param tc2 Lead time constant (Tc2).
 *        Typical Value = 0.
 * @param te Exciter field time constant (Te).
 *        Typical Value = 1.2.
 * @param tf Rate feedback time constant (Tf).
 *        Typical Value = 1.
 * @param tf1 Feedback lead time constant (Tf1).
 *        Typical Value = 0.
 * @param tf2 Feedback lag time constant (Tf2).
 *        Typical Value = 0.
 * @param tp Field current Bridge time constant (Tp).
 *        Typical Value = 0.
 * @param vcmax Maximum compounding voltage (Vcmax).
 *        Typical Value = 0.
 * @param vfmax Maximum Exciter Field Current (Vfmax).
 *        Typical Value = 47.
 * @param vfmin Minimum Exciter Field Current (Vfmin).
 *        Typical Value = -20.
 * @param vimax Voltage Regulator Input Limit (Vimax).
 *        Typical Value = 0.1.
 * @param vrmax Maximum controller output (Vrmax).
 *        Typical Value = 47.
 * @param vrmin Minimum controller output (Vrmin).
 *        Typical Value = -20.
 * @param xc Exciter compounding reactance (Xc).
 *        Typical Value = 0.
 */
case class ExcREXS
(
    override val sup: ExcitationSystemDynamics,
    val e1: Double,
    val e2: Double,
    val fbf: String,
    val flimf: Double,
    val kc: Double,
    val kd: Double,
    val ke: Double,
    val kefd: Double,
    val kf: Double,
    val kh: Double,
    val kii: Double,
    val kip: Double,
    val ks: Double,
    val kvi: Double,
    val kvp: Double,
    val kvphz: Double,
    val nvphz: Double,
    val se1: Double,
    val se2: Double,
    val ta: Double,
    val tb1: Double,
    val tb2: Double,
    val tc1: Double,
    val tc2: Double,
    val te: Double,
    val tf: Double,
    val tf1: Double,
    val tf2: Double,
    val tp: Double,
    val vcmax: Double,
    val vfmax: Double,
    val vfmin: Double,
    val vimax: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val e1 = parse_element (element ("""ExcREXS.e1"""))
    val e2 = parse_element (element ("""ExcREXS.e2"""))
    val fbf = parse_attribute (attribute ("""ExcREXS.fbf"""))
    val flimf = parse_element (element ("""ExcREXS.flimf"""))
    val kc = parse_element (element ("""ExcREXS.kc"""))
    val kd = parse_element (element ("""ExcREXS.kd"""))
    val ke = parse_element (element ("""ExcREXS.ke"""))
    val kefd = parse_element (element ("""ExcREXS.kefd"""))
    val kf = parse_element (element ("""ExcREXS.kf"""))
    val kh = parse_element (element ("""ExcREXS.kh"""))
    val kii = parse_element (element ("""ExcREXS.kii"""))
    val kip = parse_element (element ("""ExcREXS.kip"""))
    val ks = parse_element (element ("""ExcREXS.ks"""))
    val kvi = parse_element (element ("""ExcREXS.kvi"""))
    val kvp = parse_element (element ("""ExcREXS.kvp"""))
    val kvphz = parse_element (element ("""ExcREXS.kvphz"""))
    val nvphz = parse_element (element ("""ExcREXS.nvphz"""))
    val se1 = parse_element (element ("""ExcREXS.se1"""))
    val se2 = parse_element (element ("""ExcREXS.se2"""))
    val ta = parse_element (element ("""ExcREXS.ta"""))
    val tb1 = parse_element (element ("""ExcREXS.tb1"""))
    val tb2 = parse_element (element ("""ExcREXS.tb2"""))
    val tc1 = parse_element (element ("""ExcREXS.tc1"""))
    val tc2 = parse_element (element ("""ExcREXS.tc2"""))
    val te = parse_element (element ("""ExcREXS.te"""))
    val tf = parse_element (element ("""ExcREXS.tf"""))
    val tf1 = parse_element (element ("""ExcREXS.tf1"""))
    val tf2 = parse_element (element ("""ExcREXS.tf2"""))
    val tp = parse_element (element ("""ExcREXS.tp"""))
    val vcmax = parse_element (element ("""ExcREXS.vcmax"""))
    val vfmax = parse_element (element ("""ExcREXS.vfmax"""))
    val vfmin = parse_element (element ("""ExcREXS.vfmin"""))
    val vimax = parse_element (element ("""ExcREXS.vimax"""))
    val vrmax = parse_element (element ("""ExcREXS.vrmax"""))
    val vrmin = parse_element (element ("""ExcREXS.vrmin"""))
    val xc = parse_element (element ("""ExcREXS.xc"""))
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
 * @param sup Reference to the superclass object.
 * @param fieldCurrent The exciter field current is used.
 * @param fieldVoltage The voltage regulator output voltage is used.
 *        It is the same as exciter field voltage.
 * @param outputVoltage The output voltage of the exciter is used.
 */
case class ExcREXSFeedbackSignalKind
(
    override val sup: BasicElement,
    val fieldCurrent: String,
    val fieldVoltage: String,
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
    val fieldCurrent = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.fieldCurrent"""))
    val fieldVoltage = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.fieldVoltage"""))
    val outputVoltage = parse_attribute (attribute ("""ExcREXSFeedbackSignalKind.outputVoltage"""))
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
 * @param sup Reference to the superclass object.
 * @param cswitch Power source switch (Cswitch).
true = fixed voltage of 1.0 PU
 *        false = generator terminal voltage.
 * @param emax Maximum field voltage output (Emax).
 *        Typical Value = 5.
 * @param emin Minimum field voltage output (Emin).
 *        Typical Value = 0.
 * @param k Gain (K) (&gt;0).
 *        Typical Value = 200.
 * @param rcrfd Rc/Rfd - ratio of field discharge resistance to field winding resistance (RcRfd).
 *        Typical Value = 0.
 * @param tatb Ta/Tb - gain reduction ratio of lag-lead element (TaTb).
 *        The parameter Ta is not defined explicitly.  Typical Value = 0.1.
 * @param tb Denominator time constant of lag-lead block (Tb).
 *        Typical Value = 10.
 * @param te Time constant of gain block (Te) (&gt;0).
 *        Typical Value = 0.02.
 */
case class ExcSCRX
(
    override val sup: ExcitationSystemDynamics,
    val cswitch: Boolean,
    val emax: Double,
    val emin: Double,
    val k: Double,
    val rcrfd: Double,
    val tatb: Double,
    val tb: Double,
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
    val cswitch = parse_element (element ("""ExcSCRX.cswitch"""))
    val emax = parse_element (element ("""ExcSCRX.emax"""))
    val emin = parse_element (element ("""ExcSCRX.emin"""))
    val k = parse_element (element ("""ExcSCRX.k"""))
    val rcrfd = parse_element (element ("""ExcSCRX.rcrfd"""))
    val tatb = parse_element (element ("""ExcSCRX.tatb"""))
    val tb = parse_element (element ("""ExcSCRX.tb"""))
    val te = parse_element (element ("""ExcSCRX.te"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Field voltage clipping maximum limit (Efdmax).
 *        Typical Value = 5.
 * @param efdmin Field voltage clipping minimum limit (Efdmin).
 *        Typical Value = -5.
 * @param emax Maximum field voltage output (Emax).
 *        Typical Value = 5.
 * @param emin Minimum field voltage output (Emin).
 *        Typical Value = -5.
 * @param k Gain (K) (&gt;0).
 *        Typical Value = 100.
 * @param kc PI controller gain (Kc).
 *        Typical Value = 0.08.
 * @param tatb Ta/Tb - gain reduction ratio of lag-lead element (TaTb).
 *        Typical Value = 0.1.
 * @param tb Denominator time constant of lag-lead block (Tb).
 *        Typical Value = 10.
 * @param tc PI controller phase lead time constant (Tc).
 *        Typical Value = 0.
 * @param te Time constant of gain block (Te).
 *        Typical Value = 0.05.
 */
case class ExcSEXS
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val efdmin: Double,
    val emax: Double,
    val emin: Double,
    val k: Double,
    val kc: Double,
    val tatb: Double,
    val tb: Double,
    val tc: Double,
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
    val efdmax = parse_element (element ("""ExcSEXS.efdmax"""))
    val efdmin = parse_element (element ("""ExcSEXS.efdmin"""))
    val emax = parse_element (element ("""ExcSEXS.emax"""))
    val emin = parse_element (element ("""ExcSEXS.emin"""))
    val k = parse_element (element ("""ExcSEXS.k"""))
    val kc = parse_element (element ("""ExcSEXS.kc"""))
    val tatb = parse_element (element ("""ExcSEXS.tatb"""))
    val tb = parse_element (element ("""ExcSEXS.tb"""))
    val tc = parse_element (element ("""ExcSEXS.tc"""))
    val te = parse_element (element ("""ExcSEXS.te"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Field voltage clipping limit (Efdmax).
 * @param efdmin Field voltage clipping limit (Efdmin).
 * @param emax Maximum field voltage output (Emax).
 *        Typical Value = 20.
 * @param emin Minimum field voltage output (Emin).
 *        Typical Value = -20.
 * @param k Gain (K).
 *        Typical Value = 1.
 * @param k1 Parameter of underexcitation limit (K1).
 *        Typical Value = 0.1364.
 * @param k2 Parameter of underexcitation limit (K2).
 *        Typical Value = -0.3861.
 * @param kc PI controller gain (Kc).
 *        Typical Value = 70.
 * @param kce Rectifier regulation factor (Kce).
 *        Typical Value = 0.
 * @param kd Exciter internal reactance (Kd).
 *        Typical Value = 0.
 * @param kgob P controller gain (Kgob).
 *        Typical Value = 10.
 * @param kp PI controller gain (Kp).
 *        Typical Value = 1.
 * @param kqi PI controller gain of integral component (Kqi).
 *        Typical Value = 0.
 * @param kqob Rate of rise of the reactive power (Kqob).
 * @param kqp PI controller gain (Kqp).
 *        Typical Value = 0.
 * @param nq Dead band of reactive power (nq).
 *        Determines the range of sensitivity.  Typical Value = 0.001.
 * @param qconoff Secondary voltage control state (Qc_on_off).
true = secondary voltage control is ON
false = secondary voltage control is OFF.
 *        Typical Value = false.
 * @param qz Desired value (setpoint) of reactive power, manual setting (Qz).
 * @param remote Selector to apply automatic calculation in secondary controller model.
true = automatic calculation is activated
false = manual set is active; the use of desired value of reactive power (Qz) is required.
 *        Typical Value = true.
 * @param sbase Apparent power of the unit (Sbase).
 *        Unit = MVA.  Typical Value = 259.
 * @param tc PI controller phase lead time constant (Tc).
 *        Typical Value = 8.
 * @param te Time constant of gain block (Te).
 *        Typical Value = 0.1.
 * @param ti PI controller phase lead time constant (Ti).
 *        Typical Value = 2.
 * @param tp Time constant (Tp).
 *        Typical Value = 0.1.
 * @param tr Voltage transducer time constant (Tr).
 *        Typical Value = 0.01.
 * @param uimax Maximum error (Uimax).
 *        Typical Value = 10.
 * @param uimin Minimum error (UImin).
 *        Typical Value = -10.
 * @param urmax Maximum controller output (URmax).
 *        Typical Value = 10.
 * @param urmin Minimum controller output (URmin).
 *        Typical Value = -10.
 * @param vtmax Maximum terminal voltage input (Vtmax).
 *        Determines the range of voltage dead band.  Typical Value = 1.05.
 * @param vtmin Minimum terminal voltage input (Vtmin).
 *        Determines the range of voltage dead band.  Typical Value = 0.95.
 * @param yp Maximum output (Yp).
 *        Minimum output = 0.  Typical Value = 1.
 */
case class ExcSK
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val efdmin: Double,
    val emax: Double,
    val emin: Double,
    val k: Double,
    val k1: Double,
    val k2: Double,
    val kc: Double,
    val kce: Double,
    val kd: Double,
    val kgob: Double,
    val kp: Double,
    val kqi: Double,
    val kqob: Double,
    val kqp: Double,
    val nq: Double,
    val qconoff: Boolean,
    val qz: Double,
    val remote: Boolean,
    val sbase: Double,
    val tc: Double,
    val te: Double,
    val ti: Double,
    val tp: Double,
    val tr: Double,
    val uimax: Double,
    val uimin: Double,
    val urmax: Double,
    val urmin: Double,
    val vtmax: Double,
    val vtmin: Double,
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
    val efdmax = parse_element (element ("""ExcSK.efdmax"""))
    val efdmin = parse_element (element ("""ExcSK.efdmin"""))
    val emax = parse_element (element ("""ExcSK.emax"""))
    val emin = parse_element (element ("""ExcSK.emin"""))
    val k = parse_element (element ("""ExcSK.k"""))
    val k1 = parse_element (element ("""ExcSK.k1"""))
    val k2 = parse_element (element ("""ExcSK.k2"""))
    val kc = parse_element (element ("""ExcSK.kc"""))
    val kce = parse_element (element ("""ExcSK.kce"""))
    val kd = parse_element (element ("""ExcSK.kd"""))
    val kgob = parse_element (element ("""ExcSK.kgob"""))
    val kp = parse_element (element ("""ExcSK.kp"""))
    val kqi = parse_element (element ("""ExcSK.kqi"""))
    val kqob = parse_element (element ("""ExcSK.kqob"""))
    val kqp = parse_element (element ("""ExcSK.kqp"""))
    val nq = parse_element (element ("""ExcSK.nq"""))
    val qconoff = parse_element (element ("""ExcSK.qconoff"""))
    val qz = parse_element (element ("""ExcSK.qz"""))
    val remote = parse_element (element ("""ExcSK.remote"""))
    val sbase = parse_element (element ("""ExcSK.sbase"""))
    val tc = parse_element (element ("""ExcSK.tc"""))
    val te = parse_element (element ("""ExcSK.te"""))
    val ti = parse_element (element ("""ExcSK.ti"""))
    val tp = parse_element (element ("""ExcSK.tp"""))
    val tr = parse_element (element ("""ExcSK.tr"""))
    val uimax = parse_element (element ("""ExcSK.uimax"""))
    val uimin = parse_element (element ("""ExcSK.uimin"""))
    val urmax = parse_element (element ("""ExcSK.urmax"""))
    val urmin = parse_element (element ("""ExcSK.urmin"""))
    val vtmax = parse_element (element ("""ExcSK.vtmax"""))
    val vtmin = parse_element (element ("""ExcSK.vtmin"""))
    val yp = parse_element (element ("""ExcSK.yp"""))
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
 * @param sup Reference to the superclass object.
 * @param ilr Exciter output current limit reference (Ilr).
 *        Typical Value = 0.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 190.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.05.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.
 * @param klr Exciter output current limiter gain (Klr).
 *        Typical Value = 0.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 10.
 * @param tb1 Voltage regulator time constant (Tb<sub>1</sub>).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 1.
 * @param tc1 Voltage regulator time constant (Tc<sub>1</sub>).
 *        Typical Value = 0.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param vamax Maximum voltage regulator output (Vamax).
 *        Typical Value = 999.
 * @param vamin Minimum voltage regulator output (Vamin).
 *        Typical Value = -999.
 * @param vimax Maximum voltage regulator input limit (Vimax).
 *        Typical Value = 999.
 * @param vimin Minimum voltage regulator input limit (Vimin).
 *        Typical Value = -999.
 * @param vrmax Maximum voltage regulator outputs (Vrmax).
 *        Typical Value = 7.8.
 * @param vrmin Minimum voltage regulator outputs (Vrmin).
 *        Typical Value = -6.7.
 * @param xe Excitation xfmr effective reactance (Xe).
 *        Typical Value = 0.04.
 */
case class ExcST1A
(
    override val sup: ExcitationSystemDynamics,
    val ilr: Double,
    val ka: Double,
    val kc: Double,
    val kf: Double,
    val klr: Double,
    val ta: Double,
    val tb: Double,
    val tb1: Double,
    val tc: Double,
    val tc1: Double,
    val tf: Double,
    val vamax: Double,
    val vamin: Double,
    val vimax: Double,
    val vimin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val ilr = parse_element (element ("""ExcST1A.ilr"""))
    val ka = parse_element (element ("""ExcST1A.ka"""))
    val kc = parse_element (element ("""ExcST1A.kc"""))
    val kf = parse_element (element ("""ExcST1A.kf"""))
    val klr = parse_element (element ("""ExcST1A.klr"""))
    val ta = parse_element (element ("""ExcST1A.ta"""))
    val tb = parse_element (element ("""ExcST1A.tb"""))
    val tb1 = parse_element (element ("""ExcST1A.tb1"""))
    val tc = parse_element (element ("""ExcST1A.tc"""))
    val tc1 = parse_element (element ("""ExcST1A.tc1"""))
    val tf = parse_element (element ("""ExcST1A.tf"""))
    val vamax = parse_element (element ("""ExcST1A.vamax"""))
    val vamin = parse_element (element ("""ExcST1A.vamin"""))
    val vimax = parse_element (element ("""ExcST1A.vimax"""))
    val vimin = parse_element (element ("""ExcST1A.vimin"""))
    val vrmax = parse_element (element ("""ExcST1A.vrmax"""))
    val vrmin = parse_element (element ("""ExcST1A.vrmin"""))
    val xe = parse_element (element ("""ExcST1A.xe"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Maximum field voltage (Efdmax).
 *        Typical Value = 99.
 * @param ka Voltage regulator gain (Ka).
 *        Typical Value = 120.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 1.82.
 * @param ke Exciter constant related to self-excited field (Ke).
 *        Typical Value = 1.
 * @param kf Excitation control system stabilizer gains (Kf).
 *        Typical Value = 0.05.
 * @param ki Potential circuit gain coefficient (Ki).
 *        Typical Value = 8.
 * @param kp Potential circuit gain coefficient (Kp).
 *        Typical Value = 4.88.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.15.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 0.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (Te).
 *        Typical Value = 0.5.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 0.7.
 * @param uelin UEL input (UELin).
true = HV gate
false = add to error signal.
 *        Typical Value = false.
 * @param vrmax Maximum voltage regulator outputs (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator outputs (Vrmin).
 *        Typical Value = -1.
 */
case class ExcST2A
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val ka: Double,
    val kc: Double,
    val ke: Double,
    val kf: Double,
    val ki: Double,
    val kp: Double,
    val ta: Double,
    val tb: Double,
    val tc: Double,
    val te: Double,
    val tf: Double,
    val uelin: Boolean,
    val vrmax: Double,
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
    val efdmax = parse_element (element ("""ExcST2A.efdmax"""))
    val ka = parse_element (element ("""ExcST2A.ka"""))
    val kc = parse_element (element ("""ExcST2A.kc"""))
    val ke = parse_element (element ("""ExcST2A.ke"""))
    val kf = parse_element (element ("""ExcST2A.kf"""))
    val ki = parse_element (element ("""ExcST2A.ki"""))
    val kp = parse_element (element ("""ExcST2A.kp"""))
    val ta = parse_element (element ("""ExcST2A.ta"""))
    val tb = parse_element (element ("""ExcST2A.tb"""))
    val tc = parse_element (element ("""ExcST2A.tc"""))
    val te = parse_element (element ("""ExcST2A.te"""))
    val tf = parse_element (element ("""ExcST2A.tf"""))
    val uelin = parse_element (element ("""ExcST2A.uelin"""))
    val vrmax = parse_element (element ("""ExcST2A.vrmax"""))
    val vrmin = parse_element (element ("""ExcST2A.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param efdmax Maximum AVR output (Efdmax).
 *        Typical Value = 6.9.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 1.1.
 * @param kg Feedback gain constant of the inner loop field regulator (Kg).
 *        Typical Value = 1.
 * @param ki Potential circuit gain coefficient (Ki).
 *        Typical Value = 4.83.
 * @param kj AVR gain (Kj).
 *        Typical Value = 200.
 * @param km Forward gain constant of the inner loop field regulator (Km).
 *        Typical Value = 7.04.
 * @param kp Potential source gain (Kp) (&gt;0).
 *        Typical Value = 4.37.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (Ks).
 *        Typical Value = 0.
 * @param ks1 Coefficient to allow different usage of the model-speed coefficient (Ks1).
 *        Typical Value = 0.
 * @param tb Voltage regulator time constant (Tb).
 *        Typical Value = 6.67.
 * @param tc Voltage regulator time constant (Tc).
 *        Typical Value = 1.
 * @param thetap Potential circuit phase angle (thetap).
 *        Typical Value = 20.
 * @param tm Forward time constant of inner loop field regulator (Tm).
 *        Typical Value = 1.
 * @param vbmax Maximum excitation voltage (Vbmax).
 *        Typical Value = 8.63.
 * @param vgmax Maximum inner loop feedback voltage (Vgmax).
 *        Typical Value = 6.53.
 * @param vimax Maximum voltage regulator input limit (Vimax).
 *        Typical Value = 0.2.
 * @param vimin Minimum voltage regulator input limit (Vimin).
 *        Typical Value = -0.2.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = 0.
 * @param xl Reactance associated with potential source (Xl).
 *        Typical Value = 0.09.
 */
case class ExcST3A
(
    override val sup: ExcitationSystemDynamics,
    val efdmax: Double,
    val kc: Double,
    val kg: Double,
    val ki: Double,
    val kj: Double,
    val km: Double,
    val kp: Double,
    val ks: Double,
    val ks1: Double,
    val tb: Double,
    val tc: Double,
    val thetap: Double,
    val tm: Double,
    val vbmax: Double,
    val vgmax: Double,
    val vimax: Double,
    val vimin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val efdmax = parse_element (element ("""ExcST3A.efdmax"""))
    val kc = parse_element (element ("""ExcST3A.kc"""))
    val kg = parse_element (element ("""ExcST3A.kg"""))
    val ki = parse_element (element ("""ExcST3A.ki"""))
    val kj = parse_element (element ("""ExcST3A.kj"""))
    val km = parse_element (element ("""ExcST3A.km"""))
    val kp = parse_element (element ("""ExcST3A.kp"""))
    val ks = parse_element (element ("""ExcST3A.ks"""))
    val ks1 = parse_element (element ("""ExcST3A.ks1"""))
    val tb = parse_element (element ("""ExcST3A.tb"""))
    val tc = parse_element (element ("""ExcST3A.tc"""))
    val thetap = parse_element (element ("""ExcST3A.thetap"""))
    val tm = parse_element (element ("""ExcST3A.tm"""))
    val vbmax = parse_element (element ("""ExcST3A.vbmax"""))
    val vgmax = parse_element (element ("""ExcST3A.vgmax"""))
    val vimax = parse_element (element ("""ExcST3A.vimax"""))
    val vimin = parse_element (element ("""ExcST3A.vimin"""))
    val vrmax = parse_element (element ("""ExcST3A.vrmax"""))
    val vrmin = parse_element (element ("""ExcST3A.vrmin"""))
    val xl = parse_element (element ("""ExcST3A.xl"""))
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
 * @param sup Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (Kc).
 *        Typical Value = 0.113.
 * @param kg Feedback gain constant of the inner loop field regulator (Kg).
 *        Typical Value = 0.
 * @param ki Potential circuit gain coefficient (Ki).
 *        Typical Value = 0.
 * @param kim Voltage regulator integral gain output (Kim).
 *        Typical Value = 0.
 * @param kir Voltage regulator integral gain (Kir).
 *        Typical Value = 10.75.
 * @param kp Potential circuit gain coefficient (Kp).
 *        Typical Value = 9.3.
 * @param kpm Voltage regulator proportional gain output (Kpm).
 *        Typical Value = 1.
 * @param kpr Voltage regulator proportional gain (Kpr).
 *        Typical Value = 10.75.
 * @param lvgate Selector (LVgate).
true = LVgate is part of the block diagram
false = LVgate is not part of the block diagram.
 *        Typical Value = false.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param thetap Potential circuit phase angle (thetap).
 *        Typical Value = 0.
 * @param uel Selector (Uel).
true = UEL is part of block diagram
false = UEL is not part of block diagram.
 *        Typical Value = false.
 * @param vbmax Maximum excitation voltage (Vbmax).
 *        Typical Value = 11.63.
 * @param vgmax Maximum inner loop feedback voltage (Vgmax).
 *        Typical Value = 5.8.
 * @param vmmax Maximum inner loop output (Vmmax).
 *        Typical Value = 99.
 * @param vmmin Minimum inner loop output (Vmmin).
 *        Typical Value = -99.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -0.87.
 * @param xl Reactance associated with potential source (Xl).
 *        Typical Value = 0.124.
 */
case class ExcST4B
(
    override val sup: ExcitationSystemDynamics,
    val kc: Double,
    val kg: Double,
    val ki: Double,
    val kim: Double,
    val kir: Double,
    val kp: Double,
    val kpm: Double,
    val kpr: Double,
    val lvgate: Boolean,
    val ta: Double,
    val thetap: Double,
    val uel: Boolean,
    val vbmax: Double,
    val vgmax: Double,
    val vmmax: Double,
    val vmmin: Double,
    val vrmax: Double,
    val vrmin: Double,
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
    val kc = parse_element (element ("""ExcST4B.kc"""))
    val kg = parse_element (element ("""ExcST4B.kg"""))
    val ki = parse_element (element ("""ExcST4B.ki"""))
    val kim = parse_element (element ("""ExcST4B.kim"""))
    val kir = parse_element (element ("""ExcST4B.kir"""))
    val kp = parse_element (element ("""ExcST4B.kp"""))
    val kpm = parse_element (element ("""ExcST4B.kpm"""))
    val kpr = parse_element (element ("""ExcST4B.kpr"""))
    val lvgate = parse_element (element ("""ExcST4B.lvgate"""))
    val ta = parse_element (element ("""ExcST4B.ta"""))
    val thetap = parse_element (element ("""ExcST4B.thetap"""))
    val uel = parse_element (element ("""ExcST4B.uel"""))
    val vbmax = parse_element (element ("""ExcST4B.vbmax"""))
    val vgmax = parse_element (element ("""ExcST4B.vgmax"""))
    val vmmax = parse_element (element ("""ExcST4B.vmmax"""))
    val vmmin = parse_element (element ("""ExcST4B.vmmin"""))
    val vrmax = parse_element (element ("""ExcST4B.vrmax"""))
    val vrmin = parse_element (element ("""ExcST4B.vrmin"""))
    val xl = parse_element (element ("""ExcST4B.xl"""))
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
 * @param sup Reference to the superclass object.
 * @param ilr Exciter output current limit reference (Ilr).
 *        Typical Value = 4.164.
 * @param k1 Selector (K1).
true = feedback is from Ifd
false = feedback is not from Ifd.
 *        Typical Value = true.
 * @param kcl Exciter output current limit adjustment (Kcl).
 *        Typical Value = 1.0577.
 * @param kff Pre-control gain constant of the inner loop field regulator (Kff).
 *        Typical Value = 1.
 * @param kg Feedback gain constant of the inner loop field regulator (Kg).
 *        Typical Value = 1.
 * @param kia Voltage regulator integral gain (Kia).
 *        Typical Value = 45.094.
 * @param klr Exciter output current limit adjustment (Kcl).
 *        Typical Value = 17.33.
 * @param km Forward gain constant of the inner loop field regulator (Km).
 *        Typical Value = 1.
 * @param kpa Voltage regulator proportional gain (Kpa).
 *        Typical Value = 18.038.
 * @param kvd Voltage regulator derivative gain (Kvd).
 *        Typical Value = 0.
 * @param oelin OEL input selector (OELin).
 *        Typical Value = noOELinput.
 * @param tg Feedback time constant of inner loop field voltage regulator (Tg).
 *        Typical Value = 0.02.
 * @param ts Rectifier firing time constant (Ts).
 *        Typical Value = 0.
 * @param tvd Voltage regulator derivative gain (Tvd).
 *        Typical Value = 0.
 * @param vamax Maximum voltage regulator output (Vamax).
 *        Typical Value = 4.81.
 * @param vamin Minimum voltage regulator output (Vamin).
 *        Typical Value = -3.85.
 * @param vilim Selector (Vilim).
true = Vimin-Vimax limiter is active
false = Vimin-Vimax limiter is not active.
 *        Typical Value = true.
 * @param vimax Maximum voltage regulator input limit (Vimax).
 *        Typical Value = 10.
 * @param vimin Minimum voltage regulator input limit (Vimin).
 *        Typical Value = -10.
 * @param vmult Selector (Vmult).
true = multiply regulator output by terminal voltage
false = do not multiply regulator output by terminal voltage.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 4.81.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -3.85.
 * @param xc Excitation source reactance (Xc).
 *        Typical Value = 0.05.
 */
case class ExcST6B
(
    override val sup: ExcitationSystemDynamics,
    val ilr: Double,
    val k1: Boolean,
    val kcl: Double,
    val kff: Double,
    val kg: Double,
    val kia: Double,
    val klr: Double,
    val km: Double,
    val kpa: Double,
    val kvd: Double,
    val oelin: String,
    val tg: Double,
    val ts: Double,
    val tvd: Double,
    val vamax: Double,
    val vamin: Double,
    val vilim: Boolean,
    val vimax: Double,
    val vimin: Double,
    val vmult: Boolean,
    val vrmax: Double,
    val vrmin: Double,
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
    val ilr = parse_element (element ("""ExcST6B.ilr"""))
    val k1 = parse_element (element ("""ExcST6B.k1"""))
    val kcl = parse_element (element ("""ExcST6B.kcl"""))
    val kff = parse_element (element ("""ExcST6B.kff"""))
    val kg = parse_element (element ("""ExcST6B.kg"""))
    val kia = parse_element (element ("""ExcST6B.kia"""))
    val klr = parse_element (element ("""ExcST6B.klr"""))
    val km = parse_element (element ("""ExcST6B.km"""))
    val kpa = parse_element (element ("""ExcST6B.kpa"""))
    val kvd = parse_element (element ("""ExcST6B.kvd"""))
    val oelin = parse_attribute (attribute ("""ExcST6B.oelin"""))
    val tg = parse_element (element ("""ExcST6B.tg"""))
    val ts = parse_element (element ("""ExcST6B.ts"""))
    val tvd = parse_element (element ("""ExcST6B.tvd"""))
    val vamax = parse_element (element ("""ExcST6B.vamax"""))
    val vamin = parse_element (element ("""ExcST6B.vamin"""))
    val vilim = parse_element (element ("""ExcST6B.vilim"""))
    val vimax = parse_element (element ("""ExcST6B.vimax"""))
    val vimin = parse_element (element ("""ExcST6B.vimin"""))
    val vmult = parse_element (element ("""ExcST6B.vmult"""))
    val vrmax = parse_element (element ("""ExcST6B.vrmax"""))
    val vrmin = parse_element (element ("""ExcST6B.vrmin"""))
    val xc = parse_element (element ("""ExcST6B.xc"""))
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
 * @param sup Reference to the superclass object.
 * @param afterUEL The connection is after UEL.
 * @param beforeUEL The connection is before UEL.
 * @param noOELinput No OEL input is used.
 */
case class ExcST6BOELselectorKind
(
    override val sup: BasicElement,
    val afterUEL: String,
    val beforeUEL: String,
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
    val afterUEL = parse_attribute (attribute ("""ExcST6BOELselectorKind.afterUEL"""))
    val beforeUEL = parse_attribute (attribute ("""ExcST6BOELselectorKind.beforeUEL"""))
    val noOELinput = parse_attribute (attribute ("""ExcST6BOELselectorKind.noOELinput"""))
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
 * @param sup Reference to the superclass object.
 * @param kh High-value gate feedback gain (Kh).
 *        Typical Value = 1.
 * @param kia Voltage regulator integral gain (Kia).
 *        Typical Value = 1.
 * @param kl Low-value gate feedback gain (Kl).
 *        Typical Value = 1.
 * @param kpa Voltage regulator proportional gain (Kpa).
 *        Typical Value = 40.
 * @param oelin OEL input selector (OELin).
 *        Typical Value = noOELinput.
 * @param tb Regulator lag time constant (Tb).
 *        Typical Value = 1.
 * @param tc Regulator lead time constant (Tc).
 *        Typical Value = 1.
 * @param tf Excitation control system stabilizer time constant (Tf).
 *        Typical Value = 1.
 * @param tg Feedback time constant of inner loop field voltage regulator (Tg).
 *        Typical Value = 1.
 * @param tia Feedback time constant (Tia).
 *        Typical Value = 3.
 * @param ts Rectifier firing time constant (Ts).
 *        Typical Value = 0.
 * @param uelin UEL input selector (UELin).
 *        Typical Value = noUELinput.
 * @param vmax Maximum voltage reference signal (Vmax).
 *        Typical Value = 1.1.
 * @param vmin Minimum voltage reference signal (Vmin).
 *        Typical Value = 0.9.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -4.5.
 */
case class ExcST7B
(
    override val sup: ExcitationSystemDynamics,
    val kh: Double,
    val kia: Double,
    val kl: Double,
    val kpa: Double,
    val oelin: String,
    val tb: Double,
    val tc: Double,
    val tf: Double,
    val tg: Double,
    val tia: Double,
    val ts: Double,
    val uelin: String,
    val vmax: Double,
    val vmin: Double,
    val vrmax: Double,
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
    val kh = parse_element (element ("""ExcST7B.kh"""))
    val kia = parse_element (element ("""ExcST7B.kia"""))
    val kl = parse_element (element ("""ExcST7B.kl"""))
    val kpa = parse_element (element ("""ExcST7B.kpa"""))
    val oelin = parse_attribute (attribute ("""ExcST7B.oelin"""))
    val tb = parse_element (element ("""ExcST7B.tb"""))
    val tc = parse_element (element ("""ExcST7B.tc"""))
    val tf = parse_element (element ("""ExcST7B.tf"""))
    val tg = parse_element (element ("""ExcST7B.tg"""))
    val tia = parse_element (element ("""ExcST7B.tia"""))
    val ts = parse_element (element ("""ExcST7B.ts"""))
    val uelin = parse_attribute (attribute ("""ExcST7B.uelin"""))
    val vmax = parse_element (element ("""ExcST7B.vmax"""))
    val vmin = parse_element (element ("""ExcST7B.vmin"""))
    val vrmax = parse_element (element ("""ExcST7B.vrmax"""))
    val vrmin = parse_element (element ("""ExcST7B.vrmin"""))
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
 * @param sup Reference to the superclass object.
 * @param addVref The signal is added to Vref.
 * @param inputLVgate The signal is connected in the input of the LV gate.
 * @param noOELinput No OEL input is used.
 * @param outputLVgate The signal is connected in the output of the LV gate.
 */
case class ExcST7BOELselectorKind
(
    override val sup: BasicElement,
    val addVref: String,
    val inputLVgate: String,
    val noOELinput: String,
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
    val addVref = parse_attribute (attribute ("""ExcST7BOELselectorKind.addVref"""))
    val inputLVgate = parse_attribute (attribute ("""ExcST7BOELselectorKind.inputLVgate"""))
    val noOELinput = parse_attribute (attribute ("""ExcST7BOELselectorKind.noOELinput"""))
    val outputLVgate = parse_attribute (attribute ("""ExcST7BOELselectorKind.outputLVgate"""))
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
 * @param sup Reference to the superclass object.
 * @param addVref The signal is added to Vref.
 * @param inputHVgate The signal is connected in the input of the HV gate.
 * @param noUELinput No UEL input is used.
 * @param outputHVgate The signal is connected in the output of the HV gate.
 */
case class ExcST7BUELselectorKind
(
    override val sup: BasicElement,
    val addVref: String,
    val inputHVgate: String,
    val noUELinput: String,
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
    val addVref = parse_attribute (attribute ("""ExcST7BUELselectorKind.addVref"""))
    val inputHVgate = parse_attribute (attribute ("""ExcST7BUELselectorKind.inputHVgate"""))
    val noUELinput = parse_attribute (attribute ("""ExcST7BUELselectorKind.noUELinput"""))
    val outputHVgate = parse_attribute (attribute ("""ExcST7BUELselectorKind.outputHVgate"""))
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
 * @param sup Reference to the superclass object.
 * @param DiscontinuousExcitationControlDynamics Discontinuous excitation control model associated with this excitation system model.
 * @param OverexcitationLimiterDynamics Overexcitation limiter model associated with this excitation system model.
 * @param PFVArControllerType1Dynamics Power Factor or VAr controller Type I model associated with this excitation system model.
 * @param PFVArControllerType2Dynamics Power Factor or VAr controller Type II model associated with this excitation system model.
 * @param PowerSystemStabilizerDynamics Power system stabilizer model associated with this excitation system model.
 * @param SynchronousMachineDynamics Synchronous machine model with which this excitation system model is associated.
 * @param UnderexcitationLimiterDynamics Undrexcitation limiter model associated with this excitation system model.
 * @param VoltageCompensatorDynamics Voltage compensator model associated with this excitation system model.
 */
case class ExcitationSystemDynamics
(
    override val sup: DynamicsFunctionBlock,
    val DiscontinuousExcitationControlDynamics: String,
    val OverexcitationLimiterDynamics: String,
    val PFVArControllerType1Dynamics: String,
    val PFVArControllerType2Dynamics: String,
    val PowerSystemStabilizerDynamics: String,
    val SynchronousMachineDynamics: String,
    val UnderexcitationLimiterDynamics: String,
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
    val DiscontinuousExcitationControlDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.DiscontinuousExcitationControlDynamics"""))
    val OverexcitationLimiterDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.OverexcitationLimiterDynamics"""))
    val PFVArControllerType1Dynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PFVArControllerType1Dynamics"""))
    val PFVArControllerType2Dynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PFVArControllerType2Dynamics"""))
    val PowerSystemStabilizerDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.PowerSystemStabilizerDynamics"""))
    val SynchronousMachineDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.SynchronousMachineDynamics"""))
    val UnderexcitationLimiterDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.UnderexcitationLimiterDynamics"""))
    val VoltageCompensatorDynamics = parse_attribute (attribute ("""ExcitationSystemDynamics.VoltageCompensatorDynamics"""))
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