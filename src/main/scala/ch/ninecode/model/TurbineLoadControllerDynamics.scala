package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Turbine Load Controller model developed in the WECC.
 * This model represents a supervisory turbine load controller that acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference. This model is intended to represent slow reset 'outer loop' controllers managing the action of the turbine governor.
 * @param sup Reference to the superclass object.
 * @param db Controller dead band (db).
 *        Typical Value = 0.
 * @param emax Maximum control error (Emax) (note 4).
 *        Typical Value = 0.02.
 * @param fb Frequency bias gain (Fb).
 *        Typical Value = 0.
 * @param fbf Frequency bias flag (Fbf).
 *        true = enable frequency bias
 *        false = disable frequency bias.
 *        Typical Value = false.
 * @param irmax Maximum turbine speed/load reference bias (Irmax) (note 3).
 *        Typical Value = 0.
 * @param ki Integral gain (Ki).
 *        Typical Value = 0.
 * @param kp Proportional gain (Kp).
 *        Typical Value = 0.
 * @param mwbase Base for power values (MWbase) (&gt;0).
 *        Unit = MW.
 * @param pbf Power controller flag (Pbf).
 *        true = enable load controller
 *        false = disable load controller.
 *        Typical Value = false.
 * @param pmwset Power controller setpoint (Pmwset) (note 1).
 *        Unit = MW. Typical Value = 0.
 * @param speedReferenceGovernor Type of turbine governor reference (Type).
 *        true = speed reference governor
 *        false = load reference governor.
 *        Typical Value = true.
 * @param tpelec Power transducer time constant (Tpelec).
 *        Typical Value = 0.
 * @group TurbineLoadControllerDynamics
 * @groupname TurbineLoadControllerDynamics Package TurbineLoadControllerDynamics
 * @groupdesc TurbineLoadControllerDynamics A turbine load controller acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference.
 */
case class TurbLCFB1
(
    override val sup: TurbineLoadControllerDynamics,
    db: Double,
    emax: Double,
    fb: Double,
    fbf: Boolean,
    irmax: Double,
    ki: Double,
    kp: Double,
    mwbase: Double,
    pbf: Boolean,
    pmwset: Double,
    speedReferenceGovernor: Boolean,
    tpelec: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0, 0.0, false, 0.0, false, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = sup.asInstanceOf[TurbineLoadControllerDynamics]
    override def copy (): Row = { clone ().asInstanceOf[TurbLCFB1] }
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
        "\t\t<cim:TurbLCFB1.db>" + db + "</cim:TurbLCFB1.db>\n" +
        "\t\t<cim:TurbLCFB1.emax>" + emax + "</cim:TurbLCFB1.emax>\n" +
        "\t\t<cim:TurbLCFB1.fb>" + fb + "</cim:TurbLCFB1.fb>\n" +
        "\t\t<cim:TurbLCFB1.fbf>" + fbf + "</cim:TurbLCFB1.fbf>\n" +
        "\t\t<cim:TurbLCFB1.irmax>" + irmax + "</cim:TurbLCFB1.irmax>\n" +
        "\t\t<cim:TurbLCFB1.ki>" + ki + "</cim:TurbLCFB1.ki>\n" +
        "\t\t<cim:TurbLCFB1.kp>" + kp + "</cim:TurbLCFB1.kp>\n" +
        "\t\t<cim:TurbLCFB1.mwbase>" + mwbase + "</cim:TurbLCFB1.mwbase>\n" +
        "\t\t<cim:TurbLCFB1.pbf>" + pbf + "</cim:TurbLCFB1.pbf>\n" +
        "\t\t<cim:TurbLCFB1.pmwset>" + pmwset + "</cim:TurbLCFB1.pmwset>\n" +
        "\t\t<cim:TurbLCFB1.speedReferenceGovernor>" + speedReferenceGovernor + "</cim:TurbLCFB1.speedReferenceGovernor>\n" +
        "\t\t<cim:TurbLCFB1.tpelec>" + tpelec + "</cim:TurbLCFB1.tpelec>\n"
    }
    override def export: String =
    {
        "\t<cim:TurbLCFB1 rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TurbLCFB1>"
    }
}

object TurbLCFB1
extends
    Parseable[TurbLCFB1]
{
    val db = parse_element (element ("""TurbLCFB1.db"""))
    val emax = parse_element (element ("""TurbLCFB1.emax"""))
    val fb = parse_element (element ("""TurbLCFB1.fb"""))
    val fbf = parse_element (element ("""TurbLCFB1.fbf"""))
    val irmax = parse_element (element ("""TurbLCFB1.irmax"""))
    val ki = parse_element (element ("""TurbLCFB1.ki"""))
    val kp = parse_element (element ("""TurbLCFB1.kp"""))
    val mwbase = parse_element (element ("""TurbLCFB1.mwbase"""))
    val pbf = parse_element (element ("""TurbLCFB1.pbf"""))
    val pmwset = parse_element (element ("""TurbLCFB1.pmwset"""))
    val speedReferenceGovernor = parse_element (element ("""TurbLCFB1.speedReferenceGovernor"""))
    val tpelec = parse_element (element ("""TurbLCFB1.tpelec"""))
    def parse (context: Context): TurbLCFB1 =
    {
        TurbLCFB1(
            TurbineLoadControllerDynamics.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param TurbineGovernorDynamics Turbine-governor controlled by this turbine load controller.
 * @group TurbineLoadControllerDynamics
 * @groupname TurbineLoadControllerDynamics Package TurbineLoadControllerDynamics
 * @groupdesc TurbineLoadControllerDynamics A turbine load controller acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference.
 */
case class TurbineLoadControllerDynamics
(
    override val sup: DynamicsFunctionBlock,
    TurbineGovernorDynamics: String
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
    override def copy (): Row = { clone ().asInstanceOf[TurbineLoadControllerDynamics] }
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
        (if (null != TurbineGovernorDynamics) "\t\t<cim:TurbineLoadControllerDynamics.TurbineGovernorDynamics rdf:resource=\"#" + TurbineGovernorDynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TurbineLoadControllerDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TurbineLoadControllerDynamics>"
    }
}

object TurbineLoadControllerDynamics
extends
    Parseable[TurbineLoadControllerDynamics]
{
    val TurbineGovernorDynamics = parse_attribute (attribute ("""TurbineLoadControllerDynamics.TurbineGovernorDynamics"""))
    def parse (context: Context): TurbineLoadControllerDynamics =
    {
        TurbineLoadControllerDynamics(
            DynamicsFunctionBlock.parse (context),
            TurbineGovernorDynamics (context)
        )
    }
}

private[ninecode] object _TurbineLoadControllerDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            TurbLCFB1.register,
            TurbineLoadControllerDynamics.register
        )
    }
}