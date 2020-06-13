package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Power factor or VAr controller type 2 function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this power factor or VAr controller type 2 is associated.
 * @group PFVArControllerType2Dynamics
 * @groupname PFVArControllerType2Dynamics Package PFVArControllerType2Dynamics
 * @groupdesc PFVArControllerType2Dynamics <font color="#0f0f0f">A var/pf regulator is defined as “a synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.”  </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
<font color="#0f0f0f">
</font>
 */
final case class PFVArControllerType2Dynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null
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
        implicit val clz: String = PFVArControllerType2Dynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PFVArControllerType2Dynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArControllerType2Dynamics rdf:ID=\"%s\">\n%s\t</cim:PFVArControllerType2Dynamics>".format (id, export_fields)
    }
}

object PFVArControllerType2Dynamics
extends
    CIMParseable[PFVArControllerType2Dynamics]
{
    override val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): PFVArControllerType2Dynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArControllerType2Dynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Power factor / reactive power regulator.
 *
 * This model represents the power factor or reactive power controller such as the Basler SCP-250. The controller measures power factor or reactive power (PU on generator rated power) and compares it with the operator's set point.
 * [Footnote: Basler SCP-250 is an example of a suitable product available commercially. This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of this product.]
 *
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Reference to the superclass object.
 * @param j Selector (<i>J</i>).
 *        true = control mode for reactive power
 *        false = control mode for power factor.
 * @param ki Reset gain (<i>Ki</i>).
 * @param kp Proportional gain (<i>Kp</i>).
 * @param max Output limit (<i>max</i>).
 * @param ref Reference value of reactive power or power factor (<i>Ref</i>).
 *        The reference value is initialised by this model. This initialisation can override the value exchanged by this attribute to represent a plant operator's change of the reference setting.
 * @group PFVArControllerType2Dynamics
 * @groupname PFVArControllerType2Dynamics Package PFVArControllerType2Dynamics
 * @groupdesc PFVArControllerType2Dynamics <font color="#0f0f0f">A var/pf regulator is defined as “a synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.”  </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
<font color="#0f0f0f">
</font>
 */
final case class PFVArType2Common1
(
    PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = null,
    j: Boolean = false,
    ki: Double = 0.0,
    kp: Double = 0.0,
    max: Double = 0.0,
    ref: Double = 0.0
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
    override def sup: PFVArControllerType2Dynamics = PFVArControllerType2Dynamics

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
        implicit val clz: String = PFVArType2Common1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArType2Common1.fields (position), value)
        emitelem (0, j)
        emitelem (1, ki)
        emitelem (2, kp)
        emitelem (3, max)
        emitelem (4, ref)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArType2Common1 rdf:ID=\"%s\">\n%s\t</cim:PFVArType2Common1>".format (id, export_fields)
    }
}

object PFVArType2Common1
extends
    CIMParseable[PFVArType2Common1]
{
    override val fields: Array[String] = Array[String] (
        "j",
        "ki",
        "kp",
        "max",
        "ref"
    )
    val j: Fielder = parse_element (element (cls, fields(0)))
    val ki: Fielder = parse_element (element (cls, fields(1)))
    val kp: Fielder = parse_element (element (cls, fields(2)))
    val max: Fielder = parse_element (element (cls, fields(3)))
    val ref: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): PFVArType2Common1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArType2Common1 (
            PFVArControllerType2Dynamics.parse (context),
            toBoolean (mask (j (), 0)),
            toDouble (mask (ki (), 1)),
            toDouble (mask (kp (), 2)),
            toDouble (mask (max (), 3)),
            toDouble (mask (ref (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE PF controller type 2 which is a summing point type controller making up the outside loop of a two-loop system.
 *
 * This controller is implemented as a slow PI type controller. The voltage regulator forms the inner loop and is implemented as a fast controller.
 * Reference: IEEE 421.5-2005, 11.4.
 *
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Reference to the superclass object.
 * @param exlon Overexcitation or under excitation flag (<i>EXLON</i>)
 *        true = 1 (not in the overexcitation or underexcitation state, integral action is active)
 *        false = 0 (in the overexcitation or underexcitation state, so integral action is disabled to allow the limiter to play its role).
 * @param ki Integral gain of the pf controller (<i>K</i><i><sub>I</sub></i>).
 *        Typical value = 1.
 * @param kp Proportional gain of the pf controller (<i>K</i><i><sub>P</sub></i>).
 *        Typical value = 1.
 * @param pfref Power factor reference (<i>P</i><i><sub>FREF</sub></i>).
 * @param vclmt Maximum output of the pf controller (<i>V</i><i><sub>CLMT</sub></i>).
 *        Typical value = 0,1.
 * @param vref Voltage regulator reference (<i>V</i><i><sub>REF</sub></i>).
 * @param vs Generator sensing voltage (<i>V</i><i><sub>S</sub></i>).
 * @group PFVArControllerType2Dynamics
 * @groupname PFVArControllerType2Dynamics Package PFVArControllerType2Dynamics
 * @groupdesc PFVArControllerType2Dynamics <font color="#0f0f0f">A var/pf regulator is defined as “a synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.”  </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
<font color="#0f0f0f">
</font>
 */
final case class PFVArType2IEEEPFController
(
    PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = null,
    exlon: Boolean = false,
    ki: Double = 0.0,
    kp: Double = 0.0,
    pfref: Double = 0.0,
    vclmt: Double = 0.0,
    vref: Double = 0.0,
    vs: Double = 0.0
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
    override def sup: PFVArControllerType2Dynamics = PFVArControllerType2Dynamics

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
        implicit val clz: String = PFVArType2IEEEPFController.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArType2IEEEPFController.fields (position), value)
        emitelem (0, exlon)
        emitelem (1, ki)
        emitelem (2, kp)
        emitelem (3, pfref)
        emitelem (4, vclmt)
        emitelem (5, vref)
        emitelem (6, vs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArType2IEEEPFController rdf:ID=\"%s\">\n%s\t</cim:PFVArType2IEEEPFController>".format (id, export_fields)
    }
}

object PFVArType2IEEEPFController
extends
    CIMParseable[PFVArType2IEEEPFController]
{
    override val fields: Array[String] = Array[String] (
        "exlon",
        "ki",
        "kp",
        "pfref",
        "vclmt",
        "vref",
        "vs"
    )
    val exlon: Fielder = parse_element (element (cls, fields(0)))
    val ki: Fielder = parse_element (element (cls, fields(1)))
    val kp: Fielder = parse_element (element (cls, fields(2)))
    val pfref: Fielder = parse_element (element (cls, fields(3)))
    val vclmt: Fielder = parse_element (element (cls, fields(4)))
    val vref: Fielder = parse_element (element (cls, fields(5)))
    val vs: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: CIMContext): PFVArType2IEEEPFController =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArType2IEEEPFController (
            PFVArControllerType2Dynamics.parse (context),
            toBoolean (mask (exlon (), 0)),
            toDouble (mask (ki (), 1)),
            toDouble (mask (kp (), 2)),
            toDouble (mask (pfref (), 3)),
            toDouble (mask (vclmt (), 4)),
            toDouble (mask (vref (), 5)),
            toDouble (mask (vs (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE VAR controller type 2 which is a summing point type controller.
 *
 * It makes up the outside loop of a two-loop system. This controller is implemented as a slow PI type controller, and the voltage regulator forms the inner loop and is implemented as a fast controller.
 * Reference: IEEE 421.5-2005, 11.5.
 *
 * @param PFVArControllerType2Dynamics [[ch.ninecode.model.PFVArControllerType2Dynamics PFVArControllerType2Dynamics]] Reference to the superclass object.
 * @param exlon Overexcitation or under excitation flag (<i>EXLON</i>)
 *        true = 1 (not in the overexcitation or underexcitation state, integral action is active)
 *        false = 0 (in the overexcitation or underexcitation state, so integral action is disabled to allow the limiter to play its role).
 * @param ki Integral gain of the pf controller (<i>K</i><i><sub>I</sub></i>).
 * @param kp Proportional gain of the pf controller (<i>K</i><i><sub>P</sub></i>).
 * @param qref Reactive power reference (<i>Q</i><i><sub>REF</sub></i>).
 * @param vclmt Maximum output of the pf controller (<i>V</i><i><sub>CLMT</sub></i>).
 * @param vref Voltage regulator reference (<i>V</i><i><sub>REF</sub></i>).
 * @param vs Generator sensing voltage (<i>V</i><i><sub>S</sub></i>).
 * @group PFVArControllerType2Dynamics
 * @groupname PFVArControllerType2Dynamics Package PFVArControllerType2Dynamics
 * @groupdesc PFVArControllerType2Dynamics <font color="#0f0f0f">A var/pf regulator is defined as “a synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.”  </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
<font color="#0f0f0f">
</font>
 */
final case class PFVArType2IEEEVArController
(
    PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = null,
    exlon: Boolean = false,
    ki: Double = 0.0,
    kp: Double = 0.0,
    qref: Double = 0.0,
    vclmt: Double = 0.0,
    vref: Double = 0.0,
    vs: Double = 0.0
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
    override def sup: PFVArControllerType2Dynamics = PFVArControllerType2Dynamics

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
        implicit val clz: String = PFVArType2IEEEVArController.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PFVArType2IEEEVArController.fields (position), value)
        emitelem (0, exlon)
        emitelem (1, ki)
        emitelem (2, kp)
        emitelem (3, qref)
        emitelem (4, vclmt)
        emitelem (5, vref)
        emitelem (6, vs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PFVArType2IEEEVArController rdf:ID=\"%s\">\n%s\t</cim:PFVArType2IEEEVArController>".format (id, export_fields)
    }
}

object PFVArType2IEEEVArController
extends
    CIMParseable[PFVArType2IEEEVArController]
{
    override val fields: Array[String] = Array[String] (
        "exlon",
        "ki",
        "kp",
        "qref",
        "vclmt",
        "vref",
        "vs"
    )
    val exlon: Fielder = parse_element (element (cls, fields(0)))
    val ki: Fielder = parse_element (element (cls, fields(1)))
    val kp: Fielder = parse_element (element (cls, fields(2)))
    val qref: Fielder = parse_element (element (cls, fields(3)))
    val vclmt: Fielder = parse_element (element (cls, fields(4)))
    val vref: Fielder = parse_element (element (cls, fields(5)))
    val vs: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: CIMContext): PFVArType2IEEEVArController =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PFVArType2IEEEVArController (
            PFVArControllerType2Dynamics.parse (context),
            toBoolean (mask (exlon (), 0)),
            toDouble (mask (ki (), 1)),
            toDouble (mask (kp (), 2)),
            toDouble (mask (qref (), 3)),
            toDouble (mask (vclmt (), 4)),
            toDouble (mask (vref (), 5)),
            toDouble (mask (vs (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _PFVArControllerType2Dynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            PFVArControllerType2Dynamics.register,
            PFVArType2Common1.register,
            PFVArType2IEEEPFController.register,
            PFVArType2IEEEVArController.register
        )
    }
}