package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

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
    override def copy (): Row = { return (clone ().asInstanceOf[ConnectDisconnectFunction]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectDisconnectFunction
extends
    Parseable[ConnectDisconnectFunction]
{
    val eventCount = parse_element (element ("""ConnectDisconnectFunction.eventCount"""))_
    val isConnected = parse_element (element ("""ConnectDisconnectFunction.isConnected"""))_
    val isDelayedDiscon = parse_element (element ("""ConnectDisconnectFunction.isDelayedDiscon"""))_
    val isLocalAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoDisconOp"""))_
    val isLocalAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isLocalAutoReconOp"""))_
    val isRemoteAutoDisconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoDisconOp"""))_
    val isRemoteAutoReconOp = parse_element (element ("""ConnectDisconnectFunction.isRemoteAutoReconOp"""))_
    val rcdInfo = parse_attribute (attribute ("""ConnectDisconnectFunction.rcdInfo"""))_
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
    override def copy (): Row = { return (clone ().asInstanceOf[RemoteConnectDisconnectInfo]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RemoteConnectDisconnectInfo
extends
    Parseable[RemoteConnectDisconnectInfo]
{
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

object LoadControl
{
    def register: Unit =
    {
          ConnectDisconnectFunction.register
          RemoteConnectDisconnectInfo.register
    }
}