package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Different from LimIEEEOEL, LimOEL2 has a fixed pickup threshold and reduces the excitation set-point by mean of non-windup integral regulator.
 *
 * Irated is the rated machine excitation current (calculated from nameplate conditions: V<sub>nom</sub>, P<sub>nom</sub>, CosPhi<sub>nom</sub>).
 *
 * @param sup [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param ifdlim Limit value of rated field current (I<sub>FDLIM</sub>).
 *        Typical Value = 1.05.
 * @param koi Gain Over excitation limiter (K<sub>OI</sub>).
 *        Typical Value = 0.1.
 * @param voimax Maximum error signal (V<sub>OIMAX</sub>).
 *        Typical Value = 0.
 * @param voimin Minimum error signal (V<sub>OIMIN</sub>).
 *        Typical Value = -9999.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLim2
(
    override val sup: OverexcitationLimiterDynamics,
    ifdlim: Double,
    koi: Double,
    voimax: Double,
    voimin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLim2] }
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
        implicit val clz: String = OverexcLim2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcLim2.fields (position), value)
        emitelem (0, ifdlim)
        emitelem (1, koi)
        emitelem (2, voimax)
        emitelem (3, voimin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcLim2 rdf:ID=\"%s\">\n%s\t</cim:OverexcLim2>".format (id, export_fields)
    }
}

object OverexcLim2
extends
    Parseable[OverexcLim2]
{
    val fields: Array[String] = Array[String] (
        "ifdlim",
        "koi",
        "voimax",
        "voimin"
    )
    val ifdlim: Fielder = parse_element (element (cls, fields(0)))
    val koi: Fielder = parse_element (element (cls, fields(1)))
    val voimax: Fielder = parse_element (element (cls, fields(2)))
    val voimin: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): OverexcLim2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverexcLim2 (
            OverexcitationLimiterDynamics.parse (context),
            toDouble (mask (ifdlim (), 0)),
            toDouble (mask (koi (), 1)),
            toDouble (mask (voimax (), 2)),
            toDouble (mask (voimin (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The over excitation limiter model is intended to represent the significant features of OELs necessary for some large-scale system studies.
 *
 * It is the result of a pragmatic approach to obtain a model that can be widely applied with attainable data from generator owners. An attempt to include all variations in the functionality of OELs and duplicate how they interact with the rest of the excitation systems would likely result in a level of application insufficient for the studies for which they are intended.
 *
 * @param sup [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param hyst OEL pickup/drop-out hysteresis (HYST).
 *        Typical Value = 0.03.
 * @param ifdlim OEL timed field current limit (I<sub>FDLIM</sub>).
 *        Typical Value = 1.05.
 * @param ifdmax OEL instantaneous field current limit (I<sub>FDMAX</sub>).
 *        Typical Value = 1.5.
 * @param itfpu OEL timed field current limiter pickup level (I<sub>TFPU</sub>).
 *        Typical Value = 1.05.
 * @param kcd OEL cooldown gain (K<sub>CD</sub>).
 *        Typical Value = 1.
 * @param kramp OEL ramped limit rate (K<sub>RAMP</sub>).
 *        Unit = PU/sec.  Typical Value = 10.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimIEEE
(
    override val sup: OverexcitationLimiterDynamics,
    hyst: Double,
    ifdlim: Double,
    ifdmax: Double,
    itfpu: Double,
    kcd: Double,
    kramp: Double
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
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimIEEE] }
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
        implicit val clz: String = OverexcLimIEEE.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcLimIEEE.fields (position), value)
        emitelem (0, hyst)
        emitelem (1, ifdlim)
        emitelem (2, ifdmax)
        emitelem (3, itfpu)
        emitelem (4, kcd)
        emitelem (5, kramp)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcLimIEEE rdf:ID=\"%s\">\n%s\t</cim:OverexcLimIEEE>".format (id, export_fields)
    }
}

object OverexcLimIEEE
extends
    Parseable[OverexcLimIEEE]
{
    val fields: Array[String] = Array[String] (
        "hyst",
        "ifdlim",
        "ifdmax",
        "itfpu",
        "kcd",
        "kramp"
    )
    val hyst: Fielder = parse_element (element (cls, fields(0)))
    val ifdlim: Fielder = parse_element (element (cls, fields(1)))
    val ifdmax: Fielder = parse_element (element (cls, fields(2)))
    val itfpu: Fielder = parse_element (element (cls, fields(3)))
    val kcd: Fielder = parse_element (element (cls, fields(4)))
    val kramp: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): OverexcLimIEEE =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverexcLimIEEE (
            OverexcitationLimiterDynamics.parse (context),
            toDouble (mask (hyst (), 0)),
            toDouble (mask (ifdlim (), 1)),
            toDouble (mask (ifdmax (), 2)),
            toDouble (mask (itfpu (), 3)),
            toDouble (mask (kcd (), 4)),
            toDouble (mask (kramp (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Field voltage over excitation limiter.
 *
 * @param sup [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param efd1 Low voltage point on the inverse time characteristic (EFD<sub>1</sub>).
 *        Typical Value = 1.1.
 * @param efd2 Mid voltage point on the inverse time characteristic (EFD<sub>2</sub>).
 *        Typical Value = 1.2.
 * @param efd3 High voltage point on the inverse time characteristic (EFD<sub>3</sub>).
 *        Typical Value = 1.5.
 * @param efddes Desired field voltage (EFD<sub>DES</sub>).
 *        Typical Value = 0.9.
 * @param efdrated Rated field voltage (EFD<sub>RATED</sub>).
 *        Typical Value = 1.05.
 * @param kmx Gain (K<sub>MX</sub>).
 *        Typical Value = 0.01.
 * @param t1 Time to trip the exciter at the low voltage point on the inverse time characteristic (TIME<sub>1</sub>).
 *        Typical Value = 120.
 * @param t2 Time to trip the exciter at the mid voltage point on the inverse time characteristic (TIME<sub>2</sub>).
 *        Typical Value = 40.
 * @param t3 Time to trip the exciter at the high voltage point on the inverse time characteristic (TIME<sub>3</sub>).
 *        Typical Value = 15.
 * @param vlow Low voltage limit (V<sub>LOW</sub>) (&gt;0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimX1
(
    override val sup: OverexcitationLimiterDynamics,
    efd1: Double,
    efd2: Double,
    efd3: Double,
    efddes: Double,
    efdrated: Double,
    kmx: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    vlow: Double
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
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimX1] }
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
        implicit val clz: String = OverexcLimX1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcLimX1.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, efd3)
        emitelem (3, efddes)
        emitelem (4, efdrated)
        emitelem (5, kmx)
        emitelem (6, t1)
        emitelem (7, t2)
        emitelem (8, t3)
        emitelem (9, vlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcLimX1 rdf:ID=\"%s\">\n%s\t</cim:OverexcLimX1>".format (id, export_fields)
    }
}

object OverexcLimX1
extends
    Parseable[OverexcLimX1]
{
    val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "efd3",
        "efddes",
        "efdrated",
        "kmx",
        "t1",
        "t2",
        "t3",
        "vlow"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val efd3: Fielder = parse_element (element (cls, fields(2)))
    val efddes: Fielder = parse_element (element (cls, fields(3)))
    val efdrated: Fielder = parse_element (element (cls, fields(4)))
    val kmx: Fielder = parse_element (element (cls, fields(5)))
    val t1: Fielder = parse_element (element (cls, fields(6)))
    val t2: Fielder = parse_element (element (cls, fields(7)))
    val t3: Fielder = parse_element (element (cls, fields(8)))
    val vlow: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): OverexcLimX1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverexcLimX1 (
            OverexcitationLimiterDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (efd3 (), 2)),
            toDouble (mask (efddes (), 3)),
            toDouble (mask (efdrated (), 4)),
            toDouble (mask (kmx (), 5)),
            toDouble (mask (t1 (), 6)),
            toDouble (mask (t2 (), 7)),
            toDouble (mask (t3 (), 8)),
            toDouble (mask (vlow (), 9))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Field Voltage or Current overexcitation limiter designed to protect the generator field of an AC machine with automatic excitation control from overheating due to prolonged overexcitation.
 *
 * @param sup [[ch.ninecode.model.OverexcitationLimiterDynamics OverexcitationLimiterDynamics]] Reference to the superclass object.
 * @param efd1 Low voltage or current point on the inverse time characteristic (EFD<sub>1</sub>).
 *        Typical Value = 1.1.
 * @param efd2 Mid voltage or current point on the inverse time characteristic (EFD<sub>2</sub>).
 *        Typical Value = 1.2.
 * @param efd3 High voltage or current point on the inverse time characteristic (EFD<sub>3</sub>).
 *        Typical Value = 1.5.
 * @param efddes Desired field voltage if m=F or field current if m=T (EFD<sub>DES</sub>).
 *        Typical Value = 1.
 * @param efdrated Rated field voltage if m=F or field current if m=T (EFD<sub>RATED</sub>).
 *        Typical Value = 1.05.
 * @param kmx Gain (K<sub>MX</sub>).
 *        Typical Value = 0.002.
 * @param m (m).
 *        true = IFD limiting
 *        false = EFD limiting.
 * @param t1 Time to trip the exciter at the low voltage or current point on the inverse time characteristic (TIME<sub>1</sub>).
 *        Typical Value = 120.
 * @param t2 Time to trip the exciter at the mid voltage or current point on the inverse time characteristic (TIME<sub>2</sub>).
 *        Typical Value = 40.
 * @param t3 Time to trip the exciter at the high voltage or current point on the inverse time characteristic (TIME<sub>3</sub>).
 *        Typical Value = 15.
 * @param vlow Low voltage limit (V<sub>LOW</sub>) (&gt;0).
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcLimX2
(
    override val sup: OverexcitationLimiterDynamics,
    efd1: Double,
    efd2: Double,
    efd3: Double,
    efddes: Double,
    efdrated: Double,
    kmx: Double,
    m: Boolean,
    t1: Double,
    t2: Double,
    t3: Double,
    vlow: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[OverexcLimX2] }
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
        implicit val clz: String = OverexcLimX2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OverexcLimX2.fields (position), value)
        emitelem (0, efd1)
        emitelem (1, efd2)
        emitelem (2, efd3)
        emitelem (3, efddes)
        emitelem (4, efdrated)
        emitelem (5, kmx)
        emitelem (6, m)
        emitelem (7, t1)
        emitelem (8, t2)
        emitelem (9, t3)
        emitelem (10, vlow)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcLimX2 rdf:ID=\"%s\">\n%s\t</cim:OverexcLimX2>".format (id, export_fields)
    }
}

object OverexcLimX2
extends
    Parseable[OverexcLimX2]
{
    val fields: Array[String] = Array[String] (
        "efd1",
        "efd2",
        "efd3",
        "efddes",
        "efdrated",
        "kmx",
        "m",
        "t1",
        "t2",
        "t3",
        "vlow"
    )
    val efd1: Fielder = parse_element (element (cls, fields(0)))
    val efd2: Fielder = parse_element (element (cls, fields(1)))
    val efd3: Fielder = parse_element (element (cls, fields(2)))
    val efddes: Fielder = parse_element (element (cls, fields(3)))
    val efdrated: Fielder = parse_element (element (cls, fields(4)))
    val kmx: Fielder = parse_element (element (cls, fields(5)))
    val m: Fielder = parse_element (element (cls, fields(6)))
    val t1: Fielder = parse_element (element (cls, fields(7)))
    val t2: Fielder = parse_element (element (cls, fields(8)))
    val t3: Fielder = parse_element (element (cls, fields(9)))
    val vlow: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): OverexcLimX2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverexcLimX2 (
            OverexcitationLimiterDynamics.parse (context),
            toDouble (mask (efd1 (), 0)),
            toDouble (mask (efd2 (), 1)),
            toDouble (mask (efd3 (), 2)),
            toDouble (mask (efddes (), 3)),
            toDouble (mask (efdrated (), 4)),
            toDouble (mask (kmx (), 5)),
            toBoolean (mask (m (), 6)),
            toDouble (mask (t1 (), 7)),
            toDouble (mask (t2 (), 8)),
            toDouble (mask (t3 (), 9)),
            toDouble (mask (vlow (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * <font color="#0f0f0f">O</font>Overexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this overexcitation limiter model is associated.
 * @group OverexcitationLimiterDynamics
 * @groupname OverexcitationLimiterDynamics Package OverexcitationLimiterDynamics
 * @groupdesc OverexcitationLimiterDynamics Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding. Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */
case class OverexcitationLimiterDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[OverexcitationLimiterDynamics] }
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
        implicit val clz: String = OverexcitationLimiterDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OverexcitationLimiterDynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OverexcitationLimiterDynamics rdf:ID=\"%s\">\n%s\t</cim:OverexcitationLimiterDynamics>".format (id, export_fields)
    }
}

object OverexcitationLimiterDynamics
extends
    Parseable[OverexcitationLimiterDynamics]
{
    val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics"
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): OverexcitationLimiterDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OverexcitationLimiterDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", false)
    )
}

private[ninecode] object _OverexcitationLimiterDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            OverexcLim2.register,
            OverexcLimIEEE.register,
            OverexcLimX1.register,
            OverexcLimX2.register,
            OverexcitationLimiterDynamics.register
        )
    }
}