package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as demand-side management using load control equipment.
 * These classes are generally associated with the point where a service is delivered to the customer.
 */

/**
 * A function that will disconnect and reconnect the customer's load under defined conditions.
 */
case class ConnectDisconnectFunction
(

    override val sup: EndDeviceFunction,

    /**
     * Running cumulative count of connect or disconnect events, for the lifetime of this function or until the value is cleared.
     */
    val eventCount: Int,

    /**
     * True if this function is in the connected state.
     */
    val isConnected: Boolean,

    /**
     * If set true, the switch may disconnect the service at the end of a specified time delay after the disconnect signal has been given.
     * If set false, the switch may disconnect the service immediately after the disconnect signal has been given. This is typically the case for over current circuit-breakers which are classified as either instantaneous or slow acting.
     */
    val isDelayedDiscon: Boolean,

    /**
     * If set true and if disconnection can be operated locally, the operation happens automatically.
     * Otherwise it happens manually.
     */
    val isLocalAutoDisconOp: Boolean,

    /**
     * If set true and if reconnection can be operated locally, then the operation happens automatically.
     * Otherwise, it happens manually.
     */
    val isLocalAutoReconOp: Boolean,

    /**
     * If set true and if disconnection can be operated remotely, then the operation happens automatically.
     * If set false and if disconnection can be operated remotely, then the operation happens manually.
     */
    val isRemoteAutoDisconOp: Boolean,

    /**
     * If set true and if reconnection can be operated remotely, then the operation happens automatically.
     * If set false and if reconnection can be operated remotely, then the operation happens manually.
     */
    val isRemoteAutoReconOp: Boolean,

    /**
     * Information on remote connect disconnect switch.
     */
    val rcdInfo: String,

    val Switches: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, false, false, false, false, false, false, null, List()) }
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf[EndDeviceFunction]
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectDisconnectFunction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectDisconnectFunction
extends
    Parseable[ConnectDisconnectFunction]
{
    val sup = EndDeviceFunction.parse _
    val eventCount = parse_element (element ("""ConnectDisconnectFunction.eventCount"""))_
    val isConnected = parse_element (element ("""ConnectDisconnectFunction.isConnected"""))_
    val isDelayedDiscon = parse_element (element ("""ConnectDisconnectFunction.isDelayedDiscon"""))_
    val isLocalAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoDisconOp"""))_
    val isLocalAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoReconOp"""))_
    val isRemoteAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoDisconOp"""))_
    val isRemoteAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoReconOp"""))_
    val rcdInfo = parse_attribute (attribute ("""ConnectDisconnectFunction.rcdInfo"""))_
    val Switches = parse_attributes (attribute ("""ConnectDisconnectFunction.Switches"""))_
    def parse (context: Context): ConnectDisconnectFunction =
    {
        ConnectDisconnectFunction(
            sup (context),
            toInteger (eventCount (context), context),
            toBoolean (isConnected (context), context),
            toBoolean (isDelayedDiscon (context), context),
            toBoolean (isLocalAutoDisconOp (context), context),
            toBoolean (isLocalAutoReconOp (context), context),
            toBoolean (isRemoteAutoDisconOp (context), context),
            toBoolean (isRemoteAutoReconOp (context), context),
            rcdInfo (context),
            Switches (context)
        )
    }
}

/**
 * Details of remote connect and disconnect function.
 */
case class RemoteConnectDisconnectInfo
(

    override val sup: BasicElement,

    /**
     * Setting of the timeout elapsed time.
     */
    val armedTimeout: Double,

    /**
     * Voltage limit on customer side of RCD switch above which the connect should not be made.
     */
    val customerVoltageLimit: Double,

    /**
     * Limit of energy before disconnect.
     */
    val energyLimit: Double,

    /**
     * Start date and time to accumulate energy for energy usage limiting.
     */
    val energyUsageStartDateTime: String,

    /**
     * Warning energy limit, used to trigger event code that energy usage is nearing limit.
     */
    val energyUsageWarning: Double,

    /**
     * True if the RCD switch has to be armed before a connect action can be initiated.
     */
    val isArmConnect: Boolean,

    /**
     * True if the RCD switch has to be armed before a disconnect action can be initiated.
     */
    val isArmDisconnect: Boolean,

    /**
     * True if the energy usage is limited and the customer will be disconnected if they go over the limit.
     */
    val isEnergyLimiting: Boolean,

    /**
     * True if load limit has to be checked to issue an immediate disconnect (after a connect) if load is over the limit.
     */
    val needsPowerLimitCheck: Boolean,

    /**
     * True if voltage limit has to be checked to prevent connect if voltage is over the limit.
     */
    val needsVoltageLimitCheck: Boolean,

    /**
     * Load limit above which the connect should either not take place or should cause an immediate disconnect.
     */
    val powerLimit: Double,

    /**
     * True if pushbutton has to be used for connect.
     */
    val usePushbutton: Boolean
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, null, 0.0, false, false, false, false, false, 0.0, false) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteConnectDisconnectInfo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteConnectDisconnectInfo
extends
    Parseable[RemoteConnectDisconnectInfo]
{
    val sup = BasicElement.parse _
    val armedTimeout = parse_element (element ("""RemoteConnectDisconnectInfo.armedTimeout"""))_
    val customerVoltageLimit = parse_element (element ("""RemoteConnectDisconnectInfo.customerVoltageLimit"""))_
    val energyLimit = parse_element (element ("""RemoteConnectDisconnectInfo.energyLimit"""))_
    val energyUsageStartDateTime = parse_element (element ("""RemoteConnectDisconnectInfo.energyUsageStartDateTime"""))_
    val energyUsageWarning = parse_element (element ("""RemoteConnectDisconnectInfo.energyUsageWarning"""))_
    val isArmConnect = parse_element (element ("""RemoteConnectDisconnectInfo.isArmConnect"""))_
    val isArmDisconnect = parse_element (element ("""RemoteConnectDisconnectInfo.isArmDisconnect"""))_
    val isEnergyLimiting = parse_element (element ("""RemoteConnectDisconnectInfo.isEnergyLimiting"""))_
    val needsPowerLimitCheck = parse_element (element ("""RemoteConnectDisconnectInfo.needsPowerLimitCheck"""))_
    val needsVoltageLimitCheck = parse_element (element ("""RemoteConnectDisconnectInfo.needsVoltageLimitCheck"""))_
    val powerLimit = parse_element (element ("""RemoteConnectDisconnectInfo.powerLimit"""))_
    val usePushbutton = parse_element (element ("""RemoteConnectDisconnectInfo.usePushbutton"""))_
    def parse (context: Context): RemoteConnectDisconnectInfo =
    {
        RemoteConnectDisconnectInfo(
            sup (context),
            toDouble (armedTimeout (context), context),
            toDouble (customerVoltageLimit (context), context),
            toDouble (energyLimit (context), context),
            energyUsageStartDateTime (context),
            toDouble (energyUsageWarning (context), context),
            toBoolean (isArmConnect (context), context),
            toBoolean (isArmDisconnect (context), context),
            toBoolean (isEnergyLimiting (context), context),
            toBoolean (needsPowerLimitCheck (context), context),
            toBoolean (needsVoltageLimitCheck (context), context),
            toDouble (powerLimit (context), context),
            toBoolean (usePushbutton (context), context)
        )
    }
}

object _LoadControl
{
    def register: Unit =
    {
        ConnectDisconnectFunction.register
        RemoteConnectDisconnectInfo.register
    }
}