package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: LoadControl
 */

case class ConnectDisconnectFunction
(
    override val sup: EndDeviceFunction,
    val eventCount: Int,
    val isConnected: Boolean,
    val isDelayedDiscon: Boolean,
    val isLocalAutoDisconOp: Boolean,
    val isLocalAutoReconOp: Boolean,
    val isRemoteAutoDisconOp: Boolean,
    val isRemoteAutoReconOp: Boolean,
    val rcdInfo: String
)
extends
    Element
{
    def this () = { this (null, 0, false, false, false, false, false, false, null) }
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
    val eventCount = parse_element (element ("""ConnectDisconnectFunction.eventCount"""))
    val isConnected = parse_element (element ("""ConnectDisconnectFunction.isConnected"""))
    val isDelayedDiscon = parse_element (element ("""ConnectDisconnectFunction.isDelayedDiscon"""))
    val isLocalAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoDisconOp"""))
    val isLocalAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoReconOp"""))
    val isRemoteAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoDisconOp"""))
    val isRemoteAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoReconOp"""))
    val rcdInfo = parse_attribute (attribute ("""ConnectDisconnectFunction.rcdInfo"""))
    def parse (context: Context): ConnectDisconnectFunction =
    {
        return (
            ConnectDisconnectFunction
            (
                EndDeviceFunction.parse (context),
                toInteger (eventCount (context), context),
                toBoolean (isConnected (context), context),
                toBoolean (isDelayedDiscon (context), context),
                toBoolean (isLocalAutoDisconOp (context), context),
                toBoolean (isLocalAutoReconOp (context), context),
                toBoolean (isRemoteAutoDisconOp (context), context),
                toBoolean (isRemoteAutoReconOp (context), context),
                rcdInfo (context)
            )
        )
    }
}

case class RemoteConnectDisconnectInfo
(
    override val sup: BasicElement,
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
        return (
            RemoteConnectDisconnectInfo
            (
                BasicElement.parse (context),
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