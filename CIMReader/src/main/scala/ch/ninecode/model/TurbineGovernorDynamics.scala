package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Turbine-governor cross-compound function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param HighPressureSynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] High-pressure synchronous machine with which this cross-compound turbine governor is associated.
 * @param LowPressureSynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Low-pressure synchronous machine with which this cross-compound turbine governor is associated.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class CrossCompoundTurbineGovernorDynamics
(
    override val sup: DynamicsFunctionBlock = null,
    HighPressureSynchronousMachineDynamics: String = null,
    LowPressureSynchronousMachineDynamics: String = null
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[CrossCompoundTurbineGovernorDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CrossCompoundTurbineGovernorDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CrossCompoundTurbineGovernorDynamics.fields (position), value)
        emitattr (0, HighPressureSynchronousMachineDynamics)
        emitattr (1, LowPressureSynchronousMachineDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CrossCompoundTurbineGovernorDynamics rdf:ID=\"%s\">\n%s\t</cim:CrossCompoundTurbineGovernorDynamics>".format (id, export_fields)
    }
}

object CrossCompoundTurbineGovernorDynamics
extends
    Parseable[CrossCompoundTurbineGovernorDynamics]
{
    override val fields: Array[String] = Array[String] (
        "HighPressureSynchronousMachineDynamics",
        "LowPressureSynchronousMachineDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("HighPressureSynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..1"),
        Relationship ("LowPressureSynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..1")
    )
    val HighPressureSynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val LowPressureSynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): CrossCompoundTurbineGovernorDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CrossCompoundTurbineGovernorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (HighPressureSynchronousMachineDynamics (), 0),
            mask (LowPressureSynchronousMachineDynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General model for any prime mover with a PID governor, used primarily for combustion turbine and combined cycle units.
 *
 * This model can be used to represent a variety of prime movers controlled by PID governors.  It is suitable, for example, for the representation of:
 * <ul>
 * <li>gas turbine and single shaft combined cycle turbines</li>
 * </ul>
 * <ul>
 * <li>diesel engines with modern electronic or digital governors  </li>
 * </ul>
 * <ul>
 * <li>steam turbines where steam is supplied from a large boiler drum or a large header whose pressure is substantially constant over the period under study</li>
 * <li>simple hydro turbines in dam configurations where the water column length is short and water inertia effects are minimal.</li>
 * </ul>
 * Additional information on this model is available in the 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, 3.1.2.3 pages 3-4 (GGOV1).
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aset Acceleration limiter setpoint (<i>Aset</i>).
 *        Unit = PU / s.  Typical value = 0,01.
 * @param db Speed governor deadband in PU speed (<i>db</i>).
 *        In the majority of applications, it is recommended that this value be set to zero.  Typical value = 0.
 * @param dm Speed sensitivity coefficient (<i>Dm</i>).  <i>Dm</i> can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.
 *        If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical value = 0.
 * @param ka Acceleration limiter gain (<i>Ka</i>).
 *        Typical value = 10.
 * @param kdgov Governor derivative gain (<i>Kdgov</i>).
 *        Typical value = 0.
 * @param kigov Governor integral gain (<i>Kigov</i>).
 *        Typical value = 2.
 * @param kiload Load limiter integral gain for PI controller (<i>Kiload</i>).
 *        Typical value = 0,67.
 * @param kimw Power controller (reset) gain (<i>Kimw</i>).
 *        The default value of 0,01 corresponds to a reset time of 100 s.  A value of 0,001 corresponds to a relatively slow-acting load controller.  Typical value = 0,01.
 * @param kpgov Governor proportional gain (<i>Kpgov</i>).
 *        Typical value = 10.
 * @param kpload Load limiter proportional gain for PI controller (<i>Kpload</i>).
 *        Typical value = 2.
 * @param kturb Turbine gain (<i>Kturb</i>) (&gt; 0).
 *        Typical value = 1,5.
 * @param ldref Load limiter reference value (<i>Ldref</i>).
 *        Typical value = 1.
 * @param maxerr Maximum value for speed error signal (<i>maxerr</i>) (&gt; GovCT1.minerr).
 *        Typical value = 0,05.
 * @param minerr Minimum value for speed error signal (<i>minerr</i>) (&lt; GovCT1.maxerr).
 *        Typical value = -0,05.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param r Permanent droop (<i>R</i>).
 *        Typical value = 0,04.
 * @param rclose Minimum valve closing rate (<i>Rclose</i>).
 *        Unit = PU / s.  Typical value = -0,1.
 * @param rdown Maximum rate of load limit decrease (<i>Rdown</i>).
 *        Typical value = -99.
 * @param ropen Maximum valve opening rate (<i>Ropen</i>).
 *        Unit = PU / s.  Typical value = 0.10.
 * @param rselect Feedback signal for droop (<i>Rselect</i>).
 *        Typical value = electricalPower.
 * @param rup Maximum rate of load limit increase (<i>Rup</i>).
 *        Typical value = 99.
 * @param ta Acceleration limiter time constant (<i>Ta</i>) (&gt; 0).
 *        Typical value = 0,1.
 * @param tact Actuator time constant (<i>Tact</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param tb Turbine lag time constant (<i>Tb</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tc Turbine lead time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tdgov Governor derivative controller time constant (<i>Tdgov</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param teng Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (<i>Teng</i>) (&gt;= 0).  <i>Teng</i> should be zero in all but special cases where this transport delay is of particular concern.
 *        Typical value = 0.
 * @param tfload Load-limiter time constant (<i>Tfload</i>) (&gt; 0).
 *        Typical value = 3.
 * @param tpelec Electrical power transducer time constant (<i>Tpelec</i>) (&gt; 0).
 *        Typical value = 1.
 * @param tsa Temperature detection lead time constant (<i>Tsa</i>) (&gt;= 0).
 *        Typical value = 4.
 * @param tsb Temperature detection lag time constant (<i>Tsb</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param vmax Maximum valve position limit (<i>Vmax</i>) (&gt; GovCT1.vmin).
 *        Typical value = 1.
 * @param vmin Minimum valve position limit (<i>Vmin</i>) (&lt; GovCT1.vmax).
 *        Typical value = 0,15.
 * @param wfnl No load fuel flow (<i>Wfnl</i>).
 *        Typical value = 0,2.
 * @param wfspd Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (<i>Wfspd</i>).
 *        true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
 *        false = fuel control system keeps fuel flow independent of engine speed.
 *        Typical value = true.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovCT1
(
    override val sup: TurbineGovernorDynamics = null,
    aset: Double = 0.0,
    db: Double = 0.0,
    dm: Double = 0.0,
    ka: Double = 0.0,
    kdgov: Double = 0.0,
    kigov: Double = 0.0,
    kiload: Double = 0.0,
    kimw: Double = 0.0,
    kpgov: Double = 0.0,
    kpload: Double = 0.0,
    kturb: Double = 0.0,
    ldref: Double = 0.0,
    maxerr: Double = 0.0,
    minerr: Double = 0.0,
    mwbase: Double = 0.0,
    r: Double = 0.0,
    rclose: Double = 0.0,
    rdown: Double = 0.0,
    ropen: Double = 0.0,
    rselect: String = null,
    rup: Double = 0.0,
    ta: Double = 0.0,
    tact: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    tdgov: Double = 0.0,
    teng: Double = 0.0,
    tfload: Double = 0.0,
    tpelec: Double = 0.0,
    tsa: Double = 0.0,
    tsb: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0,
    wfnl: Double = 0.0,
    wfspd: Boolean = false
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovCT1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovCT1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovCT1.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GovCT1.fields (position), value)
        emitelem (0, aset)
        emitelem (1, db)
        emitelem (2, dm)
        emitelem (3, ka)
        emitelem (4, kdgov)
        emitelem (5, kigov)
        emitelem (6, kiload)
        emitelem (7, kimw)
        emitelem (8, kpgov)
        emitelem (9, kpload)
        emitelem (10, kturb)
        emitelem (11, ldref)
        emitelem (12, maxerr)
        emitelem (13, minerr)
        emitelem (14, mwbase)
        emitelem (15, r)
        emitelem (16, rclose)
        emitelem (17, rdown)
        emitelem (18, ropen)
        emitattr (19, rselect)
        emitelem (20, rup)
        emitelem (21, ta)
        emitelem (22, tact)
        emitelem (23, tb)
        emitelem (24, tc)
        emitelem (25, tdgov)
        emitelem (26, teng)
        emitelem (27, tfload)
        emitelem (28, tpelec)
        emitelem (29, tsa)
        emitelem (30, tsb)
        emitelem (31, vmax)
        emitelem (32, vmin)
        emitelem (33, wfnl)
        emitelem (34, wfspd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovCT1 rdf:ID=\"%s\">\n%s\t</cim:GovCT1>".format (id, export_fields)
    }
}

object GovCT1
extends
    Parseable[GovCT1]
{
    override val fields: Array[String] = Array[String] (
        "aset",
        "db",
        "dm",
        "ka",
        "kdgov",
        "kigov",
        "kiload",
        "kimw",
        "kpgov",
        "kpload",
        "kturb",
        "ldref",
        "maxerr",
        "minerr",
        "mwbase",
        "r",
        "rclose",
        "rdown",
        "ropen",
        "rselect",
        "rup",
        "ta",
        "tact",
        "tb",
        "tc",
        "tdgov",
        "teng",
        "tfload",
        "tpelec",
        "tsa",
        "tsb",
        "vmax",
        "vmin",
        "wfnl",
        "wfspd"
    )
    val aset: Fielder = parse_element (element (cls, fields(0)))
    val db: Fielder = parse_element (element (cls, fields(1)))
    val dm: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val kdgov: Fielder = parse_element (element (cls, fields(4)))
    val kigov: Fielder = parse_element (element (cls, fields(5)))
    val kiload: Fielder = parse_element (element (cls, fields(6)))
    val kimw: Fielder = parse_element (element (cls, fields(7)))
    val kpgov: Fielder = parse_element (element (cls, fields(8)))
    val kpload: Fielder = parse_element (element (cls, fields(9)))
    val kturb: Fielder = parse_element (element (cls, fields(10)))
    val ldref: Fielder = parse_element (element (cls, fields(11)))
    val maxerr: Fielder = parse_element (element (cls, fields(12)))
    val minerr: Fielder = parse_element (element (cls, fields(13)))
    val mwbase: Fielder = parse_element (element (cls, fields(14)))
    val r: Fielder = parse_element (element (cls, fields(15)))
    val rclose: Fielder = parse_element (element (cls, fields(16)))
    val rdown: Fielder = parse_element (element (cls, fields(17)))
    val ropen: Fielder = parse_element (element (cls, fields(18)))
    val rselect: Fielder = parse_attribute (attribute (cls, fields(19)))
    val rup: Fielder = parse_element (element (cls, fields(20)))
    val ta: Fielder = parse_element (element (cls, fields(21)))
    val tact: Fielder = parse_element (element (cls, fields(22)))
    val tb: Fielder = parse_element (element (cls, fields(23)))
    val tc: Fielder = parse_element (element (cls, fields(24)))
    val tdgov: Fielder = parse_element (element (cls, fields(25)))
    val teng: Fielder = parse_element (element (cls, fields(26)))
    val tfload: Fielder = parse_element (element (cls, fields(27)))
    val tpelec: Fielder = parse_element (element (cls, fields(28)))
    val tsa: Fielder = parse_element (element (cls, fields(29)))
    val tsb: Fielder = parse_element (element (cls, fields(30)))
    val vmax: Fielder = parse_element (element (cls, fields(31)))
    val vmin: Fielder = parse_element (element (cls, fields(32)))
    val wfnl: Fielder = parse_element (element (cls, fields(33)))
    val wfspd: Fielder = parse_element (element (cls, fields(34)))

    def parse (context: Context): GovCT1 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovCT1 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aset (), 0)),
            toDouble (mask (db (), 1)),
            toDouble (mask (dm (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (kdgov (), 4)),
            toDouble (mask (kigov (), 5)),
            toDouble (mask (kiload (), 6)),
            toDouble (mask (kimw (), 7)),
            toDouble (mask (kpgov (), 8)),
            toDouble (mask (kpload (), 9)),
            toDouble (mask (kturb (), 10)),
            toDouble (mask (ldref (), 11)),
            toDouble (mask (maxerr (), 12)),
            toDouble (mask (minerr (), 13)),
            toDouble (mask (mwbase (), 14)),
            toDouble (mask (r (), 15)),
            toDouble (mask (rclose (), 16)),
            toDouble (mask (rdown (), 17)),
            toDouble (mask (ropen (), 18)),
            mask (rselect (), 19),
            toDouble (mask (rup (), 20)),
            toDouble (mask (ta (), 21)),
            toDouble (mask (tact (), 22)),
            toDouble (mask (tb (), 23)),
            toDouble (mask (tc (), 24)),
            toDouble (mask (tdgov (), 25)),
            toDouble (mask (teng (), 26)),
            toDouble (mask (tfload (), 27)),
            toDouble (mask (tpelec (), 28)),
            toDouble (mask (tsa (), 29)),
            toDouble (mask (tsb (), 30)),
            toDouble (mask (vmax (), 31)),
            toDouble (mask (vmin (), 32)),
            toDouble (mask (wfnl (), 33)),
            toBoolean (mask (wfspd (), 34))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * General governor with frequency-dependent fuel flow limit.
 *
 * This model is a modification of the GovCT1<b> </b>model in order to represent the frequency-dependent fuel flow limit of a specific gas turbine manufacturer.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aset Acceleration limiter setpoint (<i>Aset</i>).
 *        Unit = PU / s.  Typical value = 10.
 * @param db Speed governor deadband in PU speed (<i>db</i>).
 *        In the majority of applications, it is recommended that this value be set to zero.  Typical value = 0.
 * @param dm Speed sensitivity coefficient (<i>Dm</i>).  <i>Dm</i> can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.
 *        If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical value = 0.
 * @param flim1 Frequency threshold 1 (<i>Flim1</i>).
 *        Unit = Hz.  Typical value = 59.
 * @param flim10 Frequency threshold 10 (<i>Flim10</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim2 Frequency threshold 2 (<i>Flim2</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim3 Frequency threshold 3 (<i>Flim3</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim4 Frequency threshold 4 (<i>Flim4</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim5 Frequency threshold 5 (<i>Flim5</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim6 Frequency threshold 6 (<i>Flim6</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim7 Frequency threshold 7 (<i>Flim7</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim8 Frequency threshold 8 (<i>Flim8</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param flim9 Frequency threshold 9 (<i>Flim9</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param ka Acceleration limiter gain (<i>Ka</i>).
 *        Typical value = 10.
 * @param kdgov Governor derivative gain (<i>Kdgov</i>).
 *        Typical value = 0.
 * @param kigov Governor integral gain (<i>Kigov</i>).
 *        Typical value = 0,45.
 * @param kiload Load limiter integral gain for PI controller (<i>Kiload</i>).
 *        Typical value = 1.
 * @param kimw Power controller (reset) gain (<i>Kimw</i>).
 *        The default value of 0,01 corresponds to a reset time of 100 seconds.  A value of 0,001 corresponds to a relatively slow-acting load controller.  Typical value = 0.
 * @param kpgov Governor proportional gain (<i>Kpgov</i>).
 *        Typical value = 4.
 * @param kpload Load limiter proportional gain for PI controller (<i>Kpload</i>).
 *        Typical value = 1.
 * @param kturb Turbine gain (<i>Kturb</i>).
 *        Typical value = 1,9168.
 * @param ldref Load limiter reference value (<i>Ldref</i>).
 *        Typical value = 1.
 * @param maxerr Maximum value for speed error signal (<i>Maxerr</i>) (&gt; GovCT2.minerr).
 *        Typical value = 1.
 * @param minerr Minimum value for speed error signal (<i>Minerr</i>) (&lt; GovCT2.maxerr).
 *        Typical value = -1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param plim1 Power limit 1 (<i>Plim1</i>).
 *        Typical value = 0,8325.
 * @param plim10 Power limit 10 (<i>Plim10</i>).
 *        Typical value = 0.
 * @param plim2 Power limit 2 (Plim2).
 *        Typical value = 0.
 * @param plim3 Power limit 3 (<i>Plim3</i>).
 *        Typical value = 0.
 * @param plim4 Power limit 4 (<i>Plim4</i>).
 *        Typical value = 0.
 * @param plim5 Power limit 5 (<i>Plim5</i>).
 *        Typical value = 0.
 * @param plim6 Power limit 6 (<i>Plim6</i>).
 *        Typical value = 0.
 * @param plim7 Power limit 7 (<i>Plim7</i>).
 *        Typical value = 0.
 * @param plim8 Power limit 8 (<i>Plim8</i>).
 *        Typical value = 0.
 * @param plim9 Power Limit 9 (<i>Plim9</i>).
 *        Typical value = 0.
 * @param prate Ramp rate for frequency-dependent power limit (<i>Prate</i>).
 *        Typical value = 0,017.
 * @param r Permanent droop (<i>R</i>).
 *        Typical value = 0,05.
 * @param rclose Minimum valve closing rate (<i>Rclose</i>).
 *        Unit = PU / s.  Typical value = -99.
 * @param rdown Maximum rate of load limit decrease (<i>Rdown</i>).
 *        Typical value = -99.
 * @param ropen Maximum valve opening rate (<i>Ropen</i>).
 *        Unit = PU / s.  Typical value = 99.
 * @param rselect Feedback signal for droop (<i>Rselect</i>).
 *        Typical value = electricalPower.
 * @param rup Maximum rate of load limit increase (<i>Rup</i>).
 *        Typical value = 99.
 * @param ta Acceleration limiter time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param tact Actuator time constant (<i>Tact</i>) (&gt;= 0).
 *        Typical value = 0,4.
 * @param tb Turbine lag time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tc Turbine lead time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tdgov Governor derivative controller time constant (<i>Tdgov</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param teng Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (<i>Teng</i>) (&gt;= 0).  <i>Teng</i> should be zero in all but special cases where this transport delay is of particular concern.
 *        Typical value = 0.
 * @param tfload Load limiter time constant (<i>Tfload</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param tpelec Electrical power transducer time constant (<i>Tpelec</i>) (&gt;= 0).
 *        Typical value = 2,5.
 * @param tsa Temperature detection lead time constant (<i>Tsa</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tsb Temperature detection lag time constant (<i>Tsb</i>) (&gt;= 0).
 *        Typical value = 50.
 * @param vmax Maximum valve position limit (<i>Vmax</i>) (&gt; GovCT2.vmin).
 *        Typical value = 1.
 * @param vmin Minimum valve position limit (<i>Vmin</i>) (&lt; GovCT2.vmax).
 *        Typical value = 0,175.
 * @param wfnl No load fuel flow (<i>Wfnl</i>).
 *        Typical value = 0,187.
 * @param wfspd Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (<i>Wfspd</i>).
 *        true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
 *        false = fuel control system keeps fuel flow independent of engine speed.
 *        Typical value = false.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovCT2
(
    override val sup: TurbineGovernorDynamics = null,
    aset: Double = 0.0,
    db: Double = 0.0,
    dm: Double = 0.0,
    flim1: Double = 0.0,
    flim10: Double = 0.0,
    flim2: Double = 0.0,
    flim3: Double = 0.0,
    flim4: Double = 0.0,
    flim5: Double = 0.0,
    flim6: Double = 0.0,
    flim7: Double = 0.0,
    flim8: Double = 0.0,
    flim9: Double = 0.0,
    ka: Double = 0.0,
    kdgov: Double = 0.0,
    kigov: Double = 0.0,
    kiload: Double = 0.0,
    kimw: Double = 0.0,
    kpgov: Double = 0.0,
    kpload: Double = 0.0,
    kturb: Double = 0.0,
    ldref: Double = 0.0,
    maxerr: Double = 0.0,
    minerr: Double = 0.0,
    mwbase: Double = 0.0,
    plim1: Double = 0.0,
    plim10: Double = 0.0,
    plim2: Double = 0.0,
    plim3: Double = 0.0,
    plim4: Double = 0.0,
    plim5: Double = 0.0,
    plim6: Double = 0.0,
    plim7: Double = 0.0,
    plim8: Double = 0.0,
    plim9: Double = 0.0,
    prate: Double = 0.0,
    r: Double = 0.0,
    rclose: Double = 0.0,
    rdown: Double = 0.0,
    ropen: Double = 0.0,
    rselect: String = null,
    rup: Double = 0.0,
    ta: Double = 0.0,
    tact: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    tdgov: Double = 0.0,
    teng: Double = 0.0,
    tfload: Double = 0.0,
    tpelec: Double = 0.0,
    tsa: Double = 0.0,
    tsb: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0,
    wfnl: Double = 0.0,
    wfspd: Boolean = false
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovCT2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovCT2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovCT2.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GovCT2.fields (position), value)
        emitelem (0, aset)
        emitelem (1, db)
        emitelem (2, dm)
        emitelem (3, flim1)
        emitelem (4, flim10)
        emitelem (5, flim2)
        emitelem (6, flim3)
        emitelem (7, flim4)
        emitelem (8, flim5)
        emitelem (9, flim6)
        emitelem (10, flim7)
        emitelem (11, flim8)
        emitelem (12, flim9)
        emitelem (13, ka)
        emitelem (14, kdgov)
        emitelem (15, kigov)
        emitelem (16, kiload)
        emitelem (17, kimw)
        emitelem (18, kpgov)
        emitelem (19, kpload)
        emitelem (20, kturb)
        emitelem (21, ldref)
        emitelem (22, maxerr)
        emitelem (23, minerr)
        emitelem (24, mwbase)
        emitelem (25, plim1)
        emitelem (26, plim10)
        emitelem (27, plim2)
        emitelem (28, plim3)
        emitelem (29, plim4)
        emitelem (30, plim5)
        emitelem (31, plim6)
        emitelem (32, plim7)
        emitelem (33, plim8)
        emitelem (34, plim9)
        emitelem (35, prate)
        emitelem (36, r)
        emitelem (37, rclose)
        emitelem (38, rdown)
        emitelem (39, ropen)
        emitattr (40, rselect)
        emitelem (41, rup)
        emitelem (42, ta)
        emitelem (43, tact)
        emitelem (44, tb)
        emitelem (45, tc)
        emitelem (46, tdgov)
        emitelem (47, teng)
        emitelem (48, tfload)
        emitelem (49, tpelec)
        emitelem (50, tsa)
        emitelem (51, tsb)
        emitelem (52, vmax)
        emitelem (53, vmin)
        emitelem (54, wfnl)
        emitelem (55, wfspd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovCT2 rdf:ID=\"%s\">\n%s\t</cim:GovCT2>".format (id, export_fields)
    }
}

object GovCT2
extends
    Parseable[GovCT2]
{
    override val fields: Array[String] = Array[String] (
        "aset",
        "db",
        "dm",
        "flim1",
        "flim10",
        "flim2",
        "flim3",
        "flim4",
        "flim5",
        "flim6",
        "flim7",
        "flim8",
        "flim9",
        "ka",
        "kdgov",
        "kigov",
        "kiload",
        "kimw",
        "kpgov",
        "kpload",
        "kturb",
        "ldref",
        "maxerr",
        "minerr",
        "mwbase",
        "plim1",
        "plim10",
        "plim2",
        "plim3",
        "plim4",
        "plim5",
        "plim6",
        "plim7",
        "plim8",
        "plim9",
        "prate",
        "r",
        "rclose",
        "rdown",
        "ropen",
        "rselect",
        "rup",
        "ta",
        "tact",
        "tb",
        "tc",
        "tdgov",
        "teng",
        "tfload",
        "tpelec",
        "tsa",
        "tsb",
        "vmax",
        "vmin",
        "wfnl",
        "wfspd"
    )
    val aset: Fielder = parse_element (element (cls, fields(0)))
    val db: Fielder = parse_element (element (cls, fields(1)))
    val dm: Fielder = parse_element (element (cls, fields(2)))
    val flim1: Fielder = parse_element (element (cls, fields(3)))
    val flim10: Fielder = parse_element (element (cls, fields(4)))
    val flim2: Fielder = parse_element (element (cls, fields(5)))
    val flim3: Fielder = parse_element (element (cls, fields(6)))
    val flim4: Fielder = parse_element (element (cls, fields(7)))
    val flim5: Fielder = parse_element (element (cls, fields(8)))
    val flim6: Fielder = parse_element (element (cls, fields(9)))
    val flim7: Fielder = parse_element (element (cls, fields(10)))
    val flim8: Fielder = parse_element (element (cls, fields(11)))
    val flim9: Fielder = parse_element (element (cls, fields(12)))
    val ka: Fielder = parse_element (element (cls, fields(13)))
    val kdgov: Fielder = parse_element (element (cls, fields(14)))
    val kigov: Fielder = parse_element (element (cls, fields(15)))
    val kiload: Fielder = parse_element (element (cls, fields(16)))
    val kimw: Fielder = parse_element (element (cls, fields(17)))
    val kpgov: Fielder = parse_element (element (cls, fields(18)))
    val kpload: Fielder = parse_element (element (cls, fields(19)))
    val kturb: Fielder = parse_element (element (cls, fields(20)))
    val ldref: Fielder = parse_element (element (cls, fields(21)))
    val maxerr: Fielder = parse_element (element (cls, fields(22)))
    val minerr: Fielder = parse_element (element (cls, fields(23)))
    val mwbase: Fielder = parse_element (element (cls, fields(24)))
    val plim1: Fielder = parse_element (element (cls, fields(25)))
    val plim10: Fielder = parse_element (element (cls, fields(26)))
    val plim2: Fielder = parse_element (element (cls, fields(27)))
    val plim3: Fielder = parse_element (element (cls, fields(28)))
    val plim4: Fielder = parse_element (element (cls, fields(29)))
    val plim5: Fielder = parse_element (element (cls, fields(30)))
    val plim6: Fielder = parse_element (element (cls, fields(31)))
    val plim7: Fielder = parse_element (element (cls, fields(32)))
    val plim8: Fielder = parse_element (element (cls, fields(33)))
    val plim9: Fielder = parse_element (element (cls, fields(34)))
    val prate: Fielder = parse_element (element (cls, fields(35)))
    val r: Fielder = parse_element (element (cls, fields(36)))
    val rclose: Fielder = parse_element (element (cls, fields(37)))
    val rdown: Fielder = parse_element (element (cls, fields(38)))
    val ropen: Fielder = parse_element (element (cls, fields(39)))
    val rselect: Fielder = parse_attribute (attribute (cls, fields(40)))
    val rup: Fielder = parse_element (element (cls, fields(41)))
    val ta: Fielder = parse_element (element (cls, fields(42)))
    val tact: Fielder = parse_element (element (cls, fields(43)))
    val tb: Fielder = parse_element (element (cls, fields(44)))
    val tc: Fielder = parse_element (element (cls, fields(45)))
    val tdgov: Fielder = parse_element (element (cls, fields(46)))
    val teng: Fielder = parse_element (element (cls, fields(47)))
    val tfload: Fielder = parse_element (element (cls, fields(48)))
    val tpelec: Fielder = parse_element (element (cls, fields(49)))
    val tsa: Fielder = parse_element (element (cls, fields(50)))
    val tsb: Fielder = parse_element (element (cls, fields(51)))
    val vmax: Fielder = parse_element (element (cls, fields(52)))
    val vmin: Fielder = parse_element (element (cls, fields(53)))
    val wfnl: Fielder = parse_element (element (cls, fields(54)))
    val wfspd: Fielder = parse_element (element (cls, fields(55)))

    def parse (context: Context): GovCT2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovCT2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aset (), 0)),
            toDouble (mask (db (), 1)),
            toDouble (mask (dm (), 2)),
            toDouble (mask (flim1 (), 3)),
            toDouble (mask (flim10 (), 4)),
            toDouble (mask (flim2 (), 5)),
            toDouble (mask (flim3 (), 6)),
            toDouble (mask (flim4 (), 7)),
            toDouble (mask (flim5 (), 8)),
            toDouble (mask (flim6 (), 9)),
            toDouble (mask (flim7 (), 10)),
            toDouble (mask (flim8 (), 11)),
            toDouble (mask (flim9 (), 12)),
            toDouble (mask (ka (), 13)),
            toDouble (mask (kdgov (), 14)),
            toDouble (mask (kigov (), 15)),
            toDouble (mask (kiload (), 16)),
            toDouble (mask (kimw (), 17)),
            toDouble (mask (kpgov (), 18)),
            toDouble (mask (kpload (), 19)),
            toDouble (mask (kturb (), 20)),
            toDouble (mask (ldref (), 21)),
            toDouble (mask (maxerr (), 22)),
            toDouble (mask (minerr (), 23)),
            toDouble (mask (mwbase (), 24)),
            toDouble (mask (plim1 (), 25)),
            toDouble (mask (plim10 (), 26)),
            toDouble (mask (plim2 (), 27)),
            toDouble (mask (plim3 (), 28)),
            toDouble (mask (plim4 (), 29)),
            toDouble (mask (plim5 (), 30)),
            toDouble (mask (plim6 (), 31)),
            toDouble (mask (plim7 (), 32)),
            toDouble (mask (plim8 (), 33)),
            toDouble (mask (plim9 (), 34)),
            toDouble (mask (prate (), 35)),
            toDouble (mask (r (), 36)),
            toDouble (mask (rclose (), 37)),
            toDouble (mask (rdown (), 38)),
            toDouble (mask (ropen (), 39)),
            mask (rselect (), 40),
            toDouble (mask (rup (), 41)),
            toDouble (mask (ta (), 42)),
            toDouble (mask (tact (), 43)),
            toDouble (mask (tb (), 44)),
            toDouble (mask (tc (), 45)),
            toDouble (mask (tdgov (), 46)),
            toDouble (mask (teng (), 47)),
            toDouble (mask (tfload (), 48)),
            toDouble (mask (tpelec (), 49)),
            toDouble (mask (tsa (), 50)),
            toDouble (mask (tsb (), 51)),
            toDouble (mask (vmax (), 52)),
            toDouble (mask (vmin (), 53)),
            toDouble (mask (wfnl (), 54)),
            toBoolean (mask (wfspd (), 55))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Single shaft gas turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param at Ambient temperature load limit (<i>Load Limit</i>).
 *        Typical value = 1.
 * @param dturb Turbine damping factor (<i>Dturb</i>).
 *        Typical value = 0,18.
 * @param kt Temperature limiter gain (<i>Kt</i>).
 *        Typical value = 3.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param r Permanent droop (<i>R</i>) (&gt;0).
 *        Typical value = 0,04.
 * @param t1 Governor mechanism time constant (<i>T1</i>) (&gt;= 0).  <i>T1</i> represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.
 *        Typical value = 0,5.
 * @param t2 Turbine power time constant (<i>T2</i>) (&gt;= 0).  <i>T2</i> represents delay due to internal energy storage of the gas turbine engine. <i>T2</i> can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of a free power turbine of an aero-derivative unit, for example.
 *        Typical value = 0,5.
 * @param t3 Turbine exhaust temperature time constant (<i>T3</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param vmax Maximum turbine power, PU of MWbase (<i>Vmax</i>) (&gt; GovGAST.vmin).
 *        Typical value = 1.
 * @param vmin Minimum turbine power, PU of MWbase (<i>Vmin</i>) (&lt; GovGAST.vmax).
 *        Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGAST
(
    override val sup: TurbineGovernorDynamics = null,
    at: Double = 0.0,
    dturb: Double = 0.0,
    kt: Double = 0.0,
    mwbase: Double = 0.0,
    r: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGAST.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGAST.fields (position), value)
        emitelem (0, at)
        emitelem (1, dturb)
        emitelem (2, kt)
        emitelem (3, mwbase)
        emitelem (4, r)
        emitelem (5, t1)
        emitelem (6, t2)
        emitelem (7, t3)
        emitelem (8, vmax)
        emitelem (9, vmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGAST rdf:ID=\"%s\">\n%s\t</cim:GovGAST>".format (id, export_fields)
    }
}

object GovGAST
extends
    Parseable[GovGAST]
{
    override val fields: Array[String] = Array[String] (
        "at",
        "dturb",
        "kt",
        "mwbase",
        "r",
        "t1",
        "t2",
        "t3",
        "vmax",
        "vmin"
    )
    val at: Fielder = parse_element (element (cls, fields(0)))
    val dturb: Fielder = parse_element (element (cls, fields(1)))
    val kt: Fielder = parse_element (element (cls, fields(2)))
    val mwbase: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val t1: Fielder = parse_element (element (cls, fields(5)))
    val t2: Fielder = parse_element (element (cls, fields(6)))
    val t3: Fielder = parse_element (element (cls, fields(7)))
    val vmax: Fielder = parse_element (element (cls, fields(8)))
    val vmin: Fielder = parse_element (element (cls, fields(9)))

    def parse (context: Context): GovGAST =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovGAST (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (at (), 0)),
            toDouble (mask (dturb (), 1)),
            toDouble (mask (kt (), 2)),
            toDouble (mask (mwbase (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (t1 (), 5)),
            toDouble (mask (t2 (), 6)),
            toDouble (mask (t3 (), 7)),
            toDouble (mask (vmax (), 8)),
            toDouble (mask (vmin (), 9))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified single shaft gas turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param a Turbine power time constant numerator scale factor (<i>a</i>).
 *        Typical value = 0,8.
 * @param b Turbine power time constant denominator scale factor (<i>b</i>) (&gt;0).
 *        Typical value = 1.
 * @param db1 Intentional dead-band width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param fidle Fuel flow at zero power output (<i>Fidle</i>).
 *        Typical value = 0,18.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2,PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param ka Governor gain (<i>Ka</i>).
 *        Typical value = 0.
 * @param kt Temperature limiter gain (<i>Kt</i>).
 *        Typical value = 3.
 * @param lmax Ambient temperature load limit (<i>Lmax</i>).  <i>Lmax</i> is the turbine power output corresponding to the limiting exhaust gas temperature.
 *        Typical value = 1.
 * @param loadinc Valve position change allowed at fast rate (<i>Loadinc</i>).
 *        Typical value = 0,05.
 * @param ltrate Maximum long term fuel valve opening rate (<i>Ltrate</i>).
 *        Typical value = 0,02.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param r Permanent droop (<i>R</i>) (&gt;0).
 *        Typical value = 0,04.
 * @param rmax Maximum fuel valve opening rate (<i>Rmax</i>).
 *        Unit = PU / s.  Typical value = 1.
 * @param t1 Governor mechanism time constant (<i>T1</i>) (&gt;= 0).  <i>T1</i> represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.
 *        Typical value = 0,5.
 * @param t2 Turbine power time constant (<i>T2</i>) (&gt;= 0). <i>T2</i> represents delay due to internal energy storage of the gas turbine engine. <i>T2</i> can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of the free power turbine of an aero-derivative unit, for example.
 *        Typical value = 0,5.
 * @param t3 Turbine exhaust temperature time constant (<i>T3</i>) (&gt;= 0).  <i>T3</i> represents delay in the exhaust temperature and load limiting system.
 *        Typical value = 3.
 * @param t4 Governor lead time constant (<i>T4</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t5 Governor lag time constant (<i>T5</i>) (&gt;= 0).
 *        If = 0, entire gain and lead-lag block is bypassed.  Typical value = 0.
 * @param tltr Valve position averaging time constant (<i>Tltr</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param vmax Maximum turbine power, PU of MWbase (<i>Vmax</i>) (&gt; GovGAST1.vmin).
 *        Typical value = 1.
 * @param vmin Minimum turbine power, PU of MWbase (<i>Vmin</i>) (&lt; GovGAST1.vmax).
 *        Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGAST1
(
    override val sup: TurbineGovernorDynamics = null,
    a: Double = 0.0,
    b: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    eps: Double = 0.0,
    fidle: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    ka: Double = 0.0,
    kt: Double = 0.0,
    lmax: Double = 0.0,
    loadinc: Double = 0.0,
    ltrate: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    r: Double = 0.0,
    rmax: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    tltr: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGAST1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGAST1.fields (position), value)
        emitelem (0, a)
        emitelem (1, b)
        emitelem (2, db1)
        emitelem (3, db2)
        emitelem (4, eps)
        emitelem (5, fidle)
        emitelem (6, gv1)
        emitelem (7, gv2)
        emitelem (8, gv3)
        emitelem (9, gv4)
        emitelem (10, gv5)
        emitelem (11, gv6)
        emitelem (12, ka)
        emitelem (13, kt)
        emitelem (14, lmax)
        emitelem (15, loadinc)
        emitelem (16, ltrate)
        emitelem (17, mwbase)
        emitelem (18, pgv1)
        emitelem (19, pgv2)
        emitelem (20, pgv3)
        emitelem (21, pgv4)
        emitelem (22, pgv5)
        emitelem (23, pgv6)
        emitelem (24, r)
        emitelem (25, rmax)
        emitelem (26, t1)
        emitelem (27, t2)
        emitelem (28, t3)
        emitelem (29, t4)
        emitelem (30, t5)
        emitelem (31, tltr)
        emitelem (32, vmax)
        emitelem (33, vmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGAST1 rdf:ID=\"%s\">\n%s\t</cim:GovGAST1>".format (id, export_fields)
    }
}

object GovGAST1
extends
    Parseable[GovGAST1]
{
    override val fields: Array[String] = Array[String] (
        "a",
        "b",
        "db1",
        "db2",
        "eps",
        "fidle",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "ka",
        "kt",
        "lmax",
        "loadinc",
        "ltrate",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "r",
        "rmax",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "tltr",
        "vmax",
        "vmin"
    )
    val a: Fielder = parse_element (element (cls, fields(0)))
    val b: Fielder = parse_element (element (cls, fields(1)))
    val db1: Fielder = parse_element (element (cls, fields(2)))
    val db2: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val fidle: Fielder = parse_element (element (cls, fields(5)))
    val gv1: Fielder = parse_element (element (cls, fields(6)))
    val gv2: Fielder = parse_element (element (cls, fields(7)))
    val gv3: Fielder = parse_element (element (cls, fields(8)))
    val gv4: Fielder = parse_element (element (cls, fields(9)))
    val gv5: Fielder = parse_element (element (cls, fields(10)))
    val gv6: Fielder = parse_element (element (cls, fields(11)))
    val ka: Fielder = parse_element (element (cls, fields(12)))
    val kt: Fielder = parse_element (element (cls, fields(13)))
    val lmax: Fielder = parse_element (element (cls, fields(14)))
    val loadinc: Fielder = parse_element (element (cls, fields(15)))
    val ltrate: Fielder = parse_element (element (cls, fields(16)))
    val mwbase: Fielder = parse_element (element (cls, fields(17)))
    val pgv1: Fielder = parse_element (element (cls, fields(18)))
    val pgv2: Fielder = parse_element (element (cls, fields(19)))
    val pgv3: Fielder = parse_element (element (cls, fields(20)))
    val pgv4: Fielder = parse_element (element (cls, fields(21)))
    val pgv5: Fielder = parse_element (element (cls, fields(22)))
    val pgv6: Fielder = parse_element (element (cls, fields(23)))
    val r: Fielder = parse_element (element (cls, fields(24)))
    val rmax: Fielder = parse_element (element (cls, fields(25)))
    val t1: Fielder = parse_element (element (cls, fields(26)))
    val t2: Fielder = parse_element (element (cls, fields(27)))
    val t3: Fielder = parse_element (element (cls, fields(28)))
    val t4: Fielder = parse_element (element (cls, fields(29)))
    val t5: Fielder = parse_element (element (cls, fields(30)))
    val tltr: Fielder = parse_element (element (cls, fields(31)))
    val vmax: Fielder = parse_element (element (cls, fields(32)))
    val vmin: Fielder = parse_element (element (cls, fields(33)))

    def parse (context: Context): GovGAST1 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovGAST1 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (b (), 1)),
            toDouble (mask (db1 (), 2)),
            toDouble (mask (db2 (), 3)),
            toDouble (mask (eps (), 4)),
            toDouble (mask (fidle (), 5)),
            toDouble (mask (gv1 (), 6)),
            toDouble (mask (gv2 (), 7)),
            toDouble (mask (gv3 (), 8)),
            toDouble (mask (gv4 (), 9)),
            toDouble (mask (gv5 (), 10)),
            toDouble (mask (gv6 (), 11)),
            toDouble (mask (ka (), 12)),
            toDouble (mask (kt (), 13)),
            toDouble (mask (lmax (), 14)),
            toDouble (mask (loadinc (), 15)),
            toDouble (mask (ltrate (), 16)),
            toDouble (mask (mwbase (), 17)),
            toDouble (mask (pgv1 (), 18)),
            toDouble (mask (pgv2 (), 19)),
            toDouble (mask (pgv3 (), 20)),
            toDouble (mask (pgv4 (), 21)),
            toDouble (mask (pgv5 (), 22)),
            toDouble (mask (pgv6 (), 23)),
            toDouble (mask (r (), 24)),
            toDouble (mask (rmax (), 25)),
            toDouble (mask (t1 (), 26)),
            toDouble (mask (t2 (), 27)),
            toDouble (mask (t3 (), 28)),
            toDouble (mask (t4 (), 29)),
            toDouble (mask (t5 (), 30)),
            toDouble (mask (tltr (), 31)),
            toDouble (mask (vmax (), 32)),
            toDouble (mask (vmin (), 33))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Gas turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param a Valve positioner (<i>A</i>).
 * @param af1 Exhaust temperature parameter (<i>Af1</i>).
 *        Unit = PU temperature.  Based on temperature in degrees C.
 * @param af2 Coefficient equal to 0,5(1-speed) (<i>Af2</i>).
 * @param b Valve positioner (<i>B</i>).
 * @param bf1 (<i>Bf1</i>).  <i>Bf1</i> = <i>E</i>(1 - <i>W</i>) where <i>E</i> (speed sensitivity coefficient) is 0,55 to 0,65 x <i>Tr</i>.
 *        Unit = PU temperature.  Based on temperature in degrees C.
 * @param bf2 Turbine torque coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (<i>Bf2</i>).
 * @param c Valve positioner (<i>C</i>).
 * @param cf2 Coefficient defining fuel flow where power output is 0% (<i>Cf2</i>).
 *        Synchronous but no output.  Typically 0,23 x K<sub>hhv</sub> (23% fuel flow).
 * @param ecr Combustion reaction time delay (<i>Ecr</i>) (&gt;= 0).
 * @param etd Turbine and exhaust delay (<i>Etd</i>) (&gt;= 0).
 * @param k3 Ratio of fuel adjustment (<i>K3</i>).
 * @param k4 Gain of radiation shield (<i>K4</i>).
 * @param k5 Gain of radiation shield (<i>K5</i>).
 * @param k6 Minimum fuel flow (<i>K6</i>).
 * @param kf Fuel system feedback (<i>Kf</i>).
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param t Fuel control time constant (<i>T</i>) (&gt;= 0).
 * @param t3 Radiation shield time constant (<i>T3</i>) (&gt;= 0).
 * @param t4 Thermocouple time constant (<i>T4</i>) (&gt;= 0).
 * @param t5 Temperature control time constant (<i>T5</i>) (&gt;= 0).
 * @param tc Temperature control (<i>Tc</i>).
 *        Unit = �F or �C depending on parameters <i>Af1</i> and <i>Bf1</i>.
 * @param tcd Compressor discharge time constant (<i>Tcd</i>) (&gt;= 0).
 * @param tf Fuel system time constant (<i>Tf</i>) (&gt;= 0).
 * @param tmax Maximum turbine limit (<i>Tmax</i>) (&gt; GovGAST2.tmin).
 * @param tmin Minimum turbine limit (<i>Tmin</i>) (&lt; GovGAST2.tmax).
 * @param tr Rated temperature (<i>Tr</i>).
 *        Unit = �C depending on parameters<i> Af1 </i>and <i>Bf1</i>.
 * @param trate Turbine rating (<i>Trate</i>).
 *        Unit = MW.
 * @param tt Temperature controller integration rate (<i>Tt</i>) (&gt;= 0).
 * @param w Governor gain (1/droop) on turbine rating (<i>W</i>).
 * @param x Governor lead time constant (<i>X</i>) (&gt;= 0).
 * @param y Governor lag time constant (<i>Y</i>) (&gt; 0).
 * @param z Governor mode (<i>Z</i>).
 *        1 = droop
 *        0 = isochronous.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGAST2
(
    override val sup: TurbineGovernorDynamics = null,
    a: Double = 0.0,
    af1: Double = 0.0,
    af2: Double = 0.0,
    b: Double = 0.0,
    bf1: Double = 0.0,
    bf2: Double = 0.0,
    c: Double = 0.0,
    cf2: Double = 0.0,
    ecr: Double = 0.0,
    etd: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    k5: Double = 0.0,
    k6: Double = 0.0,
    kf: Double = 0.0,
    mwbase: Double = 0.0,
    t: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    tc: Double = 0.0,
    tcd: Double = 0.0,
    tf: Double = 0.0,
    tmax: Double = 0.0,
    tmin: Double = 0.0,
    tr: Double = 0.0,
    trate: Double = 0.0,
    tt: Double = 0.0,
    w: Double = 0.0,
    x: Double = 0.0,
    y: Double = 0.0,
    z: Int = 0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGAST2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGAST2.fields (position), value)
        emitelem (0, a)
        emitelem (1, af1)
        emitelem (2, af2)
        emitelem (3, b)
        emitelem (4, bf1)
        emitelem (5, bf2)
        emitelem (6, c)
        emitelem (7, cf2)
        emitelem (8, ecr)
        emitelem (9, etd)
        emitelem (10, k3)
        emitelem (11, k4)
        emitelem (12, k5)
        emitelem (13, k6)
        emitelem (14, kf)
        emitelem (15, mwbase)
        emitelem (16, t)
        emitelem (17, t3)
        emitelem (18, t4)
        emitelem (19, t5)
        emitelem (20, tc)
        emitelem (21, tcd)
        emitelem (22, tf)
        emitelem (23, tmax)
        emitelem (24, tmin)
        emitelem (25, tr)
        emitelem (26, trate)
        emitelem (27, tt)
        emitelem (28, w)
        emitelem (29, x)
        emitelem (30, y)
        emitelem (31, z)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGAST2 rdf:ID=\"%s\">\n%s\t</cim:GovGAST2>".format (id, export_fields)
    }
}

object GovGAST2
extends
    Parseable[GovGAST2]
{
    override val fields: Array[String] = Array[String] (
        "a",
        "af1",
        "af2",
        "b",
        "bf1",
        "bf2",
        "c",
        "cf2",
        "ecr",
        "etd",
        "k3",
        "k4",
        "k5",
        "k6",
        "kf",
        "mwbase",
        "t",
        "t3",
        "t4",
        "t5",
        "tc",
        "tcd",
        "tf",
        "tmax",
        "tmin",
        "tr",
        "trate",
        "tt",
        "w",
        "x",
        "y",
        "z"
    )
    val a: Fielder = parse_element (element (cls, fields(0)))
    val af1: Fielder = parse_element (element (cls, fields(1)))
    val af2: Fielder = parse_element (element (cls, fields(2)))
    val b: Fielder = parse_element (element (cls, fields(3)))
    val bf1: Fielder = parse_element (element (cls, fields(4)))
    val bf2: Fielder = parse_element (element (cls, fields(5)))
    val c: Fielder = parse_element (element (cls, fields(6)))
    val cf2: Fielder = parse_element (element (cls, fields(7)))
    val ecr: Fielder = parse_element (element (cls, fields(8)))
    val etd: Fielder = parse_element (element (cls, fields(9)))
    val k3: Fielder = parse_element (element (cls, fields(10)))
    val k4: Fielder = parse_element (element (cls, fields(11)))
    val k5: Fielder = parse_element (element (cls, fields(12)))
    val k6: Fielder = parse_element (element (cls, fields(13)))
    val kf: Fielder = parse_element (element (cls, fields(14)))
    val mwbase: Fielder = parse_element (element (cls, fields(15)))
    val t: Fielder = parse_element (element (cls, fields(16)))
    val t3: Fielder = parse_element (element (cls, fields(17)))
    val t4: Fielder = parse_element (element (cls, fields(18)))
    val t5: Fielder = parse_element (element (cls, fields(19)))
    val tc: Fielder = parse_element (element (cls, fields(20)))
    val tcd: Fielder = parse_element (element (cls, fields(21)))
    val tf: Fielder = parse_element (element (cls, fields(22)))
    val tmax: Fielder = parse_element (element (cls, fields(23)))
    val tmin: Fielder = parse_element (element (cls, fields(24)))
    val tr: Fielder = parse_element (element (cls, fields(25)))
    val trate: Fielder = parse_element (element (cls, fields(26)))
    val tt: Fielder = parse_element (element (cls, fields(27)))
    val w: Fielder = parse_element (element (cls, fields(28)))
    val x: Fielder = parse_element (element (cls, fields(29)))
    val y: Fielder = parse_element (element (cls, fields(30)))
    val z: Fielder = parse_element (element (cls, fields(31)))

    def parse (context: Context): GovGAST2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovGAST2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (af1 (), 1)),
            toDouble (mask (af2 (), 2)),
            toDouble (mask (b (), 3)),
            toDouble (mask (bf1 (), 4)),
            toDouble (mask (bf2 (), 5)),
            toDouble (mask (c (), 6)),
            toDouble (mask (cf2 (), 7)),
            toDouble (mask (ecr (), 8)),
            toDouble (mask (etd (), 9)),
            toDouble (mask (k3 (), 10)),
            toDouble (mask (k4 (), 11)),
            toDouble (mask (k5 (), 12)),
            toDouble (mask (k6 (), 13)),
            toDouble (mask (kf (), 14)),
            toDouble (mask (mwbase (), 15)),
            toDouble (mask (t (), 16)),
            toDouble (mask (t3 (), 17)),
            toDouble (mask (t4 (), 18)),
            toDouble (mask (t5 (), 19)),
            toDouble (mask (tc (), 20)),
            toDouble (mask (tcd (), 21)),
            toDouble (mask (tf (), 22)),
            toDouble (mask (tmax (), 23)),
            toDouble (mask (tmin (), 24)),
            toDouble (mask (tr (), 25)),
            toDouble (mask (trate (), 26)),
            toDouble (mask (tt (), 27)),
            toDouble (mask (w (), 28)),
            toDouble (mask (x (), 29)),
            toDouble (mask (y (), 30)),
            toInteger (mask (z (), 31))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic turbogas with acceleration and temperature controller.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param bca Acceleration limit set-point (<i>Bca</i>).
 *        Unit = 1/s.  Typical value = 0,01.
 * @param bp Droop (<i>bp</i>).
 *        Typical value = 0,05.
 * @param dtc Exhaust temperature variation due to fuel flow increasing from 0 to 1 PU (<i>deltaTc</i>).
 *        Typical value = 390.
 * @param ka Minimum fuel flow (<i>Ka</i>).
 *        Typical value = 0,23.
 * @param kac Fuel system feedback (<i>K</i><i><sub>AC</sub></i>).
 *        Typical value = 0.
 * @param kca Acceleration control integral gain (<i>Kca</i>).
 *        Unit = 1/s.  Typical value = 100.
 * @param ksi Gain of radiation shield (<i>Ksi</i>).
 *        Typical value = 0,8.
 * @param ky Coefficient of transfer function of fuel valve positioner (<i>Ky</i>).
 *        Typical value = 1.
 * @param mnef Fuel flow maximum negative error value (<i>MNef</i>).
 *        Typical value = -0,05.
 * @param mxef Fuel flow maximum positive error value (<i>MXef</i>).
 *        Typical value = 0,05.
 * @param rcmn Minimum fuel flow (<i>RCMN</i>).
 *        Typical value = -0,1.
 * @param rcmx Maximum fuel flow (<i>RCMX</i>).
 *        Typical value = 1.
 * @param tac Fuel control time constant (<i>Tac</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tc Compressor discharge volume time constant (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param td Temperature controller derivative gain (<i>Td</i>) (&gt;= 0).
 *        Typical value = 3,3.
 * @param tfen Turbine rated exhaust temperature correspondent to Pm=1 PU (<i>Tfen</i>).
 *        Typical value = 540.
 * @param tg Time constant of speed governor (<i>Tg</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tsi Time constant of radiation shield (<i>Tsi</i>) (&gt;= 0).
 *        Typical value = 15.
 * @param tt Temperature controller integration rate (<i>Tt</i>).
 *        Typical value = 250.
 * @param ttc Time constant of thermocouple (<i>Ttc</i>) (&gt;= 0).
 *        Typical value = 2,5.
 * @param ty Time constant of fuel valve positioner (<i>Ty</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGAST3
(
    override val sup: TurbineGovernorDynamics = null,
    bca: Double = 0.0,
    bp: Double = 0.0,
    dtc: Double = 0.0,
    ka: Double = 0.0,
    kac: Double = 0.0,
    kca: Double = 0.0,
    ksi: Double = 0.0,
    ky: Double = 0.0,
    mnef: Double = 0.0,
    mxef: Double = 0.0,
    rcmn: Double = 0.0,
    rcmx: Double = 0.0,
    tac: Double = 0.0,
    tc: Double = 0.0,
    td: Double = 0.0,
    tfen: Double = 0.0,
    tg: Double = 0.0,
    tsi: Double = 0.0,
    tt: Double = 0.0,
    ttc: Double = 0.0,
    ty: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST3] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGAST3.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGAST3.fields (position), value)
        emitelem (0, bca)
        emitelem (1, bp)
        emitelem (2, dtc)
        emitelem (3, ka)
        emitelem (4, kac)
        emitelem (5, kca)
        emitelem (6, ksi)
        emitelem (7, ky)
        emitelem (8, mnef)
        emitelem (9, mxef)
        emitelem (10, rcmn)
        emitelem (11, rcmx)
        emitelem (12, tac)
        emitelem (13, tc)
        emitelem (14, td)
        emitelem (15, tfen)
        emitelem (16, tg)
        emitelem (17, tsi)
        emitelem (18, tt)
        emitelem (19, ttc)
        emitelem (20, ty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGAST3 rdf:ID=\"%s\">\n%s\t</cim:GovGAST3>".format (id, export_fields)
    }
}

object GovGAST3
extends
    Parseable[GovGAST3]
{
    override val fields: Array[String] = Array[String] (
        "bca",
        "bp",
        "dtc",
        "ka",
        "kac",
        "kca",
        "ksi",
        "ky",
        "mnef",
        "mxef",
        "rcmn",
        "rcmx",
        "tac",
        "tc",
        "td",
        "tfen",
        "tg",
        "tsi",
        "tt",
        "ttc",
        "ty"
    )
    val bca: Fielder = parse_element (element (cls, fields(0)))
    val bp: Fielder = parse_element (element (cls, fields(1)))
    val dtc: Fielder = parse_element (element (cls, fields(2)))
    val ka: Fielder = parse_element (element (cls, fields(3)))
    val kac: Fielder = parse_element (element (cls, fields(4)))
    val kca: Fielder = parse_element (element (cls, fields(5)))
    val ksi: Fielder = parse_element (element (cls, fields(6)))
    val ky: Fielder = parse_element (element (cls, fields(7)))
    val mnef: Fielder = parse_element (element (cls, fields(8)))
    val mxef: Fielder = parse_element (element (cls, fields(9)))
    val rcmn: Fielder = parse_element (element (cls, fields(10)))
    val rcmx: Fielder = parse_element (element (cls, fields(11)))
    val tac: Fielder = parse_element (element (cls, fields(12)))
    val tc: Fielder = parse_element (element (cls, fields(13)))
    val td: Fielder = parse_element (element (cls, fields(14)))
    val tfen: Fielder = parse_element (element (cls, fields(15)))
    val tg: Fielder = parse_element (element (cls, fields(16)))
    val tsi: Fielder = parse_element (element (cls, fields(17)))
    val tt: Fielder = parse_element (element (cls, fields(18)))
    val ttc: Fielder = parse_element (element (cls, fields(19)))
    val ty: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): GovGAST3 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovGAST3 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (bca (), 0)),
            toDouble (mask (bp (), 1)),
            toDouble (mask (dtc (), 2)),
            toDouble (mask (ka (), 3)),
            toDouble (mask (kac (), 4)),
            toDouble (mask (kca (), 5)),
            toDouble (mask (ksi (), 6)),
            toDouble (mask (ky (), 7)),
            toDouble (mask (mnef (), 8)),
            toDouble (mask (mxef (), 9)),
            toDouble (mask (rcmn (), 10)),
            toDouble (mask (rcmx (), 11)),
            toDouble (mask (tac (), 12)),
            toDouble (mask (tc (), 13)),
            toDouble (mask (td (), 14)),
            toDouble (mask (tfen (), 15)),
            toDouble (mask (tg (), 16)),
            toDouble (mask (tsi (), 17)),
            toDouble (mask (tt (), 18)),
            toDouble (mask (ttc (), 19)),
            toDouble (mask (ty (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Generic turbogas.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param bp Droop (<i>b</i><i><sub>p</sub></i>).
 *        Typical value = 0,05.
 * @param ktm Compressor gain (<i>Ktm</i>).
 *        Typical value = 0.
 * @param mnef Fuel flow maximum negative error value (<i>MNef</i>).
 *        Typical value = -0,05.
 * @param mxef Fuel flow maximum positive error value (<i>MXef</i>).
 *        Typical value = 0,05.
 * @param rymn Minimum valve opening (<i>RYMN</i>).
 *        Typical value = 0.
 * @param rymx Maximum valve opening (<i>RYMX</i>).
 *        Typical value = 1,1.
 * @param ta Maximum gate opening velocity (<i>TA</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param tc Maximum gate closing velocity (<i>TC</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param tcm Fuel control time constant (<i>Tcm</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tm Compressor discharge volume time constant (<i>Tm</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param ty Time constant of fuel valve positioner (<i>Ty</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGAST4
(
    override val sup: TurbineGovernorDynamics = null,
    bp: Double = 0.0,
    ktm: Double = 0.0,
    mnef: Double = 0.0,
    mxef: Double = 0.0,
    rymn: Double = 0.0,
    rymx: Double = 0.0,
    ta: Double = 0.0,
    tc: Double = 0.0,
    tcm: Double = 0.0,
    tm: Double = 0.0,
    ty: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST4] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGAST4.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGAST4.fields (position), value)
        emitelem (0, bp)
        emitelem (1, ktm)
        emitelem (2, mnef)
        emitelem (3, mxef)
        emitelem (4, rymn)
        emitelem (5, rymx)
        emitelem (6, ta)
        emitelem (7, tc)
        emitelem (8, tcm)
        emitelem (9, tm)
        emitelem (10, ty)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGAST4 rdf:ID=\"%s\">\n%s\t</cim:GovGAST4>".format (id, export_fields)
    }
}

object GovGAST4
extends
    Parseable[GovGAST4]
{
    override val fields: Array[String] = Array[String] (
        "bp",
        "ktm",
        "mnef",
        "mxef",
        "rymn",
        "rymx",
        "ta",
        "tc",
        "tcm",
        "tm",
        "ty"
    )
    val bp: Fielder = parse_element (element (cls, fields(0)))
    val ktm: Fielder = parse_element (element (cls, fields(1)))
    val mnef: Fielder = parse_element (element (cls, fields(2)))
    val mxef: Fielder = parse_element (element (cls, fields(3)))
    val rymn: Fielder = parse_element (element (cls, fields(4)))
    val rymx: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tc: Fielder = parse_element (element (cls, fields(7)))
    val tcm: Fielder = parse_element (element (cls, fields(8)))
    val tm: Fielder = parse_element (element (cls, fields(9)))
    val ty: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): GovGAST4 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovGAST4 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (bp (), 0)),
            toDouble (mask (ktm (), 1)),
            toDouble (mask (mnef (), 2)),
            toDouble (mask (mxef (), 3)),
            toDouble (mask (rymn (), 4)),
            toDouble (mask (rymx (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tc (), 7)),
            toDouble (mask (tcm (), 8)),
            toDouble (mask (tm (), 9)),
            toDouble (mask (ty (), 10))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Woodward� gas turbine governor.
 * [Footnote: Woodward gas turbines are an example of suitable products available commercially.
 *
 * This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param a Valve positioner (<i>A</i>).
 * @param af1 Exhaust temperature parameter (<i>Af1</i>).
 * @param af2 Coefficient equal to 0,5(1-speed) (<i>Af2</i>).
 * @param b Valve positioner (<i>B</i>).
 * @param bf1 (<i>Bf1</i>).  <i>Bf1</i> = <i>E</i>(1-<i>w</i>) where <i>E</i> (speed sensitivity coefficient) is 0,55 to 0,65 x <i>Tr</i>.
 * @param bf2 Turbine torque coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (<i>Bf2</i>).
 * @param c Valve positioner (<i>C</i>).
 * @param cf2 Coefficient defining fuel flow where power output is 0 % (<i>Cf2</i>).
 *        Synchronous but no output.  Typically 0,23 x K<sub>hhv </sub>(23 % fuel flow).
 * @param ecr Combustion reaction time delay (<i>Ecr</i>) (&gt;= 0).
 * @param etd Turbine and exhaust delay (<i>Etd</i>) (&gt;= 0).
 * @param k3 Ratio of fuel adjustment (<i>K3</i>).
 * @param k4 Gain of radiation shield (<i>K4</i>).
 * @param k5 Gain of radiation shield (<i>K5</i>).
 * @param k6 Minimum fuel flow (<i>K6</i>).
 * @param kd Drop governor gain (<i>Kd</i>).
 * @param kdroop (<i>Kdroop</i>) (&gt;= 0).
 * @param kf Fuel system feedback (<i>Kf</i>).
 * @param ki Isochronous Governor Gain (<i>Ki</i>).
 * @param kp PID proportional gain (<i>Kp</i>).
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param t Fuel control time constant (<i>T</i>) (&gt;= 0).
 * @param t3 Radiation shield time constant (<i>T3</i>) (&gt;= 0).
 * @param t4 Thermocouple time constant (<i>T4</i>) (&gt;= 0).
 * @param t5 Temperature control time constant (<i>T5</i>) (&gt;= 0).
 * @param tc Temperature control (<i>Tc</i>).
 * @param tcd Compressor discharge time constant (<i>Tcd</i>) (&gt;= 0).
 * @param td Power transducer time constant (<i>Td</i>) (&gt;= 0).
 * @param tf Fuel system time constant (<i>Tf</i>) (&gt;= 0).
 * @param tmax Maximum Turbine limit (<i>Tmax</i>) (&gt; GovGASTWD.tmin).
 * @param tmin Minimum turbine limit (<i>Tmin</i>) (&lt; GovGASTWD.tmax).
 * @param tr Rated temperature (<i>Tr</i>).
 * @param trate Turbine rating (<i>Trate</i>).
 *        Unit = MW.
 * @param tt Temperature controller integration rate (<i>Tt</i>) (&gt;= 0).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovGASTWD
(
    override val sup: TurbineGovernorDynamics = null,
    a: Double = 0.0,
    af1: Double = 0.0,
    af2: Double = 0.0,
    b: Double = 0.0,
    bf1: Double = 0.0,
    bf2: Double = 0.0,
    c: Double = 0.0,
    cf2: Double = 0.0,
    ecr: Double = 0.0,
    etd: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    k5: Double = 0.0,
    k6: Double = 0.0,
    kd: Double = 0.0,
    kdroop: Double = 0.0,
    kf: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    t: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    tc: Double = 0.0,
    tcd: Double = 0.0,
    td: Double = 0.0,
    tf: Double = 0.0,
    tmax: Double = 0.0,
    tmin: Double = 0.0,
    tr: Double = 0.0,
    trate: Double = 0.0,
    tt: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGASTWD] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovGASTWD.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovGASTWD.fields (position), value)
        emitelem (0, a)
        emitelem (1, af1)
        emitelem (2, af2)
        emitelem (3, b)
        emitelem (4, bf1)
        emitelem (5, bf2)
        emitelem (6, c)
        emitelem (7, cf2)
        emitelem (8, ecr)
        emitelem (9, etd)
        emitelem (10, k3)
        emitelem (11, k4)
        emitelem (12, k5)
        emitelem (13, k6)
        emitelem (14, kd)
        emitelem (15, kdroop)
        emitelem (16, kf)
        emitelem (17, ki)
        emitelem (18, kp)
        emitelem (19, mwbase)
        emitelem (20, t)
        emitelem (21, t3)
        emitelem (22, t4)
        emitelem (23, t5)
        emitelem (24, tc)
        emitelem (25, tcd)
        emitelem (26, td)
        emitelem (27, tf)
        emitelem (28, tmax)
        emitelem (29, tmin)
        emitelem (30, tr)
        emitelem (31, trate)
        emitelem (32, tt)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovGASTWD rdf:ID=\"%s\">\n%s\t</cim:GovGASTWD>".format (id, export_fields)
    }
}

object GovGASTWD
extends
    Parseable[GovGASTWD]
{
    override val fields: Array[String] = Array[String] (
        "a",
        "af1",
        "af2",
        "b",
        "bf1",
        "bf2",
        "c",
        "cf2",
        "ecr",
        "etd",
        "k3",
        "k4",
        "k5",
        "k6",
        "kd",
        "kdroop",
        "kf",
        "ki",
        "kp",
        "mwbase",
        "t",
        "t3",
        "t4",
        "t5",
        "tc",
        "tcd",
        "td",
        "tf",
        "tmax",
        "tmin",
        "tr",
        "trate",
        "tt"
    )
    val a: Fielder = parse_element (element (cls, fields(0)))
    val af1: Fielder = parse_element (element (cls, fields(1)))
    val af2: Fielder = parse_element (element (cls, fields(2)))
    val b: Fielder = parse_element (element (cls, fields(3)))
    val bf1: Fielder = parse_element (element (cls, fields(4)))
    val bf2: Fielder = parse_element (element (cls, fields(5)))
    val c: Fielder = parse_element (element (cls, fields(6)))
    val cf2: Fielder = parse_element (element (cls, fields(7)))
    val ecr: Fielder = parse_element (element (cls, fields(8)))
    val etd: Fielder = parse_element (element (cls, fields(9)))
    val k3: Fielder = parse_element (element (cls, fields(10)))
    val k4: Fielder = parse_element (element (cls, fields(11)))
    val k5: Fielder = parse_element (element (cls, fields(12)))
    val k6: Fielder = parse_element (element (cls, fields(13)))
    val kd: Fielder = parse_element (element (cls, fields(14)))
    val kdroop: Fielder = parse_element (element (cls, fields(15)))
    val kf: Fielder = parse_element (element (cls, fields(16)))
    val ki: Fielder = parse_element (element (cls, fields(17)))
    val kp: Fielder = parse_element (element (cls, fields(18)))
    val mwbase: Fielder = parse_element (element (cls, fields(19)))
    val t: Fielder = parse_element (element (cls, fields(20)))
    val t3: Fielder = parse_element (element (cls, fields(21)))
    val t4: Fielder = parse_element (element (cls, fields(22)))
    val t5: Fielder = parse_element (element (cls, fields(23)))
    val tc: Fielder = parse_element (element (cls, fields(24)))
    val tcd: Fielder = parse_element (element (cls, fields(25)))
    val td: Fielder = parse_element (element (cls, fields(26)))
    val tf: Fielder = parse_element (element (cls, fields(27)))
    val tmax: Fielder = parse_element (element (cls, fields(28)))
    val tmin: Fielder = parse_element (element (cls, fields(29)))
    val tr: Fielder = parse_element (element (cls, fields(30)))
    val trate: Fielder = parse_element (element (cls, fields(31)))
    val tt: Fielder = parse_element (element (cls, fields(32)))

    def parse (context: Context): GovGASTWD =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovGASTWD (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (a (), 0)),
            toDouble (mask (af1 (), 1)),
            toDouble (mask (af2 (), 2)),
            toDouble (mask (b (), 3)),
            toDouble (mask (bf1 (), 4)),
            toDouble (mask (bf2 (), 5)),
            toDouble (mask (c (), 6)),
            toDouble (mask (cf2 (), 7)),
            toDouble (mask (ecr (), 8)),
            toDouble (mask (etd (), 9)),
            toDouble (mask (k3 (), 10)),
            toDouble (mask (k4 (), 11)),
            toDouble (mask (k5 (), 12)),
            toDouble (mask (k6 (), 13)),
            toDouble (mask (kd (), 14)),
            toDouble (mask (kdroop (), 15)),
            toDouble (mask (kf (), 16)),
            toDouble (mask (ki (), 17)),
            toDouble (mask (kp (), 18)),
            toDouble (mask (mwbase (), 19)),
            toDouble (mask (t (), 20)),
            toDouble (mask (t3 (), 21)),
            toDouble (mask (t4 (), 22)),
            toDouble (mask (t5 (), 23)),
            toDouble (mask (tc (), 24)),
            toDouble (mask (tcd (), 25)),
            toDouble (mask (td (), 26)),
            toDouble (mask (tf (), 27)),
            toDouble (mask (tmax (), 28)),
            toDouble (mask (tmin (), 29)),
            toDouble (mask (tr (), 30)),
            toDouble (mask (trate (), 31)),
            toDouble (mask (tt (), 32))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Basic hydro turbine governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param at Turbine gain (<i>At</i>) (&gt; 0).
 *        Typical value = 1,2.
 * @param dturb Turbine damping factor (<i>Dturb</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param gmax Maximum gate opening (<i>Gmax</i>) (&gt; 0 and &gt; GovHydro.gmin).
 *        Typical value = 1.
 * @param gmin Minimum gate opening (<i>Gmin</i>) (&gt;= 0 and &lt; GovHydro1.gmax).
 *        Typical value = 0.
 * @param hdam Turbine nominal head (<i>hdam</i>).
 *        Typical value = 1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param qnl No-load flow at nominal head (<i>qnl</i>) (&gt;= 0).
 *        Typical value = 0,08.
 * @param rperm Permanent droop (<i>R</i>) (&gt; 0).
 *        Typical value = 0,04.
 * @param rtemp Temporary droop (<i>r</i>) (&gt; GovHydro1.rperm).
 *        Typical value = 0,3.
 * @param tf Filter time constant (<i>Tf</i>) (&gt; 0).
 *        Typical value = 0,05.
 * @param tg Gate servo time constant (<i>Tg</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tr Washout time constant (<i>Tr</i>) (&gt; 0).
 *        Typical value = 5.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt; 0).
 *        Typical value = 1.
 * @param velm Maximum gate velocity (<i>Vlem</i>) (&gt; 0).
 *        Typical value = 0,2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydro1
(
    override val sup: TurbineGovernorDynamics = null,
    at: Double = 0.0,
    dturb: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    hdam: Double = 0.0,
    mwbase: Double = 0.0,
    qnl: Double = 0.0,
    rperm: Double = 0.0,
    rtemp: Double = 0.0,
    tf: Double = 0.0,
    tg: Double = 0.0,
    tr: Double = 0.0,
    tw: Double = 0.0,
    velm: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydro1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydro1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydro1.fields (position), value)
        emitelem (0, at)
        emitelem (1, dturb)
        emitelem (2, gmax)
        emitelem (3, gmin)
        emitelem (4, hdam)
        emitelem (5, mwbase)
        emitelem (6, qnl)
        emitelem (7, rperm)
        emitelem (8, rtemp)
        emitelem (9, tf)
        emitelem (10, tg)
        emitelem (11, tr)
        emitelem (12, tw)
        emitelem (13, velm)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydro1 rdf:ID=\"%s\">\n%s\t</cim:GovHydro1>".format (id, export_fields)
    }
}

object GovHydro1
extends
    Parseable[GovHydro1]
{
    override val fields: Array[String] = Array[String] (
        "at",
        "dturb",
        "gmax",
        "gmin",
        "hdam",
        "mwbase",
        "qnl",
        "rperm",
        "rtemp",
        "tf",
        "tg",
        "tr",
        "tw",
        "velm"
    )
    val at: Fielder = parse_element (element (cls, fields(0)))
    val dturb: Fielder = parse_element (element (cls, fields(1)))
    val gmax: Fielder = parse_element (element (cls, fields(2)))
    val gmin: Fielder = parse_element (element (cls, fields(3)))
    val hdam: Fielder = parse_element (element (cls, fields(4)))
    val mwbase: Fielder = parse_element (element (cls, fields(5)))
    val qnl: Fielder = parse_element (element (cls, fields(6)))
    val rperm: Fielder = parse_element (element (cls, fields(7)))
    val rtemp: Fielder = parse_element (element (cls, fields(8)))
    val tf: Fielder = parse_element (element (cls, fields(9)))
    val tg: Fielder = parse_element (element (cls, fields(10)))
    val tr: Fielder = parse_element (element (cls, fields(11)))
    val tw: Fielder = parse_element (element (cls, fields(12)))
    val velm: Fielder = parse_element (element (cls, fields(13)))

    def parse (context: Context): GovHydro1 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydro1 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (at (), 0)),
            toDouble (mask (dturb (), 1)),
            toDouble (mask (gmax (), 2)),
            toDouble (mask (gmin (), 3)),
            toDouble (mask (hdam (), 4)),
            toDouble (mask (mwbase (), 5)),
            toDouble (mask (qnl (), 6)),
            toDouble (mask (rperm (), 7)),
            toDouble (mask (rtemp (), 8)),
            toDouble (mask (tf (), 9)),
            toDouble (mask (tg (), 10)),
            toDouble (mask (tr (), 11)),
            toDouble (mask (tw (), 12)),
            toDouble (mask (velm (), 13))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE hydro turbine governor with straightforward penstock configuration and hydraulic-dashpot governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (<i>Aturb</i>).
 *        Typical value = -1.
 * @param bturb Turbine denominator multiplier (<i>Bturb</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param db1 Intentional deadband width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional deadband (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param kturb Turbine gain (<i>Kturb</i>).
 *        Typical value = 1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (P<i>gv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening (<i>Pmax</i>) (&gt; GovHydro2.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening (<i>Pmin</i>) (&lt; GovHydro2.pmax).
 *        Typical value = 0.
 * @param rperm Permanent droop (<i>Rperm</i>).
 *        Typical value = 0,05.
 * @param rtemp Temporary droop (<i>Rtemp</i>).
 *        Typical value = 0,5.
 * @param tg Gate servo time constant (<i>Tg</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tp Pilot servo valve time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param tr Dashpot time constant (<i>Tr</i>) (&gt;= 0).
 *        Typical value = 12.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt;= 0).
 *        Typical value = 2.
 * @param uc Maximum gate closing velocity (<i>Uc</i>) (&lt; 0).
 *        Unit = PU / s.   Typical value = -0,1.
 * @param uo Maximum gate opening velocity (<i>Uo</i>).
 *        Unit = PU / s.  Typical value = 0,1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydro2
(
    override val sup: TurbineGovernorDynamics = null,
    aturb: Double = 0.0,
    bturb: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    eps: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    kturb: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    rperm: Double = 0.0,
    rtemp: Double = 0.0,
    tg: Double = 0.0,
    tp: Double = 0.0,
    tr: Double = 0.0,
    tw: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydro2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydro2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydro2.fields (position), value)
        emitelem (0, aturb)
        emitelem (1, bturb)
        emitelem (2, db1)
        emitelem (3, db2)
        emitelem (4, eps)
        emitelem (5, gv1)
        emitelem (6, gv2)
        emitelem (7, gv3)
        emitelem (8, gv4)
        emitelem (9, gv5)
        emitelem (10, gv6)
        emitelem (11, kturb)
        emitelem (12, mwbase)
        emitelem (13, pgv1)
        emitelem (14, pgv2)
        emitelem (15, pgv3)
        emitelem (16, pgv4)
        emitelem (17, pgv5)
        emitelem (18, pgv6)
        emitelem (19, pmax)
        emitelem (20, pmin)
        emitelem (21, rperm)
        emitelem (22, rtemp)
        emitelem (23, tg)
        emitelem (24, tp)
        emitelem (25, tr)
        emitelem (26, tw)
        emitelem (27, uc)
        emitelem (28, uo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydro2 rdf:ID=\"%s\">\n%s\t</cim:GovHydro2>".format (id, export_fields)
    }
}

object GovHydro2
extends
    Parseable[GovHydro2]
{
    override val fields: Array[String] = Array[String] (
        "aturb",
        "bturb",
        "db1",
        "db2",
        "eps",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "kturb",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "rperm",
        "rtemp",
        "tg",
        "tp",
        "tr",
        "tw",
        "uc",
        "uo"
    )
    val aturb: Fielder = parse_element (element (cls, fields(0)))
    val bturb: Fielder = parse_element (element (cls, fields(1)))
    val db1: Fielder = parse_element (element (cls, fields(2)))
    val db2: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val gv1: Fielder = parse_element (element (cls, fields(5)))
    val gv2: Fielder = parse_element (element (cls, fields(6)))
    val gv3: Fielder = parse_element (element (cls, fields(7)))
    val gv4: Fielder = parse_element (element (cls, fields(8)))
    val gv5: Fielder = parse_element (element (cls, fields(9)))
    val gv6: Fielder = parse_element (element (cls, fields(10)))
    val kturb: Fielder = parse_element (element (cls, fields(11)))
    val mwbase: Fielder = parse_element (element (cls, fields(12)))
    val pgv1: Fielder = parse_element (element (cls, fields(13)))
    val pgv2: Fielder = parse_element (element (cls, fields(14)))
    val pgv3: Fielder = parse_element (element (cls, fields(15)))
    val pgv4: Fielder = parse_element (element (cls, fields(16)))
    val pgv5: Fielder = parse_element (element (cls, fields(17)))
    val pgv6: Fielder = parse_element (element (cls, fields(18)))
    val pmax: Fielder = parse_element (element (cls, fields(19)))
    val pmin: Fielder = parse_element (element (cls, fields(20)))
    val rperm: Fielder = parse_element (element (cls, fields(21)))
    val rtemp: Fielder = parse_element (element (cls, fields(22)))
    val tg: Fielder = parse_element (element (cls, fields(23)))
    val tp: Fielder = parse_element (element (cls, fields(24)))
    val tr: Fielder = parse_element (element (cls, fields(25)))
    val tw: Fielder = parse_element (element (cls, fields(26)))
    val uc: Fielder = parse_element (element (cls, fields(27)))
    val uo: Fielder = parse_element (element (cls, fields(28)))

    def parse (context: Context): GovHydro2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydro2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aturb (), 0)),
            toDouble (mask (bturb (), 1)),
            toDouble (mask (db1 (), 2)),
            toDouble (mask (db2 (), 3)),
            toDouble (mask (eps (), 4)),
            toDouble (mask (gv1 (), 5)),
            toDouble (mask (gv2 (), 6)),
            toDouble (mask (gv3 (), 7)),
            toDouble (mask (gv4 (), 8)),
            toDouble (mask (gv5 (), 9)),
            toDouble (mask (gv6 (), 10)),
            toDouble (mask (kturb (), 11)),
            toDouble (mask (mwbase (), 12)),
            toDouble (mask (pgv1 (), 13)),
            toDouble (mask (pgv2 (), 14)),
            toDouble (mask (pgv3 (), 15)),
            toDouble (mask (pgv4 (), 16)),
            toDouble (mask (pgv5 (), 17)),
            toDouble (mask (pgv6 (), 18)),
            toDouble (mask (pmax (), 19)),
            toDouble (mask (pmin (), 20)),
            toDouble (mask (rperm (), 21)),
            toDouble (mask (rtemp (), 22)),
            toDouble (mask (tg (), 23)),
            toDouble (mask (tp (), 24)),
            toDouble (mask (tr (), 25)),
            toDouble (mask (tw (), 26)),
            toDouble (mask (uc (), 27)),
            toDouble (mask (uo (), 28))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Modified IEEE hydro governor-turbine.
 *
 * This model differs from that defined in the IEEE modelling guideline paper in that the limits on gate position and velocity do not permit "wind up" of the upstream signals.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param at Turbine gain (<i>At</i>) (&gt;0).
 *        Typical value = 1,2.
 * @param db1 Intentional dead-band width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param dturb Turbine damping factor (<i>Dturb</i>).
 *        Typical value = 0,2.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param governorControl Governor control flag (<i>Cflag</i>).
 *        true = PID control is active
 *        false = double derivative control is active.
 *        Typical value = true.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param h0 Turbine nominal head (<i>H0</i>).
 *        Typical value = 1.
 * @param k1 Derivative gain (<i>K1</i>).
 *        Typical value = 0,01.
 * @param k2 Double derivative gain, if <i>Cflag</i> = -1 (<i>K2</i>).
 *        Typical value = 2,5.
 * @param kg Gate servo gain (<i>Kg</i>).
 *        Typical value = 2.
 * @param ki Integral gain (<i>Ki</i>).
 *        Typical value = 0,5.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (<i>Pmax</i>) (&gt; GovHydro3.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening, PU of <i>MWbase</i> (<i>Pmin</i>) (&lt; GovHydro3.pmax).
 *        Typical value = 0.
 * @param qnl No-load turbine flow at nominal head (<i>Qnl</i>).
 *        Typical value = 0,08.
 * @param relec Steady-state droop, PU, for electrical power feedback (<i>Relec</i>).
 *        Typical value = 0,05.
 * @param rgate Steady-state droop, PU, for governor output feedback (<i>Rgate</i>).
 *        Typical value = 0.
 * @param td Input filter time constant (<i>Td</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tf Washout time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tp Gate servo time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tt Power feedback time constant (<i>Tt</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 1.
 * @param velcl Maximum gate closing velocity (<i>Velcl</i>).
 *        Unit = PU / s.  Typical value = -0,2.
 * @param velop Maximum gate opening velocity (<i>Velop</i>).
 *        Unit = PU / s. Typical value = 0,2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydro3
(
    override val sup: TurbineGovernorDynamics = null,
    at: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    dturb: Double = 0.0,
    eps: Double = 0.0,
    governorControl: Boolean = false,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    h0: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    qnl: Double = 0.0,
    relec: Double = 0.0,
    rgate: Double = 0.0,
    td: Double = 0.0,
    tf: Double = 0.0,
    tp: Double = 0.0,
    tt: Double = 0.0,
    tw: Double = 0.0,
    velcl: Double = 0.0,
    velop: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydro3] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydro3.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydro3.fields (position), value)
        emitelem (0, at)
        emitelem (1, db1)
        emitelem (2, db2)
        emitelem (3, dturb)
        emitelem (4, eps)
        emitelem (5, governorControl)
        emitelem (6, gv1)
        emitelem (7, gv2)
        emitelem (8, gv3)
        emitelem (9, gv4)
        emitelem (10, gv5)
        emitelem (11, gv6)
        emitelem (12, h0)
        emitelem (13, k1)
        emitelem (14, k2)
        emitelem (15, kg)
        emitelem (16, ki)
        emitelem (17, mwbase)
        emitelem (18, pgv1)
        emitelem (19, pgv2)
        emitelem (20, pgv3)
        emitelem (21, pgv4)
        emitelem (22, pgv5)
        emitelem (23, pgv6)
        emitelem (24, pmax)
        emitelem (25, pmin)
        emitelem (26, qnl)
        emitelem (27, relec)
        emitelem (28, rgate)
        emitelem (29, td)
        emitelem (30, tf)
        emitelem (31, tp)
        emitelem (32, tt)
        emitelem (33, tw)
        emitelem (34, velcl)
        emitelem (35, velop)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydro3 rdf:ID=\"%s\">\n%s\t</cim:GovHydro3>".format (id, export_fields)
    }
}

object GovHydro3
extends
    Parseable[GovHydro3]
{
    override val fields: Array[String] = Array[String] (
        "at",
        "db1",
        "db2",
        "dturb",
        "eps",
        "governorControl",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "h0",
        "k1",
        "k2",
        "kg",
        "ki",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "qnl",
        "relec",
        "rgate",
        "td",
        "tf",
        "tp",
        "tt",
        "tw",
        "velcl",
        "velop"
    )
    val at: Fielder = parse_element (element (cls, fields(0)))
    val db1: Fielder = parse_element (element (cls, fields(1)))
    val db2: Fielder = parse_element (element (cls, fields(2)))
    val dturb: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val governorControl: Fielder = parse_element (element (cls, fields(5)))
    val gv1: Fielder = parse_element (element (cls, fields(6)))
    val gv2: Fielder = parse_element (element (cls, fields(7)))
    val gv3: Fielder = parse_element (element (cls, fields(8)))
    val gv4: Fielder = parse_element (element (cls, fields(9)))
    val gv5: Fielder = parse_element (element (cls, fields(10)))
    val gv6: Fielder = parse_element (element (cls, fields(11)))
    val h0: Fielder = parse_element (element (cls, fields(12)))
    val k1: Fielder = parse_element (element (cls, fields(13)))
    val k2: Fielder = parse_element (element (cls, fields(14)))
    val kg: Fielder = parse_element (element (cls, fields(15)))
    val ki: Fielder = parse_element (element (cls, fields(16)))
    val mwbase: Fielder = parse_element (element (cls, fields(17)))
    val pgv1: Fielder = parse_element (element (cls, fields(18)))
    val pgv2: Fielder = parse_element (element (cls, fields(19)))
    val pgv3: Fielder = parse_element (element (cls, fields(20)))
    val pgv4: Fielder = parse_element (element (cls, fields(21)))
    val pgv5: Fielder = parse_element (element (cls, fields(22)))
    val pgv6: Fielder = parse_element (element (cls, fields(23)))
    val pmax: Fielder = parse_element (element (cls, fields(24)))
    val pmin: Fielder = parse_element (element (cls, fields(25)))
    val qnl: Fielder = parse_element (element (cls, fields(26)))
    val relec: Fielder = parse_element (element (cls, fields(27)))
    val rgate: Fielder = parse_element (element (cls, fields(28)))
    val td: Fielder = parse_element (element (cls, fields(29)))
    val tf: Fielder = parse_element (element (cls, fields(30)))
    val tp: Fielder = parse_element (element (cls, fields(31)))
    val tt: Fielder = parse_element (element (cls, fields(32)))
    val tw: Fielder = parse_element (element (cls, fields(33)))
    val velcl: Fielder = parse_element (element (cls, fields(34)))
    val velop: Fielder = parse_element (element (cls, fields(35)))

    def parse (context: Context): GovHydro3 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydro3 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (at (), 0)),
            toDouble (mask (db1 (), 1)),
            toDouble (mask (db2 (), 2)),
            toDouble (mask (dturb (), 3)),
            toDouble (mask (eps (), 4)),
            toBoolean (mask (governorControl (), 5)),
            toDouble (mask (gv1 (), 6)),
            toDouble (mask (gv2 (), 7)),
            toDouble (mask (gv3 (), 8)),
            toDouble (mask (gv4 (), 9)),
            toDouble (mask (gv5 (), 10)),
            toDouble (mask (gv6 (), 11)),
            toDouble (mask (h0 (), 12)),
            toDouble (mask (k1 (), 13)),
            toDouble (mask (k2 (), 14)),
            toDouble (mask (kg (), 15)),
            toDouble (mask (ki (), 16)),
            toDouble (mask (mwbase (), 17)),
            toDouble (mask (pgv1 (), 18)),
            toDouble (mask (pgv2 (), 19)),
            toDouble (mask (pgv3 (), 20)),
            toDouble (mask (pgv4 (), 21)),
            toDouble (mask (pgv5 (), 22)),
            toDouble (mask (pgv6 (), 23)),
            toDouble (mask (pmax (), 24)),
            toDouble (mask (pmin (), 25)),
            toDouble (mask (qnl (), 26)),
            toDouble (mask (relec (), 27)),
            toDouble (mask (rgate (), 28)),
            toDouble (mask (td (), 29)),
            toDouble (mask (tf (), 30)),
            toDouble (mask (tp (), 31)),
            toDouble (mask (tt (), 32)),
            toDouble (mask (tw (), 33)),
            toDouble (mask (velcl (), 34)),
            toDouble (mask (velop (), 35))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Hydro turbine and governor.
 *
 * Represents plants with straight-forward penstock configurations and hydraulic governors of the traditional 'dashpot' type.  This model can be used to represent simple, Francis/Pelton or Kaplan turbines.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param at Turbine gain (<i>At</i>).
 *        Typical value = 1,2.
 * @param bgv0 Kaplan blade servo point 0 (<i>Bgv0</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 0.
 * @param bgv1 Kaplan blade servo point 1 (<i>Bgv1</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 0.
 * @param bgv2 Kaplan blade servo point 2 (<i>Bgv2</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 0,1.
 * @param bgv3 Kaplan blade servo point 3 (<i>Bgv3</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 0,667.
 * @param bgv4 Kaplan blade servo point 4 (<i>Bgv4</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 0,9.
 * @param bgv5 Kaplan blade servo point 5 (<i>Bgv5</i>) (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 1.
 * @param bmax Maximum blade adjustment factor (<i>Bmax</i>)  (= 0 for simple, = 0 for Francis/Pelton).
 *        Typical value for Kaplan = 1,1276.
 * @param db1 Intentional deadband width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param dturb Turbine damping factor (<i>Dturb</i>).
 *        Unit = delta P (PU of <i>MWbase</i>) / delta speed (PU).  Typical value for simple = 0,5, Francis/Pelton = 1,1, Kaplan = 1,1.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gmax Maximum gate opening, PU of <i>MWbase</i> (<i>Gmax</i>) (&gt; GovHydro4.gmin).
 *        Typical value = 1.
 * @param gmin Minimum gate opening, PU of <i>MWbase</i> (<i>Gmin</i>) (&lt; GovHydro4.gmax).
 *        Typical value = 0.
 * @param gv0 Nonlinear gain point 0, PU gv (<i>Gv0</i>) (= 0 for simple).
 *        Typical for Francis/Pelton = 0,1, Kaplan = 0,1.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>) (= 0 for simple, &gt; GovHydro4.gv0 for Francis/Pelton and Kaplan).
 *        Typical value for Francis/Pelton = 0,4, Kaplan = 0,4.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>) (= 0 for simple, &gt; GovHydro4.gv1 for Francis/Pelton and Kaplan).
 *        Typical value for Francis/Pelton = 0,5, Kaplan = 0,5.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>)  (= 0 for simple, &gt; GovHydro4.gv2 for Francis/Pelton and Kaplan).
 *        Typical value for Francis/Pelton = 0,7, Kaplan = 0,7.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>)  (= 0 for simple, &gt; GovHydro4.gv3 for Francis/Pelton and Kaplan).
 *        Typical value for  Francis/Pelton = 0,8, Kaplan = 0,8.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>)  (= 0 for simple, &lt; 1 and &gt; GovHydro4.gv4 for Francis/Pelton and Kaplan).
 *        Typical value for Francis/Pelton = 0,9, Kaplan = 0,9.
 * @param hdam Head available at dam (<i>hdam</i>).
 *        Typical value = 1.
 * @param model The kind of model being represented (simple, Francis/Pelton or Kaplan).
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv0 Nonlinear gain point 0, PU power (<i>Pgv0</i>) (= 0 for simple).
 *        Typical value = 0.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>) (= 0 for simple).
 *        Typical value for Francis/Pelton = 0,42, Kaplan = 0,35.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>) (= 0 for simple).
 *        Typical value for Francis/Pelton = 0,56, Kaplan = 0,468.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>) (= 0 for simple).
 *        Typical value for Francis/Pelton = 0,8, Kaplan = 0,796.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>) (= 0 for simple).
 *        Typical value for Francis/Pelton = 0,9, Kaplan = 0,917.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>) (= 0 for simple).
 *        Typical value for Francis/Pelton = 0,97, Kaplan = 0,99.
 * @param qnl No-load flow at nominal head (<i>Qnl</i>).
 *        Typical value for simple = 0,08, Francis/Pelton = 0, Kaplan = 0.
 * @param rperm Permanent droop (<i>Rperm</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param rtemp Temporary droop (<i>Rtemp</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param tblade Blade servo time constant (<i>Tblade</i>) (&gt;= 0).
 *        Typical value = 100.
 * @param tg Gate servo time constant (<i>Tg</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param tp Pilot servo time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tr Dashpot time constant (<i>Tr</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt; 0).
 *        Typical value = 1.
 * @param uc Max gate closing velocity (<i>Uc</i>).
 *        Typical value = 0,2.
 * @param uo Max gate opening velocity (<i>Uo</i>).
 *        Typical value = 0,2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydro4
(
    override val sup: TurbineGovernorDynamics = null,
    at: Double = 0.0,
    bgv0: Double = 0.0,
    bgv1: Double = 0.0,
    bgv2: Double = 0.0,
    bgv3: Double = 0.0,
    bgv4: Double = 0.0,
    bgv5: Double = 0.0,
    bmax: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    dturb: Double = 0.0,
    eps: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    gv0: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    hdam: Double = 0.0,
    model: String = null,
    mwbase: Double = 0.0,
    pgv0: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    qnl: Double = 0.0,
    rperm: Double = 0.0,
    rtemp: Double = 0.0,
    tblade: Double = 0.0,
    tg: Double = 0.0,
    tp: Double = 0.0,
    tr: Double = 0.0,
    tw: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydro4] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydro4.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydro4.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GovHydro4.fields (position), value)
        emitelem (0, at)
        emitelem (1, bgv0)
        emitelem (2, bgv1)
        emitelem (3, bgv2)
        emitelem (4, bgv3)
        emitelem (5, bgv4)
        emitelem (6, bgv5)
        emitelem (7, bmax)
        emitelem (8, db1)
        emitelem (9, db2)
        emitelem (10, dturb)
        emitelem (11, eps)
        emitelem (12, gmax)
        emitelem (13, gmin)
        emitelem (14, gv0)
        emitelem (15, gv1)
        emitelem (16, gv2)
        emitelem (17, gv3)
        emitelem (18, gv4)
        emitelem (19, gv5)
        emitelem (20, hdam)
        emitattr (21, model)
        emitelem (22, mwbase)
        emitelem (23, pgv0)
        emitelem (24, pgv1)
        emitelem (25, pgv2)
        emitelem (26, pgv3)
        emitelem (27, pgv4)
        emitelem (28, pgv5)
        emitelem (29, qnl)
        emitelem (30, rperm)
        emitelem (31, rtemp)
        emitelem (32, tblade)
        emitelem (33, tg)
        emitelem (34, tp)
        emitelem (35, tr)
        emitelem (36, tw)
        emitelem (37, uc)
        emitelem (38, uo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydro4 rdf:ID=\"%s\">\n%s\t</cim:GovHydro4>".format (id, export_fields)
    }
}

object GovHydro4
extends
    Parseable[GovHydro4]
{
    override val fields: Array[String] = Array[String] (
        "at",
        "bgv0",
        "bgv1",
        "bgv2",
        "bgv3",
        "bgv4",
        "bgv5",
        "bmax",
        "db1",
        "db2",
        "dturb",
        "eps",
        "gmax",
        "gmin",
        "gv0",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "hdam",
        "model",
        "mwbase",
        "pgv0",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "qnl",
        "rperm",
        "rtemp",
        "tblade",
        "tg",
        "tp",
        "tr",
        "tw",
        "uc",
        "uo"
    )
    val at: Fielder = parse_element (element (cls, fields(0)))
    val bgv0: Fielder = parse_element (element (cls, fields(1)))
    val bgv1: Fielder = parse_element (element (cls, fields(2)))
    val bgv2: Fielder = parse_element (element (cls, fields(3)))
    val bgv3: Fielder = parse_element (element (cls, fields(4)))
    val bgv4: Fielder = parse_element (element (cls, fields(5)))
    val bgv5: Fielder = parse_element (element (cls, fields(6)))
    val bmax: Fielder = parse_element (element (cls, fields(7)))
    val db1: Fielder = parse_element (element (cls, fields(8)))
    val db2: Fielder = parse_element (element (cls, fields(9)))
    val dturb: Fielder = parse_element (element (cls, fields(10)))
    val eps: Fielder = parse_element (element (cls, fields(11)))
    val gmax: Fielder = parse_element (element (cls, fields(12)))
    val gmin: Fielder = parse_element (element (cls, fields(13)))
    val gv0: Fielder = parse_element (element (cls, fields(14)))
    val gv1: Fielder = parse_element (element (cls, fields(15)))
    val gv2: Fielder = parse_element (element (cls, fields(16)))
    val gv3: Fielder = parse_element (element (cls, fields(17)))
    val gv4: Fielder = parse_element (element (cls, fields(18)))
    val gv5: Fielder = parse_element (element (cls, fields(19)))
    val hdam: Fielder = parse_element (element (cls, fields(20)))
    val model: Fielder = parse_attribute (attribute (cls, fields(21)))
    val mwbase: Fielder = parse_element (element (cls, fields(22)))
    val pgv0: Fielder = parse_element (element (cls, fields(23)))
    val pgv1: Fielder = parse_element (element (cls, fields(24)))
    val pgv2: Fielder = parse_element (element (cls, fields(25)))
    val pgv3: Fielder = parse_element (element (cls, fields(26)))
    val pgv4: Fielder = parse_element (element (cls, fields(27)))
    val pgv5: Fielder = parse_element (element (cls, fields(28)))
    val qnl: Fielder = parse_element (element (cls, fields(29)))
    val rperm: Fielder = parse_element (element (cls, fields(30)))
    val rtemp: Fielder = parse_element (element (cls, fields(31)))
    val tblade: Fielder = parse_element (element (cls, fields(32)))
    val tg: Fielder = parse_element (element (cls, fields(33)))
    val tp: Fielder = parse_element (element (cls, fields(34)))
    val tr: Fielder = parse_element (element (cls, fields(35)))
    val tw: Fielder = parse_element (element (cls, fields(36)))
    val uc: Fielder = parse_element (element (cls, fields(37)))
    val uo: Fielder = parse_element (element (cls, fields(38)))

    def parse (context: Context): GovHydro4 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydro4 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (at (), 0)),
            toDouble (mask (bgv0 (), 1)),
            toDouble (mask (bgv1 (), 2)),
            toDouble (mask (bgv2 (), 3)),
            toDouble (mask (bgv3 (), 4)),
            toDouble (mask (bgv4 (), 5)),
            toDouble (mask (bgv5 (), 6)),
            toDouble (mask (bmax (), 7)),
            toDouble (mask (db1 (), 8)),
            toDouble (mask (db2 (), 9)),
            toDouble (mask (dturb (), 10)),
            toDouble (mask (eps (), 11)),
            toDouble (mask (gmax (), 12)),
            toDouble (mask (gmin (), 13)),
            toDouble (mask (gv0 (), 14)),
            toDouble (mask (gv1 (), 15)),
            toDouble (mask (gv2 (), 16)),
            toDouble (mask (gv3 (), 17)),
            toDouble (mask (gv4 (), 18)),
            toDouble (mask (gv5 (), 19)),
            toDouble (mask (hdam (), 20)),
            mask (model (), 21),
            toDouble (mask (mwbase (), 22)),
            toDouble (mask (pgv0 (), 23)),
            toDouble (mask (pgv1 (), 24)),
            toDouble (mask (pgv2 (), 25)),
            toDouble (mask (pgv3 (), 26)),
            toDouble (mask (pgv4 (), 27)),
            toDouble (mask (pgv5 (), 28)),
            toDouble (mask (qnl (), 29)),
            toDouble (mask (rperm (), 30)),
            toDouble (mask (rtemp (), 31)),
            toDouble (mask (tblade (), 32)),
            toDouble (mask (tg (), 33)),
            toDouble (mask (tp (), 34)),
            toDouble (mask (tr (), 35)),
            toDouble (mask (tw (), 36)),
            toDouble (mask (uc (), 37)),
            toDouble (mask (uo (), 38))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Double derivative hydro governor and turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (<i>Aturb</i>) (see parameter detail 3).
 *        Typical value = -1.
 * @param bturb Turbine denominator multiplier (<i>Bturb</i>) (see parameter detail 3).
 *        Typical value = 0,5.
 * @param db1 Intentional dead-band width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gmax Maximum gate opening (<i>Gmax</i>) (&gt; GovHydroDD.gmin).
 *        Typical value = 0.
 * @param gmin Minimum gate opening (<i>Gmin</i>) (&lt; GovHydroDD.gmax).
 *        Typical value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param inputSignal Input signal switch (<i>Flag</i>).
 *        true = <i>Pe</i> input is used
 *        false = feedback is received from <i>CV</i>.
 *        <i>Flag</i> is normally dependent on <i>Tt</i>.
 *        If <i>Tt</i> is zero, <i>Flag</i> is set to false. If <i>Tt</i> is not zero, <i>Flag</i> is set to true.
 *        Typical value = true.
 * @param k1 Single derivative gain (<i>K1</i>).
 *        Typical value = 3,6.
 * @param k2 Double derivative gain (<i>K2</i>).
 *        Typical value = 0,2.
 * @param kg Gate servo gain (<i>Kg</i>).
 *        Typical value = 3.
 * @param ki Integral gain (<i>Ki</i>).
 *        Typical value = 1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening, PU of <i>MWbase</i> (<i>Pmax</i>) (&gt; GovHydroDD.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening, PU of <i>MWbase</i> (<i>Pmin</i>) (&gt; GovHydroDD.pmax).
 *        Typical value = 0.
 * @param r Steady state droop (<i>R</i>).
 *        Typical value = 0,05.
 * @param td Input filter time constant (<i>Td</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0.
 * @param tf Washout time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tp Gate servo time constant (<i>Tp</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,35.
 * @param tt Power feedback time constant (<i>Tt</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,02.
 * @param tturb Turbine time constant (<i>Tturb</i>)  (&gt;= 0).
 *        See parameter detail 3.  Typical value = 0,8.
 * @param velcl Maximum gate closing velocity (<i>Velcl</i>).
 *        Unit = PU / s.  Typical value = -0,14.
 * @param velop Maximum gate opening velocity (<i>Velop</i>).
 *        Unit = PU / s.  Typical value = 0,09.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroDD
(
    override val sup: TurbineGovernorDynamics = null,
    aturb: Double = 0.0,
    bturb: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    eps: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    inputSignal: Boolean = false,
    k1: Double = 0.0,
    k2: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    r: Double = 0.0,
    td: Double = 0.0,
    tf: Double = 0.0,
    tp: Double = 0.0,
    tt: Double = 0.0,
    tturb: Double = 0.0,
    velcl: Double = 0.0,
    velop: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroDD] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroDD.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroDD.fields (position), value)
        emitelem (0, aturb)
        emitelem (1, bturb)
        emitelem (2, db1)
        emitelem (3, db2)
        emitelem (4, eps)
        emitelem (5, gmax)
        emitelem (6, gmin)
        emitelem (7, gv1)
        emitelem (8, gv2)
        emitelem (9, gv3)
        emitelem (10, gv4)
        emitelem (11, gv5)
        emitelem (12, gv6)
        emitelem (13, inputSignal)
        emitelem (14, k1)
        emitelem (15, k2)
        emitelem (16, kg)
        emitelem (17, ki)
        emitelem (18, mwbase)
        emitelem (19, pgv1)
        emitelem (20, pgv2)
        emitelem (21, pgv3)
        emitelem (22, pgv4)
        emitelem (23, pgv5)
        emitelem (24, pgv6)
        emitelem (25, pmax)
        emitelem (26, pmin)
        emitelem (27, r)
        emitelem (28, td)
        emitelem (29, tf)
        emitelem (30, tp)
        emitelem (31, tt)
        emitelem (32, tturb)
        emitelem (33, velcl)
        emitelem (34, velop)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroDD rdf:ID=\"%s\">\n%s\t</cim:GovHydroDD>".format (id, export_fields)
    }
}

object GovHydroDD
extends
    Parseable[GovHydroDD]
{
    override val fields: Array[String] = Array[String] (
        "aturb",
        "bturb",
        "db1",
        "db2",
        "eps",
        "gmax",
        "gmin",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "inputSignal",
        "k1",
        "k2",
        "kg",
        "ki",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "r",
        "td",
        "tf",
        "tp",
        "tt",
        "tturb",
        "velcl",
        "velop"
    )
    val aturb: Fielder = parse_element (element (cls, fields(0)))
    val bturb: Fielder = parse_element (element (cls, fields(1)))
    val db1: Fielder = parse_element (element (cls, fields(2)))
    val db2: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val gmax: Fielder = parse_element (element (cls, fields(5)))
    val gmin: Fielder = parse_element (element (cls, fields(6)))
    val gv1: Fielder = parse_element (element (cls, fields(7)))
    val gv2: Fielder = parse_element (element (cls, fields(8)))
    val gv3: Fielder = parse_element (element (cls, fields(9)))
    val gv4: Fielder = parse_element (element (cls, fields(10)))
    val gv5: Fielder = parse_element (element (cls, fields(11)))
    val gv6: Fielder = parse_element (element (cls, fields(12)))
    val inputSignal: Fielder = parse_element (element (cls, fields(13)))
    val k1: Fielder = parse_element (element (cls, fields(14)))
    val k2: Fielder = parse_element (element (cls, fields(15)))
    val kg: Fielder = parse_element (element (cls, fields(16)))
    val ki: Fielder = parse_element (element (cls, fields(17)))
    val mwbase: Fielder = parse_element (element (cls, fields(18)))
    val pgv1: Fielder = parse_element (element (cls, fields(19)))
    val pgv2: Fielder = parse_element (element (cls, fields(20)))
    val pgv3: Fielder = parse_element (element (cls, fields(21)))
    val pgv4: Fielder = parse_element (element (cls, fields(22)))
    val pgv5: Fielder = parse_element (element (cls, fields(23)))
    val pgv6: Fielder = parse_element (element (cls, fields(24)))
    val pmax: Fielder = parse_element (element (cls, fields(25)))
    val pmin: Fielder = parse_element (element (cls, fields(26)))
    val r: Fielder = parse_element (element (cls, fields(27)))
    val td: Fielder = parse_element (element (cls, fields(28)))
    val tf: Fielder = parse_element (element (cls, fields(29)))
    val tp: Fielder = parse_element (element (cls, fields(30)))
    val tt: Fielder = parse_element (element (cls, fields(31)))
    val tturb: Fielder = parse_element (element (cls, fields(32)))
    val velcl: Fielder = parse_element (element (cls, fields(33)))
    val velop: Fielder = parse_element (element (cls, fields(34)))

    def parse (context: Context): GovHydroDD =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydroDD (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aturb (), 0)),
            toDouble (mask (bturb (), 1)),
            toDouble (mask (db1 (), 2)),
            toDouble (mask (db2 (), 3)),
            toDouble (mask (eps (), 4)),
            toDouble (mask (gmax (), 5)),
            toDouble (mask (gmin (), 6)),
            toDouble (mask (gv1 (), 7)),
            toDouble (mask (gv2 (), 8)),
            toDouble (mask (gv3 (), 9)),
            toDouble (mask (gv4 (), 10)),
            toDouble (mask (gv5 (), 11)),
            toDouble (mask (gv6 (), 12)),
            toBoolean (mask (inputSignal (), 13)),
            toDouble (mask (k1 (), 14)),
            toDouble (mask (k2 (), 15)),
            toDouble (mask (kg (), 16)),
            toDouble (mask (ki (), 17)),
            toDouble (mask (mwbase (), 18)),
            toDouble (mask (pgv1 (), 19)),
            toDouble (mask (pgv2 (), 20)),
            toDouble (mask (pgv3 (), 21)),
            toDouble (mask (pgv4 (), 22)),
            toDouble (mask (pgv5 (), 23)),
            toDouble (mask (pgv6 (), 24)),
            toDouble (mask (pmax (), 25)),
            toDouble (mask (pmin (), 26)),
            toDouble (mask (r (), 27)),
            toDouble (mask (td (), 28)),
            toDouble (mask (tf (), 29)),
            toDouble (mask (tp (), 30)),
            toDouble (mask (tt (), 31)),
            toDouble (mask (tturb (), 32)),
            toDouble (mask (velcl (), 33)),
            toDouble (mask (velop (), 34))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed hydro unit - Francis model.
 *
 * This model can be used to represent three types of governors.
 * A schematic of the hydraulic system of detailed hydro unit models, such as Francis and Pelton, is provided in the DetailedHydroModelHydraulicSystem diagram.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param am Opening section <i>S</i><i><sub>EFF</sub></i> at the maximum efficiency (<i>Am</i>).
 *        Typical value = 0,7.
 * @param av0 Area of the surge tank (<i>A</i><i><sub>V0</sub></i>).
 *        Unit = m<sup>2</sup>. Typical value = 30.
 * @param av1 Area of the compensation tank (<i>A</i><i><sub>V1</sub></i>).
 *        Unit = m<sup>2</sup>. Typical value = 700.
 * @param bp Droop (<i>Bp</i>).
 *        Typical value = 0,05.
 * @param db1 Intentional dead-band width (<i>DB1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param etamax Maximum efficiency (<i>EtaMax</i>).
 *        Typical value = 1,05.
 * @param governorControl Governor control flag (<i>Cflag</i>).
 *        Typical value = mechanicHydrolicTachoAccelerator.
 * @param h1 Head of compensation chamber water level with respect to the level of penstock (<i>H</i><i><sub>1</sub></i>).
 *        Unit = km.  Typical value = 0,004.
 * @param h2 Head of surge tank water level with respect to the level of penstock (<i>H</i><i><sub>2</sub></i>).
 *        Unit = km.  Typical value = 0,040.
 * @param hn Rated hydraulic head (<i>H</i><i><sub>n</sub></i>).
 *        Unit = km.  Typical value = 0,250.
 * @param kc Penstock loss coefficient (due to friction) (<i>Kc</i>).
 *        Typical value = 0,025.
 * @param kg Water tunnel and surge chamber loss coefficient (due to friction) (<i>Kg</i>).
 *        Typical value = 0,025.
 * @param kt Washout gain (<i>Kt</i>).
 *        Typical value = 0,25.
 * @param qc0 No-load turbine flow at nominal head (<i>Qc0</i>).
 *        Typical value = 0,1.
 * @param qn Rated flow (<i>Q</i><i><sub>n</sub></i>).
 *        Unit = m<sup>3</sup>/s. Typical value = 250.
 * @param ta Derivative gain (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param td Washout time constant (<i>Td</i>) (&gt;= 0).
 *        Typical value = 6.
 * @param ts Gate servo time constant (<i>Ts</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param twnc Water inertia time constant (<i>Twnc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param twng Water tunnel and surge chamber inertia time constant (<i>Twng</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param tx Derivative feedback gain (<i>Tx</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param va Maximum gate opening velocity (<i>Va</i>).
 *        Unit = PU / s.  Typical value = 0,06.
 * @param valvmax Maximum gate opening (<i>ValvMax</i>) (&gt; GovHydroFrancis.valvmin).
 *        Typical value = 1,1.
 * @param valvmin Minimum gate opening (<i>ValvMin</i>) (&lt; GovHydroFrancis.valvmax).
 *        Typical value = 0.
 * @param vc Maximum gate closing velocity (<i>Vc</i>).
 *        Unit = PU / s.  Typical value = -0,06.
 * @param waterTunnelSurgeChamberSimulation Water tunnel and surge chamber simulation (<i>Tflag</i>).
 *        true = enable of water tunnel and surge chamber simulation
 *        false = inhibit of water tunnel and surge chamber simulation.
 *        Typical value = false.
 * @param zsfc Head of upper water level with respect to the level of penstock (<i>Zsfc</i>).
 *        Unit = km.  Typical value = 0,025.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroFrancis
(
    override val sup: TurbineGovernorDynamics = null,
    am: Double = 0.0,
    av0: Double = 0.0,
    av1: Double = 0.0,
    bp: Double = 0.0,
    db1: Double = 0.0,
    etamax: Double = 0.0,
    governorControl: String = null,
    h1: Double = 0.0,
    h2: Double = 0.0,
    hn: Double = 0.0,
    kc: Double = 0.0,
    kg: Double = 0.0,
    kt: Double = 0.0,
    qc0: Double = 0.0,
    qn: Double = 0.0,
    ta: Double = 0.0,
    td: Double = 0.0,
    ts: Double = 0.0,
    twnc: Double = 0.0,
    twng: Double = 0.0,
    tx: Double = 0.0,
    va: Double = 0.0,
    valvmax: Double = 0.0,
    valvmin: Double = 0.0,
    vc: Double = 0.0,
    waterTunnelSurgeChamberSimulation: Boolean = false,
    zsfc: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroFrancis] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroFrancis.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroFrancis.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GovHydroFrancis.fields (position), value)
        emitelem (0, am)
        emitelem (1, av0)
        emitelem (2, av1)
        emitelem (3, bp)
        emitelem (4, db1)
        emitelem (5, etamax)
        emitattr (6, governorControl)
        emitelem (7, h1)
        emitelem (8, h2)
        emitelem (9, hn)
        emitelem (10, kc)
        emitelem (11, kg)
        emitelem (12, kt)
        emitelem (13, qc0)
        emitelem (14, qn)
        emitelem (15, ta)
        emitelem (16, td)
        emitelem (17, ts)
        emitelem (18, twnc)
        emitelem (19, twng)
        emitelem (20, tx)
        emitelem (21, va)
        emitelem (22, valvmax)
        emitelem (23, valvmin)
        emitelem (24, vc)
        emitelem (25, waterTunnelSurgeChamberSimulation)
        emitelem (26, zsfc)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroFrancis rdf:ID=\"%s\">\n%s\t</cim:GovHydroFrancis>".format (id, export_fields)
    }
}

object GovHydroFrancis
extends
    Parseable[GovHydroFrancis]
{
    override val fields: Array[String] = Array[String] (
        "am",
        "av0",
        "av1",
        "bp",
        "db1",
        "etamax",
        "governorControl",
        "h1",
        "h2",
        "hn",
        "kc",
        "kg",
        "kt",
        "qc0",
        "qn",
        "ta",
        "td",
        "ts",
        "twnc",
        "twng",
        "tx",
        "va",
        "valvmax",
        "valvmin",
        "vc",
        "waterTunnelSurgeChamberSimulation",
        "zsfc"
    )
    val am: Fielder = parse_element (element (cls, fields(0)))
    val av0: Fielder = parse_element (element (cls, fields(1)))
    val av1: Fielder = parse_element (element (cls, fields(2)))
    val bp: Fielder = parse_element (element (cls, fields(3)))
    val db1: Fielder = parse_element (element (cls, fields(4)))
    val etamax: Fielder = parse_element (element (cls, fields(5)))
    val governorControl: Fielder = parse_attribute (attribute (cls, fields(6)))
    val h1: Fielder = parse_element (element (cls, fields(7)))
    val h2: Fielder = parse_element (element (cls, fields(8)))
    val hn: Fielder = parse_element (element (cls, fields(9)))
    val kc: Fielder = parse_element (element (cls, fields(10)))
    val kg: Fielder = parse_element (element (cls, fields(11)))
    val kt: Fielder = parse_element (element (cls, fields(12)))
    val qc0: Fielder = parse_element (element (cls, fields(13)))
    val qn: Fielder = parse_element (element (cls, fields(14)))
    val ta: Fielder = parse_element (element (cls, fields(15)))
    val td: Fielder = parse_element (element (cls, fields(16)))
    val ts: Fielder = parse_element (element (cls, fields(17)))
    val twnc: Fielder = parse_element (element (cls, fields(18)))
    val twng: Fielder = parse_element (element (cls, fields(19)))
    val tx: Fielder = parse_element (element (cls, fields(20)))
    val va: Fielder = parse_element (element (cls, fields(21)))
    val valvmax: Fielder = parse_element (element (cls, fields(22)))
    val valvmin: Fielder = parse_element (element (cls, fields(23)))
    val vc: Fielder = parse_element (element (cls, fields(24)))
    val waterTunnelSurgeChamberSimulation: Fielder = parse_element (element (cls, fields(25)))
    val zsfc: Fielder = parse_element (element (cls, fields(26)))

    def parse (context: Context): GovHydroFrancis =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroFrancis (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (am (), 0)),
            toDouble (mask (av0 (), 1)),
            toDouble (mask (av1 (), 2)),
            toDouble (mask (bp (), 3)),
            toDouble (mask (db1 (), 4)),
            toDouble (mask (etamax (), 5)),
            mask (governorControl (), 6),
            toDouble (mask (h1 (), 7)),
            toDouble (mask (h2 (), 8)),
            toDouble (mask (hn (), 9)),
            toDouble (mask (kc (), 10)),
            toDouble (mask (kg (), 11)),
            toDouble (mask (kt (), 12)),
            toDouble (mask (qc0 (), 13)),
            toDouble (mask (qn (), 14)),
            toDouble (mask (ta (), 15)),
            toDouble (mask (td (), 16)),
            toDouble (mask (ts (), 17)),
            toDouble (mask (twnc (), 18)),
            toDouble (mask (twng (), 19)),
            toDouble (mask (tx (), 20)),
            toDouble (mask (va (), 21)),
            toDouble (mask (valvmax (), 22)),
            toDouble (mask (valvmin (), 23)),
            toDouble (mask (vc (), 24)),
            toBoolean (mask (waterTunnelSurgeChamberSimulation (), 25)),
            toDouble (mask (zsfc (), 26))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE simplified hydro governor-turbine model.
 *
 * Used for mechanical-hydraulic and electro-hydraulic turbine governors, with or without steam feedback. Typical values given are for mechanical-hydraulic turbine-governor.
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems, November/December 1973, Volume PAS-92, Number 6, <i><u>Dynamic Models for Steam and Hydro Turbines in Power System Studies</u></i>, page 1904.</font>
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param k Governor gain (<i>K)</i>.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pmax Gate maximum (<i>Pmax</i>) (&gt; GovHydroIEEE0.pmin).
 * @param pmin Gate minimum (<i>Pmin</i>) (&lt; GovHydroIEEE.pmax).
 * @param t1 Governor lag time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 0,25.
 * @param t2 Governor lead time constant (<i>T2)</i> (&gt;= 0).
 *        Typical value = 0.
 * @param t3 Gate actuator time constant (<i>T3</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t4 Water starting time (<i>T4</i>) (&gt;= 0).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroIEEE0
(
    override val sup: TurbineGovernorDynamics = null,
    k: Double = 0.0,
    mwbase: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroIEEE0] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroIEEE0.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroIEEE0.fields (position), value)
        emitelem (0, k)
        emitelem (1, mwbase)
        emitelem (2, pmax)
        emitelem (3, pmin)
        emitelem (4, t1)
        emitelem (5, t2)
        emitelem (6, t3)
        emitelem (7, t4)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroIEEE0 rdf:ID=\"%s\">\n%s\t</cim:GovHydroIEEE0>".format (id, export_fields)
    }
}

object GovHydroIEEE0
extends
    Parseable[GovHydroIEEE0]
{
    override val fields: Array[String] = Array[String] (
        "k",
        "mwbase",
        "pmax",
        "pmin",
        "t1",
        "t2",
        "t3",
        "t4"
    )
    val k: Fielder = parse_element (element (cls, fields(0)))
    val mwbase: Fielder = parse_element (element (cls, fields(1)))
    val pmax: Fielder = parse_element (element (cls, fields(2)))
    val pmin: Fielder = parse_element (element (cls, fields(3)))
    val t1: Fielder = parse_element (element (cls, fields(4)))
    val t2: Fielder = parse_element (element (cls, fields(5)))
    val t3: Fielder = parse_element (element (cls, fields(6)))
    val t4: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): GovHydroIEEE0 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroIEEE0 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (k (), 0)),
            toDouble (mask (mwbase (), 1)),
            toDouble (mask (pmax (), 2)),
            toDouble (mask (pmin (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t2 (), 5)),
            toDouble (mask (t3 (), 6)),
            toDouble (mask (t4 (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE hydro turbine governor model represents plants with straightforward penstock configurations and hydraulic-dashpot governors.
 *
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems, November/December 1973, Volume PAS-92, Number 6, <i><u>Dynamic Models for Steam and Hydro Turbines in Power System Studies</u></i>, page 1904.</font>
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (<i>Aturb</i>).
 *        Typical value = -1.
 * @param bturb Turbine denominator multiplier (<i>Bturb</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param kturb Turbine gain (<i>Kturb</i>).
 *        Typical value = 1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening (<i>Pmax</i>) (&gt; GovHydroIEEE2.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening (<i>Pmin</i>) (&lt;GovHydroIEEE2.pmax).
 *        Typical value = 0.
 * @param rperm Permanent droop (<i>Rperm</i>).
 *        Typical value = 0,05.
 * @param rtemp Temporary droop (<i>Rtemp</i>).
 *        Typical value = 0,5.
 * @param tg Gate servo time constant (<i>Tg</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param tp Pilot servo valve time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,03.
 * @param tr Dashpot time constant (<i>Tr</i>) (&gt;= 0).
 *        Typical value = 12.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt;= 0).
 *        Typical value = 2.
 * @param uc Maximum gate closing velocity (<i>Uc</i>) (&lt;0).
 *        Typical value = -0,1.
 * @param uo Maximum gate opening velocity (<i>Uo</i>).
 *        Unit = PU / s.  Typical value = 0,1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroIEEE2
(
    override val sup: TurbineGovernorDynamics = null,
    aturb: Double = 0.0,
    bturb: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    kturb: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    rperm: Double = 0.0,
    rtemp: Double = 0.0,
    tg: Double = 0.0,
    tp: Double = 0.0,
    tr: Double = 0.0,
    tw: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroIEEE2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroIEEE2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroIEEE2.fields (position), value)
        emitelem (0, aturb)
        emitelem (1, bturb)
        emitelem (2, gv1)
        emitelem (3, gv2)
        emitelem (4, gv3)
        emitelem (5, gv4)
        emitelem (6, gv5)
        emitelem (7, gv6)
        emitelem (8, kturb)
        emitelem (9, mwbase)
        emitelem (10, pgv1)
        emitelem (11, pgv2)
        emitelem (12, pgv3)
        emitelem (13, pgv4)
        emitelem (14, pgv5)
        emitelem (15, pgv6)
        emitelem (16, pmax)
        emitelem (17, pmin)
        emitelem (18, rperm)
        emitelem (19, rtemp)
        emitelem (20, tg)
        emitelem (21, tp)
        emitelem (22, tr)
        emitelem (23, tw)
        emitelem (24, uc)
        emitelem (25, uo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroIEEE2 rdf:ID=\"%s\">\n%s\t</cim:GovHydroIEEE2>".format (id, export_fields)
    }
}

object GovHydroIEEE2
extends
    Parseable[GovHydroIEEE2]
{
    override val fields: Array[String] = Array[String] (
        "aturb",
        "bturb",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "kturb",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "rperm",
        "rtemp",
        "tg",
        "tp",
        "tr",
        "tw",
        "uc",
        "uo"
    )
    val aturb: Fielder = parse_element (element (cls, fields(0)))
    val bturb: Fielder = parse_element (element (cls, fields(1)))
    val gv1: Fielder = parse_element (element (cls, fields(2)))
    val gv2: Fielder = parse_element (element (cls, fields(3)))
    val gv3: Fielder = parse_element (element (cls, fields(4)))
    val gv4: Fielder = parse_element (element (cls, fields(5)))
    val gv5: Fielder = parse_element (element (cls, fields(6)))
    val gv6: Fielder = parse_element (element (cls, fields(7)))
    val kturb: Fielder = parse_element (element (cls, fields(8)))
    val mwbase: Fielder = parse_element (element (cls, fields(9)))
    val pgv1: Fielder = parse_element (element (cls, fields(10)))
    val pgv2: Fielder = parse_element (element (cls, fields(11)))
    val pgv3: Fielder = parse_element (element (cls, fields(12)))
    val pgv4: Fielder = parse_element (element (cls, fields(13)))
    val pgv5: Fielder = parse_element (element (cls, fields(14)))
    val pgv6: Fielder = parse_element (element (cls, fields(15)))
    val pmax: Fielder = parse_element (element (cls, fields(16)))
    val pmin: Fielder = parse_element (element (cls, fields(17)))
    val rperm: Fielder = parse_element (element (cls, fields(18)))
    val rtemp: Fielder = parse_element (element (cls, fields(19)))
    val tg: Fielder = parse_element (element (cls, fields(20)))
    val tp: Fielder = parse_element (element (cls, fields(21)))
    val tr: Fielder = parse_element (element (cls, fields(22)))
    val tw: Fielder = parse_element (element (cls, fields(23)))
    val uc: Fielder = parse_element (element (cls, fields(24)))
    val uo: Fielder = parse_element (element (cls, fields(25)))

    def parse (context: Context): GovHydroIEEE2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroIEEE2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aturb (), 0)),
            toDouble (mask (bturb (), 1)),
            toDouble (mask (gv1 (), 2)),
            toDouble (mask (gv2 (), 3)),
            toDouble (mask (gv3 (), 4)),
            toDouble (mask (gv4 (), 5)),
            toDouble (mask (gv5 (), 6)),
            toDouble (mask (gv6 (), 7)),
            toDouble (mask (kturb (), 8)),
            toDouble (mask (mwbase (), 9)),
            toDouble (mask (pgv1 (), 10)),
            toDouble (mask (pgv2 (), 11)),
            toDouble (mask (pgv3 (), 12)),
            toDouble (mask (pgv4 (), 13)),
            toDouble (mask (pgv5 (), 14)),
            toDouble (mask (pgv6 (), 15)),
            toDouble (mask (pmax (), 16)),
            toDouble (mask (pmin (), 17)),
            toDouble (mask (rperm (), 18)),
            toDouble (mask (rtemp (), 19)),
            toDouble (mask (tg (), 20)),
            toDouble (mask (tp (), 21)),
            toDouble (mask (tr (), 22)),
            toDouble (mask (tw (), 23)),
            toDouble (mask (uc (), 24)),
            toDouble (mask (uo (), 25))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * PID governor and turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (<i>Aturb</i>) (see parameter detail 3).
 *        Typical value -1.
 * @param bturb Turbine denominator multiplier (<i>Bturb</i>) (see parameter detail 3).
 *        Typical value = 0,5.
 * @param db1 Intentional dead-band width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param inputSignal Input signal switch (<i>Flag</i>).
 *        true = <i>Pe</i> input is used
 *        false = feedback is received from <i>CV</i>.
 *        <i>Flag</i> is normally dependent on <i>Tt</i>.
 *        If <i>Tt </i>is zero, <i>Flag</i> is set to false. If <i>Tt</i> is not zero, <i>Flag</i> is set to true.
 *        Typical value = true.
 * @param kd Derivative gain (<i>Kd</i>).
 *        Typical value = 1,11.
 * @param kg Gate servo gain (<i>Kg</i>).
 *        Typical value = 2,5.
 * @param ki Integral gain (<i>Ki</i>).
 *        Typical value = 0,36.
 * @param kp Proportional gain (<i>Kp</i>).
 *        Typical value = 0,1.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (<i>Pmax</i>) (&gt; GovHydroPID.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening, PU of MWbase (<i>Pmin</i>) (&lt; GovHydroPID.pmax).
 *        Typical value = 0.
 * @param r Steady state droop (<i>R</i>).
 *        Typical value = 0,05.
 * @param td Input filter time constant (<i>Td</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0.
 * @param tf Washout time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tp Gate servo time constant (<i>Tp</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,35.
 * @param tt Power feedback time constant (<i>Tt</i>) (&gt;= 0).
 *        If = 0, block is bypassed.  Typical value = 0,02.
 * @param tturb Turbine time constant (<i>Tturb</i>) (&gt;= 0).
 *        See Parameter detail 3.  Typical value = 0,8.
 * @param velcl Maximum gate closing velocity (<i>Velcl</i>).
 *        Unit = PU / s.  Typical value = -0,14.
 * @param velop Maximum gate opening velocity (<i>Velop</i>).
 *        Unit = PU / s.  Typical value = 0,09.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroPID
(
    override val sup: TurbineGovernorDynamics = null,
    aturb: Double = 0.0,
    bturb: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    eps: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    inputSignal: Boolean = false,
    kd: Double = 0.0,
    kg: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    r: Double = 0.0,
    td: Double = 0.0,
    tf: Double = 0.0,
    tp: Double = 0.0,
    tt: Double = 0.0,
    tturb: Double = 0.0,
    velcl: Double = 0.0,
    velop: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroPID] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroPID.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroPID.fields (position), value)
        emitelem (0, aturb)
        emitelem (1, bturb)
        emitelem (2, db1)
        emitelem (3, db2)
        emitelem (4, eps)
        emitelem (5, gv1)
        emitelem (6, gv2)
        emitelem (7, gv3)
        emitelem (8, gv4)
        emitelem (9, gv5)
        emitelem (10, gv6)
        emitelem (11, inputSignal)
        emitelem (12, kd)
        emitelem (13, kg)
        emitelem (14, ki)
        emitelem (15, kp)
        emitelem (16, mwbase)
        emitelem (17, pgv1)
        emitelem (18, pgv2)
        emitelem (19, pgv3)
        emitelem (20, pgv4)
        emitelem (21, pgv5)
        emitelem (22, pgv6)
        emitelem (23, pmax)
        emitelem (24, pmin)
        emitelem (25, r)
        emitelem (26, td)
        emitelem (27, tf)
        emitelem (28, tp)
        emitelem (29, tt)
        emitelem (30, tturb)
        emitelem (31, velcl)
        emitelem (32, velop)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroPID rdf:ID=\"%s\">\n%s\t</cim:GovHydroPID>".format (id, export_fields)
    }
}

object GovHydroPID
extends
    Parseable[GovHydroPID]
{
    override val fields: Array[String] = Array[String] (
        "aturb",
        "bturb",
        "db1",
        "db2",
        "eps",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "inputSignal",
        "kd",
        "kg",
        "ki",
        "kp",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "r",
        "td",
        "tf",
        "tp",
        "tt",
        "tturb",
        "velcl",
        "velop"
    )
    val aturb: Fielder = parse_element (element (cls, fields(0)))
    val bturb: Fielder = parse_element (element (cls, fields(1)))
    val db1: Fielder = parse_element (element (cls, fields(2)))
    val db2: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val gv1: Fielder = parse_element (element (cls, fields(5)))
    val gv2: Fielder = parse_element (element (cls, fields(6)))
    val gv3: Fielder = parse_element (element (cls, fields(7)))
    val gv4: Fielder = parse_element (element (cls, fields(8)))
    val gv5: Fielder = parse_element (element (cls, fields(9)))
    val gv6: Fielder = parse_element (element (cls, fields(10)))
    val inputSignal: Fielder = parse_element (element (cls, fields(11)))
    val kd: Fielder = parse_element (element (cls, fields(12)))
    val kg: Fielder = parse_element (element (cls, fields(13)))
    val ki: Fielder = parse_element (element (cls, fields(14)))
    val kp: Fielder = parse_element (element (cls, fields(15)))
    val mwbase: Fielder = parse_element (element (cls, fields(16)))
    val pgv1: Fielder = parse_element (element (cls, fields(17)))
    val pgv2: Fielder = parse_element (element (cls, fields(18)))
    val pgv3: Fielder = parse_element (element (cls, fields(19)))
    val pgv4: Fielder = parse_element (element (cls, fields(20)))
    val pgv5: Fielder = parse_element (element (cls, fields(21)))
    val pgv6: Fielder = parse_element (element (cls, fields(22)))
    val pmax: Fielder = parse_element (element (cls, fields(23)))
    val pmin: Fielder = parse_element (element (cls, fields(24)))
    val r: Fielder = parse_element (element (cls, fields(25)))
    val td: Fielder = parse_element (element (cls, fields(26)))
    val tf: Fielder = parse_element (element (cls, fields(27)))
    val tp: Fielder = parse_element (element (cls, fields(28)))
    val tt: Fielder = parse_element (element (cls, fields(29)))
    val tturb: Fielder = parse_element (element (cls, fields(30)))
    val velcl: Fielder = parse_element (element (cls, fields(31)))
    val velop: Fielder = parse_element (element (cls, fields(32)))

    def parse (context: Context): GovHydroPID =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydroPID (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (aturb (), 0)),
            toDouble (mask (bturb (), 1)),
            toDouble (mask (db1 (), 2)),
            toDouble (mask (db2 (), 3)),
            toDouble (mask (eps (), 4)),
            toDouble (mask (gv1 (), 5)),
            toDouble (mask (gv2 (), 6)),
            toDouble (mask (gv3 (), 7)),
            toDouble (mask (gv4 (), 8)),
            toDouble (mask (gv5 (), 9)),
            toDouble (mask (gv6 (), 10)),
            toBoolean (mask (inputSignal (), 11)),
            toDouble (mask (kd (), 12)),
            toDouble (mask (kg (), 13)),
            toDouble (mask (ki (), 14)),
            toDouble (mask (kp (), 15)),
            toDouble (mask (mwbase (), 16)),
            toDouble (mask (pgv1 (), 17)),
            toDouble (mask (pgv2 (), 18)),
            toDouble (mask (pgv3 (), 19)),
            toDouble (mask (pgv4 (), 20)),
            toDouble (mask (pgv5 (), 21)),
            toDouble (mask (pgv6 (), 22)),
            toDouble (mask (pmax (), 23)),
            toDouble (mask (pmin (), 24)),
            toDouble (mask (r (), 25)),
            toDouble (mask (td (), 26)),
            toDouble (mask (tf (), 27)),
            toDouble (mask (tp (), 28)),
            toDouble (mask (tt (), 29)),
            toDouble (mask (tturb (), 30)),
            toDouble (mask (velcl (), 31)),
            toDouble (mask (velop (), 32))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Hydro turbine and governor.
 *
 * Represents plants with straightforward penstock configurations and "three term" electro-hydraulic governors (i.e. Woodward<sup>TM</sup> electronic).
 * [Footnote: Woodward electronic governors are an example of suitable products available commercially. This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param atw Factor multiplying <i>Tw</i> (<i>Atw</i>).
 *        Typical value = 0.
 * @param d Turbine damping factor (<i>D</i>).
 *        Unit = delta P / delta speed.  Typical value = 0.
 * @param feedbackSignal Feedback signal type flag (<i>Flag</i>).
 *        true = use gate position feedback signal
 *        false = use Pe.
 * @param g0 Gate opening at speed no load (<i>G0</i>).
 *        Typical value = 0.
 * @param g1 Intermediate gate opening (<i>G1</i>).
 *        Typical value = 0.
 * @param g2 Intermediate gate opening (<i>G2</i>).
 *        Typical value = 0.
 * @param gmax Maximum gate opening (<i>Gmax</i>) (&gt; GovHydroPID2.gmin).
 *        Typical value = 0.
 * @param gmin Minimum gate opening (<i>Gmin</i>) (&gt; GovHydroPID2.gmax).
 *        Typical value = 0.
 * @param kd Derivative gain (<i>Kd</i>).
 *        Typical value = 0.
 * @param ki Reset gain (<i>Ki</i>).
 *        Unit = PU/s.  Typical value = 0.
 * @param kp Proportional gain (<i>Kp</i>).
 *        Typical value = 0.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt;0).
 *        Unit = MW.
 * @param p1 Power at gate opening <i>G1</i> (<i>P1</i>).
 *        Typical value = 0.
 * @param p2 Power at gate opening G2 (<i>P2</i>).
 *        Typical value = 0.
 * @param p3 Power at full opened gate (<i>P3</i>).
 *        Typical value = 0.
 * @param rperm Permanent drop (<i>Rperm</i>).
 *        Typical value = 0.
 * @param ta Controller time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tb Gate servo time constant (<i>Tb</i>) (&gt; 0).
 * @param treg Speed detector time constant (<i>Treg</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param velmax Maximum gate opening velocity (<i>Velmax</i>) (&lt; GovHydroPID2.velmin).
 *        Unit = PU / s.  Typical value = 0.
 * @param velmin Maximum gate closing velocity (<i>Velmin</i>) (&gt; GovHydroPID2.velmax).
 *        Unit = PU / s.  Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroPID2
(
    override val sup: TurbineGovernorDynamics = null,
    atw: Double = 0.0,
    d: Double = 0.0,
    feedbackSignal: Boolean = false,
    g0: Double = 0.0,
    g1: Double = 0.0,
    g2: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    kd: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    p1: Double = 0.0,
    p2: Double = 0.0,
    p3: Double = 0.0,
    rperm: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    treg: Double = 0.0,
    tw: Double = 0.0,
    velmax: Double = 0.0,
    velmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroPID2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroPID2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroPID2.fields (position), value)
        emitelem (0, atw)
        emitelem (1, d)
        emitelem (2, feedbackSignal)
        emitelem (3, g0)
        emitelem (4, g1)
        emitelem (5, g2)
        emitelem (6, gmax)
        emitelem (7, gmin)
        emitelem (8, kd)
        emitelem (9, ki)
        emitelem (10, kp)
        emitelem (11, mwbase)
        emitelem (12, p1)
        emitelem (13, p2)
        emitelem (14, p3)
        emitelem (15, rperm)
        emitelem (16, ta)
        emitelem (17, tb)
        emitelem (18, treg)
        emitelem (19, tw)
        emitelem (20, velmax)
        emitelem (21, velmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroPID2 rdf:ID=\"%s\">\n%s\t</cim:GovHydroPID2>".format (id, export_fields)
    }
}

object GovHydroPID2
extends
    Parseable[GovHydroPID2]
{
    override val fields: Array[String] = Array[String] (
        "atw",
        "d",
        "feedbackSignal",
        "g0",
        "g1",
        "g2",
        "gmax",
        "gmin",
        "kd",
        "ki",
        "kp",
        "mwbase",
        "p1",
        "p2",
        "p3",
        "rperm",
        "ta",
        "tb",
        "treg",
        "tw",
        "velmax",
        "velmin"
    )
    val atw: Fielder = parse_element (element (cls, fields(0)))
    val d: Fielder = parse_element (element (cls, fields(1)))
    val feedbackSignal: Fielder = parse_element (element (cls, fields(2)))
    val g0: Fielder = parse_element (element (cls, fields(3)))
    val g1: Fielder = parse_element (element (cls, fields(4)))
    val g2: Fielder = parse_element (element (cls, fields(5)))
    val gmax: Fielder = parse_element (element (cls, fields(6)))
    val gmin: Fielder = parse_element (element (cls, fields(7)))
    val kd: Fielder = parse_element (element (cls, fields(8)))
    val ki: Fielder = parse_element (element (cls, fields(9)))
    val kp: Fielder = parse_element (element (cls, fields(10)))
    val mwbase: Fielder = parse_element (element (cls, fields(11)))
    val p1: Fielder = parse_element (element (cls, fields(12)))
    val p2: Fielder = parse_element (element (cls, fields(13)))
    val p3: Fielder = parse_element (element (cls, fields(14)))
    val rperm: Fielder = parse_element (element (cls, fields(15)))
    val ta: Fielder = parse_element (element (cls, fields(16)))
    val tb: Fielder = parse_element (element (cls, fields(17)))
    val treg: Fielder = parse_element (element (cls, fields(18)))
    val tw: Fielder = parse_element (element (cls, fields(19)))
    val velmax: Fielder = parse_element (element (cls, fields(20)))
    val velmin: Fielder = parse_element (element (cls, fields(21)))

    def parse (context: Context): GovHydroPID2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroPID2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (atw (), 0)),
            toDouble (mask (d (), 1)),
            toBoolean (mask (feedbackSignal (), 2)),
            toDouble (mask (g0 (), 3)),
            toDouble (mask (g1 (), 4)),
            toDouble (mask (g2 (), 5)),
            toDouble (mask (gmax (), 6)),
            toDouble (mask (gmin (), 7)),
            toDouble (mask (kd (), 8)),
            toDouble (mask (ki (), 9)),
            toDouble (mask (kp (), 10)),
            toDouble (mask (mwbase (), 11)),
            toDouble (mask (p1 (), 12)),
            toDouble (mask (p2 (), 13)),
            toDouble (mask (p3 (), 14)),
            toDouble (mask (rperm (), 15)),
            toDouble (mask (ta (), 16)),
            toDouble (mask (tb (), 17)),
            toDouble (mask (treg (), 18)),
            toDouble (mask (tw (), 19)),
            toDouble (mask (velmax (), 20)),
            toDouble (mask (velmin (), 21))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed hydro unit - Pelton model.
 *
 * This model can be used to represent the dynamic related to water tunnel and surge chamber.
 * The DetailedHydroModelHydraulicSystem diagram, located under the GovHydroFrancis class, provides a schematic of the hydraulic system of detailed hydro unit models, such as Francis and Pelton.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param av0 Area of the surge tank (<i>A</i><i><sub>V0</sub></i>).
 *        Unit = m<sup>2</sup>. Typical value = 30.
 * @param av1 Area of the compensation tank (<i>A</i><i><sub>V1</sub></i>).
 *        Unit = m<sup>2</sup>. Typical value = 700.
 * @param bp Droop (<i>bp</i>).
 *        Typical value = 0,05.
 * @param db1 Intentional dead-band width (<i>DB1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Intentional dead-band width of valve opening error (<i>DB2</i>).
 *        Unit = Hz.  Typical value = 0,01.
 * @param h1 Head of compensation chamber water level with respect to the level of penstock (<i>H</i><i><sub>1</sub></i>).
 *        Unit = km.  Typical value = 0,004.
 * @param h2 Head of surge tank water level with respect to the level of penstock (<i>H</i><i><sub>2</sub></i>).
 *        Unit = km.  Typical value = 0,040.
 * @param hn Rated hydraulic head (<i>H</i><i><sub>n</sub></i>).
 *        Unit = km.  Typical value = 0,250.
 * @param kc Penstock loss coefficient (due to friction) (<i>Kc</i>).
 *        Typical value = 0,025.
 * @param kg Water tunnel and surge chamber loss coefficient (due to friction) (<i>Kg</i>).
 *        Typical value = 0,025.
 * @param qc0 No-load turbine flow at nominal head (<i>Qc0</i>).
 *        Typical value = 0,05.
 * @param qn Rated flow (<i>Q</i><i><sub>n</sub></i>).
 *        Unit = m<sup>3</sup>/s. Typical value = 250.
 * @param simplifiedPelton Simplified Pelton model simulation (<i>Sflag</i>).
 *        true = enable of simplified Pelton model simulation
 *        false = enable of complete Pelton model simulation (non-linear gain).
 *        Typical value = true.
 * @param staticCompensating Static compensating characteristic (<i>Cflag</i>).
 *        It should be true if simplifiedPelton = false.
 *        true = enable of static compensating characteristic
 *        false = inhibit of static compensating characteristic.
 *        Typical value = false.
 * @param ta Derivative gain (accelerometer time constant) (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param ts Gate servo time constant (<i>Ts</i>) (&gt;= 0).
 *        Typical value = 0,15.
 * @param tv Servomotor integrator time constant (<i>Tv</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param twnc Water inertia time constant (<i>Twnc</i>) (&gt;= 0).
 *        Typical value = 1.
 * @param twng Water tunnel and surge chamber inertia time constant (<i>Twng</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param tx Electronic integrator time constant (<i>Tx</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param va Maximum gate opening velocity (<i>Va</i>).
 *        Unit = PU / s.  Typical value = 0,06.
 * @param valvmax Maximum gate opening (<i>ValvMax</i>) (&gt; GovHydroPelton.valvmin).
 *        Typical value = 1,1.
 * @param valvmin Minimum gate opening (<i>ValvMin</i>) (&lt; GovHydroPelton.valvmax).
 *        Typical value = 0.
 * @param vav Maximum servomotor valve opening velocity (<i>Vav</i>).
 *        Typical value = 0,1.
 * @param vc Maximum gate closing velocity (<i>Vc</i>).
 *        Unit = PU / s.  Typical value = -0,06.
 * @param vcv Maximum servomotor valve closing velocity (<i>Vcv</i>).
 *        Typical value = -0,1.
 * @param waterTunnelSurgeChamberSimulation Water tunnel and surge chamber simulation (<i>Tflag</i>).
 *        true = enable of water tunnel and surge chamber simulation
 *        false = inhibit of water tunnel and surge chamber simulation.
 *        Typical value = false.
 * @param zsfc Head of upper water level with respect to the level of penstock (<i>Zsfc</i>).
 *        Unit = km.  Typical value = 0,025.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroPelton
(
    override val sup: TurbineGovernorDynamics = null,
    av0: Double = 0.0,
    av1: Double = 0.0,
    bp: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    h1: Double = 0.0,
    h2: Double = 0.0,
    hn: Double = 0.0,
    kc: Double = 0.0,
    kg: Double = 0.0,
    qc0: Double = 0.0,
    qn: Double = 0.0,
    simplifiedPelton: Boolean = false,
    staticCompensating: Boolean = false,
    ta: Double = 0.0,
    ts: Double = 0.0,
    tv: Double = 0.0,
    twnc: Double = 0.0,
    twng: Double = 0.0,
    tx: Double = 0.0,
    va: Double = 0.0,
    valvmax: Double = 0.0,
    valvmin: Double = 0.0,
    vav: Double = 0.0,
    vc: Double = 0.0,
    vcv: Double = 0.0,
    waterTunnelSurgeChamberSimulation: Boolean = false,
    zsfc: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroPelton] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroPelton.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroPelton.fields (position), value)
        emitelem (0, av0)
        emitelem (1, av1)
        emitelem (2, bp)
        emitelem (3, db1)
        emitelem (4, db2)
        emitelem (5, h1)
        emitelem (6, h2)
        emitelem (7, hn)
        emitelem (8, kc)
        emitelem (9, kg)
        emitelem (10, qc0)
        emitelem (11, qn)
        emitelem (12, simplifiedPelton)
        emitelem (13, staticCompensating)
        emitelem (14, ta)
        emitelem (15, ts)
        emitelem (16, tv)
        emitelem (17, twnc)
        emitelem (18, twng)
        emitelem (19, tx)
        emitelem (20, va)
        emitelem (21, valvmax)
        emitelem (22, valvmin)
        emitelem (23, vav)
        emitelem (24, vc)
        emitelem (25, vcv)
        emitelem (26, waterTunnelSurgeChamberSimulation)
        emitelem (27, zsfc)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroPelton rdf:ID=\"%s\">\n%s\t</cim:GovHydroPelton>".format (id, export_fields)
    }
}

object GovHydroPelton
extends
    Parseable[GovHydroPelton]
{
    override val fields: Array[String] = Array[String] (
        "av0",
        "av1",
        "bp",
        "db1",
        "db2",
        "h1",
        "h2",
        "hn",
        "kc",
        "kg",
        "qc0",
        "qn",
        "simplifiedPelton",
        "staticCompensating",
        "ta",
        "ts",
        "tv",
        "twnc",
        "twng",
        "tx",
        "va",
        "valvmax",
        "valvmin",
        "vav",
        "vc",
        "vcv",
        "waterTunnelSurgeChamberSimulation",
        "zsfc"
    )
    val av0: Fielder = parse_element (element (cls, fields(0)))
    val av1: Fielder = parse_element (element (cls, fields(1)))
    val bp: Fielder = parse_element (element (cls, fields(2)))
    val db1: Fielder = parse_element (element (cls, fields(3)))
    val db2: Fielder = parse_element (element (cls, fields(4)))
    val h1: Fielder = parse_element (element (cls, fields(5)))
    val h2: Fielder = parse_element (element (cls, fields(6)))
    val hn: Fielder = parse_element (element (cls, fields(7)))
    val kc: Fielder = parse_element (element (cls, fields(8)))
    val kg: Fielder = parse_element (element (cls, fields(9)))
    val qc0: Fielder = parse_element (element (cls, fields(10)))
    val qn: Fielder = parse_element (element (cls, fields(11)))
    val simplifiedPelton: Fielder = parse_element (element (cls, fields(12)))
    val staticCompensating: Fielder = parse_element (element (cls, fields(13)))
    val ta: Fielder = parse_element (element (cls, fields(14)))
    val ts: Fielder = parse_element (element (cls, fields(15)))
    val tv: Fielder = parse_element (element (cls, fields(16)))
    val twnc: Fielder = parse_element (element (cls, fields(17)))
    val twng: Fielder = parse_element (element (cls, fields(18)))
    val tx: Fielder = parse_element (element (cls, fields(19)))
    val va: Fielder = parse_element (element (cls, fields(20)))
    val valvmax: Fielder = parse_element (element (cls, fields(21)))
    val valvmin: Fielder = parse_element (element (cls, fields(22)))
    val vav: Fielder = parse_element (element (cls, fields(23)))
    val vc: Fielder = parse_element (element (cls, fields(24)))
    val vcv: Fielder = parse_element (element (cls, fields(25)))
    val waterTunnelSurgeChamberSimulation: Fielder = parse_element (element (cls, fields(26)))
    val zsfc: Fielder = parse_element (element (cls, fields(27)))

    def parse (context: Context): GovHydroPelton =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroPelton (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (av0 (), 0)),
            toDouble (mask (av1 (), 1)),
            toDouble (mask (bp (), 2)),
            toDouble (mask (db1 (), 3)),
            toDouble (mask (db2 (), 4)),
            toDouble (mask (h1 (), 5)),
            toDouble (mask (h2 (), 6)),
            toDouble (mask (hn (), 7)),
            toDouble (mask (kc (), 8)),
            toDouble (mask (kg (), 9)),
            toDouble (mask (qc0 (), 10)),
            toDouble (mask (qn (), 11)),
            toBoolean (mask (simplifiedPelton (), 12)),
            toBoolean (mask (staticCompensating (), 13)),
            toDouble (mask (ta (), 14)),
            toDouble (mask (ts (), 15)),
            toDouble (mask (tv (), 16)),
            toDouble (mask (twnc (), 17)),
            toDouble (mask (twng (), 18)),
            toDouble (mask (tx (), 19)),
            toDouble (mask (va (), 20)),
            toDouble (mask (valvmax (), 21)),
            toDouble (mask (valvmin (), 22)),
            toDouble (mask (vav (), 23)),
            toDouble (mask (vc (), 24)),
            toDouble (mask (vcv (), 25)),
            toBoolean (mask (waterTunnelSurgeChamberSimulation (), 26)),
            toDouble (mask (zsfc (), 27))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Fourth order lead-lag governor and hydro turbine.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param at Turbine gain (<i>At</i>).
 *        Typical value = 1,2.
 * @param db1 Intentional dead-band width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional dead-band (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param dturb Turbine damping factor (<i>Dturb</i>).
 *        Typical value = 0,2.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gmax Maximum governor output (<i>Gmax</i>) (&gt; GovHydroR.gmin).
 *        Typical value = 1,05.
 * @param gmin Minimum governor output (<i>Gmin</i>) (&lt; GovHydroR.gmax).
 *        Typical value = -0,05.
 * @param gv1 Nonlinear gain point 1, PU gv (<i>Gv1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (<i>Gv2</i>).
 *        Typical value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (<i>Gv3</i>).
 *        Typical value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (<i>Gv4</i>).
 *        Typical value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (<i>Gv5</i>).
 *        Typical value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (<i>Gv6</i>).
 *        Typical value = 0.
 * @param h0 Turbine nominal head (<i>H0</i>).
 *        Typical value = 1.
 * @param inputSignal Input signal switch (<i>Flag</i>).
 *        true = <i>Pe</i> input is used
 *        false = feedback is received from <i>CV</i>.
 *        <i>Flag</i> is normally dependent on <i>Tt</i>.
 *        If <i>Tt </i>is zero, <i>Flag</i> is set to false. If <i>Tt</i> is not zero, <i>Flag</i> is set to true.
 *        Typical value = true.
 * @param kg Gate servo gain (<i>Kg</i>).
 *        Typical value = 2.
 * @param ki Integral gain (<i>Ki</i>).
 *        Typical value = 0,5.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (<i>Pgv2</i>).
 *        Typical value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (<i>Pgv3</i>).
 *        Typical value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (<i>Pgv4</i>).
 *        Typical value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (<i>Pgv5</i>).
 *        Typical value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum gate opening, PU of <i>MWbase</i> (<i>Pmax</i>) (&gt; GovHydroR.pmin).
 *        Typical value = 1.
 * @param pmin Minimum gate opening, PU of <i>MWbase</i> (<i>Pmin</i>) (&lt; GovHydroR.pmax).
 *        Typical value = 0.
 * @param qnl No-load turbine flow at nominal head (<i>Qnl</i>).
 *        Typical value = 0,08.
 * @param r Steady-state droop (<i>R</i>).
 *        Typical value = 0,05.
 * @param t1 Lead time constant 1 (<i>T1</i>) (&gt;= 0).
 *        Typical value = 1,5.
 * @param t2 Lag time constant 1 (<i>T2</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t3 Lead time constant 2 (<i>T3</i>) (&gt;= 0).
 *        Typical value = 1,5.
 * @param t4 Lag time constant 2 (<i>T4</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t5 Lead time constant 3 (<i>T5</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t6 Lag time constant 3 (<i>T6</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param t7 Lead time constant 4 (<i>T7</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t8 Lag time constant 4 (<i>T8</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param td Input filter time constant (<i>Td</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tp Gate servo time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,05.
 * @param tt Power feedback time constant (<i>Tt</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt; 0).
 *        Typical value = 1.
 * @param velcl Maximum gate closing velocity (<i>Velcl</i>).
 *        Unit = PU / s.  Typical value = -0,2.
 * @param velop Maximum gate opening velocity (<i>Velop</i>).
 *        Unit = PU / s.  Typical value = 0,2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroR
(
    override val sup: TurbineGovernorDynamics = null,
    at: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    dturb: Double = 0.0,
    eps: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    h0: Double = 0.0,
    inputSignal: Boolean = false,
    kg: Double = 0.0,
    ki: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    qnl: Double = 0.0,
    r: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    t8: Double = 0.0,
    td: Double = 0.0,
    tp: Double = 0.0,
    tt: Double = 0.0,
    tw: Double = 0.0,
    velcl: Double = 0.0,
    velop: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroR] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroR.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroR.fields (position), value)
        emitelem (0, at)
        emitelem (1, db1)
        emitelem (2, db2)
        emitelem (3, dturb)
        emitelem (4, eps)
        emitelem (5, gmax)
        emitelem (6, gmin)
        emitelem (7, gv1)
        emitelem (8, gv2)
        emitelem (9, gv3)
        emitelem (10, gv4)
        emitelem (11, gv5)
        emitelem (12, gv6)
        emitelem (13, h0)
        emitelem (14, inputSignal)
        emitelem (15, kg)
        emitelem (16, ki)
        emitelem (17, mwbase)
        emitelem (18, pgv1)
        emitelem (19, pgv2)
        emitelem (20, pgv3)
        emitelem (21, pgv4)
        emitelem (22, pgv5)
        emitelem (23, pgv6)
        emitelem (24, pmax)
        emitelem (25, pmin)
        emitelem (26, qnl)
        emitelem (27, r)
        emitelem (28, t1)
        emitelem (29, t2)
        emitelem (30, t3)
        emitelem (31, t4)
        emitelem (32, t5)
        emitelem (33, t6)
        emitelem (34, t7)
        emitelem (35, t8)
        emitelem (36, td)
        emitelem (37, tp)
        emitelem (38, tt)
        emitelem (39, tw)
        emitelem (40, velcl)
        emitelem (41, velop)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroR rdf:ID=\"%s\">\n%s\t</cim:GovHydroR>".format (id, export_fields)
    }
}

object GovHydroR
extends
    Parseable[GovHydroR]
{
    override val fields: Array[String] = Array[String] (
        "at",
        "db1",
        "db2",
        "dturb",
        "eps",
        "gmax",
        "gmin",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "h0",
        "inputSignal",
        "kg",
        "ki",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "qnl",
        "r",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "t7",
        "t8",
        "td",
        "tp",
        "tt",
        "tw",
        "velcl",
        "velop"
    )
    val at: Fielder = parse_element (element (cls, fields(0)))
    val db1: Fielder = parse_element (element (cls, fields(1)))
    val db2: Fielder = parse_element (element (cls, fields(2)))
    val dturb: Fielder = parse_element (element (cls, fields(3)))
    val eps: Fielder = parse_element (element (cls, fields(4)))
    val gmax: Fielder = parse_element (element (cls, fields(5)))
    val gmin: Fielder = parse_element (element (cls, fields(6)))
    val gv1: Fielder = parse_element (element (cls, fields(7)))
    val gv2: Fielder = parse_element (element (cls, fields(8)))
    val gv3: Fielder = parse_element (element (cls, fields(9)))
    val gv4: Fielder = parse_element (element (cls, fields(10)))
    val gv5: Fielder = parse_element (element (cls, fields(11)))
    val gv6: Fielder = parse_element (element (cls, fields(12)))
    val h0: Fielder = parse_element (element (cls, fields(13)))
    val inputSignal: Fielder = parse_element (element (cls, fields(14)))
    val kg: Fielder = parse_element (element (cls, fields(15)))
    val ki: Fielder = parse_element (element (cls, fields(16)))
    val mwbase: Fielder = parse_element (element (cls, fields(17)))
    val pgv1: Fielder = parse_element (element (cls, fields(18)))
    val pgv2: Fielder = parse_element (element (cls, fields(19)))
    val pgv3: Fielder = parse_element (element (cls, fields(20)))
    val pgv4: Fielder = parse_element (element (cls, fields(21)))
    val pgv5: Fielder = parse_element (element (cls, fields(22)))
    val pgv6: Fielder = parse_element (element (cls, fields(23)))
    val pmax: Fielder = parse_element (element (cls, fields(24)))
    val pmin: Fielder = parse_element (element (cls, fields(25)))
    val qnl: Fielder = parse_element (element (cls, fields(26)))
    val r: Fielder = parse_element (element (cls, fields(27)))
    val t1: Fielder = parse_element (element (cls, fields(28)))
    val t2: Fielder = parse_element (element (cls, fields(29)))
    val t3: Fielder = parse_element (element (cls, fields(30)))
    val t4: Fielder = parse_element (element (cls, fields(31)))
    val t5: Fielder = parse_element (element (cls, fields(32)))
    val t6: Fielder = parse_element (element (cls, fields(33)))
    val t7: Fielder = parse_element (element (cls, fields(34)))
    val t8: Fielder = parse_element (element (cls, fields(35)))
    val td: Fielder = parse_element (element (cls, fields(36)))
    val tp: Fielder = parse_element (element (cls, fields(37)))
    val tt: Fielder = parse_element (element (cls, fields(38)))
    val tw: Fielder = parse_element (element (cls, fields(39)))
    val velcl: Fielder = parse_element (element (cls, fields(40)))
    val velop: Fielder = parse_element (element (cls, fields(41)))

    def parse (context: Context): GovHydroR =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydroR (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (at (), 0)),
            toDouble (mask (db1 (), 1)),
            toDouble (mask (db2 (), 2)),
            toDouble (mask (dturb (), 3)),
            toDouble (mask (eps (), 4)),
            toDouble (mask (gmax (), 5)),
            toDouble (mask (gmin (), 6)),
            toDouble (mask (gv1 (), 7)),
            toDouble (mask (gv2 (), 8)),
            toDouble (mask (gv3 (), 9)),
            toDouble (mask (gv4 (), 10)),
            toDouble (mask (gv5 (), 11)),
            toDouble (mask (gv6 (), 12)),
            toDouble (mask (h0 (), 13)),
            toBoolean (mask (inputSignal (), 14)),
            toDouble (mask (kg (), 15)),
            toDouble (mask (ki (), 16)),
            toDouble (mask (mwbase (), 17)),
            toDouble (mask (pgv1 (), 18)),
            toDouble (mask (pgv2 (), 19)),
            toDouble (mask (pgv3 (), 20)),
            toDouble (mask (pgv4 (), 21)),
            toDouble (mask (pgv5 (), 22)),
            toDouble (mask (pgv6 (), 23)),
            toDouble (mask (pmax (), 24)),
            toDouble (mask (pmin (), 25)),
            toDouble (mask (qnl (), 26)),
            toDouble (mask (r (), 27)),
            toDouble (mask (t1 (), 28)),
            toDouble (mask (t2 (), 29)),
            toDouble (mask (t3 (), 30)),
            toDouble (mask (t4 (), 31)),
            toDouble (mask (t5 (), 32)),
            toDouble (mask (t6 (), 33)),
            toDouble (mask (t7 (), 34)),
            toDouble (mask (t8 (), 35)),
            toDouble (mask (td (), 36)),
            toDouble (mask (tp (), 37)),
            toDouble (mask (tt (), 38)),
            toDouble (mask (tw (), 39)),
            toDouble (mask (velcl (), 40)),
            toDouble (mask (velop (), 41))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Woodward<sup>TM </sup>electric hydro governor.
 * [Footnote: Woodward electric hydro governors are an example of suitable products available commercially.
 *
 * This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param db Speed deadband (<i>db</i>).
 * @param dicn Value to allow the integral controller to advance beyond the gate limits (<i>Dicn</i>).
 * @param dpv Value to allow the pilot valve controller to advance beyond the gate limits (<i>Dpv</i>).
 * @param dturb Turbine damping factor (<i>Dturb</i>).
 *        Unit = delta P (PU of <i>MWbase</i>) / delta speed (PU).
 * @param feedbackSignal Feedback signal selection (<i>Sw</i>).
 *        true = PID output (if <i>R-Perm-Gate </i>= droop and <i>R-Perm-Pe </i>= 0)
 *        false = electrical power (if <i>R-Perm-Gate </i>= 0 and <i>R-Perm-Pe </i>= droop) or
 *        false = gate position (if R<i>-Perm-Gate </i>= droop and <i>R-Perm-Pe </i>= 0).
 *        Typical value = false.
 * @param fl1 Flowgate 1 (<i>Fl1</i>).
 *        Flow value for gate position point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl2 Flowgate 2 (<i>Fl2</i>).
 *        Flow value for gate position point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl3 Flowgate 3 (<i>Fl3</i>).
 *        Flow value for gate position point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl4 Flowgate 4 (<i>Fl4</i>).
 *        Flow value for gate position point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl5 Flowgate 5 (<i>Fl5</i>).
 *        Flow value for gate position point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fp1 Flow P1 (<i>Fp1</i>).
 *        Turbine flow value for point 1 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp10 Flow P10 (<i>Fp10</i>).
 *        Turbine flow value for point 10 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp2 Flow P2 (<i>Fp2</i>).
 *        Turbine flow value for point 2 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp3 Flow P3 (<i>Fp3</i>).
 *        Turbine flow value for point 3 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp4 Flow P4 (<i>Fp4</i>).
 *        Turbine flow value for point 4 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp5 Flow P5 (<i>Fp5</i>).
 *        Turbine flow value for point 5 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp6 Flow P6 (<i>Fp6</i>).
 *        Turbine flow value for point 6 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp7 Flow P7 (<i>Fp7</i>).
 *        Turbine flow value for point 7 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp8 Flow P8 (<i>Fp8</i>).
 *        Turbine flow value for point 8 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp9 Flow P9 (<i>Fp9</i>).
 *        Turbine flow value for point 9 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param gmax Maximum gate position (<i>Gmax</i>) (&gt; GovHydroWEH.gmin).
 * @param gmin Minimum gate position (<i>Gmin</i>) (&lt; GovHydroWEH.gmax).
 * @param gtmxcl Maximum gate closing rate (<i>Gtmxcl</i>).
 * @param gtmxop Maximum gate opening rate (<i>Gtmxop</i>).
 * @param gv1 Gate 1 (<i>Gv1</i>).
 *        Gate Position value for point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv2 Gate 2 (<i>Gv2</i>).
 *        Gate Position value for point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv3 Gate 3 (<i>Gv3</i>).
 *        Gate Position value for point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv4 Gate 4 (<i>Gv4</i>).
 *        Gate Position value for point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv5 Gate 5 (<i>Gv5</i>).
 *        Gate Position value for point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param kd Derivative controller derivative gain (<i>Kd</i>).
 * @param ki Derivative controller Integral gain (<i>Ki</i>).
 * @param kp Derivative control gain (<i>Kp</i>).
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pmss1 Pmss flow P1 (<i>Pmss1</i>).
 *        Mechanical power output for turbine flow point 1 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss10 Pmss flow P10 (<i>Pmss10</i>).
 *        Mechanical power output for turbine flow point 10 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss2 Pmss flow P2 (<i>Pmss2</i>).
 *        Mechanical power output for turbine flow point 2 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss3 Pmss flow P3 (<i>Pmss3</i>).
 *        Mechanical power output for turbine flow point 3 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss4 Pmss flow P4 (<i>Pmss4</i>).
 *        Mechanical power output for turbine flow point 4 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss5 Pmss flow P5 (<i>Pmss5</i>).
 *        Mechanical power output for turbine flow point 5 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss6 Pmss flow P6 (<i>Pmss6</i>).
 *        Mechanical power output for turbine flow point 6 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss7 Pmss flow P7 (<i>Pmss7</i>).
 *        Mechanical power output for turbine flow point 7 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss8 Pmss flow P8 (<i>Pmss8</i>).
 *        Mechanical power output for turbine flow point 8 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss9 Pmss flow P9 (<i>Pmss9</i>).
 *        Mechanical power output for turbine flow point 9 for lookup table representing PU mechanical power on machine MVA rating as a function of turbine flow.
 * @param rpg Permanent droop for governor output feedback (<i>R-Perm-Gate</i>).
 * @param rpp Permanent droop for electrical power feedback (<i>R-Perm-Pe</i>).
 * @param td Derivative controller time constant (<i>Td</i>) (&gt;= 0).
 *        Limits the derivative characteristic beyond a breakdown frequency to avoid amplification of high-frequency noise.
 * @param tdv Distributive valve time lag time constant (<i>Tdv</i>) (&gt;= 0).
 * @param tg Value to allow the distribution valve controller to advance beyond the gate movement rate limit (<i>Tg</i>) (&gt;= 0).
 * @param tp Pilot valve time lag time constant (<i>Tp</i>) (&gt;= 0).
 * @param tpe Electrical power droop time constant (<i>Tpe</i>) (&gt;= 0).
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt; 0).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroWEH
(
    override val sup: TurbineGovernorDynamics = null,
    db: Double = 0.0,
    dicn: Double = 0.0,
    dpv: Double = 0.0,
    dturb: Double = 0.0,
    feedbackSignal: Boolean = false,
    fl1: Double = 0.0,
    fl2: Double = 0.0,
    fl3: Double = 0.0,
    fl4: Double = 0.0,
    fl5: Double = 0.0,
    fp1: Double = 0.0,
    fp10: Double = 0.0,
    fp2: Double = 0.0,
    fp3: Double = 0.0,
    fp4: Double = 0.0,
    fp5: Double = 0.0,
    fp6: Double = 0.0,
    fp7: Double = 0.0,
    fp8: Double = 0.0,
    fp9: Double = 0.0,
    gmax: Double = 0.0,
    gmin: Double = 0.0,
    gtmxcl: Double = 0.0,
    gtmxop: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    kd: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    pmss1: Double = 0.0,
    pmss10: Double = 0.0,
    pmss2: Double = 0.0,
    pmss3: Double = 0.0,
    pmss4: Double = 0.0,
    pmss5: Double = 0.0,
    pmss6: Double = 0.0,
    pmss7: Double = 0.0,
    pmss8: Double = 0.0,
    pmss9: Double = 0.0,
    rpg: Double = 0.0,
    rpp: Double = 0.0,
    td: Double = 0.0,
    tdv: Double = 0.0,
    tg: Double = 0.0,
    tp: Double = 0.0,
    tpe: Double = 0.0,
    tw: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroWEH] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroWEH.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroWEH.fields (position), value)
        emitelem (0, db)
        emitelem (1, dicn)
        emitelem (2, dpv)
        emitelem (3, dturb)
        emitelem (4, feedbackSignal)
        emitelem (5, fl1)
        emitelem (6, fl2)
        emitelem (7, fl3)
        emitelem (8, fl4)
        emitelem (9, fl5)
        emitelem (10, fp1)
        emitelem (11, fp10)
        emitelem (12, fp2)
        emitelem (13, fp3)
        emitelem (14, fp4)
        emitelem (15, fp5)
        emitelem (16, fp6)
        emitelem (17, fp7)
        emitelem (18, fp8)
        emitelem (19, fp9)
        emitelem (20, gmax)
        emitelem (21, gmin)
        emitelem (22, gtmxcl)
        emitelem (23, gtmxop)
        emitelem (24, gv1)
        emitelem (25, gv2)
        emitelem (26, gv3)
        emitelem (27, gv4)
        emitelem (28, gv5)
        emitelem (29, kd)
        emitelem (30, ki)
        emitelem (31, kp)
        emitelem (32, mwbase)
        emitelem (33, pmss1)
        emitelem (34, pmss10)
        emitelem (35, pmss2)
        emitelem (36, pmss3)
        emitelem (37, pmss4)
        emitelem (38, pmss5)
        emitelem (39, pmss6)
        emitelem (40, pmss7)
        emitelem (41, pmss8)
        emitelem (42, pmss9)
        emitelem (43, rpg)
        emitelem (44, rpp)
        emitelem (45, td)
        emitelem (46, tdv)
        emitelem (47, tg)
        emitelem (48, tp)
        emitelem (49, tpe)
        emitelem (50, tw)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroWEH rdf:ID=\"%s\">\n%s\t</cim:GovHydroWEH>".format (id, export_fields)
    }
}

object GovHydroWEH
extends
    Parseable[GovHydroWEH]
{
    override val fields: Array[String] = Array[String] (
        "db",
        "dicn",
        "dpv",
        "dturb",
        "feedbackSignal",
        "fl1",
        "fl2",
        "fl3",
        "fl4",
        "fl5",
        "fp1",
        "fp10",
        "fp2",
        "fp3",
        "fp4",
        "fp5",
        "fp6",
        "fp7",
        "fp8",
        "fp9",
        "gmax",
        "gmin",
        "gtmxcl",
        "gtmxop",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "kd",
        "ki",
        "kp",
        "mwbase",
        "pmss1",
        "pmss10",
        "pmss2",
        "pmss3",
        "pmss4",
        "pmss5",
        "pmss6",
        "pmss7",
        "pmss8",
        "pmss9",
        "rpg",
        "rpp",
        "td",
        "tdv",
        "tg",
        "tp",
        "tpe",
        "tw"
    )
    val db: Fielder = parse_element (element (cls, fields(0)))
    val dicn: Fielder = parse_element (element (cls, fields(1)))
    val dpv: Fielder = parse_element (element (cls, fields(2)))
    val dturb: Fielder = parse_element (element (cls, fields(3)))
    val feedbackSignal: Fielder = parse_element (element (cls, fields(4)))
    val fl1: Fielder = parse_element (element (cls, fields(5)))
    val fl2: Fielder = parse_element (element (cls, fields(6)))
    val fl3: Fielder = parse_element (element (cls, fields(7)))
    val fl4: Fielder = parse_element (element (cls, fields(8)))
    val fl5: Fielder = parse_element (element (cls, fields(9)))
    val fp1: Fielder = parse_element (element (cls, fields(10)))
    val fp10: Fielder = parse_element (element (cls, fields(11)))
    val fp2: Fielder = parse_element (element (cls, fields(12)))
    val fp3: Fielder = parse_element (element (cls, fields(13)))
    val fp4: Fielder = parse_element (element (cls, fields(14)))
    val fp5: Fielder = parse_element (element (cls, fields(15)))
    val fp6: Fielder = parse_element (element (cls, fields(16)))
    val fp7: Fielder = parse_element (element (cls, fields(17)))
    val fp8: Fielder = parse_element (element (cls, fields(18)))
    val fp9: Fielder = parse_element (element (cls, fields(19)))
    val gmax: Fielder = parse_element (element (cls, fields(20)))
    val gmin: Fielder = parse_element (element (cls, fields(21)))
    val gtmxcl: Fielder = parse_element (element (cls, fields(22)))
    val gtmxop: Fielder = parse_element (element (cls, fields(23)))
    val gv1: Fielder = parse_element (element (cls, fields(24)))
    val gv2: Fielder = parse_element (element (cls, fields(25)))
    val gv3: Fielder = parse_element (element (cls, fields(26)))
    val gv4: Fielder = parse_element (element (cls, fields(27)))
    val gv5: Fielder = parse_element (element (cls, fields(28)))
    val kd: Fielder = parse_element (element (cls, fields(29)))
    val ki: Fielder = parse_element (element (cls, fields(30)))
    val kp: Fielder = parse_element (element (cls, fields(31)))
    val mwbase: Fielder = parse_element (element (cls, fields(32)))
    val pmss1: Fielder = parse_element (element (cls, fields(33)))
    val pmss10: Fielder = parse_element (element (cls, fields(34)))
    val pmss2: Fielder = parse_element (element (cls, fields(35)))
    val pmss3: Fielder = parse_element (element (cls, fields(36)))
    val pmss4: Fielder = parse_element (element (cls, fields(37)))
    val pmss5: Fielder = parse_element (element (cls, fields(38)))
    val pmss6: Fielder = parse_element (element (cls, fields(39)))
    val pmss7: Fielder = parse_element (element (cls, fields(40)))
    val pmss8: Fielder = parse_element (element (cls, fields(41)))
    val pmss9: Fielder = parse_element (element (cls, fields(42)))
    val rpg: Fielder = parse_element (element (cls, fields(43)))
    val rpp: Fielder = parse_element (element (cls, fields(44)))
    val td: Fielder = parse_element (element (cls, fields(45)))
    val tdv: Fielder = parse_element (element (cls, fields(46)))
    val tg: Fielder = parse_element (element (cls, fields(47)))
    val tp: Fielder = parse_element (element (cls, fields(48)))
    val tpe: Fielder = parse_element (element (cls, fields(49)))
    val tw: Fielder = parse_element (element (cls, fields(50)))

    def parse (context: Context): GovHydroWEH =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovHydroWEH (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (db (), 0)),
            toDouble (mask (dicn (), 1)),
            toDouble (mask (dpv (), 2)),
            toDouble (mask (dturb (), 3)),
            toBoolean (mask (feedbackSignal (), 4)),
            toDouble (mask (fl1 (), 5)),
            toDouble (mask (fl2 (), 6)),
            toDouble (mask (fl3 (), 7)),
            toDouble (mask (fl4 (), 8)),
            toDouble (mask (fl5 (), 9)),
            toDouble (mask (fp1 (), 10)),
            toDouble (mask (fp10 (), 11)),
            toDouble (mask (fp2 (), 12)),
            toDouble (mask (fp3 (), 13)),
            toDouble (mask (fp4 (), 14)),
            toDouble (mask (fp5 (), 15)),
            toDouble (mask (fp6 (), 16)),
            toDouble (mask (fp7 (), 17)),
            toDouble (mask (fp8 (), 18)),
            toDouble (mask (fp9 (), 19)),
            toDouble (mask (gmax (), 20)),
            toDouble (mask (gmin (), 21)),
            toDouble (mask (gtmxcl (), 22)),
            toDouble (mask (gtmxop (), 23)),
            toDouble (mask (gv1 (), 24)),
            toDouble (mask (gv2 (), 25)),
            toDouble (mask (gv3 (), 26)),
            toDouble (mask (gv4 (), 27)),
            toDouble (mask (gv5 (), 28)),
            toDouble (mask (kd (), 29)),
            toDouble (mask (ki (), 30)),
            toDouble (mask (kp (), 31)),
            toDouble (mask (mwbase (), 32)),
            toDouble (mask (pmss1 (), 33)),
            toDouble (mask (pmss10 (), 34)),
            toDouble (mask (pmss2 (), 35)),
            toDouble (mask (pmss3 (), 36)),
            toDouble (mask (pmss4 (), 37)),
            toDouble (mask (pmss5 (), 38)),
            toDouble (mask (pmss6 (), 39)),
            toDouble (mask (pmss7 (), 40)),
            toDouble (mask (pmss8 (), 41)),
            toDouble (mask (pmss9 (), 42)),
            toDouble (mask (rpg (), 43)),
            toDouble (mask (rpp (), 44)),
            toDouble (mask (td (), 45)),
            toDouble (mask (tdv (), 46)),
            toDouble (mask (tg (), 47)),
            toDouble (mask (tp (), 48)),
            toDouble (mask (tpe (), 49)),
            toDouble (mask (tw (), 50))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Woodward<sup>TM</sup> PID hydro governor.
 * [Footnote: Woodward PID hydro governors are an example of suitable products available commercially.
 *
 * This information is given for the convenience of users of this document and does not constitute an endorsement by IEC of these products.]
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param d Turbine damping factor (<i>D</i>).
 *        Unit = delta P / delta speed.
 * @param gatmax Gate opening limit maximum (<i>Gatmax</i>) (&gt; GovHydroWPID.gatmin).
 * @param gatmin Gate opening limit minimum (<i>Gatmin</i>) (&lt; GovHydroWPID.gatmax).
 * @param gv1 Gate position 1 (<i>Gv1</i>).
 * @param gv2 Gate position 2 (<i>Gv2</i>).
 * @param gv3 Gate position 3 (<i>Gv3</i>) (= 1,0).
 * @param kd Derivative gain (<i>Kd</i>).
 *        Typical value = 1,11.
 * @param ki Reset gain (<i>Ki</i>).
 *        Typical value = 0,36.
 * @param kp Proportional gain (<i>Kp</i>).
 *        Typical value = 0,1.
 * @param mwbase Base for power values  (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Output at <i>Gv1</i> PU of <i>MWbase</i> (<i>Pgv1</i>).
 * @param pgv2 Output at <i>Gv2</i> PU of <i>MWbase</i> (<i>Pgv2</i>).
 * @param pgv3 Output at <i>Gv3</i> PU of <i>MWbase</i> (<i>Pgv3</i>).
 * @param pmax Maximum power output (<i>Pmax</i>) (&gt; GovHydroWPID.pmin).
 * @param pmin Minimum power output (<i>Pmin</i>) (&lt; GovHydroWPID.pmax).
 * @param reg Permanent drop (<i>Reg</i>).
 * @param ta Controller time constant (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tb Gate servo time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param treg Speed detector time constant (<i>Treg</i>) (&gt;= 0).
 * @param tw Water inertia time constant (<i>Tw</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param velmax Maximum gate opening velocity (<i>Velmax</i>) (&gt; GovHydroWPID.velmin).
 *        Unit = PU / s.  Typical value = 0.
 * @param velmin Maximum gate closing velocity (<i>Velmin</i>) (&lt; GovHydroWPID.velmax).
 *        Unit = PU / s.  Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovHydroWPID
(
    override val sup: TurbineGovernorDynamics = null,
    d: Double = 0.0,
    gatmax: Double = 0.0,
    gatmin: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    kd: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    reg: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    treg: Double = 0.0,
    tw: Double = 0.0,
    velmax: Double = 0.0,
    velmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovHydroWPID] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovHydroWPID.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovHydroWPID.fields (position), value)
        emitelem (0, d)
        emitelem (1, gatmax)
        emitelem (2, gatmin)
        emitelem (3, gv1)
        emitelem (4, gv2)
        emitelem (5, gv3)
        emitelem (6, kd)
        emitelem (7, ki)
        emitelem (8, kp)
        emitelem (9, mwbase)
        emitelem (10, pgv1)
        emitelem (11, pgv2)
        emitelem (12, pgv3)
        emitelem (13, pmax)
        emitelem (14, pmin)
        emitelem (15, reg)
        emitelem (16, ta)
        emitelem (17, tb)
        emitelem (18, treg)
        emitelem (19, tw)
        emitelem (20, velmax)
        emitelem (21, velmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovHydroWPID rdf:ID=\"%s\">\n%s\t</cim:GovHydroWPID>".format (id, export_fields)
    }
}

object GovHydroWPID
extends
    Parseable[GovHydroWPID]
{
    override val fields: Array[String] = Array[String] (
        "d",
        "gatmax",
        "gatmin",
        "gv1",
        "gv2",
        "gv3",
        "kd",
        "ki",
        "kp",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pmax",
        "pmin",
        "reg",
        "ta",
        "tb",
        "treg",
        "tw",
        "velmax",
        "velmin"
    )
    val d: Fielder = parse_element (element (cls, fields(0)))
    val gatmax: Fielder = parse_element (element (cls, fields(1)))
    val gatmin: Fielder = parse_element (element (cls, fields(2)))
    val gv1: Fielder = parse_element (element (cls, fields(3)))
    val gv2: Fielder = parse_element (element (cls, fields(4)))
    val gv3: Fielder = parse_element (element (cls, fields(5)))
    val kd: Fielder = parse_element (element (cls, fields(6)))
    val ki: Fielder = parse_element (element (cls, fields(7)))
    val kp: Fielder = parse_element (element (cls, fields(8)))
    val mwbase: Fielder = parse_element (element (cls, fields(9)))
    val pgv1: Fielder = parse_element (element (cls, fields(10)))
    val pgv2: Fielder = parse_element (element (cls, fields(11)))
    val pgv3: Fielder = parse_element (element (cls, fields(12)))
    val pmax: Fielder = parse_element (element (cls, fields(13)))
    val pmin: Fielder = parse_element (element (cls, fields(14)))
    val reg: Fielder = parse_element (element (cls, fields(15)))
    val ta: Fielder = parse_element (element (cls, fields(16)))
    val tb: Fielder = parse_element (element (cls, fields(17)))
    val treg: Fielder = parse_element (element (cls, fields(18)))
    val tw: Fielder = parse_element (element (cls, fields(19)))
    val velmax: Fielder = parse_element (element (cls, fields(20)))
    val velmin: Fielder = parse_element (element (cls, fields(21)))

    def parse (context: Context): GovHydroWPID =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovHydroWPID (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (d (), 0)),
            toDouble (mask (gatmax (), 1)),
            toDouble (mask (gatmin (), 2)),
            toDouble (mask (gv1 (), 3)),
            toDouble (mask (gv2 (), 4)),
            toDouble (mask (gv3 (), 5)),
            toDouble (mask (kd (), 6)),
            toDouble (mask (ki (), 7)),
            toDouble (mask (kp (), 8)),
            toDouble (mask (mwbase (), 9)),
            toDouble (mask (pgv1 (), 10)),
            toDouble (mask (pgv2 (), 11)),
            toDouble (mask (pgv3 (), 12)),
            toDouble (mask (pmax (), 13)),
            toDouble (mask (pmin (), 14)),
            toDouble (mask (reg (), 15)),
            toDouble (mask (ta (), 16)),
            toDouble (mask (tb (), 17)),
            toDouble (mask (treg (), 18)),
            toDouble (mask (tw (), 19)),
            toDouble (mask (velmax (), 20)),
            toDouble (mask (velmin (), 21))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A simplified steam turbine governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param dt Turbine damping coefficient (<i>Dt</i>).
 *        Unit = delta P / delta speed. Typical value = 0.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param r Permanent droop (<i>R</i>).
 *        Typical value = 0,05.
 * @param t1 Steam bowl time constant (<i>T1</i>) (&gt; 0).
 *        Typical value = 0,5.
 * @param t2 Numerator time constant of <i>T2</i>/<i>T3</i> block (<i>T2</i>) (&gt;= 0).
 *        Typical value = 3.
 * @param t3 Reheater time constant (<i>T3</i>) (&gt; 0).
 *        Typical value = 10.
 * @param vmax Maximum valve position, PU of <i>mwcap</i> (<i>Vmax</i>) (&gt; GovSteam0.vmin).
 *        Typical value = 1.
 * @param vmin Minimum valve position, PU of <i>mwcap</i> (<i>Vmin</i>) (&lt; GovSteam0.vmax).
 *        Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteam0
(
    override val sup: TurbineGovernorDynamics = null,
    dt: Double = 0.0,
    mwbase: Double = 0.0,
    r: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteam0] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteam0.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteam0.fields (position), value)
        emitelem (0, dt)
        emitelem (1, mwbase)
        emitelem (2, r)
        emitelem (3, t1)
        emitelem (4, t2)
        emitelem (5, t3)
        emitelem (6, vmax)
        emitelem (7, vmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteam0 rdf:ID=\"%s\">\n%s\t</cim:GovSteam0>".format (id, export_fields)
    }
}

object GovSteam0
extends
    Parseable[GovSteam0]
{
    override val fields: Array[String] = Array[String] (
        "dt",
        "mwbase",
        "r",
        "t1",
        "t2",
        "t3",
        "vmax",
        "vmin"
    )
    val dt: Fielder = parse_element (element (cls, fields(0)))
    val mwbase: Fielder = parse_element (element (cls, fields(1)))
    val r: Fielder = parse_element (element (cls, fields(2)))
    val t1: Fielder = parse_element (element (cls, fields(3)))
    val t2: Fielder = parse_element (element (cls, fields(4)))
    val t3: Fielder = parse_element (element (cls, fields(5)))
    val vmax: Fielder = parse_element (element (cls, fields(6)))
    val vmin: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): GovSteam0 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteam0 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (dt (), 0)),
            toDouble (mask (mwbase (), 1)),
            toDouble (mask (r (), 2)),
            toDouble (mask (t1 (), 3)),
            toDouble (mask (t2 (), 4)),
            toDouble (mask (t3 (), 5)),
            toDouble (mask (vmax (), 6)),
            toDouble (mask (vmin (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Steam turbine governor, based on the GovSteamIEEE1 (with optional deadband and nonlinear valve gain added).
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param db1 Intentional deadband width (<i>db1</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param db2 Unintentional deadband (<i>db2</i>).
 *        Unit = MW.  Typical value = 0.
 * @param eps Intentional db hysteresis (<i>eps</i>).
 *        Unit = Hz.  Typical value = 0.
 * @param gv1 Nonlinear gain valve position point 1 (<i>GV1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain valve position point 2 (<i>GV2</i>).
 *        Typical value = 0,4.
 * @param gv3 Nonlinear gain valve position point 3 (<i>GV3</i>).
 *        Typical value = 0,5.
 * @param gv4 Nonlinear gain valve position point 4 (<i>GV4</i>).
 *        Typical value = 0,6.
 * @param gv5 Nonlinear gain valve position point 5 (<i>GV5</i>).
 *        Typical value = 1.
 * @param gv6 Nonlinear gain valve position point 6 (<i>GV6</i>).
 *        Typical value = 0.
 * @param k Governor gain (reciprocal of droop) (<i>K</i>) (&gt; 0).
 *        Typical value = 25.
 * @param k1 Fraction of HP shaft power after first boiler pass (<i>K1</i>).
 *        Typical value = 0,2.
 * @param k2 Fraction of LP shaft power after first boiler pass (<i>K2</i>).
 *        Typical value = 0.
 * @param k3 Fraction of HP shaft power after second boiler pass (<i>K3</i>).
 *        Typical value = 0,3.
 * @param k4 Fraction of LP shaft power after second boiler pass (<i>K4</i>).
 *        Typical value = 0.
 * @param k5 Fraction of HP shaft power after third boiler pass (<i>K5</i>).
 *        Typical value = 0,5.
 * @param k6 Fraction of LP shaft power after third boiler pass (<i>K6</i>).
 *        Typical value = 0.
 * @param k7 Fraction of HP shaft power after fourth boiler pass (<i>K7</i>).
 *        Typical value = 0.
 * @param k8 Fraction of LP shaft power after fourth boiler pass (<i>K8</i>).
 *        Typical value = 0.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain power value point 1 (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain power value point 2 (<i>Pgv2</i>).
 *        Typical value = 0,75.
 * @param pgv3 Nonlinear gain power value point 3 (<i>Pgv3</i>).
 *        Typical value = 0,91.
 * @param pgv4 Nonlinear gain power value point 4 (<i>Pgv4</i>).
 *        Typical value = 0,98.
 * @param pgv5 Nonlinear gain power value point 5 (<i>Pgv5</i>).
 *        Typical value = 1.
 * @param pgv6 Nonlinear gain power value point 6 (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum valve opening (<i>Pmax</i>) (&gt; GovSteam1.pmin).
 *        Typical value = 1.
 * @param pmin Minimum valve opening (<i>Pmin</i>) (&gt;= 0 and &lt; GovSteam1.pmax).
 *        Typical value = 0.
 * @param sdb1 Intentional deadband indicator.
 *        true = intentional deadband is applied
 *        false = intentional deadband is not applied.
 *        Typical value = true.
 * @param sdb2 Unintentional deadband location.
 *        true = intentional deadband is applied before point "A"
 *        false = intentional deadband is applied after point "A".
 *        Typical value = true.
 * @param t1 Governor lag time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t2 Governor lead time constant (<i>T2</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t3 Valve positioner time constant (<i>T3) </i>(&gt; 0).
 *        Typical value = 0,1.
 * @param t4 Inlet piping/steam bowl time constant (<i>T4</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param t5 Time constant of second boiler pass (<i>T5</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param t6 Time constant of third boiler pass (<i>T6</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param t7 Time constant of fourth boiler pass (<i>T7</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param uc Maximum valve closing velocity (<i>Uc</i>) (&lt; 0).
 *        Unit = PU / s.  Typical value = -10.
 * @param uo Maximum valve opening velocity (<i>Uo</i>) (&gt; 0).
 *        Unit = PU / s.  Typical value = 1.
 * @param valve Nonlinear valve characteristic.
 *        true = nonlinear valve characteristic is used
 *        false = nonlinear valve characteristic is not used.
 *        Typical value = true.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteam1
(
    override val sup: TurbineGovernorDynamics = null,
    db1: Double = 0.0,
    db2: Double = 0.0,
    eps: Double = 0.0,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    k: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    k5: Double = 0.0,
    k6: Double = 0.0,
    k7: Double = 0.0,
    k8: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    sdb1: Boolean = false,
    sdb2: Boolean = false,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0,
    valve: Boolean = false
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteam1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteam1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteam1.fields (position), value)
        emitelem (0, db1)
        emitelem (1, db2)
        emitelem (2, eps)
        emitelem (3, gv1)
        emitelem (4, gv2)
        emitelem (5, gv3)
        emitelem (6, gv4)
        emitelem (7, gv5)
        emitelem (8, gv6)
        emitelem (9, k)
        emitelem (10, k1)
        emitelem (11, k2)
        emitelem (12, k3)
        emitelem (13, k4)
        emitelem (14, k5)
        emitelem (15, k6)
        emitelem (16, k7)
        emitelem (17, k8)
        emitelem (18, mwbase)
        emitelem (19, pgv1)
        emitelem (20, pgv2)
        emitelem (21, pgv3)
        emitelem (22, pgv4)
        emitelem (23, pgv5)
        emitelem (24, pgv6)
        emitelem (25, pmax)
        emitelem (26, pmin)
        emitelem (27, sdb1)
        emitelem (28, sdb2)
        emitelem (29, t1)
        emitelem (30, t2)
        emitelem (31, t3)
        emitelem (32, t4)
        emitelem (33, t5)
        emitelem (34, t6)
        emitelem (35, t7)
        emitelem (36, uc)
        emitelem (37, uo)
        emitelem (38, valve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteam1 rdf:ID=\"%s\">\n%s\t</cim:GovSteam1>".format (id, export_fields)
    }
}

object GovSteam1
extends
    Parseable[GovSteam1]
{
    override val fields: Array[String] = Array[String] (
        "db1",
        "db2",
        "eps",
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "k",
        "k1",
        "k2",
        "k3",
        "k4",
        "k5",
        "k6",
        "k7",
        "k8",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "sdb1",
        "sdb2",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "t7",
        "uc",
        "uo",
        "valve"
    )
    val db1: Fielder = parse_element (element (cls, fields(0)))
    val db2: Fielder = parse_element (element (cls, fields(1)))
    val eps: Fielder = parse_element (element (cls, fields(2)))
    val gv1: Fielder = parse_element (element (cls, fields(3)))
    val gv2: Fielder = parse_element (element (cls, fields(4)))
    val gv3: Fielder = parse_element (element (cls, fields(5)))
    val gv4: Fielder = parse_element (element (cls, fields(6)))
    val gv5: Fielder = parse_element (element (cls, fields(7)))
    val gv6: Fielder = parse_element (element (cls, fields(8)))
    val k: Fielder = parse_element (element (cls, fields(9)))
    val k1: Fielder = parse_element (element (cls, fields(10)))
    val k2: Fielder = parse_element (element (cls, fields(11)))
    val k3: Fielder = parse_element (element (cls, fields(12)))
    val k4: Fielder = parse_element (element (cls, fields(13)))
    val k5: Fielder = parse_element (element (cls, fields(14)))
    val k6: Fielder = parse_element (element (cls, fields(15)))
    val k7: Fielder = parse_element (element (cls, fields(16)))
    val k8: Fielder = parse_element (element (cls, fields(17)))
    val mwbase: Fielder = parse_element (element (cls, fields(18)))
    val pgv1: Fielder = parse_element (element (cls, fields(19)))
    val pgv2: Fielder = parse_element (element (cls, fields(20)))
    val pgv3: Fielder = parse_element (element (cls, fields(21)))
    val pgv4: Fielder = parse_element (element (cls, fields(22)))
    val pgv5: Fielder = parse_element (element (cls, fields(23)))
    val pgv6: Fielder = parse_element (element (cls, fields(24)))
    val pmax: Fielder = parse_element (element (cls, fields(25)))
    val pmin: Fielder = parse_element (element (cls, fields(26)))
    val sdb1: Fielder = parse_element (element (cls, fields(27)))
    val sdb2: Fielder = parse_element (element (cls, fields(28)))
    val t1: Fielder = parse_element (element (cls, fields(29)))
    val t2: Fielder = parse_element (element (cls, fields(30)))
    val t3: Fielder = parse_element (element (cls, fields(31)))
    val t4: Fielder = parse_element (element (cls, fields(32)))
    val t5: Fielder = parse_element (element (cls, fields(33)))
    val t6: Fielder = parse_element (element (cls, fields(34)))
    val t7: Fielder = parse_element (element (cls, fields(35)))
    val uc: Fielder = parse_element (element (cls, fields(36)))
    val uo: Fielder = parse_element (element (cls, fields(37)))
    val valve: Fielder = parse_element (element (cls, fields(38)))

    def parse (context: Context): GovSteam1 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovSteam1 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (db1 (), 0)),
            toDouble (mask (db2 (), 1)),
            toDouble (mask (eps (), 2)),
            toDouble (mask (gv1 (), 3)),
            toDouble (mask (gv2 (), 4)),
            toDouble (mask (gv3 (), 5)),
            toDouble (mask (gv4 (), 6)),
            toDouble (mask (gv5 (), 7)),
            toDouble (mask (gv6 (), 8)),
            toDouble (mask (k (), 9)),
            toDouble (mask (k1 (), 10)),
            toDouble (mask (k2 (), 11)),
            toDouble (mask (k3 (), 12)),
            toDouble (mask (k4 (), 13)),
            toDouble (mask (k5 (), 14)),
            toDouble (mask (k6 (), 15)),
            toDouble (mask (k7 (), 16)),
            toDouble (mask (k8 (), 17)),
            toDouble (mask (mwbase (), 18)),
            toDouble (mask (pgv1 (), 19)),
            toDouble (mask (pgv2 (), 20)),
            toDouble (mask (pgv3 (), 21)),
            toDouble (mask (pgv4 (), 22)),
            toDouble (mask (pgv5 (), 23)),
            toDouble (mask (pgv6 (), 24)),
            toDouble (mask (pmax (), 25)),
            toDouble (mask (pmin (), 26)),
            toBoolean (mask (sdb1 (), 27)),
            toBoolean (mask (sdb2 (), 28)),
            toDouble (mask (t1 (), 29)),
            toDouble (mask (t2 (), 30)),
            toDouble (mask (t3 (), 31)),
            toDouble (mask (t4 (), 32)),
            toDouble (mask (t5 (), 33)),
            toDouble (mask (t6 (), 34)),
            toDouble (mask (t7 (), 35)),
            toDouble (mask (uc (), 36)),
            toDouble (mask (uo (), 37)),
            toBoolean (mask (valve (), 38))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param dbf Frequency deadband (<i>DBF</i>).
 *        Typical value = 0.
 * @param k Governor gain (reciprocal of droop) (<i>K</i>).
 *        Typical value = 20.
 * @param mnef Fuel flow maximum negative error value (<i>MN</i><i><sub>EF</sub></i>).
 *        Typical value = -1.
 * @param mxef Fuel flow maximum positive error value (<i>MX</i><i><sub>EF</sub></i>).
 *        Typical value = 1.
 * @param pmax Maximum fuel flow (<i>P</i><i><sub>MAX</sub></i>) (&gt; GovSteam2.pmin).
 *        Typical value = 1.
 * @param pmin Minimum fuel flow (<i>P</i><i><sub>MIN</sub></i>) (&lt; GovSteam2.pmax).
 *        Typical value = 0.
 * @param t1 Governor lag time constant (<i>T</i><i><sub>1</sub></i>) (&gt; 0).
 *        Typical value = 0,45.
 * @param t2 Governor lead time constant (<i>T</i><i><sub>2</sub></i>) (&gt;= 0).
 *        Typical value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteam2
(
    override val sup: TurbineGovernorDynamics = null,
    dbf: Double = 0.0,
    k: Double = 0.0,
    mnef: Double = 0.0,
    mxef: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteam2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteam2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteam2.fields (position), value)
        emitelem (0, dbf)
        emitelem (1, k)
        emitelem (2, mnef)
        emitelem (3, mxef)
        emitelem (4, pmax)
        emitelem (5, pmin)
        emitelem (6, t1)
        emitelem (7, t2)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteam2 rdf:ID=\"%s\">\n%s\t</cim:GovSteam2>".format (id, export_fields)
    }
}

object GovSteam2
extends
    Parseable[GovSteam2]
{
    override val fields: Array[String] = Array[String] (
        "dbf",
        "k",
        "mnef",
        "mxef",
        "pmax",
        "pmin",
        "t1",
        "t2"
    )
    val dbf: Fielder = parse_element (element (cls, fields(0)))
    val k: Fielder = parse_element (element (cls, fields(1)))
    val mnef: Fielder = parse_element (element (cls, fields(2)))
    val mxef: Fielder = parse_element (element (cls, fields(3)))
    val pmax: Fielder = parse_element (element (cls, fields(4)))
    val pmin: Fielder = parse_element (element (cls, fields(5)))
    val t1: Fielder = parse_element (element (cls, fields(6)))
    val t2: Fielder = parse_element (element (cls, fields(7)))

    def parse (context: Context): GovSteam2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteam2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (dbf (), 0)),
            toDouble (mask (k (), 1)),
            toDouble (mask (mnef (), 2)),
            toDouble (mask (mxef (), 3)),
            toDouble (mask (pmax (), 4)),
            toDouble (mask (pmin (), 5)),
            toDouble (mask (t1 (), 6)),
            toDouble (mask (t2 (), 7))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * European governor model.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param fcut Frequency deadband (<i>f</i><i><sub>cut</sub></i>) (&gt;= 0).
 *        Typical value = 0,002.
 * @param k2 Gain (<i>K2</i>).
 *        Typical value = 0,75.
 * @param k3 Gain (<i>K3</i>).
 *        Typical value = 0,5.
 * @param kd Gain (<i>Kd</i>).
 *        Typical value = 1,0.
 * @param kg Gain (<i>Kg</i>).
 *        Typical value = 1,0.
 * @param kls Gain (<i>Kls</i>) (&gt; 0).
 *        Typical value = 0,1.
 * @param kp Gain (<i>Kp</i>).
 *        Typical value = 1,0.
 * @param ks Gain (<i>Ks</i>).
 *        Typical value = 21,0.
 * @param peflag Electric power input selection (Peflag).
 *        true = electric power input
 *        false = feedback signal.
 *        Typical value = false.
 * @param pmax High power limit (<i>Pmax</i>) (&gt; GovSteamBB.pmin).
 *        Typical value = 1,0.
 * @param pmin Low power limit (<i>Pmin</i>) (&lt; GovSteamBB.pmax).
 *        Typical value = 0.
 * @param t1 Time constant (<i>T1</i>).
 *        Typical value = 0,05.
 * @param t4 Time constant (<i>T4</i>).
 *        Typical value = 0,15.
 * @param t5 Time constant (<i>T5</i>).
 *        Typical value = 12,0.
 * @param t6 Time constant (<i>T6</i>).
 *        Typical value = 0,75.
 * @param td Time constant (<i>Td</i>) (&gt; 0).
 *        Typical value = 1,0.
 * @param tn Time constant (<i>Tn</i>) (&gt; 0).
 *        Typical value = 1,0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamBB
(
    override val sup: TurbineGovernorDynamics = null,
    fcut: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    kd: Double = 0.0,
    kg: Double = 0.0,
    kls: Double = 0.0,
    kp: Double = 0.0,
    ks: Double = 0.0,
    peflag: Boolean = false,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    td: Double = 0.0,
    tn: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamBB] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamBB.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamBB.fields (position), value)
        emitelem (0, fcut)
        emitelem (1, k2)
        emitelem (2, k3)
        emitelem (3, kd)
        emitelem (4, kg)
        emitelem (5, kls)
        emitelem (6, kp)
        emitelem (7, ks)
        emitelem (8, peflag)
        emitelem (9, pmax)
        emitelem (10, pmin)
        emitelem (11, t1)
        emitelem (12, t4)
        emitelem (13, t5)
        emitelem (14, t6)
        emitelem (15, td)
        emitelem (16, tn)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamBB rdf:ID=\"%s\">\n%s\t</cim:GovSteamBB>".format (id, export_fields)
    }
}

object GovSteamBB
extends
    Parseable[GovSteamBB]
{
    override val fields: Array[String] = Array[String] (
        "fcut",
        "k2",
        "k3",
        "kd",
        "kg",
        "kls",
        "kp",
        "ks",
        "peflag",
        "pmax",
        "pmin",
        "t1",
        "t4",
        "t5",
        "t6",
        "td",
        "tn"
    )
    val fcut: Fielder = parse_element (element (cls, fields(0)))
    val k2: Fielder = parse_element (element (cls, fields(1)))
    val k3: Fielder = parse_element (element (cls, fields(2)))
    val kd: Fielder = parse_element (element (cls, fields(3)))
    val kg: Fielder = parse_element (element (cls, fields(4)))
    val kls: Fielder = parse_element (element (cls, fields(5)))
    val kp: Fielder = parse_element (element (cls, fields(6)))
    val ks: Fielder = parse_element (element (cls, fields(7)))
    val peflag: Fielder = parse_element (element (cls, fields(8)))
    val pmax: Fielder = parse_element (element (cls, fields(9)))
    val pmin: Fielder = parse_element (element (cls, fields(10)))
    val t1: Fielder = parse_element (element (cls, fields(11)))
    val t4: Fielder = parse_element (element (cls, fields(12)))
    val t5: Fielder = parse_element (element (cls, fields(13)))
    val t6: Fielder = parse_element (element (cls, fields(14)))
    val td: Fielder = parse_element (element (cls, fields(15)))
    val tn: Fielder = parse_element (element (cls, fields(16)))

    def parse (context: Context): GovSteamBB =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamBB (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (fcut (), 0)),
            toDouble (mask (k2 (), 1)),
            toDouble (mask (k3 (), 2)),
            toDouble (mask (kd (), 3)),
            toDouble (mask (kg (), 4)),
            toDouble (mask (kls (), 5)),
            toDouble (mask (kp (), 6)),
            toDouble (mask (ks (), 7)),
            toBoolean (mask (peflag (), 8)),
            toDouble (mask (pmax (), 9)),
            toDouble (mask (pmin (), 10)),
            toDouble (mask (t1 (), 11)),
            toDouble (mask (t4 (), 12)),
            toDouble (mask (t5 (), 13)),
            toDouble (mask (t6 (), 14)),
            toDouble (mask (td (), 15)),
            toDouble (mask (tn (), 16))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Cross compound turbine governor.
 *
 * Unlike tandem compound units, cross compound units are not on the same shaft.
 *
 * @param sup [[ch.ninecode.model.CrossCompoundTurbineGovernorDynamics CrossCompoundTurbineGovernorDynamics]] Reference to the superclass object.
 * @param dhp HP damping factor (<i>Dhp</i>).
 *        Typical value = 0.
 * @param dlp LP damping factor (<i>Dlp</i>).
 *        Typical value = 0.
 * @param fhp Fraction of HP power ahead of reheater (<i>Fhp</i>).
 *        Typical value = 0,3.
 * @param flp Fraction of LP power ahead of reheater (<i>Flp</i>).
 *        Typical value = 0,7.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pmaxhp Maximum HP value position (<i>Pmaxhp</i>).
 *        Typical value = 1.
 * @param pmaxlp Maximum LP value position (<i>Pmaxlp</i>).
 *        Typical value = 1.
 * @param rhp HP governor droop (<i>Rhp</i>) (&gt; 0).
 *        Typical value = 0,05.
 * @param rlp LP governor droop (<i>Rlp</i>) (&gt; 0).
 *        Typical value = 0,05.
 * @param t1hp HP governor time constant (<i>T1hp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t1lp LP governor time constant (<i>T1lp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t3hp HP turbine time constant (<i>T3hp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t3lp LP turbine time constant (<i>T3lp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t4hp HP turbine time constant (<i>T4hp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t4lp LP turbine time constant (<i>T4lp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param t5hp HP reheater time constant (<i>T5hp</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param t5lp LP reheater time constant (<i>T5lp</i>) (&gt;= 0).
 *        Typical value = 10.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamCC
(
    override val sup: CrossCompoundTurbineGovernorDynamics = null,
    dhp: Double = 0.0,
    dlp: Double = 0.0,
    fhp: Double = 0.0,
    flp: Double = 0.0,
    mwbase: Double = 0.0,
    pmaxhp: Double = 0.0,
    pmaxlp: Double = 0.0,
    rhp: Double = 0.0,
    rlp: Double = 0.0,
    t1hp: Double = 0.0,
    t1lp: Double = 0.0,
    t3hp: Double = 0.0,
    t3lp: Double = 0.0,
    t4hp: Double = 0.0,
    t4lp: Double = 0.0,
    t5hp: Double = 0.0,
    t5lp: Double = 0.0
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
    def CrossCompoundTurbineGovernorDynamics: CrossCompoundTurbineGovernorDynamics = sup.asInstanceOf[CrossCompoundTurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamCC] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamCC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamCC.fields (position), value)
        emitelem (0, dhp)
        emitelem (1, dlp)
        emitelem (2, fhp)
        emitelem (3, flp)
        emitelem (4, mwbase)
        emitelem (5, pmaxhp)
        emitelem (6, pmaxlp)
        emitelem (7, rhp)
        emitelem (8, rlp)
        emitelem (9, t1hp)
        emitelem (10, t1lp)
        emitelem (11, t3hp)
        emitelem (12, t3lp)
        emitelem (13, t4hp)
        emitelem (14, t4lp)
        emitelem (15, t5hp)
        emitelem (16, t5lp)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamCC rdf:ID=\"%s\">\n%s\t</cim:GovSteamCC>".format (id, export_fields)
    }
}

object GovSteamCC
extends
    Parseable[GovSteamCC]
{
    override val fields: Array[String] = Array[String] (
        "dhp",
        "dlp",
        "fhp",
        "flp",
        "mwbase",
        "pmaxhp",
        "pmaxlp",
        "rhp",
        "rlp",
        "t1hp",
        "t1lp",
        "t3hp",
        "t3lp",
        "t4hp",
        "t4lp",
        "t5hp",
        "t5lp"
    )
    val dhp: Fielder = parse_element (element (cls, fields(0)))
    val dlp: Fielder = parse_element (element (cls, fields(1)))
    val fhp: Fielder = parse_element (element (cls, fields(2)))
    val flp: Fielder = parse_element (element (cls, fields(3)))
    val mwbase: Fielder = parse_element (element (cls, fields(4)))
    val pmaxhp: Fielder = parse_element (element (cls, fields(5)))
    val pmaxlp: Fielder = parse_element (element (cls, fields(6)))
    val rhp: Fielder = parse_element (element (cls, fields(7)))
    val rlp: Fielder = parse_element (element (cls, fields(8)))
    val t1hp: Fielder = parse_element (element (cls, fields(9)))
    val t1lp: Fielder = parse_element (element (cls, fields(10)))
    val t3hp: Fielder = parse_element (element (cls, fields(11)))
    val t3lp: Fielder = parse_element (element (cls, fields(12)))
    val t4hp: Fielder = parse_element (element (cls, fields(13)))
    val t4lp: Fielder = parse_element (element (cls, fields(14)))
    val t5hp: Fielder = parse_element (element (cls, fields(15)))
    val t5lp: Fielder = parse_element (element (cls, fields(16)))

    def parse (context: Context): GovSteamCC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamCC (
            CrossCompoundTurbineGovernorDynamics.parse (context),
            toDouble (mask (dhp (), 0)),
            toDouble (mask (dlp (), 1)),
            toDouble (mask (fhp (), 2)),
            toDouble (mask (flp (), 3)),
            toDouble (mask (mwbase (), 4)),
            toDouble (mask (pmaxhp (), 5)),
            toDouble (mask (pmaxlp (), 6)),
            toDouble (mask (rhp (), 7)),
            toDouble (mask (rlp (), 8)),
            toDouble (mask (t1hp (), 9)),
            toDouble (mask (t1lp (), 10)),
            toDouble (mask (t3hp (), 11)),
            toDouble (mask (t3lp (), 12)),
            toDouble (mask (t4hp (), 13)),
            toDouble (mask (t4lp (), 14)),
            toDouble (mask (t5hp (), 15)),
            toDouble (mask (t5lp (), 16))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified boiler and steam turbine with PID governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param chc Control valves rate closing limit (<i>Chc</i>).
 *        Unit = PU / s.  Typical value = -3,3.
 * @param cho Control valves rate opening limit (<i>Cho</i>).
 *        Unit = PU / s.  Typical value = 0,17.
 * @param cic Intercept valves rate closing limit (<i>Cic</i>).
 *        Typical value = -2,2.
 * @param cio Intercept valves rate opening limit (<i>Cio</i>).
 *        Typical value = 0,123.
 * @param db1 Deadband of the frequency corrector (<i>db1</i>).
 *        Typical value = 0.
 * @param db2 Deadband of the speed governor (<i>db2</i>).
 *        Typical value = 0,0004.
 * @param hhpmax Maximum control valve position (<i>Hhpmax</i>).
 *        Typical value = 1.
 * @param ke Gain of the power controller (<i>Ke</i>).
 *        Typical value = 0,65.
 * @param kfcor Gain of the frequency corrector (<i>Kfcor</i>).
 *        Typical value = 20.
 * @param khp Fraction of total turbine output generated by HP part (<i>Khp</i>).
 *        Typical value = 0,277.
 * @param klp Fraction of total turbine output generated by HP part (<i>Klp</i>).
 *        Typical value = 0,723.
 * @param komegacor Gain of the speed governor (<i>Kwcor</i>).
 *        Typical value = 20.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pmax Maximal active power of the turbine (<i>Pmax</i>).
 *        Typical value = 1.
 * @param prhmax Maximum low pressure limit (<i>Prhmax</i>).
 *        Typical value = 1,4.
 * @param simx Intercept valves transfer limit (<i>Simx</i>).
 *        Typical value = 0,425.
 * @param tb Boiler time constant (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 100.
 * @param tdp Derivative time constant of the power controller (<i>Tdp</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param ten Electro hydraulic transducer (<i>Ten</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tf Frequency transducer time constant (<i>Tf</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param tfp Time constant of the power controller (<i>Tfp</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param thp High pressure (HP) time constant of the turbine (<i>Thp</i>) (&gt;= 0).
 *        Typical value = 0,31.
 * @param tip Integral time constant of the power controller (<i>Tip</i>) (&gt;= 0).
 *        Typical value = 2.
 * @param tlp Low pressure (LP) time constant of the turbine (<i>Tlp</i>) (&gt;= 0).
 *        Typical value = 0,45.
 * @param tp Power transducer time constant (<i>Tp</i>) (&gt;= 0).
 *        Typical value = 0,07.
 * @param trh Reheater  time constant of the turbine (<i>Trh</i>) (&gt;= 0).
 *        Typical value = 8.
 * @param tvhp Control valves servo time constant (<i>Tvhp</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param tvip Intercept valves servo time constant (<i>Tvip</i>) (&gt;= 0).
 *        Typical value = 0,15.
 * @param tw Speed transducer time constant (<i>Tw</i>) (&gt;= 0).
 *        Typical value = 0,02.
 * @param wfmax Upper limit for frequency correction (<i>Wfmax</i>) (&gt; GovSteamEU.wfmin).
 *        Typical value = 0,05.
 * @param wfmin Lower limit for frequency correction (<i>Wfmin</i>) (&lt; GovSteamEU.wfmax).
 *        Typical value = -0,05.
 * @param wmax1 Emergency speed control lower limit (<i>wmax1</i>).
 *        Typical value = 1,025.
 * @param wmax2 Emergency speed control upper limit (<i>wmax2</i>).
 *        Typical value = 1,05.
 * @param wwmax Upper limit for the speed governor (<i>Wwmax</i>) (&gt; GovSteamEU.wwmin).
 *        Typical value = 0,1.
 * @param wwmin Lower limit for the speed governor frequency correction (<i>Wwmin</i>) (&lt; GovSteamEU.wwmax).
 *        Typical value = -1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamEU
(
    override val sup: TurbineGovernorDynamics = null,
    chc: Double = 0.0,
    cho: Double = 0.0,
    cic: Double = 0.0,
    cio: Double = 0.0,
    db1: Double = 0.0,
    db2: Double = 0.0,
    hhpmax: Double = 0.0,
    ke: Double = 0.0,
    kfcor: Double = 0.0,
    khp: Double = 0.0,
    klp: Double = 0.0,
    komegacor: Double = 0.0,
    mwbase: Double = 0.0,
    pmax: Double = 0.0,
    prhmax: Double = 0.0,
    simx: Double = 0.0,
    tb: Double = 0.0,
    tdp: Double = 0.0,
    ten: Double = 0.0,
    tf: Double = 0.0,
    tfp: Double = 0.0,
    thp: Double = 0.0,
    tip: Double = 0.0,
    tlp: Double = 0.0,
    tp: Double = 0.0,
    trh: Double = 0.0,
    tvhp: Double = 0.0,
    tvip: Double = 0.0,
    tw: Double = 0.0,
    wfmax: Double = 0.0,
    wfmin: Double = 0.0,
    wmax1: Double = 0.0,
    wmax2: Double = 0.0,
    wwmax: Double = 0.0,
    wwmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamEU] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamEU.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamEU.fields (position), value)
        emitelem (0, chc)
        emitelem (1, cho)
        emitelem (2, cic)
        emitelem (3, cio)
        emitelem (4, db1)
        emitelem (5, db2)
        emitelem (6, hhpmax)
        emitelem (7, ke)
        emitelem (8, kfcor)
        emitelem (9, khp)
        emitelem (10, klp)
        emitelem (11, komegacor)
        emitelem (12, mwbase)
        emitelem (13, pmax)
        emitelem (14, prhmax)
        emitelem (15, simx)
        emitelem (16, tb)
        emitelem (17, tdp)
        emitelem (18, ten)
        emitelem (19, tf)
        emitelem (20, tfp)
        emitelem (21, thp)
        emitelem (22, tip)
        emitelem (23, tlp)
        emitelem (24, tp)
        emitelem (25, trh)
        emitelem (26, tvhp)
        emitelem (27, tvip)
        emitelem (28, tw)
        emitelem (29, wfmax)
        emitelem (30, wfmin)
        emitelem (31, wmax1)
        emitelem (32, wmax2)
        emitelem (33, wwmax)
        emitelem (34, wwmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamEU rdf:ID=\"%s\">\n%s\t</cim:GovSteamEU>".format (id, export_fields)
    }
}

object GovSteamEU
extends
    Parseable[GovSteamEU]
{
    override val fields: Array[String] = Array[String] (
        "chc",
        "cho",
        "cic",
        "cio",
        "db1",
        "db2",
        "hhpmax",
        "ke",
        "kfcor",
        "khp",
        "klp",
        "komegacor",
        "mwbase",
        "pmax",
        "prhmax",
        "simx",
        "tb",
        "tdp",
        "ten",
        "tf",
        "tfp",
        "thp",
        "tip",
        "tlp",
        "tp",
        "trh",
        "tvhp",
        "tvip",
        "tw",
        "wfmax",
        "wfmin",
        "wmax1",
        "wmax2",
        "wwmax",
        "wwmin"
    )
    val chc: Fielder = parse_element (element (cls, fields(0)))
    val cho: Fielder = parse_element (element (cls, fields(1)))
    val cic: Fielder = parse_element (element (cls, fields(2)))
    val cio: Fielder = parse_element (element (cls, fields(3)))
    val db1: Fielder = parse_element (element (cls, fields(4)))
    val db2: Fielder = parse_element (element (cls, fields(5)))
    val hhpmax: Fielder = parse_element (element (cls, fields(6)))
    val ke: Fielder = parse_element (element (cls, fields(7)))
    val kfcor: Fielder = parse_element (element (cls, fields(8)))
    val khp: Fielder = parse_element (element (cls, fields(9)))
    val klp: Fielder = parse_element (element (cls, fields(10)))
    val komegacor: Fielder = parse_element (element (cls, fields(11)))
    val mwbase: Fielder = parse_element (element (cls, fields(12)))
    val pmax: Fielder = parse_element (element (cls, fields(13)))
    val prhmax: Fielder = parse_element (element (cls, fields(14)))
    val simx: Fielder = parse_element (element (cls, fields(15)))
    val tb: Fielder = parse_element (element (cls, fields(16)))
    val tdp: Fielder = parse_element (element (cls, fields(17)))
    val ten: Fielder = parse_element (element (cls, fields(18)))
    val tf: Fielder = parse_element (element (cls, fields(19)))
    val tfp: Fielder = parse_element (element (cls, fields(20)))
    val thp: Fielder = parse_element (element (cls, fields(21)))
    val tip: Fielder = parse_element (element (cls, fields(22)))
    val tlp: Fielder = parse_element (element (cls, fields(23)))
    val tp: Fielder = parse_element (element (cls, fields(24)))
    val trh: Fielder = parse_element (element (cls, fields(25)))
    val tvhp: Fielder = parse_element (element (cls, fields(26)))
    val tvip: Fielder = parse_element (element (cls, fields(27)))
    val tw: Fielder = parse_element (element (cls, fields(28)))
    val wfmax: Fielder = parse_element (element (cls, fields(29)))
    val wfmin: Fielder = parse_element (element (cls, fields(30)))
    val wmax1: Fielder = parse_element (element (cls, fields(31)))
    val wmax2: Fielder = parse_element (element (cls, fields(32)))
    val wwmax: Fielder = parse_element (element (cls, fields(33)))
    val wwmin: Fielder = parse_element (element (cls, fields(34)))

    def parse (context: Context): GovSteamEU =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovSteamEU (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (chc (), 0)),
            toDouble (mask (cho (), 1)),
            toDouble (mask (cic (), 2)),
            toDouble (mask (cio (), 3)),
            toDouble (mask (db1 (), 4)),
            toDouble (mask (db2 (), 5)),
            toDouble (mask (hhpmax (), 6)),
            toDouble (mask (ke (), 7)),
            toDouble (mask (kfcor (), 8)),
            toDouble (mask (khp (), 9)),
            toDouble (mask (klp (), 10)),
            toDouble (mask (komegacor (), 11)),
            toDouble (mask (mwbase (), 12)),
            toDouble (mask (pmax (), 13)),
            toDouble (mask (prhmax (), 14)),
            toDouble (mask (simx (), 15)),
            toDouble (mask (tb (), 16)),
            toDouble (mask (tdp (), 17)),
            toDouble (mask (ten (), 18)),
            toDouble (mask (tf (), 19)),
            toDouble (mask (tfp (), 20)),
            toDouble (mask (thp (), 21)),
            toDouble (mask (tip (), 22)),
            toDouble (mask (tlp (), 23)),
            toDouble (mask (tp (), 24)),
            toDouble (mask (trh (), 25)),
            toDouble (mask (tvhp (), 26)),
            toDouble (mask (tvip (), 27)),
            toDouble (mask (tw (), 28)),
            toDouble (mask (wfmax (), 29)),
            toDouble (mask (wfmin (), 30)),
            toDouble (mask (wmax1 (), 31)),
            toDouble (mask (wmax2 (), 32)),
            toDouble (mask (wwmax (), 33)),
            toDouble (mask (wwmin (), 34))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Steam turbine governor with reheat time constants and modelling of the effects of fast valve closing to reduce mechanical power.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param dt (<i>Dt</i>).
 * @param k Fraction of the turbine power developed by turbine sections not involved in fast valving (<i>K</i>).
 * @param mwbase Alternate base used instead of machine base in equipment model if necessary (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param r (<i>R</i>).
 * @param t1 Governor time constant (<i>T1</i>) (&gt;= 0).
 * @param t3 Reheater time constant (<i>T3</i>) (&gt;= 0).
 * @param ta Time after initial time for valve to close (<i>Ta</i>) (&gt;= 0).
 * @param tb Time after initial time for valve to begin opening (<i>Tb</i>) (&gt;= 0).
 * @param tc Time after initial time for valve to become fully open (<i>Tc</i>) (&gt;= 0).
 * @param tt Time constant with which power falls off after intercept valve closure (<i>Tt</i>) (&gt;= 0).
 * @param vmax (<i>Vmax</i>) (&gt; GovSteamFV2.vmin).
 * @param vmin (<i>Vmin</i>) (&lt; GovSteamFV2.vmax).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamFV2
(
    override val sup: TurbineGovernorDynamics = null,
    dt: Double = 0.0,
    k: Double = 0.0,
    mwbase: Double = 0.0,
    r: Double = 0.0,
    t1: Double = 0.0,
    t3: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    tt: Double = 0.0,
    vmax: Double = 0.0,
    vmin: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamFV2] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamFV2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamFV2.fields (position), value)
        emitelem (0, dt)
        emitelem (1, k)
        emitelem (2, mwbase)
        emitelem (3, r)
        emitelem (4, t1)
        emitelem (5, t3)
        emitelem (6, ta)
        emitelem (7, tb)
        emitelem (8, tc)
        emitelem (9, tt)
        emitelem (10, vmax)
        emitelem (11, vmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV2 rdf:ID=\"%s\">\n%s\t</cim:GovSteamFV2>".format (id, export_fields)
    }
}

object GovSteamFV2
extends
    Parseable[GovSteamFV2]
{
    override val fields: Array[String] = Array[String] (
        "dt",
        "k",
        "mwbase",
        "r",
        "t1",
        "t3",
        "ta",
        "tb",
        "tc",
        "tt",
        "vmax",
        "vmin"
    )
    val dt: Fielder = parse_element (element (cls, fields(0)))
    val k: Fielder = parse_element (element (cls, fields(1)))
    val mwbase: Fielder = parse_element (element (cls, fields(2)))
    val r: Fielder = parse_element (element (cls, fields(3)))
    val t1: Fielder = parse_element (element (cls, fields(4)))
    val t3: Fielder = parse_element (element (cls, fields(5)))
    val ta: Fielder = parse_element (element (cls, fields(6)))
    val tb: Fielder = parse_element (element (cls, fields(7)))
    val tc: Fielder = parse_element (element (cls, fields(8)))
    val tt: Fielder = parse_element (element (cls, fields(9)))
    val vmax: Fielder = parse_element (element (cls, fields(10)))
    val vmin: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): GovSteamFV2 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamFV2 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (dt (), 0)),
            toDouble (mask (k (), 1)),
            toDouble (mask (mwbase (), 2)),
            toDouble (mask (r (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (t3 (), 5)),
            toDouble (mask (ta (), 6)),
            toDouble (mask (tb (), 7)),
            toDouble (mask (tc (), 8)),
            toDouble (mask (tt (), 9)),
            toDouble (mask (vmax (), 10)),
            toDouble (mask (vmin (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified GovSteamIEEE1 steam turbine governor with Prmax limit and fast valving.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param gv1 Nonlinear gain valve position point 1 (<i>GV1</i>).
 *        Typical value = 0.
 * @param gv2 Nonlinear gain valve position point 2 (<i>GV2</i>).
 *        Typical value = 0,4.
 * @param gv3 Nonlinear gain valve position point 3 (<i>GV3</i>).
 *        Typical value = 0,5.
 * @param gv4 Nonlinear gain valve position point 4 (<i>GV4</i>).
 *        Typical value = 0,6.
 * @param gv5 Nonlinear gain valve position point 5 (<i>GV5</i>).
 *        Typical value = 1.
 * @param gv6 Nonlinear gain valve position point 6 (<i>GV6</i>).
 *        Typical value = 0.
 * @param k Governor gain, (reciprocal of droop) (<i>K</i>).
 *        Typical value = 20.
 * @param k1 Fraction of turbine power developed after first boiler pass (<i>K1</i>).
 *        Typical value = 0,2.
 * @param k2 Fraction of turbine power developed after second boiler pass (<i>K2</i>).
 *        Typical value = 0,2.
 * @param k3 Fraction of hp turbine power developed after crossover or third boiler pass (<i>K3</i>).
 *        Typical value = 0,6.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain power value point 1 (<i>Pgv1</i>).
 *        Typical value = 0.
 * @param pgv2 Nonlinear gain power value point 2 (<i>Pgv2</i>).
 *        Typical value = 0,75.
 * @param pgv3 Nonlinear gain power value point 3 (<i>Pgv3</i>).
 *        Typical value = 0,91.
 * @param pgv4 Nonlinear gain power value point 4 (<i>Pgv4</i>).
 *        Typical value = 0,98.
 * @param pgv5 Nonlinear gain power value point 5 (<i>Pgv5</i>).
 *        Typical value = 1.
 * @param pgv6 Nonlinear gain power value point 6 (<i>Pgv6</i>).
 *        Typical value = 0.
 * @param pmax Maximum valve opening, PU of <i>MWbase</i> (<i>Pmax</i>) (&gt; GovSteamFV3.pmin).
 *        Typical value = 1.
 * @param pmin Minimum valve opening, PU of <i>MWbase</i> (<i>Pmin</i>) (&lt; GovSteamFV3.pmax).
 *        Typical value = 0.
 * @param prmax Max. pressure in reheater (<i>Prmax</i>).
 *        Typical value = 1.
 * @param t1 Governor lead time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t2 Governor lag time constant (<i>T2</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t3 Valve positioner time constant (<i>T3</i>) (&gt; 0).
 *        Typical value = 0.
 * @param t4 Inlet piping/steam bowl time constant (<i>T4</i>) (&gt;= 0).
 *        Typical value = 0,2.
 * @param t5 Time constant of second boiler pass (i.e. reheater) (<i>T5</i>) (&gt; 0 if fast valving is used, otherwise &gt;= 0).
 *        Typical value = 0,5.
 * @param t6 Time constant of crossover or third boiler pass (<i>T6</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param ta Time to close intercept valve (IV) (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0,97.
 * @param tb Time until IV starts to reopen (<i>Tb</i>) (&gt;= 0).
 *        Typical value = 0,98.
 * @param tc Time until IV is fully open (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0,99.
 * @param uc Maximum valve closing velocity (<i>Uc</i>).
 *        Unit = PU / s.  Typical value = -1.
 * @param uo Maximum valve opening velocity (<i>Uo</i>).
 *        Unit = PU / s.  Typical value = 0,1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamFV3
(
    override val sup: TurbineGovernorDynamics = null,
    gv1: Double = 0.0,
    gv2: Double = 0.0,
    gv3: Double = 0.0,
    gv4: Double = 0.0,
    gv5: Double = 0.0,
    gv6: Double = 0.0,
    k: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    mwbase: Double = 0.0,
    pgv1: Double = 0.0,
    pgv2: Double = 0.0,
    pgv3: Double = 0.0,
    pgv4: Double = 0.0,
    pgv5: Double = 0.0,
    pgv6: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    prmax: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    ta: Double = 0.0,
    tb: Double = 0.0,
    tc: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamFV3] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamFV3.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamFV3.fields (position), value)
        emitelem (0, gv1)
        emitelem (1, gv2)
        emitelem (2, gv3)
        emitelem (3, gv4)
        emitelem (4, gv5)
        emitelem (5, gv6)
        emitelem (6, k)
        emitelem (7, k1)
        emitelem (8, k2)
        emitelem (9, k3)
        emitelem (10, mwbase)
        emitelem (11, pgv1)
        emitelem (12, pgv2)
        emitelem (13, pgv3)
        emitelem (14, pgv4)
        emitelem (15, pgv5)
        emitelem (16, pgv6)
        emitelem (17, pmax)
        emitelem (18, pmin)
        emitelem (19, prmax)
        emitelem (20, t1)
        emitelem (21, t2)
        emitelem (22, t3)
        emitelem (23, t4)
        emitelem (24, t5)
        emitelem (25, t6)
        emitelem (26, ta)
        emitelem (27, tb)
        emitelem (28, tc)
        emitelem (29, uc)
        emitelem (30, uo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV3 rdf:ID=\"%s\">\n%s\t</cim:GovSteamFV3>".format (id, export_fields)
    }
}

object GovSteamFV3
extends
    Parseable[GovSteamFV3]
{
    override val fields: Array[String] = Array[String] (
        "gv1",
        "gv2",
        "gv3",
        "gv4",
        "gv5",
        "gv6",
        "k",
        "k1",
        "k2",
        "k3",
        "mwbase",
        "pgv1",
        "pgv2",
        "pgv3",
        "pgv4",
        "pgv5",
        "pgv6",
        "pmax",
        "pmin",
        "prmax",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "ta",
        "tb",
        "tc",
        "uc",
        "uo"
    )
    val gv1: Fielder = parse_element (element (cls, fields(0)))
    val gv2: Fielder = parse_element (element (cls, fields(1)))
    val gv3: Fielder = parse_element (element (cls, fields(2)))
    val gv4: Fielder = parse_element (element (cls, fields(3)))
    val gv5: Fielder = parse_element (element (cls, fields(4)))
    val gv6: Fielder = parse_element (element (cls, fields(5)))
    val k: Fielder = parse_element (element (cls, fields(6)))
    val k1: Fielder = parse_element (element (cls, fields(7)))
    val k2: Fielder = parse_element (element (cls, fields(8)))
    val k3: Fielder = parse_element (element (cls, fields(9)))
    val mwbase: Fielder = parse_element (element (cls, fields(10)))
    val pgv1: Fielder = parse_element (element (cls, fields(11)))
    val pgv2: Fielder = parse_element (element (cls, fields(12)))
    val pgv3: Fielder = parse_element (element (cls, fields(13)))
    val pgv4: Fielder = parse_element (element (cls, fields(14)))
    val pgv5: Fielder = parse_element (element (cls, fields(15)))
    val pgv6: Fielder = parse_element (element (cls, fields(16)))
    val pmax: Fielder = parse_element (element (cls, fields(17)))
    val pmin: Fielder = parse_element (element (cls, fields(18)))
    val prmax: Fielder = parse_element (element (cls, fields(19)))
    val t1: Fielder = parse_element (element (cls, fields(20)))
    val t2: Fielder = parse_element (element (cls, fields(21)))
    val t3: Fielder = parse_element (element (cls, fields(22)))
    val t4: Fielder = parse_element (element (cls, fields(23)))
    val t5: Fielder = parse_element (element (cls, fields(24)))
    val t6: Fielder = parse_element (element (cls, fields(25)))
    val ta: Fielder = parse_element (element (cls, fields(26)))
    val tb: Fielder = parse_element (element (cls, fields(27)))
    val tc: Fielder = parse_element (element (cls, fields(28)))
    val uc: Fielder = parse_element (element (cls, fields(29)))
    val uo: Fielder = parse_element (element (cls, fields(30)))

    def parse (context: Context): GovSteamFV3 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamFV3 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (gv1 (), 0)),
            toDouble (mask (gv2 (), 1)),
            toDouble (mask (gv3 (), 2)),
            toDouble (mask (gv4 (), 3)),
            toDouble (mask (gv5 (), 4)),
            toDouble (mask (gv6 (), 5)),
            toDouble (mask (k (), 6)),
            toDouble (mask (k1 (), 7)),
            toDouble (mask (k2 (), 8)),
            toDouble (mask (k3 (), 9)),
            toDouble (mask (mwbase (), 10)),
            toDouble (mask (pgv1 (), 11)),
            toDouble (mask (pgv2 (), 12)),
            toDouble (mask (pgv3 (), 13)),
            toDouble (mask (pgv4 (), 14)),
            toDouble (mask (pgv5 (), 15)),
            toDouble (mask (pgv6 (), 16)),
            toDouble (mask (pmax (), 17)),
            toDouble (mask (pmin (), 18)),
            toDouble (mask (prmax (), 19)),
            toDouble (mask (t1 (), 20)),
            toDouble (mask (t2 (), 21)),
            toDouble (mask (t3 (), 22)),
            toDouble (mask (t4 (), 23)),
            toDouble (mask (t5 (), 24)),
            toDouble (mask (t6 (), 25)),
            toDouble (mask (ta (), 26)),
            toDouble (mask (tb (), 27)),
            toDouble (mask (tc (), 28)),
            toDouble (mask (uc (), 29)),
            toDouble (mask (uo (), 30))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Detailed electro-hydraulic governor for steam unit.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param cpsmn Minimum value of pressure regulator output (<i>Cpsmn</i>).
 *        Typical value = -1.
 * @param cpsmx Maximum value of pressure regulator output (<i>Cpsmx</i>).
 *        Typical value = 1.
 * @param crmn Minimum value of regulator set-point (<i>Crmn</i>).
 *        Typical value = 0.
 * @param crmx Maximum value of regulator set-point (<i>Crmx</i>).
 *        Typical value = 1,2.
 * @param kdc Derivative gain of pressure regulator (<i>Kdc</i>).
 *        Typical value = 1.
 * @param kf1 Frequency bias (reciprocal of droop) (<i>Kf1</i>).
 *        Typical value = 20.
 * @param kf3 Frequency control (reciprocal of droop) (<i>Kf3</i>).
 *        Typical value = 20.
 * @param khp Fraction  of total turbine output generated by HP part (<i>Khp</i>).
 *        Typical value = 0,35.
 * @param kic Integral gain of pressure regulator (<i>Kic</i>).
 *        Typical value = 0,0033.
 * @param kip Integral gain of pressure feedback regulator (<i>Kip</i>).
 *        Typical value = 0,5.
 * @param kit Integral gain of electro-hydraulic regulator (<i>Kit</i>).
 *        Typical value = 0,04.
 * @param kmp1 First gain coefficient of  intercept valves characteristic (<i>Kmp1</i>).
 *        Typical value = 0,5.
 * @param kmp2 Second gain coefficient of intercept valves characteristic (<i>Kmp2</i>).
 *        Typical value = 3,5.
 * @param kpc Proportional gain of pressure regulator (<i>Kpc</i>).
 *        Typical value = 0,5.
 * @param kpp Proportional gain of pressure feedback regulator (<i>Kpp</i>).
 *        Typical value = 1.
 * @param kpt Proportional gain of electro-hydraulic regulator (<i>Kpt</i>).
 *        Typical value = 0,3.
 * @param krc Maximum variation of fuel flow (<i>Krc</i>).
 *        Typical value = 0,05.
 * @param ksh Pressure loss due to flow friction in the boiler tubes (<i>Ksh</i>).
 *        Typical value = 0,08.
 * @param lpi Maximum negative power error (<i>Lpi</i>).
 *        Typical value = -0,15.
 * @param lps Maximum positive power error (<i>Lps</i>).
 *        Typical value = 0,03.
 * @param mnef Lower limit for frequency correction (<i>MN</i><i><sub>EF</sub></i>).
 *        Typical value = -0,05.
 * @param mxef Upper limit for frequency correction (<i>MX</i><i><sub>EF</sub></i>).
 *        Typical value = 0,05.
 * @param pr1 First value of pressure set point static characteristic (<i>Pr1</i>).
 *        Typical value = 0,2.
 * @param pr2 Second value of pressure set point static characteristic, corresponding to <i>Ps0</i> = 1,0 PU (<i>Pr2</i>).
 *        Typical value = 0,75.
 * @param psmn Minimum value of pressure set point static characteristic (<i>Psmn</i>).
 *        Typical value = 1.
 * @param rsmimn Minimum value of integral regulator (<i>Rsmimn</i>).
 *        Typical value = 0.
 * @param rsmimx Maximum value of integral regulator (<i>Rsmimx</i>).
 *        Typical value = 1,1.
 * @param rvgmn Minimum value of integral regulator (<i>Rvgmn</i>).
 *        Typical value = 0.
 * @param rvgmx Maximum value of integral regulator (<i>Rvgmx</i>).
 *        Typical value = 1,2.
 * @param srmn Minimum valve opening (<i>Srmn</i>).
 *        Typical value = 0.
 * @param srmx Maximum valve opening (<i>Srmx</i>).
 *        Typical value = 1,1.
 * @param srsmp Intercept valves characteristic discontinuity point (<i>Srsmp</i>).
 *        Typical value = 0,43.
 * @param svmn Maximum regulator gate closing velocity (<i>Svmn</i>).
 *        Typical value = -0,0333.
 * @param svmx Maximum regulator gate opening velocity (<i>Svmx</i>).
 *        Typical value = 0,0333.
 * @param ta Control valves rate opening time (<i>Ta</i>) (&gt;= 0).
 *        Typical value = 0,8.
 * @param tam Intercept valves rate opening time (<i>Tam</i>) (&gt;= 0).
 *        Typical value = 0,8.
 * @param tc Control valves rate closing time (<i>Tc</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param tcm Intercept valves rate closing time (<i>Tcm</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param tdc Derivative time constant of pressure regulator (<i>Tdc</i>) (&gt;= 0).
 *        Typical value = 90.
 * @param tf1 Time constant of fuel regulation (<i>Tf1</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tf2 Time constant of steam chest (<i>Tf2</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param thp High pressure (HP) time constant of the turbine (<i>Thp</i>) (&gt;= 0).
 *        Typical value = 0,15.
 * @param tmp Low pressure (LP) time constant of the turbine (<i>Tmp</i>) (&gt;= 0).
 *        Typical value = 0,4.
 * @param trh Reheater  time constant of the turbine (<i>Trh</i>) (&gt;= 0).
 *        Typical value = 10.
 * @param tv Boiler time constant (<i>Tv</i>) (&gt;= 0).
 *        Typical value = 60.
 * @param ty Control valves servo time constant (<i>Ty</i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param y Coefficient of linearized equations of turbine (Stodola formulation) (<i>Y</i>).
 *        Typical value = 0,13.
 * @param yhpmn Minimum control valve position (<i>Yhpmn</i>).
 *        Typical value = 0.
 * @param yhpmx Maximum control valve position (<i>Yhpmx</i>).
 *        Typical value = 1,1.
 * @param ympmn Minimum intercept valve position (<i>Ympmn</i>).
 *        Typical value = 0.
 * @param ympmx Maximum intercept valve position (<i>Ympmx</i>).
 *        Typical value = 1,1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamFV4
(
    override val sup: TurbineGovernorDynamics = null,
    cpsmn: Double = 0.0,
    cpsmx: Double = 0.0,
    crmn: Double = 0.0,
    crmx: Double = 0.0,
    kdc: Double = 0.0,
    kf1: Double = 0.0,
    kf3: Double = 0.0,
    khp: Double = 0.0,
    kic: Double = 0.0,
    kip: Double = 0.0,
    kit: Double = 0.0,
    kmp1: Double = 0.0,
    kmp2: Double = 0.0,
    kpc: Double = 0.0,
    kpp: Double = 0.0,
    kpt: Double = 0.0,
    krc: Double = 0.0,
    ksh: Double = 0.0,
    lpi: Double = 0.0,
    lps: Double = 0.0,
    mnef: Double = 0.0,
    mxef: Double = 0.0,
    pr1: Double = 0.0,
    pr2: Double = 0.0,
    psmn: Double = 0.0,
    rsmimn: Double = 0.0,
    rsmimx: Double = 0.0,
    rvgmn: Double = 0.0,
    rvgmx: Double = 0.0,
    srmn: Double = 0.0,
    srmx: Double = 0.0,
    srsmp: Double = 0.0,
    svmn: Double = 0.0,
    svmx: Double = 0.0,
    ta: Double = 0.0,
    tam: Double = 0.0,
    tc: Double = 0.0,
    tcm: Double = 0.0,
    tdc: Double = 0.0,
    tf1: Double = 0.0,
    tf2: Double = 0.0,
    thp: Double = 0.0,
    tmp: Double = 0.0,
    trh: Double = 0.0,
    tv: Double = 0.0,
    ty: Double = 0.0,
    y: Double = 0.0,
    yhpmn: Double = 0.0,
    yhpmx: Double = 0.0,
    ympmn: Double = 0.0,
    ympmx: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamFV4] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamFV4.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamFV4.fields (position), value)
        emitelem (0, cpsmn)
        emitelem (1, cpsmx)
        emitelem (2, crmn)
        emitelem (3, crmx)
        emitelem (4, kdc)
        emitelem (5, kf1)
        emitelem (6, kf3)
        emitelem (7, khp)
        emitelem (8, kic)
        emitelem (9, kip)
        emitelem (10, kit)
        emitelem (11, kmp1)
        emitelem (12, kmp2)
        emitelem (13, kpc)
        emitelem (14, kpp)
        emitelem (15, kpt)
        emitelem (16, krc)
        emitelem (17, ksh)
        emitelem (18, lpi)
        emitelem (19, lps)
        emitelem (20, mnef)
        emitelem (21, mxef)
        emitelem (22, pr1)
        emitelem (23, pr2)
        emitelem (24, psmn)
        emitelem (25, rsmimn)
        emitelem (26, rsmimx)
        emitelem (27, rvgmn)
        emitelem (28, rvgmx)
        emitelem (29, srmn)
        emitelem (30, srmx)
        emitelem (31, srsmp)
        emitelem (32, svmn)
        emitelem (33, svmx)
        emitelem (34, ta)
        emitelem (35, tam)
        emitelem (36, tc)
        emitelem (37, tcm)
        emitelem (38, tdc)
        emitelem (39, tf1)
        emitelem (40, tf2)
        emitelem (41, thp)
        emitelem (42, tmp)
        emitelem (43, trh)
        emitelem (44, tv)
        emitelem (45, ty)
        emitelem (46, y)
        emitelem (47, yhpmn)
        emitelem (48, yhpmx)
        emitelem (49, ympmn)
        emitelem (50, ympmx)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV4 rdf:ID=\"%s\">\n%s\t</cim:GovSteamFV4>".format (id, export_fields)
    }
}

object GovSteamFV4
extends
    Parseable[GovSteamFV4]
{
    override val fields: Array[String] = Array[String] (
        "cpsmn",
        "cpsmx",
        "crmn",
        "crmx",
        "kdc",
        "kf1",
        "kf3",
        "khp",
        "kic",
        "kip",
        "kit",
        "kmp1",
        "kmp2",
        "kpc",
        "kpp",
        "kpt",
        "krc",
        "ksh",
        "lpi",
        "lps",
        "mnef",
        "mxef",
        "pr1",
        "pr2",
        "psmn",
        "rsmimn",
        "rsmimx",
        "rvgmn",
        "rvgmx",
        "srmn",
        "srmx",
        "srsmp",
        "svmn",
        "svmx",
        "ta",
        "tam",
        "tc",
        "tcm",
        "tdc",
        "tf1",
        "tf2",
        "thp",
        "tmp",
        "trh",
        "tv",
        "ty",
        "y",
        "yhpmn",
        "yhpmx",
        "ympmn",
        "ympmx"
    )
    val cpsmn: Fielder = parse_element (element (cls, fields(0)))
    val cpsmx: Fielder = parse_element (element (cls, fields(1)))
    val crmn: Fielder = parse_element (element (cls, fields(2)))
    val crmx: Fielder = parse_element (element (cls, fields(3)))
    val kdc: Fielder = parse_element (element (cls, fields(4)))
    val kf1: Fielder = parse_element (element (cls, fields(5)))
    val kf3: Fielder = parse_element (element (cls, fields(6)))
    val khp: Fielder = parse_element (element (cls, fields(7)))
    val kic: Fielder = parse_element (element (cls, fields(8)))
    val kip: Fielder = parse_element (element (cls, fields(9)))
    val kit: Fielder = parse_element (element (cls, fields(10)))
    val kmp1: Fielder = parse_element (element (cls, fields(11)))
    val kmp2: Fielder = parse_element (element (cls, fields(12)))
    val kpc: Fielder = parse_element (element (cls, fields(13)))
    val kpp: Fielder = parse_element (element (cls, fields(14)))
    val kpt: Fielder = parse_element (element (cls, fields(15)))
    val krc: Fielder = parse_element (element (cls, fields(16)))
    val ksh: Fielder = parse_element (element (cls, fields(17)))
    val lpi: Fielder = parse_element (element (cls, fields(18)))
    val lps: Fielder = parse_element (element (cls, fields(19)))
    val mnef: Fielder = parse_element (element (cls, fields(20)))
    val mxef: Fielder = parse_element (element (cls, fields(21)))
    val pr1: Fielder = parse_element (element (cls, fields(22)))
    val pr2: Fielder = parse_element (element (cls, fields(23)))
    val psmn: Fielder = parse_element (element (cls, fields(24)))
    val rsmimn: Fielder = parse_element (element (cls, fields(25)))
    val rsmimx: Fielder = parse_element (element (cls, fields(26)))
    val rvgmn: Fielder = parse_element (element (cls, fields(27)))
    val rvgmx: Fielder = parse_element (element (cls, fields(28)))
    val srmn: Fielder = parse_element (element (cls, fields(29)))
    val srmx: Fielder = parse_element (element (cls, fields(30)))
    val srsmp: Fielder = parse_element (element (cls, fields(31)))
    val svmn: Fielder = parse_element (element (cls, fields(32)))
    val svmx: Fielder = parse_element (element (cls, fields(33)))
    val ta: Fielder = parse_element (element (cls, fields(34)))
    val tam: Fielder = parse_element (element (cls, fields(35)))
    val tc: Fielder = parse_element (element (cls, fields(36)))
    val tcm: Fielder = parse_element (element (cls, fields(37)))
    val tdc: Fielder = parse_element (element (cls, fields(38)))
    val tf1: Fielder = parse_element (element (cls, fields(39)))
    val tf2: Fielder = parse_element (element (cls, fields(40)))
    val thp: Fielder = parse_element (element (cls, fields(41)))
    val tmp: Fielder = parse_element (element (cls, fields(42)))
    val trh: Fielder = parse_element (element (cls, fields(43)))
    val tv: Fielder = parse_element (element (cls, fields(44)))
    val ty: Fielder = parse_element (element (cls, fields(45)))
    val y: Fielder = parse_element (element (cls, fields(46)))
    val yhpmn: Fielder = parse_element (element (cls, fields(47)))
    val yhpmx: Fielder = parse_element (element (cls, fields(48)))
    val ympmn: Fielder = parse_element (element (cls, fields(49)))
    val ympmx: Fielder = parse_element (element (cls, fields(50)))

    def parse (context: Context): GovSteamFV4 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = GovSteamFV4 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (cpsmn (), 0)),
            toDouble (mask (cpsmx (), 1)),
            toDouble (mask (crmn (), 2)),
            toDouble (mask (crmx (), 3)),
            toDouble (mask (kdc (), 4)),
            toDouble (mask (kf1 (), 5)),
            toDouble (mask (kf3 (), 6)),
            toDouble (mask (khp (), 7)),
            toDouble (mask (kic (), 8)),
            toDouble (mask (kip (), 9)),
            toDouble (mask (kit (), 10)),
            toDouble (mask (kmp1 (), 11)),
            toDouble (mask (kmp2 (), 12)),
            toDouble (mask (kpc (), 13)),
            toDouble (mask (kpp (), 14)),
            toDouble (mask (kpt (), 15)),
            toDouble (mask (krc (), 16)),
            toDouble (mask (ksh (), 17)),
            toDouble (mask (lpi (), 18)),
            toDouble (mask (lps (), 19)),
            toDouble (mask (mnef (), 20)),
            toDouble (mask (mxef (), 21)),
            toDouble (mask (pr1 (), 22)),
            toDouble (mask (pr2 (), 23)),
            toDouble (mask (psmn (), 24)),
            toDouble (mask (rsmimn (), 25)),
            toDouble (mask (rsmimx (), 26)),
            toDouble (mask (rvgmn (), 27)),
            toDouble (mask (rvgmx (), 28)),
            toDouble (mask (srmn (), 29)),
            toDouble (mask (srmx (), 30)),
            toDouble (mask (srsmp (), 31)),
            toDouble (mask (svmn (), 32)),
            toDouble (mask (svmx (), 33)),
            toDouble (mask (ta (), 34)),
            toDouble (mask (tam (), 35)),
            toDouble (mask (tc (), 36)),
            toDouble (mask (tcm (), 37)),
            toDouble (mask (tdc (), 38)),
            toDouble (mask (tf1 (), 39)),
            toDouble (mask (tf2 (), 40)),
            toDouble (mask (thp (), 41)),
            toDouble (mask (tmp (), 42)),
            toDouble (mask (trh (), 43)),
            toDouble (mask (tv (), 44)),
            toDouble (mask (ty (), 45)),
            toDouble (mask (y (), 46)),
            toDouble (mask (yhpmn (), 47)),
            toDouble (mask (yhpmx (), 48)),
            toDouble (mask (ympmn (), 49)),
            toDouble (mask (ympmx (), 50))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEEE steam turbine governor model.
 *
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems, November/December 1973, Volume PAS-92, Number 6, <i><u>Dynamic Models for Steam and Hydro Turbines in Power System Studies</u></i>, page 1904.</font>
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param k Governor gain (reciprocal of droop) (<i>K</i>) (&gt; 0).
 *        Typical value = 25.
 * @param k1 Fraction of HP shaft power after first boiler pass (<i>K1</i>).
 *        Typical value = 0,2.
 * @param k2 Fraction of LP shaft power after first boiler pass (<i>K2</i>).
 *        Typical value = 0.
 * @param k3 Fraction of HP shaft power after second boiler pass (<i>K3</i>).
 *        Typical value = 0,3.
 * @param k4 Fraction of LP shaft power after second boiler pass (<i>K4</i>).
 *        Typical value = 0.
 * @param k5 Fraction of HP shaft power after third boiler pass (<i>K5</i>).
 *        Typical value = 0,5.
 * @param k6 Fraction of LP shaft power after third boiler pass (<i>K6</i>).
 *        Typical value = 0.
 * @param k7 Fraction of HP shaft power after fourth boiler pass (<i>K7</i>).
 *        Typical value = 0.
 * @param k8 Fraction of LP shaft power after fourth boiler pass (<i>K8</i>).
 *        Typical value = 0.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0)<i>. </i>Unit = MW.
 * @param pmax Maximum valve opening (<i>Pmax</i>) (&gt; GovSteamIEEE1.pmin).
 *        Typical value = 1.
 * @param pmin Minimum valve opening (<i>Pmin</i>) (&gt;= 0 and &lt; GovSteamIEEE1.pmax).
 *        Typical value = 0.
 * @param t1 Governor lag time constant (<i>T1</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t2 Governor lead time constant (<i>T2</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param t3 Valve positioner time constant (<i>T3</i>) (&gt; 0).
 *        Typical value = 0,1.
 * @param t4 Inlet piping/steam bowl time constant (<i>T4</i>) (&gt;= 0).
 *        Typical value = 0,3.
 * @param t5 Time constant of second boiler pass (<i>T5</i>) (&gt;= 0).
 *        Typical value = 5.
 * @param t6 Time constant of third boiler pass (<i>T6</i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param t7 Time constant of fourth boiler pass (<i>T7</i>) (&gt;= 0).
 *        Typical value = 0.
 * @param uc Maximum valve closing velocity (<i>Uc</i>) (&lt; 0).
 *        Unit = PU / s.  Typical value = -10.
 * @param uo Maximum valve opening velocity (<i>Uo</i>) (&gt; 0).
 *        Unit = PU / s.  Typical value = 1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamIEEE1
(
    override val sup: TurbineGovernorDynamics = null,
    k: Double = 0.0,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    k4: Double = 0.0,
    k5: Double = 0.0,
    k6: Double = 0.0,
    k7: Double = 0.0,
    k8: Double = 0.0,
    mwbase: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0,
    t7: Double = 0.0,
    uc: Double = 0.0,
    uo: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamIEEE1] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamIEEE1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamIEEE1.fields (position), value)
        emitelem (0, k)
        emitelem (1, k1)
        emitelem (2, k2)
        emitelem (3, k3)
        emitelem (4, k4)
        emitelem (5, k5)
        emitelem (6, k6)
        emitelem (7, k7)
        emitelem (8, k8)
        emitelem (9, mwbase)
        emitelem (10, pmax)
        emitelem (11, pmin)
        emitelem (12, t1)
        emitelem (13, t2)
        emitelem (14, t3)
        emitelem (15, t4)
        emitelem (16, t5)
        emitelem (17, t6)
        emitelem (18, t7)
        emitelem (19, uc)
        emitelem (20, uo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamIEEE1 rdf:ID=\"%s\">\n%s\t</cim:GovSteamIEEE1>".format (id, export_fields)
    }
}

object GovSteamIEEE1
extends
    Parseable[GovSteamIEEE1]
{
    override val fields: Array[String] = Array[String] (
        "k",
        "k1",
        "k2",
        "k3",
        "k4",
        "k5",
        "k6",
        "k7",
        "k8",
        "mwbase",
        "pmax",
        "pmin",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6",
        "t7",
        "uc",
        "uo"
    )
    val k: Fielder = parse_element (element (cls, fields(0)))
    val k1: Fielder = parse_element (element (cls, fields(1)))
    val k2: Fielder = parse_element (element (cls, fields(2)))
    val k3: Fielder = parse_element (element (cls, fields(3)))
    val k4: Fielder = parse_element (element (cls, fields(4)))
    val k5: Fielder = parse_element (element (cls, fields(5)))
    val k6: Fielder = parse_element (element (cls, fields(6)))
    val k7: Fielder = parse_element (element (cls, fields(7)))
    val k8: Fielder = parse_element (element (cls, fields(8)))
    val mwbase: Fielder = parse_element (element (cls, fields(9)))
    val pmax: Fielder = parse_element (element (cls, fields(10)))
    val pmin: Fielder = parse_element (element (cls, fields(11)))
    val t1: Fielder = parse_element (element (cls, fields(12)))
    val t2: Fielder = parse_element (element (cls, fields(13)))
    val t3: Fielder = parse_element (element (cls, fields(14)))
    val t4: Fielder = parse_element (element (cls, fields(15)))
    val t5: Fielder = parse_element (element (cls, fields(16)))
    val t6: Fielder = parse_element (element (cls, fields(17)))
    val t7: Fielder = parse_element (element (cls, fields(18)))
    val uc: Fielder = parse_element (element (cls, fields(19)))
    val uo: Fielder = parse_element (element (cls, fields(20)))

    def parse (context: Context): GovSteamIEEE1 =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamIEEE1 (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (k (), 0)),
            toDouble (mask (k1 (), 1)),
            toDouble (mask (k2 (), 2)),
            toDouble (mask (k3 (), 3)),
            toDouble (mask (k4 (), 4)),
            toDouble (mask (k5 (), 5)),
            toDouble (mask (k6 (), 6)),
            toDouble (mask (k7 (), 7)),
            toDouble (mask (k8 (), 8)),
            toDouble (mask (mwbase (), 9)),
            toDouble (mask (pmax (), 10)),
            toDouble (mask (pmin (), 11)),
            toDouble (mask (t1 (), 12)),
            toDouble (mask (t2 (), 13)),
            toDouble (mask (t3 (), 14)),
            toDouble (mask (t4 (), 15)),
            toDouble (mask (t5 (), 16)),
            toDouble (mask (t6 (), 17)),
            toDouble (mask (t7 (), 18)),
            toDouble (mask (uc (), 19)),
            toDouble (mask (uo (), 20))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified steam turbine governor.
 *
 * @param sup [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Reference to the superclass object.
 * @param k1 One / PU regulation (<i>K1</i>).
 * @param k2 Fraction (<i>K2</i>).
 * @param k3 Fraction (<i>K3</i>).
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pmax Upper power limit (<i>Pmax</i>) (&gt; GovSteamSGO.pmin).
 * @param pmin Lower power limit (<i>Pmin</i>) (&gt;= 0 and &lt; GovSteamSGO.pmax).
 * @param t1 Controller lag (<i>T1</i>) (&gt;= 0).
 * @param t2 Controller lead compensation (<i>T2</i>) (&gt;= 0).
 * @param t3 Governor lag (<i>T3</i>) (&gt; 0).
 * @param t4 Delay due to steam inlet volumes associated with steam chest and inlet piping (<i>T4</i>) (&gt;= 0).
 * @param t5 Reheater delay including hot and cold leads (<i>T5</i>) (&gt;= 0).
 * @param t6 Delay due to IP-LP turbine, crossover pipes and LP end hoods (<i>T6</i>) (&gt;= 0).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class GovSteamSGO
(
    override val sup: TurbineGovernorDynamics = null,
    k1: Double = 0.0,
    k2: Double = 0.0,
    k3: Double = 0.0,
    mwbase: Double = 0.0,
    pmax: Double = 0.0,
    pmin: Double = 0.0,
    t1: Double = 0.0,
    t2: Double = 0.0,
    t3: Double = 0.0,
    t4: Double = 0.0,
    t5: Double = 0.0,
    t6: Double = 0.0
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamSGO] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GovSteamSGO.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GovSteamSGO.fields (position), value)
        emitelem (0, k1)
        emitelem (1, k2)
        emitelem (2, k3)
        emitelem (3, mwbase)
        emitelem (4, pmax)
        emitelem (5, pmin)
        emitelem (6, t1)
        emitelem (7, t2)
        emitelem (8, t3)
        emitelem (9, t4)
        emitelem (10, t5)
        emitelem (11, t6)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GovSteamSGO rdf:ID=\"%s\">\n%s\t</cim:GovSteamSGO>".format (id, export_fields)
    }
}

object GovSteamSGO
extends
    Parseable[GovSteamSGO]
{
    override val fields: Array[String] = Array[String] (
        "k1",
        "k2",
        "k3",
        "mwbase",
        "pmax",
        "pmin",
        "t1",
        "t2",
        "t3",
        "t4",
        "t5",
        "t6"
    )
    val k1: Fielder = parse_element (element (cls, fields(0)))
    val k2: Fielder = parse_element (element (cls, fields(1)))
    val k3: Fielder = parse_element (element (cls, fields(2)))
    val mwbase: Fielder = parse_element (element (cls, fields(3)))
    val pmax: Fielder = parse_element (element (cls, fields(4)))
    val pmin: Fielder = parse_element (element (cls, fields(5)))
    val t1: Fielder = parse_element (element (cls, fields(6)))
    val t2: Fielder = parse_element (element (cls, fields(7)))
    val t3: Fielder = parse_element (element (cls, fields(8)))
    val t4: Fielder = parse_element (element (cls, fields(9)))
    val t5: Fielder = parse_element (element (cls, fields(10)))
    val t6: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): GovSteamSGO =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GovSteamSGO (
            TurbineGovernorDynamics.parse (context),
            toDouble (mask (k1 (), 0)),
            toDouble (mask (k2 (), 1)),
            toDouble (mask (k3 (), 2)),
            toDouble (mask (mwbase (), 3)),
            toDouble (mask (pmax (), 4)),
            toDouble (mask (pmin (), 5)),
            toDouble (mask (t1 (), 6)),
            toDouble (mask (t2 (), 7)),
            toDouble (mask (t3 (), 8)),
            toDouble (mask (t4 (), 9)),
            toDouble (mask (t5 (), 10)),
            toDouble (mask (t6 (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Turbine-governor function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Asynchronous machine model with which this turbine-governor model is associated.
 *        TurbineGovernorDynamics shall have either an association to SynchronousMachineDynamics or to AsynchronousMachineDynamics.
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Synchronous machine model with which this turbine-governor model is associated.
 *        TurbineGovernorDynamics shall have either an association to SynchronousMachineDynamics or to AsynchronousMachineDynamics.
 * @param TurbineLoadControllerDynamics [[ch.ninecode.model.TurbineLoadControllerDynamics TurbineLoadControllerDynamics]] Turbine load controller providing input to this turbine-governor.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 */
final case class TurbineGovernorDynamics
(
    override val sup: DynamicsFunctionBlock = null,
    AsynchronousMachineDynamics: String = null,
    SynchronousMachineDynamics: String = null,
    TurbineLoadControllerDynamics: String = null
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[TurbineGovernorDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineGovernorDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TurbineGovernorDynamics.fields (position), value)
        emitattr (0, AsynchronousMachineDynamics)
        emitattr (1, SynchronousMachineDynamics)
        emitattr (2, TurbineLoadControllerDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TurbineGovernorDynamics rdf:ID=\"%s\">\n%s\t</cim:TurbineGovernorDynamics>".format (id, export_fields)
    }
}

object TurbineGovernorDynamics
extends
    Parseable[TurbineGovernorDynamics]
{
    override val fields: Array[String] = Array[String] (
        "AsynchronousMachineDynamics",
        "SynchronousMachineDynamics",
        "TurbineLoadControllerDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AsynchronousMachineDynamics", "AsynchronousMachineDynamics", "0..1", "0..1"),
        Relationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "0..1", "0..*"),
        Relationship ("TurbineLoadControllerDynamics", "TurbineLoadControllerDynamics", "0..1", "1")
    )
    val AsynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TurbineLoadControllerDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): TurbineGovernorDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TurbineGovernorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (AsynchronousMachineDynamics (), 0),
            mask (SynchronousMachineDynamics (), 1),
            mask (TurbineLoadControllerDynamics (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _TurbineGovernorDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            CrossCompoundTurbineGovernorDynamics.register,
            GovCT1.register,
            GovCT2.register,
            GovGAST.register,
            GovGAST1.register,
            GovGAST2.register,
            GovGAST3.register,
            GovGAST4.register,
            GovGASTWD.register,
            GovHydro1.register,
            GovHydro2.register,
            GovHydro3.register,
            GovHydro4.register,
            GovHydroDD.register,
            GovHydroFrancis.register,
            GovHydroIEEE0.register,
            GovHydroIEEE2.register,
            GovHydroPID.register,
            GovHydroPID2.register,
            GovHydroPelton.register,
            GovHydroR.register,
            GovHydroWEH.register,
            GovHydroWPID.register,
            GovSteam0.register,
            GovSteam1.register,
            GovSteam2.register,
            GovSteamBB.register,
            GovSteamCC.register,
            GovSteamEU.register,
            GovSteamFV2.register,
            GovSteamFV3.register,
            GovSteamFV4.register,
            GovSteamIEEE1.register,
            GovSteamSGO.register,
            TurbineGovernorDynamics.register
        )
    }
}