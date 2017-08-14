package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Standard aggregate load model comprised of static and/or dynamic components.
 * A static load model represents the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage. A dynamic load model can used to represent the aggregate response of the motor components of the load.
 * @param sup Reference to the superclass object.
 * @param LoadMotor Aggregate motor (dynamic) load associated with this aggregate load.
 * @param LoadStatic Aggregate static load associated with this aggregate load.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadAggregate
(
    override val sup: LoadDynamics,
    LoadMotor: String,
    LoadStatic: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[LoadAggregate] }
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
        (if (null != LoadMotor) "\t\t<cim:LoadAggregate.LoadMotor rdf:resource=\"#" + LoadMotor + "\"/>\n" else "") +
        (if (null != LoadStatic) "\t\t<cim:LoadAggregate.LoadStatic rdf:resource=\"#" + LoadStatic + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadAggregate rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadAggregate>"
    }
}

object LoadAggregate
extends
    Parseable[LoadAggregate]
{
    val LoadMotor = parse_attribute (attribute ("""LoadAggregate.LoadMotor"""))
    val LoadStatic = parse_attribute (attribute ("""LoadAggregate.LoadStatic"""))
    def parse (context: Context): LoadAggregate =
    {
        LoadAggregate(
            LoadDynamics.parse (context),
            LoadMotor (context),
            LoadStatic (context)
        )
    }
}

/**
 * This model combines static load and induction motor load effects.
 * The dynamics of the motor are simplified by linearizing the induction machine equations.
 * @param sup Reference to the superclass object.
 * @param epfd Active load-frequency dependence index (dynamic) (Epfd).
 *        Typical Value = 1.5.
 * @param epfs Active load-frequency dependence index (static) (Epfs).
 *        Typical Value = 1.5.
 * @param epvd Active load-voltage dependence index (dynamic) (Epvd).
 *        Typical Value = 0.7.
 * @param epvs Active load-voltage dependence index (static) (Epvs).
 *        Typical Value = 0.7.
 * @param eqfd Reactive load-frequency dependence index (dynamic) (Eqfd).
 *        Typical Value = 0.
 * @param eqfs Reactive load-frequency dependence index (static) (Eqfs).
 *        Typical Value = 0.
 * @param eqvd Reactive load-voltage dependence index (dynamic) (Eqvd).
 *        Typical Value = 2.
 * @param eqvs Reactive load-voltage dependence index (static) (Eqvs).
 *        Typical Value = 2.
 * @param h Inertia constant (H).
 *        Typical Value = 2.5.
 * @param lfrac Loading factor � ratio of initial P to motor MVA base (Lfrac).
 *        Typical Value = 0.8.
 * @param pfrac Fraction of constant-power load to be represented by this motor model (Pfrac) (&gt;=0.0 and &lt;=1.0).
 *        Typical Value = 0.5.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadComposite
(
    override val sup: LoadDynamics,
    epfd: Double,
    epfs: Double,
    epvd: Double,
    epvs: Double,
    eqfd: Double,
    eqfs: Double,
    eqvd: Double,
    eqvs: Double,
    h: Double,
    lfrac: Double,
    pfrac: Double
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
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[LoadComposite] }
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
        "\t\t<cim:LoadComposite.epfd>" + epfd + "</cim:LoadComposite.epfd>\n" +
        "\t\t<cim:LoadComposite.epfs>" + epfs + "</cim:LoadComposite.epfs>\n" +
        "\t\t<cim:LoadComposite.epvd>" + epvd + "</cim:LoadComposite.epvd>\n" +
        "\t\t<cim:LoadComposite.epvs>" + epvs + "</cim:LoadComposite.epvs>\n" +
        "\t\t<cim:LoadComposite.eqfd>" + eqfd + "</cim:LoadComposite.eqfd>\n" +
        "\t\t<cim:LoadComposite.eqfs>" + eqfs + "</cim:LoadComposite.eqfs>\n" +
        "\t\t<cim:LoadComposite.eqvd>" + eqvd + "</cim:LoadComposite.eqvd>\n" +
        "\t\t<cim:LoadComposite.eqvs>" + eqvs + "</cim:LoadComposite.eqvs>\n" +
        "\t\t<cim:LoadComposite.h>" + h + "</cim:LoadComposite.h>\n" +
        "\t\t<cim:LoadComposite.lfrac>" + lfrac + "</cim:LoadComposite.lfrac>\n" +
        "\t\t<cim:LoadComposite.pfrac>" + pfrac + "</cim:LoadComposite.pfrac>\n"
    }
    override def export: String =
    {
        "\t<cim:LoadComposite rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadComposite>"
    }
}

object LoadComposite
extends
    Parseable[LoadComposite]
{
    val epfd = parse_element (element ("""LoadComposite.epfd"""))
    val epfs = parse_element (element ("""LoadComposite.epfs"""))
    val epvd = parse_element (element ("""LoadComposite.epvd"""))
    val epvs = parse_element (element ("""LoadComposite.epvs"""))
    val eqfd = parse_element (element ("""LoadComposite.eqfd"""))
    val eqfs = parse_element (element ("""LoadComposite.eqfs"""))
    val eqvd = parse_element (element ("""LoadComposite.eqvd"""))
    val eqvs = parse_element (element ("""LoadComposite.eqvs"""))
    val h = parse_element (element ("""LoadComposite.h"""))
    val lfrac = parse_element (element ("""LoadComposite.lfrac"""))
    val pfrac = parse_element (element ("""LoadComposite.pfrac"""))
    def parse (context: Context): LoadComposite =
    {
        LoadComposite(
            LoadDynamics.parse (context),
            toDouble (epfd (context), context),
            toDouble (epfs (context), context),
            toDouble (epvd (context), context),
            toDouble (epvs (context), context),
            toDouble (eqfd (context), context),
            toDouble (eqfs (context), context),
            toDouble (eqvd (context), context),
            toDouble (eqvs (context), context),
            toDouble (h (context), context),
            toDouble (lfrac (context), context),
            toDouble (pfrac (context), context)
        )
    }
}

/**
 * Load whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * 
 * A standard feature of dynamic load behaviour modelling is the ability to associate the same behaviour to multiple energy consumers by means of a single aggregate load definition.
 * Aggregate loads are used to represent all or part of the real and reactive load from one or more loads in the static (power flow) data. This load is usually the aggregation of many individual load devices and the load model is approximate representation of the aggregate response of the load devices to system disturbances. The load model is always applied to individual bus loads (energy consumers) but a single set of load model parameters can used for all loads in the grouping.
 * @param sup Reference to the superclass object.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadDynamics
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadDynamics] }
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
        ""
    }
    override def export: String =
    {
        "\t<cim:LoadDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadDynamics>"
    }
}

object LoadDynamics
extends
    Parseable[LoadDynamics]
{
    def parse (context: Context): LoadDynamics =
    {
        LoadDynamics(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * These load models (known also as generic non-linear dynamic (GNLD) load models) can be used in mid-term and long-term voltage stability simulations (i.e., to study voltage collapse), as they can replace a more detailed representation of aggregate load, including induction motors, thermostatically controlled and static loads.
 * @param sup Reference to the superclass object.
 * @param bs Steady state voltage index for reactive power (BS).
 * @param bt Transient voltage index for reactive power (BT).
 * @param genericNonLinearLoadModelType Type of generic non-linear load model.
 * @param ls Steady state voltage index for active power (LS).
 * @param lt Transient voltage index for active power (LT).
 * @param pt Dynamic portion of active load (P<sub>T</sub>).
 * @param qt Dynamic portion of reactive load (Q<sub>T</sub>).
 * @param tp Time constant of lag function of active power (T<sub>P</sub>).
 * @param tq Time constant of lag function of reactive power (T<sub>Q</sub>).
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadGenericNonLinear
(
    override val sup: LoadDynamics,
    bs: Double,
    bt: Double,
    genericNonLinearLoadModelType: String,
    ls: Double,
    lt: Double,
    pt: Double,
    qt: Double,
    tp: Double,
    tq: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { clone ().asInstanceOf[LoadGenericNonLinear] }
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
        "\t\t<cim:LoadGenericNonLinear.bs>" + bs + "</cim:LoadGenericNonLinear.bs>\n" +
        "\t\t<cim:LoadGenericNonLinear.bt>" + bt + "</cim:LoadGenericNonLinear.bt>\n" +
        (if (null != genericNonLinearLoadModelType) "\t\t<cim:LoadGenericNonLinear.genericNonLinearLoadModelType rdf:resource=\"#" + genericNonLinearLoadModelType + "\"/>\n" else "") +
        "\t\t<cim:LoadGenericNonLinear.ls>" + ls + "</cim:LoadGenericNonLinear.ls>\n" +
        "\t\t<cim:LoadGenericNonLinear.lt>" + lt + "</cim:LoadGenericNonLinear.lt>\n" +
        "\t\t<cim:LoadGenericNonLinear.pt>" + pt + "</cim:LoadGenericNonLinear.pt>\n" +
        "\t\t<cim:LoadGenericNonLinear.qt>" + qt + "</cim:LoadGenericNonLinear.qt>\n" +
        "\t\t<cim:LoadGenericNonLinear.tp>" + tp + "</cim:LoadGenericNonLinear.tp>\n" +
        "\t\t<cim:LoadGenericNonLinear.tq>" + tq + "</cim:LoadGenericNonLinear.tq>\n"
    }
    override def export: String =
    {
        "\t<cim:LoadGenericNonLinear rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadGenericNonLinear>"
    }
}

object LoadGenericNonLinear
extends
    Parseable[LoadGenericNonLinear]
{
    val bs = parse_element (element ("""LoadGenericNonLinear.bs"""))
    val bt = parse_element (element ("""LoadGenericNonLinear.bt"""))
    val genericNonLinearLoadModelType = parse_attribute (attribute ("""LoadGenericNonLinear.genericNonLinearLoadModelType"""))
    val ls = parse_element (element ("""LoadGenericNonLinear.ls"""))
    val lt = parse_element (element ("""LoadGenericNonLinear.lt"""))
    val pt = parse_element (element ("""LoadGenericNonLinear.pt"""))
    val qt = parse_element (element ("""LoadGenericNonLinear.qt"""))
    val tp = parse_element (element ("""LoadGenericNonLinear.tp"""))
    val tq = parse_element (element ("""LoadGenericNonLinear.tq"""))
    def parse (context: Context): LoadGenericNonLinear =
    {
        LoadGenericNonLinear(
            LoadDynamics.parse (context),
            toDouble (bs (context), context),
            toDouble (bt (context), context),
            genericNonLinearLoadModelType (context),
            toDouble (ls (context), context),
            toDouble (lt (context), context),
            toDouble (pt (context), context),
            toDouble (qt (context), context),
            toDouble (tp (context), context),
            toDouble (tq (context), context)
        )
    }
}

/**
 * Aggregate induction motor load.
 * This model  is used to represent a fraction of an ordinary load as "induction motor load".  It allows load that is treated as ordinary constant power in power flow analysis to be represented by an induction motor in dynamic simulation.  If <b>Lpp</b> = 0. or <b>Lpp</b> = <b>Lp</b>, or <b>Tppo</b> = 0.,  only one cage is represented. Magnetic saturation is not modelled. Either a "one-cage" or "two-cage" model of the induction machine can be modelled. Magnetic saturation is not modelled.
 * @param sup Reference to the superclass object.
 * @param d Damping factor (D).
 *        Unit = delta P/delta speed.  Typical Value = 2.
 * @param h Inertia constant (H) (not=0).
 *        Typical Value = 0.4.
 * @param lfac Loading factor � ratio of initial P to motor MVA base (Lfac).
 *        Typical Value = 0.8.
 * @param lp Transient reactance (Lp).
 *        Typical Value = 0.15.
 * @param lpp Subtransient reactance (Lpp).
 *        Typical Value = 0.15.
 * @param ls Synchronous reactance (Ls).
 *        Typical Value = 3.2.
 * @param pfrac Fraction of constant-power load to be represented by this motor model (Pfrac) (&gt;=0.0 and &lt;=1.0).
 *        Typical Value = 0.3.
 * @param ra Stator resistance (Ra).
 *        Typical Value = 0.
 * @param tbkr Circuit breaker operating time (Tbkr).
 *        Typical Value = 0.08.
 * @param tpo Transient rotor time constant (Tpo) (not=0).
 *        Typical Value = 1.
 * @param tppo Subtransient rotor time constant (Tppo).
 *        Typical Value = 0.02.
 * @param tv Voltage trip pickup time (Tv).
 *        Typical Value = 0.1.
 * @param vt Voltage threshold for tripping (Vt).
 *        Typical Value = 0.7.
 * @param LoadAggregate Aggregate load to which this aggregate motor (dynamic) load belongs.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadMotor
(
    override val sup: IdentifiedObject,
    d: Double,
    h: Double,
    lfac: Double,
    lp: Double,
    lpp: Double,
    ls: Double,
    pfrac: Double,
    ra: Double,
    tbkr: Double,
    tpo: Double,
    tppo: Double,
    tv: Double,
    vt: Double,
    LoadAggregate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadMotor] }
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
        "\t\t<cim:LoadMotor.d>" + d + "</cim:LoadMotor.d>\n" +
        "\t\t<cim:LoadMotor.h>" + h + "</cim:LoadMotor.h>\n" +
        "\t\t<cim:LoadMotor.lfac>" + lfac + "</cim:LoadMotor.lfac>\n" +
        "\t\t<cim:LoadMotor.lp>" + lp + "</cim:LoadMotor.lp>\n" +
        "\t\t<cim:LoadMotor.lpp>" + lpp + "</cim:LoadMotor.lpp>\n" +
        "\t\t<cim:LoadMotor.ls>" + ls + "</cim:LoadMotor.ls>\n" +
        "\t\t<cim:LoadMotor.pfrac>" + pfrac + "</cim:LoadMotor.pfrac>\n" +
        "\t\t<cim:LoadMotor.ra>" + ra + "</cim:LoadMotor.ra>\n" +
        "\t\t<cim:LoadMotor.tbkr>" + tbkr + "</cim:LoadMotor.tbkr>\n" +
        "\t\t<cim:LoadMotor.tpo>" + tpo + "</cim:LoadMotor.tpo>\n" +
        "\t\t<cim:LoadMotor.tppo>" + tppo + "</cim:LoadMotor.tppo>\n" +
        "\t\t<cim:LoadMotor.tv>" + tv + "</cim:LoadMotor.tv>\n" +
        "\t\t<cim:LoadMotor.vt>" + vt + "</cim:LoadMotor.vt>\n" +
        (if (null != LoadAggregate) "\t\t<cim:LoadMotor.LoadAggregate rdf:resource=\"#" + LoadAggregate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadMotor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadMotor>"
    }
}

object LoadMotor
extends
    Parseable[LoadMotor]
{
    val d = parse_element (element ("""LoadMotor.d"""))
    val h = parse_element (element ("""LoadMotor.h"""))
    val lfac = parse_element (element ("""LoadMotor.lfac"""))
    val lp = parse_element (element ("""LoadMotor.lp"""))
    val lpp = parse_element (element ("""LoadMotor.lpp"""))
    val ls = parse_element (element ("""LoadMotor.ls"""))
    val pfrac = parse_element (element ("""LoadMotor.pfrac"""))
    val ra = parse_element (element ("""LoadMotor.ra"""))
    val tbkr = parse_element (element ("""LoadMotor.tbkr"""))
    val tpo = parse_element (element ("""LoadMotor.tpo"""))
    val tppo = parse_element (element ("""LoadMotor.tppo"""))
    val tv = parse_element (element ("""LoadMotor.tv"""))
    val vt = parse_element (element ("""LoadMotor.vt"""))
    val LoadAggregate = parse_attribute (attribute ("""LoadMotor.LoadAggregate"""))
    def parse (context: Context): LoadMotor =
    {
        LoadMotor(
            IdentifiedObject.parse (context),
            toDouble (d (context), context),
            toDouble (h (context), context),
            toDouble (lfac (context), context),
            toDouble (lp (context), context),
            toDouble (lpp (context), context),
            toDouble (ls (context), context),
            toDouble (pfrac (context), context),
            toDouble (ra (context), context),
            toDouble (tbkr (context), context),
            toDouble (tpo (context), context),
            toDouble (tppo (context), context),
            toDouble (tv (context), context),
            toDouble (vt (context), context),
            LoadAggregate (context)
        )
    }
}

/**
 * General static load model representing the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage.
 * @param sup Reference to the superclass object.
 * @param ep1 First term voltage exponent for active power (Ep1).
 *        Used only when .staticLoadModelType = exponential.
 * @param ep2 Second term voltage exponent for active power (Ep2).
 *        Used only when .staticLoadModelType = exponential.
 * @param ep3 Third term voltage exponent for active power (Ep3).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq1 First term voltage exponent for reactive power (Eq1).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq2 Second term voltage exponent for reactive power (Eq2).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq3 Third term voltage exponent for reactive power (Eq3).
 *        Used only when .staticLoadModelType = exponential.
 * @param kp1 First term voltage coefficient for active power (Kp1).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp2 Second term voltage coefficient for active power (Kp2).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp3 Third term voltage coefficient for active power (Kp3).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp4 Frequency coefficient for active power (Kp4).
 *        Must be non-zero when .staticLoadModelType = ZIP2.  Not used for all other values of .staticLoadModelType.
 * @param kpf Frequency deviation coefficient for active power (Kpf).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq1 First term voltage coefficient for reactive power (Kq1).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq2 Second term voltage coefficient for reactive power (Kq2).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq3 Third term voltage coefficient for reactive power (Kq3).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq4 Frequency coefficient for reactive power (Kq4).
 *        Must be non-zero when .staticLoadModelType = ZIP2.  Not used for all other values of .staticLoadModelType.
 * @param kqf Frequency deviation coefficient for reactive power (Kqf).
 *        Not used when .staticLoadModelType = constantZ.
 * @param staticLoadModelType Type of static load model.
 *        Typical Value = constantZ.
 * @param LoadAggregate Aggregate load to which this aggregate static load belongs.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  

Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  

Large industrial motors or groups of similar motors may be represented by individual motor models (synchronous or asynchronous) which are usually represented as generators with negative Pgen in the static (power flow) data.  
In the CIM, such individual modelling is handled by child classes of either the SynchronousMachineDynamics or AsynchronousMachineDynamics classes.
 */
case class LoadStatic
(
    override val sup: IdentifiedObject,
    ep1: Double,
    ep2: Double,
    ep3: Double,
    eq1: Double,
    eq2: Double,
    eq3: Double,
    kp1: Double,
    kp2: Double,
    kp3: Double,
    kp4: Double,
    kpf: Double,
    kq1: Double,
    kq2: Double,
    kq3: Double,
    kq4: Double,
    kqf: Double,
    staticLoadModelType: String,
    LoadAggregate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadStatic] }
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
        "\t\t<cim:LoadStatic.ep1>" + ep1 + "</cim:LoadStatic.ep1>\n" +
        "\t\t<cim:LoadStatic.ep2>" + ep2 + "</cim:LoadStatic.ep2>\n" +
        "\t\t<cim:LoadStatic.ep3>" + ep3 + "</cim:LoadStatic.ep3>\n" +
        "\t\t<cim:LoadStatic.eq1>" + eq1 + "</cim:LoadStatic.eq1>\n" +
        "\t\t<cim:LoadStatic.eq2>" + eq2 + "</cim:LoadStatic.eq2>\n" +
        "\t\t<cim:LoadStatic.eq3>" + eq3 + "</cim:LoadStatic.eq3>\n" +
        "\t\t<cim:LoadStatic.kp1>" + kp1 + "</cim:LoadStatic.kp1>\n" +
        "\t\t<cim:LoadStatic.kp2>" + kp2 + "</cim:LoadStatic.kp2>\n" +
        "\t\t<cim:LoadStatic.kp3>" + kp3 + "</cim:LoadStatic.kp3>\n" +
        "\t\t<cim:LoadStatic.kp4>" + kp4 + "</cim:LoadStatic.kp4>\n" +
        "\t\t<cim:LoadStatic.kpf>" + kpf + "</cim:LoadStatic.kpf>\n" +
        "\t\t<cim:LoadStatic.kq1>" + kq1 + "</cim:LoadStatic.kq1>\n" +
        "\t\t<cim:LoadStatic.kq2>" + kq2 + "</cim:LoadStatic.kq2>\n" +
        "\t\t<cim:LoadStatic.kq3>" + kq3 + "</cim:LoadStatic.kq3>\n" +
        "\t\t<cim:LoadStatic.kq4>" + kq4 + "</cim:LoadStatic.kq4>\n" +
        "\t\t<cim:LoadStatic.kqf>" + kqf + "</cim:LoadStatic.kqf>\n" +
        (if (null != staticLoadModelType) "\t\t<cim:LoadStatic.staticLoadModelType rdf:resource=\"#" + staticLoadModelType + "\"/>\n" else "") +
        (if (null != LoadAggregate) "\t\t<cim:LoadStatic.LoadAggregate rdf:resource=\"#" + LoadAggregate + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadStatic rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadStatic>"
    }
}

object LoadStatic
extends
    Parseable[LoadStatic]
{
    val ep1 = parse_element (element ("""LoadStatic.ep1"""))
    val ep2 = parse_element (element ("""LoadStatic.ep2"""))
    val ep3 = parse_element (element ("""LoadStatic.ep3"""))
    val eq1 = parse_element (element ("""LoadStatic.eq1"""))
    val eq2 = parse_element (element ("""LoadStatic.eq2"""))
    val eq3 = parse_element (element ("""LoadStatic.eq3"""))
    val kp1 = parse_element (element ("""LoadStatic.kp1"""))
    val kp2 = parse_element (element ("""LoadStatic.kp2"""))
    val kp3 = parse_element (element ("""LoadStatic.kp3"""))
    val kp4 = parse_element (element ("""LoadStatic.kp4"""))
    val kpf = parse_element (element ("""LoadStatic.kpf"""))
    val kq1 = parse_element (element ("""LoadStatic.kq1"""))
    val kq2 = parse_element (element ("""LoadStatic.kq2"""))
    val kq3 = parse_element (element ("""LoadStatic.kq3"""))
    val kq4 = parse_element (element ("""LoadStatic.kq4"""))
    val kqf = parse_element (element ("""LoadStatic.kqf"""))
    val staticLoadModelType = parse_attribute (attribute ("""LoadStatic.staticLoadModelType"""))
    val LoadAggregate = parse_attribute (attribute ("""LoadStatic.LoadAggregate"""))
    def parse (context: Context): LoadStatic =
    {
        LoadStatic(
            IdentifiedObject.parse (context),
            toDouble (ep1 (context), context),
            toDouble (ep2 (context), context),
            toDouble (ep3 (context), context),
            toDouble (eq1 (context), context),
            toDouble (eq2 (context), context),
            toDouble (eq3 (context), context),
            toDouble (kp1 (context), context),
            toDouble (kp2 (context), context),
            toDouble (kp3 (context), context),
            toDouble (kp4 (context), context),
            toDouble (kpf (context), context),
            toDouble (kq1 (context), context),
            toDouble (kq2 (context), context),
            toDouble (kq3 (context), context),
            toDouble (kq4 (context), context),
            toDouble (kqf (context), context),
            staticLoadModelType (context),
            LoadAggregate (context)
        )
    }
}

private[ninecode] object _LoadDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            LoadAggregate.register,
            LoadComposite.register,
            LoadDynamics.register,
            LoadGenericNonLinear.register,
            LoadMotor.register,
            LoadStatic.register
        )
    }
}