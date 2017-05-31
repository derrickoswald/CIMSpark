package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine.
 * The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
 */

/**
 * Asynchronous machine whose behaviour is described by reference to a standard model expressed in either time constant reactance form or equivalent circuit form <font color="#0f0f0f">or by definition of a user-defined model.</font>

<b>Parameter Notes:</b>
<ol>
	<li>Asynchronous machine parameters such as <b>Xl, Xs</b> etc. are actually used as inductances (L) in the model, but are commonly referred to as reactances since, at nominal frequency, the per unit values are the same.
 * However, some references use the symbol L instead of X. </li>
 * @param sup Reference to the superclass object.
 * @param AsynchronousMachine Asynchronous machine to which this asynchronous machine dynamics model applies.
 * @param MechanicalLoadDynamics Mechanical load model associated with this asynchronous machine model.
 * @param TurbineGovernorDynamics Turbine-governor model associated with this asynchronous machine model.
 * @param WindTurbineType1or2Dynamics Wind generator type 1 or 2 model associated with this asynchronous machine model.
 */
case class AsynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
    val AsynchronousMachine: String,
    val MechanicalLoadDynamics: String,
    val TurbineGovernorDynamics: String,
    val WindTurbineType1or2Dynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def RotatingMachineDynamics: RotatingMachineDynamics = sup.asInstanceOf[RotatingMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachineDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachineDynamics
extends
    Parseable[AsynchronousMachineDynamics]
{
    val sup = RotatingMachineDynamics.parse _
    val AsynchronousMachine = parse_attribute (attribute ("""AsynchronousMachineDynamics.AsynchronousMachine"""))
    val MechanicalLoadDynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.MechanicalLoadDynamics"""))
    val TurbineGovernorDynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.TurbineGovernorDynamics"""))
    val WindTurbineType1or2Dynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.WindTurbineType1or2Dynamics"""))
    def parse (context: Context): AsynchronousMachineDynamics =
    {
        AsynchronousMachineDynamics(
            sup (context),
            AsynchronousMachine (context),
            MechanicalLoadDynamics (context),
            TurbineGovernorDynamics (context),
            WindTurbineType1or2Dynamics (context)
        )
    }
}

/**
 * The electrical equations of all variations of the asynchronous model are based on the AsynchronousEquivalentCircuit diagram for the direct and quadrature axes, with two equivalent rotor windings in each axis.  

<b>Equations for conversion between Equivalent Circuit and Time Constant Reactance forms:</b>
<b>Xs</b> = <b>Xm</b> + <b>Xl</b>
<b>X'</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b> / (<b>Xm</b> + <b>Xlr1</b>)
<b>X''</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b>* <b>Xlr2</b> / (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>)
<b>T'o</b> = (<b>Xm</b> + <b>Xlr1</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr1</b>)
<b>T''o</b> = (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr2</b> * (<b>Xm </b>+ <b>Xlr1</b>)
<b>
</b>Same equations using CIM attributes from AsynchronousMachineTimeConstantReactance class on left of = sign and AsynchronousMachineEquivalentCircuit class on right (except as noted):
xs = xm + RotatingMachineDynamics.statorLeakageReactance
xp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1 / (xm + xlr1)
xpp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1* xlr2 / (xm * xlr1 + xm * xlr2 + xlr1 * xlr2)
tpo = (xm + xlr1) / (2*pi*nominal frequency * rr1)
 * tppo = (xm * xlr1 + xm * xlr2 + xlr1 * xlr2) / (2*pi*nominal frequency * rr2 * (xm + xlr1).
 * @param sup Reference to the superclass object.
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 */
case class AsynchronousMachineEquivalentCircuit
(
    override val sup: AsynchronousMachineDynamics,
    val rr1: Double,
    val rr2: Double,
    val xlr1: Double,
    val xlr2: Double,
    val xm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachineEquivalentCircuit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachineEquivalentCircuit
extends
    Parseable[AsynchronousMachineEquivalentCircuit]
{
    val sup = AsynchronousMachineDynamics.parse _
    val rr1 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.rr1"""))
    val rr2 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.rr2"""))
    val xlr1 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xlr1"""))
    val xlr2 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xlr2"""))
    val xm = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xm"""))
    def parse (context: Context): AsynchronousMachineEquivalentCircuit =
    {
        AsynchronousMachineEquivalentCircuit(
            sup (context),
            toDouble (rr1 (context), context),
            toDouble (rr2 (context), context),
            toDouble (xlr1 (context), context),
            toDouble (xlr2 (context), context),
            toDouble (xm (context), context)
        )
    }
}

/**
 * <b>Parameter Notes:</b>
<ol>
	<li>If <b>X''</b> = <b>X'</b>, a single cage (one equivalent rotor winding per axis) is modelled.</li>
	<li>The �p� in the attribute names is a substitution for a �prime� in the usual parameter notation, e.g. tpo refers to T'o.</li>
</ol>

The parameters used for models expressed in time constant reactance form include:
<ul>
	<li>RotatingMachine.ratedS (MVAbase)</li>
	<li>RotatingMachineDynamics.damping (D)</li>
	<li>RotatingMachineDynamics.inertia (H)</li>
	<li>RotatingMachineDynamics.saturationFactor (S1)</li>
	<li>RotatingMachineDynamics.saturationFactor120 (S12)</li>
	<li>RotatingMachineDynamics.statorLeakageReactance (Xl)</li>
	<li>RotatingMachineDynamics.statorResistance (Rs)</li>
	<li>.xs (Xs)</li>
	<li>.xp (X')</li>
	<li>.xpp (X'')</li>
	<li>.tpo (T'o)</li>
	<li>.tppo (T''o).</li>
 * </ul>
 * @param sup Reference to the superclass object.
 * @param tpo Transient rotor time constant (T'o) (&gt; T''o).
 *        Typical Value = 5.
 * @param tppo Subtransient rotor time constant (T''o) (&gt; 0).
 *        Typical Value = 0.03.
 * @param xp Transient reactance (unsaturated) (X') (&gt;=X'').
 *        Typical Value = 0.5.
 * @param xpp Subtransient reactance (unsaturated) (X'') (&gt; Xl).
 *        Typical Value = 0.2.
 * @param xs Synchronous reactance (Xs) (&gt;= X').
 *        Typical Value = 1.8.
 */
case class AsynchronousMachineTimeConstantReactance
(
    override val sup: AsynchronousMachineDynamics,
    val tpo: Double,
    val tppo: Double,
    val xp: Double,
    val xpp: Double,
    val xs: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachineTimeConstantReactance]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachineTimeConstantReactance
extends
    Parseable[AsynchronousMachineTimeConstantReactance]
{
    val sup = AsynchronousMachineDynamics.parse _
    val tpo = parse_element (element ("""AsynchronousMachineTimeConstantReactance.tpo"""))
    val tppo = parse_element (element ("""AsynchronousMachineTimeConstantReactance.tppo"""))
    val xp = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xp"""))
    val xpp = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xpp"""))
    val xs = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xs"""))
    def parse (context: Context): AsynchronousMachineTimeConstantReactance =
    {
        AsynchronousMachineTimeConstantReactance(
            sup (context),
            toDouble (tpo (context), context),
            toDouble (tppo (context), context),
            toDouble (xp (context), context),
            toDouble (xpp (context), context),
            toDouble (xs (context), context)
        )
    }
}

object _AsynchronousMachineDynamics
{
    def register: Unit =
    {
        AsynchronousMachineDynamics.register
        AsynchronousMachineEquivalentCircuit.register
        AsynchronousMachineTimeConstantReactance.register
    }
}