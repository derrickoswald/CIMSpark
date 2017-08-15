package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The constant aerodynamic torque model assumes that the aerodynamic torque is constant.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.1.1.
 *
 * @param sup Reference to the superclass object.
 * @param WindGenTurbineType1aIEC Wind turbine type 1A model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindAeroConstIEC
(
    override val sup: IdentifiedObject,
    WindGenTurbineType1aIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindAeroConstIEC] }
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
        (if (null != WindGenTurbineType1aIEC) "\t\t<cim:WindAeroConstIEC.WindGenTurbineType1aIEC rdf:resource=\"#" + WindGenTurbineType1aIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindAeroConstIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindAeroConstIEC>"
    }
}

object WindAeroConstIEC
extends
    Parseable[WindAeroConstIEC]
{
    val WindGenTurbineType1aIEC = parse_attribute (attribute ("""WindAeroConstIEC.WindGenTurbineType1aIEC"""))
    def parse (context: Context): WindAeroConstIEC =
    {
        WindAeroConstIEC(
            IdentifiedObject.parse (context),
            WindGenTurbineType1aIEC (context)
        )
    }
}

/**
 * One-dimensional aerodynamic model.
 *
 * Reference: IEC Standard 614000-27-1 Section 5.6.1.2.
 *
 * @param sup Reference to the superclass object.
 * @param ka Aerodynamic gain (<i>k</i><i><sub>a</sub></i>).
 *        It is type dependent parameter.
 * @param thetaomega Initial pitch angle (<i>theta</i><i><sub>omega0</sub></i>).
 *        It is case dependent parameter.
 * @param WindTurbineType3IEC Wind turbine type 3 model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindAeroOneDimIEC
(
    override val sup: IdentifiedObject,
    ka: Double,
    thetaomega: Double,
    WindTurbineType3IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindAeroOneDimIEC] }
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
        "\t\t<cim:WindAeroOneDimIEC.ka>" + ka + "</cim:WindAeroOneDimIEC.ka>\n" +
        "\t\t<cim:WindAeroOneDimIEC.thetaomega>" + thetaomega + "</cim:WindAeroOneDimIEC.thetaomega>\n" +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindAeroOneDimIEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindAeroOneDimIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindAeroOneDimIEC>"
    }
}

object WindAeroOneDimIEC
extends
    Parseable[WindAeroOneDimIEC]
{
    val ka = parse_element (element ("""WindAeroOneDimIEC.ka"""))
    val thetaomega = parse_element (element ("""WindAeroOneDimIEC.thetaomega"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindAeroOneDimIEC.WindTurbineType3IEC"""))
    def parse (context: Context): WindAeroOneDimIEC =
    {
        WindAeroOneDimIEC(
            IdentifiedObject.parse (context),
            toDouble (ka (context), context),
            toDouble (thetaomega (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * Two-dimensional aerodynamic model.
 *
 * Reference: IEC Standard 614000-27-1 Section 5.6.1.3.
 *
 * @param sup Reference to the superclass object.
 * @param dpomega Partial derivative of aerodynamic power with respect to changes in WTR speed (<i>dp</i><i><sub>omega</sub></i>).
 *        It is type dependent parameter.
 * @param dptheta Partial derivative of aerodynamic power with respect to changes in pitch angle (<i>dp</i><i><sub>theta</sub></i>).
 *        It is type dependent parameter.
 * @param dpv1 Partial derivative (<i>dp</i><sub>v1</sub>).
 *        It is type dependent parameter.
 * @param omegazero Rotor speed if the wind turbine is not derated (<i>omega</i><i><sub>0</sub></i>).
 *        It is type dependent parameter.
 * @param pavail Available aerodynamic power (<i>p</i><sub>avail</sub>).
 *        It is case dependent parameter.
 * @param thetav2 Blade angle at twice rated wind speed (<i>theta</i><i><sub>v2</sub></i>).
 *        It is type dependent parameter.
 * @param thetazero Pitch angle if the wind turbine is not derated (<i>theta</i><i><sub>0</sub></i>).
 *        It is case dependent parameter.
 * @param WindTurbineType3IEC Wind turbine type 3 model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindAeroTwoDimIEC
(
    override val sup: IdentifiedObject,
    dpomega: Double,
    dptheta: Double,
    dpv1: Double,
    omegazero: Double,
    pavail: Double,
    thetav2: Double,
    thetazero: Double,
    WindTurbineType3IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindAeroTwoDimIEC] }
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
        "\t\t<cim:WindAeroTwoDimIEC.dpomega>" + dpomega + "</cim:WindAeroTwoDimIEC.dpomega>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.dptheta>" + dptheta + "</cim:WindAeroTwoDimIEC.dptheta>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.dpv1>" + dpv1 + "</cim:WindAeroTwoDimIEC.dpv1>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.omegazero>" + omegazero + "</cim:WindAeroTwoDimIEC.omegazero>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.pavail>" + pavail + "</cim:WindAeroTwoDimIEC.pavail>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.thetav2>" + thetav2 + "</cim:WindAeroTwoDimIEC.thetav2>\n" +
        "\t\t<cim:WindAeroTwoDimIEC.thetazero>" + thetazero + "</cim:WindAeroTwoDimIEC.thetazero>\n" +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindAeroTwoDimIEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindAeroTwoDimIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindAeroTwoDimIEC>"
    }
}

object WindAeroTwoDimIEC
extends
    Parseable[WindAeroTwoDimIEC]
{
    val dpomega = parse_element (element ("""WindAeroTwoDimIEC.dpomega"""))
    val dptheta = parse_element (element ("""WindAeroTwoDimIEC.dptheta"""))
    val dpv1 = parse_element (element ("""WindAeroTwoDimIEC.dpv1"""))
    val omegazero = parse_element (element ("""WindAeroTwoDimIEC.omegazero"""))
    val pavail = parse_element (element ("""WindAeroTwoDimIEC.pavail"""))
    val thetav2 = parse_element (element ("""WindAeroTwoDimIEC.thetav2"""))
    val thetazero = parse_element (element ("""WindAeroTwoDimIEC.thetazero"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindAeroTwoDimIEC.WindTurbineType3IEC"""))
    def parse (context: Context): WindAeroTwoDimIEC =
    {
        WindAeroTwoDimIEC(
            IdentifiedObject.parse (context),
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
 *
 * The current limitation model combines the physical limits and the control limits.
 *
 * @param sup Reference to the superclass object.
 * @param imax Maximum continuous current at the wind turbine terminals (<i>i</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param imaxdip Maximum current during voltage dip at the wind turbine terminals (<i>i</i><sub>maxdip</sub>).
 *        It is project dependent parameter.
 * @param kpqu Partial derivative of reactive current limit (<i>K</i><sub>pqu</sub>).
 *        It is type dependent parameter.
 * @param mdfslim Limitation of type 3 stator current  (<i>M</i><sub>DFSLim</sub>):
 *        - false=0: total current limitation,
 *        - true=1: stator current limitation).
 *        It is type dependent parameter.
 * @param mqpri Prioritisation of q control during UVRT (<i>M</i><sub>qpri</sub>):
 *        - true = 1: reactive power priority,
 *        - false = 0: active power priority.
 *        It is project dependent parameter.
 * @param tufiltcl Voltage measurement filter time constant (<i>T</i><sub>ufiltcl</sub>).
 *        It is type dependent parameter.
 * @param upqumax Wind turbine voltage in the operation point where zero reactive current can be delivered (<i>u</i><sub>pqumax</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType3or4IEC Wind turbine type 3 or 4 model with which this wind control current limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContCurrLimIEC
(
    override val sup: IdentifiedObject,
    imax: Double,
    imaxdip: Double,
    kpqu: Double,
    mdfslim: Boolean,
    mqpri: Boolean,
    tufiltcl: Double,
    upqumax: Double,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContCurrLimIEC] }
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
        "\t\t<cim:WindContCurrLimIEC.imax>" + imax + "</cim:WindContCurrLimIEC.imax>\n" +
        "\t\t<cim:WindContCurrLimIEC.imaxdip>" + imaxdip + "</cim:WindContCurrLimIEC.imaxdip>\n" +
        "\t\t<cim:WindContCurrLimIEC.kpqu>" + kpqu + "</cim:WindContCurrLimIEC.kpqu>\n" +
        "\t\t<cim:WindContCurrLimIEC.mdfslim>" + mdfslim + "</cim:WindContCurrLimIEC.mdfslim>\n" +
        "\t\t<cim:WindContCurrLimIEC.mqpri>" + mqpri + "</cim:WindContCurrLimIEC.mqpri>\n" +
        "\t\t<cim:WindContCurrLimIEC.tufiltcl>" + tufiltcl + "</cim:WindContCurrLimIEC.tufiltcl>\n" +
        "\t\t<cim:WindContCurrLimIEC.upqumax>" + upqumax + "</cim:WindContCurrLimIEC.upqumax>\n" +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindContCurrLimIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContCurrLimIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContCurrLimIEC>"
    }
}

object WindContCurrLimIEC
extends
    Parseable[WindContCurrLimIEC]
{
    val imax = parse_element (element ("""WindContCurrLimIEC.imax"""))
    val imaxdip = parse_element (element ("""WindContCurrLimIEC.imaxdip"""))
    val kpqu = parse_element (element ("""WindContCurrLimIEC.kpqu"""))
    val mdfslim = parse_element (element ("""WindContCurrLimIEC.mdfslim"""))
    val mqpri = parse_element (element ("""WindContCurrLimIEC.mqpri"""))
    val tufiltcl = parse_element (element ("""WindContCurrLimIEC.tufiltcl"""))
    val upqumax = parse_element (element ("""WindContCurrLimIEC.upqumax"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContCurrLimIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindContCurrLimIEC =
    {
        WindContCurrLimIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.4.
 *
 * @param sup Reference to the superclass object.
 * @param dpmax Maximum wind turbine power ramp rate (<i>dp</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param dprefmax Maximum ramp rate of wind turbine reference power (d<i>p</i><sub>refmax</sub>).
 *        It is project dependent parameter.
 * @param dprefmin Minimum ramp rate of wind turbine reference power (d<i>p</i><sub>refmin</sub>).
 *        It is project dependent parameter.
 * @param dthetamax Ramp limitation of torque, required in some grid codes (d<i>t</i><sub>max</sub>).
 *        It is project dependent parameter.
 * @param dthetamaxuvrt Limitation of torque rise rate during UVRT (d<i>theta</i><sub>maxUVRT</sub>).
 *        It is project dependent parameter.
 * @param kdtd Gain for active drive train damping (<i>K</i><sub>DTD</sub>).
 *        It is type dependent parameter.
 * @param kip PI controller integration parameter (<i>K</i><sub>Ip</sub>).
 *        It is type dependent parameter.
 * @param kpp PI controller proportional gain (<i>K</i><sub>Pp</sub>).
 *        It is type dependent parameter.
 * @param mpuvrt Enable UVRT power control mode (M<sub>pUVRT).</sub>
 *        true = 1: voltage control
 *        false = 0: reactive power control.
 *        It is project dependent parameter.
 * @param omegaoffset Offset to reference value that limits controller action during rotor speed changes (omega<sub>offset</sub>).
 *        It is case dependent parameter.
 * @param pdtdmax Maximum active drive train damping power (<i>p</i><sub>DTDmax</sub>).
 *        It is type dependent parameter.
 * @param tdvs Time<sub> </sub>delay after deep voltage sags (T<sub>DVS</sub>).
 *        It is project dependent parameter.
 * @param thetaemin Minimum electrical generator torque (<i>t</i><sub>emin</sub>).
 *        It is type dependent parameter.
 * @param thetauscale Voltage scaling factor of reset-torque (<i>t</i><sub>uscale</sub>).
 *        It is project dependent parameter.
 * @param tomegafiltp3 Filter time constant for generator speed measurement (<i>T</i><sub>omegafiltp3</sub>).
 *        It is type dependent parameter.
 * @param tpfiltp3 Filter time constant for power measurement (<i>T</i><sub>pfiltp3</sub>).
 *        It is type dependent parameter.
 * @param tpord Time constant in power order lag (<i>T</i><sub>pord</sub>).
 *        It is type dependent parameter.
 * @param tufiltp3 Filter time constant for voltage measurement (<i>T</i><sub>ufiltp3</sub>).
 *        It is type dependent parameter.
 * @param twref Time constant in speed reference filter (<i>T</i><sub>omega,ref</sub>).
 *        It is type dependent parameter.
 * @param udvs Voltage limit for hold UVRT status after deep voltage sags (<i>u</i><i><sub>DVS</sub></i>).
 *        It is project dependent parameter.
 * @param updip Voltage dip threshold for P-control (<i>u</i><sub>Pdip</sub>).
 *        Part of turbine control, often different (e.g 0.8) from converter thresholds. It is project dependent parameter.
 * @param wdtd Active drive train damping frequency (omega<sub>DTD</sub>).
 *        It can be calculated from two mass model parameters. It is type dependent parameter.
 * @param zeta Coefficient for active drive train damping (zeta).
 *        It is type dependent parameter.
 * @param WindTurbineType3IEC Wind turbine type 3 model with which this Wind control P type 3 model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContPType3IEC
(
    override val sup: IdentifiedObject,
    dpmax: Double,
    dprefmax: Double,
    dprefmin: Double,
    dthetamax: Double,
    dthetamaxuvrt: Double,
    kdtd: Double,
    kip: Double,
    kpp: Double,
    mpuvrt: Boolean,
    omegaoffset: Double,
    pdtdmax: Double,
    tdvs: Double,
    thetaemin: Double,
    thetauscale: Double,
    tomegafiltp3: Double,
    tpfiltp3: Double,
    tpord: Double,
    tufiltp3: Double,
    twref: Double,
    udvs: Double,
    updip: Double,
    wdtd: Double,
    zeta: Double,
    WindTurbineType3IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContPType3IEC] }
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
        "\t\t<cim:WindContPType3IEC.dpmax>" + dpmax + "</cim:WindContPType3IEC.dpmax>\n" +
        "\t\t<cim:WindContPType3IEC.dprefmax>" + dprefmax + "</cim:WindContPType3IEC.dprefmax>\n" +
        "\t\t<cim:WindContPType3IEC.dprefmin>" + dprefmin + "</cim:WindContPType3IEC.dprefmin>\n" +
        "\t\t<cim:WindContPType3IEC.dthetamax>" + dthetamax + "</cim:WindContPType3IEC.dthetamax>\n" +
        "\t\t<cim:WindContPType3IEC.dthetamaxuvrt>" + dthetamaxuvrt + "</cim:WindContPType3IEC.dthetamaxuvrt>\n" +
        "\t\t<cim:WindContPType3IEC.kdtd>" + kdtd + "</cim:WindContPType3IEC.kdtd>\n" +
        "\t\t<cim:WindContPType3IEC.kip>" + kip + "</cim:WindContPType3IEC.kip>\n" +
        "\t\t<cim:WindContPType3IEC.kpp>" + kpp + "</cim:WindContPType3IEC.kpp>\n" +
        "\t\t<cim:WindContPType3IEC.mpuvrt>" + mpuvrt + "</cim:WindContPType3IEC.mpuvrt>\n" +
        "\t\t<cim:WindContPType3IEC.omegaoffset>" + omegaoffset + "</cim:WindContPType3IEC.omegaoffset>\n" +
        "\t\t<cim:WindContPType3IEC.pdtdmax>" + pdtdmax + "</cim:WindContPType3IEC.pdtdmax>\n" +
        "\t\t<cim:WindContPType3IEC.tdvs>" + tdvs + "</cim:WindContPType3IEC.tdvs>\n" +
        "\t\t<cim:WindContPType3IEC.thetaemin>" + thetaemin + "</cim:WindContPType3IEC.thetaemin>\n" +
        "\t\t<cim:WindContPType3IEC.thetauscale>" + thetauscale + "</cim:WindContPType3IEC.thetauscale>\n" +
        "\t\t<cim:WindContPType3IEC.tomegafiltp3>" + tomegafiltp3 + "</cim:WindContPType3IEC.tomegafiltp3>\n" +
        "\t\t<cim:WindContPType3IEC.tpfiltp3>" + tpfiltp3 + "</cim:WindContPType3IEC.tpfiltp3>\n" +
        "\t\t<cim:WindContPType3IEC.tpord>" + tpord + "</cim:WindContPType3IEC.tpord>\n" +
        "\t\t<cim:WindContPType3IEC.tufiltp3>" + tufiltp3 + "</cim:WindContPType3IEC.tufiltp3>\n" +
        "\t\t<cim:WindContPType3IEC.twref>" + twref + "</cim:WindContPType3IEC.twref>\n" +
        "\t\t<cim:WindContPType3IEC.udvs>" + udvs + "</cim:WindContPType3IEC.udvs>\n" +
        "\t\t<cim:WindContPType3IEC.updip>" + updip + "</cim:WindContPType3IEC.updip>\n" +
        "\t\t<cim:WindContPType3IEC.wdtd>" + wdtd + "</cim:WindContPType3IEC.wdtd>\n" +
        "\t\t<cim:WindContPType3IEC.zeta>" + zeta + "</cim:WindContPType3IEC.zeta>\n" +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindContPType3IEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContPType3IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContPType3IEC>"
    }
}

object WindContPType3IEC
extends
    Parseable[WindContPType3IEC]
{
    val dpmax = parse_element (element ("""WindContPType3IEC.dpmax"""))
    val dprefmax = parse_element (element ("""WindContPType3IEC.dprefmax"""))
    val dprefmin = parse_element (element ("""WindContPType3IEC.dprefmin"""))
    val dthetamax = parse_element (element ("""WindContPType3IEC.dthetamax"""))
    val dthetamaxuvrt = parse_element (element ("""WindContPType3IEC.dthetamaxuvrt"""))
    val kdtd = parse_element (element ("""WindContPType3IEC.kdtd"""))
    val kip = parse_element (element ("""WindContPType3IEC.kip"""))
    val kpp = parse_element (element ("""WindContPType3IEC.kpp"""))
    val mpuvrt = parse_element (element ("""WindContPType3IEC.mpuvrt"""))
    val omegaoffset = parse_element (element ("""WindContPType3IEC.omegaoffset"""))
    val pdtdmax = parse_element (element ("""WindContPType3IEC.pdtdmax"""))
    val tdvs = parse_element (element ("""WindContPType3IEC.tdvs"""))
    val thetaemin = parse_element (element ("""WindContPType3IEC.thetaemin"""))
    val thetauscale = parse_element (element ("""WindContPType3IEC.thetauscale"""))
    val tomegafiltp3 = parse_element (element ("""WindContPType3IEC.tomegafiltp3"""))
    val tpfiltp3 = parse_element (element ("""WindContPType3IEC.tpfiltp3"""))
    val tpord = parse_element (element ("""WindContPType3IEC.tpord"""))
    val tufiltp3 = parse_element (element ("""WindContPType3IEC.tufiltp3"""))
    val twref = parse_element (element ("""WindContPType3IEC.twref"""))
    val udvs = parse_element (element ("""WindContPType3IEC.udvs"""))
    val updip = parse_element (element ("""WindContPType3IEC.updip"""))
    val wdtd = parse_element (element ("""WindContPType3IEC.wdtd"""))
    val zeta = parse_element (element ("""WindContPType3IEC.zeta"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindContPType3IEC.WindTurbineType3IEC"""))
    def parse (context: Context): WindContPType3IEC =
    {
        WindContPType3IEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.5.
 *
 * @param sup Reference to the superclass object.
 * @param dpmaxp4a Maximum wind turbine power ramp rate (<i>dp</i><sub>maxp4A</sub>).
 *        It is project dependent parameter.
 * @param tpordp4a Time constant in power order lag (<i>T</i><sub>pordp4A</sub>).
 *        It is type dependent parameter.
 * @param tufiltp4a Voltage measurement filter time constant (<i>T</i><sub>ufiltp4A</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType4aIEC Wind turbine type 4A model with which this wind control P type 4A model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContPType4aIEC
(
    override val sup: IdentifiedObject,
    dpmaxp4a: Double,
    tpordp4a: Double,
    tufiltp4a: Double,
    WindTurbineType4aIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContPType4aIEC] }
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
        "\t\t<cim:WindContPType4aIEC.dpmaxp4a>" + dpmaxp4a + "</cim:WindContPType4aIEC.dpmaxp4a>\n" +
        "\t\t<cim:WindContPType4aIEC.tpordp4a>" + tpordp4a + "</cim:WindContPType4aIEC.tpordp4a>\n" +
        "\t\t<cim:WindContPType4aIEC.tufiltp4a>" + tufiltp4a + "</cim:WindContPType4aIEC.tufiltp4a>\n" +
        (if (null != WindTurbineType4aIEC) "\t\t<cim:WindContPType4aIEC.WindTurbineType4aIEC rdf:resource=\"#" + WindTurbineType4aIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContPType4aIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContPType4aIEC>"
    }
}

object WindContPType4aIEC
extends
    Parseable[WindContPType4aIEC]
{
    val dpmaxp4a = parse_element (element ("""WindContPType4aIEC.dpmaxp4a"""))
    val tpordp4a = parse_element (element ("""WindContPType4aIEC.tpordp4a"""))
    val tufiltp4a = parse_element (element ("""WindContPType4aIEC.tufiltp4a"""))
    val WindTurbineType4aIEC = parse_attribute (attribute ("""WindContPType4aIEC.WindTurbineType4aIEC"""))
    def parse (context: Context): WindContPType4aIEC =
    {
        WindContPType4aIEC(
            IdentifiedObject.parse (context),
            toDouble (dpmaxp4a (context), context),
            toDouble (tpordp4a (context), context),
            toDouble (tufiltp4a (context), context),
            WindTurbineType4aIEC (context)
        )
    }
}

/**
 * P control model Type 4B.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.6.
 *
 * @param sup Reference to the superclass object.
 * @param dpmaxp4b Maximum wind turbine power ramp rate (<i>dp</i><sub>maxp4B</sub>).
 *        It is project dependent parameter.
 * @param tpaero Time constant in aerodynamic power response (<i>T</i><sub>paero</sub>).
 *        It is type dependent parameter.
 * @param tpordp4b Time constant in power order lag (<i>T</i><sub>pordp4B</sub>).
 *        It is type dependent parameter.
 * @param tufiltp4b Voltage measurement filter time constant (<i>T</i><sub>ufiltp4B</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType4bIEC Wind turbine type 4B model with which this wind control P type 4B model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContPType4bIEC
(
    override val sup: IdentifiedObject,
    dpmaxp4b: Double,
    tpaero: Double,
    tpordp4b: Double,
    tufiltp4b: Double,
    WindTurbineType4bIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContPType4bIEC] }
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
        "\t\t<cim:WindContPType4bIEC.dpmaxp4b>" + dpmaxp4b + "</cim:WindContPType4bIEC.dpmaxp4b>\n" +
        "\t\t<cim:WindContPType4bIEC.tpaero>" + tpaero + "</cim:WindContPType4bIEC.tpaero>\n" +
        "\t\t<cim:WindContPType4bIEC.tpordp4b>" + tpordp4b + "</cim:WindContPType4bIEC.tpordp4b>\n" +
        "\t\t<cim:WindContPType4bIEC.tufiltp4b>" + tufiltp4b + "</cim:WindContPType4bIEC.tufiltp4b>\n" +
        (if (null != WindTurbineType4bIEC) "\t\t<cim:WindContPType4bIEC.WindTurbineType4bIEC rdf:resource=\"#" + WindTurbineType4bIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContPType4bIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContPType4bIEC>"
    }
}

object WindContPType4bIEC
extends
    Parseable[WindContPType4bIEC]
{
    val dpmaxp4b = parse_element (element ("""WindContPType4bIEC.dpmaxp4b"""))
    val tpaero = parse_element (element ("""WindContPType4bIEC.tpaero"""))
    val tpordp4b = parse_element (element ("""WindContPType4bIEC.tpordp4b"""))
    val tufiltp4b = parse_element (element ("""WindContPType4bIEC.tufiltp4b"""))
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindContPType4bIEC.WindTurbineType4bIEC"""))
    def parse (context: Context): WindContPType4bIEC =
    {
        WindContPType4bIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.2.
 *
 * @param sup Reference to the superclass object.
 * @param dthetamax Maximum pitch positive ramp rate (d<i>theta</i><sub>max</sub>).
 *        It is type dependent parameter. Unit = degrees/sec.
 * @param dthetamin Maximum pitch negative ramp rate (d<i>theta</i><sub>min</sub>).
 *        It is type dependent parameter. Unit = degrees/sec.
 * @param kic Power PI controller integration gain (<i>K</i><sub>Ic</sub>).
 *        It is type dependent parameter.
 * @param kiomega Speed PI controller integration gain (<i>K</i><sub>Iomega</sub>).
 *        It is type dependent parameter.
 * @param kpc Power PI controller proportional gain (<i>K</i><sub>Pc</sub>).
 *        It is type dependent parameter.
 * @param kpomega Speed PI controller proportional gain (<i>K</i><sub>Pomega</sub>).
 *        It is type dependent parameter.
 * @param kpx Pitch cross coupling gain (K<sub>PX</sub>).
 *        It is type dependent parameter.
 * @param thetamax Maximum pitch angle (<i>theta</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param thetamin Minimum pitch angle (<i>theta</i><sub>min</sub>).
 *        It is type dependent parameter.
 * @param ttheta Pitch time constant (t<i>theta</i>).
 *        It is type dependent parameter.
 * @param WindTurbineType3IEC Wind turbine type 3 model with which this pitch control model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContPitchAngleIEC
(
    override val sup: IdentifiedObject,
    dthetamax: Double,
    dthetamin: Double,
    kic: Double,
    kiomega: Double,
    kpc: Double,
    kpomega: Double,
    kpx: Double,
    thetamax: Double,
    thetamin: Double,
    ttheta: Double,
    WindTurbineType3IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContPitchAngleIEC] }
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
        "\t\t<cim:WindContPitchAngleIEC.dthetamax>" + dthetamax + "</cim:WindContPitchAngleIEC.dthetamax>\n" +
        "\t\t<cim:WindContPitchAngleIEC.dthetamin>" + dthetamin + "</cim:WindContPitchAngleIEC.dthetamin>\n" +
        "\t\t<cim:WindContPitchAngleIEC.kic>" + kic + "</cim:WindContPitchAngleIEC.kic>\n" +
        "\t\t<cim:WindContPitchAngleIEC.kiomega>" + kiomega + "</cim:WindContPitchAngleIEC.kiomega>\n" +
        "\t\t<cim:WindContPitchAngleIEC.kpc>" + kpc + "</cim:WindContPitchAngleIEC.kpc>\n" +
        "\t\t<cim:WindContPitchAngleIEC.kpomega>" + kpomega + "</cim:WindContPitchAngleIEC.kpomega>\n" +
        "\t\t<cim:WindContPitchAngleIEC.kpx>" + kpx + "</cim:WindContPitchAngleIEC.kpx>\n" +
        "\t\t<cim:WindContPitchAngleIEC.thetamax>" + thetamax + "</cim:WindContPitchAngleIEC.thetamax>\n" +
        "\t\t<cim:WindContPitchAngleIEC.thetamin>" + thetamin + "</cim:WindContPitchAngleIEC.thetamin>\n" +
        "\t\t<cim:WindContPitchAngleIEC.ttheta>" + ttheta + "</cim:WindContPitchAngleIEC.ttheta>\n" +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindContPitchAngleIEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContPitchAngleIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContPitchAngleIEC>"
    }
}

object WindContPitchAngleIEC
extends
    Parseable[WindContPitchAngleIEC]
{
    val dthetamax = parse_element (element ("""WindContPitchAngleIEC.dthetamax"""))
    val dthetamin = parse_element (element ("""WindContPitchAngleIEC.dthetamin"""))
    val kic = parse_element (element ("""WindContPitchAngleIEC.kic"""))
    val kiomega = parse_element (element ("""WindContPitchAngleIEC.kiomega"""))
    val kpc = parse_element (element ("""WindContPitchAngleIEC.kpc"""))
    val kpomega = parse_element (element ("""WindContPitchAngleIEC.kpomega"""))
    val kpx = parse_element (element ("""WindContPitchAngleIEC.kpx"""))
    val thetamax = parse_element (element ("""WindContPitchAngleIEC.thetamax"""))
    val thetamin = parse_element (element ("""WindContPitchAngleIEC.thetamin"""))
    val ttheta = parse_element (element ("""WindContPitchAngleIEC.ttheta"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindContPitchAngleIEC.WindTurbineType3IEC"""))
    def parse (context: Context): WindContPitchAngleIEC =
    {
        WindContPitchAngleIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.7.
 *
 * @param sup Reference to the superclass object.
 * @param iqh1 Maximum reactive current injection during dip (i<sub>qh1</sub>).
 *        It is type dependent parameter.
 * @param iqmax Maximum reactive current injection (i<sub>qmax</sub>).
 *        It is type dependent parameter.
 * @param iqmin Minimum reactive current injection (i<sub>qmin</sub>).
 *        It is type dependent parameter.
 * @param iqpost Post fault reactive current injection (<i>i</i><sub>qpost</sub>).
 *        It is project dependent parameter.
 * @param kiq Reactive power PI controller integration gain (<i>K</i><sub>I,q</sub>).
 *        It is type dependent parameter.
 * @param kiu Voltage PI controller integration gain (<i>K</i><sub>I,u</sub>).
 *        It is type dependent parameter.
 * @param kpq Reactive power PI controller proportional gain (<i>K</i><sub>P,q</sub>).
 *        It is type dependent parameter.
 * @param kpu Voltage PI controller proportional gain (<i>K</i><sub>P,u</sub>).
 *        It is type dependent parameter.
 * @param kqv Voltage scaling factor for UVRT current (<i>K</i><sub>qv</sub>).
 *        It is project dependent parameter.
 * @param rdroop Resistive component of voltage drop impedance (<i>r</i><sub>droop</sub>).
 *        It is project dependent parameter.
 * @param tpfiltq Power measurement filter time constant (<i>T</i><sub>pfiltq</sub>).
 *        It is type dependent parameter.
 * @param tpost Length of time period where post fault reactive power is injected (<i>T</i><sub>post</sub>).
 *        It is project dependent parameter.
 * @param tqord Time constant in reactive power order lag (<i>T</i><sub>qord</sub>).
 *        It is type dependent parameter.
 * @param tufiltq Voltage measurement filter time constant (<i>T</i><sub>ufiltq</sub>).
 *        It is type dependent parameter.
 * @param udb1 Voltage dead band lower limit (<i>u</i><sub>db1</sub>).
 *        It is type dependent parameter.
 * @param udb2 Voltage dead band upper limit (<i>u</i><sub>db2</sub>).
 *        It is type dependent parameter.
 * @param umax Maximum voltage in voltage PI controller integral term (u<sub>max</sub>).
 *        It is type dependent parameter.
 * @param umin Minimum voltage in voltage PI controller integral term (u<sub>min</sub>).
 *        It is type dependent parameter.
 * @param uqdip Voltage threshold for UVRT detection in q control (<i>u</i><sub>qdip</sub>).
 *        It is type dependent parameter.
 * @param uref0 User defined bias in voltage reference (<i>u</i><sub>ref0</sub>), used when <i>M</i><sub>qG</sub> is set to voltage control.
 *        It is case dependent parameter.
 * @param windQcontrolModesType Types of general wind turbine Q control modes (<i>M</i><sub>qG</sub>).
 *        It is project dependent parameter.
 * @param windUVRTQcontrolModesType Types of UVRT Q control modes (<i>M</i><sub>qUVRT</sub>).
 *        It is project dependent parameter.
 * @param xdroop Inductive component of voltage drop impedance (<i>x</i><sub>droop</sub>).
 *        It is project dependent parameter.
 * @param WindTurbineType3or4IEC Wind turbine type 3 or 4 model with which this reactive control model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContQIEC
(
    override val sup: IdentifiedObject,
    iqh1: Double,
    iqmax: Double,
    iqmin: Double,
    iqpost: Double,
    kiq: Double,
    kiu: Double,
    kpq: Double,
    kpu: Double,
    kqv: Double,
    rdroop: Double,
    tpfiltq: Double,
    tpost: Double,
    tqord: Double,
    tufiltq: Double,
    udb1: Double,
    udb2: Double,
    umax: Double,
    umin: Double,
    uqdip: Double,
    uref0: Double,
    windQcontrolModesType: String,
    windUVRTQcontrolModesType: String,
    xdroop: Double,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContQIEC] }
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
        "\t\t<cim:WindContQIEC.iqh1>" + iqh1 + "</cim:WindContQIEC.iqh1>\n" +
        "\t\t<cim:WindContQIEC.iqmax>" + iqmax + "</cim:WindContQIEC.iqmax>\n" +
        "\t\t<cim:WindContQIEC.iqmin>" + iqmin + "</cim:WindContQIEC.iqmin>\n" +
        "\t\t<cim:WindContQIEC.iqpost>" + iqpost + "</cim:WindContQIEC.iqpost>\n" +
        "\t\t<cim:WindContQIEC.kiq>" + kiq + "</cim:WindContQIEC.kiq>\n" +
        "\t\t<cim:WindContQIEC.kiu>" + kiu + "</cim:WindContQIEC.kiu>\n" +
        "\t\t<cim:WindContQIEC.kpq>" + kpq + "</cim:WindContQIEC.kpq>\n" +
        "\t\t<cim:WindContQIEC.kpu>" + kpu + "</cim:WindContQIEC.kpu>\n" +
        "\t\t<cim:WindContQIEC.kqv>" + kqv + "</cim:WindContQIEC.kqv>\n" +
        "\t\t<cim:WindContQIEC.rdroop>" + rdroop + "</cim:WindContQIEC.rdroop>\n" +
        "\t\t<cim:WindContQIEC.tpfiltq>" + tpfiltq + "</cim:WindContQIEC.tpfiltq>\n" +
        "\t\t<cim:WindContQIEC.tpost>" + tpost + "</cim:WindContQIEC.tpost>\n" +
        "\t\t<cim:WindContQIEC.tqord>" + tqord + "</cim:WindContQIEC.tqord>\n" +
        "\t\t<cim:WindContQIEC.tufiltq>" + tufiltq + "</cim:WindContQIEC.tufiltq>\n" +
        "\t\t<cim:WindContQIEC.udb1>" + udb1 + "</cim:WindContQIEC.udb1>\n" +
        "\t\t<cim:WindContQIEC.udb2>" + udb2 + "</cim:WindContQIEC.udb2>\n" +
        "\t\t<cim:WindContQIEC.umax>" + umax + "</cim:WindContQIEC.umax>\n" +
        "\t\t<cim:WindContQIEC.umin>" + umin + "</cim:WindContQIEC.umin>\n" +
        "\t\t<cim:WindContQIEC.uqdip>" + uqdip + "</cim:WindContQIEC.uqdip>\n" +
        "\t\t<cim:WindContQIEC.uref0>" + uref0 + "</cim:WindContQIEC.uref0>\n" +
        (if (null != windQcontrolModesType) "\t\t<cim:WindContQIEC.windQcontrolModesType rdf:resource=\"#" + windQcontrolModesType + "\"/>\n" else "") +
        (if (null != windUVRTQcontrolModesType) "\t\t<cim:WindContQIEC.windUVRTQcontrolModesType rdf:resource=\"#" + windUVRTQcontrolModesType + "\"/>\n" else "") +
        "\t\t<cim:WindContQIEC.xdroop>" + xdroop + "</cim:WindContQIEC.xdroop>\n" +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindContQIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContQIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContQIEC>"
    }
}

object WindContQIEC
extends
    Parseable[WindContQIEC]
{
    val iqh1 = parse_element (element ("""WindContQIEC.iqh1"""))
    val iqmax = parse_element (element ("""WindContQIEC.iqmax"""))
    val iqmin = parse_element (element ("""WindContQIEC.iqmin"""))
    val iqpost = parse_element (element ("""WindContQIEC.iqpost"""))
    val kiq = parse_element (element ("""WindContQIEC.kiq"""))
    val kiu = parse_element (element ("""WindContQIEC.kiu"""))
    val kpq = parse_element (element ("""WindContQIEC.kpq"""))
    val kpu = parse_element (element ("""WindContQIEC.kpu"""))
    val kqv = parse_element (element ("""WindContQIEC.kqv"""))
    val rdroop = parse_element (element ("""WindContQIEC.rdroop"""))
    val tpfiltq = parse_element (element ("""WindContQIEC.tpfiltq"""))
    val tpost = parse_element (element ("""WindContQIEC.tpost"""))
    val tqord = parse_element (element ("""WindContQIEC.tqord"""))
    val tufiltq = parse_element (element ("""WindContQIEC.tufiltq"""))
    val udb1 = parse_element (element ("""WindContQIEC.udb1"""))
    val udb2 = parse_element (element ("""WindContQIEC.udb2"""))
    val umax = parse_element (element ("""WindContQIEC.umax"""))
    val umin = parse_element (element ("""WindContQIEC.umin"""))
    val uqdip = parse_element (element ("""WindContQIEC.uqdip"""))
    val uref0 = parse_element (element ("""WindContQIEC.uref0"""))
    val windQcontrolModesType = parse_attribute (attribute ("""WindContQIEC.windQcontrolModesType"""))
    val windUVRTQcontrolModesType = parse_attribute (attribute ("""WindContQIEC.windUVRTQcontrolModesType"""))
    val xdroop = parse_element (element ("""WindContQIEC.xdroop"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindContQIEC =
    {
        WindContQIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.9.
 *
 * @param sup Reference to the superclass object.
 * @param qmax Maximum reactive power (<i>q</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param qmin Minimum reactive power (<i>q</i><sub>min</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType3or4IEC Wind generator type 3 or 4 model with which this constant Q limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContQLimIEC
(
    override val sup: IdentifiedObject,
    qmax: Double,
    qmin: Double,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContQLimIEC] }
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
        "\t\t<cim:WindContQLimIEC.qmax>" + qmax + "</cim:WindContQLimIEC.qmax>\n" +
        "\t\t<cim:WindContQLimIEC.qmin>" + qmin + "</cim:WindContQLimIEC.qmin>\n" +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindContQLimIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContQLimIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContQLimIEC>"
    }
}

object WindContQLimIEC
extends
    Parseable[WindContQLimIEC]
{
    val qmax = parse_element (element ("""WindContQLimIEC.qmax"""))
    val qmin = parse_element (element ("""WindContQLimIEC.qmin"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQLimIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindContQLimIEC =
    {
        WindContQLimIEC(
            IdentifiedObject.parse (context),
            toDouble (qmax (context), context),
            toDouble (qmin (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * QP and QU limitation model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.10.
 *
 * @param sup Reference to the superclass object.
 * @param tpfiltql Power measurement filter time constant for Q capacity (<i>T</i><sub>pfiltql</sub>).
 *        It is type dependent parameter.
 * @param tufiltql Voltage measurement filter time constant for Q capacity (<i>T</i><sub>ufiltql</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType3or4IEC Wind generator type 3 or 4 model with which this QP and QU limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContQPQULimIEC
(
    override val sup: IdentifiedObject,
    tpfiltql: Double,
    tufiltql: Double,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContQPQULimIEC] }
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
        "\t\t<cim:WindContQPQULimIEC.tpfiltql>" + tpfiltql + "</cim:WindContQPQULimIEC.tpfiltql>\n" +
        "\t\t<cim:WindContQPQULimIEC.tufiltql>" + tufiltql + "</cim:WindContQPQULimIEC.tufiltql>\n" +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindContQPQULimIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContQPQULimIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContQPQULimIEC>"
    }
}

object WindContQPQULimIEC
extends
    Parseable[WindContQPQULimIEC]
{
    val tpfiltql = parse_element (element ("""WindContQPQULimIEC.tpfiltql"""))
    val tufiltql = parse_element (element ("""WindContQPQULimIEC.tufiltql"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindContQPQULimIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindContQPQULimIEC =
    {
        WindContQPQULimIEC(
            IdentifiedObject.parse (context),
            toDouble (tpfiltql (context), context),
            toDouble (tufiltql (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * Rotor resistance control model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.3.
 *
 * @param sup Reference to the superclass object.
 * @param kirr Integral gain in rotor resistance PI controller (<i>K</i><sub>Irr</sub>).
 *        It is type dependent parameter.
 * @param komegafilt Filter gain for generator speed measurement (K<sub>omegafilt</sub>).
 *        It is type dependent parameter.
 * @param kpfilt Filter gain for power measurement (<i>K</i><sub>pfilt</sub>).
 *        It is type dependent parameter.
 * @param kprr Proportional gain in rotor resistance PI controller (<i>K</i><sub>Prr</sub>).
 *        It is type dependent parameter.
 * @param rmax Maximum rotor resistance (<i>r</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param rmin Minimum rotor resistance (<i>r</i><sub>min</sub>).
 *        It is type dependent parameter.
 * @param tomegafiltrr Filter time constant for generator speed measurement (<i>T</i><sub>omegafiltrr</sub>).
 *        It is type dependent parameter.
 * @param tpfiltrr Filter time constant for power measurement (<i>T</i><sub>pfiltrr</sub>).
 *        It is type dependent parameter.
 * @param WindGenTurbineType2IEC Wind turbine type 2 model with whitch this wind control rotor resistance model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindContRotorRIEC
(
    override val sup: IdentifiedObject,
    kirr: Double,
    komegafilt: Double,
    kpfilt: Double,
    kprr: Double,
    rmax: Double,
    rmin: Double,
    tomegafiltrr: Double,
    tpfiltrr: Double,
    WindGenTurbineType2IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindContRotorRIEC] }
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
        "\t\t<cim:WindContRotorRIEC.kirr>" + kirr + "</cim:WindContRotorRIEC.kirr>\n" +
        "\t\t<cim:WindContRotorRIEC.komegafilt>" + komegafilt + "</cim:WindContRotorRIEC.komegafilt>\n" +
        "\t\t<cim:WindContRotorRIEC.kpfilt>" + kpfilt + "</cim:WindContRotorRIEC.kpfilt>\n" +
        "\t\t<cim:WindContRotorRIEC.kprr>" + kprr + "</cim:WindContRotorRIEC.kprr>\n" +
        "\t\t<cim:WindContRotorRIEC.rmax>" + rmax + "</cim:WindContRotorRIEC.rmax>\n" +
        "\t\t<cim:WindContRotorRIEC.rmin>" + rmin + "</cim:WindContRotorRIEC.rmin>\n" +
        "\t\t<cim:WindContRotorRIEC.tomegafiltrr>" + tomegafiltrr + "</cim:WindContRotorRIEC.tomegafiltrr>\n" +
        "\t\t<cim:WindContRotorRIEC.tpfiltrr>" + tpfiltrr + "</cim:WindContRotorRIEC.tpfiltrr>\n" +
        (if (null != WindGenTurbineType2IEC) "\t\t<cim:WindContRotorRIEC.WindGenTurbineType2IEC rdf:resource=\"#" + WindGenTurbineType2IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindContRotorRIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindContRotorRIEC>"
    }
}

object WindContRotorRIEC
extends
    Parseable[WindContRotorRIEC]
{
    val kirr = parse_element (element ("""WindContRotorRIEC.kirr"""))
    val komegafilt = parse_element (element ("""WindContRotorRIEC.komegafilt"""))
    val kpfilt = parse_element (element ("""WindContRotorRIEC.kpfilt"""))
    val kprr = parse_element (element ("""WindContRotorRIEC.kprr"""))
    val rmax = parse_element (element ("""WindContRotorRIEC.rmax"""))
    val rmin = parse_element (element ("""WindContRotorRIEC.rmin"""))
    val tomegafiltrr = parse_element (element ("""WindContRotorRIEC.tomegafiltrr"""))
    val tpfiltrr = parse_element (element ("""WindContRotorRIEC.tpfiltrr"""))
    val WindGenTurbineType2IEC = parse_attribute (attribute ("""WindContRotorRIEC.WindGenTurbineType2IEC"""))
    def parse (context: Context): WindContRotorRIEC =
    {
        WindContRotorRIEC(
            IdentifiedObject.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param input Input value (x) for the lookup table function.
 * @param lookupTableFunctionType Type of the lookup table function.
 * @param output Output value (y) for the lookup table function.
 * @param sequence Sequence numbers of the pairs of the input (x) and the output (y) of the lookup table function.
 * @param WindContCurrLimIEC The current control limitation model with which this wind dynamics lookup table is associated.
 * @param WindContPType3IEC The P control type 3 model with which this wind dynamics lookup table is associated.
 * @param WindContQPQULimIEC The QP and QU limitation model with which this wind dynamics lookup table is associated.
 * @param WindContRotorRIEC The rotor resistance control model with which this wind dynamics lookup table is associated.
 * @param WindGenType3bIEC The generator type 3B model with which this wind dynamics lookup table is associated.
 * @param WindPitchContPowerIEC The pitch control power model with which this wind dynamics lookup table is associated.
 * @param WindPlantFreqPcontrolIEC The frequency and active power wind plant control model with which this wind dynamics lookup table is associated.
 * @param WindPlantReactiveControlIEC The voltage and reactive power wind plant control model with which this wind dynamics lookup table is associated.
 * @param WindProtectionIEC The grid protection model with which this wind dynamics lookup table is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindDynamicsLookupTable
(
    override val sup: IdentifiedObject,
    input: Double,
    lookupTableFunctionType: String,
    output: Double,
    sequence: Int,
    WindContCurrLimIEC: String,
    WindContPType3IEC: String,
    WindContQPQULimIEC: String,
    WindContRotorRIEC: String,
    WindGenType3bIEC: String,
    WindPitchContPowerIEC: String,
    WindPlantFreqPcontrolIEC: String,
    WindPlantReactiveControlIEC: String,
    WindProtectionIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0.0, 0, null, null, null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindDynamicsLookupTable] }
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
        "\t\t<cim:WindDynamicsLookupTable.input>" + input + "</cim:WindDynamicsLookupTable.input>\n" +
        (if (null != lookupTableFunctionType) "\t\t<cim:WindDynamicsLookupTable.lookupTableFunctionType rdf:resource=\"#" + lookupTableFunctionType + "\"/>\n" else "") +
        "\t\t<cim:WindDynamicsLookupTable.output>" + output + "</cim:WindDynamicsLookupTable.output>\n" +
        "\t\t<cim:WindDynamicsLookupTable.sequence>" + sequence + "</cim:WindDynamicsLookupTable.sequence>\n" +
        (if (null != WindContCurrLimIEC) "\t\t<cim:WindDynamicsLookupTable.WindContCurrLimIEC rdf:resource=\"#" + WindContCurrLimIEC + "\"/>\n" else "") +
        (if (null != WindContPType3IEC) "\t\t<cim:WindDynamicsLookupTable.WindContPType3IEC rdf:resource=\"#" + WindContPType3IEC + "\"/>\n" else "") +
        (if (null != WindContQPQULimIEC) "\t\t<cim:WindDynamicsLookupTable.WindContQPQULimIEC rdf:resource=\"#" + WindContQPQULimIEC + "\"/>\n" else "") +
        (if (null != WindContRotorRIEC) "\t\t<cim:WindDynamicsLookupTable.WindContRotorRIEC rdf:resource=\"#" + WindContRotorRIEC + "\"/>\n" else "") +
        (if (null != WindGenType3bIEC) "\t\t<cim:WindDynamicsLookupTable.WindGenType3bIEC rdf:resource=\"#" + WindGenType3bIEC + "\"/>\n" else "") +
        (if (null != WindPitchContPowerIEC) "\t\t<cim:WindDynamicsLookupTable.WindPitchContPowerIEC rdf:resource=\"#" + WindPitchContPowerIEC + "\"/>\n" else "") +
        (if (null != WindPlantFreqPcontrolIEC) "\t\t<cim:WindDynamicsLookupTable.WindPlantFreqPcontrolIEC rdf:resource=\"#" + WindPlantFreqPcontrolIEC + "\"/>\n" else "") +
        (if (null != WindPlantReactiveControlIEC) "\t\t<cim:WindDynamicsLookupTable.WindPlantReactiveControlIEC rdf:resource=\"#" + WindPlantReactiveControlIEC + "\"/>\n" else "") +
        (if (null != WindProtectionIEC) "\t\t<cim:WindDynamicsLookupTable.WindProtectionIEC rdf:resource=\"#" + WindProtectionIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindDynamicsLookupTable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindDynamicsLookupTable>"
    }
}

object WindDynamicsLookupTable
extends
    Parseable[WindDynamicsLookupTable]
{
    val input = parse_element (element ("""WindDynamicsLookupTable.input"""))
    val lookupTableFunctionType = parse_attribute (attribute ("""WindDynamicsLookupTable.lookupTableFunctionType"""))
    val output = parse_element (element ("""WindDynamicsLookupTable.output"""))
    val sequence = parse_element (element ("""WindDynamicsLookupTable.sequence"""))
    val WindContCurrLimIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContCurrLimIEC"""))
    val WindContPType3IEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContPType3IEC"""))
    val WindContQPQULimIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContQPQULimIEC"""))
    val WindContRotorRIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindContRotorRIEC"""))
    val WindGenType3bIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindGenType3bIEC"""))
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPitchContPowerIEC"""))
    val WindPlantFreqPcontrolIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPlantFreqPcontrolIEC"""))
    val WindPlantReactiveControlIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindPlantReactiveControlIEC"""))
    val WindProtectionIEC = parse_attribute (attribute ("""WindDynamicsLookupTable.WindProtectionIEC"""))
    def parse (context: Context): WindDynamicsLookupTable =
    {
        WindDynamicsLookupTable(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1, section 5.5.2.2.
 *
 * @param sup Reference to the superclass object.
 * @param WindAeroConstIEC Wind aerodynamic model associated with this wind turbine type 1A model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenTurbineType1aIEC
(
    override val sup: WindTurbineType1or2IEC,
    WindAeroConstIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindGenTurbineType1aIEC] }
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
        (if (null != WindAeroConstIEC) "\t\t<cim:WindGenTurbineType1aIEC.WindAeroConstIEC rdf:resource=\"#" + WindAeroConstIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType1aIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenTurbineType1aIEC>"
    }
}

object WindGenTurbineType1aIEC
extends
    Parseable[WindGenTurbineType1aIEC]
{
    val WindAeroConstIEC = parse_attribute (attribute ("""WindGenTurbineType1aIEC.WindAeroConstIEC"""))
    def parse (context: Context): WindGenTurbineType1aIEC =
    {
        WindGenTurbineType1aIEC(
            WindTurbineType1or2IEC.parse (context),
            WindAeroConstIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 1B.
 *
 * Reference: IEC Standard 61400-27-1, section 5.5.2.3.
 *
 * @param sup Reference to the superclass object.
 * @param WindPitchContPowerIEC Pitch control power model associated with this wind turbine type 1B model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenTurbineType1bIEC
(
    override val sup: WindTurbineType1or2IEC,
    WindPitchContPowerIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindGenTurbineType1bIEC] }
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
        (if (null != WindPitchContPowerIEC) "\t\t<cim:WindGenTurbineType1bIEC.WindPitchContPowerIEC rdf:resource=\"#" + WindPitchContPowerIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType1bIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenTurbineType1bIEC>"
    }
}

object WindGenTurbineType1bIEC
extends
    Parseable[WindGenTurbineType1bIEC]
{
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindGenTurbineType1bIEC.WindPitchContPowerIEC"""))
    def parse (context: Context): WindGenTurbineType1bIEC =
    {
        WindGenTurbineType1bIEC(
            WindTurbineType1or2IEC.parse (context),
            WindPitchContPowerIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 2.
 *
 * Reference: IEC Standard 61400-27-1, section 5.5.3.
 *
 * @param sup Reference to the superclass object.
 * @param WindContRotorRIEC Wind control rotor resistance model associated with wind turbine type 2 model.
 * @param WindPitchContPowerIEC Pitch control power model associated with this wind turbine type 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenTurbineType2IEC
(
    override val sup: WindTurbineType1or2IEC,
    WindContRotorRIEC: String,
    WindPitchContPowerIEC: String
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
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup.asInstanceOf[WindTurbineType1or2IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindGenTurbineType2IEC] }
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
        (if (null != WindContRotorRIEC) "\t\t<cim:WindGenTurbineType2IEC.WindContRotorRIEC rdf:resource=\"#" + WindContRotorRIEC + "\"/>\n" else "") +
        (if (null != WindPitchContPowerIEC) "\t\t<cim:WindGenTurbineType2IEC.WindPitchContPowerIEC rdf:resource=\"#" + WindPitchContPowerIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType2IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenTurbineType2IEC>"
    }
}

object WindGenTurbineType2IEC
extends
    Parseable[WindGenTurbineType2IEC]
{
    val WindContRotorRIEC = parse_attribute (attribute ("""WindGenTurbineType2IEC.WindContRotorRIEC"""))
    val WindPitchContPowerIEC = parse_attribute (attribute ("""WindGenTurbineType2IEC.WindPitchContPowerIEC"""))
    def parse (context: Context): WindGenTurbineType2IEC =
    {
        WindGenTurbineType2IEC(
            WindTurbineType1or2IEC.parse (context),
            WindContRotorRIEC (context),
            WindPitchContPowerIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 generator models of IEC type 3A and 3B.
 *
 * @param sup Reference to the superclass object.
 * @param dipmax Maximum active current ramp rate (di<sub>pmax</sub>).
 *        It is project dependent parameter.
 * @param diqmax Maximum reactive current ramp rate (di<sub>qmax</sub>).
 *        It is project dependent parameter.
 * @param xs Electromagnetic transient reactance (x<sub>S</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType3IEC Wind turbine type 3 model with which this wind generator type 3 is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenType3IEC
(
    override val sup: IdentifiedObject,
    dipmax: Double,
    diqmax: Double,
    xs: Double,
    WindTurbineType3IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindGenType3IEC] }
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
        "\t\t<cim:WindGenType3IEC.dipmax>" + dipmax + "</cim:WindGenType3IEC.dipmax>\n" +
        "\t\t<cim:WindGenType3IEC.diqmax>" + diqmax + "</cim:WindGenType3IEC.diqmax>\n" +
        "\t\t<cim:WindGenType3IEC.xs>" + xs + "</cim:WindGenType3IEC.xs>\n" +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindGenType3IEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenType3IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenType3IEC>"
    }
}

object WindGenType3IEC
extends
    Parseable[WindGenType3IEC]
{
    val dipmax = parse_element (element ("""WindGenType3IEC.dipmax"""))
    val diqmax = parse_element (element ("""WindGenType3IEC.diqmax"""))
    val xs = parse_element (element ("""WindGenType3IEC.xs"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindGenType3IEC.WindTurbineType3IEC"""))
    def parse (context: Context): WindGenType3IEC =
    {
        WindGenType3IEC(
            IdentifiedObject.parse (context),
            toDouble (dipmax (context), context),
            toDouble (diqmax (context), context),
            toDouble (xs (context), context),
            WindTurbineType3IEC (context)
        )
    }
}

/**
 * IEC Type 3A generator set model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.2.
 *
 * @param sup Reference to the superclass object.
 * @param kpc Current PI controller proportional gain (K<sub>Pc</sub>).
 *        It is type dependent parameter.
 * @param tic Current PI controller integration time constant (T<sub>Ic</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType4IEC Wind turbine type 4 model with which this wind generator type 3A model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenType3aIEC
(
    override val sup: WindGenType3IEC,
    kpc: Double,
    tic: Double,
    WindTurbineType4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindGenType3IEC: WindGenType3IEC = sup.asInstanceOf[WindGenType3IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindGenType3aIEC] }
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
        "\t\t<cim:WindGenType3aIEC.kpc>" + kpc + "</cim:WindGenType3aIEC.kpc>\n" +
        "\t\t<cim:WindGenType3aIEC.tic>" + tic + "</cim:WindGenType3aIEC.tic>\n" +
        (if (null != WindTurbineType4IEC) "\t\t<cim:WindGenType3aIEC.WindTurbineType4IEC rdf:resource=\"#" + WindTurbineType4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenType3aIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenType3aIEC>"
    }
}

object WindGenType3aIEC
extends
    Parseable[WindGenType3aIEC]
{
    val kpc = parse_element (element ("""WindGenType3aIEC.kpc"""))
    val tic = parse_element (element ("""WindGenType3aIEC.tic"""))
    val WindTurbineType4IEC = parse_attribute (attribute ("""WindGenType3aIEC.WindTurbineType4IEC"""))
    def parse (context: Context): WindGenType3aIEC =
    {
        WindGenType3aIEC(
            WindGenType3IEC.parse (context),
            toDouble (kpc (context), context),
            toDouble (tic (context), context),
            WindTurbineType4IEC (context)
        )
    }
}

/**
 * IEC Type 3B generator set model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.3.
 *
 * @param sup Reference to the superclass object.
 * @param mwtcwp Crowbar control mode (<i>M</i><sub>WTcwp</sub>).
 *        <ul>
 *        <li>true = 1 in the model</li>
 *        <li>false = 0 in the model.</li>
 *        </ul>
 *        The parameter is case dependent parameter.
 * @param tg Current generation Time constant (<i>T</i><sub>g</sub>).
 *        It is type dependent parameter.
 * @param two Time constant for crowbar washout filter (<i>T</i><sub>wo</sub>).
 *        It is case dependent parameter.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenType3bIEC
(
    override val sup: WindGenType3IEC,
    mwtcwp: Boolean,
    tg: Double,
    two: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindGenType3IEC: WindGenType3IEC = sup.asInstanceOf[WindGenType3IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindGenType3bIEC] }
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
        "\t\t<cim:WindGenType3bIEC.mwtcwp>" + mwtcwp + "</cim:WindGenType3bIEC.mwtcwp>\n" +
        "\t\t<cim:WindGenType3bIEC.tg>" + tg + "</cim:WindGenType3bIEC.tg>\n" +
        "\t\t<cim:WindGenType3bIEC.two>" + two + "</cim:WindGenType3bIEC.two>\n"
    }
    override def export: String =
    {
        "\t<cim:WindGenType3bIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenType3bIEC>"
    }
}

object WindGenType3bIEC
extends
    Parseable[WindGenType3bIEC]
{
    val mwtcwp = parse_element (element ("""WindGenType3bIEC.mwtcwp"""))
    val tg = parse_element (element ("""WindGenType3bIEC.tg"""))
    val two = parse_element (element ("""WindGenType3bIEC.two"""))
    def parse (context: Context): WindGenType3bIEC =
    {
        WindGenType3bIEC(
            WindGenType3IEC.parse (context),
            toBoolean (mwtcwp (context), context),
            toDouble (tg (context), context),
            toDouble (two (context), context)
        )
    }
}

/**
 * IEC Type 4 generator set model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.4.
 *
 * @param sup Reference to the superclass object.
 * @param dipmax Maximum active current ramp rate (di<sub>pmax</sub>).
 *        It is project dependent parameter.
 * @param diqmax Maximum reactive current ramp rate (di<sub>qmax</sub>).
 *        It is project dependent parameter.
 * @param diqmin Minimum reactive current ramp rate (d<i>i</i><sub>qmin</sub>).
 *        It is case dependent parameter.
 * @param tg Time constant (T<sub>g</sub>).
 *        It is type dependent parameter.
 * @param WindTurbineType4aIEC Wind turbine type 4A model with which this wind generator type 4 model is associated.
 * @param WindTurbineType4bIEC Wind turbine type 4B model with which this wind generator type 4 model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindGenType4IEC
(
    override val sup: IdentifiedObject,
    dipmax: Double,
    diqmax: Double,
    diqmin: Double,
    tg: Double,
    WindTurbineType4aIEC: String,
    WindTurbineType4bIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindGenType4IEC] }
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
        "\t\t<cim:WindGenType4IEC.dipmax>" + dipmax + "</cim:WindGenType4IEC.dipmax>\n" +
        "\t\t<cim:WindGenType4IEC.diqmax>" + diqmax + "</cim:WindGenType4IEC.diqmax>\n" +
        "\t\t<cim:WindGenType4IEC.diqmin>" + diqmin + "</cim:WindGenType4IEC.diqmin>\n" +
        "\t\t<cim:WindGenType4IEC.tg>" + tg + "</cim:WindGenType4IEC.tg>\n" +
        (if (null != WindTurbineType4aIEC) "\t\t<cim:WindGenType4IEC.WindTurbineType4aIEC rdf:resource=\"#" + WindTurbineType4aIEC + "\"/>\n" else "") +
        (if (null != WindTurbineType4bIEC) "\t\t<cim:WindGenType4IEC.WindTurbineType4bIEC rdf:resource=\"#" + WindTurbineType4bIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindGenType4IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindGenType4IEC>"
    }
}

object WindGenType4IEC
extends
    Parseable[WindGenType4IEC]
{
    val dipmax = parse_element (element ("""WindGenType4IEC.dipmax"""))
    val diqmax = parse_element (element ("""WindGenType4IEC.diqmax"""))
    val diqmin = parse_element (element ("""WindGenType4IEC.diqmin"""))
    val tg = parse_element (element ("""WindGenType4IEC.tg"""))
    val WindTurbineType4aIEC = parse_attribute (attribute ("""WindGenType4IEC.WindTurbineType4aIEC"""))
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindGenType4IEC.WindTurbineType4bIEC"""))
    def parse (context: Context): WindGenType4IEC =
    {
        WindGenType4IEC(
            IdentifiedObject.parse (context),
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
 * Two mass model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.2.1.
 *
 * @param sup Reference to the superclass object.
 * @param cdrt Drive train damping (<i>c</i><i><sub>drt</sub></i><i>)</i>.
 *        It is type dependent parameter.
 * @param hgen Inertia constant of generator (<i>H</i><sub>gen</sub>).
 *        It is type dependent parameter.
 * @param hwtr Inertia constant of wind turbine rotor (<i>H</i><sub>WTR</sub>).
 *        It is type dependent parameter.
 * @param kdrt Drive train stiffness (<i>k</i><i><sub>drt</sub></i>).
 *        It is type dependent parameter.
 * @param WindTurbineType1or2IEC Wind generator type 1 or 2 model with which this wind mechanical model is associated.
 * @param WindTurbineType3IEC Wind turbine Type 3 model with which this wind mechanical model is associated.
 * @param WindTurbineType4bIEC Wind turbine type 4B model with which this wind mechanical model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindMechIEC
(
    override val sup: IdentifiedObject,
    cdrt: Double,
    hgen: Double,
    hwtr: Double,
    kdrt: Double,
    WindTurbineType1or2IEC: String,
    WindTurbineType3IEC: String,
    WindTurbineType4bIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindMechIEC] }
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
        "\t\t<cim:WindMechIEC.cdrt>" + cdrt + "</cim:WindMechIEC.cdrt>\n" +
        "\t\t<cim:WindMechIEC.hgen>" + hgen + "</cim:WindMechIEC.hgen>\n" +
        "\t\t<cim:WindMechIEC.hwtr>" + hwtr + "</cim:WindMechIEC.hwtr>\n" +
        "\t\t<cim:WindMechIEC.kdrt>" + kdrt + "</cim:WindMechIEC.kdrt>\n" +
        (if (null != WindTurbineType1or2IEC) "\t\t<cim:WindMechIEC.WindTurbineType1or2IEC rdf:resource=\"#" + WindTurbineType1or2IEC + "\"/>\n" else "") +
        (if (null != WindTurbineType3IEC) "\t\t<cim:WindMechIEC.WindTurbineType3IEC rdf:resource=\"#" + WindTurbineType3IEC + "\"/>\n" else "") +
        (if (null != WindTurbineType4bIEC) "\t\t<cim:WindMechIEC.WindTurbineType4bIEC rdf:resource=\"#" + WindTurbineType4bIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindMechIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindMechIEC>"
    }
}

object WindMechIEC
extends
    Parseable[WindMechIEC]
{
    val cdrt = parse_element (element ("""WindMechIEC.cdrt"""))
    val hgen = parse_element (element ("""WindMechIEC.hgen"""))
    val hwtr = parse_element (element ("""WindMechIEC.hwtr"""))
    val kdrt = parse_element (element ("""WindMechIEC.kdrt"""))
    val WindTurbineType1or2IEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType1or2IEC"""))
    val WindTurbineType3IEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType3IEC"""))
    val WindTurbineType4bIEC = parse_attribute (attribute ("""WindMechIEC.WindTurbineType4bIEC"""))
    def parse (context: Context): WindMechIEC =
    {
        WindMechIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.5.1.
 *
 * @param sup Reference to the superclass object.
 * @param dpmax Rate limit for increasing power (d<i>p</i><sub>max</sub>).
 *        It is type dependent parameter.
 * @param dpmin Rate limit for decreasing power (d<i>p</i><sub>min</sub>).
 *        It is type dependent parameter.
 * @param pmin Minimum power setting (<i>p</i><sub>min</sub>).
 *        It is type dependent parameter.
 * @param pset If <i>p</i><sub>init </sub>&lt; <i>p</i><sub>set </sub>then power will ne ramped down to <i>p</i><sub>min</sub>.
 *        It is (<i>p</i><sub>set</sub>) in the IEC 61400-27-1. It is type dependent parameter.
 * @param t1 Lag time constant (<i>T</i><sub>1</sub>).
 *        It is type dependent parameter.
 * @param tr Voltage measurement time constant (<i>T</i><sub>r</sub>).
 *        It is type dependent parameter.
 * @param uuvrt Dip detection threshold (u<sub>UVRT</sub>).
 *        It is type dependent parameter.
 * @param WindGenTurbineType1bIEC Wind turbine type 1B model with which this Pitch control power model is associated.
 * @param WindGenTurbineType2IEC Wind turbine type 2 model with which this Pitch control power model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindPitchContPowerIEC
(
    override val sup: IdentifiedObject,
    dpmax: Double,
    dpmin: Double,
    pmin: Double,
    pset: Double,
    t1: Double,
    tr: Double,
    uuvrt: Double,
    WindGenTurbineType1bIEC: String,
    WindGenTurbineType2IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindPitchContPowerIEC] }
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
        "\t\t<cim:WindPitchContPowerIEC.dpmax>" + dpmax + "</cim:WindPitchContPowerIEC.dpmax>\n" +
        "\t\t<cim:WindPitchContPowerIEC.dpmin>" + dpmin + "</cim:WindPitchContPowerIEC.dpmin>\n" +
        "\t\t<cim:WindPitchContPowerIEC.pmin>" + pmin + "</cim:WindPitchContPowerIEC.pmin>\n" +
        "\t\t<cim:WindPitchContPowerIEC.pset>" + pset + "</cim:WindPitchContPowerIEC.pset>\n" +
        "\t\t<cim:WindPitchContPowerIEC.t1>" + t1 + "</cim:WindPitchContPowerIEC.t1>\n" +
        "\t\t<cim:WindPitchContPowerIEC.tr>" + tr + "</cim:WindPitchContPowerIEC.tr>\n" +
        "\t\t<cim:WindPitchContPowerIEC.uuvrt>" + uuvrt + "</cim:WindPitchContPowerIEC.uuvrt>\n" +
        (if (null != WindGenTurbineType1bIEC) "\t\t<cim:WindPitchContPowerIEC.WindGenTurbineType1bIEC rdf:resource=\"#" + WindGenTurbineType1bIEC + "\"/>\n" else "") +
        (if (null != WindGenTurbineType2IEC) "\t\t<cim:WindPitchContPowerIEC.WindGenTurbineType2IEC rdf:resource=\"#" + WindGenTurbineType2IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindPitchContPowerIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPitchContPowerIEC>"
    }
}

object WindPitchContPowerIEC
extends
    Parseable[WindPitchContPowerIEC]
{
    val dpmax = parse_element (element ("""WindPitchContPowerIEC.dpmax"""))
    val dpmin = parse_element (element ("""WindPitchContPowerIEC.dpmin"""))
    val pmin = parse_element (element ("""WindPitchContPowerIEC.pmin"""))
    val pset = parse_element (element ("""WindPitchContPowerIEC.pset"""))
    val t1 = parse_element (element ("""WindPitchContPowerIEC.t1"""))
    val tr = parse_element (element ("""WindPitchContPowerIEC.tr"""))
    val uuvrt = parse_element (element ("""WindPitchContPowerIEC.uuvrt"""))
    val WindGenTurbineType1bIEC = parse_attribute (attribute ("""WindPitchContPowerIEC.WindGenTurbineType1bIEC"""))
    val WindGenTurbineType2IEC = parse_attribute (attribute ("""WindPitchContPowerIEC.WindGenTurbineType2IEC"""))
    def parse (context: Context): WindPitchContPowerIEC =
    {
        WindPitchContPowerIEC(
            IdentifiedObject.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param RemoteInputSignal The remote signal with which this power plant is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindPlantDynamics
(
    override val sup: DynamicsFunctionBlock,
    RemoteInputSignal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[WindPlantDynamics] }
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
        (if (null != RemoteInputSignal) "\t\t<cim:WindPlantDynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindPlantDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPlantDynamics>"
    }
}

object WindPlantDynamics
extends
    Parseable[WindPlantDynamics]
{
    val RemoteInputSignal = parse_attribute (attribute ("""WindPlantDynamics.RemoteInputSignal"""))
    def parse (context: Context): WindPlantDynamics =
    {
        WindPlantDynamics(
            DynamicsFunctionBlock.parse (context),
            RemoteInputSignal (context)
        )
    }
}

/**
 * Frequency and active power controller model.
 *
 * Reference: IEC Standard 61400-27-1 Annex D.
 *
 * @param sup Reference to the superclass object.
 * @param dprefmax Maximum ramp rate of <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>dp</i><sub>refmax</sub>).
 *        It is case dependent parameter.
 * @param dprefmin Minimum (negative) ramp rate of <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>dp</i><sub>refmin</sub>).
 *        It is project dependent parameter.
 * @param dpwprefmax Maximum positive ramp rate for wind plant power reference (<i>dp</i><sub>WPrefmax</sub>).
 *        It is project dependent parameter.
 * @param dpwprefmin Maximum negative ramp rate for wind plant power reference (<i>dp</i><sub>WPrefmin</sub>).
 *        It is project dependent parameter.
 * @param kiwpp Plant P controller integral gain (<i>K</i><sub>IWPp</sub>).
 *        It is project dependent parameter.
 * @param kiwppmax Maximum PI integrator term (<i>K</i><sub>IWPpmax</sub>).
 *        It is project dependent parameter.
 * @param kiwppmin Minimum PI integrator term (<i>K</i><sub>IWPpmin</sub>).
 *        It is project dependent parameter.
 * @param kpwpp Plant P controller proportional gain (<i>K</i><sub>PWPp</sub>).
 *        It is project dependent parameter.
 * @param kwppref Power reference gain (<i>K</i><sub>WPpref</sub>).
 *        It is project dependent parameter.
 * @param prefmax Maximum <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>p</i><sub>refmax</sub>).
 *        It is project dependent parameter.
 * @param prefmin Minimum <i>p</i><sub>WTref</sub> request from the plant controller to the wind turbines (<i>p</i><sub>refmin</sub>).
 *        It is project dependent parameter.
 * @param tpft Lead time constant in reference value transfer function (<i>T</i><sub>pft</sub>).
 *        It is project dependent parameter.
 * @param tpfv Lag time constant in reference value transfer function (<i>T</i><sub>pfv</sub>).
 *        It is project dependent parameter.
 * @param twpffiltp Filter time constant for frequency measurement (<i>T</i><sub>WPffiltp</sub>).
 *        It is project dependent parameter.
 * @param twppfiltp Filter time constant for active power measurement (<i>T</i><sub>WPpfiltp</sub>).
 *        It is project dependent parameter.
 * @param WindPlantIEC Wind plant model with which this wind plant frequency and active power control is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindPlantFreqPcontrolIEC
(
    override val sup: IdentifiedObject,
    dprefmax: Double,
    dprefmin: Double,
    dpwprefmax: Double,
    dpwprefmin: Double,
    kiwpp: Double,
    kiwppmax: Double,
    kiwppmin: Double,
    kpwpp: Double,
    kwppref: Double,
    prefmax: Double,
    prefmin: Double,
    tpft: Double,
    tpfv: Double,
    twpffiltp: Double,
    twppfiltp: Double,
    WindPlantIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindPlantFreqPcontrolIEC] }
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
        "\t\t<cim:WindPlantFreqPcontrolIEC.dprefmax>" + dprefmax + "</cim:WindPlantFreqPcontrolIEC.dprefmax>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.dprefmin>" + dprefmin + "</cim:WindPlantFreqPcontrolIEC.dprefmin>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.dpwprefmax>" + dpwprefmax + "</cim:WindPlantFreqPcontrolIEC.dpwprefmax>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.dpwprefmin>" + dpwprefmin + "</cim:WindPlantFreqPcontrolIEC.dpwprefmin>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.kiwpp>" + kiwpp + "</cim:WindPlantFreqPcontrolIEC.kiwpp>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.kiwppmax>" + kiwppmax + "</cim:WindPlantFreqPcontrolIEC.kiwppmax>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.kiwppmin>" + kiwppmin + "</cim:WindPlantFreqPcontrolIEC.kiwppmin>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.kpwpp>" + kpwpp + "</cim:WindPlantFreqPcontrolIEC.kpwpp>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.kwppref>" + kwppref + "</cim:WindPlantFreqPcontrolIEC.kwppref>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.prefmax>" + prefmax + "</cim:WindPlantFreqPcontrolIEC.prefmax>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.prefmin>" + prefmin + "</cim:WindPlantFreqPcontrolIEC.prefmin>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.tpft>" + tpft + "</cim:WindPlantFreqPcontrolIEC.tpft>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.tpfv>" + tpfv + "</cim:WindPlantFreqPcontrolIEC.tpfv>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.twpffiltp>" + twpffiltp + "</cim:WindPlantFreqPcontrolIEC.twpffiltp>\n" +
        "\t\t<cim:WindPlantFreqPcontrolIEC.twppfiltp>" + twppfiltp + "</cim:WindPlantFreqPcontrolIEC.twppfiltp>\n" +
        (if (null != WindPlantIEC) "\t\t<cim:WindPlantFreqPcontrolIEC.WindPlantIEC rdf:resource=\"#" + WindPlantIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindPlantFreqPcontrolIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPlantFreqPcontrolIEC>"
    }
}

object WindPlantFreqPcontrolIEC
extends
    Parseable[WindPlantFreqPcontrolIEC]
{
    val dprefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.dprefmax"""))
    val dprefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.dprefmin"""))
    val dpwprefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.dpwprefmax"""))
    val dpwprefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.dpwprefmin"""))
    val kiwpp = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwpp"""))
    val kiwppmax = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwppmax"""))
    val kiwppmin = parse_element (element ("""WindPlantFreqPcontrolIEC.kiwppmin"""))
    val kpwpp = parse_element (element ("""WindPlantFreqPcontrolIEC.kpwpp"""))
    val kwppref = parse_element (element ("""WindPlantFreqPcontrolIEC.kwppref"""))
    val prefmax = parse_element (element ("""WindPlantFreqPcontrolIEC.prefmax"""))
    val prefmin = parse_element (element ("""WindPlantFreqPcontrolIEC.prefmin"""))
    val tpft = parse_element (element ("""WindPlantFreqPcontrolIEC.tpft"""))
    val tpfv = parse_element (element ("""WindPlantFreqPcontrolIEC.tpfv"""))
    val twpffiltp = parse_element (element ("""WindPlantFreqPcontrolIEC.twpffiltp"""))
    val twppfiltp = parse_element (element ("""WindPlantFreqPcontrolIEC.twppfiltp"""))
    val WindPlantIEC = parse_attribute (attribute ("""WindPlantFreqPcontrolIEC.WindPlantIEC"""))
    def parse (context: Context): WindPlantFreqPcontrolIEC =
    {
        WindPlantFreqPcontrolIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC 61400-27-1, Annex D.
 *
 * @param sup Reference to the superclass object.
 * @param WindPlantFreqPcontrolIEC Wind plant frequency and active power control model associated with this wind plant.
 * @param WindPlantReactiveControlIEC Wind plant model with which this wind reactive control is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindPlantIEC
(
    override val sup: WindPlantDynamics,
    WindPlantFreqPcontrolIEC: String,
    WindPlantReactiveControlIEC: String
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
    def WindPlantDynamics: WindPlantDynamics = sup.asInstanceOf[WindPlantDynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindPlantIEC] }
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
        (if (null != WindPlantFreqPcontrolIEC) "\t\t<cim:WindPlantIEC.WindPlantFreqPcontrolIEC rdf:resource=\"#" + WindPlantFreqPcontrolIEC + "\"/>\n" else "") +
        (if (null != WindPlantReactiveControlIEC) "\t\t<cim:WindPlantIEC.WindPlantReactiveControlIEC rdf:resource=\"#" + WindPlantReactiveControlIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindPlantIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPlantIEC>"
    }
}

object WindPlantIEC
extends
    Parseable[WindPlantIEC]
{
    val WindPlantFreqPcontrolIEC = parse_attribute (attribute ("""WindPlantIEC.WindPlantFreqPcontrolIEC"""))
    val WindPlantReactiveControlIEC = parse_attribute (attribute ("""WindPlantIEC.WindPlantReactiveControlIEC"""))
    def parse (context: Context): WindPlantIEC =
    {
        WindPlantIEC(
            WindPlantDynamics.parse (context),
            WindPlantFreqPcontrolIEC (context),
            WindPlantReactiveControlIEC (context)
        )
    }
}

/**
 * Simplified plant voltage and reactive power control model for use with type 3 and type 4 wind turbine models.
 *
 * Reference: IEC Standard 61400-27-1 Annex D.
 *
 * @param sup Reference to the superclass object.
 * @param dxrefmax Maximum positive ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><sub>refmax</sub>).
 *        It is project dependent parameter.
 * @param dxrefmin Maximum negative ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><sub>refmin</sub>).
 *        It is project dependent parameter.
 * @param kiwpx Plant Q controller integral gain (<i>K</i><sub>IWPx</sub>).
 *        It is project dependent parameter.
 * @param kiwpxmax Maximum reactive Power/voltage reference from integration (<i>K</i><sub>IWPxmax</sub>).
 *        It is project dependent parameter.
 * @param kiwpxmin Minimum reactive Power/voltage reference from integration (<i>K</i><sub>IWPxmin</sub>).
 *        It is project dependent parameter.
 * @param kpwpx Plant Q controller proportional gain (<i>K</i><sub>PWPx</sub>).
 *        It is project dependent parameter.
 * @param kwpqref Reactive power reference gain (<i>K</i><sub>WPqref</sub>).
 *        It is project dependent parameter.
 * @param kwpqu Plant voltage control droop (<i>K</i><sub>WPqu</sub>).
 *        It is project dependent parameter.
 * @param tuqfilt Filter time constant for voltage dependent reactive power (<i>T</i><sub>uqfilt</sub>).
 *        It is project dependent parameter.
 * @param twppfiltq Filter time constant for active power measurement (<i>T</i><sub>WPpfiltq</sub>).
 *        It is project dependent parameter.
 * @param twpqfiltq Filter time constant for reactive power measurement (<i>T</i><sub>WPqfiltq</sub>).
 *        It is project dependent parameter.
 * @param twpufiltq Filter time constant for voltage measurement (<i>T</i><sub>WPufiltq</sub>).
 *        It is project dependent parameter.
 * @param txft Lead time constant in reference value transfer function (<i>T</i><sub>xft</sub>).
 *        It is project dependent parameter.
 * @param txfv Lag time constant in reference value transfer function (<i>T</i><sub>xfv</sub>).
 *        It is project dependent parameter.
 * @param uwpqdip Voltage threshold for UVRT detection in q control (<i>u</i><sub>WPqdip</sub>).
 *        It is project dependent parameter.
 * @param windPlantQcontrolModesType Reactive power/voltage controller mode (<i>M</i><sub>WPqmode</sub>).
 *        It is case dependent parameter.
 * @param xrefmax Maximum <i>x</i><sub>WTref</sub> (<i>q</i><sub>WTref</sub> or delta <i>u</i><sub>WTref</sub>) request from the plant controller (<i>x</i><sub>refmax</sub>).
 *        It is case dependent parameter.
 * @param xrefmin Minimum <i>x</i><sub>WTref</sub> (<i>q</i><sub>WTref</sub> or delta<i>u</i><sub>WTref</sub>) request from the plant controller (<i>x</i><sub>refmin</sub>).
 *        It is project dependent parameter.
 * @param WindPlantIEC Wind plant reactive control model associated with this wind plant.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindPlantReactiveControlIEC
(
    override val sup: IdentifiedObject,
    dxrefmax: Double,
    dxrefmin: Double,
    kiwpx: Double,
    kiwpxmax: Double,
    kiwpxmin: Double,
    kpwpx: Double,
    kwpqref: Double,
    kwpqu: Double,
    tuqfilt: Double,
    twppfiltq: Double,
    twpqfiltq: Double,
    twpufiltq: Double,
    txft: Double,
    txfv: Double,
    uwpqdip: Double,
    windPlantQcontrolModesType: String,
    xrefmax: Double,
    xrefmin: Double,
    WindPlantIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindPlantReactiveControlIEC] }
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
        "\t\t<cim:WindPlantReactiveControlIEC.dxrefmax>" + dxrefmax + "</cim:WindPlantReactiveControlIEC.dxrefmax>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.dxrefmin>" + dxrefmin + "</cim:WindPlantReactiveControlIEC.dxrefmin>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kiwpx>" + kiwpx + "</cim:WindPlantReactiveControlIEC.kiwpx>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kiwpxmax>" + kiwpxmax + "</cim:WindPlantReactiveControlIEC.kiwpxmax>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kiwpxmin>" + kiwpxmin + "</cim:WindPlantReactiveControlIEC.kiwpxmin>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kpwpx>" + kpwpx + "</cim:WindPlantReactiveControlIEC.kpwpx>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kwpqref>" + kwpqref + "</cim:WindPlantReactiveControlIEC.kwpqref>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.kwpqu>" + kwpqu + "</cim:WindPlantReactiveControlIEC.kwpqu>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.tuqfilt>" + tuqfilt + "</cim:WindPlantReactiveControlIEC.tuqfilt>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.twppfiltq>" + twppfiltq + "</cim:WindPlantReactiveControlIEC.twppfiltq>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.twpqfiltq>" + twpqfiltq + "</cim:WindPlantReactiveControlIEC.twpqfiltq>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.twpufiltq>" + twpufiltq + "</cim:WindPlantReactiveControlIEC.twpufiltq>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.txft>" + txft + "</cim:WindPlantReactiveControlIEC.txft>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.txfv>" + txfv + "</cim:WindPlantReactiveControlIEC.txfv>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.uwpqdip>" + uwpqdip + "</cim:WindPlantReactiveControlIEC.uwpqdip>\n" +
        (if (null != windPlantQcontrolModesType) "\t\t<cim:WindPlantReactiveControlIEC.windPlantQcontrolModesType rdf:resource=\"#" + windPlantQcontrolModesType + "\"/>\n" else "") +
        "\t\t<cim:WindPlantReactiveControlIEC.xrefmax>" + xrefmax + "</cim:WindPlantReactiveControlIEC.xrefmax>\n" +
        "\t\t<cim:WindPlantReactiveControlIEC.xrefmin>" + xrefmin + "</cim:WindPlantReactiveControlIEC.xrefmin>\n" +
        (if (null != WindPlantIEC) "\t\t<cim:WindPlantReactiveControlIEC.WindPlantIEC rdf:resource=\"#" + WindPlantIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindPlantReactiveControlIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindPlantReactiveControlIEC>"
    }
}

object WindPlantReactiveControlIEC
extends
    Parseable[WindPlantReactiveControlIEC]
{
    val dxrefmax = parse_element (element ("""WindPlantReactiveControlIEC.dxrefmax"""))
    val dxrefmin = parse_element (element ("""WindPlantReactiveControlIEC.dxrefmin"""))
    val kiwpx = parse_element (element ("""WindPlantReactiveControlIEC.kiwpx"""))
    val kiwpxmax = parse_element (element ("""WindPlantReactiveControlIEC.kiwpxmax"""))
    val kiwpxmin = parse_element (element ("""WindPlantReactiveControlIEC.kiwpxmin"""))
    val kpwpx = parse_element (element ("""WindPlantReactiveControlIEC.kpwpx"""))
    val kwpqref = parse_element (element ("""WindPlantReactiveControlIEC.kwpqref"""))
    val kwpqu = parse_element (element ("""WindPlantReactiveControlIEC.kwpqu"""))
    val tuqfilt = parse_element (element ("""WindPlantReactiveControlIEC.tuqfilt"""))
    val twppfiltq = parse_element (element ("""WindPlantReactiveControlIEC.twppfiltq"""))
    val twpqfiltq = parse_element (element ("""WindPlantReactiveControlIEC.twpqfiltq"""))
    val twpufiltq = parse_element (element ("""WindPlantReactiveControlIEC.twpufiltq"""))
    val txft = parse_element (element ("""WindPlantReactiveControlIEC.txft"""))
    val txfv = parse_element (element ("""WindPlantReactiveControlIEC.txfv"""))
    val uwpqdip = parse_element (element ("""WindPlantReactiveControlIEC.uwpqdip"""))
    val windPlantQcontrolModesType = parse_attribute (attribute ("""WindPlantReactiveControlIEC.windPlantQcontrolModesType"""))
    val xrefmax = parse_element (element ("""WindPlantReactiveControlIEC.xrefmax"""))
    val xrefmin = parse_element (element ("""WindPlantReactiveControlIEC.xrefmin"""))
    val WindPlantIEC = parse_attribute (attribute ("""WindPlantReactiveControlIEC.WindPlantIEC"""))
    def parse (context: Context): WindPlantReactiveControlIEC =
    {
        WindPlantReactiveControlIEC(
            IdentifiedObject.parse (context),
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
 *
 * Reference: IEC Standard 614000-27-1 Section 5.6.6.
 *
 * @param sup Reference to the superclass object.
 * @param dfimax Maximum rate of change of frequency (<i>dF</i><i><sub>max</sub></i>).
 *        It is type dependent parameter.
 * @param fover Wind turbine over frequency protection activation threshold (<i>f</i><i><sub>over</sub></i>).
 *        It is project dependent parameter.
 * @param funder Wind turbine under frequency protection activation threshold (<i>f</i><i><sub>under</sub></i>).
 *        It is project dependent parameter.
 * @param mzc Zero crossing measurement mode (<i>Mzc</i>).
 *        True = 1 if the WT protection system uses zero crossings to detect frequency � otherwise false = 0. It is type dependent parameter.
 * @param tfma Time interval of moving average window (<i>TfMA</i>).
 *        It is type dependent parameter.
 * @param uover Wind turbine over voltage protection activation threshold (<i>u</i><i><sub>over</sub></i>).
 *        It is project dependent parameter.
 * @param uunder Wind turbine under voltage protection activation threshold (<i>u</i><i><sub>under</sub></i>).
 *        It is project dependent parameter.
 * @param WindTurbineType1or2IEC Wind generator type 1 or 2 model with which this wind turbine protection model is associated.
 * @param WindTurbineType3or4IEC Wind generator type 3 or 4 model with which this wind turbine protection model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindProtectionIEC
(
    override val sup: IdentifiedObject,
    dfimax: Double,
    fover: Double,
    funder: Double,
    mzc: Boolean,
    tfma: Double,
    uover: Double,
    uunder: Double,
    WindTurbineType1or2IEC: String,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindProtectionIEC] }
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
        "\t\t<cim:WindProtectionIEC.dfimax>" + dfimax + "</cim:WindProtectionIEC.dfimax>\n" +
        "\t\t<cim:WindProtectionIEC.fover>" + fover + "</cim:WindProtectionIEC.fover>\n" +
        "\t\t<cim:WindProtectionIEC.funder>" + funder + "</cim:WindProtectionIEC.funder>\n" +
        "\t\t<cim:WindProtectionIEC.mzc>" + mzc + "</cim:WindProtectionIEC.mzc>\n" +
        "\t\t<cim:WindProtectionIEC.tfma>" + tfma + "</cim:WindProtectionIEC.tfma>\n" +
        "\t\t<cim:WindProtectionIEC.uover>" + uover + "</cim:WindProtectionIEC.uover>\n" +
        "\t\t<cim:WindProtectionIEC.uunder>" + uunder + "</cim:WindProtectionIEC.uunder>\n" +
        (if (null != WindTurbineType1or2IEC) "\t\t<cim:WindProtectionIEC.WindTurbineType1or2IEC rdf:resource=\"#" + WindTurbineType1or2IEC + "\"/>\n" else "") +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindProtectionIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindProtectionIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindProtectionIEC>"
    }
}

object WindProtectionIEC
extends
    Parseable[WindProtectionIEC]
{
    val dfimax = parse_element (element ("""WindProtectionIEC.dfimax"""))
    val fover = parse_element (element ("""WindProtectionIEC.fover"""))
    val funder = parse_element (element ("""WindProtectionIEC.funder"""))
    val mzc = parse_element (element ("""WindProtectionIEC.mzc"""))
    val tfma = parse_element (element ("""WindProtectionIEC.tfma"""))
    val uover = parse_element (element ("""WindProtectionIEC.uover"""))
    val uunder = parse_element (element ("""WindProtectionIEC.uunder"""))
    val WindTurbineType1or2IEC = parse_attribute (attribute ("""WindProtectionIEC.WindTurbineType1or2IEC"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindProtectionIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindProtectionIEC =
    {
        WindProtectionIEC(
            IdentifiedObject.parse (context),
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
 * Reference frame rotation model.
 *
 * Reference: IEC Standard 61400-27-1 Section 5.6.3.5.
 *
 * @param sup Reference to the superclass object.
 * @param tpll Time constant for PLL first order filter model (T<sub>PLL</sub>).
 *        It is type dependent parameter.
 * @param upll1 Voltage below which the angle of the voltage is filtered and possibly also frozen (u<sub>PLL1</sub>).
 *        It is type dependent parameter.
 * @param upll2 Voltage (u<sub>PLL2</sub>) below which the angle of the voltage is frozen if u<sub>PLL2 </sub>is smaller or equal to u<sub>PLL1</sub> .
 *        It is type dependent parameter.
 * @param WindTurbineType3or4IEC Wind turbine type 3 or 4 model with which this reference frame rotation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindRefFrameRotIEC
(
    override val sup: IdentifiedObject,
    tpll: Double,
    upll1: Double,
    upll2: Double,
    WindTurbineType3or4IEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WindRefFrameRotIEC] }
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
        "\t\t<cim:WindRefFrameRotIEC.tpll>" + tpll + "</cim:WindRefFrameRotIEC.tpll>\n" +
        "\t\t<cim:WindRefFrameRotIEC.upll1>" + upll1 + "</cim:WindRefFrameRotIEC.upll1>\n" +
        "\t\t<cim:WindRefFrameRotIEC.upll2>" + upll2 + "</cim:WindRefFrameRotIEC.upll2>\n" +
        (if (null != WindTurbineType3or4IEC) "\t\t<cim:WindRefFrameRotIEC.WindTurbineType3or4IEC rdf:resource=\"#" + WindTurbineType3or4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindRefFrameRotIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindRefFrameRotIEC>"
    }
}

object WindRefFrameRotIEC
extends
    Parseable[WindRefFrameRotIEC]
{
    val tpll = parse_element (element ("""WindRefFrameRotIEC.tpll"""))
    val upll1 = parse_element (element ("""WindRefFrameRotIEC.upll1"""))
    val upll2 = parse_element (element ("""WindRefFrameRotIEC.upll2"""))
    val WindTurbineType3or4IEC = parse_attribute (attribute ("""WindRefFrameRotIEC.WindTurbineType3or4IEC"""))
    def parse (context: Context): WindRefFrameRotIEC =
    {
        WindRefFrameRotIEC(
            IdentifiedObject.parse (context),
            toDouble (tpll (context), context),
            toDouble (upll1 (context), context),
            toDouble (upll2 (context), context),
            WindTurbineType3or4IEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to wind turbines Type 1 and 2 and their control models.
 *
 * @param sup Reference to the superclass object.
 * @param AsynchronousMachineDynamics Asynchronous machine model with which this wind generator type 1 or 2 model is associated.
 * @param RemoteInputSignal Remote input signal used by this wind generator Type 1 or Type 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType1or2Dynamics
(
    override val sup: DynamicsFunctionBlock,
    AsynchronousMachineDynamics: String,
    RemoteInputSignal: String
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
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType1or2Dynamics] }
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
        (if (null != AsynchronousMachineDynamics) "\t\t<cim:WindTurbineType1or2Dynamics.AsynchronousMachineDynamics rdf:resource=\"#" + AsynchronousMachineDynamics + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:WindTurbineType1or2Dynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType1or2Dynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType1or2Dynamics>"
    }
}

object WindTurbineType1or2Dynamics
extends
    Parseable[WindTurbineType1or2Dynamics]
{
    val AsynchronousMachineDynamics = parse_attribute (attribute ("""WindTurbineType1or2Dynamics.AsynchronousMachineDynamics"""))
    val RemoteInputSignal = parse_attribute (attribute ("""WindTurbineType1or2Dynamics.RemoteInputSignal"""))
    def parse (context: Context): WindTurbineType1or2Dynamics =
    {
        WindTurbineType1or2Dynamics(
            DynamicsFunctionBlock.parse (context),
            AsynchronousMachineDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 1 and 2 including their control models.
 *
 * Generator model for wind turbine of IEC Type 1 or Type 2 is a standard asynchronous generator model.
 *
 * @param sup Reference to the superclass object.
 * @param WindMechIEC Wind mechanical model associated with this wind generator type 1 or 2 model.
 * @param WindProtectionIEC Wind turbune protection model associated with this wind generator type 1 or 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType1or2IEC
(
    override val sup: WindTurbineType1or2Dynamics,
    WindMechIEC: String,
    WindProtectionIEC: String
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
    def WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = sup.asInstanceOf[WindTurbineType1or2Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType1or2IEC] }
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
        (if (null != WindMechIEC) "\t\t<cim:WindTurbineType1or2IEC.WindMechIEC rdf:resource=\"#" + WindMechIEC + "\"/>\n" else "") +
        (if (null != WindProtectionIEC) "\t\t<cim:WindTurbineType1or2IEC.WindProtectionIEC rdf:resource=\"#" + WindProtectionIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType1or2IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType1or2IEC>"
    }
}

object WindTurbineType1or2IEC
extends
    Parseable[WindTurbineType1or2IEC]
{
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType1or2IEC.WindMechIEC"""))
    val WindProtectionIEC = parse_attribute (attribute ("""WindTurbineType1or2IEC.WindProtectionIEC"""))
    def parse (context: Context): WindTurbineType1or2IEC =
    {
        WindTurbineType1or2IEC(
            WindTurbineType1or2Dynamics.parse (context),
            WindMechIEC (context),
            WindProtectionIEC (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 including their control models.
 *
 * @param sup Reference to the superclass object.
 * @param WindAeroOneDimIEC Wind aerodynamic model associated with this wind generator type 3 model.
 * @param WindAeroTwoDimIEC Wind aerodynamic model associated with this wind turbine type 3 model.
 * @param WindContPType3IEC Wind control P type 3 model associated with this wind turbine type 3 model.
 * @param WindContPitchAngleIEC Wind control pitch angle model associated with this wind turbine type 3.
 * @param WindGenType3IEC Wind generator Type 3 model associated with this wind turbine type 3 model.
 * @param WindMechIEC Wind mechanical model associated with this wind turbine Type 3 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType3IEC
(
    override val sup: WindTurbineType3or4IEC,
    WindAeroOneDimIEC: String,
    WindAeroTwoDimIEC: String,
    WindContPType3IEC: String,
    WindContPitchAngleIEC: String,
    WindGenType3IEC: String,
    WindMechIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup.asInstanceOf[WindTurbineType3or4IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType3IEC] }
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
        (if (null != WindAeroOneDimIEC) "\t\t<cim:WindTurbineType3IEC.WindAeroOneDimIEC rdf:resource=\"#" + WindAeroOneDimIEC + "\"/>\n" else "") +
        (if (null != WindAeroTwoDimIEC) "\t\t<cim:WindTurbineType3IEC.WindAeroTwoDimIEC rdf:resource=\"#" + WindAeroTwoDimIEC + "\"/>\n" else "") +
        (if (null != WindContPType3IEC) "\t\t<cim:WindTurbineType3IEC.WindContPType3IEC rdf:resource=\"#" + WindContPType3IEC + "\"/>\n" else "") +
        (if (null != WindContPitchAngleIEC) "\t\t<cim:WindTurbineType3IEC.WindContPitchAngleIEC rdf:resource=\"#" + WindContPitchAngleIEC + "\"/>\n" else "") +
        (if (null != WindGenType3IEC) "\t\t<cim:WindTurbineType3IEC.WindGenType3IEC rdf:resource=\"#" + WindGenType3IEC + "\"/>\n" else "") +
        (if (null != WindMechIEC) "\t\t<cim:WindTurbineType3IEC.WindMechIEC rdf:resource=\"#" + WindMechIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType3IEC>"
    }
}

object WindTurbineType3IEC
extends
    Parseable[WindTurbineType3IEC]
{
    val WindAeroOneDimIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindAeroOneDimIEC"""))
    val WindAeroTwoDimIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindAeroTwoDimIEC"""))
    val WindContPType3IEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindContPType3IEC"""))
    val WindContPitchAngleIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindContPitchAngleIEC"""))
    val WindGenType3IEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindGenType3IEC"""))
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType3IEC.WindMechIEC"""))
    def parse (context: Context): WindTurbineType3IEC =
    {
        WindTurbineType3IEC(
            WindTurbineType3or4IEC.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param EnergySource Energy Source (current source) with which this wind Type 3 or 4 dynamics model is asoociated.
 * @param RemoteInputSignal Remote input signal used by these wind turbine Type 3 or 4 models.
 * @param WindPlantDynamics The wind plant with which the wind turbines type 3 or 4 are associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType3or4Dynamics
(
    override val sup: DynamicsFunctionBlock,
    EnergySource: String,
    RemoteInputSignal: String,
    WindPlantDynamics: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType3or4Dynamics] }
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
        (if (null != EnergySource) "\t\t<cim:WindTurbineType3or4Dynamics.EnergySource rdf:resource=\"#" + EnergySource + "\"/>\n" else "") +
        (if (null != RemoteInputSignal) "\t\t<cim:WindTurbineType3or4Dynamics.RemoteInputSignal rdf:resource=\"#" + RemoteInputSignal + "\"/>\n" else "") +
        (if (null != WindPlantDynamics) "\t\t<cim:WindTurbineType3or4Dynamics.WindPlantDynamics rdf:resource=\"#" + WindPlantDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3or4Dynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType3or4Dynamics>"
    }
}

object WindTurbineType3or4Dynamics
extends
    Parseable[WindTurbineType3or4Dynamics]
{
    val EnergySource = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.EnergySource"""))
    val RemoteInputSignal = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.RemoteInputSignal"""))
    val WindPlantDynamics = parse_attribute (attribute ("""WindTurbineType3or4Dynamics.WindPlantDynamics"""))
    def parse (context: Context): WindTurbineType3or4Dynamics =
    {
        WindTurbineType3or4Dynamics(
            DynamicsFunctionBlock.parse (context),
            EnergySource (context),
            RemoteInputSignal (context),
            WindPlantDynamics (context)
        )
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines Type 3 and 4 including their control models.
 *
 * @param sup Reference to the superclass object.
 * @param WIndContQIEC Wind control Q model associated with this wind turbine type 3 or 4 model.
 * @param WindContCurrLimIEC Wind control current limitation model associated with this wind turbine type 3 or 4 model.
 * @param WindContQLimIEC Constant Q limitation model associated with this wind generator type 3 or 4 model.
 * @param WindContQPQULimIEC QP and QU limitation model associated with this wind generator type 3 or 4 model.
 * @param WindProtectionIEC Wind turbune protection model associated with this wind generator type 3 or 4 model.
 * @param WindRefFrameRotIEC Reference frame rotation model associated with this wind turbine type 3 or 4 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType3or4IEC
(
    override val sup: WindTurbineType3or4Dynamics,
    WIndContQIEC: String,
    WindContCurrLimIEC: String,
    WindContQLimIEC: String,
    WindContQPQULimIEC: String,
    WindProtectionIEC: String,
    WindRefFrameRotIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = sup.asInstanceOf[WindTurbineType3or4Dynamics]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType3or4IEC] }
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
        (if (null != WIndContQIEC) "\t\t<cim:WindTurbineType3or4IEC.WIndContQIEC rdf:resource=\"#" + WIndContQIEC + "\"/>\n" else "") +
        (if (null != WindContCurrLimIEC) "\t\t<cim:WindTurbineType3or4IEC.WindContCurrLimIEC rdf:resource=\"#" + WindContCurrLimIEC + "\"/>\n" else "") +
        (if (null != WindContQLimIEC) "\t\t<cim:WindTurbineType3or4IEC.WindContQLimIEC rdf:resource=\"#" + WindContQLimIEC + "\"/>\n" else "") +
        (if (null != WindContQPQULimIEC) "\t\t<cim:WindTurbineType3or4IEC.WindContQPQULimIEC rdf:resource=\"#" + WindContQPQULimIEC + "\"/>\n" else "") +
        (if (null != WindProtectionIEC) "\t\t<cim:WindTurbineType3or4IEC.WindProtectionIEC rdf:resource=\"#" + WindProtectionIEC + "\"/>\n" else "") +
        (if (null != WindRefFrameRotIEC) "\t\t<cim:WindTurbineType3or4IEC.WindRefFrameRotIEC rdf:resource=\"#" + WindRefFrameRotIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3or4IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType3or4IEC>"
    }
}

object WindTurbineType3or4IEC
extends
    Parseable[WindTurbineType3or4IEC]
{
    val WIndContQIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WIndContQIEC"""))
    val WindContCurrLimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContCurrLimIEC"""))
    val WindContQLimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContQLimIEC"""))
    val WindContQPQULimIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindContQPQULimIEC"""))
    val WindProtectionIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindProtectionIEC"""))
    val WindRefFrameRotIEC = parse_attribute (attribute ("""WindTurbineType3or4IEC.WindRefFrameRotIEC"""))
    def parse (context: Context): WindTurbineType3or4IEC =
    {
        WindTurbineType3or4IEC(
            WindTurbineType3or4Dynamics.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @param WindGenType3aIEC Wind generator type 3A model associated with this wind turbine type 4 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType4IEC
(
    override val sup: WindTurbineType3or4IEC,
    WindGenType3aIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup.asInstanceOf[WindTurbineType3or4IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType4IEC] }
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
        (if (null != WindGenType3aIEC) "\t\t<cim:WindTurbineType4IEC.WindGenType3aIEC rdf:resource=\"#" + WindGenType3aIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4IEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType4IEC>"
    }
}

object WindTurbineType4IEC
extends
    Parseable[WindTurbineType4IEC]
{
    val WindGenType3aIEC = parse_attribute (attribute ("""WindTurbineType4IEC.WindGenType3aIEC"""))
    def parse (context: Context): WindTurbineType4IEC =
    {
        WindTurbineType4IEC(
            WindTurbineType3or4IEC.parse (context),
            WindGenType3aIEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 4A.
 *
 * Reference: IEC Standard 61400-27-1, section 5.5.5.3.
 *
 * @param sup Reference to the superclass object.
 * @param WindContPType4aIEC Wind control P type 4A model associated with this wind turbine type 4A model.
 * @param WindGenType4IEC Wind generator type 4 model associated with this wind turbine type 4A model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType4aIEC
(
    override val sup: WindTurbineType4IEC,
    WindContPType4aIEC: String,
    WindGenType4IEC: String
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
    def WindTurbineType4IEC: WindTurbineType4IEC = sup.asInstanceOf[WindTurbineType4IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType4aIEC] }
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
        (if (null != WindContPType4aIEC) "\t\t<cim:WindTurbineType4aIEC.WindContPType4aIEC rdf:resource=\"#" + WindContPType4aIEC + "\"/>\n" else "") +
        (if (null != WindGenType4IEC) "\t\t<cim:WindTurbineType4aIEC.WindGenType4IEC rdf:resource=\"#" + WindGenType4IEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4aIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType4aIEC>"
    }
}

object WindTurbineType4aIEC
extends
    Parseable[WindTurbineType4aIEC]
{
    val WindContPType4aIEC = parse_attribute (attribute ("""WindTurbineType4aIEC.WindContPType4aIEC"""))
    val WindGenType4IEC = parse_attribute (attribute ("""WindTurbineType4aIEC.WindGenType4IEC"""))
    def parse (context: Context): WindTurbineType4aIEC =
    {
        WindTurbineType4aIEC(
            WindTurbineType4IEC.parse (context),
            WindContPType4aIEC (context),
            WindGenType4IEC (context)
        )
    }
}

/**
 * Wind turbine IEC Type 4A.
 *
 * Reference: IEC Standard 61400-27-1, section 5.5.5.2.
 *
 * @param sup Reference to the superclass object.
 * @param WindContPType4bIEC Wind control P type 4B model associated with this wind turbine type 4B model.
 * @param WindGenType4IEC Wind generator type 4 model associated with this wind turbine type 4B model.
 * @param WindMechIEC Wind mechanical model associated with this wind turbine Type 4B model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into 4 types, which are currently significant in power systems. The 4 types have the following characteristics:
<ul>
	<li>Type 1: Wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage)</li>
	<li>Type 2: Wind turbine with directly grid connected asynchronous generator with variable rotor resistance</li>
	<li>Type 3: Wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter)</li>
	<li>Type 4: Wind turbines connected fully through a power converter.</li>
</ul>

Models included in this package are according to IEC 61400-27-1.

Note: Each attribute is categorized as type, project, or case parameter. The definitions related to this categorization are specified by IEC 61400-27-1, section 6.4.2.
 */
case class WindTurbineType4bIEC
(
    override val sup: WindTurbineType4IEC,
    WindContPType4bIEC: String,
    WindGenType4IEC: String,
    WindMechIEC: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WindTurbineType4IEC: WindTurbineType4IEC = sup.asInstanceOf[WindTurbineType4IEC]
    override def copy (): Row = { clone ().asInstanceOf[WindTurbineType4bIEC] }
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
        (if (null != WindContPType4bIEC) "\t\t<cim:WindTurbineType4bIEC.WindContPType4bIEC rdf:resource=\"#" + WindContPType4bIEC + "\"/>\n" else "") +
        (if (null != WindGenType4IEC) "\t\t<cim:WindTurbineType4bIEC.WindGenType4IEC rdf:resource=\"#" + WindGenType4IEC + "\"/>\n" else "") +
        (if (null != WindMechIEC) "\t\t<cim:WindTurbineType4bIEC.WindMechIEC rdf:resource=\"#" + WindMechIEC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4bIEC rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WindTurbineType4bIEC>"
    }
}

object WindTurbineType4bIEC
extends
    Parseable[WindTurbineType4bIEC]
{
    val WindContPType4bIEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindContPType4bIEC"""))
    val WindGenType4IEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindGenType4IEC"""))
    val WindMechIEC = parse_attribute (attribute ("""WindTurbineType4bIEC.WindMechIEC"""))
    def parse (context: Context): WindTurbineType4bIEC =
    {
        WindTurbineType4bIEC(
            WindTurbineType4IEC.parse (context),
            WindContPType4bIEC (context),
            WindGenType4IEC (context),
            WindMechIEC (context)
        )
    }
}

private[ninecode] object _WindDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            WindAeroConstIEC.register,
            WindAeroOneDimIEC.register,
            WindAeroTwoDimIEC.register,
            WindContCurrLimIEC.register,
            WindContPType3IEC.register,
            WindContPType4aIEC.register,
            WindContPType4bIEC.register,
            WindContPitchAngleIEC.register,
            WindContQIEC.register,
            WindContQLimIEC.register,
            WindContQPQULimIEC.register,
            WindContRotorRIEC.register,
            WindDynamicsLookupTable.register,
            WindGenTurbineType1aIEC.register,
            WindGenTurbineType1bIEC.register,
            WindGenTurbineType2IEC.register,
            WindGenType3IEC.register,
            WindGenType3aIEC.register,
            WindGenType3bIEC.register,
            WindGenType4IEC.register,
            WindMechIEC.register,
            WindPitchContPowerIEC.register,
            WindPlantDynamics.register,
            WindPlantFreqPcontrolIEC.register,
            WindPlantIEC.register,
            WindPlantReactiveControlIEC.register,
            WindProtectionIEC.register,
            WindRefFrameRotIEC.register,
            WindTurbineType1or2Dynamics.register,
            WindTurbineType1or2IEC.register,
            WindTurbineType3IEC.register,
            WindTurbineType3or4Dynamics.register,
            WindTurbineType3or4IEC.register,
            WindTurbineType4IEC.register,
            WindTurbineType4aIEC.register,
            WindTurbineType4bIEC.register
        )
    }
}