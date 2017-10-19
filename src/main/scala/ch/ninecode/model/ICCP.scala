package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPCommandPoint
(
    override val sup: ICCPControlPoint,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPCommandPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPCommandPoint.fields (position), value)
        emitattr (0, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPCommandPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPCommandPoint>".format (id, export_fields)
    }
}

object ICCPCommandPoint
extends
    Parseable[ICCPCommandPoint]
{
    val fields: Array[String] = Array[String] (
        ""
    )
    val unknown: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ICCPCommandPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPCommandPoint (
            ICCPControlPoint.parse (context),
            mask (unknown (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "Command", false)
    )
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPControlPoint
(
    override val sup: ICCPPoint,
    deviceClass: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPControlPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPControlPoint.fields (position), value)
        emitattr (0, deviceClass)
        emitattr (1, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPControlPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPControlPoint>".format (id, export_fields)
    }
}

object ICCPControlPoint
extends
    Parseable[ICCPControlPoint]
{
    val fields: Array[String] = Array[String] (
        "deviceClass",
        ""
    )
    val deviceClass: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ICCPControlPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPControlPoint (
            ICCPPoint.parse (context),
            mask (deviceClass (), 0),
            mask (unknown (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "ICCPIndicationPoint", false)
    )
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPIndicationPoint
(
    override val sup: ICCPPoint,
    typ: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPIndicationPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPIndicationPoint.fields (position), value)
        emitattr (0, typ)
        emitattr (1, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPIndicationPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPIndicationPoint>".format (id, export_fields)
    }
}

object ICCPIndicationPoint
extends
    Parseable[ICCPIndicationPoint]
{
    val fields: Array[String] = Array[String] (
        "type",
        ""
    )
    val typ: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ICCPIndicationPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPIndicationPoint (
            ICCPPoint.parse (context),
            mask (typ (), 0),
            mask (unknown (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "ICCPControlPoint", false)
    )
}

/**
 * This class represents the TASE.2 Information Message Object.
 *
 * The IdentifiedObject.name attribute must be non-null.  The value of the attribute shall be used as the TASE.2 Information Reference, as specified by 60870-6-503.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param localReference The Local Reference attribute specifies a value agreed upon between sender and receiver of the Information Message.
 *        It further identifies the Information Message.
 * @param scope <em>undocumented</em>
 * @param unknown [[ch.ninecode.model.TASE2BilateralTable TASE2BilateralTable]] <em>undocumented</em>
 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPInformationMessage
(
    override val sup: IdentifiedObject,
    localReference: String,
    scope: String,
    unknown: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPInformationMessage.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ICCPInformationMessage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPInformationMessage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (ICCPInformationMessage.fields (position), x))
        emitelem (0, localReference)
        emitattr (1, scope)
        emitattrs (2, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPInformationMessage rdf:ID=\"%s\">\n%s\t</cim:ICCPInformationMessage>".format (id, export_fields)
    }
}

object ICCPInformationMessage
extends
    Parseable[ICCPInformationMessage]
{
    val fields: Array[String] = Array[String] (
        "localReference",
        "scope",
        ""
    )
    val localReference: Fielder = parse_element (element (cls, fields(0)))
    val scope: Fielder = parse_attribute (attribute (cls, fields(1)))
    val unknown: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): ICCPInformationMessage =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        def masks (field: Fields, position: Int): List[String] = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPInformationMessage (
            IdentifiedObject.parse (context),
            mask (localReference (), 0),
            mask (scope (), 1),
            masks (unknown (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "TASE2BilateralTable", true)
    )
}

/**
 * The IdentifiedObject.name attribute must have a value.
 *
 * The name attribute shall be used as the DataValue name used for the exchange.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param scope <em>undocumented</em>
 * @param unknown [[ch.ninecode.model.TASE2BilateralTable TASE2BilateralTable]] <em>undocumented</em>
 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPPoint
(
    override val sup: IdentifiedObject,
    scope: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPPoint.fields (position), value)
        emitattr (0, scope)
        emitattr (1, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPPoint>".format (id, export_fields)
    }
}

object ICCPPoint
extends
    Parseable[ICCPPoint]
{
    val fields: Array[String] = Array[String] (
        "scope",
        ""
    )
    val scope: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ICCPPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPPoint (
            IdentifiedObject.parse (context),
            mask (scope (), 0),
            mask (unknown (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "TASE2BilateralTable", false)
    )
}

/**

 * @group ICCP
 * @groupname ICCP Package ICCP
 */
case class ICCPSetPoint
(
    override val sup: ICCPControlPoint,
    typ: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPSetPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPSetPoint.fields (position), value)
        emitattr (0, typ)
        emitattr (1, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPSetPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPSetPoint>".format (id, export_fields)
    }
}

object ICCPSetPoint
extends
    Parseable[ICCPSetPoint]
{
    val fields: Array[String] = Array[String] (
        "type",
        ""
    )
    val typ: Fielder = parse_attribute (attribute (cls, fields(0)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ICCPSetPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ICCPSetPoint (
            ICCPControlPoint.parse (context),
            mask (typ (), 0),
            mask (unknown (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "AnalogControl", false)
    )
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
    gateway: String,
    subnet: String,
    unknown: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IPAccessPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IPAccessPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IPAccessPoint.fields (position), value)
        emitelem (0, address)
        emitattr (1, addressType)
        emitelem (2, gateway)
        emitelem (3, subnet)
        emitattr (4, unknown)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IPAccessPoint rdf:ID=\"%s\">\n%s\t</cim:IPAccessPoint>".format (id, export_fields)
    }
}

object IPAccessPoint
extends
    Parseable[IPAccessPoint]
{
    val fields: Array[String] = Array[String] (
        "address",
        "addressType",
        "gateway",
        "subnet",
        ""
    )
    val address: Fielder = parse_element (element (cls, fields(0)))
    val addressType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val gateway: Fielder = parse_element (element (cls, fields(2)))
    val subnet: Fielder = parse_element (element (cls, fields(3)))
    val unknown: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): IPAccessPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = IPAccessPoint (
            BasicElement.parse (context),
            mask (address (), 0),
            mask (addressType (), 1),
            mask (gateway (), 2),
            mask (subnet (), 3),
            mask (unknown (), 4)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("unknown", "TASE2BilateralTable", false)
    )
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ISOUpperLayer.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ISOUpperLayer.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ISOUpperLayer.fields (position), value)
        emitattr (0, ap)
        emitelem (1, osiPsel)
        emitelem (2, osiSsel)
        emitelem (3, osiTsel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ISOUpperLayer rdf:ID=\"%s\">\n%s\t</cim:ISOUpperLayer>".format (id, export_fields)
    }
}

object ISOUpperLayer
extends
    Parseable[ISOUpperLayer]
{
    val fields: Array[String] = Array[String] (
        "ap",
        "osiPsel",
        "osiSsel",
        "osiTsel"
    )
    val ap: Fielder = parse_attribute (attribute (cls, fields(0)))
    val osiPsel: Fielder = parse_element (element (cls, fields(1)))
    val osiSsel: Fielder = parse_element (element (cls, fields(2)))
    val osiTsel: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): ISOUpperLayer =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ISOUpperLayer (
            TCPAcessPoint.parse (context),
            mask (ap (), 0),
            mask (osiPsel (), 1),
            mask (osiSsel (), 2),
            mask (osiTsel (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TASE2BilateralTable.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TASE2BilateralTable.fields (position), value)
        emitelem (0, bilateralTableID)
        emitelem (1, calling)
        emitelem (2, nameOfICC)
        emitelem (3, tase2version)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TASE2BilateralTable rdf:ID=\"%s\">\n%s\t</cim:TASE2BilateralTable>".format (id, export_fields)
    }
}

object TASE2BilateralTable
extends
    Parseable[TASE2BilateralTable]
{
    val fields: Array[String] = Array[String] (
        "bilateralTableID",
        "calling",
        "nameOfICC",
        "tase2version"
    )
    val bilateralTableID: Fielder = parse_element (element (cls, fields(0)))
    val calling: Fielder = parse_element (element (cls, fields(1)))
    val nameOfICC: Fielder = parse_element (element (cls, fields(2)))
    val tase2version: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): TASE2BilateralTable =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = TASE2BilateralTable (
            IdentifiedObject.parse (context),
            mask (bilateralTableID (), 0),
            toBoolean (mask (calling (), 1)),
            mask (nameOfICC (), 2),
            mask (tase2version (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TCPAcessPoint.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TCPAcessPoint.fields (position), value)
        emitelem (0, keepAliveTime)
        emitelem (1, port)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TCPAcessPoint rdf:ID=\"%s\">\n%s\t</cim:TCPAcessPoint>".format (id, export_fields)
    }
}

object TCPAcessPoint
extends
    Parseable[TCPAcessPoint]
{
    val fields: Array[String] = Array[String] (
        "keepAliveTime",
        "port"
    )
    val keepAliveTime: Fielder = parse_element (element (cls, fields(0)))
    val port: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): TCPAcessPoint =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = TCPAcessPoint (
            IPAccessPoint.parse (context),
            toInteger (mask (keepAliveTime (), 0)),
            toInteger (mask (port (), 1))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
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