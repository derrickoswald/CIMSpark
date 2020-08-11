package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A function that will disconnect and reconnect the customer's load under defined conditions.
 *
 * @param sup                  [[ch.ninecode.model.EndDeviceFunction EndDeviceFunction]] Reference to the superclass object.
 * @param eventCount           Running cumulative count of connect or disconnect events, for the lifetime of this function or until the value is cleared.
 * @param isConnected          True if this function is in the connected state.
 * @param isDelayedDiscon      If set true, the switch may disconnect the service at the end of a specified time delay after the disconnect signal has been given.
 *                             If set false, the switch may disconnect the service immediately after the disconnect signal has been given. This is typically the case for over current circuit-breakers which are classified as either instantaneous or slow acting.
 * @param isLocalAutoDisconOp  If set true and if disconnection can be operated locally, the operation happens automatically.
 *                             Otherwise it happens manually.
 * @param isLocalAutoReconOp   If set true and if reconnection can be operated locally, then the operation happens automatically.
 *                             Otherwise, it happens manually.
 * @param isRemoteAutoDisconOp If set true and if disconnection can be operated remotely, then the operation happens automatically.
 *                             If set false and if disconnection can be operated remotely, then the operation happens manually.
 * @param isRemoteAutoReconOp  If set true and if reconnection can be operated remotely, then the operation happens automatically.
 *                             If set false and if reconnection can be operated remotely, then the operation happens manually.
 * @param rcdInfo              [[ch.ninecode.model.RemoteConnectDisconnectInfo RemoteConnectDisconnectInfo]] Information on remote connect disconnect switch.
 * @param Switches             [[ch.ninecode.model.Switch Switch]] <em>undocumented</em>
 * @group LoadControl
 * @groupname LoadControl Package LoadControl
 * @groupdesc LoadControl This package is an extension of the Metering package and contains the information classes that support specialised applications such as demand-side management using load control equipment. These classes are generally associated with the point where a service is delivered to the customer.
 */
case class ConnectDisconnectFunction
(
    override val sup: EndDeviceFunction,
    eventCount: Int,
    isConnected: Boolean,
    isDelayedDiscon: Boolean,
    isLocalAutoDisconOp: Boolean,
    isLocalAutoReconOp: Boolean,
    isRemoteAutoDisconOp: Boolean,
    isRemoteAutoReconOp: Boolean,
    rcdInfo: String,
    Switches: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0, false, false, false, false, false, false, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EndDeviceFunction: EndDeviceFunction = sup.asInstanceOf [EndDeviceFunction]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ConnectDisconnectFunction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConnectDisconnectFunction.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConnectDisconnectFunction.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConnectDisconnectFunction.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ConnectDisconnectFunction.fields (position), x))

        emitelem (0, eventCount)
        emitelem (1, isConnected)
        emitelem (2, isDelayedDiscon)
        emitelem (3, isLocalAutoDisconOp)
        emitelem (4, isLocalAutoReconOp)
        emitelem (5, isRemoteAutoDisconOp)
        emitelem (6, isRemoteAutoReconOp)
        emitattr (7, rcdInfo)
        emitattrs (8, Switches)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConnectDisconnectFunction rdf:ID=\"%s\">\n%s\t</cim:ConnectDisconnectFunction>".format (id, export_fields)
    }
}

object ConnectDisconnectFunction
    extends
        Parseable[ConnectDisconnectFunction]
{
    override val fields: Array[String] = Array [String](
        "eventCount",
        "isConnected",
        "isDelayedDiscon",
        "isLocalAutoDisconOp",
        "isLocalAutoReconOp",
        "isRemoteAutoDisconOp",
        "isRemoteAutoReconOp",
        "rcdInfo",
        "Switches"
    )
    override val relations: List[Relationship] = List (
        Relationship ("rcdInfo", "RemoteConnectDisconnectInfo", "0..1", "0..*"),
        Relationship ("Switches", "Switch", "0..*", "0..*")
    )
    val eventCount: Fielder = parse_element (element (cls, fields (0)))
    val isConnected: Fielder = parse_element (element (cls, fields (1)))
    val isDelayedDiscon: Fielder = parse_element (element (cls, fields (2)))
    val isLocalAutoDisconOp: Fielder = parse_element (element (cls, fields (3)))
    val isLocalAutoReconOp: Fielder = parse_element (element (cls, fields (4)))
    val isRemoteAutoDisconOp: Fielder = parse_element (element (cls, fields (5)))
    val isRemoteAutoReconOp: Fielder = parse_element (element (cls, fields (6)))
    val rcdInfo: Fielder = parse_attribute (attribute (cls, fields (7)))
    val Switches: FielderMultiple = parse_attributes (attribute (cls, fields (8)))

    def parse (context: Context): ConnectDisconnectFunction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ConnectDisconnectFunction (
            EndDeviceFunction.parse (context),
            toInteger (mask (eventCount (), 0)),
            toBoolean (mask (isConnected (), 1)),
            toBoolean (mask (isDelayedDiscon (), 2)),
            toBoolean (mask (isLocalAutoDisconOp (), 3)),
            toBoolean (mask (isLocalAutoReconOp (), 4)),
            toBoolean (mask (isRemoteAutoDisconOp (), 5)),
            toBoolean (mask (isRemoteAutoReconOp (), 6)),
            mask (rcdInfo (), 7),
            masks (Switches (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Details of remote connect and disconnect function.
 *
 * @param sup                      Reference to the superclass object.
 * @param armedTimeout             Setting of the timeout elapsed time.
 * @param customerVoltageLimit     Voltage limit on customer side of RCD switch above which the connect should not be made.
 * @param energyLimit              Limit of energy before disconnect.
 * @param energyUsageStartDateTime Start date and time to accumulate energy for energy usage limiting.
 * @param energyUsageWarning       Warning energy limit, used to trigger event code that energy usage is nearing limit.
 * @param isArmConnect             True if the RCD switch has to be armed before a connect action can be initiated.
 * @param isArmDisconnect          True if the RCD switch has to be armed before a disconnect action can be initiated.
 * @param isEnergyLimiting         True if the energy usage is limited and the customer will be disconnected if they go over the limit.
 * @param needsPowerLimitCheck     True if load limit has to be checked to issue an immediate disconnect (after a connect) if load is over the limit.
 * @param needsVoltageLimitCheck   True if voltage limit has to be checked to prevent connect if voltage is over the limit.
 * @param powerLimit               Load limit above which the connect should either not take place or should cause an immediate disconnect.
 * @param usePushbutton            True if pushbutton has to be used for connect.
 * @group LoadControl
 * @groupname LoadControl Package LoadControl
 * @groupdesc LoadControl This package is an extension of the Metering package and contains the information classes that support specialised applications such as demand-side management using load control equipment. These classes are generally associated with the point where a service is delivered to the customer.
 */
case class RemoteConnectDisconnectInfo
(
    override val sup: BasicElement,
    armedTimeout: Double,
    customerVoltageLimit: Double,
    energyLimit: Double,
    energyUsageStartDateTime: String,
    energyUsageWarning: Double,
    isArmConnect: Boolean,
    isArmDisconnect: Boolean,
    isEnergyLimiting: Boolean,
    needsPowerLimitCheck: Boolean,
    needsVoltageLimitCheck: Boolean,
    powerLimit: Double,
    usePushbutton: Boolean
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, 0.0, 0.0, null, 0.0, false, false, false, false, false, 0.0, false)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [RemoteConnectDisconnectInfo]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RemoteConnectDisconnectInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (RemoteConnectDisconnectInfo.fields (position), value)

        emitelem (0, armedTimeout)
        emitelem (1, customerVoltageLimit)
        emitelem (2, energyLimit)
        emitelem (3, energyUsageStartDateTime)
        emitelem (4, energyUsageWarning)
        emitelem (5, isArmConnect)
        emitelem (6, isArmDisconnect)
        emitelem (7, isEnergyLimiting)
        emitelem (8, needsPowerLimitCheck)
        emitelem (9, needsVoltageLimitCheck)
        emitelem (10, powerLimit)
        emitelem (11, usePushbutton)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:RemoteConnectDisconnectInfo rdf:ID=\"%s\">\n%s\t</cim:RemoteConnectDisconnectInfo>".format (id, export_fields)
    }
}

object RemoteConnectDisconnectInfo
    extends
        Parseable[RemoteConnectDisconnectInfo]
{
    override val fields: Array[String] = Array [String](
        "armedTimeout",
        "customerVoltageLimit",
        "energyLimit",
        "energyUsageStartDateTime",
        "energyUsageWarning",
        "isArmConnect",
        "isArmDisconnect",
        "isEnergyLimiting",
        "needsPowerLimitCheck",
        "needsVoltageLimitCheck",
        "powerLimit",
        "usePushbutton"
    )
    val armedTimeout: Fielder = parse_element (element (cls, fields (0)))
    val customerVoltageLimit: Fielder = parse_element (element (cls, fields (1)))
    val energyLimit: Fielder = parse_element (element (cls, fields (2)))
    val energyUsageStartDateTime: Fielder = parse_element (element (cls, fields (3)))
    val energyUsageWarning: Fielder = parse_element (element (cls, fields (4)))
    val isArmConnect: Fielder = parse_element (element (cls, fields (5)))
    val isArmDisconnect: Fielder = parse_element (element (cls, fields (6)))
    val isEnergyLimiting: Fielder = parse_element (element (cls, fields (7)))
    val needsPowerLimitCheck: Fielder = parse_element (element (cls, fields (8)))
    val needsVoltageLimitCheck: Fielder = parse_element (element (cls, fields (9)))
    val powerLimit: Fielder = parse_element (element (cls, fields (10)))
    val usePushbutton: Fielder = parse_element (element (cls, fields (11)))

    def parse (context: Context): RemoteConnectDisconnectInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = RemoteConnectDisconnectInfo (
            BasicElement.parse (context),
            toDouble (mask (armedTimeout (), 0)),
            toDouble (mask (customerVoltageLimit (), 1)),
            toDouble (mask (energyLimit (), 2)),
            mask (energyUsageStartDateTime (), 3),
            toDouble (mask (energyUsageWarning (), 4)),
            toBoolean (mask (isArmConnect (), 5)),
            toBoolean (mask (isArmDisconnect (), 6)),
            toBoolean (mask (isEnergyLimiting (), 7)),
            toBoolean (mask (needsPowerLimitCheck (), 8)),
            toBoolean (mask (needsVoltageLimitCheck (), 9)),
            toDouble (mask (powerLimit (), 10)),
            toBoolean (mask (usePushbutton (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _LoadControl
{
    def register: List[ClassInfo] =
    {
        List (
            ConnectDisconnectFunction.register,
            RemoteConnectDisconnectInfo.register
        )
    }
}