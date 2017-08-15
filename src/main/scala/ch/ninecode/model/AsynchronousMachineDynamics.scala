package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Asynchronous machine whose behaviour is described by reference to a standard model expressed in either time constant reactance form or equivalent circuit form <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * 
 * <b>Parameter Notes:</b>
 * <ol>
 * <li>Asynchronous machine parameters such as <b>Xl, Xs</b> etc. are actually used as inductances (L) in the model, but are commonly referred to as reactances since, at nominal frequency, the per unit values are the same.
 *
 * However, some references use the symbol L instead of X. </li>
 *
 * @param sup Reference to the superclass object.
 * @param AsynchronousMachine Asynchronous machine to which this asynchronous machine dynamics model applies.
 * @param MechanicalLoadDynamics Mechanical load model associated with this asynchronous machine model.
 * @param TurbineGovernorDynamics Turbine-governor model associated with this asynchronous machine model.
 * @param WindTurbineType1or2Dynamics Wind generator type 1 or 2 model associated with this asynchronous machine model.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineDynamics
(
    override val sup: RotatingMachineDynamics,
    AsynchronousMachine: String,
    MechanicalLoadDynamics: String,
    TurbineGovernorDynamics: String,
    WindTurbineType1or2Dynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RotatingMachineDynamics: RotatingMachineDynamics = sup.asInstanceOf[RotatingMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineDynamics] }
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
        (if (null != AsynchronousMachine) "\t\t<cim:AsynchronousMachineDynamics.AsynchronousMachine rdf:resource=\"#" + AsynchronousMachine + "\"/>\n" else "") +
        (if (null != MechanicalLoadDynamics) "\t\t<cim:AsynchronousMachineDynamics.MechanicalLoadDynamics rdf:resource=\"#" + MechanicalLoadDynamics + "\"/>\n" else "") +
        (if (null != TurbineGovernorDynamics) "\t\t<cim:AsynchronousMachineDynamics.TurbineGovernorDynamics rdf:resource=\"#" + TurbineGovernorDynamics + "\"/>\n" else "") +
        (if (null != WindTurbineType1or2Dynamics) "\t\t<cim:AsynchronousMachineDynamics.WindTurbineType1or2Dynamics rdf:resource=\"#" + WindTurbineType1or2Dynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachineDynamics>"
    }
}

object AsynchronousMachineDynamics
extends
    Parseable[AsynchronousMachineDynamics]
{
    val AsynchronousMachine = parse_attribute (attribute ("""AsynchronousMachineDynamics.AsynchronousMachine"""))
    val MechanicalLoadDynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.MechanicalLoadDynamics"""))
    val TurbineGovernorDynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.TurbineGovernorDynamics"""))
    val WindTurbineType1or2Dynamics = parse_attribute (attribute ("""AsynchronousMachineDynamics.WindTurbineType1or2Dynamics"""))
    def parse (context: Context): AsynchronousMachineDynamics =
    {
        AsynchronousMachineDynamics(
            RotatingMachineDynamics.parse (context),
            AsynchronousMachine (context),
            MechanicalLoadDynamics (context),
            TurbineGovernorDynamics (context),
            WindTurbineType1or2Dynamics (context)
        )
    }
}

/**
 * The electrical equations of all variations of the asynchronous model are based on the AsynchronousEquivalentCircuit diagram for the direct and quadrature axes, with two equivalent rotor windings in each axis.
 * 
 * <b>Equations for conversion between Equivalent Circuit and Time Constant Reactance forms:</b>
 * <b>Xs</b> = <b>Xm</b> + <b>Xl</b>
 * <b>X'</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b> / (<b>Xm</b> + <b>Xlr1</b>)
 * <b>X''</b> = <b>Xl</b> + <b>Xm</b> * <b>Xlr1</b>* <b>Xlr2</b> / (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>)
 * <b>T'o</b> = (<b>Xm</b> + <b>Xlr1</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr1</b>)
 * <b>T''o</b> = (<b>Xm</b> * <b>Xlr1</b> + <b>Xm</b> * <b>Xlr2</b> + <b>Xlr1</b> * <b>Xlr2</b>) / (<b>omega</b><b><sub>0</sub></b> * <b>Rr2</b> * (<b>Xm </b>+ <b>Xlr1</b>)
 * <b>
 * </b>Same equations using CIM attributes from AsynchronousMachineTimeConstantReactance class on left of = sign and AsynchronousMachineEquivalentCircuit class on right (except as noted):
 * xs = xm + RotatingMachineDynamics.statorLeakageReactance
 * xp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1 / (xm + xlr1)
 * xpp = RotatingMachineDynamics.statorLeakageReactance + xm * xlr1* xlr2 / (xm * xlr1 + xm * xlr2 + xlr1 * xlr2)
 * tpo = (xm + xlr1) / (2*pi*nominal frequency * rr1)
 *
 * tppo = (xm * xlr1 + xm * xlr2 + xlr1 * xlr2) / (2*pi*nominal frequency * rr2 * (xm + xlr1).
 *
 * @param sup Reference to the superclass object.
 * @param rr1 Damper 1 winding resistance.
 * @param rr2 Damper 2 winding resistance.
 * @param xlr1 Damper 1 winding leakage reactance.
 * @param xlr2 Damper 2 winding leakage reactance.
 * @param xm Magnetizing reactance.
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineEquivalentCircuit
(
    override val sup: AsynchronousMachineDynamics,
    rr1: Double,
    rr2: Double,
    xlr1: Double,
    xlr2: Double,
    xm: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineEquivalentCircuit] }
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
        "\t\t<cim:AsynchronousMachineEquivalentCircuit.rr1>" + rr1 + "</cim:AsynchronousMachineEquivalentCircuit.rr1>\n" +
        "\t\t<cim:AsynchronousMachineEquivalentCircuit.rr2>" + rr2 + "</cim:AsynchronousMachineEquivalentCircuit.rr2>\n" +
        "\t\t<cim:AsynchronousMachineEquivalentCircuit.xlr1>" + xlr1 + "</cim:AsynchronousMachineEquivalentCircuit.xlr1>\n" +
        "\t\t<cim:AsynchronousMachineEquivalentCircuit.xlr2>" + xlr2 + "</cim:AsynchronousMachineEquivalentCircuit.xlr2>\n" +
        "\t\t<cim:AsynchronousMachineEquivalentCircuit.xm>" + xm + "</cim:AsynchronousMachineEquivalentCircuit.xm>\n"
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineEquivalentCircuit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachineEquivalentCircuit>"
    }
}

object AsynchronousMachineEquivalentCircuit
extends
    Parseable[AsynchronousMachineEquivalentCircuit]
{
    val rr1 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.rr1"""))
    val rr2 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.rr2"""))
    val xlr1 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xlr1"""))
    val xlr2 = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xlr2"""))
    val xm = parse_element (element ("""AsynchronousMachineEquivalentCircuit.xm"""))
    def parse (context: Context): AsynchronousMachineEquivalentCircuit =
    {
        AsynchronousMachineEquivalentCircuit(
            AsynchronousMachineDynamics.parse (context),
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
 * <ol>
 * <li>If <b>X''</b> = <b>X'</b>, a single cage (one equivalent rotor winding per axis) is modelled.</li>
 * <li>The �p� in the attribute names is a substitution for a �prime� in the usual parameter notation, e.g. tpo refers to T'o.</li>
 * </ol>
 * 
 * The parameters used for models expressed in time constant reactance form include:
 * <ul>
 * <li>RotatingMachine.ratedS (MVAbase)</li>
 * <li>RotatingMachineDynamics.damping (D)</li>
 * <li>RotatingMachineDynamics.inertia (H)</li>
 * <li>RotatingMachineDynamics.saturationFactor (S1)</li>
 * <li>RotatingMachineDynamics.saturationFactor120 (S12)</li>
 * <li>RotatingMachineDynamics.statorLeakageReactance (Xl)</li>
 * <li>RotatingMachineDynamics.statorResistance (Rs)</li>
 * <li>.xs (Xs)</li>
 * <li>.xp (X')</li>
 * <li>.xpp (X'')</li>
 * <li>.tpo (T'o)</li>
 * <li>.tppo (T''o).</li>
 *
 * </ul>
 *
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
 * @group AsynchronousMachineDynamics
 * @groupname AsynchronousMachineDynamics Package AsynchronousMachineDynamics
 * @groupdesc AsynchronousMachineDynamics An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine. 

The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.

The asynchronous machine model is used to model wind generators Type 1 and Type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 */
case class AsynchronousMachineTimeConstantReactance
(
    override val sup: AsynchronousMachineDynamics,
    tpo: Double,
    tppo: Double,
    xp: Double,
    xpp: Double,
    xs: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { clone ().asInstanceOf[AsynchronousMachineTimeConstantReactance] }
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
        "\t\t<cim:AsynchronousMachineTimeConstantReactance.tpo>" + tpo + "</cim:AsynchronousMachineTimeConstantReactance.tpo>\n" +
        "\t\t<cim:AsynchronousMachineTimeConstantReactance.tppo>" + tppo + "</cim:AsynchronousMachineTimeConstantReactance.tppo>\n" +
        "\t\t<cim:AsynchronousMachineTimeConstantReactance.xp>" + xp + "</cim:AsynchronousMachineTimeConstantReactance.xp>\n" +
        "\t\t<cim:AsynchronousMachineTimeConstantReactance.xpp>" + xpp + "</cim:AsynchronousMachineTimeConstantReactance.xpp>\n" +
        "\t\t<cim:AsynchronousMachineTimeConstantReactance.xs>" + xs + "</cim:AsynchronousMachineTimeConstantReactance.xs>\n"
    }
    override def export: String =
    {
        "\t<cim:AsynchronousMachineTimeConstantReactance rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AsynchronousMachineTimeConstantReactance>"
    }
}

object AsynchronousMachineTimeConstantReactance
extends
    Parseable[AsynchronousMachineTimeConstantReactance]
{
    val tpo = parse_element (element ("""AsynchronousMachineTimeConstantReactance.tpo"""))
    val tppo = parse_element (element ("""AsynchronousMachineTimeConstantReactance.tppo"""))
    val xp = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xp"""))
    val xpp = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xpp"""))
    val xs = parse_element (element ("""AsynchronousMachineTimeConstantReactance.xs"""))
    def parse (context: Context): AsynchronousMachineTimeConstantReactance =
    {
        AsynchronousMachineTimeConstantReactance(
            AsynchronousMachineDynamics.parse (context),
            toDouble (tpo (context), context),
            toDouble (tppo (context), context),
            toDouble (xp (context), context),
            toDouble (xpp (context), context),
            toDouble (xs (context), context)
        )
    }
}

private[ninecode] object _AsynchronousMachineDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            AsynchronousMachineDynamics.register,
            AsynchronousMachineEquivalentCircuit.register,
            AsynchronousMachineTimeConstantReactance.register
        )
    }
}