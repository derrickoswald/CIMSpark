package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * All synchronous machine detailed types use a subset of the same data parameters and input/output variables.
 *
 * The several variations differ in the following ways:
 * - the number of  equivalent windings that are included;
 * - the way in which saturation is incorporated into the model;
 * - whether or not “subtransient saliency” (<i>X''q</i> not = <i>X''d</i>) is represented.
 * It is not necessary for each simulation tool to have separate models for each of the model types.  The same model can often be used for several types by alternative logic within the model.  Also, differences in saturation representation might not result in significant model performance differences so model substitutions are often acceptable.
 *
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @param efdBaseRatio Ratio (exciter voltage/generator voltage) of <i>Efd</i> bases of exciter and generator models (&gt; 0).
 *        Typical value = 1.
 * @param ifdBaseType Excitation base system mode.
 *        It should be equal to the value of <i>WLMDV</i> given by the user. <i>WLMDV</i> is the PU ratio between the field voltage and the excitation current: <i>Efd</i> = <i>WLMDV</i> x <i>Ifd</i>. Typical value = ifag.
 * @param saturationFactor120QAxis Quadrature-axis saturation factor at 120% of rated terminal voltage (<i>S12q</i>) (&gt;= SynchonousMachineDetailed.saturationFactorQAxis).
 *        Typical value = 0,12.
 * @param saturationFactorQAxis Quadrature-axis saturation factor at rated terminal voltage (<i>S1q</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 */
final case class SynchronousMachineDetailed
(
    SynchronousMachineDynamics: SynchronousMachineDynamics = null,
    efdBaseRatio: Double = 0.0,
    ifdBaseType: String = null,
    saturationFactor120QAxis: Double = 0.0,
    saturationFactorQAxis: Double = 0.0
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
    override def sup: SynchronousMachineDynamics = SynchronousMachineDynamics

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
        implicit val clz: String = SynchronousMachineDetailed.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachineDetailed.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachineDetailed.fields (position), value)
        emitelem (0, efdBaseRatio)
        emitattr (1, ifdBaseType)
        emitelem (2, saturationFactor120QAxis)
        emitelem (3, saturationFactorQAxis)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineDetailed rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineDetailed>".format (id, export_fields)
    }
}

object SynchronousMachineDetailed
extends
    CIMParseable[SynchronousMachineDetailed]
{
    override val fields: Array[String] = Array[String] (
        "efdBaseRatio",
        "ifdBaseType",
        "saturationFactor120QAxis",
        "saturationFactorQAxis"
    )
    val efdBaseRatio: Fielder = parse_element (element (cls, fields(0)))
    val ifdBaseType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val saturationFactor120QAxis: Fielder = parse_element (element (cls, fields(2)))
    val saturationFactorQAxis: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: CIMContext): SynchronousMachineDetailed =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineDetailed (
            SynchronousMachineDynamics.parse (context),
            toDouble (mask (efdBaseRatio (), 0)),
            mask (ifdBaseType (), 1),
            toDouble (mask (saturationFactor120QAxis (), 2)),
            toDouble (mask (saturationFactorQAxis (), 3))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Synchronous machine whose behaviour is described by reference to a standard model expressed in one of the following forms:
 * - simplified (or classical), where a group of generators or motors is not modelled in detail;
 * - detailed, in equivalent circuit form;
 * - detailed, in time constant reactance form; or
 * <font color="#0f0f0f">- by definition of a user-defined model.</font>
 * <font color="#0f0f0f">It is a common practice to represent small generators by a negative load rather than by a dynamic generator model when performing dynamics simulations.
 *
 * In this case, a SynchronousMachine in the static model is not represented by anything in the dynamics model, instead it is treated as an ordinary load.</font>
 * <font color="#0f0f0f">Parameter details:</font>
 * <ol>
 * <li><font color="#0f0f0f">Synchronous machine parameters such as <i>Xl, Xd, Xp</i> etc. are actually used as inductances in the models,</font> but are commonly referred to as reactances since, at nominal frequency, the PU values are the same. However, some references use the symbol <i>L</i> instead of <i>X</i>.</li>
 * </ol>
 *
 * @param RotatingMachineDynamics [[ch.ninecode.model.RotatingMachineDynamics RotatingMachineDynamics]] Reference to the superclass object.
 * @param CrossCompoundTurbineGovernorDyanmics [[ch.ninecode.model.CrossCompoundTurbineGovernorDynamics CrossCompoundTurbineGovernorDynamics]] The cross-compound turbine governor with which this high-pressure synchronous machine is associated.
 * @param CrossCompoundTurbineGovernorDynamics [[ch.ninecode.model.CrossCompoundTurbineGovernorDynamics CrossCompoundTurbineGovernorDynamics]] The cross-compound turbine governor with which this low-pressure synchronous machine is associated.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model associated with this synchronous machine model.
 * @param GenICompensationForGenJ [[ch.ninecode.model.GenICompensationForGenJ GenICompensationForGenJ]] Compensation of voltage compensator's generator for current flow out of this  generator.
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Mechanical load model associated with this synchronous machine model.
 * @param SynchronousMachine [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machine to which synchronous machine dynamics model applies.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor model associated with this synchronous machine model.
 *        Multiplicity of greater than one is intended to support hydro units that have multiple turbines on one generator.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 */
final case class SynchronousMachineDynamics
(
    RotatingMachineDynamics: RotatingMachineDynamics = null,
    CrossCompoundTurbineGovernorDyanmics: String = null,
    CrossCompoundTurbineGovernorDynamics: String = null,
    ExcitationSystemDynamics: String = null,
    GenICompensationForGenJ: List[String] = null,
    MechanicalLoadDynamics: String = null,
    SynchronousMachine: String = null,
    TurbineGovernorDynamics: List[String] = null
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
        implicit val clz: String = SynchronousMachineDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachineDynamics.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SynchronousMachineDynamics.fields (position), x))
        emitattr (0, CrossCompoundTurbineGovernorDyanmics)
        emitattr (1, CrossCompoundTurbineGovernorDynamics)
        emitattr (2, ExcitationSystemDynamics)
        emitattrs (3, GenICompensationForGenJ)
        emitattr (4, MechanicalLoadDynamics)
        emitattr (5, SynchronousMachine)
        emitattrs (6, TurbineGovernorDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineDynamics rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineDynamics>".format (id, export_fields)
    }
}

object SynchronousMachineDynamics
extends
    CIMParseable[SynchronousMachineDynamics]
{
    override val fields: Array[String] = Array[String] (
        "CrossCompoundTurbineGovernorDyanmics",
        "CrossCompoundTurbineGovernorDynamics",
        "ExcitationSystemDynamics",
        "GenICompensationForGenJ",
        "MechanicalLoadDynamics",
        "SynchronousMachine",
        "TurbineGovernorDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CrossCompoundTurbineGovernorDyanmics", "CrossCompoundTurbineGovernorDynamics", "0..1", "1"),
        CIMRelationship ("CrossCompoundTurbineGovernorDynamics", "CrossCompoundTurbineGovernorDynamics", "0..1", "1"),
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "0..1", "1"),
        CIMRelationship ("GenICompensationForGenJ", "GenICompensationForGenJ", "0..*", "1"),
        CIMRelationship ("MechanicalLoadDynamics", "MechanicalLoadDynamics", "0..1", "0..1"),
        CIMRelationship ("SynchronousMachine", "SynchronousMachine", "1", "0..1"),
        CIMRelationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "0..*", "0..1")
    )
    val CrossCompoundTurbineGovernorDyanmics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CrossCompoundTurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GenICompensationForGenJ: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MechanicalLoadDynamics: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SynchronousMachine: Fielder = parse_attribute (attribute (cls, fields(5)))
    val TurbineGovernorDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): SynchronousMachineDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineDynamics (
            RotatingMachineDynamics.parse (context),
            mask (CrossCompoundTurbineGovernorDyanmics (), 0),
            mask (CrossCompoundTurbineGovernorDynamics (), 1),
            mask (ExcitationSystemDynamics (), 2),
            masks (GenICompensationForGenJ (), 3),
            mask (MechanicalLoadDynamics (), 4),
            mask (SynchronousMachine (), 5),
            masks (TurbineGovernorDynamics (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The electrical equations for all variations of the synchronous models are based on the SynchronousEquivalentCircuit diagram for the direct- and quadrature- axes.
 *
 * Equations for conversion between equivalent circuit and time constant reactance forms:
 * <i>Xd</i> = <i>Xad </i>+<i> Xl</i>
 * <i>X’d</i> = <i>Xl</i> + <i>Xad</i> x <i>Xfd</i> / (<i>Xad</i> + <i>Xfd</i>)
 * <i>X”d</i> = <i>Xl</i> + <i>Xad</i> x <i>Xfd</i> x <i>X1d</i> / (<i>Xad</i> x <i>Xfd</i> + <i>Xad</i> x <i>X1d</i> + <i>Xfd</i> x <i>X1d</i>)
 * <i>Xq</i> = <i>Xaq</i> + <i>Xl</i>
 * <i>X’q</i> = <i>Xl</i> + <i>Xaq</i> x <i>X1q</i> / (<i>Xaq</i> + <i>X1q</i>)
 * <i>X”q</i> = <i>Xl</i> + <i>Xaq</i> x <i>X1q</i> x <i>X2q</i> / (<i>Xaq</i> x <i>X1q</i> + <i>Xaq</i> x <i>X2q</i> + <i>X1q</i> x <i>X2q</i>)
 * <i>T’do</i> = (<i>Xad</i> + <i>Xfd</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>Rfd</i>)
 * <i>T”do</i> = (<i>Xad</i> x <i>Xfd</i> + <i>Xad</i> x <i>X1d</i> + <i>Xfd</i> x <i>X1d</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>R1d</i> x (<i>Xad</i> + <i>Xfd</i>)
 * <i>T’qo</i> = (<i>Xaq</i> + <i>X1q</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>R1q</i>)
 * <i>T”qo</i> = (<i>Xaq</i> x <i>X1q</i> + <i>Xaq</i> x <i>X2q</i> + <i>X1q</i> x <i>X2q</i>) / (<i>omega</i><i><sub>0</sub></i> x <i>R2q</i> x (<i>Xaq</i> + <i>X1q</i>)
 * Same equations using CIM attributes from SynchronousMachineTimeConstantReactance class on left of "=" and SynchronousMachineEquivalentCircuit class on right (except as noted):
 * xDirectSync = xad + RotatingMachineDynamics.statorLeakageReactance
 * xDirectTrans = RotatingMachineDynamics.statorLeakageReactance + xad x xfd / (xad + xfd)
 * xDirectSubtrans = RotatingMachineDynamics.statorLeakageReactance + xad x xfd x x1d / (xad x xfd + xad x x1d + xfd x x1d)
 * xQuadSync = xaq + RotatingMachineDynamics.statorLeakageReactance
 * xQuadTrans = RotatingMachineDynamics.statorLeakageReactance + xaq x x1q / (xaq+ x1q)
 * xQuadSubtrans = RotatingMachineDynamics.statorLeakageReactance + xaq x x1q x x2q / (xaq x x1q + xaq x x2q + x1q x x2q)
 * tpdo = (xad + xfd) / (2 x pi x nominal frequency x rfd)
 * tppdo = (xad x xfd + xad x x1d + xfd x x1d) / (2 x pi x nominal frequency x r1d x (xad + xfd)
 * tpqo = (xaq + x1q) / (2 x pi x nominal frequency x r1q)
 * tppqo = (xaq x x1q + xaq x x2q + x1q x x2q) / (2 x pi x nominal frequency x r2q x (xaq + x1q)
 * These are only valid for a simplified model where "Canay" reactance is zero.
 *
 * @param SynchronousMachineDetailed [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param r1d Direct-axis damper 1 winding resistance.
 * @param r1q Quadrature-axis damper 1 winding resistance.
 * @param r2q Quadrature-axis damper 2 winding resistance.
 * @param rfd Field winding resistance.
 * @param x1d Direct-axis damper 1 winding leakage reactance.
 * @param x1q Quadrature-axis damper 1 winding leakage reactance.
 * @param x2q Quadrature-axis damper 2 winding leakage reactance.
 * @param xad Direct-axis mutual reactance.
 * @param xaq Quadrature-axis mutual reactance.
 * @param xf1d Differential mutual (“Canay”) reactance.
 * @param xfd Field winding leakage reactance.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 */
final case class SynchronousMachineEquivalentCircuit
(
    SynchronousMachineDetailed: SynchronousMachineDetailed = null,
    r1d: Double = 0.0,
    r1q: Double = 0.0,
    r2q: Double = 0.0,
    rfd: Double = 0.0,
    x1d: Double = 0.0,
    x1q: Double = 0.0,
    x2q: Double = 0.0,
    xad: Double = 0.0,
    xaq: Double = 0.0,
    xf1d: Double = 0.0,
    xfd: Double = 0.0
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
    override def sup: SynchronousMachineDetailed = SynchronousMachineDetailed

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
        implicit val clz: String = SynchronousMachineEquivalentCircuit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachineEquivalentCircuit.fields (position), value)
        emitelem (0, r1d)
        emitelem (1, r1q)
        emitelem (2, r2q)
        emitelem (3, rfd)
        emitelem (4, x1d)
        emitelem (5, x1q)
        emitelem (6, x2q)
        emitelem (7, xad)
        emitelem (8, xaq)
        emitelem (9, xf1d)
        emitelem (10, xfd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineEquivalentCircuit rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineEquivalentCircuit>".format (id, export_fields)
    }
}

object SynchronousMachineEquivalentCircuit
extends
    CIMParseable[SynchronousMachineEquivalentCircuit]
{
    override val fields: Array[String] = Array[String] (
        "r1d",
        "r1q",
        "r2q",
        "rfd",
        "x1d",
        "x1q",
        "x2q",
        "xad",
        "xaq",
        "xf1d",
        "xfd"
    )
    val r1d: Fielder = parse_element (element (cls, fields(0)))
    val r1q: Fielder = parse_element (element (cls, fields(1)))
    val r2q: Fielder = parse_element (element (cls, fields(2)))
    val rfd: Fielder = parse_element (element (cls, fields(3)))
    val x1d: Fielder = parse_element (element (cls, fields(4)))
    val x1q: Fielder = parse_element (element (cls, fields(5)))
    val x2q: Fielder = parse_element (element (cls, fields(6)))
    val xad: Fielder = parse_element (element (cls, fields(7)))
    val xaq: Fielder = parse_element (element (cls, fields(8)))
    val xf1d: Fielder = parse_element (element (cls, fields(9)))
    val xfd: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: CIMContext): SynchronousMachineEquivalentCircuit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineEquivalentCircuit (
            SynchronousMachineDetailed.parse (context),
            toDouble (mask (r1d (), 0)),
            toDouble (mask (r1q (), 1)),
            toDouble (mask (r2q (), 2)),
            toDouble (mask (rfd (), 3)),
            toDouble (mask (x1d (), 4)),
            toDouble (mask (x1q (), 5)),
            toDouble (mask (x2q (), 6)),
            toDouble (mask (xad (), 7)),
            toDouble (mask (xaq (), 8)),
            toDouble (mask (xf1d (), 9)),
            toDouble (mask (xfd (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The simplified model represents a synchronous generator as a constant internal voltage behind an impedance<i> </i>(<i>Rs + jXp</i>) as shown in the Simplified diagram.
 *
 * Since internal voltage is held constant, there is no <i>Efd</i> input and any excitation system model will be ignored.  There is also no <i>Ifd</i> output.
 * This model should not be used for representing a real generator except, perhaps, small generators whose response is insignificant.
 * The parameters used for the simplified model include:
 * - RotatingMachineDynamics.damping (<i>D</i>);
 * - RotatingMachineDynamics.inertia (<i>H</i>);
 * - RotatingMachineDynamics.statorLeakageReactance (used to exchange <i>jXp </i>for SynchronousMachineSimplified);
 * - RotatingMachineDynamics.statorResistance (<i>Rs</i>).
 *
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 */
final case class SynchronousMachineSimplified
(
    SynchronousMachineDynamics: SynchronousMachineDynamics = null
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
    override def sup: SynchronousMachineDynamics = SynchronousMachineDynamics

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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineSimplified rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineSimplified>".format (id, export_fields)
    }
}

object SynchronousMachineSimplified
extends
    CIMParseable[SynchronousMachineSimplified]
{

    def parse (context: CIMContext): SynchronousMachineSimplified =
    {
        val ret = SynchronousMachineSimplified (
            SynchronousMachineDynamics.parse (context)
        )
        ret
    }
}

/**
 * Synchronous machine detailed modelling types are defined by the combination of the attributes SynchronousMachineTimeConstantReactance.modelType and SynchronousMachineTimeConstantReactance.rotorType.
 *
 * Parameter details:
 * <ol>
 * <li>The “p” in the time-related attribute names is a substitution for a “prime” in the usual parameter notation, e.g. tpdo refers to <i>T'do</i>.</li>
 * <li>The parameters used for models expressed in time constant reactance form include:</li>
 * </ol>
 * - RotatingMachine.ratedS (<i>MVAbase</i>);
 * - RotatingMachineDynamics.damping (<i>D</i>);
 * - RotatingMachineDynamics.inertia (<i>H</i>);
 * - RotatingMachineDynamics.saturationFactor (<i>S1</i>);
 * - RotatingMachineDynamics.saturationFactor120 (<i>S12</i>);
 * - RotatingMachineDynamics.statorLeakageReactance (<i>Xl</i>);
 * - RotatingMachineDynamics.statorResistance (<i>Rs</i>);
 * - SynchronousMachineTimeConstantReactance.ks (<i>Ks</i>);
 * - SynchronousMachineDetailed.saturationFactorQAxis (<i>S1q</i>);
 * - SynchronousMachineDetailed.saturationFactor120QAxis (<i>S12q</i>);
 * - SynchronousMachineDetailed.efdBaseRatio;
 * - SynchronousMachineDetailed.ifdBaseType;
 * - .xDirectSync (<i>Xd</i>);
 * - .xDirectTrans (<i>X'd</i>);
 * - .xDirectSubtrans (<i>X''d</i>);
 * - .xQuadSync (<i>Xq</i>);
 * - .xQuadTrans (<i>X'q</i>);
 * - .xQuadSubtrans (<i>X''q</i>);
 * - .tpdo (<i>T'do</i>);
 * - .tppdo (<i>T''do</i>);
 * - .tpqo (<i>T'qo</i>);
 * - .tppqo (<i>T''qo</i>);
 * - .tc.
 *
 * @param SynchronousMachineDetailed [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param ks Saturation loading correction factor (<i>Ks</i>) (&gt;= 0).
 *        Used only by type J model.  Typical value = 0.
 * @param modelType Type of synchronous machine model used in dynamic simulation applications.
 * @param rotorType Type of rotor on physical machine.
 * @param tc Damping time constant for “Canay” reactance (&gt;= 0).
 *        Typical value = 0.
 * @param tpdo Direct-axis transient rotor time constant (<i>T'do</i>) (&gt; SynchronousMachineTimeConstantReactance.tppdo).
 *        Typical value = 5.
 * @param tppdo Direct-axis subtransient rotor time constant (<i>T''do</i>) (&gt; 0).
 *        Typical value = 0,03.
 * @param tppqo Quadrature-axis subtransient rotor time constant (<i>T''qo</i>) (&gt; 0).
 *        Typical value = 0,03.
 * @param tpqo Quadrature-axis transient rotor time constant (<i>T'qo</i>) (&gt; SynchronousMachineTimeConstantReactance.tppqo).
 *        Typical value = 0,5.
 * @param xDirectSubtrans Direct-axis subtransient reactance (unsaturated) (<i>X''d</i>) (&gt; RotatingMachineDynamics.statorLeakageReactance).
 *        Typical value = 0,2.
 * @param xDirectSync Direct-axis synchronous reactance (<i>Xd</i>) (&gt;= SynchronousMachineTimeConstantReactance.xDirectTrans).
 *        The quotient of a sustained value of that AC component of armature voltage that is produced by the total direct-axis flux due to direct-axis armature current and the value of the AC component of this current, the machine running at rated speed.  Typical value = 1,8.
 * @param xDirectTrans Direct-axis transient reactance (unsaturated) (<i>X'd</i>) (&gt;= SynchronousMachineTimeConstantReactance.xDirectSubtrans).
 *        Typical value = 0,5.
 * @param xQuadSubtrans Quadrature-axis subtransient reactance (<i>X''q</i>) (&gt; RotatingMachineDynamics.statorLeakageReactance).
 *        Typical value = 0,2.
 * @param xQuadSync Quadrature-axis synchronous reactance (<i>Xq</i>) (&gt;= SynchronousMachineTimeConstantReactance.xQuadTrans).
 *        The ratio of the component of reactive armature voltage, due to the quadrature-axis component of armature current, to this component of current, under steady state conditions and at rated frequency.  Typical value = 1,6.
 * @param xQuadTrans Quadrature-axis transient reactance (<i>X'q</i>) (&gt;= SynchronousMachineTimeConstantReactance.xQuadSubtrans).
 *        Typical value = 0,3.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 */
final case class SynchronousMachineTimeConstantReactance
(
    SynchronousMachineDetailed: SynchronousMachineDetailed = null,
    ks: Double = 0.0,
    modelType: String = null,
    rotorType: String = null,
    tc: Double = 0.0,
    tpdo: Double = 0.0,
    tppdo: Double = 0.0,
    tppqo: Double = 0.0,
    tpqo: Double = 0.0,
    xDirectSubtrans: Double = 0.0,
    xDirectSync: Double = 0.0,
    xDirectTrans: Double = 0.0,
    xQuadSubtrans: Double = 0.0,
    xQuadSync: Double = 0.0,
    xQuadTrans: Double = 0.0
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
    override def sup: SynchronousMachineDetailed = SynchronousMachineDetailed

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
        implicit val clz: String = SynchronousMachineTimeConstantReactance.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SynchronousMachineTimeConstantReactance.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachineTimeConstantReactance.fields (position), value)
        emitelem (0, ks)
        emitattr (1, modelType)
        emitattr (2, rotorType)
        emitelem (3, tc)
        emitelem (4, tpdo)
        emitelem (5, tppdo)
        emitelem (6, tppqo)
        emitelem (7, tpqo)
        emitelem (8, xDirectSubtrans)
        emitelem (9, xDirectSync)
        emitelem (10, xDirectTrans)
        emitelem (11, xQuadSubtrans)
        emitelem (12, xQuadSync)
        emitelem (13, xQuadTrans)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineTimeConstantReactance rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineTimeConstantReactance>".format (id, export_fields)
    }
}

object SynchronousMachineTimeConstantReactance
extends
    CIMParseable[SynchronousMachineTimeConstantReactance]
{
    override val fields: Array[String] = Array[String] (
        "ks",
        "modelType",
        "rotorType",
        "tc",
        "tpdo",
        "tppdo",
        "tppqo",
        "tpqo",
        "xDirectSubtrans",
        "xDirectSync",
        "xDirectTrans",
        "xQuadSubtrans",
        "xQuadSync",
        "xQuadTrans"
    )
    val ks: Fielder = parse_element (element (cls, fields(0)))
    val modelType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val rotorType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val tc: Fielder = parse_element (element (cls, fields(3)))
    val tpdo: Fielder = parse_element (element (cls, fields(4)))
    val tppdo: Fielder = parse_element (element (cls, fields(5)))
    val tppqo: Fielder = parse_element (element (cls, fields(6)))
    val tpqo: Fielder = parse_element (element (cls, fields(7)))
    val xDirectSubtrans: Fielder = parse_element (element (cls, fields(8)))
    val xDirectSync: Fielder = parse_element (element (cls, fields(9)))
    val xDirectTrans: Fielder = parse_element (element (cls, fields(10)))
    val xQuadSubtrans: Fielder = parse_element (element (cls, fields(11)))
    val xQuadSync: Fielder = parse_element (element (cls, fields(12)))
    val xQuadTrans: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: CIMContext): SynchronousMachineTimeConstantReactance =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineTimeConstantReactance (
            SynchronousMachineDetailed.parse (context),
            toDouble (mask (ks (), 0)),
            mask (modelType (), 1),
            mask (rotorType (), 2),
            toDouble (mask (tc (), 3)),
            toDouble (mask (tpdo (), 4)),
            toDouble (mask (tppdo (), 5)),
            toDouble (mask (tppqo (), 6)),
            toDouble (mask (tpqo (), 7)),
            toDouble (mask (xDirectSubtrans (), 8)),
            toDouble (mask (xDirectSync (), 9)),
            toDouble (mask (xDirectTrans (), 10)),
            toDouble (mask (xQuadSubtrans (), 11)),
            toDouble (mask (xQuadSync (), 12)),
            toDouble (mask (xQuadTrans (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _SynchronousMachineDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            SynchronousMachineDetailed.register,
            SynchronousMachineDynamics.register,
            SynchronousMachineEquivalentCircuit.register,
            SynchronousMachineSimplified.register,
            SynchronousMachineTimeConstantReactance.register
        )
    }
}