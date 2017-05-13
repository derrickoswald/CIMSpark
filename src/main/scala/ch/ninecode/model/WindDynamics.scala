package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * Wind turbines are generally divided into 4 types, which are currently significant in power systems.
 * The 4 types have the following characteristics:
 */

/**
 * The constant aerodynamic torque model assumes that the aerodynamic torque is constant.
 * Reference: IEC Standard 61400-27-1 Section 5.6.1.1.
 */
case class WindAeroConstIEC
(

    override val sup: IdentifiedObject,

    /**
     * Wind turbine type 1A model with which this wind aerodynamic model is associated.
     */
    val WindGenTurbineType1aIEC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindAeroConstIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindAeroConstIEC
extends
    Parseable[WindAeroConstIEC]
{
    val sup = IdentifiedObject.parse _
    val WindGenTurbineType1aIEC = parse_attribute (attribute ("""WindAeroConstIEC.WindGenTurbineType1aIEC"""))_
    def parse (context: Context): WindAeroConstIEC =
    {
        WindAeroConstIEC(
            sup (context),
            WindGenTurbineType1aIEC (context)
        )
    }
}

/**
 * One-dimensional aerodynamic model.
 * Reference: IEC Standard 614000-27-1 Section 5.6.1.2.
 */
case class WindAeroOneDimIEC
(

    override val sup: IdentifiedObject,

    /**
     * Aerodynamic gain (<i>k</i><i><sub>a</sub></i>).
     * It is type dependent parameter.
     */
    val ka: Double,

    /**
     * Initial pitch angle (<i>theta</i><i><sub>omega0</sub></i>).
     * It is case dependent parameter.
     */
    val thetaomega: Double,

    /**
     * Wind turbine type 3 model with which this wind aerodynamic model is associated.
     */
    val WindTurbineType3IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindAeroOneDimIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindAeroOneDimIEC
extends
    Parseable[WindAeroOneDimIEC]
{
    val sup = IdentifiedObject.parse _
    val ka = parse_element (element ("""WindAeroOneDimIEC.ka"""))_
    val thetaomega = parse_element (element ("""WindAeroOneDimIEC.thetaomega"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindAeroOneDimIEC.WindTurbineType3IEC"""))_
    def parse (context: Context): WindAeroOneDimIEC =
    {
        WindAeroOneDimIEC(
            sup (context),
            toDouble (ka (context), context),
            toDouble (thetaomega (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * Two-dimensional aerodynamic model.
 * Reference: IEC Standard 614000-27-1 Section 5.6.1.3.
 */
case class WindAeroTwoDimIEC
(

    override val sup: IdentifiedObject,

    /**
     * Partial derivative of aerodynamic power with respect to changes in WTR speed (<i>dp</i><i><sub>omega</sub></i>).
     * It is type dependent parameter.
     */
    val dpomega: Double,

    /**
     * Partial derivative of aerodynamic power with respect to changes in pitch angle (<i>dp</i><i><sub>theta</sub></i>).
     * It is type dependent parameter.
     */
    val dptheta: Double,

    /**
     * Partial derivative (<i>dp</i><sub>v1</sub>).
     * It is type dependent parameter.
     */
    val dpv1: Double,

    /**
     * Rotor speed if the wind turbine is not derated (<i>omega</i><i><sub>0</sub></i>).
     * It is type dependent parameter.
     */
    val omegazero: Double,

    /**
     * Available aerodynamic power (<i>p</i><sub>avail</sub>).
     * It is case dependent parameter.
     */
    val pavail: Double,

    /**
     * Blade angle at twice rated wind speed (<i>theta</i><i><sub>v2</sub></i>).
     * It is type dependent parameter.
     */
    val thetav2: Double,

    /**
     * Pitch angle if the wind turbine is not derated (<i>theta</i><i><sub>0</sub></i>).
     * It is case dependent parameter.
     */
    val thetazero: Double,

    /**
     * Wind turbine type 3 model with which this wind aerodynamic model is associated.
     */
    val WindTurbineType3IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindAeroTwoDimIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindAeroTwoDimIEC
extends
    Parseable[WindAeroTwoDimIEC]
{
    val sup = IdentifiedObject.parse _
    val dpomega = parse_element (element ("""WindAeroTwoDimIEC.dpomega"""))_
    val dptheta = parse_element (element ("""WindAeroTwoDimIEC.dptheta"""))_
    val dpv1 = parse_element (element ("""WindAeroTwoDimIEC.dpv1"""))_
    val omegazero = parse_element (element ("""WindAeroTwoDimIEC.omegazero"""))_
    val pavail = parse_element (element ("""WindAeroTwoDimIEC.pavail"""))_
    val thetav2 = parse_element (element ("""WindAeroTwoDimIEC.thetav2"""))_
    val thetazero = parse_element (element ("""WindAeroTwoDimIEC.thetazero"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindAeroTwoDimIEC.WindTurbineType3IEC"""))_
    def parse (context: Context): WindAeroTwoDimIEC =
    {
        WindAeroTwoDimIEC(
            sup (context),
            toDouble (dpomega (context), context),
            toDouble (dptheta (context), context),
            toDouble (dpv1 (context), context),
            toDouble (omegazero (context), context),
            toDouble (pavail (context), context),
            toDouble (thetav2 (context), context),
            toDouble (thetazero (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * Current limitation model.
 * The current limitation model combines the physical limits and the control limits.
 */
case class WindContCurrLimIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum continuous current at the wind turbine terminals (<i>i</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val imax: Double,

    /**
     * Maximum current during voltage dip at the wind turbine terminals (<i>i</i><sub>maxdip</sub>).
     * It is project dependent parameter.
     */
    val imaxdip: Double,

    /**
     * Partial derivative of reactive current limit (<i>K</i><sub>pqu</sub>).
     * It is type dependent parameter.
     */
    val kpqu: Double,

    /**
     * Limitation of type 3 stator current  (<i>M</i><sub>DFSLim</sub>): 
    - false=0: total current limitation, 
    - true=1: stator current limitation).
     * It is type dependent parameter.
     */
    val mdfslim: Boolean,

    /**
     * Prioritisation of q control during UVRT (<i>M</i><sub>qpri</sub>):
    - true = 1: reactive power priority,
    - false = 0: active power priority.
     * It is project dependent parameter.
     */
    val mqpri: Boolean,

    /**
     * Voltage measurement filter time constant (<i>T</i><sub>ufiltcl</sub>).
     * It is type dependent parameter.
     */
    val tufiltcl: Double,

    /**
     * Wind turbine voltage in the operation point where zero reactive current can be delivered (<i>u</i><sub>pqumax</sub>).
     * It is type dependent parameter.
     */
    val upqumax: Double,

    /**
     * Wind turbine type 3 or 4 model with which this wind control current limitation model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContCurrLimIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContCurrLimIEC
extends
    Parseable[WindContCurrLimIEC]
{
    val sup = IdentifiedObject.parse _
    val imax = parse_element (element ("""WindContCurrLimIEC.imax"""))_
    val imaxdip = parse_element (element ("""WindContCurrLimIEC.imaxdip"""))_
    val kpqu = parse_element (element ("""WindContCurrLimIEC.kpqu"""))_
    val mdfslim = parse_element (element ("""WindContCurrLimIEC.mdfslim"""))_
    val mqpri = parse_element (element ("""WindContCurrLimIEC.mqpri"""))_
    val tufiltcl = parse_element (element ("""WindContCurrLimIEC.tufiltcl"""))_
    val upqumax = parse_element (element ("""WindContCurrLimIEC.upqumax"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContCurrLimIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindContCurrLimIEC =
    {
        WindContCurrLimIEC(
            sup (context),
            toDouble (imax (context), context),
            toDouble (imaxdip (context), context),
            toDouble (kpqu (context), context),
            toBoolean (mdfslim (context), context),
            toBoolean (mqpri (context), context),
            toDouble (tufiltcl (context), context),
            toDouble (upqumax (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * P control model Type 3.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.4.
 */
case class WindContPType3IEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum wind turbine power ramp rate (<i>dp</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val dpmax: Double,

    /**
     * Maximum ramp rate of wind turbine reference power (d<i>p</i><sub>refmax</sub>).
     * It is project dependent parameter.
     */
    val dprefmax: Double,

    /**
     * Minimum ramp rate of wind turbine reference power (d<i>p</i><sub>refmin</sub>).
     * It is project dependent parameter.
     */
    val dprefmin: Double,

    /**
     * Ramp limitation of torque, required in some grid codes (d<i>t</i><sub>max</sub>).
     * It is project dependent parameter.
     */
    val dthetamax: Double,

    /**
     * Limitation of torque rise rate during UVRT (d<i>theta</i><sub>maxUVRT</sub>).
     * It is project dependent parameter.
     */
    val dthetamaxuvrt: Double,

    /**
     * Gain for active drive train damping (<i>K</i><sub>DTD</sub>).
     * It is type dependent parameter.
     */
    val kdtd: Double,

    /**
     * PI controller integration parameter (<i>K</i><sub>Ip</sub>).
     * It is type dependent parameter.
     */
    val kip: Double,

    /**
     * PI controller proportional gain (<i>K</i><sub>Pp</sub>).
     * It is type dependent parameter.
     */
    val kpp: Double,

    /**
     * Enable UVRT power control mode (M<sub>pUVRT).</sub>
    true = 1: voltage control
    false = 0: reactive power control.
     * It is project dependent parameter.
     */
    val mpuvrt: Boolean,

    /**
     * Offset to reference value that limits controller action during rotor speed changes (omega<sub>offset</sub>).
     * It is case dependent parameter.
     */
    val omegaoffset: Double,

    /**
     * Maximum active drive train damping power (<i>p</i><sub>DTDmax</sub>).
     * It is type dependent parameter.
     */
    val pdtdmax: Double,

    /**
     * Time<sub> </sub>delay after deep voltage sags (T<sub>DVS</sub>).
     * It is project dependent parameter.
     */
    val tdvs: Double,

    /**
     * Minimum electrical generator torque (<i>t</i><sub>emin</sub>).
     * It is type dependent parameter.
     */
    val thetaemin: Double,

    /**
     * Voltage scaling factor of reset-torque (<i>t</i><sub>uscale</sub>).
     * It is project dependent parameter.
     */
    val thetauscale: Double,

    /**
     * Filter time constant for generator speed measurement (<i>T</i><sub>omegafiltp3</sub>).
     * It is type dependent parameter.
     */
    val tomegafiltp3: Double,

    /**
     * Filter time constant for power measurement (<i>T</i><sub>pfiltp3</sub>).
     * It is type dependent parameter.
     */
    val tpfiltp3: Double,

    /**
     * Time constant in power order lag (<i>T</i><sub>pord</sub>).
     * It is type dependent parameter.
     */
    val tpord: Double,

    /**
     * Filter time constant for voltage measurement (<i>T</i><sub>ufiltp3</sub>).
     * It is type dependent parameter.
     */
    val tufiltp3: Double,

    /**
     * Time constant in speed reference filter (<i>T</i><sub>omega,ref</sub>).
     * It is type dependent parameter.
     */
    val twref: Double,

    /**
     * Voltage limit for hold UVRT status after deep voltage sags (<i>u</i><i><sub>DVS</sub></i>).
     * It is project dependent parameter.
     */
    val udvs: Double,

    /**
     * Voltage dip threshold for P-control (<i>u</i><sub>Pdip</sub>).
     * Part of turbine control, often different (e.g 0.8) from converter thresholds. It is project dependent parameter.
     */
    val updip: Double,

    /**
     * Active drive train damping frequency (omega<sub>DTD</sub>).
     * It can be calculated from two mass model parameters. It is type dependent parameter.
     */
    val wdtd: Double,

    /**
     * Coefficient for active drive train damping (zeta).
     * It is type dependent parameter.
     */
    val zeta: Double,

    /**
     * Wind turbine type 3 model with which this Wind control P type 3 model is associated.
     */
    val WindTurbineType3IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContPType3IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContPType3IEC
extends
    Parseable[WindContPType3IEC]
{
    val sup = IdentifiedObject.parse _
    val dpmax = parse_element (element ("""WindContPType3IEC.dpmax"""))_
    val dprefmax = parse_element (element ("""WindContPType3IEC.dprefmax"""))_
    val dprefmin = parse_element (element ("""WindContPType3IEC.dprefmin"""))_
    val dthetamax = parse_element (element ("""WindContPType3IEC.dthetamax"""))_
    val dthetamaxuvrt = parse_element (element ("""WindContPType3IEC.dthetamaxuvrt"""))_
    val kdtd = parse_element (element ("""WindContPType3IEC.kdtd"""))_
    val kip = parse_element (element ("""WindContPType3IEC.kip"""))_
    val kpp = parse_element (element ("""WindContPType3IEC.kpp"""))_
    val mpuvrt = parse_element (element ("""WindContPType3IEC.mpuvrt"""))_
    val omegaoffset = parse_element (element ("""WindContPType3IEC.omegaoffset"""))_
    val pdtdmax = parse_element (element ("""WindContPType3IEC.pdtdmax"""))_
    val tdvs = parse_element (element ("""WindContPType3IEC.tdvs"""))_
    val thetaemin = parse_element (element ("""WindContPType3IEC.thetaemin"""))_
    val thetauscale = parse_element (element ("""WindContPType3IEC.thetauscale"""))_
    val tomegafiltp3 = parse_element (element ("""WindContPType3IEC.tomegafiltp3"""))_
    val tpfiltp3 = parse_element (element ("""WindContPType3IEC.tpfiltp3"""))_
    val tpord = parse_element (element ("""WindContPType3IEC.tpord"""))_
    val tufiltp3 = parse_element (element ("""WindContPType3IEC.tufiltp3"""))_
    val twref = parse_element (element ("""WindContPType3IEC.twref"""))_
    val udvs = parse_element (element ("""WindContPType3IEC.udvs"""))_
    val updip = parse_element (element ("""WindContPType3IEC.updip"""))_
    val wdtd = parse_element (element ("""WindContPType3IEC.wdtd"""))_
    val zeta = parse_element (element ("""WindContPType3IEC.zeta"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindContPType3IEC.WindTurbineType3IEC"""))_
    def parse (context: Context): WindContPType3IEC =
    {
        WindContPType3IEC(
            sup (context),
            toDouble (dpmax (context), context),
            toDouble (dprefmax (context), context),
            toDouble (dprefmin (context), context),
            toDouble (dthetamax (context), context),
            toDouble (dthetamaxuvrt (context), context),
            toDouble (kdtd (context), context),
            toDouble (kip (context), context),
            toDouble (kpp (context), context),
            toBoolean (mpuvrt (context), context),
            toDouble (omegaoffset (context), context),
            toDouble (pdtdmax (context), context),
            toDouble (tdvs (context), context),
            toDouble (thetaemin (context), context),
            toDouble (thetauscale (context), context),
            toDouble (tomegafiltp3 (context), context),
            toDouble (tpfiltp3 (context), context),
            toDouble (tpord (context), context),
            toDouble (tufiltp3 (context), context),
            toDouble (twref (context), context),
            toDouble (udvs (context), context),
            toDouble (updip (context), context),
            toDouble (wdtd (context), context),
            toDouble (zeta (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * P control model Type 4A.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.5.
 */
case class WindContPType4aIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum wind turbine power ramp rate (<i>dp</i><sub>maxp4A</sub>).
     * It is project dependent parameter.
     */
    val dpmaxp4a: Double,

    /**
     * Time constant in power order lag (<i>T</i><sub>pordp4A</sub>).
     * It is type dependent parameter.
     */
    val tpordp4a: Double,

    /**
     * Voltage measurement filter time constant (<i>T</i><sub>ufiltp4A</sub>).
     * It is type dependent parameter.
     */
    val tufiltp4a: Double,

    /**
     *  Wind turbine type 4A model with which this wind control P type 4A model is associated.
     */
    val WindTurbineType4aIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContPType4aIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContPType4aIEC
extends
    Parseable[WindContPType4aIEC]
{
    val sup = IdentifiedObject.parse _
    val dpmaxp4a = parse_element (element ("""WindContPType4aIEC.dpmaxp4a"""))_
    val tpordp4a = parse_element (element ("""WindContPType4aIEC.tpordp4a"""))_
    val tufiltp4a = parse_element (element ("""WindContPType4aIEC.tufiltp4a"""))_
    val WindTurbineType4aIEC = parse_attribute (attribute ("""WindContPType4aIEC.WindTurbineType4aIEC"""))_
    def parse (context: Context): WindContPType4aIEC =
    {
        WindContPType4aIEC(
            sup (context),
            toDouble (dpmaxp4a (context), context),
            toDouble (tpordp4a (context), context),
            toDouble (tufiltp4a (context), context),
            WindTurbineType4aIEC (context)
        )
    }
}

/**
 * P control model Type 4B.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.6.
 */
case class WindContPType4bIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum wind turbine power ramp rate (<i>dp</i><sub>maxp4B</sub>).
     * It is project dependent parameter.
     */
    val dpmaxp4b: Double,

    /**
     * Time constant in aerodynamic power response (<i>T</i><sub>paero</sub>).
     * It is type dependent parameter.
     */
    val tpaero: Double,

    /**
     * Time constant in power order lag (<i>T</i><sub>pordp4B</sub>).
     * It is type dependent parameter.
     */
    val tpordp4b: Double,

    /**
     * Voltage measurement filter time constant (<i>T</i><sub>ufiltp4B</sub>).
     * It is type dependent parameter.
     */
    val tufiltp4b: Double,

    /**
     * Wind turbine type 4B model with which this wind control P type 4B model is associated.
     */
    val WindTurbineType4bIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContPType4bIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContPType4bIEC
extends
    Parseable[WindContPType4bIEC]
{
    val sup = IdentifiedObject.parse _
    val dpmaxp4b = parse_element (element ("""WindContPType4bIEC.dpmaxp4b"""))_
    val tpaero = parse_element (element ("""WindContPType4bIEC.tpaero"""))_
    val tpordp4b = parse_element (element ("""WindContPType4bIEC.tpordp4b"""))_
    val tufiltp4b = parse_element (element ("""WindContPType4bIEC.tufiltp4b"""))_
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindContPType4bIEC.WindTurbineType4bIEC"""))_
    def parse (context: Context): WindContPType4bIEC =
    {
        WindContPType4bIEC(
            sup (context),
            toDouble (dpmaxp4b (context), context),
            toDouble (tpaero (context), context),
            toDouble (tpordp4b (context), context),
            toDouble (tufiltp4b (context), context),
            WindTurbineType4bIEC (context)
        )
    }
}

/**
 * Pitch angle control model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.2.
 */
case class WindContPitchAngleIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum pitch positive ramp rate (d<i>theta</i><sub>max</sub>).
     * It is type dependent parameter. Unit = degrees/sec.
     */
    val dthetamax: Double,

    /**
     * Maximum pitch negative ramp rate (d<i>theta</i><sub>min</sub>).
     * It is type dependent parameter. Unit = degrees/sec.
     */
    val dthetamin: Double,

    /**
     * Power PI controller integration gain (<i>K</i><sub>Ic</sub>).
     * It is type dependent parameter.
     */
    val kic: Double,

    /**
     * Speed PI controller integration gain (<i>K</i><sub>Iomega</sub>).
     * It is type dependent parameter.
     */
    val kiomega: Double,

    /**
     * Power PI controller proportional gain (<i>K</i><sub>Pc</sub>).
     * It is type dependent parameter.
     */
    val kpc: Double,

    /**
     * Speed PI controller proportional gain (<i>K</i><sub>Pomega</sub>).
     * It is type dependent parameter.
     */
    val kpomega: Double,

    /**
     * Pitch cross coupling gain (K<sub>PX</sub>).
     * It is type dependent parameter.
     */
    val kpx: Double,

    /**
     * Maximum pitch angle (<i>theta</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val thetamax: Double,

    /**
     * Minimum pitch angle (<i>theta</i><sub>min</sub>).
     * It is type dependent parameter.
     */
    val thetamin: Double,

    /**
     * Pitch time constant (t<i>theta</i>).
     * It is type dependent parameter.
     */
    val ttheta: Double,

    /**
     * Wind turbine type 3 model with which this pitch control model is associated.
     */
    val WindTurbineType3IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContPitchAngleIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContPitchAngleIEC
extends
    Parseable[WindContPitchAngleIEC]
{
    val sup = IdentifiedObject.parse _
    val dthetamax = parse_element (element ("""WindContPitchAngleIEC.dthetamax"""))_
    val dthetamin = parse_element (element ("""WindContPitchAngleIEC.dthetamin"""))_
    val kic = parse_element (element ("""WindContPitchAngleIEC.kic"""))_
    val kiomega = parse_element (element ("""WindContPitchAngleIEC.kiomega"""))_
    val kpc = parse_element (element ("""WindContPitchAngleIEC.kpc"""))_
    val kpomega = parse_element (element ("""WindContPitchAngleIEC.kpomega"""))_
    val kpx = parse_element (element ("""WindContPitchAngleIEC.kpx"""))_
    val thetamax = parse_element (element ("""WindContPitchAngleIEC.thetamax"""))_
    val thetamin = parse_element (element ("""WindContPitchAngleIEC.thetamin"""))_
    val ttheta = parse_element (element ("""WindContPitchAngleIEC.ttheta"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindContPitchAngleIEC.WindTurbineType3IEC"""))_
    def parse (context: Context): WindContPitchAngleIEC =
    {
        WindContPitchAngleIEC(
            sup (context),
            toDouble (dthetamax (context), context),
            toDouble (dthetamin (context), context),
            toDouble (kic (context), context),
            toDouble (kiomega (context), context),
            toDouble (kpc (context), context),
            toDouble (kpomega (context), context),
            toDouble (kpx (context), context),
            toDouble (thetamax (context), context),
            toDouble (thetamin (context), context),
            toDouble (ttheta (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * Q control model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.7.
 */
case class WindContQIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum reactive current injection during dip (i<sub>qh1</sub>).
     * It is type dependent parameter.
     */
    val iqh1: Double,

    /**
     * Maximum reactive current injection (i<sub>qmax</sub>).
     * It is type dependent parameter.
     */
    val iqmax: Double,

    /**
     * Minimum reactive current injection (i<sub>qmin</sub>).
     * It is type dependent parameter.
     */
    val iqmin: Double,

    /**
     * Post fault reactive current injection (<i>i</i><sub>qpost</sub>).
     * It is project dependent parameter.
     */
    val iqpost: Double,

    /**
     * Reactive power PI controller integration gain (<i>K</i><sub>I,q</sub>).
     * It is type dependent parameter.
     */
    val kiq: Double,

    /**
     * Voltage PI controller integration gain (<i>K</i><sub>I,u</sub>).
     * It is type dependent parameter.
     */
    val kiu: Double,

    /**
     * Reactive power PI controller proportional gain (<i>K</i><sub>P,q</sub>).
     * It is type dependent parameter.
     */
    val kpq: Double,

    /**
     * Voltage PI controller proportional gain (<i>K</i><sub>P,u</sub>).
     * It is type dependent parameter.
     */
    val kpu: Double,

    /**
     * Voltage scaling factor for UVRT current (<i>K</i><sub>qv</sub>).
     * It is project dependent parameter.
     */
    val kqv: Double,

    /**
     * Resistive component of voltage drop impedance (<i>r</i><sub>droop</sub>).
     * It is project dependent parameter.
     */
    val rdroop: Double,

    /**
     * Power measurement filter time constant (<i>T</i><sub>pfiltq</sub>).
     * It is type dependent parameter.
     */
    val tpfiltq: Double,

    /**
     * Length of time period where post fault reactive power is injected (<i>T</i><sub>post</sub>).
     * It is project dependent parameter.
     */
    val tpost: Double,

    /**
     * Time constant in reactive power order lag (<i>T</i><sub>qord</sub>).
     * It is type dependent parameter.
     */
    val tqord: Double,

    /**
     * Voltage measurement filter time constant (<i>T</i><sub>ufiltq</sub>).
     * It is type dependent parameter.
     */
    val tufiltq: Double,

    /**
     * Voltage dead band lower limit (<i>u</i><sub>db1</sub>).
     * It is type dependent parameter.
     */
    val udb1: Double,

    /**
     * Voltage dead band upper limit (<i>u</i><sub>db2</sub>).
     * It is type dependent parameter.
     */
    val udb2: Double,

    /**
     * Maximum voltage in voltage PI controller integral term (u<sub>max</sub>).
     * It is type dependent parameter.
     */
    val umax: Double,

    /**
     * Minimum voltage in voltage PI controller integral term (u<sub>min</sub>).
     * It is type dependent parameter.
     */
    val umin: Double,

    /**
     * Voltage threshold for UVRT detection in q control (<i>u</i><sub>qdip</sub>).
     * It is type dependent parameter.
     */
    val uqdip: Double,

    /**
     * User defined bias in voltage reference (<i>u</i><sub>ref0</sub>), used when <i>M</i><sub>qG</sub> is set to voltage control.
     * It is case dependent parameter.
     */
    val uref0: Double,

    /**
     * Types of general wind turbine Q control modes (<i>M</i><sub>qG</sub>).
     * It is project dependent parameter.
     */
    val windQcontrolModesType: String,

    /**
     * Types of UVRT Q control modes (<i>M</i><sub>qUVRT</sub>).
     * It is project dependent parameter.
     */
    val windUVRTQcontrolModesType: String,

    /**
     * Inductive component of voltage drop impedance (<i>x</i><sub>droop</sub>).
     * It is project dependent parameter.
     */
    val xdroop: Double,

    /**
     * Wind turbine type 3 or 4 model with which this reactive control model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContQIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContQIEC
extends
    Parseable[WindContQIEC]
{
    val sup = IdentifiedObject.parse _
    val iqh1 = parse_element (element ("""WindContQIEC.iqh1"""))_
    val iqmax = parse_element (element ("""WindContQIEC.iqmax"""))_
    val iqmin = parse_element (element ("""WindContQIEC.iqmin"""))_
    val iqpost = parse_element (element ("""WindContQIEC.iqpost"""))_
    val kiq = parse_element (element ("""WindContQIEC.kiq"""))_
    val kiu = parse_element (element ("""WindContQIEC.kiu"""))_
    val kpq = parse_element (element ("""WindContQIEC.kpq"""))_
    val kpu = parse_element (element ("""WindContQIEC.kpu"""))_
    val kqv = parse_element (element ("""WindContQIEC.kqv"""))_
    val rdroop = parse_element (element ("""WindContQIEC.rdroop"""))_
    val tpfiltq = parse_element (element ("""WindContQIEC.tpfiltq"""))_
    val tpost = parse_element (element ("""WindContQIEC.tpost"""))_
    val tqord = parse_element (element ("""WindContQIEC.tqord"""))_
    val tufiltq = parse_element (element ("""WindContQIEC.tufiltq"""))_
    val udb1 = parse_element (element ("""WindContQIEC.udb1"""))_
    val udb2 = parse_element (element ("""WindContQIEC.udb2"""))_
    val umax = parse_element (element ("""WindContQIEC.umax"""))_
    val umin = parse_element (element ("""WindContQIEC.umin"""))_
    val uqdip = parse_element (element ("""WindContQIEC.uqdip"""))_
    val uref0 = parse_element (element ("""WindContQIEC.uref0"""))_
    val windQcontrolModesType = parse_attribute (attribute ("""WindContQIEC.windQcontrolModesType"""))_
    val windUVRTQcontrolModesType = parse_attribute (attribute ("""WindContQIEC.windUVRTQcontrolModesType"""))_
    val xdroop = parse_element (element ("""WindContQIEC.xdroop"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindContQIEC =
    {
        WindContQIEC(
            sup (context),
            toDouble (iqh1 (context), context),
            toDouble (iqmax (context), context),
            toDouble (iqmin (context), context),
            toDouble (iqpost (context), context),
            toDouble (kiq (context), context),
            toDouble (kiu (context), context),
            toDouble (kpq (context), context),
            toDouble (kpu (context), context),
            toDouble (kqv (context), context),
            toDouble (rdroop (context), context),
            toDouble (tpfiltq (context), context),
            toDouble (tpost (context), context),
            toDouble (tqord (context), context),
            toDouble (tufiltq (context), context),
            toDouble (udb1 (context), context),
            toDouble (udb2 (context), context),
            toDouble (umax (context), context),
            toDouble (umin (context), context),
            toDouble (uqdip (context), context),
            toDouble (uref0 (context), context),
            windQcontrolModesType (context),
            windUVRTQcontrolModesType (context),
            toDouble (xdroop (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * Constant Q limitation model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.9.
 */
case class WindContQLimIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum reactive power (<i>q</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val qmax: Double,

    /**
     * Minimum reactive power (<i>q</i><sub>min</sub>).
     * It is type dependent parameter.
     */
    val qmin: Double,

    /**
     * Wind generator type 3 or 4 model with which this constant Q limitation model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContQLimIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContQLimIEC
extends
    Parseable[WindContQLimIEC]
{
    val sup = IdentifiedObject.parse _
    val qmax = parse_element (element ("""WindContQLimIEC.qmax"""))_
    val qmin = parse_element (element ("""WindContQLimIEC.qmin"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQLimIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindContQLimIEC =
    {
        WindContQLimIEC(
            sup (context),
            toDouble (qmax (context), context),
            toDouble (qmin (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * QP and QU limitation model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.10.
 */
case class WindContQPQULimIEC
(

    override val sup: IdentifiedObject,

    /**
     * Power measurement filter time constant for Q capacity (<i>T</i><sub>pfiltql</sub>).
     * It is type dependent parameter.
     */
    val tpfiltql: Double,

    /**
     * Voltage measurement filter time constant for Q capacity (<i>T</i><sub>ufiltql</sub>).
     * It is type dependent parameter.
     */
    val tufiltql: Double,

    /**
     * Wind generator type 3 or 4 model with which this QP and QU limitation model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContQPQULimIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContQPQULimIEC
extends
    Parseable[WindContQPQULimIEC]
{
    val sup = IdentifiedObject.parse _
    val tpfiltql = parse_element (element ("""WindContQPQULimIEC.tpfiltql"""))_
    val tufiltql = parse_element (element ("""WindContQPQULimIEC.tufiltql"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQPQULimIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindContQPQULimIEC =
    {
        WindContQPQULimIEC(
            sup (context),
            toDouble (tpfiltql (context), context),
            toDouble (tufiltql (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * Rotor resistance control model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.3.
 */
case class WindContRotorRIEC
(

    override val sup: IdentifiedObject,

    /**
     * Integral gain in rotor resistance PI controller (<i>K</i><sub>Irr</sub>).
     * It is type dependent parameter.
     */
    val kirr: Double,

    /**
     * Filter gain for generator speed measurement (K<sub>omegafilt</sub>).
     * It is type dependent parameter.
     */
    val komegafilt: Double,

    /**
     * Filter gain for power measurement (<i>K</i><sub>pfilt</sub>).
     * It is type dependent parameter.
     */
    val kpfilt: Double,

    /**
     * Proportional gain in rotor resistance PI controller (<i>K</i><sub>Prr</sub>).
     * It is type dependent parameter.
     */
    val kprr: Double,

    /**
     * Maximum rotor resistance (<i>r</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val rmax: Double,

    /**
     * Minimum rotor resistance (<i>r</i><sub>min</sub>).
     * It is type dependent parameter.
     */
    val rmin: Double,

    /**
     * Filter time constant for generator speed measurement (<i>T</i><sub>omegafiltrr</sub>).
     * It is type dependent parameter.
     */
    val tomegafiltrr: Double,

    /**
     * Filter time constant for power measurement (<i>T</i><sub>pfiltrr</sub>).
     * It is type dependent parameter.
     */
    val tpfiltrr: Double,

    /**
     * Wind turbine type 2 model with whitch this wind control rotor resistance model is associated.
     */
    val WindGenTurbineType2IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindContRotorRIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindContRotorRIEC
extends
    Parseable[WindContRotorRIEC]
{
    val sup = IdentifiedObject.parse _
    val kirr = parse_element (element ("""WindContRotorRIEC.kirr"""))_
    val komegafilt = parse_element (element ("""WindContRotorRIEC.komegafilt"""))_
    val kpfilt = parse_element (element ("""WindContRotorRIEC.kpfilt"""))_
    val kprr = parse_element (element ("""WindContRotorRIEC.kprr"""))_
    val rmax = parse_element (element ("""WindContRotorRIEC.rmax"""))_
    val rmin = parse_element (element ("""WindContRotorRIEC.rmin"""))_
    val tomegafiltrr = parse_element (element ("""WindContRotorRIEC.tomegafiltrr"""))_
    val tpfiltrr = parse_element (element ("""WindContRotorRIEC.tpfiltrr"""))_
    val WindGenTurbineType2IEC = parse_attribute (attribute ("""WindContRotorRIEC.WindGenTurbineType2IEC"""))_
    def parse (context: Context): WindContRotorRIEC =
    {
        WindContRotorRIEC(
            sup (context),
            toDouble (kirr (context), context),
            toDouble (komegafilt (context), context),
            toDouble (kpfilt (context), context),
            toDouble (kprr (context), context),
            toDouble (rmax (context), context),
            toDouble (rmin (context), context),
            toDouble (tomegafiltrr (context), context),
            toDouble (tpfiltrr (context), context),
            WindGenTurbineType2IEC (context)
        )
    }
}

/**
 * The class models a look up table for the purpose of wind standard models.
 */
case class WindDynamicsLookupTable
(

    override val sup: IdentifiedObject,

    /**
     * Input value (x) for the lookup table function.
     */
    val input: Double,

    /**
     * Type of the lookup table function.
     */
    val lookupTableFunctionType: String,

    /**
     * Output value (y) for the lookup table function.
     */
    val output: Double,

    /**
     * Sequence numbers of the pairs of the input (x) and the output (y) of the lookup table function.
     */
    val sequence: Int,

    /**
     * The current control limitation model with which this wind dynamics lookup table is associated.
     */
    val WindContCurrLimIEC: String,

    /**
     * The P control type 3 model with which this wind dynamics lookup table is associated.
     */
    val WindContPType3IEC: String,

    /**
     * The QP and QU limitation model with which this wind dynamics lookup table is associated.
     */
    val WindContQPQULimIEC: String,

    /**
     * The rotor resistance control model with which this wind dynamics lookup table is associated.
     */
    val WindContRotorRIEC: String,

    /**
     * The generator type 3B model with which this wind dynamics lookup table is associated.
     */
    val WindGenType3bIEC: String,

    /**
     * The pitch control power model with which this wind dynamics lookup table is associated.
     */
    val WindPitchContPowerIEC: String,

    /**
     * The frequency and active power wind plant control model with which this wind dynamics lookup table is associated.
     */
    val WindPlantFreqPcontrolIEC: String,

    /**
     * The voltage and reactive power wind plant control model with which this wind dynamics lookup table is associated.
     */
    val WindPlantReactiveControlIEC: String,

    /**
     * The grid protection model with which this wind dynamics lookup table is associated.
     */
    val WindProtectionIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, 0.0, 0, null, null, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindDynamicsLookupTable]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindDynamicsLookupTable
extends
    Parseable[WindDynamicsLookupTable]
{
    val sup = IdentifiedObject.parse _
    val input = parse_element (element ("""WindDynamicsLookupTable.input"""))_
    val lookupTableFunctionType = parse_attribute (attribute ("""WindDynamicsLookupTable.lookupTableFunctionType"""))_
    val output = parse_element (element ("""WindDynamicsLookupTable.output"""))_
    val sequence = parse_element (element ("""WindDynamicsLookupTable.sequence"""))_
    val WindContCurrLimIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContCurrLimIEC"""))_
    val WindContPType3IEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContPType3IEC"""))_
    val WindContQPQULimIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContQPQULimIEC"""))_
    val WindContRotorRIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContRotorRIEC"""))_
    val WindGenType3bIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindGenType3bIEC"""))_
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPitchContPowerIEC"""))_
    val WindPlantFreqPcontrolIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPlantFreqPcontrolIEC"""))_
    val WindPlantReactiveControlIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPlantReactiveControlIEC"""))_
    val WindProtectionIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindProtectionIEC"""))_
    def parse (context: Context): WindDynamicsLookupTable =
    {
        WindDynamicsLookupTable(
            sup (context),
            toDouble (input (context), context),
            lookupTableFunctionType (context),
            toDouble (output (context), context),
            toInteger (sequence (context), context),
            WindContCurrLimIEC (context),
            WindContPType3IEC (context),
            WindContQPQULimIEC (context),
            WindContRotorRIEC (context),
            WindGenType3bIEC (context),
            WindPitchContPowerIEC (context),
            WindPlantFreqPcontrolIEC (context),
            WindPlantReactiveControlIEC (context),
            WindProtectionIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 1A.
 * Reference: IEC Standard 61400-27-1, section 5.5.2.2.
 */
case class WindGenTurbineType1aIEC
(

    override val sup: WindTurbineType1or2IEC,

    /**
     * Wind aerodynamic model associated with this wind turbine type 1A model.
     */
    val WindAeroConstIEC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenTurbineType1aIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenTurbineType1aIEC
extends
    Parseable[WindGenTurbineType1aIEC]
{
    val sup = WindTurbineType1or2IEC.parse _
    val WindAeroConstIEC = parse_attribute (attribute ("""WindGenTurbineType1aIEC.WindAeroConstIEC"""))_
    def parse (context: Context): WindGenTurbineType1aIEC =
    {
        WindGenTurbineType1aIEC(
            sup (context),
            WindAeroConstIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 1B.
 * Reference: IEC Standard 61400-27-1, section 5.5.2.3.
 */
case class WindGenTurbineType1bIEC
(

    override val sup: WindTurbineType1or2IEC,

    /**
     * Pitch control power model associated with this wind turbine type 1B model.
     */
    val WindPitchContPowerIEC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenTurbineType1bIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenTurbineType1bIEC
extends
    Parseable[WindGenTurbineType1bIEC]
{
    val sup = WindTurbineType1or2IEC.parse _
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindGenTurbineType1bIEC.WindPitchContPowerIEC"""))_
    def parse (context: Context): WindGenTurbineType1bIEC =
    {
        WindGenTurbineType1bIEC(
            sup (context),
            WindPitchContPowerIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 2.
 * Reference: IEC Standard 61400-27-1, section 5.5.3.
 */
case class WindGenTurbineType2IEC
(

    override val sup: WindTurbineType1or2IEC,

    /**
     * Wind control rotor resistance model associated with wind turbine type 2 model.
     */
    val WindContRotorRIEC: String,

    /**
     * Pitch control power model associated with this wind turbine type 2 model.
     */
    val WindPitchContPowerIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenTurbineType2IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenTurbineType2IEC
extends
    Parseable[WindGenTurbineType2IEC]
{
    val sup = WindTurbineType1or2IEC.parse _
    val WindContRotorRIEC = parse_attribute (attribute ("""WindGenTurbineType2IEC.WindContRotorRIEC"""))_
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindGenTurbineType2IEC.WindPitchContPowerIEC"""))_
    def parse (context: Context): WindGenTurbineType2IEC =
    {
        WindGenTurbineType2IEC(
            sup (context),
            WindContRotorRIEC (context),
            WindPitchContPowerIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 generator models of IEC type 3A and 3B.
 */
case class WindGenType3IEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum active current ramp rate (di<sub>pmax</sub>).
     * It is project dependent parameter.
     */
    val dipmax: Double,

    /**
     * Maximum reactive current ramp rate (di<sub>qmax</sub>).
     * It is project dependent parameter.
     */
    val diqmax: Double,

    /**
     * Electromagnetic transient reactance (x<sub>S</sub>).
     * It is type dependent parameter.
     */
    val xs: Double,

    /**
     * Wind turbine type 3 model with which this wind generator type 3 is associated. 
     */
    val WindTurbineType3IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenType3IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenType3IEC
extends
    Parseable[WindGenType3IEC]
{
    val sup = IdentifiedObject.parse _
    val dipmax = parse_element (element ("""WindGenType3IEC.dipmax"""))_
    val diqmax = parse_element (element ("""WindGenType3IEC.diqmax"""))_
    val xs = parse_element (element ("""WindGenType3IEC.xs"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindGenType3IEC.WindTurbineType3IEC"""))_
    def parse (context: Context): WindGenType3IEC =
    {
        WindGenType3IEC(
            sup (context),
            toDouble (dipmax (context), context),
            toDouble (diqmax (context), context),
            toDouble (xs (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * IEC Type 3A generator set model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.2.
 */
case class WindGenType3aIEC
(

    override val sup: WindGenType3IEC,

    /**
     * Current PI controller proportional gain (K<sub>Pc</sub>).
     * It is type dependent parameter.
     */
    val kpc: Double,

    /**
     * Current PI controller integration time constant (T<sub>Ic</sub>).
     * It is type dependent parameter.
     */
    val tic: Double,

    /**
     * Wind turbine type 4 model with which this wind generator type 3A model is associated.
     */
    val WindTurbineType4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null) }
    def WindGenType3IEC: WindGenType3IEC = sup.asInstanceOf[WindGenType3IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenType3aIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenType3aIEC
extends
    Parseable[WindGenType3aIEC]
{
    val sup = WindGenType3IEC.parse _
    val kpc = parse_element (element ("""WindGenType3aIEC.kpc"""))_
    val tic = parse_element (element ("""WindGenType3aIEC.tic"""))_
    val WindTurbineType4IEC = parse_attribute (attribute ("""WindGenType3aIEC.WindTurbineType4IEC"""))_
    def parse (context: Context): WindGenType3aIEC =
    {
        WindGenType3aIEC(
            sup (context),
            toDouble (kpc (context), context),
            toDouble (tic (context), context),
            WindTurbineType4IEC (context)
        )
    }
}

/**
 * IEC Type 3B generator set model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.3.
 */
case class WindGenType3bIEC
(

    override val sup: WindGenType3IEC,

    /**
     * Crowbar control mode (<i>M</i><sub>WTcwp</sub>). 
    <ul>
    	<li>true = 1 in the model</li>
    	<li>false = 0 in the model.</li>
    </ul>
     * The parameter is case dependent parameter.
     */
    val mwtcwp: Boolean,

    /**
     * Current generation Time constant (<i>T</i><sub>g</sub>).
     * It is type dependent parameter.
     */
    val tg: Double,

    /**
     * Time constant for crowbar washout filter (<i>T</i><sub>wo</sub>).
     * It is case dependent parameter.
     */
    val two: Double
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0.0) }
    def WindGenType3IEC: WindGenType3IEC = sup.asInstanceOf[WindGenType3IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenType3bIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenType3bIEC
extends
    Parseable[WindGenType3bIEC]
{
    val sup = WindGenType3IEC.parse _
    val mwtcwp = parse_element (element ("""WindGenType3bIEC.mwtcwp"""))_
    val tg = parse_element (element ("""WindGenType3bIEC.tg"""))_
    val two = parse_element (element ("""WindGenType3bIEC.two"""))_
    def parse (context: Context): WindGenType3bIEC =
    {
        WindGenType3bIEC(
            sup (context),
            toBoolean (mwtcwp (context), context),
            toDouble (tg (context), context),
            toDouble (two (context), context)
        )
    }
}

/**
 * IEC Type 4 generator set model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.4.
 */
case class WindGenType4IEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum active current ramp rate (di<sub>pmax</sub>).
     * It is project dependent parameter.
     */
    val dipmax: Double,

    /**
     * Maximum reactive current ramp rate (di<sub>qmax</sub>).
     * It is project dependent parameter.
     */
    val diqmax: Double,

    /**
     * Minimum reactive current ramp rate (d<i>i</i><sub>qmin</sub>).
     * It is case dependent parameter.
     */
    val diqmin: Double,

    /**
     * Time constant (T<sub>g</sub>).
     * It is type dependent parameter.
     */
    val tg: Double,

    /**
     * Wind turbine type 4A model with which this wind generator type 4 model is associated.
     */
    val WindTurbineType4aIEC: String,

    /**
     * Wind turbine type 4B model with which this wind generator type 4 model is associated.
     */
    val WindTurbineType4bIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindGenType4IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindGenType4IEC
extends
    Parseable[WindGenType4IEC]
{
    val sup = IdentifiedObject.parse _
    val dipmax = parse_element (element ("""WindGenType4IEC.dipmax"""))_
    val diqmax = parse_element (element ("""WindGenType4IEC.diqmax"""))_
    val diqmin = parse_element (element ("""WindGenType4IEC.diqmin"""))_
    val tg = parse_element (element ("""WindGenType4IEC.tg"""))_
    val WindTurbineType4aIEC = parse_attribute (attribute ("""WindGenType4IEC.WindTurbineType4aIEC"""))_
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindGenType4IEC.WindTurbineType4bIEC"""))_
    def parse (context: Context): WindGenType4IEC =
    {
        WindGenType4IEC(
            sup (context),
            toDouble (dipmax (context), context),
            toDouble (diqmax (context), context),
            toDouble (diqmin (context), context),
            toDouble (tg (context), context),
            WindTurbineType4aIEC (context),
            WindTurbineType4bIEC (context)
        )
    }
}

/**
 * Function of the lookup table.
 */
case class WindLookupTableFunctionKind
(

    override val sup: BasicElement,

    /**
     * Lookup table for voltage dependency of active current limits (i<sub>pmax</sub>(u<sub>WT</sub>)).
     * It is used for current limitation model, IEC 61400-27-1, section 5.6.5.8.
     */
    val ipmax: String,

    /**
     * Lookup table for voltage dependency of reactive current limits (i<sub>qmax</sub>(u<sub>WT</sub>)).
     * It is used for current limitation model, IEC 61400-27-1, section 5.6.5.8.
     */
    val iqmax: String,

    /**
     * Power vs. speed lookup table (omega(p)).
     * It is used for P control model type 3, IEC 61400-27-1, section 5.6.5.4.
     */
    val omegap: String,

    /**
     * Power versus speed change (negative slip) lookup table (p<sub>rr</sub>(deltaomega)).
     * It is used for rotor resistance control model, IEC 61400-27-1, section 5.6.5.3.
     */
    val prr: String,

    /**
     * Power vs. frequency lookup table (p<sub>WPbias</sub>(f)).
     * It is used for wind power plant frequency and active power control model, IEC 61400-27-1, Annex D.
     */
    val pwp: String,

    /**
     * Lookup table for active power dependency of reactive power maximum limit (q<sub>maxp</sub>(p)).
     * It is used for QP and QU limitation model, IEC 61400-27-1, section 5.6.5.10.
     */
    val qmaxp: String,

    /**
     * Lookup table for voltage dependency of reactive power maximum limit (q<sub>maxu</sub>(p)).
     * It is used for QP and QU limitation model, IEC 61400-27-1, section 5.6.5.10.
     */
    val qmaxu: String,

    /**
     * Lookup table for active power dependency of reactive power minimum limit (q<sub>minp</sub>(p)).
     * It is used for QP and QU limitation model, IEC 61400-27-1, section 5.6.5.10.
     */
    val qminp: String,

    /**
     * Lookup table for voltage dependency of reactive power minimum limit (q<sub>minu</sub>(p)).
     * It is used for QP and QU limitation model, IEC 61400-27-1, section 5.6.5.10.
     */
    val qminu: String,

    /**
     * Look up table for the UQ static mode (q<sub>WP</sub>(u<sub>err</sub>)).
     * It is used for voltage and reactive power control model, IEC 61400-27-1, Annex D.
     */
    val qwp: String,

    /**
     * Crowbar duration versus voltage variation look-up table (T<sub>CW</sub>(du)).
     * It is case dependent parameter. It is used for type 3B generator set model, IEC 61400-27-1, section 5.6.3.3.
     */
    val tcwdu: String,

    /**
     * Lookup table to determine the duration of the power reduction after a voltage dip, depending on the size of the voltage dip (T<sub>d</sub>(u<sub>WT</sub>)).
     * It is type dependent parameter. It is used for pitch control power model, IEC 61400-27-1, section 5.6.5.1.
     */
    val tduwt: String,

    /**
     * Disconnection time versus over frequency lookup table (T<sub>fover</sub>(f<sub>WT</sub>)).
     * It is used for grid protection model, IEC 61400-27-1, section 5.6.6.
     */
    val tfover: String,

    /**
     * Disconnection time versus under frequency lookup table (T<sub>funder</sub>(f<sub>WT</sub>)).
     * It is used for grid protection model, IEC 61400-27-1, section 5.6.6.
     */
    val tfunder: String,

    /**
     * Disconnection time versus over voltage lookup table (T<sub>uover</sub>(u<sub>WT</sub>)).
     * It is used for grid protection model, IEC 61400-27-1, section 5.6.6.
     */
    val tuover: String,

    /**
     * Disconnection time versus under voltage lookup table (T<sub>uunder</sub>(u<sub>WT</sub>)).
     * It is used for grid protection model, IEC 61400-27-1, section 5.6.6.
     */
    val tuunder: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindLookupTableFunctionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindLookupTableFunctionKind
extends
    Parseable[WindLookupTableFunctionKind]
{
    val sup = BasicElement.parse _
    val ipmax = parse_attribute (attribute ("""WindLookupTableFunctionKind.ipmax"""))_
    val iqmax = parse_attribute (attribute ("""WindLookupTableFunctionKind.iqmax"""))_
    val omegap = parse_attribute (attribute ("""WindLookupTableFunctionKind.omegap"""))_
    val prr = parse_attribute (attribute ("""WindLookupTableFunctionKind.prr"""))_
    val pwp = parse_attribute (attribute ("""WindLookupTableFunctionKind.pwp"""))_
    val qmaxp = parse_attribute (attribute ("""WindLookupTableFunctionKind.qmaxp"""))_
    val qmaxu = parse_attribute (attribute ("""WindLookupTableFunctionKind.qmaxu"""))_
    val qminp = parse_attribute (attribute ("""WindLookupTableFunctionKind.qminp"""))_
    val qminu = parse_attribute (attribute ("""WindLookupTableFunctionKind.qminu"""))_
    val qwp = parse_attribute (attribute ("""WindLookupTableFunctionKind.qwp"""))_
    val tcwdu = parse_attribute (attribute ("""WindLookupTableFunctionKind.tcwdu"""))_
    val tduwt = parse_attribute (attribute ("""WindLookupTableFunctionKind.tduwt"""))_
    val tfover = parse_attribute (attribute ("""WindLookupTableFunctionKind.tfover"""))_
    val tfunder = parse_attribute (attribute ("""WindLookupTableFunctionKind.tfunder"""))_
    val tuover = parse_attribute (attribute ("""WindLookupTableFunctionKind.tuover"""))_
    val tuunder = parse_attribute (attribute ("""WindLookupTableFunctionKind.tuunder"""))_
    def parse (context: Context): WindLookupTableFunctionKind =
    {
        WindLookupTableFunctionKind(
            sup (context),
            ipmax (context),
            iqmax (context),
            omegap (context),
            prr (context),
            pwp (context),
            qmaxp (context),
            qmaxu (context),
            qminp (context),
            qminu (context),
            qwp (context),
            tcwdu (context),
            tduwt (context),
            tfover (context),
            tfunder (context),
            tuover (context),
            tuunder (context)
        )
    }
}

/**
 * Two mass model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.2.1.
 */
case class WindMechIEC
(

    override val sup: IdentifiedObject,

    /**
     * Drive train damping (<i>c</i><i><sub>drt</sub></i><i>)</i>.
     * It is type dependent parameter.
     */
    val cdrt: Double,

    /**
     * Inertia constant of generator (<i>H</i><sub>gen</sub>).
     * It is type dependent parameter.
     */
    val hgen: Double,

    /**
     * Inertia constant of wind turbine rotor (<i>H</i><sub>WTR</sub>).
     * It is type dependent parameter.
     */
    val hwtr: Double,

    /**
     * Drive train stiffness (<i>k</i><i><sub>drt</sub></i>).
     * It is type dependent parameter.
     */
    val kdrt: Double,

    /**
     * Wind generator type 1 or 2 model with which this wind mechanical model is associated.
     */
    val WindTurbineType1or2IEC: String,

    /**
     * Wind turbine Type 3 model with which this wind mechanical model is associated.
     */
    val WindTurbineType3IEC: String,

    /**
     * Wind turbine type 4B model with which this wind mechanical model is associated.
     */
    val WindTurbineType4bIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindMechIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindMechIEC
extends
    Parseable[WindMechIEC]
{
    val sup = IdentifiedObject.parse _
    val cdrt = parse_element (element ("""WindMechIEC.cdrt"""))_
    val hgen = parse_element (element ("""WindMechIEC.hgen"""))_
    val hwtr = parse_element (element ("""WindMechIEC.hwtr"""))_
    val kdrt = parse_element (element ("""WindMechIEC.kdrt"""))_
    val WindTurbineType1or2IEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType1or2IEC"""))_
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType3IEC"""))_
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType4bIEC"""))_
    def parse (context: Context): WindMechIEC =
    {
        WindMechIEC(
            sup (context),
            toDouble (cdrt (context), context),
            toDouble (hgen (context), context),
            toDouble (hwtr (context), context),
            toDouble (kdrt (context), context),
            WindTurbineType1or2IEC (context),
            WindTurbineType3IEC (context),
            WindTurbineType4bIEC (context)
        )
    }
}

/**
 * Pitch control power model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.1.
 */
case class WindPitchContPowerIEC
(

    override val sup: IdentifiedObject,

    /**
     * Rate limit for increasing power (d<i>p</i><sub>max</sub>).
     * It is type dependent parameter.
     */
    val dpmax: Double,

    /**
     * Rate limit for decreasing power (d<i>p</i><sub>min</sub>).
     * It is type dependent parameter.
     */
    val dpmin: Double,

    /**
     * Minimum power setting (<i>p</i><sub>min</sub>).
     * It is type dependent parameter.
     */
    val pmin: Double,

    /**
     * If <i>p</i><sub>init </sub>&lt; <i>p</i><sub>set </sub>then power will ne ramped down to <i>p</i><sub>min</sub>.
     * It is (<i>p</i><sub>set</sub>) in the IEC 61400-27-1. It is type dependent parameter.
     */
    val pset: Double,

    /**
     * Lag time constant (<i>T</i><sub>1</sub>).
     * It is type dependent parameter.
     */
    val t1: Double,

    /**
     * Voltage measurement time constant (<i>T</i><sub>r</sub>).
     * It is type dependent parameter.
     */
    val tr: Double,

    /**
     * Dip detection threshold (u<sub>UVRT</sub>).
     * It is type dependent parameter.
     */
    val uuvrt: Double,

    /**
     * Wind turbine type 1B model with which this Pitch control power model is associated.
     */
    val WindGenTurbineType1bIEC: String,

    /**
     * Wind turbine type 2 model with which this Pitch control power model is associated.
     */
    val WindGenTurbineType2IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPitchContPowerIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPitchContPowerIEC
extends
    Parseable[WindPitchContPowerIEC]
{
    val sup = IdentifiedObject.parse _
    val dpmax = parse_element (element ("""WindPitchContPowerIEC.dpmax"""))_
    val dpmin = parse_element (element ("""WindPitchContPowerIEC.dpmin"""))_
    val pmin = parse_element (element ("""WindPitchContPowerIEC.pmin"""))_
    val pset = parse_element (element ("""WindPitchContPowerIEC.pset"""))_
    val t1 = parse_element (element ("""WindPitchContPowerIEC.t1"""))_
    val tr = parse_element (element ("""WindPitchContPowerIEC.tr"""))_
    val uuvrt = parse_element (element ("""WindPitchContPowerIEC.uuvrt"""))_
    val WindGenTurbineType1bIEC = parse_attribute (attribute ("""WindPitchContPowerIEC.WindGenTurbineType1bIEC"""))_
    val WindGenTurbineType2IEC = parse_attribute (attribute ("""WindPitchContPowerIEC.WindGenTurbineType2IEC"""))_
    def parse (context: Context): WindPitchContPowerIEC =
    {
        WindPitchContPowerIEC(
            sup (context),
            toDouble (dpmax (context), context),
            toDouble (dpmin (context), context),
            toDouble (pmin (context), context),
            toDouble (pset (context), context),
            toDouble (t1 (context), context),
            toDouble (tr (context), context),
            toDouble (uuvrt (context), context),
            WindGenTurbineType1bIEC (context),
            WindGenTurbineType2IEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to wind turbines Type 3 and 4 and wind plant IEC and user defined wind plants including their control models.
 */
case class WindPlantDynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * The remote signal with which this power plant is associated.
     */
    val RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantDynamics
extends
    Parseable[WindPlantDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val RemoteInputSignal = parse_attribute (attribute ("""WindPlantDynamics.RemoteInputSignal"""))_
    def parse (context: Context): WindPlantDynamics =
    {
        WindPlantDynamics(
            sup (context),
            RemoteInputSignal (context)
        )
    }
}

/**
 * Frequency and active power controller model.
 * Reference: IEC Standard 61400-27-1 Annex D.
 */
case class WindPlantFreqPcontrolIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum ramp rate of <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>dp</i><sub>refmax</sub>).
     * It is case dependent parameter.
     */
    val dprefmax: Double,

    /**
     * Minimum (negative) ramp rate of <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>dp</i><sub>refmin</sub>).
     * It is project dependent parameter.
     */
    val dprefmin: Double,

    /**
     * Maximum positive ramp rate for wind plant power reference (<i>dp</i><sub>WPrefmax</sub>).
     * It is project dependent parameter.
     */
    val dpwprefmax: Double,

    /**
     * Maximum negative ramp rate for wind plant power reference (<i>dp</i><sub>WPrefmin</sub>).
     * It is project dependent parameter.
     */
    val dpwprefmin: Double,

    /**
     * Plant P controller integral gain (<i>K</i><sub>IWPp</sub>).
     * It is project dependent parameter.
     */
    val kiwpp: Double,

    /**
     * Maximum PI integrator term (<i>K</i><sub>IWPpmax</sub>).
     * It is project dependent parameter.
     */
    val kiwppmax: Double,

    /**
     * Minimum PI integrator term (<i>K</i><sub>IWPpmin</sub>).
     * It is project dependent parameter.
     */
    val kiwppmin: Double,

    /**
     * Plant P controller proportional gain (<i>K</i><sub>PWPp</sub>).
     * It is project dependent parameter.
     */
    val kpwpp: Double,

    /**
     * Power reference gain (<i>K</i><sub>WPpref</sub>).
     * It is project dependent parameter.
     */
    val kwppref: Double,

    /**
     * Maximum <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>p</i><sub>refmax</sub>).
     * It is project dependent parameter.
     */
    val prefmax: Double,

    /**
     * Minimum <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>p</i><sub>refmin</sub>).
     * It is project dependent parameter.
     */
    val prefmin: Double,

    /**
     * Lead time constant in reference value transfer function (<i>T</i><sub>pft</sub>).
     * It is project dependent parameter.
     */
    val tpft: Double,

    /**
     * Lag time constant in reference value transfer function (<i>T</i><sub>pfv</sub>).
     * It is project dependent parameter.
     */
    val tpfv: Double,

    /**
     * Filter time constant for frequency measurement (<i>T</i><sub>WPffiltp</sub>).
     * It is project dependent parameter.
     */
    val twpffiltp: Double,

    /**
     * Filter time constant for active power measurement (<i>T</i><sub>WPpfiltp</sub>).
     * It is project dependent parameter.
     */
    val twppfiltp: Double,

    /**
     * Wind plant model with which this wind plant frequency and active power control is associated.
     */
    val WindPlantIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantFreqPcontrolIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantFreqPcontrolIEC
extends
    Parseable[WindPlantFreqPcontrolIEC]
{
    val sup = IdentifiedObject.parse _
    val dprefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.dprefmax"""))_
    val dprefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.dprefmin"""))_
    val dpwprefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.dpwprefmax"""))_
    val dpwprefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.dpwprefmin"""))_
    val kiwpp = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwpp"""))_
    val kiwppmax = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwppmax"""))_
    val kiwppmin = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwppmin"""))_
    val kpwpp = parse_element (element ("""WindPlantFreqPcontrolIEC.kpwpp"""))_
    val kwppref = parse_element (element ("""WindPlantFreqPcontrolIEC.kwppref"""))_
    val prefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.prefmax"""))_
    val prefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.prefmin"""))_
    val tpft = parse_element (element ("""WindPlantFreqPcontrolIEC.tpft"""))_
    val tpfv = parse_element (element ("""WindPlantFreqPcontrolIEC.tpfv"""))_
    val twpffiltp = parse_element (element ("""WindPlantFreqPcontrolIEC.twpffiltp"""))_
    val twppfiltp = parse_element (element ("""WindPlantFreqPcontrolIEC.twppfiltp"""))_
    val WindPlantIEC = parse_attribute (attribute ("""WindPlantFreqPcontrolIEC.WindPlantIEC"""))_
    def parse (context: Context): WindPlantFreqPcontrolIEC =
    {
        WindPlantFreqPcontrolIEC(
            sup (context),
            toDouble (dprefmax (context), context),
            toDouble (dprefmin (context), context),
            toDouble (dpwprefmax (context), context),
            toDouble (dpwprefmin (context), context),
            toDouble (kiwpp (context), context),
            toDouble (kiwppmax (context), context),
            toDouble (kiwppmin (context), context),
            toDouble (kpwpp (context), context),
            toDouble (kwppref (context), context),
            toDouble (prefmax (context), context),
            toDouble (prefmin (context), context),
            toDouble (tpft (context), context),
            toDouble (tpfv (context), context),
            toDouble (twpffiltp (context), context),
            toDouble (twppfiltp (context), context),
            WindPlantIEC (context)
        )
    }
}

/**
 * Simplified IEC type plant level model.
 * Reference: IEC 61400-27-1, Annex D.
 */
case class WindPlantIEC
(

    override val sup: WindPlantDynamics,

    /**
     * Wind plant frequency and active power control model associated with this wind plant.
     */
    val WindPlantFreqPcontrolIEC: String,

    /**
     * Wind plant model with which this wind reactive control is associated.
     */
    val WindPlantReactiveControlIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WindPlantDynamics: WindPlantDynamics = sup.asInstanceOf[WindPlantDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantIEC
extends
    Parseable[WindPlantIEC]
{
    val sup = WindPlantDynamics.parse _
    val WindPlantFreqPcontrolIEC = parse_attribute (attribute ("""WindPlantIEC.WindPlantFreqPcontrolIEC"""))_
    val WindPlantReactiveControlIEC = parse_attribute (attribute ("""WindPlantIEC.WindPlantReactiveControlIEC"""))_
    def parse (context: Context): WindPlantIEC =
    {
        WindPlantIEC(
            sup (context),
            WindPlantFreqPcontrolIEC (context),
            WindPlantReactiveControlIEC (context)
        )
    }
}

/**
 * Reactive power/voltage controller mode.
 */
case class WindPlantQcontrolModeKind
(

    override val sup: BasicElement,

    /**
     * Power factor reference.
     */
    val powerFactor: String,

    /**
     * Reactive power reference.
     */
    val reactivePower: String,

    /**
     * UQ static.
     */
    val uqStatic: String,

    /**
     * Voltage control.
     */
    val voltageControl: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantQcontrolModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantQcontrolModeKind
extends
    Parseable[WindPlantQcontrolModeKind]
{
    val sup = BasicElement.parse _
    val powerFactor = parse_attribute (attribute ("""WindPlantQcontrolModeKind.powerFactor"""))_
    val reactivePower = parse_attribute (attribute ("""WindPlantQcontrolModeKind.reactivePower"""))_
    val uqStatic = parse_attribute (attribute ("""WindPlantQcontrolModeKind.uqStatic"""))_
    val voltageControl = parse_attribute (attribute ("""WindPlantQcontrolModeKind.voltageControl"""))_
    def parse (context: Context): WindPlantQcontrolModeKind =
    {
        WindPlantQcontrolModeKind(
            sup (context),
            powerFactor (context),
            reactivePower (context),
            uqStatic (context),
            voltageControl (context)
        )
    }
}

/**
 * Simplified plant voltage and reactive power control model for use with type 3 and type 4 wind turbine models.
 * Reference: IEC Standard 61400-27-1 Annex D.
 */
case class WindPlantReactiveControlIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum positive ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><sub>refmax</sub>).
     * It is project dependent parameter.
     */
    val dxrefmax: Double,

    /**
     * Maximum negative ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><sub>refmin</sub>).
     * It is project dependent parameter.
     */
    val dxrefmin: Double,

    /**
     * Plant Q controller integral gain (<i>K</i><sub>IWPx</sub>).
     * It is project dependent parameter.
     */
    val kiwpx: Double,

    /**
     * Maximum reactive Power/voltage reference from integration (<i>K</i><sub>IWPxmax</sub>).
     * It is project dependent parameter.
     */
    val kiwpxmax: Double,

    /**
     * Minimum reactive Power/voltage reference from integration (<i>K</i><sub>IWPxmin</sub>).
     * It is project dependent parameter.
     */
    val kiwpxmin: Double,

    /**
     * Plant Q controller proportional gain (<i>K</i><sub>PWPx</sub>).
     * It is project dependent parameter.
     */
    val kpwpx: Double,

    /**
     * Reactive power reference gain (<i>K</i><sub>WPqref</sub>).
     * It is project dependent parameter.
     */
    val kwpqref: Double,

    /**
     * Plant voltage control droop (<i>K</i><sub>WPqu</sub>).
     * It is project dependent parameter.
     */
    val kwpqu: Double,

    /**
     * Filter time constant for voltage dependent reactive power (<i>T</i><sub>uqfilt</sub>).
     * It is project dependent parameter.
     */
    val tuqfilt: Double,

    /**
     * Filter time constant for active power measurement (<i>T</i><sub>WPpfiltq</sub>).
     * It is project dependent parameter.
     */
    val twppfiltq: Double,

    /**
     * Filter time constant for reactive power measurement (<i>T</i><sub>WPqfiltq</sub>).
     * It is project dependent parameter.
     */
    val twpqfiltq: Double,

    /**
     * Filter time constant for voltage measurement (<i>T</i><sub>WPufiltq</sub>).
     * It is project dependent parameter.
     */
    val twpufiltq: Double,

    /**
     * Lead time constant in reference value transfer function (<i>T</i><sub>xft</sub>).
     * It is project dependent parameter.
     */
    val txft: Double,

    /**
     * Lag time constant in reference value transfer function (<i>T</i><sub>xfv</sub>).
     * It is project dependent parameter.
     */
    val txfv: Double,

    /**
     * Voltage threshold for UVRT detection in q control (<i>u</i><sub>WPqdip</sub>).
     * It is project dependent parameter.
     */
    val uwpqdip: Double,

    /**
     * Reactive power/voltage controller mode (<i>M</i><sub>WPqmode</sub>).
     * It is case dependent parameter.
     */
    val windPlantQcontrolModesType: String,

    /**
     * Maximum <i>x</i><sub>WTref</sub> (<i>q</i><sub>WTref</sub> or delta <i>u</i><sub>WTref</sub>) request from the plant controller (<i>x</i><sub>refmax</sub>).
     * It is case dependent parameter.
     */
    val xrefmax: Double,

    /**
     * Minimum <i>x</i><sub>WTref</sub> (<i>q</i><sub>WTref</sub> or delta<i>u</i><sub>WTref</sub>) request from the plant controller (<i>x</i><sub>refmin</sub>).
     * It is project dependent parameter.
     */
    val xrefmin: Double,

    /**
     * Wind plant reactive control model associated with this wind plant.
     */
    val WindPlantIEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantReactiveControlIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantReactiveControlIEC
extends
    Parseable[WindPlantReactiveControlIEC]
{
    val sup = IdentifiedObject.parse _
    val dxrefmax = parse_element (element ("""WindPlantReactiveControlIEC.dxrefmax"""))_
    val dxrefmin = parse_element (element ("""WindPlantReactiveControlIEC.dxrefmin"""))_
    val kiwpx = parse_element (element ("""WindPlantReactiveControlIEC.kiwpx"""))_
    val kiwpxmax = parse_element (element ("""WindPlantReactiveControlIEC.kiwpxmax"""))_
    val kiwpxmin = parse_element (element ("""WindPlantReactiveControlIEC.kiwpxmin"""))_
    val kpwpx = parse_element (element ("""WindPlantReactiveControlIEC.kpwpx"""))_
    val kwpqref = parse_element (element ("""WindPlantReactiveControlIEC.kwpqref"""))_
    val kwpqu = parse_element (element ("""WindPlantReactiveControlIEC.kwpqu"""))_
    val tuqfilt = parse_element (element ("""WindPlantReactiveControlIEC.tuqfilt"""))_
    val twppfiltq = parse_element (element ("""WindPlantReactiveControlIEC.twppfiltq"""))_
    val twpqfiltq = parse_element (element ("""WindPlantReactiveControlIEC.twpqfiltq"""))_
    val twpufiltq = parse_element (element ("""WindPlantReactiveControlIEC.twpufiltq"""))_
    val txft = parse_element (element ("""WindPlantReactiveControlIEC.txft"""))_
    val txfv = parse_element (element ("""WindPlantReactiveControlIEC.txfv"""))_
    val uwpqdip = parse_element (element ("""WindPlantReactiveControlIEC.uwpqdip"""))_
    val windPlantQcontrolModesType = parse_attribute (attribute ("""WindPlantReactiveControlIEC.windPlantQcontrolModesType"""))_
    val xrefmax = parse_element (element ("""WindPlantReactiveControlIEC.xrefmax"""))_
    val xrefmin = parse_element (element ("""WindPlantReactiveControlIEC.xrefmin"""))_
    val WindPlantIEC = parse_attribute (attribute ("""WindPlantReactiveControlIEC.WindPlantIEC"""))_
    def parse (context: Context): WindPlantReactiveControlIEC =
    {
        WindPlantReactiveControlIEC(
            sup (context),
            toDouble (dxrefmax (context), context),
            toDouble (dxrefmin (context), context),
            toDouble (kiwpx (context), context),
            toDouble (kiwpxmax (context), context),
            toDouble (kiwpxmin (context), context),
            toDouble (kpwpx (context), context),
            toDouble (kwpqref (context), context),
            toDouble (kwpqu (context), context),
            toDouble (tuqfilt (context), context),
            toDouble (twppfiltq (context), context),
            toDouble (twpqfiltq (context), context),
            toDouble (twpufiltq (context), context),
            toDouble (txft (context), context),
            toDouble (txfv (context), context),
            toDouble (uwpqdip (context), context),
            windPlantQcontrolModesType (context),
            toDouble (xrefmax (context), context),
            toDouble (xrefmin (context), context),
            WindPlantIEC (context)
        )
    }
}

/**
 * The grid protection model includes protection against over and under voltage, and against over and under frequency.
 * Reference: IEC Standard 614000-27-1 Section 5.6.6.
 */
case class WindProtectionIEC
(

    override val sup: IdentifiedObject,

    /**
     * Maximum rate of change of frequency (<i>dF</i><i><sub>max</sub></i>).
     * It is type dependent parameter.
     */
    val dfimax: Double,

    /**
     * Wind turbine over frequency protection activation threshold (<i>f</i><i><sub>over</sub></i>).
     * It is project dependent parameter.
     */
    val fover: Double,

    /**
     * Wind turbine under frequency protection activation threshold (<i>f</i><i><sub>under</sub></i>).
     * It is project dependent parameter.
     */
    val funder: Double,

    /**
     * Zero crossing measurement mode (<i>Mzc</i>).
     * True = 1 if the WT protection system uses zero crossings to detect frequency � otherwise false = 0. It is type dependent parameter.
     */
    val mzc: Boolean,

    /**
     * Time interval of moving average window (<i>TfMA</i>).
     * It is type dependent parameter.
     */
    val tfma: Double,

    /**
     * Wind turbine over voltage protection activation threshold (<i>u</i><i><sub>over</sub></i>).
     * It is project dependent parameter.
     */
    val uover: Double,

    /**
     * Wind turbine under voltage protection activation threshold (<i>u</i><i><sub>under</sub></i>).
     * It is project dependent parameter.
     */
    val uunder: Double,

    /**
     * Wind generator type 1 or 2 model with which this wind turbine protection model is associated.
     */
    val WindTurbineType1or2IEC: String,

    /**
     * Wind generator type 3 or 4 model with which this wind turbine protection model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindProtectionIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindProtectionIEC
extends
    Parseable[WindProtectionIEC]
{
    val sup = IdentifiedObject.parse _
    val dfimax = parse_element (element ("""WindProtectionIEC.dfimax"""))_
    val fover = parse_element (element ("""WindProtectionIEC.fover"""))_
    val funder = parse_element (element ("""WindProtectionIEC.funder"""))_
    val mzc = parse_element (element ("""WindProtectionIEC.mzc"""))_
    val tfma = parse_element (element ("""WindProtectionIEC.tfma"""))_
    val uover = parse_element (element ("""WindProtectionIEC.uover"""))_
    val uunder = parse_element (element ("""WindProtectionIEC.uunder"""))_
    val WindTurbineType1or2IEC = parse_attribute (attribute ("""WindProtectionIEC.WindTurbineType1or2IEC"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindProtectionIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindProtectionIEC =
    {
        WindProtectionIEC(
            sup (context),
            toDouble (dfimax (context), context),
            toDouble (fover (context), context),
            toDouble (funder (context), context),
            toBoolean (mzc (context), context),
            toDouble (tfma (context), context),
            toDouble (uover (context), context),
            toDouble (uunder (context), context),
            WindTurbineType1or2IEC (context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * General wind turbine Q control modes <i>M</i><sub>qG</sub>.
 */
case class WindQcontrolModeKind
(

    override val sup: BasicElement,

    /**
     * Open loop reactive power control (only used with closed loop at plant level) (<i>M</i><i><sub>q</sub></i><sub>G </sub>equals 2).
     */
    val openLoopReactivePower: String,

    /**
     * Open loop power factor control (<i>M</i><i><sub>q</sub></i><sub>G </sub>equals 4).
     */
    val openLooppowerFactor: String,

    /**
     * Power factor control (<i>M</i><i><sub>q</sub></i><sub>G </sub>equals 3).
     */
    val powerFactor: String,

    /**
     * Reactive power control (<i>M</i><i><sub>q</sub></i><sub>G</sub> equals 1).
     */
    val reactivePower: String,

    /**
     * Voltage control (<i>M</i><i><sub>q</sub></i><sub>G</sub> equals 0).
     */
    val voltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindQcontrolModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindQcontrolModeKind
extends
    Parseable[WindQcontrolModeKind]
{
    val sup = BasicElement.parse _
    val openLoopReactivePower = parse_attribute (attribute ("""WindQcontrolModeKind.openLoopReactivePower"""))_
    val openLooppowerFactor = parse_attribute (attribute ("""WindQcontrolModeKind.openLooppowerFactor"""))_
    val powerFactor = parse_attribute (attribute ("""WindQcontrolModeKind.powerFactor"""))_
    val reactivePower = parse_attribute (attribute ("""WindQcontrolModeKind.reactivePower"""))_
    val voltage = parse_attribute (attribute ("""WindQcontrolModeKind.voltage"""))_
    def parse (context: Context): WindQcontrolModeKind =
    {
        WindQcontrolModeKind(
            sup (context),
            openLoopReactivePower (context),
            openLooppowerFactor (context),
            powerFactor (context),
            reactivePower (context),
            voltage (context)
        )
    }
}

/**
 * Reference frame rotation model.
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.5.
 */
case class WindRefFrameRotIEC
(

    override val sup: IdentifiedObject,

    /**
     * Time constant for PLL first order filter model (T<sub>PLL</sub>).
     * It is type dependent parameter.
     */
    val tpll: Double,

    /**
     * Voltage below which the angle of the voltage is filtered and possibly also frozen (u<sub>PLL1</sub>).
     * It is type dependent parameter.
     */
    val upll1: Double,

    /**
     * Voltage (u<sub>PLL2</sub>) below which the angle of the voltage is frozen if u<sub>PLL2 </sub>is smaller or equal to u<sub>PLL1</sub> .
     * It is type dependent parameter.
     */
    val upll2: Double,

    /**
     * Wind turbine type 3 or 4 model with which this reference frame rotation model is associated.
     */
    val WindTurbineType3or4IEC: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[WindRefFrameRotIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindRefFrameRotIEC
extends
    Parseable[WindRefFrameRotIEC]
{
    val sup = IdentifiedObject.parse _
    val tpll = parse_element (element ("""WindRefFrameRotIEC.tpll"""))_
    val upll1 = parse_element (element ("""WindRefFrameRotIEC.upll1"""))_
    val upll2 = parse_element (element ("""WindRefFrameRotIEC.upll2"""))_
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindRefFrameRotIEC.WindTurbineType3or4IEC"""))_
    def parse (context: Context): WindRefFrameRotIEC =
    {
        WindRefFrameRotIEC(
            sup (context),
            toDouble (tpll (context), context),
            toDouble (upll1 (context), context),
            toDouble (upll2 (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to wind turbines Type 1 and 2 and their control models.
 */
case class WindTurbineType1or2Dynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Asynchronous machine model with which this wind generator type 1 or 2 model is associated.
     */
    val AsynchronousMachineDynamics: String,

    /**
     * Remote input signal used by this wind generator Type 1 or Type 2 model.
     */
    val RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType1or2Dynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType1or2Dynamics
extends
    Parseable[WindTurbineType1or2Dynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""WindTurbineType1or2Dynamics.AsynchronousMachineDynamics"""))_
    val RemoteInputSignal = parse_attribute (attribute ("""WindTurbineType1or2Dynamics.RemoteInputSignal"""))_
    def parse (context: Context): WindTurbineType1or2Dynamics =
    {
        WindTurbineType1or2Dynamics(
            sup (context),
            AsynchronousMachineDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 1 and 2 including their control models.
 * Generator model for wind turbine of IEC Type 1 or Type 2 is a standard asynchronous generator model.
 */
case class WindTurbineType1or2IEC
(

    override val sup: WindTurbineType1or2Dynamics,

    /**
     * Wind mechanical model associated with this wind generator type 1 or 2 model.
     */
    val WindMechIEC: String,

    /**
     * Wind turbune protection model associated with this wind generator type 1 or 2 model.
     */
    val WindProtectionIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = sup.asInstanceOf[WindTurbineType1or2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType1or2IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType1or2IEC
extends
    Parseable[WindTurbineType1or2IEC]
{
    val sup = WindTurbineType1or2Dynamics.parse _
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType1or2IEC.WindMechIEC"""))_
    val WindProtectionIEC = parse_attribute (attribute ("""WindTurbineType1or2IEC.WindProtectionIEC"""))_
    def parse (context: Context): WindTurbineType1or2IEC =
    {
        WindTurbineType1or2IEC(
            sup (context),
            WindMechIEC (context),
            WindProtectionIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 including their control models.
 */
case class WindTurbineType3IEC
(

    override val sup: WindTurbineType3or4IEC,

    /**
     * Wind aerodynamic model associated with this wind generator type 3 model.
     */
    val WindAeroOneDimIEC: String,

    /**
     * Wind aerodynamic model associated with this wind turbine type 3 model.
     */
    val WindAeroTwoDimIEC: String,

    /**
     * Wind control P type 3 model associated with this wind turbine type 3 model.
     */
    val WindContPType3IEC: String,

    /**
     * Wind control pitch angle model associated with this wind turbine type 3.
     */
    val WindContPitchAngleIEC: String,

    /**
     * Wind generator Type 3 model associated with this wind turbine type 3 model.
     */
    val WindGenType3IEC: String,

    /**
     * Wind mechanical model associated with this wind turbine Type 3 model.
     */
    val WindMechIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup.asInstanceOf[WindTurbineType3or4IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType3IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType3IEC
extends
    Parseable[WindTurbineType3IEC]
{
    val sup = WindTurbineType3or4IEC.parse _
    val WindAeroOneDimIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindAeroOneDimIEC"""))_
    val WindAeroTwoDimIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindAeroTwoDimIEC"""))_
    val WindContPType3IEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindContPType3IEC"""))_
    val WindContPitchAngleIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindContPitchAngleIEC"""))_
    val WindGenType3IEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindGenType3IEC"""))_
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindMechIEC"""))_
    def parse (context: Context): WindTurbineType3IEC =
    {
        WindTurbineType3IEC(
            sup (context),
            WindAeroOneDimIEC (context),
            WindAeroTwoDimIEC (context),
            WindContPType3IEC (context),
            WindContPitchAngleIEC (context),
            WindGenType3IEC (context),
            WindMechIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to wind turbines Type 3 and 4 and wind plant including their control models.
 */
case class WindTurbineType3or4Dynamics
(

    override val sup: DynamicsFunctionBlock,

    /**
     * Energy Source (current source) with which this wind Type 3 or 4 dynamics model is asoociated.
     */
    val EnergySource: String,

    /**
     * Remote input signal used by these wind turbine Type 3 or 4 models.
     */
    val RemoteInputSignal: String,

    /**
     * The wind plant with which the wind turbines type 3 or 4 are associated.
     */
    val WindPlantDynamics: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType3or4Dynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType3or4Dynamics
extends
    Parseable[WindTurbineType3or4Dynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val EnergySource = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.EnergySource"""))_
    val RemoteInputSignal = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.RemoteInputSignal"""))_
    val WindPlantDynamics = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.WindPlantDynamics"""))_
    def parse (context: Context): WindTurbineType3or4Dynamics =
    {
        WindTurbineType3or4Dynamics(
            sup (context),
            EnergySource (context),
            RemoteInputSignal (context),
            WindPlantDynamics (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 and 4 including their control models.
 */
case class WindTurbineType3or4IEC
(

    override val sup: WindTurbineType3or4Dynamics,

    /**
     * Wind control Q model associated with this wind turbine type 3 or 4 model.
     */
    val WIndContQIEC: String,

    /**
     * Wind control current limitation model associated with this wind turbine type 3 or 4 model.
     */
    val WindContCurrLimIEC: String,

    /**
     * Constant Q limitation model associated with this wind generator type 3 or 4 model.
     */
    val WindContQLimIEC: String,

    /**
     * QP and QU limitation model associated with this wind generator type 3 or 4 model.
     */
    val WindContQPQULimIEC: String,

    /**
     * Wind turbune protection model associated with this wind generator type 3 or 4 model.
     */
    val WindProtectionIEC: String,

    /**
     * Reference frame rotation model associated with this wind turbine type 3 or 4 model.
     */
    val WindRefFrameRotIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = sup.asInstanceOf[WindTurbineType3or4Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType3or4IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType3or4IEC
extends
    Parseable[WindTurbineType3or4IEC]
{
    val sup = WindTurbineType3or4Dynamics.parse _
    val WIndContQIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WIndContQIEC"""))_
    val WindContCurrLimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContCurrLimIEC"""))_
    val WindContQLimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContQLimIEC"""))_
    val WindContQPQULimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContQPQULimIEC"""))_
    val WindProtectionIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindProtectionIEC"""))_
    val WindRefFrameRotIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindRefFrameRotIEC"""))_
    def parse (context: Context): WindTurbineType3or4IEC =
    {
        WindTurbineType3or4IEC(
            sup (context),
            WIndContQIEC (context),
            WindContCurrLimIEC (context),
            WindContQLimIEC (context),
            WindContQPQULimIEC (context),
            WindProtectionIEC (context),
            WindRefFrameRotIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 4 including their control models.
 */
case class WindTurbineType4IEC
(

    override val sup: WindTurbineType3or4IEC,

    /**
     * Wind generator type 3A model associated with this wind turbine type 4 model.
     */
    val WindGenType3aIEC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup.asInstanceOf[WindTurbineType3or4IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType4IEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType4IEC
extends
    Parseable[WindTurbineType4IEC]
{
    val sup = WindTurbineType3or4IEC.parse _
    val WindGenType3aIEC = parse_attribute (attribute ("""WindTurbineType4IEC.WindGenType3aIEC"""))_
    def parse (context: Context): WindTurbineType4IEC =
    {
        WindTurbineType4IEC(
            sup (context),
            WindGenType3aIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 4A.
 * Reference: IEC Standard 61400-27-1, section 5.5.5.3.
 */
case class WindTurbineType4aIEC
(

    override val sup: WindTurbineType4IEC,

    /**
     * Wind control P type 4A model associated with this wind turbine type 4A model.
     */
    val WindContPType4aIEC: String,

    /**
     * Wind generator type 4 model associated with this wind turbine type 4A model.
     */
    val WindGenType4IEC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def WindTurbineType4IEC: WindTurbineType4IEC = sup.asInstanceOf[WindTurbineType4IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType4aIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType4aIEC
extends
    Parseable[WindTurbineType4aIEC]
{
    val sup = WindTurbineType4IEC.parse _
    val WindContPType4aIEC = parse_attribute (attribute ("""WindTurbineType4aIEC.WindContPType4aIEC"""))_
    val WindGenType4IEC = parse_attribute (attribute ("""WindTurbineType4aIEC.WindGenType4IEC"""))_
    def parse (context: Context): WindTurbineType4aIEC =
    {
        WindTurbineType4aIEC(
            sup (context),
            WindContPType4aIEC (context),
            WindGenType4IEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 4A.
 * Reference: IEC Standard 61400-27-1, section 5.5.5.2.
 */
case class WindTurbineType4bIEC
(

    override val sup: WindTurbineType4IEC,

    /**
     * Wind control P type 4B model associated with this wind turbine type 4B model.
     */
    val WindContPType4bIEC: String,

    /**
     * Wind generator type 4 model associated with this wind turbine type 4B model.
     */
    val WindGenType4IEC: String,

    /**
     * Wind mechanical model associated with this wind turbine Type 4B model.
     */
    val WindMechIEC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def WindTurbineType4IEC: WindTurbineType4IEC = sup.asInstanceOf[WindTurbineType4IEC]
    override def copy (): Row = { return (clone ().asInstanceOf[WindTurbineType4bIEC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindTurbineType4bIEC
extends
    Parseable[WindTurbineType4bIEC]
{
    val sup = WindTurbineType4IEC.parse _
    val WindContPType4bIEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindContPType4bIEC"""))_
    val WindGenType4IEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindGenType4IEC"""))_
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindMechIEC"""))_
    def parse (context: Context): WindTurbineType4bIEC =
    {
        WindTurbineType4bIEC(
            sup (context),
            WindContPType4bIEC (context),
            WindGenType4IEC (context),
            WindMechIEC (context)
        )
    }
}

/**
 * UVRT Q control modes <i>M</i><sub>qUVRT</sub>.
 */
case class WindUVRTQcontrolModeKind
(

    override val sup: BasicElement,

    /**
     * Voltage dependent reactive current injection (<i>M</i><i><sub>q</sub></i><sub>UVRT </sub>equals 0).
     */
    val mode0: String,

    /**
     * Reactive current injection controlled as the pre-fault value plus an additional voltage dependent reactive current injection (<i>M</i><i><sub>q</sub></i><sub>UVRT</sub> equals 1).
     */
    val mode1: String,

    /**
     * Reactive current injection controlled as the pre-fault value plus an additional voltage dependent reactive current injection during fault, and as the pre-fault value plus an additional constant reactive current injection post fault (<i>M</i><i><sub>q</sub></i><sub>UVRT </sub>equals 2).
     */
    val mode2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[WindUVRTQcontrolModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindUVRTQcontrolModeKind
extends
    Parseable[WindUVRTQcontrolModeKind]
{
    val sup = BasicElement.parse _
    val mode0 = parse_attribute (attribute ("""WindUVRTQcontrolModeKind.mode0"""))_
    val mode1 = parse_attribute (attribute ("""WindUVRTQcontrolModeKind.mode1"""))_
    val mode2 = parse_attribute (attribute ("""WindUVRTQcontrolModeKind.mode2"""))_
    def parse (context: Context): WindUVRTQcontrolModeKind =
    {
        WindUVRTQcontrolModeKind(
            sup (context),
            mode0 (context),
            mode1 (context),
            mode2 (context)
        )
    }
}

object _WindDynamics
{
    def register: Unit =
    {
        WindAeroConstIEC.register
        WindAeroOneDimIEC.register
        WindAeroTwoDimIEC.register
        WindContCurrLimIEC.register
        WindContPType3IEC.register
        WindContPType4aIEC.register
        WindContPType4bIEC.register
        WindContPitchAngleIEC.register
        WindContQIEC.register
        WindContQLimIEC.register
        WindContQPQULimIEC.register
        WindContRotorRIEC.register
        WindDynamicsLookupTable.register
        WindGenTurbineType1aIEC.register
        WindGenTurbineType1bIEC.register
        WindGenTurbineType2IEC.register
        WindGenType3IEC.register
        WindGenType3aIEC.register
        WindGenType3bIEC.register
        WindGenType4IEC.register
        WindLookupTableFunctionKind.register
        WindMechIEC.register
        WindPitchContPowerIEC.register
        WindPlantDynamics.register
        WindPlantFreqPcontrolIEC.register
        WindPlantIEC.register
        WindPlantQcontrolModeKind.register
        WindPlantReactiveControlIEC.register
        WindProtectionIEC.register
        WindQcontrolModeKind.register
        WindRefFrameRotIEC.register
        WindTurbineType1or2Dynamics.register
        WindTurbineType1or2IEC.register
        WindTurbineType3IEC.register
        WindTurbineType3or4Dynamics.register
        WindTurbineType3or4IEC.register
        WindTurbineType4IEC.register
        WindTurbineType4aIEC.register
        WindTurbineType4bIEC.register
        WindUVRTQcontrolModeKind.register
    }
}