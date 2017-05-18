package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as demand-side management using load control equipment.
 * These classes are generally associated with the point where a service is delivered to the customer.
 */

/**
 * A function that will disconnect and reconnect the customer's load under defined conditions.
 * @param sup Reference to the superclass object.
 * @param eventCount Running cumulative count of connect or disconnect events, for the lifetime of this function or until the value is cleared.
 * @param isConnected True if this function is in the connected state.
 * @param isDelayedDiscon If set true, the switch may disconnect the service at the end of a specified time delay after the disconnect signal has been given.
 *        If set false, the switch may disconnect the service immediately after the disconnect signal has been given. This is typically the case for over current circuit-breakers which are classified as either instantaneous or slow acting.
 * @param isLocalAutoDisconOp If set true and if disconnection can be operated locally, the operation happens automatically.
 *        Otherwise it happens manually.
 * @param isLocalAutoReconOp If set true and if reconnection can be operated locally, then the operation happens automatically.
 *        Otherwise, it happens manually.
 * @param isRemoteAutoDisconOp If set true and if disconnection can be operated remotely, then the operation happens automatically.
 *        If set false and if disconnection can be operated remotely, then the operation happens manually.
 * @param isRemoteAutoReconOp If set true and if reconnection can be operated remotely, then the operation happens automatically.
 *        If set false and if reconnection can be operated remotely, then the operation happens manually.
 * @param rcdInfo Information on remote connect disconnect switch.
 * @param Switches
 */
case class ConnectDisconnectFunction
(
    override val sup: Element,
    val eventCount: Int,
    val isConnected: Boolean,
    val isDelayedDiscon: Boolean,
    val isLocalAutoDisconOp: Boolean,
    val isLocalAutoReconOp: Boolean,
    val isRemoteAutoDisconOp: Boolean,
    val isRemoteAutoReconOp: Boolean,
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
    val eventCount = parse_element (element ("""ConnectDisconnectFunction.eventCount"""))
    val isConnected = parse_element (element ("""ConnectDisconnectFunction.isConnected"""))
    val isDelayedDiscon = parse_element (element ("""ConnectDisconnectFunction.isDelayedDiscon"""))
    val isLocalAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoDisconOp"""))
    val isLocalAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoReconOp"""))
    val isRemoteAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoDisconOp"""))
    val isRemoteAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoReconOp"""))
    val rcdInfo = parse_attribute (attribute ("""ConnectDisconnectFunction.rcdInfo"""))
    val Switches = parse_attributes (attribute ("""ConnectDisconnectFunction.Switches"""))
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
 * @param sup Reference to the superclass object.
 * @param armedTimeout Setting of the timeout elapsed time.
 * @param customerVoltageLimit Voltage limit on customer side of RCD switch above which the connect should not be made.
 * @param energyLimit Limit of energy before disconnect.
 * @param energyUsageStartDateTime Start date and time to accumulate energy for energy usage limiting.
 * @param energyUsageWarning Warning energy limit, used to trigger event code that energy usage is nearing limit.
 * @param isArmConnect True if the RCD switch has to be armed before a connect action can be initiated.
 * @param isArmDisconnect True if the RCD switch has to be armed before a disconnect action can be initiated.
 * @param isEnergyLimiting True if the energy usage is limited and the customer will be disconnected if they go over the limit.
 * @param needsPowerLimitCheck True if load limit has to be checked to issue an immediate disconnect (after a connect) if load is over the limit.
 * @param needsVoltageLimitCheck True if voltage limit has to be checked to prevent connect if voltage is over the limit.
 * @param powerLimit Load limit above which the connect should either not take place or should cause an immediate disconnect.
 * @param usePushbutton True if pushbutton has to be used for connect.
 */
case class RemoteConnectDisconnectInfo
(
    override val sup: Element,
    val armedTimeout: Double,
    val customerVoltageLimit: Double,
    val energyLimit: Double,
    val energyUsageStartDateTime: String,
    val energyUsageWarning: Double,
    val isArmConnect: Boolean,
    val isArmDisconnect: Boolean,
    val isEnergyLimiting: Boolean,
    val needsPowerLimitCheck: Boolean,
    val needsVoltageLimitCheck: Boolean,
    val powerLimit: Double,
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
    val armedTimeout = parse_element (element ("""RemoteConnectDisconnectInfo.armedTimeout"""))
    val customerVoltageLimit = parse_element (element ("""RemoteConnectDisconnectInfo.customerVoltageLimit"""))
    val energyLimit = parse_element (element ("""RemoteConnectDisconnectInfo.energyLimit"""))
    val energyUsageStartDateTime = parse_element (element ("""RemoteConnectDisconnectInfo.energyUsageStartDateTime"""))
    val energyUsageWarning = parse_element (element ("""RemoteConnectDisconnectInfo.energyUsageWarning"""))
    val isArmConnect = parse_element (element ("""RemoteConnectDisconnectInfo.isArmConnect"""))
    val isArmDisconnect = parse_element (element ("""RemoteConnectDisconnectInfo.isArmDisconnect"""))
    val isEnergyLimiting = parse_element (element ("""RemoteConnectDisconnectInfo.isEnergyLimiting"""))
    val needsPowerLimitCheck = parse_element (element ("""RemoteConnectDisconnectInfo.needsPowerLimitCheck"""))
    val needsVoltageLimitCheck = parse_element (element ("""RemoteConnectDisconnectInfo.needsVoltageLimitCheck"""))
    val powerLimit = parse_element (element ("""RemoteConnectDisconnectInfo.powerLimit"""))
    val usePushbutton = parse_element (element ("""RemoteConnectDisconnectInfo.usePushbutton"""))
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