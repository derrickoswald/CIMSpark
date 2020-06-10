package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * Turbine load controller model developed by WECC.
 *
 * This model represents a supervisory turbine load controller that acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference. This model is intended to represent slow reset 'outer loop' controllers managing the action of the turbine governor.
 *
 * @param TurbineLoadControllerDynamics [[ch.ninecode.model.TurbineLoadControllerDynamics TurbineLoadControllerDynamics]] Reference to the superclass object.
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
final case class TurbLCFB1
(
    TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = null,
    db: Double = 0.0,
    emax: Double = 0.0,
    fb: Double = 0.0,
    fbf: Boolean = false,
    irmax: Double = 0.0,
    ki: Double = 0.0,
    kp: Double = 0.0,
    mwbase: Double = 0.0,
    pbf: Boolean = false,
    pmwset: Double = 0.0,
    speedReferenceGovernor: Boolean = false,
    tpelec: Double = 0.0
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
    override def sup: TurbineLoadControllerDynamics = TurbineLoadControllerDynamics

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
    CIMParseable[TurbLCFB1]
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

    def parse (context: CIMContext): TurbLCFB1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param TurbineGovernorDynamics [[ch.ninecode.model.TurbineGovernorDynamics TurbineGovernorDynamics]] Turbine-governor controlled by this turbine load controller.
 * @group TurbineLoadControllerDynamics
 * @groupname TurbineLoadControllerDynamics Package TurbineLoadControllerDynamics
 * @groupdesc TurbineLoadControllerDynamics A turbine load controller acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference.
 */
final case class TurbineLoadControllerDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    TurbineGovernorDynamics: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
    CIMParseable[TurbineLoadControllerDynamics]
{
    override val fields: Array[String] = Array[String] (
        "TurbineGovernorDynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TurbineGovernorDynamics", "TurbineGovernorDynamics", "1", "0..1")
    )
    val TurbineGovernorDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): TurbineLoadControllerDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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
    def register: List[CIMClassInfo] =
    {
        List (
            TurbLCFB1.register,
            TurbineLoadControllerDynamics.register
        )
    }
}