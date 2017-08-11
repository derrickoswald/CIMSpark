package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Underexcitation limiters (UELs) act to boost excitation.
 * The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */

/**
 * This model can be derived from UnderexcLimIEEE2.
 * The limit characteristic (look �up table) is a single straight-line, the same as UnderexcLimIEEE2 (see Figure 10.4 (p 32), IEEE 421.5-2005 Section 10.2).
 * @param sup Reference to the superclass object.
 * @param kui Gain Under excitation limiter (Kui).
 *        Typical Value = 0.1.
 * @param p0 Segment P initial point (P0).
 *        Typical Value = 0.
 * @param p1 Segment P end point (P1).
 *        Typical Value = 1.
 * @param q0 Segment Q initial point (Q0).
 *        Typical Value = -0.31.
 * @param q1 Segment Q end point (Q1).
 *        Typical Value = -0.1.
 * @param vuimax Maximum error signal (V<sub>UImax</sub>).
 *        Typical Value = 1.
 * @param vuimin Minimum error signal (V<sub>UImin</sub>).
 *        Typical Value = 0.
 */
case class UnderexcLim2Simplified
(
    override val sup: UnderexcitationLimiterDynamics,
    kui: Double,
    p0: Double,
    p1: Double,
    q0: Double,
    q1: Double,
    vuimax: Double,
    vuimin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcLim2Simplified] }
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
        "\t\t<cim:UnderexcLim2Simplified.kui>" + kui + "</cim:UnderexcLim2Simplified.kui>\n" +
        "\t\t<cim:UnderexcLim2Simplified.p0>" + p0 + "</cim:UnderexcLim2Simplified.p0>\n" +
        "\t\t<cim:UnderexcLim2Simplified.p1>" + p1 + "</cim:UnderexcLim2Simplified.p1>\n" +
        "\t\t<cim:UnderexcLim2Simplified.q0>" + q0 + "</cim:UnderexcLim2Simplified.q0>\n" +
        "\t\t<cim:UnderexcLim2Simplified.q1>" + q1 + "</cim:UnderexcLim2Simplified.q1>\n" +
        "\t\t<cim:UnderexcLim2Simplified.vuimax>" + vuimax + "</cim:UnderexcLim2Simplified.vuimax>\n" +
        "\t\t<cim:UnderexcLim2Simplified.vuimin>" + vuimin + "</cim:UnderexcLim2Simplified.vuimin>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcLim2Simplified rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcLim2Simplified>"
    }
}

object UnderexcLim2Simplified
extends
    Parseable[UnderexcLim2Simplified]
{
    val kui: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.kui"""))
    val p0: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.p0"""))
    val p1: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.p1"""))
    val q0: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.q0"""))
    val q1: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.q1"""))
    val vuimax: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.vuimax"""))
    val vuimin: (Context) => String = parse_element (element ("""UnderexcLim2Simplified.vuimin"""))
    def parse (context: Context): UnderexcLim2Simplified =
    {
        UnderexcLim2Simplified(
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (kui (context), context),
            toDouble (p0 (context), context),
            toDouble (p1 (context), context),
            toDouble (q0 (context), context),
            toDouble (q1 (context), context),
            toDouble (vuimax (context), context),
            toDouble (vuimin (context), context)
        )
    }
}

/**
 * The class represents the Type UEL1 model which has a circular limit boundary when plotted in terms of machine reactive power vs. real power output.
 * Reference: IEEE UEL1 421.5-2005 Section 10.1.
 * @param sup Reference to the superclass object.
 * @param kuc UEL center setting (K<sub>UC</sub>).
 *        Typical Value = 1.38.
 * @param kuf UEL excitation system stabilizer gain (K<sub>UF</sub>).
 *        Typical Value = 3.3.
 * @param kui UEL integral gain (K<sub>UI</sub>).
 *        Typical Value = 0.
 * @param kul UEL proportional gain (K<sub>UL</sub>).
 *        Typical Value = 100.
 * @param kur UEL radius setting (K<sub>UR</sub>).
 *        Typical Value = 1.95.
 * @param tu1 UEL lead time constant (T<sub>U1</sub>).
 *        Typical Value = 0.
 * @param tu2 UEL lag time constant (T<sub>U2</sub>).
 *        Typical Value = 0.05.
 * @param tu3 UEL lead time constant (T<sub>U3</sub>).
 *        Typical Value = 0.
 * @param tu4 UEL lag time constant (T<sub>U4</sub>).
 *        Typical Value = 0.
 * @param vucmax UEL maximum limit for operating point phasor magnitude (V<sub>UCMAX</sub>).
 *        Typical Value = 5.8.
 * @param vuimax UEL integrator output maximum limit (V<sub>UIMAX</sub>).
 * @param vuimin UEL integrator output minimum limit (V<sub>UIMIN</sub>).
 * @param vulmax UEL output maximum limit (V<sub>ULMAX</sub>).
 *        Typical Value = 18.
 * @param vulmin UEL output minimum limit (V<sub>ULMIN</sub>).
 *        Typical Value = -18.
 * @param vurmax UEL maximum limit for radius phasor magnitude (V<sub>URMAX</sub>).
 *        Typical Value = 5.8.
 */
case class UnderexcLimIEEE1
(
    override val sup: UnderexcitationLimiterDynamics,
    kuc: Double,
    kuf: Double,
    kui: Double,
    kul: Double,
    kur: Double,
    tu1: Double,
    tu2: Double,
    tu3: Double,
    tu4: Double,
    vucmax: Double,
    vuimax: Double,
    vuimin: Double,
    vulmax: Double,
    vulmin: Double,
    vurmax: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcLimIEEE1] }
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
        "\t\t<cim:UnderexcLimIEEE1.kuc>" + kuc + "</cim:UnderexcLimIEEE1.kuc>\n" +
        "\t\t<cim:UnderexcLimIEEE1.kuf>" + kuf + "</cim:UnderexcLimIEEE1.kuf>\n" +
        "\t\t<cim:UnderexcLimIEEE1.kui>" + kui + "</cim:UnderexcLimIEEE1.kui>\n" +
        "\t\t<cim:UnderexcLimIEEE1.kul>" + kul + "</cim:UnderexcLimIEEE1.kul>\n" +
        "\t\t<cim:UnderexcLimIEEE1.kur>" + kur + "</cim:UnderexcLimIEEE1.kur>\n" +
        "\t\t<cim:UnderexcLimIEEE1.tu1>" + tu1 + "</cim:UnderexcLimIEEE1.tu1>\n" +
        "\t\t<cim:UnderexcLimIEEE1.tu2>" + tu2 + "</cim:UnderexcLimIEEE1.tu2>\n" +
        "\t\t<cim:UnderexcLimIEEE1.tu3>" + tu3 + "</cim:UnderexcLimIEEE1.tu3>\n" +
        "\t\t<cim:UnderexcLimIEEE1.tu4>" + tu4 + "</cim:UnderexcLimIEEE1.tu4>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vucmax>" + vucmax + "</cim:UnderexcLimIEEE1.vucmax>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vuimax>" + vuimax + "</cim:UnderexcLimIEEE1.vuimax>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vuimin>" + vuimin + "</cim:UnderexcLimIEEE1.vuimin>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vulmax>" + vulmax + "</cim:UnderexcLimIEEE1.vulmax>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vulmin>" + vulmin + "</cim:UnderexcLimIEEE1.vulmin>\n" +
        "\t\t<cim:UnderexcLimIEEE1.vurmax>" + vurmax + "</cim:UnderexcLimIEEE1.vurmax>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimIEEE1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcLimIEEE1>"
    }
}

object UnderexcLimIEEE1
extends
    Parseable[UnderexcLimIEEE1]
{
    val kuc: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.kuc"""))
    val kuf: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.kuf"""))
    val kui: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.kui"""))
    val kul: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.kul"""))
    val kur: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.kur"""))
    val tu1: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.tu1"""))
    val tu2: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.tu2"""))
    val tu3: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.tu3"""))
    val tu4: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.tu4"""))
    val vucmax: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vucmax"""))
    val vuimax: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vuimax"""))
    val vuimin: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vuimin"""))
    val vulmax: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vulmax"""))
    val vulmin: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vulmin"""))
    val vurmax: (Context) => String = parse_element (element ("""UnderexcLimIEEE1.vurmax"""))
    def parse (context: Context): UnderexcLimIEEE1 =
    {
        UnderexcLimIEEE1(
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (kuc (context), context),
            toDouble (kuf (context), context),
            toDouble (kui (context), context),
            toDouble (kul (context), context),
            toDouble (kur (context), context),
            toDouble (tu1 (context), context),
            toDouble (tu2 (context), context),
            toDouble (tu3 (context), context),
            toDouble (tu4 (context), context),
            toDouble (vucmax (context), context),
            toDouble (vuimax (context), context),
            toDouble (vuimin (context), context),
            toDouble (vulmax (context), context),
            toDouble (vulmin (context), context),
            toDouble (vurmax (context), context)
        )
    }
}

/**
 * The class represents the Type UEL2 which has either a straight-line or multi-segment characteristic when plotted in terms of machine reactive power output vs. real power output.
 * Reference: IEEE UEL2 421.5-2005 Section 10.2.  (Limit characteristic lookup table shown in Figure 10.4 (p 32) of the standard).
 * @param sup Reference to the superclass object.
 * @param k1 UEL terminal voltage exponent applied to real power input to UEL limit look-up table (k1).
 *        Typical Value = 2.
 * @param k2 UEL terminal voltage exponent applied to reactive power output from UEL limit look-up table (k2).
 *        Typical Value = 2.
 * @param kfb Gain associated with optional integrator feedback input signal to UEL (K<sub>FB</sub>).
 *        Typical Value = 0.
 * @param kuf UEL excitation system stabilizer gain (K<sub>UF</sub>).
 *        Typical Value = 0.
 * @param kui UEL integral gain (K<sub>UI</sub>).
 *        Typical Value = 0.5.
 * @param kul UEL proportional gain (K<sub>UL</sub>).
 *        Typical Value = 0.8.
 * @param p0 Real power values for endpoints (P<sub>0</sub>).
 *        Typical Value = 0.
 * @param p1 Real power values for endpoints (P<sub>1</sub>).
 *        Typical Value = 0.3.
 * @param p10 Real power values for endpoints (P<sub>10</sub>).
 * @param p2 Real power values for endpoints (P<sub>2</sub>).
 *        Typical Value = 0.6.
 * @param p3 Real power values for endpoints (P<sub>3</sub>).
 *        Typical Value = 0.9.
 * @param p4 Real power values for endpoints (P<sub>4</sub>).
 *        Typical Value = 1.02.
 * @param p5 Real power values for endpoints (P<sub>5</sub>).
 * @param p6 Real power values for endpoints (P<sub>6</sub>).
 * @param p7 Real power values for endpoints (P<sub>7</sub>).
 * @param p8 Real power values for endpoints (P<sub>8</sub>).
 * @param p9 Real power values for endpoints (P<sub>9</sub>).
 * @param q0 Reactive power values for endpoints (Q<sub>0</sub>).
 *        Typical Value = -0.31.
 * @param q1 Reactive power values for endpoints (Q<sub>1</sub>).
 *        Typical Value = -0.31.
 * @param q10 Reactive power values for endpoints (Q<sub>10</sub>).
 * @param q2 Reactive power values for endpoints (Q<sub>2</sub>).
 *        Typical Value = -0.28.
 * @param q3 Reactive power values for endpoints (Q<sub>3</sub>).
 *        Typical Value = -0.21.
 * @param q4 Reactive power values for endpoints (Q<sub>4</sub>).
 *        Typical Value = 0.
 * @param q5 Reactive power values for endpoints (Q<sub>5</sub>).
 * @param q6 Reactive power values for endpoints (Q<sub>6</sub>).
 * @param q7 Reactive power values for endpoints (Q<sub>7</sub>).
 * @param q8 Reactive power values for endpoints (Q<sub>8</sub>).
 * @param q9 Reactive power values for endpoints (Q<sub>9</sub>).
 * @param tu1 UEL lead time constant (T<sub>U1</sub>).
 *        Typical Value = 0.
 * @param tu2 UEL lag time constant (T<sub>U2</sub>).
 *        Typical Value = 0.
 * @param tu3 UEL lead time constant (T<sub>U3</sub>).
 *        Typical Value = 0.
 * @param tu4 UEL lag time constant (T<sub>U4</sub>).
 *        Typical Value = 0.
 * @param tul Time constant associated with optional integrator feedback input signal to UEL (T<sub>UL</sub>).
 *        Typical Value = 0.
 * @param tup Real power filter time constant (T<sub>UP</sub>).
 *        Typical Value = 5.
 * @param tuq Reactive power filter time constant (T<sub>UQ</sub>).
 *        Typical Value = 0.
 * @param tuv Voltage filter time constant (T<sub>UV</sub>).
 *        Typical Value = 5.
 * @param vuimax UEL integrator output maximum limit (V<sub>UIMAX</sub>).
 *        Typical Value = 0.25.
 * @param vuimin UEL integrator output minimum limit (V<sub>UIMIN</sub>).
 *        Typical Value = 0.
 * @param vulmax UEL output maximum limit (V<sub>ULMAX</sub>).
 *        Typical Value = 0.25.
 * @param vulmin UEL output minimum limit (V<sub>ULMIN</sub>).
 *        Typical Value = 0.
 */
case class UnderexcLimIEEE2
(
    override val sup: UnderexcitationLimiterDynamics,
    k1: Double,
    k2: Double,
    kfb: Double,
    kuf: Double,
    kui: Double,
    kul: Double,
    p0: Double,
    p1: Double,
    p10: Double,
    p2: Double,
    p3: Double,
    p4: Double,
    p5: Double,
    p6: Double,
    p7: Double,
    p8: Double,
    p9: Double,
    q0: Double,
    q1: Double,
    q10: Double,
    q2: Double,
    q3: Double,
    q4: Double,
    q5: Double,
    q6: Double,
    q7: Double,
    q8: Double,
    q9: Double,
    tu1: Double,
    tu2: Double,
    tu3: Double,
    tu4: Double,
    tul: Double,
    tup: Double,
    tuq: Double,
    tuv: Double,
    vuimax: Double,
    vuimin: Double,
    vulmax: Double,
    vulmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcLimIEEE2] }
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
        "\t\t<cim:UnderexcLimIEEE2.k1>" + k1 + "</cim:UnderexcLimIEEE2.k1>\n" +
        "\t\t<cim:UnderexcLimIEEE2.k2>" + k2 + "</cim:UnderexcLimIEEE2.k2>\n" +
        "\t\t<cim:UnderexcLimIEEE2.kfb>" + kfb + "</cim:UnderexcLimIEEE2.kfb>\n" +
        "\t\t<cim:UnderexcLimIEEE2.kuf>" + kuf + "</cim:UnderexcLimIEEE2.kuf>\n" +
        "\t\t<cim:UnderexcLimIEEE2.kui>" + kui + "</cim:UnderexcLimIEEE2.kui>\n" +
        "\t\t<cim:UnderexcLimIEEE2.kul>" + kul + "</cim:UnderexcLimIEEE2.kul>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p0>" + p0 + "</cim:UnderexcLimIEEE2.p0>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p1>" + p1 + "</cim:UnderexcLimIEEE2.p1>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p10>" + p10 + "</cim:UnderexcLimIEEE2.p10>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p2>" + p2 + "</cim:UnderexcLimIEEE2.p2>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p3>" + p3 + "</cim:UnderexcLimIEEE2.p3>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p4>" + p4 + "</cim:UnderexcLimIEEE2.p4>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p5>" + p5 + "</cim:UnderexcLimIEEE2.p5>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p6>" + p6 + "</cim:UnderexcLimIEEE2.p6>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p7>" + p7 + "</cim:UnderexcLimIEEE2.p7>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p8>" + p8 + "</cim:UnderexcLimIEEE2.p8>\n" +
        "\t\t<cim:UnderexcLimIEEE2.p9>" + p9 + "</cim:UnderexcLimIEEE2.p9>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q0>" + q0 + "</cim:UnderexcLimIEEE2.q0>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q1>" + q1 + "</cim:UnderexcLimIEEE2.q1>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q10>" + q10 + "</cim:UnderexcLimIEEE2.q10>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q2>" + q2 + "</cim:UnderexcLimIEEE2.q2>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q3>" + q3 + "</cim:UnderexcLimIEEE2.q3>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q4>" + q4 + "</cim:UnderexcLimIEEE2.q4>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q5>" + q5 + "</cim:UnderexcLimIEEE2.q5>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q6>" + q6 + "</cim:UnderexcLimIEEE2.q6>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q7>" + q7 + "</cim:UnderexcLimIEEE2.q7>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q8>" + q8 + "</cim:UnderexcLimIEEE2.q8>\n" +
        "\t\t<cim:UnderexcLimIEEE2.q9>" + q9 + "</cim:UnderexcLimIEEE2.q9>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tu1>" + tu1 + "</cim:UnderexcLimIEEE2.tu1>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tu2>" + tu2 + "</cim:UnderexcLimIEEE2.tu2>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tu3>" + tu3 + "</cim:UnderexcLimIEEE2.tu3>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tu4>" + tu4 + "</cim:UnderexcLimIEEE2.tu4>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tul>" + tul + "</cim:UnderexcLimIEEE2.tul>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tup>" + tup + "</cim:UnderexcLimIEEE2.tup>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tuq>" + tuq + "</cim:UnderexcLimIEEE2.tuq>\n" +
        "\t\t<cim:UnderexcLimIEEE2.tuv>" + tuv + "</cim:UnderexcLimIEEE2.tuv>\n" +
        "\t\t<cim:UnderexcLimIEEE2.vuimax>" + vuimax + "</cim:UnderexcLimIEEE2.vuimax>\n" +
        "\t\t<cim:UnderexcLimIEEE2.vuimin>" + vuimin + "</cim:UnderexcLimIEEE2.vuimin>\n" +
        "\t\t<cim:UnderexcLimIEEE2.vulmax>" + vulmax + "</cim:UnderexcLimIEEE2.vulmax>\n" +
        "\t\t<cim:UnderexcLimIEEE2.vulmin>" + vulmin + "</cim:UnderexcLimIEEE2.vulmin>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimIEEE2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcLimIEEE2>"
    }
}

object UnderexcLimIEEE2
extends
    Parseable[UnderexcLimIEEE2]
{
    val k1: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.k1"""))
    val k2: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.k2"""))
    val kfb: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.kfb"""))
    val kuf: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.kuf"""))
    val kui: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.kui"""))
    val kul: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.kul"""))
    val p0: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p0"""))
    val p1: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p1"""))
    val p10: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p10"""))
    val p2: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p2"""))
    val p3: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p3"""))
    val p4: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p4"""))
    val p5: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p5"""))
    val p6: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p6"""))
    val p7: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p7"""))
    val p8: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p8"""))
    val p9: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.p9"""))
    val q0: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q0"""))
    val q1: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q1"""))
    val q10: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q10"""))
    val q2: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q2"""))
    val q3: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q3"""))
    val q4: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q4"""))
    val q5: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q5"""))
    val q6: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q6"""))
    val q7: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q7"""))
    val q8: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q8"""))
    val q9: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.q9"""))
    val tu1: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tu1"""))
    val tu2: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tu2"""))
    val tu3: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tu3"""))
    val tu4: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tu4"""))
    val tul: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tul"""))
    val tup: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tup"""))
    val tuq: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tuq"""))
    val tuv: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.tuv"""))
    val vuimax: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.vuimax"""))
    val vuimin: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.vuimin"""))
    val vulmax: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.vulmax"""))
    val vulmin: (Context) => String = parse_element (element ("""UnderexcLimIEEE2.vulmin"""))
    def parse (context: Context): UnderexcLimIEEE2 =
    {
        UnderexcLimIEEE2(
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (kfb (context), context),
            toDouble (kuf (context), context),
            toDouble (kui (context), context),
            toDouble (kul (context), context),
            toDouble (p0 (context), context),
            toDouble (p1 (context), context),
            toDouble (p10 (context), context),
            toDouble (p2 (context), context),
            toDouble (p3 (context), context),
            toDouble (p4 (context), context),
            toDouble (p5 (context), context),
            toDouble (p6 (context), context),
            toDouble (p7 (context), context),
            toDouble (p8 (context), context),
            toDouble (p9 (context), context),
            toDouble (q0 (context), context),
            toDouble (q1 (context), context),
            toDouble (q10 (context), context),
            toDouble (q2 (context), context),
            toDouble (q3 (context), context),
            toDouble (q4 (context), context),
            toDouble (q5 (context), context),
            toDouble (q6 (context), context),
            toDouble (q7 (context), context),
            toDouble (q8 (context), context),
            toDouble (q9 (context), context),
            toDouble (tu1 (context), context),
            toDouble (tu2 (context), context),
            toDouble (tu3 (context), context),
            toDouble (tu4 (context), context),
            toDouble (tul (context), context),
            toDouble (tup (context), context),
            toDouble (tuq (context), context),
            toDouble (tuv (context), context),
            toDouble (vuimax (context), context),
            toDouble (vuimin (context), context),
            toDouble (vulmax (context), context),
            toDouble (vulmin (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Allis-Chalmers minimum excitation limiter.</font>
 * @param sup Reference to the superclass object.
 * @param k Minimum excitation limit slope (K) (&gt;0).
 * @param kf2 Differential gain (Kf2).
 * @param km Minimum excitation limit gain (Km).
 * @param melmax Minimum excitation limit value (MELMAX).
 * @param tf2 Differential time constant (Tf2) (&gt;0).
 * @param tm Minimum excitation limit time constant (Tm).
 */
case class UnderexcLimX1
(
    override val sup: UnderexcitationLimiterDynamics,
    k: Double,
    kf2: Double,
    km: Double,
    melmax: Double,
    tf2: Double,
    tm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcLimX1] }
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
        "\t\t<cim:UnderexcLimX1.k>" + k + "</cim:UnderexcLimX1.k>\n" +
        "\t\t<cim:UnderexcLimX1.kf2>" + kf2 + "</cim:UnderexcLimX1.kf2>\n" +
        "\t\t<cim:UnderexcLimX1.km>" + km + "</cim:UnderexcLimX1.km>\n" +
        "\t\t<cim:UnderexcLimX1.melmax>" + melmax + "</cim:UnderexcLimX1.melmax>\n" +
        "\t\t<cim:UnderexcLimX1.tf2>" + tf2 + "</cim:UnderexcLimX1.tf2>\n" +
        "\t\t<cim:UnderexcLimX1.tm>" + tm + "</cim:UnderexcLimX1.tm>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimX1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcLimX1>"
    }
}

object UnderexcLimX1
extends
    Parseable[UnderexcLimX1]
{
    val k: (Context) => String = parse_element (element ("""UnderexcLimX1.k"""))
    val kf2: (Context) => String = parse_element (element ("""UnderexcLimX1.kf2"""))
    val km: (Context) => String = parse_element (element ("""UnderexcLimX1.km"""))
    val melmax: (Context) => String = parse_element (element ("""UnderexcLimX1.melmax"""))
    val tf2: (Context) => String = parse_element (element ("""UnderexcLimX1.tf2"""))
    val tm: (Context) => String = parse_element (element ("""UnderexcLimX1.tm"""))
    def parse (context: Context): UnderexcLimX1 =
    {
        UnderexcLimX1(
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (k (context), context),
            toDouble (kf2 (context), context),
            toDouble (km (context), context),
            toDouble (melmax (context), context),
            toDouble (tf2 (context), context),
            toDouble (tm (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Westinghouse minimum excitation limiter.</font>
 * @param sup Reference to the superclass object.
 * @param kf2 Differential gain (Kf2).
 * @param km Minimum excitation limit gain (Km).
 * @param melmax Minimum excitation limit value (MELMAX).
 * @param qo Excitation center setting (Qo).
 * @param r Excitation radius (R).
 * @param tf2 Differential time constant (Tf2) (&gt;0).
 * @param tm Minimum excitation limit time constant (Tm).
 */
case class UnderexcLimX2
(
    override val sup: UnderexcitationLimiterDynamics,
    kf2: Double,
    km: Double,
    melmax: Double,
    qo: Double,
    r: Double,
    tf2: Double,
    tm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcLimX2] }
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
        "\t\t<cim:UnderexcLimX2.kf2>" + kf2 + "</cim:UnderexcLimX2.kf2>\n" +
        "\t\t<cim:UnderexcLimX2.km>" + km + "</cim:UnderexcLimX2.km>\n" +
        "\t\t<cim:UnderexcLimX2.melmax>" + melmax + "</cim:UnderexcLimX2.melmax>\n" +
        "\t\t<cim:UnderexcLimX2.qo>" + qo + "</cim:UnderexcLimX2.qo>\n" +
        "\t\t<cim:UnderexcLimX2.r>" + r + "</cim:UnderexcLimX2.r>\n" +
        "\t\t<cim:UnderexcLimX2.tf2>" + tf2 + "</cim:UnderexcLimX2.tf2>\n" +
        "\t\t<cim:UnderexcLimX2.tm>" + tm + "</cim:UnderexcLimX2.tm>\n"
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimX2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcLimX2>"
    }
}

object UnderexcLimX2
extends
    Parseable[UnderexcLimX2]
{
    val kf2: (Context) => String = parse_element (element ("""UnderexcLimX2.kf2"""))
    val km: (Context) => String = parse_element (element ("""UnderexcLimX2.km"""))
    val melmax: (Context) => String = parse_element (element ("""UnderexcLimX2.melmax"""))
    val qo: (Context) => String = parse_element (element ("""UnderexcLimX2.qo"""))
    val r: (Context) => String = parse_element (element ("""UnderexcLimX2.r"""))
    val tf2: (Context) => String = parse_element (element ("""UnderexcLimX2.tf2"""))
    val tm: (Context) => String = parse_element (element ("""UnderexcLimX2.tm"""))
    def parse (context: Context): UnderexcLimX2 =
    {
        UnderexcLimX2(
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (kf2 (context), context),
            toDouble (km (context), context),
            toDouble (melmax (context), context),
            toDouble (qo (context), context),
            toDouble (r (context), context),
            toDouble (tf2 (context), context),
            toDouble (tm (context), context)
        )
    }
}

/**
 * Underexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this underexcitation limiter model is associated.
 * @param RemoteInputSignal Remote input signal used by this underexcitation limiter model.
 */
case class UnderexcitationLimiterDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String,
    RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[UnderexcitationLimiterDynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:UnderexcitationLimiterDynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:UnderexcitationLimiterDynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UnderexcitationLimiterDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnderexcitationLimiterDynamics>"
    }
}

object UnderexcitationLimiterDynamics
extends
    Parseable[UnderexcitationLimiterDynamics]
{
    val ExcitationSystemDynamics: (Context) => String = parse_attribute (attribute ("""UnderexcitationLimiterDynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal: (Context) => String = parse_attribute (attribute ("""UnderexcitationLimiterDynamics.RemoteInputSignal"""))
    def parse (context: Context): UnderexcitationLimiterDynamics =
    {
        UnderexcitationLimiterDynamics(
            DynamicsFunctionBlock.parse (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

private[ninecode] object _UnderexcitationLimiterDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            UnderexcLim2Simplified.register,
            UnderexcLimIEEE1.register,
            UnderexcLimIEEE2.register,
            UnderexcLimX1.register,
            UnderexcLimX2.register,
            UnderexcitationLimiterDynamics.register
        )
    }
}