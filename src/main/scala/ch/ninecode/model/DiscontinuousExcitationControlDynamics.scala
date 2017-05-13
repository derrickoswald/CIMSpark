package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font colour="#0f0f0f">In some particular system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited.
 * For these situations, discontinuous excitation control signals may be employed to enhance stability following large transient disturbances.</font>
 */

/**
 * The class represents IEEE Type DEC1A discontinuous excitation control model that boosts generator excitation to a level higher than that demanded by the voltage regulator and stabilizer immediately following a system fault.
 * Reference: IEEE Standard 421.5-2005 Section 12.2.
 */
case class DiscExcContIEEEDEC1A
(

    override val sup: DiscontinuousExcitationControlDynamics,

    /**
     * Speed change reference (<i>E</i><i><sub>SC</sub></i>).
     * Typical Value = 0.0015.
     */
    val esc: Double,

    /**
     * Discontinuous controller gain (<i>K</i><i><sub>AN</sub></i>).
     * Typical Value = 400.
     */
    val kan: Double,

    /**
     * Terminal voltage limiter gain (<i>K</i><i><sub>ETL</sub></i>).
     * Typical Value = 47.
     */
    val ketl: Double,

    /**
     * Discontinuous controller time constant (<i>T</i><i><sub>AN</sub></i>).
     * Typical Value = 0.08.
     */
    val tan: Double,

    /**
     * Time constant (<i>T</i><i><sub>D</sub></i>).
     * Typical Value = 0.03.
     */
    val td: Double,

    /**
     * Time constant (<i>T</i><i><sub>L</sub></i><sub>1</sub>).
     * Typical Value = 0.025.
     */
    val tl1: Double,

    /**
     * Time constant (<i>T</i><i><sub>L</sub></i><sub>2</sub>).
     * Typical Value = 1.25.
     */
    val tl2: Double,

    /**
     * DEC washout time constant (<i>T</i><i><sub>W</sub></i><sub>5</sub>).
     * Typical Value = 5.
     */
    val tw5: Double,

    /**
     * Limiter for Van (<i>V</i><i><sub>ANMAX</sub></i>).
     */
    val vanmax: Double,

    /**
     * Limiter (<i>V</i><i><sub>OMAX</sub></i>).
     * Typical Value = 0.3.
     */
    val vomax: Double,

    /**
     * Limiter (<i>V</i><i><sub>OMIN</sub></i>).
     * Typical Value = 0.1.
     */
    val vomin: Double,

    /**
     * Limiter (<i>V</i><i><sub>SMAX</sub></i>).
     * Typical Value = 0.2.
     */
    val vsmax: Double,

    /**
     * Limiter (<i>V</i><i><sub>SMIN</sub></i>).
     * Typical Value = -0.066.
     */
    val vsmin: Double,

    /**
     * Terminal voltage level reference (<i>V</i><i><sub>TC</sub></i>).
     * Typical Value = 0.95.
     */
    val vtc: Double,

    /**
     * Voltage reference (<i>V</i><i><sub>TLMT</sub></i>).
     * Typical Value = 1.1.
     */
    val vtlmt: Double,

    /**
     * Voltage limits (<i>V</i><i><sub>TM</sub></i>).
     * Typical Value = 1.13.
     */
    val vtm: Double,

    /**
     * Voltage limits (<i>V</i><i><sub>TN</sub></i>).
     * Typical Value = 1.12.
     */
    val vtn: Double,

    /**
     * Regulator voltage reference (<i>V</i><i><sub>AL</sub></i>).
     * Typical Value = 5.5.
     */
    val _val: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscExcContIEEEDEC1A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscExcContIEEEDEC1A
extends
    Parseable[DiscExcContIEEEDEC1A]
{
    val sup = DiscontinuousExcitationControlDynamics.parse _
    val esc = parse_element (element ("""DiscExcContIEEEDEC1A.esc"""))_
    val kan = parse_element (element ("""DiscExcContIEEEDEC1A.kan"""))_
    val ketl = parse_element (element ("""DiscExcContIEEEDEC1A.ketl"""))_
    val tan = parse_element (element ("""DiscExcContIEEEDEC1A.tan"""))_
    val td = parse_element (element ("""DiscExcContIEEEDEC1A.td"""))_
    val tl1 = parse_element (element ("""DiscExcContIEEEDEC1A.tl1"""))_
    val tl2 = parse_element (element ("""DiscExcContIEEEDEC1A.tl2"""))_
    val tw5 = parse_element (element ("""DiscExcContIEEEDEC1A.tw5"""))_
    val vanmax = parse_element (element ("""DiscExcContIEEEDEC1A.vanmax"""))_
    val vomax = parse_element (element ("""DiscExcContIEEEDEC1A.vomax"""))_
    val vomin = parse_element (element ("""DiscExcContIEEEDEC1A.vomin"""))_
    val vsmax = parse_element (element ("""DiscExcContIEEEDEC1A.vsmax"""))_
    val vsmin = parse_element (element ("""DiscExcContIEEEDEC1A.vsmin"""))_
    val vtc = parse_element (element ("""DiscExcContIEEEDEC1A.vtc"""))_
    val vtlmt = parse_element (element ("""DiscExcContIEEEDEC1A.vtlmt"""))_
    val vtm = parse_element (element ("""DiscExcContIEEEDEC1A.vtm"""))_
    val vtn = parse_element (element ("""DiscExcContIEEEDEC1A.vtn"""))_
    val _val = parse_element (element ("""DiscExcContIEEEDEC1A.val"""))_
    def parse (context: Context): DiscExcContIEEEDEC1A =
    {
        DiscExcContIEEEDEC1A(
            sup (context),
            toDouble (esc (context), context),
            toDouble (kan (context), context),
            toDouble (ketl (context), context),
            toDouble (tan (context), context),
            toDouble (td (context), context),
            toDouble (tl1 (context), context),
            toDouble (tl2 (context), context),
            toDouble (tw5 (context), context),
            toDouble (vanmax (context), context),
            toDouble (vomax (context), context),
            toDouble (vomin (context), context),
            toDouble (vsmax (context), context),
            toDouble (vsmin (context), context),
            toDouble (vtc (context), context),
            toDouble (vtlmt (context), context),
            toDouble (vtm (context), context),
            toDouble (vtn (context), context),
            toDouble (_val (context), context)
        )
    }
}

/**
 * The class represents IEEE Type DEC2A model for the discontinuous excitation control.
 * This system provides transient excitation boosting via an open-loop control as initiated by a trigger signal generated remotely.
 */
case class DiscExcContIEEEDEC2A
(

    override val sup: DiscontinuousExcitationControlDynamics,

    /**
     * Discontinuous controller time constant (<i>T</i><i><sub>D1</sub></i>).
     */
    val td1: Double,

    /**
     * Discontinuous controller washout time constant (<i>T</i><i><sub>D2</sub></i>).
     */
    val td2: Double,

    /**
     * Limiter (<i>V</i><i><sub>DMAX</sub></i>).
     */
    val vdmax: Double,

    /**
     * Limiter (<i>V</i><i><sub>DMIN</sub></i>).
     */
    val vdmin: Double,

    /**
     * Discontinuous controller input reference (<i>V</i><i><sub>K</sub></i>).
     */
    val vk: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscExcContIEEEDEC2A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscExcContIEEEDEC2A
extends
    Parseable[DiscExcContIEEEDEC2A]
{
    val sup = DiscontinuousExcitationControlDynamics.parse _
    val td1 = parse_element (element ("""DiscExcContIEEEDEC2A.td1"""))_
    val td2 = parse_element (element ("""DiscExcContIEEEDEC2A.td2"""))_
    val vdmax = parse_element (element ("""DiscExcContIEEEDEC2A.vdmax"""))_
    val vdmin = parse_element (element ("""DiscExcContIEEEDEC2A.vdmin"""))_
    val vk = parse_element (element ("""DiscExcContIEEEDEC2A.vk"""))_
    def parse (context: Context): DiscExcContIEEEDEC2A =
    {
        DiscExcContIEEEDEC2A(
            sup (context),
            toDouble (td1 (context), context),
            toDouble (td2 (context), context),
            toDouble (vdmax (context), context),
            toDouble (vdmin (context), context),
            toDouble (vk (context), context)
        )
    }
}

/**
 * The class represents IEEE Type DEC3A model.
 * In some systems, the stabilizer output is disconnected from the regulator immediately following a severe fault to prevent the stabilizer from competing with action of voltage regulator during the first swing.
 */
case class DiscExcContIEEEDEC3A
(

    override val sup: DiscontinuousExcitationControlDynamics,

    /**
     * Reset time delay (<i>T</i><i><sub>DR</sub></i>).
     */
    val tdr: Double,

    /**
     * Terminal undervoltage comparison level (<i>V</i><i><sub>TMIN</sub></i>).
     */
    val vtmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscExcContIEEEDEC3A]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscExcContIEEEDEC3A
extends
    Parseable[DiscExcContIEEEDEC3A]
{
    val sup = DiscontinuousExcitationControlDynamics.parse _
    val tdr = parse_element (element ("""DiscExcContIEEEDEC3A.tdr"""))_
    val vtmin = parse_element (element ("""DiscExcContIEEEDEC3A.vtmin"""))_
    def parse (context: Context): DiscExcContIEEEDEC3A =
    {
        DiscExcContIEEEDEC3A(
            sup (context),
            toDouble (tdr (context), context),
            toDouble (vtmin (context), context)
        )
    }
}

/**
 * Discontinuous excitation control function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model</font>.
 */
case class DiscontinuousExcitationControlDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Excitation system model with which this discontinuous excitation control model is associated.
     */
    val ExcitationSystemDynamics: String,

    /**
     * Remote input signal used by this discontinuous excitation control system model.
     */
    val RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscontinuousExcitationControlDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscontinuousExcitationControlDynamics
extends
    Parseable[DiscontinuousExcitationControlDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""DiscontinuousExcitationControlDynamics.ExcitationSystemDynamics"""))_
    val RemoteInputSignal = parse_attribute (attribute ("""DiscontinuousExcitationControlDynamics.RemoteInputSignal"""))_
    def parse (context: Context): DiscontinuousExcitationControlDynamics =
    {
        DiscontinuousExcitationControlDynamics(
            sup (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

object _DiscontinuousExcitationControlDynamics
{
    def register: Unit =
    {
        DiscExcContIEEEDEC1A.register
        DiscExcContIEEEDEC2A.register
        DiscExcContIEEEDEC3A.register
        DiscontinuousExcitationControlDynamics.register
    }
}