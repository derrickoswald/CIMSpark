package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * All synchronous machine detailed types use a subset of the same data parameters and input/output variables.
 *
 * The several variations differ in the following ways:
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
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
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineDetailed
(
    override val sup: SynchronousMachineDynamics,
    efdBaseRatio: Double,
    ifdBaseType: String,
    saturationFactor120QAxis: Double,
    saturationFactorQAxis: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineDetailed] }
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
    Parseable[SynchronousMachineDetailed]
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

    def parse (context: Context): SynchronousMachineDetailed =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 *
 * @param sup [[ch.ninecode.model.RotatingMachineDynamics RotatingMachineDynamics]] Reference to the superclass object.
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
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
    CrossCompoundTurbineGovernorDyanmics: String,
    CrossCompoundTurbineGovernorDynamics: String,
    ExcitationSystemDynamics: String,
    GenICompensationForGenJ: List[String],
    MechanicalLoadDynamics: String,
    SynchronousMachine: String,
    TurbineGovernorDynamics: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RotatingMachineDynamics: RotatingMachineDynamics = sup.asInstanceOf[RotatingMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineDynamics] }
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
        implicit val clz: String = SynchronousMachineDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SynchronousMachineDynamics.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SynchronousMachineDynamics.fields (position), x))
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
    Parseable[SynchronousMachineDynamics]
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
    override val relations: List[Relationship] = List (
        Relationship ("CrossCompoundTurbineGovernorDyanmics", "CrossCompoundTurbineGovernorDynamics", "0..1", "1"),
        Relationship ("CrossCompoundTurbineGovernorDynamics", "CrossCompoundTurbineGovernorDynamics", "0..1", "1"),
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "0..1", "1"),
        Relationship ("GenICompensationForGenJ", "GenICompensationForGenJ", "0..*", "1"),
        Relationship ("MechanicalLoadDynamics", "MechanicalLoadDynamics", "0..1", "0..1"),
        Relationship ("SynchronousMachine", "SynchronousMachine", "1", "0..1"),
        Relationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "0..*", "0..1")
    )
    val CrossCompoundTurbineGovernorDyanmics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CrossCompoundTurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GenICompensationForGenJ: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MechanicalLoadDynamics: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SynchronousMachine: Fielder = parse_attribute (attribute (cls, fields(5)))
    val TurbineGovernorDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): SynchronousMachineDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param r1d Direct-axis damper 1 winding resistance.
 * @param r1q Quadrature-axis damper 1 winding resistance.
 * @param r2q Quadrature-axis damper 2 winding resistance.
 * @param rfd Field winding resistance.
 * @param x1d Direct-axis damper 1 winding leakage reactance.
 * @param x1q Quadrature-axis damper 1 winding leakage reactance.
 * @param x2q Quadrature-axis damper 2 winding leakage reactance.
 * @param xad Direct-axis mutual reactance.
 * @param xaq Quadrature-axis mutual reactance.
 * @param xf1d Differential mutual (�Canay�) reactance.
 * @param xfd Field winding leakage reactance.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineEquivalentCircuit
(
    override val sup: SynchronousMachineDetailed,
    r1d: Double,
    r1q: Double,
    r2q: Double,
    rfd: Double,
    x1d: Double,
    x1q: Double,
    x2q: Double,
    xad: Double,
    xaq: Double,
    xf1d: Double,
    xfd: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SynchronousMachineDetailed: SynchronousMachineDetailed = sup.asInstanceOf[SynchronousMachineDetailed]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineEquivalentCircuit] }
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
    Parseable[SynchronousMachineEquivalentCircuit]
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

    def parse (context: Context): SynchronousMachineEquivalentCircuit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.  
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineSimplified
(
    override val sup: SynchronousMachineDynamics
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineSimplified] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SynchronousMachineSimplified rdf:ID=\"%s\">\n%s\t</cim:SynchronousMachineSimplified>".format (id, export_fields)
    }
}

object SynchronousMachineSimplified
extends
    Parseable[SynchronousMachineSimplified]
{

    def parse (context: Context): SynchronousMachineSimplified =
    {
        implicit val ctx: Context = context
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
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param ks Saturation loading correction factor (<i>Ks</i>) (&gt;= 0).
 *        Used only by type J model.  Typical value = 0.
 * @param modelType Type of synchronous machine model used in dynamic simulation applications.
 * @param rotorType Type of rotor on physical machine.
 * @param tc Damping time constant for �Canay� reactance (&gt;= 0).
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
The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineTimeConstantReactance
(
    override val sup: SynchronousMachineDetailed,
    ks: Double,
    modelType: String,
    rotorType: String,
    tc: Double,
    tpdo: Double,
    tppdo: Double,
    tppqo: Double,
    tpqo: Double,
    xDirectSubtrans: Double,
    xDirectSync: Double,
    xDirectTrans: Double,
    xQuadSubtrans: Double,
    xQuadSync: Double,
    xQuadTrans: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SynchronousMachineDetailed: SynchronousMachineDetailed = sup.asInstanceOf[SynchronousMachineDetailed]
    override def copy (): Row = { clone ().asInstanceOf[SynchronousMachineTimeConstantReactance] }
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
    Parseable[SynchronousMachineTimeConstantReactance]
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

    def parse (context: Context): SynchronousMachineTimeConstantReactance =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
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
    def register: List[ClassInfo] =
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