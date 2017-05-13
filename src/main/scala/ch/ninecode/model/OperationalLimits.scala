package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package models a specification of limits associated with equipment and other operational entities.
 */

/**
 * Limit on active power flow.
 */
case class ActivePowerLimit
(

    override val sup: OperationalLimit,

    /**
     * Value of active power limit.
     */
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[ActivePowerLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ActivePowerLimit
extends
    Parseable[ActivePowerLimit]
{
    val sup = OperationalLimit.parse _
    val value = parse_element (element ("""ActivePowerLimit.value"""))_
    def parse (context: Context): ActivePowerLimit =
    {
        ActivePowerLimit(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * Apparent power limit.
 */
case class ApparentPowerLimit
(

    override val sup: OperationalLimit,

    /**
     * The apparent power limit.
     */
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[ApparentPowerLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ApparentPowerLimit
extends
    Parseable[ApparentPowerLimit]
{
    val sup = OperationalLimit.parse _
    val value = parse_element (element ("""ApparentPowerLimit.value"""))_
    def parse (context: Context): ApparentPowerLimit =
    {
        ApparentPowerLimit(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * A group of branch terminals whose directed flow summation is to be monitored.
 * A branch group need not form a cutset of the network.
 */
case class BranchGroup
(

    override val sup: IdentifiedObject,

    /**
     * The maximum active power flow.
     */
    val maximumActivePower: Double,

    /**
     * The maximum reactive power flow.
     */
    val maximumReactivePower: Double,

    /**
     * The minimum active power flow.
     */
    val minimumActivePower: Double,

    /**
     * The minimum reactive power flow.
     */
    val minimumReactivePower: Double,

    /**
     * Monitor the active power flow.
     */
    val monitorActivePower: Boolean,

    /**
     * Monitor the reactive power flow.
     */
    val monitorReactivePower: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BranchGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BranchGroup
extends
    Parseable[BranchGroup]
{
    val sup = IdentifiedObject.parse _
    val maximumActivePower = parse_element (element ("""BranchGroup.maximumActivePower"""))_
    val maximumReactivePower = parse_element (element ("""BranchGroup.maximumReactivePower"""))_
    val minimumActivePower = parse_element (element ("""BranchGroup.minimumActivePower"""))_
    val minimumReactivePower = parse_element (element ("""BranchGroup.minimumReactivePower"""))_
    val monitorActivePower = parse_element (element ("""BranchGroup.monitorActivePower"""))_
    val monitorReactivePower = parse_element (element ("""BranchGroup.monitorReactivePower"""))_
    def parse (context: Context): BranchGroup =
    {
        BranchGroup(
            sup (context),
            toDouble (maximumActivePower (context), context),
            toDouble (maximumReactivePower (context), context),
            toDouble (minimumActivePower (context), context),
            toDouble (minimumReactivePower (context), context),
            toBoolean (monitorActivePower (context), context),
            toBoolean (monitorReactivePower (context), context)
        )
    }
}

/**
 * A specific directed terminal flow for a branch group.
 */
case class BranchGroupTerminal
(

    override val sup: BasicElement,

    /**
     * The flow into the terminal is summed if set true.
     * The flow out of the terminanl is summed if set false.
     */
    val positiveFlowIn: Boolean,

    /**
     * The terminal to be summed.
     */
    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, false, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BranchGroupTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BranchGroupTerminal
extends
    Parseable[BranchGroupTerminal]
{
    val sup = BasicElement.parse _
    val positiveFlowIn = parse_element (element ("""BranchGroupTerminal.positiveFlowIn"""))_
    val Terminal = parse_attribute (attribute ("""BranchGroupTerminal.Terminal"""))_
    def parse (context: Context): BranchGroupTerminal =
    {
        BranchGroupTerminal(
            sup (context),
            toBoolean (positiveFlowIn (context), context),
            Terminal (context)
        )
    }
}

/**
 * Operational limit on current.
 */
case class CurrentLimit
(

    override val sup: OperationalLimit,

    /**
     * Limit on current flow.
     */
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentLimit
extends
    Parseable[CurrentLimit]
{
    val sup = OperationalLimit.parse _
    val value = parse_element (element ("""CurrentLimit.value"""))_
    def parse (context: Context): CurrentLimit =
    {
        CurrentLimit(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

/**
 * A value associated with a specific kind of limit.
 * The sub class value attribute shall be positive.
 */
case class OperationalLimit
(

    override val sup: IdentifiedObject,

    /**
     * The limit dependency models which are used to calculate this limit.
     * If no limit dependencies are specified then the native limit value is used.
     */
    val LimitDependencyModel: List[String],

    /**
     * The limit type associated with this limit.
     */
    val OperationalLimitType: String
)
extends
    Element
{
    def this () = { this (null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalLimit
extends
    Parseable[OperationalLimit]
{
    val sup = IdentifiedObject.parse _
    val LimitDependencyModel = parse_attributes (attribute ("""OperationalLimit.LimitDependencyModel"""))_
    val OperationalLimitType = parse_attribute (attribute ("""OperationalLimit.OperationalLimitType"""))_
    def parse (context: Context): OperationalLimit =
    {
        OperationalLimit(
            sup (context),
            LimitDependencyModel (context),
            OperationalLimitType (context)
        )
    }
}

/**
 * The direction attribute describes the side of  a limit that is a violation.
 */
case class OperationalLimitDirectionKind
(

    override val sup: BasicElement,

    /**
     * An absoluteValue limit means that a monitored absolute value above the limit value is a violation.
     */
    val absoluteValue: String,

    /**
     * High means that a monitored value above the limit value is a violation.
     * If applied to a terminal flow, the positive direction is into the terminal.
     */
    val high: String,

    /**
     * Low means a monitored value below the limit is a violation.
     * If applied to a terminal flow, the positive direction is into the terminal.
     */
    val low: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalLimitDirectionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalLimitDirectionKind
extends
    Parseable[OperationalLimitDirectionKind]
{
    val sup = BasicElement.parse _
    val absoluteValue = parse_attribute (attribute ("""OperationalLimitDirectionKind.absoluteValue"""))_
    val high = parse_attribute (attribute ("""OperationalLimitDirectionKind.high"""))_
    val low = parse_attribute (attribute ("""OperationalLimitDirectionKind.low"""))_
    def parse (context: Context): OperationalLimitDirectionKind =
    {
        OperationalLimitDirectionKind(
            sup (context),
            absoluteValue (context),
            high (context),
            low (context)
        )
    }
}

/**
 * A set of limits associated with equipment.
 * Sets of limits might apply to a specific temperature, or season for example. A set of limits may contain different severities of limit levels that would apply to the same equipment. The set may contain limits of different types such as apparent power and current limits or high and low voltage limits  that are logically applied together as a set.
 */
case class OperationalLimitSet
(

    override val sup: IdentifiedObject,

    /**
     * The equipment to which the limit set applies.
     */
    val Equipment: String,

    val Terminal: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalLimitSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalLimitSet
extends
    Parseable[OperationalLimitSet]
{
    val sup = IdentifiedObject.parse _
    val Equipment = parse_attribute (attribute ("""OperationalLimitSet.Equipment"""))_
    val Terminal = parse_attribute (attribute ("""OperationalLimitSet.Terminal"""))_
    def parse (context: Context): OperationalLimitSet =
    {
        OperationalLimitSet(
            sup (context),
            Equipment (context),
            Terminal (context)
        )
    }
}

/**
 * The operational meaning of a category of limits.
 */
case class OperationalLimitType
(

    override val sup: IdentifiedObject,

    /**
     * The nominal acceptable duration of the limit.
     * Limits are commonly expressed in terms of the a time limit for which the limit is normally acceptable.   The actual acceptable duration of a specific limit may depend on other local factors such as temperature or wind speed.
     */
    val acceptableDuration: Double,

    /**
     * The direction of the limit.
     */
    val direction: String,

    val TargetOperationalLimitmTypeScaling: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalLimitType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalLimitType
extends
    Parseable[OperationalLimitType]
{
    val sup = IdentifiedObject.parse _
    val acceptableDuration = parse_element (element ("""OperationalLimitType.acceptableDuration"""))_
    val direction = parse_attribute (attribute ("""OperationalLimitType.direction"""))_
    val TargetOperationalLimitmTypeScaling = parse_attribute (attribute ("""OperationalLimitType.TargetOperationalLimitmTypeScaling"""))_
    def parse (context: Context): OperationalLimitType =
    {
        OperationalLimitType(
            sup (context),
            toDouble (acceptableDuration (context), context),
            direction (context),
            TargetOperationalLimitmTypeScaling (context)
        )
    }
}

/**
 * Operational limit applied to voltage.
 */
case class VoltageLimit
(

    override val sup: OperationalLimit,

    /**
     * Limit on voltage.
     * High or low limit nature of the limit depends upon the properties of the operational limit type.
     */
    val value: Double
)
extends
    Element
{
    def this () = { this (null, 0.0) }
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { return (clone ().asInstanceOf[VoltageLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageLimit
extends
    Parseable[VoltageLimit]
{
    val sup = OperationalLimit.parse _
    val value = parse_element (element ("""VoltageLimit.value"""))_
    def parse (context: Context): VoltageLimit =
    {
        VoltageLimit(
            sup (context),
            toDouble (value (context), context)
        )
    }
}

object _OperationalLimits
{
    def register: Unit =
    {
        ActivePowerLimit.register
        ApparentPowerLimit.register
        BranchGroup.register
        BranchGroupTerminal.register
        CurrentLimit.register
        OperationalLimit.register
        OperationalLimitDirectionKind.register
        OperationalLimitSet.register
        OperationalLimitType.register
        VoltageLimit.register
    }
}