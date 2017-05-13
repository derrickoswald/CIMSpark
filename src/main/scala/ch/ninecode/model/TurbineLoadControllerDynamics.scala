package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * A turbine load controller acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference.
 */

/**
 * Turbine Load Controller model developed in the WECC.
 * This model represents a supervisory turbine load controller that acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference. This model is intended to represent slow reset 'outer loop' controllers managing the action of the turbine governor.
 */
case class TurbLCFB1
(

    override val sup: TurbineLoadControllerDynamics,

    /**
     * Controller dead band (db).
     * Typical Value = 0.
     */
    val db: Double,

    /**
     * Maximum control error (Emax) (note 4).
     * Typical Value = 0.02.
     */
    val emax: Double,

    /**
     * Frequency bias gain (Fb).
     * Typical Value = 0.
     */
    val fb: Double,

    /**
     * Frequency bias flag (Fbf).
    true = enable frequency bias
    false = disable frequency bias.
     * Typical Value = false.
     */
    val fbf: Boolean,

    /**
     * Maximum turbine speed/load reference bias (Irmax) (note 3).
     * Typical Value = 0.
     */
    val irmax: Double,

    /**
     * Integral gain (Ki).
     * Typical Value = 0.
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
     * Power controller flag (Pbf).
    true = enable load controller
    false = disable load controller.
     * Typical Value = false.
     */
    val pbf: Boolean,

    /**
     * Power controller setpoint (Pmwset) (note 1).
     * Unit = MW. Typical Value = 0.
     */
    val pmwset: Double,

    /**
     * Type of turbine governor reference (Type).
    true = speed reference governor
    false = load reference governor.
     * Typical Value = true.
     */
    val speedReferenceGovernor: Boolean,

    /**
     * Power transducer time constant (Tpelec).
     * Typical Value = 0.
     */
    val tpelec: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, false, 0.0, false, 0.0) }
    def TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = sup.asInstanceOf[TurbineLoadControllerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbLCFB1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbLCFB1
extends
    Parseable[TurbLCFB1]
{
    val sup = TurbineLoadControllerDynamics.parse _
    val db = parse_element (element ("""TurbLCFB1.db"""))_
    val emax = parse_element (element ("""TurbLCFB1.emax"""))_
    val fb = parse_element (element ("""TurbLCFB1.fb"""))_
    val fbf = parse_element (element ("""TurbLCFB1.fbf"""))_
    val irmax = parse_element (element ("""TurbLCFB1.irmax"""))_
    val ki = parse_element (element ("""TurbLCFB1.ki"""))_
    val kp = parse_element (element ("""TurbLCFB1.kp"""))_
    val mwbase = parse_element (element ("""TurbLCFB1.mwbase"""))_
    val pbf = parse_element (element ("""TurbLCFB1.pbf"""))_
    val pmwset = parse_element (element ("""TurbLCFB1.pmwset"""))_
    val speedReferenceGovernor = parse_element (element ("""TurbLCFB1.speedReferenceGovernor"""))_
    val tpelec = parse_element (element ("""TurbLCFB1.tpelec"""))_
    def parse (context: Context): TurbLCFB1 =
    {
        TurbLCFB1(
            sup (context),
            toDouble (db (context), context),
            toDouble (emax (context), context),
            toDouble (fb (context), context),
            toBoolean (fbf (context), context),
            toDouble (irmax (context), context),
            toDouble (ki (context), context),
            toDouble (kp (context), context),
            toDouble (mwbase (context), context),
            toBoolean (pbf (context), context),
            toDouble (pmwset (context), context),
            toBoolean (speedReferenceGovernor (context), context),
            toDouble (tpelec (context), context)
        )
    }
}

/**
 * Turbine load controller function block whose behavior is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 */
case class TurbineLoadControllerDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Turbine-governor controlled by this turbine load controller.
     */
    val TurbineGovernorDynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbineLoadControllerDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbineLoadControllerDynamics
extends
    Parseable[TurbineLoadControllerDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val TurbineGovernorDynamics = parse_attribute (attribute ("""TurbineLoadControllerDynamics.TurbineGovernorDynamics"""))_
    def parse (context: Context): TurbineLoadControllerDynamics =
    {
        TurbineLoadControllerDynamics(
            sup (context),
            TurbineGovernorDynamics (context)
        )
    }
}

object _TurbineLoadControllerDynamics
{
    def register: Unit =
    {
        TurbLCFB1.register
        TurbineLoadControllerDynamics.register
    }
}