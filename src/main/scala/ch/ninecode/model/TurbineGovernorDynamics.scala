package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.
 * Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
 */

/**
 * Governor droop signal feedback source.
 */
case class DroopSignalFeedbackKind
(

    override val sup: BasicElement,

    /**
     * Electrical power feedback (connection indicated as 1 in the block diagrams of models, e.g.
     * GovCT1, GovCT2).
     */
    val electricalPower: String,

    /**
     * Fuel valve stroke feedback (true stroke) (connection indicated as 2 in the block diagrams of model, e.g.
     * GovCT1, GovCT2).
     */
    val fuelValveStroke: String,

    /**
     * Governor output feedback (requested stroke) (connection indicated as 3 in the block diagrams of models, e.g.
     * GovCT1, GovCT2).
     */
    val governorOutput: String,

    /**
     * No droop signal feedback, is isochronous governor.
     */
    val none: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DroopSignalFeedbackKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DroopSignalFeedbackKind
extends
    Parseable[DroopSignalFeedbackKind]
{
    val sup = BasicElement.parse _
    val electricalPower = parse_attribute (attribute ("""DroopSignalFeedbackKind.electricalPower"""))_
    val fuelValveStroke = parse_attribute (attribute ("""DroopSignalFeedbackKind.fuelValveStroke"""))_
    val governorOutput = parse_attribute (attribute ("""DroopSignalFeedbackKind.governorOutput"""))_
    val none = parse_attribute (attribute ("""DroopSignalFeedbackKind.none"""))_
    def parse (context: Context): DroopSignalFeedbackKind =
    {
        DroopSignalFeedbackKind(
            sup (context),
            electricalPower (context),
            fuelValveStroke (context),
            governorOutput (context),
            none (context)
        )
    }
}

/**
 * Governor control flag for Francis hydro model.
 */
case class FrancisGovernorControlKind
(

    override val sup: BasicElement,

    /**
     * Electromechanical and electrohydraulic regulator (Cflag=3).
     */
    val electromechanicalElectrohydraulic: String,

    /**
     * Mechanic-hydraulic regulator with transient feedback (Cflag=2).
     */
    val mechanicHydraulicTransientFeedback: String,

    /**
     * Mechanic-hydraulic regulator with tacho-accelerometer (Cflag = 1).
     */
    val mechanicHydrolicTachoAccelerator: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FrancisGovernorControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FrancisGovernorControlKind
extends
    Parseable[FrancisGovernorControlKind]
{
    val sup = BasicElement.parse _
    val electromechanicalElectrohydraulic = parse_attribute (attribute ("""FrancisGovernorControlKind.electromechanicalElectrohydraulic"""))_
    val mechanicHydraulicTransientFeedback = parse_attribute (attribute ("""FrancisGovernorControlKind.mechanicHydraulicTransientFeedback"""))_
    val mechanicHydrolicTachoAccelerator = parse_attribute (attribute ("""FrancisGovernorControlKind.mechanicHydrolicTachoAccelerator"""))_
    def parse (context: Context): FrancisGovernorControlKind =
    {
        FrancisGovernorControlKind(
            sup (context),
            electromechanicalElectrohydraulic (context),
            mechanicHydraulicTransientFeedback (context),
            mechanicHydrolicTachoAccelerator (context)
        )
    }
}

/**
 * General model for any prime mover with a PID governor, used primarily for combustion turbine and combined cycle units.
 * This model can be used to represent a variety of prime movers controlled by PID governors.  It is suitable, for example, for representation of
 */
case class GovCT1
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Acceleration limiter setpoint (Aset).
     * Unit = PU/sec.  Typical Value = 0.01.
     */
    val aset: Double,

    /**
     * Speed governor dead band in per unit speed (db).
     * In the majority of applications, it is recommended that this value be set to zero.  Typical Value = 0.
     */
    val db: Double,

    /**
     * Speed sensitivity coefficient (Dm).
     * Dm can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.  If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical Value = 0.
     */
    val dm: Double,

    /**
     * Acceleration limiter gain (Ka).
     * Typical Value = 10.
     */
    val ka: Double,

    /**
     * Governor derivative gain (Kdgov).
     * Typical Value = 0.
     */
    val kdgov: Double,

    /**
     * Governor integral gain (Kigov).
     * Typical Value = 2.
     */
    val kigov: Double,

    /**
     * Load limiter integral gain for PI controller (Kiload).
     * Typical Value = 0.67.
     */
    val kiload: Double,

    /**
     * Power controller (reset) gain (Kimw).
     * The default value of 0.01 corresponds to a reset time of 100 seconds.  A value of 0.001 corresponds to a relatively slow acting load controller.  Typical Value = 0.01.
     */
    val kimw: Double,

    /**
     * Governor proportional gain (Kpgov).
     * Typical Value = 10.
     */
    val kpgov: Double,

    /**
     * Load limiter proportional gain for PI controller (Kpload).
     * Typical Value = 2.
     */
    val kpload: Double,

    /**
     * Turbine gain (Kturb) (&gt;0).
     * Typical Value = 1.5.
     */
    val kturb: Double,

    /**
     * Load limiter reference value (Ldref).
     * Typical Value = 1.
     */
    val ldref: Double,

    /**
     * Maximum value for speed error signal (maxerr).
     * Typical Value = 0.05.
     */
    val maxerr: Double,

    /**
     * Minimum value for speed error signal (minerr).
     * Typical Value = -0.05.
     */
    val minerr: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Permanent droop (R).
     * Typical Value = 0.04.
     */
    val r: Double,

    /**
     * Minimum valve closing rate (Rclose).
     * Unit = PU/sec.  Typical Value = -0.1.
     */
    val rclose: Double,

    /**
     * Maximum rate of load limit decrease (Rdown).
     * Typical Value = -99.
     */
    val rdown: Double,

    /**
     * Maximum valve opening rate (Ropen).
     * Unit = PU/sec.  Typical Value = 0.10.
     */
    val ropen: Double,

    /**
     * Feedback signal for droop (Rselect).
     * Typical Value = electricalPower.
     */
    val rselect: String,

    /**
     * Maximum rate of load limit increase (Rup).
     * Typical Value = 99.
     */
    val rup: Double,

    /**
     * Acceleration limiter time constant (Ta) (&gt;0).
     * Typical Value = 0.1.
     */
    val ta: Double,

    /**
     * Actuator time constant (Tact).
     * Typical Value = 0.5.
     */
    val tact: Double,

    /**
     * Turbine lag time constant (Tb) (&gt;0).
     * Typical Value = 0.5.
     */
    val tb: Double,

    /**
     * Turbine lead time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Governor derivative controller time constant (Tdgov).
     * Typical Value = 1.
     */
    val tdgov: Double,

    /**
     * Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (Teng).
     * Teng should be zero in all but special cases where this transport delay is of particular concern.  Typical Value = 0.
     */
    val teng: Double,

    /**
     * Load Limiter time constant (Tfload) (&gt;0).
     * Typical Value = 3.
     */
    val tfload: Double,

    /**
     * Electrical power transducer time constant (Tpelec) (&gt;0).
     * Typical Value = 1.
     */
    val tpelec: Double,

    /**
     * Temperature detection lead time constant (Tsa).
     * Typical Value = 4.
     */
    val tsa: Double,

    /**
     * Temperature detection lag time constant (Tsb).
     * Typical Value = 5.
     */
    val tsb: Double,

    /**
     * Maximum valve position limit (Vmax).
     * Typical Value = 1.
     */
    val vmax: Double,

    /**
     * Minimum valve position limit (Vmin).
     * Typical Value = 0.15.
     */
    val vmin: Double,

    /**
     * No load fuel flow (Wfnl).
     * Typical Value = 0.2.
     */
    val wfnl: Double,

    /**
     * Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (Wfspd).
    true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
    false = fuel control system keeps fuel flow independent of engine speed.
     * Typical Value = true.
     */
    val wfspd: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovCT1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovCT1
extends
    Parseable[GovCT1]
{
    val sup = TurbineGovernorDynamics.parse _
    val aset = parse_element (element ("""GovCT1.aset"""))_
    val db = parse_element (element ("""GovCT1.db"""))_
    val dm = parse_element (element ("""GovCT1.dm"""))_
    val ka = parse_element (element ("""GovCT1.ka"""))_
    val kdgov = parse_element (element ("""GovCT1.kdgov"""))_
    val kigov = parse_element (element ("""GovCT1.kigov"""))_
    val kiload = parse_element (element ("""GovCT1.kiload"""))_
    val kimw = parse_element (element ("""GovCT1.kimw"""))_
    val kpgov = parse_element (element ("""GovCT1.kpgov"""))_
    val kpload = parse_element (element ("""GovCT1.kpload"""))_
    val kturb = parse_element (element ("""GovCT1.kturb"""))_
    val ldref = parse_element (element ("""GovCT1.ldref"""))_
    val maxerr = parse_element (element ("""GovCT1.maxerr"""))_
    val minerr = parse_element (element ("""GovCT1.minerr"""))_
    val mwbase = parse_element (element ("""GovCT1.mwbase"""))_
    val r = parse_element (element ("""GovCT1.r"""))_
    val rclose = parse_element (element ("""GovCT1.rclose"""))_
    val rdown = parse_element (element ("""GovCT1.rdown"""))_
    val ropen = parse_element (element ("""GovCT1.ropen"""))_
    val rselect = parse_attribute (attribute ("""GovCT1.rselect"""))_
    val rup = parse_element (element ("""GovCT1.rup"""))_
    val ta = parse_element (element ("""GovCT1.ta"""))_
    val tact = parse_element (element ("""GovCT1.tact"""))_
    val tb = parse_element (element ("""GovCT1.tb"""))_
    val tc = parse_element (element ("""GovCT1.tc"""))_
    val tdgov = parse_element (element ("""GovCT1.tdgov"""))_
    val teng = parse_element (element ("""GovCT1.teng"""))_
    val tfload = parse_element (element ("""GovCT1.tfload"""))_
    val tpelec = parse_element (element ("""GovCT1.tpelec"""))_
    val tsa = parse_element (element ("""GovCT1.tsa"""))_
    val tsb = parse_element (element ("""GovCT1.tsb"""))_
    val vmax = parse_element (element ("""GovCT1.vmax"""))_
    val vmin = parse_element (element ("""GovCT1.vmin"""))_
    val wfnl = parse_element (element ("""GovCT1.wfnl"""))_
    val wfspd = parse_element (element ("""GovCT1.wfspd"""))_
    def parse (context: Context): GovCT1 =
    {
        GovCT1(
            sup (context),
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
 * This model is a modification of the GovCT1<b> </b>model in order to represent the frequency-dependent fuel flow limit of a specific gas turbine manufacturer.
 */
case class GovCT2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Acceleration limiter setpoint (Aset).
     * Unit = PU/sec.  Typical Value = 10.
     */
    val aset: Double,

    /**
     * Speed governor dead band in per unit speed (db).
     * In the majority of applications, it is recommended that this value be set to zero.  Typical Value = 0.
     */
    val db: Double,

    /**
     * Speed sensitivity coefficient (Dm).
     * Dm can represent either the variation of the engine power with the shaft speed or the variation of maximum power capability with shaft speed.  If it is positive it describes the falling slope of the engine speed verses power characteristic as speed increases. A slightly falling characteristic is typical for reciprocating engines and some aero-derivative turbines.  If it is negative the engine power is assumed to be unaffected by the shaft speed, but the maximum permissible fuel flow is taken to fall with falling shaft speed. This is characteristic of single-shaft industrial turbines due to exhaust temperature limits.  Typical Value = 0.
     */
    val dm: Double,

    /**
     * Frequency threshold 1 (Flim1).
     * Unit = Hz.  Typical Value = 59.
     */
    val flim1: Double,

    /**
     * Frequency threshold 10 (Flim10).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim10: Double,

    /**
     * Frequency threshold 2 (Flim2).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim2: Double,

    /**
     * Frequency threshold 3 (Flim3).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim3: Double,

    /**
     * Frequency threshold 4 (Flim4).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim4: Double,

    /**
     * Frequency threshold 5 (Flim5).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim5: Double,

    /**
     * Frequency threshold 6 (Flim6).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim6: Double,

    /**
     * Frequency threshold 7 (Flim7).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim7: Double,

    /**
     * Frequency threshold 8 (Flim8).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim8: Double,

    /**
     * Frequency threshold 9 (Flim9).
     * Unit = Hz.  Typical Value = 0.
     */
    val flim9: Double,

    /**
     * Acceleration limiter Gain (Ka).
     * Typical Value = 10.
     */
    val ka: Double,

    /**
     * Governor derivative gain (Kdgov).
     * Typical Value = 0.
     */
    val kdgov: Double,

    /**
     * Governor integral gain (Kigov).
     * Typical Value = 0.45.
     */
    val kigov: Double,

    /**
     * Load limiter integral gain for PI controller (Kiload).
     * Typical Value = 1.
     */
    val kiload: Double,

    /**
     * Power controller (reset) gain (Kimw).
     * The default value of 0.01 corresponds to a reset time of 100 seconds.  A value of 0.001 corresponds to a relatively slow acting load controller.  Typical Value = 0.
     */
    val kimw: Double,

    /**
     * Governor proportional gain (Kpgov).
     * Typical Value = 4.
     */
    val kpgov: Double,

    /**
     * Load limiter proportional gain for PI controller (Kpload).
     * Typical Value = 1.
     */
    val kpload: Double,

    /**
     * Turbine gain (Kturb).
     * Typical Value = 1.9168.
     */
    val kturb: Double,

    /**
     * Load limiter reference value (Ldref).
     * Typical Value = 1.
     */
    val ldref: Double,

    /**
     * Maximum value for speed error signal (Maxerr).
     * Typical Value = 1.
     */
    val maxerr: Double,

    /**
     * Minimum value for speed error signal (Minerr).
     * Typical Value = -1.
     */
    val minerr: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Power limit 1 (Plim1).
     * Typical Value = 0.8325.
     */
    val plim1: Double,

    /**
     * Power limit 10 (Plim10).
     * Typical Value = 0.
     */
    val plim10: Double,

    /**
     * Power limit 2 (Plim2).
     * Typical Value = 0.
     */
    val plim2: Double,

    /**
     * Power limit 3 (Plim3).
     * Typical Value = 0.
     */
    val plim3: Double,

    /**
     * Power limit 4 (Plim4).
     * Typical Value = 0.
     */
    val plim4: Double,

    /**
     * Power limit 5 (Plim5).
     * Typical Value = 0.
     */
    val plim5: Double,

    /**
     * Power limit 6 (Plim6).
     * Typical Value = 0.
     */
    val plim6: Double,

    /**
     * Power limit 7 (Plim7).
     * Typical Value = 0.
     */
    val plim7: Double,

    /**
     * Power limit 8 (Plim8).
     * Typical Value = 0.
     */
    val plim8: Double,

    /**
     * Power Limit 9 (Plim9).
     * Typical Value = 0.
     */
    val plim9: Double,

    /**
     * Ramp rate for frequency-dependent power limit (Prate).
     * Typical Value = 0.017.
     */
    val prate: Double,

    /**
     * Permanent droop (R).
     * Typical Value = 0.05.
     */
    val r: Double,

    /**
     * Minimum valve closing rate (Rclose).
     * Unit = PU/sec.  Typical Value = -99.
     */
    val rclose: Double,

    /**
     * Maximum rate of load limit decrease (Rdown).
     * Typical Value = -99.
     */
    val rdown: Double,

    /**
     * Maximum valve opening rate (Ropen).
     * Unit = PU/sec.  Typical Value = 99.
     */
    val ropen: Double,

    /**
     * Feedback signal for droop (Rselect).
     * Typical Value = electricalPower.
     */
    val rselect: String,

    /**
     * Maximum rate of load limit increase (Rup).
     * Typical Value = 99.
     */
    val rup: Double,

    /**
     * Acceleration limiter time constant (Ta).
     * Typical Value = 1.
     */
    val ta: Double,

    /**
     * Actuator time constant (Tact).
     * Typical Value = 0.4.
     */
    val tact: Double,

    /**
     * Turbine lag time constant (Tb).
     * Typical Value = 0.1.
     */
    val tb: Double,

    /**
     * Turbine lead time constant (Tc).
     * Typical Value = 0.
     */
    val tc: Double,

    /**
     * Governor derivative controller time constant (Tdgov).
     * Typical Value = 1.
     */
    val tdgov: Double,

    /**
     * Transport time delay for diesel engine used in representing diesel engines where there is a small but measurable transport delay between a change in fuel flow setting and the development of torque (Teng).
     * Teng should be zero in all but special cases where this transport delay is of particular concern.  Typical Value = 0.
     */
    val teng: Double,

    /**
     * Load Limiter time constant (Tfload).
     * Typical Value = 3.
     */
    val tfload: Double,

    /**
     * Electrical power transducer time constant (Tpelec).
     * Typical Value = 2.5.
     */
    val tpelec: Double,

    /**
     * Temperature detection lead time constant (Tsa).
     * Typical Value = 0.
     */
    val tsa: Double,

    /**
     * Temperature detection lag time constant (Tsb).
     * Typical Value = 50.
     */
    val tsb: Double,

    /**
     * Maximum valve position limit (Vmax).
     * Typical Value = 1.
     */
    val vmax: Double,

    /**
     * Minimum valve position limit (Vmin).
     * Typical Value = 0.175.
     */
    val vmin: Double,

    /**
     * No load fuel flow (Wfnl).
     * Typical Value = 0.187.
     */
    val wfnl: Double,

    /**
     * Switch for fuel source characteristic to recognize that fuel flow, for a given fuel valve stroke, can be proportional to engine speed (Wfspd).
    true = fuel flow proportional to speed (for some gas turbines and diesel engines with positive displacement fuel injectors)
    false = fuel control system keeps fuel flow independent of engine speed.
     * Typical Value = false.
     */
    val wfspd: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovCT2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovCT2
extends
    Parseable[GovCT2]
{
    val sup = TurbineGovernorDynamics.parse _
    val aset = parse_element (element ("""GovCT2.aset"""))_
    val db = parse_element (element ("""GovCT2.db"""))_
    val dm = parse_element (element ("""GovCT2.dm"""))_
    val flim1 = parse_element (element ("""GovCT2.flim1"""))_
    val flim10 = parse_element (element ("""GovCT2.flim10"""))_
    val flim2 = parse_element (element ("""GovCT2.flim2"""))_
    val flim3 = parse_element (element ("""GovCT2.flim3"""))_
    val flim4 = parse_element (element ("""GovCT2.flim4"""))_
    val flim5 = parse_element (element ("""GovCT2.flim5"""))_
    val flim6 = parse_element (element ("""GovCT2.flim6"""))_
    val flim7 = parse_element (element ("""GovCT2.flim7"""))_
    val flim8 = parse_element (element ("""GovCT2.flim8"""))_
    val flim9 = parse_element (element ("""GovCT2.flim9"""))_
    val ka = parse_element (element ("""GovCT2.ka"""))_
    val kdgov = parse_element (element ("""GovCT2.kdgov"""))_
    val kigov = parse_element (element ("""GovCT2.kigov"""))_
    val kiload = parse_element (element ("""GovCT2.kiload"""))_
    val kimw = parse_element (element ("""GovCT2.kimw"""))_
    val kpgov = parse_element (element ("""GovCT2.kpgov"""))_
    val kpload = parse_element (element ("""GovCT2.kpload"""))_
    val kturb = parse_element (element ("""GovCT2.kturb"""))_
    val ldref = parse_element (element ("""GovCT2.ldref"""))_
    val maxerr = parse_element (element ("""GovCT2.maxerr"""))_
    val minerr = parse_element (element ("""GovCT2.minerr"""))_
    val mwbase = parse_element (element ("""GovCT2.mwbase"""))_
    val plim1 = parse_element (element ("""GovCT2.plim1"""))_
    val plim10 = parse_element (element ("""GovCT2.plim10"""))_
    val plim2 = parse_element (element ("""GovCT2.plim2"""))_
    val plim3 = parse_element (element ("""GovCT2.plim3"""))_
    val plim4 = parse_element (element ("""GovCT2.plim4"""))_
    val plim5 = parse_element (element ("""GovCT2.plim5"""))_
    val plim6 = parse_element (element ("""GovCT2.plim6"""))_
    val plim7 = parse_element (element ("""GovCT2.plim7"""))_
    val plim8 = parse_element (element ("""GovCT2.plim8"""))_
    val plim9 = parse_element (element ("""GovCT2.plim9"""))_
    val prate = parse_element (element ("""GovCT2.prate"""))_
    val r = parse_element (element ("""GovCT2.r"""))_
    val rclose = parse_element (element ("""GovCT2.rclose"""))_
    val rdown = parse_element (element ("""GovCT2.rdown"""))_
    val ropen = parse_element (element ("""GovCT2.ropen"""))_
    val rselect = parse_attribute (attribute ("""GovCT2.rselect"""))_
    val rup = parse_element (element ("""GovCT2.rup"""))_
    val ta = parse_element (element ("""GovCT2.ta"""))_
    val tact = parse_element (element ("""GovCT2.tact"""))_
    val tb = parse_element (element ("""GovCT2.tb"""))_
    val tc = parse_element (element ("""GovCT2.tc"""))_
    val tdgov = parse_element (element ("""GovCT2.tdgov"""))_
    val teng = parse_element (element ("""GovCT2.teng"""))_
    val tfload = parse_element (element ("""GovCT2.tfload"""))_
    val tpelec = parse_element (element ("""GovCT2.tpelec"""))_
    val tsa = parse_element (element ("""GovCT2.tsa"""))_
    val tsb = parse_element (element ("""GovCT2.tsb"""))_
    val vmax = parse_element (element ("""GovCT2.vmax"""))_
    val vmin = parse_element (element ("""GovCT2.vmin"""))_
    val wfnl = parse_element (element ("""GovCT2.wfnl"""))_
    val wfspd = parse_element (element ("""GovCT2.wfspd"""))_
    def parse (context: Context): GovCT2 =
    {
        GovCT2(
            sup (context),
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
 */
case class GovGAST
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Ambient temperature load limit (Load Limit).
     * Typical Value = 1.
     */
    val at: Double,

    /**
     * Turbine damping factor (Dturb).
     * Typical Value = 0.18.
     */
    val dturb: Double,

    /**
     * Temperature limiter gain (Kt).
     * Typical Value = 3.
     */
    val kt: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     */
    val mwbase: Double,

    /**
     * Permanent droop (R).
     * Typical Value = 0.04.
     */
    val r: Double,

    /**
     * Governor mechanism time constant (T1).
     * T1 represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.  Typical Value = 0.5.
     */
    val t1: Double,

    /**
     * Turbine power time constant (T2).
     * T2 represents delay due to internal energy storage of the gas turbine engine. T2 can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of a the free power turbine of an aero-derivative unit, for example.  Typical Value = 0.5.
     */
    val t2: Double,

    /**
     * Turbine exhaust temperature time constant (T3).
     * Typical Value = 3.
     */
    val t3: Double,

    /**
     * Maximum turbine power, PU of MWbase (Vmax).
     * Typical Value = 1.
     */
    val vmax: Double,

    /**
     * Minimum turbine power, PU of MWbase (Vmin).
     * Typical Value = 0.
     */
    val vmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGAST]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGAST
extends
    Parseable[GovGAST]
{
    val sup = TurbineGovernorDynamics.parse _
    val at = parse_element (element ("""GovGAST.at"""))_
    val dturb = parse_element (element ("""GovGAST.dturb"""))_
    val kt = parse_element (element ("""GovGAST.kt"""))_
    val mwbase = parse_element (element ("""GovGAST.mwbase"""))_
    val r = parse_element (element ("""GovGAST.r"""))_
    val t1 = parse_element (element ("""GovGAST.t1"""))_
    val t2 = parse_element (element ("""GovGAST.t2"""))_
    val t3 = parse_element (element ("""GovGAST.t3"""))_
    val vmax = parse_element (element ("""GovGAST.vmax"""))_
    val vmin = parse_element (element ("""GovGAST.vmin"""))_
    def parse (context: Context): GovGAST =
    {
        GovGAST(
            sup (context),
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
 */
case class GovGAST1
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine power time constant numerator scale factor (a).
     * Typical Value = 0.8.
     */
    val a: Double,

    /**
     * Turbine power time constant denominator scale factor (b).
     * Typical Value = 1.
     */
    val b: Double,

    /**
     * Intentional dead-band width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Fuel flow at zero power output (Fidle).
     * Typical Value = 0.18.
     */
    val fidle: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2,PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Governor gain (Ka).
     * Typical Value = 0.
     */
    val ka: Double,

    /**
     * Temperature limiter gain (Kt).
     * Typical Value = 3.
     */
    val kt: Double,

    /**
     * Ambient temperature load limit (Lmax).
     * Lmax is the turbine power output corresponding to the limiting exhaust gas temperature.  Typical Value = 1.
     */
    val lmax: Double,

    /**
     * Valve position change allowed at fast rate (Loadinc).
     * Typical Value = 0.05.
     */
    val loadinc: Double,

    /**
     * Maximum long term fuel valve opening rate (Ltrate).
     * Typical Value = 0.02.
     */
    val ltrate: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Permanent droop (R).
     * Typical Value = 0.04.
     */
    val r: Double,

    /**
     * Maximum fuel valve opening rate (Rmax).
     * Unit = PU/sec.  Typical Value = 1.
     */
    val rmax: Double,

    /**
     * Governor mechanism time constant (T1).
     * T1 represents the natural valve positioning time constant of the governor for small disturbances, as seen when rate limiting is not in effect.  Typical Value = 0.5.
     */
    val t1: Double,

    /**
     * Turbine power time constant (T2).
     * T2 represents delay due to internal energy storage of the gas turbine engine. T2 can be used to give a rough approximation to the delay associated with acceleration of the compressor spool of a multi-shaft engine, or with the compressibility of gas in the plenum of the free power turbine of an aero-derivative unit, for example.  Typical Value = 0.5.
     */
    val t2: Double,

    /**
     * Turbine exhaust temperature time constant (T3).
     * T3 represents delay in the exhaust temperature and load limiting system. Typical Value = 3.
     */
    val t3: Double,

    /**
     * Governor lead time constant (T4).
     * Typical Value = 0.
     */
    val t4: Double,

    /**
     * Governor lag time constant (T5).
     * Typical Value = 0.
     */
    val t5: Double,

    /**
     * Valve position averaging time constant (Tltr).
     * Typical Value = 10.
     */
    val tltr: Double,

    /**
     * Maximum turbine power, PU of MWbase (Vmax).
     * Typical Value = 1.
     */
    val vmax: Double,

    /**
     * Minimum turbine power, PU of MWbase (Vmin).
     * Typical Value = 0.
     */
    val vmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGAST1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGAST1
extends
    Parseable[GovGAST1]
{
    val sup = TurbineGovernorDynamics.parse _
    val a = parse_element (element ("""GovGAST1.a"""))_
    val b = parse_element (element ("""GovGAST1.b"""))_
    val db1 = parse_element (element ("""GovGAST1.db1"""))_
    val db2 = parse_element (element ("""GovGAST1.db2"""))_
    val eps = parse_element (element ("""GovGAST1.eps"""))_
    val fidle = parse_element (element ("""GovGAST1.fidle"""))_
    val gv1 = parse_element (element ("""GovGAST1.gv1"""))_
    val gv2 = parse_element (element ("""GovGAST1.gv2"""))_
    val gv3 = parse_element (element ("""GovGAST1.gv3"""))_
    val gv4 = parse_element (element ("""GovGAST1.gv4"""))_
    val gv5 = parse_element (element ("""GovGAST1.gv5"""))_
    val gv6 = parse_element (element ("""GovGAST1.gv6"""))_
    val ka = parse_element (element ("""GovGAST1.ka"""))_
    val kt = parse_element (element ("""GovGAST1.kt"""))_
    val lmax = parse_element (element ("""GovGAST1.lmax"""))_
    val loadinc = parse_element (element ("""GovGAST1.loadinc"""))_
    val ltrate = parse_element (element ("""GovGAST1.ltrate"""))_
    val mwbase = parse_element (element ("""GovGAST1.mwbase"""))_
    val pgv1 = parse_element (element ("""GovGAST1.pgv1"""))_
    val pgv2 = parse_element (element ("""GovGAST1.pgv2"""))_
    val pgv3 = parse_element (element ("""GovGAST1.pgv3"""))_
    val pgv4 = parse_element (element ("""GovGAST1.pgv4"""))_
    val pgv5 = parse_element (element ("""GovGAST1.pgv5"""))_
    val pgv6 = parse_element (element ("""GovGAST1.pgv6"""))_
    val r = parse_element (element ("""GovGAST1.r"""))_
    val rmax = parse_element (element ("""GovGAST1.rmax"""))_
    val t1 = parse_element (element ("""GovGAST1.t1"""))_
    val t2 = parse_element (element ("""GovGAST1.t2"""))_
    val t3 = parse_element (element ("""GovGAST1.t3"""))_
    val t4 = parse_element (element ("""GovGAST1.t4"""))_
    val t5 = parse_element (element ("""GovGAST1.t5"""))_
    val tltr = parse_element (element ("""GovGAST1.tltr"""))_
    val vmax = parse_element (element ("""GovGAST1.vmax"""))_
    val vmin = parse_element (element ("""GovGAST1.vmin"""))_
    def parse (context: Context): GovGAST1 =
    {
        GovGAST1(
            sup (context),
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
 */
case class GovGAST2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Valve positioner (A).
     */
    val a: Double,

    /**
     * Exhaust temperature Parameter (Af1).
     * Unit = per unit temperature.  Based on temperature in degrees C.
     */
    val af1: Double,

    /**
     * Coefficient equal to 0.5(1-speed) (Af2).
     */
    val af2: Double,

    /**
     * Valve positioner (B).
     */
    val b: Double,

    /**
     * (Bf1).
     * Bf1 = E(1-w) where E (speed sensitivity coefficient) is 0.55 to 0.65 x Tr.  Unit = per unit temperature.  Based on temperature in degrees C.
     */
    val bf1: Double,

    /**
     * Turbine Torque Coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (Bf2).
     */
    val bf2: Double,

    /**
     * Valve positioner (C).
     */
    val c: Double,

    /**
     * Coefficient defining fuel flow where power output is 0% (Cf2).
     * Synchronous but no output.  Typically 0.23 x K<sub>hhv</sub> (23% fuel flow).
     */
    val cf2: Double,

    /**
     * Combustion reaction time delay (Ecr).
     */
    val ecr: Double,

    /**
     * Turbine and exhaust delay (Etd).
     */
    val etd: Double,

    /**
     * Ratio of Fuel Adjustment (K3).
     */
    val k3: Double,

    /**
     * Gain of radiation shield (K4).
     */
    val k4: Double,

    /**
     * Gain of radiation shield (K5).
     */
    val k5: Double,

    /**
     * Minimum fuel flow (K6).
     */
    val k6: Double,

    /**
     * Fuel system feedback (Kf).
     */
    val kf: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Fuel Control Time Constant (T).
     */
    val t: Double,

    /**
     * Radiation shield time constant (T3).
     */
    val t3: Double,

    /**
     * Thermocouple time constant (T4).
     */
    val t4: Double,

    /**
     * Temperature control time constant (T5).
     */
    val t5: Double,

    /**
     * Temperature control (Tc).
     * Unit = �F or �C depending on constants Af1 and Bf1.
     */
    val tc: Double,

    /**
     * Compressor discharge time constant (Tcd).
     */
    val tcd: Double,

    /**
     * Fuel system time constant (Tf).
     */
    val tf: Double,

    /**
     * Maximum Turbine limit (Tmax).
     */
    val tmax: Double,

    /**
     * Minimum Turbine limit (Tmin).
     */
    val tmin: Double,

    /**
     * Rated temperature (Tr).
     * Unit = �C depending on parameters Af1 and Bf1.
     */
    val tr: Double,

    /**
     * Turbine rating (Trate).
     * Unit = MW.
     */
    val trate: Double,

    /**
     * Temperature controller integration rate (Tt).
     */
    val tt: Double,

    /**
     * Governor gain (1/droop) on turbine rating (W).
     */
    val w: Double,

    /**
     * Governor lead time constant (X).
     */
    val x: Double,

    /**
     * Governor lag time constant (Y) (&gt;0).
     */
    val y: Double,

    /**
     * Governor mode (Z).
    true = Droop
     * false = ISO.
     */
    val z: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGAST2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGAST2
extends
    Parseable[GovGAST2]
{
    val sup = TurbineGovernorDynamics.parse _
    val a = parse_element (element ("""GovGAST2.a"""))_
    val af1 = parse_element (element ("""GovGAST2.af1"""))_
    val af2 = parse_element (element ("""GovGAST2.af2"""))_
    val b = parse_element (element ("""GovGAST2.b"""))_
    val bf1 = parse_element (element ("""GovGAST2.bf1"""))_
    val bf2 = parse_element (element ("""GovGAST2.bf2"""))_
    val c = parse_element (element ("""GovGAST2.c"""))_
    val cf2 = parse_element (element ("""GovGAST2.cf2"""))_
    val ecr = parse_element (element ("""GovGAST2.ecr"""))_
    val etd = parse_element (element ("""GovGAST2.etd"""))_
    val k3 = parse_element (element ("""GovGAST2.k3"""))_
    val k4 = parse_element (element ("""GovGAST2.k4"""))_
    val k5 = parse_element (element ("""GovGAST2.k5"""))_
    val k6 = parse_element (element ("""GovGAST2.k6"""))_
    val kf = parse_element (element ("""GovGAST2.kf"""))_
    val mwbase = parse_element (element ("""GovGAST2.mwbase"""))_
    val t = parse_element (element ("""GovGAST2.t"""))_
    val t3 = parse_element (element ("""GovGAST2.t3"""))_
    val t4 = parse_element (element ("""GovGAST2.t4"""))_
    val t5 = parse_element (element ("""GovGAST2.t5"""))_
    val tc = parse_element (element ("""GovGAST2.tc"""))_
    val tcd = parse_element (element ("""GovGAST2.tcd"""))_
    val tf = parse_element (element ("""GovGAST2.tf"""))_
    val tmax = parse_element (element ("""GovGAST2.tmax"""))_
    val tmin = parse_element (element ("""GovGAST2.tmin"""))_
    val tr = parse_element (element ("""GovGAST2.tr"""))_
    val trate = parse_element (element ("""GovGAST2.trate"""))_
    val tt = parse_element (element ("""GovGAST2.tt"""))_
    val w = parse_element (element ("""GovGAST2.w"""))_
    val x = parse_element (element ("""GovGAST2.x"""))_
    val y = parse_element (element ("""GovGAST2.y"""))_
    val z = parse_element (element ("""GovGAST2.z"""))_
    def parse (context: Context): GovGAST2 =
    {
        GovGAST2(
            sup (context),
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
 */
case class GovGAST3
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Acceleration limit set-point (Bca).
     * Unit = 1/s.  Typical Value = 0.01.
     */
    val bca: Double,

    /**
     * Droop (bp).
     * Typical Value = 0.05.
     */
    val bp: Double,

    /**
     * Exhaust temperature variation due to fuel flow increasing from 0 to 1 PU (deltaTc).
     * Typical Value = 390.
     */
    val dtc: Double,

    /**
     * Minimum fuel flow (Ka).
     * Typical Value = 0.23.
     */
    val ka: Double,

    /**
     * Fuel system feedback (K<sub>AC</sub>).
     * Typical Value = 0.
     */
    val kac: Double,

    /**
     * Acceleration control integral gain (Kca).
     * Unit = 1/s.  Typical Value = 100.
     */
    val kca: Double,

    /**
     * Gain of radiation shield (Ksi).
     * Typical Value = 0.8.
     */
    val ksi: Double,

    /**
     * Coefficient of transfer function of fuel valve positioner (Ky).
     * Typical Value = 1.
     */
    val ky: Double,

    /**
     * Fuel flow maximum negative error value (MN<sub>EF</sub>).
     * Typical Value = -0.05.
     */
    val mnef: Double,

    /**
     * Fuel flow maximum positive error value (MX<sub>EF</sub>).
     * Typical Value = 0.05.
     */
    val mxef: Double,

    /**
     * Minimum fuel flow (RCMN).
     * Typical Value = -0.1.
     */
    val rcmn: Double,

    /**
     * Maximum fuel flow (RCMX).
     * Typical Value = 1.
     */
    val rcmx: Double,

    /**
     * Fuel control time constant (Tac).
     * Typical Value = 0.1.
     */
    val tac: Double,

    /**
     * Compressor discharge volume time constant (Tc).
     * Typical Value = 0.2.
     */
    val tc: Double,

    /**
     * Temperature controller derivative gain (Td).
     * Typical Value = 3.3.
     */
    val td: Double,

    /**
     * Turbine rated exhaust temperature correspondent to Pm=1 PU (Tfen).
     * Typical Value = 540.
     */
    val tfen: Double,

    /**
     * Time constant of speed governor (Tg).
     * Typical Value = 0.05.
     */
    val tg: Double,

    /**
     * Time constant of radiation shield (Tsi).
     * Typical Value = 15.
     */
    val tsi: Double,

    /**
     * Temperature controller integration rate (Tt).
     * Typical Value = 250.
     */
    val tt: Double,

    /**
     * Time constant of thermocouple (Ttc).
     * Typical Value = 2.5.
     */
    val ttc: Double,

    /**
     * Time constant of fuel valve positioner (Ty).
     * Typical Value = 0.2.
     */
    val ty: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGAST3]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGAST3
extends
    Parseable[GovGAST3]
{
    val sup = TurbineGovernorDynamics.parse _
    val bca = parse_element (element ("""GovGAST3.bca"""))_
    val bp = parse_element (element ("""GovGAST3.bp"""))_
    val dtc = parse_element (element ("""GovGAST3.dtc"""))_
    val ka = parse_element (element ("""GovGAST3.ka"""))_
    val kac = parse_element (element ("""GovGAST3.kac"""))_
    val kca = parse_element (element ("""GovGAST3.kca"""))_
    val ksi = parse_element (element ("""GovGAST3.ksi"""))_
    val ky = parse_element (element ("""GovGAST3.ky"""))_
    val mnef = parse_element (element ("""GovGAST3.mnef"""))_
    val mxef = parse_element (element ("""GovGAST3.mxef"""))_
    val rcmn = parse_element (element ("""GovGAST3.rcmn"""))_
    val rcmx = parse_element (element ("""GovGAST3.rcmx"""))_
    val tac = parse_element (element ("""GovGAST3.tac"""))_
    val tc = parse_element (element ("""GovGAST3.tc"""))_
    val td = parse_element (element ("""GovGAST3.td"""))_
    val tfen = parse_element (element ("""GovGAST3.tfen"""))_
    val tg = parse_element (element ("""GovGAST3.tg"""))_
    val tsi = parse_element (element ("""GovGAST3.tsi"""))_
    val tt = parse_element (element ("""GovGAST3.tt"""))_
    val ttc = parse_element (element ("""GovGAST3.ttc"""))_
    val ty = parse_element (element ("""GovGAST3.ty"""))_
    def parse (context: Context): GovGAST3 =
    {
        GovGAST3(
            sup (context),
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
 */
case class GovGAST4
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Droop (bp).
     * Typical Value = 0.05.
     */
    val bp: Double,

    /**
     * Compressor gain (K<sub>tm</sub>).
     * Typical Value = 0.
     */
    val ktm: Double,

    /**
     * Fuel flow maximum negative error value (MN<sub>EF</sub>).
     * Typical Value = -0.05.
     */
    val mnef: Double,

    /**
     * Fuel flow maximum positive error value (MX<sub>EF</sub>).
     * Typical Value = 0.05.
     */
    val mxef: Double,

    /**
     * Minimum valve opening (RYMN).
     * Typical Value = 0.
     */
    val rymn: Double,

    /**
     * Maximum valve opening (RYMX).
     * Typical Value = 1.1.
     */
    val rymx: Double,

    /**
     * Maximum gate opening velocity (T<sub>A</sub>).
     * Typical Value = 3.
     */
    val ta: Double,

    /**
     * Maximum gate closing velocity (T<sub>c</sub>).
     * Typical Value = 0.5.
     */
    val tc: Double,

    /**
     * Fuel control time constant (T<sub>cm</sub>).
     * Typical Value = 0.1.
     */
    val tcm: Double,

    /**
     * Compressor discharge volume time constant (T<sub>m</sub>).
     * Typical Value = 0.2.
     */
    val tm: Double,

    /**
     * Time constant of fuel valve positioner (T<sub>y</sub>).
     * Typical Value = 0.1.
     */
    val tv: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGAST4]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGAST4
extends
    Parseable[GovGAST4]
{
    val sup = TurbineGovernorDynamics.parse _
    val bp = parse_element (element ("""GovGAST4.bp"""))_
    val ktm = parse_element (element ("""GovGAST4.ktm"""))_
    val mnef = parse_element (element ("""GovGAST4.mnef"""))_
    val mxef = parse_element (element ("""GovGAST4.mxef"""))_
    val rymn = parse_element (element ("""GovGAST4.rymn"""))_
    val rymx = parse_element (element ("""GovGAST4.rymx"""))_
    val ta = parse_element (element ("""GovGAST4.ta"""))_
    val tc = parse_element (element ("""GovGAST4.tc"""))_
    val tcm = parse_element (element ("""GovGAST4.tcm"""))_
    val tm = parse_element (element ("""GovGAST4.tm"""))_
    val tv = parse_element (element ("""GovGAST4.tv"""))_
    def parse (context: Context): GovGAST4 =
    {
        GovGAST4(
            sup (context),
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
 */
case class GovGASTWD
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Valve positioner (<i>A</i>).
     */
    val a: Double,

    /**
     * Exhaust temperature Parameter (Af1).
     */
    val af1: Double,

    /**
     * Coefficient equal to 0.5(1-speed) (Af2).
     */
    val af2: Double,

    /**
     * Valve positioner (<i>B</i>).
     */
    val b: Double,

    /**
     * (Bf1).
     * Bf1 = E(1-w) where E (speed sensitivity coefficient) is 0.55 to 0.65 x Tr.
     */
    val bf1: Double,

    /**
     * Turbine Torque Coefficient K<sub>hhv</sub> (depends on heating value of fuel stream in combustion chamber) (Bf2).
     */
    val bf2: Double,

    /**
     * Valve positioner (<i>C</i>).
     */
    val c: Double,

    /**
     * Coefficient defining fuel flow where power output is 0% (Cf2).
     * Synchronous but no output.  Typically 0.23 x K<sub>hhv </sub>(23% fuel flow).
     */
    val cf2: Double,

    /**
     * Combustion reaction time delay (Ecr).
     */
    val ecr: Double,

    /**
     * Turbine and exhaust delay (Etd).
     */
    val etd: Double,

    /**
     * Ratio of Fuel Adjustment (K3).
     */
    val k3: Double,

    /**
     * Gain of radiation shield (K4).
     */
    val k4: Double,

    /**
     * Gain of radiation shield (K5).
     */
    val k5: Double,

    /**
     * Minimum fuel flow (K6).
     */
    val k6: Double,

    /**
     * Drop Governor Gain (Kd).
     */
    val kd: Double,

    /**
     * (Kdroop).
     */
    val kdroop: Double,

    /**
     * Fuel system feedback (Kf).
     */
    val kf: Double,

    /**
     * Isochronous Governor Gain (Ki).
     */
    val ki: Double,

    /**
     * PID Proportional gain (Kp).
     */
    val kp: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Fuel Control Time Constant (T).
     */
    val t: Double,

    /**
     * Radiation shield time constant (T3).
     */
    val t3: Double,

    /**
     * Thermocouple time constant (T4).
     */
    val t4: Double,

    /**
     * Temperature control time constant (T5).
     */
    val t5: Double,

    /**
     * Temperature control (Tc).
     */
    val tc: Double,

    /**
     * Compressor discharge time constant (Tcd).
     */
    val tcd: Double,

    /**
     * Power transducer time constant (Td).
     */
    val td: Double,

    /**
     * Fuel system time constant (Tf).
     */
    val tf: Double,

    /**
     * Maximum Turbine limit (Tmax).
     */
    val tmax: Double,

    /**
     * Minimum Turbine limit (Tmin).
     */
    val tmin: Double,

    /**
     * Rated temperature (Tr).
     */
    val tr: Double,

    /**
     * Turbine rating (Trate).
     * Unit = MW.
     */
    val trate: Double,

    /**
     * Temperature controller integration rate (Tt).
     */
    val tt: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovGASTWD]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovGASTWD
extends
    Parseable[GovGASTWD]
{
    val sup = TurbineGovernorDynamics.parse _
    val a = parse_element (element ("""GovGASTWD.a"""))_
    val af1 = parse_element (element ("""GovGASTWD.af1"""))_
    val af2 = parse_element (element ("""GovGASTWD.af2"""))_
    val b = parse_element (element ("""GovGASTWD.b"""))_
    val bf1 = parse_element (element ("""GovGASTWD.bf1"""))_
    val bf2 = parse_element (element ("""GovGASTWD.bf2"""))_
    val c = parse_element (element ("""GovGASTWD.c"""))_
    val cf2 = parse_element (element ("""GovGASTWD.cf2"""))_
    val ecr = parse_element (element ("""GovGASTWD.ecr"""))_
    val etd = parse_element (element ("""GovGASTWD.etd"""))_
    val k3 = parse_element (element ("""GovGASTWD.k3"""))_
    val k4 = parse_element (element ("""GovGASTWD.k4"""))_
    val k5 = parse_element (element ("""GovGASTWD.k5"""))_
    val k6 = parse_element (element ("""GovGASTWD.k6"""))_
    val kd = parse_element (element ("""GovGASTWD.kd"""))_
    val kdroop = parse_element (element ("""GovGASTWD.kdroop"""))_
    val kf = parse_element (element ("""GovGASTWD.kf"""))_
    val ki = parse_element (element ("""GovGASTWD.ki"""))_
    val kp = parse_element (element ("""GovGASTWD.kp"""))_
    val mwbase = parse_element (element ("""GovGASTWD.mwbase"""))_
    val t = parse_element (element ("""GovGASTWD.t"""))_
    val t3 = parse_element (element ("""GovGASTWD.t3"""))_
    val t4 = parse_element (element ("""GovGASTWD.t4"""))_
    val t5 = parse_element (element ("""GovGASTWD.t5"""))_
    val tc = parse_element (element ("""GovGASTWD.tc"""))_
    val tcd = parse_element (element ("""GovGASTWD.tcd"""))_
    val td = parse_element (element ("""GovGASTWD.td"""))_
    val tf = parse_element (element ("""GovGASTWD.tf"""))_
    val tmax = parse_element (element ("""GovGASTWD.tmax"""))_
    val tmin = parse_element (element ("""GovGASTWD.tmin"""))_
    val tr = parse_element (element ("""GovGASTWD.tr"""))_
    val trate = parse_element (element ("""GovGASTWD.trate"""))_
    val tt = parse_element (element ("""GovGASTWD.tt"""))_
    def parse (context: Context): GovGASTWD =
    {
        GovGASTWD(
            sup (context),
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
 */
case class GovHydro1
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine gain (At) (&gt;0).
     * Typical Value = 1.2.
     */
    val at: Double,

    /**
     * Turbine damping factor (Dturb) (&gt;=0).
     * Typical Value = 0.5.
     */
    val dturb: Double,

    /**
     * Maximum gate opening (Gmax) (&gt;0).
     * Typical Value = 1.
     */
    val gmax: Double,

    /**
     * Minimum gate opening (Gmin) (&gt;=0).
     * Typical Value = 0.
     */
    val gmin: Double,

    /**
     * Turbine nominal head (hdam).
     * Typical Value = 1.
     */
    val hdam: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * No-load flow at nominal head (qnl) (&gt;=0).
     * Typical Value = 0.08.
     */
    val qnl: Double,

    /**
     * Permanent droop (R) (&gt;0).
     * Typical Value = 0.04.
     */
    val rperm: Double,

    /**
     * Temporary droop (r) (&gt;R).
     * Typical Value = 0.3.
     */
    val rtemp: Double,

    /**
     * Filter time constant (<i>Tf</i>) (&gt;0).
     * Typical Value = 0.05.
     */
    val tf: Double,

    /**
     * Gate servo time constant (Tg) (&gt;0).
     * Typical Value = 0.5.
     */
    val tg: Double,

    /**
     * Washout time constant (Tr) (&gt;0).
     * Typical Value = 5.
     */
    val tr: Double,

    /**
     * Water inertia time constant (Tw) (&gt;0).
     * Typical Value = 1.
     */
    val tw: Double,

    /**
     * Maximum gate velocity (Vlem) (&gt;0).
     * Typical Value = 0.2.
     */
    val velm: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydro1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydro1
extends
    Parseable[GovHydro1]
{
    val sup = TurbineGovernorDynamics.parse _
    val at = parse_element (element ("""GovHydro1.at"""))_
    val dturb = parse_element (element ("""GovHydro1.dturb"""))_
    val gmax = parse_element (element ("""GovHydro1.gmax"""))_
    val gmin = parse_element (element ("""GovHydro1.gmin"""))_
    val hdam = parse_element (element ("""GovHydro1.hdam"""))_
    val mwbase = parse_element (element ("""GovHydro1.mwbase"""))_
    val qnl = parse_element (element ("""GovHydro1.qnl"""))_
    val rperm = parse_element (element ("""GovHydro1.rperm"""))_
    val rtemp = parse_element (element ("""GovHydro1.rtemp"""))_
    val tf = parse_element (element ("""GovHydro1.tf"""))_
    val tg = parse_element (element ("""GovHydro1.tg"""))_
    val tr = parse_element (element ("""GovHydro1.tr"""))_
    val tw = parse_element (element ("""GovHydro1.tw"""))_
    val velm = parse_element (element ("""GovHydro1.velm"""))_
    def parse (context: Context): GovHydro1 =
    {
        GovHydro1(
            sup (context),
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
 */
case class GovHydro2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine numerator multiplier (Aturb).
     * Typical Value = -1.
     */
    val aturb: Double,

    /**
     * Turbine denominator multiplier (Bturb).
     * Typical Value = 0.5.
     */
    val bturb: Double,

    /**
     * Intentional deadband width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional deadband (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Turbine gain (Kturb).
     * Typical Value = 1.
     */
    val kturb: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening; (<i>Pmin</i>).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Permanent droop (Rperm).
     * Typical Value = 0.05.
     */
    val rperm: Double,

    /**
     * Temporary droop (Rtemp).
     * Typical Value = 0.5.
     */
    val rtemp: Double,

    /**
     * Gate servo time constant (Tg).
     * Typical Value = 0.5.
     */
    val tg: Double,

    /**
     * Pilot servo valve time constant (Tp).
     * Typical Value = 0.03.
     */
    val tp: Double,

    /**
     * Dashpot time constant (Tr).
     * Typical Value = 12.
     */
    val tr: Double,

    /**
     * Water inertia time constant (Tw).
     * Typical Value = 2.
     */
    val tw: Double,

    /**
     * Maximum gate closing velocity (Uc) (&lt;0).
     * Unit = PU/sec.   Typical Value = -0.1.
     */
    val uc: Double,

    /**
     * Maximum gate opening velocity (Uo).
     * Unit = PU/sec.  Typical Value = 0.1.
     */
    val uo: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydro2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydro2
extends
    Parseable[GovHydro2]
{
    val sup = TurbineGovernorDynamics.parse _
    val aturb = parse_element (element ("""GovHydro2.aturb"""))_
    val bturb = parse_element (element ("""GovHydro2.bturb"""))_
    val db1 = parse_element (element ("""GovHydro2.db1"""))_
    val db2 = parse_element (element ("""GovHydro2.db2"""))_
    val eps = parse_element (element ("""GovHydro2.eps"""))_
    val gv1 = parse_element (element ("""GovHydro2.gv1"""))_
    val gv2 = parse_element (element ("""GovHydro2.gv2"""))_
    val gv3 = parse_element (element ("""GovHydro2.gv3"""))_
    val gv4 = parse_element (element ("""GovHydro2.gv4"""))_
    val gv5 = parse_element (element ("""GovHydro2.gv5"""))_
    val gv6 = parse_element (element ("""GovHydro2.gv6"""))_
    val kturb = parse_element (element ("""GovHydro2.kturb"""))_
    val mwbase = parse_element (element ("""GovHydro2.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydro2.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydro2.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydro2.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydro2.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydro2.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydro2.pgv6"""))_
    val pmax = parse_element (element ("""GovHydro2.pmax"""))_
    val pmin = parse_element (element ("""GovHydro2.pmin"""))_
    val rperm = parse_element (element ("""GovHydro2.rperm"""))_
    val rtemp = parse_element (element ("""GovHydro2.rtemp"""))_
    val tg = parse_element (element ("""GovHydro2.tg"""))_
    val tp = parse_element (element ("""GovHydro2.tp"""))_
    val tr = parse_element (element ("""GovHydro2.tr"""))_
    val tw = parse_element (element ("""GovHydro2.tw"""))_
    val uc = parse_element (element ("""GovHydro2.uc"""))_
    val uo = parse_element (element ("""GovHydro2.uo"""))_
    def parse (context: Context): GovHydro2 =
    {
        GovHydro2(
            sup (context),
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
 * This model differs from that defined in the IEEE modeling guideline paper in that the limits on gate position and velocity do not permit "wind up" of the upstream signals.
 */
case class GovHydro3
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine gain (At).
     * Typical Value = 1.2.
     */
    val at: Double,

    /**
     * Intentional dead-band width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Turbine damping factor (Dturb).
     * Typical Value = 0.2.
     */
    val dturb: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Governor control flag (Cflag).
    true = PID control is active
    false = double derivative control is active.
     * Typical Value = true.
     */
    val governorControl: Boolean,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Turbine nominal head (H0).
     * Typical Value = 1.
     */
    val h0: Double,

    /**
     * Derivative gain (K1).
     * Typical Value = 0.01.
     */
    val k1: Double,

    /**
     * Double derivative gain, if Cflag = -1 (K2).
     * Typical Value = 2.5.
     */
    val k2: Double,

    /**
     * Gate servo gain (Kg).
     * Typical Value = 2.
     */
    val kg: Double,

    /**
     * Integral gain (Ki).
     * Typical Value = 0.5.
     */
    val ki: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening, PU of MWbase (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening, PU of MWbase (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * No-load turbine flow at nominal head (Qnl).
     * Typical Value = 0.08.
     */
    val qnl: Double,

    /**
     * Steady-state droop, PU, for electrical power feedback (Relec).
     * Typical Value = 0.05.
     */
    val relec: Double,

    /**
     * Steady-state droop, PU, for governor output feedback (Rgate).
     * Typical Value = 0.
     */
    val rgate: Double,

    /**
     * Input filter time constant (Td).
     * Typical Value = 0.05.
     */
    val td: Double,

    /**
     * Washout time constant (Tf).
     * Typical Value = 0.1.
     */
    val tf: Double,

    /**
     * Gate servo time constant (Tp).
     * Typical Value = 0.05.
     */
    val tp: Double,

    /**
     * Power feedback time constant (Tt).
     * Typical Value = 0.2.
     */
    val tt: Double,

    /**
     * Water inertia time constant (Tw).
     * Typical Value = 1.
     */
    val tw: Double,

    /**
     * Maximum gate closing velocity (Velcl).
     * Unit = PU/sec.  Typical Value = -0.2.
     */
    val velcl: Double,

    /**
     * Maximum gate opening velocity (Velop).
     * Unit = PU/sec. Typical Value = 0.2.
     */
    val velop: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydro3]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydro3
extends
    Parseable[GovHydro3]
{
    val sup = TurbineGovernorDynamics.parse _
    val at = parse_element (element ("""GovHydro3.at"""))_
    val db1 = parse_element (element ("""GovHydro3.db1"""))_
    val db2 = parse_element (element ("""GovHydro3.db2"""))_
    val dturb = parse_element (element ("""GovHydro3.dturb"""))_
    val eps = parse_element (element ("""GovHydro3.eps"""))_
    val governorControl = parse_element (element ("""GovHydro3.governorControl"""))_
    val gv1 = parse_element (element ("""GovHydro3.gv1"""))_
    val gv2 = parse_element (element ("""GovHydro3.gv2"""))_
    val gv3 = parse_element (element ("""GovHydro3.gv3"""))_
    val gv4 = parse_element (element ("""GovHydro3.gv4"""))_
    val gv5 = parse_element (element ("""GovHydro3.gv5"""))_
    val gv6 = parse_element (element ("""GovHydro3.gv6"""))_
    val h0 = parse_element (element ("""GovHydro3.h0"""))_
    val k1 = parse_element (element ("""GovHydro3.k1"""))_
    val k2 = parse_element (element ("""GovHydro3.k2"""))_
    val kg = parse_element (element ("""GovHydro3.kg"""))_
    val ki = parse_element (element ("""GovHydro3.ki"""))_
    val mwbase = parse_element (element ("""GovHydro3.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydro3.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydro3.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydro3.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydro3.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydro3.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydro3.pgv6"""))_
    val pmax = parse_element (element ("""GovHydro3.pmax"""))_
    val pmin = parse_element (element ("""GovHydro3.pmin"""))_
    val qnl = parse_element (element ("""GovHydro3.qnl"""))_
    val relec = parse_element (element ("""GovHydro3.relec"""))_
    val rgate = parse_element (element ("""GovHydro3.rgate"""))_
    val td = parse_element (element ("""GovHydro3.td"""))_
    val tf = parse_element (element ("""GovHydro3.tf"""))_
    val tp = parse_element (element ("""GovHydro3.tp"""))_
    val tt = parse_element (element ("""GovHydro3.tt"""))_
    val tw = parse_element (element ("""GovHydro3.tw"""))_
    val velcl = parse_element (element ("""GovHydro3.velcl"""))_
    val velop = parse_element (element ("""GovHydro3.velop"""))_
    def parse (context: Context): GovHydro3 =
    {
        GovHydro3(
            sup (context),
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
 * Represents plants with straight-forward penstock configurations and hydraulic governors of traditional 'dashpot' type.  This model can be used to represent simple, Francis, Pelton or Kaplan turbines.
 */
case class GovHydro4
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine gain (At).
     * Typical Value = 1.2.
     */
    val at: Double,

    /**
     * Kaplan blade servo point 0 (Bgv0).
     * Typical Value = 0.
     */
    val bgv0: Double,

    /**
     * Kaplan blade servo point 1 (Bgv1).
     * Typical Value = 0.
     */
    val bgv1: Double,

    /**
     * Kaplan blade servo point 2 (Bgv2).
     * Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.1.
     */
    val bgv2: Double,

    /**
     * Kaplan blade servo point 3 (Bgv3).
     * Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.667.
     */
    val bgv3: Double,

    /**
     * Kaplan blade servo point 4 (Bgv4).
     * Typical Value = 0.  Typical Value Francis = 0, Kaplan = 0.9.
     */
    val bgv4: Double,

    /**
     * Kaplan blade servo point 5 (Bgv5).
     * Typical Value = 0.  Typical Value Francis = 0, Kaplan = 1.
     */
    val bgv5: Double,

    /**
     * Maximum blade adjustment factor (Bmax).
     * Typical Value = 0.  Typical Value Francis = 0, Kaplan = 1.1276.
     */
    val bmax: Double,

    /**
     * Intentional deadband width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Turbine damping factor (Dturb).
     * Unit = delta P (PU of MWbase) / delta speed (PU).
     */
    val dturb: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Maximum gate opening, PU of MWbase (Gmax).
     * Typical Value = 1.
     */
    val gmax: Double,

    /**
     * Minimum gate opening, PU of MWbase (Gmin).
     * Typical Value = 0.
     */
    val gmin: Double,

    /**
     * Nonlinear gain point 0, PU gv (Gv0).
     * Typical Value = 0.  Typical Value Francis = 0.1, Kaplan = 0.1.
     */
    val gv0: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.  Typical Value Francis = 0.4, Kaplan = 0.4.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.  Typical Value Francis = 0.5, Kaplan = 0.5.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.  Typical Value Francis = 0.7, Kaplan = 0.7.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.  Typical Value Francis = 0.8, Kaplan = 0.8.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.  Typical Value Francis = 0.9, Kaplan = 0.9.
     */
    val gv5: Double,

    /**
     * Head available at dam (hdam).
     * Typical Value = 1.
     */
    val hdam: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 0, PU power (Pgv0).
     * Typical Value = 0.
     */
    val pgv0: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.  Typical Value Francis = 0.42, Kaplan = 0.35.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.  Typical Value Francis = 0.56, Kaplan = 0.468.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.  Typical Value Francis = 0.8, Kaplan = 0.796.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.  Typical Value Francis = 0.9, Kaplan = 0.917.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.  Typical Value Francis = 0.97, Kaplan = 0.99.
     */
    val pgv5: Double,

    /**
     * No-load flow at nominal head (Qnl).
     * Typical Value = 0.08.  Typical Value Francis = 0, Kaplan = 0.
     */
    val qn1: Double,

    /**
     * Permanent droop (Rperm).
     * Typical Value = 0.05.
     */
    val rperm: Double,

    /**
     * Temporary droop (Rtemp).
     * Typical Value = 0.3.
     */
    val rtemp: Double,

    /**
     * Blade servo time constant (Tblade).
     * Typical Value = 100.
     */
    val tblade: Double,

    /**
     * Gate servo time constant (Tg) (&gt;0).
     * Typical Value = 0.5.
     */
    val tg: Double,

    /**
     * Pilot servo time constant (Tp).
     * Typical Value = 0.1.
     */
    val tp: Double,

    /**
     * Dashpot time constant (Tr) (&gt;0).
     * Typical Value = 5.
     */
    val tr: Double,

    /**
     * Water inertia time constant (Tw) (&gt;0).
     * Typical Value = 1.
     */
    val tw: Double,

    /**
     * Max gate closing velocity (Uc).
     * Typical Value = 0.2.
     */
    val uc: Double,

    /**
     * Max gate opening velocity (Uo).
     * Typical Value = 0.2.
     */
    val uo: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydro4]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydro4
extends
    Parseable[GovHydro4]
{
    val sup = TurbineGovernorDynamics.parse _
    val at = parse_element (element ("""GovHydro4.at"""))_
    val bgv0 = parse_element (element ("""GovHydro4.bgv0"""))_
    val bgv1 = parse_element (element ("""GovHydro4.bgv1"""))_
    val bgv2 = parse_element (element ("""GovHydro4.bgv2"""))_
    val bgv3 = parse_element (element ("""GovHydro4.bgv3"""))_
    val bgv4 = parse_element (element ("""GovHydro4.bgv4"""))_
    val bgv5 = parse_element (element ("""GovHydro4.bgv5"""))_
    val bmax = parse_element (element ("""GovHydro4.bmax"""))_
    val db1 = parse_element (element ("""GovHydro4.db1"""))_
    val db2 = parse_element (element ("""GovHydro4.db2"""))_
    val dturb = parse_element (element ("""GovHydro4.dturb"""))_
    val eps = parse_element (element ("""GovHydro4.eps"""))_
    val gmax = parse_element (element ("""GovHydro4.gmax"""))_
    val gmin = parse_element (element ("""GovHydro4.gmin"""))_
    val gv0 = parse_element (element ("""GovHydro4.gv0"""))_
    val gv1 = parse_element (element ("""GovHydro4.gv1"""))_
    val gv2 = parse_element (element ("""GovHydro4.gv2"""))_
    val gv3 = parse_element (element ("""GovHydro4.gv3"""))_
    val gv4 = parse_element (element ("""GovHydro4.gv4"""))_
    val gv5 = parse_element (element ("""GovHydro4.gv5"""))_
    val hdam = parse_element (element ("""GovHydro4.hdam"""))_
    val mwbase = parse_element (element ("""GovHydro4.mwbase"""))_
    val pgv0 = parse_element (element ("""GovHydro4.pgv0"""))_
    val pgv1 = parse_element (element ("""GovHydro4.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydro4.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydro4.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydro4.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydro4.pgv5"""))_
    val qn1 = parse_element (element ("""GovHydro4.qn1"""))_
    val rperm = parse_element (element ("""GovHydro4.rperm"""))_
    val rtemp = parse_element (element ("""GovHydro4.rtemp"""))_
    val tblade = parse_element (element ("""GovHydro4.tblade"""))_
    val tg = parse_element (element ("""GovHydro4.tg"""))_
    val tp = parse_element (element ("""GovHydro4.tp"""))_
    val tr = parse_element (element ("""GovHydro4.tr"""))_
    val tw = parse_element (element ("""GovHydro4.tw"""))_
    val uc = parse_element (element ("""GovHydro4.uc"""))_
    val uo = parse_element (element ("""GovHydro4.uo"""))_
    def parse (context: Context): GovHydro4 =
    {
        GovHydro4(
            sup (context),
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
 */
case class GovHydroDD
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine numerator multiplier (Aturb) (note 3).
     * Typical Value = -1.
     */
    val aturb: Double,

    /**
     * Turbine denominator multiplier (Bturb) (note 3).
     * Typical Value = 0.5.
     */
    val bturb: Double,

    /**
     * Intentional dead-band width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Maximum gate opening (Gmax).
     * Typical Value = 0.
     */
    val gmax: Double,

    /**
     * Minimum gate opening (Gmin).
     * Typical Value = 0.
     */
    val gmin: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Input signal switch (Flag). 
    true = Pe input is used
    false = feedback is received from CV.
     * Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.
     */
    val inputSignal: Boolean,

    /**
     * Single derivative gain (K1).
     * Typical Value = 3.6.
     */
    val k1: Double,

    /**
     * Double derivative gain (K2).
     * Typical Value = 0.2.
     */
    val k2: Double,

    /**
     * Gate servo gain (Kg).
     * Typical Value = 3.
     */
    val kg: Double,

    /**
     * Integral gain (Ki).
     * Typical Value = 1.
     */
    val ki: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening, PU of MWbase (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening, PU of MWbase (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Steady state droop (R).
     * Typical Value = 0.05.
     */
    val r: Double,

    /**
     * Input filter time constant (Td).
     * Typical Value = 0.
     */
    val td: Double,

    /**
     * Washout time constant (Tf).
     * Typical Value = 0.1.
     */
    val tf: Double,

    /**
     * Gate servo time constant (Tp).
     * Typical Value = 0.35.
     */
    val tp: Double,

    /**
     * Power feedback time constant (Tt).
     * Typical Value = 0.02.
     */
    val tt: Double,

    /**
     * Turbine time constant (Tturb) (note 3).
     * Typical Value = 0.8.
     */
    val tturb: Double,

    /**
     * Maximum gate closing velocity (Velcl).
     * Unit = PU/sec.  Typical Value = -0.14.
     */
    val velcl: Double,

    /**
     * Maximum gate opening velocity (Velop).
     * Unit = PU/sec.  Typical Value = 0.09.
     */
    val velop: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroDD]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroDD
extends
    Parseable[GovHydroDD]
{
    val sup = TurbineGovernorDynamics.parse _
    val aturb = parse_element (element ("""GovHydroDD.aturb"""))_
    val bturb = parse_element (element ("""GovHydroDD.bturb"""))_
    val db1 = parse_element (element ("""GovHydroDD.db1"""))_
    val db2 = parse_element (element ("""GovHydroDD.db2"""))_
    val eps = parse_element (element ("""GovHydroDD.eps"""))_
    val gmax = parse_element (element ("""GovHydroDD.gmax"""))_
    val gmin = parse_element (element ("""GovHydroDD.gmin"""))_
    val gv1 = parse_element (element ("""GovHydroDD.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroDD.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroDD.gv3"""))_
    val gv4 = parse_element (element ("""GovHydroDD.gv4"""))_
    val gv5 = parse_element (element ("""GovHydroDD.gv5"""))_
    val gv6 = parse_element (element ("""GovHydroDD.gv6"""))_
    val inputSignal = parse_element (element ("""GovHydroDD.inputSignal"""))_
    val k1 = parse_element (element ("""GovHydroDD.k1"""))_
    val k2 = parse_element (element ("""GovHydroDD.k2"""))_
    val kg = parse_element (element ("""GovHydroDD.kg"""))_
    val ki = parse_element (element ("""GovHydroDD.ki"""))_
    val mwbase = parse_element (element ("""GovHydroDD.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydroDD.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydroDD.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydroDD.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydroDD.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydroDD.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydroDD.pgv6"""))_
    val pmax = parse_element (element ("""GovHydroDD.pmax"""))_
    val pmin = parse_element (element ("""GovHydroDD.pmin"""))_
    val r = parse_element (element ("""GovHydroDD.r"""))_
    val td = parse_element (element ("""GovHydroDD.td"""))_
    val tf = parse_element (element ("""GovHydroDD.tf"""))_
    val tp = parse_element (element ("""GovHydroDD.tp"""))_
    val tt = parse_element (element ("""GovHydroDD.tt"""))_
    val tturb = parse_element (element ("""GovHydroDD.tturb"""))_
    val velcl = parse_element (element ("""GovHydroDD.velcl"""))_
    val velop = parse_element (element ("""GovHydroDD.velop"""))_
    def parse (context: Context): GovHydroDD =
    {
        GovHydroDD(
            sup (context),
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
 * This model can be used to represent three types of governors.
 */
case class GovHydroFrancis
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Opening section S<sub>eff</sub> at the maximum efficiency (Am).
     * Typical Value = 0.7.
     */
    val am: Double,

    /**
     * Area of the surge tank (A<sub>V0</sub>).
     * Unit = m<sup>2</sup>. Typical Value = 30.
     */
    val av0: Double,

    /**
     * Area of the compensation tank (A<sub>V1</sub>).
     * Unit = m<sup>2</sup>. Typical Value = 700.
     */
    val av1: Double,

    /**
     * Droop (Bp).
     * Typical Value = 0.05.
     */
    val bp: Double,

    /**
     * Intentional dead-band width (DB1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Maximum efficiency (EtaMax).
     * Typical Value = 1.05.
     */
    val etamax: Double,

    /**
     * Governor control flag (Cflag).
     * Typical Value = mechanicHydrolicTachoAccelerator.
     */
    val governorControl: String,

    /**
     * Head of compensation chamber water level with respect to the level of penstock (H<sub>1</sub>).
     * Unit = m. Typical Value = 4.
     */
    val h1: Double,

    /**
     * Head of surge tank water level with respect to the level of penstock (H<sub>2</sub>).
     * Unit = m. Typical Value = 40.
     */
    val h2: Double,

    /**
     * Rated hydraulic head (H<sub>n</sub>).
     * Unit = m. Typical Value = 250.
     */
    val hn: Double,

    /**
     * Penstock loss coefficient (due to friction) (Kc).
     * Typical Value = 0.025.
     */
    val kc: Double,

    /**
     * Water tunnel and surge chamber loss coefficient (due to friction) (Kg).
     * Typical Value = 0.025.
     */
    val kg: Double,

    /**
     * Washout gain (Kt).
     * Typical Value = 0.25.
     */
    val kt: Double,

    /**
     * No-load turbine flow at nominal head (Qc0).
     * Typical Value = 0.21.
     */
    val qc0: Double,

    /**
     * Rated flow (Q<sub>n</sub>).
     * Unit = m<sup>3</sup>/s. Typical Value = 40.
     */
    val qn: Double,

    /**
     * Derivative gain (Ta).
     * Typical Value = 3.
     */
    val ta: Double,

    /**
     * Washout time constant (Td).
     * Typical Value = 3.
     */
    val td: Double,

    /**
     * Gate servo time constant (Ts).
     * Typical Value = 0.5.
     */
    val ts: Double,

    /**
     * Water inertia time constant (Twnc).
     * Typical Value = 1.
     */
    val twnc: Double,

    /**
     * Water tunnel and surge chamber inertia time constant (Twng).
     * Typical Value = 3.
     */
    val twng: Double,

    /**
     * Derivative feedback gain (Tx).
     * Typical Value = 1.
     */
    val tx: Double,

    /**
     * Maximum gate opening velocity (Va).
     * Unit = PU/sec.  Typical Value = 0.011.
     */
    val va: Double,

    /**
     * Maximum gate opening (ValvMax).
     * Typical Value = 1.
     */
    val valvmax: Double,

    /**
     * Minimum gate opening (ValvMin).
     * Typical Value = 0.
     */
    val valvmin: Double,

    /**
     * Maximum gate closing velocity (Vc).
     * Unit = PU/sec.  Typical Value = -0.011.
     */
    val vc: Double,

    /**
     * Water tunnel and surge chamber simulation (Tflag).
    true = enable of water tunnel and surge chamber simulation
    false = inhibit of water tunnel and surge chamber simulation.
     * Typical Value = false.
     */
    val waterTunnelSurgeChamberSimulation: Boolean,

    /**
     * Head of upper water level with respect to the level of penstock (Zsfc).
     * Unit = m.  Typical Value = 25.
     */
    val zsfc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroFrancis]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroFrancis
extends
    Parseable[GovHydroFrancis]
{
    val sup = TurbineGovernorDynamics.parse _
    val am = parse_element (element ("""GovHydroFrancis.am"""))_
    val av0 = parse_element (element ("""GovHydroFrancis.av0"""))_
    val av1 = parse_element (element ("""GovHydroFrancis.av1"""))_
    val bp = parse_element (element ("""GovHydroFrancis.bp"""))_
    val db1 = parse_element (element ("""GovHydroFrancis.db1"""))_
    val etamax = parse_element (element ("""GovHydroFrancis.etamax"""))_
    val governorControl = parse_attribute (attribute ("""GovHydroFrancis.governorControl"""))_
    val h1 = parse_element (element ("""GovHydroFrancis.h1"""))_
    val h2 = parse_element (element ("""GovHydroFrancis.h2"""))_
    val hn = parse_element (element ("""GovHydroFrancis.hn"""))_
    val kc = parse_element (element ("""GovHydroFrancis.kc"""))_
    val kg = parse_element (element ("""GovHydroFrancis.kg"""))_
    val kt = parse_element (element ("""GovHydroFrancis.kt"""))_
    val qc0 = parse_element (element ("""GovHydroFrancis.qc0"""))_
    val qn = parse_element (element ("""GovHydroFrancis.qn"""))_
    val ta = parse_element (element ("""GovHydroFrancis.ta"""))_
    val td = parse_element (element ("""GovHydroFrancis.td"""))_
    val ts = parse_element (element ("""GovHydroFrancis.ts"""))_
    val twnc = parse_element (element ("""GovHydroFrancis.twnc"""))_
    val twng = parse_element (element ("""GovHydroFrancis.twng"""))_
    val tx = parse_element (element ("""GovHydroFrancis.tx"""))_
    val va = parse_element (element ("""GovHydroFrancis.va"""))_
    val valvmax = parse_element (element ("""GovHydroFrancis.valvmax"""))_
    val valvmin = parse_element (element ("""GovHydroFrancis.valvmin"""))_
    val vc = parse_element (element ("""GovHydroFrancis.vc"""))_
    val waterTunnelSurgeChamberSimulation = parse_element (element ("""GovHydroFrancis.waterTunnelSurgeChamberSimulation"""))_
    val zsfc = parse_element (element ("""GovHydroFrancis.zsfc"""))_
    def parse (context: Context): GovHydroFrancis =
    {
        GovHydroFrancis(
            sup (context),
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
 * Used for Mechanical-Hydraulic and Electro-Hydraulic turbine governors, with our without steam feedback. Typical values given are for Mechanical-Hydraulic.
 */
case class GovHydroIEEE0
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Governor gain (K<i>)</i>.
     */
    val k: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Gate maximum (Pmax).
     */
    val pmax: Double,

    /**
     * Gate minimum (Pmin).
     */
    val pmin: Double,

    /**
     * Governor lag time constant (T1).
     * Typical Value = 0.25.
     */
    val t1: Double,

    /**
     * Governor lead time constant (T2<i>)</i>.
     * Typical Value = 0.
     */
    val t2: Double,

    /**
     * Gate actuator time constant (T3).
     * Typical Value = 0.1.
     */
    val t3: Double,

    /**
     * Water starting time (T4).
     */
    val t4: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroIEEE0]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroIEEE0
extends
    Parseable[GovHydroIEEE0]
{
    val sup = TurbineGovernorDynamics.parse _
    val k = parse_element (element ("""GovHydroIEEE0.k"""))_
    val mwbase = parse_element (element ("""GovHydroIEEE0.mwbase"""))_
    val pmax = parse_element (element ("""GovHydroIEEE0.pmax"""))_
    val pmin = parse_element (element ("""GovHydroIEEE0.pmin"""))_
    val t1 = parse_element (element ("""GovHydroIEEE0.t1"""))_
    val t2 = parse_element (element ("""GovHydroIEEE0.t2"""))_
    val t3 = parse_element (element ("""GovHydroIEEE0.t3"""))_
    val t4 = parse_element (element ("""GovHydroIEEE0.t4"""))_
    def parse (context: Context): GovHydroIEEE0 =
    {
        GovHydroIEEE0(
            sup (context),
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
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems</font>
 */
case class GovHydroIEEE2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine numerator multiplier (Aturb).
     * Typical Value = -1.
     */
    val aturb: Double,

    /**
     * Turbine denominator multiplier (Bturb).
     * Typical Value = 0.5.
     */
    val bturb: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Turbine gain (Kturb).
     * Typical Value = 1.
     */
    val kturb: Double,

    /**
     * Base for power values (MWbase) (&gt; 0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Permanent droop (Rperm).
     * Typical Value = 0.05.
     */
    val rperm: Double,

    /**
     * Temporary droop (Rtemp).
     * Typical Value = 0.5.
     */
    val rtemp: Double,

    /**
     * Gate servo time constant (Tg).
     * Typical Value = 0.5.
     */
    val tg: Double,

    /**
     * Pilot servo valve time constant (Tp).
     * Typical Value = 0.03.
     */
    val tp: Double,

    /**
     * Dashpot time constant (Tr).
     * Typical Value = 12.
     */
    val tr: Double,

    /**
     * Water inertia time constant (Tw).
     * Typical Value = 2.
     */
    val tw: Double,

    /**
     * Maximum gate closing velocity (Uc) (&lt;0).
     * Typical Value = -0.1.
     */
    val uc: Double,

    /**
     * Maximum gate opening velocity (Uo).
     * Unit = PU/sec.  Typical Value = 0.1.
     */
    val uo: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroIEEE2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroIEEE2
extends
    Parseable[GovHydroIEEE2]
{
    val sup = TurbineGovernorDynamics.parse _
    val aturb = parse_element (element ("""GovHydroIEEE2.aturb"""))_
    val bturb = parse_element (element ("""GovHydroIEEE2.bturb"""))_
    val gv1 = parse_element (element ("""GovHydroIEEE2.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroIEEE2.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroIEEE2.gv3"""))_
    val gv4 = parse_element (element ("""GovHydroIEEE2.gv4"""))_
    val gv5 = parse_element (element ("""GovHydroIEEE2.gv5"""))_
    val gv6 = parse_element (element ("""GovHydroIEEE2.gv6"""))_
    val kturb = parse_element (element ("""GovHydroIEEE2.kturb"""))_
    val mwbase = parse_element (element ("""GovHydroIEEE2.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydroIEEE2.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydroIEEE2.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydroIEEE2.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydroIEEE2.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydroIEEE2.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydroIEEE2.pgv6"""))_
    val pmax = parse_element (element ("""GovHydroIEEE2.pmax"""))_
    val pmin = parse_element (element ("""GovHydroIEEE2.pmin"""))_
    val rperm = parse_element (element ("""GovHydroIEEE2.rperm"""))_
    val rtemp = parse_element (element ("""GovHydroIEEE2.rtemp"""))_
    val tg = parse_element (element ("""GovHydroIEEE2.tg"""))_
    val tp = parse_element (element ("""GovHydroIEEE2.tp"""))_
    val tr = parse_element (element ("""GovHydroIEEE2.tr"""))_
    val tw = parse_element (element ("""GovHydroIEEE2.tw"""))_
    val uc = parse_element (element ("""GovHydroIEEE2.uc"""))_
    val uo = parse_element (element ("""GovHydroIEEE2.uo"""))_
    def parse (context: Context): GovHydroIEEE2 =
    {
        GovHydroIEEE2(
            sup (context),
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
 */
case class GovHydroPID
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine numerator multiplier (Aturb) (note 3).
     * Typical Value -1.
     */
    val aturb: Double,

    /**
     * Turbine denominator multiplier (Bturb) (note 3).
     * Typical Value = 0.5.
     */
    val bturb: Double,

    /**
     * Intentional dead-band width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Input signal switch (Flag). 
    true = Pe input is used
    false = feedback is received from CV.
     * Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.  Typical Value = true.
     */
    val inputSignal: Boolean,

    /**
     * Derivative gain (Kd).
     * Typical Value = 1.11.
     */
    val kd: Double,

    /**
     * Gate servo gain (Kg).
     * Typical Value = 2.5.
     */
    val kg: Double,

    /**
     * Integral gain (Ki).
     * Typical Value = 0.36.
     */
    val ki: Double,

    /**
     * Proportional gain (Kp).
     * Typical Value = 0.1.
     */
    val kp: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening, PU of MWbase (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening, PU of MWbase (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Steady state droop (R).
     * Typical Value = 0.05.
     */
    val r: Double,

    /**
     * Input filter time constant (Td).
     * Typical Value = 0.
     */
    val td: Double,

    /**
     * Washout time constant (Tf).
     * Typical Value = 0.1.
     */
    val tf: Double,

    /**
     * Gate servo time constant (Tp).
     * Typical Value = 0.35.
     */
    val tp: Double,

    /**
     * Power feedback time constant (Tt).
     * Typical Value = 0.02.
     */
    val tt: Double,

    /**
     * Turbine time constant (Tturb) (note 3).
     * Typical Value = 0.8.
     */
    val tturb: Double,

    /**
     * Maximum gate closing velocity (Velcl).
     * Unit = PU/sec.  Typical Value = -0.14.
     */
    val velcl: Double,

    /**
     * Maximum gate opening velocity (Velop).
     * Unit = PU/sec.  Typical Value = 0.09.
     */
    val velop: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroPID]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroPID
extends
    Parseable[GovHydroPID]
{
    val sup = TurbineGovernorDynamics.parse _
    val aturb = parse_element (element ("""GovHydroPID.aturb"""))_
    val bturb = parse_element (element ("""GovHydroPID.bturb"""))_
    val db1 = parse_element (element ("""GovHydroPID.db1"""))_
    val db2 = parse_element (element ("""GovHydroPID.db2"""))_
    val eps = parse_element (element ("""GovHydroPID.eps"""))_
    val gv1 = parse_element (element ("""GovHydroPID.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroPID.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroPID.gv3"""))_
    val gv4 = parse_element (element ("""GovHydroPID.gv4"""))_
    val gv5 = parse_element (element ("""GovHydroPID.gv5"""))_
    val gv6 = parse_element (element ("""GovHydroPID.gv6"""))_
    val inputSignal = parse_element (element ("""GovHydroPID.inputSignal"""))_
    val kd = parse_element (element ("""GovHydroPID.kd"""))_
    val kg = parse_element (element ("""GovHydroPID.kg"""))_
    val ki = parse_element (element ("""GovHydroPID.ki"""))_
    val kp = parse_element (element ("""GovHydroPID.kp"""))_
    val mwbase = parse_element (element ("""GovHydroPID.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydroPID.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydroPID.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydroPID.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydroPID.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydroPID.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydroPID.pgv6"""))_
    val pmax = parse_element (element ("""GovHydroPID.pmax"""))_
    val pmin = parse_element (element ("""GovHydroPID.pmin"""))_
    val r = parse_element (element ("""GovHydroPID.r"""))_
    val td = parse_element (element ("""GovHydroPID.td"""))_
    val tf = parse_element (element ("""GovHydroPID.tf"""))_
    val tp = parse_element (element ("""GovHydroPID.tp"""))_
    val tt = parse_element (element ("""GovHydroPID.tt"""))_
    val tturb = parse_element (element ("""GovHydroPID.tturb"""))_
    val velcl = parse_element (element ("""GovHydroPID.velcl"""))_
    val velop = parse_element (element ("""GovHydroPID.velop"""))_
    def parse (context: Context): GovHydroPID =
    {
        GovHydroPID(
            sup (context),
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
 * Represents plants with straight forward penstock configurations and "three term" electro-hydraulic governors (i.e. Woodard electronic).
 */
case class GovHydroPID2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Factor multiplying Tw (Atw).
     * Typical Value = 0.
     */
    val atw: Double,

    /**
     * Turbine damping factor (D).
     * Unit = delta P / delta speed.  Typical Value = 0.
     */
    val d: Double,

    /**
     * Feedback signal type flag (Flag).
    true = use gate position feedback signal
     * false = use Pe.
     */
    val feedbackSignal: Boolean,

    /**
     * Gate opening at speed no load (G0).
     * Typical Value = 0.
     */
    val g0: Double,

    /**
     * Intermediate gate opening (G1).
     * Typical Value = 0.
     */
    val g1: Double,

    /**
     * Intermediate gate opening (G2).
     * Typical Value = 0.
     */
    val g2: Double,

    /**
     * Maximum gate opening (Gmax).
     * Typical Value = 0.
     */
    val gmax: Double,

    /**
     * Minimum gate opening (Gmin).
     * Typical Value = 0.
     */
    val gmin: Double,

    /**
     * Derivative gain (Kd).
     * Typical Value = 0.
     */
    val kd: Double,

    /**
     * Reset gain (Ki).
     * Unit = PU/ sec.  Typical Value = 0.
     */
    val ki: Double,

    /**
     * Proportional gain (Kp).
     * Typical Value = 0.
     */
    val kp: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Power at gate opening G1 (P1).
     * Typical Value = 0.
     */
    val p1: Double,

    /**
     * Power at gate opening G2 (P2).
     * Typical Value = 0.
     */
    val p2: Double,

    /**
     * Power at full opened gate (P3).
     * Typical Value = 0.
     */
    val p3: Double,

    /**
     * Permanent drop (Rperm).
     * Typical Value = 0.
     */
    val rperm: Double,

    /**
     * Controller time constant (Ta) (&gt;0).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Gate servo time constant (Tb) (&gt;0).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Speed detector time constant (Treg).
     * Typical Value = 0.
     */
    val treg: Double,

    /**
     * Water inertia time constant (Tw) (&gt;0).
     * Typical Value = 0.
     */
    val tw: Double,

    /**
     * Maximum gate opening velocity (Velmax).
     * Unit = PU/sec.  Typical Value = 0.
     */
    val velmax: Double,

    /**
     * Maximum gate closing velocity (Velmin).
     * Unit = PU/sec.  Typical Value = 0.
     */
    val velmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroPID2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroPID2
extends
    Parseable[GovHydroPID2]
{
    val sup = TurbineGovernorDynamics.parse _
    val atw = parse_element (element ("""GovHydroPID2.atw"""))_
    val d = parse_element (element ("""GovHydroPID2.d"""))_
    val feedbackSignal = parse_element (element ("""GovHydroPID2.feedbackSignal"""))_
    val g0 = parse_element (element ("""GovHydroPID2.g0"""))_
    val g1 = parse_element (element ("""GovHydroPID2.g1"""))_
    val g2 = parse_element (element ("""GovHydroPID2.g2"""))_
    val gmax = parse_element (element ("""GovHydroPID2.gmax"""))_
    val gmin = parse_element (element ("""GovHydroPID2.gmin"""))_
    val kd = parse_element (element ("""GovHydroPID2.kd"""))_
    val ki = parse_element (element ("""GovHydroPID2.ki"""))_
    val kp = parse_element (element ("""GovHydroPID2.kp"""))_
    val mwbase = parse_element (element ("""GovHydroPID2.mwbase"""))_
    val p1 = parse_element (element ("""GovHydroPID2.p1"""))_
    val p2 = parse_element (element ("""GovHydroPID2.p2"""))_
    val p3 = parse_element (element ("""GovHydroPID2.p3"""))_
    val rperm = parse_element (element ("""GovHydroPID2.rperm"""))_
    val ta = parse_element (element ("""GovHydroPID2.ta"""))_
    val tb = parse_element (element ("""GovHydroPID2.tb"""))_
    val treg = parse_element (element ("""GovHydroPID2.treg"""))_
    val tw = parse_element (element ("""GovHydroPID2.tw"""))_
    val velmax = parse_element (element ("""GovHydroPID2.velmax"""))_
    val velmin = parse_element (element ("""GovHydroPID2.velmin"""))_
    def parse (context: Context): GovHydroPID2 =
    {
        GovHydroPID2(
            sup (context),
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
 * This model can be used to represent the dynamic related to water tunnel and surge chamber.
 */
case class GovHydroPelton
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Area of the surge tank (A<sub>V0</sub>).
     * Unit = m<sup>2</sup>. Typical Value = 30.
     */
    val av0: Double,

    /**
     * Area of the compensation tank (A<sub>V1</sub>).
     * Unit = m<sup>2</sup>. Typical Value = 700.
     */
    val av1: Double,

    /**
     * Droop (bp).
     * Typical Value = 0.05.
     */
    val bp: Double,

    /**
     * Intentional dead-band width (DB1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Intentional dead-band width of valve opening error (DB2).
     * Unit = Hz.  Typical Value = 0.01.
     */
    val db2: Double,

    /**
     * Head of compensation chamber water level with respect to the level of penstock (H<sub>1</sub>).
     * Unit = m. Typical Value = 4.
     */
    val h1: Double,

    /**
     * Head of surge tank water level with respect to the level of penstock (H<sub>2</sub>).
     * Unit = m. Typical Value = 40.
     */
    val h2: Double,

    /**
     * Rated hydraulic head (H<sub>n</sub>).
     * Unit = m. Typical Value = 250.
     */
    val hn: Double,

    /**
     * Penstock loss coefficient (due to friction) (Kc).
     * Typical Value = 0.025.
     */
    val kc: Double,

    /**
     * Water tunnel and surge chamber loss coefficient (due to friction) (Kg).
     * Typical Value = -0.025.
     */
    val kg: Double,

    /**
     * No-load turbine flow at nominal head (Qc0).
     * Typical Value = 0.05.
     */
    val qc0: Double,

    /**
     * Rated flow (Q<sub>n</sub>).
     * Unit = m<sup>3</sup>/s. Typical Value = 40.
     */
    val qn: Double,

    /**
     * Simplified Pelton model simulation (Sflag).
    true = enable of simplified Pelton model simulation
    false = enable of complete Pelton model simulation (non linear gain).
     * Typical Value = false.
     */
    val simplifiedPelton: Boolean,

    /**
     * Static compensating characteristic (Cflag).
    true = enable of static compensating characteristic 
    false = inhibit of static compensating characteristic.
     * Typical Value = false.
     */
    val staticCompensating: Boolean,

    /**
     * Derivative gain (accelerometer time constant) (Ta).
     * Typical Value = 3.
     */
    val ta: Double,

    /**
     * Gate servo time constant (Ts).
     * Typical Value = 0.15.
     */
    val ts: Double,

    /**
     * Servomotor integrator time constant (TV).
     * Typical Value = 0.3.
     */
    val tv: Double,

    /**
     * Water inertia time constant (Twnc).
     * Typical Value = 1.
     */
    val twnc: Double,

    /**
     * Water tunnel and surge chamber inertia time constant (Twng).
     * Typical Value = 3.
     */
    val twng: Double,

    /**
     * Electronic integrator time constant (Tx).
     * Typical Value = 0.5.
     */
    val tx: Double,

    /**
     * Maximum gate opening velocity (Va).
     * Unit = PU/sec.  Typical Value = 0.016.
     */
    val va: Double,

    /**
     * Maximum gate opening (ValvMax).
     * Typical Value = 1.
     */
    val valvmax: Double,

    /**
     * Minimum gate opening (ValvMin).
     * Typical Value = 0.
     */
    val valvmin: Double,

    /**
     * Maximum servomotor valve opening velocity (Vav).
     * Typical Value = 0.017.
     */
    val vav: Double,

    /**
     * Maximum gate closing velocity (Vc).
     * Unit = PU/sec.  Typical Value = -0.016.
     */
    val vc: Double,

    /**
     * Maximum servomotor valve closing velocity (Vcv).
     * Typical Value = -0.017.
     */
    val vcv: Double,

    /**
     * Water tunnel and surge chamber simulation (Tflag).
    true = enable of water tunnel and surge chamber simulation
    false = inhibit of water tunnel and surge chamber simulation.
     * Typical Value = false.
     */
    val waterTunnelSurgeChamberSimulation: Boolean,

    /**
     * Head of upper water level with respect to the level of penstock (Zsfc).
     * Unit = m. Typical Value = 25.
     */
    val zsfc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroPelton]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroPelton
extends
    Parseable[GovHydroPelton]
{
    val sup = TurbineGovernorDynamics.parse _
    val av0 = parse_element (element ("""GovHydroPelton.av0"""))_
    val av1 = parse_element (element ("""GovHydroPelton.av1"""))_
    val bp = parse_element (element ("""GovHydroPelton.bp"""))_
    val db1 = parse_element (element ("""GovHydroPelton.db1"""))_
    val db2 = parse_element (element ("""GovHydroPelton.db2"""))_
    val h1 = parse_element (element ("""GovHydroPelton.h1"""))_
    val h2 = parse_element (element ("""GovHydroPelton.h2"""))_
    val hn = parse_element (element ("""GovHydroPelton.hn"""))_
    val kc = parse_element (element ("""GovHydroPelton.kc"""))_
    val kg = parse_element (element ("""GovHydroPelton.kg"""))_
    val qc0 = parse_element (element ("""GovHydroPelton.qc0"""))_
    val qn = parse_element (element ("""GovHydroPelton.qn"""))_
    val simplifiedPelton = parse_element (element ("""GovHydroPelton.simplifiedPelton"""))_
    val staticCompensating = parse_element (element ("""GovHydroPelton.staticCompensating"""))_
    val ta = parse_element (element ("""GovHydroPelton.ta"""))_
    val ts = parse_element (element ("""GovHydroPelton.ts"""))_
    val tv = parse_element (element ("""GovHydroPelton.tv"""))_
    val twnc = parse_element (element ("""GovHydroPelton.twnc"""))_
    val twng = parse_element (element ("""GovHydroPelton.twng"""))_
    val tx = parse_element (element ("""GovHydroPelton.tx"""))_
    val va = parse_element (element ("""GovHydroPelton.va"""))_
    val valvmax = parse_element (element ("""GovHydroPelton.valvmax"""))_
    val valvmin = parse_element (element ("""GovHydroPelton.valvmin"""))_
    val vav = parse_element (element ("""GovHydroPelton.vav"""))_
    val vc = parse_element (element ("""GovHydroPelton.vc"""))_
    val vcv = parse_element (element ("""GovHydroPelton.vcv"""))_
    val waterTunnelSurgeChamberSimulation = parse_element (element ("""GovHydroPelton.waterTunnelSurgeChamberSimulation"""))_
    val zsfc = parse_element (element ("""GovHydroPelton.zsfc"""))_
    def parse (context: Context): GovHydroPelton =
    {
        GovHydroPelton(
            sup (context),
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
 */
case class GovHydroR
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine gain (At).
     * Typical Value = 1.2.
     */
    val at: Double,

    /**
     * Intentional dead-band width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional dead-band (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Turbine damping factor (Dturb).
     * Typical Value = 0.2.
     */
    val dturb: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Maximum governor output (Gmax).
     * Typical Value = 1.05.
     */
    val gmax: Double,

    /**
     * Minimum governor output (Gmin).
     * Typical Value = -0.05.
     */
    val gmin: Double,

    /**
     * Nonlinear gain point 1, PU gv (Gv1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain point 2, PU gv (Gv2).
     * Typical Value = 0.
     */
    val gv2: Double,

    /**
     * Nonlinear gain point 3, PU gv (Gv3).
     * Typical Value = 0.
     */
    val gv3: Double,

    /**
     * Nonlinear gain point 4, PU gv (Gv4).
     * Typical Value = 0.
     */
    val gv4: Double,

    /**
     * Nonlinear gain point 5, PU gv (Gv5).
     * Typical Value = 0.
     */
    val gv5: Double,

    /**
     * Nonlinear gain point 6, PU gv (Gv6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Turbine nominal head (H0).
     * Typical Value = 1.
     */
    val h0: Double,

    /**
     * Input signal switch (Flag).
    true = Pe input is used
    false = feedback is received from CV.
     * Flag is normally dependent on Tt.  If Tf is zero, Flag is set to false. If Tf is not zero, Flag is set to true.  Typical Value = true.
     */
    val inputSignal: Boolean,

    /**
     * Gate servo gain (Kg).
     * Typical Value = 2.
     */
    val kg: Double,

    /**
     * Integral gain (Ki).
     * Typical Value = 0.5.
     */
    val ki: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain point 1, PU power (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain point 2, PU power (Pgv2).
     * Typical Value = 0.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain point 3, PU power (Pgv3).
     * Typical Value = 0.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain point 4, PU power (Pgv4).
     * Typical Value = 0.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain point 5, PU power (Pgv5).
     * Typical Value = 0.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain point 6, PU power (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum gate opening, PU of MWbase (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum gate opening, PU of MWbase (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * No-load turbine flow at nominal head (Qnl).
     * Typical Value = 0.08.
     */
    val qnl: Double,

    /**
     * Steady-state droop (R).
     * Typical Value = 0.05.
     */
    val r: Double,

    /**
     * Lead time constant 1 (T1).
     * Typical Value = 1.5.
     */
    val t1: Double,

    /**
     * Lag time constant 1 (T2).
     * Typical Value = 0.1.
     */
    val t2: Double,

    /**
     * Lead time constant 2 (T3).
     * Typical Value = 1.5.
     */
    val t3: Double,

    /**
     * Lag time constant 2 (T4).
     * Typical Value = 0.1.
     */
    val t4: Double,

    /**
     * Lead time constant 3 (T5).
     * Typical Value = 0.
     */
    val t5: Double,

    /**
     * Lag time constant 3 (T6).
     * Typical Value = 0.05.
     */
    val t6: Double,

    /**
     * Lead time constant 4 (T7).
     * Typical Value = 0.
     */
    val t7: Double,

    /**
     * Lag time constant 4 (T8).
     * Typical Value = 0.05.
     */
    val t8: Double,

    /**
     * Input filter time constant (Td).
     * Typical Value = 0.05.
     */
    val td: Double,

    /**
     * Gate servo time constant (Tp).
     * Typical Value = 0.05.
     */
    val tp: Double,

    /**
     * Power feedback time constant (Tt).
     * Typical Value = 0.
     */
    val tt: Double,

    /**
     * Water inertia time constant (Tw).
     * Typical Value = 1.
     */
    val tw: Double,

    /**
     * Maximum gate closing velocity (Velcl).
     * Unit = PU/sec.  Typical Value = -0.2.
     */
    val velcl: Double,

    /**
     * Maximum gate opening velocity (Velop).
     * Unit = PU/sec.  Typical Value = 0.2.
     */
    val velop: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroR]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroR
extends
    Parseable[GovHydroR]
{
    val sup = TurbineGovernorDynamics.parse _
    val at = parse_element (element ("""GovHydroR.at"""))_
    val db1 = parse_element (element ("""GovHydroR.db1"""))_
    val db2 = parse_element (element ("""GovHydroR.db2"""))_
    val dturb = parse_element (element ("""GovHydroR.dturb"""))_
    val eps = parse_element (element ("""GovHydroR.eps"""))_
    val gmax = parse_element (element ("""GovHydroR.gmax"""))_
    val gmin = parse_element (element ("""GovHydroR.gmin"""))_
    val gv1 = parse_element (element ("""GovHydroR.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroR.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroR.gv3"""))_
    val gv4 = parse_element (element ("""GovHydroR.gv4"""))_
    val gv5 = parse_element (element ("""GovHydroR.gv5"""))_
    val gv6 = parse_element (element ("""GovHydroR.gv6"""))_
    val h0 = parse_element (element ("""GovHydroR.h0"""))_
    val inputSignal = parse_element (element ("""GovHydroR.inputSignal"""))_
    val kg = parse_element (element ("""GovHydroR.kg"""))_
    val ki = parse_element (element ("""GovHydroR.ki"""))_
    val mwbase = parse_element (element ("""GovHydroR.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydroR.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydroR.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydroR.pgv3"""))_
    val pgv4 = parse_element (element ("""GovHydroR.pgv4"""))_
    val pgv5 = parse_element (element ("""GovHydroR.pgv5"""))_
    val pgv6 = parse_element (element ("""GovHydroR.pgv6"""))_
    val pmax = parse_element (element ("""GovHydroR.pmax"""))_
    val pmin = parse_element (element ("""GovHydroR.pmin"""))_
    val qnl = parse_element (element ("""GovHydroR.qnl"""))_
    val r = parse_element (element ("""GovHydroR.r"""))_
    val t1 = parse_element (element ("""GovHydroR.t1"""))_
    val t2 = parse_element (element ("""GovHydroR.t2"""))_
    val t3 = parse_element (element ("""GovHydroR.t3"""))_
    val t4 = parse_element (element ("""GovHydroR.t4"""))_
    val t5 = parse_element (element ("""GovHydroR.t5"""))_
    val t6 = parse_element (element ("""GovHydroR.t6"""))_
    val t7 = parse_element (element ("""GovHydroR.t7"""))_
    val t8 = parse_element (element ("""GovHydroR.t8"""))_
    val td = parse_element (element ("""GovHydroR.td"""))_
    val tp = parse_element (element ("""GovHydroR.tp"""))_
    val tt = parse_element (element ("""GovHydroR.tt"""))_
    val tw = parse_element (element ("""GovHydroR.tw"""))_
    val velcl = parse_element (element ("""GovHydroR.velcl"""))_
    val velop = parse_element (element ("""GovHydroR.velop"""))_
    def parse (context: Context): GovHydroR =
    {
        GovHydroR(
            sup (context),
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
 */
case class GovHydroWEH
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Speed Dead Band (db).
     */
    val db: Double,

    /**
     * Value to allow the integral controller to advance beyond the gate limits (Dicn).
     */
    val dicn: Double,

    /**
     * Value to allow the Pilot valve controller to advance beyond the gate limits (Dpv).
     */
    val dpv: Double,

    /**
     * Turbine damping factor (Dturb).
     * Unit = delta P (PU of MWbase) / delta speed (PU).
     */
    val dturb: Double,

    /**
     * Feedback signal selection (Sw).
    true = PID Output (if R-Perm-Gate=droop and R-Perm-Pe=0)
    false = Electrical Power (if R-Perm-Gate=0 and R-Perm-Pe=droop) or
     * false = Gate Position (if R-Perm-Gate=droop and R-Perm-Pe=0).
     */
    val feedbackSignal: Boolean,

    /**
     * Flow Gate 1 (Fl1).
     * Flow value for gate position point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val fl1: Double,

    /**
     * Flow Gate 2 (Fl2).
     * Flow value for gate position point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val fl2: Double,

    /**
     * Flow Gate 3 (Fl3).
     * Flow value for gate position point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val fl3: Double,

    /**
     * Flow Gate 4 (Fl4).
     * Flow value for gate position point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val fl4: Double,

    /**
     * Flow Gate 5 (Fl5).
     * Flow value for gate position point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val fl5: Double,

    /**
     * Flow P1 (Fp1).
     * Turbine Flow value for point 1 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp1: Double,

    /**
     * Flow P10 (Fp10).
     * Turbine Flow value for point 10 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp10: Double,

    /**
     * Flow P2 (Fp2).
     * Turbine Flow value for point 2 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp2: Double,

    /**
     * Flow P3 (Fp3).
     * Turbine Flow value for point 3 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp3: Double,

    /**
     * Flow P4 (Fp4).
     * Turbine Flow value for point 4 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp4: Double,

    /**
     * Flow P5 (Fp5).
     * Turbine Flow value for point 5 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp5: Double,

    /**
     * Flow P6 (Fp6).
     * Turbine Flow value for point 6 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp6: Double,

    /**
     * Flow P7 (Fp7).
     * Turbine Flow value for point 7 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp7: Double,

    /**
     * Flow P8 (Fp8).
     * Turbine Flow value for point 8 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp8: Double,

    /**
     * Flow P9 (Fp9).
     * Turbine Flow value for point 9 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val fp9: Double,

    /**
     * Maximum Gate Position (Gmax).
     */
    val gmax: Double,

    /**
     * Minimum Gate Position (Gmin).
     */
    val gmin: Double,

    /**
     * Maximum gate closing rate (Gtmxcl).
     */
    val gtmxcl: Double,

    /**
     * Maximum gate opening rate (Gtmxop).
     */
    val gtmxop: Double,

    /**
     * Gate 1 (Gv1).
     * Gate Position value for point 1 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val gv1: Double,

    /**
     * Gate 2 (Gv2).
     * Gate Position value for point 2 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val gv2: Double,

    /**
     * Gate 3 (Gv3).
     * Gate Position value for point 3 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val gv3: Double,

    /**
     * Gate 4 (Gv4).
     * Gate Position value for point 4 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val gv4: Double,

    /**
     * Gate 5 (Gv5).
     * Gate Position value for point 5 for lookup table representing water flow through the turbine as a function of gate position to produce steady state flow.
     */
    val gv5: Double,

    /**
     * Derivative controller derivative gain (Kd).
     */
    val kd: Double,

    /**
     * Derivative controller Integral gain (Ki).
     */
    val ki: Double,

    /**
     * Derivative control gain (Kp).
     */
    val kp: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Pmss Flow P1 (Pmss1).
     * Mechanical Power output Pmss for Turbine Flow point 1 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss1: Double,

    /**
     * Pmss Flow P10 (Pmss10).
     * Mechanical Power output Pmss for Turbine Flow point 10 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss10: Double,

    /**
     * Pmss Flow P2 (Pmss2).
     * Mechanical Power output Pmss for Turbine Flow point 2 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss2: Double,

    /**
     * Pmss Flow P3 (Pmss3).
     * Mechanical Power output Pmss for Turbine Flow point 3 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss3: Double,

    /**
     * Pmss Flow P4 (Pmss4).
     * Mechanical Power output Pmss for Turbine Flow point 4 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss4: Double,

    /**
     * Pmss Flow P5 (Pmss5).
     * Mechanical Power output Pmss for Turbine Flow point 5 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss5: Double,

    /**
     * Pmss Flow P6 (Pmss6).
     * Mechanical Power output Pmss for Turbine Flow point 6 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss6: Double,

    /**
     * Pmss Flow P7 (Pmss7).
     * Mechanical Power output Pmss for Turbine Flow point 7 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss7: Double,

    /**
     * Pmss Flow P8 (Pmss8).
     * Mechanical Power output Pmss for Turbine Flow point 8 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss8: Double,

    /**
     * Pmss Flow P9 (Pmss9).
     * Mechanical Power output Pmss for Turbine Flow point 9 for lookup table representing per unit mechanical power on machine MVA rating as a function of turbine flow.
     */
    val pmss9: Double,

    /**
     * Permanent droop for governor output feedback (R-Perm-Gate).
     */
    val rpg: Double,

    /**
     * Permanent droop for electrical power feedback (R-Perm-Pe).
     */
    val rpp: Double,

    /**
     * Derivative controller time constant to limit the derivative characteristic beyond a breakdown frequency to avoid amplification of high-frequency noise (Td).
     */
    val td: Double,

    /**
     * Distributive Valve time lag time constant (Tdv).
     */
    val tdv: Double,

    /**
     * Value to allow the Distribution valve controller to advance beyond the gate movement rate limit (Tg).
     */
    val tg: Double,

    /**
     * Pilot Valve time lag time constant (Tp).
     */
    val tp: Double,

    /**
     * Electrical power droop time constant (Tpe).
     */
    val tpe: Double,

    /**
     * Water inertia time constant (Tw) (&gt;0).
     */
    val tw: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroWEH]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroWEH
extends
    Parseable[GovHydroWEH]
{
    val sup = TurbineGovernorDynamics.parse _
    val db = parse_element (element ("""GovHydroWEH.db"""))_
    val dicn = parse_element (element ("""GovHydroWEH.dicn"""))_
    val dpv = parse_element (element ("""GovHydroWEH.dpv"""))_
    val dturb = parse_element (element ("""GovHydroWEH.dturb"""))_
    val feedbackSignal = parse_element (element ("""GovHydroWEH.feedbackSignal"""))_
    val fl1 = parse_element (element ("""GovHydroWEH.fl1"""))_
    val fl2 = parse_element (element ("""GovHydroWEH.fl2"""))_
    val fl3 = parse_element (element ("""GovHydroWEH.fl3"""))_
    val fl4 = parse_element (element ("""GovHydroWEH.fl4"""))_
    val fl5 = parse_element (element ("""GovHydroWEH.fl5"""))_
    val fp1 = parse_element (element ("""GovHydroWEH.fp1"""))_
    val fp10 = parse_element (element ("""GovHydroWEH.fp10"""))_
    val fp2 = parse_element (element ("""GovHydroWEH.fp2"""))_
    val fp3 = parse_element (element ("""GovHydroWEH.fp3"""))_
    val fp4 = parse_element (element ("""GovHydroWEH.fp4"""))_
    val fp5 = parse_element (element ("""GovHydroWEH.fp5"""))_
    val fp6 = parse_element (element ("""GovHydroWEH.fp6"""))_
    val fp7 = parse_element (element ("""GovHydroWEH.fp7"""))_
    val fp8 = parse_element (element ("""GovHydroWEH.fp8"""))_
    val fp9 = parse_element (element ("""GovHydroWEH.fp9"""))_
    val gmax = parse_element (element ("""GovHydroWEH.gmax"""))_
    val gmin = parse_element (element ("""GovHydroWEH.gmin"""))_
    val gtmxcl = parse_element (element ("""GovHydroWEH.gtmxcl"""))_
    val gtmxop = parse_element (element ("""GovHydroWEH.gtmxop"""))_
    val gv1 = parse_element (element ("""GovHydroWEH.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroWEH.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroWEH.gv3"""))_
    val gv4 = parse_element (element ("""GovHydroWEH.gv4"""))_
    val gv5 = parse_element (element ("""GovHydroWEH.gv5"""))_
    val kd = parse_element (element ("""GovHydroWEH.kd"""))_
    val ki = parse_element (element ("""GovHydroWEH.ki"""))_
    val kp = parse_element (element ("""GovHydroWEH.kp"""))_
    val mwbase = parse_element (element ("""GovHydroWEH.mwbase"""))_
    val pmss1 = parse_element (element ("""GovHydroWEH.pmss1"""))_
    val pmss10 = parse_element (element ("""GovHydroWEH.pmss10"""))_
    val pmss2 = parse_element (element ("""GovHydroWEH.pmss2"""))_
    val pmss3 = parse_element (element ("""GovHydroWEH.pmss3"""))_
    val pmss4 = parse_element (element ("""GovHydroWEH.pmss4"""))_
    val pmss5 = parse_element (element ("""GovHydroWEH.pmss5"""))_
    val pmss6 = parse_element (element ("""GovHydroWEH.pmss6"""))_
    val pmss7 = parse_element (element ("""GovHydroWEH.pmss7"""))_
    val pmss8 = parse_element (element ("""GovHydroWEH.pmss8"""))_
    val pmss9 = parse_element (element ("""GovHydroWEH.pmss9"""))_
    val rpg = parse_element (element ("""GovHydroWEH.rpg"""))_
    val rpp = parse_element (element ("""GovHydroWEH.rpp"""))_
    val td = parse_element (element ("""GovHydroWEH.td"""))_
    val tdv = parse_element (element ("""GovHydroWEH.tdv"""))_
    val tg = parse_element (element ("""GovHydroWEH.tg"""))_
    val tp = parse_element (element ("""GovHydroWEH.tp"""))_
    val tpe = parse_element (element ("""GovHydroWEH.tpe"""))_
    val tw = parse_element (element ("""GovHydroWEH.tw"""))_
    def parse (context: Context): GovHydroWEH =
    {
        GovHydroWEH(
            sup (context),
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
 */
case class GovHydroWPID
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine damping factor (D).
     * Unit = delta P / delta speed.
     */
    val d: Double,

    /**
     * Gate opening Limit Maximum (Gatmax).
     */
    val gatmax: Double,

    /**
     * Gate opening Limit Minimum (Gatmin).
     */
    val gatmin: Double,

    /**
     * Gate position 1 (Gv1).
     */
    val gv1: Double,

    /**
     * Gate position 2 (Gv2).
     */
    val gv2: Double,

    /**
     * Gate position 3 (Gv3).
     */
    val gv3: Double,

    /**
     * Derivative gain (Kd).
     * Typical Value = 1.11.
     */
    val kd: Double,

    /**
     * Reset gain (Ki).
     * Typical Value = 0.36.
     */
    val ki: Double,

    /**
     * Proportional gain (Kp).
     * Typical Value = 0.1.
     */
    val kp: Double,

    /**
     * Base for power values  (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Output at Gv1 PU of MWbase (Pgv1).
     */
    val pgv1: Double,

    /**
     * Output at Gv2 PU of MWbase (Pgv2).
     */
    val pgv2: Double,

    /**
     * Output at Gv3 PU of MWbase (Pgv3).
     */
    val pgv3: Double,

    /**
     * Maximum Power Output (Pmax).
     */
    val pmax: Double,

    /**
     * Minimum Power Output (Pmin).
     */
    val pmin: Double,

    /**
     * Permanent drop (Reg).
     */
    val reg: Double,

    /**
     * Controller time constant (Ta) (&gt;0).
     * Typical Value = 0.
     */
    val ta: Double,

    /**
     * Gate servo time constant (Tb) (&gt;0).
     * Typical Value = 0.
     */
    val tb: Double,

    /**
     * Speed detector time constant (Treg).
     */
    val treg: Double,

    /**
     * Water inertia time constant (Tw) (&gt;0).
     * Typical Value = 0.
     */
    val tw: Double,

    /**
     * Maximum gate opening velocity (Velmax).
     * Unit = PU/sec.  Typical Value = 0.
     */
    val velmax: Double,

    /**
     * Maximum gate closing velocity (Velmin).
     * Unit = PU/sec.  Typical Value = 0.
     */
    val velmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovHydroWPID]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovHydroWPID
extends
    Parseable[GovHydroWPID]
{
    val sup = TurbineGovernorDynamics.parse _
    val d = parse_element (element ("""GovHydroWPID.d"""))_
    val gatmax = parse_element (element ("""GovHydroWPID.gatmax"""))_
    val gatmin = parse_element (element ("""GovHydroWPID.gatmin"""))_
    val gv1 = parse_element (element ("""GovHydroWPID.gv1"""))_
    val gv2 = parse_element (element ("""GovHydroWPID.gv2"""))_
    val gv3 = parse_element (element ("""GovHydroWPID.gv3"""))_
    val kd = parse_element (element ("""GovHydroWPID.kd"""))_
    val ki = parse_element (element ("""GovHydroWPID.ki"""))_
    val kp = parse_element (element ("""GovHydroWPID.kp"""))_
    val mwbase = parse_element (element ("""GovHydroWPID.mwbase"""))_
    val pgv1 = parse_element (element ("""GovHydroWPID.pgv1"""))_
    val pgv2 = parse_element (element ("""GovHydroWPID.pgv2"""))_
    val pgv3 = parse_element (element ("""GovHydroWPID.pgv3"""))_
    val pmax = parse_element (element ("""GovHydroWPID.pmax"""))_
    val pmin = parse_element (element ("""GovHydroWPID.pmin"""))_
    val reg = parse_element (element ("""GovHydroWPID.reg"""))_
    val ta = parse_element (element ("""GovHydroWPID.ta"""))_
    val tb = parse_element (element ("""GovHydroWPID.tb"""))_
    val treg = parse_element (element ("""GovHydroWPID.treg"""))_
    val tw = parse_element (element ("""GovHydroWPID.tw"""))_
    val velmax = parse_element (element ("""GovHydroWPID.velmax"""))_
    val velmin = parse_element (element ("""GovHydroWPID.velmin"""))_
    def parse (context: Context): GovHydroWPID =
    {
        GovHydroWPID(
            sup (context),
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
 */
case class GovSteam0
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Turbine damping coefficient (Dt).
     * Unit = delta P / delta speed. Typical Value = 0.
     */
    val dt: Double,

    /**
     * Base for power values (MWbase)  (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Permanent droop (R).
     * Typical Value = 0.05.
     */
    val r: Double,

    /**
     * Steam bowl time constant (T1).
     * Typical Value = 0.5.
     */
    val t1: Double,

    /**
     * Numerator time constant of T2/T3 block (T2).
     * Typical Value = 3.
     */
    val t2: Double,

    /**
     * Reheater time constant (T3).
     * Typical Value = 10.
     */
    val t3: Double,

    /**
     * Maximum valve position, PU of mwcap (Vmax).
     * Typical Value = 1.
     */
    val vmax: Double,

    /**
     * Minimum valve position, PU of mwcap (Vmin).
     * Typical Value = 0.
     */
    val vmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteam0]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteam0
extends
    Parseable[GovSteam0]
{
    val sup = TurbineGovernorDynamics.parse _
    val dt = parse_element (element ("""GovSteam0.dt"""))_
    val mwbase = parse_element (element ("""GovSteam0.mwbase"""))_
    val r = parse_element (element ("""GovSteam0.r"""))_
    val t1 = parse_element (element ("""GovSteam0.t1"""))_
    val t2 = parse_element (element ("""GovSteam0.t2"""))_
    val t3 = parse_element (element ("""GovSteam0.t3"""))_
    val vmax = parse_element (element ("""GovSteam0.vmax"""))_
    val vmin = parse_element (element ("""GovSteam0.vmin"""))_
    def parse (context: Context): GovSteam0 =
    {
        GovSteam0(
            sup (context),
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
 */
case class GovSteam1
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Intentional deadband width (db1).
     * Unit = Hz.  Typical Value = 0.
     */
    val db1: Double,

    /**
     * Unintentional deadband (db2).
     * Unit = MW.  Typical Value = 0.
     */
    val db2: Double,

    /**
     * Intentional db hysteresis (eps).
     * Unit = Hz.  Typical Value = 0.
     */
    val eps: Double,

    /**
     * Nonlinear gain valve position point 1 (GV1).
     * Typical Value = 0.
     */
    val gv1: Double,

    /**
     * Nonlinear gain valve position point 2 (GV2).
     * Typical Value = 0.4.
     */
    val gv2: Double,

    /**
     * Nonlinear gain valve position point 3 (GV3).
     * Typical Value = 0.5.
     */
    val gv3: Double,

    /**
     * Nonlinear gain valve position point 4 (GV4).
     * Typical Value = 0.6.
     */
    val gv4: Double,

    /**
     * Nonlinear gain valve position point 5 (GV5).
     * Typical Value = 1.
     */
    val gv5: Double,

    /**
     * Nonlinear gain valve position point 6 (GV6).
     * Typical Value = 0.
     */
    val gv6: Double,

    /**
     * Governor gain (reciprocal of droop) (K) (&gt;0).
     * Typical Value = 25.
     */
    val k: Double,

    /**
     * Fraction of HP shaft power after first boiler pass (K1).
     * Typical Value = 0.2.
     */
    val k1: Double,

    /**
     * Fraction of LP shaft power after first boiler pass (K2).
     * Typical Value = 0.
     */
    val k2: Double,

    /**
     * Fraction of HP shaft power after second boiler pass (K3).
     * Typical Value = 0.3.
     */
    val k3: Double,

    /**
     * Fraction of LP shaft power after second boiler pass (K4).
     * Typical Value = 0.
     */
    val k4: Double,

    /**
     * Fraction of HP shaft power after third boiler pass (K5).
     * Typical Value = 0.5.
     */
    val k5: Double,

    /**
     * Fraction of LP shaft power after third boiler pass (K6).
     * Typical Value = 0.
     */
    val k6: Double,

    /**
     * Fraction of HP shaft power after fourth boiler pass (K7).
     * Typical Value = 0.
     */
    val k7: Double,

    /**
     * Fraction of LP shaft power after fourth boiler pass (K8).
     * Typical Value = 0.
     */
    val k8: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Nonlinear gain power value point 1 (Pgv1).
     * Typical Value = 0.
     */
    val pgv1: Double,

    /**
     * Nonlinear gain power value point 2 (Pgv2).
     * Typical Value = 0.75.
     */
    val pgv2: Double,

    /**
     * Nonlinear gain power value point 3 (Pgv3).
     * Typical Value = 0.91.
     */
    val pgv3: Double,

    /**
     * Nonlinear gain power value point 4 (Pgv4).
     * Typical Value = 0.98.
     */
    val pgv4: Double,

    /**
     * Nonlinear gain power value point 5 (Pgv5).
     * Typical Value = 1.
     */
    val pgv5: Double,

    /**
     * Nonlinear gain power value point 6 (Pgv6).
     * Typical Value = 0.
     */
    val pgv6: Double,

    /**
     * Maximum valve opening (Pmax) (&gt; Pmin).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum valve opening (Pmin) (&gt;=0).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Intentional deadband indicator.
    true = intentional deadband is applied
    false = intentional deadband is not applied.
     * Typical Value = true.
     */
    val sdb1: Boolean,

    /**
     * Unintentional deadband location.
    true = intentional deadband is applied before point "A"
    false = intentional deadband is applied after point "A".
     * Typical Value = true.
     */
    val sdb2: Boolean,

    /**
     * Governor lag time constant (T1).
     * Typical Value = 0.
     */
    val t1: Double,

    /**
     * Governor lead time constant (T2).
     * Typical Value = 0.
     */
    val t2: Double,

    /**
     * Valve positioner time constant (T3<i>) </i>(&gt;0).
     * Typical Value = 0.1.
     */
    val t3: Double,

    /**
     * Inlet piping/steam bowl time constant (T4).
     * Typical Value = 0.3.
     */
    val t4: Double,

    /**
     * Time constant of second boiler pass (T5).
     * Typical Value = 5.
     */
    val t5: Double,

    /**
     * Time constant of third boiler pass (T6).
     * Typical Value = 0.5.
     */
    val t6: Double,

    /**
     * Time constant of fourth boiler pass (T7).
     * Typical Value = 0.
     */
    val t7: Double,

    /**
     * Maximum valve closing velocity (Uc) (&lt;0).
     * Unit = PU/sec.  Typical Value = -10.
     */
    val uc: Double,

    /**
     * Maximum valve opening velocity (Uo) (&gt;0).
     * Unit = PU/sec.  Typical Value = 1.
     */
    val uo: Double,

    /**
     * Nonlinear valve characteristic.
    true = nonlinear valve characteristic is used
    false = nonlinear valve characteristic is not used.
     * Typical Value = true.
     */
    val valve: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteam1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteam1
extends
    Parseable[GovSteam1]
{
    val sup = TurbineGovernorDynamics.parse _
    val db1 = parse_element (element ("""GovSteam1.db1"""))_
    val db2 = parse_element (element ("""GovSteam1.db2"""))_
    val eps = parse_element (element ("""GovSteam1.eps"""))_
    val gv1 = parse_element (element ("""GovSteam1.gv1"""))_
    val gv2 = parse_element (element ("""GovSteam1.gv2"""))_
    val gv3 = parse_element (element ("""GovSteam1.gv3"""))_
    val gv4 = parse_element (element ("""GovSteam1.gv4"""))_
    val gv5 = parse_element (element ("""GovSteam1.gv5"""))_
    val gv6 = parse_element (element ("""GovSteam1.gv6"""))_
    val k = parse_element (element ("""GovSteam1.k"""))_
    val k1 = parse_element (element ("""GovSteam1.k1"""))_
    val k2 = parse_element (element ("""GovSteam1.k2"""))_
    val k3 = parse_element (element ("""GovSteam1.k3"""))_
    val k4 = parse_element (element ("""GovSteam1.k4"""))_
    val k5 = parse_element (element ("""GovSteam1.k5"""))_
    val k6 = parse_element (element ("""GovSteam1.k6"""))_
    val k7 = parse_element (element ("""GovSteam1.k7"""))_
    val k8 = parse_element (element ("""GovSteam1.k8"""))_
    val mwbase = parse_element (element ("""GovSteam1.mwbase"""))_
    val pgv1 = parse_element (element ("""GovSteam1.pgv1"""))_
    val pgv2 = parse_element (element ("""GovSteam1.pgv2"""))_
    val pgv3 = parse_element (element ("""GovSteam1.pgv3"""))_
    val pgv4 = parse_element (element ("""GovSteam1.pgv4"""))_
    val pgv5 = parse_element (element ("""GovSteam1.pgv5"""))_
    val pgv6 = parse_element (element ("""GovSteam1.pgv6"""))_
    val pmax = parse_element (element ("""GovSteam1.pmax"""))_
    val pmin = parse_element (element ("""GovSteam1.pmin"""))_
    val sdb1 = parse_element (element ("""GovSteam1.sdb1"""))_
    val sdb2 = parse_element (element ("""GovSteam1.sdb2"""))_
    val t1 = parse_element (element ("""GovSteam1.t1"""))_
    val t2 = parse_element (element ("""GovSteam1.t2"""))_
    val t3 = parse_element (element ("""GovSteam1.t3"""))_
    val t4 = parse_element (element ("""GovSteam1.t4"""))_
    val t5 = parse_element (element ("""GovSteam1.t5"""))_
    val t6 = parse_element (element ("""GovSteam1.t6"""))_
    val t7 = parse_element (element ("""GovSteam1.t7"""))_
    val uc = parse_element (element ("""GovSteam1.uc"""))_
    val uo = parse_element (element ("""GovSteam1.uo"""))_
    val valve = parse_element (element ("""GovSteam1.valve"""))_
    def parse (context: Context): GovSteam1 =
    {
        GovSteam1(
            sup (context),
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
 */
case class GovSteam2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Frequency dead band (DBF).
     * Typical Value = 0.
     */
    val dbf: Double,

    /**
     * Governor gain (reciprocal of droop) (K).
     * Typical Value = 20.
     */
    val k: Double,

    /**
     * Fuel flow maximum negative error value (MN<sub>EF</sub>).
     * Typical Value = -1.
     */
    val mnef: Double,

    /**
     * Fuel flow maximum positive error value (MX<sub>EF</sub>).
     * Typical Value = 1.
     */
    val mxef: Double,

    /**
     * Maximum fuel flow (P<sub>MAX</sub>).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum fuel flow (P<sub>MIN</sub>).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Governor lag time constant (T<sub>1</sub>) (&gt;0).
     * Typical Value = 0.45.
     */
    val t1: Double,

    /**
     * Governor lead time constant (T<sub>2</sub>) (may be 0).
     * Typical Value = 0.
     */
    val t2: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteam2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteam2
extends
    Parseable[GovSteam2]
{
    val sup = TurbineGovernorDynamics.parse _
    val dbf = parse_element (element ("""GovSteam2.dbf"""))_
    val k = parse_element (element ("""GovSteam2.k"""))_
    val mnef = parse_element (element ("""GovSteam2.mnef"""))_
    val mxef = parse_element (element ("""GovSteam2.mxef"""))_
    val pmax = parse_element (element ("""GovSteam2.pmax"""))_
    val pmin = parse_element (element ("""GovSteam2.pmin"""))_
    val t1 = parse_element (element ("""GovSteam2.t1"""))_
    val t2 = parse_element (element ("""GovSteam2.t2"""))_
    def parse (context: Context): GovSteam2 =
    {
        GovSteam2(
            sup (context),
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
 */
case class GovSteamCC
(

    override val sup: TurbineGovernorDynamics,

    /**
     * HP damping factor (Dhp).
     * Typical Value = 0.
     */
    val dhp: Double,

    /**
     * LP damping factor (Dlp).
     * Typical Value = 0.
     */
    val dlp: Double,

    /**
     * Fraction of HP power ahead of reheater (Fhp).
     * Typical Value = 0.3.
     */
    val fhp: Double,

    /**
     * Fraction of LP power ahead of reheater (Flp).
     * Typical Value = 0.7.
     */
    val flp: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Maximum HP value position (Pmaxhp).
     * Typical Value = 1.
     */
    val pmaxhp: Double,

    /**
     * Maximum LP value position (Pmaxlp).
     * Typical Value = 1.
     */
    val pmaxlp: Double,

    /**
     * HP governor droop (Rhp).
     * Typical Value = 0.05.
     */
    val rhp: Double,

    /**
     * LP governor droop (Rlp).
     * Typical Value = 0.05.
     */
    val rlp: Double,

    /**
     * HP governor time constant (T1hp).
     * Typical Value = 0.1.
     */
    val t1hp: Double,

    /**
     * LP governor time constant (T1lp).
     * Typical Value = 0.1.
     */
    val t1lp: Double,

    /**
     * HP turbine time constant (T3hp).
     * Typical Value = 0.1.
     */
    val t3hp: Double,

    /**
     * LP turbine time constant (T3lp).
     * Typical Value = 0.1.
     */
    val t3lp: Double,

    /**
     * HP turbine time constant (T4hp).
     * Typical Value = 0.1.
     */
    val t4hp: Double,

    /**
     * LP turbine time constant (T4lp).
     * Typical Value = 0.1.
     */
    val t4lp: Double,

    /**
     * HP reheater time constant (T5hp).
     * Typical Value = 10.
     */
    val t5hp: Double,

    /**
     * LP reheater time constant (T5lp).
     * Typical Value = 10.
     */
    val t5lp: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamCC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamCC
extends
    Parseable[GovSteamCC]
{
    val sup = TurbineGovernorDynamics.parse _
    val dhp = parse_element (element ("""GovSteamCC.dhp"""))_
    val dlp = parse_element (element ("""GovSteamCC.dlp"""))_
    val fhp = parse_element (element ("""GovSteamCC.fhp"""))_
    val flp = parse_element (element ("""GovSteamCC.flp"""))_
    val mwbase = parse_element (element ("""GovSteamCC.mwbase"""))_
    val pmaxhp = parse_element (element ("""GovSteamCC.pmaxhp"""))_
    val pmaxlp = parse_element (element ("""GovSteamCC.pmaxlp"""))_
    val rhp = parse_element (element ("""GovSteamCC.rhp"""))_
    val rlp = parse_element (element ("""GovSteamCC.rlp"""))_
    val t1hp = parse_element (element ("""GovSteamCC.t1hp"""))_
    val t1lp = parse_element (element ("""GovSteamCC.t1lp"""))_
    val t3hp = parse_element (element ("""GovSteamCC.t3hp"""))_
    val t3lp = parse_element (element ("""GovSteamCC.t3lp"""))_
    val t4hp = parse_element (element ("""GovSteamCC.t4hp"""))_
    val t4lp = parse_element (element ("""GovSteamCC.t4lp"""))_
    val t5hp = parse_element (element ("""GovSteamCC.t5hp"""))_
    val t5lp = parse_element (element ("""GovSteamCC.t5lp"""))_
    def parse (context: Context): GovSteamCC =
    {
        GovSteamCC(
            sup (context),
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
 */
case class GovSteamEU
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Control valves rate closing limit (Chc).
     * Unit = PU/sec.  Typical Value = -3.3.
     */
    val chc: Double,

    /**
     * Control valves rate opening limit (Cho).
     * Unit = PU/sec.  Typical Value = 0.17.
     */
    val cho: Double,

    /**
     * Intercept valves rate closing limit (Cic).
     * Typical Value = -2.2.
     */
    val cic: Double,

    /**
     * Intercept valves rate opening limit (Cio).
     * Typical Value = 0.123.
     */
    val cio: Double,

    /**
     * Dead band of the frequency corrector (db1).
     * Typical Value = 0.
     */
    val db1: Double,

    /**
     * Dead band of the speed governor (db2).
     * Typical Value = 0.0004.
     */
    val db2: Double,

    /**
     * Maximum control valve position (Hhpmax).
     * Typical Value = 1.
     */
    val hhpmax: Double,

    /**
     * Gain of the power controller (Ke).
     * Typical Value = 0.65.
     */
    val ke: Double,

    /**
     * Gain of the frequency corrector (Kfcor).
     * Typical Value = 20.
     */
    val kfcor: Double,

    /**
     * Fraction of total turbine output generated by HP part (Khp).
     * Typical Value = 0.277.
     */
    val khp: Double,

    /**
     * Fraction of total turbine output generated by HP part (Klp).
     * Typical Value = 0.723.
     */
    val klp: Double,

    /**
     * Gain of the speed governor (Kwcor).
     * Typical Value = 20.
     */
    val kwcor: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Maximal active power of the turbine (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Maximum low pressure limit (Prhmax).
     * Typical Value = 1.4.
     */
    val prhmax: Double,

    /**
     * Intercept valves transfer limit (Simx).
     * Typical Value = 0.425.
     */
    val simx: Double,

    /**
     * Boiler time constant (Tb).
     * Typical Value = 100.
     */
    val tb: Double,

    /**
     * Derivative time constant of the power controller (Tdp).
     * Typical Value = 0.
     */
    val tdp: Double,

    /**
     * Electro hydraulic transducer (Ten).
     * Typical Value = 0.1.
     */
    val ten: Double,

    /**
     * Frequency transducer time constant (Tf).
     * Typical Value = 0.
     */
    val tf: Double,

    /**
     * Time constant of the power controller (Tfp).
     * Typical Value = 0.
     */
    val tfp: Double,

    /**
     * High pressure (HP) time constant of the turbine (Thp).
     * Typical Value = 0.31.
     */
    val thp: Double,

    /**
     * Integral time constant of the power controller (Tip).
     * Typical Value = 2.
     */
    val tip: Double,

    /**
     * Low pressure(LP) time constant of the turbine (Tlp).
     * Typical Value = 0.45.
     */
    val tlp: Double,

    /**
     * Power transducer time constant (Tp).
     * Typical Value = 0.07.
     */
    val tp: Double,

    /**
     * Reheater  time constant of the turbine (Trh).
     * Typical Value = 8.
     */
    val trh: Double,

    /**
     * Control valves servo time constant (Tvhp).
     * Typical Value = 0.1.
     */
    val tvhp: Double,

    /**
     * Intercept valves servo time constant (Tvip).
     * Typical Value = 0.15.
     */
    val tvip: Double,

    /**
     * Speed transducer time constant (Tw).
     * Typical Value = 0.02.
     */
    val tw: Double,

    /**
     * Upper limit for frequency correction (Wfmax).
     * Typical Value = 0.05.
     */
    val wfmax: Double,

    /**
     * Lower limit for frequency correction (Wfmin).
     * Typical Value = -0.05.
     */
    val wfmin: Double,

    /**
     * Emergency speed control lower limit (wmax1).
     * Typical Value = 1.025.
     */
    val wmax1: Double,

    /**
     * Emergency speed control upper limit (wmax2).
     * Typical Value = 1.05.
     */
    val wmax2: Double,

    /**
     * Upper limit for the speed governor (Wwmax).
     * Typical Value = 0.1.
     */
    val wwmax: Double,

    /**
     * Lower limit for the speed governor frequency correction (Wwmin).
     * Typical Value = -1.
     */
    val wwmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamEU]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamEU
extends
    Parseable[GovSteamEU]
{
    val sup = TurbineGovernorDynamics.parse _
    val chc = parse_element (element ("""GovSteamEU.chc"""))_
    val cho = parse_element (element ("""GovSteamEU.cho"""))_
    val cic = parse_element (element ("""GovSteamEU.cic"""))_
    val cio = parse_element (element ("""GovSteamEU.cio"""))_
    val db1 = parse_element (element ("""GovSteamEU.db1"""))_
    val db2 = parse_element (element ("""GovSteamEU.db2"""))_
    val hhpmax = parse_element (element ("""GovSteamEU.hhpmax"""))_
    val ke = parse_element (element ("""GovSteamEU.ke"""))_
    val kfcor = parse_element (element ("""GovSteamEU.kfcor"""))_
    val khp = parse_element (element ("""GovSteamEU.khp"""))_
    val klp = parse_element (element ("""GovSteamEU.klp"""))_
    val kwcor = parse_element (element ("""GovSteamEU.kwcor"""))_
    val mwbase = parse_element (element ("""GovSteamEU.mwbase"""))_
    val pmax = parse_element (element ("""GovSteamEU.pmax"""))_
    val prhmax = parse_element (element ("""GovSteamEU.prhmax"""))_
    val simx = parse_element (element ("""GovSteamEU.simx"""))_
    val tb = parse_element (element ("""GovSteamEU.tb"""))_
    val tdp = parse_element (element ("""GovSteamEU.tdp"""))_
    val ten = parse_element (element ("""GovSteamEU.ten"""))_
    val tf = parse_element (element ("""GovSteamEU.tf"""))_
    val tfp = parse_element (element ("""GovSteamEU.tfp"""))_
    val thp = parse_element (element ("""GovSteamEU.thp"""))_
    val tip = parse_element (element ("""GovSteamEU.tip"""))_
    val tlp = parse_element (element ("""GovSteamEU.tlp"""))_
    val tp = parse_element (element ("""GovSteamEU.tp"""))_
    val trh = parse_element (element ("""GovSteamEU.trh"""))_
    val tvhp = parse_element (element ("""GovSteamEU.tvhp"""))_
    val tvip = parse_element (element ("""GovSteamEU.tvip"""))_
    val tw = parse_element (element ("""GovSteamEU.tw"""))_
    val wfmax = parse_element (element ("""GovSteamEU.wfmax"""))_
    val wfmin = parse_element (element ("""GovSteamEU.wfmin"""))_
    val wmax1 = parse_element (element ("""GovSteamEU.wmax1"""))_
    val wmax2 = parse_element (element ("""GovSteamEU.wmax2"""))_
    val wwmax = parse_element (element ("""GovSteamEU.wwmax"""))_
    val wwmin = parse_element (element ("""GovSteamEU.wwmin"""))_
    def parse (context: Context): GovSteamEU =
    {
        GovSteamEU(
            sup (context),
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
 */
case class GovSteamFV2
(

    override val sup: TurbineGovernorDynamics,

    /**
     * (Dt).
     */
    val dt: Double,

    /**
     * Fraction of the turbine power developed by turbine sections not involved in fast valving (K).
     */
    val k: Double,

    /**
     * Alternate Base used instead of Machine base in equipment model if necessary (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * (R).
     */
    val r: Double,

    /**
     * Governor time constant (T1).
     */
    val t1: Double,

    /**
     * Reheater time constant (T3).
     */
    val t3: Double,

    /**
     * Time after initial time for valve to close (Ta).
     */
    val ta: Double,

    /**
     * Time after initial time for valve to begin opening (Tb).
     */
    val tb: Double,

    /**
     * Time after initial time for valve to become fully open (Tc).
     */
    val tc: Double,

    /**
     * Initial time to begin fast valving (Ti).
     */
    val ti: Double,

    /**
     * Time constant with which power falls off after intercept valve closure (Tt).
     */
    val tt: Double,

    /**
     * (Vmax).
     */
    val vmax: Double,

    /**
     * (Vmin).
     */
    val vmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamFV2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamFV2
extends
    Parseable[GovSteamFV2]
{
    val sup = TurbineGovernorDynamics.parse _
    val dt = parse_element (element ("""GovSteamFV2.dt"""))_
    val k = parse_element (element ("""GovSteamFV2.k"""))_
    val mwbase = parse_element (element ("""GovSteamFV2.mwbase"""))_
    val r = parse_element (element ("""GovSteamFV2.r"""))_
    val t1 = parse_element (element ("""GovSteamFV2.t1"""))_
    val t3 = parse_element (element ("""GovSteamFV2.t3"""))_
    val ta = parse_element (element ("""GovSteamFV2.ta"""))_
    val tb = parse_element (element ("""GovSteamFV2.tb"""))_
    val tc = parse_element (element ("""GovSteamFV2.tc"""))_
    val ti = parse_element (element ("""GovSteamFV2.ti"""))_
    val tt = parse_element (element ("""GovSteamFV2.tt"""))_
    val vmax = parse_element (element ("""GovSteamFV2.vmax"""))_
    val vmin = parse_element (element ("""GovSteamFV2.vmin"""))_
    def parse (context: Context): GovSteamFV2 =
    {
        GovSteamFV2(
            sup (context),
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
 */
case class GovSteamFV3
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Governor gain, (reciprocal of droop) (K).
     * Typical Value = 20.
     */
    val k: Double,

    /**
     * Fraction of turbine power developed after first boiler pass (K1).
     * Typical Value = 0.2.
     */
    val k1: Double,

    /**
     * Fraction of turbine power developed after second boiler pass (K2).
     * Typical Value = 0.2.
     */
    val k2: Double,

    /**
     * Fraction of hp turbine power developed after crossover or third boiler pass (K3).
     * Typical Value = 0.6.
     */
    val k3: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Maximum valve opening, PU of MWbase (Pmax).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum valve opening, PU of MWbase (Pmin).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Max. pressure in reheater (Prmax).
     * Typical Value = 1.
     */
    val prmax: Double,

    /**
     * Governor lead time constant (T1).
     * Typical Value = 0.
     */
    val t1: Double,

    /**
     * Governor lag time constant (T2).
     * Typical Value = 0.
     */
    val t2: Double,

    /**
     * Valve positioner time constant (T3).
     * Typical Value = 0.
     */
    val t3: Double,

    /**
     * Inlet piping/steam bowl time constant (T4).
     * Typical Value = 0.2.
     */
    val t4: Double,

    /**
     * Time constant of second boiler pass (i.e. reheater) (T5).
     * Typical Value = 0.5.
     */
    val t5: Double,

    /**
     * Time constant of crossover or third boiler pass (T6).
     * Typical Value = 10.
     */
    val t6: Double,

    /**
     * Time to close intercept valve (IV) (Ta).
     * Typical Value = 0.97.
     */
    val ta: Double,

    /**
     * Time until IV starts to reopen (Tb).
     * Typical Value = 0.98.
     */
    val tb: Double,

    /**
     * Time until IV is fully open (Tc).
     * Typical Value = 0.99.
     */
    val tc: Double,

    /**
     * Maximum valve closing velocity (Uc).
     * Unit = PU/sec.  Typical Value = -1.
     */
    val uc: Double,

    /**
     * Maximum valve opening velocity (Uo).
     * Unit = PU/sec.  Typical Value = 0.1.
     */
    val uo: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamFV3]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamFV3
extends
    Parseable[GovSteamFV3]
{
    val sup = TurbineGovernorDynamics.parse _
    val k = parse_element (element ("""GovSteamFV3.k"""))_
    val k1 = parse_element (element ("""GovSteamFV3.k1"""))_
    val k2 = parse_element (element ("""GovSteamFV3.k2"""))_
    val k3 = parse_element (element ("""GovSteamFV3.k3"""))_
    val mwbase = parse_element (element ("""GovSteamFV3.mwbase"""))_
    val pmax = parse_element (element ("""GovSteamFV3.pmax"""))_
    val pmin = parse_element (element ("""GovSteamFV3.pmin"""))_
    val prmax = parse_element (element ("""GovSteamFV3.prmax"""))_
    val t1 = parse_element (element ("""GovSteamFV3.t1"""))_
    val t2 = parse_element (element ("""GovSteamFV3.t2"""))_
    val t3 = parse_element (element ("""GovSteamFV3.t3"""))_
    val t4 = parse_element (element ("""GovSteamFV3.t4"""))_
    val t5 = parse_element (element ("""GovSteamFV3.t5"""))_
    val t6 = parse_element (element ("""GovSteamFV3.t6"""))_
    val ta = parse_element (element ("""GovSteamFV3.ta"""))_
    val tb = parse_element (element ("""GovSteamFV3.tb"""))_
    val tc = parse_element (element ("""GovSteamFV3.tc"""))_
    val uc = parse_element (element ("""GovSteamFV3.uc"""))_
    val uo = parse_element (element ("""GovSteamFV3.uo"""))_
    def parse (context: Context): GovSteamFV3 =
    {
        GovSteamFV3(
            sup (context),
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
 */
case class GovSteamFV4
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Minimum value of pressure regulator output (Cpsmn).
     * Typical Value = -1.
     */
    val cpsmn: Double,

    /**
     * Maximum value of pressure regulator output (Cpsmx).
     * Typical Value = 1.
     */
    val cpsmx: Double,

    /**
     * Minimum value of regulator set-point (Crmn).
     * Typical Value = 0.
     */
    val crmn: Double,

    /**
     * Maximum value of regulator set-point (Crmx).
     * Typical Value = 1.2.
     */
    val crmx: Double,

    /**
     * Derivative gain of pressure regulator (Kdc).
     * Typical Value = 1.
     */
    val kdc: Double,

    /**
     * Frequency bias (reciprocal of droop) (Kf1).
     * Typical Value = 20.
     */
    val kf1: Double,

    /**
     * Frequency control (reciprocal of droop) (Kf3).
     * Typical Value = 20.
     */
    val kf3: Double,

    /**
     * Fraction  of total turbine output generated by HP part (Khp).
     * Typical Value = 0.35.
     */
    val khp: Double,

    /**
     * Integral gain of pressure regulator (Kic).
     * Typical Value = 0.0033.
     */
    val kic: Double,

    /**
     * Integral gain of pressure feedback regulator (Kip).
     * Typical Value = 0.5.
     */
    val kip: Double,

    /**
     * Integral gain of electro-hydraulic regulator (Kit).
     * Typical Value = 0.04.
     */
    val kit: Double,

    /**
     * First gain coefficient of  intercept valves characteristic (Kmp1).
     * Typical Value = 0.5.
     */
    val kmp1: Double,

    /**
     * Second gain coefficient of intercept valves characteristic (Kmp2).
     * Typical Value = 3.5.
     */
    val kmp2: Double,

    /**
     * Proportional gain of pressure regulator (Kpc).
     * Typical Value = 0.5.
     */
    val kpc: Double,

    /**
     * Proportional gain of pressure feedback regulator (Kpp).
     * Typical Value = 1.
     */
    val kpp: Double,

    /**
     * Proportional gain of electro-hydraulic regulator (Kpt).
     * Typical Value = 0.3.
     */
    val kpt: Double,

    /**
     * Maximum variation of fuel flow (Krc).
     * Typical Value = 0.05.
     */
    val krc: Double,

    /**
     * Pressure loss due to flow friction in the boiler tubes (Ksh).
     * Typical Value = 0.08.
     */
    val ksh: Double,

    /**
     * Maximum negative power error (Lpi).
     * Typical Value = -0.15.
     */
    val lpi: Double,

    /**
     * Maximum positive power error (Lps).
     * Typical Value = 0.03.
     */
    val lps: Double,

    /**
     * Lower limit for frequency correction (MN<sub>EF</sub>).
     * Typical Value = -0.05.
     */
    val mnef: Double,

    /**
     * Upper limit for frequency correction (MX<sub>EF</sub>).
     * Typical Value = 0.05.
     */
    val mxef: Double,

    /**
     * First value of pressure set point static characteristic (Pr1).
     * Typical Value = 0.2.
     */
    val pr1: Double,

    /**
     * Second value of pressure set point static characteristic, corresponding to Ps0 = 1.0 PU (Pr2).
     * Typical Value = 0.75.
     */
    val pr2: Double,

    /**
     * Minimum value of pressure set point static characteristic (Psmn).
     * Typical Value = 1.
     */
    val psmn: Double,

    /**
     * Minimum value of integral regulator (Rsmimn).
     * Typical Value = 0.
     */
    val rsmimn: Double,

    /**
     * Maximum value of integral regulator (Rsmimx).
     * Typical Value = 1.1.
     */
    val rsmimx: Double,

    /**
     * Minimum value of integral regulator (Rvgmn).
     * Typical Value = 0.
     */
    val rvgmn: Double,

    /**
     * Maximum value of integral regulator (Rvgmx).
     * Typical Value = 1.2.
     */
    val rvgmx: Double,

    /**
     * Minimum valve opening (Srmn).
     * Typical Value = 0.
     */
    val srmn: Double,

    /**
     * Maximum valve opening (Srmx).
     * Typical Value = 1.1.
     */
    val srmx: Double,

    /**
     * Intercept valves characteristic discontinuity point (Srsmp).
     * Typical Value = 0.43.
     */
    val srsmp: Double,

    /**
     * Maximum regulator gate closing velocity (Svmn).
     * Typical Value = -0.0333.
     */
    val svmn: Double,

    /**
     * Maximum regulator gate opening velocity (Svmx).
     * Typical Value = 0.0333.
     */
    val svmx: Double,

    /**
     * Control valves rate opening time (Ta).
     * Typical Value = 0.8.
     */
    val ta: Double,

    /**
     * Intercept valves rate opening time (Tam).
     * Typical Value = 0.8.
     */
    val tam: Double,

    /**
     * Control valves rate closing time (Tc).
     * Typical Value = 0.5.
     */
    val tc: Double,

    /**
     * Intercept valves rate closing time (Tcm).
     * Typical Value = 0.5.
     */
    val tcm: Double,

    /**
     * Derivative time constant of pressure regulator (Tdc).
     * Typical Value = 90.
     */
    val tdc: Double,

    /**
     * Time constant of fuel regulation (Tf1).
     * Typical Value = 10.
     */
    val tf1: Double,

    /**
     * Time constant of steam chest (Tf2).
     * Typical Value = 10.
     */
    val tf2: Double,

    /**
     * High pressure (HP) time constant of the turbine (Thp).
     * Typical Value = 0.15.
     */
    val thp: Double,

    /**
     * Low pressure (LP) time constant of the turbine (Tmp).
     * Typical Value = 0.4.
     */
    val tmp: Double,

    /**
     * Reheater  time constant of the turbine (Trh).
     * Typical Value = 10.
     */
    val trh: Double,

    /**
     * Boiler time constant (Tv).
     * Typical Value = 60.
     */
    val tv: Double,

    /**
     * Control valves servo time constant (Ty).
     * Typical Value = 0.1.
     */
    val ty: Double,

    /**
     * Coefficient of linearized equations of turbine (Stodola formulation) (Y).
     * Typical Value = 0.13.
     */
    val y: Double,

    /**
     * Minimum control valve position (Yhpmn).
     * Typical Value = 0.
     */
    val yhpmn: Double,

    /**
     * Maximum control valve position (Yhpmx).
     * Typical Value = 1.1.
     */
    val yhpmx: Double,

    /**
     * Minimum intercept valve position (Ympmn).
     * Typical Value = 0.
     */
    val ympmn: Double,

    /**
     * Maximum intercept valve position (Ympmx).
     * Typical Value = 1.1.
     */
    val ympmx: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamFV4]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamFV4
extends
    Parseable[GovSteamFV4]
{
    val sup = TurbineGovernorDynamics.parse _
    val cpsmn = parse_element (element ("""GovSteamFV4.cpsmn"""))_
    val cpsmx = parse_element (element ("""GovSteamFV4.cpsmx"""))_
    val crmn = parse_element (element ("""GovSteamFV4.crmn"""))_
    val crmx = parse_element (element ("""GovSteamFV4.crmx"""))_
    val kdc = parse_element (element ("""GovSteamFV4.kdc"""))_
    val kf1 = parse_element (element ("""GovSteamFV4.kf1"""))_
    val kf3 = parse_element (element ("""GovSteamFV4.kf3"""))_
    val khp = parse_element (element ("""GovSteamFV4.khp"""))_
    val kic = parse_element (element ("""GovSteamFV4.kic"""))_
    val kip = parse_element (element ("""GovSteamFV4.kip"""))_
    val kit = parse_element (element ("""GovSteamFV4.kit"""))_
    val kmp1 = parse_element (element ("""GovSteamFV4.kmp1"""))_
    val kmp2 = parse_element (element ("""GovSteamFV4.kmp2"""))_
    val kpc = parse_element (element ("""GovSteamFV4.kpc"""))_
    val kpp = parse_element (element ("""GovSteamFV4.kpp"""))_
    val kpt = parse_element (element ("""GovSteamFV4.kpt"""))_
    val krc = parse_element (element ("""GovSteamFV4.krc"""))_
    val ksh = parse_element (element ("""GovSteamFV4.ksh"""))_
    val lpi = parse_element (element ("""GovSteamFV4.lpi"""))_
    val lps = parse_element (element ("""GovSteamFV4.lps"""))_
    val mnef = parse_element (element ("""GovSteamFV4.mnef"""))_
    val mxef = parse_element (element ("""GovSteamFV4.mxef"""))_
    val pr1 = parse_element (element ("""GovSteamFV4.pr1"""))_
    val pr2 = parse_element (element ("""GovSteamFV4.pr2"""))_
    val psmn = parse_element (element ("""GovSteamFV4.psmn"""))_
    val rsmimn = parse_element (element ("""GovSteamFV4.rsmimn"""))_
    val rsmimx = parse_element (element ("""GovSteamFV4.rsmimx"""))_
    val rvgmn = parse_element (element ("""GovSteamFV4.rvgmn"""))_
    val rvgmx = parse_element (element ("""GovSteamFV4.rvgmx"""))_
    val srmn = parse_element (element ("""GovSteamFV4.srmn"""))_
    val srmx = parse_element (element ("""GovSteamFV4.srmx"""))_
    val srsmp = parse_element (element ("""GovSteamFV4.srsmp"""))_
    val svmn = parse_element (element ("""GovSteamFV4.svmn"""))_
    val svmx = parse_element (element ("""GovSteamFV4.svmx"""))_
    val ta = parse_element (element ("""GovSteamFV4.ta"""))_
    val tam = parse_element (element ("""GovSteamFV4.tam"""))_
    val tc = parse_element (element ("""GovSteamFV4.tc"""))_
    val tcm = parse_element (element ("""GovSteamFV4.tcm"""))_
    val tdc = parse_element (element ("""GovSteamFV4.tdc"""))_
    val tf1 = parse_element (element ("""GovSteamFV4.tf1"""))_
    val tf2 = parse_element (element ("""GovSteamFV4.tf2"""))_
    val thp = parse_element (element ("""GovSteamFV4.thp"""))_
    val tmp = parse_element (element ("""GovSteamFV4.tmp"""))_
    val trh = parse_element (element ("""GovSteamFV4.trh"""))_
    val tv = parse_element (element ("""GovSteamFV4.tv"""))_
    val ty = parse_element (element ("""GovSteamFV4.ty"""))_
    val y = parse_element (element ("""GovSteamFV4.y"""))_
    val yhpmn = parse_element (element ("""GovSteamFV4.yhpmn"""))_
    val yhpmx = parse_element (element ("""GovSteamFV4.yhpmx"""))_
    val ympmn = parse_element (element ("""GovSteamFV4.ympmn"""))_
    val ympmx = parse_element (element ("""GovSteamFV4.ympmx"""))_
    def parse (context: Context): GovSteamFV4 =
    {
        GovSteamFV4(
            sup (context),
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
 * Ref<font color="#0f0f0f">erence: IEEE Transactions on Power Apparatus and Systems</font>
 */
case class GovSteamIEEE1
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Governor gain (reciprocal of droop) (K) (&gt; 0).
     * Typical Value = 25.
     */
    val k: Double,

    /**
     * Fraction of HP shaft power after first boiler pass (K1).
     * Typical Value = 0.2.
     */
    val k1: Double,

    /**
     * Fraction of LP shaft power after first boiler pass (K2).
     * Typical Value = 0.
     */
    val k2: Double,

    /**
     * Fraction of HP shaft power after second boiler pass (K3).
     * Typical Value = 0.3.
     */
    val k3: Double,

    /**
     * Fraction of LP shaft power after second boiler pass (K4).
     * Typical Value = 0.
     */
    val k4: Double,

    /**
     * Fraction of HP shaft power after third boiler pass (K5).
     * Typical Value = 0.5.
     */
    val k5: Double,

    /**
     * Fraction of LP shaft power after third boiler pass (K6).
     * Typical Value = 0.
     */
    val k6: Double,

    /**
     * Fraction of HP shaft power after fourth boiler pass (K7).
     * Typical Value = 0.
     */
    val k7: Double,

    /**
     * Fraction of LP shaft power after fourth boiler pass (K8).
     * Typical Value = 0.
     */
    val k8: Double,

    /**
     * Base for power values (MWbase) (&gt; 0)<i>.</i>
     */
    val mwbase: Double,

    /**
     * Maximum valve opening (Pmax) (&gt; Pmin).
     * Typical Value = 1.
     */
    val pmax: Double,

    /**
     * Minimum valve opening (Pmin) (&gt;= 0).
     * Typical Value = 0.
     */
    val pmin: Double,

    /**
     * Governor lag time constant (T1).
     * Typical Value = 0.
     */
    val t1: Double,

    /**
     * Governor lead time constant (T2).
     * Typical Value = 0.
     */
    val t2: Double,

    /**
     * Valve positioner time constant (T3) (&gt; 0).
     * Typical Value = 0.1.
     */
    val t3: Double,

    /**
     * Inlet piping/steam bowl time constant (T4).
     * Typical Value = 0.3.
     */
    val t4: Double,

    /**
     * Time constant of second boiler pass (T5).
     * Typical Value = 5.
     */
    val t5: Double,

    /**
     * Time constant of third boiler pass (T6).
     * Typical Value = 0.5.
     */
    val t6: Double,

    /**
     * Time constant of fourth boiler pass (T7).
     * Typical Value = 0.
     */
    val t7: Double,

    /**
     * Maximum valve closing velocity (Uc) (&lt; 0).
     * Unit = PU/sec.  Typical Value = -10.
     */
    val uc: Double,

    /**
     * Maximum valve opening velocity (Uo) (&gt; 0).
     * Unit = PU/sec.  Typical Value = 1.
     */
    val uo: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamIEEE1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamIEEE1
extends
    Parseable[GovSteamIEEE1]
{
    val sup = TurbineGovernorDynamics.parse _
    val k = parse_element (element ("""GovSteamIEEE1.k"""))_
    val k1 = parse_element (element ("""GovSteamIEEE1.k1"""))_
    val k2 = parse_element (element ("""GovSteamIEEE1.k2"""))_
    val k3 = parse_element (element ("""GovSteamIEEE1.k3"""))_
    val k4 = parse_element (element ("""GovSteamIEEE1.k4"""))_
    val k5 = parse_element (element ("""GovSteamIEEE1.k5"""))_
    val k6 = parse_element (element ("""GovSteamIEEE1.k6"""))_
    val k7 = parse_element (element ("""GovSteamIEEE1.k7"""))_
    val k8 = parse_element (element ("""GovSteamIEEE1.k8"""))_
    val mwbase = parse_element (element ("""GovSteamIEEE1.mwbase"""))_
    val pmax = parse_element (element ("""GovSteamIEEE1.pmax"""))_
    val pmin = parse_element (element ("""GovSteamIEEE1.pmin"""))_
    val t1 = parse_element (element ("""GovSteamIEEE1.t1"""))_
    val t2 = parse_element (element ("""GovSteamIEEE1.t2"""))_
    val t3 = parse_element (element ("""GovSteamIEEE1.t3"""))_
    val t4 = parse_element (element ("""GovSteamIEEE1.t4"""))_
    val t5 = parse_element (element ("""GovSteamIEEE1.t5"""))_
    val t6 = parse_element (element ("""GovSteamIEEE1.t6"""))_
    val t7 = parse_element (element ("""GovSteamIEEE1.t7"""))_
    val uc = parse_element (element ("""GovSteamIEEE1.uc"""))_
    val uo = parse_element (element ("""GovSteamIEEE1.uo"""))_
    def parse (context: Context): GovSteamIEEE1 =
    {
        GovSteamIEEE1(
            sup (context),
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
 */
case class GovSteamSGO
(

    override val sup: TurbineGovernorDynamics,

    /**
     * One/per unit regulation (K1).
     */
    val k1: Double,

    /**
     * Fraction (K2).
     */
    val k2: Double,

    /**
     * Fraction (K3).
     */
    val k3: Double,

    /**
     * Base for power values (MWbase) (&gt;0).
     * Unit = MW.
     */
    val mwbase: Double,

    /**
     * Upper power limit (Pmax).
     */
    val pmax: Double,

    /**
     * Lower power limit (Pmin).
     */
    val pmin: Double,

    /**
     * Controller lag (T1).
     */
    val t1: Double,

    /**
     * Controller lead compensation (T2).
     */
    val t2: Double,

    /**
     * Governor lag (T3) (&gt;0).
     */
    val t3: Double,

    /**
     * Delay due to steam inlet volumes associated with steam chest and inlet piping (T4).
     */
    val t4: Double,

    /**
     * Reheater delay including hot and cold leads (T5).
     */
    val t5: Double,

    /**
     * Delay due to IP-LP turbine, crossover pipes and LP end hoods (T6).
     */
    val t6: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[GovSteamSGO]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GovSteamSGO
extends
    Parseable[GovSteamSGO]
{
    val sup = TurbineGovernorDynamics.parse _
    val k1 = parse_element (element ("""GovSteamSGO.k1"""))_
    val k2 = parse_element (element ("""GovSteamSGO.k2"""))_
    val k3 = parse_element (element ("""GovSteamSGO.k3"""))_
    val mwbase = parse_element (element ("""GovSteamSGO.mwbase"""))_
    val pmax = parse_element (element ("""GovSteamSGO.pmax"""))_
    val pmin = parse_element (element ("""GovSteamSGO.pmin"""))_
    val t1 = parse_element (element ("""GovSteamSGO.t1"""))_
    val t2 = parse_element (element ("""GovSteamSGO.t2"""))_
    val t3 = parse_element (element ("""GovSteamSGO.t3"""))_
    val t4 = parse_element (element ("""GovSteamSGO.t4"""))_
    val t5 = parse_element (element ("""GovSteamSGO.t5"""))_
    val t6 = parse_element (element ("""GovSteamSGO.t6"""))_
    def parse (context: Context): GovSteamSGO =
    {
        GovSteamSGO(
            sup (context),
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
 */
case class TurbineGovernorDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Asynchronous machine model with which this turbine-governor model is associated.
     */
    val AsynchronousMachineDynamics: String,

    /**
     * Turbine load controller providing input to this turbine-governor.
     */
    val TurbineLoadControllerDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbineGovernorDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbineGovernorDynamics
extends
    Parseable[TurbineGovernorDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""TurbineGovernorDynamics.AsynchronousMachineDynamics"""))_
    val TurbineLoadControllerDynamics = parse_attribute (attribute ("""TurbineGovernorDynamics.TurbineLoadControllerDynamics"""))_
    def parse (context: Context): TurbineGovernorDynamics =
    {
        TurbineGovernorDynamics(
            sup (context),
            AsynchronousMachineDynamics (context),
            TurbineLoadControllerDynamics (context)
        )
    }
}

object _TurbineGovernorDynamics
{
    def register: Unit =
    {
        DroopSignalFeedbackKind.register
        FrancisGovernorControlKind.register
        GovCT1.register
        GovCT2.register
        GovGAST.register
        GovGAST1.register
        GovGAST2.register
        GovGAST3.register
        GovGAST4.register
        GovGASTWD.register
        GovHydro1.register
        GovHydro2.register
        GovHydro3.register
        GovHydro4.register
        GovHydroDD.register
        GovHydroFrancis.register
        GovHydroIEEE0.register
        GovHydroIEEE2.register
        GovHydroPID.register
        GovHydroPID2.register
        GovHydroPelton.register
        GovHydroR.register
        GovHydroWEH.register
        GovHydroWPID.register
        GovSteam0.register
        GovSteam1.register
        GovSteam2.register
        GovSteamCC.register
        GovSteamEU.register
        GovSteamFV2.register
        GovSteamFV3.register
        GovSteamFV4.register
        GovSteamIEEE1.register
        GovSteamSGO.register
        TurbineGovernorDynamics.register
    }
}