package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.
 * Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.
 */

/**
 * Type of generic non-linear load model.
 * @param sup Reference to the superclass object.
 * @param exponentialRecovery Exponential recovery model.
 * @param loadAdaptive Load adaptive model.
 */
case class GenericNonLinearLoadModelKind
(override val sup: BasicElement,
val exponentialRecovery: String,
val loadAdaptive: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[GenericNonLinearLoadModelKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenericNonLinearLoadModelKind
extends
    Parseable[GenericNonLinearLoadModelKind]
{
    val sup = BasicElement.parse _
    val exponentialRecovery = parse_attribute (attribute ("""GenericNonLinearLoadModelKind.exponentialRecovery"""))_
    val loadAdaptive = parse_attribute (attribute ("""GenericNonLinearLoadModelKind.loadAdaptive"""))_
    def parse (context: Context): GenericNonLinearLoadModelKind =
    {
        GenericNonLinearLoadModelKind(
            sup (context),
            exponentialRecovery (context),
            loadAdaptive (context)
        )
    }
}

/**
 * Standard aggregate load model comprised of static and/or dynamic components.
 * A static load model represents the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage. A dynamic load model can used to represent the aggregate response of the motor components of the load.
 * @param sup Reference to the superclass object.
 * @param LoadMotor Aggregate motor (dynamic) load associated with this aggregate load.
 * @param LoadStatic Aggregate static load associated with this aggregate load.
 */
case class LoadAggregate
(override val sup: LoadDynamics,
val LoadMotor: String,
val LoadStatic: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadAggregate]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadAggregate
extends
    Parseable[LoadAggregate]
{
    val sup = LoadDynamics.parse _
    val LoadMotor = parse_attribute (attribute ("""LoadAggregate.LoadMotor"""))_
    val LoadStatic = parse_attribute (attribute ("""LoadAggregate.LoadStatic"""))_
    def parse (context: Context): LoadAggregate =
    {
        LoadAggregate(
            sup (context),
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
 */
case class LoadComposite
(override val sup: LoadDynamics,
val epfd: Double,
val epfs: Double,
val epvd: Double,
val epvs: Double,
val eqfd: Double,
val eqfs: Double,
val eqvd: Double,
val eqvs: Double,
val h: Double,
val lfrac: Double,
val pfrac: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadComposite]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadComposite
extends
    Parseable[LoadComposite]
{
    val sup = LoadDynamics.parse _
    val epfd = parse_element (element ("""LoadComposite.epfd"""))_
    val epfs = parse_element (element ("""LoadComposite.epfs"""))_
    val epvd = parse_element (element ("""LoadComposite.epvd"""))_
    val epvs = parse_element (element ("""LoadComposite.epvs"""))_
    val eqfd = parse_element (element ("""LoadComposite.eqfd"""))_
    val eqfs = parse_element (element ("""LoadComposite.eqfs"""))_
    val eqvd = parse_element (element ("""LoadComposite.eqvd"""))_
    val eqvs = parse_element (element ("""LoadComposite.eqvs"""))_
    val h = parse_element (element ("""LoadComposite.h"""))_
    val lfrac = parse_element (element ("""LoadComposite.lfrac"""))_
    val pfrac = parse_element (element ("""LoadComposite.pfrac"""))_
    def parse (context: Context): LoadComposite =
    {
        LoadComposite(
            sup (context),
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

A standard feature of dynamic load behaviour modelling is the ability to associate the same behaviour to multiple energy consumers by means of a single aggregate load definition.
 * Aggregate loads are used to represent all or part of the real and reactive load from one or more loads in the static (power flow) data. This load is usually the aggregation of many individual load devices and the load model is approximate representation of the aggregate response of the load devices to system disturbances. The load model is always applied to individual bus loads (energy consumers) but a single set of load model parameters can used for all loads in the grouping.
 * @param sup Reference to the superclass object.
 */
case class LoadDynamics
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadDynamics
extends
    Parseable[LoadDynamics]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): LoadDynamics =
    {
        LoadDynamics(
            sup (context)
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
 */
case class LoadGenericNonLinear
(override val sup: LoadDynamics,
val bs: Double,
val bt: Double,
val genericNonLinearLoadModelType: String,
val ls: Double,
val lt: Double,
val pt: Double,
val qt: Double,
val tp: Double,
val tq: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadGenericNonLinear]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadGenericNonLinear
extends
    Parseable[LoadGenericNonLinear]
{
    val sup = LoadDynamics.parse _
    val bs = parse_element (element ("""LoadGenericNonLinear.bs"""))_
    val bt = parse_element (element ("""LoadGenericNonLinear.bt"""))_
    val genericNonLinearLoadModelType = parse_attribute (attribute ("""LoadGenericNonLinear.genericNonLinearLoadModelType"""))_
    val ls = parse_element (element ("""LoadGenericNonLinear.ls"""))_
    val lt = parse_element (element ("""LoadGenericNonLinear.lt"""))_
    val pt = parse_element (element ("""LoadGenericNonLinear.pt"""))_
    val qt = parse_element (element ("""LoadGenericNonLinear.qt"""))_
    val tp = parse_element (element ("""LoadGenericNonLinear.tp"""))_
    val tq = parse_element (element ("""LoadGenericNonLinear.tq"""))_
    def parse (context: Context): LoadGenericNonLinear =
    {
        LoadGenericNonLinear(
            sup (context),
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
 */
case class LoadMotor
(override val sup: IdentifiedObject,
val d: Double,
val h: Double,
val lfac: Double,
val lp: Double,
val lpp: Double,
val ls: Double,
val pfrac: Double,
val ra: Double,
val tbkr: Double,
val tpo: Double,
val tppo: Double,
val tv: Double,
val vt: Double,
val LoadAggregate: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadMotor]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadMotor
extends
    Parseable[LoadMotor]
{
    val sup = IdentifiedObject.parse _
    val d = parse_element (element ("""LoadMotor.d"""))_
    val h = parse_element (element ("""LoadMotor.h"""))_
    val lfac = parse_element (element ("""LoadMotor.lfac"""))_
    val lp = parse_element (element ("""LoadMotor.lp"""))_
    val lpp = parse_element (element ("""LoadMotor.lpp"""))_
    val ls = parse_element (element ("""LoadMotor.ls"""))_
    val pfrac = parse_element (element ("""LoadMotor.pfrac"""))_
    val ra = parse_element (element ("""LoadMotor.ra"""))_
    val tbkr = parse_element (element ("""LoadMotor.tbkr"""))_
    val tpo = parse_element (element ("""LoadMotor.tpo"""))_
    val tppo = parse_element (element ("""LoadMotor.tppo"""))_
    val tv = parse_element (element ("""LoadMotor.tv"""))_
    val vt = parse_element (element ("""LoadMotor.vt"""))_
    val LoadAggregate = parse_attribute (attribute ("""LoadMotor.LoadAggregate"""))_
    def parse (context: Context): LoadMotor =
    {
        LoadMotor(
            sup (context),
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
 */
case class LoadStatic
(override val sup: IdentifiedObject,
val ep1: Double,
val ep2: Double,
val ep3: Double,
val eq1: Double,
val eq2: Double,
val eq3: Double,
val kp1: Double,
val kp2: Double,
val kp3: Double,
val kp4: Double,
val kpf: Double,
val kq1: Double,
val kq2: Double,
val kq3: Double,
val kq4: Double,
val kqf: Double,
val staticLoadModelType: String,
val LoadAggregate: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadStatic]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadStatic
extends
    Parseable[LoadStatic]
{
    val sup = IdentifiedObject.parse _
    val ep1 = parse_element (element ("""LoadStatic.ep1"""))_
    val ep2 = parse_element (element ("""LoadStatic.ep2"""))_
    val ep3 = parse_element (element ("""LoadStatic.ep3"""))_
    val eq1 = parse_element (element ("""LoadStatic.eq1"""))_
    val eq2 = parse_element (element ("""LoadStatic.eq2"""))_
    val eq3 = parse_element (element ("""LoadStatic.eq3"""))_
    val kp1 = parse_element (element ("""LoadStatic.kp1"""))_
    val kp2 = parse_element (element ("""LoadStatic.kp2"""))_
    val kp3 = parse_element (element ("""LoadStatic.kp3"""))_
    val kp4 = parse_element (element ("""LoadStatic.kp4"""))_
    val kpf = parse_element (element ("""LoadStatic.kpf"""))_
    val kq1 = parse_element (element ("""LoadStatic.kq1"""))_
    val kq2 = parse_element (element ("""LoadStatic.kq2"""))_
    val kq3 = parse_element (element ("""LoadStatic.kq3"""))_
    val kq4 = parse_element (element ("""LoadStatic.kq4"""))_
    val kqf = parse_element (element ("""LoadStatic.kqf"""))_
    val staticLoadModelType = parse_attribute (attribute ("""LoadStatic.staticLoadModelType"""))_
    val LoadAggregate = parse_attribute (attribute ("""LoadStatic.LoadAggregate"""))_
    def parse (context: Context): LoadStatic =
    {
        LoadStatic(
            sup (context),
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

/**
 * Type of static load model.
 * @param sup Reference to the superclass object.
 * @param constantZ The load is represented as a constant impedance.
 *        ConstantZ P and Q equations are used and no attributes are required.
 * @param exponential Exponential P and Q equations are used and the following attributes are required:
kp1, kp2, kp3, kpf, ep1, ep2, ep3
 *        kq1, kq2, kq3, kqf, eq1, eq2, eq3.
 * @param zIP1 ZIP1 P and Q equations are used and the following attributes are required:
kp1, kp2, kp3, kpf
 *        kq1, kq2, kq3, kqf.
 * @param zIP2 This model separates the frequency-dependent load (primarily motors) from other load.
 *        ZIP2 P and Q equations are used and the following attributes are required:
 */
case class StaticLoadModelKind
(override val sup: BasicElement,
val constantZ: String,
val exponential: String,
val zIP1: String,
val zIP2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[StaticLoadModelKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StaticLoadModelKind
extends
    Parseable[StaticLoadModelKind]
{
    val sup = BasicElement.parse _
    val constantZ = parse_attribute (attribute ("""StaticLoadModelKind.constantZ"""))_
    val exponential = parse_attribute (attribute ("""StaticLoadModelKind.exponential"""))_
    val zIP1 = parse_attribute (attribute ("""StaticLoadModelKind.zIP1"""))_
    val zIP2 = parse_attribute (attribute ("""StaticLoadModelKind.zIP2"""))_
    def parse (context: Context): StaticLoadModelKind =
    {
        StaticLoadModelKind(
            sup (context),
            constantZ (context),
            exponential (context),
            zIP1 (context),
            zIP2 (context)
        )
    }
}

object _LoadDynamics
{
    def register: Unit =
    {
        GenericNonLinearLoadModelKind.register
        LoadAggregate.register
        LoadComposite.register
        LoadDynamics.register
        LoadGenericNonLinear.register
        LoadMotor.register
        LoadStatic.register
        StaticLoadModelKind.register
    }
}