package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.
 * Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.
 */

/**
 * Type of generic non-linear load model.
 */
case class GenericNonLinearLoadModelKind
(

    override val sup: BasicElement,

    /**
     * Exponential recovery model.
     */
    val exponentialRecovery: String,

    /**
     * Load adaptive model.
     */
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
 */
case class LoadAggregate
(

    override val sup: LoadDynamics,

    /**
     * Aggregate motor (dynamic) load associated with this aggregate load.
     */
    val LoadMotor: String,

    /**
     * Aggregate static load associated with this aggregate load.
     */
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
 */
case class LoadComposite
(

    override val sup: LoadDynamics,

    /**
     * Active load-frequency dependence index (dynamic) (Epfd).
     * Typical Value = 1.5.
     */
    val epfd: Double,

    /**
     * Active load-frequency dependence index (static) (Epfs).
     * Typical Value = 1.5.
     */
    val epfs: Double,

    /**
     * Active load-voltage dependence index (dynamic) (Epvd).
     * Typical Value = 0.7.
     */
    val epvd: Double,

    /**
     * Active load-voltage dependence index (static) (Epvs).
     * Typical Value = 0.7.
     */
    val epvs: Double,

    /**
     * Reactive load-frequency dependence index (dynamic) (Eqfd).
     * Typical Value = 0.
     */
    val eqfd: Double,

    /**
     * Reactive load-frequency dependence index (static) (Eqfs).
     * Typical Value = 0.
     */
    val eqfs: Double,

    /**
     * Reactive load-voltage dependence index (dynamic) (Eqvd).
     * Typical Value = 2.
     */
    val eqvd: Double,

    /**
     * Reactive load-voltage dependence index (static) (Eqvs).
     * Typical Value = 2.
     */
    val eqvs: Double,

    /**
     * Inertia constant (H).
     * Typical Value = 2.5.
     */
    val h: Double,

    /**
     * Loading factor � ratio of initial P to motor MVA base (Lfrac).
     * Typical Value = 0.8.
     */
    val lfrac: Double,

    /**
     * Fraction of constant-power load to be represented by this motor model (Pfrac) (&gt;=0.0 and &lt;=1.0).
     * Typical Value = 0.5.
     */
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
 */
case class LoadDynamics
(

    override val sup: IdentifiedObject
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
 */
case class LoadGenericNonLinear
(

    override val sup: LoadDynamics,

    /**
     * Steady state voltage index for reactive power (BS).
     */
    val bs: Double,

    /**
     * Transient voltage index for reactive power (BT).
     */
    val bt: Double,

    /**
     * Type of generic non-linear load model.
     */
    val genericNonLinearLoadModelType: String,

    /**
     * Steady state voltage index for active power (LS).
     */
    val ls: Double,

    /**
     * Transient voltage index for active power (LT).
     */
    val lt: Double,

    /**
     * Dynamic portion of active load (P<sub>T</sub>).
     */
    val pt: Double,

    /**
     * Dynamic portion of reactive load (Q<sub>T</sub>).
     */
    val qt: Double,

    /**
     * Time constant of lag function of active power (T<sub>P</sub>).
     */
    val tp: Double,

    /**
     * Time constant of lag function of reactive power (T<sub>Q</sub>).
     */
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
 */
case class LoadMotor
(

    override val sup: IdentifiedObject,

    /**
     * Damping factor (D).
     * Unit = delta P/delta speed.  Typical Value = 2.
     */
    val d: Double,

    /**
     * Inertia constant (H) (not=0).
     * Typical Value = 0.4.
     */
    val h: Double,

    /**
     * Loading factor � ratio of initial P to motor MVA base (Lfac).
     * Typical Value = 0.8.
     */
    val lfac: Double,

    /**
     * Transient reactance (Lp).
     * Typical Value = 0.15.
     */
    val lp: Double,

    /**
     * Subtransient reactance (Lpp).
     * Typical Value = 0.15.
     */
    val lpp: Double,

    /**
     * Synchronous reactance (Ls).
     * Typical Value = 3.2.
     */
    val ls: Double,

    /**
     * Fraction of constant-power load to be represented by this motor model (Pfrac) (&gt;=0.0 and &lt;=1.0).
     * Typical Value = 0.3.
     */
    val pfrac: Double,

    /**
     * Stator resistance (Ra).
     * Typical Value = 0.
     */
    val ra: Double,

    /**
     * Circuit breaker operating time (Tbkr).
     * Typical Value = 0.08.
     */
    val tbkr: Double,

    /**
     * Transient rotor time constant (Tpo) (not=0).
     * Typical Value = 1.
     */
    val tpo: Double,

    /**
     * Subtransient rotor time constant (Tppo).
     * Typical Value = 0.02.
     */
    val tppo: Double,

    /**
     * Voltage trip pickup time (Tv).
     * Typical Value = 0.1.
     */
    val tv: Double,

    /**
     * Voltage threshold for tripping (Vt).
     * Typical Value = 0.7.
     */
    val vt: Double,

    /**
     * Aggregate load to which this aggregate motor (dynamic) load belongs.
     */
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
 */
case class LoadStatic
(

    override val sup: IdentifiedObject,

    /**
     * First term voltage exponent for active power (Ep1).
     * Used only when .staticLoadModelType = exponential.
     */
    val ep1: Double,

    /**
     * Second term voltage exponent for active power (Ep2).
     * Used only when .staticLoadModelType = exponential.
     */
    val ep2: Double,

    /**
     * Third term voltage exponent for active power (Ep3).
     * Used only when .staticLoadModelType = exponential.
     */
    val ep3: Double,

    /**
     * First term voltage exponent for reactive power (Eq1).
     * Used only when .staticLoadModelType = exponential.
     */
    val eq1: Double,

    /**
     * Second term voltage exponent for reactive power (Eq2).
     * Used only when .staticLoadModelType = exponential.
     */
    val eq2: Double,

    /**
     * Third term voltage exponent for reactive power (Eq3).
     * Used only when .staticLoadModelType = exponential.
     */
    val eq3: Double,

    /**
     * First term voltage coefficient for active power (Kp1).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kp1: Double,

    /**
     * Second term voltage coefficient for active power (Kp2).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kp2: Double,

    /**
     * Third term voltage coefficient for active power (Kp3).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kp3: Double,

    /**
     * Frequency coefficient for active power (Kp4).
     * Must be non-zero when .staticLoadModelType = ZIP2.  Not used for all other values of .staticLoadModelType.
     */
    val kp4: Double,

    /**
     * Frequency deviation coefficient for active power (Kpf).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kpf: Double,

    /**
     * First term voltage coefficient for reactive power (Kq1).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kq1: Double,

    /**
     * Second term voltage coefficient for reactive power (Kq2).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kq2: Double,

    /**
     * Third term voltage coefficient for reactive power (Kq3).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kq3: Double,

    /**
     * Frequency coefficient for reactive power (Kq4).
     * Must be non-zero when .staticLoadModelType = ZIP2.  Not used for all other values of .staticLoadModelType.
     */
    val kq4: Double,

    /**
     * Frequency deviation coefficient for reactive power (Kqf).
     * Not used when .staticLoadModelType = constantZ.
     */
    val kqf: Double,

    /**
     * Type of static load model.
     * Typical Value = constantZ.
     */
    val staticLoadModelType: String,

    /**
     * Aggregate load to which this aggregate static load belongs.
     */
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
 */
case class StaticLoadModelKind
(

    override val sup: BasicElement,

    /**
     * The load is represented as a constant impedance.
     * ConstantZ P and Q equations are used and no attributes are required.
     */
    val constantZ: String,

    /**
     * Exponential P and Q equations are used and the following attributes are required:
    kp1, kp2, kp3, kpf, ep1, ep2, ep3
     * kq1, kq2, kq3, kqf, eq1, eq2, eq3.
     */
    val exponential: String,

    /**
     * ZIP1 P and Q equations are used and the following attributes are required:
    kp1, kp2, kp3, kpf
     * kq1, kq2, kq3, kqf.
     */
    val zIP1: String,

    /**
     * This model separates the frequency-dependent load (primarily motors) from other load.
     * ZIP2 P and Q equations are used and the following attributes are required:
     */
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