package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.
 * Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.
 */

/**
 * Excitation base system mode.
 * @param sup Reference to the superclass object.
 * @param ifag Air gap line mode.  ifdBaseValue is computed, not defined by the user, in this mode.
 * @param iffl Full load system mode.  ifdBaseValue is computed, not defined by the user, in this mode.
 * @param ifnl No load system with saturation mode.  ifdBaseValue is computed, not defined by the user, in this mode.
 */
case class IfdBaseKind
(
    override val sup: BasicElement,
    val ifag: String,
    val iffl: String,
    val ifnl: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[IfdBaseKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IfdBaseKind
extends
    Parseable[IfdBaseKind]
{
    val sup = BasicElement.parse _
    val ifag = parse_attribute (attribute ("""IfdBaseKind.ifag"""))
    val iffl = parse_attribute (attribute ("""IfdBaseKind.iffl"""))
    val ifnl = parse_attribute (attribute ("""IfdBaseKind.ifnl"""))
    def parse (context: Context): IfdBaseKind =
    {
        IfdBaseKind(
            sup (context),
            ifag (context),
            iffl (context),
            ifnl (context)
        )
    }
}

/**
 * Type of rotor on physical machine.
 * @param sup Reference to the superclass object.
 * @param roundRotor Round rotor type of synchronous machine.
 * @param salientPole Salient pole type of synchronous machine.
 */
case class RotorKind
(
    override val sup: BasicElement,
    val roundRotor: String,
    val salientPole: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RotorKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RotorKind
extends
    Parseable[RotorKind]
{
    val sup = BasicElement.parse _
    val roundRotor = parse_attribute (attribute ("""RotorKind.roundRotor"""))
    val salientPole = parse_attribute (attribute ("""RotorKind.salientPole"""))
    def parse (context: Context): RotorKind =
    {
        RotorKind(
            sup (context),
            roundRotor (context),
            salientPole (context)
        )
    }
}

/**
 * All synchronous machine detailed types use a subset of the same data parameters and input/output variables.
 * The several variations differ in the following ways:
 * @param sup Reference to the superclass object.
 * @param efdBaseRatio Ratio (Exciter voltage/Generator voltage) of Efd bases of exciter and generator models.
 *        Typical Value = 1.
 * @param ifdBaseType Excitation base system mode.
 *        It should be equal to the value of WLMDV given by the user. WLMDV is the per unit ratio between the field voltage and the excitation current: Efd = WLMDV*Ifd. Typical Value = ifag.
 * @param saturationFactor120QAxis Q-axis saturation factor at 120% of rated terminal voltage (S12q) (&gt;=S1q).
 *        Typical Value = 0.12.
 * @param saturationFactorQAxis Q-axis saturation factor at rated terminal voltage (S1q) (&gt;= 0).
 *        Typical Value = 0.02.
 */
case class SynchronousMachineDetailed
(
    override val sup: SynchronousMachineDynamics,
    val efdBaseRatio: Double,
    val ifdBaseType: String,
    val saturationFactor120QAxis: Double,
    val saturationFactorQAxis: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0.0) }
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineDetailed]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineDetailed
extends
    Parseable[SynchronousMachineDetailed]
{
    val sup = SynchronousMachineDynamics.parse _
    val efdBaseRatio = parse_element (element ("""SynchronousMachineDetailed.efdBaseRatio"""))
    val ifdBaseType = parse_attribute (attribute ("""SynchronousMachineDetailed.ifdBaseType"""))
    val saturationFactor120QAxis = parse_element (element ("""SynchronousMachineDetailed.saturationFactor120QAxis"""))
    val saturationFactorQAxis = parse_element (element ("""SynchronousMachineDetailed.saturationFactorQAxis"""))
    def parse (context: Context): SynchronousMachineDetailed =
    {
        SynchronousMachineDetailed(
            sup (context),
            toDouble (efdBaseRatio (context), context),
            ifdBaseType (context),
            toDouble (saturationFactor120QAxis (context), context),
            toDouble (saturationFactorQAxis (context), context)
        )
    }
}

/**
 * Synchronous machine whose behaviour is described by reference to a standard model expressed in one of the following forms:
<ul>
	<li>simplified (or classical), where a group of generators or motors is not modelled in detail</li>
</ul>
<ul>
	<li>detailed, in equivalent circuit form</li>
	<li>detailed, in time constant reactance form</li>
</ul>
<font color="#0f0f0f">or by definition of a user-defined model.</font>
<font color="#0f0f0f">
</font><font color="#0f0f0f"><b>Note:</b>  It is a common practice to represent small generators by a negative load rather than by a dynamic generator model when performing dynamics simulations.
 * In this case a SynchronousMachine in the static model is not represented by anything in the dynamics model, instead it is treated as ordinary load.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model associated with this synchronous machine model.
 * @param MechanicalLoadDynamics Mechanical load model associated with this synchronous machine model.
 * @param SynchronousMachine Synchronous machine to which synchronous machine dynamics model applies.
 * @param TurbineGovernorDynamics Turbine-governor model associated with this synchronous machine model.
 */
case class SynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
    val ExcitationSystemDynamics: String,
    val MechanicalLoadDynamics: String,
    val SynchronousMachine: String,
    val TurbineGovernorDynamics: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def RotatingMachineDynamics: RotatingMachineDynamics = sup.asInstanceOf[RotatingMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineDynamics
extends
    Parseable[SynchronousMachineDynamics]
{
    val sup = RotatingMachineDynamics.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""SynchronousMachineDynamics.ExcitationSystemDynamics"""))
    val MechanicalLoadDynamics = parse_attribute (attribute ("""SynchronousMachineDynamics.MechanicalLoadDynamics"""))
    val SynchronousMachine = parse_attribute (attribute ("""SynchronousMachineDynamics.SynchronousMachine"""))
    val TurbineGovernorDynamics = parse_attributes (attribute ("""SynchronousMachineDynamics.TurbineGovernorDynamics"""))
    def parse (context: Context): SynchronousMachineDynamics =
    {
        SynchronousMachineDynamics(
            sup (context),
            ExcitationSystemDynamics (context),
            MechanicalLoadDynamics (context),
            SynchronousMachine (context),
            TurbineGovernorDynamics (context)
        )
    }
}

/**
 * The electrical equations for all variations of the synchronous models are based on the SynchronousEquivalentCircuit diagram for the direct and quadrature axes.

<b>Equations for conversion between Equivalent Circuit and Time Constant Reactance forms:</b>
<b>Xd</b> = <b>Xad</b> + <b>Xl</b>
<b>X�d</b> = <b>Xl</b> + <b>Xad</b> * <b>Xfd</b> / (<b>Xad</b> + <b>Xfd</b>)
<b>X�d</b> = <b>Xl</b> + <b>Xad</b> * <b>Xfd </b>* <b>X1d</b> / (<b>Xad</b> * <b>Xfd</b> + <b>Xad</b> * <b>X1d</b> + <b>Xfd</b> * <b>X1d</b>)
<b>Xq</b> = <b>Xaq</b> + <b>Xl</b>
<b>X�q</b> = <b>Xl</b> + <b>Xaq</b> * <b>X1q</b> / (<b>Xaq</b>+ <b>X1q</b>)
<b>X�q</b> = <b>Xl</b> + <b>Xaq</b> *<b> X1q</b>* <b>X2q</b> / (<b>Xaq</b> * <b>X1q</b> + <b>Xaq</b> * <b>X2q</b> + <b>X1q</b> * <b>X2q</b>)
<b>T�do</b> = (<b>Xad</b> + <b>Xfd</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rfd</b>)
<b>T�do</b> = (<b>Xad</b> * <b>Xfd</b> + <b>Xad</b> * <b>X1d</b> + <b>Xfd</b> * <b>X1d</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>R1d</b> * (<b>Xad</b> + <b>Xfd</b>)
<b>T�qo</b> = (<b>Xaq</b> + <b>X1q</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>R1q</b>)
<b>T�qo</b> = (<b>Xaq</b> * <b>X1q</b> + <b>Xaq</b> * <b>X2q</b> + <b>X1q</b> * <b>X2q</b>)/ (<b>omega</b><b><sub>0</sub></b> * <b>R2q</b> * (<b>Xaq</b> + <b>X1q</b>)
<b>
</b>Same equations using CIM attributes from SynchronousMachineTimeConstantReactance class on left of = sign and SynchronousMachineEquivalentCircuit class on right (except as noted):
xDirectSync = xad + RotatingMachineDynamics.statorLeakageReactance
xDirectTrans = RotatingMachineDynamics.statorLeakageReactance + xad * xfd / (xad + xfd)
xDirectSubtrans = RotatingMachineDynamics.statorLeakageReactance + xad * xfd * x1d / (xad * xfd + xad * x1d + xfd * x1d)
xQuadSync = xaq + RotatingMachineDynamics.statorLeakageReactance
xQuadTrans = RotatingMachineDynamics.statorLeakageReactance + xaq * x1q / (xaq+ x1q)
xQuadSubtrans = RotatingMachineDynamics.statorLeakageReactance + xaq * x1q* x2q / (xaq * x1q + xaq * x2q + x1q * x2q) 
tpdo = (xad + xfd) / (2*pi*nominal frequency * rfd)
tppdo = (xad * xfd + xad * x1d + xfd * x1d) / (2*pi*nominal frequency * r1d * (xad + xfd)
tpqo = (xaq + x1q) / (2*pi*nominal frequency * r1q)
tppqo = (xaq * x1q + xaq * x2q + x1q * x2q)/ (2*pi*nominal frequency * r2q * (xaq + x1q).
 * Are only valid for a simplified model where "Canay" reactance is zero.
 * @param sup Reference to the superclass object.
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
 */
case class SynchronousMachineEquivalentCircuit
(
    override val sup: SynchronousMachineDetailed,
    val r1d: Double,
    val r1q: Double,
    val r2q: Double,
    val rfd: Double,
    val x1d: Double,
    val x1q: Double,
    val x2q: Double,
    val xad: Double,
    val xaq: Double,
    val xf1d: Double,
    val xfd: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def SynchronousMachineDetailed: SynchronousMachineDetailed = sup.asInstanceOf[SynchronousMachineDetailed]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineEquivalentCircuit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineEquivalentCircuit
extends
    Parseable[SynchronousMachineEquivalentCircuit]
{
    val sup = SynchronousMachineDetailed.parse _
    val r1d = parse_element (element ("""SynchronousMachineEquivalentCircuit.r1d"""))
    val r1q = parse_element (element ("""SynchronousMachineEquivalentCircuit.r1q"""))
    val r2q = parse_element (element ("""SynchronousMachineEquivalentCircuit.r2q"""))
    val rfd = parse_element (element ("""SynchronousMachineEquivalentCircuit.rfd"""))
    val x1d = parse_element (element ("""SynchronousMachineEquivalentCircuit.x1d"""))
    val x1q = parse_element (element ("""SynchronousMachineEquivalentCircuit.x1q"""))
    val x2q = parse_element (element ("""SynchronousMachineEquivalentCircuit.x2q"""))
    val xad = parse_element (element ("""SynchronousMachineEquivalentCircuit.xad"""))
    val xaq = parse_element (element ("""SynchronousMachineEquivalentCircuit.xaq"""))
    val xf1d = parse_element (element ("""SynchronousMachineEquivalentCircuit.xf1d"""))
    val xfd = parse_element (element ("""SynchronousMachineEquivalentCircuit.xfd"""))
    def parse (context: Context): SynchronousMachineEquivalentCircuit =
    {
        SynchronousMachineEquivalentCircuit(
            sup (context),
            toDouble (r1d (context), context),
            toDouble (r1q (context), context),
            toDouble (r2q (context), context),
            toDouble (rfd (context), context),
            toDouble (x1d (context), context),
            toDouble (x1q (context), context),
            toDouble (x2q (context), context),
            toDouble (xad (context), context),
            toDouble (xaq (context), context),
            toDouble (xf1d (context), context),
            toDouble (xfd (context), context)
        )
    }
}

/**
 * Type of synchronous machine model used in Dynamic simulation applications.
 * @param sup Reference to the superclass object.
 * @param subtransient Subtransient synchronous machine model.
 * @param subtransientSimplified Simplified version of subtransient synchronous machine model where magnetic coupling between the direct and quadrature axes is ignored.
 * @param subtransientSimplifiedDirectAxis Simplified version of a subtransient synchronous machine model with no damper circuit on d-axis.
 * @param subtransientTypeF WECC Type F variant of subtransient synchronous machine model.
 * @param subtransientTypeJ WECC Type J variant of subtransient synchronous machine model.
 */
case class SynchronousMachineModelKind
(
    override val sup: BasicElement,
    val subtransient: String,
    val subtransientSimplified: String,
    val subtransientSimplifiedDirectAxis: String,
    val subtransientTypeF: String,
    val subtransientTypeJ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineModelKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineModelKind
extends
    Parseable[SynchronousMachineModelKind]
{
    val sup = BasicElement.parse _
    val subtransient = parse_attribute (attribute ("""SynchronousMachineModelKind.subtransient"""))
    val subtransientSimplified = parse_attribute (attribute ("""SynchronousMachineModelKind.subtransientSimplified"""))
    val subtransientSimplifiedDirectAxis = parse_attribute (attribute ("""SynchronousMachineModelKind.subtransientSimplifiedDirectAxis"""))
    val subtransientTypeF = parse_attribute (attribute ("""SynchronousMachineModelKind.subtransientTypeF"""))
    val subtransientTypeJ = parse_attribute (attribute ("""SynchronousMachineModelKind.subtransientTypeJ"""))
    def parse (context: Context): SynchronousMachineModelKind =
    {
        SynchronousMachineModelKind(
            sup (context),
            subtransient (context),
            subtransientSimplified (context),
            subtransientSimplifiedDirectAxis (context),
            subtransientTypeF (context),
            subtransientTypeJ (context)
        )
    }
}

/**
 * The simplified model represents a synchronous generator as a constant internal voltage behind an impedance (<b>Rs</b> + <b>jXp</b>) as shown in the Simplified diagram.
 * Since internal voltage is held constant, there is no <b>Efd</b> input and any excitation system model will be ignored.  There is also no <b>Ifd</b> output.
 * @param sup Reference to the superclass object.
 */
case class SynchronousMachineSimplified
(
    override val sup: SynchronousMachineDynamics
)
extends
    Element
{
    def this () = { this (null) }
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineSimplified]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineSimplified
extends
    Parseable[SynchronousMachineSimplified]
{
    val sup = SynchronousMachineDynamics.parse _
    def parse (context: Context): SynchronousMachineSimplified =
    {
        SynchronousMachineSimplified(
            sup (context)
        )
    }
}

/**
 * Synchronous machine detailed modelling types are defined by the combination of the attributes SynchronousMachineTimeConstantReactance.modelType and SynchronousMachineTimeConstantReactance.rotorType.  
<b>
</b><b>Parameter notes:</b>
<ol>
	<li>The �p� in the time-related attribute names is a substitution for a �prime� in the usual parameter notation, e.g. tpdo refers to <b>T'do</b>.</li>
</ol>
<b>
</b>The parameters used for models expressed in time constant reactance form include:
<ul>
	<li>RotatingMachine.ratedS (MVAbase)</li>
	<li>RotatingMachineDynamics.damping (D)</li>
	<li>RotatingMachineDynamics.inertia (H)</li>
	<li>RotatingMachineDynamics.saturationFactor (S1)</li>
	<li>RotatingMachineDynamics.saturationFactor120 (S12)</li>
	<li>RotatingMachineDynamics.statorLeakageReactance (Xl)</li>
	<li>RotatingMachineDynamics.statorResistance (Rs)</li>
	<li>SynchronousMachineTimeConstantReactance.ks (Ks)</li>
	<li>SynchronousMachineDetailed.saturationFactorQAxis (S1q)</li>
	<li>SynchronousMachineDetailed.saturationFactor120QAxis (S12q)</li>
	<li>SynchronousMachineDetailed.efdBaseRatio</li>
	<li>SynchronousMachineDetailed.ifdBaseType</li>
	<li>SynchronousMachineDetailed.ifdBaseValue, if present</li>
	<li>.xDirectSync (Xd)</li>
	<li>.xDirectTrans (X'd)</li>
	<li>.xDirectSubtrans (X''d)</li>
	<li>.xQuadSync (Xq)</li>
	<li>.xQuadTrans (X'q)</li>
	<li>.xQuadSubtrans (X''q)</li>
	<li>.tpdo (T'do)</li>
	<li>.tppdo (T''do)</li>
	<li>.tpqo (T'qo)</li>
	<li>.tppqo (T''qo)</li>
	<li>.tc.</li>
 * </ul>
 * @param sup Reference to the superclass object.
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
 */
case class SynchronousMachineTimeConstantReactance
(
    override val sup: SynchronousMachineDetailed,
    val ks: Double,
    val modelType: String,
    val rotorType: String,
    val tc: Double,
    val tpdo: Double,
    val tppdo: Double,
    val tppqo: Double,
    val tpqo: Double,
    val xDirectSubtrans: Double,
    val xDirectSync: Double,
    val xDirectTrans: Double,
    val xQuadSubtrans: Double,
    val xQuadSync: Double,
    val xQuadTrans: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def SynchronousMachineDetailed: SynchronousMachineDetailed = sup.asInstanceOf[SynchronousMachineDetailed]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineTimeConstantReactance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineTimeConstantReactance
extends
    Parseable[SynchronousMachineTimeConstantReactance]
{
    val sup = SynchronousMachineDetailed.parse _
    val ks = parse_element (element ("""SynchronousMachineTimeConstantReactance.ks"""))
    val modelType = parse_attribute (attribute ("""SynchronousMachineTimeConstantReactance.modelType"""))
    val rotorType = parse_attribute (attribute ("""SynchronousMachineTimeConstantReactance.rotorType"""))
    val tc = parse_element (element ("""SynchronousMachineTimeConstantReactance.tc"""))
    val tpdo = parse_element (element ("""SynchronousMachineTimeConstantReactance.tpdo"""))
    val tppdo = parse_element (element ("""SynchronousMachineTimeConstantReactance.tppdo"""))
    val tppqo = parse_element (element ("""SynchronousMachineTimeConstantReactance.tppqo"""))
    val tpqo = parse_element (element ("""SynchronousMachineTimeConstantReactance.tpqo"""))
    val xDirectSubtrans = parse_element (element ("""SynchronousMachineTimeConstantReactance.xDirectSubtrans"""))
    val xDirectSync = parse_element (element ("""SynchronousMachineTimeConstantReactance.xDirectSync"""))
    val xDirectTrans = parse_element (element ("""SynchronousMachineTimeConstantReactance.xDirectTrans"""))
    val xQuadSubtrans = parse_element (element ("""SynchronousMachineTimeConstantReactance.xQuadSubtrans"""))
    val xQuadSync = parse_element (element ("""SynchronousMachineTimeConstantReactance.xQuadSync"""))
    val xQuadTrans = parse_element (element ("""SynchronousMachineTimeConstantReactance.xQuadTrans"""))
    def parse (context: Context): SynchronousMachineTimeConstantReactance =
    {
        SynchronousMachineTimeConstantReactance(
            sup (context),
            toDouble (ks (context), context),
            modelType (context),
            rotorType (context),
            toDouble (tc (context), context),
            toDouble (tpdo (context), context),
            toDouble (tppdo (context), context),
            toDouble (tppqo (context), context),
            toDouble (tpqo (context), context),
            toDouble (xDirectSubtrans (context), context),
            toDouble (xDirectSync (context), context),
            toDouble (xDirectTrans (context), context),
            toDouble (xQuadSubtrans (context), context),
            toDouble (xQuadSync (context), context),
            toDouble (xQuadTrans (context), context)
        )
    }
}

object _SynchronousMachineDynamics
{
    def register: Unit =
    {
        IfdBaseKind.register
        RotorKind.register
        SynchronousMachineDetailed.register
        SynchronousMachineDynamics.register
        SynchronousMachineEquivalentCircuit.register
        SynchronousMachineModelKind.register
        SynchronousMachineSimplified.register
        SynchronousMachineTimeConstantReactance.register
    }
}