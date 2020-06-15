package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Power factor or VAr controller type 1 function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this power actor or VAr controller type 1 model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this power factor or VAr controller type 1 model.
 * @param VoltageAdjusterDynamics [[ch.ninecode.model.VoltageAdjusterDynamics VoltageAdjusterDynamics]] Voltage adjuster model associated with this power factor or VAr controller type 1 model.
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value. This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE 421.1 as “a control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.” </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 */
final case class PFVArControllerType1Dynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null,
    RemoteInputSignal: String = null,
    VoltageAdjusterDynamics: String = null
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
        implicit val clz: String = PFVArControllerType1Dynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PFVArControllerType1Dynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        emitattr (1, RemoteInputSignal)
        emitattr (2, VoltageAdjusterDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType1Dynamics rdf:ID=\"%s\">\n%s\t</cim:PFVArControllerType1Dynamics>".format (id, export_fields)
    }
}

object PFVArControllerType1Dynamics
extends
    CIMParseable[PFVArControllerType1Dynamics]
{
    override val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal",
        "VoltageAdjusterDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        CIMRelationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1"),
        CIMRelationship ("VoltageAdjusterDynamics", "VoltageAdjusterDynamics", "0..1", "1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))
    val VoltageAdjusterDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): PFVArControllerType1Dynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArControllerType1Dynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1),
            mask (VoltageAdjusterDynamics (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PFVArControllerType1DynamicsSerializer extends CIMSerializer[PFVArControllerType1Dynamics]
{
    def write (kryo: Kryo, output: Output, obj: PFVArControllerType1Dynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ExcitationSystemDynamics),
            () => output.writeString (obj.RemoteInputSignal),
            () => output.writeString (obj.VoltageAdjusterDynamics)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PFVArControllerType1Dynamics]): PFVArControllerType1Dynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PFVArControllerType1Dynamics (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * IEEE PF controller type 1 which operates by moving the voltage reference directly.
 *
 * Reference: IEEE 421.5-2005, 11.2.
 *
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param ovex Overexcitation Flag (<i>OVEX</i>)
 *        true = overexcited
 *        false = underexcited.
 * @param tpfc PF controller time delay (<i>T</i><i><sub>PFC</sub></i>) (&gt;= 0).
 *        Typical value = 5.
 * @param vitmin Minimum machine terminal current needed to enable pf/var controller (<i>V</i><i><sub>ITMIN</sub></i>).
 * @param vpf Synchronous machine power factor (<i>V</i><i><sub>PF</sub></i>).
 * @param vpfcbw PF controller deadband (<i>V</i><i><sub>PFC_BW</sub></i>).
 *        Typical value = 0,05.
 * @param vpfref PF controller reference (<i>V</i><i><sub>PFREF</sub></i>).
 * @param vvtmax Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>) (&gt; PFVArType1IEEEPFController.vvtmin).
 * @param vvtmin Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>) (&lt; PFVArType1IEEEPFController.vvtmax).
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value. This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE 421.1 as “a control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.” </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 */
final case class PFVArType1IEEEPFController
(
    PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = null,
    ovex: Boolean = false,
    tpfc: Double = 0.0,
    vitmin: Double = 0.0,
    vpf: Double = 0.0,
    vpfcbw: Double = 0.0,
    vpfref: Double = 0.0,
    vvtmax: Double = 0.0,
    vvtmin: Double = 0.0
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
    override def sup: PFVArControllerType1Dynamics = PFVArControllerType1Dynamics

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
        implicit val clz: String = PFVArType1IEEEPFController.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArType1IEEEPFController.fields (position), value)
        emitelem (0, ovex)
        emitelem (1, tpfc)
        emitelem (2, vitmin)
        emitelem (3, vpf)
        emitelem (4, vpfcbw)
        emitelem (5, vpfref)
        emitelem (6, vvtmax)
        emitelem (7, vvtmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArType1IEEEPFController rdf:ID=\"%s\">\n%s\t</cim:PFVArType1IEEEPFController>".format (id, export_fields)
    }
}

object PFVArType1IEEEPFController
extends
    CIMParseable[PFVArType1IEEEPFController]
{
    override val fields: Array[String] = Array[String] (
        "ovex",
        "tpfc",
        "vitmin",
        "vpf",
        "vpfcbw",
        "vpfref",
        "vvtmax",
        "vvtmin"
    )
    val ovex: Fielder = parse_element (element (cls, fields(0)))
    val tpfc: Fielder = parse_element (element (cls, fields(1)))
    val vitmin: Fielder = parse_element (element (cls, fields(2)))
    val vpf: Fielder = parse_element (element (cls, fields(3)))
    val vpfcbw: Fielder = parse_element (element (cls, fields(4)))
    val vpfref: Fielder = parse_element (element (cls, fields(5)))
    val vvtmax: Fielder = parse_element (element (cls, fields(6)))
    val vvtmin: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: CIMContext): PFVArType1IEEEPFController =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArType1IEEEPFController (
            PFVArControllerType1Dynamics.parse (context),
            toBoolean (mask (ovex (), 0)),
            toDouble (mask (tpfc (), 1)),
            toDouble (mask (vitmin (), 2)),
            toDouble (mask (vpf (), 3)),
            toDouble (mask (vpfcbw (), 4)),
            toDouble (mask (vpfref (), 5)),
            toDouble (mask (vvtmax (), 6)),
            toDouble (mask (vvtmin (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PFVArType1IEEEPFControllerSerializer extends CIMSerializer[PFVArType1IEEEPFController]
{
    def write (kryo: Kryo, output: Output, obj: PFVArType1IEEEPFController): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.ovex),
            () => output.writeDouble (obj.tpfc),
            () => output.writeDouble (obj.vitmin),
            () => output.writeDouble (obj.vpf),
            () => output.writeDouble (obj.vpfcbw),
            () => output.writeDouble (obj.vpfref),
            () => output.writeDouble (obj.vvtmax),
            () => output.writeDouble (obj.vvtmin)
        )
        PFVArControllerType1DynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PFVArType1IEEEPFController]): PFVArType1IEEEPFController =
    {
        val parent = PFVArControllerType1DynamicsSerializer.read (kryo, input, classOf[PFVArControllerType1Dynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PFVArType1IEEEPFController (
            parent,
            if (isSet (0)) input.readBoolean else false,
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
 * IEEE VAR controller type 1 which operates by moving the voltage reference directly.
 *
 * Reference: IEEE 421.5-2005, 11.3.
 *
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param tvarc Var controller time delay (<i>T</i><i><sub>VARC</sub></i>) (&gt;= 0).
 *        Typical value = 5.
 * @param vvar Synchronous machine power factor (<i>V</i><i><sub>VAR</sub></i>).
 * @param vvarcbw Var controller deadband (<i>V</i><i><sub>VARC_BW</sub></i>).
 *        Typical value = 0,02.
 * @param vvarref Var controller reference (<i>V</i><i><sub>VARREF</sub></i>).
 * @param vvtmax Maximum machine terminal voltage needed for pf/VAr controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>) (&gt; PVFArType1IEEEVArController.vvtmin).
 * @param vvtmin Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>) (&lt; PVFArType1IEEEVArController.vvtmax).
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value. This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE 421.1 as “a control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.” </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 */
final case class PFVArType1IEEEVArController
(
    PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = null,
    tvarc: Double = 0.0,
    vvar: Double = 0.0,
    vvarcbw: Double = 0.0,
    vvarref: Double = 0.0,
    vvtmax: Double = 0.0,
    vvtmin: Double = 0.0
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
    override def sup: PFVArControllerType1Dynamics = PFVArControllerType1Dynamics

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
        implicit val clz: String = PFVArType1IEEEVArController.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArType1IEEEVArController.fields (position), value)
        emitelem (0, tvarc)
        emitelem (1, vvar)
        emitelem (2, vvarcbw)
        emitelem (3, vvarref)
        emitelem (4, vvtmax)
        emitelem (5, vvtmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArType1IEEEVArController rdf:ID=\"%s\">\n%s\t</cim:PFVArType1IEEEVArController>".format (id, export_fields)
    }
}

object PFVArType1IEEEVArController
extends
    CIMParseable[PFVArType1IEEEVArController]
{
    override val fields: Array[String] = Array[String] (
        "tvarc",
        "vvar",
        "vvarcbw",
        "vvarref",
        "vvtmax",
        "vvtmin"
    )
    val tvarc: Fielder = parse_element (element (cls, fields(0)))
    val vvar: Fielder = parse_element (element (cls, fields(1)))
    val vvarcbw: Fielder = parse_element (element (cls, fields(2)))
    val vvarref: Fielder = parse_element (element (cls, fields(3)))
    val vvtmax: Fielder = parse_element (element (cls, fields(4)))
    val vvtmin: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): PFVArType1IEEEVArController =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArType1IEEEVArController (
            PFVArControllerType1Dynamics.parse (context),
            toDouble (mask (tvarc (), 0)),
            toDouble (mask (vvar (), 1)),
            toDouble (mask (vvarcbw (), 2)),
            toDouble (mask (vvarref (), 3)),
            toDouble (mask (vvtmax (), 4)),
            toDouble (mask (vvtmin (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

object PFVArType1IEEEVArControllerSerializer extends CIMSerializer[PFVArType1IEEEVArController]
{
    def write (kryo: Kryo, output: Output, obj: PFVArType1IEEEVArController): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.tvarc),
            () => output.writeDouble (obj.vvar),
            () => output.writeDouble (obj.vvarcbw),
            () => output.writeDouble (obj.vvarref),
            () => output.writeDouble (obj.vvtmax),
            () => output.writeDouble (obj.vvtmin)
        )
        PFVArControllerType1DynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PFVArType1IEEEVArController]): PFVArType1IEEEVArController =
    {
        val parent = PFVArControllerType1DynamicsSerializer.read (kryo, input, classOf[PFVArControllerType1Dynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PFVArType1IEEEVArController (
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

private[ninecode] object _PFVArControllerType1Dynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            PFVArControllerType1Dynamics.register,
            PFVArType1IEEEPFController.register,
            PFVArType1IEEEVArController.register
        )
    }
}