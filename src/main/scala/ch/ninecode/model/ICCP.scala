package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPCommandPoint
(
    override val sup: ICCPControlPoint,
    attr: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPCommandPoint>"
    }
}

object ICCPCommandPoint
extends
    Parseable[ICCPCommandPoint]
{
    val attr = parse_attribute (attribute ("""ICCPCommandPoint."""))
    def parse (context: Context): ICCPCommandPoint =
    {
        ICCPCommandPoint(
            ICCPControlPoint.parse (context),
            attr (context)
        )
    }
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPControlPoint
(
    override val sup: ICCPPoint,
    attr: String,
    deviceClass: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPControlPoint>"
    }
}

object ICCPControlPoint
extends
    Parseable[ICCPControlPoint]
{
    val attr = parse_attribute (attribute ("""ICCPControlPoint."""))
    val deviceClass = parse_attribute (attribute ("""ICCPControlPoint.deviceClass"""))
    def parse (context: Context): ICCPControlPoint =
    {
        ICCPControlPoint(
            ICCPPoint.parse (context),
            attr (context),
            deviceClass (context)
        )
    }
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPIndicationPoint
(
    override val sup: ICCPPoint,
    attr: String,
    typ: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPIndicationPoint>"
    }
}

object ICCPIndicationPoint
extends
    Parseable[ICCPIndicationPoint]
{
    val attr = parse_attribute (attribute ("""ICCPIndicationPoint."""))
    val typ = parse_attribute (attribute ("""ICCPIndicationPoint.type"""))
    def parse (context: Context): ICCPIndicationPoint =
    {
        ICCPIndicationPoint(
            ICCPPoint.parse (context),
            attr (context),
            typ (context)
        )
    }
}

/**
 * This class represents the TASE.2 Information Message Object.
 *
 * The IdentifiedObject.name attribute must be non-null.  The value of the attribute shall be used as the TASE.2 Information Reference, as specified by 60870-6-503.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param attr [[ch.ninecode.model.TASE2BilateralTable TASE2BilateralTable]] <em>undocumented</em>
 * @param localReference The Local Reference attribute specifies a value agreed upon between sender and receiver of the Information Message.
 *        It further identifies the Information Message.
 * @param scope <em>undocumented</em>
 * @group ICCP
 * @groupname ICCP Package ICCP
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPInformationMessage>"
    }
}

object ICCPInformationMessage
extends
    Parseable[ICCPInformationMessage]
{
    val attr = parse_attributes (attribute ("""ICCPInformationMessage."""))
    val localReference = parse_element (element ("""ICCPInformationMessage.localReference"""))
    val scope = parse_attribute (attribute ("""ICCPInformationMessage.scope"""))
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

/**
 * The IdentifiedObject.name attribute must have a value.
 *
 * The name attribute shall be used as the DataValue name used for the exchange.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param attr [[ch.ninecode.model.TASE2BilateralTable TASE2BilateralTable]] <em>undocumented</em>
 * @param scope <em>undocumented</em>
 * @group ICCP
 * @groupname ICCP Package ICCP
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPPoint>"
    }
}

object ICCPPoint
extends
    Parseable[ICCPPoint]
{
    val attr = parse_attribute (attribute ("""ICCPPoint."""))
    val scope = parse_attribute (attribute ("""ICCPPoint.scope"""))
    def parse (context: Context): ICCPPoint =
    {
        ICCPPoint(
            IdentifiedObject.parse (context),
            attr (context),
            scope (context)
        )
    }
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPSetPoint
(
    override val sup: ICCPControlPoint,
    attr: String,
    typ: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ICCPSetPoint>"
    }
}

object ICCPSetPoint
extends
    Parseable[ICCPSetPoint]
{
    val attr = parse_attribute (attribute ("""ICCPSetPoint."""))
    val typ = parse_attribute (attribute ("""ICCPSetPoint.type"""))
    def parse (context: Context): ICCPSetPoint =
    {
        ICCPSetPoint(
            ICCPControlPoint.parse (context),
            attr (context),
            typ (context)
        )
    }
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
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
        "\t</cim:IPAccessPoint>"
    }
}

object IPAccessPoint
extends
    Parseable[IPAccessPoint]
{
    val address = parse_element (element ("""IPAccessPoint.address"""))
    val addressType = parse_attribute (attribute ("""IPAccessPoint.addressType"""))
    val attr = parse_attribute (attribute ("""IPAccessPoint."""))
    val gateway = parse_element (element ("""IPAccessPoint.gateway"""))
    val subnet = parse_element (element ("""IPAccessPoint.subnet"""))
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

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:ISOUpperLayer>"
    }
}

object ISOUpperLayer
extends
    Parseable[ISOUpperLayer]
{
    val ap = parse_attribute (attribute ("""ISOUpperLayer.ap"""))
    val osiPsel = parse_element (element ("""ISOUpperLayer.osiPsel"""))
    val osiSsel = parse_element (element ("""ISOUpperLayer.osiSsel"""))
    val osiTsel = parse_element (element ("""ISOUpperLayer.osiTsel"""))
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
 *
 * Hence the ICCP bilateral (table) descriptions are created by exchanging ICCPProvider data between the parties.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param bilateralTableID Specifies the version of the Bilateral Table configuration that is being exchanged.
 * @param calling Used to indicate if the Provider is responsible for initiating the TASE.2 connection.
 *        If the value is TRUE, the provider is responsible for establishing the association.  If the value is FALSE, the peer provider of the Bilateral Table will need to establish the association.
 * @param nameOfICC Specifies the ICC scope name that the remote can use to access the information in the Bilateral Table if the information is not VCC scoped.
 *        This value may not be null.
 * @param tase2version Specifies the version of the TASE.2 that is needed to access the Bilateral Table information via TASE.2
 * @group ICCP
 * @groupname ICCP Package ICCP
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
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:TASE2BilateralTable>"
    }
}

object TASE2BilateralTable
extends
    Parseable[TASE2BilateralTable]
{
    val bilateralTableID = parse_element (element ("""TASE2BilateralTable.bilateralTableID"""))
    val calling = parse_element (element ("""TASE2BilateralTable.calling"""))
    val nameOfICC = parse_element (element ("""TASE2BilateralTable.nameOfICC"""))
    val tase2version = parse_element (element ("""TASE2BilateralTable.tase2version"""))
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

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class TCPAcessPoint
(
    override val sup: IPAccessPoint,
    keepAliveTime: Int,
    port: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
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
        "\t</cim:TCPAcessPoint>"
    }
}

object TCPAcessPoint
extends
    Parseable[TCPAcessPoint]
{
    val keepAliveTime = parse_element (element ("""TCPAcessPoint.keepAliveTime"""))
    val port = parse_element (element ("""TCPAcessPoint.port"""))
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
            ICCPIndicationPoint.register,
            ICCPInformationMessage.register,
            ICCPPoint.register,
            ICCPSetPoint.register,
            IPAccessPoint.register,
            ISOUpperLayer.register,
            TASE2BilateralTable.register,
            TCPAcessPoint.register
        )
    }
}