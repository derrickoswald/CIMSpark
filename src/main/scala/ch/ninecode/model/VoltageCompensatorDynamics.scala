package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.
 * It is linked to a specific generator (synchronous machine).
 */

/**
 * This class provides the resistive and reactive components of compensation for the generator associated with the IEEE Type 2 voltage compensator for current flow out of one of the other generators in the interconnection.
 * @param sup Reference to the superclass object.
 * @param rcij <font color="#0f0f0f">Resistive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Rcij).</font>
 * @param xcij <font color="#0f0f0f">Reactive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Xcij).</font>
 * @param SynchronousMachineDynamics Standard synchronous machine out of which current flow is being compensated for.
 * @param VcompIEEEType2 The standard IEEE Type 2 voltage compensator of this compensation.
 */
case class GenICompensationForGenJ
(
    override val sup: Element,
    val rcij: Double,
    val xcij: Double,
    val SynchronousMachineDynamics: String,
    val VcompIEEEType2: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[GenICompensationForGenJ]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenICompensationForGenJ
extends
    Parseable[GenICompensationForGenJ]
{
    val sup = IdentifiedObject.parse _
    val rcij = parse_element (element ("""GenICompensationForGenJ.rcij"""))
    val xcij = parse_element (element ("""GenICompensationForGenJ.xcij"""))
    val SynchronousMachineDynamics = parse_attribute (attribute ("""GenICompensationForGenJ.SynchronousMachineDynamics"""))
    val VcompIEEEType2 = parse_attribute (attribute ("""GenICompensationForGenJ.VcompIEEEType2"""))
    def parse (context: Context): GenICompensationForGenJ =
    {
        GenICompensationForGenJ(
            sup (context),
            toDouble (rcij (context), context),
            toDouble (xcij (context), context),
            SynchronousMachineDynamics (context),
            VcompIEEEType2 (context)
        )
    }
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 * This model is common to all excitation system models described in the IEEE Standard. </font>
 * @param sup Reference to the superclass object.
 * @param rc <font color="#0f0f0f">Resistive component of compensation of a generator (Rc).</font>
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @param xc <font color="#0f0f0f">Reactive component of compensation of a generator (Xc).</font>
 */
case class VCompIEEEType1
(
    override val sup: Element,
    val rc: Double,
    val tr: Double,
    val xc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[VCompIEEEType1]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VCompIEEEType1
extends
    Parseable[VCompIEEEType1]
{
    val sup = VoltageCompensatorDynamics.parse _
    val rc = parse_element (element ("""VCompIEEEType1.rc"""))
    val tr = parse_element (element ("""VCompIEEEType1.tr"""))
    val xc = parse_element (element ("""VCompIEEEType1.xc"""))
    def parse (context: Context): VCompIEEEType1 =
    {
        VCompIEEEType1(
            sup (context),
            toDouble (rc (context), context),
            toDouble (tr (context), context),
            toDouble (xc (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 * This model is designed to cover the following types of compensation: </font>
 * @param sup Reference to the superclass object.
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 */
case class VCompIEEEType2
(
    override val sup: Element,
    val tr: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[VCompIEEEType2]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VCompIEEEType2
extends
    Parseable[VCompIEEEType2]
{
    val sup = VoltageCompensatorDynamics.parse _
    val tr = parse_element (element ("""VCompIEEEType2.tr"""))
    def parse (context: Context): VCompIEEEType2 =
    {
        VCompIEEEType2(
            sup (context),
            toDouble (tr (context), context)
        )
    }
}

/**
 * Voltage compensator function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 * @param sup Reference to the superclass object.
 * @param ExcitationSystemDynamics Excitation system model with which this voltage compensator is associated.
 * @param RemoteInputSignal Remote input signal used by this voltage compensator model.
 */
case class VoltageCompensatorDynamics
(
    override val sup: Element,
    val ExcitationSystemDynamics: String,
    val RemoteInputSignal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageCompensatorDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageCompensatorDynamics
extends
    Parseable[VoltageCompensatorDynamics]
{
    val sup = DynamicsFunctionBlock.parse _
    val ExcitationSystemDynamics = parse_attribute (attribute ("""VoltageCompensatorDynamics.ExcitationSystemDynamics"""))
    val RemoteInputSignal = parse_attribute (attribute ("""VoltageCompensatorDynamics.RemoteInputSignal"""))
    def parse (context: Context): VoltageCompensatorDynamics =
    {
        VoltageCompensatorDynamics(
            sup (context),
            ExcitationSystemDynamics (context),
            RemoteInputSignal (context)
        )
    }
}

object _VoltageCompensatorDynamics
{
    def register: Unit =
    {
        GenICompensationForGenJ.register
        VCompIEEEType1.register
        VCompIEEEType2.register
        VoltageCompensatorDynamics.register
    }
}