package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.
 * A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
 */

/**
 * Power Factor or VAr controller Type I function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this Power Factor or VAr controller Type I model is associated.
 * @param RemoteInputSignal Remote input signal used by this Power Factor or VAr controller Type I model.
 * @param VoltageAdjusterDynamics Voltage adjuster model associated with this Power Factor or VA controller Type I model.
 */
case class PFVArControllerType1Dynamics
(
    override val sup: DynamicsFunctionBlock,
    val ExcitationSystemDynamics: String,
    val RemoteInputSignal: String,
    val VoltageAdjusterDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArControllerType1Dynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArControllerType1Dynamics
extends
    Parseable[PFVArControllerType1Dynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal = parse_attribute (attribute ("""PFVArControllerType1Dynamics.RemoteInputSignal"""))
    val VoltageAdjusterDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.VoltageAdjusterDynamics"""))
    def parse (context: Context): PFVArControllerType1Dynamics =
    {
        PFVArControllerType1Dynamics(
            sup (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context),
            VoltageAdjusterDynamics (context)
        )
    }
}

/**
 * The class represents IEEE PF Controller Type 1 which operates by moving the voltage reference directly.
 * Reference: IEEE Standard 421.5-2005 Section 11.2.
 * @param sup Reference to the superclass object.
 * @param ovex Overexcitation Flag (<i>OVEX</i>)
true = overexcited
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
 */
case class PFVArType1IEEEPFController
(
    override val sup: PFVArControllerType1Dynamics,
    val ovex: Boolean,
    val tpfc: Double,
    val vitmin: Double,
    val vpf: Double,
    val vpfcbw: Double,
    val vpfref: Double,
    val vvtmax: Double,
    val vvtmin: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArType1IEEEPFController]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArType1IEEEPFController
extends
    Parseable[PFVArType1IEEEPFController]
{
    val sup = PFVArControllerType1Dynamics.parse _
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
            sup (context),
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
 * Reference: IEEE Standard 421.5-2005 Section 11.3.
 * @param sup Reference to the superclass object.
 * @param tvarc Var controller time delay (<i>T</i><i><sub>VARC</sub></i>).
 *        Typical Value = 5.
 * @param vvar Synchronous machine power factor (<i>V</i><i><sub>VAR</sub></i>).
 * @param vvarcbw Var controller dead band (<i>V</i><i><sub>VARC_BW</sub></i>).
 *        Typical Value = 0.02.
 * @param vvarref Var controller reference (<i>V</i><i><sub>VARREF</sub></i>).
 * @param vvtmax Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>).
 * @param vvtmin Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>).
 */
case class PFVArType1IEEEVArController
(
    override val sup: PFVArControllerType1Dynamics,
    val tvarc: Double,
    val vvar: Double,
    val vvarcbw: Double,
    val vvarref: Double,
    val vvtmax: Double,
    val vvtmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArType1IEEEVArController]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArType1IEEEVArController
extends
    Parseable[PFVArType1IEEEVArController]
{
    val sup = PFVArControllerType1Dynamics.parse _
    val tvarc = parse_element (element ("""PFVArType1IEEEVArController.tvarc"""))
    val vvar = parse_element (element ("""PFVArType1IEEEVArController.vvar"""))
    val vvarcbw = parse_element (element ("""PFVArType1IEEEVArController.vvarcbw"""))
    val vvarref = parse_element (element ("""PFVArType1IEEEVArController.vvarref"""))
    val vvtmax = parse_element (element ("""PFVArType1IEEEVArController.vvtmax"""))
    val vvtmin = parse_element (element ("""PFVArType1IEEEVArController.vvtmin"""))
    def parse (context: Context): PFVArType1IEEEVArController =
    {
        PFVArType1IEEEVArController(
            sup (context),
            toDouble (tvarc (context), context),
            toDouble (vvar (context), context),
            toDouble (vvarcbw (context), context),
            toDouble (vvarref (context), context),
            toDouble (vvtmax (context), context),
            toDouble (vvtmin (context), context)
        )
    }
}

object _PFVArControllerType1Dynamics
{
    def register: Unit =
    {
        PFVArControllerType1Dynamics.register
        PFVArType1IEEEPFController.register
        PFVArType1IEEEVArController.register
    }
}