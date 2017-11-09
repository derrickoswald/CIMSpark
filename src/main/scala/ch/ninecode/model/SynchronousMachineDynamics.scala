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
 * @param efdBaseRatio Ratio (Exciter voltage/Generator voltage) of Efd bases of exciter and generator models.
 *        Typical Value = 1.
 * @param ifdBaseType Excitation base system mode.
 *        It should be equal to the value of WLMDV given by the user. WLMDV is the per unit ratio between the field voltage and the excitation current: Efd = WLMDV*Ifd. Typical Value = ifag.
 * @param saturationFactor120QAxis Q-axis saturation factor at 120% of rated terminal voltage (S12q) (&gt;=S1q).
 *        Typical Value = 0.12.
 * @param saturationFactorQAxis Q-axis saturation factor at rated terminal voltage (S1q) (&gt;= 0).
 *        Typical Value = 0.02.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.  

The interconnection with the electrical network equations may differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
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
 * <ul>
 * <li>simplified (or classical), where a group of generators or motors is not modelled in detail</li>
 * </ul>
 * <ul>
 * <li>detailed, in equivalent circuit form</li>
 * <li>detailed, in time constant reactance form</li>
 * </ul>
 * <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * <font color="#0f0f0f">
 * </font><font color="#0f0f0f"><b>Note:</b>  It is a common practice to represent small generators by a negative load rather than by a dynamic generator model when performing dynamics simulations.
 *
 * In this case a SynchronousMachine in the static model is not represented by anything in the dynamics model, instead it is treated as ordinary load.</font>
 *
 * @param sup [[ch.ninecode.model.RotatingMachineDynamics RotatingMachineDynamics]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model associated with this synchronous machine model.
 * @param GenICompensationForGenJ [[ch.ninecode.model.GenICompensationForGenJ GenICompensationForGenJ]] Compensation of voltage compensator's generator for current flow out of this  generator.
 * @param MechanicalLoadDynamics [[ch.ninecode.model.MechanicalLoadDynamics MechanicalLoadDynamics]] Mechanical load model associated with this synchronous machine model.
 * @param SynchronousMachine [[ch.ninecode.model.SynchronousMachine SynchronousMachine]] Synchronous machine to which synchronous machine dynamics model applies.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor model associated with this synchronous machine model.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.  

The interconnection with the electrical network equations may differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
 */
case class SynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
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
    def this () = { this (null, null, List(), null, null, List()) }
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
        emitattr (0, ExcitationSystemDynamics)
        emitattrs (1, GenICompensationForGenJ)
        emitattr (2, MechanicalLoadDynamics)
        emitattr (3, SynchronousMachine)
        emitattrs (4, TurbineGovernorDynamics)
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
        "ExcitationSystemDynamics",
        "GenICompensationForGenJ",
        "MechanicalLoadDynamics",
        "SynchronousMachine",
        "TurbineGovernorDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "0..1", "1"),
        Relationship ("GenICompensationForGenJ", "GenICompensationForGenJ", "0..*", "1"),
        Relationship ("MechanicalLoadDynamics", "MechanicalLoadDynamics", "0..1", "0..1"),
        Relationship ("SynchronousMachine", "SynchronousMachine", "1", "0..1"),
        Relationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "0..*", "0..*")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GenICompensationForGenJ: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val MechanicalLoadDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SynchronousMachine: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TurbineGovernorDynamics: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): SynchronousMachineDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SynchronousMachineDynamics (
            RotatingMachineDynamics.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            masks (GenICompensationForGenJ (), 1),
            mask (MechanicalLoadDynamics (), 2),
            mask (SynchronousMachine (), 3),
            masks (TurbineGovernorDynamics (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The electrical equations for all variations of the synchronous models are based on the SynchronousEquivalentCircuit diagram for the direct and quadrature axes.
 * 
 * <b>Equations for conversion between Equivalent Circuit and Time Constant Reactance forms:</b>
 * <b>Xd</b> = <b>Xad</b> + <b>Xl</b>
 * <b>X�d</b> = <b>Xl</b> + <b>Xad</b> * <b>Xfd</b> / (<b>Xad</b> + <b>Xfd</b>)
 * <b>X�d</b> = <b>Xl</b> + <b>Xad</b> * <b>Xfd </b>* <b>X1d</b> / (<b>Xad</b> * <b>Xfd</b> + <b>Xad</b> * <b>X1d</b> + <b>Xfd</b> * <b>X1d</b>)
 * <b>Xq</b> = <b>Xaq</b> + <b>Xl</b>
 * <b>X�q</b> = <b>Xl</b> + <b>Xaq</b> * <b>X1q</b> / (<b>Xaq</b>+ <b>X1q</b>)
 * <b>X�q</b> = <b>Xl</b> + <b>Xaq</b> *<b> X1q</b>* <b>X2q</b> / (<b>Xaq</b> * <b>X1q</b> + <b>Xaq</b> * <b>X2q</b> + <b>X1q</b> * <b>X2q</b>)
 * <b>T�do</b> = (<b>Xad</b> + <b>Xfd</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rfd</b>)
 * <b>T�do</b> = (<b>Xad</b> * <b>Xfd</b> + <b>Xad</b> * <b>X1d</b> + <b>Xfd</b> * <b>X1d</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>R1d</b> * (<b>Xad</b> + <b>Xfd</b>)
 * <b>T�qo</b> = (<b>Xaq</b> + <b>X1q</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>R1q</b>)
 * <b>T�qo</b> = (<b>Xaq</b> * <b>X1q</b> + <b>Xaq</b> * <b>X2q</b> + <b>X1q</b> * <b>X2q</b>)/ (<b>omega</b><b><sub>0</sub></b> * <b>R2q</b> * (<b>Xaq</b> + <b>X1q</b>)
 * <b>
 * </b>Same equations using CIM attributes from SynchronousMachineTimeConstantReactance class on left of = sign and SynchronousMachineEquivalentCircuit class on right (except as noted):
 * xDirectSync = xad + RotatingMachineDynamics.statorLeakageReactance
 * xDirectTrans = RotatingMachineDynamics.statorLeakageReactance + xad * xfd / (xad + xfd)
 * xDirectSubtrans = RotatingMachineDynamics.statorLeakageReactance + xad * xfd * x1d / (xad * xfd + xad * x1d + xfd * x1d)
 * xQuadSync = xaq + RotatingMachineDynamics.statorLeakageReactance
 * xQuadTrans = RotatingMachineDynamics.statorLeakageReactance + xaq * x1q / (xaq+ x1q)
 * xQuadSubtrans = RotatingMachineDynamics.statorLeakageReactance + xaq * x1q* x2q / (xaq * x1q + xaq * x2q + x1q * x2q)
 * tpdo = (xad + xfd) / (2*pi*nominal frequency * rfd)
 * tppdo = (xad * xfd + xad * x1d + xfd * x1d) / (2*pi*nominal frequency * r1d * (xad + xfd)
 * tpqo = (xaq + x1q) / (2*pi*nominal frequency * r1q)
 * tppqo = (xaq * x1q + xaq * x2q + x1q * x2q)/ (2*pi*nominal frequency * r2q * (xaq + x1q).
 *
 * Are only valid for a simplified model where "Canay" reactance is zero.
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param r1d D-axis damper 1 winding resistance.
 * @param r1q Q-axis damper 1 winding resistance.
 * @param r2q Q-axis damper 2 winding resistance.
 * @param rfd Field winding resistance.
 * @param x1d D-axis damper 1 winding leakage reactance.
 * @param x1q Q-axis damper 1 winding leakage reactance.
 * @param x2q Q-axis damper 2 winding leakage reactance.
 * @param xad D-axis mutual reactance.
 * @param xaq Q-axis mutual reactance.
 * @param xf1d Differential mutual (�Canay�) reactance.
 * @param xfd Field winding leakage reactance.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.  

The interconnection with the electrical network equations may differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
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
 * The simplified model represents a synchronous generator as a constant internal voltage behind an impedance (<b>Rs</b> + <b>jXp</b>) as shown in the Simplified diagram.
 *
 * Since internal voltage is held constant, there is no <b>Efd</b> input and any excitation system model will be ignored.  There is also no <b>Ifd</b> output.
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Reference to the superclass object.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.  

The interconnection with the electrical network equations may differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
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
 * <b>
 * </b><b>Parameter notes:</b>
 * <ol>
 * <li>The �p� in the time-related attribute names is a substitution for a �prime� in the usual parameter notation, e.g. tpdo refers to <b>T'do</b>.</li>
 * </ol>
 * <b>
 * </b>The parameters used for models expressed in time constant reactance form include:
 * <ul>
 * <li>RotatingMachine.ratedS (MVAbase)</li>
 * <li>RotatingMachineDynamics.damping (D)</li>
 * <li>RotatingMachineDynamics.inertia (H)</li>
 * <li>RotatingMachineDynamics.saturationFactor (S1)</li>
 * <li>RotatingMachineDynamics.saturationFactor120 (S12)</li>
 * <li>RotatingMachineDynamics.statorLeakageReactance (Xl)</li>
 * <li>RotatingMachineDynamics.statorResistance (Rs)</li>
 * <li>SynchronousMachineTimeConstantReactance.ks (Ks)</li>
 * <li>SynchronousMachineDetailed.saturationFactorQAxis (S1q)</li>
 * <li>SynchronousMachineDetailed.saturationFactor120QAxis (S12q)</li>
 * <li>SynchronousMachineDetailed.efdBaseRatio</li>
 * <li>SynchronousMachineDetailed.ifdBaseType</li>
 * <li>SynchronousMachineDetailed.ifdBaseValue, if present</li>
 * <li>.xDirectSync (Xd)</li>
 * <li>.xDirectTrans (X'd)</li>
 * <li>.xDirectSubtrans (X''d)</li>
 * <li>.xQuadSync (Xq)</li>
 * <li>.xQuadTrans (X'q)</li>
 * <li>.xQuadSubtrans (X''q)</li>
 * <li>.tpdo (T'do)</li>
 * <li>.tppdo (T''do)</li>
 * <li>.tpqo (T'qo)</li>
 * <li>.tppqo (T''qo)</li>
 * <li>.tc.</li>
 *
 * </ul>
 *
 * @param sup [[ch.ninecode.model.SynchronousMachineDetailed SynchronousMachineDetailed]] Reference to the superclass object.
 * @param ks Saturation loading correction factor (Ks) (&gt;= 0).
 *        Used only by Type J model.  Typical Value = 0.
 * @param modelType Type of synchronous machine model used in Dynamic simulation applications.
 * @param rotorType Type of rotor on physical machine.
 * @param tc Damping time constant for �Canay� reactance.
 *        Typical Value = 0.
 * @param tpdo Direct-axis transient rotor time constant (T'do) (&gt; T''do).
 *        Typical Value = 5.
 * @param tppdo Direct-axis subtransient rotor time constant (T''do) (&gt; 0).
 *        Typical Value = 0.03.
 * @param tppqo Quadrature-axis subtransient rotor time constant (T''qo) (&gt; 0).
 *        Typical Value = 0.03.
 * @param tpqo Quadrature-axis transient rotor time constant (T'qo) (&gt; T''qo).
 *        Typical Value = 0.5.
 * @param xDirectSubtrans Direct-axis subtransient reactance (unsaturated) (X''d) (&gt; Xl).
 *        Typical Value = 0.2.
 * @param xDirectSync Direct-axis synchronous reactance (Xd) (&gt;= X'd).
 *        The quotient of a sustained value of that AC component of armature voltage that is produced by the total direct-axis flux due to direct-axis armature current and the value of the AC component of this current, the machine running at rated speed. Typical Value = 1.8.
 * @param xDirectTrans Direct-axis transient reactance (unsaturated) (X'd) (&gt; =X''d).
 *        Typical Value = 0.5.
 * @param xQuadSubtrans Quadrature-axis subtransient reactance (X''q) (&gt; Xl).
 *        Typical Value = 0.2.
 * @param xQuadSync Quadrature-axis synchronous reactance (Xq) (&gt; =X'q).
 *        The ratio of the component of reactive armature voltage, due to the quadrature-axis component of armature current, to this component of current, under steady state conditions and at rated frequency.  Typical Value = 1.6.
 * @param xQuadTrans Quadrature-axis transient reactance (X'q) (&gt; =X''q).
 *        Typical Value = 0.3.
 * @group SynchronousMachineDynamics
 * @groupname SynchronousMachineDynamics Package SynchronousMachineDynamics
 * @groupdesc SynchronousMachineDynamics For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.  Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.  

The interconnection with the electrical network equations may differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
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