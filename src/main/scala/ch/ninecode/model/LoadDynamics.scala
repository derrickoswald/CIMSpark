package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Standard aggregate load model comprised of static and/or dynamic components.
 *
 * A static load model represents the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage. A dynamic load model can used to represent the aggregate response of the motor components of the load.
 *
 * @param sup [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param LoadMotor [[ch.ninecode.model.LoadMotor LoadMotor]] Aggregate motor (dynamic) load associated with this aggregate load.
 * @param LoadStatic [[ch.ninecode.model.LoadStatic LoadStatic]] Aggregate static load associated with this aggregate load.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadAggregate.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadAggregate.fields (position), value)
        emitattr (0, LoadMotor)
        emitattr (1, LoadStatic)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadAggregate rdf:ID=\"%s\">\n%s\t</cim:LoadAggregate>".format (id, export_fields)
    }
}

object LoadAggregate
extends
    Parseable[LoadAggregate]
{
    val fields: Array[String] = Array[String] (
        "LoadMotor",
        "LoadStatic"
    )
    val LoadMotor: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LoadStatic: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LoadAggregate =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadAggregate (
            LoadDynamics.parse (context),
            mask (LoadMotor (), 0),
            mask (LoadStatic (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadMotor", "LoadMotor", false),
        Relationship ("LoadStatic", "LoadStatic", false)
    )
}

/**
 * This model combines static load and induction motor load effects.
 *
 * The dynamics of the motor are simplified by linearizing the induction machine equations.
 *
 * @param sup [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadComposite.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadComposite.fields (position), value)
        emitelem (0, epfd)
        emitelem (1, epfs)
        emitelem (2, epvd)
        emitelem (3, epvs)
        emitelem (4, eqfd)
        emitelem (5, eqfs)
        emitelem (6, eqvd)
        emitelem (7, eqvs)
        emitelem (8, h)
        emitelem (9, lfrac)
        emitelem (10, pfrac)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadComposite rdf:ID=\"%s\">\n%s\t</cim:LoadComposite>".format (id, export_fields)
    }
}

object LoadComposite
extends
    Parseable[LoadComposite]
{
    val fields: Array[String] = Array[String] (
        "epfd",
        "epfs",
        "epvd",
        "epvs",
        "eqfd",
        "eqfs",
        "eqvd",
        "eqvs",
        "h",
        "lfrac",
        "pfrac"
    )
    val epfd: Fielder = parse_element (element (cls, fields(0)))
    val epfs: Fielder = parse_element (element (cls, fields(1)))
    val epvd: Fielder = parse_element (element (cls, fields(2)))
    val epvs: Fielder = parse_element (element (cls, fields(3)))
    val eqfd: Fielder = parse_element (element (cls, fields(4)))
    val eqfs: Fielder = parse_element (element (cls, fields(5)))
    val eqvd: Fielder = parse_element (element (cls, fields(6)))
    val eqvs: Fielder = parse_element (element (cls, fields(7)))
    val h: Fielder = parse_element (element (cls, fields(8)))
    val lfrac: Fielder = parse_element (element (cls, fields(9)))
    val pfrac: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): LoadComposite =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadComposite (
            LoadDynamics.parse (context),
            toDouble (mask (epfd (), 0)),
            toDouble (mask (epfs (), 1)),
            toDouble (mask (epvd (), 2)),
            toDouble (mask (epvs (), 3)),
            toDouble (mask (eqfd (), 4)),
            toDouble (mask (eqfs (), 5)),
            toDouble (mask (eqvd (), 6)),
            toDouble (mask (eqvs (), 7)),
            toDouble (mask (h (), 8)),
            toDouble (mask (lfrac (), 9)),
            toDouble (mask (pfrac (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Load whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * 
 * A standard feature of dynamic load behaviour modelling is the ability to associate the same behaviour to multiple energy consumers by means of a single aggregate load definition.
 *
 * Aggregate loads are used to represent all or part of the real and reactive load from one or more loads in the static (power flow) data. This load is usually the aggregation of many individual load devices and the load model is approximate representation of the aggregate response of the load devices to system disturbances. The load model is always applied to individual bus loads (energy consumers) but a single set of load model parameters can used for all loads in the grouping.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:LoadDynamics rdf:ID=\"%s\">\n%s\t</cim:LoadDynamics>".format (id, export_fields)
    }
}

object LoadDynamics
extends
    Parseable[LoadDynamics]
{

    def parse (context: Context): LoadDynamics =
    {
        implicit val ctx: Context = context
        val ret = LoadDynamics (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * These load models (known also as generic non-linear dynamic (GNLD) load models) can be used in mid-term and long-term voltage stability simulations (i.e., to study voltage collapse), as they can replace a more detailed representation of aggregate load, including induction motors, thermostatically controlled and static loads.
 *
 * @param sup [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadGenericNonLinear.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadGenericNonLinear.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadGenericNonLinear.fields (position), value)
        emitelem (0, bs)
        emitelem (1, bt)
        emitattr (2, genericNonLinearLoadModelType)
        emitelem (3, ls)
        emitelem (4, lt)
        emitelem (5, pt)
        emitelem (6, qt)
        emitelem (7, tp)
        emitelem (8, tq)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadGenericNonLinear rdf:ID=\"%s\">\n%s\t</cim:LoadGenericNonLinear>".format (id, export_fields)
    }
}

object LoadGenericNonLinear
extends
    Parseable[LoadGenericNonLinear]
{
    val fields: Array[String] = Array[String] (
        "bs",
        "bt",
        "genericNonLinearLoadModelType",
        "ls",
        "lt",
        "pt",
        "qt",
        "tp",
        "tq"
    )
    val bs: Fielder = parse_element (element (cls, fields(0)))
    val bt: Fielder = parse_element (element (cls, fields(1)))
    val genericNonLinearLoadModelType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ls: Fielder = parse_element (element (cls, fields(3)))
    val lt: Fielder = parse_element (element (cls, fields(4)))
    val pt: Fielder = parse_element (element (cls, fields(5)))
    val qt: Fielder = parse_element (element (cls, fields(6)))
    val tp: Fielder = parse_element (element (cls, fields(7)))
    val tq: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): LoadGenericNonLinear =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadGenericNonLinear (
            LoadDynamics.parse (context),
            toDouble (mask (bs (), 0)),
            toDouble (mask (bt (), 1)),
            mask (genericNonLinearLoadModelType (), 2),
            toDouble (mask (ls (), 3)),
            toDouble (mask (lt (), 4)),
            toDouble (mask (pt (), 5)),
            toDouble (mask (qt (), 6)),
            toDouble (mask (tp (), 7)),
            toDouble (mask (tq (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Aggregate induction motor load.
 *
 * This model  is used to represent a fraction of an ordinary load as "induction motor load".  It allows load that is treated as ordinary constant power in power flow analysis to be represented by an induction motor in dynamic simulation.  If <b>Lpp</b> = 0. or <b>Lpp</b> = <b>Lp</b>, or <b>Tppo</b> = 0.,  only one cage is represented. Magnetic saturation is not modelled. Either a "one-cage" or "two-cage" model of the induction machine can be modelled. Magnetic saturation is not modelled.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param LoadAggregate [[ch.ninecode.model.LoadAggregate LoadAggregate]] Aggregate load to which this aggregate motor (dynamic) load belongs.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadMotor.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadMotor.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadMotor.fields (position), value)
        emitelem (0, d)
        emitelem (1, h)
        emitelem (2, lfac)
        emitelem (3, lp)
        emitelem (4, lpp)
        emitelem (5, ls)
        emitelem (6, pfrac)
        emitelem (7, ra)
        emitelem (8, tbkr)
        emitelem (9, tpo)
        emitelem (10, tppo)
        emitelem (11, tv)
        emitelem (12, vt)
        emitattr (13, LoadAggregate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadMotor rdf:ID=\"%s\">\n%s\t</cim:LoadMotor>".format (id, export_fields)
    }
}

object LoadMotor
extends
    Parseable[LoadMotor]
{
    val fields: Array[String] = Array[String] (
        "d",
        "h",
        "lfac",
        "lp",
        "lpp",
        "ls",
        "pfrac",
        "ra",
        "tbkr",
        "tpo",
        "tppo",
        "tv",
        "vt",
        "LoadAggregate"
    )
    val d: Fielder = parse_element (element (cls, fields(0)))
    val h: Fielder = parse_element (element (cls, fields(1)))
    val lfac: Fielder = parse_element (element (cls, fields(2)))
    val lp: Fielder = parse_element (element (cls, fields(3)))
    val lpp: Fielder = parse_element (element (cls, fields(4)))
    val ls: Fielder = parse_element (element (cls, fields(5)))
    val pfrac: Fielder = parse_element (element (cls, fields(6)))
    val ra: Fielder = parse_element (element (cls, fields(7)))
    val tbkr: Fielder = parse_element (element (cls, fields(8)))
    val tpo: Fielder = parse_element (element (cls, fields(9)))
    val tppo: Fielder = parse_element (element (cls, fields(10)))
    val tv: Fielder = parse_element (element (cls, fields(11)))
    val vt: Fielder = parse_element (element (cls, fields(12)))
    val LoadAggregate: Fielder = parse_attribute (attribute (cls, fields(13)))

    def parse (context: Context): LoadMotor =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadMotor (
            IdentifiedObject.parse (context),
            toDouble (mask (d (), 0)),
            toDouble (mask (h (), 1)),
            toDouble (mask (lfac (), 2)),
            toDouble (mask (lp (), 3)),
            toDouble (mask (lpp (), 4)),
            toDouble (mask (ls (), 5)),
            toDouble (mask (pfrac (), 6)),
            toDouble (mask (ra (), 7)),
            toDouble (mask (tbkr (), 8)),
            toDouble (mask (tpo (), 9)),
            toDouble (mask (tppo (), 10)),
            toDouble (mask (tv (), 11)),
            toDouble (mask (vt (), 12)),
            mask (LoadAggregate (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadAggregate", "LoadAggregate", false)
    )
}

/**
 * General static load model representing the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param LoadAggregate [[ch.ninecode.model.LoadAggregate LoadAggregate]] Aggregate load to which this aggregate static load belongs.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadStatic.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadStatic.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadStatic.fields (position), value)
        emitelem (0, ep1)
        emitelem (1, ep2)
        emitelem (2, ep3)
        emitelem (3, eq1)
        emitelem (4, eq2)
        emitelem (5, eq3)
        emitelem (6, kp1)
        emitelem (7, kp2)
        emitelem (8, kp3)
        emitelem (9, kp4)
        emitelem (10, kpf)
        emitelem (11, kq1)
        emitelem (12, kq2)
        emitelem (13, kq3)
        emitelem (14, kq4)
        emitelem (15, kqf)
        emitattr (16, staticLoadModelType)
        emitattr (17, LoadAggregate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadStatic rdf:ID=\"%s\">\n%s\t</cim:LoadStatic>".format (id, export_fields)
    }
}

object LoadStatic
extends
    Parseable[LoadStatic]
{
    val fields: Array[String] = Array[String] (
        "ep1",
        "ep2",
        "ep3",
        "eq1",
        "eq2",
        "eq3",
        "kp1",
        "kp2",
        "kp3",
        "kp4",
        "kpf",
        "kq1",
        "kq2",
        "kq3",
        "kq4",
        "kqf",
        "staticLoadModelType",
        "LoadAggregate"
    )
    val ep1: Fielder = parse_element (element (cls, fields(0)))
    val ep2: Fielder = parse_element (element (cls, fields(1)))
    val ep3: Fielder = parse_element (element (cls, fields(2)))
    val eq1: Fielder = parse_element (element (cls, fields(3)))
    val eq2: Fielder = parse_element (element (cls, fields(4)))
    val eq3: Fielder = parse_element (element (cls, fields(5)))
    val kp1: Fielder = parse_element (element (cls, fields(6)))
    val kp2: Fielder = parse_element (element (cls, fields(7)))
    val kp3: Fielder = parse_element (element (cls, fields(8)))
    val kp4: Fielder = parse_element (element (cls, fields(9)))
    val kpf: Fielder = parse_element (element (cls, fields(10)))
    val kq1: Fielder = parse_element (element (cls, fields(11)))
    val kq2: Fielder = parse_element (element (cls, fields(12)))
    val kq3: Fielder = parse_element (element (cls, fields(13)))
    val kq4: Fielder = parse_element (element (cls, fields(14)))
    val kqf: Fielder = parse_element (element (cls, fields(15)))
    val staticLoadModelType: Fielder = parse_attribute (attribute (cls, fields(16)))
    val LoadAggregate: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: Context): LoadStatic =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LoadStatic (
            IdentifiedObject.parse (context),
            toDouble (mask (ep1 (), 0)),
            toDouble (mask (ep2 (), 1)),
            toDouble (mask (ep3 (), 2)),
            toDouble (mask (eq1 (), 3)),
            toDouble (mask (eq2 (), 4)),
            toDouble (mask (eq3 (), 5)),
            toDouble (mask (kp1 (), 6)),
            toDouble (mask (kp2 (), 7)),
            toDouble (mask (kp3 (), 8)),
            toDouble (mask (kp4 (), 9)),
            toDouble (mask (kpf (), 10)),
            toDouble (mask (kq1 (), 11)),
            toDouble (mask (kq2 (), 12)),
            toDouble (mask (kq3 (), 13)),
            toDouble (mask (kq4 (), 14)),
            toDouble (mask (kqf (), 15)),
            mask (staticLoadModelType (), 16),
            mask (LoadAggregate (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadAggregate", "LoadAggregate", false)
    )
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