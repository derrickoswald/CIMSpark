package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Power system stabilizer function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup                      [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this power system stabilizer model is associated.
 * @param RemoteInputSignal        [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this power system stabilizer model.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
 */
case class PowerSystemStabilizerDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String,
    RemoteInputSignal: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf [DynamicsFunctionBlock]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PowerSystemStabilizerDynamics]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerSystemStabilizerDynamics.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemStabilizerDynamics.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (PowerSystemStabilizerDynamics.fields (position), x))

        emitattr (0, ExcitationSystemDynamics)
        emitattrs (1, RemoteInputSignal)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PowerSystemStabilizerDynamics rdf:ID=\"%s\">\n%s\t</cim:PowerSystemStabilizerDynamics>".format (id, export_fields)
    }
}

object PowerSystemStabilizerDynamics
    extends
        Parseable[PowerSystemStabilizerDynamics]
{
    override val fields: Array[String] = Array [String](
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..*", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RemoteInputSignal: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): PowerSystemStabilizerDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PowerSystemStabilizerDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            masks (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian PSS - three input PSS (speed, frequency, power).
 *
 * @param sup   [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param kf    Frequency power input gain (K<sub>F</sub>).
 *              Typical Value = 5.
 * @param kpe   Electric power input gain (K<sub>PE</sub>).
 *              Typical Value = 0.3.
 * @param ks    PSS gain (K<sub>S</sub>).
 *              Typical Value = 1.
 * @param kw    Shaft speed power input gain (K<sub>W</sub>).
 *              Typical Value = 0.
 * @param pmin  Minimum power PSS enabling (P<sub>MIN</sub>).
 *              Typical Value = 0.25.
 * @param t10   Lead/lag time constant (T<sub>10</sub>).
 *              Typical Value = 0.
 * @param t5    Washout (T<sub>5</sub>).
 *              Typical Value = 3.5.
 * @param t6    Filter time constant (T<sub>6</sub>).
 *              Typical Value = 0.
 * @param t7    Lead/lag time constant (T<sub>7</sub>).
 *              Typical Value = 0.
 * @param t8    Lead/lag time constant (T<sub>8</sub>).
 *              Typical Value = 0.
 * @param t9    Lead/lag time constant (T<sub>9</sub>).
 *              Typical Value = 0.
 * @param tpe   Electric power filter time constant (T<sub>PE</sub>).
 *              Typical Value = 0.05.
 * @param vadat <font color="#0f0f0f">Signal selector (V<sub>adAt</sub>).</font>
 *              <font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
 *              <font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
 *              <font color="#0f0f0f">Typical Value = true.</font>
 * @param vsmn  Stabilizer output max limit (V<sub>SMN</sub>).
 *              Typical Value = -0.06.
 * @param vsmx  Stabilizer output min limit (V<sub>SMX</sub>).
 *              Typical Value = 0.06.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Pss1]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss1.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss1.fields (position), value)

        emitelem (0, kf)
        emitelem (1, kpe)
        emitelem (2, ks)
        emitelem (3, kw)
        emitelem (4, pmin)
        emitelem (5, t10)
        emitelem (6, t5)
        emitelem (7, t6)
        emitelem (8, t7)
        emitelem (9, t8)
        emitelem (10, t9)
        emitelem (11, tpe)
        emitelem (12, vadat)
        emitelem (13, vsmn)
        emitelem (14, vsmx)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss1 rdf:ID=\"%s\">\n%s\t</cim:Pss1>".format (id, export_fields)
    }
}

object Pss1
    extends
        Parseable[Pss1]
{
    override val fields: Array[String] = Array [String](
        "kf",
        "kpe",
        "ks",
        "kw",
        "pmin",
        "t10",
        "t5",
        "t6",
        "t7",
        "t8",
        "t9",
        "tpe",
        "vadat",
        "vsmn",
        "vsmx"
    )
    val kf: Fielder = parse_element (element (cls, fields (0)))
    val kpe: Fielder = parse_element (element (cls, fields (1)))
    val ks: Fielder = parse_element (element (cls, fields (2)))
    val kw: Fielder = parse_element (element (cls, fields (3)))
    val pmin: Fielder = parse_element (element (cls, fields (4)))
    val t10: Fielder = parse_element (element (cls, fields (5)))
    val t5: Fielder = parse_element (element (cls, fields (6)))
    val t6: Fielder = parse_element (element (cls, fields (7)))
    val t7: Fielder = parse_element (element (cls, fields (8)))
    val t8: Fielder = parse_element (element (cls, fields (9)))
    val t9: Fielder = parse_element (element (cls, fields (10)))
    val tpe: Fielder = parse_element (element (cls, fields (11)))
    val vadat: Fielder = parse_element (element (cls, fields (12)))
    val vsmn: Fielder = parse_element (element (cls, fields (13)))
    val vsmx: Fielder = parse_element (element (cls, fields (14)))

    def parse (context: Context): Pss1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pss1 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (kf (), 0)),
            toDouble (mask (kpe (), 1)),
            toDouble (mask (ks (), 2)),
            toDouble (mask (kw (), 3)),
            toDouble (mask (pmin (), 4)),
            toDouble (mask (t10 (), 5)),
            toDouble (mask (t5 (), 6)),
            toDouble (mask (t6 (), 7)),
            toDouble (mask (t7 (), 8)),
            toDouble (mask (t8 (), 9)),
            toDouble (mask (t9 (), 10)),
            toDouble (mask (tpe (), 11)),
            toBoolean (mask (vadat (), 12)),
            toDouble (mask (vsmn (), 13)),
            toDouble (mask (vsmx (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Single input power system stabilizer.
 *
 * It is a modified version in order to allow representation of various vendors' implementations on PSS type 1A.
 *
 * @param sup             [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1              Notch filter parameter (A1).
 * @param a2              Notch filter parameter (A2).
 * @param a3              Notch filter parameter (A3).
 * @param a4              Notch filter parameter (A4).
 * @param a5              Notch filter parameter (A5).
 * @param a6              Notch filter parameter (A6).
 * @param a7              Notch filter parameter (A7).
 * @param a8              Notch filter parameter (A8).
 * @param inputSignalType Type of input signal.
 * @param kd              Selector (Kd).
 *                        true = e<sup>-sTdelay</sup> used
 *                        false = e<sup>-sTdelay</sup> not used.
 * @param ks              Stabilizer gain (Ks).
 * @param t1              Lead/lag time constant (T1).
 * @param t2              Lead/lag time constant (T2).
 * @param t3              Lead/lag time constant (T3).
 * @param t4              Lead/lag time constant (T4).
 * @param t5              Washout time constant (T5).
 * @param t6              Transducer time constant (T6).
 * @param tdelay          Time constant (Tdelay).
 * @param vcl             Stabilizer input cutoff threshold (Vcl).
 * @param vcu             Stabilizer input cutoff threshold (Vcu).
 * @param vrmax           Maximum stabilizer output (Vrmax).
 * @param vrmin           Minimum stabilizer output (Vrmin).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Pss1A]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss1A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss1A.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pss1A.fields (position), value)

        emitelem (0, a1)
        emitelem (1, a2)
        emitelem (2, a3)
        emitelem (3, a4)
        emitelem (4, a5)
        emitelem (5, a6)
        emitelem (6, a7)
        emitelem (7, a8)
        emitattr (8, inputSignalType)
        emitelem (9, kd)
        emitelem (10, ks)
        emitelem (11, t1)
        emitelem (12, t2)
        emitelem (13, t3)
        emitelem (14, t4)
        emitelem (15, t5)
        emitelem (16, t6)
        emitelem (17, tdelay)
        emitelem (18, vcl)
        emitelem (19, vcu)
        emitelem (20, vrmax)
        emitelem (21, vrmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss1A rdf:ID=\"%s\">\n%s\t</cim:Pss1A>".format (id, export_fields)
    }
}

object Pss1A
    extends
        Parseable[Pss1A]
{
    override val fields: Array[String] = Array [String](
        "a1",
        "a2",
        "a3",
        "a4",
        "a5",
        "a6",
        "a7",
        "a8",
        "inputSignalType",
        "kd",
        "ks",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "tdelay",
        "vcl",
        "vcu",
        "vrmax",
        "vrmin"
    )
    val a1: Fielder = parse_element (element (cls, fields (0)))
    val a2: Fielder = parse_element (element (cls, fields (1)))
    val a3: Fielder = parse_element (element (cls, fields (2)))
    val a4: Fielder = parse_element (element (cls, fields (3)))
    val a5: Fielder = parse_element (element (cls, fields (4)))
    val a6: Fielder = parse_element (element (cls, fields (5)))
    val a7: Fielder = parse_element (element (cls, fields (6)))
    val a8: Fielder = parse_element (element (cls, fields (7)))
    val inputSignalType: Fielder = parse_attribute (attribute (cls, fields (8)))
    val kd: Fielder = parse_element (element (cls, fields (9)))
    val ks: Fielder = parse_element (element (cls, fields (10)))
    val t1: Fielder = parse_element (element (cls, fields (11)))
    val t2: Fielder = parse_element (element (cls, fields (12)))
    val t3: Fielder = parse_element (element (cls, fields (13)))
    val t4: Fielder = parse_element (element (cls, fields (14)))
    val t5: Fielder = parse_element (element (cls, fields (15)))
    val t6: Fielder = parse_element (element (cls, fields (16)))
    val tdelay: Fielder = parse_element (element (cls, fields (17)))
    val vcl: Fielder = parse_element (element (cls, fields (18)))
    val vcu: Fielder = parse_element (element (cls, fields (19)))
    val vrmax: Fielder = parse_element (element (cls, fields (20)))
    val vrmin: Fielder = parse_element (element (cls, fields (21)))

    def parse (context: Context): Pss1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pss1A (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a1 (), 0)),
            toDouble (mask (a2 (), 1)),
            toDouble (mask (a3 (), 2)),
            toDouble (mask (a4 (), 3)),
            toDouble (mask (a5 (), 4)),
            toDouble (mask (a6 (), 5)),
            toDouble (mask (a7 (), 6)),
            toDouble (mask (a8 (), 7)),
            mask (inputSignalType (), 8),
            toBoolean (mask (kd (), 9)),
            toDouble (mask (ks (), 10)),
            toDouble (mask (t1 (), 11)),
            toDouble (mask (t2 (), 12)),
            toDouble (mask (t3 (), 13)),
            toDouble (mask (t4 (), 14)),
            toDouble (mask (t5 (), 15)),
            toDouble (mask (t6 (), 16)),
            toDouble (mask (tdelay (), 17)),
            toDouble (mask (vcl (), 18)),
            toDouble (mask (vcu (), 19)),
            toDouble (mask (vrmax (), 20)),
            toDouble (mask (vrmin (), 21))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE PSS2B Model.
 *
 * Extra lead/lag (or rate) block added at end (up to 4 lead/lags total).
 *
 * @param sup              [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a                Numerator constant (a).
 *                         Typical Value = 1.
 * @param inputSignal1Type Type of input signal #1.
 *                         Typical Value = rotorSpeed.
 * @param inputSignal2Type Type of input signal #2.
 *                         Typical Value = generatorElectricalPower.
 * @param ks1              Stabilizer gain (Ks1).
 *                         Typical Value = 12.
 * @param ks2              Gain on signal #2 (Ks2).
 *                         Typical Value = 0.2.
 * @param ks3              Gain on signal #2 input before ramp-tracking filter (Ks3).
 *                         Typical Value = 1.
 * @param ks4              Gain on signal #2 input after ramp-tracking filter (Ks4).
 *                         Typical Value = 1.
 * @param m                Denominator order of ramp tracking filter (M).
 *                         Typical Value = 5.
 * @param n                Order of ramp tracking filter (N).
 *                         Typical Value = 1.
 * @param t1               Lead/lag time constant (T1).
 *                         Typical Value = 0.12.
 * @param t10              Lead/lag time constant (T10).
 *                         Typical Value = 0.
 * @param t11              Lead/lag time constant (T11).
 *                         Typical Value = 0.
 * @param t2               Lead/lag time constant (T2).
 *                         Typical Value = 0.02.
 * @param t3               Lead/lag time constant (T3).
 *                         Typical Value = 0.3.
 * @param t4               Lead/lag time constant (T4).
 *                         Typical Value = 0.02.
 * @param t6               Time constant on signal #1 (T6).
 *                         Typical Value = 0.
 * @param t7               Time constant on signal #2 (T7).
 *                         Typical Value = 2.
 * @param t8               Lead of ramp tracking filter (T8).
 *                         Typical Value = 0.2.
 * @param t9               Lag of ramp tracking filter (T9).
 *                         Typical Value = 0.1.
 * @param ta               Lead constant (Ta).
 *                         Typical Value = 0.
 * @param tb               Lag time constant (Tb).
 *                         Typical Value = 0.
 * @param tw1              First washout on signal #1 (Tw1).
 *                         Typical Value = 2.
 * @param tw2              Second washout on signal #1 (Tw2).
 *                         Typical Value = 2.
 * @param tw3              First washout on signal #2 (Tw3).
 *                         Typical Value = 2.
 * @param tw4              Second washout on signal #2 (Tw4).
 *                         Typical Value = 0.
 * @param vsi1max          Input signal #1 max limit (Vsi1max).
 *                         Typical Value = 2.
 * @param vsi1min          Input signal #1 min limit (Vsi1min).
 *                         Typical Value = -2.
 * @param vsi2max          Input signal #2 max limit (Vsi2max).
 *                         Typical Value = 2.
 * @param vsi2min          Input signal #2 min limit (Vsi2min).
 *                         Typical Value = -2.
 * @param vstmax           Stabilizer output max limit (Vstmax).
 *                         Typical Value = 0.1.
 * @param vstmin           Stabilizer output min limit (Vstmin).
 *                         Typical Value = -0.1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Pss2B]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss2B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss2B.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pss2B.fields (position), value)

        emitelem (0, a)
        emitattr (1, inputSignal1Type)
        emitattr (2, inputSignal2Type)
        emitelem (3, ks1)
        emitelem (4, ks2)
        emitelem (5, ks3)
        emitelem (6, ks4)
        emitelem (7, m)
        emitelem (8, n)
        emitelem (9, t1)
        emitelem (10, t10)
        emitelem (11, t11)
        emitelem (12, t2)
        emitelem (13, t3)
        emitelem (14, t4)
        emitelem (15, t6)
        emitelem (16, t7)
        emitelem (17, t8)
        emitelem (18, t9)
        emitelem (19, ta)
        emitelem (20, tb)
        emitelem (21, tw1)
        emitelem (22, tw2)
        emitelem (23, tw3)
        emitelem (24, tw4)
        emitelem (25, vsi1max)
        emitelem (26, vsi1min)
        emitelem (27, vsi2max)
        emitelem (28, vsi2min)
        emitelem (29, vstmax)
        emitelem (30, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss2B rdf:ID=\"%s\">\n%s\t</cim:Pss2B>".format (id, export_fields)
    }
}

object Pss2B
    extends
        Parseable[Pss2B]
{
    override val fields: Array[String] = Array [String](
        "a",
        "inputSignal1Type",
        "inputSignal2Type",
        "ks1",
        "ks2",
        "ks3",
        "ks4",
        "m",
        "n",
        "t1",
        "t10",
        "t11",
        "t2",
        "t3",
        "t4",
        "t6",
        "t7",
        "t8",
        "t9",
        "ta",
        "tb",
        "tw1",
        "tw2",
        "tw3",
        "tw4",
        "vsi1max",
        "vsi1min",
        "vsi2max",
        "vsi2min",
        "vstmax",
        "vstmin"
    )
    val a: Fielder = parse_element (element (cls, fields (0)))
    val inputSignal1Type: Fielder = parse_attribute (attribute (cls, fields (1)))
    val inputSignal2Type: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ks1: Fielder = parse_element (element (cls, fields (3)))
    val ks2: Fielder = parse_element (element (cls, fields (4)))
    val ks3: Fielder = parse_element (element (cls, fields (5)))
    val ks4: Fielder = parse_element (element (cls, fields (6)))
    val m: Fielder = parse_element (element (cls, fields (7)))
    val n: Fielder = parse_element (element (cls, fields (8)))
    val t1: Fielder = parse_element (element (cls, fields (9)))
    val t10: Fielder = parse_element (element (cls, fields (10)))
    val t11: Fielder = parse_element (element (cls, fields (11)))
    val t2: Fielder = parse_element (element (cls, fields (12)))
    val t3: Fielder = parse_element (element (cls, fields (13)))
    val t4: Fielder = parse_element (element (cls, fields (14)))
    val t6: Fielder = parse_element (element (cls, fields (15)))
    val t7: Fielder = parse_element (element (cls, fields (16)))
    val t8: Fielder = parse_element (element (cls, fields (17)))
    val t9: Fielder = parse_element (element (cls, fields (18)))
    val ta: Fielder = parse_element (element (cls, fields (19)))
    val tb: Fielder = parse_element (element (cls, fields (20)))
    val tw1: Fielder = parse_element (element (cls, fields (21)))
    val tw2: Fielder = parse_element (element (cls, fields (22)))
    val tw3: Fielder = parse_element (element (cls, fields (23)))
    val tw4: Fielder = parse_element (element (cls, fields (24)))
    val vsi1max: Fielder = parse_element (element (cls, fields (25)))
    val vsi1min: Fielder = parse_element (element (cls, fields (26)))
    val vsi2max: Fielder = parse_element (element (cls, fields (27)))
    val vsi2min: Fielder = parse_element (element (cls, fields (28)))
    val vstmax: Fielder = parse_element (element (cls, fields (29)))
    val vstmin: Fielder = parse_element (element (cls, fields (30)))

    def parse (context: Context): Pss2B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pss2B (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a (), 0)),
            mask (inputSignal1Type (), 1),
            mask (inputSignal2Type (), 2),
            toDouble (mask (ks1 (), 3)),
            toDouble (mask (ks2 (), 4)),
            toDouble (mask (ks3 (), 5)),
            toDouble (mask (ks4 (), 6)),
            toInteger (mask (m (), 7)),
            toInteger (mask (n (), 8)),
            toDouble (mask (t1 (), 9)),
            toDouble (mask (t10 (), 10)),
            toDouble (mask (t11 (), 11)),
            toDouble (mask (t2 (), 12)),
            toDouble (mask (t3 (), 13)),
            toDouble (mask (t4 (), 14)),
            toDouble (mask (t6 (), 15)),
            toDouble (mask (t7 (), 16)),
            toDouble (mask (t8 (), 17)),
            toDouble (mask (t9 (), 18)),
            toDouble (mask (ta (), 19)),
            toDouble (mask (tb (), 20)),
            toDouble (mask (tw1 (), 21)),
            toDouble (mask (tw2 (), 22)),
            toDouble (mask (tw3 (), 23)),
            toDouble (mask (tw4 (), 24)),
            toDouble (mask (vsi1max (), 25)),
            toDouble (mask (vsi1min (), 26)),
            toDouble (mask (vsi2max (), 27)),
            toDouble (mask (vsi2min (), 28)),
            toDouble (mask (vstmax (), 29)),
            toDouble (mask (vstmin (), 30))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 1.
 *
 * @param sup              [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 *                         Typical Value = rotorAngularFrequencyDeviation.
 * @param inputSignal2Type Type of input signal #2.
 *                         Typical Value = generatorElectricalPower.
 * @param k1               Gain (K1).
 * @param k2               Gain (K2).
 * @param lsmax            Limiter (Lsmax).
 * @param lsmin            Limiter (Lsmin).
 * @param t1               Time constant (T1).
 * @param t10              Time constant (T10).
 * @param t2               Time constant (T2).
 * @param t3               Time constant (T3).
 * @param t4               Time constant (T4).
 * @param t5               Time constant (T5).
 * @param t6               Time constant (T6).
 * @param t7               Time constant (T7).
 * @param t8               Time constant (T8).
 * @param t9               Time constant (T9).
 * @param vcl              Cutoff limiter (Vcl).
 * @param vcu              Cutoff limiter (Vcu).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Pss2ST]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss2ST.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss2ST.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Pss2ST.fields (position), value)

        emitattr (0, inputSignal1Type)
        emitattr (1, inputSignal2Type)
        emitelem (2, k1)
        emitelem (3, k2)
        emitelem (4, lsmax)
        emitelem (5, lsmin)
        emitelem (6, t1)
        emitelem (7, t10)
        emitelem (8, t2)
        emitelem (9, t3)
        emitelem (10, t4)
        emitelem (11, t5)
        emitelem (12, t6)
        emitelem (13, t7)
        emitelem (14, t8)
        emitelem (15, t9)
        emitelem (16, vcl)
        emitelem (17, vcu)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss2ST rdf:ID=\"%s\">\n%s\t</cim:Pss2ST>".format (id, export_fields)
    }
}

object Pss2ST
    extends
        Parseable[Pss2ST]
{
    override val fields: Array[String] = Array [String](
        "inputSignal1Type",
        "inputSignal2Type",
        "k1",
        "k2",
        "lsmax",
        "lsmin",
        "t1",
        "t10",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "t7",
        "t8",
        "t9",
        "vcl",
        "vcu"
    )
    val inputSignal1Type: Fielder = parse_attribute (attribute (cls, fields (0)))
    val inputSignal2Type: Fielder = parse_attribute (attribute (cls, fields (1)))
    val k1: Fielder = parse_element (element (cls, fields (2)))
    val k2: Fielder = parse_element (element (cls, fields (3)))
    val lsmax: Fielder = parse_element (element (cls, fields (4)))
    val lsmin: Fielder = parse_element (element (cls, fields (5)))
    val t1: Fielder = parse_element (element (cls, fields (6)))
    val t10: Fielder = parse_element (element (cls, fields (7)))
    val t2: Fielder = parse_element (element (cls, fields (8)))
    val t3: Fielder = parse_element (element (cls, fields (9)))
    val t4: Fielder = parse_element (element (cls, fields (10)))
    val t5: Fielder = parse_element (element (cls, fields (11)))
    val t6: Fielder = parse_element (element (cls, fields (12)))
    val t7: Fielder = parse_element (element (cls, fields (13)))
    val t8: Fielder = parse_element (element (cls, fields (14)))
    val t9: Fielder = parse_element (element (cls, fields (15)))
    val vcl: Fielder = parse_element (element (cls, fields (16)))
    val vcu: Fielder = parse_element (element (cls, fields (17)))

    def parse (context: Context): Pss2ST =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pss2ST (
            PowerSystemStabilizerDynamics.parse (context),
            mask (inputSignal1Type (), 0),
            mask (inputSignal2Type (), 1),
            toDouble (mask (k1 (), 2)),
            toDouble (mask (k2 (), 3)),
            toDouble (mask (lsmax (), 4)),
            toDouble (mask (lsmin (), 5)),
            toDouble (mask (t1 (), 6)),
            toDouble (mask (t10 (), 7)),
            toDouble (mask (t2 (), 8)),
            toDouble (mask (t3 (), 9)),
            toDouble (mask (t4 (), 10)),
            toDouble (mask (t5 (), 11)),
            toDouble (mask (t6 (), 12)),
            toDouble (mask (t7 (), 13)),
            toDouble (mask (t8 (), 14)),
            toDouble (mask (t9 (), 15)),
            toDouble (mask (vcl (), 16)),
            toDouble (mask (vcu (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Italian PSS - Detailed PSS.
 *
 * @param sup      [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param ctw2     Selector for Second washout enabling (C<sub>TW2</sub>).
 *                 true = second washout filter is bypassed
 *                 false = second washout filter in use.
 *                 Typical Value = true.
 * @param deadband Stabilizer output dead band (DeadBand).
 *                 Typical Value = 0.
 * @param isfreq   Selector for Frequency/shaft speed input (IsFreq).
 *                 true = speed
 *                 false = frequency.
 *                 Typical Value = true.
 * @param kf       Frequency/shaft speed input gain (K<sub>F</sub>).
 *                 Typical Value = 5.
 * @param kpe      Electric power input gain (K<sub>PE</sub>).
 *                 Typical Value = 0.3.
 * @param kpss     PSS gain (K<sub>PSS</sub>).
 *                 Typical Value = 1.
 * @param pmm      Minimum power PSS enabling (P<sub>mn</sub>).
 *                 Typical Value = 0.25.
 * @param tl1      Lead/lag time constant (T<sub>L1</sub>).
 *                 Typical Value = 0.
 * @param tl2      Lead/lag time constant (T<sub>L2</sub>).
 *                 Typical Value = 0.
 * @param tl3      Lead/lag time constant (T<sub>L3</sub>).
 *                 Typical Value = 0.
 * @param tl4      Lead/lag time constant (T<sub>L4</sub>).
 *                 Typical Value = 0.
 * @param tpe      Electric power filter time constant (T<sub>PE</sub>).
 *                 Typical Value = 0.05.
 * @param tw1      First WashOut (T<sub>w1</sub>).
 *                 Typical Value = 3.5.
 * @param tw2      Second WashOut (T<sub>w2</sub>).
 *                 Typical Value = 0.
 * @param vadat    <font color="#0f0f0f">Signal selector (V<sub>adAtt</sub>).</font>
 *                 <font color="#0f0f0f">true = closed (Generator Power is greater than Pmin)</font>
 *                 <font color="#0f0f0f">false = open (Pe is smaller than Pmin).</font>
 *                 <font color="#0f0f0f">Typical Value = true.</font>
 * @param vsmn     Stabilizer output max limit (V<sub>SMN</sub>).
 *                 Typical Value = -0.1.
 * @param vsmx     Stabilizer output min limit (V<sub>SMX</sub>).
 *                 Typical Value = 0.1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, false, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Pss5]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss5.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss5.fields (position), value)

        emitelem (0, ctw2)
        emitelem (1, deadband)
        emitelem (2, isfreq)
        emitelem (3, kf)
        emitelem (4, kpe)
        emitelem (5, kpss)
        emitelem (6, pmm)
        emitelem (7, tl1)
        emitelem (8, tl2)
        emitelem (9, tl3)
        emitelem (10, tl4)
        emitelem (11, tpe)
        emitelem (12, tw1)
        emitelem (13, tw2)
        emitelem (14, vadat)
        emitelem (15, vsmn)
        emitelem (16, vsmx)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss5 rdf:ID=\"%s\">\n%s\t</cim:Pss5>".format (id, export_fields)
    }
}

object Pss5
    extends
        Parseable[Pss5]
{
    override val fields: Array[String] = Array [String](
        "ctw2",
        "deadband",
        "isfreq",
        "kf",
        "kpe",
        "kpss",
        "pmm",
        "tl1",
        "tl2",
        "tl3",
        "tl4",
        "tpe",
        "tw1",
        "tw2",
        "vadat",
        "vsmn",
        "vsmx"
    )
    val ctw2: Fielder = parse_element (element (cls, fields (0)))
    val deadband: Fielder = parse_element (element (cls, fields (1)))
    val isfreq: Fielder = parse_element (element (cls, fields (2)))
    val kf: Fielder = parse_element (element (cls, fields (3)))
    val kpe: Fielder = parse_element (element (cls, fields (4)))
    val kpss: Fielder = parse_element (element (cls, fields (5)))
    val pmm: Fielder = parse_element (element (cls, fields (6)))
    val tl1: Fielder = parse_element (element (cls, fields (7)))
    val tl2: Fielder = parse_element (element (cls, fields (8)))
    val tl3: Fielder = parse_element (element (cls, fields (9)))
    val tl4: Fielder = parse_element (element (cls, fields (10)))
    val tpe: Fielder = parse_element (element (cls, fields (11)))
    val tw1: Fielder = parse_element (element (cls, fields (12)))
    val tw2: Fielder = parse_element (element (cls, fields (13)))
    val vadat: Fielder = parse_element (element (cls, fields (14)))
    val vsmn: Fielder = parse_element (element (cls, fields (15)))
    val vsmx: Fielder = parse_element (element (cls, fields (16)))

    def parse (context: Context): Pss5 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Pss5 (
            PowerSystemStabilizerDynamics.parse (context),
            toBoolean (mask (ctw2 (), 0)),
            toDouble (mask (deadband (), 1)),
            toBoolean (mask (isfreq (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (kpe (), 4)),
            toDouble (mask (kpss (), 5)),
            toDouble (mask (pmm (), 6)),
            toDouble (mask (tl1 (), 7)),
            toDouble (mask (tl2 (), 8)),
            toDouble (mask (tl3 (), 9)),
            toDouble (mask (tl4 (), 10)),
            toDouble (mask (tpe (), 11)),
            toDouble (mask (tw1 (), 12)),
            toDouble (mask (tw2 (), 13)),
            toBoolean (mask (vadat (), 14)),
            toDouble (mask (vsmn (), 15)),
            toDouble (mask (vsmx (), 16))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Power system stabilizer typically associated with ExcELIN2 (though PssIEEE2B or Pss2B can also be used).
 *
 * @param sup    [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param apss   Coefficient (a_PSS).
 *               Typical Value = 0.1.
 * @param ks1    Gain (Ks1).
 *               Typical Value = 1.
 * @param ks2    Gain (Ks2).
 *               Typical Value = 0.1.
 * @param ppss   Coefficient (p_PSS) (&gt;=0 and &lt;=4).
 *               Typical Value = 0.1.
 * @param psslim PSS limiter (psslim).
 *               Typical Value = 0.1.
 * @param ts1    Time constant (Ts1).
 *               Typical Value = 0.
 * @param ts2    Time constant (Ts2).
 *               Typical Value = 1.
 * @param ts3    Time constant (Ts3).
 *               Typical Value = 1.
 * @param ts4    Time constant (Ts4).
 *               Typical Value = 0.1.
 * @param ts5    Time constant (Ts5).
 *               Typical Value = 0.
 * @param ts6    Time constant (Ts6).
 *               Typical Value = 1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssELIN2]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssELIN2.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssELIN2.fields (position), value)

        emitelem (0, apss)
        emitelem (1, ks1)
        emitelem (2, ks2)
        emitelem (3, ppss)
        emitelem (4, psslim)
        emitelem (5, ts1)
        emitelem (6, ts2)
        emitelem (7, ts3)
        emitelem (8, ts4)
        emitelem (9, ts5)
        emitelem (10, ts6)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssELIN2 rdf:ID=\"%s\">\n%s\t</cim:PssELIN2>".format (id, export_fields)
    }
}

object PssELIN2
    extends
        Parseable[PssELIN2]
{
    override val fields: Array[String] = Array [String](
        "apss",
        "ks1",
        "ks2",
        "ppss",
        "psslim",
        "ts1",
        "ts2",
        "ts3",
        "ts4",
        "ts5",
        "ts6"
    )
    val apss: Fielder = parse_element (element (cls, fields (0)))
    val ks1: Fielder = parse_element (element (cls, fields (1)))
    val ks2: Fielder = parse_element (element (cls, fields (2)))
    val ppss: Fielder = parse_element (element (cls, fields (3)))
    val psslim: Fielder = parse_element (element (cls, fields (4)))
    val ts1: Fielder = parse_element (element (cls, fields (5)))
    val ts2: Fielder = parse_element (element (cls, fields (6)))
    val ts3: Fielder = parse_element (element (cls, fields (7)))
    val ts4: Fielder = parse_element (element (cls, fields (8)))
    val ts5: Fielder = parse_element (element (cls, fields (9)))
    val ts6: Fielder = parse_element (element (cls, fields (10)))

    def parse (context: Context): PssELIN2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssELIN2 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (apss (), 0)),
            toDouble (mask (ks1 (), 1)),
            toDouble (mask (ks2 (), 2)),
            toDouble (mask (ppss (), 3)),
            toDouble (mask (psslim (), 4)),
            toDouble (mask (ts1 (), 5)),
            toDouble (mask (ts2 (), 6)),
            toDouble (mask (ts3 (), 7)),
            toDouble (mask (ts4 (), 8)),
            toDouble (mask (ts5 (), 9)),
            toDouble (mask (ts6 (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS1A power system stabilizer model.
 *
 * PSS1A is the generalized form of a PSS with a single input. Some common stabilizer input signals are speed, frequency, and power.
 *
 * @param sup             [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1              PSS signal conditioning frequency filter constant (A1).
 *                        Typical Value = 0.061.
 * @param a2              PSS signal conditioning frequency filter constant (A2).
 *                        Typical Value = 0.0017.
 * @param inputSignalType Type of input signal.
 *                        Typical Value = rotorAngularFrequencyDeviation.
 * @param ks              Stabilizer gain (Ks).
 *                        Typical Value = 5.
 * @param t1              Lead/lag time constant (T1).
 *                        Typical Value = 0.3.
 * @param t2              Lead/lag time constant (T2).
 *                        Typical Value = 0.03.
 * @param t3              Lead/lag time constant (T3).
 *                        Typical Value = 0.3.
 * @param t4              Lead/lag time constant (T4).
 *                        Typical Value = 0.03.
 * @param t5              Washout time constant (T5).
 *                        Typical Value = 10.
 * @param t6              Transducer time constant (T6).
 *                        Typical Value = 0.01.
 * @param vrmax           Maximum stabilizer output (Vrmax).
 *                        Typical Value = 0.05.
 * @param vrmin           Minimum stabilizer output (Vrmin).
 *                        Typical Value = -0.05.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssIEEE1A]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssIEEE1A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssIEEE1A.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PssIEEE1A.fields (position), value)

        emitelem (0, a1)
        emitelem (1, a2)
        emitattr (2, inputSignalType)
        emitelem (3, ks)
        emitelem (4, t1)
        emitelem (5, t2)
        emitelem (6, t3)
        emitelem (7, t4)
        emitelem (8, t5)
        emitelem (9, t6)
        emitelem (10, vrmax)
        emitelem (11, vrmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssIEEE1A rdf:ID=\"%s\">\n%s\t</cim:PssIEEE1A>".format (id, export_fields)
    }
}

object PssIEEE1A
    extends
        Parseable[PssIEEE1A]
{
    override val fields: Array[String] = Array [String](
        "a1",
        "a2",
        "inputSignalType",
        "ks",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "vrmax",
        "vrmin"
    )
    val a1: Fielder = parse_element (element (cls, fields (0)))
    val a2: Fielder = parse_element (element (cls, fields (1)))
    val inputSignalType: Fielder = parse_attribute (attribute (cls, fields (2)))
    val ks: Fielder = parse_element (element (cls, fields (3)))
    val t1: Fielder = parse_element (element (cls, fields (4)))
    val t2: Fielder = parse_element (element (cls, fields (5)))
    val t3: Fielder = parse_element (element (cls, fields (6)))
    val t4: Fielder = parse_element (element (cls, fields (7)))
    val t5: Fielder = parse_element (element (cls, fields (8)))
    val t6: Fielder = parse_element (element (cls, fields (9)))
    val vrmax: Fielder = parse_element (element (cls, fields (10)))
    val vrmin: Fielder = parse_element (element (cls, fields (11)))

    def parse (context: Context): PssIEEE1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssIEEE1A (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a1 (), 0)),
            toDouble (mask (a2 (), 1)),
            mask (inputSignalType (), 2),
            toDouble (mask (ks (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t2 (), 5)),
            toDouble (mask (t3 (), 6)),
            toDouble (mask (t4 (), 7)),
            toDouble (mask (t5 (), 8)),
            toDouble (mask (t6 (), 9)),
            toDouble (mask (vrmax (), 10)),
            toDouble (mask (vrmin (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS2B power system stabilizer model.
 *
 * This stabilizer model is designed to represent a variety of dual-input stabilizers, which normally use combinations of power and speed or frequency to derive the stabilizing signal.
 *
 * @param sup              [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 *                         Typical Value = rotorSpeed.
 * @param inputSignal2Type Type of input signal #2.
 *                         Typical Value = generatorElectricalPower.
 * @param ks1              Stabilizer gain (Ks1).
 *                         Typical Value = 12.
 * @param ks2              Gain on signal #2 (Ks2).
 *                         Typical Value = 0.2.
 * @param ks3              Gain on signal #2 input before ramp-tracking filter (Ks3).
 *                         Typical Value = 1.
 * @param m                Denominator order of ramp tracking filter (M).
 *                         Typical Value = 5.
 * @param n                Order of ramp tracking filter (N).
 *                         Typical Value = 1.
 * @param t1               Lead/lag time constant (T1).
 *                         Typical Value = 0.12.
 * @param t10              Lead/lag time constant (T10).
 *                         Typical Value = 0.
 * @param t11              Lead/lag time constant (T11).
 *                         Typical Value = 0.
 * @param t2               Lead/lag time constant (T2).
 *                         Typical Value = 0.02.
 * @param t3               Lead/lag time constant (T3).
 *                         Typical Value = 0.3.
 * @param t4               Lead/lag time constant (T4).
 *                         Typical Value = 0.02.
 * @param t6               Time constant on signal #1 (T6).
 *                         Typical Value = 0.
 * @param t7               Time constant on signal #2 (T7).
 *                         Typical Value = 2.
 * @param t8               Lead of ramp tracking filter (T8).
 *                         Typical Value = 0.2.
 * @param t9               Lag of ramp tracking filter (T9).
 *                         Typical Value = 0.1.
 * @param tw1              First washout on signal #1 (Tw1).
 *                         Typical Value = 2.
 * @param tw2              Second washout on signal #1 (Tw2).
 *                         Typical Value = 2.
 * @param tw3              First washout on signal #2 (Tw3).
 *                         Typical Value = 2.
 * @param tw4              Second washout on signal #2 (Tw4).
 *                         Typical Value = 0.
 * @param vsi1max          Input signal #1 max limit (Vsi1max).
 *                         Typical Value = 2.
 * @param vsi1min          Input signal #1 min limit (Vsi1min).
 *                         Typical Value = -2.
 * @param vsi2max          Input signal #2 max limit (Vsi2max).
 *                         Typical Value = 2.
 * @param vsi2min          Input signal #2 min limit (Vsi2min).
 *                         Typical Value = -2.
 * @param vstmax           Stabilizer output max limit (Vstmax).
 *                         Typical Value = 0.1.
 * @param vstmin           Stabilizer output min limit (Vstmin).
 *                         Typical Value = -0.1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, 0.0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssIEEE2B]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssIEEE2B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssIEEE2B.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PssIEEE2B.fields (position), value)

        emitattr (0, inputSignal1Type)
        emitattr (1, inputSignal2Type)
        emitelem (2, ks1)
        emitelem (3, ks2)
        emitelem (4, ks3)
        emitelem (5, m)
        emitelem (6, n)
        emitelem (7, t1)
        emitelem (8, t10)
        emitelem (9, t11)
        emitelem (10, t2)
        emitelem (11, t3)
        emitelem (12, t4)
        emitelem (13, t6)
        emitelem (14, t7)
        emitelem (15, t8)
        emitelem (16, t9)
        emitelem (17, tw1)
        emitelem (18, tw2)
        emitelem (19, tw3)
        emitelem (20, tw4)
        emitelem (21, vsi1max)
        emitelem (22, vsi1min)
        emitelem (23, vsi2max)
        emitelem (24, vsi2min)
        emitelem (25, vstmax)
        emitelem (26, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssIEEE2B rdf:ID=\"%s\">\n%s\t</cim:PssIEEE2B>".format (id, export_fields)
    }
}

object PssIEEE2B
    extends
        Parseable[PssIEEE2B]
{
    override val fields: Array[String] = Array [String](
        "inputSignal1Type",
        "inputSignal2Type",
        "ks1",
        "ks2",
        "ks3",
        "m",
        "n",
        "t1",
        "t10",
        "t11",
        "t2",
        "t3",
        "t4",
        "t6",
        "t7",
        "t8",
        "t9",
        "tw1",
        "tw2",
        "tw3",
        "tw4",
        "vsi1max",
        "vsi1min",
        "vsi2max",
        "vsi2min",
        "vstmax",
        "vstmin"
    )
    val inputSignal1Type: Fielder = parse_attribute (attribute (cls, fields (0)))
    val inputSignal2Type: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ks1: Fielder = parse_element (element (cls, fields (2)))
    val ks2: Fielder = parse_element (element (cls, fields (3)))
    val ks3: Fielder = parse_element (element (cls, fields (4)))
    val m: Fielder = parse_element (element (cls, fields (5)))
    val n: Fielder = parse_element (element (cls, fields (6)))
    val t1: Fielder = parse_element (element (cls, fields (7)))
    val t10: Fielder = parse_element (element (cls, fields (8)))
    val t11: Fielder = parse_element (element (cls, fields (9)))
    val t2: Fielder = parse_element (element (cls, fields (10)))
    val t3: Fielder = parse_element (element (cls, fields (11)))
    val t4: Fielder = parse_element (element (cls, fields (12)))
    val t6: Fielder = parse_element (element (cls, fields (13)))
    val t7: Fielder = parse_element (element (cls, fields (14)))
    val t8: Fielder = parse_element (element (cls, fields (15)))
    val t9: Fielder = parse_element (element (cls, fields (16)))
    val tw1: Fielder = parse_element (element (cls, fields (17)))
    val tw2: Fielder = parse_element (element (cls, fields (18)))
    val tw3: Fielder = parse_element (element (cls, fields (19)))
    val tw4: Fielder = parse_element (element (cls, fields (20)))
    val vsi1max: Fielder = parse_element (element (cls, fields (21)))
    val vsi1min: Fielder = parse_element (element (cls, fields (22)))
    val vsi2max: Fielder = parse_element (element (cls, fields (23)))
    val vsi2min: Fielder = parse_element (element (cls, fields (24)))
    val vstmax: Fielder = parse_element (element (cls, fields (25)))
    val vstmin: Fielder = parse_element (element (cls, fields (26)))

    def parse (context: Context): PssIEEE2B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssIEEE2B (
            PowerSystemStabilizerDynamics.parse (context),
            mask (inputSignal1Type (), 0),
            mask (inputSignal2Type (), 1),
            toDouble (mask (ks1 (), 2)),
            toDouble (mask (ks2 (), 3)),
            toDouble (mask (ks3 (), 4)),
            toInteger (mask (m (), 5)),
            toInteger (mask (n (), 6)),
            toDouble (mask (t1 (), 7)),
            toDouble (mask (t10 (), 8)),
            toDouble (mask (t11 (), 9)),
            toDouble (mask (t2 (), 10)),
            toDouble (mask (t3 (), 11)),
            toDouble (mask (t4 (), 12)),
            toDouble (mask (t6 (), 13)),
            toDouble (mask (t7 (), 14)),
            toDouble (mask (t8 (), 15)),
            toDouble (mask (t9 (), 16)),
            toDouble (mask (tw1 (), 17)),
            toDouble (mask (tw2 (), 18)),
            toDouble (mask (tw3 (), 19)),
            toDouble (mask (tw4 (), 20)),
            toDouble (mask (vsi1max (), 21)),
            toDouble (mask (vsi1min (), 22)),
            toDouble (mask (vsi2max (), 23)),
            toDouble (mask (vsi2min (), 24)),
            toDouble (mask (vstmax (), 25)),
            toDouble (mask (vstmin (), 26))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS3B power system stabilizer model.
 *
 * The PSS model PSS3B has dual inputs of electrical power and rotor angular frequency deviation. The signals are used to derive an equivalent mechanical power signal.
 *
 * @param sup              [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1               Notch filter parameter (A1).
 *                         Typical Value = 0.359.
 * @param a2               Notch filter parameter (A2).
 *                         Typical Value = 0.586.
 * @param a3               Notch filter parameter (A3).
 *                         Typical Value = 0.429.
 * @param a4               Notch filter parameter (A4).
 *                         Typical Value = 0.564.
 * @param a5               Notch filter parameter (A5).
 *                         Typical Value = 0.001.
 * @param a6               Notch filter parameter (A6).
 *                         Typical Value = 0.
 * @param a7               Notch filter parameter (A7).
 *                         Typical Value = 0.031.
 * @param a8               Notch filter parameter (A8).
 *                         Typical Value = 0.
 * @param inputSignal1Type Type of input signal #1.
 *                         Typical Value = generatorElectricalPower.
 * @param inputSignal2Type Type of input signal #2.
 *                         Typical Value = rotorSpeed.
 * @param ks1              Gain on signal # 1 (Ks1).
 *                         Typical Value = -0.602.
 * @param ks2              Gain on signal # 2 (Ks2).
 *                         Typical Value = 30.12.
 * @param t1               Transducer time constant (T1).
 *                         Typical Value = 0.012.
 * @param t2               Transducer time constant (T2).
 *                         Typical Value = 0.012.
 * @param tw1              Washout time constant (Tw1).
 *                         Typical Value = 0.3.
 * @param tw2              Washout time constant (Tw2).
 *                         Typical Value = 0.3.
 * @param tw3              Washout time constant (Tw3).
 *                         Typical Value = 0.6.
 * @param vstmax           Stabilizer output max limit (Vstmax).
 *                         Typical Value = 0.1.
 * @param vstmin           Stabilizer output min limit (Vstmin).
 *                         Typical Value = -0.1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssIEEE3B]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssIEEE3B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssIEEE3B.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PssIEEE3B.fields (position), value)

        emitelem (0, a1)
        emitelem (1, a2)
        emitelem (2, a3)
        emitelem (3, a4)
        emitelem (4, a5)
        emitelem (5, a6)
        emitelem (6, a7)
        emitelem (7, a8)
        emitattr (8, inputSignal1Type)
        emitattr (9, inputSignal2Type)
        emitelem (10, ks1)
        emitelem (11, ks2)
        emitelem (12, t1)
        emitelem (13, t2)
        emitelem (14, tw1)
        emitelem (15, tw2)
        emitelem (16, tw3)
        emitelem (17, vstmax)
        emitelem (18, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssIEEE3B rdf:ID=\"%s\">\n%s\t</cim:PssIEEE3B>".format (id, export_fields)
    }
}

object PssIEEE3B
    extends
        Parseable[PssIEEE3B]
{
    override val fields: Array[String] = Array [String](
        "a1",
        "a2",
        "a3",
        "a4",
        "a5",
        "a6",
        "a7",
        "a8",
        "inputSignal1Type",
        "inputSignal2Type",
        "ks1",
        "ks2",
        "t1",
        "t2",
        "tw1",
        "tw2",
        "tw3",
        "vstmax",
        "vstmin"
    )
    val a1: Fielder = parse_element (element (cls, fields (0)))
    val a2: Fielder = parse_element (element (cls, fields (1)))
    val a3: Fielder = parse_element (element (cls, fields (2)))
    val a4: Fielder = parse_element (element (cls, fields (3)))
    val a5: Fielder = parse_element (element (cls, fields (4)))
    val a6: Fielder = parse_element (element (cls, fields (5)))
    val a7: Fielder = parse_element (element (cls, fields (6)))
    val a8: Fielder = parse_element (element (cls, fields (7)))
    val inputSignal1Type: Fielder = parse_attribute (attribute (cls, fields (8)))
    val inputSignal2Type: Fielder = parse_attribute (attribute (cls, fields (9)))
    val ks1: Fielder = parse_element (element (cls, fields (10)))
    val ks2: Fielder = parse_element (element (cls, fields (11)))
    val t1: Fielder = parse_element (element (cls, fields (12)))
    val t2: Fielder = parse_element (element (cls, fields (13)))
    val tw1: Fielder = parse_element (element (cls, fields (14)))
    val tw2: Fielder = parse_element (element (cls, fields (15)))
    val tw3: Fielder = parse_element (element (cls, fields (16)))
    val vstmax: Fielder = parse_element (element (cls, fields (17)))
    val vstmin: Fielder = parse_element (element (cls, fields (18)))

    def parse (context: Context): PssIEEE3B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssIEEE3B (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a1 (), 0)),
            toDouble (mask (a2 (), 1)),
            toDouble (mask (a3 (), 2)),
            toDouble (mask (a4 (), 3)),
            toDouble (mask (a5 (), 4)),
            toDouble (mask (a6 (), 5)),
            toDouble (mask (a7 (), 6)),
            toDouble (mask (a8 (), 7)),
            mask (inputSignal1Type (), 8),
            mask (inputSignal2Type (), 9),
            toDouble (mask (ks1 (), 10)),
            toDouble (mask (ks2 (), 11)),
            toDouble (mask (t1 (), 12)),
            toDouble (mask (t2 (), 13)),
            toDouble (mask (tw1 (), 14)),
            toDouble (mask (tw2 (), 15)),
            toDouble (mask (tw3 (), 16)),
            toDouble (mask (vstmax (), 17)),
            toDouble (mask (vstmin (), 18))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents IEEE Std 421.5-2005 type PSS2B power system stabilizer model.
 *
 * The PSS4B model represents a structure based on multiple working frequency bands. Three separate bands, respectively dedicated to the low-, intermediate- and high-frequency modes of oscillations, are used in this delta-omega (speed input) PSS.
 *
 * @param sup      [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param bwh1     Notch filter 1 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwh2     Notch filter 2 (high-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwl1     Notch filter 1 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param bwl2     Notch filter 2 (low-frequency band): Three dB bandwidth (B<sub>wi</sub>).
 * @param kh       High band gain (K<sub>H</sub>).
 *                 Typical Value = 120.
 * @param kh1      High band differential filter gain (K<sub>H1</sub>).
 *                 Typical Value = 66.
 * @param kh11     High band first lead-lag blocks coefficient (K<sub>H11</sub>).
 *                 Typical Value = 1.
 * @param kh17     High band first lead-lag blocks coefficient (K<sub>H17</sub>).
 *                 Typical Value = 1.
 * @param kh2      High band differential filter gain (K<sub>H2</sub>).
 *                 Typical Value = 66.
 * @param ki       Intermediate band gain (K<sub>I</sub>).
 *                 Typical Value = 30.
 * @param ki1      Intermediate band differential filter gain (K<sub>I1</sub>).
 *                 Typical Value = 66.
 * @param ki11     Intermediate band first lead-lag blocks coefficient (K<sub>I11</sub>).
 *                 Typical Value = 1.
 * @param ki17     Intermediate band first lead-lag blocks coefficient (K<sub>I17</sub>).
 *                 Typical Value = 1.
 * @param ki2      Intermediate band differential filter gain (K<sub>I2</sub>).
 *                 Typical Value = 66.
 * @param kl       Low band gain (K<sub>L</sub>).
 *                 Typical Value = 7.5.
 * @param kl1      Low band differential filter gain (K<sub>L1</sub>).
 *                 Typical Value = 66.
 * @param kl11     Low band first lead-lag blocks coefficient (K<sub>L11</sub>).
 *                 Typical Value = 1.
 * @param kl17     Low band first lead-lag blocks coefficient (K<sub>L17</sub>).
 *                 Typical Value = 1.
 * @param kl2      Low band differential filter gain (K<sub>L2</sub>).
 *                 Typical Value = 66.
 * @param omeganh1 Notch filter 1 (high-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganh2 Notch filter 2 (high-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganl1 Notch filter 1 (low-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param omeganl2 Notch filter 2 (low-frequency band): filter frequency (omega<sub>ni</sub>).
 * @param th1      High band time constant (T<sub>H1</sub>).
 *                 Typical Value = 0.01513.
 * @param th10     High band time constant (T<sub>H10</sub>).
 *                 Typical Value = 0.
 * @param th11     High band time constant (T<sub>H11</sub>).
 *                 Typical Value = 0.
 * @param th12     High band time constant (T<sub>H12</sub>).
 *                 Typical Value = 0.
 * @param th2      High band time constant (T<sub>H2</sub>).
 *                 Typical Value = 0.01816.
 * @param th3      High band time constant (T<sub>H3</sub>).
 *                 Typical Value = 0.
 * @param th4      High band time constant (T<sub>H4</sub>).
 *                 Typical Value = 0.
 * @param th5      High band time constant (T<sub>H5</sub>).
 *                 Typical Value = 0.
 * @param th6      High band time constant (T<sub>H6</sub>).
 *                 Typical Value = 0.
 * @param th7      High band time constant (T<sub>H7</sub>).
 *                 Typical Value = 0.01816.
 * @param th8      High band time constant (T<sub>H8</sub>).
 *                 Typical Value = 0.02179.
 * @param th9      High band time constant (T<sub>H9</sub>).
 *                 Typical Value = 0.
 * @param ti1      Intermediate band time constant (T<sub>I1</sub>).
 *                 Typical Value = 0.173.
 * @param ti10     Intermediate band time constant (T<sub>I11</sub>).
 *                 Typical Value = 0.
 * @param ti11     Intermediate band time constant (T<sub>I11</sub>).
 *                 Typical Value = 0.
 * @param ti12     Intermediate band time constant (T<sub>I2</sub>).
 *                 Typical Value = 0.
 * @param ti2      Intermediate band time constant (T<sub>I2</sub>).
 *                 Typical Value = 0.2075.
 * @param ti3      Intermediate band time constant (T<sub>I3</sub>).
 *                 Typical Value = 0.
 * @param ti4      Intermediate band time constant (T<sub>I4</sub>).
 *                 Typical Value = 0.
 * @param ti5      Intermediate band time constant (T<sub>I5</sub>).
 *                 Typical Value = 0.
 * @param ti6      Intermediate band time constant (T<sub>I6</sub>).
 *                 Typical Value = 0.
 * @param ti7      Intermediate band time constant (T<sub>I7</sub>).
 *                 Typical Value = 0.2075.
 * @param ti8      Intermediate band time constant (T<sub>I8</sub>).
 *                 Typical Value = 0.2491.
 * @param ti9      Intermediate band time constant (T<sub>I9</sub>).
 *                 Typical Value = 0.
 * @param tl1      Low band time constant (T<sub>L1</sub>).
 *                 Typical Value = 1.73.
 * @param tl10     Low band time constant (T<sub>L10</sub>).
 *                 Typical Value = 0.
 * @param tl11     Low band time constant (T<sub>L11</sub>).
 *                 Typical Value = 0.
 * @param tl12     Low band time constant (T<sub>L12</sub>).
 *                 Typical Value = 0.
 * @param tl2      Low band time constant (T<sub>L2</sub>).
 *                 Typical Value = 2.075.
 * @param tl3      Low band time constant (T<sub>L3</sub>).
 *                 Typical Value = 0.
 * @param tl4      Low band time constant (T<sub>L4</sub>).
 *                 Typical Value = 0.
 * @param tl5      Low band time constant (T<sub>L5</sub>).
 *                 Typical Value = 0.
 * @param tl6      Low band time constant (T<sub>L6</sub>).
 *                 Typical Value = 0.
 * @param tl7      Low band time constant (T<sub>L7</sub>).
 *                 Typical Value = 2.075.
 * @param tl8      Low band time constant (T<sub>L8</sub>).
 *                 Typical Value = 2.491.
 * @param tl9      Low band time constant (T<sub>L9</sub>).
 *                 Typical Value = 0.
 * @param vhmax    High band output maximum limit (V<sub>Hmax</sub>).
 *                 Typical Value = 0.6.
 * @param vhmin    High band output minimum limit (V<sub>Hmin</sub>).
 *                 Typical Value = -0.6.
 * @param vimax    Intermediate band output maximum limit (V<sub>Imax</sub>).
 *                 Typical Value = 0.6.
 * @param vimin    Intermediate band output minimum limit (V<sub>Imin</sub>).
 *                 Typical Value = -0.6.
 * @param vlmax    Low band output maximum limit (V<sub>Lmax</sub>).
 *                 Typical Value = 0.075.
 * @param vlmin    Low band output minimum limit (V<sub>Lmin</sub>).
 *                 Typical Value = -0.075.
 * @param vstmax   PSS output maximum limit (V<sub>STmax</sub>).
 *                 Typical Value = 0.15.
 * @param vstmin   PSS output minimum limit (V<sub>STmin</sub>).
 *                 Typical Value = -0.15.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssIEEE4B]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssIEEE4B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssIEEE4B.fields (position), value)

        emitelem (0, bwh1)
        emitelem (1, bwh2)
        emitelem (2, bwl1)
        emitelem (3, bwl2)
        emitelem (4, kh)
        emitelem (5, kh1)
        emitelem (6, kh11)
        emitelem (7, kh17)
        emitelem (8, kh2)
        emitelem (9, ki)
        emitelem (10, ki1)
        emitelem (11, ki11)
        emitelem (12, ki17)
        emitelem (13, ki2)
        emitelem (14, kl)
        emitelem (15, kl1)
        emitelem (16, kl11)
        emitelem (17, kl17)
        emitelem (18, kl2)
        emitelem (19, omeganh1)
        emitelem (20, omeganh2)
        emitelem (21, omeganl1)
        emitelem (22, omeganl2)
        emitelem (23, th1)
        emitelem (24, th10)
        emitelem (25, th11)
        emitelem (26, th12)
        emitelem (27, th2)
        emitelem (28, th3)
        emitelem (29, th4)
        emitelem (30, th5)
        emitelem (31, th6)
        emitelem (32, th7)
        emitelem (33, th8)
        emitelem (34, th9)
        emitelem (35, ti1)
        emitelem (36, ti10)
        emitelem (37, ti11)
        emitelem (38, ti12)
        emitelem (39, ti2)
        emitelem (40, ti3)
        emitelem (41, ti4)
        emitelem (42, ti5)
        emitelem (43, ti6)
        emitelem (44, ti7)
        emitelem (45, ti8)
        emitelem (46, ti9)
        emitelem (47, tl1)
        emitelem (48, tl10)
        emitelem (49, tl11)
        emitelem (50, tl12)
        emitelem (51, tl2)
        emitelem (52, tl3)
        emitelem (53, tl4)
        emitelem (54, tl5)
        emitelem (55, tl6)
        emitelem (56, tl7)
        emitelem (57, tl8)
        emitelem (58, tl9)
        emitelem (59, vhmax)
        emitelem (60, vhmin)
        emitelem (61, vimax)
        emitelem (62, vimin)
        emitelem (63, vlmax)
        emitelem (64, vlmin)
        emitelem (65, vstmax)
        emitelem (66, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssIEEE4B rdf:ID=\"%s\">\n%s\t</cim:PssIEEE4B>".format (id, export_fields)
    }
}

object PssIEEE4B
    extends
        Parseable[PssIEEE4B]
{
    override val fields: Array[String] = Array [String](
        "bwh1",
        "bwh2",
        "bwl1",
        "bwl2",
        "kh",
        "kh1",
        "kh11",
        "kh17",
        "kh2",
        "ki",
        "ki1",
        "ki11",
        "ki17",
        "ki2",
        "kl",
        "kl1",
        "kl11",
        "kl17",
        "kl2",
        "omeganh1",
        "omeganh2",
        "omeganl1",
        "omeganl2",
        "th1",
        "th10",
        "th11",
        "th12",
        "th2",
        "th3",
        "th4",
        "th5",
        "th6",
        "th7",
        "th8",
        "th9",
        "ti1",
        "ti10",
        "ti11",
        "ti12",
        "ti2",
        "ti3",
        "ti4",
        "ti5",
        "ti6",
        "ti7",
        "ti8",
        "ti9",
        "tl1",
        "tl10",
        "tl11",
        "tl12",
        "tl2",
        "tl3",
        "tl4",
        "tl5",
        "tl6",
        "tl7",
        "tl8",
        "tl9",
        "vhmax",
        "vhmin",
        "vimax",
        "vimin",
        "vlmax",
        "vlmin",
        "vstmax",
        "vstmin"
    )
    val bwh1: Fielder = parse_element (element (cls, fields (0)))
    val bwh2: Fielder = parse_element (element (cls, fields (1)))
    val bwl1: Fielder = parse_element (element (cls, fields (2)))
    val bwl2: Fielder = parse_element (element (cls, fields (3)))
    val kh: Fielder = parse_element (element (cls, fields (4)))
    val kh1: Fielder = parse_element (element (cls, fields (5)))
    val kh11: Fielder = parse_element (element (cls, fields (6)))
    val kh17: Fielder = parse_element (element (cls, fields (7)))
    val kh2: Fielder = parse_element (element (cls, fields (8)))
    val ki: Fielder = parse_element (element (cls, fields (9)))
    val ki1: Fielder = parse_element (element (cls, fields (10)))
    val ki11: Fielder = parse_element (element (cls, fields (11)))
    val ki17: Fielder = parse_element (element (cls, fields (12)))
    val ki2: Fielder = parse_element (element (cls, fields (13)))
    val kl: Fielder = parse_element (element (cls, fields (14)))
    val kl1: Fielder = parse_element (element (cls, fields (15)))
    val kl11: Fielder = parse_element (element (cls, fields (16)))
    val kl17: Fielder = parse_element (element (cls, fields (17)))
    val kl2: Fielder = parse_element (element (cls, fields (18)))
    val omeganh1: Fielder = parse_element (element (cls, fields (19)))
    val omeganh2: Fielder = parse_element (element (cls, fields (20)))
    val omeganl1: Fielder = parse_element (element (cls, fields (21)))
    val omeganl2: Fielder = parse_element (element (cls, fields (22)))
    val th1: Fielder = parse_element (element (cls, fields (23)))
    val th10: Fielder = parse_element (element (cls, fields (24)))
    val th11: Fielder = parse_element (element (cls, fields (25)))
    val th12: Fielder = parse_element (element (cls, fields (26)))
    val th2: Fielder = parse_element (element (cls, fields (27)))
    val th3: Fielder = parse_element (element (cls, fields (28)))
    val th4: Fielder = parse_element (element (cls, fields (29)))
    val th5: Fielder = parse_element (element (cls, fields (30)))
    val th6: Fielder = parse_element (element (cls, fields (31)))
    val th7: Fielder = parse_element (element (cls, fields (32)))
    val th8: Fielder = parse_element (element (cls, fields (33)))
    val th9: Fielder = parse_element (element (cls, fields (34)))
    val ti1: Fielder = parse_element (element (cls, fields (35)))
    val ti10: Fielder = parse_element (element (cls, fields (36)))
    val ti11: Fielder = parse_element (element (cls, fields (37)))
    val ti12: Fielder = parse_element (element (cls, fields (38)))
    val ti2: Fielder = parse_element (element (cls, fields (39)))
    val ti3: Fielder = parse_element (element (cls, fields (40)))
    val ti4: Fielder = parse_element (element (cls, fields (41)))
    val ti5: Fielder = parse_element (element (cls, fields (42)))
    val ti6: Fielder = parse_element (element (cls, fields (43)))
    val ti7: Fielder = parse_element (element (cls, fields (44)))
    val ti8: Fielder = parse_element (element (cls, fields (45)))
    val ti9: Fielder = parse_element (element (cls, fields (46)))
    val tl1: Fielder = parse_element (element (cls, fields (47)))
    val tl10: Fielder = parse_element (element (cls, fields (48)))
    val tl11: Fielder = parse_element (element (cls, fields (49)))
    val tl12: Fielder = parse_element (element (cls, fields (50)))
    val tl2: Fielder = parse_element (element (cls, fields (51)))
    val tl3: Fielder = parse_element (element (cls, fields (52)))
    val tl4: Fielder = parse_element (element (cls, fields (53)))
    val tl5: Fielder = parse_element (element (cls, fields (54)))
    val tl6: Fielder = parse_element (element (cls, fields (55)))
    val tl7: Fielder = parse_element (element (cls, fields (56)))
    val tl8: Fielder = parse_element (element (cls, fields (57)))
    val tl9: Fielder = parse_element (element (cls, fields (58)))
    val vhmax: Fielder = parse_element (element (cls, fields (59)))
    val vhmin: Fielder = parse_element (element (cls, fields (60)))
    val vimax: Fielder = parse_element (element (cls, fields (61)))
    val vimin: Fielder = parse_element (element (cls, fields (62)))
    val vlmax: Fielder = parse_element (element (cls, fields (63)))
    val vlmin: Fielder = parse_element (element (cls, fields (64)))
    val vstmax: Fielder = parse_element (element (cls, fields (65)))
    val vstmin: Fielder = parse_element (element (cls, fields (66)))

    def parse (context: Context): PssIEEE4B =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0, 0)
        val ret = PssIEEE4B (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (bwh1 (), 0)),
            toDouble (mask (bwh2 (), 1)),
            toDouble (mask (bwl1 (), 2)),
            toDouble (mask (bwl2 (), 3)),
            toDouble (mask (kh (), 4)),
            toDouble (mask (kh1 (), 5)),
            toDouble (mask (kh11 (), 6)),
            toDouble (mask (kh17 (), 7)),
            toDouble (mask (kh2 (), 8)),
            toDouble (mask (ki (), 9)),
            toDouble (mask (ki1 (), 10)),
            toDouble (mask (ki11 (), 11)),
            toDouble (mask (ki17 (), 12)),
            toDouble (mask (ki2 (), 13)),
            toDouble (mask (kl (), 14)),
            toDouble (mask (kl1 (), 15)),
            toDouble (mask (kl11 (), 16)),
            toDouble (mask (kl17 (), 17)),
            toDouble (mask (kl2 (), 18)),
            toDouble (mask (omeganh1 (), 19)),
            toDouble (mask (omeganh2 (), 20)),
            toDouble (mask (omeganl1 (), 21)),
            toDouble (mask (omeganl2 (), 22)),
            toDouble (mask (th1 (), 23)),
            toDouble (mask (th10 (), 24)),
            toDouble (mask (th11 (), 25)),
            toDouble (mask (th12 (), 26)),
            toDouble (mask (th2 (), 27)),
            toDouble (mask (th3 (), 28)),
            toDouble (mask (th4 (), 29)),
            toDouble (mask (th5 (), 30)),
            toDouble (mask (th6 (), 31)),
            toDouble (mask (th7 (), 32)),
            toDouble (mask (th8 (), 33)),
            toDouble (mask (th9 (), 34)),
            toDouble (mask (ti1 (), 35)),
            toDouble (mask (ti10 (), 36)),
            toDouble (mask (ti11 (), 37)),
            toDouble (mask (ti12 (), 38)),
            toDouble (mask (ti2 (), 39)),
            toDouble (mask (ti3 (), 40)),
            toDouble (mask (ti4 (), 41)),
            toDouble (mask (ti5 (), 42)),
            toDouble (mask (ti6 (), 43)),
            toDouble (mask (ti7 (), 44)),
            toDouble (mask (ti8 (), 45)),
            toDouble (mask (ti9 (), 46)),
            toDouble (mask (tl1 (), 47)),
            toDouble (mask (tl10 (), 48)),
            toDouble (mask (tl11 (), 49)),
            toDouble (mask (tl12 (), 50)),
            toDouble (mask (tl2 (), 51)),
            toDouble (mask (tl3 (), 52)),
            toDouble (mask (tl4 (), 53)),
            toDouble (mask (tl5 (), 54)),
            toDouble (mask (tl6 (), 55)),
            toDouble (mask (tl7 (), 56)),
            toDouble (mask (tl8 (), 57)),
            toDouble (mask (tl9 (), 58)),
            toDouble (mask (vhmax (), 59)),
            toDouble (mask (vhmin (), 60)),
            toDouble (mask (vimax (), 61)),
            toDouble (mask (vimin (), 62)),
            toDouble (mask (vlmax (), 63)),
            toDouble (mask (vlmin (), 64)),
            toDouble (mask (vstmax (), 65)),
            toDouble (mask (vstmin (), 66))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 1.
 *
 * @param sup [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param dtc Time step related to activation of controls (Dtc).
 *            Typical Value = 0.025.
 * @param dtf Time step frequency calculation (Dtf).
 *            Typical Value = 0.025.
 * @param dtp Time step active power calculation (Dtp).
 *            Typical Value = 0.0125.
 * @param k   Gain (K).
 *            Typical Value = 9.
 * @param m   (M).
 *            M=2*H.  Typical Value = 5.
 * @param t1  Time constant (T1).
 *            Typical Value = 0.3.
 * @param t2  Time constant (T2).
 *            Typical Value = 1.
 * @param t3  Time constant (T3).
 *            Typical Value = 0.2.
 * @param t4  Time constant (T4).
 *            Typical Value = 0.05.
 * @param tf  Time constant (Tf).
 *            Typical Value = 0.2.
 * @param tp  Time constant (Tp).
 *            Typical Value = 0.2.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssPTIST1]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssPTIST1.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssPTIST1.fields (position), value)

        emitelem (0, dtc)
        emitelem (1, dtf)
        emitelem (2, dtp)
        emitelem (3, k)
        emitelem (4, m)
        emitelem (5, t1)
        emitelem (6, t2)
        emitelem (7, t3)
        emitelem (8, t4)
        emitelem (9, tf)
        emitelem (10, tp)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssPTIST1 rdf:ID=\"%s\">\n%s\t</cim:PssPTIST1>".format (id, export_fields)
    }
}

object PssPTIST1
    extends
        Parseable[PssPTIST1]
{
    override val fields: Array[String] = Array [String](
        "dtc",
        "dtf",
        "dtp",
        "k",
        "m",
        "t1",
        "t2",
        "t3",
        "t4",
        "tf",
        "tp"
    )
    val dtc: Fielder = parse_element (element (cls, fields (0)))
    val dtf: Fielder = parse_element (element (cls, fields (1)))
    val dtp: Fielder = parse_element (element (cls, fields (2)))
    val k: Fielder = parse_element (element (cls, fields (3)))
    val m: Fielder = parse_element (element (cls, fields (4)))
    val t1: Fielder = parse_element (element (cls, fields (5)))
    val t2: Fielder = parse_element (element (cls, fields (6)))
    val t3: Fielder = parse_element (element (cls, fields (7)))
    val t4: Fielder = parse_element (element (cls, fields (8)))
    val tf: Fielder = parse_element (element (cls, fields (9)))
    val tp: Fielder = parse_element (element (cls, fields (10)))

    def parse (context: Context): PssPTIST1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssPTIST1 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (dtc (), 0)),
            toDouble (mask (dtf (), 1)),
            toDouble (mask (dtp (), 2)),
            toDouble (mask (k (), 3)),
            toDouble (mask (m (), 4)),
            toDouble (mask (t1 (), 5)),
            toDouble (mask (t2 (), 6)),
            toDouble (mask (t3 (), 7)),
            toDouble (mask (t4 (), 8)),
            toDouble (mask (tf (), 9)),
            toDouble (mask (tp (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PTI Microprocessor-Based Stabilizer type 3.
 *
 * @param sup    [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a0     Filter coefficient (A0).
 * @param a1     Limiter (Al).
 * @param a2     Filter coefficient (A2).
 * @param a3     Filter coefficient (A3).
 * @param a4     Filter coefficient (A4).
 * @param a5     Filter coefficient (A5).
 * @param al     Limiter (Al).
 * @param athres Threshold value above which output averaging will be bypassed (Athres).
 *               Typical Value = 0.005.
 * @param b0     Filter coefficient (B0).
 * @param b1     Filter coefficient (B1).
 * @param b2     Filter coefficient (B2).
 * @param b3     Filter coefficient (B3).
 * @param b4     Filter coefficient (B4).
 * @param b5     Filter coefficient (B5).
 * @param dl     Limiter (Dl).
 * @param dtc    Time step related to activation of controls (0.03 for 50 Hz) (Dtc).
 *               Typical Value = 0.025.
 * @param dtf    Time step frequency calculation (0.03 for 50 Hz) (Dtf).
 *               Typical Value = 0.025.
 * @param dtp    Time step active power calculation (0.015 for 50 Hz) (Dtp).
 *               Typical Value = 0.0125.
 * @param isw    Digital/analog output switch (Isw).
 *               true = produce analog output
 *               false = convert to digital output, using tap selection table.
 * @param k      Gain (K).
 *               Typical Value = 9.
 * @param lthres Threshold value (Lthres).
 * @param m      (M).
 *               M=2*H.  Typical Value = 5.
 * @param nav    Number of control outputs to average (Nav) (1 &lt;= Nav &lt;= 16).
 *               Typical Value = 4.
 * @param ncl    Number of counts at limit to active limit function (Ncl) (&gt;0).
 * @param ncr    Number of counts until reset after limit function is triggered (Ncr).
 * @param pmin   (Pmin).
 * @param t1     Time constant (T1).
 *               Typical Value = 0.3.
 * @param t2     Time constant (T2).
 *               Typical Value = 1.
 * @param t3     Time constant (T3).
 *               Typical Value = 0.2.
 * @param t4     Time constant (T4).
 *               Typical Value = 0.05.
 * @param t5     Time constant (T5).
 * @param t6     Time constant (T6).
 * @param tf     Time constant (Tf).
 *               Typical Value = 0.2.
 * @param tp     Time constant (Tp).
 *               Typical Value = 0.2.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssPTIST3]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssPTIST3.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssPTIST3.fields (position), value)

        emitelem (0, a0)
        emitelem (1, a1)
        emitelem (2, a2)
        emitelem (3, a3)
        emitelem (4, a4)
        emitelem (5, a5)
        emitelem (6, al)
        emitelem (7, athres)
        emitelem (8, b0)
        emitelem (9, b1)
        emitelem (10, b2)
        emitelem (11, b3)
        emitelem (12, b4)
        emitelem (13, b5)
        emitelem (14, dl)
        emitelem (15, dtc)
        emitelem (16, dtf)
        emitelem (17, dtp)
        emitelem (18, isw)
        emitelem (19, k)
        emitelem (20, lthres)
        emitelem (21, m)
        emitelem (22, nav)
        emitelem (23, ncl)
        emitelem (24, ncr)
        emitelem (25, pmin)
        emitelem (26, t1)
        emitelem (27, t2)
        emitelem (28, t3)
        emitelem (29, t4)
        emitelem (30, t5)
        emitelem (31, t6)
        emitelem (32, tf)
        emitelem (33, tp)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssPTIST3 rdf:ID=\"%s\">\n%s\t</cim:PssPTIST3>".format (id, export_fields)
    }
}

object PssPTIST3
    extends
        Parseable[PssPTIST3]
{
    override val fields: Array[String] = Array [String](
        "a0",
        "a1",
        "a2",
        "a3",
        "a4",
        "a5",
        "al",
        "athres",
        "b0",
        "b1",
        "b2",
        "b3",
        "b4",
        "b5",
        "dl",
        "dtc",
        "dtf",
        "dtp",
        "isw",
        "k",
        "lthres",
        "m",
        "nav",
        "ncl",
        "ncr",
        "pmin",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "tf",
        "tp"
    )
    val a0: Fielder = parse_element (element (cls, fields (0)))
    val a1: Fielder = parse_element (element (cls, fields (1)))
    val a2: Fielder = parse_element (element (cls, fields (2)))
    val a3: Fielder = parse_element (element (cls, fields (3)))
    val a4: Fielder = parse_element (element (cls, fields (4)))
    val a5: Fielder = parse_element (element (cls, fields (5)))
    val al: Fielder = parse_element (element (cls, fields (6)))
    val athres: Fielder = parse_element (element (cls, fields (7)))
    val b0: Fielder = parse_element (element (cls, fields (8)))
    val b1: Fielder = parse_element (element (cls, fields (9)))
    val b2: Fielder = parse_element (element (cls, fields (10)))
    val b3: Fielder = parse_element (element (cls, fields (11)))
    val b4: Fielder = parse_element (element (cls, fields (12)))
    val b5: Fielder = parse_element (element (cls, fields (13)))
    val dl: Fielder = parse_element (element (cls, fields (14)))
    val dtc: Fielder = parse_element (element (cls, fields (15)))
    val dtf: Fielder = parse_element (element (cls, fields (16)))
    val dtp: Fielder = parse_element (element (cls, fields (17)))
    val isw: Fielder = parse_element (element (cls, fields (18)))
    val k: Fielder = parse_element (element (cls, fields (19)))
    val lthres: Fielder = parse_element (element (cls, fields (20)))
    val m: Fielder = parse_element (element (cls, fields (21)))
    val nav: Fielder = parse_element (element (cls, fields (22)))
    val ncl: Fielder = parse_element (element (cls, fields (23)))
    val ncr: Fielder = parse_element (element (cls, fields (24)))
    val pmin: Fielder = parse_element (element (cls, fields (25)))
    val t1: Fielder = parse_element (element (cls, fields (26)))
    val t2: Fielder = parse_element (element (cls, fields (27)))
    val t3: Fielder = parse_element (element (cls, fields (28)))
    val t4: Fielder = parse_element (element (cls, fields (29)))
    val t5: Fielder = parse_element (element (cls, fields (30)))
    val t6: Fielder = parse_element (element (cls, fields (31)))
    val tf: Fielder = parse_element (element (cls, fields (32)))
    val tp: Fielder = parse_element (element (cls, fields (33)))

    def parse (context: Context): PssPTIST3 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0, 0)
        val ret = PssPTIST3 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a0 (), 0)),
            toDouble (mask (a1 (), 1)),
            toDouble (mask (a2 (), 2)),
            toDouble (mask (a3 (), 3)),
            toDouble (mask (a4 (), 4)),
            toDouble (mask (a5 (), 5)),
            toDouble (mask (al (), 6)),
            toDouble (mask (athres (), 7)),
            toDouble (mask (b0 (), 8)),
            toDouble (mask (b1 (), 9)),
            toDouble (mask (b2 (), 10)),
            toDouble (mask (b3 (), 11)),
            toDouble (mask (b4 (), 12)),
            toDouble (mask (b5 (), 13)),
            toDouble (mask (dl (), 14)),
            toDouble (mask (dtc (), 15)),
            toDouble (mask (dtf (), 16)),
            toDouble (mask (dtp (), 17)),
            toBoolean (mask (isw (), 18)),
            toDouble (mask (k (), 19)),
            toDouble (mask (lthres (), 20)),
            toDouble (mask (m (), 21)),
            toDouble (mask (nav (), 22)),
            toDouble (mask (ncl (), 23)),
            toDouble (mask (ncr (), 24)),
            toDouble (mask (pmin (), 25)),
            toDouble (mask (t1 (), 26)),
            toDouble (mask (t2 (), 27)),
            toDouble (mask (t3 (), 28)),
            toDouble (mask (t4 (), 29)),
            toDouble (mask (t5 (), 30)),
            toDouble (mask (t6 (), 31)),
            toDouble (mask (tf (), 32)),
            toDouble (mask (tp (), 33))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Power sensitive stabilizer model.
 *
 * @param sup   [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param kx    Gain (Kx).
 * @param ta    Time constant (Ta).
 * @param tb    Time constant (Tb).
 * @param tc    Time constant (Tc).
 * @param td    Time constant (Td).
 * @param te    Time constant (Te).
 * @param tt    Time constant (Tt).
 * @param tx1   Reset time constant (Tx1).
 * @param tx2   Time constant (Tx2).
 * @param vsmax Limiter (Vsmax).
 * @param vsmin Limiter (Vsmin).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssSB4]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssSB4.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssSB4.fields (position), value)

        emitelem (0, kx)
        emitelem (1, ta)
        emitelem (2, tb)
        emitelem (3, tc)
        emitelem (4, td)
        emitelem (5, te)
        emitelem (6, tt)
        emitelem (7, tx1)
        emitelem (8, tx2)
        emitelem (9, vsmax)
        emitelem (10, vsmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssSB4 rdf:ID=\"%s\">\n%s\t</cim:PssSB4>".format (id, export_fields)
    }
}

object PssSB4
    extends
        Parseable[PssSB4]
{
    override val fields: Array[String] = Array [String](
        "kx",
        "ta",
        "tb",
        "tc",
        "td",
        "te",
        "tt",
        "tx1",
        "tx2",
        "vsmax",
        "vsmin"
    )
    val kx: Fielder = parse_element (element (cls, fields (0)))
    val ta: Fielder = parse_element (element (cls, fields (1)))
    val tb: Fielder = parse_element (element (cls, fields (2)))
    val tc: Fielder = parse_element (element (cls, fields (3)))
    val td: Fielder = parse_element (element (cls, fields (4)))
    val te: Fielder = parse_element (element (cls, fields (5)))
    val tt: Fielder = parse_element (element (cls, fields (6)))
    val tx1: Fielder = parse_element (element (cls, fields (7)))
    val tx2: Fielder = parse_element (element (cls, fields (8)))
    val vsmax: Fielder = parse_element (element (cls, fields (9)))
    val vsmin: Fielder = parse_element (element (cls, fields (10)))

    def parse (context: Context): PssSB4 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssSB4 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (kx (), 0)),
            toDouble (mask (ta (), 1)),
            toDouble (mask (tb (), 2)),
            toDouble (mask (tc (), 3)),
            toDouble (mask (td (), 4)),
            toDouble (mask (te (), 5)),
            toDouble (mask (tt (), 6)),
            toDouble (mask (tx1 (), 7)),
            toDouble (mask (tx2 (), 8)),
            toDouble (mask (vsmax (), 9)),
            toDouble (mask (vsmin (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Model for Siemens �H infinity� power system stabilizer with generator electrical power input.
 *
 * @param sup   [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param k     Main gain (K).
 *              Typical Value = 1.
 * @param k0    Gain 0 (K0).
 *              Typical Value = 0.012.
 * @param k1    Gain 1 (K1).
 *              Typical Value = 0.488.
 * @param k2    Gain 2 (K2).
 *              Typical Value = 0.064.
 * @param k3    Gain 3 (K3).
 *              Typical Value = 0.224.
 * @param k4    Gain 4 (K4).
 *              Typical Value = 0.1.
 * @param t1    Time constant 1 (T1).
 *              Typical Value = 0.076.
 * @param t2    Time constant 2 (T2).
 *              Typical Value = 0.086.
 * @param t3    Time constant 3 (T3).
 *              Typical Value = 1.068.
 * @param t4    Time constant 4 (T4).
 *              Typical Value = 1.913.
 * @param td    Input time constant (Td).
 *              Typical Value = 10.
 * @param vsmax Output maximum limit (Vsmax).
 *              Typical Value = 0.1.
 * @param vsmin Output minimum limit (Vsmin).
 *              Typical Value = -0.1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssSH]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssSH.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssSH.fields (position), value)

        emitelem (0, k)
        emitelem (1, k0)
        emitelem (2, k1)
        emitelem (3, k2)
        emitelem (4, k3)
        emitelem (5, k4)
        emitelem (6, t1)
        emitelem (7, t2)
        emitelem (8, t3)
        emitelem (9, t4)
        emitelem (10, td)
        emitelem (11, vsmax)
        emitelem (12, vsmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssSH rdf:ID=\"%s\">\n%s\t</cim:PssSH>".format (id, export_fields)
    }
}

object PssSH
    extends
        Parseable[PssSH]
{
    override val fields: Array[String] = Array [String](
        "k",
        "k0",
        "k1",
        "k2",
        "k3",
        "k4",
        "t1",
        "t2",
        "t3",
        "t4",
        "td",
        "vsmax",
        "vsmin"
    )
    val k: Fielder = parse_element (element (cls, fields (0)))
    val k0: Fielder = parse_element (element (cls, fields (1)))
    val k1: Fielder = parse_element (element (cls, fields (2)))
    val k2: Fielder = parse_element (element (cls, fields (3)))
    val k3: Fielder = parse_element (element (cls, fields (4)))
    val k4: Fielder = parse_element (element (cls, fields (5)))
    val t1: Fielder = parse_element (element (cls, fields (6)))
    val t2: Fielder = parse_element (element (cls, fields (7)))
    val t3: Fielder = parse_element (element (cls, fields (8)))
    val t4: Fielder = parse_element (element (cls, fields (9)))
    val td: Fielder = parse_element (element (cls, fields (10)))
    val vsmax: Fielder = parse_element (element (cls, fields (11)))
    val vsmin: Fielder = parse_element (element (cls, fields (12)))

    def parse (context: Context): PssSH =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssSH (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (k (), 0)),
            toDouble (mask (k0 (), 1)),
            toDouble (mask (k1 (), 2)),
            toDouble (mask (k2 (), 3)),
            toDouble (mask (k3 (), 4)),
            toDouble (mask (k4 (), 5)),
            toDouble (mask (t1 (), 6)),
            toDouble (mask (t2 (), 7)),
            toDouble (mask (t3 (), 8)),
            toDouble (mask (t4 (), 9)),
            toDouble (mask (td (), 10)),
            toDouble (mask (vsmax (), 11)),
            toDouble (mask (vsmin (), 12))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PSS Slovakian type � three inputs.
 *
 * @param sup   [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param k1    Gain P (K1).
 *              Typical Value = -0.3.
 * @param k2    Gain fe (K2).
 *              Typical Value = -0.15.
 * @param k3    Gain If (K3).
 *              Typical Value = 10.
 * @param t1    Denominator time constant (T1).
 *              Typical Value = 0.3.
 * @param t2    Filter time constant (T2).
 *              Typical Value = 0.35.
 * @param t3    Denominator time constant (T3).
 *              Typical Value = 0.22.
 * @param t4    Filter time constant (T4).
 *              Typical Value = 0.02.
 * @param t5    Denominator time constant (T5).
 *              Typical Value = 0.02.
 * @param t6    Filter time constant (T6).
 *              Typical Value = 0.02.
 * @param vsmax Stabilizer output max limit (Vsmax).
 *              Typical Value = 0.4.
 * @param vsmin Stabilizer output min limit (Vsmin).
 *              Typical Value = -0.4.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssSK]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssSK.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssSK.fields (position), value)

        emitelem (0, k1)
        emitelem (1, k2)
        emitelem (2, k3)
        emitelem (3, t1)
        emitelem (4, t2)
        emitelem (5, t3)
        emitelem (6, t4)
        emitelem (7, t5)
        emitelem (8, t6)
        emitelem (9, vsmax)
        emitelem (10, vsmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssSK rdf:ID=\"%s\">\n%s\t</cim:PssSK>".format (id, export_fields)
    }
}

object PssSK
    extends
        Parseable[PssSK]
{
    override val fields: Array[String] = Array [String](
        "k1",
        "k2",
        "k3",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "vsmax",
        "vsmin"
    )
    val k1: Fielder = parse_element (element (cls, fields (0)))
    val k2: Fielder = parse_element (element (cls, fields (1)))
    val k3: Fielder = parse_element (element (cls, fields (2)))
    val t1: Fielder = parse_element (element (cls, fields (3)))
    val t2: Fielder = parse_element (element (cls, fields (4)))
    val t3: Fielder = parse_element (element (cls, fields (5)))
    val t4: Fielder = parse_element (element (cls, fields (6)))
    val t5: Fielder = parse_element (element (cls, fields (7)))
    val t6: Fielder = parse_element (element (cls, fields (8)))
    val vsmax: Fielder = parse_element (element (cls, fields (9)))
    val vsmin: Fielder = parse_element (element (cls, fields (10)))

    def parse (context: Context): PssSK =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssSK (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (k1 (), 0)),
            toDouble (mask (k2 (), 1)),
            toDouble (mask (k3 (), 2)),
            toDouble (mask (t1 (), 3)),
            toDouble (mask (t2 (), 4)),
            toDouble (mask (t3 (), 5)),
            toDouble (mask (t4 (), 6)),
            toDouble (mask (t5 (), 7)),
            toDouble (mask (t6 (), 8)),
            toDouble (mask (vsmax (), 9)),
            toDouble (mask (vsmin (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Dual input Power System Stabilizer, based on IEEE type 2, with modified output limiter defined by WECC (Western Electricity Coordinating Council, USA).
 *
 * @param sup              [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type Type of input signal #1.
 * @param inputSignal2Type Type of input signal #2.
 * @param k1               Input signal 1 gain  (K<sub>1</sub>).
 * @param k2               Input signal 2 gain (K<sub>2</sub>).
 * @param t1               Input signal 1 transducer time constant (T<sub>1</sub>).
 * @param t10              Lag time constant (T<sub>10</sub>).
 * @param t2               Input signal 2 transducer time constant (T<sub>2</sub>).
 * @param t3               Stabilizer washout time constant (T<sub>3</sub>).
 * @param t4               Stabilizer washout time lag constant (T<sub>4</sub>) (&gt;0).
 * @param t5               Lead time constant (T<sub>5</sub>).
 * @param t6               Lag time constant (T<sub>6</sub>).
 * @param t7               Lead time constant (T<sub>7</sub>).
 * @param t8               Lag time constant (T<sub>8</sub>).
 * @param t9               Lead time constant (T<sub>9</sub>).
 * @param vcl              Minimum value for voltage compensator output (V<sub>CL</sub>).
 * @param vcu              Maximum value for voltage compensator output (V<sub>CU</sub>).
 * @param vsmax            Maximum output signal (Vsmax).
 * @param vsmin            Minimum output signal (Vsmin).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.  A variety of input signals may be used depending on the particular design.
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
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf [PowerSystemStabilizerDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PssWECC]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssWECC.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssWECC.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PssWECC.fields (position), value)

        emitattr (0, inputSignal1Type)
        emitattr (1, inputSignal2Type)
        emitelem (2, k1)
        emitelem (3, k2)
        emitelem (4, t1)
        emitelem (5, t10)
        emitelem (6, t2)
        emitelem (7, t3)
        emitelem (8, t4)
        emitelem (9, t5)
        emitelem (10, t6)
        emitelem (11, t7)
        emitelem (12, t8)
        emitelem (13, t9)
        emitelem (14, vcl)
        emitelem (15, vcu)
        emitelem (16, vsmax)
        emitelem (17, vsmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssWECC rdf:ID=\"%s\">\n%s\t</cim:PssWECC>".format (id, export_fields)
    }
}

object PssWECC
    extends
        Parseable[PssWECC]
{
    override val fields: Array[String] = Array [String](
        "inputSignal1Type",
        "inputSignal2Type",
        "k1",
        "k2",
        "t1",
        "t10",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "t7",
        "t8",
        "t9",
        "vcl",
        "vcu",
        "vsmax",
        "vsmin"
    )
    val inputSignal1Type: Fielder = parse_attribute (attribute (cls, fields (0)))
    val inputSignal2Type: Fielder = parse_attribute (attribute (cls, fields (1)))
    val k1: Fielder = parse_element (element (cls, fields (2)))
    val k2: Fielder = parse_element (element (cls, fields (3)))
    val t1: Fielder = parse_element (element (cls, fields (4)))
    val t10: Fielder = parse_element (element (cls, fields (5)))
    val t2: Fielder = parse_element (element (cls, fields (6)))
    val t3: Fielder = parse_element (element (cls, fields (7)))
    val t4: Fielder = parse_element (element (cls, fields (8)))
    val t5: Fielder = parse_element (element (cls, fields (9)))
    val t6: Fielder = parse_element (element (cls, fields (10)))
    val t7: Fielder = parse_element (element (cls, fields (11)))
    val t8: Fielder = parse_element (element (cls, fields (12)))
    val t9: Fielder = parse_element (element (cls, fields (13)))
    val vcl: Fielder = parse_element (element (cls, fields (14)))
    val vcu: Fielder = parse_element (element (cls, fields (15)))
    val vsmax: Fielder = parse_element (element (cls, fields (16)))
    val vsmin: Fielder = parse_element (element (cls, fields (17)))

    def parse (context: Context): PssWECC =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PssWECC (
            PowerSystemStabilizerDynamics.parse (context),
            mask (inputSignal1Type (), 0),
            mask (inputSignal2Type (), 1),
            toDouble (mask (k1 (), 2)),
            toDouble (mask (k2 (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t10 (), 5)),
            toDouble (mask (t2 (), 6)),
            toDouble (mask (t3 (), 7)),
            toDouble (mask (t4 (), 8)),
            toDouble (mask (t5 (), 9)),
            toDouble (mask (t6 (), 10)),
            toDouble (mask (t7 (), 11)),
            toDouble (mask (t8 (), 12)),
            toDouble (mask (t9 (), 13)),
            toDouble (mask (vcl (), 14)),
            toDouble (mask (vcu (), 15)),
            toDouble (mask (vsmax (), 16)),
            toDouble (mask (vsmin (), 17))
        )
        ret.bitfields = bitfields
        ret
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