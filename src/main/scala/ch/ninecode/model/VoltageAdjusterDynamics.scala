package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>
 * <font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 */

/**
 * The class represents IEEE Voltage Adjuster which is used to represent the voltage adjuster in either a power factor or var control system.
 * Reference: IEEE Standard 421.5-2005 Section 11.1.
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
 */
case class VAdjIEEE
(override val sup: VoltageAdjusterDynamics,
val adjslew: Double,
val taoff: Double,
val taon: Double,
val vadjf: Double,
val vadjmax: Double,
val vadjmin: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def VoltageAdjusterDynamics: VoltageAdjusterDynamics = sup.asInstanceOf[VoltageAdjusterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[VAdjIEEE]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VAdjIEEE
extends
    Parseable[VAdjIEEE]
{
    val sup = VoltageAdjusterDynamics.parse _
    val adjslew = parse_element (element ("""VAdjIEEE.adjslew"""))_
    val taoff = parse_element (element ("""VAdjIEEE.taoff"""))_
    val taon = parse_element (element ("""VAdjIEEE.taon"""))_
    val vadjf = parse_element (element ("""VAdjIEEE.vadjf"""))_
    val vadjmax = parse_element (element ("""VAdjIEEE.vadjmax"""))_
    val vadjmin = parse_element (element ("""VAdjIEEE.vadjmin"""))_
    def parse (context: Context): VAdjIEEE =
    {
        VAdjIEEE(
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param PFVArControllerType1Dynamics Power Factor or VAr controller Type I model with which this voltage adjuster is associated.
 */
case class VoltageAdjusterDynamics
(override val sup: DynamicsFunctionBlock,
val PFVArControllerType1Dynamics: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageAdjusterDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageAdjusterDynamics
extends
    Parseable[VoltageAdjusterDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val PFVArControllerType1Dynamics = parse_attribute (attribute ("""VoltageAdjusterDynamics.PFVArControllerType1Dynamics"""))_
    def parse (context: Context): VoltageAdjusterDynamics =
    {
        VoltageAdjusterDynamics(
            sup (context),
            PFVArControllerType1Dynamics (context)
        )
    }
}

object _VoltageAdjusterDynamics
{
    def register: Unit =
    {
        VAdjIEEE.register
        VoltageAdjusterDynamics.register
    }
}