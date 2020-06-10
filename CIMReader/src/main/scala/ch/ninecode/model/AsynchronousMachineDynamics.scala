package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Asynchronous machine whose behaviour is described by reference to a standard model expressed in either time constant reactance form or equivalent circuit form <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * Parameter details:
 * <ol>
 * <li>Asynchronous machine parameters such as <i>Xl, Xs,</i> etc. are actually used as inductances in the model, but are commonly referred to as reactances since, at nominal frequency, the PU values are the same.
 *
 * However, some references use the symbol <i>L</i> instead of <i>X</i>.</li>
 * </ol>
 *
 * @param RotatingMachineDynamics [[ch.ninecode.model.RotatingMachineDynamics RotatingMachineDynamics]] Reference to the superclass object.
 * @param AsynchronousMachine [[ch.ninecode.model.AsynchronousMachine AsynchronousMachine]] Asynchronous machine to which this asynchronous machine dynamics model applies.
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Mechanical load model associated with this asynchronous machine model.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor model associated with this asynchronous machine model.
 * @param WindTurbineType1or2Dynamics [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Wind generator type 1 or type 2 model associated with this asynchronous machine model.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g. a squirrel-cage induction machine. 
The interconnection with the electrical network equations can differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
The asynchronous machine model is used to model wind generators type 1 and type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
final case class AsynchronousMachineDynamics
(
    RotatingMachineDynamics: RotatingMachineDynamics = null,
    AsynchronousMachine: String = null,
    MechanicalLoadDynamics: String = null,
    TurbineGovernorDynamics: String = null,
    WindTurbineType1or2Dynamics: String = null
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
    override def sup: RotatingMachineDynamics = RotatingMachineDynamics

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
        implicit val clz: String = AsynchronousMachineDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AsynchronousMachineDynamics.fields (position), value)
        emitattr (0, AsynchronousMachine)
        emitattr (1, MechanicalLoadDynamics)
        emitattr (2, TurbineGovernorDynamics)
        emitattr (3, WindTurbineType1or2Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineDynamics rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineDynamics>".format (id, export_fields)
    }
}

object AsynchronousMachineDynamics
extends
    CIMParseable[AsynchronousMachineDynamics]
{
    override val fields: Array[String] = Array[String] (
        "AsynchronousMachine",
        "MechanicalLoadDynamics",
        "TurbineGovernorDynamics",
        "WindTurbineType1or2Dynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AsynchronousMachine", "AsynchronousMachine", "1", "0..1"),
        CIMRelationship ("MechanicalLoadDynamics", "MechanicalLoadDynamics", "0..1", "0..1"),
        CIMRelationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "0..1", "0..1"),
        CIMRelationship ("WindTurbineType1or2Dynamics", "WindTurbineType1or2Dynamics", "0..1", "1")
    )
    val AsynchronousMachine: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MechanicalLoadDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WindTurbineType1or2Dynamics: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): AsynchronousMachineDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineDynamics (
            RotatingMachineDynamics.parse (context),
            mask (AsynchronousMachine (), 0),
            mask (MechanicalLoadDynamics (), 1),
            mask (TurbineGovernorDynamics (), 2),
            mask (WindTurbineType1or2Dynamics (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The electrical equations of all variations of the asynchronous model are based on the AsynchronousEquivalentCircuit diagram for the direct- and quadrature- axes, with two equivalent rotor windings in each axis.
 *
 * Equations for conversion between equivalent circuit and time constant reactance forms:
 * <i>Xs</i> = <i>Xm</i> + <i>Xl</i>
 * <i>X'</i> = <i>Xl</i> + <i>Xm</i> x <i>Xlr1 </i>/ (<i>Xm </i>+ <i>Xlr1</i>)
 * <i>X''</i> = <i>Xl</i> + <i>Xm</i> x <i>Xlr1</i> x <i>Xlr2</i> / (<i>Xm</i> x <i>Xlr1</i> + <i>Xm</i> x <i>Xlr2</i> + <i>Xlr1</i> x <i>Xlr2</i>)
 * <i>T'o</i> = (<i>Xm</i> + <i>Xlr1</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>Rr1</i>)
 * <i>T''o</i> = (<i>Xm</i> x <i>Xlr1</i> + <i>Xm</i> x <i>Xlr2</i> + <i>Xlr1</i> x <i>Xlr2</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>Rr2</i> x (<i>Xm</i> + <i>Xlr1</i>)
 * Same equations using CIM attributes from AsynchronousMachineTimeConstantReactance class on left of "=" and AsynchronousMachineEquivalentCircuit class on right (except as noted):
 * xs = xm + RotatingMachineDynamics.statorLeakageReactance
 * xp = RotatingMachineDynamics.statorLeakageReactance + xm x xlr1 / (xm + xlr1)
 * xpp = RotatingMachineDynamics.statorLeakageReactance + xm x xlr1 x xlr2 / (xm x xlr1 + xm x xlr2 + xlr1 x xlr2)
 * tpo = (xm + xlr1) / (2 x pi x nominal frequency x rr1)
 * tppo = (xm x xlr1 + xm x xlr2 + xlr1 x xlr2) / (2 x pi x nominal frequency x rr2 x (xm + xlr1).
 *
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g. a squirrel-cage induction machine. 
The interconnection with the electrical network equations can differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
The asynchronous machine model is used to model wind generators type 1 and type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
final case class AsynchronousMachineEquivalentCircuit
(
    AsynchronousMachineDynamics: AsynchronousMachineDynamics = null,
    rr1: Double = 0.0,
    rr2: Double = 0.0,
    xlr1: Double = 0.0,
    xlr2: Double = 0.0,
    xm: Double = 0.0
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
    override def sup: AsynchronousMachineDynamics = AsynchronousMachineDynamics

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
        implicit val clz: String = AsynchronousMachineEquivalentCircuit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineEquivalentCircuit.fields (position), value)
        emitelem (0, rr1)
        emitelem (1, rr2)
        emitelem (2, xlr1)
        emitelem (3, xlr2)
        emitelem (4, xm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineEquivalentCircuit rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineEquivalentCircuit>".format (id, export_fields)
    }
}

object AsynchronousMachineEquivalentCircuit
extends
    CIMParseable[AsynchronousMachineEquivalentCircuit]
{
    override val fields: Array[String] = Array[String] (
        "rr1",
        "rr2",
        "xlr1",
        "xlr2",
        "xm"
    )
    val rr1: Fielder = parse_element (element (cls, fields(0)))
    val rr2: Fielder = parse_element (element (cls, fields(1)))
    val xlr1: Fielder = parse_element (element (cls, fields(2)))
    val xlr2: Fielder = parse_element (element (cls, fields(3)))
    val xm: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): AsynchronousMachineEquivalentCircuit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineEquivalentCircuit (
            AsynchronousMachineDynamics.parse (context),
            toDouble (mask (rr1 (), 0)),
            toDouble (mask (rr2 (), 1)),
            toDouble (mask (xlr1 (), 2)),
            toDouble (mask (xlr2 (), 3)),
            toDouble (mask (xm (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parameter details:
 * <ol>
 * <li>If <i>X'' </i>=<i> X'</i>, a single cage (one equivalent rotor winding per axis) is modelled.</li>
 * <li>The “<i>p</i>” in the attribute names is a substitution for a “prime” in the usual parameter notation, e.g. <i>tpo</i> refers to <i>T'o</i>.</li>
 * </ol>
 * The parameters used for models expressed in time constant reactance form include:
 * - RotatingMachine.ratedS (<i>MVAbase</i>);
 * - RotatingMachineDynamics.damping (<i>D</i>);
 * - RotatingMachineDynamics.inertia (<i>H</i>);
 * - RotatingMachineDynamics.saturationFactor (<i>S1</i>);
 * - RotatingMachineDynamics.saturationFactor120 (<i>S12</i>);
 * - RotatingMachineDynamics.statorLeakageReactance (<i>Xl</i>);
 * - RotatingMachineDynamics.statorResistance (<i>Rs</i>);
 * - .xs (<i>Xs</i>);
 * - .xp (<i>X'</i>);
 * - .xpp (<i>X''</i>);
 * - .tpo (<i>T'o</i>);
 *
 * - .tppo (<i>T''o</i>).
 *
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Reference to the superclass object.
 * @param tpo Transient rotor time constant (<i>T'o</i>) (&gt; AsynchronousMachineTimeConstantReactance.tppo).
 *        Typical value = 5.
 * @param tppo Subtransient rotor time constant (<i>T''o</i>) (&gt; 0).
 *        Typical value = 0,03.
 * @param xp Transient reactance (unsaturated) (<i>X'</i>) (&gt;= AsynchronousMachineTimeConstantReactance.xpp).
 *        Typical value = 0,5.
 * @param xpp Subtransient reactance (unsaturated) (<i>X''</i>) (&gt; RotatingMachineDynamics.statorLeakageReactance).
 *        Typical value = 0,2.
 * @param xs Synchronous reactance (<i>Xs</i>) (&gt;= AsynchronousMachineTimeConstantReactance.xp).
 *        Typical value = 1,8.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g. a squirrel-cage induction machine. 
The interconnection with the electrical network equations can differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
The asynchronous machine model is used to model wind generators type 1 and type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
final case class AsynchronousMachineTimeConstantReactance
(
    AsynchronousMachineDynamics: AsynchronousMachineDynamics = null,
    tpo: Double = 0.0,
    tppo: Double = 0.0,
    xp: Double = 0.0,
    xpp: Double = 0.0,
    xs: Double = 0.0
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
    override def sup: AsynchronousMachineDynamics = AsynchronousMachineDynamics

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
        implicit val clz: String = AsynchronousMachineTimeConstantReactance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AsynchronousMachineTimeConstantReactance.fields (position), value)
        emitelem (0, tpo)
        emitelem (1, tppo)
        emitelem (2, xp)
        emitelem (3, xpp)
        emitelem (4, xs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineTimeConstantReactance rdf:ID=\"%s\">\n%s\t</cim:AsynchronousMachineTimeConstantReactance>".format (id, export_fields)
    }
}

object AsynchronousMachineTimeConstantReactance
extends
    CIMParseable[AsynchronousMachineTimeConstantReactance]
{
    override val fields: Array[String] = Array[String] (
        "tpo",
        "tppo",
        "xp",
        "xpp",
        "xs"
    )
    val tpo: Fielder = parse_element (element (cls, fields(0)))
    val tppo: Fielder = parse_element (element (cls, fields(1)))
    val xp: Fielder = parse_element (element (cls, fields(2)))
    val xpp: Fielder = parse_element (element (cls, fields(3)))
    val xs: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): AsynchronousMachineTimeConstantReactance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AsynchronousMachineTimeConstantReactance (
            AsynchronousMachineDynamics.parse (context),
            toDouble (mask (tpo (), 0)),
            toDouble (mask (tppo (), 1)),
            toDouble (mask (xp (), 2)),
            toDouble (mask (xpp (), 3)),
            toDouble (mask (xs (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _AsynchronousMachineDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            AsynchronousMachineDynamics.register,
            AsynchronousMachineEquivalentCircuit.register,
            AsynchronousMachineTimeConstantReactance.register
        )
    }
}