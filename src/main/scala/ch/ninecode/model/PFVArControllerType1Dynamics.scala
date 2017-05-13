package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.
 * A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
 */

/**
 * Power Factor or VAr controller Type I function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 */
case class PFVArControllerType1Dynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Excitation system model with which this Power Factor or VAr controller Type I model is associated.
     */
    val ExcitationSystemDynamics: String,

    /**
     * Remote input signal used by this Power Factor or VAr controller Type I model.
     */
    val RemoteInputSignal: String,

    /**
     * Voltage adjuster model associated with this Power Factor or VA controller Type I model.
     */
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
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.ExcitationSystemDynamics"""))_
    val RemoteInputSignal = parse_attribute (attribute ("""PFVArControllerType1Dynamics.RemoteInputSignal"""))_
    val VoltageAdjusterDynamics = parse_attribute (attribute ("""PFVArControllerType1Dynamics.VoltageAdjusterDynamics"""))_
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
 */
case class PFVArType1IEEEPFController
(

    override val sup: PFVArControllerType1Dynamics,

    /**
     * Overexcitation Flag (<i>OVEX</i>)
    true = overexcited
     * false = underexcited.
     */
    val ovex: Boolean,

    /**
     * PF controller time delay (<i>T</i><i><sub>PFC</sub></i>).
     * Typical Value = 5.
     */
    val tpfc: Double,

    /**
     * Minimum machine terminal current needed to enable pf/var controller (<i>V</i><i><sub>ITMIN</sub></i>).
     */
    val vitmin: Double,

    /**
     * Synchronous machine power factor (<i>V</i><i><sub>PF</sub></i>).
     */
    val vpf: Double,

    /**
     * PF controller dead band (<i>V</i><i><sub>PFC_BW</sub></i>).
     * Typical Value = 0.05.
     */
    val vpfcbw: Double,

    /**
     * PF controller reference (<i>V</i><i><sub>PFREF</sub></i>).
     */
    val vpfref: Double,

    /**
     * Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>).
     */
    val vvtmax: Double,

    /**
     * Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>).
     */
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
    val ovex = parse_element (element ("""PFVArType1IEEEPFController.ovex"""))_
    val tpfc = parse_element (element ("""PFVArType1IEEEPFController.tpfc"""))_
    val vitmin = parse_element (element ("""PFVArType1IEEEPFController.vitmin"""))_
    val vpf = parse_element (element ("""PFVArType1IEEEPFController.vpf"""))_
    val vpfcbw = parse_element (element ("""PFVArType1IEEEPFController.vpfcbw"""))_
    val vpfref = parse_element (element ("""PFVArType1IEEEPFController.vpfref"""))_
    val vvtmax = parse_element (element ("""PFVArType1IEEEPFController.vvtmax"""))_
    val vvtmin = parse_element (element ("""PFVArType1IEEEPFController.vvtmin"""))_
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
 */
case class PFVArType1IEEEVArController
(

    override val sup: PFVArControllerType1Dynamics,

    /**
     * Var controller time delay (<i>T</i><i><sub>VARC</sub></i>).
     * Typical Value = 5.
     */
    val tvarc: Double,

    /**
     * Synchronous machine power factor (<i>V</i><i><sub>VAR</sub></i>).
     */
    val vvar: Double,

    /**
     * Var controller dead band (<i>V</i><i><sub>VARC_BW</sub></i>).
     * Typical Value = 0.02.
     */
    val vvarcbw: Double,

    /**
     * Var controller reference (<i>V</i><i><sub>VARREF</sub></i>).
     */
    val vvarref: Double,

    /**
     * Maximum machine terminal voltage needed for pf/var controller to be enabled (<i>V</i><i><sub>VTMAX</sub></i>).
     */
    val vvtmax: Double,

    /**
     * Minimum machine terminal voltage needed to enable pf/var controller (<i>V</i><i><sub>VTMIN</sub></i>).
     */
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
    val tvarc = parse_element (element ("""PFVArType1IEEEVArController.tvarc"""))_
    val vvar = parse_element (element ("""PFVArType1IEEEVArController.vvar"""))_
    val vvarcbw = parse_element (element ("""PFVArType1IEEEVArController.vvarcbw"""))_
    val vvarref = parse_element (element ("""PFVArType1IEEEVArController.vvarref"""))_
    val vvtmax = parse_element (element ("""PFVArType1IEEEVArController.vvtmax"""))_
    val vvtmin = parse_element (element ("""PFVArType1IEEEVArController.vvtmin"""))_
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