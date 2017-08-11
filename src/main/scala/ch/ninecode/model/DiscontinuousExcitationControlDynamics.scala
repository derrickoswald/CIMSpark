package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * <font colour="#0f0f0f">In some particular system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited.
 * For these situations, discontinuous excitation control signals may be employed to enhance stability following large transient disturbances.</font>
 */

/**
 * The class represents IEEE Type DEC1A discontinuous excitation control model that boosts generator excitation to a level higher than that demanded by the voltage regulator and stabilizer immediately following a system fault.
 * Reference: IEEE Standard 421.5-2005 Section 12.2.
 * @param sup Reference to the superclass object.
 * @param esc Speed change reference (<i>E</i><i><sub>SC</sub></i>).
 *        Typical Value = 0.0015.
 * @param kan Discontinuous controller gain (<i>K</i><i><sub>AN</sub></i>).
 *        Typical Value = 400.
 * @param ketl Terminal voltage limiter gain (<i>K</i><i><sub>ETL</sub></i>).
 *        Typical Value = 47.
 * @param tan Discontinuous controller time constant (<i>T</i><i><sub>AN</sub></i>).
 *        Typical Value = 0.08.
 * @param td Time constant (<i>T</i><i><sub>D</sub></i>).
 *        Typical Value = 0.03.
 * @param tl1 Time constant (<i>T</i><i><sub>L</sub></i><sub>1</sub>).
 *        Typical Value = 0.025.
 * @param tl2 Time constant (<i>T</i><i><sub>L</sub></i><sub>2</sub>).
 *        Typical Value = 1.25.
 * @param tw5 DEC washout time constant (<i>T</i><i><sub>W</sub></i><sub>5</sub>).
 *        Typical Value = 5.
 * @param vanmax Limiter for Van (<i>V</i><i><sub>ANMAX</sub></i>).
 * @param vomax Limiter (<i>V</i><i><sub>OMAX</sub></i>).
 *        Typical Value = 0.3.
 * @param vomin Limiter (<i>V</i><i><sub>OMIN</sub></i>).
 *        Typical Value = 0.1.
 * @param vsmax Limiter (<i>V</i><i><sub>SMAX</sub></i>).
 *        Typical Value = 0.2.
 * @param vsmin Limiter (<i>V</i><i><sub>SMIN</sub></i>).
 *        Typical Value = -0.066.
 * @param vtc Terminal voltage level reference (<i>V</i><i><sub>TC</sub></i>).
 *        Typical Value = 0.95.
 * @param vtlmt Voltage reference (<i>V</i><i><sub>TLMT</sub></i>).
 *        Typical Value = 1.1.
 * @param vtm Voltage limits (<i>V</i><i><sub>TM</sub></i>).
 *        Typical Value = 1.13.
 * @param vtn Voltage limits (<i>V</i><i><sub>TN</sub></i>).
 *        Typical Value = 1.12.
 * @param _val Regulator voltage reference (<i>V</i><i><sub>AL</sub></i>).
 *        Typical Value = 5.5.
 */
case class DiscExcContIEEEDEC1A
(
    override val sup: DiscontinuousExcitationControlDynamics,
    esc: Double,
    kan: Double,
    ketl: Double,
    tan: Double,
    td: Double,
    tl1: Double,
    tl2: Double,
    tw5: Double,
    vanmax: Double,
    vomax: Double,
    vomin: Double,
    vsmax: Double,
    vsmin: Double,
    vtc: Double,
    vtlmt: Double,
    vtm: Double,
    vtn: Double,
    _val: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC1A] }
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
        "\t\t<cim:DiscExcContIEEEDEC1A.esc>" + esc + "</cim:DiscExcContIEEEDEC1A.esc>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.kan>" + kan + "</cim:DiscExcContIEEEDEC1A.kan>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.ketl>" + ketl + "</cim:DiscExcContIEEEDEC1A.ketl>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.tan>" + tan + "</cim:DiscExcContIEEEDEC1A.tan>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.td>" + td + "</cim:DiscExcContIEEEDEC1A.td>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.tl1>" + tl1 + "</cim:DiscExcContIEEEDEC1A.tl1>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.tl2>" + tl2 + "</cim:DiscExcContIEEEDEC1A.tl2>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.tw5>" + tw5 + "</cim:DiscExcContIEEEDEC1A.tw5>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vanmax>" + vanmax + "</cim:DiscExcContIEEEDEC1A.vanmax>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vomax>" + vomax + "</cim:DiscExcContIEEEDEC1A.vomax>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vomin>" + vomin + "</cim:DiscExcContIEEEDEC1A.vomin>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vsmax>" + vsmax + "</cim:DiscExcContIEEEDEC1A.vsmax>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vsmin>" + vsmin + "</cim:DiscExcContIEEEDEC1A.vsmin>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vtc>" + vtc + "</cim:DiscExcContIEEEDEC1A.vtc>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vtlmt>" + vtlmt + "</cim:DiscExcContIEEEDEC1A.vtlmt>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vtm>" + vtm + "</cim:DiscExcContIEEEDEC1A.vtm>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.vtn>" + vtn + "</cim:DiscExcContIEEEDEC1A.vtn>\n" +
        "\t\t<cim:DiscExcContIEEEDEC1A.val>" + _val + "</cim:DiscExcContIEEEDEC1A.val>\n"
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC1A rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscExcContIEEEDEC1A>"
    }
}

object DiscExcContIEEEDEC1A
extends
    Parseable[DiscExcContIEEEDEC1A]
{
    val esc: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.esc"""))
    val kan: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.kan"""))
    val ketl: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.ketl"""))
    val tan: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.tan"""))
    val td: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.td"""))
    val tl1: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.tl1"""))
    val tl2: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.tl2"""))
    val tw5: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.tw5"""))
    val vanmax: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vanmax"""))
    val vomax: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vomax"""))
    val vomin: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vomin"""))
    val vsmax: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vsmax"""))
    val vsmin: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vsmin"""))
    val vtc: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vtc"""))
    val vtlmt: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vtlmt"""))
    val vtm: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vtm"""))
    val vtn: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.vtn"""))
    val _val: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC1A.val"""))
    def parse (context: Context): DiscExcContIEEEDEC1A =
    {
        DiscExcContIEEEDEC1A(
            DiscontinuousExcitationControlDynamics.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param td1 Discontinuous controller time constant (<i>T</i><i><sub>D1</sub></i>).
 * @param td2 Discontinuous controller washout time constant (<i>T</i><i><sub>D2</sub></i>).
 * @param vdmax Limiter (<i>V</i><i><sub>DMAX</sub></i>).
 * @param vdmin Limiter (<i>V</i><i><sub>DMIN</sub></i>).
 * @param vk Discontinuous controller input reference (<i>V</i><i><sub>K</sub></i>).
 */
case class DiscExcContIEEEDEC2A
(
    override val sup: DiscontinuousExcitationControlDynamics,
    td1: Double,
    td2: Double,
    vdmax: Double,
    vdmin: Double,
    vk: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC2A] }
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
        "\t\t<cim:DiscExcContIEEEDEC2A.td1>" + td1 + "</cim:DiscExcContIEEEDEC2A.td1>\n" +
        "\t\t<cim:DiscExcContIEEEDEC2A.td2>" + td2 + "</cim:DiscExcContIEEEDEC2A.td2>\n" +
        "\t\t<cim:DiscExcContIEEEDEC2A.vdmax>" + vdmax + "</cim:DiscExcContIEEEDEC2A.vdmax>\n" +
        "\t\t<cim:DiscExcContIEEEDEC2A.vdmin>" + vdmin + "</cim:DiscExcContIEEEDEC2A.vdmin>\n" +
        "\t\t<cim:DiscExcContIEEEDEC2A.vk>" + vk + "</cim:DiscExcContIEEEDEC2A.vk>\n"
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC2A rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscExcContIEEEDEC2A>"
    }
}

object DiscExcContIEEEDEC2A
extends
    Parseable[DiscExcContIEEEDEC2A]
{
    val td1: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC2A.td1"""))
    val td2: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC2A.td2"""))
    val vdmax: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC2A.vdmax"""))
    val vdmin: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC2A.vdmin"""))
    val vk: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC2A.vk"""))
    def parse (context: Context): DiscExcContIEEEDEC2A =
    {
        DiscExcContIEEEDEC2A(
            DiscontinuousExcitationControlDynamics.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param tdr Reset time delay (<i>T</i><i><sub>DR</sub></i>).
 * @param vtmin Terminal undervoltage comparison level (<i>V</i><i><sub>TMIN</sub></i>).
 */
case class DiscExcContIEEEDEC3A
(
    override val sup: DiscontinuousExcitationControlDynamics,
    tdr: Double,
    vtmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC3A] }
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
        "\t\t<cim:DiscExcContIEEEDEC3A.tdr>" + tdr + "</cim:DiscExcContIEEEDEC3A.tdr>\n" +
        "\t\t<cim:DiscExcContIEEEDEC3A.vtmin>" + vtmin + "</cim:DiscExcContIEEEDEC3A.vtmin>\n"
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC3A rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscExcContIEEEDEC3A>"
    }
}

object DiscExcContIEEEDEC3A
extends
    Parseable[DiscExcContIEEEDEC3A]
{
    val tdr: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC3A.tdr"""))
    val vtmin: (Context) => String = parse_element (element ("""DiscExcContIEEEDEC3A.vtmin"""))
    def parse (context: Context): DiscExcContIEEEDEC3A =
    {
        DiscExcContIEEEDEC3A(
            DiscontinuousExcitationControlDynamics.parse (context),
            toDouble (tdr (context), context),
            toDouble (vtmin (context), context)
        )
    }
}

/**
 * Discontinuous excitation control function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model</font>.
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this discontinuous excitation control model is associated.
 * @param RemoteInputSignal Remote input signal used by this discontinuous excitation control system model.
 */
case class DiscontinuousExcitationControlDynamics
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
    override def copy (): Row = { clone ().asInstanceOf[DiscontinuousExcitationControlDynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:DiscontinuousExcitationControlDynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:DiscontinuousExcitationControlDynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiscontinuousExcitationControlDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiscontinuousExcitationControlDynamics>"
    }
}

object DiscontinuousExcitationControlDynamics
extends
    Parseable[DiscontinuousExcitationControlDynamics]
{
    val ExcitationSystemDynamics: (Context) => String = parse_attribute (attribute ("""DiscontinuousExcitationControlDynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal: (Context) => String = parse_attribute (attribute ("""DiscontinuousExcitationControlDynamics.RemoteInputSignal"""))
    def parse (context: Context): DiscontinuousExcitationControlDynamics =
    {
        DiscontinuousExcitationControlDynamics(
            DynamicsFunctionBlock.parse (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

private[ninecode] object _DiscontinuousExcitationControlDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            DiscExcContIEEEDEC1A.register,
            DiscExcContIEEEDEC2A.register,
            DiscExcContIEEEDEC3A.register,
            DiscontinuousExcitationControlDynamics.register
        )
    }
}