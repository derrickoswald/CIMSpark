package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Turbine load controller model developed by WECC.
 *
 * This model represents a supervisory turbine load controller that acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference. This model is intended to represent slow reset 'outer loop' controllers managing the action of the turbine governor.
 *
 * @param sup [[ch.ninecode.model.TurbineLoadControllerDynamics TurbineLoadControllerDynamics]] Reference to the superclass object.
 * @param db Controller deadband (<i>db</i>).
 *        Typical value = 0.
 * @param emax Maximum control error (<i>Emax</i>) (see parameter detail 4).
 *        Typical value = 0,02.
 * @param fb Frequency bias gain (<i>Fb</i>).
 *        Typical value = 0.
 * @param fbf Frequency bias flag (<i>Fbf</i>).
 *        true = enable frequency bias
 *        false = disable frequency bias.
 *        Typical value = false.
 * @param irmax Maximum turbine speed/load reference bias (<i>Irmax</i>) (see parameter detail 3).
 *        Typical value = 0.
 * @param ki Integral gain (<i>Ki</i>).
 *        Typical value = 0.
 * @param kp Proportional gain (<i>Kp</i>).
 *        Typical value = 0.
 * @param mwbase Base for power values (<i>MWbase</i>) (&gt; 0).
 *        Unit = MW.
 * @param pbf Power controller flag (<i>Pbf</i>).
 *        true = enable load controller
 *        false = disable load controller.
 *        Typical value = false.
 * @param pmwset Power controller setpoint (<i>Pmwset</i>) (see parameter detail 1).
 *        Unit = MW. Typical value = 0.
 * @param speedReferenceGovernor Type of turbine governor reference (<i>Type</i>).
 *        true = speed reference governor
 *        false = load reference governor.
 *        Typical value = true.
 * @param tpelec Power transducer time constant (<i>Tpelec</i>) (&gt;= 0).
 *        Typical value = 0.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbLCFB1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TurbLCFB1.fields (position), value)
        emitelem (0, db)
        emitelem (1, emax)
        emitelem (2, fb)
        emitelem (3, fbf)
        emitelem (4, irmax)
        emitelem (5, ki)
        emitelem (6, kp)
        emitelem (7, mwbase)
        emitelem (8, pbf)
        emitelem (9, pmwset)
        emitelem (10, speedReferenceGovernor)
        emitelem (11, tpelec)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TurbLCFB1 rdf:ID=\"%s\">\n%s\t</cim:TurbLCFB1>".format (id, export_fields)
    }
}

object TurbLCFB1
extends
    Parseable[TurbLCFB1]
{
    override val fields: Array[String] = Array[String] (
        "db",
        "emax",
        "fb",
        "fbf",
        "irmax",
        "ki",
        "kp",
        "mwbase",
        "pbf",
        "pmwset",
        "speedReferenceGovernor",
        "tpelec"
    )
    val db: Fielder = parse_element (element (cls, fields(0)))
    val emax: Fielder = parse_element (element (cls, fields(1)))
    val fb: Fielder = parse_element (element (cls, fields(2)))
    val fbf: Fielder = parse_element (element (cls, fields(3)))
    val irmax: Fielder = parse_element (element (cls, fields(4)))
    val ki: Fielder = parse_element (element (cls, fields(5)))
    val kp: Fielder = parse_element (element (cls, fields(6)))
    val mwbase: Fielder = parse_element (element (cls, fields(7)))
    val pbf: Fielder = parse_element (element (cls, fields(8)))
    val pmwset: Fielder = parse_element (element (cls, fields(9)))
    val speedReferenceGovernor: Fielder = parse_element (element (cls, fields(10)))
    val tpelec: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): TurbLCFB1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TurbLCFB1 (
            TurbineLoadControllerDynamics.parse (context),
            toDouble (mask (db (), 0)),
            toDouble (mask (emax (), 1)),
            toDouble (mask (fb (), 2)),
            toBoolean (mask (fbf (), 3)),
            toDouble (mask (irmax (), 4)),
            toDouble (mask (ki (), 5)),
            toDouble (mask (kp (), 6)),
            toDouble (mask (mwbase (), 7)),
            toBoolean (mask (pbf (), 8)),
            toDouble (mask (pmwset (), 9)),
            toBoolean (mask (speedReferenceGovernor (), 10)),
            toDouble (mask (tpelec (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Turbine load controller function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor controlled by this turbine load controller.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TurbineLoadControllerDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TurbineLoadControllerDynamics.fields (position), value)
        emitattr (0, TurbineGovernorDynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TurbineLoadControllerDynamics rdf:ID=\"%s\">\n%s\t</cim:TurbineLoadControllerDynamics>".format (id, export_fields)
    }
}

object TurbineLoadControllerDynamics
extends
    Parseable[TurbineLoadControllerDynamics]
{
    override val fields: Array[String] = Array[String] (
        "TurbineGovernorDynamics"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "1", "0..1")
    )
    val TurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TurbineLoadControllerDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TurbineLoadControllerDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (TurbineGovernorDynamics (), 0)
        )
        ret.bitfields = bitfields
        ret
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