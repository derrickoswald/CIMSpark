package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Simplified type UEL2 underexcitation limiter.
 *
 * This model can be derived from UnderexcLimIEEE2.  The limit characteristic (look –up table) is a single straight-line, the same as UnderexcLimIEEE2 (see Figure 10.4 (p 32), IEEE 421.5-2005 Section 10.2).
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param kui Gain Under excitation limiter (<i>K</i><i><sub>UI</sub></i>).
 *        Typical value = 0,1.
 * @param p0 Segment P initial point (<i>P</i><i><sub>0</sub></i>).
 *        Typical value = 0.
 * @param p1 Segment P end point (<i>P</i><i><sub>1</sub></i>).
 *        Typical value = 1.
 * @param q0 Segment Q initial point (<i>Q</i><i><sub>0</sub></i>).
 *        Typical value = -0,31.
 * @param q1 Segment Q end point (<i>Q</i><i><sub>1</sub></i>).
 *        Typical value = -0,1.
 * @param vuimax Maximum error signal (<i>V</i><i><sub>UIMAX</sub></i>) (&gt; UnderexcLim2Simplified.vuimin).
 *        Typical value = 1.
 * @param vuimin Minimum error signal (<i>V</i><i><sub>UIMIN</sub></i>) (&lt; UnderexcLim2Simplified.vuimax).
 *        Typical value = 0.
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcLim2Simplified
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    kui: Double = 0.0,
    p0: Double = 0.0,
    p1: Double = 0.0,
    q0: Double = 0.0,
    q1: Double = 0.0,
    vuimax: Double = 0.0,
    vuimin: Double = 0.0
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    CIMParseable[UnderexcLim2Simplified]
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

    def parse (context: CIMContext): UnderexcLim2Simplified =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[UnderexcLim2Simplified] = UnderexcLim2SimplifiedSerializer
}

object UnderexcLim2SimplifiedSerializer extends CIMSerializer[UnderexcLim2Simplified]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcLim2Simplified): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kui),
            () => output.writeDouble (obj.p0),
            () => output.writeDouble (obj.p1),
            () => output.writeDouble (obj.q0),
            () => output.writeDouble (obj.q1),
            () => output.writeDouble (obj.vuimax),
            () => output.writeDouble (obj.vuimin)
        )
        UnderexcitationLimiterDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcLim2Simplified]): UnderexcLim2Simplified =
    {
        val parent = UnderexcitationLimiterDynamicsSerializer.read (kryo, input, classOf[UnderexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcLim2Simplified (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Type UEL1 model which has a circular limit boundary when plotted in terms of machine reactive power vs. real power output.
 *
 * Reference: IEEE UEL1 421.5-2005, 10.1.
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param kuc UEL centre setting (<i>K</i><i><sub>UC</sub></i>).
 *        Typical value = 1,38.
 * @param kuf UEL excitation system stabilizer gain (<i>K</i><i><sub>UF</sub></i>).
 *        Typical value = 3,3.
 * @param kui UEL integral gain (<i>K</i><i><sub>UI</sub></i>).
 *        Typical value = 0.
 * @param kul UEL proportional gain (<i>K</i><i><sub>UL</sub></i>).
 *        Typical value = 100.
 * @param kur UEL radius setting (<i>K</i><i><sub>UR</sub></i>).
 *        Typical value = 1,95.
 * @param tu1 UEL lead time constant (<i>T</i><i><sub>U1</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tu2 UEL lag time constant (<i>T</i><i><sub>U2</sub></i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tu3 UEL lead time constant (<i>T</i><i><sub>U3</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tu4 UEL lag time constant (<i>T</i><i><sub>U4</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param vucmax UEL maximum limit for operating point phasor magnitude (<i>V</i><i><sub>UCMAX</sub></i>).
 *        Typical value = 5,8.
 * @param vuimax UEL integrator output maximum limit (<i>V</i><i><sub>UIMAX</sub></i>) (&gt; UnderexcLimIEEE1.vuimin).
 * @param vuimin UEL integrator output minimum limit (<i>V</i><i><sub>UIMIN</sub></i>) (&lt; UnderexcLimIEEE1.vuimax).
 * @param vulmax UEL output maximum limit (<i>V</i><i><sub>ULMAX</sub></i>) (&gt; UnderexcLimIEEE1.vulmin).
 *        Typical value = 18.
 * @param vulmin UEL output minimum limit (<i>V</i><i><sub>ULMIN</sub></i>) (&lt; UnderexcLimIEEE1.vulmax).
 *        Typical value = -18.
 * @param vurmax UEL maximum limit for radius phasor magnitude (<i>V</i><i><sub>URMAX</sub></i>).
 *        Typical value = 5,8.
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcLimIEEE1
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    kuc: Double = 0.0,
    kuf: Double = 0.0,
    kui: Double = 0.0,
    kul: Double = 0.0,
    kur: Double = 0.0,
    tu1: Double = 0.0,
    tu2: Double = 0.0,
    tu3: Double = 0.0,
    tu4: Double = 0.0,
    vucmax: Double = 0.0,
    vuimax: Double = 0.0,
    vuimin: Double = 0.0,
    vulmax: Double = 0.0,
    vulmin: Double = 0.0,
    vurmax: Double = 0.0
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    CIMParseable[UnderexcLimIEEE1]
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

    def parse (context: CIMContext): UnderexcLimIEEE1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[UnderexcLimIEEE1] = UnderexcLimIEEE1Serializer
}

object UnderexcLimIEEE1Serializer extends CIMSerializer[UnderexcLimIEEE1]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcLimIEEE1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kuc),
            () => output.writeDouble (obj.kuf),
            () => output.writeDouble (obj.kui),
            () => output.writeDouble (obj.kul),
            () => output.writeDouble (obj.kur),
            () => output.writeDouble (obj.tu1),
            () => output.writeDouble (obj.tu2),
            () => output.writeDouble (obj.tu3),
            () => output.writeDouble (obj.tu4),
            () => output.writeDouble (obj.vucmax),
            () => output.writeDouble (obj.vuimax),
            () => output.writeDouble (obj.vuimin),
            () => output.writeDouble (obj.vulmax),
            () => output.writeDouble (obj.vulmin),
            () => output.writeDouble (obj.vurmax)
        )
        UnderexcitationLimiterDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcLimIEEE1]): UnderexcLimIEEE1 =
    {
        val parent = UnderexcitationLimiterDynamicsSerializer.read (kryo, input, classOf[UnderexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcLimIEEE1 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Type UEL2 underexcitation limiter which has either a straight-line or multi-segment characteristic when plotted in terms of machine reactive power output vs. real power output.
 *
 * Reference: IEEE UEL2 421.5-2005, 10.2  (limit characteristic lookup table shown in Figure 10.4 (p 32)).
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param k1 UEL terminal voltage exponent applied to real power input to UEL limit look-up table (<i>k1</i>).
 *        Typical value = 2.
 * @param k2 UEL terminal voltage exponent applied to reactive power output from UEL limit look-up table (<i>k2</i>).
 *        Typical value = 2.
 * @param kfb Gain associated with optional integrator feedback input signal to UEL (<i>K</i><i><sub>FB</sub></i>).
 *        Typical value = 0.
 * @param kuf UEL excitation system stabilizer gain (<i>K</i><i><sub>UF</sub></i>).
 *        Typical value = 0.
 * @param kui UEL integral gain (<i>K</i><i><sub>UI</sub></i>).
 *        Typical value = 0,5.
 * @param kul UEL proportional gain (<i>K</i><i><sub>UL</sub></i>).
 *        Typical value = 0,8.
 * @param p0 Real power values for endpoints (<i>P</i><i><sub>0</sub></i>).
 *        Typical value = 0.
 * @param p1 Real power values for endpoints (<i>P</i><i><sub>1</sub></i>).
 *        Typical value = 0,3.
 * @param p10 Real power values for endpoints (<i>P</i><i><sub>10</sub></i>).
 * @param p2 Real power values for endpoints (<i>P</i><i><sub>2</sub></i>).
 *        Typical value = 0,6.
 * @param p3 Real power values for endpoints (<i>P</i><i><sub>3</sub></i>).
 *        Typical value = 0,9.
 * @param p4 Real power values for endpoints (<i>P</i><i><sub>4</sub></i>).
 *        Typical value = 1,02.
 * @param p5 Real power values for endpoints (<i>P</i><i><sub>5</sub></i>).
 * @param p6 Real power values for endpoints (<i>P</i><i><sub>6</sub></i>).
 * @param p7 Real power values for endpoints (<i>P</i><i><sub>7</sub></i>).
 * @param p8 Real power values for endpoints (<i>P</i><i><sub>8</sub></i>).
 * @param p9 Real power values for endpoints (<i>P</i><i><sub>9</sub></i>).
 * @param q0 Reactive power values for endpoints (<i>Q</i><i><sub>0</sub></i>).
 *        Typical value = -0,31.
 * @param q1 Reactive power values for endpoints (<i>Q</i><i><sub>1</sub></i>).
 *        Typical value = -0,31.
 * @param q10 Reactive power values for endpoints (<i>Q</i><i><sub>10</sub></i>).
 * @param q2 Reactive power values for endpoints (<i>Q</i><i><sub>2</sub></i>).
 *        Typical value = -0,28.
 * @param q3 Reactive power values for endpoints (<i>Q</i><i><sub>3</sub></i>).
 *        Typical value = -0,21.
 * @param q4 Reactive power values for endpoints (<i>Q</i><i><sub>4</sub></i>).
 *        Typical value = 0.
 * @param q5 Reactive power values for endpoints (<i>Q</i><i><sub>5</sub></i>).
 * @param q6 Reactive power values for endpoints (<i>Q</i><i><sub>6</sub></i>).
 * @param q7 Reactive power values for endpoints (<i>Q</i><i><sub>7</sub></i>).
 * @param q8 Reactive power values for endpoints (<i>Q</i><i><sub>8</sub></i>).
 * @param q9 Reactive power values for endpoints (<i>Q</i><i><sub>9</sub></i>).
 * @param tu1 UEL lead time constant (<i>T</i><i><sub>U1</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tu2 UEL lag time constant (<i>T</i><i><sub>U2</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tu3 UEL lead time constant (<i>T</i><i><sub>U3</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tu4 UEL lag time constant (<i>T</i><i><sub>U4</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tul Time constant associated with optional integrator feedback input signal to UEL (<i>T</i><i><sub>UL</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tup Real power filter time constant (<i>T</i><i><sub>UP</sub></i>) (&gt;= 0).
 *        Typical value = 5.
 * @param tuq Reactive power filter time constant (<i>T</i><i><sub>UQ</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tuv Voltage filter time constant (<i>T</i><i><sub>UV</sub></i>) (&gt;= 0).
 *        Typical value = 5.
 * @param vuimax UEL integrator output maximum limit (<i>V</i><i><sub>UIMAX</sub></i>) (&gt; UnderexcLimIEEE2.vuimin).
 *        Typical value = 0,25.
 * @param vuimin UEL integrator output minimum limit (<i>V</i><i><sub>UIMIN</sub></i>) (&lt; UnderexcLimIEEE2.vuimax).
 *        Typical value = 0.
 * @param vulmax UEL output maximum limit (<i>V</i><i><sub>ULMAX</sub></i>) (&gt; UnderexcLimIEEE2.vulmin).
 *        Typical value = 0,25.
 * @param vulmin UEL output minimum limit (<i>V</i><i><sub>ULMIN</sub></i>) (&lt; UnderexcLimIEEE2.vulmax).
 *        Typical value = 0.
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcLimIEEE2
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    k1: Double = 0.0,
    k2: Double = 0.0,
    kfb: Double = 0.0,
    kuf: Double = 0.0,
    kui: Double = 0.0,
    kul: Double = 0.0,
    p0: Double = 0.0,
    p1: Double = 0.0,
    p10: Double = 0.0,
    p2: Double = 0.0,
    p3: Double = 0.0,
    p4: Double = 0.0,
    p5: Double = 0.0,
    p6: Double = 0.0,
    p7: Double = 0.0,
    p8: Double = 0.0,
    p9: Double = 0.0,
    q0: Double = 0.0,
    q1: Double = 0.0,
    q10: Double = 0.0,
    q2: Double = 0.0,
    q3: Double = 0.0,
    q4: Double = 0.0,
    q5: Double = 0.0,
    q6: Double = 0.0,
    q7: Double = 0.0,
    q8: Double = 0.0,
    q9: Double = 0.0,
    tu1: Double = 0.0,
    tu2: Double = 0.0,
    tu3: Double = 0.0,
    tu4: Double = 0.0,
    tul: Double = 0.0,
    tup: Double = 0.0,
    tuq: Double = 0.0,
    tuv: Double = 0.0,
    vuimax: Double = 0.0,
    vuimin: Double = 0.0,
    vulmax: Double = 0.0,
    vulmin: Double = 0.0
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    CIMParseable[UnderexcLimIEEE2]
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

    def parse (context: CIMContext): UnderexcLimIEEE2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
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

    def serializer: Serializer[UnderexcLimIEEE2] = UnderexcLimIEEE2Serializer
}

object UnderexcLimIEEE2Serializer extends CIMSerializer[UnderexcLimIEEE2]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcLimIEEE2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.k1),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.kfb),
            () => output.writeDouble (obj.kuf),
            () => output.writeDouble (obj.kui),
            () => output.writeDouble (obj.kul),
            () => output.writeDouble (obj.p0),
            () => output.writeDouble (obj.p1),
            () => output.writeDouble (obj.p10),
            () => output.writeDouble (obj.p2),
            () => output.writeDouble (obj.p3),
            () => output.writeDouble (obj.p4),
            () => output.writeDouble (obj.p5),
            () => output.writeDouble (obj.p6),
            () => output.writeDouble (obj.p7),
            () => output.writeDouble (obj.p8),
            () => output.writeDouble (obj.p9),
            () => output.writeDouble (obj.q0),
            () => output.writeDouble (obj.q1),
            () => output.writeDouble (obj.q10),
            () => output.writeDouble (obj.q2),
            () => output.writeDouble (obj.q3),
            () => output.writeDouble (obj.q4),
            () => output.writeDouble (obj.q5),
            () => output.writeDouble (obj.q6),
            () => output.writeDouble (obj.q7),
            () => output.writeDouble (obj.q8),
            () => output.writeDouble (obj.q9),
            () => output.writeDouble (obj.tu1),
            () => output.writeDouble (obj.tu2),
            () => output.writeDouble (obj.tu3),
            () => output.writeDouble (obj.tu4),
            () => output.writeDouble (obj.tul),
            () => output.writeDouble (obj.tup),
            () => output.writeDouble (obj.tuq),
            () => output.writeDouble (obj.tuv),
            () => output.writeDouble (obj.vuimax),
            () => output.writeDouble (obj.vuimin),
            () => output.writeDouble (obj.vulmax),
            () => output.writeDouble (obj.vulmin)
        )
        UnderexcitationLimiterDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcLimIEEE2]): UnderexcLimIEEE2 =
    {
        val parent = UnderexcitationLimiterDynamicsSerializer.read (kryo, input, classOf[UnderexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcLimIEEE2 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0,
            if (isSet (17)) input.readDouble else 0.0,
            if (isSet (18)) input.readDouble else 0.0,
            if (isSet (19)) input.readDouble else 0.0,
            if (isSet (20)) input.readDouble else 0.0,
            if (isSet (21)) input.readDouble else 0.0,
            if (isSet (22)) input.readDouble else 0.0,
            if (isSet (23)) input.readDouble else 0.0,
            if (isSet (24)) input.readDouble else 0.0,
            if (isSet (25)) input.readDouble else 0.0,
            if (isSet (26)) input.readDouble else 0.0,
            if (isSet (27)) input.readDouble else 0.0,
            if (isSet (28)) input.readDouble else 0.0,
            if (isSet (29)) input.readDouble else 0.0,
            if (isSet (30)) input.readDouble else 0.0,
            if (isSet (31)) input.readDouble else 0.0,
            if (isSet (32)) input.readDouble else 0.0,
            if (isSet (33)) input.readDouble else 0.0,
            if (isSet (34)) input.readDouble else 0.0,
            if (isSet (35)) input.readDouble else 0.0,
            if (isSet (36)) input.readDouble else 0.0,
            if (isSet (37)) input.readDouble else 0.0,
            if (isSet (38)) input.readDouble else 0.0,
            if (isSet (39)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <font color="#0f0f0f">Allis-Chalmers minimum excitation limiter.</font>
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param k Minimum excitation limit slope (<i>K</i>) (&gt; 0).
 * @param kf2 Differential gain (<i>K</i><i><sub>F2</sub></i>).
 * @param km Minimum excitation limit gain (<i>K</i><i><sub>M</sub></i>).
 * @param melmax Minimum excitation limit value (<i>MELMAX</i>).
 * @param tf2 Differential time constant (<i>T</i><i><sub>F2</sub></i>) (&gt;= 0).
 * @param tm Minimum excitation limit time constant (<i>T</i><i><sub>M</sub></i>) (&gt;= 0).
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcLimX1
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    k: Double = 0.0,
    kf2: Double = 0.0,
    km: Double = 0.0,
    melmax: Double = 0.0,
    tf2: Double = 0.0,
    tm: Double = 0.0
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    CIMParseable[UnderexcLimX1]
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

    def parse (context: CIMContext): UnderexcLimX1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[UnderexcLimX1] = UnderexcLimX1Serializer
}

object UnderexcLimX1Serializer extends CIMSerializer[UnderexcLimX1]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcLimX1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.k),
            () => output.writeDouble (obj.kf2),
            () => output.writeDouble (obj.km),
            () => output.writeDouble (obj.melmax),
            () => output.writeDouble (obj.tf2),
            () => output.writeDouble (obj.tm)
        )
        UnderexcitationLimiterDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcLimX1]): UnderexcLimX1 =
    {
        val parent = UnderexcitationLimiterDynamicsSerializer.read (kryo, input, classOf[UnderexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcLimX1 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <font color="#0f0f0f">Westinghouse minimum excitation limiter.</font>
 *
 * @param UnderexcitationLimiterDynamics [[ch.ninecode.model.UnderexcitationLimiterDynamics UnderexcitationLimiterDynamics]] Reference to the superclass object.
 * @param kf2 Differential gain (<i>K</i><i><sub>F2</sub></i>).
 * @param km Minimum excitation limit gain (<i>K</i><i><sub>M</sub></i>).
 * @param melmax Minimum excitation limit value (<i>MELMAX</i>).
 * @param qo Excitation centre setting (<i>Q</i><i><sub>O</sub></i>).
 * @param r Excitation radius (<i>R</i>).
 * @param tf2 Differential time constant (<i>T</i><i><sub>F2</sub></i>) (&gt;= 0).
 * @param tm Minimum excitation limit time constant (<i>T</i><i><sub>M</sub></i>) (&gt;= 0).
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcLimX2
(
    UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = null,
    kf2: Double = 0.0,
    km: Double = 0.0,
    melmax: Double = 0.0,
    qo: Double = 0.0,
    r: Double = 0.0,
    tf2: Double = 0.0,
    tm: Double = 0.0
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
    override def sup: UnderexcitationLimiterDynamics = UnderexcitationLimiterDynamics

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
    CIMParseable[UnderexcLimX2]
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

    def parse (context: CIMContext): UnderexcLimX2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[UnderexcLimX2] = UnderexcLimX2Serializer
}

object UnderexcLimX2Serializer extends CIMSerializer[UnderexcLimX2]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcLimX2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kf2),
            () => output.writeDouble (obj.km),
            () => output.writeDouble (obj.melmax),
            () => output.writeDouble (obj.qo),
            () => output.writeDouble (obj.r),
            () => output.writeDouble (obj.tf2),
            () => output.writeDouble (obj.tm)
        )
        UnderexcitationLimiterDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcLimX2]): UnderexcLimX2 =
    {
        val parent = UnderexcitationLimiterDynamicsSerializer.read (kryo, input, classOf[UnderexcitationLimiterDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcLimX2 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Underexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this underexcitation limiter model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this underexcitation limiter model.
 * @group UnderexcitationLimiterDynamics
 * @groupname UnderexcitationLimiterDynamics Package UnderexcitationLimiterDynamics
 * @groupdesc UnderexcitationLimiterDynamics Underexcitation limiters (UELs) act to boost excitation. The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 */
final case class UnderexcitationLimiterDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null,
    RemoteInputSignal: String = null
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
    CIMParseable[UnderexcitationLimiterDynamics]
{
    override val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        CIMRelationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): UnderexcitationLimiterDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnderexcitationLimiterDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[UnderexcitationLimiterDynamics] = UnderexcitationLimiterDynamicsSerializer
}

object UnderexcitationLimiterDynamicsSerializer extends CIMSerializer[UnderexcitationLimiterDynamics]
{
    def write (kryo: Kryo, output: Output, obj: UnderexcitationLimiterDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ExcitationSystemDynamics),
            () => output.writeString (obj.RemoteInputSignal)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnderexcitationLimiterDynamics]): UnderexcitationLimiterDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnderexcitationLimiterDynamics (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _UnderexcitationLimiterDynamics
{
    def register: List[CIMClassInfo] =
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