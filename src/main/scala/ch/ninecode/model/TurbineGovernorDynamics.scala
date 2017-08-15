package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * General model for any prime mover with a PID governor, used primarily for combustion turbine and combined cycle units.
 *
 * This model can be used to represent a variety of prime movers controlled by PID governors.  It is suitable, for example, for representation of
 *
 * @param sup Reference to the superclass object.
 * @param aset Acceleration limiter setpoint (Aset).
 *        Unit = PU/sec.  Typical Value = 0.01.
 * @param db Speed governor dead band in per unit speed (db).
 *        In the majority of applications, it is recommended that this value be set to zero.  Typical Value = 0.
 * @param dm Speed sensitivity coefficient (Dm).
 *        Dm can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.  If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical Value = 0.
 * @param ka Acceleration limiter gain (Ka).
 *        Typical Value = 10.
 * @param kdgov Governor derivative gain (Kdgov).
 *        Typical Value = 0.
 * @param kigov Governor integral gain (Kigov).
 *        Typical Value = 2.
 * @param kiload Load limiter integral gain for PI controller (Kiload).
 *        Typical Value = 0.67.
 * @param kimw Power controller (reset) gain (Kimw).
 *        The default value of 0.01 corresponds to a reset time of 100 seconds.  A value of 0.001 corresponds to a relatively slow acting load controller.  Typical Value = 0.01.
 * @param kpgov Governor proportional gain (Kpgov).
 *        Typical Value = 10.
 * @param kpload Load limiter proportional gain for PI controller (Kpload).
 *        Typical Value = 2.
 * @param kturb Turbine gain (Kturb) (&gt;0).
 *        Typical Value = 1.5.
 * @param ldref Load limiter reference value (Ldref).
 *        Typical Value = 1.
 * @param maxerr Maximum value for speed error signal (maxerr).
 *        Typical Value = 0.05.
 * @param minerr Minimum value for speed error signal (minerr).
 *        Typical Value = -0.05.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param r Permanent droop (R).
 *        Typical Value = 0.04.
 * @param rclose Minimum valve closing rate (Rclose).
 *        Unit = PU/sec.  Typical Value = -0.1.
 * @param rdown Maximum rate of load limit decrease (Rdown).
 *        Typical Value = -99.
 * @param ropen Maximum valve opening rate (Ropen).
 *        Unit = PU/sec.  Typical Value = 0.10.
 * @param rselect Feedback signal for droop (Rselect).
 *        Typical Value = electricalPower.
 * @param rup Maximum rate of load limit increase (Rup).
 *        Typical Value = 99.
 * @param ta Acceleration limiter time constant (Ta) (&gt;0).
 *        Typical Value = 0.1.
 * @param tact Actuator time constant (Tact).
 *        Typical Value = 0.5.
 * @param tb Turbine lag time constant (Tb) (&gt;0).
 *        Typical Value = 0.5.
 * @param tc Turbine lead time constant (Tc).
 *        Typical Value = 0.
 * @param tdgov Governor derivative controller time constant (Tdgov).
 *        Typical Value = 1.
 * @param teng Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (Teng).
 *        Teng should be zero in all but special cases where this transport delay is of particular concern.  Typical Value = 0.
 * @param tfload Load Limiter time constant (Tfload) (&gt;0).
 *        Typical Value = 3.
 * @param tpelec Electrical power transducer time constant (Tpelec) (&gt;0).
 *        Typical Value = 1.
 * @param tsa Temperature detection lead time constant (Tsa).
 *        Typical Value = 4.
 * @param tsb Temperature detection lag time constant (Tsb).
 *        Typical Value = 5.
 * @param vmax Maximum valve position limit (Vmax).
 *        Typical Value = 1.
 * @param vmin Minimum valve position limit (Vmin).
 *        Typical Value = 0.15.
 * @param wfnl No load fuel flow (Wfnl).
 *        Typical Value = 0.2.
 * @param wfspd Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (Wfspd).
 *        true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
 *        false = fuel control system keeps fuel flow independent of engine speed.
 *        Typical Value = true.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovCT1
(
    override val sup: TurbineGovernorDynamics,
    aset: Double,
    db: Double,
    dm: Double,
    ka: Double,
    kdgov: Double,
    kigov: Double,
    kiload: Double,
    kimw: Double,
    kpgov: Double,
    kpload: Double,
    kturb: Double,
    ldref: Double,
    maxerr: Double,
    minerr: Double,
    mwbase: Double,
    r: Double,
    rclose: Double,
    rdown: Double,
    ropen: Double,
    rselect: String,
    rup: Double,
    ta: Double,
    tact: Double,
    tb: Double,
    tc: Double,
    tdgov: Double,
    teng: Double,
    tfload: Double,
    tpelec: Double,
    tsa: Double,
    tsb: Double,
    vmax: Double,
    vmin: Double,
    wfnl: Double,
    wfspd: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovCT1.aset>" + aset + "</cim:GovCT1.aset>\n" +
        "\t\t<cim:GovCT1.db>" + db + "</cim:GovCT1.db>\n" +
        "\t\t<cim:GovCT1.dm>" + dm + "</cim:GovCT1.dm>\n" +
        "\t\t<cim:GovCT1.ka>" + ka + "</cim:GovCT1.ka>\n" +
        "\t\t<cim:GovCT1.kdgov>" + kdgov + "</cim:GovCT1.kdgov>\n" +
        "\t\t<cim:GovCT1.kigov>" + kigov + "</cim:GovCT1.kigov>\n" +
        "\t\t<cim:GovCT1.kiload>" + kiload + "</cim:GovCT1.kiload>\n" +
        "\t\t<cim:GovCT1.kimw>" + kimw + "</cim:GovCT1.kimw>\n" +
        "\t\t<cim:GovCT1.kpgov>" + kpgov + "</cim:GovCT1.kpgov>\n" +
        "\t\t<cim:GovCT1.kpload>" + kpload + "</cim:GovCT1.kpload>\n" +
        "\t\t<cim:GovCT1.kturb>" + kturb + "</cim:GovCT1.kturb>\n" +
        "\t\t<cim:GovCT1.ldref>" + ldref + "</cim:GovCT1.ldref>\n" +
        "\t\t<cim:GovCT1.maxerr>" + maxerr + "</cim:GovCT1.maxerr>\n" +
        "\t\t<cim:GovCT1.minerr>" + minerr + "</cim:GovCT1.minerr>\n" +
        "\t\t<cim:GovCT1.mwbase>" + mwbase + "</cim:GovCT1.mwbase>\n" +
        "\t\t<cim:GovCT1.r>" + r + "</cim:GovCT1.r>\n" +
        "\t\t<cim:GovCT1.rclose>" + rclose + "</cim:GovCT1.rclose>\n" +
        "\t\t<cim:GovCT1.rdown>" + rdown + "</cim:GovCT1.rdown>\n" +
        "\t\t<cim:GovCT1.ropen>" + ropen + "</cim:GovCT1.ropen>\n" +
        (if (null != rselect) "\t\t<cim:GovCT1.rselect rdf:resource=\"#" + rselect + "\"/>\n" else "") +
        "\t\t<cim:GovCT1.rup>" + rup + "</cim:GovCT1.rup>\n" +
        "\t\t<cim:GovCT1.ta>" + ta + "</cim:GovCT1.ta>\n" +
        "\t\t<cim:GovCT1.tact>" + tact + "</cim:GovCT1.tact>\n" +
        "\t\t<cim:GovCT1.tb>" + tb + "</cim:GovCT1.tb>\n" +
        "\t\t<cim:GovCT1.tc>" + tc + "</cim:GovCT1.tc>\n" +
        "\t\t<cim:GovCT1.tdgov>" + tdgov + "</cim:GovCT1.tdgov>\n" +
        "\t\t<cim:GovCT1.teng>" + teng + "</cim:GovCT1.teng>\n" +
        "\t\t<cim:GovCT1.tfload>" + tfload + "</cim:GovCT1.tfload>\n" +
        "\t\t<cim:GovCT1.tpelec>" + tpelec + "</cim:GovCT1.tpelec>\n" +
        "\t\t<cim:GovCT1.tsa>" + tsa + "</cim:GovCT1.tsa>\n" +
        "\t\t<cim:GovCT1.tsb>" + tsb + "</cim:GovCT1.tsb>\n" +
        "\t\t<cim:GovCT1.vmax>" + vmax + "</cim:GovCT1.vmax>\n" +
        "\t\t<cim:GovCT1.vmin>" + vmin + "</cim:GovCT1.vmin>\n" +
        "\t\t<cim:GovCT1.wfnl>" + wfnl + "</cim:GovCT1.wfnl>\n" +
        "\t\t<cim:GovCT1.wfspd>" + wfspd + "</cim:GovCT1.wfspd>\n"
    }
    override def export: String =
    {
        "\t<cim:GovCT1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovCT1>"
    }
}

object GovCT1
extends
    Parseable[GovCT1]
{
    val aset = parse_element (element ("""GovCT1.aset"""))
    val db = parse_element (element ("""GovCT1.db"""))
    val dm = parse_element (element ("""GovCT1.dm"""))
    val ka = parse_element (element ("""GovCT1.ka"""))
    val kdgov = parse_element (element ("""GovCT1.kdgov"""))
    val kigov = parse_element (element ("""GovCT1.kigov"""))
    val kiload = parse_element (element ("""GovCT1.kiload"""))
    val kimw = parse_element (element ("""GovCT1.kimw"""))
    val kpgov = parse_element (element ("""GovCT1.kpgov"""))
    val kpload = parse_element (element ("""GovCT1.kpload"""))
    val kturb = parse_element (element ("""GovCT1.kturb"""))
    val ldref = parse_element (element ("""GovCT1.ldref"""))
    val maxerr = parse_element (element ("""GovCT1.maxerr"""))
    val minerr = parse_element (element ("""GovCT1.minerr"""))
    val mwbase = parse_element (element ("""GovCT1.mwbase"""))
    val r = parse_element (element ("""GovCT1.r"""))
    val rclose = parse_element (element ("""GovCT1.rclose"""))
    val rdown = parse_element (element ("""GovCT1.rdown"""))
    val ropen = parse_element (element ("""GovCT1.ropen"""))
    val rselect = parse_attribute (attribute ("""GovCT1.rselect"""))
    val rup = parse_element (element ("""GovCT1.rup"""))
    val ta = parse_element (element ("""GovCT1.ta"""))
    val tact = parse_element (element ("""GovCT1.tact"""))
    val tb = parse_element (element ("""GovCT1.tb"""))
    val tc = parse_element (element ("""GovCT1.tc"""))
    val tdgov = parse_element (element ("""GovCT1.tdgov"""))
    val teng = parse_element (element ("""GovCT1.teng"""))
    val tfload = parse_element (element ("""GovCT1.tfload"""))
    val tpelec = parse_element (element ("""GovCT1.tpelec"""))
    val tsa = parse_element (element ("""GovCT1.tsa"""))
    val tsb = parse_element (element ("""GovCT1.tsb"""))
    val vmax = parse_element (element ("""GovCT1.vmax"""))
    val vmin = parse_element (element ("""GovCT1.vmin"""))
    val wfnl = parse_element (element ("""GovCT1.wfnl"""))
    val wfspd = parse_element (element ("""GovCT1.wfspd"""))
    def parse (context: Context): GovCT1 =
    {
        GovCT1(
            TurbineGovernorDynamics.parse (context),
            toDouble (aset (context), context),
            toDouble (db (context), context),
            toDouble (dm (context), context),
            toDouble (ka (context), context),
            toDouble (kdgov (context), context),
            toDouble (kigov (context), context),
            toDouble (kiload (context), context),
            toDouble (kimw (context), context),
            toDouble (kpgov (context), context),
            toDouble (kpload (context), context),
            toDouble (kturb (context), context),
            toDouble (ldref (context), context),
            toDouble (maxerr (context), context),
            toDouble (minerr (context), context),
            toDouble (mwbase (context), context),
            toDouble (r (context), context),
            toDouble (rclose (context), context),
            toDouble (rdown (context), context),
            toDouble (ropen (context), context),
            rselect (context),
            toDouble (rup (context), context),
            toDouble (ta (context), context),
            toDouble (tact (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (tdgov (context), context),
            toDouble (teng (context), context),
            toDouble (tfload (context), context),
            toDouble (tpelec (context), context),
            toDouble (tsa (context), context),
            toDouble (tsb (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context),
            toDouble (wfnl (context), context),
            toBoolean (wfspd (context), context)
        )
    }
}

/**
 * General governor model with frequency-dependent fuel flow limit.
 *
 * This model is a modification of the GovCT1<b> </b>model in order to represent the frequency-dependent fuel flow limit of a specific gas turbine manufacturer.
 *
 * @param sup Reference to the superclass object.
 * @param aset Acceleration limiter setpoint (Aset).
 *        Unit = PU/sec.  Typical Value = 10.
 * @param db Speed governor dead band in per unit speed (db).
 *        In the majority of applications, it is recommended that this value be set to zero.  Typical Value = 0.
 * @param dm Speed sensitivity coefficient (Dm).
 *        Dm can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.  If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical Value = 0.
 * @param flim1 Frequency threshold 1 (Flim1).
 *        Unit = Hz.  Typical Value = 59.
 * @param flim10 Frequency threshold 10 (Flim10).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim2 Frequency threshold 2 (Flim2).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim3 Frequency threshold 3 (Flim3).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim4 Frequency threshold 4 (Flim4).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim5 Frequency threshold 5 (Flim5).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim6 Frequency threshold 6 (Flim6).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim7 Frequency threshold 7 (Flim7).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim8 Frequency threshold 8 (Flim8).
 *        Unit = Hz.  Typical Value = 0.
 * @param flim9 Frequency threshold 9 (Flim9).
 *        Unit = Hz.  Typical Value = 0.
 * @param ka Acceleration limiter Gain (Ka).
 *        Typical Value = 10.
 * @param kdgov Governor derivative gain (Kdgov).
 *        Typical Value = 0.
 * @param kigov Governor integral gain (Kigov).
 *        Typical Value = 0.45.
 * @param kiload Load limiter integral gain for PI controller (Kiload).
 *        Typical Value = 1.
 * @param kimw Power controller (reset) gain (Kimw).
 *        The default value of 0.01 corresponds to a reset time of 100 seconds.  A value of 0.001 corresponds to a relatively slow acting load controller.  Typical Value = 0.
 * @param kpgov Governor proportional gain (Kpgov).
 *        Typical Value = 4.
 * @param kpload Load limiter proportional gain for PI controller (Kpload).
 *        Typical Value = 1.
 * @param kturb Turbine gain (Kturb).
 *        Typical Value = 1.9168.
 * @param ldref Load limiter reference value (Ldref).
 *        Typical Value = 1.
 * @param maxerr Maximum value for speed error signal (Maxerr).
 *        Typical Value = 1.
 * @param minerr Minimum value for speed error signal (Minerr).
 *        Typical Value = -1.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param plim1 Power limit 1 (Plim1).
 *        Typical Value = 0.8325.
 * @param plim10 Power limit 10 (Plim10).
 *        Typical Value = 0.
 * @param plim2 Power limit 2 (Plim2).
 *        Typical Value = 0.
 * @param plim3 Power limit 3 (Plim3).
 *        Typical Value = 0.
 * @param plim4 Power limit 4 (Plim4).
 *        Typical Value = 0.
 * @param plim5 Power limit 5 (Plim5).
 *        Typical Value = 0.
 * @param plim6 Power limit 6 (Plim6).
 *        Typical Value = 0.
 * @param plim7 Power limit 7 (Plim7).
 *        Typical Value = 0.
 * @param plim8 Power limit 8 (Plim8).
 *        Typical Value = 0.
 * @param plim9 Power Limit 9 (Plim9).
 *        Typical Value = 0.
 * @param prate Ramp rate for frequency-dependent power limit (Prate).
 *        Typical Value = 0.017.
 * @param r Permanent droop (R).
 *        Typical Value = 0.05.
 * @param rclose Minimum valve closing rate (Rclose).
 *        Unit = PU/sec.  Typical Value = -99.
 * @param rdown Maximum rate of load limit decrease (Rdown).
 *        Typical Value = -99.
 * @param ropen Maximum valve opening rate (Ropen).
 *        Unit = PU/sec.  Typical Value = 99.
 * @param rselect Feedback signal for droop (Rselect).
 *        Typical Value = electricalPower.
 * @param rup Maximum rate of load limit increase (Rup).
 *        Typical Value = 99.
 * @param ta Acceleration limiter time constant (Ta).
 *        Typical Value = 1.
 * @param tact Actuator time constant (Tact).
 *        Typical Value = 0.4.
 * @param tb Turbine lag time constant (Tb).
 *        Typical Value = 0.1.
 * @param tc Turbine lead time constant (Tc).
 *        Typical Value = 0.
 * @param tdgov Governor derivative controller time constant (Tdgov).
 *        Typical Value = 1.
 * @param teng Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (Teng).
 *        Teng should be zero in all but special cases where this transport delay is of particular concern.  Typical Value = 0.
 * @param tfload Load Limiter time constant (Tfload).
 *        Typical Value = 3.
 * @param tpelec Electrical power transducer time constant (Tpelec).
 *        Typical Value = 2.5.
 * @param tsa Temperature detection lead time constant (Tsa).
 *        Typical Value = 0.
 * @param tsb Temperature detection lag time constant (Tsb).
 *        Typical Value = 50.
 * @param vmax Maximum valve position limit (Vmax).
 *        Typical Value = 1.
 * @param vmin Minimum valve position limit (Vmin).
 *        Typical Value = 0.175.
 * @param wfnl No load fuel flow (Wfnl).
 *        Typical Value = 0.187.
 * @param wfspd Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (Wfspd).
 *        true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
 *        false = fuel control system keeps fuel flow independent of engine speed.
 *        Typical Value = false.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovCT2
(
    override val sup: TurbineGovernorDynamics,
    aset: Double,
    db: Double,
    dm: Double,
    flim1: Double,
    flim10: Double,
    flim2: Double,
    flim3: Double,
    flim4: Double,
    flim5: Double,
    flim6: Double,
    flim7: Double,
    flim8: Double,
    flim9: Double,
    ka: Double,
    kdgov: Double,
    kigov: Double,
    kiload: Double,
    kimw: Double,
    kpgov: Double,
    kpload: Double,
    kturb: Double,
    ldref: Double,
    maxerr: Double,
    minerr: Double,
    mwbase: Double,
    plim1: Double,
    plim10: Double,
    plim2: Double,
    plim3: Double,
    plim4: Double,
    plim5: Double,
    plim6: Double,
    plim7: Double,
    plim8: Double,
    plim9: Double,
    prate: Double,
    r: Double,
    rclose: Double,
    rdown: Double,
    ropen: Double,
    rselect: String,
    rup: Double,
    ta: Double,
    tact: Double,
    tb: Double,
    tc: Double,
    tdgov: Double,
    teng: Double,
    tfload: Double,
    tpelec: Double,
    tsa: Double,
    tsb: Double,
    vmax: Double,
    vmin: Double,
    wfnl: Double,
    wfspd: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovCT2.aset>" + aset + "</cim:GovCT2.aset>\n" +
        "\t\t<cim:GovCT2.db>" + db + "</cim:GovCT2.db>\n" +
        "\t\t<cim:GovCT2.dm>" + dm + "</cim:GovCT2.dm>\n" +
        "\t\t<cim:GovCT2.flim1>" + flim1 + "</cim:GovCT2.flim1>\n" +
        "\t\t<cim:GovCT2.flim10>" + flim10 + "</cim:GovCT2.flim10>\n" +
        "\t\t<cim:GovCT2.flim2>" + flim2 + "</cim:GovCT2.flim2>\n" +
        "\t\t<cim:GovCT2.flim3>" + flim3 + "</cim:GovCT2.flim3>\n" +
        "\t\t<cim:GovCT2.flim4>" + flim4 + "</cim:GovCT2.flim4>\n" +
        "\t\t<cim:GovCT2.flim5>" + flim5 + "</cim:GovCT2.flim5>\n" +
        "\t\t<cim:GovCT2.flim6>" + flim6 + "</cim:GovCT2.flim6>\n" +
        "\t\t<cim:GovCT2.flim7>" + flim7 + "</cim:GovCT2.flim7>\n" +
        "\t\t<cim:GovCT2.flim8>" + flim8 + "</cim:GovCT2.flim8>\n" +
        "\t\t<cim:GovCT2.flim9>" + flim9 + "</cim:GovCT2.flim9>\n" +
        "\t\t<cim:GovCT2.ka>" + ka + "</cim:GovCT2.ka>\n" +
        "\t\t<cim:GovCT2.kdgov>" + kdgov + "</cim:GovCT2.kdgov>\n" +
        "\t\t<cim:GovCT2.kigov>" + kigov + "</cim:GovCT2.kigov>\n" +
        "\t\t<cim:GovCT2.kiload>" + kiload + "</cim:GovCT2.kiload>\n" +
        "\t\t<cim:GovCT2.kimw>" + kimw + "</cim:GovCT2.kimw>\n" +
        "\t\t<cim:GovCT2.kpgov>" + kpgov + "</cim:GovCT2.kpgov>\n" +
        "\t\t<cim:GovCT2.kpload>" + kpload + "</cim:GovCT2.kpload>\n" +
        "\t\t<cim:GovCT2.kturb>" + kturb + "</cim:GovCT2.kturb>\n" +
        "\t\t<cim:GovCT2.ldref>" + ldref + "</cim:GovCT2.ldref>\n" +
        "\t\t<cim:GovCT2.maxerr>" + maxerr + "</cim:GovCT2.maxerr>\n" +
        "\t\t<cim:GovCT2.minerr>" + minerr + "</cim:GovCT2.minerr>\n" +
        "\t\t<cim:GovCT2.mwbase>" + mwbase + "</cim:GovCT2.mwbase>\n" +
        "\t\t<cim:GovCT2.plim1>" + plim1 + "</cim:GovCT2.plim1>\n" +
        "\t\t<cim:GovCT2.plim10>" + plim10 + "</cim:GovCT2.plim10>\n" +
        "\t\t<cim:GovCT2.plim2>" + plim2 + "</cim:GovCT2.plim2>\n" +
        "\t\t<cim:GovCT2.plim3>" + plim3 + "</cim:GovCT2.plim3>\n" +
        "\t\t<cim:GovCT2.plim4>" + plim4 + "</cim:GovCT2.plim4>\n" +
        "\t\t<cim:GovCT2.plim5>" + plim5 + "</cim:GovCT2.plim5>\n" +
        "\t\t<cim:GovCT2.plim6>" + plim6 + "</cim:GovCT2.plim6>\n" +
        "\t\t<cim:GovCT2.plim7>" + plim7 + "</cim:GovCT2.plim7>\n" +
        "\t\t<cim:GovCT2.plim8>" + plim8 + "</cim:GovCT2.plim8>\n" +
        "\t\t<cim:GovCT2.plim9>" + plim9 + "</cim:GovCT2.plim9>\n" +
        "\t\t<cim:GovCT2.prate>" + prate + "</cim:GovCT2.prate>\n" +
        "\t\t<cim:GovCT2.r>" + r + "</cim:GovCT2.r>\n" +
        "\t\t<cim:GovCT2.rclose>" + rclose + "</cim:GovCT2.rclose>\n" +
        "\t\t<cim:GovCT2.rdown>" + rdown + "</cim:GovCT2.rdown>\n" +
        "\t\t<cim:GovCT2.ropen>" + ropen + "</cim:GovCT2.ropen>\n" +
        (if (null != rselect) "\t\t<cim:GovCT2.rselect rdf:resource=\"#" + rselect + "\"/>\n" else "") +
        "\t\t<cim:GovCT2.rup>" + rup + "</cim:GovCT2.rup>\n" +
        "\t\t<cim:GovCT2.ta>" + ta + "</cim:GovCT2.ta>\n" +
        "\t\t<cim:GovCT2.tact>" + tact + "</cim:GovCT2.tact>\n" +
        "\t\t<cim:GovCT2.tb>" + tb + "</cim:GovCT2.tb>\n" +
        "\t\t<cim:GovCT2.tc>" + tc + "</cim:GovCT2.tc>\n" +
        "\t\t<cim:GovCT2.tdgov>" + tdgov + "</cim:GovCT2.tdgov>\n" +
        "\t\t<cim:GovCT2.teng>" + teng + "</cim:GovCT2.teng>\n" +
        "\t\t<cim:GovCT2.tfload>" + tfload + "</cim:GovCT2.tfload>\n" +
        "\t\t<cim:GovCT2.tpelec>" + tpelec + "</cim:GovCT2.tpelec>\n" +
        "\t\t<cim:GovCT2.tsa>" + tsa + "</cim:GovCT2.tsa>\n" +
        "\t\t<cim:GovCT2.tsb>" + tsb + "</cim:GovCT2.tsb>\n" +
        "\t\t<cim:GovCT2.vmax>" + vmax + "</cim:GovCT2.vmax>\n" +
        "\t\t<cim:GovCT2.vmin>" + vmin + "</cim:GovCT2.vmin>\n" +
        "\t\t<cim:GovCT2.wfnl>" + wfnl + "</cim:GovCT2.wfnl>\n" +
        "\t\t<cim:GovCT2.wfspd>" + wfspd + "</cim:GovCT2.wfspd>\n"
    }
    override def export: String =
    {
        "\t<cim:GovCT2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovCT2>"
    }
}

object GovCT2
extends
    Parseable[GovCT2]
{
    val aset = parse_element (element ("""GovCT2.aset"""))
    val db = parse_element (element ("""GovCT2.db"""))
    val dm = parse_element (element ("""GovCT2.dm"""))
    val flim1 = parse_element (element ("""GovCT2.flim1"""))
    val flim10 = parse_element (element ("""GovCT2.flim10"""))
    val flim2 = parse_element (element ("""GovCT2.flim2"""))
    val flim3 = parse_element (element ("""GovCT2.flim3"""))
    val flim4 = parse_element (element ("""GovCT2.flim4"""))
    val flim5 = parse_element (element ("""GovCT2.flim5"""))
    val flim6 = parse_element (element ("""GovCT2.flim6"""))
    val flim7 = parse_element (element ("""GovCT2.flim7"""))
    val flim8 = parse_element (element ("""GovCT2.flim8"""))
    val flim9 = parse_element (element ("""GovCT2.flim9"""))
    val ka = parse_element (element ("""GovCT2.ka"""))
    val kdgov = parse_element (element ("""GovCT2.kdgov"""))
    val kigov = parse_element (element ("""GovCT2.kigov"""))
    val kiload = parse_element (element ("""GovCT2.kiload"""))
    val kimw = parse_element (element ("""GovCT2.kimw"""))
    val kpgov = parse_element (element ("""GovCT2.kpgov"""))
    val kpload = parse_element (element ("""GovCT2.kpload"""))
    val kturb = parse_element (element ("""GovCT2.kturb"""))
    val ldref = parse_element (element ("""GovCT2.ldref"""))
    val maxerr = parse_element (element ("""GovCT2.maxerr"""))
    val minerr = parse_element (element ("""GovCT2.minerr"""))
    val mwbase = parse_element (element ("""GovCT2.mwbase"""))
    val plim1 = parse_element (element ("""GovCT2.plim1"""))
    val plim10 = parse_element (element ("""GovCT2.plim10"""))
    val plim2 = parse_element (element ("""GovCT2.plim2"""))
    val plim3 = parse_element (element ("""GovCT2.plim3"""))
    val plim4 = parse_element (element ("""GovCT2.plim4"""))
    val plim5 = parse_element (element ("""GovCT2.plim5"""))
    val plim6 = parse_element (element ("""GovCT2.plim6"""))
    val plim7 = parse_element (element ("""GovCT2.plim7"""))
    val plim8 = parse_element (element ("""GovCT2.plim8"""))
    val plim9 = parse_element (element ("""GovCT2.plim9"""))
    val prate = parse_element (element ("""GovCT2.prate"""))
    val r = parse_element (element ("""GovCT2.r"""))
    val rclose = parse_element (element ("""GovCT2.rclose"""))
    val rdown = parse_element (element ("""GovCT2.rdown"""))
    val ropen = parse_element (element ("""GovCT2.ropen"""))
    val rselect = parse_attribute (attribute ("""GovCT2.rselect"""))
    val rup = parse_element (element ("""GovCT2.rup"""))
    val ta = parse_element (element ("""GovCT2.ta"""))
    val tact = parse_element (element ("""GovCT2.tact"""))
    val tb = parse_element (element ("""GovCT2.tb"""))
    val tc = parse_element (element ("""GovCT2.tc"""))
    val tdgov = parse_element (element ("""GovCT2.tdgov"""))
    val teng = parse_element (element ("""GovCT2.teng"""))
    val tfload = parse_element (element ("""GovCT2.tfload"""))
    val tpelec = parse_element (element ("""GovCT2.tpelec"""))
    val tsa = parse_element (element ("""GovCT2.tsa"""))
    val tsb = parse_element (element ("""GovCT2.tsb"""))
    val vmax = parse_element (element ("""GovCT2.vmax"""))
    val vmin = parse_element (element ("""GovCT2.vmin"""))
    val wfnl = parse_element (element ("""GovCT2.wfnl"""))
    val wfspd = parse_element (element ("""GovCT2.wfspd"""))
    def parse (context: Context): GovCT2 =
    {
        GovCT2(
            TurbineGovernorDynamics.parse (context),
            toDouble (aset (context), context),
            toDouble (db (context), context),
            toDouble (dm (context), context),
            toDouble (flim1 (context), context),
            toDouble (flim10 (context), context),
            toDouble (flim2 (context), context),
            toDouble (flim3 (context), context),
            toDouble (flim4 (context), context),
            toDouble (flim5 (context), context),
            toDouble (flim6 (context), context),
            toDouble (flim7 (context), context),
            toDouble (flim8 (context), context),
            toDouble (flim9 (context), context),
            toDouble (ka (context), context),
            toDouble (kdgov (context), context),
            toDouble (kigov (context), context),
            toDouble (kiload (context), context),
            toDouble (kimw (context), context),
            toDouble (kpgov (context), context),
            toDouble (kpload (context), context),
            toDouble (kturb (context), context),
            toDouble (ldref (context), context),
            toDouble (maxerr (context), context),
            toDouble (minerr (context), context),
            toDouble (mwbase (context), context),
            toDouble (plim1 (context), context),
            toDouble (plim10 (context), context),
            toDouble (plim2 (context), context),
            toDouble (plim3 (context), context),
            toDouble (plim4 (context), context),
            toDouble (plim5 (context), context),
            toDouble (plim6 (context), context),
            toDouble (plim7 (context), context),
            toDouble (plim8 (context), context),
            toDouble (plim9 (context), context),
            toDouble (prate (context), context),
            toDouble (r (context), context),
            toDouble (rclose (context), context),
            toDouble (rdown (context), context),
            toDouble (ropen (context), context),
            rselect (context),
            toDouble (rup (context), context),
            toDouble (ta (context), context),
            toDouble (tact (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (tdgov (context), context),
            toDouble (teng (context), context),
            toDouble (tfload (context), context),
            toDouble (tpelec (context), context),
            toDouble (tsa (context), context),
            toDouble (tsb (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context),
            toDouble (wfnl (context), context),
            toBoolean (wfspd (context), context)
        )
    }
}

/**
 * Single shaft gas turbine.
 *
 * @param sup Reference to the superclass object.
 * @param at Ambient temperature load limit (Load Limit).
 *        Typical Value = 1.
 * @param dturb Turbine damping factor (Dturb).
 *        Typical Value = 0.18.
 * @param kt Temperature limiter gain (Kt).
 *        Typical Value = 3.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 * @param r Permanent droop (R).
 *        Typical Value = 0.04.
 * @param t1 Governor mechanism time constant (T1).
 *        T1 represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.  Typical Value = 0.5.
 * @param t2 Turbine power time constant (T2).
 *        T2 represents delay due to internal energy storage of the gas turbine engine. T2 can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of a the free power turbine of an aero-derivative unit, for example.  Typical Value = 0.5.
 * @param t3 Turbine exhaust temperature time constant (T3).
 *        Typical Value = 3.
 * @param vmax Maximum turbine power, PU of MWbase (Vmax).
 *        Typical Value = 1.
 * @param vmin Minimum turbine power, PU of MWbase (Vmin).
 *        Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGAST
(
    override val sup: TurbineGovernorDynamics,
    at: Double,
    dturb: Double,
    kt: Double,
    mwbase: Double,
    r: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    vmax: Double,
    vmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovGAST.at>" + at + "</cim:GovGAST.at>\n" +
        "\t\t<cim:GovGAST.dturb>" + dturb + "</cim:GovGAST.dturb>\n" +
        "\t\t<cim:GovGAST.kt>" + kt + "</cim:GovGAST.kt>\n" +
        "\t\t<cim:GovGAST.mwbase>" + mwbase + "</cim:GovGAST.mwbase>\n" +
        "\t\t<cim:GovGAST.r>" + r + "</cim:GovGAST.r>\n" +
        "\t\t<cim:GovGAST.t1>" + t1 + "</cim:GovGAST.t1>\n" +
        "\t\t<cim:GovGAST.t2>" + t2 + "</cim:GovGAST.t2>\n" +
        "\t\t<cim:GovGAST.t3>" + t3 + "</cim:GovGAST.t3>\n" +
        "\t\t<cim:GovGAST.vmax>" + vmax + "</cim:GovGAST.vmax>\n" +
        "\t\t<cim:GovGAST.vmin>" + vmin + "</cim:GovGAST.vmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGAST rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGAST>"
    }
}

object GovGAST
extends
    Parseable[GovGAST]
{
    val at = parse_element (element ("""GovGAST.at"""))
    val dturb = parse_element (element ("""GovGAST.dturb"""))
    val kt = parse_element (element ("""GovGAST.kt"""))
    val mwbase = parse_element (element ("""GovGAST.mwbase"""))
    val r = parse_element (element ("""GovGAST.r"""))
    val t1 = parse_element (element ("""GovGAST.t1"""))
    val t2 = parse_element (element ("""GovGAST.t2"""))
    val t3 = parse_element (element ("""GovGAST.t3"""))
    val vmax = parse_element (element ("""GovGAST.vmax"""))
    val vmin = parse_element (element ("""GovGAST.vmin"""))
    def parse (context: Context): GovGAST =
    {
        GovGAST(
            TurbineGovernorDynamics.parse (context),
            toDouble (at (context), context),
            toDouble (dturb (context), context),
            toDouble (kt (context), context),
            toDouble (mwbase (context), context),
            toDouble (r (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context)
        )
    }
}

/**
 * Modified single shaft gas turbine.
 *
 * @param sup Reference to the superclass object.
 * @param a Turbine power time constant numerator scale factor (a).
 *        Typical Value = 0.8.
 * @param b Turbine power time constant denominator scale factor (b).
 *        Typical Value = 1.
 * @param db1 Intentional dead-band width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param fidle Fuel flow at zero power output (Fidle).
 *        Typical Value = 0.18.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2,PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param ka Governor gain (Ka).
 *        Typical Value = 0.
 * @param kt Temperature limiter gain (Kt).
 *        Typical Value = 3.
 * @param lmax Ambient temperature load limit (Lmax).
 *        Lmax is the turbine power output corresponding to the limiting exhaust gas temperature.  Typical Value = 1.
 * @param loadinc Valve position change allowed at fast rate (Loadinc).
 *        Typical Value = 0.05.
 * @param ltrate Maximum long term fuel valve opening rate (Ltrate).
 *        Typical Value = 0.02.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param r Permanent droop (R).
 *        Typical Value = 0.04.
 * @param rmax Maximum fuel valve opening rate (Rmax).
 *        Unit = PU/sec.  Typical Value = 1.
 * @param t1 Governor mechanism time constant (T1).
 *        T1 represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.  Typical Value = 0.5.
 * @param t2 Turbine power time constant (T2).
 *        T2 represents delay due to internal energy storage of the gas turbine engine. T2 can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of the free power turbine of an aero-derivative unit, for example.  Typical Value = 0.5.
 * @param t3 Turbine exhaust temperature time constant (T3).
 *        T3 represents delay in the exhaust temperature and load limiting system. Typical Value = 3.
 * @param t4 Governor lead time constant (T4).
 *        Typical Value = 0.
 * @param t5 Governor lag time constant (T5).
 *        Typical Value = 0.
 * @param tltr Valve position averaging time constant (Tltr).
 *        Typical Value = 10.
 * @param vmax Maximum turbine power, PU of MWbase (Vmax).
 *        Typical Value = 1.
 * @param vmin Minimum turbine power, PU of MWbase (Vmin).
 *        Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGAST1
(
    override val sup: TurbineGovernorDynamics,
    a: Double,
    b: Double,
    db1: Double,
    db2: Double,
    eps: Double,
    fidle: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    ka: Double,
    kt: Double,
    lmax: Double,
    loadinc: Double,
    ltrate: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    r: Double,
    rmax: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    tltr: Double,
    vmax: Double,
    vmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovGAST1.a>" + a + "</cim:GovGAST1.a>\n" +
        "\t\t<cim:GovGAST1.b>" + b + "</cim:GovGAST1.b>\n" +
        "\t\t<cim:GovGAST1.db1>" + db1 + "</cim:GovGAST1.db1>\n" +
        "\t\t<cim:GovGAST1.db2>" + db2 + "</cim:GovGAST1.db2>\n" +
        "\t\t<cim:GovGAST1.eps>" + eps + "</cim:GovGAST1.eps>\n" +
        "\t\t<cim:GovGAST1.fidle>" + fidle + "</cim:GovGAST1.fidle>\n" +
        "\t\t<cim:GovGAST1.gv1>" + gv1 + "</cim:GovGAST1.gv1>\n" +
        "\t\t<cim:GovGAST1.gv2>" + gv2 + "</cim:GovGAST1.gv2>\n" +
        "\t\t<cim:GovGAST1.gv3>" + gv3 + "</cim:GovGAST1.gv3>\n" +
        "\t\t<cim:GovGAST1.gv4>" + gv4 + "</cim:GovGAST1.gv4>\n" +
        "\t\t<cim:GovGAST1.gv5>" + gv5 + "</cim:GovGAST1.gv5>\n" +
        "\t\t<cim:GovGAST1.gv6>" + gv6 + "</cim:GovGAST1.gv6>\n" +
        "\t\t<cim:GovGAST1.ka>" + ka + "</cim:GovGAST1.ka>\n" +
        "\t\t<cim:GovGAST1.kt>" + kt + "</cim:GovGAST1.kt>\n" +
        "\t\t<cim:GovGAST1.lmax>" + lmax + "</cim:GovGAST1.lmax>\n" +
        "\t\t<cim:GovGAST1.loadinc>" + loadinc + "</cim:GovGAST1.loadinc>\n" +
        "\t\t<cim:GovGAST1.ltrate>" + ltrate + "</cim:GovGAST1.ltrate>\n" +
        "\t\t<cim:GovGAST1.mwbase>" + mwbase + "</cim:GovGAST1.mwbase>\n" +
        "\t\t<cim:GovGAST1.pgv1>" + pgv1 + "</cim:GovGAST1.pgv1>\n" +
        "\t\t<cim:GovGAST1.pgv2>" + pgv2 + "</cim:GovGAST1.pgv2>\n" +
        "\t\t<cim:GovGAST1.pgv3>" + pgv3 + "</cim:GovGAST1.pgv3>\n" +
        "\t\t<cim:GovGAST1.pgv4>" + pgv4 + "</cim:GovGAST1.pgv4>\n" +
        "\t\t<cim:GovGAST1.pgv5>" + pgv5 + "</cim:GovGAST1.pgv5>\n" +
        "\t\t<cim:GovGAST1.pgv6>" + pgv6 + "</cim:GovGAST1.pgv6>\n" +
        "\t\t<cim:GovGAST1.r>" + r + "</cim:GovGAST1.r>\n" +
        "\t\t<cim:GovGAST1.rmax>" + rmax + "</cim:GovGAST1.rmax>\n" +
        "\t\t<cim:GovGAST1.t1>" + t1 + "</cim:GovGAST1.t1>\n" +
        "\t\t<cim:GovGAST1.t2>" + t2 + "</cim:GovGAST1.t2>\n" +
        "\t\t<cim:GovGAST1.t3>" + t3 + "</cim:GovGAST1.t3>\n" +
        "\t\t<cim:GovGAST1.t4>" + t4 + "</cim:GovGAST1.t4>\n" +
        "\t\t<cim:GovGAST1.t5>" + t5 + "</cim:GovGAST1.t5>\n" +
        "\t\t<cim:GovGAST1.tltr>" + tltr + "</cim:GovGAST1.tltr>\n" +
        "\t\t<cim:GovGAST1.vmax>" + vmax + "</cim:GovGAST1.vmax>\n" +
        "\t\t<cim:GovGAST1.vmin>" + vmin + "</cim:GovGAST1.vmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGAST1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGAST1>"
    }
}

object GovGAST1
extends
    Parseable[GovGAST1]
{
    val a = parse_element (element ("""GovGAST1.a"""))
    val b = parse_element (element ("""GovGAST1.b"""))
    val db1 = parse_element (element ("""GovGAST1.db1"""))
    val db2 = parse_element (element ("""GovGAST1.db2"""))
    val eps = parse_element (element ("""GovGAST1.eps"""))
    val fidle = parse_element (element ("""GovGAST1.fidle"""))
    val gv1 = parse_element (element ("""GovGAST1.gv1"""))
    val gv2 = parse_element (element ("""GovGAST1.gv2"""))
    val gv3 = parse_element (element ("""GovGAST1.gv3"""))
    val gv4 = parse_element (element ("""GovGAST1.gv4"""))
    val gv5 = parse_element (element ("""GovGAST1.gv5"""))
    val gv6 = parse_element (element ("""GovGAST1.gv6"""))
    val ka = parse_element (element ("""GovGAST1.ka"""))
    val kt = parse_element (element ("""GovGAST1.kt"""))
    val lmax = parse_element (element ("""GovGAST1.lmax"""))
    val loadinc = parse_element (element ("""GovGAST1.loadinc"""))
    val ltrate = parse_element (element ("""GovGAST1.ltrate"""))
    val mwbase = parse_element (element ("""GovGAST1.mwbase"""))
    val pgv1 = parse_element (element ("""GovGAST1.pgv1"""))
    val pgv2 = parse_element (element ("""GovGAST1.pgv2"""))
    val pgv3 = parse_element (element ("""GovGAST1.pgv3"""))
    val pgv4 = parse_element (element ("""GovGAST1.pgv4"""))
    val pgv5 = parse_element (element ("""GovGAST1.pgv5"""))
    val pgv6 = parse_element (element ("""GovGAST1.pgv6"""))
    val r = parse_element (element ("""GovGAST1.r"""))
    val rmax = parse_element (element ("""GovGAST1.rmax"""))
    val t1 = parse_element (element ("""GovGAST1.t1"""))
    val t2 = parse_element (element ("""GovGAST1.t2"""))
    val t3 = parse_element (element ("""GovGAST1.t3"""))
    val t4 = parse_element (element ("""GovGAST1.t4"""))
    val t5 = parse_element (element ("""GovGAST1.t5"""))
    val tltr = parse_element (element ("""GovGAST1.tltr"""))
    val vmax = parse_element (element ("""GovGAST1.vmax"""))
    val vmin = parse_element (element ("""GovGAST1.vmin"""))
    def parse (context: Context): GovGAST1 =
    {
        GovGAST1(
            TurbineGovernorDynamics.parse (context),
            toDouble (a (context), context),
            toDouble (b (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (eps (context), context),
            toDouble (fidle (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (ka (context), context),
            toDouble (kt (context), context),
            toDouble (lmax (context), context),
            toDouble (loadinc (context), context),
            toDouble (ltrate (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (r (context), context),
            toDouble (rmax (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (tltr (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context)
        )
    }
}

/**
 * Gas turbine model.
 *
 * @param sup Reference to the superclass object.
 * @param a Valve positioner (A).
 * @param af1 Exhaust temperature Parameter (Af1).
 *        Unit = per unit temperature.  Based on temperature in degrees C.
 * @param af2 Coefficient equal to 0.5(1-speed) (Af2).
 * @param b Valve positioner (B).
 * @param bf1 (Bf1).
 *        Bf1 = E(1-w) where E (speed sensitivity coefficient) is 0.55 to 0.65 x Tr.  Unit = per unit temperature.  Based on temperature in degrees C.
 * @param bf2 Turbine Torque Coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (Bf2).
 * @param c Valve positioner (C).
 * @param cf2 Coefficient defining fuel flow where power output is 0% (Cf2).
 *        Synchronous but no output.  Typically 0.23 x K<sub>hhv</sub> (23% fuel flow).
 * @param ecr Combustion reaction time delay (Ecr).
 * @param etd Turbine and exhaust delay (Etd).
 * @param k3 Ratio of Fuel Adjustment (K3).
 * @param k4 Gain of radiation shield (K4).
 * @param k5 Gain of radiation shield (K5).
 * @param k6 Minimum fuel flow (K6).
 * @param kf Fuel system feedback (Kf).
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param t Fuel Control Time Constant (T).
 * @param t3 Radiation shield time constant (T3).
 * @param t4 Thermocouple time constant (T4).
 * @param t5 Temperature control time constant (T5).
 * @param tc Temperature control (Tc).
 *        Unit = �F or �C depending on constants Af1 and Bf1.
 * @param tcd Compressor discharge time constant (Tcd).
 * @param tf Fuel system time constant (Tf).
 * @param tmax Maximum Turbine limit (Tmax).
 * @param tmin Minimum Turbine limit (Tmin).
 * @param tr Rated temperature (Tr).
 *        Unit = �C depending on parameters Af1 and Bf1.
 * @param trate Turbine rating (Trate).
 *        Unit = MW.
 * @param tt Temperature controller integration rate (Tt).
 * @param w Governor gain (1/droop) on turbine rating (W).
 * @param x Governor lead time constant (X).
 * @param y Governor lag time constant (Y) (&gt;0).
 * @param z Governor mode (Z).
 *        true = Droop
 *        false = ISO.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGAST2
(
    override val sup: TurbineGovernorDynamics,
    a: Double,
    af1: Double,
    af2: Double,
    b: Double,
    bf1: Double,
    bf2: Double,
    c: Double,
    cf2: Double,
    ecr: Double,
    etd: Double,
    k3: Double,
    k4: Double,
    k5: Double,
    k6: Double,
    kf: Double,
    mwbase: Double,
    t: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    tc: Double,
    tcd: Double,
    tf: Double,
    tmax: Double,
    tmin: Double,
    tr: Double,
    trate: Double,
    tt: Double,
    w: Double,
    x: Double,
    y: Double,
    z: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovGAST2.a>" + a + "</cim:GovGAST2.a>\n" +
        "\t\t<cim:GovGAST2.af1>" + af1 + "</cim:GovGAST2.af1>\n" +
        "\t\t<cim:GovGAST2.af2>" + af2 + "</cim:GovGAST2.af2>\n" +
        "\t\t<cim:GovGAST2.b>" + b + "</cim:GovGAST2.b>\n" +
        "\t\t<cim:GovGAST2.bf1>" + bf1 + "</cim:GovGAST2.bf1>\n" +
        "\t\t<cim:GovGAST2.bf2>" + bf2 + "</cim:GovGAST2.bf2>\n" +
        "\t\t<cim:GovGAST2.c>" + c + "</cim:GovGAST2.c>\n" +
        "\t\t<cim:GovGAST2.cf2>" + cf2 + "</cim:GovGAST2.cf2>\n" +
        "\t\t<cim:GovGAST2.ecr>" + ecr + "</cim:GovGAST2.ecr>\n" +
        "\t\t<cim:GovGAST2.etd>" + etd + "</cim:GovGAST2.etd>\n" +
        "\t\t<cim:GovGAST2.k3>" + k3 + "</cim:GovGAST2.k3>\n" +
        "\t\t<cim:GovGAST2.k4>" + k4 + "</cim:GovGAST2.k4>\n" +
        "\t\t<cim:GovGAST2.k5>" + k5 + "</cim:GovGAST2.k5>\n" +
        "\t\t<cim:GovGAST2.k6>" + k6 + "</cim:GovGAST2.k6>\n" +
        "\t\t<cim:GovGAST2.kf>" + kf + "</cim:GovGAST2.kf>\n" +
        "\t\t<cim:GovGAST2.mwbase>" + mwbase + "</cim:GovGAST2.mwbase>\n" +
        "\t\t<cim:GovGAST2.t>" + t + "</cim:GovGAST2.t>\n" +
        "\t\t<cim:GovGAST2.t3>" + t3 + "</cim:GovGAST2.t3>\n" +
        "\t\t<cim:GovGAST2.t4>" + t4 + "</cim:GovGAST2.t4>\n" +
        "\t\t<cim:GovGAST2.t5>" + t5 + "</cim:GovGAST2.t5>\n" +
        "\t\t<cim:GovGAST2.tc>" + tc + "</cim:GovGAST2.tc>\n" +
        "\t\t<cim:GovGAST2.tcd>" + tcd + "</cim:GovGAST2.tcd>\n" +
        "\t\t<cim:GovGAST2.tf>" + tf + "</cim:GovGAST2.tf>\n" +
        "\t\t<cim:GovGAST2.tmax>" + tmax + "</cim:GovGAST2.tmax>\n" +
        "\t\t<cim:GovGAST2.tmin>" + tmin + "</cim:GovGAST2.tmin>\n" +
        "\t\t<cim:GovGAST2.tr>" + tr + "</cim:GovGAST2.tr>\n" +
        "\t\t<cim:GovGAST2.trate>" + trate + "</cim:GovGAST2.trate>\n" +
        "\t\t<cim:GovGAST2.tt>" + tt + "</cim:GovGAST2.tt>\n" +
        "\t\t<cim:GovGAST2.w>" + w + "</cim:GovGAST2.w>\n" +
        "\t\t<cim:GovGAST2.x>" + x + "</cim:GovGAST2.x>\n" +
        "\t\t<cim:GovGAST2.y>" + y + "</cim:GovGAST2.y>\n" +
        "\t\t<cim:GovGAST2.z>" + z + "</cim:GovGAST2.z>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGAST2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGAST2>"
    }
}

object GovGAST2
extends
    Parseable[GovGAST2]
{
    val a = parse_element (element ("""GovGAST2.a"""))
    val af1 = parse_element (element ("""GovGAST2.af1"""))
    val af2 = parse_element (element ("""GovGAST2.af2"""))
    val b = parse_element (element ("""GovGAST2.b"""))
    val bf1 = parse_element (element ("""GovGAST2.bf1"""))
    val bf2 = parse_element (element ("""GovGAST2.bf2"""))
    val c = parse_element (element ("""GovGAST2.c"""))
    val cf2 = parse_element (element ("""GovGAST2.cf2"""))
    val ecr = parse_element (element ("""GovGAST2.ecr"""))
    val etd = parse_element (element ("""GovGAST2.etd"""))
    val k3 = parse_element (element ("""GovGAST2.k3"""))
    val k4 = parse_element (element ("""GovGAST2.k4"""))
    val k5 = parse_element (element ("""GovGAST2.k5"""))
    val k6 = parse_element (element ("""GovGAST2.k6"""))
    val kf = parse_element (element ("""GovGAST2.kf"""))
    val mwbase = parse_element (element ("""GovGAST2.mwbase"""))
    val t = parse_element (element ("""GovGAST2.t"""))
    val t3 = parse_element (element ("""GovGAST2.t3"""))
    val t4 = parse_element (element ("""GovGAST2.t4"""))
    val t5 = parse_element (element ("""GovGAST2.t5"""))
    val tc = parse_element (element ("""GovGAST2.tc"""))
    val tcd = parse_element (element ("""GovGAST2.tcd"""))
    val tf = parse_element (element ("""GovGAST2.tf"""))
    val tmax = parse_element (element ("""GovGAST2.tmax"""))
    val tmin = parse_element (element ("""GovGAST2.tmin"""))
    val tr = parse_element (element ("""GovGAST2.tr"""))
    val trate = parse_element (element ("""GovGAST2.trate"""))
    val tt = parse_element (element ("""GovGAST2.tt"""))
    val w = parse_element (element ("""GovGAST2.w"""))
    val x = parse_element (element ("""GovGAST2.x"""))
    val y = parse_element (element ("""GovGAST2.y"""))
    val z = parse_element (element ("""GovGAST2.z"""))
    def parse (context: Context): GovGAST2 =
    {
        GovGAST2(
            TurbineGovernorDynamics.parse (context),
            toDouble (a (context), context),
            toDouble (af1 (context), context),
            toDouble (af2 (context), context),
            toDouble (b (context), context),
            toDouble (bf1 (context), context),
            toDouble (bf2 (context), context),
            toDouble (c (context), context),
            toDouble (cf2 (context), context),
            toDouble (ecr (context), context),
            toDouble (etd (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (k5 (context), context),
            toDouble (k6 (context), context),
            toDouble (kf (context), context),
            toDouble (mwbase (context), context),
            toDouble (t (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (tc (context), context),
            toDouble (tcd (context), context),
            toDouble (tf (context), context),
            toDouble (tmax (context), context),
            toDouble (tmin (context), context),
            toDouble (tr (context), context),
            toDouble (trate (context), context),
            toDouble (tt (context), context),
            toDouble (w (context), context),
            toDouble (x (context), context),
            toDouble (y (context), context),
            toBoolean (z (context), context)
        )
    }
}

/**
 * Generic turbogas with acceleration and temperature controller.
 *
 * @param sup Reference to the superclass object.
 * @param bca Acceleration limit set-point (Bca).
 *        Unit = 1/s.  Typical Value = 0.01.
 * @param bp Droop (bp).
 *        Typical Value = 0.05.
 * @param dtc Exhaust temperature variation due to fuel flow increasing from 0 to 1 PU (deltaTc).
 *        Typical Value = 390.
 * @param ka Minimum fuel flow (Ka).
 *        Typical Value = 0.23.
 * @param kac Fuel system feedback (K<sub>AC</sub>).
 *        Typical Value = 0.
 * @param kca Acceleration control integral gain (Kca).
 *        Unit = 1/s.  Typical Value = 100.
 * @param ksi Gain of radiation shield (Ksi).
 *        Typical Value = 0.8.
 * @param ky Coefficient of transfer function of fuel valve positioner (Ky).
 *        Typical Value = 1.
 * @param mnef Fuel flow maximum negative error value (MN<sub>EF</sub>).
 *        Typical Value = -0.05.
 * @param mxef Fuel flow maximum positive error value (MX<sub>EF</sub>).
 *        Typical Value = 0.05.
 * @param rcmn Minimum fuel flow (RCMN).
 *        Typical Value = -0.1.
 * @param rcmx Maximum fuel flow (RCMX).
 *        Typical Value = 1.
 * @param tac Fuel control time constant (Tac).
 *        Typical Value = 0.1.
 * @param tc Compressor discharge volume time constant (Tc).
 *        Typical Value = 0.2.
 * @param td Temperature controller derivative gain (Td).
 *        Typical Value = 3.3.
 * @param tfen Turbine rated exhaust temperature correspondent to Pm=1 PU (Tfen).
 *        Typical Value = 540.
 * @param tg Time constant of speed governor (Tg).
 *        Typical Value = 0.05.
 * @param tsi Time constant of radiation shield (Tsi).
 *        Typical Value = 15.
 * @param tt Temperature controller integration rate (Tt).
 *        Typical Value = 250.
 * @param ttc Time constant of thermocouple (Ttc).
 *        Typical Value = 2.5.
 * @param ty Time constant of fuel valve positioner (Ty).
 *        Typical Value = 0.2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGAST3
(
    override val sup: TurbineGovernorDynamics,
    bca: Double,
    bp: Double,
    dtc: Double,
    ka: Double,
    kac: Double,
    kca: Double,
    ksi: Double,
    ky: Double,
    mnef: Double,
    mxef: Double,
    rcmn: Double,
    rcmx: Double,
    tac: Double,
    tc: Double,
    td: Double,
    tfen: Double,
    tg: Double,
    tsi: Double,
    tt: Double,
    ttc: Double,
    ty: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovGAST3.bca>" + bca + "</cim:GovGAST3.bca>\n" +
        "\t\t<cim:GovGAST3.bp>" + bp + "</cim:GovGAST3.bp>\n" +
        "\t\t<cim:GovGAST3.dtc>" + dtc + "</cim:GovGAST3.dtc>\n" +
        "\t\t<cim:GovGAST3.ka>" + ka + "</cim:GovGAST3.ka>\n" +
        "\t\t<cim:GovGAST3.kac>" + kac + "</cim:GovGAST3.kac>\n" +
        "\t\t<cim:GovGAST3.kca>" + kca + "</cim:GovGAST3.kca>\n" +
        "\t\t<cim:GovGAST3.ksi>" + ksi + "</cim:GovGAST3.ksi>\n" +
        "\t\t<cim:GovGAST3.ky>" + ky + "</cim:GovGAST3.ky>\n" +
        "\t\t<cim:GovGAST3.mnef>" + mnef + "</cim:GovGAST3.mnef>\n" +
        "\t\t<cim:GovGAST3.mxef>" + mxef + "</cim:GovGAST3.mxef>\n" +
        "\t\t<cim:GovGAST3.rcmn>" + rcmn + "</cim:GovGAST3.rcmn>\n" +
        "\t\t<cim:GovGAST3.rcmx>" + rcmx + "</cim:GovGAST3.rcmx>\n" +
        "\t\t<cim:GovGAST3.tac>" + tac + "</cim:GovGAST3.tac>\n" +
        "\t\t<cim:GovGAST3.tc>" + tc + "</cim:GovGAST3.tc>\n" +
        "\t\t<cim:GovGAST3.td>" + td + "</cim:GovGAST3.td>\n" +
        "\t\t<cim:GovGAST3.tfen>" + tfen + "</cim:GovGAST3.tfen>\n" +
        "\t\t<cim:GovGAST3.tg>" + tg + "</cim:GovGAST3.tg>\n" +
        "\t\t<cim:GovGAST3.tsi>" + tsi + "</cim:GovGAST3.tsi>\n" +
        "\t\t<cim:GovGAST3.tt>" + tt + "</cim:GovGAST3.tt>\n" +
        "\t\t<cim:GovGAST3.ttc>" + ttc + "</cim:GovGAST3.ttc>\n" +
        "\t\t<cim:GovGAST3.ty>" + ty + "</cim:GovGAST3.ty>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGAST3 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGAST3>"
    }
}

object GovGAST3
extends
    Parseable[GovGAST3]
{
    val bca = parse_element (element ("""GovGAST3.bca"""))
    val bp = parse_element (element ("""GovGAST3.bp"""))
    val dtc = parse_element (element ("""GovGAST3.dtc"""))
    val ka = parse_element (element ("""GovGAST3.ka"""))
    val kac = parse_element (element ("""GovGAST3.kac"""))
    val kca = parse_element (element ("""GovGAST3.kca"""))
    val ksi = parse_element (element ("""GovGAST3.ksi"""))
    val ky = parse_element (element ("""GovGAST3.ky"""))
    val mnef = parse_element (element ("""GovGAST3.mnef"""))
    val mxef = parse_element (element ("""GovGAST3.mxef"""))
    val rcmn = parse_element (element ("""GovGAST3.rcmn"""))
    val rcmx = parse_element (element ("""GovGAST3.rcmx"""))
    val tac = parse_element (element ("""GovGAST3.tac"""))
    val tc = parse_element (element ("""GovGAST3.tc"""))
    val td = parse_element (element ("""GovGAST3.td"""))
    val tfen = parse_element (element ("""GovGAST3.tfen"""))
    val tg = parse_element (element ("""GovGAST3.tg"""))
    val tsi = parse_element (element ("""GovGAST3.tsi"""))
    val tt = parse_element (element ("""GovGAST3.tt"""))
    val ttc = parse_element (element ("""GovGAST3.ttc"""))
    val ty = parse_element (element ("""GovGAST3.ty"""))
    def parse (context: Context): GovGAST3 =
    {
        GovGAST3(
            TurbineGovernorDynamics.parse (context),
            toDouble (bca (context), context),
            toDouble (bp (context), context),
            toDouble (dtc (context), context),
            toDouble (ka (context), context),
            toDouble (kac (context), context),
            toDouble (kca (context), context),
            toDouble (ksi (context), context),
            toDouble (ky (context), context),
            toDouble (mnef (context), context),
            toDouble (mxef (context), context),
            toDouble (rcmn (context), context),
            toDouble (rcmx (context), context),
            toDouble (tac (context), context),
            toDouble (tc (context), context),
            toDouble (td (context), context),
            toDouble (tfen (context), context),
            toDouble (tg (context), context),
            toDouble (tsi (context), context),
            toDouble (tt (context), context),
            toDouble (ttc (context), context),
            toDouble (ty (context), context)
        )
    }
}

/**
 * Generic turbogas.
 *
 * @param sup Reference to the superclass object.
 * @param bp Droop (bp).
 *        Typical Value = 0.05.
 * @param ktm Compressor gain (K<sub>tm</sub>).
 *        Typical Value = 0.
 * @param mnef Fuel flow maximum negative error value (MN<sub>EF</sub>).
 *        Typical Value = -0.05.
 * @param mxef Fuel flow maximum positive error value (MX<sub>EF</sub>).
 *        Typical Value = 0.05.
 * @param rymn Minimum valve opening (RYMN).
 *        Typical Value = 0.
 * @param rymx Maximum valve opening (RYMX).
 *        Typical Value = 1.1.
 * @param ta Maximum gate opening velocity (T<sub>A</sub>).
 *        Typical Value = 3.
 * @param tc Maximum gate closing velocity (T<sub>c</sub>).
 *        Typical Value = 0.5.
 * @param tcm Fuel control time constant (T<sub>cm</sub>).
 *        Typical Value = 0.1.
 * @param tm Compressor discharge volume time constant (T<sub>m</sub>).
 *        Typical Value = 0.2.
 * @param tv Time constant of fuel valve positioner (T<sub>y</sub>).
 *        Typical Value = 0.1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGAST4
(
    override val sup: TurbineGovernorDynamics,
    bp: Double,
    ktm: Double,
    mnef: Double,
    mxef: Double,
    rymn: Double,
    rymx: Double,
    ta: Double,
    tc: Double,
    tcm: Double,
    tm: Double,
    tv: Double
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
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovGAST4] }
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
        "\t\t<cim:GovGAST4.bp>" + bp + "</cim:GovGAST4.bp>\n" +
        "\t\t<cim:GovGAST4.ktm>" + ktm + "</cim:GovGAST4.ktm>\n" +
        "\t\t<cim:GovGAST4.mnef>" + mnef + "</cim:GovGAST4.mnef>\n" +
        "\t\t<cim:GovGAST4.mxef>" + mxef + "</cim:GovGAST4.mxef>\n" +
        "\t\t<cim:GovGAST4.rymn>" + rymn + "</cim:GovGAST4.rymn>\n" +
        "\t\t<cim:GovGAST4.rymx>" + rymx + "</cim:GovGAST4.rymx>\n" +
        "\t\t<cim:GovGAST4.ta>" + ta + "</cim:GovGAST4.ta>\n" +
        "\t\t<cim:GovGAST4.tc>" + tc + "</cim:GovGAST4.tc>\n" +
        "\t\t<cim:GovGAST4.tcm>" + tcm + "</cim:GovGAST4.tcm>\n" +
        "\t\t<cim:GovGAST4.tm>" + tm + "</cim:GovGAST4.tm>\n" +
        "\t\t<cim:GovGAST4.tv>" + tv + "</cim:GovGAST4.tv>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGAST4 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGAST4>"
    }
}

object GovGAST4
extends
    Parseable[GovGAST4]
{
    val bp = parse_element (element ("""GovGAST4.bp"""))
    val ktm = parse_element (element ("""GovGAST4.ktm"""))
    val mnef = parse_element (element ("""GovGAST4.mnef"""))
    val mxef = parse_element (element ("""GovGAST4.mxef"""))
    val rymn = parse_element (element ("""GovGAST4.rymn"""))
    val rymx = parse_element (element ("""GovGAST4.rymx"""))
    val ta = parse_element (element ("""GovGAST4.ta"""))
    val tc = parse_element (element ("""GovGAST4.tc"""))
    val tcm = parse_element (element ("""GovGAST4.tcm"""))
    val tm = parse_element (element ("""GovGAST4.tm"""))
    val tv = parse_element (element ("""GovGAST4.tv"""))
    def parse (context: Context): GovGAST4 =
    {
        GovGAST4(
            TurbineGovernorDynamics.parse (context),
            toDouble (bp (context), context),
            toDouble (ktm (context), context),
            toDouble (mnef (context), context),
            toDouble (mxef (context), context),
            toDouble (rymn (context), context),
            toDouble (rymx (context), context),
            toDouble (ta (context), context),
            toDouble (tc (context), context),
            toDouble (tcm (context), context),
            toDouble (tm (context), context),
            toDouble (tv (context), context)
        )
    }
}

/**
 * Woodward Gas turbine governor model.
 *
 * @param sup Reference to the superclass object.
 * @param a Valve positioner (<i>A</i>).
 * @param af1 Exhaust temperature Parameter (Af1).
 * @param af2 Coefficient equal to 0.5(1-speed) (Af2).
 * @param b Valve positioner (<i>B</i>).
 * @param bf1 (Bf1).
 *        Bf1 = E(1-w) where E (speed sensitivity coefficient) is 0.55 to 0.65 x Tr.
 * @param bf2 Turbine Torque Coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (Bf2).
 * @param c Valve positioner (<i>C</i>).
 * @param cf2 Coefficient defining fuel flow where power output is 0% (Cf2).
 *        Synchronous but no output.  Typically 0.23 x K<sub>hhv </sub>(23% fuel flow).
 * @param ecr Combustion reaction time delay (Ecr).
 * @param etd Turbine and exhaust delay (Etd).
 * @param k3 Ratio of Fuel Adjustment (K3).
 * @param k4 Gain of radiation shield (K4).
 * @param k5 Gain of radiation shield (K5).
 * @param k6 Minimum fuel flow (K6).
 * @param kd Drop Governor Gain (Kd).
 * @param kdroop (Kdroop).
 * @param kf Fuel system feedback (Kf).
 * @param ki Isochronous Governor Gain (Ki).
 * @param kp PID Proportional gain (Kp).
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param t Fuel Control Time Constant (T).
 * @param t3 Radiation shield time constant (T3).
 * @param t4 Thermocouple time constant (T4).
 * @param t5 Temperature control time constant (T5).
 * @param tc Temperature control (Tc).
 * @param tcd Compressor discharge time constant (Tcd).
 * @param td Power transducer time constant (Td).
 * @param tf Fuel system time constant (Tf).
 * @param tmax Maximum Turbine limit (Tmax).
 * @param tmin Minimum Turbine limit (Tmin).
 * @param tr Rated temperature (Tr).
 * @param trate Turbine rating (Trate).
 *        Unit = MW.
 * @param tt Temperature controller integration rate (Tt).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovGASTWD
(
    override val sup: TurbineGovernorDynamics,
    a: Double,
    af1: Double,
    af2: Double,
    b: Double,
    bf1: Double,
    bf2: Double,
    c: Double,
    cf2: Double,
    ecr: Double,
    etd: Double,
    k3: Double,
    k4: Double,
    k5: Double,
    k6: Double,
    kd: Double,
    kdroop: Double,
    kf: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    t: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    tc: Double,
    tcd: Double,
    td: Double,
    tf: Double,
    tmax: Double,
    tmin: Double,
    tr: Double,
    trate: Double,
    tt: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovGASTWD.a>" + a + "</cim:GovGASTWD.a>\n" +
        "\t\t<cim:GovGASTWD.af1>" + af1 + "</cim:GovGASTWD.af1>\n" +
        "\t\t<cim:GovGASTWD.af2>" + af2 + "</cim:GovGASTWD.af2>\n" +
        "\t\t<cim:GovGASTWD.b>" + b + "</cim:GovGASTWD.b>\n" +
        "\t\t<cim:GovGASTWD.bf1>" + bf1 + "</cim:GovGASTWD.bf1>\n" +
        "\t\t<cim:GovGASTWD.bf2>" + bf2 + "</cim:GovGASTWD.bf2>\n" +
        "\t\t<cim:GovGASTWD.c>" + c + "</cim:GovGASTWD.c>\n" +
        "\t\t<cim:GovGASTWD.cf2>" + cf2 + "</cim:GovGASTWD.cf2>\n" +
        "\t\t<cim:GovGASTWD.ecr>" + ecr + "</cim:GovGASTWD.ecr>\n" +
        "\t\t<cim:GovGASTWD.etd>" + etd + "</cim:GovGASTWD.etd>\n" +
        "\t\t<cim:GovGASTWD.k3>" + k3 + "</cim:GovGASTWD.k3>\n" +
        "\t\t<cim:GovGASTWD.k4>" + k4 + "</cim:GovGASTWD.k4>\n" +
        "\t\t<cim:GovGASTWD.k5>" + k5 + "</cim:GovGASTWD.k5>\n" +
        "\t\t<cim:GovGASTWD.k6>" + k6 + "</cim:GovGASTWD.k6>\n" +
        "\t\t<cim:GovGASTWD.kd>" + kd + "</cim:GovGASTWD.kd>\n" +
        "\t\t<cim:GovGASTWD.kdroop>" + kdroop + "</cim:GovGASTWD.kdroop>\n" +
        "\t\t<cim:GovGASTWD.kf>" + kf + "</cim:GovGASTWD.kf>\n" +
        "\t\t<cim:GovGASTWD.ki>" + ki + "</cim:GovGASTWD.ki>\n" +
        "\t\t<cim:GovGASTWD.kp>" + kp + "</cim:GovGASTWD.kp>\n" +
        "\t\t<cim:GovGASTWD.mwbase>" + mwbase + "</cim:GovGASTWD.mwbase>\n" +
        "\t\t<cim:GovGASTWD.t>" + t + "</cim:GovGASTWD.t>\n" +
        "\t\t<cim:GovGASTWD.t3>" + t3 + "</cim:GovGASTWD.t3>\n" +
        "\t\t<cim:GovGASTWD.t4>" + t4 + "</cim:GovGASTWD.t4>\n" +
        "\t\t<cim:GovGASTWD.t5>" + t5 + "</cim:GovGASTWD.t5>\n" +
        "\t\t<cim:GovGASTWD.tc>" + tc + "</cim:GovGASTWD.tc>\n" +
        "\t\t<cim:GovGASTWD.tcd>" + tcd + "</cim:GovGASTWD.tcd>\n" +
        "\t\t<cim:GovGASTWD.td>" + td + "</cim:GovGASTWD.td>\n" +
        "\t\t<cim:GovGASTWD.tf>" + tf + "</cim:GovGASTWD.tf>\n" +
        "\t\t<cim:GovGASTWD.tmax>" + tmax + "</cim:GovGASTWD.tmax>\n" +
        "\t\t<cim:GovGASTWD.tmin>" + tmin + "</cim:GovGASTWD.tmin>\n" +
        "\t\t<cim:GovGASTWD.tr>" + tr + "</cim:GovGASTWD.tr>\n" +
        "\t\t<cim:GovGASTWD.trate>" + trate + "</cim:GovGASTWD.trate>\n" +
        "\t\t<cim:GovGASTWD.tt>" + tt + "</cim:GovGASTWD.tt>\n"
    }
    override def export: String =
    {
        "\t<cim:GovGASTWD rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovGASTWD>"
    }
}

object GovGASTWD
extends
    Parseable[GovGASTWD]
{
    val a = parse_element (element ("""GovGASTWD.a"""))
    val af1 = parse_element (element ("""GovGASTWD.af1"""))
    val af2 = parse_element (element ("""GovGASTWD.af2"""))
    val b = parse_element (element ("""GovGASTWD.b"""))
    val bf1 = parse_element (element ("""GovGASTWD.bf1"""))
    val bf2 = parse_element (element ("""GovGASTWD.bf2"""))
    val c = parse_element (element ("""GovGASTWD.c"""))
    val cf2 = parse_element (element ("""GovGASTWD.cf2"""))
    val ecr = parse_element (element ("""GovGASTWD.ecr"""))
    val etd = parse_element (element ("""GovGASTWD.etd"""))
    val k3 = parse_element (element ("""GovGASTWD.k3"""))
    val k4 = parse_element (element ("""GovGASTWD.k4"""))
    val k5 = parse_element (element ("""GovGASTWD.k5"""))
    val k6 = parse_element (element ("""GovGASTWD.k6"""))
    val kd = parse_element (element ("""GovGASTWD.kd"""))
    val kdroop = parse_element (element ("""GovGASTWD.kdroop"""))
    val kf = parse_element (element ("""GovGASTWD.kf"""))
    val ki = parse_element (element ("""GovGASTWD.ki"""))
    val kp = parse_element (element ("""GovGASTWD.kp"""))
    val mwbase = parse_element (element ("""GovGASTWD.mwbase"""))
    val t = parse_element (element ("""GovGASTWD.t"""))
    val t3 = parse_element (element ("""GovGASTWD.t3"""))
    val t4 = parse_element (element ("""GovGASTWD.t4"""))
    val t5 = parse_element (element ("""GovGASTWD.t5"""))
    val tc = parse_element (element ("""GovGASTWD.tc"""))
    val tcd = parse_element (element ("""GovGASTWD.tcd"""))
    val td = parse_element (element ("""GovGASTWD.td"""))
    val tf = parse_element (element ("""GovGASTWD.tf"""))
    val tmax = parse_element (element ("""GovGASTWD.tmax"""))
    val tmin = parse_element (element ("""GovGASTWD.tmin"""))
    val tr = parse_element (element ("""GovGASTWD.tr"""))
    val trate = parse_element (element ("""GovGASTWD.trate"""))
    val tt = parse_element (element ("""GovGASTWD.tt"""))
    def parse (context: Context): GovGASTWD =
    {
        GovGASTWD(
            TurbineGovernorDynamics.parse (context),
            toDouble (a (context), context),
            toDouble (af1 (context), context),
            toDouble (af2 (context), context),
            toDouble (b (context), context),
            toDouble (bf1 (context), context),
            toDouble (bf2 (context), context),
            toDouble (c (context), context),
            toDouble (cf2 (context), context),
            toDouble (ecr (context), context),
            toDouble (etd (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (k5 (context), context),
            toDouble (k6 (context), context),
            toDouble (kd (context), context),
            toDouble (kdroop (context), context),
            toDouble (kf (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toDouble (t (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (tc (context), context),
            toDouble (tcd (context), context),
            toDouble (td (context), context),
            toDouble (tf (context), context),
            toDouble (tmax (context), context),
            toDouble (tmin (context), context),
            toDouble (tr (context), context),
            toDouble (trate (context), context),
            toDouble (tt (context), context)
        )
    }
}

/**
 * Basic Hydro turbine governor model.
 *
 * @param sup Reference to the superclass object.
 * @param at Turbine gain (At) (&gt;0).
 *        Typical Value = 1.2.
 * @param dturb Turbine damping factor (Dturb) (&gt;=0).
 *        Typical Value = 0.5.
 * @param gmax Maximum gate opening (Gmax) (&gt;0).
 *        Typical Value = 1.
 * @param gmin Minimum gate opening (Gmin) (&gt;=0).
 *        Typical Value = 0.
 * @param hdam Turbine nominal head (hdam).
 *        Typical Value = 1.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param qnl No-load flow at nominal head (qnl) (&gt;=0).
 *        Typical Value = 0.08.
 * @param rperm Permanent droop (R) (&gt;0).
 *        Typical Value = 0.04.
 * @param rtemp Temporary droop (r) (&gt;R).
 *        Typical Value = 0.3.
 * @param tf Filter time constant (<i>Tf</i>) (&gt;0).
 *        Typical Value = 0.05.
 * @param tg Gate servo time constant (Tg) (&gt;0).
 *        Typical Value = 0.5.
 * @param tr Washout time constant (Tr) (&gt;0).
 *        Typical Value = 5.
 * @param tw Water inertia time constant (Tw) (&gt;0).
 *        Typical Value = 1.
 * @param velm Maximum gate velocity (Vlem) (&gt;0).
 *        Typical Value = 0.2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydro1
(
    override val sup: TurbineGovernorDynamics,
    at: Double,
    dturb: Double,
    gmax: Double,
    gmin: Double,
    hdam: Double,
    mwbase: Double,
    qnl: Double,
    rperm: Double,
    rtemp: Double,
    tf: Double,
    tg: Double,
    tr: Double,
    tw: Double,
    velm: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydro1.at>" + at + "</cim:GovHydro1.at>\n" +
        "\t\t<cim:GovHydro1.dturb>" + dturb + "</cim:GovHydro1.dturb>\n" +
        "\t\t<cim:GovHydro1.gmax>" + gmax + "</cim:GovHydro1.gmax>\n" +
        "\t\t<cim:GovHydro1.gmin>" + gmin + "</cim:GovHydro1.gmin>\n" +
        "\t\t<cim:GovHydro1.hdam>" + hdam + "</cim:GovHydro1.hdam>\n" +
        "\t\t<cim:GovHydro1.mwbase>" + mwbase + "</cim:GovHydro1.mwbase>\n" +
        "\t\t<cim:GovHydro1.qnl>" + qnl + "</cim:GovHydro1.qnl>\n" +
        "\t\t<cim:GovHydro1.rperm>" + rperm + "</cim:GovHydro1.rperm>\n" +
        "\t\t<cim:GovHydro1.rtemp>" + rtemp + "</cim:GovHydro1.rtemp>\n" +
        "\t\t<cim:GovHydro1.tf>" + tf + "</cim:GovHydro1.tf>\n" +
        "\t\t<cim:GovHydro1.tg>" + tg + "</cim:GovHydro1.tg>\n" +
        "\t\t<cim:GovHydro1.tr>" + tr + "</cim:GovHydro1.tr>\n" +
        "\t\t<cim:GovHydro1.tw>" + tw + "</cim:GovHydro1.tw>\n" +
        "\t\t<cim:GovHydro1.velm>" + velm + "</cim:GovHydro1.velm>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydro1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydro1>"
    }
}

object GovHydro1
extends
    Parseable[GovHydro1]
{
    val at = parse_element (element ("""GovHydro1.at"""))
    val dturb = parse_element (element ("""GovHydro1.dturb"""))
    val gmax = parse_element (element ("""GovHydro1.gmax"""))
    val gmin = parse_element (element ("""GovHydro1.gmin"""))
    val hdam = parse_element (element ("""GovHydro1.hdam"""))
    val mwbase = parse_element (element ("""GovHydro1.mwbase"""))
    val qnl = parse_element (element ("""GovHydro1.qnl"""))
    val rperm = parse_element (element ("""GovHydro1.rperm"""))
    val rtemp = parse_element (element ("""GovHydro1.rtemp"""))
    val tf = parse_element (element ("""GovHydro1.tf"""))
    val tg = parse_element (element ("""GovHydro1.tg"""))
    val tr = parse_element (element ("""GovHydro1.tr"""))
    val tw = parse_element (element ("""GovHydro1.tw"""))
    val velm = parse_element (element ("""GovHydro1.velm"""))
    def parse (context: Context): GovHydro1 =
    {
        GovHydro1(
            TurbineGovernorDynamics.parse (context),
            toDouble (at (context), context),
            toDouble (dturb (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (hdam (context), context),
            toDouble (mwbase (context), context),
            toDouble (qnl (context), context),
            toDouble (rperm (context), context),
            toDouble (rtemp (context), context),
            toDouble (tf (context), context),
            toDouble (tg (context), context),
            toDouble (tr (context), context),
            toDouble (tw (context), context),
            toDouble (velm (context), context)
        )
    }
}

/**
 * IEEE hydro turbine governor model represents plants with straightforward penstock configurations and hydraulic-dashpot governors.
 *
 * @param sup Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (Aturb).
 *        Typical Value = -1.
 * @param bturb Turbine denominator multiplier (Bturb).
 *        Typical Value = 0.5.
 * @param db1 Intentional deadband width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional deadband (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param kturb Turbine gain (Kturb).
 *        Typical Value = 1.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening; (<i>Pmin</i>).
 *        Typical Value = 0.
 * @param rperm Permanent droop (Rperm).
 *        Typical Value = 0.05.
 * @param rtemp Temporary droop (Rtemp).
 *        Typical Value = 0.5.
 * @param tg Gate servo time constant (Tg).
 *        Typical Value = 0.5.
 * @param tp Pilot servo valve time constant (Tp).
 *        Typical Value = 0.03.
 * @param tr Dashpot time constant (Tr).
 *        Typical Value = 12.
 * @param tw Water inertia time constant (Tw).
 *        Typical Value = 2.
 * @param uc Maximum gate closing velocity (Uc) (&lt;0).
 *        Unit = PU/sec.   Typical Value = -0.1.
 * @param uo Maximum gate opening velocity (Uo).
 *        Unit = PU/sec.  Typical Value = 0.1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydro2
(
    override val sup: TurbineGovernorDynamics,
    aturb: Double,
    bturb: Double,
    db1: Double,
    db2: Double,
    eps: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    kturb: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    rperm: Double,
    rtemp: Double,
    tg: Double,
    tp: Double,
    tr: Double,
    tw: Double,
    uc: Double,
    uo: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydro2.aturb>" + aturb + "</cim:GovHydro2.aturb>\n" +
        "\t\t<cim:GovHydro2.bturb>" + bturb + "</cim:GovHydro2.bturb>\n" +
        "\t\t<cim:GovHydro2.db1>" + db1 + "</cim:GovHydro2.db1>\n" +
        "\t\t<cim:GovHydro2.db2>" + db2 + "</cim:GovHydro2.db2>\n" +
        "\t\t<cim:GovHydro2.eps>" + eps + "</cim:GovHydro2.eps>\n" +
        "\t\t<cim:GovHydro2.gv1>" + gv1 + "</cim:GovHydro2.gv1>\n" +
        "\t\t<cim:GovHydro2.gv2>" + gv2 + "</cim:GovHydro2.gv2>\n" +
        "\t\t<cim:GovHydro2.gv3>" + gv3 + "</cim:GovHydro2.gv3>\n" +
        "\t\t<cim:GovHydro2.gv4>" + gv4 + "</cim:GovHydro2.gv4>\n" +
        "\t\t<cim:GovHydro2.gv5>" + gv5 + "</cim:GovHydro2.gv5>\n" +
        "\t\t<cim:GovHydro2.gv6>" + gv6 + "</cim:GovHydro2.gv6>\n" +
        "\t\t<cim:GovHydro2.kturb>" + kturb + "</cim:GovHydro2.kturb>\n" +
        "\t\t<cim:GovHydro2.mwbase>" + mwbase + "</cim:GovHydro2.mwbase>\n" +
        "\t\t<cim:GovHydro2.pgv1>" + pgv1 + "</cim:GovHydro2.pgv1>\n" +
        "\t\t<cim:GovHydro2.pgv2>" + pgv2 + "</cim:GovHydro2.pgv2>\n" +
        "\t\t<cim:GovHydro2.pgv3>" + pgv3 + "</cim:GovHydro2.pgv3>\n" +
        "\t\t<cim:GovHydro2.pgv4>" + pgv4 + "</cim:GovHydro2.pgv4>\n" +
        "\t\t<cim:GovHydro2.pgv5>" + pgv5 + "</cim:GovHydro2.pgv5>\n" +
        "\t\t<cim:GovHydro2.pgv6>" + pgv6 + "</cim:GovHydro2.pgv6>\n" +
        "\t\t<cim:GovHydro2.pmax>" + pmax + "</cim:GovHydro2.pmax>\n" +
        "\t\t<cim:GovHydro2.pmin>" + pmin + "</cim:GovHydro2.pmin>\n" +
        "\t\t<cim:GovHydro2.rperm>" + rperm + "</cim:GovHydro2.rperm>\n" +
        "\t\t<cim:GovHydro2.rtemp>" + rtemp + "</cim:GovHydro2.rtemp>\n" +
        "\t\t<cim:GovHydro2.tg>" + tg + "</cim:GovHydro2.tg>\n" +
        "\t\t<cim:GovHydro2.tp>" + tp + "</cim:GovHydro2.tp>\n" +
        "\t\t<cim:GovHydro2.tr>" + tr + "</cim:GovHydro2.tr>\n" +
        "\t\t<cim:GovHydro2.tw>" + tw + "</cim:GovHydro2.tw>\n" +
        "\t\t<cim:GovHydro2.uc>" + uc + "</cim:GovHydro2.uc>\n" +
        "\t\t<cim:GovHydro2.uo>" + uo + "</cim:GovHydro2.uo>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydro2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydro2>"
    }
}

object GovHydro2
extends
    Parseable[GovHydro2]
{
    val aturb = parse_element (element ("""GovHydro2.aturb"""))
    val bturb = parse_element (element ("""GovHydro2.bturb"""))
    val db1 = parse_element (element ("""GovHydro2.db1"""))
    val db2 = parse_element (element ("""GovHydro2.db2"""))
    val eps = parse_element (element ("""GovHydro2.eps"""))
    val gv1 = parse_element (element ("""GovHydro2.gv1"""))
    val gv2 = parse_element (element ("""GovHydro2.gv2"""))
    val gv3 = parse_element (element ("""GovHydro2.gv3"""))
    val gv4 = parse_element (element ("""GovHydro2.gv4"""))
    val gv5 = parse_element (element ("""GovHydro2.gv5"""))
    val gv6 = parse_element (element ("""GovHydro2.gv6"""))
    val kturb = parse_element (element ("""GovHydro2.kturb"""))
    val mwbase = parse_element (element ("""GovHydro2.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydro2.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydro2.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydro2.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydro2.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydro2.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydro2.pgv6"""))
    val pmax = parse_element (element ("""GovHydro2.pmax"""))
    val pmin = parse_element (element ("""GovHydro2.pmin"""))
    val rperm = parse_element (element ("""GovHydro2.rperm"""))
    val rtemp = parse_element (element ("""GovHydro2.rtemp"""))
    val tg = parse_element (element ("""GovHydro2.tg"""))
    val tp = parse_element (element ("""GovHydro2.tp"""))
    val tr = parse_element (element ("""GovHydro2.tr"""))
    val tw = parse_element (element ("""GovHydro2.tw"""))
    val uc = parse_element (element ("""GovHydro2.uc"""))
    val uo = parse_element (element ("""GovHydro2.uo"""))
    def parse (context: Context): GovHydro2 =
    {
        GovHydro2(
            TurbineGovernorDynamics.parse (context),
            toDouble (aturb (context), context),
            toDouble (bturb (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (eps (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (kturb (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (rperm (context), context),
            toDouble (rtemp (context), context),
            toDouble (tg (context), context),
            toDouble (tp (context), context),
            toDouble (tr (context), context),
            toDouble (tw (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context)
        )
    }
}

/**
 * Modified IEEE Hydro Governor-Turbine Model.
 *
 * This model differs from that defined in the IEEE modeling guideline paper in that the limits on gate position and velocity do not permit "wind up" of the upstream signals.
 *
 * @param sup Reference to the superclass object.
 * @param at Turbine gain (At).
 *        Typical Value = 1.2.
 * @param db1 Intentional dead-band width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param dturb Turbine damping factor (Dturb).
 *        Typical Value = 0.2.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param governorControl Governor control flag (Cflag).
 *        true = PID control is active
 *        false = double derivative control is active.
 *        Typical Value = true.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param h0 Turbine nominal head (H0).
 *        Typical Value = 1.
 * @param k1 Derivative gain (K1).
 *        Typical Value = 0.01.
 * @param k2 Double derivative gain, if Cflag = -1 (K2).
 *        Typical Value = 2.5.
 * @param kg Gate servo gain (Kg).
 *        Typical Value = 2.
 * @param ki Integral gain (Ki).
 *        Typical Value = 0.5.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening, PU of MWbase (Pmin).
 *        Typical Value = 0.
 * @param qnl No-load turbine flow at nominal head (Qnl).
 *        Typical Value = 0.08.
 * @param relec Steady-state droop, PU, for electrical power feedback (Relec).
 *        Typical Value = 0.05.
 * @param rgate Steady-state droop, PU, for governor output feedback (Rgate).
 *        Typical Value = 0.
 * @param td Input filter time constant (Td).
 *        Typical Value = 0.05.
 * @param tf Washout time constant (Tf).
 *        Typical Value = 0.1.
 * @param tp Gate servo time constant (Tp).
 *        Typical Value = 0.05.
 * @param tt Power feedback time constant (Tt).
 *        Typical Value = 0.2.
 * @param tw Water inertia time constant (Tw).
 *        Typical Value = 1.
 * @param velcl Maximum gate closing velocity (Velcl).
 *        Unit = PU/sec.  Typical Value = -0.2.
 * @param velop Maximum gate opening velocity (Velop).
 *        Unit = PU/sec. Typical Value = 0.2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydro3
(
    override val sup: TurbineGovernorDynamics,
    at: Double,
    db1: Double,
    db2: Double,
    dturb: Double,
    eps: Double,
    governorControl: Boolean,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    h0: Double,
    k1: Double,
    k2: Double,
    kg: Double,
    ki: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    qnl: Double,
    relec: Double,
    rgate: Double,
    td: Double,
    tf: Double,
    tp: Double,
    tt: Double,
    tw: Double,
    velcl: Double,
    velop: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydro3.at>" + at + "</cim:GovHydro3.at>\n" +
        "\t\t<cim:GovHydro3.db1>" + db1 + "</cim:GovHydro3.db1>\n" +
        "\t\t<cim:GovHydro3.db2>" + db2 + "</cim:GovHydro3.db2>\n" +
        "\t\t<cim:GovHydro3.dturb>" + dturb + "</cim:GovHydro3.dturb>\n" +
        "\t\t<cim:GovHydro3.eps>" + eps + "</cim:GovHydro3.eps>\n" +
        "\t\t<cim:GovHydro3.governorControl>" + governorControl + "</cim:GovHydro3.governorControl>\n" +
        "\t\t<cim:GovHydro3.gv1>" + gv1 + "</cim:GovHydro3.gv1>\n" +
        "\t\t<cim:GovHydro3.gv2>" + gv2 + "</cim:GovHydro3.gv2>\n" +
        "\t\t<cim:GovHydro3.gv3>" + gv3 + "</cim:GovHydro3.gv3>\n" +
        "\t\t<cim:GovHydro3.gv4>" + gv4 + "</cim:GovHydro3.gv4>\n" +
        "\t\t<cim:GovHydro3.gv5>" + gv5 + "</cim:GovHydro3.gv5>\n" +
        "\t\t<cim:GovHydro3.gv6>" + gv6 + "</cim:GovHydro3.gv6>\n" +
        "\t\t<cim:GovHydro3.h0>" + h0 + "</cim:GovHydro3.h0>\n" +
        "\t\t<cim:GovHydro3.k1>" + k1 + "</cim:GovHydro3.k1>\n" +
        "\t\t<cim:GovHydro3.k2>" + k2 + "</cim:GovHydro3.k2>\n" +
        "\t\t<cim:GovHydro3.kg>" + kg + "</cim:GovHydro3.kg>\n" +
        "\t\t<cim:GovHydro3.ki>" + ki + "</cim:GovHydro3.ki>\n" +
        "\t\t<cim:GovHydro3.mwbase>" + mwbase + "</cim:GovHydro3.mwbase>\n" +
        "\t\t<cim:GovHydro3.pgv1>" + pgv1 + "</cim:GovHydro3.pgv1>\n" +
        "\t\t<cim:GovHydro3.pgv2>" + pgv2 + "</cim:GovHydro3.pgv2>\n" +
        "\t\t<cim:GovHydro3.pgv3>" + pgv3 + "</cim:GovHydro3.pgv3>\n" +
        "\t\t<cim:GovHydro3.pgv4>" + pgv4 + "</cim:GovHydro3.pgv4>\n" +
        "\t\t<cim:GovHydro3.pgv5>" + pgv5 + "</cim:GovHydro3.pgv5>\n" +
        "\t\t<cim:GovHydro3.pgv6>" + pgv6 + "</cim:GovHydro3.pgv6>\n" +
        "\t\t<cim:GovHydro3.pmax>" + pmax + "</cim:GovHydro3.pmax>\n" +
        "\t\t<cim:GovHydro3.pmin>" + pmin + "</cim:GovHydro3.pmin>\n" +
        "\t\t<cim:GovHydro3.qnl>" + qnl + "</cim:GovHydro3.qnl>\n" +
        "\t\t<cim:GovHydro3.relec>" + relec + "</cim:GovHydro3.relec>\n" +
        "\t\t<cim:GovHydro3.rgate>" + rgate + "</cim:GovHydro3.rgate>\n" +
        "\t\t<cim:GovHydro3.td>" + td + "</cim:GovHydro3.td>\n" +
        "\t\t<cim:GovHydro3.tf>" + tf + "</cim:GovHydro3.tf>\n" +
        "\t\t<cim:GovHydro3.tp>" + tp + "</cim:GovHydro3.tp>\n" +
        "\t\t<cim:GovHydro3.tt>" + tt + "</cim:GovHydro3.tt>\n" +
        "\t\t<cim:GovHydro3.tw>" + tw + "</cim:GovHydro3.tw>\n" +
        "\t\t<cim:GovHydro3.velcl>" + velcl + "</cim:GovHydro3.velcl>\n" +
        "\t\t<cim:GovHydro3.velop>" + velop + "</cim:GovHydro3.velop>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydro3 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydro3>"
    }
}

object GovHydro3
extends
    Parseable[GovHydro3]
{
    val at = parse_element (element ("""GovHydro3.at"""))
    val db1 = parse_element (element ("""GovHydro3.db1"""))
    val db2 = parse_element (element ("""GovHydro3.db2"""))
    val dturb = parse_element (element ("""GovHydro3.dturb"""))
    val eps = parse_element (element ("""GovHydro3.eps"""))
    val governorControl = parse_element (element ("""GovHydro3.governorControl"""))
    val gv1 = parse_element (element ("""GovHydro3.gv1"""))
    val gv2 = parse_element (element ("""GovHydro3.gv2"""))
    val gv3 = parse_element (element ("""GovHydro3.gv3"""))
    val gv4 = parse_element (element ("""GovHydro3.gv4"""))
    val gv5 = parse_element (element ("""GovHydro3.gv5"""))
    val gv6 = parse_element (element ("""GovHydro3.gv6"""))
    val h0 = parse_element (element ("""GovHydro3.h0"""))
    val k1 = parse_element (element ("""GovHydro3.k1"""))
    val k2 = parse_element (element ("""GovHydro3.k2"""))
    val kg = parse_element (element ("""GovHydro3.kg"""))
    val ki = parse_element (element ("""GovHydro3.ki"""))
    val mwbase = parse_element (element ("""GovHydro3.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydro3.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydro3.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydro3.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydro3.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydro3.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydro3.pgv6"""))
    val pmax = parse_element (element ("""GovHydro3.pmax"""))
    val pmin = parse_element (element ("""GovHydro3.pmin"""))
    val qnl = parse_element (element ("""GovHydro3.qnl"""))
    val relec = parse_element (element ("""GovHydro3.relec"""))
    val rgate = parse_element (element ("""GovHydro3.rgate"""))
    val td = parse_element (element ("""GovHydro3.td"""))
    val tf = parse_element (element ("""GovHydro3.tf"""))
    val tp = parse_element (element ("""GovHydro3.tp"""))
    val tt = parse_element (element ("""GovHydro3.tt"""))
    val tw = parse_element (element ("""GovHydro3.tw"""))
    val velcl = parse_element (element ("""GovHydro3.velcl"""))
    val velop = parse_element (element ("""GovHydro3.velop"""))
    def parse (context: Context): GovHydro3 =
    {
        GovHydro3(
            TurbineGovernorDynamics.parse (context),
            toDouble (at (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (dturb (context), context),
            toDouble (eps (context), context),
            toBoolean (governorControl (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (h0 (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (qnl (context), context),
            toDouble (relec (context), context),
            toDouble (rgate (context), context),
            toDouble (td (context), context),
            toDouble (tf (context), context),
            toDouble (tp (context), context),
            toDouble (tt (context), context),
            toDouble (tw (context), context),
            toDouble (velcl (context), context),
            toDouble (velop (context), context)
        )
    }
}

/**
 * Hydro turbine and governor.
 *
 * Represents plants with straight-forward penstock configurations and hydraulic governors of traditional 'dashpot' type.  This model can be used to represent simple, Francis, Pelton or Kaplan turbines.
 *
 * @param sup Reference to the superclass object.
 * @param at Turbine gain (At).
 *        Typical Value = 1.2.
 * @param bgv0 Kaplan blade servo point 0 (Bgv0).
 *        Typical Value = 0.
 * @param bgv1 Kaplan blade servo point 1 (Bgv1).
 *        Typical Value = 0.
 * @param bgv2 Kaplan blade servo point 2 (Bgv2).
 *        Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.1.
 * @param bgv3 Kaplan blade servo point 3 (Bgv3).
 *        Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.667.
 * @param bgv4 Kaplan blade servo point 4 (Bgv4).
 *        Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.9.
 * @param bgv5 Kaplan blade servo point 5 (Bgv5).
 *        Typical Value = 0.  Typical Value Francis = 0, Kaplan = 1.
 * @param bmax Maximum blade adjustment factor (Bmax).
 *        Typical Value = 0.  Typical Value Francis = 0, Kaplan = 1.1276.
 * @param db1 Intentional deadband width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param dturb Turbine damping factor (Dturb).
 *        Unit = delta P (PU of MWbase) / delta speed (PU).
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gmax Maximum gate opening, PU of MWbase (Gmax).
 *        Typical Value = 1.
 * @param gmin Minimum gate opening, PU of MWbase (Gmin).
 *        Typical Value = 0.
 * @param gv0 Nonlinear gain point 0, PU gv (Gv0).
 *        Typical Value = 0.  Typical Value Francis = 0.1, Kaplan = 0.1.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.  Typical Value Francis = 0.4, Kaplan = 0.4.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.  Typical Value Francis = 0.5, Kaplan = 0.5.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.  Typical Value Francis = 0.7, Kaplan = 0.7.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.  Typical Value Francis = 0.8, Kaplan = 0.8.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.  Typical Value Francis = 0.9, Kaplan = 0.9.
 * @param hdam Head available at dam (hdam).
 *        Typical Value = 1.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv0 Nonlinear gain point 0, PU power (Pgv0).
 *        Typical Value = 0.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.  Typical Value Francis = 0.42, Kaplan = 0.35.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.  Typical Value Francis = 0.56, Kaplan = 0.468.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.  Typical Value Francis = 0.8, Kaplan = 0.796.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.  Typical Value Francis = 0.9, Kaplan = 0.917.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.  Typical Value Francis = 0.97, Kaplan = 0.99.
 * @param qn1 No-load flow at nominal head (Qnl).
 *        Typical Value = 0.08.  Typical Value Francis = 0, Kaplan = 0.
 * @param rperm Permanent droop (Rperm).
 *        Typical Value = 0.05.
 * @param rtemp Temporary droop (Rtemp).
 *        Typical Value = 0.3.
 * @param tblade Blade servo time constant (Tblade).
 *        Typical Value = 100.
 * @param tg Gate servo time constant (Tg) (&gt;0).
 *        Typical Value = 0.5.
 * @param tp Pilot servo time constant (Tp).
 *        Typical Value = 0.1.
 * @param tr Dashpot time constant (Tr) (&gt;0).
 *        Typical Value = 5.
 * @param tw Water inertia time constant (Tw) (&gt;0).
 *        Typical Value = 1.
 * @param uc Max gate closing velocity (Uc).
 *        Typical Value = 0.2.
 * @param uo Max gate opening velocity (Uo).
 *        Typical Value = 0.2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydro4
(
    override val sup: TurbineGovernorDynamics,
    at: Double,
    bgv0: Double,
    bgv1: Double,
    bgv2: Double,
    bgv3: Double,
    bgv4: Double,
    bgv5: Double,
    bmax: Double,
    db1: Double,
    db2: Double,
    dturb: Double,
    eps: Double,
    gmax: Double,
    gmin: Double,
    gv0: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    hdam: Double,
    mwbase: Double,
    pgv0: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    qn1: Double,
    rperm: Double,
    rtemp: Double,
    tblade: Double,
    tg: Double,
    tp: Double,
    tr: Double,
    tw: Double,
    uc: Double,
    uo: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydro4.at>" + at + "</cim:GovHydro4.at>\n" +
        "\t\t<cim:GovHydro4.bgv0>" + bgv0 + "</cim:GovHydro4.bgv0>\n" +
        "\t\t<cim:GovHydro4.bgv1>" + bgv1 + "</cim:GovHydro4.bgv1>\n" +
        "\t\t<cim:GovHydro4.bgv2>" + bgv2 + "</cim:GovHydro4.bgv2>\n" +
        "\t\t<cim:GovHydro4.bgv3>" + bgv3 + "</cim:GovHydro4.bgv3>\n" +
        "\t\t<cim:GovHydro4.bgv4>" + bgv4 + "</cim:GovHydro4.bgv4>\n" +
        "\t\t<cim:GovHydro4.bgv5>" + bgv5 + "</cim:GovHydro4.bgv5>\n" +
        "\t\t<cim:GovHydro4.bmax>" + bmax + "</cim:GovHydro4.bmax>\n" +
        "\t\t<cim:GovHydro4.db1>" + db1 + "</cim:GovHydro4.db1>\n" +
        "\t\t<cim:GovHydro4.db2>" + db2 + "</cim:GovHydro4.db2>\n" +
        "\t\t<cim:GovHydro4.dturb>" + dturb + "</cim:GovHydro4.dturb>\n" +
        "\t\t<cim:GovHydro4.eps>" + eps + "</cim:GovHydro4.eps>\n" +
        "\t\t<cim:GovHydro4.gmax>" + gmax + "</cim:GovHydro4.gmax>\n" +
        "\t\t<cim:GovHydro4.gmin>" + gmin + "</cim:GovHydro4.gmin>\n" +
        "\t\t<cim:GovHydro4.gv0>" + gv0 + "</cim:GovHydro4.gv0>\n" +
        "\t\t<cim:GovHydro4.gv1>" + gv1 + "</cim:GovHydro4.gv1>\n" +
        "\t\t<cim:GovHydro4.gv2>" + gv2 + "</cim:GovHydro4.gv2>\n" +
        "\t\t<cim:GovHydro4.gv3>" + gv3 + "</cim:GovHydro4.gv3>\n" +
        "\t\t<cim:GovHydro4.gv4>" + gv4 + "</cim:GovHydro4.gv4>\n" +
        "\t\t<cim:GovHydro4.gv5>" + gv5 + "</cim:GovHydro4.gv5>\n" +
        "\t\t<cim:GovHydro4.hdam>" + hdam + "</cim:GovHydro4.hdam>\n" +
        "\t\t<cim:GovHydro4.mwbase>" + mwbase + "</cim:GovHydro4.mwbase>\n" +
        "\t\t<cim:GovHydro4.pgv0>" + pgv0 + "</cim:GovHydro4.pgv0>\n" +
        "\t\t<cim:GovHydro4.pgv1>" + pgv1 + "</cim:GovHydro4.pgv1>\n" +
        "\t\t<cim:GovHydro4.pgv2>" + pgv2 + "</cim:GovHydro4.pgv2>\n" +
        "\t\t<cim:GovHydro4.pgv3>" + pgv3 + "</cim:GovHydro4.pgv3>\n" +
        "\t\t<cim:GovHydro4.pgv4>" + pgv4 + "</cim:GovHydro4.pgv4>\n" +
        "\t\t<cim:GovHydro4.pgv5>" + pgv5 + "</cim:GovHydro4.pgv5>\n" +
        "\t\t<cim:GovHydro4.qn1>" + qn1 + "</cim:GovHydro4.qn1>\n" +
        "\t\t<cim:GovHydro4.rperm>" + rperm + "</cim:GovHydro4.rperm>\n" +
        "\t\t<cim:GovHydro4.rtemp>" + rtemp + "</cim:GovHydro4.rtemp>\n" +
        "\t\t<cim:GovHydro4.tblade>" + tblade + "</cim:GovHydro4.tblade>\n" +
        "\t\t<cim:GovHydro4.tg>" + tg + "</cim:GovHydro4.tg>\n" +
        "\t\t<cim:GovHydro4.tp>" + tp + "</cim:GovHydro4.tp>\n" +
        "\t\t<cim:GovHydro4.tr>" + tr + "</cim:GovHydro4.tr>\n" +
        "\t\t<cim:GovHydro4.tw>" + tw + "</cim:GovHydro4.tw>\n" +
        "\t\t<cim:GovHydro4.uc>" + uc + "</cim:GovHydro4.uc>\n" +
        "\t\t<cim:GovHydro4.uo>" + uo + "</cim:GovHydro4.uo>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydro4 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydro4>"
    }
}

object GovHydro4
extends
    Parseable[GovHydro4]
{
    val at = parse_element (element ("""GovHydro4.at"""))
    val bgv0 = parse_element (element ("""GovHydro4.bgv0"""))
    val bgv1 = parse_element (element ("""GovHydro4.bgv1"""))
    val bgv2 = parse_element (element ("""GovHydro4.bgv2"""))
    val bgv3 = parse_element (element ("""GovHydro4.bgv3"""))
    val bgv4 = parse_element (element ("""GovHydro4.bgv4"""))
    val bgv5 = parse_element (element ("""GovHydro4.bgv5"""))
    val bmax = parse_element (element ("""GovHydro4.bmax"""))
    val db1 = parse_element (element ("""GovHydro4.db1"""))
    val db2 = parse_element (element ("""GovHydro4.db2"""))
    val dturb = parse_element (element ("""GovHydro4.dturb"""))
    val eps = parse_element (element ("""GovHydro4.eps"""))
    val gmax = parse_element (element ("""GovHydro4.gmax"""))
    val gmin = parse_element (element ("""GovHydro4.gmin"""))
    val gv0 = parse_element (element ("""GovHydro4.gv0"""))
    val gv1 = parse_element (element ("""GovHydro4.gv1"""))
    val gv2 = parse_element (element ("""GovHydro4.gv2"""))
    val gv3 = parse_element (element ("""GovHydro4.gv3"""))
    val gv4 = parse_element (element ("""GovHydro4.gv4"""))
    val gv5 = parse_element (element ("""GovHydro4.gv5"""))
    val hdam = parse_element (element ("""GovHydro4.hdam"""))
    val mwbase = parse_element (element ("""GovHydro4.mwbase"""))
    val pgv0 = parse_element (element ("""GovHydro4.pgv0"""))
    val pgv1 = parse_element (element ("""GovHydro4.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydro4.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydro4.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydro4.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydro4.pgv5"""))
    val qn1 = parse_element (element ("""GovHydro4.qn1"""))
    val rperm = parse_element (element ("""GovHydro4.rperm"""))
    val rtemp = parse_element (element ("""GovHydro4.rtemp"""))
    val tblade = parse_element (element ("""GovHydro4.tblade"""))
    val tg = parse_element (element ("""GovHydro4.tg"""))
    val tp = parse_element (element ("""GovHydro4.tp"""))
    val tr = parse_element (element ("""GovHydro4.tr"""))
    val tw = parse_element (element ("""GovHydro4.tw"""))
    val uc = parse_element (element ("""GovHydro4.uc"""))
    val uo = parse_element (element ("""GovHydro4.uo"""))
    def parse (context: Context): GovHydro4 =
    {
        GovHydro4(
            TurbineGovernorDynamics.parse (context),
            toDouble (at (context), context),
            toDouble (bgv0 (context), context),
            toDouble (bgv1 (context), context),
            toDouble (bgv2 (context), context),
            toDouble (bgv3 (context), context),
            toDouble (bgv4 (context), context),
            toDouble (bgv5 (context), context),
            toDouble (bmax (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (dturb (context), context),
            toDouble (eps (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (gv0 (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (hdam (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv0 (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (qn1 (context), context),
            toDouble (rperm (context), context),
            toDouble (rtemp (context), context),
            toDouble (tblade (context), context),
            toDouble (tg (context), context),
            toDouble (tp (context), context),
            toDouble (tr (context), context),
            toDouble (tw (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context)
        )
    }
}

/**
 * Double derivative hydro governor and turbine.
 *
 * @param sup Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (Aturb) (note 3).
 *        Typical Value = -1.
 * @param bturb Turbine denominator multiplier (Bturb) (note 3).
 *        Typical Value = 0.5.
 * @param db1 Intentional dead-band width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gmax Maximum gate opening (Gmax).
 *        Typical Value = 0.
 * @param gmin Minimum gate opening (Gmin).
 *        Typical Value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param inputSignal Input signal switch (Flag).
 *        true = Pe input is used
 *        false = feedback is received from CV.
 *        Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.
 * @param k1 Single derivative gain (K1).
 *        Typical Value = 3.6.
 * @param k2 Double derivative gain (K2).
 *        Typical Value = 0.2.
 * @param kg Gate servo gain (Kg).
 *        Typical Value = 3.
 * @param ki Integral gain (Ki).
 *        Typical Value = 1.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening, PU of MWbase (Pmin).
 *        Typical Value = 0.
 * @param r Steady state droop (R).
 *        Typical Value = 0.05.
 * @param td Input filter time constant (Td).
 *        Typical Value = 0.
 * @param tf Washout time constant (Tf).
 *        Typical Value = 0.1.
 * @param tp Gate servo time constant (Tp).
 *        Typical Value = 0.35.
 * @param tt Power feedback time constant (Tt).
 *        Typical Value = 0.02.
 * @param tturb Turbine time constant (Tturb) (note 3).
 *        Typical Value = 0.8.
 * @param velcl Maximum gate closing velocity (Velcl).
 *        Unit = PU/sec.  Typical Value = -0.14.
 * @param velop Maximum gate opening velocity (Velop).
 *        Unit = PU/sec.  Typical Value = 0.09.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroDD
(
    override val sup: TurbineGovernorDynamics,
    aturb: Double,
    bturb: Double,
    db1: Double,
    db2: Double,
    eps: Double,
    gmax: Double,
    gmin: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    inputSignal: Boolean,
    k1: Double,
    k2: Double,
    kg: Double,
    ki: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    r: Double,
    td: Double,
    tf: Double,
    tp: Double,
    tt: Double,
    tturb: Double,
    velcl: Double,
    velop: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroDD.aturb>" + aturb + "</cim:GovHydroDD.aturb>\n" +
        "\t\t<cim:GovHydroDD.bturb>" + bturb + "</cim:GovHydroDD.bturb>\n" +
        "\t\t<cim:GovHydroDD.db1>" + db1 + "</cim:GovHydroDD.db1>\n" +
        "\t\t<cim:GovHydroDD.db2>" + db2 + "</cim:GovHydroDD.db2>\n" +
        "\t\t<cim:GovHydroDD.eps>" + eps + "</cim:GovHydroDD.eps>\n" +
        "\t\t<cim:GovHydroDD.gmax>" + gmax + "</cim:GovHydroDD.gmax>\n" +
        "\t\t<cim:GovHydroDD.gmin>" + gmin + "</cim:GovHydroDD.gmin>\n" +
        "\t\t<cim:GovHydroDD.gv1>" + gv1 + "</cim:GovHydroDD.gv1>\n" +
        "\t\t<cim:GovHydroDD.gv2>" + gv2 + "</cim:GovHydroDD.gv2>\n" +
        "\t\t<cim:GovHydroDD.gv3>" + gv3 + "</cim:GovHydroDD.gv3>\n" +
        "\t\t<cim:GovHydroDD.gv4>" + gv4 + "</cim:GovHydroDD.gv4>\n" +
        "\t\t<cim:GovHydroDD.gv5>" + gv5 + "</cim:GovHydroDD.gv5>\n" +
        "\t\t<cim:GovHydroDD.gv6>" + gv6 + "</cim:GovHydroDD.gv6>\n" +
        "\t\t<cim:GovHydroDD.inputSignal>" + inputSignal + "</cim:GovHydroDD.inputSignal>\n" +
        "\t\t<cim:GovHydroDD.k1>" + k1 + "</cim:GovHydroDD.k1>\n" +
        "\t\t<cim:GovHydroDD.k2>" + k2 + "</cim:GovHydroDD.k2>\n" +
        "\t\t<cim:GovHydroDD.kg>" + kg + "</cim:GovHydroDD.kg>\n" +
        "\t\t<cim:GovHydroDD.ki>" + ki + "</cim:GovHydroDD.ki>\n" +
        "\t\t<cim:GovHydroDD.mwbase>" + mwbase + "</cim:GovHydroDD.mwbase>\n" +
        "\t\t<cim:GovHydroDD.pgv1>" + pgv1 + "</cim:GovHydroDD.pgv1>\n" +
        "\t\t<cim:GovHydroDD.pgv2>" + pgv2 + "</cim:GovHydroDD.pgv2>\n" +
        "\t\t<cim:GovHydroDD.pgv3>" + pgv3 + "</cim:GovHydroDD.pgv3>\n" +
        "\t\t<cim:GovHydroDD.pgv4>" + pgv4 + "</cim:GovHydroDD.pgv4>\n" +
        "\t\t<cim:GovHydroDD.pgv5>" + pgv5 + "</cim:GovHydroDD.pgv5>\n" +
        "\t\t<cim:GovHydroDD.pgv6>" + pgv6 + "</cim:GovHydroDD.pgv6>\n" +
        "\t\t<cim:GovHydroDD.pmax>" + pmax + "</cim:GovHydroDD.pmax>\n" +
        "\t\t<cim:GovHydroDD.pmin>" + pmin + "</cim:GovHydroDD.pmin>\n" +
        "\t\t<cim:GovHydroDD.r>" + r + "</cim:GovHydroDD.r>\n" +
        "\t\t<cim:GovHydroDD.td>" + td + "</cim:GovHydroDD.td>\n" +
        "\t\t<cim:GovHydroDD.tf>" + tf + "</cim:GovHydroDD.tf>\n" +
        "\t\t<cim:GovHydroDD.tp>" + tp + "</cim:GovHydroDD.tp>\n" +
        "\t\t<cim:GovHydroDD.tt>" + tt + "</cim:GovHydroDD.tt>\n" +
        "\t\t<cim:GovHydroDD.tturb>" + tturb + "</cim:GovHydroDD.tturb>\n" +
        "\t\t<cim:GovHydroDD.velcl>" + velcl + "</cim:GovHydroDD.velcl>\n" +
        "\t\t<cim:GovHydroDD.velop>" + velop + "</cim:GovHydroDD.velop>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroDD rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroDD>"
    }
}

object GovHydroDD
extends
    Parseable[GovHydroDD]
{
    val aturb = parse_element (element ("""GovHydroDD.aturb"""))
    val bturb = parse_element (element ("""GovHydroDD.bturb"""))
    val db1 = parse_element (element ("""GovHydroDD.db1"""))
    val db2 = parse_element (element ("""GovHydroDD.db2"""))
    val eps = parse_element (element ("""GovHydroDD.eps"""))
    val gmax = parse_element (element ("""GovHydroDD.gmax"""))
    val gmin = parse_element (element ("""GovHydroDD.gmin"""))
    val gv1 = parse_element (element ("""GovHydroDD.gv1"""))
    val gv2 = parse_element (element ("""GovHydroDD.gv2"""))
    val gv3 = parse_element (element ("""GovHydroDD.gv3"""))
    val gv4 = parse_element (element ("""GovHydroDD.gv4"""))
    val gv5 = parse_element (element ("""GovHydroDD.gv5"""))
    val gv6 = parse_element (element ("""GovHydroDD.gv6"""))
    val inputSignal = parse_element (element ("""GovHydroDD.inputSignal"""))
    val k1 = parse_element (element ("""GovHydroDD.k1"""))
    val k2 = parse_element (element ("""GovHydroDD.k2"""))
    val kg = parse_element (element ("""GovHydroDD.kg"""))
    val ki = parse_element (element ("""GovHydroDD.ki"""))
    val mwbase = parse_element (element ("""GovHydroDD.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydroDD.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydroDD.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydroDD.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydroDD.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydroDD.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydroDD.pgv6"""))
    val pmax = parse_element (element ("""GovHydroDD.pmax"""))
    val pmin = parse_element (element ("""GovHydroDD.pmin"""))
    val r = parse_element (element ("""GovHydroDD.r"""))
    val td = parse_element (element ("""GovHydroDD.td"""))
    val tf = parse_element (element ("""GovHydroDD.tf"""))
    val tp = parse_element (element ("""GovHydroDD.tp"""))
    val tt = parse_element (element ("""GovHydroDD.tt"""))
    val tturb = parse_element (element ("""GovHydroDD.tturb"""))
    val velcl = parse_element (element ("""GovHydroDD.velcl"""))
    val velop = parse_element (element ("""GovHydroDD.velop"""))
    def parse (context: Context): GovHydroDD =
    {
        GovHydroDD(
            TurbineGovernorDynamics.parse (context),
            toDouble (aturb (context), context),
            toDouble (bturb (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (eps (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toBoolean (inputSignal (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (r (context), context),
            toDouble (td (context), context),
            toDouble (tf (context), context),
            toDouble (tp (context), context),
            toDouble (tt (context), context),
            toDouble (tturb (context), context),
            toDouble (velcl (context), context),
            toDouble (velop (context), context)
        )
    }
}

/**
 * Detailed hydro unit - Francis model.
 *
 * This model can be used to represent three types of governors.
 *
 * @param sup Reference to the superclass object.
 * @param am Opening section S<sub>eff</sub> at the maximum efficiency (Am).
 *        Typical Value = 0.7.
 * @param av0 Area of the surge tank (A<sub>V0</sub>).
 *        Unit = m<sup>2</sup>. Typical Value = 30.
 * @param av1 Area of the compensation tank (A<sub>V1</sub>).
 *        Unit = m<sup>2</sup>. Typical Value = 700.
 * @param bp Droop (Bp).
 *        Typical Value = 0.05.
 * @param db1 Intentional dead-band width (DB1).
 *        Unit = Hz.  Typical Value = 0.
 * @param etamax Maximum efficiency (EtaMax).
 *        Typical Value = 1.05.
 * @param governorControl Governor control flag (Cflag).
 *        Typical Value = mechanicHydrolicTachoAccelerator.
 * @param h1 Head of compensation chamber water level with respect to the level of penstock (H<sub>1</sub>).
 *        Unit = m. Typical Value = 4.
 * @param h2 Head of surge tank water level with respect to the level of penstock (H<sub>2</sub>).
 *        Unit = m. Typical Value = 40.
 * @param hn Rated hydraulic head (H<sub>n</sub>).
 *        Unit = m. Typical Value = 250.
 * @param kc Penstock loss coefficient (due to friction) (Kc).
 *        Typical Value = 0.025.
 * @param kg Water tunnel and surge chamber loss coefficient (due to friction) (Kg).
 *        Typical Value = 0.025.
 * @param kt Washout gain (Kt).
 *        Typical Value = 0.25.
 * @param qc0 No-load turbine flow at nominal head (Qc0).
 *        Typical Value = 0.21.
 * @param qn Rated flow (Q<sub>n</sub>).
 *        Unit = m<sup>3</sup>/s. Typical Value = 40.
 * @param ta Derivative gain (Ta).
 *        Typical Value = 3.
 * @param td Washout time constant (Td).
 *        Typical Value = 3.
 * @param ts Gate servo time constant (Ts).
 *        Typical Value = 0.5.
 * @param twnc Water inertia time constant (Twnc).
 *        Typical Value = 1.
 * @param twng Water tunnel and surge chamber inertia time constant (Twng).
 *        Typical Value = 3.
 * @param tx Derivative feedback gain (Tx).
 *        Typical Value = 1.
 * @param va Maximum gate opening velocity (Va).
 *        Unit = PU/sec.  Typical Value = 0.011.
 * @param valvmax Maximum gate opening (ValvMax).
 *        Typical Value = 1.
 * @param valvmin Minimum gate opening (ValvMin).
 *        Typical Value = 0.
 * @param vc Maximum gate closing velocity (Vc).
 *        Unit = PU/sec.  Typical Value = -0.011.
 * @param waterTunnelSurgeChamberSimulation Water tunnel and surge chamber simulation (Tflag).
 *        true = enable of water tunnel and surge chamber simulation
 *        false = inhibit of water tunnel and surge chamber simulation.
 *        Typical Value = false.
 * @param zsfc Head of upper water level with respect to the level of penstock (Zsfc).
 *        Unit = m.  Typical Value = 25.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroFrancis
(
    override val sup: TurbineGovernorDynamics,
    am: Double,
    av0: Double,
    av1: Double,
    bp: Double,
    db1: Double,
    etamax: Double,
    governorControl: String,
    h1: Double,
    h2: Double,
    hn: Double,
    kc: Double,
    kg: Double,
    kt: Double,
    qc0: Double,
    qn: Double,
    ta: Double,
    td: Double,
    ts: Double,
    twnc: Double,
    twng: Double,
    tx: Double,
    va: Double,
    valvmax: Double,
    valvmin: Double,
    vc: Double,
    waterTunnelSurgeChamberSimulation: Boolean,
    zsfc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroFrancis.am>" + am + "</cim:GovHydroFrancis.am>\n" +
        "\t\t<cim:GovHydroFrancis.av0>" + av0 + "</cim:GovHydroFrancis.av0>\n" +
        "\t\t<cim:GovHydroFrancis.av1>" + av1 + "</cim:GovHydroFrancis.av1>\n" +
        "\t\t<cim:GovHydroFrancis.bp>" + bp + "</cim:GovHydroFrancis.bp>\n" +
        "\t\t<cim:GovHydroFrancis.db1>" + db1 + "</cim:GovHydroFrancis.db1>\n" +
        "\t\t<cim:GovHydroFrancis.etamax>" + etamax + "</cim:GovHydroFrancis.etamax>\n" +
        (if (null != governorControl) "\t\t<cim:GovHydroFrancis.governorControl rdf:resource=\"#" + governorControl + "\"/>\n" else "") +
        "\t\t<cim:GovHydroFrancis.h1>" + h1 + "</cim:GovHydroFrancis.h1>\n" +
        "\t\t<cim:GovHydroFrancis.h2>" + h2 + "</cim:GovHydroFrancis.h2>\n" +
        "\t\t<cim:GovHydroFrancis.hn>" + hn + "</cim:GovHydroFrancis.hn>\n" +
        "\t\t<cim:GovHydroFrancis.kc>" + kc + "</cim:GovHydroFrancis.kc>\n" +
        "\t\t<cim:GovHydroFrancis.kg>" + kg + "</cim:GovHydroFrancis.kg>\n" +
        "\t\t<cim:GovHydroFrancis.kt>" + kt + "</cim:GovHydroFrancis.kt>\n" +
        "\t\t<cim:GovHydroFrancis.qc0>" + qc0 + "</cim:GovHydroFrancis.qc0>\n" +
        "\t\t<cim:GovHydroFrancis.qn>" + qn + "</cim:GovHydroFrancis.qn>\n" +
        "\t\t<cim:GovHydroFrancis.ta>" + ta + "</cim:GovHydroFrancis.ta>\n" +
        "\t\t<cim:GovHydroFrancis.td>" + td + "</cim:GovHydroFrancis.td>\n" +
        "\t\t<cim:GovHydroFrancis.ts>" + ts + "</cim:GovHydroFrancis.ts>\n" +
        "\t\t<cim:GovHydroFrancis.twnc>" + twnc + "</cim:GovHydroFrancis.twnc>\n" +
        "\t\t<cim:GovHydroFrancis.twng>" + twng + "</cim:GovHydroFrancis.twng>\n" +
        "\t\t<cim:GovHydroFrancis.tx>" + tx + "</cim:GovHydroFrancis.tx>\n" +
        "\t\t<cim:GovHydroFrancis.va>" + va + "</cim:GovHydroFrancis.va>\n" +
        "\t\t<cim:GovHydroFrancis.valvmax>" + valvmax + "</cim:GovHydroFrancis.valvmax>\n" +
        "\t\t<cim:GovHydroFrancis.valvmin>" + valvmin + "</cim:GovHydroFrancis.valvmin>\n" +
        "\t\t<cim:GovHydroFrancis.vc>" + vc + "</cim:GovHydroFrancis.vc>\n" +
        "\t\t<cim:GovHydroFrancis.waterTunnelSurgeChamberSimulation>" + waterTunnelSurgeChamberSimulation + "</cim:GovHydroFrancis.waterTunnelSurgeChamberSimulation>\n" +
        "\t\t<cim:GovHydroFrancis.zsfc>" + zsfc + "</cim:GovHydroFrancis.zsfc>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroFrancis rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroFrancis>"
    }
}

object GovHydroFrancis
extends
    Parseable[GovHydroFrancis]
{
    val am = parse_element (element ("""GovHydroFrancis.am"""))
    val av0 = parse_element (element ("""GovHydroFrancis.av0"""))
    val av1 = parse_element (element ("""GovHydroFrancis.av1"""))
    val bp = parse_element (element ("""GovHydroFrancis.bp"""))
    val db1 = parse_element (element ("""GovHydroFrancis.db1"""))
    val etamax = parse_element (element ("""GovHydroFrancis.etamax"""))
    val governorControl = parse_attribute (attribute ("""GovHydroFrancis.governorControl"""))
    val h1 = parse_element (element ("""GovHydroFrancis.h1"""))
    val h2 = parse_element (element ("""GovHydroFrancis.h2"""))
    val hn = parse_element (element ("""GovHydroFrancis.hn"""))
    val kc = parse_element (element ("""GovHydroFrancis.kc"""))
    val kg = parse_element (element ("""GovHydroFrancis.kg"""))
    val kt = parse_element (element ("""GovHydroFrancis.kt"""))
    val qc0 = parse_element (element ("""GovHydroFrancis.qc0"""))
    val qn = parse_element (element ("""GovHydroFrancis.qn"""))
    val ta = parse_element (element ("""GovHydroFrancis.ta"""))
    val td = parse_element (element ("""GovHydroFrancis.td"""))
    val ts = parse_element (element ("""GovHydroFrancis.ts"""))
    val twnc = parse_element (element ("""GovHydroFrancis.twnc"""))
    val twng = parse_element (element ("""GovHydroFrancis.twng"""))
    val tx = parse_element (element ("""GovHydroFrancis.tx"""))
    val va = parse_element (element ("""GovHydroFrancis.va"""))
    val valvmax = parse_element (element ("""GovHydroFrancis.valvmax"""))
    val valvmin = parse_element (element ("""GovHydroFrancis.valvmin"""))
    val vc = parse_element (element ("""GovHydroFrancis.vc"""))
    val waterTunnelSurgeChamberSimulation = parse_element (element ("""GovHydroFrancis.waterTunnelSurgeChamberSimulation"""))
    val zsfc = parse_element (element ("""GovHydroFrancis.zsfc"""))
    def parse (context: Context): GovHydroFrancis =
    {
        GovHydroFrancis(
            TurbineGovernorDynamics.parse (context),
            toDouble (am (context), context),
            toDouble (av0 (context), context),
            toDouble (av1 (context), context),
            toDouble (bp (context), context),
            toDouble (db1 (context), context),
            toDouble (etamax (context), context),
            governorControl (context),
            toDouble (h1 (context), context),
            toDouble (h2 (context), context),
            toDouble (hn (context), context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (kt (context), context),
            toDouble (qc0 (context), context),
            toDouble (qn (context), context),
            toDouble (ta (context), context),
            toDouble (td (context), context),
            toDouble (ts (context), context),
            toDouble (twnc (context), context),
            toDouble (twng (context), context),
            toDouble (tx (context), context),
            toDouble (va (context), context),
            toDouble (valvmax (context), context),
            toDouble (valvmin (context), context),
            toDouble (vc (context), context),
            toBoolean (waterTunnelSurgeChamberSimulation (context), context),
            toDouble (zsfc (context), context)
        )
    }
}

/**
 * IEEE Simplified Hydro Governor-Turbine Model.
 *
 * Used for Mechanical-Hydraulic and Electro-Hydraulic turbine governors, with our without steam feedback. Typical values given are for Mechanical-Hydraulic.
 *
 * @param sup Reference to the superclass object.
 * @param k Governor gain (K<i>)</i>.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param pmax Gate maximum (Pmax).
 * @param pmin Gate minimum (Pmin).
 * @param t1 Governor lag time constant (T1).
 *        Typical Value = 0.25.
 * @param t2 Governor lead time constant (T2<i>)</i>.
 *        Typical Value = 0.
 * @param t3 Gate actuator time constant (T3).
 *        Typical Value = 0.1.
 * @param t4 Water starting time (T4).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroIEEE0
(
    override val sup: TurbineGovernorDynamics,
    k: Double,
    mwbase: Double,
    pmax: Double,
    pmin: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroIEEE0.k>" + k + "</cim:GovHydroIEEE0.k>\n" +
        "\t\t<cim:GovHydroIEEE0.mwbase>" + mwbase + "</cim:GovHydroIEEE0.mwbase>\n" +
        "\t\t<cim:GovHydroIEEE0.pmax>" + pmax + "</cim:GovHydroIEEE0.pmax>\n" +
        "\t\t<cim:GovHydroIEEE0.pmin>" + pmin + "</cim:GovHydroIEEE0.pmin>\n" +
        "\t\t<cim:GovHydroIEEE0.t1>" + t1 + "</cim:GovHydroIEEE0.t1>\n" +
        "\t\t<cim:GovHydroIEEE0.t2>" + t2 + "</cim:GovHydroIEEE0.t2>\n" +
        "\t\t<cim:GovHydroIEEE0.t3>" + t3 + "</cim:GovHydroIEEE0.t3>\n" +
        "\t\t<cim:GovHydroIEEE0.t4>" + t4 + "</cim:GovHydroIEEE0.t4>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroIEEE0 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroIEEE0>"
    }
}

object GovHydroIEEE0
extends
    Parseable[GovHydroIEEE0]
{
    val k = parse_element (element ("""GovHydroIEEE0.k"""))
    val mwbase = parse_element (element ("""GovHydroIEEE0.mwbase"""))
    val pmax = parse_element (element ("""GovHydroIEEE0.pmax"""))
    val pmin = parse_element (element ("""GovHydroIEEE0.pmin"""))
    val t1 = parse_element (element ("""GovHydroIEEE0.t1"""))
    val t2 = parse_element (element ("""GovHydroIEEE0.t2"""))
    val t3 = parse_element (element ("""GovHydroIEEE0.t3"""))
    val t4 = parse_element (element ("""GovHydroIEEE0.t4"""))
    def parse (context: Context): GovHydroIEEE0 =
    {
        GovHydroIEEE0(
            TurbineGovernorDynamics.parse (context),
            toDouble (k (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context)
        )
    }
}

/**
 * IEEE hydro turbine governor model represents plants with straightforward penstock configurations and hydraulic-dashpot governors.
 *
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems</font>
 *
 * @param sup Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (Aturb).
 *        Typical Value = -1.
 * @param bturb Turbine denominator multiplier (Bturb).
 *        Typical Value = 0.5.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param kturb Turbine gain (Kturb).
 *        Typical Value = 1.
 * @param mwbase Base for power values (MWbase) (&gt; 0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening (Pmin).
 *        Typical Value = 0.
 * @param rperm Permanent droop (Rperm).
 *        Typical Value = 0.05.
 * @param rtemp Temporary droop (Rtemp).
 *        Typical Value = 0.5.
 * @param tg Gate servo time constant (Tg).
 *        Typical Value = 0.5.
 * @param tp Pilot servo valve time constant (Tp).
 *        Typical Value = 0.03.
 * @param tr Dashpot time constant (Tr).
 *        Typical Value = 12.
 * @param tw Water inertia time constant (Tw).
 *        Typical Value = 2.
 * @param uc Maximum gate closing velocity (Uc) (&lt;0).
 *        Typical Value = -0.1.
 * @param uo Maximum gate opening velocity (Uo).
 *        Unit = PU/sec.  Typical Value = 0.1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroIEEE2
(
    override val sup: TurbineGovernorDynamics,
    aturb: Double,
    bturb: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    kturb: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    rperm: Double,
    rtemp: Double,
    tg: Double,
    tp: Double,
    tr: Double,
    tw: Double,
    uc: Double,
    uo: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroIEEE2.aturb>" + aturb + "</cim:GovHydroIEEE2.aturb>\n" +
        "\t\t<cim:GovHydroIEEE2.bturb>" + bturb + "</cim:GovHydroIEEE2.bturb>\n" +
        "\t\t<cim:GovHydroIEEE2.gv1>" + gv1 + "</cim:GovHydroIEEE2.gv1>\n" +
        "\t\t<cim:GovHydroIEEE2.gv2>" + gv2 + "</cim:GovHydroIEEE2.gv2>\n" +
        "\t\t<cim:GovHydroIEEE2.gv3>" + gv3 + "</cim:GovHydroIEEE2.gv3>\n" +
        "\t\t<cim:GovHydroIEEE2.gv4>" + gv4 + "</cim:GovHydroIEEE2.gv4>\n" +
        "\t\t<cim:GovHydroIEEE2.gv5>" + gv5 + "</cim:GovHydroIEEE2.gv5>\n" +
        "\t\t<cim:GovHydroIEEE2.gv6>" + gv6 + "</cim:GovHydroIEEE2.gv6>\n" +
        "\t\t<cim:GovHydroIEEE2.kturb>" + kturb + "</cim:GovHydroIEEE2.kturb>\n" +
        "\t\t<cim:GovHydroIEEE2.mwbase>" + mwbase + "</cim:GovHydroIEEE2.mwbase>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv1>" + pgv1 + "</cim:GovHydroIEEE2.pgv1>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv2>" + pgv2 + "</cim:GovHydroIEEE2.pgv2>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv3>" + pgv3 + "</cim:GovHydroIEEE2.pgv3>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv4>" + pgv4 + "</cim:GovHydroIEEE2.pgv4>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv5>" + pgv5 + "</cim:GovHydroIEEE2.pgv5>\n" +
        "\t\t<cim:GovHydroIEEE2.pgv6>" + pgv6 + "</cim:GovHydroIEEE2.pgv6>\n" +
        "\t\t<cim:GovHydroIEEE2.pmax>" + pmax + "</cim:GovHydroIEEE2.pmax>\n" +
        "\t\t<cim:GovHydroIEEE2.pmin>" + pmin + "</cim:GovHydroIEEE2.pmin>\n" +
        "\t\t<cim:GovHydroIEEE2.rperm>" + rperm + "</cim:GovHydroIEEE2.rperm>\n" +
        "\t\t<cim:GovHydroIEEE2.rtemp>" + rtemp + "</cim:GovHydroIEEE2.rtemp>\n" +
        "\t\t<cim:GovHydroIEEE2.tg>" + tg + "</cim:GovHydroIEEE2.tg>\n" +
        "\t\t<cim:GovHydroIEEE2.tp>" + tp + "</cim:GovHydroIEEE2.tp>\n" +
        "\t\t<cim:GovHydroIEEE2.tr>" + tr + "</cim:GovHydroIEEE2.tr>\n" +
        "\t\t<cim:GovHydroIEEE2.tw>" + tw + "</cim:GovHydroIEEE2.tw>\n" +
        "\t\t<cim:GovHydroIEEE2.uc>" + uc + "</cim:GovHydroIEEE2.uc>\n" +
        "\t\t<cim:GovHydroIEEE2.uo>" + uo + "</cim:GovHydroIEEE2.uo>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroIEEE2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroIEEE2>"
    }
}

object GovHydroIEEE2
extends
    Parseable[GovHydroIEEE2]
{
    val aturb = parse_element (element ("""GovHydroIEEE2.aturb"""))
    val bturb = parse_element (element ("""GovHydroIEEE2.bturb"""))
    val gv1 = parse_element (element ("""GovHydroIEEE2.gv1"""))
    val gv2 = parse_element (element ("""GovHydroIEEE2.gv2"""))
    val gv3 = parse_element (element ("""GovHydroIEEE2.gv3"""))
    val gv4 = parse_element (element ("""GovHydroIEEE2.gv4"""))
    val gv5 = parse_element (element ("""GovHydroIEEE2.gv5"""))
    val gv6 = parse_element (element ("""GovHydroIEEE2.gv6"""))
    val kturb = parse_element (element ("""GovHydroIEEE2.kturb"""))
    val mwbase = parse_element (element ("""GovHydroIEEE2.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydroIEEE2.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydroIEEE2.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydroIEEE2.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydroIEEE2.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydroIEEE2.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydroIEEE2.pgv6"""))
    val pmax = parse_element (element ("""GovHydroIEEE2.pmax"""))
    val pmin = parse_element (element ("""GovHydroIEEE2.pmin"""))
    val rperm = parse_element (element ("""GovHydroIEEE2.rperm"""))
    val rtemp = parse_element (element ("""GovHydroIEEE2.rtemp"""))
    val tg = parse_element (element ("""GovHydroIEEE2.tg"""))
    val tp = parse_element (element ("""GovHydroIEEE2.tp"""))
    val tr = parse_element (element ("""GovHydroIEEE2.tr"""))
    val tw = parse_element (element ("""GovHydroIEEE2.tw"""))
    val uc = parse_element (element ("""GovHydroIEEE2.uc"""))
    val uo = parse_element (element ("""GovHydroIEEE2.uo"""))
    def parse (context: Context): GovHydroIEEE2 =
    {
        GovHydroIEEE2(
            TurbineGovernorDynamics.parse (context),
            toDouble (aturb (context), context),
            toDouble (bturb (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (kturb (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (rperm (context), context),
            toDouble (rtemp (context), context),
            toDouble (tg (context), context),
            toDouble (tp (context), context),
            toDouble (tr (context), context),
            toDouble (tw (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context)
        )
    }
}

/**
 * PID governor and turbine.
 *
 * @param sup Reference to the superclass object.
 * @param aturb Turbine numerator multiplier (Aturb) (note 3).
 *        Typical Value -1.
 * @param bturb Turbine denominator multiplier (Bturb) (note 3).
 *        Typical Value = 0.5.
 * @param db1 Intentional dead-band width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param inputSignal Input signal switch (Flag).
 *        true = Pe input is used
 *        false = feedback is received from CV.
 *        Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.  Typical Value = true.
 * @param kd Derivative gain (Kd).
 *        Typical Value = 1.11.
 * @param kg Gate servo gain (Kg).
 *        Typical Value = 2.5.
 * @param ki Integral gain (Ki).
 *        Typical Value = 0.36.
 * @param kp Proportional gain (Kp).
 *        Typical Value = 0.1.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening, PU of MWbase (Pmin).
 *        Typical Value = 0.
 * @param r Steady state droop (R).
 *        Typical Value = 0.05.
 * @param td Input filter time constant (Td).
 *        Typical Value = 0.
 * @param tf Washout time constant (Tf).
 *        Typical Value = 0.1.
 * @param tp Gate servo time constant (Tp).
 *        Typical Value = 0.35.
 * @param tt Power feedback time constant (Tt).
 *        Typical Value = 0.02.
 * @param tturb Turbine time constant (Tturb) (note 3).
 *        Typical Value = 0.8.
 * @param velcl Maximum gate closing velocity (Velcl).
 *        Unit = PU/sec.  Typical Value = -0.14.
 * @param velop Maximum gate opening velocity (Velop).
 *        Unit = PU/sec.  Typical Value = 0.09.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroPID
(
    override val sup: TurbineGovernorDynamics,
    aturb: Double,
    bturb: Double,
    db1: Double,
    db2: Double,
    eps: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    inputSignal: Boolean,
    kd: Double,
    kg: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    r: Double,
    td: Double,
    tf: Double,
    tp: Double,
    tt: Double,
    tturb: Double,
    velcl: Double,
    velop: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroPID.aturb>" + aturb + "</cim:GovHydroPID.aturb>\n" +
        "\t\t<cim:GovHydroPID.bturb>" + bturb + "</cim:GovHydroPID.bturb>\n" +
        "\t\t<cim:GovHydroPID.db1>" + db1 + "</cim:GovHydroPID.db1>\n" +
        "\t\t<cim:GovHydroPID.db2>" + db2 + "</cim:GovHydroPID.db2>\n" +
        "\t\t<cim:GovHydroPID.eps>" + eps + "</cim:GovHydroPID.eps>\n" +
        "\t\t<cim:GovHydroPID.gv1>" + gv1 + "</cim:GovHydroPID.gv1>\n" +
        "\t\t<cim:GovHydroPID.gv2>" + gv2 + "</cim:GovHydroPID.gv2>\n" +
        "\t\t<cim:GovHydroPID.gv3>" + gv3 + "</cim:GovHydroPID.gv3>\n" +
        "\t\t<cim:GovHydroPID.gv4>" + gv4 + "</cim:GovHydroPID.gv4>\n" +
        "\t\t<cim:GovHydroPID.gv5>" + gv5 + "</cim:GovHydroPID.gv5>\n" +
        "\t\t<cim:GovHydroPID.gv6>" + gv6 + "</cim:GovHydroPID.gv6>\n" +
        "\t\t<cim:GovHydroPID.inputSignal>" + inputSignal + "</cim:GovHydroPID.inputSignal>\n" +
        "\t\t<cim:GovHydroPID.kd>" + kd + "</cim:GovHydroPID.kd>\n" +
        "\t\t<cim:GovHydroPID.kg>" + kg + "</cim:GovHydroPID.kg>\n" +
        "\t\t<cim:GovHydroPID.ki>" + ki + "</cim:GovHydroPID.ki>\n" +
        "\t\t<cim:GovHydroPID.kp>" + kp + "</cim:GovHydroPID.kp>\n" +
        "\t\t<cim:GovHydroPID.mwbase>" + mwbase + "</cim:GovHydroPID.mwbase>\n" +
        "\t\t<cim:GovHydroPID.pgv1>" + pgv1 + "</cim:GovHydroPID.pgv1>\n" +
        "\t\t<cim:GovHydroPID.pgv2>" + pgv2 + "</cim:GovHydroPID.pgv2>\n" +
        "\t\t<cim:GovHydroPID.pgv3>" + pgv3 + "</cim:GovHydroPID.pgv3>\n" +
        "\t\t<cim:GovHydroPID.pgv4>" + pgv4 + "</cim:GovHydroPID.pgv4>\n" +
        "\t\t<cim:GovHydroPID.pgv5>" + pgv5 + "</cim:GovHydroPID.pgv5>\n" +
        "\t\t<cim:GovHydroPID.pgv6>" + pgv6 + "</cim:GovHydroPID.pgv6>\n" +
        "\t\t<cim:GovHydroPID.pmax>" + pmax + "</cim:GovHydroPID.pmax>\n" +
        "\t\t<cim:GovHydroPID.pmin>" + pmin + "</cim:GovHydroPID.pmin>\n" +
        "\t\t<cim:GovHydroPID.r>" + r + "</cim:GovHydroPID.r>\n" +
        "\t\t<cim:GovHydroPID.td>" + td + "</cim:GovHydroPID.td>\n" +
        "\t\t<cim:GovHydroPID.tf>" + tf + "</cim:GovHydroPID.tf>\n" +
        "\t\t<cim:GovHydroPID.tp>" + tp + "</cim:GovHydroPID.tp>\n" +
        "\t\t<cim:GovHydroPID.tt>" + tt + "</cim:GovHydroPID.tt>\n" +
        "\t\t<cim:GovHydroPID.tturb>" + tturb + "</cim:GovHydroPID.tturb>\n" +
        "\t\t<cim:GovHydroPID.velcl>" + velcl + "</cim:GovHydroPID.velcl>\n" +
        "\t\t<cim:GovHydroPID.velop>" + velop + "</cim:GovHydroPID.velop>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroPID rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroPID>"
    }
}

object GovHydroPID
extends
    Parseable[GovHydroPID]
{
    val aturb = parse_element (element ("""GovHydroPID.aturb"""))
    val bturb = parse_element (element ("""GovHydroPID.bturb"""))
    val db1 = parse_element (element ("""GovHydroPID.db1"""))
    val db2 = parse_element (element ("""GovHydroPID.db2"""))
    val eps = parse_element (element ("""GovHydroPID.eps"""))
    val gv1 = parse_element (element ("""GovHydroPID.gv1"""))
    val gv2 = parse_element (element ("""GovHydroPID.gv2"""))
    val gv3 = parse_element (element ("""GovHydroPID.gv3"""))
    val gv4 = parse_element (element ("""GovHydroPID.gv4"""))
    val gv5 = parse_element (element ("""GovHydroPID.gv5"""))
    val gv6 = parse_element (element ("""GovHydroPID.gv6"""))
    val inputSignal = parse_element (element ("""GovHydroPID.inputSignal"""))
    val kd = parse_element (element ("""GovHydroPID.kd"""))
    val kg = parse_element (element ("""GovHydroPID.kg"""))
    val ki = parse_element (element ("""GovHydroPID.ki"""))
    val kp = parse_element (element ("""GovHydroPID.kp"""))
    val mwbase = parse_element (element ("""GovHydroPID.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydroPID.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydroPID.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydroPID.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydroPID.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydroPID.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydroPID.pgv6"""))
    val pmax = parse_element (element ("""GovHydroPID.pmax"""))
    val pmin = parse_element (element ("""GovHydroPID.pmin"""))
    val r = parse_element (element ("""GovHydroPID.r"""))
    val td = parse_element (element ("""GovHydroPID.td"""))
    val tf = parse_element (element ("""GovHydroPID.tf"""))
    val tp = parse_element (element ("""GovHydroPID.tp"""))
    val tt = parse_element (element ("""GovHydroPID.tt"""))
    val tturb = parse_element (element ("""GovHydroPID.tturb"""))
    val velcl = parse_element (element ("""GovHydroPID.velcl"""))
    val velop = parse_element (element ("""GovHydroPID.velop"""))
    def parse (context: Context): GovHydroPID =
    {
        GovHydroPID(
            TurbineGovernorDynamics.parse (context),
            toDouble (aturb (context), context),
            toDouble (bturb (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (eps (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toBoolean (inputSignal (context), context),
            toDouble (kd (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (r (context), context),
            toDouble (td (context), context),
            toDouble (tf (context), context),
            toDouble (tp (context), context),
            toDouble (tt (context), context),
            toDouble (tturb (context), context),
            toDouble (velcl (context), context),
            toDouble (velop (context), context)
        )
    }
}

/**
 * Hydro turbine and governor.
 *
 * Represents plants with straight forward penstock configurations and "three term" electro-hydraulic governors (i.e. Woodard electronic).
 *
 * @param sup Reference to the superclass object.
 * @param atw Factor multiplying Tw (Atw).
 *        Typical Value = 0.
 * @param d Turbine damping factor (D).
 *        Unit = delta P / delta speed.  Typical Value = 0.
 * @param feedbackSignal Feedback signal type flag (Flag).
 *        true = use gate position feedback signal
 *        false = use Pe.
 * @param g0 Gate opening at speed no load (G0).
 *        Typical Value = 0.
 * @param g1 Intermediate gate opening (G1).
 *        Typical Value = 0.
 * @param g2 Intermediate gate opening (G2).
 *        Typical Value = 0.
 * @param gmax Maximum gate opening (Gmax).
 *        Typical Value = 0.
 * @param gmin Minimum gate opening (Gmin).
 *        Typical Value = 0.
 * @param kd Derivative gain (Kd).
 *        Typical Value = 0.
 * @param ki Reset gain (Ki).
 *        Unit = PU/ sec.  Typical Value = 0.
 * @param kp Proportional gain (Kp).
 *        Typical Value = 0.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param p1 Power at gate opening G1 (P1).
 *        Typical Value = 0.
 * @param p2 Power at gate opening G2 (P2).
 *        Typical Value = 0.
 * @param p3 Power at full opened gate (P3).
 *        Typical Value = 0.
 * @param rperm Permanent drop (Rperm).
 *        Typical Value = 0.
 * @param ta Controller time constant (Ta) (&gt;0).
 *        Typical Value = 0.
 * @param tb Gate servo time constant (Tb) (&gt;0).
 *        Typical Value = 0.
 * @param treg Speed detector time constant (Treg).
 *        Typical Value = 0.
 * @param tw Water inertia time constant (Tw) (&gt;0).
 *        Typical Value = 0.
 * @param velmax Maximum gate opening velocity (Velmax).
 *        Unit = PU/sec.  Typical Value = 0.
 * @param velmin Maximum gate closing velocity (Velmin).
 *        Unit = PU/sec.  Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroPID2
(
    override val sup: TurbineGovernorDynamics,
    atw: Double,
    d: Double,
    feedbackSignal: Boolean,
    g0: Double,
    g1: Double,
    g2: Double,
    gmax: Double,
    gmin: Double,
    kd: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    p1: Double,
    p2: Double,
    p3: Double,
    rperm: Double,
    ta: Double,
    tb: Double,
    treg: Double,
    tw: Double,
    velmax: Double,
    velmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroPID2.atw>" + atw + "</cim:GovHydroPID2.atw>\n" +
        "\t\t<cim:GovHydroPID2.d>" + d + "</cim:GovHydroPID2.d>\n" +
        "\t\t<cim:GovHydroPID2.feedbackSignal>" + feedbackSignal + "</cim:GovHydroPID2.feedbackSignal>\n" +
        "\t\t<cim:GovHydroPID2.g0>" + g0 + "</cim:GovHydroPID2.g0>\n" +
        "\t\t<cim:GovHydroPID2.g1>" + g1 + "</cim:GovHydroPID2.g1>\n" +
        "\t\t<cim:GovHydroPID2.g2>" + g2 + "</cim:GovHydroPID2.g2>\n" +
        "\t\t<cim:GovHydroPID2.gmax>" + gmax + "</cim:GovHydroPID2.gmax>\n" +
        "\t\t<cim:GovHydroPID2.gmin>" + gmin + "</cim:GovHydroPID2.gmin>\n" +
        "\t\t<cim:GovHydroPID2.kd>" + kd + "</cim:GovHydroPID2.kd>\n" +
        "\t\t<cim:GovHydroPID2.ki>" + ki + "</cim:GovHydroPID2.ki>\n" +
        "\t\t<cim:GovHydroPID2.kp>" + kp + "</cim:GovHydroPID2.kp>\n" +
        "\t\t<cim:GovHydroPID2.mwbase>" + mwbase + "</cim:GovHydroPID2.mwbase>\n" +
        "\t\t<cim:GovHydroPID2.p1>" + p1 + "</cim:GovHydroPID2.p1>\n" +
        "\t\t<cim:GovHydroPID2.p2>" + p2 + "</cim:GovHydroPID2.p2>\n" +
        "\t\t<cim:GovHydroPID2.p3>" + p3 + "</cim:GovHydroPID2.p3>\n" +
        "\t\t<cim:GovHydroPID2.rperm>" + rperm + "</cim:GovHydroPID2.rperm>\n" +
        "\t\t<cim:GovHydroPID2.ta>" + ta + "</cim:GovHydroPID2.ta>\n" +
        "\t\t<cim:GovHydroPID2.tb>" + tb + "</cim:GovHydroPID2.tb>\n" +
        "\t\t<cim:GovHydroPID2.treg>" + treg + "</cim:GovHydroPID2.treg>\n" +
        "\t\t<cim:GovHydroPID2.tw>" + tw + "</cim:GovHydroPID2.tw>\n" +
        "\t\t<cim:GovHydroPID2.velmax>" + velmax + "</cim:GovHydroPID2.velmax>\n" +
        "\t\t<cim:GovHydroPID2.velmin>" + velmin + "</cim:GovHydroPID2.velmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroPID2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroPID2>"
    }
}

object GovHydroPID2
extends
    Parseable[GovHydroPID2]
{
    val atw = parse_element (element ("""GovHydroPID2.atw"""))
    val d = parse_element (element ("""GovHydroPID2.d"""))
    val feedbackSignal = parse_element (element ("""GovHydroPID2.feedbackSignal"""))
    val g0 = parse_element (element ("""GovHydroPID2.g0"""))
    val g1 = parse_element (element ("""GovHydroPID2.g1"""))
    val g2 = parse_element (element ("""GovHydroPID2.g2"""))
    val gmax = parse_element (element ("""GovHydroPID2.gmax"""))
    val gmin = parse_element (element ("""GovHydroPID2.gmin"""))
    val kd = parse_element (element ("""GovHydroPID2.kd"""))
    val ki = parse_element (element ("""GovHydroPID2.ki"""))
    val kp = parse_element (element ("""GovHydroPID2.kp"""))
    val mwbase = parse_element (element ("""GovHydroPID2.mwbase"""))
    val p1 = parse_element (element ("""GovHydroPID2.p1"""))
    val p2 = parse_element (element ("""GovHydroPID2.p2"""))
    val p3 = parse_element (element ("""GovHydroPID2.p3"""))
    val rperm = parse_element (element ("""GovHydroPID2.rperm"""))
    val ta = parse_element (element ("""GovHydroPID2.ta"""))
    val tb = parse_element (element ("""GovHydroPID2.tb"""))
    val treg = parse_element (element ("""GovHydroPID2.treg"""))
    val tw = parse_element (element ("""GovHydroPID2.tw"""))
    val velmax = parse_element (element ("""GovHydroPID2.velmax"""))
    val velmin = parse_element (element ("""GovHydroPID2.velmin"""))
    def parse (context: Context): GovHydroPID2 =
    {
        GovHydroPID2(
            TurbineGovernorDynamics.parse (context),
            toDouble (atw (context), context),
            toDouble (d (context), context),
            toBoolean (feedbackSignal (context), context),
            toDouble (g0 (context), context),
            toDouble (g1 (context), context),
            toDouble (g2 (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (kd (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toDouble (p1 (context), context),
            toDouble (p2 (context), context),
            toDouble (p3 (context), context),
            toDouble (rperm (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (treg (context), context),
            toDouble (tw (context), context),
            toDouble (velmax (context), context),
            toDouble (velmin (context), context)
        )
    }
}

/**
 * Detailed hydro unit - Pelton model.
 *
 * This model can be used to represent the dynamic related to water tunnel and surge chamber.
 *
 * @param sup Reference to the superclass object.
 * @param av0 Area of the surge tank (A<sub>V0</sub>).
 *        Unit = m<sup>2</sup>. Typical Value = 30.
 * @param av1 Area of the compensation tank (A<sub>V1</sub>).
 *        Unit = m<sup>2</sup>. Typical Value = 700.
 * @param bp Droop (bp).
 *        Typical Value = 0.05.
 * @param db1 Intentional dead-band width (DB1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Intentional dead-band width of valve opening error (DB2).
 *        Unit = Hz.  Typical Value = 0.01.
 * @param h1 Head of compensation chamber water level with respect to the level of penstock (H<sub>1</sub>).
 *        Unit = m. Typical Value = 4.
 * @param h2 Head of surge tank water level with respect to the level of penstock (H<sub>2</sub>).
 *        Unit = m. Typical Value = 40.
 * @param hn Rated hydraulic head (H<sub>n</sub>).
 *        Unit = m. Typical Value = 250.
 * @param kc Penstock loss coefficient (due to friction) (Kc).
 *        Typical Value = 0.025.
 * @param kg Water tunnel and surge chamber loss coefficient (due to friction) (Kg).
 *        Typical Value = -0.025.
 * @param qc0 No-load turbine flow at nominal head (Qc0).
 *        Typical Value = 0.05.
 * @param qn Rated flow (Q<sub>n</sub>).
 *        Unit = m<sup>3</sup>/s. Typical Value = 40.
 * @param simplifiedPelton Simplified Pelton model simulation (Sflag).
 *        true = enable of simplified Pelton model simulation
 *        false = enable of complete Pelton model simulation (non linear gain).
 *        Typical Value = false.
 * @param staticCompensating Static compensating characteristic (Cflag).
 *        true = enable of static compensating characteristic
 *        false = inhibit of static compensating characteristic.
 *        Typical Value = false.
 * @param ta Derivative gain (accelerometer time constant) (Ta).
 *        Typical Value = 3.
 * @param ts Gate servo time constant (Ts).
 *        Typical Value = 0.15.
 * @param tv Servomotor integrator time constant (TV).
 *        Typical Value = 0.3.
 * @param twnc Water inertia time constant (Twnc).
 *        Typical Value = 1.
 * @param twng Water tunnel and surge chamber inertia time constant (Twng).
 *        Typical Value = 3.
 * @param tx Electronic integrator time constant (Tx).
 *        Typical Value = 0.5.
 * @param va Maximum gate opening velocity (Va).
 *        Unit = PU/sec.  Typical Value = 0.016.
 * @param valvmax Maximum gate opening (ValvMax).
 *        Typical Value = 1.
 * @param valvmin Minimum gate opening (ValvMin).
 *        Typical Value = 0.
 * @param vav Maximum servomotor valve opening velocity (Vav).
 *        Typical Value = 0.017.
 * @param vc Maximum gate closing velocity (Vc).
 *        Unit = PU/sec.  Typical Value = -0.016.
 * @param vcv Maximum servomotor valve closing velocity (Vcv).
 *        Typical Value = -0.017.
 * @param waterTunnelSurgeChamberSimulation Water tunnel and surge chamber simulation (Tflag).
 *        true = enable of water tunnel and surge chamber simulation
 *        false = inhibit of water tunnel and surge chamber simulation.
 *        Typical Value = false.
 * @param zsfc Head of upper water level with respect to the level of penstock (Zsfc).
 *        Unit = m. Typical Value = 25.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroPelton
(
    override val sup: TurbineGovernorDynamics,
    av0: Double,
    av1: Double,
    bp: Double,
    db1: Double,
    db2: Double,
    h1: Double,
    h2: Double,
    hn: Double,
    kc: Double,
    kg: Double,
    qc0: Double,
    qn: Double,
    simplifiedPelton: Boolean,
    staticCompensating: Boolean,
    ta: Double,
    ts: Double,
    tv: Double,
    twnc: Double,
    twng: Double,
    tx: Double,
    va: Double,
    valvmax: Double,
    valvmin: Double,
    vav: Double,
    vc: Double,
    vcv: Double,
    waterTunnelSurgeChamberSimulation: Boolean,
    zsfc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroPelton.av0>" + av0 + "</cim:GovHydroPelton.av0>\n" +
        "\t\t<cim:GovHydroPelton.av1>" + av1 + "</cim:GovHydroPelton.av1>\n" +
        "\t\t<cim:GovHydroPelton.bp>" + bp + "</cim:GovHydroPelton.bp>\n" +
        "\t\t<cim:GovHydroPelton.db1>" + db1 + "</cim:GovHydroPelton.db1>\n" +
        "\t\t<cim:GovHydroPelton.db2>" + db2 + "</cim:GovHydroPelton.db2>\n" +
        "\t\t<cim:GovHydroPelton.h1>" + h1 + "</cim:GovHydroPelton.h1>\n" +
        "\t\t<cim:GovHydroPelton.h2>" + h2 + "</cim:GovHydroPelton.h2>\n" +
        "\t\t<cim:GovHydroPelton.hn>" + hn + "</cim:GovHydroPelton.hn>\n" +
        "\t\t<cim:GovHydroPelton.kc>" + kc + "</cim:GovHydroPelton.kc>\n" +
        "\t\t<cim:GovHydroPelton.kg>" + kg + "</cim:GovHydroPelton.kg>\n" +
        "\t\t<cim:GovHydroPelton.qc0>" + qc0 + "</cim:GovHydroPelton.qc0>\n" +
        "\t\t<cim:GovHydroPelton.qn>" + qn + "</cim:GovHydroPelton.qn>\n" +
        "\t\t<cim:GovHydroPelton.simplifiedPelton>" + simplifiedPelton + "</cim:GovHydroPelton.simplifiedPelton>\n" +
        "\t\t<cim:GovHydroPelton.staticCompensating>" + staticCompensating + "</cim:GovHydroPelton.staticCompensating>\n" +
        "\t\t<cim:GovHydroPelton.ta>" + ta + "</cim:GovHydroPelton.ta>\n" +
        "\t\t<cim:GovHydroPelton.ts>" + ts + "</cim:GovHydroPelton.ts>\n" +
        "\t\t<cim:GovHydroPelton.tv>" + tv + "</cim:GovHydroPelton.tv>\n" +
        "\t\t<cim:GovHydroPelton.twnc>" + twnc + "</cim:GovHydroPelton.twnc>\n" +
        "\t\t<cim:GovHydroPelton.twng>" + twng + "</cim:GovHydroPelton.twng>\n" +
        "\t\t<cim:GovHydroPelton.tx>" + tx + "</cim:GovHydroPelton.tx>\n" +
        "\t\t<cim:GovHydroPelton.va>" + va + "</cim:GovHydroPelton.va>\n" +
        "\t\t<cim:GovHydroPelton.valvmax>" + valvmax + "</cim:GovHydroPelton.valvmax>\n" +
        "\t\t<cim:GovHydroPelton.valvmin>" + valvmin + "</cim:GovHydroPelton.valvmin>\n" +
        "\t\t<cim:GovHydroPelton.vav>" + vav + "</cim:GovHydroPelton.vav>\n" +
        "\t\t<cim:GovHydroPelton.vc>" + vc + "</cim:GovHydroPelton.vc>\n" +
        "\t\t<cim:GovHydroPelton.vcv>" + vcv + "</cim:GovHydroPelton.vcv>\n" +
        "\t\t<cim:GovHydroPelton.waterTunnelSurgeChamberSimulation>" + waterTunnelSurgeChamberSimulation + "</cim:GovHydroPelton.waterTunnelSurgeChamberSimulation>\n" +
        "\t\t<cim:GovHydroPelton.zsfc>" + zsfc + "</cim:GovHydroPelton.zsfc>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroPelton rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroPelton>"
    }
}

object GovHydroPelton
extends
    Parseable[GovHydroPelton]
{
    val av0 = parse_element (element ("""GovHydroPelton.av0"""))
    val av1 = parse_element (element ("""GovHydroPelton.av1"""))
    val bp = parse_element (element ("""GovHydroPelton.bp"""))
    val db1 = parse_element (element ("""GovHydroPelton.db1"""))
    val db2 = parse_element (element ("""GovHydroPelton.db2"""))
    val h1 = parse_element (element ("""GovHydroPelton.h1"""))
    val h2 = parse_element (element ("""GovHydroPelton.h2"""))
    val hn = parse_element (element ("""GovHydroPelton.hn"""))
    val kc = parse_element (element ("""GovHydroPelton.kc"""))
    val kg = parse_element (element ("""GovHydroPelton.kg"""))
    val qc0 = parse_element (element ("""GovHydroPelton.qc0"""))
    val qn = parse_element (element ("""GovHydroPelton.qn"""))
    val simplifiedPelton = parse_element (element ("""GovHydroPelton.simplifiedPelton"""))
    val staticCompensating = parse_element (element ("""GovHydroPelton.staticCompensating"""))
    val ta = parse_element (element ("""GovHydroPelton.ta"""))
    val ts = parse_element (element ("""GovHydroPelton.ts"""))
    val tv = parse_element (element ("""GovHydroPelton.tv"""))
    val twnc = parse_element (element ("""GovHydroPelton.twnc"""))
    val twng = parse_element (element ("""GovHydroPelton.twng"""))
    val tx = parse_element (element ("""GovHydroPelton.tx"""))
    val va = parse_element (element ("""GovHydroPelton.va"""))
    val valvmax = parse_element (element ("""GovHydroPelton.valvmax"""))
    val valvmin = parse_element (element ("""GovHydroPelton.valvmin"""))
    val vav = parse_element (element ("""GovHydroPelton.vav"""))
    val vc = parse_element (element ("""GovHydroPelton.vc"""))
    val vcv = parse_element (element ("""GovHydroPelton.vcv"""))
    val waterTunnelSurgeChamberSimulation = parse_element (element ("""GovHydroPelton.waterTunnelSurgeChamberSimulation"""))
    val zsfc = parse_element (element ("""GovHydroPelton.zsfc"""))
    def parse (context: Context): GovHydroPelton =
    {
        GovHydroPelton(
            TurbineGovernorDynamics.parse (context),
            toDouble (av0 (context), context),
            toDouble (av1 (context), context),
            toDouble (bp (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (h1 (context), context),
            toDouble (h2 (context), context),
            toDouble (hn (context), context),
            toDouble (kc (context), context),
            toDouble (kg (context), context),
            toDouble (qc0 (context), context),
            toDouble (qn (context), context),
            toBoolean (simplifiedPelton (context), context),
            toBoolean (staticCompensating (context), context),
            toDouble (ta (context), context),
            toDouble (ts (context), context),
            toDouble (tv (context), context),
            toDouble (twnc (context), context),
            toDouble (twng (context), context),
            toDouble (tx (context), context),
            toDouble (va (context), context),
            toDouble (valvmax (context), context),
            toDouble (valvmin (context), context),
            toDouble (vav (context), context),
            toDouble (vc (context), context),
            toDouble (vcv (context), context),
            toBoolean (waterTunnelSurgeChamberSimulation (context), context),
            toDouble (zsfc (context), context)
        )
    }
}

/**
 * Fourth order lead-lag governor and hydro turbine.
 *
 * @param sup Reference to the superclass object.
 * @param at Turbine gain (At).
 *        Typical Value = 1.2.
 * @param db1 Intentional dead-band width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional dead-band (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param dturb Turbine damping factor (Dturb).
 *        Typical Value = 0.2.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gmax Maximum governor output (Gmax).
 *        Typical Value = 1.05.
 * @param gmin Minimum governor output (Gmin).
 *        Typical Value = -0.05.
 * @param gv1 Nonlinear gain point 1, PU gv (Gv1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain point 2, PU gv (Gv2).
 *        Typical Value = 0.
 * @param gv3 Nonlinear gain point 3, PU gv (Gv3).
 *        Typical Value = 0.
 * @param gv4 Nonlinear gain point 4, PU gv (Gv4).
 *        Typical Value = 0.
 * @param gv5 Nonlinear gain point 5, PU gv (Gv5).
 *        Typical Value = 0.
 * @param gv6 Nonlinear gain point 6, PU gv (Gv6).
 *        Typical Value = 0.
 * @param h0 Turbine nominal head (H0).
 *        Typical Value = 1.
 * @param inputSignal Input signal switch (Flag).
 *        true = Pe input is used
 *        false = feedback is received from CV.
 *        Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.  Typical Value = true.
 * @param kg Gate servo gain (Kg).
 *        Typical Value = 2.
 * @param ki Integral gain (Ki).
 *        Typical Value = 0.5.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain point 1, PU power (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain point 2, PU power (Pgv2).
 *        Typical Value = 0.
 * @param pgv3 Nonlinear gain point 3, PU power (Pgv3).
 *        Typical Value = 0.
 * @param pgv4 Nonlinear gain point 4, PU power (Pgv4).
 *        Typical Value = 0.
 * @param pgv5 Nonlinear gain point 5, PU power (Pgv5).
 *        Typical Value = 0.
 * @param pgv6 Nonlinear gain point 6, PU power (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum gate opening, PU of MWbase (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum gate opening, PU of MWbase (Pmin).
 *        Typical Value = 0.
 * @param qnl No-load turbine flow at nominal head (Qnl).
 *        Typical Value = 0.08.
 * @param r Steady-state droop (R).
 *        Typical Value = 0.05.
 * @param t1 Lead time constant 1 (T1).
 *        Typical Value = 1.5.
 * @param t2 Lag time constant 1 (T2).
 *        Typical Value = 0.1.
 * @param t3 Lead time constant 2 (T3).
 *        Typical Value = 1.5.
 * @param t4 Lag time constant 2 (T4).
 *        Typical Value = 0.1.
 * @param t5 Lead time constant 3 (T5).
 *        Typical Value = 0.
 * @param t6 Lag time constant 3 (T6).
 *        Typical Value = 0.05.
 * @param t7 Lead time constant 4 (T7).
 *        Typical Value = 0.
 * @param t8 Lag time constant 4 (T8).
 *        Typical Value = 0.05.
 * @param td Input filter time constant (Td).
 *        Typical Value = 0.05.
 * @param tp Gate servo time constant (Tp).
 *        Typical Value = 0.05.
 * @param tt Power feedback time constant (Tt).
 *        Typical Value = 0.
 * @param tw Water inertia time constant (Tw).
 *        Typical Value = 1.
 * @param velcl Maximum gate closing velocity (Velcl).
 *        Unit = PU/sec.  Typical Value = -0.2.
 * @param velop Maximum gate opening velocity (Velop).
 *        Unit = PU/sec.  Typical Value = 0.2.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroR
(
    override val sup: TurbineGovernorDynamics,
    at: Double,
    db1: Double,
    db2: Double,
    dturb: Double,
    eps: Double,
    gmax: Double,
    gmin: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    h0: Double,
    inputSignal: Boolean,
    kg: Double,
    ki: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    qnl: Double,
    r: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    t8: Double,
    td: Double,
    tp: Double,
    tt: Double,
    tw: Double,
    velcl: Double,
    velop: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroR.at>" + at + "</cim:GovHydroR.at>\n" +
        "\t\t<cim:GovHydroR.db1>" + db1 + "</cim:GovHydroR.db1>\n" +
        "\t\t<cim:GovHydroR.db2>" + db2 + "</cim:GovHydroR.db2>\n" +
        "\t\t<cim:GovHydroR.dturb>" + dturb + "</cim:GovHydroR.dturb>\n" +
        "\t\t<cim:GovHydroR.eps>" + eps + "</cim:GovHydroR.eps>\n" +
        "\t\t<cim:GovHydroR.gmax>" + gmax + "</cim:GovHydroR.gmax>\n" +
        "\t\t<cim:GovHydroR.gmin>" + gmin + "</cim:GovHydroR.gmin>\n" +
        "\t\t<cim:GovHydroR.gv1>" + gv1 + "</cim:GovHydroR.gv1>\n" +
        "\t\t<cim:GovHydroR.gv2>" + gv2 + "</cim:GovHydroR.gv2>\n" +
        "\t\t<cim:GovHydroR.gv3>" + gv3 + "</cim:GovHydroR.gv3>\n" +
        "\t\t<cim:GovHydroR.gv4>" + gv4 + "</cim:GovHydroR.gv4>\n" +
        "\t\t<cim:GovHydroR.gv5>" + gv5 + "</cim:GovHydroR.gv5>\n" +
        "\t\t<cim:GovHydroR.gv6>" + gv6 + "</cim:GovHydroR.gv6>\n" +
        "\t\t<cim:GovHydroR.h0>" + h0 + "</cim:GovHydroR.h0>\n" +
        "\t\t<cim:GovHydroR.inputSignal>" + inputSignal + "</cim:GovHydroR.inputSignal>\n" +
        "\t\t<cim:GovHydroR.kg>" + kg + "</cim:GovHydroR.kg>\n" +
        "\t\t<cim:GovHydroR.ki>" + ki + "</cim:GovHydroR.ki>\n" +
        "\t\t<cim:GovHydroR.mwbase>" + mwbase + "</cim:GovHydroR.mwbase>\n" +
        "\t\t<cim:GovHydroR.pgv1>" + pgv1 + "</cim:GovHydroR.pgv1>\n" +
        "\t\t<cim:GovHydroR.pgv2>" + pgv2 + "</cim:GovHydroR.pgv2>\n" +
        "\t\t<cim:GovHydroR.pgv3>" + pgv3 + "</cim:GovHydroR.pgv3>\n" +
        "\t\t<cim:GovHydroR.pgv4>" + pgv4 + "</cim:GovHydroR.pgv4>\n" +
        "\t\t<cim:GovHydroR.pgv5>" + pgv5 + "</cim:GovHydroR.pgv5>\n" +
        "\t\t<cim:GovHydroR.pgv6>" + pgv6 + "</cim:GovHydroR.pgv6>\n" +
        "\t\t<cim:GovHydroR.pmax>" + pmax + "</cim:GovHydroR.pmax>\n" +
        "\t\t<cim:GovHydroR.pmin>" + pmin + "</cim:GovHydroR.pmin>\n" +
        "\t\t<cim:GovHydroR.qnl>" + qnl + "</cim:GovHydroR.qnl>\n" +
        "\t\t<cim:GovHydroR.r>" + r + "</cim:GovHydroR.r>\n" +
        "\t\t<cim:GovHydroR.t1>" + t1 + "</cim:GovHydroR.t1>\n" +
        "\t\t<cim:GovHydroR.t2>" + t2 + "</cim:GovHydroR.t2>\n" +
        "\t\t<cim:GovHydroR.t3>" + t3 + "</cim:GovHydroR.t3>\n" +
        "\t\t<cim:GovHydroR.t4>" + t4 + "</cim:GovHydroR.t4>\n" +
        "\t\t<cim:GovHydroR.t5>" + t5 + "</cim:GovHydroR.t5>\n" +
        "\t\t<cim:GovHydroR.t6>" + t6 + "</cim:GovHydroR.t6>\n" +
        "\t\t<cim:GovHydroR.t7>" + t7 + "</cim:GovHydroR.t7>\n" +
        "\t\t<cim:GovHydroR.t8>" + t8 + "</cim:GovHydroR.t8>\n" +
        "\t\t<cim:GovHydroR.td>" + td + "</cim:GovHydroR.td>\n" +
        "\t\t<cim:GovHydroR.tp>" + tp + "</cim:GovHydroR.tp>\n" +
        "\t\t<cim:GovHydroR.tt>" + tt + "</cim:GovHydroR.tt>\n" +
        "\t\t<cim:GovHydroR.tw>" + tw + "</cim:GovHydroR.tw>\n" +
        "\t\t<cim:GovHydroR.velcl>" + velcl + "</cim:GovHydroR.velcl>\n" +
        "\t\t<cim:GovHydroR.velop>" + velop + "</cim:GovHydroR.velop>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroR rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroR>"
    }
}

object GovHydroR
extends
    Parseable[GovHydroR]
{
    val at = parse_element (element ("""GovHydroR.at"""))
    val db1 = parse_element (element ("""GovHydroR.db1"""))
    val db2 = parse_element (element ("""GovHydroR.db2"""))
    val dturb = parse_element (element ("""GovHydroR.dturb"""))
    val eps = parse_element (element ("""GovHydroR.eps"""))
    val gmax = parse_element (element ("""GovHydroR.gmax"""))
    val gmin = parse_element (element ("""GovHydroR.gmin"""))
    val gv1 = parse_element (element ("""GovHydroR.gv1"""))
    val gv2 = parse_element (element ("""GovHydroR.gv2"""))
    val gv3 = parse_element (element ("""GovHydroR.gv3"""))
    val gv4 = parse_element (element ("""GovHydroR.gv4"""))
    val gv5 = parse_element (element ("""GovHydroR.gv5"""))
    val gv6 = parse_element (element ("""GovHydroR.gv6"""))
    val h0 = parse_element (element ("""GovHydroR.h0"""))
    val inputSignal = parse_element (element ("""GovHydroR.inputSignal"""))
    val kg = parse_element (element ("""GovHydroR.kg"""))
    val ki = parse_element (element ("""GovHydroR.ki"""))
    val mwbase = parse_element (element ("""GovHydroR.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydroR.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydroR.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydroR.pgv3"""))
    val pgv4 = parse_element (element ("""GovHydroR.pgv4"""))
    val pgv5 = parse_element (element ("""GovHydroR.pgv5"""))
    val pgv6 = parse_element (element ("""GovHydroR.pgv6"""))
    val pmax = parse_element (element ("""GovHydroR.pmax"""))
    val pmin = parse_element (element ("""GovHydroR.pmin"""))
    val qnl = parse_element (element ("""GovHydroR.qnl"""))
    val r = parse_element (element ("""GovHydroR.r"""))
    val t1 = parse_element (element ("""GovHydroR.t1"""))
    val t2 = parse_element (element ("""GovHydroR.t2"""))
    val t3 = parse_element (element ("""GovHydroR.t3"""))
    val t4 = parse_element (element ("""GovHydroR.t4"""))
    val t5 = parse_element (element ("""GovHydroR.t5"""))
    val t6 = parse_element (element ("""GovHydroR.t6"""))
    val t7 = parse_element (element ("""GovHydroR.t7"""))
    val t8 = parse_element (element ("""GovHydroR.t8"""))
    val td = parse_element (element ("""GovHydroR.td"""))
    val tp = parse_element (element ("""GovHydroR.tp"""))
    val tt = parse_element (element ("""GovHydroR.tt"""))
    val tw = parse_element (element ("""GovHydroR.tw"""))
    val velcl = parse_element (element ("""GovHydroR.velcl"""))
    val velop = parse_element (element ("""GovHydroR.velop"""))
    def parse (context: Context): GovHydroR =
    {
        GovHydroR(
            TurbineGovernorDynamics.parse (context),
            toDouble (at (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (dturb (context), context),
            toDouble (eps (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (h0 (context), context),
            toBoolean (inputSignal (context), context),
            toDouble (kg (context), context),
            toDouble (ki (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (qnl (context), context),
            toDouble (r (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (t8 (context), context),
            toDouble (td (context), context),
            toDouble (tp (context), context),
            toDouble (tt (context), context),
            toDouble (tw (context), context),
            toDouble (velcl (context), context),
            toDouble (velop (context), context)
        )
    }
}

/**
 * Woodward Electric Hydro Governor Model.
 *
 * @param sup Reference to the superclass object.
 * @param db Speed Dead Band (db).
 * @param dicn Value to allow the integral controller to advance beyond the gate limits (Dicn).
 * @param dpv Value to allow the Pilot valve controller to advance beyond the gate limits (Dpv).
 * @param dturb Turbine damping factor (Dturb).
 *        Unit = delta P (PU of MWbase) / delta speed (PU).
 * @param feedbackSignal Feedback signal selection (Sw).
 *        true = PID Output (if R-Perm-Gate=droop and R-Perm-Pe=0)
 *        false = Electrical Power (if R-Perm-Gate=0 and R-Perm-Pe=droop) or
 *        false = Gate Position (if R-Perm-Gate=droop and R-Perm-Pe=0).
 * @param fl1 Flow Gate 1 (Fl1).
 *        Flow value for gate position point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl2 Flow Gate 2 (Fl2).
 *        Flow value for gate position point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl3 Flow Gate 3 (Fl3).
 *        Flow value for gate position point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl4 Flow Gate 4 (Fl4).
 *        Flow value for gate position point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fl5 Flow Gate 5 (Fl5).
 *        Flow value for gate position point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param fp1 Flow P1 (Fp1).
 *        Turbine Flow value for point 1 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp10 Flow P10 (Fp10).
 *        Turbine Flow value for point 10 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp2 Flow P2 (Fp2).
 *        Turbine Flow value for point 2 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp3 Flow P3 (Fp3).
 *        Turbine Flow value for point 3 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp4 Flow P4 (Fp4).
 *        Turbine Flow value for point 4 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp5 Flow P5 (Fp5).
 *        Turbine Flow value for point 5 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp6 Flow P6 (Fp6).
 *        Turbine Flow value for point 6 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp7 Flow P7 (Fp7).
 *        Turbine Flow value for point 7 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp8 Flow P8 (Fp8).
 *        Turbine Flow value for point 8 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param fp9 Flow P9 (Fp9).
 *        Turbine Flow value for point 9 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param gmax Maximum Gate Position (Gmax).
 * @param gmin Minimum Gate Position (Gmin).
 * @param gtmxcl Maximum gate closing rate (Gtmxcl).
 * @param gtmxop Maximum gate opening rate (Gtmxop).
 * @param gv1 Gate 1 (Gv1).
 *        Gate Position value for point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv2 Gate 2 (Gv2).
 *        Gate Position value for point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv3 Gate 3 (Gv3).
 *        Gate Position value for point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv4 Gate 4 (Gv4).
 *        Gate Position value for point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param gv5 Gate 5 (Gv5).
 *        Gate Position value for point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
 * @param kd Derivative controller derivative gain (Kd).
 * @param ki Derivative controller Integral gain (Ki).
 * @param kp Derivative control gain (Kp).
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pmss1 Pmss Flow P1 (Pmss1).
 *        Mechanical Power output Pmss for Turbine Flow point 1 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss10 Pmss Flow P10 (Pmss10).
 *        Mechanical Power output Pmss for Turbine Flow point 10 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss2 Pmss Flow P2 (Pmss2).
 *        Mechanical Power output Pmss for Turbine Flow point 2 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss3 Pmss Flow P3 (Pmss3).
 *        Mechanical Power output Pmss for Turbine Flow point 3 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss4 Pmss Flow P4 (Pmss4).
 *        Mechanical Power output Pmss for Turbine Flow point 4 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss5 Pmss Flow P5 (Pmss5).
 *        Mechanical Power output Pmss for Turbine Flow point 5 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss6 Pmss Flow P6 (Pmss6).
 *        Mechanical Power output Pmss for Turbine Flow point 6 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss7 Pmss Flow P7 (Pmss7).
 *        Mechanical Power output Pmss for Turbine Flow point 7 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss8 Pmss Flow P8 (Pmss8).
 *        Mechanical Power output Pmss for Turbine Flow point 8 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param pmss9 Pmss Flow P9 (Pmss9).
 *        Mechanical Power output Pmss for Turbine Flow point 9 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
 * @param rpg Permanent droop for governor output feedback (R-Perm-Gate).
 * @param rpp Permanent droop for electrical power feedback (R-Perm-Pe).
 * @param td Derivative controller time constant to limit the derivative characteristic beyond a breakdown frequency to avoid amplification of high-frequency noise (Td).
 * @param tdv Distributive Valve time lag time constant (Tdv).
 * @param tg Value to allow the Distribution valve controller to advance beyond the gate movement rate limit (Tg).
 * @param tp Pilot Valve time lag time constant (Tp).
 * @param tpe Electrical power droop time constant (Tpe).
 * @param tw Water inertia time constant (Tw) (&gt;0).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroWEH
(
    override val sup: TurbineGovernorDynamics,
    db: Double,
    dicn: Double,
    dpv: Double,
    dturb: Double,
    feedbackSignal: Boolean,
    fl1: Double,
    fl2: Double,
    fl3: Double,
    fl4: Double,
    fl5: Double,
    fp1: Double,
    fp10: Double,
    fp2: Double,
    fp3: Double,
    fp4: Double,
    fp5: Double,
    fp6: Double,
    fp7: Double,
    fp8: Double,
    fp9: Double,
    gmax: Double,
    gmin: Double,
    gtmxcl: Double,
    gtmxop: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    kd: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    pmss1: Double,
    pmss10: Double,
    pmss2: Double,
    pmss3: Double,
    pmss4: Double,
    pmss5: Double,
    pmss6: Double,
    pmss7: Double,
    pmss8: Double,
    pmss9: Double,
    rpg: Double,
    rpp: Double,
    td: Double,
    tdv: Double,
    tg: Double,
    tp: Double,
    tpe: Double,
    tw: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroWEH.db>" + db + "</cim:GovHydroWEH.db>\n" +
        "\t\t<cim:GovHydroWEH.dicn>" + dicn + "</cim:GovHydroWEH.dicn>\n" +
        "\t\t<cim:GovHydroWEH.dpv>" + dpv + "</cim:GovHydroWEH.dpv>\n" +
        "\t\t<cim:GovHydroWEH.dturb>" + dturb + "</cim:GovHydroWEH.dturb>\n" +
        "\t\t<cim:GovHydroWEH.feedbackSignal>" + feedbackSignal + "</cim:GovHydroWEH.feedbackSignal>\n" +
        "\t\t<cim:GovHydroWEH.fl1>" + fl1 + "</cim:GovHydroWEH.fl1>\n" +
        "\t\t<cim:GovHydroWEH.fl2>" + fl2 + "</cim:GovHydroWEH.fl2>\n" +
        "\t\t<cim:GovHydroWEH.fl3>" + fl3 + "</cim:GovHydroWEH.fl3>\n" +
        "\t\t<cim:GovHydroWEH.fl4>" + fl4 + "</cim:GovHydroWEH.fl4>\n" +
        "\t\t<cim:GovHydroWEH.fl5>" + fl5 + "</cim:GovHydroWEH.fl5>\n" +
        "\t\t<cim:GovHydroWEH.fp1>" + fp1 + "</cim:GovHydroWEH.fp1>\n" +
        "\t\t<cim:GovHydroWEH.fp10>" + fp10 + "</cim:GovHydroWEH.fp10>\n" +
        "\t\t<cim:GovHydroWEH.fp2>" + fp2 + "</cim:GovHydroWEH.fp2>\n" +
        "\t\t<cim:GovHydroWEH.fp3>" + fp3 + "</cim:GovHydroWEH.fp3>\n" +
        "\t\t<cim:GovHydroWEH.fp4>" + fp4 + "</cim:GovHydroWEH.fp4>\n" +
        "\t\t<cim:GovHydroWEH.fp5>" + fp5 + "</cim:GovHydroWEH.fp5>\n" +
        "\t\t<cim:GovHydroWEH.fp6>" + fp6 + "</cim:GovHydroWEH.fp6>\n" +
        "\t\t<cim:GovHydroWEH.fp7>" + fp7 + "</cim:GovHydroWEH.fp7>\n" +
        "\t\t<cim:GovHydroWEH.fp8>" + fp8 + "</cim:GovHydroWEH.fp8>\n" +
        "\t\t<cim:GovHydroWEH.fp9>" + fp9 + "</cim:GovHydroWEH.fp9>\n" +
        "\t\t<cim:GovHydroWEH.gmax>" + gmax + "</cim:GovHydroWEH.gmax>\n" +
        "\t\t<cim:GovHydroWEH.gmin>" + gmin + "</cim:GovHydroWEH.gmin>\n" +
        "\t\t<cim:GovHydroWEH.gtmxcl>" + gtmxcl + "</cim:GovHydroWEH.gtmxcl>\n" +
        "\t\t<cim:GovHydroWEH.gtmxop>" + gtmxop + "</cim:GovHydroWEH.gtmxop>\n" +
        "\t\t<cim:GovHydroWEH.gv1>" + gv1 + "</cim:GovHydroWEH.gv1>\n" +
        "\t\t<cim:GovHydroWEH.gv2>" + gv2 + "</cim:GovHydroWEH.gv2>\n" +
        "\t\t<cim:GovHydroWEH.gv3>" + gv3 + "</cim:GovHydroWEH.gv3>\n" +
        "\t\t<cim:GovHydroWEH.gv4>" + gv4 + "</cim:GovHydroWEH.gv4>\n" +
        "\t\t<cim:GovHydroWEH.gv5>" + gv5 + "</cim:GovHydroWEH.gv5>\n" +
        "\t\t<cim:GovHydroWEH.kd>" + kd + "</cim:GovHydroWEH.kd>\n" +
        "\t\t<cim:GovHydroWEH.ki>" + ki + "</cim:GovHydroWEH.ki>\n" +
        "\t\t<cim:GovHydroWEH.kp>" + kp + "</cim:GovHydroWEH.kp>\n" +
        "\t\t<cim:GovHydroWEH.mwbase>" + mwbase + "</cim:GovHydroWEH.mwbase>\n" +
        "\t\t<cim:GovHydroWEH.pmss1>" + pmss1 + "</cim:GovHydroWEH.pmss1>\n" +
        "\t\t<cim:GovHydroWEH.pmss10>" + pmss10 + "</cim:GovHydroWEH.pmss10>\n" +
        "\t\t<cim:GovHydroWEH.pmss2>" + pmss2 + "</cim:GovHydroWEH.pmss2>\n" +
        "\t\t<cim:GovHydroWEH.pmss3>" + pmss3 + "</cim:GovHydroWEH.pmss3>\n" +
        "\t\t<cim:GovHydroWEH.pmss4>" + pmss4 + "</cim:GovHydroWEH.pmss4>\n" +
        "\t\t<cim:GovHydroWEH.pmss5>" + pmss5 + "</cim:GovHydroWEH.pmss5>\n" +
        "\t\t<cim:GovHydroWEH.pmss6>" + pmss6 + "</cim:GovHydroWEH.pmss6>\n" +
        "\t\t<cim:GovHydroWEH.pmss7>" + pmss7 + "</cim:GovHydroWEH.pmss7>\n" +
        "\t\t<cim:GovHydroWEH.pmss8>" + pmss8 + "</cim:GovHydroWEH.pmss8>\n" +
        "\t\t<cim:GovHydroWEH.pmss9>" + pmss9 + "</cim:GovHydroWEH.pmss9>\n" +
        "\t\t<cim:GovHydroWEH.rpg>" + rpg + "</cim:GovHydroWEH.rpg>\n" +
        "\t\t<cim:GovHydroWEH.rpp>" + rpp + "</cim:GovHydroWEH.rpp>\n" +
        "\t\t<cim:GovHydroWEH.td>" + td + "</cim:GovHydroWEH.td>\n" +
        "\t\t<cim:GovHydroWEH.tdv>" + tdv + "</cim:GovHydroWEH.tdv>\n" +
        "\t\t<cim:GovHydroWEH.tg>" + tg + "</cim:GovHydroWEH.tg>\n" +
        "\t\t<cim:GovHydroWEH.tp>" + tp + "</cim:GovHydroWEH.tp>\n" +
        "\t\t<cim:GovHydroWEH.tpe>" + tpe + "</cim:GovHydroWEH.tpe>\n" +
        "\t\t<cim:GovHydroWEH.tw>" + tw + "</cim:GovHydroWEH.tw>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroWEH rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroWEH>"
    }
}

object GovHydroWEH
extends
    Parseable[GovHydroWEH]
{
    val db = parse_element (element ("""GovHydroWEH.db"""))
    val dicn = parse_element (element ("""GovHydroWEH.dicn"""))
    val dpv = parse_element (element ("""GovHydroWEH.dpv"""))
    val dturb = parse_element (element ("""GovHydroWEH.dturb"""))
    val feedbackSignal = parse_element (element ("""GovHydroWEH.feedbackSignal"""))
    val fl1 = parse_element (element ("""GovHydroWEH.fl1"""))
    val fl2 = parse_element (element ("""GovHydroWEH.fl2"""))
    val fl3 = parse_element (element ("""GovHydroWEH.fl3"""))
    val fl4 = parse_element (element ("""GovHydroWEH.fl4"""))
    val fl5 = parse_element (element ("""GovHydroWEH.fl5"""))
    val fp1 = parse_element (element ("""GovHydroWEH.fp1"""))
    val fp10 = parse_element (element ("""GovHydroWEH.fp10"""))
    val fp2 = parse_element (element ("""GovHydroWEH.fp2"""))
    val fp3 = parse_element (element ("""GovHydroWEH.fp3"""))
    val fp4 = parse_element (element ("""GovHydroWEH.fp4"""))
    val fp5 = parse_element (element ("""GovHydroWEH.fp5"""))
    val fp6 = parse_element (element ("""GovHydroWEH.fp6"""))
    val fp7 = parse_element (element ("""GovHydroWEH.fp7"""))
    val fp8 = parse_element (element ("""GovHydroWEH.fp8"""))
    val fp9 = parse_element (element ("""GovHydroWEH.fp9"""))
    val gmax = parse_element (element ("""GovHydroWEH.gmax"""))
    val gmin = parse_element (element ("""GovHydroWEH.gmin"""))
    val gtmxcl = parse_element (element ("""GovHydroWEH.gtmxcl"""))
    val gtmxop = parse_element (element ("""GovHydroWEH.gtmxop"""))
    val gv1 = parse_element (element ("""GovHydroWEH.gv1"""))
    val gv2 = parse_element (element ("""GovHydroWEH.gv2"""))
    val gv3 = parse_element (element ("""GovHydroWEH.gv3"""))
    val gv4 = parse_element (element ("""GovHydroWEH.gv4"""))
    val gv5 = parse_element (element ("""GovHydroWEH.gv5"""))
    val kd = parse_element (element ("""GovHydroWEH.kd"""))
    val ki = parse_element (element ("""GovHydroWEH.ki"""))
    val kp = parse_element (element ("""GovHydroWEH.kp"""))
    val mwbase = parse_element (element ("""GovHydroWEH.mwbase"""))
    val pmss1 = parse_element (element ("""GovHydroWEH.pmss1"""))
    val pmss10 = parse_element (element ("""GovHydroWEH.pmss10"""))
    val pmss2 = parse_element (element ("""GovHydroWEH.pmss2"""))
    val pmss3 = parse_element (element ("""GovHydroWEH.pmss3"""))
    val pmss4 = parse_element (element ("""GovHydroWEH.pmss4"""))
    val pmss5 = parse_element (element ("""GovHydroWEH.pmss5"""))
    val pmss6 = parse_element (element ("""GovHydroWEH.pmss6"""))
    val pmss7 = parse_element (element ("""GovHydroWEH.pmss7"""))
    val pmss8 = parse_element (element ("""GovHydroWEH.pmss8"""))
    val pmss9 = parse_element (element ("""GovHydroWEH.pmss9"""))
    val rpg = parse_element (element ("""GovHydroWEH.rpg"""))
    val rpp = parse_element (element ("""GovHydroWEH.rpp"""))
    val td = parse_element (element ("""GovHydroWEH.td"""))
    val tdv = parse_element (element ("""GovHydroWEH.tdv"""))
    val tg = parse_element (element ("""GovHydroWEH.tg"""))
    val tp = parse_element (element ("""GovHydroWEH.tp"""))
    val tpe = parse_element (element ("""GovHydroWEH.tpe"""))
    val tw = parse_element (element ("""GovHydroWEH.tw"""))
    def parse (context: Context): GovHydroWEH =
    {
        GovHydroWEH(
            TurbineGovernorDynamics.parse (context),
            toDouble (db (context), context),
            toDouble (dicn (context), context),
            toDouble (dpv (context), context),
            toDouble (dturb (context), context),
            toBoolean (feedbackSignal (context), context),
            toDouble (fl1 (context), context),
            toDouble (fl2 (context), context),
            toDouble (fl3 (context), context),
            toDouble (fl4 (context), context),
            toDouble (fl5 (context), context),
            toDouble (fp1 (context), context),
            toDouble (fp10 (context), context),
            toDouble (fp2 (context), context),
            toDouble (fp3 (context), context),
            toDouble (fp4 (context), context),
            toDouble (fp5 (context), context),
            toDouble (fp6 (context), context),
            toDouble (fp7 (context), context),
            toDouble (fp8 (context), context),
            toDouble (fp9 (context), context),
            toDouble (gmax (context), context),
            toDouble (gmin (context), context),
            toDouble (gtmxcl (context), context),
            toDouble (gtmxop (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (kd (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmss1 (context), context),
            toDouble (pmss10 (context), context),
            toDouble (pmss2 (context), context),
            toDouble (pmss3 (context), context),
            toDouble (pmss4 (context), context),
            toDouble (pmss5 (context), context),
            toDouble (pmss6 (context), context),
            toDouble (pmss7 (context), context),
            toDouble (pmss8 (context), context),
            toDouble (pmss9 (context), context),
            toDouble (rpg (context), context),
            toDouble (rpp (context), context),
            toDouble (td (context), context),
            toDouble (tdv (context), context),
            toDouble (tg (context), context),
            toDouble (tp (context), context),
            toDouble (tpe (context), context),
            toDouble (tw (context), context)
        )
    }
}

/**
 * Woodward PID Hydro Governor.
 *
 * @param sup Reference to the superclass object.
 * @param d Turbine damping factor (D).
 *        Unit = delta P / delta speed.
 * @param gatmax Gate opening Limit Maximum (Gatmax).
 * @param gatmin Gate opening Limit Minimum (Gatmin).
 * @param gv1 Gate position 1 (Gv1).
 * @param gv2 Gate position 2 (Gv2).
 * @param gv3 Gate position 3 (Gv3).
 * @param kd Derivative gain (Kd).
 *        Typical Value = 1.11.
 * @param ki Reset gain (Ki).
 *        Typical Value = 0.36.
 * @param kp Proportional gain (Kp).
 *        Typical Value = 0.1.
 * @param mwbase Base for power values  (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Output at Gv1 PU of MWbase (Pgv1).
 * @param pgv2 Output at Gv2 PU of MWbase (Pgv2).
 * @param pgv3 Output at Gv3 PU of MWbase (Pgv3).
 * @param pmax Maximum Power Output (Pmax).
 * @param pmin Minimum Power Output (Pmin).
 * @param reg Permanent drop (Reg).
 * @param ta Controller time constant (Ta) (&gt;0).
 *        Typical Value = 0.
 * @param tb Gate servo time constant (Tb) (&gt;0).
 *        Typical Value = 0.
 * @param treg Speed detector time constant (Treg).
 * @param tw Water inertia time constant (Tw) (&gt;0).
 *        Typical Value = 0.
 * @param velmax Maximum gate opening velocity (Velmax).
 *        Unit = PU/sec.  Typical Value = 0.
 * @param velmin Maximum gate closing velocity (Velmin).
 *        Unit = PU/sec.  Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovHydroWPID
(
    override val sup: TurbineGovernorDynamics,
    d: Double,
    gatmax: Double,
    gatmin: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    kd: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pmax: Double,
    pmin: Double,
    reg: Double,
    ta: Double,
    tb: Double,
    treg: Double,
    tw: Double,
    velmax: Double,
    velmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovHydroWPID.d>" + d + "</cim:GovHydroWPID.d>\n" +
        "\t\t<cim:GovHydroWPID.gatmax>" + gatmax + "</cim:GovHydroWPID.gatmax>\n" +
        "\t\t<cim:GovHydroWPID.gatmin>" + gatmin + "</cim:GovHydroWPID.gatmin>\n" +
        "\t\t<cim:GovHydroWPID.gv1>" + gv1 + "</cim:GovHydroWPID.gv1>\n" +
        "\t\t<cim:GovHydroWPID.gv2>" + gv2 + "</cim:GovHydroWPID.gv2>\n" +
        "\t\t<cim:GovHydroWPID.gv3>" + gv3 + "</cim:GovHydroWPID.gv3>\n" +
        "\t\t<cim:GovHydroWPID.kd>" + kd + "</cim:GovHydroWPID.kd>\n" +
        "\t\t<cim:GovHydroWPID.ki>" + ki + "</cim:GovHydroWPID.ki>\n" +
        "\t\t<cim:GovHydroWPID.kp>" + kp + "</cim:GovHydroWPID.kp>\n" +
        "\t\t<cim:GovHydroWPID.mwbase>" + mwbase + "</cim:GovHydroWPID.mwbase>\n" +
        "\t\t<cim:GovHydroWPID.pgv1>" + pgv1 + "</cim:GovHydroWPID.pgv1>\n" +
        "\t\t<cim:GovHydroWPID.pgv2>" + pgv2 + "</cim:GovHydroWPID.pgv2>\n" +
        "\t\t<cim:GovHydroWPID.pgv3>" + pgv3 + "</cim:GovHydroWPID.pgv3>\n" +
        "\t\t<cim:GovHydroWPID.pmax>" + pmax + "</cim:GovHydroWPID.pmax>\n" +
        "\t\t<cim:GovHydroWPID.pmin>" + pmin + "</cim:GovHydroWPID.pmin>\n" +
        "\t\t<cim:GovHydroWPID.reg>" + reg + "</cim:GovHydroWPID.reg>\n" +
        "\t\t<cim:GovHydroWPID.ta>" + ta + "</cim:GovHydroWPID.ta>\n" +
        "\t\t<cim:GovHydroWPID.tb>" + tb + "</cim:GovHydroWPID.tb>\n" +
        "\t\t<cim:GovHydroWPID.treg>" + treg + "</cim:GovHydroWPID.treg>\n" +
        "\t\t<cim:GovHydroWPID.tw>" + tw + "</cim:GovHydroWPID.tw>\n" +
        "\t\t<cim:GovHydroWPID.velmax>" + velmax + "</cim:GovHydroWPID.velmax>\n" +
        "\t\t<cim:GovHydroWPID.velmin>" + velmin + "</cim:GovHydroWPID.velmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovHydroWPID rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovHydroWPID>"
    }
}

object GovHydroWPID
extends
    Parseable[GovHydroWPID]
{
    val d = parse_element (element ("""GovHydroWPID.d"""))
    val gatmax = parse_element (element ("""GovHydroWPID.gatmax"""))
    val gatmin = parse_element (element ("""GovHydroWPID.gatmin"""))
    val gv1 = parse_element (element ("""GovHydroWPID.gv1"""))
    val gv2 = parse_element (element ("""GovHydroWPID.gv2"""))
    val gv3 = parse_element (element ("""GovHydroWPID.gv3"""))
    val kd = parse_element (element ("""GovHydroWPID.kd"""))
    val ki = parse_element (element ("""GovHydroWPID.ki"""))
    val kp = parse_element (element ("""GovHydroWPID.kp"""))
    val mwbase = parse_element (element ("""GovHydroWPID.mwbase"""))
    val pgv1 = parse_element (element ("""GovHydroWPID.pgv1"""))
    val pgv2 = parse_element (element ("""GovHydroWPID.pgv2"""))
    val pgv3 = parse_element (element ("""GovHydroWPID.pgv3"""))
    val pmax = parse_element (element ("""GovHydroWPID.pmax"""))
    val pmin = parse_element (element ("""GovHydroWPID.pmin"""))
    val reg = parse_element (element ("""GovHydroWPID.reg"""))
    val ta = parse_element (element ("""GovHydroWPID.ta"""))
    val tb = parse_element (element ("""GovHydroWPID.tb"""))
    val treg = parse_element (element ("""GovHydroWPID.treg"""))
    val tw = parse_element (element ("""GovHydroWPID.tw"""))
    val velmax = parse_element (element ("""GovHydroWPID.velmax"""))
    val velmin = parse_element (element ("""GovHydroWPID.velmin"""))
    def parse (context: Context): GovHydroWPID =
    {
        GovHydroWPID(
            TurbineGovernorDynamics.parse (context),
            toDouble (d (context), context),
            toDouble (gatmax (context), context),
            toDouble (gatmin (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (kd (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (reg (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (treg (context), context),
            toDouble (tw (context), context),
            toDouble (velmax (context), context),
            toDouble (velmin (context), context)
        )
    }
}

/**
 * A simplified steam turbine governor model.
 *
 * @param sup Reference to the superclass object.
 * @param dt Turbine damping coefficient (Dt).
 *        Unit = delta P / delta speed. Typical Value = 0.
 * @param mwbase Base for power values (MWbase)  (&gt;0).
 *        Unit = MW.
 * @param r Permanent droop (R).
 *        Typical Value = 0.05.
 * @param t1 Steam bowl time constant (T1).
 *        Typical Value = 0.5.
 * @param t2 Numerator time constant of T2/T3 block (T2).
 *        Typical Value = 3.
 * @param t3 Reheater time constant (T3).
 *        Typical Value = 10.
 * @param vmax Maximum valve position, PU of mwcap (Vmax).
 *        Typical Value = 1.
 * @param vmin Minimum valve position, PU of mwcap (Vmin).
 *        Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteam0
(
    override val sup: TurbineGovernorDynamics,
    dt: Double,
    mwbase: Double,
    r: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    vmax: Double,
    vmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteam0.dt>" + dt + "</cim:GovSteam0.dt>\n" +
        "\t\t<cim:GovSteam0.mwbase>" + mwbase + "</cim:GovSteam0.mwbase>\n" +
        "\t\t<cim:GovSteam0.r>" + r + "</cim:GovSteam0.r>\n" +
        "\t\t<cim:GovSteam0.t1>" + t1 + "</cim:GovSteam0.t1>\n" +
        "\t\t<cim:GovSteam0.t2>" + t2 + "</cim:GovSteam0.t2>\n" +
        "\t\t<cim:GovSteam0.t3>" + t3 + "</cim:GovSteam0.t3>\n" +
        "\t\t<cim:GovSteam0.vmax>" + vmax + "</cim:GovSteam0.vmax>\n" +
        "\t\t<cim:GovSteam0.vmin>" + vmin + "</cim:GovSteam0.vmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteam0 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteam0>"
    }
}

object GovSteam0
extends
    Parseable[GovSteam0]
{
    val dt = parse_element (element ("""GovSteam0.dt"""))
    val mwbase = parse_element (element ("""GovSteam0.mwbase"""))
    val r = parse_element (element ("""GovSteam0.r"""))
    val t1 = parse_element (element ("""GovSteam0.t1"""))
    val t2 = parse_element (element ("""GovSteam0.t2"""))
    val t3 = parse_element (element ("""GovSteam0.t3"""))
    val vmax = parse_element (element ("""GovSteam0.vmax"""))
    val vmin = parse_element (element ("""GovSteam0.vmin"""))
    def parse (context: Context): GovSteam0 =
    {
        GovSteam0(
            TurbineGovernorDynamics.parse (context),
            toDouble (dt (context), context),
            toDouble (mwbase (context), context),
            toDouble (r (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context)
        )
    }
}

/**
 * Steam turbine governor model, based on the GovSteamIEEE1 model  (with optional deadband and nonlinear valve gain added).
 *
 * @param sup Reference to the superclass object.
 * @param db1 Intentional deadband width (db1).
 *        Unit = Hz.  Typical Value = 0.
 * @param db2 Unintentional deadband (db2).
 *        Unit = MW.  Typical Value = 0.
 * @param eps Intentional db hysteresis (eps).
 *        Unit = Hz.  Typical Value = 0.
 * @param gv1 Nonlinear gain valve position point 1 (GV1).
 *        Typical Value = 0.
 * @param gv2 Nonlinear gain valve position point 2 (GV2).
 *        Typical Value = 0.4.
 * @param gv3 Nonlinear gain valve position point 3 (GV3).
 *        Typical Value = 0.5.
 * @param gv4 Nonlinear gain valve position point 4 (GV4).
 *        Typical Value = 0.6.
 * @param gv5 Nonlinear gain valve position point 5 (GV5).
 *        Typical Value = 1.
 * @param gv6 Nonlinear gain valve position point 6 (GV6).
 *        Typical Value = 0.
 * @param k Governor gain (reciprocal of droop) (K) (&gt;0).
 *        Typical Value = 25.
 * @param k1 Fraction of HP shaft power after first boiler pass (K1).
 *        Typical Value = 0.2.
 * @param k2 Fraction of LP shaft power after first boiler pass (K2).
 *        Typical Value = 0.
 * @param k3 Fraction of HP shaft power after second boiler pass (K3).
 *        Typical Value = 0.3.
 * @param k4 Fraction of LP shaft power after second boiler pass (K4).
 *        Typical Value = 0.
 * @param k5 Fraction of HP shaft power after third boiler pass (K5).
 *        Typical Value = 0.5.
 * @param k6 Fraction of LP shaft power after third boiler pass (K6).
 *        Typical Value = 0.
 * @param k7 Fraction of HP shaft power after fourth boiler pass (K7).
 *        Typical Value = 0.
 * @param k8 Fraction of LP shaft power after fourth boiler pass (K8).
 *        Typical Value = 0.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pgv1 Nonlinear gain power value point 1 (Pgv1).
 *        Typical Value = 0.
 * @param pgv2 Nonlinear gain power value point 2 (Pgv2).
 *        Typical Value = 0.75.
 * @param pgv3 Nonlinear gain power value point 3 (Pgv3).
 *        Typical Value = 0.91.
 * @param pgv4 Nonlinear gain power value point 4 (Pgv4).
 *        Typical Value = 0.98.
 * @param pgv5 Nonlinear gain power value point 5 (Pgv5).
 *        Typical Value = 1.
 * @param pgv6 Nonlinear gain power value point 6 (Pgv6).
 *        Typical Value = 0.
 * @param pmax Maximum valve opening (Pmax) (&gt; Pmin).
 *        Typical Value = 1.
 * @param pmin Minimum valve opening (Pmin) (&gt;=0).
 *        Typical Value = 0.
 * @param sdb1 Intentional deadband indicator.
 *        true = intentional deadband is applied
 *        false = intentional deadband is not applied.
 *        Typical Value = true.
 * @param sdb2 Unintentional deadband location.
 *        true = intentional deadband is applied before point "A"
 *        false = intentional deadband is applied after point "A".
 *        Typical Value = true.
 * @param t1 Governor lag time constant (T1).
 *        Typical Value = 0.
 * @param t2 Governor lead time constant (T2).
 *        Typical Value = 0.
 * @param t3 Valve positioner time constant (T3<i>) </i>(&gt;0).
 *        Typical Value = 0.1.
 * @param t4 Inlet piping/steam bowl time constant (T4).
 *        Typical Value = 0.3.
 * @param t5 Time constant of second boiler pass (T5).
 *        Typical Value = 5.
 * @param t6 Time constant of third boiler pass (T6).
 *        Typical Value = 0.5.
 * @param t7 Time constant of fourth boiler pass (T7).
 *        Typical Value = 0.
 * @param uc Maximum valve closing velocity (Uc) (&lt;0).
 *        Unit = PU/sec.  Typical Value = -10.
 * @param uo Maximum valve opening velocity (Uo) (&gt;0).
 *        Unit = PU/sec.  Typical Value = 1.
 * @param valve Nonlinear valve characteristic.
 *        true = nonlinear valve characteristic is used
 *        false = nonlinear valve characteristic is not used.
 *        Typical Value = true.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteam1
(
    override val sup: TurbineGovernorDynamics,
    db1: Double,
    db2: Double,
    eps: Double,
    gv1: Double,
    gv2: Double,
    gv3: Double,
    gv4: Double,
    gv5: Double,
    gv6: Double,
    k: Double,
    k1: Double,
    k2: Double,
    k3: Double,
    k4: Double,
    k5: Double,
    k6: Double,
    k7: Double,
    k8: Double,
    mwbase: Double,
    pgv1: Double,
    pgv2: Double,
    pgv3: Double,
    pgv4: Double,
    pgv5: Double,
    pgv6: Double,
    pmax: Double,
    pmin: Double,
    sdb1: Boolean,
    sdb2: Boolean,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    uc: Double,
    uo: Double,
    valve: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteam1.db1>" + db1 + "</cim:GovSteam1.db1>\n" +
        "\t\t<cim:GovSteam1.db2>" + db2 + "</cim:GovSteam1.db2>\n" +
        "\t\t<cim:GovSteam1.eps>" + eps + "</cim:GovSteam1.eps>\n" +
        "\t\t<cim:GovSteam1.gv1>" + gv1 + "</cim:GovSteam1.gv1>\n" +
        "\t\t<cim:GovSteam1.gv2>" + gv2 + "</cim:GovSteam1.gv2>\n" +
        "\t\t<cim:GovSteam1.gv3>" + gv3 + "</cim:GovSteam1.gv3>\n" +
        "\t\t<cim:GovSteam1.gv4>" + gv4 + "</cim:GovSteam1.gv4>\n" +
        "\t\t<cim:GovSteam1.gv5>" + gv5 + "</cim:GovSteam1.gv5>\n" +
        "\t\t<cim:GovSteam1.gv6>" + gv6 + "</cim:GovSteam1.gv6>\n" +
        "\t\t<cim:GovSteam1.k>" + k + "</cim:GovSteam1.k>\n" +
        "\t\t<cim:GovSteam1.k1>" + k1 + "</cim:GovSteam1.k1>\n" +
        "\t\t<cim:GovSteam1.k2>" + k2 + "</cim:GovSteam1.k2>\n" +
        "\t\t<cim:GovSteam1.k3>" + k3 + "</cim:GovSteam1.k3>\n" +
        "\t\t<cim:GovSteam1.k4>" + k4 + "</cim:GovSteam1.k4>\n" +
        "\t\t<cim:GovSteam1.k5>" + k5 + "</cim:GovSteam1.k5>\n" +
        "\t\t<cim:GovSteam1.k6>" + k6 + "</cim:GovSteam1.k6>\n" +
        "\t\t<cim:GovSteam1.k7>" + k7 + "</cim:GovSteam1.k7>\n" +
        "\t\t<cim:GovSteam1.k8>" + k8 + "</cim:GovSteam1.k8>\n" +
        "\t\t<cim:GovSteam1.mwbase>" + mwbase + "</cim:GovSteam1.mwbase>\n" +
        "\t\t<cim:GovSteam1.pgv1>" + pgv1 + "</cim:GovSteam1.pgv1>\n" +
        "\t\t<cim:GovSteam1.pgv2>" + pgv2 + "</cim:GovSteam1.pgv2>\n" +
        "\t\t<cim:GovSteam1.pgv3>" + pgv3 + "</cim:GovSteam1.pgv3>\n" +
        "\t\t<cim:GovSteam1.pgv4>" + pgv4 + "</cim:GovSteam1.pgv4>\n" +
        "\t\t<cim:GovSteam1.pgv5>" + pgv5 + "</cim:GovSteam1.pgv5>\n" +
        "\t\t<cim:GovSteam1.pgv6>" + pgv6 + "</cim:GovSteam1.pgv6>\n" +
        "\t\t<cim:GovSteam1.pmax>" + pmax + "</cim:GovSteam1.pmax>\n" +
        "\t\t<cim:GovSteam1.pmin>" + pmin + "</cim:GovSteam1.pmin>\n" +
        "\t\t<cim:GovSteam1.sdb1>" + sdb1 + "</cim:GovSteam1.sdb1>\n" +
        "\t\t<cim:GovSteam1.sdb2>" + sdb2 + "</cim:GovSteam1.sdb2>\n" +
        "\t\t<cim:GovSteam1.t1>" + t1 + "</cim:GovSteam1.t1>\n" +
        "\t\t<cim:GovSteam1.t2>" + t2 + "</cim:GovSteam1.t2>\n" +
        "\t\t<cim:GovSteam1.t3>" + t3 + "</cim:GovSteam1.t3>\n" +
        "\t\t<cim:GovSteam1.t4>" + t4 + "</cim:GovSteam1.t4>\n" +
        "\t\t<cim:GovSteam1.t5>" + t5 + "</cim:GovSteam1.t5>\n" +
        "\t\t<cim:GovSteam1.t6>" + t6 + "</cim:GovSteam1.t6>\n" +
        "\t\t<cim:GovSteam1.t7>" + t7 + "</cim:GovSteam1.t7>\n" +
        "\t\t<cim:GovSteam1.uc>" + uc + "</cim:GovSteam1.uc>\n" +
        "\t\t<cim:GovSteam1.uo>" + uo + "</cim:GovSteam1.uo>\n" +
        "\t\t<cim:GovSteam1.valve>" + valve + "</cim:GovSteam1.valve>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteam1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteam1>"
    }
}

object GovSteam1
extends
    Parseable[GovSteam1]
{
    val db1 = parse_element (element ("""GovSteam1.db1"""))
    val db2 = parse_element (element ("""GovSteam1.db2"""))
    val eps = parse_element (element ("""GovSteam1.eps"""))
    val gv1 = parse_element (element ("""GovSteam1.gv1"""))
    val gv2 = parse_element (element ("""GovSteam1.gv2"""))
    val gv3 = parse_element (element ("""GovSteam1.gv3"""))
    val gv4 = parse_element (element ("""GovSteam1.gv4"""))
    val gv5 = parse_element (element ("""GovSteam1.gv5"""))
    val gv6 = parse_element (element ("""GovSteam1.gv6"""))
    val k = parse_element (element ("""GovSteam1.k"""))
    val k1 = parse_element (element ("""GovSteam1.k1"""))
    val k2 = parse_element (element ("""GovSteam1.k2"""))
    val k3 = parse_element (element ("""GovSteam1.k3"""))
    val k4 = parse_element (element ("""GovSteam1.k4"""))
    val k5 = parse_element (element ("""GovSteam1.k5"""))
    val k6 = parse_element (element ("""GovSteam1.k6"""))
    val k7 = parse_element (element ("""GovSteam1.k7"""))
    val k8 = parse_element (element ("""GovSteam1.k8"""))
    val mwbase = parse_element (element ("""GovSteam1.mwbase"""))
    val pgv1 = parse_element (element ("""GovSteam1.pgv1"""))
    val pgv2 = parse_element (element ("""GovSteam1.pgv2"""))
    val pgv3 = parse_element (element ("""GovSteam1.pgv3"""))
    val pgv4 = parse_element (element ("""GovSteam1.pgv4"""))
    val pgv5 = parse_element (element ("""GovSteam1.pgv5"""))
    val pgv6 = parse_element (element ("""GovSteam1.pgv6"""))
    val pmax = parse_element (element ("""GovSteam1.pmax"""))
    val pmin = parse_element (element ("""GovSteam1.pmin"""))
    val sdb1 = parse_element (element ("""GovSteam1.sdb1"""))
    val sdb2 = parse_element (element ("""GovSteam1.sdb2"""))
    val t1 = parse_element (element ("""GovSteam1.t1"""))
    val t2 = parse_element (element ("""GovSteam1.t2"""))
    val t3 = parse_element (element ("""GovSteam1.t3"""))
    val t4 = parse_element (element ("""GovSteam1.t4"""))
    val t5 = parse_element (element ("""GovSteam1.t5"""))
    val t6 = parse_element (element ("""GovSteam1.t6"""))
    val t7 = parse_element (element ("""GovSteam1.t7"""))
    val uc = parse_element (element ("""GovSteam1.uc"""))
    val uo = parse_element (element ("""GovSteam1.uo"""))
    val valve = parse_element (element ("""GovSteam1.valve"""))
    def parse (context: Context): GovSteam1 =
    {
        GovSteam1(
            TurbineGovernorDynamics.parse (context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (eps (context), context),
            toDouble (gv1 (context), context),
            toDouble (gv2 (context), context),
            toDouble (gv3 (context), context),
            toDouble (gv4 (context), context),
            toDouble (gv5 (context), context),
            toDouble (gv6 (context), context),
            toDouble (k (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (k5 (context), context),
            toDouble (k6 (context), context),
            toDouble (k7 (context), context),
            toDouble (k8 (context), context),
            toDouble (mwbase (context), context),
            toDouble (pgv1 (context), context),
            toDouble (pgv2 (context), context),
            toDouble (pgv3 (context), context),
            toDouble (pgv4 (context), context),
            toDouble (pgv5 (context), context),
            toDouble (pgv6 (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toBoolean (sdb1 (context), context),
            toBoolean (sdb2 (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context),
            toBoolean (valve (context), context)
        )
    }
}

/**
 * Simplified governor model.
 *
 * @param sup Reference to the superclass object.
 * @param dbf Frequency dead band (DBF).
 *        Typical Value = 0.
 * @param k Governor gain (reciprocal of droop) (K).
 *        Typical Value = 20.
 * @param mnef Fuel flow maximum negative error value (MN<sub>EF</sub>).
 *        Typical Value = -1.
 * @param mxef Fuel flow maximum positive error value (MX<sub>EF</sub>).
 *        Typical Value = 1.
 * @param pmax Maximum fuel flow (P<sub>MAX</sub>).
 *        Typical Value = 1.
 * @param pmin Minimum fuel flow (P<sub>MIN</sub>).
 *        Typical Value = 0.
 * @param t1 Governor lag time constant (T<sub>1</sub>) (&gt;0).
 *        Typical Value = 0.45.
 * @param t2 Governor lead time constant (T<sub>2</sub>) (may be 0).
 *        Typical Value = 0.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteam2
(
    override val sup: TurbineGovernorDynamics,
    dbf: Double,
    k: Double,
    mnef: Double,
    mxef: Double,
    pmax: Double,
    pmin: Double,
    t1: Double,
    t2: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteam2.dbf>" + dbf + "</cim:GovSteam2.dbf>\n" +
        "\t\t<cim:GovSteam2.k>" + k + "</cim:GovSteam2.k>\n" +
        "\t\t<cim:GovSteam2.mnef>" + mnef + "</cim:GovSteam2.mnef>\n" +
        "\t\t<cim:GovSteam2.mxef>" + mxef + "</cim:GovSteam2.mxef>\n" +
        "\t\t<cim:GovSteam2.pmax>" + pmax + "</cim:GovSteam2.pmax>\n" +
        "\t\t<cim:GovSteam2.pmin>" + pmin + "</cim:GovSteam2.pmin>\n" +
        "\t\t<cim:GovSteam2.t1>" + t1 + "</cim:GovSteam2.t1>\n" +
        "\t\t<cim:GovSteam2.t2>" + t2 + "</cim:GovSteam2.t2>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteam2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteam2>"
    }
}

object GovSteam2
extends
    Parseable[GovSteam2]
{
    val dbf = parse_element (element ("""GovSteam2.dbf"""))
    val k = parse_element (element ("""GovSteam2.k"""))
    val mnef = parse_element (element ("""GovSteam2.mnef"""))
    val mxef = parse_element (element ("""GovSteam2.mxef"""))
    val pmax = parse_element (element ("""GovSteam2.pmax"""))
    val pmin = parse_element (element ("""GovSteam2.pmin"""))
    val t1 = parse_element (element ("""GovSteam2.t1"""))
    val t2 = parse_element (element ("""GovSteam2.t2"""))
    def parse (context: Context): GovSteam2 =
    {
        GovSteam2(
            TurbineGovernorDynamics.parse (context),
            toDouble (dbf (context), context),
            toDouble (k (context), context),
            toDouble (mnef (context), context),
            toDouble (mxef (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context)
        )
    }
}

/**
 * Cross compound turbine governor model.
 *
 * @param sup Reference to the superclass object.
 * @param dhp HP damping factor (Dhp).
 *        Typical Value = 0.
 * @param dlp LP damping factor (Dlp).
 *        Typical Value = 0.
 * @param fhp Fraction of HP power ahead of reheater (Fhp).
 *        Typical Value = 0.3.
 * @param flp Fraction of LP power ahead of reheater (Flp).
 *        Typical Value = 0.7.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pmaxhp Maximum HP value position (Pmaxhp).
 *        Typical Value = 1.
 * @param pmaxlp Maximum LP value position (Pmaxlp).
 *        Typical Value = 1.
 * @param rhp HP governor droop (Rhp).
 *        Typical Value = 0.05.
 * @param rlp LP governor droop (Rlp).
 *        Typical Value = 0.05.
 * @param t1hp HP governor time constant (T1hp).
 *        Typical Value = 0.1.
 * @param t1lp LP governor time constant (T1lp).
 *        Typical Value = 0.1.
 * @param t3hp HP turbine time constant (T3hp).
 *        Typical Value = 0.1.
 * @param t3lp LP turbine time constant (T3lp).
 *        Typical Value = 0.1.
 * @param t4hp HP turbine time constant (T4hp).
 *        Typical Value = 0.1.
 * @param t4lp LP turbine time constant (T4lp).
 *        Typical Value = 0.1.
 * @param t5hp HP reheater time constant (T5hp).
 *        Typical Value = 10.
 * @param t5lp LP reheater time constant (T5lp).
 *        Typical Value = 10.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamCC
(
    override val sup: TurbineGovernorDynamics,
    dhp: Double,
    dlp: Double,
    fhp: Double,
    flp: Double,
    mwbase: Double,
    pmaxhp: Double,
    pmaxlp: Double,
    rhp: Double,
    rlp: Double,
    t1hp: Double,
    t1lp: Double,
    t3hp: Double,
    t3lp: Double,
    t4hp: Double,
    t4lp: Double,
    t5hp: Double,
    t5lp: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[GovSteamCC] }
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
        "\t\t<cim:GovSteamCC.dhp>" + dhp + "</cim:GovSteamCC.dhp>\n" +
        "\t\t<cim:GovSteamCC.dlp>" + dlp + "</cim:GovSteamCC.dlp>\n" +
        "\t\t<cim:GovSteamCC.fhp>" + fhp + "</cim:GovSteamCC.fhp>\n" +
        "\t\t<cim:GovSteamCC.flp>" + flp + "</cim:GovSteamCC.flp>\n" +
        "\t\t<cim:GovSteamCC.mwbase>" + mwbase + "</cim:GovSteamCC.mwbase>\n" +
        "\t\t<cim:GovSteamCC.pmaxhp>" + pmaxhp + "</cim:GovSteamCC.pmaxhp>\n" +
        "\t\t<cim:GovSteamCC.pmaxlp>" + pmaxlp + "</cim:GovSteamCC.pmaxlp>\n" +
        "\t\t<cim:GovSteamCC.rhp>" + rhp + "</cim:GovSteamCC.rhp>\n" +
        "\t\t<cim:GovSteamCC.rlp>" + rlp + "</cim:GovSteamCC.rlp>\n" +
        "\t\t<cim:GovSteamCC.t1hp>" + t1hp + "</cim:GovSteamCC.t1hp>\n" +
        "\t\t<cim:GovSteamCC.t1lp>" + t1lp + "</cim:GovSteamCC.t1lp>\n" +
        "\t\t<cim:GovSteamCC.t3hp>" + t3hp + "</cim:GovSteamCC.t3hp>\n" +
        "\t\t<cim:GovSteamCC.t3lp>" + t3lp + "</cim:GovSteamCC.t3lp>\n" +
        "\t\t<cim:GovSteamCC.t4hp>" + t4hp + "</cim:GovSteamCC.t4hp>\n" +
        "\t\t<cim:GovSteamCC.t4lp>" + t4lp + "</cim:GovSteamCC.t4lp>\n" +
        "\t\t<cim:GovSteamCC.t5hp>" + t5hp + "</cim:GovSteamCC.t5hp>\n" +
        "\t\t<cim:GovSteamCC.t5lp>" + t5lp + "</cim:GovSteamCC.t5lp>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamCC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamCC>"
    }
}

object GovSteamCC
extends
    Parseable[GovSteamCC]
{
    val dhp = parse_element (element ("""GovSteamCC.dhp"""))
    val dlp = parse_element (element ("""GovSteamCC.dlp"""))
    val fhp = parse_element (element ("""GovSteamCC.fhp"""))
    val flp = parse_element (element ("""GovSteamCC.flp"""))
    val mwbase = parse_element (element ("""GovSteamCC.mwbase"""))
    val pmaxhp = parse_element (element ("""GovSteamCC.pmaxhp"""))
    val pmaxlp = parse_element (element ("""GovSteamCC.pmaxlp"""))
    val rhp = parse_element (element ("""GovSteamCC.rhp"""))
    val rlp = parse_element (element ("""GovSteamCC.rlp"""))
    val t1hp = parse_element (element ("""GovSteamCC.t1hp"""))
    val t1lp = parse_element (element ("""GovSteamCC.t1lp"""))
    val t3hp = parse_element (element ("""GovSteamCC.t3hp"""))
    val t3lp = parse_element (element ("""GovSteamCC.t3lp"""))
    val t4hp = parse_element (element ("""GovSteamCC.t4hp"""))
    val t4lp = parse_element (element ("""GovSteamCC.t4lp"""))
    val t5hp = parse_element (element ("""GovSteamCC.t5hp"""))
    val t5lp = parse_element (element ("""GovSteamCC.t5lp"""))
    def parse (context: Context): GovSteamCC =
    {
        GovSteamCC(
            TurbineGovernorDynamics.parse (context),
            toDouble (dhp (context), context),
            toDouble (dlp (context), context),
            toDouble (fhp (context), context),
            toDouble (flp (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmaxhp (context), context),
            toDouble (pmaxlp (context), context),
            toDouble (rhp (context), context),
            toDouble (rlp (context), context),
            toDouble (t1hp (context), context),
            toDouble (t1lp (context), context),
            toDouble (t3hp (context), context),
            toDouble (t3lp (context), context),
            toDouble (t4hp (context), context),
            toDouble (t4lp (context), context),
            toDouble (t5hp (context), context),
            toDouble (t5lp (context), context)
        )
    }
}

/**
 * Simplified model  of boiler and steam turbine with PID governor.
 *
 * @param sup Reference to the superclass object.
 * @param chc Control valves rate closing limit (Chc).
 *        Unit = PU/sec.  Typical Value = -3.3.
 * @param cho Control valves rate opening limit (Cho).
 *        Unit = PU/sec.  Typical Value = 0.17.
 * @param cic Intercept valves rate closing limit (Cic).
 *        Typical Value = -2.2.
 * @param cio Intercept valves rate opening limit (Cio).
 *        Typical Value = 0.123.
 * @param db1 Dead band of the frequency corrector (db1).
 *        Typical Value = 0.
 * @param db2 Dead band of the speed governor (db2).
 *        Typical Value = 0.0004.
 * @param hhpmax Maximum control valve position (Hhpmax).
 *        Typical Value = 1.
 * @param ke Gain of the power controller (Ke).
 *        Typical Value = 0.65.
 * @param kfcor Gain of the frequency corrector (Kfcor).
 *        Typical Value = 20.
 * @param khp Fraction of total turbine output generated by HP part (Khp).
 *        Typical Value = 0.277.
 * @param klp Fraction of total turbine output generated by HP part (Klp).
 *        Typical Value = 0.723.
 * @param kwcor Gain of the speed governor (Kwcor).
 *        Typical Value = 20.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pmax Maximal active power of the turbine (Pmax).
 *        Typical Value = 1.
 * @param prhmax Maximum low pressure limit (Prhmax).
 *        Typical Value = 1.4.
 * @param simx Intercept valves transfer limit (Simx).
 *        Typical Value = 0.425.
 * @param tb Boiler time constant (Tb).
 *        Typical Value = 100.
 * @param tdp Derivative time constant of the power controller (Tdp).
 *        Typical Value = 0.
 * @param ten Electro hydraulic transducer (Ten).
 *        Typical Value = 0.1.
 * @param tf Frequency transducer time constant (Tf).
 *        Typical Value = 0.
 * @param tfp Time constant of the power controller (Tfp).
 *        Typical Value = 0.
 * @param thp High pressure (HP) time constant of the turbine (Thp).
 *        Typical Value = 0.31.
 * @param tip Integral time constant of the power controller (Tip).
 *        Typical Value = 2.
 * @param tlp Low pressure(LP) time constant of the turbine (Tlp).
 *        Typical Value = 0.45.
 * @param tp Power transducer time constant (Tp).
 *        Typical Value = 0.07.
 * @param trh Reheater  time constant of the turbine (Trh).
 *        Typical Value = 8.
 * @param tvhp Control valves servo time constant (Tvhp).
 *        Typical Value = 0.1.
 * @param tvip Intercept valves servo time constant (Tvip).
 *        Typical Value = 0.15.
 * @param tw Speed transducer time constant (Tw).
 *        Typical Value = 0.02.
 * @param wfmax Upper limit for frequency correction (Wfmax).
 *        Typical Value = 0.05.
 * @param wfmin Lower limit for frequency correction (Wfmin).
 *        Typical Value = -0.05.
 * @param wmax1 Emergency speed control lower limit (wmax1).
 *        Typical Value = 1.025.
 * @param wmax2 Emergency speed control upper limit (wmax2).
 *        Typical Value = 1.05.
 * @param wwmax Upper limit for the speed governor (Wwmax).
 *        Typical Value = 0.1.
 * @param wwmin Lower limit for the speed governor frequency correction (Wwmin).
 *        Typical Value = -1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamEU
(
    override val sup: TurbineGovernorDynamics,
    chc: Double,
    cho: Double,
    cic: Double,
    cio: Double,
    db1: Double,
    db2: Double,
    hhpmax: Double,
    ke: Double,
    kfcor: Double,
    khp: Double,
    klp: Double,
    kwcor: Double,
    mwbase: Double,
    pmax: Double,
    prhmax: Double,
    simx: Double,
    tb: Double,
    tdp: Double,
    ten: Double,
    tf: Double,
    tfp: Double,
    thp: Double,
    tip: Double,
    tlp: Double,
    tp: Double,
    trh: Double,
    tvhp: Double,
    tvip: Double,
    tw: Double,
    wfmax: Double,
    wfmin: Double,
    wmax1: Double,
    wmax2: Double,
    wwmax: Double,
    wwmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamEU.chc>" + chc + "</cim:GovSteamEU.chc>\n" +
        "\t\t<cim:GovSteamEU.cho>" + cho + "</cim:GovSteamEU.cho>\n" +
        "\t\t<cim:GovSteamEU.cic>" + cic + "</cim:GovSteamEU.cic>\n" +
        "\t\t<cim:GovSteamEU.cio>" + cio + "</cim:GovSteamEU.cio>\n" +
        "\t\t<cim:GovSteamEU.db1>" + db1 + "</cim:GovSteamEU.db1>\n" +
        "\t\t<cim:GovSteamEU.db2>" + db2 + "</cim:GovSteamEU.db2>\n" +
        "\t\t<cim:GovSteamEU.hhpmax>" + hhpmax + "</cim:GovSteamEU.hhpmax>\n" +
        "\t\t<cim:GovSteamEU.ke>" + ke + "</cim:GovSteamEU.ke>\n" +
        "\t\t<cim:GovSteamEU.kfcor>" + kfcor + "</cim:GovSteamEU.kfcor>\n" +
        "\t\t<cim:GovSteamEU.khp>" + khp + "</cim:GovSteamEU.khp>\n" +
        "\t\t<cim:GovSteamEU.klp>" + klp + "</cim:GovSteamEU.klp>\n" +
        "\t\t<cim:GovSteamEU.kwcor>" + kwcor + "</cim:GovSteamEU.kwcor>\n" +
        "\t\t<cim:GovSteamEU.mwbase>" + mwbase + "</cim:GovSteamEU.mwbase>\n" +
        "\t\t<cim:GovSteamEU.pmax>" + pmax + "</cim:GovSteamEU.pmax>\n" +
        "\t\t<cim:GovSteamEU.prhmax>" + prhmax + "</cim:GovSteamEU.prhmax>\n" +
        "\t\t<cim:GovSteamEU.simx>" + simx + "</cim:GovSteamEU.simx>\n" +
        "\t\t<cim:GovSteamEU.tb>" + tb + "</cim:GovSteamEU.tb>\n" +
        "\t\t<cim:GovSteamEU.tdp>" + tdp + "</cim:GovSteamEU.tdp>\n" +
        "\t\t<cim:GovSteamEU.ten>" + ten + "</cim:GovSteamEU.ten>\n" +
        "\t\t<cim:GovSteamEU.tf>" + tf + "</cim:GovSteamEU.tf>\n" +
        "\t\t<cim:GovSteamEU.tfp>" + tfp + "</cim:GovSteamEU.tfp>\n" +
        "\t\t<cim:GovSteamEU.thp>" + thp + "</cim:GovSteamEU.thp>\n" +
        "\t\t<cim:GovSteamEU.tip>" + tip + "</cim:GovSteamEU.tip>\n" +
        "\t\t<cim:GovSteamEU.tlp>" + tlp + "</cim:GovSteamEU.tlp>\n" +
        "\t\t<cim:GovSteamEU.tp>" + tp + "</cim:GovSteamEU.tp>\n" +
        "\t\t<cim:GovSteamEU.trh>" + trh + "</cim:GovSteamEU.trh>\n" +
        "\t\t<cim:GovSteamEU.tvhp>" + tvhp + "</cim:GovSteamEU.tvhp>\n" +
        "\t\t<cim:GovSteamEU.tvip>" + tvip + "</cim:GovSteamEU.tvip>\n" +
        "\t\t<cim:GovSteamEU.tw>" + tw + "</cim:GovSteamEU.tw>\n" +
        "\t\t<cim:GovSteamEU.wfmax>" + wfmax + "</cim:GovSteamEU.wfmax>\n" +
        "\t\t<cim:GovSteamEU.wfmin>" + wfmin + "</cim:GovSteamEU.wfmin>\n" +
        "\t\t<cim:GovSteamEU.wmax1>" + wmax1 + "</cim:GovSteamEU.wmax1>\n" +
        "\t\t<cim:GovSteamEU.wmax2>" + wmax2 + "</cim:GovSteamEU.wmax2>\n" +
        "\t\t<cim:GovSteamEU.wwmax>" + wwmax + "</cim:GovSteamEU.wwmax>\n" +
        "\t\t<cim:GovSteamEU.wwmin>" + wwmin + "</cim:GovSteamEU.wwmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamEU rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamEU>"
    }
}

object GovSteamEU
extends
    Parseable[GovSteamEU]
{
    val chc = parse_element (element ("""GovSteamEU.chc"""))
    val cho = parse_element (element ("""GovSteamEU.cho"""))
    val cic = parse_element (element ("""GovSteamEU.cic"""))
    val cio = parse_element (element ("""GovSteamEU.cio"""))
    val db1 = parse_element (element ("""GovSteamEU.db1"""))
    val db2 = parse_element (element ("""GovSteamEU.db2"""))
    val hhpmax = parse_element (element ("""GovSteamEU.hhpmax"""))
    val ke = parse_element (element ("""GovSteamEU.ke"""))
    val kfcor = parse_element (element ("""GovSteamEU.kfcor"""))
    val khp = parse_element (element ("""GovSteamEU.khp"""))
    val klp = parse_element (element ("""GovSteamEU.klp"""))
    val kwcor = parse_element (element ("""GovSteamEU.kwcor"""))
    val mwbase = parse_element (element ("""GovSteamEU.mwbase"""))
    val pmax = parse_element (element ("""GovSteamEU.pmax"""))
    val prhmax = parse_element (element ("""GovSteamEU.prhmax"""))
    val simx = parse_element (element ("""GovSteamEU.simx"""))
    val tb = parse_element (element ("""GovSteamEU.tb"""))
    val tdp = parse_element (element ("""GovSteamEU.tdp"""))
    val ten = parse_element (element ("""GovSteamEU.ten"""))
    val tf = parse_element (element ("""GovSteamEU.tf"""))
    val tfp = parse_element (element ("""GovSteamEU.tfp"""))
    val thp = parse_element (element ("""GovSteamEU.thp"""))
    val tip = parse_element (element ("""GovSteamEU.tip"""))
    val tlp = parse_element (element ("""GovSteamEU.tlp"""))
    val tp = parse_element (element ("""GovSteamEU.tp"""))
    val trh = parse_element (element ("""GovSteamEU.trh"""))
    val tvhp = parse_element (element ("""GovSteamEU.tvhp"""))
    val tvip = parse_element (element ("""GovSteamEU.tvip"""))
    val tw = parse_element (element ("""GovSteamEU.tw"""))
    val wfmax = parse_element (element ("""GovSteamEU.wfmax"""))
    val wfmin = parse_element (element ("""GovSteamEU.wfmin"""))
    val wmax1 = parse_element (element ("""GovSteamEU.wmax1"""))
    val wmax2 = parse_element (element ("""GovSteamEU.wmax2"""))
    val wwmax = parse_element (element ("""GovSteamEU.wwmax"""))
    val wwmin = parse_element (element ("""GovSteamEU.wwmin"""))
    def parse (context: Context): GovSteamEU =
    {
        GovSteamEU(
            TurbineGovernorDynamics.parse (context),
            toDouble (chc (context), context),
            toDouble (cho (context), context),
            toDouble (cic (context), context),
            toDouble (cio (context), context),
            toDouble (db1 (context), context),
            toDouble (db2 (context), context),
            toDouble (hhpmax (context), context),
            toDouble (ke (context), context),
            toDouble (kfcor (context), context),
            toDouble (khp (context), context),
            toDouble (klp (context), context),
            toDouble (kwcor (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmax (context), context),
            toDouble (prhmax (context), context),
            toDouble (simx (context), context),
            toDouble (tb (context), context),
            toDouble (tdp (context), context),
            toDouble (ten (context), context),
            toDouble (tf (context), context),
            toDouble (tfp (context), context),
            toDouble (thp (context), context),
            toDouble (tip (context), context),
            toDouble (tlp (context), context),
            toDouble (tp (context), context),
            toDouble (trh (context), context),
            toDouble (tvhp (context), context),
            toDouble (tvip (context), context),
            toDouble (tw (context), context),
            toDouble (wfmax (context), context),
            toDouble (wfmin (context), context),
            toDouble (wmax1 (context), context),
            toDouble (wmax2 (context), context),
            toDouble (wwmax (context), context),
            toDouble (wwmin (context), context)
        )
    }
}

/**
 * Steam turbine governor with reheat time constants and modeling of the effects of fast valve closing to reduce mechanical power.
 *
 * @param sup Reference to the superclass object.
 * @param dt (Dt).
 * @param k Fraction of the turbine power developed by turbine sections not involved in fast valving (K).
 * @param mwbase Alternate Base used instead of Machine base in equipment model if necessary (MWbase) (&gt;0).
 *        Unit = MW.
 * @param r (R).
 * @param t1 Governor time constant (T1).
 * @param t3 Reheater time constant (T3).
 * @param ta Time after initial time for valve to close (Ta).
 * @param tb Time after initial time for valve to begin opening (Tb).
 * @param tc Time after initial time for valve to become fully open (Tc).
 * @param ti Initial time to begin fast valving (Ti).
 * @param tt Time constant with which power falls off after intercept valve closure (Tt).
 * @param vmax (Vmax).
 * @param vmin (Vmin).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamFV2
(
    override val sup: TurbineGovernorDynamics,
    dt: Double,
    k: Double,
    mwbase: Double,
    r: Double,
    t1: Double,
    t3: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    ti: Double,
    tt: Double,
    vmax: Double,
    vmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamFV2.dt>" + dt + "</cim:GovSteamFV2.dt>\n" +
        "\t\t<cim:GovSteamFV2.k>" + k + "</cim:GovSteamFV2.k>\n" +
        "\t\t<cim:GovSteamFV2.mwbase>" + mwbase + "</cim:GovSteamFV2.mwbase>\n" +
        "\t\t<cim:GovSteamFV2.r>" + r + "</cim:GovSteamFV2.r>\n" +
        "\t\t<cim:GovSteamFV2.t1>" + t1 + "</cim:GovSteamFV2.t1>\n" +
        "\t\t<cim:GovSteamFV2.t3>" + t3 + "</cim:GovSteamFV2.t3>\n" +
        "\t\t<cim:GovSteamFV2.ta>" + ta + "</cim:GovSteamFV2.ta>\n" +
        "\t\t<cim:GovSteamFV2.tb>" + tb + "</cim:GovSteamFV2.tb>\n" +
        "\t\t<cim:GovSteamFV2.tc>" + tc + "</cim:GovSteamFV2.tc>\n" +
        "\t\t<cim:GovSteamFV2.ti>" + ti + "</cim:GovSteamFV2.ti>\n" +
        "\t\t<cim:GovSteamFV2.tt>" + tt + "</cim:GovSteamFV2.tt>\n" +
        "\t\t<cim:GovSteamFV2.vmax>" + vmax + "</cim:GovSteamFV2.vmax>\n" +
        "\t\t<cim:GovSteamFV2.vmin>" + vmin + "</cim:GovSteamFV2.vmin>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV2 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamFV2>"
    }
}

object GovSteamFV2
extends
    Parseable[GovSteamFV2]
{
    val dt = parse_element (element ("""GovSteamFV2.dt"""))
    val k = parse_element (element ("""GovSteamFV2.k"""))
    val mwbase = parse_element (element ("""GovSteamFV2.mwbase"""))
    val r = parse_element (element ("""GovSteamFV2.r"""))
    val t1 = parse_element (element ("""GovSteamFV2.t1"""))
    val t3 = parse_element (element ("""GovSteamFV2.t3"""))
    val ta = parse_element (element ("""GovSteamFV2.ta"""))
    val tb = parse_element (element ("""GovSteamFV2.tb"""))
    val tc = parse_element (element ("""GovSteamFV2.tc"""))
    val ti = parse_element (element ("""GovSteamFV2.ti"""))
    val tt = parse_element (element ("""GovSteamFV2.tt"""))
    val vmax = parse_element (element ("""GovSteamFV2.vmax"""))
    val vmin = parse_element (element ("""GovSteamFV2.vmin"""))
    def parse (context: Context): GovSteamFV2 =
    {
        GovSteamFV2(
            TurbineGovernorDynamics.parse (context),
            toDouble (dt (context), context),
            toDouble (k (context), context),
            toDouble (mwbase (context), context),
            toDouble (r (context), context),
            toDouble (t1 (context), context),
            toDouble (t3 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (ti (context), context),
            toDouble (tt (context), context),
            toDouble (vmax (context), context),
            toDouble (vmin (context), context)
        )
    }
}

/**
 * Simplified GovSteamIEEE1 Steam turbine governor model with Prmax limit and fast valving.
 *
 * @param sup Reference to the superclass object.
 * @param k Governor gain, (reciprocal of droop) (K).
 *        Typical Value = 20.
 * @param k1 Fraction of turbine power developed after first boiler pass (K1).
 *        Typical Value = 0.2.
 * @param k2 Fraction of turbine power developed after second boiler pass (K2).
 *        Typical Value = 0.2.
 * @param k3 Fraction of hp turbine power developed after crossover or third boiler pass (K3).
 *        Typical Value = 0.6.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pmax Maximum valve opening, PU of MWbase (Pmax).
 *        Typical Value = 1.
 * @param pmin Minimum valve opening, PU of MWbase (Pmin).
 *        Typical Value = 0.
 * @param prmax Max. pressure in reheater (Prmax).
 *        Typical Value = 1.
 * @param t1 Governor lead time constant (T1).
 *        Typical Value = 0.
 * @param t2 Governor lag time constant (T2).
 *        Typical Value = 0.
 * @param t3 Valve positioner time constant (T3).
 *        Typical Value = 0.
 * @param t4 Inlet piping/steam bowl time constant (T4).
 *        Typical Value = 0.2.
 * @param t5 Time constant of second boiler pass (i.e. reheater) (T5).
 *        Typical Value = 0.5.
 * @param t6 Time constant of crossover or third boiler pass (T6).
 *        Typical Value = 10.
 * @param ta Time to close intercept valve (IV) (Ta).
 *        Typical Value = 0.97.
 * @param tb Time until IV starts to reopen (Tb).
 *        Typical Value = 0.98.
 * @param tc Time until IV is fully open (Tc).
 *        Typical Value = 0.99.
 * @param uc Maximum valve closing velocity (Uc).
 *        Unit = PU/sec.  Typical Value = -1.
 * @param uo Maximum valve opening velocity (Uo).
 *        Unit = PU/sec.  Typical Value = 0.1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamFV3
(
    override val sup: TurbineGovernorDynamics,
    k: Double,
    k1: Double,
    k2: Double,
    k3: Double,
    mwbase: Double,
    pmax: Double,
    pmin: Double,
    prmax: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    ta: Double,
    tb: Double,
    tc: Double,
    uc: Double,
    uo: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamFV3.k>" + k + "</cim:GovSteamFV3.k>\n" +
        "\t\t<cim:GovSteamFV3.k1>" + k1 + "</cim:GovSteamFV3.k1>\n" +
        "\t\t<cim:GovSteamFV3.k2>" + k2 + "</cim:GovSteamFV3.k2>\n" +
        "\t\t<cim:GovSteamFV3.k3>" + k3 + "</cim:GovSteamFV3.k3>\n" +
        "\t\t<cim:GovSteamFV3.mwbase>" + mwbase + "</cim:GovSteamFV3.mwbase>\n" +
        "\t\t<cim:GovSteamFV3.pmax>" + pmax + "</cim:GovSteamFV3.pmax>\n" +
        "\t\t<cim:GovSteamFV3.pmin>" + pmin + "</cim:GovSteamFV3.pmin>\n" +
        "\t\t<cim:GovSteamFV3.prmax>" + prmax + "</cim:GovSteamFV3.prmax>\n" +
        "\t\t<cim:GovSteamFV3.t1>" + t1 + "</cim:GovSteamFV3.t1>\n" +
        "\t\t<cim:GovSteamFV3.t2>" + t2 + "</cim:GovSteamFV3.t2>\n" +
        "\t\t<cim:GovSteamFV3.t3>" + t3 + "</cim:GovSteamFV3.t3>\n" +
        "\t\t<cim:GovSteamFV3.t4>" + t4 + "</cim:GovSteamFV3.t4>\n" +
        "\t\t<cim:GovSteamFV3.t5>" + t5 + "</cim:GovSteamFV3.t5>\n" +
        "\t\t<cim:GovSteamFV3.t6>" + t6 + "</cim:GovSteamFV3.t6>\n" +
        "\t\t<cim:GovSteamFV3.ta>" + ta + "</cim:GovSteamFV3.ta>\n" +
        "\t\t<cim:GovSteamFV3.tb>" + tb + "</cim:GovSteamFV3.tb>\n" +
        "\t\t<cim:GovSteamFV3.tc>" + tc + "</cim:GovSteamFV3.tc>\n" +
        "\t\t<cim:GovSteamFV3.uc>" + uc + "</cim:GovSteamFV3.uc>\n" +
        "\t\t<cim:GovSteamFV3.uo>" + uo + "</cim:GovSteamFV3.uo>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV3 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamFV3>"
    }
}

object GovSteamFV3
extends
    Parseable[GovSteamFV3]
{
    val k = parse_element (element ("""GovSteamFV3.k"""))
    val k1 = parse_element (element ("""GovSteamFV3.k1"""))
    val k2 = parse_element (element ("""GovSteamFV3.k2"""))
    val k3 = parse_element (element ("""GovSteamFV3.k3"""))
    val mwbase = parse_element (element ("""GovSteamFV3.mwbase"""))
    val pmax = parse_element (element ("""GovSteamFV3.pmax"""))
    val pmin = parse_element (element ("""GovSteamFV3.pmin"""))
    val prmax = parse_element (element ("""GovSteamFV3.prmax"""))
    val t1 = parse_element (element ("""GovSteamFV3.t1"""))
    val t2 = parse_element (element ("""GovSteamFV3.t2"""))
    val t3 = parse_element (element ("""GovSteamFV3.t3"""))
    val t4 = parse_element (element ("""GovSteamFV3.t4"""))
    val t5 = parse_element (element ("""GovSteamFV3.t5"""))
    val t6 = parse_element (element ("""GovSteamFV3.t6"""))
    val ta = parse_element (element ("""GovSteamFV3.ta"""))
    val tb = parse_element (element ("""GovSteamFV3.tb"""))
    val tc = parse_element (element ("""GovSteamFV3.tc"""))
    val uc = parse_element (element ("""GovSteamFV3.uc"""))
    val uo = parse_element (element ("""GovSteamFV3.uo"""))
    def parse (context: Context): GovSteamFV3 =
    {
        GovSteamFV3(
            TurbineGovernorDynamics.parse (context),
            toDouble (k (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (prmax (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (ta (context), context),
            toDouble (tb (context), context),
            toDouble (tc (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context)
        )
    }
}

/**
 * Detailed electro-hydraulic governor for steam unit.
 *
 * @param sup Reference to the superclass object.
 * @param cpsmn Minimum value of pressure regulator output (Cpsmn).
 *        Typical Value = -1.
 * @param cpsmx Maximum value of pressure regulator output (Cpsmx).
 *        Typical Value = 1.
 * @param crmn Minimum value of regulator set-point (Crmn).
 *        Typical Value = 0.
 * @param crmx Maximum value of regulator set-point (Crmx).
 *        Typical Value = 1.2.
 * @param kdc Derivative gain of pressure regulator (Kdc).
 *        Typical Value = 1.
 * @param kf1 Frequency bias (reciprocal of droop) (Kf1).
 *        Typical Value = 20.
 * @param kf3 Frequency control (reciprocal of droop) (Kf3).
 *        Typical Value = 20.
 * @param khp Fraction  of total turbine output generated by HP part (Khp).
 *        Typical Value = 0.35.
 * @param kic Integral gain of pressure regulator (Kic).
 *        Typical Value = 0.0033.
 * @param kip Integral gain of pressure feedback regulator (Kip).
 *        Typical Value = 0.5.
 * @param kit Integral gain of electro-hydraulic regulator (Kit).
 *        Typical Value = 0.04.
 * @param kmp1 First gain coefficient of  intercept valves characteristic (Kmp1).
 *        Typical Value = 0.5.
 * @param kmp2 Second gain coefficient of intercept valves characteristic (Kmp2).
 *        Typical Value = 3.5.
 * @param kpc Proportional gain of pressure regulator (Kpc).
 *        Typical Value = 0.5.
 * @param kpp Proportional gain of pressure feedback regulator (Kpp).
 *        Typical Value = 1.
 * @param kpt Proportional gain of electro-hydraulic regulator (Kpt).
 *        Typical Value = 0.3.
 * @param krc Maximum variation of fuel flow (Krc).
 *        Typical Value = 0.05.
 * @param ksh Pressure loss due to flow friction in the boiler tubes (Ksh).
 *        Typical Value = 0.08.
 * @param lpi Maximum negative power error (Lpi).
 *        Typical Value = -0.15.
 * @param lps Maximum positive power error (Lps).
 *        Typical Value = 0.03.
 * @param mnef Lower limit for frequency correction (MN<sub>EF</sub>).
 *        Typical Value = -0.05.
 * @param mxef Upper limit for frequency correction (MX<sub>EF</sub>).
 *        Typical Value = 0.05.
 * @param pr1 First value of pressure set point static characteristic (Pr1).
 *        Typical Value = 0.2.
 * @param pr2 Second value of pressure set point static characteristic, corresponding to Ps0 = 1.0 PU (Pr2).
 *        Typical Value = 0.75.
 * @param psmn Minimum value of pressure set point static characteristic (Psmn).
 *        Typical Value = 1.
 * @param rsmimn Minimum value of integral regulator (Rsmimn).
 *        Typical Value = 0.
 * @param rsmimx Maximum value of integral regulator (Rsmimx).
 *        Typical Value = 1.1.
 * @param rvgmn Minimum value of integral regulator (Rvgmn).
 *        Typical Value = 0.
 * @param rvgmx Maximum value of integral regulator (Rvgmx).
 *        Typical Value = 1.2.
 * @param srmn Minimum valve opening (Srmn).
 *        Typical Value = 0.
 * @param srmx Maximum valve opening (Srmx).
 *        Typical Value = 1.1.
 * @param srsmp Intercept valves characteristic discontinuity point (Srsmp).
 *        Typical Value = 0.43.
 * @param svmn Maximum regulator gate closing velocity (Svmn).
 *        Typical Value = -0.0333.
 * @param svmx Maximum regulator gate opening velocity (Svmx).
 *        Typical Value = 0.0333.
 * @param ta Control valves rate opening time (Ta).
 *        Typical Value = 0.8.
 * @param tam Intercept valves rate opening time (Tam).
 *        Typical Value = 0.8.
 * @param tc Control valves rate closing time (Tc).
 *        Typical Value = 0.5.
 * @param tcm Intercept valves rate closing time (Tcm).
 *        Typical Value = 0.5.
 * @param tdc Derivative time constant of pressure regulator (Tdc).
 *        Typical Value = 90.
 * @param tf1 Time constant of fuel regulation (Tf1).
 *        Typical Value = 10.
 * @param tf2 Time constant of steam chest (Tf2).
 *        Typical Value = 10.
 * @param thp High pressure (HP) time constant of the turbine (Thp).
 *        Typical Value = 0.15.
 * @param tmp Low pressure (LP) time constant of the turbine (Tmp).
 *        Typical Value = 0.4.
 * @param trh Reheater  time constant of the turbine (Trh).
 *        Typical Value = 10.
 * @param tv Boiler time constant (Tv).
 *        Typical Value = 60.
 * @param ty Control valves servo time constant (Ty).
 *        Typical Value = 0.1.
 * @param y Coefficient of linearized equations of turbine (Stodola formulation) (Y).
 *        Typical Value = 0.13.
 * @param yhpmn Minimum control valve position (Yhpmn).
 *        Typical Value = 0.
 * @param yhpmx Maximum control valve position (Yhpmx).
 *        Typical Value = 1.1.
 * @param ympmn Minimum intercept valve position (Ympmn).
 *        Typical Value = 0.
 * @param ympmx Maximum intercept valve position (Ympmx).
 *        Typical Value = 1.1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamFV4
(
    override val sup: TurbineGovernorDynamics,
    cpsmn: Double,
    cpsmx: Double,
    crmn: Double,
    crmx: Double,
    kdc: Double,
    kf1: Double,
    kf3: Double,
    khp: Double,
    kic: Double,
    kip: Double,
    kit: Double,
    kmp1: Double,
    kmp2: Double,
    kpc: Double,
    kpp: Double,
    kpt: Double,
    krc: Double,
    ksh: Double,
    lpi: Double,
    lps: Double,
    mnef: Double,
    mxef: Double,
    pr1: Double,
    pr2: Double,
    psmn: Double,
    rsmimn: Double,
    rsmimx: Double,
    rvgmn: Double,
    rvgmx: Double,
    srmn: Double,
    srmx: Double,
    srsmp: Double,
    svmn: Double,
    svmx: Double,
    ta: Double,
    tam: Double,
    tc: Double,
    tcm: Double,
    tdc: Double,
    tf1: Double,
    tf2: Double,
    thp: Double,
    tmp: Double,
    trh: Double,
    tv: Double,
    ty: Double,
    y: Double,
    yhpmn: Double,
    yhpmx: Double,
    ympmn: Double,
    ympmx: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamFV4.cpsmn>" + cpsmn + "</cim:GovSteamFV4.cpsmn>\n" +
        "\t\t<cim:GovSteamFV4.cpsmx>" + cpsmx + "</cim:GovSteamFV4.cpsmx>\n" +
        "\t\t<cim:GovSteamFV4.crmn>" + crmn + "</cim:GovSteamFV4.crmn>\n" +
        "\t\t<cim:GovSteamFV4.crmx>" + crmx + "</cim:GovSteamFV4.crmx>\n" +
        "\t\t<cim:GovSteamFV4.kdc>" + kdc + "</cim:GovSteamFV4.kdc>\n" +
        "\t\t<cim:GovSteamFV4.kf1>" + kf1 + "</cim:GovSteamFV4.kf1>\n" +
        "\t\t<cim:GovSteamFV4.kf3>" + kf3 + "</cim:GovSteamFV4.kf3>\n" +
        "\t\t<cim:GovSteamFV4.khp>" + khp + "</cim:GovSteamFV4.khp>\n" +
        "\t\t<cim:GovSteamFV4.kic>" + kic + "</cim:GovSteamFV4.kic>\n" +
        "\t\t<cim:GovSteamFV4.kip>" + kip + "</cim:GovSteamFV4.kip>\n" +
        "\t\t<cim:GovSteamFV4.kit>" + kit + "</cim:GovSteamFV4.kit>\n" +
        "\t\t<cim:GovSteamFV4.kmp1>" + kmp1 + "</cim:GovSteamFV4.kmp1>\n" +
        "\t\t<cim:GovSteamFV4.kmp2>" + kmp2 + "</cim:GovSteamFV4.kmp2>\n" +
        "\t\t<cim:GovSteamFV4.kpc>" + kpc + "</cim:GovSteamFV4.kpc>\n" +
        "\t\t<cim:GovSteamFV4.kpp>" + kpp + "</cim:GovSteamFV4.kpp>\n" +
        "\t\t<cim:GovSteamFV4.kpt>" + kpt + "</cim:GovSteamFV4.kpt>\n" +
        "\t\t<cim:GovSteamFV4.krc>" + krc + "</cim:GovSteamFV4.krc>\n" +
        "\t\t<cim:GovSteamFV4.ksh>" + ksh + "</cim:GovSteamFV4.ksh>\n" +
        "\t\t<cim:GovSteamFV4.lpi>" + lpi + "</cim:GovSteamFV4.lpi>\n" +
        "\t\t<cim:GovSteamFV4.lps>" + lps + "</cim:GovSteamFV4.lps>\n" +
        "\t\t<cim:GovSteamFV4.mnef>" + mnef + "</cim:GovSteamFV4.mnef>\n" +
        "\t\t<cim:GovSteamFV4.mxef>" + mxef + "</cim:GovSteamFV4.mxef>\n" +
        "\t\t<cim:GovSteamFV4.pr1>" + pr1 + "</cim:GovSteamFV4.pr1>\n" +
        "\t\t<cim:GovSteamFV4.pr2>" + pr2 + "</cim:GovSteamFV4.pr2>\n" +
        "\t\t<cim:GovSteamFV4.psmn>" + psmn + "</cim:GovSteamFV4.psmn>\n" +
        "\t\t<cim:GovSteamFV4.rsmimn>" + rsmimn + "</cim:GovSteamFV4.rsmimn>\n" +
        "\t\t<cim:GovSteamFV4.rsmimx>" + rsmimx + "</cim:GovSteamFV4.rsmimx>\n" +
        "\t\t<cim:GovSteamFV4.rvgmn>" + rvgmn + "</cim:GovSteamFV4.rvgmn>\n" +
        "\t\t<cim:GovSteamFV4.rvgmx>" + rvgmx + "</cim:GovSteamFV4.rvgmx>\n" +
        "\t\t<cim:GovSteamFV4.srmn>" + srmn + "</cim:GovSteamFV4.srmn>\n" +
        "\t\t<cim:GovSteamFV4.srmx>" + srmx + "</cim:GovSteamFV4.srmx>\n" +
        "\t\t<cim:GovSteamFV4.srsmp>" + srsmp + "</cim:GovSteamFV4.srsmp>\n" +
        "\t\t<cim:GovSteamFV4.svmn>" + svmn + "</cim:GovSteamFV4.svmn>\n" +
        "\t\t<cim:GovSteamFV4.svmx>" + svmx + "</cim:GovSteamFV4.svmx>\n" +
        "\t\t<cim:GovSteamFV4.ta>" + ta + "</cim:GovSteamFV4.ta>\n" +
        "\t\t<cim:GovSteamFV4.tam>" + tam + "</cim:GovSteamFV4.tam>\n" +
        "\t\t<cim:GovSteamFV4.tc>" + tc + "</cim:GovSteamFV4.tc>\n" +
        "\t\t<cim:GovSteamFV4.tcm>" + tcm + "</cim:GovSteamFV4.tcm>\n" +
        "\t\t<cim:GovSteamFV4.tdc>" + tdc + "</cim:GovSteamFV4.tdc>\n" +
        "\t\t<cim:GovSteamFV4.tf1>" + tf1 + "</cim:GovSteamFV4.tf1>\n" +
        "\t\t<cim:GovSteamFV4.tf2>" + tf2 + "</cim:GovSteamFV4.tf2>\n" +
        "\t\t<cim:GovSteamFV4.thp>" + thp + "</cim:GovSteamFV4.thp>\n" +
        "\t\t<cim:GovSteamFV4.tmp>" + tmp + "</cim:GovSteamFV4.tmp>\n" +
        "\t\t<cim:GovSteamFV4.trh>" + trh + "</cim:GovSteamFV4.trh>\n" +
        "\t\t<cim:GovSteamFV4.tv>" + tv + "</cim:GovSteamFV4.tv>\n" +
        "\t\t<cim:GovSteamFV4.ty>" + ty + "</cim:GovSteamFV4.ty>\n" +
        "\t\t<cim:GovSteamFV4.y>" + y + "</cim:GovSteamFV4.y>\n" +
        "\t\t<cim:GovSteamFV4.yhpmn>" + yhpmn + "</cim:GovSteamFV4.yhpmn>\n" +
        "\t\t<cim:GovSteamFV4.yhpmx>" + yhpmx + "</cim:GovSteamFV4.yhpmx>\n" +
        "\t\t<cim:GovSteamFV4.ympmn>" + ympmn + "</cim:GovSteamFV4.ympmn>\n" +
        "\t\t<cim:GovSteamFV4.ympmx>" + ympmx + "</cim:GovSteamFV4.ympmx>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamFV4 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamFV4>"
    }
}

object GovSteamFV4
extends
    Parseable[GovSteamFV4]
{
    val cpsmn = parse_element (element ("""GovSteamFV4.cpsmn"""))
    val cpsmx = parse_element (element ("""GovSteamFV4.cpsmx"""))
    val crmn = parse_element (element ("""GovSteamFV4.crmn"""))
    val crmx = parse_element (element ("""GovSteamFV4.crmx"""))
    val kdc = parse_element (element ("""GovSteamFV4.kdc"""))
    val kf1 = parse_element (element ("""GovSteamFV4.kf1"""))
    val kf3 = parse_element (element ("""GovSteamFV4.kf3"""))
    val khp = parse_element (element ("""GovSteamFV4.khp"""))
    val kic = parse_element (element ("""GovSteamFV4.kic"""))
    val kip = parse_element (element ("""GovSteamFV4.kip"""))
    val kit = parse_element (element ("""GovSteamFV4.kit"""))
    val kmp1 = parse_element (element ("""GovSteamFV4.kmp1"""))
    val kmp2 = parse_element (element ("""GovSteamFV4.kmp2"""))
    val kpc = parse_element (element ("""GovSteamFV4.kpc"""))
    val kpp = parse_element (element ("""GovSteamFV4.kpp"""))
    val kpt = parse_element (element ("""GovSteamFV4.kpt"""))
    val krc = parse_element (element ("""GovSteamFV4.krc"""))
    val ksh = parse_element (element ("""GovSteamFV4.ksh"""))
    val lpi = parse_element (element ("""GovSteamFV4.lpi"""))
    val lps = parse_element (element ("""GovSteamFV4.lps"""))
    val mnef = parse_element (element ("""GovSteamFV4.mnef"""))
    val mxef = parse_element (element ("""GovSteamFV4.mxef"""))
    val pr1 = parse_element (element ("""GovSteamFV4.pr1"""))
    val pr2 = parse_element (element ("""GovSteamFV4.pr2"""))
    val psmn = parse_element (element ("""GovSteamFV4.psmn"""))
    val rsmimn = parse_element (element ("""GovSteamFV4.rsmimn"""))
    val rsmimx = parse_element (element ("""GovSteamFV4.rsmimx"""))
    val rvgmn = parse_element (element ("""GovSteamFV4.rvgmn"""))
    val rvgmx = parse_element (element ("""GovSteamFV4.rvgmx"""))
    val srmn = parse_element (element ("""GovSteamFV4.srmn"""))
    val srmx = parse_element (element ("""GovSteamFV4.srmx"""))
    val srsmp = parse_element (element ("""GovSteamFV4.srsmp"""))
    val svmn = parse_element (element ("""GovSteamFV4.svmn"""))
    val svmx = parse_element (element ("""GovSteamFV4.svmx"""))
    val ta = parse_element (element ("""GovSteamFV4.ta"""))
    val tam = parse_element (element ("""GovSteamFV4.tam"""))
    val tc = parse_element (element ("""GovSteamFV4.tc"""))
    val tcm = parse_element (element ("""GovSteamFV4.tcm"""))
    val tdc = parse_element (element ("""GovSteamFV4.tdc"""))
    val tf1 = parse_element (element ("""GovSteamFV4.tf1"""))
    val tf2 = parse_element (element ("""GovSteamFV4.tf2"""))
    val thp = parse_element (element ("""GovSteamFV4.thp"""))
    val tmp = parse_element (element ("""GovSteamFV4.tmp"""))
    val trh = parse_element (element ("""GovSteamFV4.trh"""))
    val tv = parse_element (element ("""GovSteamFV4.tv"""))
    val ty = parse_element (element ("""GovSteamFV4.ty"""))
    val y = parse_element (element ("""GovSteamFV4.y"""))
    val yhpmn = parse_element (element ("""GovSteamFV4.yhpmn"""))
    val yhpmx = parse_element (element ("""GovSteamFV4.yhpmx"""))
    val ympmn = parse_element (element ("""GovSteamFV4.ympmn"""))
    val ympmx = parse_element (element ("""GovSteamFV4.ympmx"""))
    def parse (context: Context): GovSteamFV4 =
    {
        GovSteamFV4(
            TurbineGovernorDynamics.parse (context),
            toDouble (cpsmn (context), context),
            toDouble (cpsmx (context), context),
            toDouble (crmn (context), context),
            toDouble (crmx (context), context),
            toDouble (kdc (context), context),
            toDouble (kf1 (context), context),
            toDouble (kf3 (context), context),
            toDouble (khp (context), context),
            toDouble (kic (context), context),
            toDouble (kip (context), context),
            toDouble (kit (context), context),
            toDouble (kmp1 (context), context),
            toDouble (kmp2 (context), context),
            toDouble (kpc (context), context),
            toDouble (kpp (context), context),
            toDouble (kpt (context), context),
            toDouble (krc (context), context),
            toDouble (ksh (context), context),
            toDouble (lpi (context), context),
            toDouble (lps (context), context),
            toDouble (mnef (context), context),
            toDouble (mxef (context), context),
            toDouble (pr1 (context), context),
            toDouble (pr2 (context), context),
            toDouble (psmn (context), context),
            toDouble (rsmimn (context), context),
            toDouble (rsmimx (context), context),
            toDouble (rvgmn (context), context),
            toDouble (rvgmx (context), context),
            toDouble (srmn (context), context),
            toDouble (srmx (context), context),
            toDouble (srsmp (context), context),
            toDouble (svmn (context), context),
            toDouble (svmx (context), context),
            toDouble (ta (context), context),
            toDouble (tam (context), context),
            toDouble (tc (context), context),
            toDouble (tcm (context), context),
            toDouble (tdc (context), context),
            toDouble (tf1 (context), context),
            toDouble (tf2 (context), context),
            toDouble (thp (context), context),
            toDouble (tmp (context), context),
            toDouble (trh (context), context),
            toDouble (tv (context), context),
            toDouble (ty (context), context),
            toDouble (y (context), context),
            toDouble (yhpmn (context), context),
            toDouble (yhpmx (context), context),
            toDouble (ympmn (context), context),
            toDouble (ympmx (context), context)
        )
    }
}

/**
 * IEEE steam turbine governor model.
 *
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems</font>
 *
 * @param sup Reference to the superclass object.
 * @param k Governor gain (reciprocal of droop) (K) (&gt; 0).
 *        Typical Value = 25.
 * @param k1 Fraction of HP shaft power after first boiler pass (K1).
 *        Typical Value = 0.2.
 * @param k2 Fraction of LP shaft power after first boiler pass (K2).
 *        Typical Value = 0.
 * @param k3 Fraction of HP shaft power after second boiler pass (K3).
 *        Typical Value = 0.3.
 * @param k4 Fraction of LP shaft power after second boiler pass (K4).
 *        Typical Value = 0.
 * @param k5 Fraction of HP shaft power after third boiler pass (K5).
 *        Typical Value = 0.5.
 * @param k6 Fraction of LP shaft power after third boiler pass (K6).
 *        Typical Value = 0.
 * @param k7 Fraction of HP shaft power after fourth boiler pass (K7).
 *        Typical Value = 0.
 * @param k8 Fraction of LP shaft power after fourth boiler pass (K8).
 *        Typical Value = 0.
 * @param mwbase Base for power values (MWbase) (&gt; 0)<i>.</i>
 * @param pmax Maximum valve opening (Pmax) (&gt; Pmin).
 *        Typical Value = 1.
 * @param pmin Minimum valve opening (Pmin) (&gt;= 0).
 *        Typical Value = 0.
 * @param t1 Governor lag time constant (T1).
 *        Typical Value = 0.
 * @param t2 Governor lead time constant (T2).
 *        Typical Value = 0.
 * @param t3 Valve positioner time constant (T3) (&gt; 0).
 *        Typical Value = 0.1.
 * @param t4 Inlet piping/steam bowl time constant (T4).
 *        Typical Value = 0.3.
 * @param t5 Time constant of second boiler pass (T5).
 *        Typical Value = 5.
 * @param t6 Time constant of third boiler pass (T6).
 *        Typical Value = 0.5.
 * @param t7 Time constant of fourth boiler pass (T7).
 *        Typical Value = 0.
 * @param uc Maximum valve closing velocity (Uc) (&lt; 0).
 *        Unit = PU/sec.  Typical Value = -10.
 * @param uo Maximum valve opening velocity (Uo) (&gt; 0).
 *        Unit = PU/sec.  Typical Value = 1.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamIEEE1
(
    override val sup: TurbineGovernorDynamics,
    k: Double,
    k1: Double,
    k2: Double,
    k3: Double,
    k4: Double,
    k5: Double,
    k6: Double,
    k7: Double,
    k8: Double,
    mwbase: Double,
    pmax: Double,
    pmin: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double,
    t7: Double,
    uc: Double,
    uo: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamIEEE1.k>" + k + "</cim:GovSteamIEEE1.k>\n" +
        "\t\t<cim:GovSteamIEEE1.k1>" + k1 + "</cim:GovSteamIEEE1.k1>\n" +
        "\t\t<cim:GovSteamIEEE1.k2>" + k2 + "</cim:GovSteamIEEE1.k2>\n" +
        "\t\t<cim:GovSteamIEEE1.k3>" + k3 + "</cim:GovSteamIEEE1.k3>\n" +
        "\t\t<cim:GovSteamIEEE1.k4>" + k4 + "</cim:GovSteamIEEE1.k4>\n" +
        "\t\t<cim:GovSteamIEEE1.k5>" + k5 + "</cim:GovSteamIEEE1.k5>\n" +
        "\t\t<cim:GovSteamIEEE1.k6>" + k6 + "</cim:GovSteamIEEE1.k6>\n" +
        "\t\t<cim:GovSteamIEEE1.k7>" + k7 + "</cim:GovSteamIEEE1.k7>\n" +
        "\t\t<cim:GovSteamIEEE1.k8>" + k8 + "</cim:GovSteamIEEE1.k8>\n" +
        "\t\t<cim:GovSteamIEEE1.mwbase>" + mwbase + "</cim:GovSteamIEEE1.mwbase>\n" +
        "\t\t<cim:GovSteamIEEE1.pmax>" + pmax + "</cim:GovSteamIEEE1.pmax>\n" +
        "\t\t<cim:GovSteamIEEE1.pmin>" + pmin + "</cim:GovSteamIEEE1.pmin>\n" +
        "\t\t<cim:GovSteamIEEE1.t1>" + t1 + "</cim:GovSteamIEEE1.t1>\n" +
        "\t\t<cim:GovSteamIEEE1.t2>" + t2 + "</cim:GovSteamIEEE1.t2>\n" +
        "\t\t<cim:GovSteamIEEE1.t3>" + t3 + "</cim:GovSteamIEEE1.t3>\n" +
        "\t\t<cim:GovSteamIEEE1.t4>" + t4 + "</cim:GovSteamIEEE1.t4>\n" +
        "\t\t<cim:GovSteamIEEE1.t5>" + t5 + "</cim:GovSteamIEEE1.t5>\n" +
        "\t\t<cim:GovSteamIEEE1.t6>" + t6 + "</cim:GovSteamIEEE1.t6>\n" +
        "\t\t<cim:GovSteamIEEE1.t7>" + t7 + "</cim:GovSteamIEEE1.t7>\n" +
        "\t\t<cim:GovSteamIEEE1.uc>" + uc + "</cim:GovSteamIEEE1.uc>\n" +
        "\t\t<cim:GovSteamIEEE1.uo>" + uo + "</cim:GovSteamIEEE1.uo>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamIEEE1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamIEEE1>"
    }
}

object GovSteamIEEE1
extends
    Parseable[GovSteamIEEE1]
{
    val k = parse_element (element ("""GovSteamIEEE1.k"""))
    val k1 = parse_element (element ("""GovSteamIEEE1.k1"""))
    val k2 = parse_element (element ("""GovSteamIEEE1.k2"""))
    val k3 = parse_element (element ("""GovSteamIEEE1.k3"""))
    val k4 = parse_element (element ("""GovSteamIEEE1.k4"""))
    val k5 = parse_element (element ("""GovSteamIEEE1.k5"""))
    val k6 = parse_element (element ("""GovSteamIEEE1.k6"""))
    val k7 = parse_element (element ("""GovSteamIEEE1.k7"""))
    val k8 = parse_element (element ("""GovSteamIEEE1.k8"""))
    val mwbase = parse_element (element ("""GovSteamIEEE1.mwbase"""))
    val pmax = parse_element (element ("""GovSteamIEEE1.pmax"""))
    val pmin = parse_element (element ("""GovSteamIEEE1.pmin"""))
    val t1 = parse_element (element ("""GovSteamIEEE1.t1"""))
    val t2 = parse_element (element ("""GovSteamIEEE1.t2"""))
    val t3 = parse_element (element ("""GovSteamIEEE1.t3"""))
    val t4 = parse_element (element ("""GovSteamIEEE1.t4"""))
    val t5 = parse_element (element ("""GovSteamIEEE1.t5"""))
    val t6 = parse_element (element ("""GovSteamIEEE1.t6"""))
    val t7 = parse_element (element ("""GovSteamIEEE1.t7"""))
    val uc = parse_element (element ("""GovSteamIEEE1.uc"""))
    val uo = parse_element (element ("""GovSteamIEEE1.uo"""))
    def parse (context: Context): GovSteamIEEE1 =
    {
        GovSteamIEEE1(
            TurbineGovernorDynamics.parse (context),
            toDouble (k (context), context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (k4 (context), context),
            toDouble (k5 (context), context),
            toDouble (k6 (context), context),
            toDouble (k7 (context), context),
            toDouble (k8 (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context),
            toDouble (t7 (context), context),
            toDouble (uc (context), context),
            toDouble (uo (context), context)
        )
    }
}

/**
 * Simplified Steam turbine governor model.
 *
 * @param sup Reference to the superclass object.
 * @param k1 One/per unit regulation (K1).
 * @param k2 Fraction (K2).
 * @param k3 Fraction (K3).
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pmax Upper power limit (Pmax).
 * @param pmin Lower power limit (Pmin).
 * @param t1 Controller lag (T1).
 * @param t2 Controller lead compensation (T2).
 * @param t3 Governor lag (T3) (&gt;0).
 * @param t4 Delay due to steam inlet volumes associated with steam chest and inlet piping (T4).
 * @param t5 Reheater delay including hot and cold leads (T5).
 * @param t6 Delay due to IP-LP turbine, crossover pipes and LP end hoods (T6).
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class GovSteamSGO
(
    override val sup: TurbineGovernorDynamics,
    k1: Double,
    k2: Double,
    k3: Double,
    mwbase: Double,
    pmax: Double,
    pmin: Double,
    t1: Double,
    t2: Double,
    t3: Double,
    t4: Double,
    t5: Double,
    t6: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
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
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:GovSteamSGO.k1>" + k1 + "</cim:GovSteamSGO.k1>\n" +
        "\t\t<cim:GovSteamSGO.k2>" + k2 + "</cim:GovSteamSGO.k2>\n" +
        "\t\t<cim:GovSteamSGO.k3>" + k3 + "</cim:GovSteamSGO.k3>\n" +
        "\t\t<cim:GovSteamSGO.mwbase>" + mwbase + "</cim:GovSteamSGO.mwbase>\n" +
        "\t\t<cim:GovSteamSGO.pmax>" + pmax + "</cim:GovSteamSGO.pmax>\n" +
        "\t\t<cim:GovSteamSGO.pmin>" + pmin + "</cim:GovSteamSGO.pmin>\n" +
        "\t\t<cim:GovSteamSGO.t1>" + t1 + "</cim:GovSteamSGO.t1>\n" +
        "\t\t<cim:GovSteamSGO.t2>" + t2 + "</cim:GovSteamSGO.t2>\n" +
        "\t\t<cim:GovSteamSGO.t3>" + t3 + "</cim:GovSteamSGO.t3>\n" +
        "\t\t<cim:GovSteamSGO.t4>" + t4 + "</cim:GovSteamSGO.t4>\n" +
        "\t\t<cim:GovSteamSGO.t5>" + t5 + "</cim:GovSteamSGO.t5>\n" +
        "\t\t<cim:GovSteamSGO.t6>" + t6 + "</cim:GovSteamSGO.t6>\n"
    }
    override def export: String =
    {
        "\t<cim:GovSteamSGO rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GovSteamSGO>"
    }
}

object GovSteamSGO
extends
    Parseable[GovSteamSGO]
{
    val k1 = parse_element (element ("""GovSteamSGO.k1"""))
    val k2 = parse_element (element ("""GovSteamSGO.k2"""))
    val k3 = parse_element (element ("""GovSteamSGO.k3"""))
    val mwbase = parse_element (element ("""GovSteamSGO.mwbase"""))
    val pmax = parse_element (element ("""GovSteamSGO.pmax"""))
    val pmin = parse_element (element ("""GovSteamSGO.pmin"""))
    val t1 = parse_element (element ("""GovSteamSGO.t1"""))
    val t2 = parse_element (element ("""GovSteamSGO.t2"""))
    val t3 = parse_element (element ("""GovSteamSGO.t3"""))
    val t4 = parse_element (element ("""GovSteamSGO.t4"""))
    val t5 = parse_element (element ("""GovSteamSGO.t5"""))
    val t6 = parse_element (element ("""GovSteamSGO.t6"""))
    def parse (context: Context): GovSteamSGO =
    {
        GovSteamSGO(
            TurbineGovernorDynamics.parse (context),
            toDouble (k1 (context), context),
            toDouble (k2 (context), context),
            toDouble (k3 (context), context),
            toDouble (mwbase (context), context),
            toDouble (pmax (context), context),
            toDouble (pmin (context), context),
            toDouble (t1 (context), context),
            toDouble (t2 (context), context),
            toDouble (t3 (context), context),
            toDouble (t4 (context), context),
            toDouble (t5 (context), context),
            toDouble (t6 (context), context)
        )
    }
}

/**
 * Turbine-governor function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param AsynchronousMachineDynamics Asynchronous machine model with which this turbine-governor model is associated.
 * @param TurbineLoadControllerDynamics Turbine load controller providing input to this turbine-governor.
 * @group TurbineGovernorDynamics
 * @groupname TurbineGovernorDynamics Package TurbineGovernorDynamics
 * @groupdesc TurbineGovernorDynamics The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.  
Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM Dynamics model is a future effort.
 */
case class TurbineGovernorDynamics
(
    override val sup: DynamicsFunctionBlock,
    AsynchronousMachineDynamics: String,
    TurbineLoadControllerDynamics: String
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[TurbineGovernorDynamics] }
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
        (if (null != AsynchronousMachineDynamics) "\t\t<cim:TurbineGovernorDynamics.AsynchronousMachineDynamics rdf:resource=\"#" + AsynchronousMachineDynamics + "\"/>\n" else "") +
        (if (null != TurbineLoadControllerDynamics) "\t\t<cim:TurbineGovernorDynamics.TurbineLoadControllerDynamics rdf:resource=\"#" + TurbineLoadControllerDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TurbineGovernorDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TurbineGovernorDynamics>"
    }
}

object TurbineGovernorDynamics
extends
    Parseable[TurbineGovernorDynamics]
{
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""TurbineGovernorDynamics.AsynchronousMachineDynamics"""))
    val TurbineLoadControllerDynamics = parse_attribute (attribute ("""TurbineGovernorDynamics.TurbineLoadControllerDynamics"""))
    def parse (context: Context): TurbineGovernorDynamics =
    {
        TurbineGovernorDynamics(
            DynamicsFunctionBlock.parse (context),
            AsynchronousMachineDynamics (context),
            TurbineLoadControllerDynamics (context)
        )
    }
}

private[ninecode] object _TurbineGovernorDynamics
{
    def register: List[ClassInfo] =
    {
        List (
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