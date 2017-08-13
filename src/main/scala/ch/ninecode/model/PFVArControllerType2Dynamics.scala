package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[PFVArControllerType2Dynamics] }
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
        (if (null != ExcitationSystemDynamics) "\t\t<cim:PFVArControllerType2Dynamics.ExcitationSystemDynamics rdf:resource=\"#" + ExcitationSystemDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType2Dynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArControllerType2Dynamics>"
    }
}

object PFVArControllerType2Dynamics
extends
    Parseable[PFVArControllerType2Dynamics]
{
    val ExcitationSystemDynamics = parse_attribute (attribute ("""PFVArControllerType2Dynamics.ExcitationSystemDynamics"""))
    def parse (context: Context): PFVArControllerType2Dynamics =
    {
        PFVArControllerType2Dynamics(
            DynamicsFunctionBlock.parse (context),
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
(
    override val sup: PFVArControllerType2Dynamics,
    j: Boolean,
    ki: Double,
    kp: Double,
    max: Double,
    ref: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArType2Common1] }
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
        "\t\t<cim:PFVArType2Common1.j>" + j + "</cim:PFVArType2Common1.j>\n" +
        "\t\t<cim:PFVArType2Common1.ki>" + ki + "</cim:PFVArType2Common1.ki>\n" +
        "\t\t<cim:PFVArType2Common1.kp>" + kp + "</cim:PFVArType2Common1.kp>\n" +
        "\t\t<cim:PFVArType2Common1.max>" + max + "</cim:PFVArType2Common1.max>\n" +
        "\t\t<cim:PFVArType2Common1.ref>" + ref + "</cim:PFVArType2Common1.ref>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArType2Common1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArType2Common1>"
    }
}

object PFVArType2Common1
extends
    Parseable[PFVArType2Common1]
{
    val j = parse_element (element ("""PFVArType2Common1.j"""))
    val ki = parse_element (element ("""PFVArType2Common1.ki"""))
    val kp = parse_element (element ("""PFVArType2Common1.kp"""))
    val max = parse_element (element ("""PFVArType2Common1.max"""))
    val ref = parse_element (element ("""PFVArType2Common1.ref"""))
    def parse (context: Context): PFVArType2Common1 =
    {
        PFVArType2Common1(
            PFVArControllerType2Dynamics.parse (context),
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
(
    override val sup: PFVArControllerType2Dynamics,
    exlon: Boolean,
    ki: Double,
    kp: Double,
    pfref: Double,
    vclmt: Double,
    vref: Double,
    vs: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArType2IEEEPFController] }
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
        "\t\t<cim:PFVArType2IEEEPFController.exlon>" + exlon + "</cim:PFVArType2IEEEPFController.exlon>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.ki>" + ki + "</cim:PFVArType2IEEEPFController.ki>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.kp>" + kp + "</cim:PFVArType2IEEEPFController.kp>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.pfref>" + pfref + "</cim:PFVArType2IEEEPFController.pfref>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.vclmt>" + vclmt + "</cim:PFVArType2IEEEPFController.vclmt>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.vref>" + vref + "</cim:PFVArType2IEEEPFController.vref>\n" +
        "\t\t<cim:PFVArType2IEEEPFController.vs>" + vs + "</cim:PFVArType2IEEEPFController.vs>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArType2IEEEPFController rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArType2IEEEPFController>"
    }
}

object PFVArType2IEEEPFController
extends
    Parseable[PFVArType2IEEEPFController]
{
    val exlon = parse_element (element ("""PFVArType2IEEEPFController.exlon"""))
    val ki = parse_element (element ("""PFVArType2IEEEPFController.ki"""))
    val kp = parse_element (element ("""PFVArType2IEEEPFController.kp"""))
    val pfref = parse_element (element ("""PFVArType2IEEEPFController.pfref"""))
    val vclmt = parse_element (element ("""PFVArType2IEEEPFController.vclmt"""))
    val vref = parse_element (element ("""PFVArType2IEEEPFController.vref"""))
    val vs = parse_element (element ("""PFVArType2IEEEPFController.vs"""))
    def parse (context: Context): PFVArType2IEEEPFController =
    {
        PFVArType2IEEEPFController(
            PFVArControllerType2Dynamics.parse (context),
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
(
    override val sup: PFVArControllerType2Dynamics,
    exlon: Boolean,
    ki: Double,
    kp: Double,
    qref: Double,
    vclmt: Double,
    vref: Double,
    vs: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[PFVArType2IEEEVArController] }
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
        "\t\t<cim:PFVArType2IEEEVArController.exlon>" + exlon + "</cim:PFVArType2IEEEVArController.exlon>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.ki>" + ki + "</cim:PFVArType2IEEEVArController.ki>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.kp>" + kp + "</cim:PFVArType2IEEEVArController.kp>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.qref>" + qref + "</cim:PFVArType2IEEEVArController.qref>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.vclmt>" + vclmt + "</cim:PFVArType2IEEEVArController.vclmt>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.vref>" + vref + "</cim:PFVArType2IEEEVArController.vref>\n" +
        "\t\t<cim:PFVArType2IEEEVArController.vs>" + vs + "</cim:PFVArType2IEEEVArController.vs>\n"
    }
    override def export: String =
    {
        "\t<cim:PFVArType2IEEEVArController rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PFVArType2IEEEVArController>"
    }
}

object PFVArType2IEEEVArController
extends
    Parseable[PFVArType2IEEEVArController]
{
    val exlon = parse_element (element ("""PFVArType2IEEEVArController.exlon"""))
    val ki = parse_element (element ("""PFVArType2IEEEVArController.ki"""))
    val kp = parse_element (element ("""PFVArType2IEEEVArController.kp"""))
    val qref = parse_element (element ("""PFVArType2IEEEVArController.qref"""))
    val vclmt = parse_element (element ("""PFVArType2IEEEVArController.vclmt"""))
    val vref = parse_element (element ("""PFVArType2IEEEVArController.vref"""))
    val vs = parse_element (element ("""PFVArType2IEEEVArController.vs"""))
    def parse (context: Context): PFVArType2IEEEVArController =
    {
        PFVArType2IEEEVArController(
            PFVArControllerType2Dynamics.parse (context),
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

private[ninecode] object _PFVArControllerType2Dynamics
{
    def register: List[ClassInfo] =
    {
        List (
            PFVArControllerType2Dynamics.register,
            PFVArType2Common1.register,
            PFVArType2IEEEPFController.register,
            PFVArType2IEEEVArController.register
        )
    }
}