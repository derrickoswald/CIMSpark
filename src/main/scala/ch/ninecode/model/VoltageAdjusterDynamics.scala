package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The class represents IEEE Voltage Adjuster which is used to represent the voltage adjuster in either a power factor or var control system.
 *
 * Reference: IEEE Standard 421.5-2005 Section 11.1.
 *
 * @param sup Reference to the superclass object.
 * @param adjslew Rate at which output of adjuster changes (<i>ADJ_SLEW</i>).
 *        Unit = sec./PU.  Typical Value = 300.
 * @param taoff Time that adjuster pulses are off (<i>T</i><i><sub>AOFF</sub></i>).
 *        Typical Value = 0.5.
 * @param taon Time that adjuster pulses are on (<i>T</i><i><sub>AON</sub></i>).
 *        Typical Value = 0.1.
 * @param vadjf Set high to provide a continuous raise or lower (<i>V</i><i><sub>ADJF</sub></i>).
 * @param vadjmax Maximum output of the adjuster (<i>V</i><i><sub>ADJMAX</sub></i>).
 *        Typical Value = 1.1.
 * @param vadjmin Minimum output of the adjuster (<i>V</i><i><sub>ADJMIN</sub></i>).
 *        Typical Value = 0.9.
 * @group VoltageAdjusterDynamics
 * @groupname VoltageAdjusterDynamics Package VoltageAdjusterDynamics
 * @groupdesc VoltageAdjusterDynamics <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>

<font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */
case class VAdjIEEE
(
    override val sup: VoltageAdjusterDynamics,
    adjslew: Double,
    taoff: Double,
    taon: Double,
    vadjf: Double,
    vadjmax: Double,
    vadjmin: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VoltageAdjusterDynamics: VoltageAdjusterDynamics = sup.asInstanceOf[VoltageAdjusterDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VAdjIEEE] }
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
        "\t\t<cim:VAdjIEEE.adjslew>" + adjslew + "</cim:VAdjIEEE.adjslew>\n" +
        "\t\t<cim:VAdjIEEE.taoff>" + taoff + "</cim:VAdjIEEE.taoff>\n" +
        "\t\t<cim:VAdjIEEE.taon>" + taon + "</cim:VAdjIEEE.taon>\n" +
        "\t\t<cim:VAdjIEEE.vadjf>" + vadjf + "</cim:VAdjIEEE.vadjf>\n" +
        "\t\t<cim:VAdjIEEE.vadjmax>" + vadjmax + "</cim:VAdjIEEE.vadjmax>\n" +
        "\t\t<cim:VAdjIEEE.vadjmin>" + vadjmin + "</cim:VAdjIEEE.vadjmin>\n"
    }
    override def export: String =
    {
        "\t<cim:VAdjIEEE rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VAdjIEEE>"
    }
}

object VAdjIEEE
extends
    Parseable[VAdjIEEE]
{
    val adjslew = parse_element (element ("""VAdjIEEE.adjslew"""))
    val taoff = parse_element (element ("""VAdjIEEE.taoff"""))
    val taon = parse_element (element ("""VAdjIEEE.taon"""))
    val vadjf = parse_element (element ("""VAdjIEEE.vadjf"""))
    val vadjmax = parse_element (element ("""VAdjIEEE.vadjmax"""))
    val vadjmin = parse_element (element ("""VAdjIEEE.vadjmin"""))
    def parse (context: Context): VAdjIEEE =
    {
        VAdjIEEE(
            VoltageAdjusterDynamics.parse (context),
            toDouble (adjslew (context), context),
            toDouble (taoff (context), context),
            toDouble (taon (context), context),
            toDouble (vadjf (context), context),
            toDouble (vadjmax (context), context),
            toDouble (vadjmin (context), context)
        )
    }
}

/**
 * Voltage adjuster function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup Reference to the superclass object.
 * @param PFVArControllerType1Dynamics Power Factor or VAr controller Type I model with which this voltage adjuster is associated.
 * @group VoltageAdjusterDynamics
 * @groupname VoltageAdjusterDynamics Package VoltageAdjusterDynamics
 * @groupdesc VoltageAdjusterDynamics <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>

<font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */
case class VoltageAdjusterDynamics
(
    override val sup: DynamicsFunctionBlock,
    PFVArControllerType1Dynamics: String
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
    override def copy (): Row = { clone ().asInstanceOf[VoltageAdjusterDynamics] }
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
        (if (null != PFVArControllerType1Dynamics) "\t\t<cim:VoltageAdjusterDynamics.PFVArControllerType1Dynamics rdf:resource=\"#" + PFVArControllerType1Dynamics + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VoltageAdjusterDynamics rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VoltageAdjusterDynamics>"
    }
}

object VoltageAdjusterDynamics
extends
    Parseable[VoltageAdjusterDynamics]
{
    val PFVArControllerType1Dynamics = parse_attribute (attribute ("""VoltageAdjusterDynamics.PFVArControllerType1Dynamics"""))
    def parse (context: Context): VoltageAdjusterDynamics =
    {
        VoltageAdjusterDynamics(
            DynamicsFunctionBlock.parse (context),
            PFVArControllerType1Dynamics (context)
        )
    }
}

private[ninecode] object _VoltageAdjusterDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            VAdjIEEE.register,
            VoltageAdjusterDynamics.register
        )
    }
}