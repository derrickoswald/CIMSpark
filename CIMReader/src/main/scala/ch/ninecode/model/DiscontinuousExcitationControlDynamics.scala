package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * IEEE type DEC1A discontinuous excitation control model that boosts generator excitation to a level higher than that demanded by the voltage regulator and stabilizer immediately following a system fault.
 *
 * Reference: IEEE 421.5-2005, 12.2.
 *
 * @param sup [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param esc Speed change reference (<i>E</i><i><sub>SC</sub></i>).
 *        Typical value = 0,0015.
 * @param kan Discontinuous controller gain (<i>K</i><i><sub>AN</sub></i>).
 *        Typical value = 400.
 * @param ketl Terminal voltage limiter gain (<i>K</i><i><sub>ETL</sub></i>).
 *        Typical value = 47.
 * @param tan Discontinuous controller time constant (<i>T</i><i><sub>AN</sub></i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param td Time constant (<i>T</i><i><sub>D</sub></i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param tl1 Time constant (<i>T</i><i><sub>L</sub></i><sub>1</sub>) (&gt;= 0).
 *        Typical value = 0,025.
 * @param tl2 Time constant (<i>T</i><i><sub>L</sub></i><sub>2</sub>) (&gt;= 0).
 *        Typical value = 1,25.
 * @param tw5 DEC washout time constant (<i>T</i><i><sub>W</sub></i><sub>5</sub>) (&gt;= 0).
 *        Typical value = 5.
 * @param val Regulator voltage reference (<i>V</i><i><sub>AL</sub></i>).
 *        Typical value = 5,5.
 * @param vanmax Limiter for Van (<i>V</i><i><sub>ANMAX</sub></i>).
 * @param vomax Limiter (<i>V</i><i><sub>OMAX</sub></i>) (&gt; DiscExcContIEEEDEC1A.vomin).
 *        Typical value = 0,3.
 * @param vomin Limiter (<i>V</i><i><sub>OMIN</sub></i>) (&lt; DiscExcContIEEEDEC1A.vomax).
 *        Typical value = 0,1.
 * @param vsmax Limiter (<i>V</i><i><sub>SMAX</sub></i>)(&gt; DiscExcContIEEEDEC1A.vsmin).
 *        Typical value = 0,2.
 * @param vsmin Limiter (<i>V</i><i><sub>SMIN</sub></i>) (&lt; DiscExcContIEEEDEC1A.vsmax).
 *        Typical value = -0,066.
 * @param vtc Terminal voltage level reference (<i>V</i><i><sub>TC</sub></i>).
 *        Typical value = 0,95.
 * @param vtlmt Voltage reference (<i>V</i><i><sub>TLMT</sub></i>).
 *        Typical value = 1,1.
 * @param vtm Voltage limits (<i>V</i><i><sub>TM</sub></i>).
 *        Typical value = 1,13.
 * @param vtn Voltage limits (<i>V</i><i><sub>TN</sub></i>).
 *        Typical value = 1,12.
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC1A
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
    `val`: Double,
    vanmax: Double,
    vomax: Double,
    vomin: Double,
    vsmax: Double,
    vsmin: Double,
    vtc: Double,
    vtlmt: Double,
    vtm: Double,
    vtn: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC1A] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC1A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscExcContIEEEDEC1A.fields (position), value)
        emitelem (0, esc)
        emitelem (1, kan)
        emitelem (2, ketl)
        emitelem (3, tan)
        emitelem (4, td)
        emitelem (5, tl1)
        emitelem (6, tl2)
        emitelem (7, tw5)
        emitelem (8, `val`)
        emitelem (9, vanmax)
        emitelem (10, vomax)
        emitelem (11, vomin)
        emitelem (12, vsmax)
        emitelem (13, vsmin)
        emitelem (14, vtc)
        emitelem (15, vtlmt)
        emitelem (16, vtm)
        emitelem (17, vtn)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC1A rdf:ID=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC1A>".format (id, export_fields)
    }
}

object DiscExcContIEEEDEC1A
extends
    Parseable[DiscExcContIEEEDEC1A]
{
    override val fields: Array[String] = Array[String] (
        "esc",
        "kan",
        "ketl",
        "tan",
        "td",
        "tl1",
        "tl2",
        "tw5",
        "val",
        "vanmax",
        "vomax",
        "vomin",
        "vsmax",
        "vsmin",
        "vtc",
        "vtlmt",
        "vtm",
        "vtn"
    )
    val esc: Fielder = parse_element (element (cls, fields(0)))
    val kan: Fielder = parse_element (element (cls, fields(1)))
    val ketl: Fielder = parse_element (element (cls, fields(2)))
    val tan: Fielder = parse_element (element (cls, fields(3)))
    val td: Fielder = parse_element (element (cls, fields(4)))
    val tl1: Fielder = parse_element (element (cls, fields(5)))
    val tl2: Fielder = parse_element (element (cls, fields(6)))
    val tw5: Fielder = parse_element (element (cls, fields(7)))
    val `val`: Fielder = parse_element (element (cls, fields(8)))
    val vanmax: Fielder = parse_element (element (cls, fields(9)))
    val vomax: Fielder = parse_element (element (cls, fields(10)))
    val vomin: Fielder = parse_element (element (cls, fields(11)))
    val vsmax: Fielder = parse_element (element (cls, fields(12)))
    val vsmin: Fielder = parse_element (element (cls, fields(13)))
    val vtc: Fielder = parse_element (element (cls, fields(14)))
    val vtlmt: Fielder = parse_element (element (cls, fields(15)))
    val vtm: Fielder = parse_element (element (cls, fields(16)))
    val vtn: Fielder = parse_element (element (cls, fields(17)))

    def parse (context: Context): DiscExcContIEEEDEC1A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC1A (
            DiscontinuousExcitationControlDynamics.parse (context),
            toDouble (mask (esc (), 0)),
            toDouble (mask (kan (), 1)),
            toDouble (mask (ketl (), 2)),
            toDouble (mask (tan (), 3)),
            toDouble (mask (td (), 4)),
            toDouble (mask (tl1 (), 5)),
            toDouble (mask (tl2 (), 6)),
            toDouble (mask (tw5 (), 7)),
            toDouble (mask (`val` (), 8)),
            toDouble (mask (vanmax (), 9)),
            toDouble (mask (vomax (), 10)),
            toDouble (mask (vomin (), 11)),
            toDouble (mask (vsmax (), 12)),
            toDouble (mask (vsmin (), 13)),
            toDouble (mask (vtc (), 14)),
            toDouble (mask (vtlmt (), 15)),
            toDouble (mask (vtm (), 16)),
            toDouble (mask (vtn (), 17))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE type DEC2A model for discontinuous excitation control.
 *
 * This system provides transient excitation boosting via an open-loop control as initiated by a trigger signal generated remotely.
 * Reference: IEEE 421.5-2005 12.3.
 *
 * @param sup [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param td1 Discontinuous controller time constant (<i>T</i><i><sub>D1</sub></i>) (&gt;= 0).
 * @param td2 Discontinuous controller washout time constant (<i>T</i><i><sub>D2</sub></i>) (&gt;= 0).
 * @param vdmax Limiter (<i>V</i><i><sub>DMAX</sub></i>) (&gt; DiscExcContIEEEDEC2A.vdmin).
 * @param vdmin Limiter (<i>V</i><i><sub>DMIN</sub></i>) (&lt; DiscExcContIEEEDEC2A.vdmax).
 * @param vk Discontinuous controller input reference (<i>V</i><i><sub>K</sub></i>).
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC2A
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC2A] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC2A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscExcContIEEEDEC2A.fields (position), value)
        emitelem (0, td1)
        emitelem (1, td2)
        emitelem (2, vdmax)
        emitelem (3, vdmin)
        emitelem (4, vk)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC2A rdf:ID=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC2A>".format (id, export_fields)
    }
}

object DiscExcContIEEEDEC2A
extends
    Parseable[DiscExcContIEEEDEC2A]
{
    override val fields: Array[String] = Array[String] (
        "td1",
        "td2",
        "vdmax",
        "vdmin",
        "vk"
    )
    val td1: Fielder = parse_element (element (cls, fields(0)))
    val td2: Fielder = parse_element (element (cls, fields(1)))
    val vdmax: Fielder = parse_element (element (cls, fields(2)))
    val vdmin: Fielder = parse_element (element (cls, fields(3)))
    val vk: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): DiscExcContIEEEDEC2A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC2A (
            DiscontinuousExcitationControlDynamics.parse (context),
            toDouble (mask (td1 (), 0)),
            toDouble (mask (td2 (), 1)),
            toDouble (mask (vdmax (), 2)),
            toDouble (mask (vdmin (), 3)),
            toDouble (mask (vk (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE type DEC3A model.
 *
 * In some systems, the stabilizer output is disconnected from the regulator immediately following a severe fault to prevent the stabilizer from competing with action of voltage regulator during the first swing.
 * Reference: IEEE 421.5-2005 12.4.
 *
 * @param sup [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param tdr Reset time delay (<i>T</i><i><sub>DR</sub></i>) (&gt;= 0).
 * @param vtmin Terminal undervoltage comparison level (<i>V</i><i><sub>TMIN</sub></i>).
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC3A
(
    override val sup: DiscontinuousExcitationControlDynamics,
    tdr: Double,
    vtmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { clone ().asInstanceOf[DiscExcContIEEEDEC3A] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC3A.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiscExcContIEEEDEC3A.fields (position), value)
        emitelem (0, tdr)
        emitelem (1, vtmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC3A rdf:ID=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC3A>".format (id, export_fields)
    }
}

object DiscExcContIEEEDEC3A
extends
    Parseable[DiscExcContIEEEDEC3A]
{
    override val fields: Array[String] = Array[String] (
        "tdr",
        "vtmin"
    )
    val tdr: Fielder = parse_element (element (cls, fields(0)))
    val vtmin: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DiscExcContIEEEDEC3A =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC3A (
            DiscontinuousExcitationControlDynamics.parse (context),
            toDouble (mask (tdr (), 0)),
            toDouble (mask (vtmin (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Discontinuous excitation control function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model</font>.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this discontinuous excitation control model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this discontinuous excitation control system model.
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscontinuousExcitationControlDynamics
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
    override def copy (): Row = { clone ().asInstanceOf[DiscontinuousExcitationControlDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiscontinuousExcitationControlDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiscontinuousExcitationControlDynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        emitattr (1, RemoteInputSignal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiscontinuousExcitationControlDynamics rdf:ID=\"%s\">\n%s\t</cim:DiscontinuousExcitationControlDynamics>".format (id, export_fields)
    }
}

object DiscontinuousExcitationControlDynamics
extends
    Parseable[DiscontinuousExcitationControlDynamics]
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

    def parse (context: Context): DiscontinuousExcitationControlDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiscontinuousExcitationControlDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
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