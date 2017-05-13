package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.  
<u>
</u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.
 * Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
 */

/**
 * Asynchronous machine whose dynamic behaviour is described by a user-defined model.
 */
case class AsynchronousMachineUserDefined
(

    override val sup: AsynchronousMachineDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def AsynchronousMachineDynamics: AsynchronousMachineDynamics = sup.asInstanceOf[AsynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[AsynchronousMachineUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AsynchronousMachineUserDefined
extends
    Parseable[AsynchronousMachineUserDefined]
{
    val sup = AsynchronousMachineDynamics.parse _
    val proprietary = parse_element (element ("""AsynchronousMachineUserDefined.proprietary"""))_
    def parse (context: Context): AsynchronousMachineUserDefined =
    {
        AsynchronousMachineUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Discontinuous excitation control function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class DiscontinuousExcitationControlUserDefined
(

    override val sup: DiscontinuousExcitationControlDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def DiscontinuousExcitationControlDynamics: DiscontinuousExcitationControlDynamics = sup.asInstanceOf[DiscontinuousExcitationControlDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[DiscontinuousExcitationControlUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiscontinuousExcitationControlUserDefined
extends
    Parseable[DiscontinuousExcitationControlUserDefined]
{
    val sup = DiscontinuousExcitationControlDynamics.parse _
    val proprietary = parse_element (element ("""DiscontinuousExcitationControlUserDefined.proprietary"""))_
    def parse (context: Context): DiscontinuousExcitationControlUserDefined =
    {
        DiscontinuousExcitationControlUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Excitation system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class ExcitationSystemUserDefined
(

    override val sup: ExcitationSystemDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def ExcitationSystemDynamics: ExcitationSystemDynamics = sup.asInstanceOf[ExcitationSystemDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[ExcitationSystemUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExcitationSystemUserDefined
extends
    Parseable[ExcitationSystemUserDefined]
{
    val sup = ExcitationSystemDynamics.parse _
    val proprietary = parse_element (element ("""ExcitationSystemUserDefined.proprietary"""))_
    def parse (context: Context): ExcitationSystemUserDefined =
    {
        ExcitationSystemUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Load whose dynamic behaviour is described by a user-defined model.
 */
case class LoadUserDefined
(

    override val sup: LoadDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def LoadDynamics: LoadDynamics = sup.asInstanceOf[LoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadUserDefined
extends
    Parseable[LoadUserDefined]
{
    val sup = LoadDynamics.parse _
    val proprietary = parse_element (element ("""LoadUserDefined.proprietary"""))_
    def parse (context: Context): LoadUserDefined =
    {
        LoadUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Mechanical load function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class MechanicalLoadUserDefined
(

    override val sup: MechanicalLoadDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def MechanicalLoadDynamics: MechanicalLoadDynamics = sup.asInstanceOf[MechanicalLoadDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[MechanicalLoadUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MechanicalLoadUserDefined
extends
    Parseable[MechanicalLoadUserDefined]
{
    val sup = MechanicalLoadDynamics.parse _
    val proprietary = parse_element (element ("""MechanicalLoadUserDefined.proprietary"""))_
    def parse (context: Context): MechanicalLoadUserDefined =
    {
        MechanicalLoadUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Overexcitation limiter system function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class OverexcitationLimiterUserDefined
(

    override val sup: OverexcitationLimiterDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def OverexcitationLimiterDynamics: OverexcitationLimiterDynamics = sup.asInstanceOf[OverexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[OverexcitationLimiterUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OverexcitationLimiterUserDefined
extends
    Parseable[OverexcitationLimiterUserDefined]
{
    val sup = OverexcitationLimiterDynamics.parse _
    val proprietary = parse_element (element ("""OverexcitationLimiterUserDefined.proprietary"""))_
    def parse (context: Context): OverexcitationLimiterUserDefined =
    {
        OverexcitationLimiterUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Power Factor or VAr controller Type I function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class PFVArControllerType1UserDefined
(

    override val sup: PFVArControllerType1Dynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def PFVArControllerType1Dynamics: PFVArControllerType1Dynamics = sup.asInstanceOf[PFVArControllerType1Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArControllerType1UserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArControllerType1UserDefined
extends
    Parseable[PFVArControllerType1UserDefined]
{
    val sup = PFVArControllerType1Dynamics.parse _
    val proprietary = parse_element (element ("""PFVArControllerType1UserDefined.proprietary"""))_
    def parse (context: Context): PFVArControllerType1UserDefined =
    {
        PFVArControllerType1UserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Power Factor or VAr controller Type II function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class PFVArControllerType2UserDefined
(

    override val sup: PFVArControllerType2Dynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def PFVArControllerType2Dynamics: PFVArControllerType2Dynamics = sup.asInstanceOf[PFVArControllerType2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PFVArControllerType2UserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PFVArControllerType2UserDefined
extends
    Parseable[PFVArControllerType2UserDefined]
{
    val sup = PFVArControllerType2Dynamics.parse _
    val proprietary = parse_element (element ("""PFVArControllerType2UserDefined.proprietary"""))_
    def parse (context: Context): PFVArControllerType2UserDefined =
    {
        PFVArControllerType2UserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Power system stabilizer</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class PowerSystemStabilizerUserDefined
(

    override val sup: PowerSystemStabilizerDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def PowerSystemStabilizerDynamics: PowerSystemStabilizerDynamics = sup.asInstanceOf[PowerSystemStabilizerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[PowerSystemStabilizerUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemStabilizerUserDefined
extends
    Parseable[PowerSystemStabilizerUserDefined]
{
    val sup = PowerSystemStabilizerDynamics.parse _
    val proprietary = parse_element (element ("""PowerSystemStabilizerUserDefined.proprietary"""))_
    def parse (context: Context): PowerSystemStabilizerUserDefined =
    {
        PowerSystemStabilizerUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Supports definition of one or more parameters of several different datatypes for use by proprietary user-defined models.
 * NOTE: This class does not inherit from IdentifiedObject since it is not intended that a single instance of it be referenced by more than one proprietary user-defined model instance.
 */
case class ProprietaryParameterDynamics
(

    override val sup: BasicElement,

    /**
     * Used for boolean parameter value.
     * If this attribute is populated, integerParameterValue and floatParameterValue will not be.
     */
    val booleanParameterValue: Boolean,

    /**
     * Used for floating point parameter value.
     * If this attribute is populated, booleanParameterValue and integerParameterValue will not be.
     */
    val floatParameterValue: Double,

    /**
     * Used for integer parameter value.
     * If this attribute is populated, booleanParameterValue and floatParameterValue will not be.
     */
    val integerParameterValue: Int,

    /**
     * Sequence number of the parameter among the set of parameters associated with the related proprietary user-defined model.
     */
    val parameterNumber: Int,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val AsynchronousMachineUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val DiscontinuousExcitationControlUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val ExcitationSystemUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val LoadUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val MechanicalLoadUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val OverexcitationLimiterUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val PFVArControllerType1UserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val PFVArControllerType2UserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val PowerSystemStabilizerUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val SynchronousMachineUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val TurbineGovernorUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val TurbineLoadControllerUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val UnderexcitationLimiterUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val VoltageAdjusterUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val VoltageCompensatorUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val WindPlantUserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val WindType1or2UserDefined: String,

    /**
     * Proprietary user-defined model with which this parameter is associated.
     */
    val WindType3or4UserDefined: String
)
extends
    Element
{
    def this () = { this (null, false, 0.0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ProprietaryParameterDynamics]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProprietaryParameterDynamics
extends
    Parseable[ProprietaryParameterDynamics]
{
    val sup = BasicElement.parse _
    val booleanParameterValue = parse_element (element ("""ProprietaryParameterDynamics.booleanParameterValue"""))_
    val floatParameterValue = parse_element (element ("""ProprietaryParameterDynamics.floatParameterValue"""))_
    val integerParameterValue = parse_element (element ("""ProprietaryParameterDynamics.integerParameterValue"""))_
    val parameterNumber = parse_element (element ("""ProprietaryParameterDynamics.parameterNumber"""))_
    val AsynchronousMachineUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.AsynchronousMachineUserDefined"""))_
    val DiscontinuousExcitationControlUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.DiscontinuousExcitationControlUserDefined"""))_
    val ExcitationSystemUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.ExcitationSystemUserDefined"""))_
    val LoadUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.LoadUserDefined"""))_
    val MechanicalLoadUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.MechanicalLoadUserDefined"""))_
    val OverexcitationLimiterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.OverexcitationLimiterUserDefined"""))_
    val PFVArControllerType1UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PFVArControllerType1UserDefined"""))_
    val PFVArControllerType2UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PFVArControllerType2UserDefined"""))_
    val PowerSystemStabilizerUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.PowerSystemStabilizerUserDefined"""))_
    val SynchronousMachineUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.SynchronousMachineUserDefined"""))_
    val TurbineGovernorUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.TurbineGovernorUserDefined"""))_
    val TurbineLoadControllerUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.TurbineLoadControllerUserDefined"""))_
    val UnderexcitationLimiterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.UnderexcitationLimiterUserDefined"""))_
    val VoltageAdjusterUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.VoltageAdjusterUserDefined"""))_
    val VoltageCompensatorUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.VoltageCompensatorUserDefined"""))_
    val WindPlantUserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindPlantUserDefined"""))_
    val WindType1or2UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindType1or2UserDefined"""))_
    val WindType3or4UserDefined = parse_attribute (attribute ("""ProprietaryParameterDynamics.WindType3or4UserDefined"""))_
    def parse (context: Context): ProprietaryParameterDynamics =
    {
        ProprietaryParameterDynamics(
            sup (context),
            toBoolean (booleanParameterValue (context), context),
            toDouble (floatParameterValue (context), context),
            toInteger (integerParameterValue (context), context),
            toInteger (parameterNumber (context), context),
            AsynchronousMachineUserDefined (context),
            DiscontinuousExcitationControlUserDefined (context),
            ExcitationSystemUserDefined (context),
            LoadUserDefined (context),
            MechanicalLoadUserDefined (context),
            OverexcitationLimiterUserDefined (context),
            PFVArControllerType1UserDefined (context),
            PFVArControllerType2UserDefined (context),
            PowerSystemStabilizerUserDefined (context),
            SynchronousMachineUserDefined (context),
            TurbineGovernorUserDefined (context),
            TurbineLoadControllerUserDefined (context),
            UnderexcitationLimiterUserDefined (context),
            VoltageAdjusterUserDefined (context),
            VoltageCompensatorUserDefined (context),
            WindPlantUserDefined (context),
            WindType1or2UserDefined (context),
            WindType3or4UserDefined (context)
        )
    }
}

/**
 * Synchronous machine whose dynamic behaviour is described by a user-defined model.
 */
case class SynchronousMachineUserDefined
(

    override val sup: SynchronousMachineDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def SynchronousMachineDynamics: SynchronousMachineDynamics = sup.asInstanceOf[SynchronousMachineDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[SynchronousMachineUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SynchronousMachineUserDefined
extends
    Parseable[SynchronousMachineUserDefined]
{
    val sup = SynchronousMachineDynamics.parse _
    val proprietary = parse_element (element ("""SynchronousMachineUserDefined.proprietary"""))_
    def parse (context: Context): SynchronousMachineUserDefined =
    {
        SynchronousMachineUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Turbine-governor function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class TurbineGovernorUserDefined
(

    override val sup: TurbineGovernorDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def TurbineGovernorDynamics: TurbineGovernorDynamics = sup.asInstanceOf[TurbineGovernorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbineGovernorUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbineGovernorUserDefined
extends
    Parseable[TurbineGovernorUserDefined]
{
    val sup = TurbineGovernorDynamics.parse _
    val proprietary = parse_element (element ("""TurbineGovernorUserDefined.proprietary"""))_
    def parse (context: Context): TurbineGovernorUserDefined =
    {
        TurbineGovernorUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Turbine load controller function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class TurbineLoadControllerUserDefined
(

    override val sup: TurbineLoadControllerDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def TurbineLoadControllerDynamics: TurbineLoadControllerDynamics = sup.asInstanceOf[TurbineLoadControllerDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[TurbineLoadControllerUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TurbineLoadControllerUserDefined
extends
    Parseable[TurbineLoadControllerUserDefined]
{
    val sup = TurbineLoadControllerDynamics.parse _
    val proprietary = parse_element (element ("""TurbineLoadControllerUserDefined.proprietary"""))_
    def parse (context: Context): TurbineLoadControllerUserDefined =
    {
        TurbineLoadControllerUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Underexcitation limiter function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class UnderexcitationLimiterUserDefined
(

    override val sup: UnderexcitationLimiterDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def UnderexcitationLimiterDynamics: UnderexcitationLimiterDynamics = sup.asInstanceOf[UnderexcitationLimiterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[UnderexcitationLimiterUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnderexcitationLimiterUserDefined
extends
    Parseable[UnderexcitationLimiterUserDefined]
{
    val sup = UnderexcitationLimiterDynamics.parse _
    val proprietary = parse_element (element ("""UnderexcitationLimiterUserDefined.proprietary"""))_
    def parse (context: Context): UnderexcitationLimiterUserDefined =
    {
        UnderexcitationLimiterUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * <font color="#0f0f0f">Voltage adjuster</font> function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class VoltageAdjusterUserDefined
(

    override val sup: VoltageAdjusterDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def VoltageAdjusterDynamics: VoltageAdjusterDynamics = sup.asInstanceOf[VoltageAdjusterDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageAdjusterUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageAdjusterUserDefined
extends
    Parseable[VoltageAdjusterUserDefined]
{
    val sup = VoltageAdjusterDynamics.parse _
    val proprietary = parse_element (element ("""VoltageAdjusterUserDefined.proprietary"""))_
    def parse (context: Context): VoltageAdjusterUserDefined =
    {
        VoltageAdjusterUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Voltage compensator function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class VoltageCompensatorUserDefined
(

    override val sup: VoltageCompensatorDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageCompensatorUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageCompensatorUserDefined
extends
    Parseable[VoltageCompensatorUserDefined]
{
    val sup = VoltageCompensatorDynamics.parse _
    val proprietary = parse_element (element ("""VoltageCompensatorUserDefined.proprietary"""))_
    def parse (context: Context): VoltageCompensatorUserDefined =
    {
        VoltageCompensatorUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind plant function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class WindPlantUserDefined
(

    override val sup: WindPlantDynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def WindPlantDynamics: WindPlantDynamics = sup.asInstanceOf[WindPlantDynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindPlantUserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindPlantUserDefined
extends
    Parseable[WindPlantUserDefined]
{
    val sup = WindPlantDynamics.parse _
    val proprietary = parse_element (element ("""WindPlantUserDefined.proprietary"""))_
    def parse (context: Context): WindPlantUserDefined =
    {
        WindPlantUserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind Type 1 or Type 2 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class WindType1or2UserDefined
(

    override val sup: WindTurbineType1or2Dynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def WindTurbineType1or2Dynamics: WindTurbineType1or2Dynamics = sup.asInstanceOf[WindTurbineType1or2Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindType1or2UserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindType1or2UserDefined
extends
    Parseable[WindType1or2UserDefined]
{
    val sup = WindTurbineType1or2Dynamics.parse _
    val proprietary = parse_element (element ("""WindType1or2UserDefined.proprietary"""))_
    def parse (context: Context): WindType1or2UserDefined =
    {
        WindType1or2UserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

/**
 * Wind Type 3 or Type 4 function block whose dynamic behaviour is described by <font color="#0f0f0f">a user-defined model.</font>
 */
case class WindType3or4UserDefined
(

    override val sup: WindTurbineType3or4Dynamics,

    /**
     * Behaviour is based on proprietary model as opposed to detailed model.
    true = user-defined model is proprietary with behaviour mutually understood by sending and receiving applications and parameters passed as general attributes
     * false = user-defined model is explicitly defined in terms of control blocks and their input and output signals.
     */
    val proprietary: Boolean
)
extends
    Element
{
    def this () = { this (null, false) }
    def WindTurbineType3or4Dynamics: WindTurbineType3or4Dynamics = sup.asInstanceOf[WindTurbineType3or4Dynamics]
    override def copy (): Row = { return (clone ().asInstanceOf[WindType3or4UserDefined]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WindType3or4UserDefined
extends
    Parseable[WindType3or4UserDefined]
{
    val sup = WindTurbineType3or4Dynamics.parse _
    val proprietary = parse_element (element ("""WindType3or4UserDefined.proprietary"""))_
    def parse (context: Context): WindType3or4UserDefined =
    {
        WindType3or4UserDefined(
            sup (context),
            toBoolean (proprietary (context), context)
        )
    }
}

object _UserDefinedModels
{
    def register: Unit =
    {
        AsynchronousMachineUserDefined.register
        DiscontinuousExcitationControlUserDefined.register
        ExcitationSystemUserDefined.register
        LoadUserDefined.register
        MechanicalLoadUserDefined.register
        OverexcitationLimiterUserDefined.register
        PFVArControllerType1UserDefined.register
        PFVArControllerType2UserDefined.register
        PowerSystemStabilizerUserDefined.register
        ProprietaryParameterDynamics.register
        SynchronousMachineUserDefined.register
        TurbineGovernorUserDefined.register
        TurbineLoadControllerUserDefined.register
        UnderexcitationLimiterUserDefined.register
        VoltageAdjusterUserDefined.register
        VoltageCompensatorUserDefined.register
        WindPlantUserDefined.register
        WindType1or2UserDefined.register
        WindType3or4UserDefined.register
    }
}