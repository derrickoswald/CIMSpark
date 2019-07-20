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
 * @param type The coded type of an ACE tariff.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param Unit [[ch.ninecode.model.Unit_ Unit_]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class AceTariffType
(
    override val sup: BasicElement,
    `type`: String,
    MarketDocument: List[String],
    Point: List[String],
    Unit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AceTariffType.fields (position), x))
        emitelem (0, `type`)
        emitattrs (1, MarketDocument)
        emitattrs (2, Point)
        emitattrs (3, Unit)
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
    override val fields: Array[String] = Array[String] (
        "type",
        "MarketDocument",
        "Point",
        "Unit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..*", "0..*"),
        Relationship ("Unit", "Unit_", "0..*", "0..*")
    )
    val `type`: Fielder = parse_element (element (cls, fields(0)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Unit: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): AceTariffType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AceTariffType (
            BasicElement.parse (context),
            mask (`type` (), 0),
            masks (MarketDocument (), 1),
            masks (Point (), 2),
            masks (Unit (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A class used to provide information about an attribute.
 *
 * @param sup Reference to the superclass object.
 * @param attribute The identification of the formal name of an attribute.
 * @param attributeValue The instance value of the attribute.
 * @param position A sequential value representing a relative sequence number.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
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
    MarketDocument: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, 0, List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (AttributeInstanceComponent.fields (position), x))
        emitelem (0, attribute)
        emitelem (1, attributeValue)
        emitelem (2, position)
        emitattrs (3, MarketDocument)
        emitattrs (4, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "attribute",
        "attributeValue",
        "position",
        "MarketDocument",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val attribute: Fielder = parse_element (element (cls, fields(0)))
    val attributeValue: Fielder = parse_element (element (cls, fields(1)))
    val position: Fielder = parse_element (element (cls, fields(2)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): AttributeInstanceComponent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AttributeInstanceComponent (
            BasicElement.parse (context),
            mask (attribute (), 0),
            mask (attributeValue (), 1),
            toInteger (mask (position (), 2)),
            masks (MarketDocument (), 3),
            masks (TimeSeries (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @param type The kind of the Auction (e.g. implicit, explicit ...).
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
    `type`: String,
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Auction.fields (position), x))
        emitelem (0, allocationMode)
        emitelem (1, cancelled)
        emitelem (2, category)
        emitelem (3, paymentTerms)
        emitelem (4, rights)
        emitelem (5, `type`)
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
    override val fields: Array[String] = Array[String] (
        "allocationMode",
        "cancelled",
        "category",
        "paymentTerms",
        "rights",
        "type",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val allocationMode: Fielder = parse_element (element (cls, fields(0)))
    val cancelled: Fielder = parse_element (element (cls, fields(1)))
    val category: Fielder = parse_element (element (cls, fields(2)))
    val paymentTerms: Fielder = parse_element (element (cls, fields(3)))
    val rights: Fielder = parse_element (element (cls, fields(4)))
    val `type`: Fielder = parse_element (element (cls, fields(5)))
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
            mask (`type` (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The formal specification of specific characteristics related to a bid.
 *
 * @param sup [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
 * @param blockBid Indication that  the values in the period are considered as a whole.
 *        They cannot be changed or subdivided.
 * @param direction The coded identification of the energy flow.
 * @param divisible An indication whether or not each element of the bid may be partially accepted or not.
 * @param exclusiveBidsIdentification Unique identification associated with all linked tenders.
 *        The identification of a set of tenders that are linked together signifying that only one can be accepted.
 *        This identification is defined by the tenderer and must be unique for a given auction.
 * @param linkedBidsIdentification Unique identification associated with all linked bids.
 * @param minimumActivationQuantity The minimum quantity of energy that can be activated at a given time interval.
 * @param priority The numeric local priority given to a bid.
 *        Lower numeric values will have higher priority.
 * @param status The information about the status of the bid, such as "shared", "restricted", ...
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
    exclusiveBidsIdentification: String,
    linkedBidsIdentification: String,
    minimumActivationQuantity: Double,
    priority: Int,
    status: String,
    stepIncrementQuantity: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, 0.0, 0, null, 0.0) }
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
        emitelem (3, exclusiveBidsIdentification)
        emitelem (4, linkedBidsIdentification)
        emitelem (5, minimumActivationQuantity)
        emitelem (6, priority)
        emitelem (7, status)
        emitelem (8, stepIncrementQuantity)
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
    override val fields: Array[String] = Array[String] (
        "blockBid",
        "direction",
        "divisible",
        "exclusiveBidsIdentification",
        "linkedBidsIdentification",
        "minimumActivationQuantity",
        "priority",
        "status",
        "stepIncrementQuantity"
    )
    val blockBid: Fielder = parse_element (element (cls, fields(0)))
    val direction: Fielder = parse_element (element (cls, fields(1)))
    val divisible: Fielder = parse_element (element (cls, fields(2)))
    val exclusiveBidsIdentification: Fielder = parse_element (element (cls, fields(3)))
    val linkedBidsIdentification: Fielder = parse_element (element (cls, fields(4)))
    val minimumActivationQuantity: Fielder = parse_element (element (cls, fields(5)))
    val priority: Fielder = parse_element (element (cls, fields(6)))
    val status: Fielder = parse_element (element (cls, fields(7)))
    val stepIncrementQuantity: Fielder = parse_element (element (cls, fields(8)))

    def parse (context: Context): BidTimeSeries =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BidTimeSeries (
            TimeSeries.parse (context),
            mask (blockBid (), 0),
            mask (direction (), 1),
            mask (divisible (), 2),
            mask (exclusiveBidsIdentification (), 3),
            mask (linkedBidsIdentification (), 4),
            toDouble (mask (minimumActivationQuantity (), 5)),
            toInteger (mask (priority (), 6)),
            mask (status (), 7),
            toDouble (mask (stepIncrementQuantity (), 8))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Duration constraint to activate, to put in operation, to deactivate, ... a given event.
 *
 * @param sup Reference to the superclass object.
 * @param duration The duration of the constraint.
 * @param type The type of the constraint.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class ConstraintDuration
(
    override val sup: BasicElement,
    duration: String,
    `type`: String,
    TimeSeries: List[String]
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
    override def copy (): Row = { clone ().asInstanceOf[ConstraintDuration] }
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
        implicit val clz: String = ConstraintDuration.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConstraintDuration.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ConstraintDuration.fields (position), x))
        emitelem (0, duration)
        emitelem (1, `type`)
        emitattrs (2, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConstraintDuration rdf:ID=\"%s\">\n%s\t</cim:ConstraintDuration>".format (id, export_fields)
    }
}

object ConstraintDuration
extends
    Parseable[ConstraintDuration]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "type",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val `type`: Fielder = parse_element (element (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): ConstraintDuration =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConstraintDuration (
            BasicElement.parse (context),
            mask (duration (), 0),
            mask (`type` (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The date and/or the time.
 *
 * @param sup Reference to the superclass object.
 * @param date Date as "yyyy-mm-dd", which conforms with ISO 8601
 * @param time Time as "hh:mm:ss.sssZ", which conforms with ISO 8601.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class DateAndOrTime
(
    override val sup: BasicElement,
    date: String,
    time: String,
    MarketDocument: List[String],
    TimeSeries: List[String]
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (DateAndOrTime.fields (position), x))
        emitelem (0, date)
        emitelem (1, time)
        emitattrs (2, MarketDocument)
        emitattrs (3, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "date",
        "time",
        "MarketDocument",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val time: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): DateAndOrTime =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DateAndOrTime (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (time (), 1),
            masks (MarketDocument (), 2),
            masks (TimeSeries (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An area of activity defined within the energy market.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Price [[ch.ninecode.model.Price Price]] <em>undocumented</em>
 * @param Quantity [[ch.ninecode.model.Quantity Quantity]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Domain
(
    override val sup: IdentifiedObject,
    MarketDocument: List[String],
    Price: List[String],
    Quantity: List[String],
    RegisteredResource: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Domain.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Domain.fields (position), x))
        emitattrs (0, MarketDocument)
        emitattrs (1, Price)
        emitattrs (2, Quantity)
        emitattrs (3, RegisteredResource)
        emitattrs (4, TimeSeries)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "MarketDocument",
        "Price",
        "Quantity",
        "RegisteredResource",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("Price", "Price", "0..*", "0..*"),
        Relationship ("Quantity", "Quantity", "0..*", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val Price: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): Domain =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Domain (
            IdentifiedObject.parse (context),
            masks (MarketDocument (), 0),
            masks (Price (), 1),
            masks (Quantity (), 2),
            masks (RegisteredResource (), 3),
            masks (TimeSeries (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The coded identification of the direction of energy flow.
 *
 * @param sup Reference to the superclass object.
 * @param direction The coded identification of the direction of energy flow.
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class FlowDirection
(
    override val sup: BasicElement,
    direction: String,
    Point: List[String],
    TimeSeries: List[String]
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (FlowDirection.fields (position), x))
        emitelem (0, direction)
        emitattrs (1, Point)
        emitattrs (2, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "direction",
        "Point",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Point", "Point", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val direction: Fielder = parse_element (element (cls, fields(0)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): FlowDirection =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = FlowDirection (
            BasicElement.parse (context),
            mask (direction (), 0),
            masks (Point (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
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
}

/**
 * Electronic document containing the information necessary to satisfy a given business process set of requirements.
 *
 * @param sup [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param AttributeInstanceComponent [[ch.ninecode.model.AttributeInstanceComponent AttributeInstanceComponent]] <em>undocumented</em>
 * @param DateAndOrTime [[ch.ninecode.model.DateAndOrTime DateAndOrTime]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Process [[ch.ninecode.model.Process Process]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @param SelfMarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketDocument
(
    override val sup: Document,
    AceTariffType: List[String],
    AttributeInstanceComponent: List[String],
    DateAndOrTime: List[String],
    Domain: List[String],
    MarketDocument_attr: List[String],
    MarketParticipant: List[String],
    Period: List[String],
    Process: List[String],
    Reason: List[String],
    SelfMarketDocument: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketDocument.fields (position), x))
        emitattrs (0, AceTariffType)
        emitattrs (1, AttributeInstanceComponent)
        emitattrs (2, DateAndOrTime)
        emitattrs (3, Domain)
        emitattrs (4, MarketDocument_attr)
        emitattrs (5, MarketParticipant)
        emitattrs (6, Period)
        emitattrs (7, Process)
        emitattrs (8, Reason)
        emitattrs (9, SelfMarketDocument)
        emitattrs (10, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "AceTariffType",
        "AttributeInstanceComponent",
        "DateAndOrTime",
        "Domain",
        "MarketDocument",
        "MarketParticipant",
        "Period",
        "Process",
        "Reason",
        "SelfMarketDocument",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        Relationship ("AttributeInstanceComponent", "AttributeInstanceComponent", "0..*", "0..*"),
        Relationship ("DateAndOrTime", "DateAndOrTime", "0..*", "0..*"),
        Relationship ("Domain", "Domain", "0..*", "0..*"),
        Relationship ("MarketDocument_attr", "MarketDocument", "0..*", "0..*"),
        Relationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        Relationship ("Period", "Period", "0..*", "0..*"),
        Relationship ("Process", "Process", "0..*", "0..*"),
        Relationship ("Reason", "Reason", "0..*", "0..*"),
        Relationship ("SelfMarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val AceTariffType: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val AttributeInstanceComponent: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val DateAndOrTime: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val MarketDocument_attr: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val Process: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val SelfMarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

    def parse (context: Context): MarketDocument =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketDocument (
            Document.parse (context),
            masks (AceTariffType (), 0),
            masks (AttributeInstanceComponent (), 1),
            masks (DateAndOrTime (), 2),
            masks (Domain (), 3),
            masks (MarketDocument_attr (), 4),
            masks (MarketParticipant (), 5),
            masks (Period (), 6),
            masks (Process (), 7),
            masks (Reason (), 8),
            masks (SelfMarketDocument (), 9),
            masks (TimeSeries (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The identification of an entity where energy products are measured or computed.
 *
 * @param sup [[ch.ninecode.model.UsagePoint UsagePoint]] Reference to the superclass object.
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketEvaluationPoint
(
    override val sup: UsagePoint,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def UsagePoint: UsagePoint = sup.asInstanceOf[UsagePoint]
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketEvaluationPoint.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketEvaluationPoint.fields (position), x))
        emitattrs (0, TimeSeries)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): MarketEvaluationPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketEvaluationPoint (
            UsagePoint.parse (context),
            masks (TimeSeries (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The condition or position of an object with regard to its standing.
 *
 * @param sup Reference to the superclass object.
 * @param status The coded condition or position of an object with regard to its standing.
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class MarketObjectStatus
(
    override val sup: BasicElement,
    status: String,
    RegisteredResource: List[String],
    TimeSeries: List[String]
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MarketObjectStatus.fields (position), x))
        emitelem (0, status)
        emitattrs (1, RegisteredResource)
        emitattrs (2, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "status",
        "RegisteredResource",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val status: Fielder = parse_element (element (cls, fields(0)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): MarketObjectStatus =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = MarketObjectStatus (
            BasicElement.parse (context),
            mask (status (), 0),
            masks (RegisteredResource (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (MktPSRType.fields (position), x))
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
    override val fields: Array[String] = Array[String] (
        "psrType",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
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
}

/**
 * An identification of a time interval that may have a given resolution.
 *
 * @param sup Reference to the superclass object.
 * @param resolution The number of units of time that compose an individual step within a period.
 * @param timeInterval The start and end date and time for a given interval.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Period
(
    override val sup: BasicElement,
    resolution: String,
    timeInterval: String,
    MarketDocument: List[String],
    Point: List[String],
    Reason: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Period.fields (position), x))
        emitelem (0, resolution)
        emitattr (1, timeInterval)
        emitattrs (2, MarketDocument)
        emitattrs (3, Point)
        emitattrs (4, Reason)
        emitattrs (5, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "resolution",
        "timeInterval",
        "MarketDocument",
        "Point",
        "Reason",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..*", "1"),
        Relationship ("Reason", "Reason", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val resolution: Fielder = parse_element (element (cls, fields(0)))
    val timeInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): Period =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Period (
            BasicElement.parse (context),
            mask (resolution (), 0),
            mask (timeInterval (), 1),
            masks (MarketDocument (), 2),
            masks (Point (), 3),
            masks (Reason (), 4),
            masks (TimeSeries (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @param FlowDirection [[ch.ninecode.model.FlowDirection FlowDirection]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Price [[ch.ninecode.model.Price Price]] <em>undocumented</em>
 * @param Quantity [[ch.ninecode.model.Quantity Quantity]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
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
    FlowDirection: List[String],
    Period: String,
    Price: List[String],
    Quantity: List[String],
    Reason: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, null, 0.0, 0.0, List(), List(), null, List(), List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Point.fields (position), x))
        emitelem (0, position)
        emitelem (1, quality)
        emitelem (2, quantity)
        emitelem (3, secondaryQuantity)
        emitattrs (4, AceTariffType)
        emitattrs (5, FlowDirection)
        emitattr (6, Period)
        emitattrs (7, Price)
        emitattrs (8, Quantity)
        emitattrs (9, Reason)
        emitattrs (10, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "position",
        "quality",
        "quantity",
        "secondaryQuantity",
        "AceTariffType",
        "FlowDirection",
        "Period",
        "Price",
        "Quantity",
        "Reason",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        Relationship ("FlowDirection", "FlowDirection", "0..*", "0..*"),
        Relationship ("Period", "Period", "1", "0..*"),
        Relationship ("Price", "Price", "0..*", "0..1"),
        Relationship ("Quantity", "Quantity", "0..*", "0..*"),
        Relationship ("Reason", "Reason", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val position: Fielder = parse_element (element (cls, fields(0)))
    val quality: Fielder = parse_element (element (cls, fields(1)))
    val quantity: Fielder = parse_element (element (cls, fields(2)))
    val secondaryQuantity: Fielder = parse_element (element (cls, fields(3)))
    val AceTariffType: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val FlowDirection: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Period: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Price: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(10)))

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
            masks (FlowDirection (), 5),
            mask (Period (), 6),
            masks (Price (), 7),
            masks (Quantity (), 8),
            masks (Reason (), 9),
            masks (TimeSeries (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The cost corresponding to a specific measure and expressed in a currency.
 *
 * @param sup Reference to the superclass object.
 * @param amount A number of monetary units specified in a unit of currency.
 * @param category The category of a price to be used in a price calculation.
 *        The price category is mutually agreed between System Operators.
 * @param direction The direction indicates whether a System Operator pays the Market Parties or inverse.
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
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
    Domain: List[String],
    Point: String,
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null, List(), null, List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Price.fields (position), x))
        emitelem (0, amount)
        emitelem (1, category)
        emitelem (2, direction)
        emitattrs (3, Domain)
        emitattr (4, Point)
        emitattrs (5, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "amount",
        "category",
        "direction",
        "Domain",
        "Point",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Domain", "Domain", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..1", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val amount: Fielder = parse_element (element (cls, fields(0)))
    val category: Fielder = parse_element (element (cls, fields(1)))
    val direction: Fielder = parse_element (element (cls, fields(2)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Point: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): Price =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Price (
            BasicElement.parse (context),
            toDouble (mask (amount (), 0)),
            mask (category (), 1),
            mask (direction (), 2),
            masks (Domain (), 3),
            mask (Point (), 4),
            masks (TimeSeries (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Process.fields (position), x))
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
    override val fields: Array[String] = Array[String] (
        "classificationType",
        "processType",
        "MarketDocument"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*")
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
}

/**
 * Description of quantities needed in the data exchange.
 *
 * The type of the quantity is described either by the role of the association or the type attribute.
 * The quality attribute provides the information about the quality of the quantity (measured, estimated, etc.).
 *
 * @param sup Reference to the superclass object.
 * @param quality The quality of the information being provided.
 *        This quality may be estimated, not available, as provided, etc.
 * @param quantity The quantity value.
 *        The association role provides the information about what is expressed.
 * @param type The description of the type of the quantity.
 * @param Detail_Quantity [[ch.ninecode.model.Quantity Quantity]] Additional information related to the associated quantity.
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Quantity
(
    override val sup: BasicElement,
    quality: String,
    quantity: Double,
    `type`: String,
    Detail_Quantity: List[String],
    Domain: List[String],
    Point: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, List(), List(), List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[Quantity] }
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
        implicit val clz: String = Quantity.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Quantity.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Quantity.fields (position), x))
        emitelem (0, quality)
        emitelem (1, quantity)
        emitelem (2, `type`)
        emitattrs (3, Detail_Quantity)
        emitattrs (4, Domain)
        emitattrs (5, Point)
        emitattrs (6, TimeSeries)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Quantity rdf:ID=\"%s\">\n%s\t</cim:Quantity>".format (id, export_fields)
    }
}

object Quantity
extends
    Parseable[Quantity]
{
    override val fields: Array[String] = Array[String] (
        "quality",
        "quantity",
        "type",
        "Detail_Quantity",
        "Domain",
        "Point",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Detail_Quantity", "Quantity", "0..*", "0..1"),
        Relationship ("Domain", "Domain", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val quality: Fielder = parse_element (element (cls, fields(0)))
    val quantity: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))
    val Detail_Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Quantity =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Quantity (
            BasicElement.parse (context),
            mask (quality (), 0),
            toDouble (mask (quantity (), 1)),
            mask (`type` (), 2),
            masks (Detail_Quantity (), 3),
            masks (Domain (), 4),
            masks (Point (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The motivation of an act.
 *
 * @param sup Reference to the superclass object.
 * @param code The motivation of an act in coded form.
 * @param text The textual explanation corresponding to the reason code.
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
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
    Period: List[String],
    Point: List[String],
    RegisteredResource: List[String],
    TimeSeries: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, List(), List(), List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Reason.fields (position), x))
        emitelem (0, code)
        emitelem (1, text)
        emitattrs (2, MarketDocument)
        emitattrs (3, Period)
        emitattrs (4, Point)
        emitattrs (5, RegisteredResource)
        emitattrs (6, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "code",
        "text",
        "MarketDocument",
        "Period",
        "Point",
        "RegisteredResource",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("Period", "Period", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..*", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val code: Fielder = parse_element (element (cls, fields(0)))
    val text: Fielder = parse_element (element (cls, fields(1)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): Reason =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Reason (
            BasicElement.parse (context),
            mask (code (), 0),
            mask (text (), 1),
            masks (MarketDocument (), 2),
            masks (Period (), 3),
            masks (Point (), 4),
            masks (RegisteredResource (), 5),
            masks (TimeSeries (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A set of similar physical or conceptual objects defined for the same period or point of time.
 *
 * @param sup [[ch.ninecode.model.TimeSeries TimeSeries]] Reference to the superclass object.
 * @param lastUpdateDate The date of the last update related to this market object.
 * @param methodType Type of method used in the business process related to this Series, e.g. metering method.
 * @param registrationDate For a market object, the date of registration of a contract, e.g. the date of change of supplier for a customer.
 * @param SelfSeries [[ch.ninecode.model.Series Series]] <em>undocumented</em>
 * @param Series [[ch.ninecode.model.Series Series]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Series
(
    override val sup: TimeSeries,
    lastUpdateDate: String,
    methodType: String,
    registrationDate: String,
    SelfSeries: List[String],
    Series_attr: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TimeSeries: TimeSeries = sup.asInstanceOf[TimeSeries]
    override def copy (): Row = { clone ().asInstanceOf[Series] }
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
        implicit val clz: String = Series.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Series.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Series.fields (position), x))
        emitelem (0, lastUpdateDate)
        emitelem (1, methodType)
        emitelem (2, registrationDate)
        emitattrs (3, SelfSeries)
        emitattrs (4, Series_attr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Series rdf:ID=\"%s\">\n%s\t</cim:Series>".format (id, export_fields)
    }
}

object Series
extends
    Parseable[Series]
{
    override val fields: Array[String] = Array[String] (
        "lastUpdateDate",
        "methodType",
        "registrationDate",
        "SelfSeries",
        "Series"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SelfSeries", "Series", "0..*", "0..*"),
        Relationship ("Series_attr", "Series", "0..*", "0..*")
    )
    val lastUpdateDate: Fielder = parse_element (element (cls, fields(0)))
    val methodType: Fielder = parse_element (element (cls, fields(1)))
    val registrationDate: Fielder = parse_element (element (cls, fields(2)))
    val SelfSeries: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val Series_attr: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: Context): Series =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Series (
            TimeSeries.parse (context),
            mask (lastUpdateDate (), 0),
            mask (methodType (), 1),
            mask (registrationDate (), 2),
            masks (SelfSeries (), 3),
            masks (Series_attr (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A set of regular time-ordered measurements or values of quantitative nature of an individual or collective phenomenon taken at successive, in most cases equidistant, periods / points of time.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param businessType The identification of the nature of the time series.
 * @param cancelledTS An indicator stating that the TimeSeries, identified by the mRID, is cancelled as well as all the values sent in a previous version of the TimeSeries in a previous document.
 * @param curveType The coded representation of the type of curve being described.
 * @param objectAggregation Identification of the object that is the common denominator used to aggregate a time series.
 * @param product The type of the product such as Power, energy, reactive power, transport capacity that is the subject of the time series.
 * @param version Version of the time series.
 * @param AttributeInstanceComponent [[ch.ninecode.model.AttributeInstanceComponent AttributeInstanceComponent]] <em>undocumented</em>
 * @param Auction [[ch.ninecode.model.Auction Auction]] <em>undocumented</em>
 * @param ConstraintDuration [[ch.ninecode.model.ConstraintDuration ConstraintDuration]] <em>undocumented</em>
 * @param DateAndOrTime [[ch.ninecode.model.DateAndOrTime DateAndOrTime]] <em>undocumented</em>
 * @param Domain [[ch.ninecode.model.Domain Domain]] <em>undocumented</em>
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] <em>undocumented</em>
 * @param FlowDirection [[ch.ninecode.model.FlowDirection FlowDirection]] <em>undocumented</em>
 * @param MarketDocument [[ch.ninecode.model.MarketDocument MarketDocument]] <em>undocumented</em>
 * @param MarketEvaluationPoint [[ch.ninecode.model.MarketEvaluationPoint MarketEvaluationPoint]] <em>undocumented</em>
 * @param MarketObjectStatus [[ch.ninecode.model.MarketObjectStatus MarketObjectStatus]] <em>undocumented</em>
 * @param MarketParticipant [[ch.ninecode.model.MarketParticipant MarketParticipant]] <em>undocumented</em>
 * @param MktPSRType [[ch.ninecode.model.MktPSRType MktPSRType]] <em>undocumented</em>
 * @param Period [[ch.ninecode.model.Period Period]] <em>undocumented</em>
 * @param Point [[ch.ninecode.model.Point Point]] <em>undocumented</em>
 * @param Price [[ch.ninecode.model.Price Price]] <em>undocumented</em>
 * @param Quantity [[ch.ninecode.model.Quantity Quantity]] <em>undocumented</em>
 * @param Reason [[ch.ninecode.model.Reason Reason]] <em>undocumented</em>
 * @param RegisteredResource [[ch.ninecode.model.RegisteredResource RegisteredResource]] <em>undocumented</em>
 * @param Unit [[ch.ninecode.model.Unit_ Unit_]] <em>undocumented</em>
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
    AttributeInstanceComponent: List[String],
    Auction: List[String],
    ConstraintDuration: List[String],
    DateAndOrTime: List[String],
    Domain: List[String],
    EnvironmentalMonitoringStation: List[String],
    FlowDirection: List[String],
    MarketDocument: List[String],
    MarketEvaluationPoint: List[String],
    MarketObjectStatus: List[String],
    MarketParticipant: List[String],
    MktPSRType: List[String],
    Period: List[String],
    Point: List[String],
    Price: List[String],
    Quantity: List[String],
    Reason: List[String],
    RegisteredResource: List[String],
    Unit: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List(), List()) }
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (TimeSeries.fields (position), x))
        emitelem (0, businessType)
        emitelem (1, cancelledTS)
        emitelem (2, curveType)
        emitelem (3, objectAggregation)
        emitelem (4, product)
        emitelem (5, version)
        emitattrs (6, AttributeInstanceComponent)
        emitattrs (7, Auction)
        emitattrs (8, ConstraintDuration)
        emitattrs (9, DateAndOrTime)
        emitattrs (10, Domain)
        emitattrs (11, EnvironmentalMonitoringStation)
        emitattrs (12, FlowDirection)
        emitattrs (13, MarketDocument)
        emitattrs (14, MarketEvaluationPoint)
        emitattrs (15, MarketObjectStatus)
        emitattrs (16, MarketParticipant)
        emitattrs (17, MktPSRType)
        emitattrs (18, Period)
        emitattrs (19, Point)
        emitattrs (20, Price)
        emitattrs (21, Quantity)
        emitattrs (22, Reason)
        emitattrs (23, RegisteredResource)
        emitattrs (24, Unit)
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
    override val fields: Array[String] = Array[String] (
        "businessType",
        "cancelledTS",
        "curveType",
        "objectAggregation",
        "product",
        "version",
        "AttributeInstanceComponent",
        "Auction",
        "ConstraintDuration",
        "DateAndOrTime",
        "Domain",
        "EnvironmentalMonitoringStation",
        "FlowDirection",
        "MarketDocument",
        "MarketEvaluationPoint",
        "MarketObjectStatus",
        "MarketParticipant",
        "MktPSRType",
        "Period",
        "Point",
        "Price",
        "Quantity",
        "Reason",
        "RegisteredResource",
        "Unit"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AttributeInstanceComponent", "AttributeInstanceComponent", "0..*", "0..*"),
        Relationship ("Auction", "Auction", "0..*", "0..*"),
        Relationship ("ConstraintDuration", "ConstraintDuration", "0..*", "0..*"),
        Relationship ("DateAndOrTime", "DateAndOrTime", "0..*", "0..*"),
        Relationship ("Domain", "Domain", "0..*", "0..*"),
        Relationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..*", "0..*"),
        Relationship ("FlowDirection", "FlowDirection", "0..*", "0..*"),
        Relationship ("MarketDocument", "MarketDocument", "0..*", "0..*"),
        Relationship ("MarketEvaluationPoint", "MarketEvaluationPoint", "0..*", "0..*"),
        Relationship ("MarketObjectStatus", "MarketObjectStatus", "0..*", "0..*"),
        Relationship ("MarketParticipant", "MarketParticipant", "0..*", "0..*"),
        Relationship ("MktPSRType", "MktPSRType", "0..*", "0..*"),
        Relationship ("Period", "Period", "0..*", "0..*"),
        Relationship ("Point", "Point", "0..*", "0..*"),
        Relationship ("Price", "Price", "0..*", "0..*"),
        Relationship ("Quantity", "Quantity", "0..*", "0..*"),
        Relationship ("Reason", "Reason", "0..*", "0..*"),
        Relationship ("RegisteredResource", "RegisteredResource", "0..*", "0..*"),
        Relationship ("Unit", "Unit_", "0..*", "0..*")
    )
    val businessType: Fielder = parse_element (element (cls, fields(0)))
    val cancelledTS: Fielder = parse_element (element (cls, fields(1)))
    val curveType: Fielder = parse_element (element (cls, fields(2)))
    val objectAggregation: Fielder = parse_element (element (cls, fields(3)))
    val product: Fielder = parse_element (element (cls, fields(4)))
    val version: Fielder = parse_element (element (cls, fields(5)))
    val AttributeInstanceComponent: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val Auction: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ConstraintDuration: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val DateAndOrTime: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val Domain: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val EnvironmentalMonitoringStation: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val FlowDirection: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val MarketDocument: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val MarketEvaluationPoint: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val MarketObjectStatus: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val MarketParticipant: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val MktPSRType: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val Period: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val Point: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val Price: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val Quantity: FielderMultiple = parse_attributes (attribute (cls, fields(21)))
    val Reason: FielderMultiple = parse_attributes (attribute (cls, fields(22)))
    val RegisteredResource: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val Unit: FielderMultiple = parse_attributes (attribute (cls, fields(24)))

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
            masks (AttributeInstanceComponent (), 6),
            masks (Auction (), 7),
            masks (ConstraintDuration (), 8),
            masks (DateAndOrTime (), 9),
            masks (Domain (), 10),
            masks (EnvironmentalMonitoringStation (), 11),
            masks (FlowDirection (), 12),
            masks (MarketDocument (), 13),
            masks (MarketEvaluationPoint (), 14),
            masks (MarketObjectStatus (), 15),
            masks (MarketParticipant (), 16),
            masks (MktPSRType (), 17),
            masks (Period (), 18),
            masks (Point (), 19),
            masks (Price (), 20),
            masks (Quantity (), 21),
            masks (Reason (), 22),
            masks (RegisteredResource (), 23),
            masks (Unit (), 24)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The identification of the unit name for the time series quantities.
 *
 * @param sup Reference to the superclass object.
 * @param name The coded representation of the unit.
 * @param AceTariffType [[ch.ninecode.model.AceTariffType AceTariffType]] <em>undocumented</em>
 * @param TimeSeries [[ch.ninecode.model.TimeSeries TimeSeries]] <em>undocumented</em>
 * @group MarketManagement
 * @groupname MarketManagement Package MarketManagement
 * @groupdesc MarketManagement This package contains all core CIM Market Extensions required for market management systems.
 */
case class Unit_
(
    override val sup: BasicElement,
    name: String,
    AceTariffType: List[String],
    TimeSeries: List[String]
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
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Unit_.fields (position), x))
        emitelem (0, name)
        emitattrs (1, AceTariffType)
        emitattrs (2, TimeSeries)
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
    override val fields: Array[String] = Array[String] (
        "name",
        "AceTariffType",
        "TimeSeries"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AceTariffType", "AceTariffType", "0..*", "0..*"),
        Relationship ("TimeSeries", "TimeSeries", "0..*", "0..*")
    )
    val name: Fielder = parse_element (element (cls, fields(0)))
    val AceTariffType: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TimeSeries: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): Unit_ =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Unit_ (
            BasicElement.parse (context),
            mask (name (), 0),
            masks (AceTariffType (), 1),
            masks (TimeSeries (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
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
            ConstraintDuration.register,
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
            Quantity.register,
            Reason.register,
            Series.register,
            TimeSeries.register,
            Unit_.register
        )
    }
}