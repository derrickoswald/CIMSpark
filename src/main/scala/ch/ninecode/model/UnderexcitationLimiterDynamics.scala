package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Underexcitation limiters (UELs) act to boost excitation.
 * The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */

/**
 * This model can be derived from UnderexcLimIEEE2.
 * The limit characteristic (look �up table) is a single straight-line, the same as UnderexcLimIEEE2 (see Figure 10.4 (p 32), IEEE 421.5-2005 Section 10.2).
 */
case class UnderexcLim2Simplified
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * Gain Under excitation limiter (Kui).
     * Typical Value = 0.1.
     */
    val kui: Double,

    /**
     * Segment P initial point (P0).
     * Typical Value = 0.
     */
    val p0: Double,

    /**
     * Segment P end point (P1).
     * Typical Value = 1.
     */
    val p1: Double,

    /**
     * Segment Q initial point (Q0).
     * Typical Value = -0.31.
     */
    val q0: Double,

    /**
     * Segment Q end point (Q1).
     * Typical Value = -0.1.
     */
    val q1: Double,

    /**
     * Maximum error signal (V<sub>UImax</sub>).
     * Typical Value = 1.
     */
    val vuimax: Double,

    /**
     * Minimum error signal (V<sub>UImin</sub>).
     * Typical Value = 0.
     */
    val vuimin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcLim2Simplified]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcLim2Simplified
extends
    Parseable[UnderexcLim2Simplified]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val kui = parse_element (element ("""UnderexcLim2Simplified.kui"""))_
    val p0 = parse_element (element ("""UnderexcLim2Simplified.p0"""))_
    val p1 = parse_element (element ("""UnderexcLim2Simplified.p1"""))_
    val q0 = parse_element (element ("""UnderexcLim2Simplified.q0"""))_
    val q1 = parse_element (element ("""UnderexcLim2Simplified.q1"""))_
    val vuimax = parse_element (element ("""UnderexcLim2Simplified.vuimax"""))_
    val vuimin = parse_element (element ("""UnderexcLim2Simplified.vuimin"""))_
    def parse (context: Context): UnderexcLim2Simplified =
    {
        UnderexcLim2Simplified(
            sup (context),
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
 */
case class UnderexcLimIEEE1
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * UEL center setting (K<sub>UC</sub>).
     * Typical Value = 1.38.
     */
    val kuc: Double,

    /**
     * UEL excitation system stabilizer gain (K<sub>UF</sub>).
     * Typical Value = 3.3.
     */
    val kuf: Double,

    /**
     * UEL integral gain (K<sub>UI</sub>).
     * Typical Value = 0.
     */
    val kui: Double,

    /**
     * UEL proportional gain (K<sub>UL</sub>).
     * Typical Value = 100.
     */
    val kul: Double,

    /**
     * UEL radius setting (K<sub>UR</sub>).
     * Typical Value = 1.95.
     */
    val kur: Double,

    /**
     * UEL lead time constant (T<sub>U1</sub>).
     * Typical Value = 0.
     */
    val tu1: Double,

    /**
     * UEL lag time constant (T<sub>U2</sub>).
     * Typical Value = 0.05.
     */
    val tu2: Double,

    /**
     * UEL lead time constant (T<sub>U3</sub>).
     * Typical Value = 0.
     */
    val tu3: Double,

    /**
     * UEL lag time constant (T<sub>U4</sub>).
     * Typical Value = 0.
     */
    val tu4: Double,

    /**
     * UEL maximum limit for operating point phasor magnitude (V<sub>UCMAX</sub>).
     * Typical Value = 5.8.
     */
    val vucmax: Double,

    /**
     * UEL integrator output maximum limit (V<sub>UIMAX</sub>).
     */
    val vuimax: Double,

    /**
     * UEL integrator output minimum limit (V<sub>UIMIN</sub>).
     */
    val vuimin: Double,

    /**
     * UEL output maximum limit (V<sub>ULMAX</sub>).
     * Typical Value = 18.
     */
    val vulmax: Double,

    /**
     * UEL output minimum limit (V<sub>ULMIN</sub>).
     * Typical Value = -18.
     */
    val vulmin: Double,

    /**
     * UEL maximum limit for radius phasor magnitude (V<sub>URMAX</sub>).
     * Typical Value = 5.8.
     */
    val vurmax: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcLimIEEE1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcLimIEEE1
extends
    Parseable[UnderexcLimIEEE1]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val kuc = parse_element (element ("""UnderexcLimIEEE1.kuc"""))_
    val kuf = parse_element (element ("""UnderexcLimIEEE1.kuf"""))_
    val kui = parse_element (element ("""UnderexcLimIEEE1.kui"""))_
    val kul = parse_element (element ("""UnderexcLimIEEE1.kul"""))_
    val kur = parse_element (element ("""UnderexcLimIEEE1.kur"""))_
    val tu1 = parse_element (element ("""UnderexcLimIEEE1.tu1"""))_
    val tu2 = parse_element (element ("""UnderexcLimIEEE1.tu2"""))_
    val tu3 = parse_element (element ("""UnderexcLimIEEE1.tu3"""))_
    val tu4 = parse_element (element ("""UnderexcLimIEEE1.tu4"""))_
    val vucmax = parse_element (element ("""UnderexcLimIEEE1.vucmax"""))_
    val vuimax = parse_element (element ("""UnderexcLimIEEE1.vuimax"""))_
    val vuimin = parse_element (element ("""UnderexcLimIEEE1.vuimin"""))_
    val vulmax = parse_element (element ("""UnderexcLimIEEE1.vulmax"""))_
    val vulmin = parse_element (element ("""UnderexcLimIEEE1.vulmin"""))_
    val vurmax = parse_element (element ("""UnderexcLimIEEE1.vurmax"""))_
    def parse (context: Context): UnderexcLimIEEE1 =
    {
        UnderexcLimIEEE1(
            sup (context),
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
 */
case class UnderexcLimIEEE2
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * UEL terminal voltage exponent applied to real power input to UEL limit look-up table (k1).
     * Typical Value = 2.
     */
    val k1: Double,

    /**
     * UEL terminal voltage exponent applied to reactive power output from UEL limit look-up table (k2).
     * Typical Value = 2.
     */
    val k2: Double,

    /**
     * Gain associated with optional integrator feedback input signal to UEL (K<sub>FB</sub>).
     * Typical Value = 0.
     */
    val kfb: Double,

    /**
     * UEL excitation system stabilizer gain (K<sub>UF</sub>).
     * Typical Value = 0.
     */
    val kuf: Double,

    /**
     * UEL integral gain (K<sub>UI</sub>).
     * Typical Value = 0.5.
     */
    val kui: Double,

    /**
     * UEL proportional gain (K<sub>UL</sub>).
     * Typical Value = 0.8.
     */
    val kul: Double,

    /**
     * Real power values for endpoints (P<sub>0</sub>).
     * Typical Value = 0.
     */
    val p0: Double,

    /**
     * Real power values for endpoints (P<sub>1</sub>).
     * Typical Value = 0.3.
     */
    val p1: Double,

    /**
     * Real power values for endpoints (P<sub>10</sub>).
     */
    val p10: Double,

    /**
     * Real power values for endpoints (P<sub>2</sub>).
     * Typical Value = 0.6.
     */
    val p2: Double,

    /**
     * Real power values for endpoints (P<sub>3</sub>).
     * Typical Value = 0.9.
     */
    val p3: Double,

    /**
     * Real power values for endpoints (P<sub>4</sub>).
     * Typical Value = 1.02.
     */
    val p4: Double,

    /**
     * Real power values for endpoints (P<sub>5</sub>).
     */
    val p5: Double,

    /**
     * Real power values for endpoints (P<sub>6</sub>).
     */
    val p6: Double,

    /**
     * Real power values for endpoints (P<sub>7</sub>).
     */
    val p7: Double,

    /**
     * Real power values for endpoints (P<sub>8</sub>).
     */
    val p8: Double,

    /**
     * Real power values for endpoints (P<sub>9</sub>).
     */
    val p9: Double,

    /**
     * Reactive power values for endpoints (Q<sub>0</sub>).
     * Typical Value = -0.31.
     */
    val q0: Double,

    /**
     * Reactive power values for endpoints (Q<sub>1</sub>).
     * Typical Value = -0.31.
     */
    val q1: Double,

    /**
     * Reactive power values for endpoints (Q<sub>10</sub>).
     */
    val q10: Double,

    /**
     * Reactive power values for endpoints (Q<sub>2</sub>).
     * Typical Value = -0.28.
     */
    val q2: Double,

    /**
     * Reactive power values for endpoints (Q<sub>3</sub>).
     * Typical Value = -0.21.
     */
    val q3: Double,

    /**
     * Reactive power values for endpoints (Q<sub>4</sub>).
     * Typical Value = 0.
     */
    val q4: Double,

    /**
     * Reactive power values for endpoints (Q<sub>5</sub>).
     */
    val q5: Double,

    /**
     * Reactive power values for endpoints (Q<sub>6</sub>).
     */
    val q6: Double,

    /**
     * Reactive power values for endpoints (Q<sub>7</sub>).
     */
    val q7: Double,

    /**
     * Reactive power values for endpoints (Q<sub>8</sub>).
     */
    val q8: Double,

    /**
     * Reactive power values for endpoints (Q<sub>9</sub>).
     */
    val q9: Double,

    /**
     * UEL lead time constant (T<sub>U1</sub>).
     * Typical Value = 0.
     */
    val tu1: Double,

    /**
     * UEL lag time constant (T<sub>U2</sub>).
     * Typical Value = 0.
     */
    val tu2: Double,

    /**
     * UEL lead time constant (T<sub>U3</sub>).
     * Typical Value = 0.
     */
    val tu3: Double,

    /**
     * UEL lag time constant (T<sub>U4</sub>).
     * Typical Value = 0.
     */
    val tu4: Double,

    /**
     * Time constant associated with optional integrator feedback input signal to UEL (T<sub>UL</sub>).
     * Typical Value = 0.
     */
    val tul: Double,

    /**
     * Real power filter time constant (T<sub>UP</sub>).
     * Typical Value = 5.
     */
    val tup: Double,

    /**
     * Reactive power filter time constant (T<sub>UQ</sub>).
     * Typical Value = 0.
     */
    val tuq: Double,

    /**
     * Voltage filter time constant (T<sub>UV</sub>).
     * Typical Value = 5.
     */
    val tuv: Double,

    /**
     * UEL integrator output maximum limit (V<sub>UIMAX</sub>).
     * Typical Value = 0.25.
     */
    val vuimax: Double,

    /**
     * UEL integrator output minimum limit (V<sub>UIMIN</sub>).
     * Typical Value = 0.
     */
    val vuimin: Double,

    /**
     * UEL output maximum limit (V<sub>ULMAX</sub>).
     * Typical Value = 0.25.
     */
    val vulmax: Double,

    /**
     * UEL output minimum limit (V<sub>ULMIN</sub>).
     * Typical Value = 0.
     */
    val vulmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcLimIEEE2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcLimIEEE2
extends
    Parseable[UnderexcLimIEEE2]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val k1 = parse_element (element ("""UnderexcLimIEEE2.k1"""))_
    val k2 = parse_element (element ("""UnderexcLimIEEE2.k2"""))_
    val kfb = parse_element (element ("""UnderexcLimIEEE2.kfb"""))_
    val kuf = parse_element (element ("""UnderexcLimIEEE2.kuf"""))_
    val kui = parse_element (element ("""UnderexcLimIEEE2.kui"""))_
    val kul = parse_element (element ("""UnderexcLimIEEE2.kul"""))_
    val p0 = parse_element (element ("""UnderexcLimIEEE2.p0"""))_
    val p1 = parse_element (element ("""UnderexcLimIEEE2.p1"""))_
    val p10 = parse_element (element ("""UnderexcLimIEEE2.p10"""))_
    val p2 = parse_element (element ("""UnderexcLimIEEE2.p2"""))_
    val p3 = parse_element (element ("""UnderexcLimIEEE2.p3"""))_
    val p4 = parse_element (element ("""UnderexcLimIEEE2.p4"""))_
    val p5 = parse_element (element ("""UnderexcLimIEEE2.p5"""))_
    val p6 = parse_element (element ("""UnderexcLimIEEE2.p6"""))_
    val p7 = parse_element (element ("""UnderexcLimIEEE2.p7"""))_
    val p8 = parse_element (element ("""UnderexcLimIEEE2.p8"""))_
    val p9 = parse_element (element ("""UnderexcLimIEEE2.p9"""))_
    val q0 = parse_element (element ("""UnderexcLimIEEE2.q0"""))_
    val q1 = parse_element (element ("""UnderexcLimIEEE2.q1"""))_
    val q10 = parse_element (element ("""UnderexcLimIEEE2.q10"""))_
    val q2 = parse_element (element ("""UnderexcLimIEEE2.q2"""))_
    val q3 = parse_element (element ("""UnderexcLimIEEE2.q3"""))_
    val q4 = parse_element (element ("""UnderexcLimIEEE2.q4"""))_
    val q5 = parse_element (element ("""UnderexcLimIEEE2.q5"""))_
    val q6 = parse_element (element ("""UnderexcLimIEEE2.q6"""))_
    val q7 = parse_element (element ("""UnderexcLimIEEE2.q7"""))_
    val q8 = parse_element (element ("""UnderexcLimIEEE2.q8"""))_
    val q9 = parse_element (element ("""UnderexcLimIEEE2.q9"""))_
    val tu1 = parse_element (element ("""UnderexcLimIEEE2.tu1"""))_
    val tu2 = parse_element (element ("""UnderexcLimIEEE2.tu2"""))_
    val tu3 = parse_element (element ("""UnderexcLimIEEE2.tu3"""))_
    val tu4 = parse_element (element ("""UnderexcLimIEEE2.tu4"""))_
    val tul = parse_element (element ("""UnderexcLimIEEE2.tul"""))_
    val tup = parse_element (element ("""UnderexcLimIEEE2.tup"""))_
    val tuq = parse_element (element ("""UnderexcLimIEEE2.tuq"""))_
    val tuv = parse_element (element ("""UnderexcLimIEEE2.tuv"""))_
    val vuimax = parse_element (element ("""UnderexcLimIEEE2.vuimax"""))_
    val vuimin = parse_element (element ("""UnderexcLimIEEE2.vuimin"""))_
    val vulmax = parse_element (element ("""UnderexcLimIEEE2.vulmax"""))_
    val vulmin = parse_element (element ("""UnderexcLimIEEE2.vulmin"""))_
    def parse (context: Context): UnderexcLimIEEE2 =
    {
        UnderexcLimIEEE2(
            sup (context),
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
 */
case class UnderexcLimX1
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * Minimum excitation limit slope (K) (&gt;0).
     */
    val k: Double,

    /**
     * Differential gain (Kf2).
     */
    val kf2: Double,

    /**
     * Minimum excitation limit gain (Km).
     */
    val km: Double,

    /**
     * Minimum excitation limit value (MELMAX).
     */
    val melmax: Double,

    /**
     * Differential time constant (Tf2) (&gt;0).
     */
    val tf2: Double,

    /**
     * Minimum excitation limit time constant (Tm).
     */
    val tm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcLimX1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcLimX1
extends
    Parseable[UnderexcLimX1]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val k = parse_element (element ("""UnderexcLimX1.k"""))_
    val kf2 = parse_element (element ("""UnderexcLimX1.kf2"""))_
    val km = parse_element (element ("""UnderexcLimX1.km"""))_
    val melmax = parse_element (element ("""UnderexcLimX1.melmax"""))_
    val tf2 = parse_element (element ("""UnderexcLimX1.tf2"""))_
    val tm = parse_element (element ("""UnderexcLimX1.tm"""))_
    def parse (context: Context): UnderexcLimX1 =
    {
        UnderexcLimX1(
            sup (context),
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
 */
case class UnderexcLimX2
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * Differential gain (Kf2).
     */
    val kf2: Double,

    /**
     * Minimum excitation limit gain (Km).
     */
    val km: Double,

    /**
     * Minimum excitation limit value (MELMAX).
     */
    val melmax: Double,

    /**
     * Excitation center setting (Qo).
     */
    val qo: Double,

    /**
     * Excitation radius (R).
     */
    val r: Double,

    /**
     * Differential time constant (Tf2) (&gt;0).
     */
    val tf2: Double,

    /**
     * Minimum excitation limit time constant (Tm).
     */
    val tm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcLimX2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcLimX2
extends
    Parseable[UnderexcLimX2]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val kf2 = parse_element (element ("""UnderexcLimX2.kf2"""))_
    val km = parse_element (element ("""UnderexcLimX2.km"""))_
    val melmax = parse_element (element ("""UnderexcLimX2.melmax"""))_
    val qo = parse_element (element ("""UnderexcLimX2.qo"""))_
    val r = parse_element (element ("""UnderexcLimX2.r"""))_
    val tf2 = parse_element (element ("""UnderexcLimX2.tf2"""))_
    val tm = parse_element (element ("""UnderexcLimX2.tm"""))_
    def parse (context: Context): UnderexcLimX2 =
    {
        UnderexcLimX2(
            sup (context),
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
 */
case class UnderexcitationLimiterDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Excitation system model with which this underexcitation limiter model is associated.
     */
    val ExcitationSystemDynamics: String,

    /**
     * Remote input signal used by this underexcitation limiter model.
     */
    val RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcitationLimiterDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcitationLimiterDynamics
extends
    Parseable[UnderexcitationLimiterDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""UnderexcitationLimiterDynamics.ExcitationSystemDynamics"""))_
    val RemoteInputSignal = parse_attribute (attribute ("""UnderexcitationLimiterDynamics.RemoteInputSignal"""))_
    def parse (context: Context): UnderexcitationLimiterDynamics =
    {
        UnderexcitationLimiterDynamics(
            sup (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

object _UnderexcitationLimiterDynamics
{
    def register: Unit =
    {
        UnderexcLim2Simplified.register
        UnderexcLimIEEE1.register
        UnderexcLimIEEE2.register
        UnderexcLimX1.register
        UnderexcLimX2.register
        UnderexcitationLimiterDynamics.register
    }
}