package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The Area Control Error tariff type that is applied or used.
 *
 * @param sup Reference to the superclass object.
 * @param typ The coded type of an ACE tariff.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Unit [[ch.ninecode.model.Unit_ Unit_]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class AceTariffType
(
    override val sup: BasicElement,
    typ: String,
    MarketDocument: List[String],
    Unit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AceTariffType] }
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
        implicit val clz: String = AceTariffType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AceTariffType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AceTariffType.fields (position), x))
        emitelem (0, typ)
        emitattrs (1, MarketDocument)
        emitattrs (2, Unit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AceTariffType rdf:ID=\"%s\">\n%s\t</cim:AceTariffType>".format (id, export_fields)
    }
}

object AceTariffType
extends
    Parseable[AceTariffType]
{
    val fields: Array[String] = Array[String] (
        "type",
        "MarketDocument",
        "Unit"
    )
    val typ: Fielder = parse_element (element (cls, fields(0)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Unit: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): AceTariffType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AceTariffType (
            BasicElement.parse (context),
            mask (typ (), 0),
            masks (MarketDocument (), 1),
            masks (Unit (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", true),
        Relationship ("Unit", "Unit_", true)
    )
}

/**
 * A class used to provide information about an attribute.
 *
 * @param sup Reference to the superclass object.
 * @param attribute The identification of the formal name of an attribute.
 * @param attributeValue The instance value of the attribute.
 * @param position A sequential value representing a relative sequence number.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class AttributeInstanceComponent
(
    override val sup: BasicElement,
    attribute: String,
    attributeValue: String,
    position: Int,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AttributeInstanceComponent] }
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
        implicit val clz: String = AttributeInstanceComponent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AttributeInstanceComponent.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (AttributeInstanceComponent.fields (position), x))
        emitelem (0, attribute)
        emitelem (1, attributeValue)
        emitelem (2, position)
        emitattrs (3, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AttributeInstanceComponent rdf:ID=\"%s\">\n%s\t</cim:AttributeInstanceComponent>".format (id, export_fields)
    }
}

object AttributeInstanceComponent
extends
    Parseable[AttributeInstanceComponent]
{
    val fields: Array[String] = Array[String] (
        "attribute",
        "attributeValue",
        "position",
        "TimeSeries"
    )
    val attribute: Fielder = parse_element (element (cls, fields(0)))
    val attributeValue: Fielder = parse_element (element (cls, fields(1)))
    val position: Fielder = parse_element (element (cls, fields(2)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): AttributeInstanceComponent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AttributeInstanceComponent (
            BasicElement.parse (context),
            mask (attribute (), 0),
            mask (attributeValue (), 1),
            toInteger (mask (position (), 2)),
            masks (TimeSeries (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

/**
 * A class providing the identification and type of an auction.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param allocationMode Identification of the method of allocation in an auction.
 * @param cancelled An indicator that signifies that the auction has been cancelled.
 * @param category The product category of an auction.
 * @param paymentTerms The terms which dictate the determination of the bid payment price.
 * @param rights The rights of use the transmission capacity acquired in an auction.
 * @param typ The kind of the Auction (e.g. implicit, explicit ...).
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Auction
(
    override val sup: IdentifiedObject,
    allocationMode: String,
    cancelled: String,
    category: String,
    paymentTerms: String,
    rights: String,
    typ: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Auction] }
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
        implicit val clz: String = Auction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Auction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Auction.fields (position), x))
        emitelem (0, allocationMode)
        emitelem (1, cancelled)
        emitelem (2, category)
        emitelem (3, paymentTerms)
        emitelem (4, rights)
        emitelem (5, typ)
        emitattrs (6, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Auction rdf:ID=\"%s\">\n%s\t</cim:Auction>".format (id, export_fields)
    }
}

object Auction
extends
    Parseable[Auction]
{
    val fields: Array[String] = Array[String] (
        "allocationMode",
        "cancelled",
        "category",
        "paymentTerms",
        "rights",
        "type",
        "TimeSeries"
    )
    val allocationMode: Fielder = parse_element (element (cls, fields(0)))
    val cancelled: Fielder = parse_element (element (cls, fields(1)))
    val category: Fielder = parse_element (element (cls, fields(2)))
    val paymentTerms: Fielder = parse_element (element (cls, fields(3)))
    val rights: Fielder = parse_element (element (cls, fields(4)))
    val typ: Fielder = parse_element (element (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Auction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Auction (
            IdentifiedObject.parse (context),
            mask (allocationMode (), 0),
            mask (cancelled (), 1),
            mask (category (), 2),
            mask (paymentTerms (), 3),
            mask (rights (), 4),
            mask (typ (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

/**
 * The formal specification of specific characteristics related to a bid.
 *
 * @param sup [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
 * @param blockBid Indication that  the values in the period are considered as a whole.
 *        They cannot be changed or subdivided.
 * @param direction The coded identification of the energy flow.
 * @param divisible An indication whether or not each element of the bid may be partially accepted or not.
 * @param linkedBidsIdentification Unique identification associated with all linked bids.
 * @param minimumActivationQuantity The minimum quantity of energy that can be activated at a given time interval.
 * @param stepIncrementQuantity The minimum increment that can be applied for an increase in an activation request.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class BidTimeSeries
(
    override val sup: TimeSeries,
    blockBid: String,
    direction: String,
    divisible: String,
    linkedBidsIdentification: String,
    minimumActivationQuantity: Double,
    stepIncrementQuantity: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TimeSeries: TimeSeries = sup.asInstanceOf[TimeSeries]
    override def copy (): Row = { clone ().asInstanceOf[BidTimeSeries] }
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
        implicit val clz: String = BidTimeSeries.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BidTimeSeries.fields (position), value)
        emitelem (0, blockBid)
        emitelem (1, direction)
        emitelem (2, divisible)
        emitelem (3, linkedBidsIdentification)
        emitelem (4, minimumActivationQuantity)
        emitelem (5, stepIncrementQuantity)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidTimeSeries rdf:ID=\"%s\">\n%s\t</cim:BidTimeSeries>".format (id, export_fields)
    }
}

object BidTimeSeries
extends
    Parseable[BidTimeSeries]
{
    val fields: Array[String] = Array[String] (
        "blockBid",
        "direction",
        "divisible",
        "linkedBidsIdentification",
        "minimumActivationQuantity",
        "stepIncrementQuantity"
    )
    val blockBid: Fielder = parse_element (element (cls, fields(0)))
    val direction: Fielder = parse_element (element (cls, fields(1)))
    val divisible: Fielder = parse_element (element (cls, fields(2)))
    val linkedBidsIdentification: Fielder = parse_element (element (cls, fields(3)))
    val minimumActivationQuantity: Fielder = parse_element (element (cls, fields(4)))
    val stepIncrementQuantity: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): BidTimeSeries =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidTimeSeries (
            TimeSeries.parse (context),
            mask (blockBid (), 0),
            mask (direction (), 1),
            mask (divisible (), 2),
            mask (linkedBidsIdentification (), 3),
            toDouble (mask (minimumActivationQuantity (), 4)),
            toDouble (mask (stepIncrementQuantity (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The date and or the time.
 *
 * @param sup Reference to the superclass object.
 * @param date Date as "yyyy-mm-dd", which conforms with ISO 8601
 * @param time Time as "hh:mm:ss.sssZ", which conforms with ISO 8601.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class DateAndOrTime
(
    override val sup: BasicElement,
    date: String,
    time: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DateAndOrTime] }
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
        implicit val clz: String = DateAndOrTime.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DateAndOrTime.fields (position), value)
        emitelem (0, date)
        emitelem (1, time)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DateAndOrTime rdf:ID=\"%s\">\n%s\t</cim:DateAndOrTime>".format (id, export_fields)
    }
}

object DateAndOrTime
extends
    Parseable[DateAndOrTime]
{
    val fields: Array[String] = Array[String] (
        "date",
        "time"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val time: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): DateAndOrTime =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DateAndOrTime (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (time (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An area of activity defined within the energy market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Domain
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Domain] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Domain rdf:ID=\"%s\">\n%s\t</cim:Domain>".format (id, export_fields)
    }
}

object Domain
extends
    Parseable[Domain]
{

    def parse (context: Context): Domain =
    {
        implicit val ctx: Context = context
        val ret = Domain (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The coded identification of the direction of energy flow.
 *
 * @param sup Reference to the superclass object.
 * @param direction The coded identification of the direction of energy flow.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class FlowDirection
(
    override val sup: BasicElement,
    direction: String
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowDirection] }
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
        implicit val clz: String = FlowDirection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FlowDirection.fields (position), value)
        emitelem (0, direction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FlowDirection rdf:ID=\"%s\">\n%s\t</cim:FlowDirection>".format (id, export_fields)
    }
}

object FlowDirection
extends
    Parseable[FlowDirection]
{
    val fields: Array[String] = Array[String] (
        "direction"
    )
    val direction: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): FlowDirection =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FlowDirection (
            BasicElement.parse (context),
            mask (direction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An identification  or eventually the contents of an agreement between two or more parties.
 *
 * @param sup [[ch.ninecode.model.MarketDocument MarketDocument]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketAgreement
(
    override val sup: MarketDocument
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def MarketDocument: MarketDocument = sup.asInstanceOf[MarketDocument]
    override def copy (): Row = { clone ().asInstanceOf[MarketAgreement] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MarketAgreement rdf:ID=\"%s\">\n%s\t</cim:MarketAgreement>".format (id, export_fields)
    }
}

object MarketAgreement
extends
    Parseable[MarketAgreement]
{

    def parse (context: Context): MarketAgreement =
    {
        implicit val ctx: Context = context
        val ret = MarketAgreement (
            MarketDocument.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Electronic document containing the information necessary to satisfy a given business process set of requirements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param selfMarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param AttributeInstanceComponent [[ch.ninecode.model.AttributeInstanceComponent AttributeInstanceComponent]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketDocument
(
    override val sup: Document,
    selfMarketDocument: List[String],
    AttributeInstanceComponent: List[String],
    Domain: List[String],
    Period: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[MarketDocument] }
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
        implicit val clz: String = MarketDocument.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketDocument.fields (position), x))
        emitattrs (0, selfMarketDocument)
        emitattrs (1, AttributeInstanceComponent)
        emitattrs (2, Domain)
        emitattrs (3, Period)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketDocument rdf:ID=\"%s\">\n%s\t</cim:MarketDocument>".format (id, export_fields)
    }
}

object MarketDocument
extends
    Parseable[MarketDocument]
{
    val fields: Array[String] = Array[String] (
        "selfMarketDocument",
        "AttributeInstanceComponent",
        "Domain",
        "Period"
    )
    val selfMarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AttributeInstanceComponent: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): MarketDocument =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketDocument (
            Document.parse (context),
            masks (selfMarketDocument (), 0),
            masks (AttributeInstanceComponent (), 1),
            masks (Domain (), 2),
            masks (Period (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("selfMarketDocument", "MarketDocument", true),
        Relationship ("AttributeInstanceComponent", "AttributeInstanceComponent", true),
        Relationship ("Domain", "Domain", true),
        Relationship ("Period", "Period", true)
    )
}

/**
 * The identification of an entity where energy products are measured or computed.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketEvaluationPoint
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[MarketEvaluationPoint] }
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:MarketEvaluationPoint rdf:ID=\"%s\">\n%s\t</cim:MarketEvaluationPoint>".format (id, export_fields)
    }
}

object MarketEvaluationPoint
extends
    Parseable[MarketEvaluationPoint]
{

    def parse (context: Context): MarketEvaluationPoint =
    {
        implicit val ctx: Context = context
        val ret = MarketEvaluationPoint (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The condition or position of an object with regard to its standing.
 *
 * @param sup Reference to the superclass object.
 * @param status The coded condition or position of an object with regard to its standing.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketObjectStatus
(
    override val sup: BasicElement,
    status: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketObjectStatus] }
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
        implicit val clz: String = MarketObjectStatus.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MarketObjectStatus.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MarketObjectStatus.fields (position), x))
        emitelem (0, status)
        emitattrs (1, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketObjectStatus rdf:ID=\"%s\">\n%s\t</cim:MarketObjectStatus>".format (id, export_fields)
    }
}

object MarketObjectStatus
extends
    Parseable[MarketObjectStatus]
{
    val fields: Array[String] = Array[String] (
        "status",
        "TimeSeries"
    )
    val status: Fielder = parse_element (element (cls, fields(0)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MarketObjectStatus =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketObjectStatus (
            BasicElement.parse (context),
            mask (status (), 0),
            masks (TimeSeries (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

/**
 * The type of a power system resource.
 *
 * @param sup [[ch.ninecode.model.PSRType PSRType]] Reference to the superclass object.
 * @param psrType The coded type of a power system resource.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MktPSRType
(
    override val sup: PSRType,
    psrType: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PSRType: PSRType = sup.asInstanceOf[PSRType]
    override def copy (): Row = { clone ().asInstanceOf[MktPSRType] }
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
        implicit val clz: String = MktPSRType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MktPSRType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (MktPSRType.fields (position), x))
        emitelem (0, psrType)
        emitattrs (1, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktPSRType rdf:ID=\"%s\">\n%s\t</cim:MktPSRType>".format (id, export_fields)
    }
}

object MktPSRType
extends
    Parseable[MktPSRType]
{
    val fields: Array[String] = Array[String] (
        "psrType",
        "TimeSeries"
    )
    val psrType: Fielder = parse_element (element (cls, fields(0)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): MktPSRType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MktPSRType (
            PSRType.parse (context),
            mask (psrType (), 0),
            masks (TimeSeries (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

/**
 * An identification of a time interval that may have a given resolution.
 *
 * @param sup Reference to the superclass object.
 * @param resolution The number of units of time that compose an individual step within a period.
 * @param timeInterval The start and end date and time for a given interval.
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Period
(
    override val sup: BasicElement,
    resolution: String,
    timeInterval: String,
    Reason: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Period] }
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
        implicit val clz: String = Period.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Period.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Period.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Period.fields (position), x))
        emitelem (0, resolution)
        emitattr (1, timeInterval)
        emitattrs (2, Reason)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Period rdf:ID=\"%s\">\n%s\t</cim:Period>".format (id, export_fields)
    }
}

object Period
extends
    Parseable[Period]
{
    val fields: Array[String] = Array[String] (
        "resolution",
        "timeInterval",
        "Reason"
    )
    val resolution: Fielder = parse_element (element (cls, fields(0)))
    val timeInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Period =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Period (
            BasicElement.parse (context),
            mask (resolution (), 0),
            mask (timeInterval (), 1),
            masks (Reason (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Reason", "Reason", true)
    )
}

/**
 * An identification of a set of values beeing adressed within a specific interval of time.
 *
 * @param sup Reference to the superclass object.
 * @param position A sequential value representing the relative position within a given time interval.
 * @param quality The quality of the information being provided.
 *        This quality may be estimated, not available, as provided, etc.
 * @param quantity Principal quantity identified for a point.
 * @param secondaryQuantity Secondary quantity identified for a point.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Point
(
    override val sup: BasicElement,
    position: Int,
    quality: String,
    quantity: Double,
    secondaryQuantity: Double,
    AceTariffType: List[String],
    Period: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, 0.0, 0.0, List(), null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Point] }
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
        implicit val clz: String = Point.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Point.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Point.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Point.fields (position), x))
        emitelem (0, position)
        emitelem (1, quality)
        emitelem (2, quantity)
        emitelem (3, secondaryQuantity)
        emitattrs (4, AceTariffType)
        emitattr (5, Period)
        emitattrs (6, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Point rdf:ID=\"%s\">\n%s\t</cim:Point>".format (id, export_fields)
    }
}

object Point
extends
    Parseable[Point]
{
    val fields: Array[String] = Array[String] (
        "position",
        "quality",
        "quantity",
        "secondaryQuantity",
        "AceTariffType",
        "Period",
        "TimeSeries"
    )
    val position: Fielder = parse_element (element (cls, fields(0)))
    val quality: Fielder = parse_element (element (cls, fields(1)))
    val quantity: Fielder = parse_element (element (cls, fields(2)))
    val secondaryQuantity: Fielder = parse_element (element (cls, fields(3)))
    val AceTariffType: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Period: Fielder = parse_attribute (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Point =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Point (
            BasicElement.parse (context),
            toInteger (mask (position (), 0)),
            mask (quality (), 1),
            toDouble (mask (quantity (), 2)),
            toDouble (mask (secondaryQuantity (), 3)),
            masks (AceTariffType (), 4),
            mask (Period (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("AceTariffType", "AceTariffType", true),
        Relationship ("Period", "Period", false),
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

/**
 * The cost corresponding to a specific measure and expressed in a currency.
 *
 * @param sup Reference to the superclass object.
 * @param amount A number of monetary units specified in a unit of currency.
 * @param category The category of a price to be used in a price calculation.
 *        The price category is mutually agreed between System Operators.
 * @param direction The direction indicates whether a System Operator pays the Market Parties or inverse.
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Price
(
    override val sup: BasicElement,
    amount: Double,
    category: String,
    direction: String,
    Point: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Price] }
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
        implicit val clz: String = Price.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Price.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Price.fields (position), value)
        emitelem (0, amount)
        emitelem (1, category)
        emitelem (2, direction)
        emitattr (3, Point)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Price rdf:ID=\"%s\">\n%s\t</cim:Price>".format (id, export_fields)
    }
}

object Price
extends
    Parseable[Price]
{
    val fields: Array[String] = Array[String] (
        "amount",
        "category",
        "direction",
        "Point"
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val category: Fielder = parse_element (element (cls, fields(1)))
    val direction: Fielder = parse_element (element (cls, fields(2)))
    val Point: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): Price =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Price (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (category (), 1),
            mask (direction (), 2),
            mask (Point (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Point", "Point", false)
    )
}

/**
 * The formal specification of a set of business transactions having the same business goal.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param classificationType The classification mechanism used to group a set of objects together within a business process.
 *        The grouping may be of a detailed or a summary nature.
 * @param processType The kind of business process.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Process
(
    override val sup: IdentifiedObject,
    classificationType: String,
    processType: String,
    MarketDocument: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Process] }
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
        implicit val clz: String = Process.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Process.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Process.fields (position), x))
        emitelem (0, classificationType)
        emitelem (1, processType)
        emitattrs (2, MarketDocument)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Process rdf:ID=\"%s\">\n%s\t</cim:Process>".format (id, export_fields)
    }
}

object Process
extends
    Parseable[Process]
{
    val fields: Array[String] = Array[String] (
        "classificationType",
        "processType",
        "MarketDocument"
    )
    val classificationType: Fielder = parse_element (element (cls, fields(0)))
    val processType: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Process =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Process (
            IdentifiedObject.parse (context),
            mask (classificationType (), 0),
            mask (processType (), 1),
            masks (MarketDocument (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", true)
    )
}

/**
 * The motivation of an act.
 *
 * @param sup Reference to the superclass object.
 * @param code The motivation of an act in coded form.
 * @param text The textual explanation corresponding to the reason code.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Reason
(
    override val sup: BasicElement,
    code: String,
    text: String,
    MarketDocument: List[String],
    Point: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Reason] }
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
        implicit val clz: String = Reason.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Reason.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Reason.fields (position), x))
        emitelem (0, code)
        emitelem (1, text)
        emitattrs (2, MarketDocument)
        emitattrs (3, Point)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Reason rdf:ID=\"%s\">\n%s\t</cim:Reason>".format (id, export_fields)
    }
}

object Reason
extends
    Parseable[Reason]
{
    val fields: Array[String] = Array[String] (
        "code",
        "text",
        "MarketDocument",
        "Point"
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val text: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): Reason =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Reason (
            BasicElement.parse (context),
            mask (code (), 0),
            mask (text (), 1),
            masks (MarketDocument (), 2),
            masks (Point (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", true),
        Relationship ("Point", "Point", true)
    )
}

/**
 * A set of regular time-ordered measurements or values of quantitative nature of an individual or collective phenomenon taken at successive, in most cases equidistant, periods / points of time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param businessType The identification of the nature of the time series.
 * @param cancelledTS An indicator stating that the TimeSeries, identified by the mRID, is cancelled as well as all the values sent in a previous version of the TimeSeries in a previous document.
 * @param curveType The coded representation of the type of curve being described.
 * @param objectAggregation Identification of the object that is the common dominator used to aggregate a time series.
 * @param product The type of the product such as Power, energy, reactive power, transport capacity that is the subject of the time series.
 * @param version Version of the time series.
 * @param DateAndOrTime [[ch.ninecode.model.DateAndOrTime DateAndOrTime]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param FlowDirection [[ch.ninecode.model.FlowDirection FlowDirection]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketEvaluationPoint [[ch.ninecode.model.MarketEvaluationPoint MarketEvaluationPoint]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class TimeSeries
(
    override val sup: IdentifiedObject,
    businessType: String,
    cancelledTS: String,
    curveType: String,
    objectAggregation: String,
    product: String,
    version: String,
    DateAndOrTime: List[String],
    Domain: List[String],
    FlowDirection: List[String],
    MarketDocument: List[String],
    MarketEvaluationPoint: List[String],
    MarketParticipant: List[String],
    Period: List[String],
    Reason: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List(), List(), List(), List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TimeSeries] }
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
        implicit val clz: String = TimeSeries.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TimeSeries.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TimeSeries.fields (position), x))
        emitelem (0, businessType)
        emitelem (1, cancelledTS)
        emitelem (2, curveType)
        emitelem (3, objectAggregation)
        emitelem (4, product)
        emitelem (5, version)
        emitattrs (6, DateAndOrTime)
        emitattrs (7, Domain)
        emitattrs (8, FlowDirection)
        emitattrs (9, MarketDocument)
        emitattrs (10, MarketEvaluationPoint)
        emitattrs (11, MarketParticipant)
        emitattrs (12, Period)
        emitattrs (13, Reason)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeSeries rdf:ID=\"%s\">\n%s\t</cim:TimeSeries>".format (id, export_fields)
    }
}

object TimeSeries
extends
    Parseable[TimeSeries]
{
    val fields: Array[String] = Array[String] (
        "businessType",
        "cancelledTS",
        "curveType",
        "objectAggregation",
        "product",
        "version",
        "DateAndOrTime",
        "Domain",
        "FlowDirection",
        "MarketDocument",
        "MarketEvaluationPoint",
        "MarketParticipant",
        "Period",
        "Reason"
    )
    val businessType: Fielder = parse_element (element (cls, fields(0)))
    val cancelledTS: Fielder = parse_element (element (cls, fields(1)))
    val curveType: Fielder = parse_element (element (cls, fields(2)))
    val objectAggregation: Fielder = parse_element (element (cls, fields(3)))
    val product: Fielder = parse_element (element (cls, fields(4)))
    val version: Fielder = parse_element (element (cls, fields(5)))
    val DateAndOrTime: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val FlowDirection: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val MarketEvaluationPoint: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(13)))

    def parse (context: Context): TimeSeries =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TimeSeries (
            IdentifiedObject.parse (context),
            mask (businessType (), 0),
            mask (cancelledTS (), 1),
            mask (curveType (), 2),
            mask (objectAggregation (), 3),
            mask (product (), 4),
            mask (version (), 5),
            masks (DateAndOrTime (), 6),
            masks (Domain (), 7),
            masks (FlowDirection (), 8),
            masks (MarketDocument (), 9),
            masks (MarketEvaluationPoint (), 10),
            masks (MarketParticipant (), 11),
            masks (Period (), 12),
            masks (Reason (), 13)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DateAndOrTime", "DateAndOrTime", true),
        Relationship ("Domain", "Domain", true),
        Relationship ("FlowDirection", "FlowDirection", true),
        Relationship ("MarketDocument", "MarketDocument", true),
        Relationship ("MarketEvaluationPoint", "MarketEvaluationPoint", true),
        Relationship ("MarketParticipant", "MarketParticipant", true),
        Relationship ("Period", "Period", true),
        Relationship ("Reason", "Reason", true)
    )
}

/**
 * The identification of the unit name for the time series quantities.
 *
 * @param sup Reference to the superclass object.
 * @param name The coded representation of the unit.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Unit_
(
    override val sup: BasicElement,
    name: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Unit_] }
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
        implicit val clz: String = Unit_.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Unit_.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (Unit_.fields (position), x))
        emitelem (0, name)
        emitattrs (1, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Unit rdf:ID=\"%s\">\n%s\t</cim:Unit>".format (id, export_fields)
    }
}

object Unit_
extends
    Parseable[Unit_]
{
    val fields: Array[String] = Array[String] (
        "name",
        "TimeSeries"
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): Unit_ =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Unit_ (
            BasicElement.parse (context),
            mask (name (), 0),
            masks (TimeSeries (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", true)
    )
}

private[ninecode] object _MarketManagement
{
    def register: List[ClassInfo] =
    {
        List (
            AceTariffType.register,
            AttributeInstanceComponent.register,
            Auction.register,
            BidTimeSeries.register,
            DateAndOrTime.register,
            Domain.register,
            FlowDirection.register,
            MarketAgreement.register,
            MarketDocument.register,
            MarketEvaluationPoint.register,
            MarketObjectStatus.register,
            MktPSRType.register,
            Period.register,
            Point.register,
            Price.register,
            Process.register,
            Reason.register,
            TimeSeries.register,
            Unit_.register
        )
    }
}