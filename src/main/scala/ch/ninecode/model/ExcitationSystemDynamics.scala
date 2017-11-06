package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Modified IEEE AC1A alternator-supplied rectifier excitation system with different rate feedback source.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param hvlvgates Indicates if both HV gate and LV gate are active (HVLVgates).
 *        true = gates are used
 *        false = gates are not used.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC1A
(
    override val sup: ExcitationSystemDynamics,
    hvlvgates: Boolean,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    kf1: Double,
    kf2: Double,
    ks: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC1A.fields (position), value)
        emitelem (0, hvlvgates)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kd)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, kf1)
        emitelem (7, kf2)
        emitelem (8, ks)
        emitelem (9, seve1)
        emitelem (10, seve2)
        emitelem (11, ta)
        emitelem (12, tb)
        emitelem (13, tc)
        emitelem (14, te)
        emitelem (15, tf)
        emitelem (16, vamax)
        emitelem (17, vamin)
        emitelem (18, ve1)
        emitelem (19, ve2)
        emitelem (20, vrmax)
        emitelem (21, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC1A rdf:ID=\"%s\">\n%s\t</cim:ExcAC1A>".format (id, export_fields)
    }
}

object ExcAC1A
extends
    Parseable[ExcAC1A]
{
    override val fields: Array[String] = Array[String] (
        "hvlvgates",
        "ka",
        "kc",
        "kd",
        "ke",
        "kf",
        "kf1",
        "kf2",
        "ks",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vrmax",
        "vrmin"
    )
    val hvlvgates: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val kf1: Fielder = parse_element (element (cls, fields(6)))
    val kf2: Fielder = parse_element (element (cls, fields(7)))
    val ks: Fielder = parse_element (element (cls, fields(8)))
    val seve1: Fielder = parse_element (element (cls, fields(9)))
    val seve2: Fielder = parse_element (element (cls, fields(10)))
    val ta: Fielder = parse_element (element (cls, fields(11)))
    val tb: Fielder = parse_element (element (cls, fields(12)))
    val tc: Fielder = parse_element (element (cls, fields(13)))
    val te: Fielder = parse_element (element (cls, fields(14)))
    val tf: Fielder = parse_element (element (cls, fields(15)))
    val vamax: Fielder = parse_element (element (cls, fields(16)))
    val vamin: Fielder = parse_element (element (cls, fields(17)))
    val ve1: Fielder = parse_element (element (cls, fields(18)))
    val ve2: Fielder = parse_element (element (cls, fields(19)))
    val vrmax: Fielder = parse_element (element (cls, fields(20)))
    val vrmin: Fielder = parse_element (element (cls, fields(21)))

    def parse (context: Context): ExcAC1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC1A (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (hvlvgates (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (kf1 (), 6)),
            toDouble (mask (kf2 (), 7)),
            toDouble (mask (ks (), 8)),
            toDouble (mask (seve1 (), 9)),
            toDouble (mask (seve2 (), 10)),
            toDouble (mask (ta (), 11)),
            toDouble (mask (tb (), 12)),
            toDouble (mask (tc (), 13)),
            toDouble (mask (te (), 14)),
            toDouble (mask (tf (), 15)),
            toDouble (mask (vamax (), 16)),
            toDouble (mask (vamin (), 17)),
            toDouble (mask (ve1 (), 18)),
            toDouble (mask (ve2 (), 19)),
            toDouble (mask (vrmax (), 20)),
            toDouble (mask (vrmin (), 21))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC2A alternator-supplied rectifier excitation system with different field current limit.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param hvgate Indicates if HV gate is active (HVgate).
 *        true = gate is used
 *        false = gate is not used.
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
 *        true = gate is used
 *        false = gate is not used.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC2A
(
    override val sup: ExcitationSystemDynamics,
    hvgate: Boolean,
    ka: Double,
    kb: Double,
    kb1: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    kh: Double,
    kl: Double,
    kl1: Double,
    ks: Double,
    lvgate: Boolean,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vfemax: Double,
    vlr: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC2A.fields (position), value)
        emitelem (0, hvgate)
        emitelem (1, ka)
        emitelem (2, kb)
        emitelem (3, kb1)
        emitelem (4, kc)
        emitelem (5, kd)
        emitelem (6, ke)
        emitelem (7, kf)
        emitelem (8, kh)
        emitelem (9, kl)
        emitelem (10, kl1)
        emitelem (11, ks)
        emitelem (12, lvgate)
        emitelem (13, seve1)
        emitelem (14, seve2)
        emitelem (15, ta)
        emitelem (16, tb)
        emitelem (17, tc)
        emitelem (18, te)
        emitelem (19, tf)
        emitelem (20, vamax)
        emitelem (21, vamin)
        emitelem (22, ve1)
        emitelem (23, ve2)
        emitelem (24, vfemax)
        emitelem (25, vlr)
        emitelem (26, vrmax)
        emitelem (27, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC2A rdf:ID=\"%s\">\n%s\t</cim:ExcAC2A>".format (id, export_fields)
    }
}

object ExcAC2A
extends
    Parseable[ExcAC2A]
{
    override val fields: Array[String] = Array[String] (
        "hvgate",
        "ka",
        "kb",
        "kb1",
        "kc",
        "kd",
        "ke",
        "kf",
        "kh",
        "kl",
        "kl1",
        "ks",
        "lvgate",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vfemax",
        "vlr",
        "vrmax",
        "vrmin"
    )
    val hvgate: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kb: Fielder = parse_element (element (cls, fields(2)))
    val kb1: Fielder = parse_element (element (cls, fields(3)))
    val kc: Fielder = parse_element (element (cls, fields(4)))
    val kd: Fielder = parse_element (element (cls, fields(5)))
    val ke: Fielder = parse_element (element (cls, fields(6)))
    val kf: Fielder = parse_element (element (cls, fields(7)))
    val kh: Fielder = parse_element (element (cls, fields(8)))
    val kl: Fielder = parse_element (element (cls, fields(9)))
    val kl1: Fielder = parse_element (element (cls, fields(10)))
    val ks: Fielder = parse_element (element (cls, fields(11)))
    val lvgate: Fielder = parse_element (element (cls, fields(12)))
    val seve1: Fielder = parse_element (element (cls, fields(13)))
    val seve2: Fielder = parse_element (element (cls, fields(14)))
    val ta: Fielder = parse_element (element (cls, fields(15)))
    val tb: Fielder = parse_element (element (cls, fields(16)))
    val tc: Fielder = parse_element (element (cls, fields(17)))
    val te: Fielder = parse_element (element (cls, fields(18)))
    val tf: Fielder = parse_element (element (cls, fields(19)))
    val vamax: Fielder = parse_element (element (cls, fields(20)))
    val vamin: Fielder = parse_element (element (cls, fields(21)))
    val ve1: Fielder = parse_element (element (cls, fields(22)))
    val ve2: Fielder = parse_element (element (cls, fields(23)))
    val vfemax: Fielder = parse_element (element (cls, fields(24)))
    val vlr: Fielder = parse_element (element (cls, fields(25)))
    val vrmax: Fielder = parse_element (element (cls, fields(26)))
    val vrmin: Fielder = parse_element (element (cls, fields(27)))

    def parse (context: Context): ExcAC2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC2A (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (hvgate (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kb (), 2)),
            toDouble (mask (kb1 (), 3)),
            toDouble (mask (kc (), 4)),
            toDouble (mask (kd (), 5)),
            toDouble (mask (ke (), 6)),
            toDouble (mask (kf (), 7)),
            toDouble (mask (kh (), 8)),
            toDouble (mask (kl (), 9)),
            toDouble (mask (kl1 (), 10)),
            toDouble (mask (ks (), 11)),
            toBoolean (mask (lvgate (), 12)),
            toDouble (mask (seve1 (), 13)),
            toDouble (mask (seve2 (), 14)),
            toDouble (mask (ta (), 15)),
            toDouble (mask (tb (), 16)),
            toDouble (mask (tc (), 17)),
            toDouble (mask (te (), 18)),
            toDouble (mask (tf (), 19)),
            toDouble (mask (vamax (), 20)),
            toDouble (mask (vamin (), 21)),
            toDouble (mask (ve1 (), 22)),
            toDouble (mask (ve2 (), 23)),
            toDouble (mask (vfemax (), 24)),
            toDouble (mask (vlr (), 25)),
            toDouble (mask (vrmax (), 26)),
            toDouble (mask (vrmin (), 27))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC3A alternator-supplied rectifier excitation system with different field current limit.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC3A
(
    override val sup: ExcitationSystemDynamics,
    efdn: Double,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    kf1: Double,
    kf2: Double,
    klv: Double,
    kn: Double,
    kr: Double,
    ks: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vemin: Double,
    vfemax: Double,
    vlv: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC3A.fields (position), value)
        emitelem (0, efdn)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kd)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, kf1)
        emitelem (7, kf2)
        emitelem (8, klv)
        emitelem (9, kn)
        emitelem (10, kr)
        emitelem (11, ks)
        emitelem (12, seve1)
        emitelem (13, seve2)
        emitelem (14, ta)
        emitelem (15, tb)
        emitelem (16, tc)
        emitelem (17, te)
        emitelem (18, tf)
        emitelem (19, vamax)
        emitelem (20, vamin)
        emitelem (21, ve1)
        emitelem (22, ve2)
        emitelem (23, vemin)
        emitelem (24, vfemax)
        emitelem (25, vlv)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC3A rdf:ID=\"%s\">\n%s\t</cim:ExcAC3A>".format (id, export_fields)
    }
}

object ExcAC3A
extends
    Parseable[ExcAC3A]
{
    override val fields: Array[String] = Array[String] (
        "efdn",
        "ka",
        "kc",
        "kd",
        "ke",
        "kf",
        "kf1",
        "kf2",
        "klv",
        "kn",
        "kr",
        "ks",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vemin",
        "vfemax",
        "vlv"
    )
    val efdn: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val kf1: Fielder = parse_element (element (cls, fields(6)))
    val kf2: Fielder = parse_element (element (cls, fields(7)))
    val klv: Fielder = parse_element (element (cls, fields(8)))
    val kn: Fielder = parse_element (element (cls, fields(9)))
    val kr: Fielder = parse_element (element (cls, fields(10)))
    val ks: Fielder = parse_element (element (cls, fields(11)))
    val seve1: Fielder = parse_element (element (cls, fields(12)))
    val seve2: Fielder = parse_element (element (cls, fields(13)))
    val ta: Fielder = parse_element (element (cls, fields(14)))
    val tb: Fielder = parse_element (element (cls, fields(15)))
    val tc: Fielder = parse_element (element (cls, fields(16)))
    val te: Fielder = parse_element (element (cls, fields(17)))
    val tf: Fielder = parse_element (element (cls, fields(18)))
    val vamax: Fielder = parse_element (element (cls, fields(19)))
    val vamin: Fielder = parse_element (element (cls, fields(20)))
    val ve1: Fielder = parse_element (element (cls, fields(21)))
    val ve2: Fielder = parse_element (element (cls, fields(22)))
    val vemin: Fielder = parse_element (element (cls, fields(23)))
    val vfemax: Fielder = parse_element (element (cls, fields(24)))
    val vlv: Fielder = parse_element (element (cls, fields(25)))

    def parse (context: Context): ExcAC3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdn (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (kf1 (), 6)),
            toDouble (mask (kf2 (), 7)),
            toDouble (mask (klv (), 8)),
            toDouble (mask (kn (), 9)),
            toDouble (mask (kr (), 10)),
            toDouble (mask (ks (), 11)),
            toDouble (mask (seve1 (), 12)),
            toDouble (mask (seve2 (), 13)),
            toDouble (mask (ta (), 14)),
            toDouble (mask (tb (), 15)),
            toDouble (mask (tc (), 16)),
            toDouble (mask (te (), 17)),
            toDouble (mask (tf (), 18)),
            toDouble (mask (vamax (), 19)),
            toDouble (mask (vamin (), 20)),
            toDouble (mask (ve1 (), 21)),
            toDouble (mask (ve2 (), 22)),
            toDouble (mask (vemin (), 23)),
            toDouble (mask (vfemax (), 24)),
            toDouble (mask (vlv (), 25))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC4A alternator-supplied rectifier excitation system with different minimum controller output.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC4A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    vimax: Double,
    vimin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC4A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC4A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC4A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, ta)
        emitelem (3, tb)
        emitelem (4, tc)
        emitelem (5, vimax)
        emitelem (6, vimin)
        emitelem (7, vrmax)
        emitelem (8, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC4A rdf:ID=\"%s\">\n%s\t</cim:ExcAC4A>".format (id, export_fields)
    }
}

object ExcAC4A
extends
    Parseable[ExcAC4A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "ta",
        "tb",
        "tc",
        "vimax",
        "vimin",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val ta: Fielder = parse_element (element (cls, fields(2)))
    val tb: Fielder = parse_element (element (cls, fields(3)))
    val tc: Fielder = parse_element (element (cls, fields(4)))
    val vimax: Fielder = parse_element (element (cls, fields(5)))
    val vimin: Fielder = parse_element (element (cls, fields(6)))
    val vrmax: Fielder = parse_element (element (cls, fields(7)))
    val vrmin: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): ExcAC4A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC4A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (ta (), 2)),
            toDouble (mask (tb (), 3)),
            toDouble (mask (tc (), 4)),
            toDouble (mask (vimax (), 5)),
            toDouble (mask (vimin (), 6)),
            toDouble (mask (vrmax (), 7)),
            toDouble (mask (vrmin (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC5A alternator-supplied rectifier excitation system with different minimum controller output.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC5A
(
    override val sup: ExcitationSystemDynamics,
    a: Double,
    efd1: Double,
    efd2: Double,
    ka: Double,
    ke: Double,
    kf: Double,
    ks: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf1: Double,
    tf2: Double,
    tf3: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC5A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC5A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC5A.fields (position), value)
        emitelem (0, a)
        emitelem (1, efd1)
        emitelem (2, efd2)
        emitelem (3, ka)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, ks)
        emitelem (7, seefd1)
        emitelem (8, seefd2)
        emitelem (9, ta)
        emitelem (10, tb)
        emitelem (11, tc)
        emitelem (12, te)
        emitelem (13, tf1)
        emitelem (14, tf2)
        emitelem (15, tf3)
        emitelem (16, vrmax)
        emitelem (17, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC5A rdf:ID=\"%s\">\n%s\t</cim:ExcAC5A>".format (id, export_fields)
    }
}

object ExcAC5A
extends
    Parseable[ExcAC5A]
{
    override val fields: Array[String] = Array[String] (
        "a",
        "efd1",
        "efd2",
        "ka",
        "ke",
        "kf",
        "ks",
        "seefd1",
        "seefd2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf1",
        "tf2",
        "tf3",
        "vrmax",
        "vrmin"
    )
    val a: Fielder = parse_element (element (cls, fields(0)))
    val efd1: Fielder = parse_element (element (cls, fields(1)))
    val efd2: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val ks: Fielder = parse_element (element (cls, fields(6)))
    val seefd1: Fielder = parse_element (element (cls, fields(7)))
    val seefd2: Fielder = parse_element (element (cls, fields(8)))
    val ta: Fielder = parse_element (element (cls, fields(9)))
    val tb: Fielder = parse_element (element (cls, fields(10)))
    val tc: Fielder = parse_element (element (cls, fields(11)))
    val te: Fielder = parse_element (element (cls, fields(12)))
    val tf1: Fielder = parse_element (element (cls, fields(13)))
    val tf2: Fielder = parse_element (element (cls, fields(14)))
    val tf3: Fielder = parse_element (element (cls, fields(15)))
    val vrmax: Fielder = parse_element (element (cls, fields(16)))
    val vrmin: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcAC5A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC5A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (efd1 (), 1)),
            toDouble (mask (efd2 (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (ks (), 6)),
            toDouble (mask (seefd1 (), 7)),
            toDouble (mask (seefd2 (), 8)),
            toDouble (mask (ta (), 9)),
            toDouble (mask (tb (), 10)),
            toDouble (mask (tc (), 11)),
            toDouble (mask (te (), 12)),
            toDouble (mask (tf1 (), 13)),
            toDouble (mask (tf2 (), 14)),
            toDouble (mask (tf3 (), 15)),
            toDouble (mask (vrmax (), 16)),
            toDouble (mask (vrmin (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC6A alternator-supplied rectifier excitation system with speed input.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC6A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kh: Double,
    ks: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    th: Double,
    tj: Double,
    tk: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vfelim: Double,
    vhmax: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC6A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC6A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC6A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, kd)
        emitelem (3, ke)
        emitelem (4, kh)
        emitelem (5, ks)
        emitelem (6, seve1)
        emitelem (7, seve2)
        emitelem (8, ta)
        emitelem (9, tb)
        emitelem (10, tc)
        emitelem (11, te)
        emitelem (12, th)
        emitelem (13, tj)
        emitelem (14, tk)
        emitelem (15, vamax)
        emitelem (16, vamin)
        emitelem (17, ve1)
        emitelem (18, ve2)
        emitelem (19, vfelim)
        emitelem (20, vhmax)
        emitelem (21, vrmax)
        emitelem (22, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC6A rdf:ID=\"%s\">\n%s\t</cim:ExcAC6A>".format (id, export_fields)
    }
}

object ExcAC6A
extends
    Parseable[ExcAC6A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "kd",
        "ke",
        "kh",
        "ks",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "th",
        "tj",
        "tk",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vfelim",
        "vhmax",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kd: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kh: Fielder = parse_element (element (cls, fields(4)))
    val ks: Fielder = parse_element (element (cls, fields(5)))
    val seve1: Fielder = parse_element (element (cls, fields(6)))
    val seve2: Fielder = parse_element (element (cls, fields(7)))
    val ta: Fielder = parse_element (element (cls, fields(8)))
    val tb: Fielder = parse_element (element (cls, fields(9)))
    val tc: Fielder = parse_element (element (cls, fields(10)))
    val te: Fielder = parse_element (element (cls, fields(11)))
    val th: Fielder = parse_element (element (cls, fields(12)))
    val tj: Fielder = parse_element (element (cls, fields(13)))
    val tk: Fielder = parse_element (element (cls, fields(14)))
    val vamax: Fielder = parse_element (element (cls, fields(15)))
    val vamin: Fielder = parse_element (element (cls, fields(16)))
    val ve1: Fielder = parse_element (element (cls, fields(17)))
    val ve2: Fielder = parse_element (element (cls, fields(18)))
    val vfelim: Fielder = parse_element (element (cls, fields(19)))
    val vhmax: Fielder = parse_element (element (cls, fields(20)))
    val vrmax: Fielder = parse_element (element (cls, fields(21)))
    val vrmin: Fielder = parse_element (element (cls, fields(22)))

    def parse (context: Context): ExcAC6A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC6A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kd (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kh (), 4)),
            toDouble (mask (ks (), 5)),
            toDouble (mask (seve1 (), 6)),
            toDouble (mask (seve2 (), 7)),
            toDouble (mask (ta (), 8)),
            toDouble (mask (tb (), 9)),
            toDouble (mask (tc (), 10)),
            toDouble (mask (te (), 11)),
            toDouble (mask (th (), 12)),
            toDouble (mask (tj (), 13)),
            toDouble (mask (tk (), 14)),
            toDouble (mask (vamax (), 15)),
            toDouble (mask (vamin (), 16)),
            toDouble (mask (ve1 (), 17)),
            toDouble (mask (ve2 (), 18)),
            toDouble (mask (vfelim (), 19)),
            toDouble (mask (vhmax (), 20)),
            toDouble (mask (vrmax (), 21)),
            toDouble (mask (vrmin (), 22))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE AC8B alternator-supplied rectifier excitation system with speed input and input limiter.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param inlim Input limiter indicator.
 *        true = input limiter Vimax and Vimin is considered
 *        false = input limiter Vimax and Vimin is not considered.
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
 *        true = input limiter Vpidmax and Vpidmin is considered
 *        false = input limiter Vpidmax and Vpidmin is not considered.
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
 *        true =the limits Vrmax and Vrmin are multiplied by the generator�s terminal voltage to represent a thyristor power stage fed from the generator terminals
 *        false = limits are not multiplied by generator's terminal voltage.
 *        Typical Value = false.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAC8B
(
    override val sup: ExcitationSystemDynamics,
    inlim: Boolean,
    ka: Double,
    kc: Double,
    kd: Double,
    kdr: Double,
    ke: Double,
    kir: Double,
    kpr: Double,
    ks: Double,
    pidlim: Boolean,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tdr: Double,
    te: Double,
    telim: Boolean,
    ve1: Double,
    ve2: Double,
    vemin: Double,
    vfemax: Double,
    vimax: Double,
    vimin: Double,
    vpidmax: Double,
    vpidmin: Double,
    vrmax: Double,
    vrmin: Double,
    vtmult: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAC8B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAC8B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAC8B.fields (position), value)
        emitelem (0, inlim)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kd)
        emitelem (4, kdr)
        emitelem (5, ke)
        emitelem (6, kir)
        emitelem (7, kpr)
        emitelem (8, ks)
        emitelem (9, pidlim)
        emitelem (10, seve1)
        emitelem (11, seve2)
        emitelem (12, ta)
        emitelem (13, tdr)
        emitelem (14, te)
        emitelem (15, telim)
        emitelem (16, ve1)
        emitelem (17, ve2)
        emitelem (18, vemin)
        emitelem (19, vfemax)
        emitelem (20, vimax)
        emitelem (21, vimin)
        emitelem (22, vpidmax)
        emitelem (23, vpidmin)
        emitelem (24, vrmax)
        emitelem (25, vrmin)
        emitelem (26, vtmult)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAC8B rdf:ID=\"%s\">\n%s\t</cim:ExcAC8B>".format (id, export_fields)
    }
}

object ExcAC8B
extends
    Parseable[ExcAC8B]
{
    override val fields: Array[String] = Array[String] (
        "inlim",
        "ka",
        "kc",
        "kd",
        "kdr",
        "ke",
        "kir",
        "kpr",
        "ks",
        "pidlim",
        "seve1",
        "seve2",
        "ta",
        "tdr",
        "te",
        "telim",
        "ve1",
        "ve2",
        "vemin",
        "vfemax",
        "vimax",
        "vimin",
        "vpidmax",
        "vpidmin",
        "vrmax",
        "vrmin",
        "vtmult"
    )
    val inlim: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val kdr: Fielder = parse_element (element (cls, fields(4)))
    val ke: Fielder = parse_element (element (cls, fields(5)))
    val kir: Fielder = parse_element (element (cls, fields(6)))
    val kpr: Fielder = parse_element (element (cls, fields(7)))
    val ks: Fielder = parse_element (element (cls, fields(8)))
    val pidlim: Fielder = parse_element (element (cls, fields(9)))
    val seve1: Fielder = parse_element (element (cls, fields(10)))
    val seve2: Fielder = parse_element (element (cls, fields(11)))
    val ta: Fielder = parse_element (element (cls, fields(12)))
    val tdr: Fielder = parse_element (element (cls, fields(13)))
    val te: Fielder = parse_element (element (cls, fields(14)))
    val telim: Fielder = parse_element (element (cls, fields(15)))
    val ve1: Fielder = parse_element (element (cls, fields(16)))
    val ve2: Fielder = parse_element (element (cls, fields(17)))
    val vemin: Fielder = parse_element (element (cls, fields(18)))
    val vfemax: Fielder = parse_element (element (cls, fields(19)))
    val vimax: Fielder = parse_element (element (cls, fields(20)))
    val vimin: Fielder = parse_element (element (cls, fields(21)))
    val vpidmax: Fielder = parse_element (element (cls, fields(22)))
    val vpidmin: Fielder = parse_element (element (cls, fields(23)))
    val vrmax: Fielder = parse_element (element (cls, fields(24)))
    val vrmin: Fielder = parse_element (element (cls, fields(25)))
    val vtmult: Fielder = parse_element (element (cls, fields(26)))

    def parse (context: Context): ExcAC8B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAC8B (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (inlim (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (kdr (), 4)),
            toDouble (mask (ke (), 5)),
            toDouble (mask (kir (), 6)),
            toDouble (mask (kpr (), 7)),
            toDouble (mask (ks (), 8)),
            toBoolean (mask (pidlim (), 9)),
            toDouble (mask (seve1 (), 10)),
            toDouble (mask (seve2 (), 11)),
            toDouble (mask (ta (), 12)),
            toDouble (mask (tdr (), 13)),
            toDouble (mask (te (), 14)),
            toBoolean (mask (telim (), 15)),
            toDouble (mask (ve1 (), 16)),
            toDouble (mask (ve2 (), 17)),
            toDouble (mask (vemin (), 18)),
            toDouble (mask (vfemax (), 19)),
            toDouble (mask (vimax (), 20)),
            toDouble (mask (vimin (), 21)),
            toDouble (mask (vpidmax (), 22)),
            toDouble (mask (vpidmin (), 23)),
            toDouble (mask (vrmax (), 24)),
            toDouble (mask (vrmin (), 25)),
            toBoolean (mask (vtmult (), 26))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian excitation system.
 *
 * It represents static field voltage or excitation current feedback excitation system.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param blint Governor Control Flag (BLINT).
 *        0 = lead-lag regulator
 *        1 = proportional integral regulator.
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
 *        0 = Open loop control
 *        1 = Closed loop control.
 *        Typical Value = 1.
 * @param kvfif Rate feedback signal flag (K<sub>VFIF</sub>).
 *        0 = output voltage of the exciter
 *        1 = exciter field current.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcANS
(
    override val sup: ExcitationSystemDynamics,
    blint: Int,
    ifmn: Double,
    ifmx: Double,
    k2: Double,
    k3: Double,
    kce: Double,
    krvecc: Int,
    kvfif: Int,
    t1: Double,
    t2: Double,
    t3: Double,
    tb: Double,
    vrmn: Double,
    vrmx: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcANS] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcANS.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcANS.fields (position), value)
        emitelem (0, blint)
        emitelem (1, ifmn)
        emitelem (2, ifmx)
        emitelem (3, k2)
        emitelem (4, k3)
        emitelem (5, kce)
        emitelem (6, krvecc)
        emitelem (7, kvfif)
        emitelem (8, t1)
        emitelem (9, t2)
        emitelem (10, t3)
        emitelem (11, tb)
        emitelem (12, vrmn)
        emitelem (13, vrmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcANS rdf:ID=\"%s\">\n%s\t</cim:ExcANS>".format (id, export_fields)
    }
}

object ExcANS
extends
    Parseable[ExcANS]
{
    override val fields: Array[String] = Array[String] (
        "blint",
        "ifmn",
        "ifmx",
        "k2",
        "k3",
        "kce",
        "krvecc",
        "kvfif",
        "t1",
        "t2",
        "t3",
        "tb",
        "vrmn",
        "vrmx"
    )
    val blint: Fielder = parse_element (element (cls, fields(0)))
    val ifmn: Fielder = parse_element (element (cls, fields(1)))
    val ifmx: Fielder = parse_element (element (cls, fields(2)))
    val k2: Fielder = parse_element (element (cls, fields(3)))
    val k3: Fielder = parse_element (element (cls, fields(4)))
    val kce: Fielder = parse_element (element (cls, fields(5)))
    val krvecc: Fielder = parse_element (element (cls, fields(6)))
    val kvfif: Fielder = parse_element (element (cls, fields(7)))
    val t1: Fielder = parse_element (element (cls, fields(8)))
    val t2: Fielder = parse_element (element (cls, fields(9)))
    val t3: Fielder = parse_element (element (cls, fields(10)))
    val tb: Fielder = parse_element (element (cls, fields(11)))
    val vrmn: Fielder = parse_element (element (cls, fields(12)))
    val vrmx: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): ExcANS =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcANS (
            ExcitationSystemDynamics.parse (context),
            toInteger (mask (blint (), 0)),
            toDouble (mask (ifmn (), 1)),
            toDouble (mask (ifmx (), 2)),
            toDouble (mask (k2 (), 3)),
            toDouble (mask (k3 (), 4)),
            toDouble (mask (kce (), 5)),
            toInteger (mask (krvecc (), 6)),
            toInteger (mask (kvfif (), 7)),
            toDouble (mask (t1 (), 8)),
            toDouble (mask (t2 (), 9)),
            toDouble (mask (t3 (), 10)),
            toDouble (mask (tb (), 11)),
            toDouble (mask (vrmn (), 12)),
            toDouble (mask (vrmx (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian excitation system corresponding to IEEE (1968) Type 1 Model.
 *
 * It represents exciter dynamo and electromechanical regulator.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR1
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    ka: Double,
    kf: Double,
    se1: Double,
    se2: Double,
    ta: Double,
    tb: Double,
    te: Double,
    tf: Double,
    vrmn: Double,
    vrmx: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR1] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR1.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitelem (2, ka)
        emitelem (3, kf)
        emitelem (4, se1)
        emitelem (5, se2)
        emitelem (6, ta)
        emitelem (7, tb)
        emitelem (8, te)
        emitelem (9, tf)
        emitelem (10, vrmn)
        emitelem (11, vrmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR1 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR1>".format (id, export_fields)
    }
}

object ExcAVR1
extends
    Parseable[ExcAVR1]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "ka",
        "kf",
        "se1",
        "se2",
        "ta",
        "tb",
        "te",
        "tf",
        "vrmn",
        "vrmx"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val kf: Fielder = parse_element (element (cls, fields(3)))
    val se1: Fielder = parse_element (element (cls, fields(4)))
    val se2: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val te: Fielder = parse_element (element (cls, fields(8)))
    val tf: Fielder = parse_element (element (cls, fields(9)))
    val vrmn: Fielder = parse_element (element (cls, fields(10)))
    val vrmx: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): ExcAVR1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR1 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (se1 (), 4)),
            toDouble (mask (se2 (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (te (), 8)),
            toDouble (mask (tf (), 9)),
            toDouble (mask (vrmn (), 10)),
            toDouble (mask (vrmx (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian excitation system corresponding to IEEE (1968) Type 2 Model.
 *
 * It represents alternator and rotating diodes and electromechanic voltage regulators.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR2
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    ka: Double,
    kf: Double,
    se1: Double,
    se2: Double,
    ta: Double,
    tb: Double,
    te: Double,
    tf1: Double,
    tf2: Double,
    vrmn: Double,
    vrmx: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR2] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR2.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitelem (2, ka)
        emitelem (3, kf)
        emitelem (4, se1)
        emitelem (5, se2)
        emitelem (6, ta)
        emitelem (7, tb)
        emitelem (8, te)
        emitelem (9, tf1)
        emitelem (10, tf2)
        emitelem (11, vrmn)
        emitelem (12, vrmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR2 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR2>".format (id, export_fields)
    }
}

object ExcAVR2
extends
    Parseable[ExcAVR2]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "ka",
        "kf",
        "se1",
        "se2",
        "ta",
        "tb",
        "te",
        "tf1",
        "tf2",
        "vrmn",
        "vrmx"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val kf: Fielder = parse_element (element (cls, fields(3)))
    val se1: Fielder = parse_element (element (cls, fields(4)))
    val se2: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val te: Fielder = parse_element (element (cls, fields(8)))
    val tf1: Fielder = parse_element (element (cls, fields(9)))
    val tf2: Fielder = parse_element (element (cls, fields(10)))
    val vrmn: Fielder = parse_element (element (cls, fields(11)))
    val vrmx: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: Context): ExcAVR2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR2 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (se1 (), 4)),
            toDouble (mask (se2 (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (te (), 8)),
            toDouble (mask (tf1 (), 9)),
            toDouble (mask (tf2 (), 10)),
            toDouble (mask (vrmn (), 11)),
            toDouble (mask (vrmx (), 12))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian excitation system.
 *
 * It represents exciter dynamo and electric regulator.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR3
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    ka: Double,
    se1: Double,
    se2: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    te: Double,
    vrmn: Double,
    vrmx: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR3] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR3.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR3.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitelem (2, ka)
        emitelem (3, se1)
        emitelem (4, se2)
        emitelem (5, t1)
        emitelem (6, t2)
        emitelem (7, t3)
        emitelem (8, t4)
        emitelem (9, te)
        emitelem (10, vrmn)
        emitelem (11, vrmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR3 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR3>".format (id, export_fields)
    }
}

object ExcAVR3
extends
    Parseable[ExcAVR3]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "ka",
        "se1",
        "se2",
        "t1",
        "t2",
        "t3",
        "t4",
        "te",
        "vrmn",
        "vrmx"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val se1: Fielder = parse_element (element (cls, fields(3)))
    val se2: Fielder = parse_element (element (cls, fields(4)))
    val t1: Fielder = parse_element (element (cls, fields(5)))
    val t2: Fielder = parse_element (element (cls, fields(6)))
    val t3: Fielder = parse_element (element (cls, fields(7)))
    val t4: Fielder = parse_element (element (cls, fields(8)))
    val te: Fielder = parse_element (element (cls, fields(9)))
    val vrmn: Fielder = parse_element (element (cls, fields(10)))
    val vrmx: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): ExcAVR3 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR3 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (se1 (), 3)),
            toDouble (mask (se2 (), 4)),
            toDouble (mask (t1 (), 5)),
            toDouble (mask (t2 (), 6)),
            toDouble (mask (t3 (), 7)),
            toDouble (mask (t4 (), 8)),
            toDouble (mask (te (), 9)),
            toDouble (mask (vrmn (), 10)),
            toDouble (mask (vrmx (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian excitation system.
 *
 * It represents static exciter and electric voltage regulator.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param imul AVR output voltage dependency selector (Imul).
 *        true = selector is connected
 *        false = selector is not connected.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR4
(
    override val sup: ExcitationSystemDynamics,
    imul: Boolean,
    ka: Double,
    ke: Double,
    kif: Double,
    t1: Double,
    t1if: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    tif: Double,
    vfmn: Double,
    vfmx: Double,
    vrmn: Double,
    vrmx: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR4] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR4.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR4.fields (position), value)
        emitelem (0, imul)
        emitelem (1, ka)
        emitelem (2, ke)
        emitelem (3, kif)
        emitelem (4, t1)
        emitelem (5, t1if)
        emitelem (6, t2)
        emitelem (7, t3)
        emitelem (8, t4)
        emitelem (9, tif)
        emitelem (10, vfmn)
        emitelem (11, vfmx)
        emitelem (12, vrmn)
        emitelem (13, vrmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR4 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR4>".format (id, export_fields)
    }
}

object ExcAVR4
extends
    Parseable[ExcAVR4]
{
    override val fields: Array[String] = Array[String] (
        "imul",
        "ka",
        "ke",
        "kif",
        "t1",
        "t1if",
        "t2",
        "t3",
        "t4",
        "tif",
        "vfmn",
        "vfmx",
        "vrmn",
        "vrmx"
    )
    val imul: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val ke: Fielder = parse_element (element (cls, fields(2)))
    val kif: Fielder = parse_element (element (cls, fields(3)))
    val t1: Fielder = parse_element (element (cls, fields(4)))
    val t1if: Fielder = parse_element (element (cls, fields(5)))
    val t2: Fielder = parse_element (element (cls, fields(6)))
    val t3: Fielder = parse_element (element (cls, fields(7)))
    val t4: Fielder = parse_element (element (cls, fields(8)))
    val tif: Fielder = parse_element (element (cls, fields(9)))
    val vfmn: Fielder = parse_element (element (cls, fields(10)))
    val vfmx: Fielder = parse_element (element (cls, fields(11)))
    val vrmn: Fielder = parse_element (element (cls, fields(12)))
    val vrmx: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): ExcAVR4 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR4 (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (imul (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (ke (), 2)),
            toDouble (mask (kif (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t1if (), 5)),
            toDouble (mask (t2 (), 6)),
            toDouble (mask (t3 (), 7)),
            toDouble (mask (t4 (), 8)),
            toDouble (mask (tif (), 9)),
            toDouble (mask (vfmn (), 10)),
            toDouble (mask (vfmx (), 11)),
            toDouble (mask (vrmn (), 12)),
            toDouble (mask (vrmx (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Manual excitation control with field circuit resistance.
 *
 * This model can be used as a very simple representation of manual voltage control.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Gain (Ka).
 * @param rex Effective Output Resistance (Rex).
 *        Rex represents the effective output resistance seen by the excitation system.
 * @param ta Time constant (Ta).
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR5
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    rex: Double,
    ta: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR5] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR5.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR5.fields (position), value)
        emitelem (0, ka)
        emitelem (1, rex)
        emitelem (2, ta)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR5 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR5>".format (id, export_fields)
    }
}

object ExcAVR5
extends
    Parseable[ExcAVR5]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "rex",
        "ta"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val rex: Fielder = parse_element (element (cls, fields(1)))
    val ta: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): ExcAVR5 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR5 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (rex (), 1)),
            toDouble (mask (ta (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IVO excitation system.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcAVR7
(
    override val sup: ExcitationSystemDynamics,
    a1: Double,
    a2: Double,
    a3: Double,
    a4: Double,
    a5: Double,
    a6: Double,
    k1: Double,
    k3: Double,
    k5: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    vmax1: Double,
    vmax3: Double,
    vmax5: Double,
    vmin1: Double,
    vmin3: Double,
    vmin5: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcAVR7] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcAVR7.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcAVR7.fields (position), value)
        emitelem (0, a1)
        emitelem (1, a2)
        emitelem (2, a3)
        emitelem (3, a4)
        emitelem (4, a5)
        emitelem (5, a6)
        emitelem (6, k1)
        emitelem (7, k3)
        emitelem (8, k5)
        emitelem (9, t1)
        emitelem (10, t2)
        emitelem (11, t3)
        emitelem (12, t4)
        emitelem (13, t5)
        emitelem (14, t6)
        emitelem (15, vmax1)
        emitelem (16, vmax3)
        emitelem (17, vmax5)
        emitelem (18, vmin1)
        emitelem (19, vmin3)
        emitelem (20, vmin5)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcAVR7 rdf:ID=\"%s\">\n%s\t</cim:ExcAVR7>".format (id, export_fields)
    }
}

object ExcAVR7
extends
    Parseable[ExcAVR7]
{
    override val fields: Array[String] = Array[String] (
        "a1",
        "a2",
        "a3",
        "a4",
        "a5",
        "a6",
        "k1",
        "k3",
        "k5",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "vmax1",
        "vmax3",
        "vmax5",
        "vmin1",
        "vmin3",
        "vmin5"
    )
    val a1: Fielder = parse_element (element (cls, fields(0)))
    val a2: Fielder = parse_element (element (cls, fields(1)))
    val a3: Fielder = parse_element (element (cls, fields(2)))
    val a4: Fielder = parse_element (element (cls, fields(3)))
    val a5: Fielder = parse_element (element (cls, fields(4)))
    val a6: Fielder = parse_element (element (cls, fields(5)))
    val k1: Fielder = parse_element (element (cls, fields(6)))
    val k3: Fielder = parse_element (element (cls, fields(7)))
    val k5: Fielder = parse_element (element (cls, fields(8)))
    val t1: Fielder = parse_element (element (cls, fields(9)))
    val t2: Fielder = parse_element (element (cls, fields(10)))
    val t3: Fielder = parse_element (element (cls, fields(11)))
    val t4: Fielder = parse_element (element (cls, fields(12)))
    val t5: Fielder = parse_element (element (cls, fields(13)))
    val t6: Fielder = parse_element (element (cls, fields(14)))
    val vmax1: Fielder = parse_element (element (cls, fields(15)))
    val vmax3: Fielder = parse_element (element (cls, fields(16)))
    val vmax5: Fielder = parse_element (element (cls, fields(17)))
    val vmin1: Fielder = parse_element (element (cls, fields(18)))
    val vmin3: Fielder = parse_element (element (cls, fields(19)))
    val vmin5: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): ExcAVR7 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcAVR7 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (a1 (), 0)),
            toDouble (mask (a2 (), 1)),
            toDouble (mask (a3 (), 2)),
            toDouble (mask (a4 (), 3)),
            toDouble (mask (a5 (), 4)),
            toDouble (mask (a6 (), 5)),
            toDouble (mask (k1 (), 6)),
            toDouble (mask (k3 (), 7)),
            toDouble (mask (k5 (), 8)),
            toDouble (mask (t1 (), 9)),
            toDouble (mask (t2 (), 10)),
            toDouble (mask (t3 (), 11)),
            toDouble (mask (t4 (), 12)),
            toDouble (mask (t5 (), 13)),
            toDouble (mask (t6 (), 14)),
            toDouble (mask (vmax1 (), 15)),
            toDouble (mask (vmax3 (), 16)),
            toDouble (mask (vmax5 (), 17)),
            toDouble (mask (vmin1 (), 18)),
            toDouble (mask (vmin3 (), 19)),
            toDouble (mask (vmin5 (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Transformer fed static excitation system (static with ABB regulator).
 *
 * This model represents a static excitation system in which a gated thyristor bridge fed by a transformer at the main generator terminals feeds the main generator directly.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Maximum open circuit exciter voltage (Efdmax).
 *        Typical Value = 5.
 * @param efdmin Minimum open circuit exciter voltage (Efdmin).
 *        Typical Value = -5.
 * @param k Steady state gain (K).
 *        Typical Value = 300.
 * @param `switch` Supplementary signal routing selector (switch).
 *        true = Vs connected to 3rd summing point
 *        false =  Vs connected to 1st summing point (see diagram).
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcBBC
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    efdmin: Double,
    k: Double,
    `switch`: Boolean,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    vrmax: Double,
    vrmin: Double,
    xe: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcBBC] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcBBC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcBBC.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, efdmin)
        emitelem (2, k)
        emitelem (3, `switch`)
        emitelem (4, t1)
        emitelem (5, t2)
        emitelem (6, t3)
        emitelem (7, t4)
        emitelem (8, vrmax)
        emitelem (9, vrmin)
        emitelem (10, xe)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcBBC rdf:ID=\"%s\">\n%s\t</cim:ExcBBC>".format (id, export_fields)
    }
}

object ExcBBC
extends
    Parseable[ExcBBC]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "efdmin",
        "k",
        "switch",
        "t1",
        "t2",
        "t3",
        "t4",
        "vrmax",
        "vrmin",
        "xe"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val efdmin: Fielder = parse_element (element (cls, fields(1)))
    val k: Fielder = parse_element (element (cls, fields(2)))
    val `switch`: Fielder = parse_element (element (cls, fields(3)))
    val t1: Fielder = parse_element (element (cls, fields(4)))
    val t2: Fielder = parse_element (element (cls, fields(5)))
    val t3: Fielder = parse_element (element (cls, fields(6)))
    val t4: Fielder = parse_element (element (cls, fields(7)))
    val vrmax: Fielder = parse_element (element (cls, fields(8)))
    val vrmin: Fielder = parse_element (element (cls, fields(9)))
    val xe: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): ExcBBC =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcBBC (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (efdmin (), 1)),
            toDouble (mask (k (), 2)),
            toBoolean (mask (`switch` (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t2 (), 5)),
            toDouble (mask (t3 (), 6)),
            toDouble (mask (t4 (), 7)),
            toDouble (mask (vrmax (), 8)),
            toDouble (mask (vrmin (), 9)),
            toDouble (mask (xe (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Czech Proportion/Integral Exciter.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcCZ
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    efdmin: Double,
    ka: Double,
    ke: Double,
    kp: Double,
    ta: Double,
    tc: Double,
    te: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcCZ] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcCZ.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcCZ.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, efdmin)
        emitelem (2, ka)
        emitelem (3, ke)
        emitelem (4, kp)
        emitelem (5, ta)
        emitelem (6, tc)
        emitelem (7, te)
        emitelem (8, vrmax)
        emitelem (9, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcCZ rdf:ID=\"%s\">\n%s\t</cim:ExcCZ>".format (id, export_fields)
    }
}

object ExcCZ
extends
    Parseable[ExcCZ]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "efdmin",
        "ka",
        "ke",
        "kp",
        "ta",
        "tc",
        "te",
        "vrmax",
        "vrmin"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val efdmin: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kp: Fielder = parse_element (element (cls, fields(4)))
    val ta: Fielder = parse_element (element (cls, fields(5)))
    val tc: Fielder = parse_element (element (cls, fields(6)))
    val te: Fielder = parse_element (element (cls, fields(7)))
    val vrmax: Fielder = parse_element (element (cls, fields(8)))
    val vrmin: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): ExcCZ =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcCZ (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (efdmin (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kp (), 4)),
            toDouble (mask (ta (), 5)),
            toDouble (mask (tc (), 6)),
            toDouble (mask (te (), 7)),
            toDouble (mask (vrmax (), 8)),
            toDouble (mask (vrmin (), 9))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE DC1A direct current commutator exciter with speed input and without underexcitation limiters (UEL) inputs.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcDC1A
(
    override val sup: ExcitationSystemDynamics,
    edfmax: Double,
    efd1: Double,
    efd2: Double,
    efdmin: Double,
    exclim: Boolean,
    ka: Double,
    ke: Double,
    kf: Double,
    ks: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcDC1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcDC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC1A.fields (position), value)
        emitelem (0, edfmax)
        emitelem (1, efd1)
        emitelem (2, efd2)
        emitelem (3, efdmin)
        emitelem (4, exclim)
        emitelem (5, ka)
        emitelem (6, ke)
        emitelem (7, kf)
        emitelem (8, ks)
        emitelem (9, seefd1)
        emitelem (10, seefd2)
        emitelem (11, ta)
        emitelem (12, tb)
        emitelem (13, tc)
        emitelem (14, te)
        emitelem (15, tf)
        emitelem (16, vrmax)
        emitelem (17, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcDC1A rdf:ID=\"%s\">\n%s\t</cim:ExcDC1A>".format (id, export_fields)
    }
}

object ExcDC1A
extends
    Parseable[ExcDC1A]
{
    override val fields: Array[String] = Array[String] (
        "edfmax",
        "efd1",
        "efd2",
        "efdmin",
        "exclim",
        "ka",
        "ke",
        "kf",
        "ks",
        "seefd1",
        "seefd2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vrmax",
        "vrmin"
    )
    val edfmax: Fielder = parse_element (element (cls, fields(0)))
    val efd1: Fielder = parse_element (element (cls, fields(1)))
    val efd2: Fielder = parse_element (element (cls, fields(2)))
    val efdmin: Fielder = parse_element (element (cls, fields(3)))
    val exclim: Fielder = parse_element (element (cls, fields(4)))
    val ka: Fielder = parse_element (element (cls, fields(5)))
    val ke: Fielder = parse_element (element (cls, fields(6)))
    val kf: Fielder = parse_element (element (cls, fields(7)))
    val ks: Fielder = parse_element (element (cls, fields(8)))
    val seefd1: Fielder = parse_element (element (cls, fields(9)))
    val seefd2: Fielder = parse_element (element (cls, fields(10)))
    val ta: Fielder = parse_element (element (cls, fields(11)))
    val tb: Fielder = parse_element (element (cls, fields(12)))
    val tc: Fielder = parse_element (element (cls, fields(13)))
    val te: Fielder = parse_element (element (cls, fields(14)))
    val tf: Fielder = parse_element (element (cls, fields(15)))
    val vrmax: Fielder = parse_element (element (cls, fields(16)))
    val vrmin: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcDC1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcDC1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (edfmax (), 0)),
            toDouble (mask (efd1 (), 1)),
            toDouble (mask (efd2 (), 2)),
            toDouble (mask (efdmin (), 3)),
            toBoolean (mask (exclim (), 4)),
            toDouble (mask (ka (), 5)),
            toDouble (mask (ke (), 6)),
            toDouble (mask (kf (), 7)),
            toDouble (mask (ks (), 8)),
            toDouble (mask (seefd1 (), 9)),
            toDouble (mask (seefd2 (), 10)),
            toDouble (mask (ta (), 11)),
            toDouble (mask (tb (), 12)),
            toDouble (mask (tc (), 13)),
            toDouble (mask (te (), 14)),
            toDouble (mask (tf (), 15)),
            toDouble (mask (vrmax (), 16)),
            toDouble (mask (vrmin (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE DC2A direct current commutator exciters with speed input, one more leg block in feedback loop and without underexcitation limiters (UEL) inputs.
 *
 * DC type 2 excitation system model with added speed multiplier, added lead-lag, and voltage-dependent limits.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = limiter at the block [Ka/(1+sTa)] is dependent on Vt
 *        false = limiter at the block is not dependent on Vt.
 *        Typical Value = true.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcDC2A
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    exclim: Boolean,
    ka: Double,
    ke: Double,
    kf: Double,
    ks: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    tf1: Double,
    vrmax: Double,
    vrmin: Double,
    vtlim: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcDC2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcDC2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC2A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, exclim)
        emitelem (3, ka)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, ks)
        emitelem (7, seefd1)
        emitelem (8, seefd2)
        emitelem (9, ta)
        emitelem (10, tb)
        emitelem (11, tc)
        emitelem (12, te)
        emitelem (13, tf)
        emitelem (14, tf1)
        emitelem (15, vrmax)
        emitelem (16, vrmin)
        emitelem (17, vtlim)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcDC2A rdf:ID=\"%s\">\n%s\t</cim:ExcDC2A>".format (id, export_fields)
    }
}

object ExcDC2A
extends
    Parseable[ExcDC2A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "exclim",
        "ka",
        "ke",
        "kf",
        "ks",
        "seefd1",
        "seefd2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "tf1",
        "vrmax",
        "vrmin",
        "vtlim"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val exclim: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val ks: Fielder = parse_element (element (cls, fields(6)))
    val seefd1: Fielder = parse_element (element (cls, fields(7)))
    val seefd2: Fielder = parse_element (element (cls, fields(8)))
    val ta: Fielder = parse_element (element (cls, fields(9)))
    val tb: Fielder = parse_element (element (cls, fields(10)))
    val tc: Fielder = parse_element (element (cls, fields(11)))
    val te: Fielder = parse_element (element (cls, fields(12)))
    val tf: Fielder = parse_element (element (cls, fields(13)))
    val tf1: Fielder = parse_element (element (cls, fields(14)))
    val vrmax: Fielder = parse_element (element (cls, fields(15)))
    val vrmin: Fielder = parse_element (element (cls, fields(16)))
    val vtlim: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcDC2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcDC2A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toBoolean (mask (exclim (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (ks (), 6)),
            toDouble (mask (seefd1 (), 7)),
            toDouble (mask (seefd2 (), 8)),
            toDouble (mask (ta (), 9)),
            toDouble (mask (tb (), 10)),
            toDouble (mask (tc (), 11)),
            toDouble (mask (te (), 12)),
            toDouble (mask (tf (), 13)),
            toDouble (mask (tf1 (), 14)),
            toDouble (mask (vrmax (), 15)),
            toDouble (mask (vrmin (), 16)),
            toBoolean (mask (vtlim (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is modified IEEE DC3A direct current commutator exciters with speed input, and death band.
 *
 * DC old type 4.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param edfmax Maximum voltage exciter output limiter (Efdmax).
 *        Typical Value = 99.
 * @param efd1 Exciter voltage at which exciter saturation is defined (Efd1).
 *        Typical Value = 2.6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (Efd2).
 *        Typical Value = 3.45.
 * @param efdlim (Efdlim).
 *        true = exciter output limiter is active
 *        false = exciter output limiter not active.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcDC3A
(
    override val sup: ExcitationSystemDynamics,
    edfmax: Double,
    efd1: Double,
    efd2: Double,
    efdlim: Boolean,
    efdmin: Double,
    exclim: Boolean,
    ke: Double,
    kr: Double,
    ks: Double,
    kv: Double,
    seefd1: Double,
    seefd2: Double,
    te: Double,
    trh: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcDC3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcDC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC3A.fields (position), value)
        emitelem (0, edfmax)
        emitelem (1, efd1)
        emitelem (2, efd2)
        emitelem (3, efdlim)
        emitelem (4, efdmin)
        emitelem (5, exclim)
        emitelem (6, ke)
        emitelem (7, kr)
        emitelem (8, ks)
        emitelem (9, kv)
        emitelem (10, seefd1)
        emitelem (11, seefd2)
        emitelem (12, te)
        emitelem (13, trh)
        emitelem (14, vrmax)
        emitelem (15, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcDC3A rdf:ID=\"%s\">\n%s\t</cim:ExcDC3A>".format (id, export_fields)
    }
}

object ExcDC3A
extends
    Parseable[ExcDC3A]
{
    override val fields: Array[String] = Array[String] (
        "edfmax",
        "efd1",
        "efd2",
        "efdlim",
        "efdmin",
        "exclim",
        "ke",
        "kr",
        "ks",
        "kv",
        "seefd1",
        "seefd2",
        "te",
        "trh",
        "vrmax",
        "vrmin"
    )
    val edfmax: Fielder = parse_element (element (cls, fields(0)))
    val efd1: Fielder = parse_element (element (cls, fields(1)))
    val efd2: Fielder = parse_element (element (cls, fields(2)))
    val efdlim: Fielder = parse_element (element (cls, fields(3)))
    val efdmin: Fielder = parse_element (element (cls, fields(4)))
    val exclim: Fielder = parse_element (element (cls, fields(5)))
    val ke: Fielder = parse_element (element (cls, fields(6)))
    val kr: Fielder = parse_element (element (cls, fields(7)))
    val ks: Fielder = parse_element (element (cls, fields(8)))
    val kv: Fielder = parse_element (element (cls, fields(9)))
    val seefd1: Fielder = parse_element (element (cls, fields(10)))
    val seefd2: Fielder = parse_element (element (cls, fields(11)))
    val te: Fielder = parse_element (element (cls, fields(12)))
    val trh: Fielder = parse_element (element (cls, fields(13)))
    val vrmax: Fielder = parse_element (element (cls, fields(14)))
    val vrmin: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): ExcDC3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcDC3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (edfmax (), 0)),
            toDouble (mask (efd1 (), 1)),
            toDouble (mask (efd2 (), 2)),
            toBoolean (mask (efdlim (), 3)),
            toDouble (mask (efdmin (), 4)),
            toBoolean (mask (exclim (), 5)),
            toDouble (mask (ke (), 6)),
            toDouble (mask (kr (), 7)),
            toDouble (mask (ks (), 8)),
            toDouble (mask (kv (), 9)),
            toDouble (mask (seefd1 (), 10)),
            toDouble (mask (seefd2 (), 11)),
            toDouble (mask (te (), 12)),
            toDouble (mask (trh (), 13)),
            toDouble (mask (vrmax (), 14)),
            toDouble (mask (vrmin (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is modified old IEEE type 3 excitation system.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param exclim (exclim).
 *        true = lower limit of zero is applied to integrator output
 *        false = lower limit of zero not applied to integrator output.
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
 *        true = exciter Vbmax limiter is active
 *        false = Vb1max is active.
 *        Typical Value = true.
 * @param vbmax Available exciter voltage limiter (Vbmax).
 *        Typical Value = 11.63.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 5.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcDC3A1
(
    override val sup: ExcitationSystemDynamics,
    exclim: Boolean,
    ka: Double,
    ke: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    ta: Double,
    te: Double,
    tf: Double,
    vb1max: Double,
    vblim: Boolean,
    vbmax: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcDC3A1] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcDC3A1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC3A1.fields (position), value)
        emitelem (0, exclim)
        emitelem (1, ka)
        emitelem (2, ke)
        emitelem (3, kf)
        emitelem (4, ki)
        emitelem (5, kp)
        emitelem (6, ta)
        emitelem (7, te)
        emitelem (8, tf)
        emitelem (9, vb1max)
        emitelem (10, vblim)
        emitelem (11, vbmax)
        emitelem (12, vrmax)
        emitelem (13, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcDC3A1 rdf:ID=\"%s\">\n%s\t</cim:ExcDC3A1>".format (id, export_fields)
    }
}

object ExcDC3A1
extends
    Parseable[ExcDC3A1]
{
    override val fields: Array[String] = Array[String] (
        "exclim",
        "ka",
        "ke",
        "kf",
        "ki",
        "kp",
        "ta",
        "te",
        "tf",
        "vb1max",
        "vblim",
        "vbmax",
        "vrmax",
        "vrmin"
    )
    val exclim: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val ke: Fielder = parse_element (element (cls, fields(2)))
    val kf: Fielder = parse_element (element (cls, fields(3)))
    val ki: Fielder = parse_element (element (cls, fields(4)))
    val kp: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val te: Fielder = parse_element (element (cls, fields(7)))
    val tf: Fielder = parse_element (element (cls, fields(8)))
    val vb1max: Fielder = parse_element (element (cls, fields(9)))
    val vblim: Fielder = parse_element (element (cls, fields(10)))
    val vbmax: Fielder = parse_element (element (cls, fields(11)))
    val vrmax: Fielder = parse_element (element (cls, fields(12)))
    val vrmin: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): ExcDC3A1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcDC3A1 (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (exclim (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (ke (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (ki (), 4)),
            toDouble (mask (kp (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (te (), 7)),
            toDouble (mask (tf (), 8)),
            toDouble (mask (vb1max (), 9)),
            toBoolean (mask (vblim (), 10)),
            toDouble (mask (vbmax (), 11)),
            toDouble (mask (vrmax (), 12)),
            toDouble (mask (vrmin (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Static PI transformer fed excitation system: ELIN (VATECH) - simplified model.
 *
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  A power system stabilizer with power input is included in the model.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcELIN1
(
    override val sup: ExcitationSystemDynamics,
    dpnf: Double,
    efmax: Double,
    efmin: Double,
    ks1: Double,
    ks2: Double,
    smax: Double,
    tfi: Double,
    tnu: Double,
    ts1: Double,
    ts2: Double,
    tsw: Double,
    vpi: Double,
    vpnf: Double,
    vpu: Double,
    xe: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcELIN1] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcELIN1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcELIN1.fields (position), value)
        emitelem (0, dpnf)
        emitelem (1, efmax)
        emitelem (2, efmin)
        emitelem (3, ks1)
        emitelem (4, ks2)
        emitelem (5, smax)
        emitelem (6, tfi)
        emitelem (7, tnu)
        emitelem (8, ts1)
        emitelem (9, ts2)
        emitelem (10, tsw)
        emitelem (11, vpi)
        emitelem (12, vpnf)
        emitelem (13, vpu)
        emitelem (14, xe)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcELIN1 rdf:ID=\"%s\">\n%s\t</cim:ExcELIN1>".format (id, export_fields)
    }
}

object ExcELIN1
extends
    Parseable[ExcELIN1]
{
    override val fields: Array[String] = Array[String] (
        "dpnf",
        "efmax",
        "efmin",
        "ks1",
        "ks2",
        "smax",
        "tfi",
        "tnu",
        "ts1",
        "ts2",
        "tsw",
        "vpi",
        "vpnf",
        "vpu",
        "xe"
    )
    val dpnf: Fielder = parse_element (element (cls, fields(0)))
    val efmax: Fielder = parse_element (element (cls, fields(1)))
    val efmin: Fielder = parse_element (element (cls, fields(2)))
    val ks1: Fielder = parse_element (element (cls, fields(3)))
    val ks2: Fielder = parse_element (element (cls, fields(4)))
    val smax: Fielder = parse_element (element (cls, fields(5)))
    val tfi: Fielder = parse_element (element (cls, fields(6)))
    val tnu: Fielder = parse_element (element (cls, fields(7)))
    val ts1: Fielder = parse_element (element (cls, fields(8)))
    val ts2: Fielder = parse_element (element (cls, fields(9)))
    val tsw: Fielder = parse_element (element (cls, fields(10)))
    val vpi: Fielder = parse_element (element (cls, fields(11)))
    val vpnf: Fielder = parse_element (element (cls, fields(12)))
    val vpu: Fielder = parse_element (element (cls, fields(13)))
    val xe: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): ExcELIN1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcELIN1 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (dpnf (), 0)),
            toDouble (mask (efmax (), 1)),
            toDouble (mask (efmin (), 2)),
            toDouble (mask (ks1 (), 3)),
            toDouble (mask (ks2 (), 4)),
            toDouble (mask (smax (), 5)),
            toDouble (mask (tfi (), 6)),
            toDouble (mask (tnu (), 7)),
            toDouble (mask (ts1 (), 8)),
            toDouble (mask (ts2 (), 9)),
            toDouble (mask (tsw (), 10)),
            toDouble (mask (vpi (), 11)),
            toDouble (mask (vpnf (), 12)),
            toDouble (mask (vpu (), 13)),
            toDouble (mask (xe (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed Excitation System Model - ELIN (VATECH).
 *
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  Power system stabilizer models used in conjunction with this excitation system model: PssELIN2, PssIEEE2B, Pss2B.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcELIN2
(
    override val sup: ExcitationSystemDynamics,
    efdbas: Double,
    iefmax: Double,
    iefmax2: Double,
    iefmin: Double,
    k1: Double,
    k1ec: Double,
    k2: Double,
    k3: Double,
    k4: Double,
    kd1: Double,
    ke2: Double,
    ketb: Double,
    pid1max: Double,
    seve1: Double,
    seve2: Double,
    tb1: Double,
    te: Double,
    te2: Double,
    ti1: Double,
    ti3: Double,
    ti4: Double,
    tr4: Double,
    upmax: Double,
    upmin: Double,
    ve1: Double,
    ve2: Double,
    xp: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcELIN2] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcELIN2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcELIN2.fields (position), value)
        emitelem (0, efdbas)
        emitelem (1, iefmax)
        emitelem (2, iefmax2)
        emitelem (3, iefmin)
        emitelem (4, k1)
        emitelem (5, k1ec)
        emitelem (6, k2)
        emitelem (7, k3)
        emitelem (8, k4)
        emitelem (9, kd1)
        emitelem (10, ke2)
        emitelem (11, ketb)
        emitelem (12, pid1max)
        emitelem (13, seve1)
        emitelem (14, seve2)
        emitelem (15, tb1)
        emitelem (16, te)
        emitelem (17, te2)
        emitelem (18, ti1)
        emitelem (19, ti3)
        emitelem (20, ti4)
        emitelem (21, tr4)
        emitelem (22, upmax)
        emitelem (23, upmin)
        emitelem (24, ve1)
        emitelem (25, ve2)
        emitelem (26, xp)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcELIN2 rdf:ID=\"%s\">\n%s\t</cim:ExcELIN2>".format (id, export_fields)
    }
}

object ExcELIN2
extends
    Parseable[ExcELIN2]
{
    override val fields: Array[String] = Array[String] (
        "efdbas",
        "iefmax",
        "iefmax2",
        "iefmin",
        "k1",
        "k1ec",
        "k2",
        "k3",
        "k4",
        "kd1",
        "ke2",
        "ketb",
        "pid1max",
        "seve1",
        "seve2",
        "tb1",
        "te",
        "te2",
        "ti1",
        "ti3",
        "ti4",
        "tr4",
        "upmax",
        "upmin",
        "ve1",
        "ve2",
        "xp"
    )
    val efdbas: Fielder = parse_element (element (cls, fields(0)))
    val iefmax: Fielder = parse_element (element (cls, fields(1)))
    val iefmax2: Fielder = parse_element (element (cls, fields(2)))
    val iefmin: Fielder = parse_element (element (cls, fields(3)))
    val k1: Fielder = parse_element (element (cls, fields(4)))
    val k1ec: Fielder = parse_element (element (cls, fields(5)))
    val k2: Fielder = parse_element (element (cls, fields(6)))
    val k3: Fielder = parse_element (element (cls, fields(7)))
    val k4: Fielder = parse_element (element (cls, fields(8)))
    val kd1: Fielder = parse_element (element (cls, fields(9)))
    val ke2: Fielder = parse_element (element (cls, fields(10)))
    val ketb: Fielder = parse_element (element (cls, fields(11)))
    val pid1max: Fielder = parse_element (element (cls, fields(12)))
    val seve1: Fielder = parse_element (element (cls, fields(13)))
    val seve2: Fielder = parse_element (element (cls, fields(14)))
    val tb1: Fielder = parse_element (element (cls, fields(15)))
    val te: Fielder = parse_element (element (cls, fields(16)))
    val te2: Fielder = parse_element (element (cls, fields(17)))
    val ti1: Fielder = parse_element (element (cls, fields(18)))
    val ti3: Fielder = parse_element (element (cls, fields(19)))
    val ti4: Fielder = parse_element (element (cls, fields(20)))
    val tr4: Fielder = parse_element (element (cls, fields(21)))
    val upmax: Fielder = parse_element (element (cls, fields(22)))
    val upmin: Fielder = parse_element (element (cls, fields(23)))
    val ve1: Fielder = parse_element (element (cls, fields(24)))
    val ve2: Fielder = parse_element (element (cls, fields(25)))
    val xp: Fielder = parse_element (element (cls, fields(26)))

    def parse (context: Context): ExcELIN2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcELIN2 (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdbas (), 0)),
            toDouble (mask (iefmax (), 1)),
            toDouble (mask (iefmax2 (), 2)),
            toDouble (mask (iefmin (), 3)),
            toDouble (mask (k1 (), 4)),
            toDouble (mask (k1ec (), 5)),
            toDouble (mask (k2 (), 6)),
            toDouble (mask (k3 (), 7)),
            toDouble (mask (k4 (), 8)),
            toDouble (mask (kd1 (), 9)),
            toDouble (mask (ke2 (), 10)),
            toDouble (mask (ketb (), 11)),
            toDouble (mask (pid1max (), 12)),
            toDouble (mask (seve1 (), 13)),
            toDouble (mask (seve2 (), 14)),
            toDouble (mask (tb1 (), 15)),
            toDouble (mask (te (), 16)),
            toDouble (mask (te2 (), 17)),
            toDouble (mask (ti1 (), 18)),
            toDouble (mask (ti3 (), 19)),
            toDouble (mask (ti4 (), 20)),
            toDouble (mask (tr4 (), 21)),
            toDouble (mask (upmax (), 22)),
            toDouble (mask (upmin (), 23)),
            toDouble (mask (ve1 (), 24)),
            toDouble (mask (ve2 (), 25)),
            toDouble (mask (xp (), 26))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Hungarian Excitation System Model, with built-in voltage transducer.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcHU
(
    override val sup: ExcitationSystemDynamics,
    ae: Double,
    ai: Double,
    atr: Double,
    emax: Double,
    emin: Double,
    imax: Double,
    imin: Double,
    ke: Double,
    ki: Double,
    te: Double,
    ti: Double,
    tr: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcHU] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcHU.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcHU.fields (position), value)
        emitelem (0, ae)
        emitelem (1, ai)
        emitelem (2, atr)
        emitelem (3, emax)
        emitelem (4, emin)
        emitelem (5, imax)
        emitelem (6, imin)
        emitelem (7, ke)
        emitelem (8, ki)
        emitelem (9, te)
        emitelem (10, ti)
        emitelem (11, tr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcHU rdf:ID=\"%s\">\n%s\t</cim:ExcHU>".format (id, export_fields)
    }
}

object ExcHU
extends
    Parseable[ExcHU]
{
    override val fields: Array[String] = Array[String] (
        "ae",
        "ai",
        "atr",
        "emax",
        "emin",
        "imax",
        "imin",
        "ke",
        "ki",
        "te",
        "ti",
        "tr"
    )
    val ae: Fielder = parse_element (element (cls, fields(0)))
    val ai: Fielder = parse_element (element (cls, fields(1)))
    val atr: Fielder = parse_element (element (cls, fields(2)))
    val emax: Fielder = parse_element (element (cls, fields(3)))
    val emin: Fielder = parse_element (element (cls, fields(4)))
    val imax: Fielder = parse_element (element (cls, fields(5)))
    val imin: Fielder = parse_element (element (cls, fields(6)))
    val ke: Fielder = parse_element (element (cls, fields(7)))
    val ki: Fielder = parse_element (element (cls, fields(8)))
    val te: Fielder = parse_element (element (cls, fields(9)))
    val ti: Fielder = parse_element (element (cls, fields(10)))
    val tr: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): ExcHU =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcHU (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ae (), 0)),
            toDouble (mask (ai (), 1)),
            toDouble (mask (atr (), 2)),
            toDouble (mask (emax (), 3)),
            toDouble (mask (emin (), 4)),
            toDouble (mask (imax (), 5)),
            toDouble (mask (imin (), 6)),
            toDouble (mask (ke (), 7)),
            toDouble (mask (ki (), 8)),
            toDouble (mask (te (), 9)),
            toDouble (mask (ti (), 10)),
            toDouble (mask (tr (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC1A model.
 *
 * The model represents the field-controlled alternator-rectifier excitation systems designated Type AC1A. These excitation systems consist of an alternator main exciter with non-controlled rectifiers.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC1A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC1A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, kd)
        emitelem (3, ke)
        emitelem (4, kf)
        emitelem (5, seve1)
        emitelem (6, seve2)
        emitelem (7, ta)
        emitelem (8, tb)
        emitelem (9, tc)
        emitelem (10, te)
        emitelem (11, tf)
        emitelem (12, vamax)
        emitelem (13, vamin)
        emitelem (14, ve1)
        emitelem (15, ve2)
        emitelem (16, vrmax)
        emitelem (17, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC1A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC1A>".format (id, export_fields)
    }
}

object ExcIEEEAC1A
extends
    Parseable[ExcIEEEAC1A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "kd",
        "ke",
        "kf",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kd: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kf: Fielder = parse_element (element (cls, fields(4)))
    val seve1: Fielder = parse_element (element (cls, fields(5)))
    val seve2: Fielder = parse_element (element (cls, fields(6)))
    val ta: Fielder = parse_element (element (cls, fields(7)))
    val tb: Fielder = parse_element (element (cls, fields(8)))
    val tc: Fielder = parse_element (element (cls, fields(9)))
    val te: Fielder = parse_element (element (cls, fields(10)))
    val tf: Fielder = parse_element (element (cls, fields(11)))
    val vamax: Fielder = parse_element (element (cls, fields(12)))
    val vamin: Fielder = parse_element (element (cls, fields(13)))
    val ve1: Fielder = parse_element (element (cls, fields(14)))
    val ve2: Fielder = parse_element (element (cls, fields(15)))
    val vrmax: Fielder = parse_element (element (cls, fields(16)))
    val vrmin: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcIEEEAC1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kd (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kf (), 4)),
            toDouble (mask (seve1 (), 5)),
            toDouble (mask (seve2 (), 6)),
            toDouble (mask (ta (), 7)),
            toDouble (mask (tb (), 8)),
            toDouble (mask (tc (), 9)),
            toDouble (mask (te (), 10)),
            toDouble (mask (tf (), 11)),
            toDouble (mask (vamax (), 12)),
            toDouble (mask (vamin (), 13)),
            toDouble (mask (ve1 (), 14)),
            toDouble (mask (ve2 (), 15)),
            toDouble (mask (vrmax (), 16)),
            toDouble (mask (vrmin (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC2A model.
 *
 * The model represents a high initial response field-controlled alternator-rectifier excitation system. The alternator main exciter is used with non-controlled rectifiers. The Type AC2A model is similar to that of Type AC1A except for the inclusion of exciter time constant compensation and exciter field current limiting elements.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC2A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kb: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    kh: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vfemax: Double,
    vrmax: Double,
    vrmin: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC2A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kb)
        emitelem (2, kc)
        emitelem (3, kd)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, kh)
        emitelem (7, seve1)
        emitelem (8, seve2)
        emitelem (9, ta)
        emitelem (10, tb)
        emitelem (11, tc)
        emitelem (12, te)
        emitelem (13, tf)
        emitelem (14, vamax)
        emitelem (15, vamin)
        emitelem (16, ve1)
        emitelem (17, ve2)
        emitelem (18, vfemax)
        emitelem (19, vrmax)
        emitelem (20, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC2A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC2A>".format (id, export_fields)
    }
}

object ExcIEEEAC2A
extends
    Parseable[ExcIEEEAC2A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kb",
        "kc",
        "kd",
        "ke",
        "kf",
        "kh",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vfemax",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kb: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val kh: Fielder = parse_element (element (cls, fields(6)))
    val seve1: Fielder = parse_element (element (cls, fields(7)))
    val seve2: Fielder = parse_element (element (cls, fields(8)))
    val ta: Fielder = parse_element (element (cls, fields(9)))
    val tb: Fielder = parse_element (element (cls, fields(10)))
    val tc: Fielder = parse_element (element (cls, fields(11)))
    val te: Fielder = parse_element (element (cls, fields(12)))
    val tf: Fielder = parse_element (element (cls, fields(13)))
    val vamax: Fielder = parse_element (element (cls, fields(14)))
    val vamin: Fielder = parse_element (element (cls, fields(15)))
    val ve1: Fielder = parse_element (element (cls, fields(16)))
    val ve2: Fielder = parse_element (element (cls, fields(17)))
    val vfemax: Fielder = parse_element (element (cls, fields(18)))
    val vrmax: Fielder = parse_element (element (cls, fields(19)))
    val vrmin: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): ExcIEEEAC2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC2A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kb (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (kh (), 6)),
            toDouble (mask (seve1 (), 7)),
            toDouble (mask (seve2 (), 8)),
            toDouble (mask (ta (), 9)),
            toDouble (mask (tb (), 10)),
            toDouble (mask (tc (), 11)),
            toDouble (mask (te (), 12)),
            toDouble (mask (tf (), 13)),
            toDouble (mask (vamax (), 14)),
            toDouble (mask (vamin (), 15)),
            toDouble (mask (ve1 (), 16)),
            toDouble (mask (ve2 (), 17)),
            toDouble (mask (vfemax (), 18)),
            toDouble (mask (vrmax (), 19)),
            toDouble (mask (vrmin (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC3A model.
 *
 * The model represents the field-controlled alternator-rectifier excitation systems designated Type AC3A. These excitation systems include an alternator main exciter with non-controlled rectifiers. The exciter employs self-excitation, and the voltage regulator power is derived from the exciter output voltage.  Therefore, this system has an additional nonlinearity, simulated by the use of a multiplier
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC3A
(
    override val sup: ExcitationSystemDynamics,
    efdn: Double,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    kn: Double,
    kr: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vemin: Double,
    vfemax: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC3A.fields (position), value)
        emitelem (0, efdn)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kd)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, kn)
        emitelem (7, kr)
        emitelem (8, seve1)
        emitelem (9, seve2)
        emitelem (10, ta)
        emitelem (11, tb)
        emitelem (12, tc)
        emitelem (13, te)
        emitelem (14, tf)
        emitelem (15, vamax)
        emitelem (16, vamin)
        emitelem (17, ve1)
        emitelem (18, ve2)
        emitelem (19, vemin)
        emitelem (20, vfemax)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC3A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC3A>".format (id, export_fields)
    }
}

object ExcIEEEAC3A
extends
    Parseable[ExcIEEEAC3A]
{
    override val fields: Array[String] = Array[String] (
        "efdn",
        "ka",
        "kc",
        "kd",
        "ke",
        "kf",
        "kn",
        "kr",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vemin",
        "vfemax"
    )
    val efdn: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val kn: Fielder = parse_element (element (cls, fields(6)))
    val kr: Fielder = parse_element (element (cls, fields(7)))
    val seve1: Fielder = parse_element (element (cls, fields(8)))
    val seve2: Fielder = parse_element (element (cls, fields(9)))
    val ta: Fielder = parse_element (element (cls, fields(10)))
    val tb: Fielder = parse_element (element (cls, fields(11)))
    val tc: Fielder = parse_element (element (cls, fields(12)))
    val te: Fielder = parse_element (element (cls, fields(13)))
    val tf: Fielder = parse_element (element (cls, fields(14)))
    val vamax: Fielder = parse_element (element (cls, fields(15)))
    val vamin: Fielder = parse_element (element (cls, fields(16)))
    val ve1: Fielder = parse_element (element (cls, fields(17)))
    val ve2: Fielder = parse_element (element (cls, fields(18)))
    val vemin: Fielder = parse_element (element (cls, fields(19)))
    val vfemax: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): ExcIEEEAC3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdn (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (kn (), 6)),
            toDouble (mask (kr (), 7)),
            toDouble (mask (seve1 (), 8)),
            toDouble (mask (seve2 (), 9)),
            toDouble (mask (ta (), 10)),
            toDouble (mask (tb (), 11)),
            toDouble (mask (tc (), 12)),
            toDouble (mask (te (), 13)),
            toDouble (mask (tf (), 14)),
            toDouble (mask (vamax (), 15)),
            toDouble (mask (vamin (), 16)),
            toDouble (mask (ve1 (), 17)),
            toDouble (mask (ve2 (), 18)),
            toDouble (mask (vemin (), 19)),
            toDouble (mask (vfemax (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC4A model.
 *
 * The model represents type AC4A alternator-supplied controlled-rectifier excitation system which is quite different from the other type ac systems. This high initial response excitation system utilizes a full thyristor bridge in the exciter output circuit.  The voltage regulator controls the firing of the thyristor bridges. The exciter alternator uses an independent voltage regulator to control its output voltage to a constant value. These effects are not modeled; however, transient loading effects on the exciter alternator are included.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC4A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    vimax: Double,
    vimin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC4A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC4A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC4A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, ta)
        emitelem (3, tb)
        emitelem (4, tc)
        emitelem (5, vimax)
        emitelem (6, vimin)
        emitelem (7, vrmax)
        emitelem (8, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC4A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC4A>".format (id, export_fields)
    }
}

object ExcIEEEAC4A
extends
    Parseable[ExcIEEEAC4A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "ta",
        "tb",
        "tc",
        "vimax",
        "vimin",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val ta: Fielder = parse_element (element (cls, fields(2)))
    val tb: Fielder = parse_element (element (cls, fields(3)))
    val tc: Fielder = parse_element (element (cls, fields(4)))
    val vimax: Fielder = parse_element (element (cls, fields(5)))
    val vimin: Fielder = parse_element (element (cls, fields(6)))
    val vrmax: Fielder = parse_element (element (cls, fields(7)))
    val vrmin: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): ExcIEEEAC4A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC4A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (ta (), 2)),
            toDouble (mask (tb (), 3)),
            toDouble (mask (tc (), 4)),
            toDouble (mask (vimax (), 5)),
            toDouble (mask (vimin (), 6)),
            toDouble (mask (vrmax (), 7)),
            toDouble (mask (vrmin (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC5A model.
 *
 * The model represents a simplified model for brushless excitation systems. The regulator is supplied from a source, such as a permanent magnet generator, which is not affected by system disturbances.  Unlike other ac models, this model uses loaded rather than open circuit exciter saturation data in the same way as it is used for the dc models.  Because the model has been widely implemented by the industry, it is sometimes used to represent other types of systems when either detailed data for them are not available or simplified models are required.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC5A
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    ka: Double,
    ke: Double,
    kf: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    te: Double,
    tf1: Double,
    tf2: Double,
    tf3: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC5A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC5A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC5A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, ka)
        emitelem (3, ke)
        emitelem (4, kf)
        emitelem (5, seefd1)
        emitelem (6, seefd2)
        emitelem (7, ta)
        emitelem (8, te)
        emitelem (9, tf1)
        emitelem (10, tf2)
        emitelem (11, tf3)
        emitelem (12, vrmax)
        emitelem (13, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC5A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC5A>".format (id, export_fields)
    }
}

object ExcIEEEAC5A
extends
    Parseable[ExcIEEEAC5A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "ka",
        "ke",
        "kf",
        "seefd1",
        "seefd2",
        "ta",
        "te",
        "tf1",
        "tf2",
        "tf3",
        "vrmax",
        "vrmin"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kf: Fielder = parse_element (element (cls, fields(4)))
    val seefd1: Fielder = parse_element (element (cls, fields(5)))
    val seefd2: Fielder = parse_element (element (cls, fields(6)))
    val ta: Fielder = parse_element (element (cls, fields(7)))
    val te: Fielder = parse_element (element (cls, fields(8)))
    val tf1: Fielder = parse_element (element (cls, fields(9)))
    val tf2: Fielder = parse_element (element (cls, fields(10)))
    val tf3: Fielder = parse_element (element (cls, fields(11)))
    val vrmax: Fielder = parse_element (element (cls, fields(12)))
    val vrmin: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): ExcIEEEAC5A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC5A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kf (), 4)),
            toDouble (mask (seefd1 (), 5)),
            toDouble (mask (seefd2 (), 6)),
            toDouble (mask (ta (), 7)),
            toDouble (mask (te (), 8)),
            toDouble (mask (tf1 (), 9)),
            toDouble (mask (tf2 (), 10)),
            toDouble (mask (tf3 (), 11)),
            toDouble (mask (vrmax (), 12)),
            toDouble (mask (vrmin (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC6A model.
 *
 * The model represents field-controlled alternator-rectifier excitation systems with system-supplied electronic voltage regulators.  The maximum output of the regulator, <b><i>V</i></b><b><i><sub>R</sub></i></b>, is a function of terminal voltage, <b><i>V</i></b><b><i><sub>T</sub></i></b>. The field current limiter included in the original model AC6A remains in the 2005 update.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC6A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kh: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    th: Double,
    tj: Double,
    tk: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vfelim: Double,
    vhmax: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC6A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC6A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC6A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, kd)
        emitelem (3, ke)
        emitelem (4, kh)
        emitelem (5, seve1)
        emitelem (6, seve2)
        emitelem (7, ta)
        emitelem (8, tb)
        emitelem (9, tc)
        emitelem (10, te)
        emitelem (11, th)
        emitelem (12, tj)
        emitelem (13, tk)
        emitelem (14, vamax)
        emitelem (15, vamin)
        emitelem (16, ve1)
        emitelem (17, ve2)
        emitelem (18, vfelim)
        emitelem (19, vhmax)
        emitelem (20, vrmax)
        emitelem (21, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC6A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC6A>".format (id, export_fields)
    }
}

object ExcIEEEAC6A
extends
    Parseable[ExcIEEEAC6A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "kd",
        "ke",
        "kh",
        "seve1",
        "seve2",
        "ta",
        "tb",
        "tc",
        "te",
        "th",
        "tj",
        "tk",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vfelim",
        "vhmax",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kd: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kh: Fielder = parse_element (element (cls, fields(4)))
    val seve1: Fielder = parse_element (element (cls, fields(5)))
    val seve2: Fielder = parse_element (element (cls, fields(6)))
    val ta: Fielder = parse_element (element (cls, fields(7)))
    val tb: Fielder = parse_element (element (cls, fields(8)))
    val tc: Fielder = parse_element (element (cls, fields(9)))
    val te: Fielder = parse_element (element (cls, fields(10)))
    val th: Fielder = parse_element (element (cls, fields(11)))
    val tj: Fielder = parse_element (element (cls, fields(12)))
    val tk: Fielder = parse_element (element (cls, fields(13)))
    val vamax: Fielder = parse_element (element (cls, fields(14)))
    val vamin: Fielder = parse_element (element (cls, fields(15)))
    val ve1: Fielder = parse_element (element (cls, fields(16)))
    val ve2: Fielder = parse_element (element (cls, fields(17)))
    val vfelim: Fielder = parse_element (element (cls, fields(18)))
    val vhmax: Fielder = parse_element (element (cls, fields(19)))
    val vrmax: Fielder = parse_element (element (cls, fields(20)))
    val vrmin: Fielder = parse_element (element (cls, fields(21)))

    def parse (context: Context): ExcIEEEAC6A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC6A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kd (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kh (), 4)),
            toDouble (mask (seve1 (), 5)),
            toDouble (mask (seve2 (), 6)),
            toDouble (mask (ta (), 7)),
            toDouble (mask (tb (), 8)),
            toDouble (mask (tc (), 9)),
            toDouble (mask (te (), 10)),
            toDouble (mask (th (), 11)),
            toDouble (mask (tj (), 12)),
            toDouble (mask (tk (), 13)),
            toDouble (mask (vamax (), 14)),
            toDouble (mask (vamin (), 15)),
            toDouble (mask (ve1 (), 16)),
            toDouble (mask (ve2 (), 17)),
            toDouble (mask (vfelim (), 18)),
            toDouble (mask (vhmax (), 19)),
            toDouble (mask (vrmax (), 20)),
            toDouble (mask (vrmin (), 21))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC7B model.
 *
 * The model represents excitation systems which consist of an ac alternator with either stationary or rotating rectifiers to produce the dc field requirements. It is an upgrade to earlier ac excitation systems, which replace only the controls but retain the ac alternator and diode rectifier bridge.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC7B
(
    override val sup: ExcitationSystemDynamics,
    kc: Double,
    kd: Double,
    kdr: Double,
    ke: Double,
    kf1: Double,
    kf2: Double,
    kf3: Double,
    kia: Double,
    kir: Double,
    kl: Double,
    kp: Double,
    kpa: Double,
    kpr: Double,
    seve1: Double,
    seve2: Double,
    tdr: Double,
    te: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    ve1: Double,
    ve2: Double,
    vemin: Double,
    vfemax: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC7B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC7B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC7B.fields (position), value)
        emitelem (0, kc)
        emitelem (1, kd)
        emitelem (2, kdr)
        emitelem (3, ke)
        emitelem (4, kf1)
        emitelem (5, kf2)
        emitelem (6, kf3)
        emitelem (7, kia)
        emitelem (8, kir)
        emitelem (9, kl)
        emitelem (10, kp)
        emitelem (11, kpa)
        emitelem (12, kpr)
        emitelem (13, seve1)
        emitelem (14, seve2)
        emitelem (15, tdr)
        emitelem (16, te)
        emitelem (17, tf)
        emitelem (18, vamax)
        emitelem (19, vamin)
        emitelem (20, ve1)
        emitelem (21, ve2)
        emitelem (22, vemin)
        emitelem (23, vfemax)
        emitelem (24, vrmax)
        emitelem (25, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC7B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC7B>".format (id, export_fields)
    }
}

object ExcIEEEAC7B
extends
    Parseable[ExcIEEEAC7B]
{
    override val fields: Array[String] = Array[String] (
        "kc",
        "kd",
        "kdr",
        "ke",
        "kf1",
        "kf2",
        "kf3",
        "kia",
        "kir",
        "kl",
        "kp",
        "kpa",
        "kpr",
        "seve1",
        "seve2",
        "tdr",
        "te",
        "tf",
        "vamax",
        "vamin",
        "ve1",
        "ve2",
        "vemin",
        "vfemax",
        "vrmax",
        "vrmin"
    )
    val kc: Fielder = parse_element (element (cls, fields(0)))
    val kd: Fielder = parse_element (element (cls, fields(1)))
    val kdr: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kf1: Fielder = parse_element (element (cls, fields(4)))
    val kf2: Fielder = parse_element (element (cls, fields(5)))
    val kf3: Fielder = parse_element (element (cls, fields(6)))
    val kia: Fielder = parse_element (element (cls, fields(7)))
    val kir: Fielder = parse_element (element (cls, fields(8)))
    val kl: Fielder = parse_element (element (cls, fields(9)))
    val kp: Fielder = parse_element (element (cls, fields(10)))
    val kpa: Fielder = parse_element (element (cls, fields(11)))
    val kpr: Fielder = parse_element (element (cls, fields(12)))
    val seve1: Fielder = parse_element (element (cls, fields(13)))
    val seve2: Fielder = parse_element (element (cls, fields(14)))
    val tdr: Fielder = parse_element (element (cls, fields(15)))
    val te: Fielder = parse_element (element (cls, fields(16)))
    val tf: Fielder = parse_element (element (cls, fields(17)))
    val vamax: Fielder = parse_element (element (cls, fields(18)))
    val vamin: Fielder = parse_element (element (cls, fields(19)))
    val ve1: Fielder = parse_element (element (cls, fields(20)))
    val ve2: Fielder = parse_element (element (cls, fields(21)))
    val vemin: Fielder = parse_element (element (cls, fields(22)))
    val vfemax: Fielder = parse_element (element (cls, fields(23)))
    val vrmax: Fielder = parse_element (element (cls, fields(24)))
    val vrmin: Fielder = parse_element (element (cls, fields(25)))

    def parse (context: Context): ExcIEEEAC7B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC7B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kc (), 0)),
            toDouble (mask (kd (), 1)),
            toDouble (mask (kdr (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kf1 (), 4)),
            toDouble (mask (kf2 (), 5)),
            toDouble (mask (kf3 (), 6)),
            toDouble (mask (kia (), 7)),
            toDouble (mask (kir (), 8)),
            toDouble (mask (kl (), 9)),
            toDouble (mask (kp (), 10)),
            toDouble (mask (kpa (), 11)),
            toDouble (mask (kpr (), 12)),
            toDouble (mask (seve1 (), 13)),
            toDouble (mask (seve2 (), 14)),
            toDouble (mask (tdr (), 15)),
            toDouble (mask (te (), 16)),
            toDouble (mask (tf (), 17)),
            toDouble (mask (vamax (), 18)),
            toDouble (mask (vamin (), 19)),
            toDouble (mask (ve1 (), 20)),
            toDouble (mask (ve2 (), 21)),
            toDouble (mask (vemin (), 22)),
            toDouble (mask (vfemax (), 23)),
            toDouble (mask (vrmax (), 24)),
            toDouble (mask (vrmin (), 25))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type AC8B model.
 *
 * This model represents a PID voltage regulator with either a brushless exciter or dc exciter. The AVR in this model consists of PID control, with separate constants for the proportional (<b>K</b><b><sub>PR</sub></b>), integral (<b>K</b><b><sub>IR</sub></b>), and derivative (<b>K</b><b><sub>DR</sub></b>) gains. The representation of the brushless exciter (<b>T</b><b><sub>E</sub></b>, <b>K</b><b><sub>E</sub></b>, <b>S</b><b><sub>E</sub></b>, <b>K</b><b><sub>C</sub></b>, <b>K</b><b><sub>D</sub></b>) is similar to the model Type AC2A. The Type AC8B model can be used to represent static voltage regulators applied to brushless excitation systems. Digitally based voltage regulators feeding dc rotating main exciters can be represented with the AC Type AC8B model with the parameters <b>K</b><b><sub>C</sub></b> and <b>K</b><b><sub>D</sub></b> set to 0.  For thyristor power stages fed from the generator terminals, the limits <b>V</b><b><sub>RMAX</sub></b> and <b>V</b><b><sub>RMIN</sub></b> should be a function of terminal voltage: <b>V</b><b><sub>T</sub></b> * <b>V</b><b><sub>RMAX</sub></b><sub> </sub>and <b>V</b><b><sub>T</sub></b> * <b>V</b><b><sub>RMIN</sub></b>.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEAC8B
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    kd: Double,
    kdr: Double,
    ke: Double,
    kir: Double,
    kpr: Double,
    seve1: Double,
    seve2: Double,
    ta: Double,
    tdr: Double,
    te: Double,
    ve1: Double,
    ve2: Double,
    vemin: Double,
    vfemax: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEAC8B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEAC8B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEAC8B.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, kd)
        emitelem (3, kdr)
        emitelem (4, ke)
        emitelem (5, kir)
        emitelem (6, kpr)
        emitelem (7, seve1)
        emitelem (8, seve2)
        emitelem (9, ta)
        emitelem (10, tdr)
        emitelem (11, te)
        emitelem (12, ve1)
        emitelem (13, ve2)
        emitelem (14, vemin)
        emitelem (15, vfemax)
        emitelem (16, vrmax)
        emitelem (17, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEAC8B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEAC8B>".format (id, export_fields)
    }
}

object ExcIEEEAC8B
extends
    Parseable[ExcIEEEAC8B]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "kd",
        "kdr",
        "ke",
        "kir",
        "kpr",
        "seve1",
        "seve2",
        "ta",
        "tdr",
        "te",
        "ve1",
        "ve2",
        "vemin",
        "vfemax",
        "vrmax",
        "vrmin"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kd: Fielder = parse_element (element (cls, fields(2)))
    val kdr: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kir: Fielder = parse_element (element (cls, fields(5)))
    val kpr: Fielder = parse_element (element (cls, fields(6)))
    val seve1: Fielder = parse_element (element (cls, fields(7)))
    val seve2: Fielder = parse_element (element (cls, fields(8)))
    val ta: Fielder = parse_element (element (cls, fields(9)))
    val tdr: Fielder = parse_element (element (cls, fields(10)))
    val te: Fielder = parse_element (element (cls, fields(11)))
    val ve1: Fielder = parse_element (element (cls, fields(12)))
    val ve2: Fielder = parse_element (element (cls, fields(13)))
    val vemin: Fielder = parse_element (element (cls, fields(14)))
    val vfemax: Fielder = parse_element (element (cls, fields(15)))
    val vrmax: Fielder = parse_element (element (cls, fields(16)))
    val vrmin: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcIEEEAC8B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEAC8B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kd (), 2)),
            toDouble (mask (kdr (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kir (), 5)),
            toDouble (mask (kpr (), 6)),
            toDouble (mask (seve1 (), 7)),
            toDouble (mask (seve2 (), 8)),
            toDouble (mask (ta (), 9)),
            toDouble (mask (tdr (), 10)),
            toDouble (mask (te (), 11)),
            toDouble (mask (ve1 (), 12)),
            toDouble (mask (ve2 (), 13)),
            toDouble (mask (vemin (), 14)),
            toDouble (mask (vfemax (), 15)),
            toDouble (mask (vrmax (), 16)),
            toDouble (mask (vrmin (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC1A model.
 *
 * This model represents field-controlled dc commutator exciters with continuously acting voltage regulators (especially the direct-acting rheostatic, rotating amplifier, and magnetic amplifier types).  Because this model has been widely implemented by the industry, it is sometimes used to represent other types of systems when detailed data for them are not available or when a simplified model is required.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = input is connected to the HV gate
 *        false = input connects to the error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -0.9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEDC1A
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    exclim: Boolean,
    ka: Double,
    ke: Double,
    kf: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    uelin: Boolean,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEDC1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEDC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEDC1A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, exclim)
        emitelem (3, ka)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, seefd1)
        emitelem (7, seefd2)
        emitelem (8, ta)
        emitelem (9, tb)
        emitelem (10, tc)
        emitelem (11, te)
        emitelem (12, tf)
        emitelem (13, uelin)
        emitelem (14, vrmax)
        emitelem (15, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEDC1A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEDC1A>".format (id, export_fields)
    }
}

object ExcIEEEDC1A
extends
    Parseable[ExcIEEEDC1A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "exclim",
        "ka",
        "ke",
        "kf",
        "seefd1",
        "seefd2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "uelin",
        "vrmax",
        "vrmin"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val exclim: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val seefd1: Fielder = parse_element (element (cls, fields(6)))
    val seefd2: Fielder = parse_element (element (cls, fields(7)))
    val ta: Fielder = parse_element (element (cls, fields(8)))
    val tb: Fielder = parse_element (element (cls, fields(9)))
    val tc: Fielder = parse_element (element (cls, fields(10)))
    val te: Fielder = parse_element (element (cls, fields(11)))
    val tf: Fielder = parse_element (element (cls, fields(12)))
    val uelin: Fielder = parse_element (element (cls, fields(13)))
    val vrmax: Fielder = parse_element (element (cls, fields(14)))
    val vrmin: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): ExcIEEEDC1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEDC1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toBoolean (mask (exclim (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (seefd1 (), 6)),
            toDouble (mask (seefd2 (), 7)),
            toDouble (mask (ta (), 8)),
            toDouble (mask (tb (), 9)),
            toDouble (mask (tc (), 10)),
            toDouble (mask (te (), 11)),
            toDouble (mask (tf (), 12)),
            toBoolean (mask (uelin (), 13)),
            toDouble (mask (vrmax (), 14)),
            toDouble (mask (vrmin (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC2A model.
 *
 * This model represents represent field-controlled dc commutator exciters with continuously acting voltage regulators having supplies obtained from the generator or auxiliary bus.  It differs from the Type DC1A model only in the voltage regulator output limits, which are now proportional to terminal voltage <b>V</b><b><sub>T</sub></b>.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = input is connected to the HV gate
 *        false = input connects to the error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 4.95.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -4.9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEDC2A
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    exclim: Double,
    ka: Double,
    ke: Double,
    kf: Double,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    uelin: Boolean,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEDC2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEDC2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEDC2A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, exclim)
        emitelem (3, ka)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, seefd1)
        emitelem (7, seefd2)
        emitelem (8, ta)
        emitelem (9, tb)
        emitelem (10, tc)
        emitelem (11, te)
        emitelem (12, tf)
        emitelem (13, uelin)
        emitelem (14, vrmax)
        emitelem (15, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEDC2A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEDC2A>".format (id, export_fields)
    }
}

object ExcIEEEDC2A
extends
    Parseable[ExcIEEEDC2A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "exclim",
        "ka",
        "ke",
        "kf",
        "seefd1",
        "seefd2",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "uelin",
        "vrmax",
        "vrmin"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val exclim: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val seefd1: Fielder = parse_element (element (cls, fields(6)))
    val seefd2: Fielder = parse_element (element (cls, fields(7)))
    val ta: Fielder = parse_element (element (cls, fields(8)))
    val tb: Fielder = parse_element (element (cls, fields(9)))
    val tc: Fielder = parse_element (element (cls, fields(10)))
    val te: Fielder = parse_element (element (cls, fields(11)))
    val tf: Fielder = parse_element (element (cls, fields(12)))
    val uelin: Fielder = parse_element (element (cls, fields(13)))
    val vrmax: Fielder = parse_element (element (cls, fields(14)))
    val vrmin: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): ExcIEEEDC2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEDC2A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (exclim (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (seefd1 (), 6)),
            toDouble (mask (seefd2 (), 7)),
            toDouble (mask (ta (), 8)),
            toDouble (mask (tb (), 9)),
            toDouble (mask (tc (), 10)),
            toDouble (mask (te (), 11)),
            toDouble (mask (tf (), 12)),
            toBoolean (mask (uelin (), 13)),
            toDouble (mask (vrmax (), 14)),
            toDouble (mask (vrmin (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC3A model.
 *
 * This model represents represent older systems, in particular those dc commutator exciters with non-continuously acting regulators that were commonly used before the development of the continuously acting varieties.  These systems respond at basically two different rates, depending upon the magnitude of voltage error. For small errors, adjustment is made periodically with a signal to a motor-operated rheostat. Larger errors cause resistors to be quickly shorted or inserted and a strong forcing signal applied to the exciter. Continuous motion of the motor-operated rheostat occurs for these larger error signals, even though it is bypassed by contactor action.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEDC3A
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    exclim: Boolean,
    ke: Double,
    kv: Double,
    seefd1: Double,
    seefd2: Double,
    te: Double,
    trh: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEDC3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEDC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEDC3A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, exclim)
        emitelem (3, ke)
        emitelem (4, kv)
        emitelem (5, seefd1)
        emitelem (6, seefd2)
        emitelem (7, te)
        emitelem (8, trh)
        emitelem (9, vrmax)
        emitelem (10, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEDC3A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEDC3A>".format (id, export_fields)
    }
}

object ExcIEEEDC3A
extends
    Parseable[ExcIEEEDC3A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "exclim",
        "ke",
        "kv",
        "seefd1",
        "seefd2",
        "te",
        "trh",
        "vrmax",
        "vrmin"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val exclim: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kv: Fielder = parse_element (element (cls, fields(4)))
    val seefd1: Fielder = parse_element (element (cls, fields(5)))
    val seefd2: Fielder = parse_element (element (cls, fields(6)))
    val te: Fielder = parse_element (element (cls, fields(7)))
    val trh: Fielder = parse_element (element (cls, fields(8)))
    val vrmax: Fielder = parse_element (element (cls, fields(9)))
    val vrmin: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): ExcIEEEDC3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEDC3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toBoolean (mask (exclim (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kv (), 4)),
            toDouble (mask (seefd1 (), 5)),
            toDouble (mask (seefd2 (), 6)),
            toDouble (mask (te (), 7)),
            toDouble (mask (trh (), 8)),
            toDouble (mask (vrmax (), 9)),
            toDouble (mask (vrmin (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type DC4B model.
 *
 * These excitation systems utilize a field-controlled dc commutator exciter with a continuously acting voltage regulator having supplies obtained from the generator or auxiliary bus.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = LV gate
 *        false = subtract from error signal.
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
 *        true = HV gate
 *        false = add to error signal.
 *        Typical Value = true.
 * @param vemin Minimum exciter voltage output(V<sub>EMIN</sub>).
 *        Typical Value = 0.
 * @param vrmax Maximum voltage regulator output (V<sub>RMAX</sub>).
 *        Typical Value = 2.7.
 * @param vrmin Minimum voltage regulator output (V<sub>RMIN</sub>).
 *        Typical Value = -0.9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEDC4B
(
    override val sup: ExcitationSystemDynamics,
    efd1: Double,
    efd2: Double,
    ka: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    oelin: Boolean,
    seefd1: Double,
    seefd2: Double,
    ta: Double,
    td: Double,
    te: Double,
    tf: Double,
    uelin: Boolean,
    vemin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEDC4B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEDC4B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEDC4B.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, ka)
        emitelem (3, kd)
        emitelem (4, ke)
        emitelem (5, kf)
        emitelem (6, ki)
        emitelem (7, kp)
        emitelem (8, oelin)
        emitelem (9, seefd1)
        emitelem (10, seefd2)
        emitelem (11, ta)
        emitelem (12, td)
        emitelem (13, te)
        emitelem (14, tf)
        emitelem (15, uelin)
        emitelem (16, vemin)
        emitelem (17, vrmax)
        emitelem (18, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEDC4B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEDC4B>".format (id, export_fields)
    }
}

object ExcIEEEDC4B
extends
    Parseable[ExcIEEEDC4B]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "ka",
        "kd",
        "ke",
        "kf",
        "ki",
        "kp",
        "oelin",
        "seefd1",
        "seefd2",
        "ta",
        "td",
        "te",
        "tf",
        "uelin",
        "vemin",
        "vrmax",
        "vrmin"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val ke: Fielder = parse_element (element (cls, fields(4)))
    val kf: Fielder = parse_element (element (cls, fields(5)))
    val ki: Fielder = parse_element (element (cls, fields(6)))
    val kp: Fielder = parse_element (element (cls, fields(7)))
    val oelin: Fielder = parse_element (element (cls, fields(8)))
    val seefd1: Fielder = parse_element (element (cls, fields(9)))
    val seefd2: Fielder = parse_element (element (cls, fields(10)))
    val ta: Fielder = parse_element (element (cls, fields(11)))
    val td: Fielder = parse_element (element (cls, fields(12)))
    val te: Fielder = parse_element (element (cls, fields(13)))
    val tf: Fielder = parse_element (element (cls, fields(14)))
    val uelin: Fielder = parse_element (element (cls, fields(15)))
    val vemin: Fielder = parse_element (element (cls, fields(16)))
    val vrmax: Fielder = parse_element (element (cls, fields(17)))
    val vrmin: Fielder = parse_element (element (cls, fields(18)))

    def parse (context: Context): ExcIEEEDC4B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEDC4B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (ke (), 4)),
            toDouble (mask (kf (), 5)),
            toDouble (mask (ki (), 6)),
            toDouble (mask (kp (), 7)),
            toBoolean (mask (oelin (), 8)),
            toDouble (mask (seefd1 (), 9)),
            toDouble (mask (seefd2 (), 10)),
            toDouble (mask (ta (), 11)),
            toDouble (mask (td (), 12)),
            toDouble (mask (te (), 13)),
            toDouble (mask (tf (), 14)),
            toBoolean (mask (uelin (), 15)),
            toDouble (mask (vemin (), 16)),
            toDouble (mask (vrmax (), 17)),
            toDouble (mask (vrmin (), 18))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST1A model.
 *
 * This model represents systems in which excitation power is supplied through a transformer from the generator terminals (or the unit�s auxiliary bus) and is regulated by a controlled rectifier.  The maximum exciter voltage available from such systems is directly related to the generator terminal voltage.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = PSS input (Vs) added to error signal
 *        false = PSS input (Vs) added to voltage regulator output.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST1A
(
    override val sup: ExcitationSystemDynamics,
    ilr: Double,
    ka: Double,
    kc: Double,
    kf: Double,
    klr: Double,
    pssin: Boolean,
    ta: Double,
    tb: Double,
    tb1: Double,
    tc: Double,
    tc1: Double,
    tf: Double,
    uelin: String,
    vamax: Double,
    vamin: Double,
    vimax: Double,
    vimin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST1A.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcIEEEST1A.fields (position), value)
        emitelem (0, ilr)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kf)
        emitelem (4, klr)
        emitelem (5, pssin)
        emitelem (6, ta)
        emitelem (7, tb)
        emitelem (8, tb1)
        emitelem (9, tc)
        emitelem (10, tc1)
        emitelem (11, tf)
        emitattr (12, uelin)
        emitelem (13, vamax)
        emitelem (14, vamin)
        emitelem (15, vimax)
        emitelem (16, vimin)
        emitelem (17, vrmax)
        emitelem (18, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST1A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST1A>".format (id, export_fields)
    }
}

object ExcIEEEST1A
extends
    Parseable[ExcIEEEST1A]
{
    override val fields: Array[String] = Array[String] (
        "ilr",
        "ka",
        "kc",
        "kf",
        "klr",
        "pssin",
        "ta",
        "tb",
        "tb1",
        "tc",
        "tc1",
        "tf",
        "uelin",
        "vamax",
        "vamin",
        "vimax",
        "vimin",
        "vrmax",
        "vrmin"
    )
    val ilr: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kf: Fielder = parse_element (element (cls, fields(3)))
    val klr: Fielder = parse_element (element (cls, fields(4)))
    val pssin: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val tb1: Fielder = parse_element (element (cls, fields(8)))
    val tc: Fielder = parse_element (element (cls, fields(9)))
    val tc1: Fielder = parse_element (element (cls, fields(10)))
    val tf: Fielder = parse_element (element (cls, fields(11)))
    val uelin: Fielder = parse_attribute (attribute (cls, fields(12)))
    val vamax: Fielder = parse_element (element (cls, fields(13)))
    val vamin: Fielder = parse_element (element (cls, fields(14)))
    val vimax: Fielder = parse_element (element (cls, fields(15)))
    val vimin: Fielder = parse_element (element (cls, fields(16)))
    val vrmax: Fielder = parse_element (element (cls, fields(17)))
    val vrmin: Fielder = parse_element (element (cls, fields(18)))

    def parse (context: Context): ExcIEEEST1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ilr (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (klr (), 4)),
            toBoolean (mask (pssin (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (tb1 (), 8)),
            toDouble (mask (tc (), 9)),
            toDouble (mask (tc1 (), 10)),
            toDouble (mask (tf (), 11)),
            mask (uelin (), 12),
            toDouble (mask (vamax (), 13)),
            toDouble (mask (vamin (), 14)),
            toDouble (mask (vimax (), 15)),
            toDouble (mask (vimin (), 16)),
            toDouble (mask (vrmax (), 17)),
            toDouble (mask (vrmin (), 18))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST2A model.
 *
 * Some static systems utilize both current and voltage sources (generator terminal quantities) to comprise the power source.  The regulator controls the exciter output through controlled saturation of the power transformer components.  These compound-source rectifier excitation systems are designated Type ST2A and are represented by ExcIEEEST2A.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = HV gate
 *        false = add to error signal.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator outputs (V<sub>RMAX</sub>).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator outputs (V<sub>RMIN</sub>).
 *        Typical Value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST2A
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    ka: Double,
    kc: Double,
    ke: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    ta: Double,
    te: Double,
    tf: Double,
    uelin: Boolean,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST2A.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, ke)
        emitelem (4, kf)
        emitelem (5, ki)
        emitelem (6, kp)
        emitelem (7, ta)
        emitelem (8, te)
        emitelem (9, tf)
        emitelem (10, uelin)
        emitelem (11, vrmax)
        emitelem (12, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST2A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST2A>".format (id, export_fields)
    }
}

object ExcIEEEST2A
extends
    Parseable[ExcIEEEST2A]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "ka",
        "kc",
        "ke",
        "kf",
        "ki",
        "kp",
        "ta",
        "te",
        "tf",
        "uelin",
        "vrmax",
        "vrmin"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kf: Fielder = parse_element (element (cls, fields(4)))
    val ki: Fielder = parse_element (element (cls, fields(5)))
    val kp: Fielder = parse_element (element (cls, fields(6)))
    val ta: Fielder = parse_element (element (cls, fields(7)))
    val te: Fielder = parse_element (element (cls, fields(8)))
    val tf: Fielder = parse_element (element (cls, fields(9)))
    val uelin: Fielder = parse_element (element (cls, fields(10)))
    val vrmax: Fielder = parse_element (element (cls, fields(11)))
    val vrmin: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: Context): ExcIEEEST2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST2A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kf (), 4)),
            toDouble (mask (ki (), 5)),
            toDouble (mask (kp (), 6)),
            toDouble (mask (ta (), 7)),
            toDouble (mask (te (), 8)),
            toDouble (mask (tf (), 9)),
            toBoolean (mask (uelin (), 10)),
            toDouble (mask (vrmax (), 11)),
            toDouble (mask (vrmin (), 12))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST3A model.
 *
 * Some static systems utilize a field voltage control loop to linearize the exciter control characteristic. This also makes the output independent of supply source variations until supply limitations are reached.  These systems utilize a variety of controlled-rectifier designs: full thyristor complements or hybrid bridges
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST3A
(
    override val sup: ExcitationSystemDynamics,
    ka: Double,
    kc: Double,
    kg: Double,
    ki: Double,
    km: Double,
    kp: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    thetap: Double,
    tm: Double,
    vbmax: Double,
    vgmax: Double,
    vimax: Double,
    vimin: Double,
    vmmax: Double,
    vmmin: Double,
    vrmax: Double,
    vrmin: Double,
    xl: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST3A.fields (position), value)
        emitelem (0, ka)
        emitelem (1, kc)
        emitelem (2, kg)
        emitelem (3, ki)
        emitelem (4, km)
        emitelem (5, kp)
        emitelem (6, ta)
        emitelem (7, tb)
        emitelem (8, tc)
        emitelem (9, thetap)
        emitelem (10, tm)
        emitelem (11, vbmax)
        emitelem (12, vgmax)
        emitelem (13, vimax)
        emitelem (14, vimin)
        emitelem (15, vmmax)
        emitelem (16, vmmin)
        emitelem (17, vrmax)
        emitelem (18, vrmin)
        emitelem (19, xl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST3A rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST3A>".format (id, export_fields)
    }
}

object ExcIEEEST3A
extends
    Parseable[ExcIEEEST3A]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "kc",
        "kg",
        "ki",
        "km",
        "kp",
        "ta",
        "tb",
        "tc",
        "thetap",
        "tm",
        "vbmax",
        "vgmax",
        "vimax",
        "vimin",
        "vmmax",
        "vmmin",
        "vrmax",
        "vrmin",
        "xl"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kg: Fielder = parse_element (element (cls, fields(2)))
    val ki: Fielder = parse_element (element (cls, fields(3)))
    val km: Fielder = parse_element (element (cls, fields(4)))
    val kp: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val tc: Fielder = parse_element (element (cls, fields(8)))
    val thetap: Fielder = parse_element (element (cls, fields(9)))
    val tm: Fielder = parse_element (element (cls, fields(10)))
    val vbmax: Fielder = parse_element (element (cls, fields(11)))
    val vgmax: Fielder = parse_element (element (cls, fields(12)))
    val vimax: Fielder = parse_element (element (cls, fields(13)))
    val vimin: Fielder = parse_element (element (cls, fields(14)))
    val vmmax: Fielder = parse_element (element (cls, fields(15)))
    val vmmin: Fielder = parse_element (element (cls, fields(16)))
    val vrmax: Fielder = parse_element (element (cls, fields(17)))
    val vrmin: Fielder = parse_element (element (cls, fields(18)))
    val xl: Fielder = parse_element (element (cls, fields(19)))

    def parse (context: Context): ExcIEEEST3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kg (), 2)),
            toDouble (mask (ki (), 3)),
            toDouble (mask (km (), 4)),
            toDouble (mask (kp (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (tc (), 8)),
            toDouble (mask (thetap (), 9)),
            toDouble (mask (tm (), 10)),
            toDouble (mask (vbmax (), 11)),
            toDouble (mask (vgmax (), 12)),
            toDouble (mask (vimax (), 13)),
            toDouble (mask (vimin (), 14)),
            toDouble (mask (vmmax (), 15)),
            toDouble (mask (vmmin (), 16)),
            toDouble (mask (vrmax (), 17)),
            toDouble (mask (vrmin (), 18)),
            toDouble (mask (xl (), 19))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST4B model.
 *
 * This model is a variation of the Type ST3A model, with a proportional plus integral (PI) regulator block replacing the lag-lead regulator characteristic that is in the ST3A model. Both potential and compound source rectifier excitation systems are modeled.  The PI regulator blocks have non-windup limits that are represented. The voltage regulator of this model is typically implemented digitally.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST4B
(
    override val sup: ExcitationSystemDynamics,
    kc: Double,
    kg: Double,
    ki: Double,
    kim: Double,
    kir: Double,
    kp: Double,
    kpm: Double,
    kpr: Double,
    ta: Double,
    thetap: Double,
    vbmax: Double,
    vmmax: Double,
    vmmin: Double,
    vrmax: Double,
    vrmin: Double,
    xl: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST4B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST4B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST4B.fields (position), value)
        emitelem (0, kc)
        emitelem (1, kg)
        emitelem (2, ki)
        emitelem (3, kim)
        emitelem (4, kir)
        emitelem (5, kp)
        emitelem (6, kpm)
        emitelem (7, kpr)
        emitelem (8, ta)
        emitelem (9, thetap)
        emitelem (10, vbmax)
        emitelem (11, vmmax)
        emitelem (12, vmmin)
        emitelem (13, vrmax)
        emitelem (14, vrmin)
        emitelem (15, xl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST4B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST4B>".format (id, export_fields)
    }
}

object ExcIEEEST4B
extends
    Parseable[ExcIEEEST4B]
{
    override val fields: Array[String] = Array[String] (
        "kc",
        "kg",
        "ki",
        "kim",
        "kir",
        "kp",
        "kpm",
        "kpr",
        "ta",
        "thetap",
        "vbmax",
        "vmmax",
        "vmmin",
        "vrmax",
        "vrmin",
        "xl"
    )
    val kc: Fielder = parse_element (element (cls, fields(0)))
    val kg: Fielder = parse_element (element (cls, fields(1)))
    val ki: Fielder = parse_element (element (cls, fields(2)))
    val kim: Fielder = parse_element (element (cls, fields(3)))
    val kir: Fielder = parse_element (element (cls, fields(4)))
    val kp: Fielder = parse_element (element (cls, fields(5)))
    val kpm: Fielder = parse_element (element (cls, fields(6)))
    val kpr: Fielder = parse_element (element (cls, fields(7)))
    val ta: Fielder = parse_element (element (cls, fields(8)))
    val thetap: Fielder = parse_element (element (cls, fields(9)))
    val vbmax: Fielder = parse_element (element (cls, fields(10)))
    val vmmax: Fielder = parse_element (element (cls, fields(11)))
    val vmmin: Fielder = parse_element (element (cls, fields(12)))
    val vrmax: Fielder = parse_element (element (cls, fields(13)))
    val vrmin: Fielder = parse_element (element (cls, fields(14)))
    val xl: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): ExcIEEEST4B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST4B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kc (), 0)),
            toDouble (mask (kg (), 1)),
            toDouble (mask (ki (), 2)),
            toDouble (mask (kim (), 3)),
            toDouble (mask (kir (), 4)),
            toDouble (mask (kp (), 5)),
            toDouble (mask (kpm (), 6)),
            toDouble (mask (kpr (), 7)),
            toDouble (mask (ta (), 8)),
            toDouble (mask (thetap (), 9)),
            toDouble (mask (vbmax (), 10)),
            toDouble (mask (vmmax (), 11)),
            toDouble (mask (vmmin (), 12)),
            toDouble (mask (vrmax (), 13)),
            toDouble (mask (vrmin (), 14)),
            toDouble (mask (xl (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST5B model.
 *
 * The Type ST5B excitation system is a variation of the Type ST1A model, with alternative overexcitation and underexcitation inputs and additional limits.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST5B
(
    override val sup: ExcitationSystemDynamics,
    kc: Double,
    kr: Double,
    t1: Double,
    tb1: Double,
    tb2: Double,
    tc1: Double,
    tc2: Double,
    tob1: Double,
    tob2: Double,
    toc1: Double,
    toc2: Double,
    tub1: Double,
    tub2: Double,
    tuc1: Double,
    tuc2: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST5B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST5B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST5B.fields (position), value)
        emitelem (0, kc)
        emitelem (1, kr)
        emitelem (2, t1)
        emitelem (3, tb1)
        emitelem (4, tb2)
        emitelem (5, tc1)
        emitelem (6, tc2)
        emitelem (7, tob1)
        emitelem (8, tob2)
        emitelem (9, toc1)
        emitelem (10, toc2)
        emitelem (11, tub1)
        emitelem (12, tub2)
        emitelem (13, tuc1)
        emitelem (14, tuc2)
        emitelem (15, vrmax)
        emitelem (16, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST5B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST5B>".format (id, export_fields)
    }
}

object ExcIEEEST5B
extends
    Parseable[ExcIEEEST5B]
{
    override val fields: Array[String] = Array[String] (
        "kc",
        "kr",
        "t1",
        "tb1",
        "tb2",
        "tc1",
        "tc2",
        "tob1",
        "tob2",
        "toc1",
        "toc2",
        "tub1",
        "tub2",
        "tuc1",
        "tuc2",
        "vrmax",
        "vrmin"
    )
    val kc: Fielder = parse_element (element (cls, fields(0)))
    val kr: Fielder = parse_element (element (cls, fields(1)))
    val t1: Fielder = parse_element (element (cls, fields(2)))
    val tb1: Fielder = parse_element (element (cls, fields(3)))
    val tb2: Fielder = parse_element (element (cls, fields(4)))
    val tc1: Fielder = parse_element (element (cls, fields(5)))
    val tc2: Fielder = parse_element (element (cls, fields(6)))
    val tob1: Fielder = parse_element (element (cls, fields(7)))
    val tob2: Fielder = parse_element (element (cls, fields(8)))
    val toc1: Fielder = parse_element (element (cls, fields(9)))
    val toc2: Fielder = parse_element (element (cls, fields(10)))
    val tub1: Fielder = parse_element (element (cls, fields(11)))
    val tub2: Fielder = parse_element (element (cls, fields(12)))
    val tuc1: Fielder = parse_element (element (cls, fields(13)))
    val tuc2: Fielder = parse_element (element (cls, fields(14)))
    val vrmax: Fielder = parse_element (element (cls, fields(15)))
    val vrmin: Fielder = parse_element (element (cls, fields(16)))

    def parse (context: Context): ExcIEEEST5B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST5B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kc (), 0)),
            toDouble (mask (kr (), 1)),
            toDouble (mask (t1 (), 2)),
            toDouble (mask (tb1 (), 3)),
            toDouble (mask (tb2 (), 4)),
            toDouble (mask (tc1 (), 5)),
            toDouble (mask (tc2 (), 6)),
            toDouble (mask (tob1 (), 7)),
            toDouble (mask (tob2 (), 8)),
            toDouble (mask (toc1 (), 9)),
            toDouble (mask (toc2 (), 10)),
            toDouble (mask (tub1 (), 11)),
            toDouble (mask (tub2 (), 12)),
            toDouble (mask (tuc1 (), 13)),
            toDouble (mask (tuc2 (), 14)),
            toDouble (mask (vrmax (), 15)),
            toDouble (mask (vrmin (), 16))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST6B model.
 *
 * This model consists of a PI voltage regulator with an inner loop field voltage regulator and pre-control. The field voltage regulator implements a proportional control. The pre-control and the delay in the feedback circuit increase the dynamic response.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST6B
(
    override val sup: ExcitationSystemDynamics,
    ilr: Double,
    kci: Double,
    kff: Double,
    kg: Double,
    kia: Double,
    klr: Double,
    km: Double,
    kpa: Double,
    oelin: String,
    tg: Double,
    vamax: Double,
    vamin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST6B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST6B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST6B.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcIEEEST6B.fields (position), value)
        emitelem (0, ilr)
        emitelem (1, kci)
        emitelem (2, kff)
        emitelem (3, kg)
        emitelem (4, kia)
        emitelem (5, klr)
        emitelem (6, km)
        emitelem (7, kpa)
        emitattr (8, oelin)
        emitelem (9, tg)
        emitelem (10, vamax)
        emitelem (11, vamin)
        emitelem (12, vrmax)
        emitelem (13, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST6B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST6B>".format (id, export_fields)
    }
}

object ExcIEEEST6B
extends
    Parseable[ExcIEEEST6B]
{
    override val fields: Array[String] = Array[String] (
        "ilr",
        "kci",
        "kff",
        "kg",
        "kia",
        "klr",
        "km",
        "kpa",
        "oelin",
        "tg",
        "vamax",
        "vamin",
        "vrmax",
        "vrmin"
    )
    val ilr: Fielder = parse_element (element (cls, fields(0)))
    val kci: Fielder = parse_element (element (cls, fields(1)))
    val kff: Fielder = parse_element (element (cls, fields(2)))
    val kg: Fielder = parse_element (element (cls, fields(3)))
    val kia: Fielder = parse_element (element (cls, fields(4)))
    val klr: Fielder = parse_element (element (cls, fields(5)))
    val km: Fielder = parse_element (element (cls, fields(6)))
    val kpa: Fielder = parse_element (element (cls, fields(7)))
    val oelin: Fielder = parse_attribute (attribute (cls, fields(8)))
    val tg: Fielder = parse_element (element (cls, fields(9)))
    val vamax: Fielder = parse_element (element (cls, fields(10)))
    val vamin: Fielder = parse_element (element (cls, fields(11)))
    val vrmax: Fielder = parse_element (element (cls, fields(12)))
    val vrmin: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): ExcIEEEST6B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST6B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ilr (), 0)),
            toDouble (mask (kci (), 1)),
            toDouble (mask (kff (), 2)),
            toDouble (mask (kg (), 3)),
            toDouble (mask (kia (), 4)),
            toDouble (mask (klr (), 5)),
            toDouble (mask (km (), 6)),
            toDouble (mask (kpa (), 7)),
            mask (oelin (), 8),
            toDouble (mask (tg (), 9)),
            toDouble (mask (vamax (), 10)),
            toDouble (mask (vamin (), 11)),
            toDouble (mask (vrmax (), 12)),
            toDouble (mask (vrmin (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type ST7B model.
 *
 * This model is representative of static potential-source excitation systems. In this system, the AVR consists of a PI voltage regulator. A phase lead-lag filter in series allows introduction of a derivative function, typically used with brushless excitation systems. In that case, the regulator is of the PID type. In addition, the terminal voltage channel includes a phase lead-lag filter.  The AVR includes the appropriate inputs on its reference for overexcitation limiter (OEL1), underexcitation limiter (UEL), stator current limiter (SCL), and current compensator (DROOP). All these limitations, when they work at voltage reference level, keep the PSS (VS signal from Type PSS1A, PSS2A, or PSS2B) in operation. However, the UEL limitation can also be transferred to the high value (HV) gate acting on the output signal. In addition, the output signal passes through a low value (LV) gate for a ceiling overexcitation limiter (OEL2).
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcIEEEST7B
(
    override val sup: ExcitationSystemDynamics,
    kh: Double,
    kia: Double,
    kl: Double,
    kpa: Double,
    oelin: String,
    tb: Double,
    tc: Double,
    tf: Double,
    tg: Double,
    tia: Double,
    uelin: String,
    vmax: Double,
    vmin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcIEEEST7B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcIEEEST7B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcIEEEST7B.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcIEEEST7B.fields (position), value)
        emitelem (0, kh)
        emitelem (1, kia)
        emitelem (2, kl)
        emitelem (3, kpa)
        emitattr (4, oelin)
        emitelem (5, tb)
        emitelem (6, tc)
        emitelem (7, tf)
        emitelem (8, tg)
        emitelem (9, tia)
        emitattr (10, uelin)
        emitelem (11, vmax)
        emitelem (12, vmin)
        emitelem (13, vrmax)
        emitelem (14, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcIEEEST7B rdf:ID=\"%s\">\n%s\t</cim:ExcIEEEST7B>".format (id, export_fields)
    }
}

object ExcIEEEST7B
extends
    Parseable[ExcIEEEST7B]
{
    override val fields: Array[String] = Array[String] (
        "kh",
        "kia",
        "kl",
        "kpa",
        "oelin",
        "tb",
        "tc",
        "tf",
        "tg",
        "tia",
        "uelin",
        "vmax",
        "vmin",
        "vrmax",
        "vrmin"
    )
    val kh: Fielder = parse_element (element (cls, fields(0)))
    val kia: Fielder = parse_element (element (cls, fields(1)))
    val kl: Fielder = parse_element (element (cls, fields(2)))
    val kpa: Fielder = parse_element (element (cls, fields(3)))
    val oelin: Fielder = parse_attribute (attribute (cls, fields(4)))
    val tb: Fielder = parse_element (element (cls, fields(5)))
    val tc: Fielder = parse_element (element (cls, fields(6)))
    val tf: Fielder = parse_element (element (cls, fields(7)))
    val tg: Fielder = parse_element (element (cls, fields(8)))
    val tia: Fielder = parse_element (element (cls, fields(9)))
    val uelin: Fielder = parse_attribute (attribute (cls, fields(10)))
    val vmax: Fielder = parse_element (element (cls, fields(11)))
    val vmin: Fielder = parse_element (element (cls, fields(12)))
    val vrmax: Fielder = parse_element (element (cls, fields(13)))
    val vrmin: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): ExcIEEEST7B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcIEEEST7B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kh (), 0)),
            toDouble (mask (kia (), 1)),
            toDouble (mask (kl (), 2)),
            toDouble (mask (kpa (), 3)),
            mask (oelin (), 4),
            toDouble (mask (tb (), 5)),
            toDouble (mask (tc (), 6)),
            toDouble (mask (tf (), 7)),
            toDouble (mask (tg (), 8)),
            toDouble (mask (tia (), 9)),
            mask (uelin (), 10),
            toDouble (mask (vmax (), 11)),
            toDouble (mask (vmin (), 12)),
            toDouble (mask (vrmax (), 13)),
            toDouble (mask (vrmin (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE Type ST1 Excitation System with semi-continuous and acting terminal voltage limiter.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcOEX3T
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    ka: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kf: Double,
    see1: Double,
    see2: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    te: Double,
    tf: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcOEX3T] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcOEX3T.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcOEX3T.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitelem (2, ka)
        emitelem (3, kc)
        emitelem (4, kd)
        emitelem (5, ke)
        emitelem (6, kf)
        emitelem (7, see1)
        emitelem (8, see2)
        emitelem (9, t1)
        emitelem (10, t2)
        emitelem (11, t3)
        emitelem (12, t4)
        emitelem (13, t5)
        emitelem (14, t6)
        emitelem (15, te)
        emitelem (16, tf)
        emitelem (17, vrmax)
        emitelem (18, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcOEX3T rdf:ID=\"%s\">\n%s\t</cim:ExcOEX3T>".format (id, export_fields)
    }
}

object ExcOEX3T
extends
    Parseable[ExcOEX3T]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "ka",
        "kc",
        "kd",
        "ke",
        "kf",
        "see1",
        "see2",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "te",
        "tf",
        "vrmax",
        "vrmin"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val ka: Fielder = parse_element (element (cls, fields(2)))
    val kc: Fielder = parse_element (element (cls, fields(3)))
    val kd: Fielder = parse_element (element (cls, fields(4)))
    val ke: Fielder = parse_element (element (cls, fields(5)))
    val kf: Fielder = parse_element (element (cls, fields(6)))
    val see1: Fielder = parse_element (element (cls, fields(7)))
    val see2: Fielder = parse_element (element (cls, fields(8)))
    val t1: Fielder = parse_element (element (cls, fields(9)))
    val t2: Fielder = parse_element (element (cls, fields(10)))
    val t3: Fielder = parse_element (element (cls, fields(11)))
    val t4: Fielder = parse_element (element (cls, fields(12)))
    val t5: Fielder = parse_element (element (cls, fields(13)))
    val t6: Fielder = parse_element (element (cls, fields(14)))
    val te: Fielder = parse_element (element (cls, fields(15)))
    val tf: Fielder = parse_element (element (cls, fields(16)))
    val vrmax: Fielder = parse_element (element (cls, fields(17)))
    val vrmin: Fielder = parse_element (element (cls, fields(18)))

    def parse (context: Context): ExcOEX3T =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcOEX3T (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            toDouble (mask (ka (), 2)),
            toDouble (mask (kc (), 3)),
            toDouble (mask (kd (), 4)),
            toDouble (mask (ke (), 5)),
            toDouble (mask (kf (), 6)),
            toDouble (mask (see1 (), 7)),
            toDouble (mask (see2 (), 8)),
            toDouble (mask (t1 (), 9)),
            toDouble (mask (t2 (), 10)),
            toDouble (mask (t3 (), 11)),
            toDouble (mask (t4 (), 12)),
            toDouble (mask (t5 (), 13)),
            toDouble (mask (t6 (), 14)),
            toDouble (mask (te (), 15)),
            toDouble (mask (tf (), 16)),
            toDouble (mask (vrmax (), 17)),
            toDouble (mask (vrmin (), 18))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Proportional/Integral Regulator Excitation System Model.
 *
 * This model can be used to represent excitation systems with a proportional-integral (PI) voltage regulator controller.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcPIC
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    efdmax: Double,
    efdmin: Double,
    ka: Double,
    kc: Double,
    ke: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    se1: Double,
    se2: Double,
    ta1: Double,
    ta2: Double,
    ta3: Double,
    ta4: Double,
    te: Double,
    tf1: Double,
    tf2: Double,
    vr1: Double,
    vr2: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcPIC] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcPIC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcPIC.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitelem (2, efdmax)
        emitelem (3, efdmin)
        emitelem (4, ka)
        emitelem (5, kc)
        emitelem (6, ke)
        emitelem (7, kf)
        emitelem (8, ki)
        emitelem (9, kp)
        emitelem (10, se1)
        emitelem (11, se2)
        emitelem (12, ta1)
        emitelem (13, ta2)
        emitelem (14, ta3)
        emitelem (15, ta4)
        emitelem (16, te)
        emitelem (17, tf1)
        emitelem (18, tf2)
        emitelem (19, vr1)
        emitelem (20, vr2)
        emitelem (21, vrmax)
        emitelem (22, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcPIC rdf:ID=\"%s\">\n%s\t</cim:ExcPIC>".format (id, export_fields)
    }
}

object ExcPIC
extends
    Parseable[ExcPIC]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "efdmax",
        "efdmin",
        "ka",
        "kc",
        "ke",
        "kf",
        "ki",
        "kp",
        "se1",
        "se2",
        "ta1",
        "ta2",
        "ta3",
        "ta4",
        "te",
        "tf1",
        "tf2",
        "vr1",
        "vr2",
        "vrmax",
        "vrmin"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val efdmax: Fielder = parse_element (element (cls, fields(2)))
    val efdmin: Fielder = parse_element (element (cls, fields(3)))
    val ka: Fielder = parse_element (element (cls, fields(4)))
    val kc: Fielder = parse_element (element (cls, fields(5)))
    val ke: Fielder = parse_element (element (cls, fields(6)))
    val kf: Fielder = parse_element (element (cls, fields(7)))
    val ki: Fielder = parse_element (element (cls, fields(8)))
    val kp: Fielder = parse_element (element (cls, fields(9)))
    val se1: Fielder = parse_element (element (cls, fields(10)))
    val se2: Fielder = parse_element (element (cls, fields(11)))
    val ta1: Fielder = parse_element (element (cls, fields(12)))
    val ta2: Fielder = parse_element (element (cls, fields(13)))
    val ta3: Fielder = parse_element (element (cls, fields(14)))
    val ta4: Fielder = parse_element (element (cls, fields(15)))
    val te: Fielder = parse_element (element (cls, fields(16)))
    val tf1: Fielder = parse_element (element (cls, fields(17)))
    val tf2: Fielder = parse_element (element (cls, fields(18)))
    val vr1: Fielder = parse_element (element (cls, fields(19)))
    val vr2: Fielder = parse_element (element (cls, fields(20)))
    val vrmax: Fielder = parse_element (element (cls, fields(21)))
    val vrmin: Fielder = parse_element (element (cls, fields(22)))

    def parse (context: Context): ExcPIC =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcPIC (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            toDouble (mask (efdmax (), 2)),
            toDouble (mask (efdmin (), 3)),
            toDouble (mask (ka (), 4)),
            toDouble (mask (kc (), 5)),
            toDouble (mask (ke (), 6)),
            toDouble (mask (kf (), 7)),
            toDouble (mask (ki (), 8)),
            toDouble (mask (kp (), 9)),
            toDouble (mask (se1 (), 10)),
            toDouble (mask (se2 (), 11)),
            toDouble (mask (ta1 (), 12)),
            toDouble (mask (ta2 (), 13)),
            toDouble (mask (ta3 (), 14)),
            toDouble (mask (ta4 (), 15)),
            toDouble (mask (te (), 16)),
            toDouble (mask (tf1 (), 17)),
            toDouble (mask (tf2 (), 18)),
            toDouble (mask (vr1 (), 19)),
            toDouble (mask (vr2 (), 20)),
            toDouble (mask (vrmax (), 21)),
            toDouble (mask (vrmin (), 22))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General Purpose Rotating Excitation System Model.
 *
 * This model can be used to represent a wide range of excitation systems whose DC power source is an AC or DC generator. It encompasses IEEE type AC1, AC2, DC1, and DC2 excitation system models.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcREXS
(
    override val sup: ExcitationSystemDynamics,
    e1: Double,
    e2: Double,
    fbf: String,
    flimf: Double,
    kc: Double,
    kd: Double,
    ke: Double,
    kefd: Double,
    kf: Double,
    kh: Double,
    kii: Double,
    kip: Double,
    ks: Double,
    kvi: Double,
    kvp: Double,
    kvphz: Double,
    nvphz: Double,
    se1: Double,
    se2: Double,
    ta: Double,
    tb1: Double,
    tb2: Double,
    tc1: Double,
    tc2: Double,
    te: Double,
    tf: Double,
    tf1: Double,
    tf2: Double,
    tp: Double,
    vcmax: Double,
    vfmax: Double,
    vfmin: Double,
    vimax: Double,
    vrmax: Double,
    vrmin: Double,
    xc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcREXS] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcREXS.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcREXS.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcREXS.fields (position), value)
        emitelem (0, e1)
        emitelem (1, e2)
        emitattr (2, fbf)
        emitelem (3, flimf)
        emitelem (4, kc)
        emitelem (5, kd)
        emitelem (6, ke)
        emitelem (7, kefd)
        emitelem (8, kf)
        emitelem (9, kh)
        emitelem (10, kii)
        emitelem (11, kip)
        emitelem (12, ks)
        emitelem (13, kvi)
        emitelem (14, kvp)
        emitelem (15, kvphz)
        emitelem (16, nvphz)
        emitelem (17, se1)
        emitelem (18, se2)
        emitelem (19, ta)
        emitelem (20, tb1)
        emitelem (21, tb2)
        emitelem (22, tc1)
        emitelem (23, tc2)
        emitelem (24, te)
        emitelem (25, tf)
        emitelem (26, tf1)
        emitelem (27, tf2)
        emitelem (28, tp)
        emitelem (29, vcmax)
        emitelem (30, vfmax)
        emitelem (31, vfmin)
        emitelem (32, vimax)
        emitelem (33, vrmax)
        emitelem (34, vrmin)
        emitelem (35, xc)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcREXS rdf:ID=\"%s\">\n%s\t</cim:ExcREXS>".format (id, export_fields)
    }
}

object ExcREXS
extends
    Parseable[ExcREXS]
{
    override val fields: Array[String] = Array[String] (
        "e1",
        "e2",
        "fbf",
        "flimf",
        "kc",
        "kd",
        "ke",
        "kefd",
        "kf",
        "kh",
        "kii",
        "kip",
        "ks",
        "kvi",
        "kvp",
        "kvphz",
        "nvphz",
        "se1",
        "se2",
        "ta",
        "tb1",
        "tb2",
        "tc1",
        "tc2",
        "te",
        "tf",
        "tf1",
        "tf2",
        "tp",
        "vcmax",
        "vfmax",
        "vfmin",
        "vimax",
        "vrmax",
        "vrmin",
        "xc"
    )
    val e1: Fielder = parse_element (element (cls, fields(0)))
    val e2: Fielder = parse_element (element (cls, fields(1)))
    val fbf: Fielder = parse_attribute (attribute (cls, fields(2)))
    val flimf: Fielder = parse_element (element (cls, fields(3)))
    val kc: Fielder = parse_element (element (cls, fields(4)))
    val kd: Fielder = parse_element (element (cls, fields(5)))
    val ke: Fielder = parse_element (element (cls, fields(6)))
    val kefd: Fielder = parse_element (element (cls, fields(7)))
    val kf: Fielder = parse_element (element (cls, fields(8)))
    val kh: Fielder = parse_element (element (cls, fields(9)))
    val kii: Fielder = parse_element (element (cls, fields(10)))
    val kip: Fielder = parse_element (element (cls, fields(11)))
    val ks: Fielder = parse_element (element (cls, fields(12)))
    val kvi: Fielder = parse_element (element (cls, fields(13)))
    val kvp: Fielder = parse_element (element (cls, fields(14)))
    val kvphz: Fielder = parse_element (element (cls, fields(15)))
    val nvphz: Fielder = parse_element (element (cls, fields(16)))
    val se1: Fielder = parse_element (element (cls, fields(17)))
    val se2: Fielder = parse_element (element (cls, fields(18)))
    val ta: Fielder = parse_element (element (cls, fields(19)))
    val tb1: Fielder = parse_element (element (cls, fields(20)))
    val tb2: Fielder = parse_element (element (cls, fields(21)))
    val tc1: Fielder = parse_element (element (cls, fields(22)))
    val tc2: Fielder = parse_element (element (cls, fields(23)))
    val te: Fielder = parse_element (element (cls, fields(24)))
    val tf: Fielder = parse_element (element (cls, fields(25)))
    val tf1: Fielder = parse_element (element (cls, fields(26)))
    val tf2: Fielder = parse_element (element (cls, fields(27)))
    val tp: Fielder = parse_element (element (cls, fields(28)))
    val vcmax: Fielder = parse_element (element (cls, fields(29)))
    val vfmax: Fielder = parse_element (element (cls, fields(30)))
    val vfmin: Fielder = parse_element (element (cls, fields(31)))
    val vimax: Fielder = parse_element (element (cls, fields(32)))
    val vrmax: Fielder = parse_element (element (cls, fields(33)))
    val vrmin: Fielder = parse_element (element (cls, fields(34)))
    val xc: Fielder = parse_element (element (cls, fields(35)))

    def parse (context: Context): ExcREXS =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0)
        val ret = ExcREXS (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (e1 (), 0)),
            toDouble (mask (e2 (), 1)),
            mask (fbf (), 2),
            toDouble (mask (flimf (), 3)),
            toDouble (mask (kc (), 4)),
            toDouble (mask (kd (), 5)),
            toDouble (mask (ke (), 6)),
            toDouble (mask (kefd (), 7)),
            toDouble (mask (kf (), 8)),
            toDouble (mask (kh (), 9)),
            toDouble (mask (kii (), 10)),
            toDouble (mask (kip (), 11)),
            toDouble (mask (ks (), 12)),
            toDouble (mask (kvi (), 13)),
            toDouble (mask (kvp (), 14)),
            toDouble (mask (kvphz (), 15)),
            toDouble (mask (nvphz (), 16)),
            toDouble (mask (se1 (), 17)),
            toDouble (mask (se2 (), 18)),
            toDouble (mask (ta (), 19)),
            toDouble (mask (tb1 (), 20)),
            toDouble (mask (tb2 (), 21)),
            toDouble (mask (tc1 (), 22)),
            toDouble (mask (tc2 (), 23)),
            toDouble (mask (te (), 24)),
            toDouble (mask (tf (), 25)),
            toDouble (mask (tf1 (), 26)),
            toDouble (mask (tf2 (), 27)),
            toDouble (mask (tp (), 28)),
            toDouble (mask (vcmax (), 29)),
            toDouble (mask (vfmax (), 30)),
            toDouble (mask (vfmin (), 31)),
            toDouble (mask (vimax (), 32)),
            toDouble (mask (vrmax (), 33)),
            toDouble (mask (vrmin (), 34)),
            toDouble (mask (xc (), 35))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simple excitation system model representing generic characteristics of many excitation systems; intended for use where negative field current may be a problem.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param cswitch Power source switch (Cswitch).
 *        true = fixed voltage of 1.0 PU
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcSCRX
(
    override val sup: ExcitationSystemDynamics,
    cswitch: Boolean,
    emax: Double,
    emin: Double,
    k: Double,
    rcrfd: Double,
    tatb: Double,
    tb: Double,
    te: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcSCRX] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcSCRX.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcSCRX.fields (position), value)
        emitelem (0, cswitch)
        emitelem (1, emax)
        emitelem (2, emin)
        emitelem (3, k)
        emitelem (4, rcrfd)
        emitelem (5, tatb)
        emitelem (6, tb)
        emitelem (7, te)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcSCRX rdf:ID=\"%s\">\n%s\t</cim:ExcSCRX>".format (id, export_fields)
    }
}

object ExcSCRX
extends
    Parseable[ExcSCRX]
{
    override val fields: Array[String] = Array[String] (
        "cswitch",
        "emax",
        "emin",
        "k",
        "rcrfd",
        "tatb",
        "tb",
        "te"
    )
    val cswitch: Fielder = parse_element (element (cls, fields(0)))
    val emax: Fielder = parse_element (element (cls, fields(1)))
    val emin: Fielder = parse_element (element (cls, fields(2)))
    val k: Fielder = parse_element (element (cls, fields(3)))
    val rcrfd: Fielder = parse_element (element (cls, fields(4)))
    val tatb: Fielder = parse_element (element (cls, fields(5)))
    val tb: Fielder = parse_element (element (cls, fields(6)))
    val te: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): ExcSCRX =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcSCRX (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (cswitch (), 0)),
            toDouble (mask (emax (), 1)),
            toDouble (mask (emin (), 2)),
            toDouble (mask (k (), 3)),
            toDouble (mask (rcrfd (), 4)),
            toDouble (mask (tatb (), 5)),
            toDouble (mask (tb (), 6)),
            toDouble (mask (te (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified Excitation System Model.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcSEXS
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    efdmin: Double,
    emax: Double,
    emin: Double,
    k: Double,
    kc: Double,
    tatb: Double,
    tb: Double,
    tc: Double,
    te: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcSEXS] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcSEXS.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcSEXS.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, efdmin)
        emitelem (2, emax)
        emitelem (3, emin)
        emitelem (4, k)
        emitelem (5, kc)
        emitelem (6, tatb)
        emitelem (7, tb)
        emitelem (8, tc)
        emitelem (9, te)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcSEXS rdf:ID=\"%s\">\n%s\t</cim:ExcSEXS>".format (id, export_fields)
    }
}

object ExcSEXS
extends
    Parseable[ExcSEXS]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "efdmin",
        "emax",
        "emin",
        "k",
        "kc",
        "tatb",
        "tb",
        "tc",
        "te"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val efdmin: Fielder = parse_element (element (cls, fields(1)))
    val emax: Fielder = parse_element (element (cls, fields(2)))
    val emin: Fielder = parse_element (element (cls, fields(3)))
    val k: Fielder = parse_element (element (cls, fields(4)))
    val kc: Fielder = parse_element (element (cls, fields(5)))
    val tatb: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val tc: Fielder = parse_element (element (cls, fields(8)))
    val te: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): ExcSEXS =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcSEXS (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (efdmin (), 1)),
            toDouble (mask (emax (), 2)),
            toDouble (mask (emin (), 3)),
            toDouble (mask (k (), 4)),
            toDouble (mask (kc (), 5)),
            toDouble (mask (tatb (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (tc (), 8)),
            toDouble (mask (te (), 9))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Slovakian Excitation System Model.
 *
 * UEL and secondary voltage control are included in this model. When this model is used, there cannot be a separate underexcitation limiter or VAr controller model.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = secondary voltage control is ON
 *        false = secondary voltage control is OFF.
 *        Typical Value = false.
 * @param qz Desired value (setpoint) of reactive power, manual setting (Qz).
 * @param remote Selector to apply automatic calculation in secondary controller model.
 *        true = automatic calculation is activated
 *        false = manual set is active; the use of desired value of reactive power (Qz) is required.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcSK
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    efdmin: Double,
    emax: Double,
    emin: Double,
    k: Double,
    k1: Double,
    k2: Double,
    kc: Double,
    kce: Double,
    kd: Double,
    kgob: Double,
    kp: Double,
    kqi: Double,
    kqob: Double,
    kqp: Double,
    nq: Double,
    qconoff: Boolean,
    qz: Double,
    remote: Boolean,
    sbase: Double,
    tc: Double,
    te: Double,
    ti: Double,
    tp: Double,
    tr: Double,
    uimax: Double,
    uimin: Double,
    urmax: Double,
    urmin: Double,
    vtmax: Double,
    vtmin: Double,
    yp: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcSK] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcSK.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcSK.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, efdmin)
        emitelem (2, emax)
        emitelem (3, emin)
        emitelem (4, k)
        emitelem (5, k1)
        emitelem (6, k2)
        emitelem (7, kc)
        emitelem (8, kce)
        emitelem (9, kd)
        emitelem (10, kgob)
        emitelem (11, kp)
        emitelem (12, kqi)
        emitelem (13, kqob)
        emitelem (14, kqp)
        emitelem (15, nq)
        emitelem (16, qconoff)
        emitelem (17, qz)
        emitelem (18, remote)
        emitelem (19, sbase)
        emitelem (20, tc)
        emitelem (21, te)
        emitelem (22, ti)
        emitelem (23, tp)
        emitelem (24, tr)
        emitelem (25, uimax)
        emitelem (26, uimin)
        emitelem (27, urmax)
        emitelem (28, urmin)
        emitelem (29, vtmax)
        emitelem (30, vtmin)
        emitelem (31, yp)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcSK rdf:ID=\"%s\">\n%s\t</cim:ExcSK>".format (id, export_fields)
    }
}

object ExcSK
extends
    Parseable[ExcSK]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "efdmin",
        "emax",
        "emin",
        "k",
        "k1",
        "k2",
        "kc",
        "kce",
        "kd",
        "kgob",
        "kp",
        "kqi",
        "kqob",
        "kqp",
        "nq",
        "qconoff",
        "qz",
        "remote",
        "sbase",
        "tc",
        "te",
        "ti",
        "tp",
        "tr",
        "uimax",
        "uimin",
        "urmax",
        "urmin",
        "vtmax",
        "vtmin",
        "yp"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val efdmin: Fielder = parse_element (element (cls, fields(1)))
    val emax: Fielder = parse_element (element (cls, fields(2)))
    val emin: Fielder = parse_element (element (cls, fields(3)))
    val k: Fielder = parse_element (element (cls, fields(4)))
    val k1: Fielder = parse_element (element (cls, fields(5)))
    val k2: Fielder = parse_element (element (cls, fields(6)))
    val kc: Fielder = parse_element (element (cls, fields(7)))
    val kce: Fielder = parse_element (element (cls, fields(8)))
    val kd: Fielder = parse_element (element (cls, fields(9)))
    val kgob: Fielder = parse_element (element (cls, fields(10)))
    val kp: Fielder = parse_element (element (cls, fields(11)))
    val kqi: Fielder = parse_element (element (cls, fields(12)))
    val kqob: Fielder = parse_element (element (cls, fields(13)))
    val kqp: Fielder = parse_element (element (cls, fields(14)))
    val nq: Fielder = parse_element (element (cls, fields(15)))
    val qconoff: Fielder = parse_element (element (cls, fields(16)))
    val qz: Fielder = parse_element (element (cls, fields(17)))
    val remote: Fielder = parse_element (element (cls, fields(18)))
    val sbase: Fielder = parse_element (element (cls, fields(19)))
    val tc: Fielder = parse_element (element (cls, fields(20)))
    val te: Fielder = parse_element (element (cls, fields(21)))
    val ti: Fielder = parse_element (element (cls, fields(22)))
    val tp: Fielder = parse_element (element (cls, fields(23)))
    val tr: Fielder = parse_element (element (cls, fields(24)))
    val uimax: Fielder = parse_element (element (cls, fields(25)))
    val uimin: Fielder = parse_element (element (cls, fields(26)))
    val urmax: Fielder = parse_element (element (cls, fields(27)))
    val urmin: Fielder = parse_element (element (cls, fields(28)))
    val vtmax: Fielder = parse_element (element (cls, fields(29)))
    val vtmin: Fielder = parse_element (element (cls, fields(30)))
    val yp: Fielder = parse_element (element (cls, fields(31)))

    def parse (context: Context): ExcSK =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0)
        val ret = ExcSK (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (efdmin (), 1)),
            toDouble (mask (emax (), 2)),
            toDouble (mask (emin (), 3)),
            toDouble (mask (k (), 4)),
            toDouble (mask (k1 (), 5)),
            toDouble (mask (k2 (), 6)),
            toDouble (mask (kc (), 7)),
            toDouble (mask (kce (), 8)),
            toDouble (mask (kd (), 9)),
            toDouble (mask (kgob (), 10)),
            toDouble (mask (kp (), 11)),
            toDouble (mask (kqi (), 12)),
            toDouble (mask (kqob (), 13)),
            toDouble (mask (kqp (), 14)),
            toDouble (mask (nq (), 15)),
            toBoolean (mask (qconoff (), 16)),
            toDouble (mask (qz (), 17)),
            toBoolean (mask (remote (), 18)),
            toDouble (mask (sbase (), 19)),
            toDouble (mask (tc (), 20)),
            toDouble (mask (te (), 21)),
            toDouble (mask (ti (), 22)),
            toDouble (mask (tp (), 23)),
            toDouble (mask (tr (), 24)),
            toDouble (mask (uimax (), 25)),
            toDouble (mask (uimin (), 26)),
            toDouble (mask (urmax (), 27)),
            toDouble (mask (urmin (), 28)),
            toDouble (mask (vtmax (), 29)),
            toDouble (mask (vtmin (), 30)),
            toDouble (mask (yp (), 31))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modification of an old IEEE ST1A static excitation system without overexcitation limiter (OEL) and underexcitation limiter (UEL).
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST1A
(
    override val sup: ExcitationSystemDynamics,
    ilr: Double,
    ka: Double,
    kc: Double,
    kf: Double,
    klr: Double,
    ta: Double,
    tb: Double,
    tb1: Double,
    tc: Double,
    tc1: Double,
    tf: Double,
    vamax: Double,
    vamin: Double,
    vimax: Double,
    vimin: Double,
    vrmax: Double,
    vrmin: Double,
    xe: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST1A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST1A.fields (position), value)
        emitelem (0, ilr)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, kf)
        emitelem (4, klr)
        emitelem (5, ta)
        emitelem (6, tb)
        emitelem (7, tb1)
        emitelem (8, tc)
        emitelem (9, tc1)
        emitelem (10, tf)
        emitelem (11, vamax)
        emitelem (12, vamin)
        emitelem (13, vimax)
        emitelem (14, vimin)
        emitelem (15, vrmax)
        emitelem (16, vrmin)
        emitelem (17, xe)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST1A rdf:ID=\"%s\">\n%s\t</cim:ExcST1A>".format (id, export_fields)
    }
}

object ExcST1A
extends
    Parseable[ExcST1A]
{
    override val fields: Array[String] = Array[String] (
        "ilr",
        "ka",
        "kc",
        "kf",
        "klr",
        "ta",
        "tb",
        "tb1",
        "tc",
        "tc1",
        "tf",
        "vamax",
        "vamin",
        "vimax",
        "vimin",
        "vrmax",
        "vrmin",
        "xe"
    )
    val ilr: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val kf: Fielder = parse_element (element (cls, fields(3)))
    val klr: Fielder = parse_element (element (cls, fields(4)))
    val ta: Fielder = parse_element (element (cls, fields(5)))
    val tb: Fielder = parse_element (element (cls, fields(6)))
    val tb1: Fielder = parse_element (element (cls, fields(7)))
    val tc: Fielder = parse_element (element (cls, fields(8)))
    val tc1: Fielder = parse_element (element (cls, fields(9)))
    val tf: Fielder = parse_element (element (cls, fields(10)))
    val vamax: Fielder = parse_element (element (cls, fields(11)))
    val vamin: Fielder = parse_element (element (cls, fields(12)))
    val vimax: Fielder = parse_element (element (cls, fields(13)))
    val vimin: Fielder = parse_element (element (cls, fields(14)))
    val vrmax: Fielder = parse_element (element (cls, fields(15)))
    val vrmin: Fielder = parse_element (element (cls, fields(16)))
    val xe: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): ExcST1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ilr (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (klr (), 4)),
            toDouble (mask (ta (), 5)),
            toDouble (mask (tb (), 6)),
            toDouble (mask (tb1 (), 7)),
            toDouble (mask (tc (), 8)),
            toDouble (mask (tc1 (), 9)),
            toDouble (mask (tf (), 10)),
            toDouble (mask (vamax (), 11)),
            toDouble (mask (vamin (), 12)),
            toDouble (mask (vimax (), 13)),
            toDouble (mask (vimin (), 14)),
            toDouble (mask (vrmax (), 15)),
            toDouble (mask (vrmin (), 16)),
            toDouble (mask (xe (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE ST2A static excitation system - another lead-lag block added to match  the model defined by WECC.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = HV gate
 *        false = add to error signal.
 *        Typical Value = false.
 * @param vrmax Maximum voltage regulator outputs (Vrmax).
 *        Typical Value = 1.
 * @param vrmin Minimum voltage regulator outputs (Vrmin).
 *        Typical Value = -1.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST2A
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    ka: Double,
    kc: Double,
    ke: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    te: Double,
    tf: Double,
    uelin: Boolean,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST2A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST2A.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, ka)
        emitelem (2, kc)
        emitelem (3, ke)
        emitelem (4, kf)
        emitelem (5, ki)
        emitelem (6, kp)
        emitelem (7, ta)
        emitelem (8, tb)
        emitelem (9, tc)
        emitelem (10, te)
        emitelem (11, tf)
        emitelem (12, uelin)
        emitelem (13, vrmax)
        emitelem (14, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST2A rdf:ID=\"%s\">\n%s\t</cim:ExcST2A>".format (id, export_fields)
    }
}

object ExcST2A
extends
    Parseable[ExcST2A]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "ka",
        "kc",
        "ke",
        "kf",
        "ki",
        "kp",
        "ta",
        "tb",
        "tc",
        "te",
        "tf",
        "uelin",
        "vrmax",
        "vrmin"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kc: Fielder = parse_element (element (cls, fields(2)))
    val ke: Fielder = parse_element (element (cls, fields(3)))
    val kf: Fielder = parse_element (element (cls, fields(4)))
    val ki: Fielder = parse_element (element (cls, fields(5)))
    val kp: Fielder = parse_element (element (cls, fields(6)))
    val ta: Fielder = parse_element (element (cls, fields(7)))
    val tb: Fielder = parse_element (element (cls, fields(8)))
    val tc: Fielder = parse_element (element (cls, fields(9)))
    val te: Fielder = parse_element (element (cls, fields(10)))
    val tf: Fielder = parse_element (element (cls, fields(11)))
    val uelin: Fielder = parse_element (element (cls, fields(12)))
    val vrmax: Fielder = parse_element (element (cls, fields(13)))
    val vrmin: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): ExcST2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST2A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kc (), 2)),
            toDouble (mask (ke (), 3)),
            toDouble (mask (kf (), 4)),
            toDouble (mask (ki (), 5)),
            toDouble (mask (kp (), 6)),
            toDouble (mask (ta (), 7)),
            toDouble (mask (tb (), 8)),
            toDouble (mask (tc (), 9)),
            toDouble (mask (te (), 10)),
            toDouble (mask (tf (), 11)),
            toBoolean (mask (uelin (), 12)),
            toDouble (mask (vrmax (), 13)),
            toDouble (mask (vrmin (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE ST3A static excitation system with added speed multiplier.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST3A
(
    override val sup: ExcitationSystemDynamics,
    efdmax: Double,
    kc: Double,
    kg: Double,
    ki: Double,
    kj: Double,
    km: Double,
    kp: Double,
    ks: Double,
    ks1: Double,
    tb: Double,
    tc: Double,
    thetap: Double,
    tm: Double,
    vbmax: Double,
    vgmax: Double,
    vimax: Double,
    vimin: Double,
    vrmax: Double,
    vrmin: Double,
    xl: Double
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
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST3A] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST3A.fields (position), value)
        emitelem (0, efdmax)
        emitelem (1, kc)
        emitelem (2, kg)
        emitelem (3, ki)
        emitelem (4, kj)
        emitelem (5, km)
        emitelem (6, kp)
        emitelem (7, ks)
        emitelem (8, ks1)
        emitelem (9, tb)
        emitelem (10, tc)
        emitelem (11, thetap)
        emitelem (12, tm)
        emitelem (13, vbmax)
        emitelem (14, vgmax)
        emitelem (15, vimax)
        emitelem (16, vimin)
        emitelem (17, vrmax)
        emitelem (18, vrmin)
        emitelem (19, xl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST3A rdf:ID=\"%s\">\n%s\t</cim:ExcST3A>".format (id, export_fields)
    }
}

object ExcST3A
extends
    Parseable[ExcST3A]
{
    override val fields: Array[String] = Array[String] (
        "efdmax",
        "kc",
        "kg",
        "ki",
        "kj",
        "km",
        "kp",
        "ks",
        "ks1",
        "tb",
        "tc",
        "thetap",
        "tm",
        "vbmax",
        "vgmax",
        "vimax",
        "vimin",
        "vrmax",
        "vrmin",
        "xl"
    )
    val efdmax: Fielder = parse_element (element (cls, fields(0)))
    val kc: Fielder = parse_element (element (cls, fields(1)))
    val kg: Fielder = parse_element (element (cls, fields(2)))
    val ki: Fielder = parse_element (element (cls, fields(3)))
    val kj: Fielder = parse_element (element (cls, fields(4)))
    val km: Fielder = parse_element (element (cls, fields(5)))
    val kp: Fielder = parse_element (element (cls, fields(6)))
    val ks: Fielder = parse_element (element (cls, fields(7)))
    val ks1: Fielder = parse_element (element (cls, fields(8)))
    val tb: Fielder = parse_element (element (cls, fields(9)))
    val tc: Fielder = parse_element (element (cls, fields(10)))
    val thetap: Fielder = parse_element (element (cls, fields(11)))
    val tm: Fielder = parse_element (element (cls, fields(12)))
    val vbmax: Fielder = parse_element (element (cls, fields(13)))
    val vgmax: Fielder = parse_element (element (cls, fields(14)))
    val vimax: Fielder = parse_element (element (cls, fields(15)))
    val vimin: Fielder = parse_element (element (cls, fields(16)))
    val vrmax: Fielder = parse_element (element (cls, fields(17)))
    val vrmin: Fielder = parse_element (element (cls, fields(18)))
    val xl: Fielder = parse_element (element (cls, fields(19)))

    def parse (context: Context): ExcST3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efdmax (), 0)),
            toDouble (mask (kc (), 1)),
            toDouble (mask (kg (), 2)),
            toDouble (mask (ki (), 3)),
            toDouble (mask (kj (), 4)),
            toDouble (mask (km (), 5)),
            toDouble (mask (kp (), 6)),
            toDouble (mask (ks (), 7)),
            toDouble (mask (ks1 (), 8)),
            toDouble (mask (tb (), 9)),
            toDouble (mask (tc (), 10)),
            toDouble (mask (thetap (), 11)),
            toDouble (mask (tm (), 12)),
            toDouble (mask (vbmax (), 13)),
            toDouble (mask (vgmax (), 14)),
            toDouble (mask (vimax (), 15)),
            toDouble (mask (vimin (), 16)),
            toDouble (mask (vrmax (), 17)),
            toDouble (mask (vrmin (), 18)),
            toDouble (mask (xl (), 19))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE ST4B static excitation system with maximum inner loop feedback gain <b>Vgmax</b>.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 *        true = LVgate is part of the block diagram
 *        false = LVgate is not part of the block diagram.
 *        Typical Value = false.
 * @param ta Voltage regulator time constant (Ta).
 *        Typical Value = 0.02.
 * @param thetap Potential circuit phase angle (thetap).
 *        Typical Value = 0.
 * @param uel Selector (Uel).
 *        true = UEL is part of block diagram
 *        false = UEL is not part of block diagram.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST4B
(
    override val sup: ExcitationSystemDynamics,
    kc: Double,
    kg: Double,
    ki: Double,
    kim: Double,
    kir: Double,
    kp: Double,
    kpm: Double,
    kpr: Double,
    lvgate: Boolean,
    ta: Double,
    thetap: Double,
    uel: Boolean,
    vbmax: Double,
    vgmax: Double,
    vmmax: Double,
    vmmin: Double,
    vrmax: Double,
    vrmin: Double,
    xl: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST4B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST4B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST4B.fields (position), value)
        emitelem (0, kc)
        emitelem (1, kg)
        emitelem (2, ki)
        emitelem (3, kim)
        emitelem (4, kir)
        emitelem (5, kp)
        emitelem (6, kpm)
        emitelem (7, kpr)
        emitelem (8, lvgate)
        emitelem (9, ta)
        emitelem (10, thetap)
        emitelem (11, uel)
        emitelem (12, vbmax)
        emitelem (13, vgmax)
        emitelem (14, vmmax)
        emitelem (15, vmmin)
        emitelem (16, vrmax)
        emitelem (17, vrmin)
        emitelem (18, xl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST4B rdf:ID=\"%s\">\n%s\t</cim:ExcST4B>".format (id, export_fields)
    }
}

object ExcST4B
extends
    Parseable[ExcST4B]
{
    override val fields: Array[String] = Array[String] (
        "kc",
        "kg",
        "ki",
        "kim",
        "kir",
        "kp",
        "kpm",
        "kpr",
        "lvgate",
        "ta",
        "thetap",
        "uel",
        "vbmax",
        "vgmax",
        "vmmax",
        "vmmin",
        "vrmax",
        "vrmin",
        "xl"
    )
    val kc: Fielder = parse_element (element (cls, fields(0)))
    val kg: Fielder = parse_element (element (cls, fields(1)))
    val ki: Fielder = parse_element (element (cls, fields(2)))
    val kim: Fielder = parse_element (element (cls, fields(3)))
    val kir: Fielder = parse_element (element (cls, fields(4)))
    val kp: Fielder = parse_element (element (cls, fields(5)))
    val kpm: Fielder = parse_element (element (cls, fields(6)))
    val kpr: Fielder = parse_element (element (cls, fields(7)))
    val lvgate: Fielder = parse_element (element (cls, fields(8)))
    val ta: Fielder = parse_element (element (cls, fields(9)))
    val thetap: Fielder = parse_element (element (cls, fields(10)))
    val uel: Fielder = parse_element (element (cls, fields(11)))
    val vbmax: Fielder = parse_element (element (cls, fields(12)))
    val vgmax: Fielder = parse_element (element (cls, fields(13)))
    val vmmax: Fielder = parse_element (element (cls, fields(14)))
    val vmmin: Fielder = parse_element (element (cls, fields(15)))
    val vrmax: Fielder = parse_element (element (cls, fields(16)))
    val vrmin: Fielder = parse_element (element (cls, fields(17)))
    val xl: Fielder = parse_element (element (cls, fields(18)))

    def parse (context: Context): ExcST4B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST4B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kc (), 0)),
            toDouble (mask (kg (), 1)),
            toDouble (mask (ki (), 2)),
            toDouble (mask (kim (), 3)),
            toDouble (mask (kir (), 4)),
            toDouble (mask (kp (), 5)),
            toDouble (mask (kpm (), 6)),
            toDouble (mask (kpr (), 7)),
            toBoolean (mask (lvgate (), 8)),
            toDouble (mask (ta (), 9)),
            toDouble (mask (thetap (), 10)),
            toBoolean (mask (uel (), 11)),
            toDouble (mask (vbmax (), 12)),
            toDouble (mask (vgmax (), 13)),
            toDouble (mask (vmmax (), 14)),
            toDouble (mask (vmmin (), 15)),
            toDouble (mask (vrmax (), 16)),
            toDouble (mask (vrmin (), 17)),
            toDouble (mask (xl (), 18))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE ST6B static excitation system with PID controller and optional inner feedbacks loop.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ilr Exciter output current limit reference (Ilr).
 *        Typical Value = 4.164.
 * @param k1 Selector (K1).
 *        true = feedback is from Ifd
 *        false = feedback is not from Ifd.
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
 *        true = Vimin-Vimax limiter is active
 *        false = Vimin-Vimax limiter is not active.
 *        Typical Value = true.
 * @param vimax Maximum voltage regulator input limit (Vimax).
 *        Typical Value = 10.
 * @param vimin Minimum voltage regulator input limit (Vimin).
 *        Typical Value = -10.
 * @param vmult Selector (Vmult).
 *        true = multiply regulator output by terminal voltage
 *        false = do not multiply regulator output by terminal voltage.
 *        Typical Value = true.
 * @param vrmax Maximum voltage regulator output (Vrmax).
 *        Typical Value = 4.81.
 * @param vrmin Minimum voltage regulator output (Vrmin).
 *        Typical Value = -3.85.
 * @param xc Excitation source reactance (Xc).
 *        Typical Value = 0.05.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST6B
(
    override val sup: ExcitationSystemDynamics,
    ilr: Double,
    k1: Boolean,
    kcl: Double,
    kff: Double,
    kg: Double,
    kia: Double,
    klr: Double,
    km: Double,
    kpa: Double,
    kvd: Double,
    oelin: String,
    tg: Double,
    ts: Double,
    tvd: Double,
    vamax: Double,
    vamin: Double,
    vilim: Boolean,
    vimax: Double,
    vimin: Double,
    vmult: Boolean,
    vrmax: Double,
    vrmin: Double,
    xc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST6B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST6B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST6B.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcST6B.fields (position), value)
        emitelem (0, ilr)
        emitelem (1, k1)
        emitelem (2, kcl)
        emitelem (3, kff)
        emitelem (4, kg)
        emitelem (5, kia)
        emitelem (6, klr)
        emitelem (7, km)
        emitelem (8, kpa)
        emitelem (9, kvd)
        emitattr (10, oelin)
        emitelem (11, tg)
        emitelem (12, ts)
        emitelem (13, tvd)
        emitelem (14, vamax)
        emitelem (15, vamin)
        emitelem (16, vilim)
        emitelem (17, vimax)
        emitelem (18, vimin)
        emitelem (19, vmult)
        emitelem (20, vrmax)
        emitelem (21, vrmin)
        emitelem (22, xc)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST6B rdf:ID=\"%s\">\n%s\t</cim:ExcST6B>".format (id, export_fields)
    }
}

object ExcST6B
extends
    Parseable[ExcST6B]
{
    override val fields: Array[String] = Array[String] (
        "ilr",
        "k1",
        "kcl",
        "kff",
        "kg",
        "kia",
        "klr",
        "km",
        "kpa",
        "kvd",
        "oelin",
        "tg",
        "ts",
        "tvd",
        "vamax",
        "vamin",
        "vilim",
        "vimax",
        "vimin",
        "vmult",
        "vrmax",
        "vrmin",
        "xc"
    )
    val ilr: Fielder = parse_element (element (cls, fields(0)))
    val k1: Fielder = parse_element (element (cls, fields(1)))
    val kcl: Fielder = parse_element (element (cls, fields(2)))
    val kff: Fielder = parse_element (element (cls, fields(3)))
    val kg: Fielder = parse_element (element (cls, fields(4)))
    val kia: Fielder = parse_element (element (cls, fields(5)))
    val klr: Fielder = parse_element (element (cls, fields(6)))
    val km: Fielder = parse_element (element (cls, fields(7)))
    val kpa: Fielder = parse_element (element (cls, fields(8)))
    val kvd: Fielder = parse_element (element (cls, fields(9)))
    val oelin: Fielder = parse_attribute (attribute (cls, fields(10)))
    val tg: Fielder = parse_element (element (cls, fields(11)))
    val ts: Fielder = parse_element (element (cls, fields(12)))
    val tvd: Fielder = parse_element (element (cls, fields(13)))
    val vamax: Fielder = parse_element (element (cls, fields(14)))
    val vamin: Fielder = parse_element (element (cls, fields(15)))
    val vilim: Fielder = parse_element (element (cls, fields(16)))
    val vimax: Fielder = parse_element (element (cls, fields(17)))
    val vimin: Fielder = parse_element (element (cls, fields(18)))
    val vmult: Fielder = parse_element (element (cls, fields(19)))
    val vrmax: Fielder = parse_element (element (cls, fields(20)))
    val vrmin: Fielder = parse_element (element (cls, fields(21)))
    val xc: Fielder = parse_element (element (cls, fields(22)))

    def parse (context: Context): ExcST6B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST6B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ilr (), 0)),
            toBoolean (mask (k1 (), 1)),
            toDouble (mask (kcl (), 2)),
            toDouble (mask (kff (), 3)),
            toDouble (mask (kg (), 4)),
            toDouble (mask (kia (), 5)),
            toDouble (mask (klr (), 6)),
            toDouble (mask (km (), 7)),
            toDouble (mask (kpa (), 8)),
            toDouble (mask (kvd (), 9)),
            mask (oelin (), 10),
            toDouble (mask (tg (), 11)),
            toDouble (mask (ts (), 12)),
            toDouble (mask (tvd (), 13)),
            toDouble (mask (vamax (), 14)),
            toDouble (mask (vamin (), 15)),
            toBoolean (mask (vilim (), 16)),
            toDouble (mask (vimax (), 17)),
            toDouble (mask (vimin (), 18)),
            toBoolean (mask (vmult (), 19)),
            toDouble (mask (vrmax (), 20)),
            toDouble (mask (vrmin (), 21)),
            toDouble (mask (xc (), 22))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE ST7B static excitation system without stator current limiter (SCL) and current compensator (DROOP) inputs.
 *
 * @param sup [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
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
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcST7B
(
    override val sup: ExcitationSystemDynamics,
    kh: Double,
    kia: Double,
    kl: Double,
    kpa: Double,
    oelin: String,
    tb: Double,
    tc: Double,
    tf: Double,
    tg: Double,
    tia: Double,
    ts: Double,
    uelin: String,
    vmax: Double,
    vmin: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { clone ().asInstanceOf[ExcST7B] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcST7B.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcST7B.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcST7B.fields (position), value)
        emitelem (0, kh)
        emitelem (1, kia)
        emitelem (2, kl)
        emitelem (3, kpa)
        emitattr (4, oelin)
        emitelem (5, tb)
        emitelem (6, tc)
        emitelem (7, tf)
        emitelem (8, tg)
        emitelem (9, tia)
        emitelem (10, ts)
        emitattr (11, uelin)
        emitelem (12, vmax)
        emitelem (13, vmin)
        emitelem (14, vrmax)
        emitelem (15, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcST7B rdf:ID=\"%s\">\n%s\t</cim:ExcST7B>".format (id, export_fields)
    }
}

object ExcST7B
extends
    Parseable[ExcST7B]
{
    override val fields: Array[String] = Array[String] (
        "kh",
        "kia",
        "kl",
        "kpa",
        "oelin",
        "tb",
        "tc",
        "tf",
        "tg",
        "tia",
        "ts",
        "uelin",
        "vmax",
        "vmin",
        "vrmax",
        "vrmin"
    )
    val kh: Fielder = parse_element (element (cls, fields(0)))
    val kia: Fielder = parse_element (element (cls, fields(1)))
    val kl: Fielder = parse_element (element (cls, fields(2)))
    val kpa: Fielder = parse_element (element (cls, fields(3)))
    val oelin: Fielder = parse_attribute (attribute (cls, fields(4)))
    val tb: Fielder = parse_element (element (cls, fields(5)))
    val tc: Fielder = parse_element (element (cls, fields(6)))
    val tf: Fielder = parse_element (element (cls, fields(7)))
    val tg: Fielder = parse_element (element (cls, fields(8)))
    val tia: Fielder = parse_element (element (cls, fields(9)))
    val ts: Fielder = parse_element (element (cls, fields(10)))
    val uelin: Fielder = parse_attribute (attribute (cls, fields(11)))
    val vmax: Fielder = parse_element (element (cls, fields(12)))
    val vmin: Fielder = parse_element (element (cls, fields(13)))
    val vrmax: Fielder = parse_element (element (cls, fields(14)))
    val vrmin: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): ExcST7B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcST7B (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (kh (), 0)),
            toDouble (mask (kia (), 1)),
            toDouble (mask (kl (), 2)),
            toDouble (mask (kpa (), 3)),
            mask (oelin (), 4),
            toDouble (mask (tb (), 5)),
            toDouble (mask (tc (), 6)),
            toDouble (mask (tf (), 7)),
            toDouble (mask (tg (), 8)),
            toDouble (mask (tia (), 9)),
            toDouble (mask (ts (), 10)),
            mask (uelin (), 11),
            toDouble (mask (vmax (), 12)),
            toDouble (mask (vmin (), 13)),
            toDouble (mask (vrmax (), 14)),
            toDouble (mask (vrmin (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Excitation system function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Discontinuous excitation control model associated with this excitation system model.
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Overexcitation limiter model associated with this excitation system model.
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Power Factor or VAr controller Type I model associated with this excitation system model.
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Power Factor or VAr controller Type II model associated with this excitation system model.
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Power system stabilizer model associated with this excitation system model.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine model with which this excitation system model is associated.
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Undrexcitation limiter model associated with this excitation system model.
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Voltage compensator model associated with this excitation system model.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (Efd) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 */
case class ExcitationSystemDynamics
(
    override val sup: DynamicsFunctionBlock,
    DiscontinuousExcitationControlDynamics: String,
    OverexcitationLimiterDynamics: String,
    PFVArControllerType1Dynamics: String,
    PFVArControllerType2Dynamics: String,
    PowerSystemStabilizerDynamics: String,
    SynchronousMachineDynamics: String,
    UnderexcitationLimiterDynamics: String,
    VoltageCompensatorDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[ExcitationSystemDynamics] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ExcitationSystemDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ExcitationSystemDynamics.fields (position), value)
        emitattr (0, DiscontinuousExcitationControlDynamics)
        emitattr (1, OverexcitationLimiterDynamics)
        emitattr (2, PFVArControllerType1Dynamics)
        emitattr (3, PFVArControllerType2Dynamics)
        emitattr (4, PowerSystemStabilizerDynamics)
        emitattr (5, SynchronousMachineDynamics)
        emitattr (6, UnderexcitationLimiterDynamics)
        emitattr (7, VoltageCompensatorDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcitationSystemDynamics rdf:ID=\"%s\">\n%s\t</cim:ExcitationSystemDynamics>".format (id, export_fields)
    }
}

object ExcitationSystemDynamics
extends
    Parseable[ExcitationSystemDynamics]
{
    override val fields: Array[String] = Array[String] (
        "DiscontinuousExcitationControlDynamics",
        "OverexcitationLimiterDynamics",
        "PFVArControllerType1Dynamics",
        "PFVArControllerType2Dynamics",
        "PowerSystemStabilizerDynamics",
        "SynchronousMachineDynamics",
        "UnderexcitationLimiterDynamics",
        "VoltageCompensatorDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiscontinuousExcitationControlDynamics", "DiscontinuousExcitationControlDynamics", "0..1", "1"),
        Relationship ("OverexcitationLimiterDynamics", "OverexcitationLimiterDynamics", "0..1", "1"),
        Relationship ("PFVArControllerType1Dynamics", "PFVArControllerType1Dynamics", "0..1", "1"),
        Relationship ("PFVArControllerType2Dynamics", "PFVArControllerType2Dynamics", "0..1", "1"),
        Relationship ("PowerSystemStabilizerDynamics", "PowerSystemStabilizerDynamics", "0..1", "1"),
        Relationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..1"),
        Relationship ("UnderexcitationLimiterDynamics", "UnderexcitationLimiterDynamics", "0..1", "1"),
        Relationship ("VoltageCompensatorDynamics", "VoltageCompensatorDynamics", "0..1", "1")
    )
    val DiscontinuousExcitationControlDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OverexcitationLimiterDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PFVArControllerType1Dynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PFVArControllerType2Dynamics: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PowerSystemStabilizerDynamics: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(5)))
    val UnderexcitationLimiterDynamics: Fielder = parse_attribute (attribute (cls, fields(6)))
    val VoltageCompensatorDynamics: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): ExcitationSystemDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ExcitationSystemDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (DiscontinuousExcitationControlDynamics (), 0),
            mask (OverexcitationLimiterDynamics (), 1),
            mask (PFVArControllerType1Dynamics (), 2),
            mask (PFVArControllerType2Dynamics (), 3),
            mask (PowerSystemStabilizerDynamics (), 4),
            mask (SynchronousMachineDynamics (), 5),
            mask (UnderexcitationLimiterDynamics (), 6),
            mask (VoltageCompensatorDynamics (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _ExcitationSystemDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            ExcAC1A.register,
            ExcAC2A.register,
            ExcAC3A.register,
            ExcAC4A.register,
            ExcAC5A.register,
            ExcAC6A.register,
            ExcAC8B.register,
            ExcANS.register,
            ExcAVR1.register,
            ExcAVR2.register,
            ExcAVR3.register,
            ExcAVR4.register,
            ExcAVR5.register,
            ExcAVR7.register,
            ExcBBC.register,
            ExcCZ.register,
            ExcDC1A.register,
            ExcDC2A.register,
            ExcDC3A.register,
            ExcDC3A1.register,
            ExcELIN1.register,
            ExcELIN2.register,
            ExcHU.register,
            ExcIEEEAC1A.register,
            ExcIEEEAC2A.register,
            ExcIEEEAC3A.register,
            ExcIEEEAC4A.register,
            ExcIEEEAC5A.register,
            ExcIEEEAC6A.register,
            ExcIEEEAC7B.register,
            ExcIEEEAC8B.register,
            ExcIEEEDC1A.register,
            ExcIEEEDC2A.register,
            ExcIEEEDC3A.register,
            ExcIEEEDC4B.register,
            ExcIEEEST1A.register,
            ExcIEEEST2A.register,
            ExcIEEEST3A.register,
            ExcIEEEST4B.register,
            ExcIEEEST5B.register,
            ExcIEEEST6B.register,
            ExcIEEEST7B.register,
            ExcOEX3T.register,
            ExcPIC.register,
            ExcREXS.register,
            ExcSCRX.register,
            ExcSEXS.register,
            ExcSK.register,
            ExcST1A.register,
            ExcST2A.register,
            ExcST3A.register,
            ExcST4B.register,
            ExcST6B.register,
            ExcST7B.register,
            ExcitationSystemDynamics.register
        )
    }
}