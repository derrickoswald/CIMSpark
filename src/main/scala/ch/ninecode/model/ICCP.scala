package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable


case class ICCPCommandPoint
(
    override val sup: ICCPControlPoint,
    attr: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ICCPControlPoint: ICCPControlPoint = sup.asInstanceOf[ICCPControlPoint]
    override def copy (): Row = { clone ().asInstanceOf[ICCPCommandPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) "\t\t<cim:ICCPCommandPoint. rdf:resource=\"#" + attr + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPCommandPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPCommandPoint>\n"
    }
}

object ICCPCommandPoint
extends
    Parseable[ICCPCommandPoint]
{
    val attr: (Context) => String = parse_attribute (attribute ("""ICCPCommandPoint."""))
    def parse (context: Context): ICCPCommandPoint =
    {
        ICCPCommandPoint(
            ICCPControlPoint.parse (context),
            attr (context)
        )
    }
}

case class ICCPControlPoint
(
    override val sup: ICCPPoint,
    attr: String,
    deviceClass: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPPoint: ICCPPoint = sup.asInstanceOf[ICCPPoint]
    override def copy (): Row = { clone ().asInstanceOf[ICCPControlPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) "\t\t<cim:ICCPControlPoint. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != deviceClass) "\t\t<cim:ICCPControlPoint.deviceClass rdf:resource=\"#" + deviceClass + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPControlPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPControlPoint>\n"
    }
}

object ICCPControlPoint
extends
    Parseable[ICCPControlPoint]
{
    val attr: (Context) => String = parse_attribute (attribute ("""ICCPControlPoint."""))
    val deviceClass: (Context) => String = parse_attribute (attribute ("""ICCPControlPoint.deviceClass"""))
    def parse (context: Context): ICCPControlPoint =
    {
        ICCPControlPoint(
            ICCPPoint.parse (context),
            attr (context),
            deviceClass (context)
        )
    }
}

case class ICCPControlPointDeviceClass
(
    override val sup: BasicElement,
    NONSBO: String,
    SBO: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ICCPControlPointDeviceClass] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != NONSBO) "\t\t<cim:ICCPControlPointDeviceClass.NONSBO rdf:resource=\"#" + NONSBO + "\"/>\n" else "") +
        (if (null != SBO) "\t\t<cim:ICCPControlPointDeviceClass.SBO rdf:resource=\"#" + SBO + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPControlPointDeviceClass rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPControlPointDeviceClass>\n"
    }
}

object ICCPControlPointDeviceClass
extends
    Parseable[ICCPControlPointDeviceClass]
{
    val NONSBO: (Context) => String = parse_attribute (attribute ("""ICCPControlPointDeviceClass.NONSBO"""))
    val SBO: (Context) => String = parse_attribute (attribute ("""ICCPControlPointDeviceClass.SBO"""))
    def parse (context: Context): ICCPControlPointDeviceClass =
    {
        ICCPControlPointDeviceClass(
            BasicElement.parse (context),
            NONSBO (context),
            SBO (context)
        )
    }
}

case class ICCPIndicationPoint
(
    override val sup: ICCPPoint,
    attr: String,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPPoint: ICCPPoint = sup.asInstanceOf[ICCPPoint]
    override def copy (): Row = { clone ().asInstanceOf[ICCPIndicationPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) "\t\t<cim:ICCPIndicationPoint. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:ICCPIndicationPoint.type rdf:resource=\"#" + typ + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPIndicationPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPIndicationPoint>\n"
    }
}

object ICCPIndicationPoint
extends
    Parseable[ICCPIndicationPoint]
{
    val attr: (Context) => String = parse_attribute (attribute ("""ICCPIndicationPoint."""))
    val typ: (Context) => String = parse_attribute (attribute ("""ICCPIndicationPoint.type"""))
    def parse (context: Context): ICCPIndicationPoint =
    {
        ICCPIndicationPoint(
            ICCPPoint.parse (context),
            attr (context),
            typ (context)
        )
    }
}

case class ICCPIndicationPointType
(
    override val sup: BasicElement,
    DISCRETE: String,
    REAL: String,
    STATE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ICCPIndicationPointType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != DISCRETE) "\t\t<cim:ICCPIndicationPointType.DISCRETE rdf:resource=\"#" + DISCRETE + "\"/>\n" else "") +
        (if (null != REAL) "\t\t<cim:ICCPIndicationPointType.REAL rdf:resource=\"#" + REAL + "\"/>\n" else "") +
        (if (null != STATE) "\t\t<cim:ICCPIndicationPointType.STATE rdf:resource=\"#" + STATE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPIndicationPointType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPIndicationPointType>\n"
    }
}

object ICCPIndicationPointType
extends
    Parseable[ICCPIndicationPointType]
{
    val DISCRETE: (Context) => String = parse_attribute (attribute ("""ICCPIndicationPointType.DISCRETE"""))
    val REAL: (Context) => String = parse_attribute (attribute ("""ICCPIndicationPointType.REAL"""))
    val STATE: (Context) => String = parse_attribute (attribute ("""ICCPIndicationPointType.STATE"""))
    def parse (context: Context): ICCPIndicationPointType =
    {
        ICCPIndicationPointType(
            BasicElement.parse (context),
            DISCRETE (context),
            REAL (context),
            STATE (context)
        )
    }
}

/**
 * This class represents the TASE.2 Information Message Object.
 * The IdentifiedObject.name attribute must be non-null.  The value of the attribute shall be used as the TASE.2 Information Reference, as specified by 60870-6-503.
 * @param sup Reference to the superclass object.
 * @param attr <em>undocumented</em>
 * @param localReference The Local Reference attribute specifies a value agreed upon between sender and receiver of the Information Message.
 *        It further identifies the Information Message.
 * @param scope <em>undocumented</em>
 */
case class ICCPInformationMessage
(
    override val sup: IdentifiedObject,
    attr: List[String],
    localReference: String,
    scope: String
)
extends
    Element
{
    def this () = { this (null, List(), null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ICCPInformationMessage] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) attr.map (x => "\t\t<cim:ICCPInformationMessage. rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != localReference) "\t\t<cim:ICCPInformationMessage.localReference>" + localReference + "</cim:ICCPInformationMessage.localReference>\n" else "") +
        (if (null != scope) "\t\t<cim:ICCPInformationMessage.scope rdf:resource=\"#" + scope + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPInformationMessage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPInformationMessage>\n"
    }
}

object ICCPInformationMessage
extends
    Parseable[ICCPInformationMessage]
{
    val attr: (Context) => List[String] = parse_attributes (attribute ("""ICCPInformationMessage."""))
    val localReference: (Context) => String = parse_element (element ("""ICCPInformationMessage.localReference"""))
    val scope: (Context) => String = parse_attribute (attribute ("""ICCPInformationMessage.scope"""))
    def parse (context: Context): ICCPInformationMessage =
    {
        ICCPInformationMessage(
            IdentifiedObject.parse (context),
            attr (context),
            localReference (context),
            scope (context)
        )
    }
}

case class ICCPPScope
(
    override val sup: BasicElement,
    ICC: String,
    VCC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ICCPPScope] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != ICC) "\t\t<cim:ICCPPScope.ICC rdf:resource=\"#" + ICC + "\"/>\n" else "") +
        (if (null != VCC) "\t\t<cim:ICCPPScope.VCC rdf:resource=\"#" + VCC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPPScope rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPPScope>\n"
    }
}

object ICCPPScope
extends
    Parseable[ICCPPScope]
{
    val ICC: (Context) => String = parse_attribute (attribute ("""ICCPPScope.ICC"""))
    val VCC: (Context) => String = parse_attribute (attribute ("""ICCPPScope.VCC"""))
    def parse (context: Context): ICCPPScope =
    {
        ICCPPScope(
            BasicElement.parse (context),
            ICC (context),
            VCC (context)
        )
    }
}

/**
 * The IdentifiedObject.name attribute must have a value.
 * The name attribute shall be used as the DataValue name used for the exchange.
 * @param sup Reference to the superclass object.
 * @param attr <em>undocumented</em>
 * @param scope <em>undocumented</em>
 */
case class ICCPPoint
(
    override val sup: IdentifiedObject,
    attr: String,
    scope: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ICCPPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) "\t\t<cim:ICCPPoint. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != scope) "\t\t<cim:ICCPPoint.scope rdf:resource=\"#" + scope + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPPoint>\n"
    }
}

object ICCPPoint
extends
    Parseable[ICCPPoint]
{
    val attr: (Context) => String = parse_attribute (attribute ("""ICCPPoint."""))
    val scope: (Context) => String = parse_attribute (attribute ("""ICCPPoint.scope"""))
    def parse (context: Context): ICCPPoint =
    {
        ICCPPoint(
            IdentifiedObject.parse (context),
            attr (context),
            scope (context)
        )
    }
}

case class ICCPSetPoint
(
    override val sup: ICCPControlPoint,
    attr: String,
    typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ICCPControlPoint: ICCPControlPoint = sup.asInstanceOf[ICCPControlPoint]
    override def copy (): Row = { clone ().asInstanceOf[ICCPSetPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != attr) "\t\t<cim:ICCPSetPoint. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != typ) "\t\t<cim:ICCPSetPoint.type rdf:resource=\"#" + typ + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPSetPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPSetPoint>\n"
    }
}

object ICCPSetPoint
extends
    Parseable[ICCPSetPoint]
{
    val attr: (Context) => String = parse_attribute (attribute ("""ICCPSetPoint."""))
    val typ: (Context) => String = parse_attribute (attribute ("""ICCPSetPoint.type"""))
    def parse (context: Context): ICCPSetPoint =
    {
        ICCPSetPoint(
            ICCPControlPoint.parse (context),
            attr (context),
            typ (context)
        )
    }
}

case class ICCPSetPointType
(
    override val sup: BasicElement,
    DISCRETE: String,
    REAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ICCPSetPointType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != DISCRETE) "\t\t<cim:ICCPSetPointType.DISCRETE rdf:resource=\"#" + DISCRETE + "\"/>\n" else "") +
        (if (null != REAL) "\t\t<cim:ICCPSetPointType.REAL rdf:resource=\"#" + REAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ICCPSetPointType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ICCPSetPointType>\n"
    }
}

object ICCPSetPointType
extends
    Parseable[ICCPSetPointType]
{
    val DISCRETE: (Context) => String = parse_attribute (attribute ("""ICCPSetPointType.DISCRETE"""))
    val REAL: (Context) => String = parse_attribute (attribute ("""ICCPSetPointType.REAL"""))
    def parse (context: Context): ICCPSetPointType =
    {
        ICCPSetPointType(
            BasicElement.parse (context),
            DISCRETE (context),
            REAL (context)
        )
    }
}

case class IPAccessPoint
(
    override val sup: BasicElement,
    address: String,
    addressType: String,
    attr: String,
    gateway: String,
    subnet: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IPAccessPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != address) "\t\t<cim:IPAccessPoint.address>" + address + "</cim:IPAccessPoint.address>\n" else "") +
        (if (null != addressType) "\t\t<cim:IPAccessPoint.addressType rdf:resource=\"#" + addressType + "\"/>\n" else "") +
        (if (null != attr) "\t\t<cim:IPAccessPoint. rdf:resource=\"#" + attr + "\"/>\n" else "") +
        (if (null != gateway) "\t\t<cim:IPAccessPoint.gateway>" + gateway + "</cim:IPAccessPoint.gateway>\n" else "") +
        (if (null != subnet) "\t\t<cim:IPAccessPoint.subnet>" + subnet + "</cim:IPAccessPoint.subnet>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IPAccessPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IPAccessPoint>\n"
    }
}

object IPAccessPoint
extends
    Parseable[IPAccessPoint]
{
    val address: (Context) => String = parse_element (element ("""IPAccessPoint.address"""))
    val addressType: (Context) => String = parse_attribute (attribute ("""IPAccessPoint.addressType"""))
    val attr: (Context) => String = parse_attribute (attribute ("""IPAccessPoint."""))
    val gateway: (Context) => String = parse_element (element ("""IPAccessPoint.gateway"""))
    val subnet: (Context) => String = parse_element (element ("""IPAccessPoint.subnet"""))
    def parse (context: Context): IPAccessPoint =
    {
        IPAccessPoint(
            BasicElement.parse (context),
            address (context),
            addressType (context),
            attr (context),
            gateway (context),
            subnet (context)
        )
    }
}

case class IPAddressType
(
    override val sup: BasicElement,
    multiplier: String,
    unit: String,
    value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[IPAddressType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != multiplier) "\t\t<cim:IPAddressType.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:IPAddressType.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        (if (null != value) "\t\t<cim:IPAddressType.value>" + value + "</cim:IPAddressType.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:IPAddressType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:IPAddressType>\n"
    }
}

object IPAddressType
extends
    Parseable[IPAddressType]
{
    val multiplier: (Context) => String = parse_attribute (attribute ("""IPAddressType.multiplier"""))
    val unit: (Context) => String = parse_attribute (attribute ("""IPAddressType.unit"""))
    val value: (Context) => String = parse_element (element ("""IPAddressType.value"""))
    def parse (context: Context): IPAddressType =
    {
        IPAddressType(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
}

case class ISOAPAddressing
(
    override val sup: BasicElement,
    multiplier: String,
    unit: String,
    value: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ISOAPAddressing] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != multiplier) "\t\t<cim:ISOAPAddressing.multiplier rdf:resource=\"#" + multiplier + "\"/>\n" else "") +
        (if (null != unit) "\t\t<cim:ISOAPAddressing.unit rdf:resource=\"#" + unit + "\"/>\n" else "") +
        (if (null != value) "\t\t<cim:ISOAPAddressing.value>" + value + "</cim:ISOAPAddressing.value>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ISOAPAddressing rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ISOAPAddressing>\n"
    }
}

object ISOAPAddressing
extends
    Parseable[ISOAPAddressing]
{
    val multiplier: (Context) => String = parse_attribute (attribute ("""ISOAPAddressing.multiplier"""))
    val unit: (Context) => String = parse_attribute (attribute ("""ISOAPAddressing.unit"""))
    val value: (Context) => String = parse_element (element ("""ISOAPAddressing.value"""))
    def parse (context: Context): ISOAPAddressing =
    {
        ISOAPAddressing(
            BasicElement.parse (context),
            multiplier (context),
            unit (context),
            value (context)
        )
    }
}

case class ISOUpperLayer
(
    override val sup: TCPAcessPoint,
    ap: String,
    osiPsel: String,
    osiSsel: String,
    osiTsel: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def TCPAcessPoint: TCPAcessPoint = sup.asInstanceOf[TCPAcessPoint]
    override def copy (): Row = { clone ().asInstanceOf[ISOUpperLayer] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != ap) "\t\t<cim:ISOUpperLayer.ap rdf:resource=\"#" + ap + "\"/>\n" else "") +
        (if (null != osiPsel) "\t\t<cim:ISOUpperLayer.osiPsel>" + osiPsel + "</cim:ISOUpperLayer.osiPsel>\n" else "") +
        (if (null != osiSsel) "\t\t<cim:ISOUpperLayer.osiSsel>" + osiSsel + "</cim:ISOUpperLayer.osiSsel>\n" else "") +
        (if (null != osiTsel) "\t\t<cim:ISOUpperLayer.osiTsel>" + osiTsel + "</cim:ISOUpperLayer.osiTsel>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ISOUpperLayer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ISOUpperLayer>\n"
    }
}

object ISOUpperLayer
extends
    Parseable[ISOUpperLayer]
{
    val ap: (Context) => String = parse_attribute (attribute ("""ISOUpperLayer.ap"""))
    val osiPsel: (Context) => String = parse_element (element ("""ISOUpperLayer.osiPsel"""))
    val osiSsel: (Context) => String = parse_element (element ("""ISOUpperLayer.osiSsel"""))
    val osiTsel: (Context) => String = parse_element (element ("""ISOUpperLayer.osiTsel"""))
    def parse (context: Context): ISOUpperLayer =
    {
        ISOUpperLayer(
            TCPAcessPoint.parse (context),
            ap (context),
            osiPsel (context),
            osiSsel (context),
            osiTsel (context)
        )
    }
}

/**
 * This class describe the sending (providing) side in a bilateral ICCP data exchange.
 * Hence the ICCP bilateral (table) descriptions are created by exchanging ICCPProvider data between the parties.
 * @param sup Reference to the superclass object.
 * @param bilateralTableID Specifies the version of the Bilateral Table configuration that is being exchanged.
 * @param calling Used to indicate if the Provider is responsible for initiating the TASE.2 connection.
 *        If the value is TRUE, the provider is responsible for establishing the association.  If the value is FALSE, the peer provider of the Bilateral Table will need to establish the association.
 * @param nameOfICC Specifies the ICC scope name that the remote can use to access the information in the Bilateral Table if the information is not VCC scoped.
 *        This value may not be null.
 * @param tase2version Specifies the version of the TASE.2 that is needed to access the Bilateral Table information via TASE.2
 */
case class TASE2BilateralTable
(
    override val sup: IdentifiedObject,
    bilateralTableID: String,
    calling: Boolean,
    nameOfICC: String,
    tase2version: String
)
extends
    Element
{
    def this () = { this (null, null, false, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TASE2BilateralTable] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != bilateralTableID) "\t\t<cim:TASE2BilateralTable.bilateralTableID>" + bilateralTableID + "</cim:TASE2BilateralTable.bilateralTableID>\n" else "") +
        "\t\t<cim:TASE2BilateralTable.calling>" + calling + "</cim:TASE2BilateralTable.calling>\n" +
        (if (null != nameOfICC) "\t\t<cim:TASE2BilateralTable.nameOfICC>" + nameOfICC + "</cim:TASE2BilateralTable.nameOfICC>\n" else "") +
        (if (null != tase2version) "\t\t<cim:TASE2BilateralTable.tase2version>" + tase2version + "</cim:TASE2BilateralTable.tase2version>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TASE2BilateralTable rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TASE2BilateralTable>\n"
    }
}

object TASE2BilateralTable
extends
    Parseable[TASE2BilateralTable]
{
    val bilateralTableID: (Context) => String = parse_element (element ("""TASE2BilateralTable.bilateralTableID"""))
    val calling: (Context) => String = parse_element (element ("""TASE2BilateralTable.calling"""))
    val nameOfICC: (Context) => String = parse_element (element ("""TASE2BilateralTable.nameOfICC"""))
    val tase2version: (Context) => String = parse_element (element ("""TASE2BilateralTable.tase2version"""))
    def parse (context: Context): TASE2BilateralTable =
    {
        TASE2BilateralTable(
            IdentifiedObject.parse (context),
            bilateralTableID (context),
            toBoolean (calling (context), context),
            nameOfICC (context),
            tase2version (context)
        )
    }
}

case class TCPAcessPoint
(
    override val sup: IPAccessPoint,
    keepAliveTime: Int,
    port: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def IPAccessPoint: IPAccessPoint = sup.asInstanceOf[IPAccessPoint]
    override def copy (): Row = { clone ().asInstanceOf[TCPAcessPoint] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:TCPAcessPoint.keepAliveTime>" + keepAliveTime + "</cim:TCPAcessPoint.keepAliveTime>\n" +
        "\t\t<cim:TCPAcessPoint.port>" + port + "</cim:TCPAcessPoint.port>\n"
    }
    override def export: String =
    {
        "\t<cim:TCPAcessPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TCPAcessPoint>\n"
    }
}

object TCPAcessPoint
extends
    Parseable[TCPAcessPoint]
{
    val keepAliveTime: (Context) => String = parse_element (element ("""TCPAcessPoint.keepAliveTime"""))
    val port: (Context) => String = parse_element (element ("""TCPAcessPoint.port"""))
    def parse (context: Context): TCPAcessPoint =
    {
        TCPAcessPoint(
            IPAccessPoint.parse (context),
            toInteger (keepAliveTime (context), context),
            toInteger (port (context), context)
        )
    }
}

private[ninecode] object _ICCP
{
    def register: List[ClassInfo] =
    {
        List (
            ICCPCommandPoint.register,
            ICCPControlPoint.register,
            ICCPControlPointDeviceClass.register,
            ICCPIndicationPoint.register,
            ICCPIndicationPointType.register,
            ICCPInformationMessage.register,
            ICCPPScope.register,
            ICCPPoint.register,
            ICCPSetPoint.register,
            ICCPSetPointType.register,
            IPAccessPoint.register,
            IPAddressType.register,
            ISOAPAddressing.register,
            ISOUpperLayer.register,
            TASE2BilateralTable.register,
            TCPAcessPoint.register
        )
    }
}