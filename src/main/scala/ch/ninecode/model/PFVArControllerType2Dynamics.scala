package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font color="#0f0f0f">A var/pf regulator is defined as �A synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.�  </font>
<font color="#0f0f0f">
</font><font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
<font color="#0f0f0f">
 * </font>
 */

/**
 * Power Factor or VAr controller Type II function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this Power Factor or VAr controller Type II is associated.
 */
case class PFVArControllerType2Dynamics
(override val sup: DynamicsFunctionBlock,
val ExcitationSystemDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArControllerType2Dynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArControllerType2Dynamics
extends
    Parseable[PFVArControllerType2Dynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PFVArControllerType2Dynamics.ExcitationSystemDynamics"""))_
    def parse (context: Context): PFVArControllerType2Dynamics =
    {
        PFVArControllerType2Dynamics(
            sup (context),
            ExcitationSystemDynamics (context)
        )
    }
}

/**
 * Power factor / Reactive power regulator.
 * This model represents the power factor or reactive power controller such as the Basler SCP-250. The controller measures power factor or reactive power (PU on generator rated power) and compares it with the operator's set point.
 * @param sup Reference to the superclass object.
 * @param j Selector (J).
true = control mode for reactive power
 *        false = control mode for power factor.
 * @param ki Reset gain (Ki).
 * @param kp Proportional gain (Kp).
 * @param max Output limit (max).
 * @param ref Reference value of reactive power or power factor (Ref).
 *        The reference value is initialised by this model. This initialisation may override the value exchanged by this attribute to represent a plant operator's change of the reference setting.
 */
case class PFVArType2Common1
(override val sup: PFVArControllerType2Dynamics,
val j: Boolean,
val ki: Double,
val kp: Double,
val max: Double,
val ref: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArType2Common1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArType2Common1
extends
    Parseable[PFVArType2Common1]
{
    val sup = PFVArControllerType2Dynamics.parse _
    val j = parse_element (element ("""PFVArType2Common1.j"""))_
    val ki = parse_element (element ("""PFVArType2Common1.ki"""))_
    val kp = parse_element (element ("""PFVArType2Common1.kp"""))_
    val max = parse_element (element ("""PFVArType2Common1.max"""))_
    val ref = parse_element (element ("""PFVArType2Common1.ref"""))_
    def parse (context: Context): PFVArType2Common1 =
    {
        PFVArType2Common1(
            sup (context),
            toBoolean (j (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (max (context), context),
            toDouble (ref (context), context)
        )
    }
}

/**
 * The class represents IEEE PF Controller Type 2 which is a summing point type controller and makes up the outside loop of a two-loop system.
 * This controller is implemented as a slow PI type controller. The voltage regulator forms the inner loop and is implemented as a fast controller.
 * @param sup Reference to the superclass object.
 * @param exlon Overexcitation or under excitation flag (<i>EXLON</i>)
true = 1 (not in the overexcitation or underexcitation state, integral action is active)
 *        false = 0 (in the overexcitation or underexcitation state, so integral action is disabled to allow the limiter to play its role).
 * @param ki Integral gain of the pf controller (<i>K</i><i><sub>I</sub></i>).
 *        Typical Value = 1.
 * @param kp Proportional gain of the pf controller (<i>K</i><i><sub>P</sub></i>).
 *        Typical Value = 1.
 * @param pfref Power factor reference (<i>P</i><i><sub>FREF</sub></i>).
 * @param vclmt Maximum output of the pf controller (<i>V</i><i><sub>CLMT</sub></i>).
 *        Typical Value = 0.1.
 * @param vref Voltage regulator reference (<i>V</i><i><sub>REF</sub></i>).
 * @param vs Generator sensing voltage (<i>V</i><i><sub>S</sub></i>).
 */
case class PFVArType2IEEEPFController
(override val sup: PFVArControllerType2Dynamics,
val exlon: Boolean,
val ki: Double,
val kp: Double,
val pfref: Double,
val vclmt: Double,
val vref: Double,
val vs: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArType2IEEEPFController]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArType2IEEEPFController
extends
    Parseable[PFVArType2IEEEPFController]
{
    val sup = PFVArControllerType2Dynamics.parse _
    val exlon = parse_element (element ("""PFVArType2IEEEPFController.exlon"""))_
    val ki = parse_element (element ("""PFVArType2IEEEPFController.ki"""))_
    val kp = parse_element (element ("""PFVArType2IEEEPFController.kp"""))_
    val pfref = parse_element (element ("""PFVArType2IEEEPFController.pfref"""))_
    val vclmt = parse_element (element ("""PFVArType2IEEEPFController.vclmt"""))_
    val vref = parse_element (element ("""PFVArType2IEEEPFController.vref"""))_
    val vs = parse_element (element ("""PFVArType2IEEEPFController.vs"""))_
    def parse (context: Context): PFVArType2IEEEPFController =
    {
        PFVArType2IEEEPFController(
            sup (context),
            toBoolean (exlon (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (pfref (context), context),
            toDouble (vclmt (context), context),
            toDouble (vref (context), context),
            toDouble (vs (context), context)
        )
    }
}

/**
 * The class represents IEEE VAR Controller Type 2 which is a summing point type controller.
 * It makes up the outside loop of a two-loop system. This controller is implemented as a slow PI type controller, and the voltage regulator forms the inner loop and is implemented as a fast controller.
 * @param sup Reference to the superclass object.
 * @param exlon Overexcitation or under excitation flag (<i>EXLON</i>)
true = 1 (not in the overexcitation or underexcitation state, integral action is active)
 *        false = 0 (in the overexcitation or underexcitation state, so integral action is disabled to allow the limiter to play its role).
 * @param ki Integral gain of the pf controller (<i>K</i><i><sub>I</sub></i>).
 * @param kp Proportional gain of the pf controller (<i>K</i><i><sub>P</sub></i>).
 * @param qref Reactive power reference (<i>Q</i><i><sub>REF</sub></i>).
 * @param vclmt Maximum output of the pf controller (<i>V</i><i><sub>CLMT</sub></i>).
 * @param vref Voltage regulator reference (<i>V</i><i><sub>REF</sub></i>).
 * @param vs Generator sensing voltage (<i>V</i><i><sub>S</sub></i>).
 */
case class PFVArType2IEEEVArController
(override val sup: PFVArControllerType2Dynamics,
val exlon: Boolean,
val ki: Double,
val kp: Double,
val qref: Double,
val vclmt: Double,
val vref: Double,
val vs: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArType2IEEEVArController]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArType2IEEEVArController
extends
    Parseable[PFVArType2IEEEVArController]
{
    val sup = PFVArControllerType2Dynamics.parse _
    val exlon = parse_element (element ("""PFVArType2IEEEVArController.exlon"""))_
    val ki = parse_element (element ("""PFVArType2IEEEVArController.ki"""))_
    val kp = parse_element (element ("""PFVArType2IEEEVArController.kp"""))_
    val qref = parse_element (element ("""PFVArType2IEEEVArController.qref"""))_
    val vclmt = parse_element (element ("""PFVArType2IEEEVArController.vclmt"""))_
    val vref = parse_element (element ("""PFVArType2IEEEVArController.vref"""))_
    val vs = parse_element (element ("""PFVArType2IEEEVArController.vs"""))_
    def parse (context: Context): PFVArType2IEEEVArController =
    {
        PFVArType2IEEEVArController(
            sup (context),
            toBoolean (exlon (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (qref (context), context),
            toDouble (vclmt (context), context),
            toDouble (vref (context), context),
            toDouble (vs (context), context)
        )
    }
}

object _PFVArControllerType2Dynamics
{
    def register: Unit =
    {
        PFVArControllerType2Dynamics.register
        PFVArType2Common1.register
        PFVArType2IEEEPFController.register
        PFVArType2IEEEVArController.register
    }
}