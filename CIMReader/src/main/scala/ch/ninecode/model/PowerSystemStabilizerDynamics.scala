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
 * Power system stabilizer function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock    [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this power system stabilizer model is associated.
 * @param RemoteInputSignal        [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this power system stabilizer model.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PowerSystemStabilizerDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null,
    RemoteInputSignal: List[String] = null
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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PowerSystemStabilizerDynamics.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PowerSystemStabilizerDynamics.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerSystemStabilizerDynamics.fields (position), x))

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
        CIMParseable[PowerSystemStabilizerDynamics]
{
    override val fields: Array[String] = Array [String](
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        CIMRelationship ("RemoteInputSignal", "RemoteInputSignal", "0..*", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RemoteInputSignal: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): PowerSystemStabilizerDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PowerSystemStabilizerDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            masks (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PowerSystemStabilizerDynamics] = PowerSystemStabilizerDynamicsSerializer
}

object PowerSystemStabilizerDynamicsSerializer extends CIMSerializer[PowerSystemStabilizerDynamics]
{
    def write (kryo: Kryo, output: Output, obj: PowerSystemStabilizerDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ExcitationSystemDynamics),
            () => writeList (obj.RemoteInputSignal, output)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerSystemStabilizerDynamics]): PowerSystemStabilizerDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf [DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerSystemStabilizerDynamics (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Italian PSS with three inputs (speed, frequency, power).
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param kf                            Frequency power input gain (<i>K</i><i><sub>F</sub></i>).
 *                                      Typical value = 5.
 * @param komega                        Shaft speed power input gain (<i>K</i><i><sub>omega</sub></i>).
 *                                      Typical value = 0.
 * @param kpe                           Electric power input gain (<i>K</i><i><sub>PE</sub></i>).
 *                                      Typical value = 0,3.
 * @param ks                            PSS gain (<i>Ks</i>).
 *                                      Typical value = 1.
 * @param pmin                          Minimum power PSS enabling (<i>Pmin</i>).
 *                                      Typical value = 0,25.
 * @param t10                           Lead/lag time constant (<i>T</i><i><sub>10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t5                            Washout (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 *                                      Typical value = 3,5.
 * @param t6                            Filter time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t7                            Lead/lag time constant (<i>T</i><i><sub>7</sub></i>) (&gt;= 0).
 *                                      If = 0, both blocks are bypassed.  Typical value = 0.
 * @param t8                            Lead/lag time constant (<i>T</i><i><sub>8</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t9                            Lead/lag time constant (<i>T</i><i><sub>9</sub></i>) (&gt;= 0).
 *                                      If = 0, both blocks are bypassed.  Typical value = 0.
 * @param tpe                           Electric power filter time constant (<i>T</i><i><sub>PE</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,05.
 * @param vadat                         <font color="#0f0f0f">Signal selector (<i>V</i><i><sub>ADAT</sub></i>).</font>
 *                                      <font color="#0f0f0f">true = closed (generator power is greater than <i>Pmin</i>)</font>
 *                                      <font color="#0f0f0f">false = open (<i>Pe</i> is smaller than <i>Pmin</i>).</font>
 *                                      <font color="#0f0f0f">Typical value = true.</font>
 * @param vsmn                          Stabilizer output maximum limit (<i>V</i><i><sub>SMN</sub></i>).
 *                                      Typical value = -0,06.
 * @param vsmx                          Stabilizer output minimum limit (<i>V</i><i><sub>SMX</sub></i>).
 *                                      Typical value = 0,06.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class Pss1
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    kf: Double = 0.0,
    komega: Double = 0.0,
    kpe: Double = 0.0,
    ks: Double = 0.0,
    pmin: Double = 0.0,
    t10: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    t9: Double = 0.0,
    tpe: Double = 0.0,
    vadat: Boolean = false,
    vsmn: Double = 0.0,
    vsmx: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss1.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss1.fields (position), value)

        emitelem (0, kf)
        emitelem (1, komega)
        emitelem (2, kpe)
        emitelem (3, ks)
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
        CIMParseable[Pss1]
{
    override val fields: Array[String] = Array [String](
        "kf",
        "komega",
        "kpe",
        "ks",
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
    val komega: Fielder = parse_element (element (cls, fields (1)))
    val kpe: Fielder = parse_element (element (cls, fields (2)))
    val ks: Fielder = parse_element (element (cls, fields (3)))
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

    def parse (context: CIMContext): Pss1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Pss1 (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (kf (), 0)),
            toDouble (mask (komega (), 1)),
            toDouble (mask (kpe (), 2)),
            toDouble (mask (ks (), 3)),
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

    def serializer: Serializer[Pss1] = Pss1Serializer
}

object Pss1Serializer extends CIMSerializer[Pss1]
{
    def write (kryo: Kryo, output: Output, obj: Pss1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kf),
            () => output.writeDouble (obj.komega),
            () => output.writeDouble (obj.kpe),
            () => output.writeDouble (obj.ks),
            () => output.writeDouble (obj.pmin),
            () => output.writeDouble (obj.t10),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.t7),
            () => output.writeDouble (obj.t8),
            () => output.writeDouble (obj.t9),
            () => output.writeDouble (obj.tpe),
            () => output.writeBoolean (obj.vadat),
            () => output.writeDouble (obj.vsmn),
            () => output.writeDouble (obj.vsmx)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pss1]): Pss1 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pss1 (
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
            if (isSet (12)) input.readBoolean else false,
            if (isSet (13)) input.readDouble else 0.0,
            if (isSet (14)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Single input power system stabilizer.
 *
 * It is a modified version in order to allow representation of various vendors' implementations on PSS type 1A.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1                            Notch filter parameter (<i>A</i><i><sub>1</sub></i>).
 * @param a2                            Notch filter parameter (<i>A</i><i><sub>2</sub></i>).
 * @param a3                            Notch filter parameter (<i>A</i><i><sub>3</sub></i>).
 * @param a4                            Notch filter parameter (<i>A</i><i><sub>4</sub></i>).
 * @param a5                            Notch filter parameter (<i>A</i><i><sub>5</sub></i>).
 * @param a6                            Notch filter parameter (<i>A</i><i><sub>6</sub></i>).
 * @param a7                            Notch filter parameter (<i>A</i><i><sub>7</sub></i>).
 * @param a8                            Notch filter parameter (<i>A</i><i><sub>8</sub></i>).
 * @param inputSignalType               Type of input signal (rotorAngularFrequencyDeviation, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, or busVoltageDerivative).
 * @param kd                            Selector (<i>Kd</i>).
 *                                      true = e<sup>-sTdelay</sup> used
 *                                      false = e<sup>-sTdelay</sup> not used.
 * @param ks                            Stabilizer gain (<i>K</i><i><sub>s</sub></i>).
 * @param t1                            Lead/lag time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 * @param t2                            Lead/lag time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 * @param t3                            Lead/lag time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 * @param t4                            Lead/lag time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 * @param t5                            Washout time constant (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 * @param t6                            Transducer time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 * @param tdelay                        Time constant (<i>Tdelay</i>) (&gt;= 0).
 * @param vcl                           Stabilizer input cutoff threshold (<i>Vcl</i>).
 * @param vcu                           Stabilizer input cutoff threshold (<i>Vcu</i>).
 * @param vrmax                         Maximum stabilizer output (<i>Vrmax</i>) (&gt; Pss1A.vrmin).
 * @param vrmin                         Minimum stabilizer output (<i>Vrmin</i>) (&lt; Pss1A.vrmax).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class Pss1A
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    a1: Double = 0.0,
    a2: Double = 0.0,
    a3: Double = 0.0,
    a4: Double = 0.0,
    a5: Double = 0.0,
    a6: Double = 0.0,
    a7: Double = 0.0,
    a8: Double = 0.0,
    inputSignalType: String = null,
    kd: Boolean = false,
    ks: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    tdelay: Double = 0.0,
    vcl: Double = 0.0,
    vcu: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Pss1A]
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

    def parse (context: CIMContext): Pss1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[Pss1A] = Pss1ASerializer
}

object Pss1ASerializer extends CIMSerializer[Pss1A]
{
    def write (kryo: Kryo, output: Output, obj: Pss1A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a1),
            () => output.writeDouble (obj.a2),
            () => output.writeDouble (obj.a3),
            () => output.writeDouble (obj.a4),
            () => output.writeDouble (obj.a5),
            () => output.writeDouble (obj.a6),
            () => output.writeDouble (obj.a7),
            () => output.writeDouble (obj.a8),
            () => output.writeString (obj.inputSignalType),
            () => output.writeBoolean (obj.kd),
            () => output.writeDouble (obj.ks),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.tdelay),
            () => output.writeDouble (obj.vcl),
            () => output.writeDouble (obj.vcu),
            () => output.writeDouble (obj.vrmax),
            () => output.writeDouble (obj.vrmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pss1A]): Pss1A =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pss1A (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readBoolean else false,
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
            if (isSet (21)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Modified IEEE PSS2B.
 *
 * Extra lead/lag (or rate) block added at end (up to 4 lead/lags total).
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a                             Numerator constant (<i>a</i>).
 *                                      Typical value = 1.
 * @param ks1                           Stabilizer gain (<i>Ks1</i>).
 *                                      Typical value = 12.
 * @param ks2                           Gain on signal #2 (<i>Ks2</i>).
 *                                      Typical value = 0,2.
 * @param ks3                           Gain on signal #2 input before ramp-tracking filter (<i>Ks3</i>).
 *                                      Typical value = 1.
 * @param ks4                           Gain on signal #2 input after ramp-tracking filter (<i>Ks4</i>).
 *                                      Typical value = 1.
 * @param m                             Denominator order of ramp tracking filter (<i>m</i>).
 *                                      Typical value = 5.
 * @param n                             Order of ramp tracking filter (<i>n</i>).
 *                                      Typical value = 1.
 * @param t1                            Lead/lag time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,12.
 * @param t10                           Lead/lag time constant (<i>T</i><i><sub>10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t11                           Lead/lag time constant (<i>T</i><i><sub>11</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t2                            Lead/lag time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,02.
 * @param t3                            Lead/lag time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t4                            Lead/lag time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,02.
 * @param t6                            Time constant on signal #1 (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t7                            Time constant on signal #2 (<i>T</i><i><sub>7</sub></i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param t8                            Lead of ramp tracking filter (<i>T</i><i><sub>8</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param t9                            Lag of ramp tracking filter (<i>T</i><i><sub>9</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,1.
 * @param ta                            Lead constant (<i>T</i><i><sub>a</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tb                            Lag time constant (<i>T</i><i><sub>b</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tw1                           First washout on signal #1 (<i>T</i><i><sub>w1</sub></i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw2                           Second washout on signal #1 (<i>T</i><i><sub>w2</sub></i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw3                           First washout on signal #2 (<i>T</i><i><sub>w3</sub></i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw4                           Second washout on signal #2 (<i>T</i><i><sub>w4</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param vsi1max                       Input signal #1 maximum limit (<i>Vsi1max</i>) (&gt; Pss2B.vsi1min).
 *                                      Typical value = 2.
 * @param vsi1min                       Input signal #1 minimum limit (<i>Vsi1min</i>) (&lt; Pss2B.vsi1max).
 *                                      Typical value = -2.
 * @param vsi2max                       Input signal #2 maximum limit (<i>Vsi2max</i>) (&gt; Pss2B.vsi2min).
 *                                      Typical value = 2.
 * @param vsi2min                       Input signal #2 minimum limit (<i>Vsi2min</i>) (&lt; Pss2B.vsi2max).
 *                                      Typical value = -2.
 * @param vstmax                        Stabilizer output maximum limit (<i>Vstmax</i>) (&gt; Pss2B.vstmin).
 *                                      Typical value = 0,1.
 * @param vstmin                        Stabilizer output minimum limit (<i>Vstmin</i>) (&lt; Pss2B.vstmax).
 *                                      Typical value = -0,1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class Pss2B
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    a: Double = 0.0,
    ks1: Double = 0.0,
    ks2: Double = 0.0,
    ks3: Double = 0.0,
    ks4: Double = 0.0,
    m: Int = 0,
    n: Int = 0,
    t1: Double = 0.0,
    t10: Double = 0.0,
    t11: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    t9: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tw1: Double = 0.0,
    tw2: Double = 0.0,
    tw3: Double = 0.0,
    tw4: Double = 0.0,
    vsi1max: Double = 0.0,
    vsi1min: Double = 0.0,
    vsi2max: Double = 0.0,
    vsi2min: Double = 0.0,
    vstmax: Double = 0.0,
    vstmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Pss2B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Pss2B.fields (position), value)

        emitelem (0, a)
        emitelem (1, ks1)
        emitelem (2, ks2)
        emitelem (3, ks3)
        emitelem (4, ks4)
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
        emitelem (17, ta)
        emitelem (18, tb)
        emitelem (19, tw1)
        emitelem (20, tw2)
        emitelem (21, tw3)
        emitelem (22, tw4)
        emitelem (23, vsi1max)
        emitelem (24, vsi1min)
        emitelem (25, vsi2max)
        emitelem (26, vsi2min)
        emitelem (27, vstmax)
        emitelem (28, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Pss2B rdf:ID=\"%s\">\n%s\t</cim:Pss2B>".format (id, export_fields)
    }
}

object Pss2B
    extends
        CIMParseable[Pss2B]
{
    override val fields: Array[String] = Array [String](
        "a",
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
    val ks1: Fielder = parse_element (element (cls, fields (1)))
    val ks2: Fielder = parse_element (element (cls, fields (2)))
    val ks3: Fielder = parse_element (element (cls, fields (3)))
    val ks4: Fielder = parse_element (element (cls, fields (4)))
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
    val ta: Fielder = parse_element (element (cls, fields (17)))
    val tb: Fielder = parse_element (element (cls, fields (18)))
    val tw1: Fielder = parse_element (element (cls, fields (19)))
    val tw2: Fielder = parse_element (element (cls, fields (20)))
    val tw3: Fielder = parse_element (element (cls, fields (21)))
    val tw4: Fielder = parse_element (element (cls, fields (22)))
    val vsi1max: Fielder = parse_element (element (cls, fields (23)))
    val vsi1min: Fielder = parse_element (element (cls, fields (24)))
    val vsi2max: Fielder = parse_element (element (cls, fields (25)))
    val vsi2min: Fielder = parse_element (element (cls, fields (26)))
    val vstmax: Fielder = parse_element (element (cls, fields (27)))
    val vstmin: Fielder = parse_element (element (cls, fields (28)))

    def parse (context: CIMContext): Pss2B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Pss2B (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (ks1 (), 1)),
            toDouble (mask (ks2 (), 2)),
            toDouble (mask (ks3 (), 3)),
            toDouble (mask (ks4 (), 4)),
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
            toDouble (mask (ta (), 17)),
            toDouble (mask (tb (), 18)),
            toDouble (mask (tw1 (), 19)),
            toDouble (mask (tw2 (), 20)),
            toDouble (mask (tw3 (), 21)),
            toDouble (mask (tw4 (), 22)),
            toDouble (mask (vsi1max (), 23)),
            toDouble (mask (vsi1min (), 24)),
            toDouble (mask (vsi2max (), 25)),
            toDouble (mask (vsi2min (), 26)),
            toDouble (mask (vstmax (), 27)),
            toDouble (mask (vstmin (), 28))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Pss2B] = Pss2BSerializer
}

object Pss2BSerializer extends CIMSerializer[Pss2B]
{
    def write (kryo: Kryo, output: Output, obj: Pss2B): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a),
            () => output.writeDouble (obj.ks1),
            () => output.writeDouble (obj.ks2),
            () => output.writeDouble (obj.ks3),
            () => output.writeDouble (obj.ks4),
            () => output.writeInt (obj.m),
            () => output.writeInt (obj.n),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t10),
            () => output.writeDouble (obj.t11),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.t7),
            () => output.writeDouble (obj.t8),
            () => output.writeDouble (obj.t9),
            () => output.writeDouble (obj.ta),
            () => output.writeDouble (obj.tb),
            () => output.writeDouble (obj.tw1),
            () => output.writeDouble (obj.tw2),
            () => output.writeDouble (obj.tw3),
            () => output.writeDouble (obj.tw4),
            () => output.writeDouble (obj.vsi1max),
            () => output.writeDouble (obj.vsi1min),
            () => output.writeDouble (obj.vsi2max),
            () => output.writeDouble (obj.vsi2min),
            () => output.writeDouble (obj.vstmax),
            () => output.writeDouble (obj.vstmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pss2B]): Pss2B =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pss2B (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readInt else 0,
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
            if (isSet (28)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * PTI microprocessor-based stabilizer type 1.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type              Type of input signal #1 (rotorAngularFrequencyDeviation, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, or busVoltageDerivative - shall be different than Pss2ST.inputSignal2Type).
 *                                      Typical value = rotorAngularFrequencyDeviation.
 * @param inputSignal2Type              Type of input signal #2 (rotorAngularFrequencyDeviation, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, or busVoltageDerivative - shall be different than Pss2ST.inputSignal1Type).
 *                                      Typical value = busVoltageDerivative.
 * @param k1                            Gain (<i>K</i><i><sub>1</sub></i>).
 * @param k2                            Gain (<i>K</i><i><sub>2</sub></i>).
 * @param lsmax                         Limiter (<i>L</i><i><sub>SMAX</sub></i>) (&gt; Pss2ST.lsmin).
 * @param lsmin                         Limiter (<i>L</i><i><sub>SMIN</sub></i>) (&lt; Pss2ST.lsmax).
 * @param t1                            Time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 * @param t10                           Time constant (<i>T</i><i><sub>10</sub></i>) (&gt;= 0).
 * @param t2                            Time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 * @param t3                            Time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 * @param t4                            Time constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 * @param t5                            Time constant (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 * @param t6                            Time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 * @param t7                            Time constant (<i>T</i><i><sub>7</sub></i>) (&gt;= 0).
 * @param t8                            Time constant (<i>T</i><i><sub>8</sub></i>) (&gt;= 0).
 * @param t9                            Time constant (<i>T</i><i><sub>9</sub></i>) (&gt;= 0).
 * @param vcl                           Cutoff limiter (<i>V</i><i><sub>CL</sub></i>).
 * @param vcu                           Cutoff limiter (<i>V</i><i><sub>CU</sub></i>).
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class Pss2ST
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    inputSignal1Type: String = null,
    inputSignal2Type: String = null,
    k1: Double = 0.0,
    k2: Double = 0.0,
    lsmax: Double = 0.0,
    lsmin: Double = 0.0,
    t1: Double = 0.0,
    t10: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    t9: Double = 0.0,
    vcl: Double = 0.0,
    vcu: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[Pss2ST]
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

    def parse (context: CIMContext): Pss2ST =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[Pss2ST] = Pss2STSerializer
}

object Pss2STSerializer extends CIMSerializer[Pss2ST]
{
    def write (kryo: Kryo, output: Output, obj: Pss2ST): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.inputSignal1Type),
            () => output.writeString (obj.inputSignal2Type),
            () => output.writeDouble (obj.k1),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.lsmax),
            () => output.writeDouble (obj.lsmin),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t10),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.t7),
            () => output.writeDouble (obj.t8),
            () => output.writeDouble (obj.t9),
            () => output.writeDouble (obj.vcl),
            () => output.writeDouble (obj.vcu)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pss2ST]): Pss2ST =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pss2ST (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
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
            if (isSet (17)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Detailed Italian PSS.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param ctw2                          Selector for second washout enabling (<i>C</i><i><sub>TW2</sub></i>).
 *                                      true = second washout filter is bypassed
 *                                      false = second washout filter in use.
 *                                      Typical value = true.
 * @param deadband                      Stabilizer output deadband (<i>DEADBAND</i>).
 *                                      Typical value = 0.
 * @param isfreq                        Selector for frequency/shaft speed input (<i>isFreq</i>).
 *                                      true = speed (same meaning as InputSignaKind.rotorSpeed)
 *                                      false = frequency (same meaning as InputSignalKind.busFrequency).
 *                                      Typical value = true (same meaning as InputSignalKind.rotorSpeed).
 * @param kf                            Frequency/shaft speed input gain (<i>K</i><i><sub>F</sub></i>).
 *                                      Typical value = 5.
 * @param kpe                           Electric power input gain (<i>K</i><i><sub>PE</sub></i>).
 *                                      Typical value = 0,3.
 * @param kpss                          PSS gain (<i>K</i><i><sub>PSS</sub></i>).
 *                                      Typical value = 1.
 * @param pmin                          Minimum power PSS enabling (<i>Pmin</i>).
 *                                      Typical value = 0,25.
 * @param tl1                           Lead/lag time constant (<i>T</i><i><sub>L1</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl2                           Lead/lag time constant (<i>T</i><i><sub>L2</sub></i>) (&gt;= 0).
 *                                      If = 0, both blocks are bypassed.  Typical value = 0.
 * @param tl3                           Lead/lag time constant (<i>T</i><i><sub>L3</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl4                           Lead/lag time constant (T<sub>L4</sub>) (&gt;= 0).
 *                                      If = 0, both blocks are bypassed.  Typical value = 0.
 * @param tpe                           Electric power filter time constant (<i>T</i><i><sub>PE</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,05.
 * @param tw1                           First washout (<i>T</i><i><sub>W1</sub></i>) (&gt;= 0).
 *                                      Typical value = 3,5.
 * @param tw2                           Second washout (<i>T</i><i><sub>W2</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param vadat                         <font color="#0f0f0f">Signal selector (<i>V</i><i><sub>adAtt</sub></i>).</font>
 *                                      <font color="#0f0f0f">true = closed (generator power is greater than <i>Pmin</i>)</font>
 *                                      <font color="#0f0f0f">false = open (<i>Pe</i> is smaller than <i>Pmin</i>).</font>
 *                                      <font color="#0f0f0f">Typical value = true.</font>
 * @param vsmn                          Stabilizer output maximum limit (<i>V</i><i><sub>SMN</sub></i>).
 *                                      Typical value = -0,1.
 * @param vsmx                          Stabilizer output minimum limit (<i>V</i><i><sub>SMX</sub></i>).
 *                                      Typical value = 0,1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class Pss5
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    ctw2: Boolean = false,
    deadband: Double = 0.0,
    isfreq: Boolean = false,
    kf: Double = 0.0,
    kpe: Double = 0.0,
    kpss: Double = 0.0,
    pmin: Double = 0.0,
    tl1: Double = 0.0,
    tl2: Double = 0.0,
    tl3: Double = 0.0,
    tl4: Double = 0.0,
    tpe: Double = 0.0,
    tw1: Double = 0.0,
    tw2: Double = 0.0,
    vadat: Boolean = false,
    vsmn: Double = 0.0,
    vsmx: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        emitelem (6, pmin)
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
        CIMParseable[Pss5]
{
    override val fields: Array[String] = Array [String](
        "ctw2",
        "deadband",
        "isfreq",
        "kf",
        "kpe",
        "kpss",
        "pmin",
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
    val pmin: Fielder = parse_element (element (cls, fields (6)))
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

    def parse (context: CIMContext): Pss5 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Pss5 (
            PowerSystemStabilizerDynamics.parse (context),
            toBoolean (mask (ctw2 (), 0)),
            toDouble (mask (deadband (), 1)),
            toBoolean (mask (isfreq (), 2)),
            toDouble (mask (kf (), 3)),
            toDouble (mask (kpe (), 4)),
            toDouble (mask (kpss (), 5)),
            toDouble (mask (pmin (), 6)),
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

    def serializer: Serializer[Pss5] = Pss5Serializer
}

object Pss5Serializer extends CIMSerializer[Pss5]
{
    def write (kryo: Kryo, output: Output, obj: Pss5): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.ctw2),
            () => output.writeDouble (obj.deadband),
            () => output.writeBoolean (obj.isfreq),
            () => output.writeDouble (obj.kf),
            () => output.writeDouble (obj.kpe),
            () => output.writeDouble (obj.kpss),
            () => output.writeDouble (obj.pmin),
            () => output.writeDouble (obj.tl1),
            () => output.writeDouble (obj.tl2),
            () => output.writeDouble (obj.tl3),
            () => output.writeDouble (obj.tl4),
            () => output.writeDouble (obj.tpe),
            () => output.writeDouble (obj.tw1),
            () => output.writeDouble (obj.tw2),
            () => output.writeBoolean (obj.vadat),
            () => output.writeDouble (obj.vsmn),
            () => output.writeDouble (obj.vsmx)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Pss5]): Pss5 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Pss5 (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readBoolean else false,
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
            if (isSet (14)) input.readBoolean else false,
            if (isSet (15)) input.readDouble else 0.0,
            if (isSet (16)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Power system stabilizer typically associated with ExcELIN2 (though PssIEEE2B or Pss2B can also be used).
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param apss                          Coefficient (<i>a_PSS</i>).
 *                                      Typical value = 0,1.
 * @param ks1                           Gain (<i>Ks1</i>).
 *                                      Typical value = 1.
 * @param ks2                           Gain (<i>Ks2</i>).
 *                                      Typical value = 0,1.
 * @param ppss                          Coefficient (<i>p_PSS</i>) (&gt;= 0 and &lt;= 4).
 *                                      Typical value = 0,1.
 * @param psslim                        PSS limiter (<i>psslim</i>).
 *                                      Typical value = 0,1.
 * @param ts1                           Time constant (<i>Ts1</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ts2                           Time constant (<i>Ts2</i>) (&gt;= 0).
 *                                      Typical value = 1.
 * @param ts3                           Time constant (<i>Ts3</i>) (&gt;= 0).
 *                                      Typical value = 1.
 * @param ts4                           Time constant (<i>Ts4</i>) (&gt;= 0).
 *                                      Typical value = 0,1.
 * @param ts5                           Time constant (<i>Ts5</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ts6                           Time constant (<i>Ts6</i>) (&gt;= 0).
 *                                      Typical value = 1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssELIN2
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    apss: Double = 0.0,
    ks1: Double = 0.0,
    ks2: Double = 0.0,
    ppss: Double = 0.0,
    psslim: Double = 0.0,
    ts1: Double = 0.0,
    ts2: Double = 0.0,
    ts3: Double = 0.0,
    ts4: Double = 0.0,
    ts5: Double = 0.0,
    ts6: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssELIN2]
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

    def parse (context: CIMContext): PssELIN2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssELIN2] = PssELIN2Serializer
}

object PssELIN2Serializer extends CIMSerializer[PssELIN2]
{
    def write (kryo: Kryo, output: Output, obj: PssELIN2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.apss),
            () => output.writeDouble (obj.ks1),
            () => output.writeDouble (obj.ks2),
            () => output.writeDouble (obj.ppss),
            () => output.writeDouble (obj.psslim),
            () => output.writeDouble (obj.ts1),
            () => output.writeDouble (obj.ts2),
            () => output.writeDouble (obj.ts3),
            () => output.writeDouble (obj.ts4),
            () => output.writeDouble (obj.ts5),
            () => output.writeDouble (obj.ts6)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssELIN2]): PssELIN2 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssELIN2 (
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
            if (isSet (10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE 421.5-2005 type PSS1A power system stabilizer model.
 *
 * PSS1A is the generalized form of a PSS with a single input signal.
 * Reference: IEEE 1A 421.5-2005, 8.1.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1                            PSS signal conditioning frequency filter constant (<i>A1</i>).
 *                                      Typical value = 0,061.
 * @param a2                            PSS signal conditioning frequency filter constant (<i>A2</i>).
 *                                      Typical value = 0,0017.
 * @param inputSignalType               Type of input signal (rotorAngularFrequencyDeviation, generatorElectricalPower, or busFrequencyDeviation).
 *                                      Typical value = rotorAngularFrequencyDeviation.
 * @param ks                            Stabilizer gain (<i>Ks</i>).
 *                                      Typical value = 5.
 * @param t1                            Lead/lag time constant (<i>T1</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t2                            Lead/lag time constant (<i>T2</i>) (&gt;= 0).
 *                                      Typical value = 0,03.
 * @param t3                            Lead/lag time constant (<i>T3</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t4                            Lead/lag time constant (<i>T4</i>) (&gt;= 0).
 *                                      Typical value = 0,03.
 * @param t5                            Washout time constant (<i>T5</i>) (&gt;= 0).
 *                                      Typical value = 10.
 * @param t6                            Transducer time constant (<i>T6</i>) (&gt;= 0).
 *                                      Typical value = 0,01.
 * @param vrmax                         Maximum stabilizer output (<i>Vrmax</i>) (&gt; PssIEEE1A.vrmin).
 *                                      Typical value = 0,05.
 * @param vrmin                         Minimum stabilizer output (<i>Vrmin</i>) (&lt; PssIEEE1A.vrmax).
 *                                      Typical value = -0,05.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssIEEE1A
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    a1: Double = 0.0,
    a2: Double = 0.0,
    inputSignalType: String = null,
    ks: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    vrmax: Double = 0.0,
    vrmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssIEEE1A]
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

    def parse (context: CIMContext): PssIEEE1A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssIEEE1A] = PssIEEE1ASerializer
}

object PssIEEE1ASerializer extends CIMSerializer[PssIEEE1A]
{
    def write (kryo: Kryo, output: Output, obj: PssIEEE1A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a1),
            () => output.writeDouble (obj.a2),
            () => output.writeString (obj.inputSignalType),
            () => output.writeDouble (obj.ks),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.vrmax),
            () => output.writeDouble (obj.vrmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssIEEE1A]): PssIEEE1A =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssIEEE1A (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE 421.5-2005 type PSS2B power system stabilizer model.
 *
 * This stabilizer model is designed to represent a variety of dual-input stabilizers, which normally use combinations of power and speed or frequency to derive the stabilizing signal.
 * Reference: IEEE 2B 421.5-2005, 8.2.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type              Type of input signal #1 (rotorAngularFrequencyDeviation, busFrequencyDeviation).
 *                                      Typical value = rotorAngularFrequencyDeviation.
 * @param inputSignal2Type              Type of input signal #2 (generatorElectricalPower).
 *                                      Typical value = generatorElectricalPower.
 * @param ks1                           Stabilizer gain (<i>Ks1</i>).
 *                                      Typical value = 12.
 * @param ks2                           Gain on signal #2 (<i>Ks2</i>).
 *                                      Typical value = 0,2.
 * @param ks3                           Gain on signal #2 input before ramp-tracking filter (<i>Ks3</i>).
 *                                      Typical value = 1.
 * @param m                             Denominator order of ramp tracking filter (<i>M</i>).
 *                                      Typical value = 5.
 * @param n                             Order of ramp tracking filter (<i>N</i>).
 *                                      Typical value = 1.
 * @param t1                            Lead/lag time constant (<i>T1</i>) (&gt;= 0).
 *                                      Typical value = 0,12.
 * @param t10                           Lead/lag time constant (<i>T10</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t11                           Lead/lag time constant (<i>T11</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t2                            Lead/lag time constant (<i>T2</i>) (&gt;= 0).
 *                                      Typical value = 0,02.
 * @param t3                            Lead/lag time constant (<i>T3</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t4                            Lead/lag time constant (<i>T4</i>) (&gt;= 0).
 *                                      Typical value = 0,02.
 * @param t6                            Time constant on signal #1 (<i>T6</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t7                            Time constant on signal #2 (<i>T7</i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param t8                            Lead of ramp tracking filter (<i>T8</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param t9                            Lag of ramp tracking filter (<i>T9</i>) (&gt;= 0).
 *                                      Typical value = 0,1.
 * @param tw1                           First washout on signal #1 (<i>Tw1</i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw2                           Second washout on signal #1 (<i>Tw2</i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw3                           First washout on signal #2 (<i>Tw3</i>) (&gt;= 0).
 *                                      Typical value = 2.
 * @param tw4                           Second washout on signal #2 (<i>Tw4</i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param vsi1max                       Input signal #1 maximum limit (<i>Vsi1max</i>) (&gt; PssIEEE2B.vsi1min).
 *                                      Typical value = 2.
 * @param vsi1min                       Input signal #1 minimum limit (<i>Vsi1min</i>) (&lt; PssIEEE2B.vsi1max).
 *                                      Typical value = -2.
 * @param vsi2max                       Input signal #2 maximum limit (<i>Vsi2max</i>) (&gt; PssIEEE2B.vsi2min).
 *                                      Typical value = 2.
 * @param vsi2min                       Input signal #2 minimum limit (<i>Vsi2min</i>) (&lt; PssIEEE2B.vsi2max).
 *                                      Typical value = -2.
 * @param vstmax                        Stabilizer output maximum limit (<i>Vstmax</i>) (&gt; PssIEEE2B.vstmin).
 *                                      Typical value = 0,1.
 * @param vstmin                        Stabilizer output minimum limit (<i>Vstmin</i>) (&lt; PssIEEE2B.vstmax).
 *                                      Typical value = -0,1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssIEEE2B
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    inputSignal1Type: String = null,
    inputSignal2Type: String = null,
    ks1: Double = 0.0,
    ks2: Double = 0.0,
    ks3: Double = 0.0,
    m: Int = 0,
    n: Int = 0,
    t1: Double = 0.0,
    t10: Double = 0.0,
    t11: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    t9: Double = 0.0,
    tw1: Double = 0.0,
    tw2: Double = 0.0,
    tw3: Double = 0.0,
    tw4: Double = 0.0,
    vsi1max: Double = 0.0,
    vsi1min: Double = 0.0,
    vsi2max: Double = 0.0,
    vsi2min: Double = 0.0,
    vstmax: Double = 0.0,
    vstmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssIEEE2B]
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

    def parse (context: CIMContext): PssIEEE2B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssIEEE2B] = PssIEEE2BSerializer
}

object PssIEEE2BSerializer extends CIMSerializer[PssIEEE2B]
{
    def write (kryo: Kryo, output: Output, obj: PssIEEE2B): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.inputSignal1Type),
            () => output.writeString (obj.inputSignal2Type),
            () => output.writeDouble (obj.ks1),
            () => output.writeDouble (obj.ks2),
            () => output.writeDouble (obj.ks3),
            () => output.writeInt (obj.m),
            () => output.writeInt (obj.n),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t10),
            () => output.writeDouble (obj.t11),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.t7),
            () => output.writeDouble (obj.t8),
            () => output.writeDouble (obj.t9),
            () => output.writeDouble (obj.tw1),
            () => output.writeDouble (obj.tw2),
            () => output.writeDouble (obj.tw3),
            () => output.writeDouble (obj.tw4),
            () => output.writeDouble (obj.vsi1max),
            () => output.writeDouble (obj.vsi1min),
            () => output.writeDouble (obj.vsi2max),
            () => output.writeDouble (obj.vsi2min),
            () => output.writeDouble (obj.vstmax),
            () => output.writeDouble (obj.vstmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssIEEE2B]): PssIEEE2B =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssIEEE2B (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readInt else 0,
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
            if (isSet (26)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE 421.5-2005 type PSS3B power system stabilizer model.
 *
 * The PSS model PSS3B has dual inputs of electrical power and rotor angular frequency deviation. The signals are used to derive an equivalent mechanical power signal.
 * This model has 2 input signals. They have the following fixed types (expressed in terms of InputSignalKind values): the first one is of rotorAngleFrequencyDeviation type and the second one is of generatorElectricalPower type.
 * Reference: IEEE 3B 421.5-2005, 8.3.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a1                            Notch filter parameter (<i>A1</i>).
 *                                      Typical value = 0,359.
 * @param a2                            Notch filter parameter (<i>A2</i>).
 *                                      Typical value = 0,586.
 * @param a3                            Notch filter parameter (<i>A3</i>).
 *                                      Typical value = 0,429.
 * @param a4                            Notch filter parameter (<i>A4</i>).
 *                                      Typical value = 0,564.
 * @param a5                            Notch filter parameter (<i>A5</i>).
 *                                      Typical value = 0,001.
 * @param a6                            Notch filter parameter (<i>A6</i>).
 *                                      Typical value = 0.
 * @param a7                            Notch filter parameter (<i>A7</i>).
 *                                      Typical value = 0,031.
 * @param a8                            Notch filter parameter (<i>A8</i>).
 *                                      Typical value = 0.
 * @param ks1                           Gain on signal # 1 (<i>Ks1</i>).
 *                                      Typical value = -0,602.
 * @param ks2                           Gain on signal # 2 (<i>Ks2</i>).
 *                                      Typical value = 30,12.
 * @param t1                            Transducer time constant (<i>T1</i>) (&gt;= 0).
 *                                      Typical value = 0,012.
 * @param t2                            Transducer time constant (<i>T2</i>) (&gt;= 0).
 *                                      Typical value = 0,012.
 * @param tw1                           Washout time constant (<i>Tw1</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param tw2                           Washout time constant (<i>Tw2</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param tw3                           Washout time constant (<i>Tw3</i>) (&gt;= 0).
 *                                      Typical value = 0,6.
 * @param vstmax                        Stabilizer output maximum limit (<i>Vstmax</i>) (&gt; PssIEEE3B.vstmin).
 *                                      Typical value = 0,1.
 * @param vstmin                        Stabilizer output minimum limit (<i>Vstmin</i>) (&lt; PssIEEE3B.vstmax).
 *                                      Typical value = -0,1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssIEEE3B
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    a1: Double = 0.0,
    a2: Double = 0.0,
    a3: Double = 0.0,
    a4: Double = 0.0,
    a5: Double = 0.0,
    a6: Double = 0.0,
    a7: Double = 0.0,
    a8: Double = 0.0,
    ks1: Double = 0.0,
    ks2: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    tw1: Double = 0.0,
    tw2: Double = 0.0,
    tw3: Double = 0.0,
    vstmax: Double = 0.0,
    vstmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssIEEE3B.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssIEEE3B.fields (position), value)

        emitelem (0, a1)
        emitelem (1, a2)
        emitelem (2, a3)
        emitelem (3, a4)
        emitelem (4, a5)
        emitelem (5, a6)
        emitelem (6, a7)
        emitelem (7, a8)
        emitelem (8, ks1)
        emitelem (9, ks2)
        emitelem (10, t1)
        emitelem (11, t2)
        emitelem (12, tw1)
        emitelem (13, tw2)
        emitelem (14, tw3)
        emitelem (15, vstmax)
        emitelem (16, vstmin)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssIEEE3B rdf:ID=\"%s\">\n%s\t</cim:PssIEEE3B>".format (id, export_fields)
    }
}

object PssIEEE3B
    extends
        CIMParseable[PssIEEE3B]
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
    val ks1: Fielder = parse_element (element (cls, fields (8)))
    val ks2: Fielder = parse_element (element (cls, fields (9)))
    val t1: Fielder = parse_element (element (cls, fields (10)))
    val t2: Fielder = parse_element (element (cls, fields (11)))
    val tw1: Fielder = parse_element (element (cls, fields (12)))
    val tw2: Fielder = parse_element (element (cls, fields (13)))
    val tw3: Fielder = parse_element (element (cls, fields (14)))
    val vstmax: Fielder = parse_element (element (cls, fields (15)))
    val vstmin: Fielder = parse_element (element (cls, fields (16)))

    def parse (context: CIMContext): PssIEEE3B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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
            toDouble (mask (ks1 (), 8)),
            toDouble (mask (ks2 (), 9)),
            toDouble (mask (t1 (), 10)),
            toDouble (mask (t2 (), 11)),
            toDouble (mask (tw1 (), 12)),
            toDouble (mask (tw2 (), 13)),
            toDouble (mask (tw3 (), 14)),
            toDouble (mask (vstmax (), 15)),
            toDouble (mask (vstmin (), 16))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PssIEEE3B] = PssIEEE3BSerializer
}

object PssIEEE3BSerializer extends CIMSerializer[PssIEEE3B]
{
    def write (kryo: Kryo, output: Output, obj: PssIEEE3B): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a1),
            () => output.writeDouble (obj.a2),
            () => output.writeDouble (obj.a3),
            () => output.writeDouble (obj.a4),
            () => output.writeDouble (obj.a5),
            () => output.writeDouble (obj.a6),
            () => output.writeDouble (obj.a7),
            () => output.writeDouble (obj.a8),
            () => output.writeDouble (obj.ks1),
            () => output.writeDouble (obj.ks2),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.tw1),
            () => output.writeDouble (obj.tw2),
            () => output.writeDouble (obj.tw3),
            () => output.writeDouble (obj.vstmax),
            () => output.writeDouble (obj.vstmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssIEEE3B]): PssIEEE3B =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssIEEE3B (
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
            if (isSet (16)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE 421.5-2005 type PSS4B power system stabilizer.
 *
 * The PSS4B model represents a structure based on multiple working frequency bands. Three separate bands, respectively dedicated to the low-, intermediate- and high-frequency modes of oscillations, are used in this delta omega (speed input) PSS.
 * There is an error in the in IEEE 421.5-2005 PSS4B model: the <i>Pe</i> input should read –<i>Pe</i>. This implies that the input <i>Pe</i> needs to be multiplied by -1.
 * Reference: IEEE 4B 421.5-2005, 8.4.
 * Parameter details:
 * This model has 2 input signals. They have the following fixed types (expressed in terms of InputSignalKind values): the first one is of rotorAngleFrequencyDeviation type and the second one is of generatorElectricalPower type.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param bwh1                          Notch filter 1 (high-frequency band): three dB bandwidth (<i>B</i><i><sub>wi</sub></i>).
 * @param bwh2                          Notch filter 2 (high-frequency band): three dB bandwidth (<i>B</i><i><sub>wi</sub></i>).
 * @param bwl1                          Notch filter 1 (low-frequency band): three dB bandwidth (<i>B</i><i><sub>wi</sub></i>).
 * @param bwl2                          Notch filter 2 (low-frequency band): three dB bandwidth (<i>B</i><i><sub>wi</sub></i>).
 * @param kh                            High band gain (<i>K</i><i><sub>H</sub></i>).
 *                                      Typical value = 120.
 * @param kh1                           High band differential filter gain (<i>K</i><i><sub>H1</sub></i>).
 *                                      Typical value = 66.
 * @param kh11                          High band first lead-lag blocks coefficient (<i>K</i><i><sub>H11</sub></i>).
 *                                      Typical value = 1.
 * @param kh17                          High band first lead-lag blocks coefficient (<i>K</i><i><sub>H17</sub></i>).
 *                                      Typical value = 1.
 * @param kh2                           High band differential filter gain (<i>K</i><i><sub>H2</sub></i>).
 *                                      Typical value = 66.
 * @param ki                            Intermediate band gain (<i>K</i><i><sub>I</sub></i>).
 *                                      Typical value = 30.
 * @param ki1                           Intermediate band differential filter gain (<i>K</i><i><sub>I1</sub></i>).
 *                                      Typical value = 66.
 * @param ki11                          Intermediate band first lead-lag blocks coefficient (<i>K</i><i><sub>I11</sub></i>).
 *                                      Typical value = 1.
 * @param ki17                          Intermediate band first lead-lag blocks coefficient (<i>K</i><i><sub>I17</sub></i>).
 *                                      Typical value = 1.
 * @param ki2                           Intermediate band differential filter gain (<i>K</i><i><sub>I2</sub></i>).
 *                                      Typical value = 66.
 * @param kl                            Low band gain (<i>K</i><i><sub>L</sub></i>).
 *                                      Typical value = 7.5.
 * @param kl1                           Low band differential filter gain (<i>K</i><i><sub>L1</sub></i>).
 *                                      Typical value = 66.
 * @param kl11                          Low band first lead-lag blocks coefficient (<i>K</i><i><sub>L11</sub></i>).
 *                                      Typical value = 1.
 * @param kl17                          Low band first lead-lag blocks coefficient (<i>K</i><i><sub>L17</sub></i>).
 *                                      Typical value = 1.
 * @param kl2                           Low band differential filter gain (<i>K</i><i><sub>L2</sub></i>).
 *                                      Typical value = 66.
 * @param omeganh1                      Notch filter 1 (high-frequency band): filter frequency (<i>omega</i><i><sub>ni</sub></i>).
 * @param omeganh2                      Notch filter 2 (high-frequency band): filter frequency (<i>omega</i><i><sub>ni</sub></i>).
 * @param omeganl1                      Notch filter 1 (low-frequency band): filter frequency (<i>omega</i><i><sub>ni</sub></i>).
 * @param omeganl2                      Notch filter 2 (low-frequency band): filter frequency (<i>omega</i><i><sub>ni</sub></i>).
 * @param th1                           High band time constant (<i>T</i><i><sub>H1</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,01513.
 * @param th10                          High band time constant (<i>T</i><i><sub>H10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th11                          High band time constant (<i>T</i><i><sub>H11</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th12                          High band time constant (<i>T</i><i><sub>H12</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th2                           High band time constant (<i>T</i><i><sub>H2</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,01816.
 * @param th3                           High band time constant (<i>T</i><i><sub>H3</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th4                           High band time constant (<i>T</i><i><sub>H4</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th5                           High band time constant (<i>T</i><i><sub>H5</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th6                           High band time constant (<i>T</i><i><sub>H6</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param th7                           High band time constant (<i>T</i><i><sub>H7</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,01816.
 * @param th8                           High band time constant (<i>T</i><i><sub>H8</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,02179.
 * @param th9                           High band time constant (<i>T</i><i><sub>H9</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti1                           Intermediate band time constant (<i>T</i><i><sub>I1</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,173.
 * @param ti10                          Intermediate band time constant (<i>T</i><i><sub>I10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti11                          Intermediate band time constant (<i>T</i><i><sub>I11</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti12                          Intermediate band time constant (<i>T</i><i><sub>I12</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti2                           Intermediate band time constant (<i>T</i><i><sub>I2</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,2075.
 * @param ti3                           Intermediate band time constant (<i>T</i><i><sub>I3</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti4                           Intermediate band time constant (<i>T</i><i><sub>I4</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti5                           Intermediate band time constant (<i>T</i><i><sub>I5</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti6                           Intermediate band time constant (<i>T</i><i><sub>I6</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param ti7                           Intermediate band time constant (<i>T</i><i><sub>I7</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,2075.
 * @param ti8                           Intermediate band time constant (<i>T</i><i><sub>I8</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,2491.
 * @param ti9                           Intermediate band time constant (<i>T</i><i><sub>I9</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl1                           Low band time constant (<i>T</i><i><sub>L1</sub></i>) (&gt;= 0).
 *                                      Typical value = 1,73.
 * @param tl10                          Low band time constant (<i>T</i><i><sub>L10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl11                          Low band time constant (<i>T</i><i><sub>L11</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl12                          Low band time constant (<i>T</i><i><sub>L12</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl2                           Low band time constant (<i>T</i><i><sub>L2</sub></i>) (&gt;= 0).
 *                                      Typical value = 2,075.
 * @param tl3                           Low band time constant (<i>T</i><i><sub>L3</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl4                           Low band time constant (<i>T</i><i><sub>L4</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl5                           Low band time constant (<i>T</i><i><sub>L5</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl6                           Low band time constant (<i>T</i><i><sub>L6</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param tl7                           Low band time constant (<i>T</i><i><sub>L7</sub></i>) (&gt;= 0).
 *                                      Typical value = 2,075.
 * @param tl8                           Low band time constant (<i>T</i><i><sub>L8</sub></i>) (&gt;= 0).
 *                                      Typical value = 2,491.
 * @param tl9                           Low band time constant (<i>T</i><i><sub>L9</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param vhmax                         High band output maximum limit (<i>V</i><i><sub>Hmax</sub></i>) (&gt; PssIEEE4B.vhmin).
 *                                      Typical value = 0,6.
 * @param vhmin                         High band output minimum limit (<i>V</i><i><sub>Hmin</sub></i>) (&lt; PssIEEE4V.vhmax).
 *                                      Typical value = -0,6.
 * @param vimax                         Intermediate band output maximum limit (<i>V</i><i><sub>Imax</sub></i>) (&gt; PssIEEE4B.vimin).
 *                                      Typical value = 0,6.
 * @param vimin                         Intermediate band output minimum limit (<i>V</i><i><sub>Imin</sub></i>) (&lt; PssIEEE4B.vimax).
 *                                      Typical value = -0,6.
 * @param vlmax                         Low band output maximum limit (<i>V</i><i><sub>Lmax</sub></i>) (&gt; PssIEEE4B.vlmin).
 *                                      Typical value = 0,075.
 * @param vlmin                         Low band output minimum limit (<i>V</i><i><sub>Lmin</sub></i>) (&lt; PssIEEE4B.vlmax).
 *                                      Typical value = -0,075.
 * @param vstmax                        PSS output maximum limit (<i>V</i><i><sub>STmax</sub></i>) (&gt; PssIEEE4B.vstmin).
 *                                      Typical value = 0,15.
 * @param vstmin                        PSS output minimum limit (<i>V</i><i><sub>STmin</sub></i>) (&lt; PssIEEE4B.vstmax).
 *                                      Typical value = -0,15.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssIEEE4B
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    bwh1: Double = 0.0,
    bwh2: Double = 0.0,
    bwl1: Double = 0.0,
    bwl2: Double = 0.0,
    kh: Double = 0.0,
    kh1: Double = 0.0,
    kh11: Double = 0.0,
    kh17: Double = 0.0,
    kh2: Double = 0.0,
    ki: Double = 0.0,
    ki1: Double = 0.0,
    ki11: Double = 0.0,
    ki17: Double = 0.0,
    ki2: Double = 0.0,
    kl: Double = 0.0,
    kl1: Double = 0.0,
    kl11: Double = 0.0,
    kl17: Double = 0.0,
    kl2: Double = 0.0,
    omeganh1: Double = 0.0,
    omeganh2: Double = 0.0,
    omeganl1: Double = 0.0,
    omeganl2: Double = 0.0,
    th1: Double = 0.0,
    th10: Double = 0.0,
    th11: Double = 0.0,
    th12: Double = 0.0,
    th2: Double = 0.0,
    th3: Double = 0.0,
    th4: Double = 0.0,
    th5: Double = 0.0,
    th6: Double = 0.0,
    th7: Double = 0.0,
    th8: Double = 0.0,
    th9: Double = 0.0,
    ti1: Double = 0.0,
    ti10: Double = 0.0,
    ti11: Double = 0.0,
    ti12: Double = 0.0,
    ti2: Double = 0.0,
    ti3: Double = 0.0,
    ti4: Double = 0.0,
    ti5: Double = 0.0,
    ti6: Double = 0.0,
    ti7: Double = 0.0,
    ti8: Double = 0.0,
    ti9: Double = 0.0,
    tl1: Double = 0.0,
    tl10: Double = 0.0,
    tl11: Double = 0.0,
    tl12: Double = 0.0,
    tl2: Double = 0.0,
    tl3: Double = 0.0,
    tl4: Double = 0.0,
    tl5: Double = 0.0,
    tl6: Double = 0.0,
    tl7: Double = 0.0,
    tl8: Double = 0.0,
    tl9: Double = 0.0,
    vhmax: Double = 0.0,
    vhmin: Double = 0.0,
    vimax: Double = 0.0,
    vimin: Double = 0.0,
    vlmax: Double = 0.0,
    vlmin: Double = 0.0,
    vstmax: Double = 0.0,
    vstmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssIEEE4B]
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

    def parse (context: CIMContext): PssIEEE4B =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0, 0, 0)
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

    def serializer: Serializer[PssIEEE4B] = PssIEEE4BSerializer
}

object PssIEEE4BSerializer extends CIMSerializer[PssIEEE4B]
{
    def write (kryo: Kryo, output: Output, obj: PssIEEE4B): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.bwh1),
            () => output.writeDouble (obj.bwh2),
            () => output.writeDouble (obj.bwl1),
            () => output.writeDouble (obj.bwl2),
            () => output.writeDouble (obj.kh),
            () => output.writeDouble (obj.kh1),
            () => output.writeDouble (obj.kh11),
            () => output.writeDouble (obj.kh17),
            () => output.writeDouble (obj.kh2),
            () => output.writeDouble (obj.ki),
            () => output.writeDouble (obj.ki1),
            () => output.writeDouble (obj.ki11),
            () => output.writeDouble (obj.ki17),
            () => output.writeDouble (obj.ki2),
            () => output.writeDouble (obj.kl),
            () => output.writeDouble (obj.kl1),
            () => output.writeDouble (obj.kl11),
            () => output.writeDouble (obj.kl17),
            () => output.writeDouble (obj.kl2),
            () => output.writeDouble (obj.omeganh1),
            () => output.writeDouble (obj.omeganh2),
            () => output.writeDouble (obj.omeganl1),
            () => output.writeDouble (obj.omeganl2),
            () => output.writeDouble (obj.th1),
            () => output.writeDouble (obj.th10),
            () => output.writeDouble (obj.th11),
            () => output.writeDouble (obj.th12),
            () => output.writeDouble (obj.th2),
            () => output.writeDouble (obj.th3),
            () => output.writeDouble (obj.th4),
            () => output.writeDouble (obj.th5),
            () => output.writeDouble (obj.th6),
            () => output.writeDouble (obj.th7),
            () => output.writeDouble (obj.th8),
            () => output.writeDouble (obj.th9),
            () => output.writeDouble (obj.ti1),
            () => output.writeDouble (obj.ti10),
            () => output.writeDouble (obj.ti11),
            () => output.writeDouble (obj.ti12),
            () => output.writeDouble (obj.ti2),
            () => output.writeDouble (obj.ti3),
            () => output.writeDouble (obj.ti4),
            () => output.writeDouble (obj.ti5),
            () => output.writeDouble (obj.ti6),
            () => output.writeDouble (obj.ti7),
            () => output.writeDouble (obj.ti8),
            () => output.writeDouble (obj.ti9),
            () => output.writeDouble (obj.tl1),
            () => output.writeDouble (obj.tl10),
            () => output.writeDouble (obj.tl11),
            () => output.writeDouble (obj.tl12),
            () => output.writeDouble (obj.tl2),
            () => output.writeDouble (obj.tl3),
            () => output.writeDouble (obj.tl4),
            () => output.writeDouble (obj.tl5),
            () => output.writeDouble (obj.tl6),
            () => output.writeDouble (obj.tl7),
            () => output.writeDouble (obj.tl8),
            () => output.writeDouble (obj.tl9),
            () => output.writeDouble (obj.vhmax),
            () => output.writeDouble (obj.vhmin),
            () => output.writeDouble (obj.vimax),
            () => output.writeDouble (obj.vimin),
            () => output.writeDouble (obj.vlmax),
            () => output.writeDouble (obj.vlmin),
            () => output.writeDouble (obj.vstmax),
            () => output.writeDouble (obj.vstmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssIEEE4B]): PssIEEE4B =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssIEEE4B (
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
            if (isSet (39)) input.readDouble else 0.0,
            if (isSet (40)) input.readDouble else 0.0,
            if (isSet (41)) input.readDouble else 0.0,
            if (isSet (42)) input.readDouble else 0.0,
            if (isSet (43)) input.readDouble else 0.0,
            if (isSet (44)) input.readDouble else 0.0,
            if (isSet (45)) input.readDouble else 0.0,
            if (isSet (46)) input.readDouble else 0.0,
            if (isSet (47)) input.readDouble else 0.0,
            if (isSet (48)) input.readDouble else 0.0,
            if (isSet (49)) input.readDouble else 0.0,
            if (isSet (50)) input.readDouble else 0.0,
            if (isSet (51)) input.readDouble else 0.0,
            if (isSet (52)) input.readDouble else 0.0,
            if (isSet (53)) input.readDouble else 0.0,
            if (isSet (54)) input.readDouble else 0.0,
            if (isSet (55)) input.readDouble else 0.0,
            if (isSet (56)) input.readDouble else 0.0,
            if (isSet (57)) input.readDouble else 0.0,
            if (isSet (58)) input.readDouble else 0.0,
            if (isSet (59)) input.readDouble else 0.0,
            if (isSet (60)) input.readDouble else 0.0,
            if (isSet (61)) input.readDouble else 0.0,
            if (isSet (62)) input.readDouble else 0.0,
            if (isSet (63)) input.readDouble else 0.0,
            if (isSet (64)) input.readDouble else 0.0,
            if (isSet (65)) input.readDouble else 0.0,
            if (isSet (66)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * PTI microprocessor-based stabilizer type 1.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param dtc                           Time step related to activation of controls (<i>deltatc</i>) (&gt;= 0).
 *                                      Typical value = 0,025.
 * @param dtf                           Time step frequency calculation (<i>deltatf</i>) (&gt;= 0).
 *                                      Typical value = 0,025.
 * @param dtp                           Time step active power calculation (<i>deltatp</i>) (&gt;= 0).
 *                                      Typical value = 0,0125.
 * @param k                             Gain (<i>K</i>).
 *                                      Typical value = 9.
 * @param m                             (<i>M</i>).  <i>M </i>= 2 x <i>H</i>.
 *                                      Typical value = 5.
 * @param t1                            Time constant (<i>T1</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t2                            Time constant (<i>T2</i>) (&gt;= 0).
 *                                      Typical value = 1.
 * @param t3                            Time constant (<i>T3</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param t4                            Time constant (<i>T4</i>) (&gt;= 0).
 *                                      Typical value = 0,05.
 * @param tf                            Time constant (<i>Tf</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param tp                            Time constant (<i>Tp</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssPTIST1
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    dtc: Double = 0.0,
    dtf: Double = 0.0,
    dtp: Double = 0.0,
    k: Double = 0.0,
    m: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    tf: Double = 0.0,
    tp: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssPTIST1]
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

    def parse (context: CIMContext): PssPTIST1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssPTIST1] = PssPTIST1Serializer
}

object PssPTIST1Serializer extends CIMSerializer[PssPTIST1]
{
    def write (kryo: Kryo, output: Output, obj: PssPTIST1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.dtc),
            () => output.writeDouble (obj.dtf),
            () => output.writeDouble (obj.dtp),
            () => output.writeDouble (obj.k),
            () => output.writeDouble (obj.m),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.tf),
            () => output.writeDouble (obj.tp)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssPTIST1]): PssPTIST1 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssPTIST1 (
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
            if (isSet (10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * PTI microprocessor-based stabilizer type 3.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param a0                            Filter coefficient (<i>A0</i>).
 * @param a1                            Limiter (<i>Al</i>).
 * @param a2                            Filter coefficient (<i>A2</i>).
 * @param a3                            Filter coefficient (<i>A3</i>).
 * @param a4                            Filter coefficient (<i>A4</i>).
 * @param a5                            Filter coefficient (<i>A5</i>).
 * @param al                            Limiter (<i>Al</i>).
 * @param athres                        Threshold value above which output averaging will be bypassed (<i>Athres</i>).
 *                                      Typical value = 0,005.
 * @param b0                            Filter coefficient (<i>B0</i>).
 * @param b1                            Filter coefficient (<i>B1</i>).
 * @param b2                            Filter coefficient (<i>B2</i>).
 * @param b3                            Filter coefficient (<i>B3</i>).
 * @param b4                            Filter coefficient (<i>B4</i>).
 * @param b5                            Filter coefficient (<i>B5</i>).
 * @param dl                            Limiter (<i>Dl</i>).
 * @param dtc                           Time step related to activation of controls (<i>deltatc</i>) (&gt;= 0).
 *                                      Typical value = 0,025 (0,03 for 50 Hz).
 * @param dtf                           Time step frequency calculation (<i>deltatf</i>) (&gt;= 0).
 *                                      Typical value = 0,025 (0,03 for 50 Hz).
 * @param dtp                           Time step active power calculation (<i>deltatp</i>) (&gt;= 0).
 *                                      Typical value = 0,0125  (0,015 for 50 Hz).
 * @param isw                           Digital/analogue output switch (<i>Isw</i>).
 *                                      true = produce analogue output
 *                                      false = convert to digital output, using tap selection table.
 * @param k                             Gain (<i>K</i>).
 *                                      Typical value = 9.
 * @param lthres                        Threshold value (<i>Lthres</i>).
 * @param m                             (<i>M</i>).  <i>M</i> = 2 x <i>H</i>.
 *                                      Typical value = 5.
 * @param nav                           Number of control outputs to average (<i>NAV</i>) (1 &lt;=  <i>NAV</i> &lt;= 16).
 *                                      Typical value = 4.
 * @param ncl                           Number of counts at limit to active limit function (<i>NCL</i>) (&gt; 0).
 * @param ncr                           Number of counts until reset after limit function is triggered (<i>NCR</i>).
 * @param pmin                          (<i>Pmin</i>).
 * @param t1                            Time constant (<i>T1</i>) (&gt;= 0).
 *                                      Typical value = 0,3.
 * @param t2                            Time constant (<i>T2</i>) (&gt;= 0).
 *                                      Typical value = 1.
 * @param t3                            Time constant (<i>T3</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param t4                            Time constant (<i>T4</i>) (&gt;= 0).
 *                                      Typical value = 0,05.
 * @param t5                            Time constant (<i>T5</i>) (&gt;= 0).
 * @param t6                            Time constant (<i>T6</i>) (&gt;= 0).
 * @param tf                            Time constant (<i>Tf</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @param tp                            Time constant (<i>Tp</i>) (&gt;= 0).
 *                                      Typical value = 0,2.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssPTIST3
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    a0: Double = 0.0,
    a1: Double = 0.0,
    a2: Double = 0.0,
    a3: Double = 0.0,
    a4: Double = 0.0,
    a5: Double = 0.0,
    al: Double = 0.0,
    athres: Double = 0.0,
    b0: Double = 0.0,
    b1: Double = 0.0,
    b2: Double = 0.0,
    b3: Double = 0.0,
    b4: Double = 0.0,
    b5: Double = 0.0,
    dl: Double = 0.0,
    dtc: Double = 0.0,
    dtf: Double = 0.0,
    dtp: Double = 0.0,
    isw: Boolean = false,
    k: Double = 0.0,
    lthres: Double = 0.0,
    m: Double = 0.0,
    nav: Double = 0.0,
    ncl: Double = 0.0,
    ncr: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    tf: Double = 0.0,
    tp: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssPTIST3]
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

    def parse (context: CIMContext): PssPTIST3 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0, 0)
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

    def serializer: Serializer[PssPTIST3] = PssPTIST3Serializer
}

object PssPTIST3Serializer extends CIMSerializer[PssPTIST3]
{
    def write (kryo: Kryo, output: Output, obj: PssPTIST3): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.a0),
            () => output.writeDouble (obj.a1),
            () => output.writeDouble (obj.a2),
            () => output.writeDouble (obj.a3),
            () => output.writeDouble (obj.a4),
            () => output.writeDouble (obj.a5),
            () => output.writeDouble (obj.al),
            () => output.writeDouble (obj.athres),
            () => output.writeDouble (obj.b0),
            () => output.writeDouble (obj.b1),
            () => output.writeDouble (obj.b2),
            () => output.writeDouble (obj.b3),
            () => output.writeDouble (obj.b4),
            () => output.writeDouble (obj.b5),
            () => output.writeDouble (obj.dl),
            () => output.writeDouble (obj.dtc),
            () => output.writeDouble (obj.dtf),
            () => output.writeDouble (obj.dtp),
            () => output.writeBoolean (obj.isw),
            () => output.writeDouble (obj.k),
            () => output.writeDouble (obj.lthres),
            () => output.writeDouble (obj.m),
            () => output.writeDouble (obj.nav),
            () => output.writeDouble (obj.ncl),
            () => output.writeDouble (obj.ncr),
            () => output.writeDouble (obj.pmin),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.tf),
            () => output.writeDouble (obj.tp)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssPTIST3]): PssPTIST3 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssPTIST3 (
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
            if (isSet (18)) input.readBoolean else false,
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
            if (isSet (33)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Power system stabilizer type RQB.
 *
 * This power system stabilizer is intended to be used together with excitation system type ExcRQB, which is primarily used in nuclear or thermal generating units.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param kdpm                          Lead lag gain (<i>KDPM</i>).
 *                                      Typical value = 0,185.
 * @param ki2                           Speed input gain (<i>Ki2</i>).
 *                                      Typical value = 3,43.
 * @param ki3                           Electrical power input gain (<i>Ki3</i>).
 *                                      Typical value = -11,45.
 * @param ki4                           Mechanical power input gain (<i>Ki4</i>).
 *                                      Typical value = 11,86.
 * @param sibv                          Speed deadband (<i>SIBV</i>).
 *                                      Typical value = 0,006.
 * @param t4f                           Lead lag time constant (<i>T4F</i>) (&gt;= 0).
 *                                      Typical value = 0,045.
 * @param t4m                           Input time constant (<i>T4M</i>) (&gt;= 0).
 *                                      Typical value = 5.
 * @param t4mom                         Speed time constant (<i>T4MOM</i>) (&gt;= 0).
 *                                      Typical value = 1,27.
 * @param tomd                          Speed delay (<i>TOMD</i>) (&gt;= 0).
 *                                      Typical value = 0,02.
 * @param tomsl                         Speed time constant (<i>TOMSL</i>) (&gt;= 0).
 *                                      Typical value = 0,04.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssRQB
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    kdpm: Double = 0.0,
    ki2: Double = 0.0,
    ki3: Double = 0.0,
    ki4: Double = 0.0,
    sibv: Double = 0.0,
    t4f: Double = 0.0,
    t4m: Double = 0.0,
    t4mom: Double = 0.0,
    tomd: Double = 0.0,
    tomsl: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssRQB.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssRQB.fields (position), value)

        emitelem (0, kdpm)
        emitelem (1, ki2)
        emitelem (2, ki3)
        emitelem (3, ki4)
        emitelem (4, sibv)
        emitelem (5, t4f)
        emitelem (6, t4m)
        emitelem (7, t4mom)
        emitelem (8, tomd)
        emitelem (9, tomsl)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssRQB rdf:ID=\"%s\">\n%s\t</cim:PssRQB>".format (id, export_fields)
    }
}

object PssRQB
    extends
        CIMParseable[PssRQB]
{
    override val fields: Array[String] = Array [String](
        "kdpm",
        "ki2",
        "ki3",
        "ki4",
        "sibv",
        "t4f",
        "t4m",
        "t4mom",
        "tomd",
        "tomsl"
    )
    val kdpm: Fielder = parse_element (element (cls, fields (0)))
    val ki2: Fielder = parse_element (element (cls, fields (1)))
    val ki3: Fielder = parse_element (element (cls, fields (2)))
    val ki4: Fielder = parse_element (element (cls, fields (3)))
    val sibv: Fielder = parse_element (element (cls, fields (4)))
    val t4f: Fielder = parse_element (element (cls, fields (5)))
    val t4m: Fielder = parse_element (element (cls, fields (6)))
    val t4mom: Fielder = parse_element (element (cls, fields (7)))
    val tomd: Fielder = parse_element (element (cls, fields (8)))
    val tomsl: Fielder = parse_element (element (cls, fields (9)))

    def parse (context: CIMContext): PssRQB =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PssRQB (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (kdpm (), 0)),
            toDouble (mask (ki2 (), 1)),
            toDouble (mask (ki3 (), 2)),
            toDouble (mask (ki4 (), 3)),
            toDouble (mask (sibv (), 4)),
            toDouble (mask (t4f (), 5)),
            toDouble (mask (t4m (), 6)),
            toDouble (mask (t4mom (), 7)),
            toDouble (mask (tomd (), 8)),
            toDouble (mask (tomsl (), 9))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PssRQB] = PssRQBSerializer
}

object PssRQBSerializer extends CIMSerializer[PssRQB]
{
    def write (kryo: Kryo, output: Output, obj: PssRQB): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kdpm),
            () => output.writeDouble (obj.ki2),
            () => output.writeDouble (obj.ki3),
            () => output.writeDouble (obj.ki4),
            () => output.writeDouble (obj.sibv),
            () => output.writeDouble (obj.t4f),
            () => output.writeDouble (obj.t4m),
            () => output.writeDouble (obj.t4mom),
            () => output.writeDouble (obj.tomd),
            () => output.writeDouble (obj.tomsl)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssRQB]): PssRQB =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssRQB (
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
            if (isSet (9)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Power sensitive stabilizer model.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param kx                            Gain (<i>Kx</i>).
 *                                      Typical value = 2,7.
 * @param ta                            Time constant (<i>Ta</i>) (&gt;= 0).
 *                                      Typical value = 0,37.
 * @param tb                            Time constant (<i>Tb</i>) (&gt;= 0).
 *                                      Typical value = 0,37.
 * @param tc                            Time constant (<i>Tc</i>) (&gt;= 0).
 *                                      Typical value = 0,035.
 * @param td                            Time constant (<i>Td</i>) (&gt;= 0).
 *                                      Typical value = 0,0.
 * @param te                            Time constant (<i>Te</i>) (&gt;= 0).
 *                                      Typical value = 0,0169.
 * @param tt                            Time constant (<i>Tt</i>) (&gt;= 0).
 *                                      Typical value = 0,18.
 * @param tx1                           Reset time constant (<i>Tx1</i>) (&gt;= 0).
 *                                      Typical value = 0,035.
 * @param tx2                           Time constant (<i>Tx2</i>) (&gt;= 0).
 *                                      Typical value = 5,0.
 * @param vsmax                         Limiter (<i>Vsmax</i>) (&gt; PssSB4.vsmin).
 *                                      Typical value = 0,062.
 * @param vsmin                         Limiter (<i>Vsmin</i>) (&lt; PssSB4.vsmax).
 *                                      Typical value = -0,062.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssSB4
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    kx: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    td: Double = 0.0,
    te: Double = 0.0,
    tt: Double = 0.0,
    tx1: Double = 0.0,
    tx2: Double = 0.0,
    vsmax: Double = 0.0,
    vsmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssSB4]
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

    def parse (context: CIMContext): PssSB4 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssSB4] = PssSB4Serializer
}

object PssSB4Serializer extends CIMSerializer[PssSB4]
{
    def write (kryo: Kryo, output: Output, obj: PssSB4): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.kx),
            () => output.writeDouble (obj.ta),
            () => output.writeDouble (obj.tb),
            () => output.writeDouble (obj.tc),
            () => output.writeDouble (obj.td),
            () => output.writeDouble (obj.te),
            () => output.writeDouble (obj.tt),
            () => output.writeDouble (obj.tx1),
            () => output.writeDouble (obj.tx2),
            () => output.writeDouble (obj.vsmax),
            () => output.writeDouble (obj.vsmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssSB4]): PssSB4 =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssSB4 (
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
            if (isSet (10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Siemens<sup>TM</sup> “H infinity” power system stabilizer with generator electrical power input.
 * [Footnote: Siemens "H infinity" power system stabilizers are an example of suitable products available commercially.
 *
 * This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param k                             Main gain (<i>K</i>).
 *                                      Typical value = 1.
 * @param k0                            Gain 0 (<i>K0</i>).
 *                                      Typical value = 0,012.
 * @param k1                            Gain 1 (<i>K1</i>).
 *                                      Typical value = 0,488.
 * @param k2                            Gain 2 (<i>K2</i>).
 *                                      Typical value = 0,064.
 * @param k3                            Gain 3 (<i>K3</i>).
 *                                      Typical value = 0,224.
 * @param k4                            Gain 4 (<i>K4</i>).
 *                                      Typical value = 0,1.
 * @param t1                            Time constant 1 (<i>T1</i>) (&gt; 0).
 *                                      Typical value = 0,076.
 * @param t2                            Time constant 2 (<i>T2</i>) (&gt; 0).
 *                                      Typical value = 0,086.
 * @param t3                            Time constant 3 (<i>T3</i>) (&gt; 0).
 *                                      Typical value = 1,068.
 * @param t4                            Time constant 4 (<i>T4</i>) (&gt; 0).
 *                                      Typical value = 1,913.
 * @param td                            Input time constant (<i>T</i><i><sub>d</sub></i>) (&gt;= 0).
 *                                      Typical value = 10.
 * @param vsmax                         Output maximum limit (<i>Vsmax</i>) (&gt; PssSH.vsmin).
 *                                      Typical value = 0,1.
 * @param vsmin                         Output minimum limit (<i>Vsmin</i>) (&lt; PssSH.vsmax).
 *                                      Typical value = -0,1.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssSH
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    k: Double = 0.0,
    k0: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    td: Double = 0.0,
    vsmax: Double = 0.0,
    vsmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssSH]
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

    def parse (context: CIMContext): PssSH =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssSH] = PssSHSerializer
}

object PssSHSerializer extends CIMSerializer[PssSH]
{
    def write (kryo: Kryo, output: Output, obj: PssSH): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.k),
            () => output.writeDouble (obj.k0),
            () => output.writeDouble (obj.k1),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.k3),
            () => output.writeDouble (obj.k4),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.td),
            () => output.writeDouble (obj.vsmax),
            () => output.writeDouble (obj.vsmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssSH]): PssSH =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssSH (
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
            if (isSet (12)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Slovakian PSS with three inputs.
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param k1                            Gain <i>P</i> (<i>K</i><i><sub>1</sub></i>).
 *                                      Typical value = -0,3.
 * @param k2                            Gain <i>f</i><i><sub>E</sub></i><i> </i>(<i>K</i><i><sub>2</sub></i>).
 *                                      Typical value = -0,15.
 * @param k3                            Gain <i>I</i><i><sub>f</sub></i><i> </i>(<i>K</i><i><sub>3</sub></i>).
 *                                      Typical value = 10.
 * @param t1                            Denominator time constant (<i>T</i><i><sub>1</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,3.
 * @param t2                            Filter time constant (<i>T</i><i><sub>2</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,35.
 * @param t3                            Denominator time constant (<i>T</i><i><sub>3</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,22.
 * @param t4                            Filter time constant (<i>T</i><i><sub>4</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,02.
 * @param t5                            Denominator time constant (<i>T</i><i><sub>5</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,02.
 * @param t6                            Filter time constant (<i>T</i><i><sub>6</sub></i>) (&gt; 0,005).
 *                                      Typical value = 0,02.
 * @param vsmax                         Stabilizer output maximum limit (<i>V</i><i><sub>SMAX</sub></i>) (&gt; PssSK.vsmin).
 *                                      Typical value = 0,4.
 * @param vsmin                         Stabilizer output minimum limit (<i>V</i><i><sub>SMIN</sub></i>) (&lt; PssSK.vsmax).
 *                                      Typical value = -0.4.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssSK
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    vsmax: Double = 0.0,
    vsmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssSK]
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

    def parse (context: CIMContext): PssSK =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssSK] = PssSKSerializer
}

object PssSKSerializer extends CIMSerializer[PssSK]
{
    def write (kryo: Kryo, output: Output, obj: PssSK): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.k1),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.k3),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.vsmax),
            () => output.writeDouble (obj.vsmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssSK]): PssSK =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssSK (
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
            if (isSet (10)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Power system stabilizer part of an ABB excitation system.
 * [Footnote: ABB excitation systems are an example of suitable products available commercially.
 *
 * This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param hlim                          Stabilizer output limiter (<i>H</i><i><sub>LIM</sub></i>).
 *                                      Typical value = 0,5.
 * @param k2                            Gain (<i>K2</i>).
 *                                      Typical value = 1,0.
 * @param k3                            Gain (<i>K3</i>).
 *                                      Typical value = 0,25.
 * @param k4                            Gain (<i>K4</i>).
 *                                      Typical value = 0,075.
 * @param k5                            Gain (<i>K5</i>).
 *                                      Typical value = 2,5.
 * @param t2                            Time constant (<i>T2</i>).
 *                                      Typical value = 4,0.
 * @param t3                            Time constant (<i>T3</i>).
 *                                      Typical value = 2,0.
 * @param t5                            Time constant (<i>T5</i>).
 *                                      Typical value = 4,5.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssSTAB2A
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    hlim: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    k5: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t5: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PssSTAB2A.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PssSTAB2A.fields (position), value)

        emitelem (0, hlim)
        emitelem (1, k2)
        emitelem (2, k3)
        emitelem (3, k4)
        emitelem (4, k5)
        emitelem (5, t2)
        emitelem (6, t3)
        emitelem (7, t5)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PssSTAB2A rdf:ID=\"%s\">\n%s\t</cim:PssSTAB2A>".format (id, export_fields)
    }
}

object PssSTAB2A
    extends
        CIMParseable[PssSTAB2A]
{
    override val fields: Array[String] = Array [String](
        "hlim",
        "k2",
        "k3",
        "k4",
        "k5",
        "t2",
        "t3",
        "t5"
    )
    val hlim: Fielder = parse_element (element (cls, fields (0)))
    val k2: Fielder = parse_element (element (cls, fields (1)))
    val k3: Fielder = parse_element (element (cls, fields (2)))
    val k4: Fielder = parse_element (element (cls, fields (3)))
    val k5: Fielder = parse_element (element (cls, fields (4)))
    val t2: Fielder = parse_element (element (cls, fields (5)))
    val t3: Fielder = parse_element (element (cls, fields (6)))
    val t5: Fielder = parse_element (element (cls, fields (7)))

    def parse (context: CIMContext): PssSTAB2A =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PssSTAB2A (
            PowerSystemStabilizerDynamics.parse (context),
            toDouble (mask (hlim (), 0)),
            toDouble (mask (k2 (), 1)),
            toDouble (mask (k3 (), 2)),
            toDouble (mask (k4 (), 3)),
            toDouble (mask (k5 (), 4)),
            toDouble (mask (t2 (), 5)),
            toDouble (mask (t3 (), 6)),
            toDouble (mask (t5 (), 7))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PssSTAB2A] = PssSTAB2ASerializer
}

object PssSTAB2ASerializer extends CIMSerializer[PssSTAB2A]
{
    def write (kryo: Kryo, output: Output, obj: PssSTAB2A): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.hlim),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.k3),
            () => output.writeDouble (obj.k4),
            () => output.writeDouble (obj.k5),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t5)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssSTAB2A]): PssSTAB2A =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssSTAB2A (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Dual input power system stabilizer, based on IEEE type 2, with modified output limiter defined by WECC (Western Electricity Coordinating Council, USA).
 *
 * @param PowerSystemStabilizerDynamics [[ch.ninecode.model.PowerSystemStabilizerDynamics PowerSystemStabilizerDynamics]] Reference to the superclass object.
 * @param inputSignal1Type              Type of input signal #1 (rotorAngularFrequencyDeviation, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, or busVoltageDerivative - shall be different than PssWECC.inputSignal2Type).
 *                                      Typical value = rotorAngularFrequencyDeviation.
 * @param inputSignal2Type              Type of input signal #2 (rotorAngularFrequencyDeviation, busFrequencyDeviation, generatorElectricalPower, generatorAcceleratingPower, busVoltage, busVoltageDerivative - shall be different than PssWECC.inputSignal1Type).
 *                                      Typical value = busVoltageDerivative.
 * @param k1                            Input signal 1 gain (<i>K</i><i><sub>1</sub></i>).
 *                                      Typical value = 1,13.
 * @param k2                            Input signal 2 gain (<i>K</i><i><sub>2</sub></i>).
 *                                      Typical value = 0,0.
 * @param t1                            Input signal 1 transducer time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,037.
 * @param t10                           Lag time constant (<i>T</i><i><sub>10</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param t2                            Input signal 2 transducer time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *                                      Typical value = 0,0.
 * @param t3                            Stabilizer washout time constant (<i>T</i><i><sub>3</sub></i>) (&gt;= 0).
 *                                      Typical value = 9,5.
 * @param t4                            Stabilizer washout time lag constant (<i>T</i><i><sub>4</sub></i>) (&gt;= 0).
 *                                      Typical value = 9,5.
 * @param t5                            Lead time constant (<i>T</i><i><sub>5</sub></i>) (&gt;= 0).
 *                                      Typical value = 1,7.
 * @param t6                            Lag time constant (<i>T</i><i><sub>6</sub></i>) (&gt;= 0).
 *                                      Typical value = 1,5.
 * @param t7                            Lead time constant (<i>T</i><i><sub>7</sub></i>) (&gt;= 0).
 *                                      Typical value = 1,7.
 * @param t8                            Lag time constant (<i>T</i><i><sub>8</sub></i>) (&gt;= 0).
 *                                      Typical value = 1,5.
 * @param t9                            Lead time constant (<i>T</i><i><sub>9</sub></i>) (&gt;= 0).
 *                                      Typical value = 0.
 * @param vcl                           Minimum value for voltage compensator output (<i>V</i><i><sub>CL</sub></i>).
 *                                      Typical value = 0.
 * @param vcu                           Maximum value for voltage compensator output (<i>V</i><i><sub>CU</sub></i>).
 *                                      Typical value = 0.
 * @param vsmax                         Maximum output signal (<i>Vsmax</i>) (&gt; PssWECC.vsmin).
 *                                      Typical value = 0,05.
 * @param vsmin                         Minimum output signal (<i>Vsmin</i>) (&lt; PssWECC.vsmax).
 *                                      Typical value = -0,05.
 * @group PowerSystemStabilizerDynamics
 * @groupname PowerSystemStabilizerDynamics Package PowerSystemStabilizerDynamics
 * @groupdesc PowerSystemStabilizerDynamics The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.  A variety of input signals can be used depending on the particular design.
 */
final case class PssWECC
(
    PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = null,
    inputSignal1Type: String = null,
    inputSignal2Type: String = null,
    k1: Double = 0.0,
    k2: Double = 0.0,
    t1: Double = 0.0,
    t10: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    t9: Double = 0.0,
    vcl: Double = 0.0,
    vcu: Double = 0.0,
    vsmax: Double = 0.0,
    vsmin: Double = 0.0
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
    override def sup: PowerSystemStabilizerDynamics = PowerSystemStabilizerDynamics

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[PssWECC]
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

    def parse (context: CIMContext): PssWECC =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[PssWECC] = PssWECCSerializer
}

object PssWECCSerializer extends CIMSerializer[PssWECC]
{
    def write (kryo: Kryo, output: Output, obj: PssWECC): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.inputSignal1Type),
            () => output.writeString (obj.inputSignal2Type),
            () => output.writeDouble (obj.k1),
            () => output.writeDouble (obj.k2),
            () => output.writeDouble (obj.t1),
            () => output.writeDouble (obj.t10),
            () => output.writeDouble (obj.t2),
            () => output.writeDouble (obj.t3),
            () => output.writeDouble (obj.t4),
            () => output.writeDouble (obj.t5),
            () => output.writeDouble (obj.t6),
            () => output.writeDouble (obj.t7),
            () => output.writeDouble (obj.t8),
            () => output.writeDouble (obj.t9),
            () => output.writeDouble (obj.vcl),
            () => output.writeDouble (obj.vcu),
            () => output.writeDouble (obj.vsmax),
            () => output.writeDouble (obj.vsmin)
        )
        PowerSystemStabilizerDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PssWECC]): PssWECC =
    {
        val parent = PowerSystemStabilizerDynamicsSerializer.read (kryo, input, classOf [PowerSystemStabilizerDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PssWECC (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
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
            if (isSet (17)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _PowerSystemStabilizerDynamics
{
    def register: List[CIMClassInfo] =
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
            PssRQB.register,
            PssSB4.register,
            PssSH.register,
            PssSK.register,
            PssSTAB2A.register,
            PssWECC.register
        )
    }
}