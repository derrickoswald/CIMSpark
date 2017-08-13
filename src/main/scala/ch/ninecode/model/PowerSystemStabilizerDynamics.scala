package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.
 * A variety of input signals may be used depending on the particular design.
 */

/**
 * Power system stabilizer function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this power system stabilizer model is associated.
 */
case class PowerSystemStabilizerDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[PowerSystemStabilizerDynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:PowerSystemStabilizerDynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PowerSystemStabilizerDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerSystemStabilizerDynamics>"
    }
}

object PowerSystemStabilizerDynamics
extends
    Parseable[PowerSystemStabilizerDynamics]
{
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PowerSystemStabilizerDynamics.ExcitationSystemDynamics"""))
    def parse (context: Context): PowerSystemStabilizerDynamics =
    {
        PowerSystemStabilizerDynamics(
            DynamicsFunctionBlock.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    kf: Double,
    kpe: Double,
    ks: Double,
    kw: Double,
    pmin: Double,
    t10: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    t9: Double,
    tpe: Double,
    vadat: Boolean,
    vsmn: Double,
    vsmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[Pss1] }
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
        "\t\t<cim:Pss1.kf>" + kf + "</cim:Pss1.kf>\n" +
        "\t\t<cim:Pss1.kpe>" + kpe + "</cim:Pss1.kpe>\n" +
        "\t\t<cim:Pss1.ks>" + ks + "</cim:Pss1.ks>\n" +
        "\t\t<cim:Pss1.kw>" + kw + "</cim:Pss1.kw>\n" +
        "\t\t<cim:Pss1.pmin>" + pmin + "</cim:Pss1.pmin>\n" +
        "\t\t<cim:Pss1.t10>" + t10 + "</cim:Pss1.t10>\n" +
        "\t\t<cim:Pss1.t5>" + t5 + "</cim:Pss1.t5>\n" +
        "\t\t<cim:Pss1.t6>" + t6 + "</cim:Pss1.t6>\n" +
        "\t\t<cim:Pss1.t7>" + t7 + "</cim:Pss1.t7>\n" +
        "\t\t<cim:Pss1.t8>" + t8 + "</cim:Pss1.t8>\n" +
        "\t\t<cim:Pss1.t9>" + t9 + "</cim:Pss1.t9>\n" +
        "\t\t<cim:Pss1.tpe>" + tpe + "</cim:Pss1.tpe>\n" +
        "\t\t<cim:Pss1.vadat>" + vadat + "</cim:Pss1.vadat>\n" +
        "\t\t<cim:Pss1.vsmn>" + vsmn + "</cim:Pss1.vsmn>\n" +
        "\t\t<cim:Pss1.vsmx>" + vsmx + "</cim:Pss1.vsmx>\n"
    }
    override def export: String =
    {
        "\t<cim:Pss1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pss1>"
    }
}

object Pss1
extends
    Parseable[Pss1]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    a1: Double,
    a2: Double,
    a3: Double,
    a4: Double,
    a5: Double,
    a6: Double,
    a7: Double,
    a8: Double,
    inputSignalType: String,
    kd: Boolean,
    ks: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    tdelay: Double,
    vcl: Double,
    vcu: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[Pss1A] }
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
        "\t\t<cim:Pss1A.a1>" + a1 + "</cim:Pss1A.a1>\n" +
        "\t\t<cim:Pss1A.a2>" + a2 + "</cim:Pss1A.a2>\n" +
        "\t\t<cim:Pss1A.a3>" + a3 + "</cim:Pss1A.a3>\n" +
        "\t\t<cim:Pss1A.a4>" + a4 + "</cim:Pss1A.a4>\n" +
        "\t\t<cim:Pss1A.a5>" + a5 + "</cim:Pss1A.a5>\n" +
        "\t\t<cim:Pss1A.a6>" + a6 + "</cim:Pss1A.a6>\n" +
        "\t\t<cim:Pss1A.a7>" + a7 + "</cim:Pss1A.a7>\n" +
        "\t\t<cim:Pss1A.a8>" + a8 + "</cim:Pss1A.a8>\n" +
        (if (null != inputSignalType) "\t\t<cim:Pss1A.inputSignalType rdf:resource=\"#" + inputSignalType + "\"/>\n" else "") +
        "\t\t<cim:Pss1A.kd>" + kd + "</cim:Pss1A.kd>\n" +
        "\t\t<cim:Pss1A.ks>" + ks + "</cim:Pss1A.ks>\n" +
        "\t\t<cim:Pss1A.t1>" + t1 + "</cim:Pss1A.t1>\n" +
        "\t\t<cim:Pss1A.t2>" + t2 + "</cim:Pss1A.t2>\n" +
        "\t\t<cim:Pss1A.t3>" + t3 + "</cim:Pss1A.t3>\n" +
        "\t\t<cim:Pss1A.t4>" + t4 + "</cim:Pss1A.t4>\n" +
        "\t\t<cim:Pss1A.t5>" + t5 + "</cim:Pss1A.t5>\n" +
        "\t\t<cim:Pss1A.t6>" + t6 + "</cim:Pss1A.t6>\n" +
        "\t\t<cim:Pss1A.tdelay>" + tdelay + "</cim:Pss1A.tdelay>\n" +
        "\t\t<cim:Pss1A.vcl>" + vcl + "</cim:Pss1A.vcl>\n" +
        "\t\t<cim:Pss1A.vcu>" + vcu + "</cim:Pss1A.vcu>\n" +
        "\t\t<cim:Pss1A.vrmax>" + vrmax + "</cim:Pss1A.vrmax>\n" +
        "\t\t<cim:Pss1A.vrmin>" + vrmin + "</cim:Pss1A.vrmin>\n"
    }
    override def export: String =
    {
        "\t<cim:Pss1A rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pss1A>"
    }
}

object Pss1A
extends
    Parseable[Pss1A]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    a: Double,
    inputSignal1Type: String,
    inputSignal2Type: String,
    ks1: Double,
    ks2: Double,
    ks3: Double,
    ks4: Double,
    m: Int,
    n: Int,
    t1: Double,
    t10: Double,
    t11: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    t9: Double,
    ta: Double,
    tb: Double,
    tw1: Double,
    tw2: Double,
    tw3: Double,
    tw4: Double,
    vsi1max: Double,
    vsi1min: Double,
    vsi2max: Double,
    vsi2min: Double,
    vstmax: Double,
    vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[Pss2B] }
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
        "\t\t<cim:Pss2B.a>" + a + "</cim:Pss2B.a>\n" +
        (if (null != inputSignal1Type) "\t\t<cim:Pss2B.inputSignal1Type rdf:resource=\"#" + inputSignal1Type + "\"/>\n" else "") +
        (if (null != inputSignal2Type) "\t\t<cim:Pss2B.inputSignal2Type rdf:resource=\"#" + inputSignal2Type + "\"/>\n" else "") +
        "\t\t<cim:Pss2B.ks1>" + ks1 + "</cim:Pss2B.ks1>\n" +
        "\t\t<cim:Pss2B.ks2>" + ks2 + "</cim:Pss2B.ks2>\n" +
        "\t\t<cim:Pss2B.ks3>" + ks3 + "</cim:Pss2B.ks3>\n" +
        "\t\t<cim:Pss2B.ks4>" + ks4 + "</cim:Pss2B.ks4>\n" +
        "\t\t<cim:Pss2B.m>" + m + "</cim:Pss2B.m>\n" +
        "\t\t<cim:Pss2B.n>" + n + "</cim:Pss2B.n>\n" +
        "\t\t<cim:Pss2B.t1>" + t1 + "</cim:Pss2B.t1>\n" +
        "\t\t<cim:Pss2B.t10>" + t10 + "</cim:Pss2B.t10>\n" +
        "\t\t<cim:Pss2B.t11>" + t11 + "</cim:Pss2B.t11>\n" +
        "\t\t<cim:Pss2B.t2>" + t2 + "</cim:Pss2B.t2>\n" +
        "\t\t<cim:Pss2B.t3>" + t3 + "</cim:Pss2B.t3>\n" +
        "\t\t<cim:Pss2B.t4>" + t4 + "</cim:Pss2B.t4>\n" +
        "\t\t<cim:Pss2B.t6>" + t6 + "</cim:Pss2B.t6>\n" +
        "\t\t<cim:Pss2B.t7>" + t7 + "</cim:Pss2B.t7>\n" +
        "\t\t<cim:Pss2B.t8>" + t8 + "</cim:Pss2B.t8>\n" +
        "\t\t<cim:Pss2B.t9>" + t9 + "</cim:Pss2B.t9>\n" +
        "\t\t<cim:Pss2B.ta>" + ta + "</cim:Pss2B.ta>\n" +
        "\t\t<cim:Pss2B.tb>" + tb + "</cim:Pss2B.tb>\n" +
        "\t\t<cim:Pss2B.tw1>" + tw1 + "</cim:Pss2B.tw1>\n" +
        "\t\t<cim:Pss2B.tw2>" + tw2 + "</cim:Pss2B.tw2>\n" +
        "\t\t<cim:Pss2B.tw3>" + tw3 + "</cim:Pss2B.tw3>\n" +
        "\t\t<cim:Pss2B.tw4>" + tw4 + "</cim:Pss2B.tw4>\n" +
        "\t\t<cim:Pss2B.vsi1max>" + vsi1max + "</cim:Pss2B.vsi1max>\n" +
        "\t\t<cim:Pss2B.vsi1min>" + vsi1min + "</cim:Pss2B.vsi1min>\n" +
        "\t\t<cim:Pss2B.vsi2max>" + vsi2max + "</cim:Pss2B.vsi2max>\n" +
        "\t\t<cim:Pss2B.vsi2min>" + vsi2min + "</cim:Pss2B.vsi2min>\n" +
        "\t\t<cim:Pss2B.vstmax>" + vstmax + "</cim:Pss2B.vstmax>\n" +
        "\t\t<cim:Pss2B.vstmin>" + vstmin + "</cim:Pss2B.vstmin>\n"
    }
    override def export: String =
    {
        "\t<cim:Pss2B rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pss2B>"
    }
}

object Pss2B
extends
    Parseable[Pss2B]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    inputSignal1Type: String,
    inputSignal2Type: String,
    k1: Double,
    k2: Double,
    lsmax: Double,
    lsmin: Double,
    t1: Double,
    t10: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    t9: Double,
    vcl: Double,
    vcu: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[Pss2ST] }
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
        (if (null != inputSignal1Type) "\t\t<cim:Pss2ST.inputSignal1Type rdf:resource=\"#" + inputSignal1Type + "\"/>\n" else "") +
        (if (null != inputSignal2Type) "\t\t<cim:Pss2ST.inputSignal2Type rdf:resource=\"#" + inputSignal2Type + "\"/>\n" else "") +
        "\t\t<cim:Pss2ST.k1>" + k1 + "</cim:Pss2ST.k1>\n" +
        "\t\t<cim:Pss2ST.k2>" + k2 + "</cim:Pss2ST.k2>\n" +
        "\t\t<cim:Pss2ST.lsmax>" + lsmax + "</cim:Pss2ST.lsmax>\n" +
        "\t\t<cim:Pss2ST.lsmin>" + lsmin + "</cim:Pss2ST.lsmin>\n" +
        "\t\t<cim:Pss2ST.t1>" + t1 + "</cim:Pss2ST.t1>\n" +
        "\t\t<cim:Pss2ST.t10>" + t10 + "</cim:Pss2ST.t10>\n" +
        "\t\t<cim:Pss2ST.t2>" + t2 + "</cim:Pss2ST.t2>\n" +
        "\t\t<cim:Pss2ST.t3>" + t3 + "</cim:Pss2ST.t3>\n" +
        "\t\t<cim:Pss2ST.t4>" + t4 + "</cim:Pss2ST.t4>\n" +
        "\t\t<cim:Pss2ST.t5>" + t5 + "</cim:Pss2ST.t5>\n" +
        "\t\t<cim:Pss2ST.t6>" + t6 + "</cim:Pss2ST.t6>\n" +
        "\t\t<cim:Pss2ST.t7>" + t7 + "</cim:Pss2ST.t7>\n" +
        "\t\t<cim:Pss2ST.t8>" + t8 + "</cim:Pss2ST.t8>\n" +
        "\t\t<cim:Pss2ST.t9>" + t9 + "</cim:Pss2ST.t9>\n" +
        "\t\t<cim:Pss2ST.vcl>" + vcl + "</cim:Pss2ST.vcl>\n" +
        "\t\t<cim:Pss2ST.vcu>" + vcu + "</cim:Pss2ST.vcu>\n"
    }
    override def export: String =
    {
        "\t<cim:Pss2ST rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pss2ST>"
    }
}

object Pss2ST
extends
    Parseable[Pss2ST]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    ctw2: Boolean,
    deadband: Double,
    isfreq: Boolean,
    kf: Double,
    kpe: Double,
    kpss: Double,
    pmm: Double,
    tl1: Double,
    tl2: Double,
    tl3: Double,
    tl4: Double,
    tpe: Double,
    tw1: Double,
    tw2: Double,
    vadat: Boolean,
    vsmn: Double,
    vsmx: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[Pss5] }
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
        "\t\t<cim:Pss5.ctw2>" + ctw2 + "</cim:Pss5.ctw2>\n" +
        "\t\t<cim:Pss5.deadband>" + deadband + "</cim:Pss5.deadband>\n" +
        "\t\t<cim:Pss5.isfreq>" + isfreq + "</cim:Pss5.isfreq>\n" +
        "\t\t<cim:Pss5.kf>" + kf + "</cim:Pss5.kf>\n" +
        "\t\t<cim:Pss5.kpe>" + kpe + "</cim:Pss5.kpe>\n" +
        "\t\t<cim:Pss5.kpss>" + kpss + "</cim:Pss5.kpss>\n" +
        "\t\t<cim:Pss5.pmm>" + pmm + "</cim:Pss5.pmm>\n" +
        "\t\t<cim:Pss5.tl1>" + tl1 + "</cim:Pss5.tl1>\n" +
        "\t\t<cim:Pss5.tl2>" + tl2 + "</cim:Pss5.tl2>\n" +
        "\t\t<cim:Pss5.tl3>" + tl3 + "</cim:Pss5.tl3>\n" +
        "\t\t<cim:Pss5.tl4>" + tl4 + "</cim:Pss5.tl4>\n" +
        "\t\t<cim:Pss5.tpe>" + tpe + "</cim:Pss5.tpe>\n" +
        "\t\t<cim:Pss5.tw1>" + tw1 + "</cim:Pss5.tw1>\n" +
        "\t\t<cim:Pss5.tw2>" + tw2 + "</cim:Pss5.tw2>\n" +
        "\t\t<cim:Pss5.vadat>" + vadat + "</cim:Pss5.vadat>\n" +
        "\t\t<cim:Pss5.vsmn>" + vsmn + "</cim:Pss5.vsmn>\n" +
        "\t\t<cim:Pss5.vsmx>" + vsmx + "</cim:Pss5.vsmx>\n"
    }
    override def export: String =
    {
        "\t<cim:Pss5 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Pss5>"
    }
}

object Pss5
extends
    Parseable[Pss5]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    apss: Double,
    ks1: Double,
    ks2: Double,
    ppss: Double,
    psslim: Double,
    ts1: Double,
    ts2: Double,
    ts3: Double,
    ts4: Double,
    ts5: Double,
    ts6: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssELIN2] }
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
        "\t\t<cim:PssELIN2.apss>" + apss + "</cim:PssELIN2.apss>\n" +
        "\t\t<cim:PssELIN2.ks1>" + ks1 + "</cim:PssELIN2.ks1>\n" +
        "\t\t<cim:PssELIN2.ks2>" + ks2 + "</cim:PssELIN2.ks2>\n" +
        "\t\t<cim:PssELIN2.ppss>" + ppss + "</cim:PssELIN2.ppss>\n" +
        "\t\t<cim:PssELIN2.psslim>" + psslim + "</cim:PssELIN2.psslim>\n" +
        "\t\t<cim:PssELIN2.ts1>" + ts1 + "</cim:PssELIN2.ts1>\n" +
        "\t\t<cim:PssELIN2.ts2>" + ts2 + "</cim:PssELIN2.ts2>\n" +
        "\t\t<cim:PssELIN2.ts3>" + ts3 + "</cim:PssELIN2.ts3>\n" +
        "\t\t<cim:PssELIN2.ts4>" + ts4 + "</cim:PssELIN2.ts4>\n" +
        "\t\t<cim:PssELIN2.ts5>" + ts5 + "</cim:PssELIN2.ts5>\n" +
        "\t\t<cim:PssELIN2.ts6>" + ts6 + "</cim:PssELIN2.ts6>\n"
    }
    override def export: String =
    {
        "\t<cim:PssELIN2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssELIN2>"
    }
}

object PssELIN2
extends
    Parseable[PssELIN2]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    a1: Double,
    a2: Double,
    inputSignalType: String,
    ks: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    vrmax: Double,
    vrmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssIEEE1A] }
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
        "\t\t<cim:PssIEEE1A.a1>" + a1 + "</cim:PssIEEE1A.a1>\n" +
        "\t\t<cim:PssIEEE1A.a2>" + a2 + "</cim:PssIEEE1A.a2>\n" +
        (if (null != inputSignalType) "\t\t<cim:PssIEEE1A.inputSignalType rdf:resource=\"#" + inputSignalType + "\"/>\n" else "") +
        "\t\t<cim:PssIEEE1A.ks>" + ks + "</cim:PssIEEE1A.ks>\n" +
        "\t\t<cim:PssIEEE1A.t1>" + t1 + "</cim:PssIEEE1A.t1>\n" +
        "\t\t<cim:PssIEEE1A.t2>" + t2 + "</cim:PssIEEE1A.t2>\n" +
        "\t\t<cim:PssIEEE1A.t3>" + t3 + "</cim:PssIEEE1A.t3>\n" +
        "\t\t<cim:PssIEEE1A.t4>" + t4 + "</cim:PssIEEE1A.t4>\n" +
        "\t\t<cim:PssIEEE1A.t5>" + t5 + "</cim:PssIEEE1A.t5>\n" +
        "\t\t<cim:PssIEEE1A.t6>" + t6 + "</cim:PssIEEE1A.t6>\n" +
        "\t\t<cim:PssIEEE1A.vrmax>" + vrmax + "</cim:PssIEEE1A.vrmax>\n" +
        "\t\t<cim:PssIEEE1A.vrmin>" + vrmin + "</cim:PssIEEE1A.vrmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssIEEE1A rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssIEEE1A>"
    }
}

object PssIEEE1A
extends
    Parseable[PssIEEE1A]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    inputSignal1Type: String,
    inputSignal2Type: String,
    ks1: Double,
    ks2: Double,
    ks3: Double,
    m: Int,
    n: Int,
    t1: Double,
    t10: Double,
    t11: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    t9: Double,
    tw1: Double,
    tw2: Double,
    tw3: Double,
    tw4: Double,
    vsi1max: Double,
    vsi1min: Double,
    vsi2max: Double,
    vsi2min: Double,
    vstmax: Double,
    vstmin: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssIEEE2B] }
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
        (if (null != inputSignal1Type) "\t\t<cim:PssIEEE2B.inputSignal1Type rdf:resource=\"#" + inputSignal1Type + "\"/>\n" else "") +
        (if (null != inputSignal2Type) "\t\t<cim:PssIEEE2B.inputSignal2Type rdf:resource=\"#" + inputSignal2Type + "\"/>\n" else "") +
        "\t\t<cim:PssIEEE2B.ks1>" + ks1 + "</cim:PssIEEE2B.ks1>\n" +
        "\t\t<cim:PssIEEE2B.ks2>" + ks2 + "</cim:PssIEEE2B.ks2>\n" +
        "\t\t<cim:PssIEEE2B.ks3>" + ks3 + "</cim:PssIEEE2B.ks3>\n" +
        "\t\t<cim:PssIEEE2B.m>" + m + "</cim:PssIEEE2B.m>\n" +
        "\t\t<cim:PssIEEE2B.n>" + n + "</cim:PssIEEE2B.n>\n" +
        "\t\t<cim:PssIEEE2B.t1>" + t1 + "</cim:PssIEEE2B.t1>\n" +
        "\t\t<cim:PssIEEE2B.t10>" + t10 + "</cim:PssIEEE2B.t10>\n" +
        "\t\t<cim:PssIEEE2B.t11>" + t11 + "</cim:PssIEEE2B.t11>\n" +
        "\t\t<cim:PssIEEE2B.t2>" + t2 + "</cim:PssIEEE2B.t2>\n" +
        "\t\t<cim:PssIEEE2B.t3>" + t3 + "</cim:PssIEEE2B.t3>\n" +
        "\t\t<cim:PssIEEE2B.t4>" + t4 + "</cim:PssIEEE2B.t4>\n" +
        "\t\t<cim:PssIEEE2B.t6>" + t6 + "</cim:PssIEEE2B.t6>\n" +
        "\t\t<cim:PssIEEE2B.t7>" + t7 + "</cim:PssIEEE2B.t7>\n" +
        "\t\t<cim:PssIEEE2B.t8>" + t8 + "</cim:PssIEEE2B.t8>\n" +
        "\t\t<cim:PssIEEE2B.t9>" + t9 + "</cim:PssIEEE2B.t9>\n" +
        "\t\t<cim:PssIEEE2B.tw1>" + tw1 + "</cim:PssIEEE2B.tw1>\n" +
        "\t\t<cim:PssIEEE2B.tw2>" + tw2 + "</cim:PssIEEE2B.tw2>\n" +
        "\t\t<cim:PssIEEE2B.tw3>" + tw3 + "</cim:PssIEEE2B.tw3>\n" +
        "\t\t<cim:PssIEEE2B.tw4>" + tw4 + "</cim:PssIEEE2B.tw4>\n" +
        "\t\t<cim:PssIEEE2B.vsi1max>" + vsi1max + "</cim:PssIEEE2B.vsi1max>\n" +
        "\t\t<cim:PssIEEE2B.vsi1min>" + vsi1min + "</cim:PssIEEE2B.vsi1min>\n" +
        "\t\t<cim:PssIEEE2B.vsi2max>" + vsi2max + "</cim:PssIEEE2B.vsi2max>\n" +
        "\t\t<cim:PssIEEE2B.vsi2min>" + vsi2min + "</cim:PssIEEE2B.vsi2min>\n" +
        "\t\t<cim:PssIEEE2B.vstmax>" + vstmax + "</cim:PssIEEE2B.vstmax>\n" +
        "\t\t<cim:PssIEEE2B.vstmin>" + vstmin + "</cim:PssIEEE2B.vstmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssIEEE2B rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssIEEE2B>"
    }
}

object PssIEEE2B
extends
    Parseable[PssIEEE2B]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    a1: Double,
    a2: Double,
    a3: Double,
    a4: Double,
    a5: Double,
    a6: Double,
    a7: Double,
    a8: Double,
    inputSignal1Type: String,
    inputSignal2Type: String,
    ks1: Double,
    ks2: Double,
    t1: Double,
    t2: Double,
    tw1: Double,
    tw2: Double,
    tw3: Double,
    vstmax: Double,
    vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssIEEE3B] }
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
        "\t\t<cim:PssIEEE3B.a1>" + a1 + "</cim:PssIEEE3B.a1>\n" +
        "\t\t<cim:PssIEEE3B.a2>" + a2 + "</cim:PssIEEE3B.a2>\n" +
        "\t\t<cim:PssIEEE3B.a3>" + a3 + "</cim:PssIEEE3B.a3>\n" +
        "\t\t<cim:PssIEEE3B.a4>" + a4 + "</cim:PssIEEE3B.a4>\n" +
        "\t\t<cim:PssIEEE3B.a5>" + a5 + "</cim:PssIEEE3B.a5>\n" +
        "\t\t<cim:PssIEEE3B.a6>" + a6 + "</cim:PssIEEE3B.a6>\n" +
        "\t\t<cim:PssIEEE3B.a7>" + a7 + "</cim:PssIEEE3B.a7>\n" +
        "\t\t<cim:PssIEEE3B.a8>" + a8 + "</cim:PssIEEE3B.a8>\n" +
        (if (null != inputSignal1Type) "\t\t<cim:PssIEEE3B.inputSignal1Type rdf:resource=\"#" + inputSignal1Type + "\"/>\n" else "") +
        (if (null != inputSignal2Type) "\t\t<cim:PssIEEE3B.inputSignal2Type rdf:resource=\"#" + inputSignal2Type + "\"/>\n" else "") +
        "\t\t<cim:PssIEEE3B.ks1>" + ks1 + "</cim:PssIEEE3B.ks1>\n" +
        "\t\t<cim:PssIEEE3B.ks2>" + ks2 + "</cim:PssIEEE3B.ks2>\n" +
        "\t\t<cim:PssIEEE3B.t1>" + t1 + "</cim:PssIEEE3B.t1>\n" +
        "\t\t<cim:PssIEEE3B.t2>" + t2 + "</cim:PssIEEE3B.t2>\n" +
        "\t\t<cim:PssIEEE3B.tw1>" + tw1 + "</cim:PssIEEE3B.tw1>\n" +
        "\t\t<cim:PssIEEE3B.tw2>" + tw2 + "</cim:PssIEEE3B.tw2>\n" +
        "\t\t<cim:PssIEEE3B.tw3>" + tw3 + "</cim:PssIEEE3B.tw3>\n" +
        "\t\t<cim:PssIEEE3B.vstmax>" + vstmax + "</cim:PssIEEE3B.vstmax>\n" +
        "\t\t<cim:PssIEEE3B.vstmin>" + vstmin + "</cim:PssIEEE3B.vstmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssIEEE3B rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssIEEE3B>"
    }
}

object PssIEEE3B
extends
    Parseable[PssIEEE3B]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    bwh1: Double,
    bwh2: Double,
    bwl1: Double,
    bwl2: Double,
    kh: Double,
    kh1: Double,
    kh11: Double,
    kh17: Double,
    kh2: Double,
    ki: Double,
    ki1: Double,
    ki11: Double,
    ki17: Double,
    ki2: Double,
    kl: Double,
    kl1: Double,
    kl11: Double,
    kl17: Double,
    kl2: Double,
    omeganh1: Double,
    omeganh2: Double,
    omeganl1: Double,
    omeganl2: Double,
    th1: Double,
    th10: Double,
    th11: Double,
    th12: Double,
    th2: Double,
    th3: Double,
    th4: Double,
    th5: Double,
    th6: Double,
    th7: Double,
    th8: Double,
    th9: Double,
    ti1: Double,
    ti10: Double,
    ti11: Double,
    ti12: Double,
    ti2: Double,
    ti3: Double,
    ti4: Double,
    ti5: Double,
    ti6: Double,
    ti7: Double,
    ti8: Double,
    ti9: Double,
    tl1: Double,
    tl10: Double,
    tl11: Double,
    tl12: Double,
    tl2: Double,
    tl3: Double,
    tl4: Double,
    tl5: Double,
    tl6: Double,
    tl7: Double,
    tl8: Double,
    tl9: Double,
    vhmax: Double,
    vhmin: Double,
    vimax: Double,
    vimin: Double,
    vlmax: Double,
    vlmin: Double,
    vstmax: Double,
    vstmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssIEEE4B] }
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
        "\t\t<cim:PssIEEE4B.bwh1>" + bwh1 + "</cim:PssIEEE4B.bwh1>\n" +
        "\t\t<cim:PssIEEE4B.bwh2>" + bwh2 + "</cim:PssIEEE4B.bwh2>\n" +
        "\t\t<cim:PssIEEE4B.bwl1>" + bwl1 + "</cim:PssIEEE4B.bwl1>\n" +
        "\t\t<cim:PssIEEE4B.bwl2>" + bwl2 + "</cim:PssIEEE4B.bwl2>\n" +
        "\t\t<cim:PssIEEE4B.kh>" + kh + "</cim:PssIEEE4B.kh>\n" +
        "\t\t<cim:PssIEEE4B.kh1>" + kh1 + "</cim:PssIEEE4B.kh1>\n" +
        "\t\t<cim:PssIEEE4B.kh11>" + kh11 + "</cim:PssIEEE4B.kh11>\n" +
        "\t\t<cim:PssIEEE4B.kh17>" + kh17 + "</cim:PssIEEE4B.kh17>\n" +
        "\t\t<cim:PssIEEE4B.kh2>" + kh2 + "</cim:PssIEEE4B.kh2>\n" +
        "\t\t<cim:PssIEEE4B.ki>" + ki + "</cim:PssIEEE4B.ki>\n" +
        "\t\t<cim:PssIEEE4B.ki1>" + ki1 + "</cim:PssIEEE4B.ki1>\n" +
        "\t\t<cim:PssIEEE4B.ki11>" + ki11 + "</cim:PssIEEE4B.ki11>\n" +
        "\t\t<cim:PssIEEE4B.ki17>" + ki17 + "</cim:PssIEEE4B.ki17>\n" +
        "\t\t<cim:PssIEEE4B.ki2>" + ki2 + "</cim:PssIEEE4B.ki2>\n" +
        "\t\t<cim:PssIEEE4B.kl>" + kl + "</cim:PssIEEE4B.kl>\n" +
        "\t\t<cim:PssIEEE4B.kl1>" + kl1 + "</cim:PssIEEE4B.kl1>\n" +
        "\t\t<cim:PssIEEE4B.kl11>" + kl11 + "</cim:PssIEEE4B.kl11>\n" +
        "\t\t<cim:PssIEEE4B.kl17>" + kl17 + "</cim:PssIEEE4B.kl17>\n" +
        "\t\t<cim:PssIEEE4B.kl2>" + kl2 + "</cim:PssIEEE4B.kl2>\n" +
        "\t\t<cim:PssIEEE4B.omeganh1>" + omeganh1 + "</cim:PssIEEE4B.omeganh1>\n" +
        "\t\t<cim:PssIEEE4B.omeganh2>" + omeganh2 + "</cim:PssIEEE4B.omeganh2>\n" +
        "\t\t<cim:PssIEEE4B.omeganl1>" + omeganl1 + "</cim:PssIEEE4B.omeganl1>\n" +
        "\t\t<cim:PssIEEE4B.omeganl2>" + omeganl2 + "</cim:PssIEEE4B.omeganl2>\n" +
        "\t\t<cim:PssIEEE4B.th1>" + th1 + "</cim:PssIEEE4B.th1>\n" +
        "\t\t<cim:PssIEEE4B.th10>" + th10 + "</cim:PssIEEE4B.th10>\n" +
        "\t\t<cim:PssIEEE4B.th11>" + th11 + "</cim:PssIEEE4B.th11>\n" +
        "\t\t<cim:PssIEEE4B.th12>" + th12 + "</cim:PssIEEE4B.th12>\n" +
        "\t\t<cim:PssIEEE4B.th2>" + th2 + "</cim:PssIEEE4B.th2>\n" +
        "\t\t<cim:PssIEEE4B.th3>" + th3 + "</cim:PssIEEE4B.th3>\n" +
        "\t\t<cim:PssIEEE4B.th4>" + th4 + "</cim:PssIEEE4B.th4>\n" +
        "\t\t<cim:PssIEEE4B.th5>" + th5 + "</cim:PssIEEE4B.th5>\n" +
        "\t\t<cim:PssIEEE4B.th6>" + th6 + "</cim:PssIEEE4B.th6>\n" +
        "\t\t<cim:PssIEEE4B.th7>" + th7 + "</cim:PssIEEE4B.th7>\n" +
        "\t\t<cim:PssIEEE4B.th8>" + th8 + "</cim:PssIEEE4B.th8>\n" +
        "\t\t<cim:PssIEEE4B.th9>" + th9 + "</cim:PssIEEE4B.th9>\n" +
        "\t\t<cim:PssIEEE4B.ti1>" + ti1 + "</cim:PssIEEE4B.ti1>\n" +
        "\t\t<cim:PssIEEE4B.ti10>" + ti10 + "</cim:PssIEEE4B.ti10>\n" +
        "\t\t<cim:PssIEEE4B.ti11>" + ti11 + "</cim:PssIEEE4B.ti11>\n" +
        "\t\t<cim:PssIEEE4B.ti12>" + ti12 + "</cim:PssIEEE4B.ti12>\n" +
        "\t\t<cim:PssIEEE4B.ti2>" + ti2 + "</cim:PssIEEE4B.ti2>\n" +
        "\t\t<cim:PssIEEE4B.ti3>" + ti3 + "</cim:PssIEEE4B.ti3>\n" +
        "\t\t<cim:PssIEEE4B.ti4>" + ti4 + "</cim:PssIEEE4B.ti4>\n" +
        "\t\t<cim:PssIEEE4B.ti5>" + ti5 + "</cim:PssIEEE4B.ti5>\n" +
        "\t\t<cim:PssIEEE4B.ti6>" + ti6 + "</cim:PssIEEE4B.ti6>\n" +
        "\t\t<cim:PssIEEE4B.ti7>" + ti7 + "</cim:PssIEEE4B.ti7>\n" +
        "\t\t<cim:PssIEEE4B.ti8>" + ti8 + "</cim:PssIEEE4B.ti8>\n" +
        "\t\t<cim:PssIEEE4B.ti9>" + ti9 + "</cim:PssIEEE4B.ti9>\n" +
        "\t\t<cim:PssIEEE4B.tl1>" + tl1 + "</cim:PssIEEE4B.tl1>\n" +
        "\t\t<cim:PssIEEE4B.tl10>" + tl10 + "</cim:PssIEEE4B.tl10>\n" +
        "\t\t<cim:PssIEEE4B.tl11>" + tl11 + "</cim:PssIEEE4B.tl11>\n" +
        "\t\t<cim:PssIEEE4B.tl12>" + tl12 + "</cim:PssIEEE4B.tl12>\n" +
        "\t\t<cim:PssIEEE4B.tl2>" + tl2 + "</cim:PssIEEE4B.tl2>\n" +
        "\t\t<cim:PssIEEE4B.tl3>" + tl3 + "</cim:PssIEEE4B.tl3>\n" +
        "\t\t<cim:PssIEEE4B.tl4>" + tl4 + "</cim:PssIEEE4B.tl4>\n" +
        "\t\t<cim:PssIEEE4B.tl5>" + tl5 + "</cim:PssIEEE4B.tl5>\n" +
        "\t\t<cim:PssIEEE4B.tl6>" + tl6 + "</cim:PssIEEE4B.tl6>\n" +
        "\t\t<cim:PssIEEE4B.tl7>" + tl7 + "</cim:PssIEEE4B.tl7>\n" +
        "\t\t<cim:PssIEEE4B.tl8>" + tl8 + "</cim:PssIEEE4B.tl8>\n" +
        "\t\t<cim:PssIEEE4B.tl9>" + tl9 + "</cim:PssIEEE4B.tl9>\n" +
        "\t\t<cim:PssIEEE4B.vhmax>" + vhmax + "</cim:PssIEEE4B.vhmax>\n" +
        "\t\t<cim:PssIEEE4B.vhmin>" + vhmin + "</cim:PssIEEE4B.vhmin>\n" +
        "\t\t<cim:PssIEEE4B.vimax>" + vimax + "</cim:PssIEEE4B.vimax>\n" +
        "\t\t<cim:PssIEEE4B.vimin>" + vimin + "</cim:PssIEEE4B.vimin>\n" +
        "\t\t<cim:PssIEEE4B.vlmax>" + vlmax + "</cim:PssIEEE4B.vlmax>\n" +
        "\t\t<cim:PssIEEE4B.vlmin>" + vlmin + "</cim:PssIEEE4B.vlmin>\n" +
        "\t\t<cim:PssIEEE4B.vstmax>" + vstmax + "</cim:PssIEEE4B.vstmax>\n" +
        "\t\t<cim:PssIEEE4B.vstmin>" + vstmin + "</cim:PssIEEE4B.vstmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssIEEE4B rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssIEEE4B>"
    }
}

object PssIEEE4B
extends
    Parseable[PssIEEE4B]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    dtc: Double,
    dtf: Double,
    dtp: Double,
    k: Double,
    m: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    tf: Double,
    tp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssPTIST1] }
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
        "\t\t<cim:PssPTIST1.dtc>" + dtc + "</cim:PssPTIST1.dtc>\n" +
        "\t\t<cim:PssPTIST1.dtf>" + dtf + "</cim:PssPTIST1.dtf>\n" +
        "\t\t<cim:PssPTIST1.dtp>" + dtp + "</cim:PssPTIST1.dtp>\n" +
        "\t\t<cim:PssPTIST1.k>" + k + "</cim:PssPTIST1.k>\n" +
        "\t\t<cim:PssPTIST1.m>" + m + "</cim:PssPTIST1.m>\n" +
        "\t\t<cim:PssPTIST1.t1>" + t1 + "</cim:PssPTIST1.t1>\n" +
        "\t\t<cim:PssPTIST1.t2>" + t2 + "</cim:PssPTIST1.t2>\n" +
        "\t\t<cim:PssPTIST1.t3>" + t3 + "</cim:PssPTIST1.t3>\n" +
        "\t\t<cim:PssPTIST1.t4>" + t4 + "</cim:PssPTIST1.t4>\n" +
        "\t\t<cim:PssPTIST1.tf>" + tf + "</cim:PssPTIST1.tf>\n" +
        "\t\t<cim:PssPTIST1.tp>" + tp + "</cim:PssPTIST1.tp>\n"
    }
    override def export: String =
    {
        "\t<cim:PssPTIST1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssPTIST1>"
    }
}

object PssPTIST1
extends
    Parseable[PssPTIST1]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    a0: Double,
    a1: Double,
    a2: Double,
    a3: Double,
    a4: Double,
    a5: Double,
    al: Double,
    athres: Double,
    b0: Double,
    b1: Double,
    b2: Double,
    b3: Double,
    b4: Double,
    b5: Double,
    dl: Double,
    dtc: Double,
    dtf: Double,
    dtp: Double,
    isw: Boolean,
    k: Double,
    lthres: Double,
    m: Double,
    nav: Double,
    ncl: Double,
    ncr: Double,
    pmin: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    tf: Double,
    tp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssPTIST3] }
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
        "\t\t<cim:PssPTIST3.a0>" + a0 + "</cim:PssPTIST3.a0>\n" +
        "\t\t<cim:PssPTIST3.a1>" + a1 + "</cim:PssPTIST3.a1>\n" +
        "\t\t<cim:PssPTIST3.a2>" + a2 + "</cim:PssPTIST3.a2>\n" +
        "\t\t<cim:PssPTIST3.a3>" + a3 + "</cim:PssPTIST3.a3>\n" +
        "\t\t<cim:PssPTIST3.a4>" + a4 + "</cim:PssPTIST3.a4>\n" +
        "\t\t<cim:PssPTIST3.a5>" + a5 + "</cim:PssPTIST3.a5>\n" +
        "\t\t<cim:PssPTIST3.al>" + al + "</cim:PssPTIST3.al>\n" +
        "\t\t<cim:PssPTIST3.athres>" + athres + "</cim:PssPTIST3.athres>\n" +
        "\t\t<cim:PssPTIST3.b0>" + b0 + "</cim:PssPTIST3.b0>\n" +
        "\t\t<cim:PssPTIST3.b1>" + b1 + "</cim:PssPTIST3.b1>\n" +
        "\t\t<cim:PssPTIST3.b2>" + b2 + "</cim:PssPTIST3.b2>\n" +
        "\t\t<cim:PssPTIST3.b3>" + b3 + "</cim:PssPTIST3.b3>\n" +
        "\t\t<cim:PssPTIST3.b4>" + b4 + "</cim:PssPTIST3.b4>\n" +
        "\t\t<cim:PssPTIST3.b5>" + b5 + "</cim:PssPTIST3.b5>\n" +
        "\t\t<cim:PssPTIST3.dl>" + dl + "</cim:PssPTIST3.dl>\n" +
        "\t\t<cim:PssPTIST3.dtc>" + dtc + "</cim:PssPTIST3.dtc>\n" +
        "\t\t<cim:PssPTIST3.dtf>" + dtf + "</cim:PssPTIST3.dtf>\n" +
        "\t\t<cim:PssPTIST3.dtp>" + dtp + "</cim:PssPTIST3.dtp>\n" +
        "\t\t<cim:PssPTIST3.isw>" + isw + "</cim:PssPTIST3.isw>\n" +
        "\t\t<cim:PssPTIST3.k>" + k + "</cim:PssPTIST3.k>\n" +
        "\t\t<cim:PssPTIST3.lthres>" + lthres + "</cim:PssPTIST3.lthres>\n" +
        "\t\t<cim:PssPTIST3.m>" + m + "</cim:PssPTIST3.m>\n" +
        "\t\t<cim:PssPTIST3.nav>" + nav + "</cim:PssPTIST3.nav>\n" +
        "\t\t<cim:PssPTIST3.ncl>" + ncl + "</cim:PssPTIST3.ncl>\n" +
        "\t\t<cim:PssPTIST3.ncr>" + ncr + "</cim:PssPTIST3.ncr>\n" +
        "\t\t<cim:PssPTIST3.pmin>" + pmin + "</cim:PssPTIST3.pmin>\n" +
        "\t\t<cim:PssPTIST3.t1>" + t1 + "</cim:PssPTIST3.t1>\n" +
        "\t\t<cim:PssPTIST3.t2>" + t2 + "</cim:PssPTIST3.t2>\n" +
        "\t\t<cim:PssPTIST3.t3>" + t3 + "</cim:PssPTIST3.t3>\n" +
        "\t\t<cim:PssPTIST3.t4>" + t4 + "</cim:PssPTIST3.t4>\n" +
        "\t\t<cim:PssPTIST3.t5>" + t5 + "</cim:PssPTIST3.t5>\n" +
        "\t\t<cim:PssPTIST3.t6>" + t6 + "</cim:PssPTIST3.t6>\n" +
        "\t\t<cim:PssPTIST3.tf>" + tf + "</cim:PssPTIST3.tf>\n" +
        "\t\t<cim:PssPTIST3.tp>" + tp + "</cim:PssPTIST3.tp>\n"
    }
    override def export: String =
    {
        "\t<cim:PssPTIST3 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssPTIST3>"
    }
}

object PssPTIST3
extends
    Parseable[PssPTIST3]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    kx: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    td: Double,
    te: Double,
    tt: Double,
    tx1: Double,
    tx2: Double,
    vsmax: Double,
    vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssSB4] }
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
        "\t\t<cim:PssSB4.kx>" + kx + "</cim:PssSB4.kx>\n" +
        "\t\t<cim:PssSB4.ta>" + ta + "</cim:PssSB4.ta>\n" +
        "\t\t<cim:PssSB4.tb>" + tb + "</cim:PssSB4.tb>\n" +
        "\t\t<cim:PssSB4.tc>" + tc + "</cim:PssSB4.tc>\n" +
        "\t\t<cim:PssSB4.td>" + td + "</cim:PssSB4.td>\n" +
        "\t\t<cim:PssSB4.te>" + te + "</cim:PssSB4.te>\n" +
        "\t\t<cim:PssSB4.tt>" + tt + "</cim:PssSB4.tt>\n" +
        "\t\t<cim:PssSB4.tx1>" + tx1 + "</cim:PssSB4.tx1>\n" +
        "\t\t<cim:PssSB4.tx2>" + tx2 + "</cim:PssSB4.tx2>\n" +
        "\t\t<cim:PssSB4.vsmax>" + vsmax + "</cim:PssSB4.vsmax>\n" +
        "\t\t<cim:PssSB4.vsmin>" + vsmin + "</cim:PssSB4.vsmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssSB4 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssSB4>"
    }
}

object PssSB4
extends
    Parseable[PssSB4]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    k: Double,
    k0: Double,
    k1: Double,
    k2: Double,
    k3: Double,
    k4: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    td: Double,
    vsmax: Double,
    vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssSH] }
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
        "\t\t<cim:PssSH.k>" + k + "</cim:PssSH.k>\n" +
        "\t\t<cim:PssSH.k0>" + k0 + "</cim:PssSH.k0>\n" +
        "\t\t<cim:PssSH.k1>" + k1 + "</cim:PssSH.k1>\n" +
        "\t\t<cim:PssSH.k2>" + k2 + "</cim:PssSH.k2>\n" +
        "\t\t<cim:PssSH.k3>" + k3 + "</cim:PssSH.k3>\n" +
        "\t\t<cim:PssSH.k4>" + k4 + "</cim:PssSH.k4>\n" +
        "\t\t<cim:PssSH.t1>" + t1 + "</cim:PssSH.t1>\n" +
        "\t\t<cim:PssSH.t2>" + t2 + "</cim:PssSH.t2>\n" +
        "\t\t<cim:PssSH.t3>" + t3 + "</cim:PssSH.t3>\n" +
        "\t\t<cim:PssSH.t4>" + t4 + "</cim:PssSH.t4>\n" +
        "\t\t<cim:PssSH.td>" + td + "</cim:PssSH.td>\n" +
        "\t\t<cim:PssSH.vsmax>" + vsmax + "</cim:PssSH.vsmax>\n" +
        "\t\t<cim:PssSH.vsmin>" + vsmin + "</cim:PssSH.vsmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssSH rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssSH>"
    }
}

object PssSH
extends
    Parseable[PssSH]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    k1: Double,
    k2: Double,
    k3: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    vsmax: Double,
    vsmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssSK] }
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
        "\t\t<cim:PssSK.k1>" + k1 + "</cim:PssSK.k1>\n" +
        "\t\t<cim:PssSK.k2>" + k2 + "</cim:PssSK.k2>\n" +
        "\t\t<cim:PssSK.k3>" + k3 + "</cim:PssSK.k3>\n" +
        "\t\t<cim:PssSK.t1>" + t1 + "</cim:PssSK.t1>\n" +
        "\t\t<cim:PssSK.t2>" + t2 + "</cim:PssSK.t2>\n" +
        "\t\t<cim:PssSK.t3>" + t3 + "</cim:PssSK.t3>\n" +
        "\t\t<cim:PssSK.t4>" + t4 + "</cim:PssSK.t4>\n" +
        "\t\t<cim:PssSK.t5>" + t5 + "</cim:PssSK.t5>\n" +
        "\t\t<cim:PssSK.t6>" + t6 + "</cim:PssSK.t6>\n" +
        "\t\t<cim:PssSK.vsmax>" + vsmax + "</cim:PssSK.vsmax>\n" +
        "\t\t<cim:PssSK.vsmin>" + vsmin + "</cim:PssSK.vsmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssSK rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssSK>"
    }
}

object PssSK
extends
    Parseable[PssSK]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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
    override val sup: PowerSystemStabilizerDynamics,
    inputSignal1Type: String,
    inputSignal2Type: String,
    k1: Double,
    k2: Double,
    t1: Double,
    t10: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    t9: Double,
    vcl: Double,
    vcu: Double,
    vsmax: Double,
    vsmin: Double
)
extends
    Element
{
    def this () = { this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[PssWECC] }
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
        (if (null != inputSignal1Type) "\t\t<cim:PssWECC.inputSignal1Type rdf:resource=\"#" + inputSignal1Type + "\"/>\n" else "") +
        (if (null != inputSignal2Type) "\t\t<cim:PssWECC.inputSignal2Type rdf:resource=\"#" + inputSignal2Type + "\"/>\n" else "") +
        "\t\t<cim:PssWECC.k1>" + k1 + "</cim:PssWECC.k1>\n" +
        "\t\t<cim:PssWECC.k2>" + k2 + "</cim:PssWECC.k2>\n" +
        "\t\t<cim:PssWECC.t1>" + t1 + "</cim:PssWECC.t1>\n" +
        "\t\t<cim:PssWECC.t10>" + t10 + "</cim:PssWECC.t10>\n" +
        "\t\t<cim:PssWECC.t2>" + t2 + "</cim:PssWECC.t2>\n" +
        "\t\t<cim:PssWECC.t3>" + t3 + "</cim:PssWECC.t3>\n" +
        "\t\t<cim:PssWECC.t4>" + t4 + "</cim:PssWECC.t4>\n" +
        "\t\t<cim:PssWECC.t5>" + t5 + "</cim:PssWECC.t5>\n" +
        "\t\t<cim:PssWECC.t6>" + t6 + "</cim:PssWECC.t6>\n" +
        "\t\t<cim:PssWECC.t7>" + t7 + "</cim:PssWECC.t7>\n" +
        "\t\t<cim:PssWECC.t8>" + t8 + "</cim:PssWECC.t8>\n" +
        "\t\t<cim:PssWECC.t9>" + t9 + "</cim:PssWECC.t9>\n" +
        "\t\t<cim:PssWECC.vcl>" + vcl + "</cim:PssWECC.vcl>\n" +
        "\t\t<cim:PssWECC.vcu>" + vcu + "</cim:PssWECC.vcu>\n" +
        "\t\t<cim:PssWECC.vsmax>" + vsmax + "</cim:PssWECC.vsmax>\n" +
        "\t\t<cim:PssWECC.vsmin>" + vsmin + "</cim:PssWECC.vsmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PssWECC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PssWECC>"
    }
}

object PssWECC
extends
    Parseable[PssWECC]
{
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
            PowerSystemStabilizerDynamics.parse (context),
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

private[ninecode] object _PowerSystemStabilizerDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            PowerSystemStabilizerDynamics.register,
            Pss1.register,
            Pss1A.register,
            Pss2B.register,
            Pss2ST.register,
            Pss5.register,
            PssELIN2.register,
            PssIEEE1A.register,
            PssIEEE2B.register,
            PssIEEE3B.register,
            PssIEEE4B.register,
            PssPTIST1.register,
            PssPTIST3.register,
            PssSB4.register,
            PssSH.register,
            PssSK.register,
            PssWECC.register
        )
    }
}