package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package models a specification of limits associated with equipment and other operational entities.
 */

/**
 * Limit on active power flow.
 * @param sup Reference to the superclass object.
 * @param value Value of active power limit.
 */
case class ActivePowerLimit
(
    override val sup: OperationalLimit,
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
    val value = parse_element (element ("""ActivePowerLimit.value"""))
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
 * @param sup Reference to the superclass object.
 * @param value The apparent power limit.
 */
case class ApparentPowerLimit
(
    override val sup: OperationalLimit,
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
    val value = parse_element (element ("""ApparentPowerLimit.value"""))
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
 * @param sup Reference to the superclass object.
 * @param maximumActivePower The maximum active power flow.
 * @param maximumReactivePower The maximum reactive power flow.
 * @param minimumActivePower The minimum active power flow.
 * @param minimumReactivePower The minimum reactive power flow.
 * @param monitorActivePower Monitor the active power flow.
 * @param monitorReactivePower Monitor the reactive power flow.
 */
case class BranchGroup
(
    override val sup: IdentifiedObject,
    val maximumActivePower: Double,
    val maximumReactivePower: Double,
    val minimumActivePower: Double,
    val minimumReactivePower: Double,
    val monitorActivePower: Boolean,
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
    val maximumActivePower = parse_element (element ("""BranchGroup.maximumActivePower"""))
    val maximumReactivePower = parse_element (element ("""BranchGroup.maximumReactivePower"""))
    val minimumActivePower = parse_element (element ("""BranchGroup.minimumActivePower"""))
    val minimumReactivePower = parse_element (element ("""BranchGroup.minimumReactivePower"""))
    val monitorActivePower = parse_element (element ("""BranchGroup.monitorActivePower"""))
    val monitorReactivePower = parse_element (element ("""BranchGroup.monitorReactivePower"""))
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
 * @param sup Reference to the superclass object.
 * @param positiveFlowIn The flow into the terminal is summed if set true.
 *        The flow out of the terminanl is summed if set false.
 * @param Terminal The terminal to be summed.
 */
case class BranchGroupTerminal
(
    override val sup: BasicElement,
    val positiveFlowIn: Boolean,
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
    val positiveFlowIn = parse_element (element ("""BranchGroupTerminal.positiveFlowIn"""))
    val Terminal = parse_attribute (attribute ("""BranchGroupTerminal.Terminal"""))
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
 * @param sup Reference to the superclass object.
 * @param value Limit on current flow.
 */
case class CurrentLimit
(
    override val sup: OperationalLimit,
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
    val value = parse_element (element ("""CurrentLimit.value"""))
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
 * @param sup Reference to the superclass object.
 * @param LimitDependencyModel The limit dependency models which are used to calculate this limit.
 *        If no limit dependencies are specified then the native limit value is used.
 * @param OperationalLimitType The limit type associated with this limit.
 */
case class OperationalLimit
(
    override val sup: IdentifiedObject,
    val LimitDependencyModel: List[String],
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
    val LimitDependencyModel = parse_attributes (attribute ("""OperationalLimit.LimitDependencyModel"""))
    val OperationalLimitType = parse_attribute (attribute ("""OperationalLimit.OperationalLimitType"""))
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
 * @param sup Reference to the superclass object.
 * @param absoluteValue An absoluteValue limit means that a monitored absolute value above the limit value is a violation.
 * @param high High means that a monitored value above the limit value is a violation.
 *        If applied to a terminal flow, the positive direction is into the terminal.
 * @param low Low means a monitored value below the limit is a violation.
 *        If applied to a terminal flow, the positive direction is into the terminal.
 */
case class OperationalLimitDirectionKind
(
    override val sup: BasicElement,
    val absoluteValue: String,
    val high: String,
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
    val absoluteValue = parse_attribute (attribute ("""OperationalLimitDirectionKind.absoluteValue"""))
    val high = parse_attribute (attribute ("""OperationalLimitDirectionKind.high"""))
    val low = parse_attribute (attribute ("""OperationalLimitDirectionKind.low"""))
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
 * @param sup Reference to the superclass object.
 * @param Equipment The equipment to which the limit set applies.
 * @param Terminal
 */
case class OperationalLimitSet
(
    override val sup: IdentifiedObject,
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
    val Equipment = parse_attribute (attribute ("""OperationalLimitSet.Equipment"""))
    val Terminal = parse_attribute (attribute ("""OperationalLimitSet.Terminal"""))
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
 * @param sup Reference to the superclass object.
 * @param acceptableDuration The nominal acceptable duration of the limit.
 *        Limits are commonly expressed in terms of the a time limit for which the limit is normally acceptable.   The actual acceptable duration of a specific limit may depend on other local factors such as temperature or wind speed.
 * @param direction The direction of the limit.
 * @param TargetOperationalLimitmTypeScaling
 */
case class OperationalLimitType
(
    override val sup: IdentifiedObject,
    val acceptableDuration: Double,
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
    val acceptableDuration = parse_element (element ("""OperationalLimitType.acceptableDuration"""))
    val direction = parse_attribute (attribute ("""OperationalLimitType.direction"""))
    val TargetOperationalLimitmTypeScaling = parse_attribute (attribute ("""OperationalLimitType.TargetOperationalLimitmTypeScaling"""))
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
 * @param sup Reference to the superclass object.
 * @param value Limit on voltage.
 *        High or low limit nature of the limit depends upon the properties of the operational limit type.
 */
case class VoltageLimit
(
    override val sup: OperationalLimit,
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
    val value = parse_element (element ("""VoltageLimit.value"""))
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