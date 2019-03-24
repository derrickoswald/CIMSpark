package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * This model can be derived from UnderexcLimIEEE2.
 *
 * The limit characteristic (look �up table) is a single straight-line, the same as UnderexcLimIEEE2 (see Figure 10.4 (p 32), IEEE 421.5-2005 Section 10.2).
 *
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
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
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcLim2Simplified.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcLim2Simplified.fields (position), value)
        emitelem (0, kui)
        emitelem (1, p0)
        emitelem (2, p1)
        emitelem (3, q0)
        emitelem (4, q1)
        emitelem (5, vuimax)
        emitelem (6, vuimin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcLim2Simplified rdf:ID=\"%s\">\n%s\t</cim:UnderexcLim2Simplified>".format (id, export_fields)
    }
}

object UnderexcLim2Simplified
extends
    Parseable[UnderexcLim2Simplified]
{
    override val fields: Array[String] = Array[String] (
        "kui",
        "p0",
        "p1",
        "q0",
        "q1",
        "vuimax",
        "vuimin"
    )
    val kui: Fielder = parse_element (element (cls, fields(0)))
    val p0: Fielder = parse_element (element (cls, fields(1)))
    val p1: Fielder = parse_element (element (cls, fields(2)))
    val q0: Fielder = parse_element (element (cls, fields(3)))
    val q1: Fielder = parse_element (element (cls, fields(4)))
    val vuimax: Fielder = parse_element (element (cls, fields(5)))
    val vuimin: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): UnderexcLim2Simplified =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UnderexcLim2Simplified (
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (mask (kui (), 0)),
            toDouble (mask (p0 (), 1)),
            toDouble (mask (p1 (), 2)),
            toDouble (mask (q0 (), 3)),
            toDouble (mask (q1 (), 4)),
            toDouble (mask (vuimax (), 5)),
            toDouble (mask (vuimin (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents the Type UEL1 model which has a circular limit boundary when plotted in terms of machine reactive power vs. real power output.
 *
 * Reference: IEEE UEL1 421.5-2005 Section 10.1.
 *
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
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
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcLimIEEE1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcLimIEEE1.fields (position), value)
        emitelem (0, kuc)
        emitelem (1, kuf)
        emitelem (2, kui)
        emitelem (3, kul)
        emitelem (4, kur)
        emitelem (5, tu1)
        emitelem (6, tu2)
        emitelem (7, tu3)
        emitelem (8, tu4)
        emitelem (9, vucmax)
        emitelem (10, vuimax)
        emitelem (11, vuimin)
        emitelem (12, vulmax)
        emitelem (13, vulmin)
        emitelem (14, vurmax)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimIEEE1 rdf:ID=\"%s\">\n%s\t</cim:UnderexcLimIEEE1>".format (id, export_fields)
    }
}

object UnderexcLimIEEE1
extends
    Parseable[UnderexcLimIEEE1]
{
    override val fields: Array[String] = Array[String] (
        "kuc",
        "kuf",
        "kui",
        "kul",
        "kur",
        "tu1",
        "tu2",
        "tu3",
        "tu4",
        "vucmax",
        "vuimax",
        "vuimin",
        "vulmax",
        "vulmin",
        "vurmax"
    )
    val kuc: Fielder = parse_element (element (cls, fields(0)))
    val kuf: Fielder = parse_element (element (cls, fields(1)))
    val kui: Fielder = parse_element (element (cls, fields(2)))
    val kul: Fielder = parse_element (element (cls, fields(3)))
    val kur: Fielder = parse_element (element (cls, fields(4)))
    val tu1: Fielder = parse_element (element (cls, fields(5)))
    val tu2: Fielder = parse_element (element (cls, fields(6)))
    val tu3: Fielder = parse_element (element (cls, fields(7)))
    val tu4: Fielder = parse_element (element (cls, fields(8)))
    val vucmax: Fielder = parse_element (element (cls, fields(9)))
    val vuimax: Fielder = parse_element (element (cls, fields(10)))
    val vuimin: Fielder = parse_element (element (cls, fields(11)))
    val vulmax: Fielder = parse_element (element (cls, fields(12)))
    val vulmin: Fielder = parse_element (element (cls, fields(13)))
    val vurmax: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): UnderexcLimIEEE1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UnderexcLimIEEE1 (
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (mask (kuc (), 0)),
            toDouble (mask (kuf (), 1)),
            toDouble (mask (kui (), 2)),
            toDouble (mask (kul (), 3)),
            toDouble (mask (kur (), 4)),
            toDouble (mask (tu1 (), 5)),
            toDouble (mask (tu2 (), 6)),
            toDouble (mask (tu3 (), 7)),
            toDouble (mask (tu4 (), 8)),
            toDouble (mask (vucmax (), 9)),
            toDouble (mask (vuimax (), 10)),
            toDouble (mask (vuimin (), 11)),
            toDouble (mask (vulmax (), 12)),
            toDouble (mask (vulmin (), 13)),
            toDouble (mask (vurmax (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents the Type UEL2 which has either a straight-line or multi-segment characteristic when plotted in terms of machine reactive power output vs. real power output.
 *
 * Reference: IEEE UEL2 421.5-2005 Section 10.2.  (Limit characteristic lookup table shown in Figure 10.4 (p 32) of the standard).
 *
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
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
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcLimIEEE2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcLimIEEE2.fields (position), value)
        emitelem (0, k1)
        emitelem (1, k2)
        emitelem (2, kfb)
        emitelem (3, kuf)
        emitelem (4, kui)
        emitelem (5, kul)
        emitelem (6, p0)
        emitelem (7, p1)
        emitelem (8, p10)
        emitelem (9, p2)
        emitelem (10, p3)
        emitelem (11, p4)
        emitelem (12, p5)
        emitelem (13, p6)
        emitelem (14, p7)
        emitelem (15, p8)
        emitelem (16, p9)
        emitelem (17, q0)
        emitelem (18, q1)
        emitelem (19, q10)
        emitelem (20, q2)
        emitelem (21, q3)
        emitelem (22, q4)
        emitelem (23, q5)
        emitelem (24, q6)
        emitelem (25, q7)
        emitelem (26, q8)
        emitelem (27, q9)
        emitelem (28, tu1)
        emitelem (29, tu2)
        emitelem (30, tu3)
        emitelem (31, tu4)
        emitelem (32, tul)
        emitelem (33, tup)
        emitelem (34, tuq)
        emitelem (35, tuv)
        emitelem (36, vuimax)
        emitelem (37, vuimin)
        emitelem (38, vulmax)
        emitelem (39, vulmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimIEEE2 rdf:ID=\"%s\">\n%s\t</cim:UnderexcLimIEEE2>".format (id, export_fields)
    }
}

object UnderexcLimIEEE2
extends
    Parseable[UnderexcLimIEEE2]
{
    override val fields: Array[String] = Array[String] (
        "k1",
        "k2",
        "kfb",
        "kuf",
        "kui",
        "kul",
        "p0",
        "p1",
        "p10",
        "p2",
        "p3",
        "p4",
        "p5",
        "p6",
        "p7",
        "p8",
        "p9",
        "q0",
        "q1",
        "q10",
        "q2",
        "q3",
        "q4",
        "q5",
        "q6",
        "q7",
        "q8",
        "q9",
        "tu1",
        "tu2",
        "tu3",
        "tu4",
        "tul",
        "tup",
        "tuq",
        "tuv",
        "vuimax",
        "vuimin",
        "vulmax",
        "vulmin"
    )
    val k1: Fielder = parse_element (element (cls, fields(0)))
    val k2: Fielder = parse_element (element (cls, fields(1)))
    val kfb: Fielder = parse_element (element (cls, fields(2)))
    val kuf: Fielder = parse_element (element (cls, fields(3)))
    val kui: Fielder = parse_element (element (cls, fields(4)))
    val kul: Fielder = parse_element (element (cls, fields(5)))
    val p0: Fielder = parse_element (element (cls, fields(6)))
    val p1: Fielder = parse_element (element (cls, fields(7)))
    val p10: Fielder = parse_element (element (cls, fields(8)))
    val p2: Fielder = parse_element (element (cls, fields(9)))
    val p3: Fielder = parse_element (element (cls, fields(10)))
    val p4: Fielder = parse_element (element (cls, fields(11)))
    val p5: Fielder = parse_element (element (cls, fields(12)))
    val p6: Fielder = parse_element (element (cls, fields(13)))
    val p7: Fielder = parse_element (element (cls, fields(14)))
    val p8: Fielder = parse_element (element (cls, fields(15)))
    val p9: Fielder = parse_element (element (cls, fields(16)))
    val q0: Fielder = parse_element (element (cls, fields(17)))
    val q1: Fielder = parse_element (element (cls, fields(18)))
    val q10: Fielder = parse_element (element (cls, fields(19)))
    val q2: Fielder = parse_element (element (cls, fields(20)))
    val q3: Fielder = parse_element (element (cls, fields(21)))
    val q4: Fielder = parse_element (element (cls, fields(22)))
    val q5: Fielder = parse_element (element (cls, fields(23)))
    val q6: Fielder = parse_element (element (cls, fields(24)))
    val q7: Fielder = parse_element (element (cls, fields(25)))
    val q8: Fielder = parse_element (element (cls, fields(26)))
    val q9: Fielder = parse_element (element (cls, fields(27)))
    val tu1: Fielder = parse_element (element (cls, fields(28)))
    val tu2: Fielder = parse_element (element (cls, fields(29)))
    val tu3: Fielder = parse_element (element (cls, fields(30)))
    val tu4: Fielder = parse_element (element (cls, fields(31)))
    val tul: Fielder = parse_element (element (cls, fields(32)))
    val tup: Fielder = parse_element (element (cls, fields(33)))
    val tuq: Fielder = parse_element (element (cls, fields(34)))
    val tuv: Fielder = parse_element (element (cls, fields(35)))
    val vuimax: Fielder = parse_element (element (cls, fields(36)))
    val vuimin: Fielder = parse_element (element (cls, fields(37)))
    val vulmax: Fielder = parse_element (element (cls, fields(38)))
    val vulmin: Fielder = parse_element (element (cls, fields(39)))

    def parse (context: Context): UnderexcLimIEEE2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0,0)
        val ret = UnderexcLimIEEE2 (
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (mask (k1 (), 0)),
            toDouble (mask (k2 (), 1)),
            toDouble (mask (kfb (), 2)),
            toDouble (mask (kuf (), 3)),
            toDouble (mask (kui (), 4)),
            toDouble (mask (kul (), 5)),
            toDouble (mask (p0 (), 6)),
            toDouble (mask (p1 (), 7)),
            toDouble (mask (p10 (), 8)),
            toDouble (mask (p2 (), 9)),
            toDouble (mask (p3 (), 10)),
            toDouble (mask (p4 (), 11)),
            toDouble (mask (p5 (), 12)),
            toDouble (mask (p6 (), 13)),
            toDouble (mask (p7 (), 14)),
            toDouble (mask (p8 (), 15)),
            toDouble (mask (p9 (), 16)),
            toDouble (mask (q0 (), 17)),
            toDouble (mask (q1 (), 18)),
            toDouble (mask (q10 (), 19)),
            toDouble (mask (q2 (), 20)),
            toDouble (mask (q3 (), 21)),
            toDouble (mask (q4 (), 22)),
            toDouble (mask (q5 (), 23)),
            toDouble (mask (q6 (), 24)),
            toDouble (mask (q7 (), 25)),
            toDouble (mask (q8 (), 26)),
            toDouble (mask (q9 (), 27)),
            toDouble (mask (tu1 (), 28)),
            toDouble (mask (tu2 (), 29)),
            toDouble (mask (tu3 (), 30)),
            toDouble (mask (tu4 (), 31)),
            toDouble (mask (tul (), 32)),
            toDouble (mask (tup (), 33)),
            toDouble (mask (tuq (), 34)),
            toDouble (mask (tuv (), 35)),
            toDouble (mask (vuimax (), 36)),
            toDouble (mask (vuimin (), 37)),
            toDouble (mask (vulmax (), 38)),
            toDouble (mask (vulmin (), 39))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * <font color="#0f0f0f">Allis-Chalmers minimum excitation limiter.</font>
 *
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param k Minimum excitation limit slope (K) (&gt;0).
 * @param kf2 Differential gain (Kf2).
 * @param km Minimum excitation limit gain (Km).
 * @param melmax Minimum excitation limit value (MELMAX).
 * @param tf2 Differential time constant (Tf2) (&gt;0).
 * @param tm Minimum excitation limit time constant (Tm).
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcLimX1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcLimX1.fields (position), value)
        emitelem (0, k)
        emitelem (1, kf2)
        emitelem (2, km)
        emitelem (3, melmax)
        emitelem (4, tf2)
        emitelem (5, tm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimX1 rdf:ID=\"%s\">\n%s\t</cim:UnderexcLimX1>".format (id, export_fields)
    }
}

object UnderexcLimX1
extends
    Parseable[UnderexcLimX1]
{
    override val fields: Array[String] = Array[String] (
        "k",
        "kf2",
        "km",
        "melmax",
        "tf2",
        "tm"
    )
    val k: Fielder = parse_element (element (cls, fields(0)))
    val kf2: Fielder = parse_element (element (cls, fields(1)))
    val km: Fielder = parse_element (element (cls, fields(2)))
    val melmax: Fielder = parse_element (element (cls, fields(3)))
    val tf2: Fielder = parse_element (element (cls, fields(4)))
    val tm: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): UnderexcLimX1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UnderexcLimX1 (
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (mask (k (), 0)),
            toDouble (mask (kf2 (), 1)),
            toDouble (mask (km (), 2)),
            toDouble (mask (melmax (), 3)),
            toDouble (mask (tf2 (), 4)),
            toDouble (mask (tm (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * <font color="#0f0f0f">Westinghouse minimum excitation limiter.</font>
 *
 * @param sup [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param kf2 Differential gain (Kf2).
 * @param km Minimum excitation limit gain (Km).
 * @param melmax Minimum excitation limit value (MELMAX).
 * @param qo Excitation center setting (Qo).
 * @param r Excitation radius (R).
 * @param tf2 Differential time constant (Tf2) (&gt;0).
 * @param tm Minimum excitation limit time constant (Tm).
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcLimX2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnderexcLimX2.fields (position), value)
        emitelem (0, kf2)
        emitelem (1, km)
        emitelem (2, melmax)
        emitelem (3, qo)
        emitelem (4, r)
        emitelem (5, tf2)
        emitelem (6, tm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcLimX2 rdf:ID=\"%s\">\n%s\t</cim:UnderexcLimX2>".format (id, export_fields)
    }
}

object UnderexcLimX2
extends
    Parseable[UnderexcLimX2]
{
    override val fields: Array[String] = Array[String] (
        "kf2",
        "km",
        "melmax",
        "qo",
        "r",
        "tf2",
        "tm"
    )
    val kf2: Fielder = parse_element (element (cls, fields(0)))
    val km: Fielder = parse_element (element (cls, fields(1)))
    val melmax: Fielder = parse_element (element (cls, fields(2)))
    val qo: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val tf2: Fielder = parse_element (element (cls, fields(5)))
    val tm: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): UnderexcLimX2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UnderexcLimX2 (
            UnderexcitationLimiterDynamics.parse (context),
            toDouble (mask (kf2 (), 0)),
            toDouble (mask (km (), 1)),
            toDouble (mask (melmax (), 2)),
            toDouble (mask (qo (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (tf2 (), 5)),
            toDouble (mask (tm (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Underexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this underexcitation limiter model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this underexcitation limiter model.
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnderexcitationLimiterDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnderexcitationLimiterDynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        emitattr (1, RemoteInputSignal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnderexcitationLimiterDynamics rdf:ID=\"%s\">\n%s\t</cim:UnderexcitationLimiterDynamics>".format (id, export_fields)
    }
}

object UnderexcitationLimiterDynamics
extends
    Parseable[UnderexcitationLimiterDynamics]
{
    override val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): UnderexcitationLimiterDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = UnderexcitationLimiterDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
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