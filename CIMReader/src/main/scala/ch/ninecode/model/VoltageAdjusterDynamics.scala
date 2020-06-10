package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship

/**
 * IEEE voltage adjuster which is used to represent the voltage adjuster in either a power factor or VAr control system.
 *
 * Reference: IEEE 421.5-2005, 11.1.
 *
 * @param VoltageAdjusterDynamics [[ch.ninecode.model.VoltageAdjusterDynamics VoltageAdjusterDynamics]] Reference to the superclass object.
 * @param adjslew Rate at which output of adjuster changes (<i>ADJ_SLEW</i>).
 *        Unit = s / PU.  Typical value = 300.
 * @param taoff Time that adjuster pulses are off (<i>T</i><i><sub>AOFF</sub></i>) (&gt;= 0).
 *        Typical value = 0,5.
 * @param taon Time that adjuster pulses are on (<i>T</i><i><sub>AON</sub></i>) (&gt;= 0).
 *        Typical value = 0,1.
 * @param vadjf Set high to provide a continuous raise or lower (<i>V</i><i><sub>ADJF</sub></i>).
 * @param vadjmax Maximum output of the adjuster (<i>V</i><i><sub>ADJMAX</sub></i>) (&gt; VAdjIEEE.vadjmin).
 *        Typical value = 1,1.
 * @param vadjmin Minimum output of the adjuster (<i>V</i><i><sub>ADJMIN</sub></i>) (&lt; VAdjIEEE.vadjmax).
 *        Typical value = 0,9.
 * @group VoltageAdjusterDynamics
 * @groupname VoltageAdjusterDynamics Package VoltageAdjusterDynamics
 * @groupdesc VoltageAdjusterDynamics <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 */
final case class VAdjIEEE
(
    VoltageAdjusterDynamics: VoltageAdjusterDynamics = null,
    adjslew: Double = 0.0,
    taoff: Double = 0.0,
    taon: Double = 0.0,
    vadjf: Double = 0.0,
    vadjmax: Double = 0.0,
    vadjmin: Double = 0.0
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
    override def sup: VoltageAdjusterDynamics = VoltageAdjusterDynamics

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
        implicit val clz: String = VAdjIEEE.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VAdjIEEE.fields (position), value)
        emitelem (0, adjslew)
        emitelem (1, taoff)
        emitelem (2, taon)
        emitelem (3, vadjf)
        emitelem (4, vadjmax)
        emitelem (5, vadjmin)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VAdjIEEE rdf:ID=\"%s\">\n%s\t</cim:VAdjIEEE>".format (id, export_fields)
    }
}

object VAdjIEEE
extends
    CIMParseable[VAdjIEEE]
{
    override val fields: Array[String] = Array[String] (
        "adjslew",
        "taoff",
        "taon",
        "vadjf",
        "vadjmax",
        "vadjmin"
    )
    val adjslew: Fielder = parse_element (element (cls, fields(0)))
    val taoff: Fielder = parse_element (element (cls, fields(1)))
    val taon: Fielder = parse_element (element (cls, fields(2)))
    val vadjf: Fielder = parse_element (element (cls, fields(3)))
    val vadjmax: Fielder = parse_element (element (cls, fields(4)))
    val vadjmin: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): VAdjIEEE =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VAdjIEEE (
            VoltageAdjusterDynamics.parse (context),
            toDouble (mask (adjslew (), 0)),
            toDouble (mask (taoff (), 1)),
            toDouble (mask (taon (), 2)),
            toDouble (mask (vadjf (), 3)),
            toDouble (mask (vadjmax (), 4)),
            toDouble (mask (vadjmin (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Voltage adjuster function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param PFVArControllerType1Dynamics [[ch.ninecode.model.PFVArControllerType1Dynamics PFVArControllerType1Dynamics]] Power factor or VAr controller type 1 model with which this voltage adjuster is associated.
 * @group VoltageAdjusterDynamics
 * @groupname VoltageAdjusterDynamics Package VoltageAdjusterDynamics
 * @groupdesc VoltageAdjusterDynamics <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>
<font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 */
final case class VoltageAdjusterDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    PFVArControllerType1Dynamics: String = null
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
        implicit val clz: String = VoltageAdjusterDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageAdjusterDynamics.fields (position), value)
        emitattr (0, PFVArControllerType1Dynamics)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageAdjusterDynamics rdf:ID=\"%s\">\n%s\t</cim:VoltageAdjusterDynamics>".format (id, export_fields)
    }
}

object VoltageAdjusterDynamics
extends
    CIMParseable[VoltageAdjusterDynamics]
{
    override val fields: Array[String] = Array[String] (
        "PFVArControllerType1Dynamics"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PFVArControllerType1Dynamics", "PFVArControllerType1Dynamics", "1", "0..1")
    )
    val PFVArControllerType1Dynamics: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): VoltageAdjusterDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageAdjusterDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (PFVArControllerType1Dynamics (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _VoltageAdjusterDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            VAdjIEEE.register,
            VoltageAdjusterDynamics.register
        )
    }
}