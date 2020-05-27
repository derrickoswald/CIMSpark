package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Aggregate loads are used to represent all or part of the real and reactive load from one or more loads in the static (power flow) data.
 *
 * This load is usually the aggregation of many individual load devices and the load model is an approximate representation of the aggregate response of the load devices to system disturbances.
 * Standard aggregate load model comprised of static and/or dynamic components.  A static load model represents the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage. A dynamic load model can be used to represent the aggregate response of the motor components of the load.
 *
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param LoadMotor [[ch.ninecode.model.LoadMotor LoadMotor]] Aggregate motor (dynamic) load associated with this aggregate load.
 * @param LoadStatic [[ch.ninecode.model.LoadStatic LoadStatic]] Aggregate static load associated with this aggregate load.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadAggregate
(
    LoadDynamics: LoadDynamics = null,
    LoadMotor: String = null,
    LoadStatic: String = null
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
    override def sup: LoadDynamics = LoadDynamics

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
    override val fields: Array[String] = Array[String] (
        "LoadMotor",
        "LoadStatic"
    )
    override val relations: List[Relationship] = List (
        Relationship ("LoadMotor", "LoadMotor", "0..1", "1"),
        Relationship ("LoadStatic", "LoadStatic", "0..1", "1")
    )
    val LoadMotor: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LoadStatic: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LoadAggregate =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadAggregate (
            LoadDynamics.parse (context),
            mask (LoadMotor (), 0),
            mask (LoadStatic (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Combined static load and induction motor load effects.
 *
 * The dynamics of the motor are simplified by linearizing the induction machine equations.
 *
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param epfd Active load-frequency dependence index (dynamic) (<i>Epfd</i>).
 *        Typical value = 1,5.
 * @param epfs Active load-frequency dependence index (static) (<i>Epfs</i>).
 *        Typical value = 1,5.
 * @param epvd Active load-voltage dependence index (dynamic) (<i>Epvd</i>).
 *        Typical value = 0,7.
 * @param epvs Active load-voltage dependence index (static) (<i>Epvs</i>).
 *        Typical value = 0,7.
 * @param eqfd Reactive load-frequency dependence index (dynamic) (<i>Eqfd</i>).
 *        Typical value = 0.
 * @param eqfs Reactive load-frequency dependence index (static) (<i>Eqfs</i>).
 *        Typical value = 0.
 * @param eqvd Reactive load-voltage dependence index (dynamic) (<i>Eqvd</i>).
 *        Typical value = 2.
 * @param eqvs Reactive load-voltage dependence index (static) (<i>Eqvs</i>).
 *        Typical value = 2.
 * @param h Inertia constant (<i>H</i>) (&gt;= 0).
 *        Typical value = 2,5.
 * @param lfac Loading factor (<i>L</i><i><sub>fac</sub></i>).
 *        The ratio of initial <i>P</i> to motor MVA base.  Typical value = 0,8.
 * @param pfrac Fraction of constant-power load to be represented by this motor model (<i>P</i><i><sub>FRAC</sub></i>) (&gt;= 0,0 and &lt;= 1,0).
 *        Typical value = 0,5.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadComposite
(
    LoadDynamics: LoadDynamics = null,
    epfd: Double = 0.0,
    epfs: Double = 0.0,
    epvd: Double = 0.0,
    epvs: Double = 0.0,
    eqfd: Double = 0.0,
    eqfs: Double = 0.0,
    eqvd: Double = 0.0,
    eqvs: Double = 0.0,
    h: Double = 0.0,
    lfac: Double = 0.0,
    pfrac: Double = 0.0
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
    override def sup: LoadDynamics = LoadDynamics

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
        emitelem (9, lfac)
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
    override val fields: Array[String] = Array[String] (
        "epfd",
        "epfs",
        "epvd",
        "epvs",
        "eqfd",
        "eqfs",
        "eqvd",
        "eqvs",
        "h",
        "lfac",
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
    val lfac: Fielder = parse_element (element (cls, fields(9)))
    val pfrac: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): LoadComposite =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
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
            toDouble (mask (lfac (), 9)),
            toDouble (mask (pfrac (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Load whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * A standard feature of dynamic load behaviour modelling is the ability to associate the same behaviour to multiple energy consumers by means of a single load definition.
 *
 * The load model is always applied to individual bus loads (energy consumers).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Energy consumer to which this dynamics load model applies.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadDynamics
(
    IdentifiedObject: IdentifiedObject = null,
    EnergyConsumer: List[String] = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
        implicit val clz: String = LoadDynamics.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LoadDynamics.fields (position), x))
        emitattrs (0, EnergyConsumer)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "EnergyConsumer"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergyConsumer", "EnergyConsumer", "0..*", "0..1")
    )
    val EnergyConsumer: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): LoadDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadDynamics (
            IdentifiedObject.parse (context),
            masks (EnergyConsumer (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic non-linear dynamic (GNLD) load.
 *
 * This model can be used in mid-term and long-term voltage stability simulations (i.e., to study voltage collapse), as it can replace a more detailed representation of aggregate load, including induction motors, thermostatically controlled and static loads.
 *
 * @param LoadDynamics [[ch.ninecode.model.LoadDynamics LoadDynamics]] Reference to the superclass object.
 * @param bs Steady state voltage index for reactive power (<i>BS</i>).
 * @param bt Transient voltage index for reactive power (<i>BT</i>).
 * @param genericNonLinearLoadModelType Type of generic non-linear load model.
 * @param ls Steady state voltage index for active power (<i>LS</i>).
 * @param lt Transient voltage index for active power (<i>LT</i>).
 * @param tp Time constant of lag function of active power (<i>T</i><i><sub>P</sub></i>) (&gt; 0).
 * @param tq Time constant of lag function of reactive power (<i>T</i><i><sub>Q</sub></i>) (&gt; 0).
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadGenericNonLinear
(
    LoadDynamics: LoadDynamics = null,
    bs: Double = 0.0,
    bt: Double = 0.0,
    genericNonLinearLoadModelType: String = null,
    ls: Double = 0.0,
    lt: Double = 0.0,
    tp: Double = 0.0,
    tq: Double = 0.0
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
    override def sup: LoadDynamics = LoadDynamics

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
        implicit val clz: String = LoadGenericNonLinear.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadGenericNonLinear.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadGenericNonLinear.fields (position), value)
        emitelem (0, bs)
        emitelem (1, bt)
        emitattr (2, genericNonLinearLoadModelType)
        emitelem (3, ls)
        emitelem (4, lt)
        emitelem (5, tp)
        emitelem (6, tq)
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
    override val fields: Array[String] = Array[String] (
        "bs",
        "bt",
        "genericNonLinearLoadModelType",
        "ls",
        "lt",
        "tp",
        "tq"
    )
    val bs: Fielder = parse_element (element (cls, fields(0)))
    val bt: Fielder = parse_element (element (cls, fields(1)))
    val genericNonLinearLoadModelType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ls: Fielder = parse_element (element (cls, fields(3)))
    val lt: Fielder = parse_element (element (cls, fields(4)))
    val tp: Fielder = parse_element (element (cls, fields(5)))
    val tq: Fielder = parse_element (element (cls, fields(6)))

    def parse (context: Context): LoadGenericNonLinear =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadGenericNonLinear (
            LoadDynamics.parse (context),
            toDouble (mask (bs (), 0)),
            toDouble (mask (bt (), 1)),
            mask (genericNonLinearLoadModelType (), 2),
            toDouble (mask (ls (), 3)),
            toDouble (mask (lt (), 4)),
            toDouble (mask (tp (), 5)),
            toDouble (mask (tq (), 6))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Aggregate induction motor load.
 *
 * This model is used to represent a fraction of an ordinary load as "induction motor load".  It allows a load that is treated as an ordinary constant power in power flow analysis to be represented by an induction motor in dynamic simulation. This model is intended for representation of aggregations of many motors dispersed through a load represented at a high voltage bus but where there is no information on the characteristics of individual motors.
 * Either a "one-cage" or "two-cage" model of the induction machine can be modelled. Magnetic saturation is not modelled.
 * This model treats a fraction of the constant power part of a load as a motor. During initialisation, the initial power drawn by the motor is set equal to <i>Pfrac</i> times the constant <i>P</i> part of the static load.  The remainder of the load is left as a static load.
 * The reactive power demand of the motor is calculated during initialisation as a function of voltage at the load bus. This reactive power demand can be less than or greater than the constant <i>Q</i> component of the load.  If the motor's reactive demand is greater than the constant <i>Q</i> component of the load, the model inserts a shunt capacitor at the terminal of the motor to bring its reactive demand down to equal the constant <i>Q</i> reactive load.
 * If an induction motor load model and a static load model are both present for a load, the motor <i>Pfrac</i> is assumed to be subtracted from the power flow constant <i>P</i> load before the static load model is applied.  The remainder of the load, if any, is then represented by the static load model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param d Damping factor (<i>D</i>).
 *        Unit = delta <i>P</i>/delta speed.  Typical value = 2.
 * @param h Inertia constant (<i>H</i>) (&gt;= 0).
 *        Typical value = 0,4.
 * @param lfac Loading factor (<i>Lfac</i>).
 *        The ratio of initial <i>P</i> to motor MVA base.  Typical value = 0,8.
 * @param lp Transient reactance (<i>Lp</i>).
 *        Typical value = 0,15.
 * @param lpp Subtransient reactance (<i>Lpp</i>).
 *        Typical value = 0,15.
 * @param ls Synchronous reactance (<i>Ls</i>).
 *        Typical value = 3,2.
 * @param pfrac Fraction of constant-power load to be represented by this motor model (<i>Pfrac</i>) (&gt;= 0,0 and &lt;= 1,0).
 *        Typical value = 0,3.
 * @param ra Stator resistance (<i>Ra</i>).
 *        Typical value = 0.
 * @param tbkr Circuit breaker operating time (<i>Tbkr</i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param tpo Transient rotor time constant (<i>Tpo</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tppo Subtransient rotor time constant (<i>Tppo</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param tv Voltage trip pickup time (<i>Tv</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param vt Voltage threshold for tripping (<i>Vt</i>).
 *        Typical value = 0,7.
 * @param LoadAggregate [[ch.ninecode.model.LoadAggregate LoadAggregate]] Aggregate load to which this aggregate motor (dynamic) load belongs.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadMotor
(
    IdentifiedObject: IdentifiedObject = null,
    d: Double = 0.0,
    h: Double = 0.0,
    lfac: Double = 0.0,
    lp: Double = 0.0,
    lpp: Double = 0.0,
    ls: Double = 0.0,
    pfrac: Double = 0.0,
    ra: Double = 0.0,
    tbkr: Double = 0.0,
    tpo: Double = 0.0,
    tppo: Double = 0.0,
    tv: Double = 0.0,
    vt: Double = 0.0,
    LoadAggregate: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("LoadAggregate", "LoadAggregate", "1", "0..1")
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
        implicit val bitfields: Array[Int] = Array(0)
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
}

/**
 * General static load.
 *
 * This model represents the sensitivity of the real and reactive power consumed by the load to the amplitude and frequency of the bus voltage.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ep1 First term voltage exponent for active power (<i>Ep1</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param ep2 Second term voltage exponent for active power (<i>Ep2</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param ep3 Third term voltage exponent for active power (<i>Ep3</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq1 First term voltage exponent for reactive power (<i>Eq1</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq2 Second term voltage exponent for reactive power (<i>Eq2</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param eq3 Third term voltage exponent for reactive power (<i>Eq3</i>).
 *        Used only when .staticLoadModelType = exponential.
 * @param kp1 First term voltage coefficient for active power (<i>K</i><i><sub>p1</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp2 Second term voltage coefficient for active power (<i>K</i><i><sub>p2</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp3 Third term voltage coefficient for active power (<i>K</i><i><sub>p3</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kp4 Frequency coefficient for active power (<i>K</i><i><sub>p4</sub></i>)  (not = 0 if .staticLoadModelType = zIP2).
 *        Used only when .staticLoadModelType = zIP2.
 * @param kpf Frequency deviation coefficient for active power (<i>K</i><i><sub>pf</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq1 First term voltage coefficient for reactive power (<i>K</i><i><sub>q1</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq2 Second term voltage coefficient for reactive power (<i>K</i><i><sub>q2</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq3 Third term voltage coefficient for reactive power (<i>K</i><i><sub>q3</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param kq4 Frequency coefficient for reactive power (<i>K</i><i><sub>q4</sub></i>)  (not = 0 when .staticLoadModelType = zIP2).
 *        Used only when .staticLoadModelType - zIP2.
 * @param kqf Frequency deviation coefficient for reactive power (<i>K</i><i><sub>qf</sub></i>).
 *        Not used when .staticLoadModelType = constantZ.
 * @param staticLoadModelType Type of static load model.
 *        Typical value = constantZ.
 * @param LoadAggregate [[ch.ninecode.model.LoadAggregate LoadAggregate]] Aggregate load to which this aggregate static load belongs.
 * @group LoadDynamics
 * @groupname LoadDynamics Package LoadDynamics
 * @groupdesc LoadDynamics Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.  
Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.  
Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 */
final case class LoadStatic
(
    IdentifiedObject: IdentifiedObject = null,
    ep1: Double = 0.0,
    ep2: Double = 0.0,
    ep3: Double = 0.0,
    eq1: Double = 0.0,
    eq2: Double = 0.0,
    eq3: Double = 0.0,
    kp1: Double = 0.0,
    kp2: Double = 0.0,
    kp3: Double = 0.0,
    kp4: Double = 0.0,
    kpf: Double = 0.0,
    kq1: Double = 0.0,
    kq2: Double = 0.0,
    kq3: Double = 0.0,
    kq4: Double = 0.0,
    kqf: Double = 0.0,
    staticLoadModelType: String = null,
    LoadAggregate: String = null
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
    override def sup: IdentifiedObject = IdentifiedObject

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
    override val fields: Array[String] = Array[String] (
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
    override val relations: List[Relationship] = List (
        Relationship ("LoadAggregate", "LoadAggregate", "1", "0..1")
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
        implicit val bitfields: Array[Int] = Array(0)
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