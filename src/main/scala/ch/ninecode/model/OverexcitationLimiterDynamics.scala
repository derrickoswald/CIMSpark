package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding.
 * Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 */

/**
 * Different from LimIEEEOEL, LimOEL2 has a fixed pickup threshold and reduces the excitation set-point by mean of non-windup integral regulator.
 * Irated is the rated machine excitation current (calculated from nameplate conditions: V<sub>nom</sub>, P<sub>nom</sub>, CosPhi<sub>nom</sub>).
 * @param sup Reference to the superclass object.
 * @param ifdlim Limit value of rated field current (I<sub>FDLIM</sub>).
 *        Typical Value = 1.05.
 * @param koi Gain Over excitation limiter (K<sub>OI</sub>).
 *        Typical Value = 0.1.
 * @param voimax Maximum error signal (V<sub>OIMAX</sub>).
 *        Typical Value = 0.
 * @param voimin Minimum error signal (V<sub>OIMIN</sub>).
 *        Typical Value = -9999.
 */
case class OverexcLim2
(
    override val sup: Element,
    val ifdlim: Double,
    val koi: Double,
    val voimax: Double,
    val voimin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0) }
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcLim2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcLim2
extends
    Parseable[OverexcLim2]
{
    val sup = OverexcitationLimiterDynamics.parse _
    val ifdlim = parse_element (element ("""OverexcLim2.ifdlim"""))
    val koi = parse_element (element ("""OverexcLim2.koi"""))
    val voimax = parse_element (element ("""OverexcLim2.voimax"""))
    val voimin = parse_element (element ("""OverexcLim2.voimin"""))
    def parse (context: Context): OverexcLim2 =
    {
        OverexcLim2(
            sup (context),
            toDouble (ifdlim (context), context),
            toDouble (koi (context), context),
            toDouble (voimax (context), context),
            toDouble (voimin (context), context)
        )
    }
}

/**
 * The over excitation limiter model is intended to represent the significant features of OELs necessary for some large-scale system studies.
 * It is the result of a pragmatic approach to obtain a model that can be widely applied with attainable data from generator owners. An attempt to include all variations in the functionality of OELs and duplicate how they interact with the rest of the excitation systems would likely result in a level of application insufficient for the studies for which they are intended.
 * @param sup Reference to the superclass object.
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
 */
case class OverexcLimIEEE
(
    override val sup: Element,
    val hyst: Double,
    val ifdlim: Double,
    val ifdmax: Double,
    val itfpu: Double,
    val kcd: Double,
    val kramp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcLimIEEE]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcLimIEEE
extends
    Parseable[OverexcLimIEEE]
{
    val sup = OverexcitationLimiterDynamics.parse _
    val hyst = parse_element (element ("""OverexcLimIEEE.hyst"""))
    val ifdlim = parse_element (element ("""OverexcLimIEEE.ifdlim"""))
    val ifdmax = parse_element (element ("""OverexcLimIEEE.ifdmax"""))
    val itfpu = parse_element (element ("""OverexcLimIEEE.itfpu"""))
    val kcd = parse_element (element ("""OverexcLimIEEE.kcd"""))
    val kramp = parse_element (element ("""OverexcLimIEEE.kramp"""))
    def parse (context: Context): OverexcLimIEEE =
    {
        OverexcLimIEEE(
            sup (context),
            toDouble (hyst (context), context),
            toDouble (ifdlim (context), context),
            toDouble (ifdmax (context), context),
            toDouble (itfpu (context), context),
            toDouble (kcd (context), context),
            toDouble (kramp (context), context)
        )
    }
}

/**
 * Field voltage over excitation limiter.
 * @param sup Reference to the superclass object.
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
 */
case class OverexcLimX1
(
    override val sup: Element,
    val efd1: Double,
    val efd2: Double,
    val efd3: Double,
    val efddes: Double,
    val efdrated: Double,
    val kmx: Double,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val vlow: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcLimX1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcLimX1
extends
    Parseable[OverexcLimX1]
{
    val sup = OverexcitationLimiterDynamics.parse _
    val efd1 = parse_element (element ("""OverexcLimX1.efd1"""))
    val efd2 = parse_element (element ("""OverexcLimX1.efd2"""))
    val efd3 = parse_element (element ("""OverexcLimX1.efd3"""))
    val efddes = parse_element (element ("""OverexcLimX1.efddes"""))
    val efdrated = parse_element (element ("""OverexcLimX1.efdrated"""))
    val kmx = parse_element (element ("""OverexcLimX1.kmx"""))
    val t1 = parse_element (element ("""OverexcLimX1.t1"""))
    val t2 = parse_element (element ("""OverexcLimX1.t2"""))
    val t3 = parse_element (element ("""OverexcLimX1.t3"""))
    val vlow = parse_element (element ("""OverexcLimX1.vlow"""))
    def parse (context: Context): OverexcLimX1 =
    {
        OverexcLimX1(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (efd3 (context), context),
            toDouble (efddes (context), context),
            toDouble (efdrated (context), context),
            toDouble (kmx (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vlow (context), context)
        )
    }
}

/**
 * Field Voltage or Current overexcitation limiter designed to protect the generator field of an AC machine with automatic excitation control from overheating due to prolonged overexcitation.
 * @param sup Reference to the superclass object.
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
true = IFD limiting
 *        false = EFD limiting.
 * @param t1 Time to trip the exciter at the low voltage or current point on the inverse time characteristic (TIME<sub>1</sub>).
 *        Typical Value = 120.
 * @param t2 Time to trip the exciter at the mid voltage or current point on the inverse time characteristic (TIME<sub>2</sub>).
 *        Typical Value = 40.
 * @param t3 Time to trip the exciter at the high voltage or current point on the inverse time characteristic (TIME<sub>3</sub>).
 *        Typical Value = 15.
 * @param vlow Low voltage limit (V<sub>LOW</sub>) (&gt;0).
 */
case class OverexcLimX2
(
    override val sup: Element,
    val efd1: Double,
    val efd2: Double,
    val efd3: Double,
    val efddes: Double,
    val efdrated: Double,
    val kmx: Double,
    val m: Boolean,
    val t1: Double,
    val t2: Double,
    val t3: Double,
    val vlow: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0) }
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcLimX2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcLimX2
extends
    Parseable[OverexcLimX2]
{
    val sup = OverexcitationLimiterDynamics.parse _
    val efd1 = parse_element (element ("""OverexcLimX2.efd1"""))
    val efd2 = parse_element (element ("""OverexcLimX2.efd2"""))
    val efd3 = parse_element (element ("""OverexcLimX2.efd3"""))
    val efddes = parse_element (element ("""OverexcLimX2.efddes"""))
    val efdrated = parse_element (element ("""OverexcLimX2.efdrated"""))
    val kmx = parse_element (element ("""OverexcLimX2.kmx"""))
    val m = parse_element (element ("""OverexcLimX2.m"""))
    val t1 = parse_element (element ("""OverexcLimX2.t1"""))
    val t2 = parse_element (element ("""OverexcLimX2.t2"""))
    val t3 = parse_element (element ("""OverexcLimX2.t3"""))
    val vlow = parse_element (element ("""OverexcLimX2.vlow"""))
    def parse (context: Context): OverexcLimX2 =
    {
        OverexcLimX2(
            sup (context),
            toDouble (efd1 (context), context),
            toDouble (efd2 (context), context),
            toDouble (efd3 (context), context),
            toDouble (efddes (context), context),
            toDouble (efdrated (context), context),
            toDouble (kmx (context), context),
            toBoolean (m (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vlow (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">O</font>Overexcitation limiter function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this overexcitation limiter model is associated.
 */
case class OverexcitationLimiterDynamics
(
    override val sup: Element,
    val ExcitationSystemDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcitationLimiterDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcitationLimiterDynamics
extends
    Parseable[OverexcitationLimiterDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""OverexcitationLimiterDynamics.ExcitationSystemDynamics"""))
    def parse (context: Context): OverexcitationLimiterDynamics =
    {
        OverexcitationLimiterDynamics(
            sup (context),
            ExcitationSystemDynamics (context)
        )
    }
}

object _OverexcitationLimiterDynamics
{
    def register: Unit =
    {
        OverexcLim2.register
        OverexcLimIEEE.register
        OverexcLimX1.register
        OverexcLimX2.register
        OverexcitationLimiterDynamics.register
    }
}