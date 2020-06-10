package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Modified IEEE AC1A alternator-supplied rectifier excitation system with different rate feedback source.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param hvlvgates Indicates if both HV gate and LV gate are active (<i>HVLVgates</i>).
 *        true = gates are used
 *        false = gates are not used.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 400.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>Kd</i>) (&gt;= 0).
 *        Typical value = 0,38.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param kf1 Coefficient to allow different usage of the model (<i>Kf1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param kf2 Coefficient to allow different usage of the model (<i>Kf2</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>c</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,8.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>amax</sub></i>) (&gt; 0).
 *        Typical value = 14,5.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>amin</sub></i>) (&lt; 0).
 *        Typical value = -14,5.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve1</i>) (&gt; 0).
 *        Typical value = 4,18.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve2</i>) (&gt; 0).
 *        Typical value = 3,14.
 * @param vrmax Maximum voltage regulator outputs (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 6,03.
 * @param vrmin Minimum voltage regulator outputs (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -5,43.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    hvlvgates: Boolean = false,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    kf1: Double = 0.0,
    kf2: Double = 0.0,
    ks: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC1A]
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

    def parse (context: CIMContext): ExcAC1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param hvgate Indicates if HV gate is active (<i>HVgate</i>).
 *        true = gate is used
 *        false = gate is not used.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 400.
 * @param kb Second stage regulator gain (<i>Kb</i>) (&gt; 0).
 *        Exciter field current controller gain.  Typical value = 25.
 * @param kb1 Second stage regulator gain (<i>Kb1</i>).
 *        It is exciter field current controller gain used as alternative to <i>Kb</i> to represent a variant of the ExcAC2A model.  Typical value = 25.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,28.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>Kd</i>) (&gt;= 0).
 *        Typical value = 0,35.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param kh Exciter field current feedback gain (<i>Kh</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kl Exciter field current limiter gain (<i>Kl</i>).
 *        Typical value = 10.
 * @param kl1 Coefficient to allow different usage of the model (<i>Kl1</i>).
 *        Typical value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param lvgate Indicates if LV gate is active (<i>LVgate</i>).
 *        true = gate is used
 *        false = gate is not used.
 *        Typical value = true.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,037.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,012.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,6.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>Vamax</i>) (&gt; 0).
 *        Typical value = 8.
 * @param vamin Minimum voltage regulator output (<i>Vamin</i>) (&lt; 0).
 *        Typical value = -8.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 4,4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 3,3.
 * @param vfemax Exciter field current limit reference (<i>Vfemax</i>) (&gt;= 0).
 *        Typical value = 4,4.
 * @param vlr Maximum exciter field current (<i>Vlr</i>) (&gt; 0).
 *        Typical value = 4,4.
 * @param vrmax Maximum voltage regulator outputs (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 105.
 * @param vrmin Minimum voltage regulator outputs (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -95.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    hvgate: Boolean = false,
    ka: Double = 0.0,
    kb: Double = 0.0,
    kb1: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    kh: Double = 0.0,
    kl: Double = 0.0,
    kl1: Double = 0.0,
    ks: Double = 0.0,
    lvgate: Boolean = false,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vfemax: Double = 0.0,
    vlr: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC2A]
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

    def parse (context: CIMContext): ExcAC2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdn Value of <i>Efd </i>at which feedback gain changes (<i>Efdn</i>) (&gt; 0).
 *        Typical value = 2,36.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 45,62.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,104.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>Kd</i>) (&gt;= 0).
 *        Typical value = 0,499.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,143.
 * @param kf1 Coefficient to allow different usage of the model (<i>Kf1</i>).
 *        Typical value = 1.
 * @param kf2 Coefficient to allow different usage of the model (<i>Kf2</i>).
 *        Typical value = 0.
 * @param klv Gain used in the minimum field voltage limiter loop (<i>Klv</i>).
 *        Typical value = 0,194.
 * @param kn Excitation control system stabilizer gain (<i>Kn</i>) (&gt;= 0).
 *        Typical value =0,05.
 * @param kr Constant associated with regulator and alternator field power supply (<i>Kr</i>) (&gt; 0).
 *        Typical value =3,77.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 1,143.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,013.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,17.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>Vamax</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamin Minimum voltage regulator output (<i>Vamin</i>) (&lt; 0).
 *        Typical value = -0,95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 6.24.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 4,68.
 * @param vemin Minimum exciter voltage output (<i>Vemin</i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vfemax Exciter field current limit reference (<i>Vfemax</i>) (&gt;= 0).
 *        Typical value = 16.
 * @param vlv Field voltage used in the minimum field voltage limiter loop (<i>Vlv</i>).
 *        Typical value = 0,79.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdn: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    kf1: Double = 0.0,
    kf2: Double = 0.0,
    klv: Double = 0.0,
    kn: Double = 0.0,
    kr: Double = 0.0,
    ks: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vemin: Double = 0.0,
    vfemax: Double = 0.0,
    vlv: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC3A]
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

    def parse (context: CIMContext): ExcAC3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,015.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vimax Maximum voltage regulator input limit (<i>Vimax</i>)  (&gt; 0).
 *        Typical value = 10.
 * @param vimin Minimum voltage regulator input limit (<i>Vimin</i>) (&lt; 0).
 *        Typical value = -10.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 5,64.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -4,53.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC4A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC4A]
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

    def parse (context: CIMContext): ExcAC4A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param a Coefficient to allow different usage of the model (<i>a</i>).
 *        Typical value = 1.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>Efd1</i>) (&gt; 0).
 *        Typical value = 5,6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>Efd2</i>) (&gt; 0).
 *        Typical value = 4,2.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 400.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>1</sub></i> (<i>Se[Efd</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,86.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>2</sub></i> (<i>Se[Efd</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,8.
 * @param tf1 Excitation control system stabilizer time constant (<i>Tf1</i>) (&gt; 0).
 *        Typical value  = 1.
 * @param tf2 Excitation control system stabilizer time constant (<i>Tf2</i>) (&gt;= 0).
 *        Typical value = 0,8.
 * @param tf3 Excitation control system stabilizer time constant (<i>Tf3</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 7,3.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value =-7,3.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC5A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    a: Double = 0.0,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ks: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    tf3: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC5A]
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

    def parse (context: CIMContext): ExcAC5A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 536.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,173.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>Kd</i>) (&gt;= 0).
 *        Typical value = 1,91.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1,6.
 * @param kh Exciter field current limiter gain (<i>Kh</i>) (&gt;= 0).
 *        Typical value = 92.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,214.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,044.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0,086.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 9.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1.
 * @param th Exciter field current limiter time constant (<i>Th</i>) (&gt; 0).
 *        Typical value = 0,08.
 * @param tj Exciter field current limiter time constant (<i>Tj</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param tk Voltage regulator time constant (<i>Tk</i>) (&gt;= 0).
 *        Typical value = 0,18.
 * @param vamax Maximum voltage regulator output (<i>Vamax</i>) (&gt; 0).
 *        Typical value = 75.
 * @param vamin Minimum voltage regulator output (<i>Vamin</i>) (&lt; 0).
 *        Typical value = -75.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 7,4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 5,55.
 * @param vfelim Exciter field current limit reference (<i>Vfelim</i>) (&gt; 0).
 *        Typical value = 19.
 * @param vhmax Maximum field current limiter signal reference (<i>Vhmax</i>) (&gt; 0).
 *        Typical value = 75.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 44.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -36.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC6A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kh: Double = 0.0,
    ks: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    th: Double = 0.0,
    tj: Double = 0.0,
    tk: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vfelim: Double = 0.0,
    vhmax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC6A]
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

    def parse (context: CIMContext): ExcAC6A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param inlim Input limiter indicator.
 *        true = input limiter <i>Vimax</i> and <i>Vimin</i> is considered
 *        false = input limiter <i>Vimax </i>and <i>Vimin</i> is not considered.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 1.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,55.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>Kd</i>) (&gt;= 0).
 *        Typical value = 1,1.
 * @param kdr Voltage regulator derivative gain (<i>Kdr</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kir Voltage regulator integral gain (<i>Kir</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param kpr Voltage regulator proportional gain (<i>Kpr</i>) (&gt; 0 if ExcAC8B.kir = 0).
 *        Typical value = 80.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param pidlim PID limiter indicator.
 *        true = input limiter <i>Vpidmax</i> and <i>Vpidmin</i> is considered
 *        false = input limiter <i>Vpidmax</i> and <i>Vpidmin</i> is not considered.
 *        Typical value = true.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tdr Lag time constant (<i>Tdr</i>) (&gt; 0 if ExcAC8B.kdr &gt; 0).
 *        Typical value = 0,1.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,2.
 * @param telim Selector for the limiter on the block (<i>1/sTe</i>).
 *        See diagram for meaning of true and false.
 *        Typical value = false.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 6,5.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 9.
 * @param vemin Minimum exciter voltage output (<i>Vemin</i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vfemax Exciter field current limit reference (<i>Vfemax</i>).
 *        Typical value = 6.
 * @param vimax Input signal maximum (<i>Vimax</i>) (&gt; ExcAC8B.vimin).
 *        Typical value = 35.
 * @param vimin Input signal minimum (<i>Vimin</i>) (&lt; ExcAC8B.vimax).
 *        Typical value = -10.
 * @param vpidmax PID maximum controller output (<i>Vpidmax</i>) (&gt; ExcAC8B.vpidmin).
 *        Typical value = 35.
 * @param vpidmin PID minimum controller output (<i>Vpidmin</i>) (&lt; ExcAC8B.vpidmax).
 *        Typical value = -10.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 35.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = 0.
 * @param vtmult Multiply by generator's terminal voltage indicator.
 *        true =the limits <i>Vrmax</i> and <i>Vrmin</i> are multiplied by the generator’s terminal voltage to represent a thyristor power stage fed from the generator terminals
 *        false = limits are not multiplied by generator's terminal voltage.
 *        Typical value = false.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAC8B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    inlim: Boolean = false,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    kdr: Double = 0.0,
    ke: Double = 0.0,
    kir: Double = 0.0,
    kpr: Double = 0.0,
    ks: Double = 0.0,
    pidlim: Boolean = false,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tdr: Double = 0.0,
    te: Double = 0.0,
    telim: Boolean = false,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vemin: Double = 0.0,
    vfemax: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vpidmax: Double = 0.0,
    vpidmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    vtmult: Boolean = false
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAC8B]
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

    def parse (context: CIMContext): ExcAC8B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param blint Governor control flag (<i>BLINT</i>).
 *        0 = lead-lag regulator
 *        1 = proportional integral regulator.
 *        Typical value = 0.
 * @param ifmn Minimum exciter current (<i>I</i><i><sub>FMN</sub></i>).
 *        Typical value = -5,2.
 * @param ifmx Maximum exciter current (<i>I</i><i><sub>FMX</sub></i>).
 *        Typical value = 6,5.
 * @param k2 Exciter gain (<i>K</i><i><sub>2</sub></i>).
 *        Typical value = 20.
 * @param k3 AVR gain (<i>K</i><i><sub>3</sub></i>).
 *        Typical value = 1000.
 * @param kce Ceiling factor (<i>K</i><i><sub>CE</sub></i>).
 *        Typical value = 1.
 * @param krvecc Feedback enabling (<i>K</i><i><sub>RVECC</sub></i>).
 *        0 = open loop control
 *        1 = closed loop control.
 *        Typical value = 1.
 * @param kvfif Rate feedback signal flag (<i>K</i><i><sub>VFIF</sub></i>).
 *        0 = output voltage of the exciter
 *        1 = exciter field current.
 *        Typical value = 0.
 * @param t1 Time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *        Typical value = 20.
 * @param t2 Time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param t3 Time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *        Typical value = 1,6.
 * @param tb Exciter time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0,04.
 * @param vrmn Minimum AVR output (<i>V</i><i><sub>RMN</sub></i>).
 *        Typical value = -5,2.
 * @param vrmx Maximum AVR output (<i>V</i><i><sub>RMX</sub></i>).
 *        Typical value = 6,5.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcANS
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    blint: Int = 0,
    ifmn: Double = 0.0,
    ifmx: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    kce: Double = 0.0,
    krvecc: Int = 0,
    kvfif: Int = 0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    tb: Double = 0.0,
    vrmn: Double = 0.0,
    vrmx: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcANS]
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

    def parse (context: CIMContext): ExcANS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Italian excitation system corresponding to IEEE (1968) type 1 model.
 *
 * It represents an exciter dynamo and electromechanical regulator.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Field voltage value 1 (<i>E</i><i><sub>1</sub></i>).
 *        Typical value = 4.18.
 * @param e2 Field voltage value 2 (<i>E</i><i><sub>2</sub></i>).
 *        Typical value = 3,14.
 * @param ka AVR gain (<i>K</i><i><sub>A</sub></i>).
 *        Typical value = 500.
 * @param kf Rate feedback gain (<i>K</i><i><sub>F</sub></i>).
 *        Typical value = 0,12.
 * @param se1 Saturation factor at <i>E</i><i><sub>1</sub></i> (<i>S[E</i><i><sub>1</sub></i><i>]</i>).
 *        Typical value = 0,1.
 * @param se2 Saturation factor at <i>E</i><i><sub>2</sub></i> (<i>S[E</i><i><sub>2</sub></i><i>]</i>).
 *        Typical value = 0,03.
 * @param ta AVR time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param tb AVR time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant (<i>T</i><i><sub>E</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf Rate feedback time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vrmn Minimum AVR output (<i>V</i><i><sub>RMN</sub></i>).
 *        Typical value = -6.
 * @param vrmx Maximum AVR output (<i>V</i><i><sub>RMX</sub></i>).
 *        Typical value = 7.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR1
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    ka: Double = 0.0,
    kf: Double = 0.0,
    se1: Double = 0.0,
    se2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vrmn: Double = 0.0,
    vrmx: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR1]
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

    def parse (context: CIMContext): ExcAVR1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Italian excitation system corresponding to IEEE (1968) type 2 model.
 *
 * It represents an alternator and rotating diodes and electromechanic voltage regulators.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Field voltage value 1 (<i>E</i><i><sub>1</sub></i>).
 *        Typical value = 4,18.
 * @param e2 Field voltage value 2 (<i>E</i><i><sub>2</sub></i>).
 *        Typical value = 3,14.
 * @param ka AVR gain (<i>K</i><i><sub>A</sub></i>).
 *        Typical value = 500.
 * @param kf Rate feedback gain (<i>K</i><i><sub>F</sub></i>).
 *        Typical value = 0,12.
 * @param se1 Saturation factor at <i>E</i><i><sub>1</sub></i> (<i>S[E</i><i><sub>1</sub></i><i>]</i>).
 *        Typical value = 0.1.
 * @param se2 Saturation factor at <i>E</i><i><sub>2</sub></i> (<i>S[E</i><i><sub>2</sub></i><i>]</i>).
 *        Typical value = 0,03.
 * @param ta AVR time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param tb AVR time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant (<i>T</i><i><sub>E</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf1 Rate feedback time constant (<i>T</i><i><sub>F1</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf2 Rate feedback time constant (<i>T</i><i><sub>F2</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vrmn Minimum AVR output (<i>V</i><i><sub>RMN</sub></i>).
 *        Typical value = -6.
 * @param vrmx Maximum AVR output (<i>V</i><i><sub>RMX</sub></i>).
 *        Typical value = 7.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR2
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    ka: Double = 0.0,
    kf: Double = 0.0,
    se1: Double = 0.0,
    se2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    te: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    vrmn: Double = 0.0,
    vrmx: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR2]
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

    def parse (context: CIMContext): ExcAVR2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * It represents an exciter dynamo and electric regulator.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Field voltage value 1 (<i>E</i><i><sub>1</sub></i>).
 *        Typical value = 4,18.
 * @param e2 Field voltage value 2 (<i>E</i><i><sub>2</sub></i>).
 *        Typical value = 3,14.
 * @param ka AVR gain (<i>K</i><i><sub>A</sub></i>).
 *        Typical value = 100.
 * @param se1 Saturation factor at <i>E</i><i><sub>1</sub></i><i> </i>(<i>S[E</i><i><sub>1</sub></i><i>]</i>).
 *        Typical value = 0,1.
 * @param se2 Saturation factor at <i>E</i><i><sub>2</sub></i><i> </i>(<i>S[E</i><i><sub>2</sub></i><i>]</i>).
 *        Typical value = 0,03.
 * @param t1 AVR time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *        Typical value = 20.
 * @param t2 AVR time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *        Typical value = 1,6.
 * @param t3 AVR time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *        Typical value = 0,66.
 * @param t4 AVR time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 *        Typical value = 0,07.
 * @param te Exciter time constant (<i>T</i><i><sub>E</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vrmn Minimum AVR output (<i>V</i><i><sub>RMN</sub></i>).
 *        Typical value = -7,5.
 * @param vrmx Maximum AVR output (<i>V</i><i><sub>RMX</sub></i>).
 *        Typical value = 7,5.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR3
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    ka: Double = 0.0,
    se1: Double = 0.0,
    se2: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    te: Double = 0.0,
    vrmn: Double = 0.0,
    vrmx: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR3]
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

    def parse (context: CIMContext): ExcAVR3 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * It represents a static exciter and electric voltage regulator.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param imul AVR output voltage dependency selector (<i>I</i><i><sub>MUL</sub></i>).
 *        true = selector is connected
 *        false = selector is not connected.
 *        Typical value = true.
 * @param ka AVR gain (<i>K</i><i><sub>A</sub></i>).
 *        Typical value = 300.
 * @param ke Exciter gain (<i>K</i><i><sub>E</sub></i><i>)</i>.
 *        Typical value = 1.
 * @param kif Exciter internal reactance (<i>K</i><i><sub>IF</sub></i>).
 *        Typical value = 0.
 * @param t1 AVR time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *        Typical value = 4,8.
 * @param t1if Exciter current feedback time constant (<i>T</i><i><sub>1IF</sub></i>) (&gt;= 0).
 *        Typical value = 60.
 * @param t2 AVR time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *        Typical value = 1,5.
 * @param t3 AVR time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t4 AVR time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tif Exciter current feedback time constant (<i>T</i><i><sub>IF</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vfmn Minimum exciter output (<i>V</i><i><sub>FMN</sub></i>).
 *        Typical value = 0.
 * @param vfmx Maximum exciter output (<i>V</i><i><sub>FMX</sub></i>).
 *        Typical value = 5.
 * @param vrmn Minimum AVR output (<i>V</i><i><sub>RMN</sub></i>).
 *        Typical value = 0.
 * @param vrmx Maximum AVR output (<i>V</i><i><sub>RMX</sub></i>).
 *        Typical value = 5.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR4
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    imul: Boolean = false,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kif: Double = 0.0,
    t1: Double = 0.0,
    t1if: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    tif: Double = 0.0,
    vfmn: Double = 0.0,
    vfmx: Double = 0.0,
    vrmn: Double = 0.0,
    vrmx: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR4]
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

    def parse (context: CIMContext): ExcAVR4 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Gain (<i>Ka</i>).
 * @param rex Effective output resistance (<i>Rex</i>). <i>Rex</i> represents the effective output resistance seen by the excitation system.
 * @param ta Time constant (<i>Ta</i>) (&gt;= 0).
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR5
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    rex: Double = 0.0,
    ta: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR5]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "rex",
        "ta"
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val rex: Fielder = parse_element (element (cls, fields(1)))
    val ta: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): ExcAVR5 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param a1 Lead coefficient (<i>A</i><i><sub>1</sub></i>).
 *        Typical value = 0,5.
 * @param a2 Lag coefficient (<i>A</i><i><sub>2</sub></i>).
 *        Typical value = 0,5.
 * @param a3 Lead coefficient (<i>A</i><i><sub>3</sub></i>).
 *        Typical value = 0,5.
 * @param a4 Lag coefficient (<i>A</i><i><sub>4</sub></i>).
 *        Typical value = 0,5.
 * @param a5 Lead coefficient (<i>A</i><i><sub>5</sub></i>).
 *        Typical value = 0,5.
 * @param a6 Lag coefficient (<i>A</i><i><sub>6</sub></i>).
 *        Typical value = 0,5.
 * @param k1 Gain (<i>K</i><i><sub>1</sub></i>).
 *        Typical value = 1.
 * @param k3 Gain (<i>K</i><i><sub>3</sub></i>).
 *        Typical value = 3.
 * @param k5 Gain (<i>K</i><i><sub>5</sub></i>).
 *        Typical value = 1.
 * @param t1 Lead time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param t2 Lag time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t3 Lead time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t4 Lag time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t5 Lead time constant (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t6 Lag time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param vmax1 Lead-lag maximum limit (<i>Vmax1</i>) (&gt; ExcAVR7.vmin1).
 *        Typical value = 5.
 * @param vmax3 Lead-lag maximum limit (<i>Vmax3</i>) (&gt; ExcAVR7.vmin3).
 *        Typical value = 5.
 * @param vmax5 Lead-lag maximum limit (<i>Vmax5</i>) (&gt; ExcAVR7.vmin5).
 *        Typical value = 5.
 * @param vmin1 Lead-lag minimum limit (<i>Vmin1</i>) (&lt; ExcAVR7.vmax1).
 *        Typical value = -5.
 * @param vmin3 Lead-lag minimum limit (<i>Vmin3</i>) (&lt; ExcAVR7.vmax3).
 *        Typical value = -5.
 * @param vmin5 Lead-lag minimum limit (<i>Vmin5</i>) (&lt; ExcAVR7.vmax5).
 *        Typical value = -2.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcAVR7
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    a1: Double = 0.0,
    a2: Double = 0.0,
    a3: Double = 0.0,
    a4: Double = 0.0,
    a5: Double = 0.0,
    a6: Double = 0.0,
    k1: Double = 0.0,
    k3: Double = 0.0,
    k5: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    vmax1: Double = 0.0,
    vmax3: Double = 0.0,
    vmax5: Double = 0.0,
    vmin1: Double = 0.0,
    vmin3: Double = 0.0,
    vmin5: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcAVR7]
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

    def parse (context: CIMContext): ExcAVR7 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Maximum open circuit exciter voltage (<i>Efdmax</i>) (&gt; ExcBBC.efdmin).
 *        Typical value = 5.
 * @param efdmin Minimum open circuit exciter voltage (<i>Efdmin</i>) (&lt; ExcBBC.efdmax).
 *        Typical value = -5.
 * @param k Steady state gain (<i>K</i>) (not = 0).
 *        Typical value = 300.
 * @param switch Supplementary signal routing selector (<i>switch</i>).
 *        true = <i>Vs</i> connected to 3rd summing point
 *        false =  <i>Vs</i> connected to 1st summing point (see diagram).
 *        Typical value = false.
 * @param t1 Controller time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 6.
 * @param t2 Controller time constant (<i>T2</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param t3 Lead/lag time constant (<i>T3</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,05.
 * @param t4 Lead/lag time constant (<i>T4</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,01.
 * @param vrmax Maximum control element output (<i>Vrmax</i>) (&gt; ExcBBC.vrmin).
 *        Typical value = 5.
 * @param vrmin Minimum control element output (<i>Vrmin</i>) (&lt; ExcBBC.vrmax).
 *        Typical value = -5.
 * @param xe Effective excitation transformer reactance (<i>Xe</i>) (&gt;= 0).  <i>Xe</i> models the regulation of the transformer/rectifier unit.
 *        Typical value = 0,05.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcBBC
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    k: Double = 0.0,
    `switch`: Boolean = false,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xe: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcBBC]
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

    def parse (context: CIMContext): ExcBBC =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Czech proportion/integral exciter.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Exciter output maximum limit (<i>Efdmax</i>) (&gt; ExcCZ.efdmin).
 * @param efdmin Exciter output minimum limit (<i>Efdmin</i>) (&lt; ExcCZ.efdmax).
 * @param ka Regulator gain (<i>Ka</i>).
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 * @param kp Regulator proportional gain (<i>Kp</i>).
 * @param ta Regulator time constant (<i>Ta</i>) (&gt;= 0).
 * @param tc Regulator integral time constant (<i>Tc</i>) (&gt;= 0).
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt;= 0).
 * @param vrmax Voltage regulator maximum limit (<i>Vrmax</i>) (&gt; ExcCZ.vrmin).
 * @param vrmin Voltage regulator minimum limit (<i>Vrmin</i>) (&lt; ExcCZ.vrmax).
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcCZ
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kp: Double = 0.0,
    ta: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcCZ]
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

    def parse (context: CIMContext): ExcCZ =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 3,1.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 2,3.
 * @param efdmax Maximum voltage exciter output limiter (<i>Efdmax</i>) (&gt; ExcDC1A.efdmin).
 *        Typical value = 99.
 * @param efdmin Minimum voltage exciter output limiter (<i>Efdmin</i>) (&lt; ExcDC1A.edfmax).
 *        Typical value = -99.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 *        true = a lower limit of zero is applied to integrator output
 *        false = a lower limit of zero is not applied to integrator output.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 46.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 0.
 * @param kf Excitation control system stabilizer gain (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>1</sub></i> (<i>Se[Eefd</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,33.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>2</sub></i> (<i>Se[Eefd</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,06.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,46.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; ExcDC1A.vrmin).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0 and &lt; ExcDC1A.vrmax).
 *        Typical value = -0,9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcDC1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    exclim: Boolean = false,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ks: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
        implicit val clz: String = ExcDC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC1A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, efdmax)
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
    CIMParseable[ExcDC1A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "efdmax",
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
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val efdmax: Fielder = parse_element (element (cls, fields(2)))
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

    def parse (context: CIMContext): ExcDC1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExcDC1A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (efdmax (), 2)),
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
 * Modified IEEE DC2A direct current commutator exciter with speed input, one more leg block in feedback loop and without underexcitation limiters (UEL) inputs.
 *
 * DC type 2 excitation system model with added speed multiplier, added lead-lag, and voltage-dependent limits.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 3,05.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 2,29.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 *        true = a lower limit of zero is applied to integrator output
 *        false = a lower limit of zero is not applied to integrator output.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 300.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        If <i>Ke</i> is entered as zero, the model calculates an effective value of <i>Ke</i> such that the initial condition value of <i>Vr</i> is zero. The zero value of <i>Ke</i> is not changed.  If <i>Ke</i> is entered as non-zero, its value is used directly, without change.  Typical value = 1.
 * @param kf Excitation control system stabilizer gain (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>1</sub></i> (<i>Se[Efd</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,279.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>2</sub></i> (<i>Se[Efd</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,117.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,01.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,33.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 0,675.
 * @param tf1 Excitation control system stabilizer time constant (<i>Tf1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; ExcDC2A.vrmin).
 *        Typical value = 4,95.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0 and &lt; ExcDC2A.vrmax).
 *        Typical value = -4,9.
 * @param vtlim (<i>Vtlim</i>).
 *        true = limiter at the block (<i>Ka / [1 + sTa]</i>) is dependent on <i>Vt </i>
 *        false = limiter at the block is not dependent on <i>Vt</i>.
 *        Typical value = true.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcDC2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    exclim: Boolean = false,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ks: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    tf1: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    vtlim: Boolean = false
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcDC2A]
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

    def parse (context: CIMContext): ExcDC2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Modified IEEE DC3A direct current commutator exciter with speed input, and deadband.
 *
 * DC old type 4.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 2,6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>Efd</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 3,45.
 * @param efdlim (<i>Efdlim</i>).
 *        true = exciter output limiter is active
 *        false = exciter output limiter not active.
 *        Typical value = true.
 * @param efdmax Maximum voltage exciter output limiter (<i>Efdmax</i>) (&gt; ExcDC3A.efdmin).
 *        Typical value = 99.
 * @param efdmin Minimum voltage exciter output limiter (<i>Efdmin</i>) (&lt; ExcDC3A.efdmax).
 *        Typical value = -99.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 *        true = a lower limit of zero is applied to integrator output
 *        false = a lower limit of zero not applied to integrator output.
 *        Typical value = true.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kr Deadband (<i>Kr</i>).
 *        Typical value = 0.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param kv Fast raise/lower contact setting (<i>Kv</i>) (&gt; 0).
 *        Typical value = 0,05.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>1</sub></i> (<i>Se[Efd</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>Efd</i><i><sub>2</sub></i> (<i>Se[Efd</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,35.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,83.
 * @param trh Rheostat travel time (<i>Trh</i>) (&gt; 0).
 *        Typical value = 20.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 5.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt;= 0).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcDC3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    efdlim: Boolean = false,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    exclim: Boolean = false,
    ke: Double = 0.0,
    kr: Double = 0.0,
    ks: Double = 0.0,
    kv: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    te: Double = 0.0,
    trh: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
        implicit val clz: String = ExcDC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcDC3A.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, efdlim)
        emitelem (3, efdmax)
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
    CIMParseable[ExcDC3A]
{
    override val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "efdlim",
        "efdmax",
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
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val efdlim: Fielder = parse_element (element (cls, fields(2)))
    val efdmax: Fielder = parse_element (element (cls, fields(3)))
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

    def parse (context: CIMContext): ExcDC3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExcDC3A (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toBoolean (mask (efdlim (), 2)),
            toDouble (mask (efdmax (), 3)),
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
 * Modified old IEEE type 3 excitation system.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param exclim (<i>exclim</i>).
 *        true = lower limit of zero is applied to integrator output
 *        false = lower limit of zero not applied to integrator output.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 300.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gain (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ki Potential circuit gain coefficient (<i>Ki</i>) (&gt;= 0).
 *        Typical value = 4,83.
 * @param kp Potential circuit gain coefficient (<i>Kp</i>) (&gt;= 0).
 *        Typical value = 4,37.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,01.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,83.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0,675.
 * @param vb1max Available exciter voltage limiter (<i>Vb1max</i>) (&gt; 0).
 *        Typical value = 11,63.
 * @param vblim Vb limiter indicator.
 *        true = exciter <i>Vbmax</i> limiter is active
 *        false = <i>Vb1max</i> is active.
 *        Typical value = true.
 * @param vbmax Available exciter voltage limiter (<i>Vbmax</i>) (&gt; 0).
 *        Typical value = 11,63.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; ExcDC3A1.vrmin).
 *        Typical value = 5.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0 and &lt; ExcDC3A1.vrmax).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcDC3A1
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    exclim: Boolean = false,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    ta: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vb1max: Double = 0.0,
    vblim: Boolean = false,
    vbmax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcDC3A1]
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

    def parse (context: CIMContext): ExcDC3A1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Static PI transformer fed excitation system ELIN (VATECH) - simplified model.
 *
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  A power system stabilizer with power input is included in the model.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param dpnf Controller follow up deadband (<i>Dpnf</i>).
 *        Typical value = 0.
 * @param efmax Maximum open circuit excitation voltage (<i>Efmax</i>) (&gt; ExcELIN1.efmin).
 *        Typical value = 5.
 * @param efmin Minimum open circuit excitation voltage (<i>Efmin</i>) (&lt; ExcELIN1.efmax).
 *        Typical value = -5.
 * @param ks1 Stabilizer gain 1 (<i>Ks1</i>).
 *        Typical value = 0.
 * @param ks2 Stabilizer gain 2 (<i>Ks2</i>).
 *        Typical value = 0.
 * @param smax Stabilizer limit output (<i>smax</i>).
 *        Typical value = 0,1.
 * @param tfi Current transducer time constant (<i>Tfi</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tnu Controller reset time constant (<i>Tnu</i>) (&gt;= 0).
 *        Typical value = 2.
 * @param ts1 Stabilizer phase lag time constant (<i>Ts1</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ts2 Stabilizer filter time constant (<i>Ts2</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tsw Stabilizer parameters (<i>Tsw</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param vpi Current controller gain (<i>Vpi</i>).
 *        Typical value = 12,45.
 * @param vpnf Controller follow up gain (<i>Vpnf</i>).
 *        Typical value = 2.
 * @param vpu Voltage controller proportional gain (<i>Vpu</i>).
 *        Typical value = 34,5.
 * @param xe Excitation transformer effective reactance (<i>Xe</i>) (&gt;= 0).  <i>Xe</i> represents the regulation of the transformer/rectifier unit.
 *        Typical value = 0,06.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcELIN1
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    dpnf: Double = 0.0,
    efmax: Double = 0.0,
    efmin: Double = 0.0,
    ks1: Double = 0.0,
    ks2: Double = 0.0,
    smax: Double = 0.0,
    tfi: Double = 0.0,
    tnu: Double = 0.0,
    ts1: Double = 0.0,
    ts2: Double = 0.0,
    tsw: Double = 0.0,
    vpi: Double = 0.0,
    vpnf: Double = 0.0,
    vpu: Double = 0.0,
    xe: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcELIN1]
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

    def parse (context: CIMContext): ExcELIN1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Detailed excitation system ELIN (VATECH).
 *
 * This model represents an all-static excitation system. A PI voltage controller establishes a desired field current set point for a proportional current controller. The integrator of the PI controller has a follow-up input to match its signal to the present field current.  Power system stabilizer models used in conjunction with this excitation system model: PssELIN2, PssIEEE2B, Pss2B.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdbas Gain (<i>Efdbas</i>).
 *        Typical value = 0,1.
 * @param iefmax Limiter (<i>I</i><i><sub>efmax</sub></i>) (&gt; ExcELIN2.iefmin).
 *        Typical value = 1.
 * @param iefmax2 Minimum open circuit excitation voltage (<i>I</i><i><sub>efmax2</sub></i>).
 *        Typical value = -5.
 * @param iefmin Limiter (<i>I</i><i><sub>efmin</sub></i>) (&lt; ExcELIN2.iefmax).
 *        Typical value = 1.
 * @param k1 Voltage regulator input gain (<i>K1</i>).
 *        Typical value = 0.
 * @param k1ec Voltage regulator input limit (<i>K1ec</i>).
 *        Typical value = 2.
 * @param k2 Gain (<i>K2</i>).
 *        Typical value = 5.
 * @param k3 Gain (<i>K3</i>).
 *        Typical value = 0,1.
 * @param k4 Gain (<i>K4</i>).
 *        Typical value = 0.
 * @param kd1 Voltage controller derivative gain (<i>Kd1</i>).
 *        Typical value = 34,5.
 * @param ke2 Gain (<i>Ke2</i>).
 *        Typical value = 0,1.
 * @param ketb Gain (<i>Ketb</i>).
 *        Typical value = 0,06.
 * @param pid1max Controller follow up gain (<i>PID1max</i>).
 *        Typical value = 2.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>1</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>Ve</i><i><sub>2</sub></i>, back of commutating reactance (<i>Se[Ve</i><i><sub>2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tb1 Voltage controller derivative washout time constant (<i>Tb1</i>) (&gt;= 0).
 *        Typical value = 12,45.
 * @param te Time constant (<i>Te</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te2 Time Constant (<i>T</i><i><sub>e2</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ti1 Controller follow up deadband (<i>Ti1</i>).
 *        Typical value = 0.
 * @param ti3 Time constant (<i>T</i><i><sub>i3</sub></i>) (&gt;= 0).
 *        Typical value = 3.
 * @param ti4 Time constant (<i>T</i><i><sub>i4</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tr4 Time constant (<i>T</i><i><sub>r4</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param upmax Limiter (<i>Upmax</i>) (&gt; ExcELIN2.upmin).
 *        Typical value = 3.
 * @param upmin Limiter (<i>Upmin</i>) (&lt; ExcELIN2.upmax).
 *        Typical value = 0.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 3.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>Ve</i><i><sub>2</sub></i>) (&gt; 0).
 *        Typical value = 0.
 * @param xp Excitation transformer effective reactance (<i>Xp</i>).
 *        Typical value = 1.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcELIN2
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdbas: Double = 0.0,
    iefmax: Double = 0.0,
    iefmax2: Double = 0.0,
    iefmin: Double = 0.0,
    k1: Double = 0.0,
    k1ec: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    kd1: Double = 0.0,
    ke2: Double = 0.0,
    ketb: Double = 0.0,
    pid1max: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    tb1: Double = 0.0,
    te: Double = 0.0,
    te2: Double = 0.0,
    ti1: Double = 0.0,
    ti3: Double = 0.0,
    ti4: Double = 0.0,
    tr4: Double = 0.0,
    upmax: Double = 0.0,
    upmin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    xp: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcELIN2]
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

    def parse (context: CIMContext): ExcELIN2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Hungarian excitation system, with built-in voltage transducer.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ae Major loop PI tag gain factor (<i>Ae</i>).
 *        Typical value = 3.
 * @param ai Minor loop PI tag gain factor (<i>Ai</i>).
 *        Typical value = 22.
 * @param atr AVR constant (<i>Atr</i>).
 *        Typical value = 2,19.
 * @param emax Field voltage control signal upper limit on AVR base (<i>Emax</i>) (&gt; ExcHU.emin).
 *        Typical value = 0,996.
 * @param emin Field voltage control signal lower limit on AVR base (<i>Emin</i>) (&lt; ExcHU.emax).
 *        Typical value = -0,866.
 * @param imax Major loop PI tag output signal upper limit (<i>Imax</i>) (&gt; ExcHU.imin).
 *        Typical value = 2,19.
 * @param imin Major loop PI tag output signal lower limit (<i>Imin</i>) (&lt; ExcHU.imax).
 *        Typical value = 0,1.
 * @param ke Voltage base conversion constant (<i>Ke</i>).
 *        Typical value = 4,666.
 * @param ki Current base conversion constant (<i>Ki</i>).
 *        Typical value = 0,21428.
 * @param te Major loop PI tag integration time constant (<i>Te</i>) (&gt;= 0).
 *        Typical value = 0,154.
 * @param ti Minor loop PI control tag integration time constant (<i>Ti</i>) (&gt;= 0).
 *        Typical value = 0,01333.
 * @param tr Filter time constant (<i>Tr</i>) (&gt;= 0).
 *        If a voltage compensator is used in conjunction with this excitation system model, <i>Tr </i>should be set to 0.  Typical value = 0,01.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcHU
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ae: Double = 0.0,
    ai: Double = 0.0,
    atr: Double = 0.0,
    emax: Double = 0.0,
    emin: Double = 0.0,
    imax: Double = 0.0,
    imin: Double = 0.0,
    ke: Double = 0.0,
    ki: Double = 0.0,
    te: Double = 0.0,
    ti: Double = 0.0,
    tr: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcHU]
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

    def parse (context: CIMContext): ExcHU =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC1A model.
 *
 * The model represents the field-controlled alternator-rectifier excitation systems designated type AC1A. These excitation systems consist of an alternator main exciter with non-controlled rectifiers.
 * Reference: IEEE 421.5-2005, 6.1.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 400.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 0,38.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,8.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 14,5.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -14,5.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 4,18.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 3,14.
 * @param vrmax Maximum voltage regulator outputs (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 6,03.
 * @param vrmin Minimum voltage regulator outputs (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -5,43.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC1A]
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

    def parse (context: CIMContext): ExcIEEEAC1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC2A model.
 *
 * The model represents a high initial response field-controlled alternator-rectifier excitation system. The alternator main exciter is used with non-controlled rectifiers. The type AC2A model is similar to that of type AC1A except for the inclusion of exciter time constant compensation and exciter field current limiting elements.
 * Reference: IEEE 421.5-2005, 6.2.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 400.
 * @param kb Second stage regulator gain (<i>K</i><i><sub>B</sub></i>) (&gt; 0).
 *        Typical value = 25.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,28.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 0,35.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param kh Exciter field current feedback gain (<i>K</i><i><sub>H</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,037.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,012.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,6.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 8.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -8.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 4,4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 3,3.
 * @param vfemax Exciter field current limit reference (<i>V</i><i><sub>FEMAX</sub></i>) (&gt; 0).
 *        Typical value = 4,4.
 * @param vrmax Maximum voltage regulator outputs (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 105.
 * @param vrmin Minimum voltage regulator outputs (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -95.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kb: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    kh: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vfemax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC2A]
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

    def parse (context: CIMContext): ExcIEEEAC2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC3A model.
 *
 * The model represents the field-controlled alternator-rectifier excitation systems designated type AC3A. These excitation systems include an alternator main exciter with non-controlled rectifiers. The exciter employs self-excitation, and the voltage regulator power is derived from the exciter output voltage.  Therefore, this system has an additional nonlinearity, simulated by the use of a multiplier whose inputs are the voltage regulator command signal, <i>Va</i>, and the exciter output voltage, <i>Efd</i>, times <i>K</i><i><sub>R</sub></i>.  This model is applicable to excitation systems employing static voltage regulators.
 * Reference: IEEE 421.5-2005, 6.3.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdn Value of <i>Efd </i>at which feedback gain changes (<i>E</i><i><sub>FDN</sub></i>) (&gt; 0).
 *        Typical value = 2,36.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 45,62.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,104.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 0,499.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,143.
 * @param kn Excitation control system stabilizer gain (<i>K</i><i><sub>N</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param kr Constant associated with regulator and alternator field power supply (<i>K</i><i><sub>R</sub></i>) (&gt; 0).
 *        Typical value = 3,77.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 1,143.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,013.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 1,17.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -0,95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 6,24.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 4,68.
 * @param vemin Minimum exciter voltage output (<i>V</i><i><sub>EMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vfemax Exciter field current limit reference (<i>V</i><i><sub>FEMAX</sub></i>) (&gt;= 0).
 *        Typical value = 16.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdn: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    kn: Double = 0.0,
    kr: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vemin: Double = 0.0,
    vfemax: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC3A]
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

    def parse (context: CIMContext): ExcIEEEAC3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC4A model.
 *
 * The model represents type AC4A alternator-supplied controlled-rectifier excitation system which is quite different from the other types of AC systems. This high initial response excitation system utilizes a full thyristor bridge in the exciter output circuit.  The voltage regulator controls the firing of the thyristor bridges. The exciter alternator uses an independent voltage regulator to control its output voltage to a constant value. These effects are not modelled; however, transient loading effects on the exciter alternator are included.
 * Reference: IEEE 421.5-2005, 6.4.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,015.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vimax Maximum voltage regulator input limit (<i>V</i><i><sub>IMAX</sub></i>) (&gt; 0).
 *        Typical value = 10.
 * @param vimin Minimum voltage regulator input limit (<i>V</i><i><sub>IMIN</sub></i>) (&lt; 0).
 *        Typical value = -10.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 5,64.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -4,53.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC4A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC4A]
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

    def parse (context: CIMContext): ExcIEEEAC4A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC5A model.
 *
 * The model represents a simplified model for brushless excitation systems. The regulator is supplied from a source, such as a permanent magnet generator, which is not affected by system disturbances.  Unlike other AC models, this model uses loaded rather than open circuit exciter saturation data in the same way as it is used for the DC models.  Because the model has been widely implemented by the industry, it is sometimes used to represent other types of systems when either detailed data for them are not available or simplified models are required.
 * Reference: IEEE 421.5-2005, 6.5.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD1</sub></i>) (&gt; 0).
 *        Typical value = 5,6.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD2</sub></i>) (&gt; 0).
 *        Typical value = 4,2.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 400.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD1</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,86.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD2</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,8.
 * @param tf1 Excitation control system stabilizer time constant (<i>T</i><i><sub>F1</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param tf2 Excitation control system stabilizer time constant (<i>T</i><i><sub>F2</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf3 Excitation control system stabilizer time constant (<i>T</i><i><sub>F3</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 7,3.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -7,3.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC5A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    te: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    tf3: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC5A]
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

    def parse (context: CIMContext): ExcIEEEAC5A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC6A model.
 *
 * The model represents field-controlled alternator-rectifier excitation systems with system-supplied electronic voltage regulators.  The maximum output of the regulator, <i>V</i><i><sub>R</sub></i>, is a function of terminal voltage, <i>V</i><i><sub>T</sub></i>. The field current limiter included in the original model AC6A remains in the 2005 update.
 * Reference: IEEE 421.5-2005, 6.6.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 536.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,173.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 1,91.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1,6.
 * @param kh Exciter field current limiter gain (<i>K</i><i><sub>H</sub></i>) (&gt;= 0).
 *        Typical value = 92.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>])</i> (&gt;= 0).
 *        Typical value = 0,214.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,044.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0,086.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 9.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 3.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param th Exciter field current limiter time constant (<i>T</i><i><sub>H</sub></i>) (&gt; 0).
 *        Typical value = 0,08.
 * @param tj Exciter field current limiter time constant (<i>T</i><i><sub>J</sub></i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param tk Voltage regulator time constant (<i>T</i><i><sub>K</sub></i>) (&gt;= 0).
 *        Typical value = 0,18.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 75.
 * @param vamin Minimum voltage regulator output (V<sub>AMIN</sub>) (&lt; 0).
 *        Typical value = -75.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 7,4.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 5,55.
 * @param vfelim Exciter field current limit reference (<i>V</i><i><sub>FELIM</sub></i>) (&gt; 0).
 *        Typical value = 19.
 * @param vhmax Maximum field current limiter signal reference (<i>V</i><i><sub>HMAX</sub></i>) (&gt; 0).
 *        Typical value = 75.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 44.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -36.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC6A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kh: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    th: Double = 0.0,
    tj: Double = 0.0,
    tk: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vfelim: Double = 0.0,
    vhmax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC6A]
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

    def parse (context: CIMContext): ExcIEEEAC6A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC7B model.
 *
 * The model represents excitation systems which consist of an AC alternator with either stationary or rotating rectifiers to produce the DC field requirements. It is an upgrade to earlier AC excitation systems, which replace only the controls but retain the AC alternator and diode rectifier bridge.
 * Reference: IEEE 421.5-2005, 6.7. Note, however, that in IEEE 421.5-2005, the [1 / <i>sT</i><i><sub>E</sub></i>] block is shown as [1 / (1 + <i>sT</i><i><sub>E</sub></i>)], which is incorrect.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,18.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param kdr Voltage regulator derivative gain (<i>K</i><i><sub>DR</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf1 Excitation control system stabilizer gain (<i>K</i><i><sub>F1</sub></i>) (&gt;= 0).
 *        Typical value = 0,212.
 * @param kf2 Excitation control system stabilizer gain (<i>K</i><i><sub>F2</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param kf3 Excitation control system stabilizer gain (<i>K</i><i><sub>F3</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param kia Voltage regulator integral gain (<i>K</i><i><sub>IA</sub></i>) (&gt;= 0).
 *        Typical value = 59,69.
 * @param kir Voltage regulator integral gain (<i>K</i><i><sub>IR</sub></i>) (&gt;= 0).
 *        Typical value = 4,24.
 * @param kl Exciter field voltage lower limit parameter (<i>K</i><i><sub>L</sub></i>).
 *        Typical value = 10.
 * @param kp Potential circuit gain coefficient (<i>K</i><i><sub>P</sub></i>) (&gt; 0).
 *        Typical value = 4,96.
 * @param kpa Voltage regulator proportional gain (<i>K</i><i><sub>PA</sub></i>) (&gt; 0 if ExcIEEEAC7B.kia = 0).
 *        Typical value = 65,36.
 * @param kpr Voltage regulator proportional gain (<i>K</i><i><sub>PR</sub></i>) (&gt; 0 if ExcIEEEAC7B.kir = 0).
 *        Typical value = 4,24.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,44.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,075.
 * @param tdr Lag time constant (<i>T</i><i><sub>DR</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 1,1.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -0,95.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 6,3.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 3,02.
 * @param vemin Minimum exciter voltage output (<i>V</i><i><sub>EMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vfemax Exciter field current limit reference (<i>V</i><i><sub>FEMAX</sub></i>).
 *        Typical value = 6,9.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 5,79.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -5,79.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC7B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kc: Double = 0.0,
    kd: Double = 0.0,
    kdr: Double = 0.0,
    ke: Double = 0.0,
    kf1: Double = 0.0,
    kf2: Double = 0.0,
    kf3: Double = 0.0,
    kia: Double = 0.0,
    kir: Double = 0.0,
    kl: Double = 0.0,
    kp: Double = 0.0,
    kpa: Double = 0.0,
    kpr: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    tdr: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vemin: Double = 0.0,
    vfemax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC7B]
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

    def parse (context: CIMContext): ExcIEEEAC7B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type AC8B model.
 *
 * This model represents a PID voltage regulator with either a brushless exciter or DC exciter. The AVR in this model consists of PID control, with separate constants for the proportional (<i>K</i><i><sub>PR</sub></i>), integral (<i>K</i><i><sub>IR</sub></i>), and derivative (<i>K</i><i><sub>DR</sub></i>) gains. The representation of the brushless exciter (<i>T</i><i><sub>E</sub></i>, <i>K</i><i><sub>E</sub></i>, <i>S</i><i><sub>E</sub></i>, <i>K</i><i><sub>C</sub></i>, <i>K</i><i><sub>D</sub></i>) is similar to the model type AC2A. The type AC8B model can be used to represent static voltage regulators applied to brushless excitation systems. Digitally based voltage regulators feeding DC rotating main exciters can be represented with the AC type AC8B model with the parameters <i>K</i><i><sub>C</sub></i> and <i>K</i><i><sub>D</sub></i> set to 0.  For thyristor power stages fed from the generator terminals, the limits <i>V</i><i><sub>RMAX</sub></i> and <i>V</i><i><sub>RMIN</sub></i><i> </i>should be a function of terminal voltage: V<i><sub>T</sub></i> x <i>V</i><i><sub>RMAX</sub></i><sub> </sub>and <i>V</i><i><sub>T</sub></i> x <i>V</i><i><sub>RMIN</sub></i>.
 * Reference: IEEE 421.5-2005, 6.8.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,55.
 * @param kd Demagnetizing factor, a function of exciter alternator reactances (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 1,1.
 * @param kdr Voltage regulator derivative gain (<i>K</i><i><sub>DR</sub></i>) (&gt;= 0).
 *        Typical value = 10.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kir Voltage regulator integral gain (<i>K</i><i><sub>IR</sub></i>) (&gt;= 0).
 *        Typical value = 5.
 * @param kpr Voltage regulator proportional gain (<i>K</i><i><sub>PR</sub></i>) (&gt; 0 if ExcIEEEAC8B.kir = 0).
 *        Typical value = 80.
 * @param seve1 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E1</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param seve2 Exciter saturation function value at the corresponding exciter voltage, <i>V</i><i><sub>E2</sub></i>, back of commutating reactance (<i>S</i><i><sub>E</sub></i><i>[V</i><i><sub>E2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tdr Lag time constant (<i>T</i><i><sub>DR</sub></i>) (&gt; 0).
 *        Typical value = 0,1.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 1,2.
 * @param ve1 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E1</sub></i>) (&gt; 0).
 *        Typical value = 6,5.
 * @param ve2 Exciter alternator output voltages back of commutating reactance at which saturation is defined (<i>V</i><i><sub>E2</sub></i>) (&gt; 0).
 *        Typical value = 9.
 * @param vemin Minimum exciter voltage output (<i>V</i><i><sub>EMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vfemax Exciter field current limit reference (<i>V</i><i><sub>FEMAX</sub></i>).
 *        Typical value = 6.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 35.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEAC8B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    kdr: Double = 0.0,
    ke: Double = 0.0,
    kir: Double = 0.0,
    kpr: Double = 0.0,
    seve1: Double = 0.0,
    seve2: Double = 0.0,
    ta: Double = 0.0,
    tdr: Double = 0.0,
    te: Double = 0.0,
    ve1: Double = 0.0,
    ve2: Double = 0.0,
    vemin: Double = 0.0,
    vfemax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEAC8B]
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

    def parse (context: CIMContext): ExcIEEEAC8B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type DC1A model.
 *
 * This model represents field-controlled DC commutator exciters with continuously acting voltage regulators (especially the direct-acting rheostatic, rotating amplifier, and magnetic amplifier types).  Because this model has been widely implemented by the industry, it is sometimes used to represent other types of systems when detailed data for them are not available or when a simplified model is required.
 * Reference: IEEE 421.5-2005, 5.1.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD1</sub></i>) (&gt; 0).
 *        Typical value = 3,1.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD2</sub></i>) (&gt; 0).
 *        Typical value = 2,3.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 *        true = a lower limit of zero is applied to integrator output
 *        false = a lower limit of zero is not applied to integrator output.
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 46.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 0.
 * @param kf Excitation control system stabilizer gain (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0.1.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD1</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0.33.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD2</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,06.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,46.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param uelin UEL input (<i>uelin</i>).
 *        true = input is connected to the HV gate
 *        false = input connects to the error signal.
 *        Typical value = true.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; ExcIEEEDC1A.vrmin).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0 and &lt; ExcIEEEDC1A.vrmax).
 *        Typical value = -0,9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEDC1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    exclim: Boolean = false,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    uelin: Boolean = false,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEDC1A]
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

    def parse (context: CIMContext): ExcIEEEDC1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type DC2A model.
 *
 * This model represents field-controlled DC commutator exciters with continuously acting voltage regulators having supplies obtained from the generator or auxiliary bus.  It differs from the type DC1A model only in the voltage regulator output limits, which are now proportional to terminal voltage <i>V</i><i><sub>T</sub></i>.
 * It is representative of solid-state replacements for various forms of older mechanical and rotating amplifier regulating equipment connected to DC commutator exciters.
 * Reference: IEEE 421.5-2005, 5.2.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD1</sub></i>) (&gt; 0).
 *        Typical value = 3,05.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD2</sub></i>) (&gt; 0).
 *        Typical value = 2,29.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output. Typical value = - 999  which means that there is no limit applied.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 300.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gain (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD1</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,279.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD2</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,117.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,01.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 1,33.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt; 0).
 *        Typical value = 0,675.
 * @param uelin UEL input (<i>uelin</i>).
 *        true = input is connected to the HV gate
 *        false = input connects to the error signal.
 *        Typical value = true.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>)(&gt; ExcIEEEDC2A.vrmin).
 *        Typical value = 4,95.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0 and &lt; ExcIEEEDC2A.vrmax).
 *        Typical value = -4,9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEDC2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    exclim: Double = 0.0,
    ka: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    uelin: Boolean = false,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEDC2A]
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

    def parse (context: CIMContext): ExcIEEEDC2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type DC3A model.
 *
 * This model represents older systems, in particular those DC commutator exciters with non-continuously acting regulators that were commonly used before the development of the continuously acting varieties.  These systems respond at basically two different rates, depending upon the magnitude of voltage error. For small errors, adjustment is made periodically with a signal to a motor-operated rheostat. Larger errors cause resistors to be quickly shorted or inserted and a strong forcing signal applied to the exciter. Continuous motion of the motor-operated rheostat occurs for these larger error signals, even though it is bypassed by contactor action.
 * Reference: IEEE 421.5-2005, 5.3.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD1</sub></i>) (&gt; 0).
 *        Typical value = 3,375.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD2</sub></i>) (&gt; 0).
 *        Typical value = 3,15.
 * @param exclim (<i>exclim</i>).
 *        IEEE standard is ambiguous about lower limit on exciter output.
 *        true = a lower limit of zero is applied to integrator output
 *        false = a lower limit of zero is not applied to integrator output.
 *        Typical value = true.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 0,05.
 * @param kv Fast raise/lower contact setting (<i>K</i><i><sub>V</sub></i>) (&gt; 0).
 *        Typical value = 0,05.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD1</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,267.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD2</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,068.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param trh Rheostat travel time (<i>T</i><i><sub>RH</sub></i>) (&gt; 0).
 *        Typical value = 20.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEDC3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    exclim: Boolean = false,
    ke: Double = 0.0,
    kv: Double = 0.0,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    te: Double = 0.0,
    trh: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEDC3A]
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

    def parse (context: CIMContext): ExcIEEEDC3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type DC4B model.
 *
 * These excitation systems utilize a field-controlled DC commutator exciter with a continuously acting voltage regulator having supplies obtained from the generator or auxiliary bus.
 * Reference: IEEE 421.5-2005, 5.4.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efd1 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD1</sub></i>) (&gt; 0).
 *        Typical value = 1,75.
 * @param efd2 Exciter voltage at which exciter saturation is defined (<i>E</i><i><sub>FD2</sub></i>) (&gt; 0).
 *        Typical value = 2,33.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param kd Regulator derivative gain (<i>K</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 20.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gain (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ki Regulator integral gain (<i>K</i><i><sub>I</sub></i>) (&gt;= 0).
 *        Typical value = 20.
 * @param kp Regulator proportional gain (<i>K</i><i><sub>P</sub></i>) (&gt;= 0).
 *        Typical value = 20.
 * @param oelin OEL input (<i>OELin</i>).
 *        true = LV gate
 *        false = subtract from error signal.
 *        Typical value = true.
 * @param seefd1 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD1</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD1</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param seefd2 Exciter saturation function value at the corresponding exciter voltage, <i>E</i><i><sub>FD2</sub></i> (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>FD2</sub></i><i>]</i>) (&gt;= 0).
 *        Typical value = 0,27.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,2.
 * @param td Regulator derivative filter time constant (<i>T</i><i><sub>D</sub></i>) (&gt; 0 if ExcIEEEDC4B.kd &gt; 0).
 *        Typical value = 0,01.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,8.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param uelin UEL input (<i>UELin</i>).
 *        true = HV gate
 *        false = add to error signal.
 *        Typical value = true.
 * @param vemin Minimum exciter voltage output (<i>V</i><i><sub>EMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; ExcIEEEDC4B.vrmin).
 *        Typical value = 2,7.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt;= 0 and &lt; ExcIEEEDC4B.vrmax).
 *        Typical value = -0,9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEDC4B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efd1: Double = 0.0,
    efd2: Double = 0.0,
    ka: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    oelin: Boolean = false,
    seefd1: Double = 0.0,
    seefd2: Double = 0.0,
    ta: Double = 0.0,
    td: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    uelin: Boolean = false,
    vemin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEDC4B]
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

    def parse (context: CIMContext): ExcIEEEDC4B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST1A model.
 *
 * This model represents systems in which excitation power is supplied through a transformer from the generator terminals (or the unit’s auxiliary bus) and is regulated by a controlled rectifier.  The maximum exciter voltage available from such systems is directly related to the generator terminal voltage.
 * Reference: IEEE 421.5-2005, 7.1.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ilr Exciter output current limit reference (<i>I</i><i><sub>LR</sub></i><i>)</i>.
 *        Typical value = 0.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 190.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param klr Exciter output current limiter gain (<i>K</i><i><sub>LR</sub></i>).
 *        Typical value = 0.
 * @param pssin Selector of the Power System Stabilizer (PSS) input (<i>PSSin</i>).
 *        true = PSS input (<i>Vs</i>) added to error signal
 *        false = PSS input (<i>Vs</i>) added to voltage regulator output.
 *        Typical value = true.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tb1 Voltage regulator time constant (<i>T</i><i><sub>B1</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tc1 Voltage regulator time constant (<i>T</i><i><sub>C1</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param uelin Selector of the connection of the UEL input (<i>UELin</i>).
 *        Typical value = ignoreUELsignal.
 * @param vamax Maximum voltage regulator output (<i>V</i><i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 14,5.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -14,5.
 * @param vimax Maximum voltage regulator input limit (<i>V</i><i><sub>IMAX</sub></i>) (&gt; 0).
 *        Typical value = 999.
 * @param vimin Minimum voltage regulator input limit (<i>V</i><i><sub>IMIN</sub></i>) (&lt; 0).
 *        Typical value = -999.
 * @param vrmax Maximum voltage regulator outputs (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 7,8.
 * @param vrmin Minimum voltage regulator outputs (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -6,7.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ilr: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kf: Double = 0.0,
    klr: Double = 0.0,
    pssin: Boolean = false,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tb1: Double = 0.0,
    tc: Double = 0.0,
    tc1: Double = 0.0,
    tf: Double = 0.0,
    uelin: String = null,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST1A]
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

    def parse (context: CIMContext): ExcIEEEST1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST2A model.
 *
 * Some static systems use both current and voltage sources (generator terminal quantities) to comprise the power source.  The regulator controls the exciter output through controlled saturation of the power transformer components.  These compound-source rectifier excitation systems are designated type ST2A and are represented by ExcIEEEST2A.
 * Reference: IEEE 421.5-2005, 7.2.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Maximum field voltage (<i>E</i><i><sub>FDMax</sub></i>) (&gt;= 0).
 *        Typical value = 99.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 120.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 1,82.
 * @param ke Exciter constant related to self-excited field (<i>K</i><i><sub>E</sub></i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>K</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param ki Potential circuit gain coefficient (<i>K</i><i><sub>I</sub></i>) (&gt;= 0).
 *        Typical value = 8.
 * @param kp Potential circuit gain coefficient (<i>K</i><i><sub>P</sub></i>) (&gt;= 0).
 *        Typical value = 4,88.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt; 0).
 *        Typical value = 0,15.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>T</i><i><sub>E</sub></i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param uelin UEL input (<i>UELin</i>).
 *        true = HV gate
 *        false = add to error signal.
 *        Typical value = true.
 * @param vrmax Maximum voltage regulator outputs (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator outputs (<i>V</i><i><sub>RMIN</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    ta: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    uelin: Boolean = false,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST2A]
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

    def parse (context: CIMContext): ExcIEEEST2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST3A model.
 *
 * Some static systems utilize a field voltage control loop to linearize the exciter control characteristic. This also makes the output independent of supply source variations until supply limitations are reached.  These systems utilize a variety of controlled-rectifier designs: full thyristor complements or hybrid bridges in either series or shunt configurations. The power source can consist of only a potential source, either fed from the machine terminals or from internal windings. Some designs can have compound power sources utilizing both machine potential and current. These power sources are represented as phasor combinations of machine terminal current and voltage and are accommodated by suitable parameters in model type ST3A which is represented by ExcIEEEST3A.
 * Reference: IEEE 421.5-2005, 7.3.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ka Voltage regulator gain (<i>K</i><i><sub>A</sub></i>) (&gt; 0).
 *        This is parameter <i>K</i> in the IEEE standard. Typical value = 200.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>K</i><i><sub>G</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ki Potential circuit gain coefficient (<i>K</i><i><sub>I</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param km Forward gain constant of the inner loop field regulator (<i>K</i><i><sub>M</sub></i>) (&gt; 0).
 *        Typical value = 7,93.
 * @param kp Potential circuit gain coefficient (<i>K</i><i><sub>P</sub></i>) (&gt; 0).
 *        Typical value = 6,15.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tb Voltage regulator time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tc Voltage regulator time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param thetap Potential circuit phase angle (<i>thetap</i>).
 *        Typical value = 0.
 * @param tm Forward time constant of inner loop field regulator (<i>T</i><i><sub>M</sub></i>) (&gt; 0).
 *        Typical value = 0,4.
 * @param vbmax Maximum excitation voltage (<i>V</i><i><sub>BMax</sub></i>) (&gt; 0).
 *        Typical value = 6,9.
 * @param vgmax Maximum inner loop feedback voltage (<i>V</i><i><sub>GMax</sub></i>) (&gt;= 0).
 *        Typical value = 5,8.
 * @param vimax Maximum voltage regulator input limit (<i>V</i><i><sub>IMAX</sub></i>) (&gt; 0).
 *        Typical value = 0,2.
 * @param vimin Minimum voltage regulator input limit (<i>V</i><i><sub>IMIN</sub></i>) (&lt; 0).
 *        Typical value = -0,2.
 * @param vmmax Maximum inner loop output (<i>V</i><i><sub>MMax</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vmmin Minimum inner loop output (<i>V</i><i><sub>MMin</sub></i>) (&lt;= 0).
 *        Typical value = 0.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 10.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -10.
 * @param xl Reactance associated with potential source (<i>X</i><i><sub>L</sub></i>) (&gt;= 0).
 *        Typical value = 0,081.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    km: Double = 0.0,
    kp: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    thetap: Double = 0.0,
    tm: Double = 0.0,
    vbmax: Double = 0.0,
    vgmax: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vmmax: Double = 0.0,
    vmmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xl: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST3A]
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

    def parse (context: CIMContext): ExcIEEEST3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST4B model.
 *
 * This model is a variation of the type ST3A model, with a proportional plus integral (PI) regulator block replacing the lag-lead regulator characteristic that is in the ST3A model. Both potential and compound source rectifier excitation systems are modelled.  The PI regulator blocks have non-windup limits that are represented. The voltage regulator of this model is typically implemented digitally.
 * Reference: IEEE 421.5-2005, 7.4.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,113.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>K</i><i><sub>G</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ki Potential circuit gain coefficient (<i>K</i><i><sub>I</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param kim Voltage regulator integral gain output (<i>K</i><i><sub>IM</sub></i>).
 *        Typical value = 0.
 * @param kir Voltage regulator integral gain (<i>K</i><i><sub>IR</sub></i>).
 *        Typical value = 10,75.
 * @param kp Potential circuit gain coefficient (<i>K</i><i><sub>P</sub></i>) (&gt; 0).
 *        Typical value = 9,3.
 * @param kpm Voltage regulator proportional gain output (<i>K</i><i><sub>PM</sub></i>).
 *        Typical value = 1.
 * @param kpr Voltage regulator proportional gain (<i>K</i><i><sub>PR</sub></i>).
 *        Typical value = 10,75.
 * @param ta Voltage regulator time constant (<i>T</i><i><sub>A</sub></i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param thetap Potential circuit phase angle (<i>thetap</i>).
 *        Typical value = 0.
 * @param vbmax Maximum excitation voltage (<i>V</i><i><sub>BMax</sub></i>) (&gt; 0).
 *        Typical value = 11,63.
 * @param vmmax Maximum inner loop output (<i>V</i><i><sub>MMax</sub></i>) (&gt; ExcIEEEST4B.vmmin).
 *        Typical value = 99.
 * @param vmmin Minimum inner loop output (<i>V</i><i><sub>MMin</sub></i>) (&lt; ExcIEEEST4B.vmmax).
 *        Typical value = -99.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -0,87.
 * @param xl Reactance associated with potential source (<i>X</i><i><sub>L</sub></i>) (&gt;= 0).
 *        Typical value = 0,124.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST4B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kc: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    kim: Double = 0.0,
    kir: Double = 0.0,
    kp: Double = 0.0,
    kpm: Double = 0.0,
    kpr: Double = 0.0,
    ta: Double = 0.0,
    thetap: Double = 0.0,
    vbmax: Double = 0.0,
    vmmax: Double = 0.0,
    vmmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xl: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST4B]
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

    def parse (context: CIMContext): ExcIEEEST4B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST5B model.
 *
 * The type ST5B excitation system is a variation of the type ST1A model, with alternative overexcitation and underexcitation inputs and additional limits.
 * The block diagram in the IEEE 421.5 standard has input signal <i>Vc </i>and does not indicate the summation point with <i>Vref</i>. The implementation of the ExcIEEEST5B shall consider summation point with <i>Vref</i>.
 * Reference: IEEE 421.5-2005, 7.5.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kc Rectifier regulation factor (<i>K</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 0,004.
 * @param kr Regulator gain (<i>K</i><i><sub>R</sub></i>) (&gt; 0).
 *        Typical value = 200.
 * @param t1 Firing circuit time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 0,004.
 * @param tb1 Regulator lag time constant (<i>T</i><i><sub>B1</sub></i>) (&gt;= 0).
 *        Typical value = 6.
 * @param tb2 Regulator lag time constant (<i>T</i><i><sub>B2</sub></i>) (&gt;= 0).
 *        Typical value = 0,01.
 * @param tc1 Regulator lead time constant (<i>T</i><i><sub>C1</sub></i>) (&gt;= 0).
 *        Typical value = 0,8.
 * @param tc2 Regulator lead time constant (<i>T</i><i><sub>C2</sub></i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param tob1 OEL lag time constant (<i>T</i><i><sub>OB1</sub></i>) (&gt;= 0).
 *        Typical value = 2.
 * @param tob2 OEL lag time constant (<i>T</i><i><sub>OB2</sub></i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param toc1 OEL lead time constant (<i>T</i><i><sub>OC1</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param toc2 OEL lead time constant (<i>T</i><i><sub>OC2</sub></i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param tub1 UEL lag time constant (<i>T</i><i><sub>UB1</sub></i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tub2 UEL lag time constant (<i>T</i><i><sub>UB2</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tuc1 UEL lead time constant (<i>T</i><i><sub>UC1</sub></i>) (&gt;= 0).
 *        Typical value = 2.
 * @param tuc2 UEL lead time constant (<i>T</i><i><sub>UC2</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 5.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -4.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST5B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kc: Double = 0.0,
    kr: Double = 0.0,
    t1: Double = 0.0,
    tb1: Double = 0.0,
    tb2: Double = 0.0,
    tc1: Double = 0.0,
    tc2: Double = 0.0,
    tob1: Double = 0.0,
    tob2: Double = 0.0,
    toc1: Double = 0.0,
    toc2: Double = 0.0,
    tub1: Double = 0.0,
    tub2: Double = 0.0,
    tuc1: Double = 0.0,
    tuc2: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST5B]
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

    def parse (context: CIMContext): ExcIEEEST5B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST6B model.
 *
 * This model consists of a PI voltage regulator with an inner loop field voltage regulator and pre-control. The field voltage regulator implements a proportional control. The pre-control and the delay in the feedback circuit increase the dynamic response.
 * Reference: IEEE 421.5-2005, 7.6.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ilr Exciter output current limit reference (<i>I</i><i><sub>LR</sub></i>) (&gt; 0).
 *        Typical value = 4,164.
 * @param kci Exciter output current limit adjustment (<i>K</i><i><sub>CI</sub></i>) (&gt; 0).
 *        Typical value = 1,0577.
 * @param kff Pre-control gain constant of the inner loop field regulator (<i>K</i><i><sub>FF</sub></i>).
 *        Typical value = 1.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>K</i><i><sub>G</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kia Voltage regulator integral gain (<i>K</i><i><sub>IA</sub></i>) (&gt; 0).
 *        Typical value = 45,094.
 * @param klr Exciter output current limiter gain (<i>K</i><i><sub>LR</sub></i>) (&gt; 0).
 *        Typical value = 17,33.
 * @param km Forward gain constant of the inner loop field regulator (<i>K</i><i><sub>M</sub></i>).
 *        Typical value = 1.
 * @param kpa Voltage regulator proportional gain (<u>K</u><u><sub>PA</sub></u>) (&gt; 0).
 *        Typical value = 18,038.
 * @param oelin OEL input selector (<i>OELin</i>).
 *        Typical value = noOELinput.
 * @param tg Feedback time constant of inner loop field voltage regulator (<i>T</i><i><sub>G</sub></i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param vamax Maximum voltage regulator output (V<i><sub>AMAX</sub></i>) (&gt; 0).
 *        Typical value = 4,81.
 * @param vamin Minimum voltage regulator output (<i>V</i><i><sub>AMIN</sub></i>) (&lt; 0).
 *        Typical value = -3,85.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 4,81.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -3,85.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST6B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ilr: Double = 0.0,
    kci: Double = 0.0,
    kff: Double = 0.0,
    kg: Double = 0.0,
    kia: Double = 0.0,
    klr: Double = 0.0,
    km: Double = 0.0,
    kpa: Double = 0.0,
    oelin: String = null,
    tg: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST6B]
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

    def parse (context: CIMContext): ExcIEEEST6B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * IEEE 421.5-2005 type ST7B model.
 *
 * This model is representative of static potential-source excitation systems. In this system, the AVR consists of a PI voltage regulator. A phase lead-lag filter in series allows the introduction of a derivative function, typically used with brushless excitation systems. In that case, the regulator is of the PID type. In addition, the terminal voltage channel includes a phase lead-lag filter.  The AVR includes the appropriate inputs on its reference for overexcitation limiter (OEL1), underexcitation limiter (UEL), stator current limiter (SCL), and current compensator (DROOP). All these limitations, when they work at voltage reference level, keep the PSS (VS signal from PSS) in operation. However, the UEL limitation can also be transferred to the high value (HV) gate acting on the output signal. In addition, the output signal passes through a low value (LV) gate for a ceiling overexcitation limiter (OEL2).
 * Reference: IEEE 421.5-2005, 7.7.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kh High-value gate feedback gain (<i>K</i><i><sub>H</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kia Voltage regulator integral gain (<i>K</i><i><sub>IA</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kl Low-value gate feedback gain (<i>K</i><i><sub>L</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kpa Voltage regulator proportional gain (<i>K</i><i><sub>PA</sub></i>) (&gt; 0).
 *        Typical value = 40.
 * @param oelin OEL input selector (<i>OELin</i>).
 *        Typical value = noOELinput.
 * @param tb Regulator lag time constant (<i>T</i><i><sub>B</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tc Regulator lead time constant (<i>T</i><i><sub>C</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf Excitation control system stabilizer time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tg Feedback time constant of inner loop field voltage regulator (<i>T</i><i><sub>G</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tia Feedback time constant (<i>T</i><i><sub>IA</sub></i>) (&gt;= 0).
 *        Typical value = 3.
 * @param uelin UEL input selector (<i>UELin</i>).
 *        Typical value = noUELinput.
 * @param vmax Maximum voltage reference signal (<i>V</i><i><sub>MAX</sub></i>) (&gt; 0 and &gt; ExcIEEEST7B.vmin).
 *        Typical value = 1,1.
 * @param vmin Minimum voltage reference signal (<i>V</i><i><sub>MIN</sub></i>) (&gt; 0 and &lt; ExcIEEEST7B.vmax).
 *        Typical value = 0,9.
 * @param vrmax Maximum voltage regulator output (<i>V</i><i><sub>RMAX</sub></i>) (&gt; 0).
 *        Typical value = 5.
 * @param vrmin Minimum voltage regulator output (<i>V</i><i><sub>RMIN</sub></i>) (&lt; 0).
 *        Typical value = -4,5.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcIEEEST7B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kh: Double = 0.0,
    kia: Double = 0.0,
    kl: Double = 0.0,
    kpa: Double = 0.0,
    oelin: String = null,
    tb: Double = 0.0,
    tc: Double = 0.0,
    tf: Double = 0.0,
    tg: Double = 0.0,
    tia: Double = 0.0,
    uelin: String = null,
    vmax: Double = 0.0,
    vmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcIEEEST7B]
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

    def parse (context: CIMContext): ExcIEEEST7B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Bus or solid fed SCR (silicon-controlled rectifier) bridge excitation system model type NI (NVE).
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param busFedSelector Fed by selector (<i>BusFedSelector</i>).
 *        true = bus fed (switch is closed)
 *        false = solid fed (switch is open).
 *        Typical value = true.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 210.
 * @param kf Excitation control system stabilizer gain (<i>Kf</i>) (&gt; 0).
 *        Typical value 0,01.
 * @param r <i>rc</i> / <i>rfd</i> (<i>R</i>) (&gt;= 0).
 *        0 means exciter has negative current capability
 *        &gt; 0 means exciter does not have negative current capability.
 *        Typical value = 5.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,02.
 * @param tf1 Excitation control system stabilizer time constant (<i>Tf1</i>) (&gt; 0).
 *        Typical value = 1,0.
 * @param tf2 Excitation control system stabilizer time constant (<i>Tf2</i>) (&gt; 0).
 *        Typical value = 0,1.
 * @param tr Time constant (<i>Tr</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param vrmax Maximum voltage regulator ouput (<i>Vrmax</i>) (&gt; ExcNI.vrmin).
 *        Typical value = 5,0.
 * @param vrmin Minimum voltage regulator ouput (<i>Vrmin</i>) (&lt; ExcNI.vrmax).
 *        Typical value = -2,0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcNI
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    busFedSelector: Boolean = false,
    ka: Double = 0.0,
    kf: Double = 0.0,
    r: Double = 0.0,
    ta: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    tr: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
        implicit val clz: String = ExcNI.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcNI.fields (position), value)
        emitelem (0, busFedSelector)
        emitelem (1, ka)
        emitelem (2, kf)
        emitelem (3, r)
        emitelem (4, ta)
        emitelem (5, tf1)
        emitelem (6, tf2)
        emitelem (7, tr)
        emitelem (8, vrmax)
        emitelem (9, vrmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcNI rdf:ID=\"%s\">\n%s\t</cim:ExcNI>".format (id, export_fields)
    }
}

object ExcNI
extends
    CIMParseable[ExcNI]
{
    override val fields: Array[String] = Array[String] (
        "busFedSelector",
        "ka",
        "kf",
        "r",
        "ta",
        "tf1",
        "tf2",
        "tr",
        "vrmax",
        "vrmin"
    )
    val busFedSelector: Fielder = parse_element (element (cls, fields(0)))
    val ka: Fielder = parse_element (element (cls, fields(1)))
    val kf: Fielder = parse_element (element (cls, fields(2)))
    val r: Fielder = parse_element (element (cls, fields(3)))
    val ta: Fielder = parse_element (element (cls, fields(4)))
    val tf1: Fielder = parse_element (element (cls, fields(5)))
    val tf2: Fielder = parse_element (element (cls, fields(6)))
    val tr: Fielder = parse_element (element (cls, fields(7)))
    val vrmax: Fielder = parse_element (element (cls, fields(8)))
    val vrmin: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: CIMContext): ExcNI =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExcNI (
            ExcitationSystemDynamics.parse (context),
            toBoolean (mask (busFedSelector (), 0)),
            toDouble (mask (ka (), 1)),
            toDouble (mask (kf (), 2)),
            toDouble (mask (r (), 3)),
            toDouble (mask (ta (), 4)),
            toDouble (mask (tf1 (), 5)),
            toDouble (mask (tf2 (), 6)),
            toDouble (mask (tr (), 7)),
            toDouble (mask (vrmax (), 8)),
            toDouble (mask (vrmin (), 9))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE type ST1 excitation system with semi-continuous and acting terminal voltage limiter.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Saturation parameter (<i>E</i><i><sub>1</sub></i>).
 * @param e2 Saturation parameter (<i>E</i><i><sub>2</sub></i>).
 * @param ka Gain (<i>K</i><i><sub>A</sub></i>).
 * @param kc Gain (<i>K</i><i><sub>C</sub></i>).
 * @param kd Gain (<i>K</i><i><sub>D</sub></i>).
 * @param ke Gain (<i>K</i><i><sub>E</sub></i>).
 * @param kf Gain (<i>K</i><i><sub>F</sub></i>).
 * @param see1 Saturation parameter (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>1</sub></i><i>]</i>).
 * @param see2 Saturation parameter (<i>S</i><i><sub>E</sub></i><i>[E</i><i><sub>2</sub></i><i>]</i>).
 * @param t1 Time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 * @param t2 Time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 * @param t3 Time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 * @param t4 Time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 * @param t5 Time constant (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 * @param t6 Time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 * @param te Time constant (<i>T</i><i><sub>E</sub></i>) (&gt;= 0).
 * @param tf Time constant (<i>T</i><i><sub>F</sub></i>) (&gt;= 0).
 * @param vrmax Limiter (<i>V</i><i><sub>RMAX</sub></i>) (&gt; ExcOEX3T.vrmin).
 * @param vrmin Limiter (<i>V</i><i><sub>RMIN</sub></i>) (&lt; ExcOEX3T.vrmax).
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcOEX3T
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    see1: Double = 0.0,
    see2: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcOEX3T]
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

    def parse (context: CIMContext): ExcOEX3T =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Proportional/integral regulator excitation system.
 *
 * This model can be used to represent excitation systems with a proportional-integral (PI) voltage regulator controller.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Field voltage value 1 (<i>E</i><i><sub>1</sub></i>).
 *        Typical value = 0.
 * @param e2 Field voltage value 2 (<i>E</i><i><sub>2</sub></i>).
 *        Typical value = 0.
 * @param efdmax Exciter maximum limit (<i>E</i><i><sub>fdmax</sub></i>) (&gt; ExcPIC.efdmin).
 *        Typical value = 8.
 * @param efdmin Exciter minimum limit (<i>E</i><i><sub>fdmin</sub></i>) (&lt; ExcPIC.efdmax).
 *        Typical value = -0,87.
 * @param ka PI controller gain (<i>K</i><i><sub>a</sub></i>).
 *        Typical value = 3,15.
 * @param kc Exciter regulation factor (<i>K</i><i><sub>c</sub></i>).
 *        Typical value = 0,08.
 * @param ke Exciter constant (<i>K</i><i><sub>e</sub></i>).
 *        Typical value = 0.
 * @param kf Rate feedback gain (<i>K</i><i><sub>f</sub></i>).
 *        Typical value = 0.
 * @param ki Current source gain (<i>K</i><i><sub>i</sub></i>).
 *        Typical value = 0.
 * @param kp Potential source gain (<i>K</i><i><sub>p</sub></i>).
 *        Typical value = 6,5.
 * @param se1 Saturation factor at <i>E</i><i><sub>1</sub></i> (<i>Se</i><i><sub>1</sub></i>).
 *        Typical value = 0.
 * @param se2 Saturation factor at <i>E</i><i><sub>2</sub></i> (<i>Se</i><i><sub>2</sub></i>).
 *        Typical value = 0.
 * @param ta1 PI controller time constant (<i>T</i><i><sub>a1</sub></i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ta2 Voltage regulator time constant (<i>T</i><i><sub>a2</sub></i>) (&gt;= 0).
 *        Typical value = 0,01.
 * @param ta3 Lead time constant (<i>T</i><i><sub>a3</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ta4 Lag time constant (<i>T</i><i><sub>a4</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant (<i>T</i><i><sub>e</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tf1 Rate feedback time constant (<i>T</i><i><sub>f1</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tf2 Rate feedback lag time constant (<i>T</i><i><sub>f2</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vr1 PI maximum limit (<i>V</i><i><sub>r1</sub></i>).
 *        Typical value = 1.
 * @param vr2 PI minimum limit (<i>V</i><i><sub>r2</sub></i>).
 *        Typical value = -0,87.
 * @param vrmax Voltage regulator maximum limit (<i>V</i><i><sub>rmax</sub></i>) (&gt; ExcPIC.vrmin).
 *        Typical value = 1.
 * @param vrmin Voltage regulator minimum limit (<i>V</i><i><sub>rmin</sub></i>) (&lt; ExcPIC.vrmax).
 *        Typical value = -0,87.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcPIC
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    se1: Double = 0.0,
    se2: Double = 0.0,
    ta1: Double = 0.0,
    ta2: Double = 0.0,
    ta3: Double = 0.0,
    ta4: Double = 0.0,
    te: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    vr1: Double = 0.0,
    vr2: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcPIC]
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

    def parse (context: CIMContext): ExcPIC =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * General purpose rotating excitation system.
 *
 * This model can be used to represent a wide range of excitation systems whose DC power source is an AC or DC generator. It encompasses IEEE type AC1, AC2, DC1, and DC2 excitation system models.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param e1 Field voltage value 1 (<i>E</i><i><sub>1</sub></i>).
 *        Typical value = 3.
 * @param e2 Field voltage value 2 (<i>E</i><i><sub>2</sub></i>).
 *        Typical value = 4.
 * @param fbf Rate feedback signal flag (<i>fbf</i>).
 *        Typical value = fieldCurrent.
 * @param flimf Limit type flag (<i>Flimf</i>).
 *        Typical value = 0.
 * @param kc Rectifier regulation factor (<i>Kc</i>).
 *        Typical value = 0,05.
 * @param kd Exciter regulation factor (<i>Kd</i>).
 *        Typical value = 2.
 * @param ke Exciter field proportional constant (<i>Ke</i>).
 *        Typical value = 1.
 * @param kefd Field voltage feedback gain (<i>Kefd</i>).
 *        Typical value = 0.
 * @param kf Rate feedback gain (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param kh Field voltage controller feedback gain (<i>Kh</i>).
 *        Typical value = 0.
 * @param kii Field current regulator integral gain (<i>Kii</i>).
 *        Typical value = 0.
 * @param kip Field current regulator proportional gain (<i>Kip</i>).
 *        Typical value = 1.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param kvi Voltage regulator integral gain (<i>Kvi</i>).
 *        Typical value = 0.
 * @param kvp Voltage regulator proportional gain (<i>Kvp</i>).
 *        Typical value = 2800.
 * @param kvphz V/Hz limiter gain (<i>Kvphz</i>).
 *        Typical value = 0.
 * @param nvphz Pickup speed of V/Hz limiter (<i>Nvphz</i>).
 *        Typical value = 0.
 * @param se1 Saturation factor at <i>E</i><i><sub>1</sub></i><i> </i>(<i>Se</i><i><sub>1</sub></i>).
 *        Typical value = 0,0001.
 * @param se2 Saturation factor at <i>E</i><i><sub>2</sub></i> (<i>Se</i><i><sub>2</sub></i>).
 *        Typical value = 0,001.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,01.
 * @param tb1 Lag time constant (<i>Tb1</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0.
 * @param tb2 Lag time constant (<i>Tb2</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0.
 * @param tc1 Lead time constant (<i>Tc1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc2 Lead time constant (<i>Tc2</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter field time constant (<i>Te</i>) (&gt; 0).
 *        Typical value = 1,2.
 * @param tf Rate feedback time constant (<i>Tf</i>) (&gt;= 0).
 *        If = 0, the feedback path is not used.  Typical value = 1.
 * @param tf1 Feedback lead time constant (<i>Tf1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tf2 Feedback lag time constant (<i>Tf2</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0.
 * @param tp Field current bridge time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vcmax Maximum compounding voltage (<i>Vcmax</i>).
 *        Typical value = 0.
 * @param vfmax Maximum exciter field current (<i>Vfmax</i>) (&gt; ExcREXS.vfmin).
 *        Typical value = 47.
 * @param vfmin Minimum exciter field current (<i>Vfmin</i>) (&lt; ExcREXS.vfmax).
 *        Typical value = -20.
 * @param vimax Voltage regulator input limit (<i>Vimax</i>).
 *        Typical value = 0,1.
 * @param vrmax Maximum controller output (V<i>rmax</i>) (&gt; ExcREXS.vrmin).
 *        Typical value = 47.
 * @param vrmin Minimum controller output (<i>Vrmin</i>) (&lt; ExcREXS.vrmax).
 *        Typical value = -20.
 * @param xc Exciter compounding reactance (<i>Xc</i>).
 *        Typical value = 0.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcREXS
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    e1: Double = 0.0,
    e2: Double = 0.0,
    fbf: String = null,
    flimf: Double = 0.0,
    kc: Double = 0.0,
    kd: Double = 0.0,
    ke: Double = 0.0,
    kefd: Double = 0.0,
    kf: Double = 0.0,
    kh: Double = 0.0,
    kii: Double = 0.0,
    kip: Double = 0.0,
    ks: Double = 0.0,
    kvi: Double = 0.0,
    kvp: Double = 0.0,
    kvphz: Double = 0.0,
    nvphz: Double = 0.0,
    se1: Double = 0.0,
    se2: Double = 0.0,
    ta: Double = 0.0,
    tb1: Double = 0.0,
    tb2: Double = 0.0,
    tc1: Double = 0.0,
    tc2: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    tp: Double = 0.0,
    vcmax: Double = 0.0,
    vfmax: Double = 0.0,
    vfmin: Double = 0.0,
    vimax: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xc: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcREXS]
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

    def parse (context: CIMContext): ExcREXS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
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
 * Excitation system type RQB (four-loop regulator, r?gulateur quatre boucles, developed in France) primarily used in nuclear or thermal generating units.
 *
 * This excitation system shall be always used together with power system stabilizer type PssRQB.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ki0 Voltage reference input gain (<i>Ki0</i>).
 *        Typical value = 12,7.
 * @param ki1 Voltage input gain (<i>Ki1</i>).
 *        Typical value = -16,8.
 * @param klir OEL input gain (<i>KLIR</i>).
 *        Typical value = 12,13.
 * @param klus Limiter gain (<i>KLUS</i>).
 *        Typical value = 50.
 * @param lsat Integrator limiter (<i>LSAT</i>).
 *        Typical value = 5,73.
 * @param lus Setpoint (<i>LUS</i>).
 *        Typical value = 0,12.
 * @param mesu Voltage input time constant (<i>MESU</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param t4m Input time constant (<i>T4M</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param tc Lead lag time constant (<i>TC</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param te Lead lag time constant (<i>TE</i>) (&gt;= 0).
 *        Typical value = 0,22.
 * @param tf Exciter time constant (<i>TF</i>) (&gt;= 0).
 *        Typical value = 0,01.
 * @param ucmax Maximum voltage reference limit (<i>UCMAX</i>) (&gt; ExcRQB.ucmin).
 *        Typical value = 1,1.
 * @param ucmin Minimum voltage reference limit (<i>UCMIN</i>) (&lt; ExcRQB.ucmax).
 *        Typical value = 0,9.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcRQB
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ki0: Double = 0.0,
    ki1: Double = 0.0,
    klir: Double = 0.0,
    klus: Double = 0.0,
    lsat: Double = 0.0,
    lus: Double = 0.0,
    mesu: Double = 0.0,
    t4m: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    ucmax: Double = 0.0,
    ucmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
        implicit val clz: String = ExcRQB.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ExcRQB.fields (position), value)
        emitelem (0, ki0)
        emitelem (1, ki1)
        emitelem (2, klir)
        emitelem (3, klus)
        emitelem (4, lsat)
        emitelem (5, lus)
        emitelem (6, mesu)
        emitelem (7, t4m)
        emitelem (8, tc)
        emitelem (9, te)
        emitelem (10, tf)
        emitelem (11, ucmax)
        emitelem (12, ucmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ExcRQB rdf:ID=\"%s\">\n%s\t</cim:ExcRQB>".format (id, export_fields)
    }
}

object ExcRQB
extends
    CIMParseable[ExcRQB]
{
    override val fields: Array[String] = Array[String] (
        "ki0",
        "ki1",
        "klir",
        "klus",
        "lsat",
        "lus",
        "mesu",
        "t4m",
        "tc",
        "te",
        "tf",
        "ucmax",
        "ucmin"
    )
    val ki0: Fielder = parse_element (element (cls, fields(0)))
    val ki1: Fielder = parse_element (element (cls, fields(1)))
    val klir: Fielder = parse_element (element (cls, fields(2)))
    val klus: Fielder = parse_element (element (cls, fields(3)))
    val lsat: Fielder = parse_element (element (cls, fields(4)))
    val lus: Fielder = parse_element (element (cls, fields(5)))
    val mesu: Fielder = parse_element (element (cls, fields(6)))
    val t4m: Fielder = parse_element (element (cls, fields(7)))
    val tc: Fielder = parse_element (element (cls, fields(8)))
    val te: Fielder = parse_element (element (cls, fields(9)))
    val tf: Fielder = parse_element (element (cls, fields(10)))
    val ucmax: Fielder = parse_element (element (cls, fields(11)))
    val ucmin: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: CIMContext): ExcRQB =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ExcRQB (
            ExcitationSystemDynamics.parse (context),
            toDouble (mask (ki0 (), 0)),
            toDouble (mask (ki1 (), 1)),
            toDouble (mask (klir (), 2)),
            toDouble (mask (klus (), 3)),
            toDouble (mask (lsat (), 4)),
            toDouble (mask (lus (), 5)),
            toDouble (mask (mesu (), 6)),
            toDouble (mask (t4m (), 7)),
            toDouble (mask (tc (), 8)),
            toDouble (mask (te (), 9)),
            toDouble (mask (tf (), 10)),
            toDouble (mask (ucmax (), 11)),
            toDouble (mask (ucmin (), 12))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simple excitation system with generic characteristics typical of many excitation systems; intended for use where negative field current could be a problem.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param cswitch Power source switch (<i>Cswitch</i>).
 *        true = fixed voltage of 1.0 PU
 *        false = generator terminal voltage.
 * @param emax Maximum field voltage output (<i>Emax</i>) (&gt; ExcSCRX.emin).
 *        Typical value = 5.
 * @param emin Minimum field voltage output (<i>Emin</i>) (&lt; ExcSCRX.emax).
 *        Typical value = 0.
 * @param k Gain (<i>K</i>) (&gt; 0).
 *        Typical value = 200.
 * @param rcrfd Ratio of field discharge resistance to field winding resistance ([<i>rc / rfd]</i>).
 *        Typical value = 0.
 * @param tatb Gain reduction ratio of lag-lead element ([<i>Ta</i> / <i>Tb</i>]).
 *        The parameter <i>Ta</i> is not defined explicitly.  Typical value = 0.1.
 * @param tb Denominator time constant of lag-lead block (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param te Time constant of gain block (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,02.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcSCRX
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    cswitch: Boolean = false,
    emax: Double = 0.0,
    emin: Double = 0.0,
    k: Double = 0.0,
    rcrfd: Double = 0.0,
    tatb: Double = 0.0,
    tb: Double = 0.0,
    te: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcSCRX]
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

    def parse (context: CIMContext): ExcSCRX =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Simplified excitation system.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Field voltage clipping maximum limit (<i>Efdmax</i>) (&gt; ExcSEXS.efdmin).
 *        Typical value = 5.
 * @param efdmin Field voltage clipping minimum limit (<i>Efdmin</i>) (&lt; ExcSEXS.efdmax).
 *        Typical value = -5.
 * @param emax Maximum field voltage output (<i>Emax</i>) (&gt; ExcSEXS.emin).
 *        Typical value = 5.
 * @param emin Minimum field voltage output (<i>Emin</i>) (&lt; ExcSEXS.emax).
 *        Typical value = -5.
 * @param k Gain (<i>K</i>) (&gt; 0).
 *        Typical value = 100.
 * @param kc PI controller gain (<i>Kc</i>) (&gt; 0 if ExcSEXS.tc &gt; 0).
 *        Typical value = 0,08.
 * @param tatb Gain reduction ratio of lag-lead element (<i>[Ta / Tb]</i>).
 *        Typical value = 0,1.
 * @param tb Denominator time constant of lag-lead block (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tc PI controller phase lead time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Time constant of gain block (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,05.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcSEXS
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    emax: Double = 0.0,
    emin: Double = 0.0,
    k: Double = 0.0,
    kc: Double = 0.0,
    tatb: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcSEXS]
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

    def parse (context: CIMContext): ExcSEXS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Slovakian excitation system.
 *
 * UEL and secondary voltage control are included in this model. When this model is used, there cannot be a separate underexcitation limiter or VAr controller model.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Field voltage clipping upper level limit (<i>Efdmax</i>) (&gt; ExcSK.efdmin).
 * @param efdmin Field voltage clipping lower level limit (<i>Efdmin</i>) (&lt; ExcSK.efdmax).
 * @param emax Maximum field voltage output (<i>Emax</i>) (&gt; ExcSK.emin).
 *        Typical value = 20.
 * @param emin Minimum field voltage output (<i>Emin</i>) (&lt; ExcSK.emax).
 *        Typical value = -20.
 * @param k Gain (<i>K</i>).
 *        Typical value = 1.
 * @param k1 Parameter of underexcitation limit (<i>K1</i>).
 *        Typical value = 0,1364.
 * @param k2 Parameter of underexcitation limit (<i>K2</i>).
 *        Typical value = -0,3861.
 * @param kc PI controller gain (<i>Kc</i>).
 *        Typical value = 70.
 * @param kce Rectifier regulation factor (<i>Kce</i>).
 *        Typical value = 0.
 * @param kd Exciter internal reactance (<i>Kd</i>).
 *        Typical value = 0.
 * @param kgob P controller gain (<i>Kgob</i>).
 *        Typical value = 10.
 * @param kp PI controller gain (<i>Kp</i>).
 *        Typical value = 1.
 * @param kqi PI controller gain of integral component (<i>Kqi</i>).
 *        Typical value = 0.
 * @param kqob Rate of rise of the reactive power (<i>Kqob</i>).
 * @param kqp PI controller gain (<i>Kqp</i>).
 *        Typical value = 0.
 * @param nq Deadband of reactive power (<i>nq</i>).
 *        Determines the range of sensitivity.  Typical value = 0,001.
 * @param qconoff Secondary voltage control state (<i>Qc_on_off</i>).
 *        true = secondary voltage control is on
 *        false = secondary voltage control is off.
 *        Typical value = false.
 * @param qz Desired value (setpoint) of reactive power, manual setting (<i>Qz</i>).
 * @param remote Selector to apply automatic calculation in secondary controller model (<i>remote</i>).
 *        true = automatic calculation is activated
 *        false = manual set is active; the use of desired value of reactive power (<i>Qz</i>) is required.
 *        Typical value = true.
 * @param sbase Apparent power of the unit (<i>Sbase</i>) (&gt; 0).
 *        Unit = MVA.  Typical value = 259.
 * @param tc PI controller phase lead time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 8.
 * @param te Time constant of gain block (<i>Te</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param ti PI controller phase lead time constant (<i>Ti</i>) (&gt;= 0).
 *        Typical value = 2.
 * @param tp Time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tr Voltage transducer time constant (<i>Tr</i>) (&gt;= 0).
 *        Typical value = 0,01.
 * @param uimax Maximum error (<i>UImax</i>) (&gt; ExcSK.uimin).
 *        Typical value = 10.
 * @param uimin Minimum error (<i>UImin</i>) (&lt; ExcSK.uimax).
 *        Typical value = -10.
 * @param urmax Maximum controller output (<i>URmax</i>) (&gt; ExcSK.urmin).
 *        Typical value = 10.
 * @param urmin Minimum controller output (<i>URmin</i>) (&lt; ExcSK.urmax).
 *        Typical value = -10.
 * @param vtmax Maximum terminal voltage input (<i>Vtmax</i>) (&gt; ExcSK.vtmin).
 *        Determines the range of voltage deadband.  Typical value = 1,05.
 * @param vtmin Minimum terminal voltage input (<i>Vtmin</i>) (&lt; ExcSK.vtmax).
 *        Determines the range of voltage deadband.  Typical value = 0,95.
 * @param yp Maximum output (<i>Yp</i>).
 *        Typical value = 1.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcSK
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    efdmin: Double = 0.0,
    emax: Double = 0.0,
    emin: Double = 0.0,
    k: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    kc: Double = 0.0,
    kce: Double = 0.0,
    kd: Double = 0.0,
    kgob: Double = 0.0,
    kp: Double = 0.0,
    kqi: Double = 0.0,
    kqob: Double = 0.0,
    kqp: Double = 0.0,
    nq: Double = 0.0,
    qconoff: Boolean = false,
    qz: Double = 0.0,
    remote: Boolean = false,
    sbase: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    ti: Double = 0.0,
    tp: Double = 0.0,
    tr: Double = 0.0,
    uimax: Double = 0.0,
    uimin: Double = 0.0,
    urmax: Double = 0.0,
    urmin: Double = 0.0,
    vtmax: Double = 0.0,
    vtmin: Double = 0.0,
    yp: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcSK]
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

    def parse (context: CIMContext): ExcSK =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ilr Exciter output current limit reference (<i>Ilr</i>).
 *        Typical value = 0.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 190.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param kf Excitation control system stabilizer gains (<i>Kf</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param klr Exciter output current limiter gain (<i>Klr</i>).
 *        Typical value = 0.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tb1 Voltage regulator time constant (<i>Tb1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tc1 Voltage regulator time constant (<i>Tc1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param vamax Maximum voltage regulator output (<i>Vamax</i>) (&gt; 0).
 *        Typical value = 999.
 * @param vamin Minimum voltage regulator output (<i>Vamin</i>) (&lt; 0).
 *        Typical value = -999.
 * @param vimax Maximum voltage regulator input limit (<i>Vimax</i>) (&gt; 0).
 *        Typical value = 999.
 * @param vimin Minimum voltage regulator input limit (<i>Vimin</i>) (&lt; 0).
 *        Typical value = -999.
 * @param vrmax Maximum voltage regulator outputs (<i>Vrmax</i>) (&gt; 0) .
 *        Typical value = 7,8.
 * @param vrmin Minimum voltage regulator outputs (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -6,7.
 * @param xe Excitation xfmr effective reactance (<i>Xe</i>).
 *        Typical value = 0,04.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST1A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ilr: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    kf: Double = 0.0,
    klr: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tb1: Double = 0.0,
    tc: Double = 0.0,
    tc1: Double = 0.0,
    tf: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xe: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST1A]
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

    def parse (context: CIMContext): ExcST1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Modified IEEE ST2A static excitation system with another lead-lag block added to match the model defined by WECC.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Maximum field voltage (<i>Efdmax</i>) (&gt;= 0).
 *        Typical value = 99.
 * @param ka Voltage regulator gain (<i>Ka</i>) (&gt; 0).
 *        Typical value = 120.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 1,82.
 * @param ke Exciter constant related to self-excited field (<i>Ke</i>).
 *        Typical value = 1.
 * @param kf Excitation control system stabilizer gains (<i>kf</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param ki Potential circuit gain coefficient (<i>K</i><i><sub>i</sub></i>) (&gt;= 0).
 *        Typical value = 8.
 * @param kp Potential circuit gain coefficient (<i>K</i><i><sub>p</sub></i>) (&gt;= 0).
 *        Typical value = 4,88.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,15.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param te Exciter time constant, integration rate associated with exciter control (<i>Te</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0,7.
 * @param uelin UEL input (<i>UELin</i>).
 *        true = HV gate
 *        false = add to error signal.
 *        Typical value = false.
 * @param vrmax Maximum voltage regulator outputs (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator outputs (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -1.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST2A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    ka: Double = 0.0,
    kc: Double = 0.0,
    ke: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    te: Double = 0.0,
    tf: Double = 0.0,
    uelin: Boolean = false,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST2A]
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

    def parse (context: CIMContext): ExcST2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param efdmax Maximum AVR output (<i>Efdmax</i>) (&gt;= 0).
 *        Typical value = 6,9.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 1,1.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>Kg</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param ki Potential circuit gain coefficient (<i>K</i><i><sub>i</sub></i>) (&gt;= 0).
 *        Typical value = 4,83.
 * @param kj AVR gain (<i>Kj</i>) (&gt; 0).
 *        Typical value = 200.
 * @param km Forward gain constant of the inner loop field regulator (<i>Km</i>) (&gt; 0).
 *        Typical value = 7,04.
 * @param kp Potential source gain (<i>K</i><i><sub>p</sub></i>) (&gt; 0).
 *        Typical value = 4,37.
 * @param ks Coefficient to allow different usage of the model-speed coefficient (<i>Ks</i>).
 *        Typical value = 0.
 * @param ks1 Coefficient to allow different usage of the model-speed coefficient (<i>Ks1</i>).
 *        Typical value = 0.
 * @param tb Voltage regulator time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 6,67.
 * @param tc Voltage regulator time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param thetap Potential circuit phase angle (<i>theta</i><i><sub>p</sub></i>).
 *        Typical value = 20.
 * @param tm Forward time constant of inner loop field regulator (<i>Tm</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vbmax Maximum excitation voltage (<i>Vbmax</i>) (&gt; 0).
 *        Typical value = 8,63.
 * @param vgmax Maximum inner loop feedback voltage (<i>Vgmax</i>) (&gt;= 0).
 *        Typical value = 6,53.
 * @param vimax Maximum voltage regulator input limit (<i>Vimax</i>) (&gt; 0).
 *        Typical value = 0,2.
 * @param vimin Minimum voltage regulator input limit (<i>Vimin</i>) (&lt; 0).
 *        Typical value = -0,2.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -1.
 * @param xl Reactance associated with potential source (<i>Xl</i>) (&gt;= 0).
 *        Typical value = 0,09.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST3A
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    efdmax: Double = 0.0,
    kc: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    kj: Double = 0.0,
    km: Double = 0.0,
    kp: Double = 0.0,
    ks: Double = 0.0,
    ks1: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    thetap: Double = 0.0,
    tm: Double = 0.0,
    vbmax: Double = 0.0,
    vgmax: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xl: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST3A]
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

    def parse (context: CIMContext): ExcST3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Modified IEEE ST4B static excitation system with maximum inner loop feedback gain <i>Vgmax</i>.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kc Rectifier loading factor proportional to commutating reactance (<i>Kc</i>) (&gt;= 0).
 *        Typical value = 0,113.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>Kg</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ki Potential circuit gain coefficient (<i>Ki</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param kim Voltage regulator integral gain output (<i>Kim</i>).
 *        Typical value = 0.
 * @param kir Voltage regulator integral gain (<i>Kir</i>).
 *        Typical value = 10,75.
 * @param kp Potential circuit gain coefficient (<i>Kp</i>) (&gt; 0).
 *        Typical value = 9,3.
 * @param kpm Voltage regulator proportional gain output (<i>Kpm</i>).
 *        Typical value = 1.
 * @param kpr Voltage regulator proportional gain (<i>Kpr</i>).
 *        Typical value = 10,75.
 * @param lvgate Selector (<i>LVGate</i>).
 *        true = <i>LVGate</i> is part of the block diagram
 *        false = <i>LVGate</i> is not part of the block diagram.
 *        Typical value = false.
 * @param ta Voltage regulator time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param thetap Potential circuit phase angle (<i>theta</i><i><sub>p</sub></i>).
 *        Typical value = 0.
 * @param uel Selector (<i>UEL</i>).
 *        true = <i>UEL</i> is part of block diagram
 *        false = <i>UEL</i> is not part of block diagram.
 *        Typical value = false.
 * @param vbmax Maximum excitation voltage (<i>Vbmax</i>) (&gt; 0).
 *        Typical value = 11,63.
 * @param vgmax Maximum inner loop feedback voltage (<i>Vgmax</i>) (&gt;= 0).
 *        Typical value = 5,8.
 * @param vmmax Maximum inner loop output (<i>Vmmax</i>) (&gt; ExcST4B.vmmin).
 *        Typical value = 99.
 * @param vmmin Minimum inner loop output (<i>Vmmin</i>) (&lt; ExcST4B.vmmax).
 *        Typical value = -99.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 1.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -0,87.
 * @param xl Reactance associated with potential source (<i>Xl</i>) (&gt;= 0).
 *        Typical value = 0,124.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST4B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kc: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    kim: Double = 0.0,
    kir: Double = 0.0,
    kp: Double = 0.0,
    kpm: Double = 0.0,
    kpr: Double = 0.0,
    lvgate: Boolean = false,
    ta: Double = 0.0,
    thetap: Double = 0.0,
    uel: Boolean = false,
    vbmax: Double = 0.0,
    vgmax: Double = 0.0,
    vmmax: Double = 0.0,
    vmmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xl: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST4B]
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

    def parse (context: CIMContext): ExcST4B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Modified IEEE ST6B static excitation system with PID controller and optional inner feedback loop.
 *
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param ilr Exciter output current limit reference (<i>Ilr</i>) (&gt; 0).
 *        Typical value = 4,164.
 * @param k1 Selector (<i>K1</i>).
 *        true = feedback is from <i>Ifd</i>
 *        false = feedback is not from <i>Ifd</i>.
 *        Typical value = true.
 * @param kcl Exciter output current limit adjustment (<i>Kcl</i>) (&gt; 0).
 *        Typical value = 1,0577.
 * @param kff Pre-control gain constant of the inner loop field regulator (<i>Kff</i>).
 *        Typical value = 1.
 * @param kg Feedback gain constant of the inner loop field regulator (<i>Kg</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kia Voltage regulator integral gain (<i>Kia</i>) (&gt; 0).
 *        Typical value = 45,094.
 * @param klr Exciter output current limit adjustment (<i>Kcl</i>) (&gt; 0).
 *        Typical value = 17,33.
 * @param km Forward gain constant of the inner loop field regulator (<i>Km</i>).
 *        Typical value = 1.
 * @param kpa Voltage regulator proportional gain (<i>Kpa</i>) (&gt; 0).
 *        Typical value = 18,038.
 * @param kvd Voltage regulator derivative gain (<i>Kvd</i>).
 *        Typical value = 0.
 * @param oelin OEL input selector (<i>OELin</i>).
 *        Typical value = noOELinput (corresponds to <i>OELin</i> = 0 on diagram).
 * @param tg Feedback time constant of inner loop field voltage regulator (<i>Tg</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param ts Rectifier firing time constant (<i>Ts</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tvd Voltage regulator derivative gain (<i>Tvd</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vamax Maximum voltage regulator output (<i>Vamax</i>) (&gt; 0).
 *        Typical value = 4,81.
 * @param vamin Minimum voltage regulator output (<i>Vamin</i>) (&lt; 0).
 *        Typical value = -3,85.
 * @param vilim Selector (<i>Vilim</i>).
 *        true = <i>Vimin</i>-<i>Vimax</i> limiter is active
 *        false = <i>Vimin</i>-<i>Vimax</i> limiter is not active.
 *        Typical value = true.
 * @param vimax Maximum voltage regulator input limit (<i>Vimax</i>) (&gt; ExcST6B.vimin).
 *        Typical value = 10.
 * @param vimin Minimum voltage regulator input limit (<i>Vimin</i>) (&lt; ExcST6B.vimax).
 *        Typical value = -10.
 * @param vmult Selector (<i>vmult</i>).
 *        true = multiply regulator output by terminal voltage
 *        false = do not multiply regulator output by terminal voltage.
 *        Typical value = true.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 4,81.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -3,85.
 * @param xc Excitation source reactance (<i>Xc</i>).
 *        Typical value = 0,05.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST6B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    ilr: Double = 0.0,
    k1: Boolean = false,
    kcl: Double = 0.0,
    kff: Double = 0.0,
    kg: Double = 0.0,
    kia: Double = 0.0,
    klr: Double = 0.0,
    km: Double = 0.0,
    kpa: Double = 0.0,
    kvd: Double = 0.0,
    oelin: String = null,
    tg: Double = 0.0,
    ts: Double = 0.0,
    tvd: Double = 0.0,
    vamax: Double = 0.0,
    vamin: Double = 0.0,
    vilim: Boolean = false,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vmult: Boolean = false,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0,
    xc: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST6B]
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

    def parse (context: CIMContext): ExcST6B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Reference to the superclass object.
 * @param kh High-value gate feedback gain (<i>Kh</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kia Voltage regulator integral gain (<i>Kia</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kl Low-value gate feedback gain (<i>Kl</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param kpa Voltage regulator proportional gain (<i>Kpa</i>) (&gt; 0).
 *        Typical value = 40.
 * @param oelin OEL input selector (<i>OELin</i>).
 *        Typical value = noOELinput.
 * @param tb Regulator lag time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tc Regulator lead time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tf Excitation control system stabilizer time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tg Feedback time constant of inner loop field voltage regulator (<i>Tg</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tia Feedback time constant (<i>Tia</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param ts Rectifier firing time constant (<i>Ts</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param uelin UEL input selector (<i>UELin</i>).
 *        Typical value = noUELinput.
 * @param vmax Maximum voltage reference signal (<i>Vmax</i>) (&gt; 0 and &gt; ExcST7B.vmin)).
 *        Typical value = 1,1.
 * @param vmin Minimum voltage reference signal (<i>Vmin</i>) (&gt; 0 and &lt; ExcST7B.vmax).
 *        Typical value = 0,9.
 * @param vrmax Maximum voltage regulator output (<i>Vrmax</i>) (&gt; 0).
 *        Typical value = 5.
 * @param vrmin Minimum voltage regulator output (<i>Vrmin</i>) (&lt; 0).
 *        Typical value = -4,5.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcST7B
(
    ExcitationSystemDynamics: ExcitationSystemDynamics = null,
    kh: Double = 0.0,
    kia: Double = 0.0,
    kl: Double = 0.0,
    kpa: Double = 0.0,
    oelin: String = null,
    tb: Double = 0.0,
    tc: Double = 0.0,
    tf: Double = 0.0,
    tg: Double = 0.0,
    tia: Double = 0.0,
    ts: Double = 0.0,
    uelin: String = null,
    vmax: Double = 0.0,
    vmin: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: ExcitationSystemDynamics = ExcitationSystemDynamics

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
    CIMParseable[ExcST7B]
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

    def parse (context: CIMContext): ExcST7B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * Excitation system function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Discontinuous excitation control model associated with this excitation system model.
 * @param OverexcitationLimiterDynamics [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Overexcitation limiter model associated with this excitation system model.
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Power factor or VAr controller type 1 model associated with this excitation system model.
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Power factor or VAr controller type 2 model associated with this excitation system model.
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Power system stabilizer model associated with this excitation system model.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine model with which this excitation system model is associated.
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Undrexcitation limiter model associated with this excitation system model.
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Voltage compensator model associated with this excitation system model.
 * @group ExcitationSystemDynamics
 * @groupname ExcitationSystemDynamics Package ExcitationSystemDynamics
 * @groupdesc ExcitationSystemDynamics The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.  It is linked to a specific generator (synchronous machine). 
The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 */
final case class ExcitationSystemDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    DiscontinuousExcitationControlDynamics: String = null,
    OverexcitationLimiterDynamics: String = null,
    PFVArControllerType1Dynamics: String = null,
    PFVArControllerType2Dynamics: String = null,
    PowerSystemStabilizerDynamics: String = null,
    SynchronousMachineDynamics: String = null,
    UnderexcitationLimiterDynamics: String = null,
    VoltageCompensatorDynamics: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
    CIMParseable[ExcitationSystemDynamics]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiscontinuousExcitationControlDynamics", "DiscontinuousExcitationControlDynamics", "0..1", "1"),
        CIMRelationship ("OverexcitationLimiterDynamics", "OverexcitationLimiterDynamics", "0..1", "1"),
        CIMRelationship ("PFVArControllerType1Dynamics", "PFVArControllerType1Dynamics", "0..1", "1"),
        CIMRelationship ("PFVArControllerType2Dynamics", "PFVArControllerType2Dynamics", "0..1", "1"),
        CIMRelationship ("PowerSystemStabilizerDynamics", "PowerSystemStabilizerDynamics", "0..1", "1"),
        CIMRelationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..1"),
        CIMRelationship ("UnderexcitationLimiterDynamics", "UnderexcitationLimiterDynamics", "0..1", "1"),
        CIMRelationship ("VoltageCompensatorDynamics", "VoltageCompensatorDynamics", "1", "1")
    )
    val DiscontinuousExcitationControlDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OverexcitationLimiterDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PFVArControllerType1Dynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PFVArControllerType2Dynamics: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PowerSystemStabilizerDynamics: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(5)))
    val UnderexcitationLimiterDynamics: Fielder = parse_attribute (attribute (cls, fields(6)))
    val VoltageCompensatorDynamics: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): ExcitationSystemDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
    def register: List[CIMClassInfo] =
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
            ExcNI.register,
            ExcOEX3T.register,
            ExcPIC.register,
            ExcREXS.register,
            ExcRQB.register,
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