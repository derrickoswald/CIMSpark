package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        (if (null != ExcitationSystemDynamics) "\t\t<cim:PFVArControllerType1Dynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:PFVArControllerType1Dynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "") +
        (if (null != VoltageAdjusterDynamics) "\t\t<cim:PFVArControllerType1Dynamics.VoltageAdjusterDynamics rdf:resource=\"#" + VoltageAdjusterDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType1Dynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArControllerType1Dynamics>"
    }
}

object PFVArControllerType1Dynamics
extends
    Parseable[PFVArControllerType1Dynamics]
{
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal = parse_attribute (attribute ("""PFVArControllerType1Dynamics.RemoteInputSignal"""))
    val VoltageAdjusterDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.VoltageAdjusterDynamics"""))
    def parse (context: Context): PFVArControllerType1Dynamics =
    {
        PFVArControllerType1Dynamics(
            DynamicsFunctionBlock.parse (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context),
            VoltageAdjusterDynamics (context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:PFVArType1IEEEPFController.ovex>" + ovex + "</cim:PFVArType1IEEEPFController.ovex>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.tpfc>" + tpfc + "</cim:PFVArType1IEEEPFController.tpfc>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vitmin>" + vitmin + "</cim:PFVArType1IEEEPFController.vitmin>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vpf>" + vpf + "</cim:PFVArType1IEEEPFController.vpf>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vpfcbw>" + vpfcbw + "</cim:PFVArType1IEEEPFController.vpfcbw>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vpfref>" + vpfref + "</cim:PFVArType1IEEEPFController.vpfref>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vvtmax>" + vvtmax + "</cim:PFVArType1IEEEPFController.vvtmax>\n" +
        "\t\t<cim:PFVArType1IEEEPFController.vvtmin>" + vvtmin + "</cim:PFVArType1IEEEPFController.vvtmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArType1IEEEPFController rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArType1IEEEPFController>"
    }
}

object PFVArType1IEEEPFController
extends
    Parseable[PFVArType1IEEEPFController]
{
    val ovex = parse_element (element ("""PFVArType1IEEEPFController.ovex"""))
    val tpfc = parse_element (element ("""PFVArType1IEEEPFController.tpfc"""))
    val vitmin = parse_element (element ("""PFVArType1IEEEPFController.vitmin"""))
    val vpf = parse_element (element ("""PFVArType1IEEEPFController.vpf"""))
    val vpfcbw = parse_element (element ("""PFVArType1IEEEPFController.vpfcbw"""))
    val vpfref = parse_element (element ("""PFVArType1IEEEPFController.vpfref"""))
    val vvtmax = parse_element (element ("""PFVArType1IEEEPFController.vvtmax"""))
    val vvtmin = parse_element (element ("""PFVArType1IEEEPFController.vvtmin"""))
    def parse (context: Context): PFVArType1IEEEPFController =
    {
        PFVArType1IEEEPFController(
            PFVArControllerType1Dynamics.parse (context),
            toBoolean (ovex (context), context),
            toDouble (tpfc (context), context),
            toDouble (vitmin (context), context),
            toDouble (vpf (context), context),
            toDouble (vpfcbw (context), context),
            toDouble (vpfref (context), context),
            toDouble (vvtmax (context), context),
            toDouble (vvtmin (context), context)
        )
    }
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
        sup.export_fields +
        "\t\t<cim:PFVArType1IEEEVArController.tvarc>" + tvarc + "</cim:PFVArType1IEEEVArController.tvarc>\n" +
        "\t\t<cim:PFVArType1IEEEVArController.vvar>" + vvar + "</cim:PFVArType1IEEEVArController.vvar>\n" +
        "\t\t<cim:PFVArType1IEEEVArController.vvarcbw>" + vvarcbw + "</cim:PFVArType1IEEEVArController.vvarcbw>\n" +
        "\t\t<cim:PFVArType1IEEEVArController.vvarref>" + vvarref + "</cim:PFVArType1IEEEVArController.vvarref>\n" +
        "\t\t<cim:PFVArType1IEEEVArController.vvtmax>" + vvtmax + "</cim:PFVArType1IEEEVArController.vvtmax>\n" +
        "\t\t<cim:PFVArType1IEEEVArController.vvtmin>" + vvtmin + "</cim:PFVArType1IEEEVArController.vvtmin>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArType1IEEEVArController rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArType1IEEEVArController>"
    }
}

object PFVArType1IEEEVArController
extends
    Parseable[PFVArType1IEEEVArController]
{
    val tvarc = parse_element (element ("""PFVArType1IEEEVArController.tvarc"""))
    val vvar = parse_element (element ("""PFVArType1IEEEVArController.vvar"""))
    val vvarcbw = parse_element (element ("""PFVArType1IEEEVArController.vvarcbw"""))
    val vvarref = parse_element (element ("""PFVArType1IEEEVArController.vvarref"""))
    val vvtmax = parse_element (element ("""PFVArType1IEEEVArController.vvtmax"""))
    val vvtmin = parse_element (element ("""PFVArType1IEEEVArController.vvtmin"""))
    def parse (context: Context): PFVArType1IEEEVArController =
    {
        PFVArType1IEEEVArController(
            PFVArControllerType1Dynamics.parse (context),
            toDouble (tvarc (context), context),
            toDouble (vvar (context), context),
            toDouble (vvarcbw (context), context),
            toDouble (vvarref (context), context),
            toDouble (vvtmax (context), context),
            toDouble (vvtmin (context), context)
        )
    }
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