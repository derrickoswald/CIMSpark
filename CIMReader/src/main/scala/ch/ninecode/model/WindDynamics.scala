package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Constant aerodynamic torque model which assumes that the aerodynamic torque is constant.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.1.1.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param WindGenTurbineType1aIEC [[ch.ninecode.model.WindGenTurbineType1aIEC WindGenTurbineType1aIEC]] Wind turbine type 1A model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindAeroConstIEC
(
    override val sup: IdentifiedObject = null,
    WindGenTurbineType1aIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindAeroConstIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindAeroConstIEC.fields (position), value)
        emitattr (0, WindGenTurbineType1aIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindAeroConstIEC rdf:ID=\"%s\">\n%s\t</cim:WindAeroConstIEC>".format (id, export_fields)
    }
}

object WindAeroConstIEC
extends
    Parseable[WindAeroConstIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindGenTurbineType1aIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindGenTurbineType1aIEC", "WindGenTurbineType1aIEC", "1", "1")
    )
    val WindGenTurbineType1aIEC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WindAeroConstIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindAeroConstIEC (
            IdentifiedObject.parse (context),
            mask (WindGenTurbineType1aIEC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * One-dimensional aerodynamic model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.1.2.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ka Aerodynamic gain (<i>k</i><i><sub>a</sub></i>).
 *        It is a type-dependent parameter.
 * @param thetaomega Initial pitch angle (<i>theta</i><i><sub>omega0</sub></i>).
 *        It is a case-dependent parameter.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindAeroOneDimIEC
(
    override val sup: IdentifiedObject = null,
    ka: Double = 0.0,
    thetaomega: Double = 0.0,
    WindTurbineType3IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindAeroOneDimIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindAeroOneDimIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindAeroOneDimIEC.fields (position), value)
        emitelem (0, ka)
        emitelem (1, thetaomega)
        emitattr (2, WindTurbineType3IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindAeroOneDimIEC rdf:ID=\"%s\">\n%s\t</cim:WindAeroOneDimIEC>".format (id, export_fields)
    }
}

object WindAeroOneDimIEC
extends
    Parseable[WindAeroOneDimIEC]
{
    override val fields: Array[String] = Array[String] (
        "ka",
        "thetaomega",
        "WindTurbineType3IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "1", "0..1")
    )
    val ka: Fielder = parse_element (element (cls, fields(0)))
    val thetaomega: Fielder = parse_element (element (cls, fields(1)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WindAeroOneDimIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindAeroOneDimIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (ka (), 0)),
            toDouble (mask (thetaomega (), 1)),
            mask (WindTurbineType3IEC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Two-dimensional aerodynamic model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.1.3.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dpomega Partial derivative of aerodynamic power with respect to changes in WTR speed (<i>dp</i><i><sub>omega</sub></i>).
 *        It is a type-dependent parameter.
 * @param dptheta Partial derivative of aerodynamic power with respect to changes in pitch angle (<i>dp</i><i><sub>theta</sub></i>).
 *        It is a type-dependent parameter.
 * @param dpv1 Partial derivative (<i>dp</i><i><sub>v1</sub></i>).
 *        It is a type-dependent parameter.
 * @param omegazero Rotor speed if the wind turbine is not derated (<i>omega</i><i><sub>0</sub></i>).
 *        It is a type-dependent parameter.
 * @param pavail Available aerodynamic power (<i>p</i><i><sub>avail</sub></i><i>)</i>.
 *        It is a case-dependent parameter.
 * @param thetav2 Blade angle at twice rated wind speed (<i>theta</i><i><sub>v2</sub></i>).
 *        It is a type-dependent parameter.
 * @param thetazero Pitch angle if the wind turbine is not derated (<i>theta</i><i><sub>0</sub></i>).
 *        It is a case-dependent parameter.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this wind aerodynamic model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindAeroTwoDimIEC
(
    override val sup: IdentifiedObject = null,
    dpomega: Double = 0.0,
    dptheta: Double = 0.0,
    dpv1: Double = 0.0,
    omegazero: Double = 0.0,
    pavail: Double = 0.0,
    thetav2: Double = 0.0,
    thetazero: Double = 0.0,
    WindTurbineType3IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindAeroTwoDimIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindAeroTwoDimIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindAeroTwoDimIEC.fields (position), value)
        emitelem (0, dpomega)
        emitelem (1, dptheta)
        emitelem (2, dpv1)
        emitelem (3, omegazero)
        emitelem (4, pavail)
        emitelem (5, thetav2)
        emitelem (6, thetazero)
        emitattr (7, WindTurbineType3IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindAeroTwoDimIEC rdf:ID=\"%s\">\n%s\t</cim:WindAeroTwoDimIEC>".format (id, export_fields)
    }
}

object WindAeroTwoDimIEC
extends
    Parseable[WindAeroTwoDimIEC]
{
    override val fields: Array[String] = Array[String] (
        "dpomega",
        "dptheta",
        "dpv1",
        "omegazero",
        "pavail",
        "thetav2",
        "thetazero",
        "WindTurbineType3IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "1", "0..1")
    )
    val dpomega: Fielder = parse_element (element (cls, fields(0)))
    val dptheta: Fielder = parse_element (element (cls, fields(1)))
    val dpv1: Fielder = parse_element (element (cls, fields(2)))
    val omegazero: Fielder = parse_element (element (cls, fields(3)))
    val pavail: Fielder = parse_element (element (cls, fields(4)))
    val thetav2: Fielder = parse_element (element (cls, fields(5)))
    val thetazero: Fielder = parse_element (element (cls, fields(6)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): WindAeroTwoDimIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindAeroTwoDimIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dpomega (), 0)),
            toDouble (mask (dptheta (), 1)),
            toDouble (mask (dpv1 (), 2)),
            toDouble (mask (omegazero (), 3)),
            toDouble (mask (pavail (), 4)),
            toDouble (mask (thetav2 (), 5)),
            toDouble (mask (thetazero (), 6)),
            mask (WindTurbineType3IEC (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Current limitation model.
 *
 * The current limitation model combines the physical limits and the control limits.
 * Reference: IEC 61400-27-1:2015, 5.6.5.8.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param imax Maximum continuous current at the wind turbine terminals (<i>i</i><i><sub>max</sub></i>).
 *        It is a type-dependent parameter.
 * @param imaxdip Maximum current during voltage dip at the wind turbine terminals (<i>i</i><i><sub>maxdip</sub></i>).
 *        It is a project-dependent parameter.
 * @param kpqu Partial derivative of reactive current limit (<i>K</i><i><sub>pqu</sub></i>) versus voltage.
 *        It is a type-dependent parameter.
 * @param mdfslim Limitation of type 3 stator current (<i>M</i><i><sub>DFSLim</sub></i>). <i>M</i><i><sub>DFSLim</sub></i><sub> </sub>= 1 for wind turbines type 4.
 *        It is a type-dependent parameter.
 *        false= total current limitation (0 in the IEC model)
 *        true=stator current limitation (1 in the IEC model).
 * @param mqpri Prioritisation of Q control during UVRT (<i>M</i><i><sub>qpri</sub></i>).
 *        It is a project-dependent parameter.
 *        true = reactive power priority (1 in the IEC model)
 *        false = active power priority (0 in the IEC model).
 * @param tufiltcl Voltage measurement filter time constant (<i>T</i><i><sub>ufiltcl</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param upqumax Wind turbine voltage in the operation point where zero reactive current can be delivered (<i>u</i><i><sub>pqumax</sub></i>).
 *        It is a type-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this current control limitation model.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind turbine type 3 or type 4 model with which this wind control current limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContCurrLimIEC
(
    override val sup: IdentifiedObject = null,
    imax: Double = 0.0,
    imaxdip: Double = 0.0,
    kpqu: Double = 0.0,
    mdfslim: Boolean = false,
    mqpri: Boolean = false,
    tufiltcl: Double = 0.0,
    upqumax: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContCurrLimIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContCurrLimIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContCurrLimIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindContCurrLimIEC.fields (position), x))
        emitelem (0, imax)
        emitelem (1, imaxdip)
        emitelem (2, kpqu)
        emitelem (3, mdfslim)
        emitelem (4, mqpri)
        emitelem (5, tufiltcl)
        emitelem (6, upqumax)
        emitattrs (7, WindDynamicsLookupTable)
        emitattr (8, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContCurrLimIEC rdf:ID=\"%s\">\n%s\t</cim:WindContCurrLimIEC>".format (id, export_fields)
    }
}

object WindContCurrLimIEC
extends
    Parseable[WindContCurrLimIEC]
{
    override val fields: Array[String] = Array[String] (
        "imax",
        "imaxdip",
        "kpqu",
        "mdfslim",
        "mqpri",
        "tufiltcl",
        "upqumax",
        "WindDynamicsLookupTable",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "1", "1")
    )
    val imax: Fielder = parse_element (element (cls, fields(0)))
    val imaxdip: Fielder = parse_element (element (cls, fields(1)))
    val kpqu: Fielder = parse_element (element (cls, fields(2)))
    val mdfslim: Fielder = parse_element (element (cls, fields(3)))
    val mqpri: Fielder = parse_element (element (cls, fields(4)))
    val tufiltcl: Fielder = parse_element (element (cls, fields(5)))
    val upqumax: Fielder = parse_element (element (cls, fields(6)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: Context): WindContCurrLimIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContCurrLimIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (imax (), 0)),
            toDouble (mask (imaxdip (), 1)),
            toDouble (mask (kpqu (), 2)),
            toBoolean (mask (mdfslim (), 3)),
            toBoolean (mask (mqpri (), 4)),
            toDouble (mask (tufiltcl (), 5)),
            toDouble (mask (upqumax (), 6)),
            masks (WindDynamicsLookupTable (), 7),
            mask (WindTurbineType3or4IEC (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * P control model type 3.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.4.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dpmax Maximum wind turbine power ramp rate (<i>dp</i><i><sub>max</sub></i>).
 *        It is a type-dependent parameter.
 * @param dprefmax Maximum ramp rate of wind turbine reference power (<i>dp</i><i><sub>refmax</sub></i>).
 *        It is a project-dependent parameter.
 * @param dprefmin Minimum ramp rate of wind turbine reference power (<i>dp</i><i><sub>refmin</sub></i>).
 *        It is a project-dependent parameter.
 * @param dthetamax Ramp limitation of torque, required in some grid codes (<i>dt</i><i><sub>max</sub></i>).
 *        It is a project-dependent parameter.
 * @param dthetamaxuvrt Limitation of torque rise rate during UVRT (<i>dtheta</i><i><sub>maxUVRT</sub></i>).
 *        It is a project-dependent parameter.
 * @param kdtd Gain for active drive train damping (<i>K</i><i><sub>DTD</sub></i>).
 *        It is a type-dependent parameter.
 * @param kip PI controller integration parameter (<i>K</i><sub>Ip</sub>).
 *        It is a type-dependent parameter.
 * @param kpp PI controller proportional gain (<i>K</i><sub>Pp</sub>).
 *        It is a type-dependent parameter.
 * @param mpuvrt Enable UVRT power control mode (<i>M</i><i><sub>pUVRT</sub></i><sub>)</sub>.
 *        It is a project-dependent parameter.
 *        true = voltage control (1 in the IEC model)
 *        false = reactive power control (0 in the IEC model).
 * @param omegadtd Active drive train damping frequency (<i>omega</i><i><sub>DTD</sub></i>).
 *        It can be calculated from two mass model parameters. It is a type-dependent parameter.
 * @param omegaoffset Offset to reference value that limits controller action during rotor speed changes (<i>omega</i><i><sub>offset</sub></i>).
 *        It is a case-dependent parameter.
 * @param pdtdmax Maximum active drive train damping power (<i>p</i><sub>DTDmax</sub>).
 *        It is a type-dependent parameter.
 * @param tdvs Time<sub> </sub>delay after deep voltage sags (<i>T</i><i><sub>DVS</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param thetaemin Minimum electrical generator torque (<i>t</i><sub>emin</sub>).
 *        It is a type-dependent parameter.
 * @param thetauscale Voltage scaling factor of reset-torque (<i>t</i><sub>uscale</sub>).
 *        It is a project-dependent parameter.
 * @param tomegafiltp3 Filter time constant for generator speed measurement (<i>T</i><sub>omegafiltp3</sub>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tomegaref Time constant in speed reference filter (<i>T</i><sub>omega,ref</sub>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tpfiltp3 Filter time constant for power measurement (<i>T</i><sub>pfiltp3</sub>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tpord Time constant in power order lag (<i>T</i><sub>pord</sub>).
 *        It is a type-dependent parameter.
 * @param tufiltp3 Filter time constant for voltage measurement (<i>T</i><sub>ufiltp3</sub>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param udvs Voltage limit for hold UVRT status after deep voltage sags (<i>u</i><i><sub>DVS</sub></i>).
 *        It is a project-dependent parameter.
 * @param updip Voltage dip threshold for P-control (<i>u</i><sub>Pdip</sub>).
 *        Part of turbine control, often different (e.g 0.8) from converter thresholds. It is a project-dependent parameter.
 * @param zeta Coefficient for active drive train damping (<i>zeta</i>).
 *        It is a type-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this P control type 3 model.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this wind control P type 3 model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContPType3IEC
(
    override val sup: IdentifiedObject = null,
    dpmax: Double = 0.0,
    dprefmax: Double = 0.0,
    dprefmin: Double = 0.0,
    dthetamax: Double = 0.0,
    dthetamaxuvrt: Double = 0.0,
    kdtd: Double = 0.0,
    kip: Double = 0.0,
    kpp: Double = 0.0,
    mpuvrt: Boolean = false,
    omegadtd: Double = 0.0,
    omegaoffset: Double = 0.0,
    pdtdmax: Double = 0.0,
    tdvs: Double = 0.0,
    thetaemin: Double = 0.0,
    thetauscale: Double = 0.0,
    tomegafiltp3: Double = 0.0,
    tomegaref: Double = 0.0,
    tpfiltp3: Double = 0.0,
    tpord: Double = 0.0,
    tufiltp3: Double = 0.0,
    udvs: Double = 0.0,
    updip: Double = 0.0,
    zeta: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindTurbineType3IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContPType3IEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContPType3IEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContPType3IEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindContPType3IEC.fields (position), x))
        emitelem (0, dpmax)
        emitelem (1, dprefmax)
        emitelem (2, dprefmin)
        emitelem (3, dthetamax)
        emitelem (4, dthetamaxuvrt)
        emitelem (5, kdtd)
        emitelem (6, kip)
        emitelem (7, kpp)
        emitelem (8, mpuvrt)
        emitelem (9, omegadtd)
        emitelem (10, omegaoffset)
        emitelem (11, pdtdmax)
        emitelem (12, tdvs)
        emitelem (13, thetaemin)
        emitelem (14, thetauscale)
        emitelem (15, tomegafiltp3)
        emitelem (16, tomegaref)
        emitelem (17, tpfiltp3)
        emitelem (18, tpord)
        emitelem (19, tufiltp3)
        emitelem (20, udvs)
        emitelem (21, updip)
        emitelem (22, zeta)
        emitattrs (23, WindDynamicsLookupTable)
        emitattr (24, WindTurbineType3IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContPType3IEC rdf:ID=\"%s\">\n%s\t</cim:WindContPType3IEC>".format (id, export_fields)
    }
}

object WindContPType3IEC
extends
    Parseable[WindContPType3IEC]
{
    override val fields: Array[String] = Array[String] (
        "dpmax",
        "dprefmax",
        "dprefmin",
        "dthetamax",
        "dthetamaxuvrt",
        "kdtd",
        "kip",
        "kpp",
        "mpuvrt",
        "omegadtd",
        "omegaoffset",
        "pdtdmax",
        "tdvs",
        "thetaemin",
        "thetauscale",
        "tomegafiltp3",
        "tomegaref",
        "tpfiltp3",
        "tpord",
        "tufiltp3",
        "udvs",
        "updip",
        "zeta",
        "WindDynamicsLookupTable",
        "WindTurbineType3IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "1", "1")
    )
    val dpmax: Fielder = parse_element (element (cls, fields(0)))
    val dprefmax: Fielder = parse_element (element (cls, fields(1)))
    val dprefmin: Fielder = parse_element (element (cls, fields(2)))
    val dthetamax: Fielder = parse_element (element (cls, fields(3)))
    val dthetamaxuvrt: Fielder = parse_element (element (cls, fields(4)))
    val kdtd: Fielder = parse_element (element (cls, fields(5)))
    val kip: Fielder = parse_element (element (cls, fields(6)))
    val kpp: Fielder = parse_element (element (cls, fields(7)))
    val mpuvrt: Fielder = parse_element (element (cls, fields(8)))
    val omegadtd: Fielder = parse_element (element (cls, fields(9)))
    val omegaoffset: Fielder = parse_element (element (cls, fields(10)))
    val pdtdmax: Fielder = parse_element (element (cls, fields(11)))
    val tdvs: Fielder = parse_element (element (cls, fields(12)))
    val thetaemin: Fielder = parse_element (element (cls, fields(13)))
    val thetauscale: Fielder = parse_element (element (cls, fields(14)))
    val tomegafiltp3: Fielder = parse_element (element (cls, fields(15)))
    val tomegaref: Fielder = parse_element (element (cls, fields(16)))
    val tpfiltp3: Fielder = parse_element (element (cls, fields(17)))
    val tpord: Fielder = parse_element (element (cls, fields(18)))
    val tufiltp3: Fielder = parse_element (element (cls, fields(19)))
    val udvs: Fielder = parse_element (element (cls, fields(20)))
    val updip: Fielder = parse_element (element (cls, fields(21)))
    val zeta: Fielder = parse_element (element (cls, fields(22)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(24)))

    def parse (context: Context): WindContPType3IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContPType3IEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dpmax (), 0)),
            toDouble (mask (dprefmax (), 1)),
            toDouble (mask (dprefmin (), 2)),
            toDouble (mask (dthetamax (), 3)),
            toDouble (mask (dthetamaxuvrt (), 4)),
            toDouble (mask (kdtd (), 5)),
            toDouble (mask (kip (), 6)),
            toDouble (mask (kpp (), 7)),
            toBoolean (mask (mpuvrt (), 8)),
            toDouble (mask (omegadtd (), 9)),
            toDouble (mask (omegaoffset (), 10)),
            toDouble (mask (pdtdmax (), 11)),
            toDouble (mask (tdvs (), 12)),
            toDouble (mask (thetaemin (), 13)),
            toDouble (mask (thetauscale (), 14)),
            toDouble (mask (tomegafiltp3 (), 15)),
            toDouble (mask (tomegaref (), 16)),
            toDouble (mask (tpfiltp3 (), 17)),
            toDouble (mask (tpord (), 18)),
            toDouble (mask (tufiltp3 (), 19)),
            toDouble (mask (udvs (), 20)),
            toDouble (mask (updip (), 21)),
            toDouble (mask (zeta (), 22)),
            masks (WindDynamicsLookupTable (), 23),
            mask (WindTurbineType3IEC (), 24)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * P control model type 4A.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.5.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dpmaxp4a Maximum wind turbine power ramp rate (<i>dp</i><i><sub>maxp4A</sub></i>).
 *        It is a project-dependent parameter.
 * @param tpordp4a Time constant in power order lag (<i>T</i><i><sub>pordp4A</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tufiltp4a Voltage measurement filter time constant (<i>T</i><i><sub>ufiltp4A</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindTurbineType4aIEC [[ch.ninecode.model.WindTurbineType4aIEC WindTurbineType4aIEC]] Wind turbine type 4A model with which this wind control P type 4A model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContPType4aIEC
(
    override val sup: IdentifiedObject = null,
    dpmaxp4a: Double = 0.0,
    tpordp4a: Double = 0.0,
    tufiltp4a: Double = 0.0,
    WindTurbineType4aIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContPType4aIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContPType4aIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContPType4aIEC.fields (position), value)
        emitelem (0, dpmaxp4a)
        emitelem (1, tpordp4a)
        emitelem (2, tufiltp4a)
        emitattr (3, WindTurbineType4aIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContPType4aIEC rdf:ID=\"%s\">\n%s\t</cim:WindContPType4aIEC>".format (id, export_fields)
    }
}

object WindContPType4aIEC
extends
    Parseable[WindContPType4aIEC]
{
    override val fields: Array[String] = Array[String] (
        "dpmaxp4a",
        "tpordp4a",
        "tufiltp4a",
        "WindTurbineType4aIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType4aIEC", "WindTurbineType4aIEC", "1", "1")
    )
    val dpmaxp4a: Fielder = parse_element (element (cls, fields(0)))
    val tpordp4a: Fielder = parse_element (element (cls, fields(1)))
    val tufiltp4a: Fielder = parse_element (element (cls, fields(2)))
    val WindTurbineType4aIEC: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): WindContPType4aIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContPType4aIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dpmaxp4a (), 0)),
            toDouble (mask (tpordp4a (), 1)),
            toDouble (mask (tufiltp4a (), 2)),
            mask (WindTurbineType4aIEC (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * P control model type 4B.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.6.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dpmaxp4b Maximum wind turbine power ramp rate (<i>dp</i><i><sub>maxp4B</sub></i>).
 *        It is a project-dependent parameter.
 * @param tpaero Time constant in aerodynamic power response (<i>T</i><i><sub>paero</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tpordp4b Time constant in power order lag (<i>T</i><i><sub>pordp4B</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tufiltp4b Voltage measurement filter time constant (<i>T</i><i><sub>ufiltp4B</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindTurbineType4bIEC [[ch.ninecode.model.WindTurbineType4bIEC WindTurbineType4bIEC]] Wind turbine type 4B model with which this wind control P type 4B model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContPType4bIEC
(
    override val sup: IdentifiedObject = null,
    dpmaxp4b: Double = 0.0,
    tpaero: Double = 0.0,
    tpordp4b: Double = 0.0,
    tufiltp4b: Double = 0.0,
    WindTurbineType4bIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContPType4bIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContPType4bIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContPType4bIEC.fields (position), value)
        emitelem (0, dpmaxp4b)
        emitelem (1, tpaero)
        emitelem (2, tpordp4b)
        emitelem (3, tufiltp4b)
        emitattr (4, WindTurbineType4bIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContPType4bIEC rdf:ID=\"%s\">\n%s\t</cim:WindContPType4bIEC>".format (id, export_fields)
    }
}

object WindContPType4bIEC
extends
    Parseable[WindContPType4bIEC]
{
    override val fields: Array[String] = Array[String] (
        "dpmaxp4b",
        "tpaero",
        "tpordp4b",
        "tufiltp4b",
        "WindTurbineType4bIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType4bIEC", "WindTurbineType4bIEC", "1", "1")
    )
    val dpmaxp4b: Fielder = parse_element (element (cls, fields(0)))
    val tpaero: Fielder = parse_element (element (cls, fields(1)))
    val tpordp4b: Fielder = parse_element (element (cls, fields(2)))
    val tufiltp4b: Fielder = parse_element (element (cls, fields(3)))
    val WindTurbineType4bIEC: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): WindContPType4bIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContPType4bIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dpmaxp4b (), 0)),
            toDouble (mask (tpaero (), 1)),
            toDouble (mask (tpordp4b (), 2)),
            toDouble (mask (tufiltp4b (), 3)),
            mask (WindTurbineType4bIEC (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Pitch angle control model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.2.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dthetamax Maximum pitch positive ramp rate (<i>dtheta</i><i><sub>max</sub></i>) (&gt; WindContPitchAngleIEC.dthetamin).
 *        It is a type-dependent parameter. Unit = degrees / s.
 * @param dthetamin Maximum pitch negative ramp rate (<i>dtheta</i><i><sub>min</sub></i><i>)</i> (&lt; WindContPitchAngleIEC.dthetamax).
 *        It is a type-dependent parameter. Unit = degrees / s.
 * @param kic Power PI controller integration gain (<i>K</i><i><sub>Ic</sub></i>).
 *        It is a type-dependent parameter.
 * @param kiomega Speed PI controller integration gain (<i>K</i><i><sub>Iomega</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpc Power PI controller proportional gain (<i>K</i><i><sub>Pc</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpomega Speed PI controller proportional gain (<i>K</i><i><sub>Pomega</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpx Pitch cross coupling gain (<i>K</i><i><sub>PX</sub></i>).
 *        It is a type-dependent parameter.
 * @param thetamax Maximum pitch angle (<i>theta</i><i><sub>max</sub></i>) (&gt; WindContPitchAngleIEC.thetamin).
 *        It is a type-dependent parameter.
 * @param thetamin Minimum pitch angle (<i>theta</i><i><sub>min</sub></i>) (&lt; WindContPitchAngleIEC.thetamax).
 *        It is a type-dependent parameter.
 * @param ttheta Pitch time constant (<i>ttheta</i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this pitch control model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContPitchAngleIEC
(
    override val sup: IdentifiedObject = null,
    dthetamax: Double = 0.0,
    dthetamin: Double = 0.0,
    kic: Double = 0.0,
    kiomega: Double = 0.0,
    kpc: Double = 0.0,
    kpomega: Double = 0.0,
    kpx: Double = 0.0,
    thetamax: Double = 0.0,
    thetamin: Double = 0.0,
    ttheta: Double = 0.0,
    WindTurbineType3IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContPitchAngleIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContPitchAngleIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContPitchAngleIEC.fields (position), value)
        emitelem (0, dthetamax)
        emitelem (1, dthetamin)
        emitelem (2, kic)
        emitelem (3, kiomega)
        emitelem (4, kpc)
        emitelem (5, kpomega)
        emitelem (6, kpx)
        emitelem (7, thetamax)
        emitelem (8, thetamin)
        emitelem (9, ttheta)
        emitattr (10, WindTurbineType3IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContPitchAngleIEC rdf:ID=\"%s\">\n%s\t</cim:WindContPitchAngleIEC>".format (id, export_fields)
    }
}

object WindContPitchAngleIEC
extends
    Parseable[WindContPitchAngleIEC]
{
    override val fields: Array[String] = Array[String] (
        "dthetamax",
        "dthetamin",
        "kic",
        "kiomega",
        "kpc",
        "kpomega",
        "kpx",
        "thetamax",
        "thetamin",
        "ttheta",
        "WindTurbineType3IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "1", "1")
    )
    val dthetamax: Fielder = parse_element (element (cls, fields(0)))
    val dthetamin: Fielder = parse_element (element (cls, fields(1)))
    val kic: Fielder = parse_element (element (cls, fields(2)))
    val kiomega: Fielder = parse_element (element (cls, fields(3)))
    val kpc: Fielder = parse_element (element (cls, fields(4)))
    val kpomega: Fielder = parse_element (element (cls, fields(5)))
    val kpx: Fielder = parse_element (element (cls, fields(6)))
    val thetamax: Fielder = parse_element (element (cls, fields(7)))
    val thetamin: Fielder = parse_element (element (cls, fields(8)))
    val ttheta: Fielder = parse_element (element (cls, fields(9)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): WindContPitchAngleIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContPitchAngleIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dthetamax (), 0)),
            toDouble (mask (dthetamin (), 1)),
            toDouble (mask (kic (), 2)),
            toDouble (mask (kiomega (), 3)),
            toDouble (mask (kpc (), 4)),
            toDouble (mask (kpomega (), 5)),
            toDouble (mask (kpx (), 6)),
            toDouble (mask (thetamax (), 7)),
            toDouble (mask (thetamin (), 8)),
            toDouble (mask (ttheta (), 9)),
            mask (WindTurbineType3IEC (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Q control model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.7.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param iqh1 Maximum reactive current injection during dip (<i>i</i><i><sub>qh1</sub></i>).
 *        It is a type-dependent parameter.
 * @param iqmax Maximum reactive current injection (<i>i</i><i><sub>qmax</sub></i>) (&gt; WindContQIEC.iqmin).
 *        It is a type-dependent parameter.
 * @param iqmin Minimum reactive current injection (<i>i</i><i><sub>qmin</sub></i>) (&lt; WindContQIEC.iqmax).
 *        It is a type-dependent parameter.
 * @param iqpost Post fault reactive current injection (<i>i</i><i><sub>qpost</sub></i>).
 *        It is a project-dependent parameter.
 * @param kiq Reactive power PI controller integration gain (<i>K</i><i><sub>I,q</sub></i>).
 *        It is a type-dependent parameter.
 * @param kiu Voltage PI controller integration gain (<i>K</i><i><sub>I,u</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpq Reactive power PI controller proportional gain (<i>K</i><i><sub>P,q</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpu Voltage PI controller proportional gain (<i>K</i><i><sub>P,u</sub></i>).
 *        It is a type-dependent parameter.
 * @param kqv Voltage scaling factor for UVRT current (<i>K</i><i><sub>qv</sub></i>).
 *        It is a project-dependent parameter.
 * @param rdroop Resistive component of voltage drop impedance (<i>r</i><i><sub>droop</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param tpfiltq Power measurement filter time constant (<i>T</i><i><sub>pfiltq</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tpost Length of time period where post fault reactive power is injected (<i>T</i><i><sub>post</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param tqord Time constant in reactive power order lag (<i>T</i><i><sub>qord</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tufiltq Voltage measurement filter time constant (<i>T</i><i><sub>ufiltq</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param udb1 Voltage deadband lower limit (<i>u</i><i><sub>db1</sub></i>).
 *        It is a type-dependent parameter.
 * @param udb2 Voltage deadband upper limit (<i>u</i><i><sub>db2</sub></i>).
 *        It is a type-dependent parameter.
 * @param umax Maximum voltage in voltage PI controller integral term (<i>u</i><i><sub>max</sub></i>) (&gt; WindContQIEC.umin).
 *        It is a type-dependent parameter.
 * @param umin Minimum voltage in voltage PI controller integral term (<i>u</i><i><sub>min</sub></i>) (&lt; WindContQIEC.umax).
 *        It is a type-dependent parameter.
 * @param uqdip Voltage threshold for UVRT detection in Q control (<i>u</i><i><sub>qdip</sub></i>).
 *        It is a type-dependent parameter.
 * @param uref0 User-defined bias in voltage reference (<i>u</i><i><sub>ref0</sub></i>).
 *        It is a case-dependent parameter.
 * @param windQcontrolModesType Types of general wind turbine Q control modes (<i>M</i><i><sub>qG</sub></i>).
 *        It is a project-dependent parameter.
 * @param windUVRTQcontrolModesType Types of UVRT Q control modes (<i>M</i><i><sub>qUVRT</sub></i>).
 *        It is a project-dependent parameter.
 * @param xdroop Inductive component of voltage drop impedance (<i>x</i><i><sub>droop</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind turbine type 3 or type 4 model with which this reactive control model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContQIEC
(
    override val sup: IdentifiedObject = null,
    iqh1: Double = 0.0,
    iqmax: Double = 0.0,
    iqmin: Double = 0.0,
    iqpost: Double = 0.0,
    kiq: Double = 0.0,
    kiu: Double = 0.0,
    kpq: Double = 0.0,
    kpu: Double = 0.0,
    kqv: Double = 0.0,
    rdroop: Double = 0.0,
    tpfiltq: Double = 0.0,
    tpost: Double = 0.0,
    tqord: Double = 0.0,
    tufiltq: Double = 0.0,
    udb1: Double = 0.0,
    udb2: Double = 0.0,
    umax: Double = 0.0,
    umin: Double = 0.0,
    uqdip: Double = 0.0,
    uref0: Double = 0.0,
    windQcontrolModesType: String = null,
    windUVRTQcontrolModesType: String = null,
    xdroop: Double = 0.0,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContQIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContQIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContQIEC.fields (position), value)
        emitelem (0, iqh1)
        emitelem (1, iqmax)
        emitelem (2, iqmin)
        emitelem (3, iqpost)
        emitelem (4, kiq)
        emitelem (5, kiu)
        emitelem (6, kpq)
        emitelem (7, kpu)
        emitelem (8, kqv)
        emitelem (9, rdroop)
        emitelem (10, tpfiltq)
        emitelem (11, tpost)
        emitelem (12, tqord)
        emitelem (13, tufiltq)
        emitelem (14, udb1)
        emitelem (15, udb2)
        emitelem (16, umax)
        emitelem (17, umin)
        emitelem (18, uqdip)
        emitelem (19, uref0)
        emitattr (20, windQcontrolModesType)
        emitattr (21, windUVRTQcontrolModesType)
        emitelem (22, xdroop)
        emitattr (23, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContQIEC rdf:ID=\"%s\">\n%s\t</cim:WindContQIEC>".format (id, export_fields)
    }
}

object WindContQIEC
extends
    Parseable[WindContQIEC]
{
    override val fields: Array[String] = Array[String] (
        "iqh1",
        "iqmax",
        "iqmin",
        "iqpost",
        "kiq",
        "kiu",
        "kpq",
        "kpu",
        "kqv",
        "rdroop",
        "tpfiltq",
        "tpost",
        "tqord",
        "tufiltq",
        "udb1",
        "udb2",
        "umax",
        "umin",
        "uqdip",
        "uref0",
        "windQcontrolModesType",
        "windUVRTQcontrolModesType",
        "xdroop",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "1", "1")
    )
    val iqh1: Fielder = parse_element (element (cls, fields(0)))
    val iqmax: Fielder = parse_element (element (cls, fields(1)))
    val iqmin: Fielder = parse_element (element (cls, fields(2)))
    val iqpost: Fielder = parse_element (element (cls, fields(3)))
    val kiq: Fielder = parse_element (element (cls, fields(4)))
    val kiu: Fielder = parse_element (element (cls, fields(5)))
    val kpq: Fielder = parse_element (element (cls, fields(6)))
    val kpu: Fielder = parse_element (element (cls, fields(7)))
    val kqv: Fielder = parse_element (element (cls, fields(8)))
    val rdroop: Fielder = parse_element (element (cls, fields(9)))
    val tpfiltq: Fielder = parse_element (element (cls, fields(10)))
    val tpost: Fielder = parse_element (element (cls, fields(11)))
    val tqord: Fielder = parse_element (element (cls, fields(12)))
    val tufiltq: Fielder = parse_element (element (cls, fields(13)))
    val udb1: Fielder = parse_element (element (cls, fields(14)))
    val udb2: Fielder = parse_element (element (cls, fields(15)))
    val umax: Fielder = parse_element (element (cls, fields(16)))
    val umin: Fielder = parse_element (element (cls, fields(17)))
    val uqdip: Fielder = parse_element (element (cls, fields(18)))
    val uref0: Fielder = parse_element (element (cls, fields(19)))
    val windQcontrolModesType: Fielder = parse_attribute (attribute (cls, fields(20)))
    val windUVRTQcontrolModesType: Fielder = parse_attribute (attribute (cls, fields(21)))
    val xdroop: Fielder = parse_element (element (cls, fields(22)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(23)))

    def parse (context: Context): WindContQIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContQIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (iqh1 (), 0)),
            toDouble (mask (iqmax (), 1)),
            toDouble (mask (iqmin (), 2)),
            toDouble (mask (iqpost (), 3)),
            toDouble (mask (kiq (), 4)),
            toDouble (mask (kiu (), 5)),
            toDouble (mask (kpq (), 6)),
            toDouble (mask (kpu (), 7)),
            toDouble (mask (kqv (), 8)),
            toDouble (mask (rdroop (), 9)),
            toDouble (mask (tpfiltq (), 10)),
            toDouble (mask (tpost (), 11)),
            toDouble (mask (tqord (), 12)),
            toDouble (mask (tufiltq (), 13)),
            toDouble (mask (udb1 (), 14)),
            toDouble (mask (udb2 (), 15)),
            toDouble (mask (umax (), 16)),
            toDouble (mask (umin (), 17)),
            toDouble (mask (uqdip (), 18)),
            toDouble (mask (uref0 (), 19)),
            mask (windQcontrolModesType (), 20),
            mask (windUVRTQcontrolModesType (), 21),
            toDouble (mask (xdroop (), 22)),
            mask (WindTurbineType3or4IEC (), 23)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Constant Q limitation model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.9.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param qmax Maximum reactive power (<i>q</i><i><sub>max</sub></i>) (&gt; WindContQLimIEC.qmin).
 *        It is a type-dependent parameter.
 * @param qmin Minimum reactive power (<i>q</i><i><sub>min</sub></i>) (&lt; WindContQLimIEC.qmax).
 *        It is a type-dependent parameter.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind generator type 3 or type 4 model with which this constant Q limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContQLimIEC
(
    override val sup: IdentifiedObject = null,
    qmax: Double = 0.0,
    qmin: Double = 0.0,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContQLimIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContQLimIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContQLimIEC.fields (position), value)
        emitelem (0, qmax)
        emitelem (1, qmin)
        emitattr (2, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContQLimIEC rdf:ID=\"%s\">\n%s\t</cim:WindContQLimIEC>".format (id, export_fields)
    }
}

object WindContQLimIEC
extends
    Parseable[WindContQLimIEC]
{
    override val fields: Array[String] = Array[String] (
        "qmax",
        "qmin",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "0..1", "0..1")
    )
    val qmax: Fielder = parse_element (element (cls, fields(0)))
    val qmin: Fielder = parse_element (element (cls, fields(1)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WindContQLimIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContQLimIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (qmax (), 0)),
            toDouble (mask (qmin (), 1)),
            mask (WindTurbineType3or4IEC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * QP and QU limitation model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.10.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tpfiltql Power measurement filter time constant for Q capacity (<i>T</i><i><sub>pfiltql</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tufiltql Voltage measurement filter time constant for Q capacity (<i>T</i><i><sub>ufiltql</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this QP and QU limitation model.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind generator type 3 or type 4 model with which this QP and QU limitation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContQPQULimIEC
(
    override val sup: IdentifiedObject = null,
    tpfiltql: Double = 0.0,
    tufiltql: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContQPQULimIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContQPQULimIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContQPQULimIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindContQPQULimIEC.fields (position), x))
        emitelem (0, tpfiltql)
        emitelem (1, tufiltql)
        emitattrs (2, WindDynamicsLookupTable)
        emitattr (3, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContQPQULimIEC rdf:ID=\"%s\">\n%s\t</cim:WindContQPQULimIEC>".format (id, export_fields)
    }
}

object WindContQPQULimIEC
extends
    Parseable[WindContQPQULimIEC]
{
    override val fields: Array[String] = Array[String] (
        "tpfiltql",
        "tufiltql",
        "WindDynamicsLookupTable",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "0..1", "0..1")
    )
    val tpfiltql: Fielder = parse_element (element (cls, fields(0)))
    val tufiltql: Fielder = parse_element (element (cls, fields(1)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): WindContQPQULimIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContQPQULimIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (tpfiltql (), 0)),
            toDouble (mask (tufiltql (), 1)),
            masks (WindDynamicsLookupTable (), 2),
            mask (WindTurbineType3or4IEC (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Rotor resistance control model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.3.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kirr Integral gain in rotor resistance PI controller (<i>K</i><i><sub>Irr</sub></i>).
 *        It is a type-dependent parameter.
 * @param komegafilt Filter gain for generator speed measurement (<i>K</i><i><sub>omegafilt</sub></i>).
 *        It is a type-dependent parameter.
 * @param kpfilt Filter gain for power measurement (<i>K</i><i><sub>pfilt</sub></i>).
 *        It is a type-dependent parameter.
 * @param kprr Proportional gain in rotor resistance PI controller (<i>K</i><i><sub>Prr</sub></i>).
 *        It is a type-dependent parameter.
 * @param rmax Maximum rotor resistance (<i>r</i><i><sub>max</sub></i>) (&gt; WindContRotorRIEC.rmin).
 *        It is a type-dependent parameter.
 * @param rmin Minimum rotor resistance (<i>r</i><i><sub>min</sub></i>) (&lt; WindContRotorRIEC.rmax).
 *        It is a type-dependent parameter.
 * @param tomegafiltrr Filter time constant for generator speed measurement (<i>T</i><i><sub>omegafiltrr</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tpfiltrr Filter time constant for power measurement (<i>T</i><i><sub>pfiltrr</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this rotor resistance control model.
 * @param WindGenTurbineType2IEC [[ch.ninecode.model.WindGenTurbineType2IEC WindGenTurbineType2IEC]] Wind turbine type 2 model with whitch this wind control rotor resistance model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindContRotorRIEC
(
    override val sup: IdentifiedObject = null,
    kirr: Double = 0.0,
    komegafilt: Double = 0.0,
    kpfilt: Double = 0.0,
    kprr: Double = 0.0,
    rmax: Double = 0.0,
    rmin: Double = 0.0,
    tomegafiltrr: Double = 0.0,
    tpfiltrr: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindGenTurbineType2IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindContRotorRIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindContRotorRIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindContRotorRIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindContRotorRIEC.fields (position), x))
        emitelem (0, kirr)
        emitelem (1, komegafilt)
        emitelem (2, kpfilt)
        emitelem (3, kprr)
        emitelem (4, rmax)
        emitelem (5, rmin)
        emitelem (6, tomegafiltrr)
        emitelem (7, tpfiltrr)
        emitattrs (8, WindDynamicsLookupTable)
        emitattr (9, WindGenTurbineType2IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindContRotorRIEC rdf:ID=\"%s\">\n%s\t</cim:WindContRotorRIEC>".format (id, export_fields)
    }
}

object WindContRotorRIEC
extends
    Parseable[WindContRotorRIEC]
{
    override val fields: Array[String] = Array[String] (
        "kirr",
        "komegafilt",
        "kpfilt",
        "kprr",
        "rmax",
        "rmin",
        "tomegafiltrr",
        "tpfiltrr",
        "WindDynamicsLookupTable",
        "WindGenTurbineType2IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindGenTurbineType2IEC", "WindGenTurbineType2IEC", "1", "1")
    )
    val kirr: Fielder = parse_element (element (cls, fields(0)))
    val komegafilt: Fielder = parse_element (element (cls, fields(1)))
    val kpfilt: Fielder = parse_element (element (cls, fields(2)))
    val kprr: Fielder = parse_element (element (cls, fields(3)))
    val rmax: Fielder = parse_element (element (cls, fields(4)))
    val rmin: Fielder = parse_element (element (cls, fields(5)))
    val tomegafiltrr: Fielder = parse_element (element (cls, fields(6)))
    val tpfiltrr: Fielder = parse_element (element (cls, fields(7)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val WindGenTurbineType2IEC: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): WindContRotorRIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindContRotorRIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (kirr (), 0)),
            toDouble (mask (komegafilt (), 1)),
            toDouble (mask (kpfilt (), 2)),
            toDouble (mask (kprr (), 3)),
            toDouble (mask (rmax (), 4)),
            toDouble (mask (rmin (), 5)),
            toDouble (mask (tomegafiltrr (), 6)),
            toDouble (mask (tpfiltrr (), 7)),
            masks (WindDynamicsLookupTable (), 8),
            mask (WindGenTurbineType2IEC (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Look up table for the purpose of wind standard models.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param input Input value (<i>x</i>) for the lookup table function.
 * @param lookupTableFunctionType Type of the lookup table function.
 * @param output Output value (<i>y</i>) for the lookup table function.
 * @param sequence Sequence numbers of the pairs of the input (<i>x</i>) and the output (<i>y</i>) of the lookup table function.
 * @param WindContCurrLimIEC [[ch.ninecode.model.WindContCurrLimIEC WindContCurrLimIEC]] The current control limitation model with which this wind dynamics lookup table is associated.
 * @param WindContPType3IEC [[ch.ninecode.model.WindContPType3IEC WindContPType3IEC]] The P control type 3 model with which this wind dynamics lookup table is associated.
 * @param WindContQPQULimIEC [[ch.ninecode.model.WindContQPQULimIEC WindContQPQULimIEC]] The QP and QU limitation model with which this wind dynamics lookup table is associated.
 * @param WindContRotorRIEC [[ch.ninecode.model.WindContRotorRIEC WindContRotorRIEC]] The rotor resistance control model with which this wind dynamics lookup table is associated.
 * @param WindGenType3bIEC [[ch.ninecode.model.WindGenType3bIEC WindGenType3bIEC]] The generator type 3B model with which this wind dynamics lookup table is associated.
 * @param WindPitchContPowerIEC [[ch.ninecode.model.WindPitchContPowerIEC WindPitchContPowerIEC]] The pitch control power model with which this wind dynamics lookup table is associated.
 * @param WindPlantFreqPcontrolIEC [[ch.ninecode.model.WindPlantFreqPcontrolIEC WindPlantFreqPcontrolIEC]] The frequency and active power wind plant control model with which this wind dynamics lookup table is associated.
 * @param WindPlantReactiveControlIEC [[ch.ninecode.model.WindPlantReactiveControlIEC WindPlantReactiveControlIEC]] The voltage and reactive power wind plant control model with which this wind dynamics lookup table is associated.
 * @param WindProtectionIEC [[ch.ninecode.model.WindProtectionIEC WindProtectionIEC]] The grid protection model with which this wind dynamics lookup table is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindDynamicsLookupTable
(
    override val sup: IdentifiedObject = null,
    input: Double = 0.0,
    lookupTableFunctionType: String = null,
    output: Double = 0.0,
    sequence: Int = 0,
    WindContCurrLimIEC: String = null,
    WindContPType3IEC: String = null,
    WindContQPQULimIEC: String = null,
    WindContRotorRIEC: String = null,
    WindGenType3bIEC: String = null,
    WindPitchContPowerIEC: String = null,
    WindPlantFreqPcontrolIEC: String = null,
    WindPlantReactiveControlIEC: String = null,
    WindProtectionIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindDynamicsLookupTable.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindDynamicsLookupTable.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindDynamicsLookupTable.fields (position), value)
        emitelem (0, input)
        emitattr (1, lookupTableFunctionType)
        emitelem (2, output)
        emitelem (3, sequence)
        emitattr (4, WindContCurrLimIEC)
        emitattr (5, WindContPType3IEC)
        emitattr (6, WindContQPQULimIEC)
        emitattr (7, WindContRotorRIEC)
        emitattr (8, WindGenType3bIEC)
        emitattr (9, WindPitchContPowerIEC)
        emitattr (10, WindPlantFreqPcontrolIEC)
        emitattr (11, WindPlantReactiveControlIEC)
        emitattr (12, WindProtectionIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindDynamicsLookupTable rdf:ID=\"%s\">\n%s\t</cim:WindDynamicsLookupTable>".format (id, export_fields)
    }
}

object WindDynamicsLookupTable
extends
    Parseable[WindDynamicsLookupTable]
{
    override val fields: Array[String] = Array[String] (
        "input",
        "lookupTableFunctionType",
        "output",
        "sequence",
        "WindContCurrLimIEC",
        "WindContPType3IEC",
        "WindContQPQULimIEC",
        "WindContRotorRIEC",
        "WindGenType3bIEC",
        "WindPitchContPowerIEC",
        "WindPlantFreqPcontrolIEC",
        "WindPlantReactiveControlIEC",
        "WindProtectionIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindContCurrLimIEC", "WindContCurrLimIEC", "0..1", "1..*"),
        Relationship ("WindContPType3IEC", "WindContPType3IEC", "0..1", "1..*"),
        Relationship ("WindContQPQULimIEC", "WindContQPQULimIEC", "0..1", "1..*"),
        Relationship ("WindContRotorRIEC", "WindContRotorRIEC", "0..1", "1..*"),
        Relationship ("WindGenType3bIEC", "WindGenType3bIEC", "0..1", "1..*"),
        Relationship ("WindPitchContPowerIEC", "WindPitchContPowerIEC", "0..1", "1..*"),
        Relationship ("WindPlantFreqPcontrolIEC", "WindPlantFreqPcontrolIEC", "0..1", "1..*"),
        Relationship ("WindPlantReactiveControlIEC", "WindPlantReactiveControlIEC", "0..1", "1..*"),
        Relationship ("WindProtectionIEC", "WindProtectionIEC", "0..1", "1..*")
    )
    val input: Fielder = parse_element (element (cls, fields(0)))
    val lookupTableFunctionType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val output: Fielder = parse_element (element (cls, fields(2)))
    val sequence: Fielder = parse_element (element (cls, fields(3)))
    val WindContCurrLimIEC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WindContPType3IEC: Fielder = parse_attribute (attribute (cls, fields(5)))
    val WindContQPQULimIEC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val WindContRotorRIEC: Fielder = parse_attribute (attribute (cls, fields(7)))
    val WindGenType3bIEC: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WindPitchContPowerIEC: Fielder = parse_attribute (attribute (cls, fields(9)))
    val WindPlantFreqPcontrolIEC: Fielder = parse_attribute (attribute (cls, fields(10)))
    val WindPlantReactiveControlIEC: Fielder = parse_attribute (attribute (cls, fields(11)))
    val WindProtectionIEC: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): WindDynamicsLookupTable =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindDynamicsLookupTable (
            IdentifiedObject.parse (context),
            toDouble (mask (input (), 0)),
            mask (lookupTableFunctionType (), 1),
            toDouble (mask (output (), 2)),
            toInteger (mask (sequence (), 3)),
            mask (WindContCurrLimIEC (), 4),
            mask (WindContPType3IEC (), 5),
            mask (WindContQPQULimIEC (), 6),
            mask (WindContRotorRIEC (), 7),
            mask (WindGenType3bIEC (), 8),
            mask (WindPitchContPowerIEC (), 9),
            mask (WindPlantFreqPcontrolIEC (), 10),
            mask (WindPlantReactiveControlIEC (), 11),
            mask (WindProtectionIEC (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind turbine IEC type 1A.
 *
 * Reference: IEC 61400-27-1:2015, 5.5.2.2.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType1or2IEC WindTurbineType1or2IEC]] Reference to the superclass object.
 * @param WindAeroConstIEC [[ch.ninecode.model.WindAeroConstIEC WindAeroConstIEC]] Wind aerodynamic model associated with this wind turbine type 1A model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenTurbineType1aIEC
(
    override val sup: WindTurbineType1or2IEC = null,
    WindAeroConstIEC: String = null
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
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup
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
        implicit val clz: String = WindGenTurbineType1aIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenTurbineType1aIEC.fields (position), value)
        emitattr (0, WindAeroConstIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType1aIEC rdf:ID=\"%s\">\n%s\t</cim:WindGenTurbineType1aIEC>".format (id, export_fields)
    }
}

object WindGenTurbineType1aIEC
extends
    Parseable[WindGenTurbineType1aIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindAeroConstIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindAeroConstIEC", "WindAeroConstIEC", "1", "1")
    )
    val WindAeroConstIEC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WindGenTurbineType1aIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenTurbineType1aIEC (
            WindTurbineType1or2IEC.parse (context),
            mask (WindAeroConstIEC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind turbine IEC type 1B.
 *
 * Reference: IEC 61400-27-1:2015, 5.5.2.3.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType1or2IEC WindTurbineType1or2IEC]] Reference to the superclass object.
 * @param WindPitchContPowerIEC [[ch.ninecode.model.WindPitchContPowerIEC WindPitchContPowerIEC]] Pitch control power model associated with this wind turbine type 1B model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenTurbineType1bIEC
(
    override val sup: WindTurbineType1or2IEC = null,
    WindPitchContPowerIEC: String = null
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
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup
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
        implicit val clz: String = WindGenTurbineType1bIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenTurbineType1bIEC.fields (position), value)
        emitattr (0, WindPitchContPowerIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType1bIEC rdf:ID=\"%s\">\n%s\t</cim:WindGenTurbineType1bIEC>".format (id, export_fields)
    }
}

object WindGenTurbineType1bIEC
extends
    Parseable[WindGenTurbineType1bIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindPitchContPowerIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindPitchContPowerIEC", "WindPitchContPowerIEC", "1", "0..1")
    )
    val WindPitchContPowerIEC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WindGenTurbineType1bIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenTurbineType1bIEC (
            WindTurbineType1or2IEC.parse (context),
            mask (WindPitchContPowerIEC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind turbine IEC type 2.
 *
 * Reference: IEC 61400-27-1:2015, 5.5.3.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType1or2IEC WindTurbineType1or2IEC]] Reference to the superclass object.
 * @param WindContRotorRIEC [[ch.ninecode.model.WindContRotorRIEC WindContRotorRIEC]] Wind control rotor resistance model associated with wind turbine type 2 model.
 * @param WindPitchContPowerIEC [[ch.ninecode.model.WindPitchContPowerIEC WindPitchContPowerIEC]] Pitch control power model associated with this wind turbine type 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenTurbineType2IEC
(
    override val sup: WindTurbineType1or2IEC = null,
    WindContRotorRIEC: String = null,
    WindPitchContPowerIEC: String = null
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
    def WindTurbineType1or2IEC: WindTurbineType1or2IEC = sup
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
        implicit val clz: String = WindGenTurbineType2IEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenTurbineType2IEC.fields (position), value)
        emitattr (0, WindContRotorRIEC)
        emitattr (1, WindPitchContPowerIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenTurbineType2IEC rdf:ID=\"%s\">\n%s\t</cim:WindGenTurbineType2IEC>".format (id, export_fields)
    }
}

object WindGenTurbineType2IEC
extends
    Parseable[WindGenTurbineType2IEC]
{
    override val fields: Array[String] = Array[String] (
        "WindContRotorRIEC",
        "WindPitchContPowerIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindContRotorRIEC", "WindContRotorRIEC", "1", "1"),
        Relationship ("WindPitchContPowerIEC", "WindPitchContPowerIEC", "1", "0..1")
    )
    val WindContRotorRIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindPitchContPowerIEC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WindGenTurbineType2IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenTurbineType2IEC (
            WindTurbineType1or2IEC.parse (context),
            mask (WindContRotorRIEC (), 0),
            mask (WindPitchContPowerIEC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines type 3 generator models of IEC type 3A and 3B.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dipmax Maximum active current ramp rate (<i>di</i><i><sub>pmax</sub></i>).
 *        It is a project-dependent parameter.
 * @param diqmax Maximum reactive current ramp rate (<i>di</i><i><sub>qmax</sub></i>).
 *        It is a project-dependent parameter.
 * @param xs Electromagnetic transient reactance (<i>x</i><i><sub>S</sub></i>).
 *        It is a type-dependent parameter.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this wind generator type 3 is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenType3IEC
(
    override val sup: IdentifiedObject = null,
    dipmax: Double = 0.0,
    diqmax: Double = 0.0,
    xs: Double = 0.0,
    WindTurbineType3IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindGenType3IEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindGenType3IEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenType3IEC.fields (position), value)
        emitelem (0, dipmax)
        emitelem (1, diqmax)
        emitelem (2, xs)
        emitattr (3, WindTurbineType3IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenType3IEC rdf:ID=\"%s\">\n%s\t</cim:WindGenType3IEC>".format (id, export_fields)
    }
}

object WindGenType3IEC
extends
    Parseable[WindGenType3IEC]
{
    override val fields: Array[String] = Array[String] (
        "dipmax",
        "diqmax",
        "xs",
        "WindTurbineType3IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "0..1", "0..1")
    )
    val dipmax: Fielder = parse_element (element (cls, fields(0)))
    val diqmax: Fielder = parse_element (element (cls, fields(1)))
    val xs: Fielder = parse_element (element (cls, fields(2)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): WindGenType3IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenType3IEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dipmax (), 0)),
            toDouble (mask (diqmax (), 1)),
            toDouble (mask (xs (), 2)),
            mask (WindTurbineType3IEC (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEC type 3A generator set model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.3.2.
 *
 * @param sup [[ch.ninecode.model.WindGenType3IEC WindGenType3IEC]] Reference to the superclass object.
 * @param kpc Current PI controller proportional gain (<i>K</i><i><sub>Pc</sub></i>).
 *        It is a type-dependent parameter.
 * @param tic Current PI controller integration time constant (<i>T</i><i><sub>Ic</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindTurbineType4IEC [[ch.ninecode.model.WindTurbineType4IEC WindTurbineType4IEC]] Wind turbine type 4 model with which this wind generator type 3A model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenType3aIEC
(
    override val sup: WindGenType3IEC = null,
    kpc: Double = 0.0,
    tic: Double = 0.0,
    WindTurbineType4IEC: String = null
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
    def WindGenType3IEC: WindGenType3IEC = sup
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
        implicit val clz: String = WindGenType3aIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindGenType3aIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenType3aIEC.fields (position), value)
        emitelem (0, kpc)
        emitelem (1, tic)
        emitattr (2, WindTurbineType4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenType3aIEC rdf:ID=\"%s\">\n%s\t</cim:WindGenType3aIEC>".format (id, export_fields)
    }
}

object WindGenType3aIEC
extends
    Parseable[WindGenType3aIEC]
{
    override val fields: Array[String] = Array[String] (
        "kpc",
        "tic",
        "WindTurbineType4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType4IEC", "WindTurbineType4IEC", "0..1", "0..1")
    )
    val kpc: Fielder = parse_element (element (cls, fields(0)))
    val tic: Fielder = parse_element (element (cls, fields(1)))
    val WindTurbineType4IEC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WindGenType3aIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenType3aIEC (
            WindGenType3IEC.parse (context),
            toDouble (mask (kpc (), 0)),
            toDouble (mask (tic (), 1)),
            mask (WindTurbineType4IEC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEC type 3B generator set model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.3.3.
 *
 * @param sup [[ch.ninecode.model.WindGenType3IEC WindGenType3IEC]] Reference to the superclass object.
 * @param mwtcwp Crowbar control mode (<i>M</i><i><sub>WTcwp</sub></i>).
 *        It is a case-dependent parameter.
 *        true = 1 in the IEC model
 *        false = 0 in the IEC model.
 * @param tg Current generation time constant (<i>T</i><i><sub>g</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param two Time constant for crowbar washout filter (<i>T</i><i><sub>wo</sub></i>) (&gt;= 0).
 *        It is a case-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this generator type 3B model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenType3bIEC
(
    override val sup: WindGenType3IEC = null,
    mwtcwp: Boolean = false,
    tg: Double = 0.0,
    two: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null
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
    def WindGenType3IEC: WindGenType3IEC = sup
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
        implicit val clz: String = WindGenType3bIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindGenType3bIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindGenType3bIEC.fields (position), x))
        emitelem (0, mwtcwp)
        emitelem (1, tg)
        emitelem (2, two)
        emitattrs (3, WindDynamicsLookupTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenType3bIEC rdf:ID=\"%s\">\n%s\t</cim:WindGenType3bIEC>".format (id, export_fields)
    }
}

object WindGenType3bIEC
extends
    Parseable[WindGenType3bIEC]
{
    override val fields: Array[String] = Array[String] (
        "mwtcwp",
        "tg",
        "two",
        "WindDynamicsLookupTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1")
    )
    val mwtcwp: Fielder = parse_element (element (cls, fields(0)))
    val tg: Fielder = parse_element (element (cls, fields(1)))
    val two: Fielder = parse_element (element (cls, fields(2)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): WindGenType3bIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenType3bIEC (
            WindGenType3IEC.parse (context),
            toBoolean (mask (mwtcwp (), 0)),
            toDouble (mask (tg (), 1)),
            toDouble (mask (two (), 2)),
            masks (WindDynamicsLookupTable (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * IEC type 4 generator set model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.3.4.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dipmax Maximum active current ramp rate (<i>di</i><i><sub>pmax</sub></i>).
 *        It is a project-dependent parameter.
 * @param diqmax Maximum reactive current ramp rate (<i>di</i><i><sub>qmax</sub></i>).
 *        It is a project-dependent parameter.
 * @param diqmin Minimum reactive current ramp rate (<i>di</i><i><sub>qmin</sub></i>).
 *        It is a project-dependent parameter.
 * @param tg Time constant (<i>T</i><i><sub>g</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param WindTurbineType4aIEC [[ch.ninecode.model.WindTurbineType4aIEC WindTurbineType4aIEC]] Wind turbine type 4A model with which this wind generator type 4 model is associated.
 * @param WindTurbineType4bIEC [[ch.ninecode.model.WindTurbineType4bIEC WindTurbineType4bIEC]] Wind turbine type 4B model with which this wind generator type 4 model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindGenType4IEC
(
    override val sup: IdentifiedObject = null,
    dipmax: Double = 0.0,
    diqmax: Double = 0.0,
    diqmin: Double = 0.0,
    tg: Double = 0.0,
    WindTurbineType4aIEC: String = null,
    WindTurbineType4bIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindGenType4IEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindGenType4IEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindGenType4IEC.fields (position), value)
        emitelem (0, dipmax)
        emitelem (1, diqmax)
        emitelem (2, diqmin)
        emitelem (3, tg)
        emitattr (4, WindTurbineType4aIEC)
        emitattr (5, WindTurbineType4bIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindGenType4IEC rdf:ID=\"%s\">\n%s\t</cim:WindGenType4IEC>".format (id, export_fields)
    }
}

object WindGenType4IEC
extends
    Parseable[WindGenType4IEC]
{
    override val fields: Array[String] = Array[String] (
        "dipmax",
        "diqmax",
        "diqmin",
        "tg",
        "WindTurbineType4aIEC",
        "WindTurbineType4bIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType4aIEC", "WindTurbineType4aIEC", "0..1", "0..1"),
        Relationship ("WindTurbineType4bIEC", "WindTurbineType4bIEC", "0..1", "0..1")
    )
    val dipmax: Fielder = parse_element (element (cls, fields(0)))
    val diqmax: Fielder = parse_element (element (cls, fields(1)))
    val diqmin: Fielder = parse_element (element (cls, fields(2)))
    val tg: Fielder = parse_element (element (cls, fields(3)))
    val WindTurbineType4aIEC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WindTurbineType4bIEC: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): WindGenType4IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindGenType4IEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dipmax (), 0)),
            toDouble (mask (diqmax (), 1)),
            toDouble (mask (diqmin (), 2)),
            toDouble (mask (tg (), 3)),
            mask (WindTurbineType4aIEC (), 4),
            mask (WindTurbineType4bIEC (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Two mass model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.2.1.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param cdrt Drive train damping (<i>c</i><i><sub>drt</sub></i><i>)</i>.
 *        It is a type-dependent parameter.
 * @param hgen Inertia constant of generator (<i>H</i><i><sub>gen</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param hwtr Inertia constant of wind turbine rotor (<i>H</i><i><sub>WTR</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param kdrt Drive train stiffness (<i>k</i><i><sub>drt</sub></i>).
 *        It is a type-dependent parameter.
 * @param WindTurbineType1or2IEC [[ch.ninecode.model.WindTurbineType1or2IEC WindTurbineType1or2IEC]] Wind generator type 1 or type 2 model with which this wind mechanical model is associated.
 * @param WindTurbineType3IEC [[ch.ninecode.model.WindTurbineType3IEC WindTurbineType3IEC]] Wind turbine type 3 model with which this wind mechanical model is associated.
 * @param WindTurbineType4bIEC [[ch.ninecode.model.WindTurbineType4bIEC WindTurbineType4bIEC]] Wind turbine type 4B model with which this wind mechanical model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindMechIEC
(
    override val sup: IdentifiedObject = null,
    cdrt: Double = 0.0,
    hgen: Double = 0.0,
    hwtr: Double = 0.0,
    kdrt: Double = 0.0,
    WindTurbineType1or2IEC: String = null,
    WindTurbineType3IEC: String = null,
    WindTurbineType4bIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindMechIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindMechIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindMechIEC.fields (position), value)
        emitelem (0, cdrt)
        emitelem (1, hgen)
        emitelem (2, hwtr)
        emitelem (3, kdrt)
        emitattr (4, WindTurbineType1or2IEC)
        emitattr (5, WindTurbineType3IEC)
        emitattr (6, WindTurbineType4bIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindMechIEC rdf:ID=\"%s\">\n%s\t</cim:WindMechIEC>".format (id, export_fields)
    }
}

object WindMechIEC
extends
    Parseable[WindMechIEC]
{
    override val fields: Array[String] = Array[String] (
        "cdrt",
        "hgen",
        "hwtr",
        "kdrt",
        "WindTurbineType1or2IEC",
        "WindTurbineType3IEC",
        "WindTurbineType4bIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType1or2IEC", "WindTurbineType1or2IEC", "0..1", "1"),
        Relationship ("WindTurbineType3IEC", "WindTurbineType3IEC", "0..1", "1"),
        Relationship ("WindTurbineType4bIEC", "WindTurbineType4bIEC", "0..1", "1")
    )
    val cdrt: Fielder = parse_element (element (cls, fields(0)))
    val hgen: Fielder = parse_element (element (cls, fields(1)))
    val hwtr: Fielder = parse_element (element (cls, fields(2)))
    val kdrt: Fielder = parse_element (element (cls, fields(3)))
    val WindTurbineType1or2IEC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WindTurbineType3IEC: Fielder = parse_attribute (attribute (cls, fields(5)))
    val WindTurbineType4bIEC: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): WindMechIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindMechIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (cdrt (), 0)),
            toDouble (mask (hgen (), 1)),
            toDouble (mask (hwtr (), 2)),
            toDouble (mask (kdrt (), 3)),
            mask (WindTurbineType1or2IEC (), 4),
            mask (WindTurbineType3IEC (), 5),
            mask (WindTurbineType4bIEC (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Pitch control power model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.5.1.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dpmax Rate limit for increasing power (<i>dp</i><i><sub>max</sub></i>) (&gt; WindPitchContPowerIEC.dpmin).
 *        It is a type-dependent parameter.
 * @param dpmin Rate limit for decreasing power (<i>dp</i><i><sub>min</sub></i>) (&lt; WindPitchContPowerIEC.dpmax).
 *        It is a type-dependent parameter.
 * @param pmin Minimum power setting (<i>p</i><i><sub>min</sub></i>).
 *        It is a type-dependent parameter.
 * @param pset If <i>p</i><i><sub>init</sub></i><sub> </sub>&lt; <i>p</i><i><sub>set</sub></i><sub> </sub>then power will be ramped down to <i>p</i><i><sub>min</sub></i>.
 *        It is (<i>p</i><i><sub>set</sub></i>) in the IEC 61400-27-1:2015. It is a type-dependent parameter.
 * @param t1 Lag time constant (<i>T</i><i><sub>1</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param tr Voltage measurement time constant (<i>T</i><i><sub>r</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param uuvrt Dip detection threshold (<i>u</i><i><sub>UVRT</sub></i>).
 *        It is a type-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this pitch control power model.
 * @param WindGenTurbineType1bIEC [[ch.ninecode.model.WindGenTurbineType1bIEC WindGenTurbineType1bIEC]] Wind turbine type 1B model with which this pitch control power model is associated.
 * @param WindGenTurbineType2IEC [[ch.ninecode.model.WindGenTurbineType2IEC WindGenTurbineType2IEC]] Wind turbine type 2 model with which this pitch control power model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindPitchContPowerIEC
(
    override val sup: IdentifiedObject = null,
    dpmax: Double = 0.0,
    dpmin: Double = 0.0,
    pmin: Double = 0.0,
    pset: Double = 0.0,
    t1: Double = 0.0,
    tr: Double = 0.0,
    uuvrt: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindGenTurbineType1bIEC: String = null,
    WindGenTurbineType2IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindPitchContPowerIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindPitchContPowerIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindPitchContPowerIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindPitchContPowerIEC.fields (position), x))
        emitelem (0, dpmax)
        emitelem (1, dpmin)
        emitelem (2, pmin)
        emitelem (3, pset)
        emitelem (4, t1)
        emitelem (5, tr)
        emitelem (6, uuvrt)
        emitattrs (7, WindDynamicsLookupTable)
        emitattr (8, WindGenTurbineType1bIEC)
        emitattr (9, WindGenTurbineType2IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPitchContPowerIEC rdf:ID=\"%s\">\n%s\t</cim:WindPitchContPowerIEC>".format (id, export_fields)
    }
}

object WindPitchContPowerIEC
extends
    Parseable[WindPitchContPowerIEC]
{
    override val fields: Array[String] = Array[String] (
        "dpmax",
        "dpmin",
        "pmin",
        "pset",
        "t1",
        "tr",
        "uuvrt",
        "WindDynamicsLookupTable",
        "WindGenTurbineType1bIEC",
        "WindGenTurbineType2IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindGenTurbineType1bIEC", "WindGenTurbineType1bIEC", "0..1", "1"),
        Relationship ("WindGenTurbineType2IEC", "WindGenTurbineType2IEC", "0..1", "1")
    )
    val dpmax: Fielder = parse_element (element (cls, fields(0)))
    val dpmin: Fielder = parse_element (element (cls, fields(1)))
    val pmin: Fielder = parse_element (element (cls, fields(2)))
    val pset: Fielder = parse_element (element (cls, fields(3)))
    val t1: Fielder = parse_element (element (cls, fields(4)))
    val tr: Fielder = parse_element (element (cls, fields(5)))
    val uuvrt: Fielder = parse_element (element (cls, fields(6)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WindGenTurbineType1bIEC: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WindGenTurbineType2IEC: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): WindPitchContPowerIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPitchContPowerIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dpmax (), 0)),
            toDouble (mask (dpmin (), 1)),
            toDouble (mask (pmin (), 2)),
            toDouble (mask (pset (), 3)),
            toDouble (mask (t1 (), 4)),
            toDouble (mask (tr (), 5)),
            toDouble (mask (uuvrt (), 6)),
            masks (WindDynamicsLookupTable (), 7),
            mask (WindGenTurbineType1bIEC (), 8),
            mask (WindGenTurbineType2IEC (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to wind turbines type 3 and type 4 and wind plant IEC and user-defined wind plants including their control models.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] The remote signal with which this power plant is associated.
 * @param WindTurbineType3or4Dynamics [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] The wind turbine type 3 or type 4 associated with this wind plant.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindPlantDynamics
(
    override val sup: DynamicsFunctionBlock = null,
    RemoteInputSignal: String = null,
    WindTurbineType3or4Dynamics: List[String] = null
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup
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
        implicit val clz: String = WindPlantDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindPlantDynamics.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindPlantDynamics.fields (position), x))
        emitattr (0, RemoteInputSignal)
        emitattrs (1, WindTurbineType3or4Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPlantDynamics rdf:ID=\"%s\">\n%s\t</cim:WindPlantDynamics>".format (id, export_fields)
    }
}

object WindPlantDynamics
extends
    Parseable[WindPlantDynamics]
{
    override val fields: Array[String] = Array[String] (
        "RemoteInputSignal",
        "WindTurbineType3or4Dynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1"),
        Relationship ("WindTurbineType3or4Dynamics", "WindTurbineType3or4Dynamics", "1..*", "0..1")
    )
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindTurbineType3or4Dynamics: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): WindPlantDynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPlantDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (RemoteInputSignal (), 0),
            masks (WindTurbineType3or4Dynamics (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Frequency and active power controller model.
 *
 * Reference: IEC 61400-27-1:2015, Annex D.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dprefmax Maximum ramp rate of <i>p</i><i><sub>WTref</sub></i> request from the plant controller to the wind turbines (<i>dp</i><i><sub>refmax</sub></i>) (&gt; WindPlantFreqPcontrolIEC.dprefmin).
 *        It is a case-dependent parameter.
 * @param dprefmin Minimum (negative) ramp rate of <i>p</i><i><sub>WTref</sub></i> request from the plant controller to the wind turbines (<i>dp</i><i><sub>refmin</sub></i>) (&lt; WindPlantFreqPcontrolIEC.dprefmax).
 *        It is a project-dependent parameter.
 * @param dpwprefmax Maximum positive ramp rate for wind plant power reference (<i>dp</i><i><sub>WPrefmax</sub></i>) (&gt; WindPlantFreqPcontrolIEC.dpwprefmin).
 *        It is a project-dependent parameter.
 * @param dpwprefmin Maximum negative ramp rate for wind plant power reference (<i>dp</i><i><sub>WPrefmin</sub></i>) (&lt; WindPlantFreqPcontrolIEC.dpwprefmax).
 *        It is a project-dependent parameter.
 * @param kiwpp Plant P controller integral gain (<i>K</i><i><sub>IWPp</sub></i>).
 *        It is a project-dependent parameter.
 * @param kiwppmax Maximum PI integrator term (<i>K</i><i><sub>IWPpmax</sub></i>) (&gt; WindPlantFreqPcontrolIEC.kiwppmin).
 *        It is a project-dependent parameter.
 * @param kiwppmin Minimum PI integrator term (<i>K</i><i><sub>IWPpmin</sub></i>) (&lt; WindPlantFreqPcontrolIEC.kiwppmax).
 *        It is a project-dependent parameter.
 * @param kpwpp Plant P controller proportional gain (<i>K</i><i><sub>PWPp</sub></i>).
 *        It is a project-dependent parameter.
 * @param kwppref Power reference gain (<i>K</i><i><sub>WPpref</sub></i>).
 *        It is a project-dependent parameter.
 * @param prefmax Maximum <i>p</i><i><sub>WTref</sub></i> request from the plant controller to the wind turbines (<i>p</i><i><sub>refmax</sub></i>) (&gt; WindPlantFreqPcontrolIEC.prefmin).
 *        It is a project-dependent parameter.
 * @param prefmin Minimum <i>p</i><i><sub>WTref</sub></i> request from the plant controller to the wind turbines (<i>p</i><i><sub>refmin</sub></i>) (&lt; WindPlantFreqPcontrolIEC.prefmax).
 *        It is a project-dependent parameter.
 * @param tpft Lead time constant in reference value transfer function (<i>T</i><i><sub>pft</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param tpfv Lag time constant in reference value transfer function (<i>T</i><i><sub>pfv</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param twpffiltp Filter time constant for frequency measurement (<i>T</i><i><sub>WPffiltp</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param twppfiltp Filter time constant for active power measurement (<i>T</i><i><sub>WPpfiltp</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this frequency and active power wind plant model.
 * @param WindPlantIEC [[ch.ninecode.model.WindPlantIEC WindPlantIEC]] Wind plant model with which this wind plant frequency and active power control is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindPlantFreqPcontrolIEC
(
    override val sup: IdentifiedObject = null,
    dprefmax: Double = 0.0,
    dprefmin: Double = 0.0,
    dpwprefmax: Double = 0.0,
    dpwprefmin: Double = 0.0,
    kiwpp: Double = 0.0,
    kiwppmax: Double = 0.0,
    kiwppmin: Double = 0.0,
    kpwpp: Double = 0.0,
    kwppref: Double = 0.0,
    prefmax: Double = 0.0,
    prefmin: Double = 0.0,
    tpft: Double = 0.0,
    tpfv: Double = 0.0,
    twpffiltp: Double = 0.0,
    twppfiltp: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindPlantIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindPlantFreqPcontrolIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindPlantFreqPcontrolIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindPlantFreqPcontrolIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindPlantFreqPcontrolIEC.fields (position), x))
        emitelem (0, dprefmax)
        emitelem (1, dprefmin)
        emitelem (2, dpwprefmax)
        emitelem (3, dpwprefmin)
        emitelem (4, kiwpp)
        emitelem (5, kiwppmax)
        emitelem (6, kiwppmin)
        emitelem (7, kpwpp)
        emitelem (8, kwppref)
        emitelem (9, prefmax)
        emitelem (10, prefmin)
        emitelem (11, tpft)
        emitelem (12, tpfv)
        emitelem (13, twpffiltp)
        emitelem (14, twppfiltp)
        emitattrs (15, WindDynamicsLookupTable)
        emitattr (16, WindPlantIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPlantFreqPcontrolIEC rdf:ID=\"%s\">\n%s\t</cim:WindPlantFreqPcontrolIEC>".format (id, export_fields)
    }
}

object WindPlantFreqPcontrolIEC
extends
    Parseable[WindPlantFreqPcontrolIEC]
{
    override val fields: Array[String] = Array[String] (
        "dprefmax",
        "dprefmin",
        "dpwprefmax",
        "dpwprefmin",
        "kiwpp",
        "kiwppmax",
        "kiwppmin",
        "kpwpp",
        "kwppref",
        "prefmax",
        "prefmin",
        "tpft",
        "tpfv",
        "twpffiltp",
        "twppfiltp",
        "WindDynamicsLookupTable",
        "WindPlantIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindPlantIEC", "WindPlantIEC", "1", "1")
    )
    val dprefmax: Fielder = parse_element (element (cls, fields(0)))
    val dprefmin: Fielder = parse_element (element (cls, fields(1)))
    val dpwprefmax: Fielder = parse_element (element (cls, fields(2)))
    val dpwprefmin: Fielder = parse_element (element (cls, fields(3)))
    val kiwpp: Fielder = parse_element (element (cls, fields(4)))
    val kiwppmax: Fielder = parse_element (element (cls, fields(5)))
    val kiwppmin: Fielder = parse_element (element (cls, fields(6)))
    val kpwpp: Fielder = parse_element (element (cls, fields(7)))
    val kwppref: Fielder = parse_element (element (cls, fields(8)))
    val prefmax: Fielder = parse_element (element (cls, fields(9)))
    val prefmin: Fielder = parse_element (element (cls, fields(10)))
    val tpft: Fielder = parse_element (element (cls, fields(11)))
    val tpfv: Fielder = parse_element (element (cls, fields(12)))
    val twpffiltp: Fielder = parse_element (element (cls, fields(13)))
    val twppfiltp: Fielder = parse_element (element (cls, fields(14)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val WindPlantIEC: Fielder = parse_attribute (attribute (cls, fields(16)))

    def parse (context: Context): WindPlantFreqPcontrolIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPlantFreqPcontrolIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dprefmax (), 0)),
            toDouble (mask (dprefmin (), 1)),
            toDouble (mask (dpwprefmax (), 2)),
            toDouble (mask (dpwprefmin (), 3)),
            toDouble (mask (kiwpp (), 4)),
            toDouble (mask (kiwppmax (), 5)),
            toDouble (mask (kiwppmin (), 6)),
            toDouble (mask (kpwpp (), 7)),
            toDouble (mask (kwppref (), 8)),
            toDouble (mask (prefmax (), 9)),
            toDouble (mask (prefmin (), 10)),
            toDouble (mask (tpft (), 11)),
            toDouble (mask (tpfv (), 12)),
            toDouble (mask (twpffiltp (), 13)),
            toDouble (mask (twppfiltp (), 14)),
            masks (WindDynamicsLookupTable (), 15),
            mask (WindPlantIEC (), 16)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified IEC type plant level model.
 *
 * Reference: IEC 61400-27-1:2015, Annex D.
 *
 * @param sup [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] Reference to the superclass object.
 * @param WindPlantFreqPcontrolIEC [[ch.ninecode.model.WindPlantFreqPcontrolIEC WindPlantFreqPcontrolIEC]] Wind plant frequency and active power control model associated with this wind plant.
 * @param WindPlantReactiveControlIEC [[ch.ninecode.model.WindPlantReactiveControlIEC WindPlantReactiveControlIEC]] Wind plant model with which this wind reactive control is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindPlantIEC
(
    override val sup: WindPlantDynamics = null,
    WindPlantFreqPcontrolIEC: String = null,
    WindPlantReactiveControlIEC: String = null
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
    def WindPlantDynamics: WindPlantDynamics = sup
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
        implicit val clz: String = WindPlantIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindPlantIEC.fields (position), value)
        emitattr (0, WindPlantFreqPcontrolIEC)
        emitattr (1, WindPlantReactiveControlIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPlantIEC rdf:ID=\"%s\">\n%s\t</cim:WindPlantIEC>".format (id, export_fields)
    }
}

object WindPlantIEC
extends
    Parseable[WindPlantIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindPlantFreqPcontrolIEC",
        "WindPlantReactiveControlIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindPlantFreqPcontrolIEC", "WindPlantFreqPcontrolIEC", "1", "1"),
        Relationship ("WindPlantReactiveControlIEC", "WindPlantReactiveControlIEC", "1", "1")
    )
    val WindPlantFreqPcontrolIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindPlantReactiveControlIEC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WindPlantIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPlantIEC (
            WindPlantDynamics.parse (context),
            mask (WindPlantFreqPcontrolIEC (), 0),
            mask (WindPlantReactiveControlIEC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Simplified plant voltage and reactive power control model for use with type 3 and type 4 wind turbine models.
 *
 * Reference: IEC 61400-27-1:2015, Annex D.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dxrefmax Maximum positive ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><i><sub>refmax</sub></i>) (&gt; WindPlantReactiveControlIEC.dxrefmin).
 *        It is a project-dependent parameter.
 * @param dxrefmin Maximum negative ramp rate for wind turbine reactive power/voltage reference (<i>dx</i><i><sub>refmin</sub></i>) (&lt; WindPlantReactiveControlIEC.dxrefmax).
 *        It is a project-dependent parameter.
 * @param kiwpx Plant Q controller integral gain (<i>K</i><i><sub>IWPx</sub></i>).
 *        It is a project-dependent parameter.
 * @param kiwpxmax Maximum reactive power/voltage reference from integration (<i>K</i><i><sub>IWPxmax</sub></i>) (&gt; WindPlantReactiveControlIEC.kiwpxmin).
 *        It is a project-dependent parameter.
 * @param kiwpxmin Minimum reactive power/voltage reference from integration (<i>K</i><i><sub>IWPxmin</sub></i>) (&lt; WindPlantReactiveControlIEC.kiwpxmax).
 *        It is a project-dependent parameter.
 * @param kpwpx Plant Q controller proportional gain (<i>K</i><i><sub>PWPx</sub></i>).
 *        It is a project-dependent parameter.
 * @param kwpqref Reactive power reference gain (<i>K</i><i><sub>WPqref</sub></i>).
 *        It is a project-dependent parameter.
 * @param kwpqu Plant voltage control droop (<i>K</i><i><sub>WPqu</sub></i>).
 *        It is a project-dependent parameter.
 * @param tuqfilt Filter time constant for voltage-dependent reactive power (<i>T</i><i><sub>uqfilt</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param twppfiltq Filter time constant for active power measurement (<i>T</i><i><sub>WPpfiltq</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param twpqfiltq Filter time constant for reactive power measurement (<i>T</i><i><sub>WPqfiltq</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param twpufiltq Filter time constant for voltage measurement (<i>T</i><i><sub>WPufiltq</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param txft Lead time constant in reference value transfer function (<i>T</i><i><sub>xft</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param txfv Lag time constant in reference value transfer function (<i>T</i><i><sub>xfv</sub></i>) (&gt;= 0).
 *        It is a project-dependent parameter.
 * @param uwpqdip Voltage threshold for UVRT detection in Q control (<i>u</i><i><sub>WPqdip</sub></i>).
 *        It is a project-dependent parameter.
 * @param windPlantQcontrolModesType Reactive power/voltage controller mode (<i>M</i><i><sub>WPqmode</sub></i>).
 *        It is a case-dependent parameter.
 * @param xrefmax Maximum <i>x</i><sub>WTref</sub> (<i>q</i><i><sub>WTref</sub></i> or delta<i> u</i><i><sub>WTref</sub></i>) request from the plant controller (<i>x</i><i><sub>refmax</sub></i>) (&gt; WindPlantReactiveControlIEC.xrefmin).
 *        It is a case-dependent parameter.
 * @param xrefmin Minimum <i>x</i><i><sub>WTref</sub></i> (<i>q</i><i><sub>WTref</sub></i> or delta <i>u</i><i><sub>WTref</sub></i>) request from the plant controller (<i>x</i><i><sub>refmin</sub></i>) (&lt; WindPlantReactiveControlIEC.xrefmax).
 *        It is a project-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this voltage and reactive power wind plant model.
 * @param WindPlantIEC [[ch.ninecode.model.WindPlantIEC WindPlantIEC]] Wind plant reactive control model associated with this wind plant.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindPlantReactiveControlIEC
(
    override val sup: IdentifiedObject = null,
    dxrefmax: Double = 0.0,
    dxrefmin: Double = 0.0,
    kiwpx: Double = 0.0,
    kiwpxmax: Double = 0.0,
    kiwpxmin: Double = 0.0,
    kpwpx: Double = 0.0,
    kwpqref: Double = 0.0,
    kwpqu: Double = 0.0,
    tuqfilt: Double = 0.0,
    twppfiltq: Double = 0.0,
    twpqfiltq: Double = 0.0,
    twpufiltq: Double = 0.0,
    txft: Double = 0.0,
    txfv: Double = 0.0,
    uwpqdip: Double = 0.0,
    windPlantQcontrolModesType: String = null,
    xrefmax: Double = 0.0,
    xrefmin: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindPlantIEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindPlantReactiveControlIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindPlantReactiveControlIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindPlantReactiveControlIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindPlantReactiveControlIEC.fields (position), x))
        emitelem (0, dxrefmax)
        emitelem (1, dxrefmin)
        emitelem (2, kiwpx)
        emitelem (3, kiwpxmax)
        emitelem (4, kiwpxmin)
        emitelem (5, kpwpx)
        emitelem (6, kwpqref)
        emitelem (7, kwpqu)
        emitelem (8, tuqfilt)
        emitelem (9, twppfiltq)
        emitelem (10, twpqfiltq)
        emitelem (11, twpufiltq)
        emitelem (12, txft)
        emitelem (13, txfv)
        emitelem (14, uwpqdip)
        emitattr (15, windPlantQcontrolModesType)
        emitelem (16, xrefmax)
        emitelem (17, xrefmin)
        emitattrs (18, WindDynamicsLookupTable)
        emitattr (19, WindPlantIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindPlantReactiveControlIEC rdf:ID=\"%s\">\n%s\t</cim:WindPlantReactiveControlIEC>".format (id, export_fields)
    }
}

object WindPlantReactiveControlIEC
extends
    Parseable[WindPlantReactiveControlIEC]
{
    override val fields: Array[String] = Array[String] (
        "dxrefmax",
        "dxrefmin",
        "kiwpx",
        "kiwpxmax",
        "kiwpxmin",
        "kpwpx",
        "kwpqref",
        "kwpqu",
        "tuqfilt",
        "twppfiltq",
        "twpqfiltq",
        "twpufiltq",
        "txft",
        "txfv",
        "uwpqdip",
        "windPlantQcontrolModesType",
        "xrefmax",
        "xrefmin",
        "WindDynamicsLookupTable",
        "WindPlantIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindPlantIEC", "WindPlantIEC", "1", "1")
    )
    val dxrefmax: Fielder = parse_element (element (cls, fields(0)))
    val dxrefmin: Fielder = parse_element (element (cls, fields(1)))
    val kiwpx: Fielder = parse_element (element (cls, fields(2)))
    val kiwpxmax: Fielder = parse_element (element (cls, fields(3)))
    val kiwpxmin: Fielder = parse_element (element (cls, fields(4)))
    val kpwpx: Fielder = parse_element (element (cls, fields(5)))
    val kwpqref: Fielder = parse_element (element (cls, fields(6)))
    val kwpqu: Fielder = parse_element (element (cls, fields(7)))
    val tuqfilt: Fielder = parse_element (element (cls, fields(8)))
    val twppfiltq: Fielder = parse_element (element (cls, fields(9)))
    val twpqfiltq: Fielder = parse_element (element (cls, fields(10)))
    val twpufiltq: Fielder = parse_element (element (cls, fields(11)))
    val txft: Fielder = parse_element (element (cls, fields(12)))
    val txfv: Fielder = parse_element (element (cls, fields(13)))
    val uwpqdip: Fielder = parse_element (element (cls, fields(14)))
    val windPlantQcontrolModesType: Fielder = parse_attribute (attribute (cls, fields(15)))
    val xrefmax: Fielder = parse_element (element (cls, fields(16)))
    val xrefmin: Fielder = parse_element (element (cls, fields(17)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val WindPlantIEC: Fielder = parse_attribute (attribute (cls, fields(19)))

    def parse (context: Context): WindPlantReactiveControlIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindPlantReactiveControlIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dxrefmax (), 0)),
            toDouble (mask (dxrefmin (), 1)),
            toDouble (mask (kiwpx (), 2)),
            toDouble (mask (kiwpxmax (), 3)),
            toDouble (mask (kiwpxmin (), 4)),
            toDouble (mask (kpwpx (), 5)),
            toDouble (mask (kwpqref (), 6)),
            toDouble (mask (kwpqu (), 7)),
            toDouble (mask (tuqfilt (), 8)),
            toDouble (mask (twppfiltq (), 9)),
            toDouble (mask (twpqfiltq (), 10)),
            toDouble (mask (twpufiltq (), 11)),
            toDouble (mask (txft (), 12)),
            toDouble (mask (txfv (), 13)),
            toDouble (mask (uwpqdip (), 14)),
            mask (windPlantQcontrolModesType (), 15),
            toDouble (mask (xrefmax (), 16)),
            toDouble (mask (xrefmin (), 17)),
            masks (WindDynamicsLookupTable (), 18),
            mask (WindPlantIEC (), 19)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The grid protection model includes protection against over- and under-voltage, and against over- and under-frequency.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.6.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param dfimax Maximum rate of change of frequency (<i>dF</i><i><sub>max</sub></i>).
 *        It is a type-dependent parameter.
 * @param fover Wind turbine over frequency protection activation threshold (<i>f</i><i><sub>over</sub></i>).
 *        It is a project-dependent parameter.
 * @param funder Wind turbine under frequency protection activation threshold (<i>f</i><i><sub>under</sub></i>).
 *        It is a project-dependent parameter.
 * @param mzc Zero crossing measurement mode (<i>Mzc</i>).
 *        It is a type-dependent parameter.
 *        true = WT protection system uses zero crossings to detect frequency (1 in the IEC model)
 *        false = WT protection system does not use zero crossings to detect frequency (0 in the IEC model).
 * @param tfma Time interval of moving average window (<i>TfMA</i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param uover Wind turbine over voltage protection activation threshold (<i>u</i><i><sub>over</sub></i>).
 *        It is a project-dependent parameter.
 * @param uunder Wind turbine under voltage protection activation threshold (<i>u</i><i><sub>under</sub></i>).
 *        It is a project-dependent parameter.
 * @param WindDynamicsLookupTable [[ch.ninecode.model.WindDynamicsLookupTable WindDynamicsLookupTable]] The wind dynamics lookup table associated with this grid protection model.
 * @param WindTurbineType1or2IEC [[ch.ninecode.model.WindTurbineType1or2IEC WindTurbineType1or2IEC]] Wind generator type 1 or type 2 model with which this wind turbine protection model is associated.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind generator type 3 or type 4 model with which this wind turbine protection model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindProtectionIEC
(
    override val sup: IdentifiedObject = null,
    dfimax: Double = 0.0,
    fover: Double = 0.0,
    funder: Double = 0.0,
    mzc: Boolean = false,
    tfma: Double = 0.0,
    uover: Double = 0.0,
    uunder: Double = 0.0,
    WindDynamicsLookupTable: List[String] = null,
    WindTurbineType1or2IEC: String = null,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindProtectionIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindProtectionIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindProtectionIEC.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (WindProtectionIEC.fields (position), x))
        emitelem (0, dfimax)
        emitelem (1, fover)
        emitelem (2, funder)
        emitelem (3, mzc)
        emitelem (4, tfma)
        emitelem (5, uover)
        emitelem (6, uunder)
        emitattrs (7, WindDynamicsLookupTable)
        emitattr (8, WindTurbineType1or2IEC)
        emitattr (9, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindProtectionIEC rdf:ID=\"%s\">\n%s\t</cim:WindProtectionIEC>".format (id, export_fields)
    }
}

object WindProtectionIEC
extends
    Parseable[WindProtectionIEC]
{
    override val fields: Array[String] = Array[String] (
        "dfimax",
        "fover",
        "funder",
        "mzc",
        "tfma",
        "uover",
        "uunder",
        "WindDynamicsLookupTable",
        "WindTurbineType1or2IEC",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindDynamicsLookupTable", "WindDynamicsLookupTable", "1..*", "0..1"),
        Relationship ("WindTurbineType1or2IEC", "WindTurbineType1or2IEC", "0..1", "1"),
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "0..1", "1")
    )
    val dfimax: Fielder = parse_element (element (cls, fields(0)))
    val fover: Fielder = parse_element (element (cls, fields(1)))
    val funder: Fielder = parse_element (element (cls, fields(2)))
    val mzc: Fielder = parse_element (element (cls, fields(3)))
    val tfma: Fielder = parse_element (element (cls, fields(4)))
    val uover: Fielder = parse_element (element (cls, fields(5)))
    val uunder: Fielder = parse_element (element (cls, fields(6)))
    val WindDynamicsLookupTable: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WindTurbineType1or2IEC: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): WindProtectionIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindProtectionIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (dfimax (), 0)),
            toDouble (mask (fover (), 1)),
            toDouble (mask (funder (), 2)),
            toBoolean (mask (mzc (), 3)),
            toDouble (mask (tfma (), 4)),
            toDouble (mask (uover (), 5)),
            toDouble (mask (uunder (), 6)),
            masks (WindDynamicsLookupTable (), 7),
            mask (WindTurbineType1or2IEC (), 8),
            mask (WindTurbineType3or4IEC (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Reference frame rotation model.
 *
 * Reference: IEC 61400-27-1:2015, 5.6.3.5.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param tpll Time constant for PLL first order filter model (<i>T</i><i><sub>PLL</sub></i>) (&gt;= 0).
 *        It is a type-dependent parameter.
 * @param upll1 Voltage below which the angle of the voltage is filtered and possibly also frozen (<i>u</i><i><sub>PLL1</sub></i>).
 *        It is a type-dependent parameter.
 * @param upll2 Voltage (<i>u</i><i><sub>PLL2</sub></i>) below which the angle of the voltage is frozen if <i>u</i><i><sub>PLL2</sub></i><sub> </sub>is smaller or equal to <i>u</i><i><sub>PLL1</sub></i> .
 *        It is a type-dependent parameter.
 * @param WindTurbineType3or4IEC [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Wind turbine type 3 or type 4 model with which this reference frame rotation model is associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindRefFrameRotIEC
(
    override val sup: IdentifiedObject = null,
    tpll: Double = 0.0,
    upll1: Double = 0.0,
    upll2: Double = 0.0,
    WindTurbineType3or4IEC: String = null
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
    def IdentifiedObject: IdentifiedObject = sup
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
        implicit val clz: String = WindRefFrameRotIEC.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WindRefFrameRotIEC.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindRefFrameRotIEC.fields (position), value)
        emitelem (0, tpll)
        emitelem (1, upll1)
        emitelem (2, upll2)
        emitattr (3, WindTurbineType3or4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindRefFrameRotIEC rdf:ID=\"%s\">\n%s\t</cim:WindRefFrameRotIEC>".format (id, export_fields)
    }
}

object WindRefFrameRotIEC
extends
    Parseable[WindRefFrameRotIEC]
{
    override val fields: Array[String] = Array[String] (
        "tpll",
        "upll1",
        "upll2",
        "WindTurbineType3or4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindTurbineType3or4IEC", "WindTurbineType3or4IEC", "1", "1")
    )
    val tpll: Fielder = parse_element (element (cls, fields(0)))
    val upll1: Fielder = parse_element (element (cls, fields(1)))
    val upll2: Fielder = parse_element (element (cls, fields(2)))
    val WindTurbineType3or4IEC: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): WindRefFrameRotIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindRefFrameRotIEC (
            IdentifiedObject.parse (context),
            toDouble (mask (tpll (), 0)),
            toDouble (mask (upll1 (), 1)),
            toDouble (mask (upll2 (), 2)),
            mask (WindTurbineType3or4IEC (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to wind turbines type 1 and type 2 and their control models.
 *
 * Generator model for wind turbine of type 1 or type 2 is a standard asynchronous generator model.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param AsynchronousMachineDynamics [[ch.ninecode.model.AsynchronousMachineDynamics AsynchronousMachineDynamics]] Asynchronous machine model with which this wind generator type 1 or type 2 model is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this wind generator type 1 or type 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType1or2Dynamics
(
    override val sup: DynamicsFunctionBlock = null,
    AsynchronousMachineDynamics: String = null,
    RemoteInputSignal: String = null
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup
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
        implicit val clz: String = WindTurbineType1or2Dynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType1or2Dynamics.fields (position), value)
        emitattr (0, AsynchronousMachineDynamics)
        emitattr (1, RemoteInputSignal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType1or2Dynamics rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType1or2Dynamics>".format (id, export_fields)
    }
}

object WindTurbineType1or2Dynamics
extends
    Parseable[WindTurbineType1or2Dynamics]
{
    override val fields: Array[String] = Array[String] (
        "AsynchronousMachineDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AsynchronousMachineDynamics", "AsynchronousMachineDynamics", "1", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val AsynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WindTurbineType1or2Dynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType1or2Dynamics (
            DynamicsFunctionBlock.parse (context),
            mask (AsynchronousMachineDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines type 1 and type 2 including their control models.
 *
 * Generator model for wind turbine of IEC type 1 or type 2 is a standard asynchronous generator model.
 * Reference: IEC 61400-27-1:2015, 5.5.2 and 5.5.3.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType1or2Dynamics WindTurbineType1or2Dynamics]] Reference to the superclass object.
 * @param WindMechIEC [[ch.ninecode.model.WindMechIEC WindMechIEC]] Wind mechanical model associated with this wind generator type 1 or type 2 model.
 * @param WindProtectionIEC [[ch.ninecode.model.WindProtectionIEC WindProtectionIEC]] Wind turbune protection model associated with this wind generator type 1 or type 2 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType1or2IEC
(
    override val sup: WindTurbineType1or2Dynamics = null,
    WindMechIEC: String = null,
    WindProtectionIEC: String = null
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
    def WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = sup
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
        implicit val clz: String = WindTurbineType1or2IEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType1or2IEC.fields (position), value)
        emitattr (0, WindMechIEC)
        emitattr (1, WindProtectionIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType1or2IEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType1or2IEC>".format (id, export_fields)
    }
}

object WindTurbineType1or2IEC
extends
    Parseable[WindTurbineType1or2IEC]
{
    override val fields: Array[String] = Array[String] (
        "WindMechIEC",
        "WindProtectionIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindMechIEC", "WindMechIEC", "1", "0..1"),
        Relationship ("WindProtectionIEC", "WindProtectionIEC", "1", "0..1")
    )
    val WindMechIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindProtectionIEC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WindTurbineType1or2IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType1or2IEC (
            WindTurbineType1or2Dynamics.parse (context),
            mask (WindMechIEC (), 0),
            mask (WindProtectionIEC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines type 3 including their control models.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Reference to the superclass object.
 * @param WindAeroOneDimIEC [[ch.ninecode.model.WindAeroOneDimIEC WindAeroOneDimIEC]] Wind aerodynamic model associated with this wind generator type 3 model.
 * @param WindAeroTwoDimIEC [[ch.ninecode.model.WindAeroTwoDimIEC WindAeroTwoDimIEC]] Wind aerodynamic model associated with this wind turbine type 3 model.
 * @param WindContPType3IEC [[ch.ninecode.model.WindContPType3IEC WindContPType3IEC]] Wind control P type 3 model associated with this wind turbine type 3 model.
 * @param WindContPitchAngleIEC [[ch.ninecode.model.WindContPitchAngleIEC WindContPitchAngleIEC]] Wind control pitch angle model associated with this wind turbine type 3.
 * @param WindGenType3IEC [[ch.ninecode.model.WindGenType3IEC WindGenType3IEC]] Wind generator type 3 model associated with this wind turbine type 3 model.
 * @param WindMechIEC [[ch.ninecode.model.WindMechIEC WindMechIEC]] Wind mechanical model associated with this wind turbine type 3 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType3IEC
(
    override val sup: WindTurbineType3or4IEC = null,
    WindAeroOneDimIEC: String = null,
    WindAeroTwoDimIEC: String = null,
    WindContPType3IEC: String = null,
    WindContPitchAngleIEC: String = null,
    WindGenType3IEC: String = null,
    WindMechIEC: String = null
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
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup
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
        implicit val clz: String = WindTurbineType3IEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType3IEC.fields (position), value)
        emitattr (0, WindAeroOneDimIEC)
        emitattr (1, WindAeroTwoDimIEC)
        emitattr (2, WindContPType3IEC)
        emitattr (3, WindContPitchAngleIEC)
        emitattr (4, WindGenType3IEC)
        emitattr (5, WindMechIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3IEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType3IEC>".format (id, export_fields)
    }
}

object WindTurbineType3IEC
extends
    Parseable[WindTurbineType3IEC]
{
    override val fields: Array[String] = Array[String] (
        "WindAeroOneDimIEC",
        "WindAeroTwoDimIEC",
        "WindContPType3IEC",
        "WindContPitchAngleIEC",
        "WindGenType3IEC",
        "WindMechIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindAeroOneDimIEC", "WindAeroOneDimIEC", "0..1", "1"),
        Relationship ("WindAeroTwoDimIEC", "WindAeroTwoDimIEC", "0..1", "1"),
        Relationship ("WindContPType3IEC", "WindContPType3IEC", "1", "1"),
        Relationship ("WindContPitchAngleIEC", "WindContPitchAngleIEC", "1", "1"),
        Relationship ("WindGenType3IEC", "WindGenType3IEC", "0..1", "0..1"),
        Relationship ("WindMechIEC", "WindMechIEC", "1", "0..1")
    )
    val WindAeroOneDimIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindAeroTwoDimIEC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WindContPType3IEC: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WindContPitchAngleIEC: Fielder = parse_attribute (attribute (cls, fields(3)))
    val WindGenType3IEC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WindMechIEC: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): WindTurbineType3IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType3IEC (
            WindTurbineType3or4IEC.parse (context),
            mask (WindAeroOneDimIEC (), 0),
            mask (WindAeroTwoDimIEC (), 1),
            mask (WindContPType3IEC (), 2),
            mask (WindContPitchAngleIEC (), 3),
            mask (WindGenType3IEC (), 4),
            mask (WindMechIEC (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to wind turbines type 3 and type 4 and wind plant including their control models.
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param PowerElectronicsConnection [[ch.ninecode.model.PowerElectronicsConnection PowerElectronicsConnection]] The power electronics connection associated with this wind turbine type 3 or type 4 dynamics model.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by these wind turbine type 3 or type 4 models.
 * @param WindPlantDynamics [[ch.ninecode.model.WindPlantDynamics WindPlantDynamics]] The wind plant with which the wind turbines type 3 or type 4 are associated.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType3or4Dynamics
(
    override val sup: DynamicsFunctionBlock = null,
    PowerElectronicsConnection: String = null,
    RemoteInputSignal: String = null,
    WindPlantDynamics: String = null
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup
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
        implicit val clz: String = WindTurbineType3or4Dynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType3or4Dynamics.fields (position), value)
        emitattr (0, PowerElectronicsConnection)
        emitattr (1, RemoteInputSignal)
        emitattr (2, WindPlantDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3or4Dynamics rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType3or4Dynamics>".format (id, export_fields)
    }
}

object WindTurbineType3or4Dynamics
extends
    Parseable[WindTurbineType3or4Dynamics]
{
    override val fields: Array[String] = Array[String] (
        "PowerElectronicsConnection",
        "RemoteInputSignal",
        "WindPlantDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PowerElectronicsConnection", "PowerElectronicsConnection", "1", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1"),
        Relationship ("WindPlantDynamics", "WindPlantDynamics", "0..1", "1..*")
    )
    val PowerElectronicsConnection: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WindPlantDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WindTurbineType3or4Dynamics =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType3or4Dynamics (
            DynamicsFunctionBlock.parse (context),
            mask (PowerElectronicsConnection (), 0),
            mask (RemoteInputSignal (), 1),
            mask (WindPlantDynamics (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines type 3 and type 4 including their control models.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType3or4Dynamics WindTurbineType3or4Dynamics]] Reference to the superclass object.
 * @param WIndContQIEC [[ch.ninecode.model.WindContQIEC WindContQIEC]] Wind control Q model associated with this wind turbine type 3 or type 4 model.
 * @param WindContCurrLimIEC [[ch.ninecode.model.WindContCurrLimIEC WindContCurrLimIEC]] Wind control current limitation model associated with this wind turbine type 3 or type 4 model.
 * @param WindContQLimIEC [[ch.ninecode.model.WindContQLimIEC WindContQLimIEC]] Constant Q limitation model associated with this wind generator type 3 or type 4 model.
 * @param WindContQPQULimIEC [[ch.ninecode.model.WindContQPQULimIEC WindContQPQULimIEC]] QP and QU limitation model associated with this wind generator type 3 or type 4 model.
 * @param WindProtectionIEC [[ch.ninecode.model.WindProtectionIEC WindProtectionIEC]] Wind turbune protection model associated with this wind generator type 3 or type 4 model.
 * @param WindRefFrameRotIEC [[ch.ninecode.model.WindRefFrameRotIEC WindRefFrameRotIEC]] Reference frame rotation model associated with this wind turbine type 3 or type 4 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType3or4IEC
(
    override val sup: WindTurbineType3or4Dynamics = null,
    WIndContQIEC: String = null,
    WindContCurrLimIEC: String = null,
    WindContQLimIEC: String = null,
    WindContQPQULimIEC: String = null,
    WindProtectionIEC: String = null,
    WindRefFrameRotIEC: String = null
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
    def WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = sup
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
        implicit val clz: String = WindTurbineType3or4IEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType3or4IEC.fields (position), value)
        emitattr (0, WIndContQIEC)
        emitattr (1, WindContCurrLimIEC)
        emitattr (2, WindContQLimIEC)
        emitattr (3, WindContQPQULimIEC)
        emitattr (4, WindProtectionIEC)
        emitattr (5, WindRefFrameRotIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType3or4IEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType3or4IEC>".format (id, export_fields)
    }
}

object WindTurbineType3or4IEC
extends
    Parseable[WindTurbineType3or4IEC]
{
    override val fields: Array[String] = Array[String] (
        "WIndContQIEC",
        "WindContCurrLimIEC",
        "WindContQLimIEC",
        "WindContQPQULimIEC",
        "WindProtectionIEC",
        "WindRefFrameRotIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WIndContQIEC", "WindContQIEC", "1", "1"),
        Relationship ("WindContCurrLimIEC", "WindContCurrLimIEC", "1", "1"),
        Relationship ("WindContQLimIEC", "WindContQLimIEC", "0..1", "0..1"),
        Relationship ("WindContQPQULimIEC", "WindContQPQULimIEC", "0..1", "0..1"),
        Relationship ("WindProtectionIEC", "WindProtectionIEC", "1", "0..1"),
        Relationship ("WindRefFrameRotIEC", "WindRefFrameRotIEC", "1", "1")
    )
    val WIndContQIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindContCurrLimIEC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WindContQLimIEC: Fielder = parse_attribute (attribute (cls, fields(2)))
    val WindContQPQULimIEC: Fielder = parse_attribute (attribute (cls, fields(3)))
    val WindProtectionIEC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val WindRefFrameRotIEC: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): WindTurbineType3or4IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType3or4IEC (
            WindTurbineType3or4Dynamics.parse (context),
            mask (WIndContQIEC (), 0),
            mask (WindContCurrLimIEC (), 1),
            mask (WindContQLimIEC (), 2),
            mask (WindContQPQULimIEC (), 3),
            mask (WindProtectionIEC (), 4),
            mask (WindRefFrameRotIEC (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Parent class supporting relationships to IEC wind turbines type 4 including their control models.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType3or4IEC WindTurbineType3or4IEC]] Reference to the superclass object.
 * @param WindGenType3aIEC [[ch.ninecode.model.WindGenType3aIEC WindGenType3aIEC]] Wind generator type 3A model associated with this wind turbine type 4 model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType4IEC
(
    override val sup: WindTurbineType3or4IEC = null,
    WindGenType3aIEC: String = null
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
    def WindTurbineType3or4IEC: WindTurbineType3or4IEC = sup
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
        implicit val clz: String = WindTurbineType4IEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType4IEC.fields (position), value)
        emitattr (0, WindGenType3aIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4IEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType4IEC>".format (id, export_fields)
    }
}

object WindTurbineType4IEC
extends
    Parseable[WindTurbineType4IEC]
{
    override val fields: Array[String] = Array[String] (
        "WindGenType3aIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindGenType3aIEC", "WindGenType3aIEC", "0..1", "0..1")
    )
    val WindGenType3aIEC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): WindTurbineType4IEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType4IEC (
            WindTurbineType3or4IEC.parse (context),
            mask (WindGenType3aIEC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind turbine IEC type 4A.
 *
 * Reference: IEC 61400-27-1:2015, 5.5.5.2.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType4IEC WindTurbineType4IEC]] Reference to the superclass object.
 * @param WindContPType4aIEC [[ch.ninecode.model.WindContPType4aIEC WindContPType4aIEC]] Wind control P type 4A model associated with this wind turbine type 4A model.
 * @param WindGenType4IEC [[ch.ninecode.model.WindGenType4IEC WindGenType4IEC]] Wind generator type 4 model associated with this wind turbine type 4A model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType4aIEC
(
    override val sup: WindTurbineType4IEC = null,
    WindContPType4aIEC: String = null,
    WindGenType4IEC: String = null
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
    def WindTurbineType4IEC: WindTurbineType4IEC = sup
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
        implicit val clz: String = WindTurbineType4aIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType4aIEC.fields (position), value)
        emitattr (0, WindContPType4aIEC)
        emitattr (1, WindGenType4IEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4aIEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType4aIEC>".format (id, export_fields)
    }
}

object WindTurbineType4aIEC
extends
    Parseable[WindTurbineType4aIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindContPType4aIEC",
        "WindGenType4IEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindContPType4aIEC", "WindContPType4aIEC", "1", "1"),
        Relationship ("WindGenType4IEC", "WindGenType4IEC", "0..1", "0..1")
    )
    val WindContPType4aIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindGenType4IEC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): WindTurbineType4aIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType4aIEC (
            WindTurbineType4IEC.parse (context),
            mask (WindContPType4aIEC (), 0),
            mask (WindGenType4IEC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Wind turbine IEC type 4B.
 *
 * Reference: IEC 61400-27-1:2015, 5.5.5.3.
 *
 * @param sup [[ch.ninecode.model.WindTurbineType4IEC WindTurbineType4IEC]] Reference to the superclass object.
 * @param WindContPType4bIEC [[ch.ninecode.model.WindContPType4bIEC WindContPType4bIEC]] Wind control P type 4B model associated with this wind turbine type 4B model.
 * @param WindGenType4IEC [[ch.ninecode.model.WindGenType4IEC WindGenType4IEC]] Wind generator type 4 model associated with this wind turbine type 4B model.
 * @param WindMechIEC [[ch.ninecode.model.WindMechIEC WindMechIEC]] Wind mechanical model associated with this wind turbine type 4B model.
 * @group WindDynamics
 * @groupname WindDynamics Package WindDynamics
 * @groupdesc WindDynamics Wind turbines are generally divided into four types, which are currently significant in power systems.  The four types have the following characteristics:
- type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
- type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
- type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
- type 4: wind turbines connected to the grid through a full size power converter.
Models included in this package are according to IEC 61400-27-1:2015.
 */
final case class WindTurbineType4bIEC
(
    override val sup: WindTurbineType4IEC = null,
    WindContPType4bIEC: String = null,
    WindGenType4IEC: String = null,
    WindMechIEC: String = null
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
    def WindTurbineType4IEC: WindTurbineType4IEC = sup
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
        implicit val clz: String = WindTurbineType4bIEC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WindTurbineType4bIEC.fields (position), value)
        emitattr (0, WindContPType4bIEC)
        emitattr (1, WindGenType4IEC)
        emitattr (2, WindMechIEC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WindTurbineType4bIEC rdf:ID=\"%s\">\n%s\t</cim:WindTurbineType4bIEC>".format (id, export_fields)
    }
}

object WindTurbineType4bIEC
extends
    Parseable[WindTurbineType4bIEC]
{
    override val fields: Array[String] = Array[String] (
        "WindContPType4bIEC",
        "WindGenType4IEC",
        "WindMechIEC"
    )
    override val relations: List[Relationship] = List (
        Relationship ("WindContPType4bIEC", "WindContPType4bIEC", "1", "1"),
        Relationship ("WindGenType4IEC", "WindGenType4IEC", "0..1", "0..1"),
        Relationship ("WindMechIEC", "WindMechIEC", "1", "0..1")
    )
    val WindContPType4bIEC: Fielder = parse_attribute (attribute (cls, fields(0)))
    val WindGenType4IEC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val WindMechIEC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): WindTurbineType4bIEC =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WindTurbineType4bIEC (
            WindTurbineType4IEC.parse (context),
            mask (WindContPType4bIEC (), 0),
            mask (WindGenType4IEC (), 1),
            mask (WindMechIEC (), 2)
        )
        ret.bitfields = bitfields
        ret
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