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
 * IEEE type DEC1A discontinuous excitation control model that boosts generator excitation to a level higher than that demanded by the voltage regulator and stabilizer immediately following a system fault.
 *
 * Reference: IEEE 421.5-2005, 12.2.
 *
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param esc                                    Speed change reference (<i>E</i><i><sub>SC</sub></i>).
 *                                               Typical value = 0,0015.
 * @param kan                                    Discontinuous controller gain (<i>K</i><i><sub>AN</sub></i>).
 *                                               Typical value = 400.
 * @param ketl                                   Terminal voltage limiter gain (<i>K</i><i><sub>ETL</sub></i>).
 *                                               Typical value = 47.
 * @param tan                                    Discontinuous controller time constant (<i>T</i><i><sub>AN</sub></i>) (&gt;= 0).
 *                                               Typical value = 0,08.
 * @param td                                     Time constant (<i>T</i><i><sub>D</sub></i>) (&gt;= 0).
 *                                               Typical value = 0,03.
 * @param tl1                                    Time constant (<i>T</i><i><sub>L</sub></i><sub>1</sub>) (&gt;= 0).
 *                                               Typical value = 0,025.
 * @param tl2                                    Time constant (<i>T</i><i><sub>L</sub></i><sub>2</sub>) (&gt;= 0).
 *                                               Typical value = 1,25.
 * @param tw5                                    DEC washout time constant (<i>T</i><i><sub>W</sub></i><sub>5</sub>) (&gt;= 0).
 *                                               Typical value = 5.
 * @param val                                    Regulator voltage reference (<i>V</i><i><sub>AL</sub></i>).
 *                                               Typical value = 5,5.
 * @param vanmax                                 Limiter for Van (<i>V</i><i><sub>ANMAX</sub></i>).
 * @param vomax                                  Limiter (<i>V</i><i><sub>OMAX</sub></i>) (&gt; DiscExcContIEEEDEC1A.vomin).
 *                                               Typical value = 0,3.
 * @param vomin                                  Limiter (<i>V</i><i><sub>OMIN</sub></i>) (&lt; DiscExcContIEEEDEC1A.vomax).
 *                                               Typical value = 0,1.
 * @param vsmax                                  Limiter (<i>V</i><i><sub>SMAX</sub></i>)(&gt; DiscExcContIEEEDEC1A.vsmin).
 *                                               Typical value = 0,2.
 * @param vsmin                                  Limiter (<i>V</i><i><sub>SMIN</sub></i>) (&lt; DiscExcContIEEEDEC1A.vsmax).
 *                                               Typical value = -0,066.
 * @param vtc                                    Terminal voltage level reference (<i>V</i><i><sub>TC</sub></i>).
 *                                               Typical value = 0,95.
 * @param vtlmt                                  Voltage reference (<i>V</i><i><sub>TLMT</sub></i>).
 *                                               Typical value = 1,1.
 * @param vtm                                    Voltage limits (<i>V</i><i><sub>TM</sub></i>).
 *                                               Typical value = 1,13.
 * @param vtn                                    Voltage limits (<i>V</i><i><sub>TN</sub></i>).
 *                                               Typical value = 1,12.
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
 *            <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC1A
(
    DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = null,
    esc: Double = 0.0,
    kan: Double = 0.0,
    ketl: Double = 0.0,
    tan: Double = 0.0,
    td: Double = 0.0,
    tl1: Double = 0.0,
    tl2: Double = 0.0,
    tw5: Double = 0.0,
    `val`: Double = 0.0,
    vanmax: Double = 0.0,
    vomax: Double = 0.0,
    vomin: Double = 0.0,
    vsmax: Double = 0.0,
    vsmin: Double = 0.0,
    vtc: Double = 0.0,
    vtlmt: Double = 0.0,
    vtm: Double = 0.0,
    vtn: Double = 0.0
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
    override def sup: DiscontinuousExcitationControlDynamics = DiscontinuousExcitationControlDynamics

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC1A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DiscExcContIEEEDEC1A.fields(position), value)

        emitelem(0, esc)
        emitelem(1, kan)
        emitelem(2, ketl)
        emitelem(3, tan)
        emitelem(4, td)
        emitelem(5, tl1)
        emitelem(6, tl2)
        emitelem(7, tw5)
        emitelem(8, `val`)
        emitelem(9, vanmax)
        emitelem(10, vomax)
        emitelem(11, vomin)
        emitelem(12, vsmax)
        emitelem(13, vsmin)
        emitelem(14, vtc)
        emitelem(15, vtlmt)
        emitelem(16, vtm)
        emitelem(17, vtn)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC1A rdf:%s=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC1A>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DiscExcContIEEEDEC1A
    extends
        CIMParseable[DiscExcContIEEEDEC1A]
{
    override val fields: Array[String] = Array[String](
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
    val esc: Fielder = parse_element(element(cls, fields(0)))
    val kan: Fielder = parse_element(element(cls, fields(1)))
    val ketl: Fielder = parse_element(element(cls, fields(2)))
    val tan: Fielder = parse_element(element(cls, fields(3)))
    val td: Fielder = parse_element(element(cls, fields(4)))
    val tl1: Fielder = parse_element(element(cls, fields(5)))
    val tl2: Fielder = parse_element(element(cls, fields(6)))
    val tw5: Fielder = parse_element(element(cls, fields(7)))
    val `val`: Fielder = parse_element(element(cls, fields(8)))
    val vanmax: Fielder = parse_element(element(cls, fields(9)))
    val vomax: Fielder = parse_element(element(cls, fields(10)))
    val vomin: Fielder = parse_element(element(cls, fields(11)))
    val vsmax: Fielder = parse_element(element(cls, fields(12)))
    val vsmin: Fielder = parse_element(element(cls, fields(13)))
    val vtc: Fielder = parse_element(element(cls, fields(14)))
    val vtlmt: Fielder = parse_element(element(cls, fields(15)))
    val vtm: Fielder = parse_element(element(cls, fields(16)))
    val vtn: Fielder = parse_element(element(cls, fields(17)))

    def parse (context: CIMContext): DiscExcContIEEEDEC1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC1A(
            DiscontinuousExcitationControlDynamics.parse(context),
            toDouble(mask(esc(), 0)),
            toDouble(mask(kan(), 1)),
            toDouble(mask(ketl(), 2)),
            toDouble(mask(tan(), 3)),
            toDouble(mask(td(), 4)),
            toDouble(mask(tl1(), 5)),
            toDouble(mask(tl2(), 6)),
            toDouble(mask(tw5(), 7)),
            toDouble(mask(`val`(), 8)),
            toDouble(mask(vanmax(), 9)),
            toDouble(mask(vomax(), 10)),
            toDouble(mask(vomin(), 11)),
            toDouble(mask(vsmax(), 12)),
            toDouble(mask(vsmin(), 13)),
            toDouble(mask(vtc(), 14)),
            toDouble(mask(vtlmt(), 15)),
            toDouble(mask(vtm(), 16)),
            toDouble(mask(vtn(), 17))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiscExcContIEEEDEC1A] = DiscExcContIEEEDEC1ASerializer
}

object DiscExcContIEEEDEC1ASerializer extends CIMSerializer[DiscExcContIEEEDEC1A]
{
    def write (kryo: Kryo, output: Output, obj: DiscExcContIEEEDEC1A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.esc),
            () => output.writeDouble(obj.kan),
            () => output.writeDouble(obj.ketl),
            () => output.writeDouble(obj.tan),
            () => output.writeDouble(obj.td),
            () => output.writeDouble(obj.tl1),
            () => output.writeDouble(obj.tl2),
            () => output.writeDouble(obj.tw5),
            () => output.writeDouble(obj.`val`),
            () => output.writeDouble(obj.vanmax),
            () => output.writeDouble(obj.vomax),
            () => output.writeDouble(obj.vomin),
            () => output.writeDouble(obj.vsmax),
            () => output.writeDouble(obj.vsmin),
            () => output.writeDouble(obj.vtc),
            () => output.writeDouble(obj.vtlmt),
            () => output.writeDouble(obj.vtm),
            () => output.writeDouble(obj.vtn)
        )
        DiscontinuousExcitationControlDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiscExcContIEEEDEC1A]): DiscExcContIEEEDEC1A =
    {
        val parent = DiscontinuousExcitationControlDynamicsSerializer.read(kryo, input, classOf[DiscontinuousExcitationControlDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DiscExcContIEEEDEC1A(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readDouble else 0.0,
            if (isSet(15)) input.readDouble else 0.0,
            if (isSet(16)) input.readDouble else 0.0,
            if (isSet(17)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE type DEC2A model for discontinuous excitation control.
 *
 * This system provides transient excitation boosting via an open-loop control as initiated by a trigger signal generated remotely.
 * Reference: IEEE 421.5-2005 12.3.
 *
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param td1                                    Discontinuous controller time constant (<i>T</i><i><sub>D1</sub></i>) (&gt;= 0).
 * @param td2                                    Discontinuous controller washout time constant (<i>T</i><i><sub>D2</sub></i>) (&gt;= 0).
 * @param vdmax                                  Limiter (<i>V</i><i><sub>DMAX</sub></i>) (&gt; DiscExcContIEEEDEC2A.vdmin).
 * @param vdmin                                  Limiter (<i>V</i><i><sub>DMIN</sub></i>) (&lt; DiscExcContIEEEDEC2A.vdmax).
 * @param vk                                     Discontinuous controller input reference (<i>V</i><i><sub>K</sub></i>).
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
 *            <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC2A
(
    DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = null,
    td1: Double = 0.0,
    td2: Double = 0.0,
    vdmax: Double = 0.0,
    vdmin: Double = 0.0,
    vk: Double = 0.0
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
    override def sup: DiscontinuousExcitationControlDynamics = DiscontinuousExcitationControlDynamics

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC2A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DiscExcContIEEEDEC2A.fields(position), value)

        emitelem(0, td1)
        emitelem(1, td2)
        emitelem(2, vdmax)
        emitelem(3, vdmin)
        emitelem(4, vk)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC2A rdf:%s=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC2A>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DiscExcContIEEEDEC2A
    extends
        CIMParseable[DiscExcContIEEEDEC2A]
{
    override val fields: Array[String] = Array[String](
        "td1",
        "td2",
        "vdmax",
        "vdmin",
        "vk"
    )
    val td1: Fielder = parse_element(element(cls, fields(0)))
    val td2: Fielder = parse_element(element(cls, fields(1)))
    val vdmax: Fielder = parse_element(element(cls, fields(2)))
    val vdmin: Fielder = parse_element(element(cls, fields(3)))
    val vk: Fielder = parse_element(element(cls, fields(4)))

    def parse (context: CIMContext): DiscExcContIEEEDEC2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC2A(
            DiscontinuousExcitationControlDynamics.parse(context),
            toDouble(mask(td1(), 0)),
            toDouble(mask(td2(), 1)),
            toDouble(mask(vdmax(), 2)),
            toDouble(mask(vdmin(), 3)),
            toDouble(mask(vk(), 4))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiscExcContIEEEDEC2A] = DiscExcContIEEEDEC2ASerializer
}

object DiscExcContIEEEDEC2ASerializer extends CIMSerializer[DiscExcContIEEEDEC2A]
{
    def write (kryo: Kryo, output: Output, obj: DiscExcContIEEEDEC2A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.td1),
            () => output.writeDouble(obj.td2),
            () => output.writeDouble(obj.vdmax),
            () => output.writeDouble(obj.vdmin),
            () => output.writeDouble(obj.vk)
        )
        DiscontinuousExcitationControlDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiscExcContIEEEDEC2A]): DiscExcContIEEEDEC2A =
    {
        val parent = DiscontinuousExcitationControlDynamicsSerializer.read(kryo, input, classOf[DiscontinuousExcitationControlDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DiscExcContIEEEDEC2A(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE type DEC3A model.
 *
 * In some systems, the stabilizer output is disconnected from the regulator immediately following a severe fault to prevent the stabilizer from competing with action of voltage regulator during the first swing.
 * Reference: IEEE 421.5-2005 12.4.
 *
 * @param DiscontinuousExcitationControlDynamics [[ch.ninecode.model.DiscontinuousExcitationControlDynamics DiscontinuousExcitationControlDynamics]] Reference to the superclass object.
 * @param tdr                                    Reset time delay (<i>T</i><i><sub>DR</sub></i>) (&gt;= 0).
 * @param vtmin                                  Terminal undervoltage comparison level (<i>V</i><i><sub>TMIN</sub></i>).
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
 *            <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscExcContIEEEDEC3A
(
    DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = null,
    tdr: Double = 0.0,
    vtmin: Double = 0.0
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
    override def sup: DiscontinuousExcitationControlDynamics = DiscontinuousExcitationControlDynamics

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DiscExcContIEEEDEC3A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DiscExcContIEEEDEC3A.fields(position), value)

        emitelem(0, tdr)
        emitelem(1, vtmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DiscExcContIEEEDEC3A rdf:%s=\"%s\">\n%s\t</cim:DiscExcContIEEEDEC3A>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DiscExcContIEEEDEC3A
    extends
        CIMParseable[DiscExcContIEEEDEC3A]
{
    override val fields: Array[String] = Array[String](
        "tdr",
        "vtmin"
    )
    val tdr: Fielder = parse_element(element(cls, fields(0)))
    val vtmin: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DiscExcContIEEEDEC3A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscExcContIEEEDEC3A(
            DiscontinuousExcitationControlDynamics.parse(context),
            toDouble(mask(tdr(), 0)),
            toDouble(mask(vtmin(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiscExcContIEEEDEC3A] = DiscExcContIEEEDEC3ASerializer
}

object DiscExcContIEEEDEC3ASerializer extends CIMSerializer[DiscExcContIEEEDEC3A]
{
    def write (kryo: Kryo, output: Output, obj: DiscExcContIEEEDEC3A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.tdr),
            () => output.writeDouble(obj.vtmin)
        )
        DiscontinuousExcitationControlDynamicsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiscExcContIEEEDEC3A]): DiscExcContIEEEDEC3A =
    {
        val parent = DiscontinuousExcitationControlDynamicsSerializer.read(kryo, input, classOf[DiscontinuousExcitationControlDynamics])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DiscExcContIEEEDEC3A(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Discontinuous excitation control function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model</font>.
 *
 * @param DynamicsFunctionBlock    [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this discontinuous excitation control model is associated.
 * @param RemoteInputSignal        [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this discontinuous excitation control system model.
 * @group DiscontinuousExcitationControlDynamics
 * @groupname DiscontinuousExcitationControlDynamics Package DiscontinuousExcitationControlDynamics
 * @groupdesc DiscontinuousExcitationControlDynamics In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited. For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
 *            <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 */
final case class DiscontinuousExcitationControlDynamics
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DiscontinuousExcitationControlDynamics.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DiscontinuousExcitationControlDynamics.fields(position), value)

        emitattr(0, ExcitationSystemDynamics)
        emitattr(1, RemoteInputSignal)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DiscontinuousExcitationControlDynamics rdf:%s=\"%s\">\n%s\t</cim:DiscontinuousExcitationControlDynamics>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DiscontinuousExcitationControlDynamics
    extends
        CIMParseable[DiscontinuousExcitationControlDynamics]
{
    override val fields: Array[String] = Array[String](
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        CIMRelationship("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute(attribute(cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): DiscontinuousExcitationControlDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiscontinuousExcitationControlDynamics(
            DynamicsFunctionBlock.parse(context),
            mask(ExcitationSystemDynamics(), 0),
            mask(RemoteInputSignal(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiscontinuousExcitationControlDynamics] = DiscontinuousExcitationControlDynamicsSerializer
}

object DiscontinuousExcitationControlDynamicsSerializer extends CIMSerializer[DiscontinuousExcitationControlDynamics]
{
    def write (kryo: Kryo, output: Output, obj: DiscontinuousExcitationControlDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.ExcitationSystemDynamics),
            () => output.writeString(obj.RemoteInputSignal)
        )
        DynamicsFunctionBlockSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiscontinuousExcitationControlDynamics]): DiscontinuousExcitationControlDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read(kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DiscontinuousExcitationControlDynamics(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _DiscontinuousExcitationControlDynamics
{
    def register: List[CIMClassInfo] =
    {
        List(
            DiscExcContIEEEDEC1A.register,
            DiscExcContIEEEDEC2A.register,
            DiscExcContIEEEDEC3A.register,
            DiscontinuousExcitationControlDynamics.register
        )
    }
}