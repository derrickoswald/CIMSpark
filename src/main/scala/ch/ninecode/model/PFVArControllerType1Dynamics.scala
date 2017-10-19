package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Power Factor or VAr controller Type I function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this Power Factor or VAr controller Type I model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this Power Factor or VAr controller Type I model.
 * @param VoltageAdjusterDynamics [[ch.ninecode.model.VoltageAdjusterDynamics VoltageAdjusterDynamics]] Voltage adjuster model associated with this Power Factor or VA controller Type I model.
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
<font color="#0f0f0f">
</font><font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */
case class PFVArControllerType1Dynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String,
    RemoteInputSignal: String,
    VoltageAdjusterDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[PFVArControllerType1Dynamics] }
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
        implicit val clz: String = PFVArControllerType1Dynamics.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[PFVArControllerType1Dynamics]
{
    val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal",
        "VoltageAdjusterDynamics"
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))
    val VoltageAdjusterDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): PFVArControllerType1Dynamics =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PFVArControllerType1Dynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1),
            mask (VoltageAdjusterDynamics (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", false),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", false),
        Relationship ("VoltageAdjusterDynamics", "VoltageAdjusterDynamics", false)
    )
}

/**
 * The class represents IEEE PF Controller Type 1 which operates by moving the voltage reference directly.
 *
 * Reference: IEEE Standard 421.5-2005 Section 11.2.
 *
 * @param sup [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param ovex Overexcitation Flag (<i>OVEX</i>)
 *        true = overexcited
 *        false = underexcited.
 * @param tpfc PF controller time delay (<i>T</i><i><sub>PFC</sub></i>).
 *        Typical Value = 5.
 * @param vitmin Minimum machine terminal current needed to enable pf/var controller (<i>V</i><i><sub>ITMIN</sub></i>).
 * @param vpf Synchronous machine power factor (<i>V</i><i><sub>PF</sub></i>).
 * @param vpfcbw PF controller dead band (<i>V</i><i><sub>PFC_BW</sub></i>).
 *        Typical Value = 0.05.
 * @param vpfref PF controller reference (<i>V</i><i><sub>PFREF</sub></i>).
 * @param vvtmax Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>).
 * @param vvtmin Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>).
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
<font color="#0f0f0f">
</font><font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */
case class PFVArType1IEEEPFController
(
    override val sup: PFVArControllerType1Dynamics,
    ovex: Boolean,
    tpfc: Double,
    vitmin: Double,
    vpf: Double,
    vpfcbw: Double,
    vpfref: Double,
    vvtmax: Double,
    vvtmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArType1IEEEPFController] }
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
        implicit val clz: String = PFVArType1IEEEPFController.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[PFVArType1IEEEPFController]
{
    val fields: Array[String] = Array[String] (
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

    def parse (context: Context): PFVArType1IEEEPFController =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
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
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The class represents IEEE VAR Controller Type 1 which operates by moving the voltage reference directly.
 *
 * Reference: IEEE Standard 421.5-2005 Section 11.3.
 *
 * @param sup [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Reference to the superclass object.
 * @param tvarc Var controller time delay (<i>T</i><i><sub>VARC</sub></i>).
 *        Typical Value = 5.
 * @param vvar Synchronous machine power factor (<i>V</i><i><sub>VAR</sub></i>).
 * @param vvarcbw Var controller dead band (<i>V</i><i><sub>VARC_BW</sub></i>).
 *        Typical Value = 0.02.
 * @param vvarref Var controller reference (<i>V</i><i><sub>VARREF</sub></i>).
 * @param vvtmax Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>).
 * @param vvtmin Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>).
 * @group PFVArControllerType1Dynamics
 * @groupname PFVArControllerType1Dynamics Package PFVArControllerType1Dynamics
 * @groupdesc PFVArControllerType1Dynamics <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
<font color="#0f0f0f">
</font><font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */
case class PFVArType1IEEEVArController
(
    override val sup: PFVArControllerType1Dynamics,
    tvarc: Double,
    vvar: Double,
    vvarcbw: Double,
    vvarref: Double,
    vvtmax: Double,
    vvtmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArType1IEEEVArController] }
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
        implicit val clz: String = PFVArType1IEEEVArController.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[PFVArType1IEEEVArController]
{
    val fields: Array[String] = Array[String] (
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

    def parse (context: Context): PFVArType1IEEEVArController =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PFVArType1IEEEVArController (
            PFVArControllerType1Dynamics.parse (context),
            toDouble (mask (tvarc (), 0)),
            toDouble (mask (vvar (), 1)),
            toDouble (mask (vvarcbw (), 2)),
            toDouble (mask (vvarref (), 3)),
            toDouble (mask (vvtmax (), 4)),
            toDouble (mask (vvtmin (), 5))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _PFVArControllerType1Dynamics
{
    def register: List[ClassInfo] =
    {
        List (
            PFVArControllerType1Dynamics.register,
            PFVArType1IEEEPFController.register,
            PFVArType1IEEEVArController.register
        )
    }
}